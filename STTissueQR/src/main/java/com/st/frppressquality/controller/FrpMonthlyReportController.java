/**
 *Jan 19, 2015
 *FrpDailyReportController.java
 * TODO
 *com.st.frppressquality.controller
 *FrpDailyReportController.java
 *Sunil Singh Bora
 */
package com.st.frppressquality.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import jakarta.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.st.common.CommonUtil;
import com.st.frppressquality.model.FrpDailyData;
import com.st.frppressquality.report.FrpPressQualityReportHandler;
import com.st.frppressquality.service.FrpPressQualityService;

/**
 * @author sbora
 *
 */
@Controller
@RequestMapping("/frpmonthlyreport")
public class FrpMonthlyReportController {
	
	@Autowired
	private FrpPressQualityService frpPressQualityService;
	
	@Autowired
	private FrpPressQualityReportHandler frpPressQualityReportHandler;
	
	private SimpleDateFormat dateFormat=new SimpleDateFormat("MM-dd-yyyy");
	
	@RequestMapping("/view")
	public String view(Model model) {
		
		model.addAttribute("sdate", dateFormat.format(CommonUtil.getFirstDate(new Date())));
		model.addAttribute("edate", dateFormat.format(new Date()));
		model.addAttribute("showFlag", false);
		
		return "frp/frpMonthlyReportView";
	}
	
	
	@RequestMapping(value="/view/data",method=RequestMethod.GET)
	public String viewData(@RequestParam("sdate")String sdate,
			@RequestParam("edate")String edate,
			Model model) {
		
		model.addAttribute("sdate", sdate);
		model.addAttribute("edate", edate);
		model.addAttribute("showFlag", true);
		
		List<FrpDailyData> dailyDatas=frpPressQualityService.getMonthlyReportData(CommonUtil.checkDate(sdate, dateFormat),CommonUtil.checkDate(edate, dateFormat));
		
		model.addAttribute("dailyDatas", dailyDatas);
		
		
		return "frp/frpMonthlyReportView";
	}
	
	@RequestMapping(value="/export",method=RequestMethod.POST)
	public void export(@RequestParam("sdate")String sdate,
			@RequestParam("edate")String edate,
			HttpServletResponse response) throws IOException, Exception {
		
		
		List<FrpDailyData> dailyDatas=frpPressQualityService.getMonthlyReportData(CommonUtil.checkDate(sdate, dateFormat),CommonUtil.checkDate(edate, dateFormat));
		
		response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
		response.setHeader("Content-Disposition", "attachment; filename=FRP_Daily_Report.xlsx");
		
		frpPressQualityReportHandler.createFrpMonthlyReport(dailyDatas,response.getOutputStream());
	}
	
}

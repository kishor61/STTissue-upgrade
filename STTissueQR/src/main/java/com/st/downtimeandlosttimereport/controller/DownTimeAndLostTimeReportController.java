/**
 *Sep 12, 2017
 *DownTimeAndLostTimeReportController.java
 * TODO
 *com.st.downtimeandlosttimereport.controller
 *DownTimeAndLostTimeReportController.java
 *Roshan Lal Tailor
 */
package com.st.downtimeandlosttimereport.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.st.common.CommonUtil;
import com.st.downtimeandlosttimereport.handler.DownTimeAndLostTimeReportHandler;
import com.st.downtimeandlosttimereport.model.DownTimeAndLostTimeReport;
import com.st.downtimeandlosttimereport.service.DownTimeAndLostTimeReportService;

/**
 * @author roshan
 *
 */
@Controller
@RequestMapping("/downtimeandlosttime")
public class DownTimeAndLostTimeReportController {

	private SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
	
	@Autowired
	private DownTimeAndLostTimeReportService DownTimeAndLostTimeReportService;
	
	@Autowired
	private ServletContext context;
	
	@Autowired
	private DownTimeAndLostTimeReportHandler DownTimeAndLostTimeReportHandler;

	@RequestMapping("/report")
	public String mainPage(Model model) {
		model.addAttribute("sdate", dateFormat.format(CommonUtil.getFirstDate(new Date())));
		model.addAttribute("edate", dateFormat.format(new Date()));
		model.addAttribute("show", false);
		model.addAttribute("export", false);
		return "downTimeAndLostTimeReport";
	}
	
	@RequestMapping("/report/show")
	public String reportShowPage(@RequestParam("sdate")String sdate,@RequestParam("edate")String edate,Model model) {
		
		Date SDate=CommonUtil.checkDate(sdate, dateFormat);
		Date EDate=CommonUtil.checkDate(edate, dateFormat);
		
		List<DownTimeAndLostTimeReport> secondaryCode= DownTimeAndLostTimeReportService.getsecondaryCode();
		List<DownTimeAndLostTimeReport> data= DownTimeAndLostTimeReportService.getDataDateWise(SDate,EDate);
		model.addAttribute("sdate", sdate);
		model.addAttribute("edate", edate);
		
		model.addAttribute("secondaryCode", secondaryCode);
		model.addAttribute("data", data);
		model.addAttribute("show", true);
		model.addAttribute("export", true);
		return "downTimeAndLostTimeReport";
	}
	@RequestMapping(value="/report/show/export",method=RequestMethod.GET)
	public void export(@RequestParam("sdate")String sdate,@RequestParam("edate")String edate,HttpServletResponse response) throws Exception{

		
		Date sDate=CommonUtil.checkDate(sdate, dateFormat);
		Date eDate=CommonUtil.checkDate(edate, dateFormat);
		
		List<DownTimeAndLostTimeReport> data= DownTimeAndLostTimeReportService.getDataDateWise(sDate,eDate);
		
		response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
		response.setHeader("Content-Disposition", "attachment; filename=DownTime And Lost Time Report.xlsx");
		File file=new File(context.getRealPath("/")+"WEB-INF/DownTime And Lost Time Report.xlsx");
		
		DownTimeAndLostTimeReportHandler.exportExcelReport(data,file,response.getOutputStream());
		
	}
}

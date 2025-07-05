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
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import jakarta.servlet.http.HttpServletRequest;
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
import com.st.frpproduction.model.FrpProdcutionOperatorDataEntry;
import com.st.frpproduction.report.FrpProdcutionReportAutoMailer;
import com.st.frpproduction.service.FrpProdcutionOperatorDataEntryService;

/**
 * @author sbora
 *
 */
@Controller
@RequestMapping("/frpdailyreport")
public class FrpDailyReportController {
	
	@Autowired
	private FrpPressQualityService frpPressQualityService;
	@Autowired
	private FrpProdcutionOperatorDataEntryService frpprodcutionoperatordataentryservice ;
	@Autowired
	private FrpPressQualityReportHandler frpPressQualityReportHandler;
	
	private SimpleDateFormat dateFormat=new SimpleDateFormat("MM-dd-yyyy");
	
	@RequestMapping("/view")
	public String view(Model model) {
		
		model.addAttribute("sdate", dateFormat.format(CommonUtil.getFirstDate(new Date())));
		model.addAttribute("edate", dateFormat.format(new Date()));
		model.addAttribute("showFlag", false);
		
		return "frp/frpDailyReportView";
	}
	
	
	@RequestMapping(value="/view/data",method=RequestMethod.GET)
	public String viewData(@RequestParam("sdate")String sdate,
			@RequestParam("edate")String edate,
			Model model) throws Exception {
		
		model.addAttribute("sdate", sdate);
		model.addAttribute("edate", edate);
		model.addAttribute("showFlag", true);
		Date dt1=new SimpleDateFormat("MM-dd-yyyy").parse(sdate);  
		Date dt2=new SimpleDateFormat("MM-dd-yyyy").parse(edate);  
		
		Calendar date1=Calendar.getInstance();
		date1.setTime(dt1);

		Calendar ecal=Calendar.getInstance();
		ecal.setTime(date1.getTime());
		ecal.set(Calendar.HOUR_OF_DAY, 0);
		ecal.set(Calendar.MINUTE, 0);
		ecal.set(Calendar.SECOND, 0);
		ecal.set(Calendar.MILLISECOND, 0);
		
		Calendar toCal=Calendar.getInstance();
		toCal.setTime(ecal.getTime());
		toCal.add(Calendar.DATE, 0);
		
		//For Last Date
		Calendar date=Calendar.getInstance();
		date.setTime(dt2);
		
		Calendar scal=Calendar.getInstance();
		scal.setTime(date.getTime());
		scal.set(Calendar.HOUR_OF_DAY, 0);
		scal.set(Calendar.MINUTE, 0);
		scal.set(Calendar.SECOND, 0);
		scal.set(Calendar.MILLISECOND, 0);
		
		Calendar frmCal=Calendar.getInstance();
		frmCal.setTime(scal.getTime());
		frmCal.add(Calendar.DATE, -1);
		//List<FrpDailyData> dailyDatas=frpPressQualityService.getDailyReportData(CommonUtil.checkDate(sdate, dateFormat),CommonUtil.checkDate(edate, dateFormat));
		
		List<FrpProdcutionOperatorDataEntry> details=frpprodcutionoperatordataentryservice.getFrpProducationDataEntryDetailedReport(toCal.getTime(),frmCal.getTime());
		
		List<FrpProdcutionOperatorDataEntry> Aavg = frpprodcutionoperatordataentryservice.getcol1avg(toCal.getTime(),frmCal.getTime());
		List<FrpProdcutionOperatorDataEntry> Bavg = frpprodcutionoperatordataentryservice.getcol1avg1(toCal.getTime(),frmCal.getTime());
		List<FrpProdcutionOperatorDataEntry> Cavg = frpprodcutionoperatordataentryservice.getcol1avg2(toCal.getTime(),frmCal.getTime());
		List<FrpProdcutionOperatorDataEntry> Davg = frpprodcutionoperatordataentryservice.getcol1avg3(toCal.getTime(),frmCal.getTime());
		
		model.addAttribute("dailyDatas", details);
		
		
		return "frp/frpDailyReportView";
	}
	
	@RequestMapping(value="/export",method=RequestMethod.POST)
	public void export(@RequestParam("sdate")String sdate,
			@RequestParam("edate")String edate,
			HttpServletResponse response) throws IOException, Exception {
		
		
		
		Date dt1=new SimpleDateFormat("MM-dd-yyyy").parse(sdate);  
		Date dt2=new SimpleDateFormat("MM-dd-yyyy").parse(edate);  
		
		Calendar date1=Calendar.getInstance();
		date1.setTime(dt1);

		Calendar ecal=Calendar.getInstance();
		ecal.setTime(date1.getTime());
		ecal.set(Calendar.HOUR_OF_DAY, 0);
		ecal.set(Calendar.MINUTE, 0);
		ecal.set(Calendar.SECOND, 0);
		ecal.set(Calendar.MILLISECOND, 0);
		
		Calendar toCal=Calendar.getInstance();
		toCal.setTime(ecal.getTime());
		toCal.add(Calendar.DATE, 0);
		
		//For Last Date
		Calendar date=Calendar.getInstance();
		date.setTime(dt2);
		
		Calendar scal=Calendar.getInstance();
		scal.setTime(date.getTime());
		scal.set(Calendar.HOUR_OF_DAY, 0);
		scal.set(Calendar.MINUTE, 0);
		scal.set(Calendar.SECOND, 0);
		scal.set(Calendar.MILLISECOND, 0);
		
		Calendar frmCal=Calendar.getInstance();
		frmCal.setTime(scal.getTime());
		frmCal.add(Calendar.DATE, -1);
		//List<FrpDailyData> dailyDatas=frpPressQualityService.getDailyReportData(CommonUtil.checkDate(sdate, dateFormat),CommonUtil.checkDate(edate, dateFormat));
		
		List<FrpProdcutionOperatorDataEntry> details=frpprodcutionoperatordataentryservice.getFrpProducationDataEntryDetailedReport(toCal.getTime(),frmCal.getTime());
		
		List<FrpProdcutionOperatorDataEntry> Aavg = frpprodcutionoperatordataentryservice.getcol1avg(toCal.getTime(),frmCal.getTime());
		List<FrpProdcutionOperatorDataEntry> Bavg = frpprodcutionoperatordataentryservice.getcol1avg1(toCal.getTime(),frmCal.getTime());
		List<FrpProdcutionOperatorDataEntry> Cavg = frpprodcutionoperatordataentryservice.getcol1avg2(toCal.getTime(),frmCal.getTime());
		List<FrpProdcutionOperatorDataEntry> Davg = frpprodcutionoperatordataentryservice.getcol1avg3(toCal.getTime(),frmCal.getTime());
		
		response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
		response.setHeader("Content-Disposition", "attachment; filename=FRP_Daily_Report.xlsx");
		
		frpPressQualityReportHandler.createFrpDailyReport(details,Aavg,Bavg,Cavg,Davg,response.getOutputStream());
	}
	
}

/**
 *06-Feb-2020
 *DailyInventryReport.java
 * TODO
 *com.st.wastepaper.controller
 *DailyInventryReport.java
 *Roshan Lal Tailor
 */
package com.st.wastepaper.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.st.common.CommonUtil;
import com.st.wastepaper.report.BarcodeInvetoryReportHandler;
import com.st.wastepaper.service.WastePaperBaleInventoryService;

/**
 * @author sohan
 *
 */
@Controller
@RequestMapping("/dailyinventryreport")
public class DailyInventryReport {
	
	@Autowired
	private ServletContext context;
	@Autowired
	private BarcodeInvetoryReportHandler barcodeInvetoryReportHandler;
	@Autowired
	private WastePaperBaleInventoryService wastePaperBaleInventoryService;
	private SimpleDateFormat dateFormat=new SimpleDateFormat("MM-dd-yyyy");
	@RequestMapping(value="/view",method=RequestMethod.GET)
	public String wastepaperDetailView(Model model) {		
		model.addAttribute("sdate", dateFormat.format(CommonUtil.getFirstDate(new Date())));
		model.addAttribute("edate", dateFormat.format(new Date()));
				
	  return "dailyinvreport";
	}
	
	@RequestMapping(value="/view/export",method=RequestMethod.POST)
	public void viewtranferabledata(@RequestParam("endDate")String edate,@RequestParam("position")String customer,HttpServletResponse response,
			HttpServletRequest request) throws IOException {
		response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
		response.setHeader("Content-Disposition",
				"attachment; filename=STT_DAILY_INVENTORY_REPORT.xlsx");
		File file = new File(context.getRealPath("/")
				+ "WEB-INF/STT_DAILY_INVENTORY_REPORT.xlsx");
		
		Date sDate=new Date();
		Date eDate=CommonUtil.checkDate(edate, dateFormat);
					
		Map<String,String> map=wastePaperBaleInventoryService.getDailyInventeryReport(customer,sDate,eDate);
		
		if(customer.equals("inDirect"))	
			customer="TREBOR INC";
		else
			customer=" DIRECT ";
		barcodeInvetoryReportHandler.getDailyInventeryReport(customer,map,file,response.getOutputStream());
		
	}
}

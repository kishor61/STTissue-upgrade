/**
 *Oct 26, 2015
 *WastePaperInBoundByDelivery.java
 * TODO
 *com.st.wastepaper.controller
 *WastePaperInBoundByDelivery.java
 *Sunil Singh Bora
 */
package com.st.wastepaper.controller;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
import com.st.wastepaper.comman.WastepaperComman;
import com.st.wastepaper.model.WastePaperBaleInventory;
import com.st.wastepaper.model.WastepaperDetail;
import com.st.wastepaper.report.WastepaperReportHandler;
import com.st.wastepaper.service.WastepaperService;
import com.st.wastepaper.report.*;

/**
 * @author roshan
 *
 */
@Controller
@RequestMapping("/wastepaperinboundbydelivery")
public class WastePaperInBoundByDeliveryController {

	private SimpleDateFormat dateFormat=new SimpleDateFormat("MM-dd-yyyy");
	
	@Autowired
	private ServletContext context;
	
	
	@Autowired
	private WastepaperService wastepaperService;
	
	@Autowired
	private WastepaperInBoundByDeliveryReportHandler wastepaperinboundbydeliveryreporthandler;
	
	@RequestMapping(value="/view",method=RequestMethod.GET)
	public String wastepaperDetailView(Model model) {
		
		model.addAttribute("sdate", dateFormat.format(CommonUtil.getFirstDate(new Date())));
		model.addAttribute("edate", dateFormat.format(new Date()));
		model.addAttribute("view", false);
		return "wastepaperReportInBoundByDelivery";
	}
	@RequestMapping(value="/view/data",method=RequestMethod.GET)
	public String wastepaperDetailView(@RequestParam("sdate")String sdate,@RequestParam("edate")String edate,Model model) throws ParseException {
		
		Date sDate=CommonUtil.checkDate(sdate, dateFormat);
		Date eDate=CommonUtil.checkDate(edate, dateFormat);
		List<WastepaperDetail> details=wastepaperService.getWastePaperInBoundByDeliveryData(sDate,eDate);
		//List<WastepaperDetail> details1=wastepaperService.getWastePaperInBoundByDeliveryData1(sDate,eDate);
		
		model.addAttribute("sdate", dateFormat.format(sDate));
		model.addAttribute("edate", dateFormat.format(eDate));
		model.addAttribute("details", details);
		model.addAttribute("view", true);
		return "wastepaperReportInBoundByDelivery";
	}
	@RequestMapping(value="/export",method=RequestMethod.POST)
	public void export(@RequestParam("sdate")String sdate,@RequestParam("edate")String edate,HttpServletResponse response) throws IOException, ParseException {
		
		Date sDate=CommonUtil.checkDate(sdate, dateFormat);
		Date eDate=CommonUtil.checkDate(edate, dateFormat);
		List<WastepaperDetail> details = null;
		details = wastepaperService.getWastePaperInBoundByDeliveryData(sDate,eDate);
		response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
		response.setHeader("Content-Disposition", "attachment; filename=WastePaper_In_Bound_By_Delivery_Report.xlsx");
		File file=new File(context.getRealPath("/")+"WEB-INF/WastePaper_In_Bound_By_Delivery_Report.xlsx");
		
		System.out.println("3");
		wastepaperinboundbydeliveryreporthandler.createwastepaperinboundbydeliveryreport(details,file,response.getOutputStream());
	}
	
}

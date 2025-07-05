/**
 *Jul 8, 2015
 *WastepaperConsumedBales.java
 * TODO
 *com.st.wastepaperconsumedbale.controller
 *WastepaperConsumedBales.java
 *Sunil Singh Bora
 */
package com.st.wastepaper.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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
import com.st.wastepaper.model.WastePaperBaleInventory;
import com.st.wastepaper.report.WastePaperUnloadBalesReportHandler;
import com.st.wastepaper.service.WastePaperBaleInventoryService;
import com.st.wastepaper.service.WastePaperUnloadBaleInventoryService;

/**
 * @author roshan
 *
 */
@Controller
@RequestMapping("/baleinventoryconsumed")
public class WastepaperConsumedBalesController {

	private static final String VIEW_PAGE="viewpage";
	private SimpleDateFormat dateFormat=new SimpleDateFormat("MM-dd-yyyy");
	
	@Autowired
	private ServletContext context;
	
	@Autowired
	private WastePaperBaleInventoryService wastePaperBaleInventoryService;
	
	@Autowired
	private WastePaperUnloadBalesReportHandler wastePaperUnloadBalesReportHandler;
	
	@Autowired
	private WastePaperUnloadBaleInventoryService  wastePaperUnloadBaleInventoryService;

	@RequestMapping("/consumedbales")
	public String consumedbales(HttpServletRequest request,HttpServletResponse response, Model model){
		model.addAttribute("startdate", dateFormat.format(new Date()));
		model.addAttribute("enddate", dateFormat.format(new Date()));
		return "wastepaperBaleInventoryConsumed";
	}
	@RequestMapping(value="/consumedbales/load",method=RequestMethod.GET)
	public String loadConsumedBales(HttpServletRequest request,HttpServletResponse response,Model model) throws Exception{
		Date startdate=CommonUtil.checkDate(request.getParameter("startdate"), dateFormat);
		Date enddate=CommonUtil.checkDate(request.getParameter("enddate"), dateFormat);
		
		List<WastePaperBaleInventory> consumedBalesData=wastePaperUnloadBaleInventoryService.getConsumedData(startdate,enddate);
		
		model.addAttribute("startdate", dateFormat.format(startdate));
		model.addAttribute("enddate", dateFormat.format(enddate));
		model.addAttribute(VIEW_PAGE, true);
		model.addAttribute("consumedBalesData", consumedBalesData);
		
		return "wastepaperBaleInventoryConsumed";
	}
	@RequestMapping(value="/export",method=RequestMethod.POST)
	public void export(@RequestParam("startdate")String sdate,
			@RequestParam("enddate")String edate,
			HttpServletResponse response) throws Exception{
		System.out.println("Exporting...");
		
		SimpleDateFormat df=new SimpleDateFormat("MM/dd/yyyy");
		Date startdate=CommonUtil.checkDate(sdate, dateFormat);
		Date enddate=CommonUtil.checkDate(edate, dateFormat);
		
		String flag="Consume";
		
		List<WastePaperBaleInventory> consumedBalesData=wastePaperUnloadBaleInventoryService.getConsumedData(startdate,enddate);
		
		response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
		response.setHeader("Content-Disposition", "attachment; filename=WastePaper_ConsumedBales_Report.xlsx");
		File file=new File(context.getRealPath("/")+"WEB-INF/WastePaper_ConsumedBales_Report.xlsx");
		
		wastePaperUnloadBalesReportHandler.getWPUnloadBalesReport(consumedBalesData,flag,file,response.getOutputStream());
		} 
}

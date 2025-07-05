/**
 *Jul 8, 2015
 *WastepaperUnloadBales.java
 * TODO
 *com.st.wastepaperunloadbale.controller
 *WastepaperUnloadBales.java
 *Sunil Singh Bora
 */
package com.st.wastepaper.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import jakarta.annotation.Resource;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.st.common.CommonUtil;
import com.st.frpyield.model.FrpYield;
import com.st.wastepaper.dao.WastePaperUnloadBaleDao;
import com.st.wastepaper.model.WastePaperBaleInventory;
import com.st.wastepaper.report.WastePaperUnloadBalesReportHandler;
import com.st.wastepaper.service.WastePaperBaleInventoryService;

/**
 * @author roshan
 *
 */
@Controller
@RequestMapping("/baleinventoryunload")
public class WastepaperUnloadBalesController {
	
	private static final String VIEW_PAGE="viewpage";
	
	@Autowired
	private ServletContext context;
	
	@Autowired
	private WastePaperBaleInventoryService wastePaperBaleInventoryService;
	
	@Autowired
	private WastePaperUnloadBalesReportHandler wastePaperUnloadBalesReportHandler;
	
	private SimpleDateFormat dateFormat=new SimpleDateFormat("MM-dd-yyyy");
	
@RequestMapping("/unloadbales")
	public String unloadbales(HttpServletRequest request,HttpServletResponse response,Model model){
		
		model.addAttribute("startdate", dateFormat.format(new Date()));
		model.addAttribute("enddate", dateFormat.format(new Date()));
	return "wastepaperUnloadBales";
	}
@RequestMapping(value="/unloadbales/load",method=RequestMethod.GET)
	public String load(HttpServletRequest request,HttpServletResponse response,Model model) throws Exception{
	Date startdate=CommonUtil.checkDate(request.getParameter("startdate"), dateFormat);
	Date enddate=CommonUtil.checkDate(request.getParameter("enddate"), dateFormat);

	SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");

	int days=CommonUtil.getDaysDiffernce(startdate, enddate);
	
	Calendar calendar=Calendar.getInstance();
	calendar.setTime(startdate);
	
	calendar.set(Calendar.HOUR_OF_DAY, 7);
	calendar.set(Calendar.MINUTE, 0);
	calendar.set(Calendar.SECOND, 0);
	calendar.set(Calendar.MILLISECOND, 0);

	/*List<Date> dates=new ArrayList<Date>();
	
	for (int i = 0; i <= days; i++) {
		System.out.println(calendar.getTime());
		dates.add(calendar.getTime());
		calendar.set(Calendar.DATE, calendar.get(Calendar.DATE) + 1);
	}
	List<Object> datas = new ArrayList<Object>();
	 Columns
	List<WastePaperBaleInventory> grades=wastePaperBaleInventoryService.getGrade();
	*/
	List<WastePaperBaleInventory> unloadbalesdata=wastePaperBaleInventoryService.getUnloadBales(startdate,enddate);
	
	model.addAttribute(VIEW_PAGE, true);
	model.addAttribute("unloadbalesdata", unloadbalesdata);
	model.addAttribute("startdate", dateFormat.format(startdate));
	model.addAttribute("enddate", dateFormat.format(enddate));
	return"wastepaperUnloadBales";
}
@RequestMapping(value="/export",method=RequestMethod.POST)
public void export(@RequestParam("startdate")String sdate,
		@RequestParam("enddate")String edate,
		HttpServletResponse response) throws Exception{
	System.out.println("Exporting...");
	
	SimpleDateFormat df = new SimpleDateFormat("MM-dd-yyyy");
	Date startdate=CommonUtil.checkDate(sdate, df);
	Date enddate=CommonUtil.checkDate(edate, df);
	
	String flag="Unload";
	
	List<WastePaperBaleInventory> unloadbalesdata=wastePaperBaleInventoryService.getUnloadBales(startdate,enddate);
	
	response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
	response.setHeader("Content-Disposition", "attachment; filename=WastePaper_UnloadBales_Report.xlsx");
	File file=new File(context.getRealPath("/")+"WEB-INF/WastePaper_UnloadBales_Report.xlsx");
	
	wastePaperUnloadBalesReportHandler.getWPUnloadBalesReport(unloadbalesdata,flag,file,response.getOutputStream());
	
	}

}

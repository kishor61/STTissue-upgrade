/**
 *Oct 9, 2015
 *WastePaperUnloadByShiftReportController.java
 * TODO
 *com.st.wastepaper.controller
 *WastePaperUnloadByShiftReportController.java
 *Sunil Singh Bora
 */
package com.st.wastepaper.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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
import com.st.wastepaper.model.WastePaperUnloadByShift;
import com.st.wastepaper.report.WastePaperUnloadByShiftReportHandler;
import com.st.wastepaper.service.WastePaperUnloadByShiftService;

/**
 * @author roshan
 *
 */
@Controller
@RequestMapping("/wastepaperunloadbyshiftreport")
public class WastePaperUnloadByShiftReportController {
	
private static final String VIEW_PAGE="viewpage";
	
	@Autowired
	private ServletContext context;
	
	private SimpleDateFormat dateFormat=new SimpleDateFormat("MM-dd-yyyy");
	
	@Autowired
	private WastePaperUnloadByShiftService wastepaperunloadbyshiftservice;
	
	@Autowired
	private WastePaperUnloadByShiftReportHandler wastepaperunloadByshiftreporthandler;
	
	@RequestMapping("/view")
	public String unloadbales(HttpServletRequest request,HttpServletResponse response,Model model){
		
		model.addAttribute("startdate", dateFormat.format(new Date()));
		model.addAttribute("enddate", dateFormat.format(new Date()));
	return "wastepaperUnloadByShiftReport";
	}
	@RequestMapping(value="/report",method=RequestMethod.GET)
	public String report(HttpServletRequest request,HttpServletResponse response,Model model) throws Exception{
	Date startdate=CommonUtil.checkDate(request.getParameter("startdate"), dateFormat);
	Date enddate=CommonUtil.checkDate(request.getParameter("enddate"), dateFormat);

	SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
	List<WastePaperUnloadByShift> unloadByShift= wastepaperunloadbyshiftservice.getUnloadByShift(startdate,enddate);
	model.addAttribute(VIEW_PAGE, true);
	model.addAttribute("unloadByShift", unloadByShift);
	model.addAttribute("startdate", dateFormat.format(startdate));
	model.addAttribute("enddate", dateFormat.format(enddate));
	return"wastepaperUnloadByShiftReport";
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
		
		List<WastePaperUnloadByShift> unloadByShift= wastepaperunloadbyshiftservice.getUnloadByShift(startdate,enddate);
		
		response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
		response.setHeader("Content-Disposition", "attachment; filename=WastePaper_Unload_By_Shift_Report.xlsx");
		File file=new File(context.getRealPath("/")+"WEB-INF/WastePaper_Unload_By_Shift_Report.xlsx");
		
		wastepaperunloadByshiftreporthandler.getWPUnloadByShiftReport(unloadByShift,file,response.getOutputStream());
		}

}

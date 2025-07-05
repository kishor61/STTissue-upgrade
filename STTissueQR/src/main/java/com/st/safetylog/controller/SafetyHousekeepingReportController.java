/**
 * 
 */
package com.st.safetylog.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.st.common.CommonUtil;
import com.st.common.SafetyCommonUtil;
import com.st.common.model.Area;
import com.st.common.model.UserAuditor;
import com.st.common.service.AreaService;
import com.st.common.service.UserAuditorService;
import com.st.safetylog.automailer.SafetyHousekeepingAutoMailer;
import com.st.safetylog.model.SafetyHousekeeping;
import com.st.safetylog.model.SafetyHousekeepingSchedule;
import com.st.safetylog.model.SafetyHousekeepingStdType;
import com.st.safetylog.model.SafetyHousekeepingTask;
import com.st.safetylog.report.SafetyHousekeepingReport;
import com.st.safetylog.service.SafetyHousekeepingService;

/**
 * @author sbora
 *
 */
@Controller
@RequestMapping(value="/safetyhousekeepingreport")
public class SafetyHousekeepingReportController {
	
	@Autowired
	private SafetyHousekeepingService safetyHousekeepingService;
	
	@Autowired
	private UserAuditorService userAuditorService;
	
	@Autowired 
	private AreaService areaService; 
	
	@Autowired
	private SafetyHousekeepingReport safetyHousekeepingReport;
	
	@Autowired
	private SafetyHousekeepingAutoMailer safetyHousekeepingAutoMailer;
	
	
	private SimpleDateFormat dateFormat=new SimpleDateFormat("MM-dd-yyyy");
	
	@RequestMapping(value="/main",method=RequestMethod.GET)
	public String main(Model model){
		Date sdate=CommonUtil.checkDate(dateFormat.format(CommonUtil.getFirstDate()), dateFormat);
		Date edate=CommonUtil.checkDate(dateFormat.format(new Date()), dateFormat);
		
		model.addAttribute("sdate", dateFormat.format(sdate));
		model.addAttribute("edate", dateFormat.format(edate));
		
		
		model.addAttribute("flagShow", false);
		
		return "safetylog/safetyHouseKeepingReport";
	}
	
	@RequestMapping(value="/load/data/{sdate}/{edate}",method=RequestMethod.GET)
	public String load(@PathVariable("sdate")String sdate,
			@PathVariable("edate")String edate,
			Model model) {
		
		Date sDate=CommonUtil.checkDate(sdate, dateFormat);
		Date eDate=CommonUtil.checkDate(edate, dateFormat);
		
		List<SafetyHousekeepingTask> housekeepingTasks=safetyHousekeepingService.getSafetyHousekeepingTasks(sDate,eDate);
		
		model.addAttribute("housekeepingTasks", housekeepingTasks);
		model.addAttribute("sdate",sdate);
		model.addAttribute("edate", edate);
		
		model.addAttribute("flagShow", true);
		
		return "safetylog/safetyHouseKeepingReport";
	}
	
	@RequestMapping(value="/export/schedule/excel",method=RequestMethod.POST)
	public void exportScheduleExcel(HttpServletRequest request,HttpServletResponse response) throws IOException {
		Date sdate=CommonUtil.checkDate(request.getParameter("sdate"), dateFormat);
		Date edate=CommonUtil.checkDate(request.getParameter("edate"), dateFormat);
		String recurrence=CommonUtil.checkNull(request.getParameter("recurrence"));
		
		List<SafetyHousekeepingSchedule> schedules=safetyHousekeepingService.getSafetyHousekeepingSchedules(sdate,edate);
		List<Area> areas=areaService.getAreas();
		List<UserAuditor> auditors=userAuditorService.getUserAutiors();
		List<Date> dates=SafetyCommonUtil.getScheduleRange(sdate, edate, recurrence);
		
		response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
		response.setHeader("Content-Disposition", "attachment; filename=ST_Tissue_Housekepping_Schedule.xlsx");
		
		safetyHousekeepingReport.createScheduleReport(schedules,areas,auditors,dates,response.getOutputStream());
	}
	
	
	@RequestMapping(value="/export/standard/pdf",method=RequestMethod.POST)
	public void exportStandardPdf(@RequestParam("taskId")int taskId,HttpServletResponse response) throws Exception {
		SafetyHousekeepingTask housekeepingTask=safetyHousekeepingService.getSafetyHousekeepingTask(taskId);
		List<SafetyHousekeepingStdType> types= safetyHousekeepingService.getSafetyHouseStandard();
		List<SafetyHousekeeping> housekeepings=safetyHousekeepingService.getSafetyHousekeepingAndActions(taskId);
		
		List<Integer> completedIds=housekeepingTask.getCompletedIds();
		for (SafetyHousekeeping safetyHousekeeping : housekeepings) {
			safetyHousekeeping.setTaskId(taskId);
			if(completedIds.contains(safetyHousekeeping.getId())){
				safetyHousekeeping.setCompleted(true);
			}
		}
		SafetyCommonUtil.getTaskScore(types, housekeepings, housekeepingTask);
		
		response.setContentType("application/pdf");
		response.setHeader("Content-disposition", "inline; filename=\"Housekeeping_Standard.pdf\"");
		
		safetyHousekeepingReport.createHousekeepingStandardReport(housekeepingTask,types,housekeepings,response.getOutputStream());
		 
	}
	
	@RequestMapping(value="/export/standard/pdf/{taskId}",method=RequestMethod.GET)
	public void exportStandardPdf2(@PathVariable("taskId")int taskId,HttpServletResponse response) throws Exception {
		SafetyHousekeepingTask housekeepingTask=safetyHousekeepingService.getSafetyHousekeepingTask(taskId);
		List<SafetyHousekeepingStdType> types= safetyHousekeepingService.getSafetyHouseStandard();
		List<SafetyHousekeeping> housekeepings=safetyHousekeepingService.getSafetyHousekeepingAndActions(taskId);
		
		
		
		List<Integer> completedIds=housekeepingTask.getCompletedIds();
		for (SafetyHousekeeping safetyHousekeeping : housekeepings) {
			safetyHousekeeping.setTaskId(taskId);
			if(completedIds.contains(safetyHousekeeping.getId())){
				safetyHousekeeping.setCompleted(true);
			}
		}
		
		SafetyCommonUtil.getTaskScore(types, housekeepings, housekeepingTask);
		
		 response.setContentType("application/pdf");
		 response.setHeader("Content-disposition", "inline; filename=\"Housekeeping_Standard.pdf\"");
		 
		 safetyHousekeepingReport.createHousekeepingStandardReport(housekeepingTask,types,housekeepings,response.getOutputStream());
		 
	}
	
	
	@RequestMapping(value="/export/standard/master/pdf",method=RequestMethod.GET)
	public void exportStandardMasterPdf(HttpServletResponse response) throws Exception {
		
		List<SafetyHousekeepingStdType> types=safetyHousekeepingService.getSafetyHouseStandard();
		List<SafetyHousekeeping> housekeepings=safetyHousekeepingService.getSafetyHousekeeping();
		
		
		 response.setContentType("application/pdf");
		 response.setHeader("Content-disposition", "inline; filename=\"Housekeeping_Standard.pdf\"");
		 
		 safetyHousekeepingReport.createHousekeepingStandardReport(types,housekeepings,response.getOutputStream());
		 
	}
	
	@RequestMapping(value="/viewreport/{taskId}/{sdate}/{edate}",method=RequestMethod.GET)
	public String viewReport(@PathVariable("taskId")int taskId,
			@PathVariable("sdate")String sdate,
			@PathVariable("edate")String edate,
			Model model) throws IOException {
		
		model.addAttribute("sdate", sdate);
		model.addAttribute("edate", edate);
		
		SafetyHousekeepingTask housekeepingTask=safetyHousekeepingService.getSafetyHousekeepingTask(taskId);
		
		model.addAttribute("housekeepingTask", housekeepingTask);
		
		List<SafetyHousekeepingStdType> types= safetyHousekeepingService.getSafetyHouseStandard();

		
		model.addAttribute("types", types);
		
		List<SafetyHousekeeping> housekeepings=safetyHousekeepingService.getSafetyHousekeepingAndActions(taskId);
		
		List<Integer> completedIds=housekeepingTask.getCompletedIds();
		for (SafetyHousekeeping safetyHousekeeping : housekeepings) {
			safetyHousekeeping.setTaskId(taskId);
			if(completedIds.contains(safetyHousekeeping.getId())){
				safetyHousekeeping.setCompleted(true);
			}
		}
		
		
		SafetyCommonUtil.getTaskScore(types, housekeepings, housekeepingTask);
		
		model.addAttribute("housekeepings", housekeepings);
		
		return "safetylog/safetyHousekeepingReportView";
		
	}
	
	
	
	@RequestMapping(value="/openreports",method=RequestMethod.GET)
	public String viewOpenReports(Model model){
		
		
		model.addAttribute("area", 0);
		model.addAttribute("auditor", 0);
		model.addAttribute("bywhom", "");
		
		List<UserAuditor> auditors=userAuditorService.getUserAutiors();
		model.addAttribute("auditors", auditors);
		
		List<Area> areas=areaService.getAreas();
		model.addAttribute("areas", areas);
		
		
		List<SafetyHousekeeping> housekeepings=safetyHousekeepingService.getSafetyHousekeepingOpen(0,0,null);
		model.addAttribute("housekeepings", housekeepings);
		
		return "safetylog/safetyHousekeepingReportOpen";
	}
	
	@RequestMapping(value="/openreports/filter",method=RequestMethod.GET)
	public String viewOpenReportsFilter(@RequestParam("area")int area,
			@RequestParam("auditor")int auditor,
			@RequestParam("bywhom")String bywhom,
			Model model){
		
		model.addAttribute("area", area);
		model.addAttribute("auditor", auditor);
		model.addAttribute("bywhom", bywhom);
		
		List<UserAuditor> auditors=userAuditorService.getUserAutiors();
		model.addAttribute("auditors", auditors);
		
		List<Area> areas=areaService.getAreas();
		model.addAttribute("areas", areas);
		
		
		List<SafetyHousekeeping> housekeepings=safetyHousekeepingService.getSafetyHousekeepingOpen(area,auditor,bywhom);
		model.addAttribute("housekeepings", housekeepings);
		
		return "safetylog/safetyHousekeepingReportOpen";
	}
	
	@RequestMapping(value="/export/openreport/pdf",method=RequestMethod.GET)
	public void exportOpenReportPdf(@RequestParam("area")int area,
			@RequestParam("auditor")int auditor,
			@RequestParam("bywhom")String bywhom,
			HttpServletResponse response) throws Exception {
		
		List<SafetyHousekeeping> housekeepings=safetyHousekeepingService.getSafetyHousekeepingOpen(area,auditor,bywhom);
		
		response.setContentType("application/pdf");
		response.setHeader("Content-disposition", "inline; filename=\"Housekeeping_Standard.pdf\"");
		
		safetyHousekeepingReport.createHousekeepingOpenReport(housekeepings,response.getOutputStream());
		 
	}
	
	@RequestMapping(value="/openreport/email",method=RequestMethod.GET)
	public @ResponseBody boolean exportOpenReportPdf(HttpServletResponse response) throws Exception {
		 
		try {
			safetyHousekeepingAutoMailer.sendOpenActionItemMail();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	
	@RequestMapping(value="/closeditems",method=RequestMethod.GET)
	public String closedItems(Model model){
		Date sdate=CommonUtil.checkDate(dateFormat.format(CommonUtil.getFirstDate()), dateFormat);
		Date edate=CommonUtil.checkDate(dateFormat.format(new Date()), dateFormat);
		
		model.addAttribute("sdate", dateFormat.format(sdate));
		model.addAttribute("edate", dateFormat.format(edate));
		
		
		model.addAttribute("flagShow", false);
		
		
		return "safetylog/safetyHouseKeepingReportClosed"; 
	}
	
	@RequestMapping(value="/closeditems/data",method=RequestMethod.GET)
	public String closedItemsData(@RequestParam("sdate")String sdate,
			@RequestParam("edate")String edate,
			Model model){

		
		model.addAttribute("sdate", sdate);
		model.addAttribute("edate", edate);
		
		
		model.addAttribute("flagShow", true);
		
		
		List<Area> areas=areaService.getAreas();
		model.addAttribute("areas", areas);
		
		
		List<SafetyHousekeeping> housekeepings=safetyHousekeepingService.getSafetyHousekeepingClosedItem(CommonUtil.checkDate(sdate, dateFormat),CommonUtil.checkDate(edate, dateFormat));
		model.addAttribute("housekeepings", housekeepings);
		
		
		return "safetylog/safetyHouseKeepingReportClosed"; 
	}
	
	
	@RequestMapping(value="/export/closedtems/pdf",method=RequestMethod.GET)
	public void exportClosedItemPdf(@RequestParam("sdate")String sdate,
			@RequestParam("edate")String edate,
			HttpServletResponse response) throws Exception {
		
		List<Area> areas=areaService.getAreas();
		List<SafetyHousekeeping> housekeepings=safetyHousekeepingService.getSafetyHousekeepingClosedItem(CommonUtil.checkDate(sdate, dateFormat),CommonUtil.checkDate(edate, dateFormat));
		
		response.setContentType("application/pdf");
		response.setHeader("Content-disposition", "inline; filename=\"Safety_Housekeeping_Closed_Item.pdf\"");
		
		safetyHousekeepingReport.createHousekeepingClosedReport(housekeepings,areas,response.getOutputStream());
		 
	}
}

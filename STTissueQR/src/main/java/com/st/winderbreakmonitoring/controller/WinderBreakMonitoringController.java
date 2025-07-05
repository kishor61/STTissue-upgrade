/**
 *Oct 29, 2015
 *WinderBreakMonitoringController.java
 * TODO
 *com.st.winderbreakmonitoring
 *WinderBreakMonitoringController.java
 *Sunil Singh Bora
 */
package com.st.winderbreakmonitoring.controller;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.google.gson.Gson;
import com.st.common.CommonUtil;
import com.st.common.FrpCommon;
import com.st.customercomplaint.model.CustomerComplaint;
import com.st.qualitypm6.service.GradeService;
import com.st.winderbreakmonitoring.model.WinderBreakMonitoring;
import com.st.winderbreakmonitoring.model.WinderBreakMonitoringComman;
import com.st.winderbreakmonitoring.service.WinderBreakMonitoringService;
import com.st.winderbreakmonitoring.report.*;
/**
 * @author roshan
 *
 */
@Controller
@RequestMapping("/winderbreakmonitoring")
public class WinderBreakMonitoringController {
	
	private SimpleDateFormat dateFormat=new SimpleDateFormat("MM-dd-yyyy");
	private SimpleDateFormat timeFormet=new SimpleDateFormat("HH:mm");
	private SimpleDateFormat dateFormat2=new SimpleDateFormat("MM/dd/yyyy");
	private SimpleDateFormat timeFormat=new SimpleDateFormat("HH:mm");
	
	private static final String EDIT_PAGE="editpage";
	private static final String VIEW_PAGE="viewpage";
	
	@Autowired
	private ServletContext context;
	
	@Autowired
	private GradeService gradeService;
	
	@Autowired
	private WinderBreakMonitoringService winderbreakmonitoringservice;
	
	@Autowired
	private WinderBreakMonitoringReportHandller winderbreakmonitoringreporthandller;
	
	@RequestMapping(value="/view",method=RequestMethod.GET)
	public String view(HttpServletRequest request,HttpServletResponse response,Model model){
	
	Date sdate=CommonUtil.checkDate(dateFormat.format(new Date()), dateFormat);
	Date edate=sdate;
	List<WinderBreakMonitoring> moniterdatas=winderbreakmonitoringservice.getWinderBreakData(sdate,edate);
	List<WinderBreakMonitoring> moniterbreakreason=winderbreakmonitoringservice.getWinderBreakReason();
	
	model.addAttribute("grades", gradeService.getGrades());
	model.addAttribute("crews", WinderBreakMonitoringComman.getCreaw());
	model.addAttribute("shifts", WinderBreakMonitoringComman.getShift());
	
	model.addAttribute("date", dateFormat.format(new Date()));
	model.addAttribute("proddateShow", dateFormat.format(new Date()));
	model.addAttribute("targetdateShow", dateFormat.format(new Date()));
	model.addAttribute("moniterdatas", moniterdatas);
	model.addAttribute("moniterbreakreason", moniterbreakreason);
	return"winderbreakmonitoring"; 
	}
	//Code Edited Here To Load The Data For A Particular Date
	@RequestMapping(value="/view/{date}",method=RequestMethod.GET)
	public String loadDateData(@PathVariable("date")String date,HttpServletRequest request,HttpServletResponse response,Model model) throws Exception{
	
	Date sdate=CommonUtil.checkDate(date, dateFormat);
	Date edate=sdate;
	List<WinderBreakMonitoring> moniterdatas=winderbreakmonitoringservice.getWinderBreakData(sdate,edate);
	List<WinderBreakMonitoring> moniterbreakreason=winderbreakmonitoringservice.getWinderBreakReason();
	
	Date d1 = null;
	Date d2 = null;

	try {
		SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		
		for(WinderBreakMonitoring data :moniterdatas){
			
			data.getStarttime().getTime();
			data.getStoptime().getTime();
			
			/*String dateStart = ""+data.getStarttime().getTime();
			String dateStop = ""+data.getStoptime().getTime();*/
			
			 
            //to convert Date to String, use format method of SimpleDateFormat class.
            String strDate = format.format(data.getStarttime());
            String endDate = format.format(data.getStoptime());
            
			d1 = format.parse(endDate);
			d2 = format.parse(strDate);

			//in milliseconds
			long diff = d2.getTime() - d1.getTime();

			long diffSeconds = diff / 1000 % 60;
			long diffMinutes = diff / (60 * 1000) % 60;
			long diffHours = diff / (60 * 60 * 1000) % 24;
			long diffDays = diff / (24 * 60 * 60 * 1000);

			/*System.out.print(diffDays + " days, ");
			System.out.print(diffHours + " hours, ");
			System.out.print(diffMinutes + " minutes, ");
			System.out.print(diffSeconds + " seconds.");*/
			data.setDowntime(diffDays+":"+diffHours+":"+diffMinutes);
		}
		

	} catch (Exception e) {
		e.printStackTrace();
	}
	model.addAttribute("grades", gradeService.getGrades());
	model.addAttribute("crews", WinderBreakMonitoringComman.getCreaw());
	model.addAttribute("shifts", WinderBreakMonitoringComman.getShift());
	model.addAttribute("date", dateFormat.format(sdate));
	model.addAttribute("proddateShow", dateFormat.format(new Date()));
	model.addAttribute("targetdateShow", dateFormat.format(new Date()));
	model.addAttribute("moniterdatas", moniterdatas);
	model.addAttribute("moniterbreakreason", moniterbreakreason);
	return"winderbreakmonitoring";
	}
	//Code To Load The Data For A Particular Date Ends Here
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public void save(HttpServletRequest request,HttpServletResponse response) throws IOException {
		Map<String, Object> map=new HashMap<String, Object>();
		
		try{
			int id=CommonUtil.checkInt(request.getParameter("id"));
			Date date=CommonUtil.checkDate(request.getParameter("Date"), dateFormat);
			String Shift=CommonUtil.checkNull(request.getParameter("Shift"));
			String Crew=CommonUtil.checkNull(request.getParameter("Crew"));
			String gradeCode=CommonUtil.checkNull(request.getParameter("gradeCode"));
			String Reel=CommonUtil.checkNull(request.getParameter("Reel"));
			String SetNo=CommonUtil.checkNull(request.getParameter("SetNo"));
			String BreakAt=CommonUtil.checkNull(request.getParameter("BreakAt"));
			String Reasonforbreak=CommonUtil.checkNull(request.getParameter("Reasonforbreak"));
			String Losstime=CommonUtil.checkNull(request.getParameter("Losstime"));
			if(Reasonforbreak=="" ||Reasonforbreak==null){
				
			}else{
				List<WinderBreakMonitoring> secondaryreason=winderbreakmonitoringservice.getSecondaryReason(Reasonforbreak);
				String reasonSecond="";
				for(WinderBreakMonitoring sdreason: secondaryreason ){
					reasonSecond=sdreason.getSecondarycode();
				}
				Losstime=reasonSecond;
			}
			
			
			String LeftoutinSpool=CommonUtil.checkNull(request.getParameter("LeftoutinSpool"));
			
			String Stoptime=CommonUtil.checkNull(request.getParameter("Stoptime"));
			String Starttime=CommonUtil.checkNull(request.getParameter("Starttime"));
			String Downtime=CommonUtil.checkNull(request.getParameter("Downtime"));
			
			SimpleDateFormat dateFormatH=new SimpleDateFormat("HH:mm");
			Date stopTime=dateFormatH.parse(Stoptime);
			Date startTime=dateFormatH.parse(Starttime);
			
			//System.out.println("stopTime::"+dateFormatH.parse(Stoptime));
			//System.out.println("startTime::"+dateFormatH.parse(Starttime));
			
			/*try{
				
				int totalMin=0;
				Date sdate=dateFormat.parse(Starttime);
				
				Date edate=dateFormat.parse(Stoptime);
				
				int hh=CommonUtil.getHoursDuration(sdate, edate);
				int mm=CommonUtil.getMinutesDuration(sdate, edate);
				
				totalMin=hh*60+mm;
			
				System.out.println("Stoptime::"+(totalMin/60));
				System.out.println((totalMin%60));
				
				
			}catch(Exception e){
				e.printStackTrace();
			}*/
			WinderBreakMonitoring wm=new WinderBreakMonitoring();
			wm.setId(id);
			wm.setDate(date);
			wm.setShift(Shift);
			wm.setCrew(Crew);
			wm.setReel(Reel);
			wm.setSetNo(SetNo);
			wm.setBreakAt(BreakAt);
			wm.setLosstime(Losstime);
			wm.setReasonforbreak(Reasonforbreak);
			wm.setLeftoutinSpool(LeftoutinSpool);
			wm.setStoptime(stopTime);
			wm.setStarttime(startTime);
			wm.setDowntime(Downtime);
			wm.setGradeCode(gradeCode);
			
			
			try {
				if(wm.getId()==0){
					response.setContentType("application/json");
					//Insert
					int key=winderbreakmonitoringservice.save(wm);
					map.put("status", true);
					System.out.println("Roshan Id is ::"+key);
					map.put("id", key);
					map.put("message", "Data saved successfully.");
					
				}else{
					response.setContentType("application/json");
					//Update
					winderbreakmonitoringservice.update(wm);
					map.put("status", true);
					map.put("id", wm.getId());
					map.put("message", "Data updated successfully.");
				}
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception("Error in saving data", e);
				
			}
		}catch(Exception e){
			System.out.println("Roshan Says, You Have An Error In WinderBreakMonitoringController.java");
			map.put("status", false);
			map.put("error", e.getMessage());
			e.printStackTrace();
		}
		response.setContentType("application/json");
		response.getWriter().write(new Gson().toJson(map));
	}
	@RequestMapping(value="/report",method=RequestMethod.GET)
	public String report(HttpServletRequest request,HttpServletResponse response,Model model){
	
	model.addAttribute("sdate", dateFormat.format(new Date()));
	model.addAttribute("edate", dateFormat.format(new Date()));
	return"winderbreakmonitoringReport"; 
	}
	@RequestMapping(value="/report/load",method=RequestMethod.GET)
	public String load(HttpServletRequest request,HttpServletResponse response,Model model) throws Exception{
	Date sdate=CommonUtil.checkDate(request.getParameter("sdate"), dateFormat);
	Date edate=CommonUtil.checkDate(request.getParameter("edate"), dateFormat);
	List<WinderBreakMonitoring> winderMonitoringData=winderbreakmonitoringservice.getWinderBreakMonitoringReport(sdate,edate);
	model.addAttribute("view", true);
	model.addAttribute("winderMonitoringData", winderMonitoringData);
	model.addAttribute("sdate", dateFormat.format(sdate));
	model.addAttribute("edate", dateFormat.format(edate));
	return"winderbreakmonitoringReport";
}
	@RequestMapping(value="/report/delete", method=RequestMethod.POST)
	public void delete(HttpServletRequest request, HttpServletResponse response) throws IOException{
		
		int id =CommonUtil.checkInt(request.getParameter("id"));
		Map<String, Object> map= new HashMap<String, Object>();
		try{
			winderbreakmonitoringservice.delete(id);
			map.put("status", true);
		}catch(Exception e){
			System.out.println("Roshan Says That You Have A Problem In WinderBreakMonitoringController.java At Delete Method");
			e.printStackTrace();
		}
	response.setContentType("application/json");
	response.getWriter().write(new Gson().toJson(map));
	}
	@RequestMapping(value="/report/export",method=RequestMethod.POST)
	public void export(@RequestParam("sdate")String sdate,@RequestParam("edate")String edate,HttpServletResponse response) throws Exception{

		SimpleDateFormat df = new SimpleDateFormat("MM-dd-yyyy");
		Date startdate=CommonUtil.checkDate(sdate, df);
		Date enddate=CommonUtil.checkDate(edate, df);
		
		List<WinderBreakMonitoring> winderMonitoringData=winderbreakmonitoringservice.getWinderBreakMonitoringReport(startdate,enddate);
		
		response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
		response.setHeader("Content-Disposition", "attachment; filename=Winder_Break_Monitoring_Report.xlsx");
		File file=new File(context.getRealPath("/")+"WEB-INF/Winder_Break_Monitoring_Report.xlsx");
		
		winderbreakmonitoringreporthandller.winderbreakmonitoringreportExport(winderMonitoringData,file,response.getOutputStream());
	}
	@RequestMapping(value="/managebreakreason",method=RequestMethod.GET)
	public String manageBreakReason(HttpServletRequest request,HttpServletResponse response,Model model){
	
	List<WinderBreakMonitoring> moniterbreakreason=winderbreakmonitoringservice.getWinderBreakReason();
	model.addAttribute("view", true);
	model.addAttribute(EDIT_PAGE, false);
	model.addAttribute(VIEW_PAGE, true);
	model.addAttribute("date", dateFormat.format(new Date()));
	model.addAttribute("moniterbreakreason", moniterbreakreason);
	return"winderbreakmonitoring_managebreakreason"; 
	}
	@RequestMapping(value="/breakreason/save",method=RequestMethod.POST)
	public String breakreasonsave(HttpServletRequest request,HttpServletResponse response,Model model,RedirectAttributes redirectAttributes) throws IOException {
		Map<String, Object> map=new HashMap<String, Object>();
		WinderBreakMonitoring wm=new WinderBreakMonitoring();
		try{
			int id=CommonUtil.checkInt(request.getParameter("id"));
			String breakreason=CommonUtil.checkNull(request.getParameter("breakreason"));
			
			System.out.println("breakreason::"+breakreason);
			
			wm.setId(id);
			wm.setReasonforbreak(breakreason);
			
			try {
				if(wm.getId()==0){
					//Insert
					int key=winderbreakmonitoringservice.savebreakreason(wm);
					map.put("status", true);
					map.put("id", key);
					map.put("message", "Data saved successfully.");
					
				}else{
					//Update
					winderbreakmonitoringservice.updatebreakreason(wm);
					map.put("status", true);
					map.put("id", wm.getId());
					map.put("message", "Data updated successfully.");
				}
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception("Error in saving data", e);
				
			}
		}catch(Exception e){
			System.out.println("Roshan Says, You Have An Error In WinderBreakMonitoringController.java");
			map.put("status", false);
			map.put("error", e.getMessage());
			e.printStackTrace();
		}
		//response.setContentType("application/json");
		//response.getWriter().write(new Gson().toJson(map));
		model.addAttribute(EDIT_PAGE, false);
		model.addAttribute(VIEW_PAGE, true);
		List<WinderBreakMonitoring> moniterbreakreason=winderbreakmonitoringservice.getWinderBreakReason();
		model.addAttribute("moniterbreakreason", moniterbreakreason);
		model.addAttribute("view", true);
		
		if(wm.getId()==0){
			redirectAttributes.addFlashAttribute("message", "Data Saved Successfully.");
			return "redirect:/winderbreakmonitoring/managebreakreason";
		}else{
			redirectAttributes.addFlashAttribute("message", "Data Updated Successfully.");
			return "redirect:/winderbreakmonitoring/managebreakreason";
		}
		
	}
	@RequestMapping(value="/managesecondarybreakreason",method=RequestMethod.GET)
	public String managesecondarybreakreason(HttpServletRequest request,HttpServletResponse response,Model model){
	
	List<WinderBreakMonitoring> moniterbreakreason=winderbreakmonitoringservice.getWinderBreakReason();	
	List<WinderBreakMonitoring> secondaryReason=winderbreakmonitoringservice.getWinderSecondaryBreakReason();
	model.addAttribute("view", true);
	model.addAttribute(EDIT_PAGE, false);
	model.addAttribute(VIEW_PAGE, true);
	model.addAttribute("date", dateFormat.format(new Date()));
	model.addAttribute("moniterbreakreason", moniterbreakreason);
	model.addAttribute("secondaryReason", secondaryReason);
	return"winderbreakmonitoring_managesecondarybreakreason"; 
	}
	@RequestMapping(value="/breakreason1/save",method=RequestMethod.POST)
	public String breakreasonsave1(HttpServletRequest request,HttpServletResponse response,Model model,RedirectAttributes redirectAttributes) throws IOException {
		Map<String, Object> map=new HashMap<String, Object>();
		WinderBreakMonitoring wm=new WinderBreakMonitoring();
		try{
			int id=CommonUtil.checkInt(request.getParameter("id"));
			String primaryReason=CommonUtil.checkNull(request.getParameter("primaryreason"));
			String secondaryReason=CommonUtil.checkNull(request.getParameter("secondaryreason"));
				
			
			wm.setId(id);
			wm.setPrimarycode(primaryReason);
			wm.setSecondarycode(secondaryReason);
			
			try {
				if(wm.getId()==0){
					//Insert
					int key=winderbreakmonitoringservice.savebreakreason1(wm);
					map.put("status", true);
					map.put("id", key);
					map.put("message", "Data saved successfully.");
					
				}else{
					//Update
					winderbreakmonitoringservice.updatebreakreason1(wm);
					map.put("status", true);
					map.put("id", wm.getId());
					map.put("message", "Data updated successfully.");
				}
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception("Error in saving data", e);
				
			}
		}catch(Exception e){
			System.out.println("Roshan Says, You Have An Error In WinderBreakMonitoringController.java");
			map.put("status", false);
			map.put("error", e.getMessage());
			e.printStackTrace();
		}
		//response.setContentType("application/json");
		//response.getWriter().write(new Gson().toJson(map));
		model.addAttribute(EDIT_PAGE, false);
		model.addAttribute(VIEW_PAGE, true);
		List<WinderBreakMonitoring> moniterbreakreason=winderbreakmonitoringservice.getWinderBreakReason();
		model.addAttribute("moniterbreakreason", moniterbreakreason);
		model.addAttribute("view", true);
		
		if(wm.getId()==0){
			redirectAttributes.addFlashAttribute("message", "Data Saved Successfully.");
			return "redirect:/winderbreakmonitoring/managesecondarybreakreason";
		}else{
			redirectAttributes.addFlashAttribute("message", "Data Updated Successfully.");
			return "redirect:/winderbreakmonitoring/managesecondarybreakreason";
		}
		
	}
	@RequestMapping(value="/breakreason/edit/{id}",method=RequestMethod.GET)
	public String editBreakReason(@PathVariable("id")int id,HttpServletRequest request,HttpServletResponse response,Model model){
	
	List<WinderBreakMonitoring> editBreakReason=winderbreakmonitoringservice.getEditWinderBreakReason(id);
	model.addAttribute("editBreakReason", editBreakReason);
	model.addAttribute(EDIT_PAGE, true);
	model.addAttribute(VIEW_PAGE, false);
	return"winderbreakmonitoring_managebreakreason"; 
	}
	
	@RequestMapping(value="/breakreasonsecondary/edit/{id}",method=RequestMethod.GET)
	public String editSecondaryBreakReason(@PathVariable("id")int id,HttpServletRequest request,HttpServletResponse response,Model model){
	
	List<WinderBreakMonitoring> moniterdatas=winderbreakmonitoringservice.getWinderBreakReason();
	List<WinderBreakMonitoring> editBreakReason=winderbreakmonitoringservice.getEditWinderBreakSecondaryReason(id);
	String primaryCode="";
	for(WinderBreakMonitoring data :editBreakReason){
		primaryCode=data.getPrimarycode();
	}
	model.addAttribute("moniterdatas", moniterdatas);
	model.addAttribute("editBreakReason", editBreakReason);
	model.addAttribute("primaryCode", primaryCode);
	model.addAttribute(EDIT_PAGE, true);
	model.addAttribute(VIEW_PAGE, false);
	return"winderbreakmonitoring_managesecondarybreakreason"; 
	}
	@RequestMapping(value="/breakreason/delete/{id}", method=RequestMethod.GET)
	public String deleteBreakReason(@PathVariable("id")int id,HttpServletRequest request, HttpServletResponse response,RedirectAttributes redirectAttributes) throws IOException{
		
		Map<String, Object> map= new HashMap<String, Object>();
		try{
			winderbreakmonitoringservice.deleteBreakReason(id);
			map.put("status", true);
		}catch(Exception e){
			System.out.println("Roshan Says That You Have A Problem In CustomerComplaintController.java At Delete Method");
			e.printStackTrace();
		}
		redirectAttributes.addFlashAttribute("message", "Data Deleted Successfully.");
		return "redirect:/winderbreakmonitoring/managebreakreason";
	}
	@RequestMapping(value="/breakreason1/delete/{id}", method=RequestMethod.GET)
	public String deleteBreakReason1(@PathVariable("id")int id,HttpServletRequest request, HttpServletResponse response,RedirectAttributes redirectAttributes) throws IOException{
		
		Map<String, Object> map= new HashMap<String, Object>();
		try{
			winderbreakmonitoringservice.deleteBreakReason1(id);
			map.put("status", true);
		}catch(Exception e){
			System.out.println("Roshan Says That You Have A Problem In CustomerComplaintController.java At Delete Method");
			e.printStackTrace();
		}
		redirectAttributes.addFlashAttribute("message", "Data Deleted Successfully.");
		return "redirect:/winderbreakmonitoring/managebreakreason";
	}
	@RequestMapping(value="/editWinderReport/{id}/{sdate}/{edate}",method=RequestMethod.GET)
	public String editWinderReport(@PathVariable("id")int id,@PathVariable("sdate")String sdate,@PathVariable("edate")String edate,HttpServletRequest request,HttpServletResponse response,Model model) throws ParseException{
	
	List<WinderBreakMonitoring> moniterdatasforid=winderbreakmonitoringservice.getWinderBreakDataOfID(id);
	List<WinderBreakMonitoring> moniterbreakreason=winderbreakmonitoringservice.getWinderBreakReason();
		
	Date dateS = dateFormat.parse(sdate);
	Date dateE = dateFormat.parse(edate);
	model.addAttribute("grades", gradeService.getGrades());
	model.addAttribute("crews", WinderBreakMonitoringComman.getCreaw());
	model.addAttribute("shifts", WinderBreakMonitoringComman.getShift());
	model.addAttribute("sdate", dateFormat.format(dateS));
	model.addAttribute("edate", dateFormat.format(dateE));
	model.addAttribute("moniterdatasforid", moniterdatasforid);
	model.addAttribute("moniterbreakreason", moniterbreakreason);
	
	return"editWinderBreakReport"; 
	}
	@RequestMapping(value="/editWinderReport",method=RequestMethod.POST)
	public String editWinderReportDone(HttpServletRequest request,HttpServletResponse response,RedirectAttributes redirectAttributes) throws IOException {
		Map<String, Object> map=new HashMap<String, Object>();
		String Sdate="";
		String Edate="";
		try{
			int id=CommonUtil.checkInt(request.getParameter("id"));
			Sdate=CommonUtil.checkNull(request.getParameter("Sdate"));
			Edate=CommonUtil.checkNull(request.getParameter("Edate"));
			Date date=CommonUtil.checkDate(request.getParameter("Date"), dateFormat);
			String Shift=CommonUtil.checkNull(request.getParameter("Shift"));
			String Crew=CommonUtil.checkNull(request.getParameter("Crew"));
			String gradeCode=CommonUtil.checkNull(request.getParameter("gradeCode"));
			String Reel=CommonUtil.checkNull(request.getParameter("Reel"));
			String SetNo=CommonUtil.checkNull(request.getParameter("SetNo"));
			String BreakAt=CommonUtil.checkNull(request.getParameter("BreakAt"));
			String Losstime=CommonUtil.checkNull(request.getParameter("Losstime"));
			String Reasonforbreak=CommonUtil.checkNull(request.getParameter("Reasonforbreak"));
			String LeftoutinSpool=CommonUtil.checkNull(request.getParameter("LeftoutinSpool"));
			
			
			String Stophr=CommonUtil.checkNull(request.getParameter("Stophr"));
			String Stopmin=CommonUtil.checkNull(request.getParameter("Stopmin"));
			
			String Starthr=CommonUtil.checkNull(request.getParameter("Starthr"));
			String Startmin=CommonUtil.checkNull(request.getParameter("Startmin"));
			
			String Stoptime=Stophr+":"+Stopmin;
			String Starttime=Starthr+":"+Startmin;
			
			String Downtime=CommonUtil.checkNull(request.getParameter("Downtime"));
			
			SimpleDateFormat dateFormatH=new SimpleDateFormat("HH:mm");
			Date stopTime=dateFormatH.parse(Stoptime);
			Date startTime=dateFormatH.parse(Starttime);
			
			/*Date stopTime=dateFormat.parse(Stoptime);
			Date startTime=dateFormat.parse(Starttime);*/
			
			WinderBreakMonitoring wm=new WinderBreakMonitoring();
			wm.setId(id);
			wm.setDate(date);
			wm.setShift(Shift);
			wm.setCrew(Crew);
			wm.setReel(Reel);
			wm.setSetNo(SetNo);
			wm.setBreakAt(BreakAt);
			wm.setLosstime(Losstime);
			wm.setReasonforbreak(Reasonforbreak);
			wm.setLeftoutinSpool(LeftoutinSpool);
			
			wm.setStoptime(stopTime);
			wm.setStarttime(startTime);
			
			wm.setDowntime(Downtime);
			wm.setGradeCode(gradeCode);
			
			Date d1 = null;
			Date d2 = null;

			try {
				SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
				
				
					
				wm.getStarttime().getTime();
				wm.getStoptime().getTime();
				   //to convert Date to String, use format method of SimpleDateFormat class.
		            String strDate = format.format(wm.getStarttime());
		            String endDate = format.format(wm.getStoptime());
		            
					d1 = format.parse(endDate);
					d2 = format.parse(strDate);

					//in milliseconds
					long diff = d2.getTime() - d1.getTime();

					long diffSeconds = diff / 1000 % 60;
					long diffMinutes = diff / (60 * 1000) % 60;
					long diffHours = diff / (60 * 60 * 1000) % 24;
					long diffDays = diff / (24 * 60 * 60 * 1000);

					/*System.out.print(diffDays + " days, ");
					System.out.print(diffHours + " hours, ");
					System.out.print(diffMinutes + " minutes, ");
					System.out.print(diffSeconds + " seconds.");*/
					wm.setDowntime(diffDays+":"+diffHours+":"+diffMinutes);
				
				

			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				winderbreakmonitoringservice.update(wm);
					map.put("status", true);
					map.put("id", wm.getId());
					map.put("message", "Data updated successfully.");
				}
			 catch (Exception e) {
				e.printStackTrace();
				throw new Exception("Error in saving data", e);
				
			}
		}catch(Exception e){
			System.out.println("Roshan Says, You Have An Error In WinderBreakMonitoringController.java At editWinderReport Method");
			map.put("status", false);
			map.put("error", e.getMessage());
			e.printStackTrace();
		}
		//response.setContentType("application/json");
		//response.getWriter().write(new Gson().toJson(map));
		redirectAttributes.addFlashAttribute("message", "Data Updated Successfully.");
		return "redirect:/winderbreakmonitoring/report/load?sdate="+Sdate+"&edate="+Edate+"&viewbutton=View";
	}
	@RequestMapping(value="/timedurtation",method=RequestMethod.POST)
	public void getTimeDurtation(HttpServletRequest request,
			HttpServletResponse response
			) throws IOException {
		
		Map<String, Integer> data=new HashMap<String, Integer>();
		
		SimpleDateFormat dateFormat=new SimpleDateFormat("HH:mm");
		
		try{
			
			int totalMin=0;
			Date sdate=dateFormat.parse(request.getParameter("sd"));
			
			Date edate=dateFormat.parse(request.getParameter("ed"));
			
			int hh=CommonUtil.getHoursDuration(sdate, edate);
			int mm=CommonUtil.getMinutesDuration(sdate, edate);
			
			totalMin=hh*60+mm;
			
			System.out.println((totalMin/60));
			System.out.println((totalMin%60));
			
			
			data.put("hh", (totalMin/60));
			data.put("mm",(totalMin%60));
			
		}catch(Exception e){
			e.printStackTrace();
		}
		response.setContentType("application/json");
		response.getWriter().write(new Gson().toJson(data));
		
	}
}

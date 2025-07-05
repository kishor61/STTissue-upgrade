/**
 *Oct 7, 2017
 *ManintenanceLogCr6Pm6FrpController.java
 * TODO
 *com.st.manintenancelogcr6pm6frp.controller
 *ManintenanceLogCr6Pm6FrpController.java
 *Roshan Lal Tailor
 */
package com.st.manintenancelogcr6pm6frp.controller;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.google.gson.Gson;
import com.st.common.CommonUtil;
import com.st.common.UtilityKpiMasterCommon;
import com.st.common.exception.ProductionException;
import com.st.manintenancelogcr6pm6frp.mailer.ManintenanceLogCr6Pm6FrpReportMailer;
import com.st.manintenancelogcr6pm6frp.model.ManintenanceLogCr6Pm6Frp;
import com.st.manintenancelogcr6pm6frp.model.ManintenanceLogCr6Pm6FrpArea;
import com.st.manintenancelogcr6pm6frp.service.ManintenanceLogCr6Pm6FrpService;
import com.st.qualitypm6.service.GradeService;

/**
 * @author roshan
 *
 */

@Controller
@RequestMapping("/manintenancelog")
public class ManintenanceLogCr6Pm6FrpController {

	@Autowired
	private ManintenanceLogCr6Pm6FrpService manintenanceLogCr6Pm6FrpServic;
	
	@Autowired
	private GradeService gradeService;
	
	@Autowired
	private ServletContext context;
	
	@Autowired
	private com.st.manintenancelogcr6pm6frp.reporthandler.ManintenanceLogCr6Pm6FrpReportHandler manintenanceLogCr6Pm6FrpReportHandler;
	
	@Autowired
	private ManintenanceLogCr6Pm6FrpReportMailer manintenanceLogCr6Pm6FrpReportMailer;
	
	private SimpleDateFormat dateFormat=new SimpleDateFormat("MM-dd-yyyy");

	private SimpleDateFormat dateTimeFormat=new SimpleDateFormat("HH:mm:ss");
	
	private SimpleDateFormat hoursFormat=new SimpleDateFormat("HH");
	
	private SimpleDateFormat dateAndTimeFormat=new SimpleDateFormat("MM-dd-yyyy HH:mm:ss");
	
	@RequestMapping(value = "/page", method = RequestMethod.GET)
	public String Entrypage(Model model) {
	
		model.addAttribute("showdata", false);
		return "manintenancelog/cr6pm6frplogsEntryPoint";
	}
	@RequestMapping(value = "/page/{shift}", method = RequestMethod.GET)
	public String page(Model model,@RequestParam("shift") String shift) {


		
		Date sdate=CommonUtil.checkDate(dateFormat.format(new Date()), dateFormat);
		Date edate=sdate;
		String target="";
		
		@SuppressWarnings("unchecked")
		Collection<SimpleGrantedAuthority> authorities = (Collection<SimpleGrantedAuthority>)    SecurityContextHolder.getContext().getAuthentication().getAuthorities();
		for (GrantedAuthority authority : authorities) {target=authority.getAuthority();}
		
		if(target.equalsIgnoreCase("Admin") || target.equalsIgnoreCase("OPERATOR") || target.equalsIgnoreCase("OPERATOR4") || target.equalsIgnoreCase("OPERATOR6") || target.equalsIgnoreCase("OPERATOR5")){//FOR Admin CR6 And PM6,CR5
			//Show The Grade Code
			model.addAttribute("prodtypeorgradecode", gradeService.getGrades());
			model.addAttribute("date", dateFormat.format(new Date()));
			model.addAttribute("area", manintenanceLogCr6Pm6FrpServic.getArea());
			
			List<Map<String, Object>> centerlineGrades=manintenanceLogCr6Pm6FrpServic.getArea_ForJSON();
			model.addAttribute("centerlineGrades", UtilityKpiMasterCommon.getJsonDataOfCenterlineGradeCode(centerlineGrades));
			
		}else if(target.equalsIgnoreCase("OPERATOR2")){//For FRP
			//Show The  Production Type
			model.addAttribute("prodtypeorgradecode", ManintenanceLogCr6Pm6Frp.getProductionType());
			model.addAttribute("date", dateFormat.format(new Date()));
			model.addAttribute("area", manintenanceLogCr6Pm6FrpServic.getArea());
			}
		//List<ManintenanceLogCr6Pm6Frp> data=manintenanceLogCr6Pm6FrpServic.getCurrentDateData(new Date());
		
		Date dateS=CommonUtil.getShiftDate();
		List<ManintenanceLogCr6Pm6Frp> data=manintenanceLogCr6Pm6FrpServic.getCurrentDateData(dateS,shift);
		
		//model.addAttribute("shift", ManintenanceLogCr6Pm6Frp.getProductionShift());
		model.addAttribute("shift", shift);
		model.addAttribute("team", ManintenanceLogCr6Pm6Frp.getProductionTeam());
		
		model.addAttribute("moniterdatas", data);
		model.addAttribute("target", target);
		
		model.addAttribute("showdata", true);
		
		
		return "manintenancelog/cr6pm6frplogs";
}
	
	@RequestMapping(value="/view/{date}/{shift}",method=RequestMethod.GET)
	public String loadDateData(@PathVariable("date")String date,@PathVariable("shift")String shift,HttpServletRequest request,HttpServletResponse response,Model model) throws Exception{


		
		Date sdate=CommonUtil.checkDate(date, dateFormat);
		Date edate=sdate;
		String target="";
		
		@SuppressWarnings("unchecked")
		Collection<SimpleGrantedAuthority> authorities = (Collection<SimpleGrantedAuthority>)    SecurityContextHolder.getContext().getAuthentication().getAuthorities();
		for (GrantedAuthority authority : authorities) {target=authority.getAuthority();}
		
		if(target.equalsIgnoreCase("Admin") || target.equalsIgnoreCase("OPERATOR") || target.equalsIgnoreCase("OPERATOR4")|| target.equalsIgnoreCase("OPERATOR6") || target.equalsIgnoreCase("OPERATOR5")){//FOR Admin CR6 And PM6
			//Show The Grade Code
			model.addAttribute("prodtypeorgradecode", gradeService.getGrades());
			model.addAttribute("date", dateFormat.format(sdate));
			model.addAttribute("area", manintenanceLogCr6Pm6FrpServic.getArea());
			
			List<Map<String, Object>> centerlineGrades=manintenanceLogCr6Pm6FrpServic.getArea_ForJSON();
			model.addAttribute("centerlineGrades", UtilityKpiMasterCommon.getJsonDataOfCenterlineGradeCode(centerlineGrades));
			
		}else if(target.equalsIgnoreCase("OPERATOR2")){//For FRP
			//Show The  Production Type
			model.addAttribute("prodtypeorgradecode", ManintenanceLogCr6Pm6Frp.getProductionType());
			model.addAttribute("date", dateFormat.format(sdate));
			model.addAttribute("area", manintenanceLogCr6Pm6FrpServic.getArea());
			}
		List<ManintenanceLogCr6Pm6Frp> data=manintenanceLogCr6Pm6FrpServic.getCurrentDateDataShiftWise(sdate,"All");
		
		//model.addAttribute("shift", ManintenanceLogCr6Pm6Frp.getProductionShift());
		model.addAttribute("shift", shift);
		model.addAttribute("team", ManintenanceLogCr6Pm6Frp.getProductionTeam());
		
		model.addAttribute("moniterdatas", data);
		model.addAttribute("target", target);
		
		model.addAttribute("showdata", true);
		
		return "manintenancelog/cr6pm6frplogs";
}
	
	@RequestMapping(value="/view/backdate/{date}/{shift}",method=RequestMethod.GET)
	public String loadBackDateData(@PathVariable("date")String date,@PathVariable("shift")String shift,HttpServletRequest request,HttpServletResponse response,Model model) throws Exception{


		
		Date sdate=CommonUtil.checkDate(date, dateFormat);
		Date edate=sdate;
		String target="";
		
		@SuppressWarnings("unchecked")
		Collection<SimpleGrantedAuthority> authorities = (Collection<SimpleGrantedAuthority>)    SecurityContextHolder.getContext().getAuthentication().getAuthorities();
		for (GrantedAuthority authority : authorities) {target=authority.getAuthority();}
		
		if(target.equalsIgnoreCase("Admin") || target.equalsIgnoreCase("OPERATOR") || target.equalsIgnoreCase("OPERATOR4")|| target.equalsIgnoreCase("OPERATOR6")|| target.equalsIgnoreCase("OPERATOR5")){//FOR Admin CR6 And PM6
			//Show The Grade Code
			model.addAttribute("prodtypeorgradecode", gradeService.getGrades());
			model.addAttribute("date", dateFormat.format(sdate));
			model.addAttribute("area", manintenanceLogCr6Pm6FrpServic.getArea());
			
			List<Map<String, Object>> centerlineGrades=manintenanceLogCr6Pm6FrpServic.getArea_ForJSON();
			model.addAttribute("centerlineGrades", UtilityKpiMasterCommon.getJsonDataOfCenterlineGradeCode(centerlineGrades));
			
		}else if(target.equalsIgnoreCase("OPERATOR2")){//For FRP
			//Show The  Production Type
			model.addAttribute("prodtypeorgradecode", ManintenanceLogCr6Pm6Frp.getProductionType());
			model.addAttribute("date", dateFormat.format(sdate));
			model.addAttribute("area", manintenanceLogCr6Pm6FrpServic.getArea());
			}
		List<ManintenanceLogCr6Pm6Frp> data=manintenanceLogCr6Pm6FrpServic.getCurrentDateDataShiftWise(sdate,shift);
		
		model.addAttribute("shift", ManintenanceLogCr6Pm6Frp.getProductionShift());
		model.addAttribute("team", ManintenanceLogCr6Pm6Frp.getProductionTeam());
		
		model.addAttribute("moniterdatas", data);
		model.addAttribute("target", target);
		
		model.addAttribute("showdata", true);
		
		return "manintenancelog/cr6pm6frplogsBackDate";
}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public void SaveData(HttpServletRequest request,HttpServletResponse response) throws IOException{
	
		Map<String, Object> map=new HashMap<String, Object>();
		try{
		int id=CommonUtil.checkInt(request.getParameter("id"));
		Date date=CommonUtil.checkDate(request.getParameter("date"), dateFormat);
		String prodtypeorgradecode=CommonUtil.checkNull(request.getParameter("prodtypeorgradecode"));
		String area=CommonUtil.checkNull(request.getParameter("area"));
		String error=CommonUtil.checkNull(request.getParameter("error"));
		String comments=CommonUtil.checkNull(request.getParameter("comments"));
		
		String shift=CommonUtil.checkNull(request.getParameter("shift"));
		String team=CommonUtil.checkNull(request.getParameter("team"));
		
		String change=CommonUtil.checkNull(request.getParameter("change"));
		String time=CommonUtil.checkNull(request.getParameter("time"));
		
		String change1=CommonUtil.checkNull(request.getParameter("change1"));
		
		String target="";
		
		@SuppressWarnings("unchecked")
		Collection<SimpleGrantedAuthority> authorities = (Collection<SimpleGrantedAuthority>)    SecurityContextHolder.getContext().getAuthentication().getAuthorities();
		for (GrantedAuthority authority : authorities) {target=authority.getAuthority();}
		
		ManintenanceLogCr6Pm6Frp data =  new ManintenanceLogCr6Pm6Frp();
		
		data.setId(id);
		
		String tempTime=dateTimeFormat.format(new Date());
		String tempHours=hoursFormat.format(new Date());
		int hour=Integer.parseInt(tempHours);
		String tempDate=dateFormat.format(date);
		
		if(time!=""){
			tempTime=time+":00";
		}
		
		String tempDateAndTime=tempDate+" "+tempTime;
		
		date=dateAndTimeFormat.parse(tempDateAndTime);


		//data.setDate(date);
		data.setDate(CommonUtil.getDateTime(dateFormat.parse(tempDate),dateTimeFormat.parse(tempTime)));
		data.setProdtypeorgradecode(prodtypeorgradecode);
		data.setArea(area);
		data.setError(error);
		data.setComments(comments);
		data.setUsertype(target);
		
		data.setTeam(team);
		data.setShift(shift);
		
		
		Date date1 = dateFormat.parse(tempDate);
        Date date2 = dateFormat.parse(dateFormat.format(new Date()));
        
		if (date1.compareTo(date2) > 0) {
            System.out.println("Date1 is after Date2");
        } else if (date1.compareTo(date2) < 0) {
            System.out.println("Date1 is before Date2");
            if(change.equalsIgnoreCase("change")){
            	
            }else{
            	 final Calendar ecal=Calendar.getInstance();
         		ecal.setTime(date1);
         		ecal.set(Calendar.HOUR_OF_DAY, 0);
         		ecal.set(Calendar.MINUTE, 0);
         		ecal.set(Calendar.SECOND, 0);
         		ecal.set(Calendar.MILLISECOND, 0);
         		ecal.add(Calendar.DATE, 1);
         		
         		Date dateS = new Timestamp(ecal.getTime().getTime());
         		String dateFormatted = dateFormat.format(dateS);
         		
         		data.setDate(CommonUtil.getDateTime(dateFormat.parse(dateFormatted),dateTimeFormat.parse(tempTime)));
            }
           
    		
        } else if (date1.compareTo(date2) == 0) {
            System.out.println("Date1 is equal to Date2");
        } else {
            System.out.println("How to get here?");
        }
		
		
		if(change1==null || change1==""){
			if(data.getShift().equalsIgnoreCase("Night")) {
				if(hour==12 || ( hour>1 && hour<8 )) {
					
					final Calendar pcal=Calendar.getInstance();
					pcal.setTime(data.getDate());
					pcal.set(Calendar.HOUR_OF_DAY, 0);
					pcal.set(Calendar.MINUTE, 0);
					pcal.set(Calendar.SECOND, 0);
					pcal.set(Calendar.MILLISECOND, 0);
					pcal.add(Calendar.DATE, -1);
	         		
	         		Date dateP = new Timestamp(pcal.getTime().getTime());
	         		String dateFormatted = dateFormat.format(dateP);
	         		
	         		tempTime="11:58:00";
	         		data.setDate(CommonUtil.getDateTime(dateFormat.parse(dateFormatted),dateTimeFormat.parse(tempTime)));
				}
			}
		}
		
		
		
		try {
			if(data.getId()==0){
				response.setContentType("application/json");
				//Insert
				int key = manintenanceLogCr6Pm6FrpServic.save(data);
				map.put("status", true);
				map.put("id", key);
				map.put("message", "Data saved successfully.");
				
			}else{
				response.setContentType("application/json");
				//Update
				manintenanceLogCr6Pm6FrpServic.update(data);
				map.put("status", true);
				map.put("id", data.getId());
				map.put("message", "Data updated successfully.");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Error in saving data", e);
			
		}
	}catch(Exception e){
		 
		map.put("status", false);
		map.put("error", e.getMessage());
		e.printStackTrace();
	}
	response.setContentType("application/json");
	response.getWriter().write(new Gson().toJson(map)); 
	}
	
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	public void delete(
			HttpServletRequest request,
			HttpServletResponse response,
			Model model) throws IOException {
			
		int id=CommonUtil.checkInt(request.getParameter("id"));

		Map<String, Object> map=new HashMap<>();
		try {
			manintenanceLogCr6Pm6FrpServic.delete(id);
			map.put("status", true);
		} catch (Exception e) {
			map.put("status", false);
			map.put("error", "Server error message:-"+e.getMessage());
		}
		
		response.setContentType("application/json");
		response.getWriter().write(new Gson().toJson(map));
		
		
	}
	
	
	@RequestMapping(value = "/addmasterorarea", method = RequestMethod.GET)
	public String addmasterorarea(Model model) {

		String target="";
		
		@SuppressWarnings("unchecked")
		Collection<SimpleGrantedAuthority> authorities = (Collection<SimpleGrantedAuthority>)    SecurityContextHolder.getContext().getAuthentication().getAuthorities();
		for (GrantedAuthority authority : authorities) {target=authority.getAuthority();}
	
		model.addAttribute("usetype", target);
		
		return "manintenancelog/addmasterorarea";

	}
	
	@RequestMapping(value = "/addmasterorarea/save", method = RequestMethod.GET)
	public String addMasterOrAreaSaveData(
			@RequestParam(value = "name") String name,
			@RequestParam(value = "usertype") String usertype,
			@RequestParam(value = "description") String description,
			RedirectAttributes redirectAttributes) {
		
		ManintenanceLogCr6Pm6FrpArea ar = new ManintenanceLogCr6Pm6FrpArea();
		ar.setName(name);
		ar.setDescription(description);
		ar.setUsertype(usertype);
		
		  int i = manintenanceLogCr6Pm6FrpServic.save(ar);
		
		  if(i!=0)
		  {
				redirectAttributes.addFlashAttribute("message","Data Saved successfully.");
				return "redirect:/manintenancelog/addmasterorarea";  
		  }
		  else
		  {
			  	redirectAttributes.addFlashAttribute("message","Error While Saving Data");
				return "redirect:/manintenancelog/addmasterorarea";  
		  }

	}
	
	@RequestMapping(value = "/reportpage", method = RequestMethod.GET)
	public String reportPage(Model model) {

		model.addAttribute("sdate", dateFormat.format(CommonUtil.getFirstDate()));
		model.addAttribute("edate", dateFormat.format(new Date()));
		
		model.addAttribute("show", false);
		model.addAttribute("export", false);
		
		List<Map<String, Object>> centerlineGrades=manintenanceLogCr6Pm6FrpServic.getArea_ForJSON();
		model.addAttribute("centerlineGrades", UtilityKpiMasterCommon.getJsonDataOfCenterlineGradeCode(centerlineGrades));
		
		String target="";
		@SuppressWarnings("unchecked")
		Collection<SimpleGrantedAuthority> authorities = (Collection<SimpleGrantedAuthority>)    SecurityContextHolder.getContext().getAuthentication().getAuthorities();
		for (GrantedAuthority authority : authorities) {target=authority.getAuthority();}
		
		if(target.equalsIgnoreCase("ADMIN")){
			model.addAttribute("userType", "ALL");
			model.addAttribute("userTypeEditTrue", true);
		}else{
			model.addAttribute("userType", target);
			model.addAttribute("userTypeEditFalse", true);
		}
		return "manintenancelog/cr6pm6frplogsreport";
}
	@RequestMapping(value="/reportpage/view",method=RequestMethod.GET)
	public String wastepaperDetailView(@RequestParam("sdate")String sdate,@RequestParam("edate")String edate,@RequestParam("userType")String userType,Model model) {
		
		model.addAttribute("sdate", sdate);
		model.addAttribute("edate", edate);
		
		Date sDate=CommonUtil.checkDate(sdate, dateFormat);
		Date eDate=CommonUtil.checkDate(edate, dateFormat);

		String target="";
		@SuppressWarnings("unchecked")
		Collection<SimpleGrantedAuthority> authorities = (Collection<SimpleGrantedAuthority>)    SecurityContextHolder.getContext().getAuthentication().getAuthorities();
		for (GrantedAuthority authority : authorities) {target=authority.getAuthority();}
		
		if(target.equalsIgnoreCase("Admin") || target.equalsIgnoreCase("OPERATOR") || target.equalsIgnoreCase("OPERATOR4")|| target.equalsIgnoreCase("OPERATOR6")|| target.equalsIgnoreCase("OPERATOR5")){//FOR Admin CR6 And PM6
			//Show The Grade Code
			model.addAttribute("prodtypeorgradecode", gradeService.getGrades());
			model.addAttribute("date", dateFormat.format(new Date()));
			model.addAttribute("area", manintenanceLogCr6Pm6FrpServic.getArea());
			
			List<Map<String, Object>> centerlineGrades=manintenanceLogCr6Pm6FrpServic.getArea_ForJSON();
			model.addAttribute("centerlineGrades", UtilityKpiMasterCommon.getJsonDataOfCenterlineGradeCode(centerlineGrades));
			
		}else if(target.equalsIgnoreCase("OPERATOR2")){//For FRP
			//Show The  Production Type
			model.addAttribute("prodtypeorgradecode", ManintenanceLogCr6Pm6Frp.getProductionType());
			model.addAttribute("date", dateFormat.format(new Date()));
			model.addAttribute("area", manintenanceLogCr6Pm6FrpServic.getArea());
			}
		
		model.addAttribute("shift", ManintenanceLogCr6Pm6Frp.getProductionShift());
		model.addAttribute("team", ManintenanceLogCr6Pm6Frp.getProductionTeam());
		
		List<ManintenanceLogCr6Pm6Frp> details=manintenanceLogCr6Pm6FrpServic.getDateBetweenData(sdate,edate,userType);
		
		model.addAttribute("details", details);
		model.addAttribute("show", true);
		model.addAttribute("export", true);
		model.addAttribute("target", target);

		if(target.equalsIgnoreCase("ADMIN")){
			model.addAttribute("userType", "ALL");
			model.addAttribute("userTypeEditTrue", true);
		}else{
			model.addAttribute("userType", target);
			model.addAttribute("userTypeEditFalse", true);
		}
		
		return "manintenancelog/cr6pm6frplogsreport";
	}
	@RequestMapping(value="/reportpage/export",method=RequestMethod.GET)
	public void export(@RequestParam("sdate")String sdate,@RequestParam("edate")String edate,@RequestParam("userType")String userType,HttpServletResponse response) throws Exception{

		
		Date sDate=CommonUtil.checkDate(sdate, dateFormat);
		Date eDate=CommonUtil.checkDate(edate, dateFormat);

		List<ManintenanceLogCr6Pm6Frp> details=manintenanceLogCr6Pm6FrpServic.getDateBetweenData(dateFormat.format(sDate),dateFormat.format(eDate),userType);
		
		response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
		response.setHeader("Content-Disposition", "attachment; filename=Daily Shift Logs Entry Report.xlsx");
		File file=new File(context.getRealPath("/")+"WEB-INF/Daily Shift Logs Entry Report.xlsx");
		
		
		manintenanceLogCr6Pm6FrpReportHandler.exportManintenanceLogCr6Pm6FrpReport(details,file,response.getOutputStream());
		
		}
	@RequestMapping(value="/reportpage/email",method=RequestMethod.POST)
	public @ResponseBody boolean mailDataGradeAndHours(HttpServletRequest request,HttpServletResponse response,Model model) throws ProductionException, IOException {
		try {
			Date sdate=CommonUtil.checkDate(request.getParameter("sdate"), dateFormat);
			Date edate=CommonUtil.checkDate(request.getParameter("edate"), dateFormat);
			String userType=CommonUtil.checkNull(request.getParameter("userType"));
			
			manintenanceLogCr6Pm6FrpReportMailer.sendDailyShiftReportMail(sdate,edate,userType);
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}


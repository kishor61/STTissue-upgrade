/**
 *May 24, 2021
 *EmergencyConcroller.java
 * TODO
 *com.st.Emergency.controller
 *EmergencyConcroller.java
 *Sohan Lal 
 */
package com.st.Emergency.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.st.Emergency.model.EmergencyIncident;
import com.st.Emergency.model.IncidentReport;
import com.st.Emergency.reporthandler.EmergencyExcelReport;
import com.st.Emergency.service.EmergencyService;
import com.st.common.CommonUtil;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


/**
 * @author kishore
 *
 */
@Controller
@RequestMapping("/911EmergencyReport")
public class EmergencyReportConcroller {
	
	@Autowired
	private  EmergencyService emergencyIncidentService;
	
	@Autowired
	private ServletContext context;
	
	@Autowired
	private EmergencyExcelReport emergencyExcelReport;
	private SimpleDateFormat format=new SimpleDateFormat("MM-dd-yyyy");
	
	@RequestMapping(value="/view",method=RequestMethod.GET)
	public String View(Model model) {		
		model.addAttribute("sdate",format.format(CommonUtil.getMonthFirstDate(new Date())));
		model.addAttribute("edate",format.format(new Date()));		
	 	return "emergency/emergencyMainReport";
	}
	@RequestMapping(value="/reportview",method=RequestMethod.GET)
	public String ReportView(
			@RequestParam("sdate") String sdate,
			@RequestParam("edate") String edate,
			@RequestParam("starIncidentLocation") String starIncidentLocation,
			@RequestParam("locationIncidentOccured") String locationIncidentOccured,
			@RequestParam("incidentType") String incidentType,
			@RequestParam("status") String status,
			@RequestParam("crew") String crew,
			Model model) {
			model.addAttribute("sdate", sdate);
			model.addAttribute("edate", edate);
			model.addAttribute("status", status);
			model.addAttribute("crew", crew);
			List<EmergencyIncident>	datas=emergencyIncidentService.getData(sdate,edate,status,starIncidentLocation,incidentType,locationIncidentOccured,crew);			
			if(datas!=null&&datas.size()>0)
			{
				model.addAttribute("datas", datas);
			}
			else
			{
				model.addAttribute("message","Data is not available choose anoher date.");
			}		
	 	return "emergency/emergencySortingDataReport";
	}
	@RequestMapping(value = "/detailsreportview", method = RequestMethod.GET)
	public String IncidentReportView(@RequestParam("id") int id,Model model) {			
			List<EmergencyIncident>	datas=emergencyIncidentService.getData(id);
			IncidentReport	data=emergencyIncidentService.getIncidentReportData(id);
			if(data!=null)
				model.addAttribute("yesFlage", true);
			emergencyIncidentService.updateViewStatus(id);
			if(datas!=null&&datas.size()>0)
			{
				model.addAttribute("data", datas.get(0));
			}
			else
			{
				model.addAttribute("message","Data is not available choose anoher date.");
			}
		return "emergency/emergencyReport";
	}
	
	@RequestMapping(value = "/incidentReportEntry/{id}", method = RequestMethod.GET)
	public String incidentReportView(@PathVariable("id") int id,Model model) {
		
			IncidentReport	data=emergencyIncidentService.getIncidentReportData(id);	
			emergencyIncidentService.updateViewStatus(id);		
			if(data!=null)
			{
				model.addAttribute("data", data);
			}
			else
			{
				model.addAttribute("message","Data is not available choose anoher date.");
			}
			return "emergency/emergencyIncidentReport";
	}
	@RequestMapping(value = "/detailsreportdownload", method = RequestMethod.GET)
	public void IncidentReportDownloadExcel(@RequestParam("id") int id,Model model,
			HttpServletResponse response) throws IOException {			
			List<EmergencyIncident>	datas=emergencyIncidentService.getData(id);	
			
			response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
			response.setHeader("Content-Disposition", "attachment; filename=ST_Tissue_Incident.xlsx");
			
			File file=new File(context.getRealPath("/")+"WEB-INF/excel template/EmergencyIncident.xlsx");
			
			emergencyExcelReport.EmergencyReport(datas,file,response.getOutputStream());
	}	
	@RequestMapping(value="/noview",method=RequestMethod.GET)
	public String NoView(Model model) {		
		model.addAttribute("sdate",format.format(CommonUtil.getMonthFirstDate(new Date())));
		model.addAttribute("edate",format.format(new Date()));		
	 	return "emergency/blank";
	}
	@RequestMapping(value = "/checkuser", method = RequestMethod.POST)
	public void isValidUser(HttpServletRequest request,	HttpServletResponse response )throws IOException {
		
		Map<String, Object> map=new HashMap<>();
		String username=request.getParameter("firstname");
		String password=request.getParameter("pwd");
		if(username!=null && username.equals("master")){
			if(password!=null && password.equals("$TP@456")){
				map.put("status", true);
			}else{
				map.put("status", false);
			}
		}else{
			map.put("status", false);
		}
		
		response.setContentType("application/json");
		response.getWriter().write(new Gson().toJson(map));
		
	}
}

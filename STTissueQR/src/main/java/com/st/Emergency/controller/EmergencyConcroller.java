/**
 *May 24, 2021
 *EmergencyConcroller.java
 * TODO
 *com.st.Emergency.controller
 *EmergencyConcroller.java
 *Sohan Lal 
 */
package com.st.Emergency.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.st.Emergency.model.EmergencyIncident;
import com.st.Emergency.model.IncidentReport;
import com.st.Emergency.service.EmergencyService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * @author kishore
 *
 */
@Controller
@RequestMapping("/911Emergency")
public class EmergencyConcroller {
	@Autowired
	private EmergencyService emergencyIncidentService;
	private SimpleDateFormat dateformat = new SimpleDateFormat("MM-dd-yyyy");
	private SimpleDateFormat timeformat = new SimpleDateFormat("HH:MM:SSS");
	private SimpleDateFormat datetimeformat = new SimpleDateFormat("MM-dd-yyyy HH:MM:SSS");

	@RequestMapping(value = "/view", method = RequestMethod.GET)
	public String EmergencyView(Model model) {
		EmergencyIncident data = new EmergencyIncident();
		data.setEdate(dateformat.format(new Date()));
		model.addAttribute("data", data);

		return "emergency/emergencyView";
	}

	@RequestMapping(value = "/incident", method = RequestMethod.GET)
	public String IncidentReportView(@RequestParam("incidentType") String incidentType,
			@RequestParam("shift") String shift, @RequestParam("date") String date,
			@RequestParam("employeeNumber") String employeeNumber, @RequestParam("crew") String crew, Model model) {
		
			EmergencyIncident data = new EmergencyIncident();
			data.setEdate(date);
			data.setShift(shift);
			data.setIncidentType(incidentType);
			data.setEmployeeNumber(employeeNumber);
			data.setCrew(crew);
			data.setDateOfIncident(dateformat.format(new Date()));
			data.setTimeOfIncident(timeformat.format(new Date()));
			data.setDateReported(dateformat.format(new Date()));
			model.addAttribute("furtherFollowUpRequested", "No");
			model.addAttribute("data", data);
		
		return "emergency/emergencyView";
	}

	@RequestMapping(value = "/view/inident/save", method = RequestMethod.POST)
	public String EmergencyIncidentSave(@ModelAttribute("data") EmergencyIncident emergencyIncident, Model model,
			RedirectAttributes redirectAttributes, HttpServletRequest request) {

		HttpSession httpSession = request.getSession();
		httpSession.setAttribute("emergencyIncident", emergencyIncident);
		redirectAttributes.addFlashAttribute("id",emergencyIncident.getId());
		if(emergencyIncident.getInvestigation().equalsIgnoreCase("Yes"))
			return "redirect:/911Emergency/incidentReportEntry/view";
		else {
		
			 emergencyIncidentService.saveorUpdate(emergencyIncident); 			 
			 if(emergencyIncident.getId()==0){
				 redirectAttributes.addFlashAttribute("message","Data Saved successfully.");
				 return "redirect:/911Emergency/view"; 
			 } 
			 else {
				 redirectAttributes.addFlashAttribute("message","Data Update successfully.");
				 return "redirect:/911Emergency/view"; 
			 }
		}
	
	}

	@RequestMapping(value = "/view/inident/update", method = RequestMethod.POST)
	public String EmergencyIncidentUpdate(@ModelAttribute("data") EmergencyIncident emergencyIncident, Model model,
			RedirectAttributes redirectAttributes, HttpServletRequest request) {
		HttpSession httpSession = request.getSession();
		httpSession.setAttribute("emergencyIncident", emergencyIncident);
		redirectAttributes.addFlashAttribute("id",emergencyIncident.getId());
		if(emergencyIncident.getInvestigation()!=null&&emergencyIncident.getInvestigation().equalsIgnoreCase("Yes"))
			return "redirect:/911Emergency/incidentReportEntry/view";
		else {
		
			 emergencyIncidentService.saveorUpdate(emergencyIncident); 			 
			 if(emergencyIncident.getId()==0){
				 redirectAttributes.addFlashAttribute("message","Data Saved successfully.");
				 return "redirect:/911Emergency/view"; 
			 } 
			 else {
				 redirectAttributes.addFlashAttribute("message","Data Update successfully.");
				 return "redirect:/911Emergency/view"; 
			 }
		}

	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String IncidentReportEdit(@PathVariable("id") int id, Model model,HttpServletRequest request) {
		System.out.println(id);

		List<EmergencyIncident> datas = emergencyIncidentService.getData(id);
		IncidentReport	incidentReport=emergencyIncidentService.getIncidentReportData(id);
		if(incidentReport!=null)
			model.addAttribute("yesFlage", true);
		if (datas != null && datas.size() > 0) {
			EmergencyIncident data = new EmergencyIncident();
			data.setId(id);
			data.setIncidentType(datas.get(0).getIncidentType());
			data.setEdate(datas.get(0).getEdate());
			data.setShift(datas.get(0).getShift());
			data.setEmployeeNumber(datas.get(0).getEmployeeNumber());
			data.setCrew(datas.get(0).getCrew());
			data.setSafeReport(datas.get(0).getSafeReport());
			data.setStatus(datas.get(0).getStatus());
			data.setYourStartArea(datas.get(0).getYourStartArea());
			data.setStarIncidentLocation(datas.get(0).getStarIncidentLocation());
			data.setLocationIncidentOccured(datas.get(0).getLocationIncidentOccured());
			data.setDescpOfEvent(datas.get(0).getDescpOfEvent());
			data.setStarCategory(datas.get(0).getStarCategory());
			data.setDateOfIncident(datas.get(0).getDateOfIncident());
			data.setTimeOfIncident(datas.get(0).getTimeOfIncident());
			data.setDateReported(datas.get(0).getDateReported());
			data.setFurtherFollowUpRequested(datas.get(0).getFurtherFollowUpRequested());
			data.setEffectedbytheincident(datas.get(0).getEffectedbytheincident());
			model.addAttribute("data", data);

		}
		HttpSession httpSession = request.getSession();
		httpSession.setAttribute("emergencyIncident", datas.get(0));
		return "emergency/emergencyEditablereort";
	}

	@RequestMapping(value = "/incidentReportEntry/view", method = RequestMethod.GET)
	public String EmergencyIncidentReportEntryView(HttpServletRequest request, HttpServletResponse response,
			Model model) {
		IncidentReport data = new IncidentReport();
		if(!model.containsAttribute("id")) {
			return "redirect:/911Emergency/view";
		}else {
		
			EmergencyIncident emergencyIncident = (EmergencyIncident) request.getSession()
					.getAttribute("emergencyIncident");
			data.setIncidentType(emergencyIncident.getIncidentType());
			data.setDate1(emergencyIncident.getDateReported());
			data.setDate2(emergencyIncident.getDateReported());
			IncidentReport data1=emergencyIncidentService.getIncidentReportData(emergencyIncident.getId());
			if(data1!=null)
				model.addAttribute("data", data1);
			else
				model.addAttribute("data", data);
			
			return "emergency/emergencyIncidentReportEntry";
		}
		
	}

	@RequestMapping(value = "/incidentReportEntry/save", method = RequestMethod.POST)
	public String EmergencyIncidentReportSave(@ModelAttribute("data") IncidentReport incidentReport, Model model,
			RedirectAttributes redirectAttributes, HttpServletRequest request, HttpServletResponse response) {
		model.addAttribute("data", incidentReport);
		EmergencyIncident emergencyIncident = (EmergencyIncident) request.getSession()
				.getAttribute("emergencyIncident");
		int i = emergencyIncidentService.saveorUpdate(emergencyIncident, incidentReport);
		// emergencyIncidentService.incidentReportSaveorUpdate(incidentReport);
		if (i > 0) {
			if (incidentReport.getId() == 0) {
				redirectAttributes.addFlashAttribute("message", "Data Saved successfully.");

				return "redirect:/911Emergency/view";
			} else {
				redirectAttributes.addFlashAttribute("message", "Data Update successfully.");
				return "redirect:/911Emergency/view";
			}
		} else {
			redirectAttributes.addFlashAttribute("message", "Data Save  Failed !.");
			return "redirect:/911Emergency/view";
		}

	}

	// getIncidentReportData
	@RequestMapping(value = "/incidentReportEntry/view/{id}", method = RequestMethod.GET)
	public String IncidentReportView(@PathVariable("id") int emergencyIncidentId, Model model) {
		if (emergencyIncidentId == 0) {
			return "redirect:/911Emergency/incidentReportEntry/view";
		} else {
			IncidentReport datas = emergencyIncidentService.getIncidentReportData(emergencyIncidentId);
			if (datas != null) {
				model.addAttribute("data", datas);
				model.addAttribute("edit", true);
			} else {
				model.addAttribute("message", "Data is not available choose anoher date.");
			}
			return "emergency/emergencyIncidentReportEntry";
		}

	}
}

/**
 *Mar 17, 2018
 *UtilityOperatorPM5Controller.java
 * TODO
 *com.st.obccPM5.controller
 *UtilityOperatorPM5Controller.java
 *Roshan Lal Tailor
 */
package com.st.obccPM5.controller;

import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.st.obccPM5.model.UtilityOperatorPM5;
import com.st.obccPM5.service.UtilityOperatorPM5Service;

/**
 * @author roshan
 *
 */
@Controller
@RequestMapping("/utilityOperatorpm5")
public class UtilityOperatorPM5Controller {

	@Autowired
	private UtilityOperatorPM5Service utilityOperatorPM5Service;

	private SimpleDateFormat format = new SimpleDateFormat("MM-dd-yyyy");

	@RequestMapping(value = "/view", method = RequestMethod.GET)
	public String operatorBasicchecklistView(
			@RequestParam("position") String position,
			@RequestParam("shift") String shift,
			@RequestParam("date") String date,
			@RequestParam("operatorname") String operatorname,
			@RequestParam("crew") String crew, Model model) {
			
			UtilityOperatorPM5 data = new UtilityOperatorPM5();
			
			data.setEdate(date);
			data.setShift(shift);
			data.setPosition(position);
			data.setOperatorName(operatorname);
			data.setCrew(crew);			
	try {
			UtilityOperatorPM5 dt = utilityOperatorPM5Service.getOperatorData(position,date, shift, crew);			
			if (dt == null) {
				data.setEdate(date);
				data.setShift(shift);
				data.setPosition(position);
				data.setOperatorName(operatorname);
				data.setCrew(crew);
				model.addAttribute("data", data);
			} else if (dt.getId() == 0) {
				data.setEdate(date);
				data.setShift(shift);
				data.setPosition(position);
				data.setOperatorName(operatorname);
				data.setCrew(crew);
				model.addAttribute("data", data);
			}

			else {
				model.addAttribute("edit", "yes");
				model.addAttribute("data", dt);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "PM5/utilityOperatorpm5";
	}
	@RequestMapping(value = "/back", method = RequestMethod.GET)
	public String operatorBasicchecklistBack(
			@RequestParam("position") String position,
			@RequestParam("shift") String shift,
			@RequestParam("date") String date,
			@RequestParam("operatorname") String operatorname,
			@RequestParam("crew") String crew, Model model) {
		
		UtilityOperatorPM5 data = new UtilityOperatorPM5();
		
		data.setEdate(date);
		data.setShift(shift);
		data.setPosition(position);
		data.setOperatorName(operatorname);
		data.setCrew(crew);
		try {
			UtilityOperatorPM5 dt = utilityOperatorPM5Service.getOperatorData(position,date, shift, crew);
			if (dt == null) {
				data.setEdate(date);
				data.setShift(shift);
				data.setPosition(position);
				data.setOperatorName(operatorname);
				data.setCrew(crew);
				model.addAttribute("data", data);
			} else if (dt.getId() == 0) {
				data.setEdate(date);
				data.setShift(shift);
				data.setPosition(position);
				data.setOperatorName(operatorname);
				data.setCrew(crew);
				model.addAttribute("data", data);
			}

			else {
				model.addAttribute("edit", "yes");
				model.addAttribute("data", dt);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "PM5/utilitybackpm5";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String backTenderSaveData(@ModelAttribute("data") UtilityOperatorPM5 data,Model model, RedirectAttributes redirectAttributes) {
		
		
		model.addAttribute("data",data);
		 
		utilityOperatorPM5Service.saveorUpdate(data);
		
		if(data.getId()==0){
			redirectAttributes.addFlashAttribute("message","Data Saved successfully.");
			return "redirect:/operatorCareCheckListPM5/view";
		}
		else
		{
			redirectAttributes.addFlashAttribute("message","Data Update successfully.");
			return "redirect:/operatorCareCheckListPM5/view";
		}
		
		 
	}
	

}

/**
 *Oct 22, 2019
 *R1OperatorPM5Controller.java
 * TODO
 *com.st.obccPM5.controller
 *R1OperatorPM5Controller.java
 *Roshan Lal Tailor
 */
package com.st.obccPM5.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.st.obccPM5.model.LeadOperatorPM5;
import com.st.obccPM5.model.R1WaterJetsDown;
import com.st.obccPM5.model.R2OperatorPM5;
import com.st.obccPM5.service.R1WaterJetsDownService;


/**
 * @author roshan
 *
 */
@Controller
@RequestMapping("/r1waterjetsdown")
public class R1WaterJetsDownController {
	
	@Autowired
	private R1WaterJetsDownService r1WaterJetsDownService;
	
	
	@RequestMapping(value = "/view", method = RequestMethod.GET)
	public String operatorBasicchecklistView(
			@RequestParam("position") String position,
			@RequestParam("shift") String shift,
			@RequestParam("date") String date,
			@RequestParam("operatorname") String operatorname,
			@RequestParam("crew") String crew, Model model) {

		R1WaterJetsDown data = new R1WaterJetsDown();
			data.setEdate(date);
			data.setShift(shift);
			data.setPosition(position);
			data.setOperatorName(operatorname);
			data.setCrew(crew);		
		try {
			R1WaterJetsDown dt = r1WaterJetsDownService.getOperatorData(position,shift,date, crew);
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

		return "PM5/r1waterjetsdown";
	}
	@RequestMapping(value = "/back", method = RequestMethod.GET)
	public String operatorBasicchecklistBack(
			@RequestParam("position") String position,
			@RequestParam("shift") String shift,
			@RequestParam("date") String date,
			@RequestParam("operatorname") String operatorname,
			@RequestParam("crew") String crew, Model model) {

		R1WaterJetsDown data = new R1WaterJetsDown();
			data.setEdate(date);
			data.setShift(shift);
			data.setPosition(position);
			data.setOperatorName(operatorname);
			data.setCrew(crew);
	
		try {
			R1WaterJetsDown dt = r1WaterJetsDownService.getOperatorData(position,shift,date, crew);
			//System.out.println(dt);
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

		return "PM5/r1backpm5";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String R1OperatorPM5SaveData(@ModelAttribute("data") R1WaterJetsDown data,Model model, RedirectAttributes redirectAttributes) {
		
		
		model.addAttribute("data",data);
		 
		r1WaterJetsDownService.saveorUpdate(data);
		
		if(data.getId()==0){
			redirectAttributes.addFlashAttribute("message","Data Saved successfully.");
			return "redirect:/operatorCareCheckListPM5/view";
		}
		else
		{
			redirectAttributes.addFlashAttribute("message","Data Update successfully.");
			return "redirect:/operatorCareCheckListPM5/view";
		}
		
		 
	}}

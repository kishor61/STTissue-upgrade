/**
 *May 10, 2021
 *R2WaterJetsDownController.java
 * TODO
 *com.st.obccPM5.controller
 *R2WaterJetsDownController.java
 *Sohan Lal 
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

import com.st.obccPM5.model.R2WaterJetsDown;
import com.st.obccPM5.service.R2WaterJetsDownService;

/**
 * @author Sohanlal
 *
 */
@Controller
@RequestMapping("/r2waterjetsdown")
public class R2WaterJetsDownController {
	
	@Autowired
	private R2WaterJetsDownService R2WaterJetsDownService;
	
	@RequestMapping(value = "/view", method = RequestMethod.GET)
	public String operatorBasicchecklistView(
			@RequestParam("position") String position,
			@RequestParam("shift") String shift,
			@RequestParam("date") String date,
			@RequestParam("operatorname") String operatorname,
			@RequestParam("crew") String crew, Model model) {

			R2WaterJetsDown data = new R2WaterJetsDown();
			data.setEdate(date);
			data.setShift(shift);
			data.setPosition(position);
			data.setOperatorName(operatorname);
			data.setCrew(crew);
		try {
			R2WaterJetsDown dt = R2WaterJetsDownService.getOperatorData(position,shift,date, crew);
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
		return "PM5/r2waterJetsDown";
	}
	@RequestMapping(value = "/back", method = RequestMethod.GET)
	public String operatorBasicchecklistBack(
			@RequestParam("position") String position,
			@RequestParam("shift") String shift,
			@RequestParam("date") String date,
			@RequestParam("operatorname") String operatorname,
			@RequestParam("crew") String crew, Model model) {

		R2WaterJetsDown data = new R2WaterJetsDown();
			data.setEdate(date);
			data.setShift(shift);
			data.setPosition(position);
			data.setOperatorName(operatorname);
			data.setCrew(crew);		
		try {
			R2WaterJetsDown dt = R2WaterJetsDownService.getOperatorData(position,shift,date, crew);
			
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
		return "PM5/r2backpm5";
	}
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String R2WaterJetsDownSaveData(@ModelAttribute("data") R2WaterJetsDown data,Model model, RedirectAttributes redirectAttributes) {
		
		
		model.addAttribute("data",data);
		 
		R2WaterJetsDownService.saveorUpdate(data);
		
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

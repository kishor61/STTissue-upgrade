/**
 *Oct 21, 2019
 *LeadOperatorPM5Controller.java
 * TODO
 *com.st.oBcc1pm5.controller
 *LeadOperatorPM5Controller.java
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

import com.st.obccPM5.model.LeadOperatorPM5;
import com.st.obccPM5.service.LeadOperatorPM5Service;
import com.st.obcc.model.BackTender;

/**
 * @author sohan
 *
 */
@Controller
@RequestMapping("/leadoperatorpm5")
public class LeadOperatorPM5Controller {@Autowired
	private LeadOperatorPM5Service leadOperatorPM5Service;
	
	@RequestMapping(value = "/view", method = RequestMethod.GET)
	public String operatorBasicchecklistView(
			@RequestParam("position") String position,
			@RequestParam("shift") String shift,
			@RequestParam("date") String date,
			@RequestParam("operatorname") String operatorname,
			@RequestParam("crew") String crew, Model model) {

			LeadOperatorPM5 data = new LeadOperatorPM5();
			data.setEdate(date);
			data.setShift(shift);
			data.setPosition(position);
			data.setOperatorName(operatorname);
			data.setCrew(crew);
		
		try {
			LeadOperatorPM5 dt = leadOperatorPM5Service.getOperatorData(position,date,shift);
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
		return "PM5/leadoperatorpm5";
	}
	@RequestMapping(value = "/back", method = RequestMethod.GET)
	public String operatorBasicchecklistBack(
			@RequestParam("position") String position,
			@RequestParam("shift") String shift,
			@RequestParam("date") String date,
			@RequestParam("operatorname") String operatorname,
			@RequestParam("crew") String crew, Model model) {

			LeadOperatorPM5 data = new LeadOperatorPM5();
			data.setEdate(date);
			data.setShift(shift);
			data.setPosition(position);
			data.setOperatorName(operatorname);
			data.setCrew(crew);
		
		try {
			LeadOperatorPM5 dt = leadOperatorPM5Service.getOperatorData(position,date,shift);
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
		return "PM5/leadbakpm5";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String LeadOperatorPM5SaveData(@ModelAttribute("data") LeadOperatorPM5 data,Model model, RedirectAttributes redirectAttributes) {
		
		
		model.addAttribute("data",data);
		 
		leadOperatorPM5Service.saveorUpdate(data);
		
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

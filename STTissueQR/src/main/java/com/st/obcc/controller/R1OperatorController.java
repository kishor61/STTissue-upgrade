/**
 *Jun 27, 2016
 *R1OperatorController.java
 * TODO
 *com.st.obcc.controller
 *R1OperatorController.java
 *Sunil Singh Bora
 */
package com.st.obcc.controller;

import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.st.obcc.model.R1Operator;
import com.st.obcc.service.R1OperatorService;

/**
 * @author snavhaal 
 *
 */
@Controller
@RequestMapping("/R1Operator")
public class R1OperatorController {
	
	@Autowired
	private R1OperatorService operatorService;
	
	private SimpleDateFormat format = new SimpleDateFormat("MM-dd-yyyy");

	@RequestMapping(value = "/view", method = RequestMethod.GET)
	public String operatorBasicchecklistView(
			@RequestParam("position") String position,
			@RequestParam("shift") String shift,
			@RequestParam("date") String date,
			@RequestParam("operatorname") String operatorname,
			@RequestParam("crew") String crew, Model model) {

		try {
			R1Operator dt = operatorService.getOperatorData(position,date,shift, crew);
			R1Operator data = new R1Operator();
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

		return "r1operator";
	}
	@RequestMapping(value = "/back", method = RequestMethod.GET)
	public String operatorBasicchecklistBack(
			@RequestParam("position") String position,
			@RequestParam("shift") String shift,
			@RequestParam("date") String date,
			@RequestParam("operatorname") String operatorname,
			@RequestParam("crew") String crew, Model model) {

		try {
			R1Operator dt = operatorService.getOperatorData(position,date,shift, crew);
			R1Operator data = new R1Operator();
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

		return "backr1operatorpm6";
	}
	
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String r1OperatorSaveData(@ModelAttribute("data") R1Operator data,Model model, RedirectAttributes redirectAttributes) {
	
		model.addAttribute("data",data);
		 
		operatorService.saveorUpdate(data);
		
		if(data.getId()==0){
			redirectAttributes.addFlashAttribute("message","Data Saved successfully.");
			return "redirect:/operatorCareCheckList/view";
		}
		else
		{
			redirectAttributes.addFlashAttribute("message","Data Update successfully.");
			return "redirect:/operatorCareCheckList/view";
		}
	}
	 
	 

}

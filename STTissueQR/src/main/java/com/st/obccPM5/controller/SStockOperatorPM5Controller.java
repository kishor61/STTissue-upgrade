/**
 *Oct 23, 2019
 *StockOperatorPM5Controller.java
 * TODO
 *com.st.obccPM5.controller
 *StockOperatorPM5Controller.java
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

import com.st.obccPM5.model.StockOperatorPM5;
import com.st.obccPM5.service.StockOperatorPM5Service;

/**
 * @author roshan
 *
 */
@Controller
@RequestMapping("/stockoperatorpm5")
public class SStockOperatorPM5Controller {

	@Autowired
	private StockOperatorPM5Service stockOperatorpm5service;
	
	@RequestMapping(value = "/view", method = RequestMethod.GET)
	public String operatorBasicchecklistView(
			@RequestParam("position") String position,
			@RequestParam("shift") String shift,
			@RequestParam("date") String date,
			@RequestParam("operatorname") String operatorname,
			@RequestParam("crew") String crew, Model model) {

			StockOperatorPM5 data = new StockOperatorPM5();
			data.setEdate(date);
			data.setShift(shift);
			data.setPosition(position);
			data.setOperatorName(operatorname);
			data.setCrew(crew);
		
		try {
			StockOperatorPM5 dt = stockOperatorpm5service.getOperatorData(position,shift, date);
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

		return "PM5/stockoperatorpm5";
	}
	@RequestMapping(value = "/back", method = RequestMethod.GET)
	public String operatorBasicchecklistBack(
			@RequestParam("position") String position,
			@RequestParam("shift") String shift,
			@RequestParam("date") String date,
			@RequestParam("operatorname") String operatorname,
			@RequestParam("crew") String crew, Model model) {

		StockOperatorPM5 data = new StockOperatorPM5();
			data.setEdate(date);
			data.setShift(shift);
			data.setPosition(position);
			data.setOperatorName(operatorname);
			data.setCrew(crew);
		
		try {
			StockOperatorPM5 dt = stockOperatorpm5service.getOperatorData(position,shift,date);
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
		return "PM5/stockbackpm5";
	}
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String StockOperatorPM5SaveData(@ModelAttribute("data") StockOperatorPM5 data,Model model, RedirectAttributes redirectAttributes) {
		
		
		model.addAttribute("data",data);
		 
		stockOperatorpm5service.saveorUpdate(data);
		
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

/**
 *Jul 4, 2016
 *StockOperatorcontroller.java
 * TODO
 *com.st.obcc.controller
 *StockOperatorcontroller.java
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

import com.st.obcc.model.StockOperator;
import com.st.obcc.service.StockOperatorService;

/**
 * @author snavhaal
 *
 */
@Controller
@RequestMapping("/stockoperator")
public class StockOperatorController {

	@Autowired
	private StockOperatorService stockOperatorService;

	private SimpleDateFormat format = new SimpleDateFormat("MM-dd-yyyy");

	@RequestMapping(value = "/view", method = RequestMethod.GET)
	public String stokeoperatorchecklistView(
			@RequestParam("position") String position,
			@RequestParam("shift") String shift,
			@RequestParam("date") String date,
			@RequestParam("operatorname") String operatorname,
			@RequestParam("crew") String crew, Model model) {

		try {
			StockOperator dt = stockOperatorService.getOperatorData(position,
					date, shift, crew);
			// System.out.println(dt);
			StockOperator data = new StockOperator();
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

		return "backstockpm6";
	}
	@RequestMapping(value = "/back", method = RequestMethod.GET)
	public String stokeoperatorchecklistBack(
			@RequestParam("position") String position,
			@RequestParam("shift") String shift,
			@RequestParam("date") String date,
			@RequestParam("operatorname") String operatorname,
			@RequestParam("crew") String crew, Model model) {

		try {
			StockOperator dt = stockOperatorService.getOperatorData(position,
					date, shift, crew);
			// System.out.println(dt);
			StockOperator data = new StockOperator();
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

		return "stockOperator";
	}
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String stockoperatorSaveData(@ModelAttribute("data") StockOperator data,Model model, RedirectAttributes redirectAttributes) {
		
		
		model.addAttribute("data",data);
		 
		stockOperatorService.saveorUpdate(data);
		
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

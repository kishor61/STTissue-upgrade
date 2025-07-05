/**
 *Jun 9, 2016
 *OperatorCheckListBackTenderController.java
 * TODO
 *com.st.obcc.controller
 *OperatorCheckListBackTenderController.java
 *Sunil Singh Bora
 */
package com.st.obcc.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.st.common.CommonUtil;
import com.st.obcc.model.BackTender;
import com.st.obcc.model.OperatorData;
import com.st.obcc.service.BackTenderService;
import com.st.obcc.service.OperatorService;

/**
 * @author snavhaal
 *
 */
@Controller
@RequestMapping("/backtender")
public class BackTenderController {

	@Autowired
	private BackTenderService backTenderService;

	private SimpleDateFormat format = new SimpleDateFormat("MM-dd-yyyy");

	@RequestMapping(value = "/view", method = RequestMethod.GET)
	public String operatorBasicchecklistView(
			@RequestParam("position") String position,
			@RequestParam("shift") String shift,
			@RequestParam("date") String date,
			@RequestParam("operatorname") String operatorname,
			@RequestParam("crew") String crew, Model model) {

		try {
			BackTender dt = backTenderService.getOperatorData(position,date,shift, crew);
			//System.out.println(dt);
			BackTender data = new BackTender();
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

		return "backtender";
	}
	@RequestMapping(value = "/back", method = RequestMethod.GET)
	public String operatorBasicchecklistBack(
			@RequestParam("position") String position,
			@RequestParam("shift") String shift,
			@RequestParam("date") String date,
			@RequestParam("operatorname") String operatorname,
			@RequestParam("crew") String crew, Model model) {

		try {
			BackTender dt = backTenderService.getOperatorData(position,date,shift, crew);
			//System.out.println(dt);
			BackTender data = new BackTender();
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

		return "backbacktenderpm6";
	}
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String backTenderSaveData(@ModelAttribute("data") BackTender data,Model model, RedirectAttributes redirectAttributes) {
		
		
		model.addAttribute("data",data);
		 
		backTenderService.saveorUpdate(data);
		
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

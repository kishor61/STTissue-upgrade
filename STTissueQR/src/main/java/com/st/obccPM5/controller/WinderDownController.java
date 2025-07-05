/**
 *May 7, 2021
 *WinderDownController.java
 * TODO
 *com.st.obccPM5.controller
 *WinderDownController.java
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

import com.st.obccPM5.model.WinderDown;
import com.st.obccPM5.service.WinderDownServiceImpl;

/**
 * @author Sohanlal
 *
 */
@Controller
@RequestMapping("/winderdown")
public class WinderDownController {

	@Autowired
	private WinderDownServiceImpl winderDownService;

	@RequestMapping(value = "/view", method = RequestMethod.GET)
	public String operatorBasicchecklistView(@RequestParam("position") String position,
			@RequestParam("shift") String shift, @RequestParam("date") String date,
			@RequestParam("operatorname") String operatorname, @RequestParam("crew") String crew, Model model) {

		WinderDown data = new WinderDown();
		data.setEdate(date);
		data.setShift(shift);
		data.setPosition(position);
		data.setOperatorName(operatorname);
		data.setCrew(crew);
		try {
			WinderDown dt = winderDownService.getOperatorData(position, shift, date, crew);
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

		return "PM5/winderDown";
	}

	@RequestMapping(value = "/back", method = RequestMethod.GET)
	public String operatorBasicchecklistBack(@RequestParam("position") String position,
			@RequestParam("shift") String shift, @RequestParam("date") String date,
			@RequestParam("operatorname") String operatorname, @RequestParam("crew") String crew, Model model) {

		WinderDown data = new WinderDown();
		data.setEdate(date);
		data.setShift(shift);
		data.setPosition(position);
		data.setOperatorName(operatorname);
		data.setCrew(crew);

		try {
			WinderDown dt = winderDownService.getOperatorData(position, shift, date, crew);
			// System.out.println(dt);
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
	public String R1OperatorPM5SaveData(@ModelAttribute("data") WinderDown data, Model model,
			RedirectAttributes redirectAttributes) {

		model.addAttribute("data", data);

		winderDownService.saveorUpdate(data);

		if (data.getId() == 0) {
			redirectAttributes.addFlashAttribute("message", "Data Saved successfully.");
			return "redirect:/operatorCareCheckListPM5/view";
		} else {
			redirectAttributes.addFlashAttribute("message", "Data Update successfully.");
			return "redirect:/operatorCareCheckListPM5/view";
		}

	}
}

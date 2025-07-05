/**
 *26-Nov-2019
 *CommonController.java
 * TODO
 *com.st.FrpObcc.controller
 *CommonController.java
 *Roshan Lal Tailor
 */
package com.st.frpobcc.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.st.frpobcc.model.Common;
import com.st.frpobcc.model.OpRoute_1;
import com.st.frpobcc.model.OpRoute_2;
import com.st.frpobcc.model.OpRoute_3;
import com.st.frpobcc.model.OpRoute_4;
import com.st.frpobcc.model.OpRoute_5;
import com.st.frpobcc.model.OpRoute_6;
import com.st.frpobcc.model.OpRoute_7;
import com.st.frpobcc.model.OpRoute_8;
import com.st.frpobcc.model.OpRoute_9;
import com.st.frpobcc.service.OpRoute_1ServiceImp;
import com.st.frpobcc.service.OpRoute_2ServiceImp;
import com.st.frpobcc.service.OpRoute_3ServiceImp;
import com.st.frpobcc.service.OpRoute_4ServiceImp;
import com.st.frpobcc.service.OpRoute_5ServiceImp;
import com.st.frpobcc.service.OpRoute_6ServiceImp;
import com.st.frpobcc.service.OpRoute_7ServiceImp;
import com.st.frpobcc.service.OpRoute_8ServiceImp;
import com.st.frpobcc.service.OpRoute_9ServiceImp;

/**
 * @author sohan
 *
 */
@Controller
@RequestMapping("/frpobccCommon")
public class CommonController {
	
	@Autowired
	private OpRoute_1ServiceImp oproute_1service;
	@Autowired
	private OpRoute_2ServiceImp oproute_2service;
	@Autowired
	private OpRoute_3ServiceImp oproute_3service;
	@Autowired
	private OpRoute_4ServiceImp oproute_4service;
	@Autowired
	private OpRoute_5ServiceImp oproute_5service;
	@Autowired
	private OpRoute_6ServiceImp oproute_6service;
	@Autowired
	private OpRoute_7ServiceImp oproute_7service;
	@Autowired
	private OpRoute_8ServiceImp oproute_8service;
	@Autowired
	private OpRoute_9ServiceImp oproute_9service;
	
	private SimpleDateFormat format=new SimpleDateFormat("MM-dd-yyyy");
	
	@RequestMapping(value="/view", method=RequestMethod.GET)
	public String View(Model model) {
		Common data=new Common();
		data.setDate(format.format(new Date()));
		model.addAttribute("data", data);
		
		return "NewFrp/commonfrp";
	}
	@RequestMapping(value="/select", method=RequestMethod.GET)
	public String PageSelector(	
			@RequestParam("position") String position,
			@RequestParam("date") String date,
			@RequestParam("crew") String crew,			
			@ModelAttribute("data") Common data,
			Model model) {
		//datas.setDate(format.format(new Date()));
		
		if(data.getPosition().equals("OP1"))
		{				
			List<OpRoute_1> datas = oproute_1service.getData(date,date);
			if(datas.size()>0)
			{
				for(OpRoute_1 dt:datas)
				{
					model.addAttribute("edit", "yes");
					model.addAttribute("data", dt);
				}
			}
			else
			{
				OpRoute_1 OpRoute_1=new OpRoute_1();
				OpRoute_1.setDate(date);
				OpRoute_1.setPosition(position);
				OpRoute_1.setCrew(crew);					
				model.addAttribute("data", OpRoute_1);
			}
			return "NewFrp/oproute_1";
		}
		else if(data.getPosition().equals("OP2"))
		{
			List<OpRoute_2> datas = oproute_2service.getData(date,date);
			if(datas.size()>0)
			{
				for(OpRoute_2 dt:datas)
				{
					model.addAttribute("edit", "yes");
					model.addAttribute("data", dt);
				}
			}
			else
			{
				OpRoute_2 OpRoute_2 =new OpRoute_2();
				OpRoute_2.setDate(date);
				OpRoute_2.setPosition(position);
				OpRoute_2.setCrew(crew);
				model.addAttribute("data", OpRoute_2);
			}
			return "NewFrp/oproute_2";
		}
		else if(data.getPosition().equals("OP3"))
		{
			List<OpRoute_3> datas = oproute_3service.getData(date,date);
			if(datas.size()>0)
			{
				for(OpRoute_3 dt:datas)
				{
					model.addAttribute("edit", "yes");
					model.addAttribute("data", dt);
				}
			}
			else
			{
				OpRoute_3 OpRoute_3 =new OpRoute_3();
				OpRoute_3.setDate(date);
				OpRoute_3.setPosition(position);
				OpRoute_3.setCrew(crew);
				model.addAttribute("data", OpRoute_3);
			}
			return "NewFrp/oproute_3";
		}
		else if(data.getPosition().equals("OP4"))
		{
			List<OpRoute_4> datas = oproute_4service.getData(date,date);
			if(datas.size()>0)
			{
				for(OpRoute_4 dt:datas)
				{
					model.addAttribute("edit", "yes");
					model.addAttribute("data", dt);
				}
			}
			else
			{
				OpRoute_4 OpRoute_4 =new OpRoute_4();
				OpRoute_4.setDate(date);
				OpRoute_4.setPosition(position);
				OpRoute_4.setCrew(crew);
				model.addAttribute("data", OpRoute_4);
			}
			return "NewFrp/oproute_4";
		}
		else if(data.getPosition().equals("OP5"))
		{
			List<OpRoute_5> datas = oproute_5service.getData(date,date);
			if(datas.size()>0)
			{
				for(OpRoute_5 dt:datas)
				{
					model.addAttribute("edit", "yes");
					model.addAttribute("data", dt);
				}
			}
			else
			{
				OpRoute_5 OpRoute_5 =new OpRoute_5();
				OpRoute_5.setDate(date);
				OpRoute_5.setPosition(position);
				OpRoute_5.setCrew(crew);
				model.addAttribute("data", OpRoute_5);
			}
			return "NewFrp/oproute_5";
		}
		else if(data.getPosition().equals("OP6"))
		{
			List<OpRoute_6> datas = oproute_6service.getData(date,date);
			if(datas.size()>0)
			{
				for(OpRoute_6 dt:datas)
				{
					model.addAttribute("edit", "yes");
					model.addAttribute("data", dt);
				}
			}
			else
			{
				OpRoute_6 OpRoute_6 =new OpRoute_6();
				OpRoute_6.setDate(date);
				OpRoute_6.setPosition(position);
				OpRoute_6.setCrew(crew);
				model.addAttribute("data", OpRoute_6);
			}
			return "NewFrp/oproute_6";
		}
		else if(data.getPosition().equals("OP7"))
		{
			List<OpRoute_7> datas = oproute_7service.getData(date,date);
			if(datas.size()>0)
			{
				for(OpRoute_7 dt:datas)
				{
					model.addAttribute("edit", "yes");
					model.addAttribute("data", dt);
				}
			}
			else
			{
				OpRoute_7 OpRoute_7 =new OpRoute_7();
				OpRoute_7.setDate(date);
				OpRoute_7.setPosition(position);
				OpRoute_7.setCrew(crew);
				model.addAttribute("data", OpRoute_7);
			}
			return "NewFrp/oproute_7";
		}
		else if(data.getPosition().equals("OP8"))
		{
			List<OpRoute_8> datas = oproute_8service.getData(date,date);
			if(datas.size()>0)
			{
				for(OpRoute_8 dt:datas)
				{
					model.addAttribute("edit", "yes");
					model.addAttribute("data", dt);
				}
			}
			else
			{
				OpRoute_8 OpRoute_8 =new OpRoute_8();
				OpRoute_8.setDate(date);
				OpRoute_8.setPosition(position);
				OpRoute_8.setCrew(crew);
				model.addAttribute("data", OpRoute_8);
			}
			return "NewFrp/oproute_8";
		}
		else if(data.getPosition().equals("OP9"))
		{
			List<OpRoute_9> datas = oproute_9service.getData(date,date);
			if(datas.size()>0)
			{
				for(OpRoute_9 dt:datas)
				{
					model.addAttribute("edit", "yes");
					model.addAttribute("data", dt);
				}
			}
			else
			{
				OpRoute_9 OpRoute_9 =new OpRoute_9();
				OpRoute_9.setDate(date);
				OpRoute_9.setPosition(position);
				OpRoute_9.setCrew(crew);
				model.addAttribute("data", OpRoute_9);
			}
			return "NewFrp/oproute_9";
		}
		else
			return "NewFrp/commonfrp";
	}
	
	@RequestMapping(value = "/OpRoute_1/save", method = RequestMethod.POST)
	public String  OpRoute_1Save(@ModelAttribute("data") OpRoute_1 OpRoute_1,
			Model model, RedirectAttributes redirectAttributes) {
		
		
			model.addAttribute("data",OpRoute_1);
			oproute_1service.saveorUpdate(OpRoute_1);
			if(OpRoute_1.getId()==0){
				redirectAttributes.addFlashAttribute("message","Data Saved successfully.");
				return "redirect:/frpobccCommon/view";
			}
			else
			{
				redirectAttributes.addFlashAttribute("message","Data Update successfully.");
				return "redirect:/frpobccCommon/view";
			}
		
	}
	@RequestMapping(value = "/OpRoute_2/save", method = RequestMethod.POST)
	public String  OpRoute_2Save(@ModelAttribute("data") OpRoute_2 OpRoute_2,
			Model model, RedirectAttributes redirectAttributes) {
		
			model.addAttribute("data",OpRoute_2);
			oproute_2service.saveorUpdate(OpRoute_2);
			if(OpRoute_2.getId()==0){
				redirectAttributes.addFlashAttribute("message","Data Saved successfully.");
				return "redirect:/frpobccCommon/view";
			}
			else
			{
				redirectAttributes.addFlashAttribute("message","Data Update successfully.");
				return "redirect:/frpobccCommon/view";
			}
	
	}
	@RequestMapping(value = "/OpRoute_3/save", method = RequestMethod.POST)
	public String  OpRoute_3Save(@ModelAttribute("data") OpRoute_3 OpRoute_3,
			Model model, RedirectAttributes redirectAttributes) {
		
		
			model.addAttribute("data",OpRoute_3);
			oproute_3service.saveorUpdate(OpRoute_3);
			if(OpRoute_3.getId()==0){
				redirectAttributes.addFlashAttribute("message","Data Saved successfully.");
				return "redirect:/frpobccCommon/view";
			}
			else
			{
				redirectAttributes.addFlashAttribute("message","Data Update successfully.");
				return "redirect:/frpobccCommon/view";
			}
	
	}
	@RequestMapping(value = "/OpRoute_4/save", method = RequestMethod.POST)
	public String  OpRoute_4Save(@ModelAttribute("data") OpRoute_4 OpRoute_4,
			Model model, RedirectAttributes redirectAttributes) {
		
		
			model.addAttribute("data",OpRoute_4);
			oproute_4service.saveorUpdate(OpRoute_4);
			if(OpRoute_4.getId()==0){
				redirectAttributes.addFlashAttribute("message","Data Saved successfully.");
				return "redirect:/frpobccCommon/view";
			}
			else
			{
				redirectAttributes.addFlashAttribute("message","Data Update successfully.");
				return "redirect:/frpobccCommon/view";
			}
	
	}
	@RequestMapping(value = "/OpRoute_5/save", method = RequestMethod.POST)
	public String  OpRoute_5Save(@ModelAttribute("data") OpRoute_5 OpRoute_5,
			Model model, RedirectAttributes redirectAttributes) {
		
		
			model.addAttribute("data",OpRoute_5);
			oproute_5service.saveorUpdate(OpRoute_5);
			if(OpRoute_5.getId()==0){
				redirectAttributes.addFlashAttribute("message","Data Saved successfully.");
				return "redirect:/frpobccCommon/view";
			}
			else
			{
				redirectAttributes.addFlashAttribute("message","Data Update successfully.");
				return "redirect:/frpobccCommon/view";
			}
	
	}
	@RequestMapping(value = "/OpRoute_6/save", method = RequestMethod.POST)
	public String  OpRoute_6Save(@ModelAttribute("data") OpRoute_6 OpRoute_6,
			Model model, RedirectAttributes redirectAttributes) {
				
			model.addAttribute("data",OpRoute_6);
			oproute_6service.saveorUpdate(OpRoute_6);
			if(OpRoute_6.getId()==0){
				redirectAttributes.addFlashAttribute("message","Data Saved successfully.");
				return "redirect:/frpobccCommon/view";
			}
			else
			{
				redirectAttributes.addFlashAttribute("message","Data Update successfully.");
				return "redirect:/frpobccCommon/view";
			}
	
	}
	@RequestMapping(value = "/OpRoute_7/save", method = RequestMethod.POST)
	public String  OpRoute_7Save(@ModelAttribute("data") OpRoute_7 OpRoute_7,
			Model model, RedirectAttributes redirectAttributes) {
				
			model.addAttribute("data",OpRoute_7);
			oproute_7service.saveorUpdate(OpRoute_7);
			if(OpRoute_7.getId()==0){
				redirectAttributes.addFlashAttribute("message","Data Saved successfully.");
				return "redirect:/frpobccCommon/view";
			}
			else
			{
				redirectAttributes.addFlashAttribute("message","Data Update successfully.");
				return "redirect:/frpobccCommon/view";
			}
	
	}
	@RequestMapping(value = "/OpRoute_8/save", method = RequestMethod.POST)
	public String  OpRoute_8Save(@ModelAttribute("data") OpRoute_8 OpRoute_8,
			Model model, RedirectAttributes redirectAttributes) {
				
			model.addAttribute("data",OpRoute_8);
			oproute_8service.saveorUpdate(OpRoute_8);
			if(OpRoute_8.getId()==0){
				redirectAttributes.addFlashAttribute("message","Data Saved successfully.");
				return "redirect:/frpobccCommon/view";
			}
			else
			{
				redirectAttributes.addFlashAttribute("message","Data Update successfully.");
				return "redirect:/frpobccCommon/view";
			}
	
	}
	@RequestMapping(value = "/OpRoute_9/save", method = RequestMethod.POST)
	public String  OpRoute_9Save(@ModelAttribute("data") OpRoute_9 OpRoute_9,
			Model model, RedirectAttributes redirectAttributes) {
				
			model.addAttribute("data",OpRoute_9);
			oproute_9service.saveorUpdate(OpRoute_9);
			if(OpRoute_9.getId()==0){
				redirectAttributes.addFlashAttribute("message","Data Saved successfully.");
				return "redirect:/frpobccCommon/view";
			}
			else
			{
				redirectAttributes.addFlashAttribute("message","Data Update successfully.");
				return "redirect:/frpobccCommon/view";
			}
	
	}

}

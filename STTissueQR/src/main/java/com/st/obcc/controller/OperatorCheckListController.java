/**
 *May 31, 2016
 *OperatorCheckListController.java
 * TODO
 *com.st.operator.controller
 *OperatorCheckListController.java
 *Sunil Singh Bora
 */
package com.st.obcc.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.google.gson.Gson;
import com.st.common.CommonUtil;
import com.st.obcc.model.OperatorData;
import com.st.obcc.service.OperatorService;


/**
 * @author roshan R1Operator
 *
 */
@Controller
@RequestMapping("/operatorCareCheckList")
public class OperatorCheckListController {
	
	
	@Autowired
	private OperatorService operatorService;
	
	
	private SimpleDateFormat format=new SimpleDateFormat("MM-dd-yyyy");

	@RequestMapping(value="/view",method=RequestMethod.GET)
	public String operatorBasicchecklistView(Model model) {
		OperatorData data=new OperatorData();
		data.setEdate(format.format(new Date()));
		model.addAttribute("data", data);
	 	return "operatorBasicCheckListNew";
	}
	
	@RequestMapping(value="/viewoperator",method=RequestMethod.GET)
	public String operatorBasicchecklistView(@RequestParam("position") String position,@RequestParam("shift") String shift,@RequestParam("date") String date,@RequestParam("operatorname") String operatorname,@RequestParam("crew") String crew,Model model) {
		
		try
		{
			OperatorData dt = operatorService.getOperatorData(position,shift,date,crew);
			OperatorData data=new OperatorData();
			if(dt == null)
			{
				data.setEdate(date);
				data.setShift(shift);
				data.setPosition(position);
				data.setOperatorname(operatorname);
				data.setCrew(crew);
				model.addAttribute("data", data);		
			}
			else if(dt.getId()==0)
			{
				data.setEdate(date);
				data.setShift(shift);
				data.setPosition(position);
				data.setCrew(crew);
				model.addAttribute("data", data);	
			}
			 
			else
			{
				model.addAttribute("edit", "yes");
				model.addAttribute("data", dt);
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
	 	return "operatorBasicCheckListNew";
	}
	
	@RequestMapping(value="/back",method=RequestMethod.GET)
	public String operatorBasicchecklistBack(@RequestParam("position") String position,@RequestParam("shift") String shift,@RequestParam("date") String date,@RequestParam("operatorname") String operatorname,@RequestParam("crew") String crew,Model model) {
		
		try
		{
			OperatorData dt = operatorService.getOperatorData(position,shift,date,crew);
			OperatorData data=new OperatorData();
			if(dt == null)
			{
				data.setEdate(date);
				data.setShift(shift);
				data.setPosition(position);
				data.setOperatorname(operatorname);
				data.setCrew(crew);
				model.addAttribute("data", data);		
			}
			else if(dt.getId()==0)
			{
				data.setEdate(date);
				data.setShift(shift);
				data.setPosition(position);
				data.setCrew(crew);
				model.addAttribute("data", data);	
			}
			 
			else
			{
				model.addAttribute("edit", "yes");
				model.addAttribute("data", dt);
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
	 	return "backr2operatorpm6";
	}
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String operatorBasicchecklistSave(@ModelAttribute("data")OperatorData data,Model model,RedirectAttributes redirectAttributes) throws Exception {
		
		//System.out.println(data.getConveyorcol1desc());	
		 
		model.addAttribute("data",data);
		
		operatorService.saveorUpdate(data);
		
		if(data.getId()==0){
			redirectAttributes.addFlashAttribute("message","Data Saved successfully.");
			return "redirect:view";
		}
		else
		{
			redirectAttributes.addFlashAttribute("message","Data Update successfully.");
			return "redirect:view";
		}	 	 
	}
	
	
	@RequestMapping(value="/checkObcc", method=RequestMethod.POST)
	public void CheckObcc(HttpServletRequest request,HttpServletResponse response) throws IOException{
		response.setContentType("application/json");
		
		
		String date=request.getParameter("date");
		String position=request.getParameter("position");
		String shift=request.getParameter("shift");
		Map<String,Boolean> map=new HashMap<String,Boolean>();				
		boolean check= operatorService.CheckObcc(date,position,shift);	
		map.put("check", check);
		response.getWriter().write(new Gson().toJson(map));
		
		System.out.println(new Gson().toJson(map));		
	}
	
	@RequestMapping(value="/checkObcc/back",method=RequestMethod.GET)
	public String checkObccBack(Model model){
		
		OperatorData data=new OperatorData();
		data.setEdate(format.format(new Date()));
		model.addAttribute("data", data);
		return "backoperatorpm6";
	}	
 
}

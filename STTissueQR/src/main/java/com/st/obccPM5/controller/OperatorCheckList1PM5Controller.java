/**
 *Oct 24, 2019
 *OperatorPM5CheckListPM5Controller.java
 * TODO
 *com.st.obccPM5.controller
 *OperatorPM5CheckListPM5Controller.java
 *Roshan Lal Tailor
 */
package com.st.obccPM5.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.st.obccPM5.model.OperatorPM5;
import com.st.obccPM5.service.OperatorPM5Service;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import com.google.gson.Gson;

/**
 * @author roshan
 *
 */
@Controller
@RequestMapping("/operatorCareCheckListPM5")
public class OperatorCheckList1PM5Controller {@Autowired
	private OperatorPM5Service operatorPM5Service;
	private SimpleDateFormat format=new SimpleDateFormat("MM-dd-yyyy");

	@RequestMapping(value="/view",method=RequestMethod.GET)
	public String OperatorPM5BasicchecklistView(Model model) {
		OperatorPM5 data=new OperatorPM5();
		data.setEdate(format.format(new Date()));
		model.addAttribute("data", data);
		
	 	return "PM5/operatorBasicCheckListpm5";
	}
	@RequestMapping(value="/checkObcc", method=RequestMethod.POST)
	public void CheckObcc(HttpServletRequest request,HttpServletResponse response) throws IOException{
		response.setContentType("application/json");
		
		
		String date=request.getParameter("date");
		String position=request.getParameter("position");
		String shift=request.getParameter("shift");
		Map<String,Boolean> map=new HashMap<String,Boolean>();				
		boolean check= operatorPM5Service.CheckObcc(date,position,shift);	
		map.put("check", check);
		response.getWriter().write(new Gson().toJson(map));
		
		System.out.println(new Gson().toJson(map));		
	}
	@RequestMapping(value="/checkObcc/back",method=RequestMethod.GET)
	public String checkObccBack(Model model){
		
		OperatorPM5 data=new OperatorPM5();
		data.setEdate(format.format(new Date()));
		model.addAttribute("data", data);
		return "PM5/backdateentryoperatorBasicChereChecklistpm5";
	}}

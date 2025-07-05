/**
 *Dec 7, 2016
 *HigherAuthorityDecisionController.java
 * TODO
 *com.st.higherauthoritydecision
 *HigherAuthorityDecisionController.java
 *Roshan Lal Tailor
 */
package com.st.higherauthoritydecision.controller;


import java.io.IOException;
import java.util.List;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.st.common.CommonUtil;
import com.st.higherauthoritydecision.service.HigherAuthorityDecisionService;
import com.st.higherauthoritydecision.mailer.HigherAutorityDecisionMailer;
import com.st.higherauthoritydecision.model.*;
//import com.sun.org.apache.xpath.internal.operations.Mod;




/**
 * @author roshan
 *
 */
@Controller
@RequestMapping("/higherauthoritydecision")
public class HigherAuthorityDecisionController {

	@Autowired
	private HigherAuthorityDecisionService higherauthoritydecisionservice;
	
	@Autowired
	private HigherAutorityDecisionMailer higherautoritydecisionmailer; 
	
	@RequestMapping(value="/apply")
	public String detail(HttpServletRequest request,HttpServletResponse response, Model model) throws IOException{
		
		List<HigherAuthorityDecision> data=higherauthoritydecisionservice.getdata();
		
		System.out.println(data);
		
		String otp=""; 
		int length = 6;
	    boolean useLetters = true;
	    boolean useNumbers = true;
	    otp = RandomStringUtils.random(length, useLetters, useNumbers);
	 
	    String status="";
	    
		for(HigherAuthorityDecision lst:data){
			if(lst.getStatus().equalsIgnoreCase("Allow")){
				higherautoritydecisionmailer.getPermissionAndMail("Block",otp);
				status=lst.getStatus();
			}else{
				higherautoritydecisionmailer.getPermissionAndMail("Allow",otp);
				status=lst.getStatus();
			}
		}
		
		model.addAttribute("otp", otp);
		model.addAttribute("status", status);
		model.addAttribute("msg", "An email was sent to you.Please enter OTP here.");
		return "authoritydecisionView";
	}
	@RequestMapping(value="/apply/action/now",method=RequestMethod.POST)
	public String applyAction(HttpServletRequest request,HttpServletResponse response,Model model) throws IOException {
		
		try{
			String otp2=CommonUtil.checkNull(request.getParameter("otp2"));
			String status=CommonUtil.checkNull(request.getParameter("status"));
			
			System.out.println(otp2);
			System.out.println(status);
			
			List<HigherAuthorityDecision> data=null;
			String status2="";
			int id=0;
			try{
				data=higherauthoritydecisionservice.getdata(1);
				for(HigherAuthorityDecision lst:data){
					status2=lst.getStatus();
					id=lst.getId();
				}
			}catch(Exception rlt1){
				rlt1.printStackTrace();
			}
			
			if(status!=status2){
				HigherAuthorityDecision had=new HigherAuthorityDecision();
				had.setStatus(status);
				had.setId(id);
				
				higherauthoritydecisionservice.updateStatusForMails(had);
				higherautoritydecisionmailer.getInformToTechnicalTeam(status);
			}else{
				
			}
		}catch(Exception rlt){
			rlt.printStackTrace();
		}
		model.addAttribute("showalert", true);
		model.addAttribute("otp", "");
		model.addAttribute("status", "");
		model.addAttribute("msg", "Please wait we are redirecting you at home page.");
		return "authoritydecisionView";
		
	}
	
}

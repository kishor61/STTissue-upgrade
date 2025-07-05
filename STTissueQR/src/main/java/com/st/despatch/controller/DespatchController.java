/**
 *Jan 12, 2018
 *DespatchController.java
 * TODO
 *com.st.despatch.controller
 *DespatchController.java
 *Roshan Lal Tailor
 */
package com.st.despatch.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.st.common.CommonUtil;
import com.st.common.exception.ProductionException;
import com.st.despatch.automailer.DespatchAutoMailer;
import com.st.despatch.model.Despatch;
import com.st.despatch.service.DespatchService;

/**
 * @author roshan
 *
 */
@Controller
@RequestMapping("/despatch")
public class DespatchController {

	private SimpleDateFormat dateFormat=new SimpleDateFormat("MM-dd-yyyy");
	
	@Autowired
	private DespatchService despatchService;
	
	@Autowired
	private DespatchAutoMailer despatchAutoMailer;
	
	@RequestMapping(value="/view",method=RequestMethod.GET)
	public String view(Model model) {
		
		model.addAttribute("sdate", dateFormat.format(CommonUtil.getFirstDate(new Date())));
		
		return "despatch/despatchreport";
	}
	
	@RequestMapping(value="/view/report",method=RequestMethod.GET)
	public String viewReport(@RequestParam("sdate")String sdate,Model model) {
		Date sDate=CommonUtil.checkDate(sdate, dateFormat);
		
		List<Despatch> datas=despatchService.getDespatchData(sDate,"BN");
		
		model.addAttribute("sdate", dateFormat.format(sDate));
		model.addAttribute("datas", datas);
		
		System.out.println(datas.size());
		return "despatch/despatchreport";
	}
	@RequestMapping(value="/view/report/email",method=RequestMethod.POST)
	public @ResponseBody boolean mailDataGradeAndHours(HttpServletRequest request,HttpServletResponse response,Model model) throws ProductionException, IOException {
		try {
			Date sdate=CommonUtil.checkDate(request.getParameter("sdate"), dateFormat);
			
			despatchAutoMailer.sendDespatchMail(sdate,"BN");
			despatchAutoMailer.sendDespatchMail(sdate,"WH");
			
			//Code For WH
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}

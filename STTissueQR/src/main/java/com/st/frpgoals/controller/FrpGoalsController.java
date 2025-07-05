/**
 *Dec 11, 2015
 *FrpCostOptimization.java
 * TODO
 *com.st.frpcostoptimization
 *FrpCostOptimization.java
 *Sunil Singh Bora
 */
package com.st.frpgoals.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

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

import com.st.common.CommonUtil;
import com.st.frpgoals.model.FrpGoals;
import com.st.frpgoals.service.FrpGoalsService;
import com.st.wastepaper.comman.WastepaperComman;
import com.st.wastepaper.model.WastePaperBaleInventory;
import com.st.wastepaper.model.WastepaperDetail;

/**
 * @author sbora
 *
 */
@Controller
@RequestMapping("/frpcostoptimization")
public class FrpGoalsController {
		
	private SimpleDateFormat dateFormat=new SimpleDateFormat("MM-dd-yyyy");
	private SimpleDateFormat dayFormat=new SimpleDateFormat("dd");
	
	@Autowired
	private FrpGoalsService frpGoalsService;
	
	
	
	@RequestMapping(value="/view",method=RequestMethod.GET)
	public String view(HttpServletResponse response,HttpServletRequest request,Model model){
		FrpGoals frpGoals=new FrpGoals();
		frpGoals.setSdateTmp(dateFormat.format(new Date()));
		frpGoals.setEdateTmp(dateFormat.format(new Date()));	
		model.addAttribute("frpGoals",frpGoals);
		
		return"frpGoalsEntry";
	}
	
	
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String save(@ModelAttribute("frpGoals")FrpGoals frpGoals,Model model,RedirectAttributes redirectAttributes){
		model.addAttribute("frpGoals",frpGoals);
		frpGoalsService.saveOrUpdate(frpGoals);
		redirectAttributes.addFlashAttribute("message", "Data saved successfully.");
		//return"frpGoalsEntry";
		return "redirect:/frpcostoptimization/view";
	}
	@RequestMapping(value="/report",method=RequestMethod.GET)
	public String report(HttpServletResponse response,HttpServletRequest request,Model model){
		
		model.addAttribute("dateS",dateFormat.format(CommonUtil.getFirstDate()));
		model.addAttribute("view", false);
		return"frpGoalsReport";
	}
	@RequestMapping(value="/report/view",method=RequestMethod.GET)
	public String wastepaperDetailView(@RequestParam("dateS")String sdate,Model model) throws ParseException {
		SimpleDateFormat monthFormat = new SimpleDateFormat("MM");
		SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");
		System.out.println("We Are Here..");
		
		
		Date date=dateFormat.parse(sdate);
		int month=0;
		int year=0; 
		List<FrpGoals> details=null;
		List<FrpGoals> frpConsumedBale=null;
		Date currentMonthSDate =null;
		Date currentMonthLDate =null;
		try {
			
			String monthS=monthFormat.format(date);
			String yearS=yearFormat.format(date);
			
			month = Integer.parseInt(monthS);
			year= Integer.parseInt(yearS);
			
			details=frpGoalsService.getFrpGoalsData(month,year);
			
			
			Calendar cal = Calendar.getInstance();
	        cal.setTime(date);
			cal.add(Calendar.MONTH, 0);
	        cal.set(Calendar.DATE, 1);
			currentMonthSDate = cal.getTime();
			cal.set(Calendar.DATE,cal.getActualMaximum(Calendar.DAY_OF_MONTH));
			
			
			currentMonthLDate = cal.getTime();
			cal.set(Calendar.DATE,cal.getActualMinimum(Calendar.DAY_OF_MONTH));
			
			System.out.println("currentMonthSDate::"+dateFormat.format(currentMonthSDate));
			System.out.println("currentMonthLDate::"+dateFormat.format(currentMonthLDate));
			
			frpConsumedBale=frpGoalsService.getConsumedData(currentMonthSDate,currentMonthLDate);
		
		} catch (Exception rlt) {
			rlt.printStackTrace();
		}
		model.addAttribute("view", true);
		model.addAttribute("details", details);
		model.addAttribute("sdate", dateFormat.format(currentMonthSDate));
		model.addAttribute("edate", dateFormat.format(currentMonthLDate));
		model.addAttribute("frpConsumedWeight", frpConsumedBale);
		model.addAttribute("dateS", sdate);
		return "frpGoalsReport";
	}
}

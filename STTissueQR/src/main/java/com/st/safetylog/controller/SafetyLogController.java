/**
 * 
 */
package com.st.safetylog.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.google.gson.Gson;
import com.st.common.CommonUtil;
import com.st.safetylog.model.SafetyLog;
import com.st.safetylog.service.SafetyLogService;

/**
 * @author sbora
 *
 */
@Controller
@RequestMapping("/safetylog")
public class SafetyLogController {

	private SimpleDateFormat dateFormat=new SimpleDateFormat("MM-dd-yyyy");
	
	
	@Autowired
	private SafetyLogService safetyLogService;
	
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}
	
	
	@RequestMapping(value="/view" ,method=RequestMethod.GET)
	public String view(Model model) {
		
		model.addAttribute("sdate", dateFormat.format(new Date()));
		model.addAttribute("edate", dateFormat.format(new Date()));
		
		return "safetylog/safetyLogView";
	}
	
	@RequestMapping(value="/add" ,method=RequestMethod.GET)
	public String add(Model model) {
		SafetyLog safetyLog=new SafetyLog();
		safetyLog.setDate(new Date());
		safetyLog.setIncidentDate(new Date());
		model.addAttribute("safetyLog",safetyLog);
		
		return "safetylog/safetyLogNew";
	}
	
	@RequestMapping(value="/edit/{id}" ,method=RequestMethod.GET)
	public String edit(@PathVariable("id")int id,Model model) {
		SafetyLog safetyLog=safetyLogService.getSafetyLog(id);
		model.addAttribute("safetyLog",safetyLog);
		
		return "safetylog/safetyLogNew";
	}
	
	@RequestMapping(value="/edit/review/{id}" ,method=RequestMethod.GET)
	public String editReviewClose(@PathVariable("id")int id,Model model) {
		SafetyLog safetyLog=safetyLogService.getSafetyLog(id);
		if(safetyLog.getDayToCompletion()==null){
			safetyLog.setDayToCompletion(new Date());
		}
		model.addAttribute("safetyLog",safetyLog);
		
		return "safetylog/safetyLogReviewClose";
	}
	
	
	@RequestMapping(value="/save" ,method=RequestMethod.POST)
	public String save(@ModelAttribute("safetyLog")SafetyLog safetyLog,RedirectAttributes redirectAttributes,Model model) {
		
		model.addAttribute("safetyLog",safetyLog);
		
		if(StringUtils.isEmpty(safetyLog.getDescription())){
			return "safetylog/safetyLogNew";
		}
		
		try {
			safetyLogService.saveOrUpdate(safetyLog);
		} catch (Exception e) {
			model.addAttribute("error","Fail to save data in database. Error message:-"+e.getMessage());
			return "safetylog/safetyLogNew";
		}
		
		if(safetyLog.getId()>0){
			model.addAttribute("message", "Data updated successfully.");
			return "safetylog/safetyLogNew";
			
		}else{
			redirectAttributes.addFlashAttribute("message", "Data saved successfully.");
			return "redirect:/safetylog/add";
		}
	}
	
	@RequestMapping(value="/save/review" ,method=RequestMethod.POST)
	public String saveReview(HttpServletRequest request,RedirectAttributes redirectAttributes,Model model) {
		
		Date date=CommonUtil.checkDate(request.getParameter("dayToCompletion"), dateFormat);
		int id=CommonUtil.checkInt(request.getParameter("id"));
		
		try {
			safetyLogService.updateSafetyLogReview(id,date);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error","Fail to save data in database. Error message:-"+e.getMessage());
			return "redirect:/safetylog/edit/review/"+id;
		}
		
		redirectAttributes.addFlashAttribute("message", "Data updated successfully.");
		return "redirect:/safetylog/edit/review/"+id;
	}
	
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	public void delete(HttpServletRequest request,HttpServletResponse response) throws IOException {
		
		
		int id=CommonUtil.checkInt(request.getParameter("id"));
		
		
		Map<String, Object>	 map=new HashMap<>();
		try {
			safetyLogService.delete(id);
			map.put("flag", true);
		} catch (Exception e) {
			map.put("flag", false);
			map.put("flag", "Cannot delete! Error Message:-"+e.getMessage());
		}


		response.setContentType("application/json");
		
		response.getWriter().write(new Gson().toJson(map));
	}
	
	@RequestMapping(value="/close",method=RequestMethod.POST)
	public void closeLog(HttpServletRequest request,HttpServletResponse response) throws IOException {
		
		
		int id=CommonUtil.checkInt(request.getParameter("id"));
		
		
		Map<String, Object>	 map=new HashMap<>();
		try {
			
			SafetyLog safetyLog=safetyLogService.getSafetyLog(id);
			
			safetyLogService.closeLog(safetyLog);
			map.put("flag", true);
		} catch (Exception e) {
			map.put("flag", false);
			map.put("flag", "Cannot close! Error Message:-"+e.getMessage());
		}


		response.setContentType("application/json");
		
		response.getWriter().write(new Gson().toJson(map));
	}
	
	@RequestMapping(value="/reset",method=RequestMethod.POST)
	public void resetLog(HttpServletRequest request,HttpServletResponse response) throws IOException {
		
		
		int id=CommonUtil.checkInt(request.getParameter("id"));
		
		
		Map<String, Object>	 map=new HashMap<>();
		try {
			
			SafetyLog safetyLog=safetyLogService.getSafetyLog(id);
			
			safetyLogService.resetLog(safetyLog);
			map.put("flag", true);
		} catch (Exception e) {
			map.put("flag", false);
			map.put("flag", "Cannot reset! Error Message:-"+e.getMessage());
		}


		response.setContentType("application/json");
		
		response.getWriter().write(new Gson().toJson(map));
	}
}

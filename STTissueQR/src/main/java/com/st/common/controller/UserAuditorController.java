/**
 * 
 */
package com.st.common.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.st.common.CommonUtil;
import com.st.common.model.UserAuditor;
import com.st.common.service.UserAuditorService;

/**
 * @author sbora
 *
 */
@Controller
@RequestMapping("/auditor")
public class UserAuditorController {
	
	@Autowired
	private UserAuditorService userAuditorService;
	
	@RequestMapping("/manage")
	public String manage(Model model) {
		
		UserAuditor auditor=new UserAuditor();
		model.addAttribute("auditor", auditor);
		
		List<UserAuditor> auditors=userAuditorService.getUserAutiors();
		model.addAttribute("auditors", auditors);
		//model.addAttribute("status",WastepaperComman.getStatus());
		return "common/manageAuditor";
	}
	
	@RequestMapping("/edit/{id}")
	public String edit(@PathVariable("id")int id,Model model) {
		
		UserAuditor auditor=userAuditorService.getUserAuditor(id);
		model.addAttribute("auditor", auditor);
		
		List<UserAuditor> auditors=userAuditorService.getUserAutiors();
		//model.addAttribute("status",WastepaperComman.getStatus());
		model.addAttribute("auditors", auditors);
		
		return "common/manageAuditor";
	}
	@PostMapping("/edit/status")
	public @ResponseBody Map<String , Object> save(jakarta.servlet.http.HttpServletRequest request, jakarta.servlet.http.HttpServletResponse response) throws IOException{
		Map<String , Object> map=new HashMap<String,Object>();
		try{
			String _email=request.getParameter("email");
			String _status=request.getParameter("status");
			
			UserAuditor data=new UserAuditor();
			data.setEmail(_email);
			data.setStatus(_status);
			
			userAuditorService.editAuditorStatus(data);
			map.put("status", true);
			map.put("message", "Data Saved Successfully.");
			
		}catch(Exception rlt){
			System.out.println("Roshan Says, You Have Problem In /addtomaster Method in WastePaperReportController.java");
			rlt.printStackTrace();
		}
		return map;
	}
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String save(@ModelAttribute("auditor")UserAuditor auditor,
			RedirectAttributes redirectAttributes,
			Model model) {
		
		List<UserAuditor> auditors=userAuditorService.getUserAutiors();
		model.addAttribute("auditors", auditors);
		
		model.addAttribute("auditor", auditor);
		
		if(StringUtils.isEmpty(auditor.getName())){
			model.addAttribute("error", "Please enter auditor name!");
			return "common/manageAuditor";
		}
		
		if(StringUtils.isEmpty(auditor.getEmail())){
			model.addAttribute("error", "Please enter email!");
			return "common/manageAuditor";
		}
		
	//	System.out.println(CommonUtil.isValidEmail(auditor.getEmail()));
	
		if(auditor.getEmail().isBlank()){
			model.addAttribute("error", "Please enter valid email!");
			return "common/manageAuditor";
		}
		
		try {
			userAuditorService.saveOrUpdate(auditor);
		} catch (Exception e) {
			model.addAttribute("error", "Failed to save data. Error:-"+e.getMessage());
			return "common/manageAuditor";
		}
		
		if(auditor.getId()==0){
			redirectAttributes.addFlashAttribute("message", "Data saved in database successfully.");
			return "redirect:/auditor/manage";
		}else{
			redirectAttributes.addFlashAttribute("message", "Data updated in database successfully.");
			return "redirect:/auditor/edit/"+auditor.getId();
		}
		
		
	}
}

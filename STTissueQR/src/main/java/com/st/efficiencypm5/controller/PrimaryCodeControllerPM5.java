/**
 * 
 */
package com.st.efficiencypm5.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.st.efficiencypm5.model.PrimaryCodePM5;
import com.st.efficiencypm5.service.EfficiencyCodeServicePM5;

/**
 * @author sbora
 *
 */
@Controller
@RequestMapping(value="/pm5effprimarycode")
public class PrimaryCodeControllerPM5 {
	
	private static Logger logger=LoggerFactory.getLogger(PrimaryCodeControllerPM5.class);

	@Autowired
	private EfficiencyCodeServicePM5 efficencyCodeService;
	
	@RequestMapping(value="/main",method=RequestMethod.GET)
	public String home(Model model) {
		
		model.addAttribute("primaryCode", new PrimaryCodePM5());
		model.addAttribute("codes", efficencyCodeService.getPrimaryCodes());
		
		return "PM5/efficiencyPrimaryCode";
	}
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String save(@ModelAttribute("primaryCode")PrimaryCodePM5 primaryCode,
			RedirectAttributes attributes,
			Model model) {
		
		try {
			if(primaryCode!=null && !(primaryCode.getCode().trim()).equals("")){
				if(primaryCode.getId()==0){
					int id=efficencyCodeService.add(primaryCode);
					logger.info("New Primary code created with id="+id);
				}else{
					efficencyCodeService.update(primaryCode);
					logger.info("Primary code updated with id="+primaryCode.getId());
				}
				
			}else{
				throw new Exception("Invalid primary code");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("error", "Invalid primary code");
			model.addAttribute("primaryCode", primaryCode);
			model.addAttribute("codes", efficencyCodeService.getPrimaryCodes());
			
			return "PM5/efficiencyPrimaryCode";
		}
		
		if(primaryCode.getId()==0){
			attributes.addFlashAttribute("message", "Primary code added successfully.");
		}else{
			attributes.addFlashAttribute("message", "Primary code updated successfully.");
		}
		
		return "redirect:/pm5effprimarycode/main";
	}
	
	@RequestMapping(value="/delete/{id}",method=RequestMethod.GET)
	public String delete(@PathVariable("id")int id,
			RedirectAttributes attributes,
			Model model) {
		
		if(id!=0){
			PrimaryCodePM5 code=new PrimaryCodePM5();
			code.setId(id);
			efficencyCodeService.delete(code);
		}
		
		attributes.addFlashAttribute("message", "Primary code deleted successfully.");
		
		return "redirect:/pm5effprimarycode/main";
	}
	
	@RequestMapping(value="/edit/{id}",method=RequestMethod.GET)
	public String edit(@PathVariable("id")int id,
			RedirectAttributes attributes,
			Model model) {
		if(id!=0){
			model.addAttribute("primaryCode", efficencyCodeService.getPrimaryCode(id));
			model.addAttribute("codes", efficencyCodeService.getPrimaryCodes());
		}
		
		return "PM5/efficiencyPrimaryCode";
	}
	
	
}

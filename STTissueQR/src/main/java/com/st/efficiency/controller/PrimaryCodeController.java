/**
 * 
 */
package com.st.efficiency.controller;

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

import com.st.efficiency.model.PrimaryCode;
import com.st.efficiency.service.EfficiencyCodeService;

/**
 * @author sbora
 *
 */
@Controller
@RequestMapping(value="/effprimarycode")
public class PrimaryCodeController {
	
	private static Logger logger=LoggerFactory.getLogger(PrimaryCodeController.class);

	@Autowired
	private EfficiencyCodeService efficencyCodeService;
	
	@RequestMapping(value="/main",method=RequestMethod.GET)
	public String home(Model model) {
		
		model.addAttribute("primaryCode", new PrimaryCode());
		model.addAttribute("codes", efficencyCodeService.getPrimaryCodes());
		
		return "efficiencyPrimaryCode";
	}
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String save(@ModelAttribute("primaryCode")PrimaryCode primaryCode,
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
			
			return "efficiencyPrimaryCode";
		}
		
		if(primaryCode.getId()==0){
			attributes.addFlashAttribute("message", "Primary code added successfully.");
		}else{
			attributes.addFlashAttribute("message", "Primary code updated successfully.");
		}
		
		return "redirect:/effprimarycode/main";
	}
	
	@RequestMapping(value="/delete/{id}",method=RequestMethod.GET)
	public String delete(@PathVariable("id")int id,
			RedirectAttributes attributes,
			Model model) {
		
		if(id!=0){
			PrimaryCode code=new PrimaryCode();
			code.setId(id);
			efficencyCodeService.delete(code);
		}
		
		attributes.addFlashAttribute("message", "Primary code deleted successfully.");
		
		return "redirect:/effprimarycode/main";
	}
	
	@RequestMapping(value="/edit/{id}",method=RequestMethod.GET)
	public String edit(@PathVariable("id")int id,
			RedirectAttributes attributes,
			Model model) {
		if(id!=0){
			model.addAttribute("primaryCode", efficencyCodeService.getPrimaryCode(id));
			model.addAttribute("codes", efficencyCodeService.getPrimaryCodes());
		}
		
		return "efficiencyPrimaryCode";
	}
	
	
}

/**
 * 
 */
package com.st.frpefficiency.controller;

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

import com.st.frpefficiency.model.FrpPrimaryCode;
import com.st.frpefficiency.service.FrpEfficiencyCodeService;

/**
 * @author sbora
 *
 */
@Controller
@RequestMapping(value="/frpeffprimarycode")
public class FrpPrimaryCodeController {
	
	private static Logger logger=LoggerFactory.getLogger(FrpPrimaryCodeController.class);

	@Autowired
	private FrpEfficiencyCodeService frpEfficiencyCodeService;
	
	@RequestMapping(value="/main",method=RequestMethod.GET)
	public String home(Model model) {
		
		model.addAttribute("primaryCode", new FrpPrimaryCode());
		model.addAttribute("codes", frpEfficiencyCodeService.getPrimaryCodes());
		
		return "frpEfficiencyPrimaryCode";
	}
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String save(@ModelAttribute("primaryCode")FrpPrimaryCode primaryCode,
			RedirectAttributes attributes,
			Model model) {
		
		try {
			if(primaryCode!=null && !(primaryCode.getCode().trim()).equals("")){
				if(primaryCode.getId()==0){
					int id=frpEfficiencyCodeService.add(primaryCode);
					logger.info("New Primary code created with id="+id);
				}else{
					frpEfficiencyCodeService.update(primaryCode);
					logger.info("Primary code updated with id="+primaryCode.getId());
				}
				
			}else{
				throw new Exception("Invalid primary code");
			}
			
		} catch (Exception e) {

			model.addAttribute("error", "Invalid primary code");
			model.addAttribute("primaryCode", primaryCode);
			model.addAttribute("codes", frpEfficiencyCodeService.getPrimaryCodes());
			
			return "frpEfficiencyPrimaryCode";
		}
		
		if(primaryCode.getId()==0){
			attributes.addFlashAttribute("message", "Primary code added successfully.");
		}else{
			attributes.addFlashAttribute("message", "Primary code updated successfully.");
		}
		
		return "redirect:/frpeffprimarycode/main";
	}
	
	@RequestMapping(value="/delete/{id}",method=RequestMethod.GET)
	public String delete(@PathVariable("id")int id,
			RedirectAttributes attributes,
			Model model) {
		
		if(id!=0){
			FrpPrimaryCode code=new FrpPrimaryCode();
			code.setId(id);
			frpEfficiencyCodeService.delete(code);
		}
		
		attributes.addFlashAttribute("message", "Primary code deleted successfully.");
		
		return "redirect:/frpeffprimarycode/main";
	}
	
	@RequestMapping(value="/edit/{id}",method=RequestMethod.GET)
	public String edit(@PathVariable("id")int id,
			RedirectAttributes attributes,
			Model model) {
		if(id!=0){
			model.addAttribute("primaryCode", frpEfficiencyCodeService.getPrimaryCode(id));
			model.addAttribute("codes", frpEfficiencyCodeService.getPrimaryCodes());
		}
		
		return "frpEfficiencyPrimaryCode";
	}
	
	
}

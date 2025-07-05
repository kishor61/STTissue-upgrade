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
import com.st.efficiencypm5.model.SecondaryCodePM5;
import com.st.efficiencypm5.service.EfficiencyCodeServicePM5;


/**
 * @author sbora
 *
 */
@Controller
@RequestMapping(value="/pm5effsecondarycode")
public class SecondaryCodeControllerPM5 {
	private static Logger logger=LoggerFactory.getLogger(SecondaryCodeControllerPM5.class);
	@Autowired
	private EfficiencyCodeServicePM5 efficencyCodeService;
	
	@RequestMapping(value="/main",method=RequestMethod.GET)
	public String home(Model model) {
		
		model.addAttribute("secondaryCode", new SecondaryCodePM5());
		model.addAttribute("codes", efficencyCodeService.getSecondaryCodes());
		model.addAttribute("primaryCodes", efficencyCodeService.getPrimaryCodes());
		
		return "PM5/efficiencySecodaryCode";
	}
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String save(@ModelAttribute("secondaryCode")SecondaryCodePM5 secondaryCode,
			RedirectAttributes attributes,
			Model model) {
		
		try {
			if(secondaryCode!=null && !(secondaryCode.getCode().trim()).equals("")){
				if(secondaryCode.getId()==0){
					// Insert
					int id=efficencyCodeService.add(secondaryCode);
					logger.info("New Secodary code created with id="+id);
				}else{
					// Update
					efficencyCodeService.update(secondaryCode);
					logger.info("Secodary code updated with id="+secondaryCode.getId());
				}
			}else{
				throw new Exception("Invalid secondary code.");
			}
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("error", "Invalid secodary code");
			model.addAttribute("secondaryCode", new SecondaryCodePM5());
			model.addAttribute("codes", efficencyCodeService.getSecondaryCodes());
			model.addAttribute("primaryCodes", efficencyCodeService.getPrimaryCodes());
			return "PM5/efficiencySecodaryCode";
		}
		
		
		if(secondaryCode.getId()==0){
			attributes.addFlashAttribute("message", "Secodary code added successfully.");
		}else{
			attributes.addFlashAttribute("message", "Secodary code updated successfully.");
		}
		return "redirect:/pm5effsecondarycode/main";
	}
	
	@RequestMapping(value="/delete/{id}",method=RequestMethod.GET)
	public String delete(@PathVariable("id")int id,
			RedirectAttributes attributes,
			Model model) {
		
		if(id!=0){
			SecondaryCodePM5 code=new SecondaryCodePM5();
			code.setId(id);
			efficencyCodeService.delete(code);
		}
		
		attributes.addFlashAttribute("message", "Secodary code deleted successfully.");
		
		return "redirect:/pm5effsecondarycode/main";
	}
	
	@RequestMapping(value="/edit/{id}",method=RequestMethod.GET)
	public String edit(@PathVariable("id")int id,
			RedirectAttributes attributes,
			Model model) {
		if(id!=0){
			model.addAttribute("secondaryCode", efficencyCodeService.getSecondaryCode(id));
			model.addAttribute("codes", efficencyCodeService.getSecondaryCodes());
			model.addAttribute("primaryCodes", efficencyCodeService.getPrimaryCodes());
		}
		
		return "PM5/efficiencySecodaryCode";
	}
	
	@RequestMapping(value="/view/{id}",method=RequestMethod.GET)
	public String view(@PathVariable("id")int id,
			Model model) {
		
		model.addAttribute("secondaryCode", new SecondaryCodePM5());
		
		if(id!=0){
			PrimaryCodePM5 primaryCode=new PrimaryCodePM5();
			primaryCode.setId(id);
			model.addAttribute("codes", efficencyCodeService.getSecondaryCodes(primaryCode));	
		}else{
			model.addAttribute("codes", efficencyCodeService.getSecondaryCodes());
		}
		
		model.addAttribute("primaryCodes", efficencyCodeService.getPrimaryCodes());
		
		return "PM5/efficiencySecodaryCode";
	}
}

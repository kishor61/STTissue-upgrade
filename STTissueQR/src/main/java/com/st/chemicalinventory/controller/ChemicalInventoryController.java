/**
 * 
 */
package com.st.chemicalinventory.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.google.gson.Gson;
import com.st.chemicalinventory.model.Chemical;
import com.st.chemicalinventory.model.ChemicalCode;
import com.st.chemicalinventory.model.ChemicalData;
import com.st.chemicalinventory.model.ChemicalPrimaryCode;
import com.st.chemicalinventory.model.ChemicalSecondaryCode;
import com.st.chemicalinventory.service.ChemicalInventoryService;
import com.st.common.CommonUtil;

/**
 * @author sbora
 *
 */
@Controller
@RequestMapping(value="/chemicalinv")
public class ChemicalInventoryController {
	
	
	@Autowired
	private ChemicalInventoryService chemicalInventoryService;
	
	SimpleDateFormat dateFormat=new SimpleDateFormat("MM-dd-yyyy");
	
	@RequestMapping(value="/primary/manage",method=RequestMethod.GET)
	public String managePrimaryCode(Model model) {
		
		ChemicalPrimaryCode chemicalPrimaryCode=new ChemicalPrimaryCode();
		model.addAttribute("chemicalPrimaryCode", chemicalPrimaryCode);
			
		List<ChemicalPrimaryCode> chemicalPrimaryCodes=chemicalInventoryService.getChemicalPrimaryCodes();
		model.addAttribute("chemicalPrimaryCodes", chemicalPrimaryCodes);
		
		return "chemicalinventory/managePrimaryCode";
	}
	@RequestMapping(value="/primary/edit/{id}",method=RequestMethod.GET)
	public String editPrimaryCode(@PathVariable("id")int id,Model model) {
		
		ChemicalPrimaryCode chemicalPrimaryCode=chemicalInventoryService.getChemicalPrimaryCode(id);
		model.addAttribute("chemicalPrimaryCode", chemicalPrimaryCode);
			
		List<ChemicalPrimaryCode> chemicalPrimaryCodes=chemicalInventoryService.getChemicalPrimaryCodes();
		model.addAttribute("chemicalPrimaryCodes", chemicalPrimaryCodes);
		
		return "chemicalinventory/managePrimaryCode";
	}
	
	@RequestMapping(value="/primary/delete/{id}",method=RequestMethod.GET)
	public String deletePrimaryCode(@PathVariable("id")int id,Model model) {
		
		chemicalInventoryService.deletePrimaryCode(id);
			
		List<ChemicalPrimaryCode> chemicalPrimaryCodes=chemicalInventoryService.getChemicalPrimaryCodes();
		model.addAttribute("chemicalPrimaryCodes", chemicalPrimaryCodes);
		
		return "redirect:/chemicalinv/primary/manage";
	}
	
	@RequestMapping(value="/primary/save",method=RequestMethod.POST)
	public String savePrimaryCode(@ModelAttribute("chemicalPrimaryCode")ChemicalPrimaryCode chemicalPrimaryCode,
			RedirectAttributes attributes,
			Model model) {
		List<ChemicalPrimaryCode> chemicalPrimaryCodes=chemicalInventoryService.getChemicalPrimaryCodes();
		model.addAttribute("chemicalPrimaryCodes", chemicalPrimaryCodes);
		model.addAttribute("chemicalPrimaryCode", chemicalPrimaryCode);
		
		if(StringUtils.isEmpty(chemicalPrimaryCode.getName())){
			model.addAttribute("error", "Please enter primary code.");
			return "chemicalinventory/managePrimaryCode";
		}else{
			try {
				
				chemicalInventoryService.saveOrUpdate(chemicalPrimaryCode);
				
			} catch (Exception e) {
				model.addAttribute("error", "Fail to save code.Try another code.");
				return "chemicalinventory/managePrimaryCode";
			}
		}
		
		if(chemicalPrimaryCode.getId()==0){
			attributes.addFlashAttribute("message","Data saved successfully.");
		}else{
			attributes.addFlashAttribute("message","Data updated successfully.");
		}
		
		return "redirect:/chemicalinv/primary/manage";
	}
	
	
	
	
	
	@RequestMapping(value="/secondary/manage",method=RequestMethod.GET)
	public String manageSecondaryCode(Model model) {
		
		ChemicalSecondaryCode chemicalSecondaryCode=new ChemicalSecondaryCode();
		model.addAttribute("chemicalSecondaryCode", chemicalSecondaryCode);
			
		List<ChemicalPrimaryCode> chemicalPrimaryCodes=chemicalInventoryService.getChemicalPrimaryCodes();
		model.addAttribute("chemicalPrimaryCodes", chemicalPrimaryCodes);
		
		List<ChemicalSecondaryCode> chemicalSecondaryCodes=chemicalInventoryService.getChemicalSecondaryCodes();
		model.addAttribute("chemicalSecondaryCodes", chemicalSecondaryCodes);
		
		
		return "chemicalinventory/manageSecondaryCode";
	}
	@RequestMapping(value="/secondary/edit/{id}",method=RequestMethod.GET)
	public String editSecondaryCode(@PathVariable("id")int id,Model model) {
		
		ChemicalSecondaryCode chemicalSecondaryCode=chemicalInventoryService.getChemicalSecondaryCode(id);
		model.addAttribute("chemicalSecondaryCode", chemicalSecondaryCode);
		
		
		List<ChemicalPrimaryCode> chemicalPrimaryCodes=chemicalInventoryService.getChemicalPrimaryCodes();
		model.addAttribute("chemicalPrimaryCodes", chemicalPrimaryCodes);
		
		List<ChemicalSecondaryCode> chemicalSecondaryCodes=chemicalInventoryService.getChemicalSecondaryCodes();
		model.addAttribute("chemicalSecondaryCodes", chemicalSecondaryCodes);
		
		return "chemicalinventory/manageSecondaryCode";
	}
	
	@RequestMapping(value="/secondary/delete/{id}",method=RequestMethod.GET)
	public String deleteSecondaryCode(@PathVariable("id")int id,Model model) {
		
		chemicalInventoryService.deleteSecondary(id);
			
		List<ChemicalPrimaryCode> chemicalPrimaryCodes=chemicalInventoryService.getChemicalPrimaryCodes();
		model.addAttribute("chemicalPrimaryCodes", chemicalPrimaryCodes);
		
		List<ChemicalSecondaryCode> chemicalSecondaryCodes=chemicalInventoryService.getChemicalSecondaryCodes();
		model.addAttribute("chemicalSecondaryCodes", chemicalSecondaryCodes);
		
		
		return "redirect:/chemicalinv/secondary/manage";
	}
	
	@RequestMapping(value="/secondary/save",method=RequestMethod.POST)
	public String saveSecondaryCode(@ModelAttribute("chemicalPrimaryCode")ChemicalSecondaryCode chemicalSecondaryCode,
			RedirectAttributes attributes,
			Model model) {
		
		List<ChemicalPrimaryCode> chemicalPrimaryCodes=chemicalInventoryService.getChemicalPrimaryCodes();
		model.addAttribute("chemicalPrimaryCodes", chemicalPrimaryCodes);
		
		model.addAttribute("chemicalSecondaryCode", chemicalSecondaryCode);
		
		
		List<ChemicalSecondaryCode> chemicalSecondaryCodes=chemicalInventoryService.getChemicalSecondaryCodes();
		model.addAttribute("chemicalSecondaryCodes", chemicalSecondaryCodes);
		
		
		if(StringUtils.isEmpty(chemicalSecondaryCode.getName())){
			model.addAttribute("error", "Please enter code.");
			return "chemicalinventory/manageSecondaryCode";
		}else{
			try {
				
				chemicalInventoryService.saveOrUpdate(chemicalSecondaryCode);
				
			} catch (Exception e) {
				model.addAttribute("error", "Fail to save code.Try another code.");
				return "chemicalinventory/manageSecondaryCode";
			}
		}
		
		if(chemicalSecondaryCode.getId()==0){
			attributes.addFlashAttribute("message","Data saved successfully.");
		}else{
			attributes.addFlashAttribute("message","Data updated successfully.");
		}
		
		return "redirect:/chemicalinv/secondary/manage";
	}
	
	
	
	
	
	@RequestMapping(value="/chemical/manage",method=RequestMethod.GET)
	public String manageChemical(Model model) {
		
		Chemical chemical=new Chemical();
		model.addAttribute("chemical", chemical);
			
		List<ChemicalSecondaryCode> chemicalSecondaryCodes=chemicalInventoryService.getChemicalSecondaryCodes();
		model.addAttribute("chemicalSecondaryCodes", chemicalSecondaryCodes);
		
		List<ChemicalCode> chemicalCodes=chemicalInventoryService.getChemicalCodes();
		model.addAttribute("chemicalCodes",chemicalCodes);
		
		List<Chemical> chemicals=chemicalInventoryService.getChemicals();
		model.addAttribute("chemicals", chemicals);
		
		
		return "chemicalinventory/manageChemical";
	}
	@RequestMapping(value="/chemical/edit/{id}",method=RequestMethod.GET)
	public String editChemical(@PathVariable("id")int id,Model model) {
		
		Chemical chemical=chemicalInventoryService.getChemical(id);
		model.addAttribute("chemical", chemical);
		
		List<ChemicalSecondaryCode> chemicalSecondaryCodes=chemicalInventoryService.getChemicalSecondaryCodes();
		model.addAttribute("chemicalSecondaryCodes", chemicalSecondaryCodes);
		
		List<ChemicalCode> chemicalCodes=chemicalInventoryService.getChemicalCodes();
		model.addAttribute("chemicalCodes",chemicalCodes);
		
		List<Chemical> chemicals=chemicalInventoryService.getChemicals();
		model.addAttribute("chemicals", chemicals);
		
		return "chemicalinventory/manageChemical";
	}
	
	@RequestMapping(value="/chemical/delete/{id}",method=RequestMethod.GET)
	public String deleteChemical(@PathVariable("id")int id,Model model) {
		
		chemicalInventoryService.deleteChemical(id);
			
		List<ChemicalSecondaryCode> chemicalSecondaryCodes=chemicalInventoryService.getChemicalSecondaryCodes();
		model.addAttribute("chemicalSecondaryCodes", chemicalSecondaryCodes);
		
		List<ChemicalCode> chemicalCodes=chemicalInventoryService.getChemicalCodes();
		model.addAttribute("chemicalCodes",chemicalCodes);
		
		List<Chemical> chemicals=chemicalInventoryService.getChemicals();
		model.addAttribute("chemicals", chemicals);
		
		return "redirect:/chemicalinv/chemical/manage";
	}
	
	@RequestMapping(value="/chemical/save",method=RequestMethod.POST)
	public String saveChemical(@ModelAttribute("chemical")Chemical chemical,
			RedirectAttributes attributes,
			Model model) {
		
		model.addAttribute("chemical", chemical);
		
		
		
		
		try {
			
			Chemical chOld=chemicalInventoryService.isChemicalExist(chemical.getSid(),chemical.getCid());
			if(chOld==null || chOld.getId()==chemical.getId()){
				chemicalInventoryService.saveOrUpdate(chemical);
			}else{
				if(chOld.isDeleted()){
					chemical.setDeleted(false);
					chemical.setId(chOld.getId());
					chemicalInventoryService.saveOrUpdate(chemical);
				}else{
					
					List<ChemicalSecondaryCode> chemicalSecondaryCodes=chemicalInventoryService.getChemicalSecondaryCodes();
					model.addAttribute("chemicalSecondaryCodes", chemicalSecondaryCodes);
					
					
					List<ChemicalCode> chemicalCodes=chemicalInventoryService.getChemicalCodes();
					model.addAttribute("chemicalCodes",chemicalCodes);
					
					List<Chemical> chemicals=chemicalInventoryService.getChemicals();
					model.addAttribute("chemicals", chemicals);
					
					model.addAttribute("error", "Already exist. Please try another code.");
					return "chemicalinventory/manageChemical";
				}
			}
			
			
			
		} catch (Exception e) {
			
			List<ChemicalSecondaryCode> chemicalSecondaryCodes=chemicalInventoryService.getChemicalSecondaryCodes();
			model.addAttribute("chemicalSecondaryCodes", chemicalSecondaryCodes);
			
			
			List<ChemicalCode> chemicalCodes=chemicalInventoryService.getChemicalCodes();
			model.addAttribute("chemicalCodes",chemicalCodes);
			
			List<Chemical> chemicals=chemicalInventoryService.getChemicals();
			model.addAttribute("chemicals", chemicals);
			
			
			model.addAttribute("error", "Fail to save chemical. Error:-"+e.getMessage());
			return "chemicalinventory/manageChemical";
		}
		
		if(chemical.getId()==0){
			attributes.addFlashAttribute("message","Data saved successfully.");
		}else{
			attributes.addFlashAttribute("message","Data updated successfully.");
		}
		
		return "redirect:/chemicalinv/chemical/manage";
	}
	
	
	
	
	@RequestMapping(value="/chemicalcode/manage",method=RequestMethod.GET)
	public String manageChemicalCode(Model model) {
		
		ChemicalCode chemicalCode=new ChemicalCode();
		model.addAttribute("chemicalCode", chemicalCode);
		
		List<ChemicalCode> chemicalCodes=chemicalInventoryService.getChemicalCodes();
		model.addAttribute("chemicalCodes", chemicalCodes);
		
		
		return "chemicalinventory/manageChemicalCode";
	}
	@RequestMapping(value="/chemicalcode/edit/{id}",method=RequestMethod.GET)
	public String editChemicalCode(@PathVariable("id")int id,Model model) {
		
		ChemicalCode chemicalCode=chemicalInventoryService.getChemicalCode(id);
		model.addAttribute("chemicalCode", chemicalCode);
		
		
		List<ChemicalCode> chemicalCodes=chemicalInventoryService.getChemicalCodes();
		model.addAttribute("chemicalCodes", chemicalCodes);
		
		return "chemicalinventory/manageChemicalCode";
	}
	
	@RequestMapping(value="/chemicalcode/delete/{id}",method=RequestMethod.GET)
	public String deleteChemicalCode(@PathVariable("id")int id,Model model) {
		
		chemicalInventoryService.deleteChemicalCode(id);
			
		List<ChemicalCode> chemicalCodes=chemicalInventoryService.getChemicalCodes();
		model.addAttribute("chemicalCodes", chemicalCodes);
		
		
		return "redirect:/chemicalinv/chemicalcode/manage";
	}
	
	@RequestMapping(value="/chemicalcode/save",method=RequestMethod.POST)
	public String saveChemicalCode(@ModelAttribute("chemicalPrimaryCode")ChemicalCode chemicalCode,
			RedirectAttributes attributes,
			Model model) {
		
		List<ChemicalCode> chemicalCodes=chemicalInventoryService.getChemicalCodes();
		model.addAttribute("chemicalCodes", chemicalCodes);
		
		model.addAttribute("chemicalCode", chemicalCode);


		if(StringUtils.isEmpty(chemicalCode.getCode())){
			model.addAttribute("error", "Please enter code.");
			return "chemicalinventory/manageChemicalCode";
		}else{
			try {
				
				chemicalInventoryService.saveOrUpdate(chemicalCode);
				
			} catch (Exception e) {
				e.printStackTrace();
				model.addAttribute("error", "Fail to save code.Try another code.");
				return "chemicalinventory/manageChemicalCode";
			}
		}
		
		if(chemicalCode.getId()==0){
			attributes.addFlashAttribute("message","Data saved successfully.");
		}else{
			attributes.addFlashAttribute("message","Data updated successfully.");
		}
		
		return "redirect:/chemicalinv/chemicalcode/manage";
	}
	


	@RequestMapping(value="/chemicaldata/new",method=RequestMethod.GET)
	public String manageChemicalData(Model model) {
		
		return "redirect:/chemicalinv/chemicaldata/new/"+dateFormat.format(new Date());
	}
	
	
	@RequestMapping(value="/chemicaldata/new/{date}",method=RequestMethod.GET)
	public String manageChemicalData(@PathVariable("date")String date,Model model) {
		
	
		List<Chemical> chemicals=chemicalInventoryService.getChemicals();
		model.addAttribute("chemicals", chemicals);
		
		model.addAttribute("date", date);
		model.addAttribute("entryId", CommonUtil.getUniqueID());
				
		return "chemicalinventory/chemicalData";
	}
	
	
	@RequestMapping(value="/chemicaldata/save",method=RequestMethod.POST)
	public void saveChemicalData(HttpServletRequest request,HttpServletResponse response) throws IOException {
		
		Map<String, Object> map=new HashMap<String, Object>();
		
		try {
			
		
			ChemicalData chemicalData=new ChemicalData();
			chemicalData.setId(CommonUtil.checkInt(request.getParameter("id")));
			chemicalData.setCid(CommonUtil.checkInt(request.getParameter("cid")));
			chemicalData.setDate(CommonUtil.checkDate(request.getParameter("date"), dateFormat));
			chemicalData.setEntryId(CommonUtil.checkNull(request.getParameter("entryId")));
			
			chemicalData.setConsumption(CommonUtil.checkDouble(request.getParameter("consumption")));
	
			
			if(chemicalData.getDate()==null){
				throw new Exception("Invalid date.");
			}
			
			if(StringUtils.isEmpty(chemicalData.getEntryId())){
				throw new Exception("Invalid requiest. Please refresh page.");
			}
			
			try {
				int id=chemicalInventoryService.saveOrUpdate(chemicalData);
				map.put("flag", true);
				map.put("id", id);
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception("Fail to save data in database. Error:-"+e.getMessage());
			}
		
			
			
		} catch (Exception e) {
			map.put("error", e.getMessage());
			map.put("flag", false);
		}
			
		response.setContentType("application/json");
		response.getWriter().write(new Gson().toJson(map));
	}
	
	
	

	@RequestMapping(value="/chemicaldata/edit/{date}/{entryId}",method=RequestMethod.GET)
	public String editChemicalData(@PathVariable("date")String date,
			@PathVariable("entryId")String entryId,
			HttpServletRequest request,
			Model model) {
		
	
		List<Chemical> chemicals=chemicalInventoryService.getChemicalData(CommonUtil.checkDate(date, dateFormat),entryId);
		model.addAttribute("chemicals", chemicals);
		
		model.addAttribute("date", date);
		model.addAttribute("entryId",entryId);
		model.addAttribute("backParam",request.getQueryString());
				
		return "chemicalinventory/chemicalDataEdit";
	}
	
	@RequestMapping(value="/chemicaldata/delete",method=RequestMethod.GET)
	public void deleteChemicalData(@RequestParam("date")String date,
			@RequestParam("entryId")String entryId,
			
			HttpServletResponse response) throws IOException {
		
		
		Map<String, Object> map=new HashMap<String, Object>();
		
		
		try {
			
			chemicalInventoryService.deleteChemicalData(CommonUtil.checkDate(date, dateFormat),entryId);
			
			map.put("flag", true);
		} catch (Exception e) {
			map.put("flag", false);
			map.put("error", "Server error:-"+e.getMessage());
			
		}
		
		
		response.setContentType("application/json");
		
		response.getWriter().write(new Gson().toJson(map));
		
		
	
	}
}

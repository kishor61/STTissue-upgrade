/**
 *Mar 2, 2016
 *TransferPricePerTonDataController.java
 * TODO
 *com.st.wastepaper.controller
 *TransferPricePerTonDataController.java
 *Sunil Singh Bora
 */
package com.st.wastepaper.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.st.common.CommonUtil;
import com.st.wastepaper.comman.WastepaperComman;
import com.st.wastepaper.model.WastePaperBaleInventory;
import com.st.wastepaper.model.WastepaperDetail;
import com.st.wastepaper.service.TransferPricePerTonDataService;
import com.st.wastepaper.service.WastepaperService;

/**
 * @author roshan
 *
 */
@Controller
@RequestMapping("/transferpricepertondata")
public class TransferPricePerTonDataController {

	
	@Autowired
	private TransferPricePerTonDataService transferpricepertondataservice;
	
	private SimpleDateFormat dateFormat=new SimpleDateFormat("MM-dd-yyyy");
	
	@RequestMapping(value="/view",method=RequestMethod.GET)
	public String wastepaperDetailView(Model model) {
		
		model.addAttribute("sdate", dateFormat.format(CommonUtil.getFirstDate(new Date())));
		model.addAttribute("edate", dateFormat.format(new Date()));
		model.addAttribute("view", false);
		return "productionWastepaper/TransferPricePerTonData";
	}
	@RequestMapping(value="/view/data",method=RequestMethod.GET)
	public String viewtranferabledata(@RequestParam("sdate")String sdate,@RequestParam("edate")String edate,Model model) {
		
		model.addAttribute("sdate", sdate);
		model.addAttribute("edate", edate);
		
		Date sDate=CommonUtil.checkDate(sdate, dateFormat);
		Date eDate=CommonUtil.checkDate(edate, dateFormat);
		List<WastepaperDetail> details=transferpricepertondataservice.getTransferAbleData(sDate,eDate);
		
		System.out.println("details:::"+details.size());
		model.addAttribute("details", details);
		model.addAttribute("view", true);
		return "productionWastepaper/TransferPricePerTonData";
	}
	@RequestMapping(value="/transfer/rlt",method=RequestMethod.GET)
	public String transferdata(@RequestParam("sdate")String sdate,@RequestParam("edate")String edate,Model model,RedirectAttributes redirectAttributes) {
		
		model.addAttribute("sdate", sdate);
		model.addAttribute("edate", edate);
		
		Date sDate=CommonUtil.checkDate(sdate, dateFormat);
		Date eDate=CommonUtil.checkDate(edate, dateFormat);
		List<WastepaperDetail> details=transferpricepertondataservice.getTransferAbleData(sDate,eDate);
		for(final WastepaperDetail detail:details){
			int key=transferpricepertondataservice.save(detail);
		}
		model.addAttribute("details", details);
		model.addAttribute("view", true);
		model.addAttribute("transferdone", true);
		//return "redirect:/transferpricepertondata/view"
		return "productionWastepaper/TransferPricePerTonDataSuccessfull";
	}
}

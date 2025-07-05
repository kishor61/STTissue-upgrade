/**
 *May 5, 2016
 *WetlapInventoryController.java
 * TODO
 *com.st.wetlapinventory.controller
 *WetlapInventoryController.java
 *Sunil Singh Bora
 */
package com.st.wetlapinventory.controller;

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
import com.st.wastepaper.comman.WastepaperComman;
import com.st.wastepaper.model.WastepaperDetail;
import com.st.wetlapinventory.model.WetlapInventory;
import com.st.wetlapinventory.service.WetlapInventoryService;

/**
 * @author roshan
 *
 */
@Controller
@RequestMapping("/wetlapinventory")
public class WetlapInventoryController {
	
	@Autowired
	private WetlapInventoryService wetlapInventoryService;
	
	@Autowired
	private com.st.wetlapinventory.report.WetlapInventoryAutoMailer wetlapinventoryautomailer;
	
	private SimpleDateFormat dateFormat=new SimpleDateFormat("MM-dd-yyyy");
	
	@RequestMapping(value="/view",method=RequestMethod.GET)
	public String view(Model model){
		
		model.addAttribute("sdate", dateFormat.format(CommonUtil.getFirstDate(new Date())));
		model.addAttribute("edate", dateFormat.format(new Date()));
		model.addAttribute("show", false);
		return "wetlapinventory/viewPage";
		
	}
	@RequestMapping(value="/view/report",method=RequestMethod.GET)
	public String report(@RequestParam("sdate")String sdate,@RequestParam("edate")String edate,Model model) {
		
		model.addAttribute("sdate", sdate);
		model.addAttribute("edate", edate);
		
		Date sDate=CommonUtil.checkDate(sdate, dateFormat);
		Date eDate=CommonUtil.checkDate(edate, dateFormat);
		
		List<WetlapInventory> frpDetails=wetlapInventoryService.getReportData();
		List<WetlapInventory> millDetails=wetlapInventoryService.getReportMillData();
		
		model.addAttribute("details", frpDetails);
		model.addAttribute("millDetails", millDetails);
		
		model.addAttribute("show", true);
		return "wetlapinventory/viewPage";
	}
	@RequestMapping(value="/view/report/sendmail",method=RequestMethod.POST)
	public @ResponseBody boolean emailSummaryData(HttpServletRequest request,HttpServletResponse response,
			Model model) throws IOException, ProductionException {
		
		Date sDate=CommonUtil.checkDate(request.getParameter("sdate"), dateFormat);
		Date eDate=CommonUtil.checkDate(request.getParameter("edate"), dateFormat);
		
		try {
				wetlapinventoryautomailer.sendMailAt8am();		
			} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return true;
		
		
	}
}

/**
 *Dec 10, 2014
 *InventoryController.java
 * TODO
 *com.st.production.dao
 *InventoryController.java
 *Sunil Singh Bora
 */
package com.st.productionpm5.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import jakarta.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.st.common.CommonUtil;
import com.st.production.model.WrapperProduction;
import com.st.production.report.InvenotryFloorReportHanlder;
import com.st.production.service.WrapperProductionService;

import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author sbora 
 *
 */
@Controller
@RequestMapping("/inventoryfloorreportpm5")
public class InventoryFloorControllerPM5 {
	
	private SimpleDateFormat dateFormat=new SimpleDateFormat("MM-dd-yyyy");
	
	@Autowired
	private InvenotryFloorReportHanlder invenotryFloorReportHanlder; 
	
	
	@Autowired
	private WrapperProductionService wrapperProductionService;
	
	
	@RequestMapping(value="/main")
	public String main(Model model) {
		
		model.addAttribute("date", dateFormat.format(new Date()));
		
		List<String> customers=wrapperProductionService.getCustomerFromWrapper();
		model.addAttribute("customers", customers);
		model.addAttribute("showFlag", false);
		
		return "productionWastepaper/inventoryFloor";
	}
	
	@RequestMapping(value="/view")
	public String view(@RequestParam("date")String date,
			@RequestParam("customer")String customer,
			Model model) {
		
		model.addAttribute("date", date);
		
		List<String> customers=wrapperProductionService.getCustomerFromWrapper();
		model.addAttribute("customers", customers);
		model.addAttribute("customer", customer);
		
		List<WrapperProduction> productions=wrapperProductionService.getInventoryWrapperProductions(CommonUtil.checkDate(date, dateFormat),customer);
		
		model.addAttribute("productions", productions);
		
		model.addAttribute("showFlag", true);
		return "productionWastepaper/inventoryFloor";
	}
	
	
	
	@RequestMapping(value="/export/excel")
	public void excelExport(@RequestParam("date")String date,
			@RequestParam("customer")String customer,
			HttpServletResponse response) throws IOException {
		
		
		response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
		response.setHeader("Content-Disposition", "attachment; filename=ST_Tissue_Inventory.xlsx");
		List<WrapperProduction> productions=wrapperProductionService.getInventoryWrapperProductions(CommonUtil.checkDate(date, dateFormat),customer);
		
		invenotryFloorReportHanlder.createExcelReport(productions,response.getOutputStream());
	}
}

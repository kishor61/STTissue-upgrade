/**
 * 
 */
package com.st.chemicalinventory.controller;

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

import com.st.chemicalinventory.model.ChemicalCode;
import com.st.chemicalinventory.model.ChemicalPrimaryCode;
import com.st.chemicalinventory.model.ChemicalReportData;
import com.st.chemicalinventory.model.ChemicalSecondaryCode;
import com.st.chemicalinventory.report.ChemicalReportHandler;
import com.st.chemicalinventory.service.ChemicalInventoryService;
import com.st.common.CommonUtil;

/**
 * @author sbora
 *	
 */
@Controller
@RequestMapping(value="/chemicalinvreport")
public class ChemicalInventoryReportController {
	
	@Autowired
	private ChemicalInventoryService chemicalInventoryService;
	
	
	
	@Autowired
	private ChemicalReportHandler chemicalReportHandler;
	
	
	SimpleDateFormat dateFormat=new SimpleDateFormat("MM-dd-yyyy");
	
	@RequestMapping(value="/main")
	public String main(Model model) {
		
		model.addAttribute("sdate", dateFormat.format(new Date()));
		model.addAttribute("edate", dateFormat.format(new Date()));
		model.addAttribute("pid", 0);
		model.addAttribute("sid", 0);

		
		List<ChemicalPrimaryCode> primaryCodes=chemicalInventoryService.getChemicalPrimaryCodes();
		List<ChemicalSecondaryCode> secondaryCodes=chemicalInventoryService.getChemicalSecondaryCodes();
		
		model.addAttribute("primaryCodes", primaryCodes);
		model.addAttribute("secondaryCodes", secondaryCodes);
		model.addAttribute("show", false);
		return "chemicalinventory/chemicalReport";
	}
	
	
	@RequestMapping(value="/view")
	public String view(@RequestParam("sdate")String sdate,
			@RequestParam("edate")String edate,
			@RequestParam("pid")int pid,
			@RequestParam("sid")int sid,
			HttpServletRequest request,
			Model model) {
		
		model.addAttribute("sdate", dateFormat.format(new Date()));
		model.addAttribute("edate", dateFormat.format(new Date()));
		
		List<ChemicalCode> chemicalCodes=chemicalInventoryService.getChemicalCodes();
		List<ChemicalPrimaryCode> primaryCodes=chemicalInventoryService.getChemicalPrimaryCodes();
		List<ChemicalSecondaryCode> secondaryCodes=chemicalInventoryService.getChemicalSecondaryCodes();
		
		model.addAttribute("chemicalCodes", chemicalCodes);
		model.addAttribute("primaryCodes", primaryCodes);
		model.addAttribute("secondaryCodes", secondaryCodes);
		model.addAttribute("sdate", sdate);
		model.addAttribute("edate", edate);
		model.addAttribute("pid", pid);
		model.addAttribute("sid", sid);
		
		Date from=CommonUtil.checkDate(sdate, dateFormat);
		Date to=CommonUtil.checkDate(edate, dateFormat);
		
		List<ChemicalReportData> reportDatas=chemicalInventoryService.getChemicalReportData(from,to,pid,sid);

		model.addAttribute("reportDatas",reportDatas);
		model.addAttribute("show", true);
		
		model.addAttribute("backParam", request.getQueryString());
		
		
		return "chemicalinventory/chemicalReport";
	}
	
	@RequestMapping(value="/view/detail")
	public String detailReportView(Model model) {
		
		model.addAttribute("sdate", dateFormat.format(new Date()));
		model.addAttribute("edate", dateFormat.format(new Date()));
		
		model.addAttribute("show", false);
		return "chemicalinventory/chemicalReportDetail";
	}
	
	@RequestMapping(value="/view/detail/load",method=RequestMethod.GET)
	public String detailReportView(@RequestParam("sdate")String sdate,
			@RequestParam("edate")String edate,
			HttpServletRequest request,
			Model model) {
		
		model.addAttribute("sdate", sdate);
		model.addAttribute("edate", edate);
		
		ChemicalReportData reportData=chemicalInventoryService.getChemicalReportDataDetail(CommonUtil.checkDate(sdate, dateFormat),CommonUtil.checkDate(edate, dateFormat));
		
		model.addAttribute("reportData", reportData);
		
		model.addAttribute("show", true);
		
		model.addAttribute("backParam", request.getQueryString());
		
		return "chemicalinventory/chemicalReportDetail";
	}
	
	
	@RequestMapping(value="/export/excel")
	public void exportExcel(@RequestParam("sdate")String sdate,
			@RequestParam("edate")String edate,
			@RequestParam("pid")int pid,
			@RequestParam("sid")int sid,
			HttpServletResponse response) throws IOException {
		
		Date from=CommonUtil.checkDate(sdate, dateFormat);
		Date to=CommonUtil.checkDate(edate, dateFormat);
		
		List<ChemicalReportData> reportDatas=chemicalInventoryService.getChemicalReportData(from,to,pid,sid);
		response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
		response.setHeader("Content-Disposition", "attachment; filename=ST_Tissue_Chemical_Report.xlsx");
		
		chemicalReportHandler.createExcelReport(reportDatas,response.getOutputStream());
	}
	
	@RequestMapping(value="/export/detail/excel",method=RequestMethod.GET)
	public void detailReportExportExcel(@RequestParam("sdate")String sdate,
			@RequestParam("edate")String edate,
			HttpServletResponse response) throws IOException {
		
		ChemicalReportData reportData=chemicalInventoryService.getChemicalReportDataDetail(CommonUtil.checkDate(sdate, dateFormat),CommonUtil.checkDate(edate, dateFormat));
		
		response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
		response.setHeader("Content-Disposition", "attachment; filename=ST_Tissue_Chemical_Report.xlsx");
		
		chemicalReportHandler.createExcelReport(reportData,response.getOutputStream());
	}
}

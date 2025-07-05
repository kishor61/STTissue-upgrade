/**
 *May 23, 2016
 *WrapperVsMachineSummaryReportController.java
 * TODO
 *com.st.production.controller
 *WrapperVsMachineSummaryReportController.java
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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.st.common.CommonUtil;
import com.st.common.exception.ProductionException;
import com.st.production.model.MachineAndWrapper;
import com.st.production.report.ProductionReportHandler;
import com.st.production.report.WrapperVsMachineSummaryReportAutoMailer;
import com.st.production.report.WrapperVsMachineSummaryReportHandler;
import com.st.production.service.MachineProductionService;
import com.st.production.service.MachineProductionSummaryService;

/**
 * @author roshan
 *
 */
@Controller
@RequestMapping("/wrapperVsMachineSummaryReportpm5")
public class WrapperVsMachineSummaryReportControllerPM5 {

	private SimpleDateFormat dateFormat=new SimpleDateFormat("MM-dd-yyyy");
	

	@Autowired
	private MachineProductionSummaryService machineproductionsummaryservice;
	
	@Autowired
	private WrapperVsMachineSummaryReportHandler wrapperVsmachinesummaryreporthandler;
	
	@Autowired
	private WrapperVsMachineSummaryReportAutoMailer WrapperVsMachineSummaryReportAutoMailer;
	
	@RequestMapping("/view")
	public String view(Model model) {
		model.addAttribute("sdate", dateFormat.format(new Date()));
		model.addAttribute("edate", dateFormat.format(new Date()));
		return "productionWastepaper/wrapperVsMachineSummaryView";
		
	}
	@RequestMapping("/export")
	public void export(@RequestParam("sdate")String sdate,@RequestParam("edate")String edate,HttpServletResponse response) throws IOException, ProductionException {
		
		response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
		response.setHeader("Content-Disposition", "attachment; filename=ST_Tissue_Wrapper_Vs_Machine.xlsx");
		
		List<MachineAndWrapper> machineAndWrappersSummary=machineproductionsummaryservice.getMachineAndWrapperSummaryReport(CommonUtil.checkDate(sdate, dateFormat),CommonUtil.checkDate(edate, dateFormat));
		
		wrapperVsmachinesummaryreporthandler.createMachineAndWrapperSummaryReport(machineAndWrappersSummary,response.getOutputStream());
		
	}
	@RequestMapping(value="/email",method=RequestMethod.GET)
	public @ResponseBody boolean mailInventorysummary() throws ProductionException, IOException {
		try {
			WrapperVsMachineSummaryReportAutoMailer.sendMailMachineVsWrapperSummaryReport();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}

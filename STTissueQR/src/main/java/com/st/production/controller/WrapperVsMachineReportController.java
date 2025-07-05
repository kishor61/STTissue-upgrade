/**
 *May 18, 2015
 *WrapperVsMachineReportController.java
 * TODO
 *com.st.production.controller
 *WrapperVsMachineReportController.java
 *Sunil Singh Bora
 */
package com.st.production.controller;

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
import com.st.production.automailer.ProductionReportAutoMailer;
import com.st.production.model.MachineAndWrapper;
import com.st.production.report.ProductionReportHandler;
import com.st.production.service.MachineProductionService;

/**
 * @author sbora
 *
 */
@Controller
@RequestMapping("/wrapperVsMachineReport")
public class WrapperVsMachineReportController {
	
	@Autowired
	private MachineProductionService machineProductionService;
	
	@Autowired
	private ProductionReportHandler productionPM6ReportHandler;
	
	@Autowired
	private ProductionReportAutoMailer productionReportAutoMailer;

	
	private SimpleDateFormat dateFormat=new SimpleDateFormat("MM-dd-yyyy");
	
	
	@RequestMapping("/view")
	public String view(Model model) {
		model.addAttribute("sdate", dateFormat.format(new Date()));
		model.addAttribute("edate", dateFormat.format(new Date()));
		return "productionWastepaper/wrapperVsMachineView";
		
	}
	
	@RequestMapping("/export")
	public void export(@RequestParam("sdate")String sdate,@RequestParam("edate")String edate,HttpServletResponse response) throws IOException, ProductionException {
		
		response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
		response.setHeader("Content-Disposition", "attachment; filename=ST_Tissue_Wrapper_Vs_Machine.xlsx");
		
		List<MachineAndWrapper> machineAndWrappers=machineProductionService.getMachineAndWrapper(CommonUtil.checkDate(sdate, dateFormat),CommonUtil.checkDate(edate, dateFormat));
		
		productionPM6ReportHandler.createMachineAndWrapperReport(machineAndWrappers,response.getOutputStream());
		
	}
	
	@RequestMapping(value="/email",method=RequestMethod.GET)
	public @ResponseBody boolean mailInventorysummary() throws ProductionException, IOException {
		try {
			productionReportAutoMailer.sendMailMachineVsWrapper();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}

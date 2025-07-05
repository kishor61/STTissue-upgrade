/**
 *Jun 4, 2018
 *DashBoardController.java
 * TODO
 *com.st.dashboard.controller
 *DashBoardController.java
 *Roshan Lal Tailor
 */
package com.st.dashboard.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.joda.time.LocalDate;
import org.joda.time.Period;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.st.common.CommonUtil;
import com.st.common.exception.ProductionException;
import com.st.convertingline.model.ConvertingLine;
import com.st.convertingline.model.ConvertingLineProduction;
import com.st.dashboard.report.DashBoardReport;
import com.st.frpproduction.model.FrpProdcutionOperatorDataEntry;
import com.st.frpproduction.service.FrpProdcutionOperatorDataEntryService;
import com.st.production.service.MachineProductionService;
import com.st.productionpm5.service.MachineProductionServicePM5;
import com.st.utilitykpimaster.model.KpiRecordableDate;
import com.st.utilitykpimaster.service.KpiRecordableDateService;
import com.st.wastepaper.comman.WastepaperComman;
import com.st.wastepaper.model.WastepaperDetail;

/**
 * @author roshan
 *
 */
@Controller
@RequestMapping("/dailydashboard")
public class DashBoardController {

	
	private SimpleDateFormat dateFormat=new SimpleDateFormat("MM-dd-yyyy");
	
	@Autowired
	private KpiRecordableDateService kpiRecordableDateService;
	
	@Autowired
	private MachineProductionServicePM5 machineProductionPM5Service;
	
	@Autowired
	private MachineProductionService machineProductionService;
	
	
	
	@Autowired
	private DashBoardReport dashBoardReport;
	
	@Autowired
	private com.st.dashboard.report.DashBoardReportMailer DashBoardReportMailer;
	
	@Autowired
	private ServletContext context;

	@Autowired
	private FrpProdcutionOperatorDataEntryService frpprodcutionoperatordataentryservice ;
	
	@RequestMapping(value="/view",method=RequestMethod.GET)
	public String wastepaperDetailView(Model model) {
		
		model.addAttribute("sdate", dateFormat.format(CommonUtil.getFirstDate(new Date())));
		model.addAttribute("edate", dateFormat.format(new Date()));
		model.addAttribute("show", false);
		return "dashboard/dashboardReport";
	}
	
	
	@RequestMapping(value="/view/data",method=RequestMethod.GET)
	public String wastepaperDetailView(@RequestParam("sdate")String sdate,Model model) throws ProductionException {
		
		model.addAttribute("sdate", sdate);
		
		
		Date sDate=CommonUtil.checkDate(sdate, dateFormat);
		Date eDate=CommonUtil.checkDate(sdate, dateFormat);
		


		
		List<Map<String, String>> datas1=new ArrayList<>();
		datas1=machineProductionPM5Service.formatDataForDailyReport(sDate,sDate);
		
		List<Map<String, String>> datas2=new ArrayList<>();
		datas2=machineProductionService.formatDataForDailyReport(sDate,sDate);
		
		List<FrpProdcutionOperatorDataEntry> details=frpprodcutionoperatordataentryservice.getFrpProducationDataEntryReport(sDate,eDate);
		
		//List<ConvertingLineProduction> caseData= convertinglinereportservice.getConvertingCaseDetailByDate(sDate,sDate);
		List<ConvertingLineProduction> caseData= null;

		KpiRecordableDate kpiRecordableDate=kpiRecordableDateService.getLastKpiRecordableDate();
		if(kpiRecordableDate!=null){
			int days=CommonUtil.getDaysDiffernce(kpiRecordableDate.getDate(), eDate);
			
			if(days>0){
				model.addAttribute("lrdate", dateFormat.format(kpiRecordableDate.getDate()));
				model.addAttribute("lrdays", days);
				//model.addAttribute("lrcdate", edate);
			}

		}
		
		model.addAttribute("datas1", datas1);
		model.addAttribute("datas2", datas2);
		model.addAttribute("datas3", details);
		model.addAttribute("datas4", caseData);
		model.addAttribute("show", true);
		
		return "dashboard/dashboardReport";
	}
	
	@RequestMapping(value="/view/data/export",method=RequestMethod.GET)
	public void export(@RequestParam("sdate")String sdate,HttpServletResponse response) throws Exception{

		
		Date sDate=CommonUtil.checkDate(sdate, dateFormat);
		
		
		List<Map<String, String>> datas1=new ArrayList<>();
		datas1=machineProductionPM5Service.formatDataForDailyReport(sDate,sDate);
		
		List<Map<String, String>> datas2=new ArrayList<>();
		datas2=machineProductionService.formatDataForDailyReport(sDate,sDate);
		
		List<FrpProdcutionOperatorDataEntry> details=frpprodcutionoperatordataentryservice.getFrpProducationDataEntryReport(sDate,sDate);
		
		List<ConvertingLineProduction> caseData= null;//convertinglinereportservice.getConvertingCaseDetail(sDate);

		KpiRecordableDate kpiRecordableDate=kpiRecordableDateService.getLastKpiRecordableDate();
		
		int lrdays=0;
		String lrdate="";
		if(kpiRecordableDate!=null){
			int days=CommonUtil.getDaysDiffernce(kpiRecordableDate.getDate(), sDate);
			
			if(days>0){
				lrdate=dateFormat.format(kpiRecordableDate.getDate());
				lrdays=days;
			}

		}
		
		
		response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
		response.setHeader("Content-Disposition", "attachment; filename=DashBoardReport.xlsx");
		File file=new File(context.getRealPath("/")+"WEB-INF/DashBoardReport.xlsx");
		
		dashBoardReport.dashBoardReportExportReport(datas1,datas2,details,caseData,lrdate,lrdays,sDate,file,response.getOutputStream());
		
		}
	
	@RequestMapping(value="/view/data/email",method=RequestMethod.POST)
	public @ResponseBody boolean breakFreeProductiondataemail(
			@RequestParam("sdate")String sdate,HttpServletResponse response,
			Model model,
			HttpServletRequest request) throws IOException, ProductionException {
		
		Date sDate=CommonUtil.checkDate(sdate, dateFormat);
		try {
			DashBoardReportMailer.getDashBoardReportMailerMail(sDate);
			} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return true;
		
		
	}
}


		
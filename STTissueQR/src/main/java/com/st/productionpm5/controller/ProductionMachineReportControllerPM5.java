/**
 * 
 */
package com.st.productionpm5.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.st.common.CommonUtil;
import com.st.common.exception.ProductionException;
import com.st.efficiencypm5.model.EffSummaryPrimaryPM5;
import com.st.efficiencypm5.model.EffSummarySecondaryPM5;
import com.st.efficiencypm5.model.EfficiencyPM5;
import com.st.efficiencypm5.service.EfficiencyCodeServicePM5;
import com.st.productionpm5.automailer.ProductionPM5ReportAutoMailer;
import com.st.productionpm5.model.MachineProductionPM5;
import com.st.productionpm5.report.MeahineBreakFreeProductionReportHandlerPM5;
import com.st.productionpm5.report.MeahineBreakFreeProductionReportMailerPM5;
import com.st.productionpm5.report.ProductionReportHandlerPM5;
import com.st.productionpm5.service.MachineProductionServicePM5;
import com.st.productionpm5.service.MachineProductionSummaryServiceImpPM5;

/**
 * @author sbora
 *
 */
@Controller
@RequestMapping(value="/pm5productionreport")
public class ProductionMachineReportControllerPM5 {
	@Autowired
	private ServletContext context;
	
	@Autowired
	private EfficiencyCodeServicePM5 efficiencyCodeService;
	
	@Autowired
	private MachineProductionServicePM5 machineProductionService;
	
	@Autowired
	private ProductionReportHandlerPM5 productionPM6ReportHandler;

	@Autowired
	private ProductionPM5ReportAutoMailer productionReportAutoMailer;
	
	@Autowired
	private MachineProductionSummaryServiceImpPM5 machineproductionsummaryserviceimp;
	
	@Autowired
	private MeahineBreakFreeProductionReportHandlerPM5 meahinebreakfreeproductionreport;
	
	@Autowired
	private MeahineBreakFreeProductionReportMailerPM5 meahinebreakfreeproductionreportmailer;
	
	private SimpleDateFormat dateFormat=new SimpleDateFormat("MM-dd-yyyy");
	
	
	
	@RequestMapping(value="/view",method=RequestMethod.GET)
	public String view(Model model) {
		
		model.addAttribute("sdate", dateFormat.format(new Date()));
		model.addAttribute("edate", dateFormat.format(new Date()));
		
		return "PM5/productionWastepaper/productionReport";
	}
	
	@RequestMapping(value="/view/data",method=RequestMethod.GET)
	public String viewData(HttpServletRequest request,
			Model model) throws ProductionException {
	
		
		//
		//refreshResource.refresh();
		
		
		Date sdate=CommonUtil.checkDate(request.getParameter("sdate"), dateFormat);
		Date edate=CommonUtil.checkDate(request.getParameter("edate"), dateFormat);
		
		model.addAttribute("sdate", dateFormat.format(sdate));
		model.addAttribute("edate", dateFormat.format(edate));
		model.addAttribute("viewFlag", true);
		
		
		List<Map<String, String>> datas=new ArrayList<>();
		
		datas=machineProductionService.formatDataForDailyReport(sdate,edate);
		

		model.addAttribute("datas", datas);
		
		return "PM5/productionWastepaper/productionReport";
	}
	@RequestMapping(value="/report/email",method=RequestMethod.POST)
	public @ResponseBody boolean mailPM6ProducationReport(HttpServletRequest request,HttpServletResponse response,Model model) throws ProductionException, IOException {
		try {
			Date sdate=CommonUtil.checkDate(request.getParameter("sdate"), dateFormat);
			Date edate=CommonUtil.checkDate(request.getParameter("edate"), dateFormat);
			
			productionReportAutoMailer.getMailPM5ProducationReport(sdate,edate);
			
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	@RequestMapping(value="/export",method=RequestMethod.POST)
	public void exportData(HttpServletRequest request,
			HttpServletResponse response,
			Model model) throws IOException, ProductionException {
		
		//
	//	refreshResource.refresh();
		
		
		Date sdate=CommonUtil.checkDate(request.getParameter("sdate"), dateFormat);
		Date edate=CommonUtil.checkDate(request.getParameter("edate"), dateFormat);
		
		model.addAttribute("sdate", dateFormat.format(sdate));
		model.addAttribute("edate", dateFormat.format(edate));
		model.addAttribute("viewFlag", true);
		
		
		List<Map<String, String>> datas=new ArrayList<>();
		
		datas=machineProductionService.formatDataForDailyReport(sdate,edate);
		
		response.setContentType("application/vnd.ms-excel");
		response.setHeader("Content-Disposition", "attachment; filename=PM5 Production Report.xls");
		
		File file=new File(context.getRealPath("/")+"WEB-INF/excel template/productionWrapper/PM5 Production Report.xls");

		HSSFWorkbook workbook=machineProductionService.getFormatedWorkbookForDailyReport(file,datas,sdate,edate);
		workbook.write(response.getOutputStream());

	}

	
	
	@RequestMapping(value="/viewsummary",method=RequestMethod.GET)
	public String viewProductionSummary(Model model) {
		
		model.addAttribute("date", dateFormat.format(new Date()));
		
		return "PM5/productionWastepaper/productionReportSummary";
	}
	
	@RequestMapping(value="/viewsummary/data",method=RequestMethod.GET)
	public String viewSummaryData(HttpServletRequest request,
			Model model) throws ProductionException {
		//refreshResource.refresh();
		
		
		Date date=CommonUtil.checkDate(request.getParameter("date"), dateFormat);
	
		String shift=CommonUtil.checkNull(request.getParameter("shift"));
		
		model.addAttribute("date", dateFormat.format(date));
		model.addAttribute("shift", shift);
		model.addAttribute("viewFlag", true);
		
		Map<String, Object> datas=new HashMap<String, Object>();
		
		datas=machineProductionService.formatDataForSumaryReport(date,date,shift);
		
		model.addAttribute("datas", datas);
		
		
		
		//
		
		Map<String, Object> datas1=new HashMap<>();
		
		List<EffSummaryPrimaryPM5> summaryPrimaries=new ArrayList<>();
		try {
			
			Calendar scal=Calendar.getInstance();
			scal.setTime(date);
			scal.set(Calendar.HOUR_OF_DAY, 6);
			scal.set(Calendar.MINUTE, 0);
			scal.set(Calendar.SECOND, 0);
			scal.set(Calendar.MILLISECOND, 0);
			
			Calendar ecal=Calendar.getInstance();
			ecal.setTime(date);
			ecal.set(Calendar.HOUR_OF_DAY, 5);
			ecal.set(Calendar.MINUTE, 59);
			ecal.set(Calendar.SECOND, 0);
			ecal.set(Calendar.MILLISECOND, 0);
			ecal.add(Calendar.DATE, 1);
			
			summaryPrimaries=formatSummaryData(scal.getTime(),ecal.getTime(),0,0);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		int totalmin=0;
		for (EffSummaryPrimaryPM5 effSummaryPrimary : summaryPrimaries) {
			totalmin+=effSummaryPrimary.getTotalMin();
		}
		datas1.put("summaryPrimaries", summaryPrimaries);
		datas1.put("hh", totalmin/60);
		datas1.put("mm", totalmin%60);
		
		
		model.addAttribute("datas1", datas1);
		
		
		
		
		
		
		
		return "PM5/productionWastepaper/productionReportSummary";
	}

	
	/**
	 * @param time
	 * @param time2
	 * @param string
	 * @param string2
	 * @return
	 */
private List<EffSummaryPrimaryPM5> formatSummaryData(Date sdate, Date edate,int pcode,int scode) {
		

		
		List<EfficiencyPM5> efficiencies=efficiencyCodeService.getSummaryData(sdate,edate,pcode,scode);
		
		List<EffSummaryPrimaryPM5> effSummaryPrimaries=new ArrayList<>();
		
		for (EfficiencyPM5 efficiency : efficiencies) {
			EffSummaryPrimaryPM5 effSummaryPrimary=getEffSummaryPrimary(effSummaryPrimaries,efficiency.getPcode());
			if(effSummaryPrimary==null){
				effSummaryPrimary=new EffSummaryPrimaryPM5();
				effSummaryPrimary.setCode(efficiency.getPcode());
				
				
				//Secondary code
				EffSummarySecondaryPM5 effSummarySecondary=new EffSummarySecondaryPM5();
				effSummarySecondary.setCode(efficiency.getScode());
				int hh=CommonUtil.getHoursDuration(efficiency.getStartTime(), efficiency.getEndTime());
				int mm=CommonUtil.getMinutesDuration(efficiency.getStartTime(), efficiency.getEndTime());
				int total=(hh*60)+mm;
				effSummarySecondary.setTotalMin(total);
				effSummarySecondary.setHh(effSummarySecondary.getTotalMin()/60);
				effSummarySecondary.setMm(effSummarySecondary.getTotalMin()%60);
				effSummaryPrimary.getSummarySecondaries().add(effSummarySecondary);
				
				
				//Set Counter;
				effSummarySecondary.setCounter(1);
				effSummaryPrimaries.add(effSummaryPrimary);
				
			}else{
				List<EffSummarySecondaryPM5> effSummarySecondaries=effSummaryPrimary.getSummarySecondaries();
				EffSummarySecondaryPM5 effSummarySecondary=getEffSummarySecondary(effSummarySecondaries,efficiency.getScode());
				if(effSummarySecondary==null){
					effSummarySecondary=new EffSummarySecondaryPM5();
					effSummarySecondary.setCode(efficiency.getScode());
					int hh=CommonUtil.getHoursDuration(efficiency.getStartTime(), efficiency.getEndTime());
					int mm=CommonUtil.getMinutesDuration(efficiency.getStartTime(), efficiency.getEndTime());
					int total=(hh*60)+mm;
					effSummarySecondary.setTotalMin(total);
					effSummarySecondary.setHh(effSummarySecondary.getTotalMin()/60);
					effSummarySecondary.setMm(effSummarySecondary.getTotalMin()%60);
					effSummarySecondaries.add(effSummarySecondary);
					effSummarySecondary.setCounter(1);
					
					
				}else{
					int hh=CommonUtil.getHoursDuration(efficiency.getStartTime(), efficiency.getEndTime());
					int mm=CommonUtil.getMinutesDuration(efficiency.getStartTime(), efficiency.getEndTime());
					int total=(hh*60)+mm;
					effSummarySecondary.setTotalMin(effSummarySecondary.getTotalMin()+total);
					effSummarySecondary.setHh(effSummarySecondary.getTotalMin()/60);
					effSummarySecondary.setMm(effSummarySecondary.getTotalMin()%60);
					
					effSummarySecondary.setCounter(effSummarySecondary.getCounter()+1);
				}
			}
		}
		
		for (EffSummaryPrimaryPM5 effSummaryPrimary : effSummaryPrimaries) {
			int total=0;
			for (EffSummarySecondaryPM5 effSummarySecondary : effSummaryPrimary.getSummarySecondaries()) {
				total+=effSummarySecondary.getTotalMin();
			}
			effSummaryPrimary.setTotalMin(total);
			effSummaryPrimary.setHh(total/60);
			effSummaryPrimary.setMm(total%60);
		}
		
		return effSummaryPrimaries;
	}

	/**
	 * @param effSummarySecondaries
	 * @param scode
	 * @return
	 */
private EffSummarySecondaryPM5 getEffSummarySecondary(
		List<EffSummarySecondaryPM5> effSummarySecondaries, String scode) {
	EffSummarySecondaryPM5 effSummarySecondary=null;
	for (EffSummarySecondaryPM5 ess : effSummarySecondaries) {
		if(ess.getCode().equals(scode)){
			effSummarySecondary=ess;
			break;
		}
	}
	return effSummarySecondary;
}

	/**
	 * @param effSummaryPrimaries
	 * @param pcode
	 * @return
	 */
private EffSummaryPrimaryPM5 getEffSummaryPrimary(
		List<EffSummaryPrimaryPM5> effSummaryPrimaries, String pcode) {
	EffSummaryPrimaryPM5 effSummaryPrimary=null;
	for (EffSummaryPrimaryPM5 esp : effSummaryPrimaries) {
		if(esp.getCode().equals(pcode)){
			effSummaryPrimary=esp;
			break;
		}
	}
	return effSummaryPrimary;
}

	@RequestMapping(value="/exportsummary",method=RequestMethod.POST)
	public void exportSummaryData(HttpServletRequest request,
			HttpServletResponse response,
			Model model) throws IOException, ProductionException {
		
		//
		//refreshResource.refresh();
		
		
		Date date=CommonUtil.checkDate(request.getParameter("date"), dateFormat);
		String shift=CommonUtil.checkNull(request.getParameter("shift"));
		
		Map<String, Object> datas=new HashMap<String, Object>();
		
		datas=machineProductionService.formatDataForSumaryReport(date,date,shift);
		
		
		
		response.setContentType("application/vnd.ms-excel");
		response.setHeader("Content-Disposition", "attachment; filename=PM6 Production Summary Report.xls");
		
		File file=new File(context.getRealPath("/")+"WEB-INF/excel template/productionWrapper/Production Summary Report.xls");

		HSSFWorkbook workbook=machineProductionService.getFormatedWorkbookForSummaryReport(file,datas,date);
		workbook.write(response.getOutputStream());

	}
	
	@RequestMapping(value="/exportsummary/pdf",method=RequestMethod.POST)
	public void exportPdfSummaryData(HttpServletRequest request,
			HttpServletResponse response,
			Model model) throws IOException, ProductionException {
		
		//
		//refreshResource.refresh();
		
		
		Date date=CommonUtil.checkDate(request.getParameter("date"), dateFormat);
		String shift=CommonUtil.checkNull(request.getParameter("shift"));
		
		Map<String, Object> datas=machineProductionService.formatDataForSumaryReport(date,date,shift);
		
		response.setContentType("application/pdf");
		response.setHeader("Content-Disposition", "attachment; filename=PM6_Production_Summary_Report.pdf");
		
		productionPM6ReportHandler.createPdfReport(datas,shift,date,response.getOutputStream());
		
		

	}
	
	@RequestMapping(value="/exportsummary/email",method=RequestMethod.POST)
	public @ResponseBody boolean emailSummaryData(HttpServletRequest request,
			HttpServletResponse response,
			Model model) throws IOException, ProductionException {
		
		Date date=CommonUtil.checkDate(request.getParameter("date"), dateFormat);
		String shift=CommonUtil.checkNull(request.getParameter("shift"));
		
		try {
			Map<String, Object> datas1=new HashMap<>();
			
			List<EffSummaryPrimaryPM5> summaryPrimaries=new ArrayList<>();
			try {
				
				Calendar scal=Calendar.getInstance();
				scal.setTime(date);
				scal.set(Calendar.HOUR_OF_DAY, 7);
				scal.set(Calendar.MINUTE, 0);
				scal.set(Calendar.SECOND, 0);
				scal.set(Calendar.MILLISECOND, 0);
				
				Calendar ecal=Calendar.getInstance();
				ecal.setTime(date);
				ecal.set(Calendar.HOUR_OF_DAY, 6);
				ecal.set(Calendar.MINUTE, 59);
				ecal.set(Calendar.SECOND, 0);
				ecal.set(Calendar.MILLISECOND, 0);
				ecal.add(Calendar.DATE, 1);
				
				summaryPrimaries=formatSummaryData(scal.getTime(),ecal.getTime(),0,0);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			int totalmin=0;
			for (EffSummaryPrimaryPM5 effSummaryPrimary : summaryPrimaries) {
				totalmin+=effSummaryPrimary.getTotalMin();
			}
			datas1.put("summaryPrimaries", summaryPrimaries);
			datas1.put("hh", totalmin/60);
			datas1.put("mm", totalmin%60);
			
			if(shift.equalsIgnoreCase("Day")){
			//	productionReportAutoMailer.sendMailAt7pm(date,datas1);
			}else{
			//	productionReportAutoMailer.sendMailAt7am(date,datas1);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return true;
		
		
	}

	@RequestMapping(value="/email/gradenhours",method=RequestMethod.GET)
	public @ResponseBody boolean mailDataGradeAndHours(@RequestParam("sdate")String sdate,@RequestParam("edate")String edate) throws ProductionException, IOException {
		try {
			productionReportAutoMailer.sendGradeAndHoureMachineMail(CommonUtil.checkDate(sdate, dateFormat),CommonUtil.checkDate(edate, dateFormat));
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	
	@RequestMapping(value="/gradenhours",method=RequestMethod.GET)
	public String gradeAndHours(Model model) throws ProductionException, IOException {
		model.addAttribute("sdate", dateFormat.format(CommonUtil.getFirstDate()));
		model.addAttribute("edate", dateFormat.format(new Date()));
		return "PM5/productionWastepaper/gradeAndHoursMachineReport";
	}
	
	@RequestMapping(value="/export/gradenhours",method=RequestMethod.POST)
	public void exportDataGradeAndHours(@RequestParam("sdate")String sdate,@RequestParam("edate")String edate,HttpServletResponse response) throws Exception{
		
		List<Map<String, Object>> datas=machineProductionService.getGradeAndHourData(CommonUtil.checkDate(sdate, dateFormat),CommonUtil.checkDate(edate, dateFormat));
		
		response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
		response.setHeader("Content-Disposition", "attachment; filename=ST_Tissue_Grade_And_Hours.xlsx");
		productionPM6ReportHandler.createExcelGradeAndHoursMachineReport(datas, response.getOutputStream());
	}
	
	@RequestMapping(value="/breakfreeproducation",method=RequestMethod.GET)
	public String breakFreeProduction(Model model) {
		
		model.addAttribute("shift", "");
		model.addAttribute("sdate", dateFormat.format(CommonUtil.getFirstDate()));
		model.addAttribute("edate", dateFormat.format(new Date()));
		model.addAttribute("export", false);
		return "PM5/productionWastepaper/breakfreeproductionReport";
	}
	
	@RequestMapping(value="/breakfreeproducation/showdata",method=RequestMethod.GET)
	public String breakFreeProductiondata(@RequestParam("sdate")String sdate,@RequestParam("edate")String edate,@RequestParam("shift")String shift,HttpServletResponse response,Model model) {
		
		Date sDate=CommonUtil.checkDate(sdate, dateFormat);
		Date eDate=CommonUtil.checkDate(edate, dateFormat);
		
		List<MachineProductionPM5> breakFreeProductionInMachine=machineproductionsummaryserviceimp.getMachineBreakFreeProduction(sDate,eDate,shift);
		
		System.out.println(breakFreeProductionInMachine.size());
		System.out.println(breakFreeProductionInMachine);
		
		model.addAttribute("data", breakFreeProductionInMachine);
		model.addAttribute("shift", shift);
		model.addAttribute("sdate", sdate);
		model.addAttribute("edate", edate);
		model.addAttribute("export", true);
		return "PM5/productionWastepaper/breakfreeproductionReport";
	}
	@RequestMapping(value="/breakfreeproducation/showdata/export",method=RequestMethod.GET)
	public void breakFreeProductiondataexport(
			@RequestParam("sdate")String sdate,
			@RequestParam("edate")String edate,
			@RequestParam("shift")String shift,
			HttpServletResponse response,
			Model model) throws IOException {
		
		
		Date sDate=CommonUtil.checkDate(sdate, dateFormat);
		Date eDate=CommonUtil.checkDate(edate, dateFormat);
		
		List<MachineProductionPM5> data=machineproductionsummaryserviceimp.getMachineBreakFreeProduction(sDate,eDate,shift);
		
		response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
		response.setHeader("Content-Disposition", "attachment; filename=Machine_Prodcution_BreakFree_Percentage_Report.xlsx");
		File file=new File(context.getRealPath("/")+"WEB-INF/Machine_Prodcution_BreakFree_Percentage_Report.xlsx");
		
		
		meahinebreakfreeproductionreport.createReport(data,file,response.getOutputStream());
		
	}
	@RequestMapping(value="/breakfreeproducation/showdata/email",method=RequestMethod.POST)
	public @ResponseBody boolean breakFreeProductiondataemail(
			@RequestParam("sdate")String sdate,
			@RequestParam("edate")String edate,
			@RequestParam("shift")String shift,
			HttpServletResponse response,
			Model model,
			HttpServletRequest request) throws IOException, ProductionException {
		
		Date sDate=CommonUtil.checkDate(sdate, dateFormat);
		Date eDate=CommonUtil.checkDate(edate, dateFormat);
		try {
			meahinebreakfreeproductionreportmailer.getMachineBreakFreeProductionMail(sDate,eDate,shift);
			} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return true;
		
		
	}
	
	@RequestMapping(value="/view/non-controlablehours",method=RequestMethod.GET)
	public String viewNonControlableHours(Model model) {
		
		model.addAttribute("sdate", dateFormat.format(new Date()));
		model.addAttribute("edate", dateFormat.format(new Date()));
		
		return "productionWastepaper/productionReport_non-controlablehours";
	}
	@RequestMapping(value="/view/non-controlablehours/data",method=RequestMethod.GET)
	public String viewDataNonControlableHours(HttpServletRequest request,
			Model model) throws ProductionException {
	
		Date sdate=CommonUtil.checkDate(request.getParameter("sdate"), dateFormat);
		Date edate=CommonUtil.checkDate(request.getParameter("edate"), dateFormat);
		
		model.addAttribute("sdate", dateFormat.format(sdate));
		model.addAttribute("edate", dateFormat.format(edate));
		model.addAttribute("viewFlag", true);
		
		
		List<Map<String, String>> datas=new ArrayList<>();
		
		datas=machineProductionService.formatDataForDailyReportNonControlableHours(sdate,edate);
		
		model.addAttribute("datas", datas);
		
		return "PM5/productionWastepaper/productionReport_non-controlablehours";
	}
	@RequestMapping(value="/export/non-controlablehours/data",method=RequestMethod.POST)
	public void exportDataNonControlableHours(HttpServletRequest request,
			HttpServletResponse response,
			Model model) throws IOException, ProductionException {
		
		Date sdate=CommonUtil.checkDate(request.getParameter("sdate"), dateFormat);
		Date edate=CommonUtil.checkDate(request.getParameter("edate"), dateFormat);
		
		model.addAttribute("sdate", dateFormat.format(sdate));
		model.addAttribute("edate", dateFormat.format(edate));
		model.addAttribute("viewFlag", true);
		
		
		List<Map<String, String>> datas=new ArrayList<>();
		
		datas=machineProductionService.formatDataForDailyReportNonControlableHours(sdate,edate);
		
		response.setContentType("application/vnd.ms-excel");
		response.setHeader("Content-Disposition", "attachment; filename=PM6 Production Report_Non-Controlable Hours.xls");
		
		File file=new File(context.getRealPath("/")+"WEB-INF/excel template/productionWrapper/PM6 Production Report_Non-Controlable Hours.xls");

		HSSFWorkbook workbook=machineProductionService.getFormatedWorkbookForDailyReportNonControlableHours(file,datas,sdate,edate);
		workbook.write(response.getOutputStream());
	}
	
}

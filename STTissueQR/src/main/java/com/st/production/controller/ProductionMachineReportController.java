/**
 * 
 */
package com.st.production.controller;

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
import com.st.efficiency.model.EffSummaryPrimary;
import com.st.efficiency.model.EffSummarySecondary;
import com.st.efficiency.model.Efficiency;
import com.st.efficiency.service.EfficiencyCodeService;
import com.st.production.automailer.ProductionReportAutoMailer;
import com.st.production.model.MachineProduction;
import com.st.production.report.MeahineBreakFreeProductionReportHandler;
import com.st.production.report.MeahineBreakFreeProductionReportMailer;
import com.st.production.report.ProductionReportHandler;
import com.st.production.service.MachineProductionService;
import com.st.production.service.MachineProductionSummaryServiceImp;

/**
 * @author sbora
 *
 */
@Controller
@RequestMapping(value="/productionreport")
public class ProductionMachineReportController {
	@Autowired
	private ServletContext context;
	
	@Autowired
	private EfficiencyCodeService efficiencyCodeService;
	
	@Autowired
	private MachineProductionService machineProductionService;
	
	@Autowired
	private ProductionReportHandler productionPM6ReportHandler;

	@Autowired
	private ProductionReportAutoMailer productionReportAutoMailer;
	
	@Autowired
	private MachineProductionSummaryServiceImp machineproductionsummaryserviceimp;
	
	@Autowired
	private MeahineBreakFreeProductionReportHandler meahinebreakfreeproductionreport;
	
	@Autowired
	private MeahineBreakFreeProductionReportMailer meahinebreakfreeproductionreportmailer;
	
	private SimpleDateFormat dateFormat=new SimpleDateFormat("MM-dd-yyyy");
	
	
	
	@RequestMapping(value="/view",method=RequestMethod.GET)
	public String view(Model model) {
		
		model.addAttribute("sdate", dateFormat.format(new Date()));
		model.addAttribute("edate", dateFormat.format(new Date()));
		
		return "productionWastepaper/productionReport";
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
		
		return "productionWastepaper/productionReport";
	}
	@RequestMapping(value="/report/email",method=RequestMethod.POST)
	public @ResponseBody boolean mailPM6ProducationReport(HttpServletRequest request,HttpServletResponse response,Model model) throws ProductionException, IOException {
		try {
			Date sdate=CommonUtil.checkDate(request.getParameter("sdate"), dateFormat);
			Date edate=CommonUtil.checkDate(request.getParameter("edate"), dateFormat);
			
			productionReportAutoMailer.getMailPM6ProducationReport(sdate,edate);
			
			
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
		response.setHeader("Content-Disposition", "attachment; filename=PM6 Production Report.xls");
		
		File file=new File(context.getRealPath("/")+"WEB-INF/excel template/productionWrapper/PM6 Production Report.xls");

		HSSFWorkbook workbook=machineProductionService.getFormatedWorkbookForDailyReport(file,datas,sdate,edate);
		workbook.write(response.getOutputStream());

	}

	
	
	@RequestMapping(value="/viewsummary",method=RequestMethod.GET)
	public String viewProductionSummary(Model model) {
		
		model.addAttribute("date", dateFormat.format(new Date()));
		
		return "productionWastepaper/productionReportSummary";
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
		
		List<EffSummaryPrimary> summaryPrimaries=new ArrayList<>();
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
		for (EffSummaryPrimary effSummaryPrimary : summaryPrimaries) {
			totalmin+=effSummaryPrimary.getTotalMin();
		}
		datas1.put("summaryPrimaries", summaryPrimaries);
		datas1.put("hh", totalmin/60);
		datas1.put("mm", totalmin%60);
		
		
		model.addAttribute("datas1", datas1);
		
		
		
		
		
		
		
		return "productionWastepaper/productionReportSummary";
	}

	
	/**
	 * @param time
	 * @param time2
	 * @param string
	 * @param string2
	 * @return
	 */
private List<EffSummaryPrimary> formatSummaryData(Date sdate, Date edate,int pcode,int scode) {
		

		
		List<Efficiency> efficiencies=efficiencyCodeService.getSummaryData(sdate,edate,pcode,scode);
		
		List<EffSummaryPrimary> effSummaryPrimaries=new ArrayList<>();
		
		for (Efficiency efficiency : efficiencies) {
			EffSummaryPrimary effSummaryPrimary=getEffSummaryPrimary(effSummaryPrimaries,efficiency.getPcode());
			if(effSummaryPrimary==null){
				effSummaryPrimary=new EffSummaryPrimary();
				effSummaryPrimary.setCode(efficiency.getPcode());
				
				
				//Secondary code
				EffSummarySecondary effSummarySecondary=new EffSummarySecondary();
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
				List<EffSummarySecondary> effSummarySecondaries=effSummaryPrimary.getSummarySecondaries();
				EffSummarySecondary effSummarySecondary=getEffSummarySecondary(effSummarySecondaries,efficiency.getScode());
				if(effSummarySecondary==null){
					effSummarySecondary=new EffSummarySecondary();
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
		
		for (EffSummaryPrimary effSummaryPrimary : effSummaryPrimaries) {
			int total=0;
			for (EffSummarySecondary effSummarySecondary : effSummaryPrimary.getSummarySecondaries()) {
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
private EffSummarySecondary getEffSummarySecondary(
		List<EffSummarySecondary> effSummarySecondaries, String scode) {
	EffSummarySecondary effSummarySecondary=null;
	for (EffSummarySecondary ess : effSummarySecondaries) {
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
private EffSummaryPrimary getEffSummaryPrimary(
		List<EffSummaryPrimary> effSummaryPrimaries, String pcode) {
	EffSummaryPrimary effSummaryPrimary=null;
	for (EffSummaryPrimary esp : effSummaryPrimaries) {
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
			
			List<EffSummaryPrimary> summaryPrimaries=new ArrayList<>();
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
			for (EffSummaryPrimary effSummaryPrimary : summaryPrimaries) {
				totalmin+=effSummaryPrimary.getTotalMin();
			}
			datas1.put("summaryPrimaries", summaryPrimaries);
			datas1.put("hh", totalmin/60);
			datas1.put("mm", totalmin%60);
			
			if(shift.equalsIgnoreCase("Day")){
				productionReportAutoMailer.sendMailAt7pm(date,datas1,"");
			}else{
				productionReportAutoMailer.sendMailAt7am(date,datas1,"");
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
		return "productionWastepaper/gradeAndHoursMachineReport";
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
		return "productionWastepaper/breakfreeproductionReport";
	}
	
	@RequestMapping(value="/breakfreeproducation/showdata",method=RequestMethod.GET)
	public String breakFreeProductiondata(@RequestParam("sdate")String sdate,@RequestParam("edate")String edate,@RequestParam("shift")String shift,HttpServletResponse response,Model model) {
		
		Date sDate=CommonUtil.checkDate(sdate, dateFormat);
		Date eDate=CommonUtil.checkDate(edate, dateFormat);
		
		List<MachineProduction> breakFreeProductionInMachine=machineproductionsummaryserviceimp.getMachineBreakFreeProduction(sDate,eDate,shift);
		
		System.out.println(breakFreeProductionInMachine.size());
		System.out.println(breakFreeProductionInMachine);
		
		model.addAttribute("data", breakFreeProductionInMachine);
		model.addAttribute("shift", shift);
		model.addAttribute("sdate", sdate);
		model.addAttribute("edate", edate);
		model.addAttribute("export", true);
		return "productionWastepaper/breakfreeproductionReport";
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
		
		List<MachineProduction> data=machineproductionsummaryserviceimp.getMachineBreakFreeProduction(sDate,eDate,shift);
		
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
		
		return "productionWastepaper/productionReport_non-controlablehours";
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

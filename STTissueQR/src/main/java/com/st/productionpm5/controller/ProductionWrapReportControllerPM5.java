/**
 * 
 */
package com.st.productionpm5.controller;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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
import com.st.productionpm5.automailer.ProductionPM5ReportAutoMailer;
import com.st.productionpm5.model.WrapperProductionPM5;
import com.st.productionpm5.report.ProductionReportHandlerPM5;
import com.st.productionpm5.service.WrapperProductionServicePM5;
/**
 * @author roshan
 *
 */
@Controller
@RequestMapping(value="/pm5productionwarpreport")
public class ProductionWrapReportControllerPM5 {

	@Autowired
	private ServletContext context;
	
	
	@Autowired
	private WrapperProductionServicePM5 wrapperProductionService;
	
	@Autowired
	private ProductionReportHandlerPM5 productionReportHandler;
	
	@Autowired
	private ProductionPM5ReportAutoMailer productionReportAutoMailer;
	
	
	/*@Autowired 
	private RefreshResource refreshResource;
	*/
	
	private SimpleDateFormat dateFormat=new SimpleDateFormat("MM-dd-yyyy");
	private SimpleDateFormat dateFormat2=new SimpleDateFormat("MMMM yy");
	
	@RequestMapping(value="/view",method=RequestMethod.GET)
	public String view(Model model) {
		
		model.addAttribute("sdate", dateFormat.format(new Date()));
		model.addAttribute("edate", dateFormat.format(new Date()));
		
		return "PM5/productionWastepaper/productionWrapReport";
	}
	
	@RequestMapping(value="/view/data",method=RequestMethod.GET)
	public String viewData(HttpServletRequest request,
			Model model) throws ProductionException {
		
		
		
		//refreshResource.refresh();
		
		
		Date sdate=CommonUtil.checkDate(request.getParameter("sdate"), dateFormat);
		Date edate=CommonUtil.checkDate(request.getParameter("edate"), dateFormat);
		
		model.addAttribute("sdate", dateFormat.format(sdate));
		model.addAttribute("edate", dateFormat.format(edate));
		
		
		String reportFrom="01-01-2013";
		Date startDate=null;
		try {
			startDate = dateFormat.parse(reportFrom);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		Calendar ecal=Calendar.getInstance();
		ecal.setTime(sdate);
		ecal.add(Calendar.MONTH,-1);
		
		
		model.addAttribute("reportFrom", dateFormat2.format(startDate));
		model.addAttribute("reportTo", dateFormat2.format(ecal.getTime()));
		
		model.addAttribute("viewFlag", true);
		
		
		List<Map<String, String>> datas=new ArrayList<>();
		
		List<Map<String, String>> historicalDatas=new ArrayList<>();
		
		
		historicalDatas=wrapperProductionService.formatHistoricalDataForWrappedReport(sdate);

		datas=wrapperProductionService.formatDataForWrappedReport(sdate,edate);

		

		model.addAttribute("hisdatas", historicalDatas);
		model.addAttribute("datas", datas);
		
		
		
		return "PM5/productionWastepaper/productionWrapReport";
	}


	@RequestMapping(value="/export",method=RequestMethod.POST)
	public void exportData(HttpServletRequest request,
			HttpServletResponse response,
			Model model) throws IOException, ProductionException {
		
		//
		//refreshResource.refresh();
		
		
		Date sdate=CommonUtil.checkDate(request.getParameter("sdate"), dateFormat);
		Date edate=CommonUtil.checkDate(request.getParameter("edate"), dateFormat);
		
		model.addAttribute("sdate", dateFormat.format(sdate));
		model.addAttribute("edate", dateFormat.format(edate));
		model.addAttribute("viewFlag", true);
		
		

		
	

		List<Map<String, String>> historicalDatas=wrapperProductionService.formatHistoricalDataForWrappedReport(sdate);
		
		List<Map<String, String>> datas=wrapperProductionService.formatDataForWrappedReport(sdate, edate);
		
		
		response.setContentType("application/vnd.ms-excel");
		response.setHeader("Content-Disposition", "attachment; filename=PM6 Production Report.xls");
		
		File file=new File(context.getRealPath("/")+"WEB-INF/excel template/productionWrapper/Production Wrapped Report.xls");

		HSSFWorkbook workbook=wrapperProductionService.getFormatedWorkbookForDailyReport(file,datas,historicalDatas,sdate,edate);
		workbook.write(response.getOutputStream());

	}
	
	

	
	@RequestMapping(value="/gradenhours",method=RequestMethod.GET)
	public String gradeAndHours(Model model) throws ProductionException, IOException {
		model.addAttribute("sdate", dateFormat.format(CommonUtil.getFirstDate()));
		model.addAttribute("edate", dateFormat.format(new Date()));
		return "PM5/productionWastepaper/gradeAndHoursReport";
	}
	
	
	
	
	@RequestMapping(value="/email/gradenhours",method=RequestMethod.GET)
	public @ResponseBody boolean mailDataGradeAndHours(@RequestParam("sdate")String sdate,@RequestParam("edate")String edate) throws ProductionException, IOException {
		try {
			productionReportAutoMailer.sendGradeAndHoureMail(CommonUtil.checkDate(sdate, dateFormat),CommonUtil.checkDate(edate, dateFormat));
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	@RequestMapping(value="/export/gradenhours",method=RequestMethod.POST)
	public void exportDataGradeAndHours(@RequestParam("sdate")String sdate,@RequestParam("edate")String edate,HttpServletResponse response) throws Exception{
			
		List<Map<String, Object>> datas=wrapperProductionService.getGradeAndHourData(CommonUtil.checkDate(sdate, dateFormat),CommonUtil.checkDate(edate, dateFormat));
		
		response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
		response.setHeader("Content-Disposition", "attachment; filename=ST_Tissue_Grade_And_Hours.xlsx");
		productionReportHandler.createExcelGradeAndHoursReport(datas, response.getOutputStream());
	}
	
	
	@RequestMapping(value="/inventorysummary",method=RequestMethod.GET)
	public String inventorySummary() throws ProductionException, IOException {
		
		return "PM5/productionWastepaper/inventorySummaryReport";
	}
	
	
	@RequestMapping(value="/export/inventorysummary",method=RequestMethod.GET)
	public void exportInventorySummary(HttpServletResponse response) throws Exception {
		Calendar calendar=Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.add(Calendar.DATE, -1);
		
		Date edate=dateFormat.parse(dateFormat.format(calendar.getTime()));
		Date sdate=dateFormat.parse(dateFormat.format(calendar.getTime()));

		
		List<WrapperProductionPM5> productions=wrapperProductionService.getWrapperForDailyInventory(sdate, edate);
		
		response.setContentType("application/pdf");
		response.setHeader("Content-Disposition", "inline; filename=Inventory_Daily_Summary.pdf");
		productionReportHandler.createPdfInventoryDailySummary(productions,response.getOutputStream());
	}
	
	
	@RequestMapping(value="/email/inventorysummary",method=RequestMethod.GET)
	public @ResponseBody boolean mailInventorysummary() throws ProductionException, IOException {
		try {
			productionReportAutoMailer.sendInventoryDailySummary();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	@RequestMapping(value="/wrapperAverage",method=RequestMethod.GET)
	public String wrapperAvgByGrade(Model model) throws ProductionException, IOException {
		model.addAttribute("sdate", dateFormat.format(new Date()));
		model.addAttribute("edate", dateFormat.format(new Date()));
		model.addAttribute("viewFlag", false);
		return "PM5/productionWastepaper/wrapperAvgByGrade";
	}
	
	@RequestMapping(value="/wrapperAverage/data",method=RequestMethod.GET)
	public String wrapperAvgByGradeData(@RequestParam("sdate")String sdate,
			@RequestParam("edate")String edate,
			Model model) throws ProductionException, IOException {
		
		model.addAttribute("sdate",sdate);
		model.addAttribute("edate", edate);
		
		List<WrapperProductionPM5> productions=wrapperProductionService.getWrapperAvgByGrade(CommonUtil.checkDate(sdate, dateFormat),CommonUtil.checkDate(edate, dateFormat));
		
		model.addAttribute("productions", productions);
		model.addAttribute("viewFlag", true);
		
		return "PM5/productionWastepaper/wrapperAvgByGrade";
	}
	
	@RequestMapping(value="/wrapperAverage/export",method=RequestMethod.GET)
	public void wrapperAvgByGradeExport(@RequestParam("sdate")String sdate,
			@RequestParam("edate")String edate,HttpServletResponse response) throws ProductionException, IOException {
		
			List<WrapperProductionPM5> productions=wrapperProductionService.getWrapperAvgByGrade(CommonUtil.checkDate(sdate, dateFormat),CommonUtil.checkDate(edate, dateFormat));
			response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
			response.setHeader("Content-Disposition", "attachment; filename=Wrapper_Average_Report.xlsx");
			
			productionReportHandler.createWrapperAverageReport(productions,response.getOutputStream());
		
	}
	
	
	
	@RequestMapping("/dataByDate")
	public String wrapperDataByDate(Model model) {
		model.addAttribute("sdate", dateFormat.format(new Date()));
		model.addAttribute("edate", dateFormat.format(new Date()));
		return "productionWastepaper/wrapperByDateView";
		
	}
	
	@RequestMapping("/dataByDate/export")
	public void wrapperDataByDateExport(@RequestParam("sdate")String sdate,@RequestParam("edate")String edate,HttpServletResponse response) throws IOException, ProductionException {
		
		response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
		response.setHeader("Content-Disposition", "attachment; filename=ST_Tissue_Wrapper_By_Date.xlsx");
		
		List<WrapperProductionPM5> wrapperProductions=wrapperProductionService.getWrapperDataByDate(CommonUtil.checkDate(sdate, dateFormat),CommonUtil.checkDate(edate, dateFormat));
		
		productionReportHandler.createWrapperByDateReport(wrapperProductions,response.getOutputStream());
		
	}
	
	
	
	
	@RequestMapping(value="/gradenhoursWithSummary",method=RequestMethod.GET)
	public String gradeAndHoursWithSummary(Model model) throws ProductionException, IOException {
		model.addAttribute("sdate", dateFormat.format(CommonUtil.getFirstDate()));
		model.addAttribute("edate", dateFormat.format(new Date()));
		return "PM5/productionWastepaper/gradeAndHoursWithSummaryReport";
	}
	
	
	
	
	@RequestMapping(value="/email/gradenhoursWithSummary",method=RequestMethod.GET)
	public @ResponseBody boolean mailDataGradeAndHoursWithSummary(@RequestParam("sdate")String sdate,@RequestParam("edate")String edate) throws ProductionException, IOException {
		try {
			productionReportAutoMailer.sendGradeAndHoureWithSummaryMail(CommonUtil.checkDate(sdate, dateFormat),CommonUtil.checkDate(edate, dateFormat));
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	@RequestMapping(value="/export/gradenhoursWithSummary",method=RequestMethod.POST)
	public void exportDataGradeAndHoursWithSummary(@RequestParam("sdate")String sdate,@RequestParam("edate")String edate,HttpServletResponse response) throws Exception{
	
		List<Map<String, Object>> datas=wrapperProductionService.getGradeAndHourData(CommonUtil.checkDate(sdate, dateFormat),CommonUtil.checkDate(edate, dateFormat));
		
		response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
		response.setHeader("Content-Disposition", "attachment; filename=ST_Tissue_Grade_And_Hours_With_Summary.xlsx");
		productionReportHandler.createExcelGradeAndHoursWithSummaryReport(datas, response.getOutputStream());
	}
	
}

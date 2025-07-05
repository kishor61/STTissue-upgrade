/**
 *Oct 30, 2019
 *ObccPM5ReportController.java
 * TODO
 *com.st.obccPM5.controller
 *ObccPM5ReportController.java
 *Roshan Lal Tailor
 */
package com.st.obccPM5.controller;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.st.common.CommonUtil;
import com.st.common.exception.ProductionException;
import com.st.obcc.model.OperatorData;
import com.st.obcc.model.R1Operator;
import com.st.obcc.model.UtilityOperator;
import com.st.obccPM5.model.LeadOperatorPM5;
import com.st.obccPM5.model.R1OperatorPM5;
import com.st.obccPM5.model.R1WaterJetsDown;
import com.st.obccPM5.model.R2OperatorPM5;
import com.st.obccPM5.model.R2WaterJetsDown;
import com.st.obccPM5.model.StockOperatorPM5;
import com.st.obccPM5.model.UtilityOperatorPM5;
import com.st.obccPM5.model.WinderDown;
import com.st.obccPM5.report.handler.Obcc1PM5ReportHandler;
import com.st.obccPM5.report.handler.Obcc1PM5pdfReportHandler;
import com.st.obccPM5.service.LeadOperatorPM5Service;
import com.st.obccPM5.service.R1OperatorPM5Service;
import com.st.obccPM5.service.R1WaterJetsDownService;
import com.st.obccPM5.service.R2OperatorPM5Service;
import com.st.obccPM5.service.R2WaterJetsDownService;
import com.st.obccPM5.service.StockOperatorPM5Service;
import com.st.obccPM5.service.UtilityOperatorPM5Service;
import com.st.obccPM5.service.WinderDownService;
/**
 * @author roshan
 *OBCCPM5Report/
 */
@Controller
@RequestMapping("/OBCCPM5Report")
public class Obcc1PM5ReportController {
	private SimpleDateFormat format = new SimpleDateFormat("MM-dd-yyyy");

@Autowired
private ServletContext context;

@Autowired
private LeadOperatorPM5Service leadOperatorService;	
@Autowired
private StockOperatorPM5Service stockOperatorService;
@Autowired
private R1OperatorPM5Service r1Operatorpm5Service;
@Autowired
private R2OperatorPM5Service r2Operatorpm5Service;
@Autowired
private UtilityOperatorPM5Service utilityOperatorPM5Service;
@Autowired
private R1WaterJetsDownService r1WaterJetsDowService;
@Autowired
private R2WaterJetsDownService r2WaterJetsDowService;
@Autowired
private WinderDownService winderDownService;
@Autowired
private Obcc1PM5ReportHandler obccpm5ReportHandler;

@Autowired
private Obcc1PM5pdfReportHandler obccpm5PdfReportHandler;


@RequestMapping(value = "/view", method = RequestMethod.GET)
public String OBCCPM5ReportView(Model model) {

	model.addAttribute("startDate",
			format.format(CommonUtil.getFirstDate(new Date())));
	model.addAttribute("endDate", format.format(new Date()));
	return "PM5/Obccpm5Report";
}

@RequestMapping(value = "/viewDownload", method = RequestMethod.GET)
public String obccreportDownloadedView(Model model) {

	model.addAttribute("startDate",
			format.format(CommonUtil.getFirstDate(new Date())));
	model.addAttribute("endDate", format.format(new Date()));
	
	return "PM5/ObccDownlodeReportPM5";
}

@RequestMapping(value = "/view/report/data/detailedreport/export", method = RequestMethod.POST)
public void exportXml(@RequestParam("startDate") String startDate,
		@RequestParam("endDate") String endDate,
		@RequestParam("position") String position,
		@RequestParam("shift") String shift, HttpServletResponse response,
		HttpServletRequest request) throws Exception {

	if (position.equals("R2")) {
		if (shift.equals("both")) {
			List<R2OperatorPM5> daylst = r2Operatorpm5Service.getOperatorDataList(
					position, "day", startDate, endDate);
			List<R2OperatorPM5> nightlst = r2Operatorpm5Service.getOperatorDataList(
					position,"night", startDate, endDate);
			long l = r2Operatorpm5Service.getDataCountDatePercentage(position,
					startDate, endDate,"both");
			//int days = CommonUtil.getDaysDiffernce(format.parse(startDate), format.parse(endDate))+1;
			
			response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
			response.setHeader("Content-Disposition",
					"attachment; filename=R2Operatorpm5.xlsx");
			File file = new File(context.getRealPath("/")
					+ "WEB-INF/R2Operatorpm5.xlsx");
			obccpm5ReportHandler.getExcelReportR2OperatorPM5DayNight(daylst,nightlst, file,
					response.getOutputStream(), l);
		
		}
		else if(shift.equals("day"))
		{
			List<R2OperatorPM5> lst = r2Operatorpm5Service.getOperatorDataList(
					position, shift,startDate, endDate);

			long l = r2Operatorpm5Service.getDataCountDatePercentage(position,
					startDate, endDate,"day");
			//int days = CommonUtil.getDaysDiffernce(format.parse(startDate), format.parse(endDate))+1;

			response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
			response.setHeader("Content-Disposition",
					"attachment; filename=DayR2Operatorpm5.xlsx");
			File file = new File(context.getRealPath("/")
					+ "WEB-INF/DayR2Operatorpm5.xlsx");

     				obccpm5ReportHandler.getExcelReportR2OperatorPM5Day(lst, file,
					response.getOutputStream(), l);
		}
		else
		{
			List<R2OperatorPM5> lst = r2Operatorpm5Service.getOperatorDataList(
					position, shift, startDate, endDate);

			long l = r2Operatorpm5Service.getDataCountDatePercentage(position,
					startDate, endDate,"night");
			//int days = CommonUtil.getDaysDiffernce(format.parse(startDate), format.parse(endDate))+1;

			response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
			response.setHeader("Content-Disposition",
					"attachment; filename=NightR2Operatorpm5.xlsx");
			File file = new File(context.getRealPath("/")
					+ "WEB-INF/NightR2Operatorpm5.xlsx");

			obccpm5ReportHandler.getExcelReportR2OperatorPM5Night(lst, file,
					response.getOutputStream(), l);
		}

	} else if (position.equals("leadoperator")) {
		
			if (shift.equals("both")) {
				List<LeadOperatorPM5>  daylst = leadOperatorService
						.getOperatorDataList(position, startDate, endDate,"day");
				List<LeadOperatorPM5>  nightlst = leadOperatorService
						.getOperatorDataList(position, startDate, endDate,"night");
				
				long l = leadOperatorService.getDataCountDatePercentage(position, startDate, endDate,"both");
	
				response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
				response.setHeader("Content-Disposition",
						"attachment; filename=LeadOperatorpm5.xlsx");
				File file = new File(context.getRealPath("/")
						+ "WEB-INF/LeadOperatorpm5.xlsx");
	
				obccpm5ReportHandler.getExcelReportForLeadOperatorPM5DayNight(daylst,nightlst, file,
					response.getOutputStream(), l);
			}else if(shift.equals("day"))
			{
				List<LeadOperatorPM5> 	lst = leadOperatorService
						.getOperatorDataList(position, startDate, endDate,shift);
			
	
				long l = leadOperatorService.getDataCountDatePercentage(position, startDate, endDate,"day");
	
				response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
				response.setHeader("Content-Disposition",
						"attachment; filename=DayLeadOperatorpm5.xlsx");
				File file = new File(context.getRealPath("/")
						+ "WEB-INF/DayLeadOperatorpm5.xlsx");
	
				obccpm5ReportHandler.getExcelReportForLeadOperatorPM5Day(lst, file,
					response.getOutputStream(), l);
			}
			else{
					List<LeadOperatorPM5> 	lst = leadOperatorService
						.getOperatorDataList(position, startDate, endDate,shift);
			
	
					long l = leadOperatorService.getDataCountDatePercentage(position, startDate, endDate,"night");
	
				response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
				response.setHeader("Content-Disposition",
						"attachment; filename=NightLeadOperatorpm5.xlsx");
				File file = new File(context.getRealPath("/")
						+ "WEB-INF/NightLeadOperatorpm5.xlsx");
	
				obccpm5ReportHandler.getExcelReportForLeadOperatorPm5Night(lst, file,
					response.getOutputStream(), l);
			}

	} else if (position.equals("R1")) {
			if(shift.equals("both"))
			{
				List<R1OperatorPM5> both = r1Operatorpm5Service.getOperatorDataListForBothShift(position, startDate, endDate);
				
				long l = r1Operatorpm5Service.getDataCountDatePercentage(position,startDate, endDate,"both");
	
				response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
				response.setHeader("Content-Disposition",
						"attachment; filename=R1Operatorpm5.xlsx");
				File file = new File(context.getRealPath("/")
						+ "WEB-INF/R1Operatorpm5.xlsx");
	
				obccpm5ReportHandler.getExcelReportForR1OperaotrPM5DayNight(both, file,
					response.getOutputStream(), l);
			}else
			{
				List<R1OperatorPM5> lst = r1Operatorpm5Service.getOperatorDataList(position,shift, startDate, endDate);
				
				long l = r1Operatorpm5Service.getDataCountDatePercentage(position,startDate, endDate,"night");
	
				response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
				response.setHeader("Content-Disposition",
						"attachment; filename=NightR1Operatorpm5.xlsx");
				File file = new File(context.getRealPath("/")
						+ "WEB-INF/NightR1Operatorpm5.xlsx");
	
				obccpm5ReportHandler.getExcelReportForR1OperaotrPM5(lst, file,
					response.getOutputStream(), l);
			}

	} else if (position.equals("stockoperator")) {

				if (shift.equals("both")) {
					List<StockOperatorPM5> daylst =stockOperatorService
							.getStockOperatorPm5DataList(position, startDate, endDate,"day");
					List<StockOperatorPM5> nightlst =stockOperatorService
							.getStockOperatorPm5DataList(position, startDate, endDate,"night");
	
					long l =stockOperatorService.getDataCountDatePercentage(position, startDate, endDate, "both");
	
					response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
					response.setHeader("Content-Disposition",
							"attachment; filename=StockOperatorpm5.xlsx");
					File file = new File(context.getRealPath("/")
							+ "WEB-INF/StockOperatorpm5.xlsx");
	
					obccpm5ReportHandler.getExcelReportForStockOperatorPM5DayNight(daylst,nightlst, file, response.getOutputStream(), l);
	
				} else if(shift.equalsIgnoreCase("night")){
					List<StockOperatorPM5> lst =stockOperatorService.getStockOperatorPm5DataList(position, startDate, endDate,shift);
	
					long l =stockOperatorService.getDataCountDatePercentage(position, startDate, endDate, shift);
					response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
					response.setHeader("Content-Disposition",
							"attachment; filename=NightStockOperatorpm5.xlsx");
					File file = new File(context.getRealPath("/")
							+ "WEB-INF/NightStockOperatorpm5.xlsx");
	
					obccpm5ReportHandler.getExcelReportForStockOperatorPM5Night(lst,file, response.getOutputStream(), l);
				}else
				{
					List<StockOperatorPM5> lst =stockOperatorService.getStockOperatorPm5DataList(position, startDate, endDate,shift);
	
					long l =stockOperatorService.getDataCountDatePercentage(position, startDate, endDate, shift);
					response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
					response.setHeader("Content-Disposition",
							"attachment; filename=DayStockOperatorpm5.xlsx");
					File file = new File(context.getRealPath("/")
							+ "WEB-INF/DayStockOperatorpm5.xlsx");
	
					obccpm5ReportHandler.getExcelReportForStockOperatorPM5Day(lst,file, response.getOutputStream(), l);
				}

	}
	else if (position.equals("utilityoperator")) {
		if (shift.equals("both")) {
			List<UtilityOperatorPM5> both = utilityOperatorPM5Service.getOperatorDataListForBothShift(
					position, startDate, endDate);
			
			long l = utilityOperatorPM5Service.getDataCountDatePercentage(position,"both",startDate, endDate);
	
			response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
			response.setHeader("Content-Disposition",
					"attachment; filename=UtilityWaterJetsPM5.xlsx");
			File file = new File(context.getRealPath("/")
					+ "WEB-INF/UtilityWaterJetsPM5.xlsx");
			obccpm5ReportHandler.getExcelReportUtilityOperatorPM5DayNight(both, file,
					response.getOutputStream(), l);
		
		}
		else if(shift.equals("day"))
		{
			List<UtilityOperatorPM5> lst = utilityOperatorPM5Service.getOperatorDataList(
					position, shift,startDate, endDate);

			long l = utilityOperatorPM5Service.getDataCountDatePercentage(position,shift,startDate, endDate);


			response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
			response.setHeader("Content-Disposition",
					"attachment; filename=DayUtilityOperatorPM5.xlsx");
			File file = new File(context.getRealPath("/")
					+ "WEB-INF/UtilityWaterJetsPM5.xlsx");

     				obccpm5ReportHandler.getExcelReportUtilityOperatorPM5Day(lst, file,
					response.getOutputStream(), l);
		}
		else
		{
			List<UtilityOperatorPM5> lst = utilityOperatorPM5Service.getOperatorDataList(
					position, shift, startDate, endDate);

			long l = utilityOperatorPM5Service.getDataCountDatePercentage(position,shift,
					startDate, endDate);


			response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
			response.setHeader("Content-Disposition",
					"attachment; filename=NightUtilityOperatorPM5.xlsx");
			File file = new File(context.getRealPath("/")
					+ "WEB-INF/UtilityWaterJetsPM5.xlsx");

			obccpm5ReportHandler.getExcelReportUtilityOperatorPM5Night(lst, file,
					response.getOutputStream(), l);
		}
	}
	else if (position.equals("R1WaterJetsDown")) {
		if (shift.equals("both")) {
			List<R1WaterJetsDown> both = r1WaterJetsDowService.getOperatorDataListForBothShift(	position, startDate, endDate);
			long l = r1WaterJetsDowService.getDataCountDatePercentage(position,"both",startDate, endDate);
	
			response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
			response.setHeader("Content-Disposition",
					"attachment; filename=R1WaterJetsDown.xlsx");
			File file = new File(context.getRealPath("/")
					+ "WEB-INF/R1WaterJetsDown.xlsx");
			obccpm5ReportHandler.getExcelReportR1WaterJetsDownDayNight(both, file,response.getOutputStream(), l);
		
		}
		else 
		{
			List<R1WaterJetsDown> lst = r1WaterJetsDowService.getOperatorDataList(
					position, shift,startDate, endDate);

			long l = r1WaterJetsDowService.getDataCountDatePercentage(position,shift,startDate, endDate);


			response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
			response.setHeader("Content-Disposition",
					"attachment; filename=R1WaterJetsDown.xlsx");
			File file = new File(context.getRealPath("/")
					+ "WEB-INF/R1WaterJetsDown.xlsx");

     				obccpm5ReportHandler.getExcelReportR1WaterJetsDown(lst, file,
					response.getOutputStream(), l);
		}
	}
	else if (position.equals("R2WaterJetsDown")) {
		if (shift.equals("both")) {
			List<R2WaterJetsDown> both = r2WaterJetsDowService.getOperatorDataListForBothShift(
					position, startDate, endDate);
			long l = r2WaterJetsDowService.getDataCountDatePercentage(position,"both",startDate, endDate);
	
			response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
			response.setHeader("Content-Disposition",
					"attachment; filename=R2WaterJetsDown.xlsx");
			File file = new File(context.getRealPath("/")
					+ "WEB-INF/R2WaterJetsDown.xlsx");
			obccpm5ReportHandler.getExcelReportR2WaterJetsDownDayNight(both, file,
					response.getOutputStream(), l);
		
		}
		else 
		{
			List<R2WaterJetsDown> lst = r2WaterJetsDowService.getOperatorDataList(
					position, shift,startDate, endDate);

			long l = r2WaterJetsDowService.getDataCountDatePercentage(position,shift,startDate, endDate);


			response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
			response.setHeader("Content-Disposition",
					"attachment; filename=R2WaterJetsDown.xlsx");
			File file = new File(context.getRealPath("/")
					+ "WEB-INF/R2WaterJetsDown.xlsx");

     				obccpm5ReportHandler.getExcelReportR2WaterJetsDown(lst, file,
					response.getOutputStream(), l);
		}
	}
	else if (position.equals("WinderDown")) {
		if (shift.equals("both")) {
			List<WinderDown> both = winderDownService.getOperatorDataListForBothShift(
					position, startDate, endDate);
			long l = winderDownService.getDataCountDatePercentage(position,"both",startDate, endDate);
	
			response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
			response.setHeader("Content-Disposition",
					"attachment; filename=UtilityWinderPM5.xlsx");
			File file = new File(context.getRealPath("/")
					+ "WEB-INF/UtilityWinderPM5.xlsx");

			obccpm5ReportHandler.getExcelReportWinderDownDayNight(both, file,
					response.getOutputStream(), l);
		
		}
		else 
		{
			List<WinderDown> lst = winderDownService.getOperatorDataList(
					position, shift,startDate, endDate);

			long l = winderDownService.getDataCountDatePercentage(position,shift,startDate, endDate);


			response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
			response.setHeader("Content-Disposition",
					"attachment; filename=UtilityWinderPM5.xlsx");
			File file = new File(context.getRealPath("/")
					+ "WEB-INF/UtilityWinderPM5.xlsx");

     				obccpm5ReportHandler.getExcelReportWinderDown(lst, file,
					response.getOutputStream(), l);
		}
	}
}

@RequestMapping(value = "/view/report/data/detailedreport/export/PDF", method = RequestMethod.GET)
public String exportPDF(@RequestParam(value = "sdate") String sdate,
		@RequestParam(value = "edate") String edate,
		@RequestParam(value = "position") String position,
		@RequestParam(value = "shift") String shift,
		HttpServletResponse response, HttpServletRequest request,
		RedirectAttributes redirectAttributes) throws Exception {

	if (shift.equals("-1")) {
			if (position.equals("R2")) {
					List<R2OperatorPM5> lst = r2Operatorpm5Service.getOperatorDataList(
							position, sdate, edate);
	
					long l = r2Operatorpm5Service.getDataCountDatePercentage(position,
							sdate, edate,"both");
	
					if (lst.size() != 0) {
						response.setContentType("application/pdf");
						response.setHeader("Content-Disposition",
								"attachment; filename=R2 Operator.pdf");
						obccpm5PdfReportHandler.createR2Pdf(lst,
								response.getOutputStream(), l);
					} else {
						redirectAttributes.addFlashAttribute("message",
								"Data Not Found For Selected Createrria.");
						return "redirect:/OBCCPM5Report/view";
					}

			} else if (position.equals("R1")) {
					List<R1OperatorPM5> lst = r1Operatorpm5Service.getOperatorDataList(
							position, shift,sdate, edate);
					// System.out.println("lst"+lst);
	
					long l = r1Operatorpm5Service.getDataCountDatePercentage(position,sdate, edate,"both");
	
					if (lst.size() != 0) {
						response.setContentType("application/pdf");
						response.setHeader("Content-Disposition",
								"attachment; filename=R1 Operator.pdf");
						obccpm5PdfReportHandler.createR1OperatorPdf(lst,
								response.getOutputStream(), l);
					} else {
						redirectAttributes.addFlashAttribute("message",
								"Data Not Found For Selected Createrria.");
						return "redirect:/OBCCPM5Report/view";
					}

			}else if (position.equals("StockOperatorPM5")) {

					List<StockOperatorPM5> daylst = null;
					List<StockOperatorPM5> nightlst = null;
					if (shift.equalsIgnoreCase("day")) {
						daylst =stockOperatorService.getStockOperatorPm5DataList(position,
							sdate, edate, "day");
					} else if (shift.equalsIgnoreCase("night")) {
							nightlst =stockOperatorService.getStockOperatorPm5DataList(
									position, sdate, edate, "night");
					} else {
							daylst =stockOperatorService.getStockOperatorPm5DataList(position,
									sdate, edate, "day");
							nightlst =stockOperatorService.getStockOperatorPm5DataList(
									position, sdate, edate, "night");
							}		
	
					long l =stockOperatorService.getDataCountDatePercentage(position, sdate, edate, shift);
						
					if (daylst != null && daylst.size() != 0 || nightlst != null
						&& nightlst.size() != 0) {
						response.setContentType("application/pdf");
						response.setHeader("Content-Disposition","attachment; StockOperatorPM5.pdf");
						obccpm5PdfReportHandler.createStockOperatorPM5Pdf(daylst,
									nightlst, response.getOutputStream(), l);
							
					} else {
							redirectAttributes.addFlashAttribute("message",
								"Data Not Found For Selected Createrria.");
							return "redirect:/OBCCPM5Report/view";
						}
			} else if (position.equals("leadoperator")) {
					List<LeadOperatorPM5> daylst = null;
					List<LeadOperatorPM5> nightlst = null;
					if (shift.equalsIgnoreCase("day")) {
						daylst = leadOperatorService.getOperatorDataList(position,
								sdate, edate, "day");
					} else if (shift.equalsIgnoreCase("night")) {
						nightlst = leadOperatorService.getOperatorDataList(position,
								sdate, edate, "night");
					} else {
						daylst = leadOperatorService.getOperatorDataList(position,
								sdate, edate, "day");
						nightlst = leadOperatorService.getOperatorDataList(position,
								sdate, edate, "night");
					}
	
					long l = leadOperatorService.getDataCountDatePercentage(position,
							sdate, edate, shift);
	
					if (daylst != null && daylst.size() != 0 || nightlst != null
							&& nightlst.size() != 0) {
						response.setContentType("application/pdf");
						response.setHeader("Content-Disposition",
								"attachment; filename=Back Tender.pdf");
						obccpm5PdfReportHandler.createLeadOperatorPM5Pdf(daylst,
								nightlst, response.getOutputStream(), l);
					}
					else {
						redirectAttributes.addFlashAttribute("message",
								"Data Not Found For Selected Createrria.");
					return "redirect:/OBCCPM5Report/view";
					}
			}else
			{
				 
			}
	}	
			
			return "redirect:/OBCCPM5Report/view";

	}

@RequestMapping(value = "/view/report/data/detailedreport/exportPercentage", method = RequestMethod.POST)
public void exportPecenatgeData(@RequestParam("startDate") String startDate,@RequestParam("endDate") String endDate,HttpServletResponse response, HttpServletRequest request)
		throws Exception {
	
	
			int startMonth = getMonth(startDate); 
			int endMonth =   getMonth(endDate);
		   
			int startYear = getYear(startDate); 
			int endYear =   getYear(endDate);
			long   r2percent,ledpercent,r1percent,stockpercent,utilipercent,r1WaterJetspercent,r2WaterJetspercent,winderDownpercent,avarage;
		   
			int n = 0;
		    Date d1;
			try {
				 d1 = format.parse(startDate);
				 Date d2 = format.parse(endDate);
				 n = differenceInMonths(d1, d2);
				
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
			System.out.println("startDate" + startMonth);
			System.out.println("endDate" + endMonth);   
			System.out.println("diff in months"+n); 
			System.out.println("startYear" + startYear);
			System.out.println("endYear" + endYear); 
			
			if(startYear!=endYear)
			{
				endMonth = n;   
			}
			else
			{
				
			}
			  Map<Date, Long> R2map = new TreeMap<Date, Long>();	
			  Map<Date, Long> R1map = new TreeMap<Date, Long>();	
			  Map<Date, Long> Ledmap = new TreeMap<Date, Long>();	
			  Map<Date, Long> Stockmap = new TreeMap<Date, Long>();
			  Map<Date, Long> utilitymap = new TreeMap<Date, Long>();
			  Map<Date, Long> Avgmap = new TreeMap<Date, Long>();
			  Map<Date, Long> R1WaterJetsmap = new TreeMap<Date, Long>();
			  Map<Date, Long> R2WaterJetsmap = new TreeMap<Date, Long>();
			  Map<Date, Long> WinderDownmap = new TreeMap<Date, Long>();
			 
		   	for (int i = 0; i <= n; i++) 
		   	{
		   		String getlastDayofMonth = null;
			   
			   if(checksameMonth(startDate,endDate) == true)
			   {
				   getlastDayofMonth = endDate;
			   }
			   else
			   {
				   getlastDayofMonth = getLastDateOfMonth(startDate);
			   }
			   
			  
			  ledpercent=leadOperatorService.getDataCountDatePercentage("leadoperator", startDate, endDate, "both");
			  stockpercent=stockOperatorService.getDataCountDatePercentage("stockoperator", startDate, endDate, "both");			 
			  r1percent=r1Operatorpm5Service.getDataCountDatePercentage("R1", startDate, endDate, "both");
			  r1WaterJetspercent=r1WaterJetsDowService.getDataCountDatePercentage("R1WaterJetsDown","both",startDate, endDate);
			  r2WaterJetspercent=r2WaterJetsDowService.getDataCountDatePercentage("R2WaterJetsDown","both",startDate, endDate);
			  r2percent=r2Operatorpm5Service.getDataCountDatePercentage("R2", startDate, endDate, "both");
			  winderDownpercent=winderDownService.getDataCountDatePercentage("WinderDown","both",startDate, endDate);
			  utilipercent=utilityOperatorPM5Service.getDataCountDatePercentage("utilityoperator", "both", startDate, endDate);
				 
			 long noOfDaysBetween =  CommonUtil.getDaysDiffernce(format.parse(startDate), format.parse(endDate))+1;
			 
			  if(noOfDaysBetween==0)
				  noOfDaysBetween=1;
			  String dt=startDate;
			  long utwin=0,utwin1=0,utwin2=0,r1winder=0,r1WaterJets=0,r2WaterJets=0,r2winder=0,r1=0,r2=0;
			 for(long k=1;k<=noOfDaysBetween;k++)
			 {
				 utwin1=winderDownService.getDataCountDatePercentage("WinderDown","both",dt, dt);
				 utwin2=utilityOperatorPM5Service.getDataCountDatePercentage("utilityoperator", "both", dt, dt);
				 r1winder=r1Operatorpm5Service.getDataCountDatePercentage("R1", dt, dt, "both");
				 r1WaterJets=r1WaterJetsDowService.getDataCountDatePercentage("R1WaterJetsDown","both",dt, dt);
				 r2WaterJets=r2WaterJetsDowService.getDataCountDatePercentage("R2WaterJetsDown","both",dt, dt);
				 r2winder=r2Operatorpm5Service.getDataCountDatePercentage("R2", dt, dt, "both");
				  
				 Calendar c = Calendar.getInstance();
				 c.setTime(format.parse(dt));
				 c.add(Calendar.DATE, 1);
				 dt = format.format(c.getTime());
				 if(utwin1==100)
					 utwin+=utwin1;
				 else if(utwin2==100)
					 utwin+=utwin2;
				 else 
					 utwin+=(utwin2+utwin1);
				 if(r1winder==100)
					 r1+=r1winder;
				 else if(r1WaterJets==100)
					 r1+=r1WaterJets;
				 else 
					 r1+=(r1winder+r1WaterJets);
				 if(r2WaterJets==100)
					 r2+=r2WaterJets;
				 else if(r2winder==100)
					 r2+=r2winder;
				 else 
					 r2+=(r2WaterJets+r2winder);
			 }
			 utwin= utwin/noOfDaysBetween;
			 r1= r1/noOfDaysBetween;
			 r2= r2/noOfDaysBetween;
			  avarage=(ledpercent+stockpercent+utwin+r1+r2)/5;
				  startDate = addOneMonth(startDate);
				  R2map.put(format.parse(getlastDayofMonth), r2percent);
				  Ledmap.put(format.parse(getlastDayofMonth), ledpercent);
				  R1map.put(format.parse(getlastDayofMonth), r1percent);
				  Stockmap.put(format.parse(getlastDayofMonth), stockpercent);
				  utilitymap.put(format.parse(getlastDayofMonth), utilipercent);
				  R1WaterJetsmap.put(format.parse(getlastDayofMonth), r1WaterJetspercent);
				  R2WaterJetsmap.put(format.parse(getlastDayofMonth), r2WaterJetspercent);
				  WinderDownmap.put(format.parse(getlastDayofMonth), winderDownpercent);
				  Avgmap.put(format.parse(getlastDayofMonth),  avarage);
				  //startMonth = startMonth+1;
		   	}
			

	
	response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
	response.setHeader("Content-Disposition",
			"attachment; filename=OBCCDownloadPM5.xlsx");
	File file = new File(context.getRealPath("/")+ "WEB-INF/OBCCDownloadPM5.xlsx");	
	obccpm5ReportHandler.getExcelReportbyPercentage( R2map, Ledmap, R1map,Stockmap, utilitymap,R1WaterJetsmap,R2WaterJetsmap,WinderDownmap,Avgmap,file,response.getOutputStream());
}

@RequestMapping(value = "/view/report/data/detailedreport/email", method = RequestMethod.POST)
public @ResponseBody boolean breakFreeProductiondataemail(
		@RequestParam("sdate") String sdate,
		@RequestParam("edate") String edate,
		@RequestParam("position") String position,
		HttpServletResponse response, Model model,
		HttpServletRequest request) throws IOException, ProductionException {
	try {

		if (position.equals("R1")) {
			List<R2WaterJetsDown> lst = r2WaterJetsDowService.getOperatorDataList(
					position, "both",sdate, edate);
			if (lst.size() != 0) {
				//obccreportingmailer.getOBCCR1ReportingMail(position, sdate,edate);
			}
		} 
		// meahinebreakfreeproductionreportmailer.getMachineBreakFreeProductionMail(sDate,eDate,shift);
	} catch (Exception e) {
		e.printStackTrace();
		return false;
	}

	return true;

}

@RequestMapping(value = "/view/report/data/detailedreport/count", method = RequestMethod.POST)
public @ResponseBody long getDataForProcessbar(
		@RequestParam("sdate") String sdate,
		@RequestParam("edate") String edate,
		@RequestParam("position") String position,
		@RequestParam("shift") String shift, HttpServletResponse response,
		Model model, HttpServletRequest request) {
	long count = 0;
	try {

		if (position.equals("R1")) {
			count =r2Operatorpm5Service.getDataCountDatePercentage("R2", sdate, edate, "both");
			model.addAttribute("percenteage", count);

		} 
		return count;
	} catch (Exception e) {
		e.printStackTrace();
		return 0;
	}

}



public static String getLastDateOfMonth(String date) {
	SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
	Date convertedDate;
	try {
		convertedDate = dateFormat.parse(date);
		Calendar c = Calendar.getInstance();
		c.setTime(convertedDate);
		c.set(Calendar.DAY_OF_MONTH,
				c.getActualMaximum(Calendar.DAY_OF_MONTH));
		Date lastDayOfMonth = c.getTime();
		DateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
		return sdf.format(lastDayOfMonth);

	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return null;
	}

}

public static String addOneMonth(String date) {
	SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
	Date convertedDate;
	try {
		convertedDate = dateFormat.parse(date);
		Calendar c = Calendar.getInstance();
		c.setTime(convertedDate);
		c.add(Calendar.MONTH, 1);
		Date lastDayOfMonth = c.getTime();
		DateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
		return sdf.format(lastDayOfMonth);
		
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return null;
	}

}

public static int getYear(String date)
{
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
		Date convertedDate;
		try {
			convertedDate = dateFormat.parse(date);
			Calendar cal = Calendar.getInstance();
		    cal.setTime(convertedDate);
		    return cal.get(Calendar.YEAR);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		}
	 	
}
public static int getMonth(String date)
{
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
		Date convertedDate;
		try {
			convertedDate = dateFormat.parse(date);
			Calendar cal = Calendar.getInstance();
		    cal.setTime(convertedDate);
		    return cal.get(Calendar.MONTH);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		}
	 	
}

public static boolean checksameMonth(String sdate,String edate)
{
	SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
	Date convertedDate1;
	Date convertedDate2;
	try {
		convertedDate1 = dateFormat.parse(sdate);
		convertedDate2 = dateFormat.parse(edate);
		Calendar cal1 = Calendar.getInstance();
		Calendar cal2 = Calendar.getInstance();
		cal1.setTime(convertedDate1);
		cal2.setTime(convertedDate2);
		boolean sameDay = cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR) &&
		                  cal1.get(Calendar.MONTH) == cal2.get(Calendar.MONTH);
		
		return sameDay;
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return false;
	}
	
}

private static int differenceInMonths(final Date s1, final Date s2) {
    final Calendar d1 = Calendar.getInstance();
    d1.setTime(s1);
    final Calendar d2 = Calendar.getInstance();
    d2.setTime(s2);
    int diff = (d2.get(Calendar.YEAR) - d1.get(Calendar.YEAR)) * 12 + d2.get(Calendar.MONTH) - d1.get(Calendar.MONTH);
    return diff;
}

}

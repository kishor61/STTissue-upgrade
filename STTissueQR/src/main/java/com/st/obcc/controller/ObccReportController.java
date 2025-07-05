/**
 *Jul 18, 2016
 *ObccReport.java
 * TODO
 *com.st.obcc.controller
 *ObccReport.java
 *Roshan Lal Tailor
 */
package com.st.obcc.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
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
import com.st.obcc.mailer.ObccReportingMailer;
import com.st.obcc.model.BackTender;
import com.st.obcc.model.MachineTender;
import com.st.obcc.model.OperatorData;
import com.st.obcc.model.R1Operator;
import com.st.obcc.model.StockOperator;
import com.st.obcc.model.UtilityOperator;
import com.st.obcc.report.handler.ObccReportHandler;
import com.st.obcc.report.handler.obccPdfReportHandler;
import com.st.obcc.service.BackTenderService;
import com.st.obcc.service.MachineTenderService;
import com.st.obcc.service.OperatorService;
import com.st.obcc.service.R1OperatorService;
import com.st.obcc.service.StockOperatorService;
import com.st.obcc.service.UtilityOperatorService;

/**
 * @author roshan
 *
 */
@Controller
@RequestMapping("/OBCCReport")
public class ObccReportController {

	private SimpleDateFormat format = new SimpleDateFormat("MM-dd-yyyy");

	private SimpleDateFormat dateFormat3 = new SimpleDateFormat("MMMM yyyy");

	@Autowired
	private ServletContext context;

	@Autowired
	private OperatorService operatorService;

	@Autowired
	private UtilityOperatorService utilityOperatorService;

	@Autowired
	private R1OperatorService r1OperatorService;

	@Autowired
	private ObccReportHandler obccReportHandler;

	@Autowired
	private obccPdfReportHandler obccPdfReportHandler;

	@Autowired
	private MachineTenderService machineTenderService;

	@Autowired
	private StockOperatorService stockOperatorService;

	@Autowired
	private BackTenderService backTenderService;

	@Autowired
	private ObccReportingMailer obccreportingmailer;

	private SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");

	@RequestMapping(value = "/view", method = RequestMethod.GET)
	public String obccreportView(Model model) {

		model.addAttribute("startDate",
				format.format(CommonUtil.getFirstDate(new Date())));
		model.addAttribute("endDate", format.format(new Date()));
		return "OBCCReport";
	}

	@RequestMapping(value = "/view/report/data/detailedreport/export", method = RequestMethod.POST)
	public void export(@RequestParam("startDate") String startDate,
			@RequestParam("endDate") String endDate,
			@RequestParam("position") String position,
			@RequestParam("shift") String shift, HttpServletResponse response,
			HttpServletRequest request) throws Exception {

		SimpleDateFormat df = new SimpleDateFormat("MM-dd-yyyy");

		if (position.equals("R2")) {
			List<OperatorData> lst = operatorService.getOperatorDataList(
					position, startDate, endDate);

			long l = operatorService.getDataCountDatePercentage(position,startDate, endDate);

			// System.out.println("lst"+lst);

			response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
			response.setHeader("Content-Disposition",
					"attachment; filename=R2Operator.xlsx");
			File file = new File(context.getRealPath("/")
					+ "WEB-INF/R2Operator.xlsx");
			//InputStream fi=new FileInputStream("D:\\STTissue.JPG");
			obccReportHandler.getExcelReport(lst, file,response.getOutputStream(), l);

		} else if (position.equals("utilityoperator")) {

			List<UtilityOperator> lst = utilityOperatorService
					.getOperatorDataList(position, startDate, endDate);
			// System.out.println("lst"+lst);

			long l = utilityOperatorService.getDataCountDatePercentage1(position, startDate, endDate);

			response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
			response.setHeader("Content-Disposition",
					"attachment; filename=utilityOperator.xlsx");
			File file = new File(context.getRealPath("/")
					+ "WEB-INF/utilityOperator.xlsx");

			obccReportHandler.getExcelReportForUtility(lst, file,
					response.getOutputStream(), l);

		} else if (position.equals("R1")) {

			List<R1Operator> lst = r1OperatorService.getOperatorDataList(
					position, startDate, endDate);
			// System.out.println("lst"+lst);

			long l = r1OperatorService.getDataCountDatePercentage1(position,
					startDate, endDate);

			response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
			response.setHeader("Content-Disposition",
					"attachment; filename=R1 Operator.xlsx");
			File file = new File(context.getRealPath("/")
					+ "WEB-INF/R1 Operator.xlsx");

			obccReportHandler.getExcelReportForR1Operaotr(lst, file,
					response.getOutputStream(), l);

		} else if (position.equals("machinetender")) {

			if (shift.equals("day")) {
				long l = machineTenderService.getDataCountDatePercentage(position, shift, startDate, endDate);

				List<MachineTender> lst = machineTenderService.getOperatorDataList(position,shift, startDate, endDate);
				// System.out.println("lst"+lst);

				response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
				response.setHeader("Content-Disposition","attachment; filename= DayMachineTender.xlsx");
				File file = new File(context.getRealPath("/")+ "WEB-INF/DayMachineTender.xlsx");
				obccReportHandler.getExcelReportForMachineTenderDay(lst, file,response.getOutputStream(), l);
			} else if (shift.equals("both")) {
				List<MachineTender> daylst = machineTenderService
						.getOperatorDataList(position,"day", startDate, endDate	);
				List<MachineTender> nightlst = machineTenderService
						.getOperatorDataList(position,"night", startDate, endDate);

				long l1 = machineTenderService.getDataCountDatePercentage(
						position, "day", startDate, endDate);
				long l2 = machineTenderService.getDataCountDatePercentage(
						position, "night", startDate, endDate);
				long l3=(l1+l2)/2;

				response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
				response.setHeader("Content-Disposition",
						"attachment; filename= MachineTender.xlsx");
				File file = new File(context.getRealPath("/")
						+ "WEB-INF/MachineTender.xlsx");

				obccReportHandler.getExcelReportForMachineTender(daylst,
						nightlst, file, response.getOutputStream(), l3);

			} else {
				List<MachineTender> lst =  machineTenderService
						.getOperatorDataList(position,shift, startDate, endDate	);
				// System.out.println("lst"+lst);

				long l = machineTenderService.getDataCountDatePercentage(position, shift, startDate, endDate);
				response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
				response.setHeader("Content-Disposition",
						"attachment; filename= NightMachineTender.xlsx");
				File file = new File(context.getRealPath("/")
						+ "WEB-INF/NightMachineTender.xlsx");

				obccReportHandler.getExcelReportForMachineTenderNight(lst,
						file, response.getOutputStream(), l);
			}

		} else if (position.equals("stockoperator")) {

			if (shift.equals("day")) {
				long l = stockOperatorService.getDataCountDatePercentage(position,shift, startDate, endDate);
				List<StockOperator> lst = stockOperatorService
						.getOperatorDataList(position,shift, startDate, endDate);
				// System.out.println("lst"+lst);

				response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
				response.setHeader("Content-Disposition",
						"attachment; filename= DayStockoperator.xlsx");
				File file = new File(context.getRealPath("/")
						+ "WEB-INF/DayStockoperator.xlsx");

				obccReportHandler.getExcelReportForStockOperatorDay(lst, file,
						response.getOutputStream(), l);
			}

			else if (shift.equals("both")) {
				long l1 = stockOperatorService.getDataCountDatePercentage(position,"day", startDate, endDate);
				long l2 = stockOperatorService.getDataCountDatePercentage(position,"night", startDate, endDate);
				long l3=(l1+l2)/2;
				List<StockOperator> daylst = stockOperatorService
						.getOperatorDataList(position,"day", startDate, endDate);
				List<StockOperator> nightlst = stockOperatorService
						.getOperatorDataList(position,"night", startDate, endDate);

				response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
				response.setHeader("Content-Disposition",
						"attachment; filename= Stockoperator.xlsx");
				File file = new File(context.getRealPath("/")
						+ "WEB-INF/Stockoperator.xlsx");

				obccReportHandler.getExcelReportForStockOperator(daylst,
						nightlst, file, response.getOutputStream(), l3);

			} else {
				long l = stockOperatorService.getDataCountDatePercentage(position,shift, startDate, endDate);
				List<StockOperator> lst = stockOperatorService
						.getOperatorDataList(position,shift, startDate, endDate);
				// System.out.println("lst"+lst);

				response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
				response.setHeader("Content-Disposition",
						"attachment; filename= NightStock Operator.xlsx");
				File file = new File(context.getRealPath("/")
						+ "WEB-INF/NightStock Operator.xlsx");

				obccReportHandler.getExcelReportForStockOperatorNight(lst,
						file, response.getOutputStream(), l);
			}

		} else if (position.equals("backtender")) {
			if (shift.equals("day")) {
				long l = backTenderService.getDataCountDatePercentage(position, shift,startDate, endDate);
				List<BackTender> lst = backTenderService.getOperatorDataList(
						position, shift,startDate, endDate);

				response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
				response.setHeader("Content-Disposition",
						"attachment; filename= DayBack Tender.xlsx");
				File file = new File(context.getRealPath("/")
						+ "WEB-INF/DayBack Tender.xlsx");

				obccReportHandler.getExcelReportForDayBacktender(lst, file,
						response.getOutputStream(), l);

			} else if (shift.equals("both")) {
				List<BackTender> daylst = backTenderService
						.getOperatorDataList(position,"day", startDate, endDate);

				List<BackTender> nightlst = backTenderService
						.getOperatorDataList(position,"night", startDate, endDate);
				long l1 = backTenderService.getDataCountDatePercentage(position,"day",startDate, endDate);
				long l2 = backTenderService.getDataCountDatePercentage(position,"night",startDate, endDate);
				long l3=(l1+l2)/2;
				response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
				response.setHeader("Content-Disposition",
						"attachment; filename= BackTender.xlsx");
				File file = new File(context.getRealPath("/")
						+ "WEB-INF/BackTender.xlsx");

				obccReportHandler.getExcelReportForBacktender(daylst, nightlst,
						file, response.getOutputStream(), l3);

			} else {
				long l = backTenderService.getDataCountDatePercentage(position,shift,
						startDate, endDate );

				List<BackTender> lst = backTenderService.getOperatorDataList(
						position,shift, startDate, endDate);

				response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
				response.setHeader("Content-Disposition",
						"attachment; filename= NightBack Tender.xlsx");
				File file = new File(context.getRealPath("/")
						+ "WEB-INF/NightBack Tender.xlsx");

				obccReportHandler.getExcelReportForNightBacktender(lst, file,
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
				List<OperatorData> lst = operatorService.getOperatorDataList(
						position, sdate, edate);
				long l = operatorService.getDataCountDatePercentage(position,
						sdate, edate);

				if (lst.size() != 0) {
					response.setContentType("application/pdf");
					response.setHeader("Content-Disposition",
							"attachment; filename=R2 Operator.pdf");
					obccPdfReportHandler.createR2Pdf(lst,
							response.getOutputStream(), l);
				} else {
					redirectAttributes.addFlashAttribute("message",
							"Data Not Found For Selected Createrria.");
					return "redirect:/OBCCReport/view";
				}

			} else if (position.equals("R1")) {
				List<R1Operator> lst = r1OperatorService.getOperatorDataList(
						position, sdate, edate);
				long l = r1OperatorService.getDataCountDatePercentage1(position,
						sdate, edate);

				if (lst.size() != 0) {
					response.setContentType("application/pdf");
					response.setHeader("Content-Disposition",
							"attachment; filename=R1 Operator.pdf");
					obccPdfReportHandler.createR1OperatorPdf(lst,
							response.getOutputStream(), l);
				} else {
					redirectAttributes.addFlashAttribute("message",
							"Data Not Found For Selected Createrria.");
					return "redirect:/OBCCReport/view";
				}

			} else if (position.equals("utilityoperator")) {

				List<UtilityOperator> lst = utilityOperatorService
						.getOperatorDataList(position, sdate, edate);

				long l = utilityOperatorService.getDataCountDatePercentage1(
						position, sdate, edate);
				if (lst.size() != 0) {
					response.setContentType("application/pdf");
					response.setHeader("Content-Disposition",
							"attachment; filename=Utility Operator.pdf");
					obccPdfReportHandler.createUtilityOperatorPdf(lst,
							response.getOutputStream(), l);
				} else {
					redirectAttributes.addFlashAttribute("message",
							"Data Not Found For Selected Createrria.");
					return "redirect:/OBCCReport/view";
				}
			}
		} else {

			if (position.equals("backtender")) {
				List<BackTender> daylst = null;
				List<BackTender> nightlst = null;
				if (shift.equalsIgnoreCase("day")) {
					daylst = backTenderService.getOperatorDataList(position,"day",sdate, edate);
				} else if (shift.equalsIgnoreCase("night")) {
					nightlst = backTenderService.getOperatorDataList(position,"night",sdate, edate );
				} else {
					daylst = backTenderService.getOperatorDataList(position,"day",sdate, edate);
					nightlst = backTenderService.getOperatorDataList(position,"night",sdate, edate);
				}

				long l = backTenderService.getDataCountDatePercentage(position, shift,sdate, edate);

				if (daylst != null && daylst.size() != 0 || nightlst != null
						&& nightlst.size() != 0) {
					response.setContentType("application/pdf");
					response.setHeader("Content-Disposition",
							"attachment; filename=Back Tender.pdf");
					obccPdfReportHandler.createBackTernerOperatorPdf(daylst,
							nightlst, response.getOutputStream(), l);

					return null;
				} else {
					redirectAttributes.addFlashAttribute("message",
							"Data Not Found For Selected Createrria.");
					return "redirect:/OBCCReport/view";

					// response.sendRedirect(request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/OBCCReport/views?message=Data is not Preset Given for Date.");
				}
			} else if (position.equals("machinetender")) {

				List<MachineTender> daylst = null;
				List<MachineTender> nightlst = null;
				if (shift.equalsIgnoreCase("day")) {
					daylst = machineTenderService.getOperatorDataList(position,"day",sdate, edate);
				} else if (shift.equalsIgnoreCase("night")) {
					nightlst = machineTenderService.getOperatorDataList(position,"night", sdate, edate );
				} else {
					daylst = machineTenderService.getOperatorDataList(position,"day",sdate, edate);
					nightlst = machineTenderService.getOperatorDataList(position,"night", sdate, edate );
				}

				long l = machineTenderService.getDataCountDatePercentage(position, shift,sdate, edate);

				if (daylst != null && daylst.size() != 0 || nightlst != null
						&& nightlst.size() != 0) {
					response.setContentType("application/pdf");
					response.setHeader("Content-Disposition",
							"attachment; filename=Machine Tender.pdf");
					obccPdfReportHandler.createMachineTernerOperatorPdf(daylst,
							nightlst, response.getOutputStream(), l);

					return null;
				} else {
					redirectAttributes.addFlashAttribute("message",
							"Data Not Found For Selected Createrria.");
					return "redirect:/OBCCReport/view";

				}

			} else if (position.equals("stockoperator")) {

				List<StockOperator> daylst = null;
				List<StockOperator> nightlst = null;
				if (shift.equalsIgnoreCase("day")) {
					daylst = stockOperatorService.getOperatorDataList(position,"day",sdate, edate);
				} else if (shift.equalsIgnoreCase("night")) {
					nightlst = stockOperatorService.getOperatorDataList(position,"night", sdate, edate);
				} else {
					daylst = stockOperatorService.getOperatorDataList(position,"day",sdate, edate);
					nightlst = stockOperatorService.getOperatorDataList(position,"night", sdate, edate);
				}

				long l = stockOperatorService.getDataCountDatePercentage(position, shift,sdate, edate);

				if (daylst != null && daylst.size() != 0 || nightlst != null
						&& nightlst.size() != 0) {
					response.setContentType("application/pdf");
					response.setHeader("Content-Disposition",
							"attachment; filename=Stock Operator.pdf");
					obccPdfReportHandler.createStokeOperatorPdf(daylst,
							nightlst, response.getOutputStream(), l);

					return null;
				} else {
					redirectAttributes.addFlashAttribute("message",
							"Data Not Found For Selected Createrria.");
					return "redirect:/OBCCReport/view";

				}

			}

		}
		return null;

	}

	// Code Starts From Here By Roshan Tailor
	@RequestMapping(value = "/view/report/data/detailedreport/email", method = RequestMethod.POST)
	public @ResponseBody boolean breakFreeProductiondataemail(
			@RequestParam("sdate") String sdate,
			@RequestParam("edate") String edate,
			@RequestParam("position") String position,
			HttpServletResponse response, Model model,
			HttpServletRequest request) throws IOException, ProductionException {
		try {

			if (position.equals("R1")) {
				List<R1Operator> lst = r1OperatorService.getOperatorDataList(
						position, sdate, edate);
				if (lst.size() != 0) {
					obccreportingmailer.getOBCCR1ReportingMail(position, sdate,
							edate);
				}
			} else if (position.equals("R2")) {

				List<OperatorData> lst1 = operatorService.getOperatorDataList(
						position, sdate, edate);
				if (lst1.size() != 0) {
					obccreportingmailer.getOBCCR2ReportingMail(position, sdate,
							edate);
				}
			} else if (position.equals("utilityoperator")) {

				List<UtilityOperator> lst3 = utilityOperatorService
						.getOperatorDataList(position, sdate, edate);
				if (lst3.size() != 0) {
					obccreportingmailer.getOBCCUtilityReportingMail(position,
							sdate, edate);
				}
			} else if (position.equals("backtender")) {

				obccreportingmailer.getOBCCBackTenderReportingMail(position,
						sdate, edate);

			} else if (position.equals("machinetender")) {

				obccreportingmailer.getOBCCMachineTenderReportingMail(position,
						sdate, edate);
			} else if (position.equals("stockoperator")) {

				obccreportingmailer.getOBCCStockOperatorReportingMail(position,
						sdate, edate);
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
				count = r1OperatorService.getDataCountDatePercentage1(position,
						sdate, edate);
				model.addAttribute("percenteage", count);

			} else if (position.equals("R2")) {
				count = operatorService.getDataCountDatePercentage(position,
						sdate, edate);
				model.addAttribute("percenteage", count);

			} else if (position.equals("utilityoperator")) {
				// utilityOperatorService
				count = utilityOperatorService.getDataCountDatePercentage1(
						position, sdate, edate);
				model.addAttribute("percenteage", count);

			} else if (position.equals("backtender")) {
				count = backTenderService.getDataCountDatePercentage(position, shift,sdate, edate);
				model.addAttribute("percenteage", count);

			} else if (position.equals("stockoperator")) {
				count = stockOperatorService.getDataCountDatePercentage(position, shift,sdate, edate);
				model.addAttribute("percenteage", count);

			} else if (position.equals("machinetender")) {
				count = machineTenderService.getDataCountDatePercentage(position, shift,sdate, edate);
				model.addAttribute("percenteage", count);

			}
			return count;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}

	}

	@RequestMapping(value = "/viewDownload", method = RequestMethod.GET)
	public String obccreportDownloadedView(Model model) {

		model.addAttribute("startDate",
				format.format(CommonUtil.getFirstDate(new Date())));
		model.addAttribute("endDate", format.format(new Date()));
		return "OBCCDownloadReport";
	}

	@RequestMapping(value = "/view/report/data/detailedreport/exportPercentage", method = RequestMethod.POST)
	public void exportPecenatgeData(@RequestParam("startDate") String startDate,@RequestParam("endDate") String endDate,HttpServletResponse response, HttpServletRequest request)
			throws Exception {

		
		  
			int startMonth = getMonth(startDate); 
			int endMonth =   getMonth(endDate);
		   
			int startYear = getYear(startDate); 
			int endYear =   getYear(endDate);
		   	System.out.println("startDate" + startMonth);
			System.out.println("endDate" + endMonth);   
		   
			
			SimpleDateFormat f = new SimpleDateFormat("mm-DD-yyyy");
			int n = 0;
		    Date d1;
			try {
				 d1 = format.parse(startDate);
				 Date d2 = format.parse(endDate);
				 n = differenceInMonths(d1, d2);
				System.out.println("diff days"+n);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			 
			if(startYear!=endYear)
			{
				endMonth = n;   
			}
			else
			{
				
			}
			 
			
		   Map<Date, Double> map = new HashMap<Date, Double>();
		   Map<Date, Double> r1map = new HashMap<Date, Double>();
		   Map<Date, Double> utilitymap = new HashMap<Date, Double>();
		   Map<Date, Double> backtendermap = new HashMap<Date, Double>();
		   Map<Date, Double> stockmap = new HashMap<Date, Double>();
		   Map<Date, Double> machinemap = new HashMap<Date, Double>();
		   Map<Date, Double> avgMap = new HashMap<Date, Double>();
		   double R1Percenatge = 0.0;
		   double R2Percenatge = 0.0;
		   double utilityoperator = 0.0;
		   double stockOperatorday = 0.0;
		   double stockOperatornight = 0.0;
		   double machinetenderday = 0.0;
		   double machinetendernight = 0.0;
		   double backtenderday = 0.0;
		   double backtendernight = 0.0;
		   double avg=0.0;
		   for (int i = 0; i <= n; i++) {
			   String getlastDayofMonth = null;
			   
			   if(checksameMonth(startDate,endDate) == true)
			   {
				   getlastDayofMonth = endDate;
			   }
			   else
			   {
				   getlastDayofMonth = getLastDateOfMonth(startDate);
			   }
			   
			   R1Percenatge = r1OperatorService.getDataCountDatePercentage1("R1",startDate, endDate);
			   R2Percenatge = operatorService.getDataCountDatePercentage("R2",startDate, endDate);
			   utilityoperator = utilityOperatorService.getDataCountDatePercentage1("utilityoperator",startDate, endDate);
			   stockOperatorday = stockOperatorService.getDataCountDatePercentage("stockoperator","day",startDate, endDate);
			   stockOperatornight = stockOperatorService.getDataCountDatePercentage("stockoperator","night",startDate, endDate);
			   double stockOperator=(stockOperatorday+stockOperatornight)/2;
			   machinetenderday = machineTenderService.getDataCountDatePercentage("machinetender","day",startDate, endDate);
			   machinetendernight = machineTenderService.getDataCountDatePercentage("machinetender","night",startDate, endDate);
			   double machinetender=( machinetenderday+ machinetendernight)/2;
			   backtenderday = backTenderService.getDataCountDatePercentage("backtender","day",startDate, endDate);		  
			   backtendernight = backTenderService.getDataCountDatePercentage("backtender","night",startDate, endDate);
			   double backtender=( backtenderday+ backtendernight)/2;  
			   avg=(R1Percenatge+R2Percenatge+utilityoperator+stockOperator+machinetender+backtender)/6;
			   avg= Double.parseDouble( CommonUtil.parseTwoDecimal(avg));
			   startDate = addOneMonth(startDate);
			   map.put(format.parse(getlastDayofMonth), R2Percenatge);
			   r1map.put(format.parse(getlastDayofMonth), R1Percenatge);
			   utilitymap.put(format.parse(getlastDayofMonth), utilityoperator);
			   stockmap.put(format.parse(getlastDayofMonth), stockOperator);
			   backtendermap.put(format.parse(getlastDayofMonth),backtender );
			   machinemap.put(format.parse(getlastDayofMonth), machinetender);
			   avgMap.put(format.parse(getlastDayofMonth),avg);
			   startMonth = startMonth+1;
			   
		   }
		   Map<Date, Double> treeMap4 = new TreeMap<Date, Double>(map);
		   Map<Date, Double> treeMap2 = new TreeMap<Date, Double>(r1map);
		   Map<Date, Double> treeMap3 = new TreeMap<Date, Double>(utilitymap);
		   Map<Date, Double> treeMap1 = new TreeMap<Date, Double>(backtendermap);
		   Map<Date, Double> treeMap5 = new TreeMap<Date, Double>(stockmap);
		   Map<Date, Double> treeMap6 = new TreeMap<Date, Double>(machinemap);
		   Map<Date, Double> treeMap7 = new TreeMap<Date, Double>(avgMap);

		response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
		response.setHeader("Content-Disposition",
				"attachment; filename=OBCCDownload.xlsx");
		File file = new File(context.getRealPath("/")+ "WEB-INF/OBCCDownload.xlsx");

		obccReportHandler.getExcelReportbyPercentage(treeMap4,treeMap1,treeMap6,treeMap5,treeMap3,treeMap2,treeMap7,file,response.getOutputStream());

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
	
	
	
	public static void main(String[] args) {
		
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
	    Date d1;
		try {
			 d1 = f.parse("2012-01-01");
			 Date d2 = f.parse("2013-02-02");
			int n = differenceInMonths(d1, d2);
			System.out.println(n);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   
		
	}
	
	
	@RequestMapping(value="/view/report/data/detailedreport/exportPercentage/email",method=RequestMethod.POST)
	public @ResponseBody boolean sendOBCCEmailPercentageMonthWise(HttpServletRequest request,HttpServletResponse response) throws IOException{
		
		String startDate=CommonUtil.checkNull(request.getParameter("sdate"));
		String endDate=CommonUtil.checkNull(request.getParameter("edate"));
		
		try {
			obccreportingmailer.sendOBCCEmailPercentageMonthWise(startDate,endDate);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	 

}

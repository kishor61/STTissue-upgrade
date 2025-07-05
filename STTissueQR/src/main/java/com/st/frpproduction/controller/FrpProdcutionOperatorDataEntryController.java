/**
 *Mar 3, 2016
 *FrpProdcutionOperatorDataEntryController.java
 * TODO
 *com.st.frpproduction.controller
 *FrpProdcutionOperatorDataEntryController.java
 *Roshan Lal Tailor
 */
package com.st.frpproduction.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.google.gson.Gson;
import com.st.common.CommonUtil;
import com.st.common.exception.ProductionException;
import com.st.customercomplaint.service.CoustomerComplaintService;
import com.st.efficiency.model.EfficiencyShiftData;
import com.st.frpproduction.model.FrpProdcutionOperatorDataEntry;
import com.st.frpproduction.service.FrpProdcutionOperatorDataEntryService;
import com.st.frpproduction.report.FrpProdcutionOperatorDataEntryReportAutoMailer;
import com.st.frpproduction.report.FrpProdcutionOperatorDataEntryReportHandler;

/**
 * @author roshan frppressquality
 *
 */
@Controller
@RequestMapping(value = "/frpproductionopdataentry")
public class FrpProdcutionOperatorDataEntryController {

	private SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");

	@Autowired
	private FrpProdcutionOperatorDataEntryReportHandler FrpProdcutionOperatorDataEntryReportHandler;

	@Autowired
	private com.st.frpproduction.report.FrpProdcutionOperatorDataEntryDetailedReportHandler FrpProdcutionOperatorDataEntryDetailedReportHandler;

	@Autowired
	private ServletContext context;

	@Autowired
	private FrpProdcutionOperatorDataEntryService frpprodcutionoperatordataentryservice;

	@Autowired
	private CoustomerComplaintService coustomercomplaintservice;

	@Autowired
	private FrpProdcutionOperatorDataEntryReportAutoMailer frpprodcutionoperatordataentryreportautomailer;

	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public String entryPage(Model model) {
		model.addAttribute("sdate", dateFormat.format(new Date()));
		model.addAttribute("edate", dateFormat.format(new Date()));
		model.addAttribute("dataentry", true);
		model.addAttribute("shift", "None");
		model.addAttribute("crew", "None");
		return "frpproductionopdataentrypage";
	}

	@RequestMapping(value = "/new/{shift}/{date}/{crew}", method = RequestMethod.GET)
	public String loaddataforshiftanddate(@PathVariable("shift") String shift, @PathVariable("date") String sdate,
			@PathVariable("crew") String crew, Model model) {

		Date sDate = CommonUtil.checkDate(sdate, dateFormat);

		List<FrpProdcutionOperatorDataEntry> details1 = frpprodcutionoperatordataentryservice
				.getFrpProducationBackDatedEntryShow1(sDate, shift);
		if (details1.size() > 0) {

			List<FrpProdcutionOperatorDataEntry> details = frpprodcutionoperatordataentryservice
					.getFrpProducationBackDatedEntryShow(sDate, shift, crew);
			model.addAttribute("details", details);
			if (details.size() > 0) {
				model.addAttribute("shift", shift);
				model.addAttribute("crew", crew);
				model.addAttribute("sdate", dateFormat.format(sDate));
				model.addAttribute("backdatedentryshow", true);
				// return "frpproductionopdataentrypage";
			}

		} else {
			model.addAttribute("shift", shift);
			// model.addAttribute("crew", crew);
			model.addAttribute("sdate", dateFormat.format(sDate));
			model.addAttribute("details", details1);
			model.addAttribute("backdatedentryshow", true);
			// return "frpproductionopdataentrypage";
		}
		model.addAttribute("sdate", dateFormat.format(sDate));

		return "frpproductionopdataentrypage";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(HttpServletRequest request, HttpServletResponse response, Model model,
			RedirectAttributes redirectAttributes) throws IOException {
		Map<String, Object> map = new HashMap<String, Object>();
		FrpProdcutionOperatorDataEntry colum = new FrpProdcutionOperatorDataEntry();

		int id = CommonUtil.checkInt(request.getParameter("id"));
		Date date = CommonUtil.checkDate(request.getParameter("sdate"), dateFormat);
		String shift = CommonUtil.checkNull(request.getParameter("shift"));
		String crew = CommonUtil.checkNull(request.getParameter("crew"));
		String productiontype = CommonUtil.checkNull(request.getParameter("productiontype"));
		double col1 = CommonUtil.checkDouble(request.getParameter("col1"));
		double col2 = CommonUtil.checkDouble(request.getParameter("col2"));
		double col3 = CommonUtil.checkDouble(request.getParameter("col3"));
		double col4 = CommonUtil.checkDouble(request.getParameter("col4"));
		double col5 = CommonUtil.checkDouble(request.getParameter("col5"));
		double col6 = CommonUtil.checkDouble(request.getParameter("col6"));
		double col7 = CommonUtil.checkDouble(request.getParameter("col7"));
		double col8 = CommonUtil.checkDouble(request.getParameter("col8"));
		double col9 = CommonUtil.checkDouble(request.getParameter("col9"));
		double col10 = CommonUtil.checkDouble(request.getParameter("col10"));
		double col11 = CommonUtil.checkDouble(request.getParameter("col11"));
		double col12 = CommonUtil.checkDouble(request.getParameter("col12"));
		double col10a = CommonUtil.checkDouble(request.getParameter("col10a"));

		// Code For Line B
		double col11b = CommonUtil.checkDouble(request.getParameter("col11b"));
		double col6b = CommonUtil.checkDouble(request.getParameter("col6b"));
		double col7b = CommonUtil.checkDouble(request.getParameter("col7b"));
		double col8b = CommonUtil.checkDouble(request.getParameter("col8b"));
		double col9b = CommonUtil.checkDouble(request.getParameter("col9b"));
		double col10b = CommonUtil.checkDouble(request.getParameter("col10b"));
		double col12b = CommonUtil.checkDouble(request.getParameter("col12b"));

		List<FrpProdcutionOperatorDataEntry> existentry = frpprodcutionoperatordataentryservice.checkexistentry(date,
				shift, crew);
		/*
		 * if(existentry.size()>0){ Date dateS=null; String shiftS="";
		 * for(FrpProdcutionOperatorDataEntry data:existentry){ dateS=data.getDate();
		 * shiftS=data.getShift(); } model.addAttribute("date",
		 * dateFormat.format(dateS)); model.addAttribute("shift", ""+shiftS);
		 * 
		 * model.addAttribute("message",
		 * "You Have Already Done The Entry For This Date And Shift.");
		 * model.addAttribute("reportDataEdit", existentry);
		 * model.addAttribute("showeditbutton", true);
		 * model.addAttribute("showsubmitbutton", false); return
		 * "frpproductionopdataentryeditpage"; }else{
		 */
		try {

			colum.setId(id);
			colum.setDate(date);
			colum.setShift(shift);
			colum.setCrew(crew);
			colum.setCol1(col1);
			colum.setCol2(col2);
			colum.setCol3(col3);
			colum.setCol4(col4);
			colum.setCol5(col5);
			colum.setCol6(col6);
			colum.setCol7(col7);
			colum.setCol8(col8);
			colum.setCol9(col9);
			colum.setCol10(col10);
			colum.setCol11(col11);
			colum.setCol12(col12);
			colum.setCol10a(col10a);

			colum.setCol11b(col11b);
			colum.setCol6b(col6b);
			colum.setCol7b(col7b);
			colum.setCol8b(col8b);
			colum.setCol9b(col9b);
			colum.setCol10b(col10b);
			colum.setCol12b(col12b);

			colum.setProductiontype(productiontype);

			try {

				if (colum.getId() == 0) {
					int key = frpprodcutionoperatordataentryservice.save(colum);
					map.put("status", true);
					map.put("id", key);
				} else {
					frpprodcutionoperatordataentryservice.update(colum);
					map.put("status", true);
					map.put("id", colum.getId());
				}

			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception("Error in saving data", e);
			}
		} catch (Exception e) {
			System.out.println("Roshan Says, You Have An Error In FrpProdcutionOperatorDataEntryController.java");
			map.put("status", false);
			map.put("error", e.getMessage());
			e.printStackTrace();
		}
		if (colum.getId() == 0) {
			redirectAttributes.addFlashAttribute("message", "Data Saved Successfully.");
		} else {
			redirectAttributes.addFlashAttribute("message", "Data Updated Successfully.");
		}

		return "redirect:/frpproductionopdataentry/new";
		// }
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public String editPage(HttpServletRequest request, HttpServletResponse response, Model model) {
		int id = CommonUtil.checkInt(request.getParameter("id"));

		List<FrpProdcutionOperatorDataEntry> existentry = frpprodcutionoperatordataentryservice.checkexistentry(id);
		Date date = null;
		String shift = "";
		for (FrpProdcutionOperatorDataEntry data : existentry) {
			date = data.getDate();
			shift = data.getShift();
		}
		model.addAttribute("date", dateFormat.format(date));
		model.addAttribute("shift", "" + shift);
		model.addAttribute("reportDataEdit", existentry);
		model.addAttribute("editdataentry", true);

		model.addAttribute("showeditbutton", false);
		model.addAttribute("showsubmitbutton", true);
		return "frpproductionopdataentryeditpage";
	}

	@RequestMapping(value = "/view/report", method = RequestMethod.GET)
	public String reportPage(Model model) {
		model.addAttribute("sdate", dateFormat.format(CommonUtil.getFirstDate(new Date())));
		model.addAttribute("edate", dateFormat.format(new Date()));
		model.addAttribute("showreport", false);
		return "frpproductionopdatareportpage";
	}

	@RequestMapping(value = "/view/report/data", method = RequestMethod.GET)
	public String reportDataPage(@RequestParam("sdate") String sdate, @RequestParam("edate") String edate,
			Model model) {

		model.addAttribute("sdate", sdate);
		model.addAttribute("edate", edate);

		Date sDate = CommonUtil.checkDate(sdate, dateFormat);
		Date eDate = CommonUtil.checkDate(edate, dateFormat);
		List<FrpProdcutionOperatorDataEntry> details = frpprodcutionoperatordataentryservice
				.getFrpProducationDataEntryReport(sDate, eDate);

		model.addAttribute("details", details);
		model.addAttribute("showreport", true);
		return "frpproductionopdatareportpage";
	}

	@RequestMapping(value = "/view/report/data/sendmail", method = RequestMethod.POST)
	public @ResponseBody boolean emailSummaryData(HttpServletRequest request, HttpServletResponse response, Model model)
			throws IOException, ProductionException {

		Date sDate = CommonUtil.checkDate(request.getParameter("sdate"), dateFormat);
		Date eDate = CommonUtil.checkDate(request.getParameter("edate"), dateFormat);

		try {
			frpprodcutionoperatordataentryreportautomailer.sendMailAt8am(sDate, eDate);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return true;

	}

	@RequestMapping(value = "/view/report/data/detailedreport", method = RequestMethod.GET)
	public String reportDataPageDetailedReport(@RequestParam("sdate") String sdate, @RequestParam("edate") String edate,
			Model model) {

		model.addAttribute("sdate", sdate);
		model.addAttribute("edate", edate);

		Date sDate = CommonUtil.checkDate(sdate, dateFormat);
		Date eDate = CommonUtil.checkDate(edate, dateFormat);

		List<FrpProdcutionOperatorDataEntry> details = frpprodcutionoperatordataentryservice
				.getFrpProducationDataEntryDetailedReport(sDate, eDate);

		List<FrpProdcutionOperatorDataEntry> Aavg = frpprodcutionoperatordataentryservice.getcol1avg(sDate, eDate);
		List<FrpProdcutionOperatorDataEntry> Bavg = frpprodcutionoperatordataentryservice.getcol1avg1(sDate, eDate);
		List<FrpProdcutionOperatorDataEntry> Cavg = frpprodcutionoperatordataentryservice.getcol1avg2(sDate, eDate);
		List<FrpProdcutionOperatorDataEntry> Davg = frpprodcutionoperatordataentryservice.getcol1avg3(sDate, eDate);

		model.addAttribute("Aavg", Aavg);
		model.addAttribute("Bavg", Bavg);
		model.addAttribute("Cavg", Cavg);
		model.addAttribute("Davg", Davg);

		model.addAttribute("details", details);
		model.addAttribute("showreport", true);

		// model.addAttribute("aData", new
		// FrpProdcutionOperatorDataEntry().totalA(details));

		return "frpproductionopdatareportpagedetailedreport";
	}

	@RequestMapping(value = "/view/report/data/detailedreport/edit/{id}", method = RequestMethod.GET)
	public String reportDataPageDetailedReportedit(@PathVariable("id") int id, Model model) {

		List<FrpProdcutionOperatorDataEntry> data = frpprodcutionoperatordataentryservice.checkexistentry(id);

		model.addAttribute("details", data);
		model.addAttribute("showreport", true);
		return "frpproductionopdatareportpagedetailedreportedit";
	}

	@RequestMapping(value = "/view/report/data/detailedreport/email", method = RequestMethod.POST)
	public @ResponseBody boolean efficiencyReportByShiftEmail(HttpServletRequest request, HttpServletResponse response,
			Model model) throws IOException {

		Date sDate = CommonUtil.checkDate(request.getParameter("sdate"), dateFormat);
		Date eDate = CommonUtil.checkDate(request.getParameter("edate"), dateFormat);

		try {
			FrpProdcutionOperatorDataEntryDetailedReportHandler.sendDetailedReportMailAt8am(sDate, eDate);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;

	}

	@RequestMapping(value = "/view/report/data/detailedreport/export", method = RequestMethod.POST)
	public void export(@RequestParam("sdate") String sdate, @RequestParam("edate") String edate,
			HttpServletResponse response) throws Exception {

		SimpleDateFormat df = new SimpleDateFormat("MM-dd-yyyy");
		Date sDate = CommonUtil.checkDate(sdate, df);
		Date eDate = CommonUtil.checkDate(edate, df);

		List<FrpProdcutionOperatorDataEntry> details = frpprodcutionoperatordataentryservice
				.getFrpProducationDataEntryDetailedReport(sDate, eDate);

		List<FrpProdcutionOperatorDataEntry> Aavg = frpprodcutionoperatordataentryservice.getcol1avg(sDate, eDate);
		List<FrpProdcutionOperatorDataEntry> Bavg = frpprodcutionoperatordataentryservice.getcol1avg1(sDate, eDate);
		List<FrpProdcutionOperatorDataEntry> Cavg = frpprodcutionoperatordataentryservice.getcol1avg2(sDate, eDate);
		List<FrpProdcutionOperatorDataEntry> Davg = frpprodcutionoperatordataentryservice.getcol1avg3(sDate, eDate);

		response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
		response.setHeader("Content-Disposition", "attachment; filename=Frp_Prodcution_Operator_DataEntry_Report.xlsx");
		File file = new File(context.getRealPath("/") + "WEB-INF/Frp_Prodcution_Operator_DataEntry_Report.xlsx");

		FrpProdcutionOperatorDataEntryReportHandler.getExcelReport(details, Aavg, Bavg, Cavg, Davg, file,
				response.getOutputStream());

	}

	@RequestMapping(value = "/back", method = RequestMethod.GET)
	public String backdatedentryPage(Model model) {
		model.addAttribute("sdate", dateFormat.format(new Date()));
		model.addAttribute("edate", dateFormat.format(new Date()));
		model.addAttribute("shift", "None");
		model.addAttribute("dataentry", true);
		return "frpproductionopbackdataentrypage";
	}

	@RequestMapping(value = "/backdatedentry/show", method = RequestMethod.POST)
	public String backdatedentryshow(@RequestParam("sdate") String sdate, @RequestParam("shift") String shift,
			Model model) {

		model.addAttribute("sdate", sdate);

		Date sDate = CommonUtil.checkDate(sdate, dateFormat);
		// List<FrpProdcutionOperatorDataEntry>
		// details=frpprodcutionoperatordataentryservice.getFrpProducationBackDatedEntryShow(sDate,shift);

		// model.addAttribute("details", details);
		model.addAttribute("shift", shift);
		model.addAttribute("sdate", dateFormat.format(sDate));
		model.addAttribute("backdatedentryshow", true);
		return "frpproductionopbackdataentrypage";
	}

	@RequestMapping(value = "/view/report/data/detailedreport/delete", method = RequestMethod.POST)
	public void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {

		int id = CommonUtil.checkInt(request.getParameter("id"));
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			frpprodcutionoperatordataentryservice.deleteRecord(id);
			map.put("status", true);
		} catch (Exception e) {
			System.out.println(
					"Roshan Says That You Have A Problem In WinderBreakMonitoringController.java At Delete Method");
			e.printStackTrace();
		}
		response.setContentType("application/json");
		response.getWriter().write(new Gson().toJson(map));
	}
}

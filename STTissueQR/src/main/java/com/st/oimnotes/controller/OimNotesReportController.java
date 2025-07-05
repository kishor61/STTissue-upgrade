/**
 * 
 */
package com.st.oimnotes.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.st.common.CommonUtil;
import com.st.common.OimCommon;
import com.st.oimnotes.automailer.OimnotesAutoMailer;
import com.st.oimnotes.model.Category;
import com.st.oimnotes.model.Summary;
import com.st.oimnotes.report.OimNotesReportHandler;
import com.st.oimnotes.service.OimNotesService;

/**
 * @author sbora
 *
 */
@Controller
@RequestMapping(value="/oimnotesreport")
public class OimNotesReportController {
	
	@Autowired
	private ServletContext context;
	
	@Autowired
	private OimNotesService oimNotesService;
	
	private SimpleDateFormat dateFormat=new SimpleDateFormat("MM-dd-yyyy");
	
	@Autowired
	private OimNotesReportHandler oimNotesReport;
	
	
	@Autowired
	private OimnotesAutoMailer oimnotesAutoMailer;
	
	
	@RequestMapping(value="/main",method=RequestMethod.GET)
	public String main(Model model) {
		
		Date sdate=CommonUtil.checkDate(dateFormat.format(CommonUtil.getFirstDate()), dateFormat);
		Date edate=CommonUtil.checkDate(dateFormat.format(new Date()), dateFormat);
		
		model.addAttribute("date", dateFormat.format(sdate));
		model.addAttribute("edate", dateFormat.format(edate));
		
		List<Category> categories=oimNotesService.getCategory();
		model.addAttribute("categories", categories);
		
		model.addAttribute("flagShow", false);
		
		return "oimnotes/oimNotesReports";
	}
	
	@RequestMapping(value="/load/dates/{sdate}/{edate}",method=RequestMethod.GET)
	public String load(@PathVariable("sdate")String sdate,
			@PathVariable("edate")String edate,
			Model model) {
		
		Date sDate=CommonUtil.checkDate(sdate, dateFormat);
		Date eDate=CommonUtil.checkDate(edate, dateFormat);
		
		List<Summary> summaries=oimNotesService.getSummariesDates(sDate, eDate);
		
		model.addAttribute("date", sdate);
		model.addAttribute("edate", edate);
		
		List<Category> categories=oimNotesService.getCategory();
		model.addAttribute("categories", categories);
		model.addAttribute("summaries", summaries);
		
		model.addAttribute("flagShow", true);
		
		return "oimnotes/oimNotesReports";
	}
	
	@RequestMapping(value="/load/dates/{categoryId}/{sdate}/{edate}",method=RequestMethod.GET)
	public String load(@PathVariable("categoryId")int categoryId,
			@PathVariable("sdate")String sdate,
			@PathVariable("edate")String edate,
			Model model) {
		
		Date sDate=CommonUtil.checkDate(sdate, dateFormat);
		Date eDate=CommonUtil.checkDate(edate, dateFormat);
		
		model.addAttribute("date", sdate);
		model.addAttribute("edate", edate);
		model.addAttribute("categoryId", categoryId);
		
		List<Summary> summaries=oimNotesService.getSummariesDates(categoryId,sDate, eDate);
		model.addAttribute("summaries", summaries);
		
		List<Category> categories=oimNotesService.getCategory();
		model.addAttribute("categories", categories);
		model.addAttribute("flagShow", true);
		
		return "oimnotes/oimNotesReports";
	}
	
		
	
	@RequestMapping(value="/view/{categoryId}/{sdate}/{edate}",method=RequestMethod.GET)
	public String view(@PathVariable("categoryId")int categoryId,
			@PathVariable("sdate")String sdate,
			@PathVariable("edate")String edate,Model model) throws IOException {
		
		model.addAttribute("recurrences", OimCommon.getRecurrenceList());
		Date sDate=CommonUtil.checkDate(sdate, dateFormat);
		Date eDate=CommonUtil.checkDate(edate, dateFormat);
		
		List<Summary> summaries=oimNotesService.getSummariesFolloUps(categoryId, sDate, eDate);
		List<Category> categories=new ArrayList<>();
		for (Category cat : oimNotesService.getCategory()) {
			for (Summary summary : summaries) {
				if(summary.getCategoryId()==cat.getId()){
					if(!categories.contains(cat)){
						categories.add(cat);
					}
				}
			}
		}
		model.addAttribute("categories", categories);
		
		model.addAttribute("categoryId", categoryId);
		model.addAttribute("sdate", sdate);
		model.addAttribute("edate", edate);
		
		
		model.addAttribute("summaries", summaries);
		return "oimnotes/oimNotesReportView";
	}
	@RequestMapping(value="/view/{sdate}/{edate}",method=RequestMethod.GET)
	public String view(@PathVariable("sdate")String sdate,
			@PathVariable("edate")String edate,Model model) throws IOException {
		
		model.addAttribute("recurrences", OimCommon.getRecurrenceList());
		Date sDate=CommonUtil.checkDate(sdate, dateFormat);
		Date eDate=CommonUtil.checkDate(edate, dateFormat);
		
		List<Summary> summaries=oimNotesService.getSummariesFolloUps(sDate, eDate);
		List<Category> categories=new ArrayList<>();
		for (Category cat : oimNotesService.getCategory()) {
			for (Summary summary : summaries) {
				if(summary.getCategoryId()==cat.getId()){
					if(!categories.contains(cat)){
						categories.add(cat);
					}
				}
			}
		}
		model.addAttribute("categories", categories);
		
		
		model.addAttribute("sdate", sdate);
		model.addAttribute("edate", edate);
		
		
		model.addAttribute("summaries", summaries);
		return "oimnotes/oimNotesReportView";
	}
	
	
	@RequestMapping(value="/export/excel",method=RequestMethod.GET)
	public void exportExcel(HttpServletRequest request,HttpServletResponse response) throws IOException {
		Date sdate=CommonUtil.checkDate(request.getParameter("sdate"), dateFormat);
		Date edate=CommonUtil.checkDate(request.getParameter("edate"), dateFormat);
		String category=request.getParameter("categoryId");
		
		List<Summary> summaries=null;
		
		if(StringUtils.isEmpty(category)){
			summaries=oimNotesService.getSummariesFolloUps(sdate, edate);
		}else{
			//summaries=oimNotesService.getSummariesFolloUps(category, sdate, edate);
		}
		List<Category> categories=new ArrayList<>();
		for (Category cat : oimNotesService.getCategory()) {
			for (Summary summary : summaries) {
				if(summary.getCategoryId()==cat.getId()){
					if(!categories.contains(cat)){
						categories.add(cat);
					}
				}
			}
		}

		response.setContentType("application/vnd.ms-excel");
		response.setHeader("Content-Disposition", "attachment; filename=PROCESS_IMPROVEMENT_MEETING_NOTES.xls");
		
	//	File file=new File(context.getRealPath("/")+"WEB-INF/excel template/Process Improvement Notes.xls");

		

	}


	@RequestMapping(value="/export/pdf/{categoryId}/{sdate}/{edate}",method=RequestMethod.GET)
	public void exportPdf(@PathVariable("categoryId")int categoryId,
			@PathVariable("sdate")String sdate,
			@PathVariable("edate")String edate,HttpServletResponse response) throws IOException, Exception {
		
		Date sDate=CommonUtil.checkDate(sdate, dateFormat);
		Date eDate=CommonUtil.checkDate(edate, dateFormat);

		
		List<Summary> summaries=oimNotesService.getSummariesFolloUps(categoryId, sDate, eDate);
		
		
		List<Category> categories=new ArrayList<>();
		for (Category cat : oimNotesService.getCategory()) {
			for (Summary summary : summaries) {
				if(summary.getCategoryId()==cat.getId()){
					if(!categories.contains(cat)){
						categories.add(cat);
					}
				}
			}
		}

		
		 response.setContentType("application/pdf");
		 response.setHeader("Content-disposition", "inline; filename=\"PROCESS_IMPROVEMENT_MEETING_NOTES.pdf\"");
		
		
		 oimNotesReport.createOimReport(summaries,categories,response.getOutputStream());

	}
	
	@RequestMapping(value="/export/pdf/{sdate}/{edate}",method=RequestMethod.GET)
	public void exportPdf(
			@PathVariable("sdate")String sdate,
			@PathVariable("edate")String edate,HttpServletResponse response) throws IOException, Exception {
		
		Date sDate=CommonUtil.checkDate(sdate, dateFormat);
		Date eDate=CommonUtil.checkDate(edate, dateFormat);

		
		List<Summary> summaries=oimNotesService.getSummariesFolloUps(sDate, eDate);
		
		
		List<Category> categories=new ArrayList<>();
		for (Category cat : oimNotesService.getCategory()) {
			for (Summary summary : summaries) {
				if(summary.getCategoryId()==cat.getId()){
					if(!categories.contains(cat)){
						categories.add(cat);
					}
				}
			}
		}

		
		 response.setContentType("application/pdf");
		 response.setHeader("Content-disposition", "inline; filename=\"PROCESS_IMPROVEMENT_MEETING_NOTES.pdf\"");
		
		
		 oimNotesReport.createOimReport(summaries,categories,response.getOutputStream());

	}

	
	@RequestMapping(value="/load/openfollowups",method=RequestMethod.GET)
	public String loadOpenFollowUps(Model model) {
		

		List<Summary> summaries=oimNotesService.getOpenSummariesFolloUps();
		
		model.addAttribute("summaries", summaries);

		model.addAttribute("recurrences", OimCommon.getRecurrenceList());
		
		return "oimnotes/oimNotesReportOpen";
	}
	
	
	@RequestMapping(value="/email/openfollowups",method=RequestMethod.GET)
	public @ResponseBody boolean emailOpenFollowUps() {
		
		try {
			oimnotesAutoMailer.sendMailOpenReport();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
		
	}
	
	
	@RequestMapping(value="/export/openfollowups",method=RequestMethod.GET)
	public void exportOpenReportPdf(
			HttpServletResponse response) throws IOException, Exception {
		

		Map<String, String> recurrences =OimCommon.getRecurrenceList();
		List<Summary> summaries=oimNotesService.getOpenSummariesFolloUps();
		
		 response.setContentType("application/pdf");
		 response.setHeader("Content-disposition", "inline; filename=\"PROCESS_IMPROVEMENT_MEETING_NOTES.pdf\"");
		
		
		 oimNotesReport.createOpenFollowUpReport(summaries,recurrences,response.getOutputStream());

	}
}

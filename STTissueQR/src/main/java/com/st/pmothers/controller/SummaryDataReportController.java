/**
 *Dec 2, 2014
 *SummaryDataReportController.java
 * TODO
 *com.st.pmothers.controller
 *SummaryDataReportController.java
 *Sunil Singh Bora
 */
package com.st.pmothers.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jakarta.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.gson.Gson;
import com.st.common.CommonUtil;
import com.st.pmothers.automailer.SummaryDataAutoMailer;
import com.st.pmothers.model.SummaryData;
import com.st.pmothers.report.SummaryDataReportHanlder;
import com.st.pmothers.service.SummaryDataService;

/**
 * @author sbora
 *
 */
@Controller
@RequestMapping(value="/pmsummarydatareport")
public class SummaryDataReportController {
	@Autowired
	private SummaryDataService summaryDataService;
	
	@Autowired
	private SummaryDataReportHanlder summaryDataReportHanlder;
	
	@Autowired
	private SummaryDataAutoMailer summaryDataAutoMailer;
	
	private SimpleDateFormat dateFormat=new SimpleDateFormat("MM-dd-yyyy");
	
	
	@RequestMapping(value="/main")
	public String main(Model model){
		
		model.addAttribute("sdate", dateFormat.format(CommonUtil.getFirstDate()));
		model.addAttribute("edate", dateFormat.format(new Date()));
		
		model.addAttribute("showFlag", false);
		
		return "dailySummary/summaryReportMain";
	}
	
	
	@RequestMapping(value="/load/date",method=RequestMethod.GET)
	public String loadDate(@RequestParam("sdate")String sdate,
			@RequestParam("edate")String edate,
			Model model){
		
		
		List<Map<String, Object>> datas=summaryDataService.getDateList(CommonUtil.checkDate(sdate, dateFormat),CommonUtil.checkDate(edate, dateFormat));
		
		model.addAttribute("datas", datas);
		model.addAttribute("sdate", sdate);
		model.addAttribute("edate", edate);
		model.addAttribute("showFlag", true);
		
		return "dailySummary/summaryReportMain";
	}
	
	@RequestMapping(value="/loaddata",method=RequestMethod.GET)
	public String loadData(@RequestParam("id")int id,
			@RequestParam("sdate")String sdate,
			@RequestParam("edate")String edate,
			Model model){
		
		
		SummaryData summaryData=summaryDataService.getSummaryData(id);
		model.addAttribute("summaryData", summaryData);
		model.addAttribute("sdate", sdate);
		model.addAttribute("edate", edate);
		return "dailySummary/summaryReportView";
	}
	
	
	@RequestMapping(value="/export/pdf/{id}",method=RequestMethod.GET)
	public void exportPdf(@PathVariable("id")int id,
			HttpServletResponse response) throws Exception{
		
		
		SummaryData summaryData=summaryDataService.getSummaryData(id);
	
		
		 response.setContentType("application/pdf");
		 response.setHeader("Content-disposition", "inline; filename=\"Daily_Summary_Report.pdf\"");
		
		
		summaryDataReportHanlder.createPdfDailySummaryReport(summaryData,response.getOutputStream());
		
	}
	
	@RequestMapping(value="/export/pdf/blank",method=RequestMethod.GET)
	public void exportPdf(HttpServletResponse response) throws Exception{
		
		
		SummaryData summaryData=new SummaryData();
	
		
		 response.setContentType("application/pdf");
		 response.setHeader("Content-disposition", "inline; filename=\"Daily_Summary_Report.pdf\"");
		
		
		summaryDataReportHanlder.createPdfDailySummaryReport(summaryData,response.getOutputStream());
		
	}
	
	@RequestMapping(value="/mail/pdf",method=RequestMethod.POST)
	public void mailPdf(@RequestParam("id")int id,
			HttpServletResponse response) throws Exception{
	
		
		Map<String, Object> map=new HashMap<String, Object>();
		
		try {
			summaryDataAutoMailer.sendSummaryMail(id);
			map.put("flag", true);
		} catch (Exception e) {
			map.put("flag", false);
			map.put("error", "Fail to send mail. Error:-"+e.getMessage());
		}
		
		response.setContentType("application/json");
		response.getWriter().write(new Gson().toJson(map));
		
	}
	
}

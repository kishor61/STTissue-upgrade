/**
 *Nov 12, 2014
 *CertificateAnalysisController.java
 * This is sample code
 *com.st.certificate.controller
 *CertificateAnalysisController.java
 *Sunil Singh Bora
 */
package com.st.certificate.controller;

import java.io.File;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.st.certificate.model.Rewdinder;
import com.st.certificate.report.CertificateReportHandler;
import com.st.certificate.service.CertificateAnalysisService;
import com.st.common.CommonUtil;
import com.st.qualitypm6.service.CustomerService;

/**
 * @author sbora
 *
 */
@Controller
@RequestMapping(value="/certificateanalysis")
public class CertificateAnalysisController {
	@Autowired
	private CertificateAnalysisService certificateAnalysisService;
	
	@Autowired
	private CertificateReportHandler certificateReport;
	
	@Autowired
	private ServletContext context;
	@Autowired
	private CustomerService customerService;
	
	
	
	private SimpleDateFormat dateFormat=new SimpleDateFormat("MM-dd-yyyy");
	
	@RequestMapping(value="/main",method=RequestMethod.GET)
	public String main(Model model){
		
		
		model.addAttribute("sdate", dateFormat.format(new Date()));
		model.addAttribute("edate", dateFormat.format(new Date()));
		
		List<String> customers=customerService.getCustomers();
		model.addAttribute("customers", customers);
		return "certificate/certificateAnalysisMain";
		
	}
	
	@RequestMapping(value="/load",method=RequestMethod.GET)
	public String load(@RequestParam("sdate")String sdate,
			@RequestParam("edate")String edate,
			@RequestParam("customer")String customer,
			Model model) throws Exception{
		
	//	System.out.println(customer);
		
		Date dateFrom=CommonUtil.checkDate(sdate, dateFormat);
		Date dateTo=CommonUtil.checkDate(edate, dateFormat);
		
		List<String> grades=certificateAnalysisService.getRewindersGrade(dateFrom,dateTo,customer);
		
		model.addAttribute("sdate", sdate);
		model.addAttribute("edate", edate);
		model.addAttribute("grades", grades);
		
		model.addAttribute("customer", URLEncoder.encode(customer, "UTF-8"));
		
		return "certificate/certificateAnalysisViewGrade";
		
	}
	@RequestMapping(value="/load/data",method=RequestMethod.GET)
	public String load(@RequestParam("sdate")String sdate,
			@RequestParam("edate")String edate,
			@RequestParam("customer")String customer,
			@RequestParam("grade")String grade,
			Model model) throws Exception{
		
		
	
		
		Date dateFrom=CommonUtil.checkDate(sdate, dateFormat);
		Date dateTo=CommonUtil.checkDate(edate, dateFormat);
		
		List<Rewdinder> rewdinders=certificateAnalysisService.getRewinders(dateFrom,dateTo,URLDecoder.decode(customer,"UTF-8"),grade);
		model.addAttribute("rewdinders", rewdinders);
		
		model.addAttribute("customer", customer);
		
		return "certificate/certificateAnalysisView";
		
	}
	
	@RequestMapping(value="/pdf/certificate",method=RequestMethod.GET)
	public void createPdfCertificate(@RequestParam("reel")String reel,
			@RequestParam("custCode")String custCode,
			@RequestParam("customer")String customer,
			@RequestParam("grade")String grade,
			HttpServletResponse response) throws  Exception{
		
		response.setContentType("application/pdf");
		response.setHeader("Content-disposition", "inline; filename=\" Certificate_of_Analysis.pdf\"");
		
		certificateReport.createPdfReport(reel,custCode,customer,grade,response.getOutputStream());
	}
	
	
	@RequestMapping(value="/excel/certificate",method=RequestMethod.GET)
	public void createExcelCertificate(@RequestParam("reels")String reels,
			@RequestParam("customer")String customer,
			HttpServletResponse response) throws  Exception{
		
		
		
		
		response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
		response.setHeader("Content-Disposition", "attachment; filename=ST_Tissue_Certificate_Of_Analysis.xlsx");
		
		File file=new File(context.getRealPath("/")+"WEB-INF/excel template/CertificateOfAnalysis.xlsx");
		
		
		
		certificateReport.createReportExcel(reels,customer,file,response.getOutputStream());
	}
	
	
	@RequestMapping(value="/pdf/certificate/multi",method=RequestMethod.GET)
	public void createPdfCertificate(@RequestParam("reels")String reels,
			@RequestParam("customer")String customer,
			HttpServletResponse response) throws  Exception{
		
		response.setContentType("application/pdf");
		response.setHeader("Content-disposition", "inline; filename=\" Certificate_of_Analysis.pdf\"");
		
		certificateReport.createPdfReportMulti(reels, customer,response.getOutputStream());
	}
	
	/*********************** *******************new Certificate Best Diamond With roll  PM6 *********************************************************/
	
	
	@RequestMapping(value="/mainNew",method=RequestMethod.GET)
	public String mainNew(Model model){
		
		
		model.addAttribute("sdate", dateFormat.format(new Date()));
		model.addAttribute("edate", dateFormat.format(new Date()));
		
		List<String> customers=customerService.getCustomers();
		model.addAttribute("customers", customers);
		return "certificate/certificateAnalysisMainNew";
		
	}
	
	@RequestMapping(value="/loadNew",method=RequestMethod.GET)
	public String loadNew(@RequestParam("sdate")String sdate,
			@RequestParam("edate")String edate,
			@RequestParam("customer")String customer,
			Model model) throws Exception{
		
	//	System.out.println(customer);
		
		Date dateFrom=CommonUtil.checkDate(sdate, dateFormat);
		Date dateTo=CommonUtil.checkDate(edate, dateFormat);
		
		List<String> grades=certificateAnalysisService.getRewindersGrade(dateFrom,dateTo,customer);
		
		model.addAttribute("sdate", sdate);
		model.addAttribute("edate", edate);
		model.addAttribute("grades", grades);
		
		model.addAttribute("customer", URLEncoder.encode(customer, "UTF-8"));
		
		return "certificate/certificateAnalysisViewGradeNew";
		
	}
	@RequestMapping(value="/load/dataNew",method=RequestMethod.GET)
	public String loadNew(@RequestParam("sdate")String sdate,
			@RequestParam("edate")String edate,
			@RequestParam("customer")String customer,
			@RequestParam("grade")String grade,
			Model model) throws Exception{
		
		
	
		
		Date dateFrom=CommonUtil.checkDate(sdate, dateFormat);
		Date dateTo=CommonUtil.checkDate(edate, dateFormat);
		
		List<Rewdinder> rewdinders=certificateAnalysisService.getRewinders(dateFrom,dateTo,URLDecoder.decode(customer,"UTF-8"),grade);
		model.addAttribute("rewdinders", rewdinders);
		
		model.addAttribute("customer", customer);
		
		return "certificate/certificateAnalysisViewNew";
		
	}
	
	@RequestMapping(value="/pdf/certificateNew",method=RequestMethod.GET)
	public void createPdfCertificateNew(@RequestParam("reel")String reel,
			@RequestParam("custCode")String custCode,
			@RequestParam("customer")String customer,
			@RequestParam("grade")String grade,
			HttpServletResponse response) throws  Exception{
		
		response.setContentType("application/pdf");
		response.setHeader("Content-disposition", "inline; filename=\" Certificate_of_Analysis.pdf\"");
		
		certificateReport.createPdfReport(reel,custCode,customer,grade,response.getOutputStream());
	}
	
	
	@RequestMapping(value="/excel/certificateNew",method=RequestMethod.GET)
	public void createExcelCertificateNew(@RequestParam("reels")String reels,
			@RequestParam("customer")String customer,@RequestParam("sdate")String sdate,
			@RequestParam("edate")String edate,
			HttpServletResponse response) throws  Exception{
		Date dateFrom=CommonUtil.checkDate(sdate, dateFormat);
		Date dateTo=CommonUtil.checkDate(edate, dateFormat);
		
		
		
		response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
		response.setHeader("Content-Disposition", "attachment; filename=ST_Tissue_Certificate_Of_Analysis.xlsx");
		
		File file=new File(context.getRealPath("/")+"WEB-INF/excel template/CertificateOfAnalysis.xlsx");
		
		
		
		certificateReport.createReportExcelNew(reels,customer,dateFrom,dateTo,file,response.getOutputStream());
	}
	
	/*********************** *******************new Certificate Best Diamond With roll for PM5 *******************************************************/

	@RequestMapping(value="/mainNewPm5",method=RequestMethod.GET)
	public String mainNewPm5(Model model){
		
		
		model.addAttribute("sdate", dateFormat.format(new Date()));
		model.addAttribute("edate", dateFormat.format(new Date()));
		
		List<String> customers=customerService.getCustomers();
		model.addAttribute("customers", customers);
		return "certificate/certificateAnalysisMainNewpm5";
		
	}
	
	@RequestMapping(value="/loadNewpm5",method=RequestMethod.GET)
	public String loadNewpm5(@RequestParam("sdate")String sdate,
			@RequestParam("edate")String edate,
			@RequestParam("customer")String customer,
			Model model) throws Exception{
		
	//	System.out.println(customer);
		
		Date dateFrom=CommonUtil.checkDate(sdate, dateFormat);
		Date dateTo=CommonUtil.checkDate(edate, dateFormat);
		
		List<String> grades=certificateAnalysisService.getRewindersGradepm5(dateFrom,dateTo,customer);
		
		model.addAttribute("sdate", sdate);
		model.addAttribute("edate", edate);
		model.addAttribute("grades", grades);
		
		model.addAttribute("customer", URLEncoder.encode(customer, "UTF-8"));
		
		return "certificate/certificateAnalysisViewGradeNewpm5";
		
	}
	@RequestMapping(value="/load/dataNewpm5",method=RequestMethod.GET)
	public String loadNewpm(@RequestParam("sdate")String sdate,
			@RequestParam("edate")String edate,
			@RequestParam("customer")String customer,
			@RequestParam("grade")String grade,
			Model model) throws Exception{
		
		
	
		
		Date dateFrom=CommonUtil.checkDate(sdate, dateFormat);
		Date dateTo=CommonUtil.checkDate(edate, dateFormat);
		
		List<Rewdinder> rewdinders=certificateAnalysisService.getRewinderspm5(dateFrom,dateTo,URLDecoder.decode(customer,"UTF-8"),grade);
		model.addAttribute("rewdinders", rewdinders);
		
		model.addAttribute("customer", customer);
		
		return "certificate/certificateAnalysisViewNewpm5";
		
	}
	
	@RequestMapping(value="/pdf/certificateNewpm5",method=RequestMethod.GET)
	public void createPdfCertificateNewpm5(@RequestParam("reel")String reel,
			@RequestParam("custCode")String custCode,
			@RequestParam("customer")String customer,
			@RequestParam("grade")String grade,
			HttpServletResponse response) throws  Exception{
		
		response.setContentType("application/pdf");
		response.setHeader("Content-disposition", "inline; filename=\" Certificate_of_Analysis.pdf\"");
		
		certificateReport.createPdfReport(reel,custCode,customer,grade,response.getOutputStream());
	}
	
	
	@RequestMapping(value="/excel/certificateNewpm5",method=RequestMethod.GET)
	public void createExcelCertificateNewpm5(@RequestParam("reels")String reels,
			@RequestParam("customer")String customer,@RequestParam("sdate")String sdate,
			@RequestParam("edate")String edate,
			HttpServletResponse response) throws  Exception{
		Date dateFrom=CommonUtil.checkDate(sdate, dateFormat);
		Date dateTo=CommonUtil.checkDate(edate, dateFormat);
		
		
		
		response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
		response.setHeader("Content-Disposition", "attachment; filename=ST_Tissue_Certificate_Of_Analysis.xlsx");
		
		File file=new File(context.getRealPath("/")+"WEB-INF/excel template/CertificateOfAnalysis.xlsx");
		
		
		
		certificateReport.createReportExcelNewPm5(reels,customer,dateFrom,dateTo,file,response.getOutputStream());
	}
	
	
	
	
}

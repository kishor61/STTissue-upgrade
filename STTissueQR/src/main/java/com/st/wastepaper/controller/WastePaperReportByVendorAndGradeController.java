/**
 *Aug 7, 2015
 *WastePaperReportByVendorAndGrade.java
 * TODO
 *com.st.wastepaper.controller
 *WastePaperReportByVendorAndGrade.java
 *Sunil Singh Bora
 */
package com.st.wastepaper.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.st.common.CommonUtil;
import com.st.wastepaper.model.ByGrade;
import com.st.wastepaper.model.ByVendor;
import com.st.wastepaper.model.WastepaperDetail;
import com.st.wastepaper.report.WastePaperByVendorAndGradeReportHandler;
import com.st.wastepaper.service.WastePaperReportByGradeService;
import com.st.wastepaper.service.WastePaperReportByVendorAndGradeService;
import com.st.wastepaper.service.WastePaperReportByVendorService;

/**
 * @author roshan
 *
 */
@Controller
@RequestMapping("/wastepaperreportbyvendorandgrade")
public class WastePaperReportByVendorAndGradeController {

	private SimpleDateFormat dateFormat= new SimpleDateFormat("MM-dd-yyyy");
	
	private static final String VIEW_PAGE="viewpage";
	
	@Autowired
	private ServletContext context;
	
	@Autowired
	private WastePaperReportByVendorService wastepaperreportbyvendorservice;
	
	@Autowired
	private WastePaperReportByGradeService wastepaperreportbygradeservice;
	
	@Autowired
	private WastePaperReportByVendorAndGradeService	wastepaperreportbyvendorandgradeservice;
	
	@Autowired
	private WastePaperByVendorAndGradeReportHandler wastepaperbyvendorandgradereporthandler; 
	
	@RequestMapping("/view")
	public String main(HttpServletRequest request,HttpServletResponse response,Model model) {
		
		List<ByVendor> vendorName=wastepaperreportbyvendorservice.vendor();
		List<ByGrade> gradeName=wastepaperreportbygradeservice.grade();
		
		model.addAttribute("gradeName", gradeName);
		model.addAttribute("vendorName", vendorName);
		model.addAttribute("sdate", dateFormat.format(CommonUtil.getFirstDate(new Date())));
		model.addAttribute("edate", dateFormat.format(new Date()));
		
		return"wastepaperreportbyvendorandgrade";
	}
	@RequestMapping("/load")
	public String reportbyvendor(@RequestParam("sdate")String sdate,
			@RequestParam("edate")String edate,
			@RequestParam("grade")int gradeid,
			@RequestParam("vendor")String vendor,
			Model model,
			HttpServletRequest request,
			HttpServletResponse response) {
		Date sDate=CommonUtil.checkDate(sdate, dateFormat);
		Date eDate=CommonUtil.checkDate(edate, dateFormat);
		

		int _totalBalesCount=0;
		String itemDescription="";
		String vandorName="";
		
		double netTonsTotal=0;
		double pricePerTonTotal=0;
		double extensionTotal=0;
		double freightInvociedTotal=0;
		double freightChbkTotal=0;
		String freightChbkPending="";
		double grandTotal=0;
		
		List<ByVendor> vendorName=wastepaperreportbyvendorservice.vendor();
		List<ByGrade> gradeName=wastepaperreportbygradeservice.grade();
		
		List<WastepaperDetail> details=wastepaperreportbyvendorandgradeservice.load(sDate,eDate,gradeid,vendor);
		
		
		List<WastepaperDetail> wastepaperDetails=new ArrayList<WastepaperDetail>();
		final WastepaperDetail wastepaperDetail=new WastepaperDetail();
		for(WastepaperDetail wp:details){
			_totalBalesCount=wp.getBales()+_totalBalesCount;
			wastepaperDetail.setTotalbales(_totalBalesCount);
			
			vandorName=wp.getVandorName();
			wastepaperDetail.setVandorName(vandorName);
			
			itemDescription=wp.getItemDescription();
			wastepaperDetail.setItemDescription(itemDescription);
			
			netTonsTotal=wp.getNetTons()+netTonsTotal;
			wastepaperDetail.setNetTons(netTonsTotal);
			
			pricePerTonTotal=wp.getPricePerTon()+pricePerTonTotal;
			wastepaperDetail.setPricePerTon(pricePerTonTotal);
			
			extensionTotal=wp.getExtention()+extensionTotal;
			wastepaperDetail.setExtention(extensionTotal);
			
			freightInvociedTotal=wp.getFreightInvoiced()+freightInvociedTotal;
			wastepaperDetail.setFreightInvoiced(freightInvociedTotal);
			
			freightChbkTotal=wp.getFreightCHBK()+freightChbkTotal;
			wastepaperDetail.setFreightCHBK(freightChbkTotal);
			
			grandTotal=wp.getGrandTotal()+grandTotal;
			wastepaperDetail.setGrandTotal(grandTotal);
			
			wastepaperDetails.add(wastepaperDetail);
				
		}
		
		
		model.addAttribute("wpbvng",wastepaperDetail );
		
		model.addAttribute("gradeName", gradeName);
		model.addAttribute("vendorName", vendorName);
		
		model.addAttribute("srchdgradeid", gradeid);
		model.addAttribute("srchdvendor", vendor);
		
		model.addAttribute(VIEW_PAGE, true);
		model.addAttribute("details", details);
		model.addAttribute("sdate", dateFormat.format(sDate));
		model.addAttribute("edate", dateFormat.format(eDate));
		
	return "wastepaperreportbyvendorandgrade";
	}
	@RequestMapping(value="/export",method=RequestMethod.POST)
	public void export(@RequestParam("startdate")String sdate,
			@RequestParam("enddate")String edate,@RequestParam("grade")int gradeid,
			@RequestParam("vendor")String vendor,
			HttpServletResponse response) throws Exception{
		System.out.println("Exporting...");
		
		Date sDate=CommonUtil.checkDate(sdate, dateFormat);
		Date eDate=CommonUtil.checkDate(edate, dateFormat);
		
		
		List<WastepaperDetail> details=wastepaperreportbyvendorandgradeservice.load(sDate,eDate,gradeid,vendor);
		
		response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
		response.setHeader("Content-Disposition", "attachment; filename=Waste_Paper_Report_By_Vandor_And_Grade.xlsx");
		File file=new File(context.getRealPath("/")+"WEB-INF/Waste_Paper_Report_By_Vandor_And_Grade.xlsx");
		
		wastepaperbyvendorandgradereporthandler.getByVendorAndGradeReport(details,file,response.getOutputStream());
		}
}

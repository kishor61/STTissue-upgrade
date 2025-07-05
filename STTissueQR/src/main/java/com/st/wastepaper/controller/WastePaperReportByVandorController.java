/**
 *Aug 7, 2015
 *WastePaperReportByVandorController.java
 * TODO
 *com.st.wastepaper.controller
 *WastePaperReportByVandorController.java
 *Sunil Singh Bora
 */
package com.st.wastepaper.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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
import com.st.wastepaper.model.BarcodeComman;
import com.st.wastepaper.model.ByVendor;
import com.st.wastepaper.model.WastePaperBaleInventory;
import com.st.wastepaper.model.WastepaperDetail;
import com.st.wastepaper.report.WastePaperByVandorReportHandler;
import com.st.wastepaper.service.WastePaperReportByVendorService;

/**
 * @author roshan
 *
 */

@Controller
@RequestMapping("/wastepaperreportbyvandor")	
public class WastePaperReportByVandorController {

	private SimpleDateFormat dateFormat= new SimpleDateFormat("MM-dd-yyyy");
	
	private static final String VIEW_PAGE="viewpage";
	
	@Autowired
	private ServletContext context;
	
	
	WastePaperReportByVendorService wastepaperreportbyvendorservice;
	
	@Autowired
	private WastePaperByVandorReportHandler wastePaperByVandorReportHandler;
	
	@RequestMapping("/view")
	public String main(HttpServletRequest request,HttpServletResponse response, Model model){
		//System.out.println(wastepaperreportbyvendorservice.vendor());
		List<ByVendor> vendorName=wastepaperreportbyvendorservice.vendor();
		model.addAttribute("vendorName", vendorName);
		model.addAttribute("sdate", dateFormat.format(CommonUtil.getFirstDate(new Date())));
		model.addAttribute("edate", dateFormat.format(new Date()));
		return "wastepaperreportbyvandor";
	}
	@RequestMapping("/load")
	public String reportbyvendor(@RequestParam("sdate")String sdate,
			@RequestParam("edate")String edate,
			@RequestParam("vendor")String vendor,
			Model model,
			HttpServletRequest request,
			HttpServletResponse response) {
		Date sDate=CommonUtil.checkDate(sdate, dateFormat);
		Date eDate=CommonUtil.checkDate(edate, dateFormat);
		String vendorname=(String)request.getParameter("vendor");
		
		int _totalBalesCount=0;
		String vandorName="";
		
		double netTonsTotal=0;
		double pricePerTonTotal=0;
		double extensionTotal=0;
		double freightInvociedTotal=0;
		double freightChbkTotal=0;
		String freightChbkPending="";
		double grandTotal=0;
		
		List<WastepaperDetail> details=wastepaperreportbyvendorservice.loadVendorData(sDate,eDate,vendorname);
		List<ByVendor> vendorName=wastepaperreportbyvendorservice.vendor();
		
		List<WastepaperDetail> wastepaperDetails=new ArrayList<WastepaperDetail>();
		final WastepaperDetail wastepaperDetail=new WastepaperDetail();
		System.out.println("srchdendor:"+vendorname);
		
		for(WastepaperDetail wp:details){
			_totalBalesCount=wp.getBales()+_totalBalesCount;
			wastepaperDetail.setTotalbales(_totalBalesCount);
			
			if(vendorname==""){
				wastepaperDetail.setVandorName("");
			}else{
				vandorName=wp.getVandorName();
				wastepaperDetail.setVandorName(vandorName);
			}
			
			netTonsTotal=wp.getNetTons()+netTonsTotal;
			wastepaperDetail.setNetTons(netTonsTotal);
			
			pricePerTonTotal=wp.getPricePerTon()+pricePerTonTotal;
			wastepaperDetail.setPricePerTon(pricePerTonTotal);
			
			extensionTotal=wp.getExtention()+extensionTotal;
			//System.out.println(extensionTotal);
			wastepaperDetail.setExtention(extensionTotal);
			
			freightInvociedTotal=wp.getFreightInvoiced()+freightInvociedTotal;
			wastepaperDetail.setFreightInvoiced(freightInvociedTotal);
			
			freightChbkTotal=wp.getFreightCHBK()+freightChbkTotal;
			wastepaperDetail.setFreightCHBK(freightChbkTotal);
			
			grandTotal=wp.getGrandTotal()+grandTotal;
			wastepaperDetail.setGrandTotal(grandTotal);
			
			wastepaperDetails.add(wastepaperDetail);
				
		}
		model.addAttribute(VIEW_PAGE, true);
		model.addAttribute("vendorName", vendorName);
		
		model.addAttribute("wpd",wastepaperDetail );
		model.addAttribute("extensionTotal", extensionTotal);
		
		model.addAttribute("details", details);
		model.addAttribute("srchdendor", vendorname);
		model.addAttribute("sdate", dateFormat.format(sDate));
		model.addAttribute("edate", dateFormat.format(eDate));
		
	return "wastepaperreportbyvandor";
	}
	
	@RequestMapping(value="/export",method=RequestMethod.POST)
	public void export(@RequestParam("startdate")String sdate,
			@RequestParam("enddate")String edate,@RequestParam("vendor")String vendorname,
			HttpServletResponse response) throws Exception{
		System.out.println("Exporting...");
		
		Date sDate=CommonUtil.checkDate(sdate, dateFormat);
		Date eDate=CommonUtil.checkDate(edate, dateFormat);
		
		
		List<WastepaperDetail> details=wastepaperreportbyvendorservice.loadVendorData(sDate,eDate,vendorname);
		
		response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
		response.setHeader("Content-Disposition", "attachment; filename=Waste_Paper_Report_By_Vandor.xlsx");
		File file=new File(context.getRealPath("/")+"WEB-INF/Waste_Paper_Report_By_Vandor.xlsx");
		
		wastePaperByVandorReportHandler.getByVandorReport(details,vendorname,file,response.getOutputStream());
		}
}

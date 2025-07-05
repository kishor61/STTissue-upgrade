/**
 *Sep 15, 2015
 *WastePaperReceivingReportByPriceController.java
 * TODO
 *com.st.wastepaper.controller
 *WastePaperReceivingReportByPriceController.java
 *Sunil Singh Bora
 */
package com.st.wastepaper.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
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
import com.st.wastepaper.model.WastepaperDetail;
import com.st.wastepaper.report.WastePaperReceivingReportByPriceExcelHandler;
import com.st.wastepaper.report.WastePaperReceivingReportByPriceHandler;
import com.st.wastepaper.report.WastePaperReceivingReportHandler;
import com.st.wastepaper.service.WastePaperBaleInventoryService;


/**
 * @author roshan
 *
 */
@Controller
@RequestMapping("/wastepaperreceivingreportbyprice")
public class WastePaperReceivingReportByPriceController {

	private static final String VIEW_PAGE="viewpage";
	private SimpleDateFormat dateFormat=new SimpleDateFormat("MM-dd-yyyy");
	
	@Autowired
	private ServletContext context;
	
	@Autowired
	private WastePaperBaleInventoryService wastePaperBaleInventoryService;
	
	@Autowired
	private WastePaperReceivingReportByPriceHandler wastepaperreceivingreportbypricehandler ;
	
	@Autowired
	private WastePaperReceivingReportByPriceExcelHandler WastePaperReceivingReporbypricetExcelHandler;
	
	@RequestMapping("/view")
	public String unloadbales(HttpServletRequest request,HttpServletResponse response,Model model){
		return "wastepaperReceivingReportByPrice";
		}
	@RequestMapping(value="/report",method=RequestMethod.GET)
	public String report(HttpServletRequest request,HttpServletResponse response,Model model){
		
		int releaseNumber=CommonUtil.checkInt(request.getParameter("releaseNumber"));
		List<WastepaperDetail> receivinfReportByPrice=wastePaperBaleInventoryService.getReceivingReport(releaseNumber);
		
		List<WastepaperDetail> rejectBales=wastePaperBaleInventoryService.getRejectBales(releaseNumber);
		double rejectweight=0;
		int rejectbales=0;
		
		if(rejectBales.size()>0){
			for(WastepaperDetail reject:rejectBales){
				System.out.println(reject.getRejectbolweight());
				System.out.println(reject.getRejectbalecount());
				rejectweight=rejectweight+reject.getRejectbolweight();
				rejectbales=rejectbales+reject.getRejectbalecount();
				
				reject.setRejectbalecount(rejectbales);
				reject.setRejectbolweight(rejectweight);
			}
			
		}
		
		model.addAttribute(VIEW_PAGE, true);
		model.addAttribute("releaseNumber", releaseNumber);
		model.addAttribute("receivinfReportByPrice", receivinfReportByPrice);
		model.addAttribute("rejectweight", rejectweight);
		model.addAttribute("rejectbales", rejectbales);
		model.addAttribute("rejectBales", rejectBales);
		
		return "wastepaperReceivingReportByPrice";	
	}
	@RequestMapping("/exportpdfbyprice")
	public void wastepaperReceivingPdfExportByPrice(@RequestParam("releaseNumber") int releaseNumber,HttpServletRequest request,HttpServletResponse response)throws Exception, IOException{
		List<WastepaperDetail> receivinfReportByPrice=wastePaperBaleInventoryService.getReceivingReport(releaseNumber);
		
		List<WastepaperDetail> rejectBales=wastePaperBaleInventoryService.getRejectBales(releaseNumber);
		
		response.setContentType("application/pdf");
		response.setHeader("Content-Disposition", "attachment; filename=ST Paper1 LLC WASTEPAPER RECEIVING REPORT BY PRICE.pdf");
		wastepaperreceivingreportbypricehandler.createpdfReportByPrice(receivinfReportByPrice,rejectBales,response.getOutputStream());
		
	}	
	@RequestMapping(value="/exportexcel",method=RequestMethod.POST)
	public void exportreport(@RequestParam("releaseNumber") int releaseNumber,HttpServletRequest request,HttpServletResponse response) throws Exception{
		List<WastepaperDetail> datas=wastePaperBaleInventoryService.getReceivingReport(releaseNumber);
		
		List<WastepaperDetail> rejectBales=wastePaperBaleInventoryService.getRejectBales(releaseNumber);
		
		response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
		response.setHeader("Content-Disposition", "attachment; filename=ST Paper1_LLC_WASTEPAPER_RECEIVING_REPORT_BY_PRICE_ExcelFormat.xlsx");
		File file=new File(context.getRealPath("/")+"WEB-INF/ST Paper1_LLC_WASTEPAPER_RECEIVING_REPORT_BY_PRICE_ExcelFormat.xlsx");
		
		WastePaperReceivingReporbypricetExcelHandler.getWastePaperReceivingReportExcelFormat(datas,rejectBales,file,response.getOutputStream());
	
	}
}

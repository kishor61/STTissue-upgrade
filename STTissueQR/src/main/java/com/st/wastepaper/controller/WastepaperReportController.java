/**
 *Feb 17, 2015
 *WastepaperReportController.java
 * TODO
 *com.st.wastepaper.controller
 *WastepaperReportController.java
 *Sunil Singh Bora
 */

package com.st.wastepaper.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

import com.st.common.CommonUtil;
import com.st.common.FrpCommon;
import com.st.frpyield.model.FrpYield;
import com.st.wastepaper.comman.WastepaperComman;
import com.st.wastepaper.model.ByGrade;
import com.st.wastepaper.model.WastepaperDetail;
import com.st.wastepaper.report.WastepaperReportHandler;
import com.st.wastepaper.service.WastePaperBaleInventoryService;
import com.st.wastepaper.service.WastePaperReportByGradeService;
import com.st.wastepaper.service.WastepaperService;

/**
 * @author sbora
 *
 */
@Controller
@RequestMapping("/wastepaperreport")
public class WastepaperReportController {

	
	@Autowired
	private WastepaperService wastepaperService;
	
	@Autowired
	private WastepaperReportHandler wastepaperReportHandler;
	
	@Autowired
	private WastePaperBaleInventoryService wastePaperBaleInventoryService;
	
	@Autowired
	private WastePaperReportByGradeService wastepaperreportbygradeservice;
	
	private SimpleDateFormat dateFormat=new SimpleDateFormat("MM-dd-yyyy");
	
	
	
	@RequestMapping(value="/view",method=RequestMethod.GET)
	public String wastepaperDetailView(Model model) {
		
		model.addAttribute("sdate", dateFormat.format(CommonUtil.getFirstDate(new Date())));
		model.addAttribute("edate", dateFormat.format(new Date()));
		model.addAttribute("viewFlagMultipleSearchData", false);
		model.addAttribute("viewFlagForSingleSearchData", false);
		model.addAttribute("viewFlagForSingleSearchBar", true);
		return "productionWastepaper/wastepaperReport";
	}
	
	
	@RequestMapping(value="/view/data",method=RequestMethod.GET)
	public String wastepaperDetailView(@RequestParam("sdate")String sdate,@RequestParam("edate")String edate,Model model) {
		
		model.addAttribute("sdate", sdate);
		model.addAttribute("edate", edate);
		
		Date sDate=CommonUtil.checkDate(sdate, dateFormat);
		Date eDate=CommonUtil.checkDate(edate, dateFormat);
		// Code Starts From Here Done By Roshan Tailor Date :-06/25/2015 MM/DD/YYYY Night Shift
		model.addAttribute("destinations",WastepaperComman.getDestination());
		// Code Ends Here Done By Roshan Tailor Date :- 06/25/2015 MM/DD/YYYY Night Shift
		List<WastepaperDetail> details=wastepaperService.getWastepaperDetailData(sDate,eDate);
		
		model.addAttribute("details", details);
		model.addAttribute("viewFlagMultipleSearchData", true);
		model.addAttribute("viewFlagForSingleSearchData", false);
		model.addAttribute("viewFlagMultipleSearchBar", true);
		model.addAttribute("viewFlagForSingleSearchBar", true);
		return "productionWastepaper/wastepaperReport";
	}
	
	
	@RequestMapping(value="/export",method=RequestMethod.GET)
	public void wastepaperDetailExport(@RequestParam("sdate")String sdate,@RequestParam("edate")String edate,HttpServletResponse response) throws IOException {
		
		
		Date sDate=CommonUtil.checkDate(sdate, dateFormat);
		Date eDate=CommonUtil.checkDate(edate, dateFormat);
		
		List<WastepaperDetail> details=wastepaperService.getWastepaperDetailData(sDate,eDate);
		
		response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
		
		response.setHeader("Content-Disposition", "attachment; filename=Wastepaper_Detail_Report.xlsx");
		
		
		wastepaperReportHandler.createWastepaperDetailReport(details,response.getOutputStream());
		
	}
//	Code Starts From Here Done By Roshan Tailor :- 06/08/2015 MM/DD/YYYy Night Shift
	@RequestMapping(value="/transfertomaster",method=RequestMethod.GET)
	public String wastepapertransfertomaster(@RequestParam("sdate")String sdate,@RequestParam("edate")String edate,HttpServletResponse response,Model model)throws IOException{
		Date sDate=CommonUtil.checkDate(sdate, dateFormat);
		Date eDate=CommonUtil.checkDate(edate, dateFormat);
		List<WastepaperDetail> transferDetails=wastepaperService.getTransferToMaster(sDate,eDate);
		
		model.addAttribute("sdate", sdate);
		model.addAttribute("edate", edate);
		model.addAttribute("successtransfer", "Data transfer to Master table successfully.");
		return "productionWastepaper/wastepaperReport";
	}
	@RequestMapping(value="/addtomaster", method=RequestMethod.POST)
	public @ResponseBody Map<String , Object> save(HttpServletRequest request, HttpServletResponse response) throws IOException{
		Map<String , Object> map=new HashMap<String,Object>();
		try{
			String masterPO=CommonUtil.checkNull(request.getParameter("masterPO"));
			int releaseNo=CommonUtil.checkInt(request.getParameter("releaseNo"));
			String freightinvoiceno=CommonUtil.checkNull(request.getParameter("freightinvoiceno"));
			double freightinvoiced=CommonUtil.checkDouble(request.getParameter("freightinvoiced"));
			double detentioncharges=CommonUtil.checkDouble(request.getParameter("detentioncharges"));
			double deduction=CommonUtil.checkDouble(request.getParameter("deduction"));
			String destination=CommonUtil.checkNull(request.getParameter("destination"));
			Double estimatedfreight=(double)CommonUtil.checkDouble(request.getParameter("estimatedfreight"));
			Double pricePerTon=(double)CommonUtil.checkDouble(request.getParameter("pricePerTon"));
			int gradeid=CommonUtil.checkInt(request.getParameter("gradeid"));
			
			WastepaperDetail wastepaperDetail=new WastepaperDetail();
			wastepaperDetail.setMasterPO(masterPO);
			wastepaperDetail.setReleaseNo(releaseNo);
			wastepaperDetail.setFreightInvoiceNo(freightinvoiceno);
			wastepaperDetail.setFreightInvoiced(freightinvoiced);
			wastepaperDetail.setDetentionCharges(detentioncharges);
			wastepaperDetail.setDeduction(deduction);
			wastepaperDetail.setDestination(destination);
			wastepaperDetail.setEstimatedFreight(estimatedfreight);
			wastepaperDetail.setPricePerTon(pricePerTon);
			wastepaperDetail.setGradeid(gradeid);
			
			List<WastepaperDetail> checkReleaseNumber=wastepaperService.checkreleseNumber(releaseNo,gradeid);
			if(checkReleaseNumber.isEmpty()){
				int key=wastepaperService.addtomaster(wastepaperDetail);
				map.put("status", true);
				map.put("message", "Data Saved Successfully.");
			}else{
				wastepaperService.addtomasterUpdate(wastepaperDetail);
				map.put("status", true);
				map.put("id", wastepaperDetail.getReleaseNo());
				map.put("message", "Data Updated Successfully.");
			}
			
			
		}catch(Exception rlt){
			System.out.println("Roshan Says, You Have Problem In /addtomaster Method in WastePaperReportController.java");
			rlt.printStackTrace();
		}
		return map;
	}
//	Code Ends Here Done By Roshan Tailor Date ;- 06/08/2015 MM/DD/YYYY
//	Code Starts From Here Done By Roshan Tailor Date :- 07/03/2015 MM/DD/YYYY Nigyht Shift
	@RequestMapping(value="/editEstimatedFriegt/{id}",method=RequestMethod.GET)
	public String edit(
			@PathVariable("id")int id,
			Model model)
					throws ParseException{
		//List<FrpYield> EditFrpYield=frpYieldService.getEditFrpYieldData(sdate);
		List<WastepaperDetail> editFreight=wastepaperService.EditFreight(id);
		model.addAttribute("editFreight",editFreight);
		return "wastepaperfreightEdit";
		
	}

	@RequestMapping(value="/editEstimatedFriegtValue",method=RequestMethod.POST)
	public @ResponseBody Map<String, Object> saveEditEstimatedFriegtValue(HttpServletRequest request,HttpServletResponse response) throws IOException{
		Map<String, Object> map=new HashMap<String, Object>();
		System.out.println("We Are In editEstimatedFriegtValue Method");
		try{
			int id=CommonUtil.checkInt(request.getParameter("id"));
			String carrier=CommonUtil.checkNull(request.getParameter("carrier"));
			String shippingCity=CommonUtil.checkNull(request.getParameter("shippingCity"));
			String shippingState=CommonUtil.checkNull(request.getParameter("shippingState"));
			double estimatedFreight=CommonUtil.checkDouble(request.getParameter("estimatedFreight"));
			
			WastepaperDetail wastepaperDetail=new WastepaperDetail();
			wastepaperDetail.setId(id);
			wastepaperDetail.setCarrier(carrier);
			wastepaperDetail.setShippingCity(shippingCity);
			wastepaperDetail.setShippingState(shippingState);
			wastepaperDetail.setEstimatedFreight(estimatedFreight);
			
			try{

				if(wastepaperDetail.getId()==0){
					
					
				}else{
					//Update DataBase.
					wastepaperService.update(wastepaperDetail);
					map.put("status", true);
					map.put("id", wastepaperDetail.getId());
					map.put("message", "Data Updated Successfully");
				}
			}catch(Exception rlt){
				System.out.println("Roshan Says, You Have Problem In Update Method In WastePaserReportComntroller.java");
			}
		}catch(Exception rlt){
			System.out.println("Roshan Says, You Have A Problem In editEstimatedFriegtValue");
			rlt.printStackTrace();
		}
		return map;
	}
//	Code Ends Here Done By Roshan Tailor Date :- 07/03/2015 MM/DD/YYYY Night Shift
//Code Starts From Here Done By Roshan Tailor Date ;- 07/03/2015 MM/DD/YYYY Night Shift
@RequestMapping(value="/addEstimatedFreightValue",method=RequestMethod.GET)
public String addEstimatedFriegtValue(Model model){
	
	return "addEstimatedFreight";
}
@RequestMapping(value="/addnewEstimatedFreight",method=RequestMethod.POST)
public @ResponseBody Map<String, Object> addnewEstimatedFreight(HttpServletRequest request,HttpServletResponse response) throws IOException{
	Map<String, Object> map=new HashMap<String, Object>();
	System.out.println("Add New Estimated Freight Method");
	try{
		String carrier=CommonUtil.checkNull(request.getParameter("carrier"));
		String shippingCity=CommonUtil.checkNull(request.getParameter("shippingCity"));
		String shippingState=CommonUtil.checkNull(request.getParameter("shippingState"));
		double estimatedFreight=CommonUtil.checkDouble(request.getParameter("estimatedFreight"));
	
		
		WastepaperDetail wastepaperDetail=new WastepaperDetail();
		
		wastepaperDetail.setCarrier(carrier);
		wastepaperDetail.setShippingCity(shippingCity);
		wastepaperDetail.setShippingState(shippingState);
		wastepaperDetail.setEstimatedFreight(estimatedFreight);
	
		
		wastepaperService.addNewEstimatedFreight(wastepaperDetail);
		
		map.put("status", true);
		map.put("message", "Data Updated Successfully");
		
	}catch(Exception rlt){
		System.out.println("Roshan Say's, You Have An Error In addnewEstimatedFreight Method Ad WastepaperReportController.java ");
		rlt.printStackTrace();
	}
	return map;
}
//Code Ends Here Done By Roshan Tailor Date:- 07/03/2015 MM/DD/YYYY Night Shift
@RequestMapping(value="/viewSingleSearch",method=RequestMethod.GET)
public String report(HttpServletRequest request,HttpServletResponse response,Model model){
	
	int releaseNumber=CommonUtil.checkInt(request.getParameter("releaseNumber"));
	List<WastepaperDetail> details=wastePaperBaleInventoryService.getReceivingReport(releaseNumber);
	
	model.addAttribute("sdate", dateFormat.format(CommonUtil.getFirstDate(new Date())));
	model.addAttribute("edate", dateFormat.format(new Date()));
	model.addAttribute("destinations",WastepaperComman.getDestination());
	model.addAttribute("viewFlagMultipleSearchData", false);
	model.addAttribute("viewFlagForSingleSearchData", true);
	model.addAttribute("viewFlagMultipleSearchBar", false);
	model.addAttribute("viewFlagForSingleSearchBar", true);
	model.addAttribute("releaseNumber", releaseNumber);
	model.addAttribute("details", details);
	
	return "productionWastepaper/wastepaperReport";
}

}

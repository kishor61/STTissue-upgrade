/**
 *Jan 21, 2015
 *FiberBalnaceReportController.java
 * TODO
 *com.st.frppressquality.controller
 *FiberBalnaceReportController.java
 *Sunil Singh Bora
 */
package com.st.frppressquality.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.st.common.ColumnsOfTable;
import com.st.common.CommonUtil;
import com.st.common.FrpCommon;
import com.st.common.exception.ProductionException;
import com.st.common.exception.TrackerException;
import com.st.frppressquality.model.FrpDailyData;
import com.st.frppressquality.report.FrpPressQualityReportHandler;
import com.st.frppressquality.service.FrpPressQualityService;
import com.st.utilitykpimaster.model.MasterData;
import com.st.utilitykpimaster.service.MasterDataService;

/**
 * @author sbora
 *
 */
@Controller
@RequestMapping("/fiberbalancereport")
public class FiberBalanceReportController {
	@Autowired
	private FrpPressQualityService frpPressQualityService;
	
	
	@Autowired
	private MasterDataService masterDataService;
	
	@Autowired
	private FrpPressQualityReportHandler frpPressQualityReportHandler;
	
	private SimpleDateFormat dateFormat=new SimpleDateFormat("MM-dd-yyyy");
	
	@RequestMapping("/view")
	public String view(Model model) {
		
		model.addAttribute("sdate", dateFormat.format(CommonUtil.getFirstDate(new Date())));
		model.addAttribute("edate", dateFormat.format(new Date()));
		model.addAttribute("showFlag", false);
		
		model.addAttribute("grades", FrpCommon.getGrade());
		
		return "frp/fiberBalanceReportView";
	}
	
	
	@RequestMapping(value="/view/data",method=RequestMethod.GET)
	public String viewData(@RequestParam("sdate")String sdate,
			@RequestParam("edate")String edate,
			@RequestParam("grade")String grade,
			Model model) throws TrackerException, ProductionException {
		
		String prodType="";
		if(grade.equals("WH")){
			prodType="W";
		}else if(grade.equalsIgnoreCase("KF")){
			prodType="K";
		}
		
		
		model.addAttribute("sdate", sdate);
		model.addAttribute("edate", edate);
		model.addAttribute("showFlag", true);
		model.addAttribute("grade", grade);
		model.addAttribute("grades", FrpCommon.getGrade());
		
		
		List<FrpDailyData> dailyDatas=frpPressQualityService.getFiberBalanceReportData(CommonUtil.checkDate(sdate, dateFormat),CommonUtil.checkDate(edate, dateFormat),prodType);
		
		List<MasterData> masterDatas=masterDataService.getMasterDatas(CommonUtil.checkDate(sdate, dateFormat),CommonUtil.checkDate(edate, dateFormat));
		List<Map<String, String>> qualityDatas=masterDataService.getReportData(masterDatas, "K");
		
		for (FrpDailyData frpDailyData : dailyDatas) {
			setMasterData(frpDailyData,qualityDatas,prodType);
		}
		
		
		
		
		model.addAttribute("dailyDatas", dailyDatas);
		
		
		return "frp/fiberBalanceReportView";
	}


	@RequestMapping(value="/export",method=RequestMethod.POST)
	public void export(@RequestParam("sdate")String sdate,
			@RequestParam("edate")String edate,
			@RequestParam("grade")String grade,
			HttpServletResponse response) throws IOException, Exception {
		
		
		String prodType="";
		if(grade.equals("WH")){
			prodType="W";
		}else if(grade.equalsIgnoreCase("KF")){
			prodType="K";
		}
		
		List<FrpDailyData> dailyDatas=frpPressQualityService.getFiberBalanceReportData(CommonUtil.checkDate(sdate, dateFormat),CommonUtil.checkDate(edate, dateFormat),prodType);
		
		List<MasterData> masterDatas=masterDataService.getMasterDatas(CommonUtil.checkDate(sdate, dateFormat),CommonUtil.checkDate(edate, dateFormat));
		List<Map<String, String>> qualityDatas=masterDataService.getReportData(masterDatas, "K");
		
		for (FrpDailyData frpDailyData : dailyDatas) {
			
			
			setMasterData(frpDailyData,qualityDatas,prodType);
		}
		
		
		response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
		response.setHeader("Content-Disposition", "attachment; filename=Fiber_Balance_Report.xlsx");
		
		frpPressQualityReportHandler.createFiberBalanceReport(dailyDatas,response.getOutputStream());
	}
	
	
	/**
	 * @param frpDailyData
	 * @param qualityDatas
	 */
	private void setMasterData(FrpDailyData frpDailyData,
			List<Map<String, String>> qualityDatas,String prodType) {
		for (Map<String, String> map : qualityDatas) {
			if(map!=null){
				String date=map.get(ColumnsOfTable.COL_01);
				if(date!=null && date.equalsIgnoreCase(frpDailyData.getDate())){
					
					double prodWrapKraft=CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_25));
					double prodWrapBlead=CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_26));
					double totalProd=0;
					if(prodType.equalsIgnoreCase("W")){
						totalProd=prodWrapBlead;
					}else if(prodType.equalsIgnoreCase("K")){
						totalProd=prodWrapKraft;
					}else{
						totalProd=prodWrapBlead+prodWrapKraft;
					}
					frpDailyData.setWrapperTon(CommonUtil.round(totalProd, 2));
					frpDailyData.setWrapperTonBDST(CommonUtil.round(frpDailyData.getWrapperTon()*0.96, 2));
					frpDailyData.setSewerLoss(CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_13)));
					frpDailyData.setFiberToFrp(CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_14)));
					frpDailyData.setProdSlabOff(CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_03)));
					break;
				}
			}
		}
		
	}

}

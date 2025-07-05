/**
 *Nov 27, 2014
 *SummaryDataController.java
 * TODO
 *com.st.oimnotes.controller
 *SummaryDataController.java
 *Sunil Singh Bora
 */
package com.st.pmothers.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.google.gson.Gson;
import com.st.common.ColumnsOfTable;
import com.st.common.CommonUtil;
import com.st.frppressquality.service.FrpPressQualityService;
import com.st.frpproduction.model.FrpProdcution;
import com.st.frpproduction.service.FrpProdcutionService;
import com.st.pmothers.model.SummaryData;
import com.st.pmothers.service.SummaryDataService;
import com.st.utilitykpimaster.model.KpiRecordableDate;
import com.st.utilitykpimaster.model.MasterData;
import com.st.utilitykpimaster.service.KpiRecordableDateService;
import com.st.utilitykpimaster.service.MasterDataService;


/**
 * @author sbora
 *
 */
@Controller
@RequestMapping(value="/pmsummarydata")
public class SummaryDataController {
	
	private static final Logger logger=LoggerFactory.getLogger(SummaryDataController.class);
	@Autowired
	private SummaryDataService summaryDataService;
	
	@Autowired
	private MasterDataService masterDataService;
	

	@Autowired
	private FrpProdcutionService frpProdcutionService;
	
	@Autowired
	private FrpPressQualityService frpPressQualityService;
	
	@Autowired
	private KpiRecordableDateService kpiRecordableDateService;
	
	
	private SimpleDateFormat dateFormat=new SimpleDateFormat("MM-dd-yyyy");
	
	
	@RequestMapping("/main")
	public String main(Model model) {
		
		SummaryData summaryData=new SummaryData();
		summaryData.setDate(new Date());
		summaryData.setProductionDate(new Date());
		model.addAttribute("summaryData", summaryData);

		
		model.addAttribute("editFlag", false);
		
		return "dailySummary/summaryDataEntry";
	}
	
	
	@RequestMapping(value="/load/data",method=RequestMethod.POST)
	public void loadData(@RequestParam("date")String date,Model model ,HttpServletResponse response) throws Exception{
		
		SummaryData summaryData=summaryDataService.getMonthToDateData(CommonUtil.checkDate(date, dateFormat));
		
		Date edate=CommonUtil.checkDate(date, dateFormat);
		Date sdate=CommonUtil.getFirstDate(edate);
		
		
		
		double quality = 0;
		double uptime=0;
		double yield=0;
		double efficiency=0;
		
		double prodProdRed=0;
		double prodSlabOff=0;
		double prodProdReject=0;
		double machineProdActual=0;
		double prodWrapTotal=0;
		double prodProdWhite=0;
		
		double downtimeMin=0;
		
		
		double qualityY = 0;
		/*double uptimeY=0;*/
		double yieldY=0;
		double efficiencyY=0;
		
		double prodProdRedY=0;
		double prodSlabOffY=0;
		double prodProdRejectY=0;
		double machineProdActualY=0;
//		double prodWrapTotalY=0;
		double prodProdWhiteY=0;
		double energyTotal=0;
		
		
		try {
			
			
			List<MasterData> masterDatas=masterDataService.getMasterDatas(sdate,edate);
			List<Map<String, String>> qualityDatas=masterDataService.getReportData(masterDatas, "K");
			
			int total=qualityDatas.size();


			if(qualityDatas.size()>0){
				Map<String, String> map =qualityDatas.get(total-1);
				
				if(date.equals(map.get(ColumnsOfTable.COL_01))){
//					prodWrapTotalY=CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_07));
					prodProdWhiteY=CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_04));
					prodProdRedY=CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_05));
					prodSlabOffY=CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_03));
					prodProdRejectY=CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_06));
					machineProdActualY=CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_02));
					
					
					efficiencyY=CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_11));
					qualityY=CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_09));
					yieldY=CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_10));
					
					energyTotal=CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_23));
				}
				

			}
			
			
			
			for (Map<String, String> map : qualityDatas) {
				prodWrapTotal+=CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_07));
				prodProdWhite+=CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_04));
				prodProdRed+=CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_05));
				prodSlabOff+=CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_03));
				prodProdReject+=CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_06));
				
				machineProdActual+=CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_02));
				
				downtimeMin+=CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_24));
				
			}
			
			
			if(total>0){
				uptime=((1440*total)-downtimeMin)/(1440*total);
			}
			
			if(machineProdActual!=0){
				yield=(prodWrapTotal/machineProdActual);
			}
			
			
			if(prodWrapTotal!=0){
				quality=prodProdWhite/prodWrapTotal;
			}
			
			efficiency=uptime*yield*quality;
			
			//MTD
			
			summaryData.setQuality_MTD01(CommonUtil.round(quality*100, 2));
			summaryData.setQuality_MTD02(CommonUtil.round(prodProdRed, 2));
			summaryData.setQuality_MTD03(CommonUtil.round(prodSlabOff, 2));
			summaryData.setQuality_MTD04(CommonUtil.round(prodProdReject, 2));
			
			
			summaryData.setPaperProd_MTD01(CommonUtil.round(machineProdActual, 2));
			summaryData.setPaperProd_MTD02(CommonUtil.round(prodProdWhite, 2));
			summaryData.setPaperProd_MTD03(CommonUtil.round(efficiency*100, 2));
			
			summaryData.setPaperProd_MTD06(CommonUtil.round(yield*100, 2));
			
			
			//Yesterday
			summaryData.setQuality_Y01(CommonUtil.round(qualityY, 2));
			summaryData.setQuality_Y02(CommonUtil.round(prodProdRedY, 2));
			summaryData.setQuality_Y03(CommonUtil.round(prodSlabOffY, 2));
			summaryData.setQuality_Y04(CommonUtil.round(prodProdRejectY, 2));
			
			
			summaryData.setPaperProd_Y01(CommonUtil.round(machineProdActualY, 2));
			summaryData.setPaperProd_Y02(CommonUtil.round(prodProdWhiteY, 2));
			summaryData.setPaperProd_Y03(CommonUtil.round(efficiencyY, 2));
			
			summaryData.setPaperProd_Y06(CommonUtil.round(yieldY, 2));
			
			
			
			
			
			//Production data
			FrpProdcution frpProdcution=frpProdcutionService.getFrpProdcutionLast(CommonUtil.checkDate(date, dateFormat));
			if(frpProdcution!=null){
				summaryData.setFiberProd_Y01(frpProdcution.getDcsWPFeedADST());
				summaryData.setFiberProd_Y02(frpProdcution.getTotalProdADST());
				
				if(frpProdcution.getProdType().equals("KF")){
					summaryData.setFiberProd_Y07(frpProdcution.getYieldDcs());
				}else if(frpProdcution.getProdType().equals("BW")){
					summaryData.setFiberProd_Y03(frpProdcution.getYieldDcs());
				}
				
				summaryData.setFiberProd_Y06(frpProdcution.getMrSowAndCbs());
				summaryData.setFiberProd_Y08(frpProdcution.getMrGroundwood());
				
				
				//System.out.println(frpProdcution.getDcsWPFeedADSTTotal());
			}
			
			
			//Birghtness
			double birghtness=frpPressQualityService.getBirghtnessAvgByDate(CommonUtil.checkDate(date, dateFormat));
			double currentBrightness=frpPressQualityService.getBirghtnessAvgOfDay();
			double sludg=frpPressQualityService.getSludgConsistencyAvg(CommonUtil.checkDate(date, dateFormat));
			
			
			summaryData.setFiberProd_Y04(birghtness);
			summaryData.setFiberProd_Y05(currentBrightness);
			summaryData.setFiberProd_Y09(sludg);
			
			//Mill Water
			List<Map<String, String>> qualityDatas2=masterDataService.getReportData(masterDatas, "M");
			
			double milWater=0;
			
			if(qualityDatas2.size()>0){
				Map<String, String> map=qualityDatas2.get(qualityDatas2.size()-1);
				if(date.equals(map.get(ColumnsOfTable.COL_02))){
					milWater=CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_25));
				}
				
			}
			summaryData.setCosts_Y01(milWater);
			summaryData.setCosts_Y02(energyTotal);
			
			
			//---------------Recordable date 
			
			KpiRecordableDate kpiRecordableDate=kpiRecordableDateService.getLastKpiRecordableDate();
			if(kpiRecordableDate!=null){
				int days=CommonUtil.getDaysDiffernce(kpiRecordableDate.getDate(), edate);
				
				summaryData.setSafety_Y01(days);

			}
			
			
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
		}
		
		
		
		response.setContentType("application/json");
		response.getWriter().write(new Gson().toJson(summaryData));
		
	
		
	}
	
	
	@RequestMapping("/edit")
	public String edit(@RequestParam("id")int id,
			@RequestParam("sdate")String sdate,
			@RequestParam("edate")String edate,
			Model model) {
		

		SummaryData summaryData=summaryDataService.getSummaryData(id);
		model.addAttribute("summaryData", summaryData);
		model.addAttribute("sdate", sdate);
		model.addAttribute("edate", edate);
		
		model.addAttribute("editFlag", true);
		return "dailySummary/summaryDataEntry";
	}
	
	
	@RequestMapping("/delete")
	public String delete(@RequestParam("id")int id,
			@RequestParam("sdate")String sdate,
			@RequestParam("edate")String edate,
			RedirectAttributes redirectAttributes,
			Model model) {
		
		
		summaryDataService.delete(id);

		redirectAttributes.addFlashAttribute("message", "Data removed from database successfully.");
		
		return "redirect:/pmsummarydatareport/load/date?sdate="+sdate+"&edate="+edate;
	}
	
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public void save(HttpServletRequest request,HttpServletResponse response) throws IOException {
		
		Map<String, Object> map=new HashMap<String, Object>();
		
		try {
			SummaryData summaryData=new SummaryData();
			summaryData.setId(CommonUtil.checkInt(request.getParameter("id")));
			summaryData.setDate(CommonUtil.checkDate(request.getParameter("date"), dateFormat));
			summaryData.setProductionDate(CommonUtil.checkDate(request.getParameter("productionDate"), dateFormat));
			summaryData.setSafety_Y01(CommonUtil.checkDouble(request.getParameter("safety_Y01")));
			summaryData.setSafety_Y02(CommonUtil.checkDouble(request.getParameter("safety_Y02")));
			summaryData.setSafety_Y03(CommonUtil.checkDouble(request.getParameter("safety_Y03")));
			summaryData.setSafety_Y04(CommonUtil.checkDouble(request.getParameter("safety_Y04")));
//			summaryData.setSafety_Y05(CommonUtil.checkDouble(request.getParameter("safety_Y05")));
		//	summaryData.setSafety_MTD01(CommonUtil.checkDouble(request.getParameter("safety_MTD01")));
		//	summaryData.setSafety_MTD02(CommonUtil.checkDouble(request.getParameter("safety_MTD02")));
			summaryData.setSafety_MTD03(CommonUtil.checkDouble(request.getParameter("safety_MTD03")));
			summaryData.setSafety_MTD04(CommonUtil.checkDouble(request.getParameter("safety_MTD04")));
//			summaryData.setSafety_MTD05(CommonUtil.checkDouble(request.getParameter("safety_MTD05")));
			summaryData.setSafety_G01(CommonUtil.checkDouble(request.getParameter("safety_G01")));
			summaryData.setSafety_G02(CommonUtil.checkDouble(request.getParameter("safety_G02")));
		//	summaryData.setSafety_G03(CommonUtil.checkDouble(request.getParameter("safety_G03")));
		//	summaryData.setSafety_G04(CommonUtil.checkDouble(request.getParameter("safety_G04")));
		//	summaryData.setSafety_G05(CommonUtil.checkDouble(request.getParameter("safety_G05")));
			summaryData.setSafetyComment(CommonUtil.checkNull(request.getParameter("safetyComment")));
			summaryData.setHousekeeping_Y01(CommonUtil.checkDouble(request.getParameter("housekeeping_Y01")));
			summaryData.setHousekeeping_MTD01(CommonUtil.checkDouble(request.getParameter("housekeeping_MTD01")));
			summaryData.setHousekeeping_G01(CommonUtil.checkDouble(request.getParameter("housekeeping_G01")));
			summaryData.setHousekeepingCommnet(CommonUtil.checkNull(request.getParameter("housekeepingCommnet")));
			summaryData.setQuality_Y01(CommonUtil.checkDouble(request.getParameter("quality_Y01")));
			summaryData.setQuality_Y02(CommonUtil.checkDouble(request.getParameter("quality_Y02")));
			summaryData.setQuality_Y03(CommonUtil.checkDouble(request.getParameter("quality_Y03")));
			summaryData.setQuality_Y04(CommonUtil.checkDouble(request.getParameter("quality_Y04")));
			summaryData.setQuality_MTD01(CommonUtil.checkDouble(request.getParameter("quality_MTD01")));
			summaryData.setQuality_MTD02(CommonUtil.checkDouble(request.getParameter("quality_MTD02")));
			summaryData.setQuality_MTD03(CommonUtil.checkDouble(request.getParameter("quality_MTD03")));
			summaryData.setQuality_MTD04(CommonUtil.checkDouble(request.getParameter("quality_MTD04")));
			summaryData.setQuality_G01(CommonUtil.checkDouble(request.getParameter("quality_G01")));
		//	summaryData.setQuality_G02(CommonUtil.checkDouble(request.getParameter("quality_G02")));
		//	summaryData.setQuality_G03(CommonUtil.checkDouble(request.getParameter("quality_G03")));
		//	summaryData.setQuality_G04(CommonUtil.checkDouble(request.getParameter("quality_G04")));
			summaryData.setQualityComment(CommonUtil.checkNull(request.getParameter("qualityComment")));
			summaryData.setFiberProd_Y01(CommonUtil.checkDouble(request.getParameter("fiberProd_Y01")));
			summaryData.setFiberProd_Y02(CommonUtil.checkDouble(request.getParameter("fiberProd_Y02")));
			summaryData.setFiberProd_Y03(CommonUtil.checkDouble(request.getParameter("fiberProd_Y03")));
			summaryData.setFiberProd_Y04(CommonUtil.checkDouble(request.getParameter("fiberProd_Y04")));
			summaryData.setFiberProd_Y05(CommonUtil.checkDouble(request.getParameter("fiberProd_Y05")));
			summaryData.setFiberProd_Y06(CommonUtil.checkDouble(request.getParameter("fiberProd_Y06")));
			summaryData.setFiberProd_Y07(CommonUtil.checkDouble(request.getParameter("fiberProd_Y07")));
			summaryData.setFiberProd_Y08(CommonUtil.checkDouble(request.getParameter("fiberProd_Y08")));
			summaryData.setFiberProd_Y09(CommonUtil.checkDouble(request.getParameter("fiberProd_Y09")));
			summaryData.setFiberProd_MTD01(CommonUtil.checkDouble(request.getParameter("fiberProd_MTD01")));
			summaryData.setFiberProd_MTD02(CommonUtil.checkDouble(request.getParameter("fiberProd_MTD02")));
			summaryData.setFiberProd_MTD03(CommonUtil.checkDouble(request.getParameter("fiberProd_MTD03")));
			summaryData.setFiberProd_MTD04(CommonUtil.checkDouble(request.getParameter("fiberProd_MTD04")));
			summaryData.setFiberProd_MTD05(CommonUtil.checkDouble(request.getParameter("fiberProd_MTD05")));
			summaryData.setFiberProd_MTD06(CommonUtil.checkDouble(request.getParameter("fiberProd_MTD06")));
			summaryData.setFiberProd_MTD07(CommonUtil.checkDouble(request.getParameter("fiberProd_MTD07")));
			summaryData.setFiberProd_MTD08(CommonUtil.checkDouble(request.getParameter("fiberProd_MTD08")));
			summaryData.setFiberProd_MTD09(CommonUtil.checkDouble(request.getParameter("fiberProd_MTD09")));
	//		summaryData.setFiberProd_G01(CommonUtil.checkDouble(request.getParameter("fiberProd_G01")));
		//	summaryData.setFiberProd_G02(CommonUtil.checkDouble(request.getParameter("fiberProd_G02")));
			summaryData.setFiberProd_G03(CommonUtil.checkDouble(request.getParameter("fiberProd_G03")));
			summaryData.setFiberProd_G04(CommonUtil.checkDouble(request.getParameter("fiberProd_G04")));
			summaryData.setFiberProd_G05(CommonUtil.checkDouble(request.getParameter("fiberProd_G05")));
			summaryData.setFiberProd_G06(CommonUtil.checkDouble(request.getParameter("fiberProd_G06")));
			summaryData.setFiberProd_G07(CommonUtil.checkDouble(request.getParameter("fiberProd_G07")));
			summaryData.setFiberProd_G08(CommonUtil.checkDouble(request.getParameter("fiberProd_G08")));
			summaryData.setFiberProd_G09(CommonUtil.checkDouble(request.getParameter("fiberProd_G09")));
			summaryData.setFiberProdComment(CommonUtil.checkNull(request.getParameter("fiberProdComment")));
			summaryData.setPaperProd_Y01(CommonUtil.checkDouble(request.getParameter("paperProd_Y01")));
			summaryData.setPaperProd_Y02(CommonUtil.checkDouble(request.getParameter("paperProd_Y02")));
			summaryData.setPaperProd_Y03(CommonUtil.checkDouble(request.getParameter("paperProd_Y03")));
			summaryData.setPaperProd_Y04(CommonUtil.checkNull(request.getParameter("paperProd_Y04")));
			summaryData.setPaperProd_Y05(CommonUtil.checkDouble(request.getParameter("paperProd_Y05")));
			summaryData.setPaperProd_Y06(CommonUtil.checkDouble(request.getParameter("paperProd_Y06")));
			summaryData.setPaperProd_Y07(CommonUtil.checkDouble(request.getParameter("paperProd_Y07")));
			summaryData.setPaperProd_MTD01(CommonUtil.checkDouble(request.getParameter("paperProd_MTD01")));
			summaryData.setPaperProd_MTD02(CommonUtil.checkDouble(request.getParameter("paperProd_MTD02")));
			summaryData.setPaperProd_MTD03(CommonUtil.checkDouble(request.getParameter("paperProd_MTD03")));
//			summaryData.setPaperProd_MTD04(CommonUtil.checkDouble(request.getParameter("paperProd_MTD04")));
//			summaryData.setPaperProd_MTD05(CommonUtil.checkDouble(request.getParameter("paperProd_MTD05")));
			summaryData.setPaperProd_MTD06(CommonUtil.checkDouble(request.getParameter("paperProd_MTD06")));
			summaryData.setPaperProd_MTD07(CommonUtil.checkDouble(request.getParameter("paperProd_MTD07")));
//			summaryData.setPaperProd_G01(CommonUtil.checkDouble(request.getParameter("paperProd_G01")));
//			summaryData.setPaperProd_G02(CommonUtil.checkDouble(request.getParameter("paperProd_G02")));
			summaryData.setPaperProd_G03(CommonUtil.checkDouble(request.getParameter("paperProd_G03")));
//			summaryData.setPaperProd_G04(CommonUtil.checkDouble(request.getParameter("paperProd_G04")));
//			summaryData.setPaperProd_G05(CommonUtil.checkDouble(request.getParameter("paperProd_G05")));
			summaryData.setPaperProd_G06(CommonUtil.checkDouble(request.getParameter("paperProd_G06")));
			summaryData.setPaperProd_G07(CommonUtil.checkDouble(request.getParameter("paperProd_G07")));
			summaryData.setPaperProdComment(CommonUtil.checkNull(request.getParameter("paperProdComment")));
			summaryData.setShipping_Y01(CommonUtil.checkDouble(request.getParameter("shipping_Y01")));
			summaryData.setShipping_Y02(CommonUtil.checkDouble(request.getParameter("shipping_Y02")));
			summaryData.setShipping_Y03(CommonUtil.checkDouble(request.getParameter("shipping_Y03")));
			summaryData.setShipping_Y04(CommonUtil.checkDouble(request.getParameter("shipping_Y04")));
//			summaryData.setShipping_MTD01(CommonUtil.checkDouble(request.getParameter("shipping_MTD01")));
//			summaryData.setShipping_MTD02(CommonUtil.checkDouble(request.getParameter("shipping_MTD02")));
//			summaryData.setShipping_MTD03(CommonUtil.checkDouble(request.getParameter("shipping_MTD03")));
//			summaryData.setShipping_MTD04(CommonUtil.checkDouble(request.getParameter("shipping_MTD04")));
//			summaryData.setShipping_G01(CommonUtil.checkDouble(request.getParameter("shipping_G01")));
//			summaryData.setShipping_G02(CommonUtil.checkDouble(request.getParameter("shipping_G02")));
//			summaryData.setShipping_G03(CommonUtil.checkDouble(request.getParameter("shipping_G03")));
//			summaryData.setShipping_G04(CommonUtil.checkDouble(request.getParameter("shipping_G04")));
			summaryData.setShippingComment(CommonUtil.checkNull(request.getParameter("shippingComment")));
			summaryData.setCosts_Y01(CommonUtil.checkDouble(request.getParameter("costs_Y01")));
			summaryData.setCosts_Y02(CommonUtil.checkDouble(request.getParameter("costs_Y02")));
			summaryData.setCosts_MTD01(CommonUtil.checkDouble(request.getParameter("costs_MTD01")));
			summaryData.setCosts_MTD02(CommonUtil.checkDouble(request.getParameter("costs_MTD02")));
			summaryData.setCosts_G01(CommonUtil.checkDouble(request.getParameter("costs_G01")));
			summaryData.setCosts_G02(CommonUtil.checkDouble(request.getParameter("costs_G02")));
			summaryData.setCostsComment(CommonUtil.checkNull(request.getParameter("costsComment")));

			summaryData.setSafetyMeetingTopic(CommonUtil.checkNull(request.getParameter("safetyMeetingTopic")));
			summaryData.setNotes(CommonUtil.checkNull(request.getParameter("notes")));
			
			summaryData.setMeetingToday(CommonUtil.checkNull(request.getParameter("meetingToday")));
			summaryData.setAttendee(CommonUtil.checkNull(request.getParameter("attendee")));
			summaryData.setVisitor(CommonUtil.checkNull(request.getParameter("visitor")));
//			
			
			int key=summaryDataService.saveOrUpdate(summaryData);
			
			map.put("flag", true);
			map.put("id", key);
		} catch (Exception e) {
			map.put("flag", false);
			map.put("error", "Unable to save data into database. Error:-"+e.getMessage());
		}
	
		response.setContentType("application/json");
		response.getWriter().write(new Gson().toJson(map));
		
	}
	
}

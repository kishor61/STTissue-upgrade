/**
 *Mar 10, 2018
 *CenterlineGradePM5Controller.java
 * TODO
 *com.st.centerlinePM5.controller
 *CenterlineGradePM5Controller.java
 *Roshan Lal Tailor
 */
package com.st.centerlinePM5.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;
import com.st.centerline.model.CenterlineGrade;
import com.st.centerline.service.CenterlineService;
import com.st.centerlinePM5.service.CenterlineServicePM5;
import com.st.common.CommonUtil;

/**
 * @author roshan
 *
 */
@Controller
@RequestMapping(value="/pm5centerlinegrade")
public class CenterlineGradePM5Controller {
	
	private static final String NEW_PAGE="newpage";
	private static final String EDIT_PAGE="editpage";
	private static final String VIEW_PAGE="viewpage";
	private SimpleDateFormat dateFormat1=new SimpleDateFormat("MM-dd-yyyy");
	
	@Autowired
	private CenterlineServicePM5 centerlineServicepm5;
	
	@RequestMapping(value="/main")
	public String centerlineGrade(Model model) {
		
		model.addAttribute("cgrades",centerlineServicepm5.getCenterlineGradeIds());
		
		return "PM5/centerlineGrade";
	}
	
	@RequestMapping(value="/add")
	public String centerlineGradeAdd(Model model) {
		
		model.addAttribute(NEW_PAGE, true);
		model.addAttribute(EDIT_PAGE, false);
		model.addAttribute(VIEW_PAGE, false);
		model.addAttribute("date", dateFormat1.format(new Date()));
		
		model.addAttribute("cgrades",centerlineServicepm5.getCenterlineGradeIds());
		
		return "PM5/centerlineGrade";
	}
	
	@RequestMapping(value="/view/{id}")
	public String centerlineGradeView(@PathVariable("id")int id,
			Model model) {
		
		model.addAttribute(NEW_PAGE, false);
		model.addAttribute(EDIT_PAGE, false);
		model.addAttribute(VIEW_PAGE, true);
		model.addAttribute("id", id);
		
		
		CenterlineGrade centerlineGrade=centerlineServicepm5.getCenterlineGrade(id);
		if(centerlineGrade.getIssueDate()==null){
			centerlineGrade.setFissueDate("");
		}else{
			centerlineGrade.setFissueDate(dateFormat1.format(centerlineGrade.getIssueDate()));
		}
		model.addAttribute("cgrades",centerlineServicepm5.getCenterlineGradeIds());
		model.addAttribute("grade", centerlineGrade);
		
		return "PM5/centerlineGrade";
	}
	
	@RequestMapping(value="/edit/{id}")
	public String centerlineGradeEdit(@PathVariable("id")int id,
			Model model) {
		
		model.addAttribute(NEW_PAGE, false);
		model.addAttribute(EDIT_PAGE, true);
		model.addAttribute(VIEW_PAGE, false);
		model.addAttribute("id", id);
		
		model.addAttribute("cgrades",centerlineServicepm5.getCenterlineGradeIds());
		model.addAttribute("grade", centerlineServicepm5.getCenterlineGrade(id));
		
		return "PM5/centerlineGrade";
	}
	
	@RequestMapping(value="/save")
	public void centerlineGradeSave(HttpServletRequest request,
			HttpServletResponse response,
			Model model) throws IOException {
		
		String gradeCode=CommonUtil.checkNull(request.getParameter("gradeCode"));
		Date issueDate=CommonUtil.checkDate(request.getParameter("issueDate"),dateFormat1);
		String revision=CommonUtil.checkNull(request.getParameter("revision"));
		
		double yankeeSpeed=CommonUtil.checkDouble(request.getParameter("yankeeSpeed"));
		double qcsBasisWtTarget=CommonUtil.checkDouble(request.getParameter("qcsBasisWtTarget"));
		double reelMoisture=CommonUtil.checkDouble(request.getParameter("reelMoisture"));
		double crepe=CommonUtil.checkDouble(request.getParameter("crepe"));
		double yankeeSteam=CommonUtil.checkDouble(request.getParameter("yankeeSteam"));
		double yankeeRelease=CommonUtil.checkDouble(request.getParameter("yankeeRelease"));
		double yankeeAdesive=CommonUtil.checkDouble(request.getParameter("yankeeAdesive"));
		double jetWireRatio=CommonUtil.checkDouble(request.getParameter("jetWireRatio"));
		double fanPumpFlowRate=CommonUtil.checkDouble(request.getParameter("fanPumpFlowRate"));
		double afterDryerSteam=CommonUtil.checkDouble(request.getParameter("afterDryerSteam"));
		String sprLoading=CommonUtil.checkNull(request.getParameter("sprLoading"));
		double feltPassivator=CommonUtil.checkDouble(request.getParameter("feltPassivator"));
		double sprayboomPressure=CommonUtil.checkDouble(request.getParameter("sprayboomPressure"));
		double sprayboomTemparature=CommonUtil.checkDouble(request.getParameter("sprayboomTemparature"));
		double wefanSpeed=CommonUtil.checkDouble(request.getParameter("wefanSpeed"));
		double defanSpeed=CommonUtil.checkDouble(request.getParameter("defanSpeed"));
		double makeUpAirDamper=CommonUtil.checkDouble(request.getParameter("makeUpAirDamper"));
		double exhaustDamper=CommonUtil.checkDouble(request.getParameter("exhaustDamper"));
		double exhaustFanSpeed=CommonUtil.checkDouble(request.getParameter("exhaustFanSpeed"));
		double wehoodTemperature=CommonUtil.checkDouble(request.getParameter("wehoodTemperature"));
		double dehoodTemperature=CommonUtil.checkDouble(request.getParameter("dehoodTemperature"));
		double yankeeAP=CommonUtil.checkDouble(request.getParameter("yankeeAP"));
		double afterDryerAP=CommonUtil.checkDouble(request.getParameter("afterDryerAP"));
		double secArmLoading=CommonUtil.checkDouble(request.getParameter("secArmLoading"));
		double reelOffset=CommonUtil.checkDouble(request.getParameter("reelOffset"));
		double uhleBoxNorthValve=CommonUtil.checkDouble(request.getParameter("uhleBoxNorthValve"));
		double uhleBoxSouthValve=CommonUtil.checkDouble(request.getParameter("uhleBoxSouthValve"));
		double faltBox1VacuumValve=CommonUtil.checkDouble(request.getParameter("faltBox1VacuumValve"));
		double faltBox2VacuumValve=CommonUtil.checkDouble(request.getParameter("faltBox2VacuumValve"));
		double faltBox4VacuumValve=CommonUtil.checkDouble(request.getParameter("faltBox4VacuumValve"));
		double fanPumpSpeed=CommonUtil.checkDouble(request.getParameter("fanPumpSpeed"));
		double totalHead=CommonUtil.checkDouble(request.getParameter("totalHead"));
		double headboxLevel=CommonUtil.checkDouble(request.getParameter("headboxLevel"));
		String horizontalSlice=CommonUtil.checkNull(request.getParameter("horizontalSlice"));
		String verticalSlice=CommonUtil.checkNull(request.getParameter("verticalSlice"));
		double selectifierRejectFlow1=CommonUtil.checkDouble(request.getParameter("selectifierRejectFlow1"));
		double selectifierRejectFlow2=CommonUtil.checkDouble(request.getParameter("selectifierRejectFlow2"));
		double secScreenCycleTime=CommonUtil.checkDouble(request.getParameter("secScreenCycleTime"));
		double lowDensityCycleTime=CommonUtil.checkDouble(request.getParameter("lowDensityCycleTime"));
		double refinersEnergy=CommonUtil.checkDouble(request.getParameter("refinersEnergy"));
		double numberOfRefiners=CommonUtil.checkDouble(request.getParameter("numberOfRefiners"));
		double refinerInletConsistency=CommonUtil.checkDouble(request.getParameter("refinerInletConsistency"));
		double machineChestConsistency=CommonUtil.checkDouble(request.getParameter("machineChestConsistency"));
		double stockFlow=CommonUtil.checkDouble(request.getParameter("stockFlow"));
		double sweetnerFlow=CommonUtil.checkDouble(request.getParameter("sweetnerFlow"));
		double broke=CommonUtil.checkDouble(request.getParameter("broke"));
		double wetStrength=CommonUtil.checkDouble(request.getParameter("wetStrength"));

		double yankeeSpeedMinC=CommonUtil.checkDouble(request.getParameter("yankeeSpeedMinC"));
		double qcsBasisWtTargetMinC=CommonUtil.checkDouble(request.getParameter("qcsBasisWtTargetMinC"));
		double reelMoistureMinC=CommonUtil.checkDouble(request.getParameter("reelMoistureMinC"));
		double crepeMinC=CommonUtil.checkDouble(request.getParameter("crepeMinC"));
		double yankeeSteamMinC=CommonUtil.checkDouble(request.getParameter("yankeeSteamMinC"));
		double yankeeReleaseMinC=CommonUtil.checkDouble(request.getParameter("yankeeReleaseMinC"));
		double yankeeAdesiveMinC=CommonUtil.checkDouble(request.getParameter("yankeeAdesiveMinC"));
		double jetWireRatioMinC=CommonUtil.checkDouble(request.getParameter("jetWireRatioMinC"));
		double fanPumpFlowRateMinC=CommonUtil.checkDouble(request.getParameter("fanPumpFlowRateMinC"));
		double afterDryerSteamMinC=CommonUtil.checkDouble(request.getParameter("afterDryerSteamMinC"));
		String sprLoadingMinC=CommonUtil.checkNull(request.getParameter("sprLoadingMinC"));
		double feltPassivatorMinC=CommonUtil.checkDouble(request.getParameter("feltPassivatorMinC"));
		double sprayboomPressureMinC=CommonUtil.checkDouble(request.getParameter("sprayboomPressureMinC"));
		double sprayboomTemparatureMinC=CommonUtil.checkDouble(request.getParameter("sprayboomTemparatureMinC"));
		double wefanSpeedMinC=CommonUtil.checkDouble(request.getParameter("wefanSpeedMinC"));
		double defanSpeedMinC=CommonUtil.checkDouble(request.getParameter("defanSpeedMinC"));
		double makeUpAirDamperMinC=CommonUtil.checkDouble(request.getParameter("makeUpAirDamperMinC"));
		double exhaustDamperMinC=CommonUtil.checkDouble(request.getParameter("exhaustDamperMinC"));
		double exhaustFanSpeedMinC=CommonUtil.checkDouble(request.getParameter("exhaustFanSpeedMinC"));
		double wehoodTemperatureMinC=CommonUtil.checkDouble(request.getParameter("wehoodTemperatureMinC"));
		double dehoodTemperatureMinC=CommonUtil.checkDouble(request.getParameter("dehoodTemperatureMinC"));
		double yankeeAPMinC=CommonUtil.checkDouble(request.getParameter("yankeeAPMinC"));
		double afterDryerAPMinC=CommonUtil.checkDouble(request.getParameter("afterDryerAPMinC"));
		double secArmLoadingMinC=CommonUtil.checkDouble(request.getParameter("secArmLoadingMinC"));
		double reelOffsetMinC=CommonUtil.checkDouble(request.getParameter("reelOffsetMinC"));
		double uhleBoxNorthValveMinC=CommonUtil.checkDouble(request.getParameter("uhleBoxNorthValveMinC"));
		double uhleBoxSouthValveMinC=CommonUtil.checkDouble(request.getParameter("uhleBoxSouthValveMinC"));
		double faltBox1VacuumValveMinC=CommonUtil.checkDouble(request.getParameter("faltBox1VacuumValveMinC"));
		double faltBox2VacuumValveMinC=CommonUtil.checkDouble(request.getParameter("faltBox2VacuumValveMinC"));
		double faltBox4VacuumValveMinC=CommonUtil.checkDouble(request.getParameter("faltBox4VacuumValveMinC"));
		double fanPumpSpeedMinC=CommonUtil.checkDouble(request.getParameter("fanPumpSpeedMinC"));
		double totalHeadMinC=CommonUtil.checkDouble(request.getParameter("totalHeadMinC"));
		double headboxLevelMinC=CommonUtil.checkDouble(request.getParameter("headboxLevelMinC"));
		String horizontalSliceMinC=CommonUtil.checkNull(request.getParameter("horizontalSliceMinC"));
		String verticalSliceMinC=CommonUtil.checkNull(request.getParameter("verticalSliceMinC"));
		double selectifierRejectFlow1MinC=CommonUtil.checkDouble(request.getParameter("selectifierRejectFlow1MinC"));
		double selectifierRejectFlow2MinC=CommonUtil.checkDouble(request.getParameter("selectifierRejectFlow2MinC"));
		double secScreenCycleTimeMinC=CommonUtil.checkDouble(request.getParameter("secScreenCycleTimeMinC"));
		double lowDensityCycleTimeMinC=CommonUtil.checkDouble(request.getParameter("lowDensityCycleTimeMinC"));
		double refinersEnergyMinC=CommonUtil.checkDouble(request.getParameter("refinersEnergyMinC"));
		double numberOfRefinersMinC=CommonUtil.checkDouble(request.getParameter("numberOfRefinersMinC"));
		double refinerInletConsistencyMinC=CommonUtil.checkDouble(request.getParameter("refinerInletConsistencyMinC"));
		double machineChestConsistencyMinC=CommonUtil.checkDouble(request.getParameter("machineChestConsistencyMinC"));
		double stockFlowMinC=CommonUtil.checkDouble(request.getParameter("stockFlowMinC"));
		double sweetnerFlowMinC=CommonUtil.checkDouble(request.getParameter("sweetnerFlowMinC"));
		double brokeMinC=CommonUtil.checkDouble(request.getParameter("brokeMinC"));
		double wetStrengthMinC=CommonUtil.checkDouble(request.getParameter("wetStrengthMinC"));

		double yankeeSpeedMaxC=CommonUtil.checkDouble(request.getParameter("yankeeSpeedMaxC"));
		double qcsBasisWtTargetMaxC=CommonUtil.checkDouble(request.getParameter("qcsBasisWtTargetMaxC"));
		double reelMoistureMaxC=CommonUtil.checkDouble(request.getParameter("reelMoistureMaxC"));
		double crepeMaxC=CommonUtil.checkDouble(request.getParameter("crepeMaxC"));
		double yankeeSteamMaxC=CommonUtil.checkDouble(request.getParameter("yankeeSteamMaxC"));
		double yankeeReleaseMaxC=CommonUtil.checkDouble(request.getParameter("yankeeReleaseMaxC"));
		double yankeeAdesiveMaxC=CommonUtil.checkDouble(request.getParameter("yankeeAdesiveMaxC"));
		double jetWireRatioMaxC=CommonUtil.checkDouble(request.getParameter("jetWireRatioMaxC"));
		double fanPumpFlowRateMaxC=CommonUtil.checkDouble(request.getParameter("fanPumpFlowRateMaxC"));
		double afterDryerSteamMaxC=CommonUtil.checkDouble(request.getParameter("afterDryerSteamMaxC"));
		String sprLoadingMaxC=CommonUtil.checkNull(request.getParameter("sprLoadingMaxC"));
		double feltPassivatorMaxC=CommonUtil.checkDouble(request.getParameter("feltPassivatorMaxC"));
		double sprayboomPressureMaxC=CommonUtil.checkDouble(request.getParameter("sprayboomPressureMaxC"));
		double sprayboomTemparatureMaxC=CommonUtil.checkDouble(request.getParameter("sprayboomTemparatureMaxC"));
		double wefanSpeedMaxC=CommonUtil.checkDouble(request.getParameter("wefanSpeedMaxC"));
		double defanSpeedMaxC=CommonUtil.checkDouble(request.getParameter("defanSpeedMaxC"));
		double makeUpAirDamperMaxC=CommonUtil.checkDouble(request.getParameter("makeUpAirDamperMaxC"));
		double exhaustDamperMaxC=CommonUtil.checkDouble(request.getParameter("exhaustDamperMaxC"));
		double exhaustFanSpeedMaxC=CommonUtil.checkDouble(request.getParameter("exhaustFanSpeedMaxC"));
		double wehoodTemperatureMaxC=CommonUtil.checkDouble(request.getParameter("wehoodTemperatureMaxC"));
		double dehoodTemperatureMaxC=CommonUtil.checkDouble(request.getParameter("dehoodTemperatureMaxC"));
		double yankeeAPMaxC=CommonUtil.checkDouble(request.getParameter("yankeeAPMaxC"));
		double afterDryerAPMaxC=CommonUtil.checkDouble(request.getParameter("afterDryerAPMaxC"));
		double secArmLoadingMaxC=CommonUtil.checkDouble(request.getParameter("secArmLoadingMaxC"));
		double reelOffsetMaxC=CommonUtil.checkDouble(request.getParameter("reelOffsetMaxC"));
		double uhleBoxNorthValveMaxC=CommonUtil.checkDouble(request.getParameter("uhleBoxNorthValveMaxC"));
		double uhleBoxSouthValveMaxC=CommonUtil.checkDouble(request.getParameter("uhleBoxSouthValveMaxC"));
		double faltBox1VacuumValveMaxC=CommonUtil.checkDouble(request.getParameter("faltBox1VacuumValveMaxC"));
		double faltBox2VacuumValveMaxC=CommonUtil.checkDouble(request.getParameter("faltBox2VacuumValveMaxC"));
		double faltBox4VacuumValveMaxC=CommonUtil.checkDouble(request.getParameter("faltBox4VacuumValveMaxC"));
		double fanPumpSpeedMaxC=CommonUtil.checkDouble(request.getParameter("fanPumpSpeedMaxC"));
		double totalHeadMaxC=CommonUtil.checkDouble(request.getParameter("totalHeadMaxC"));
		double headboxLevelMaxC=CommonUtil.checkDouble(request.getParameter("headboxLevelMaxC"));
		String horizontalSliceMaxC=CommonUtil.checkNull(request.getParameter("horizontalSliceMaxC"));
		String verticalSliceMaxC=CommonUtil.checkNull(request.getParameter("verticalSliceMaxC"));
		double selectifierRejectFlow1MaxC=CommonUtil.checkDouble(request.getParameter("selectifierRejectFlow1MaxC"));
		double selectifierRejectFlow2MaxC=CommonUtil.checkDouble(request.getParameter("selectifierRejectFlow2MaxC"));
		double secScreenCycleTimeMaxC=CommonUtil.checkDouble(request.getParameter("secScreenCycleTimeMaxC"));
		double lowDensityCycleTimeMaxC=CommonUtil.checkDouble(request.getParameter("lowDensityCycleTimeMaxC"));
		double refinersEnergyMaxC=CommonUtil.checkDouble(request.getParameter("refinersEnergyMaxC"));
		double numberOfRefinersMaxC=CommonUtil.checkDouble(request.getParameter("numberOfRefinersMaxC"));
		double refinerInletConsistencyMaxC=CommonUtil.checkDouble(request.getParameter("refinerInletConsistencyMaxC"));
		double machineChestConsistencyMaxC=CommonUtil.checkDouble(request.getParameter("machineChestConsistencyMaxC"));
		double stockFlowMaxC=CommonUtil.checkDouble(request.getParameter("stockFlowMaxC"));
		double sweetnerFlowMaxC=CommonUtil.checkDouble(request.getParameter("sweetnerFlowMaxC"));
		double brokeMaxC=CommonUtil.checkDouble(request.getParameter("brokeMaxC"));
		double wetStrengthMaxC=CommonUtil.checkDouble(request.getParameter("wetStrengthMaxC"));
		
		
		//New Field 
		double afterDryerDrawMinC=CommonUtil.checkDouble(request.getParameter("afterDryerDrawMinC"));
		double afterDryerDraw=CommonUtil.checkDouble(request.getParameter("afterDryerDraw"));
		double afterDryerDrawMaxC=CommonUtil.checkDouble(request.getParameter("afterDryerDrawMaxC"));
		
		String horizontalSliceDcsMinC=CommonUtil.checkNull(request.getParameter("horizontalSliceDcsMinC"));
		String horizontalSliceDcs=CommonUtil.checkNull(request.getParameter("horizontalSliceDcs"));
		String horizontalSliceDcsMaxC=CommonUtil.checkNull(request.getParameter("horizontalSliceDcsMaxC"));
		
		String verticalSliceDcsMinC=CommonUtil.checkNull(request.getParameter("verticalSliceDcsMinC"));
		String verticalSliceDcs=CommonUtil.checkNull(request.getParameter("verticalSliceDcs"));
		String verticalSliceDcsMaxC=CommonUtil.checkNull(request.getParameter("verticalSliceDcsMaxC"));

		//New Field Added Here By Roshan Tailor
		double sprloadingfrontMinC=CommonUtil.checkDouble(request.getParameter("sprloadingfrontMinC"));
		double sprloadingbackMinC=CommonUtil.checkDouble(request.getParameter("sprloadingbackMinC"));
		double pickuprollvacuumMinC=CommonUtil.checkDouble(request.getParameter("pickuprollvacuumMinC"));
		double uhleboxvacuumMinC=CommonUtil.checkDouble(request.getParameter("uhleboxvacuumMinC"));
		double sprvacuumMinC=CommonUtil.checkDouble(request.getParameter("sprvacuumMinC"));
		double primaryscreenrejectflowMinC=CommonUtil.checkDouble(request.getParameter("primaryscreenrejectflowMinC"));
		double blendchestcyMinC=CommonUtil.checkDouble(request.getParameter("blendchestcyMinC"));
		double refiner1powerMinC=CommonUtil.checkDouble(request.getParameter("refiner1powerMinC"));
		double refiner2powerMinC=CommonUtil.checkDouble(request.getParameter("refiner2powerMinC"));
		double refiner1inletcyMinC=CommonUtil.checkDouble(request.getParameter("refiner1inletcyMinC"));
		double refiner2inletcyMinC=CommonUtil.checkDouble(request.getParameter("refiner2inletcyMinC"));
		double basisweighttargetMinC=CommonUtil.checkDouble(request.getParameter("basisweighttargetMinC"));
		double moisturetargetMinC=CommonUtil.checkDouble(request.getParameter("moisturetargetMinC"));
		double yankeemapflowMinC=CommonUtil.checkDouble(request.getParameter("yankeemapflowMinC"));
		double machinechestpumpspeedMinC=CommonUtil.checkDouble(request.getParameter("machinechestpumpspeedMinC"));
		
		
		double sprloadingfront=CommonUtil.checkDouble(request.getParameter("sprloadingfront"));
		double sprloadingback=CommonUtil.checkDouble(request.getParameter("sprloadingback"));
		double pickuprollvacuum=CommonUtil.checkDouble(request.getParameter("pickuprollvacuum"));
		double uhleboxvacuum=CommonUtil.checkDouble(request.getParameter("uhleboxvacuum"));
		double sprvacuum=CommonUtil.checkDouble(request.getParameter("sprvacuum"));
		double primaryscreenrejectflow=CommonUtil.checkDouble(request.getParameter("primaryscreenrejectflow"));
		double blendchestcy=CommonUtil.checkDouble(request.getParameter("blendchestcy"));
		double refiner1power=CommonUtil.checkDouble(request.getParameter("refiner1power"));
		double refiner2power=CommonUtil.checkDouble(request.getParameter("refiner2power"));
		double refiner1inletcy=CommonUtil.checkDouble(request.getParameter("refiner1inletcy"));
		double refiner2inletcy=CommonUtil.checkDouble(request.getParameter("refiner2inletcy"));
		double basisweighttarget=CommonUtil.checkDouble(request.getParameter("basisweighttarget"));
		double moisturetarget=CommonUtil.checkDouble(request.getParameter("moisturetarget"));
		double yankeemapflow=CommonUtil.checkDouble(request.getParameter("yankeemapflow"));
		double machinechestpumpspeed=CommonUtil.checkDouble(request.getParameter("machinechestpumpspeed"));
		
		
		double sprloadingfrontMaxC=CommonUtil.checkDouble(request.getParameter("sprloadingfrontMaxC"));
		double sprloadingbackMaxC=CommonUtil.checkDouble(request.getParameter("sprloadingbackMaxC"));
		double pickuprollvacuumMaxC=CommonUtil.checkDouble(request.getParameter("pickuprollvacuumMaxC"));
		double uhleboxvacuumMaxC=CommonUtil.checkDouble(request.getParameter("uhleboxvacuumMaxC"));
		double sprvacuumMaxC=CommonUtil.checkDouble(request.getParameter("sprvacuumMaxC"));
		double primaryscreenrejectflowMaxC=CommonUtil.checkDouble(request.getParameter("primaryscreenrejectflowMaxC"));
		double blendchestcyMaxC=CommonUtil.checkDouble(request.getParameter("blendchestcyMaxC"));
		double refiner1powerMaxC=CommonUtil.checkDouble(request.getParameter("refiner1powerMaxC"));
		double refiner2powerMaxC=CommonUtil.checkDouble(request.getParameter("refiner2powerMaxC"));
		double refiner1inletcyMaxC=CommonUtil.checkDouble(request.getParameter("refiner1inletcyMaxC"));
		double refiner2inletcyMaxC=CommonUtil.checkDouble(request.getParameter("refiner2inletcyMaxC"));
		
		double basisweighttargetMaxC=CommonUtil.checkDouble(request.getParameter("basisweighttargetMaxC"));
		double moisturetargetMaxC=CommonUtil.checkDouble(request.getParameter("moisturetargetMaxC"));
		double yankeemapflowMaxC=CommonUtil.checkDouble(request.getParameter("yankeemapflowMaxC"));
		double machinechestpumpspeedMaxC=CommonUtil.checkDouble(request.getParameter("machinechestpumpspeedMaxC"));
		
		
		
		
		int id=CommonUtil.checkInt(request.getParameter("id"));
		
		Map<String, Object> map=new HashMap<String, Object>();
		
		if(gradeCode!=null && !gradeCode.trim().equals("")){
			
			
			
			
			CenterlineGrade centerlineGrade=new CenterlineGrade();
			
			centerlineGrade.setGrade(gradeCode);
			
			centerlineGrade.setYankeeSpeed(yankeeSpeed);
			centerlineGrade.setQcsBasisWtTarget(qcsBasisWtTarget);
			centerlineGrade.setReelMoisture(reelMoisture);
			centerlineGrade.setCrepe(crepe);
			centerlineGrade.setYankeeSteam(yankeeSteam);
			centerlineGrade.setYankeeRelease(yankeeRelease);
			centerlineGrade.setYankeeAdesive(yankeeAdesive);
			centerlineGrade.setJetWireRatio(jetWireRatio);
			centerlineGrade.setFanPumpFlowRate(fanPumpFlowRate);
			centerlineGrade.setAfterDryerSteam(afterDryerSteam);
			centerlineGrade.setSprLoading(sprLoading);
			centerlineGrade.setFeltPassivator(feltPassivator);
			centerlineGrade.setSprayboomPressure(sprayboomPressure);
			centerlineGrade.setSprayboomTemparature(sprayboomTemparature);
			centerlineGrade.setWefanSpeed(wefanSpeed);
			centerlineGrade.setDefanSpeed(defanSpeed);
			centerlineGrade.setMakeUpAirDamper(makeUpAirDamper);
			centerlineGrade.setExhaustDamper(exhaustDamper);
			centerlineGrade.setExhaustFanSpeed(exhaustFanSpeed);
			centerlineGrade.setWehoodTemperature(wehoodTemperature);
			centerlineGrade.setDehoodTemperature(dehoodTemperature);
			centerlineGrade.setYankeeAP(yankeeAP);
			centerlineGrade.setAfterDryerAP(afterDryerAP);
			centerlineGrade.setSecArmLoading(secArmLoading);
			centerlineGrade.setReelOffset(reelOffset);
			centerlineGrade.setUhleBoxNorthValve(uhleBoxNorthValve);
			centerlineGrade.setUhleBoxSouthValve(uhleBoxSouthValve);
			centerlineGrade.setFaltBox1VacuumValve(faltBox1VacuumValve);
			centerlineGrade.setFaltBox2VacuumValve(faltBox2VacuumValve);
			centerlineGrade.setFaltBox4VacuumValve(faltBox4VacuumValve);
			centerlineGrade.setFanPumpSpeed(fanPumpSpeed);
			centerlineGrade.setTotalHead(totalHead);
			centerlineGrade.setHeadboxLevel(headboxLevel);
			centerlineGrade.setHorizontalSlice(horizontalSlice);
			centerlineGrade.setVerticalSlice(verticalSlice);
			centerlineGrade.setSelectifierRejectFlow1(selectifierRejectFlow1);
			centerlineGrade.setSelectifierRejectFlow2(selectifierRejectFlow2);
			centerlineGrade.setSecScreenCycleTime(secScreenCycleTime);
			centerlineGrade.setLowDensityCycleTime(lowDensityCycleTime);
			centerlineGrade.setRefinersEnergy(refinersEnergy);
			centerlineGrade.setNumberOfRefiners(numberOfRefiners);
			centerlineGrade.setRefinerInletConsistency(refinerInletConsistency);
			centerlineGrade.setMachineChestConsistency(machineChestConsistency);
			centerlineGrade.setStockFlow(stockFlow);
			centerlineGrade.setSweetnerFlow(sweetnerFlow);
			centerlineGrade.setBroke(broke);
			centerlineGrade.setWetStrength(wetStrength);

			centerlineGrade.setYankeeSpeedMinC(yankeeSpeedMinC);
			centerlineGrade.setQcsBasisWtTargetMinC(qcsBasisWtTargetMinC);
			centerlineGrade.setReelMoistureMinC(reelMoistureMinC);
			centerlineGrade.setCrepeMinC(crepeMinC);
			centerlineGrade.setYankeeSteamMinC(yankeeSteamMinC);
			centerlineGrade.setYankeeReleaseMinC(yankeeReleaseMinC);
			centerlineGrade.setYankeeAdesiveMinC(yankeeAdesiveMinC);
			centerlineGrade.setJetWireRatioMinC(jetWireRatioMinC);
			centerlineGrade.setFanPumpFlowRateMinC(fanPumpFlowRateMinC);
			centerlineGrade.setAfterDryerSteamMinC(afterDryerSteamMinC);
			centerlineGrade.setSprLoadingMinC(sprLoadingMinC);
			centerlineGrade.setFeltPassivatorMinC(feltPassivatorMinC);
			centerlineGrade.setSprayboomPressureMinC(sprayboomPressureMinC);
			centerlineGrade.setSprayboomTemparatureMinC(sprayboomTemparatureMinC);
			centerlineGrade.setWefanSpeedMinC(wefanSpeedMinC);
			centerlineGrade.setDefanSpeedMinC(defanSpeedMinC);
			centerlineGrade.setMakeUpAirDamperMinC(makeUpAirDamperMinC);
			centerlineGrade.setExhaustDamperMinC(exhaustDamperMinC);
			centerlineGrade.setExhaustFanSpeedMinC(exhaustFanSpeedMinC);
			centerlineGrade.setWehoodTemperatureMinC(wehoodTemperatureMinC);
			centerlineGrade.setDehoodTemperatureMinC(dehoodTemperatureMinC);
			centerlineGrade.setYankeeAPMinC(yankeeAPMinC);
			centerlineGrade.setAfterDryerAPMinC(afterDryerAPMinC);
			centerlineGrade.setSecArmLoadingMinC(secArmLoadingMinC);
			centerlineGrade.setReelOffsetMinC(reelOffsetMinC);
			centerlineGrade.setUhleBoxNorthValveMinC(uhleBoxNorthValveMinC);
			centerlineGrade.setUhleBoxSouthValveMinC(uhleBoxSouthValveMinC);
			centerlineGrade.setFaltBox1VacuumValveMinC(faltBox1VacuumValveMinC);
			centerlineGrade.setFaltBox2VacuumValveMinC(faltBox2VacuumValveMinC);
			centerlineGrade.setFaltBox4VacuumValveMinC(faltBox4VacuumValveMinC);
			centerlineGrade.setFanPumpSpeedMinC(fanPumpSpeedMinC);
			centerlineGrade.setTotalHeadMinC(totalHeadMinC);
			centerlineGrade.setHeadboxLevelMinC(headboxLevelMinC);
			centerlineGrade.setHorizontalSliceMinC(horizontalSliceMinC);
			centerlineGrade.setVerticalSliceMinC(verticalSliceMinC);
			centerlineGrade.setSelectifierRejectFlow1MinC(selectifierRejectFlow1MinC);
			centerlineGrade.setSelectifierRejectFlow2MinC(selectifierRejectFlow2MinC);
			centerlineGrade.setSecScreenCycleTimeMinC(secScreenCycleTimeMinC);
			centerlineGrade.setLowDensityCycleTimeMinC(lowDensityCycleTimeMinC);
			centerlineGrade.setRefinersEnergyMinC(refinersEnergyMinC);
			centerlineGrade.setNumberOfRefinersMinC(numberOfRefinersMinC);
			centerlineGrade.setRefinerInletConsistencyMinC(refinerInletConsistencyMinC);
			centerlineGrade.setMachineChestConsistencyMinC(machineChestConsistencyMinC);
			centerlineGrade.setStockFlowMinC(stockFlowMinC);
			centerlineGrade.setSweetnerFlowMinC(sweetnerFlowMinC);
			centerlineGrade.setBrokeMinC(brokeMinC);
			centerlineGrade.setWetStrengthMinC(wetStrengthMinC);

			centerlineGrade.setYankeeSpeedMaxC(yankeeSpeedMaxC);
			centerlineGrade.setQcsBasisWtTargetMaxC(qcsBasisWtTargetMaxC);
			centerlineGrade.setReelMoistureMaxC(reelMoistureMaxC);
			centerlineGrade.setCrepeMaxC(crepeMaxC);
			centerlineGrade.setYankeeSteamMaxC(yankeeSteamMaxC);
			centerlineGrade.setYankeeReleaseMaxC(yankeeReleaseMaxC);
			centerlineGrade.setYankeeAdesiveMaxC(yankeeAdesiveMaxC);
			centerlineGrade.setJetWireRatioMaxC(jetWireRatioMaxC);
			centerlineGrade.setFanPumpFlowRateMaxC(fanPumpFlowRateMaxC);
			centerlineGrade.setAfterDryerSteamMaxC(afterDryerSteamMaxC);
			centerlineGrade.setSprLoadingMaxC(sprLoadingMaxC);
			centerlineGrade.setFeltPassivatorMaxC(feltPassivatorMaxC);
			centerlineGrade.setSprayboomPressureMaxC(sprayboomPressureMaxC);
			centerlineGrade.setSprayboomTemparatureMaxC(sprayboomTemparatureMaxC);
			centerlineGrade.setWefanSpeedMaxC(wefanSpeedMaxC);
			centerlineGrade.setDefanSpeedMaxC(defanSpeedMaxC);
			centerlineGrade.setMakeUpAirDamperMaxC(makeUpAirDamperMaxC);
			centerlineGrade.setExhaustDamperMaxC(exhaustDamperMaxC);
			centerlineGrade.setExhaustFanSpeedMaxC(exhaustFanSpeedMaxC);
			centerlineGrade.setWehoodTemperatureMaxC(wehoodTemperatureMaxC);
			centerlineGrade.setDehoodTemperatureMaxC(dehoodTemperatureMaxC);
			centerlineGrade.setYankeeAPMaxC(yankeeAPMaxC);
			centerlineGrade.setAfterDryerAPMaxC(afterDryerAPMaxC);
			centerlineGrade.setSecArmLoadingMaxC(secArmLoadingMaxC);
			centerlineGrade.setReelOffsetMaxC(reelOffsetMaxC);
			centerlineGrade.setUhleBoxNorthValveMaxC(uhleBoxNorthValveMaxC);
			centerlineGrade.setUhleBoxSouthValveMaxC(uhleBoxSouthValveMaxC);
			centerlineGrade.setFaltBox1VacuumValveMaxC(faltBox1VacuumValveMaxC);
			centerlineGrade.setFaltBox2VacuumValveMaxC(faltBox2VacuumValveMaxC);
			centerlineGrade.setFaltBox4VacuumValveMaxC(faltBox4VacuumValveMaxC);
			centerlineGrade.setFanPumpSpeedMaxC(fanPumpSpeedMaxC);
			centerlineGrade.setTotalHeadMaxC(totalHeadMaxC);
			centerlineGrade.setHeadboxLevelMaxC(headboxLevelMaxC);
			centerlineGrade.setHorizontalSliceMaxC(horizontalSliceMaxC);
			centerlineGrade.setVerticalSliceMaxC(verticalSliceMaxC);
			centerlineGrade.setSelectifierRejectFlow1MaxC(selectifierRejectFlow1MaxC);
			centerlineGrade.setSelectifierRejectFlow2MaxC(selectifierRejectFlow2MaxC);
			centerlineGrade.setSecScreenCycleTimeMaxC(secScreenCycleTimeMaxC);
			centerlineGrade.setLowDensityCycleTimeMaxC(lowDensityCycleTimeMaxC);
			centerlineGrade.setRefinersEnergyMaxC(refinersEnergyMaxC);
			centerlineGrade.setNumberOfRefinersMaxC(numberOfRefinersMaxC);
			centerlineGrade.setRefinerInletConsistencyMaxC(refinerInletConsistencyMaxC);
			centerlineGrade.setMachineChestConsistencyMaxC(machineChestConsistencyMaxC);
			centerlineGrade.setStockFlowMaxC(stockFlowMaxC);
			centerlineGrade.setSweetnerFlowMaxC(sweetnerFlowMaxC);
			centerlineGrade.setBrokeMaxC(brokeMaxC);
			centerlineGrade.setWetStrengthMaxC(wetStrengthMaxC);

			centerlineGrade.setIssueDate(issueDate);
			centerlineGrade.setRevision(revision);

			
			//New Field
			centerlineGrade.setAfterDryerDrawMinC(afterDryerDrawMinC);
			centerlineGrade.setAfterDryerDraw(afterDryerDraw);
			centerlineGrade.setAfterDryerDrawMaxC(afterDryerDrawMaxC);
			
			centerlineGrade.setHorizontalSliceDcsMinC(horizontalSliceDcsMinC);
			centerlineGrade.setHorizontalSliceDcs(horizontalSliceDcs);
			centerlineGrade.setHorizontalSliceDcsMaxC(horizontalSliceDcsMaxC);
			
			centerlineGrade.setVerticalSliceDcsMaxC(verticalSliceDcsMaxC);
			centerlineGrade.setVerticalSliceDcs(verticalSliceDcs);
			centerlineGrade.setVerticalSliceDcsMinC(verticalSliceDcsMinC);
			
			//New Field Added Here By Roshan Tailor
			
			centerlineGrade.setSprloadingfrontMinC(sprloadingfrontMinC);
			centerlineGrade.setSprloadingfront(sprloadingfront);
			centerlineGrade.setSprloadingfrontMaxC(sprloadingfrontMaxC);

			centerlineGrade.setSprloadingbackMinC(sprloadingbackMinC);
			centerlineGrade.setSprloadingback(sprloadingback);
			centerlineGrade.setSprloadingbackMaxC(sprloadingbackMaxC);

			centerlineGrade.setPickuprollvacuumMinC(pickuprollvacuumMinC);
			centerlineGrade.setPickuprollvacuum(pickuprollvacuum);
			centerlineGrade.setPickuprollvacuumMaxC(pickuprollvacuumMaxC);

			centerlineGrade.setUhleboxvacuumMinC(uhleboxvacuumMinC);
			centerlineGrade.setUhleboxvacuum(uhleboxvacuum);
			centerlineGrade.setUhleboxvacuumMaxC(uhleboxvacuumMaxC);

			centerlineGrade.setSprvacuumMinC(sprvacuumMinC);
			centerlineGrade.setSprvacuum(sprvacuum);
			centerlineGrade.setSprvacuumMaxC(sprvacuumMaxC);

			centerlineGrade.setPrimaryscreenrejectflowMinC(primaryscreenrejectflowMinC);
			centerlineGrade.setPrimaryscreenrejectflow(primaryscreenrejectflow);
			centerlineGrade.setPrimaryscreenrejectflowMaxC(primaryscreenrejectflowMaxC);

			centerlineGrade.setBlendchestcyMinC(blendchestcyMinC);
			centerlineGrade.setBlendchestcy(blendchestcy);
			centerlineGrade.setBlendchestcyMaxC(blendchestcyMaxC);

			centerlineGrade.setRefiner1powerMinC(refiner1powerMinC);
			centerlineGrade.setRefiner1power(refiner1power);
			centerlineGrade.setRefiner1powerMaxC(refiner1powerMaxC);

			centerlineGrade.setRefiner2powerMinC(refiner2powerMinC);
			centerlineGrade.setRefiner2power(refiner2power);
			centerlineGrade.setRefiner2powerMaxC(refiner2powerMaxC);

			centerlineGrade.setRefiner1inletcyMinC(refiner1inletcyMinC);
			centerlineGrade.setRefiner1inletcy(refiner1inletcy);
			centerlineGrade.setRefiner1inletcyMaxC(refiner1inletcyMaxC);

			centerlineGrade.setRefiner2inletcyMinC(refiner2inletcyMinC);
			centerlineGrade.setRefiner2inletcy(refiner2inletcy);
			centerlineGrade.setRefiner2inletcyMaxC(refiner2inletcyMaxC);
			
			
			centerlineGrade.setBasisweighttargetMinC(basisweighttargetMinC);
			centerlineGrade.setBasisweighttarget(basisweighttarget);
			centerlineGrade.setBasisweighttargetMaxC(basisweighttargetMaxC);
			
			
			centerlineGrade.setMoisturetargetMinC(moisturetargetMinC);
			centerlineGrade.setMoisturetarget(moisturetarget);
			centerlineGrade.setMoisturetargetMaxC(moisturetargetMaxC);
			
			
			centerlineGrade.setYankeemapflowMinC(yankeemapflowMinC);
			centerlineGrade.setYankeemapflow(yankeemapflow);
			centerlineGrade.setYankeemapflowMaxC(yankeemapflowMaxC);
			
			centerlineGrade.setMachinechestpumpspeedMinC(machinechestpumpspeedMinC);
			centerlineGrade.setMachinechestpumpspeed(machinechestpumpspeed);
			centerlineGrade.setMachinechestpumpspeedMaxC(machinechestpumpspeedMaxC);
			

			

			//New Field Ends Here
			
			centerlineGrade.setId(id);
			try{
				if(id!=0){
					centerlineServicepm5.update(centerlineGrade);
					map.put("status", true);
					map.put("status", true);
					map.put("id", id);
				}else{
					map.put("id", centerlineServicepm5.save(centerlineGrade));
					map.put("status", true);
					
				}
			}catch(Exception e){
				e.printStackTrace();
				map.put("status", false);
				map.put("error", "Internal server error..");
			}
			
			
		}else{
			map.put("status", false);
			map.put("error", "Please enter grade code.");
		}
		
		response.setContentType("application/json");
		
		
		response.getWriter().write(new Gson().toJson(map));		
		
		
	}
}

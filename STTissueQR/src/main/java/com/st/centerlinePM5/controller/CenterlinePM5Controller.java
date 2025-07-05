/**
 *Mar 10, 2018
 *CenterlinePM5Controller.java
 * TODO
 *com.st.centerlinePM5.controller
 *CenterlinePM5Controller.java
 *Roshan Lal Tailor
 */
package com.st.centerlinePM5.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.gson.Gson;
import com.st.centerline.controller.CenterlineController;
import com.st.centerline.model.CenterlineData;
import com.st.centerline.model.CenterlineGrade;
import com.st.centerlinePM5.service.CenterlineServicePM5;
import com.st.common.CommonUtil;

/**
 * @author roshan
 *
 */

@Controller
@RequestMapping(value = "/pm5centerline")
public class CenterlinePM5Controller {

	private static final Logger logger=LoggerFactory.getLogger(CenterlineController.class);
	@Autowired
	private CenterlineServicePM5 centerlineServicePM5;

	private SimpleDateFormat dateFormat1 = new SimpleDateFormat("MM-dd-yyyy");

	// private SimpleDateFormat dateFormat2=new SimpleDateFormat("MM/dd/yyyy");


	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public String newCenterlineData(Model model) {

		model.addAttribute("clgrades", centerlineServicePM5.getCenterlineGrades());
		model.addAttribute("date", dateFormat1.format(new Date()));

		return "PM5/centerlineNew";
	}
	
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String editCenterlineData(@PathVariable("id")int id,Model model) {

		model.addAttribute("clgrades", centerlineServicePM5.getCenterlineGrades());
		model.addAttribute("date", dateFormat1.format(new Date()));
		model.addAttribute("id", id);
		
		return "PM5/centerlineEdit";
	}

	@RequestMapping(value="/print/{id}")
	public String centerlineGradePrint(@PathVariable("id")String id,
			Model model) {

		CenterlineData centerlineData=centerlineServicePM5.getCenterlineData(Integer.parseInt(id));
		centerlineData.setFdate(dateFormat1.format(centerlineData.getDate()==null?new Date():centerlineData.getDate()));
		
		CenterlineGrade centerlineGrade=centerlineServicePM5.getCenterlineGrade(centerlineData.getGradeId());
		centerlineGrade.setFissueDate(centerlineGrade.getIssueDate()==null?"":dateFormat1.format(centerlineGrade.getIssueDate()));
		
		model.addAttribute("cgrade", centerlineGrade);
		model.addAttribute("cdata", centerlineData);
		
		return "PM5/centerlineGradePrint";
		
	}
	@RequestMapping(value="/print/grade/{id}")
	public String centerlineGradePrintGrade(@PathVariable("id")int id,
			Model model) {

		
		CenterlineGrade centerlineGrade=centerlineServicePM5.getCenterlineGrade(id);
		centerlineGrade.setFissueDate(centerlineGrade.getIssueDate()==null?"":dateFormat1.format(centerlineGrade.getIssueDate()));
		
		model.addAttribute("cgrade", centerlineGrade);
		model.addAttribute("cdata", null);
		
		return "PM5/centerlineGradePrint";
		
	}
	/*@RequestMapping(value = "/getencodedgrade", method = RequestMethod.POST)
	public void getCenterlineGradeEncoded(HttpServletRequest request,
			HttpServletResponse response, Model model) throws IOException {

		String grade = request.getParameter("grade");


		response.setContentType("application/json");

		response.getWriter().write(new Gson().toJson(CommonEncodeDecode.encode(grade)));

	}*/
	
	@RequestMapping(value = "/getclgrade", method = RequestMethod.POST)
	public void getCenterlineGrade(HttpServletRequest request,
			HttpServletResponse response, Model model) throws IOException {

		int grade = CommonUtil.checkInt(request.getParameter("grade"));

		CenterlineGrade centerlineGrade = null;

		if (grade!=0) {
			centerlineGrade = centerlineServicePM5.getCenterlineGrade(grade);
			if(centerlineGrade.getIssueDate()!=null){
				centerlineGrade.setFissueDate(dateFormat1.format(centerlineGrade.getIssueDate()));
			}else{
				centerlineGrade.setFissueDate("");
			}
		}

		response.setContentType("application/json");

		response.getWriter().write(new Gson().toJson(centerlineGrade));

	}

	@RequestMapping(value = "/savecldata", method = RequestMethod.POST)
	public void saveCenterline(HttpServletRequest request,
			HttpServletResponse response,
			Model model) throws IOException {
		
		CenterlineData centerlineData=new CenterlineData();
		
		int id=CommonUtil.checkInt(request.getParameter("id"));
		centerlineData.setId(id);
		
		int grade=CommonUtil.checkInt(request.getParameter("grade"));
		centerlineData.setGradeId(grade);
		
		String crew=CommonUtil.checkNull(request.getParameter("crew"));
		centerlineData.setCrew(crew);
		
		String shift=CommonUtil.checkNull(request.getParameter("shift"));
		centerlineData.setShift(shift);

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
		
		
		double sprloadingfront=CommonUtil.checkDouble(request.getParameter("SPRLoadingFront"));
		double sprloadingback=CommonUtil.checkDouble(request.getParameter("SPRLoadingBack"));
		double pickuprollvacuum=CommonUtil.checkDouble(request.getParameter("PickUpRollVacuum"));
		double uhleboxvacuum=CommonUtil.checkDouble(request.getParameter("UhleBoxVacuum"));
		double sprvacuum=CommonUtil.checkDouble(request.getParameter("SPRVacuum"));
		double primaryscreenrejectflow=CommonUtil.checkDouble(request.getParameter("PrimaryScreenRejectFlow"));
		double blendchestcy=CommonUtil.checkDouble(request.getParameter("BlendChestCy"));
		double refiner1power=CommonUtil.checkDouble(request.getParameter("Refiner1Power"));
		double refiner2power=CommonUtil.checkDouble(request.getParameter("Refiner2Power"));
		double refiner1inletcy=CommonUtil.checkDouble(request.getParameter("Refiner1InletCy"));
		double refiner2inletcy=CommonUtil.checkDouble(request.getParameter("Refiner2InletCy"));
		
		double basisweighttarget=CommonUtil.checkDouble(request.getParameter("basisweighttarget"));
		double moisturetarget=CommonUtil.checkDouble(request.getParameter("moisturetarget"));
		double yankeemapflow=CommonUtil.checkDouble(request.getParameter("yankeemapflow"));
		double machinechestpumpspeed=CommonUtil.checkDouble(request.getParameter("machinechestpumpspeed"));
		
		
		
		Date date=CommonUtil.checkDate(request.getParameter("date"),dateFormat1);
		Date issueDate=null;
		try{
			issueDate=CommonUtil.checkDate(request.getParameter("issueDate"),dateFormat1);
		}catch(Exception e){
			logger.error("Invalid parsing date...");
		}
		
		String revision=CommonUtil.checkNull(request.getParameter("revision"));
		String noteSecA=CommonUtil.checkNull(request.getParameter("noteSecA"));
		String noteSecB=CommonUtil.checkNull(request.getParameter("noteSecB"));
		
		
		
		//New Field
		double afterDryerDraw=CommonUtil.checkDouble(request.getParameter("afterDryerDraw"));
		String horizontalSliceDcs=CommonUtil.checkNull(request.getParameter("horizontalSliceDcs"));
		String verticalSliceDcs=CommonUtil.checkNull(request.getParameter("verticalSliceDcs"));
		
		
		centerlineData.setYankeeSpeed(yankeeSpeed);
		centerlineData.setQcsBasisWtTarget(qcsBasisWtTarget);
		centerlineData.setReelMoisture(reelMoisture);
		centerlineData.setCrepe(crepe);
		centerlineData.setYankeeSteam(yankeeSteam);
		centerlineData.setYankeeRelease(yankeeRelease);
		centerlineData.setYankeeAdesive(yankeeAdesive);
		centerlineData.setJetWireRatio(jetWireRatio);
		centerlineData.setFanPumpFlowRate(fanPumpFlowRate);
		centerlineData.setAfterDryerSteam(afterDryerSteam);
		centerlineData.setSprLoading(sprLoading);
		centerlineData.setFeltPassivator(feltPassivator);
		centerlineData.setSprayboomPressure(sprayboomPressure);
		centerlineData.setSprayboomTemparature(sprayboomTemparature);
		centerlineData.setWefanSpeed(wefanSpeed);
		centerlineData.setDefanSpeed(defanSpeed);
		centerlineData.setMakeUpAirDamper(makeUpAirDamper);
		centerlineData.setExhaustDamper(exhaustDamper);
		centerlineData.setExhaustFanSpeed(exhaustFanSpeed);
		centerlineData.setWehoodTemperature(wehoodTemperature);
		centerlineData.setDehoodTemperature(dehoodTemperature);
		centerlineData.setYankeeAP(yankeeAP);
		centerlineData.setAfterDryerAP(afterDryerAP);
		centerlineData.setSecArmLoading(secArmLoading);
		centerlineData.setReelOffset(reelOffset);
		centerlineData.setUhleBoxNorthValve(uhleBoxNorthValve);
		centerlineData.setUhleBoxSouthValve(uhleBoxSouthValve);
		centerlineData.setFaltBox1VacuumValve(faltBox1VacuumValve);
		centerlineData.setFaltBox2VacuumValve(faltBox2VacuumValve);
		centerlineData.setFaltBox4VacuumValve(faltBox4VacuumValve);
		centerlineData.setFanPumpSpeed(fanPumpSpeed);
		centerlineData.setTotalHead(totalHead);
		centerlineData.setHeadboxLevel(headboxLevel);
		centerlineData.setHorizontalSlice(horizontalSlice);
		centerlineData.setVerticalSlice(verticalSlice);
		centerlineData.setSelectifierRejectFlow1(selectifierRejectFlow1);
		centerlineData.setSelectifierRejectFlow2(selectifierRejectFlow2);
		centerlineData.setSecScreenCycleTime(secScreenCycleTime);
		centerlineData.setLowDensityCycleTime(lowDensityCycleTime);
		centerlineData.setRefinersEnergy(refinersEnergy);
		centerlineData.setNumberOfRefiners(numberOfRefiners);
		centerlineData.setRefinerInletConsistency(refinerInletConsistency);
		centerlineData.setMachineChestConsistency(machineChestConsistency);
		centerlineData.setStockFlow(stockFlow);
		centerlineData.setSweetnerFlow(sweetnerFlow);
		centerlineData.setBroke(broke);
		centerlineData.setWetStrength(wetStrength);
		centerlineData.setDate(date);
		centerlineData.setIssueDate(issueDate);
		centerlineData.setRevision(revision);
		centerlineData.setNoteSecA(noteSecA);
		centerlineData.setNoteSecB(noteSecB);
		
		//New 
		centerlineData.setAfterDryerDraw(afterDryerDraw);
		centerlineData.setHorizontalSliceDcs(horizontalSliceDcs);
		centerlineData.setVerticalSliceDcs(verticalSliceDcs);
		
		//New Fields RLT
		centerlineData.setSprloadingfront(sprloadingfront);
		centerlineData.setSprloadingback(sprloadingback);
		centerlineData.setPickuprollvacuum(pickuprollvacuum);
		centerlineData.setUhleboxvacuum(uhleboxvacuum);
		centerlineData.setSprvacuum(sprvacuum);
		centerlineData.setPrimaryscreenrejectflow(primaryscreenrejectflow);
		centerlineData.setBlendchestcy(blendchestcy);
		centerlineData.setRefiner1power(refiner1power);
		centerlineData.setRefiner2power(refiner2power);
		centerlineData.setRefiner1inletcy(refiner1inletcy);
		centerlineData.setRefiner2inletcy(refiner2inletcy);
		
		centerlineData.setBasisweighttarget(basisweighttarget);
		centerlineData.setMoisturetarget(moisturetarget);
		centerlineData.setYankeemapflow(yankeemapflow);
		centerlineData.setMachinechestpumpspeed(machinechestpumpspeed);
		
		Map<String, Object> map=new HashMap<String, Object>();
		try {
			if(centerlineData.getId()==0){
				int genId=centerlineServicePM5.save(centerlineData);
				
				//System.out.println("ID="+genId);
				map.put("status", true);
				map.put("id", genId);
				map.put("message", "Data saved successfully.");
			}else{
				centerlineServicePM5.update(centerlineData);
				//System.out.println("UID="+centerlineData.getId());
				map.put("status", true);
				map.put("id", centerlineData.getId());
				map.put("message", "Data updated successfully.");
			}
		} catch (Exception e) {
			//e.printStackTrace();
			System.err.println(e.getMessage());
			map.put("status", false);
			map.put("message", "Error in saving data.");
		}

		response.setContentType("application/json");

		response.getWriter().write(new Gson().toJson(map));
		
	}

	@RequestMapping(value = "/getcurrentgrade", method = RequestMethod.POST)
	public void getCureentGrade(HttpServletRequest request,
			HttpServletResponse response, Model model) throws IOException {

		List<Map<String, Object>> map=new ArrayList<>();
		
		try {
			map=centerlineServicePM5.getCurrentRunningGrade();
			
			for (Map<String, Object> map2 : map) {
				Timestamp date=(Timestamp)map2.get("DATE");
				map2.put("DATE", dateFormat1.format(date));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		response.setContentType("application/json");

		response.getWriter().write(new Gson().toJson(map));

	}

	@RequestMapping(value = "/loaddata", method = RequestMethod.POST)
	public void loadData(HttpServletRequest request,
			HttpServletResponse response, Model model) throws IOException {

		int id=CommonUtil.checkInt(request.getParameter("id"));

		Map<String, Object> map=new HashMap<>();
		if(id!=0){
			CenterlineData centerlineData=centerlineServicePM5.getCenterlineData(id);
		
			centerlineData.setFdate(dateFormat1.format(centerlineData.getDate()==null?new Date():centerlineData.getDate()));
			centerlineData.setFissueDate(dateFormat1.format(centerlineData.getIssueDate()==null?new Date():centerlineData.getIssueDate()));
			
			CenterlineGrade centerlineGrade=centerlineServicePM5.getCenterlineGrade(centerlineData.getGradeId());
			
		
			
			centerlineGrade.setFissueDate(centerlineGrade.getIssueDate()==null?"":dateFormat1.format(centerlineGrade.getIssueDate()));
			
			
			map.put("cldata", centerlineData);
			map.put("clgrade", centerlineGrade);
		}
		
		response.setContentType("application/json");

		response.getWriter().write(new Gson().toJson(map));
	}

	@RequestMapping(value = "/deletecldata", method = RequestMethod.POST)
	public void deleteClData(HttpServletRequest request,
			HttpServletResponse response, Model model) throws IOException {

		int id=CommonUtil.checkInt(request.getParameter("id"));

		Map<String, Object> map=new HashMap<>();
		if(id!=0){
			centerlineServicePM5.delete(id);
		
			map.put("status", true);
		}
		
		response.setContentType("application/json");

		response.getWriter().write(new Gson().toJson(map));
	}
}

/**
 * 
 */
package com.st.frpproduction.controller;

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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.st.common.CommonUtil;
import com.st.common.FrpCommon;
import com.st.frppressquality.service.FrpPressQualityService;
import com.st.frpproduction.model.FrpProdcution;
import com.st.frpproduction.service.FrpProdcutionService;


/**
 * @author sbora
 *
 */
@Controller
@RequestMapping(value="/frpproduction")
public class FrpProdcutionController {
	private SimpleDateFormat dateFormat1=new SimpleDateFormat("MM-dd-yyyy");
	

	@Autowired
	private FrpProdcutionService frpProdcutionService;
	
	@Autowired
	private FrpPressQualityService frpPressQualityService;
	
	
	@RequestMapping(value="/new",method=RequestMethod.GET)
	public String entryPage(Model model) {
		model.addAttribute("ptypes", FrpCommon.getProductionType());
		model.addAttribute("grades", FrpCommon.getProductionGradeType());
		//Code Starts From Here Done By Roshan Tailor Date :- 03/18/2015
		//Code Modified By Roshan Tailor Date 03/21/2015
		model.addAttribute("astar", FrpCommon.getProductionAStarValue());
		model.addAttribute("bstar", FrpCommon.getProductionBStarValue());
		model.addAttribute("pumpruning",FrpCommon.getClarifierunderflowpumpruning());
		//Code Ends Here Done By Roshan Tailor
		model.addAttribute("date", dateFormat1.format(new Date()));
		model.addAttribute("editFlag", false);
		
		return "frpProductionNew";
	}
	
	@RequestMapping(value="/edit/{id}",method=RequestMethod.GET)
	public String edit(@PathVariable("id")int id,
			HttpServletRequest request,
			Model model) {
		
		model.addAttribute("editFlag", true);
		
		model.addAttribute("ptypes", FrpCommon.getProductionType());
		model.addAttribute("grades", FrpCommon.getProductionGradeType());
		
		model.addAttribute("backParam", request.getQueryString());
		
		FrpProdcution frpProdcution=frpProdcutionService.getFrpProdcution(id);
		
		FrpProdcution mtdFrpProdcution=frpProdcutionService.getMTDFrpProdcution(frpProdcution.getDate(), frpProdcution.getProdType());
		
		double dcsYield=0;
		double trackerYield=0;
		if(mtdFrpProdcution.getDcsWPFeedADSTTotal()!=0){
			dcsYield=mtdFrpProdcution.getTotalProdADSTTotal()/mtdFrpProdcution.getDcsWPFeedADSTTotal();
		}
		if(mtdFrpProdcution.getTrackerWPfeedTotal()!=0){
			trackerYield=mtdFrpProdcution.getTotalProdADSTTotal()/mtdFrpProdcution.getTrackerWPfeedTotal();
		}
		
		
		model.addAttribute("dcsYield", CommonUtil.round(dcsYield*100, 2));
		model.addAttribute("trackerYield",  CommonUtil.round(trackerYield*100, 2));
		
		
		model.addAttribute("date", dateFormat1.format(frpProdcution.getDate()));
		
		model.addAttribute("frpProdcution", frpProdcution);
		
		return "frpProductionNew";
	}
	
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	public void delete(
			HttpServletRequest request,
			HttpServletResponse response,
			Model model) throws IOException {
			
		int id=CommonUtil.checkInt(request.getParameter("id"));

		Map<String, Object> map=new HashMap<>();
		try {
			frpProdcutionService.delete(id);
			map.put("status", true);
		} catch (Exception e) {
			map.put("status", false);
			map.put("error", "Server error message:-"+e.getMessage());
		}
		
		response.setContentType("application/json");
		response.getWriter().write(new Gson().toJson(map));
		
		
	}
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public void save(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		
		Map<String, Object> map=new HashMap<>();
		
		
		try {
			int id=CommonUtil.checkInt(request.getParameter("id"));
			Date date=CommonUtil.checkDate(request.getParameter("date"),dateFormat1);
			
			if(date==null){
				throw new Exception("Server error message:- Invalid date.");
			}
			String prodType=CommonUtil.checkNull(request.getParameter("prodType"));
			if(prodType==null || prodType.equals("")){
				throw new Exception("Server error message:- Select production type.");
			}
			
			double hdStorage=CommonUtil.checkDouble(request.getParameter("hdStorage"));
			double dcsWPFeedADST=CommonUtil.checkDouble(request.getParameter("dcsWPFeedADST"));
			double primaryPressADST=CommonUtil.checkDouble(request.getParameter("primaryPressADST"));
			double wetLapProdADST=CommonUtil.checkDouble(request.getParameter("wetLapProdADST"));
			double totalProdADST=CommonUtil.checkDouble(request.getParameter("totalProdADST"));
			double trackerWPfeed=CommonUtil.checkDouble(request.getParameter("trackerWPfeed"));
			double yieldDcs=CommonUtil.checkDouble(request.getParameter("yieldDcs"));
			double yieldTracker=CommonUtil.checkDouble(request.getParameter("yieldTracker"));
			double freshWater=CommonUtil.checkDouble(request.getParameter("freshWater"));
			double mrMwlAndSwl=CommonUtil.checkDouble(request.getParameter("mrMwlAndSwl"));
			double mrSowAndCbs=CommonUtil.checkDouble(request.getParameter("mrSowAndCbs"));
			double mrDlk=CommonUtil.checkDouble(request.getParameter("mrDlk"));
			double mrOcc=CommonUtil.checkDouble(request.getParameter("mrOcc"));
			double mrWhiteGrades=CommonUtil.checkDouble(request.getParameter("mrWhiteGrades"));
			double mrGroundwood=CommonUtil.checkDouble(request.getParameter("mrGroundwood"));
			double mrOther=CommonUtil.checkDouble(request.getParameter("mrOther"));
			double wpmMwl=CommonUtil.checkDouble(request.getParameter("wpmMwl"));
			double wpmPrintMix=CommonUtil.checkDouble(request.getParameter("wpmPrintMix"));
			double wpmSow=CommonUtil.checkDouble(request.getParameter("wpmSow"));
			double wpmCbs=CommonUtil.checkDouble(request.getParameter("wpmCbs"));
			double wpmSowAndCbs=CommonUtil.checkDouble(request.getParameter("wpmSowAndCbs"));
			double wpmCtdGrwd=CommonUtil.checkDouble(request.getParameter("wpmCtdGrwd"));
			double wpmSwl=CommonUtil.checkDouble(request.getParameter("wpmSwl"));
			double wpmOcc=CommonUtil.checkDouble(request.getParameter("wpmOcc"));
			double wpmNewsNewsblank=CommonUtil.checkDouble(request.getParameter("wpmNewsNewsblank"));
			double wpmDlk=CommonUtil.checkDouble(request.getParameter("wpmDlk"));
			double wpmOther=CommonUtil.checkDouble(request.getParameter("wpmOther"));
			double wpmTotal=CommonUtil.checkDouble(request.getParameter("wpmTotal"));
			String targetBrightness=CommonUtil.checkNull(request.getParameter("targetBrightness"));
			double dailyAvg=CommonUtil.checkDouble(request.getParameter("dailyAvg"));
			String pmTargetBrite=CommonUtil.checkNull(request.getParameter("pmTargetBrite"));
			String pmAvgBrite=CommonUtil.checkNull(request.getParameter("pmAvgBrite"));
			String comments=CommonUtil.checkNull(request.getParameter("comments"));
			
			String grade=CommonUtil.checkNull(request.getParameter("grade"));
			
			//new fields
			double wpMailUndeliverable=CommonUtil.checkDouble(request.getParameter("wpMailUndeliverable"));
			double freshWater2=CommonUtil.checkDouble(request.getParameter("freshWater2"));
			
//			Code Starts From Here Done By Roshan Tailor Date :- 03/17/2015
			//new fields	
			//Code Modified By Roshan TAilor Date:- 03/24/2015
			//String clarifierunderflowpumpruningYN=CommonUtil.checkNull(request.getParameter("clarifierunderflowpumpruningYN"));
			//double sludgepressconsistency=CommonUtil.checkDouble(request.getParameter("sludgepressconsistency"));
			//double screwpressconsistency=CommonUtil.checkDouble(request.getParameter("screwpressconsistency"));
			//double mixratiobrightness=CommonUtil.checkDouble(request.getParameter("mixratiobrightness"));
//			double eric=CommonUtil.checkDouble(request.getParameter("eric"));
//			String astar=CommonUtil.checkNull(request.getParameter("astar"));
//			String bstar=CommonUtil.checkNull(request.getParameter("bstar"));
//			Code Ends Here Done By Roshan Tailor
	
			
			FrpProdcution frpProdcution=new FrpProdcution();
			frpProdcution.setId(id);
			frpProdcution.setDate(date);
			frpProdcution.setHdStorage(hdStorage);
			frpProdcution.setDcsWPFeedADST(dcsWPFeedADST);
			frpProdcution.setPrimaryPressADST(primaryPressADST);
			frpProdcution.setWetLapProdADST(wetLapProdADST);
			frpProdcution.setTotalProdADST(totalProdADST);
			frpProdcution.setTrackerWPfeed(trackerWPfeed);
			frpProdcution.setYieldDcs(yieldDcs);
			frpProdcution.setYieldTracker(yieldTracker);
			frpProdcution.setFreshWater(freshWater);
			frpProdcution.setMrMwlAndSwl(mrMwlAndSwl);
			frpProdcution.setMrSowAndCbs(mrSowAndCbs);
			frpProdcution.setMrDlk(mrDlk);
			frpProdcution.setMrOcc(mrOcc);
			frpProdcution.setMrWhiteGrades(mrWhiteGrades);
			frpProdcution.setMrGroundwood(mrGroundwood);
			frpProdcution.setMrOther(mrOther);
			frpProdcution.setWpmMwl(wpmMwl);
			frpProdcution.setWpmPrintMix(wpmPrintMix);
			frpProdcution.setWpmSow(wpmSow);
			frpProdcution.setWpmCbs(wpmCbs);
			frpProdcution.setWpmSowAndCbs(wpmSowAndCbs);
			frpProdcution.setWpmCtdGrwd(wpmCtdGrwd);
			frpProdcution.setWpmSwl(wpmSwl);
			frpProdcution.setWpmOcc(wpmOcc);
			frpProdcution.setWpmNewsNewsblank(wpmNewsNewsblank);
			frpProdcution.setWpmDlk(wpmDlk);
			frpProdcution.setWpmOther(wpmOther);
			frpProdcution.setWpmTotal(wpmTotal);
			frpProdcution.setTargetBrightness(targetBrightness);
			frpProdcution.setDailyAvg(dailyAvg);
			frpProdcution.setPmTargetBrite(pmTargetBrite);
			frpProdcution.setPmAvgBrite(pmAvgBrite);
			frpProdcution.setComments(comments);
			frpProdcution.setProdType(prodType);
			frpProdcution.setGrade(grade);

			frpProdcution.setWpMailUndeliverable(wpMailUndeliverable);
			frpProdcution.setFreshWater2(freshWater2);
			
//			Code Starts From Here done BY Roshan Tailor Date :- 03/17/2015 MM/DD/YYYY
			//frpProdcution.setClarifierunderflowpumpruningYN(clarifierunderflowpumpruningYN);
			//frpProdcution.setSludgepressconsistency(sludgepressconsistency);
			//frpProdcution.setScrewpressconsistency(screwpressconsistency);
			//frpProdcution.setMixratiobrightness(mixratiobrightness);
//			frpProdcution.setEric(eric);
//			frpProdcution.setAstar(astar);
//			frpProdcution.setBstar(bstar);
//			Code Ends Here Done By Roshan Tailor
			
			try {
				
				FrpProdcution oldFrpProdcution=frpProdcutionService.getFrpProdcutionLast(frpProdcution.getDate());
				FrpProdcution mtdFrpProdcution=frpProdcutionService.getMTDFrpProdcution(frpProdcution.getDate(), frpProdcution.getProdType());
				double dcsYield=0;
				double trackerYield=0;
				if(mtdFrpProdcution.getDcsWPFeedADSTTotal()!=0){
					dcsYield=mtdFrpProdcution.getTotalProdADSTTotal()/mtdFrpProdcution.getDcsWPFeedADSTTotal();
				}
				if(mtdFrpProdcution.getTrackerWPfeedTotal()!=0){
					trackerYield=mtdFrpProdcution.getTotalProdADSTTotal()/mtdFrpProdcution.getTrackerWPfeedTotal();
				}
				
				
				map.put("dcsYield", CommonUtil.round(dcsYield*100, 2));
				map.put("trackerYield",  CommonUtil.round(trackerYield*100, 2));
				
				if(oldFrpProdcution!=null){
					if(frpProdcution.getFreshWater()==0){
						//frpProdcution.setFreshWater(oldFrpProdcution.getFreshWater());
						map.put("freshWater", oldFrpProdcution.getFreshWater());
						map.put("freshWater2", oldFrpProdcution.getFreshWater2());
					}else{
						map.put("freshWater", frpProdcution.getFreshWater());
						map.put("freshWater2", frpProdcution.getFreshWater2());
					}
				}else{
					map.put("freshWater", frpProdcution.getFreshWater());
					map.put("freshWater2", frpProdcution.getFreshWater2());
				}
				
				if(frpProdcution.getId()==0){
					int key=frpProdcutionService.save(frpProdcution);
					map.put("status", true);
					map.put("id", key);
					map.put("message", "Data saved successfully.");
				}else{
					frpProdcutionService.update(frpProdcution);
					map.put("status", true);
					map.put("id", frpProdcution.getId());
					map.put("message", "Data updated successfully.");
				}
			} catch (Exception e) {
				///System.out.println("OK"+e.getCause());
				throw new Exception("Error in saving data into database.", e);
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
			map.put("status", false);
			map.put("error", e.getMessage());
			
		}
		
		response.setContentType("application/json");

		response.getWriter().write(new Gson().toJson(map));
		


	}
	
//	Code Starts From Here Done By Roshan Tailor Date :- 03/18/2015
	@RequestMapping(value="/pressqualityinfo",method=RequestMethod.POST)
	public @ResponseBody Map<String, Object> getPressQualityInfo(@RequestParam("date")String date) {
		Date d=CommonUtil.checkDate(date, new SimpleDateFormat("MM-dd-yyyy"));
		Map<String, Object> map=frpPressQualityService.getPressQualityInfo(d);
		return map;
	}
//	Code Ends Here Done By Roshan Tailor
}

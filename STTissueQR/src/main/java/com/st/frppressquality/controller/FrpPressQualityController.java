/**
 * 
 */
package com.st.frppressquality.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.st.common.CommonUtil;
import com.st.common.FrpCommon;
import com.st.frppressquality.model.FrpPressQuality;
import com.st.frppressquality.model.SludgeHauling;
import com.st.frppressquality.model.StickiesData;
import com.st.frppressquality.service.FrpPressQualityService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * @author sbora frppressqualityreport
 *
 */
@Controller
@RequestMapping(value="/frppressquality")
public class FrpPressQualityController {
	
	@Autowired
	private FrpPressQualityService frpPressQualityService;
	
	private SimpleDateFormat dateFormat1=new SimpleDateFormat("MM-dd-yyyy");
	private SimpleDateFormat timeFormat=new SimpleDateFormat("HH:mm");
	private SimpleDateFormat dateFormat=new SimpleDateFormat("MM-dd-yyyy");

	
	@RequestMapping(value="/new",method=RequestMethod.GET)
	public String main(Model model){
		
		model.addAttribute("qtypes", FrpCommon.getPressQualityType());
		
		return "frpPressQualityNew";
	}
	
	@SuppressWarnings("null")
	@RequestMapping(value="/new/{type}",method=RequestMethod.GET)
	public String pageType(@PathVariable("type")String type,
			Model model){
		
		Date sdate=CommonUtil.checkDate(dateFormat1.format(new Date()), dateFormat1);
		Date edate=sdate;
		
		model.addAttribute("qtypes", FrpCommon.getPressQualityType());
		model.addAttribute("type", type);
		model.addAttribute("grades", FrpCommon.getPressQualityGrade());
		model.addAttribute("ynflags", FrpCommon.getYN());
		model.addAttribute("date", dateFormat1.format(new Date()));
		//Code Starts From Here Done By Roshan Tailor Date :- 03/24/2015
		model.addAttribute("astar", FrpCommon.getProductionAStarValue());
		model.addAttribute("bstar", FrpCommon.getProductionBStarValue());
		//Code Ends Here Done By Roshan Tailor
		//Code Starts From Here Done By Roshan Tailor Date :- 03/21/2015
		if(type.equalsIgnoreCase("TPQ") ||(type.equalsIgnoreCase("TPQ2"))||(type.equalsIgnoreCase("SECPRESSQ")) || type.equalsIgnoreCase("SPC") || type.equalsIgnoreCase("WL")|| type.equalsIgnoreCase("IPSC")){
			List<FrpPressQuality> qualities=frpPressQualityService.getFrpPressQualities(sdate,edate,type);
			model.addAttribute("qualities", qualities);
		//Code Ends Here Done By Roshan Tailor	
			}else if(type.equalsIgnoreCase("SH")){
			List<SludgeHauling> sludgeHaulings=frpPressQualityService.getSludgeHauling(sdate,edate);
			if(sludgeHaulings.size()==0){
				sludgeHaulings.add(new SludgeHauling());
			}
			model.addAttribute("sludgeHaulings", sludgeHaulings);
		}else if(type.equalsIgnoreCase("ST")){
			List<StickiesData> StickiesData=frpPressQualityService.getStickiesData(sdate,edate);
			if(StickiesData==null)
				StickiesData.add(new StickiesData());
			else if(StickiesData.size()==0)
				StickiesData.add(new StickiesData());
			
			model.addAttribute("qualities", StickiesData);
			
		}
		
		
		return "frpPressQualityNew";
	}
	
	@RequestMapping(value="/edit/{id}/{type}",method=RequestMethod.GET)
	public String edit(@PathVariable("id")int id,
			@PathVariable("type")String type,
			HttpServletRequest request,
			Model model){
		
		String backParam=request.getQueryString();
		

		model.addAttribute("qtypes", FrpCommon.getPressQualityType());
		model.addAttribute("type", type);
		model.addAttribute("grades", FrpCommon.getPressQualityGrade());
		model.addAttribute("ynflags", FrpCommon.getYN());
//		Code Starts From Here Done By Roshan Tailor Date :- 03/27/2015 MM/DD/YYYY
		model.addAttribute("astar", FrpCommon.getProductionAStarValue());
		model.addAttribute("bstar", FrpCommon.getProductionBStarValue());
//		Code Ends Here Done By Roshan Tailor
		
		
		if(type.equalsIgnoreCase("TPQ") || type.equalsIgnoreCase("TPQ2") || type.equalsIgnoreCase("SECPRESSQ") || type.equalsIgnoreCase("SPC") || type.equalsIgnoreCase("WL")|| type.equalsIgnoreCase("IPSC")){
			FrpPressQuality frpPressQuality=frpPressQualityService.getFrpPressQuality(id);
			model.addAttribute("date", dateFormat1.format(frpPressQuality.getDate()));
			
			List<FrpPressQuality> qualities=new ArrayList<>();
			if(frpPressQuality!=null){
				qualities.add(frpPressQuality);
			}
			model.addAttribute("qualities", qualities);
		}else if(type.equalsIgnoreCase("SH")){
			SludgeHauling sludgeHauling=frpPressQualityService.getSludgeHauling(id);
			List<SludgeHauling> sludgeHaulings=new ArrayList<>();
			if(sludgeHauling!=null){
				sludgeHaulings.add(sludgeHauling);
			}
			
			model.addAttribute("sludgeHaulings", sludgeHaulings);
		}
		
		
		
		
		model.addAttribute("backPram", backParam);
		
		return "frpPressQualityEdit";
	}
	
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public void save(HttpServletRequest request,HttpServletResponse response) throws IOException {
		Map<String, Object> map=new HashMap<String, Object>();
		
		try {
			int id=CommonUtil.checkInt(request.getParameter("id"));
			Date date=CommonUtil.checkDate(request.getParameter("date"),dateFormat1);
			if(date==null){
				throw new Exception("Invalid date.");
			}
			
			String time=CommonUtil.checkNull(request.getParameter("time"));
			if(time!=null && !time.equals("")){
				Date t=CommonUtil.checkDate(time, timeFormat);
				date=CommonUtil.getDateTime(date, t);
			}
			
			
			int lot=CommonUtil.checkInt(request.getParameter("lot"));
			String initials=CommonUtil.checkNull(request.getParameter("initials"));
//			Code Starts From Here Done By Roshan Tailor Date ;- 04/01/015
			double bleachingchemical=CommonUtil.checkDouble(request.getParameter("bleachingchemical"));
//			Code ends Here Done By Roshan Tailor
			String grade=CommonUtil.checkNull(request.getParameter("grade"));

			double  brightness=CommonUtil.checkDouble(request.getParameter("brightness"));
//			Code Starts From Here Done By Roshan Tailor Date :- 03/30/2015
			double  lvalue=CommonUtil.checkDouble(request.getParameter("lvalue"));
			double  avalue=CommonUtil.checkDouble(request.getParameter("avalue"));
			double  bvalue=CommonUtil.checkDouble(request.getParameter("bvalue"));
//			Code Ends Here Doen By Roshan TAilor 
			double  dirt=CommonUtil.checkDouble(request.getParameter("dirt"));
			double  stickies=CommonUtil.checkDouble(request.getParameter("stickies"));
			double  consistency=CommonUtil.checkDouble(request.getParameter("consistency"));
			double  ash=CommonUtil.checkDouble(request.getParameter("ash"));

			String cuRunning=CommonUtil.checkNull(request.getParameter("cuRunning"));
			String comments=CommonUtil.checkNull(request.getParameter("comments"));
			String qualityType=CommonUtil.checkNull(request.getParameter("qualityType"));
			
			String line=CommonUtil.checkNull(request.getParameter("line"));
			
			double  freeness=CommonUtil.checkDouble(request.getParameter("freeness"));
			
//			Code Starts From Here Done By Roshan Tailor Date :- 03/24/2015   MM/DD/YYYY
			double eric=CommonUtil.checkDouble(request.getParameter("eric"));
			String astar=CommonUtil.checkNull(request.getParameter("astar"));
			String bstar=CommonUtil.checkNull(request.getParameter("bstar"));
			String comment=CommonUtil.checkNull(request.getParameter("comments"));
//			Code Ends Here Done By Roshan Tailor
			FrpPressQuality frpPressQuality=new FrpPressQuality();
			frpPressQuality.setId(id);
			frpPressQuality.setDate(date);
			frpPressQuality.setLot(lot);
			frpPressQuality.setInitials(initials);
//			Code Starts From Here Done By Roshan Tailor Date ;- 04/01/2015
			frpPressQuality.setBleachingchemical(bleachingchemical);
//			Code Ends Here Done By Roshan Tailor 
			frpPressQuality.setGrade(grade);
			frpPressQuality.setBrightness(brightness);
//			Code Starts From Here Done By Roshan Tailor Date :- 03/30/2015
			frpPressQuality.setAvalue(avalue);
			frpPressQuality.setLvalue(lvalue);
			frpPressQuality.setBvalue(bvalue);
//			Code Ends Here Done By Roshan Tailor
			frpPressQuality.setDirt(dirt);
			frpPressQuality.setStickies(stickies);
			frpPressQuality.setConsistency(consistency);
			frpPressQuality.setAsh(ash);
			frpPressQuality.setCuRunning(cuRunning);
			frpPressQuality.setComments(comments);
			frpPressQuality.setQualityType(qualityType);
			frpPressQuality.setLine(line);
			frpPressQuality.setFreeness(freeness);
//			Code Starts From Here Done By Roshan Tailor Date :-03/4/2015
			frpPressQuality.setEric(eric);
			frpPressQuality.setAstar(astar);
			frpPressQuality.setBstar(bstar);
			frpPressQuality.setComments(comment);
//			Code Ends Here Done By Roshan Tailor
//			System.out.println("L Value"+lvalue);
//			System.out.println("A Value"+avalue);
//			System.out.println("B Value"+bvalue);
			if(qualityType.equalsIgnoreCase("WL")){
				if(frpPressQualityService.isLotExist(frpPressQuality)){
					map.put("ERLOT", "OK");
					throw new Exception("Lot number already exist.");
				}
			}
			
			try {
				if(frpPressQuality.getId()==0){
					//Insert
					int key=frpPressQualityService.save(frpPressQuality);
					map.put("status", true);
					map.put("id", key);
					map.put("message", "Data saved successfully.");
					
				}else{
					frpPressQualityService.update(frpPressQuality);
					map.put("status", true);
					map.put("id", frpPressQuality.getId());
					map.put("message", "Data updated successfully.");
					//Update
				}
			} catch (Exception e) {
				throw new Exception("Error in saving data", e);
			}
			
		} catch (Exception e) {
		//	e.printStackTrace();
			map.put("status", false);
			map.put("error", e.getMessage());
		}
		
		response.setContentType("application/json");
		response.getWriter().write(new Gson().toJson(map));
	}
	
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	public void delete(HttpServletRequest request,HttpServletResponse response) throws IOException {
		int id=CommonUtil.checkInt(request.getParameter("id"));
		
		Map<String, Object> map=new HashMap<String, Object>();
		
		try {
			frpPressQualityService.delete(id);
			map.put("status", true);
		} catch (Exception e) {
			map.put("status", false);
			map.put("error", "Server error...");
			
		}
		
		
		response.setContentType("application/json");
		response.getWriter().write(new Gson().toJson(map));
		
	}
	
	@RequestMapping(value="/deleteStickiedata",method=RequestMethod.POST)
	public void deleteStickiedata(HttpServletRequest request,HttpServletResponse response) throws IOException {
		int id=CommonUtil.checkInt(request.getParameter("id"));
		
		Map<String, Object> map=new HashMap<String, Object>();
		
		try {
			frpPressQualityService.deleteStickiedata(id);
			map.put("status", true);
		} catch (Exception e) {
			map.put("status", false);
			map.put("error", "Server error...");
			
		}
		
		
		response.setContentType("application/json");
		response.getWriter().write(new Gson().toJson(map));
		
	}
	
	@RequestMapping(value="/savesludgehauling",method=RequestMethod.POST)
	public @ResponseBody Map<String, Object> saveSlugHauling(HttpServletRequest request){
		Map<String, Object> map=new HashMap<String, Object>();
		
		try {
			SludgeHauling sludgeHauling=new SludgeHauling();
			
			sludgeHauling.setId(CommonUtil.checkInt(request.getParameter("id")));
			sludgeHauling.setDate(CommonUtil.checkDate(request.getParameter("date"), dateFormat1));
			sludgeHauling.setGrade(CommonUtil.checkNull(request.getParameter("grade")));
			sludgeHauling.setSludgeHauled(CommonUtil.checkDouble(request.getParameter("sludgeHauled")));
			sludgeHauling.setSludgeConsistency(CommonUtil.checkDouble(request.getParameter("sludgeConsistency")));
			sludgeHauling.setRejectsBwHauled(CommonUtil.checkDouble(request.getParameter("rejectsBwHauled")));
			sludgeHauling.setRejectsBwConsistency(CommonUtil.checkDouble(request.getParameter("rejectsBwConsistency")));
			sludgeHauling.setFrpSludgePressRunning(CommonUtil.checkNull(request.getParameter("frpSludgePressRunning")));
			sludgeHauling.setFrpScrewPressRunning(CommonUtil.checkNull(request.getParameter("frpScrewPressRunning")));
			
			//Code Starts From Here Doen By Roshan Tailor Date :- 04/12/2018
			sludgeHauling.setEffluentConsistency(CommonUtil.checkDouble(request.getParameter("effluentConsistency")));
			sludgeHauling.setCoddischarge(CommonUtil.checkDouble(request.getParameter("coddischarge")));
			//Code Ends Here Done By Roshan Tailor Date ;- 04/12/2018
			int id=frpPressQualityService.saveOrUpdate(sludgeHauling);
			map.put("status", true);
			map.put("id", id);
			
			
			if(sludgeHauling.getId()>0){
				map.put("message", "Data updated successfully.");	
			}else{
				map.put("message", "Data saved successfully.");
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
			map.put("status", false);
			map.put("error", e.getMessage());
		}
		
		return map;
		
	}
	
	/*
	 * Code Starts From Here Doen By kishor vaishnav for Stickies data in frp
	 * quality drop down Date :- 25/12/2019
	 */
	@RequestMapping(value="/savesstickies",method=RequestMethod.POST)
	public void StickiesData(HttpServletRequest request,HttpServletResponse response) throws Exception {
		
		Map<String, Object> map=new HashMap<String, Object>();
		try {
			Date date=CommonUtil.checkDate(request.getParameter("date"),dateFormat1);
			int id=CommonUtil.checkInt(request.getParameter("id"));
			StickiesData StickiesData=new StickiesData();
			StickiesData.setId(id);			
			StickiesData.setDate(date);
			List<StickiesData> StickiesDatas=frpPressQualityService.getStickiesDataById(id);
			for (StickiesData obj : StickiesDatas) {
				if(obj.getId()==id)
					StickiesData=obj;
				StickiesData.setId(obj.getId());			
				StickiesData.setDate(obj.getDate());
			}			
				
			if(date==null){
				throw new Exception("Invalid date.");
			}
			
			String ttimeA=CommonUtil.checkNull(request.getParameter("ttimeA"));
			String ttimeAnew = null;
			if(ttimeA!=null && !ttimeA.equals("")){
				Date t=CommonUtil.checkDate(ttimeA, timeFormat);
				 ttimeAnew= timeFormat.format(t);
				
			}
			if(StickiesData.getTtimeA()==null||StickiesData.getTtimeA().isEmpty()||!CommonUtil.checkNull(request.getParameter("ttimeA")).isEmpty())
				StickiesData.setTtimeA(ttimeAnew);
			if(StickiesData.getTinitialsA()==null||StickiesData.getTinitialsA().isEmpty()||!CommonUtil.checkNull(request.getParameter("tinitialsA")).isEmpty())
			StickiesData.setTinitialsA(CommonUtil.checkNull(request.getParameter("tinitialsA")));
			if(StickiesData.getTcountA()==null||StickiesData.getTcountA().isEmpty())
			StickiesData.setTcountA(CommonUtil.checkNull(request.getParameter("tcountA")));
			if(StickiesData.getTtotalareaA()==null||StickiesData.getTtotalareaA().isEmpty()||!CommonUtil.checkNull(request.getParameter("ttotalareaA")).isEmpty())
			StickiesData.setTtotalareaA(CommonUtil.checkNull(request.getParameter("ttotalareaA")));
			if(StickiesData.getTavgareaA()==null||StickiesData.getTavgareaA().isEmpty()||!CommonUtil.checkNull(request.getParameter("tavgareaA")).isEmpty())
			StickiesData.setTavgareaA(CommonUtil.checkNull(request.getParameter("tavgareaA")));
			if(StickiesData.getTppmA()==null||StickiesData.getTppmA().isEmpty()||!CommonUtil.checkNull(request.getParameter("tppmA")).isEmpty())
			StickiesData.setTppmA(CommonUtil.checkNull(request.getParameter("tppmA")));
			if(StickiesData.getTcommentA()==null||StickiesData.getTcommentA().isEmpty()||!CommonUtil.checkNull(request.getParameter("tcommentA")).isEmpty())
			StickiesData.setTcommentA(CommonUtil.checkNull(request.getParameter("tcommentA")));
			
			String retimeA=CommonUtil.checkNull(request.getParameter("retimeA"));
			String retimeAnew = null;
			if(retimeA!=null && !retimeA.equals("")){
				Date t=CommonUtil.checkDate(retimeA, timeFormat);
				retimeAnew= timeFormat.format(t);
				
			}
			if(StickiesData.getRetimeA()==null||StickiesData.getRetimeA().isEmpty()||!CommonUtil.checkNull(request.getParameter("retimeA")).isEmpty())
				StickiesData.setRetimeA(retimeAnew);
			if(StickiesData.getReinitialsA()==null||StickiesData.getReinitialsA().isEmpty()||!CommonUtil.checkNull(request.getParameter("reinitialsA")).isEmpty())
				StickiesData.setReinitialsA(CommonUtil.checkNull(request.getParameter("reinitialsA")));
			if(StickiesData.getRecountA()==null||StickiesData.getRecountA().isEmpty())
				StickiesData.setRecountA(CommonUtil.checkNull(request.getParameter("recountA")));
			if(StickiesData.getRetotalareaA()==null||StickiesData.getRetotalareaA().isEmpty()||!CommonUtil.checkNull(request.getParameter("retotalareaA")).isEmpty())
				StickiesData.setRetotalareaA(CommonUtil.checkNull(request.getParameter("retotalareaA")));
			if(StickiesData.getReavgareaA()==null||StickiesData.getReavgareaA().isEmpty()||!CommonUtil.checkNull(request.getParameter("reavgareaA")).isEmpty())
				StickiesData.setReavgareaA(CommonUtil.checkNull(request.getParameter("reavgareaA")));
			if(StickiesData.getReppmA()==null||StickiesData.getReppmA().isEmpty()||!CommonUtil.checkNull(request.getParameter("reppmA")).isEmpty())
				StickiesData.setReppmA(CommonUtil.checkNull(request.getParameter("reppmA")));
			if(StickiesData.getRecommentA()==null||StickiesData.getRecommentA().isEmpty()||!CommonUtil.checkNull(request.getParameter("recommentA")).isEmpty())
				StickiesData.setRecommentA(CommonUtil.checkNull(request.getParameter("recommentA")));
			
			String patimeA=CommonUtil.checkNull(request.getParameter("patimeA"));
			String patimeAnew = null;
			if(patimeA!=null && !patimeA.equals("")){
				Date t=CommonUtil.checkDate(patimeA, timeFormat);
				patimeAnew= timeFormat.format(t);
				
			}
			if(StickiesData.getPatimeA()==null||StickiesData.getPatimeA().isEmpty()||!CommonUtil.checkNull(request.getParameter("patimeA")).isEmpty())
				StickiesData.setPatimeA(patimeAnew);
			if(StickiesData.getPainitialsA()==null||StickiesData.getPainitialsA().isEmpty()||!CommonUtil.checkNull(request.getParameter("painitialsA")).isEmpty())
			StickiesData.setPainitialsA(CommonUtil.checkNull(request.getParameter("painitialsA")));
			if(StickiesData.getPacountA()==null||StickiesData.getPacountA().isEmpty()||!CommonUtil.checkNull(request.getParameter("pacountA")).isEmpty())
			StickiesData.setPacountA(CommonUtil.checkNull(request.getParameter("pacountA")));
			if(StickiesData.getPatotalareaA()==null||StickiesData.getPatotalareaA().isEmpty()||!CommonUtil.checkNull(request.getParameter("patotalareaA")).isEmpty())
			StickiesData.setPatotalareaA(CommonUtil.checkNull(request.getParameter("patotalareaA")));
			if(StickiesData.getPaavgareaA()==null||StickiesData.getPaavgareaA().isEmpty()||!CommonUtil.checkNull(request.getParameter("paavgareaA")).isEmpty())
			StickiesData.setPaavgareaA(CommonUtil.checkNull(request.getParameter("paavgareaA")));
			if(StickiesData.getPappmA()==null||StickiesData.getPappmA().isEmpty()||!CommonUtil.checkNull(request.getParameter("pappmA")).isEmpty())
			StickiesData.setPappmA(CommonUtil.checkNull(request.getParameter("pappmA")));
			if(StickiesData.getPacommentA()==null||StickiesData.getPacommentA().isEmpty()||!CommonUtil.checkNull(request.getParameter("pacommentA")).isEmpty())
			StickiesData.setPacommentA(CommonUtil.checkNull(request.getParameter("pacommentA")));
			

			String totimeB=CommonUtil.checkNull(request.getParameter("totimeB"));
			String totimeBnew = null;
			if(totimeB!=null && !totimeB.equals("")){
				Date t=CommonUtil.checkDate(totimeB, timeFormat);
				totimeBnew= timeFormat.format(t);
				
			}
			if(StickiesData.getTotimeB()==null||StickiesData.getTotimeB().isEmpty()||!CommonUtil.checkNull(request.getParameter("totimeB")).isEmpty())
			StickiesData.setTotimeB(totimeBnew);
			if(StickiesData.getToinitialsB()==null||StickiesData.getToinitialsB().isEmpty()||!CommonUtil.checkNull(request.getParameter("toinitialsB")).isEmpty())
			StickiesData.setToinitialsB(CommonUtil.checkNull(request.getParameter("toinitialsB")));
			if(StickiesData.getTocountB()==null||StickiesData.getTocountB().isEmpty())
			StickiesData.setTocountB(CommonUtil.checkNull(request.getParameter("tocountB")));
			if(StickiesData.getTototalareaB()==null||StickiesData.getTototalareaB().isEmpty()||!CommonUtil.checkNull(request.getParameter("tototalareaB")).isEmpty())
			StickiesData.setTototalareaB(CommonUtil.checkNull(request.getParameter("tototalareaB")));
			if(StickiesData.getToavgareaB()==null||StickiesData.getToavgareaB().isEmpty()||!CommonUtil.checkNull(request.getParameter("toavgareaB")).isEmpty())
			StickiesData.setToavgareaB(CommonUtil.checkNull(request.getParameter("toavgareaB")));
			if(StickiesData.getToppmB()==null||StickiesData.getToppmB().isEmpty()||!CommonUtil.checkNull(request.getParameter("toppmB")).isEmpty())
			StickiesData.setToppmB(CommonUtil.checkNull(request.getParameter("toppmB")));
			if(StickiesData.getTocommentB()==null||StickiesData.getTocommentB().isEmpty()||!CommonUtil.checkNull(request.getParameter("tocommentB")).isEmpty())
			StickiesData.setTocommentB(CommonUtil.checkNull(request.getParameter("tocommentB")));
			
			
			String retimeB=CommonUtil.checkNull(request.getParameter("retimeB"));
			String retimeBnew = null;
			if(retimeB!=null && !retimeB.equals("")){
				Date t=CommonUtil.checkDate(retimeB, timeFormat);
				retimeBnew= timeFormat.format(t);
				
			}
			if(StickiesData.getRetimeB()==null||StickiesData.getRetimeB().isEmpty()||!CommonUtil.checkNull(request.getParameter("retimeB")).isEmpty())
			StickiesData.setRetimeB(retimeBnew);
			if(StickiesData.getReinitialsB()==null||StickiesData.getReinitialsB().isEmpty()||!CommonUtil.checkNull(request.getParameter("reinitialsB")).isEmpty())
			StickiesData.setReinitialsB(CommonUtil.checkNull(request.getParameter("reinitialsB")));
			if(StickiesData.getRecountB()==null||StickiesData.getRecountB().isEmpty()||!CommonUtil.checkNull(request.getParameter("recountB")).isEmpty())
			StickiesData.setRecountB(CommonUtil.checkNull(request.getParameter("recountB")));
			if(StickiesData.getRetotalareaB()==null||StickiesData.getRetotalareaB().isEmpty()||!CommonUtil.checkNull(request.getParameter("retotalareaB")).isEmpty())
			StickiesData.setRetotalareaB(CommonUtil.checkNull(request.getParameter("retotalareaB")));
			if(StickiesData.getReavgareaB()==null||StickiesData.getReavgareaB().isEmpty()||!CommonUtil.checkNull(request.getParameter("reavgareaB")).isEmpty())
			StickiesData.setReavgareaB(CommonUtil.checkNull(request.getParameter("reavgareaB")));
			if(StickiesData.getReppmB()==null||StickiesData.getReppmB().isEmpty()||!CommonUtil.checkNull(request.getParameter("reppmB")).isEmpty())
			StickiesData.setReppmB(CommonUtil.checkNull(request.getParameter("reppmB")));
			if(StickiesData.getRecommentB()==null||StickiesData.getRecommentB().isEmpty()||!CommonUtil.checkNull(request.getParameter("recommentB")).isEmpty())
			StickiesData.setRecommentB(CommonUtil.checkNull(request.getParameter("recommentB")));
			
			String patimeB=CommonUtil.checkNull(request.getParameter("patimeB"));
			String patimeBnew = null;
			if(patimeB!=null && !patimeB.equals("")){
				Date t=CommonUtil.checkDate(patimeB, timeFormat);
				patimeBnew= timeFormat.format(t);
				
			}
			if(StickiesData.getPatimeB()==null||StickiesData.getPatimeB().isEmpty()||!CommonUtil.checkNull(request.getParameter("patimeB")).isEmpty())
				StickiesData.setPatimeB(patimeBnew);
			if(StickiesData.getPainitialsB()==null||StickiesData.getPainitialsB().isEmpty()||!CommonUtil.checkNull(request.getParameter("painitialsB")).isEmpty())
				StickiesData.setPainitialsB(CommonUtil.checkNull(request.getParameter("painitialsB")));
			if(StickiesData.getPacountB()==null||StickiesData.getPacountB().isEmpty()||!CommonUtil.checkNull(request.getParameter("pacountB")).isEmpty())
				StickiesData.setPacountB(CommonUtil.checkNull(request.getParameter("pacountB")));
			if(StickiesData.getPatotalareaB()==null||StickiesData.getPatotalareaB().isEmpty()||!CommonUtil.checkNull(request.getParameter("patotalareaB")).isEmpty())
				StickiesData.setPatotalareaB(CommonUtil.checkNull(request.getParameter("patotalareaB")));
			if(StickiesData.getPaavgareaB()==null||StickiesData.getPaavgareaB().isEmpty()||!CommonUtil.checkNull(request.getParameter("paavgareaB")).isEmpty())
				StickiesData.setPaavgareaB(CommonUtil.checkNull(request.getParameter("paavgareaB")));
			if(StickiesData.getPappmB()==null||StickiesData.getPappmB().isEmpty()||!CommonUtil.checkNull(request.getParameter("pappmB")).isEmpty())
				StickiesData.setPappmB(CommonUtil.checkNull(request.getParameter("pappmB")));
			if(StickiesData.getPacommentB()==null||StickiesData.getPacommentB().isEmpty()||!CommonUtil.checkNull(request.getParameter("pacommentB")).isEmpty())
				StickiesData.setPacommentB(CommonUtil.checkNull(request.getParameter("pacommentB")));
			
			/***************************  Code Start Here by Sohan Lal  *****************/
			
			String psatimeA=CommonUtil.checkNull(request.getParameter("psatimeA"));
			String psatimeAnew = null;
			if(psatimeA!=null && !psatimeA.equals("")){
				Date t=CommonUtil.checkDate(psatimeA, timeFormat);
				 psatimeAnew= timeFormat.format(t);
				
			}
			if(StickiesData.getPsatimeA()==null||StickiesData.getPsatimeA().isEmpty()||!CommonUtil.checkNull(request.getParameter("psatimeA")).isEmpty())
				StickiesData.setPsatimeA(psatimeAnew);
			if(StickiesData.getPsainitialsA()==null||StickiesData.getPsainitialsA().isEmpty()||!CommonUtil.checkNull(request.getParameter("psainitialsA")).isEmpty())
				StickiesData.setPsainitialsA(CommonUtil.checkNull(request.getParameter("psainitialsA")));
			if(StickiesData.getPsacountA()==null||StickiesData.getPsacountA().isEmpty()||!CommonUtil.checkNull(request.getParameter("psacountA")).isEmpty())
				StickiesData.setPsacountA(CommonUtil.checkNull(request.getParameter("psacountA")));
			if(StickiesData.getPsatotalareaA()==null||StickiesData.getPsatotalareaA().isEmpty()||!CommonUtil.checkNull(request.getParameter("psatotalareaA")).isEmpty())
				StickiesData.setPsatotalareaA(CommonUtil.checkNull(request.getParameter("psatotalareaA")));
			if(StickiesData.getPsaavgareaA()==null||StickiesData.getPsaavgareaA().isEmpty()||!CommonUtil.checkNull(request.getParameter("psaavgareaA")).isEmpty())
				StickiesData.setPsaavgareaA(CommonUtil.checkNull(request.getParameter("psaavgareaA")));
			if(StickiesData.getPsappmA()==null||StickiesData.getPsappmA().isEmpty()||!CommonUtil.checkNull(request.getParameter("psappmA")).isEmpty())
				StickiesData.setPsappmA(CommonUtil.checkNull(request.getParameter("psappmA")));
			if(StickiesData.getEfficiencyA()==null||StickiesData.getEfficiencyA().isEmpty()||!CommonUtil.checkNull(request.getParameter("efficiencyA")).isEmpty())
				StickiesData.setEfficiencyA(CommonUtil.checkNull(request.getParameter("efficiencyA")));
			if(StickiesData.getPsacommentA()==null||StickiesData.getPsacommentA().isEmpty()||!CommonUtil.checkNull(request.getParameter("psacommentA")).isEmpty())
				StickiesData.setPsacommentA(CommonUtil.checkNull(request.getParameter("psacommentA")));
			
			
			String psftimeA=CommonUtil.checkNull(request.getParameter("psftimeA"));
			String psftimeAnew = null;
			if(psftimeA!=null && !psftimeA.equals("")){
				Date t=CommonUtil.checkDate(psftimeA, timeFormat);
				 psftimeAnew= timeFormat.format(t);
				
			}
			if(StickiesData.getPsftimeA()==null||StickiesData.getPsftimeA().isEmpty()||!CommonUtil.checkNull(request.getParameter("psftimeA")).isEmpty())
				StickiesData.setPsftimeA(psftimeAnew);
			if(StickiesData.getPsfinitialsA()==null||StickiesData.getPsfinitialsA().isEmpty()||!CommonUtil.checkNull(request.getParameter("psfinitialsA")).isEmpty())
				StickiesData.setPsfinitialsA(CommonUtil.checkNull(request.getParameter("psfinitialsA")));
			if(StickiesData.getPsfcountA()==null||StickiesData.getPsfcountA().isEmpty()||!CommonUtil.checkNull(request.getParameter("psfcountA")).isEmpty())
				StickiesData.setPsfcountA(CommonUtil.checkNull(request.getParameter("psfcountA")));
			if(StickiesData.getPsftotalareaA()==null||StickiesData.getPsftotalareaA().isEmpty()||!CommonUtil.checkNull(request.getParameter("psftotalareaA")).isEmpty())
				StickiesData.setPsftotalareaA(CommonUtil.checkNull(request.getParameter("psftotalareaA")));
			if(StickiesData.getPsfavgareaA()==null||StickiesData.getPsfavgareaA().isEmpty()||!CommonUtil.checkNull(request.getParameter("psfavgareaA")).isEmpty())
				StickiesData.setPsfavgareaA(CommonUtil.checkNull(request.getParameter("psfavgareaA")));
			if(StickiesData.getPsfppmA()==null||StickiesData.getPsfppmA().isEmpty()||!CommonUtil.checkNull(request.getParameter("psfppmA")).isEmpty())
				StickiesData.setPsfppmA(CommonUtil.checkNull(request.getParameter("psfppmA")));
			if(StickiesData.getPsfcommentA()==null||StickiesData.getPsfcommentA().isEmpty()||!CommonUtil.checkNull(request.getParameter("psfcommentA")).isEmpty())
				StickiesData.setPsfcommentA(CommonUtil.checkNull(request.getParameter("psfcommentA")));
		
			String psftimeB=CommonUtil.checkNull(request.getParameter("psftimeB"));
			String psftimeBnew = null;
			if(psftimeB!=null && !psftimeB.equals("")){
				Date t=CommonUtil.checkDate(psftimeB, timeFormat);
				 psftimeBnew= timeFormat.format(t);
				
			}
			if(StickiesData.getPsftimeB()==null||StickiesData.getPsftimeB().isEmpty()||!CommonUtil.checkNull(request.getParameter("psftimeB")).isEmpty())
				StickiesData.setPsftimeB(psftimeBnew);
			if(StickiesData.getPsfinitialsB()==null||StickiesData.getPsfinitialsB().isEmpty()||!CommonUtil.checkNull(request.getParameter("psfinitialsB")).isEmpty())	
				StickiesData.setPsfinitialsB(CommonUtil.checkNull(request.getParameter("psfinitialsB")));
			if(StickiesData.getPsfcountB()==null||StickiesData.getPsfcountB().isEmpty()||!CommonUtil.checkNull(request.getParameter("psfcountB")).isEmpty())	
				StickiesData.setPsfcountB(CommonUtil.checkNull(request.getParameter("psfcountB")));
			if(StickiesData.getPsftotalareaB()==null||StickiesData.getPsftotalareaB().isEmpty()||!CommonUtil.checkNull(request.getParameter("psftotalareaB")).isEmpty())	
				StickiesData.setPsftotalareaB(CommonUtil.checkNull(request.getParameter("psftotalareaB")));
			if(StickiesData.getPsfavgareaB()==null||StickiesData.getPsfavgareaB().isEmpty())	
				StickiesData.setPsfavgareaB(CommonUtil.checkNull(request.getParameter("psfavgareaB")));
			if(StickiesData.getPsfppmB()==null||StickiesData.getPsfppmB().isEmpty()||!CommonUtil.checkNull(request.getParameter("psfppmB")).isEmpty())	
				StickiesData.setPsfppmB(CommonUtil.checkNull(request.getParameter("psfppmB")));
			if(StickiesData.getPsfcommentB()==null||StickiesData.getPsfcommentB().isEmpty()||!CommonUtil.checkNull(request.getParameter("psfcommentB")).isEmpty())	
				StickiesData.setPsfcommentB(CommonUtil.checkNull(request.getParameter("psfcommentB")));
			
			
			String psatimeB=CommonUtil.checkNull(request.getParameter("psatimeB"));
			String psatimeBnew = null;
			if(psatimeB!=null && !psatimeB.equals("")){
				Date t=CommonUtil.checkDate(psatimeB, timeFormat);
				 psatimeBnew= timeFormat.format(t);
				
			}
			if(StickiesData.getPsatimeB()==null||StickiesData.getPsatimeB().isEmpty()||!CommonUtil.checkNull(request.getParameter("psatimeB")).isEmpty())
				StickiesData.setPsatimeB(psatimeBnew);
			if(StickiesData.getPsainitialsB()==null||StickiesData.getPsainitialsB().isEmpty()||!CommonUtil.checkNull(request.getParameter("psainitialsB")).isEmpty())
				StickiesData.setPsainitialsB(CommonUtil.checkNull(request.getParameter("psainitialsB")));
			if(StickiesData.getPsacountB()==null||StickiesData.getPsacountB().isEmpty()||!CommonUtil.checkNull(request.getParameter("psacountB")).isEmpty())
				StickiesData.setPsacountB(CommonUtil.checkNull(request.getParameter("psacountB")));
			if(StickiesData.getPsatotalareaB()==null||StickiesData.getPsatotalareaB().isEmpty()||!CommonUtil.checkNull(request.getParameter("psatotalareaB")).isEmpty())
				StickiesData.setPsatotalareaB(CommonUtil.checkNull(request.getParameter("psatotalareaB")));
			if(StickiesData.getPsaavgareaB()==null||StickiesData.getPsaavgareaB().isEmpty()||!CommonUtil.checkNull(request.getParameter("psaavgareaB")).isEmpty())
				StickiesData.setPsaavgareaB(CommonUtil.checkNull(request.getParameter("psaavgareaB")));
			if(StickiesData.getPsappmB()==null||StickiesData.getPsappmB().isEmpty()||!CommonUtil.checkNull(request.getParameter("psappmB")).isEmpty())
				StickiesData.setPsappmB(CommonUtil.checkNull(request.getParameter("psappmB")));
			if(StickiesData.getEfficiencyB()==null||StickiesData.getEfficiencyB().isEmpty()||!CommonUtil.checkNull(request.getParameter("efficiencyB")).isEmpty())
				StickiesData.setEfficiencyB(CommonUtil.checkNull(request.getParameter("efficiencyB")));
			if(StickiesData.getPsacommentB()==null||StickiesData.getPsacommentB().isEmpty()||!request.getParameter("psacommentB").isEmpty())
				StickiesData.setPsacommentB(CommonUtil.checkNull(request.getParameter("psacommentB")));
			
			
			try {
				if(StickiesData.getId()==0){
					//Insert
					int key=frpPressQualityService.saveOrUpdate(StickiesData);
					map.put("status", true);
					map.put("id", key);
					map.put("message", "Data saved successfully.");
					map.put("count", 0);
					
				}else{
					frpPressQualityService.update(StickiesData);
					map.put("status", true);
					map.put("id", StickiesData.getId());
					map.put("message", "Data updated successfully.");
					map.put("count", 1);
					//Update
				}
			} catch (Exception e) {
				throw new Exception("Error in saving data", e);
			}
			
		} catch (Exception e) {
		//	e.printStackTrace();
			map.put("status", false);
			map.put("error", e.getMessage());
		}
		
		response.setContentType("application/json");
		response.getWriter().write(new Gson().toJson(map));
		
	}
	
		
	
	
	@RequestMapping(value="/deletesludgehauling",method=RequestMethod.POST)
	public @ResponseBody Map<String, Object> deleteSludgeHauling(HttpServletRequest request,HttpServletResponse response) throws IOException {
		int id=CommonUtil.checkInt(request.getParameter("id"));
		
		Map<String, Object> map=new HashMap<String, Object>();
		
		try {
			frpPressQualityService.deleteSludgeHauling(id);
			map.put("status", true);
		} catch (Exception e) {
			map.put("status", false);
			map.put("error", "Server error...");
			
		}
		return map;
	
		
	}
	@RequestMapping(value="/shbackdatedentry",method=RequestMethod.GET)
	public String shbackdatedentry(Model model){
		
		model.addAttribute("sdate", dateFormat.format(CommonUtil.getFirstDate()));
		model.addAttribute("edate", dateFormat.format(new Date()));
		
		return "frpPressQualityNew_BackDatedEntry";
	}
	
	@RequestMapping(value="/shbackdatedentry/report/{sdate}/{edate}",method=RequestMethod.GET)
	public String ShowDateBetweenData(@PathVariable("sdate")String sdate,@PathVariable("edate")String edate,HttpServletRequest request,HttpServletResponse response,Model model) throws ParseException{
	
	//Date Sdate=CommonUtil.checkDate(sdate, dateFormat);
	///Date Edate=CommonUtil.checkDate(edate, dateFormat);
	
	Date Sdate=CommonUtil.checkDate(sdate, dateFormat);
	Date Edate=CommonUtil.checkDate(edate, dateFormat);
	
	List<SludgeHauling> sludgeHaulings=frpPressQualityService.getSludgeHauling(Sdate,Edate);
	
	model.addAttribute("qtypes", FrpCommon.getPressQualityType());
	model.addAttribute("grades", FrpCommon.getPressQualityGrade());
	model.addAttribute("ynflags", FrpCommon.getYN());
	model.addAttribute("date", dateFormat1.format(new Date()));
	model.addAttribute("astar", FrpCommon.getProductionAStarValue());
	model.addAttribute("bstar", FrpCommon.getProductionBStarValue());
	model.addAttribute("type", "SH");
	model.addAttribute("sludgeHaulings", sludgeHaulings);
	model.addAttribute("sdate", dateFormat.format(Sdate));
	model.addAttribute("edate", dateFormat.format(Edate));
	
	return "frpPressQualityNew_BackDatedEntry";
	}

}

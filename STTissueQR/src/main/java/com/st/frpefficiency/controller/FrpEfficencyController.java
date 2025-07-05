/**
 * 
 */
package com.st.frpefficiency.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.google.gson.Gson;
import com.st.common.CommonUtil;
import com.st.common.FrpCommon;
import com.st.frpefficiency.model.FrpEfficiency;
import com.st.frpefficiency.model.FrpSecondaryCode;
import com.st.frpefficiency.service.FrpEfficiencyCodeService;
import com.st.frpefficiency.service.FrpEfficiencyService;

/**
 * @author sbora
 *
 */
@Controller
@RequestMapping(value="/frpefficiency")
public class FrpEfficencyController {
	
	private static Logger logger=LoggerFactory.getLogger(FrpEfficencyController.class);

	
	@Autowired
	private FrpEfficiencyCodeService frpEfficiencyCodeService;
	@Autowired
	private FrpEfficiencyService frpEfficiencyService;
	
	
	private SimpleDateFormat dateFormat=new SimpleDateFormat("MM-dd-yyyy");
	private SimpleDateFormat timeFormat=new SimpleDateFormat("HH:mm");
	private SimpleDateFormat timeFormatHH=new SimpleDateFormat("HH");
	private SimpleDateFormat timeFormatMM=new SimpleDateFormat("mm");
	
	@RequestMapping(value="/main", method=RequestMethod.GET)
	public String main(Model model) {
		
		model.addAttribute("efficiency", new FrpEfficiency());
		model.addAttribute("grades", FrpCommon.getGrade());
		
		model.addAttribute("codes", frpEfficiencyCodeService.getSecondaryCodes());
		
		return "frpEfficiency";
	}
	
	@RequestMapping(value="/new", method=RequestMethod.GET)
	public String newEntryPage(Model model) {
		
		Date date=CommonUtil.getShiftDate();
		
		Calendar scal=Calendar.getInstance();
		scal.setTime(date);
		scal.set(Calendar.HOUR_OF_DAY, 7);
		scal.set(Calendar.MINUTE, 0);
		scal.set(Calendar.SECOND, 0);
		scal.set(Calendar.MILLISECOND, 0);
		
		FrpEfficiency efficiency=new FrpEfficiency();
		efficiency.setStartDate(scal.getTime());
		
		Calendar ecal=Calendar.getInstance();
		ecal.setTime(date);
		ecal.set(Calendar.HOUR_OF_DAY, 6);
		ecal.set(Calendar.MINUTE, 59);
		ecal.set(Calendar.SECOND, 0);
		ecal.set(Calendar.MILLISECOND, 0);
		ecal.add(Calendar.DATE, 1);
		
		efficiency.setEndDate(ecal.getTime());
		
		List<FrpEfficiency> efficiencies=frpEfficiencyService.getEfficiencies(efficiency);
		model.addAttribute("efficiencies", efficiencies);
		
		model.addAttribute("edate", dateFormat.format(date));
		model.addAttribute("shiftdate", dateFormat.format(date));
		
		model.addAttribute("grades", FrpCommon.getGrade());
		
		model.addAttribute("codes", frpEfficiencyCodeService.getSecondaryCodes());
		
		model.addAttribute("showOldDate", false);
		
		return "frpEfficiencyNew";
	}
	
	@RequestMapping(value="/new/{date}", method=RequestMethod.GET)
	public String backDateEntryPage(@PathVariable("date")String date,
			Model model) {
		
		Date odate=CommonUtil.checkDate(date, dateFormat);
		
		Date sdate=CommonUtil.getShiftDate();
		
		Calendar scal=Calendar.getInstance();
		scal.setTime(odate);
		scal.set(Calendar.HOUR_OF_DAY, 7);
		scal.set(Calendar.MINUTE, 0);
		scal.set(Calendar.SECOND, 0);
		scal.set(Calendar.MILLISECOND, 0);
		
		FrpEfficiency efficiency=new FrpEfficiency();
		efficiency.setStartDate(scal.getTime());
		
		Calendar ecal=Calendar.getInstance();
		ecal.setTime(odate);
		ecal.set(Calendar.HOUR_OF_DAY, 6);
		ecal.set(Calendar.MINUTE, 59);
		ecal.set(Calendar.SECOND, 0);
		ecal.set(Calendar.MILLISECOND, 0);
		ecal.add(Calendar.DATE, 1);
		
		efficiency.setEndDate(ecal.getTime());
		
		List<FrpEfficiency> efficiencies=frpEfficiencyService.getEfficiencies(efficiency);
		model.addAttribute("efficiencies", efficiencies);
		
		model.addAttribute("edate", dateFormat.format(odate));
		model.addAttribute("shiftdate", dateFormat.format(sdate));
		
		model.addAttribute("grades", FrpCommon.getGrade());
		
		model.addAttribute("codes", frpEfficiencyCodeService.getSecondaryCodes());
		model.addAttribute("showOldDate", true);
		model.addAttribute("ndate", dateFormat.format(ecal.getTime()));
		
		return "frpEfficiencyNew";
	}
	
	
	@RequestMapping(value="/edit/{id}", method=RequestMethod.GET)
	public String edit(@PathVariable("id")int id,
			HttpServletRequest request,
			Model model) {
		
		
		
		FrpEfficiency efficiency=frpEfficiencyService.getEfficiency(id);
		efficiency.setFdate(dateFormat.format(efficiency.getDate()));
		efficiency.setFstartTimeHH(timeFormatHH.format(efficiency.getStartTime()));
		efficiency.setFstartTimeMM(timeFormatMM.format(efficiency.getStartTime()));
		
		Calendar scal=Calendar.getInstance();
		scal.setTime(efficiency.getStartTime());
		
		Calendar ecal=Calendar.getInstance();
		ecal.setTime(efficiency.getEndTime());
		
		
		efficiency.setFendTimeHH(CommonUtil.getHoursDuration(scal.getTime(), ecal.getTime())+"");
		efficiency.setFendTimeMM(CommonUtil.getMinutesDuration(scal.getTime(), ecal.getTime())+"");
		
		efficiency.setQueryString(request.getQueryString());
		
		model.addAttribute("efficiency", efficiency);
		model.addAttribute("grades", FrpCommon.getGrade());
		
		model.addAttribute("codes", frpEfficiencyCodeService.getSecondaryCodes());
		
		return "frpEfficiency";
	}
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String save(@ModelAttribute("efficiency")FrpEfficiency efficency,
			RedirectAttributes redirectAttributes,
			Model model){
		
		try {
			try {
				Date date=dateFormat.parse(efficency.getFdate());
				efficency.setDate(date);
			} catch (ParseException e) {
				throw new Exception("Invalid Date.");
			}
			
			try {
				Date stime=timeFormat.parse(efficency.getFstartTimeHH()+":"+efficency.getFstartTimeMM());
				efficency.setStartTime(new Timestamp(stime.getTime()));
			} catch (ParseException e) {
				throw new Exception("Invalid Start time.");
			}
			
			try{
				String endt=CommonUtil.timeDiff(efficency.getFstartTimeHH()+":"+efficency.getFstartTimeMM(), efficency.getFendTimeHH(),efficency.getFendTimeMM());
				Date etime=timeFormat.parse(endt);
				efficency.setEndTime(new Timestamp(etime.getTime()));
			}catch(Exception e){
				throw new Exception("Invalid End time.");
			}
			
			
			try {
				if(efficency.getId()==0){
					int id=frpEfficiencyService.add(efficency);
					logger.info("Data saved with id="+id);
				}else{
					frpEfficiencyService.update(efficency);
					logger.info("Data updated with id="+efficency.getId());
				}
				
				
			} catch (Exception e) {
				throw new Exception("Failed to save data.");
			}
			
			
		} catch (Exception e) {
			model.addAttribute("efficiency", efficency);
			model.addAttribute("grades", FrpCommon.getGrade());
			model.addAttribute("codes", frpEfficiencyCodeService.getSecondaryCodes());
			model.addAttribute("error", e.getMessage());
		}
		
		if(efficency.getId()==0){
			redirectAttributes.addFlashAttribute("message", "Data saved successfully.");
		}else{
			
			redirectAttributes.addFlashAttribute("message", "Data updated successfully.");
			return "redirect:/frpefficiencyreport/view?"+efficency.getQueryString();
		}
		
		
		return "redirect:/frpefficiency/main";
	}
	
	
	@RequestMapping(value="/savenew", method=RequestMethod.POST)
	public void save(HttpServletRequest request,
			HttpServletResponse response,
			Model model) throws IOException{
		
		FrpEfficiency efficency=new FrpEfficiency();
		Map<String, Object> map=new HashMap<>();
		
		
		try {
			try {
				Date date=dateFormat.parse(request.getParameter("fdate"));
				efficency.setDate(date);
			} catch (ParseException e) {
				throw new Exception("Invalid Date.");
			}
			
			try {
				Date stime=timeFormat.parse(request.getParameter("fstartTimeHH")+":"+request.getParameter("fstartTimeMM"));
				efficency.setStartTime(new Timestamp(stime.getTime()));
			} catch (ParseException e) {
				throw new Exception("Invalid start time.");
			}
			
			try{
				String endt=CommonUtil.timeDiff(request.getParameter("fstartTimeHH")+":"+request.getParameter("fstartTimeMM"), request.getParameter("fendTimeHH"),request.getParameter("fendTimeMM"));
				Date etime=timeFormat.parse(endt);
				efficency.setEndTime(new Timestamp(etime.getTime()));
			}catch(Exception e){
				throw new Exception("Invalid end time.");
			}
			
			
			int id=CommonUtil.checkInt(request.getParameter("id"));
			efficency.setId(id);
			String shift=CommonUtil.checkNull(request.getParameter("shift"));
			efficency.setShift(shift);
			String crew=CommonUtil.checkNull(request.getParameter("crew"));
			efficency.setCrew(crew);
			String reel=CommonUtil.checkNull(request.getParameter("reel"));
			efficency.setBatchNo(reel);
			String gradeCode=CommonUtil.checkNull(request.getParameter("gradeCode"));
			efficency.setGrade(gradeCode);
			String comment=CommonUtil.checkNull(request.getParameter("comment"));
			efficency.setComment(comment);
			int secondaryCode=CommonUtil.checkInt(request.getParameter("secondaryCode"));
			FrpSecondaryCode code=new FrpSecondaryCode();
			code.setId(secondaryCode);
			efficency.setSecondaryCode(code);
			
			try {
				if(efficency.getId()==0){
					int key=frpEfficiencyService.add(efficency);
					map.put("id", key);
					map.put("status", true);
					map.put("message", "Data saved successfully");
					
					logger.info("Data saved with id="+key);
				}else{
					frpEfficiencyService.update(efficency);
					
					map.put("id", efficency.getId());
					map.put("status", true);
					map.put("message", "Data updated successfully");
					logger.info("Data updated with id="+efficency.getId());
				}
				
				
			} catch (Exception e) {
				throw new Exception("Failed to save data.Server error..");
				
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
			map.put("status", false);
			map.put("error", e.getMessage());
		}
		
		response.setContentType("application/json");
		response.getWriter().write(new Gson().toJson(map));
		
	}
	
	@RequestMapping(value="/timediff",method=RequestMethod.POST)
	public void getTimeDiff(HttpServletRequest request,
			HttpServletResponse response
			) throws IOException {
		
		String data="";
		
		
		try{
			data=CommonUtil.timeDiff(request.getParameter("sd"), request.getParameter("edHH"), request.getParameter("edMM"));
		}catch(Exception e){
			e.printStackTrace();
		}
		response.setContentType("application/json");
		response.getWriter().write(new Gson().toJson(data));
		
	}
	
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	public void delete(HttpServletRequest request,
			HttpServletResponse response
			) throws IOException {
		response.setContentType("application/json");
		Map<String, Boolean> map=new HashMap<String, Boolean>();
		int id=CommonUtil.checkInt(request.getParameter("id"));
		
		try{
			frpEfficiencyService.delete(id);
			map.put("status", true);
		}catch(Exception e){
			e.printStackTrace();
			map.put("status", false);
		}
		
		response.getWriter().write(new Gson().toJson(map));
	}
	
	
	@RequestMapping(value="/current/info",method=RequestMethod.POST)
	public void currentInfo(HttpServletRequest request,
			HttpServletResponse response
			) throws IOException {
		response.setContentType("application/json");
		Map<String, Object> map=new HashMap<>();
		
		map.put("date", dateFormat.format(new Date()));
		
		response.getWriter().write(new Gson().toJson(map));
	}

}

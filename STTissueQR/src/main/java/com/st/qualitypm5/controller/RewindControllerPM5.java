/**
 *Dec 25, 2017
 *RewindControllerPM5.java
 * TODO
 *com.st.qualitypm5.controller
 *RewindControllerPM5.java
 *Roshan Lal Tailor
 */
package com.st.qualitypm5.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.gson.Gson;
import com.st.common.CommonUtil;
import com.st.common.GradeTargetPM5Util;
import com.st.common.GradeTargetUtil;
import com.st.qualitypm5.model.GradeTargetPM5;
import com.st.qualitypm5.model.RewindPM5;
import com.st.qualitypm5.service.GradePM5Service;
import com.st.qualitypm5.service.GradeTargetPM5Service;
import com.st.qualitypm5.service.ReelServicePM5;
import com.st.qualitypm5.service.RewindServicePM5;
import com.st.qualitypm6.controller.RewindController;
import com.st.qualitypm6.model.Rewind;
import com.st.qualitypm6.service.CustomerService;
import com.st.qualitypm6.service.RewindService;

/**
 * @author roshan
 *
 */
@Controller
@RequestMapping(value = "/pm5rewind")
public class RewindControllerPM5 {

	private static Logger logger = Logger.getLogger(RewindControllerPM5.class);
	private SimpleDateFormat dateFormat1 = new SimpleDateFormat("MM-dd-yyyy");
	private SimpleDateFormat dateFormat2 = new SimpleDateFormat("MM/dd/yyyy");
	private SimpleDateFormat timeFormat=new SimpleDateFormat("HH:mm");
	
	@Autowired
	private GradePM5Service gradepm5Service;
	@Autowired
	private ReelServicePM5 reelpm5Service;
	@Autowired
	private GradeTargetPM5Service gradeTargetpm5Service;

	@Autowired
	private RewindServicePM5 rewindServicepm5;

	@Autowired
	private CustomerService customerService;

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String add(Model model) {

		model.addAttribute("showForm", false);
		model.addAttribute("grades", gradepm5Service.getGrades());
		model.addAttribute("date", dateFormat1.format(new Date()));
		return "PM5/rewindAdd";

	}

	@RequestMapping(value = "/add/{gradeCode}", method = RequestMethod.GET)
	public String add(@PathVariable("gradeCode") String gradeCode,
			HttpServletRequest request, Model model) {

		//CommonUtil.save(CommonUtil.REWIND_TEST_ENTRY_PAGE,request.getRequestURI());

		model.addAttribute("showForm", false);
		model.addAttribute("grades", gradepm5Service.getGrades());
		model.addAttribute("date", dateFormat1.format(new Date()));
		model.addAttribute("reels", reelpm5Service.getReelByGradeCode(gradeCode));

		List<String> customers = customerService.getCustomers();
		model.addAttribute("customers", customers);

		return "PM5/rewindAdd";

	}

	@RequestMapping(value = "/add/{gradeCode}/{reelNo}", method = RequestMethod.GET)
	public String add(@PathVariable("gradeCode") String gradeCode,
			@PathVariable("reelNo") String reelNo, HttpServletRequest request,
			Model model) {

		
		model.addAttribute("cDate", dateFormat2.format(new Date()));
		model.addAttribute("cTime", timeFormat.format(new Date()));
		
		//CommonUtil.save(CommonUtil.REWIND_TEST_ENTRY_PAGE,request.getRequestURI());


		List<GradeTargetPM5> gradeTargets = gradeTargetpm5Service.getGradeTarget(gradeCode);
		Map<String, Object> objective = GradeTargetPM5Util.format(gradeTargets);

		model.addAttribute("objective", objective);

		model.addAttribute("grades", gradepm5Service.getGrades());
		model.addAttribute("gradeCode", gradeCode);
		model.addAttribute("showForm", true);
		model.addAttribute("reelNo", reelNo);
		model.addAttribute("reels", reelpm5Service.getReelByGradeCode(gradeCode));

		
		Date shiftDate=CommonUtil.getShiftDate();

		List<RewindPM5> rewinds = rewindServicepm5.getRewinds(gradeCode, shiftDate);
		
		if(rewinds==null){	
			rewinds = new ArrayList<>();
		}

		model.addAttribute("rewinds", rewinds);

		List<String> customers = customerService.getCustomers();
		model.addAttribute("customers", customers);

		String custName = request.getParameter("custName");
		if (custName != null && custName.trim().equals("")) {
			model.addAttribute("custName", custName);
		} else {
			model.addAttribute("custName",
					reelpm5Service.getCustomerName(gradeCode, reelNo));
		}

		return "PM5/rewindAdd";
	}

	@RequestMapping(value = "/add/back", method = RequestMethod.GET)
	public String addBack(Model model) {

		model.addAttribute("showForm", false);
		model.addAttribute("grades", gradepm5Service.getGrades());
		model.addAttribute("date", dateFormat1.format(new Date()));
		return "PM5/rewindAddBack";

	}
	
	@RequestMapping(value = "/add/back/{gradeCode}", method = RequestMethod.GET)
	public String addBack(@PathVariable("gradeCode") String gradeCode,
			HttpServletRequest request, Model model) {

		model.addAttribute("showForm", false);
		model.addAttribute("grades", gradepm5Service.getGrades());
		model.addAttribute("date", dateFormat1.format(new Date()));
		model.addAttribute("reels", reelpm5Service.getReelByGradeCode(gradeCode));

		List<String> customers = customerService.getCustomers();
		model.addAttribute("customers", customers);

		return "PM5/rewindAddBack";

	}
	@RequestMapping(value = "/add/back/{date}/{gradeCode}/{reelNo}", method = RequestMethod.GET)
	public String addBack(@PathVariable("date") String date,
			@PathVariable("gradeCode") String gradeCode,
			@PathVariable("reelNo") String reelNo, HttpServletRequest request,
			Model model) {

		
		
		Date jdate = null;
		try {
			jdate = dateFormat1.parse(date);
			model.addAttribute("formatedDate", dateFormat2.format(jdate));

		} catch (ParseException e) {
			logger.error("Invalid date selected", e);
			return "rewindAdd";
		}

		List<GradeTargetPM5> gradeTargets = gradeTargetpm5Service.getGradeTarget(gradeCode);
		Map<String, Object> objective = GradeTargetPM5Util.format(gradeTargets);

		model.addAttribute("objective", objective);

		model.addAttribute("grades", gradepm5Service.getGrades());
		model.addAttribute("gradeCode", gradeCode);
		model.addAttribute("showForm", true);
		model.addAttribute("date", date);
		model.addAttribute("reelNo", reelNo);
		model.addAttribute("reels", reelpm5Service.getReelByGradeCode(gradeCode));
		
		List<RewindPM5> rewinds = null;
		if (jdate != null) {
			
			rewinds = rewindServicepm5.getRewinds(gradeCode, jdate);
			
			if(rewinds==null){	
				rewinds = new ArrayList<>();
			}

		} else {
			rewinds = new ArrayList<>();
		}

		model.addAttribute("rewinds", rewinds);

		List<String> customers = customerService.getCustomers();
		model.addAttribute("customers", customers);

		String custName = request.getParameter("custName");
		if (custName != null && custName.trim().equals("")) {
			model.addAttribute("custName", custName);
		} else {
			model.addAttribute("custName",reelpm5Service.getCustomerName(gradeCode, reelNo));
		}

		return "PM5/rewindAddBack";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public void save(HttpServletRequest request, HttpServletResponse response,
			Model model) {

/*		String enterAutoFlag = request.getParameter("enterAutoFlag");

		String elementIndex = request.getParameter("elementIndex");

		int trIndex = 0;
		int tdIndex = 0;
		if (elementIndex.contains("-")) {
			trIndex = NumberUtils.toInt(elementIndex.split("-")[0], 0);
			tdIndex = NumberUtils.toInt(elementIndex.split("-")[1], 0);
		}

	

		CommonUtil.save(CommonUtil.REWIND_TD_INDEX,
				new Integer(tdIndex).toString());
		CommonUtil.save(CommonUtil.REWIND_TR_INDEX,
				new Integer(trIndex).toString());*/

		List<String> ids = Arrays.asList(request.getParameterValues("id"));
		List<String> dates = Arrays.asList(request.getParameterValues("date"));
		List<String> times=Arrays.asList(request.getParameterValues("time"));
		List<String> gradeCodes = Arrays.asList(request.getParameterValues("gradeCode"));
		List<String> reels = Arrays.asList(request.getParameterValues("reel"));
		List<String> setNos = Arrays.asList(request.getParameterValues("setNo"));
		List<String> actualBasisWts = Arrays.asList(request.getParameterValues("actualBasisWt"));
		List<String> bulks = Arrays.asList(request.getParameterValues("bulk"));
		List<String> mdTensiles = Arrays.asList(request.getParameterValues("mdTensile"));
		List<String> cdTensiles = Arrays.asList(request.getParameterValues("cdTensile"));
		List<String> mdStretchs = Arrays.asList(request.getParameterValues("mdStretch"));
		List<String> mdcdTensileRatios = Arrays.asList(request.getParameterValues("mdcdTensileRatio"));
		List<String> mdWetTensiles = Arrays.asList(request.getParameterValues("mdWetTensile"));
		List<String> cdWetTensiles = Arrays.asList(request.getParameterValues("cdWetTensile"));
		List<String> cdTensileRatios = Arrays.asList(request.getParameterValues("cdTensileRatio"));
		List<String> brightnesss = Arrays.asList(request.getParameterValues("brightness"));
		List<String> dirtCounts = Arrays.asList(request.getParameterValues("dirtCount"));
		List<String> absorbencySecondss = Arrays.asList(request.getParameterValues("absorbencySeconds"));
//		Code Starts From Here Done By Roshan Tailor Date :- 03/05/2015
		List<String> lvalues=Arrays.asList(request.getParameterValues("lvalue"));
		List<String> avalues=Arrays.asList(request.getParameterValues("avalue"));
		List<String> bvalues =Arrays.asList(request.getParameterValues("bvalue"));
//		Code Ends Here Done By Roshan Tailor
		List<String> customers = Arrays.asList(request.getParameterValues("customer"));
		List<String> remarkss = Arrays.asList(request.getParameterValues("remarks"));

		
		List<RewindPM5> rewindsList = new ArrayList<RewindPM5>();
		List<RewindPM5> rewindsUpdateList = new ArrayList<RewindPM5>();

		for (int i = 0; i < ids.size(); i++) {
			String setNo = setNos.get(i);
			String date = dates.get(i);
			Date dateVal = null;
			try {
				dateVal = dateFormat2.parse(date);
			} catch (ParseException e) {
				e.printStackTrace();
			}

			String grade = gradeCodes.get(i);
			if (grade != null && dateVal != null && setNo != null
					&& !setNo.trim().equals("")) {

				RewindPM5 rewindObj = new RewindPM5();

				String id = ids.get(i);
				int idVal = 0;
				if (id != null) {
					idVal = NumberUtils.toInt(id, 0);
				}
				rewindObj.setId(idVal);
				
				String time=times.get(i).trim();
				if(time.equals("")){
					time="00:00";
				}
				
				Date timeVal=null;
				try {
					int h=0;
					int m=0;
					if(time.contains(":")){
						h=NumberUtils.toInt(time.split(":")[0].trim(),0);
						m=NumberUtils.toInt(time.split(":")[1].trim(),0);
						
					}else{
						h=NumberUtils.toInt(time,0);
					}
					Calendar calendar=Calendar.getInstance();
					calendar.set(Calendar.HOUR_OF_DAY, h);
					calendar.set(Calendar.MINUTE, m);
					calendar.set(Calendar.SECOND, 0);
					calendar.set(Calendar.MILLISECOND, 0);
					timeVal=calendar.getTime();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				rewindObj.setTime(timeVal);
				
				rewindObj.setDate(CommonUtil.getDateTime(dateVal, timeVal));

				rewindObj.setGradeCode(grade);

				String reelVal = reels.get(i);
				rewindObj.setReel(reelVal);

				String setVal = setNos.get(i);
				rewindObj.setSetNo(setVal);

				String actualBasisWt = actualBasisWts.get(i);
				double actualBasisWtVal = 0;
				if (actualBasisWt != null) {
					actualBasisWtVal = NumberUtils.toDouble(actualBasisWt, 0);
				}
				rewindObj.setActualBasisWt(actualBasisWtVal);

				String bulk = bulks.get(i);
				double bulkVal = 0;
				if (bulk != null) {
					bulkVal = NumberUtils.toDouble(bulk, 0);
				}
				rewindObj.setBulk(bulkVal);

				String mdTensile = mdTensiles.get(i);
				double mdTensileVal = 0;
				if (mdTensile != null) {
					mdTensileVal = NumberUtils.toDouble(mdTensile, 0);
				}
				rewindObj.setMdTensile(mdTensileVal);

				String cdTensile = cdTensiles.get(i);
				double cdTensileVal = 0;
				if (cdTensile != null) {
					cdTensileVal = NumberUtils.toDouble(cdTensile, 0);
				}
				rewindObj.setCdTensile(cdTensileVal);

				String mdStretch = mdStretchs.get(i);
				double mdStretchVal = 0;
				if (mdStretch != null) {
					mdStretchVal = NumberUtils.toDouble(mdStretch, 0);
				}
				rewindObj.setMdStretch(mdStretchVal);

				String mdcdTensileRatio = mdcdTensileRatios.get(i);
				double mdcdTensileRatioVal = 0;
				if (mdcdTensileRatio != null) {
					mdcdTensileRatioVal = NumberUtils.toDouble(
							mdcdTensileRatio, 0);
				}
				rewindObj.setMdcdTensileRatio(mdcdTensileRatioVal);

				String mdWetTensile = mdWetTensiles.get(i);
				double mdWetTensileVal = 0;
				if (mdWetTensile != null) {
					mdWetTensileVal = NumberUtils.toDouble(mdWetTensile, 0);
				}
				rewindObj.setMdWetTensile(mdWetTensileVal);

				String cdWetTensile = cdWetTensiles.get(i);
				double cdWetTensileVal = 0;
				if (cdWetTensile != null) {
					cdWetTensileVal = NumberUtils.toDouble(cdWetTensile, 0);
				}
				rewindObj.setCdWetTensile(cdWetTensileVal);

				String cdTensileRatio = cdTensileRatios.get(i);
				double cdTensileRatioVal = 0;
				if (cdTensileRatio != null) {
					cdTensileRatioVal = NumberUtils.toDouble(cdTensileRatio, 0);
				}
				rewindObj.setCdTensileRatio(cdTensileRatioVal);

				String brightness = brightnesss.get(i);
				double brightnessVal = 0;
				if (brightness != null) {
					brightnessVal = NumberUtils.toDouble(brightness, 0);
				}
				rewindObj.setBrightness(brightnessVal);

				String dirtCount = dirtCounts.get(i);
				double dirtCountVal = 0;
				if (dirtCount != null) {
					dirtCountVal = NumberUtils.toDouble(dirtCount, 0);
				}
				rewindObj.setDirtCount(dirtCountVal);

				String absorbencySeconds = absorbencySecondss.get(i);
				double absorbencySecondsVal = 0;
				if (absorbencySeconds != null) {
					absorbencySecondsVal = NumberUtils.toDouble(
							absorbencySeconds, 0);
				}
				rewindObj.setAbsorbencySeconds(absorbencySecondsVal);
				
//				Code Starts From Here Done By Roshan Tailor Date :- 03/05/2015

				String lvalue=lvalues.get(i);
				double lvalueVal=0;
				if(lvalue !=null){
				lvalueVal=NumberUtils.toDouble(lvalue, 0);
				}
				rewindObj.setLvalue(lvalueVal);
				
				String avalue=avalues.get(i);
				double avalueVal=0;
				if(avalue!=null){
					avalueVal=NumberUtils.toDouble(avalue, 0);
				}
				rewindObj.setAvalue(avalueVal);
				
				String bvalue=bvalues.get(i);
				double bvalueVal=0;
				if(bvalue!=null){
					bvalueVal=NumberUtils.toDouble(bvalue, 0);
				}
				rewindObj.setBvalue(bvalueVal);
				
//				Code Ends Here Done By Roshan Tailor
				String customer = customers.get(i);

				// System.out.println("Customer Name:-"+customer);

				if (customer == null) {
					customer = "";
				}
				rewindObj.setCustomer(customer);

				String remarks = remarkss.get(i);
				if (remarks == null) {
					remarks = "";
				}
				rewindObj.setRemarks(remarks);

				if (rewindObj.getId() != 0) {
					rewindsUpdateList.add(rewindObj);
				} else {
					rewindsList.add(rewindObj);
				}
			}
		}

		/*List<String> entryIds = Arrays.asList(request.getParameter("ids").split(","));
		
		List<Integer> intIds=new ArrayList<>();
		for (String string : entryIds) {
			int eid=NumberUtils.toInt(string,0);
			if(eid!=0){
				intIds.add(eid);
			}
		}*/
		
		try {
			
			

			/*if(intIds.size()>0){
				rewindServicepm5.updateEntryById(intIds, enterAutoFlag);
			}
			*/
			
			response.setContentType("application/json");

			if (rewindsUpdateList.size() == 1) {
				RewindPM5 rewind = rewindsUpdateList.get(0);
				Map<String, Object> map = new HashMap<>();
				RewindPM5 rewindOld = rewindServicepm5.getRewindById(rewind.getId());

				if (rewind.getSetNo().equalsIgnoreCase(rewindOld.getSetNo())) {
					map.put("flag", true);
					rewindServicepm5.update(rewind);
					map.put("id", rewind.getId());
				} else {
					boolean flag = rewindServicepm5.isSetNumberExist(rewind.getSetNo());
					if (flag) {
						map.put("flag", false);
					} else {
						map.put("flag", true);
						rewindServicepm5.update(rewind);
						map.put("id", rewind.getId());
					}
				}
				response.getWriter().write(new Gson().toJson(map));
			}

			if (rewindsList.size() == 1) {
				RewindPM5 rewind = rewindsList.get(0);
				Map<String, Object> map = new HashMap<>();

				boolean flag = rewindServicepm5.isSetNumberExist(rewind.getSetNo());
				if (flag) {
					map.put("flag", false);
				} else {
					map.put("flag", true);
					int id = rewindServicepm5.save(rewind);
					map.put("id", id);
				}
				response.getWriter().write(new Gson().toJson(map));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public void update(HttpServletRequest request,
			HttpServletResponse response, Model model) {



		List<String> ids = Arrays.asList(request.getParameterValues("id"));
		List<String> dates = Arrays.asList(request.getParameterValues("date"));
		List<String> times=Arrays.asList(request.getParameterValues("time"));
		List<String> gradeCodes = Arrays.asList(request.getParameterValues("gradeCode"));
		List<String> reels = Arrays.asList(request.getParameterValues("reel"));
		List<String> setNos = Arrays.asList(request.getParameterValues("setNo"));
		List<String> actualBasisWts = Arrays.asList(request.getParameterValues("actualBasisWt"));
		List<String> bulks = Arrays.asList(request.getParameterValues("bulk"));
		List<String> mdTensiles = Arrays.asList(request.getParameterValues("mdTensile"));
		List<String> cdTensiles = Arrays.asList(request.getParameterValues("cdTensile"));
		List<String> mdStretchs = Arrays.asList(request.getParameterValues("mdStretch"));
		List<String> mdcdTensileRatios = Arrays.asList(request.getParameterValues("mdcdTensileRatio"));
		List<String> mdWetTensiles = Arrays.asList(request.getParameterValues("mdWetTensile"));
		List<String> cdWetTensiles = Arrays.asList(request.getParameterValues("cdWetTensile"));
		List<String> cdTensileRatios = Arrays.asList(request.getParameterValues("cdTensileRatio"));
		List<String> brightnesss = Arrays.asList(request.getParameterValues("brightness"));
		List<String> dirtCounts = Arrays.asList(request.getParameterValues("dirtCount"));
		List<String> absorbencySecondss = Arrays.asList(request.getParameterValues("absorbencySeconds"));
//		Code Starts From Here Done By Roshan Tailor Date :- 03/07/02015 MM/DD/YYYY To Add The Values Into List
//		Modification Done By Roshan Tailor On Date :- 03/10/2015 MM/DD/YYYY
		List<String> lvalues=Arrays.asList(request.getParameterValues("lvalue"));
		List<String> avalues=Arrays.asList(request.getParameterValues("avalue"));
		List<String> bvalues=Arrays.asList(request.getParameterValues("bvalue"));
//		Code Ends Here Done By Roshan Tailor
		List<String> customers = Arrays.asList(request.getParameterValues("customer"));
		List<String> remarkss = Arrays.asList(request.getParameterValues("remarks"));

		List<RewindPM5> rewindsUpdateList = new ArrayList<RewindPM5>();
//Code Done By Roshan Tailor For Testing Purpose
//		System.out.println("Lvalue::"+lvalues);
//		System.out.println("Avalue::"+avalues);
//		System.out.println("Bvalue::"+bvalues);
//		System.out.println("Customer Name Is::::"+customers);
//Code Ends Here,Done for Testing Purpose		
		for (int i = 0; i < ids.size(); i++) {
			String setNo = setNos.get(i);
			String date = dates.get(i);
			Date dateVal = null;
			try {
				dateVal = dateFormat2.parse(date);
			} catch (ParseException e) {
				e.printStackTrace();
			}

			String grade = gradeCodes.get(i);
			if (grade != null && dateVal != null && setNo != null
					&& !setNo.trim().equals("")) {

				RewindPM5 rewindObj = new RewindPM5();

				String id = ids.get(i);
				int idVal = 0;
				if (id != null) {
					idVal = NumberUtils.toInt(id, 0);
				}
				rewindObj.setId(idVal);
				
				String time=times.get(i).trim();
				if(time.equals("")){
					time="00:00";
				}
				
				Date timeVal=null;
				try {
					int h=0;
					int m=0;
					if(time.contains(":")){
						h=NumberUtils.toInt(time.split(":")[0].trim(),0);
						m=NumberUtils.toInt(time.split(":")[1].trim(),0);
						
					}else{
						h=NumberUtils.toInt(time,0);
					}
					Calendar calendar=Calendar.getInstance();
					calendar.set(Calendar.HOUR_OF_DAY, h);
					calendar.set(Calendar.MINUTE, m);
					calendar.set(Calendar.SECOND, 0);
					calendar.set(Calendar.MILLISECOND, 0);
					timeVal=calendar.getTime();
				} catch (Exception e) {
					e.printStackTrace();
				}
				rewindObj.setTime(timeVal);
				
				rewindObj.setDate(CommonUtil.getDateTime(dateVal, timeVal));

				rewindObj.setGradeCode(grade);

				String reelVal = reels.get(i);
				rewindObj.setReel(reelVal);

				String setVal = setNos.get(i);
				rewindObj.setSetNo(setVal);

				String actualBasisWt = actualBasisWts.get(i);
				double actualBasisWtVal = 0;
				if (actualBasisWt != null) {
					actualBasisWtVal = NumberUtils.toDouble(actualBasisWt, 0);
				}
				rewindObj.setActualBasisWt(actualBasisWtVal);

				String bulk = bulks.get(i);
				double bulkVal = 0;
				if (bulk != null) {
					bulkVal = NumberUtils.toDouble(bulk, 0);
				}
				rewindObj.setBulk(bulkVal);

				String mdTensile = mdTensiles.get(i);
				double mdTensileVal = 0;
				if (mdTensile != null) {
					mdTensileVal = NumberUtils.toDouble(mdTensile, 0);
				}
				rewindObj.setMdTensile(mdTensileVal);

				String cdTensile = cdTensiles.get(i);
				double cdTensileVal = 0;
				if (cdTensile != null) {
					cdTensileVal = NumberUtils.toDouble(cdTensile, 0);
				}
				rewindObj.setCdTensile(cdTensileVal);

				String mdStretch = mdStretchs.get(i);
				double mdStretchVal = 0;
				if (mdStretch != null) {
					mdStretchVal = NumberUtils.toDouble(mdStretch, 0);
				}
				rewindObj.setMdStretch(mdStretchVal);

				String mdcdTensileRatio = mdcdTensileRatios.get(i);
				double mdcdTensileRatioVal = 0;
				if (mdcdTensileRatio != null) {
					mdcdTensileRatioVal = NumberUtils.toDouble(
							mdcdTensileRatio, 0);
				}
				rewindObj.setMdcdTensileRatio(mdcdTensileRatioVal);

				String mdWetTensile = mdWetTensiles.get(i);
				double mdWetTensileVal = 0;
				if (mdWetTensile != null) {
					mdWetTensileVal = NumberUtils.toDouble(mdWetTensile, 0);
				}
				rewindObj.setMdWetTensile(mdWetTensileVal);

				String cdWetTensile = cdWetTensiles.get(i);
				double cdWetTensileVal = 0;
				if (cdWetTensile != null) {
					cdWetTensileVal = NumberUtils.toDouble(cdWetTensile, 0);
				}
				rewindObj.setCdWetTensile(cdWetTensileVal);

				String cdTensileRatio = cdTensileRatios.get(i);
				double cdTensileRatioVal = 0;
				if (cdTensileRatio != null) {
					cdTensileRatioVal = NumberUtils.toDouble(cdTensileRatio, 0);
				}
				rewindObj.setCdTensileRatio(cdTensileRatioVal);

				String brightness = brightnesss.get(i);
				double brightnessVal = 0;
				if (brightness != null) {
					brightnessVal = NumberUtils.toDouble(brightness, 0);
				}
				rewindObj.setBrightness(brightnessVal);

				String dirtCount = dirtCounts.get(i);
				double dirtCountVal = 0;
				if (dirtCount != null) {
					dirtCountVal = NumberUtils.toDouble(dirtCount, 0);
				}
				rewindObj.setDirtCount(dirtCountVal);

				String absorbencySeconds = absorbencySecondss.get(i);
				double absorbencySecondsVal = 0;
				if (absorbencySeconds != null) {
					absorbencySecondsVal = NumberUtils.toDouble(
							absorbencySeconds, 0);
				}
				rewindObj.setAbsorbencySeconds(absorbencySecondsVal);

//				Code Starts From Here Done By Roshan Tailor DAte :- 03/07/2015 MM/DD/YYYY
				String lvalue=lvalues.get(i);
				double lvalueVal=0;
				if(lvalue!=null){
					lvalueVal=NumberUtils.toDouble(lvalue, 0);
				}
				rewindObj.setLvalue(lvalueVal);
				
				
				String avalue=avalues.get(i);
				double avalueVal=0;
				if(avalue!=null){
					avalueVal=NumberUtils.toDouble(avalue,0);
				}
				rewindObj.setAvalue(avalueVal);
				
				
				String bvalue=bvalues.get(i);
				double bvalueVal=0;
				if(bvalue!=null){
					bvalueVal=NumberUtils.toDouble(bvalue, 0);
				}
				rewindObj.setBvalue(bvalueVal);
//				Code Ends Here Done By Roshan Tailor
				
				String customer = customers.get(i);

//				 System.out.println("Customer Name:-"+customer);

				if (customer == null) {
					customer = "";
				}
				rewindObj.setCustomer(customer);

				String remarks = remarkss.get(i);
				if (remarks == null) {
					remarks = "";
				}
				rewindObj.setRemarks(remarks);

				if (rewindObj.getId() != 0) {
					rewindsUpdateList.add(rewindObj);
				}

			}
		}

		try {
			for (RewindPM5 rewind : rewindsUpdateList) {
//				All Values Are Coming rewind Object
			//	System.out.println("Remark Is::"+rewind.getRemarks());
			//	System.out.println("Customer Is::"+rewind.getCustomer());
				
				rewindServicepm5.update(rewind);
			}
			response.setContentType("application/json");
			Map<String, String> map = new HashMap<>();
			map.put("status", "1");
			response.getWriter().write(new Gson().toJson(map));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@RequestMapping(value = "/check", method = RequestMethod.POST)
	public void validateReelData(HttpServletRequest request,
			HttpServletResponse response) {

		response.setContentType("application/json");

		String value = request.getParameter("value");
		double val = NumberUtils.toDouble(value, 0);
		double minR=CommonUtil.checkDouble(request.getParameter("minR"));
		double maxR=CommonUtil.checkDouble(request.getParameter("maxR"));
		double minC=CommonUtil.checkDouble(request.getParameter("minC"));
		double maxC=CommonUtil.checkDouble(request.getParameter("maxC"));
		double target=CommonUtil.checkDouble(request.getParameter("target"));
		
		
		int color=0;
		if(val!=0){
			color=GradeTargetUtil.checkRange(val, minR, maxR, minC, maxC, target);
		}
		
		
		Map<String, Integer> map = new HashMap<>();
		map.put("color", color);
		try {
			response.getWriter().write(new Gson().toJson(map));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "/setnocheck", method = RequestMethod.POST)
	public void validateReelNumber(HttpServletRequest request,
			HttpServletResponse response) {

		response.setContentType("application/json");

		String setNo = request.getParameter("setNo");
		boolean flag = rewindServicepm5.isSetNumberExist(setNo);
		Map<String, Boolean> map = new HashMap<>();
		map.put("flag", flag);

		try {
			response.getWriter().write(new Gson().toJson(map));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public void deleteRewid(HttpServletRequest request,
			HttpServletResponse response) {

		response.setContentType("application/json");

		String ids = request.getParameter("ids");

		if (ids == null) {
			ids = "";
		}

		List<String> idsList = Arrays.asList(ids.split(","));

		if (idsList.size() != 0) {
			rewindServicepm5.delete(idsList);
		}

		boolean flag = true;
		Map<String, Boolean> map = new HashMap<>();
		map.put("flag", flag);

		try {
			response.getWriter().write(new Gson().toJson(map));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value = "/rwindinfo", method = RequestMethod.GET)
	public String rewindInfo(Model model) {
		model.addAttribute("showFlag", false);
		return "PM5/rewindInfo";
	}
	
	@RequestMapping(value = "/rwindinfo/data", method = RequestMethod.GET)
	public String rewindInfo(HttpServletRequest request,Model model) {
		
		String reel=CommonUtil.checkNull(request.getParameter("reel"));
		String set=CommonUtil.checkNull(request.getParameter("set"));
		
		
		List<RewindPM5> rewinds=null;
		if(StringUtils.isNotBlank(reel) || StringUtils.isNotBlank(set)){
			rewinds=rewindServicepm5.getRewindInfo(reel,set);
		}
		
		model.addAttribute("reel", reel);
		model.addAttribute("set", set);
		model.addAttribute("showFlag", true);
		model.addAttribute("rewinds", rewinds);
		
		return "PM5/rewindInfo";
	}
	
	@RequestMapping(value="/getCurrentData",method=RequestMethod.POST)
	public void currentData(HttpServletResponse response) throws IOException {
		
		SimpleDateFormat dateFormat=new SimpleDateFormat("MM/dd/yyyy");
		Map<String, String>	 map=new HashMap<>();
		String date=dateFormat.format(new Date());
		map.put("date", date);
		map.put("time", timeFormat.format(new Date()));
		
		response.setContentType("application/json");
		
		response.getWriter().write(new Gson().toJson(map));
	}
}

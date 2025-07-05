/**
 *Dec 22, 2017
 *ReelControllerPM5.java
 * TODO
 *com.st.qualitypm5.controller
 *ReelControllerPM5.java
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

import org.apache.commons.lang3.math.NumberUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.gson.Gson;
import com.st.common.CommonProperties;
import com.st.common.CommonUtil;
import com.st.common.GradeTargetPM5Util;
import com.st.common.GradeTargetUtil;
import com.st.frppressquality.service.FrpPressQualityService;
import com.st.production.model.WrapperProduction;
import com.st.production.service.WrapperProductionService;
import com.st.qualitypm5.model.GradeTargetPM5;
import com.st.qualitypm5.model.ReelPM5;
import com.st.qualitypm5.service.GradePM5Service;
import com.st.qualitypm5.service.GradeTargetPM5Service;
import com.st.qualitypm5.service.ReelServicePM5;
import com.st.qualitypm6.service.CustomerService;

/**
 * @author roshan
 *
 */
@Controller
@RequestMapping(value = "/pm5reel")
public class ReelControllerPM5 {

	private static Logger logger = Logger.getLogger(ReelControllerPM5.class);
	private SimpleDateFormat dateFormat1 = new SimpleDateFormat("MM-dd-yyyy");
	private SimpleDateFormat dateFormat2 = new SimpleDateFormat("MM/dd/yyyy");
	private SimpleDateFormat yearformat = new SimpleDateFormat("yyyy");
	private SimpleDateFormat dateTimeFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm");
	private SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");

	@Autowired
	private GradePM5Service gradePM5Service;
	@Autowired
	private ReelServicePM5 reelServicePM5;
	@Autowired
	private GradeTargetPM5Service gradeTargetPM5Service;
	@Autowired
	private CustomerService customerService;

	@Autowired
	private FrpPressQualityService frpPressQualityService;

	@Autowired
	private WrapperProductionService wrapperProductionService;

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String add(Model model) {

		model.addAttribute("maxReel", reelServicePM5.getMaxReel());

		model.addAttribute("showForm", false);
		model.addAttribute("grades", gradePM5Service.getGrades());
		model.addAttribute("date", dateFormat1.format(new Date()));

		return "PM5/reelAdd";
	}

	@RequestMapping(value = "/add/{gradeCode}", method = RequestMethod.GET)
	public String add(@PathVariable("gradeCode") String gradeCode, HttpServletRequest request, Model model) {

		model.addAttribute("maxReel", reelServicePM5.getMaxReel());
		model.addAttribute("cTime", timeFormat.format(new Date()));
		model.addAttribute("cDate", dateFormat2.format(new Date()));

		// CommonUtil.save(CommonUtil.REEL_TEST_ENTRY_PAGE_PM5,
		// request.getRequestURI());

		Date date = CommonUtil.getShiftDate();

		List<GradeTargetPM5> gradeTargets = gradeTargetPM5Service.getGradeTarget(gradeCode);
		Map<String, Object> objective = GradeTargetPM5Util.format(gradeTargets);

		model.addAttribute("objective", objective);

		model.addAttribute("grades", gradePM5Service.getGrades());
		model.addAttribute("gradeCode", gradeCode);
		model.addAttribute("showForm", true);
		model.addAttribute("date", dateFormat1.format(date));

		List<ReelPM5> reels = reelServicePM5.getReels(gradeCode, date);

		if (reels == null) {
			reels = new ArrayList<ReelPM5>();
		}

		model.addAttribute("reels", reels);

		List<String> customers = customerService.getCustomers();
		model.addAttribute("customers", customers);

		return "PM5/reelAdd";
	}

	@RequestMapping(value = "/add/back", method = RequestMethod.GET)
	public String addBack(Model model) {

		model.addAttribute("showForm", false);
		model.addAttribute("grades", gradePM5Service.getGrades());
		model.addAttribute("date", dateFormat1.format(new Date()));

		return "PM5/reelAddBack";
	}

	@RequestMapping(value = "/add/back/{date}/{gradeCode}", method = RequestMethod.GET)
	public String addBack(@PathVariable("date") String date, @PathVariable("gradeCode") String gradeCode,
			HttpServletRequest request, Model model) {

		Date jdate = null;
		try {
			jdate = dateFormat1.parse(date);
			model.addAttribute("formatedDate", dateFormat2.format(jdate));

		} catch (ParseException e) {
			logger.error("Invalid date selected", e);
			return "reelAdd";
		}

		List<GradeTargetPM5> gradeTargets = gradeTargetPM5Service.getGradeTarget(gradeCode);
		Map<String, Object> objective = GradeTargetPM5Util.format(gradeTargets);

		model.addAttribute("objective", objective);

		model.addAttribute("grades", gradePM5Service.getGrades());
		model.addAttribute("gradeCode", gradeCode);
		model.addAttribute("showForm", true);
		model.addAttribute("date", date);

		List<ReelPM5> reels = reelServicePM5.getReels(gradeCode, jdate);

		if (reels == null) {
			reels = new ArrayList<ReelPM5>();
		}

		model.addAttribute("reels", reels);

		List<String> customers = customerService.getCustomers();
		model.addAttribute("customers", customers);

		return "PM5/reelAddBack";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public void save(HttpServletRequest request, HttpServletResponse response, Model model) {

		String yer = null;

		List<String> ids = Arrays.asList(request.getParameterValues("id"));
		List<String> dates = Arrays.asList(request.getParameterValues("date"));
		List<String> times = Arrays.asList(request.getParameterValues("time"));
		List<String> gradeCodes = Arrays.asList(request.getParameterValues("gradeCode"));
		List<String> reels = Arrays.asList(request.getParameterValues("reel"));
		List<String> scannerBasisWts = Arrays.asList(request.getParameterValues("scannerBasisWt"));
		List<String> actualBasisWts = Arrays.asList(request.getParameterValues("actualBasisWt"));
		List<String> bulks = Arrays.asList(request.getParameterValues("bulk"));
		List<String> finchCups = Arrays.asList(request.getParameterValues("finchCup"));
		List<String> mdTensiles = Arrays.asList(request.getParameterValues("mdTensile"));
		List<String> cdTensiles = Arrays.asList(request.getParameterValues("cdTensile"));
		List<String> mdStretchs = Arrays.asList(request.getParameterValues("mdStretch"));
		List<String> mdcdTensileRatios = Arrays.asList(request.getParameterValues("mdcdTensileRatio"));
		List<String> mdWetTensiles = Arrays.asList(request.getParameterValues("mdWetTensile"));
		List<String> cdWetTensiles = Arrays.asList(request.getParameterValues("cdWetTensile"));
		List<String> cdTensileRatios = Arrays.asList(request.getParameterValues("cdTensileRatio"));
		List<String> brightnesss = Arrays.asList(request.getParameterValues("brightness"));
		List<String> fwaFlows = Arrays.asList(request.getParameterValues("fwaFlow"));

		List<String> akds = Arrays.asList(request.getParameterValues("akd"));
		List<String> wetstrengths = Arrays.asList(request.getParameterValues("wetstrength"));
		List<String> drystrengthflows = Arrays.asList(request.getParameterValues("drystrengthflow"));

		List<String> dirtCounts = Arrays.asList(request.getParameterValues("dirtCount"));
		List<String> fwaDosages = Arrays.asList(request.getParameterValues("fwaDosage"));
		List<String> tphs = Arrays.asList(request.getParameterValues("tph"));
		List<String> trims = Arrays.asList(request.getParameterValues("trim"));
		List<String> crepeRatios = Arrays.asList(request.getParameterValues("crepeRatio"));
//		Code Starts  Done By Roshan Tailor Date:- 03/04/2015 mm/dd/yyyy
		List<String> lvalues = Arrays.asList(request.getParameterValues("lvaue"));
		List<String> avalues = Arrays.asList(request.getParameterValues("avalue"));
		List<String> bvalues = Arrays.asList(request.getParameterValues("bvalue"));
		List<String> deltaes = Arrays.asList(request.getParameterValues("deltae"));

		// Code Ends here Done By Roshan Tailor

		List<String> customers = Arrays.asList(request.getParameterValues("customer"));
		List<String> customers1=Arrays.asList(request.getParameterValues("customer1"));
        List<String> customers2=Arrays.asList(request.getParameterValues("customer2"));
	

		List<String> remarkss = Arrays.asList(request.getParameterValues("remarks"));

		List<ReelPM5> reelList = new ArrayList<ReelPM5>();
		List<ReelPM5> reelUpdateList = new ArrayList<ReelPM5>();

		for (int i = 0; i < ids.size(); i++) {
			String reel = reels.get(i);
			String date = dates.get(i);

			Date dateVal = null;
			try {
				dateVal = dateFormat2.parse(date);
				yer = yearformat.format(dateVal);
				System.out.println(yer);
			} catch (ParseException e) {
				e.printStackTrace();
			}

			String grade = gradeCodes.get(i);
			if (grade != null && dateVal != null && reel != null && !reel.trim().equals("")) {

				ReelPM5 reelObj = new ReelPM5();

				String id = ids.get(i);
				int idVal = 0;
				if (id != null) {
					idVal = NumberUtils.toInt(id, 0);
				}
				reelObj.setId(idVal);

				String time = times.get(i).trim();
				if (time.equals("")) {
					time = "00:00";
				}

				Date timeVal = null;
				try {
					int h = 0;
					int m = 0;
					if (time.contains(":")) {
						h = NumberUtils.toInt(time.split(":")[0].trim(), 0);
						m = NumberUtils.toInt(time.split(":")[1].trim(), 0);

					} else {
						h = NumberUtils.toInt(time, 0);
					}
					Calendar calendar = Calendar.getInstance();
					calendar.set(Calendar.HOUR_OF_DAY, h);
					calendar.set(Calendar.MINUTE, m);
					calendar.set(Calendar.SECOND, 0);
					calendar.set(Calendar.MILLISECOND, 0);
					timeVal = calendar.getTime();
				} catch (Exception e) {
					e.printStackTrace();
				}
				reelObj.setTime(timeVal);
				reelObj.setDate(CommonUtil.getDateTime(dateVal, timeVal));

				reelObj.setGradeCode(grade);

				String reelVal = reels.get(i);
				reelObj.setReel(reelVal);

				String scannerBasisWt = scannerBasisWts.get(i);
				double scannerBasisWtVal = 0;
				if (scannerBasisWt != null) {
					scannerBasisWtVal = NumberUtils.toDouble(scannerBasisWt, 0);
				}
				reelObj.setScannerBasisWt(scannerBasisWtVal);

				String actualBasisWt = actualBasisWts.get(i);
				double actualBasisWtVal = 0;
				if (actualBasisWt != null) {
					actualBasisWtVal = NumberUtils.toDouble(actualBasisWt, 0);
				}
				reelObj.setActualBasisWt(actualBasisWtVal);

				String bulk = bulks.get(i);
				double bulkVal = 0;
				if (bulk != null) {
					bulkVal = NumberUtils.toDouble(bulk, 0);
				}
				reelObj.setBulk(bulkVal);
				
				String mdTensile = mdTensiles.get(i);
				double mdTensileVal = 0;
				if (mdTensile != null) {
					mdTensileVal = NumberUtils.toDouble(mdTensile, 0);
				}
				reelObj.setMdTensile(mdTensileVal);

				String cdTensile = cdTensiles.get(i);
				String finchCup = finchCups.get(i);
				double finchCupVal = 0;
				if (finchCup != null) {
					finchCupVal = NumberUtils.toDouble(finchCup, 0);
				}
				reelObj.setFinchCup(finchCupVal);
				double cdTensileVal = 0;
				if (cdTensile != null) {
					cdTensileVal = NumberUtils.toDouble(cdTensile, 0);
				}
				reelObj.setCdTensile(cdTensileVal);

				String mdStretch = mdStretchs.get(i);
				double mdStretchVal = 0;
				if (mdStretch != null) {
					mdStretchVal = NumberUtils.toDouble(mdStretch, 0);
				}
				reelObj.setMdStretch(mdStretchVal);

				String mdcdTensileRatio = mdcdTensileRatios.get(i);
				double mdcdTensileRatioVal = 0;
				if (mdcdTensileRatio != null) {
					mdcdTensileRatioVal = NumberUtils.toDouble(mdcdTensileRatio, 0);
				}
				reelObj.setMdcdTensileRatio(mdcdTensileRatioVal);

				String mdWetTensile = mdWetTensiles.get(i);
				double mdWetTensileVal = 0;
				if (mdWetTensile != null) {
					mdWetTensileVal = NumberUtils.toDouble(mdWetTensile, 0);
				}
				reelObj.setMdWetTensile(mdWetTensileVal);

				String cdWetTensile = cdWetTensiles.get(i);
				double cdWetTensileVal = 0;
				if (cdWetTensile != null) {
					cdWetTensileVal = NumberUtils.toDouble(cdWetTensile, 0);
				}
				reelObj.setCdWetTensile(cdWetTensileVal);

				String cdTensileRatio = cdTensileRatios.get(i);
				double cdTensileRatioVal = 0;
				if (cdTensileRatio != null) {
					cdTensileRatioVal = NumberUtils.toDouble(cdTensileRatio, 0);
				}
				reelObj.setWetDryRatio(cdTensileRatioVal);

				String brightness = brightnesss.get(i);
				double brightnessVal = 0;
				if (brightness != null) {
					brightnessVal = NumberUtils.toDouble(brightness, 0);
				}
				reelObj.setBrightness(brightnessVal);

				String fwaFlow = fwaFlows.get(i);
				double fwaFlowVal = 0;
				if (fwaFlow != null) {
					fwaFlowVal = NumberUtils.toDouble(fwaFlow, 0);
				}
				reelObj.setFwaFlow(fwaFlowVal);

				//
				String akd = akds.get(i);
				double akdVal = 0;
				if (akd != null) {
					akdVal = NumberUtils.toDouble(akd, 0);
				}
				reelObj.setAkd(akdVal);

				String wetstrength = wetstrengths.get(i);
				double wetstrengthVal = 0;
				if (wetstrength != null) {
					wetstrengthVal = NumberUtils.toDouble(wetstrength, 0);
				}
				reelObj.setWetstrength(wetstrengthVal);

				String drystrengthflow = drystrengthflows.get(i);
				double drystrengthflowVal = 0;
				if (drystrengthflow != null) {
					drystrengthflowVal = NumberUtils.toDouble(drystrengthflow, 0);
				}
				reelObj.setDrystrengthflow(drystrengthflowVal);

				//

				String dirtCount = dirtCounts.get(i);
				double dirtCountVal = 0;
				if (dirtCount != null) {
					dirtCountVal = NumberUtils.toDouble(dirtCount, 0);
				}
				reelObj.setDirtCount(dirtCountVal);

				String fwaDosage = fwaDosages.get(i);
				double fwaDosageVal = 0;
				if (fwaDosage != null) {
					fwaDosageVal = NumberUtils.toDouble(fwaDosage, 0);
				}
				reelObj.setFwaDosage(fwaDosageVal);

				String tph = tphs.get(i);
				double tphVal = 0;
				if (tph != null) {
					tphVal = NumberUtils.toDouble(tph, 0);
				}
				reelObj.setTph(tphVal);

				String trim = trims.get(i);
				double trimVal = 0;
				if (trim != null) {
					trimVal = NumberUtils.toDouble(trim, 0);
				}
				reelObj.setTrim(trimVal);

				String crepeRatio = crepeRatios.get(i);
				double crepeRatioVal = 0;
				if (crepeRatio != null) {
					crepeRatioVal = NumberUtils.toDouble(crepeRatio, 0);
				}
				reelObj.setCrepeRatio(crepeRatioVal);

//				Code Done By Roshan Tailor Starts From Here Date:- 03/05/2015
				String lvalue = lvalues.get(i);
				double lvalueVal = 0;
				if (lvalue != null) {
					lvalueVal = NumberUtils.toDouble(lvalue, 0);
				}
				reelObj.setLvalue(lvalueVal);

				String avalue = avalues.get(i);
				double avalueVal = 0;
				if (avalue != null) {
					avalueVal = NumberUtils.toDouble(avalue, 0);
				}
				reelObj.setAvalue(avalueVal);

				String bvalue = bvalues.get(i);
				double bvalueVal = 0;
				if (bvalue != null) {
					bvalueVal = NumberUtils.toDouble(bvalue, 0);
				}
				reelObj.setBvalue(bvalueVal);

				String deltae = deltaes.get(i);
				double deltaeVal = 0;
				if (deltae != null) {
					deltaeVal = NumberUtils.toDouble(deltae, 0);
				}
				reelObj.setDeltae(deltaeVal);

//				Code Ends Here Done By Roshan Tailor

				String customer = customers.get(i);
				if (customer == null) {
					customer = "";
				}
				reelObj.setCustomer(customer);

				
				  String customer1=customers1.get(i);
				  if(customer1==null){ customer1=""; }
				  reelObj.setCustomer1(customer1);
				  
				  String customer2 = customers2.get(i);
					if (customer2 == null) {
						customer2 = "";
					}
					reelObj.setCustomer2(customer2);
					 
				
				 reelObj.setCustomer2(customer2);

				String remarks = remarkss.get(i);
				if (remarks == null) {
					remarks = "";
				}
				reelObj.setRemarks(remarks);

				if (reelObj.getId() != 0) {
					reelUpdateList.add(reelObj);
				} else {
					reelList.add(reelObj);
				}

			}
		}

		try {

			response.setContentType("application/json");

			if (reelUpdateList.size() == 1) {
				ReelPM5 reel = reelUpdateList.get(0);

				boolean checkFlag = true;
				// Reel Time
				Map<String, Date> reelMap = reelServicePM5.getPrevNextReelDate(reel.getReel());
				if (reelMap.get(CommonProperties.REEL_PREV) != null) {
					if (CommonUtil.getMinutesDiff(reel.getDate(), reelMap.get(CommonProperties.REEL_PREV)) > 0) {
						checkFlag = false;
					}
				}

				Map<String, Object> map = new HashMap<>();

				if (checkFlag) {
					ReelPM5 reelOld = reelServicePM5.getReelById(reel.getId());

					if (reelOld.getReel().equals(reel.getReel())) {
						map.put("flag", true);
						reelServicePM5.update(reel);
						map.put("id", reel.getId());

					} else {
						boolean flag = reelServicePM5.isReelNumberExist(reel.getReel(), yer);
						if (flag) {
							map.put("flag", false);
							logger.info("Reel No:-" + reel.getReel() + " Already exist");
							map.put("error", "Reel No:-" + reel.getReel() + " already exist..");
						} else {
							map.put("flag", true);
							reelServicePM5.update(reel);
							map.put("id", reel.getId());
						}
					}
				} else {
					map.put("error",
							"Previous reel no. " + (NumberUtils.toInt(reel.getReel(), 0) - 1) + " was entered at "
									+ dateTimeFormat.format(reelMap.get(CommonProperties.REEL_PREV)) + "."
									+ " Please change time for reel no. " + reel.getReel());
					map.put("field", "time");
				}

				response.getWriter().write(new Gson().toJson(map));
			}

			if (reelList.size() == 1) {
				ReelPM5 reel = reelList.get(0);
				Map<String, Object> map = new HashMap<>();

				boolean checkFlag = true;
				// Reel Time
				Map<String, Date> reelMap = reelServicePM5.getPrevNextReelDate(reel.getReel());
				if (reelMap.get(CommonProperties.REEL_PREV) != null) {
					if (CommonUtil.getMinutesDiff(reel.getDate(), reelMap.get(CommonProperties.REEL_PREV)) > 0) {
						checkFlag = false;
					}
				}

				if (checkFlag) {
					boolean flag = reelServicePM5.isReelNumberExist(reel.getReel(), yer);
					if (flag) {
						map.put("flag", false);
						logger.info("Reel No:-" + reel.getReel() + " Already exist");
						map.put("error", "Reel No:-" + reel.getReel() + " already exist..");
					} else {
						map.put("flag", true);
						int id = reelServicePM5.save(reel);
						map.put("id", id);
					}
				} else {
					map.put("error",
							"Previous reel no. " + (NumberUtils.toInt(reel.getReel(), 0) - 1) + " was entered at "
									+ dateTimeFormat.format(reelMap.get(CommonProperties.REEL_PREV)) + "."
									+ " Please change time for reel no. " + reel.getReel());
					map.put("field", "time");
				}

				response.getWriter().write(new Gson().toJson(map));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public void update(HttpServletRequest request, HttpServletResponse response, Model model) {

		List<String> ids = Arrays.asList(request.getParameterValues("id"));
		List<String> dates = Arrays.asList(request.getParameterValues("date"));
		List<String> times = Arrays.asList(request.getParameterValues("time"));
		List<String> gradeCodes = Arrays.asList(request.getParameterValues("gradeCode"));
		List<String> reels = Arrays.asList(request.getParameterValues("reel"));
		List<String> scannerBasisWts = Arrays.asList(request.getParameterValues("scannerBasisWt"));
		List<String> actualBasisWts = Arrays.asList(request.getParameterValues("actualBasisWt"));
		List<String> bulks = Arrays.asList(request.getParameterValues("bulk"));
		List<String> mdTensiles = Arrays.asList(request.getParameterValues("mdTensile"));
		List<String> cdTensiles = Arrays.asList(request.getParameterValues("cdTensile"));
		List<String> mdStretchs = Arrays.asList(request.getParameterValues("mdStretch"));
		List<String> mdcdTensileRatios = Arrays.asList(request.getParameterValues("mdcdTensileRatio"));
		List<String> mdWetTensiles = Arrays.asList(request.getParameterValues("mdWetTensile"));
		List<String> finchCups = Arrays.asList(request.getParameterValues("finchCup"));
		List<String> cdWetTensiles = Arrays.asList(request.getParameterValues("cdWetTensile"));
		List<String> cdTensileRatios = Arrays.asList(request.getParameterValues("cdTensileRatio"));
		List<String> brightnesss = Arrays.asList(request.getParameterValues("brightness"));
		List<String> fwaFlows = Arrays.asList(request.getParameterValues("fwaFlow"));

		List<String> akds = Arrays.asList(request.getParameterValues("akd"));
		List<String> wetstrengths = Arrays.asList(request.getParameterValues("wetstrength"));
		List<String> drystrengthflows = Arrays.asList(request.getParameterValues("drystrengthflow"));

		List<String> dirtCounts = Arrays.asList(request.getParameterValues("dirtCount"));
		List<String> fwaDosages = Arrays.asList(request.getParameterValues("fwaDosage"));
		List<String> tphs = Arrays.asList(request.getParameterValues("tph"));
		List<String> trims = Arrays.asList(request.getParameterValues("trim"));
//		Code Starts From Here Done By Roshan Tailor Date ;- 03/10/2015 MM/DD/YYYY
		List<String> lvalues = Arrays.asList(request.getParameterValues("lvalue"));
		List<String> avalues = Arrays.asList(request.getParameterValues("avalue"));
		List<String> bvalues = Arrays.asList(request.getParameterValues("bvalue"));
		List<String> deltaes = Arrays.asList(request.getParameterValues("deltae"));
//		Code Ends Here Done By Roshan Tailor 
		List<String> crepeRatios = Arrays.asList(request.getParameterValues("crepeRatio"));
		List<String> customers = Arrays.asList(request.getParameterValues("customer"));
		List<String> customers1 = Arrays.asList(request.getParameterValues("customer1"));
		List<String> customers2 = Arrays.asList(request.getParameterValues("customer2"));

		// System.out.println(customers);

		List<String> remarkss = Arrays.asList(request.getParameterValues("remarks"));

		List<ReelPM5> reelUpdateList = new ArrayList<ReelPM5>();

		for (int i = 0; i < ids.size(); i++) {
			String reel = reels.get(i);
			String date = dates.get(i);
			Date dateVal = null;
			try {
				dateVal = dateFormat2.parse(date);
			} catch (ParseException e) {
				e.printStackTrace();
			}

			String grade = gradeCodes.get(i);
			if (grade != null && dateVal != null && reel != null && !reel.trim().equals("")) {

				ReelPM5 reelObj = new ReelPM5();

				String id = ids.get(i);
				int idVal = 0;
				if (id != null) {
					idVal = NumberUtils.toInt(id, 0);
				}
				reelObj.setId(idVal);

				String time = times.get(i).trim();
				if (time.equals("")) {
					time = "00:00";
				}

				Date timeVal = null;
				try {
					int h = 0;
					int m = 0;
					if (time.contains(":")) {
						h = NumberUtils.toInt(time.split(":")[0].trim(), 0);
						m = NumberUtils.toInt(time.split(":")[1].trim(), 0);

					} else {
						h = NumberUtils.toInt(time, 0);
					}
					Calendar calendar = Calendar.getInstance();
					calendar.set(Calendar.HOUR_OF_DAY, h);
					calendar.set(Calendar.MINUTE, m);
					calendar.set(Calendar.SECOND, 0);
					calendar.set(Calendar.MILLISECOND, 0);
					timeVal = calendar.getTime();
				} catch (Exception e) {
					e.printStackTrace();
				}
				reelObj.setTime(timeVal);
				reelObj.setDate(CommonUtil.getDateTime(dateVal, timeVal));

				reelObj.setGradeCode(grade);

				String reelVal = reels.get(i);
				reelObj.setReel(reelVal);

				String scannerBasisWt = scannerBasisWts.get(i);
				double scannerBasisWtVal = 0;
				if (scannerBasisWt != null) {
					scannerBasisWtVal = NumberUtils.toDouble(scannerBasisWt, 0);
				}
				reelObj.setScannerBasisWt(scannerBasisWtVal);

				String actualBasisWt = actualBasisWts.get(i);
				double actualBasisWtVal = 0;
				if (actualBasisWt != null) {
					actualBasisWtVal = NumberUtils.toDouble(actualBasisWt, 0);
				}
				reelObj.setActualBasisWt(actualBasisWtVal);

				String bulk = bulks.get(i);
				double bulkVal = 0;
				if (bulk != null) {
					bulkVal = NumberUtils.toDouble(bulk, 0);
				}
				reelObj.setBulk(bulkVal);

				String mdTensile = mdTensiles.get(i);
				double mdTensileVal = 0;
				if (mdTensile != null) {
					mdTensileVal = NumberUtils.toDouble(mdTensile, 0);
				}
				reelObj.setMdTensile(mdTensileVal);

				String cdTensile = cdTensiles.get(i);
				double cdTensileVal = 0;
				if (cdTensile != null) {
					cdTensileVal = NumberUtils.toDouble(cdTensile, 0);
				}
				reelObj.setCdTensile(cdTensileVal);

				String mdStretch = mdStretchs.get(i);
				double mdStretchVal = 0;
				if (mdStretch != null) {
					mdStretchVal = NumberUtils.toDouble(mdStretch, 0);
				}
				reelObj.setMdStretch(mdStretchVal);

				String mdcdTensileRatio = mdcdTensileRatios.get(i);
				double mdcdTensileRatioVal = 0;
				if (mdcdTensileRatio != null) {
					mdcdTensileRatioVal = NumberUtils.toDouble(mdcdTensileRatio, 0);
				}
				reelObj.setMdcdTensileRatio(mdcdTensileRatioVal);

				String mdWetTensile = mdWetTensiles.get(i);
				double mdWetTensileVal = 0;
				if (mdWetTensile != null) {
					mdWetTensileVal = NumberUtils.toDouble(mdWetTensile, 0);
				}
				reelObj.setMdWetTensile(mdWetTensileVal);

				String finchCup = finchCups.get(i);
				double finchCupVal = 0;
				if (finchCup != null) {
					finchCupVal = NumberUtils.toDouble(finchCup, 0);
				}
				reelObj.setFinchCup(finchCupVal);

				String cdWetTensile = cdWetTensiles.get(i);
				double cdWetTensileVal = 0;
				if (cdWetTensile != null) {
					cdWetTensileVal = NumberUtils.toDouble(cdWetTensile, 0);
				}
				reelObj.setCdWetTensile(cdWetTensileVal);

				String cdTensileRatio = cdTensileRatios.get(i);
				double cdTensileRatioVal = 0;
				if (cdTensileRatio != null) {
					cdTensileRatioVal = NumberUtils.toDouble(cdTensileRatio, 0);
				}
				reelObj.setWetDryRatio(cdTensileRatioVal);

				String brightness = brightnesss.get(i);
				double brightnessVal = 0;
				if (brightness != null) {
					brightnessVal = NumberUtils.toDouble(brightness, 0);
				}
				reelObj.setBrightness(brightnessVal);

				String fwaFlow = fwaFlows.get(i);
				double fwaFlowVal = 0;
				if (fwaFlow != null) {
					fwaFlowVal = NumberUtils.toDouble(fwaFlow, 0);
				}
				reelObj.setFwaFlow(fwaFlowVal);

				//
				String akd = akds.get(i);
				double akdVal = 0;
				if (akd != null) {
					akdVal = NumberUtils.toDouble(akd, 0);
				}
				reelObj.setAkd(akdVal);

				String wetstrength = wetstrengths.get(i);
				double wetstrengthVal = 0;
				if (wetstrength != null) {
					wetstrengthVal = NumberUtils.toDouble(wetstrength, 0);
				}
				reelObj.setWetstrength(wetstrengthVal);

				String drystrengthflow = drystrengthflows.get(i);
				double drystrengthflowVal = 0;
				if (drystrengthflow != null) {
					drystrengthflowVal = NumberUtils.toDouble(drystrengthflow, 0);
				}
				reelObj.setDrystrengthflow(drystrengthflowVal);

				//

				String dirtCount = dirtCounts.get(i);
				double dirtCountVal = 0;
				if (dirtCount != null) {
					dirtCountVal = NumberUtils.toDouble(dirtCount, 0);
				}
				reelObj.setDirtCount(dirtCountVal);

				String fwaDosage = fwaDosages.get(i);
				double fwaDosageVal = 0;
				if (fwaDosage != null) {
					fwaDosageVal = NumberUtils.toDouble(fwaDosage, 0);
				}
				reelObj.setFwaDosage(fwaDosageVal);

				String tph = tphs.get(i);
				double tphVal = 0;
				if (tph != null) {
					tphVal = NumberUtils.toDouble(tph, 0);
				}
				reelObj.setTph(tphVal);

				String trim = trims.get(i);
				double trimVal = 0;
				if (trim != null) {
					trimVal = NumberUtils.toDouble(trim, 0);
				}
				reelObj.setTrim(trimVal);

				String crepeRatio = crepeRatios.get(i);
				double crepeRatioVal = 0;
				if (crepeRatio != null) {
					crepeRatioVal = NumberUtils.toDouble(crepeRatio, 0);
				}
				reelObj.setCrepeRatio(crepeRatioVal);
//				Code Starts From Here Done By Roshan Tailor Date :-03/10/2015 DD/MM/YYYY
				String lvalue = lvalues.get(i);
				double lvalueVal = 0;
				if (lvalue != null) {
					lvalueVal = NumberUtils.toDouble(lvalue, 0);
				}
				reelObj.setLvalue(lvalueVal);

				String avalue = avalues.get(i);
				double avalueVal = 0;
				if (avalue != null) {
					avalueVal = NumberUtils.toDouble(avalue, 0);
				}
				reelObj.setAvalue(avalueVal);

				String bvalue = bvalues.get(i);
				double bvalueVal = 0;
				if (bvalue != null) {
					bvalueVal = NumberUtils.toDouble(bvalue, 0);
				}
				reelObj.setBvalue(bvalueVal);

				String deltae = deltaes.get(i);
				double deltaeVal = 0;
				if (deltae != null) {
					deltaeVal = NumberUtils.toDouble(deltae, 0);
				}
				reelObj.setDeltae(deltaeVal);
//				Code Ends Here Done By Roshan Tailor

				String customer = customers.get(i);
				if (customer == null) {
					customer = "";
				}
				reelObj.setCustomer(customer);
				
				
				String customer1 = customers1.get(i);
				if (customer1 == null) {
					customer1 = "";
				}
				reelObj.setCustomer1(customer1);
				
				
				String customer2 = customers2.get(i);
				if (customer2 == null) {
					customer2 = "";
				}
				reelObj.setCustomer2(customer2);
				

				String remarks = remarkss.get(i);
				if (remarks == null) {
					remarks = "";
				}
				reelObj.setRemarks(remarks);

				if (reelObj.getId() != 0) {
					reelUpdateList.add(reelObj);
				}
			}
		}

		try {
			for (ReelPM5 reel : reelUpdateList) {
				reelServicePM5.update(reel);
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
	public void validateReelData(HttpServletRequest request, HttpServletResponse response) {

		response.setContentType("application/json");

		String value = request.getParameter("value");
		double val = NumberUtils.toDouble(value, 0);

		String sminR=request.getParameter("minR");
		String smaxR=request.getParameter("maxR");
		String sminC=request.getParameter("minC");
		String smaxC=request.getParameter("maxC");
		String starget=request.getParameter("target");
		double minR=0;double maxR=0;double minC=0;double maxC=0;double target=0;
		if(sminR!=null&&!sminR.isBlank())
		 minR=CommonUtil.checkDouble(sminR);
		if(smaxR!=null&&!smaxR.isBlank())
		 maxR=CommonUtil.checkDouble(smaxR);
		if(sminC!=null&&!sminC.isBlank())
		 minC=CommonUtil.checkDouble(sminC);
		if(smaxC!=null&&!smaxC.isBlank())
		 maxC=CommonUtil.checkDouble(smaxC);
		if(starget!=null&&!starget.isBlank())
		 target=CommonUtil.checkDouble(starget);

		int color = 0;
		if (val != 0) {
			color = GradeTargetUtil.checkRange(val, minR, maxR, minC, maxC, target);
		}

		Map<String, Integer> map = new HashMap<>();
		map.put("color", color);
		try {
			response.getWriter().write(new Gson().toJson(map));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "/reelnocheck", method = RequestMethod.POST)
	public void validateReelNumber(HttpServletRequest request, HttpServletResponse response) {

		response.setContentType("application/json");

		String value = request.getParameter("value");

		boolean flag = reelServicePM5.isReelNumberExist(value);
		Map<String, Boolean> map = new HashMap<>();
		map.put("flag", flag);

		try {
			response.getWriter().write(new Gson().toJson(map));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public void deleteReel(HttpServletRequest request, HttpServletResponse response) {

		response.setContentType("application/json");

		String ids = request.getParameter("ids");

		if (ids == null) {
			ids = "";
		}

		List<String> idsList = Arrays.asList(ids.split(","));

		if (idsList.size() != 0) {
			reelServicePM5.delete(idsList);
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

	@RequestMapping(value = "/reelinfo", method = RequestMethod.GET)
	public String getReelInfo(Model model) throws IOException {
		model.addAttribute("showFlag", false);
		return "PM5/reelInfo";
	}

	@RequestMapping(value = "/reelinfo/data", method = RequestMethod.GET)
	public String getReelInfo(HttpServletRequest request, Model model) throws IOException {

		String reelNo = CommonUtil.checkNull(request.getParameter("reel"));

		List<ReelPM5> reels = reelServicePM5.getReelByReelNo(reelNo);

		model.addAttribute("reel", reelNo);
		model.addAttribute("showFlag", true);
		model.addAttribute("reels", reels);

		return "PM5/reelInfo";
	}

	@RequestMapping(value = "/findmatch", method = RequestMethod.POST)
	public String findMatchGrade(HttpServletRequest request, Model model) {

		ReelPM5 reel = new ReelPM5();
		String gradeCode = CommonUtil.checkNull(request.getParameter("gradeCode"));
		reel.setGradeCode(gradeCode);
		double actualBasisWt = CommonUtil.checkDouble(request.getParameter("actualBasisWt"));
		reel.setActualBasisWt(actualBasisWt);
		double mdTensile = CommonUtil.checkDouble(request.getParameter("mdTensile"));
		reel.setMdTensile(mdTensile);
		double cdTensile = CommonUtil.checkDouble(request.getParameter("cdTensile"));
		reel.setCdTensile(cdTensile);
		double bulk = CommonUtil.checkDouble(request.getParameter("bulk"));
		reel.setBulk(bulk);
		double mdStretch = CommonUtil.checkDouble(request.getParameter("mdStretch"));
		reel.setMdStretch(mdStretch);
		double mdWetTensile = CommonUtil.checkDouble(request.getParameter("mdWetTensile"));
		reel.setMdWetTensile(mdWetTensile);
		double cdWetTensile = CommonUtil.checkDouble(request.getParameter("cdWetTensile"));
		reel.setCdWetTensile(cdWetTensile);
		double brightness = CommonUtil.checkDouble(request.getParameter("brightness"));
		reel.setBrightness(brightness);
		double mdcdTensileRatio = CommonUtil.checkDouble(request.getParameter("mdcdTensileRatio"));
		reel.setMdcdTensileRatio(mdcdTensileRatio);
		double cdTensileRatio = CommonUtil.checkDouble(request.getParameter("cdTensileRatio"));
		reel.setWetDryRatio(cdTensileRatio);
		double dirtCount = CommonUtil.checkDouble(request.getParameter("dirtCount"));
		reel.setDirtCount(dirtCount);

		List<Map<String, Object>> result = reelServicePM5.findMatch(reel);

		model.addAttribute("result", result);

		return "PM5/reelFindMatch";
	}

	@RequestMapping(value = "/getCurrentData", method = RequestMethod.POST)
	public void currentData(HttpServletRequest request, HttpServletResponse response) throws IOException {

		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Map<String, String> map = new HashMap<>();

		String CurrentReelNumberByAajx = CommonUtil.checkNull(request.getParameter("reelNumber"));
		String CurrentGradeCodeByAjax = CommonUtil.checkNull(request.getParameter("gradeCode"));

		int i = Integer.parseInt(CurrentReelNumberByAajx);
		String CurrentReelDB = reelServicePM5.getcurrentreel(CurrentReelNumberByAajx, CurrentGradeCodeByAjax);
		String LastRecordedGradeCode = reelServicePM5.getlastgradecode();

		int j = Integer.parseInt(CurrentReelDB);
		int reeldiffrence = j - i;

		if ((((reeldiffrence > 0) || (reeldiffrence < 0)) && (CurrentGradeCodeByAjax.equals(LastRecordedGradeCode)))
				|| ((reeldiffrence > 0) && (!CurrentGradeCodeByAjax.equals(LastRecordedGradeCode)))) {
			// map.put("stopentry", "stop");
			map.put("doentry", "move");
			String date = dateFormat.format(new Date());
			map.put("date", date);
			map.put("time", timeFormat.format(new Date()));
			map.put("reel", (NumberUtils.toInt(reelServicePM5.getMaxReel(), 0) + 1) + "");
			response.setContentType("application/json");
			response.getWriter().write(new Gson().toJson(map));
		}
		if (((reeldiffrence == 0) && !(CurrentGradeCodeByAjax.equals(LastRecordedGradeCode)))
				|| ((reeldiffrence == 0) && (CurrentGradeCodeByAjax.equals(LastRecordedGradeCode)))) {
			map.put("doentry", "move");
			String date = dateFormat.format(new Date());
			map.put("date", date);
			map.put("time", timeFormat.format(new Date()));
			map.put("reel", (NumberUtils.toInt(reelServicePM5.getMaxReel(), 0) + 1) + "");
			response.setContentType("application/json");
			response.getWriter().write(new Gson().toJson(map));
		}

//		map.put("doentry", "move");
//		String date=dateFormat.format(new Date());
//		map.put("date", date);
//		map.put("time", timeFormat.format(new Date()));
//		map.put("reel",( NumberUtils.toInt(reelService.getMaxReel(), 0)+1)+"");
//		response.setContentType("application/json");
//		response.getWriter().write(new Gson().toJson(map));
	}
//	Code Ends Here Done By Roshan Tailor

	@RequestMapping(value = "/brightness/info", method = RequestMethod.POST)
	public void getBrightnessAvg(HttpServletRequest request, HttpServletResponse response) throws IOException {

		String grade = CommonUtil.checkNull(request.getParameter("grade"));

		// System.out.println("Grade Code="+grade);

		// FRP Brightness average
		double frpBrightnessAvg = frpPressQualityService.getBirghtnessAvgOfLastDay();
		// System.out.println("frpBrightnessAvg"+frpBrightnessAvg);
		// FRP Brightness average
		double machBrightnessAvg = reelServicePM5.getBirghtnessAvgOfLastDay(grade);

		List<Map<String, Object>> frpBrightness = frpPressQualityService.getBirghtness();

		List<String> data = new ArrayList<String>();

		Map<String, Object> map = new HashMap<>();

		SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy h:mma");

		for (Map<String, Object> map2 : frpBrightness) {
			Date date = (Date) map2.get("DATE");
			StringBuilder builder = new StringBuilder();
			builder.append(format.format(date));
			builder.append("&nbsp;&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;&nbsp;" + map2.get("BRIGHTNESS"));
			data.add(builder.toString());
		}

		map.put("frpBrightnessAvg", CommonUtil.round(frpBrightnessAvg, 2));
		map.put("machBrightnessAvg", CommonUtil.round(machBrightnessAvg, 2));

		map.put("blist", data);

		/// Get White Ton/Red Ton/Reject Ton

		WrapperProduction wrapperData = wrapperProductionService.getWrapperTonsOfShift();

		map.put("wrapperData", wrapperData);

		// System.out.println(wrapperData.getWhiteWeight());
		// System.out.println(wrapperData.getRedWeight());
		// System.out.println(wrapperData.getRejectWeight());

		response.setContentType("application/json");

		response.getWriter().write(new Gson().toJson(map));
	}

}

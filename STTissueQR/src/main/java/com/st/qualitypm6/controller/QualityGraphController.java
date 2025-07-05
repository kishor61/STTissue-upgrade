/**
 *Dec 12, 2014
 *ReelRwinderGraphController.java
 * TODO
 *com.st.qualitypm6.controller
 *ReelRwinderGraphController.java
 *Sunil Singh Bora
 */
package com.st.qualitypm6.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.st.common.CommonUtil;
import com.st.common.GradeTargetUtil;
import com.st.qualitypm6.model.GradeTarget;
import com.st.qualitypm6.model.QualityGraph;
import com.st.qualitypm6.model.QualityGraphDataPoint;
import com.st.qualitypm6.model.Reel;
import com.st.qualitypm6.model.Rewind;
import com.st.qualitypm6.report.QualityReportHandler;
import com.st.qualitypm6.service.CustomerService;
import com.st.qualitypm6.service.GradeService;
import com.st.qualitypm6.service.GradeTargetService;
import com.st.qualitypm6.service.ReelService;
import com.st.qualitypm6.service.RewindService;

/**
 * @author sbora 
 *
 */
@Controller
@RequestMapping("/qualitygraph")
public class QualityGraphController {
	
	@Autowired
	private GradeService gradeService;
	
	@Autowired
	private GradeTargetService gradeTargetService;
	
	@Autowired
	private CustomerService customerService;

	@Autowired
	private ReelService reelService;
	
	@Autowired
	private QualityReportHandler qualityReportHandler;
	
	@Autowired 
	private RewindService rewindService;
	
	private SimpleDateFormat dateFormat=new SimpleDateFormat("MM-dd-yyyy");
	
	@RequestMapping("/main")
	public String main(Model model) {
		/*model.addAttribute("grades", gradeService.getGrades());*/
		model.addAttribute("sdate", dateFormat.format(new Date()));
		model.addAttribute("edate", dateFormat.format(new Date()));
		model.addAttribute("customers", customerService.getCustomers());
		
		return "reelRewinderGraph";
	}
	
	@RequestMapping("/main/grade")
	public String graph(@RequestParam("sdate")String sdate,
			@RequestParam("edate")String edate,
			@RequestParam("customer")String customer,
			Model model) {
		model.addAttribute("sdate", sdate);
		model.addAttribute("edate", edate);
		model.addAttribute("customer", customer);
		model.addAttribute("customers", customerService.getCustomers());
		
		
		List<String> grades=reelService.getGrades(CommonUtil.checkDate(sdate, dateFormat),CommonUtil.checkDate(edate, dateFormat),customer);
		model.addAttribute("grades", grades);

		return "reelRewinderGraph";
	}
	
	@RequestMapping("/graph")
	public String graph(@RequestParam("sdate")String sdate,
			@RequestParam("edate")String edate,
			@RequestParam("gradeCode")String gradeCode,
			@RequestParam("customer")String customer,
			Model model) {
		
		model.addAttribute("gradeCode",gradeCode);
		model.addAttribute("sdate", sdate);
		model.addAttribute("edate", edate);
		model.addAttribute("customer", customer);

		return "reelRewinderGraphIframe";
	}
	
	@RequestMapping(value="/graph/data",method=RequestMethod.POST)
	public @ResponseBody QualityGraph graphData(@RequestParam("sdate")String sdate,
			@RequestParam("edate")String edate,
			@RequestParam("gradeCode")String gradeCode,
			@RequestParam("customer")String customer
			) {
		
		QualityGraph qualityGraph=new QualityGraph();
		
		List<GradeTarget> gradeTargets=gradeTargetService.getGradeTarget(gradeCode);
		
		if(gradeTargets.size()>0){
			GradeTarget GP01=GradeTargetUtil.getGradeTarget(gradeTargets, GradeTargetUtil.GP01);
			GradeTarget GP02=GradeTargetUtil.getGradeTarget(gradeTargets, GradeTargetUtil.GP02);
			GradeTarget GP03=GradeTargetUtil.getGradeTarget(gradeTargets, GradeTargetUtil.GP03);
			GradeTarget GP04=GradeTargetUtil.getGradeTarget(gradeTargets, GradeTargetUtil.GP04);
			GradeTarget GP06=GradeTargetUtil.getGradeTarget(gradeTargets, GradeTargetUtil.GP06);
			GradeTarget GP08=GradeTargetUtil.getGradeTarget(gradeTargets, GradeTargetUtil.GP08);
			
			
			if(GP01!=null){
				qualityGraph.setActualBasisTarget(GP01.getTarget());
				qualityGraph.setActualBasisMinR(GP01.getRejectMin());
				qualityGraph.setActualBasisMaxR(GP01.getRejectMax());
			}
			
			if(GP02!=null){
				qualityGraph.setBrightnessTarget(GP02.getTarget());
				qualityGraph.setBrightnessMinR(GP02.getRejectMin());
				qualityGraph.setBrightnessMaxR(GP02.getRejectMax());
			}
			
			
			if(GP03!=null){
				qualityGraph.setBulkTarget(GP03.getTarget());
				qualityGraph.setBulkMinR(GP03.getRejectMin());
				qualityGraph.setBulkMaxR(GP03.getRejectMax());
			}
			
			if(GP04!=null){
				qualityGraph.setMdTensileTarget(GP04.getTarget());
				qualityGraph.setMdTensileMinR(GP04.getRejectMin());
				qualityGraph.setMdTensileMaxR(GP04.getRejectMax());
			}
			
			if(GP06!=null){
				qualityGraph.setCdTensileTarget(GP06.getTarget());
				qualityGraph.setCdTensileMinR(GP06.getRejectMin());
				qualityGraph.setCdTensileMaxR(GP06.getRejectMax());
			}
			
			if(GP08!=null){
				qualityGraph.setMdStretchTarget(GP08.getTarget());
				qualityGraph.setMdStretchMinR(GP08.getRejectMin());
				qualityGraph.setMdStretchMaxR(GP08.getRejectMax());
			}
		}
		
		SimpleDateFormat formatDateTime=new SimpleDateFormat("yyyy-MM-dd h:mma");
		
		List<Reel> reels=reelService.getReelData(CommonUtil.checkDate(sdate, dateFormat), CommonUtil.checkDate(edate, dateFormat), gradeCode, customer,"","");
		
		List<QualityGraphDataPoint> actualBasisReels=new ArrayList<>();
		List<QualityGraphDataPoint> bulkReels=new ArrayList<>();
		List<QualityGraphDataPoint> mdTensileReels=new ArrayList<>();
		List<QualityGraphDataPoint> cdTensileReels=new ArrayList<>();
		List<QualityGraphDataPoint> mdStretchReels=new ArrayList<>();
		List<QualityGraphDataPoint> brightnessReels=new ArrayList<>();

		
		List<String> reelList=new ArrayList<String>();
		for (Reel reel : reels) {
			actualBasisReels.add(new QualityGraphDataPoint(formatDateTime.format(reel.getDate()),reel.getActualBasisWt(),reel.getReel()));
			bulkReels.add(new QualityGraphDataPoint(formatDateTime.format(reel.getDate()),reel.getBulk(),reel.getReel()));
			mdTensileReels.add(new QualityGraphDataPoint(formatDateTime.format(reel.getDate()),reel.getMdTensile(),reel.getReel()));
			cdTensileReels.add(new QualityGraphDataPoint(formatDateTime.format(reel.getDate()),reel.getCdTensile(),reel.getReel()));
			mdStretchReels.add(new QualityGraphDataPoint(formatDateTime.format(reel.getDate()),reel.getMdStretch(),reel.getReel()));
			brightnessReels.add(new QualityGraphDataPoint(formatDateTime.format(reel.getDate()),reel.getBrightness(),reel.getReel()));
			
			reelList.add(reel.getReel());
		}
		
		qualityGraph.setActualBasisReels(actualBasisReels);
		qualityGraph.setBulkReels(bulkReels);
		qualityGraph.setMdStretchReels(mdStretchReels);
		qualityGraph.setCdTensileReels(cdTensileReels);
		qualityGraph.setMdTensileReels(mdTensileReels);
		qualityGraph.setBrightnessReels(brightnessReels);
		
		
		
		
		List<Rewind> rewinds=rewindService.getRewindByGradeCustomerGraph(reelList, gradeCode, customer);
		
		List<QualityGraphDataPoint> actualBasisRewinds=new ArrayList<>();
		List<QualityGraphDataPoint> bulkRewinds=new ArrayList<>();
		List<QualityGraphDataPoint> mdTensileRewinds=new ArrayList<>();
		List<QualityGraphDataPoint> cdTensileRewinds=new ArrayList<>();
		List<QualityGraphDataPoint> mdStretchRewinds=new ArrayList<>();
		List<QualityGraphDataPoint> brightnessRewinds=new ArrayList<>();
		
		for (Rewind rewind : rewinds) {
			{
				QualityGraphDataPoint dataPoint=new QualityGraphDataPoint(rewind.getReel());
				if(actualBasisReels.contains(dataPoint)){
					dataPoint=actualBasisReels.get(actualBasisReels.indexOf(dataPoint));
					actualBasisRewinds.add(new QualityGraphDataPoint(dataPoint.getX(), rewind.getActualBasisWt(),dataPoint.getReel()));
				}
			}
			
			
			{
				QualityGraphDataPoint dataPoint=new QualityGraphDataPoint(rewind.getReel());
				if(bulkReels.contains(dataPoint)){
					dataPoint=bulkReels.get(bulkReels.indexOf(dataPoint));
					bulkRewinds.add(new QualityGraphDataPoint(dataPoint.getX(), rewind.getBulk(),dataPoint.getReel()));
				}
			}
			
			{
				QualityGraphDataPoint dataPoint=new QualityGraphDataPoint(rewind.getReel());
				if(mdTensileReels.contains(dataPoint)){
					dataPoint=mdTensileReels.get(mdTensileReels.indexOf(dataPoint));
					mdTensileRewinds.add(new QualityGraphDataPoint(dataPoint.getX(), rewind.getMdTensile(),dataPoint.getReel()));
					
				}
			}
			
			{
				QualityGraphDataPoint dataPoint=new QualityGraphDataPoint(rewind.getReel());
				if(cdTensileReels.contains(dataPoint)){
					dataPoint=cdTensileReels.get(cdTensileReels.indexOf(dataPoint));
					cdTensileRewinds.add(new QualityGraphDataPoint(dataPoint.getX(), rewind.getCdTensile(),dataPoint.getReel()));
					
				}
			}
			
			{
				QualityGraphDataPoint dataPoint=new QualityGraphDataPoint(rewind.getReel());
				if(mdStretchReels.contains(dataPoint)){
					dataPoint=mdStretchReels.get(mdStretchReels.indexOf(dataPoint));
					mdStretchRewinds.add(new QualityGraphDataPoint(dataPoint.getX(), rewind.getMdStretch(),dataPoint.getReel()));
				}
			}
			
			{
				QualityGraphDataPoint dataPoint=new QualityGraphDataPoint(rewind.getReel());
				if(brightnessReels.contains(dataPoint)){
					dataPoint=brightnessReels.get(brightnessReels.indexOf(dataPoint));
					brightnessRewinds.add(new QualityGraphDataPoint(dataPoint.getX(), rewind.getMdStretch(),dataPoint.getReel()));
				}
			}
			
			
		}
		
		qualityGraph.setActualBasisRewinds(actualBasisRewinds);
		
		qualityGraph.setBulkRewinds(bulkRewinds);
		qualityGraph.setMdTensileRewinds(mdTensileRewinds);
		qualityGraph.setCdTensileRewinds(cdTensileRewinds);
		qualityGraph.setMdStretchRewinds(mdStretchRewinds);
		qualityGraph.setBrightnessRewinds(brightnessRewinds);
		
		return qualityGraph;
	}

	
	
	@RequestMapping(value="/export/pdf",method=RequestMethod.POST)
	public void export(
			@RequestParam("actualBasisflag")boolean actualBasisflag,
			@RequestParam("actualBasis")String actualBasis,
			
			@RequestParam("bulkflag")boolean bulkflag,
			@RequestParam("bulk")String bulk,
			
			@RequestParam("mdTensileflag")boolean mdTensileflag,
			@RequestParam("mdTensile")String mdTensile,
			
			@RequestParam("cdTensileflag")boolean cdTensileflag,
			@RequestParam("cdTensile")String cdTensile,
			
			@RequestParam("mdStrechflag")boolean mdStrechflag,
			@RequestParam("mdStrech")String mdStrech,
			
			@RequestParam("brightnessflag")boolean brightnessflag,
			@RequestParam("brightness")String brightness,
			
			HttpServletResponse response) throws Exception {
		
		response.setContentType("application/pdf");
		
		qualityReportHandler.createQualityGraphReport(actualBasisflag,actualBasis,
				bulkflag,bulk,
				mdTensileflag,mdTensile,
				cdTensileflag,cdTensile,
				mdStrechflag,mdStrech,
				brightnessflag,brightness,
				response.getOutputStream());
	}
	
}

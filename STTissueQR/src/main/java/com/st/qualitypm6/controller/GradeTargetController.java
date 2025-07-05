package com.st.qualitypm6.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import jakarta.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.math.NumberUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.st.qualitypm6.model.GradeTarget;
import com.st.qualitypm6.service.GradeService;
import com.st.qualitypm6.service.GradeTargetService;

@Controller
@RequestMapping(value="/gradetarget")
public class GradeTargetController {
	
	private static Logger logger=Logger.getLogger(GradeTargetController.class);
	
	@Autowired
	private GradeService gradeService;
	
	@Autowired
	private GradeTargetService gradeTargetService;
	
	
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String addNewGrade(Model model){
		model.addAttribute("grades", gradeService.getGrades());
		return "gradeTargetAdd";
	}
	
	@RequestMapping(value="/add/{gradeCode}",method=RequestMethod.GET)
	public String addNewGrade(@PathVariable("gradeCode") String gradeCode,Model model){
		model.addAttribute("grades", gradeService.getGrades());
		model.addAttribute("gradesTargets", gradeTargetService.getGradeTargets(gradeCode));
		model.addAttribute("gradeCode", gradeCode);
		model.addAttribute("showForm", true);
		
		return "gradeTargetAdd";
	}
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String saveNewGrade(HttpServletRequest request ,RedirectAttributes redirectAttributes,Model model){
		
		String gradeCode=request.getParameter("gradeCode");
		if(gradeCode.trim().equals("")){
			redirectAttributes.addFlashAttribute("error", "Grade code is not valid.");
		}else{
		
			List<String> propIds=Arrays.asList(request.getParameterValues("PhysicalPropertyID"));
			List<String> minRejects=Arrays.asList(request.getParameterValues("minReject"));
			List<String> minControls=Arrays.asList(request.getParameterValues("minControl"));
			List<String> targets=Arrays.asList(request.getParameterValues("target"));
			List<String> maxControls=Arrays.asList(request.getParameterValues("maxControl"));
			List<String> maxRejects=Arrays.asList(request.getParameterValues("maxReject"));
			List<String> notes=Arrays.asList(request.getParameterValues("note"));
		
			List<GradeTarget> gradeTargets=new ArrayList<GradeTarget>();
 			
			for(int i=0;i<propIds.size();i++){
				if(propIds!=null && !propIds.equals("")){
					GradeTarget gradeTarget=new GradeTarget();
					
					String probId=propIds.get(i);
					gradeTarget.setPhysicalProperty(probId);
					
					String minReject=minRejects.get(i);
					double minR=0;
					if(minReject!=null){
						minR=NumberUtils.toDouble(minReject,0);
					}
					gradeTarget.setRejectMin(minR);
					
					String minControl=minControls.get(i);
					double minC=0;
					if(minControl!=null){
						minC=NumberUtils.toDouble(minControl,0);
					}
					gradeTarget.setControlMin(minC);
					
					String target=targets.get(i);
					double t=0;
					if(target!=null){
						t=minC=NumberUtils.toDouble(target,0);
					}
					gradeTarget.setTarget(t);
					
					String maxControl=maxControls.get(i);
					double maxC=0;
					if(maxControl!=null){
						maxC=NumberUtils.toDouble(maxControl,0);
					}
					gradeTarget.setControlMax(maxC);
					
					String maxReject=maxRejects.get(i);
					double maxR=0;
					if(maxReject!=null ){
						maxR=maxC=NumberUtils.toDouble(maxReject,0);
					}
					gradeTarget.setRejectMax(maxR);
					
					
					String note=notes.get(i);
					if(note==null){
						note="";
					}
					gradeTarget.setNote(note);
					
					gradeTarget.setGradeCode(gradeCode);
					
					gradeTargets.add(gradeTarget);
				}
				
				
			}
			try{
				gradeTargetService.save(gradeTargets);
			}catch(Exception e){
				logger.error("Error in saving in gradeTargets", e);
				e.printStackTrace();
				redirectAttributes.addFlashAttribute("error", "Fail to save data in master table.");
			}
			
			
			redirectAttributes.addFlashAttribute("message", "Data saved successfully.");
		}
		
		
		
		
		
		
		return "redirect:/gradetarget/add/"+gradeCode;
	}
}

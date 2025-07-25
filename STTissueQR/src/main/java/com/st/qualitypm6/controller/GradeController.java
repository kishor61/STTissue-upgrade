package com.st.qualitypm6.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;


import jakarta.servlet.http.HttpServletRequest;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.st.common.CommonUtil;
import com.st.qualitypm6.model.Grade;
import com.st.qualitypm6.model.GradeTarget;
import com.st.qualitypm6.service.CustomerService;
import com.st.qualitypm6.service.GradeService;
import com.st.qualitypm6.service.GradeTargetService;

@Controller
@RequestMapping(value="/grade")
public class GradeController {

	private static final String NEW_PAGE="newpage";
	private static final String EDIT_PAGE="editpage";
	private static final String VIEW_PAGE="viewpage";
	private SimpleDateFormat dateFormat=new SimpleDateFormat("MM/dd/yyyy");
	
	//private Logger logger=Logger.getLogger(GradeController.class);
	
	@Autowired
	private GradeService gradeService;
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private GradeTargetService gradeTargetService;
	

	
	@RequestMapping(value="/main",method=RequestMethod.GET)
	public String main(Model model){
		
	//	model.addAttribute("customers", customerService.getCustomers());
		
		model.addAttribute("grades", gradeService.getGrades());
		
		return "grade";
	}
	
	@RequestMapping(value="/new",method=RequestMethod.GET)
	public String newGrade(Model model){
		
		model.addAttribute(NEW_PAGE, true);
		model.addAttribute(VIEW_PAGE, false);
		model.addAttribute(EDIT_PAGE, false);
		
		model.addAttribute("customers", customerService.getCustomers());
		model.addAttribute("grades", gradeService.getGrades());
		model.addAttribute("gradeProperties", gradeService.getGradesProperties());
		
		return "grade";
	}
	
	@RequestMapping(value="/edit/{gradeCode}",method=RequestMethod.GET)
	public String editGrade(@PathVariable("gradeCode")String gradeCode,Model model){
		
		model.addAttribute(NEW_PAGE, false);
		model.addAttribute(VIEW_PAGE, false);
		model.addAttribute(EDIT_PAGE, true);
		model.addAttribute("gradeCode", gradeCode);
		model.addAttribute("grades", gradeService.getGrades());
		
		model.addAttribute("customers", customerService.getCustomers());
		
		
		Grade grade=gradeService.getGrade(gradeCode);
		
		model.addAttribute("grade", grade);
		
		
		if(grade!=null){
			List<GradeTarget> gradeTargets=gradeTargetService.getGradeTargets(gradeCode);
			model.addAttribute("gradeTargets", gradeTargets);
		}
		
		model.addAttribute("grades", gradeService.getGrades());
		
		return "grade";
	}
	
	@RequestMapping(value="/view/{gradeCode}",method=RequestMethod.GET)
	public String viewGrade(@PathVariable("gradeCode")String gradeCode,Model model){
		
		model.addAttribute(NEW_PAGE, false);
		model.addAttribute(VIEW_PAGE, true);
		model.addAttribute(EDIT_PAGE, false);
		model.addAttribute("gradeCode", gradeCode);
		
		Grade grade=gradeService.getGrade(gradeCode);
		
		model.addAttribute("grade", grade);
		
		if(grade!=null){
			List<GradeTarget> gradeTargets=gradeTargetService.getGradeTargets(gradeCode);
			model.addAttribute("gradeTargets", gradeTargets);
		}
		
		model.addAttribute("grades", gradeService.getGrades());
		
		return "grade";
	}
	@RequestMapping(value="/print/{gradeCode}",method=RequestMethod.GET)
	public String printGrade(@PathVariable("gradeCode")String gradeCode,Model model){
		
		Grade grade=gradeService.getGrade(gradeCode);
		
		model.addAttribute("grade", grade);
		
		if(grade!=null){
			List<GradeTarget> gradeTargets=gradeTargetService.getGradeTargets(gradeCode);
			model.addAttribute("gradeTargets", gradeTargets);
		}
		
		model.addAttribute("grades", gradeService.getGrades());
		
		return "gradePrint";
	}
	
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String updateGrade(HttpServletRequest request,RedirectAttributes redirectAttributes,Model model){
		
		model.addAttribute(NEW_PAGE, false);
		model.addAttribute(VIEW_PAGE, true);
		model.addAttribute(EDIT_PAGE, false);
		
		model.addAttribute("grades", gradeService.getGrades());
		
		
		String gradeCode=request.getParameter("gradeCode");
		
		if(gradeCode!=null && !gradeCode.trim().equals("")){
			
			Grade grade=new Grade();
			grade.setGradeCode(gradeCode);
			
			String revisionDate=request.getParameter("revisionDate");
			Date date=null;
			try {
				date=dateFormat.parse(revisionDate);
			} catch (Exception e) {
				e.fillInStackTrace();
				date=new Date();
			}
			grade.setRevisionDate(date);
			
			String tmNo=request.getParameter("tmNo");
			if(tmNo==null){
				tmNo="";
			}
			grade.setTmNo(tmNo);
			
			String description=request.getParameter("description");
			if(description==null){
				description="";
			}
			grade.setDescription(description);
			
			String customerGrade=request.getParameter("customerGrade");
			if(customerGrade==null){
				customerGrade="";
			}
			grade.setCustomerGrade(customerGrade);
			
			String customer=request.getParameter("customer");
			if(customer==null){
				customer="";
			}
			grade.setCustomer(customer);
			
			String tissueApproval=request.getParameter("tissueApproval");
			if(tissueApproval==null){
				tissueApproval="";
			}
			grade.setTissueApproval(tissueApproval);
			
			String customerApproval=request.getParameter("customerApproval");
			if(customerApproval==null){
				customerApproval="";
			}
			grade.setCustomerApproval(customerApproval);
			
			String notes=request.getParameter("notes");
			if(notes==null){
				notes="";
			}
			grade.setNotes(notes);
			
			String visualStandard=request.getParameter("visualStandard");
			if(visualStandard==null){
				visualStandard="";
			}
			grade.setVisualStandard(visualStandard);
			
			String trimMin=request.getParameter("trimMin");
			if(trimMin==null){
				trimMin="";
			}
			grade.setTrimMin(trimMin);
			
			String trimTarget=request.getParameter("trimTarget");
			if(trimTarget==null){
				trimTarget="";
			}
			grade.setTrimTarget(trimTarget);
			
			String trimMax=request.getParameter("trimMax");
			if(trimMax==null){
				trimMax="";
			}
			grade.setTrimMax(trimMax);
			
			String diameterMin=request.getParameter("diameterMin");
			if(diameterMin==null){
				diameterMin="";
			}
			grade.setDiameterMin(diameterMin);
			
			String diameterTarget=request.getParameter("diameterTarget");
			if(diameterTarget==null){
				diameterTarget="";
			}
			grade.setDiameterTarget(diameterTarget);
			
			String diameterMax=request.getParameter("diameterMax");
			if(diameterMax==null){
				diameterMax="";
			}
			grade.setDiameterMax(diameterMax);
			
			String breakMin=request.getParameter("breakMin");
			if(breakMin==null){
				breakMin="";
			}
			grade.setBreakMin(breakMin);
			
			String breakTarget=request.getParameter("breakTarget");
			if(breakTarget==null){
				breakTarget="";
			}
			grade.setBreakTarget(breakTarget);
			
			String breakMax=request.getParameter("breakMax");
			if(breakMax==null){
				breakMax="";
			}
			grade.setBreakMax(breakMax);;
			
			String specialInstruction=request.getParameter("specialInstruction");
			if(specialInstruction==null){
				specialInstruction="";
			}
			grade.setSpecialInstruction(specialInstruction);;
			
			
			
			List<String> physicalProperty=Arrays.asList(request.getParameterValues("physicalProperty"));
			List<String> rejectMin=Arrays.asList(request.getParameterValues("rejectMin"));
			List<String> controlMin=Arrays.asList(request.getParameterValues("controlMin"));
			List<String> target=Arrays.asList(request.getParameterValues("target"));
			List<String> controlMax=Arrays.asList(request.getParameterValues("controlMax"));
			List<String> rejectMax=Arrays.asList(request.getParameterValues("rejectMax"));
			List<String> note=Arrays.asList(request.getParameterValues("note"));
			
			List<GradeTarget> gradeTargets=new ArrayList<>();
			
			if(physicalProperty!=null &&
					rejectMin!=null &&
					controlMin!=null &&
					target!=null &&
					controlMax!=null &&
					rejectMax!=null &&
					note!=null){
				
				
				for (int i = 0; i < physicalProperty.size(); i++) {
					
					
					String prop=physicalProperty.get(i);
					if(prop!=null && !prop.trim().equals("")){
						
						try{
							GradeTarget gradeTarget=new GradeTarget();
							gradeTarget.setPhysicalProperty(prop);
							gradeTarget.setGradeCode(gradeCode);
							
							double rejMin=NumberUtils.toDouble(rejectMin.get(i), 0);
							gradeTarget.setRejectMin(rejMin);
							
							double conMin=NumberUtils.toDouble(controlMin.get(i), 0);
							gradeTarget.setControlMin(conMin);
							
							double targ=NumberUtils.toDouble(target.get(i), 0);
							gradeTarget.setTarget(targ);
							
							double conMax=NumberUtils.toDouble(controlMax.get(i), 0);
							gradeTarget.setControlMax(conMax);
							
							double rejMax=NumberUtils.toDouble(rejectMax.get(i), 0);
							gradeTarget.setRejectMax(rejMax);
							
							String nts=note.get(i);
							if(nts==null){
								nts="";
							}
							gradeTarget.setNote(nts);
							
							
							gradeTargets.add(gradeTarget);
							
						}catch(Exception e){
							e.printStackTrace();
						}
						
						
					}
					
				}
				
			}
			
			
			try {
				gradeService.update(grade);
				gradeTargetService.save(gradeTargets);
				
			} catch (Exception e) {

				e.printStackTrace();
				model.addAttribute("error", "Error in saving grade "+gradeCode);
				return "gradeError";
			}
			
			
		}

		redirectAttributes.addFlashAttribute("message", "Grade update successfully.");
		
		return "redirect:/grade/view/"+gradeCode;
	}

	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String saveGrade(HttpServletRequest request,RedirectAttributes redirectAttributes,Model model){
		
		model.addAttribute(NEW_PAGE, false);
		model.addAttribute(VIEW_PAGE, true);
		model.addAttribute(EDIT_PAGE, false);
		
		model.addAttribute("grades", gradeService.getGrades());
		
		
		
		String gradeCode=request.getParameter("gradeCode");
		
		if(gradeCode!=null && !gradeCode.trim().equals("")){
			
			Grade grade=new Grade();
			grade.setGradeCode(gradeCode);
			
			String revisionDate=request.getParameter("revisionDate");
			Date date=null;
			try {
				date=dateFormat.parse(revisionDate);
			} catch (Exception e) {
				e.fillInStackTrace();
				date=new Date();
			}
			grade.setRevisionDate(date);
			
			String tmNo=request.getParameter("tmNo");
			if(tmNo==null){
				tmNo="";
			}
			grade.setTmNo(tmNo);
			
			String description=request.getParameter("description");
			if(description==null){
				description="";
			}
			grade.setDescription(description);
			
			String customerGrade=request.getParameter("customerGrade");
			if(customerGrade==null){
				customerGrade="";
			}
			grade.setCustomerGrade(customerGrade);
			
			String customer=request.getParameter("customer");
			if(customer==null){
				customer="";
			}
			grade.setCustomer(customer);
			
			String tissueApproval=request.getParameter("tissueApproval");
			if(tissueApproval==null){
				tissueApproval="";
			}
			grade.setTissueApproval(tissueApproval);
			
			String customerApproval=request.getParameter("customerApproval");
			if(customerApproval==null){
				customerApproval="";
			}
			grade.setCustomerApproval(customerApproval);
			
			String notes=request.getParameter("notes");
			if(notes==null){
				notes="";
			}
			grade.setNotes(notes);
			
			String visualStandard=request.getParameter("visualStandard");
			if(visualStandard==null){
				visualStandard="";
			}
			grade.setVisualStandard(visualStandard);
			
			String trimMin=request.getParameter("trimMin");
			if(trimMin==null){
				trimMin="";
			}
			grade.setTrimMin(trimMin);
			
			String trimTarget=request.getParameter("trimTarget");
			if(trimTarget==null){
				trimTarget="";
			}
			grade.setTrimTarget(trimTarget);
			
			String trimMax=request.getParameter("trimMax");
			if(trimMax==null){
				trimMax="";
			}
			grade.setTrimMax(trimMax);
			
			String diameterMin=request.getParameter("diameterMin");
			if(diameterMin==null){
				diameterMin="";
			}
			grade.setDiameterMin(diameterMin);
			
			String diameterTarget=request.getParameter("diameterTarget");
			if(diameterTarget==null){
				diameterTarget="";
			}
			grade.setDiameterTarget(diameterTarget);
			
			String diameterMax=request.getParameter("diameterMax");
			if(diameterMax==null){
				diameterMax="";
			}
			grade.setDiameterMax(diameterMax);
			
			String breakMin=request.getParameter("breakMin");
			if(breakMin==null){
				breakMin="";
			}
			grade.setBreakMin(breakMin);
			
			String breakTarget=request.getParameter("breakTarget");
			if(breakTarget==null){
				breakTarget="";
			}
			grade.setBreakTarget(breakTarget);
			
			String breakMax=request.getParameter("breakMax");
			if(breakMax==null){
				breakMax="";
			}
			grade.setBreakMax(breakMax);;
			
			String specialInstruction=request.getParameter("specialInstruction");
			if(specialInstruction==null){
				specialInstruction="";
			}
			grade.setSpecialInstruction(specialInstruction);;
			
			
			
			List<String> physicalProperty=Arrays.asList(request.getParameterValues("physicalProperty"));
			List<String> rejectMin=Arrays.asList(request.getParameterValues("rejectMin"));
			List<String> controlMin=Arrays.asList(request.getParameterValues("controlMin"));
			List<String> target=Arrays.asList(request.getParameterValues("target"));
			List<String> controlMax=Arrays.asList(request.getParameterValues("controlMax"));
			List<String> rejectMax=Arrays.asList(request.getParameterValues("rejectMax"));
			List<String> note=Arrays.asList(request.getParameterValues("note"));
			
			List<GradeTarget> gradeTargets=new ArrayList<>();
			
			if(physicalProperty!=null &&
					rejectMin!=null &&
					controlMin!=null &&
					target!=null &&
					controlMax!=null &&
					rejectMax!=null &&
					note!=null){
				
				
				for (int i = 0; i < physicalProperty.size(); i++) {
					
					
					String prop=physicalProperty.get(i);
					if(prop!=null && !prop.trim().equals("")){
						
						try{
							GradeTarget gradeTarget=new GradeTarget();
							gradeTarget.setPhysicalProperty(prop);
							gradeTarget.setGradeCode(gradeCode);
							
							double rejMin=NumberUtils.toDouble(rejectMin.get(i), 0);
							gradeTarget.setRejectMin(rejMin);
							
							double conMin=NumberUtils.toDouble(controlMin.get(i), 0);
							gradeTarget.setControlMin(conMin);
							
							double targ=NumberUtils.toDouble(target.get(i), 0);
							gradeTarget.setTarget(targ);
							
							double conMax=NumberUtils.toDouble(controlMax.get(i), 0);
							gradeTarget.setControlMax(conMax);
							
							double rejMax=NumberUtils.toDouble(rejectMax.get(i), 0);
							gradeTarget.setRejectMax(rejMax);
							
							String nts=note.get(i);
							if(nts==null){
								nts="";
							}
							gradeTarget.setNote(nts);
							
							
							gradeTargets.add(gradeTarget);
							
						}catch(Exception e){
							e.printStackTrace();
						}
						
						
					}
					
				}
				
			}
			
			
			try {
				gradeService.save(grade);
				gradeTargetService.save(gradeTargets);
				
			} catch (Exception e) {

				e.printStackTrace();
				model.addAttribute("error", "Error in saving grade "+gradeCode);
				return "gradeError";
			}
			
			
		}
		
		redirectAttributes.addFlashAttribute("message", "New grade saved successfully.");
		
		return "redirect:/grade/edit/"+gradeCode;
	}
	
	
	@RequestMapping(value="/newcustomer",method=RequestMethod.GET)
	public String newCustomer(Model model){

		return "customer";
	}
	
	@RequestMapping(value="/viewcustomer",method=RequestMethod.GET)
	public String viewCustomer(Model model){

		model.addAttribute("customers", customerService.getCustomersFullInfo());
		
		return "customerView";
	}
	
	@RequestMapping(value="/editcustomer/{id}",method=RequestMethod.GET)
	public String editCustomer(@PathVariable("id")int id,Model model){

		List<Map<String, Object>> maps=customerService.getCustomerById(id);
		if(maps.size()==0){
			return "customer";
		}
		
		
		model.addAttribute("customer", maps.get(0));
		
		
		return "customerEdit";
	}
	
	
	@RequestMapping(value="/deletecustomer",method=RequestMethod.POST)
	public String deleteCustomer(HttpServletRequest request,RedirectAttributes redirectAttributes,Model model){

		String[] customers=request.getParameterValues("customer");
		if(customers!=null & customers.length>0){
			List<String> customerIds=Arrays.asList(customers);
			try{
				customerService.delete(customerIds);
				redirectAttributes.addFlashAttribute("message", "Customers deleted successfully.!");
			}catch(Exception e){
				e.printStackTrace();
				redirectAttributes.addFlashAttribute("error", "Fail to delete Customers."+e.getMessage());
				return "redirect:/grade/viewcustomer";
			}
			
		}else{
			redirectAttributes.addFlashAttribute("message", "Please select customer!");
		}
		
		
		
		return "redirect:/grade/viewcustomer";
	}
	
	
	@RequestMapping(value="/savecustomer",method=RequestMethod.POST)
	public String saveCustomer(HttpServletRequest request,RedirectAttributes redirectAttributes,Model model){
		String ids=request.getParameter("id");
		int id=0;
		if(ids!=null&&!ids.isBlank())
			id=CommonUtil.checkInt(ids);
		 
		String name=request.getParameter("name");
		String location=request.getParameter("location");
		String city=request.getParameter("city");
		String state=request.getParameter("state");
		if(location==null){
			location="";
		}
		if(city==null){
			city="";
		}
		if(state==null){
			state="";
		}
		
		try {
			if(id==0){
				customerService.saveCustomer(name,location,city,state);
			}else{
				customerService.updateCustomer(id,name,location,city,state);
			}
			
		} catch (Exception e) {
			model.addAttribute("error", "Error in adding new Customer:-"+e.getMessage());
			return "customer";
		}
		
		
		model.addAttribute("message", "Customer added successfully.");
		
		if(id==0){
			model.addAttribute("message", "Customer added successfully.");
			return "customer";
		}else{
			redirectAttributes.addFlashAttribute("message", "Customer updated successfully.");
			return "redirect:/grade/viewcustomer";
		}
		
	}
	@RequestMapping(value="/copy/{grade}",method=RequestMethod.GET)
	public String copyGrade(@PathVariable("grade")String grade,Model model){
		model.addAttribute("grade", grade);
		model.addAttribute("saveFlag", false);
		
		return "gradeCopy";
	}
	
	
	@RequestMapping(value="/copysave",method=RequestMethod.GET)
	public String copyGrade(@RequestParam("grade")String grade,
			@RequestParam("ngrade")String ngrade,
			Model model){
		
		Grade gradeTemp=gradeService.getGrade(ngrade);
		if(gradeTemp!=null){
			model.addAttribute("error", "Grade code already exist. Please try another code.");
			model.addAttribute("ngrade", ngrade);
		}else{
			Grade targetGrade=gradeService.getGrade(grade);
			targetGrade.setGradeCode(ngrade);
			
			List<GradeTarget> gradeTargets=gradeTargetService.getGradeTargets(grade);
			for (GradeTarget gradeTarget : gradeTargets) {
				gradeTarget.setGradeCode(ngrade);
			}
			
			try {
				gradeService.save(targetGrade);
			} catch (Exception e) {
				model.addAttribute("error", "Fail to copy grade code.");
				e.printStackTrace();
			}
			try {
				gradeTargetService.save(gradeTargets);
			} catch (Exception e) {
				model.addAttribute("error", "Fail to copy grade target values.");
				e.printStackTrace();
			}
			
			model.addAttribute("message", "Grade code copied successfully.");
		}
		
		model.addAttribute("grade", grade);
		
		
		model.addAttribute("saveFlag", true);
		return "gradeCopy";
	}
	
}

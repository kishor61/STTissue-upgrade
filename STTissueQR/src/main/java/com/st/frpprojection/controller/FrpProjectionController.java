/**
 * 
 */
package com.st.frpprojection.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
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
import com.st.frpprojection.model.FrpProjection;
import com.st.frpprojection.service.FrpProjectionService;

/**
 * @author sbora frpprojectionreport
 *
 */
@Controller
@RequestMapping(value="/frpprojection")
public class FrpProjectionController {
	
	@Autowired
	private FrpProjectionService frpProjectionService;
	
	@RequestMapping(value="/new",method=RequestMethod.GET)
	public String newFormula(Model model) {
		model.addAttribute("frpgrade", FrpCommon.getGrade());
		return "frp/projectionFormulaNew";
	}
	@RequestMapping(value="/new/{type}",method=RequestMethod.GET)
	public String newFormula(@PathVariable("type")String type,Model model) {
		
		model.addAttribute("frpgradetype", FrpCommon.getGradeType());
		model.addAttribute("frpgrade", FrpCommon.getGrade());
		model.addAttribute("type", type);
		
		return "frp/projectionFormulaNew";
	}
	
	@RequestMapping(value="/view",method=RequestMethod.GET)
	public String viewFormula(Model model) {
		model.addAttribute("frpgrade", FrpCommon.getGrade());
		return "frp/projectionFormulaView";
	}
	
	
	@RequestMapping(value="/view/{type}",method=RequestMethod.GET)
	public String viewFormula(@PathVariable("type")String type,Model model) {
		
		model.addAttribute("type", type);
		model.addAttribute("frpgradetype", FrpCommon.getGradeType());
		model.addAttribute("frpgrade", FrpCommon.getGrade());
		
		List<FrpProjection> projections=frpProjectionService.getProjectionFormulae(type);
		model.addAttribute("projections", projections);
		return "frp/projectionFormulaView";
	}
	
	@RequestMapping(value="/edit/{id}",method=RequestMethod.GET)
	public String editFormula(@PathVariable("id") int id,Model model) {
		
		model.addAttribute("frpgradetype", FrpCommon.getGradeType());
		model.addAttribute("frpgrade", FrpCommon.getGrade());
		
		FrpProjection projection=frpProjectionService.getProjectionFormula(id);
		model.addAttribute("projection", projection);
		
		model.addAttribute("type", projection==null?null:projection.getType());
		
		return "frp/projectionFormulaNew";
	}
	
	
	@RequestMapping(value="/delete/{id}",method=RequestMethod.GET)
	public @ResponseBody boolean deleteFormula(@PathVariable("id") int id) {
		
		try {
			frpProjectionService.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public void save(HttpServletRequest request,HttpServletResponse response,Model model) throws IOException {
		int id=CommonUtil.checkInt(request.getParameter("id"));
		String type=CommonUtil.checkNull(request.getParameter("type"));
		String type2=CommonUtil.checkNull(request.getParameter("type2"));
		double input=CommonUtil.checkDouble(request.getParameter("input"));
		double mwlAndSwl=CommonUtil.checkDouble(request.getParameter("mwlAndSwl"));
		double sow=CommonUtil.checkDouble(request.getParameter("sow"));
		double cbs=CommonUtil.checkDouble(request.getParameter("cbs"));
		double sowAndMail=CommonUtil.checkDouble(request.getParameter("sowAndMail"));
		double growndwood=CommonUtil.checkDouble(request.getParameter("growndwood"));
		double dlk=CommonUtil.checkDouble(request.getParameter("dlk"));
		double occ=CommonUtil.checkDouble(request.getParameter("occ"));
		double others=CommonUtil.checkDouble(request.getParameter("others"));
		String remarks=CommonUtil.checkNull(request.getParameter("remarks"));
		
		double occMinR=CommonUtil.checkDouble(request.getParameter("occMinR"));
		double occMinC=CommonUtil.checkDouble(request.getParameter("occMinC"));
		double occTarget=CommonUtil.checkDouble(request.getParameter("occTarget"));
		double occMaxC=CommonUtil.checkDouble(request.getParameter("occMaxC"));
		double occMaxR=CommonUtil.checkDouble(request.getParameter("occMaxR"));
		double dlkMinR=CommonUtil.checkDouble(request.getParameter("dlkMinR"));
		double dlkMinC=CommonUtil.checkDouble(request.getParameter("dlkMinC"));
		double dlkTarget=CommonUtil.checkDouble(request.getParameter("dlkTarget"));
		double dlkMaxC=CommonUtil.checkDouble(request.getParameter("dlkMaxC"));
		double dlkMaxR=CommonUtil.checkDouble(request.getParameter("dlkMaxR"));
		double sowAndMailMinR=CommonUtil.checkDouble(request.getParameter("sowAndMailMinR"));
		double sowAndMailMinC=CommonUtil.checkDouble(request.getParameter("sowAndMailMinC"));
		double sowAndMailTarget=CommonUtil.checkDouble(request.getParameter("sowAndMailTarget"));
		double sowAndMailMaxC=CommonUtil.checkDouble(request.getParameter("sowAndMailMaxC"));
		double sowAndMailMaxR=CommonUtil.checkDouble(request.getParameter("sowAndMailMaxR"));
		double growndwoodMinR=CommonUtil.checkDouble(request.getParameter("growndwoodMinR"));
		double growndwoodMinC=CommonUtil.checkDouble(request.getParameter("growndwoodMinC"));
		double growndwoodTarget=CommonUtil.checkDouble(request.getParameter("growndwoodTarget"));
		double growndwoodMaxC=CommonUtil.checkDouble(request.getParameter("growndwoodMaxC"));
		double growndwoodMaxR=CommonUtil.checkDouble(request.getParameter("growndwoodMaxR"));
		double mwlAndSwlMinR=CommonUtil.checkDouble(request.getParameter("mwlAndSwlMinR"));
		double mwlAndSwlMinC=CommonUtil.checkDouble(request.getParameter("mwlAndSwlMinC"));
		double mwlAndSwlTarget=CommonUtil.checkDouble(request.getParameter("mwlAndSwlTarget"));
		double mwlAndSwlMaxC=CommonUtil.checkDouble(request.getParameter("mwlAndSwlMaxC"));
		double mwlAndSwlMaxR=CommonUtil.checkDouble(request.getParameter("mwlAndSwlMaxR"));
		double sowMinR=CommonUtil.checkDouble(request.getParameter("sowMinR"));
		double sowMinC=CommonUtil.checkDouble(request.getParameter("sowMinC"));
		double sowTarget=CommonUtil.checkDouble(request.getParameter("sowTarget"));
		double sowMaxC=CommonUtil.checkDouble(request.getParameter("sowMaxC"));
		double sowMaxR=CommonUtil.checkDouble(request.getParameter("sowMaxR"));
		double cbsMinR=CommonUtil.checkDouble(request.getParameter("cbsMinR"));
		double cbsMinC=CommonUtil.checkDouble(request.getParameter("cbsMinC"));
		double cbsTarget=CommonUtil.checkDouble(request.getParameter("cbsTarget"));
		double cbsMaxC=CommonUtil.checkDouble(request.getParameter("cbsMaxC"));
		double cbsMaxR=CommonUtil.checkDouble(request.getParameter("cbsMaxR"));
		
		double othersMinR=CommonUtil.checkDouble(request.getParameter("othersMinR"));
		double othersMinC=CommonUtil.checkDouble(request.getParameter("othersMinC"));
		double othersTarget=CommonUtil.checkDouble(request.getParameter("othersTarget"));
		double othersMaxC=CommonUtil.checkDouble(request.getParameter("othersMaxC"));
		double othersMaxR=CommonUtil.checkDouble(request.getParameter("othersMaxR"));
		
		//Code Starts From Here Done By Roshan Tailor
		double hw=CommonUtil.checkDouble(request.getParameter("hw"));
		double hwMinR=CommonUtil.checkDouble(request.getParameter("hwMinR"));
		double hwMinC=CommonUtil.checkDouble(request.getParameter("hwMinC"));
		double hwTarget=CommonUtil.checkDouble(request.getParameter("hwTarget"));
		double hwMaxC=CommonUtil.checkDouble(request.getParameter("hwMaxC"));
		double hwMaxR=CommonUtil.checkDouble(request.getParameter("hwMaxR"));
		
		double unprtsbs=CommonUtil.checkDouble(request.getParameter("unprtsbs"));
		double unprtsbsMinR=CommonUtil.checkDouble(request.getParameter("unprtsbsMinR"));
		double unprtsbsMinC=CommonUtil.checkDouble(request.getParameter("unprtsbsMinC"));
		double unprtsbsTarget=CommonUtil.checkDouble(request.getParameter("unprtsbsTarget"));
		double unprtsbsMaxC=CommonUtil.checkDouble(request.getParameter("unprtsbsMaxC"));
		double unprtsbsMaxR=CommonUtil.checkDouble(request.getParameter("unprtsbsMaxR"));
		//Code Ends Here Done By Roshan Tailor
		
		//Mixed added new

		double mixedPaper=CommonUtil.checkDouble(request.getParameter("mixedPaper"));
		double mixedPaperMinR=CommonUtil.checkDouble(request.getParameter("mixedPaperMinR"));
		double mixedPaperMinC=CommonUtil.checkDouble(request.getParameter("mixedPaperMinC"));
		double mixedPaperTarget=CommonUtil.checkDouble(request.getParameter("mixedPaperTarget"));
		double mixedPaperMaxC=CommonUtil.checkDouble(request.getParameter("mixedPaperMaxC"));
		double mixedPaperMaxR=CommonUtil.checkDouble(request.getParameter("mixedPaperMaxR"));
		
		//Mixed added new 2014-12-18

		double cutBook=CommonUtil.checkDouble(request.getParameter("cutBook"));
		double cutBookMinR=CommonUtil.checkDouble(request.getParameter("cutBookMinR"));
		double cutBookMinC=CommonUtil.checkDouble(request.getParameter("cutBookMinC"));
		double cutBookTarget=CommonUtil.checkDouble(request.getParameter("cutBookTarget"));
		double cutBookMaxC=CommonUtil.checkDouble(request.getParameter("cutBookMaxC"));
		double cutBookMaxR=CommonUtil.checkDouble(request.getParameter("cutBookMaxR"));

		
		Map<String, Object> map=new HashMap<>();
		
		try {
			
			if(StringUtils.isEmpty(type)){
				throw new Exception("Please select production type.");
			}
			
			FrpProjection frpProjection=new FrpProjection();
			frpProjection.setId(id);
			frpProjection.setType(type);
			frpProjection.setType2(type2);
			frpProjection.setInput(input);
			frpProjection.setMwlAndSwl(mwlAndSwl);
			frpProjection.setSow(sow);
			frpProjection.setCbs(cbs);
			frpProjection.setSowAndMail(sowAndMail);
			frpProjection.setGrowndwood(growndwood);
			frpProjection.setDlk(dlk);
			frpProjection.setOcc(occ);
			frpProjection.setOthers(others);
			frpProjection.setRemarks(remarks);
			
			frpProjection.setOccMinR(occMinR);
			frpProjection.setOccMinC(occMinC);
			frpProjection.setOccTarget(occTarget);
			frpProjection.setOccMaxC(occMaxC);
			frpProjection.setOccMaxR(occMaxR);
			frpProjection.setDlkMinR(dlkMinR);
			frpProjection.setDlkMinC(dlkMinC);
			frpProjection.setDlkTarget(dlkTarget);
			frpProjection.setDlkMaxC(dlkMaxC);
			frpProjection.setDlkMaxR(dlkMaxR);
			frpProjection.setSowAndMailMinR(sowAndMailMinR);
			frpProjection.setSowAndMailMinC(sowAndMailMinC);
			frpProjection.setSowAndMailTarget(sowAndMailTarget);
			frpProjection.setSowAndMailMaxC(sowAndMailMaxC);
			frpProjection.setSowAndMailMaxR(sowAndMailMaxR);
			frpProjection.setGrowndwoodMinR(growndwoodMinR);
			frpProjection.setGrowndwoodMinC(growndwoodMinC);
			frpProjection.setGrowndwoodTarget(growndwoodTarget);
			frpProjection.setGrowndwoodMaxC(growndwoodMaxC);
			frpProjection.setGrowndwoodMaxR(growndwoodMaxR);
			frpProjection.setMwlAndSwlMinR(mwlAndSwlMinR);
			frpProjection.setMwlAndSwlMinC(mwlAndSwlMinC);
			frpProjection.setMwlAndSwlTarget(mwlAndSwlTarget);
			frpProjection.setMwlAndSwlMaxC(mwlAndSwlMaxC);
			frpProjection.setMwlAndSwlMaxR(mwlAndSwlMaxR);
			frpProjection.setSowMinR(sowMinR);
			frpProjection.setSowMinC(sowMinC);
			frpProjection.setSowTarget(sowTarget);
			frpProjection.setSowMaxC(sowMaxC);
			frpProjection.setSowMaxR(sowMaxR);
			frpProjection.setCbsMinR(cbsMinR);
			frpProjection.setCbsMinC(cbsMinC);
			frpProjection.setCbsTarget(cbsTarget);
			frpProjection.setCbsMaxC(cbsMaxC);
			frpProjection.setCbsMaxR(cbsMaxR);
			frpProjection.setOthersMinR(othersMinR);
			frpProjection.setOthersMinC(othersMinC);
			frpProjection.setOthersTarget(othersTarget);
			frpProjection.setOthersMaxC(othersMaxC);
			frpProjection.setOthersMaxR(othersMaxR);

			frpProjection.setMixedPaper(mixedPaper);
			frpProjection.setMixedPaperMinR(mixedPaperMinR);
			frpProjection.setMixedPaperMinC(mixedPaperMinC);
			frpProjection.setMixedPaperTarget(mixedPaperTarget);
			frpProjection.setMixedPaperMaxC(mixedPaperMaxC);
			frpProjection.setMixedPaperMaxR(mixedPaperMaxR);
			
			frpProjection.setCutBook(cutBook);
			frpProjection.setCutBookMaxR(cutBookMaxR);
			frpProjection.setCutBookMinC(cutBookMinC);
			frpProjection.setCutBookMaxC(cutBookMaxC);
			frpProjection.setCutBookMinR(cutBookMinR);
			frpProjection.setCutBookTarget(cutBookTarget);
			
			
			//Code Starts From Here Done By Roshan Tailor
			frpProjection.setHw(hw);
			frpProjection.setHwMinR(hwMinR);
			frpProjection.setHwMinC(hwMinC);
			frpProjection.setHwTarget(hwTarget);
			frpProjection.setHwMaxC(hwMaxC);
			frpProjection.setHwMaxR(hwMaxR);
			
			
			frpProjection.setUnprtsbs(unprtsbs);
			frpProjection.setUnprtsbsMinR(unprtsbsMinR);
			frpProjection.setUnprtsbsMinC(unprtsbsMinC);
			frpProjection.setUnprtsbsTarget(unprtsbsTarget);
			frpProjection.setUnprtsbsMaxC(unprtsbsMaxC);
			frpProjection.setUnprtsbsMaxR(unprtsbsMaxR);
			
			//Code Ends Here Done By Roshan Tailor
			
			if(id>0){
				
				try {
					frpProjectionService.updateFormula(frpProjection);
					map.put("id", id);
					map.put("status", true);
					map.put("message", "Data updated successfully.");
				} catch (Exception e) {
					throw new Exception("Error in upading record. "+e.getMessage());
				}
				
			}else{
				try {
					
					int key=frpProjectionService.saveFormula(frpProjection);
					map.put("status", true);
					map.put("id", key);
					map.put("message", "Data inserted successfully.");
				} catch (Exception e) {
					throw new Exception("Error in saved new record. "+e.getMessage());
				}
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
			map.put("status", false);
			map.put("error", e.getMessage());
		}
		
		
		//System.out.println(map);
		response.setContentType("application/json");
		response.getWriter().write(new Gson().toJson(map));
		
	}
}

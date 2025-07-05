/**
 * 
 */
package com.st.frpprojectionJon.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import jakarta.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.gson.Gson;
import com.st.common.CommonUtil;
import com.st.common.FrpCommon;
import com.st.frppressquality.service.FrpPressQualityService;
import com.st.frpprojectionJon.service.FrpProjectionJonService;
import com.st.qualitypm6.service.ReelService;

/**
 * @author sbora
 *
 */
@Controller
@RequestMapping(value="/frpprojectionmixJon")
public class FrpProjectionMixJonController {
	
	@Autowired
	private FrpProjectionJonService frpProjectionService;
	@Autowired
	private ReelService reelService;
	@Autowired
	private FrpPressQualityService frpPressQualityService;
	
	@RequestMapping(value="/view",method=RequestMethod.GET)
	public String view(Model model) {
		model.addAttribute("frpgrade", FrpCommon.getGrade());
		//model.addAttribute("frpgradeType", FrpCommon.getGradeType());
		return "frp/projectionViewMixGraph";
	}
	
	@RequestMapping(value="/view/{type}",method=RequestMethod.GET)
	public String view2(@PathVariable()String type,Model model) {
		model.addAttribute("type", type);
		model.addAttribute("frpgrade", FrpCommon.getGrade());
		model.addAttribute("frpgradeType", FrpCommon.getGradeType());
		model.addAttribute("frpProjection", frpProjectionService.getProjectionFormulae(type));
		return "frp/projectionViewMixGraph";
	}
	
	@RequestMapping(value="/viewgraph/{grade}/{type}",method=RequestMethod.GET)
	public String viewGraph(@PathVariable("grade")String grade,
			@PathVariable("type")int type,
			Model model) {
		
			model.addAttribute("frpgrade", FrpCommon.getGrade());
			model.addAttribute("grade", grade);
			model.addAttribute("type", type);
			//Map<String, Object>map=frpProjectionService.getProjectionMixData(grade,type);
		
		return "frp/projectionViewMixGraphIframe";
	}
	
	@RequestMapping(value="/viewgraphdata/{grade}/{type}",method=RequestMethod.POST)
	public void viewGraph(@PathVariable("grade")String grade,
			@PathVariable("type")int type,
			HttpServletResponse response) throws IOException {
		Map<String, Object>map=new HashMap<>();
		try {
			map=frpProjectionService.getProjectionMixData(grade,type);
			
			double avgMachineBrightness=reelService.getBirghtnessAvgOfDay();
			
			double avgFrpBrightness=frpPressQualityService.getBirghtnessAvgOfDay();
			
			map.put("avgMachineBrightness", CommonUtil.round(avgMachineBrightness, 2));
			map.put("avgFrpBrightness", CommonUtil.round(avgFrpBrightness, 2));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.setContentType("application/json");
		response.getWriter().write(new Gson().toJson(map));
	}
}

/**
 * 
 */
package com.st.utilitykpimaster.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.gson.Gson;
import com.st.centerline.service.CenterlineService;
import com.st.common.CommonUtil;
import com.st.common.FrpCommon;
import com.st.common.UtilityKpiMasterCommon;
import com.st.frppressquality.model.SludgeHauling;
import com.st.utilitykpimaster.model.KpiRecordableDate;
import com.st.utilitykpimaster.model.MasterData;
import com.st.utilitykpimaster.model.UtilityData;
import com.st.utilitykpimaster.service.KpiRecordableDateService;
import com.st.utilitykpimaster.service.MasterDataService;
import com.st.utilitykpimaster.service.UtilityDataService;

/**
 * @author roshan
 *
 */
@Controller
@RequestMapping(value="/utilitykpimaster")
public class UtilityKpiMasterController {
	
	@Autowired
	private UtilityDataService utilityDataService;
	
	@Autowired
	private MasterDataService masterDataService;
	
	@Autowired
	private CenterlineService centerlineService;
	
	
	@Autowired
	private KpiRecordableDateService kpiRecordableDateService;
	
	
	
	private SimpleDateFormat dateFormat=new SimpleDateFormat("MM-dd-yyyy");
	private SimpleDateFormat timeFormat=new SimpleDateFormat("HH:mm");
	
	@RequestMapping(value="/new",method=RequestMethod.GET)
	public String main(Model model) {
		
		model.addAttribute("pages", UtilityKpiMasterCommon.getEntryPages());
		return "utilityKpiMasterMain";
		
	}
	@RequestMapping(value="/new/{page}",method=RequestMethod.GET)
	public String entryPage(
			@PathVariable("page")String page,
			Model model) {
		
		model.addAttribute("page", page);
		model.addAttribute("date", dateFormat.format(new Date()));
		model.addAttribute("pages", UtilityKpiMasterCommon.getEntryPages());
		
		if(page.equalsIgnoreCase("U")){
			List<UtilityData> utilityDatas=utilityDataService.getUtilityDatasL31();
			model.addAttribute("utilityDatas", utilityDatas);
		}else if(page.equalsIgnoreCase("M")){
			
			List<Map<String, Object>> centerlineGrades=centerlineService.getCenterlineGrades();
			model.addAttribute("centerlineGrades", UtilityKpiMasterCommon.getJsonDataOfCenterlineGrade(centerlineGrades));
			
			List<MasterData> masterDatas=masterDataService.getMasterDatasL31();
			model.addAttribute("masterDatas", masterDatas);
			
		}else if(page.equalsIgnoreCase("K")){
			List<KpiRecordableDate> kpiRecordableDates=kpiRecordableDateService.getKpiRecordableDate();
			model.addAttribute("kpiRecordableDates", kpiRecordableDates);
			
		}
		
		return "utilityKpiMasterMain";
		
	}
	
	
	@RequestMapping(value="/edit/{page}/{id}",method=RequestMethod.GET)
	public String edit(
			@PathVariable("page")String page,
			@PathVariable("id")int id,
			HttpServletRequest request,
			Model model) {
		
		model.addAttribute("page", page);
		model.addAttribute("backParam", request.getQueryString());
		model.addAttribute("date", dateFormat.format(new Date()));
		model.addAttribute("pages", UtilityKpiMasterCommon.getEntryPages());
		
		if(page.equalsIgnoreCase("U")){
			List<UtilityData> utilityDatas=new ArrayList<>();
			utilityDatas.add(utilityDataService.getUtilityData(id));
			model.addAttribute("utilityDatas", utilityDatas);
		}else if(page.equalsIgnoreCase("M")){
			List<Map<String, Object>> centerlineGrades=centerlineService.getCenterlineGrades();
			model.addAttribute("centerlineGrades", UtilityKpiMasterCommon.getJsonDataOfCenterlineGrade(centerlineGrades));
			
			List<MasterData> masterDatas=new ArrayList<>();
			masterDatas.add(masterDataService.getMasterData(id));
			model.addAttribute("masterDatas", masterDatas);
		}
		
		
		
		return "utilityKpiMasterEdit";
		
	}
	
	
	
	
	@RequestMapping(value="/saveutility",method=RequestMethod.POST)
	public void saveUtility(HttpServletRequest request,
			HttpServletResponse response,
			Model model) throws IOException {
		
		Map<String, Object> map=new HashMap<String, Object>();
		
		try {
			
			int id=CommonUtil.checkInt(request.getParameter("id"));
			Date date=CommonUtil.checkDate(request.getParameter("date"),dateFormat);
			String t=CommonUtil.checkNull(request.getParameter("time"));
			if(t!=null && !t.trim().equals("")){
				Date time=CommonUtil.checkDate(t, timeFormat);
				date=CommonUtil.getDateTime(date, time);
			}
			int lb60=CommonUtil.checkInt(request.getParameter("lb60"));
			int consumption1=CommonUtil.checkInt(request.getParameter("consumption1"));
			int lb150=CommonUtil.checkInt(request.getParameter("lb150"));
			int consumption2=CommonUtil.checkInt(request.getParameter("consumption2"));
			int millWater=CommonUtil.checkInt(request.getParameter("millWater"));
			int consumption3=CommonUtil.checkInt(request.getParameter("consumption3"));
			int condensate=CommonUtil.checkInt(request.getParameter("condensate"));
			int consumption4=CommonUtil.checkInt(request.getParameter("consumption4"));
			int riverWater=CommonUtil.checkInt(request.getParameter("riverWater"));
			int riverWaterData=CommonUtil.checkInt(request.getParameter("riverWaterData"));
			

			UtilityData utilityData=new UtilityData();
			utilityData.setId(id);
			utilityData.setDate(date);
			utilityData.setLb60(lb60);
			utilityData.setConsumption1(consumption1);
			utilityData.setLb150(lb150);
			utilityData.setConsumption2(consumption2);
			utilityData.setMillWater(millWater);
			utilityData.setConsumption3(consumption3);
			utilityData.setCondensate(condensate);
			utilityData.setConsumption4(consumption4);
			utilityData.setRiverWater(riverWater);
			utilityData.setRiverWaterData(riverWaterData);
			
			try {
				if(utilityData.getId()==0){
					int key=utilityDataService.save(utilityData);
					
					UtilityData prevUtilityData=utilityDataService.getPrevUtilityData(key);
					
					map.put("status", true);
					map.put("id", key);
					map.put("message", "Data saved successfully.");
					map.put("pdata", prevUtilityData);
				}else{
					utilityDataService.update(utilityData);
					
					UtilityData prevUtilityData=utilityDataService.getPrevUtilityData(id);
					
					map.put("status", true);
					map.put("id", utilityData.getId());
					map.put("message", "Data updated successfully.");
					map.put("pdata", prevUtilityData);
				}
			} catch (Exception e) {
				throw new Exception("Server error..", e);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
			map.put("status", false);
			map.put("error", e.getMessage());
		}
		
		response.setContentType("application/json");
		response.getWriter().write(new Gson().toJson(map));
		
		
	}
	
	@RequestMapping(value="/deleteutility",method=RequestMethod.POST)
	public void delete(HttpServletRequest request,HttpServletResponse response) throws IOException {
		int id=CommonUtil.checkInt(request.getParameter("id"));
		
		Map<String, Object> map=new HashMap<String, Object>();
		
		try {
			utilityDataService.delete(id);
			map.put("status", true);
		} catch (Exception e) {
			map.put("status", false);
			map.put("error", "Server error...");
			
		}
		
		
		response.setContentType("application/json");
		response.getWriter().write(new Gson().toJson(map));
		
	}
	
	
	
	
	@RequestMapping(value="/savemaster",method=RequestMethod.POST)
	public void saveMaster(HttpServletRequest request,
			HttpServletResponse response,
			Model model) throws IOException {
		
		Map<String, Object> map=new HashMap<String, Object>();
		
		try {
			
			int id=CommonUtil.checkInt(request.getParameter("id"));
			Date date=CommonUtil.checkDate(request.getParameter("date"),dateFormat);
			double avgThp=CommonUtil.checkDouble(request.getParameter("avgThp"));
			double prodBlead=CommonUtil.checkDouble(request.getParameter("prodBlead"));
			double prodKraft=CommonUtil.checkDouble(request.getParameter("prodKraft"));
			double prodSlabOff=CommonUtil.checkDouble(request.getParameter("prodSlabOff"));
			double prodWrapBlead=CommonUtil.checkDouble(request.getParameter("prodWrapBlead"));
			double prodProdWhite=CommonUtil.checkDouble(request.getParameter("prodProdWhite"));
			double prodProdRed=CommonUtil.checkDouble(request.getParameter("prodProdRed"));
			double prodProdReject=CommonUtil.checkDouble(request.getParameter("prodProdReject"));
			double naturalGasFlow=CommonUtil.checkDouble(request.getParameter("naturalGasFlow"));
			double fiberLossSewerFlow=CommonUtil.checkDouble(request.getParameter("fiberLossSewerFlow"));
			double fiberLossSfConsy=CommonUtil.checkDouble(request.getParameter("fiberLossSfConsy"));
			double fiberLossWwToFrp=CommonUtil.checkDouble(request.getParameter("fiberLossWwToFrp"));
			double fiberLossWfFlow=CommonUtil.checkDouble(request.getParameter("fiberLossWfFlow"));
			double pulpWlap=CommonUtil.checkDouble(request.getParameter("pulpWlap"));
			double energyElectrical=CommonUtil.checkDouble(request.getParameter("energyElectrical"));
			double pulpDataFromFrp=CommonUtil.checkDouble(request.getParameter("pulpDataFromFrp"));
			double pulpConsumedFromHd=CommonUtil.checkDouble(request.getParameter("pulpConsumedFromHd"));
			double pulpDataProdDcs=CommonUtil.checkDouble(request.getParameter("pulpDataProdDcs"));
			double pulpDataHdLevel=CommonUtil.checkDouble(request.getParameter("pulpDataHdLevel"));
			double pulpInHd=CommonUtil.checkDouble(request.getParameter("pulpInHd"));
			String tissueGrade=CommonUtil.checkNull(request.getParameter("tissueGrade"));
			
			double chemWetStrength=CommonUtil.checkDouble(request.getParameter("chemWetStrength"));
			double chemRelease=CommonUtil.checkDouble(request.getParameter("chemRelease"));
			double chemAdhesive=CommonUtil.checkDouble(request.getParameter("chemAdhesive"));
			double chemMap=CommonUtil.checkDouble(request.getParameter("chemMap"));
			double chemDefoamer=CommonUtil.checkDouble(request.getParameter("chemDefoamer"));
			double chemPassivator=CommonUtil.checkDouble(request.getParameter("chemPassivator"));
			
			double coddischarge=CommonUtil.checkDouble(request.getParameter("coddischarge"));
			
			
			
			MasterData masterData=new MasterData();
			masterData.setId(id);
			masterData.setDate(date);
			masterData.setAvgThp(avgThp);
			masterData.setProdBlead(prodBlead);
			masterData.setProdKraft(prodKraft);
			masterData.setProdSlabOff(prodSlabOff);
			masterData.setProdWrapBlead(prodWrapBlead);
			masterData.setProdProdWhite(prodProdWhite);
			masterData.setProdProdRed(prodProdRed);
			masterData.setProdProdReject(prodProdReject);
			masterData.setNaturalGasFlow(naturalGasFlow);
			masterData.setFiberLossSewerFlow(fiberLossSewerFlow);
			masterData.setFiberLossSfConsy(fiberLossSfConsy);
			masterData.setFiberLossWwToFrp(fiberLossWwToFrp);
			masterData.setFiberLossWfFlow(fiberLossWfFlow);
			masterData.setPulpWlap(pulpWlap);
			masterData.setEnergyElectrical(energyElectrical);
			masterData.setPulpDataFromFrp(pulpDataFromFrp);
			masterData.setPulpConsumedFromHd(pulpConsumedFromHd);
			masterData.setPulpDataProdDcs(pulpDataProdDcs);
			masterData.setPulpDataHdLevel(pulpDataHdLevel);
			masterData.setPulpInHd(pulpInHd);
			masterData.setTissueGrade(tissueGrade);
		
			
			masterData.setChemWetStrength(chemWetStrength);
			masterData.setChemRelease(chemRelease);
			masterData.setChemAdhesive(chemAdhesive);
			masterData.setChemMap(chemMap);
			masterData.setChemDefoamer(chemDefoamer);
			masterData.setChemPassivator(chemPassivator);
			
			masterData.setCoddischarge(coddischarge);
			
			
			try {
				if(masterData.getId()==0){
					int key=masterDataService.save(masterData);
					map.put("status", true);
					map.put("id", key);
					map.put("message", "Data saved successfully.");
				}else{
					masterDataService.update(masterData);
					map.put("status", true);
					map.put("id", masterData.getId());
					map.put("message", "Data updated successfully.");
				}
			} catch (Exception e) {
				throw new Exception("Server error..", e);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
			map.put("status", false);
			map.put("error", e.getMessage());
		}
		
		response.setContentType("application/json");
		response.getWriter().write(new Gson().toJson(map));
		
		
	}
	
	@RequestMapping(value="/deletemaster",method=RequestMethod.POST)
	public void deleteMaster(HttpServletRequest request,HttpServletResponse response) throws IOException {
		int id=CommonUtil.checkInt(request.getParameter("id"));
		
		Map<String, Object> map=new HashMap<String, Object>();
		
		try {
			masterDataService.delete(id);
			map.put("status", true);
		} catch (Exception e) {
			map.put("status", false);
			map.put("error", "Server error...");
			
		}
		
		
		response.setContentType("application/json");
		response.getWriter().write(new Gson().toJson(map));
		
	}
	
	@RequestMapping(value="/savekpidate",method=RequestMethod.POST)
	public void saveKpiRecordableDate(HttpServletRequest request,HttpServletResponse response) throws IOException {

		

		Map<String, Object> map=new HashMap<String, Object>();
		
		try {
			
			Date date=CommonUtil.checkDate(request.getParameter("date"), dateFormat);
			
			if(date==null){
				throw new Exception("Invalid date");
			}
			
			
			String remarks=CommonUtil.checkNull(request.getParameter("remarks"));
			
			KpiRecordableDate kpiRecordableDate=new KpiRecordableDate();
			kpiRecordableDate.setDate(date);
			kpiRecordableDate.setRemarks(remarks);
			
			try {
				@SuppressWarnings("unused")
				int key=kpiRecordableDateService.save(kpiRecordableDate);				
//				System.out.println("Id="+key);
				map.put("status", true);
			} catch (Exception e) {
				throw new Exception("Server error.."+e.getMessage(), e);
				
			}
		} catch (Exception e) {
			map.put("status", false);
			map.put("error", e.getMessage());
		}
		
		
		
		
		
		
		response.setContentType("application/json");
		response.getWriter().write(new Gson().toJson(map));
		
	}
	
	@RequestMapping(value="/deletekpirecordabledate",method=RequestMethod.POST)
	public void deleteKpiRecordableDate(HttpServletRequest request,HttpServletResponse response) throws IOException {
		int id=CommonUtil.checkInt(request.getParameter("id"));
		
		Map<String, Object> map=new HashMap<String, Object>();
		
		try {
			kpiRecordableDateService.delete(id);
			map.put("status", true);
		} catch (Exception e) {
			map.put("status", false);
			map.put("error", "Server error...");
			
		}
		
		
		response.setContentType("application/json");
		response.getWriter().write(new Gson().toJson(map));
		
	}
	@RequestMapping(value="/masterbackdatedentry",method=RequestMethod.GET)
	public String shbackdatedentry(Model model){
		
		List<Map<String, Object>> centerlineGrades=centerlineService.getCenterlineGrades();
		model.addAttribute("centerlineGrades", UtilityKpiMasterCommon.getJsonDataOfCenterlineGrade(centerlineGrades));

		model.addAttribute("date", dateFormat.format(new Date()));
		model.addAttribute("pages", UtilityKpiMasterCommon.getEntryPages());
		
		model.addAttribute("sdate", dateFormat.format(CommonUtil.getFirstDate()));
		model.addAttribute("edate", dateFormat.format(new Date()));
		model.addAttribute("page", "M");
		
		return "utilityKpiMasterBackDatedEntryMain";
	}
	@RequestMapping(value="/masterbackdatedentry/report/{sdate}/{edate}",method=RequestMethod.GET)
	public String ShowDateBetweenData(@PathVariable("sdate")String sdate,@PathVariable("edate")String edate,HttpServletRequest request,HttpServletResponse response,Model model) throws ParseException{

	Date Sdate=CommonUtil.checkDate(sdate, dateFormat);
	Date Edate=CommonUtil.checkDate(edate, dateFormat);

	
	List<Map<String, Object>> centerlineGrades=centerlineService.getCenterlineGrades();
	model.addAttribute("centerlineGrades", UtilityKpiMasterCommon.getJsonDataOfCenterlineGrade(centerlineGrades));
	
	List<MasterData> masterDatas=masterDataService.getMasterDatasBetweenDate(Sdate,Edate);
	model.addAttribute("masterDatas", masterDatas);
	model.addAttribute("page", "M");
	
	return "utilityKpiMasterBackDatedEntryMain";
	}
	
}

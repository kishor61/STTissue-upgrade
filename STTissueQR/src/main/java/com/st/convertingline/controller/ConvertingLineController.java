/**
 *Mar 25, 2017
 *ConvertingLineController.java
 * TODO
 *com.st.convertingline
 *ConvertingLineController.java
 *Roshan Lal Tailor
 */
package com.st.convertingline.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.gson.Gson;
import com.st.common.CommonUtil;
import com.st.convertingline.model.ConvertingLine;
import com.st.convertingline.service.ConvertingLineService;

/**
 * @author roshan
 *
 */
@Controller
@RequestMapping("/convertingline")
public class ConvertingLineController {
	
	private static Logger logger=Logger.getLogger(ConvertingLineController.class);
	private SimpleDateFormat dateFormat=new SimpleDateFormat("MM-dd-yyyy");
	
	@Autowired
	private ConvertingLineService convertinglineservice;
	
	@RequestMapping(value="/skuspecificationdataentry/view",method=RequestMethod.GET)
	public String wastepaperDetailView(Model model) {
		
		List<ConvertingLine> custname=convertinglineservice.getAllCustName();
		List<ConvertingLine> skucode=convertinglineservice.getAllSkuCode();
		List<ConvertingLine> currentData=convertinglineservice.getCurrentDateData(dateFormat.format(new Date()));
		 
		model.addAttribute("currentData", currentData);
		model.addAttribute("custname", custname);
		model.addAttribute("skucode", skucode);
		model.addAttribute("currentdate", dateFormat.format(new Date()));
		
		model.addAttribute("coreentry",true);
		model.addAttribute("backentry",false);
		return "convertingline/skuspecificationdataentry";
	}
	@RequestMapping(value="/skuspecificationdataentry/save", method=RequestMethod.POST)
	public void save(HttpServletRequest request,HttpServletResponse response,Model model) throws IOException{
		Map<String , Object> map=new HashMap<String,Object>();
		try{
			
			response.setContentType("application/json");
		
			int id=CommonUtil.checkInt(request.getParameter("id"));
			Date date=CommonUtil.checkDate(request.getParameter("date"),dateFormat);
			
			String custname=CommonUtil.checkNull(request.getParameter("custname"));
			String skucode=CommonUtil.checkNull(request.getParameter("skucode"));
			
			double january=CommonUtil.checkDouble(request.getParameter("January"));
			double february=CommonUtil.checkDouble(request.getParameter("February"));
			double march=CommonUtil.checkDouble(request.getParameter("March"));
			double april=CommonUtil.checkDouble(request.getParameter("April"));
			double may=CommonUtil.checkDouble(request.getParameter("May"));
			double june=CommonUtil.checkDouble(request.getParameter("June"));
			double july=CommonUtil.checkDouble(request.getParameter("July"));
			double august=CommonUtil.checkDouble(request.getParameter("August"));
			double september=CommonUtil.checkDouble(request.getParameter("September"));
			double october=CommonUtil.checkDouble(request.getParameter("October"));
			double november=CommonUtil.checkDouble(request.getParameter("November"));
			double december=CommonUtil.checkDouble(request.getParameter("December"));
			
			ConvertingLine data=new ConvertingLine();
			
			data.setId(id);
			data.setDate(date);
			data.setCustomer(custname);
			data.setSkucode(skucode);
			
			data.setJanuary(january);
			data.setFebruary(february);
			data.setMarch(march);
			data.setApril(april);
			data.setMay(may);
			data.setJune(june);
			data.setJuly(july);
			data.setAugust(august);
			data.setSeptember(september);
			data.setOctober(october);
			data.setNovember(november);
			data.setDecember(december);

			try{
				if(data.getId()==0){
					//Insert Into DataBase.
					int key=convertinglineservice.save(data); 
					map.put("status", true);
					map.put("id", key);
					map.put("message", "Data Saved Successfully");
					
				}else{
					//Update DataBase.
					convertinglineservice.update(data);
					map.put("status", true);
					map.put("id", data.getId());
					map.put("message", "Data Updated Successfully");
				}
			}
			catch(Exception e){
				logger.error("Roshan Says, You HAve A Problem To Save Data At ConvertingLineController.java",e);
				e.printStackTrace();
			}
			
			
		}catch(Exception e){
			logger.error("Roshan Says ,You Have A Problem In /save method Of ConvertingLineController.java",e);
			e.printStackTrace();
		}
		response.getWriter().write(new Gson().toJson(map));
	}
	@RequestMapping(value="/delete", method=RequestMethod.POST)
	public void delete(HttpServletRequest request, HttpServletResponse response) throws IOException{
		
		int id =CommonUtil.checkInt(request.getParameter("id"));
		Map<String, Object> map= new HashMap<String, Object>();
		try{
			convertinglineservice.delete(id);
			map.put("status", true);
		}catch(Exception e){
			System.out.println("Roshan Says That You Have A Problem In WinderBreakMonitoringController.java At Delete Method");
			e.printStackTrace();
		}
	response.setContentType("application/json");
	response.getWriter().write(new Gson().toJson(map));
	}
	@RequestMapping(value="/skuspecificationdataentry/add/back",method=RequestMethod.GET)
	public String addBack(Model model){
		model.addAttribute("coreentry",false);
		model.addAttribute("backentry",true);
		model.addAttribute("currentdate", dateFormat.format(new Date()));
		return "convertingline/skuspecificationdataentry";
	}
	@RequestMapping(value="/skuspecificationdataentry/view/backdateddata",method=RequestMethod.GET)
	public String viebackdateddata(HttpServletRequest request,HttpServletResponse response,Model model) {
		
		Date date1=CommonUtil.checkDate(request.getParameter("sdate"),dateFormat);
		Date date2=CommonUtil.checkDate(request.getParameter("edate"),dateFormat);
		
		List<ConvertingLine> custname=convertinglineservice.getAllCustName();
		List<ConvertingLine> skucode=convertinglineservice.getAllSkuCode();
		List<ConvertingLine> currentData=convertinglineservice.getCurrentBackDateData(date1,date2);
		 
		model.addAttribute("currentData", currentData);
		model.addAttribute("custname", custname);
		model.addAttribute("skucode", skucode);
		model.addAttribute("currentdate", dateFormat.format(new Date()));
		
		model.addAttribute("coreentry",true);
		model.addAttribute("backentry",false);
		return "convertingline/skuspecificationdataentry";
	}
	
	@RequestMapping(value="/reportview/editforecast",method=RequestMethod.GET)
	public String reportViewEditForecast(HttpServletRequest request,HttpServletResponse response,Model model) {
		
		Date date1=CommonUtil.checkDate(request.getParameter("sdate"),dateFormat);
		Date date2=CommonUtil.checkDate(request.getParameter("edate"),dateFormat);
		String customerName=CommonUtil.checkNull(request.getParameter("custname"));
		
		List<ConvertingLine> custname=convertinglineservice.getAllCustName();
		List<ConvertingLine> skucode=convertinglineservice.getAllSkuCode();
		List<ConvertingLine> currentData=convertinglineservice.getEditForecast(date1,date2,customerName);
		 
		model.addAttribute("currentData", currentData);
		model.addAttribute("custname", custname);
		model.addAttribute("skucode", skucode);
		model.addAttribute("currentdate", dateFormat.format(new Date()));
		
		model.addAttribute("coreentry",true);
		model.addAttribute("backentry",false);
		return "convertingline/editForeCastDataSearchedWise";
	}
	
	@RequestMapping(value="/skuspecificationdataentry/view/backdateddata/editid/{id}",method=RequestMethod.GET)
	public String skuSpecificationDataEntryViewBackdatedDataEditId(@PathVariable("id") int id,Model model) {
		
		
		List<ConvertingLine> custname=convertinglineservice.getAllCustName();
		List<ConvertingLine> skucode=convertinglineservice.getAllSkuCode();
		List<ConvertingLine> currentData=convertinglineservice.getskuSpecificationDataEntryViewBackdatedDataEditId(id);
		 
		model.addAttribute("currentData", currentData);
		model.addAttribute("custname", custname);
		model.addAttribute("skucode", skucode);
		model.addAttribute("currentdate", dateFormat.format(new Date()));
		
		model.addAttribute("coreentry",true);
		model.addAttribute("backentry",false);
		return "convertingline/skuspecificationdataentry";
	}
	
	//Edit ForseCaste Another Method
	@RequestMapping(value="/skuspecification/forecaste/saveorupdate", method=RequestMethod.POST)
	public void skuspecificationForecasteSaveOrUpdate(HttpServletRequest request,HttpServletResponse response,Model model) throws IOException{
		Map<String , Object> map=new HashMap<String,Object>();
		try{
			
			response.setContentType("application/json");
		
			Date date= new Date();
			
			String custname=CommonUtil.checkNull(request.getParameter("custname"));
			String skucode=CommonUtil.checkNull(request.getParameter("skucode"));
			
			double january=CommonUtil.checkDouble(request.getParameter("January"));
			double february=CommonUtil.checkDouble(request.getParameter("February"));
			double march=CommonUtil.checkDouble(request.getParameter("March"));
			double april=CommonUtil.checkDouble(request.getParameter("April"));
			double may=CommonUtil.checkDouble(request.getParameter("May"));
			double june=CommonUtil.checkDouble(request.getParameter("June"));
			double july=CommonUtil.checkDouble(request.getParameter("July"));
			double august=CommonUtil.checkDouble(request.getParameter("August"));
			double september=CommonUtil.checkDouble(request.getParameter("September"));
			double october=CommonUtil.checkDouble(request.getParameter("October"));
			double november=CommonUtil.checkDouble(request.getParameter("November"));
			double december=CommonUtil.checkDouble(request.getParameter("December"));
			
			ConvertingLine data=new ConvertingLine();
			
			
			data.setCustomer(custname);
			data.setSkucode(skucode);
			
			data.setJanuary(january);
			data.setFebruary(february);
			data.setMarch(march);
			data.setApril(april);
			data.setMay(may);
			data.setJune(june);
			data.setJuly(july);
			data.setAugust(august);
			data.setSeptember(september);
			data.setOctober(october);
			data.setNovember(november);
			data.setDecember(december);

			Date lastEntryCheck=convertinglineservice.getCheckLastEntryData(data.getCustomer(),data.getSkucode(),date);
			
			try{
				if(lastEntryCheck==null){
					//Insert Into DataBase.
					data.setDate(date);
					System.out.println("Insert");
					int key=convertinglineservice.skuspecificationForecasteSave(data); 
					map.put("status", true);
					map.put("id", key);
					map.put("message", "Data Saved Successfully");
					
				}else{
					//Update DataBase.
					data.setDate(lastEntryCheck);
					System.out.println("Update");
					convertinglineservice.skuspecificationForecasteUpdate(data);
					map.put("status", true);
					map.put("id", data.getId());
					map.put("message", "Data Updated Successfully");
				}
			}
			catch(Exception e){
				logger.error("Roshan Says, You HAve A Problem To Save Data At ConvertingLineController.java in skuspecificationForecasteSaveOrUpdate Method",e);
				e.printStackTrace();
			}
			
			
		}catch(Exception e){
			logger.error("Roshan Says, You HAve A Problem To Save Data At ConvertingLineController.java in skuspecificationForecasteSaveOrUpdate Method",e);
			e.printStackTrace();
		}
		response.getWriter().write(new Gson().toJson(map));
	}
}

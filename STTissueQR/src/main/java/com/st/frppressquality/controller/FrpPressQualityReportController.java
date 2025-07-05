/**
 * 
 */
package com.st.frppressquality.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.st.common.ColumnsOfTable;
import com.st.common.CommonUtil;
import com.st.common.FrpCommon;
import com.st.common.Workbook2007Util;
import com.st.frppressquality.model.FrpPressQuality;
import com.st.frppressquality.model.SludgeHauling;
import com.st.frppressquality.model.StickiesData;
import com.st.frppressquality.report.FrpPressQualityReportHandler;
import com.st.frppressquality.service.FrpPressQualityService;

/**
 * @author sbora
 *
 */
@Controller
@RequestMapping(value="/frppressqualityreport")
public class FrpPressQualityReportController {
	@Autowired
	private FrpPressQualityService frpPressQualityService;
	
	@Autowired
	private ServletContext context;
	
	@Autowired
	private FrpPressQualityReportHandler frpPressQualityReportHandler;
	
	
	private SimpleDateFormat dateFormat1=new SimpleDateFormat("MM-dd-yyyy");
	private SimpleDateFormat timeFormat=new SimpleDateFormat("HH:mm");
	
	
	@RequestMapping(value="/view",method=RequestMethod.GET)
	public String main(Model model){
		model.addAttribute("sdate", dateFormat1.format(new Date()));
		model.addAttribute("edate", dateFormat1.format(new Date()));
		
		model.addAttribute("qtypes", FrpCommon.getPressQualityType());
		
		return "frpPressQualityView";
	}
	
	@RequestMapping(value="/view/load",method=RequestMethod.GET)
	public String viewData(HttpServletRequest request,
			Model model){
		Date sdate=CommonUtil.checkDate(request.getParameter("sdate"), dateFormat1);
		Date edate=CommonUtil.checkDate(request.getParameter("edate"), dateFormat1);
		String type=request.getParameter("pType");
		
		model.addAttribute("qtypes", FrpCommon.getPressQualityType());
		model.addAttribute("sdate", dateFormat1.format(sdate));
		model.addAttribute("edate", dateFormat1.format(edate));
		model.addAttribute("type", type);
//		Code Starts From Here Done By Roshan Added TPQ2,SECPRESSQ Type Tailor Date :- 03/27/2015 MM/DD/YYYY 
		if(type.equalsIgnoreCase("TPQ") ||type.equalsIgnoreCase("TPQ2") || type.equalsIgnoreCase("SECPRESSQ") ||type.equalsIgnoreCase("SPC") || type.equalsIgnoreCase("WL")|| type.equalsIgnoreCase("IPSC")){
//		Code Ends Here Done By Roshan Tailor 	
			List<Map<String, Object>> qualities=new ArrayList<>();
			
			List<FrpPressQuality> frpPressQualities=frpPressQualityService.getFrpPressQualities(sdate,edate,type);
			
			try {
					qualities=formatData(frpPressQualities,type); //See Open Implementation Will Redirect Where HAve To Put Col Number Which Will Show Data On JSP PAge. 
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			model.addAttribute("qualities", qualities);
		}else if(type.equalsIgnoreCase("SH")){
			List<SludgeHauling> sludgeHaulings=frpPressQualityService.getSludgeHauling(sdate,edate);
			if(sludgeHaulings.size()==0){
				sludgeHaulings.add(new SludgeHauling());
			}
			model.addAttribute("sludgeHaulings", sludgeHaulings);
			model.addAttribute("grades", FrpCommon.getPressQualityGrade());
			model.addAttribute("ynflags", FrpCommon.getYN());
		}else if(type.equalsIgnoreCase("ST")){
			List<StickiesData> StickiesData=frpPressQualityService.getStickiesData(sdate,edate);
			if(StickiesData==null) {
				
			}
				
			
			model.addAttribute("qualities", StickiesData);
			model.addAttribute("grades", FrpCommon.getPressQualityGrade());
			model.addAttribute("ynflags", FrpCommon.getYN());
		}
		
		
		
		return "frpPressQualityView";
	}

	
	@RequestMapping(value="/export",method=RequestMethod.POST)
	public void export(HttpServletRequest request,
			HttpServletResponse response,
			Model model) throws Exception{
		Date sdate=CommonUtil.checkDate(request.getParameter("sdate"), dateFormat1);
		Date edate=CommonUtil.checkDate(request.getParameter("edate"), dateFormat1);
		String type=request.getParameter("pType");
		
		
		
			
		
		
		response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
		
		if(type.equalsIgnoreCase("TPQ"))
		{
			
			List<Map<String, Object>> qualities=new ArrayList<>();
			
			List<FrpPressQuality> frpPressQualities=frpPressQualityService.getFrpPressQualities(sdate,edate,type);
			
			qualities=formatData(frpPressQualities,type);
			
			response.setHeader("Content-Disposition", "attachment; filename=FRP Quality Report-Tertiary.xlsx");
			File file=new File(context.getRealPath("/")+"WEB-INF/FRP Quality Report-Tertiary.xlsx");

			XSSFWorkbook workbook=getFormatedWorkbook(file,qualities,type);
			workbook.write(response.getOutputStream());

		}
		
//		Code Starts From Here Done By Roshan TAilor Date :- 03/27/2015
		else if(type.equalsIgnoreCase("TPQ2"))
		{
			List<Map<String, Object>> qualities=new ArrayList<>();
			
			List<FrpPressQuality> frpPressQualities=frpPressQualityService.getFrpPressQualities(sdate,edate,type);
			
			qualities=formatData(frpPressQualities,type);
			
			response.setHeader("Content-Disposition", "attachment; filename=FRP Quality Report-Tertiary.xlsx");
			File file=new File(context.getRealPath("/")+"WEB-INF/FRP Quality Report-Tertiary 2.xlsx"); //Roshan Made A new Excel File For Tertiary Press Quality 2(TPQ2)

			XSSFWorkbook workbook=getFormatedWorkbook(file,qualities,type);
			workbook.write(response.getOutputStream());

			
		}
//		Code Ends Here Done By Roshan Tailor
//		Code Starts From Here Done By Roshan Tailor 
		else if(type.equalsIgnoreCase("SECPRESSQ"))
		{
			List<Map<String, Object>> qualities=new ArrayList<>();
			
			List<FrpPressQuality> frpPressQualities=frpPressQualityService.getFrpPressQualities(sdate,edate,type);
			
			qualities=formatData(frpPressQualities,type);
			
			response.setHeader("Content-Disposition", "attachment; filename=FRP Quality Report-Tertiary.xlsx");
			File file=new File(context.getRealPath("/")+"WEB-INF/FRP Quality Report-Secondary Press Quality.xlsx"); //Roshan Made A new Excel File For Secondary Press Quality

			XSSFWorkbook workbook=getFormatedWorkbook(file,qualities,type);
			workbook.write(response.getOutputStream());

			
		}
//		Code Ends Here Done By Roshan Tailor
		else if(type.equalsIgnoreCase("SPC")){
			
			List<Map<String, Object>> qualities=new ArrayList<>();
			
			List<FrpPressQuality> frpPressQualities=frpPressQualityService.getFrpPressQualities(sdate,edate,type);
			
			qualities=formatData(frpPressQualities,type);
			
			response.setHeader("Content-Disposition", "attachment; filename=FRP Quality Report-Sludge.xlsx");
			File file=new File(context.getRealPath("/")+"WEB-INF/FRP Quality Report-Sludge.xlsx");

			XSSFWorkbook workbook=getFormatedWorkbook(file,qualities,type);
			workbook.write(response.getOutputStream());

			
			
		}else if(type.equalsIgnoreCase("IPSC")){
			
			List<Map<String, Object>> qualities=new ArrayList<>();
			
			List<FrpPressQuality> frpPressQualities=frpPressQualityService.getFrpPressQualities(sdate,edate,type);
			
			qualities=formatData(frpPressQualities,type);
			
			response.setHeader("Content-Disposition", "attachment; filename=FRP Quality Report-Sludge.xlsx");
			File file=new File(context.getRealPath("/")+"WEB-INF/FRP Quality Report-IP Sludge.xlsx");

			XSSFWorkbook workbook=getFormatedWorkbook(file,qualities,type);
			workbook.write(response.getOutputStream());

			
			
		}else if(type.equalsIgnoreCase("WL")){
			
			List<Map<String, Object>> qualities=new ArrayList<>();
			
			List<FrpPressQuality> frpPressQualities=frpPressQualityService.getFrpPressQualities(sdate,edate,type);
			
			qualities=formatData(frpPressQualities,type);
			
			response.setHeader("Content-Disposition", "attachment; filename=FRP Quality Report-WetLap.xlsx");
			File file=new File(context.getRealPath("/")+"WEB-INF/FRP Quality Report-WetLap.xlsx");

			XSSFWorkbook workbook=getFormatedWorkbook(file,qualities,type);
			workbook.write(response.getOutputStream());

		}else if(type.equalsIgnoreCase("SH")){
			
			response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
			response.setHeader("Content-Disposition", "attachment; filename=Sludge_Hauling.xlsx");
			
			List<SludgeHauling> sludgeHaulings=frpPressQualityService.getSludgeHauling(sdate, edate); 
			
			frpPressQualityReportHandler.createSludgeHaulingReport(sludgeHaulings,response.getOutputStream());
		}
		else if(type.equalsIgnoreCase("ST")){
			
			response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
			response.setHeader("Content-Disposition", "attachment; filename=Sludge_Hauling.xlsx");
			
			List<StickiesData> StickiesData=frpPressQualityService.getStickiesData(sdate,edate);
			
			frpPressQualityReportHandler.createStickiesDataReport(StickiesData,response.getOutputStream());
		}
		

	}
	
	/**
	 * @param file
	 * @param qualities
	 * @param type
	 * @return frppressqualityreport
	 * @throws IOException 
	 */
	private XSSFWorkbook getFormatedWorkbook(File file,
			List<Map<String, Object>> datas, String type) throws IOException {
		
		
		Workbook2007Util util=new Workbook2007Util(file, 0);
		
		
		int rowCount=3;
		short hieght=280;
		int col=0;
		if(type!=null){
			if(type.equalsIgnoreCase("TPQ"))
			{
				
				
				double total=0;
				int countBrightness=0;
				
				for (Map<String, Object> map : datas) {
					
					col=0;
					
					util.addValue(rowCount, col++, map.get(ColumnsOfTable.COL_02).toString(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, hieght);
					util.addValue(rowCount, col++, map.get(ColumnsOfTable.COL_03).toString(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, hieght);
					util.addValue(rowCount, col++, map.get(ColumnsOfTable.COL_04).toString(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, hieght);
					
					util.addValue(rowCount, col++, CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_05).toString()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, hieght);
					
					double num=Double.parseDouble(map.get(ColumnsOfTable.COL_05).toString());
					if(num>0){
						countBrightness++;
					}
					total+=num;
					
					util.addValue(rowCount, col++, CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_06).toString()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, hieght);
					util.addValue(rowCount, col++, CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_07).toString()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, hieght);
					util.addValue(rowCount, col++, CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_08).toString()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, hieght);
					util.addValue(rowCount, col++, CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_09).toString()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, hieght);
					util.addValue(rowCount, col++, CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_10).toString()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, hieght);
//					Code Starts From Here Done By Roshan TAilor Date:- 03/30/2015
					util.addValue(rowCount, col++, CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_11).toString()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, hieght);
					util.addValue(rowCount, col++, CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_12).toString()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, hieght);
					util.addValue(rowCount, col++, CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_13).toString()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, hieght);
//					Code Ends Here Done By Roshan Tailor
					util.addValue(rowCount, col++, map.get(ColumnsOfTable.COL_14).toString(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, hieght);
					
					rowCount++;
					
				}
				
				double avg=0;
			//	System.out.println(total);
				
				if(datas.size()>0){
					avg=total/countBrightness;
				}
				{
					col=0;
					
					
					util.addValue(rowCount, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, hieght);
					util.addValue(rowCount, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, hieght);
					util.addValue(rowCount, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, hieght);
					util.addValue(rowCount, col++, CommonUtil.round(avg, 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER, hieght);
					
					util.addValue(rowCount, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, hieght);
										
					util.addValue(rowCount, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, hieght);
					util.addValue(rowCount, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, hieght);
					util.addValue(rowCount, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, hieght);
					util.addValue(rowCount, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, hieght);
					util.addValue(rowCount, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, hieght);
					
				}
				
				
			}
//			Code Starts From Here Done By Roshan Tailor Date :- 03/27/2015 MM/DD/YYYY
			if(type.equalsIgnoreCase("TPQ2"))
			{
				
				
				double total=0;
				int countBrightness=0;
				
				for (Map<String, Object> map : datas) {
					
					col=0;
					
					util.addValue(rowCount, col++, map.get(ColumnsOfTable.COL_02).toString(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, hieght);
					util.addValue(rowCount, col++, map.get(ColumnsOfTable.COL_03).toString(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, hieght);
					util.addValue(rowCount, col++, map.get(ColumnsOfTable.COL_16).toString(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, hieght);
					util.addValue(rowCount, col++, map.get(ColumnsOfTable.COL_04).toString(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, hieght);	
					util.addValue(rowCount, col++, CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_05).toString()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, hieght);
					
					double num=Double.parseDouble(map.get(ColumnsOfTable.COL_06).toString());
					if(num>0){
						countBrightness++;
					}
					total+=num;
//					Code Starts From Here Done BY Roshan Tailor Date :- 04/01/2015
					util.addValue(rowCount, col++, CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_06).toString()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, hieght);
//					Code Ends Here Done By Roshan Tailor
					util.addValue(rowCount, col++, CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_07).toString()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, hieght);
					util.addValue(rowCount, col++, CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_08).toString()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, hieght);
					util.addValue(rowCount, col++, CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_09).toString()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, hieght);
					util.addValue(rowCount, col++, CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_10).toString()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, hieght);
					util.addValue(rowCount, col++, CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_11).toString()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, hieght);
//					Code Starts From Here Done By Roshan Tailor Date:- 03/30/2015 For Generation Of Excel Sheet Report
					util.addValue(rowCount, col++, CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_12).toString()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, hieght);
					util.addValue(rowCount, col++, CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_13).toString()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, hieght);
					util.addValue(rowCount, col++, CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_14).toString()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, hieght);
//					Code Ends Here Done By Roshan Tailor
					util.addValue(rowCount, col++, map.get(ColumnsOfTable.COL_15).toString(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, hieght);
					
					rowCount++;
					
				}
				
				double avg=0;
			//	System.out.println(total);
				
				if(datas.size()>0){
					avg=total/countBrightness;
				}
				{
					col=0;
					
					
					util.addValue(rowCount, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, hieght);
					util.addValue(rowCount, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, hieght);
					util.addValue(rowCount, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, hieght);
					util.addValue(rowCount, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, hieght);
					
					
					util.addValue(rowCount, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, hieght);
					util.addValue(rowCount, col++, CommonUtil.round(avg, 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER, hieght);
					util.addValue(rowCount, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, hieght);
					util.addValue(rowCount, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, hieght);
					util.addValue(rowCount, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, hieght);
					util.addValue(rowCount, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, hieght);
					util.addValue(rowCount, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, hieght);
					util.addValue(rowCount, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, hieght);
					
				}
				
				
			}
//			Code Ends Here Done By Roshan Tailor
//			Code Starts From Here Done By Roshan Tailor Date :- 03/27/2015 MM/DD/YYYY
			if(type.equalsIgnoreCase("SECPRESSQ"))
			{
				
				
				double total=0;
				int countBrightness=0;
				
				for (Map<String, Object> map : datas) {
					
					col=0;
					
					util.addValue(rowCount, col++, map.get(ColumnsOfTable.COL_02).toString(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, hieght);
					util.addValue(rowCount, col++, map.get(ColumnsOfTable.COL_03).toString(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, hieght);
					//util.addValue(rowCount, col++, map.get(ColumnsOfTable.COL_05).toString(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, hieght);
					
					util.addValue(rowCount, col++, CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_05).toString()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, hieght);
					
					double num=Double.parseDouble(map.get(ColumnsOfTable.COL_05).toString());
					if(num>0){
						countBrightness++;
					}
					total+=num;
					
					util.addValue(rowCount, col++, CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_14).toString()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, hieght);
					util.addValue(rowCount, col++, CommonUtil.checkNull(map.get(ColumnsOfTable.COL_15).toString()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, hieght);
					util.addValue(rowCount, col++, CommonUtil.checkNull(map.get(ColumnsOfTable.COL_16).toString()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, hieght);
					util.addValue(rowCount, col++, CommonUtil.checkNull(map.get(ColumnsOfTable.COL_11).toString()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, hieght);
			
					rowCount++;
					
				}
				
				double avg=0;
			//	System.out.println(total);
				
				if(datas.size()>0){
					avg=total/countBrightness;
				}
				{
					col=0;
					
					
					util.addValue(rowCount, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, hieght);
					util.addValue(rowCount, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, hieght);
					util.addValue(rowCount, col++, CommonUtil.round(avg, 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER, hieght);
					util.addValue(rowCount, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, hieght);
					
					util.addValue(rowCount, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, hieght);
										
					util.addValue(rowCount, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, hieght);
					util.addValue(rowCount, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, hieght);
					util.addValue(rowCount, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, hieght);
					util.addValue(rowCount, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, hieght);
					util.addValue(rowCount, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, hieght);
					
				}
				
				
			}
//			Code Ends Here Done By Roshan Tailor
			else if(type.equalsIgnoreCase("SPC")){				for (Map<String, Object> map : datas) {
					col=0;
					
					util.addValue(rowCount, col++, map.get(ColumnsOfTable.COL_02).toString(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, hieght);
					util.addValue(rowCount, col++, map.get(ColumnsOfTable.COL_03).toString(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, hieght);
					util.addValue(rowCount, col++, map.get(ColumnsOfTable.COL_04).toString(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, hieght);
					
					util.addValue(rowCount, col++, CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_05).toString()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, hieght);
					
					util.addValue(rowCount, col++, map.get(ColumnsOfTable.COL_06)==null?"":map.get(ColumnsOfTable.COL_06).toString(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, hieght);
					util.addValue(rowCount, col++, map.get(ColumnsOfTable.COL_07)==null?"":map.get(ColumnsOfTable.COL_07).toString(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, hieght);
					util.addValue(rowCount, col++, map.get(ColumnsOfTable.COL_08).toString(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, hieght);
					
					rowCount++;				
				}
			
				
			}else if(type.equalsIgnoreCase("IPSC")){
				for (Map<String, Object> map : datas) {
					col=0;
					util.addValue(rowCount, col++, map.get(ColumnsOfTable.COL_02).toString(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, hieght);
					util.addValue(rowCount, col++, CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_03).toString()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, hieght);
					util.addValue(rowCount, col++, CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_04).toString()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, hieght);
					util.addValue(rowCount, col++, map.get(ColumnsOfTable.COL_06)==null?"":map.get(ColumnsOfTable.COL_06).toString(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, hieght);
					
					rowCount++;
				}
			
				
			}else if(type.equalsIgnoreCase("WL")){
				for (Map<String, Object> map : datas) {

					col=0;
					util.addValue(rowCount, col++, map.get(ColumnsOfTable.COL_02).toString(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, hieght);
					util.addValue(rowCount, col++, map.get(ColumnsOfTable.COL_03).toString(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, hieght);
					util.addValue(rowCount, col++, CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_04).toString()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, hieght);
					util.addValue(rowCount, col++, CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_05).toString()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, hieght);
					util.addValue(rowCount, col++, map.get(ColumnsOfTable.COL_06)==null?"":map.get(ColumnsOfTable.COL_06).toString(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, hieght);
					
					util.addValue(rowCount, col++, CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_07).toString()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, hieght);
					util.addValue(rowCount, col++, CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_08).toString()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, hieght);
					util.addValue(rowCount, col++, CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_09).toString()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, hieght);
					util.addValue(rowCount, col++, CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_10).toString()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, hieght);
					util.addValue(rowCount, col++, CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_11).toString()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, hieght);
					util.addValue(rowCount, col++,  map.get(ColumnsOfTable.COL_12)==null?"":map.get(ColumnsOfTable.COL_12).toString(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, hieght);
					
					
					rowCount++;
				}
				
			}
		}
		
		return util.getWorkbook();
	}

	/**
	 * @param frpPressQualities
	 * @param type
	 * @return
	 */
	private List<Map<String, Object>> formatData(
			List<FrpPressQuality> frpPressQualities, String type) {
		
		
		List<Map<String, Object>> datas=new ArrayList<>();
		
		if(type!=null)
		{
			if(type.equalsIgnoreCase("TPQ"))
			{
				
				for (FrpPressQuality frpPressQuality : frpPressQualities) {
					Map<String, Object> map=new HashMap<String, Object>();
					map.put(ColumnsOfTable.COL_01, frpPressQuality.getId());
					map.put(ColumnsOfTable.COL_02, dateFormat1.format(frpPressQuality.getDate()));
					map.put(ColumnsOfTable.COL_03, timeFormat.format(frpPressQuality.getDate()));
					map.put(ColumnsOfTable.COL_04, frpPressQuality.getInitials());
					map.put(ColumnsOfTable.COL_05, frpPressQuality.getBrightness());
//					Code Starts From Here Done By Roshan Tailor Date :- 03/30/2015
					map.put(ColumnsOfTable.COL_06, frpPressQuality.getLvalue());
					map.put(ColumnsOfTable.COL_07, frpPressQuality.getAvalue());
					map.put(ColumnsOfTable.COL_08, frpPressQuality.getBvalue());
//					Code Ends Here Done By Roshan Tailor 
					map.put(ColumnsOfTable.COL_09, frpPressQuality.getDirt());
					map.put(ColumnsOfTable.COL_10, frpPressQuality.getStickies());
					map.put(ColumnsOfTable.COL_11, frpPressQuality.getAsh());
					map.put(ColumnsOfTable.COL_12, frpPressQuality.getConsistency());
					map.put(ColumnsOfTable.COL_13, frpPressQuality.getFreeness());
					map.put(ColumnsOfTable.COL_14, frpPressQuality.getComments());
					datas.add(map);
				}
				
				
			}
//			Code Starts From Here Done By Roshan Tailor Added TPQ2 Date :- 03/27/2015 MM/DD/YYYY
			else if(type.equalsIgnoreCase("TPQ2"))
			{
				for (FrpPressQuality frpPressQuality : frpPressQualities) {
					Map<String, Object> map=new HashMap<String, Object>();
					map.put(ColumnsOfTable.COL_01, frpPressQuality.getId());
					map.put(ColumnsOfTable.COL_02, dateFormat1.format(frpPressQuality.getDate()));
					map.put(ColumnsOfTable.COL_03, timeFormat.format(frpPressQuality.getDate()));
					map.put(ColumnsOfTable.COL_04, frpPressQuality.getInitials());
//					Code Starts From Here Done By Roshan Tailor Date :- 04/01/2015
					map.put(ColumnsOfTable.COL_05, frpPressQuality.getBleachingchemical());
//					Code Ends Here Done By Roshan Tailor
					map.put(ColumnsOfTable.COL_06, frpPressQuality.getBrightness());
//					Code Starts From Here Done By Roshan Tailor Date ;- 03/30/2015
					map.put(ColumnsOfTable.COL_07, frpPressQuality.getLvalue());
					map.put(ColumnsOfTable.COL_08, frpPressQuality.getAvalue());
					map.put(ColumnsOfTable.COL_09, frpPressQuality.getBvalue());
//					Code Ends HEre Done By Roshan Tailor 
					map.put(ColumnsOfTable.COL_10, frpPressQuality.getDirt());
					map.put(ColumnsOfTable.COL_11, frpPressQuality.getStickies());
					map.put(ColumnsOfTable.COL_12, frpPressQuality.getAsh());
					map.put(ColumnsOfTable.COL_13, frpPressQuality.getConsistency());
					map.put(ColumnsOfTable.COL_14, frpPressQuality.getFreeness());
					map.put(ColumnsOfTable.COL_15, frpPressQuality.getComments());
					map.put(ColumnsOfTable.COL_16, frpPressQuality.getLine());
					datas.add(map);
				}
			}
//			Code Ends Here Done By Roshan Tailor 
//			Code Starts From Here Done By Roshan Tailor Added SECPRESSQ Date :- 063/27/2015
			else if(type.equalsIgnoreCase("SECPRESSQ"))
			{
				for (FrpPressQuality frpPressQuality : frpPressQualities) {
					
					Map<String, Object> map=new HashMap<String, Object>();
					map.put(ColumnsOfTable.COL_01, frpPressQuality.getId());
					map.put(ColumnsOfTable.COL_02, dateFormat1.format(frpPressQuality.getDate()));
					map.put(ColumnsOfTable.COL_03, timeFormat.format(frpPressQuality.getDate()));
					map.put(ColumnsOfTable.COL_04, frpPressQuality.getInitials());
					map.put(ColumnsOfTable.COL_05, frpPressQuality.getBrightness());
					map.put(ColumnsOfTable.COL_06, frpPressQuality.getDirt());
					map.put(ColumnsOfTable.COL_07, frpPressQuality.getStickies());
					map.put(ColumnsOfTable.COL_08, frpPressQuality.getAsh());
					map.put(ColumnsOfTable.COL_09, frpPressQuality.getConsistency());
					map.put(ColumnsOfTable.COL_10, frpPressQuality.getFreeness());
					map.put(ColumnsOfTable.COL_11, frpPressQuality.getComments());
					
					map.put(ColumnsOfTable.COL_12, frpPressQuality.getQualityType());
					map.put(ColumnsOfTable.COL_13, frpPressQuality.getFreeness());
					map.put(ColumnsOfTable.COL_14, frpPressQuality.getEric());
					map.put(ColumnsOfTable.COL_15, frpPressQuality.getAstar());
					map.put(ColumnsOfTable.COL_16, frpPressQuality.getBstar());
					
					datas.add(map);
			}	
				}
//			Code Ends Here Done By Roshan Tailor
			else if(type.equalsIgnoreCase("SPC")){				
				for (FrpPressQuality frpPressQuality : frpPressQualities) {
					Map<String, Object> map=new HashMap<String, Object>();
					map.put(ColumnsOfTable.COL_01, frpPressQuality.getId());
					map.put(ColumnsOfTable.COL_02, dateFormat1.format(frpPressQuality.getDate()));
					map.put(ColumnsOfTable.COL_03, timeFormat.format(frpPressQuality.getDate()));
					map.put(ColumnsOfTable.COL_04, frpPressQuality.getInitials());
					map.put(ColumnsOfTable.COL_05, frpPressQuality.getConsistency());
					map.put(ColumnsOfTable.COL_06, FrpCommon.getPressQualityGrade().get(frpPressQuality.getGrade()));
					map.put(ColumnsOfTable.COL_07, FrpCommon.getYN().get(frpPressQuality.getCuRunning()));
					map.put(ColumnsOfTable.COL_08, frpPressQuality.getComments());
					datas.add(map);
					
				}
				
			}else if(type.equalsIgnoreCase("IPSC")){
				
				for (FrpPressQuality frpPressQuality : frpPressQualities) {
					Map<String, Object> map=new HashMap<String, Object>();
					map.put(ColumnsOfTable.COL_01, frpPressQuality.getId());
					map.put(ColumnsOfTable.COL_02, dateFormat1.format(frpPressQuality.getDate()));
					map.put(ColumnsOfTable.COL_03, frpPressQuality.getConsistency());
					map.put(ColumnsOfTable.COL_04, frpPressQuality.getComments());
					datas.add(map);
					
				}
				
			}else if(type.equalsIgnoreCase("WL")){
				
				for (FrpPressQuality frpPressQuality : frpPressQualities) {
					Map<String, Object> map=new HashMap<String, Object>();
					map.put(ColumnsOfTable.COL_01, frpPressQuality.getId());
					map.put(ColumnsOfTable.COL_02, dateFormat1.format(frpPressQuality.getDate()));
					map.put(ColumnsOfTable.COL_03, timeFormat.format(frpPressQuality.getDate()));
					map.put(ColumnsOfTable.COL_04, frpPressQuality.getLot());
					map.put(ColumnsOfTable.COL_05, frpPressQuality.getBrightness());
					map.put(ColumnsOfTable.COL_06, FrpCommon.getPressQualityGrade().get(frpPressQuality.getGrade()));
					map.put(ColumnsOfTable.COL_07, frpPressQuality.getStickies());
					map.put(ColumnsOfTable.COL_08, frpPressQuality.getDirt());
					map.put(ColumnsOfTable.COL_09, frpPressQuality.getConsistency());
					map.put(ColumnsOfTable.COL_10, frpPressQuality.getAsh());
					map.put(ColumnsOfTable.COL_11, frpPressQuality.getFreeness());
					map.put(ColumnsOfTable.COL_12, frpPressQuality.getComments());
					datas.add(map);
				}
				
			}
		}
		
		return datas;
	}
}

/**
 *May 10, 2018
 *CenterlineReportPM5Controller.java
 * TODO
 *com.st.centerlinePM5.controller
 *CenterlineReportPM5Controller.java
 *Roshan Lal Tailor
 */
package com.st.centerlinePM5.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.st.centerline.model.CenterlineData;
import com.st.centerline.model.CenterlineGrade;
import com.st.centerline.report.CenterlineReportHandler;
import com.st.centerlinePM5.service.CenterlinePM5Service;
import com.st.common.CenterlineUtil;
import com.st.common.Columns;
import com.st.common.ColumnsOfTable;
import com.st.common.CommonUtil;

/**
 * @author roshan
 *
 */
@Controller
@RequestMapping(value="/pm5centerlinereport")
public class CenterlineReportPM5Controller {
	
	//private static Logger logger=LoggerFactory.getLogger(CenterlineReportController.class);
	
	@Autowired
	private ServletContext context;
	
	@Autowired
	private CenterlinePM5Service centerlineService;
	
	@Autowired
	private CenterlineReportHandler centerlineReportHandler;

	private SimpleDateFormat dateFormat1 = new SimpleDateFormat("MM-dd-yyyy");

	
	@RequestMapping(value = "/view", method = RequestMethod.GET)
	public String viewCenterlineData(Model model) {

		model.addAttribute("clgrades", centerlineService.getCenterlineGrades());
		model.addAttribute("sdate", dateFormat1.format(new Date()));
		model.addAttribute("edate", dateFormat1.format(new Date()));
		
		return "PM5/centerlineView";
	}
	
	@RequestMapping(value = "/load", method = RequestMethod.POST)
	public String viewDataCenterlineData(@RequestParam("sdate")String sdate,
			@RequestParam("edate")String edate,
			@RequestParam("grade")int grade,
			Model model) {

		List<Map<String, Object>> datas=new ArrayList<>();
		
		model.addAttribute("clgrades", centerlineService.getCenterlineGrades());

		model.addAttribute("sdate", sdate);
		model.addAttribute("edate", edate);
		model.addAttribute("grade", grade);
		Date dateS=null;
		Date dateE=null;
		try {
			dateS=dateFormat1.parse(sdate);
			dateE=dateFormat1.parse(edate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		
		
		List<CenterlineData> centerlineDatas=null;
		if(dateE!=null && dateS!=null){
			if(grade!=0){
				centerlineDatas=centerlineService.getCenterlineData(dateS, dateE, grade);
			}else{
				centerlineDatas=centerlineService.getCenterlineData(dateS, dateE);
			}
		}
		
		if(centerlineDatas!=null){
			datas=formatData(centerlineDatas);
			//System.out.println(datas);
		}
		
		model.addAttribute("datas", datas);
		
		return "PM5/centerlineView";
	}
	
	
	@RequestMapping(value = "/view2", method = RequestMethod.GET)
	public String viewCenterlineData2(Model model) {

		model.addAttribute("clgrades", centerlineService.getCenterlineGrades());
		model.addAttribute("sdate", dateFormat1.format(new Date()));
		model.addAttribute("edate", dateFormat1.format(new Date()));
		
		return "PM5/centerlineView2";
	}
	
	@RequestMapping(value = "/load2", method = RequestMethod.POST)
	public String viewDataCenterlineData2(@RequestParam("sdate")String sdate,
			@RequestParam("edate")String edate,
			@RequestParam("grade")int grade,
			Model model) {

		model.addAttribute("clgrades", centerlineService.getCenterlineGrades());

		model.addAttribute("sdate", sdate);
		model.addAttribute("edate", edate);
		model.addAttribute("grade", grade);
		Date dateS=null;
		Date dateE=null;
		try {
			dateS=dateFormat1.parse(sdate);
			dateE=dateFormat1.parse(edate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		
		if(grade!=0){
			List<CenterlineData> centerlineDatas=centerlineService.getCenterlineData(dateS, dateE, grade);
			CenterlineGrade centerlineGrade=centerlineService.getCenterlineGrade(grade);
			
			model.addAttribute("centerlineDatas", centerlineDatas);
			model.addAttribute("centerlineGrade", centerlineGrade);	
			
			model.addAttribute("single", true);
			model.addAttribute("multiple", false);	
			
			return "PM5/centerlineView2";
		}else{
			
			/*List<CenterlineGrade> centerlineDatas=centerlineService.getCenterlineDataSinglrOrAllSearch(dateS, dateE);
			
			model.addAttribute("centerlineDatas", centerlineDatas);
			model.addAttribute("single", false);
			model.addAttribute("multiple", true);*/
			
			List<Map<String, Object>> datas=new ArrayList<>();
			List<CenterlineData> centerlineDatas=null;
			if(dateE!=null && dateS!=null){
				if(grade!=0){
					centerlineDatas=centerlineService.getCenterlineData(dateS, dateE, grade);
				}else{
					centerlineDatas=centerlineService.getCenterlineData(dateS, dateE);
				}
			}
			
			if(centerlineDatas!=null){
				datas=formatData(centerlineDatas);
				//System.out.println(datas);
			}
			
			model.addAttribute("datas", datas);
			
			return "PM5/centerlineView2_AllToShow";
		}
		
		
		
		
	}

	
	
	@RequestMapping(value = "/export", method = RequestMethod.POST)
	public void exportDataCenterlineData(@RequestParam("sdate")String sdate,
			@RequestParam("edate")String edate,
			@RequestParam("grade")int grade,
			HttpServletRequest request,
			HttpServletResponse response,
			Model model) {

		List<Map<String, Object>> datas=new ArrayList<>();

		Date dateS=null;
		Date dateE=null;
		try {
			dateS=dateFormat1.parse(sdate);
			dateE=dateFormat1.parse(edate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		
		
		List<CenterlineData> centerlineDatas=null;
		if(dateE!=null && dateS!=null){
			if(grade!=0){
				centerlineDatas=centerlineService.getCenterlineData(dateS, dateE, grade);
			}else{
				centerlineDatas=centerlineService.getCenterlineData(dateS, dateE);
			}
		}
		
		if(centerlineDatas!=null){
			datas=formatData(centerlineDatas);
		}
		
		response.setContentType("application/vnd.ms-excel");
		response.setHeader("Content-Disposition", "attachment; filename=ST Tissue-CenterlineReport.xls");
		
		File file=new File(context.getRealPath("/")+"WEB-INF/CenterlineReport.xls");

		try {
			HSSFWorkbook workbook=getFormatedWorkbook(file,datas);
			workbook.write(response.getOutputStream());
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	@RequestMapping(value = "/export2", method = RequestMethod.POST)
	public void exportDataCenterlineData2(@RequestParam("sdate")String sdate,
			@RequestParam("edate")String edate,
			@RequestParam("grade")int grade,
			HttpServletResponse response) throws Exception {

		Date dateS=null;
		Date dateE=null;
		try {
			dateS=dateFormat1.parse(sdate);
			dateE=dateFormat1.parse(edate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		
		
		List<CenterlineData> centerlineDatas=centerlineService.getCenterlineData(dateS, dateE, grade);;
		
		CenterlineGrade centerlineGrade=centerlineService.getCenterlineGrade(grade);
		
		
		
		response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
		response.setHeader("Content-Disposition", "attachment; filename=ST Tissue-CenterlineReport.xlsx");
		
		centerlineReportHandler.createCenterlineReport(centerlineDatas,centerlineGrade,response.getOutputStream());
	}
	
	
	/**
	 * @param file
	 * @param datas
	 * @return
	 * @throws IOException 
	 */
	private HSSFWorkbook getFormatedWorkbook(File file,
			List<Map<String, Object>> datas) throws IOException {
		
		
		
		
		FileInputStream inputStream=new FileInputStream(file);
		HSSFWorkbook workbook=new HSSFWorkbook(inputStream);
		HSSFCellStyle headerCellStyle=workbook.createCellStyle();
		headerCellStyle.setWrapText(true);
		headerCellStyle.setAlignment(HorizontalAlignment.LEFT);
		headerCellStyle.setBorderBottom(BorderStyle.THIN);
		headerCellStyle.setBorderLeft(BorderStyle.THIN);
		headerCellStyle.setBorderRight(BorderStyle.THIN);
		headerCellStyle.setBorderTop(BorderStyle.THIN);
		
		Font headerFont=workbook.createFont();
		//headerFont.setBoldweight(Font.BOLDWEIGHT_BOLD);
		headerFont.setBold(true);
		headerCellStyle.setFont(headerFont);
		
		
		
		HSSFSheet sheet=workbook.getSheetAt(0);

		
		
		Font objectFont=workbook.createFont();
		objectFont.setBold(true);
		objectFont.setColor(IndexedColors.BLUE.getIndex());
		
		HSSFCellStyle objectCellStyle=workbook.createCellStyle();
		objectCellStyle.setBorderBottom(BorderStyle.THIN);
		objectCellStyle.setBorderLeft(BorderStyle.THIN);
		objectCellStyle.setBorderRight(BorderStyle.THIN);
		objectCellStyle.setBorderTop(BorderStyle.THIN);
		objectCellStyle.setAlignment(HorizontalAlignment.CENTER);
		objectCellStyle.setFont(objectFont);
		objectCellStyle.setFillForegroundColor(IndexedColors.LIGHT_YELLOW.getIndex());
		objectCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		
		Font objectFontRed=workbook.createFont();
		objectFontRed.setBold(true);
		objectFontRed.setColor(IndexedColors.RED.getIndex());


		Font fontRow=workbook.createFont();
		fontRow.setBold(true);
		fontRow.setColor(IndexedColors.BLACK.getIndex());
		
		HSSFCellStyle rowCellStyle=workbook.createCellStyle();
		rowCellStyle.setBorderBottom(BorderStyle.THIN);
		rowCellStyle.setBorderLeft(BorderStyle.THIN);
		rowCellStyle.setBorderRight(BorderStyle.THIN);
		rowCellStyle.setBorderTop(BorderStyle.THIN);
		rowCellStyle.setFont(fontRow);
		rowCellStyle.setAlignment(HorizontalAlignment.CENTER);
		rowCellStyle.setVerticalAlignment(VerticalAlignment.TOP);
		rowCellStyle.setWrapText(true);
		
		HSSFCellStyle rowCellStyleRed=workbook.createCellStyle();
		rowCellStyleRed.setBorderBottom(BorderStyle.THIN);
		rowCellStyleRed.setBorderLeft(BorderStyle.THIN);
		rowCellStyleRed.setBorderRight(BorderStyle.THIN);
		rowCellStyleRed.setBorderTop(BorderStyle.THIN);
		rowCellStyleRed.setFont(fontRow);
		rowCellStyleRed.setAlignment(HorizontalAlignment.CENTER);
		rowCellStyleRed.setFillForegroundColor(IndexedColors.RED.getIndex());
		rowCellStyleRed.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		rowCellStyle.setVerticalAlignment(VerticalAlignment.TOP);
		rowCellStyle.setWrapText(true);
	
		
		HSSFCellStyle rowCellStyleGreen=workbook.createCellStyle();
		rowCellStyleGreen.setBorderBottom(BorderStyle.THIN);
		rowCellStyleGreen.setBorderLeft(BorderStyle.THIN);
		rowCellStyleGreen.setBorderRight(BorderStyle.THIN);
		rowCellStyleGreen.setBorderTop(BorderStyle.THIN);
		rowCellStyleGreen.setFont(fontRow);
		rowCellStyleGreen.setAlignment(HorizontalAlignment.CENTER);
		rowCellStyleGreen.setFillForegroundColor(IndexedColors.GREEN.getIndex());
		rowCellStyleGreen.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		rowCellStyle.setVerticalAlignment(VerticalAlignment.TOP);
		rowCellStyle.setWrapText(true);
		
		int rowCount=1;
		for (Map<String, Object> map : datas) {
			HSSFRow row=sheet.createRow(rowCount);
			row.setHeight((short)280);
			if(map.get(ColumnsOfTable.COL_01).equals("OB")){
				HSSFCell COL_01=row.createCell(Columns.COL_00);
				COL_01.setCellStyle(objectCellStyle);
				COL_01.setCellValue("OBJECTIVE");
				
				HSSFCell COL_02=row.createCell(Columns.COL_01);
				COL_02.setCellStyle(objectCellStyle);
				COL_02.setCellValue(map.get(ColumnsOfTable.COL_49).toString());
				
				HSSFCell COL_03=row.createCell(Columns.COL_02);
				COL_03.setCellStyle(objectCellStyle);
				COL_03.setCellValue(map.get(ColumnsOfTable.COL_50).toString());
				
				HSSFCell COL_04=row.createCell(Columns.COL_03);
				COL_04.setCellStyle(objectCellStyle);
				COL_04.setCellValue(map.get(ColumnsOfTable.COL_51).toString());
				
				
				HSSFCell COL_blank=row.createCell(Columns.COL_04);
				COL_blank.setCellStyle(objectCellStyle);
				COL_blank.setCellValue("");
				
				
				HSSFCell COL_05=row.createCell(Columns.COL_05);
				COL_05.setCellStyle(objectCellStyle);
				COL_05.setCellValue(CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_02).toString()));
				
				HSSFCell COL_06=row.createCell(Columns.COL_06);
				COL_06.setCellStyle(objectCellStyle);
				COL_06.setCellValue(CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_03).toString()));
				
				HSSFCell COL_07=row.createCell(Columns.COL_07);
				COL_07.setCellStyle(objectCellStyle);
				COL_07.setCellValue(CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_04).toString()));
				
				HSSFCell COL_08=row.createCell(Columns.COL_08);
				COL_08.setCellStyle(objectCellStyle);
				COL_08.setCellValue(CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_05).toString()));
				
				HSSFCell COL_09=row.createCell(Columns.COL_09);
				COL_09.setCellStyle(objectCellStyle);
				COL_09.setCellValue(CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_06).toString()));
				
				HSSFCell COL_10=row.createCell(Columns.COL_10);
				COL_10.setCellStyle(objectCellStyle);
				COL_10.setCellValue(CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_07).toString()));
				
				HSSFCell COL_11=row.createCell(Columns.COL_11);
				COL_11.setCellStyle(objectCellStyle);
				COL_11.setCellValue(CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_08).toString()));
				
				HSSFCell COL_12=row.createCell(Columns.COL_12);
				COL_12.setCellStyle(objectCellStyle);
				COL_12.setCellValue(CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_09).toString()));
				
				HSSFCell COL_13=row.createCell(Columns.COL_13);
				COL_13.setCellStyle(objectCellStyle);
				COL_13.setCellValue(CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_10).toString()));
				
				//New Field
				HSSFCell COL_55=row.createCell(Columns.COL_14);
				COL_55.setCellStyle(objectCellStyle);
				COL_55.setCellValue(CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_55).toString()));
				
				HSSFCell COL_blank2=row.createCell(Columns.COL_14);
				COL_blank2.setCellStyle(objectCellStyle);
				COL_blank2.setCellValue("");
				
				HSSFCell COL_14=row.createCell(Columns.COL_16);
				COL_14.setCellStyle(objectCellStyle);
				COL_14.setCellValue(CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_11).toString()));
				
				HSSFCell COL_15=row.createCell(Columns.COL_17);
				COL_15.setCellStyle(objectCellStyle);
				COL_15.setCellValue(map.get(ColumnsOfTable.COL_12)==null?"":map.get(ColumnsOfTable.COL_12).toString());
				
				HSSFCell COL_16=row.createCell(Columns.COL_18);
				COL_16.setCellStyle(objectCellStyle);
				COL_16.setCellValue(CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_13).toString()));
				
				HSSFCell COL_17=row.createCell(Columns.COL_19);
				COL_17.setCellStyle(objectCellStyle);
				COL_17.setCellValue(CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_14).toString()));
				
				HSSFCell COL_18=row.createCell(Columns.COL_20);
				COL_18.setCellStyle(objectCellStyle);
				COL_18.setCellValue(CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_15).toString()));
				
				HSSFCell COL_19=row.createCell(Columns.COL_21);
				COL_19.setCellStyle(objectCellStyle);
				COL_19.setCellValue(CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_16).toString()));
				
				HSSFCell COL_20=row.createCell(Columns.COL_22);
				COL_20.setCellStyle(objectCellStyle);
				COL_20.setCellValue(CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_17).toString()));
				
				HSSFCell COL_21=row.createCell(Columns.COL_23);
				COL_21.setCellStyle(objectCellStyle);
				COL_21.setCellValue(CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_18).toString()));
				
				HSSFCell COL_22=row.createCell(Columns.COL_24);
				COL_22.setCellStyle(objectCellStyle);
				COL_22.setCellValue(CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_19).toString()));
				
				HSSFCell COL_23=row.createCell(Columns.COL_25);
				COL_23.setCellStyle(objectCellStyle);
				COL_23.setCellValue(CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_20).toString()));
				
				HSSFCell COL_24=row.createCell(Columns.COL_26);
				COL_24.setCellStyle(objectCellStyle);
				COL_24.setCellValue(CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_21).toString()));
				
				HSSFCell COL_25=row.createCell(Columns.COL_27);
				COL_25.setCellStyle(objectCellStyle);
				COL_25.setCellValue(CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_22).toString()));
				
				HSSFCell COL_26=row.createCell(Columns.COL_28);
				COL_26.setCellStyle(objectCellStyle);
				COL_26.setCellValue(CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_23).toString()));
				
				HSSFCell COL_27=row.createCell(Columns.COL_29);
				COL_27.setCellStyle(objectCellStyle);
				COL_27.setCellValue(CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_24).toString()));
				
				HSSFCell COL_28=row.createCell(Columns.COL_30);
				COL_28.setCellStyle(objectCellStyle);
				COL_28.setCellValue(CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_25).toString()));
				
				HSSFCell COL_29=row.createCell(Columns.COL_31);
				COL_29.setCellStyle(objectCellStyle);
				COL_29.setCellValue(CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_26).toString()));
				
				HSSFCell COL_30=row.createCell(Columns.COL_32);
				COL_30.setCellStyle(objectCellStyle);
				COL_30.setCellValue(CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_27).toString()));
				
				HSSFCell COL_31=row.createCell(Columns.COL_33);
				COL_31.setCellStyle(objectCellStyle);
				COL_31.setCellValue(CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_28).toString()));
				
				HSSFCell COL_32=row.createCell(Columns.COL_34);
				COL_32.setCellStyle(objectCellStyle);
				COL_32.setCellValue(CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_29).toString()));
				
				HSSFCell COL_33=row.createCell(Columns.COL_35);
				COL_33.setCellStyle(objectCellStyle);
				COL_33.setCellValue(CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_30).toString()));
				
				HSSFCell COL_34=row.createCell(Columns.COL_36);
				COL_34.setCellStyle(objectCellStyle);
				COL_34.setCellValue(CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_31).toString()));
				
				HSSFCell COL_35=row.createCell(Columns.COL_37);
				COL_35.setCellStyle(objectCellStyle);
				COL_35.setCellValue(CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_32).toString()));
				
				HSSFCell COL_36=row.createCell(Columns.COL_38);
				COL_36.setCellStyle(objectCellStyle);
				COL_36.setCellValue(CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_33).toString()));
				
				HSSFCell COL_37=row.createCell(Columns.COL_39);
				COL_37.setCellStyle(objectCellStyle);
				COL_37.setCellValue(CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_34).toString()));
				
				HSSFCell COL_38=row.createCell(Columns.COL_40);
				COL_38.setCellStyle(objectCellStyle);
				COL_38.setCellValue(map.get(ColumnsOfTable.COL_35)==null?"":map.get(ColumnsOfTable.COL_35).toString());
				
				HSSFCell COL_56=row.createCell(Columns.COL_41);
				COL_56.setCellStyle(objectCellStyle);
				COL_56.setCellValue(map.get(ColumnsOfTable.COL_56)==null?"":map.get(ColumnsOfTable.COL_56).toString());
				
				
				HSSFCell COL_39=row.createCell(Columns.COL_42);
				COL_39.setCellStyle(objectCellStyle);
				COL_39.setCellValue(map.get(ColumnsOfTable.COL_36)==null?"":map.get(ColumnsOfTable.COL_36).toString());
				
				
				HSSFCell COL_57=row.createCell(Columns.COL_43);
				COL_57.setCellStyle(objectCellStyle);
				COL_57.setCellValue(map.get(ColumnsOfTable.COL_57)==null?"":map.get(ColumnsOfTable.COL_57).toString());
				
				
				HSSFCell COL_40=row.createCell(Columns.COL_44);
				COL_40.setCellStyle(objectCellStyle);
				COL_40.setCellValue(CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_37).toString()));
				
				HSSFCell COL_41=row.createCell(Columns.COL_45);
				COL_41.setCellStyle(objectCellStyle);
				COL_41.setCellValue(CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_38).toString()));
				
				
				HSSFCell COL_42=row.createCell(Columns.COL_46);
				COL_42.setCellStyle(objectCellStyle);
				COL_42.setCellValue(CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_39).toString()));
				
				HSSFCell COL_43=row.createCell(Columns.COL_47);
				COL_43.setCellStyle(objectCellStyle);
				COL_43.setCellValue(CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_40).toString()));
				
				HSSFCell COL_44=row.createCell(Columns.COL_48);
				COL_44.setCellStyle(objectCellStyle);
				COL_44.setCellValue(CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_41).toString()));
				
				HSSFCell COL_45=row.createCell(Columns.COL_49);
				COL_45.setCellStyle(objectCellStyle);
				COL_45.setCellValue(CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_42).toString()));
				
				HSSFCell COL_46=row.createCell(Columns.COL_50);
				COL_46.setCellStyle(objectCellStyle);
				COL_46.setCellValue(CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_43).toString()));
				
				HSSFCell COL_47=row.createCell(Columns.COL_51);
				COL_47.setCellStyle(objectCellStyle);
				COL_47.setCellValue(CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_44).toString()));
				
				HSSFCell COL_48=row.createCell(Columns.COL_52);
				COL_48.setCellStyle(objectCellStyle);
				COL_48.setCellValue(CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_45).toString()));
				
				HSSFCell COL_49=row.createCell(Columns.COL_53);
				COL_49.setCellStyle(objectCellStyle);
				COL_49.setCellValue(CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_46).toString()));
				
				HSSFCell COL_50=row.createCell(Columns.COL_54);
				COL_50.setCellStyle(objectCellStyle);
				COL_50.setCellValue(CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_47).toString()));
				
				HSSFCell COL_51=row.createCell(Columns.COL_55);
				COL_51.setCellStyle(objectCellStyle);
				COL_51.setCellValue(CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_48).toString()));
				
				HSSFCell COL_52=row.createCell(Columns.COL_56);
				COL_52.setCellStyle(objectCellStyle);
				COL_52.setCellValue("");
				HSSFCell COL_53=row.createCell(Columns.COL_57);
				COL_53.setCellStyle(objectCellStyle);
				COL_53.setCellValue("");
			}else{
				
				
				
				HSSFCell COL_01=row.createCell(Columns.COL_00);
				COL_01.setCellStyle(rowCellStyle);
				COL_01.setCellValue(map.get(ColumnsOfTable.COL_01)==null?"":map.get(ColumnsOfTable.COL_01).toString());

				HSSFCell COL_02=row.createCell(Columns.COL_01);
				COL_02.setCellStyle(rowCellStyle);
				COL_02.setCellValue(map.get(ColumnsOfTable.COL_49)==null?"":map.get(ColumnsOfTable.COL_49).toString());

				HSSFCell COL_03=row.createCell(Columns.COL_02);
				COL_03.setCellStyle(rowCellStyle);
				COL_03.setCellValue(map.get(ColumnsOfTable.COL_50)==null?"":map.get(ColumnsOfTable.COL_50).toString());

				HSSFCell COL_04=row.createCell(Columns.COL_03);
				COL_04.setCellStyle(rowCellStyle);
				COL_04.setCellValue(map.get(ColumnsOfTable.COL_51)==null?"":map.get(ColumnsOfTable.COL_51).toString());


				HSSFCell COL_05=row.createCell(Columns.COL_05);
				if(map.get(ColumnsOfTable.COL_02_C).toString().equalsIgnoreCase("redcolor")){
					COL_05.setCellStyle(rowCellStyleRed);
				}else if(map.get(ColumnsOfTable.COL_02_C).toString().equalsIgnoreCase("greencolor")){
					COL_05.setCellStyle(rowCellStyleGreen);
				}else{
					COL_05.setCellStyle(rowCellStyle);	
				}
				COL_05.setCellValue(map.get(ColumnsOfTable.COL_02)==null?0:CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_02).toString()));

				HSSFCell COL_06=row.createCell(Columns.COL_06);
				if(map.get(ColumnsOfTable.COL_03_C).toString().equalsIgnoreCase("redcolor")){
					COL_06.setCellStyle(rowCellStyleRed);
				}else if(map.get(ColumnsOfTable.COL_03_C).toString().equalsIgnoreCase("greencolor")){
					COL_06.setCellStyle(rowCellStyleGreen);
				}else{
					COL_06.setCellStyle(rowCellStyle);	
				}
				COL_06.setCellValue(map.get(ColumnsOfTable.COL_03)==null?0:CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_03).toString()));

				HSSFCell COL_07=row.createCell(Columns.COL_07);
				if(map.get(ColumnsOfTable.COL_04_C).toString().equalsIgnoreCase("redcolor")){
					COL_07.setCellStyle(rowCellStyleRed);
				}else if(map.get(ColumnsOfTable.COL_04_C).toString().equalsIgnoreCase("greencolor")){
					COL_07.setCellStyle(rowCellStyleGreen);	
				}else{
					COL_07.setCellStyle(rowCellStyle);	
				}
				COL_07.setCellValue(map.get(ColumnsOfTable.COL_04)==null?0:CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_04).toString()));

				HSSFCell COL_08=row.createCell(Columns.COL_08);
				if(map.get(ColumnsOfTable.COL_05_C).toString().equalsIgnoreCase("redcolor")){
					COL_08.setCellStyle(rowCellStyleRed);
				}else if(map.get(ColumnsOfTable.COL_05_C).toString().equalsIgnoreCase("greencolor")){
					COL_08.setCellStyle(rowCellStyleGreen);
				}else{
					COL_08.setCellStyle(rowCellStyle);	
				}
				COL_08.setCellValue(map.get(ColumnsOfTable.COL_05)==null?0:CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_05).toString()));

				HSSFCell COL_09=row.createCell(Columns.COL_09);
				if(map.get(ColumnsOfTable.COL_06_C).toString().equalsIgnoreCase("redcolor")){
					COL_09.setCellStyle(rowCellStyleRed);
				}else if(map.get(ColumnsOfTable.COL_06_C).toString().equalsIgnoreCase("greencolor")){
					COL_09.setCellStyle(rowCellStyleGreen);
				}else{
					COL_09.setCellStyle(rowCellStyle);	
				}
				COL_09.setCellValue(map.get(ColumnsOfTable.COL_06)==null?0:CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_06).toString()));

				HSSFCell COL_10=row.createCell(Columns.COL_10);
				if(map.get(ColumnsOfTable.COL_07_C).toString().equalsIgnoreCase("redcolor")){
					COL_10.setCellStyle(rowCellStyleRed);
				}else if(map.get(ColumnsOfTable.COL_07_C).toString().equalsIgnoreCase("greencolor")){
					COL_10.setCellStyle(rowCellStyleGreen);
				}else{
					COL_10.setCellStyle(rowCellStyle);	
				}
				COL_10.setCellValue(map.get(ColumnsOfTable.COL_07)==null?0:CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_07).toString()));

				HSSFCell COL_11=row.createCell(Columns.COL_11);
				if(map.get(ColumnsOfTable.COL_08_C).toString().equalsIgnoreCase("redcolor")){
					COL_11.setCellStyle(rowCellStyleRed);
				}else if(map.get(ColumnsOfTable.COL_08_C).toString().equalsIgnoreCase("greencolor")){
					COL_11.setCellStyle(rowCellStyleGreen);
				}else{
					COL_11.setCellStyle(rowCellStyle);	
				}
				COL_11.setCellValue(map.get(ColumnsOfTable.COL_08)==null?0:CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_08).toString()));

				HSSFCell COL_12=row.createCell(Columns.COL_12);
				if(map.get(ColumnsOfTable.COL_09_C).toString().equalsIgnoreCase("redcolor")){
					COL_12.setCellStyle(rowCellStyleRed);
				}else if(map.get(ColumnsOfTable.COL_09_C).toString().equalsIgnoreCase("greencolor")){
					COL_12.setCellStyle(rowCellStyleGreen);
				}else{
					COL_12.setCellStyle(rowCellStyle);	
				}
				COL_12.setCellValue(map.get(ColumnsOfTable.COL_09)==null?0:CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_09).toString()));

				HSSFCell COL_13=row.createCell(Columns.COL_13);
				if(map.get(ColumnsOfTable.COL_10_C).toString().equalsIgnoreCase("redcolor")){
					COL_13.setCellStyle(rowCellStyleRed);
				}else if(map.get(ColumnsOfTable.COL_10_C).toString().equalsIgnoreCase("greencolor")){
					COL_13.setCellStyle(rowCellStyleGreen);
				}else{
					COL_13.setCellStyle(rowCellStyle);	
				}
				COL_13.setCellValue(map.get(ColumnsOfTable.COL_10)==null?0:CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_10).toString()));

				
				//New Field
				
				HSSFCell COL_55=row.createCell(Columns.COL_14);
				if(map.get(ColumnsOfTable.COL_55_C).toString().equalsIgnoreCase("redcolor")){
					COL_55.setCellStyle(rowCellStyleRed);
				}else if(map.get(ColumnsOfTable.COL_55_C).toString().equalsIgnoreCase("greencolor")){
					COL_55.setCellStyle(rowCellStyleGreen);
				}else{
					COL_55.setCellStyle(rowCellStyle);	
				}
				COL_55.setCellValue(map.get(ColumnsOfTable.COL_55)==null?0:CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_55).toString()));

				
				
				HSSFCell COL_14=row.createCell(Columns.COL_16);
				if(map.get(ColumnsOfTable.COL_11_C).toString().equalsIgnoreCase("redcolor")){
					COL_14.setCellStyle(rowCellStyleRed);
				}else if(map.get(ColumnsOfTable.COL_11_C).toString().equalsIgnoreCase("greencolor")){
					COL_14.setCellStyle(rowCellStyleGreen);
				}else{
					COL_14.setCellStyle(rowCellStyle);	
				}
				COL_14.setCellValue(map.get(ColumnsOfTable.COL_11)==null?0:CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_11).toString()));

				HSSFCell COL_15=row.createCell(Columns.COL_17);
				if(map.get(ColumnsOfTable.COL_12_C).toString().equalsIgnoreCase("redcolor")){
					COL_15.setCellStyle(rowCellStyleRed);
				}else if(map.get(ColumnsOfTable.COL_12_C).toString().equalsIgnoreCase("greencolor")){
					COL_15.setCellStyle(rowCellStyleGreen);
				}else{
					COL_15.setCellStyle(rowCellStyle);	
				}
				COL_15.setCellValue(map.get(ColumnsOfTable.COL_12)==null?"":map.get(ColumnsOfTable.COL_12).toString());

				HSSFCell COL_16=row.createCell(Columns.COL_18);
				if(map.get(ColumnsOfTable.COL_13_C).toString().equalsIgnoreCase("redcolor")){
					COL_16.setCellStyle(rowCellStyleRed);
				}else if(map.get(ColumnsOfTable.COL_13_C).toString().equalsIgnoreCase("greencolor")){
					COL_16.setCellStyle(rowCellStyleGreen);
				}else{
					COL_16.setCellStyle(rowCellStyle);	
				}
				COL_16.setCellValue(map.get(ColumnsOfTable.COL_13)==null?0:CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_13).toString()));

				HSSFCell COL_17=row.createCell(Columns.COL_19);
				if(map.get(ColumnsOfTable.COL_14_C).toString().equalsIgnoreCase("redcolor")){
					COL_17.setCellStyle(rowCellStyleRed);
				}else if(map.get(ColumnsOfTable.COL_14_C).toString().equalsIgnoreCase("greencolor")){
					COL_17.setCellStyle(rowCellStyleGreen);
				}else{
					COL_17.setCellStyle(rowCellStyle);	
				}
				COL_17.setCellValue(map.get(ColumnsOfTable.COL_14)==null?0:CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_14).toString()));

				HSSFCell COL_18=row.createCell(Columns.COL_20);
				if(map.get(ColumnsOfTable.COL_15_C).toString().equalsIgnoreCase("redcolor")){
					COL_18.setCellStyle(rowCellStyleRed);
				}else if(map.get(ColumnsOfTable.COL_15_C).toString().equalsIgnoreCase("greencolor")){
					COL_18.setCellStyle(rowCellStyleGreen);
				}else{
					COL_18.setCellStyle(rowCellStyle);	
				}
				COL_18.setCellValue(map.get(ColumnsOfTable.COL_15)==null?0:CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_15).toString()));

				HSSFCell COL_19=row.createCell(Columns.COL_21);
				if(map.get(ColumnsOfTable.COL_16_C).toString().equalsIgnoreCase("redcolor")){
					COL_19.setCellStyle(rowCellStyleRed);
				}else if(map.get(ColumnsOfTable.COL_16_C).toString().equalsIgnoreCase("greencolor")){
					COL_19.setCellStyle(rowCellStyleGreen);
				}else{
					COL_19.setCellStyle(rowCellStyle);	
				}
				COL_19.setCellValue(map.get(ColumnsOfTable.COL_16)==null?0:CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_16).toString()));

				HSSFCell COL_20=row.createCell(Columns.COL_22);
				if(map.get(ColumnsOfTable.COL_17_C).toString().equalsIgnoreCase("redcolor")){
					COL_20.setCellStyle(rowCellStyleRed);
				}else if(map.get(ColumnsOfTable.COL_17_C).toString().equalsIgnoreCase("greencolor")){
					COL_20.setCellStyle(rowCellStyleGreen);
				}else{
					COL_20.setCellStyle(rowCellStyle);	
				}
				COL_20.setCellValue(map.get(ColumnsOfTable.COL_17)==null?0:CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_17).toString()));

				HSSFCell COL_21=row.createCell(Columns.COL_23);
				if(map.get(ColumnsOfTable.COL_18_C).toString().equalsIgnoreCase("redcolor")){
					COL_21.setCellStyle(rowCellStyleRed);
				}else if(map.get(ColumnsOfTable.COL_18_C).toString().equalsIgnoreCase("greencolor")){
					COL_21.setCellStyle(rowCellStyleGreen);
				}else{
					COL_21.setCellStyle(rowCellStyle);	
				}
				COL_21.setCellValue(map.get(ColumnsOfTable.COL_18)==null?0:CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_18).toString()));

				HSSFCell COL_22=row.createCell(Columns.COL_24);
				if(map.get(ColumnsOfTable.COL_19_C).toString().equalsIgnoreCase("redcolor")){
					COL_22.setCellStyle(rowCellStyleRed);
				}else if(map.get(ColumnsOfTable.COL_19_C).toString().equalsIgnoreCase("greencolor")){
					COL_22.setCellStyle(rowCellStyleGreen);
				}else{
					COL_22.setCellStyle(rowCellStyle);	
				}
				COL_22.setCellValue(map.get(ColumnsOfTable.COL_19)==null?0:CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_19).toString()));

				HSSFCell COL_23=row.createCell(Columns.COL_25);
				if(map.get(ColumnsOfTable.COL_20_C).toString().equalsIgnoreCase("redcolor")){
					COL_23.setCellStyle(rowCellStyleRed);
				}else if(map.get(ColumnsOfTable.COL_20_C).toString().equalsIgnoreCase("greencolor")){
					COL_23.setCellStyle(rowCellStyleGreen);
				}else{
					COL_23.setCellStyle(rowCellStyle);
				}
				COL_23.setCellValue(map.get(ColumnsOfTable.COL_20)==null?0:CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_20).toString()));

				HSSFCell COL_24=row.createCell(Columns.COL_26);
				if(map.get(ColumnsOfTable.COL_21_C).toString().equalsIgnoreCase("redcolor")){
					COL_24.setCellStyle(rowCellStyleRed);
				}else if(map.get(ColumnsOfTable.COL_21_C).toString().equalsIgnoreCase("greencolor")){
					COL_24.setCellStyle(rowCellStyleGreen);
				}else{
					COL_24.setCellStyle(rowCellStyle);	
				}
				COL_24.setCellValue(map.get(ColumnsOfTable.COL_21)==null?0:CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_21).toString()));

				HSSFCell COL_25=row.createCell(Columns.COL_27);
				if(map.get(ColumnsOfTable.COL_22_C).toString().equalsIgnoreCase("redcolor")){
					COL_25.setCellStyle(rowCellStyleRed);
				}else if(map.get(ColumnsOfTable.COL_22_C).toString().equalsIgnoreCase("greencolor")){
					COL_25.setCellStyle(rowCellStyleGreen);
				}else{
					COL_25.setCellStyle(rowCellStyle);	
				}
				COL_25.setCellValue(map.get(ColumnsOfTable.COL_22)==null?0:CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_22).toString()));

				HSSFCell COL_26=row.createCell(Columns.COL_28);
				if(map.get(ColumnsOfTable.COL_23_C).toString().equalsIgnoreCase("redcolor")){
					COL_26.setCellStyle(rowCellStyleRed);
				}else if(map.get(ColumnsOfTable.COL_23_C).toString().equalsIgnoreCase("greencolor")){
					COL_26.setCellStyle(rowCellStyleGreen);
				}else{
					COL_26.setCellStyle(rowCellStyle);	
				}
				COL_26.setCellValue(map.get(ColumnsOfTable.COL_23)==null?0:CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_23).toString()));

				HSSFCell COL_27=row.createCell(Columns.COL_29);
				if(map.get(ColumnsOfTable.COL_24_C).toString().equalsIgnoreCase("redcolor")){
					COL_27.setCellStyle(rowCellStyleRed);
				}else if(map.get(ColumnsOfTable.COL_24_C).toString().equalsIgnoreCase("greencolor")){
					COL_27.setCellStyle(rowCellStyleGreen);
				}else{
					COL_27.setCellStyle(rowCellStyle);	
				}
				COL_27.setCellValue(map.get(ColumnsOfTable.COL_24)==null?0:CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_24).toString()));

				HSSFCell COL_28=row.createCell(Columns.COL_30);
				if(map.get(ColumnsOfTable.COL_25_C).toString().equalsIgnoreCase("redcolor")){
					COL_28.setCellStyle(rowCellStyleRed);
				}else if(map.get(ColumnsOfTable.COL_25_C).toString().equalsIgnoreCase("greencolor")){
					COL_28.setCellStyle(rowCellStyleGreen);
				}else{
					COL_28.setCellStyle(rowCellStyle);	
				}
				COL_28.setCellValue(map.get(ColumnsOfTable.COL_25)==null?0:CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_25).toString()));

				HSSFCell COL_29=row.createCell(Columns.COL_31);
				if(map.get(ColumnsOfTable.COL_26_C).toString().equalsIgnoreCase("redcolor")){
					COL_29.setCellStyle(rowCellStyleRed);
				}else if(map.get(ColumnsOfTable.COL_26_C).toString().equalsIgnoreCase("greencolor")){
					COL_29.setCellStyle(rowCellStyleGreen);
				}else{
					COL_29.setCellStyle(rowCellStyle);
				}
				COL_29.setCellValue(map.get(ColumnsOfTable.COL_26)==null?0:CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_26).toString()));

				HSSFCell COL_30=row.createCell(Columns.COL_32);
				if(map.get(ColumnsOfTable.COL_27_C).toString().equalsIgnoreCase("redcolor")){
					COL_30.setCellStyle(rowCellStyleRed);
				}else if(map.get(ColumnsOfTable.COL_27_C).toString().equalsIgnoreCase("greencolor")){
					COL_30.setCellStyle(rowCellStyleGreen);
				}else{
					COL_30.setCellStyle(rowCellStyle);	
				}
				COL_30.setCellValue(map.get(ColumnsOfTable.COL_27)==null?0:CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_27).toString()));

				HSSFCell COL_31=row.createCell(Columns.COL_33);
				if(map.get(ColumnsOfTable.COL_28_C).toString().equalsIgnoreCase("redcolor")){
					COL_31.setCellStyle(rowCellStyleRed);
				}else if(map.get(ColumnsOfTable.COL_28_C).toString().equalsIgnoreCase("greencolor")){
					COL_31.setCellStyle(rowCellStyleGreen);
				}else{
					COL_31.setCellStyle(rowCellStyle);	
				}
				COL_31.setCellValue(map.get(ColumnsOfTable.COL_28)==null?0:CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_28).toString()));

				HSSFCell COL_32=row.createCell(Columns.COL_34);
				if(map.get(ColumnsOfTable.COL_29_C).toString().equalsIgnoreCase("redcolor")){
					COL_32.setCellStyle(rowCellStyleRed);
				}else if(map.get(ColumnsOfTable.COL_29_C).toString().equalsIgnoreCase("greencolor")){
					COL_32.setCellStyle(rowCellStyleGreen);
				}else{
					COL_32.setCellStyle(rowCellStyle);	
				}
				COL_32.setCellValue(map.get(ColumnsOfTable.COL_29)==null?0:CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_29).toString()));

				HSSFCell COL_33=row.createCell(Columns.COL_35);
				if(map.get(ColumnsOfTable.COL_30_C).toString().equalsIgnoreCase("redcolor")){
					COL_33.setCellStyle(rowCellStyleRed);
				}else if(map.get(ColumnsOfTable.COL_30_C).toString().equalsIgnoreCase("greencolor")){
					COL_33.setCellStyle(rowCellStyleGreen);
				}else{
					COL_33.setCellStyle(rowCellStyle);	
				}
				COL_33.setCellValue(map.get(ColumnsOfTable.COL_30)==null?0:CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_30).toString()));

				HSSFCell COL_34=row.createCell(Columns.COL_36);
				if(map.get(ColumnsOfTable.COL_31_C).toString().equalsIgnoreCase("redcolor")){
					COL_34.setCellStyle(rowCellStyleRed);
				}else if(map.get(ColumnsOfTable.COL_31_C).toString().equalsIgnoreCase("greencolor")){
					COL_34.setCellStyle(rowCellStyleGreen);
				}else{
					COL_34.setCellStyle(rowCellStyle);	
				}
				COL_34.setCellValue(map.get(ColumnsOfTable.COL_31)==null?0:CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_31).toString()));

				HSSFCell COL_35=row.createCell(Columns.COL_37);
				if(map.get(ColumnsOfTable.COL_32_C).toString().equalsIgnoreCase("redcolor")){
					COL_35.setCellStyle(rowCellStyleRed);
				}else if(map.get(ColumnsOfTable.COL_32_C).toString().equalsIgnoreCase("greencolor")){
					COL_35.setCellStyle(rowCellStyleGreen);
				}else{
					COL_35.setCellStyle(rowCellStyle);	
				}
				COL_35.setCellValue(map.get(ColumnsOfTable.COL_32)==null?0:CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_32).toString()));

				HSSFCell COL_36=row.createCell(Columns.COL_38);
				if(map.get(ColumnsOfTable.COL_33_C).toString().equalsIgnoreCase("redcolor")){
					COL_36.setCellStyle(rowCellStyleRed);
				}else if(map.get(ColumnsOfTable.COL_33_C).toString().equalsIgnoreCase("greencolor")){
					COL_36.setCellStyle(rowCellStyleGreen);
				}else{
					COL_36.setCellStyle(rowCellStyle);
				}
				COL_36.setCellValue(map.get(ColumnsOfTable.COL_33)==null?0:CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_33).toString()));

				HSSFCell COL_37=row.createCell(Columns.COL_39);
				if(map.get(ColumnsOfTable.COL_34_C).toString().equalsIgnoreCase("redcolor")){
					COL_37.setCellStyle(rowCellStyleRed);
				}else if(map.get(ColumnsOfTable.COL_34_C).toString().equalsIgnoreCase("greencolor")){
					COL_37.setCellStyle(rowCellStyleGreen);
				}else{
					COL_37.setCellStyle(rowCellStyle);	
				}
				COL_37.setCellValue(map.get(ColumnsOfTable.COL_34)==null?0:CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_34).toString()));

				HSSFCell COL_38=row.createCell(Columns.COL_40);
				if(map.get(ColumnsOfTable.COL_35_C).toString().equalsIgnoreCase("redcolor")){
					COL_38.setCellStyle(rowCellStyleRed);
				}else if(map.get(ColumnsOfTable.COL_35_C).toString().equalsIgnoreCase("greencolor")){
					COL_38.setCellStyle(rowCellStyleGreen);
				}else{
					COL_38.setCellStyle(rowCellStyle);	
				}
				COL_38.setCellValue(map.get(ColumnsOfTable.COL_35)==null?"":map.get(ColumnsOfTable.COL_35).toString());

				
				
				//New Field
				HSSFCell COL_56=row.createCell(Columns.COL_41);
				if(map.get(ColumnsOfTable.COL_56_C).toString().equalsIgnoreCase("redcolor")){
					COL_56.setCellStyle(rowCellStyleRed);
				}else if(map.get(ColumnsOfTable.COL_56_C).toString().equalsIgnoreCase("greencolor")){
					COL_56.setCellStyle(rowCellStyleGreen);
				}else{
					COL_56.setCellStyle(rowCellStyle);	
				}
				COL_56.setCellValue(map.get(ColumnsOfTable.COL_56)==null?"":map.get(ColumnsOfTable.COL_56).toString());

				
				
				HSSFCell COL_39=row.createCell(Columns.COL_42);
				if(map.get(ColumnsOfTable.COL_36_C).toString().equalsIgnoreCase("redcolor")){
					COL_39.setCellStyle(rowCellStyleRed);
				}else if(map.get(ColumnsOfTable.COL_36_C).toString().equalsIgnoreCase("greencolor")){
					COL_39.setCellStyle(rowCellStyleGreen);
				}else{
					COL_39.setCellStyle(rowCellStyle);	
				}
				COL_39.setCellValue(map.get(ColumnsOfTable.COL_36)==null?"":map.get(ColumnsOfTable.COL_36).toString());

				
				//New Field
				HSSFCell COL_57=row.createCell(Columns.COL_43);
				if(map.get(ColumnsOfTable.COL_57_C).toString().equalsIgnoreCase("redcolor")){
					COL_57.setCellStyle(rowCellStyleRed);
				}else if(map.get(ColumnsOfTable.COL_57_C).toString().equalsIgnoreCase("greencolor")){
					COL_57.setCellStyle(rowCellStyleGreen);
				}else{
					COL_57.setCellStyle(rowCellStyle);	
				}
				COL_57.setCellValue(map.get(ColumnsOfTable.COL_57)==null?"":map.get(ColumnsOfTable.COL_57).toString());

				

				HSSFCell COL_40=row.createCell(Columns.COL_44);
				if(map.get(ColumnsOfTable.COL_37_C).toString().equalsIgnoreCase("redcolor")){
					COL_40.setCellStyle(rowCellStyleRed);
				}else if(map.get(ColumnsOfTable.COL_37_C).toString().equalsIgnoreCase("greencolor")){
					COL_40.setCellStyle(rowCellStyleGreen);
				}else{
					COL_40.setCellStyle(rowCellStyle);	
				}
				COL_40.setCellValue(map.get(ColumnsOfTable.COL_37)==null?0:CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_37).toString()));

				HSSFCell COL_41=row.createCell(Columns.COL_45);
				if(map.get(ColumnsOfTable.COL_38_C).toString().equalsIgnoreCase("redcolor")){
					COL_41.setCellStyle(rowCellStyleRed);
				}else if(map.get(ColumnsOfTable.COL_38_C).toString().equalsIgnoreCase("greencolor")){
					COL_41.setCellStyle(rowCellStyleGreen);
				}else{
					COL_41.setCellStyle(rowCellStyle);	
				}
				COL_41.setCellValue(map.get(ColumnsOfTable.COL_38)==null?0:CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_38).toString()));


				HSSFCell COL_42=row.createCell(Columns.COL_46);
				if(map.get(ColumnsOfTable.COL_39_C).toString().equalsIgnoreCase("redcolor")){
					COL_42.setCellStyle(rowCellStyleRed);
				}else if(map.get(ColumnsOfTable.COL_39_C).toString().equalsIgnoreCase("greencolor")){
					COL_42.setCellStyle(rowCellStyleGreen);
				}else{
					COL_42.setCellStyle(rowCellStyle);	
				}
				COL_42.setCellValue(map.get(ColumnsOfTable.COL_39)==null?0:CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_39).toString()));

				HSSFCell COL_43=row.createCell(Columns.COL_47);
				if(map.get(ColumnsOfTable.COL_40_C).toString().equalsIgnoreCase("redcolor")){
					COL_43.setCellStyle(rowCellStyleRed);
				}else if(map.get(ColumnsOfTable.COL_40_C).toString().equalsIgnoreCase("greencolor")){
					COL_43.setCellStyle(rowCellStyleGreen);
				}else{
					COL_43.setCellStyle(rowCellStyle);
				}
				COL_43.setCellValue(map.get(ColumnsOfTable.COL_40)==null?0:CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_40).toString()));

				HSSFCell COL_44=row.createCell(Columns.COL_48);
				if(map.get(ColumnsOfTable.COL_41_C).toString().equalsIgnoreCase("redcolor")){
					COL_44.setCellStyle(rowCellStyleRed);
				}else if(map.get(ColumnsOfTable.COL_41_C).toString().equalsIgnoreCase("greencolor")){
					COL_44.setCellStyle(rowCellStyleGreen);
				}else{
					COL_44.setCellStyle(rowCellStyle);	
				}
				COL_44.setCellValue(map.get(ColumnsOfTable.COL_41)==null?0:CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_41).toString()));

				HSSFCell COL_45=row.createCell(Columns.COL_49);
				if(map.get(ColumnsOfTable.COL_42_C).toString().equalsIgnoreCase("redcolor")){
					COL_45.setCellStyle(rowCellStyleRed);
				}else if(map.get(ColumnsOfTable.COL_42_C).toString().equalsIgnoreCase("greencolor")){
					COL_45.setCellStyle(rowCellStyleGreen);
				}else{
					COL_45.setCellStyle(rowCellStyle);	
				}
				COL_45.setCellValue(map.get(ColumnsOfTable.COL_42)==null?0:CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_42).toString()));

				HSSFCell COL_46=row.createCell(Columns.COL_50);
				if(map.get(ColumnsOfTable.COL_43_C).toString().equalsIgnoreCase("redcolor")){
					COL_46.setCellStyle(rowCellStyleRed);
				}else if(map.get(ColumnsOfTable.COL_43_C).toString().equalsIgnoreCase("greencolor")){
					COL_46.setCellStyle(rowCellStyleGreen);
				}else{
					COL_46.setCellStyle(rowCellStyle);	
				}
				COL_46.setCellValue(map.get(ColumnsOfTable.COL_43)==null?0:CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_43).toString()));

				HSSFCell COL_47=row.createCell(Columns.COL_51);
				if(map.get(ColumnsOfTable.COL_44_C).toString().equalsIgnoreCase("redcolor")){
					COL_47.setCellStyle(rowCellStyleRed);
				}else if(map.get(ColumnsOfTable.COL_44_C).toString().equalsIgnoreCase("greencolor")){
					COL_47.setCellStyle(rowCellStyleGreen);
				}else{
					COL_47.setCellStyle(rowCellStyle);
				}
				COL_47.setCellValue(map.get(ColumnsOfTable.COL_44)==null?0:CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_44).toString()));

				HSSFCell COL_48=row.createCell(Columns.COL_52);
				if(map.get(ColumnsOfTable.COL_45_C).toString().equalsIgnoreCase("redcolor")){
					COL_48.setCellStyle(rowCellStyleRed);
				}else if(map.get(ColumnsOfTable.COL_45_C).toString().equalsIgnoreCase("greencolor")){
					COL_48.setCellStyle(rowCellStyleGreen);
				}else{
					COL_48.setCellStyle(rowCellStyle);
				}
				COL_48.setCellValue(map.get(ColumnsOfTable.COL_45)==null?0:CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_45).toString()));

				HSSFCell COL_49=row.createCell(Columns.COL_53);
				if(map.get(ColumnsOfTable.COL_46_C).toString().equalsIgnoreCase("redcolor")){
					COL_49.setCellStyle(rowCellStyleRed);
				}else if(map.get(ColumnsOfTable.COL_46_C).toString().equalsIgnoreCase("greencolor")){
					COL_49.setCellStyle(rowCellStyleGreen);
				}else{
					COL_49.setCellStyle(rowCellStyle);	
				}
				COL_49.setCellValue(map.get(ColumnsOfTable.COL_46)==null?0:CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_46).toString()));

				HSSFCell COL_50=row.createCell(Columns.COL_54);
				if(map.get(ColumnsOfTable.COL_47_C).toString().equalsIgnoreCase("redcolor")){
					COL_50.setCellStyle(rowCellStyleRed);
				}else if(map.get(ColumnsOfTable.COL_47_C).toString().equalsIgnoreCase("greencolor")){
					COL_50.setCellStyle(rowCellStyleGreen);
				}else{
					COL_50.setCellStyle(rowCellStyle);
				}
				COL_50.setCellValue(map.get(ColumnsOfTable.COL_47)==null?0:CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_47).toString()));

				HSSFCell COL_51=row.createCell(Columns.COL_55);
				if(map.get(ColumnsOfTable.COL_48_C).toString().equalsIgnoreCase("redcolor")){
					COL_51.setCellStyle(rowCellStyleRed);
				}else if(map.get(ColumnsOfTable.COL_48_C).toString().equalsIgnoreCase("greencolor")){
					COL_51.setCellStyle(rowCellStyleGreen);
				}else{
					COL_51.setCellStyle(rowCellStyle);
				}COL_51.setCellValue(map.get(ColumnsOfTable.COL_48)==null?0:CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_48).toString()));


				HSSFCell COL_52=row.createCell(Columns.COL_56);
				COL_52.setCellStyle(rowCellStyle);
				COL_52.setCellValue(map.get(ColumnsOfTable.COL_53)==null?"":map.get(ColumnsOfTable.COL_53).toString());
				
				
				HSSFCell COL_53=row.createCell(Columns.COL_57);
				COL_53.setCellStyle(rowCellStyle);
				COL_53.setCellValue(map.get(ColumnsOfTable.COL_54)==null?"":map.get(ColumnsOfTable.COL_54).toString());
			}

			rowCount++;
		}
		
		
		return workbook;
	}

	/**
	 * @param centerlineDatas
	 * @return
	 */
	private List<Map<String, Object>> formatData(
			List<CenterlineData> centerlineDatas) {
		
		
		CenterlineGrade centerlineGrade=null;
		int grade=0;
		
		List<Map<String, Object>> datas=new ArrayList<>();
		
		for (CenterlineData centerlineData : centerlineDatas) {
			
			
			
			if(centerlineData.getGradeId()!=grade){
				try {
					centerlineGrade=centerlineService.getCenterlineGrade(centerlineData.getGradeId());
				} catch (Exception e) {
					//logger.error("Grade code '"+centerlineData.getGrade()+"' not exist in master", e);
					continue;
				}
				

				grade=centerlineGrade.getId();
			
				Map<String, Object> obMap=new HashMap<String, Object>();
				obMap.put(ColumnsOfTable.COL_01, "OB");

				obMap.put(ColumnsOfTable.COL_02, centerlineGrade.getYankeeSpeed());
				obMap.put(ColumnsOfTable.COL_03, centerlineGrade.getQcsBasisWtTarget());
				obMap.put(ColumnsOfTable.COL_04, centerlineGrade.getReelMoisture());
				obMap.put(ColumnsOfTable.COL_05, centerlineGrade.getCrepe());
				obMap.put(ColumnsOfTable.COL_06, centerlineGrade.getYankeeSteam());
				obMap.put(ColumnsOfTable.COL_07, centerlineGrade.getYankeeRelease());
				obMap.put(ColumnsOfTable.COL_08, centerlineGrade.getYankeeAdesive());
				obMap.put(ColumnsOfTable.COL_09, centerlineGrade.getJetWireRatio());
				obMap.put(ColumnsOfTable.COL_10, centerlineGrade.getFanPumpFlowRate());
				obMap.put(ColumnsOfTable.COL_11, centerlineGrade.getAfterDryerSteam());
				obMap.put(ColumnsOfTable.COL_12, centerlineGrade.getSprLoading());
				obMap.put(ColumnsOfTable.COL_13, centerlineGrade.getFeltPassivator());
				obMap.put(ColumnsOfTable.COL_14, centerlineGrade.getSprayboomPressure());
				obMap.put(ColumnsOfTable.COL_15, centerlineGrade.getSprayboomTemparature());
				obMap.put(ColumnsOfTable.COL_16, centerlineGrade.getWefanSpeed());
				obMap.put(ColumnsOfTable.COL_17, centerlineGrade.getDefanSpeed());
				obMap.put(ColumnsOfTable.COL_18, centerlineGrade.getMakeUpAirDamper());
				obMap.put(ColumnsOfTable.COL_19, centerlineGrade.getExhaustDamper());
				obMap.put(ColumnsOfTable.COL_20, centerlineGrade.getExhaustFanSpeed());
				obMap.put(ColumnsOfTable.COL_21, centerlineGrade.getWehoodTemperature());
				obMap.put(ColumnsOfTable.COL_22, centerlineGrade.getDehoodTemperature());
				obMap.put(ColumnsOfTable.COL_23, centerlineGrade.getYankeeAP());
				obMap.put(ColumnsOfTable.COL_24, centerlineGrade.getAfterDryerAP());
				obMap.put(ColumnsOfTable.COL_25, centerlineGrade.getSecArmLoading());
				obMap.put(ColumnsOfTable.COL_26, centerlineGrade.getReelOffset());
				obMap.put(ColumnsOfTable.COL_27, centerlineGrade.getUhleBoxNorthValve());
				obMap.put(ColumnsOfTable.COL_28, centerlineGrade.getUhleBoxSouthValve());
				obMap.put(ColumnsOfTable.COL_29, centerlineGrade.getFaltBox1VacuumValve());
				obMap.put(ColumnsOfTable.COL_30, centerlineGrade.getFaltBox2VacuumValve());
				obMap.put(ColumnsOfTable.COL_31, centerlineGrade.getFaltBox4VacuumValve());
				obMap.put(ColumnsOfTable.COL_32, centerlineGrade.getFanPumpSpeed());
				obMap.put(ColumnsOfTable.COL_33, centerlineGrade.getTotalHead());
				obMap.put(ColumnsOfTable.COL_34, centerlineGrade.getHeadboxLevel());
				obMap.put(ColumnsOfTable.COL_35, centerlineGrade.getHorizontalSlice());
				obMap.put(ColumnsOfTable.COL_36, centerlineGrade.getVerticalSlice());
				obMap.put(ColumnsOfTable.COL_37, centerlineGrade.getSelectifierRejectFlow1());
				obMap.put(ColumnsOfTable.COL_38, centerlineGrade.getSelectifierRejectFlow2());
				obMap.put(ColumnsOfTable.COL_39, centerlineGrade.getSecScreenCycleTime());
				obMap.put(ColumnsOfTable.COL_40, centerlineGrade.getLowDensityCycleTime());
				obMap.put(ColumnsOfTable.COL_41, centerlineGrade.getRefinersEnergy());
				obMap.put(ColumnsOfTable.COL_42, centerlineGrade.getNumberOfRefiners());
				obMap.put(ColumnsOfTable.COL_43, centerlineGrade.getRefinerInletConsistency());
				obMap.put(ColumnsOfTable.COL_44, centerlineGrade.getMachineChestConsistency());
				obMap.put(ColumnsOfTable.COL_45, centerlineGrade.getStockFlow());
				obMap.put(ColumnsOfTable.COL_46, centerlineGrade.getSweetnerFlow());
				obMap.put(ColumnsOfTable.COL_47, centerlineGrade.getBroke());
				obMap.put(ColumnsOfTable.COL_48, centerlineGrade.getWetStrength());
				
				obMap.put(ColumnsOfTable.COL_49, centerlineGrade.getGrade());
				
				obMap.put(ColumnsOfTable.COL_50, "");
				obMap.put(ColumnsOfTable.COL_51, "");
				obMap.put(ColumnsOfTable.COL_52, "");
				obMap.put(ColumnsOfTable.COL_53, "");
				obMap.put(ColumnsOfTable.COL_54, "");
			
				
				//New Field
				
				obMap.put(ColumnsOfTable.COL_55, centerlineGrade.getAfterDryerDraw());
				obMap.put(ColumnsOfTable.COL_56, centerlineGrade.getHorizontalSliceDcs());
				obMap.put(ColumnsOfTable.COL_57, centerlineGrade.getVerticalSliceDcs());
				

				
				datas.add(obMap);
				
			//	System.out.println(obMap);
				
			}
			
			Map<String, Object> obData=new HashMap<String, Object>();
			obData.put(ColumnsOfTable.COL_01, dateFormat1.format(centerlineData.getDate()));
			
			obData.put(ColumnsOfTable.COL_02, centerlineData.getYankeeSpeed());
			obData.put(ColumnsOfTable.COL_03, centerlineData.getQcsBasisWtTarget());
			obData.put(ColumnsOfTable.COL_04, centerlineData.getReelMoisture());
			obData.put(ColumnsOfTable.COL_05, centerlineData.getCrepe());
			obData.put(ColumnsOfTable.COL_06, centerlineData.getYankeeSteam());
			obData.put(ColumnsOfTable.COL_07, centerlineData.getYankeeRelease());
			obData.put(ColumnsOfTable.COL_08, centerlineData.getYankeeAdesive());
			obData.put(ColumnsOfTable.COL_09, centerlineData.getJetWireRatio());
			obData.put(ColumnsOfTable.COL_10, centerlineData.getFanPumpFlowRate());
			obData.put(ColumnsOfTable.COL_11, centerlineData.getAfterDryerSteam());
			obData.put(ColumnsOfTable.COL_12, centerlineData.getSprLoading());
			obData.put(ColumnsOfTable.COL_13, centerlineData.getFeltPassivator());
			obData.put(ColumnsOfTable.COL_14, centerlineData.getSprayboomPressure());
			obData.put(ColumnsOfTable.COL_15, centerlineData.getSprayboomTemparature());
			obData.put(ColumnsOfTable.COL_16, centerlineData.getWefanSpeed());
			obData.put(ColumnsOfTable.COL_17, centerlineData.getDefanSpeed());
			obData.put(ColumnsOfTable.COL_18, centerlineData.getMakeUpAirDamper());
			obData.put(ColumnsOfTable.COL_19, centerlineData.getExhaustDamper());
			obData.put(ColumnsOfTable.COL_20, centerlineData.getExhaustFanSpeed());
			obData.put(ColumnsOfTable.COL_21, centerlineData.getWehoodTemperature());
			obData.put(ColumnsOfTable.COL_22, centerlineData.getDehoodTemperature());
			obData.put(ColumnsOfTable.COL_23, centerlineData.getYankeeAP());
			obData.put(ColumnsOfTable.COL_24, centerlineData.getAfterDryerAP());
			obData.put(ColumnsOfTable.COL_25, centerlineData.getSecArmLoading());
			obData.put(ColumnsOfTable.COL_26, centerlineData.getReelOffset());
			obData.put(ColumnsOfTable.COL_27, centerlineData.getUhleBoxNorthValve());
			obData.put(ColumnsOfTable.COL_28, centerlineData.getUhleBoxSouthValve());
			obData.put(ColumnsOfTable.COL_29, centerlineData.getFaltBox1VacuumValve());
			obData.put(ColumnsOfTable.COL_30, centerlineData.getFaltBox2VacuumValve());
			obData.put(ColumnsOfTable.COL_31, centerlineData.getFaltBox4VacuumValve());
			obData.put(ColumnsOfTable.COL_32, centerlineData.getFanPumpSpeed());
			obData.put(ColumnsOfTable.COL_33, centerlineData.getTotalHead());
			obData.put(ColumnsOfTable.COL_34, centerlineData.getHeadboxLevel());
			obData.put(ColumnsOfTable.COL_35, centerlineData.getHorizontalSlice());
			obData.put(ColumnsOfTable.COL_36, centerlineData.getVerticalSlice());
			obData.put(ColumnsOfTable.COL_37, centerlineData.getSelectifierRejectFlow1());
			obData.put(ColumnsOfTable.COL_38, centerlineData.getSelectifierRejectFlow2());
			obData.put(ColumnsOfTable.COL_39, centerlineData.getSecScreenCycleTime());
			obData.put(ColumnsOfTable.COL_40, centerlineData.getLowDensityCycleTime());
			obData.put(ColumnsOfTable.COL_41, centerlineData.getRefinersEnergy());
			obData.put(ColumnsOfTable.COL_42, centerlineData.getNumberOfRefiners());
			obData.put(ColumnsOfTable.COL_43, centerlineData.getRefinerInletConsistency());
			obData.put(ColumnsOfTable.COL_44, centerlineData.getMachineChestConsistency());
			obData.put(ColumnsOfTable.COL_45, centerlineData.getStockFlow());
			obData.put(ColumnsOfTable.COL_46, centerlineData.getSweetnerFlow());
			obData.put(ColumnsOfTable.COL_47, centerlineData.getBroke());
			obData.put(ColumnsOfTable.COL_48, centerlineData.getWetStrength());
			
			

			obData.put(ColumnsOfTable.COL_02_C, CenterlineUtil.rangeCheck( centerlineData.getYankeeSpeed(),centerlineGrade.getYankeeSpeed(),centerlineGrade.getYankeeSpeedMinC(),centerlineGrade.getYankeeSpeedMaxC()));
			obData.put(ColumnsOfTable.COL_03_C, CenterlineUtil.rangeCheck( centerlineData.getQcsBasisWtTarget(),centerlineGrade.getQcsBasisWtTarget(),centerlineGrade.getQcsBasisWtTargetMinC(),centerlineGrade.getQcsBasisWtTargetMaxC()));
			obData.put(ColumnsOfTable.COL_04_C, CenterlineUtil.rangeCheck( centerlineData.getReelMoisture(),centerlineGrade.getReelMoisture(),centerlineGrade.getReelMoistureMinC(),centerlineGrade.getReelMoistureMaxC()));
			obData.put(ColumnsOfTable.COL_05_C, CenterlineUtil.rangeCheck( centerlineData.getCrepe(),centerlineGrade.getCrepe(),centerlineGrade.getCrepeMinC(),centerlineGrade.getCrepeMaxC()));
			obData.put(ColumnsOfTable.COL_06_C, CenterlineUtil.rangeCheck( centerlineData.getYankeeSteam(),centerlineGrade.getYankeeSteam(),centerlineGrade.getYankeeSteamMinC(),centerlineGrade.getYankeeSteamMaxC()));
			obData.put(ColumnsOfTable.COL_07_C, CenterlineUtil.rangeCheck( centerlineData.getYankeeRelease(),centerlineGrade.getYankeeRelease(),centerlineGrade.getYankeeReleaseMinC(),centerlineGrade.getYankeeReleaseMaxC()));
			obData.put(ColumnsOfTable.COL_08_C, CenterlineUtil.rangeCheck( centerlineData.getYankeeAdesive(),centerlineGrade.getYankeeAdesive(),centerlineGrade.getYankeeAdesiveMinC(),centerlineGrade.getYankeeAdesiveMaxC()));
			obData.put(ColumnsOfTable.COL_09_C, CenterlineUtil.rangeCheck( centerlineData.getJetWireRatio(),centerlineGrade.getJetWireRatio(),centerlineGrade.getJetWireRatioMinC(),centerlineGrade.getJetWireRatioMaxC()));
			obData.put(ColumnsOfTable.COL_10_C, CenterlineUtil.rangeCheck( centerlineData.getFanPumpFlowRate(),centerlineGrade.getFanPumpFlowRate(),centerlineGrade.getFanPumpFlowRateMinC(),centerlineGrade.getFanPumpFlowRateMaxC()));
			obData.put(ColumnsOfTable.COL_11_C, CenterlineUtil.rangeCheck( centerlineData.getAfterDryerSteam(),centerlineGrade.getAfterDryerSteam(),centerlineGrade.getAfterDryerSteamMinC(),centerlineGrade.getAfterDryerSteamMaxC()));
			obData.put(ColumnsOfTable.COL_12_C, CenterlineUtil.rangeString1( centerlineData.getSprLoading(),centerlineGrade.getSprLoading(),centerlineGrade.getSprLoadingMinC(),centerlineGrade.getSprLoadingMaxC()));
			obData.put(ColumnsOfTable.COL_13_C, CenterlineUtil.rangeCheck( centerlineData.getFeltPassivator(),centerlineGrade.getFeltPassivator(),centerlineGrade.getFeltPassivatorMinC(),centerlineGrade.getFeltPassivatorMaxC()));
			obData.put(ColumnsOfTable.COL_14_C, CenterlineUtil.rangeCheck( centerlineData.getSprayboomPressure(),centerlineGrade.getSprayboomPressure(),centerlineGrade.getSprayboomPressureMinC(),centerlineGrade.getSprayboomPressureMaxC()));
			obData.put(ColumnsOfTable.COL_15_C, CenterlineUtil.rangeCheck( centerlineData.getSprayboomTemparature(),centerlineGrade.getSprayboomTemparature(),centerlineGrade.getSprayboomTemparatureMinC(),centerlineGrade.getSprayboomTemparatureMaxC()));
			obData.put(ColumnsOfTable.COL_16_C, CenterlineUtil.rangeCheck( centerlineData.getWefanSpeed(),centerlineGrade.getWefanSpeed(),centerlineGrade.getWefanSpeedMinC(),centerlineGrade.getWefanSpeedMaxC()));
			obData.put(ColumnsOfTable.COL_17_C, CenterlineUtil.rangeCheck( centerlineData.getDefanSpeed(),centerlineGrade.getDefanSpeed(),centerlineGrade.getDefanSpeedMinC(),centerlineGrade.getDefanSpeedMaxC()));
			obData.put(ColumnsOfTable.COL_18_C, CenterlineUtil.rangeCheck( centerlineData.getMakeUpAirDamper(),centerlineGrade.getMakeUpAirDamper(),centerlineGrade.getMakeUpAirDamperMinC(),centerlineGrade.getMakeUpAirDamperMaxC()));
			obData.put(ColumnsOfTable.COL_19_C, CenterlineUtil.rangeCheck( centerlineData.getExhaustDamper(),centerlineGrade.getExhaustDamper(),centerlineGrade.getExhaustDamperMinC(),centerlineGrade.getExhaustDamperMaxC()));
			obData.put(ColumnsOfTable.COL_20_C, CenterlineUtil.rangeCheck( centerlineData.getExhaustFanSpeed(),centerlineGrade.getExhaustFanSpeed(),centerlineGrade.getExhaustFanSpeedMinC(),centerlineGrade.getExhaustFanSpeedMaxC()));
			obData.put(ColumnsOfTable.COL_21_C, CenterlineUtil.rangeCheck( centerlineData.getWehoodTemperature(),centerlineGrade.getWehoodTemperature(),centerlineGrade.getWehoodTemperatureMinC(),centerlineGrade.getWehoodTemperatureMaxC()));
			obData.put(ColumnsOfTable.COL_22_C, CenterlineUtil.rangeCheck( centerlineData.getDehoodTemperature(),centerlineGrade.getDehoodTemperature(),centerlineGrade.getDehoodTemperatureMinC(),centerlineGrade.getDehoodTemperatureMaxC()));
			obData.put(ColumnsOfTable.COL_23_C, CenterlineUtil.rangeCheck( centerlineData.getYankeeAP(),centerlineGrade.getYankeeAP(),centerlineGrade.getYankeeAPMinC(),centerlineGrade.getYankeeAPMaxC()));
			obData.put(ColumnsOfTable.COL_24_C, CenterlineUtil.rangeCheck( centerlineData.getAfterDryerAP(),centerlineGrade.getAfterDryerAP(),centerlineGrade.getAfterDryerAPMinC(),centerlineGrade.getAfterDryerAPMaxC()));
			obData.put(ColumnsOfTable.COL_25_C, CenterlineUtil.rangeCheck( centerlineData.getSecArmLoading(),centerlineGrade.getSecArmLoading(),centerlineGrade.getSecArmLoadingMinC(),centerlineGrade.getSecArmLoadingMaxC()));
			obData.put(ColumnsOfTable.COL_26_C, CenterlineUtil.rangeCheck( centerlineData.getReelOffset(),centerlineGrade.getReelOffset(),centerlineGrade.getReelOffsetMinC(),centerlineGrade.getReelOffsetMaxC()));
			obData.put(ColumnsOfTable.COL_27_C, CenterlineUtil.rangeCheck( centerlineData.getUhleBoxNorthValve(),centerlineGrade.getUhleBoxNorthValve(),centerlineGrade.getUhleBoxNorthValveMinC(),centerlineGrade.getUhleBoxNorthValveMaxC()));
			obData.put(ColumnsOfTable.COL_28_C, CenterlineUtil.rangeCheck( centerlineData.getUhleBoxSouthValve(),centerlineGrade.getUhleBoxSouthValve(),centerlineGrade.getUhleBoxSouthValveMinC(),centerlineGrade.getUhleBoxSouthValveMaxC()));
			obData.put(ColumnsOfTable.COL_29_C, CenterlineUtil.rangeCheck( centerlineData.getFaltBox1VacuumValve(),centerlineGrade.getFaltBox1VacuumValve(),centerlineGrade.getFaltBox1VacuumValveMinC(),centerlineGrade.getFaltBox1VacuumValveMaxC()));
			obData.put(ColumnsOfTable.COL_30_C, CenterlineUtil.rangeCheck( centerlineData.getFaltBox2VacuumValve(),centerlineGrade.getFaltBox2VacuumValve(),centerlineGrade.getFaltBox2VacuumValveMinC(),centerlineGrade.getFaltBox2VacuumValveMaxC()));
			obData.put(ColumnsOfTable.COL_31_C, CenterlineUtil.rangeCheck( centerlineData.getFaltBox4VacuumValve(),centerlineGrade.getFaltBox4VacuumValve(),centerlineGrade.getFaltBox4VacuumValveMinC(),centerlineGrade.getFaltBox4VacuumValveMaxC()));
			obData.put(ColumnsOfTable.COL_32_C, CenterlineUtil.rangeCheck( centerlineData.getFanPumpSpeed(),centerlineGrade.getFanPumpSpeed(),centerlineGrade.getFanPumpSpeedMinC(),centerlineGrade.getFanPumpSpeedMaxC()));
			obData.put(ColumnsOfTable.COL_33_C, CenterlineUtil.rangeCheck( centerlineData.getTotalHead(),centerlineGrade.getTotalHead(),centerlineGrade.getTotalHeadMinC(),centerlineGrade.getTotalHeadMaxC()));
			obData.put(ColumnsOfTable.COL_34_C, CenterlineUtil.rangeCheck( centerlineData.getHeadboxLevel(),centerlineGrade.getHeadboxLevel(),centerlineGrade.getHeadboxLevelMinC(),centerlineGrade.getHeadboxLevelMaxC()));
			obData.put(ColumnsOfTable.COL_35_C, CenterlineUtil.rangeString2( centerlineData.getHorizontalSlice(),centerlineGrade.getHorizontalSlice(),centerlineGrade.getHorizontalSliceMinC(),centerlineGrade.getHorizontalSliceMaxC()));
			obData.put(ColumnsOfTable.COL_36_C, CenterlineUtil.rangeString2( centerlineData.getVerticalSlice(),centerlineGrade.getVerticalSlice(),centerlineGrade.getVerticalSliceMinC(),centerlineGrade.getVerticalSliceMaxC()));
			obData.put(ColumnsOfTable.COL_37_C, CenterlineUtil.rangeCheck( centerlineData.getSelectifierRejectFlow1(),centerlineGrade.getSelectifierRejectFlow1(),centerlineGrade.getSelectifierRejectFlow1MinC(),centerlineGrade.getSelectifierRejectFlow1MaxC()));
			obData.put(ColumnsOfTable.COL_38_C, CenterlineUtil.rangeCheck( centerlineData.getSelectifierRejectFlow2(),centerlineGrade.getSelectifierRejectFlow2(),centerlineGrade.getSelectifierRejectFlow2MinC(),centerlineGrade.getSelectifierRejectFlow2MaxC()));
			obData.put(ColumnsOfTable.COL_39_C, CenterlineUtil.rangeCheck( centerlineData.getSecScreenCycleTime(),centerlineGrade.getSecScreenCycleTime(),centerlineGrade.getSecScreenCycleTimeMinC(),centerlineGrade.getSecScreenCycleTimeMaxC()));
			obData.put(ColumnsOfTable.COL_40_C, CenterlineUtil.rangeCheck( centerlineData.getLowDensityCycleTime(),centerlineGrade.getLowDensityCycleTime(),centerlineGrade.getLowDensityCycleTimeMinC(),centerlineGrade.getLowDensityCycleTimeMaxC()));
			obData.put(ColumnsOfTable.COL_41_C, CenterlineUtil.rangeCheck( centerlineData.getRefinersEnergy(),centerlineGrade.getRefinersEnergy(),centerlineGrade.getRefinersEnergyMinC(),centerlineGrade.getRefinersEnergyMaxC()));
			obData.put(ColumnsOfTable.COL_42_C, CenterlineUtil.rangeCheck( centerlineData.getNumberOfRefiners(),centerlineGrade.getNumberOfRefiners(),centerlineGrade.getNumberOfRefinersMinC(),centerlineGrade.getNumberOfRefinersMaxC()));
			obData.put(ColumnsOfTable.COL_43_C, CenterlineUtil.rangeCheck( centerlineData.getRefinerInletConsistency(),centerlineGrade.getRefinerInletConsistency(),centerlineGrade.getRefinerInletConsistencyMinC(),centerlineGrade.getRefinerInletConsistencyMaxC()));
			obData.put(ColumnsOfTable.COL_44_C, CenterlineUtil.rangeCheck( centerlineData.getMachineChestConsistency(),centerlineGrade.getMachineChestConsistency(),centerlineGrade.getMachineChestConsistencyMinC(),centerlineGrade.getMachineChestConsistencyMaxC()));
			obData.put(ColumnsOfTable.COL_45_C, CenterlineUtil.rangeCheck( centerlineData.getStockFlow(),centerlineGrade.getStockFlow(),centerlineGrade.getStockFlowMinC(),centerlineGrade.getStockFlowMaxC()));
			obData.put(ColumnsOfTable.COL_46_C, CenterlineUtil.rangeCheck( centerlineData.getSweetnerFlow(),centerlineGrade.getSweetnerFlow(),centerlineGrade.getSweetnerFlowMinC(),centerlineGrade.getSweetnerFlowMaxC()));
			obData.put(ColumnsOfTable.COL_47_C, CenterlineUtil.rangeCheck( centerlineData.getBroke(),centerlineGrade.getBroke(),centerlineGrade.getBrokeMinC(),centerlineGrade.getBrokeMaxC()));
			obData.put(ColumnsOfTable.COL_48_C, CenterlineUtil.rangeCheck( centerlineData.getWetStrength(),centerlineGrade.getWetStrength(),centerlineGrade.getWetStrengthMinC(),centerlineGrade.getWetStrengthMaxC()));


			obData.put(ColumnsOfTable.COL_49, centerlineGrade.getGrade());
			obData.put(ColumnsOfTable.COL_50, centerlineData.getShift());
			obData.put(ColumnsOfTable.COL_51, centerlineData.getCrew());
			
			obData.put(ColumnsOfTable.COL_52, centerlineData.getId());
			obData.put(ColumnsOfTable.COL_53, centerlineData.getNoteSecA()==null?"":centerlineData.getNoteSecA());
			obData.put(ColumnsOfTable.COL_54, centerlineData.getNoteSecB()==null?"":centerlineData.getNoteSecB());
			
			//New Field
			obData.put(ColumnsOfTable.COL_55, centerlineData.getAfterDryerDraw());
			obData.put(ColumnsOfTable.COL_56, centerlineData.getHorizontalSliceDcs());
			obData.put(ColumnsOfTable.COL_57, centerlineData.getVerticalSliceDcs());
			
			obData.put(ColumnsOfTable.COL_55_C, CenterlineUtil.rangeCheck( centerlineData.getAfterDryerDraw(),centerlineGrade.getAfterDryerDraw(),centerlineGrade.getAfterDryerDrawMinC(),centerlineGrade.getAfterDryerDrawMaxC()));
			obData.put(ColumnsOfTable.COL_56_C, CenterlineUtil.rangeString2( centerlineData.getHorizontalSliceDcs(),centerlineGrade.getHorizontalSliceDcs(),centerlineGrade.getHorizontalSliceDcsMinC(),centerlineGrade.getHorizontalSliceDcsMaxC()));
			obData.put(ColumnsOfTable.COL_57_C, CenterlineUtil.rangeString2( centerlineData.getVerticalSliceDcs(),centerlineGrade.getVerticalSliceDcs(),centerlineGrade.getVerticalSliceDcsMinC(),centerlineGrade.getVerticalSliceDcsMaxC()));

			
			
			datas.add(obData);
		//	System.out.println(obData);
		}
		
		
		return datas;
	}
	
	
	
}

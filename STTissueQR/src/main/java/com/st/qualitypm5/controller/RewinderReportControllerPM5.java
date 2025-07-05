/**
 *Dec 25, 2017
 *RewinderReportControllerPM5.java
 * TODO
 *com.st.qualitypm5.controller
 *RewinderReportControllerPM5.java
 *Roshan Lal Tailor
 */
package com.st.qualitypm5.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
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

import com.st.common.Columns;
import com.st.common.ColumnsOfTable;
import com.st.common.CommonUtil;
import com.st.qualitypm5.model.RewindPM5;
import com.st.qualitypm5.report.QualityReportHandlerPM5;
import com.st.qualitypm5.service.GradePM5Service;
import com.st.qualitypm5.service.GradeTargetPM5Service;
import com.st.qualitypm5.service.ReelServicePM5;
import com.st.qualitypm5.service.RewindServicePM5;
import com.st.qualitypm6.service.CustomerService;

/**
 * @author roshan
 *
 */
@Controller
@RequestMapping(value="/pm5rewindreport")
public class RewinderReportControllerPM5 {
	
	@Autowired
	private ReelServicePM5 reelServicepm5;
	@Autowired
	private RewindServicePM5 rewindServicepm5;
	
	@Autowired
	private GradeTargetPM5Service gradeTargetPm5Service;
	
	@Autowired
	private ServletContext context;
	
	@Autowired
	private GradePM5Service gradepm5Service;
	
	@Autowired
	private CustomerService customerService;
	

	@Autowired
	private QualityReportHandlerPM5 qualityReportHandlerPM5;
	
	
	
	private SimpleDateFormat dateFormat1=new SimpleDateFormat("MM-dd-yyyy");
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String report(Model model) {
		
		model.addAttribute("grades", gradepm5Service.getGrades());
		model.addAttribute("customers", customerService.getCustomers());
		model.addAttribute("reels", reelServicepm5.getReels());
		return "PM5/rewinderReport";
	}
	

	

	
	
	private HSSFWorkbook getFormatedWorkbook(File file,
			List<Map<String, Object>> datas) throws IOException {
		FileInputStream inputStream=new FileInputStream(file);
		HSSFWorkbook workbook=new HSSFWorkbook(inputStream);
		
		
		HSSFCellStyle headerCellStyle=workbook.createCellStyle();
	//	headerCellStyle.setWrapText(true);
		headerCellStyle.setAlignment(HorizontalAlignment.LEFT);
		headerCellStyle.setBorderBottom(BorderStyle.THIN);
		headerCellStyle.setBorderLeft(BorderStyle.THIN);
		headerCellStyle.setBorderRight(BorderStyle.THIN);
		headerCellStyle.setBorderTop(BorderStyle.THIN);
		
		Font headerFont=workbook.createFont();
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
		objectCellStyle.setWrapText(true);
		
		Font objectFontRed=workbook.createFont();
		objectFontRed.setBold(true);
		objectFontRed.setColor(IndexedColors.RED.getIndex());
		HSSFCellStyle objectCellStyleRED=workbook.createCellStyle();
		objectCellStyleRED.setBorderBottom(BorderStyle.THIN);
		objectCellStyleRED.setBorderLeft(BorderStyle.THIN);
		objectCellStyleRED.setBorderRight(BorderStyle.THIN);
		objectCellStyleRED.setBorderTop(BorderStyle.THIN);
		objectCellStyleRED.setAlignment(HorizontalAlignment.CENTER);
		objectCellStyleRED.setFont(objectFontRed);
		objectCellStyleRED.setWrapText(true);
		
		Font objectFontCol=workbook.createFont();
		objectFontCol.setBold(true);
		objectFontCol.setColor(IndexedColors.BLACK.getIndex());
		HSSFCellStyle objectCellStyleCol=workbook.createCellStyle();
		objectCellStyleCol.setBorderBottom(BorderStyle.THIN);
		objectCellStyleCol.setBorderLeft(BorderStyle.THIN);
		objectCellStyleCol.setBorderRight(BorderStyle.THIN);
		objectCellStyleCol.setBorderTop(BorderStyle.THIN);
		objectCellStyleCol.setAlignment(HorizontalAlignment.CENTER);
		objectCellStyleCol.setFont(objectFontCol);
		objectCellStyleCol.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
		objectCellStyleCol.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		objectCellStyleCol.setWrapText(true);

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
		rowCellStyle.setWrapText(true);
		rowCellStyle.setVerticalAlignment(VerticalAlignment.TOP);
		
		HSSFCellStyle rowCellStyleRed=workbook.createCellStyle();
		rowCellStyleRed.setBorderBottom(BorderStyle.THIN);
		rowCellStyleRed.setBorderLeft(BorderStyle.THIN);
		rowCellStyleRed.setBorderRight(BorderStyle.THIN);
		rowCellStyleRed.setBorderTop(BorderStyle.THIN);
		rowCellStyleRed.setFont(fontRow);
		rowCellStyleRed.setAlignment(HorizontalAlignment.CENTER);
		rowCellStyleRed.setFillForegroundColor(IndexedColors.RED.getIndex());
		rowCellStyleRed.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		rowCellStyleRed.setWrapText(true);
		
		HSSFCellStyle rowCellStyleYellow=workbook.createCellStyle();
		rowCellStyleYellow.setBorderBottom(BorderStyle.THIN);
		rowCellStyleYellow.setBorderLeft(BorderStyle.THIN);
		rowCellStyleYellow.setBorderRight(BorderStyle.THIN);
		rowCellStyleYellow.setBorderTop(BorderStyle.THIN);
		rowCellStyleYellow.setFont(fontRow);
		rowCellStyleYellow.setAlignment(HorizontalAlignment.CENTER);
		rowCellStyleYellow.setFillForegroundColor(IndexedColors.YELLOW.getIndex());
		rowCellStyleYellow.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		rowCellStyleYellow.setWrapText(true);
		
		HSSFCellStyle rowCellStyleGreen=workbook.createCellStyle();
		rowCellStyleGreen.setBorderBottom(BorderStyle.THIN);
		rowCellStyleGreen.setBorderLeft(BorderStyle.THIN);
		rowCellStyleGreen.setBorderRight(BorderStyle.THIN);
		rowCellStyleGreen.setBorderTop(BorderStyle.THIN);
		rowCellStyleGreen.setFont(fontRow);
		rowCellStyleGreen.setAlignment(HorizontalAlignment.CENTER);
		rowCellStyleGreen.setFillForegroundColor(IndexedColors.LIGHT_GREEN.getIndex());
		rowCellStyleGreen.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		rowCellStyleGreen.setWrapText(true);
		
		int rowCount=2;
		
	//	System.out.println(datas);
		
		for (Map<String, Object> map : datas) {
			
			HSSFRow row=sheet.createRow(rowCount);
			row.setHeight((short)280);
			if(map.get(ColumnsOfTable.COL_01).toString().equalsIgnoreCase("OBJECTIVES")){
				HSSFCell COL_01=row.createCell(Columns.COL_00);
				COL_01.setCellStyle(objectCellStyle);
				COL_01.setCellValue(map.get(ColumnsOfTable.COL_01).toString());
				
				HSSFCell COL_19=row.createCell(Columns.COL_01);
				COL_19.setCellStyle(objectCellStyle);
				COL_19.setCellValue("N/A");
				
				
				HSSFCell COL_02=row.createCell(Columns.COL_02);
				COL_02.setCellStyle(objectCellStyleRED);
				COL_02.setCellValue(map.get(ColumnsOfTable.COL_02).toString());
				
				
				
				HSSFCell COL_03=row.createCell(Columns.COL_03);
				COL_03.setCellStyle(objectCellStyle);
				COL_03.setCellValue(map.get(ColumnsOfTable.COL_03).toString());
				
				HSSFCell COL_04=row.createCell(Columns.COL_04);
				COL_04.setCellStyle(objectCellStyle);
				COL_04.setCellValue(map.get(ColumnsOfTable.COL_04).toString());
				
				HSSFCell COL_05=row.createCell(Columns.COL_05);
				COL_05.setCellStyle(objectCellStyle);
				COL_05.setCellValue(CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_05).toString()));
				
				HSSFCell COL_06=row.createCell(Columns.COL_06);
				COL_06.setCellStyle(objectCellStyle);
				COL_06.setCellValue(CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_06).toString()));
				
				HSSFCell COL_07=row.createCell(Columns.COL_07);
				COL_07.setCellStyle(objectCellStyle);
				COL_07.setCellValue(CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_07).toString()));
				
				HSSFCell COL_08=row.createCell(Columns.COL_08);
				COL_08.setCellStyle(objectCellStyle);
				COL_08.setCellValue(CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_08).toString()));
				
				HSSFCell COL_09=row.createCell(Columns.COL_09);
				COL_09.setCellStyle(objectCellStyle);
				COL_09.setCellValue(CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_09).toString()));
				
				HSSFCell COL_10=row.createCell(Columns.COL_10);
				COL_10.setCellStyle(objectCellStyle);
				COL_10.setCellValue(CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_10).toString()));
				
				HSSFCell COL_11=row.createCell(Columns.COL_11);
				COL_11.setCellStyle(objectCellStyle);
				COL_11.setCellValue(CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_11).toString()));
				
				HSSFCell COL_12=row.createCell(Columns.COL_12);
				COL_12.setCellStyle(objectCellStyle);
				COL_12.setCellValue(CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_12).toString()));
				
				HSSFCell COL_13=row.createCell(Columns.COL_13);
				COL_13.setCellStyle(objectCellStyle);
				COL_13.setCellValue(CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_13).toString()));
				
				HSSFCell COL_14=row.createCell(Columns.COL_14);
				COL_14.setCellStyle(objectCellStyle);
				COL_14.setCellValue(CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_14).toString()));
				
				HSSFCell COL_15=row.createCell(Columns.COL_15);
				COL_15.setCellStyle(objectCellStyle);
				COL_15.setCellValue(CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_15).toString()));
				
				HSSFCell COL_16=row.createCell(Columns.COL_16);
				COL_16.setCellStyle(objectCellStyle);
				COL_16.setCellValue(CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_16).toString()));
				
				HSSFCell COL_17=row.createCell(Columns.COL_17);
				COL_17.setCellStyle(objectCellStyle);
				COL_17.setCellValue(CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_17).toString()));
//				Code Starts From Here Done By Roshan Tailor Date ;- 03/11/2015 DD/MM/YYYY
//				Code Again Updated By Roshan Tailor Date :-03/12/2015
				HSSFCell COL_18=row.createCell(Columns.COL_18);
				COL_18.setCellStyle(objectCellStyle);
				COL_18.setCellValue(CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_18).toString()));
//				Code Again Updated By Roshan Tailor Date :-03/12/2015
				HSSFCell COL_20=row.createCell(Columns.COL_19);
				COL_20.setCellStyle(objectCellStyle);
				COL_20.setCellValue(CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_19).toString()));
//				Updated Code Ends Here Done By Roshan Tailor 
				
//				Code Ends Here Done By Roshan Tailor
				
				
//				Code Ends Here Done By Roshan Tailor
				
				HSSFCell COL_25=row.createCell(Columns.COL_20);
				COL_25.setCellStyle(objectCellStyle);
				COL_25.setCellValue("");
				
				
				HSSFCell COL_26=row.createCell(Columns.COL_21);
				COL_26.setCellStyle(objectCellStyle);
				COL_26.setCellValue("");
				
				
			}else{
				HSSFCell COL_01=row.createCell(Columns.COL_00);
				COL_01.setCellStyle(rowCellStyle);
				COL_01.setCellValue(map.get(ColumnsOfTable.COL_01).toString());
				
				HSSFCell COL_19=row.createCell(Columns.COL_01);
				COL_19.setCellStyle(rowCellStyle);
				COL_19.setCellValue(map.get(ColumnsOfTable.COL_19).toString());
				
				HSSFCell COL_02=row.createCell(Columns.COL_02);
				COL_02.setCellStyle(rowCellStyle);
				COL_02.setCellValue(map.get(ColumnsOfTable.COL_02).toString());
				
				HSSFCell COL_03=row.createCell(Columns.COL_03);
				COL_03.setCellStyle(rowCellStyle);
				if(StringUtils.isNumeric(map.get(ColumnsOfTable.COL_03).toString())){
					COL_03.setCellValue(CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_03).toString()));	
				}else{
					COL_03.setCellValue(map.get(ColumnsOfTable.COL_03).toString());
				}
				
				
				HSSFCell COL_04=row.createCell(Columns.COL_04);
				COL_04.setCellStyle(rowCellStyle);
				COL_04.setCellValue(map.get(ColumnsOfTable.COL_04).toString());
				
				HSSFCell COL_05=row.createCell(Columns.COL_05);
				if(map.get(ColumnsOfTable.COL_05_C).toString().equalsIgnoreCase("redcolor")){
					COL_05.setCellStyle(rowCellStyleRed);
				}else if(map.get(ColumnsOfTable.COL_05_C).toString().equalsIgnoreCase("greencolor")){
					COL_05.setCellStyle(rowCellStyleGreen);
				}else if(map.get(ColumnsOfTable.COL_05_C).toString().equalsIgnoreCase("yellowcolor")){
					COL_05.setCellStyle(rowCellStyleYellow);
				}else{
					COL_05.setCellStyle(rowCellStyle);
				}				
				COL_05.setCellValue(CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_05).toString()));
				
				HSSFCell COL_06=row.createCell(Columns.COL_06);
				if(map.get(ColumnsOfTable.COL_06_C).toString().equalsIgnoreCase("redcolor")){
					COL_06.setCellStyle(rowCellStyleRed);
				}else if(map.get(ColumnsOfTable.COL_06_C).toString().equalsIgnoreCase("greencolor")){
					COL_06.setCellStyle(rowCellStyleGreen);
				}else if(map.get(ColumnsOfTable.COL_06_C).toString().equalsIgnoreCase("yellowcolor")){
					COL_06.setCellStyle(rowCellStyleYellow);
				}else{
					COL_06.setCellStyle(rowCellStyle);
				}
				COL_06.setCellValue(CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_06).toString()));
				
				HSSFCell COL_07=row.createCell(Columns.COL_07);
				if(map.get(ColumnsOfTable.COL_07_C).toString().equalsIgnoreCase("redcolor")){
					COL_07.setCellStyle(rowCellStyleRed);
				}else if(map.get(ColumnsOfTable.COL_07_C).toString().equalsIgnoreCase("greencolor")){
					COL_07.setCellStyle(rowCellStyleGreen);
				}else if(map.get(ColumnsOfTable.COL_07_C).toString().equalsIgnoreCase("yellowcolor")){
					COL_07.setCellStyle(rowCellStyleYellow);
				}else{
					COL_07.setCellStyle(rowCellStyle);
				}
				COL_07.setCellValue(CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_07).toString()));
				
				HSSFCell COL_08=row.createCell(Columns.COL_08);
				if(map.get(ColumnsOfTable.COL_08_C).toString().equalsIgnoreCase("redcolor")){
					COL_08.setCellStyle(rowCellStyleRed);
				}else if(map.get(ColumnsOfTable.COL_08_C).toString().equalsIgnoreCase("greencolor")){
					COL_08.setCellStyle(rowCellStyleGreen);
				}else if(map.get(ColumnsOfTable.COL_08_C).toString().equalsIgnoreCase("yellowcolor")){
					COL_08.setCellStyle(rowCellStyleYellow);
				}else{
					COL_08.setCellStyle(rowCellStyle);
				}
				COL_08.setCellValue(CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_08).toString()));
				
				HSSFCell COL_09=row.createCell(Columns.COL_09);
				if(map.get(ColumnsOfTable.COL_09_C).toString().equalsIgnoreCase("redcolor")){
					COL_09.setCellStyle(rowCellStyleRed);
				}else if(map.get(ColumnsOfTable.COL_09_C).toString().equalsIgnoreCase("greencolor")){
					COL_09.setCellStyle(rowCellStyleGreen);
				}else if(map.get(ColumnsOfTable.COL_09_C).toString().equalsIgnoreCase("yellowcolor")){
					COL_09.setCellStyle(rowCellStyleYellow);
				}else{
					COL_09.setCellStyle(rowCellStyle);
				}
				COL_09.setCellValue(CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_09).toString()));
				
				HSSFCell COL_10=row.createCell(Columns.COL_10);
				if(map.get(ColumnsOfTable.COL_10_C).toString().equalsIgnoreCase("redcolor")){
					COL_10.setCellStyle(rowCellStyleRed);
				}else if(map.get(ColumnsOfTable.COL_10_C).toString().equalsIgnoreCase("greencolor")){
					COL_10.setCellStyle(rowCellStyleGreen);
				}else if(map.get(ColumnsOfTable.COL_10_C).toString().equalsIgnoreCase("yellowcolor")){
					COL_10.setCellStyle(rowCellStyleYellow);
				}else{
					COL_10.setCellStyle(rowCellStyle);
				}
				COL_10.setCellValue(CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_10).toString()));
				
				HSSFCell COL_11=row.createCell(Columns.COL_11);
				if(map.get(ColumnsOfTable.COL_11_C).toString().equalsIgnoreCase("redcolor")){
					COL_11.setCellStyle(rowCellStyleRed);
				}else if(map.get(ColumnsOfTable.COL_11_C).toString().equalsIgnoreCase("greencolor")){
					COL_11.setCellStyle(rowCellStyleGreen);
				}else if(map.get(ColumnsOfTable.COL_11_C).toString().equalsIgnoreCase("yellowcolor")){
					COL_11.setCellStyle(rowCellStyleYellow);
				}else{
					COL_11.setCellStyle(rowCellStyle);
				}
				COL_11.setCellValue(CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_11).toString()));
				
				HSSFCell COL_12=row.createCell(Columns.COL_12);
				if(map.get(ColumnsOfTable.COL_12_C).toString().equalsIgnoreCase("redcolor")){
					COL_12.setCellStyle(rowCellStyleRed);
				}else if(map.get(ColumnsOfTable.COL_12_C).toString().equalsIgnoreCase("greencolor")){
					COL_12.setCellStyle(rowCellStyleGreen);
				}else if(map.get(ColumnsOfTable.COL_12_C).toString().equalsIgnoreCase("yellowcolor")){
					COL_12.setCellStyle(rowCellStyleYellow);
				}else{
					COL_12.setCellStyle(rowCellStyle);
				}
				COL_12.setCellValue(CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_12).toString()));
				
				HSSFCell COL_13=row.createCell(Columns.COL_13);
				if(map.get(ColumnsOfTable.COL_13_C).toString().equalsIgnoreCase("redcolor")){
					COL_13.setCellStyle(rowCellStyleRed);
				}else if(map.get(ColumnsOfTable.COL_13_C).toString().equalsIgnoreCase("greencolor")){
					COL_13.setCellStyle(rowCellStyleGreen);
				}else if(map.get(ColumnsOfTable.COL_13_C).toString().equalsIgnoreCase("yellowcolor")){
					COL_13.setCellStyle(rowCellStyleYellow);
				}else{
					COL_13.setCellStyle(rowCellStyle);
				}
				COL_13.setCellValue(CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_13).toString()));
				
				HSSFCell COL_14=row.createCell(Columns.COL_14);
				if(map.get(ColumnsOfTable.COL_14_C).toString().equalsIgnoreCase("redcolor")){
					COL_14.setCellStyle(rowCellStyleRed);
				}else if(map.get(ColumnsOfTable.COL_14_C).toString().equalsIgnoreCase("greencolor")){
					COL_14.setCellStyle(rowCellStyleGreen);
				}else if(map.get(ColumnsOfTable.COL_14_C).toString().equalsIgnoreCase("yellowcolor")){
					COL_14.setCellStyle(rowCellStyleYellow);
				}else{
					COL_14.setCellStyle(rowCellStyle);
				}
				COL_14.setCellValue(CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_14).toString()));
				
				HSSFCell COL_15=row.createCell(Columns.COL_15);
				if(map.get(ColumnsOfTable.COL_15_C).toString().equalsIgnoreCase("redcolor")){
					COL_15.setCellStyle(rowCellStyleRed);
				}else if(map.get(ColumnsOfTable.COL_15_C).toString().equalsIgnoreCase("greencolor")){
					COL_15.setCellStyle(rowCellStyleGreen);
				}else if(map.get(ColumnsOfTable.COL_15_C).toString().equalsIgnoreCase("yellowcolor")){
					COL_15.setCellStyle(rowCellStyleYellow);
				}else{
					COL_15.setCellStyle(rowCellStyle);
				}
				COL_15.setCellValue(CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_15).toString()));
				
				HSSFCell COL_16=row.createCell(Columns.COL_16);
				if(map.get(ColumnsOfTable.COL_16_C).toString().equalsIgnoreCase("redcolor")){
					COL_16.setCellStyle(rowCellStyleRed);
				}else if(map.get(ColumnsOfTable.COL_16_C).toString().equalsIgnoreCase("greencolor")){
					COL_16.setCellStyle(rowCellStyleGreen);
				}else if(map.get(ColumnsOfTable.COL_16_C).toString().equalsIgnoreCase("yellowcolor")){
					COL_16.setCellStyle(rowCellStyleYellow);
				}else{
					COL_16.setCellStyle(rowCellStyle);
				}
				COL_16.setCellValue(CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_16).toString()));
//				Code Starts From Here Done By Roshan Tailor Date :-03/11/2015 MM/DD/YYYY
				
				HSSFCell COL_25=row.createCell(Columns.COL_17);
				COL_25.setCellStyle(rowCellStyle);
				COL_25.setCellValue(CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_23).toString()));
				
				HSSFCell COL_24=row.createCell(Columns.COL_18);
				COL_24.setCellStyle(rowCellStyle);
				COL_24.setCellValue(CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_24).toString()));
				
				HSSFCell COL_23=row.createCell(Columns.COL_19);
				COL_23.setCellStyle(rowCellStyle);
				COL_23.setCellValue(CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_25).toString()));
				
//				Code Ends Here Done By Roshan Tailor 
				HSSFCell COL_20=row.createCell(Columns.COL_20);
				COL_20.setCellStyle(rowCellStyle);
				COL_20.setCellValue(map.get(ColumnsOfTable.COL_26)!=null?map.get(ColumnsOfTable.COL_26).toString():"");
				
				HSSFCell COL_21=row.createCell(Columns.COL_21);
				COL_21.setCellStyle(rowCellStyle);
				COL_21.setCellValue(map.get(ColumnsOfTable.COL_27)!=null?map.get(ColumnsOfTable.COL_27).toString():"");

				
			}
			
			
			
			rowCount++;
		}
		return workbook;
	}



	
	/**
	 * Rewind Report New
	 * @return 
	 */
	
	@RequestMapping("/view/report")
	public String rewindReportView(@RequestParam("fromDate")String fromDate,
			@RequestParam("toDate")String toDate,
			@RequestParam("grade")String grade,
			@RequestParam("customer")String customer,
			@RequestParam("reel")String reel,
			@RequestParam("type")String type,
			Model model
			) {
		
		try {
			List<RewindPM5> rewinds = rewindServicepm5.getRewindData(
					dateFormat1.parse(fromDate), 
					dateFormat1.parse(toDate),grade,customer,reel,type);
			
			List<Map<String, Object>> datas =rewindServicepm5.getFormatedData(rewinds);
			model.addAttribute("datas", datas);
			
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "PM5/rewinderReportDatewise";
	}

	
	@RequestMapping("/view/update")
	public String rewindReportUpdate(@RequestParam("fromDate")String fromDate,
			@RequestParam("toDate")String toDate,
			@RequestParam("grade")String grade,
			@RequestParam("customer")String customer,
			@RequestParam("reel")String reel,
			@RequestParam("type")String type,
			Model model
			){
		
	
		try {
			List<RewindPM5> rewinds = rewindServicepm5.getRewindData(
					dateFormat1.parse(fromDate), 
					dateFormat1.parse(toDate),grade,customer,reel,type);
			
			List<Map<String, Object>> datas =rewindServicepm5.getFormatedData(rewinds);
			model.addAttribute("datas", datas);
			model.addAttribute("customers", customerService.getCustomers());
			model.addAttribute("grades", gradepm5Service.getGrades());
			
			
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "PM5/rewindUpdate";
	}
	
	@RequestMapping("/view/export")
	public void rewindReportExport(@RequestParam("fromDate")String fromDate,
			@RequestParam("toDate")String toDate,
			@RequestParam("grade")String grade,
			@RequestParam("customer")String customer,
			@RequestParam("reel")String reel,
			@RequestParam("type")String type,
			HttpServletResponse response
			){
	
		try {
			List<RewindPM5> rewinds = rewindServicepm5.getRewindData(
					dateFormat1.parse(fromDate), 
					dateFormat1.parse(toDate),grade,customer,reel,type);
			
			List<Map<String, Object>> datas =rewindServicepm5.getFormatedData(rewinds);
			
			
			response.setContentType("application/vnd.ms-excel");
			response.setHeader("Content-Disposition", "attachment; filename=ST Tisue-ReelReport_PM5.xls");
			
			File file=new File(context.getRealPath("/")+"WEB-INF/RewinderReport_PM5.xls");

			try {
				HSSFWorkbook workbook=getFormatedWorkbook(file,datas);
				workbook.write(response.getOutputStream());
				
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		
	}
	
	@RequestMapping("/view/exportpdf")
	public void rewindReportExportPdf(@RequestParam("fromDate")String fromDate,
			@RequestParam("toDate")String toDate,
			@RequestParam("grade")String grade,
			@RequestParam("customer")String customer,
			@RequestParam("reel")String reel,
			@RequestParam("type")String type,
			HttpServletResponse response
			) throws IOException, Exception {
		
		List<RewindPM5> rewinds = rewindServicepm5.getRewindData(
				dateFormat1.parse(fromDate), 
				dateFormat1.parse(toDate),grade,customer,reel,type);
		
		response.setContentType("application/pdf");
		response.setHeader("Content-Disposition", "attachment; filename=ST Tisue_RewindlReport_PM5.pdf");
		qualityReportHandlerPM5.createRewindReport(rewinds, response.getOutputStream());
		
	}



}

/**
 * 
 */
package com.st.productionpm5.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.math.NumberUtils;
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
import org.apache.poi.ss.util.CellRangeAddress;
import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.Months;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.st.common.Columns;
import com.st.common.ColumnsOfTable;
import com.st.common.CommonUtil;
import com.st.common.exception.ProductionException;
import com.st.productionpm5.dao.MachineProductionDaoPM5;
import com.st.productionpm5.dao.WrapperProductionDaoPM5;
import com.st.productionpm5.model.MachineProductionPM5;
import com.st.productionpm5.model.WrapProductionRedCodePM5;
import com.st.productionpm5.model.WrapProductionRedCodePM5.WrapperData;
import com.st.productionpm5.model.WrapperProductionPM5;
import com.st.productionpm5.util.WrapperRedCodeComparatorPM5;
import com.st.productionpm5.util.WrapperRedCodeComparatorPM5.Field;
/**
 * @author sbora
 *
 */
@Service
public class WrapperProductionServiceImpPM5 implements WrapperProductionServicePM5 {

	@Autowired
	private WrapperProductionDaoPM5 wrapperProductionDao;
	
	@Autowired
	private MachineProductionDaoPM5 machineProductionDao;
	
	
	
	private SimpleDateFormat dateFormat=new SimpleDateFormat("MM-dd-yyyy");
	private SimpleDateFormat dateFormat1=new SimpleDateFormat("MMMM yyyy");
	
	
	@Transactional
	@Override
	public List<WrapperProductionPM5> getWrapperProductions(Date sdate, Date edate) throws ProductionException {
		return wrapperProductionDao.getWrapperProductions(sdate,edate);
	}

	@Transactional
	@Override
	public double getTrageTons(List<String> gradeCodes) throws ProductionException {
		return wrapperProductionDao.getTrageTons(gradeCodes);
	}



	
	@Transactional
	@Override
	public List<Map<String, String>> formatDataForWrappedReport(Date sdate,
			Date edate) throws ProductionException {
		List<Map<String, String>> datas=new ArrayList<>();
		
		int days=Days.daysBetween(new DateTime(sdate.getTime()), new DateTime(edate.getTime())).getDays();
		for(int i=0;i<days+1;i++){
			
			Calendar scal=Calendar.getInstance();
			scal.setTime(sdate);
			scal.set(Calendar.HOUR_OF_DAY, 7);
			scal.set(Calendar.MINUTE, 0);
			scal.set(Calendar.SECOND, 0);
			scal.set(Calendar.MILLISECOND, 0);
			
			Calendar ecal=Calendar.getInstance();
			ecal.setTime(sdate);
			ecal.set(Calendar.HOUR_OF_DAY, 6);
			ecal.set(Calendar.MINUTE, 59);
			ecal.set(Calendar.SECOND, 59);
			ecal.set(Calendar.MILLISECOND, 0);
			ecal.add(Calendar.DATE, 1);
			
			/*System.out.println("\t\t SD="+new SimpleDateFormat("MM-dd-YYY hh:mm:ss").format(scal.getTime())+
					"\t\t ED="+new SimpleDateFormat("MM-dd-YYY hh:mm:ss").format(ecal.getTime()));
			*/
			
			Map<String, String> map=new HashMap<String, String>();
			map.put(ColumnsOfTable.COL_01, dateFormat.format(sdate));
			
			
			double machineProductionTotal=0;
			
			
			
			List<MachineProductionPM5> machineProductions=machineProductionDao.getMachineProductions(scal.getTime(),ecal.getTime());
			for (MachineProductionPM5 machineProduction : machineProductions) {
				machineProductionTotal+=machineProduction.getGoodWeight();
			}
			
			
			
			map.put(ColumnsOfTable.COL_02, CommonUtil.round(machineProductionTotal, 2)+"");
			
			double whiteWhiteTons=0;
			double whiteBrownTons=0;
			
			double redWhiteTons=0;
			double redBrownTons=0;
			//Target
			double targeTons=0;
			
			double totalGrossWt=0;
			
			List<WrapperProductionPM5> wrapperProductions=wrapperProductionDao.getWrapperProductionsByMonth(scal.getTime(),ecal.getTime());
			for (WrapperProductionPM5 wrapperProduction : wrapperProductions) {
				String gradeCode=wrapperProduction.getGradeCode();
				if(StringUtils.isEmpty(gradeCode)){
					continue;
				}
				
				if(gradeCode!=null && gradeCode.length()>7){
					gradeCode=gradeCode.substring(gradeCode.indexOf("-")+1, gradeCode.length());
					gradeCode=gradeCode.substring(0,gradeCode.indexOf("-"));
					
					if(gradeCode.equalsIgnoreCase("98")){
						whiteBrownTons+=wrapperProduction.getWhiteWeight();
						redBrownTons+=wrapperProduction.getRedWeight();
					}else{
						whiteWhiteTons+=wrapperProduction.getWhiteWeight();
						redWhiteTons+=wrapperProduction.getRedWeight();
					}
				}
			}
			
			totalGrossWt=whiteBrownTons+whiteWhiteTons+redBrownTons+redWhiteTons;
			
			for (WrapperProductionPM5 wrapperProduction : wrapperProductions) {
				targeTons+=((((wrapperProduction.getWhiteWeight()+wrapperProduction.getRedWeight())/totalGrossWt)*24)*wrapperProduction.getTbdRate())/24;				
			}
			
			
			map.put(ColumnsOfTable.COL_03, CommonUtil.round(whiteWhiteTons/2000, 2)+"");
			map.put(ColumnsOfTable.COL_04, CommonUtil.round(whiteBrownTons/2000, 2)+"");
			map.put(ColumnsOfTable.COL_05, CommonUtil.round(redWhiteTons/2000, 2)+"");
			map.put(ColumnsOfTable.COL_06, CommonUtil.round(redBrownTons/2000, 2)+"");
			
			double totalNetTons=whiteWhiteTons+whiteBrownTons+redWhiteTons+redBrownTons;
			
			map.put(ColumnsOfTable.COL_07, CommonUtil.round(totalNetTons/2000, 2)+"");
			map.put(ColumnsOfTable.COL_08, CommonUtil.round(totalNetTons/2000, 2)+"");
			
			
			//System.out.println(gradeCodes);
			
			
			map.put(ColumnsOfTable.COL_09, CommonUtil.round(targeTons, 2)+"");
			
			
			double monthEffi=0;
			if(targeTons!=0){
				monthEffi=((whiteBrownTons/2000)+(whiteWhiteTons/2000))/targeTons;
			}
			map.put(ColumnsOfTable.COL_10, CommonUtil.round(monthEffi*100, 2)+"");
			
			datas.add(map);
			sdate=ecal.getTime();
		}
		
		return datas;

	}


	@Override
	public HSSFWorkbook getFormatedWorkbookForDailyReport(File file,
			List<Map<String, String>> datas,List<Map<String, String>> historicalDatas, Date sdate, Date edate) throws IOException {
		
		FileInputStream inputStream=new FileInputStream(file);
		HSSFWorkbook workbook=new HSSFWorkbook(inputStream);
	
		Font fontRow=workbook.createFont();
		fontRow.setBold(false);
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
		
		
		Font objectFont=workbook.createFont();
		objectFont.setBold(false);
		objectFont.setColor(IndexedColors.BLACK.getIndex());
		HSSFCellStyle objectCellStyle=workbook.createCellStyle();
		objectCellStyle.setBorderBottom(BorderStyle.THIN);
		objectCellStyle.setBorderLeft(BorderStyle.THIN);
		objectCellStyle.setBorderRight(BorderStyle.THIN);
		objectCellStyle.setBorderTop(BorderStyle.THIN);
		objectCellStyle.setAlignment(HorizontalAlignment.CENTER);
		objectCellStyle.setFillForegroundColor(IndexedColors.GOLD.getIndex());
		objectCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		objectCellStyle.setFont(objectFont);
		objectCellStyle.setWrapText(true);
		
		Font objectFont2=workbook.createFont();
		objectFont2.setBold(true);
		objectFont2.setColor(IndexedColors.BLACK.getIndex());
		HSSFCellStyle objectCellStyle2=workbook.createCellStyle();
		objectCellStyle2.setBorderBottom(BorderStyle.THIN);
		objectCellStyle2.setBorderLeft(BorderStyle.THIN);
		objectCellStyle2.setBorderRight(BorderStyle.THIN);
		objectCellStyle2.setBorderTop(BorderStyle.THIN);
		objectCellStyle2.setAlignment(HorizontalAlignment.CENTER);
		objectCellStyle2.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
		objectCellStyle2.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		objectCellStyle2.setFont(objectFont2);
		objectCellStyle2.setWrapText(true);
		
		HSSFSheet sheet=workbook.getSheetAt(0);
	
		
		
		String reportFrom="01-01-2013";
		Date startDate=null;
		try {
			startDate = dateFormat.parse(reportFrom);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		Calendar ecal=Calendar.getInstance();
		ecal.setTime(sdate);
		ecal.add(Calendar.MONTH,-1);
		
		SimpleDateFormat df=new SimpleDateFormat("MMMM yy");
		
		sheet.getRow(1).getCell(0).setCellValue("PM6 TISSUE Wrapped Tons with Machine Production  "+df.format(startDate)+"-"+df.format(ecal.getTime()));
		sheet.getRow(4).getCell(0).setCellValue("ST Tissue LLC, PM6 TISSUE WRAPPED TONS - "+dateFormat1.format(sdate));
		
		
		
		sheet.shiftRows(4, sheet.getLastRowNum(),historicalDatas.size());
		
		
		int rowCount=4;
		
		{
			for (Map<String, String> map : historicalDatas) {
				HSSFRow row=sheet.createRow(rowCount++);
				row.setHeight((short)280);
				
				
				HSSFCell COL_01=row.createCell(Columns.COL_00);
				HSSFCell COL_02=row.createCell(Columns.COL_01);
				HSSFCell COL_03=row.createCell(Columns.COL_02);
				HSSFCell COL_04=row.createCell(Columns.COL_03);
				HSSFCell COL_05=row.createCell(Columns.COL_04);
				HSSFCell COL_06=row.createCell(Columns.COL_05);
				HSSFCell COL_07=row.createCell(Columns.COL_06);
				HSSFCell COL_08=row.createCell(Columns.COL_07);
				HSSFCell COL_09=row.createCell(Columns.COL_08);
				HSSFCell COL_10=row.createCell(Columns.COL_09);
				
				
				if(map.get(ColumnsOfTable.COL_11).equalsIgnoreCase("YT")){
					COL_01.setCellStyle(objectCellStyle2);
					COL_02.setCellStyle(objectCellStyle2);
					COL_03.setCellStyle(objectCellStyle2);
					COL_04.setCellStyle(objectCellStyle2);
					COL_05.setCellStyle(objectCellStyle2);
					COL_06.setCellStyle(objectCellStyle2);
					COL_07.setCellStyle(objectCellStyle2);
					COL_08.setCellStyle(objectCellStyle2);
					COL_09.setCellStyle(objectCellStyle2);
					COL_10.setCellStyle(objectCellStyle2);
				}else{
					COL_01.setCellStyle(rowCellStyle);
					COL_02.setCellStyle(rowCellStyle);
					COL_03.setCellStyle(rowCellStyle);
					COL_04.setCellStyle(rowCellStyle);
					COL_05.setCellStyle(rowCellStyle);
					COL_06.setCellStyle(rowCellStyle);
					COL_07.setCellStyle(rowCellStyle);
					COL_08.setCellStyle(rowCellStyle);
					COL_09.setCellStyle(rowCellStyle);
					COL_10.setCellStyle(rowCellStyle);
				}
				
				
				COL_01.setCellValue(map.get(ColumnsOfTable.COL_01).toString());
				COL_02.setCellValue(NumberUtils.toDouble(map.get(ColumnsOfTable.COL_02), 0));
				COL_03.setCellValue(NumberUtils.toDouble(map.get(ColumnsOfTable.COL_03), 0));
				COL_04.setCellValue(NumberUtils.toDouble(map.get(ColumnsOfTable.COL_04), 0));
				COL_05.setCellValue(NumberUtils.toDouble(map.get(ColumnsOfTable.COL_05), 0));
				COL_06.setCellValue(NumberUtils.toDouble(map.get(ColumnsOfTable.COL_06), 0));
				COL_07.setCellValue(NumberUtils.toDouble(map.get(ColumnsOfTable.COL_07), 0));
				if(map.get(ColumnsOfTable.COL_11).equalsIgnoreCase("YT")){
					COL_08.setCellValue("");
					COL_10.setCellValue("");
				}else{
					COL_08.setCellValue(NumberUtils.toDouble(map.get(ColumnsOfTable.COL_08),0));
					COL_10.setCellValue(NumberUtils.toDouble(map.get(ColumnsOfTable.COL_10),0));
				}
				
				COL_09.setCellValue(NumberUtils.toDouble(map.get(ColumnsOfTable.COL_09), 0));
				
				
				
			}
		}
		
		
		double TOTAL_02=0;
		double TOTAL_03=0;
		double TOTAL_04=0;
		double TOTAL_05=0;
		double TOTAL_06=0;
		double TOTAL_07=0;
		double TOTAL_08=0;
		double TOTAL_09=0;
		double TOTAL_10=0;
		int totalRow=datas.size();
		{
			
			sheet.getRow(rowCount+1).setHeight((short)600);
			rowCount=rowCount+3;
			
			for (Map<String, String> map : datas) {
				HSSFRow row=sheet.createRow(rowCount++);
				row.setHeight((short)280);
				
				HSSFCell COL_01=row.createCell(Columns.COL_00);
				COL_01.setCellStyle(rowCellStyle);
				COL_01.setCellValue(map.get(ColumnsOfTable.COL_01).toString());
				
				HSSFCell COL_02=row.createCell(Columns.COL_01);
				COL_02.setCellStyle(rowCellStyle);
				COL_02.setCellValue(NumberUtils.toDouble(map.get(ColumnsOfTable.COL_02), 0));
				TOTAL_02+=NumberUtils.toDouble(map.get(ColumnsOfTable.COL_02), 0);
				
				HSSFCell COL_03=row.createCell(Columns.COL_02);
				COL_03.setCellStyle(rowCellStyle);
				COL_03.setCellValue(NumberUtils.toDouble(map.get(ColumnsOfTable.COL_03), 0));
				TOTAL_03+=NumberUtils.toDouble(map.get(ColumnsOfTable.COL_03), 0);
				
				HSSFCell COL_04=row.createCell(Columns.COL_03);
				COL_04.setCellStyle(rowCellStyle);
				COL_04.setCellValue(NumberUtils.toDouble(map.get(ColumnsOfTable.COL_04), 0));
				TOTAL_04+=NumberUtils.toDouble(map.get(ColumnsOfTable.COL_04), 0);
				
				HSSFCell COL_05=row.createCell(Columns.COL_04);
				COL_05.setCellStyle(rowCellStyle);
				COL_05.setCellValue(NumberUtils.toDouble(map.get(ColumnsOfTable.COL_05), 0));
				TOTAL_05+=NumberUtils.toDouble(map.get(ColumnsOfTable.COL_05), 0);
				
				HSSFCell COL_06=row.createCell(Columns.COL_05);
				COL_06.setCellStyle(rowCellStyle);
				COL_06.setCellValue(NumberUtils.toDouble(map.get(ColumnsOfTable.COL_06), 0));
				TOTAL_06+=NumberUtils.toDouble(map.get(ColumnsOfTable.COL_06), 0);
				
				HSSFCell COL_07=row.createCell(Columns.COL_06);
				COL_07.setCellStyle(rowCellStyle);
				COL_07.setCellValue(NumberUtils.toDouble(map.get(ColumnsOfTable.COL_07), 0));
				TOTAL_07+=NumberUtils.toDouble(map.get(ColumnsOfTable.COL_07), 0);
				
				HSSFCell COL_08=row.createCell(Columns.COL_07);
				COL_08.setCellStyle(rowCellStyle);
				COL_08.setCellValue(NumberUtils.toDouble(map.get(ColumnsOfTable.COL_08), 0));
				TOTAL_08+=NumberUtils.toDouble(map.get(ColumnsOfTable.COL_08), 0);
				
				HSSFCell COL_09=row.createCell(Columns.COL_08);
				COL_09.setCellStyle(rowCellStyle);
				COL_09.setCellValue(NumberUtils.toDouble(map.get(ColumnsOfTable.COL_09), 0));
				TOTAL_09+=NumberUtils.toDouble(map.get(ColumnsOfTable.COL_09), 0);
				
				HSSFCell COL_10=row.createCell(Columns.COL_09);
				COL_10.setCellStyle(rowCellStyle);
				COL_10.setCellValue(NumberUtils.toDouble(map.get(ColumnsOfTable.COL_10), 0));
				
			}
		}
		
		
		
		{
			{
				HSSFRow row=sheet.createRow(rowCount++);
				row.setHeight((short)280);

				HSSFCell COL_01=row.createCell(Columns.COL_00);
				HSSFCell COL_02=row.createCell(Columns.COL_01);
				HSSFCell COL_03=row.createCell(Columns.COL_02);
				HSSFCell COL_04=row.createCell(Columns.COL_03);
				HSSFCell COL_05=row.createCell(Columns.COL_04);
				HSSFCell COL_06=row.createCell(Columns.COL_05);
				HSSFCell COL_07=row.createCell(Columns.COL_06);
				HSSFCell COL_08=row.createCell(Columns.COL_07);
				HSSFCell COL_09=row.createCell(Columns.COL_08);
				HSSFCell COL_10=row.createCell(Columns.COL_09);

				
				COL_01.setCellStyle(objectCellStyle);
				COL_02.setCellStyle(objectCellStyle);
				COL_03.setCellStyle(objectCellStyle);
				COL_04.setCellStyle(objectCellStyle);
				COL_05.setCellStyle(objectCellStyle);
				COL_06.setCellStyle(objectCellStyle);
				COL_07.setCellStyle(objectCellStyle);
				COL_08.setCellStyle(objectCellStyle);
				COL_09.setCellStyle(objectCellStyle);
				COL_10.setCellStyle(objectCellStyle);
				
				
				COL_01.setCellValue("Total");
				COL_02.setCellValue(TOTAL_02);
				COL_03.setCellValue(TOTAL_03);
				COL_04.setCellValue(TOTAL_04);
				COL_05.setCellValue(TOTAL_05);
				COL_06.setCellValue(TOTAL_06);
				COL_07.setCellValue(TOTAL_07);
				COL_08.setCellValue(CommonUtil.round(TOTAL_08/totalRow, 2));
				COL_09.setCellValue(TOTAL_09);
				
				if(TOTAL_09!=0){
					TOTAL_10=(TOTAL_03+TOTAL_04)/TOTAL_09;
				}
				
				COL_10.setCellValue(CommonUtil.round(TOTAL_10*100, 2));

			}
		}
		
		
		return workbook;
	}


	@Transactional
	@Override
	public List<Map<String, String>> formatHistoricalDataForWrappedReport(
			Date date) throws ProductionException {
		
		List<Map<String, String>> datas=new ArrayList<>();
		
		
		String sdate="01-01-2014";
		Date startDate=null;
		try {
			startDate = dateFormat.parse(sdate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		Calendar scal=Calendar.getInstance();
		scal.setTime(startDate);
		
		Calendar ecal=Calendar.getInstance();
		ecal.setTime(date);
//		ecal.add(Calendar.MONTH, 1);
		
		double machineProductionTotalYear=0;
		double whiteWhiteTonsYear=0;
		double whiteBrownTonsYear=0;
		
		double redWhiteTonsYear=0;
		double redBrownTonsYear=0;
		
		double totalNetTonsYear=0;
		
		double targeTonsYear=0;
		
		
		
		//Loop For Month
		while(!(scal.get(Calendar.MONTH)==ecal.get(Calendar.MONTH)
				&&
			scal.get(Calendar.YEAR)==ecal.get(Calendar.YEAR))){
			
			Calendar sCal=Calendar.getInstance();
			sCal.setTime(scal.getTime());

			
			Calendar eCal=Calendar.getInstance();
			eCal.setTime(scal.getTime());
			eCal.add(Calendar.MONTH, 1);
			
			
			Map<String, String> map=new HashMap<String, String>();
			map.put(ColumnsOfTable.COL_01, new SimpleDateFormat("MMMM yy").format(sCal.getTime()));
			
			
			
			
			double machineProductionTotalMonth=0;
			double whiteWhiteTonsMonth=0;
			double whiteBrownTonsMonth=0;
			
			double redWhiteTonsMonth=0;
			double redBrownTonsMonth=0;
			
			double targeTonsMonth=0;
			
			int days=Days.daysBetween(new DateTime(sCal.getTime()), new DateTime(eCal.getTime())).getDays();
			
			/*System.out.println("Total Days="+days+" \tStart Day="+dateFormat.format(sCal.getTime())+
					" \tEnd Day="+dateFormat.format(eCal.getTime())+"\t"+"Month="+new SimpleDateFormat("MMMM yy").format(sCal.getTime()));
			*/
			//Loop For Day
			for(int i=0;i<days;i++){
				
				Calendar scalm=Calendar.getInstance();
				scalm.setTime(sCal.getTime());
				scalm.set(Calendar.HOUR_OF_DAY, 7);
				scalm.set(Calendar.MINUTE, 0);
				scalm.set(Calendar.SECOND, 0);
				scalm.set(Calendar.MILLISECOND, 0);
				
				Calendar ecalm=Calendar.getInstance();
				ecalm.setTime(sCal.getTime());
				ecalm.set(Calendar.HOUR_OF_DAY, 6);
				ecalm.set(Calendar.MINUTE, 59);
				ecalm.set(Calendar.SECOND, 59);
				ecalm.set(Calendar.MILLISECOND, 0);
				ecalm.add(Calendar.DATE, 1);
				
				
			/*	System.out.println("\t\t SD="+new SimpleDateFormat("MM-dd-YYY hh:mm:ss").format(scalm.getTime())+
						"\t\t ED="+new SimpleDateFormat("MM-dd-YYY hh:mm:ss").format(ecalm.getTime()));
			*/	
				
				double machineProductionTotal=0;
				
				
				
				List<MachineProductionPM5> machineProductions=machineProductionDao.getMachineProductions(scalm.getTime(),ecalm.getTime());
				for (MachineProductionPM5 machineProduction : machineProductions) {
					machineProductionTotal+=machineProduction.getGoodWeight();
				}
				
				double whiteWhiteTons=0;
				double whiteBrownTons=0;
				
				double redWhiteTons=0;
				double redBrownTons=0;
				//Target
				double targeTons=0;
				
				double totalGrossWt=0;
				
				List<WrapperProductionPM5> wrapperProductions=wrapperProductionDao.getWrapperProductionsByMonth(scalm.getTime(),ecalm.getTime());
				for (WrapperProductionPM5 wrapperProduction : wrapperProductions) {
					String gradeCode=wrapperProduction.getGradeCode();
					if(StringUtils.isEmpty(gradeCode)){
						continue;
					}
					if(gradeCode!=null && gradeCode.length()>7){
						gradeCode=gradeCode.substring(gradeCode.indexOf("-")+1, gradeCode.length());
						gradeCode=gradeCode.substring(0,gradeCode.indexOf("-"));
						
						if(gradeCode.equalsIgnoreCase("98")){
							whiteBrownTons+=wrapperProduction.getWhiteWeight();
							redBrownTons+=wrapperProduction.getRedWeight();
						}else{
							whiteWhiteTons+=wrapperProduction.getWhiteWeight();
							redWhiteTons+=wrapperProduction.getRedWeight();
						}
					}
				}
				
				totalGrossWt=whiteBrownTons+whiteWhiteTons+redBrownTons+redWhiteTons;
				
				for (WrapperProductionPM5 wrapperProduction : wrapperProductions) {
					targeTons+=((((wrapperProduction.getWhiteWeight()+wrapperProduction.getRedWeight())/totalGrossWt)*24)*wrapperProduction.getTbdRate())/24;				
				}
				
				
				machineProductionTotalMonth+=machineProductionTotal;
				
				whiteBrownTonsMonth+=whiteBrownTons;
				redBrownTonsMonth+=redBrownTons;
				
				whiteWhiteTonsMonth+=whiteWhiteTons;
				redWhiteTonsMonth+=redWhiteTons;
				
				
				targeTonsMonth+=targeTons;
				
				
				
				sCal.setTime(ecalm.getTime());
			}
			
			//System.out.println("whiteWhiteTonsMonth="+whiteWhiteTonsMonth);
			
			map.put(ColumnsOfTable.COL_02, CommonUtil.round(machineProductionTotalMonth, 2)+"");
			map.put(ColumnsOfTable.COL_03, CommonUtil.round(whiteWhiteTonsMonth/2000, 2)+"");
			map.put(ColumnsOfTable.COL_04, CommonUtil.round(whiteBrownTonsMonth/2000, 2)+"");
			map.put(ColumnsOfTable.COL_05, CommonUtil.round(redWhiteTonsMonth/2000, 2)+"");
			map.put(ColumnsOfTable.COL_06, CommonUtil.round(redBrownTonsMonth/2000, 2)+"");
			
			
			double totalNetTonsMonth=whiteWhiteTonsMonth+whiteBrownTonsMonth+redWhiteTonsMonth+redBrownTonsMonth;
			
			
			
			map.put(ColumnsOfTable.COL_07, CommonUtil.round(totalNetTonsMonth/2000, 2)+"");
			
			double avgTongsMonth=0;
			if(days>0){
				avgTongsMonth=(totalNetTonsMonth/2000)/days;
			}
			map.put(ColumnsOfTable.COL_08, CommonUtil.round(avgTongsMonth, 2)+"");
			

			
			//Target
			
			map.put(ColumnsOfTable.COL_09, CommonUtil.round(targeTonsMonth, 2)+"");
			
			//System.out.println("Year"+targeTons);
			
			double monthEffiMonth=0;
			if(targeTonsMonth!=0){
				monthEffiMonth=((whiteBrownTonsMonth/2000)+(whiteWhiteTonsMonth/2000))/targeTonsMonth;
			}
			map.put(ColumnsOfTable.COL_10, CommonUtil.round(monthEffiMonth*100, 2)+"");
			map.put(ColumnsOfTable.COL_11,"");
			datas.add(map);
			
			
			
			
			
			//Yearly Total
			machineProductionTotalYear+=machineProductionTotalMonth;
			whiteWhiteTonsYear+=whiteWhiteTonsMonth;
			whiteBrownTonsYear+=whiteBrownTonsMonth;
			redWhiteTonsYear+=redWhiteTonsMonth;
			redBrownTonsYear+=redBrownTonsMonth;
			totalNetTonsYear+=totalNetTonsMonth;
			targeTonsYear+=targeTonsMonth;
			
			
			if(scal.get(Calendar.MONTH)==Calendar.DECEMBER){
				
				Map<String, String> mapY=new HashMap<String, String>();
				
				mapY.put(ColumnsOfTable.COL_01, new SimpleDateFormat("yyyy").format(scal.getTime())+" Total");
				
				mapY.put(ColumnsOfTable.COL_02,CommonUtil.round(machineProductionTotalYear, 2)+"");
				mapY.put(ColumnsOfTable.COL_03,CommonUtil.round(whiteWhiteTonsYear/2000, 2)+"");
				mapY.put(ColumnsOfTable.COL_04,CommonUtil.round(whiteBrownTonsYear/2000, 2)+"");
				mapY.put(ColumnsOfTable.COL_05,CommonUtil.round(redWhiteTonsYear/2000, 2)+"");
				mapY.put(ColumnsOfTable.COL_06,CommonUtil.round(redBrownTonsYear/2000, 2)+"");
				mapY.put(ColumnsOfTable.COL_07,CommonUtil.round(totalNetTonsYear/2000, 2)+"");
				mapY.put(ColumnsOfTable.COL_08,"");
				mapY.put(ColumnsOfTable.COL_09,CommonUtil.round(targeTonsYear, 2)+"");
				mapY.put(ColumnsOfTable.COL_10,"");
				
				mapY.put(ColumnsOfTable.COL_11,"YT");
				
				datas.add(mapY);
				
				machineProductionTotalYear=0;
				whiteWhiteTonsYear=0;
				whiteBrownTonsYear=0;
				redWhiteTonsYear=0;
				redBrownTonsYear=0;
				totalNetTonsYear=0;
				targeTonsYear=0;
				
				
				
			}
			
			
			
			machineProductionTotalMonth=0;
			whiteWhiteTonsMonth=0;
			whiteWhiteTonsMonth=0;
			whiteBrownTonsMonth=0;
			
			redWhiteTonsMonth=0;
			redBrownTonsMonth=0;
			targeTonsMonth=0;
			
			// Increment
			scal.add(Calendar.MONTH, 1);
		}
		
		
		return datas;
	}

	@Transactional
	@Override
	public Map<String, Object> getWrapperDataByRedCode(Date sdate, Date edate) throws ProductionException {
		
		
		int month=Months.monthsBetween(new DateTime(sdate.getTime()), new DateTime(edate.getTime())).getMonths();
		Map<String, Object> data =new HashMap<>();
		
		List<WrapProductionRedCodePM5> redCodes=wrapperProductionDao.getRedCodes();
		
		
		
		SimpleDateFormat df=new SimpleDateFormat("MMM-yyyy");
		
		List<String> months=new ArrayList<>();
		data.put("months", months);
		
		if(month>=0){
			
			Calendar calendar=Calendar.getInstance();
			calendar.setTime(sdate);
		
			for(int i=0;i<=month;i++){
				Calendar scal=Calendar.getInstance();
				scal.setTime(calendar.getTime());
				scal.set(Calendar.HOUR_OF_DAY, 7);
				scal.set(Calendar.MINUTE, 0);
				scal.set(Calendar.SECOND, 0);
				scal.set(Calendar.MILLISECOND, 0);
				scal.set(Calendar.DATE, 1);
				
				Calendar ecal=Calendar.getInstance();
				ecal.setTime(calendar.getTime());
				ecal.set(Calendar.HOUR_OF_DAY, 6);
				ecal.set(Calendar.MINUTE, 59);
				ecal.set(Calendar.SECOND, 59);
				ecal.set(Calendar.MILLISECOND, 0);
				ecal.set(Calendar.DATE, 1);
				ecal.add(Calendar.MONTH, 1);
				
				
				months.add(df.format(scal.getTime()));
				

				List<WrapperProductionPM5> productions=wrapperProductionDao.getWrapperProductionRedCode(scal.getTime(),ecal.getTime());
				
				for(WrapProductionRedCodePM5 redCode:redCodes){
					
					List<WrapperProductionPM5> wrapperProductions=getWrapperProduction(redCode.getRedCode(),productions);
					
						
					WrapperData wrapperData=redCode.new WrapperData();
					
					if(wrapperProductions.size()>0){
						double redWhiteTotal=0;
						double redBrownTotal=0;
						double rejectedWhiteTotal=0;
						double rejectedBrownTotal=0;
						
						
						for (WrapperProductionPM5 wrapper : wrapperProductions) {
							
							String gradeCode=wrapper.getGradeCode();
							if(StringUtils.isEmpty(gradeCode)){
								continue;
							}
							if(gradeCode!=null && gradeCode.length()>7){
								gradeCode=gradeCode.substring(gradeCode.indexOf("-")+1, gradeCode.length());
								gradeCode=gradeCode.substring(0,gradeCode.indexOf("-"));
								
								if(gradeCode.equalsIgnoreCase("98")){
									redBrownTotal+=wrapper.getRedWeight();
									rejectedBrownTotal+=wrapper.getRejectWeight();
								}else{
									redWhiteTotal+=wrapper.getRedWeight();
									rejectedWhiteTotal+=wrapper.getRejectWeight();
								}
							}
						}
						
						
						wrapperData.setRedWeightBrown(redBrownTotal/2000);
						wrapperData.setRedWeightWhite(redWhiteTotal/2000);
						wrapperData.setRejectedWeightBrown(rejectedBrownTotal/2000);
						wrapperData.setRejectedWeightWhite(rejectedWhiteTotal/2000);
						
						redCode.getWrapperData().add(wrapperData);
						
					}else{
						redCode.getWrapperData().add(wrapperData);//Empty
					}
				}
				
				
				
				calendar.setTime(ecal.getTime());
				
			}
			
		}
		
		
		double redMax=0;
		double rejectMax=0;
		
		//Filter
		List<WrapProductionRedCodePM5> redCodesData= new ArrayList<>();
		
		for (int i=0;i<redCodes.size();i++) {
			WrapProductionRedCodePM5 wrapProductionRedCode=redCodes.get(i);
			List<WrapperData> wrapperDatas=wrapProductionRedCode.getWrapperData();
			
			double totalRedWhite=0;
			double totalRedBrown=0;
			double totalRejectWhite=0;
			double totalRejectBrown=0;
			for (WrapperData wrapperData : wrapperDatas) {
				totalRedWhite+=wrapperData.getRedWeightWhite();
				totalRedBrown+=wrapperData.getRedWeightBrown();
				totalRejectWhite+=wrapperData.getRejectedWeightWhite();
				totalRejectBrown+=wrapperData.getRejectedWeightBrown();
			}
			double totalRed=totalRedBrown+totalRedWhite;
			double totalReject=totalRejectWhite+totalRejectBrown;
			
			if((totalRedWhite+totalRedBrown+totalRejectWhite+totalRejectBrown)==0){
				continue;
			}
			if(totalRed>redMax){
				redMax=totalRed;
			}
			if(totalReject>rejectMax){
				rejectMax=totalReject;
			}
			
			wrapProductionRedCode.setTotalRedWhite(totalRedWhite);
			wrapProductionRedCode.setTotalRedBrown(totalRedBrown);
			wrapProductionRedCode.setTotalRejectBrown(totalRejectBrown);
			wrapProductionRedCode.setTotalRejectWhite(totalRejectWhite);
			
			wrapProductionRedCode.setTotalRed(totalRed);
			wrapProductionRedCode.setTotalReject(totalReject);
			
			redCodesData.add(wrapProductionRedCode);
		}
		
		WrapperRedCodeComparatorPM5 comparator=new WrapperRedCodeComparatorPM5();
		
		if(redMax>rejectMax){
			comparator.setField(Field.RED);
		}else{
			comparator.setField(Field.REJECT);
		}
		Collections.sort(redCodesData, comparator);
		
		
		//None Rede code Data
		
		
		WrapProductionRedCodePM5 redCodeNone=new WrapProductionRedCodePM5();
		redCodeNone.setRedCode("NONE");
		redCodeNone.setRedCodeDesc("Non-Red code data");
		
		if(month>=0){
			
			Calendar calendar=Calendar.getInstance();
			calendar.setTime(sdate);
		
			for(int i=0;i<=month;i++){
				Calendar scal=Calendar.getInstance();
				scal.setTime(calendar.getTime());
				scal.set(Calendar.HOUR_OF_DAY, 7);
				scal.set(Calendar.MINUTE, 0);
				scal.set(Calendar.SECOND, 0);
				scal.set(Calendar.MILLISECOND, 0);
				scal.set(Calendar.DATE, 1);
				
				Calendar ecal=Calendar.getInstance();
				ecal.setTime(calendar.getTime());
				ecal.set(Calendar.HOUR_OF_DAY, 6);
				ecal.set(Calendar.MINUTE, 59);
				ecal.set(Calendar.SECOND, 59);
				ecal.set(Calendar.MILLISECOND, 0);
				ecal.set(Calendar.DATE, 1);
				ecal.add(Calendar.MONTH, 1);
				
				
				//months.add(df.format(scal.getTime()));
				

				List<WrapperProductionPM5> productions=wrapperProductionDao.getWrapperProductionNoneRedCode(scal.getTime(),ecal.getTime());
				
			//	for(WrapProductionRedCode redCode:redCodes){
					
					List<WrapperProductionPM5> wrapperProductions=getWrapperProduction(redCodeNone.getRedCode(),productions);
					
						
					WrapperData wrapperData=redCodeNone.new WrapperData();
					
					if(wrapperProductions.size()>0){
						double redWhiteTotal=0;
						double redBrownTotal=0;
						double rejectedWhiteTotal=0;
						double rejectedBrownTotal=0;
						
						
						for (WrapperProductionPM5 wrapper : wrapperProductions) {
							
							String gradeCode=wrapper.getGradeCode();
							if(StringUtils.isEmpty(gradeCode)){
								continue;
							}
							if(gradeCode!=null && gradeCode.length()>7){
								gradeCode=gradeCode.substring(gradeCode.indexOf("-")+1, gradeCode.length());
								gradeCode=gradeCode.substring(0,gradeCode.indexOf("-"));
								
								if(gradeCode.equalsIgnoreCase("98")){
									redBrownTotal+=wrapper.getRedWeight();
									rejectedBrownTotal+=wrapper.getRejectWeight();
								}else{
									redWhiteTotal+=wrapper.getRedWeight();
									rejectedWhiteTotal+=wrapper.getRejectWeight();
								}
							}
						}
						
						wrapperData.setRedWeightBrown(redBrownTotal/2000);
						wrapperData.setRedWeightWhite(redWhiteTotal/2000);
						wrapperData.setRejectedWeightBrown(rejectedBrownTotal/2000);
						wrapperData.setRejectedWeightWhite(rejectedWhiteTotal/2000);
						
						redCodeNone.getWrapperData().add(wrapperData);
						
					}else{
						redCodeNone.getWrapperData().add(wrapperData);//Empty
					}
			//	}
				
				
				
				calendar.setTime(ecal.getTime());
				
			}
		}

		{
			List<WrapperData> wrapperDatas=redCodeNone.getWrapperData();
			
			double totalRedWhite=0;
			double totalRedBrown=0;
			double totalRejectWhite=0;
			double totalRejectBrown=0;
			for (WrapperData wrapperData : wrapperDatas) {
				totalRedWhite+=wrapperData.getRedWeightWhite();
				totalRedBrown+=wrapperData.getRedWeightBrown();
				totalRejectWhite+=wrapperData.getRejectedWeightWhite();
				totalRejectBrown+=wrapperData.getRejectedWeightBrown();
			}
			double totalRed=totalRedBrown+totalRedWhite;
			double totalReject=totalRejectWhite+totalRejectBrown;

			
			redCodeNone.setTotalRedWhite(totalRedWhite);
			redCodeNone.setTotalRedBrown(totalRedBrown);
			redCodeNone.setTotalRejectBrown(totalRejectBrown);
			redCodeNone.setTotalRejectWhite(totalRejectWhite);
			
			redCodeNone.setTotalRed(totalRed);
			redCodeNone.setTotalReject(totalReject);
			
			redCodesData.add(redCodeNone);
		}
		
		
		
		
		
		
		data.put("redData", redCodesData);
		
		{
			WrapProductionRedCodePM5 totalData=new WrapProductionRedCodePM5();
			List<WrapperData> totalWrapperDatas=new ArrayList<WrapProductionRedCodePM5.WrapperData>();
			
			double totalRedWhiteTotal=0;
			double totalRedBrownTotal=0;
			double totalRejectWhiteTotal=0;
			double totalRejectBrownTotal=0;
			
			for (int i = 0; i < months.size(); i++) {
				double redWeightWhite=0;
				double redWeightBrown=0;
				double rejectedWeightWhite=0;
				double rejectedWeightBrown=0;
				
				for (WrapProductionRedCodePM5 wrapProductionRedCode : redCodesData) {
					WrapperData wd=wrapProductionRedCode.getWrapperData().get(i);
					redWeightWhite+=wd.getRedWeightWhite();
					redWeightBrown+=wd.getRedWeightBrown();
					rejectedWeightWhite+=wd.getRejectedWeightWhite();
					rejectedWeightBrown+=wd.getRejectedWeightBrown();
					
					totalRedWhiteTotal+=wd.getRedWeightWhite();
					totalRedBrownTotal+=wd.getRedWeightBrown();
					totalRejectWhiteTotal+=wd.getRejectedWeightWhite();
					totalRejectBrownTotal+=wd.getRejectedWeightBrown();
					
				}
				WrapperData wrapperData=totalData.new WrapperData();
				wrapperData.setRedWeightWhite(redWeightWhite);
				wrapperData.setRedWeightBrown(redWeightBrown);
				wrapperData.setRejectedWeightWhite(rejectedWeightWhite);
				wrapperData.setRejectedWeightBrown(rejectedWeightBrown);
				
				totalWrapperDatas.add(wrapperData);
			}
			
			totalData.setWrapperData(totalWrapperDatas);
			
			totalData.setTotalRedWhite(totalRedWhiteTotal);
			totalData.setTotalRedBrown(totalRedBrownTotal);
			totalData.setTotalRejectWhite(totalRejectWhiteTotal);
			totalData.setTotalRejectBrown(totalRejectBrownTotal);
			totalData.setTotalReject(totalRejectBrownTotal+totalRejectWhiteTotal);
			totalData.setTotalRed(totalRedBrownTotal+totalRedWhiteTotal);
			
			
			data.put("totalRedData", totalData);
		}
		
		return data;
	}

	/**
	 * @param redCode
	 * @param productions
	 * @return
	 */
	private List<WrapperProductionPM5> getWrapperProduction(String redCode,
			List<WrapperProductionPM5> productions) {
		List<WrapperProductionPM5> productionsList=new ArrayList<>();
		for (WrapperProductionPM5 wrapperProduction : productions) {
			if(redCode.equals(wrapperProduction.getRedCode())){
				productionsList.add(wrapperProduction);
			}
		}
		return productionsList;
	}

	/* (non-Javadoc)
	 * @see com.st.production.service.WrapperProductionService#getFormatedWorkbookForWrapperRedCode(java.io.File, java.util.Map, java.util.Date, java.util.Date)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public HSSFWorkbook getFormatedWorkbookForWrapperRedCode(File file,
			Map<String, Object> data, Date sdate, Date edate) throws IOException {
		FileInputStream inputStream=new FileInputStream(file);
		HSSFWorkbook workbook=new HSSFWorkbook(inputStream);
	
		Font fontRow=workbook.createFont();
		fontRow.setBold(false);
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
		
		
		Font objectFont=workbook.createFont();
		objectFont.setBold(true);
		objectFont.setColor(IndexedColors.BLACK.getIndex());
		HSSFCellStyle objectCellStyle=workbook.createCellStyle();
		objectCellStyle.setBorderBottom(BorderStyle.THIN);
		objectCellStyle.setBorderLeft(BorderStyle.THIN);
		objectCellStyle.setBorderRight(BorderStyle.THIN);
		objectCellStyle.setBorderTop(BorderStyle.THIN);
		objectCellStyle.setAlignment(HorizontalAlignment.CENTER);
		objectCellStyle.setFillForegroundColor(IndexedColors.GOLD.getIndex());
		objectCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		objectCellStyle.setFont(objectFont);
		objectCellStyle.setWrapText(true);
		
		Font objectFont2=workbook.createFont();
		objectFont2.setBold(true);
		objectFont2.setColor(IndexedColors.BLACK.getIndex());
		HSSFCellStyle objectCellStyle2=workbook.createCellStyle();
		objectCellStyle2.setBorderBottom(BorderStyle.THIN);
		objectCellStyle2.setBorderLeft(BorderStyle.THIN);
		objectCellStyle2.setBorderRight(BorderStyle.THIN);
		objectCellStyle2.setBorderTop(BorderStyle.THIN);
		objectCellStyle2.setAlignment(HorizontalAlignment.CENTER);
		objectCellStyle2.setFillForegroundColor(IndexedColors.LIGHT_YELLOW.getIndex());
		objectCellStyle2.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		objectCellStyle2.setFont(objectFont2);
		objectCellStyle2.setWrapText(true);
		
		HSSFSheet sheet=workbook.getSheetAt(0);
	
		List<String> months=(List<String>) data.get("months");
		List<WrapProductionRedCodePM5> redCodesData=(List<WrapProductionRedCodePM5>)data.get("redData");
		
		
		String headerTitle="PM6 Tissue Wrapper Report - Red/Reject Tons";
		
		int cellCount=0;
		int rowCount=0;
		int numMonth=months.size();
		
		
		int headerLen=(8+months.size()*4);
		if(CommonUtil.isEqual(sdate, edate)){
			headerLen-=4;
		}
		HSSFRow headerRow=sheet.createRow(rowCount);
		
		
		for(int i=0;i<headerLen;i++){
			HSSFCell headerCell=headerRow.createCell(cellCount++);
			headerCell.setCellStyle(objectCellStyle);
			if(i==0){headerCell.setCellValue(headerTitle);}
		}
		
		sheet.addMergedRegion(new CellRangeAddress(rowCount, rowCount, 0, headerLen-1));
		
		cellCount=0;
		
		HSSFRow headerRow2=sheet.createRow(++rowCount);
		{
			HSSFCell cell=headerRow2.createCell(cellCount++);
			cell.setCellStyle(objectCellStyle2);
			cell.setCellValue("Red Code");
			
			HSSFCell cell2=headerRow2.createCell(cellCount++);
			cell2.setCellStyle(objectCellStyle2);
			
			
			sheet.addMergedRegion(new CellRangeAddress(rowCount, rowCount, cellCount-2, cellCount-1));
		}
		{
			for(int i=0;i<numMonth;i++){
				for(int j=0;j<4;j++){
					HSSFCell cell=headerRow2.createCell(cellCount++);
					cell.setCellStyle(objectCellStyle2);
					if(j==0){
						cell.setCellValue(months.get(i));
					}
				}
				sheet.addMergedRegion(new CellRangeAddress(rowCount, rowCount, cellCount-4, cellCount-1));
			}
		}
		
		{
			
			if(CommonUtil.isEqual(sdate, edate)){
				for(int j=0;j<2;j++){
					HSSFCell cell=headerRow2.createCell(cellCount++);
					cell.setCellStyle(objectCellStyle2);
					if(j==0){
						cell.setCellValue("Total");
					}
				}
				sheet.addMergedRegion(new CellRangeAddress(rowCount, rowCount, cellCount-2, cellCount-1));
			}else{
				for(int j=0;j<6;j++){
					HSSFCell cell=headerRow2.createCell(cellCount++);
					cell.setCellStyle(objectCellStyle2);
					if(j==0){
						cell.setCellValue("Total");
					}
				}
				sheet.addMergedRegion(new CellRangeAddress(rowCount, rowCount, cellCount-6, cellCount-1));
			}
			
		}
		
		cellCount=0;
		
		HSSFRow headerRow3=sheet.createRow(++rowCount);
		{
			HSSFCell cell=headerRow3.createCell(cellCount++);
			cell.setCellStyle(objectCellStyle2);
			cell.setCellValue("Code");
			
			sheet.addMergedRegion(new CellRangeAddress(rowCount, rowCount+1, cellCount-1, cellCount-1));
			
			HSSFCell cell2=headerRow3.createCell(cellCount++);
			cell2.setCellStyle(objectCellStyle2);
			cell2.setCellValue("Description");
			
			sheet.addMergedRegion(new CellRangeAddress(rowCount, rowCount+1, cellCount-1, cellCount-1));
		}
		
		{
			for(int i=0;i<numMonth;i++){
				for(int j=0;j<2;j++){
					HSSFCell cell1=headerRow3.createCell(cellCount++);
					cell1.setCellStyle(objectCellStyle2);
					if(j==0){
						cell1.setCellValue("Red");
					}
				}
				sheet.addMergedRegion(new CellRangeAddress(rowCount, rowCount, cellCount-2, cellCount-1));
				for(int j=0;j<2;j++){
					HSSFCell cell1=headerRow3.createCell(cellCount++);
					cell1.setCellStyle(objectCellStyle2);
					if(j==0){
						cell1.setCellValue("Rejected");
					}
				}
				sheet.addMergedRegion(new CellRangeAddress(rowCount, rowCount, cellCount-2, cellCount-1));
			}
		}
		
		{
			
			if(!CommonUtil.isEqual(sdate, edate)){
				for(int i=0;i<2;i++){
					HSSFCell cell1=headerRow3.createCell(cellCount++);
					cell1.setCellStyle(objectCellStyle2);
					if(i==0){
						cell1.setCellValue("Red");
					}
				}
				
				sheet.addMergedRegion(new CellRangeAddress(rowCount, rowCount, cellCount-2, cellCount-1));
				
				for(int i=0;i<2;i++){
					HSSFCell cell1=headerRow3.createCell(cellCount++);
					cell1.setCellStyle(objectCellStyle2);
					if(i==0){
						cell1.setCellValue("Rejected");
					}
				}
				
				sheet.addMergedRegion(new CellRangeAddress(rowCount, rowCount, cellCount-2, cellCount-1));
				
			}
			
			
			
			
			HSSFCell cell3=headerRow3.createCell(cellCount++);
			cell3.setCellStyle(objectCellStyle2);
			cell3.setCellValue("Red Total");
			sheet.addMergedRegion(new CellRangeAddress(rowCount, rowCount+1, cellCount-1, cellCount-1));
			
			HSSFCell cell4=headerRow3.createCell(cellCount++);
			cell4.setCellStyle(objectCellStyle2);
			cell4.setCellValue("Rejected Total");
			
			sheet.addMergedRegion(new CellRangeAddress(rowCount, rowCount+1, cellCount-1, cellCount-1));
		}
		
		
		cellCount=0;
		int totalCell=8+numMonth*4;
		
		if(CommonUtil.isEqual(sdate, edate)){
			totalCell-=4;
		}
		
		HSSFRow headerRow4=sheet.createRow(++rowCount);
		for(int i=0;i<totalCell;i++){
			
			HSSFCell cell=headerRow4.createCell(cellCount++);
			cell.setCellStyle(objectCellStyle2);
			
			if(i==0 || i==1){
				
			}else{
				if(i%2==0){
					cell.setCellValue("White");
				}else{
					cell.setCellValue("Brown");
				}
			}
			
		}
		
		
		for (WrapProductionRedCodePM5 wrapProductionRedCode : redCodesData) {
		
			cellCount=0;
			
			HSSFRow row=sheet.createRow(++rowCount);
			row.setHeight((short)280);
			
			HSSFCell cell1=row.createCell(cellCount++);
			HSSFCell cell2=row.createCell(cellCount++);
			
			cell1.setCellStyle(rowCellStyle);
			cell2.setCellStyle(rowCellStyle);
			
			cell1.setCellValue(wrapProductionRedCode.getRedCode());
			cell2.setCellValue(wrapProductionRedCode.getRedCodeDesc());
			
			List<WrapperData> wrapperDatas=wrapProductionRedCode.getWrapperData();
			for (WrapperData wrapperData : wrapperDatas) {
				HSSFCell cell3=row.createCell(cellCount++);
				HSSFCell cell4=row.createCell(cellCount++);
				HSSFCell cell5=row.createCell(cellCount++);
				HSSFCell cell6=row.createCell(cellCount++);
				
				cell3.setCellStyle(rowCellStyle);
				cell4.setCellStyle(rowCellStyle);
				cell5.setCellStyle(rowCellStyle);
				cell6.setCellStyle(rowCellStyle);
				
				cell3.setCellValue(CommonUtil.round(wrapperData.getRedWeightWhite(), 2));
				cell4.setCellValue(CommonUtil.round(wrapperData.getRedWeightBrown(), 2));
				cell5.setCellValue(CommonUtil.round(wrapperData.getRejectedWeightWhite(), 2));
				cell6.setCellValue(CommonUtil.round(wrapperData.getRejectedWeightBrown(), 2));
				
			}
			
			
			if(!CommonUtil.isEqual(sdate, edate)){
				
				HSSFCell cell7=row.createCell(cellCount++);
				HSSFCell cell8=row.createCell(cellCount++);
				HSSFCell cell9=row.createCell(cellCount++);
				HSSFCell cell10=row.createCell(cellCount++);
				
				cell7.setCellStyle(rowCellStyle);
				cell8.setCellStyle(rowCellStyle);
				cell9.setCellStyle(rowCellStyle);
				cell10.setCellStyle(rowCellStyle);
				
				cell7.setCellValue(CommonUtil.round(wrapProductionRedCode.getTotalRedWhite(), 2));
				cell8.setCellValue(CommonUtil.round(wrapProductionRedCode.getTotalRedBrown(), 2));
				cell9.setCellValue(CommonUtil.round(wrapProductionRedCode.getTotalRejectWhite(), 2));
				cell10.setCellValue(CommonUtil.round(wrapProductionRedCode.getTotalRejectBrown(), 2));
				
			}
			
			
			
			HSSFCell cell11=row.createCell(cellCount++);
			HSSFCell cell12=row.createCell(cellCount++);
			
			cell11.setCellStyle(rowCellStyle);
			cell12.setCellStyle(rowCellStyle);
			
			cell11.setCellValue(CommonUtil.round(wrapProductionRedCode.getTotalRed(), 2));
			cell12.setCellValue(CommonUtil.round(wrapProductionRedCode.getTotalReject(), 2));
		}
		
		
		{
			WrapProductionRedCodePM5 wrapProductionRedCode=(WrapProductionRedCodePM5)data.get("totalRedData");
			cellCount=0;
			
			HSSFRow row=sheet.createRow(++rowCount);
			row.setHeight((short)280);
			
			HSSFCell cell1=row.createCell(cellCount++);
			HSSFCell cell2=row.createCell(cellCount++);
			
			cell1.setCellStyle(rowCellStyle);
			cell2.setCellStyle(rowCellStyle);
			
			cell1.setCellValue("");
			cell2.setCellValue("TOTAL");
			
			List<WrapperData> wrapperDatas=wrapProductionRedCode.getWrapperData();
			for (WrapperData wrapperData : wrapperDatas) {
				HSSFCell cell3=row.createCell(cellCount++);
				HSSFCell cell4=row.createCell(cellCount++);
				HSSFCell cell5=row.createCell(cellCount++);
				HSSFCell cell6=row.createCell(cellCount++);
				
				cell3.setCellStyle(rowCellStyle);
				cell4.setCellStyle(rowCellStyle);
				cell5.setCellStyle(rowCellStyle);
				cell6.setCellStyle(rowCellStyle);
				
				cell3.setCellValue(CommonUtil.round(wrapperData.getRedWeightWhite(), 2));
				cell4.setCellValue(CommonUtil.round(wrapperData.getRedWeightBrown(), 2));
				cell5.setCellValue(CommonUtil.round(wrapperData.getRejectedWeightWhite(), 2));
				cell6.setCellValue(CommonUtil.round(wrapperData.getRejectedWeightBrown(), 2));
				
			}
			
			if(!CommonUtil.isEqual(sdate, edate)){
				HSSFCell cell7=row.createCell(cellCount++);
				HSSFCell cell8=row.createCell(cellCount++);
				HSSFCell cell9=row.createCell(cellCount++);
				HSSFCell cell10=row.createCell(cellCount++);
				
				cell7.setCellStyle(rowCellStyle);
				cell8.setCellStyle(rowCellStyle);
				cell9.setCellStyle(rowCellStyle);
				cell10.setCellStyle(rowCellStyle);
				
				cell7.setCellValue(CommonUtil.round(wrapProductionRedCode.getTotalRedWhite(), 2));
				cell8.setCellValue(CommonUtil.round(wrapProductionRedCode.getTotalRedBrown(), 2));
				cell9.setCellValue(CommonUtil.round(wrapProductionRedCode.getTotalRejectWhite(), 2));
				cell10.setCellValue(CommonUtil.round(wrapProductionRedCode.getTotalRejectBrown(), 2));
				
				
			}
			
			
			HSSFCell cell11=row.createCell(cellCount++);
			HSSFCell cell12=row.createCell(cellCount++);
			
			cell11.setCellStyle(rowCellStyle);
			cell12.setCellStyle(rowCellStyle);
			
			cell11.setCellValue(CommonUtil.round(wrapProductionRedCode.getTotalRed(), 2));
			cell12.setCellValue(CommonUtil.round(wrapProductionRedCode.getTotalReject(), 2));
		}
		
		return workbook;
	}

	/* (non-Javadoc)
	 * @see com.st.production.service.WrapperProductionService#getCustomerFromWrapper()
	 */
	@Transactional
	@Override
	public List<String> getCustomerFromWrapper() {
		return wrapperProductionDao.getCustomerFromWrapper();
	}

	/* (non-Javadoc)
	 * @see com.st.production.service.WrapperProductionService#getInventoryWrapperProductions(java.util.Date, java.util.Date, java.lang.String)
	 */
	@Transactional
	@Override
	public List<WrapperProductionPM5> getInventoryWrapperProductions(Date date,
			String customer) {
		return wrapperProductionDao.getInventoryWrapperProductions(date,customer);
	}

	/* (non-Javadoc)
	 * @see com.st.production.service.WrapperProductionService#getGradeAndHourData(java.util.Date, java.util.Date)
	 */
	@Transactional
	@Override
	public List<Map<String, Object>> getGradeAndHourData(Date sdate, Date edate
	) throws ProductionException {
		
		return wrapperProductionDao.getGradeAndHoursData(sdate,edate);

	}

	/* (non-Javadoc)
	 * @see com.st.production.service.WrapperProductionService#getWrapperForDailyInventory(java.util.Date, java.util.Date)
	 */
	@Transactional
	@Override
	public List<WrapperProductionPM5> getWrapperForDailyInventory(Date sdate,
			Date edate) {
		return wrapperProductionDao.getWrapperForDailyInventory(sdate,edate);
	}

	/* (non-Javadoc)
	 * @see com.st.production.service.WrapperProductionService#isNewRedEntryExist()
	 */
	@Transactional
	@Override
	public Map<String, Object> isNewRedEntryExist() {
		// TODO Auto-generated method stub
		return wrapperProductionDao.isNewRedEntryExist();
	}

	/* (non-Javadoc)
	 * @see com.st.production.service.WrapperProductionService#getWrapperFullProductionData(java.util.Date, java.util.Date)
	 */
	@Transactional
	@Override
	public List<WrapperProductionPM5> getWrapperRedRejectProductionData(Date sdate,
			Date edate) {
		
		return wrapperProductionDao.getWrapperRedRejectProductionData(sdate,edate);
	}

	/* (non-Javadoc)
	 * @see com.st.production.service.WrapperProductionService#getWrapperTons()
	 */
	@Transactional
	@Override
	public WrapperProductionPM5 getWrapperTonsOfShift() {
		return wrapperProductionDao.getWrapperTonsOfShift();
	}

	/* (non-Javadoc)
	 * @see com.st.production.service.WrapperProductionService#getWrapperAvgByGrade(java.util.Date, java.util.Date)
	 */
	@Transactional
	@Override
	public List<WrapperProductionPM5> getWrapperAvgByGrade(Date sdate, Date edate) {
		return wrapperProductionDao.getWrapperAvgByGrade(sdate,edate);
	}

	/* (non-Javadoc)
	 * @see com.st.production.service.WrapperProductionService#getWrapperDataByDate(java.util.Date, java.util.Date)
	 */
	@Transactional
	@Override
	public List<WrapperProductionPM5> getWrapperDataByDate(Date sdate,
			Date edate) throws ProductionException {
		return wrapperProductionDao.getWrapperDataByDate(sdate,edate);
	}

	/* (non-Javadoc)
	 * @see com.st.production.service.WrapperProductionService#getWrapperRedRejectProductionData_PM5(java.util.Date, java.util.Date)
	 */
	@Override
	@Transactional
	public List<WrapperProductionPM5> getWrapperRedRejectProductionData_PM5(Date sdate, Date edate) {
		// TODO Auto-generated method stub
		return wrapperProductionDao.getWrapperRedRejectProductionData_PM5(sdate,edate);
	}

	/* (non-Javadoc)
	 * @see com.st.production.service.WrapperProductionService#isNewRedEntryExist_PM5()
	 */
	@Override
	@Transactional
	public Map<String, Object> isNewRedEntryExist_PM5() {
		// TODO Auto-generated method stub
		return wrapperProductionDao.isNewRedEntryExist_PM5();
	}



}

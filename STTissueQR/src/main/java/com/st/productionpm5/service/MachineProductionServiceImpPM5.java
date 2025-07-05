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
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
import org.joda.time.DateTime;
import org.joda.time.Days;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.st.common.Columns;
import com.st.common.ColumnsOfTable;
import com.st.common.CommonUtil;
import com.st.common.exception.ProductionException;
import com.st.efficiencypm5.dao.EfficiencyDaoPM5;
import com.st.efficiencypm5.model.EfficiencyPM5;
import com.st.efficiencypm5.model.PrimaryCodePM5;
import com.st.productionpm5.dao.MachineProductionDaoPM5;
import com.st.productionpm5.dao.WrapperProductionDaoPM5;
import com.st.productionpm5.model.MachineAndWrapperPM5;
import com.st.productionpm5.model.MachineProductionPM5;
import com.st.productionpm5.model.MachineProductionSummaryPM5;
import com.st.productionpm5.model.WrapperProductionPM5;
import com.st.productionpm5.model.WrapperProductionSummaryPM5;
import com.st.utilitykpimaster.model.MasterData;
import com.st.utilitykpimasterPM5.dao.MasterDataDaoPM5;

/**
 * @author sbora
 *
 */
@Service
public class MachineProductionServiceImpPM5 implements MachineProductionServicePM5 {

	@Autowired
	private MachineProductionDaoPM5 machineProductionDao;
	
	@Autowired
	private EfficiencyDaoPM5 efficiencyDao;
	
	@Autowired
	private MasterDataDaoPM5 masterDataDao;
	
	@Autowired
	private WrapperProductionDaoPM5 wrapperProductionDao;
	
	private static final String VIEW_PAGE="viewpage";
	
	private SimpleDateFormat dateFormat1=new SimpleDateFormat("MM/dd/yyyy");
	private SimpleDateFormat dateFormat=new SimpleDateFormat("MM-dd-yyyy");
	private SimpleDateFormat dateFormat2=new SimpleDateFormat("MM-dd-yyyy hh:mm:ss");
	
	@Transactional
	@Override
	public List<MachineProductionPM5> getMachineProductions(Date sdate, Date edate) throws ProductionException {
		return machineProductionDao.getMachineProductions(sdate,edate);
	}

	
	//Other Function
	@Override
	public HSSFWorkbook getFormatedWorkbookForDailyReport(File file,
			List<Map<String, String>> datas, Date sdate, Date edate)
			throws IOException {
		
		FileInputStream inputStream=new FileInputStream(file);
		HSSFWorkbook workbook=new HSSFWorkbook(inputStream);
	
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
		
		HSSFSheet sheet=workbook.getSheetAt(0);
		sheet.setColumnWidth(19, 9000);
		
		
		
		sheet.getRow(0).getCell(0).setCellValue("PM5 Production Report For - "+dateFormat1.format(sdate)+"-"+dateFormat1.format(edate));
		
		int rowCount=2;
		
	//	double TOTAL_01=0;
		double TOTAL_02=0;
		double TOTAL_03=0;
		double TOTAL_04=0;
		double TOTAL_05=0;
		@SuppressWarnings("unused")
		double TOTAL_06=0;
		double TOTAL_07=0;
		double TOTAL_08=0;
		double TOTAL_09=0;
		double TOTAL_10=0;
		double TOTAL_11=0;
		double TOTAL_12=0;
		double TOTAL_13=0;
		
		double TOTAL_22=0;//Code By Roshan Tailor
		double TOTAL_21=0;//Code By Roshan Tailor
		double TOTAL_23=0;//Code By Roshan Tailor For Un-Controlled Down Time
		double TOTAL_24=0;//Reject Tons
		
		double TOTAL_25=0;//Reject Tons For Machine
		double TOTAL_26=0;//Net White Reel Tons
		
	//	double TOTAL_14=0;
	//	double TOTAL_15=0;
	//	double TOTAL_16=0;
	//	double TOTAL_17=0;
	//	double TOTAL_18=0;
	//	double TOTAL_19=0;
	//	double TOTAL_20=0;
		
		int totalLength=datas.size();
		
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
			
			//Reject Tons For Machine
			HSSFCell COL_24=row.createCell(Columns.COL_02);
			COL_24.setCellStyle(rowCellStyle);
			COL_24.setCellValue(NumberUtils.toDouble(map.get(ColumnsOfTable.COL_24), 0));
			TOTAL_25+=NumberUtils.toDouble(map.get(ColumnsOfTable.COL_24), 0);
			
			//Net White Reel Tons
			HSSFCell COL_25=row.createCell(Columns.COL_03);
			COL_25.setCellStyle(rowCellStyle);
			COL_25.setCellValue(NumberUtils.toDouble(map.get(ColumnsOfTable.COL_25), 0));
			TOTAL_26+=NumberUtils.toDouble(map.get(ColumnsOfTable.COL_25), 0);
			
			
			HSSFCell COL_03=row.createCell(Columns.COL_04);
			COL_03.setCellStyle(rowCellStyle);
			COL_03.setCellValue(NumberUtils.toDouble(map.get(ColumnsOfTable.COL_03), 0));
			TOTAL_03+=NumberUtils.toDouble(map.get(ColumnsOfTable.COL_03), 0);
			
			HSSFCell COL_04=row.createCell(Columns.COL_05);
			COL_04.setCellStyle(rowCellStyle);
			COL_04.setCellValue(NumberUtils.toDouble(map.get(ColumnsOfTable.COL_04), 0));
			TOTAL_04+=NumberUtils.toDouble(map.get(ColumnsOfTable.COL_04), 0);
			
			HSSFCell COL_05=row.createCell(Columns.COL_07);
			COL_05.setCellStyle(rowCellStyle);
			COL_05.setCellValue(NumberUtils.toDouble(map.get(ColumnsOfTable.COL_05), 0));
			TOTAL_05+=NumberUtils.toDouble(map.get(ColumnsOfTable.COL_05), 0);
			//
			//Reject Tons
			HSSFCell COL_23=row.createCell(Columns.COL_06);
			COL_23.setCellStyle(rowCellStyle);
			COL_23.setCellValue(NumberUtils.toDouble(map.get(ColumnsOfTable.COL_23), 0));
			TOTAL_24+=NumberUtils.toDouble(map.get(ColumnsOfTable.COL_23), 0);
			
			HSSFCell COL_06=row.createCell(Columns.COL_08);
			COL_06.setCellStyle(rowCellStyle);
			COL_06.setCellValue(NumberUtils.toDouble(map.get(ColumnsOfTable.COL_06), 0));
			TOTAL_06+=NumberUtils.toDouble(map.get(ColumnsOfTable.COL_06), 0);
			
			HSSFCell COL_07=row.createCell(Columns.COL_09);
			COL_07.setCellStyle(rowCellStyle);
			COL_07.setCellValue(NumberUtils.toDouble(map.get(ColumnsOfTable.COL_07), 0));
			TOTAL_07+=NumberUtils.toDouble(map.get(ColumnsOfTable.COL_07), 0);
			
			HSSFCell COL_08=row.createCell(Columns.COL_10);
			COL_08.setCellStyle(rowCellStyle);
			COL_08.setCellValue(NumberUtils.toDouble(map.get(ColumnsOfTable.COL_08), 0));
			TOTAL_08+=NumberUtils.toDouble(map.get(ColumnsOfTable.COL_08), 0);
			
			HSSFCell COL_09=row.createCell(Columns.COL_11);
			COL_09.setCellStyle(rowCellStyle);
			COL_09.setCellValue(NumberUtils.toDouble(map.get(ColumnsOfTable.COL_09), 0));
			TOTAL_09+=NumberUtils.toDouble(map.get(ColumnsOfTable.COL_09), 0);
			
			HSSFCell COL_10=row.createCell(Columns.COL_12);
			COL_10.setCellStyle(rowCellStyle);
			COL_10.setCellValue(NumberUtils.toDouble(map.get(ColumnsOfTable.COL_10), 0));
			TOTAL_10+=NumberUtils.toDouble(map.get(ColumnsOfTable.COL_10), 0);
			
			HSSFCell COL_11=row.createCell(Columns.COL_13);
			COL_11.setCellStyle(rowCellStyle);
			COL_11.setCellValue(NumberUtils.toDouble(map.get(ColumnsOfTable.COL_11), 0));
			TOTAL_11+=NumberUtils.toDouble(map.get(ColumnsOfTable.COL_11), 0);
			
			HSSFCell COL_12=row.createCell(Columns.COL_14);
			COL_12.setCellStyle(rowCellStyle);
			COL_12.setCellValue(NumberUtils.toDouble(map.get(ColumnsOfTable.COL_12), 0));
			TOTAL_12+=NumberUtils.toDouble(map.get(ColumnsOfTable.COL_12), 0);
			
			HSSFCell COL_13=row.createCell(Columns.COL_15);
			COL_13.setCellStyle(rowCellStyle);
			COL_13.setCellValue(NumberUtils.toDouble(map.get(ColumnsOfTable.COL_13), 0));
			TOTAL_13+=NumberUtils.toDouble(map.get(ColumnsOfTable.COL_13), 0);
			
			//Code Starts From Here Done By Roshan
			HSSFCell COL_22=row.createCell(Columns.COL_16);
			COL_22.setCellStyle(rowCellStyle);
			COL_22.setCellValue(NumberUtils.toDouble(map.get(ColumnsOfTable.COL_22), 0));
			//TOTAL_22+=NumberUtils.toDouble(map.get(ColumnsOfTable.COL_22), 0);
			
			HSSFCell COL_21=row.createCell(Columns.COL_17);
			COL_21.setCellStyle(rowCellStyle);
			COL_21.setCellValue(NumberUtils.toDouble(map.get(ColumnsOfTable.COL_21), 0));
			TOTAL_21+=NumberUtils.toDouble(map.get(ColumnsOfTable.COL_21), 0);
			
			//Code Ends Here Done By Roshan Tailor
			
			HSSFCell COL_14=row.createCell(Columns.COL_18);
			COL_14.setCellStyle(rowCellStyle);
			COL_14.setCellValue(NumberUtils.toDouble(map.get(ColumnsOfTable.COL_14), 0));
		//	TOTAL_14+=NumberUtils.toDouble(map.get(ColumnsOfTable.COL_14), 0);
			
			HSSFCell COL_15=row.createCell(Columns.COL_19);
			COL_15.setCellStyle(rowCellStyle);
			COL_15.setCellValue(NumberUtils.toDouble(map.get(ColumnsOfTable.COL_15), 0));
		//	TOTAL_15+=NumberUtils.toDouble(map.get(ColumnsOfTable.COL_15), 0);
			
			HSSFCell COL_16=row.createCell(Columns.COL_20);
			COL_16.setCellStyle(rowCellStyle);
			COL_16.setCellValue(NumberUtils.toDouble(map.get(ColumnsOfTable.COL_16), 0));
		//	TOTAL_16+=NumberUtils.toDouble(map.get(ColumnsOfTable.COL_16), 0);
			
			HSSFCell COL_17=row.createCell(Columns.COL_21);
			COL_17.setCellStyle(rowCellStyle);
			COL_17.setCellValue(NumberUtils.toDouble(map.get(ColumnsOfTable.COL_17), 0));
		//	TOTAL_17+=NumberUtils.toDouble(map.get(ColumnsOfTable.COL_17), 0);
			
			HSSFCell COL_18=row.createCell(Columns.COL_22);
			COL_18.setCellStyle(rowCellStyle);
			String productCode=map.get(ColumnsOfTable.COL_18);
			COL_18.setCellValue(productCode==null?"":productCode.replace("<br>", ""));
			
			HSSFCell COL_19=row.createCell(Columns.COL_23);
			COL_19.setCellStyle(rowCellStyle);
			String customer=map.get(ColumnsOfTable.COL_19);
			COL_19.setCellValue(customer==null?"":customer.replace("<br>", ""));
			
			HSSFCell COL_20=row.createCell(Columns.COL_24);
			COL_20.setCellStyle(rowCellStyle);
			COL_20.setCellValue(map.get(ColumnsOfTable.COL_20)==null?"":map.get(ColumnsOfTable.COL_20));
			
			
			
			
		}
		
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
			HSSFCell COL_11=row.createCell(Columns.COL_10);
			HSSFCell COL_12=row.createCell(Columns.COL_11);
			HSSFCell COL_13=row.createCell(Columns.COL_12);
			HSSFCell COL_14=row.createCell(Columns.COL_13);
			HSSFCell COL_15=row.createCell(Columns.COL_14);//Code By Roshan Tailor
			HSSFCell COL_16=row.createCell(Columns.COL_15);//Code By Roshan Tailor
			HSSFCell COL_17=row.createCell(Columns.COL_16);
			HSSFCell COL_18=row.createCell(Columns.COL_17);
			HSSFCell COL_19=row.createCell(Columns.COL_18);
			HSSFCell COL_20=row.createCell(Columns.COL_19);
			HSSFCell COL_21=row.createCell(Columns.COL_20);
			HSSFCell COL_22=row.createCell(Columns.COL_21);
			
			HSSFCell COL_23=row.createCell(Columns.COL_22);
			HSSFCell COL_24=row.createCell(Columns.COL_23);
			
			HSSFCell COL_25=row.createCell(Columns.COL_24);
			HSSFCell COL_26=row.createCell(Columns.COL_25);
			


			
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
			COL_11.setCellStyle(objectCellStyle);
			COL_12.setCellStyle(objectCellStyle);
			COL_13.setCellStyle(objectCellStyle);
			COL_14.setCellStyle(objectCellStyle);
			COL_15.setCellStyle(objectCellStyle);
			COL_16.setCellStyle(objectCellStyle);
			COL_17.setCellStyle(objectCellStyle);
			COL_18.setCellStyle(objectCellStyle);
			COL_19.setCellStyle(objectCellStyle);
			COL_20.setCellStyle(objectCellStyle);
			
			COL_21.setCellStyle(objectCellStyle);//Code By Roshan tailor
			COL_22.setCellStyle(objectCellStyle);//Code By Roshan Tailor
			
			COL_23.setCellStyle(objectCellStyle);//Code By Roshan Tailor
			COL_24.setCellStyle(objectCellStyle);
			COL_25.setCellStyle(objectCellStyle);
			COL_26.setCellStyle(objectCellStyle);
			
			
			COL_01.setCellValue("Total");
			COL_02.setCellValue(TOTAL_02);	//Reel Ton
			COL_03.setCellValue(TOTAL_25);  
			COL_04.setCellValue(TOTAL_26);  
			COL_05.setCellValue(TOTAL_03);  //White Ton
			
			
			
			COL_07.setCellValue(TOTAL_24);  
			COL_06.setCellValue(TOTAL_04);  //
			COL_08.setCellValue(TOTAL_05);	//Total Ton
			COL_09.setCellValue(CommonUtil.round(TOTAL_06/totalLength, 2));
			COL_10.setCellValue(TOTAL_07);
			COL_11.setCellValue(TOTAL_08);
			COL_12.setCellValue(CommonUtil.round(TOTAL_09/totalLength, 2));
			COL_13.setCellValue(TOTAL_10);
			COL_14.setCellValue(TOTAL_11);
			COL_15.setCellValue(TOTAL_12);	//Porcess Downtime
			COL_16.setCellValue(TOTAL_13);	//Machine Downtime
			
			double operatingTime=0;
			double totalCalenderHr=0;
			int days=CommonUtil.getDaysDiffernce(sdate, edate);
			for (int i = 0; i <=days; i++) {
				
				totalCalenderHr=totalCalenderHr+1440;
				//System.out.println(i);
			}
			
			COL_17.setCellValue(totalCalenderHr);
			COL_18.setCellValue(TOTAL_21);
			
			double paperYield=0;
			if(TOTAL_02!=0){
				paperYield=(TOTAL_05/TOTAL_02);
			}
			double firstQuality=0;
			if(TOTAL_05!=0){
				firstQuality=(TOTAL_03/TOTAL_05);
			}
			
			double uptime=0;
			if(totalLength!=0){
				
				//Old Formula 
				//uptime=((1440*totalLength-(TOTAL_12+TOTAL_13))/(1440*totalLength));
				
				//New Formula
				//uptime=((100-(TOTAL_12+TOTAL_13)/(1440-TOTAL_21)))/100;
				/*double totalTime=TOTAL_12+TOTAL_13;
				double operatingTime=totalTime-TOTAL_21;
				double UpTime_Cal=totalTime/operatingTime;
				
				double downTimePer=UpTime_Cal*100;
				
				uptime=CommonUtil.round(100-downTimePer, 2);*/

				
				double totalTime=TOTAL_12+TOTAL_13;
				
				/*Calendar c = Calendar.getInstance();
				int monthMaxDays = c.getActualMaximum(Calendar.DAY_OF_MONTH);
				
				
				Calendar cal = Calendar.getInstance();
			    cal.setTime(sdate);
			    int day = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
			    
			    System.out.println("Hat Be..."+day);*/
				
				
				//System.out.println("totalCalenderHr::"+totalCalenderHr);
				operatingTime=totalCalenderHr-TOTAL_21; //For 31 Days
				
				double UpTime_Cal=totalTime/operatingTime;
				
				double downTimePer=UpTime_Cal*100;
				
				uptime=CommonUtil.round(100-downTimePer, 2);
				
				
				
			}
			double effPercent=(paperYield*firstQuality*uptime);

			
			COL_19.setCellValue(CommonUtil.round(paperYield*100, 2));
			COL_20.setCellValue(CommonUtil.round(firstQuality*100, 2));
			
			//Old Formula Wise
			/*COL_18.setCellValue(CommonUtil.round(uptime*100, 2));
			COL_19.setCellValue(CommonUtil.round(effPercent*100, 2));*/
			
			//New Formula Wise
			COL_21.setCellValue(CommonUtil.round(uptime, 2));
			COL_22.setCellValue(CommonUtil.round(effPercent, 2));
			
			COL_23.setCellValue("Uncontrollable excluded");
			COL_24.setCellValue("");
			COL_25.setCellValue("");
			
			
		
		}
		//Left A Blank Row
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
			HSSFCell COL_11=row.createCell(Columns.COL_10);
			HSSFCell COL_12=row.createCell(Columns.COL_11);
			HSSFCell COL_13=row.createCell(Columns.COL_12);
			HSSFCell COL_14=row.createCell(Columns.COL_13);
			HSSFCell COL_15=row.createCell(Columns.COL_14);
			HSSFCell COL_16=row.createCell(Columns.COL_15);
			HSSFCell COL_17=row.createCell(Columns.COL_16);
			HSSFCell COL_18=row.createCell(Columns.COL_17);
			HSSFCell COL_19=row.createCell(Columns.COL_18);
			HSSFCell COL_20=row.createCell(Columns.COL_19);
			HSSFCell COL_21=row.createCell(Columns.COL_20);
			HSSFCell COL_22=row.createCell(Columns.COL_21);
			HSSFCell COL_23=row.createCell(Columns.COL_22);
			
			HSSFCell COL_24=row.createCell(Columns.COL_23);
			HSSFCell COL_25=row.createCell(Columns.COL_24);
			
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
			COL_11.setCellStyle(rowCellStyle);
			COL_12.setCellStyle(rowCellStyle);
			COL_13.setCellStyle(rowCellStyle);
			COL_14.setCellStyle(rowCellStyle);
			COL_15.setCellStyle(rowCellStyle);
			COL_16.setCellStyle(rowCellStyle);
			COL_17.setCellStyle(rowCellStyle);
			COL_18.setCellStyle(rowCellStyle);
			COL_19.setCellStyle(rowCellStyle);
			COL_20.setCellStyle(rowCellStyle);
			COL_21.setCellStyle(rowCellStyle); 
			COL_22.setCellStyle(rowCellStyle);
			COL_23.setCellStyle(rowCellStyle);
			
			COL_24.setCellStyle(rowCellStyle);
			COL_25.setCellStyle(rowCellStyle);
			
			COL_01.setCellValue("");
			COL_02.setCellValue("");	 
			COL_03.setCellValue("");   
			COL_04.setCellValue("");  
			COL_05.setCellValue("");	 
			COL_06.setCellValue("");
			COL_07.setCellValue("");
			COL_08.setCellValue("");
			COL_09.setCellValue("");
			COL_10.setCellValue("");
			COL_11.setCellValue("");
			COL_12.setCellValue("");	 
			COL_13.setCellValue("");	 
			COL_14.setCellValue("");
			COL_15.setCellValue("");
			COL_16.setCellValue("");
			COL_17.setCellValue("");
			COL_18.setCellValue("");
			COL_19.setCellValue("");
			COL_20.setCellValue("");
			COL_21.setCellValue("");
			COL_22.setCellValue("");
			COL_23.setCellValue("");
			COL_24.setCellValue("");
			COL_25.setCellValue("");
		}
		//Code By Roshan Tailor For Uncontrolled hours
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
			HSSFCell COL_11=row.createCell(Columns.COL_10);
			HSSFCell COL_12=row.createCell(Columns.COL_11);
			HSSFCell COL_13=row.createCell(Columns.COL_12);
			HSSFCell COL_14=row.createCell(Columns.COL_13);
			HSSFCell COL_15=row.createCell(Columns.COL_14);
			HSSFCell COL_16=row.createCell(Columns.COL_15);
			HSSFCell COL_17=row.createCell(Columns.COL_16);
			HSSFCell COL_18=row.createCell(Columns.COL_17);
			HSSFCell COL_19=row.createCell(Columns.COL_18);
			HSSFCell COL_20=row.createCell(Columns.COL_19);
			HSSFCell COL_21=row.createCell(Columns.COL_20);
			HSSFCell COL_22=row.createCell(Columns.COL_21);
			HSSFCell COL_23=row.createCell(Columns.COL_22);
			
			HSSFCell COL_24=row.createCell(Columns.COL_23);
			HSSFCell COL_25=row.createCell(Columns.COL_24);

			
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
			COL_11.setCellStyle(objectCellStyle);
			COL_12.setCellStyle(objectCellStyle);
			COL_13.setCellStyle(objectCellStyle);
			COL_14.setCellStyle(objectCellStyle);
			COL_15.setCellStyle(objectCellStyle);
			COL_16.setCellStyle(objectCellStyle);
			COL_17.setCellStyle(objectCellStyle);
			COL_18.setCellStyle(objectCellStyle);
			COL_19.setCellStyle(objectCellStyle);
			COL_20.setCellStyle(objectCellStyle);
			
			COL_21.setCellStyle(objectCellStyle); 
			COL_22.setCellStyle(objectCellStyle); 
			
			COL_23.setCellStyle(objectCellStyle); 
			COL_24.setCellStyle(objectCellStyle); 
			COL_25.setCellStyle(objectCellStyle); 
			
			//Now Apply New Formula For Non Control able Hours
			
			COL_01.setCellValue("Total");
			COL_02.setCellValue(TOTAL_02);	
			COL_03.setCellValue(TOTAL_25);  
			COL_04.setCellValue(TOTAL_26);  
			COL_05.setCellValue(TOTAL_03);   
			COL_07.setCellValue(TOTAL_24);  
			COL_06.setCellValue(TOTAL_04);  
			COL_08.setCellValue(TOTAL_05);	 
			COL_09.setCellValue(CommonUtil.round(TOTAL_06/totalLength, 2));
			COL_10.setCellValue(TOTAL_07);
			COL_11.setCellValue(TOTAL_08);
			COL_12.setCellValue(CommonUtil.round(TOTAL_09/totalLength, 2));
			COL_13.setCellValue(TOTAL_10);
			COL_14.setCellValue(TOTAL_11);
			COL_15.setCellValue(TOTAL_12);	 
			COL_16.setCellValue(TOTAL_13);	
			
			int days=CommonUtil.getDaysDiffernce(sdate, edate);
			double operatingTime=0;
			double totalCalenderHr=0;
			for (int i = 0; i <=days; i++) {
				
				totalCalenderHr=totalCalenderHr+1440;
			}
			COL_17.setCellValue(totalCalenderHr);
			COL_18.setCellValue(TOTAL_21);
			
			double paperYield=0;
			if(TOTAL_02!=0){
				paperYield=(TOTAL_05/TOTAL_02);
			}
			double firstQuality=0;
			if(TOTAL_05!=0){
				firstQuality=(TOTAL_03/TOTAL_05);
			}
			
			double uptime=0;
			if(totalLength!=0){
				
				double totalTime=TOTAL_12+TOTAL_13+TOTAL_21;
				
				operatingTime=totalCalenderHr; //For 31 Days
				double UpTime_Cal=totalTime/operatingTime;
				double downTimePer=UpTime_Cal*100;
				uptime=CommonUtil.round(100-downTimePer, 2);
			}
			double effPercent=(paperYield*firstQuality*uptime);

			
			COL_19.setCellValue(CommonUtil.round(paperYield*100, 2));
			COL_20.setCellValue(CommonUtil.round(firstQuality*100, 2));
			
			COL_21.setCellValue(CommonUtil.round(uptime, 2));
			COL_22.setCellValue(CommonUtil.round(effPercent, 2));
			
			COL_23.setCellValue("Uncontrollable Included");
			COL_24.setCellValue("");
			COL_25.setCellValue("");
		}
		
		
		
		
		return workbook;
	}



	
	@Transactional
	@Override
	public List<Map<String, String>> formatDataForDailyReport(Date sdate, Date edate) throws ProductionException {
	
		
		
		
		List<Map<String, String>> datas=new ArrayList<>();
		
		

		//
		int days=Days.daysBetween(new DateTime(sdate.getTime()), new DateTime(edate.getTime())).getDays();
		double total=0;
		
		for(int i=0;i<days+1;i++){
			
		//	System.out.println(sdate);
			Calendar scal=CommonUtil.getStartDate(sdate);
			Calendar ecal=CommonUtil.getEndDate(sdate);
				
			
			
		//	System.out.println("Start Date:-"+scal.getTime());
		//	System.out.println("End Date:-"+ecal.getTime());
			
			Map<String, String> map=new HashMap<String, String>();
			double reelWeight=0;
			double machineSpeed=0;
			double rejectWeightMachine=0;
			List<String> gradeCodes=new ArrayList<>();
			//Machine Production
			List<MachineProductionPM5> machineProductions=machineProductionDao.getMachineProductions(scal.getTime(),ecal.getTime());
			for (MachineProductionPM5 machineProduction : machineProductions) {
				reelWeight+=machineProduction.getGoodWeight();
				rejectWeightMachine+=machineProduction.getRejectedWeight();
				if(machineProduction.getMachineSpeed()>machineSpeed){
					machineSpeed=machineProduction.getMachineSpeed();
				}
				
				if(!gradeCodes.contains(machineProduction.getGradeCode())){
					gradeCodes.add(machineProduction.getGradeCode());
				}
			}
			
			double whiteWeight=0;
			double redWeight=0;
			double rejectWeight=0;
			List<String> customers=new ArrayList<>();
			//Wrapper Production
			List<WrapperProductionPM5> wrapperProductions=wrapperProductionDao.getWrapperProductions(scal.getTime(),ecal.getTime());
			for (WrapperProductionPM5 wrapperProduction : wrapperProductions) {
				whiteWeight+=wrapperProduction.getWhiteWeight();
				redWeight+=wrapperProduction.getRedWeight();
				rejectWeight+=wrapperProduction.getRejectWeight();
				if(!customers.contains(wrapperProduction.getCustomer())){
					customers.add(wrapperProduction.getCustomer());
				}
				
			}
			whiteWeight=whiteWeight/2000;
			redWeight=redWeight/2000;
			
			double totalTons=whiteWeight+redWeight;
			total+=totalTons;
			
			double totalAvg=total/(i+1);
			
			double processLoss=reelWeight-totalTons;
			
			map.put(ColumnsOfTable.COL_01, dateFormat.format(sdate));
			map.put(ColumnsOfTable.COL_02, CommonUtil.round(reelWeight, 2)+"");
			map.put(ColumnsOfTable.COL_03, CommonUtil.round(whiteWeight, 2)+"");
			map.put(ColumnsOfTable.COL_04, CommonUtil.round(redWeight, 2)+"");
			map.put(ColumnsOfTable.COL_05, CommonUtil.round(totalTons, 2)+"");
			map.put(ColumnsOfTable.COL_06, CommonUtil.round(totalAvg, 2)+"");
			
			//For Wrapper
			map.put(ColumnsOfTable.COL_23, CommonUtil.round(rejectWeight/2000, 2)+"");
			
			//For Machine
			map.put(ColumnsOfTable.COL_24, CommonUtil.round(rejectWeightMachine, 2)+"");
			map.put(ColumnsOfTable.COL_25, CommonUtil.round((reelWeight-rejectWeightMachine),2)+"");
			
			
			
			map.put(ColumnsOfTable.COL_07, "0");
			
			
			map.put(ColumnsOfTable.COL_08, CommonUtil.round(processLoss, 2)+"");
			map.put(ColumnsOfTable.COL_09, CommonUtil.round(machineSpeed, 2)+"");
			
			int oldDownTime=0;
			int oldDayProcessTime=0;
			int oldNightProcessTime=0;
			int oldMachineDownTime=0;
			
			Date tempdate=null;
			try {
				tempdate=dateFormat.parse(dateFormat.format(scal.getTime()));
				if(tempdate!=null){
					List<MasterData> masterDatas=masterDataDao.getMasterDatas(tempdate, tempdate);
					for (MasterData masterData : masterDatas) {
						oldDownTime+=masterData.getDowntimeMin();
						oldDayProcessTime+=masterData.getDowntimeDayMin();
						oldNightProcessTime+=masterData.getDowntimeNightMin();
						oldMachineDownTime+=masterData.getMachineDowntimeMin();
					}
				}
				
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
			
			int toldOldDownTime=oldDayProcessTime+oldNightProcessTime+oldMachineDownTime;
			int diffValue=toldOldDownTime-oldDownTime;
			if(diffValue>0){
				oldDayProcessTime=oldDayProcessTime-diffValue;
			}else if(diffValue<0){
				oldDayProcessTime=oldDayProcessTime-(diffValue);
			}
			
			double dayProcessTime=0;
			double nightProcessTime=0;
			double machineDownTime=0;
			double restDownTime=0;		//Code Done By Roshan Tailor
			
			List<String> comments=new ArrayList<>();
			
			
			EfficiencyPM5 efficiency=new EfficiencyPM5();
			efficiency.setStartDate(scal.getTime());
			efficiency.setEndDate(ecal.getTime());
			
			if(oldDownTime==0){
				List<EfficiencyPM5> efficiencies=efficiencyDao.getEfficiencies(efficiency);
	  			
				for (EfficiencyPM5 eff : efficiencies) {
					PrimaryCodePM5 primaryCode=eff.getSecondaryCode().getPrimaryCode();
					if(primaryCode.getType()==1){
						//Process Down time
						if(eff.getShift().equalsIgnoreCase("Day")){
							dayProcessTime+=(CommonUtil.getHoursDuration(eff.getStartTime(), eff.getEndTime())*60+CommonUtil.getMinutesDuration(eff.getStartTime(), eff.getEndTime()));
						}else if(eff.getShift().equalsIgnoreCase("Night")){
							nightProcessTime+=(CommonUtil.getHoursDuration(eff.getStartTime(), eff.getEndTime())*60+CommonUtil.getMinutesDuration(eff.getStartTime(), eff.getEndTime()));
						}
					}else if(primaryCode.getType()==2){
						//Machine down time
						machineDownTime+=(CommonUtil.getHoursDuration(eff.getStartTime(), eff.getEndTime())*60+CommonUtil.getMinutesDuration(eff.getStartTime(), eff.getEndTime()));
					}
					//code Starts Form Here Done By Roshan Tailor
					else if(primaryCode.getType()==3){
						//Machine down time
						restDownTime+=(CommonUtil.getHoursDuration(eff.getStartTime(), eff.getEndTime())*60+CommonUtil.getMinutesDuration(eff.getStartTime(), eff.getEndTime()));
					}
					//Code Ends Here Done By Roshan Tailor
					
					if(!StringUtils.isEmpty(eff.getComment())){
						comments.add(eff.getComment());
					}
					
				}
			}
			
			
			double totalProcessDownTime=0;
			if(oldDownTime==0){
				totalProcessDownTime=dayProcessTime+nightProcessTime;
			}else{
				dayProcessTime=oldDayProcessTime;
				nightProcessTime=oldNightProcessTime;
				totalProcessDownTime=oldDayProcessTime+oldNightProcessTime;
				machineDownTime=oldMachineDownTime;
			}
			
			map.put(ColumnsOfTable.COL_10, CommonUtil.round(dayProcessTime, 2)+"");
			map.put(ColumnsOfTable.COL_11, CommonUtil.round(nightProcessTime, 2)+"");
			map.put(ColumnsOfTable.COL_12, CommonUtil.round(totalProcessDownTime, 2)+"");
			map.put(ColumnsOfTable.COL_13, CommonUtil.round(machineDownTime, 2)+"");
			
			map.put(ColumnsOfTable.COL_21, CommonUtil.round(restDownTime, 2)+""); //Code Done By Roshan Tailor
			map.put(ColumnsOfTable.COL_22, CommonUtil.round(24*60, 2)+"");//Code Done By Roshan Tailor, This Line Is Hard Cord To Show Mini(s) Of A Day. 
			
			double paperYield=0;
			if(reelWeight!=0){
				//paperYield=(totalTons/reelWeight);
				paperYield=(totalTons/(CommonUtil.round(reelWeight-rejectWeightMachine, 2)));
				
			}
			
			double firstQuality=0;
			if(totalTons!=0){
				firstQuality=(whiteWeight/totalTons);
			}
			
			//Old Formula
			//double uptime=((1440-(totalProcessDownTime+machineDownTime))/1440f);
			
			//New Formula
			//double uptime=((100-(totalProcessDownTime+machineDownTime)/(1440-restDownTime)))/100;
			
			double totalTime=totalProcessDownTime+machineDownTime;
			double operatingTime=1440-restDownTime;
			double UpTime_Cal=totalTime/operatingTime;
			
			double downTimePer=UpTime_Cal*100;
			
			double uptime=CommonUtil.round(100-downTimePer, 2);
			
			/*System.out.println("totalProcessDownTime:"+totalProcessDownTime);
			System.out.println("machineDownTime:"+machineDownTime);
			System.out.println("restDownTime:"+restDownTime);
			
			System.out.println("totalTime:"+totalTime);
			System.out.println("operatingTime:"+operatingTime);
			System.out.println("UpTime_Cal:"+UpTime_Cal);
			System.out.println("downTimePer:"+downTimePer);
			System.out.println("uptime:"+uptime);*/
			
			
			/*System.out.println("uptime::"+uptime);
			System.out.println("restDownTime:"+restDownTime);
			System.out.println("totalProcessDownTime::"+totalProcessDownTime);
			System.out.println("machineDownTime::"+machineDownTime);*/
			
			double effPercent=(paperYield*firstQuality*uptime);
			
			map.put(ColumnsOfTable.COL_14, CommonUtil.round(paperYield*100, 2)+"");
			map.put(ColumnsOfTable.COL_15, CommonUtil.round(firstQuality*100, 2)+"");
			
			//Old Formula Wise
			/*map.put(ColumnsOfTable.COL_16, CommonUtil.round(uptime*100, 2)+"");*/
			
			//New Formula Wise
			map.put(ColumnsOfTable.COL_16, CommonUtil.round(uptime, 2)+"");
			
			//Old Formula Wise
			/*map.put(ColumnsOfTable.COL_17, CommonUtil.round(effPercent*100, 2)+"");*/
			
			//New Formula Wise
			map.put(ColumnsOfTable.COL_17, CommonUtil.round(effPercent, 2)+"");
			
			String productCodes=StringUtils.join(gradeCodes, ",<br>");
			map.put(ColumnsOfTable.COL_18, productCodes);
			
			String customerNames=StringUtils.join(customers, ",<br>");
			map.put(ColumnsOfTable.COL_19, customerNames);
			
			String commentList=StringUtils.join(comments, ", ");
			map.put(ColumnsOfTable.COL_20, commentList);
			
			datas.add(map);
			
			sdate=ecal.getTime();
		}
		
		
		//System.out.println(datas);
		
		return datas;

	}


	/* (non-Javadoc)
	 * @see com.st.production.service.MachineProductionService#formatDataForSumaryReport(java.util.Date, java.util.Date)
	 */
	@Transactional
	@Override
	public Map<String, Object> formatDataForSumaryReport(Date sdate,
			Date edate,String shift) throws ProductionException {
		Map<String, Object> datas=new HashMap<String, Object>();
			
		Calendar scal=CommonUtil.getStartDate(sdate);
		Calendar ecal=CommonUtil.getEndDate(sdate);
		
		
		List<MachineProductionSummaryPM5> productionSummaries=new ArrayList<>();
	
		
		//Code Starts From Here Done By Roshan Tailor Date:-2015-11-23
		
		List<MachineProductionPM5> checkMachineProductionsForRollBreakData=machineProductionDao.checkMachineProductionsForRollBreak(scal.getTime(), ecal.getTime(),shift);
		
		List<MachineProductionPM5> machineProductionsForRollBreak=machineProductionDao.getMachineProductionsForRollBreak(scal.getTime(), ecal.getTime(),shift,checkMachineProductionsForRollBreakData.size());
		datas.put("machinerollbreakinfo", machineProductionsForRollBreak);
		//Code Ends Here Done By Roshan Tailor Date:-2015-11-23
				
		List<MachineProductionPM5> machineProductions=machineProductionDao.getMachineProductions(scal.getTime(), ecal.getTime(),shift);
		for (MachineProductionPM5 machineProduction : machineProductions) {
			MachineProductionSummaryPM5 productionSummary=getMachineProductionSummary(productionSummaries,machineProduction.getGradeCode());
			
			
			
			if(productionSummary==null){
				productionSummary=new MachineProductionSummaryPM5();
				
				if(machineProduction.getShift().equalsIgnoreCase("Day")){
					productionSummary.setDayWeight(machineProduction.getGoodWeight());
				}else if(machineProduction.getShift().equalsIgnoreCase("Night")){
					productionSummary.setNightWeight(machineProduction.getGoodWeight());
				}
				productionSummary.setRejected(machineProduction.getRejectedWeight());
				
				if(machineProduction.getRejectedWeight()>0){
					if(machineProduction.getComments()!=null && !machineProduction.getComments().equals("")){
							productionSummary.setComments(machineProduction.getComments());	
					}
				}
				productionSummary.setGradeCode(machineProduction.getGradeCode());
				
				productionSummaries.add(productionSummary);
			}else{
				
				if(machineProduction.getShift().equalsIgnoreCase("Day")){
					productionSummary.setDayWeight(productionSummary.getDayWeight()+machineProduction.getGoodWeight());
				}else if(machineProduction.getShift().equalsIgnoreCase("Night")){
					productionSummary.setNightWeight(productionSummary.getNightWeight()+machineProduction.getGoodWeight());
				}
				productionSummary.setRejected(productionSummary.getRejected()+machineProduction.getRejectedWeight());
				
				if(machineProduction.getRejectedWeight()>0){
					if(machineProduction.getComments()!=null && !machineProduction.getComments().equals("")){
						if(productionSummary.getComments().length()>0){
								productionSummary.setComments(productionSummary.getComments()+", "+machineProduction.getComments());	
						}else{
								productionSummary.setComments(machineProduction.getComments());	
						}
					}	
				}
			}
			
			//System.out.println(machineProduction.getShift());
			
			
		}
	
		datas.put("production", productionSummaries);
		
		
		
		WrapperProductionSummaryPM5 dayWrapperProduction=new WrapperProductionSummaryPM5();
		dayWrapperProduction.setShift("Day");
		WrapperProductionSummaryPM5 nightWrapperProduction=new WrapperProductionSummaryPM5();
		nightWrapperProduction.setShift("Night");
		
		Set<String> daysComment=new HashSet<>();
		Set<String> nightsComment=new HashSet<>();
		
		//Code Starts From Here Done By Roshan Tailor Date:-2015-11-17
		
		List<WrapperProductionPM5> checkBreaksData=wrapperProductionDao.checkBreaks(scal.getTime(), ecal.getTime(),shift);
		
		System.out.println(checkBreaksData.size());
		List<WrapperProductionPM5> wrapperProductionsForRollBreak=null;
		wrapperProductionsForRollBreak=wrapperProductionDao.getWrapperProductionsForRollBreak(scal.getTime(), ecal.getTime(),shift,checkBreaksData.size());
		 
		for(WrapperProductionPM5 data :wrapperProductionsForRollBreak){
			System.out.println("TYTYT::::"+data.getTotalrollsproduce());
		}
		datas.put("rollbreakinfo", wrapperProductionsForRollBreak);
		//Code Ends Here Done By Roshan Tailor Date:-2015-11-17
		System.out.println(scal.getTime()+"======="+ecal.getTime());
		List<WrapperProductionPM5> wrapperProductions=wrapperProductionDao.getWrapperProductions(scal.getTime(), ecal.getTime(),shift);
		for (WrapperProductionPM5 wrapperProduction : wrapperProductions) {
			if(wrapperProduction.getShift().equals("Day")){
				dayWrapperProduction.setWhiteWeight(dayWrapperProduction.getWhiteWeight()+wrapperProduction.getWhiteWeight());
				dayWrapperProduction.setRedWeight(dayWrapperProduction.getRedWeight()+wrapperProduction.getRedWeight());
				dayWrapperProduction.setRejectWeight(dayWrapperProduction.getRejectWeight()+wrapperProduction.getRejectWeight());
			
				
				if(wrapperProduction.getComment()!=null && wrapperProduction.getComment().length()>0){
					if(!daysComment.contains(wrapperProduction.getComment().trim()) && (wrapperProduction.getRedWeight()>0 ||wrapperProduction.getRejectWeight()>0)){
						daysComment.add(wrapperProduction.getComment());
					}
				}
				
			}else if(wrapperProduction.getShift().equals("Night")){
				nightWrapperProduction.setWhiteWeight(nightWrapperProduction.getWhiteWeight()+wrapperProduction.getWhiteWeight());
				nightWrapperProduction.setRedWeight(nightWrapperProduction.getRedWeight()+wrapperProduction.getRedWeight());
				nightWrapperProduction.setRejectWeight(nightWrapperProduction.getRejectWeight()+wrapperProduction.getRejectWeight());
				
				if(wrapperProduction.getComment()!=null && wrapperProduction.getComment().length()>0){
					if(!nightsComment.contains(wrapperProduction.getComment()) && (wrapperProduction.getRedWeight()>0 ||wrapperProduction.getRejectWeight()>0)){
						nightsComment.add(wrapperProduction.getComment());
					}
				}
			}
			
		}
		
		dayWrapperProduction.setWhiteWeight(CommonUtil.round(dayWrapperProduction.getWhiteWeight()/2000, 2));
		dayWrapperProduction.setRedWeight(CommonUtil.round(dayWrapperProduction.getRedWeight()/2000, 2));
		dayWrapperProduction.setRejectWeight(CommonUtil.round(dayWrapperProduction.getRejectWeight()/2000, 2));
		
		nightWrapperProduction.setWhiteWeight(CommonUtil.round(nightWrapperProduction.getWhiteWeight()/2000, 2));
		nightWrapperProduction.setRedWeight(CommonUtil.round(nightWrapperProduction.getRedWeight()/2000, 2));
		nightWrapperProduction.setRejectWeight(CommonUtil.round(nightWrapperProduction.getRejectWeight()/2000, 2));
		
		String[] dayComment=StringUtils.join(daysComment, ",").split(",");
		String[] nightComment=StringUtils.join(nightsComment, ",").split(",");
		
		dayWrapperProduction.setComment(StringUtils.join(new HashSet<String>(Arrays.asList(dayComment)), ","));
		nightWrapperProduction.setComment(StringUtils.join(new HashSet<String>(Arrays.asList(nightComment)), ","));
		
		datas.put("wrapDay", dayWrapperProduction);
		datas.put("wrapNigh", nightWrapperProduction);
		
		if(machineProductions.size()==0 && wrapperProductions.size()==0){
			datas.put("dataFlag", true);
		}else{
			datas.put("dataFlag", false);
		}
		
		
		
		Calendar scalMTD=Calendar.getInstance();
		scalMTD.setTime(CommonUtil.getFirstDate(scal.getTime()));
		scalMTD.set(Calendar.HOUR_OF_DAY, 6);
		scalMTD.set(Calendar.SECOND, 0);
		scalMTD.set(Calendar.MINUTE, 0);
		scalMTD.set(Calendar.MILLISECOND, 0);
		
		//System.out.println("SDATE="+scal.getTime()+"\t EDATE="+ecal.getTime());
		//System.out.println("SMTD="+scalMTD.getTime()+"\t EMTD="+ecal.getTime());
		
		MachineProductionSummaryPM5 mpMTD=new MachineProductionSummaryPM5();
		double dayMpDay=0;
		double nightMpDay=0;
		double mpReject=0;
		List<MachineProductionPM5> machineProductionsMTD=machineProductionDao.getMachineProductions(scalMTD.getTime(), ecal.getTime(),"");
		for (MachineProductionPM5 machineProduction : machineProductionsMTD) {
			
			if(machineProduction.getShift().equalsIgnoreCase("Day")){
				dayMpDay+=machineProduction.getGoodWeight();
			}else if(machineProduction.getShift().equalsIgnoreCase("Night")){
				nightMpDay+=machineProduction.getGoodWeight();
			}
			mpReject+=machineProduction.getRejectedWeight();
		}
		mpMTD.setDayWeight(dayMpDay);
		mpMTD.setNightWeight(nightMpDay);
		mpMTD.setRejected(mpReject);
		
		datas.put("mpMTD", mpMTD);
		
		
		WrapperProductionSummaryPM5 wpMTD=new WrapperProductionSummaryPM5();
		System.out.println(scalMTD.getTime()+"---"+ ecal.getTime());
		List<WrapperProductionPM5> wrapperProductionsMTD=wrapperProductionDao.getWrapperProductions(scalMTD.getTime(), ecal.getTime(),"");
		double wrWhite=0;
		double wrRed=0;
		double wrReject=0;
		for (WrapperProductionPM5 wrapperProduction : wrapperProductionsMTD) {
			wrWhite+=wrapperProduction.getWhiteWeight();
			wrRed+=wrapperProduction.getRedWeight();
			wrReject+=wrapperProduction.getRejectWeight();
		}
		wpMTD.setWhiteWeight(CommonUtil.round(wrWhite/2000, 2));
		wpMTD.setRedWeight(CommonUtil.round(wrRed/2000, 2));
		wpMTD.setRejectWeight(CommonUtil.round(wrReject/2000, 2));
		datas.put("wpMTD", wpMTD);
		return datas;
	}


	/**
	 * @param productionSummaries
	 * @param gradeCode
	 * @return
	 */
	private MachineProductionSummaryPM5 getMachineProductionSummary(
			List<MachineProductionSummaryPM5> productionSummaries, String gradeCode) {
		MachineProductionSummaryPM5 productionSummary=null;
		for (MachineProductionSummaryPM5 machineProductionSummary : productionSummaries) {
			if(machineProductionSummary.getGradeCode()!=null){
				if(machineProductionSummary.getGradeCode().equals(gradeCode)){
					productionSummary=machineProductionSummary;
					break;
				}
			}
			
		}
		return productionSummary;
	}


	
	@Override
	public HSSFWorkbook getFormatedWorkbookForSummaryReport(File file,Map<String, Object> datas,Date date) throws IOException {

		
		
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
		objectCellStyle.setFont(objectFont);
		objectCellStyle.setWrapText(true);
		
	
		HSSFSheet sheet=workbook.getSheetAt(0);
		
		@SuppressWarnings("unchecked")
		List<MachineProductionSummaryPM5> productionSummaries=(List<MachineProductionSummaryPM5>)datas.get("production");
		MachineProductionSummaryPM5 mpMTD=(MachineProductionSummaryPM5) datas.get("mpMTD");
		
		
		
		
		WrapperProductionSummaryPM5 dayWrap=(WrapperProductionSummaryPM5) datas.get("wrapDay");
		WrapperProductionSummaryPM5 nightWrap=(WrapperProductionSummaryPM5) datas.get("wrapNigh");
		WrapperProductionSummaryPM5 wpMTD=(WrapperProductionSummaryPM5) datas.get("wpMTD");
		
		sheet.getRow(0).getCell(0).setCellValue("PM6 Machine Production - "+dateFormat.format(date));
		sheet.getRow(3).getCell(0).setCellValue("PM6 Wrapped Production - "+dateFormat.format(date));			
		sheet.shiftRows(2, sheet.getLastRowNum(), productionSummaries.size()+2);
		
		int rowCount=2;
		
		double dayTotal=0;
		double nightTotal=0;
		double total=0;
		double rejectedTotal=0;
		
		for (MachineProductionSummaryPM5 machineProductionSummary : productionSummaries) {
			HSSFRow row=sheet.createRow(rowCount++);
			
			HSSFCell cell01=row.createCell(Columns.COL_00);
			HSSFCell cell02=row.createCell(Columns.COL_01);
			HSSFCell cell03=row.createCell(Columns.COL_02);
			HSSFCell cell04=row.createCell(Columns.COL_03);
			HSSFCell cell05=row.createCell(Columns.COL_04);
			HSSFCell cell06=row.createCell(Columns.COL_05);
			HSSFCell cell07=row.createCell(Columns.COL_06);


			cell01.setCellStyle(rowCellStyle);
			cell02.setCellStyle(rowCellStyle);
			cell03.setCellStyle(rowCellStyle);
			cell04.setCellStyle(rowCellStyle);
			cell05.setCellStyle(rowCellStyle);
			cell06.setCellStyle(rowCellStyle);
			cell07.setCellStyle(rowCellStyle);
			
			
			if(rowCount==3){
				cell01.setCellValue(dateFormat.format(date));
			}else{
				cell01.setCellValue("");
			}
			
			cell02.setCellValue(machineProductionSummary.getGradeCode());
			cell03.setCellValue(CommonUtil.round(machineProductionSummary.getDayWeight(), 2));
			cell04.setCellValue(CommonUtil.round(machineProductionSummary.getNightWeight(), 2));
			cell05.setCellValue(CommonUtil.round((machineProductionSummary.getNightWeight()+machineProductionSummary.getDayWeight()), 2));
			cell06.setCellValue(CommonUtil.round(machineProductionSummary.getRejected(), 2));
			cell07.setCellValue(machineProductionSummary.getComments()==null?"":machineProductionSummary.getComments());
		
			dayTotal+=machineProductionSummary.getDayWeight();
			nightTotal+=machineProductionSummary.getNightWeight();
			total+=machineProductionSummary.getNightWeight()+machineProductionSummary.getDayWeight();
			rejectedTotal+=machineProductionSummary.getRejected();
			
		}
		{
			HSSFRow row=sheet.createRow(rowCount++);
			row.setHeight((short)280);
			
			HSSFCell cell01=row.createCell(Columns.COL_00);
			HSSFCell cell02=row.createCell(Columns.COL_01);
			HSSFCell cell03=row.createCell(Columns.COL_02);
			HSSFCell cell04=row.createCell(Columns.COL_03);
			HSSFCell cell05=row.createCell(Columns.COL_04);
			HSSFCell cell06=row.createCell(Columns.COL_05);
			HSSFCell cell07=row.createCell(Columns.COL_06);


			cell01.setCellStyle(objectCellStyle);
			cell02.setCellStyle(objectCellStyle);
			cell03.setCellStyle(objectCellStyle);
			cell04.setCellStyle(objectCellStyle);
			cell05.setCellStyle(objectCellStyle);
			cell06.setCellStyle(objectCellStyle);
			cell07.setCellStyle(objectCellStyle);
			
			
			cell01.setCellValue("");
			
			cell02.setCellValue("Total");
			cell03.setCellValue(CommonUtil.round(dayTotal, 2));
			cell04.setCellValue(CommonUtil.round(nightTotal, 2));
			cell05.setCellValue(CommonUtil.round(total, 2));
			cell06.setCellValue(CommonUtil.round(rejectedTotal, 2));
			cell07.setCellValue("");
		
		}
		
		{
			HSSFRow row=sheet.createRow(rowCount++);
			row.setHeight((short)280);
			
			HSSFCell cell01=row.createCell(Columns.COL_00);
			HSSFCell cell02=row.createCell(Columns.COL_01);
			HSSFCell cell03=row.createCell(Columns.COL_02);
			HSSFCell cell04=row.createCell(Columns.COL_03);
			HSSFCell cell05=row.createCell(Columns.COL_04);
			HSSFCell cell06=row.createCell(Columns.COL_05);
			HSSFCell cell07=row.createCell(Columns.COL_06);


			cell01.setCellStyle(objectCellStyle);
			cell02.setCellStyle(objectCellStyle);
			cell03.setCellStyle(objectCellStyle);
			cell04.setCellStyle(objectCellStyle);
			cell05.setCellStyle(objectCellStyle);
			cell06.setCellStyle(objectCellStyle);
			cell07.setCellStyle(objectCellStyle);
			
			
			cell01.setCellValue("");
			
			cell02.setCellValue("MTD");
			cell03.setCellValue(CommonUtil.round(mpMTD.getDayWeight(), 2));
			cell04.setCellValue(CommonUtil.round(mpMTD.getNightWeight(), 2));
			cell05.setCellValue(CommonUtil.round(mpMTD.getDayWeight()+mpMTD.getNightWeight(), 2));
			cell06.setCellValue(CommonUtil.round(mpMTD.getRejected(), 2));
			cell07.setCellValue("");
		
		}
		
		
		rowCount=rowCount+4;
		
		{
			HSSFRow row=sheet.createRow(rowCount++);
			row.setHeight((short)280);
			
			HSSFCell cell01=row.createCell(Columns.COL_00);
			HSSFCell cell02=row.createCell(Columns.COL_01);
			HSSFCell cell03=row.createCell(Columns.COL_02);
			HSSFCell cell04=row.createCell(Columns.COL_03);
			HSSFCell cell05=row.createCell(Columns.COL_04);
			HSSFCell cell06=row.createCell(Columns.COL_05);
			HSSFCell cell07=row.createCell(Columns.COL_06);


			cell01.setCellStyle(rowCellStyle);
			cell02.setCellStyle(rowCellStyle);
			cell03.setCellStyle(rowCellStyle);
			cell04.setCellStyle(rowCellStyle);
			cell05.setCellStyle(rowCellStyle);
			cell06.setCellStyle(rowCellStyle);
			cell07.setCellStyle(rowCellStyle);
			
			cell01.setCellValue(dateFormat.format(date));
			cell02.setCellValue(dayWrap.getShift());
			cell03.setCellValue(dayWrap.getWhiteWeight());
			cell04.setCellValue(dayWrap.getRedWeight());
			cell05.setCellValue((dayWrap.getWhiteWeight()+dayWrap.getRedWeight()));
			cell06.setCellValue(dayWrap.getRejectWeight());
			cell07.setCellValue(dayWrap.getComment());
			
		
		}
		{
			HSSFRow row=sheet.createRow(rowCount++);
			row.setHeight((short)280);
			
			HSSFCell cell01=row.createCell(Columns.COL_00);
			HSSFCell cell02=row.createCell(Columns.COL_01);
			HSSFCell cell03=row.createCell(Columns.COL_02);
			HSSFCell cell04=row.createCell(Columns.COL_03);
			HSSFCell cell05=row.createCell(Columns.COL_04);
			HSSFCell cell06=row.createCell(Columns.COL_05);
			HSSFCell cell07=row.createCell(Columns.COL_06);


			cell01.setCellStyle(rowCellStyle);
			cell02.setCellStyle(rowCellStyle);
			cell03.setCellStyle(rowCellStyle);
			cell04.setCellStyle(rowCellStyle);
			cell05.setCellStyle(rowCellStyle);
			cell06.setCellStyle(rowCellStyle);
			cell07.setCellStyle(rowCellStyle);
			
			cell01.setCellValue("");
			cell02.setCellValue(nightWrap.getShift());
			cell03.setCellValue(nightWrap.getWhiteWeight());
			cell04.setCellValue(nightWrap.getRedWeight());
			cell05.setCellValue((nightWrap.getWhiteWeight()+nightWrap.getRedWeight()));
			cell06.setCellValue(nightWrap.getRejectWeight());
			cell07.setCellValue(nightWrap.getComment());
			
		
		}
		{
			HSSFRow row=sheet.createRow(rowCount++);
			row.setHeight((short)280);
			
			HSSFCell cell01=row.createCell(Columns.COL_00);
			HSSFCell cell02=row.createCell(Columns.COL_01);
			HSSFCell cell03=row.createCell(Columns.COL_02);
			HSSFCell cell04=row.createCell(Columns.COL_03);
			HSSFCell cell05=row.createCell(Columns.COL_04);
			HSSFCell cell06=row.createCell(Columns.COL_05);
			HSSFCell cell07=row.createCell(Columns.COL_06);


			cell01.setCellStyle(objectCellStyle);
			cell02.setCellStyle(objectCellStyle);
			cell03.setCellStyle(objectCellStyle);
			cell04.setCellStyle(objectCellStyle);
			cell05.setCellStyle(objectCellStyle);
			cell06.setCellStyle(objectCellStyle);
			cell07.setCellStyle(objectCellStyle);
			
			cell01.setCellValue("");
			cell02.setCellValue("Total");
			cell03.setCellValue(CommonUtil.round(nightWrap.getWhiteWeight()+dayWrap.getWhiteWeight(), 2));
			cell04.setCellValue(CommonUtil.round(nightWrap.getRedWeight()+dayWrap.getRedWeight(), 2));
			cell05.setCellValue(CommonUtil.round(nightWrap.getWhiteWeight()+nightWrap.getRedWeight()+dayWrap.getWhiteWeight()+dayWrap.getRedWeight(), 2));
			cell06.setCellValue(CommonUtil.round(nightWrap.getRejectWeight()+dayWrap.getRejectWeight(), 2));
			cell07.setCellValue("");
			
		
		}
		
		{
			
			
			HSSFRow row=sheet.createRow(rowCount++);
			row.setHeight((short)280);
			
			HSSFCell cell01=row.createCell(Columns.COL_00);
			HSSFCell cell02=row.createCell(Columns.COL_01);
			HSSFCell cell03=row.createCell(Columns.COL_02);
			HSSFCell cell04=row.createCell(Columns.COL_03);
			HSSFCell cell05=row.createCell(Columns.COL_04);
			HSSFCell cell06=row.createCell(Columns.COL_05);
			HSSFCell cell07=row.createCell(Columns.COL_06);


			cell01.setCellStyle(objectCellStyle);
			cell02.setCellStyle(objectCellStyle);
			cell03.setCellStyle(objectCellStyle);
			cell04.setCellStyle(objectCellStyle);
			cell05.setCellStyle(objectCellStyle);
			cell06.setCellStyle(objectCellStyle);
			cell07.setCellStyle(objectCellStyle);
			
			cell01.setCellValue("");
			cell02.setCellValue("MTD");
			cell03.setCellValue(CommonUtil.round(wpMTD.getWhiteWeight(), 2));
			cell04.setCellValue(CommonUtil.round(wpMTD.getRedWeight(), 2));
			cell05.setCellValue(CommonUtil.round(wpMTD.getWhiteWeight()+wpMTD.getRedWeight(), 2));
			cell06.setCellValue(CommonUtil.round(wpMTD.getRejectWeight(), 2));
			cell07.setCellValue("");
			
		
		}
		
		return workbook;
	}


	/* (non-Javadoc)
	 * @see com.st.production.service.MachineProductionService#getGradeAndHourData(java.util.Date, java.util.Date)
	 */
	@Transactional
	@Override
	public List<Map<String, Object>> getGradeAndHourData(Date sdate, Date edate) throws ProductionException {
		return machineProductionDao.getGradeAndHourData(sdate,edate);
	}


	/* (non-Javadoc)
	 * @see com.st.production.service.MachineProductionService#getMachineAndWrapper(java.util.Date, java.util.Date)
	 */
	@Transactional
	@Override
	public List<MachineAndWrapperPM5> getMachineAndWrapper(Date sdate, Date edate) throws ProductionException {
		return machineProductionDao.getMachineAndWrapper(sdate,edate);
	}


	/* (non-Javadoc)
	 * @see com.st.production.service.MachineProductionService#formatDataForDailyReportNonControlableHours(java.util.Date, java.util.Date)
	 */
	@Transactional
	@Override
	public List<Map<String, String>> formatDataForDailyReportNonControlableHours(
			Date sdate, Date edate) throws ProductionException {
	
		
		
		
		List<Map<String, String>> datas=new ArrayList<>();
		
		

		//
		int days=Days.daysBetween(new DateTime(sdate.getTime()), new DateTime(edate.getTime())).getDays();
		double total=0;
		
		for(int i=0;i<days+1;i++){
			
		//	System.out.println(sdate);
			
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
			
			
			
		//	System.out.println("Start Date:-"+scal.getTime());
		//	System.out.println("End Date:-"+ecal.getTime());
			
			Map<String, String> map=new HashMap<String, String>();
			double reelWeight=0;
			double machineSpeed=0;
			List<String> gradeCodes=new ArrayList<>();
			//Machine Production
			List<MachineProductionPM5> machineProductions=machineProductionDao.getMachineProductions(scal.getTime(),ecal.getTime());
			for (MachineProductionPM5 machineProduction : machineProductions) {
				reelWeight+=machineProduction.getGoodWeight();
				if(machineProduction.getMachineSpeed()>machineSpeed){
					machineSpeed=machineProduction.getMachineSpeed();
				}
				
				if(!gradeCodes.contains(machineProduction.getGradeCode())){
					gradeCodes.add(machineProduction.getGradeCode());
				}
			}
			
			double whiteWeight=0;
			double redWeight=0;
			List<String> customers=new ArrayList<>();
			//Wrapper Production
			List<WrapperProductionPM5> wrapperProductions=wrapperProductionDao.getWrapperProductions(scal.getTime(),ecal.getTime());
			for (WrapperProductionPM5 wrapperProduction : wrapperProductions) {
				whiteWeight+=wrapperProduction.getWhiteWeight();
				redWeight+=wrapperProduction.getRedWeight();
				if(!customers.contains(wrapperProduction.getCustomer())){
					customers.add(wrapperProduction.getCustomer());
				}
				
			}
			whiteWeight=whiteWeight/2000;
			redWeight=redWeight/2000;
			
			double totalTons=whiteWeight+redWeight;
			total+=totalTons;
			
			double totalAvg=total/(i+1);
			
			double processLoss=reelWeight-totalTons;
			
			map.put(ColumnsOfTable.COL_01, dateFormat.format(sdate));
			map.put(ColumnsOfTable.COL_02, CommonUtil.round(reelWeight, 2)+"");
			map.put(ColumnsOfTable.COL_03, CommonUtil.round(whiteWeight, 2)+"");
			map.put(ColumnsOfTable.COL_04, CommonUtil.round(redWeight, 2)+"");
			map.put(ColumnsOfTable.COL_05, CommonUtil.round(totalTons, 2)+"");
			map.put(ColumnsOfTable.COL_06, CommonUtil.round(totalAvg, 2)+"");
			
			
			
			map.put(ColumnsOfTable.COL_07, "0");
			
			
			map.put(ColumnsOfTable.COL_08, CommonUtil.round(processLoss, 2)+"");
			map.put(ColumnsOfTable.COL_09, CommonUtil.round(machineSpeed, 2)+"");
			
			int oldDownTime=0;
			int oldDayProcessTime=0;
			int oldNightProcessTime=0;
			int oldMachineDownTime=0;
			
			Date tempdate=null;
			try {
				tempdate=dateFormat.parse(dateFormat.format(scal.getTime()));
				if(tempdate!=null){
					List<MasterData> masterDatas=masterDataDao.getMasterDatas(tempdate, tempdate);
					for (MasterData masterData : masterDatas) {
						oldDownTime+=masterData.getDowntimeMin();
						oldDayProcessTime+=masterData.getDowntimeDayMin();
						oldNightProcessTime+=masterData.getDowntimeNightMin();
						oldMachineDownTime+=masterData.getMachineDowntimeMin();
					}
				}
				
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
			
			int toldOldDownTime=oldDayProcessTime+oldNightProcessTime+oldMachineDownTime;
			int diffValue=toldOldDownTime-oldDownTime;
			if(diffValue>0){
				oldDayProcessTime=oldDayProcessTime-diffValue;
			}else if(diffValue<0){
				oldDayProcessTime=oldDayProcessTime-(diffValue);
			}
			
			double dayProcessTime=0;
			double nightProcessTime=0;
			double machineDownTime=0;
			double restDownTime=0;		//Code Done By Roshan Tailor
			
			List<String> comments=new ArrayList<>();
			
			
			EfficiencyPM5 efficiency=new EfficiencyPM5();
			efficiency.setStartDate(scal.getTime());
			efficiency.setEndDate(ecal.getTime());
			
			if(oldDownTime==0){
				List<EfficiencyPM5> efficiencies=efficiencyDao.getEfficiencies(efficiency);
	  			
				for (EfficiencyPM5 eff : efficiencies) {
					PrimaryCodePM5 primaryCode=eff.getSecondaryCode().getPrimaryCode();
					if(primaryCode.getType()==1){
						//Process Down time
						if(eff.getShift().equalsIgnoreCase("Day")){
							dayProcessTime+=(CommonUtil.getHoursDuration(eff.getStartTime(), eff.getEndTime())*60+CommonUtil.getMinutesDuration(eff.getStartTime(), eff.getEndTime()));
						}else if(eff.getShift().equalsIgnoreCase("Night")){
							nightProcessTime+=(CommonUtil.getHoursDuration(eff.getStartTime(), eff.getEndTime())*60+CommonUtil.getMinutesDuration(eff.getStartTime(), eff.getEndTime()));
						}
					}else if(primaryCode.getType()==2){
						//Machine down time
						machineDownTime+=(CommonUtil.getHoursDuration(eff.getStartTime(), eff.getEndTime())*60+CommonUtil.getMinutesDuration(eff.getStartTime(), eff.getEndTime()));
					}
					//code Starts Form Here Done By Roshan Tailor
					else if(primaryCode.getType()==3){
						//Machine down time
						restDownTime+=(CommonUtil.getHoursDuration(eff.getStartTime(), eff.getEndTime())*60+CommonUtil.getMinutesDuration(eff.getStartTime(), eff.getEndTime()));
					}
					//Code Ends Here Done By Roshan Tailor
					
					if(!StringUtils.isEmpty(eff.getComment())){
						comments.add(eff.getComment());
					}
					
				}
			}
			
			
			double totalProcessDownTime=0;
			if(oldDownTime==0){
				totalProcessDownTime=dayProcessTime+nightProcessTime;
			}else{
				dayProcessTime=oldDayProcessTime;
				nightProcessTime=oldNightProcessTime;
				totalProcessDownTime=oldDayProcessTime+oldNightProcessTime;
				machineDownTime=oldMachineDownTime;
			}
			
			map.put(ColumnsOfTable.COL_10, CommonUtil.round(dayProcessTime, 2)+"");
			map.put(ColumnsOfTable.COL_11, CommonUtil.round(nightProcessTime, 2)+"");
			map.put(ColumnsOfTable.COL_12, CommonUtil.round(totalProcessDownTime, 2)+"");
			map.put(ColumnsOfTable.COL_13, CommonUtil.round(machineDownTime, 2)+"");
			
			map.put(ColumnsOfTable.COL_21, CommonUtil.round(restDownTime, 2)+""); //Code Done By Roshan Tailor
			map.put(ColumnsOfTable.COL_22, CommonUtil.round(24*60, 2)+"");//Code Done By Roshan Tailor, This Line Is Hard Cord To Show Mini(s) Of A Day. 
			
			double paperYield=0;
			if(reelWeight!=0){
				paperYield=(totalTons/reelWeight);
			}
			
			double firstQuality=0;
			if(totalTons!=0){
				firstQuality=(whiteWeight/totalTons);
			}
			
			//Old Formula
			//double uptime=((1440-(totalProcessDownTime+machineDownTime))/1440f);
			
			//New Formula
			//double uptime=((100-(totalProcessDownTime+machineDownTime)/(1440-restDownTime)))/100;
			
			double totalTime=totalProcessDownTime+machineDownTime+restDownTime;
			double operatingTime=1440;
			double UpTime_Cal=totalTime/operatingTime;
			
			double downTimePer=UpTime_Cal*100;
			
			double uptime=CommonUtil.round(100-downTimePer, 2);
			
			System.out.println("totalProcessDownTime:"+totalProcessDownTime);
			System.out.println("machineDownTime:"+machineDownTime);
			System.out.println("restDownTime:"+restDownTime);
			
			System.out.println("totalTime:"+totalTime);
			System.out.println("operatingTime:"+operatingTime);
			System.out.println("UpTime_Cal:"+UpTime_Cal);
			System.out.println("downTimePer:"+downTimePer);
			System.out.println("uptime:"+uptime);
			
			
			/*System.out.println("uptime::"+uptime);
			System.out.println("restDownTime:"+restDownTime);
			System.out.println("totalProcessDownTime::"+totalProcessDownTime);
			System.out.println("machineDownTime::"+machineDownTime);*/
			
			double effPercent=(paperYield*firstQuality*uptime);
			
			map.put(ColumnsOfTable.COL_14, CommonUtil.round(paperYield*100, 2)+"");
			map.put(ColumnsOfTable.COL_15, CommonUtil.round(firstQuality*100, 2)+"");
			
			//Old Formula Wise
			/*map.put(ColumnsOfTable.COL_16, CommonUtil.round(uptime*100, 2)+"");*/
			
			//New Formula Wise
			map.put(ColumnsOfTable.COL_16, CommonUtil.round(uptime, 2)+"");
			
			//Old Formula Wise
			/*map.put(ColumnsOfTable.COL_17, CommonUtil.round(effPercent*100, 2)+"");*/
			
			//New Formula Wise
			map.put(ColumnsOfTable.COL_17, CommonUtil.round(effPercent, 2)+"");
			
			String productCodes=StringUtils.join(gradeCodes, ",<br>");
			map.put(ColumnsOfTable.COL_18, productCodes);
			
			String customerNames=StringUtils.join(customers, ",<br>");
			map.put(ColumnsOfTable.COL_19, customerNames);
			
			String commentList=StringUtils.join(comments, ", ");
			map.put(ColumnsOfTable.COL_20, commentList);
			
			datas.add(map);
			
			sdate=ecal.getTime();
		}
		
		
		//System.out.println(datas);
		
		return datas;

	}


	/* (non-Javadoc)
	 * @see com.st.production.service.MachineProductionService#getFormatedWorkbookForDailyReportNonControlableHours(java.io.File, java.util.List, java.util.Date, java.util.Date)
	 */
	@Override
	public HSSFWorkbook getFormatedWorkbookForDailyReportNonControlableHours(
			File file, List<Map<String, String>> datas, Date sdate, Date edate) throws IOException {
		
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
		
		HSSFSheet sheet=workbook.getSheetAt(0);
	
		
		
		
		sheet.getRow(0).getCell(0).setCellValue("PM6 Production Non-Controlable Hours Report For - "+dateFormat1.format(sdate)+"-"+dateFormat1.format(edate));
		
		int rowCount=2;
		
	//	double TOTAL_01=0;
		double TOTAL_02=0;
		double TOTAL_03=0;
		double TOTAL_04=0;
		double TOTAL_05=0;
		@SuppressWarnings("unused")
		double TOTAL_06=0;
		double TOTAL_07=0;
		double TOTAL_08=0;
		double TOTAL_09=0;
		double TOTAL_10=0;
		double TOTAL_11=0;
		double TOTAL_12=0;
		double TOTAL_13=0;
		
		double TOTAL_22=0;//Code By Roshan Tailor
		double TOTAL_21=0;//Code By Roshan Tailor
		double TOTAL_23=0;//Code By Roshan Tailor For Un-Controlled Down Time
		
	//	double TOTAL_14=0;
	//	double TOTAL_15=0;
	//	double TOTAL_16=0;
	//	double TOTAL_17=0;
	//	double TOTAL_18=0;
	//	double TOTAL_19=0;
	//	double TOTAL_20=0;
		
		int totalLength=datas.size();
		
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
			TOTAL_10+=NumberUtils.toDouble(map.get(ColumnsOfTable.COL_10), 0);
			
			HSSFCell COL_11=row.createCell(Columns.COL_10);
			COL_11.setCellStyle(rowCellStyle);
			COL_11.setCellValue(NumberUtils.toDouble(map.get(ColumnsOfTable.COL_11), 0));
			TOTAL_11+=NumberUtils.toDouble(map.get(ColumnsOfTable.COL_11), 0);
			
			HSSFCell COL_12=row.createCell(Columns.COL_11);
			COL_12.setCellStyle(rowCellStyle);
			COL_12.setCellValue(NumberUtils.toDouble(map.get(ColumnsOfTable.COL_12), 0));
			TOTAL_12+=NumberUtils.toDouble(map.get(ColumnsOfTable.COL_12), 0);
			
			HSSFCell COL_13=row.createCell(Columns.COL_12);
			COL_13.setCellStyle(rowCellStyle);
			COL_13.setCellValue(NumberUtils.toDouble(map.get(ColumnsOfTable.COL_13), 0));
			TOTAL_13+=NumberUtils.toDouble(map.get(ColumnsOfTable.COL_13), 0);
			
			//Code Starts From Here Done By Roshan
			HSSFCell COL_22=row.createCell(Columns.COL_13);
			COL_22.setCellStyle(rowCellStyle);
			COL_22.setCellValue(NumberUtils.toDouble(map.get(ColumnsOfTable.COL_22), 0));
			//TOTAL_22+=NumberUtils.toDouble(map.get(ColumnsOfTable.COL_22), 0);
			
			HSSFCell COL_21=row.createCell(Columns.COL_14);
			COL_21.setCellStyle(rowCellStyle);
			COL_21.setCellValue(NumberUtils.toDouble(map.get(ColumnsOfTable.COL_21), 0));
			TOTAL_21+=NumberUtils.toDouble(map.get(ColumnsOfTable.COL_21), 0);
			
			//Code Ends Here Done By Roshan Tailor
			
			HSSFCell COL_14=row.createCell(Columns.COL_15);
			COL_14.setCellStyle(rowCellStyle);
			COL_14.setCellValue(NumberUtils.toDouble(map.get(ColumnsOfTable.COL_14), 0));
		//	TOTAL_14+=NumberUtils.toDouble(map.get(ColumnsOfTable.COL_14), 0);
			
			HSSFCell COL_15=row.createCell(Columns.COL_16);
			COL_15.setCellStyle(rowCellStyle);
			COL_15.setCellValue(NumberUtils.toDouble(map.get(ColumnsOfTable.COL_15), 0));
		//	TOTAL_15+=NumberUtils.toDouble(map.get(ColumnsOfTable.COL_15), 0);
			
			HSSFCell COL_16=row.createCell(Columns.COL_17);
			COL_16.setCellStyle(rowCellStyle);
			COL_16.setCellValue(NumberUtils.toDouble(map.get(ColumnsOfTable.COL_16), 0));
		//	TOTAL_16+=NumberUtils.toDouble(map.get(ColumnsOfTable.COL_16), 0);
			
			HSSFCell COL_17=row.createCell(Columns.COL_18);
			COL_17.setCellStyle(rowCellStyle);
			COL_17.setCellValue(NumberUtils.toDouble(map.get(ColumnsOfTable.COL_17), 0));
		//	TOTAL_17+=NumberUtils.toDouble(map.get(ColumnsOfTable.COL_17), 0);
			
			HSSFCell COL_18=row.createCell(Columns.COL_19);
			COL_18.setCellStyle(rowCellStyle);
			String productCode=map.get(ColumnsOfTable.COL_18);
			COL_18.setCellValue(productCode==null?"":productCode.replace("<br>", ""));
			
			HSSFCell COL_19=row.createCell(Columns.COL_20);
			COL_19.setCellStyle(rowCellStyle);
			String customer=map.get(ColumnsOfTable.COL_19);
			COL_19.setCellValue(customer==null?"":customer.replace("<br>", ""));
			
			HSSFCell COL_20=row.createCell(Columns.COL_21);
			COL_20.setCellStyle(rowCellStyle);
			COL_20.setCellValue(map.get(ColumnsOfTable.COL_20)==null?"":map.get(ColumnsOfTable.COL_20));
			
			
			
			
		}
		
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
			HSSFCell COL_11=row.createCell(Columns.COL_10);
			HSSFCell COL_12=row.createCell(Columns.COL_11);
			HSSFCell COL_13=row.createCell(Columns.COL_12);
			HSSFCell COL_14=row.createCell(Columns.COL_13);
			HSSFCell COL_15=row.createCell(Columns.COL_14);//Code By Roshan Tailor
			HSSFCell COL_16=row.createCell(Columns.COL_15);//Code By Roshan Tailor
			HSSFCell COL_17=row.createCell(Columns.COL_16);
			HSSFCell COL_18=row.createCell(Columns.COL_17);
			HSSFCell COL_19=row.createCell(Columns.COL_18);
			HSSFCell COL_20=row.createCell(Columns.COL_19);
			HSSFCell COL_21=row.createCell(Columns.COL_20);
			HSSFCell COL_22=row.createCell(Columns.COL_21);
			


			
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
			COL_11.setCellStyle(objectCellStyle);
			COL_12.setCellStyle(objectCellStyle);
			COL_13.setCellStyle(objectCellStyle);
			COL_14.setCellStyle(objectCellStyle);
			COL_15.setCellStyle(objectCellStyle);
			COL_16.setCellStyle(objectCellStyle);
			COL_17.setCellStyle(objectCellStyle);
			COL_18.setCellStyle(objectCellStyle);
			COL_19.setCellStyle(objectCellStyle);
			COL_20.setCellStyle(objectCellStyle);
			
			COL_21.setCellStyle(objectCellStyle);//Code By Roshan tailor
			COL_22.setCellStyle(objectCellStyle);//Code By Roshan Tailor
			
			
			COL_01.setCellValue("Total");
			COL_02.setCellValue(TOTAL_02);	//Reel Ton
			COL_03.setCellValue(TOTAL_03);  //White Ton
			COL_04.setCellValue(TOTAL_04);  //
			COL_05.setCellValue(TOTAL_05);	//Total Ton
			COL_06.setCellValue(CommonUtil.round(TOTAL_05/totalLength, 2));
			COL_07.setCellValue(TOTAL_07);
			COL_08.setCellValue(TOTAL_08);
			COL_09.setCellValue(CommonUtil.round(TOTAL_09/totalLength, 2));
			COL_10.setCellValue(TOTAL_10);
			COL_11.setCellValue(TOTAL_11);
			COL_12.setCellValue(TOTAL_12);	//Porcess Downtime
			COL_13.setCellValue(TOTAL_13);	//Machine Downtime
			COL_14.setCellValue("");
			COL_15.setCellValue(TOTAL_21);
			
			double paperYield=0;
			if(TOTAL_02!=0){
				paperYield=(TOTAL_05/TOTAL_02);
			}
			double firstQuality=0;
			if(TOTAL_05!=0){
				firstQuality=(TOTAL_03/TOTAL_05);
			}
			
			double uptime=0;
			if(totalLength!=0){
				
				//Old Formula 
				//uptime=((1440*totalLength-(TOTAL_12+TOTAL_13))/(1440*totalLength));
				
				//New Formula
				//uptime=((100-(TOTAL_12+TOTAL_13)/(1440-TOTAL_21)))/100;
				/*double totalTime=TOTAL_12+TOTAL_13;
				double operatingTime=totalTime-TOTAL_21;
				double UpTime_Cal=totalTime/operatingTime;
				
				double downTimePer=UpTime_Cal*100;
				
				uptime=CommonUtil.round(100-downTimePer, 2);*/

				
				double totalTime=TOTAL_12+TOTAL_13+TOTAL_21;
				
				/*Calendar c = Calendar.getInstance();
				int monthMaxDays = c.getActualMaximum(Calendar.DAY_OF_MONTH);
				
				
				Calendar cal = Calendar.getInstance();
			    cal.setTime(sdate);
			    int day = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
			    
			    System.out.println("Hat Be..."+day);*/
				
				int days=CommonUtil.getDaysDiffernce(sdate, edate);
				
				double operatingTime=0;
				
				double totalCalenderHr=0;
				
				for (int i = 0; i <=days; i++) {
					
					totalCalenderHr=totalCalenderHr+1440;
					System.out.println(i);
				}
				
				//System.out.println("totalCalenderHr::"+totalCalenderHr);
				//operatingTime=totalCalenderHr-TOTAL_21; //For 31 Days
				
				operatingTime=totalCalenderHr; //For 31 Days
				
				double UpTime_Cal=totalTime/operatingTime;
				
				double downTimePer=UpTime_Cal*100;
				
				uptime=CommonUtil.round(100-downTimePer, 2);
				
				
				
			}
			double effPercent=(paperYield*firstQuality*uptime);

			
			COL_16.setCellValue(CommonUtil.round(paperYield*100, 2));
			COL_17.setCellValue(CommonUtil.round(firstQuality*100, 2));
			
			//Old Formula Wise
			/*COL_18.setCellValue(CommonUtil.round(uptime*100, 2));
			COL_19.setCellValue(CommonUtil.round(effPercent*100, 2));*/
			
			//New Formula Wise
			COL_18.setCellValue(CommonUtil.round(uptime, 2));
			COL_19.setCellValue(CommonUtil.round(effPercent, 2));
			
			COL_20.setCellValue("");
			COL_21.setCellValue("");
			COL_22.setCellValue("");
		
		}
		
		
		
		return workbook;
	}

}

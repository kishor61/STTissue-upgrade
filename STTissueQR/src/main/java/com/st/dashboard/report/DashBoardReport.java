/**
 *Jun 18, 2018
 *DashBoardReport.java
 * TODO
 *com.st.dashboard.report
 *DashBoardReport.java
 *Roshan Lal Tailor
 */
package com.st.dashboard.report;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import jakarta.servlet.ServletOutputStream;

import org.springframework.stereotype.Component;

import com.st.common.ColumnsOfTable;
import com.st.common.CommonUtil;
import com.st.common.Workbook2007Util;
import com.st.convertingline.model.ConvertingLineProduction;
import com.st.frpproduction.model.FrpProdcutionOperatorDataEntry;

/**
 * @author roshan
 *
 */
@Component
public class DashBoardReport {
	

	private SimpleDateFormat dateFormat=new SimpleDateFormat("MM-dd-yyyy");
	
	
	/**
	 * @param datas1
	 * @param datas2
	 * @param details
	 * @param caseData
	 * @param lrdate
	 * @param lrdays
	 * @param sDate 
	 * @param file
	 * @param outputStream
	 * @throws IOException 
	 */
	public void dashBoardReportExportReport(List<Map<String, String>> datas1,
			List<Map<String, String>> datas2,
			List<FrpProdcutionOperatorDataEntry> details,
			List<ConvertingLineProduction> caseData, String lrdate, int lrdays,
			Date sDate, File file, ServletOutputStream outputStream) throws IOException {
		// TODO Auto-generated method stub
		
		Workbook2007Util util = new Workbook2007Util(file,0);
		
		short rowHeight = 280;
		int row=0;
		int col=0;
		
		col++;
		
		util.addValue(row, col++, dateFormat.format(new Date()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		row++;row++;
		col++;
		
		util.addValue(row, 2, 7.4, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		util.addValue(row, 3, 0, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		row++;
		col++;
		
		util.addValue(row, 2, lrdays, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		util.addValue(row, 3, lrdate, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);

		row++;row++;row++;row++;row++;
		
		for(Map<String, String> map : datas1){
			
			util.addValue(row, 1, map.get(ColumnsOfTable.COL_24).toString(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		}
		
		for(Map<String, String> map : datas1){
			
			util.addValue(row, 2, map.get(ColumnsOfTable.COL_04).toString(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		}
		row++;
		
		for(Map<String, String> map : datas2){
			
			util.addValue(row, 1, map.get(ColumnsOfTable.COL_24).toString(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		}
		
		for(Map<String, String> map : datas2){
			
			util.addValue(row, 2, map.get(ColumnsOfTable.COL_04).toString(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		}
		
		row++;
		util.addValue(row, 1, 0, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		
		util.addValue(row, 2, dateFormat.format(sDate), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		row++;
		
		row++;row++;row++;row++;row++;
		
		for( FrpProdcutionOperatorDataEntry data : details){
			util.addValue(row, 1,data.getTotalcol10(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		}
		row++;
		for( FrpProdcutionOperatorDataEntry data : details){
			util.addValue(row, 1,data.getTotalcol6(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		}
		row++;
		
		util.addValue(row, 1,0, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		row++;
		
		for( FrpProdcutionOperatorDataEntry data : details){
			util.addValue(row, 1,CommonUtil.round(data.getTotalcol11()/2, 2)+" %", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		}
		row++;
		
		row++;row++;
		
		for( FrpProdcutionOperatorDataEntry data : details){
			util.addValue(row, 1,data.getTotalcol10b(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		}
		row++;
		for( FrpProdcutionOperatorDataEntry data : details){
			util.addValue(row, 1,data.getTotalcol6b(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		}
		row++;
		
		util.addValue(row, 1,0, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		row++;
		
		for( FrpProdcutionOperatorDataEntry data : details){
			util.addValue(row, 1,CommonUtil.round(data.getTotalcol11b()/2, 2)+" %", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		}
		
		row++;row++;row++;row++;row++;

		for(Map<String, String> map : datas1){
			
			util.addValue(row, 1, map.get(ColumnsOfTable.COL_02).toString(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		}
		
		row++;
		for(Map<String, String> map : datas1){
			
			util.addValue(row, 1, map.get(ColumnsOfTable.COL_03).toString(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		}
		row++;
		
		for(Map<String, String> map : datas1){
			
			util.addValue(row, 1, map.get(ColumnsOfTable.COL_12).toString(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		}
		row++;
		for(Map<String, String> map : datas1){
			
			util.addValue(row, 1, map.get(ColumnsOfTable.COL_16).toString(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		}
		
		row++;
		for(Map<String, String> map : datas1){
			
			util.addValue(row, 1, map.get(ColumnsOfTable.COL_17).toString(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		}
		
		row++;
		util.addValue(row, 1, 0, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		row++;
		util.addValue(row, 1,0, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		
		
		row++;row++;
		

		for(Map<String, String> map : datas2){
			
			util.addValue(row, 1, map.get(ColumnsOfTable.COL_02).toString(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		}
		
		row++;
		for(Map<String, String> map : datas2){
			
			util.addValue(row, 1, map.get(ColumnsOfTable.COL_03).toString(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		}
		row++;
		
		for(Map<String, String> map : datas2){
			
			util.addValue(row, 1, map.get(ColumnsOfTable.COL_12).toString(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		}
		row++;
		for(Map<String, String> map : datas2){
			
			util.addValue(row, 1, map.get(ColumnsOfTable.COL_16).toString(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		}
		
		row++;
		for(Map<String, String> map : datas2){
			
			util.addValue(row, 1, map.get(ColumnsOfTable.COL_17).toString(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		}
		
		row++;
		util.addValue(row, 1, 0, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		row++;
		util.addValue(row, 1,0, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		row++;
		util.addValue(row, 1,0, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		
		
		row++;row++;row++;row++;row++;
		
		double firstcase=0;
		double secodcase=0;
		for( ConvertingLineProduction data : caseData){
			secodcase=secodcase+data.getSecodcase();
			firstcase=firstcase+data.getFirstcase();
			
		}
		
		util.addValue(row, 1,CommonUtil.round(secodcase+firstcase, 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		row++;
		util.addValue(row, 1,0, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		
		row++;
		util.write(outputStream);
	}


	/**
	 * @param datas1
	 * @param datas2
	 * @param details
	 * @param caseData
	 * @param lrdate
	 * @param lrdays
	 * @param sDate
	 * @param outputStream
	 * @throws IOException 
	 */
	public void createDailyDashBoardReportForAutoMail(
			List<Map<String, String>> datas1, List<Map<String, String>> datas2,
			List<FrpProdcutionOperatorDataEntry> details,
			List<ConvertingLineProduction> caseData, String lrdate, int lrdays,
			Date sDate, FileOutputStream outputStream) throws IOException {
		// TODO Auto-generated method stub
		Workbook2007Util util = new Workbook2007Util();
		util.setSheetName("STT Daily DashBoard Report", 0);

		short rowHeight = 280;
		short rowHeight1 = 400;
		int row=0;
		int col=0;
		

		col++;
		util.addValue(row, col++, "Date", Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight1);
		util.addValue(row, col++, dateFormat.format(new Date()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight1);
		
		row++;
		col=0;
		
		util.addValue(row, col++, "SAFETY", Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
		util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		util.addValue(row, col++, "Last Incident on", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		util.addValue(row, col++, "Remarks", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		
		row++;
		col=0;
		
		util.addValue(row, col++, "YTD OIR", Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
		util.addValue(row, col++, "7.4", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		util.addValue(row, col++, "0", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		
		//col=0;
		//row++;
		
		/*util.addValue(row, col++, 0, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		util.addValue(row, col++, 0, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		util.addValue(row, col++, 7.4, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		util.addValue(row, col++, 0, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		util.addValue(row, col++, 0, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);*/
		
		row++;
		col=0;
		
		util.addValue(row, col++, "Safe workdays w/o Recordable", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		util.addValue(row, col++, lrdays, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		util.addValue(row, col++, lrdate, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			
		row++;
		col=0;
		
		
		util.addValue(row, col++, "Quality", Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
		util.addValue(row, col++, "Daily Tons", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		util.addValue(row, col++, "Daily Tons", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		util.addValue(row, col++, "Monthly Avg.", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		util.addValue(row, col++, "Monthly Avg.", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		
		row++;
		col=0;
		
		util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		util.addValue(row, col++, "Reject", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		util.addValue(row, col++, "Red", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		util.addValue(row, col++, "Reject", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		util.addValue(row, col++, "Red", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		
		row++;
		col=0;
		
		util.addValue(row, col++, "F5", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		for(Map<String, String> map : datas1){
			util.addValue(row, col++, map.get(ColumnsOfTable.COL_24).toString(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		}
		
		for(Map<String, String> map : datas1){
			util.addValue(row, col++, map.get(ColumnsOfTable.COL_04).toString(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		}
		row++;
		col=0;
		
		util.addValue(row, col++, "F6", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		for(Map<String, String> map : datas2){
			util.addValue(row, col++, map.get(ColumnsOfTable.COL_24).toString(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		}
		
		for(Map<String, String> map : datas2){
			util.addValue(row, col++, map.get(ColumnsOfTable.COL_04).toString(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		}
		
		row++;
		col=0;
		
		
		
		
		util.addValue(row, col++, "Days since last complaint", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		util.addValue(row, col++, 0, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		util.addValue(row, col++, dateFormat.format(sDate), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		
		row++;
		col=0;
		
		util.addValue(row, col++, "PRODUCTIVITY", Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
		util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		
		row++;
		col=0;
		util.addValue(row, col++, "FRP", Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
		util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		
		row++;
		col=0;
		
		util.addValue(row, col++, "A Line", Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
		util.addValue(row, col++, "Daily", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		util.addValue(row, col++, "MTD/AVg.", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		util.addValue(row, col++, "Remarks", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		util.addValue(row, col++, "Remarks", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		
		row++;
		col=0;
		
		util.addValue(row, col++, "Batches", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		for( FrpProdcutionOperatorDataEntry data : details){
			util.addValue(row, col++,data.getTotalcol10(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		}
		util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		
		row++;
		col=0;
		
		util.addValue(row, col++, "Tons Made", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		for( FrpProdcutionOperatorDataEntry data : details){
			util.addValue(row, col++,data.getTotalcol6(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		}
		
		util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		
		row++;
		col=0;
		
		util.addValue(row, col++, "Current Run Rate", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		util.addValue(row, col++,0, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		
		
		row++;
		col=0;
		
		util.addValue(row, col++, "HD Level", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		for( FrpProdcutionOperatorDataEntry data : details){
			util.addValue(row, 1,CommonUtil.round(data.getTotalcol11()/2, 2)+" %", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		}
		util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		
		
		row++;
		col=0;
		
		util.addValue(row, col++, "Comments", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		
		row++;
		col=0;
		
		util.addValue(row, col++, "B Line", Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
		util.addValue(row, col++, "Daily", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		util.addValue(row, col++, "MTD/AVg.", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		util.addValue(row, col++, "Remarks", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		util.addValue(row, col++, "Remarks", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		
		row++;
		col=0;
		
		util.addValue(row, col++, "Batches", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		for( FrpProdcutionOperatorDataEntry data : details){
			util.addValue(row, col++,data.getTotalcol10b(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		}
		util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		
		row++;
		col=0;
		
		util.addValue(row, col++, "Tons Made", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		for( FrpProdcutionOperatorDataEntry data : details){
			util.addValue(row, col++,data.getTotalcol6b(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		}
		util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		
		row++;
		col=0;
		
		util.addValue(row, col++, "Current Run Rate", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		util.addValue(row, col++,0, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		
		
		row++;
		col=0;
		util.addValue(row, col++, "PCC/RX Level", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		for( FrpProdcutionOperatorDataEntry data : details){
			util.addValue(row, col++,CommonUtil.round(data.getTotalcol11b()/2, 2)+" %", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		}
		util.addValue(row, col++, 0, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		
		row++;
		col=0;

		util.addValue(row, col++, "Productivity", Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
		util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		
		row++;
		col=0;
		
		util.addValue(row, col++, "F5", Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
		util.addValue(row, col++, "Daily", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		util.addValue(row, col++, "MTD Avg.", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		util.addValue(row, col++, "Remark", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		util.addValue(row, col++, "Remark", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		
		row++;
		col=0;
		
		util.addValue(row, col++, "Reel", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		for(Map<String, String> map : datas1){
			util.addValue(row, col++, map.get(ColumnsOfTable.COL_02).toString(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		}
		util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		
		row++;
		col=0;
		
		util.addValue(row, col++, "Wrapped", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		for(Map<String, String> map : datas1){
			util.addValue(row, col++, map.get(ColumnsOfTable.COL_03).toString(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		}
		util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		
		col=0;
		row++;
		
		util.addValue(row, col++, "TLT", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		for(Map<String, String> map : datas1){
			util.addValue(row, col++, map.get(ColumnsOfTable.COL_12).toString(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		}
		util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		
		col=0;
		row++;
		
		util.addValue(row, col++, "Uptime", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		for(Map<String, String> map : datas1){
			util.addValue(row, col++, map.get(ColumnsOfTable.COL_16).toString(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		}
		util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		
		row++;
		col=0;
		
		util.addValue(row, col++, "Efficiency", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		for(Map<String, String> map : datas1){
			util.addValue(row, col++, map.get(ColumnsOfTable.COL_17).toString(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		}
		util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		
		col=0;
		row++;
		util.addValue(row, col++, "Fresh Water Usage", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		util.addValue(row, col++, "0", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		util.addValue(row, col++, "0", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		
		row++;
		col=0;
		
		util.addValue(row, col++, "Sewer Loss", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		util.addValue(row, col++, "0", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		util.addValue(row, col++, "0", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		
		row++;
		col=0;
		
		util.addValue(row, col++, "Comments", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		util.addValue(row, col++, "0", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		util.addValue(row, col++, "0", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		
		
		row++;
		col=0;
		util.addValue(row, col++, "F6", Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
		util.addValue(row, col++, "Daily", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		util.addValue(row, col++, "MTD Avg.", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		util.addValue(row, col++, "Remark", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		util.addValue(row, col++, "Remark", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		
		row++;
		col=0;
		

		util.addValue(row, col++, "Reel", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		for(Map<String, String> map : datas2){
			util.addValue(row, col++, map.get(ColumnsOfTable.COL_02).toString(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		}
		util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		
		row++;
		col=0;
		
		util.addValue(row, col++, "Wrapped", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		for(Map<String, String> map : datas2){
			util.addValue(row, col++, map.get(ColumnsOfTable.COL_03).toString(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		}
		util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		
		col=0;
		row++;
		
		util.addValue(row, col++, "TLT", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		for(Map<String, String> map : datas2){
			util.addValue(row, col++, map.get(ColumnsOfTable.COL_12).toString(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		}
		util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		
		col=0;
		row++;
		
		util.addValue(row, col++, "Uptime", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		for(Map<String, String> map : datas2){
			util.addValue(row, col++, map.get(ColumnsOfTable.COL_16).toString(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		}
		util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		
		row++;
		col=0;
		
		util.addValue(row, col++, "Efficiency", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		for(Map<String, String> map : datas2){
			util.addValue(row, col++, map.get(ColumnsOfTable.COL_17).toString(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		}
		util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		
		col=0;
		row++;
		util.addValue(row, col++, "Fresh Water Usage", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		util.addValue(row, col++, "0", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		util.addValue(row, col++, "0", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);

		col=0;
		row++;
		util.addValue(row, col++, "River Water Usage", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		util.addValue(row, col++, "0", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		util.addValue(row, col++, "0", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		
		row++;
		col=0;
		
		util.addValue(row, col++, "Sewer Loss", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		util.addValue(row, col++, "0", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		util.addValue(row, col++, "0", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		
		row++;
		col=0;
		
		util.addValue(row, col++, "Comments", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		util.addValue(row, col++, "0", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		util.addValue(row, col++, "0", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		
		row++;
		col=0;
		
		util.addValue(row, col++, "Converting", Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
		util.addValue(row, col++, "Daily", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		util.addValue(row, col++, "Inventory", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		
		row++;
		col=0;
		
		double firstcase=0;
		double secodcase=0;
		for( ConvertingLineProduction data : caseData){
			secodcase=secodcase+data.getSecodcase();
			firstcase=firstcase+data.getFirstcase();
			
		}
		util.addValue(row, col++, "Total Cases", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		util.addValue(row, col++, CommonUtil.round(secodcase+firstcase, 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		
		row++;
		col=0;
		
		util.addValue(row, col++, "TLT", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		util.addValue(row, col++, 0, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		
		
		row++;
		col=0;
		
		util.addValue(row, col++, "Shiping", Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
		util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		
		row++;
		col=0;
		
		util.addValue(row, col++, "White Inventory", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		
		row++;
		col=0;
		
		util.addValue(row, col++, "Red Inventory", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		
		
		row++;
		col=0;
		
		util.addValue(row, col++, "Shipped Yesterday/Today", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		
		row++;
		col=0;
		
		util.addValue(row, col++, "Received Yesterday/Today", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		
		
		
		row++;
		col=0;
		
		util.addValue(row, col++, "Comments", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		
		row++;
		
		for (int i = 0; i < 24; i++) {
			util.setAutoSizeColumn(i);
		}
		
		util.write(outputStream);
		
	}


}

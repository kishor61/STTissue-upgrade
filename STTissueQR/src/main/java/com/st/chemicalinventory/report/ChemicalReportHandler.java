/**
 *Nov 27, 2014
 *ChemicalReportHandler.java
 * TODO
 *com.st.chemicalinventory.report
 *ChemicalReportHandler.java
 *Sunil Singh Bora
 */
package com.st.chemicalinventory.report;

import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.List;

import jakarta.servlet.ServletOutputStream;

import org.springframework.stereotype.Component;

import com.st.chemicalinventory.model.ChemicalData;
import com.st.chemicalinventory.model.ChemicalPrimaryCode;
import com.st.chemicalinventory.model.ChemicalReportData;
import com.st.chemicalinventory.model.ChemicalSecondaryCode;
import com.st.chemicalinventory.model.ChemicalReportData.ReportData;
import com.st.common.Workbook2007Util;

/**
 * @author sbora
 *
 */
@Component
public class ChemicalReportHandler {

	/**
	 * @param reportData
	 * @param outputStream
	 * @throws IOException 
	 */
	public void createExcelReport(ChemicalReportData reportData,
			OutputStream outputStream) throws IOException {
		
		Workbook2007Util util=new Workbook2007Util();
		
		int colLen=reportData.getDatas().size();
		
		int row=0;
		int col=0;
		short rowHeight=280;
		
		
		util.mergeCell(0, 0, 0, colLen);
		util.addValue(row++, 0, "ST Tissue CHEMICAL - REPORT", Workbook2007Util.Style.STYLE_BOLD_CENTER, (short)400);
		
		
		util.mergeCell(1, 3, 0, 0);
		util.addValue(row, 0, "DATE", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		
		List<ChemicalPrimaryCode> primaryCodes=reportData.getPrimaryCodes();
		col=1;
		for (ChemicalPrimaryCode chemicalPrimaryCode : primaryCodes) {
			int sCol=col;
			int eCol=col+chemicalPrimaryCode.getCount()-1;
			
			util.mergeCell(row, row, sCol, eCol);
			util.addValue(row, sCol, chemicalPrimaryCode.getName(),Workbook2007Util.Style.STYLE_NORMAL_CENTER,rowHeight);
			col=sCol+chemicalPrimaryCode.getCount();
		}
		
		row++;
		col=1;
		List<ChemicalSecondaryCode> secondaryCodes=reportData.getSecondaryCodes();
		for (ChemicalSecondaryCode secondaryCode : secondaryCodes) {
			int sCol=col;
			int eCol=col+secondaryCode.getCount()-1;
			
			util.mergeCell(row, row, sCol, eCol);
			util.addValue(row, sCol, secondaryCode.getName(),Workbook2007Util.Style.STYLE_NORMAL_CENTER,rowHeight);
			col=sCol+secondaryCode.getCount();
		}
		
		
		row++;
		col=1;
		List<ChemicalData> chemicalDatas=reportData.getDatas();
		for (ChemicalData chemicalData : chemicalDatas) {
			util.addValue(row, col, chemicalData.getChemicalCode(),Workbook2007Util.Style.STYLE_NORMAL_CENTER,rowHeight);
			col++;
		}
		
		row++;
		col=0;
		
		List<ReportData> datas=reportData.getReportDatas();
		for (ReportData data : datas) {
			util.addValue(row, col++, data.getDate(),Workbook2007Util.Style.STYLE_NORMAL_CENTER,rowHeight);
			
			for (double value : data.getValues()) {
				util.addValue(row, col++, value,Workbook2007Util.Style.STYLE_NORMAL_CENTER,rowHeight);
			}
			row++;
			col=0;
		}
		
		
		col=1;
		util.addValue(row, 0, "TOTAL",Workbook2007Util.Style.STYLE_BOLD_CENTER,rowHeight);
		
		for (ChemicalData chemicalData : chemicalDatas) {
			util.addValue(row, col, chemicalData.getTotalConsumption(),Workbook2007Util.Style.STYLE_BOLD_CENTER,rowHeight);
			col++;
		}
		
		for (int i = 0; i < colLen; i++) {
			util.setAutoSizeColumn(i);
		}
		
		util.write(outputStream);
	}

	/**
	 * @param reportDatas
	 * @param outputStream
	 * @throws IOException 
	 */
	public void createExcelReport(List<ChemicalReportData> reportDatas,
			ServletOutputStream outputStream) throws IOException {
		
		Workbook2007Util util=new Workbook2007Util();
		int row=0;
		int col=0;
		short rowHeight=280;
		
		util.mergeCell(0, 0, 0, 4);
		util.addValue(row++, 0, "ST Tissue CHEMICAL - REPORT", Workbook2007Util.Style.STYLE_BOLD_CENTER, (short)400);
		
		
		util.addValue(row, col++, "Date", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(row, col++, "Consumption", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(row, col++, "Chemical", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(row, col++, "Secondary Code", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(row, col++, "Primary Code", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		
		row++;
		col=0;
		
		
		SimpleDateFormat dateFormat=new SimpleDateFormat("MM-dd-yyyy");
		
		for (ChemicalReportData chemicalReportData : reportDatas) {
			List<ChemicalData> datas=chemicalReportData.getDatas();
			
			util.mergeCell(row, row+datas.size()-1, col, col);
			util.addValue(row, col++, dateFormat.format(chemicalReportData.getDate()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			
			for (ChemicalData chemicalData : datas) {
				util.addValue(row, col++, chemicalData.getConsumption(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
				util.addValue(row, col++, chemicalData.getChemicalCode(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
				util.addValue(row, col++, chemicalData.getSecondaryName(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
				util.addValue(row, col++, chemicalData.getPrimaryName(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
				row++;
				col=1;
			}
			
			col=0;
		}
		
		
		
		
		for (int i = 1; i < 5; i++) {
			util.setAutoSizeColumn(i);
		}
		
		util.write(outputStream);
	}

}

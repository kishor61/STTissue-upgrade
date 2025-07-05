/**
 *Dec 25, 2014
 *ProductionPM6ReportHandler.java
 * TODO
 *com.st.production.report
 *ProductionPM6ReportHandler.java
 *Sunil Singh Bora
 */
package com.st.production.report;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
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
import org.springframework.stereotype.Component;

import com.st.common.Columns;
import com.st.common.ColumnsOfTable;
import com.st.common.CommonUtil;
import com.st.common.Workbook2007Util;
import com.st.common.pdfutil.PdfReportUtil;
import com.st.common.pdfutil.PdfReportUtil.Section;
import com.st.common.pdfutil.PdfReportUtil.Table;
import com.st.common.pdfutil.PdfStyle;
import com.st.production.model.MachineAndWrapper;
import com.st.production.model.WrapperProduction;

/**
 * @author sbora
 *
 */
@Component
public class ProductionReportHandler {

	private SimpleDateFormat dateFormat1=new SimpleDateFormat("MM/dd/yyyy");
	
	/**
	 * @param datas
	 * @param shift
	 * @param date
	 * @param outputStream
	 */
	public void createPdfReport(Map<String, Object> datas, String shift,
			Date date, OutputStream outputStream) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @param datas
	 * @param outputStream
	 * @throws IOException 
	 */
	public void createExcelGradeAndHoursReport(List<Map<String, Object>> datas,
			OutputStream outputStream) throws IOException {
		
		Workbook2007Util workbookUtil=new Workbook2007Util();

		int row=0;
		int col=0;
		short rowHeight=280;
		
		workbookUtil.addValue(row, col++, "DateEntered", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, "Customer", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, "GradeCode", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, "RollWidthSum", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, "Ply", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, "WhiteGross", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, "WhiteNet", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, "RedGross", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, "RedNet", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, "RejectGross", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, "RejectNet", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, "GrossWrapped", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, "NetWrapped", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, "HoursSpent", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, "NetTonsPerHour", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, "NetTonsPerDay", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, "MachineSpeed", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, "TBDRate", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, "TargetTonsCalc", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, "EfficiencyCalc", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, "Furnish Code", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);

		
		
		double whiteGrossTotal=0;
		double whiteNetTotal=0;
		double redGrossTotal=0;
		double redNetTotal=0;
		double rejectGrossTotal=0;
		double rejectNetTotal=0;
		
		double grossTotal=0;
		double netTotal=0;
		
		double hrsTotal=0;
		
		for (Map<String, Object> map : datas) {
			row++;
			col=0;
			
			workbookUtil.addValue(row, col++, map.get("DateEntered"), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, map.get("Customer"), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, map.get("GradeCode"), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, CommonUtil.checkDouble(map.get("RollWidthSum").toString()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, map.get("Ply"), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, map.get("WhiteGross"), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, map.get("WhiteNet"), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, map.get("RedGross"), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, map.get("RedNet"), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, map.get("RejectGross"), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, map.get("RejectNet"), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, map.get("GrossWrapped"), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, map.get("NetWrapped"), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, map.get("HoursSpent"), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, map.get("NetTonsPerHour"), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, map.get("NetTonsPerDay"), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, map.get("MachineSpeed"), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, map.get("TBDRate"), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, map.get("TargetTonsCalc"), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, map.get("EfficiencyCalc"), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, map.get("FurnishCode"), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);

			whiteGrossTotal+= CommonUtil.checkDouble(map.get("WhiteGross").toString());
			whiteNetTotal+= CommonUtil.checkDouble(map.get("WhiteNet").toString());
			redGrossTotal+= CommonUtil.checkDouble(map.get("RedGross").toString());
			redNetTotal+= CommonUtil.checkDouble(map.get("RedNet").toString());
			rejectGrossTotal+= CommonUtil.checkDouble(map.get("RejectGross").toString());
			rejectNetTotal+= CommonUtil.checkDouble(map.get("RejectNet").toString());
			grossTotal+= CommonUtil.checkDouble(map.get("GrossWrapped").toString());
			netTotal+= CommonUtil.checkDouble(map.get("NetWrapped").toString());
			
			hrsTotal+= CommonUtil.checkDouble(map.get("HoursSpent").toString());
		}
	
		{
			row++;
			col=0;
			
			workbookUtil.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, whiteGrossTotal, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, whiteNetTotal, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, redGrossTotal, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, redNetTotal, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, rejectGrossTotal, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, rejectNetTotal, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, grossTotal, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, netTotal, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, hrsTotal, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);

		}
		
		for (int i = 0; i < 22; i++) {
			workbookUtil.setAutoSizeColumn(i);
		}
		
		workbookUtil.freez(1, 1);
		
		workbookUtil.write(outputStream);
	}

	/**
	 * @param servletOutputStream 
	 * @param productions 
	 * @throws Exception 
	 * 
	 */
	public void createPdfInventoryDailySummary(List<WrapperProduction> productions, OutputStream outputStream) throws Exception {
		
		PdfReportUtil pdfUtil=new PdfReportUtil();
		pdfUtil.setOuputStream(outputStream);
		pdfUtil.setDocumentTitle("Inventory Daily Summary");
		pdfUtil.setPage(PdfStyle.PAGE_LEGAL_PORTRAIT);
		pdfUtil.open();
		
		
		
		Section header=pdfUtil.new Section(10, 10, PdfStyle.ALIGN_CENTER);
		header.addText("Inventory Daily Summary".toUpperCase(), PdfStyle.FONT_BOLD_UNDERLINE_16);
		header.finish();
		
		SimpleDateFormat dateFormat=new SimpleDateFormat("MM/dd/yyyy");
		
		Date date=null;
		String customer=null;
		String wrapper=null;
		
		Table table=null;
		
		int totalRoll=0;
		double totalWeight=0;
		
		int grandTotalRoll=0;
		double grandTotalWeight=0;
		
		
		for (int i = 0; i < productions.size(); i++) {
			
			
			WrapperProduction production=productions.get(i);
			
			if(i==0){
				table=pdfUtil.new Table(7, new float[]{3,2,2,2,1,2,3});
			//	table.setCommonHeader(true);
				
				
				
				
				date=production.getDateEntered();
				customer=production.getCustomer();
				wrapper=production.getWrapperNumber();
				
				table.addCell(dateFormat.format(date), PdfStyle.FONT_BOLD_10, PdfStyle.ALIGN_LEFT, 1, 1,0);
				table.addCell(customer, PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 6, 1,0);
				table.addCell(wrapper+" Production", PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 7, 1,0);
				
				table.addCell("Grade Code", PdfStyle.FONT_BOLD_8, PdfStyle.ALIGN_CENTER, 1, 1);
				table.addCell("Roll Size", PdfStyle.FONT_BOLD_8, PdfStyle.ALIGN_CENTER, 1, 1);
				table.addCell("Roll Count", PdfStyle.FONT_BOLD_8, PdfStyle.ALIGN_CENTER, 1, 1);
				table.addCell("Cust Code", PdfStyle.FONT_BOLD_8, PdfStyle.ALIGN_CENTER, 1, 1);
				table.addCell("Ply", PdfStyle.FONT_BOLD_8, PdfStyle.ALIGN_CENTER, 1, 1);
				table.addCell("Core Size", PdfStyle.FONT_BOLD_8, PdfStyle.ALIGN_CENTER, 1, 1);
				table.addCell("White Weight", PdfStyle.FONT_BOLD_8, PdfStyle.ALIGN_CENTER, 1, 1);
				
				table.addCell(CommonUtil.checkNull(production.getGradeCode()), PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1);
				table.addCell(CommonUtil.checkNull(production.getRollWidth())+"x"+CommonUtil.checkNull(production.getDiameter()), PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1);
				table.addCell(production.getRollCount()+"", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1);	
				table.addCell(CommonUtil.checkNull(production.getCustomerGradeCode()), PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1);
				table.addCell(production.getPly()+"", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1);
				table.addCell(CommonUtil.checkNull(production.getCoreSize()), PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1);
				table.addCell(production.getWhiteWeight()+"", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1);
				
				
				totalRoll+=production.getRollCount();
				totalWeight+=production.getWhiteWeight();
				
				grandTotalRoll+=production.getRollCount();
				grandTotalWeight+=production.getWhiteWeight();
				
				
			}else if(CommonUtil.isEqual(date, production.getDateEntered())
					&& customer.equalsIgnoreCase(production.getCustomer())
					&& wrapper.equalsIgnoreCase(production.getWrapperNumber())
					){
				
				table.addCell(CommonUtil.checkNull(production.getGradeCode()), PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1);
				table.addCell(CommonUtil.checkNull(production.getRollWidth())+"x"+CommonUtil.checkNull(production.getDiameter()), PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1);
				table.addCell(production.getRollCount()+"", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1);	
				table.addCell(CommonUtil.checkNull(production.getCustomerGradeCode()), PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1);
				table.addCell(production.getPly()+"", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1);
				table.addCell(CommonUtil.checkNull(production.getCoreSize()), PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1);
				table.addCell(production.getWhiteWeight()+"", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1);
				
				totalRoll+=production.getRollCount();
				totalWeight+=production.getWhiteWeight();
				
				grandTotalRoll+=production.getRollCount();
				grandTotalWeight+=production.getWhiteWeight();
				
			}else{
				
				
				
				
				if(CommonUtil.isEqual(date, production.getDateEntered())){
					table.addCell("WR6 Roll", PdfStyle.FONT_BOLD_8, PdfStyle.ALIGN_RIGHT, 2, 1,0);
					table.addCell(totalRoll+"", PdfStyle.FONT_BOLD_8, PdfStyle.ALIGN_CENTER, 1, 1,0);
					table.addCell("Pounds", PdfStyle.FONT_BOLD_8, PdfStyle.ALIGN_RIGHT, 3, 1,0);
					table.addCell(CommonUtil.round(totalWeight, 2)+"", PdfStyle.FONT_BOLD_8, PdfStyle.ALIGN_CENTER, 1, 1,0);
					
					table.addCell("", PdfStyle.FONT_BOLD_8, PdfStyle.ALIGN_RIGHT, 3, 1,0);
					table.addCell("Tons", PdfStyle.FONT_BOLD_8, PdfStyle.ALIGN_RIGHT, 3, 1,0);
					table.addCell(CommonUtil.round(totalWeight/2000, 2)+"", PdfStyle.FONT_BOLD_8, PdfStyle.ALIGN_CENTER, 1, 1,0);
					
					totalRoll=0;
					totalWeight=0;
					
				}else{
					
					table.addCell("WR6 Roll", PdfStyle.FONT_BOLD_8, PdfStyle.ALIGN_RIGHT, 2, 1,0);
					table.addCell(totalRoll+"", PdfStyle.FONT_BOLD_8, PdfStyle.ALIGN_CENTER, 1, 1,0);
					table.addCell("Pounds", PdfStyle.FONT_BOLD_8, PdfStyle.ALIGN_RIGHT, 3, 1,0);
					table.addCell(CommonUtil.round(totalWeight, 2)+"", PdfStyle.FONT_BOLD_8, PdfStyle.ALIGN_CENTER, 1, 1,0);
					
					table.addCell("", PdfStyle.FONT_BOLD_8, PdfStyle.ALIGN_RIGHT, 3, 1,0);
					table.addCell("Tons", PdfStyle.FONT_BOLD_8, PdfStyle.ALIGN_RIGHT, 3, 1,0);
					table.addCell(CommonUtil.round(totalWeight/2000, 2)+"", PdfStyle.FONT_BOLD_8, PdfStyle.ALIGN_CENTER, 1, 1,0);
					
					table.addCell("______________________________________________"
							+ "___________________________________________________"
							+ "_________________________________________________"
							+ "__________________________", PdfStyle.FONT_NORMAL_6, PdfStyle.ALIGN_CENTER, 7, 1,0,0,0,1,1);
					
					table.addCell("WR6 Total Roll", PdfStyle.FONT_BOLD_8, PdfStyle.ALIGN_RIGHT, 2, 1,0);
					table.addCell(grandTotalRoll+"", PdfStyle.FONT_BOLD_8, PdfStyle.ALIGN_CENTER, 1, 1,0);
					table.addCell("Total Pounds", PdfStyle.FONT_BOLD_8, PdfStyle.ALIGN_RIGHT, 3, 1,0);
					table.addCell(CommonUtil.round(grandTotalWeight, 2)+"", PdfStyle.FONT_BOLD_8, PdfStyle.ALIGN_CENTER, 1, 1,0);
					
					table.addCell("", PdfStyle.FONT_BOLD_8, PdfStyle.ALIGN_RIGHT, 3, 1,0);
					table.addCell("Total Tons", PdfStyle.FONT_BOLD_8, PdfStyle.ALIGN_RIGHT, 3, 1,0);
					table.addCell(CommonUtil.round(grandTotalWeight/2000, 2)+"", PdfStyle.FONT_BOLD_8, PdfStyle.ALIGN_CENTER, 1, 1,0);
					
					totalRoll=0;
					totalWeight=0;
					
					grandTotalRoll=0;
					grandTotalWeight=0;
					
					
					table.addCell("\n", PdfStyle.FONT_BOLD_10, PdfStyle.ALIGN_LEFT, 7, 1,0);
					
				}
				
				
				
				
				table.finish();
				
				
				date=production.getDateEntered();
				customer=production.getCustomer();
				wrapper=production.getWrapperNumber();
				
				
				
				table=pdfUtil.new Table(7, new float[]{3,2,2,2,1,2,3});
				//table.setCommonHeader(true, 2);
				
				
				
				
				
				table.addCell(dateFormat.format(date), PdfStyle.FONT_BOLD_10, PdfStyle.ALIGN_LEFT, 1, 1,0);
				table.addCell(customer, PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 6, 1,0);
				table.addCell(wrapper+" Production", PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 7, 1,0);
				
				table.addCell("Grade Code", PdfStyle.FONT_BOLD_8, PdfStyle.ALIGN_CENTER, 1, 1);
				table.addCell("Roll Size", PdfStyle.FONT_BOLD_8, PdfStyle.ALIGN_CENTER, 1, 1);
				table.addCell("Roll Count", PdfStyle.FONT_BOLD_8, PdfStyle.ALIGN_CENTER, 1, 1);
				table.addCell("Cust Code", PdfStyle.FONT_BOLD_8, PdfStyle.ALIGN_CENTER, 1, 1);
				table.addCell("Ply", PdfStyle.FONT_BOLD_8, PdfStyle.ALIGN_CENTER, 1, 1);
				table.addCell("Core Size", PdfStyle.FONT_BOLD_8, PdfStyle.ALIGN_CENTER, 1, 1);
				table.addCell("White Weight", PdfStyle.FONT_BOLD_8, PdfStyle.ALIGN_CENTER, 1, 1);
				
				table.addCell(CommonUtil.checkNull(production.getGradeCode()), PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1);
				table.addCell(CommonUtil.checkNull(production.getRollWidth())+"x"+CommonUtil.checkNull(production.getDiameter()), PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1);
				table.addCell(production.getRollCount()+"", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1);	
				table.addCell(CommonUtil.checkNull(production.getCustomerGradeCode()), PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1);
				table.addCell(production.getPly()+"", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1);
				table.addCell(CommonUtil.checkNull(production.getCoreSize()), PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1);
				table.addCell(production.getWhiteWeight()+"", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1);
				
				totalRoll+=production.getRollCount();
				totalWeight+=production.getWhiteWeight();
				
				grandTotalRoll+=production.getRollCount();
				grandTotalWeight+=production.getWhiteWeight();
			}

		}
		
		if(table!=null){
			
			

			table.addCell("WR6 Roll", PdfStyle.FONT_BOLD_8, PdfStyle.ALIGN_RIGHT, 2, 1,0);
			table.addCell(totalRoll+"", PdfStyle.FONT_BOLD_8, PdfStyle.ALIGN_CENTER, 1, 1,0);
			table.addCell("Pounds", PdfStyle.FONT_BOLD_8, PdfStyle.ALIGN_RIGHT, 3, 1,0);
			table.addCell(CommonUtil.round(totalWeight, 2)+"", PdfStyle.FONT_BOLD_8, PdfStyle.ALIGN_CENTER, 1, 1,0);
			
			table.addCell("", PdfStyle.FONT_BOLD_8, PdfStyle.ALIGN_RIGHT, 3, 1,0);
			table.addCell("Tons", PdfStyle.FONT_BOLD_8, PdfStyle.ALIGN_RIGHT, 3, 1,0);
			table.addCell(CommonUtil.round(totalWeight/2000, 2)+"", PdfStyle.FONT_BOLD_8, PdfStyle.ALIGN_CENTER, 1, 1,0);

			table.addCell("______________________________________________"
					+ "___________________________________________________"
					+ "_________________________________________________"
					+ "__________________________", PdfStyle.FONT_NORMAL_6, PdfStyle.ALIGN_CENTER, 7, 1,0,0,0,1,1);
			
			table.addCell("WR6 Total Roll", PdfStyle.FONT_BOLD_8, PdfStyle.ALIGN_RIGHT, 2, 1,0);
			table.addCell(grandTotalRoll+"", PdfStyle.FONT_BOLD_8, PdfStyle.ALIGN_CENTER, 1, 1,0);
			table.addCell("Total Pounds", PdfStyle.FONT_BOLD_8, PdfStyle.ALIGN_RIGHT, 3, 1,0);
			table.addCell(CommonUtil.round(grandTotalWeight, 2)+"", PdfStyle.FONT_BOLD_8, PdfStyle.ALIGN_CENTER, 1, 1,0);
			
			table.addCell("", PdfStyle.FONT_BOLD_8, PdfStyle.ALIGN_RIGHT, 3, 1,0);
			table.addCell("Total Tons", PdfStyle.FONT_BOLD_8, PdfStyle.ALIGN_RIGHT, 3, 1,0);
			table.addCell(CommonUtil.round(grandTotalWeight/2000, 2)+"", PdfStyle.FONT_BOLD_8, PdfStyle.ALIGN_CENTER, 1, 1,0);
			
			totalRoll=0;
			totalWeight=0;
			
			grandTotalRoll=0;
			grandTotalWeight=0;
				
			
			table.finish();
		}
		
		pdfUtil.close();
	}

	/**
	 * @param datas
	 * @param outputStream
	 * @throws Exception 
	 */
	public void createExcelGradeAndHoursMachineReport(
			List<Map<String, Object>> datas, OutputStream outputStream) throws Exception {
		Workbook2007Util workbookUtil=new Workbook2007Util();

		int row=0;
		int col=0;
		short rowHeight=280;
		
		workbookUtil.addValue(row, col++, "DateEntered", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
	//	workbookUtil.addValue(row, col++, "Customer", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, "GradeCode", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
	//	workbookUtil.addValue(row, col++, "RollWidthSum", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
	//	workbookUtil.addValue(row, col++, "Ply", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, "GoodGross", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, "GoodNet", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, "RedGross", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, "RedNet", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, "RejectGross", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, "RejectNet", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, "GrossWrapped", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, "NetWrapped", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, "HoursSpent", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, "NetTonsPerHour", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, "NetTonsPerDay", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, "MachineSpeed", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, "TBDRate", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, "TargetTonsCalc", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, "EfficiencyCalc", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);

		
		double whiteGrossTotal=0;
		double whiteNetTotal=0;
		double redGrossTotal=0;
		double redNetTotal=0;
		double rejectGrossTotal=0;
		double rejectNetTotal=0;
		
		double grossTotal=0;
		double netTotal=0;
		
		double hrsTotal=0;
		
		for (Map<String, Object> map : datas) {
			row++;
			col=0;
			
			workbookUtil.addValue(row, col++, map.get("DateEntered"), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
	//		workbookUtil.addValue(row, col++, map.get("Customer"), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, map.get("GradeCode"), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
	//		workbookUtil.addValue(row, col++, CommonUtil.checkDouble(map.get("RollWidthSum").toString()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
	//		workbookUtil.addValue(row, col++, map.get("Ply"), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, map.get("WhiteGross"), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, map.get("WhiteNet"), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, map.get("RedGross"), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, map.get("RedNet"), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, map.get("RejectGross"), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, map.get("RejectNet"), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, map.get("GrossWrapped"), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, map.get("NetWrapped"), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, map.get("HoursSpent"), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, map.get("NetTonsPerHour"), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, map.get("NetTonsPerDay"), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, map.get("MachineSpeed"), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, map.get("TBDRate"), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, map.get("TargetTonsCalc"), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, map.get("EfficiencyCalc"), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);

			whiteGrossTotal+= CommonUtil.checkDouble(map.get("WhiteGross").toString());
			whiteNetTotal+= CommonUtil.checkDouble(map.get("WhiteNet").toString());
			redGrossTotal+= CommonUtil.checkDouble(map.get("RedGross").toString());
			redNetTotal+= CommonUtil.checkDouble(map.get("RedNet").toString());
			rejectGrossTotal+= CommonUtil.checkDouble(map.get("RejectGross").toString());
			rejectNetTotal+= CommonUtil.checkDouble(map.get("RejectNet").toString());
			grossTotal+= CommonUtil.checkDouble(map.get("GrossWrapped").toString());
			netTotal+= CommonUtil.checkDouble(map.get("NetWrapped").toString());
			
			hrsTotal+= CommonUtil.checkDouble(map.get("HoursSpent").toString());
		}
	
		{
			row++;
			col=0;
			
		//	workbookUtil.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		//	workbookUtil.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		//	workbookUtil.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, whiteGrossTotal, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, whiteNetTotal, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, redGrossTotal, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, redNetTotal, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, rejectGrossTotal, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, rejectNetTotal, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, grossTotal, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, netTotal, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, hrsTotal, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);

		}
		
		for (int i = 0; i < 17; i++) {
			workbookUtil.setAutoSizeColumn(i);
		}
		
		workbookUtil.freez(1, 1);
		
		workbookUtil.write(outputStream);
	}

	/**
	 * @param productions
	 * @param outputStream
	 * @throws IOException 
	 */
	public void createWrapperAverageReport(List<WrapperProduction> productions,
			OutputStream outputStream) throws IOException {
		Workbook2007Util workbookUtil=new Workbook2007Util();

		int row=0;
		int col=0;
		short rowHeight=280;
		
		workbookUtil.addValue(row, col++, "Grade", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, "Diameter", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, "Roll Width", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, "White Weight (avg)", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, "White Weight (max)", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, "White Weight (min)", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);

		for (WrapperProduction production : productions) {
			col=0;
			row++;
			workbookUtil.addValue(row, col++, CommonUtil.checkNull(production.getGradeCode()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, CommonUtil.checkNull(production.getDiameter()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, CommonUtil.checkNull(production.getRollWidth()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, production.getWhiteWeight(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, production.getWhiteWeightMax(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, production.getWhiteWeightMin(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			
		}
		
		for (int i = 0; i <6; i++) {
			workbookUtil.setAutoSizeColumn(i);
		}
		
		workbookUtil.write(outputStream);
	}

	/**
	 * @param machineAndWrappers
	 * @param outputStream
	 * @throws IOException 
	 */
	public void createMachineAndWrapperReport(
			List<MachineAndWrapper> machineAndWrappers,
			OutputStream outputStream) throws IOException {
		Workbook2007Util workbookUtil=new Workbook2007Util();

		int row=0;
		int col=0;
		
		workbookUtil.addValue(row, 0, "Machine Vs Wrapper Reports", Workbook2007Util.Style.STYLE_HEADER_01, (short)400);
		workbookUtil.mergeCell(row, row, 0, 17);
		short rowHeight=280;
		col=0;
		row++;
		
		
	//	workbookUtil.addValue(row, col++, "RollID", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, "DateEntered", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, "GradeCode", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, "ReelNumber", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, "ReelWhiteWeight", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, "ReelRedWeight", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, "ReelRejectWeight", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, "ReelSumTons", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, "WrappedCount", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, "WrappedWhite", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, "WrappedRed", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, "WrappedReject", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, "WrappedSumLbs", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, "WrappedSumTons", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, "Variance", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, "VariancePercent", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, "WrapperWidth", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, "MachReelWidth", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, "WidthVariance", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		
		
		SimpleDateFormat dateFormat=new SimpleDateFormat("MM/dd/yyyy");
		
		for (MachineAndWrapper machineAndWrapper : machineAndWrappers) {
			col=0;
			row++;
			//workbookUtil.addValue(row, col++, CommonUtil.checkNull(machineAndWrapper.getRollID()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, dateFormat.format(machineAndWrapper.getDateEntered()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, CommonUtil.checkNull(machineAndWrapper.getGradeCode()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, machineAndWrapper.getReelNumber(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, machineAndWrapper.getReelWhiteWeight(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, machineAndWrapper.getReelRedWeight(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, machineAndWrapper.getReelRejectWeight(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, machineAndWrapper.getReelSumTons(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, machineAndWrapper.getWrappedCount(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, machineAndWrapper.getWrappedWhite(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, machineAndWrapper.getWrappedRed(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, machineAndWrapper.getWrappedReject(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, machineAndWrapper.getWrappedSumLbs(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, machineAndWrapper.getWrappedSumTons(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, machineAndWrapper.getVariance(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, CommonUtil.checkNull(machineAndWrapper.getVariancePercent()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, machineAndWrapper.getWrapperWidth(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, machineAndWrapper.getMachReelWidth(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, machineAndWrapper.getWidthVariance(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			
		}
		
		for (int i = 0; i <19; i++) {
			workbookUtil.setAutoSizeColumn(i);
		}
		
		workbookUtil.write(outputStream);
	}

	/**
	 * @param wrapperProductions
	 * @param outputStream
	 * @throws IOException 
	 */
	public void createWrapperByDateReport(
			List<WrapperProduction> wrapperProductions,
			OutputStream outputStream) throws IOException {
		Workbook2007Util workbookUtil=new Workbook2007Util();

		int row=0;
		int col=0;
		short rowHeight=280;
		
		workbookUtil.addValue(row, col++, "DateEntered", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, "DateTimeEntered", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, "RollID", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, "GradeCode", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, "CustomerGradeCode", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, "RollNumber", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, "SetPosition", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, "WhiteWeight", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, "RedWeight", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, "RejectWeight", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, "Diam", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, "RWidth", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, "Ply", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, "CoreSize", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, "Customer", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, "WeightVar", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, "ReelNumber1", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, "MachineRollID1", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, "ReelWidth", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, "ReelWeight", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, "", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, "", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, "", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		
		SimpleDateFormat dateFormat=new SimpleDateFormat("MM/dd/yyyy");
		SimpleDateFormat dateTimeFormat=new SimpleDateFormat("MM/dd/yyyy hh:mm a");
		
		double reelNumber=0;
		int countRow=0;
		Set<String> noOfSets=new HashSet<String>();
		double whiteWeight=0;
		double reelWeight=0;
		double reelWidth=0;
		double rwidth=0;
		
		double min=Double.MAX_VALUE;
		double max=0;
		double avg=0;

		
		for (WrapperProduction production : wrapperProductions) {
			
			
			if(reelNumber==0){
				//Continue
			}else if(reelNumber!=production.getReelNumber1()){
				
				//Row -1 
				row++;
				workbookUtil.addValue(row, 4, "Number of Sets", Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				workbookUtil.addValue(row, 5, noOfSets.size(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				workbookUtil.addValue(row, 6, "Total", Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				workbookUtil.addValue(row, 7, whiteWeight, Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				double winderTrim=0;
				if(noOfSets.size()!=0){
					winderTrim=CommonUtil.round(rwidth/noOfSets.size(), 3);
				}
				workbookUtil.addValue(row, 9, "Winder Trim", Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				workbookUtil.addValue(row, 10, winderTrim, Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				workbookUtil.addValue(row, 15, "Reel Weight", Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				workbookUtil.addValue(row, 16, reelWeight, Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				workbookUtil.addValue(row, 20, "MIN", Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				workbookUtil.addValue(row, 21, CommonUtil.round(min, 4), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				//Row - 2
				row++;
				double recovery=0;
				if(reelWeight!=0){
					recovery=CommonUtil.round((whiteWeight/(reelWeight*2000))*100, 2);
				}
				workbookUtil.addValue(row, 6, "Recovery", Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				workbookUtil.addValue(row, 7, recovery+"%", Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				workbookUtil.addValue(row, 9, "Machine Trim", Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				workbookUtil.addValue(row, 10, reelWidth, Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				workbookUtil.addValue(row, 20, "MAX", Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				workbookUtil.addValue(row, 21, CommonUtil.round(max, 4), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				//Row -3
				row++;
				
				double trimLoss=0;
				if(reelWidth!=0){
					trimLoss=CommonUtil.round(((reelWidth-winderTrim)/reelWidth)*100, 2);
				}
				workbookUtil.addValue(row, 9, "Trim Loss", Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				workbookUtil.addValue(row, 10, trimLoss+"%", Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				workbookUtil.addValue(row, 20, "Avg", Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				workbookUtil.addValue(row, 21, CommonUtil.round(countRow>0?avg/countRow:0, 4), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				row++;
				
				countRow=0;
				noOfSets.clear();
				whiteWeight=0;
				reelWeight=0;
				rwidth=0;
				reelWidth=0;
				min=Double.MAX_VALUE;
				max=0;
				avg=0;
				
			}
			
			reelNumber=production.getReelNumber1();
			
			col=0;
			row++;
			workbookUtil.addValue(row, col++,production.getDateEntered()==null?"":dateFormat.format(production.getDateEntered()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++,production.getDateTimeEntered()==null?"":dateTimeFormat.format(production.getDateTimeEntered()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			
			workbookUtil.addValue(row, col++, CommonUtil.checkNull(production.getRollID()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, CommonUtil.checkNull(production.getGradeCode()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, CommonUtil.checkNull(production.getCustomerGradeCode()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, CommonUtil.checkNull(production.getRollNumber()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, CommonUtil.checkNull(production.getSetPosition()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, production.getWhiteWeight(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, production.getRedWeight(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, production.getRejectWeight(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, production.getDiam(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, production.getRwidth(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, production.getPly(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, production.getCoreSizeN(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++,  CommonUtil.checkNull(production.getCustomer()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++,  CommonUtil.checkNull(production.getWeightVar()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, production.getReelNumber1(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++,  CommonUtil.checkNull(production.getMachineRollID1()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, production.getReelWidth(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, production.getReelWeight(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			
			double val1=((Math.PI/4*((production.getDiam()*production.getDiam())-((production.getCoreSizeN()*production.getCoreSizeN()))))*production.getRwidth());
			workbookUtil.addValue(row, col++, CommonUtil.round(val1, 4), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			double val2=0;
			if(val1!=0){
				val2=production.getWhiteWeight()/val1;
			}
			workbookUtil.addValue(row, col++, CommonUtil.round(val2, 4), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			
			double reelAvg=getReelAvg(wrapperProductions,production.getReelNumber1());
			
			double val3=0;
			if(reelAvg!=0){
				val3=(val2/reelAvg)*100;
			}
			
			workbookUtil.addValue(row, col++, CommonUtil.round(val3, 2)+"%", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			
			
			if(val2>max){
				max=val2;
			}
			if(val2<min){
				min=val2;
			}
			
			avg+=val2;
			
			countRow++;
			
			noOfSets.add(production.getRollNumber());
			whiteWeight+=production.getWhiteWeight();
			reelWeight=production.getReelWeight();
			reelWidth=production.getReelWidth();
			rwidth+=production.getRwidth();
		}
		
		
		//Final Row
		if(wrapperProductions.size()>0){
			//Row -1 
			row++;
			workbookUtil.addValue(row, 4, "Number of Sets", Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			workbookUtil.addValue(row, 5, noOfSets.size(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			workbookUtil.addValue(row, 6, "Total", Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			workbookUtil.addValue(row, 7, whiteWeight, Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			double winderTrim=0;
			if(noOfSets.size()!=0){
				winderTrim=CommonUtil.round(rwidth/noOfSets.size(), 3);
			}
			workbookUtil.addValue(row, 9, "Winder Trim", Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			workbookUtil.addValue(row, 10, winderTrim, Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			workbookUtil.addValue(row, 15, "Reel Weight", Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			workbookUtil.addValue(row, 16, reelWeight, Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			workbookUtil.addValue(row, 20, "MIN", Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			workbookUtil.addValue(row, 21, CommonUtil.round(min, 4), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			//Row - 2
			row++;
			double recovery=0;
			if(reelWeight!=0){
				recovery=CommonUtil.round((whiteWeight/(reelWeight*2000))*100, 2);
			}
			workbookUtil.addValue(row, 6, "Recovery", Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			workbookUtil.addValue(row, 7, recovery+"%", Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			workbookUtil.addValue(row, 9, "Machine Trim", Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			workbookUtil.addValue(row, 10, reelWidth, Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			workbookUtil.addValue(row, 20, "MAX", Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			workbookUtil.addValue(row, 21, CommonUtil.round(max, 4), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			//Row -3
			row++;
			
			double trimLoss=0;
			if(reelWidth!=0){
				trimLoss=CommonUtil.round(((reelWidth-winderTrim)/reelWidth)*100, 2);
			}
			workbookUtil.addValue(row, 9, "Trim Loss", Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			workbookUtil.addValue(row, 10, trimLoss+"%", Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			workbookUtil.addValue(row, 20, "Avg", Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			workbookUtil.addValue(row, 21, CommonUtil.round(countRow>0?avg/countRow:0, 4), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
		}
		
		for (int i = 0; i <22; i++) {
			workbookUtil.setAutoSizeColumn(i);
		}
		
		workbookUtil.write(outputStream);
		
	}

	/**
	 * @param wrapperProductions
	 * @param reelNumber1
	 * @return
	 */
	private double getReelAvg(List<WrapperProduction> wrapperProductions,
			double reel) {
		
		int count=0;
		double total=0;
		for (WrapperProduction production : wrapperProductions) {
			if(production.getReelNumber1()==reel){
				double val1=((Math.PI/4*((production.getDiam()*production.getDiam())-((production.getCoreSizeN()*production.getCoreSizeN()))))*production.getRwidth());
				
				double val2=0;
				if(val1!=0){
					val2=production.getWhiteWeight()/val1;
				}
				
				total+=val2;
				count++;
			}
			
		}
		
		if(count>0){
			return CommonUtil.round(total/count, 4);
		}
		
		return 0;
	}

	/**
	 * @param datas
	 * @param outputStream
	 * @throws IOException 
	 */
	public void createExcelGradeAndHoursWithSummaryReport(
			List<Map<String, Object>> datas, OutputStream outputStream) throws IOException {
		Workbook2007Util workbookUtil=new Workbook2007Util();

		int row=0;
		int col=0;
		short rowHeight=280;
		
		workbookUtil.addValue(row, col++, "DateEntered", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, "Customer", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, "GradeCode", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, "Grade", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, "RollWidthSum", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, "White", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, "Red", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, "Total", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, "HoursSpent", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, "TonsPerHour", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, "TonsPerDay", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, "MachineSpeed", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, "Days", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, "BasisWeight", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, "FirstQuality", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, "MECalc", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, "TrimSum", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, "SpeedSum", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, "BwtSum", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		
	//	double whiteNapkinTotalRollWith=0;
	//	double whiteTowelTotalRollWith=0;
	//	double kraftNapkinTotalRollWith=0;
	//	double kraftTowelTotalRollWith=0;
		
		double whiteNapkinTotalWhite=0;
		double whiteTowelTotalWhite=0;
		double kraftNapkinTotalWhite=0;
		double kraftTowelTotalWhite=0;
		
		double whiteNapkinTotalRed=0;
		double whiteTowelTotalRed=0;
		double kraftNapkinTotalRed=0;
		double kraftTowelTotalRed=0;
		
		double whiteNapkinTotalHourSpent=0;
		double whiteTowelTotalHourSpent=0;
		double kraftNapkinTotalHourSpent=0;
		double kraftTowelTotalHourSpent=0;
		
		double whiteNapkinTotalTrimSum=0;
		double whiteTowelTotalTrimSum=0;
		double kraftNapkinTotalTrimSum=0;
		double kraftTowelTotalTrimSum=0;
		
		double whiteNapkinTotalSpeedSum=0;
		double whiteTowelTotalSpeedSum=0;
		double kraftNapkinTotalSpeedSum=0;
		double kraftTowelTotalSpeedSum=0;

		double whiteNapkinTotalBwtSum=0;
		double whiteTowelTotalBwtSum=0;
		double kraftNapkinTotalBwtSum=0;
		double kraftTowelTotalBwtSum=0;

		
		
		for (Map<String, Object> map : datas) {
			
			String gradeCode=map.get("GradeCode").toString();
			
			if(StringUtils.isEmpty(gradeCode)){
				continue;
			}
			
			row++;
			col=0;
			
			
			
			
			String grade=CommonUtil.getGradeFromGradeCode(gradeCode);
			double rollWithSum=CommonUtil.checkDouble(map.get("RollWidthSum").toString());
			double white=CommonUtil.checkDouble(map.get("WhiteGross").toString());
			double red=CommonUtil.checkDouble(map.get("RedGross").toString());
			double total=white+red;
			double hoursSpent=CommonUtil.checkDouble(map.get("HoursSpent").toString());
			double tonsPerHour=0;
			if(hoursSpent!=0){
				tonsPerHour=CommonUtil.round(total/hoursSpent, 2);
			}
			double tonsPerDay=CommonUtil.round(tonsPerHour*24, 2);
			
			double machineSpeed=CommonUtil.checkDouble(map.get("MachineSpeed").toString());
			
			double days=CommonUtil.round(hoursSpent/24, 2);
			
			
			
			double basisWeight=CommonUtil.checkDouble(gradeCode.substring(0,3))/10;
			
			double firstQuality=0;
			if(total!=0){
				firstQuality=CommonUtil.round((white/total)*100, 2);
			}

			double meCalc=0;
			if((machineSpeed*basisWeight)!=0){
				meCalc=CommonUtil.round((tonsPerDay/(machineSpeed*basisWeight*306/(1+0.09)/50000))*100, 2);
			}

			double trimSum=CommonUtil.round(rollWithSum*hoursSpent, 2);
			double speedSum=CommonUtil.round(machineSpeed*hoursSpent, 0);
			
			double bwtSum=CommonUtil.round(basisWeight*hoursSpent, 2);

			
			if(grade.equals(CommonUtil.WHITE_NAPKIN)){
				whiteNapkinTotalWhite+=white;
				whiteNapkinTotalRed+=red;
				whiteNapkinTotalHourSpent+=hoursSpent;
				whiteNapkinTotalTrimSum+=trimSum;
				whiteNapkinTotalSpeedSum+=speedSum;
				whiteNapkinTotalBwtSum+=bwtSum;
				
			
				
			}else if(grade.equals(CommonUtil.WHITE_TOWEL)){
				whiteTowelTotalWhite+=white;
				whiteTowelTotalRed+=red;
				whiteTowelTotalHourSpent+=hoursSpent;
				whiteTowelTotalTrimSum+=trimSum;
				whiteTowelTotalSpeedSum+=speedSum;
				whiteTowelTotalBwtSum+=bwtSum;
				
				
				
			}else if(grade.equals(CommonUtil.KRAFT_NAPKIN)){
				kraftNapkinTotalWhite+=white;
				kraftNapkinTotalRed+=red;
				kraftNapkinTotalHourSpent+=hoursSpent;
				kraftNapkinTotalTrimSum+=trimSum;
				kraftNapkinTotalSpeedSum+=speedSum;
				kraftNapkinTotalBwtSum+=bwtSum;
				
				
				
			}else if(grade.equals(CommonUtil.KRAFT_TOWEL)){
				kraftTowelTotalWhite+=white;
				kraftTowelTotalRed+=red;
				kraftTowelTotalHourSpent+=hoursSpent;
				kraftTowelTotalTrimSum+=trimSum;
				kraftTowelTotalSpeedSum+=speedSum;
				kraftTowelTotalBwtSum+=bwtSum;
				
				
			}
					
			
			workbookUtil.addValue(row, col++, map.get("DateEntered"), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, map.get("Customer"), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, map.get("GradeCode"), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, grade, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, rollWithSum, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, white, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, red, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, total, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, hoursSpent, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, tonsPerHour, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, tonsPerDay, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, machineSpeed, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, days, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, basisWeight, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, firstQuality+"%", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, meCalc+"%", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, trimSum, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, speedSum, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, bwtSum, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		}
	
		

		row=row+2;
		{
			col=3;
			workbookUtil.addValue(row, col++,"Summary", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, "RollWidthSum", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, "White", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, "Red", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, "Total", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, "HoursSpent", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, "TonsPerHour", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, "TonsPerDay", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, "MachineSpeed", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, "Days", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, "BasisWeight", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, "FirstQuality", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, "MECalc", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, "TrimLossTons", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, "TrimLossPct", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
			
		}
		//White Napkin
		{
			row++;
			col=3;
			
			double whiteNapkinTotalRollWith=0;
			if(whiteNapkinTotalHourSpent>0){
				whiteNapkinTotalRollWith=CommonUtil.round(whiteTowelTotalTrimSum/whiteNapkinTotalHourSpent, 2);
			}
			
			double napkinTotal=whiteNapkinTotalWhite+whiteNapkinTotalRed;
			
			
			double tonsPerHour=0;
			if(whiteNapkinTotalHourSpent!=0){
				tonsPerHour=CommonUtil.round(napkinTotal/whiteNapkinTotalHourSpent, 2);
			}
			double tonsPerDay=CommonUtil.round(tonsPerHour*24, 2);
			
			double machineSpeed=0;
			if(whiteNapkinTotalHourSpent!=0){
				machineSpeed=CommonUtil.round(whiteNapkinTotalSpeedSum/whiteNapkinTotalHourSpent, 2);
			}
			
			double days=CommonUtil.round(whiteNapkinTotalHourSpent/24, 2);
			
			
			
			double basisWeight=0;
			if(whiteNapkinTotalHourSpent!=0){
				basisWeight=CommonUtil.round(whiteNapkinTotalBwtSum/whiteNapkinTotalHourSpent, 2);
			}
			
			
			double firstQuality=0;
			if(napkinTotal!=0){
				firstQuality=CommonUtil.round((whiteNapkinTotalWhite/napkinTotal)*100, 2);
			}

			double meCalc=0;
			if((machineSpeed*basisWeight)!=0){
				meCalc=CommonUtil.round((tonsPerDay/(machineSpeed*basisWeight*306/(1+0.09)/50000))*100, 2);
			}
			
			double trimLossTon=0;
			if(whiteNapkinTotalRollWith>0){
				trimLossTon=CommonUtil.round(napkinTotal*306/whiteNapkinTotalRollWith-napkinTotal, 2);
			}
			
			double trimLossPrec=CommonUtil.round((1-whiteNapkinTotalRollWith/306)*100, 2);
			
			
			workbookUtil.addValue(row, col++, "White Napkin", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, whiteNapkinTotalRollWith, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, whiteNapkinTotalWhite, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, whiteNapkinTotalRed, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, napkinTotal, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, whiteNapkinTotalHourSpent, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, tonsPerHour, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, tonsPerDay, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, machineSpeed, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, days, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, basisWeight, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, firstQuality+"%", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, meCalc+"%", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, trimLossTon, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, trimLossPrec+"%", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		//	workbookUtil.addValue(row, col++, whiteNapkinTotalBwtSum, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			
		}
		
		//Kraft Napkin
		{
			row++;
			col=3;
			
			double kraftNapkinTotalRollWith=0;
			if(kraftNapkinTotalHourSpent>0){
				kraftNapkinTotalRollWith=CommonUtil.round(kraftNapkinTotalTrimSum/kraftNapkinTotalHourSpent, 2);
			}
			
			double napkinTotal=kraftNapkinTotalWhite+kraftNapkinTotalRed;
			
			double tonsPerHour=0;
			if(kraftNapkinTotalHourSpent!=0){
				tonsPerHour=CommonUtil.round(napkinTotal/kraftNapkinTotalHourSpent, 2);
			}
			double tonsPerDay=CommonUtil.round(tonsPerHour*24, 2);
			
			
			double machineSpeed=0;
			if(kraftNapkinTotalHourSpent!=0){
				machineSpeed=CommonUtil.round(kraftNapkinTotalSpeedSum/kraftNapkinTotalHourSpent, 2);
			}
			
			double days=CommonUtil.round(kraftNapkinTotalHourSpent/24, 2);
			
			
			
			double basisWeight=0;
			if(kraftNapkinTotalHourSpent!=0){
				basisWeight=CommonUtil.round(kraftNapkinTotalBwtSum/kraftNapkinTotalHourSpent, 2);
			}
			
			
			double firstQuality=0;
			if(napkinTotal!=0){
				firstQuality=CommonUtil.round((kraftNapkinTotalWhite/napkinTotal)*100, 2);
			}

			double meCalc=0;
			if((machineSpeed*basisWeight)!=0){
				meCalc=CommonUtil.round((tonsPerDay/(machineSpeed*basisWeight*306/(1+0.09)/50000))*100, 2);
			}
			
			double trimLossTon=0;
			if(kraftNapkinTotalRollWith>0){
				trimLossTon=CommonUtil.round(napkinTotal*306/kraftNapkinTotalRollWith-napkinTotal, 2);
			}
			
			double trimLossPrec=CommonUtil.round((1-kraftNapkinTotalRollWith/306)*100, 2);
			
			
			workbookUtil.addValue(row, col++, "Kraft Napkin", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, kraftNapkinTotalRollWith, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, kraftNapkinTotalWhite, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, kraftNapkinTotalRed, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, napkinTotal, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, kraftNapkinTotalHourSpent, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, tonsPerHour, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, tonsPerDay, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, machineSpeed, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, days, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, basisWeight, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, firstQuality+"%", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, meCalc+"%", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, trimLossTon, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, trimLossPrec+"%", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		//	workbookUtil.addValue(row, col++, kraftNapkinTotalBwtSum, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			
		}
		
		
		//White Towel
		{
			row++;
			col=3;
			
			double whiteTowelTotalRollWith=0;
			if(whiteTowelTotalHourSpent>0){
				whiteTowelTotalRollWith=CommonUtil.round(whiteTowelTotalTrimSum/whiteTowelTotalHourSpent, 2);
			}
			
			double towelTotal=whiteTowelTotalWhite+whiteTowelTotalRed;
			
			double tonsPerHour=0;
			if(whiteTowelTotalHourSpent!=0){
				tonsPerHour=CommonUtil.round(towelTotal/whiteTowelTotalHourSpent, 2);
			}
			double tonsPerDay=CommonUtil.round(tonsPerHour*24, 2);
			
			double machineSpeed=0;
			if(whiteTowelTotalHourSpent!=0){
				machineSpeed=CommonUtil.round(whiteTowelTotalSpeedSum/whiteTowelTotalHourSpent, 2);
			}
			
			double days=CommonUtil.round(whiteTowelTotalHourSpent/24, 2);
			
			
			
			double basisWeight=0;
			if(whiteTowelTotalHourSpent!=0){
				basisWeight=CommonUtil.round(whiteTowelTotalBwtSum/whiteTowelTotalHourSpent, 2);
			}
			
			
			double firstQuality=0;
			if(towelTotal!=0){
				firstQuality=CommonUtil.round((whiteTowelTotalWhite/towelTotal)*100, 2);
			}

			double meCalc=0;
			if((machineSpeed*basisWeight)!=0){
				meCalc=CommonUtil.round((tonsPerDay/(machineSpeed*basisWeight*306/(1+0.09)/50000))*100, 2);
			}
			
			double trimLossTon=0;
			if(whiteTowelTotalRollWith>0){
				trimLossTon=CommonUtil.round(towelTotal*306/whiteTowelTotalRollWith-towelTotal, 2);
			}
			
			double trimLossPrec=CommonUtil.round((1-whiteTowelTotalRollWith/306)*100, 2);
			
			
			workbookUtil.addValue(row, col++, "White Towel", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, whiteTowelTotalRollWith, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, whiteTowelTotalWhite, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, whiteTowelTotalRed, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, towelTotal, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, whiteTowelTotalHourSpent, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, tonsPerHour, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, tonsPerDay, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, machineSpeed, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, days, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, basisWeight, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, firstQuality+"%", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, meCalc+"%", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, trimLossTon, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, trimLossPrec+"%", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		//	workbookUtil.addValue(row, col++, whiteTowelTotalBwtSum, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			
		}
		
		//Kraft Towel
		{
			row++;
			col=3;
			
			double kraftTowelTotalRollWith=0;
			if(kraftTowelTotalHourSpent>0){
				kraftTowelTotalRollWith=CommonUtil.round(kraftTowelTotalTrimSum/kraftTowelTotalHourSpent, 2);
			}
			
			double towelTotal=kraftTowelTotalWhite+kraftTowelTotalRed;
			
			double tonsPerHour=0;
			if(kraftTowelTotalHourSpent!=0){
				tonsPerHour=CommonUtil.round(towelTotal/kraftTowelTotalHourSpent, 2);
			}
			double tonsPerDay=CommonUtil.round(tonsPerHour*24, 2);
			
			double machineSpeed=0;
			if(kraftTowelTotalHourSpent!=0){
				machineSpeed=CommonUtil.round(kraftTowelTotalSpeedSum/kraftTowelTotalHourSpent, 2);
			}
			
			double days=CommonUtil.round(kraftTowelTotalHourSpent/24, 2);
			
			
			
			double basisWeight=0;
			if(kraftTowelTotalHourSpent!=0){
				basisWeight=CommonUtil.round(kraftTowelTotalBwtSum/kraftTowelTotalHourSpent, 2);
			}
			
			
			double firstQuality=0;
			if(towelTotal!=0){
				firstQuality=CommonUtil.round((kraftTowelTotalWhite/towelTotal)*100, 2);
			}

			double meCalc=0;
			if((machineSpeed*basisWeight)!=0){
				meCalc=CommonUtil.round((tonsPerDay/(machineSpeed*basisWeight*306/(1+0.09)/50000))*100, 2);
			}
			
			double trimLossTon=0;
			if(kraftTowelTotalRollWith>0){
				trimLossTon=CommonUtil.round(towelTotal*306/kraftTowelTotalRollWith-towelTotal, 2);
			}
			
			double trimLossPrec=CommonUtil.round((1-kraftTowelTotalRollWith/306)*100, 2);
			
			workbookUtil.addValue(row, col++, "Kraft Towel", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, kraftTowelTotalRollWith, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, kraftTowelTotalWhite, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, kraftTowelTotalRed, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, towelTotal, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, kraftTowelTotalHourSpent, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, tonsPerHour, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, tonsPerDay, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, machineSpeed, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, days, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, basisWeight, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, firstQuality+"%", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, meCalc+"%", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, trimLossTon, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, trimLossPrec+"%", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		//	workbookUtil.addValue(row, col++, kraftTowelTotalBwtSum, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			
		}
		
		
		row++;
		
		//All Napkin
		{
			row++;
			col=3;
			
			double allNapkinTotalRollWith=0;
			if((whiteNapkinTotalHourSpent+kraftNapkinTotalHourSpent)>0){
				allNapkinTotalRollWith=CommonUtil.round((whiteNapkinTotalTrimSum+kraftNapkinTotalTrimSum)/(whiteNapkinTotalHourSpent+kraftNapkinTotalHourSpent), 2);
			}
			
			
			double napkinTotal=whiteNapkinTotalWhite+whiteNapkinTotalRed+kraftNapkinTotalWhite+kraftNapkinTotalRed;
			
			double tonsPerHour=0;
			if((whiteNapkinTotalHourSpent+kraftNapkinTotalHourSpent)!=0){
				tonsPerHour=CommonUtil.round(napkinTotal/(whiteNapkinTotalHourSpent+kraftNapkinTotalHourSpent), 2);
			}
			double tonsPerDay=CommonUtil.round(tonsPerHour*24, 2);
			
			double machineSpeed=0;
			if((whiteNapkinTotalHourSpent+kraftNapkinTotalHourSpent)!=0){
				machineSpeed=CommonUtil.round((whiteNapkinTotalSpeedSum+kraftNapkinTotalSpeedSum)/(whiteNapkinTotalHourSpent+kraftNapkinTotalHourSpent), 2);
			}
			
			double days=CommonUtil.round((whiteNapkinTotalHourSpent+kraftNapkinTotalHourSpent)/24, 2);
			
			
			
			double basisWeight=0;
			if((whiteNapkinTotalHourSpent+kraftNapkinTotalHourSpent)!=0){
				basisWeight=CommonUtil.round((whiteNapkinTotalBwtSum+kraftNapkinTotalBwtSum)/(whiteNapkinTotalHourSpent+kraftNapkinTotalHourSpent), 2);
			}
			
			
			double firstQuality=0;
			if(napkinTotal!=0){
				firstQuality=CommonUtil.round(((whiteNapkinTotalWhite+kraftNapkinTotalWhite)/napkinTotal)*100, 2);
			}

			double meCalc=0;
			if((machineSpeed*basisWeight)!=0){
				meCalc=CommonUtil.round((tonsPerDay/(machineSpeed*basisWeight*306/(1+0.09)/50000))*100, 2);
			}
			
			double trimLossTon=0;
			if(allNapkinTotalRollWith>0){
				trimLossTon=CommonUtil.round(napkinTotal*306/allNapkinTotalRollWith-napkinTotal, 2);
			}
			
			double trimLossPrec=CommonUtil.round((1-allNapkinTotalRollWith/306)*100, 2);
			
			
			workbookUtil.addValue(row, col++, "All Napkin", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, allNapkinTotalRollWith, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, whiteNapkinTotalWhite+kraftNapkinTotalWhite, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, whiteNapkinTotalRed+kraftNapkinTotalRed, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, napkinTotal, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, whiteNapkinTotalHourSpent+kraftNapkinTotalHourSpent, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, tonsPerHour, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, tonsPerDay, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, machineSpeed, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, days, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, basisWeight, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, firstQuality+"%", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, meCalc+"%", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, trimLossTon, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, trimLossPrec+"%", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		//	workbookUtil.addValue(row, col++, whiteNapkinTotalBwtSum+kraftNapkinTotalBwtSum, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			
		}
		
		//All Towel
		{
			row++;
			col=3;
			
			double allTowelTotalRollWith=0;
			if((whiteTowelTotalHourSpent+kraftTowelTotalHourSpent)>0){
				allTowelTotalRollWith=CommonUtil.round((whiteTowelTotalTrimSum+kraftTowelTotalTrimSum)/(whiteTowelTotalHourSpent+kraftTowelTotalHourSpent), 2);
			}
			
			double towelTotal=whiteTowelTotalWhite+whiteTowelTotalRed+kraftTowelTotalWhite+kraftTowelTotalRed;
			
			double tonsPerHour=0;
			if((whiteTowelTotalHourSpent+kraftTowelTotalHourSpent)!=0){
				tonsPerHour=CommonUtil.round(towelTotal/(whiteTowelTotalHourSpent+kraftTowelTotalHourSpent), 2);
			}
			double tonsPerDay=CommonUtil.round(tonsPerHour*24, 2);
			
			double machineSpeed=0;
			if((whiteTowelTotalHourSpent+kraftTowelTotalHourSpent)!=0){
				machineSpeed=CommonUtil.round((whiteTowelTotalSpeedSum+kraftTowelTotalSpeedSum)/(whiteTowelTotalHourSpent+kraftTowelTotalHourSpent), 2);
			}
			
			double days=CommonUtil.round((whiteTowelTotalHourSpent+kraftTowelTotalHourSpent)/24, 2);
			
			
			
			double basisWeight=0;
			if((whiteTowelTotalHourSpent+kraftTowelTotalHourSpent)!=0){
				basisWeight=CommonUtil.round((whiteTowelTotalBwtSum+kraftTowelTotalBwtSum)/(whiteTowelTotalHourSpent+kraftTowelTotalHourSpent), 2);
			}
			
			
			double firstQuality=0;
			if(towelTotal!=0){
				firstQuality=CommonUtil.round(((whiteTowelTotalWhite+kraftTowelTotalWhite)/towelTotal)*100, 2);
			}

			double meCalc=0;
			if((machineSpeed*basisWeight)!=0){
				meCalc=CommonUtil.round((tonsPerDay/(machineSpeed*basisWeight*306/(1+0.09)/50000))*100, 2);
			}
			
			double trimLossTon=0;
			if(allTowelTotalRollWith>0){
				trimLossTon=CommonUtil.round(towelTotal*306/allTowelTotalRollWith-towelTotal, 2);
			}
			
			double trimLossPrec=CommonUtil.round((1-allTowelTotalRollWith/306)*100, 2);
			
			
			workbookUtil.addValue(row, col++, "All Towel", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, allTowelTotalRollWith, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, whiteTowelTotalWhite+kraftTowelTotalWhite, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, whiteTowelTotalRed+kraftTowelTotalRed, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, towelTotal, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, whiteTowelTotalHourSpent+kraftTowelTotalHourSpent, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, tonsPerHour, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, tonsPerDay, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, machineSpeed, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, days, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, basisWeight, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, firstQuality+"%", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, meCalc+"%", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, trimLossTon, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, trimLossPrec+"%", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		//	workbookUtil.addValue(row, col++, whiteTowelTotalBwtSum+kraftTowelTotalBwtSum, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			
			
			
		}
		{
			row=row+3;
			col=3;
		//Code Starts From Here Done By Roshan Tailor Date:- 08/02/2016 MM/DD/YYYY
			workbookUtil.addValue(row, col++, "Grade", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, "Tons Per Day", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, "Days", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
			
			col=3;
			row++;
				double tonsPerHour7=0;
				double napkinTotal=whiteNapkinTotalWhite+whiteNapkinTotalRed;
				if(whiteNapkinTotalHourSpent!=0){
					tonsPerHour7=CommonUtil.round(napkinTotal/whiteNapkinTotalHourSpent, 2);
				}
				double tonsPerDay7=CommonUtil.round(tonsPerHour7*24, 2);
				double days7=CommonUtil.round(whiteNapkinTotalHourSpent/24, 2);
			workbookUtil.addValue(row, col++, "White Napkin", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, tonsPerDay7, Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, days7, Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
			
			row++;
			col=3;
			double napkinTotal1=kraftNapkinTotalWhite+kraftNapkinTotalRed;
			
			double tonsPerHour2=0;
			if(kraftNapkinTotalHourSpent!=0){
				tonsPerHour2=CommonUtil.round(napkinTotal1/kraftNapkinTotalHourSpent, 2);
			}
			double tonsPerDay1=CommonUtil.round(tonsPerHour2*24, 2);
			double days1=CommonUtil.round(kraftNapkinTotalHourSpent/24, 2);
			workbookUtil.addValue(row, col++, "Kraft Napkin", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, tonsPerDay1, Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, days1, Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
			
			row++;
			col=3;
			double towelTotal=whiteTowelTotalWhite+whiteTowelTotalRed;
			
			double tonsPerHour3=0;
			if(whiteTowelTotalHourSpent!=0){
				tonsPerHour3=CommonUtil.round(towelTotal/whiteTowelTotalHourSpent, 2);
			}
			double tonsPerDay3=CommonUtil.round(tonsPerHour3*24, 2);
			double days3=CommonUtil.round(whiteTowelTotalHourSpent/24, 2);
			workbookUtil.addValue(row, col++, "White Towel", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, tonsPerDay3, Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, days3, Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
			
			row++;
			col=3;
			double towelTotal4=kraftTowelTotalWhite+kraftTowelTotalRed;
			
			double tonsPerHour4=0;
			if(kraftTowelTotalHourSpent!=0){
				tonsPerHour4=CommonUtil.round(towelTotal4/kraftTowelTotalHourSpent, 2);
			}
			double tonsPerDay4=CommonUtil.round(tonsPerHour4*24, 2);
			double days4=CommonUtil.round(kraftTowelTotalHourSpent/24, 2);
			workbookUtil.addValue(row, col++, "Kraft Towel", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, tonsPerDay4, Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, days4, Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
			
			row = row+2;
			col=3;
			double napkinTotal5=whiteNapkinTotalWhite+whiteNapkinTotalRed+kraftNapkinTotalWhite+kraftNapkinTotalRed;
			
			double tonsPerHour5=0;
			if((whiteNapkinTotalHourSpent+kraftNapkinTotalHourSpent)!=0){
				tonsPerHour5=CommonUtil.round(napkinTotal5/(whiteNapkinTotalHourSpent+kraftNapkinTotalHourSpent), 2);
			}
			double tonsPerDay5=CommonUtil.round(tonsPerHour5*24, 2);
			double days5=CommonUtil.round((whiteNapkinTotalHourSpent+kraftNapkinTotalHourSpent)/24, 2);
			workbookUtil.addValue(row, col++, "All Napkin", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, tonsPerDay5, Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, days5, Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
			
			row++;
			col=3;
			double towelTotal6=whiteTowelTotalWhite+whiteTowelTotalRed+kraftTowelTotalWhite+kraftTowelTotalRed;
			
			double tonsPerHour6=0;
			if((whiteTowelTotalHourSpent+kraftTowelTotalHourSpent)!=0){
				tonsPerHour6=CommonUtil.round(towelTotal6/(whiteTowelTotalHourSpent+kraftTowelTotalHourSpent), 2);
			}
			double tonsPerDay6=CommonUtil.round(tonsPerHour6*24, 2);
			double days6=CommonUtil.round((whiteTowelTotalHourSpent+kraftTowelTotalHourSpent)/24, 2);
			workbookUtil.addValue(row, col++, "All Towel", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, tonsPerDay6, Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, days6, Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
			
			
		//Code Ends Here Done By Roshan Tailor Date :- 08/02/2016
		}

		for (int i = 0; i < 17; i++) {
			workbookUtil.setAutoSizeColumn(i);
		}
		
		workbookUtil.freez(1, 1);
		
		workbookUtil.write(outputStream);
	}

	/**
	 * @param datas
	 * @param file 
	 * @param sdate
	 * @param edate
	 * @param outputStream
	 * @return
	 * @throws IOException 
	 */
	public HSSFWorkbook createExcelPM6PRODUCTIONREPORT(
			List<Map<String, String>> datas, File file, Date sdate, Date edate,
			FileOutputStream outputStream) throws IOException {
		
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
		sheet.setColumnWidth(19, 9000);
		
		
		
		sheet.getRow(0).getCell(0).setCellValue("PM6 Production Report For - "+dateFormat1.format(sdate)+"-"+dateFormat1.format(edate));
		
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
			int days=(int)CommonUtil.getDaysDiffernce(sdate, edate);
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
			
			int days=(int)CommonUtil.getDaysDiffernce(sdate, edate);
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



}

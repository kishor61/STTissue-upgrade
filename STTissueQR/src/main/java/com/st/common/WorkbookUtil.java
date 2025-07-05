/**
 * 
 */
package com.st.common;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.BorderStyle;
//import org.apache.poi.hssf.util.HSSFRegionUtil;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * @author sbora
 *
 */
public class WorkbookUtil {
		/**public static void mergeCell(HSSFWorkbook workbook,int sheet,int rowFrom,int rowTo,int colFrom,int colTo){
			CellRangeAddress rangeAddress=new CellRangeAddress(rowFrom, rowTo, colFrom, colTo);
			HSSFSheet sheet2=workbook.getSheetAt(sheet);
			sheet2.addMergedRegion(rangeAddress);
			
			
			XSSFRegionUtil.setBorderTop(BorderStyle.THIN, rangeAddress, sheet2, workbook);
			XSSFRegionUtil.setBorderBottom(BorderStyle.THIN, rangeAddress, sheet2, workbook);
			XSSFRegionUtil.setBorderLeft(BorderStyle.THIN, rangeAddress, sheet2, workbook);
			XSSFRegionUtil.setBorderRight(BorderStyle.THIN, rangeAddress, sheet2, workbook);
		}**/
	
	
	 public static void mergeCell(HSSFWorkbook workbook, int sheetIndex, int rowFrom, int rowTo, int colFrom, int colTo) {
	        HSSFSheet sheet = workbook.getSheetAt(sheetIndex);
	        
	        // Create a range for merging cells
	        CellRangeAddress rangeAddress = new CellRangeAddress(rowFrom, rowTo, colFrom, colTo);
	        sheet.addMergedRegion(rangeAddress);

	        // Create a CellStyle for borders
	        HSSFCellStyle cellStyle = workbook.createCellStyle();
	        cellStyle.setBorderTop(BorderStyle.THIN);
	        cellStyle.setBorderBottom(BorderStyle.THIN);
	        cellStyle.setBorderLeft(BorderStyle.THIN);
	        cellStyle.setBorderRight(BorderStyle.THIN);

	        // Apply borders to the first cell in the merged region
	        sheet.getRow(rowFrom).getCell(colFrom).setCellStyle(cellStyle);

	        // Manually set borders for each cell in the merged region
	        for (int row = rowFrom; row <= rowTo; row++) {
	            for (int col = colFrom; col <= colTo; col++) {
	                sheet.getRow(row).getCell(col).setCellStyle(cellStyle);
	            }
	        }
	    }
	
	private static HSSFCellStyle getCellStyle(HSSFWorkbook workbook){
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
		return rowCellStyle;
	}
	private static HSSFCellStyle getCellStyleRed(HSSFWorkbook workbook){
		Font fontRow=workbook.createFont();
		fontRow.setBold(false);
		fontRow.setColor(IndexedColors.BLACK.getIndex());
		HSSFCellStyle rowCellStyle=workbook.createCellStyle();
		rowCellStyle.setBorderBottom(BorderStyle.THIN);
		rowCellStyle.setBorderLeft(BorderStyle.THIN);
		rowCellStyle.setBorderRight(BorderStyle.THIN);
		rowCellStyle.setBorderTop(BorderStyle.THIN);
		rowCellStyle.setFont(fontRow);
		rowCellStyle.setFillForegroundColor(IndexedColors.RED.getIndex());
		rowCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		rowCellStyle.setAlignment(HorizontalAlignment.CENTER);
		rowCellStyle.setVerticalAlignment(VerticalAlignment.TOP);
		rowCellStyle.setWrapText(true);
		
		return rowCellStyle;
	}
	
	private static HSSFCellStyle getCellStyleLeft(HSSFWorkbook workbook){
		Font fontRow=workbook.createFont();
		fontRow.setBold(false);
		fontRow.setColor(IndexedColors.BLACK.getIndex());
		HSSFCellStyle rowCellStyle=workbook.createCellStyle();
		rowCellStyle.setBorderBottom(BorderStyle.THIN);
		rowCellStyle.setBorderLeft(BorderStyle.THIN);
		rowCellStyle.setBorderRight(BorderStyle.THIN);
		rowCellStyle.setBorderTop(BorderStyle.THIN);
		rowCellStyle.setFont(fontRow);
		rowCellStyle.setAlignment(HorizontalAlignment.LEFT);
		rowCellStyle.setVerticalAlignment(VerticalAlignment.TOP);
		rowCellStyle.setWrapText(true);
		return rowCellStyle;
	}
	private static HSSFCellStyle getCellStyleRight(HSSFWorkbook workbook){
		Font fontRow=workbook.createFont();
		fontRow.setBold(false);
		fontRow.setColor(IndexedColors.BLACK.getIndex());
		HSSFCellStyle rowCellStyle=workbook.createCellStyle();
		rowCellStyle.setBorderBottom(BorderStyle.THIN);
		rowCellStyle.setBorderLeft(BorderStyle.THIN);
		rowCellStyle.setBorderRight(BorderStyle.THIN);
		rowCellStyle.setBorderTop(BorderStyle.THIN);
		rowCellStyle.setFont(fontRow);
		rowCellStyle.setAlignment(HorizontalAlignment.RIGHT);
		rowCellStyle.setVerticalAlignment(VerticalAlignment.TOP);
		rowCellStyle.setWrapText(true);
		return rowCellStyle;
	}
	
	private static HSSFCellStyle getCellStyleHeader(HSSFWorkbook workbook){
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
		return objectCellStyle;
	}
	
	private static HSSFCellStyle getCellStyleFooter(HSSFWorkbook workbook){
		Font objectFont2=workbook.createFont();
		objectFont2.setBold(false);
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
		return objectCellStyle2;
	}
	
	public static void createCell(HSSFWorkbook workbook,HSSFRow row,String value,int col){
		HSSFCell cell=row.createCell(col);
		cell.setCellStyle(getCellStyle(workbook));
		cell.setCellValue(value);
	}
	public static void createCellLeft(HSSFWorkbook workbook,HSSFRow row,String value,int col){
		HSSFCell cell=row.createCell(col);
		cell.setCellStyle(getCellStyleLeft(workbook));
		cell.setCellValue(value);
	}
	public static void createCellRight(HSSFWorkbook workbook,HSSFRow row,String value,int col){
		HSSFCell cell=row.createCell(col);
		cell.setCellStyle(getCellStyleRight(workbook));
		cell.setCellValue(value);
	}
	public static void createCellRed(HSSFWorkbook workbook,HSSFRow row,String value,int col){
		HSSFCell cell=row.createCell(col);
		cell.setCellStyle(getCellStyleRed(workbook));
		cell.setCellValue(value);
	}
	
	public static void createCell(HSSFWorkbook workbook,HSSFRow row,double value,int col){
		HSSFCell cell=row.createCell(col);
		cell.setCellStyle(getCellStyle(workbook));
		cell.setCellValue(value);
	}
	public static void createCellLeft(HSSFWorkbook workbook,HSSFRow row,double value,int col){
		HSSFCell cell=row.createCell(col);
		cell.setCellStyle(getCellStyleLeft(workbook));
		cell.setCellValue(value);
	}
	public static void createCellRight(HSSFWorkbook workbook,HSSFRow row,double value,int col){
		HSSFCell cell=row.createCell(col);
		cell.setCellStyle(getCellStyleRight(workbook));
		cell.setCellValue(value);
	}
	public static void createCellRed(HSSFWorkbook workbook,HSSFRow row,double value,int col){
		HSSFCell cell=row.createCell(col);
		cell.setCellStyle(getCellStyleRed(workbook));
		cell.setCellValue(value);
	}
	
	
	
	public static void createCellHeader(HSSFWorkbook workbook,HSSFRow row,String value,int col){
		HSSFCell cell=row.createCell(col);
		cell.setCellStyle(getCellStyleHeader(workbook));
		cell.setCellValue(value);
	}
	
	
	public static void createCellFooter(HSSFWorkbook workbook,HSSFRow row,String value,int col){
		HSSFCell cell=row.createCell(col);
		cell.setCellStyle(getCellStyleFooter(workbook));
		cell.setCellValue(value);
	}
}

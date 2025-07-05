/**
 * 
 */
package com.st.common;

import java.awt.Color;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.commons.io.IOUtils;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.RegionUtil;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFClientAnchor;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFDrawing;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFPicture;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.BorderStyle; // Import this enum
/**
 * @author sbora
 *
 */
public class Workbook2007Util {
	
	
	
	private XSSFWorkbook workbook;

	
	private XSSFCellStyle cellStyleHeader01;
	private XSSFCellStyle cellStyleNormalCenter;
	private XSSFCellStyle cellStyleNormalLeft;
	private XSSFCellStyle cellStyleNormalRight;
	private XSSFCellStyle cellStyleBoldCenter;
	private XSSFCellStyle cellStyleBoldLeft;
	
	private XSSFCellStyle cellStyleNormalCenterOrange;
	private XSSFCellStyle cellStyleNormalCenterRed;
	private XSSFCellStyle cellStyleNormalCenterGreen;
	
	//Code Strats From Here Done By Roshan Tailor
	private XSSFCellStyle cellStyleNormalCenterYellow;
	private XSSFCellStyle cellStyleNormalCenterSkyColor;
	private XSSFCellStyle cellStyleNormalCenterf5da81;
	//Code Ends HEre Done By Roshan Tailor
	
	private XSSFCellStyle cellStyleNormalCenterNoneBorder;
	private XSSFCellStyle cellStyleNormalLeftNoneBorder;
	
	private XSSFCellStyle cellStyleBoldJustify;
	private XSSFSheet sheet;
	
	private XSSFCellStyle cellStyleNormalCenterGrayColor;
	/**
	 * @throws IOException 
	 * 
	 */
	
	public Workbook2007Util(File file,int sheetNo) throws IOException {
		FileInputStream inputStream=new FileInputStream(file);
		this.workbook=new XSSFWorkbook(inputStream);
		sheet=workbook.getSheetAt(sheetNo);
		initStyle();
	}
	public Workbook2007Util(){
		this.workbook=new XSSFWorkbook();
		sheet=workbook.createSheet();
		
		initStyle();
	}
	public void setSheetName(String name,int sheetNo){
		workbook.setSheetName(sheetNo, name);
	}
	public void freez(int col,int row){
		sheet.createFreezePane(col, row);
	}
	
	public XSSFWorkbook createlogo(InputStream inputStream,int col,int row) throws IOException {
        byte[] bytes = IOUtils.toByteArray(inputStream );
        int pictureIdx = workbook.addPicture(bytes, Workbook.PICTURE_TYPE_PNG);
        XSSFDrawing drawing = sheet.createDrawingPatriarch();
        XSSFClientAnchor anchor=new XSSFClientAnchor();
        anchor.setCol1(col);
        anchor.setRow1( row);
        XSSFPicture pict = drawing.createPicture(anchor, pictureIdx);
        pict.resize();
        
        return workbook;
 }

	
	private void initStyle(){
		
		//Bold Font Center
		XSSFFont fontHeader=workbook.createFont();
		fontHeader.setBold(true); // Set font to bold
		//fontHeader.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
		fontHeader.setColor(IndexedColors.BLACK.getIndex());
		cellStyleHeader01=workbook.createCellStyle();
		cellStyleHeader01.setBorderBottom(BorderStyle.THIN);
		cellStyleHeader01.setBorderLeft(BorderStyle.THIN);
		cellStyleHeader01.setBorderRight(BorderStyle.THIN);
		cellStyleHeader01.setBorderTop(BorderStyle.THIN);
		cellStyleHeader01.setFont(fontHeader);
		cellStyleHeader01.setAlignment(HorizontalAlignment.CENTER);
		cellStyleHeader01.setVerticalAlignment(VerticalAlignment.TOP);
		// Set the fill color (orange) using RGB byte array
        XSSFColor fillColor = new XSSFColor(new byte[]{(byte) 255, (byte) 165, 0});  // Orange RGB
		cellStyleHeader01.setFillForegroundColor(fillColor);
		cellStyleHeader01.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		cellStyleHeader01.setWrapText(true);
		
		
		//Bold XSSFFont Center
		XSSFFont fontBold=workbook.createFont();
		fontHeader.setBold(true);
		//fontBold.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
		fontBold.setColor(IndexedColors.BLACK.getIndex());
		cellStyleBoldCenter=workbook.createCellStyle();
		cellStyleBoldCenter.setBorderBottom(BorderStyle.THIN);
		cellStyleBoldCenter.setBorderLeft(BorderStyle.THIN);
		cellStyleBoldCenter.setBorderRight(BorderStyle.THIN);
		cellStyleBoldCenter.setBorderTop(BorderStyle.THIN);
		cellStyleBoldCenter.setFont(fontBold);
		cellStyleBoldCenter.setAlignment(HorizontalAlignment.CENTER);
		cellStyleBoldCenter.setVerticalAlignment(VerticalAlignment.TOP);
		cellStyleBoldCenter.setWrapText(true);
		
		
		cellStyleBoldLeft=workbook.createCellStyle();
		cellStyleBoldLeft.setBorderBottom(BorderStyle.THIN);
		cellStyleBoldLeft.setBorderLeft(BorderStyle.THIN);
		cellStyleBoldLeft.setBorderRight(BorderStyle.THIN);
		cellStyleBoldLeft.setBorderTop(BorderStyle.THIN);
		cellStyleBoldLeft.setFont(fontBold);
		//cellStyleBoldLeft.setAlignment(XSSFCellStyle.ALIGN_LEFT);
		cellStyleBoldLeft.setAlignment(HorizontalAlignment.LEFT);
		cellStyleBoldLeft.setVerticalAlignment(VerticalAlignment.TOP);
		cellStyleBoldLeft.setWrapText(true);
		
		
		
		//Normal XSSFFont Center
		XSSFFont fontNormal=workbook.createFont();
		//fontNormal.setBoldweight(XSSFFont.BOLDWEIGHT_NORMAL);
		fontHeader.setBold(true);
		fontNormal.setColor(IndexedColors.BLACK.getIndex());
		cellStyleNormalCenter=workbook.createCellStyle();
		cellStyleNormalCenter.setBorderBottom(BorderStyle.THIN);
		cellStyleNormalCenter.setBorderLeft(BorderStyle.THIN);
		cellStyleNormalCenter.setBorderRight(BorderStyle.THIN);
		cellStyleNormalCenter.setBorderTop(BorderStyle.THIN);
		cellStyleNormalCenter.setFont(fontNormal);
		cellStyleNormalCenter.setAlignment(HorizontalAlignment.CENTER);
		cellStyleNormalCenter.setVerticalAlignment(VerticalAlignment.TOP);
		cellStyleNormalCenter.setWrapText(true);
		
		//orange
		 cellStyleNormalCenterOrange=workbook.createCellStyle();
		 cellStyleNormalCenterOrange.setBorderBottom(BorderStyle.NONE);
		 cellStyleNormalCenterOrange.setBorderLeft(BorderStyle.NONE);
		 cellStyleNormalCenterOrange.setBorderRight(BorderStyle.NONE);
		 cellStyleNormalCenterOrange.setBorderTop(BorderStyle.NONE);
		 cellStyleNormalCenterOrange.setFont(fontNormal);
		 cellStyleNormalCenterOrange.setAlignment(HorizontalAlignment.CENTER);
		 cellStyleNormalCenterOrange.setVerticalAlignment(VerticalAlignment.CENTER);
		 cellStyleNormalCenterOrange.setWrapText(true);
		 //cellStyleNormalCenterOrange.setFillForegroundColor(new XSSFColor(new Color(191, 89, 21)));
		 //cellStyleNormalCenterOrange.setFillPattern(CellStyle.SOLID_FOREGROUND);
		// Set fill foreground color
		 cellStyleNormalCenterOrange.setFillForegroundColor(new XSSFColor(new Color(191, 89, 21), null));

		 // Set fill pattern to solid
		 cellStyleNormalCenterOrange.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		//Red
		cellStyleNormalCenterRed=workbook.createCellStyle();
		cellStyleNormalCenterRed.setBorderBottom(BorderStyle.THIN);
		cellStyleNormalCenterRed.setBorderLeft(BorderStyle.THIN);
		cellStyleNormalCenterRed.setBorderRight(BorderStyle.THIN);
		cellStyleNormalCenterRed.setBorderTop(BorderStyle.THIN);
		cellStyleNormalCenterRed.setFont(fontNormal);
		cellStyleNormalCenterRed.setAlignment(HorizontalAlignment.CENTER);
		cellStyleNormalCenterRed.setVerticalAlignment(VerticalAlignment.TOP);
		cellStyleNormalCenterRed.setWrapText(true);
		//cellStyleNormalCenterRed.setFillForegroundColor(new XSSFColor(new Color(255, 102, 102)));
		//cellStyleNormalCenterRed.setFillPattern(CellStyle.SOLID_FOREGROUND);
		// Set fill foreground color
		cellStyleNormalCenterRed.setFillForegroundColor(new XSSFColor(new Color(255, 102, 102), null));

		// Set fill pattern to solid
		cellStyleNormalCenterRed.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		//Green
		cellStyleNormalCenterGreen=workbook.createCellStyle();
		cellStyleNormalCenterGreen.setBorderBottom(BorderStyle.THIN);
		cellStyleNormalCenterGreen.setBorderLeft(BorderStyle.THIN);
		cellStyleNormalCenterGreen.setBorderRight(BorderStyle.THIN);
		cellStyleNormalCenterGreen.setBorderTop(BorderStyle.THIN);
		cellStyleNormalCenterGreen.setFont(fontNormal);
		cellStyleNormalCenterGreen.setAlignment(HorizontalAlignment.CENTER);
		cellStyleNormalCenterGreen.setVerticalAlignment(VerticalAlignment.TOP);
		cellStyleNormalCenterGreen.setWrapText(true);
		//cellStyleNormalCenterGreen.setFillForegroundColor(new XSSFColor(new Color(124,252,0)));
		//cellStyleNormalCenterGreen.setFillForegroundColor(new XSSFColor(new Color(110,162,62)));
		//cellStyleNormalCenterGreen.setFillPattern(CellStyle.SOLID_FOREGROUND);
		// Set fill foreground color
		cellStyleNormalCenterGreen.setFillForegroundColor(new XSSFColor(new Color(110, 162, 62), null));

		// Set fill pattern to solid
		cellStyleNormalCenterGreen.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		//Yellow Color
		/*Code Starts From Here Done By Roshan Tailor*/
		cellStyleNormalCenterYellow=workbook.createCellStyle();
		cellStyleNormalCenterYellow.setBorderBottom(BorderStyle.THIN);
		cellStyleNormalCenterYellow.setBorderLeft(BorderStyle.THIN);
		cellStyleNormalCenterYellow.setBorderRight(BorderStyle.THIN);
		cellStyleNormalCenterYellow.setBorderTop(BorderStyle.THIN);
		cellStyleNormalCenterYellow.setFont(fontNormal);
		cellStyleNormalCenterYellow.setAlignment(HorizontalAlignment.CENTER);
		cellStyleNormalCenterYellow.setVerticalAlignment(VerticalAlignment.TOP);
		cellStyleNormalCenterYellow.setWrapText(true);
		//cellStyleNormalCenterYellow.setFillForegroundColor(new XSSFColor(new Color(255,255,51)));
		/*cellStyleNormalCenterYellow.setFillForegroundColor(new XSSFColor(new Color(255,255,204)));*/
		//cellStyleNormalCenterYellow.setFillPattern(CellStyle.SOLID_FOREGROUND);
		// Set fill foreground color to yellow (RGB: 255, 255, 51)
		cellStyleNormalCenterYellow.setFillForegroundColor(new XSSFColor(new Color(255, 255, 51), null));

		// Set fill pattern to solid
		cellStyleNormalCenterYellow.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		/*Code Ends Here Done By Roshan Tailor*/
		
		//Sky Color
		/*Code Starts From Here Done By Roshan Tailor*/
		cellStyleNormalCenterSkyColor=workbook.createCellStyle();
		cellStyleNormalCenterSkyColor.setBorderBottom(BorderStyle.THIN);
		cellStyleNormalCenterSkyColor.setBorderLeft(BorderStyle.THIN);
		cellStyleNormalCenterSkyColor.setBorderRight(BorderStyle.THIN);
		cellStyleNormalCenterSkyColor.setBorderTop(BorderStyle.THIN);
		cellStyleNormalCenterSkyColor.setFont(fontNormal);
		cellStyleNormalCenterSkyColor.setAlignment(HorizontalAlignment.CENTER);
		cellStyleNormalCenterSkyColor.setVerticalAlignment(VerticalAlignment.TOP);
		cellStyleNormalCenterSkyColor.setWrapText(true);
		//cellStyleNormalCenterSkyColor.setFillForegroundColor(new XSSFColor(new Color(0,184,255 )));
		//cellStyleNormalCenterSkyColor.setFillPattern(CellStyle.SOLID_FOREGROUND);
		// Set fill foreground color to sky blue (RGB: 0, 184, 255)
		cellStyleNormalCenterSkyColor.setFillForegroundColor(new XSSFColor(new Color(0, 184, 255), null));

		// Set fill pattern to solid
		cellStyleNormalCenterSkyColor.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		
		
		cellStyleNormalCenterGrayColor=workbook.createCellStyle();
		cellStyleNormalCenterGrayColor.setBorderBottom(BorderStyle.THIN);
		cellStyleNormalCenterGrayColor.setBorderLeft(BorderStyle.THIN);
		cellStyleNormalCenterGrayColor.setBorderRight(BorderStyle.THIN);
		cellStyleNormalCenterGrayColor.setBorderTop(BorderStyle.THIN);
		cellStyleNormalCenterGrayColor.setFont(fontNormal);
		cellStyleNormalCenterGrayColor.setAlignment(HorizontalAlignment.CENTER);
		cellStyleNormalCenterGrayColor.setVerticalAlignment(VerticalAlignment.TOP);
		cellStyleNormalCenterGrayColor.setWrapText(true);
		//cellStyleNormalCenterGrayColor.setFillForegroundColor(new XSSFColor(new Color(201,201,201)));
		//cellStyleNormalCenterGrayColor.setFillPattern(CellStyle.SOLID_FOREGROUND);
		// Set fill foreground color to light gray (RGB: 201, 201, 201)
		cellStyleNormalCenterGrayColor.setFillForegroundColor(new XSSFColor(new Color(201, 201, 201), null));

		// Set fill pattern to solid
		cellStyleNormalCenterGrayColor.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		/*Code Ends Here Done By Roshan Tailor*/
		
		
		/*Code Starts From Here Done By Roshan Tailor ADte :- 2016-12-06*/
		//This Code Is For Color 
		cellStyleNormalCenterf5da81=workbook.createCellStyle();
		cellStyleNormalCenterf5da81.setBorderBottom(BorderStyle.THIN);
		cellStyleNormalCenterf5da81.setBorderLeft(BorderStyle.THIN);
		cellStyleNormalCenterf5da81.setBorderRight(BorderStyle.THIN);
		cellStyleNormalCenterf5da81.setBorderTop(BorderStyle.THIN);
		cellStyleNormalCenterf5da81.setFont(fontNormal);
		cellStyleNormalCenterf5da81.setAlignment(HorizontalAlignment.CENTER);
		cellStyleNormalCenterf5da81.setVerticalAlignment(VerticalAlignment.TOP);
		//cellStyleNormalCenterf5da81.setFillForegroundColor(new XSSFColor(new Color(245, 218, 129)));
		//cellStyleNormalCenterf5da81.setFillPattern(CellStyle.SOLID_FOREGROUND);
		// Set fill foreground color (RGB: 245, 218, 129)
		cellStyleNormalCenterf5da81.setFillForegroundColor(new XSSFColor(new Color(245, 218, 129), null));

		// Set fill pattern to solid
		cellStyleNormalCenterf5da81.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		cellStyleNormalCenterf5da81.setWrapText(true);
		
		/*Code Ends Here Done By Roshan Tailor ADte :- 2016-12-06*/
		
		//XSSFFont Normal
		XSSFFont fontNormalLeft=workbook.createFont();
		//fontNormalLeft.setBoldweight(XSSFFont.BOLDWEIGHT_NORMAL);
		// Set font weight to normal (not bold)
		fontNormalLeft.setBold(false);
		fontNormalLeft.setColor(IndexedColors.BLACK.getIndex());
		cellStyleNormalLeft=workbook.createCellStyle();
		cellStyleNormalLeft.setBorderBottom(BorderStyle.THIN);
		cellStyleNormalLeft.setBorderLeft(BorderStyle.THIN);
		cellStyleNormalLeft.setBorderRight(BorderStyle.THIN);
		cellStyleNormalLeft.setBorderTop(BorderStyle.THIN);
		cellStyleNormalLeft.setFont(fontNormalLeft);
		cellStyleNormalLeft.setAlignment(HorizontalAlignment.LEFT);
		cellStyleNormalLeft.setVerticalAlignment(VerticalAlignment.TOP);
		cellStyleNormalLeft.setWrapText(true);
		
		
		
		//XSSFFont Normal
	
		cellStyleNormalCenterNoneBorder=workbook.createCellStyle();
		cellStyleNormalCenterNoneBorder.setFont(fontNormalLeft);
		cellStyleNormalCenterNoneBorder.setAlignment(HorizontalAlignment.CENTER);
		cellStyleNormalCenterNoneBorder.setVerticalAlignment(VerticalAlignment.TOP);
		cellStyleNormalCenterNoneBorder.setWrapText(true);
		
		
		cellStyleNormalLeftNoneBorder=workbook.createCellStyle();
		cellStyleNormalLeftNoneBorder.setFont(fontNormalLeft);
		cellStyleNormalLeftNoneBorder.setAlignment(HorizontalAlignment.LEFT);
		cellStyleNormalLeftNoneBorder.setVerticalAlignment(VerticalAlignment.TOP);
		//cellStyleNormalCenterNoneBorder.setWrapText(true);
				
		
		
		//
		XSSFFont fontNormalRight=workbook.createFont();
		//fontNormalRight.setBoldweight(XSSFFont.BOLDWEIGHT_NORMAL);
		fontNormalLeft.setBold(false);
		fontNormalRight.setColor(IndexedColors.BLACK.getIndex());
		cellStyleNormalRight=workbook.createCellStyle();
		cellStyleNormalRight.setBorderBottom(BorderStyle.THIN);
		cellStyleNormalRight.setBorderLeft(BorderStyle.THIN);
		cellStyleNormalRight.setBorderRight(BorderStyle.THIN);
		cellStyleNormalRight.setBorderTop(BorderStyle.THIN);
		cellStyleNormalRight.setFont(fontNormalRight);
		cellStyleNormalRight.setAlignment(HorizontalAlignment.RIGHT);
		cellStyleNormalRight.setVerticalAlignment(VerticalAlignment.TOP);
		cellStyleNormalRight.setWrapText(true);
		
		//cellStyleBoldJustify;		
		
		XSSFFont fontNormal1=workbook.createFont();		
		//fontNormal1.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);	
		// Set font to bold
		fontNormal1.setBold(true);
		fontNormal1.setColor(IndexedColors.BLACK.getIndex()); 		
		cellStyleBoldJustify=workbook.createCellStyle();		
		cellStyleBoldJustify.setBorderBottom(BorderStyle.THIN);		
		cellStyleBoldJustify.setBorderLeft(BorderStyle.THIN);		
		cellStyleBoldJustify.setBorderRight(BorderStyle.THIN);		
		cellStyleBoldJustify.setBorderTop(BorderStyle.THIN);		
		cellStyleBoldJustify.setFont(fontBold);		
		cellStyleBoldJustify.setAlignment(HorizontalAlignment.JUSTIFY);		
		cellStyleBoldJustify.setVerticalAlignment(VerticalAlignment.TOP);		
		cellStyleBoldJustify.setWrapText(true);
	}
	
	public void createFreezePane(int row,int col)
	{
		sheet.createFreezePane(col, row);
	}
	
	
	        

	
	
	public void addValue(int row, int col, Object value, short styleBoldCenter, short rowHeight){
		XSSFRow xssfRow=sheet.getRow(row);
		
		if(xssfRow==null){
			xssfRow=sheet.createRow(row);
		}
		xssfRow.setHeight(rowHeight);
		XSSFCell cell=xssfRow.getCell(col);
		if(cell==null){
			cell=xssfRow.createCell(col);
		}
		
		if(Style.STYLE_BOLD_CENTER==styleBoldCenter){
			cell.setCellStyle(cellStyleBoldCenter);
		}else if(Style.STYLE_NORMAL_CENTER==styleBoldCenter){
			cell.setCellStyle(cellStyleNormalCenter);
		}else if(Style.STYLE_NORMAL_LEFT==styleBoldCenter){
			cell.setCellStyle(cellStyleNormalLeft);
		}else if(Style.STYLE_NORMAL_RIGHT==styleBoldCenter){
			cell.setCellStyle(cellStyleNormalRight);
		}else if(Style.STYLE_HEADER_01==styleBoldCenter){
			cell.setCellStyle(cellStyleHeader01);
		}else if(Style.STYLE_NORMAL_CENTER_GREEN==styleBoldCenter){
			cell.setCellStyle(cellStyleNormalCenterGreen);
		}else if(Style.STYLE_NORMAL_CENTER_ORANGE==styleBoldCenter){
			cell.setCellStyle(cellStyleNormalCenterOrange);
		}
		else if(Style.STYLE_NORMAL_CENTER_RED==styleBoldCenter){
			cell.setCellStyle(cellStyleNormalCenterRed);
		}else if(Style.STYLE_NORMAL_CENTER_Yellow==styleBoldCenter){
			cell.setCellStyle(cellStyleNormalCenterYellow);
		}
		else if(Style.STYLE_NORMAL_CENTER_SkyColor==styleBoldCenter){
			cell.setCellStyle(cellStyleNormalCenterSkyColor);
		}else if(Style.STYLE_NORMAL_CENTER_GrayColor==styleBoldCenter){
			cell.setCellStyle(cellStyleNormalCenterGrayColor);
		}
		else if(Style.STYLE_NORMAL_CENTER_NOBORDER==styleBoldCenter){
			cell.setCellStyle(cellStyleNormalCenterNoneBorder);
		}else if(Style.STYLE_NORMAL_LEFT_NOBORDER==styleBoldCenter){
			cell.setCellStyle(cellStyleNormalLeftNoneBorder);
		}else if(Style.STYLE_BOLD_LEFT==styleBoldCenter){
			cell.setCellStyle(cellStyleBoldLeft);
		}
		else if(Style.STYLE_BOLD_JUSTIFY==styleBoldCenter){		
			cell.setCellStyle(cellStyleBoldJustify);
		}else if(Style.STYLE_NORMAL_CENTER_BORDER_f5da81==styleBoldCenter){
			cell.setCellStyle(cellStyleNormalCenterf5da81);
		}
		
		if(value instanceof String){
			cell.setCellValue((String)value);
		}else if(value instanceof Double){
			cell.setCellValue((Double)value);
		}else if(value instanceof Integer){
			cell.setCellValue((Integer)value);
		}else if(value instanceof Long){
			cell.setCellValue((Long)value);
		}else if(value instanceof Float){
			cell.setCellValue((Float)value);
		}
		
		
	}
	
	


	/**public void mergeCell(int rowFrom,int rowTo,int colFrom,int colTo){
		CellRangeAddress rangeAddress=new CellRangeAddress(rowFrom, rowTo, colFrom, colTo);
		sheet.addMergedRegion(rangeAddress);
		//RegionUtil.setBorderTop(XSSFCellStyle.BORDER_THIN, rangeAddress, sheet, workbook);
		RegionUtil.setBorderTop(BorderStyle.THIN, rangeAddress, sheet, workbook);
		RegionUtil.setBorderBottom(XSSFCellStyle.BORDER_THIN, rangeAddress, sheet, workbook);
		RegionUtil.setBorderLeft(XSSFCellStyle.BORDER_THIN, rangeAddress, sheet, workbook);
		RegionUtil.setBorderRight(XSSFCellStyle.BORDER_THIN, rangeAddress, sheet, workbook);
	}
	public void mergeCellwithoutBorder(int rowFrom,int rowTo,int colFrom,int colTo){
		CellRangeAddress rangeAddress=new CellRangeAddress(rowFrom, rowTo, colFrom, colTo);
		sheet.addMergedRegion(rangeAddress);
		RegionUtil.setBorderTop(XSSFCellStyle.BORDER_NONE, rangeAddress, sheet, workbook);
		RegionUtil.setBorderBottom(XSSFCellStyle.BORDER_NONE, rangeAddress, sheet, workbook);
		RegionUtil.setBorderLeft(XSSFCellStyle.BORDER_NONE, rangeAddress, sheet, workbook);
		// Your existing method
		RegionUtil.setBorderRight(BorderStyle.NONE, rangeAddress, sheet);

	}**/
	public void mergeCell(int rowFrom, int rowTo, int colFrom, int colTo) {
	    CellRangeAddress rangeAddress = new CellRangeAddress(rowFrom, rowTo, colFrom, colTo);
	    sheet.addMergedRegion(rangeAddress);
	    
	    // Set borders around the merged region
	    RegionUtil.setBorderTop(BorderStyle.THIN, rangeAddress, sheet);
	    RegionUtil.setBorderBottom(BorderStyle.THIN, rangeAddress, sheet);
	    RegionUtil.setBorderLeft(BorderStyle.THIN, rangeAddress, sheet);
	    RegionUtil.setBorderRight(BorderStyle.THIN, rangeAddress, sheet);
	}

	public void mergeCellwithoutBorder(int rowFrom, int rowTo, int colFrom, int colTo) {
	    CellRangeAddress rangeAddress = new CellRangeAddress(rowFrom, rowTo, colFrom, colTo);
	    sheet.addMergedRegion(rangeAddress);
	    
	    // Set no borders around the merged region
	    RegionUtil.setBorderTop(BorderStyle.NONE, rangeAddress, sheet);
	    RegionUtil.setBorderBottom(BorderStyle.NONE, rangeAddress, sheet);
	    RegionUtil.setBorderLeft(BorderStyle.NONE, rangeAddress, sheet);
	    RegionUtil.setBorderRight(BorderStyle.NONE, rangeAddress, sheet);
	}
	
	
	
	public void write(OutputStream stream) throws IOException{
		workbook.write(stream);
	}
	
	public void setAutoSizeColumn(int col){
		sheet.autoSizeColumn(col);
	}
	public void setAutoSizeRow(int row,short hight){
	
		
		
	}
	
	public XSSFWorkbook getWorkbook(){
		return workbook;
	}
	
	//Static field
	public static class Style{
		public static final short STYLE_NORMAL_CENTER=1;
		public static final short STYLE_NORMAL_LEFT=2;
		public static final short STYLE_NORMAL_RIGHT=3;
		public static final short STYLE_BOLD_CENTER=4;
		public static final short STYLE_HEADER_01=5;
		
		public static final short STYLE_NORMAL_CENTER_RED=6;
		public static final short STYLE_NORMAL_CENTER_GREEN=7;
		//Code Starts From Here Done By Roshan Tailor
		public static final short STYLE_NORMAL_CENTER_Yellow=11;
		public static final short STYLE_NORMAL_CENTER_SkyColor=12;
		//Code Ends Here Done By Roshan Tailor
		public static final short STYLE_NORMAL_CENTER_NOBORDER=8;
		public static final short STYLE_NORMAL_LEFT_NOBORDER=9;
		
		public static final short STYLE_NORMAL_CENTER_BORDER_f5da81=14;
		
		public static final short STYLE_BOLD_LEFT=10;
		
		public static final short STYLE_BOLD_JUSTIFY=13;
		
		public static final short STYLE_NORMAL_CENTER_GrayColor=15;
		public static final short STYLE_NORMAL_CENTER_ORANGE=16;
		
	}
}

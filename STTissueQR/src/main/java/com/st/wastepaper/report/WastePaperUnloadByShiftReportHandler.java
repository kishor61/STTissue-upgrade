/**
 *Oct 10, 2015
 *WastePaperUnloadByShiftReportHandler.java
 * TODO
 *com.st.wastepaper.report
 *WastePaperUnloadByShiftReportHandler.java
 *Sunil Singh Bora
 */
package com.st.wastepaper.report;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

import jakarta.servlet.ServletOutputStream;

import org.springframework.stereotype.Component;

import com.st.common.CommonUtil;
import com.st.common.Workbook2007Util;
import com.st.wastepaper.model.WastePaperUnloadByShift;

/**
 * @author roshan
 *
 */
@Component
public class WastePaperUnloadByShiftReportHandler {

	/**
	 * @param unloadByShift
	 * @param file
	 * @param outputStream
	 * @throws IOException 
	 */
	
	private SimpleDateFormat dateFormat=new SimpleDateFormat("MM-dd-yyyy");public void getWPUnloadByShiftReport(
			List<WastePaperUnloadByShift> unloadByShift, File file,
			ServletOutputStream outputStream) throws IOException {
		// TODO Auto-generated method stub
		Workbook2007Util util = new Workbook2007Util(file,0);
		
		util.setSheetName("Unload Report By Shift", 0);
		
		short rowHeight = 280;
		int row=2;
		int col=0;
		int lastcol=0;
		
		int totalInDay=0;
		int totalInNight=0;
		int finalGrandTotal=0;
		for(WastePaperUnloadByShift byshift:unloadByShift){
			col=0;
			lastcol=1;
			
			util.addValue(row, col++, dateFormat.format(byshift.getUnloaddate()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, byshift.getDay(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, byshift.getDayshift(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, byshift.getNightshift(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, byshift.getGrandtotal(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			row++;
			totalInDay=totalInDay+byshift.getDayshift();
			totalInNight=totalInNight+byshift.getNightshift();
			finalGrandTotal=finalGrandTotal+byshift.getGrandtotal();
		}
		col=0;
		util.addValue(row, col++, "Total", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(row, col++, totalInDay, Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(row, col++, totalInNight, Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(row, col++, finalGrandTotal, Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.write(outputStream);
	}
 
}

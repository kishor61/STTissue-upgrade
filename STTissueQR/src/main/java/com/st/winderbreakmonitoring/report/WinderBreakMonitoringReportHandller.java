/**
 *Oct 30, 2015
 *WinderBreakMonitoringReportHandller.java
 * TODO
 *com.st.winderbreakmonitoring.report
 *WinderBreakMonitoringReportHandller.java
 *Sunil Singh Bora
 */
package com.st.winderbreakmonitoring.report;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

import jakarta.servlet.ServletOutputStream;

import org.springframework.stereotype.Component;

import com.st.common.Workbook2007Util;
import com.st.customercomplaint.model.CustomerComplaint;
import com.st.winderbreakmonitoring.model.WinderBreakMonitoring;

/**
 * @author roshan
 *
 */
@Component
public class WinderBreakMonitoringReportHandller {

	/**
	 * @param winderMonitoringData
	 * @param file
	 * @param outputStream
	 * @throws IOException 
	 */
	private SimpleDateFormat dateFormat=new SimpleDateFormat("MM-dd-yyyy");
	private SimpleDateFormat dateFormat1=new SimpleDateFormat("HH:mm:ss");
	public void winderbreakmonitoringreportExport(
			List<WinderBreakMonitoring> winderMonitoringData, File file,
			ServletOutputStream outputStream) throws IOException {
		// TODO Auto-generated method stub
		Workbook2007Util util = new Workbook2007Util(file,0);
		util.setSheetName("Winder Break Monitoring Report", 0);
		short rowHeight = 280;
		int row=3;
		int col=0;
		int lastcol=0;
		for(WinderBreakMonitoring wmd:winderMonitoringData)
		{
			col=0;
			lastcol=1;
			
			util.addValue(row, col++, dateFormat.format(wmd.getDate()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, wmd.getShift(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, wmd.getCrew(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, wmd.getGradeCode(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, wmd.getReel(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, wmd.getSetNo(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, wmd.getBreakAt(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			
			util.addValue(row, col++, dateFormat1.format(wmd.getStoptime()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, dateFormat1.format(wmd.getStarttime()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, wmd.getDowntime(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			
			
			util.addValue(row, col++, wmd.getReasonforbreak(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, wmd.getLosstime(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, wmd.getLeftoutinSpool(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			row++;
		}
		util.write(outputStream);
	}

}

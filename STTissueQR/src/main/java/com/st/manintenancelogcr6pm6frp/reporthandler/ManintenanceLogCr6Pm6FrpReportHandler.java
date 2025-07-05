/**
 *Dec 9, 2017
 *ManintenanceLogCr6Pm6FrpReportHandler.java
 * TODO
 *com.st.manintenancelogcr6pm6frp.reporthandler
 *ManintenanceLogCr6Pm6FrpReportHandler.java
 *Roshan Lal Tailor
 */
package com.st.manintenancelogcr6pm6frp.reporthandler;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

import jakarta.servlet.ServletOutputStream;

import org.springframework.stereotype.Component;

import com.st.common.Workbook2007Util;
import com.st.manintenancelogcr6pm6frp.model.ManintenanceLogCr6Pm6Frp;

/**
 * @author roshan
 *
 */
@Component
public class ManintenanceLogCr6Pm6FrpReportHandler {

	private SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
	
	private SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
	
	/**
	 * @param details
	 * @param file
	 * @param outputStream
	 * @throws IOException 
	 */
	public void exportManintenanceLogCr6Pm6FrpReport( List<ManintenanceLogCr6Pm6Frp> details, File file, ServletOutputStream outputStream) throws IOException {
		
		Workbook2007Util util = new Workbook2007Util(file,0);
		util.setSheetName("Daily Shift Logs Report", 0);
		short rowHeight = 280;
		int row=3;
		int col=0;
		int lastcol=0;
	
		for(ManintenanceLogCr6Pm6Frp data:details)
		{
			col=0;
			lastcol=1;
			util.addValue(row, col++, dateFormat.format(data.getDate()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			//util.addValue(row, col++, data.getTime(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, data.getShift(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, data.getProdtypeorgradecode(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, data.getTeam(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			/*util.addValue(row, col++, data.getArea(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, data.getError(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);*/
			util.addValue(row, col++, data.getComments(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			
			row++;
		}
		util.write(outputStream);
	}

	/**
	 * @param details
	 * @param outputStream
	 * @throws IOException 
	 */
	public void emailManintenanceLogCr6Pm6FrpReport(
			List<ManintenanceLogCr6Pm6Frp> details,
			FileOutputStream outputStream) throws IOException {
		
		Workbook2007Util util = new Workbook2007Util();
		util.setSheetName("Daily Shift Logs Report", 0);
		short rowHeight = 280;
		int row=0;
		int col=0;
		int lastcol=0;
	
		util.addValue(row, col++, "Date", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
//		util.addValue(row, col++, "Time", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(row, col++, "User Type", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(row, col++, "Shift", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(row, col++, "Grade Code", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(row, col++, "Team", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(row, col++, "Comments/Note", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		
		for(ManintenanceLogCr6Pm6Frp data:details)
		{
			row++;
			col=0;
			lastcol=1;
			util.addValue(row, col++, dateFormat.format(data.getDate()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
//			util.addValue(row, col++, data.getTime(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			if(data.getUsertype().equalsIgnoreCase("ADMIN")){
				util.addValue(row, col++, "ADMIN", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			}else if(data.getUsertype().equalsIgnoreCase("OPERATOR")){
				util.addValue(row, col++, "CR6", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			}else if(data.getUsertype().equalsIgnoreCase("OPERATOR2")){
				util.addValue(row, col++, "FRP", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			}else if(data.getUsertype().equalsIgnoreCase("OPERATOR3")){
				util.addValue(row, col++, "STI", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			}else if(data.getUsertype().equalsIgnoreCase("OPERATOR4")){
				util.addValue(row, col++, "PM", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			}else if(data.getUsertype().equalsIgnoreCase("OPERATOR5")){
				util.addValue(row, col++, "CL", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			}else{
				util.addValue(row, col++, "CR5", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			}
			util.addValue(row, col++, data.getShift(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, data.getProdtypeorgradecode(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, data.getTeam(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, data.getComments(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		}
		util.freez(1, 1);
		for (int i = 0; i < 17; i++) {
			util.setAutoSizeColumn(i);
		}
		
		util.write(outputStream);	
	}

}

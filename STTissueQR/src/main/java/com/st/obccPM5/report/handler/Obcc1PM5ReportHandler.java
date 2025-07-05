/**
 *Oct 30, 2019
 *ObccPM5ReportHandler.java
 * TODO
 *com.st.obccPM5.report.handler
 *ObccPM5ReportHandler.java
 *Roshan Lal Tailor
 */
package com.st.obccPM5.report.handler;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import jakarta.servlet.ServletOutputStream;
import org.springframework.stereotype.Component;

import com.st.common.CommonUtil;
import com.st.common.Workbook2007Util;
import com.st.obccPM5.model.LeadOperatorPM5;
import com.st.obccPM5.model.R1OperatorPM5;
import com.st.obccPM5.model.R1WaterJetsDown;
import com.st.obccPM5.model.R2OperatorPM5;
import com.st.obccPM5.model.R2WaterJetsDown;
import com.st.obccPM5.model.StockOperatorPM5;
import com.st.obccPM5.model.UtilityOperatorPM5;
import com.st.obccPM5.model.WinderDown;


/**
 * @author sohan
 *
 */
@Component
public class Obcc1PM5ReportHandler {
	/**
	 * @param daylst
	 * @param file
	 * @param outputStream
	 * @param l
	 */
	public void getExcelReportR2OperatorPM5Day(List<R2OperatorPM5> daylst, File file, ServletOutputStream outputStream,long l) throws IOException {
		
		Workbook2007Util util = new Workbook2007Util(file,0);
		util.setSheetName("R2 Operator ", 0);
		  
		
		
		short rowHeight = 280;
		int row=3;
		int col=0;
		for(R2OperatorPM5 data:daylst){
			col =0;
			if(data.isMachinedown()==true)
			{
				util.addValue(row, col++, "YES",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			else if(data.isMachinedown()==false)
			{
				util.addValue(row, col++, "NO",Workbook2007Util.Style.STYLE_NORMAL_CENTER_GREEN, rowHeight);
			}
			else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			util.addValue(row, col++,   data.getEdate(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, data.getPosition(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.capitalizeFirstLetter(data.getShift()), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, data.getCrew(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
		
		
		
		
		
		if(data.isWindedeckstopscol1() == true)
		{
			util.addValue(row, col++, "OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
		}
		else if(data.isWindedeckstopscol1() == false)
		{
			util.addValue(row, col++, "NOT OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
		}
		else
		{
			util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
		}
		
		util.addValue(row, col++, data.getCorescol1Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
		
		if(data.isConveyorcol1() == true)
		{
			util.addValue(row, col++, "OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
		}
		else if(data.isConveyorcol1() == false)
		{
			util.addValue(row, col++, "NOT OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
		}
		else
		{
			util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
		}
		
		util.addValue(row, col++, data.getConveyorcol1Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
		
		if(data.isConveyorcol2() == true)
		{
			util.addValue(row, col++, "OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
		}
		else if(data.isConveyorcol2() == false)
		{
			util.addValue(row, col++, "NOT OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
		}
		else
		{
			util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
		}
		
		util.addValue(row, col++, data.getConveyorcol2Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
		
		if(data.isConveyorcol3() == true)
		{
			util.addValue(row, col++, "No OverHeating",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
		}
		else if(data.isConveyorcol3() == false)
		{
			util.addValue(row, col++, "OverHeating",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
		}
		else
		{
			util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
		}
		util.addValue(row, col++, data.getConveyorcol3Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
		
		
		if(data.isConveyorcol4() == true)
		{
			util.addValue(row, col++, "No Abnormal Sound",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
		}
		else if(data.isConveyorcol4() == false)
		{
			util.addValue(row, col++, "Abnormal Sound",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
		}
		else
		{
			util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
		}
		
		util.addValue(row, col++, data.getConveyorcol4Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
		
		
		if(data.isConveyorcol5() == true)
		{
			util.addValue(row, col++, "OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
		}
		else if(data.isConveyorcol5() == false)
		{
			util.addValue(row, col++, "NOT OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
		}
		else
		{
			util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
		}
		
		util.addValue(row, col++, data.getConveyorcol5Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
		
		if(data.isCoresawcol1() == true)
		{
			util.addValue(row, col++, "ON",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
		}
		else if(data.isCoresawcol1() == false)
		{
			util.addValue(row, col++, "OFF",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
		}
		else
		{
			util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
		}
		
		util.addValue(row, col++, data.getCoresawcol1Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
		
		if(data.isCoresawcol2() == true)
		{
			util.addValue(row, col++, "OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
		}
		else if(data.isCoresawcol2() == false)
		{
			util.addValue(row, col++, "NOT OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
		}
		else
		{
			util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
		}
		
		util.addValue(row, col++, data.getCoresawcol2Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
		
		
		if(data.isCoresawcol3() == true)
		{
			util.addValue(row, col++, "OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
		}
		else if(data.isCoresawcol3() == false)
		{
			util.addValue(row, col++, "NOT OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
		}
		else
		{
			util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
		}
		
		util.addValue(row, col++, data.getCoresawcol3Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
		
		if(data.isCoresawcol4() == true)
		{
			util.addValue(row, col++, "OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
		}
		else if(data.isCoresawcol4() == false)
		{
			util.addValue(row, col++, "NOT OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
		}
		else
		{
			util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
		}
		
		util.addValue(row, col++, data.getCoresawcol4Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
		
		
		if(data.isCorescol1() == true)
		{
			util.addValue(row, col++, "OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
		}
		else if(data.isCorescol1() == false)
		{
			util.addValue(row, col++, "NOT OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
		}
		else
		{
			util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
		}
		
		util.addValue(row, col++, data.getCorescol1Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
		
	  	
		row++ ;
			
		}
		col = 1;
		util.mergeCell(row+2, row+2, col, col+5);
		util.addValue(row+2, col, "OBCC Completed = "+l+"%",Workbook2007Util.Style.STYLE_BOLD_LEFT, rowHeight);
		
		
		util.write(outputStream);
	}	
	/**
	 * @param nightlst
	 * @param file
	 * @param outputStream
	 * @param l
	 * @throws IOException 
	 */
	public void getExcelReportR2OperatorPM5Night(List<R2OperatorPM5> nightlst,File file, ServletOutputStream outputStream, long l) throws IOException {
		Workbook2007Util util = new Workbook2007Util(file,0);
		util.setSheetName("R2 Operator ", 0);
		  
		
		
		short rowHeight = 280;
		int row=3;
		int col=0;
		for(R2OperatorPM5 data:nightlst){
			col =0;
			if(data.isMachinedown()==true)
			{
				util.addValue(row, col++, "YES",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			else if(data.isMachinedown()==false)
			{
				util.addValue(row, col++, "NO",Workbook2007Util.Style.STYLE_NORMAL_CENTER_GREEN, rowHeight);
			}
			else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			util.addValue(row, col++,   data.getEdate(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, data.getPosition(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.capitalizeFirstLetter(data.getShift()), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, data.getCrew(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
		
		
		
		
		
		if(data.isWindedeckstopscol1() == true)
		{
			util.addValue(row, col++, "OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
		}
		else if(data.isWindedeckstopscol1() == false)
		{
			util.addValue(row, col++, "NOT OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
		}
		else
		{
			util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
		}
		
		util.addValue(row, col++, data.getCorescol1Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
		
		if(data.isConveyorcol1() == true)
		{
			util.addValue(row, col++, "OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
		}
		else if(data.isConveyorcol1() == false)
		{
			util.addValue(row, col++, "NOT OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
		}
		else
		{
			util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
		}
		
		util.addValue(row, col++, data.getConveyorcol1Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
		
		if(data.isConveyorcol2() == true)
		{
			util.addValue(row, col++, "OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
		}
		else if(data.isConveyorcol2() == false)
		{
			util.addValue(row, col++, "NOT OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
		}
		else
		{
			util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
		}
		
		util.addValue(row, col++, data.getConveyorcol2Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
		
		if(data.isConveyorcol3() == true)
		{
			util.addValue(row, col++, "No OverHeating",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
		}
		else if(data.isConveyorcol3() == false)
		{
			util.addValue(row, col++, "OverHeating",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
		}
		else
		{
			util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
		}
		util.addValue(row, col++, data.getConveyorcol3Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
		
		
		if(data.isConveyorcol4() == true)
		{
			util.addValue(row, col++, "No Abnormal Sound",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
		}
		else if(data.isConveyorcol4() == false)
		{
			util.addValue(row, col++, "Abnormal Sound",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
		}
		else
		{
			util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
		}
		
		util.addValue(row, col++, data.getConveyorcol4Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
		
		
		if(data.isConveyorcol5() == true)
		{
			util.addValue(row, col++, "OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
		}
		else if(data.isConveyorcol5() == false)
		{
			util.addValue(row, col++, "NOT OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
		}
		else
		{
			util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
		}
		
		util.addValue(row, col++, data.getConveyorcol5Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
		
		if(data.isCoresawcol1() == true)
		{
			util.addValue(row, col++, "ON",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
		}
		else if(data.isCoresawcol1() == false)
		{
			util.addValue(row, col++, "OFF",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
		}
		else
		{
			util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
		}
		
		util.addValue(row, col++, data.getCoresawcol1Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
		
		if(data.isCoresawcol2() == true)
		{
			util.addValue(row, col++, "OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
		}
		else if(data.isCoresawcol2() == false)
		{
			util.addValue(row, col++, "NOT OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
		}
		else
		{
			util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
		}
		
		util.addValue(row, col++, data.getCoresawcol2Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
		
		
		if(data.isCoresawcol3() == true)
		{
			util.addValue(row, col++, "OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
		}
		else if(data.isCoresawcol3() == false)
		{
			util.addValue(row, col++, "NOT OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
		}
		else
		{
			util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
		}
		
		util.addValue(row, col++, data.getCoresawcol3Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
		
		if(data.isCoresawcol4() == true)
		{
			util.addValue(row, col++, "OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
		}
		else if(data.isCoresawcol4() == false)
		{
			util.addValue(row, col++, "NOT OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
		}
		else
		{
			util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
		}
		
		util.addValue(row, col++, data.getCoresawcol4Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
		
		
		if(data.isCorescol1() == true)
		{
			util.addValue(row, col++, "OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
		}
		else if(data.isCorescol1() == false)
		{
			util.addValue(row, col++, "NOT OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
		}
		else
		{
			util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
		}
		
		util.addValue(row, col++, data.getCorescol1Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
		
	  	
		row++ ;
			
		}
		col=0;
		util.mergeCell(row+2, row+2, col, col+5);
		util.addValue(row+2, col, "OBCC Completed = "+l+"%",Workbook2007Util.Style.STYLE_BOLD_LEFT, rowHeight);
		
		util.write(outputStream);
	}
	/**
	 * @param daylst
	 * @param nightlst
	 * @param file
	 * @param outputStream
	 * @param l
	 * @throws IOException 
	 */	
	public void getExcelReportR2OperatorPM5DayNight(List<R2OperatorPM5> daylst,List<R2OperatorPM5> nightlst, File file, ServletOutputStream outputStream, 
			long l) throws IOException {
		
		
		Workbook2007Util util = new Workbook2007Util(file,0);
		util.setSheetName("R2 Operator ", 0);
		  
		
		
		short rowHeight = 280;
		int row=3;
		int col=0;
		for(R2OperatorPM5 data:daylst){
			col =0;
			if(data.isMachinedown()==true)
			{
				util.addValue(row, col++, "YES",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			else if(data.isMachinedown()==false)
			{
				util.addValue(row, col++, "NO",Workbook2007Util.Style.STYLE_NORMAL_CENTER_GREEN, rowHeight);
			}
			else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			util.addValue(row, col++,   data.getEdate(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, data.getPosition(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.capitalizeFirstLetter(data.getShift()), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, data.getCrew(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
		
		
		
		
		
		if(data.isWindedeckstopscol1() == true)
		{
			util.addValue(row, col++, "OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
		}
		else if(data.isWindedeckstopscol1() == false)
		{
			util.addValue(row, col++, "NOT OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
		}
		else
		{
			util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
		}
		
		util.addValue(row, col++, data.getCorescol1Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
		
		if(data.isConveyorcol1() == true)
		{
			util.addValue(row, col++, "OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
		}
		else if(data.isConveyorcol1() == false)
		{
			util.addValue(row, col++, "NOT OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
		}
		else
		{
			util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
		}
		
		util.addValue(row, col++, data.getConveyorcol1Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
		
		if(data.isConveyorcol2() == true)
		{
			util.addValue(row, col++, "OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
		}
		else if(data.isConveyorcol2() == false)
		{
			util.addValue(row, col++, "NOT OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
		}
		else
		{
			util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
		}
		
		util.addValue(row, col++, data.getConveyorcol2Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
		
		if(data.isConveyorcol3() == true)
		{
			util.addValue(row, col++, "No OverHeating",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
		}
		else if(data.isConveyorcol3() == false)
		{
			util.addValue(row, col++, "OverHeating",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
		}
		else
		{
			util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
		}
		util.addValue(row, col++, data.getConveyorcol3Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
		
		
		if(data.isConveyorcol4() == true)
		{
			util.addValue(row, col++, "No Abnormal Sound",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
		}
		else if(data.isConveyorcol4() == false)
		{
			util.addValue(row, col++, "Abnormal Sound",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
		}
		else
		{
			util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
		}
		
		util.addValue(row, col++, data.getConveyorcol4Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
		
		
		if(data.isConveyorcol5() == true)
		{
			util.addValue(row, col++, "OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
		}
		else if(data.isConveyorcol5() == false)
		{
			util.addValue(row, col++, "NOT OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
		}
		else
		{
			util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
		}
		
		util.addValue(row, col++, data.getConveyorcol5Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
		
		if(data.isCoresawcol1() == true)
		{
			util.addValue(row, col++, "ON",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
		}
		else if(data.isCoresawcol1() == false)
		{
			util.addValue(row, col++, "OFF",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
		}
		else
		{
			util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
		}
		
		util.addValue(row, col++, data.getCoresawcol1Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
		
		if(data.isCoresawcol2() == true)
		{
			util.addValue(row, col++, "OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
		}
		else if(data.isCoresawcol2() == false)
		{
			util.addValue(row, col++, "NOT OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
		}
		else
		{
			util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
		}
		
		util.addValue(row, col++, data.getCoresawcol2Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
		
		
		if(data.isCoresawcol3() == true)
		{
			util.addValue(row, col++, "OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
		}
		else if(data.isCoresawcol3() == false)
		{
			util.addValue(row, col++, "NOT OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
		}
		else
		{
			util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
		}
		
		util.addValue(row, col++, data.getCoresawcol3Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
		
		if(data.isCoresawcol4() == true)
		{
			util.addValue(row, col++, "OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
		}
		else if(data.isCoresawcol4() == false)
		{
			util.addValue(row, col++, "NOT OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
		}
		else
		{
			util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
		}
		
		util.addValue(row, col++, data.getCoresawcol4Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
		
		
		if(data.isCorescol1() == true)
		{
			util.addValue(row, col++, "OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
		}
		else if(data.isCorescol1() == false)
		{
			util.addValue(row, col++, "NOT OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
		}
		else
		{
			util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
		}
		
		util.addValue(row, col++, data.getCorescol1Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
		
	  	
		row++ ;
			
		}
		
		col=0;
	

			
		row=row+6;
//		util.addValue(row, col,"Night Shift list Data", Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
		for(R2OperatorPM5 data:nightlst){
			col =0;
			if(data.isMachinedown()==true)
			{
				util.addValue(row, col++, "YES",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			else if(data.isMachinedown()==false)
			{
				util.addValue(row, col++, "NO",Workbook2007Util.Style.STYLE_NORMAL_CENTER_GREEN, rowHeight);
			}
			else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			util.addValue(row, col++,   data.getEdate(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, data.getPosition(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.capitalizeFirstLetter(data.getShift()), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, data.getCrew(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
		
		
		
		
		
		if(data.isWindedeckstopscol1() == true)
		{
			util.addValue(row, col++, "OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
		}
		else if(data.isWindedeckstopscol1() == false)
		{
			util.addValue(row, col++, "NOT OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
		}
		else
		{
			util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
		}
		
		util.addValue(row, col++, data.getCorescol1Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
		
		if(data.isConveyorcol1() == true)
		{
			util.addValue(row, col++, "OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
		}
		else if(data.isConveyorcol1() == false)
		{
			util.addValue(row, col++, "NOT OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
		}
		else
		{
			util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
		}
		
		util.addValue(row, col++, data.getConveyorcol1Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
		
		if(data.isConveyorcol2() == true)
		{
			util.addValue(row, col++, "OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
		}
		else if(data.isConveyorcol2() == false)
		{
			util.addValue(row, col++, "NOT OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
		}
		else
		{
			util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
		}
		
		util.addValue(row, col++, data.getConveyorcol2Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
		
		if(data.isConveyorcol3() == true)
		{
			util.addValue(row, col++, "No OverHeating",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
		}
		else if(data.isConveyorcol3() == false)
		{
			util.addValue(row, col++, "OverHeating",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
		}
		else
		{
			util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
		}
		util.addValue(row, col++, data.getConveyorcol3Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
		
		
		if(data.isConveyorcol4() == true)
		{
			util.addValue(row, col++, "No Abnormal Sound",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
		}
		else if(data.isConveyorcol4() == false)
		{
			util.addValue(row, col++, "Abnormal Sound",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
		}
		else
		{
			util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
		}
		
		util.addValue(row, col++, data.getConveyorcol4Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
		
		
		if(data.isConveyorcol5() == true)
		{
			util.addValue(row, col++, "OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
		}
		else if(data.isConveyorcol5() == false)
		{
			util.addValue(row, col++, "NOT OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
		}
		else
		{
			util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
		}
		
		util.addValue(row, col++, data.getConveyorcol5Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
		
		if(data.isCoresawcol1() == true)
		{
			util.addValue(row, col++, "ON",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
		}
		else if(data.isCoresawcol1() == false)
		{
			util.addValue(row, col++, "OFF",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
		}
		else
		{
			util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
		}
		
		util.addValue(row, col++, data.getCoresawcol1Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
		
		if(data.isCoresawcol2() == true)
		{
			util.addValue(row, col++, "OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
		}
		else if(data.isCoresawcol2() == false)
		{
			util.addValue(row, col++, "NOT OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
		}
		else
		{
			util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
		}
		
		util.addValue(row, col++, data.getCoresawcol2Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
		
		
		if(data.isCoresawcol3() == true)
		{
			util.addValue(row, col++, "OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
		}
		else if(data.isCoresawcol3() == false)
		{
			util.addValue(row, col++, "NOT OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
		}
		else
		{
			util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
		}
		
		util.addValue(row, col++, data.getCoresawcol3Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
		
		if(data.isCoresawcol4() == true)
		{
			util.addValue(row, col++, "OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
		}
		else if(data.isCoresawcol4() == false)
		{
			util.addValue(row, col++, "NOT OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
		}
		else
		{
			util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
		}
		
		util.addValue(row, col++, data.getCoresawcol4Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
		
		
		if(data.isCorescol1() == true)
		{
			util.addValue(row, col++, "OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
		}
		else if(data.isCorescol1() == false)
		{
			util.addValue(row, col++, "NOT OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
		}
		else
		{
			util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
		}
		
		util.addValue(row, col++, data.getCorescol1Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
		
	  	
		row++ ;
			
		}
		col=0;
		util.mergeCell(row+2, row+2, col, col+5);
		util.addValue(row+2, col, "OBCC Completed = "+l+"%",Workbook2007Util.Style.STYLE_BOLD_LEFT, rowHeight);
		
		
		util.write(outputStream);
		
	}
	/**
	 * @param daylst
	 * @param file
	 * @param outputStream
	 * @param l
	 * @throws IOException 
	 */
	public void getExcelReportForLeadOperatorPM5Day(List<LeadOperatorPM5> daylst,
			File file, ServletOutputStream outputStream, long l) throws IOException {
		
		Workbook2007Util util = new Workbook2007Util(file,0);
		util.setSheetName("Lead Operator  ", 0);
		  
		
		
		short rowHeight = 280;
		int row=3;
		int col=0;
		
		for(LeadOperatorPM5 data:daylst)
		{
			col =0;
			if(data.isMachinedown()==true)
			{
				util.addValue(row, col++, "YES",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			else if(data.isMachinedown()==false)
			{
				util.addValue(row, col++, "NO",Workbook2007Util.Style.STYLE_NORMAL_CENTER_GREEN, rowHeight);
			}
			else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			util.addValue(row, col++,   data.getEdate(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, data.getPosition(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.capitalizeFirstLetter(data.getShift()), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, data.getCrew(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
		
						
				util.addValue(row, col++, data.getFormatingsectioncol1(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getFormatingsectioncol1Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getFormatingsectioncol2(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getFormatingsectioncol2Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getFormatingsectioncol3(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getFormatingsectioncol3Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getFormatingsectioncol4(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getFormatingsectioncol4Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getFormatingsectioncol5(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getFormatingsectioncol5Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getFormatingsectioncol6(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getFormatingsectioncol6Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getFormatingsectioncol7(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getFormatingsectioncol7Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				util.addValue(row, col++, data.getCouchrollcol1(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++,data.getCouchrollcol1Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getCouchrollcol2(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++,data.getCouchrollcol2Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getCouchrollcol3(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++,data.getCouchrollcol3Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getCouchrollcol4(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++,data.getCouchrollcol4Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
		
				util.addValue(row, col++, data.getCouchrollcol5(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++,data.getCouchrollcol5Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				if(data.isCouchrollcol6()==true)
				{
					util.addValue(row, col++, "ok",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}
				else if(data.isCouchrollcol6()==false)
				{
					util.addValue(row, col++, "Not ok",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}else
				{
					util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}
				util.addValue(row, col++,data.getCouchrollcol6Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				/**
				if(data.isCouchrollcol7()==true)
				{
					util.addValue(row, col++, "ok",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}
				else if(data.isCouchrollcol7()==false)
				{
					util.addValue(row, col++, "Not ok",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}
				else
				{
					util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}
				util.addValue(row, col++,data.getCouchrollcol7Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				**/
				util.addValue(row, col++, data.getPicupfeltguidecol1(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getPicupfeltguidecol1Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getPicupfeltguidecol2(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getPicupfeltguidecol2Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getPicupfeltguidecol3(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getPicupfeltguidecol3Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getPicupfeltguidecol4(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getPicupfeltguidecol4Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				util.addValue(row, col++, data.getSuctionpressurerollcol1(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getSuctionpressurerollcol1Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getSuctionpressurerollcol2(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getSuctionpressurerollcol2Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				/***
				util.addValue(row, col++, data.getSuctionpressurerollcol3(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getSuctionpressurerollcol3Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getSuctionpressurerollcol4(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getSuctionpressurerollcol4Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getSuctionpressurerollcol5(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getSuctionpressurerollcol5Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				
				util.addValue(row, col++, data.getYankeedryerCol1(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getYankeedryerCol1Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getYankeedryerCol2(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getYankeedryerCol2Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getYankeedryerCol3(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getYankeedryerCol3Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getYankeedryerCol4(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getYankeedryerCol4Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				
				util.addValue(row, col++, data.getPressfeltareacol1(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++,data.getPressfeltareacol1Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				**/
				if(data.isPressfeltareacol2()==true)
				{
					util.addValue(row, col++, "ok",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}
				else if(data.isPressfeltareacol2()==false)
				{
					util.addValue(row, col++, "Not ok",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}
				else
				{
					util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}
				/***
				util.addValue(row, col++,data.getPressfeltareacol2Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getPressfeltareacol3(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				**/
				util.addValue(row, col++,data.getPressfeltareacol3Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getPressfeltareacol4(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++,data.getPressfeltareacol4Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getPressfeltareacol5(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++,data.getPressfeltareacol5Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getPressfeltareacol6(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++,data.getPressfeltareacol6Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getPressfeltareacol7(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++,data.getPressfeltareacol7Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getPressfeltareacol8(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++,data.getPressfeltareacol8Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				
				util.addValue(row, col++, data.getLubeoilsystemcol1(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++,data.getLubeoilsystemcol1Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getLubeoilsystemcol2(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++,data.getLubeoilsystemcol2Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getLubeoilsystemcol3(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++,data.getLubeoilsystemcol3Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getLubeoilsystemcol4(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++,data.getLubeoilsystemcol4Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getLubeoilsystemcol5(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++,data.getLubeoilsystemcol5Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getLubeoilsystemcol6(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++,data.getLubeoilsystemcol6Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getLubeoilsystemcol7(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++,data.getLubeoilsystemcol7Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				if(data.isF5abbaccuraycol1()==true)
				{
					util.addValue(row, col++, "ok",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}
				else if(data.isF5abbaccuraycol1()==false)
				{
					util.addValue(row, col++, "Not ok",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}
				else
				{
					util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}
				util.addValue(row, col++,data.getF5abbaccuraycol1Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				if(data.isF5abbaccuraycol2()==true)
				{
					util.addValue(row, col++, "ok",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}
				else if(data.isF5abbaccuraycol2()==false)
				{
					util.addValue(row, col++, "Not ok",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}
				else
				{
					util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}
				util.addValue(row, col++, data.getF5abbaccuraycol2Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				/***
				
				if(data.isF5abbaccuraycol3()==true)
				{
					util.addValue(row, col++, "ok",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}
				else if(data.isF5abbaccuraycol3()==false)
				{
					util.addValue(row, col++, "Not ok",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}
				else
				{
					util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}
				util.addValue(row, col++,data.getF5abbaccuraycol3Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				***/
				
				if(data.isF5abbaccuraycol4()==true)
				{
					util.addValue(row, col++, "ok",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}
				else if(data.isF5abbaccuraycol4()==false)
				{
					util.addValue(row, col++, "ok",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}
				else
				{
					util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}
				util.addValue(row, col++, data.getF5abbaccuraycol4Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				
				if(data.isF5abbaccuraycol5()==true)
				{
					util.addValue(row, col++, "ok",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}
				else if(data.isF5abbaccuraycol5()==false)
				{
					util.addValue(row, col++, "Not ok",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}
				else
				{
					util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}
				util.addValue(row, col++,data.getF5abbaccuraycol5Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				/***
				if(data.isF5abbaccuraycol6()==true)
				{
					util.addValue(row, col++, "ok",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}
				else if(data.isF5abbaccuraycol6()==false)
				{
					util.addValue(row, col++, "Not ok",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}
				else
				{
					util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}
				util.addValue(row, col++, data.getF5abbaccuraycol6Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				***/
				
				row++ ;
		}
		col = 1;
		util.mergeCell(row+2, row+2, col, col+5);
		util.addValue(row+2, col, "OBCC Completed = "+l+"%",Workbook2007Util.Style.STYLE_BOLD_LEFT, rowHeight);
		
		
		util.write(outputStream);
	}
	/**
	 * @param nightlst
	 * @param file
	 * @param outputStream
	 * @param l
	 * @throws IOException 
	 */
	public void getExcelReportForLeadOperatorPm5Night(List<LeadOperatorPM5> nightlst, File file,	ServletOutputStream outputStream, long l) throws IOException {
		
		Workbook2007Util util = new Workbook2007Util(file,0);
		util.setSheetName("Lead Operator  ", 0);
		  
		
		
		short rowHeight = 280;
		int row=3;
		int col=0;
		
		for(LeadOperatorPM5 data:nightlst)
		{
			col =0;
			if(data.isMachinedown()==true)
			{
				util.addValue(row, col++, "YES",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			else if(data.isMachinedown()==false)
			{
				util.addValue(row, col++, "NO",Workbook2007Util.Style.STYLE_NORMAL_CENTER_GREEN, rowHeight);
			}
			else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			util.addValue(row, col++, data.getEdate(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_GREEN, rowHeight);
			util.addValue(row, col++, data.getPosition(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.capitalizeFirstLetter(data.getShift()), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, data.getCrew(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			/**
				util.addValue(row, col++, data.getShowerwaterSystemcol1(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getShowerwaterSystemcol1Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				***/
				util.addValue(row, col++, data.getShowerwaterSystemcolin2(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getShowerwaterSystemcolout2(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getShowerwaterSystemcol2Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getShowerwaterSystemcolin3(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getShowerwaterSystemcolout3(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getShowerwaterSystemcol3Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				if(data.isShowerwaterSystemcol4() == true)
				{
						util.addValue(row, col++, "Ok",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
				}
				else if(data.isShowerwaterSystemcol4() == false)
				{
					util.addValue(row, col++, "Not Ok",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
				}
				else
				{
					util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}
				util.addValue(row, col++,data.getShowerwaterSystemcol4Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
						
				util.addValue(row, col++, data.getShowerwaterSystemcolin5(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getShowerwaterSystemcolout5(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getShowerwaterSystemcol5Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getShowerwaterSystemcol6(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getShowerwaterSystemcol6Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getShowerwaterSystemcol7(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getShowerwaterSystemcol7Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getShowerwaterSystemcolin8(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getShowerwaterSystemcolout8(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getShowerwaterSystemcol8Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				if(data.isShowerwaterSystemcol9() == true)
				{
						util.addValue(row, col++, "Ok",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
				}
				else if(data.isShowerwaterSystemcol9() == false)
				{
					util.addValue(row, col++, "Not Ok",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}
				else 
				{
					util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}
				util.addValue(row, col++,data.getShowerwaterSystemcol9Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				util.addValue(row, col++, data.getShowerwaterSystemcol10(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getShowerwaterSystemcol10Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				/***
				util.addValue(row, col++, data.getShowerwaterSystemcol11(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getShowerwaterSystemcol11Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				**/
				util.addValue(row, col++, data.getFanpumpcol1(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getFanpumpcol1Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getFanpumpcolin2(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getFanpumpcolout2(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getFanpumpcol2Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				if(data.isFanpumpcol3() == true)
				{
						util.addValue(row, col++, "Ok",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
				}
				else if(data.isFanpumpcol3() == false)
				{
					util.addValue(row, col++, "Not Ok",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
				}
				else
				{
					util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}
				util.addValue(row, col++,data.getFanpumpcol3Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				util.addValue(row, col++, data.getPrimarythinstockscreencol1(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getPrimarythinstockscreencol1Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getPrimarythinstockscreencol2(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getPrimarythinstockscreencol2Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				/**
				util.addValue(row, col++, data.getPrimarythinstockscreencol3(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getPrimarythinstockscreencol3Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				***/
				if(data.isPrimarythinstockscreencol4() == true)
				{
						util.addValue(row, col++, "Ok",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
				}
				else if(data.isPrimarythinstockscreencol4() == false)
				{
					util.addValue(row, col++, "Not Ok",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
				}
				else
				{
					util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}
				util.addValue(row, col++,data.getPrimarythinstockscreencol4Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				
				if(data.isVacuumpumpcol1() == true)
				{
						util.addValue(row, col++, "Ok",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
				}
				else if(data.isVacuumpumpcol1() == false)
				{
						util.addValue(row, col++, "Not Ok",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
				}
				else
				{
					util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}
				util.addValue(row, col++,data.getVacuumpumpcol1Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				util.addValue(row, col++, data.getVacuumpumpcolin2(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getVacuumpumpcolout2(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getVacuumpumpcol2Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getVacuumpumpcol3(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getVacuumpumpcol3Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getVacuumpumpcol4(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getVacuumpumpcol4Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getVacuumpumpcol5(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getVacuumpumpcol5Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getVacuumpumpcol6(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getVacuumpumpcol6Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getVacuumpumpcol7(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getVacuumpumpcol7Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getVacuumpumpcol8(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getVacuumpumpcol8Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getVacuumpumpcol9(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getVacuumpumpcol9Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getVacuumpumpcol10(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getVacuumpumpcol10Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getVacuumpumpcol11(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getVacuumpumpcol11Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getVacuumpumpcol12(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getVacuumpumpcol12Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getVacuumpumpcol13(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getVacuumpumpcol13Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getVacuumpumpcol14(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getVacuumpumpcol14Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getVacuumpumpcol15(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getVacuumpumpcol15Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getVacuumpumpcol16(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getVacuumpumpcol16Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getVacuumpumpcol17(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getVacuumpumpcol17Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getVacuumpumpcol18(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getVacuumpumpcol18Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
		row++ ;
		}
		col = 1;
		util.mergeCell(row+2, row+2, col, col+5);
		util.addValue(row+2, col, "OBCC Completed = "+l+"%",Workbook2007Util.Style.STYLE_BOLD_LEFT, rowHeight);
		util.write(outputStream);
	}
	/**
	 * @param daylst
	 * @param nightlst
	 * @param file
	 * @param outputStream
	 * @param l
	 * @throws IOException 
	 */
	public void getExcelReportForLeadOperatorPM5DayNight(
			List<LeadOperatorPM5> daylst, List<LeadOperatorPM5> nightlst,
			File file, ServletOutputStream outputStream, long l) throws IOException {
		
		Workbook2007Util util = new Workbook2007Util(file,0);
		util.setSheetName("Lead Operator  List ", 0);
		  			
		short rowHeight = 280;
		int row=3;
		int col=0;
		for(LeadOperatorPM5 data:daylst)
		{   
			col=0;
			if(data.isMachinedown()==true)
			{
				util.addValue(row, col++, "YES",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			else if(data.isMachinedown()==false)
			{
				util.addValue(row, col++, "NO",Workbook2007Util.Style.STYLE_NORMAL_CENTER_GREEN, rowHeight);
			}
			else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			util.addValue(row, col++,   data.getEdate(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, data.getPosition(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.capitalizeFirstLetter(data.getShift()), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, data.getCrew(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
		
						
				util.addValue(row, col++, data.getFormatingsectioncol1(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getFormatingsectioncol1Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getFormatingsectioncol2(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getFormatingsectioncol2Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getFormatingsectioncol3(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getFormatingsectioncol3Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getFormatingsectioncol4(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getFormatingsectioncol4Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getFormatingsectioncol5(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getFormatingsectioncol5Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getFormatingsectioncol6(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getFormatingsectioncol6Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getFormatingsectioncol7(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getFormatingsectioncol7Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				util.addValue(row, col++, data.getCouchrollcol1(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++,data.getCouchrollcol1Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getCouchrollcol2(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++,data.getCouchrollcol2Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getCouchrollcol3(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++,data.getCouchrollcol3Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getCouchrollcol4(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++,data.getCouchrollcol4Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getCouchrollcol5(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++,data.getCouchrollcol5Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				if(data.isCouchrollcol6()==true)
				{
					util.addValue(row, col++, "ok",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}
				else if(data.isCouchrollcol6()==false)
				{
					util.addValue(row, col++, "Not ok",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}else
				{
					util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}
				util.addValue(row, col++,data.getCouchrollcol6Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				if(data.isCouchrollcol7()==true)
				{
					util.addValue(row, col++, "ok",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}
				else if(data.isCouchrollcol7()==false)
				{
					util.addValue(row, col++, "Not ok",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}
				else
				{
					util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}
				util.addValue(row, col++,data.getCouchrollcol7Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				util.addValue(row, col++, data.getPicupfeltguidecol1(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getPicupfeltguidecol1Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getPicupfeltguidecol2(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getPicupfeltguidecol2Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getPicupfeltguidecol3(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getPicupfeltguidecol3Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getPicupfeltguidecol4(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getPicupfeltguidecol4Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				util.addValue(row, col++, data.getSuctionpressurerollcol1(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getSuctionpressurerollcol1Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getSuctionpressurerollcol2(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getSuctionpressurerollcol2Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getSuctionpressurerollcol3(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getSuctionpressurerollcol3Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getSuctionpressurerollcol4(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getSuctionpressurerollcol4Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getSuctionpressurerollcol5(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getSuctionpressurerollcol5Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				
				util.addValue(row, col++, data.getYankeedryerCol1(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getYankeedryerCol1Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getYankeedryerCol2(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getYankeedryerCol2Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getYankeedryerCol3(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getYankeedryerCol3Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getYankeedryerCol4(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getYankeedryerCol4Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				
				util.addValue(row, col++, data.getPressfeltareacol1(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++,data.getPressfeltareacol1Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				if(data.isPressfeltareacol2()==true)
				{
					util.addValue(row, col++, "ok",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}
				else if(data.isPressfeltareacol2()==false)
				{
					util.addValue(row, col++, "Not ok",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}
				else
				{
					util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}
				util.addValue(row, col++,data.getPressfeltareacol2Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getPressfeltareacol3(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++,data.getPressfeltareacol3Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getPressfeltareacol4(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++,data.getPressfeltareacol4Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getPressfeltareacol5(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++,data.getPressfeltareacol5Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getPressfeltareacol6(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++,data.getPressfeltareacol6Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getPressfeltareacol7(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++,data.getPressfeltareacol7Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getPressfeltareacol8(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++,data.getPressfeltareacol8Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				
				util.addValue(row, col++, data.getLubeoilsystemcol1(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++,data.getLubeoilsystemcol1Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getLubeoilsystemcol2(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++,data.getLubeoilsystemcol2Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getLubeoilsystemcol3(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++,data.getLubeoilsystemcol3Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getLubeoilsystemcol4(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++,data.getLubeoilsystemcol4Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getLubeoilsystemcol5(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++,data.getLubeoilsystemcol5Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getLubeoilsystemcol6(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++,data.getLubeoilsystemcol6Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getLubeoilsystemcol7(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++,data.getLubeoilsystemcol7Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				if(data.isF5abbaccuraycol1()==true)
				{
					util.addValue(row, col++, "ok",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}
				else if(data.isF5abbaccuraycol1()==false)
				{
					util.addValue(row, col++, "Not ok",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}
				else
				{
					util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}
				util.addValue(row, col++,data.getF5abbaccuraycol1Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				if(data.isF5abbaccuraycol2()==true)
				{
					util.addValue(row, col++, "ok",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}
				else if(data.isF5abbaccuraycol2()==false)
				{
					util.addValue(row, col++, "Not ok",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}
				else
				{
					util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}
				util.addValue(row, col++, data.getF5abbaccuraycol2Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				
				if(data.isF5abbaccuraycol3()==true)
				{
					util.addValue(row, col++, "ok",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}
				else if(data.isF5abbaccuraycol3()==false)
				{
					util.addValue(row, col++, "Not ok",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}
				else
				{
					util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}
				util.addValue(row, col++,data.getF5abbaccuraycol3Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				
				if(data.isF5abbaccuraycol4()==true)
				{
					util.addValue(row, col++, "ok",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}
				else if(data.isF5abbaccuraycol4()==false)
				{
					util.addValue(row, col++, "ok",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}
				else
				{
					util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}
				util.addValue(row, col++, data.getF5abbaccuraycol4Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				
				if(data.isF5abbaccuraycol5()==true)
				{
					util.addValue(row, col++, "ok",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}
				else if(data.isF5abbaccuraycol5()==false)
				{
					util.addValue(row, col++, "Not ok",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}
				else
				{
					util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}
				util.addValue(row, col++,data.getF5abbaccuraycol5Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				if(data.isF5abbaccuraycol6()==true)
				{
					util.addValue(row, col++, "ok",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}
				else if(data.isF5abbaccuraycol6()==false)
				{
					util.addValue(row, col++, "Not ok",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}
				else
				{
					util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}
				util.addValue(row, col++, data.getF5abbaccuraycol6Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				row++ ;
		}
		col = 0;		
		
			row=row+4;
			for(LeadOperatorPM5 data:nightlst)
			{
				col =0;
				if(data.isMachinedown()==true)
				{
					util.addValue(row, col++, "YES",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}
				else if(data.isMachinedown()==false)
				{
					util.addValue(row, col++, "NO",Workbook2007Util.Style.STYLE_NORMAL_CENTER_GREEN, rowHeight);
				}
				else
				{
					util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}
				util.addValue(row, col++, data.getEdate(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_GREEN, rowHeight);
				util.addValue(row, col++, data.getPosition(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
				util.addValue(row, col++, CommonUtil.capitalizeFirstLetter(data.getShift()), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
				util.addValue(row, col++, data.getCrew(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
				
					util.addValue(row, col++, data.getShowerwaterSystemcol1(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					util.addValue(row, col++, data.getShowerwaterSystemcol1Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					util.addValue(row, col++, data.getShowerwaterSystemcolin2(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					util.addValue(row, col++, data.getShowerwaterSystemcolout2(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					util.addValue(row, col++, data.getShowerwaterSystemcol2Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					util.addValue(row, col++, data.getShowerwaterSystemcolin3(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					util.addValue(row, col++, data.getShowerwaterSystemcolout3(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					util.addValue(row, col++, data.getShowerwaterSystemcol3Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					if(data.isShowerwaterSystemcol4() == true)
					{
							util.addValue(row, col++, "Ok",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
					}
					else if(data.isShowerwaterSystemcol4() == false)
					{
						util.addValue(row, col++, "Not Ok",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
					}
					else
					{
						util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					}
					util.addValue(row, col++,data.getShowerwaterSystemcol4Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
							
					util.addValue(row, col++, data.getShowerwaterSystemcolin5(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					util.addValue(row, col++, data.getShowerwaterSystemcolout5(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					util.addValue(row, col++, data.getShowerwaterSystemcol5Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					util.addValue(row, col++, data.getShowerwaterSystemcol6(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					util.addValue(row, col++, data.getShowerwaterSystemcol6Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					util.addValue(row, col++, data.getShowerwaterSystemcol7(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					util.addValue(row, col++, data.getShowerwaterSystemcol7Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					util.addValue(row, col++, data.getShowerwaterSystemcolin8(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					util.addValue(row, col++, data.getShowerwaterSystemcolout8(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					util.addValue(row, col++, data.getShowerwaterSystemcol8Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					if(data.isShowerwaterSystemcol9() == true)
					{
							util.addValue(row, col++, "Ok",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
					}
					else if(data.isShowerwaterSystemcol9() == false)
					{
						util.addValue(row, col++, "Not Ok",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					}
					else 
					{
						util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					}
					util.addValue(row, col++,data.getShowerwaterSystemcol9Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					
					util.addValue(row, col++, data.getShowerwaterSystemcol10(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					util.addValue(row, col++, data.getShowerwaterSystemcol10Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					util.addValue(row, col++, data.getShowerwaterSystemcol11(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					util.addValue(row, col++, data.getShowerwaterSystemcol11Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					
					util.addValue(row, col++, data.getFanpumpcol1(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					util.addValue(row, col++, data.getFanpumpcol1Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					util.addValue(row, col++, data.getFanpumpcolin2(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					util.addValue(row, col++, data.getFanpumpcolout2(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					util.addValue(row, col++, data.getFanpumpcol2Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					if(data.isFanpumpcol3() == true)
					{
							util.addValue(row, col++, "Ok",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
					}
					else if(data.isFanpumpcol3() == false)
					{
						util.addValue(row, col++, "Not Ok",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
					}
					else
					{
						util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					}
					util.addValue(row, col++,data.getFanpumpcol3Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					
					util.addValue(row, col++, data.getPrimarythinstockscreencol1(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					util.addValue(row, col++, data.getPrimarythinstockscreencol1Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					util.addValue(row, col++, data.getPrimarythinstockscreencol2(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					util.addValue(row, col++, data.getPrimarythinstockscreencol2Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					util.addValue(row, col++, data.getPrimarythinstockscreencol3(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					util.addValue(row, col++, data.getPrimarythinstockscreencol3Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					if(data.isPrimarythinstockscreencol4() == true)
					{
							util.addValue(row, col++, "Ok",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
					}
					else if(data.isPrimarythinstockscreencol4() == false)
					{
						util.addValue(row, col++, "Not Ok",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
					}
					else
					{
						util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					}
					util.addValue(row, col++,data.getPrimarythinstockscreencol4Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					
					
					if(data.isVacuumpumpcol1() == true)
					{
							util.addValue(row, col++, "Ok",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
					}
					else if(data.isVacuumpumpcol1() == false)
					{
							util.addValue(row, col++, "Not Ok",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
					}
					else
					{
						util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					}
					util.addValue(row, col++,data.getVacuumpumpcol1Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					
					util.addValue(row, col++, data.getVacuumpumpcolin2(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					util.addValue(row, col++, data.getVacuumpumpcolout2(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					util.addValue(row, col++, data.getVacuumpumpcol2Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					util.addValue(row, col++, data.getVacuumpumpcol3(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					util.addValue(row, col++, data.getVacuumpumpcol3Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					util.addValue(row, col++, data.getVacuumpumpcol4(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					util.addValue(row, col++, data.getVacuumpumpcol4Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					util.addValue(row, col++, data.getVacuumpumpcol5(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					util.addValue(row, col++, data.getVacuumpumpcol5Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					util.addValue(row, col++, data.getVacuumpumpcol6(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					util.addValue(row, col++, data.getVacuumpumpcol6Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					util.addValue(row, col++, data.getVacuumpumpcol7(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					util.addValue(row, col++, data.getVacuumpumpcol7Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					util.addValue(row, col++, data.getVacuumpumpcol8(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					util.addValue(row, col++, data.getVacuumpumpcol8Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					util.addValue(row, col++, data.getVacuumpumpcol9(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					util.addValue(row, col++, data.getVacuumpumpcol9Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					util.addValue(row, col++, data.getVacuumpumpcol10(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					util.addValue(row, col++, data.getVacuumpumpcol10Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					util.addValue(row, col++, data.getVacuumpumpcol11(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					util.addValue(row, col++, data.getVacuumpumpcol11Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					util.addValue(row, col++, data.getVacuumpumpcol12(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					util.addValue(row, col++, data.getVacuumpumpcol12Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					util.addValue(row, col++, data.getVacuumpumpcol13(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					util.addValue(row, col++, data.getVacuumpumpcol13Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					util.addValue(row, col++, data.getVacuumpumpcol14(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					util.addValue(row, col++, data.getVacuumpumpcol14Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					util.addValue(row, col++, data.getVacuumpumpcol15(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					util.addValue(row, col++, data.getVacuumpumpcol15Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					util.addValue(row, col++, data.getVacuumpumpcol16(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					util.addValue(row, col++, data.getVacuumpumpcol16Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					util.addValue(row, col++, data.getVacuumpumpcol17(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					util.addValue(row, col++, data.getVacuumpumpcol17Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					util.addValue(row, col++, data.getVacuumpumpcol18(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					util.addValue(row, col++, data.getVacuumpumpcol18Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				row++ ;
		}
		col = 1;
		util.mergeCell(row+2, row+2, col, col+5);
		util.addValue(row+2, col, "OBCC Completed = "+l+"%",Workbook2007Util.Style.STYLE_BOLD_LEFT, rowHeight);
		util.write(outputStream);	
 }
	/**
	 * @param lst
	 * @param file
	 * @param outputStream
	 * @param l
	 * @throws IOException 
	 */
	public void getExcelReportForR1OperaotrPM5(List<R1OperatorPM5> lst, File file,ServletOutputStream outputStream, long l) throws IOException {
		
		Workbook2007Util util = new Workbook2007Util(file,0);
		util.setSheetName("R1 Operator ", 0);
		
		short rowHeight = 280;
		int row=3;
		int col=0;
		
		for(R1OperatorPM5 data:lst){
			col =0;
			if(data.isMachinedown()==true)
			{
				util.addValue(row, col++, "YES",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			else if(data.isMachinedown()==false)
			{
				util.addValue(row, col++, "NO",Workbook2007Util.Style.STYLE_NORMAL_CENTER_GREEN, rowHeight);
			}
			else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			util.addValue(row, col++,   data.getEdate(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.capitalizeFirstLetter(data.getPosition()), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.capitalizeFirstLetter(data.getShift()), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, data.getCrew(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			
			
			if(data.isLeadInRollCol1() == true)
			{
				util.addValue(row, col++, "OverHeating",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isLeadInRollCol1() == false)
			{
				util.addValue(row, col++, "No OverHeating",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			else 
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			
			util.addValue(row, col++, data.getLeadInRollCol1Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			if(data.isLeadInRollCol2() == true)
			{
				util.addValue(row, col++, "Oil Leakage",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isLeadInRollCol2() == false)
			{
				util.addValue(row, col++, "No Oil Leakage",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			
			util.addValue(row, col++, data.getLeadInRollCol2Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			
			
			if(data.isLeadInRollCol3() == true)
			{
				util.addValue(row, col++, "Abnormal Sound",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isLeadInRollCol3() == false)
			{
				util.addValue(row, col++, "No Abnormal Sound",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			
			util.addValue(row, col++, data.getLeadInRollCol3Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			if(data.isLeadInRollCol4() == true)
			{
				util.addValue(row, col++, "OverHeating",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isLeadInRollCol4() == false)
			{
				util.addValue(row, col++, "No OverHeating",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			
			util.addValue(row, col++, data.getLeadInRollCol4Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
            if(data.isLeadInRollCol5() == true)
			{
				util.addValue(row, col++, "Abnormal Sound",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else  if(data.isLeadInRollCol5() == false)
			{
				util.addValue(row, col++, "No Abnormal Sound",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
            else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			
			util.addValue(row, col++, data.getLeadInRollCol5Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			 
			
			if(data.isSectionRollCol1() == true)
			{
				util.addValue(row, col++, "Free Turning",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isSectionRollCol1() == false)
			{
				util.addValue(row, col++, "NOT Turning",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			
			util.addValue(row, col++, data.getSectionRollCol1Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			
			
			if(data.isBreakAssemblyCol1() == true)
			{
				util.addValue(row, col++, "Leakage",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isBreakAssemblyCol1() == false)
			{
				util.addValue(row, col++, "No Leakage",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			
			util.addValue(row, col++, data.getBreakAssemblyCol1Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			if(data.isBreakAssemblyCol2() == true)
			{
				util.addValue(row, col++, "Ok",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isBreakAssemblyCol2() == false)
			{
				util.addValue(row, col++, "Not Ok",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			
			util.addValue(row, col++, data.getBreakAssemblyCol2Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
		
			
			if(data.isSlittersCol1() == true)
			{
				util.addValue(row, col++, "Ok",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isSlittersCol1() == false)
			{
				util.addValue(row, col++, "Not Ok",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			
			util.addValue(row, col++, data.getSlittersCol1Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			if(data.isSlittersCol2() == true)
			{
				util.addValue(row, col++, "Ok",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isSlittersCol2() == false)
			{
				util.addValue(row, col++, "Not Ok",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			
			util.addValue(row, col++, data.getSlittersCol2Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			if(data.isSlittersCol3() == true)
			{
				util.addValue(row, col++, "Ok",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isSlittersCol3() == false)
			{
				util.addValue(row, col++, "Not Ok",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			
			util.addValue(row, col++, data.getSlittersCol3Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			
			if(data.isTrimAssemblyCol1() == true)
			{
				util.addValue(row, col++, "Ok",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isTrimAssemblyCol1() ==false)
			{
				util.addValue(row, col++, "Not Ok",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			
			util.addValue(row, col++, data.getTrimAssemblyCol1Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			
			if(data.isTrimAssemblyCol2() == true)
			{
				util.addValue(row, col++, "OverHeating",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isTrimAssemblyCol2() == false)
			{
				util.addValue(row, col++, "No OverHeating",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			
			util.addValue(row, col++, data.getTrimAssemblyCol2Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			if(data.isTrimAssemblyCol3() == true)
			{
				util.addValue(row, col++, "Abnormal Sound",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isTrimAssemblyCol3() == false)
			{
				util.addValue(row, col++, "No Abnormal Sound",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else
			{
				util.addValue(row, col++, " ",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			
			util.addValue(row, col++, data.getTrimAssemblyCol3Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			
			if(data.isTrimAssemblyCol4() == true)
			{
				util.addValue(row, col++, "OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isTrimAssemblyCol4() == false)
			{
				util.addValue(row, col++, "Not OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			
			util.addValue(row, col++, data.getTrimAssemblyCol4Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
		
			
			if(data.isTensiionRollCol1() == true)
			{
				util.addValue(row, col++, "Free Turning",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isTensiionRollCol1() == false)
			{
				util.addValue(row, col++, "Not Turning",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			
			util.addValue(row, col++, data.getTensiionRollCol1Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			
			if(data.isTensiionRollCol2() == true)
			{
				util.addValue(row, col++, "Build Up",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isTensiionRollCol2() == false)
			{
				util.addValue(row, col++, "No Build Up",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			
			util.addValue(row, col++, data.getTensiionRollCol2Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			
			if(data.isTensiionRollCol3() == true)
			{
				util.addValue(row, col++, "OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isTensiionRollCol3() == false)
			{
				util.addValue(row, col++, "OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			
			util.addValue(row, col++, data.getTensiionRollCol3Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			
			if(data.isWinderDrum1Col1() == true)
			{
				util.addValue(row, col++, "OverHeating",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isWinderDrum1Col1() ==false)
			{
				util.addValue(row, col++, " No OverHeating",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			
			util.addValue(row, col++, data.getWinderDrum1Col1Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			if(data.isWinderDrum1Col2() == true)
			{
				util.addValue(row, col++, "Oil Leakage",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isWinderDrum1Col2() == false)
			{
				util.addValue(row, col++, "No Oil Leakage",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			
			util.addValue(row, col++, data.getWinderDrum1Col2Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			
			
			if(data.isWinderDrum1Col3() == true)
			{
				util.addValue(row, col++, "Abnormal Sound",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isWinderDrum1Col3() == false)
			{
				util.addValue(row, col++, "No Abnormal Sound",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			
			util.addValue(row, col++, data.getWinderDrum1Col3Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
		
			if(data.isWinderDrum1Col4() == true)
			{
				util.addValue(row, col++, "OverHeating",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isWinderDrum1Col4() == false)
			{
				util.addValue(row, col++, "No OverHeating",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			
			util.addValue(row, col++, data.getWinderDrum1Col4Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);

			
			
			if(data.isWinderDrum1Col5() == true)
			{
				util.addValue(row, col++, "Abnormal Sound",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isWinderDrum1Col5() ==false)
			{
				util.addValue(row, col++, "No Abnormal Sound",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			
			util.addValue(row, col++, data.getWinderDrum1Col5Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
			
			if(data.isWinderDrum2Col1() == true)
			{
				util.addValue(row, col++, "OverHeating",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isWinderDrum2Col1() == false)
			{
				util.addValue(row, col++, "No OverHeating",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			
			util.addValue(row, col++, data.getWinderDrum2Col1Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			if(data.isWinderDrum2Col2() == true)
			{
				util.addValue(row, col++, "Oil Leakage",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isWinderDrum2Col2() == false)
			{
				util.addValue(row, col++, "No Oil Leakage",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			
			util.addValue(row, col++, data.getWinderDrum2Col2Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			
			
			if(data.isWinderDrum2Col3() == true)
			{
				util.addValue(row, col++, "Abnormal Sound",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isWinderDrum2Col3() == false)
			{
				util.addValue(row, col++, "No Abnormal Sound",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			
			util.addValue(row, col++, data.getWinderDrum2Col3Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			//
			
			if(data.isWinderDrum2Col4() == true)
			{
				util.addValue(row, col++, "OverHeating",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isWinderDrum2Col4() == false)
			{
				util.addValue(row, col++, "No OverHeating",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			
			util.addValue(row, col++, data.getWinderDrum2Col4Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);

			
			
			if(data.isWinderDrum2Col5() == true)
			{
				util.addValue(row, col++, "Abnormal Sound",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			if(data.isWinderDrum2Col5() == false)
			{
				util.addValue(row, col++, "No Abnormal Sound",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			
			util.addValue(row, col++, data.getWinderDrum2Col5Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
		
			
			if(data.isRollEjectorCol1() == true)
			{
				util.addValue(row, col++, "OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isRollEjectorCol1() == false)
			{
				util.addValue(row, col++, "Not OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			
			util.addValue(row, col++, data.getRollEjectorCol1Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			
			if(data.isRollEjectorCol2() == true)
			{
				util.addValue(row, col++, "OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isRollEjectorCol2() == false)
			{
				util.addValue(row, col++, "Not OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			
			util.addValue(row, col++, data.getRollEjectorCol2Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			
			if(data.isRollEjectorCol3() == true)
			{
				util.addValue(row, col++, "OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isRollEjectorCol3() == false)
			{
				util.addValue(row, col++, "Not OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			
			util.addValue(row, col++, data.getRollEjectorCol3Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			
			
			if(data.isRiderRollCol1() == true)
			{
				util.addValue(row, col++, "OverHeating",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isRiderRollCol1() == false)
			{
				util.addValue(row, col++, "No OverHeating",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			
			util.addValue(row, col++, data.getRiderRollCol1Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			
			if(data.isRiderRollCol2() == true)
			{
				util.addValue(row, col++, "Oil Leakage",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isRiderRollCol2() == false)
			{
				util.addValue(row, col++, "No Oil Leakage",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			
			util.addValue(row, col++, data.getRiderRollCol2Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			
			if(data.isRiderRollCol3() == true)
			{
				util.addValue(row, col++, "Abnormal Sound",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isRiderRollCol3() == false)
			{
				util.addValue(row, col++, "No Abnormal Sound",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			
			util.addValue(row, col++, data.getRiderRollCol3Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
		
			if(data.isRiderRollCol4() == true)
			{
				util.addValue(row, col++, "OverHeating",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isRiderRollCol4() == false)
			{
				util.addValue(row, col++, "No OverHeating",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			
			util.addValue(row, col++, data.getRiderRollCol4Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			
			if(data.isRiderRollCol5() == true)
			{
				util.addValue(row, col++, "Abnormal Sound",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isRiderRollCol5() == false)
			{
				util.addValue(row, col++, "No Abnormal Sound",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			
			util.addValue(row, col++, data.getRiderRollCol5Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			
			
			if(data.isRiderRollCol6() == true)
			{
				util.addValue(row, col++, "OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isRiderRollCol6() == false)
			{
				util.addValue(row, col++, "Not OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			
			util.addValue(row, col++, data.getRiderRollCol6Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			
			if(data.isRiderRollCol7() == true)
			{
				util.addValue(row, col++, "OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isRiderRollCol7() == false)
			{
				util.addValue(row, col++, "Not OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			
			util.addValue(row, col++, data.getRiderRollCol7Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			if(data.isRiderRollCol8() == true)
			{
				util.addValue(row, col++, "OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isRiderRollCol8() == false)
			{
				util.addValue(row, col++, "Not OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			
			util.addValue(row, col++, data.getRiderRollCol8Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			
			
			if(data.isBowedRollCol1() == true)
			{
				util.addValue(row, col++, "OverHeating",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isBowedRollCol1() == false)
			{
				util.addValue(row, col++, "No OverHeating",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			
			util.addValue(row, col++, data.getBowedRollCol1Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			
			if(data.isBowedRollCol2() == true)
			{
				util.addValue(row, col++, "Abnormal Sound",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isBowedRollCol2() == false)
			{
				util.addValue(row, col++, "No Abnormal Sound",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			
			util.addValue(row, col++, data.getBowedRollCol2Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			
			
			if(data.isBowedRollCol3() == true)
			{
				util.addValue(row, col++, "OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isBowedRollCol3() == false)
			{
				util.addValue(row, col++, "Not OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			
			util.addValue(row, col++, data.getBowedRollCol3Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			 
			
			if(data.isCoreChucksCol1() == true)
			{
				util.addValue(row, col++, "OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isCoreChucksCol1() == false)
			{
				util.addValue(row, col++, "Not OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			
			util.addValue(row, col++, data.getCoreChucksCol1Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			
			
			if(data.isCoreChucksCol2() == true)
			{
				util.addValue(row, col++, "OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isCoreChucksCol2() == false)
			{
				util.addValue(row, col++, "Not OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			
			util.addValue(row, col++, data.getCoreChucksCol2Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			
			if(data.isCoreChucksCol3() == true)
			{
				util.addValue(row, col++, "OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isCoreChucksCol3() == false)
			{
				util.addValue(row, col++, "Not OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			
			util.addValue(row, col++, data.getCoreChucksCol3Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			
			if(data.isCoreChucksCol4() == true)
			{
				util.addValue(row, col++, "Leakage",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isCoreChucksCol4() == false)
			{
				util.addValue(row, col++, "No Leakage",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			
			util.addValue(row, col++, data.getCoreChucksCol4Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			 
			
			if(data.isNipGuardCol1() == true)
			{
				util.addValue(row, col++, "OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isNipGuardCol1() == false)
			{
				util.addValue(row, col++, "Not OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			
			util.addValue(row, col++, data.getNipGuardCol1Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			
			if(data.isNipGuardCol2() == true)
			{
				util.addValue(row, col++, "OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isNipGuardCol2() == false)
			{
				util.addValue(row, col++, "Not OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			
			util.addValue(row, col++, data.getNipGuardCol2Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			
			if(data.isNipGuardCol3() == true)
			{
				util.addValue(row, col++, "Leakage",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isNipGuardCol3() == false)
			{
				util.addValue(row, col++, "No Leakage",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			
			util.addValue(row, col++, data.getNipGuardCol3Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			
			if(data.isTableLeftGateCol1() == true)
			{
				util.addValue(row, col++, "OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isTableLeftGateCol1() ==false)
			{
				util.addValue(row, col++, "Not OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			
			util.addValue(row, col++, data.getTableLeftGateCol1Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			
			if(data.isTableLeftGateCol2() == true)
			{
				util.addValue(row, col++, "OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isTableLeftGateCol2() == false)
			{
				util.addValue(row, col++, "Not OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			
			util.addValue(row, col++, data.getTableLeftGateCol2Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			 
			
			row++;
		}
		col = 1;
		util.mergeCell(row+2, row+2, col, col+5);
		util.addValue(row+2, col, "OBCC Completed = "+l+"%",Workbook2007Util.Style.STYLE_BOLD_LEFT, rowHeight);
		
		
		util.write(outputStream);
	
		
	}
	/**
	 * @param lst
	 * @param nightlst 
	 * @param file
	 * @param outputStream
	 * @param l
	 * @throws IOException 
	 */
	public void getExcelReportForR1OperaotrPM5DayNight(List<R1OperatorPM5> both, File file, ServletOutputStream outputStream, long l) throws IOException {
		Workbook2007Util util = new Workbook2007Util(file,0);
		util.setSheetName("R1 Operator ", 0);
		
		short rowHeight = 280;
		int row=3;
		int col=0;
		for(R1OperatorPM5 data:both){
			col =0;
			if(data.isMachinedown()==true)
			{
				util.addValue(row, col++, "YES",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			else if(data.isMachinedown()==false)
			{
				util.addValue(row, col++, "NO",Workbook2007Util.Style.STYLE_NORMAL_CENTER_GREEN, rowHeight);
			}
			else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			util.addValue(row, col++,   data.getEdate(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.capitalizeFirstLetter(data.getPosition()), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.capitalizeFirstLetter(data.getShift()), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, data.getCrew(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			
			
			if(data.isLeadInRollCol1() == true)
			{
				util.addValue(row, col++, "OverHeating",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isLeadInRollCol1() == false)
			{
				util.addValue(row, col++, "No OverHeating",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			else 
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			
			util.addValue(row, col++, data.getLeadInRollCol1Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			if(data.isLeadInRollCol2() == true)
			{
				util.addValue(row, col++, "Oil Leakage",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isLeadInRollCol2() == false)
			{
				util.addValue(row, col++, "No Oil Leakage",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			
			util.addValue(row, col++, data.getLeadInRollCol2Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			
			
			if(data.isLeadInRollCol3() == true)
			{
				util.addValue(row, col++, "Abnormal Sound",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isLeadInRollCol3() == false)
			{
				util.addValue(row, col++, "No Abnormal Sound",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			
			util.addValue(row, col++, data.getLeadInRollCol3Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			if(data.isLeadInRollCol4() == true)
			{
				util.addValue(row, col++, "OverHeating",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isLeadInRollCol4() == false)
			{
				util.addValue(row, col++, "No OverHeating",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			
			util.addValue(row, col++, data.getLeadInRollCol4Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
            if(data.isLeadInRollCol5() == true)
			{
				util.addValue(row, col++, "Abnormal Sound",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else  if(data.isLeadInRollCol5() == false)
			{
				util.addValue(row, col++, "No Abnormal Sound",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
            else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			
			util.addValue(row, col++, data.getLeadInRollCol5Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			 
			
			if(data.isSectionRollCol1() == true)
			{
				util.addValue(row, col++, "Free Turning",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isSectionRollCol1() == false)
			{
				util.addValue(row, col++, "NOT Turning",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			
			util.addValue(row, col++, data.getSectionRollCol1Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			
			
			if(data.isBreakAssemblyCol1() == true)
			{
				util.addValue(row, col++, "Leakage",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isBreakAssemblyCol1() == false)
			{
				util.addValue(row, col++, "No Leakage",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			
			util.addValue(row, col++, data.getBreakAssemblyCol1Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			if(data.isBreakAssemblyCol2() == true)
			{
				util.addValue(row, col++, "Ok",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isBreakAssemblyCol2() == false)
			{
				util.addValue(row, col++, "Not Ok",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			
			util.addValue(row, col++, data.getBreakAssemblyCol2Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
		
			
			if(data.isSlittersCol1() == true)
			{
				util.addValue(row, col++, "Ok",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isSlittersCol1() == false)
			{
				util.addValue(row, col++, "Not Ok",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			
			util.addValue(row, col++, data.getSlittersCol1Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			if(data.isSlittersCol2() == true)
			{
				util.addValue(row, col++, "Ok",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isSlittersCol2() == false)
			{
				util.addValue(row, col++, "Not Ok",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			
			util.addValue(row, col++, data.getSlittersCol2Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			if(data.isSlittersCol3() == true)
			{
				util.addValue(row, col++, "Ok",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isSlittersCol3() == false)
			{
				util.addValue(row, col++, "Not Ok",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			
			util.addValue(row, col++, data.getSlittersCol3Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			
			if(data.isTrimAssemblyCol1() == true)
			{
				util.addValue(row, col++, "Ok",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isTrimAssemblyCol1() ==false)
			{
				util.addValue(row, col++, "Not Ok",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			
			util.addValue(row, col++, data.getTrimAssemblyCol1Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			
			if(data.isTrimAssemblyCol2() == true)
			{
				util.addValue(row, col++, "OverHeating",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isTrimAssemblyCol2() == false)
			{
				util.addValue(row, col++, "No OverHeating",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			
			util.addValue(row, col++, data.getTrimAssemblyCol2Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			if(data.isTrimAssemblyCol3() == true)
			{
				util.addValue(row, col++, "Abnormal Sound",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isTrimAssemblyCol3() == false)
			{
				util.addValue(row, col++, "No Abnormal Sound",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else
			{
				util.addValue(row, col++, " ",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			
			util.addValue(row, col++, data.getTrimAssemblyCol3Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			
			if(data.isTrimAssemblyCol4() == true)
			{
				util.addValue(row, col++, "OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isTrimAssemblyCol4() == false)
			{
				util.addValue(row, col++, "Not OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			
			util.addValue(row, col++, data.getTrimAssemblyCol4Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
		
			
			if(data.isTensiionRollCol1() == true)
			{
				util.addValue(row, col++, "Free Turning",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isTensiionRollCol1() == false)
			{
				util.addValue(row, col++, "Not Turning",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			
			util.addValue(row, col++, data.getTensiionRollCol1Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			
			if(data.isTensiionRollCol2() == true)
			{
				util.addValue(row, col++, "Build Up",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isTensiionRollCol2() == false)
			{
				util.addValue(row, col++, "No Build Up",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			
			util.addValue(row, col++, data.getTensiionRollCol2Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			
			if(data.isTensiionRollCol3() == true)
			{
				util.addValue(row, col++, "OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isTensiionRollCol3() == false)
			{
				util.addValue(row, col++, "OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			
			util.addValue(row, col++, data.getTensiionRollCol3Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			
			if(data.isWinderDrum1Col1() == true)
			{
				util.addValue(row, col++, "OverHeating",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isWinderDrum1Col1() ==false)
			{
				util.addValue(row, col++, " No OverHeating",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			
			util.addValue(row, col++, data.getWinderDrum1Col1Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			if(data.isWinderDrum1Col2() == true)
			{
				util.addValue(row, col++, "Oil Leakage",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isWinderDrum1Col2() == false)
			{
				util.addValue(row, col++, "No Oil Leakage",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			
			util.addValue(row, col++, data.getWinderDrum1Col2Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			
			
			if(data.isWinderDrum1Col3() == true)
			{
				util.addValue(row, col++, "Abnormal Sound",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isWinderDrum1Col3() == false)
			{
				util.addValue(row, col++, "No Abnormal Sound",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			
			util.addValue(row, col++, data.getWinderDrum1Col3Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
		
			if(data.isWinderDrum1Col4() == true)
			{
				util.addValue(row, col++, "OverHeating",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isWinderDrum1Col4() == false)
			{
				util.addValue(row, col++, "No OverHeating",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			
			util.addValue(row, col++, data.getWinderDrum1Col4Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);

			
			
			if(data.isWinderDrum1Col5() == true)
			{
				util.addValue(row, col++, "Abnormal Sound",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isWinderDrum1Col5() ==false)
			{
				util.addValue(row, col++, "No Abnormal Sound",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			
			util.addValue(row, col++, data.getWinderDrum1Col5Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
			
			if(data.isWinderDrum2Col1() == true)
			{
				util.addValue(row, col++, "OverHeating",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isWinderDrum2Col1() == false)
			{
				util.addValue(row, col++, "No OverHeating",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			
			util.addValue(row, col++, data.getWinderDrum2Col1Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			if(data.isWinderDrum2Col2() == true)
			{
				util.addValue(row, col++, "Oil Leakage",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isWinderDrum2Col2() == false)
			{
				util.addValue(row, col++, "No Oil Leakage",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			
			util.addValue(row, col++, data.getWinderDrum2Col2Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			
			
			if(data.isWinderDrum2Col3() == true)
			{
				util.addValue(row, col++, "Abnormal Sound",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isWinderDrum2Col3() == false)
			{
				util.addValue(row, col++, "No Abnormal Sound",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			
			util.addValue(row, col++, data.getWinderDrum2Col3Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			//
			
			if(data.isWinderDrum2Col4() == true)
			{
				util.addValue(row, col++, "OverHeating",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isWinderDrum2Col4() == false)
			{
				util.addValue(row, col++, "No OverHeating",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			
			util.addValue(row, col++, data.getWinderDrum2Col4Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);

			
			
			if(data.isWinderDrum2Col5() == true)
			{
				util.addValue(row, col++, "Abnormal Sound",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			if(data.isWinderDrum2Col5() == false)
			{
				util.addValue(row, col++, "No Abnormal Sound",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			
			util.addValue(row, col++, data.getWinderDrum2Col5Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
		
			
			if(data.isRollEjectorCol1() == true)
			{
				util.addValue(row, col++, "OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isRollEjectorCol1() == false)
			{
				util.addValue(row, col++, "Not OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			
			util.addValue(row, col++, data.getRollEjectorCol1Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			
			if(data.isRollEjectorCol2() == true)
			{
				util.addValue(row, col++, "OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isRollEjectorCol2() == false)
			{
				util.addValue(row, col++, "Not OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			
			util.addValue(row, col++, data.getRollEjectorCol2Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			
			if(data.isRollEjectorCol3() == true)
			{
				util.addValue(row, col++, "OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isRollEjectorCol3() == false)
			{
				util.addValue(row, col++, "Not OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			
			util.addValue(row, col++, data.getRollEjectorCol3Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			
			
			if(data.isRiderRollCol1() == true)
			{
				util.addValue(row, col++, "OverHeating",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isRiderRollCol1() == false)
			{
				util.addValue(row, col++, "No OverHeating",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			
			util.addValue(row, col++, data.getRiderRollCol1Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			
			if(data.isRiderRollCol2() == true)
			{
				util.addValue(row, col++, "Oil Leakage",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isRiderRollCol2() == false)
			{
				util.addValue(row, col++, "No Oil Leakage",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			
			util.addValue(row, col++, data.getRiderRollCol2Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			
			if(data.isRiderRollCol3() == true)
			{
				util.addValue(row, col++, "Abnormal Sound",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isRiderRollCol3() == false)
			{
				util.addValue(row, col++, "No Abnormal Sound",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			
			util.addValue(row, col++, data.getRiderRollCol3Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
		
			if(data.isRiderRollCol4() == true)
			{
				util.addValue(row, col++, "OverHeating",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isRiderRollCol4() == false)
			{
				util.addValue(row, col++, "No OverHeating",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			
			util.addValue(row, col++, data.getRiderRollCol4Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			
			if(data.isRiderRollCol5() == true)
			{
				util.addValue(row, col++, "Abnormal Sound",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isRiderRollCol5() == false)
			{
				util.addValue(row, col++, "No Abnormal Sound",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			
			util.addValue(row, col++, data.getRiderRollCol5Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			
			
			if(data.isRiderRollCol6() == true)
			{
				util.addValue(row, col++, "OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isRiderRollCol6() == false)
			{
				util.addValue(row, col++, "Not OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			
			util.addValue(row, col++, data.getRiderRollCol6Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			
			if(data.isRiderRollCol7() == true)
			{
				util.addValue(row, col++, "OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isRiderRollCol7() == false)
			{
				util.addValue(row, col++, "Not OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			
			util.addValue(row, col++, data.getRiderRollCol7Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			if(data.isRiderRollCol8() == true)
			{
				util.addValue(row, col++, "OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isRiderRollCol8() == false)
			{
				util.addValue(row, col++, "Not OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			
			util.addValue(row, col++, data.getRiderRollCol8Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			
			
			if(data.isBowedRollCol1() == true)
			{
				util.addValue(row, col++, "OverHeating",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isBowedRollCol1() == false)
			{
				util.addValue(row, col++, "No OverHeating",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			
			util.addValue(row, col++, data.getBowedRollCol1Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			
			if(data.isBowedRollCol2() == true)
			{
				util.addValue(row, col++, "Abnormal Sound",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isBowedRollCol2() == false)
			{
				util.addValue(row, col++, "No Abnormal Sound",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			
			util.addValue(row, col++, data.getBowedRollCol2Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			
			
			if(data.isBowedRollCol3() == true)
			{
				util.addValue(row, col++, "OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isBowedRollCol3() == false)
			{
				util.addValue(row, col++, "Not OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			
			util.addValue(row, col++, data.getBowedRollCol3Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			 
			
			if(data.isCoreChucksCol1() == true)
			{
				util.addValue(row, col++, "OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isCoreChucksCol1() == false)
			{
				util.addValue(row, col++, "Not OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			
			util.addValue(row, col++, data.getCoreChucksCol1Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			
			
			if(data.isCoreChucksCol2() == true)
			{
				util.addValue(row, col++, "OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isCoreChucksCol2() == false)
			{
				util.addValue(row, col++, "Not OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			
			util.addValue(row, col++, data.getCoreChucksCol2Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			
			if(data.isCoreChucksCol3() == true)
			{
				util.addValue(row, col++, "OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isCoreChucksCol3() == false)
			{
				util.addValue(row, col++, "Not OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			
			util.addValue(row, col++, data.getCoreChucksCol3Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			
			if(data.isCoreChucksCol4() == true)
			{
				util.addValue(row, col++, "Leakage",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isCoreChucksCol4() == false)
			{
				util.addValue(row, col++, "No Leakage",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			
			util.addValue(row, col++, data.getCoreChucksCol4Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			 
			
			if(data.isNipGuardCol1() == true)
			{
				util.addValue(row, col++, "OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isNipGuardCol1() == false)
			{
				util.addValue(row, col++, "Not OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			
			util.addValue(row, col++, data.getNipGuardCol1Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			
			if(data.isNipGuardCol2() == true)
			{
				util.addValue(row, col++, "OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isNipGuardCol2() == false)
			{
				util.addValue(row, col++, "Not OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			
			util.addValue(row, col++, data.getNipGuardCol2Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			
			if(data.isNipGuardCol3() == true)
			{
				util.addValue(row, col++, "Leakage",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isNipGuardCol3() == false)
			{
				util.addValue(row, col++, "No Leakage",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			
			util.addValue(row, col++, data.getNipGuardCol3Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			
			if(data.isTableLeftGateCol1() == true)
			{
				util.addValue(row, col++, "OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isTableLeftGateCol1() ==false)
			{
				util.addValue(row, col++, "Not OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			
			util.addValue(row, col++, data.getTableLeftGateCol1Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			
			if(data.isTableLeftGateCol2() == true)
			{
				util.addValue(row, col++, "OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isTableLeftGateCol2() == false)
			{
				util.addValue(row, col++, "Not OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			
			util.addValue(row, col++, data.getTableLeftGateCol2Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			 
			
			row++;
		}
		col=1;
		util.mergeCell(row+2, row+2, col, col+5);
		util.addValue(row+2, col, "OBCC Completed = "+l+"%",Workbook2007Util.Style.STYLE_BOLD_LEFT, rowHeight);
		
		
		util.write(outputStream);
		
	}
	/**
	 * @param lst	
	 * @param file
	 * @param outputStream
	 * @param l
	 * @throws IOException 
	 */
	public void getExcelReportForStockOperatorPM5Day(List<StockOperatorPM5> lst,
			File file, ServletOutputStream outputStream, long l) throws IOException {
		
		Workbook2007Util util = new Workbook2007Util(file,0);
		util.setSheetName("Stock Operator PM5 ", 0);
		
		short rowHeight = 280;
		int row=3;
		int col=0;
		for(StockOperatorPM5 data:lst)
		{
			col =0;
			if(data.isMachinedown()==true)
			{
				util.addValue(row, col++, "YES",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			else if(data.isMachinedown()==false)
			{
				util.addValue(row, col++, "NO",Workbook2007Util.Style.STYLE_NORMAL_CENTER_GREEN, rowHeight);
			}
			else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			util.addValue(row, col++,   data.getEdate(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.capitalizeFirstLetter(data.getPosition()), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.capitalizeFirstLetter(data.getShift()), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, data.getCrew(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			/***
			util.addValue(row, col++, data.getFibersupplytankcol1(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++,data.getFibersupplytankcol1Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			***/
			util.addValue(row, col++,data.getFibersupplytankcol2(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++,data.getFibersupplytankcol2Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
			
			if(data.isFibersupplytankcol3()==true)
			{
				util.addValue(row, col++, "ok",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			else if(data.isFibersupplytankcol3()==false)
			{
				util.addValue(row, col++, "Not ok",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			util.addValue(row, col++,data.getFibersupplytankcol3Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			util.addValue(row, col++,data.getFibersupplytankcol4Inbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++,data.getFibersupplytankcol4Outbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++,data.getFibersupplytankcol4Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++,data.getFibersupplytankcol5Inbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++,data.getFibersupplytankcol5Outbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++,data.getFibersupplytankcol5Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			if(data.isFibersupplytankcol6()==true)
			{
				util.addValue(row, col++, "ok",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			else if(data.isFibersupplytankcol6()==false)
			{
				util.addValue(row, col++, "Not ok",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			util.addValue(row, col++,data.getFibersupplytankcol6Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			/**
			util.addValue(row, col++,data.getMixchestcol1(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++,data.getMixchestcol1Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			**/
			util.addValue(row, col++,data.getMixchestcol2Inbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++,data.getMixchestcol2Outbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++,data.getMixchestcol2Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			if(data.isMixchestcol3()==true)
			{
				util.addValue(row, col++, "ok",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			else if(data.isMixchestcol3()==false)
			{
				util.addValue(row, col++, "Not ok",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			util.addValue(row, col++,data.getMixchestcol3Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			if(data.isMixchestcol4()==true)
			{
				util.addValue(row, col++, "ok",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			else if(data.isMixchestcol4()==false)
			{
				util.addValue(row, col++, "Not ok",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			util.addValue(row, col++,data.getMixchestcol4Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			util.addValue(row, col++,data.getMixchestcol5Inbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++,data.getMixchestcol5Outbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++,data.getMixchestcol5Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			/**
			util.addValue(row, col++,data.getBlendchestcol1(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++,data.getBlendchestcol1Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			
			**/
			if(data.isBlendchestcol2()==true)
			{
				util.addValue(row, col++, "ok",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			else if(data.isBlendchestcol2()==false)
			{
				util.addValue(row, col++, "Not ok",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			util.addValue(row, col++,data.getBlendchestcol2Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++,data.getBlendchestcol3Inbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++,data.getBlendchestcol3Outbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++,data.getBlendchestcol3Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
		/**
			util.addValue(row, col++,data.getMachinechestcol1(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++,data.getMachinechestcol1Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			**/
			if(data.isMachinechestcol2()==true)
			{
				util.addValue(row, col++, "ok",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			else if(data.isMachinechestcol2()==false)
			{
				util.addValue(row, col++, "Not ok",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			util.addValue(row, col++,data.getMachinechestcol2Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++,data.getMachinechestcol3Inbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++,data.getMachinechestcol3Outbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++,data.getMachinechestcol3Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			if(data.isMachinechestcol4()==true)
			{
				util.addValue(row, col++, "ok",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			else if(data.isMachinechestcol4()==false)
			{
				util.addValue(row, col++, "Not ok",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			util.addValue(row, col++,data.getMachinechestcol4Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++,data.getMachinechestcol5Inbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++,data.getMachinechestcol5Outbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++,data.getMachinechestcol5Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			
			if(data.isCouchpitcol1()==true)
			{
				util.addValue(row, col++, "ok",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			else if(data.isCouchpitcol1()==false)
			{
				util.addValue(row, col++, "Not ok",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			util.addValue(row, col++,data.getCouchpitcol1Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			util.addValue(row, col++,data.getCouchpitcol2Inbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++,data.getCouchpitcol2Outbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++,data.getCouchpitcol2Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			if(data.isCouchpitcol3()==true)
			{
				util.addValue(row, col++, "ok",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			else if(data.isCouchpitcol3()==false)
			{
				util.addValue(row, col++, "Not ok",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			util.addValue(row, col++,data.getCouchpitcol3Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++,data.getCouchpitcol4Inbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++,data.getCouchpitcol4Outbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++,data.getCouchpitcol4Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			util.addValue(row, col++,data.getCouchpitcol5Inbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++,data.getCouchpitcol5Outbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++,data.getCouchpitcol5Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
		
			if(data.isCouchpitcol6()==true)
			{
				util.addValue(row, col++, "ok",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			else if(data.isCouchpitcol6()==false)
			{
				util.addValue(row, col++, "Not ok",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			util.addValue(row, col++,data.getCouchpitcol6Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			

			if(data.isCleanscannerheadcol1()==true)
			{
				util.addValue(row, col++, "ok",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			else if(data.isCleanscannerheadcol1()==false)
			{
				util.addValue(row, col++, "Not ok",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			util.addValue(row, col++,data.getCleanscannerheadcol1Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			

			if(data.isSpoolstarterworkingproperlycol1()==true)
			{
				util.addValue(row, col++, "ok",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			else if(data.isSpoolstarterworkingproperlycol1()==false)
			{
				util.addValue(row, col++, "Not ok",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			util.addValue(row, col++,data.getSpoolstarterworkingproperlycol1Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
/***
			if(data.isBeakpassacceptablecol1()==true)
			{
				util.addValue(row, col++, "ok",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			else if(data.isBeakpassacceptablecol1()==false)
			{
				util.addValue(row, col++, "Not ok",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			util.addValue(row, col++,data.getBeakpassacceptablecol1Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			***/
			row++ ;
		}
		col = 1;
		util.mergeCell(row+2, row+2, col, col+5);
		util.addValue(row+2, col, "OBCC Completed = "+ l+"%",Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.write(outputStream);
		
	}
	/**
	 * @param nightlst
	 * @param file
	 * @param outputStream
	 * @param l
	 * @throws IOException 
	 */
	public void getExcelReportForStockOperatorPM5Night(
			List<StockOperatorPM5> nightlst, File file,
			ServletOutputStream outputStream, long l) throws IOException {
		
		Workbook2007Util util = new Workbook2007Util(file,0);
		util.setSheetName("Stock Operator PM5 ", 0);
		
		short rowHeight = 280;
		short rowHeightHeader=600;
		int row=0;
		int col=0;
		 col=0;
		 util.addValue(row, col++, "Machinw Down ", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 util.addValue(row, col++, "Date ", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 util.addValue(row, col++, "Position ", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 util.addValue(row, col++, "Shift ", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 util.addValue(row, col++, "Crew", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		
		 util.addValue(row, col++, "Refiner motor1", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 util.addValue(row, col++, "Description", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 
		 util.addValue(row, col++, "Refiner load unload motor1 Inbound", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 util.addValue(row, col++, "Refiner load unload motor1 Outbound", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 util.addValue(row, col++, "Description", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 
		 util.addValue(row, col++, "Oil level ", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 util.addValue(row, col++, "Descrition", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 
		 util.addValue(row, col++, "Seal water", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 util.addValue(row, col++, "Descrition", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 
		 util.addValue(row, col++, "Refiner motor2", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 util.addValue(row, col++, "Description", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 
		 util.addValue(row, col++, "Refiner load unload motor2 Inbound", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 util.addValue(row, col++, "Refiner load unload motor2 Outbound", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 util.addValue(row, col++, "Description", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 
		 util.addValue(row, col++, "Oil level ", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 util.addValue(row, col++, "Descrition", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 
		 util.addValue(row, col++, "Seal water", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 util.addValue(row, col++, "Descrition", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 
		 util.addValue(row, col++, "Consistency Dilution pump", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 util.addValue(row, col++, "Descrition", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 
		 util.addValue(row, col++, "Consistency Dilution pump motor Inbound", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 util.addValue(row, col++, "Consistency Dilution pump motor Outbound", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 util.addValue(row, col++, "Descrition", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 
		 util.addValue(row, col++, "Combined water pump", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 util.addValue(row, col++, "Descrition", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 
		 util.addValue(row, col++, "Combined water pump motor Inbound", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 util.addValue(row, col++, "Combined water pump motor Outbound", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 util.addValue(row, col++, "Descrition", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		/*** 
		 util.addValue(row, col++, "FRP white water chest", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 util.addValue(row, col++, "Descrition", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 
		 util.addValue(row, col++, "White water chest", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 util.addValue(row, col++, "Descrition", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 
		 util.addValue(row, col++, "Silo  level", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 util.addValue(row, col++, "Descrition", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 ***/
		 util.addValue(row, col++, "Yankee pulper East agitator", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 util.addValue(row, col++, "Descrition", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 
		 util.addValue(row, col++, "Yankee pulper East Agitator motor Inbound", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 util.addValue(row, col++, "Yankee pulper East Agitator motor Outbound", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 util.addValue(row, col++, "Descrition", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 
		 util.addValue(row, col++, "Yankee pulper best agitator", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 util.addValue(row, col++, "Descrition", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 
		 util.addValue(row, col++, "Yankee pulper west agitator motor Inbound", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 util.addValue(row, col++, "Yankee pulper west agitator motor Outbound", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 util.addValue(row, col++, "Descrition", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 
		 util.addValue(row, col++, "Yankee pulper pump", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 util.addValue(row, col++, "Descrition", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 
		 util.addValue(row, col++, "Yankee pulper motor Inbound", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 util.addValue(row, col++, "Yankee pulper motor Outbound", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 util.addValue(row, col++, "Descrition", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 
		 util.addValue(row, col++, "Broke chest agitator south", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 util.addValue(row, col++, "Descrition", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 
		 util.addValue(row, col++, "Broke chest agitator south motor Inbound", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 util.addValue(row, col++, "Broke chest agitator south motor Outbound", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 util.addValue(row, col++, "Descrition", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 
		 util.addValue(row, col++, "Broke chest agitator north", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 util.addValue(row, col++, "Descrition", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 
		 util.addValue(row, col++, "Broke chest agitator north  motor Inbound", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 util.addValue(row, col++, "Broke chest agitator north  motor Outbound", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 util.addValue(row, col++, "Descrition", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 
		 util.addValue(row, col++, "Segments", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 util.addValue(row, col++, "Descrition", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 
		 util.addValue(row, col++, "Nozzles", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 util.addValue(row, col++, "Descrition", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 
		 util.addValue(row, col++, "knock of shawer", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 util.addValue(row, col++, "Descrition", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 
		 util.addValue(row, col++, "Save all motor Inbound", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 util.addValue(row, col++, "Save all motor Outbound", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 util.addValue(row, col++, "Descrition", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 
		 util.addValue(row, col++, "SydraPulper agitator Motor Inbound", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 util.addValue(row, col++, "SydraPulper agitator Motor Outbound", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 util.addValue(row, col++, "Descrition", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 
		 util.addValue(row, col++, "SydraPulper  Gear Unit", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 util.addValue(row, col++, "Descrition", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 
		 util.addValue(row, col++, "SydraPulper Pump", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 util.addValue(row, col++, "Descrition", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 
		 util.addValue(row, col++, "SydraPulper Pump Motor Inbound", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 util.addValue(row, col++, "SydraPulper Pump Motor Outbound", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 util.addValue(row, col++, "Descrition", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 
		 util.addValue(row, col++, "SydraPulper Level", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 util.addValue(row, col++, "Descrition", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 
		 row = row+1;
		for(StockOperatorPM5 data:nightlst)
		{
			col =0;
			if(data.isMachinedown()==true)
			{
				util.addValue(row, col++, "YES",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			else if(data.isMachinedown()==false)
			{
				util.addValue(row, col++, "NO",Workbook2007Util.Style.STYLE_NORMAL_CENTER_GREEN, rowHeight);
			}
			else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			util.addValue(row, col++,   data.getEdate(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.capitalizeFirstLetter(data.getPosition()), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.capitalizeFirstLetter(data.getShift()), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, data.getCrew(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			
			if(data.isRefiner1col1()==true)
			{
				util.addValue(row, col++, "ok",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			else if(data.isRefiner1col1()==false)
			{
				util.addValue(row, col++, "Not ok",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			util.addValue(row, col++, data.getRefiner1col1Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			util.addValue(row, col++, data.getRefiner1col2Inbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getRefiner1col2Outbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++,data.getRefiner1col2Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++,data.getRefiner1col3(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++,data.getRefiner1col3Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++,data.getRefiner1col4(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++,data.getRefiner1col4Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			if(data.isRefiner2col1()==true)
			{
				util.addValue(row, col++, "ok",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			else if(data.isRefiner2col1()==false)
			{
				util.addValue(row, col++, "Not ok",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			util.addValue(row, col++, data.getRefiner2col1Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			util.addValue(row, col++, data.getRefiner2col2Inbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getRefiner2col2Outbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++,data.getRefiner2col2Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++,data.getRefiner2col3(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++,data.getRefiner2col3Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++,data.getRefiner2col4(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++,data.getRefiner2col4Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
		
			if(data.isWhitewaterpumpscol1()==true)
			{
				util.addValue(row, col++, "ok",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			else if(data.isWhitewaterpumpscol1()==false)
			{
				util.addValue(row, col++, "Not ok",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			util.addValue(row, col++,data.getWhitewaterpumpscol1Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			util.addValue(row, col++, data.getWhitewaterpumpscol2Inbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getWhitewaterpumpscol2Outbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++,data.getWhitewaterpumpscol2Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			if(data.isWhitewaterpumpscol3()==true)
			{
				util.addValue(row, col++, "ok",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			else if(data.isWhitewaterpumpscol3()==false)
			{
				util.addValue(row, col++, "Not ok",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			util.addValue(row, col++,data.getWhitewaterpumpscol3Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			util.addValue(row, col++, data.getWhitewaterpumpscol4Inbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getWhitewaterpumpscol4Outbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++,data.getWhitewaterpumpscol4Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			/***
			util.addValue(row, col++, data.getWhitewaterpumpscol5(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++,data.getWhitewaterpumpscol5Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getWhitewaterpumpscol6(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++,data.getWhitewaterpumpscol6Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getWhitewaterpumpscol7(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++,data.getWhitewaterpumpscol7Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			***/
			if(data.isYankeepulpercol1()==true)
			{
				util.addValue(row, col++, "ok",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			else if(data.isYankeepulpercol1()==false)
			{
				util.addValue(row, col++, "Not ok",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			util.addValue(row, col++,data.getYankeepulpercol1Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getYankeepulpercol2Inbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getYankeepulpercol2Outbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++,data.getYankeepulpercol2Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			if(data.isYankeepulpercol3()==true)
			{
				util.addValue(row, col++, "ok",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			else if(data.isYankeepulpercol3()==false)
			{
				util.addValue(row, col++, "Not ok",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			util.addValue(row, col++,data.getYankeepulpercol3Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getYankeepulpercol4Inbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getYankeepulpercol4Outbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++,data.getYankeepulpercol4Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			if(data.isYankeepulpercol5()==true)
			{
				util.addValue(row, col++, "ok",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			else if(data.isYankeepulpercol5()==false)
			{
				util.addValue(row, col++, "Not ok",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			util.addValue(row, col++,data.getYankeepulpercol5Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getYankeepulpercol6Inbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getYankeepulpercol6Outbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++,data.getYankeepulpercol6Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			if(data.isBorkechestcol1()==true)
			{
				util.addValue(row, col++, "ok",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			else if(data.isBorkechestcol1()==false)
			{
				util.addValue(row, col++, "Not ok",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			util.addValue(row, col++,data.getBorkechestcol1Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getBorkechestcol2Inbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getBorkechestcol2Outbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++,data.getBorkechestcol2Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			if(data.isBorkechestcol3()==true)
			{
				util.addValue(row, col++, "ok",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			else if(data.isBorkechestcol3()==false)
			{
				util.addValue(row, col++, "Not ok",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			util.addValue(row, col++,data.getBorkechestcol3Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getBorkechestcol4Inbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getBorkechestcol4Outbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++,data.getBorkechestcol4Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			util.addValue(row, col++, data.getSaveallcol1(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++,data.getSaveallcol1Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getSaveallcol2(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++,data.getSaveallcol2Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			if(data.isSaveallcol3()==true)
			{
				util.addValue(row, col++, "On",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			else if(data.isSaveallcol3()==false)
			{
				util.addValue(row, col++, "OFF",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			util.addValue(row, col++,data.getSaveallcol3Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++,data.getSaveallcol4Inbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getSaveallcol4Outbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++,data.getSaveallcol4Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			util.addValue(row, col++,data.getSydrapulpercol1Inbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++,data.getSydrapulpercol1Outbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++,data.getSydrapulpercol1Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++,data.getSydrapulpercol2(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++,data.getSydrapulpercol2Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			if(data.isSydrapulpercol3()==true)
			{
				util.addValue(row, col++, "On",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			else if(data.isSydrapulpercol3()==false)
			{
				util.addValue(row, col++, "OFF",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			util.addValue(row, col++,data.getSydrapulpercol3Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++,data.getSydrapulpercol4Inbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++,data.getSydrapulpercol4Outbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++,data.getSydrapulpercol4Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++,data.getSydrapulpercol5(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++,data.getSydrapulpercol5Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			row++ ;
			
			
		}
		col = 1;
		util.mergeCell(row+2, row+2, col, col+5);
		util.addValue(row+2, col, "OBCC Completed = "+l+"%",Workbook2007Util.Style.STYLE_BOLD_LEFT, rowHeight);
		
		util.write(outputStream);
		
	}
	/**
	 * @param daylst
	 * @param nightlst
	 * @param file
	 * @param outputStream
	 * @param l
	 * @throws IOException 
	 */
	public void getExcelReportForStockOperatorPM5DayNight(List<StockOperatorPM5> daylst, List<StockOperatorPM5> nightlst,
			File file, ServletOutputStream outputStream, long l) throws IOException {
		Workbook2007Util util = new Workbook2007Util(file,0);
		util.setSheetName("Stock Operator PM5 ", 0);
		
		short rowHeight = 280;
		short rowHeightHeader =600;
		int row=2;
		int col=0;
		for(StockOperatorPM5 data:daylst)
		{
			col =0;
			if(data.isMachinedown()==true)
			{
				util.addValue(row, col++, "YES",Workbook2007Util.Style.STYLE_NORMAL_CENTER_RED, rowHeight);
			}
			else if(data.isMachinedown()==false)
			{
				util.addValue(row, col++, "NO",Workbook2007Util.Style.STYLE_NORMAL_CENTER_GREEN, rowHeight);
			}
			else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			util.addValue(row, col++,   data.getEdate(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.capitalizeFirstLetter(data.getPosition()), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.capitalizeFirstLetter(data.getShift()), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, data.getCrew(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			/**
			util.addValue(row, col++, data.getFibersupplytankcol1(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++,data.getFibersupplytankcol1Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			**/
			util.addValue(row, col++,data.getFibersupplytankcol2(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++,data.getFibersupplytankcol2Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
			
			if(data.isFibersupplytankcol3()==true)
			{
				util.addValue(row, col++, "ok",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			else if(data.isFibersupplytankcol3()==false)
			{
				util.addValue(row, col++, "Not ok",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			util.addValue(row, col++,data.getFibersupplytankcol3Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			util.addValue(row, col++,data.getFibersupplytankcol4Inbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++,data.getFibersupplytankcol4Outbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++,data.getFibersupplytankcol4Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++,data.getFibersupplytankcol5Inbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++,data.getFibersupplytankcol5Outbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++,data.getFibersupplytankcol5Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			if(data.isFibersupplytankcol6()==true)
			{
				util.addValue(row, col++, "ok",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			else if(data.isFibersupplytankcol6()==false)
			{
				util.addValue(row, col++, "Not ok",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			util.addValue(row, col++,data.getFibersupplytankcol6Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			/***
			util.addValue(row, col++,data.getMixchestcol1(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++,data.getMixchestcol1Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			**/
			util.addValue(row, col++,data.getMixchestcol2Inbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++,data.getMixchestcol2Outbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++,data.getMixchestcol2Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			if(data.isMixchestcol3()==true)
			{
				util.addValue(row, col++, "ok",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			else if(data.isMixchestcol3()==false)
			{
				util.addValue(row, col++, "Not ok",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			util.addValue(row, col++,data.getMixchestcol3Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			if(data.isMixchestcol4()==true)
			{
				util.addValue(row, col++, "ok",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			else if(data.isMixchestcol4()==false)
			{
				util.addValue(row, col++, "Not ok",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			util.addValue(row, col++,data.getMixchestcol4Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			util.addValue(row, col++,data.getMixchestcol5Inbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++,data.getMixchestcol5Outbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++,data.getMixchestcol5Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			/***
			util.addValue(row, col++,data.getBlendchestcol1(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++,data.getBlendchestcol1Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			**/
			if(data.isBlendchestcol2()==true)
			{
				util.addValue(row, col++, "ok",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			else if(data.isBlendchestcol2()==false)
			{
				util.addValue(row, col++, "Not ok",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			util.addValue(row, col++,data.getBlendchestcol2Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++,data.getBlendchestcol3Inbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++,data.getBlendchestcol3Outbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++,data.getBlendchestcol3Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
		/**
			util.addValue(row, col++,data.getMachinechestcol1(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++,data.getMachinechestcol1Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			
			**/
			if(data.isMachinechestcol2()==true)
			{
				util.addValue(row, col++, "ok",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			else if(data.isMachinechestcol2()==false)
			{
				util.addValue(row, col++, "Not ok",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			util.addValue(row, col++,data.getMachinechestcol2Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++,data.getMachinechestcol3Inbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++,data.getMachinechestcol3Outbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++,data.getMachinechestcol3Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			if(data.isMachinechestcol4()==true)
			{
				util.addValue(row, col++, "ok",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			else if(data.isMachinechestcol4()==false)
			{
				util.addValue(row, col++, "Not ok",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			util.addValue(row, col++,data.getMachinechestcol4Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++,data.getMachinechestcol5Inbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++,data.getMachinechestcol5Outbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++,data.getMachinechestcol5Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			
			if(data.isCouchpitcol1()==true)
			{
				util.addValue(row, col++, "ok",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			else if(data.isCouchpitcol1()==false)
			{
				util.addValue(row, col++, "Not ok",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			util.addValue(row, col++,data.getCouchpitcol1Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			util.addValue(row, col++,data.getCouchpitcol2Inbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++,data.getCouchpitcol2Outbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++,data.getCouchpitcol2Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			if(data.isCouchpitcol3()==true)
			{
				util.addValue(row, col++, "ok",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			else if(data.isCouchpitcol3()==false)
			{
				util.addValue(row, col++, "Not ok",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			util.addValue(row, col++,data.getCouchpitcol3Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++,data.getCouchpitcol4Inbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++,data.getCouchpitcol4Outbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++,data.getCouchpitcol4Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			util.addValue(row, col++,data.getCouchpitcol5Inbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++,data.getCouchpitcol5Outbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++,data.getCouchpitcol5Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
		
			if(data.isCouchpitcol6()==true)
			{
				util.addValue(row, col++, "ok",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			else if(data.isCouchpitcol6()==false)
			{
				util.addValue(row, col++, "Not ok",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			util.addValue(row, col++,data.getCouchpitcol6Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			

			if(data.isCleanscannerheadcol1()==true)
			{
				util.addValue(row, col++, "ok",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			else if(data.isCleanscannerheadcol1()==false)
			{
				util.addValue(row, col++, "Not ok",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			util.addValue(row, col++,data.getCleanscannerheadcol1Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			

			if(data.isSpoolstarterworkingproperlycol1()==true)
			{
				util.addValue(row, col++, "ok",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			else if(data.isSpoolstarterworkingproperlycol1()==false)
			{
				util.addValue(row, col++, "Not ok",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			util.addValue(row, col++,data.getSpoolstarterworkingproperlycol1Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			/***

			if(data.isBeakpassacceptablecol1()==true)
			{
				util.addValue(row, col++, "ok",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			else if(data.isBeakpassacceptablecol1()==false)
			{
				util.addValue(row, col++, "Not ok",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			util.addValue(row, col++,data.getBeakpassacceptablecol1Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			***/
			
			row++ ;
		}
		
		
		 row = row+2;
		 col=0;
		 util.addValue(row, col++, "Machinw Down ", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 util.addValue(row, col++, "Date ", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 util.addValue(row, col++, "Position ", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 util.addValue(row, col++, "Shift ", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 util.addValue(row, col++, "Crew", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		
		 util.addValue(row, col++, "Refiner motor1", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 util.addValue(row, col++, "Description", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 
		 util.addValue(row, col++, "Refiner load unload motor1 Inbound", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 util.addValue(row, col++, "Refiner load unload motor1 Outbound", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 util.addValue(row, col++, "Description", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 
		 util.addValue(row, col++, "Oil level ", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 util.addValue(row, col++, "Descrition", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 
		 util.addValue(row, col++, "Seal water", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 util.addValue(row, col++, "Descrition", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 
		 util.addValue(row, col++, "Refiner motor2", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 util.addValue(row, col++, "Description", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 
		 util.addValue(row, col++, "Refiner load unload motor2 Inbound", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 util.addValue(row, col++, "Refiner load unload motor2 Outbound", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 util.addValue(row, col++, "Description", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 
		 util.addValue(row, col++, "Oil level ", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 util.addValue(row, col++, "Descrition", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 
		 util.addValue(row, col++, "Seal water", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 util.addValue(row, col++, "Descrition", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 
		 util.addValue(row, col++, "Consistency Dilution pump", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 util.addValue(row, col++, "Descrition", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 
		 util.addValue(row, col++, "Consistency Dilution pump motor Inbound", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 util.addValue(row, col++, "Consistency Dilution pump motor Outbound", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 util.addValue(row, col++, "Descrition", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 
		 util.addValue(row, col++, "Combined water pump", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 util.addValue(row, col++, "Descrition", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 
		 util.addValue(row, col++, "Combined water pump motor Inbound", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 util.addValue(row, col++, "Combined water pump motor Outbound", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 util.addValue(row, col++, "Descrition", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 /***
		 util.addValue(row, col++, "FRP white water chest", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 util.addValue(row, col++, "Descrition", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 
		 util.addValue(row, col++, "White water chest", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 util.addValue(row, col++, "Descrition", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 
		 util.addValue(row, col++, "Silo  level", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 util.addValue(row, col++, "Descrition", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 ***/
		 util.addValue(row, col++, "Yankee pulper East agitator", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 util.addValue(row, col++, "Descrition", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 
		 util.addValue(row, col++, "Yankee pulper East Agitator motor Inbound", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 util.addValue(row, col++, "Yankee pulper East Agitator motor Outbound", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 util.addValue(row, col++, "Descrition", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 
		 util.addValue(row, col++, "Yankee pulper best agitator", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 util.addValue(row, col++, "Descrition", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 
		 util.addValue(row, col++, "Yankee pulper west agitator motor Inbound", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 util.addValue(row, col++, "Yankee pulper west agitator motor Outbound", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 util.addValue(row, col++, "Descrition", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 
		 util.addValue(row, col++, "Yankee pulper pump", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 util.addValue(row, col++, "Descrition", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 
		 util.addValue(row, col++, "Yankee pulper motor Inbound", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 util.addValue(row, col++, "Yankee pulper motor Outbound", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 util.addValue(row, col++, "Descrition", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 
		 util.addValue(row, col++, "Broke chest agitator south", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 util.addValue(row, col++, "Descrition", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 
		 util.addValue(row, col++, "Broke chest agitator south motor Inbound", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 util.addValue(row, col++, "Broke chest agitator south motor Outbound", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 util.addValue(row, col++, "Descrition", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 
		 util.addValue(row, col++, "Broke chest agitator north", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 util.addValue(row, col++, "Descrition", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 
		 util.addValue(row, col++, "Broke chest agitator north  motor Inbound", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 util.addValue(row, col++, "Broke chest agitator north  motor Outbound", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 util.addValue(row, col++, "Descrition", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 
		 util.addValue(row, col++, "Segments", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 util.addValue(row, col++, "Descrition", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 
		 util.addValue(row, col++, "Nozzles", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 util.addValue(row, col++, "Descrition", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 
		 util.addValue(row, col++, "knock of shawer", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 util.addValue(row, col++, "Descrition", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 
		 util.addValue(row, col++, "Save all motor Inbound", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 util.addValue(row, col++, "Save all motor Outbound", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 util.addValue(row, col++, "Descrition", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 
		 util.addValue(row, col++, "SydraPulper agitator Motor Inbound", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 util.addValue(row, col++, "SydraPulper agitator Motor Outbound", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 util.addValue(row, col++, "Descrition", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 
		 util.addValue(row, col++, "SydraPulper  Gear Unit", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 util.addValue(row, col++, "Descrition", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 
		 util.addValue(row, col++, "SydraPulper Pump", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 util.addValue(row, col++, "Descrition", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 
		 util.addValue(row, col++, "SydraPulper Pump Motor Inbound", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 util.addValue(row, col++, "SydraPulper Pump Motor Outbound", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 util.addValue(row, col++, "Descrition", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 
		 util.addValue(row, col++, "SydraPulper Level", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 util.addValue(row, col++, "Descrition", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 
		 row = row+1;
		for(StockOperatorPM5 data:nightlst)
		{
			col =0;
			if(data.isMachinedown()==true)
			{
				util.addValue(row, col++, "YES",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			else if(data.isMachinedown()==false)
			{
				util.addValue(row, col++, "NO",Workbook2007Util.Style.STYLE_NORMAL_CENTER_GREEN, rowHeight);
			}
			else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			util.addValue(row, col++,   data.getEdate(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.capitalizeFirstLetter(data.getPosition()), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.capitalizeFirstLetter(data.getShift()), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, data.getCrew(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			
			if(data.isRefiner1col1()==true)
			{
				util.addValue(row, col++, "ok",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			else if(data.isRefiner1col1()==false)
			{
				util.addValue(row, col++, "Not ok",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			util.addValue(row, col++, data.getRefiner1col1Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			util.addValue(row, col++, data.getRefiner1col2Inbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getRefiner1col2Outbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++,data.getRefiner1col2Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++,data.getRefiner1col3(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++,data.getRefiner1col3Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++,data.getRefiner1col4(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++,data.getRefiner1col4Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			if(data.isRefiner2col1()==true)
			{
				util.addValue(row, col++, "ok",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			else if(data.isRefiner2col1()==false)
			{
				util.addValue(row, col++, "Not ok",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			util.addValue(row, col++, data.getRefiner2col1Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			util.addValue(row, col++, data.getRefiner2col2Inbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getRefiner2col2Outbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++,data.getRefiner2col2Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++,data.getRefiner2col3(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++,data.getRefiner2col3Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++,data.getRefiner2col4(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++,data.getRefiner2col4Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
		
			if(data.isWhitewaterpumpscol1()==true)
			{
				util.addValue(row, col++, "ok",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			else if(data.isWhitewaterpumpscol1()==false)
			{
				util.addValue(row, col++, "Not ok",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			util.addValue(row, col++,data.getWhitewaterpumpscol1Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			util.addValue(row, col++, data.getWhitewaterpumpscol2Inbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getWhitewaterpumpscol2Outbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++,data.getWhitewaterpumpscol2Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			if(data.isWhitewaterpumpscol3()==true)
			{
				util.addValue(row, col++, "ok",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			else if(data.isWhitewaterpumpscol3()==false)
			{
				util.addValue(row, col++, "Not ok",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			util.addValue(row, col++,data.getWhitewaterpumpscol3Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			util.addValue(row, col++, data.getWhitewaterpumpscol4Inbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getWhitewaterpumpscol4Outbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++,data.getWhitewaterpumpscol4Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			/**
			util.addValue(row, col++, data.getWhitewaterpumpscol5(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++,data.getWhitewaterpumpscol5Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getWhitewaterpumpscol6(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++,data.getWhitewaterpumpscol6Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getWhitewaterpumpscol7(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++,data.getWhitewaterpumpscol7Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			**/
			if(data.isYankeepulpercol1()==true)
			{
				util.addValue(row, col++, "ok",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			else if(data.isYankeepulpercol1()==false)
			{
				util.addValue(row, col++, "Not ok",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			util.addValue(row, col++,data.getYankeepulpercol1Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getYankeepulpercol2Inbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getYankeepulpercol2Outbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++,data.getYankeepulpercol2Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			if(data.isYankeepulpercol3()==true)
			{
				util.addValue(row, col++, "ok",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			else if(data.isYankeepulpercol3()==false)
			{
				util.addValue(row, col++, "Not ok",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			util.addValue(row, col++,data.getYankeepulpercol3Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getYankeepulpercol4Inbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getYankeepulpercol4Outbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++,data.getYankeepulpercol4Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			if(data.isYankeepulpercol5()==true)
			{
				util.addValue(row, col++, "ok",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			else if(data.isYankeepulpercol5()==false)
			{
				util.addValue(row, col++, "Not ok",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			util.addValue(row, col++,data.getYankeepulpercol5Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getYankeepulpercol6Inbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getYankeepulpercol6Outbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++,data.getYankeepulpercol6Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			if(data.isBorkechestcol1()==true)
			{
				util.addValue(row, col++, "ok",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			else if(data.isBorkechestcol1()==false)
			{
				util.addValue(row, col++, "Not ok",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			util.addValue(row, col++,data.getBorkechestcol1Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getBorkechestcol2Inbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getBorkechestcol2Outbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++,data.getBorkechestcol2Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			if(data.isBorkechestcol3()==true)
			{
				util.addValue(row, col++, "ok",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			else if(data.isBorkechestcol3()==false)
			{
				util.addValue(row, col++, "Not ok",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			util.addValue(row, col++,data.getBorkechestcol3Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getBorkechestcol4Inbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getBorkechestcol4Outbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++,data.getBorkechestcol4Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			util.addValue(row, col++, data.getSaveallcol1(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++,data.getSaveallcol1Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getSaveallcol2(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++,data.getSaveallcol2Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			if(data.isSaveallcol3()==true)
			{
				util.addValue(row, col++, "On",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			else if(data.isSaveallcol3()==false)
			{
				util.addValue(row, col++, "OFF",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			util.addValue(row, col++,data.getSaveallcol3Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++,data.getSaveallcol4Inbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getSaveallcol4Outbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++,data.getSaveallcol4Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			util.addValue(row, col++,data.getSydrapulpercol1Inbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++,data.getSydrapulpercol1Outbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++,data.getSydrapulpercol1Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++,data.getSydrapulpercol2(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++,data.getSydrapulpercol2Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			if(data.isSydrapulpercol3()==true)
			{
				util.addValue(row, col++, "On",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			else if(data.isSydrapulpercol3()==false)
			{
				util.addValue(row, col++, "OFF",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			util.addValue(row, col++,data.getSydrapulpercol3Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++,data.getSydrapulpercol4Inbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++,data.getSydrapulpercol4Outbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++,data.getSydrapulpercol4Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++,data.getSydrapulpercol5(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++,data.getSydrapulpercol5Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			row++ ;
			
			
		}
		col = 1;
		util.mergeCell(row+2, row+2, col, col+4);
		util.addValue(row+2, col, "OBCC Completed = "+l+"%",Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		
		util.write(outputStream);
		
	}
	/**
	 * @param daylst
	 * @param nightlst
	 * @param file
	 * @param outputStream
	 * @param l
	 * @throws IOException 
	 */
	public void getExcelReportUtilityOperatorPM5DayNight(List<UtilityOperatorPM5> both,File file, ServletOutputStream outputStream, long l) throws IOException {

		
		Workbook2007Util util = new Workbook2007Util(file,0);
		util.setSheetName("Utility Operator ", 0);
		  
		
		
		short rowHeight = 280;
		int row=3;
		int col=0;
		for(UtilityOperatorPM5 data:both){
			col =0;
			if(data.isMachinedown() == true)
			{
				util.addValue(row, col++, "YES",Workbook2007Util.Style.STYLE_NORMAL_CENTER_RED, rowHeight);		
			}
			else if(data.isMachinedown() == false)
			{
				util.addValue(row, col++, "NO",Workbook2007Util.Style.STYLE_NORMAL_CENTER_GREEN, rowHeight);		
			}
			else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			util.addValue(row, col++,   data.getEdate(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.capitalizeFirstLetter(data.getPosition()), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.capitalizeFirstLetter(data.getShift()), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, data.getCrew(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
		 
	  	
			if(data.isChecklistcompleted()== true)util.addValue(row, col++, "OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			else util.addValue(row, col++, "NOT OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++,data.getChecklistcompletedDesc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			if(data.isClampscleanofburrs()== true)util.addValue(row, col++, "OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			else util.addValue(row, col++, "NOT OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);	
			util.addValue(row, col++,data.getClampscleanofburrsDesc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			if(data.isAnyvisibleissue()== true)util.addValue(row, col++, "OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			else util.addValue(row, col++, "NOT OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);	
			util.addValue(row, col++,data.getAnyvisibleissueDesc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			/***
			if(data.isMotorizedhandtruck()== true)util.addValue(row, col++, "OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			else util.addValue(row, col++, "NOT OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);	
			util.addValue(row, col++,data.getMotorizedhandtruckDesc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			if(data.isBatterychangesandcableintact()== true)util.addValue(row, col++, "OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			else util.addValue(row, col++, "NOT OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);	
			util.addValue(row, col++,data.getBatterychangesandcableintactDesc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			**/
			if(data.isCautionlightoperational()== true)util.addValue(row, col++, "OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			else util.addValue(row, col++, "NOT OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);	
			util.addValue(row, col++,data.getAlllocksoperationalDesc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			if(data.isControlarmoperatingproperly()== true)util.addValue(row, col++, "OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			else util.addValue(row, col++, "NOT OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);	
			util.addValue(row, col++,data.getControlarmoperatingproperlyDesc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			if(data.isAnymovementissue()== true)util.addValue(row, col++, "OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			else util.addValue(row, col++, "NOT OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);	
			util.addValue(row, col++,data.getAnymovementissueDesc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			if(data.isHandtruckblowdown()== true)util.addValue(row, col++, "OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			else util.addValue(row, col++, "NOT OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);	
			util.addValue(row, col++,data.getHandtruckblowdownDesc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			if(data.isLiftingproperly()== true)util.addValue(row, col++, "OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			else util.addValue(row, col++, "NOT OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);	
			util.addValue(row, col++,data.getControlarmoperatingproperlyDesc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			/**
			if(data.isBothfoldoutwingsopenorclosed()== true)util.addValue(row, col++, "OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			else util.addValue(row, col++, "NOT OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);	
			util.addValue(row, col++,data.getBothfoldoutwingsopenorclosedDesc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			if(data.isBotharetobeopenedandclosedatthesametime()== true)util.addValue(row, col++, "OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			else util.addValue(row, col++, "NOT OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);	
			util.addValue(row, col++,data.getBotharetobeopenedandclosedatthesametimeDesc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			**/
			if(data.isAlllocksoperational()== true)util.addValue(row, col++, "OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			else util.addValue(row, col++, "NOT OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);	
			util.addValue(row, col++,data.getAlllocksoperationalDesc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			if(data.isAlllightintactandworking()== true)util.addValue(row, col++, "OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			else util.addValue(row, col++, "NOT OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);	
			util.addValue(row, col++,data.getAlllightintactandworkingDesc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			if(data.isGladhandlocksbeingused()== true)util.addValue(row, col++, "OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			else util.addValue(row, col++, "NOT OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);	
			util.addValue(row, col++,data.getGladhandlocksbeingusedDesc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);	
			
		row++ ;
			
		}
		util.mergeCell(row+2, row+2, col, col+4);
		util.addValue(row+2, col, "OBCC Completed = "+l+"%",Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		
		util.write(outputStream);
		
	}
	/**
	 * @param lst
	 * @param file
	 * @param outputStream
	 * @param l
	 * @throws IOException 
	 */
	public void getExcelReportUtilityOperatorPM5Night(List<UtilityOperatorPM5> nightlst, File file,
			ServletOutputStream outputStream, long l) throws IOException {
		
		Workbook2007Util util = new Workbook2007Util(file,0);
		util.setSheetName("Utility Operator ", 0);
		  
		
		
		short rowHeight = 280;
		int row=3;
		int col=0;
		for(UtilityOperatorPM5 data:nightlst){
			col =0;
			if(data.isMachinedown() == true)
			{
				util.addValue(row, col++, "YES",Workbook2007Util.Style.STYLE_NORMAL_CENTER_RED, rowHeight);		
			}
			else if(data.isMachinedown() == false)
			{
				util.addValue(row, col++, "NO",Workbook2007Util.Style.STYLE_NORMAL_CENTER_GREEN, rowHeight);		
			}
			else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			util.addValue(row, col++,   data.getEdate(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.capitalizeFirstLetter(data.getPosition()), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.capitalizeFirstLetter(data.getShift()), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, data.getCrew(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
		 
			if(data.isChecklistcompleted()== true)util.addValue(row, col++, "OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			else util.addValue(row, col++, "NOT OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++,data.getChecklistcompletedDesc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			if(data.isClampscleanofburrs()== true)util.addValue(row, col++, "OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			else util.addValue(row, col++, "NOT OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);	
			util.addValue(row, col++,data.getClampscleanofburrsDesc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			if(data.isAnyvisibleissue()== true)util.addValue(row, col++, "OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			else util.addValue(row, col++, "NOT OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);	
			util.addValue(row, col++,data.getAnyvisibleissueDesc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			/***
			if(data.isMotorizedhandtruck()== true)util.addValue(row, col++, "OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			else util.addValue(row, col++, "NOT OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);	
			util.addValue(row, col++,data.getMotorizedhandtruckDesc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			if(data.isBatterychangesandcableintact()== true)util.addValue(row, col++, "OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			else util.addValue(row, col++, "NOT OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);	
			util.addValue(row, col++,data.getBatterychangesandcableintactDesc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			***/
			if(data.isCautionlightoperational()== true)util.addValue(row, col++, "OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			else util.addValue(row, col++, "NOT OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);	
			util.addValue(row, col++,data.getAlllocksoperationalDesc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			if(data.isControlarmoperatingproperly()== true)util.addValue(row, col++, "OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			else util.addValue(row, col++, "NOT OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);	
			util.addValue(row, col++,data.getControlarmoperatingproperlyDesc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			if(data.isAnymovementissue()== true)util.addValue(row, col++, "OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			else util.addValue(row, col++, "NOT OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);	
			util.addValue(row, col++,data.getAnymovementissueDesc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			if(data.isHandtruckblowdown()== true)util.addValue(row, col++, "OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			else util.addValue(row, col++, "NOT OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);	
			util.addValue(row, col++,data.getHandtruckblowdownDesc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			if(data.isLiftingproperly()== true)util.addValue(row, col++, "OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			else util.addValue(row, col++, "NOT OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);	
			util.addValue(row, col++,data.getControlarmoperatingproperlyDesc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			/***
			if(data.isBothfoldoutwingsopenorclosed()== true)util.addValue(row, col++, "OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			else util.addValue(row, col++, "NOT OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);	
			util.addValue(row, col++,data.getBothfoldoutwingsopenorclosedDesc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			if(data.isBotharetobeopenedandclosedatthesametime()== true)util.addValue(row, col++, "OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			else util.addValue(row, col++, "NOT OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);	
			util.addValue(row, col++,data.getBotharetobeopenedandclosedatthesametimeDesc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			**/
			if(data.isAlllocksoperational()== true)util.addValue(row, col++, "OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			else util.addValue(row, col++, "NOT OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);	
			util.addValue(row, col++,data.getAlllocksoperationalDesc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			if(data.isAlllightintactandworking()== true)util.addValue(row, col++, "OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			else util.addValue(row, col++, "NOT OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);	
			util.addValue(row, col++,data.getAlllightintactandworkingDesc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			if(data.isGladhandlocksbeingused()== true)util.addValue(row, col++, "OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			else util.addValue(row, col++, "NOT OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);	
			util.addValue(row, col++,data.getGladhandlocksbeingusedDesc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
		row++ ;
			
		}
		col = 0;
		util.mergeCell(row+2, row+2, col, col+4);
		util.addValue(row+2, col, "OBCC Completed = "+l+"%",Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		
		util.write(outputStream);
		
	}
	/**
	 * @param lst
	 * @param file
	 * @param outputStream
	 * @param l
	 * @throws IOException 
	 */
	public void getExcelReportUtilityOperatorPM5Day(List<UtilityOperatorPM5> daylst, File file,
			ServletOutputStream outputStream, long l) throws IOException {
		
		
		Workbook2007Util util = new Workbook2007Util(file,0);
		util.setSheetName("Utility Operator ", 0);
		  
		
		
		short rowHeight = 280;
		int row=3;
		int col=0;
		for(UtilityOperatorPM5 data:daylst){
			col =0;
			if(data.isMachinedown() == true)
			{
				util.addValue(row, col++, "YES",Workbook2007Util.Style.STYLE_NORMAL_CENTER_RED, rowHeight);		
			}
			else if(data.isMachinedown() == false)
			{
				util.addValue(row, col++, "NO",Workbook2007Util.Style.STYLE_NORMAL_CENTER_GREEN, rowHeight);		
			}
			else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			util.addValue(row, col++,   data.getEdate(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.capitalizeFirstLetter(data.getPosition()), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.capitalizeFirstLetter(data.getShift()), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, data.getCrew(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
		 
			if(data.isChecklistcompleted()== true)util.addValue(row, col++, "OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			else util.addValue(row, col++, "NOT OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++,data.getChecklistcompletedDesc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			if(data.isClampscleanofburrs()== true)util.addValue(row, col++, "OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			else util.addValue(row, col++, "NOT OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);	
			util.addValue(row, col++,data.getClampscleanofburrsDesc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			if(data.isAnyvisibleissue()== true)util.addValue(row, col++, "OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			else util.addValue(row, col++, "NOT OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);	
			util.addValue(row, col++,data.getAnyvisibleissueDesc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			/***
			if(data.isMotorizedhandtruck()== true)util.addValue(row, col++, "OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			else util.addValue(row, col++, "NOT OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);	
			util.addValue(row, col++,data.getMotorizedhandtruckDesc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			if(data.isBatterychangesandcableintact()== true)util.addValue(row, col++, "OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			else util.addValue(row, col++, "NOT OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);	
			util.addValue(row, col++,data.getBatterychangesandcableintactDesc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			**/
			if(data.isCautionlightoperational()== true)util.addValue(row, col++, "OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			else util.addValue(row, col++, "NOT OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);	
			util.addValue(row, col++,data.getAlllocksoperationalDesc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			if(data.isControlarmoperatingproperly()== true)util.addValue(row, col++, "OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			else util.addValue(row, col++, "NOT OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);	
			util.addValue(row, col++,data.getControlarmoperatingproperlyDesc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			if(data.isAnymovementissue()== true)util.addValue(row, col++, "OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			else util.addValue(row, col++, "NOT OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);	
			util.addValue(row, col++,data.getAnymovementissueDesc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			if(data.isHandtruckblowdown()== true)util.addValue(row, col++, "OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			else util.addValue(row, col++, "NOT OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);	
			util.addValue(row, col++,data.getHandtruckblowdownDesc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			if(data.isLiftingproperly()== true)util.addValue(row, col++, "OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			else util.addValue(row, col++, "NOT OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);	
			util.addValue(row, col++,data.getControlarmoperatingproperlyDesc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			/***
			if(data.isBothfoldoutwingsopenorclosed()== true)util.addValue(row, col++, "OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			else util.addValue(row, col++, "NOT OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);	
			util.addValue(row, col++,data.getBothfoldoutwingsopenorclosedDesc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			if(data.isBotharetobeopenedandclosedatthesametime()== true)util.addValue(row, col++, "OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			else util.addValue(row, col++, "NOT OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);	
			util.addValue(row, col++,data.getBotharetobeopenedandclosedatthesametimeDesc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			**/
			if(data.isAlllocksoperational()== true)util.addValue(row, col++, "OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			else util.addValue(row, col++, "NOT OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);	
			util.addValue(row, col++,data.getAlllocksoperationalDesc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			if(data.isAlllightintactandworking()== true)util.addValue(row, col++, "OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			else util.addValue(row, col++, "NOT OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);	
			util.addValue(row, col++,data.getAlllightintactandworkingDesc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			if(data.isGladhandlocksbeingused()== true)util.addValue(row, col++, "OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			else util.addValue(row, col++, "NOT OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);	
			util.addValue(row, col++,data.getGladhandlocksbeingusedDesc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
		row++ ;
			
		}
		col = 0;
		util.mergeCell(row+2, row+2, col, col+4);
		util.addValue(row+2, col, "OBCC Completed = "+l+"%",Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.write(outputStream);
		
	}
	public void getExcelReportbyPercentage(Map<Date, Long> r2map,
			Map<Date, Long> ledmap, Map<Date, Long> r1map,
			Map<Date, Long> stockmap, Map<Date, Long> utilitymap,Map<Date, Long> r1WaterJetsmap, Map<Date, Long> r2WaterJetsmap, Map<Date, Long> winderDownmap, Map<Date, Long> avgmap, File file,
			ServletOutputStream outputStream) throws IOException {
		
		Workbook2007Util util = new Workbook2007Util(file,0);
		
		short rowHeight = 280;
		int row=2;
		int col=0;
		for (Map.Entry<Date, Long> entry : ledmap.entrySet())
		{
			//String monthYear=getFormatedDateAndMonth(entry.getKey());	
			util.addValue(row, col++, CommonUtil.dateParseOrFormat(entry.getKey()),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, entry.getValue()+"%",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			row++;
			col = 0;
			
		}
		row = 2;
		for (Map.Entry<Date, Long> entry : stockmap.entrySet())
		{
			col=2;
			util.addValue(row, col++, entry.getValue()+"%",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			row++;
		}
		row = 2;
		for (Map.Entry<Date, Long> entry : r2WaterJetsmap.entrySet())
		{
			col=3;
			util.addValue(row, col++, entry.getValue()+"%",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			row++;
		}
		row = 2;
		for (Map.Entry<Date, Long> entry : r2map.entrySet())
		{
			col=4;
			util.addValue(row, col++, entry.getValue()+"%",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			row++;
		}		
		row = 2;
		for (Map.Entry<Date, Long> entry : r1map.entrySet())
		{
			col=5;
			util.addValue(row, col++, entry.getValue()+"%",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			row++;
		}
		row = 2;
		for (Map.Entry<Date, Long> entry : r1WaterJetsmap.entrySet())
		{
			col=6;
			util.addValue(row, col++, entry.getValue()+"%",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			row++;
		}
		row = 2;
		for (Map.Entry<Date, Long> entry : utilitymap.entrySet())
		{
			col=7;
			util.addValue(row, col++, entry.getValue()+"%",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			row++;
		}
		row = 2;
		for (Map.Entry<Date, Long> entry : winderDownmap.entrySet())
		{
			col=8;
			util.addValue(row, col++, entry.getValue()+"%",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			row++;
		}
		
		row = 2;
		for (Map.Entry<Date, Long> entry : avgmap.entrySet())
		{
			col=9;
			util.addValue(row, col++, entry.getValue()+"%",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			row++;
		}
	
		util.write(outputStream);
	}
	/**
	 * @param daylst
	 * @param nightlst
	 * @param file
	 * @param outputStream
	 * @param l
	 * @throws IOException 
	 */
	public void getExcelReportR1WaterJetsDownDayNight(List<R1WaterJetsDown> both,
			File file, ServletOutputStream outputStream, long l) throws IOException {

		Workbook2007Util util = new Workbook2007Util(file,0);
		util.setSheetName("R1WaterJetsDown", 0);
		short rowHeight = 280;
		int row=3;
		int col=0;
		for(R1WaterJetsDown data:both){
			col =0;
			if(data.isMachinedown() == true)
				util.addValue(row, col++, "YES",Workbook2007Util.Style.STYLE_NORMAL_CENTER_RED, rowHeight);	
			else 
				util.addValue(row, col++, "NO",Workbook2007Util.Style.STYLE_NORMAL_CENTER_GREEN, rowHeight);
			util.addValue(row, col++,   data.getEdate(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.capitalizeFirstLetter(data.getPosition()), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.capitalizeFirstLetter(data.getShift()), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, data.getCrew(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			
			if(data.isExtractorTabeLevel()==true)
				util.addValue(row, col++, "YES",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			else 
				util.addValue(row, col++, "NO",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getExtractorTabeLevelDesc(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			if(data.isAllRollersInWorkingCondition()==true)
				util.addValue(row, col++, "YES",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);	
			else 
				util.addValue(row, col++, "NO",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			util.addValue(row, col++, data.getAllRollersInWorkingConditionDesc(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			if(data.isAnyAbnormalSounds()==true)
				util.addValue(row, col++, "YES",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);	
			else 
				util.addValue(row, col++, "NO",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			util.addValue(row, col++, data.getAnyAbnormalSoundsDesc(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			if(data.isHydralicMotorIssues()==true)
				util.addValue(row, col++, "YES",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);	
			else 
				util.addValue(row, col++, "NO",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			util.addValue(row, col++, data.getHydralicMotorIssuesDesc(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			if(data.isAnyHydralicLeaks()==true)
				util.addValue(row, col++, "YES",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);	
			else 
				util.addValue(row, col++, "NO",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			util.addValue(row, col++, data.getAnyHydralicLeaksDesc(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			if(data.isSensorsAndLimitSwitchesWorking()==true)
				util.addValue(row, col++, "YES",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);	
			else 
				util.addValue(row, col++, "NO",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			util.addValue(row, col++, data.getSensorsAndLimitSwitchesWorkingDesc(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			if(data.isChainAndSprocketsAllOk()==true)
				util.addValue(row, col++, "YES",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);	
			else 
				util.addValue(row, col++, "NO",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			util.addValue(row, col++, data.getChainAndSprocketsAllOkDesc(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			/**
			if(data.isWetAndCraneWorking()==true)
				util.addValue(row, col++, "YES",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);	
			else 
				util.addValue(row, col++, "NO",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			util.addValue(row, col++, data.getWetAndCraneWorkingDesc(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			if(data.isAllHookesworking()==true)
				util.addValue(row, col++, "YES",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);	
			else 
				util.addValue(row, col++, "NO",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			util.addValue(row, col++, data.getAllHookesworkingDesc(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			***/
			if(data.isWaterPressure()==true)
				util.addValue(row, col++, "YES",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);	
			else 
				util.addValue(row, col++, "NO",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			util.addValue(row, col++, data.getWaterPressureDesc(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			if(data.getPumpControlStationInUse()!=null)
				util.addValue(row, col++,data.getPumpControlStationInUse() ,Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);	
			else 
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			if(data.getPumpControlStationInUse2()!=null)
				util.addValue(row, col++,data.getPumpControlStationInUse2() ,Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);	
			else 
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			util.addValue(row, col++, data.getPumpControlStationInUseDesc(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			if(data.isAnyTableMovementIssue()==true)
				util.addValue(row, col++, "YES",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);	
			else 
				util.addValue(row, col++, "NO",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			util.addValue(row, col++, data.getAnyTableMovementIssueDesc(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			if(data.getFrontAndBackTableScrewOk()!=null)
				util.addValue(row, col++,data.getFrontAndBackTableScrewOk(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);	
			else 
				util.addValue(row, col++, "NO",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			if(data.getFrontAndBackTableScrewOk2()!=null)
				util.addValue(row, col++,data.getFrontAndBackTableScrewOk2(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);	
			else 
				util.addValue(row, col++, "NO",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			
			util.addValue(row, col++, data, Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			if(data.isTableAndLiftScrewsBlownDown()==true)
				util.addValue(row, col++, "YES",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);	
			else 
				util.addValue(row, col++, "NO",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			util.addValue(row, col++, data.getTableAndLiftScrewsBlownDownDesc(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			if(data.isAnyTrimShootIssues()==true)
				util.addValue(row, col++, "YES",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);	
			else 
				util.addValue(row, col++, "NO",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			util.addValue(row, col++, data.getAnyTrimShootIssuesDesc(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			if(data.isTableDrainClean()==true)
				util.addValue(row, col++, "YES",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);	
			else 
				util.addValue(row, col++, "NO",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			util.addValue(row, col++, data.getTableDrainCleanDesc(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			if(data.isFlueshLinesClean()==true)
				util.addValue(row, col++, "YES",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);	
			else 
				util.addValue(row, col++, "NO",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			util.addValue(row, col++, data.getFlueshLinesCleanDesc(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			/***
			if(data.isCheckCoolingWater()==true)
				util.addValue(row, col++, "YES",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);	
			else 
				util.addValue(row, col++, "NO",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			util.addValue(row, col++, data.getCheckCoolingWaterDesc(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			**/
			if(data.isAllPanelLightsWorking()==true)
				util.addValue(row, col++, "YES",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);	
			else 
				util.addValue(row, col++, "NO",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			util.addValue(row, col++, data.getAllPanelLightsWorkingDesc(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			if(data.isAirShaftsHolding()==true)
				util.addValue(row, col++, "YES",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);	
			else 
				util.addValue(row, col++, "NO",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			util.addValue(row, col++, data.getAirShaftsHoldingDesc(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			if(data.isAnyBreakingIssues()==true)
				util.addValue(row, col++, "YES",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);	
			else 
				util.addValue(row, col++, "NO",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			util.addValue(row, col++, data.getAnyBreakingIssuesDesc(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			row++;

		}
		
		col = 0;
		util.mergeCell(row+2, row+2, col, col+4);
		util.addValue(row+2, col, "OBCC Completed = "+l+"%",Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);		
		util.write(outputStream);
	}
	/**
	 * @param lst
	 * @param file
	 * @param outputStream
	 * @param l
	 * @throws IOException 
	 */
	public void getExcelReportR1WaterJetsDown(List<R1WaterJetsDown> lst, File file, ServletOutputStream outputStream,
			long l) throws IOException {
		
		Workbook2007Util util = new Workbook2007Util(file,0);
		util.setSheetName("Utility Operator ", 0);		
		
		short rowHeight = 280;
		int row=3;
		int col=0;
		for(R1WaterJetsDown data:lst){
			col =0;
			if(data.isMachinedown() == true)
				util.addValue(row, col++, "YES",Workbook2007Util.Style.STYLE_NORMAL_CENTER_RED, rowHeight);	
			else 
				util.addValue(row, col++, "NO",Workbook2007Util.Style.STYLE_NORMAL_CENTER_GREEN, rowHeight);
			util.addValue(row, col++,   data.getEdate(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.capitalizeFirstLetter(data.getPosition()), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.capitalizeFirstLetter(data.getShift()), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, data.getCrew(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			
			if(data.isExtractorTabeLevel()==true)
				util.addValue(row, col++, "YES",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			else 
				util.addValue(row, col++, "NO",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getExtractorTabeLevelDesc(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			if(data.isAllRollersInWorkingCondition()==true)
				util.addValue(row, col++, "YES",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);	
			else 
				util.addValue(row, col++, "NO",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			util.addValue(row, col++, data.getAllRollersInWorkingConditionDesc(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			if(data.isAnyAbnormalSounds()==true)
				util.addValue(row, col++, "YES",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);	
			else 
				util.addValue(row, col++, "NO",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			util.addValue(row, col++, data.getAnyAbnormalSoundsDesc(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			if(data.isHydralicMotorIssues()==true)
				util.addValue(row, col++, "YES",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);	
			else 
				util.addValue(row, col++, "NO",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			util.addValue(row, col++, data.getHydralicMotorIssuesDesc(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			if(data.isAnyHydralicLeaks()==true)
				util.addValue(row, col++, "YES",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);	
			else 
				util.addValue(row, col++, "NO",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			util.addValue(row, col++, data.getAnyHydralicLeaksDesc(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			if(data.isSensorsAndLimitSwitchesWorking()==true)
				util.addValue(row, col++, "YES",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);	
			else 
				util.addValue(row, col++, "NO",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			util.addValue(row, col++, data.getSensorsAndLimitSwitchesWorkingDesc(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			if(data.isChainAndSprocketsAllOk()==true)
				util.addValue(row, col++, "YES",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);	
			else 
				util.addValue(row, col++, "NO",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			util.addValue(row, col++, data.getChainAndSprocketsAllOkDesc(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			/**
			if(data.isWetAndCraneWorking()==true)
				util.addValue(row, col++, "YES",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);	
			else 
				util.addValue(row, col++, "NO",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			util.addValue(row, col++, data.getWetAndCraneWorkingDesc(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			if(data.isAllHookesworking()==true)
				util.addValue(row, col++, "YES",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);	
			else 
				util.addValue(row, col++, "NO",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			util.addValue(row, col++, data.getAllHookesworkingDesc(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			**/
			if(data.isWaterPressure()==true)
				util.addValue(row, col++, "YES",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);	
			else 
				util.addValue(row, col++, "NO",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			util.addValue(row, col++, data.getWaterPressureDesc(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			if(data.getPumpControlStationInUse()!=null)
				util.addValue(row, col++,data.getPumpControlStationInUse(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);	
			else 
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			if(data.getPumpControlStationInUse2()!=null)
				util.addValue(row, col++,data.getPumpControlStationInUse2(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);	
			else 
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			
			util.addValue(row, col++, data.getPumpControlStationInUseDesc(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			if(data.isAnyTableMovementIssue()==true)
				util.addValue(row, col++, "YES",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);	
			else 
				util.addValue(row, col++, "NO",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			util.addValue(row, col++, data.getAnyTableMovementIssueDesc(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			if(data.getFrontAndBackTableScrewOk()!=null)
				util.addValue(row, col++,data.getFrontAndBackTableScrewOk(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);	
			else 
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			if(data.getFrontAndBackTableScrewOk()!=null)
				util.addValue(row, col++,data.getFrontAndBackTableScrewOk(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);	
			else 
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);	
			
			util.addValue(row, col++, data, Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			if(data.isTableAndLiftScrewsBlownDown()==true)
				util.addValue(row, col++, "YES",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);	
			else 
				util.addValue(row, col++, "NO",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			util.addValue(row, col++, data.getTableAndLiftScrewsBlownDownDesc(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			if(data.isAnyTrimShootIssues()==true)
				util.addValue(row, col++, "YES",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);	
			else 
				util.addValue(row, col++, "NO",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			util.addValue(row, col++, data.getAnyTrimShootIssuesDesc(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			if(data.isTableDrainClean()==true)
				util.addValue(row, col++, "YES",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);	
			else 
				util.addValue(row, col++, "NO",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			util.addValue(row, col++, data.getTableDrainCleanDesc(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			if(data.isFlueshLinesClean()==true)
				util.addValue(row, col++, "YES",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);	
			else 
				util.addValue(row, col++, "NO",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			util.addValue(row, col++, data.getFlueshLinesCleanDesc(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			/**
			if(data.isCheckCoolingWater()==true)
				util.addValue(row, col++, "YES",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);	
			else 
				util.addValue(row, col++, "NO",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			util.addValue(row, col++, data.getCheckCoolingWaterDesc(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			**/
			if(data.isAllPanelLightsWorking()==true)
				util.addValue(row, col++, "YES",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);	
			else 
				util.addValue(row, col++, "NO",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			util.addValue(row, col++, data.getAllPanelLightsWorkingDesc(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			if(data.isAirShaftsHolding()==true)
				util.addValue(row, col++, "YES",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);	
			else 
				util.addValue(row, col++, "NO",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			util.addValue(row, col++, data.getAirShaftsHoldingDesc(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			if(data.isAnyBreakingIssues()==true)
				util.addValue(row, col++, "YES",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);	
			else 
				util.addValue(row, col++, "NO",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			util.addValue(row, col++, data.getAnyBreakingIssuesDesc(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			row++;
	}
		
		col = 0;
		util.mergeCell(row+2, row+2, col, col+4);
		util.addValue(row+2, col, "OBCC Completed = "+l+"%",Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);		
		util.write(outputStream);
		
	}
	/**
	 * @param daylst
	 * @param nightlst
	 * @param file
	 * @param outputStream
	 * @param l
	 * @throws IOException 
	 */
	public void getExcelReportR2WaterJetsDownDayNight(List<R2WaterJetsDown> both,
			File file, ServletOutputStream outputStream, long l) throws IOException {
		Workbook2007Util util = new Workbook2007Util(file,0);
		util.setSheetName("Utility Operator ", 0);		
		
		short rowHeight = 280;
		int row=3;
		int col=0;
		for(R2WaterJetsDown data:both){
			col =0;
			if(data.isMachinedown() == true)
				util.addValue(row, col++, "YES",Workbook2007Util.Style.STYLE_NORMAL_CENTER_RED, rowHeight);	
			else 
				util.addValue(row, col++, "NO",Workbook2007Util.Style.STYLE_NORMAL_CENTER_GREEN, rowHeight);
			util.addValue(row, col++, data.getEdate(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.capitalizeFirstLetter(data.getPosition()), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.capitalizeFirstLetter(data.getShift()), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, data.getCrew(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			/**
			if(data.isSketchWrapdozier()== true)util.addValue(row, col++, "YES",Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			else util.addValue(row, col++, "NO",Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, data.getSketchWrapdozierDesc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			**/
			if(data.isAnycontrolpanelissues()== true)util.addValue(row, col++, "YES",Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			else util.addValue(row, col++, "NO",Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, data.getAnycontrolpanelissuesDesc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			if(data.isTurntableWorkingproperly()== true)util.addValue(row, col++, "YES",Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			else util.addValue(row, col++, "NO",Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, data.getTurntableWorkingproperlyDesc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			if(data.isAutomaticWeightinputOk()== true)util.addValue(row, col++, "YES",Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			else util.addValue(row, col++, "NO",Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, data.getAutomaticWeightinputOkDesc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			if(data.isSafetygatesintacandbeingused()== true)util.addValue(row, col++, "YES",Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			else util.addValue(row, col++, "NO",Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, data.getSafetygatesintacandbeingusedDesc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			if(data.isRollStopperinplaceandbeingused()== true)util.addValue(row, col++, "YES",Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			else util.addValue(row, col++, "NO",Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, data.getRollStopperinplaceandbeingusedDesc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			if(data.isLaserandMirrorCleaned()== true)util.addValue(row, col++, "YES",Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			else util.addValue(row, col++, "NO",Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, data.getLaserandMirrorCleanedDesc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			if(data.isAllHandRailsIntact()== true)util.addValue(row, col++, "YES",Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			else util.addValue(row, col++, "NO",Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, data.getAllHandRailsIntactDesc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			if(data.isAllEnjectionSystemWorkingProperly()== true)util.addValue(row, col++, "YES",Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			else util.addValue(row, col++, "NO",Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);			
			util.addValue(row, col++, data.getAllEnjectionSystemWorkingProperlyDesc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			if(data.isWrapper150ml_360()== true)util.addValue(row, col++, "YES",Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			else util.addValue(row, col++, "NO",Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, data.getWrapper150ml_360Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			if(data.isRollRampOk()== true)util.addValue(row, col++, "YES",Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			else util.addValue(row, col++, "NO",Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, data.getRollRampOkDesc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			/**
			if(data.isDryandCraneWorkingProperly()== true)util.addValue(row, col++, "YES",Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			else util.addValue(row, col++, "NO",Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, data.getDryandCraneWorkingProperlyDesc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			if(data.isAllHooksWorking()== true)util.addValue(row, col++, "YES",Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			else util.addValue(row, col++, "NO",Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, data.getAllHooksWorkingDesc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			**/
			row++;
		}
			
			col = 0;
			util.mergeCell(row+2, row+2, col, col+4);
			util.addValue(row+2, col, "OBCC Completed = "+l+"%",Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);		
			util.write(outputStream);
	}
	/**
	 * @param lst
	 * 
	 * @param file
	 * @param outputStream
	 * @param l
	 * @throws IOException 
	 */
	public void getExcelReportR2WaterJetsDown(List<R2WaterJetsDown> lst, File file, ServletOutputStream outputStream,
			long l) throws IOException {
		
		Workbook2007Util util = new Workbook2007Util(file,0);
		util.setSheetName("Utility Operator ", 0);		
		
		short rowHeight = 280;
		int row=3;
		int col=0;
		for(R2WaterJetsDown data:lst){
			col =0;
			if(data.isMachinedown() == true)
				util.addValue(row, col++, "YES",Workbook2007Util.Style.STYLE_NORMAL_CENTER_RED, rowHeight);	
			else 
				util.addValue(row, col++, "NO",Workbook2007Util.Style.STYLE_NORMAL_CENTER_GREEN, rowHeight);
			util.addValue(row, col++,   data.getEdate(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.capitalizeFirstLetter(data.getPosition()), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.capitalizeFirstLetter(data.getShift()), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, data.getCrew(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			/**
			if(data.isSketchWrapdozier()== true)util.addValue(row, col++, "YES",Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			else util.addValue(row, col++, "NO",Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, data.getSketchWrapdozierDesc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			**/
			if(data.isAnycontrolpanelissues()== true)util.addValue(row, col++, "YES",Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			else util.addValue(row, col++, "NO",Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, data.getAnycontrolpanelissuesDesc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			if(data.isTurntableWorkingproperly()== true)util.addValue(row, col++, "YES",Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			else util.addValue(row, col++, "NO",Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, data.getTurntableWorkingproperlyDesc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			if(data.isAutomaticWeightinputOk()== true)util.addValue(row, col++, "YES",Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			else util.addValue(row, col++, "NO",Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, data.getAutomaticWeightinputOkDesc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			if(data.isSafetygatesintacandbeingused()== true)util.addValue(row, col++, "YES",Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			else util.addValue(row, col++, "NO",Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, data.getSafetygatesintacandbeingusedDesc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			if(data.isRollStopperinplaceandbeingused()== true)util.addValue(row, col++, "YES",Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			else util.addValue(row, col++, "NO",Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, data.getRollStopperinplaceandbeingusedDesc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			if(data.isLaserandMirrorCleaned()== true)util.addValue(row, col++, "YES",Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			else util.addValue(row, col++, "NO",Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, data.getLaserandMirrorCleanedDesc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			if(data.isAllHandRailsIntact()== true)util.addValue(row, col++, "YES",Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			else util.addValue(row, col++, "NO",Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, data.getAllHandRailsIntactDesc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			if(data.isAllEnjectionSystemWorkingProperly()== true)util.addValue(row, col++, "YES",Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			else util.addValue(row, col++, "NO",Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);			
			util.addValue(row, col++, data.getAllEnjectionSystemWorkingProperlyDesc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			if(data.isWrapper150ml_360()== true)util.addValue(row, col++, "YES",Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			else util.addValue(row, col++, "NO",Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, data.getWrapper150ml_360Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			if(data.isRollRampOk()== true)util.addValue(row, col++, "YES",Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			else util.addValue(row, col++, "NO",Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, data.getRollRampOkDesc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			/**
			if(data.isDryandCraneWorkingProperly()== true)util.addValue(row, col++, "YES",Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			else util.addValue(row, col++, "NO",Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, data.getDryandCraneWorkingProperlyDesc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			if(data.isAllHooksWorking()== true)util.addValue(row, col++, "YES",Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			else util.addValue(row, col++, "NO",Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, data.getAllHooksWorkingDesc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			**/
			row++;
			row++;
		}
			
			col = 0;
			util.mergeCell(row+2, row+2, col, col+4);
			util.addValue(row+2, col, "OBCC Completed = "+l+"%",Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);		
			util.write(outputStream);
		
	}
	/**
	 * @param daylst
	 * @param nightlst
	 * @param file
	 * @param outputStream
	 * @param l
	 * @throws IOException 
	 */
	public void getExcelReportWinderDownDayNight(List<WinderDown> both, File file,
			ServletOutputStream outputStream, long l) throws IOException {
		
		Workbook2007Util util = new Workbook2007Util(file,0);
		util.setSheetName("WinderDown", 0);		
		
		short rowHeight = 280;
		int row=3;
		int col=0;
		for(WinderDown data:both){
			col =0;
			if(data.isMachinedown() == true)
				util.addValue(row, col++, "YES",Workbook2007Util.Style.STYLE_NORMAL_CENTER_RED, rowHeight);	
			else 
				util.addValue(row, col++, "NO",Workbook2007Util.Style.STYLE_NORMAL_CENTER_GREEN, rowHeight);
			util.addValue(row, col++,   data.getEdate(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.capitalizeFirstLetter(data.getPosition()), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.capitalizeFirstLetter(data.getShift()), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, data.getCrew(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			
		if(data.isPower()==true)
			util.addValue(row, col++, "YES",Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			else util.addValue(row, col++, "NO",Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, data,Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			if(data.isBlade()==true)
			util.addValue(row, col++, "YES",Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			else util.addValue(row, col++, "NO",Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, data,Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			if(data.isSizeadjustmentmovement()==true)
			util.addValue(row, col++, "YES",Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			else util.addValue(row, col++, "NO",Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, data,Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			if(data.isRollkickerworkingproperly()==true)
			util.addValue(row, col++, "YES",Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			else util.addValue(row, col++, "NO",Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, data,Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			if(data.isAnyhydraulicleaks()==true)
			util.addValue(row, col++, "YES",Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			else util.addValue(row, col++, "NO",Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, data,Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			if(data.isUprightbumperandcushionbumperworkingproperly()==true)
			util.addValue(row, col++, "YES",Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			else util.addValue(row, col++, "NO",Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, data,Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			if(data.isAnycontrolpanelissues()==true)
			util.addValue(row, col++, "YES",Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			else util.addValue(row, col++, "NO",Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, data,Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			if(data.isAnynoticeableissueswithconveyor()==true)
			util.addValue(row, col++, "YES",Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			else util.addValue(row, col++, "NO",Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, data,Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			row++;
		}
		/**
		for(WinderDown data:nightlst){
			col =0;
			if(data.isMachinedown() == true)
				util.addValue(row, col++, "YES",Workbook2007Util.Style.STYLE_NORMAL_CENTER_RED, rowHeight);	
			else 
				util.addValue(row, col++, "NO",Workbook2007Util.Style.STYLE_NORMAL_CENTER_GREEN, rowHeight);
			util.addValue(row, col++,   data.getEdate(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.capitalizeFirstLetter(data.getPosition()), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.capitalizeFirstLetter(data.getShift()), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, data.getCrew(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			
		if(data.isPower()==true)
			util.addValue(row, col++, "YES",Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			else util.addValue(row, col++, "NO",Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, data,Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			if(data.isBlade()==true)
			util.addValue(row, col++, "YES",Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			else util.addValue(row, col++, "NO",Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, data,Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			if(data.isSizeadjustmentmovement()==true)
			util.addValue(row, col++, "YES",Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			else util.addValue(row, col++, "NO",Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, data,Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			if(data.isRollkickerworkingproperly()==true)
			util.addValue(row, col++, "YES",Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			else util.addValue(row, col++, "NO",Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, data,Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			if(data.isAnyhydraulicleaks()==true)
			util.addValue(row, col++, "YES",Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			else util.addValue(row, col++, "NO",Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, data,Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			if(data.isUprightbumperandcushionbumperworkingproperly()==true)
			util.addValue(row, col++, "YES",Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			else util.addValue(row, col++, "NO",Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, data,Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			if(data.isAnycontrolpanelissues()==true)
			util.addValue(row, col++, "YES",Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			else util.addValue(row, col++, "NO",Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, data,Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			if(data.isAnynoticeableissueswithconveyor()==true)
			util.addValue(row, col++, "YES",Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			else util.addValue(row, col++, "NO",Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, data,Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			row++;
		}
		**/
		row++;
		col = 0;
		util.mergeCell(row+2, row+2, col, col+4);
		util.addValue(row+2, col, "OBCC Completed = "+l+"%",Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);		
		util.write(outputStream);
	}
	/**
	 * @param lst
	 * @param file
	 * @param outputStream
	 * @param l
	 * @throws IOException 
	 */
	public void getExcelReportWinderDown(List<WinderDown> lst, File file, ServletOutputStream outputStream, long l) throws IOException {
		
		
		Workbook2007Util util = new Workbook2007Util(file,0);
		util.setSheetName("Utility Operator ", 0);		
		
		short rowHeight = 280;
		int row=3;
		int col=0;
		
		for(WinderDown data:lst){
			col =0;
			if(data.isMachinedown() == true)
				util.addValue(row, col++, "YES",Workbook2007Util.Style.STYLE_NORMAL_CENTER_RED, rowHeight);	
			else 
				util.addValue(row, col++, "NO",Workbook2007Util.Style.STYLE_NORMAL_CENTER_GREEN, rowHeight);
			util.addValue(row, col++,   data.getEdate(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.capitalizeFirstLetter(data.getPosition()), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.capitalizeFirstLetter(data.getShift()), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, data.getCrew(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			
		if(data.isPower()==true)
			util.addValue(row, col++, "YES",Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			else util.addValue(row, col++, "NO",Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, data,Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			if(data.isBlade()==true)
			util.addValue(row, col++, "YES",Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			else util.addValue(row, col++, "NO",Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, data,Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			if(data.isSizeadjustmentmovement()==true)
			util.addValue(row, col++, "YES",Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			else util.addValue(row, col++, "NO",Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, data,Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			if(data.isRollkickerworkingproperly()==true)
			util.addValue(row, col++, "YES",Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			else util.addValue(row, col++, "NO",Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, data,Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			if(data.isAnyhydraulicleaks()==true)
			util.addValue(row, col++, "YES",Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			else util.addValue(row, col++, "NO",Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, data,Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			if(data.isUprightbumperandcushionbumperworkingproperly()==true)
			util.addValue(row, col++, "YES",Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			else util.addValue(row, col++, "NO",Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, data,Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			if(data.isAnycontrolpanelissues()==true)
			util.addValue(row, col++, "YES",Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			else util.addValue(row, col++, "NO",Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, data,Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			if(data.isAnynoticeableissueswithconveyor()==true)
			util.addValue(row, col++, "YES",Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			else util.addValue(row, col++, "NO",Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, data,Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			row++;
		}
		row++;
		col = 0;
		util.mergeCell(row+2, row+2, col, col+4);
		util.addValue(row+2, col, "OBCC Completed = "+l+"%",Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);		
		util.write(outputStream);
		
	}
}

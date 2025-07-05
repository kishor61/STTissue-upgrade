/**
 *Jul 18, 2016
 *ObccReportHandler.java
 * TODO
 *com.st.obcc.report.handler
 *ObccReportHandler.java
 *Roshan Lal Tailor
 */
package com.st.obcc.report.handler;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Formatter;
import java.util.List;
import java.util.Map;

import jakarta.servlet.ServletOutputStream;

import org.apache.commons.io.IOUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFClientAnchor;
import org.apache.poi.xssf.usermodel.XSSFDrawing;
import org.apache.poi.xssf.usermodel.XSSFPicture;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;

import com.st.common.CommonUtil;
import com.st.common.Workbook2007Util;
import com.st.obcc.model.BackTender;
import com.st.obcc.model.MachineTender;
import com.st.obcc.model.OperatorData;
import com.st.obcc.model.R1Operator;
import com.st.obcc.model.StockOperator;
import com.st.obcc.model.UtilityOperator;

/**
 * @author snavhaal
 *
 */
@Component
public class ObccReportHandler {
	
	
	private SimpleDateFormat dateFormat=new SimpleDateFormat("MM-dd-yyyy");
	public void getExcelReport(List<OperatorData> operatordata, File file, ServletOutputStream outputStream,long l) throws IOException {
		
		Workbook2007Util util = new Workbook2007Util(file,0);
		util.setSheetName("R2 Operator ", 0);
		  
		
		
		short rowHeight = 280;
		int row=5;
		int col=0;		
		for(OperatorData data:operatordata){
			col =0;
			
			 if(data.isMachinedown())
				   util.addValue(row, col++, "YES", Workbook2007Util.Style.STYLE_NORMAL_CENTER_RED, rowHeight);
			   else
				   util.addValue(row, col++,"NO", Workbook2007Util.Style.STYLE_NORMAL_CENTER_GREEN, rowHeight); 
			util.addValue(row, col++,   data.getEdate(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_GREEN, rowHeight);
			util.addValue(row, col++, data.getPosition(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.capitalizeFirstLetter(data.getShift()), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, data.getCrew(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
		
		
		
		//System.out.println("data.isMovementcol1()"+data.isMovementcol1());
		
		if(data.isMovementcol1() == true)
		{
			util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
		}
		else if(data.isMovementcol1() == false) 
		{
			util.addValue(row, col++, "No",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
		}else
		{
			util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
		}
		
		util.addValue(row, col++, data.getMovementcol1desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
		
		if(data.isConveyorcol1() == true)
		{
			util.addValue(row, col++, "Ok",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
		}
		else if(data.isConveyorcol1() == false) 
		{
			util.addValue(row, col++, "Not Ok",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
		}else
		{
			util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
		}
		
		util.addValue(row, col++, data.getConveyorcol1desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
		
		if(data.isConveyorcol2() == true)
		{
			util.addValue(row, col++, "Ok",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
		}
		else if(data.isConveyorcol2() == false) 
		{
			util.addValue(row, col++, "Not Ok",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
		}else
		{
			util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
		}
		util.addValue(row, col++, data.getConveyorcol2desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
		
		if(data.isConveyorcol3() == true)
		{
			util.addValue(row, col++, "Overheating",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
		}
		else if(data.isConveyorcol3() == false) 
		{
			util.addValue(row, col++, "Overheating",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
		}else
		{
			util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
		}
		util.addValue(row, col++, data.getConveyorcol3desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
		
		
		if(data.isConveyorcol4() == true)
		{
			util.addValue(row, col++, "Abnormal Sound",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
		}
		else if(data.isConveyorcol4() == false) 
		{
			util.addValue(row, col++, " No AbnormalSound ",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
		}else
		{
			util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
		}
		
		util.addValue(row, col++, data.getConveyorcol4desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
		
		
		if(data.isConveyorcol5() == true)
		{
			util.addValue(row, col++, "Ok",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
		}
		else if(data.isConveyorcol5() == false) 
		{
			util.addValue(row, col++, " Not OK ",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
		}else
		{
			util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
		}
		
		util.addValue(row, col++, data.getConveyorcol5desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
		
		if(data.isPowercol1() == true)
		{
			util.addValue(row, col++, "ON",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
		}
		else if(data.isPowercol1() == false) 
		{
			util.addValue(row, col++, " Off ",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
		}else
		{
			util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
		}
		util.addValue(row, col++, data.getPowercol1desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
		
		if(data.isPowercol2() == true)
		{
			util.addValue(row, col++, "OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
		}
		else if(data.isPowercol2() == false) 
		{
			util.addValue(row, col++, " Not Ok ",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
		}else
		{
			util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
		}
		util.addValue(row, col++, data.getPowercol2desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
		
		
		if(data.isPowercol3() == true)
		{
			util.addValue(row, col++, "OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
		}
		else if(data.isPowercol3() == false) 
		{
			util.addValue(row, col++, " Not Ok ",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
		}else
		{
			util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
		}
		
		util.addValue(row, col++, data.getPowercol3desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
		
		if(data.isPowercol4() == true)
		{
			util.addValue(row, col++, "OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
		}
		else if(data.isPowercol4() == false) 
		{
			util.addValue(row, col++, " Not Ok ",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
		}else
		{
			util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
		}
		util.addValue(row, col++, data.getPowercol4desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
		
		
		if(data.isOrdercol1() == true)
		{
			util.addValue(row, col++, "OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
		}
		else if(data.isOrdercol1() == false) 
		{
			util.addValue(row, col++, " Not Ok ",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
		}else
		{
			util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
		}
		
		util.addValue(row, col++, data.getOrdercol1desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
		
	  	
		row++ ;
			
		}
		col = 0;
		util.addValue(row+2, col++, "OBCC Completed = "+l+"%",Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeight);
		
		
		util.write(outputStream);
	}
	
	public void getExcelReportForUtility(List<UtilityOperator> operatordata, File file, ServletOutputStream outputStream,long l) throws IOException {
		
		Workbook2007Util util = new Workbook2007Util(file,0);
		util.setSheetName("Utility Operator ", 0);
		  
		
		
		short rowHeight = 280;
		int row=3;
		int col=0;
		for(UtilityOperator data:operatordata){
			col =0;
			 if(data.isMachinedown())
				   util.addValue(row, col++, "YES", Workbook2007Util.Style.STYLE_NORMAL_CENTER_RED, rowHeight);
			   else
				   util.addValue(row, col++,"NO", Workbook2007Util.Style.STYLE_NORMAL_CENTER_GREEN, rowHeight); 
			util.addValue(row, col++,   data.getEdate(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_GREEN, rowHeight);
			util.addValue(row, col++, CommonUtil.capitalizeFirstLetter(data.getPosition()), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.capitalizeFirstLetter(data.getShift()), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, data.getCrew(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
		 
	  	
			if(data.isWrapperFoxCol1() == true)
			{
				util.addValue(row, col++, "OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isWrapperFoxCol1() == false) 
			{
				util.addValue(row, col++, " Not Ok ",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			
			util.addValue(row, col++, data.getWrapperFoxCol1Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			if(data.isWrapperFoxCol2() == true)
			{
				util.addValue(row, col++, "OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isWrapperFoxCol2() == false) 
			{
				util.addValue(row, col++, " Not Ok ",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			
			util.addValue(row, col++, data.getWrapperFoxCol2Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			if(data.isWrapperFoxCol3() == true)
			{
				util.addValue(row, col++, "OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isWrapperFoxCol3() == false) 
			{
				util.addValue(row, col++, " Not Ok ",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			
			util.addValue(row, col++, data.getWrapperFoxCol3Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			/****
			if(data.isWrapperFoxCol4() == true)
			{
				util.addValue(row, col++, "OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isWrapperFoxCol4() == false) 
			{
				util.addValue(row, col++, " Not Ok ",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
		
			util.addValue(row, col++, data.getWrapperFoxCol4Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			***/
			
			if(data.isWrapperFoxCol5() == true)
			{
				util.addValue(row, col++, "Abnormal Sound",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isWrapperFoxCol5() == false) 
			{
				util.addValue(row, col++, " No Abnormal Sound ",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			
			util.addValue(row, col++, data.getWrapperFoxCol5Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			
			
			
			
			if(data.isWrapperWuftechCol1() == true)
			{
				util.addValue(row, col++, "OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isWrapperWuftechCol1() == false) 
			{
				util.addValue(row, col++, " Not Ok ",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			
			util.addValue(row, col++, data.getWrapperWuftechCol1Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			if(data.isWrapperWuftechCol2() == true)
			{
				util.addValue(row, col++, "OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isWrapperWuftechCol2() == false) 
			{
				util.addValue(row, col++, " Not Ok ",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			
			
			util.addValue(row, col++, data.getWrapperWuftechCol2Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			
			if(data.isWrapperWuftechCol3() == true)
			{
				util.addValue(row, col++, "OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isWrapperWuftechCol3() == false) 
			{
				util.addValue(row, col++, " Not Ok ",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			
			util.addValue(row, col++, data.getWrapperWuftechCol3Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			/*****
			
			if(data.isWrapperWuftechCol4() == true)
			{
				util.addValue(row, col++, "Overheating",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isWrapperWuftechCol4() == false) 
			{
				util.addValue(row, col++, " Not  Overheating ",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			
			util.addValue(row, col++, data.getWrapperWuftechCol4Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			***/
			
			if(data.isWrapperWuftechCol5() == true)
			{
				util.addValue(row, col++, "Abnormal Sound",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isWrapperWuftechCol5() == false) 
			{
				util.addValue(row, col++, " No Abnormal Sound ",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			
			
			util.addValue(row, col++, data.getWrapperWuftechCol5Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			
			if(data.isWrapperWuftechCol6() == true)
			{
				util.addValue(row, col++, "Abnormal Sound",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isWrapperWuftechCol6() == false) 
			{
				util.addValue(row, col++, " No Abnormal Sound ",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			
			util.addValue(row, col++, data.getWrapperWuftechCol6Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			


			if(data.isScaleCol1() == true)
			{
				util.addValue(row, col++, "Ok",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isScaleCol1() == false) 
			{
				util.addValue(row, col++, " Not Ok ",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			
			util.addValue(row, col++, data.getScaleCol1Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			
			if(data.isScaleCol2() == true)
			{
				util.addValue(row, col++, "Ok",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isScaleCol2() == false) 
			{
				util.addValue(row, col++, "Not Ok ",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			
			util.addValue(row, col++, data.getScaleCol2Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			if(data.isScaleCol3() == true)
			{
				util.addValue(row, col++, "Ok",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isScaleCol3() == false) 
			{
				util.addValue(row, col++, " Not Ok ",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			
			util.addValue(row, col++, data.getScaleCol3Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			if(data.isScaleCol4() == true)
			{
				util.addValue(row, col++, "Ok",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isScaleCol4() == false) 
			{
				util.addValue(row, col++, " Not Ok ",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			util.addValue(row, col++, data.getScaleCol4Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			 
			
			
		row++ ;
			
		}
		col = 0;
		util.addValue(row+2, col++, "OBCC Completed = "+l+"%",Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeight);
		
		util.write(outputStream);
	}
	
	public void getExcelReportForR1Operaotr(List<R1Operator> operatordata, File file, ServletOutputStream outputStream,long l) throws IOException {
		
		Workbook2007Util util = new Workbook2007Util(file,0);
		util.setSheetName("R1 Operator ", 0);
		
		short rowHeight = 280;
		int row=3;
		int col=0;
		
		for(R1Operator data:operatordata){
			col =0;
			 if(data.isMachinedown())
				   util.addValue(row, col++, "YES", Workbook2007Util.Style.STYLE_NORMAL_CENTER_RED, rowHeight);
			   else
				   util.addValue(row, col++,"NO", Workbook2007Util.Style.STYLE_NORMAL_CENTER_GREEN, rowHeight); 
			util.addValue(row, col++,   data.getEdate(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_GREEN, rowHeight);
			util.addValue(row, col++, CommonUtil.capitalizeFirstLetter(data.getPosition()), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.capitalizeFirstLetter(data.getShift()), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, data.getCrew(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			
						
			
			
			if(data.getLeadInRollCol1() != null)
			{
				util.addValue(row, col++,data.getLeadInRollCol1() ,Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			
			util.addValue(row, col++, data.getLeadInRollCol1Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			if(data.isLeadInRollCol2() == true)
			{
				util.addValue(row, col++, "Oil Leakage",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.getLeadInRollCol1() != null) 
			{
				util.addValue(row, col++, " No Oil Leakage",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}else
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
				util.addValue(row, col++, " No Abnormal Sound ",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			util.addValue(row, col++, data.getLeadInRollCol3Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			if(data.getLeadInRollCol4() != null)
			{
				util.addValue(row, col++, data.getLeadInRollCol4(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			
			util.addValue(row, col++, data.getLeadInRollCol4Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
            if(data.isLeadInRollCol5() == true)
            {
				util.addValue(row, col++, "Abnormal Sound",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isLeadInRollCol5() == false) 
			{
				util.addValue(row, col++, " No Abnormal Sound ",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			
			util.addValue(row, col++, data.getLeadInRollCol5Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			 
			
			if(data.isSectionRollCol1() == true)
			 {
				util.addValue(row, col++, "Free Tuning",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isSectionRollCol1() == false) 
			{
				util.addValue(row, col++, " No Free Tuning ",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}else
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
				util.addValue(row, col++, " No Leakage ",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			
			util.addValue(row, col++, data.getBreakAssemblyCol1Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			/**
			
			if(data.isBreakAssemblyCol2() == true)
			 {
				util.addValue(row, col++, "Ok",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isBreakAssemblyCol2() == false) 
			{
				util.addValue(row, col++, " NotOk ",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			
			util.addValue(row, col++, data.getBreakAssemblyCol2Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			
			***/
			
			
			
			if(data.isSlittersCol1() == true)
			 {
				util.addValue(row, col++, "Ok",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isSlittersCol1() == false) 
			{
				util.addValue(row, col++, " NotOk ",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}else
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
				util.addValue(row, col++, " NotOk ",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}else
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
				util.addValue(row, col++, " NotOk ",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			util.addValue(row, col++, data.getSlittersCol3Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			
			if(data.isTrimAssemblyCol1() == true)
			 {
				util.addValue(row, col++, "Ok",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isTrimAssemblyCol1() == false) 
			{
				util.addValue(row, col++, " NotOk ",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			util.addValue(row, col++, data.getTrimAssemblyCol1Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			/***
			if(data.isTrimAssemblyCol2() == true)
			 {
				util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isTrimAssemblyCol2() == false) 
			{
				util.addValue(row, col++, " No",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}else
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
				util.addValue(row, col++, " No Abnormal Sound",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			
			util.addValue(row, col++, data.getTrimAssemblyCol3Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			
			if(data.isTrimAssemblyCol4() == true)
			{
				util.addValue(row, col++, "Ok",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isTrimAssemblyCol4() == false) 
			{
				util.addValue(row, col++, " NotOk ",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			
			util.addValue(row, col++, data.getTrimAssemblyCol4Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			***/
			
			
			
			if(data.isTensiionRollCol1() == true)
			{
				util.addValue(row, col++, "free",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isTensiionRollCol1() == false) 
			{
				util.addValue(row, col++, " Not ",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}else
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
				util.addValue(row, col++, " Not  Build Up",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}else
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
				util.addValue(row, col++, " Not  ok",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			
			util.addValue(row, col++, data.getTensiionRollCol3Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			
			
			
			//////
			
			
			if(data.getWinderDrum1Col1() != null)
			{
				util.addValue(row, col++,data.getWinderDrum1Col1(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			
			
			util.addValue(row, col++, data.getWinderDrum1Col1Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			
			if(data.isWinderDrum1Col2() == true)
			{
				util.addValue(row, col++, "Oil Leakage ",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isWinderDrum1Col2() == false) 
			{
				util.addValue(row, col++, " No Oil Leakage ",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}else
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
				util.addValue(row, col++, " No Abnormal Sound ",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			
			util.addValue(row, col++, data.getWinderDrum1Col3Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			//
			
			if(data.getWinderDrum1Col4() != null)
			{
				util.addValue(row, col++,data.getWinderDrum1Col4(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			
			util.addValue(row, col++, data.getWinderDrum1Col4Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);

			
			
			if(data.isWinderDrum1Col5() == true)
			{
				util.addValue(row, col++, "Abnormal Sound",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isWinderDrum1Col5() == false) 
			{
				util.addValue(row, col++, " No Abnormal Sound ",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			
			util.addValue(row, col++, data.getWinderDrum1Col5Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			
			
			
			/*if(data.isWinderDrum1Col6() == true)
			{
				util.addValue(row, col++, "OverHeating",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else
			{
				util.addValue(row, col++, "No OverHeating",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			
			util.addValue(row, col++, data.getWinderDrum1Col6Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);

			
			
			if(data.isWinderDrum1Col7() == true)
			{
				util.addValue(row, col++, "Abnormal Sound",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else
			{
				util.addValue(row, col++, "No Abnormal Sound",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			
			util.addValue(row, col++, data.getWinderDrum1Col7Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);*/
			
			////2
			
			
			if(data.getWinderDrum2Col1() != null)
			{
				util.addValue(row, col++, data.getWinderDrum2Col1(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			
			util.addValue(row, col++, data.getWinderDrum2Col1Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			if(data.isWinderDrum2Col2() == true)
			{
				util.addValue(row, col++, "Oil Leakage",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isWinderDrum1Col2() == false) 
			{
				util.addValue(row, col++, " No Oil Leakage ",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}else
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
				util.addValue(row, col++, " No Abnormal Sound ",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			
			util.addValue(row, col++, data.getWinderDrum2Col3Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			//
			
			if(data.getWinderDrum2Col4() != null)
			{
				util.addValue(row, col++, data.getWinderDrum2Col4(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			
			util.addValue(row, col++, data.getWinderDrum2Col4Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);

			
			
			if(data.isWinderDrum2Col5() == true)
			{
				util.addValue(row, col++, "Abnormal Sound",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isWinderDrum2Col5() == false) 
			{
				util.addValue(row, col++, " No Abnormal Sound ",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			
			util.addValue(row, col++, data.getWinderDrum2Col5Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			
			
			
			/*if(data.isWinderDrum2Col6() == true)
			{
				util.addValue(row, col++, "OverHeating",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else
			{
				util.addValue(row, col++, "No OverHeating",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			
			util.addValue(row, col++, data.getWinderDrum2Col6Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);

			
			
			if(data.isWinderDrum2Col7() == true)
			{
				util.addValue(row, col++, "Abnormal Sound",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else
			{
				util.addValue(row, col++, "No Abnormal Sound",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			
			util.addValue(row, col++, data.getWinderDrum2Col7Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);*/
			
			
			
			if(data.isRollEjectorCol1() == true)
			{
				util.addValue(row, col++, "OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isRollEjectorCol1() == false) 
			{
				util.addValue(row, col++, "Not Ok ",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}else
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
				util.addValue(row, col++, " Not Ok ",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			
			util.addValue(row, col++, data.getRollEjectorCol2Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			/***
			if(data.isRollEjectorCol3() == true)
			{
				util.addValue(row, col++, "OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isRollEjectorCol3() == false) 
			{
				util.addValue(row, col++, " Not OK ",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}else
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
				util.addValue(row, col++, " No OverHeating ",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}else
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
				util.addValue(row, col++, " No Oil Leakage ",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}else
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
				util.addValue(row, col++, " No Abnormal Sound ",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			
			util.addValue(row, col++, data.getRiderRollCol3Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			***/
			
			
			if(data.getRiderRollCol4() != null)
			{
				util.addValue(row, col++, data.getRiderRollCol4(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}else
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
				util.addValue(row, col++, " No Abnormal Sound ",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}else
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
				util.addValue(row, col++, " Not Ok ",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			
			util.addValue(row, col++, data.getRiderRollCol6Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			/***
			if(data.isRiderRollCol7() == true)
			{
				util.addValue(row, col++, "OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isRiderRollCol7() == false) 
			{
				util.addValue(row, col++, " Not Ok ",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			
			util.addValue(row, col++, data.getRiderRollCol7Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			***/
			if(data.isRiderRollCol8() == true)
			{
				util.addValue(row, col++, "OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isRiderRollCol8() == false) 
			{
				util.addValue(row, col++, " Not Ok ",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			
			util.addValue(row, col++, data.getRiderRollCol8Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			
			
			if(data.getBowedRollCol1() != null)
			{
				util.addValue(row, col++, data.getBowedRollCol1(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}else
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
				util.addValue(row, col++, " No Abnormal Sound ",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}else
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
				util.addValue(row, col++, " Not ok",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}else
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
				util.addValue(row, col++, " Not ok ",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			
			util.addValue(row, col++, data.getCoreChucksCol1Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			/****
			
			if(data.isCoreChucksCol2() == true)
			{
				util.addValue(row, col++, "OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isCoreChucksCol2() == false) 
			{
				util.addValue(row, col++, " Not ok ",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}else
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
				util.addValue(row, col++, " Not Ok",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}else
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
				util.addValue(row, col++, " No Oil Leakage ",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			
			util.addValue(row, col++, data.getCoreChucksCol4Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			 
			***/
			if(data.isNipGuardCol1() == true)
			{
				util.addValue(row, col++, "OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isNipGuardCol1() == false) 
			{
				util.addValue(row, col++, " Not Ok ",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			
			util.addValue(row, col++, data.getNipGuardCol1Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			/***
			if(data.isNipGuardCol2() == true)
			{
				util.addValue(row, col++, "OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isNipGuardCol2() == false) 
			{
				util.addValue(row, col++, " Not Ok ",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}else
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
				util.addValue(row, col++, " No Oil Leakage ",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			
			util.addValue(row, col++, data.getNipGuardCol3Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			***/
			
			if(data.isTableLeftGateCol1() == true)
			{
				util.addValue(row, col++, "OK",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isTableLeftGateCol1() == false) 
			{
				util.addValue(row, col++, " Not Ok ",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}else
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
				util.addValue(row, col++, " Not Ok ",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			
			util.addValue(row, col++, data.getTableLeftGateCol2Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			 
			
			row++;
		}
		col = 0;
		
		util.addValue(row+2, col++, "OBCC Completed = "+l+"%",Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeight);
		
		
		util.write(outputStream);
	
	}
	
	
public void getExcelReportForMachineTenderDay(List<MachineTender> operatordata, File file, ServletOutputStream outputStream,long l) throws IOException {
		
		Workbook2007Util util = new Workbook2007Util(file,0);
	 	 	
		util.setSheetName("Day Machine Tender", 0);
		 
		
		 
		
		short rowHeight = 280;
		int row=3;
		int col=0;
	
	
		for(MachineTender data:operatordata){
			col =0;
			 if(data.isMachinedown())
				   util.addValue(row, col++, "YES", Workbook2007Util.Style.STYLE_NORMAL_CENTER_RED, rowHeight);
			   else
				   util.addValue(row, col++,"NO", Workbook2007Util.Style.STYLE_NORMAL_CENTER_GREEN, rowHeight); 
			
			 	util.addValue(row, col++, data.getEdate(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_GREEN, rowHeight);
				util.addValue(row, col++, CommonUtil.capitalizeFirstLetter(data.getPosition()), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
				util.addValue(row, col++, CommonUtil.capitalizeFirstLetter(data.getShift()), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
				util.addValue(row, col++, data.getCrew(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
		 		 
				  
				
				util.addValue(row, col++, data.getFormingSectionCol1(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);	
				util.addValue(row, col++, data.getFormingSectionCol1Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				
				util.addValue(row, col++, data.getFormingSectionCol2(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);	
				util.addValue(row, col++, data.getFormingSectionCol2Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				util.addValue(row, col++, data.getFormingSectionCol3(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);	
				util.addValue(row, col++, data.getFormingSectionCol3Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				util.addValue(row, col++, data.getFormingSectionCol4(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);	
				util.addValue(row, col++, data.getFormingSectionCol4Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				util.addValue(row, col++, data.getFormingSectionCol5(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);	
				util.addValue(row, col++, data.getFormingSectionCol5Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				util.addValue(row, col++, data.getFormingSectionCol6(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);	
				util.addValue(row, col++, data.getFormingSectionCol6Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				util.addValue(row, col++, data.getFormingSectionCol7(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);	
				util.addValue(row, col++, data.getFormingSectionCol7Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				util.addValue(row, col++, data.getFormingSectionCol8(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);	
				util.addValue(row, col++, data.getFormingSectionCol8Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				util.addValue(row, col++, data.getFormingSectionCol9(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);	
				util.addValue(row, col++, data.getFormingSectionCol9Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				util.addValue(row, col++, data.getFormingSectionCol10(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);	
				util.addValue(row, col++, data.getFormingSectionCol10Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				util.addValue(row, col++, data.getFormingSectionCol11(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);	
				util.addValue(row, col++, data.getFormingSectionCol11Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				util.addValue(row, col++, data.getFormingSectionCol12(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);	
				util.addValue(row, col++, data.getFormingSectionCol12Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				 
				
				
				
				if(data.isFormingSectionCol13() == true)
				{
					util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
				}
				else if(data.isFormingSectionCol13() == false) 
				{
					util.addValue(row, col++, " No ",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}else
				{
					util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}
				
				util.addValue(row, col++, data.getFormingSectionCol13Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				if(data.isFormingSectionCol14() == true)
				{
					util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
				}
				else if(data.isFormingSectionCol14() == false) 
				{
					util.addValue(row, col++, " No ",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}else
				{
					util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}
				
				util.addValue(row, col++, data.getFormingSectionCol14Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				//section
				
				util.addValue(row, col++, data.getSuctionPressureRollCol1(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);	
				util.addValue(row, col++, data.getSuctionPressureRollCol1Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				util.addValue(row, col++, data.getSuctionPressureRollCol2(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);	
				util.addValue(row, col++, data.getSuctionPressureRollCol2Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				util.addValue(row, col++, data.getSuctionPressureRollCol3(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);	
				util.addValue(row, col++, data.getSuctionPressureRollCol3Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getSuctionPressureRollCol4(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);	
				util.addValue(row, col++, data.getSuctionPressureRollCol4Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getSuctionPressureRollCol5(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);	
				util.addValue(row, col++, data.getSuctionPressureRollCol5Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getSuctionPressureRollCol6(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);	
				util.addValue(row, col++, data.getSuctionPressureRollCol6Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				 
				
				if(data.isSuctionPressureRollCol7() == true)
				{
					util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
				}
				else if(data.isSuctionPressureRollCol7() == false) 
				{
					util.addValue(row, col++, " No ",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}else
				{
					util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}
				
				util.addValue(row, col++, data.getSuctionPressureRollCol7Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				//yankee dryer
				
				
				util.addValue(row, col++, data.getYankeeDryerCol1(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);	
				util.addValue(row, col++, data.getYankeeDryerCol1Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				util.addValue(row, col++, data.getYankeeDryerCol2(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);	
				util.addValue(row, col++, data.getYankeeDryerCol2Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				
				if(data.isYankeeDryerCol3() == true)
				{
					util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
				}
				else if(data.isYankeeDryerCol3() == false) 
				{
					util.addValue(row, col++, " No ",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}else
				{
					util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}
				
				util.addValue(row, col++, data.getYankeeDryerCol3Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				util.addValue(row, col++, data.getYankeeDryerCol4(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);	
				util.addValue(row, col++, data.getYankeeDryerCol4Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				
				if(data.isYankeeDryerCol5() == true)
				{
					util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
				}
				else if(data.isYankeeDryerCol5() == false) 
				{
					util.addValue(row, col++, " No ",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}else
				{
					util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}
				util.addValue(row, col++, data.getYankeeDryerCol5Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				//Drive Roll
				
				
				
				util.addValue(row, col++, data.getDriveRollCol1(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);	
				util.addValue(row, col++, data.getDriveRollCol1Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				util.addValue(row, col++, data.getDriveRollCol2(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);	
				util.addValue(row, col++, data.getDriveRollCol2Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getDriveRollCol3(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);	
				util.addValue(row, col++, data.getDriveRollCol3Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getDriveRollCol4(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);	
				util.addValue(row, col++, data.getDriveRollCol4Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getDriveRollCol5(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);	
				util.addValue(row, col++, data.getDriveRollCol5Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getDriveRollCol6(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);	
				util.addValue(row, col++, data.getDriveRollCol6Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getDriveRollCol7(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);	
				util.addValue(row, col++, data.getDriveRollCol7Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				
				//press Section
				
				util.addValue(row, col++, data.getPressSectionCol1(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);	
				util.addValue(row, col++, data.getPressSectionCol1Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				util.addValue(row, col++, data.getPressSectionCol2(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);	
				util.addValue(row, col++, data.getPressSectionCol2Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getPressSectionCol3(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);	
				util.addValue(row, col++, data.getPressSectionCol3Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getPressSectionCol4(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);	
				util.addValue(row, col++, data.getPressSectionCol4Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getPressSectionCol5(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);	
				util.addValue(row, col++, data.getPressSectionCol5Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				 
				

				if(data.isPressSectionCol6() == true)
				{
					util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
				}
				else if(data.isPressSectionCol6() == false) 
				{
					util.addValue(row, col++, " No ",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}else
				{
					util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}
				util.addValue(row, col++, data.getPressSectionCol6Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				util.addValue(row, col++, data.getPressSectionCol7(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);	
				util.addValue(row, col++, data.getPressSectionCol7Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				if(data.isPressSectionCol8() == true)
				{
					util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
				}
				else if(data.isPressSectionCol8() == false) 
				{
					util.addValue(row, col++, " No ",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}else
				{
					util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}
				util.addValue(row, col++, data.getPressSectionCol8Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight); 
				
				//upper presss
				/**
				util.addValue(row, col++, data.getUpperPressCol1(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);	
				util.addValue(row, col++, data.getUpperPressCol1Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				***/
				util.addValue(row, col++, data.getUpperPressCol2(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);	
				util.addValue(row, col++, data.getUpperPressCol2Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				/****
				if(data.isUpperPressCol3() == true)
				{
					util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
				}
				else if(data.isUpperPressCol3() == false) 
				{
					util.addValue(row, col++, " No ",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}else
				{
					util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}
				util.addValue(row, col++, data.getUpperPressCol3Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight); 
				***/
				if(data.isUpperPressCol4() == true)
				{
					util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
				}
				else if(data.isUpperPressCol4() == false) 
				{
					util.addValue(row, col++, " No ",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}else
				{
					util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}
				util.addValue(row, col++, data.getUpperPressCol4Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight); 
				
				if(data.isUpperPressCol5() == true)
				{
					util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
				}
				else if(data.isUpperPressCol5() == false) 
				{
					util.addValue(row, col++, " No ",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}else
				{
					util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}
				util.addValue(row, col++, data.getUpperPressCol5Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight); 
				
				if(data.isUpperPressCol6() == true)
				{
					util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
				}
				else if(data.isUpperPressCol6() == false) 
				{
					util.addValue(row, col++, " No ",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}else
				{
					util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}
				util.addValue(row, col++, data.getUpperPressCol6Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight); 
				


				if(data.isUpperPressCol7() == true)
				{
					util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
				}
				else if(data.isUpperPressCol7() == false) 
				{
					util.addValue(row, col++, " No ",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}else
				{
					util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}
				util.addValue(row, col++, data.getUpperPressCol7Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight); 
				
				if(data.isUpperPressCol8() == true)
				{
					util.addValue(row, col++, "On",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
				}
				else if(data.isUpperPressCol8() == false) 
				{
					util.addValue(row, col++, " No ",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}else
				{
					util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}
				util.addValue(row, col++, data.getUpperPressCol8Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight); 
				
				if(data.getUpperPressCol9() !=null)
				{
					util.addValue(row, col++, data.getUpperPressCol9(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
				}
				else
				{
					util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}
				util.addValue(row, col++, data.getUpperPressCol9Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight); 
				
				//chemical
				
				/***
				
				util.addValue(row, col++, data.getChemicalTotesCol1(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);	
				util.addValue(row, col++, data.getChemicalTotesCol1Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				util.addValue(row, col++, data.getChemicalTotesCol2(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);	
				util.addValue(row, col++, data.getChemicalTotesCol2Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				util.addValue(row, col++, data.getChemicalTotesCol3(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);	
				util.addValue(row, col++, data.getChemicalTotesCol3Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				util.addValue(row, col++, data.getChemicalTotesCol4(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);	
				util.addValue(row, col++, data.getChemicalTotesCol4Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
				util.addValue(row, col++, data.getChemicalTotesCol5(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);	
				util.addValue(row, col++, data.getChemicalTotesCol5Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				***/
				//last shift Desc
				
				
				
				
				if(data.isFillupcentcol1() == true)
				{
					util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
				}
				else if(data.isFillupcentcol1() == false) 
				{
					util.addValue(row, col++, " No ",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}else
				{
					util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}
				util.addValue(row, col++, data.getFillupcentcol1Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				/***
				if(data.isFillupcentcol2() == true)
				{
					util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
				}
				else if(data.isFillupcentcol2() == false) 
				{
					util.addValue(row, col++, " No ",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}else
				{
					util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}
				util.addValue(row, col++, data.getFillupcentcol2Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				
				if(data.isFillupcentcol3() == true)
				{
					util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
				}
				else if(data.isFillupcentcol3() == false) 
				{
					util.addValue(row, col++, " No ",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}else
				{
					util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}
				util.addValue(row, col++, data.getFillupcentcol3Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				****/
				
				if(data.isFillupcentcol4() == true)
				{
					util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
				}
				else if(data.isFillupcentcol4() == false) 
				{
					util.addValue(row, col++, " No ",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}else
				{
					util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}
				util.addValue(row, col++, data.getFillupcentcol4Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
			 
				
				if(data.isFillupcentcol3() == true)
				{
					util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
				}
				else if(data.isFillupcentcol3() == false) 
				{
					util.addValue(row, col++, " No ",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}else
				{
					util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}
				util.addValue(row, col++, data.getFillupcentcol5Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				/***
				util.addValue(row, col++, data.getFillupcentcol6(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);	
				util.addValue(row, col++, data.getFillupcentcol6Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				util.addValue(row, col++, data.getFillupcentcol7(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);	
				util.addValue(row, col++, data.getFillupcentcol7Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
			 
				****/
			 
			row++;
			
			
		}
		col = 0;
		util.addValue(row+2, col++, "OBCC Completed = "+l+"%",Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeight);
		util.write(outputStream);
	 	
	   
 }


public void getExcelReportForMachineTenderNight(List<MachineTender> operatordata, File file, ServletOutputStream outputStream,long l) throws IOException {
	
	Workbook2007Util util = new Workbook2007Util(file,0);
 	 	
	util.setSheetName("Night Machine Tender", 0);
	 
	
	 
	
	short rowHeight = 280;
	int row=3;
	int col=0;


	for(MachineTender data:operatordata){
		col =0;
		 if(data.isMachinedown())
			   util.addValue(row, col++, "YES", Workbook2007Util.Style.STYLE_NORMAL_CENTER_RED, rowHeight);
		   else
			   util.addValue(row, col++,"NO", Workbook2007Util.Style.STYLE_NORMAL_CENTER_GREEN, rowHeight); 
		 	util.addValue(row, col++, data.getEdate(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_GREEN, rowHeight);
			util.addValue(row, col++, CommonUtil.capitalizeFirstLetter(data.getPosition()), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.capitalizeFirstLetter(data.getShift()), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, data.getCrew(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
	 		 
	 	 
			
			
			util.addValue(row, col++, data.getFanPumpCol1(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getFanPumpCol1Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			
			if(data.isFanPumpCol2() == true)
			{
				util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isFanPumpCol2() == false) 
			{
				util.addValue(row, col++, " No ",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			util.addValue(row, col++, data.getFanPumpCol2Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight); 
			
		
			util.addValue(row, col++, data.getFanPumpCol3Inbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getFanPumpCol3Outbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getFanPumpCol3Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			
			
			util.addValue(row, col++, data.getFanPumpCol4Inbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getFanPumpCol4Outbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getFanPumpCol4Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			
			
			util.addValue(row, col++, data.getSelectifierScreenCol1(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getSelectifierScreenCol1Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			util.addValue(row, col++, data.getSelectifierScreenCol2(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getSelectifierScreenCol2Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			/***
			util.addValue(row, col++, data.getSelectifierScreenCol3(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getSelectifierScreenCol3Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			***/
			

			util.addValue(row, col++, data.getSelectifierScreenCol4Inbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getSelectifierScreenCol4Outbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getSelectifierScreenCol4Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			/***
			util.addValue(row, col++, data.getSelectifierScreenCol5(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getSelectifierScreenCol5Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			***/
			
			util.addValue(row, col++, data.getSelectifierScreenCol6Inbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getSelectifierScreenCol6Outbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getSelectifierScreenCol6Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			
			
			util.addValue(row, col++, data.getSelectifierScreenCol7(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getSelectifierScreenCol7Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			
			/***
			
			if(data.isSelectifierScreenCol8() == true)
			{
				util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isSelectifierScreenCol8() == false) 
			{
				util.addValue(row, col++, " No ",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			util.addValue(row, col++, data.getSelectifierScreenCol8Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight); 
			
			
			
			util.addValue(row, col++, data.getSelectifierScreenCol9Inbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getSelectifierScreenCol9Outbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getSelectifierScreenCol9Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			if(data.isSelectifierScreenCol10() == true)
			{
				util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isSelectifierScreenCol10() == false) 
			{
				util.addValue(row, col++, " No ",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			util.addValue(row, col++, data.getSelectifierScreenCol10Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight); 
			 
			
			util.addValue(row, col++, data.getSelectifierScreenCol11Inbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getSelectifierScreenCol11Outbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getSelectifierScreenCol11Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			
		
			

			if(data.isVacumePumpCol1() == true)
			{
				util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isVacumePumpCol1() == false) 
			{
				util.addValue(row, col++, " No ",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			util.addValue(row, col++, data.getVacumePumpCol1Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight); 
			
			
			if(data.isVacumePumpCol2() == true)
			{
				util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isVacumePumpCol2() == false) 
			{
				util.addValue(row, col++, " No ",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			util.addValue(row, col++, data.getVacumePumpCol2Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight); 
			 
			****/
			
			if(data.isVacumePumpCol3() == true)
			{
				util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isVacumePumpCol3() == false) 
			{
				util.addValue(row, col++, " No ",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			util.addValue(row, col++, data.getVacumePumpCol3Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			 
			
			
			util.addValue(row, col++, data.getVacumePumpCol4Inbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getVacumePumpCol4Outbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getVacumePumpCol4Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			
			util.addValue(row, col++, data.getVacumePumpCol5Inbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getVacumePumpCol5Outbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getVacumePumpCol5Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			
			/****

			if(data.isVacumePumpCol6() == true)
			{
				util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isVacumePumpCol6() == false) 
			{
				util.addValue(row, col++, " No ",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			util.addValue(row, col++, data.getVacumePumpCol6Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight); 
			***/
			
			util.addValue(row, col++, data.getVacumePumpCol7Inbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getVacumePumpCol7Outbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getVacumePumpCol7Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			
			if(data.isVacumePumpCol8() == true)
			{
				util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isVacumePumpCol8() == false) 
			{
				util.addValue(row, col++, " No ",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			util.addValue(row, col++, data.getVacumePumpCol8Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			 
			util.addValue(row, col++, data.getVacumePumpCol9(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getVacumePumpCol9Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			
			util.addValue(row, col++, data.getVacumePumpCol10(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getVacumePumpCol10Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			
			
			if(data.isVacumePumpCol11() == true)
			{
				util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isVacumePumpCol11() == false) 
			{
				util.addValue(row, col++, " No ",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			util.addValue(row, col++, data.getVacumePumpCol11Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			 
			util.addValue(row, col++, data.getVacumePumpCol12(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getVacumePumpCol12Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			 
			util.addValue(row, col++, data.getVacumePumpCol13(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getVacumePumpCol13Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			/***
			if(data.isVacumePumpCol14() == true)
			{
				util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isVacumePumpCol14() == false) 
			{
				util.addValue(row, col++, " No ",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			util.addValue(row, col++, data.getVacumePumpCol14Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight); 
			***/
			
			util.addValue(row, col++, data.getVacumePumpCol15Inbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getVacumePumpCol15Outbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getVacumePumpCol15Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			
			
			if(data.isVacumePumpCol16() == true)
			{
				util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isVacumePumpCol16() == false) 
			{
				util.addValue(row, col++, " No ",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			util.addValue(row, col++, data.getVacumePumpCol16Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			 
			
			util.addValue(row, col++, data.getVacumePumpCol17(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getVacumePumpCol17Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			
			util.addValue(row, col++, data.getVacumePumpCol18(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getVacumePumpCol18Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			
			
			if(data.isVacumePumpCol19() == true)
			{
				util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isVacumePumpCol19() == false) 
			{
				util.addValue(row, col++, " No ",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			util.addValue(row, col++, data.getVacumePumpCol19Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			 
			util.addValue(row, col++, data.getVacumePumpCol20(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getVacumePumpCol20Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			 
			util.addValue(row, col++, data.getVacumePumpCol21(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getVacumePumpCol21Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			
			
			if(data.isVacumePumpCol22() == true)
			{
				util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isVacumePumpCol22() == false) 
			{
				util.addValue(row, col++, " No ",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			util.addValue(row, col++, data.getVacumePumpCol22Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			 
			
			util.addValue(row, col++, data.getVacumePumpCol23(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getVacumePumpCol23Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			
			util.addValue(row, col++, data.getVacumePumpCol24(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getVacumePumpCol24Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			
			
			if(data.isVacumePumpCol25() == true)
			{
				util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isVacumePumpCol25() == false) 
			{
				util.addValue(row, col++, " No ",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			util.addValue(row, col++, data.getVacumePumpCol25Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			 
			util.addValue(row, col++, data.getVacumePumpCol26(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getVacumePumpCol26Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			util.addValue(row, col++, data.getVacumePumpCol27(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getVacumePumpCol27Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			
			if(data.isVacumePumpCol28() == true)
			{
				util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isVacumePumpCol28() == false) 
			{
				util.addValue(row, col++, " No ",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			util.addValue(row, col++, data.getVacumePumpCol28Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			 
			
			util.addValue(row, col++, data.getVacumePumpCol29(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getVacumePumpCol29Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			util.addValue(row, col++, data.getVacumePumpCol30(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getVacumePumpCol30Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			
			if(data.isVacumePumpCol31() == true)
			{
				util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isVacumePumpCol31() == false) 
			{
				util.addValue(row, col++, " No ",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			util.addValue(row, col++, data.getVacumePumpCol31Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			 
			util.addValue(row, col++, data.getVacumePumpCol32(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getVacumePumpCol32Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			util.addValue(row, col++, data.getVacumePumpCol33(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getVacumePumpCol33Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			
			if(data.isVacumePumpCol34() == true)
			{
				util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isVacumePumpCol34() == false) 
			{
				util.addValue(row, col++, " No ",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			util.addValue(row, col++, data.getVacumePumpCol34Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			 
			util.addValue(row, col++, data.getVacumePumpCol35(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getVacumePumpCol35Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			
			util.addValue(row, col++, data.getVacumePumpCol36(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getVacumePumpCol36Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			
			util.addValue(row, col++, data.getRiverWaterCol1(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getRiverWaterCol1Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			util.addValue(row, col++, data.getRiverWaterCol2(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getRiverWaterCol2Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			/***
			if(data.isShowercol1() == true)
			{
				util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isShowercol1() == false) 
			{
				util.addValue(row, col++, " No ",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			util.addValue(row, col++, data.getShowercol1Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight); 
			
			***/
			
			util.addValue(row, col++, data.getShowercol2North(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getShowercol2South(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getShowercol2Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			/***
			if(data.isShowercol3() == true)
			{
				util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isShowercol3() == false) 
			{
				util.addValue(row, col++, " No ",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			util.addValue(row, col++, data.getShowercol3Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight); 
			***/
			util.addValue(row, col++, data.getShowercol4North(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getShowercol4South(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getShowercol4Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			/***
			
			if(data.isShowercol5() == true)
			{
				util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isShowercol5() == false) 
			{
				util.addValue(row, col++, " No ",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			util.addValue(row, col++, data.getShowercol5Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight); 
			***/
			
			util.addValue(row, col++, data.getShowercol6North(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getShowercol6South(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getShowercol6Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			
			util.addValue(row, col++, data.getShowercol7(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getShowercol7Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			
			
			
			if(data.isFillupcentcol1() == true)
			{
				util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isFillupcentcol1() == false) 
			{
				util.addValue(row, col++, " No ",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			util.addValue(row, col++, data.getFillupcentcol1Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			
			/****
			if(data.isFillupcentcol2() == true)
			{
				util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isFillupcentcol2() == false) 
			{
				util.addValue(row, col++, " No ",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			util.addValue(row, col++, data.getFillupcentcol2Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			
			
			
			if(data.isFillupcentcol3() == true)
			{
				util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isFillupcentcol3() == false) 
			{
				util.addValue(row, col++, " No ",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			util.addValue(row, col++, data.getFillupcentcol3Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			
			if(data.isFillupcentcol4() == true)
			{
				util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isFillupcentcol4() == false) 
			{
				util.addValue(row, col++, " No ",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			util.addValue(row, col++, data.getFillupcentcol4Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			
			if(data.isFillupcentcol8() == true)
			{
				util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isFillupcentcol8() == false) 
			{
				util.addValue(row, col++, " No ",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			util.addValue(row, col++, data.getFillupcentcol8Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
		 
		***/
		row++;
		
		
	}
	col = 0;
	util.addValue(row+2, col++, "OBCC Completed = "+l+"%",Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeight);
	util.write(outputStream);
 	
   
}



public void getExcelReportForStockOperatorDay(List<StockOperator> operatordata, File file, ServletOutputStream outputStream,long l) throws IOException {
	
	Workbook2007Util util = new Workbook2007Util(file,0);
 	 	
	util.setSheetName("Day Stock Operator", 0);
	 
	
	 
	
	short rowHeight = 280;
	int row=3;
	int col=0;


	for(StockOperator data:operatordata){
		col =0;
	 	
		   if(data.isMachinedown())
			   util.addValue(row, col++, "YES", Workbook2007Util.Style.STYLE_NORMAL_CENTER_RED, rowHeight);
		   else
			   util.addValue(row, col++,"NO", Workbook2007Util.Style.STYLE_NORMAL_CENTER_GREEN, rowHeight); 
		   
		 	util.addValue(row, col++, data.getEdate(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_GREEN, rowHeight);
			util.addValue(row, col++, CommonUtil.capitalizeFirstLetter(data.getPosition()), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.capitalizeFirstLetter(data.getShift()), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, data.getCrew(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
	 		 
			/******
			
			if(data.isHdStorageChestCol1() == true)
			{
				util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isHdStorageChestCol1() == false) 
			{
				util.addValue(row, col++, " No ",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			util.addValue(row, col++, data.getHdStorageChestCol1Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight); 
			
			***/
			
			util.addValue(row, col++, data.getHdStorageChestCol2Inbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getHdStorageChestCol2Outbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getHdStorageChestCol2Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			/****
			
			if(data.isHdStorageChestCol3() == true)
			{
				util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isHdStorageChestCol3() == false) 
			{
				util.addValue(row, col++, " No ",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			util.addValue(row, col++, data.getHdStorageChestCol3Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight); 
			
			***/
			
			util.addValue(row, col++, data.getHdStorageChestCol4Inbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getHdStorageChestCol4Outbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getHdStorageChestCol4Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			/********
			if(data.isHdStorageChestCol5() == true)
			{
				util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isHdStorageChestCol5() == false) 
			{
				util.addValue(row, col++, " No ",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			util.addValue(row, col++, data.getHdStorageChestCol5Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight); 
			
			***/
			
			util.addValue(row, col++, data.getHdStorageChestCol6Inbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getHdStorageChestCol6Outbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getHdStorageChestCol6Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			/*******
			if(data.isHdStorageChestCol7() == true)
			{
				util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isHdStorageChestCol7() == false) 
			{
				util.addValue(row, col++, " No ",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			util.addValue(row, col++, data.getHdStorageChestCol7Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight); 
			

****/
			util.addValue(row, col++, data.getHdStorageChestCol8Inbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getHdStorageChestCol8Outbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getHdStorageChestCol8Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			/*********
			if(data.isBlendChestCol1() == true)
			{
				util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isBlendChestCol1() == false) 
			{
				util.addValue(row, col++, " No ",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			util.addValue(row, col++, data.getBlendChestCol1Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			***/
			util.addValue(row, col++, data.getBlendChestCol2Inbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getBlendChestCol2Outbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getBlendChestCol2Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			/*****
			if(data.isBlendChestCol3() == true)
			{
				util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isBlendChestCol3() == false) 
			{
				util.addValue(row, col++, " No ",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			util.addValue(row, col++, data.getBlendChestCol3Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			****/
			util.addValue(row, col++, data.getBlendChestCol4Inbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getBlendChestCol4Outbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getBlendChestCol4Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			/*******
			if(data.isSeeScreenFeedTandCol1()  == true)
			{
				util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isSeeScreenFeedTandCol1() == false) 
			{
				util.addValue(row, col++, " No ",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			util.addValue(row, col++, data.getSeeScreenFeedTandCol1Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			**/
			util.addValue(row, col++, data.getSeeScreenFeedTandCol2Inbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getSeeScreenFeedTandcol2Outbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getSeeScreenFeedTandCol2Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			
			/****
			if(data.isSeeScreenFeedTandCol3()  == true)
			{
				util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isSeeScreenFeedTandCol3() == false) 
			{
				util.addValue(row, col++, " No ",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			util.addValue(row, col++, data.getSeeScreenFeedTandCol3Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			***/
			
			util.addValue(row, col++, data.getSeeScreenFeedTandCol4Inbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getSeeScreenFeedTandcol4Outbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getSeeScreenFeedTandCol4Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			/***
			
			if(data.isMachineChestCol1()  == true)
			{
				util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isMachineChestCol1() == false) 
			{
				util.addValue(row, col++, " No ",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			util.addValue(row, col++, data.getMachineChestCol1Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			***/
			util.addValue(row, col++, data.getMachineChestCol2Inbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getMachineChestCol2Outbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getMachineChestCol2Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
		 
			/****
			if(data.isMachineChestCol3()  == true)
			{
				util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isMachineChestCol3() == false) 
			{
				util.addValue(row, col++, " No ",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			util.addValue(row, col++, data.getMachineChestCol3Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			***/
			
			util.addValue(row, col++, data.getMachineChestCol4Inbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getMachineChestCol4Outbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getMachineChestCol4Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			/****
			if(data.isMachineChestCol5()  == true)
			{
				util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isMachineChestCol5() == false) 
			{
				util.addValue(row, col++, " No ",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			util.addValue(row, col++, data.getMachineChestCol5Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			***/
			
			util.addValue(row, col++, data.getMachineChestCol6Inbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getMachineChestCol6Outbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getMachineChestCol6Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			
			/****
			
			if(data.isCleannersCol1()  == true)
			{
				util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isCleannersCol1() == false) 
			{
				util.addValue(row, col++, " No ",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			util.addValue(row, col++, data.getCleannersCol1Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			***/
			if(data.isCleannersCol2()  == true)
			{
				util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isCleannersCol2() == false) 
			{
				util.addValue(row, col++, " No ",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			util.addValue(row, col++, data.getCleannersCol2Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			util.addValue(row, col++, data.getCleannersCol3Inbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getCleannersCol3Outbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getCleannersCol3Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			/****
			if(data.isDeLinkStockCol1()  == true)
			{
				util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isDeLinkStockCol1() == false) 
			{
				util.addValue(row, col++, " No ",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			util.addValue(row, col++, data.getDeLinkStockCol1Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			****/
			util.addValue(row, col++, data.getDeLinkStockCol2Inbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getDeLinkStockCol2Outbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getDeLinkStockCol2Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			
			
			if(data.isWhiteWaterCol1()  == true)
			{
				util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isWhiteWaterCol1() == false) 
			{
				util.addValue(row, col++, " No ",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			util.addValue(row, col++, data.getWhiteWaterCol1Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			util.addValue(row, col++, data.getWhiteWaterCol2Inbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getWhiteWaterCol2Outbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getWhiteWaterCol2Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			
			if(data.isWhiteWaterCol3()  == true)
			{
				util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isWhiteWaterCol3() == false) 
			{
				util.addValue(row, col++, " No ",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			util.addValue(row, col++, data.getWhiteWaterCol3Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			util.addValue(row, col++, data.getWhiteWaterCol4Inbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getWhiteWaterCol4Outbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getWhiteWaterCol4Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			
			
			if(data.isWhiteWaterCol5()  == true)
			{
				util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isWhiteWaterCol5() == false) 
			{
				util.addValue(row, col++, " No ",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			util.addValue(row, col++, data.getWhiteWaterCol5Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			util.addValue(row, col++, data.getWhiteWaterCol6Inbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getWhiteWaterCol6Outbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getWhiteWaterCol6Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			
			if(data.isWhiteWaterCol7()  == true)
			{
				util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isWhiteWaterCol7() == false) 
			{
				util.addValue(row, col++, " No ",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			util.addValue(row, col++, data.getWhiteWaterCol7Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			util.addValue(row, col++, data.getWhiteWaterCol8Inbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getWhiteWaterCol8Outbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getWhiteWaterCol8Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			/***
			if(data.isCouchPitCol1()  == true)
			{
				util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isCouchPitCol1() == false) 
			{
				util.addValue(row, col++, " No ",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			util.addValue(row, col++, data.getCouchPitCol1Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			**/
			if(data.isCouchPitCol2()  == true)
			{
				util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isCouchPitCol2() == false) 
			{
				util.addValue(row, col++, " No ",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			util.addValue(row, col++, data.getCouchPitCol2Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			
			util.addValue(row, col++, data.getCouchPitCol3Inbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getCouchPitCol3Outbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getCouchPitCol3Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			
			if(data.isCouchPitCol4()  == true)
			{
				util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isCouchPitCol4() == false) 
			{
				util.addValue(row, col++, " No ",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			util.addValue(row, col++, data.getCouchPitCol4Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			
			util.addValue(row, col++, data.getCouchPitCol5Inbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getCouchPitCol5Outbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getCouchPitCol5Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			/*****
			if(data.isCouchPitCol6()  == true)
			{
				util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isCouchPitCol6() == false) 
			{
				util.addValue(row, col++, " No ",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			util.addValue(row, col++, data.getCouchPitCol6Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			
			util.addValue(row, col++, data.getCouchPitCol7Inbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getCouchPitCol7Outbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getCouchPitCol7Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			util.addValue(row, col++, data.getCouchPitCol8Inbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getCouchPitCol8Outbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getCouchPitCol8Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			
			
			if(data.isCouchPitCol9()  == true)
			{
				util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isCouchPitCol9() == false) 
			{
				util.addValue(row, col++, " No ",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			util.addValue(row, col++, data.getCouchPitCol9Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			 ****/
			util.addValue(row, col++, data.getCouchPitCol10Inbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getCouchPitCol10Outbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getCouchPitCol10Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			util.addValue(row, col++, data.getCouchPitCol11Inbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getCouchPitCol11Outbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getCouchPitCol11Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			/***
			if(data.isYankeePulperCol1()  == true)
			{
				util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isYankeePulperCol1() == false) 
			{
				util.addValue(row, col++, " No ",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			util.addValue(row, col++, data.getYankeePulperCol1Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			
			if(data.isYankeePulperCol1Drain()  == true)
			{
				util.addValue(row, col++, "Open",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isYankeePulperCol1Drain() == false) 
			{
				util.addValue(row, col++, " No ",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			util.addValue(row, col++, data.getYankeePulperCol1DrainDesc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			
			if(data.isYankeePulperCol2()  == true)
			{
				util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isYankeePulperCol2() == false) 
			{
				util.addValue(row, col++, " No ",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			util.addValue(row, col++, data.getYankeePulperCol2Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			***/
			util.addValue(row, col++, data.getYankeePulperCol3Inbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getYankeePulperCol3Outbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getYankeePulperCol3Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			
			/***
			if(data.isYankeePulperCol4()  == true)
			{
				util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isYankeePulperCol4() == false) 
			{
				util.addValue(row, col++, " No ",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			util.addValue(row, col++, data.getYankeePulperCol4Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			***/
			
			util.addValue(row, col++, data.getYankeePulperCol5Inbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getYankeePulperCol5Outbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getYankeePulperCol5Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			/***

			if(data.isYankeePulperCol6()  == true)
			{
				util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isYankeePulperCol6() == false) 
			{
				util.addValue(row, col++, " No ",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			util.addValue(row, col++, data.getYankeePulperCol6Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			***/
			
			util.addValue(row, col++, data.getYankeePulperCol7Inbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getYankeePulperCol7Outbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getYankeePulperCol7Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			/*****
			
			if(data.isYankeePulperCol8()  == true)
			{
				util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isYankeePulperCol8() == false) 
			{
				util.addValue(row, col++, " No ",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			util.addValue(row, col++, data.getYankeePulperCol8Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			
			
			util.addValue(row, col++, data.getYankeePulperCol9Inbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getYankeePulperCol9Outbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getYankeePulperCol9Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			
			util.addValue(row, col++, data.getDesccol1(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getDesccol1Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			 ***/
			

		row++;
	}
	col = 0;
	util.addValue(row+2, col++, "OBCC Completed = "+l+"%",Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeight);
	
	util.write(outputStream);
}


public void getExcelReportForStockOperatorNight(List<StockOperator> operatordata, File file, ServletOutputStream outputStream,long l) throws IOException {
	
	Workbook2007Util util = new Workbook2007Util(file,0);
 	 	
	util.setSheetName("Night Stock Operator", 0);
	 
	
	 
	
	short rowHeight = 280;
	int row=3;
	int col=0;


	for(StockOperator data:operatordata){
		col =0;
		 if(data.isMachinedown())
			   util.addValue(row, col++, "YES", Workbook2007Util.Style.STYLE_NORMAL_CENTER_RED, rowHeight);
		   else
			   util.addValue(row, col++,"NO", Workbook2007Util.Style.STYLE_NORMAL_CENTER_GREEN, rowHeight); 
		 	util.addValue(row, col++, data.getEdate(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_GREEN, rowHeight);
			util.addValue(row, col++, CommonUtil.capitalizeFirstLetter(data.getPosition()), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.capitalizeFirstLetter(data.getShift()), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, data.getCrew(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
	 		
			if(data.isBrokeDeflakerCol1() == true)
			{
				util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isBrokeDeflakerCol1() == false) 
			{
				util.addValue(row, col++, " No ",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			util.addValue(row, col++, data.getBrokeDeflakerCol1Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight); 
			
			
			util.addValue(row, col++, data.getBrokeDeflakerCol2Inbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getBrokeDeflakerCol2Outbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getBrokeDeflakerCol2Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			
			if(data.isBrokeDeflakerCol3() == true)
			{
				util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isBrokeDeflakerCol3() == false) 
			{
				util.addValue(row, col++, " No ",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			util.addValue(row, col++, data.getBrokeDeflakerCol3Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight); 
			
			
			
			
			util.addValue(row, col++, data.getRefiningSystemCol1(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getRefiningSystemCol1Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			/***
			if(data.isRefiningSystemCol2() == true)
			{
				util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isRefiningSystemCol2() == false) 
			{
				util.addValue(row, col++, " No ",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			util.addValue(row, col++, data.getRefiningSystemCol2Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight); 
			
			util.addValue(row, col++, data.getRefiningSystemCol3Inbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getRefiningSystemCol3Outbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getRefiningSystemCol3Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			***/
			util.addValue(row, col++, data.getRefiningSystemCol4(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getRefiningSystemCol4Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			util.addValue(row, col++, data.getRefiningSystemCol5(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getRefiningSystemCol5Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			/****
			util.addValue(row, col++, data.getRefiningSystemCol6(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getRefiningSystemCol6Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			
			if(data.isRefiningSystemCol7() == true)
			{
				util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isRefiningSystemCol7() == false) 
			{
				util.addValue(row, col++, " No ",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			util.addValue(row, col++, data.getRefiningSystemCol7Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight); 
			
			
			util.addValue(row, col++, data.getRefiningSystemCol8Inbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getRefiningSystemCol8Outbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getRefiningSystemCol8Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			
			util.addValue(row, col++, data.getRefiningSystemCol9(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getRefiningSystemCol9Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			util.addValue(row, col++, data.getRefiningSystemCol10(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getRefiningSystemCol10Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			
			
			
			if(data.isWhiteWaterPumpCol1() == true)
			{
				util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isWhiteWaterPumpCol1() == false) 
			{
				util.addValue(row, col++, " No ",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			util.addValue(row, col++, data.getWhiteWaterPumpCol1Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			***/
			
			util.addValue(row, col++, data.getWhiteWaterPumpCol2Inbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getWhiteWaterPumpCol2Outbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getWhiteWaterPumpCol2Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			
			/****
			
			if(data.isWhiteWaterPumpCol3() == true)
			{
				util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isWhiteWaterPumpCol3() == false) 
			{
				util.addValue(row, col++, " No ",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			util.addValue(row, col++, data.getWhiteWaterPumpCol3Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			***/
			
			
			util.addValue(row, col++, data.getWhiteWaterPumpCol4Inbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getWhiteWaterPumpCol4Outbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getWhiteWaterPumpCol4Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			
			/***
			if(data.isWhiteWaterPumpCol5() == true)
			{
				util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isWhiteWaterPumpCol5() == false) 
			{
				util.addValue(row, col++, " No ",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			util.addValue(row, col++, data.getWhiteWaterPumpCol5Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			***/
			
			util.addValue(row, col++, data.getWhiteWaterPumpCol6Inbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getWhiteWaterPumpCol6Outbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getWhiteWaterPumpCol6Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			/****
			
			util.addValue(row, col++, data.getSilloCol1(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getSilloCol1Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			
			if(data.isSilloCol2() == true)
			{
				util.addValue(row, col++, "Open",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isSilloCol2() == false) 
			{
				util.addValue(row, col++, " No ",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			util.addValue(row, col++, data.getSilloCol2Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			util.addValue(row, col++, data.getSilloCol3(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getSilloCol3Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			
			
			if(data.isYankeePumplerCol1() == true)
			{
				util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isYankeePumplerCol1() == false) 
			{
				util.addValue(row, col++, " No ",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			util.addValue(row, col++, data.getYankeePumplerCol1Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			
			if(data.isYankeePumplerCol1Drain() == true)
			{
				util.addValue(row, col++, "Open",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isYankeePumplerCol1Drain() == false) 
			{
				util.addValue(row, col++, " No ",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			util.addValue(row, col++, data.getYankeePumplerCol1DrainDesc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			
			
			if(data.isYankeePumplerCol2() == true)
			{
				util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isYankeePumplerCol2() == false) 
			{
				util.addValue(row, col++, " No ",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			util.addValue(row, col++, data.getYankeePumplerCol2Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			
			***/
			
			util.addValue(row, col++, data.getYankeePumplerCol3Inbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getYankeePumplerCol3Outbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getYankeePumplerCol3Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			/***
			
			if(data.isYankeePumplerCol4() == true)
			{
				util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isYankeePumplerCol4() == false) 
			{
				util.addValue(row, col++, " No ",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			util.addValue(row, col++, data.getYankeePumplerCol3Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			***/
			util.addValue(row, col++, data.getYankeePumplerCol5Inbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getYankeePumplerCol5Outbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getYankeePumplerCol5Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			/****
			
			if(data.isYankeePumplerCol6() == true)
			{
				util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isYankeePumplerCol6() == false) 
			{
				util.addValue(row, col++, " No ",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			util.addValue(row, col++, data.getYankeePumplerCol6Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			***/
			util.addValue(row, col++, data.getYankeePumplerCol7Inbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getYankeePumplerCol7Outbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getYankeePumplerCol7Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			/***
			
			if(data.isYankeePumplerCol8() == true)
			{
				util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isYankeePumplerCol8() == false) 
			{
				util.addValue(row, col++, " No ",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			util.addValue(row, col++, data.getYankeePumplerCol8Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			util.addValue(row, col++, data.getYankeePumplerCol9Inbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getYankeePumplerCol9Outbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getYankeePumplerCol9Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			
			
			
			
			util.addValue(row, col++, data.getBrokeSystemCol1(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getBrokeSystemCol1Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getBrokeSystemCol2(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getBrokeSystemCol2Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			****/
			
			util.addValue(row, col++, data.getBrokeSystemCol3(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getBrokeSystemCol3Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getBrokeSystemCol4(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getBrokeSystemCol4Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getBrokeSystemCol5(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getBrokeSystemCol5Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getBrokeSystemCol6(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getBrokeSystemCol6Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getBrokeSystemCol7(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getBrokeSystemCol7Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			/***
			util.addValue(row, col++, data.getBrokeSystemCol8(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getBrokeSystemCol8Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			***/
			
			util.addValue(row, col++, data.getBrokeSystemCol9(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getBrokeSystemCol9Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			/***
			util.addValue(row, col++, data.getBrokeSystemCol10(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getBrokeSystemCol10Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			***/
			util.addValue(row, col++, data.getBrokeSystemCol11(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getBrokeSystemCol11Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			
			/***
			util.addValue(row, col++, data.getSaveAllCol1(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getSaveAllCol1Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			***/
			if(data.isSaveAllCol2() == true)
			{
				util.addValue(row, col++, "Work",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else
			{
				util.addValue(row, col++, "Plug",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			util.addValue(row, col++, data.getSaveAllCol2Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			
			if(data.isSaveAllCol3() == true)
			{
				util.addValue(row, col++, "Work",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else
			{
				util.addValue(row, col++, "Plug",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			util.addValue(row, col++, data.getSaveAllCol3Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			
			
			util.addValue(row, col++, data.getSaveAllCol4Inbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getSaveAllCol4Outbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getSaveAllCol4Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			
			
			
			
			if(data.isSaveAllCol5() == true)
			{
				util.addValue(row, col++, "On",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else
			{
				util.addValue(row, col++, "Off",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			util.addValue(row, col++, data.getSaveAllCol5Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			
			
			if(data.isSaveAllCol6() == true)
			{
				util.addValue(row, col++, "On",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else
			{
				util.addValue(row, col++, "Off",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			util.addValue(row, col++, data.getSaveAllCol6Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			

/***
			
			
			if(data.isHydrapulperCol1() == true)
			{
				util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else
			{
				util.addValue(row, col++, "No",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			util.addValue(row, col++, data.getHydrapulperCol1Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			****/
			
			util.addValue(row, col++, data.getHydrapulperCol2Inbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getHydrapulperCol2outbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getHydrapulperCol2Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			/***
			if(data.isHydrapulperCol3() == true)
			{
				util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else
			{
				util.addValue(row, col++, "No",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			util.addValue(row, col++, data.getHydrapulperCol3Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			
			util.addValue(row, col++, data.getHydrapulperCol4Inbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getHydrapulperCol4outbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getHydrapulperCol4Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			

			if(data.isHydrapulperCol5() == true)
			{
				util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else
			{
				util.addValue(row, col++, "No",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			util.addValue(row, col++, data.getHydrapulperCol5Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			

			if(data.isHydrapulperCol6() == true)
			{
				util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else
			{
				util.addValue(row, col++, "No",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			util.addValue(row, col++, data.getHydrapulperCol6Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			

			if(data.isHydrapulperCol7() == true)
			{
				util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else
			{
				util.addValue(row, col++, "No",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			util.addValue(row, col++, data.getHydrapulperCol7Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			***/
			
			
			util.addValue(row, col++, data.getHydrapulperCol8Inbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getHydrapulperCol8outbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getHydrapulperCol8Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			
			/****
			
			if(data.isHydrapulperCol9() == true)
			{
				util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else
			{
				util.addValue(row, col++, "No",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			util.addValue(row, col++, data.getHydrapulperCol9Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			
			util.addValue(row, col++, data.getHydrapulperCol10Inbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getHydrapulperCol10outbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getHydrapulperCol10Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			
			
			
			if(data.isHydrapulperCol11() == true)
			{
				util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else
			{
				util.addValue(row, col++, "No",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			util.addValue(row, col++, data.getHydrapulperCol11Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			
			
			
			if(data.isHydrapulperCol12() == true)
			{
				util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else
			{
				util.addValue(row, col++, "No",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			util.addValue(row, col++, data.getHydrapulperCol12Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			
			if(data.isHydrapulperCol13() == true)
			{
				util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else
			{
				util.addValue(row, col++, "No",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			util.addValue(row, col++, data.getHydrapulperCol13Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			****/
			
			util.addValue(row, col++, data.getHydrapulperCol14Inbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getHydrapulperCol14outbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getHydrapulperCol14Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			/****
			
			if(data.isHydrapulperCol15() == true)
			{
				util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else
			{
				util.addValue(row, col++, "No",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			util.addValue(row, col++, data.getHydrapulperCol15Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			
			
			util.addValue(row, col++, data.getHydrapulperCol16Inbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getHydrapulperCol16outbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getHydrapulperCol16Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			
			util.addValue(row, col++, data.getDesccol1(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getDesccol1Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			 
			***/

			row++;
	}
	col = 0;
	util.addValue(row+2, col++, "OBCC Completed = "+l+"%",Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeight);
	
	util.write(outputStream);
}
 
	
	//Method Ends Here
	
	 
	public void getExcelReportForDayBacktender(List<BackTender> operatordata, File file, ServletOutputStream outputStream,long l) throws IOException {
	
			Workbook2007Util util = new Workbook2007Util(file,0);
			util.setSheetName("Day Backtender Operator ", 0);
			
			short rowHeight = 280;
			int row=3;
			int col=0;
			
			for(BackTender data:operatordata){
				col =0;
				 if(data.isMachinedown())
					   util.addValue(row, col++, "YES", Workbook2007Util.Style.STYLE_NORMAL_CENTER_RED, rowHeight);
				   else
					   util.addValue(row, col++,"NO", Workbook2007Util.Style.STYLE_NORMAL_CENTER_GREEN, rowHeight); 
				util.addValue(row, col++,   data.getEdate(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_GREEN, rowHeight);
				util.addValue(row, col++, CommonUtil.capitalizeFirstLetter(data.getPosition()), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
				util.addValue(row, col++, CommonUtil.capitalizeFirstLetter(data.getShift()), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
				util.addValue(row, col++, data.getCrew(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
				
				
				
				util.addValue(row, col++, data.getReelCol1(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getReelCol1Desc(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				util.addValue(row, col++, data.getReelCol2(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getReelCol2Desc(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				
				util.addValue(row, col++, data.getReelCol3Inbound(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getReelCol3Outbound(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getReelCol3Desc(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				
				if(data.isReelCol4() == true)
				{
					util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
				}
				else if(data.isReelCol4() == false) 
				{
					util.addValue(row, col++, "No",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}else
				{
					util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}
				util.addValue(row, col++, data.getReelCol4Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				
				util.addValue(row, col++, data.getReelCol5(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getReelCol5Desc(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				
				
				util.addValue(row, col++, data.getMachineLubricationCol1(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getMachineLubricationCol1Desc(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				util.addValue(row, col++, data.getMachineLubricationCol2(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getMachineLubricationCol2Desc(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				/****
				
				if(data.getMachineLubricationCol3() !=null)
				{
					util.addValue(row, col++, data.getMachineLubricationCol3(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
				}
				else
				{
					util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}
				util.addValue(row, col++, data.getMachineLubricationCol3Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				***/
				
				util.addValue(row, col++, data.getMachineLubricationCol4(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getMachineLubricationCol4Desc(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				util.addValue(row, col++, data.getMachineLubricationCol5(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getMachineLubricationCol5Desc(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				
				
				if(data.isCondensateCol1() == true)
				{
					util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
				}
				else if(data.isCondensateCol1() == false) 
				{
					util.addValue(row, col++, "No",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}else
				{
					util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}
				util.addValue(row, col++, data.getCondensateCol1Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				
				util.addValue(row, col++, data.getCondensateCol2Inbound(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getCondensateCol2Outbound(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getCondensateCol3Desc(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				
				
				if(data.isCondensateCol3() == true)
				{
					util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
				}
				else if(data.isCondensateCol3() == false) 
				{
					util.addValue(row, col++, "No",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}else
				{
					util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}
				util.addValue(row, col++, data.getCondensateCol3Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				
				util.addValue(row, col++, data.getCondensateCol4Inbound(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getCondensateCol4Outbound(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getCondensateCol4Desc(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				
				if(data.isCondensateCol5() == true)
				{
					util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
				}
				else if(data.isCondensateCol5() == false) 
				{
					util.addValue(row, col++, "No",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}else
				{
					util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}

				util.addValue(row, col++, data.getCondensateCol5Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				
				if(data.isCondensateCol6() == true)
				{
					util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
				}
				else if(data.isCondensateCol6() == false) 
				{
					util.addValue(row, col++, "No",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}else
				{
					util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}
				util.addValue(row, col++, data.getCondensateCol6Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				
				
				util.addValue(row, col++, data.getCondensateCol7Inbound(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getCondensateCol7Outbound(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getCondensateCol7Desc(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				
				
				if(data.isCondensateCol8() == true)
				{
					util.addValue(row, col++, "Open",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
				}
				else if(data.isCondensateCol8() == false) 
				{
					util.addValue(row, col++, "Close",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}else
				{
					util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}
				util.addValue(row, col++, data.getCondensateCol8Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);


				util.addValue(row, col++, data.getCondensateCol9Inbound(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getCondensateCol9Outbound(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getCondensateCol9Desc(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				
				if(data.isCondensateCol10() == true)
				{
					util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
				}
				else if(data.isCondensateCol10() == false) 
				{
					util.addValue(row, col++, "No",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}else
				{
					util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}
				util.addValue(row, col++, data.getCondensateCol10Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				
				util.addValue(row, col++, data.getCondensateCol11Inbound(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getCondensateCol11Outbound(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getCondensateCol11Desc(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				
				if(data.isCondensateCol12() == true)
				{
					util.addValue(row, col++, "Open",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
				}
				else if(data.isCondensateCol12() == false) 
				{
					util.addValue(row, col++, "Close",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}else
				{
					util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}
				util.addValue(row, col++, data.getCondensateCol12Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				
				
				if(data.isCondensateCol13() == true)
				{
					util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
				}
				else if(data.isCondensateCol13() == false) 
				{
					util.addValue(row, col++, "No",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}else
				{
					util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}
				util.addValue(row, col++, data.getCondensateCol13Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				
				util.addValue(row, col++, data.getCondensateCol14Inbound(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getCondensateCol14Outbound(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getCondensateCol14Desc(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				/**** 
				if(data.getCondensateCol15()!=null)
				{
					util.addValue(row, col++,data.getCondensateCol15(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
				}else
				{
					util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}
				util.addValue(row, col++, data.getCondensateCol15Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				***/
				
				if(data.isShowerWaterCol1() == true)
				{
					util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
				}
				else if(data.isShowerWaterCol1() == false) 
				{
					util.addValue(row, col++, "No",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}else
				{
					util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}
				util.addValue(row, col++, data.getShowerWaterCol1Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				
				if(data.isShowerWaterCol2() == true)
				{
					util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
				}
				else if(data.isShowerWaterCol2() == false) 
				{
					util.addValue(row, col++, "No",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}else
				{
					util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}
				util.addValue(row, col++, data.getShowerWaterCol2Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				
				util.addValue(row, col++, data.getShowerWaterCol3Inbound(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getShowerWaterCol3Outbound(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getShowerWaterCol3Desc(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				
				if(data.isShowerWaterCol4() == true)
				{
					util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
				}
				else if(data.isShowerWaterCol4() == false) 
				{
					util.addValue(row, col++, "No",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}else
				{
					util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}
				util.addValue(row, col++, data.getShowerWaterCol4Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				 
				
				util.addValue(row, col++, data.getShowerWaterCol5Inbound(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getShowerWaterCol5Outbound(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getShowerWaterCol5Desc(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				/****
				
				if(data.isShowerWaterCol6() == true)
				{
					util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
				}
				else if(data.isShowerWaterCol6() == false) 
				{
					util.addValue(row, col++, "No",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}else
				{
					util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}
				util.addValue(row, col++, data.getShowerWaterCol6Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				
				
				util.addValue(row, col++, data.getShowerWaterCol7Inbound(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getShowerWaterCol7Outbound(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getShowerWaterCol7Desc(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				***/
				
				util.addValue(row, col++, data.getShowerWaterCol8(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getShowerWaterCol8Desc(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				util.addValue(row, col++, data.getShowerWaterCol9(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getShowerWaterCol9Desc(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				
				
				util.addValue(row, col++, data.getLubricationCol1(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getLubricationCol1Desc(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				util.addValue(row, col++, data.getLubricationCol2(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getLubricationCol2Desc(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				util.addValue(row, col++, data.getLubricationCol3(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getLubricationCol3Desc(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				
				util.addValue(row, col++, data.getLubricationCol4(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getLubricationCol4Desc(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				util.addValue(row, col++, data.getLubricationCol5(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getLubricationCo5Desc(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				util.addValue(row, col++, data.getLubricationCol6(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getLubricationCo6Desc(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				util.addValue(row, col++, data.getLubricationCol7(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getLubricationCo7Desc(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				
				util.addValue(row, col++, data.getFillupcol1(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getFillupcol1Desc(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				util.addValue(row, col++, data.getFillupcol2(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getFillupcol2Desc(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				util.addValue(row, col++, data.getFillupcol3(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getFillupcol3Desc(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				util.addValue(row, col++, data.getFillupcol5(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getFillupcol5Desc(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				util.addValue(row, col++, data.getFillupcol6(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getFillupcol6Desc(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				util.addValue(row, col++, data.getFillupcol7(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getFillupcol7Desc(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
			 	
				if(data.isAfterDryerCol4() == true)
				{
					util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
				}
				else if(data.isAfterDryerCol4() == false) 
				{
					util.addValue(row, col++, "No",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}else
				{
					util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}
				util.addValue(row, col++, data.getAfterDryerCol4Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
			 	
				if(data.isShowerWaterCol6() == true)
				{
					util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
				}
				else if(data.isShowerWaterCol6() == false) 
				{
					util.addValue(row, col++, "No",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}else
				{
					util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}
				util.addValue(row, col++, data.getShowerWaterCol6Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				util.addValue(row, col++, data.getAfterDryerCol5(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getAfterDryerCol5Desc(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				util.addValue(row, col++, data.getAfterDryerCol6(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getAfterDryerCol6Desc(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				util.addValue(row, col++, data.getEqptScannerCol2(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getEqptScannerCol2Desc(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				util.addValue(row, col++, data.getCheckbladechange(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getCheckbladechangeremark(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				util.addValue(row, col++, data.getCelovesforholes(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getCelovesforholesremark(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				row++;
		
				}
			col = 0;
			util.addValue(row+2, col++, "OBCC Completed = "+l+"%",Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeight);
			 util.write(outputStream);
	 }
	
	public void getExcelReportForNightBacktender(List<BackTender> operatordata, File file, ServletOutputStream outputStream,long l) throws IOException {
		
		Workbook2007Util util = new Workbook2007Util(file,0);
		util.setSheetName("Night Backtender Operator ", 0);
		
		short rowHeight = 280;
		int row=3;
		int col=0;
		
		for(BackTender data:operatordata){
			col =0;
			
			 if(data.isMachinedown())
				   util.addValue(row, col++, "YES", Workbook2007Util.Style.STYLE_NORMAL_CENTER_RED, rowHeight);
			   else
				   util.addValue(row, col++,"NO", Workbook2007Util.Style.STYLE_NORMAL_CENTER_GREEN, rowHeight); 
	
			util.addValue(row, col++,   data.getEdate(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_GREEN, rowHeight);
			util.addValue(row, col++, CommonUtil.capitalizeFirstLetter(data.getPosition()), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.capitalizeFirstLetter(data.getShift()), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, data.getCrew(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			
			
			if(data.isAfterDryerCol1() == true)
			{
				util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isAfterDryerCol1() == false) 
			{
				util.addValue(row, col++, "No",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			util.addValue(row, col++, data.getAfterDryerCol1Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			
			util.addValue(row, col++, data.getAfterDryerCol2(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getAfterDryerCol2Desc(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			
			util.addValue(row, col++, data.getAfterDryerCol3(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getAfterDryerCol3Desc(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			/****
			if(data.isAfterDryerCol4() == true)
			{
				util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isAfterDryerCol4() == false) 
			{
				util.addValue(row, col++, "No",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			util.addValue(row, col++, data.getAfterDryerCol4Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			
			
			if(data.getAfterDryerCol5()!=null)
			{
				util.addValue(row, col++,data.getAfterDryerCol5(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			util.addValue(row, col++, data.getAfterDryerCol5Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			
			if(data.getAfterDryerCol6()!=null)
			{
				util.addValue(row, col++,data.getAfterDryerCol6(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			util.addValue(row, col++, data.getAfterDryerCol6Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			***/
			
			if(data.isEqptScannerCol1() == true)
			{
				util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isEqptScannerCol1() == false) 
			{
				util.addValue(row, col++, "No",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			util.addValue(row, col++, data.getEqptScannerCol1Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			
			/**
			if(data.getEqptScannerCol2()!=null)
			{
				util.addValue(row, col++, data.getEqptScannerCol2(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			util.addValue(row, col++, data.getEqptScannerCol2Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			***/
			if(data.isEqptScannerCol3() == true)
			{
				util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isEqptScannerCol3() == false) 
			{
				util.addValue(row, col++, "No",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			util.addValue(row, col++, data.getEqptScannerCol3Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			
			if(data.isEqptScannerCol4() == true)
			{
				util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isEqptScannerCol4() == false) 
			{
				util.addValue(row, col++, "No",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			util.addValue(row, col++, data.getEqptScannerCol4Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			if(data.isEqptScannerCol5() == true)
			{
				util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isEqptScannerCol5() == false) 
			{
				util.addValue(row, col++, "No",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			util.addValue(row, col++, data.getEqptScannerCol5Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			
			
			
			if(data.isEqptReelSectionCol1() == true)
			{
				util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isEqptReelSectionCol1() == false) 
			{
				util.addValue(row, col++, "No",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			util.addValue(row, col++, data.getEqptReelSectionCol1Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			
			
			util.addValue(row, col++, data.getEqptReelSectionCol2(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getEqptReelSectionCol2Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			
			util.addValue(row, col++, data.getEqptReelSectionCol3(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getEqptReelSectionCol3Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			
			util.addValue(row, col++, data.getEqptReelSectionCol4(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getEqptReelSectionCol4Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			util.addValue(row, col++, data.getEqptReelSectionCol5(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getEqptReelSectionCol5Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			
			
			if(data.isOilFlowCol1() == true)
			{
				util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isOilFlowCol1() == false) 
			{
				util.addValue(row, col++, "No",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			util.addValue(row, col++, data.getOilFlowCol1Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			
			
			if(data.isOilFlowCol2() == true)
			{
				util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isOilFlowCol2() == false) 
			{
				util.addValue(row, col++, "No",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			util.addValue(row, col++, data.getOilFlowCol2Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			
			if(data.isOilFlowCol3() == true)
			{
				util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isOilFlowCol3() == false) 
			{
				util.addValue(row, col++, "No",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			util.addValue(row, col++, data.getOilFlowCol3Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			
			if(data.isOilFlowCol4() == true)
			{
				util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isOilFlowCol4() == false) 
			{
				util.addValue(row, col++, "No",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			util.addValue(row, col++, data.getOilFlowCol4Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			
			
			util.addValue(row, col++, data.getOilFlowCol5(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getOilFlowCol5Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			util.addValue(row, col++, data.getOilFlowCol6(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getOilFlowCol6Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			util.addValue(row, col++, data.getOilFlowCol7(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getOilFlowCol7Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			
			if(data.isMezzanineCol1() == true)
			{
				util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isMezzanineCol1() == false) 
			{
				util.addValue(row, col++, "No",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			util.addValue(row, col++, data.getMezzanineCol1Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			
			
			
			
			if(data.isMezzanineCol2() == true)
			{
				util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isMezzanineCol2() == false) 
			{
				util.addValue(row, col++, "No",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			util.addValue(row, col++, data.getMezzanineCol2Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			
			if(data.isMezzanineCol3() == true)
			{
				util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isMezzanineCol3() == false) 
			{
				util.addValue(row, col++, "No",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			util.addValue(row, col++, data.getMezzanineCol3Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			
			if(data.isMezzanineCol4() == true)
			{
				util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isMezzanineCol4() == false) 
			{
				util.addValue(row, col++, "No",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			util.addValue(row, col++, data.getMezzanineCol4Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			
			if(data.isMezzanineCol5() == true)
			{
				util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isMezzanineCol5() == false) 
			{
				util.addValue(row, col++, "No",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}util.addValue(row, col++, data.getMezzanineCol5Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			
			
			
			util.addValue(row, col++, data.getFillupcol1(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getFillupcol1Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			
			util.addValue(row, col++, data.getFillupcol2(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getFillupcol2Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			util.addValue(row, col++, data.getFillupcol3(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getFillupcol3Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			util.addValue(row, col++, data.getFillupcol4(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getFillupcol4Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			util.addValue(row, col++, data.getFillupcol5(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getFillupcol5Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			util.addValue(row, col++, data.getFillupcol6(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getFillupcol6Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			util.addValue(row, col++, data.getFillupcol7(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getFillupcol7Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			if(data.isAfterDryerCol4() == true)
			{
				util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isAfterDryerCol4() == false) 
			{
				util.addValue(row, col++, "No",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			util.addValue(row, col++, data.getAfterDryerCol4Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
		 	
			if(data.isShowerWaterCol6() == true)
			{
				util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isShowerWaterCol6() == false) 
			{
				util.addValue(row, col++, "No",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			util.addValue(row, col++, data.getShowerWaterCol6Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			util.addValue(row, col++, data.getAfterDryerCol5(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getAfterDryerCol5Desc(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			util.addValue(row, col++, data.getAfterDryerCol6(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getAfterDryerCol6Desc(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			util.addValue(row, col++, data.getEqptScannerCol2(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getEqptScannerCol2Desc(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			util.addValue(row, col++, data.getCheckbladechange(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getCheckbladechangeremark(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			util.addValue(row, col++, data.getCelovesforholes(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getCelovesforholesremark(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			
			
			row++;
		}
		col = 0;
		util.addValue(row+2, col++, "OBCC Completed = "+l+"%",Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeight);
		util.write(outputStream);
	}

	public void getExcelReportForBacktender(List<BackTender> dayoperatordata,List<BackTender> nightoperatordata, File file, ServletOutputStream outputStream,long l) throws IOException {
	
		Workbook2007Util util = new Workbook2007Util(file,0);
		util.setSheetName("Backtender Operator ", 0);
		
		short rowHeight = 280;
		short rowHeightHeader = 900;
		int row=3;
		int col=0;
		
		for(BackTender data:dayoperatordata){
			col =0;
			 if(data.isMachinedown())
				   util.addValue(row, col++, "YES", Workbook2007Util.Style.STYLE_NORMAL_CENTER_RED, rowHeight);
			   else
				   util.addValue(row, col++,"NO", Workbook2007Util.Style.STYLE_NORMAL_CENTER_GREEN, rowHeight); 
	
			util.addValue(row, col++,   data.getEdate(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_GREEN, rowHeight);
			util.addValue(row, col++, CommonUtil.capitalizeFirstLetter(data.getPosition()), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.capitalizeFirstLetter(data.getShift()), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, data.getCrew(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			
			
			
			util.addValue(row, col++, data.getReelCol1(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getReelCol1Desc(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			util.addValue(row, col++, data.getReelCol2(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getReelCol2Desc(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			
			util.addValue(row, col++, data.getReelCol3Inbound(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getReelCol3Outbound(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getReelCol3Desc(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			
			if(data.isReelCol4() == true)
			{
				util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isReelCol4() == false) 
			{
				util.addValue(row, col++, "No",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			util.addValue(row, col++, data.getReelCol4Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			
			util.addValue(row, col++, data.getReelCol5(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getReelCol5Desc(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			
			
			util.addValue(row, col++, data.getMachineLubricationCol1(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getMachineLubricationCol1Desc(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			util.addValue(row, col++, data.getMachineLubricationCol2(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getMachineLubricationCol2Desc(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			
			if(data.getMachineLubricationCol3() !=null)
			{
				util.addValue(row, col++,data.getMachineLubricationCol3() ,Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			util.addValue(row, col++, data.getMachineLubricationCol3Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			
			util.addValue(row, col++, data.getMachineLubricationCol4(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getMachineLubricationCol4Desc(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			util.addValue(row, col++, data.getMachineLubricationCol5(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getMachineLubricationCol5Desc(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			
			
			if(data.isCondensateCol1() == true)
			{
				util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isCondensateCol1() == false) 
			{
				util.addValue(row, col++, "No",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			util.addValue(row, col++, data.getCondensateCol1Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			
			util.addValue(row, col++, data.getCondensateCol2Inbound(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getCondensateCol2Outbound(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getCondensateCol3Desc(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			
			
			if(data.isCondensateCol3() == true)
			{
				util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isCondensateCol3() == false) 
			{
				util.addValue(row, col++, "No",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			util.addValue(row, col++, data.getCondensateCol3Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			
			util.addValue(row, col++, data.getCondensateCol4Inbound(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getCondensateCol4Outbound(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getCondensateCol4Desc(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			
			if(data.isCondensateCol5() == true)
			{
				util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isCondensateCol5() == false) 
			{
				util.addValue(row, col++, "No",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			util.addValue(row, col++, data.getCondensateCol5Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			
			if(data.isCondensateCol6() == true)
			{
				util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isCondensateCol6() == false) 
			{
				util.addValue(row, col++, "No",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			util.addValue(row, col++, data.getCondensateCol6Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			
			
			util.addValue(row, col++, data.getCondensateCol7Inbound(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getCondensateCol7Outbound(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getCondensateCol7Desc(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			
			
			if(data.isCondensateCol8() == true)
			{
				util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isCondensateCol8() == false) 
			{
				util.addValue(row, col++, "No",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			util.addValue(row, col++, data.getCondensateCol8Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);


			util.addValue(row, col++, data.getCondensateCol9Inbound(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getCondensateCol9Outbound(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getCondensateCol9Desc(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			
			if(data.isCondensateCol10() == true)
			{
				util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isCondensateCol10() == false) 
			{
				util.addValue(row, col++, "No",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			util.addValue(row, col++, data.getCondensateCol10Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			
			util.addValue(row, col++, data.getCondensateCol11Inbound(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getCondensateCol11Outbound(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getCondensateCol11Desc(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			
			if(data.isCondensateCol12() == true)
			{
				util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isCondensateCol12() == false) 
			{
				util.addValue(row, col++, "No",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			util.addValue(row, col++, data.getCondensateCol12Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			
			
			if(data.isCondensateCol13() == true)
			{
				util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isCondensateCol13() == false) 
			{
				util.addValue(row, col++, "No",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			util.addValue(row, col++, data.getCondensateCol13Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			
			util.addValue(row, col++, data.getCondensateCol14Inbound(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getCondensateCol14Outbound(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getCondensateCol14Desc(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			 
			if(data.getCondensateCol15()!=null)
			{
				util.addValue(row, col++,data.getCondensateCol15(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			util.addValue(row, col++, data.getCondensateCol15Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			
			
			if(data.isShowerWaterCol1() == true)
			{
				util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isShowerWaterCol1() == false) 
			{
				util.addValue(row, col++, "No",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			util.addValue(row, col++, data.getShowerWaterCol1Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			
			if(data.isShowerWaterCol2() == true)
			{
				util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isShowerWaterCol2() == false) 
			{
				util.addValue(row, col++, "No",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			util.addValue(row, col++, data.getShowerWaterCol2Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			
			util.addValue(row, col++, data.getShowerWaterCol3Inbound(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getShowerWaterCol3Outbound(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getShowerWaterCol3Desc(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			
			if(data.isShowerWaterCol4() == true)
			{
				util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isShowerWaterCol4() == false) 
			{
				util.addValue(row, col++, "No",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			util.addValue(row, col++, data.getShowerWaterCol4Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			 
			
			util.addValue(row, col++, data.getShowerWaterCol5Inbound(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getShowerWaterCol5Outbound(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getShowerWaterCol5Desc(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			
			if(data.isShowerWaterCol6() == true)
			{
				util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isShowerWaterCol6() == false) 
			{
				util.addValue(row, col++, "No",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			util.addValue(row, col++, data.getShowerWaterCol6Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			
			
			util.addValue(row, col++, data.getShowerWaterCol7Inbound(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getShowerWaterCol7Outbound(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getShowerWaterCol7Desc(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			
			
			util.addValue(row, col++, data.getShowerWaterCol8(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getShowerWaterCol8Desc(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			util.addValue(row, col++, data.getShowerWaterCol9(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getShowerWaterCol9Desc(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			
			
			util.addValue(row, col++, data.getLubricationCol1(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getLubricationCol1Desc(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			util.addValue(row, col++, data.getLubricationCol2(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getLubricationCol2Desc(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			util.addValue(row, col++, data.getLubricationCol3(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getLubricationCol3Desc(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			
			util.addValue(row, col++, data.getLubricationCol4(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getLubricationCol4Desc(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			util.addValue(row, col++, data.getLubricationCol5(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getLubricationCo5Desc(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			util.addValue(row, col++, data.getLubricationCol6(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getLubricationCo6Desc(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			util.addValue(row, col++, data.getLubricationCol7(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getLubricationCo7Desc(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			
			util.addValue(row, col++, data.getFillupcol1(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getFillupcol1Desc(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			util.addValue(row, col++, data.getFillupcol2(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getFillupcol2Desc(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			util.addValue(row, col++, data.getFillupcol3(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getFillupcol3Desc(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			util.addValue(row, col++, data.getFillupcol5(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getFillupcol5Desc(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			util.addValue(row, col++, data.getFillupcol6(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getFillupcol6Desc(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			util.addValue(row, col++, data.getFillupcol7(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getFillupcol7Desc(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
		 	
			
			
			row++;
		}
		
		
		 row = row+2;
		 col=0;
		
		 util.addValue(row, col++, "Machine Down", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);	
		 util.addValue(row, col++, "Date", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 util.addValue(row, col++, "Position", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 util.addValue(row, col++, "Shift", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 util.addValue(row, col++, "Crew", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);	
		
		 
		 util.addValue(row, col++, "Verify Dryer felt edges are smooth", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
		 util.addValue(row, col++, "Description", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 util.addValue(row, col++, "Top Stretch Felt Tension (PSI)", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 util.addValue(row, col++, "Description", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 util.addValue(row, col++, "Bottom Stretch Felt Tension (PSI)", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 util.addValue(row, col++, "Description", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 util.addValue(row, col++, "Top Felt Guide Paddle Position Correctness & Cleanliness", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 util.addValue(row, col++, "Description", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 util.addValue(row, col++, "Bott. Felt Guide Paddle Position Correctness & Cleanliness", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 util.addValue(row, col++, "Description", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 util.addValue(row, col++, "Felt health", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		  
		 util.addValue(row, col++, "Description", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 
		 util.addValue(row, col++, "Verify Scanner Air Filter is Clean", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 util.addValue(row, col++, "Description", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 util.addValue(row, col++, "Verify Scanner Chiller Water Level is Present", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 
		 util.addValue(row, col++, "Description", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 util.addValue(row, col++, "Clean the scanner heads", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 util.addValue(row, col++, "Description", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 
		 util.addValue(row, col++, "Cleanliness of the opearting floor", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 
		 util.addValue(row, col++, "Description", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 util.addValue(row, col++, "Spool starter fix condition", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 util.addValue(row, col++, "Description", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 util.addValue(row, col++, "Verify brakes pads condition is acceptable", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 util.addValue(row, col++, "Description", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 util.addValue(row, col++, "Mill Supply Air Pressure (PSI)", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 util.addValue(row, col++, "Description", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 
		 
		 
		 util.addValue(row, col++, "Reel Doctor Loading Pressure (PSI)", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 util.addValue(row, col++, "Description", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 util.addValue(row, col++, "Reel Brake Loading Pressure (PSI)", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 util.addValue(row, col++, "Description", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 util.addValue(row, col++, "After-dryer Doctor Loading Pressure", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 
		 util.addValue(row, col++, "Description", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 
		 util.addValue(row, col++, "DS2 (F)", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 util.addValue(row, col++, "Description", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 
		 util.addValue(row, col++, "DS3 (H)", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 util.addValue(row, col++, "Description", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 util.addValue(row, col++, "DS4 (I)", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 util.addValue(row, col++, "Description", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 util.addValue(row, col++, "DS5 (N)", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 util.addValue(row, col++, "Description", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 util.addValue(row, col++, "RGBXT", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 util.addValue(row, col++, "Description", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 util.addValue(row, col++, "RBRG", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 util.addValue(row, col++, "Description", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 util.addValue(row, col++, "RGBXS", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 util.addValue(row, col++, "Description", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 util.addValue(row, col++, "Verify DE Combustion External Filters are clean and not plugged/dirty", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 util.addValue(row, col++, "Description", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		
		
		 
		 
		 util.addValue(row, col++, "Verify WE Combustion Ext Filters are clean", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 util.addValue(row, col++, "Description", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 util.addValue(row, col++, "Verify DE Yankee Hood Supply Fan Bearing Oil levels (2)", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 util.addValue(row, col++, "Description", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 util.addValue(row, col++, "Inspect Drive Side Clearance between Hood and Yankee Dryer for pluggage/build-up.", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 util.addValue(row, col++, "Description", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 util.addValue(row, col++, "Verify WE Yankee Hood Supply Fan Bearing Oil levels (2)", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 util.addValue(row, col++, "Description", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 util.addValue(row, col++, "Blow down Yankee catwalks, top of hood and hood duct work", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 util.addValue(row, col++, "Description", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader); 
		 util.addValue(row, col++, "Wash and clean M/c floors from the of after dryers to refiners (T/S and D/S)", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 
		 util.addValue(row, col++, "Description", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 util.addValue(row, col++, "Clean basement from Loose paper when needed", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 util.addValue(row, col++, "Description", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 util.addValue(row, col++, "Blow down After Dryers and frame work", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 util.addValue(row, col++, "Description", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 util.addValue(row, col++, "Check Chemical totes and change if needed", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 
		 util.addValue(row, col++, "Description", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 util.addValue(row, col++, "At least 3 blades should be on top of blade platform and all used blades cut up by end of shift", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 
		 
		 util.addValue(row, col++, "Description", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 util.addValue(row, col++, "Area around reel should be free from loose paper", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 util.addValue(row, col++, "Description", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		 
		 
		 row = row+1;
		 
		 for(BackTender data:nightoperatordata){
				 col =0;
				
				 if(data.isMachinedown())
					   util.addValue(row, col++, "YES", Workbook2007Util.Style.STYLE_NORMAL_CENTER_RED, rowHeight);
				   else
					   util.addValue(row, col++,"NO", Workbook2007Util.Style.STYLE_NORMAL_CENTER_GREEN, rowHeight); 
			 
				util.addValue(row, col++,   data.getEdate(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_GREEN, rowHeight);
				util.addValue(row, col++, CommonUtil.capitalizeFirstLetter(data.getPosition()), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
				util.addValue(row, col++, CommonUtil.capitalizeFirstLetter(data.getShift()), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
				util.addValue(row, col++, data.getCrew(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
				
				
				if(data.isAfterDryerCol1() == true)
				{
					util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
				}
				else if(data.isAfterDryerCol1() == false) 
				{
					util.addValue(row, col++, "No",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}else
				{
					util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}
				util.addValue(row, col++, data.getAfterDryerCol1Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				
				util.addValue(row, col++, data.getAfterDryerCol2(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getAfterDryerCol2Desc(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				
				util.addValue(row, col++, data.getAfterDryerCol3(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getAfterDryerCol3Desc(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				
				if(data.isAfterDryerCol4() == true)
				{
					util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
				}
				else if(data.isAfterDryerCol4() == false) 
				{
					util.addValue(row, col++, "No",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}else
				{
					util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}
				util.addValue(row, col++, data.getAfterDryerCol4Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				
				
				if(data.getAfterDryerCol5()!=null)
				{
					util.addValue(row, col++,data.getAfterDryerCol5(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
				}else
				{
					util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}
				util.addValue(row, col++, data.getAfterDryerCol5Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				
				if(data.getAfterDryerCol6()!=null)
				{
					util.addValue(row, col++,data.getAfterDryerCol6(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
				}else
				{
					util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}
				util.addValue(row, col++, data.getAfterDryerCol6Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				
				
				if(data.isEqptScannerCol1() == true)
				{
					util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
				}
				else if(data.isEqptScannerCol1() == false) 
				{
					util.addValue(row, col++, "No",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}else
				{
					util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}
				util.addValue(row, col++, data.getEqptScannerCol1Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				
				
				if(data.getEqptScannerCol2()!=null)
				{
					util.addValue(row, col++,data.getEqptScannerCol2(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
				}else
				{
					util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}
				util.addValue(row, col++, data.getEqptScannerCol2Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				
				if(data.isEqptScannerCol3() == true)
				{
					util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
				}
				else if(data.isEqptScannerCol3() == false) 
				{
					util.addValue(row, col++, "No",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}else
				{
					util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}
				util.addValue(row, col++, data.getEqptScannerCol3Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				
				if(data.isEqptScannerCol4() == true)
				{
					util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
				}
				else if(data.isEqptScannerCol4() == false) 
				{
					util.addValue(row, col++, "No",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}else
				{
					util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}
				util.addValue(row, col++, data.getEqptScannerCol4Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				if(data.isEqptScannerCol5() == true)
				{
					util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
				}
				else if(data.isEqptScannerCol5() == false) 
				{
					util.addValue(row, col++, "No",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}else
				{
					util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}
				util.addValue(row, col++, data.getEqptScannerCol5Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				
				
				
				if(data.isEqptReelSectionCol1() == true)
				{
					util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
				}
				else if(data.isEqptReelSectionCol1() == false) 
				{
					util.addValue(row, col++, "No",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}else
				{
					util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}
				util.addValue(row, col++, data.getEqptReelSectionCol1Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				
				
				util.addValue(row, col++, data.getEqptReelSectionCol2(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getEqptReelSectionCol2Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				
				util.addValue(row, col++, data.getEqptReelSectionCol3(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getEqptReelSectionCol3Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				
				util.addValue(row, col++, data.getEqptReelSectionCol4(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getEqptReelSectionCol4Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				util.addValue(row, col++, data.getEqptReelSectionCol5(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getEqptReelSectionCol5Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				
				
				if(data.isOilFlowCol1() == true)
				{
					util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
				}
				else if(data.isOilFlowCol1() == false) 
				{
					util.addValue(row, col++, "No",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}else
				{
					util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}
				util.addValue(row, col++, data.getOilFlowCol1Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				
				
				if(data.isOilFlowCol2() == true)
				{
					util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
				}
				else if(data.isOilFlowCol2() == false) 
				{
					util.addValue(row, col++, "No",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}else
				{
					util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}
				util.addValue(row, col++, data.getOilFlowCol2Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				
				if(data.isOilFlowCol3() == true)
				{
					util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
				}
				else if(data.isOilFlowCol3() == false) 
				{
					util.addValue(row, col++, "No",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}else
				{
					util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}
				util.addValue(row, col++, data.getOilFlowCol3Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				
				if(data.isOilFlowCol4() == true)
				{
					util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
				}
				else if(data.isOilFlowCol4() == false) 
				{
					util.addValue(row, col++, "No",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}else
				{
					util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}
				util.addValue(row, col++, data.getOilFlowCol4Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				
				
				util.addValue(row, col++, data.getOilFlowCol5(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getOilFlowCol5Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				util.addValue(row, col++, data.getOilFlowCol6(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getOilFlowCol6Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				util.addValue(row, col++, data.getOilFlowCol7(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getOilFlowCol7Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				
				if(data.isMezzanineCol1() == true)
				{
					util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
				}
				else if(data.isMezzanineCol1() == false) 
				{
					util.addValue(row, col++, "No",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}else
				{
					util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}
				util.addValue(row, col++, data.getMezzanineCol1Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				
				
				
				
				if(data.isMezzanineCol2() == true)
				{
					util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
				}
				else if(data.isMezzanineCol2() == false) 
				{
					util.addValue(row, col++, "No",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}else
				{
					util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}
				util.addValue(row, col++, data.getMezzanineCol2Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				
				if(data.isMezzanineCol3() == true)
				{
					util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
				}
				else if(data.isMezzanineCol3() == false) 
				{
					util.addValue(row, col++, "No",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}else
				{
					util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}
				util.addValue(row, col++, data.getMezzanineCol3Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				
				if(data.isMezzanineCol4() == true)
				{
					util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
				}
				else if(data.isMezzanineCol4() == false) 
				{
					util.addValue(row, col++, "No",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}else
				{
					util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}
				util.addValue(row, col++, data.getMezzanineCol4Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				
				if(data.isMezzanineCol5() == true)
				{
					util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
				}
				else if(data.isMezzanineCol5() == false) 
				{
					util.addValue(row, col++, "No",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}else
				{
					util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}
				util.addValue(row, col++, data.getMezzanineCol5Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				
				
				
				util.addValue(row, col++, data.getFillupcol1(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getFillupcol1Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				
				util.addValue(row, col++, data.getFillupcol2(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getFillupcol2Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				util.addValue(row, col++, data.getFillupcol3(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getFillupcol3Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				util.addValue(row, col++, data.getFillupcol4(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getFillupcol4Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				util.addValue(row, col++, data.getFillupcol5(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getFillupcol5Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				util.addValue(row, col++, data.getFillupcol6(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getFillupcol6Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				util.addValue(row, col++, data.getFillupcol7(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getFillupcol7Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
			 	
				
				
				row++;
			}
		 
		 
		 col = 0;
		 util.addValue(row+2, col++, "OBCC Completed = "+l+"%",Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeight);
		
		util.write(outputStream);
		
	}
	
	public void getExcelReportForStockOperator(List<StockOperator> dayoperatordata,List<StockOperator> nightoperatordata, File file, ServletOutputStream outputStream,long l) throws IOException {
		
		Workbook2007Util util = new Workbook2007Util(file,0);
		util.setSheetName("Stock Operator ", 0);
		
		short rowHeight = 280;
		short rowHeightHeader = 900;
		int row=3;
		int col=0;
	
		for(StockOperator data:dayoperatordata){
			    col =0;
			    if(data.isMachinedown())
					   util.addValue(row, col++, "YES", Workbook2007Util.Style.STYLE_NORMAL_CENTER_RED, rowHeight);
				   else
					   util.addValue(row, col++,"NO", Workbook2007Util.Style.STYLE_NORMAL_CENTER_GREEN, rowHeight); 
			    util.addValue(row, col++, data.getEdate(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_GREEN, rowHeight);
				util.addValue(row, col++, CommonUtil.capitalizeFirstLetter(data.getPosition()), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
				util.addValue(row, col++, CommonUtil.capitalizeFirstLetter(data.getShift()), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
				util.addValue(row, col++, data.getCrew(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
		 		 
				
				
				if(data.isHdStorageChestCol1() == true)
				{
					util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
				}
				else if(data.isHdStorageChestCol1() == false) 
				{
					util.addValue(row, col++, "No",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}else
				{
					util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}
				util.addValue(row, col++, data.getHdStorageChestCol1Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight); 
				
				
				
				util.addValue(row, col++, data.getHdStorageChestCol2Inbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getHdStorageChestCol2Outbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getHdStorageChestCol2Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				
				
				if(data.isHdStorageChestCol3() == true)
				{
					util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
				}
				else if(data.isHdStorageChestCol3() == false) 
				{
					util.addValue(row, col++, "No",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}else
				{
					util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}
				util.addValue(row, col++, data.getHdStorageChestCol3Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight); 
				
				
				
				util.addValue(row, col++, data.getHdStorageChestCol4Inbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getHdStorageChestCol4Outbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getHdStorageChestCol4Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				if(data.isHdStorageChestCol5() == true)
				{
					util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
				}
				else if(data.isHdStorageChestCol5() == false) 
				{
					util.addValue(row, col++, "No",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}else
				{
					util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}
				util.addValue(row, col++, data.getHdStorageChestCol5Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight); 
				
				
				
				util.addValue(row, col++, data.getHdStorageChestCol6Inbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getHdStorageChestCol6Outbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getHdStorageChestCol6Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				
				if(data.isHdStorageChestCol7() == true)
				{
					util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
				}
				else if(data.isHdStorageChestCol7() == false) 
				{
					util.addValue(row, col++, "No",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}else
				{
					util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}
				util.addValue(row, col++, data.getHdStorageChestCol7Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight); 
				


				util.addValue(row, col++, data.getHdStorageChestCol8Inbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getHdStorageChestCol8Outbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getHdStorageChestCol8Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				
				if(data.isBlendChestCol1() == true)
				{
					util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
				}
				else if(data.isBlendChestCol1() == false) 
				{
					util.addValue(row, col++, "No",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}else
				{
					util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}
				util.addValue(row, col++, data.getBlendChestCol1Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				
				util.addValue(row, col++, data.getBlendChestCol2Inbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getBlendChestCol2Outbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getBlendChestCol2Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				if(data.isBlendChestCol3() == true)
				{
					util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
				}
				else if(data.isBlendChestCol3() == false) 
				{
					util.addValue(row, col++, "No",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}else
				{
					util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}
				util.addValue(row, col++, data.getBlendChestCol3Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				
				util.addValue(row, col++, data.getBlendChestCol4Inbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getBlendChestCol4Outbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getBlendChestCol4Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				
				if(data.isSeeScreenFeedTandCol1()  == true)
				{
					util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
				}
				else if(data.isSeeScreenFeedTandCol1() == false) 
				{
					util.addValue(row, col++, "No",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}else
				{
					util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}
				util.addValue(row, col++, data.getSeeScreenFeedTandCol1Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				
				util.addValue(row, col++, data.getSeeScreenFeedTandCol2Inbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getSeeScreenFeedTandcol2Outbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getSeeScreenFeedTandCol2Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				
				
				if(data.isSeeScreenFeedTandCol3()  == true)
				{
					util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
				}
				else if(data.isSeeScreenFeedTandCol3() == false) 
				{
					util.addValue(row, col++, "No",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}else
				{
					util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}
				util.addValue(row, col++, data.getSeeScreenFeedTandCol3Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				util.addValue(row, col++, data.getSeeScreenFeedTandCol4Inbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getSeeScreenFeedTandcol4Outbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getSeeScreenFeedTandCol4Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				
				
				if(data.isMachineChestCol1()  == true)
				{
					util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
				}
				else if(data.isMachineChestCol1() == false) 
				{
					util.addValue(row, col++, "No",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}else
				{
					util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}
				util.addValue(row, col++, data.getMachineChestCol1Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				
				util.addValue(row, col++, data.getMachineChestCol2Inbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getMachineChestCol2Outbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getMachineChestCol2Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			 
				
				if(data.isMachineChestCol3()  == true)
				{
					util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
				}
				else if(data.isMachineChestCol3() == false) 
				{
					util.addValue(row, col++, "No",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}else
				{
					util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}
				util.addValue(row, col++, data.getMachineChestCol3Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				
				util.addValue(row, col++, data.getMachineChestCol4Inbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getMachineChestCol4Outbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getMachineChestCol4Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				
				if(data.isMachineChestCol5()  == true)
				{
					util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
				}
				else if(data.isMachineChestCol5() == false) 
				{
					util.addValue(row, col++, "No",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}else
				{
					util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}
				util.addValue(row, col++, data.getMachineChestCol5Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				
				util.addValue(row, col++, data.getMachineChestCol6Inbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getMachineChestCol6Outbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getMachineChestCol6Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				
				
				
				if(data.isCleannersCol1()  == true)
				{
					util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
				}
				else if(data.isCleannersCol1() == false) 
				{
					util.addValue(row, col++, "No",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}else
				{
					util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}
				util.addValue(row, col++, data.getCleannersCol1Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				
				if(data.isCleannersCol2()  == true)
				{
					util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
				}
				else if(data.isCleannersCol2() == false) 
				{
					util.addValue(row, col++, "No",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}else
				{
					util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}
				util.addValue(row, col++, data.getCleannersCol2Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				util.addValue(row, col++, data.getCleannersCol3Inbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getCleannersCol3Outbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getCleannersCol3Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				
				if(data.isDeLinkStockCol1()  == true)
				{
					util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
				}
				else if(data.isDeLinkStockCol1() == false) 
				{
					util.addValue(row, col++, "No",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}else
				{
					util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}
				util.addValue(row, col++, data.getDeLinkStockCol1Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				
				util.addValue(row, col++, data.getDeLinkStockCol2Inbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getDeLinkStockCol2Outbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getDeLinkStockCol2Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				
				
				if(data.isWhiteWaterCol1()  == true)
				{
					util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
				}
				else if(data.isWhiteWaterCol1() == false) 
				{
					util.addValue(row, col++, "No",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}else
				{
					util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}
				util.addValue(row, col++, data.getWhiteWaterCol1Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				util.addValue(row, col++, data.getWhiteWaterCol2Inbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getWhiteWaterCol2Outbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getWhiteWaterCol2Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				
				if(data.isWhiteWaterCol3()  == true)
				{
					util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
				}
				else if(data.isWhiteWaterCol3() == false) 
				{
					util.addValue(row, col++, "No",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}else
				{
					util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}
				util.addValue(row, col++, data.getWhiteWaterCol3Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				util.addValue(row, col++, data.getWhiteWaterCol4Inbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getWhiteWaterCol4Outbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getWhiteWaterCol4Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				
				
				if(data.isWhiteWaterCol5()  == true)
				{
					util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
				}
				else if(data.isWhiteWaterCol5() == false) 
				{
					util.addValue(row, col++, "No",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}else
				{
					util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}
				util.addValue(row, col++, data.getWhiteWaterCol5Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				util.addValue(row, col++, data.getWhiteWaterCol6Inbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getWhiteWaterCol6Outbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getWhiteWaterCol6Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				
				if(data.isWhiteWaterCol7()  == true)
				{
					util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
				}
				else if(data.isWhiteWaterCol7() == false) 
				{
					util.addValue(row, col++, "No",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}else
				{
					util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}
				util.addValue(row, col++, data.getWhiteWaterCol7Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				util.addValue(row, col++, data.getWhiteWaterCol8Inbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getWhiteWaterCol8Outbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getWhiteWaterCol8Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				
				if(data.isCouchPitCol1()  == true)
				{
					util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
				}
				else if(data.isCouchPitCol1() == false) 
				{
					util.addValue(row, col++, "No",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}else
				{
					util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}
				util.addValue(row, col++, data.getCouchPitCol1Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				
				if(data.isCouchPitCol2()  == true)
				{
					util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
				}
				else if(data.isCouchPitCol2() == false) 
				{
					util.addValue(row, col++, "No",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}else
				{
					util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}
				util.addValue(row, col++, data.getCouchPitCol2Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				
				util.addValue(row, col++, data.getCouchPitCol3Inbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getCouchPitCol3Outbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getCouchPitCol3Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				
				if(data.isCouchPitCol4()  == true)
				{
					util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
				}
				else if(data.isCouchPitCol4() == false) 
				{
					util.addValue(row, col++, "No",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}else
				{
					util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}
				util.addValue(row, col++, data.getCouchPitCol4Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				
				util.addValue(row, col++, data.getCouchPitCol5Inbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getCouchPitCol5Outbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getCouchPitCol5Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				if(data.isCouchPitCol6()  == true)
				{
					util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
				}
				else if(data.isCouchPitCol6() == false) 
				{
					util.addValue(row, col++, "No",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}else
				{
					util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}
				util.addValue(row, col++, data.getCouchPitCol6Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				
				util.addValue(row, col++, data.getCouchPitCol7Inbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getCouchPitCol7Outbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getCouchPitCol7Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				util.addValue(row, col++, data.getCouchPitCol8Inbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getCouchPitCol8Outbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getCouchPitCol8Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				
				
				if(data.isCouchPitCol9()  == true)
				{
					util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
				}
				else if(data.isCouchPitCol9() == false) 
				{
					util.addValue(row, col++, "No",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}else
				{
					util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}
				util.addValue(row, col++, data.getCouchPitCol9Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				 
				util.addValue(row, col++, data.getCouchPitCol10Inbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getCouchPitCol10Outbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getCouchPitCol10Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				util.addValue(row, col++, data.getCouchPitCol11Inbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getCouchPitCol11Outbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getCouchPitCol11Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				if(data.isYankeePulperCol1()  == true)
				{
					util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
				}
				else if(data.isYankeePulperCol1() == false) 
				{
					util.addValue(row, col++, "No",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}else
				{
					util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}
				util.addValue(row, col++, data.getYankeePulperCol1Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				
				if(data.isYankeePulperCol1Drain()  == true)
				{
					util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
				}
				else if(data.isYankeePulperCol1Drain() == false) 
				{
					util.addValue(row, col++, "No",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}else
				{
					util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}
				util.addValue(row, col++, data.getYankeePulperCol1DrainDesc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				
				if(data.isYankeePulperCol2()  == true)
				{
					util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
				}
				else if(data.isYankeePulperCol2() == false) 
				{
					util.addValue(row, col++, "No",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}else
				{
					util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}
				util.addValue(row, col++, data.getYankeePulperCol2Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				
				util.addValue(row, col++, data.getYankeePulperCol3Inbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getYankeePulperCol3Outbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getYankeePulperCol3Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				
				
				if(data.isYankeePulperCol4()  == true)
				{
					util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
				}
				else if(data.isYankeePulperCol4() == false) 
				{
					util.addValue(row, col++, "No",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}else
				{
					util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}
				util.addValue(row, col++, data.getYankeePulperCol4Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				
				
				util.addValue(row, col++, data.getYankeePulperCol5Inbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getYankeePulperCol5Outbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getYankeePulperCol5Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				

				if(data.isYankeePulperCol6()  == true)
				{
					util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
				}
				else if(data.isYankeePulperCol6() == false) 
				{
					util.addValue(row, col++, "No",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}else
				{
					util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}
				util.addValue(row, col++, data.getYankeePulperCol6Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				
				
				util.addValue(row, col++, data.getYankeePulperCol7Inbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getYankeePulperCol7Outbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getYankeePulperCol7Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				
				if(data.isYankeePulperCol8()  == true)
				{
					util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
				}
				else if(data.isYankeePulperCol8() == false) 
				{
					util.addValue(row, col++, "No",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}else
				{
					util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}
				util.addValue(row, col++, data.getYankeePulperCol8Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				
				
				util.addValue(row, col++, data.getYankeePulperCol9Inbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getYankeePulperCol9Outbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getYankeePulperCol9Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				
				util.addValue(row, col++, data.getDesccol1(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getDesccol1Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			 
				

			row++;
		}
		
		
		 try {
			row = row+2;
			 col=0;
			 
			 util.addValue(row, col++, "Date", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
			 util.addValue(row, col++, "Position", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
			 util.addValue(row, col++, "Shift", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
			 util.addValue(row, col++, "Crew", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		 
		 
		 
		 util.addValue(row, col++, "Broke Deflaker", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
		 util.addValue(row, col++, "Description", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
		 
		 
		 util.addValue(row, col++, "Deflaker Motor Inbound", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
		 util.addValue(row, col++, "Deflaker Motor Outbound", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
		 util.addValue(row, col++, "Description", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
		 
		 util.addValue(row, col++, "Sealing Water ", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
		 util.addValue(row, col++, "Description", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
		 
		 util.addValue(row, col++, "Refiner #", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
		 util.addValue(row, col++, "Description", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
		 
		 util.addValue(row, col++, "Refiner # Moter", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
		 util.addValue(row, col++, "Description", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
		 
		 
		 util.addValue(row, col++, "Refiner #Load/Unload Moter  Inbound", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
		 util.addValue(row, col++, "Refiner #Load/Unload Moter  Outbound", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
		 util.addValue(row, col++, "Description", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
		 
		 
		 util.addValue(row, col++, "Oil Level", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
		 util.addValue(row, col++, "Description", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
		 
		 
		 util.addValue(row, col++, "Sealing Water", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
		 util.addValue(row, col++, "Description", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
		 
		 
		 util.addValue(row, col++, "Refiner #", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
		 util.addValue(row, col++, "Description", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
		 
		 util.addValue(row, col++, "Refiner # Moter", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
		 util.addValue(row, col++, "Description", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
		 
		 
		 util.addValue(row, col++, "Refiner #Load/Unload Moter  Inbound", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
		 util.addValue(row, col++, "Refiner #Load/Unload Moter  Outbound", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
		 util.addValue(row, col++, "Description", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
		 
		 
		 util.addValue(row, col++, "Oil Level", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
		 util.addValue(row, col++, "Description", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
		 
		 
		 util.addValue(row, col++, "Sealing Water", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
		 util.addValue(row, col++, "Description", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
		 
		 
		 util.addValue(row, col++, "White waterTransfer Pump", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
		 util.addValue(row, col++, "Description", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
		 
		 
		 util.addValue(row, col++, "White Water Transfer  Pump Moter Inbound", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
		 util.addValue(row, col++, "White Water Transfer  Pump Moter Outbound", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
		 util.addValue(row, col++, "Description", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
		 
		 
		 util.addValue(row, col++, "Save all Shower Pump", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
		 util.addValue(row, col++, "Description", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
		 
		 
		 util.addValue(row, col++, "Save all Shower Pump Motor Inbound", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
		 util.addValue(row, col++, "Save all Shower Pump Motor Outbound", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
		 util.addValue(row, col++, "Description", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
		 
		 
		 
		 util.addValue(row, col++, "Consistency Dilution pump", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
		 util.addValue(row, col++, "Description", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
		 
		 
		 util.addValue(row, col++, "Consistency Dilution pump Motor Inbound", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
		 util.addValue(row, col++, "Consistency Dilution pump Motor Outbound", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
		 util.addValue(row, col++, "Description", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);


		 util.addValue(row, col++, "Silo Level", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
		 util.addValue(row, col++, "Description", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
		 
		 util.addValue(row, col++, "Drain", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
		 util.addValue(row, col++, "Description", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
		 
		 
		 util.addValue(row, col++, "Basic weight value position in DCS", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
		 util.addValue(row, col++, "Description", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
		 
		 
		 util.addValue(row, col++, "Yankee Pulper Overflow", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
		 util.addValue(row, col++, "Description", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
		 
		 
		 util.addValue(row, col++, "Yankee Pulper Drain", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
		 util.addValue(row, col++, "Description", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
		 
		 
		 util.addValue(row, col++, "Yankee Pulper East Agitator", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
		 util.addValue(row, col++, "Description", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
		 
		 
		 util.addValue(row, col++, "Yankee Pulper East Agitator Motor Inbound", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
		 util.addValue(row, col++, "Yankee Pulper East Agitator Motor Outbound", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
		 util.addValue(row, col++, "Description", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
		 
		 util.addValue(row, col++, "Yankee Pulper West Agitator", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
		 util.addValue(row, col++, "Description", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
		 
		
		 util.addValue(row, col++, "Yankee Pulper West Agitator Motor Inbound", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
		 util.addValue(row, col++, "Yankee Pulper West Agitator Motor Outbound", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
		 util.addValue(row, col++, "Description", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
		 
		 
		 util.addValue(row, col++, "Yankee pump", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
		 util.addValue(row, col++, "Description", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
		 
		 
		 util.addValue(row, col++, "Yankee pump Motor Inbound", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
		 util.addValue(row, col++, "Yankee pump Motor Outbound", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
		 util.addValue(row, col++, "Description", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
		 
		 
		 util.addValue(row, col++, "Yankee trim pump", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
		 util.addValue(row, col++, "Description", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
		 
		 
		 
		 util.addValue(row, col++, "Yankee trim pump Motor Inbound", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
		 util.addValue(row, col++, "Yankee trim pump Motor Outbound", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
		 util.addValue(row, col++, "Description", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
		 
		 util.addValue(row, col++, "Broke Chest Level", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
		 util.addValue(row, col++, "Description", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader); 
		 
		 
		 util.addValue(row, col++, "Central broke chest agitator Double", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
		 util.addValue(row, col++, "Description", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader); 
		 
		 util.addValue(row, col++, "Agitator Motor", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
		 util.addValue(row, col++, "Description", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader); 
		 
		 
		 util.addValue(row, col++, "Broke chest agitator South east single", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
		 util.addValue(row, col++, "Description", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader); 
		 
		 util.addValue(row, col++, "Agitator Motor", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
		 util.addValue(row, col++, "Description", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader); 
		 
		 util.addValue(row, col++, "Broke chest agitator South west single", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
		 util.addValue(row, col++, "Description", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader); 
		 
		 
		 util.addValue(row, col++, "Agitator Motor", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
		 util.addValue(row, col++, "Description", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader); 
		 
		 
		 util.addValue(row, col++, "Broke chest pump East", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
		 util.addValue(row, col++, "Description", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader); 
		 
		 util.addValue(row, col++, "Broke chest pump East Motor", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
		 util.addValue(row, col++, "Description", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader); 
		 
		 
		 util.addValue(row, col++, "Broke chest pump West", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
		 util.addValue(row, col++, "Description", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader); 
		 
		 util.addValue(row, col++, "Broke chest pump West Motor", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
		 util.addValue(row, col++, "Description", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader); 
		 
		  
		 util.addValue(row, col++, "Save All Vat", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
		 util.addValue(row, col++, "Description", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader); 
		 
		 
		 util.addValue(row, col++, "Segments", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
		 util.addValue(row, col++, "Description", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader); 
		 
		 util.addValue(row, col++, "Nozzles", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
		 util.addValue(row, col++, "Description", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
		 
		 
		 util.addValue(row, col++, "Save all Cylinder Motor Inbound", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
		 util.addValue(row, col++, "Save all Cylinder Motor Outbound", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
		 util.addValue(row, col++, "Description", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
		 
		 
		 util.addValue(row, col++, "Segement cleaning shower", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
		 util.addValue(row, col++, "Description", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
		 
		 
		 util.addValue(row, col++, "Peel off shower", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
		 util.addValue(row, col++, "Description", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
		 
		 
		 
		 util.addValue(row, col++, "Hydrapulper East", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
		 util.addValue(row, col++, "Description", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
		 
		 
		 util.addValue(row, col++, "Hydrapulper East Motor Inbound", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
		 util.addValue(row, col++, "Hydrapulper East Motor Outbound", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
		 util.addValue(row, col++, "Description", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
		 
		 
		 util.addValue(row, col++, "Lube system pump East", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
		 util.addValue(row, col++, "Description", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
		 
		 
		 util.addValue(row, col++, "Lube system pump East Motor Inbound", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
		 util.addValue(row, col++, "Lube system pump East Motor Outbound", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
		 util.addValue(row, col++, "Description", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
		 
		 util.addValue(row, col++, "Cooling Coil", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
		 util.addValue(row, col++, "Description", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
		 
		 
		 util.addValue(row, col++, "Lube oil system East Filter", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
		 util.addValue(row, col++, "Description", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
		 
		 util.addValue(row, col++, "Hydrapulper West", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
		 util.addValue(row, col++, "Description", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
		 
		 
		 util.addValue(row, col++, "Hydrapulper West Motor Inbound", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
		 util.addValue(row, col++, "Hydrapulper West Motor Outbound", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
		 util.addValue(row, col++, "Description", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
		 
		 
		 util.addValue(row, col++, "Lube system pump West", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
		 util.addValue(row, col++, "Description", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
		 
		 
		 util.addValue(row, col++, "Lube system pump West Motor Inbound", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
		 util.addValue(row, col++, "Lube system pump West Motor Outbound", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
		 util.addValue(row, col++, "Description", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
		 
		  
		 util.addValue(row, col++, "Cooling Coil", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
		 util.addValue(row, col++, "Description", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
		 
		 
		 util.addValue(row, col++, "Lube oil system West Filter", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
		 util.addValue(row, col++, "Description", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
		 
		 
		 util.addValue(row, col++, "Hydrapulper stock Pump", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
		 util.addValue(row, col++, "Description", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
		 
		 util.addValue(row, col++, "Hydrapulper stock Pump Motor Inbound", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
		 util.addValue(row, col++, "Hydrapulper stock Pump Motor Outbound", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
		 util.addValue(row, col++, "Description", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
		 
		 util.addValue(row, col++, "Hydrapulper trim pump", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
		 util.addValue(row, col++, "Description", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
		 
		 
		 util.addValue(row, col++, "Hydrapulper trim pump Motor Inbound", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
		 util.addValue(row, col++, "Hydrapulper trim pump Motor Ourbound", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
		 util.addValue(row, col++, "Description", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
		 
		 util.addValue(row, col++, "Wash M/c floors from the of after dryers to refiners", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
		 util.addValue(row, col++, "Description", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
		 
		 row = row+1;
		 
		 for(StockOperator data:nightoperatordata){
				col =0;
				 if(data.isMachinedown())
					   util.addValue(row, col++, "YES", Workbook2007Util.Style.STYLE_NORMAL_CENTER_RED, rowHeight);
				   else
					   util.addValue(row, col++,"NO", Workbook2007Util.Style.STYLE_NORMAL_CENTER_GREEN, rowHeight); 
				 	util.addValue(row, col++, data.getEdate(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_GREEN, rowHeight);
					util.addValue(row, col++, CommonUtil.capitalizeFirstLetter(data.getPosition()), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
					util.addValue(row, col++, CommonUtil.capitalizeFirstLetter(data.getShift()), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
					util.addValue(row, col++, data.getCrew(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			 		
					if(data.isBrokeDeflakerCol1() == true)
					{
						util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
					}
					else if(data.isBrokeDeflakerCol1() == false) 
					{
						util.addValue(row, col++, "No",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					}else
					{
						util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					}
					util.addValue(row, col++, data.getBrokeDeflakerCol1Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight); 
					
					
					util.addValue(row, col++, data.getBrokeDeflakerCol2Inbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					util.addValue(row, col++, data.getBrokeDeflakerCol2Outbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					util.addValue(row, col++, data.getBrokeDeflakerCol2Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					
					
					if(data.isBrokeDeflakerCol3() == true)
					{
						util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
					}
					else if(data.isBrokeDeflakerCol3() == false) 
					{
						util.addValue(row, col++, "No",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					}else
					{
						util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					}
					util.addValue(row, col++, data.getBrokeDeflakerCol3Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight); 
					
					
					
					
					util.addValue(row, col++, data.getRefiningSystemCol1(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					util.addValue(row, col++, data.getRefiningSystemCol1Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					
					
					if(data.isRefiningSystemCol2() == true)
					{
						util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
					}
					else if(data.isRefiningSystemCol2() == false) 
					{
						util.addValue(row, col++, "No",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					}else
					{
						util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					}
					util.addValue(row, col++, data.getRefiningSystemCol2Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight); 
					
					util.addValue(row, col++, data.getRefiningSystemCol3Inbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					util.addValue(row, col++, data.getRefiningSystemCol3Outbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					util.addValue(row, col++, data.getRefiningSystemCol3Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					
					
					util.addValue(row, col++, data.getRefiningSystemCol4(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					util.addValue(row, col++, data.getRefiningSystemCol4Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					
					util.addValue(row, col++, data.getRefiningSystemCol5(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					util.addValue(row, col++, data.getRefiningSystemCol5Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					
					util.addValue(row, col++, data.getRefiningSystemCol6(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					util.addValue(row, col++, data.getRefiningSystemCol6Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					
					
					if(data.isRefiningSystemCol7() == true)
					{
						util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
					}
					else if(data.isRefiningSystemCol7() == false) 
					{
						util.addValue(row, col++, "No",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					}else
					{
						util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					}
					util.addValue(row, col++, data.getRefiningSystemCol7Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight); 
					
					
					util.addValue(row, col++, data.getRefiningSystemCol8Inbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					util.addValue(row, col++, data.getRefiningSystemCol8Outbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					util.addValue(row, col++, data.getRefiningSystemCol8Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					
					
					util.addValue(row, col++, data.getRefiningSystemCol9(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					util.addValue(row, col++, data.getRefiningSystemCol9Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					
					util.addValue(row, col++, data.getRefiningSystemCol10(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					util.addValue(row, col++, data.getRefiningSystemCol10Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					
					
					
					
					if(data.isWhiteWaterPumpCol1() == true)
					{
						util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
					}
					else if(data.isWhiteWaterPumpCol1() == false) 
					{
						util.addValue(row, col++, "No",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					}else
					{
						util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					}
					util.addValue(row, col++, data.getWhiteWaterPumpCol1Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					
					
					
					util.addValue(row, col++, data.getWhiteWaterPumpCol2Inbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					util.addValue(row, col++, data.getWhiteWaterPumpCol2Outbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					util.addValue(row, col++, data.getWhiteWaterPumpCol2Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					
					
					
					
					if(data.isWhiteWaterPumpCol3() == true)
					{
						util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
					}
					else if(data.isWhiteWaterPumpCol3() == false) 
					{
						util.addValue(row, col++, "No",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					}else
					{
						util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					}
					util.addValue(row, col++, data.getWhiteWaterPumpCol3Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					
					
					
					util.addValue(row, col++, data.getWhiteWaterPumpCol4Inbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					util.addValue(row, col++, data.getWhiteWaterPumpCol4Outbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					util.addValue(row, col++, data.getWhiteWaterPumpCol4Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					
					
					
					if(data.isWhiteWaterPumpCol5() == true)
					{
						util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
					}
					else if(data.isWhiteWaterPumpCol5() == false) 
					{
						util.addValue(row, col++, "No",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					}else
					{
						util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					}
					util.addValue(row, col++, data.getWhiteWaterPumpCol5Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					
					
					
					util.addValue(row, col++, data.getWhiteWaterPumpCol6Inbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					util.addValue(row, col++, data.getWhiteWaterPumpCol6Outbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					util.addValue(row, col++, data.getWhiteWaterPumpCol6Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					
					
					
					util.addValue(row, col++, data.getSilloCol1(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					util.addValue(row, col++, data.getSilloCol1Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					
					
					if(data.isSilloCol2() == true)
					{
						util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
					}
					else if(data.isHdStorageChestCol3() == false) 
					{
						util.addValue(row, col++, "No",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					}else
					{
						util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					}
					util.addValue(row, col++, data.getSilloCol2Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					
					util.addValue(row, col++, data.getSilloCol3(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					util.addValue(row, col++, data.getSilloCol3Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					
					
					
					if(data.isYankeePumplerCol1() == true)
					{
						util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
					}
					else if(data.isYankeePumplerCol1() == false) 
					{
						util.addValue(row, col++, "No",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					}else
					{
						util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					}
					util.addValue(row, col++, data.getYankeePumplerCol1Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					
					
					if(data.isYankeePumplerCol1Drain() == true)
					{
						util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
					}
					else if(data.isYankeePumplerCol1Drain() == false) 
					{
						util.addValue(row, col++, "No",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					}else
					{
						util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					}
					util.addValue(row, col++, data.getYankeePumplerCol1DrainDesc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					
					
					
					if(data.isYankeePumplerCol2() == true)
					{
						util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
					}
					else if(data.isYankeePumplerCol2() == false) 
					{
						util.addValue(row, col++, "No",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					}else
					{
						util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					}
					util.addValue(row, col++, data.getYankeePumplerCol2Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					
					
					
					
					util.addValue(row, col++, data.getYankeePumplerCol3Inbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					util.addValue(row, col++, data.getYankeePumplerCol3Outbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					util.addValue(row, col++, data.getYankeePumplerCol3Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					
					
					
					if(data.isYankeePumplerCol4() == true)
					{
						util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
					}
					else if(data.isYankeePumplerCol4() == false) 
					{
						util.addValue(row, col++, "No",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					}else
					{
						util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					}
					util.addValue(row, col++, data.getYankeePumplerCol3Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					
					
					util.addValue(row, col++, data.getYankeePumplerCol5Inbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					util.addValue(row, col++, data.getYankeePumplerCol5Outbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					util.addValue(row, col++, data.getYankeePumplerCol5Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					
					
					
					if(data.isYankeePumplerCol6() == true)
					{
						util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
					}
					else if(data.isYankeePumplerCol6() == false) 
					{
						util.addValue(row, col++, "No",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					}else
					{
						util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					}
					util.addValue(row, col++, data.getYankeePumplerCol6Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					
					
					util.addValue(row, col++, data.getYankeePumplerCol7Inbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					util.addValue(row, col++, data.getYankeePumplerCol7Outbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					util.addValue(row, col++, data.getYankeePumplerCol7Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					
					
					if(data.isYankeePumplerCol8() == true)
					{
						util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
					}
					else if(data.isYankeePumplerCol8() == false) 
					{
						util.addValue(row, col++, "No",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					}else
					{
						util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					}
					util.addValue(row, col++, data.getYankeePumplerCol8Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					
					util.addValue(row, col++, data.getYankeePumplerCol9Inbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					util.addValue(row, col++, data.getYankeePumplerCol9Outbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					util.addValue(row, col++, data.getYankeePumplerCol9Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					
					
					
					
					
					util.addValue(row, col++, data.getBrokeSystemCol1(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					util.addValue(row, col++, data.getBrokeSystemCol1Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					util.addValue(row, col++, data.getBrokeSystemCol2(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					util.addValue(row, col++, data.getBrokeSystemCol2Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					util.addValue(row, col++, data.getBrokeSystemCol3(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					util.addValue(row, col++, data.getBrokeSystemCol3Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					util.addValue(row, col++, data.getBrokeSystemCol4(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					util.addValue(row, col++, data.getBrokeSystemCol4Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					util.addValue(row, col++, data.getBrokeSystemCol5(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					util.addValue(row, col++, data.getBrokeSystemCol5Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					util.addValue(row, col++, data.getBrokeSystemCol6(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					util.addValue(row, col++, data.getBrokeSystemCol6Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					util.addValue(row, col++, data.getBrokeSystemCol7(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					util.addValue(row, col++, data.getBrokeSystemCol7Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					util.addValue(row, col++, data.getBrokeSystemCol8(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					util.addValue(row, col++, data.getBrokeSystemCol8Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					util.addValue(row, col++, data.getBrokeSystemCol9(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					util.addValue(row, col++, data.getBrokeSystemCol9Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					util.addValue(row, col++, data.getBrokeSystemCol10(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					util.addValue(row, col++, data.getBrokeSystemCol10Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					util.addValue(row, col++, data.getBrokeSystemCol11(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					util.addValue(row, col++, data.getBrokeSystemCol11Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					
					
					
					util.addValue(row, col++, data.getSaveAllCol1(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					util.addValue(row, col++, data.getSaveAllCol1Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					
					
					if(data.isSaveAllCol2() == true)
					{
						util.addValue(row, col++, "Work",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
					}
					else if(data.isSaveAllCol2() == false) 
					{
						util.addValue(row, col++, "Plug",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					}else
					{
						util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					}
					util.addValue(row, col++, data.getSaveAllCol2Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					
					
					if(data.isSaveAllCol3() == true)
					{
						util.addValue(row, col++, "Work",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
					}
					else if(data.isSaveAllCol3() == false) 
					{
						util.addValue(row, col++, "Plug",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					}else
					{
						util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					}
					util.addValue(row, col++, data.getSaveAllCol3Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					
					
					
					util.addValue(row, col++, data.getSaveAllCol4Inbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					util.addValue(row, col++, data.getSaveAllCol4Outbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					util.addValue(row, col++, data.getSaveAllCol4Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					
					
					
					
					
					if(data.isSaveAllCol5() == true)
					{
						util.addValue(row, col++, "On",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
					}
					else if(data.isSaveAllCol5() == false) 
					{
						util.addValue(row, col++, "Off",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					}else
					{
						util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					}
					util.addValue(row, col++, data.getSaveAllCol5Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					
					
					
					if(data.isSaveAllCol6() == true)
					{
						util.addValue(row, col++, "On",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
					}
					else if(data.isSaveAllCol6() == false) 
					{
						util.addValue(row, col++, "Off",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					}else
					{
						util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					}
					util.addValue(row, col++, data.getSaveAllCol6Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					
					


					
					
					if(data.isHydrapulperCol1() == true)
					{
						util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
					}
					else if(data.isHydrapulperCol1() == false) 
					{
						util.addValue(row, col++, "No",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					}else
					{
						util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					}
					util.addValue(row, col++, data.getHydrapulperCol1Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					
					
					
					util.addValue(row, col++, data.getHydrapulperCol2Inbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					util.addValue(row, col++, data.getHydrapulperCol2outbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					util.addValue(row, col++, data.getHydrapulperCol2Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					
					
					if(data.isHydrapulperCol3() == true)
					{
						util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
					}
					else if(data.isHydrapulperCol3() == false) 
					{
						util.addValue(row, col++, "No",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					}else
					{
						util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					}
					util.addValue(row, col++, data.getHydrapulperCol3Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					
					
					util.addValue(row, col++, data.getHydrapulperCol4Inbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					util.addValue(row, col++, data.getHydrapulperCol4outbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					util.addValue(row, col++, data.getHydrapulperCol4Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					
					

					if(data.isHydrapulperCol5() == true)
					{
						util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
					}
					else if(data.isHydrapulperCol5() == false) 
					{
						util.addValue(row, col++, "No",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					}else
					{
						util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					}
					util.addValue(row, col++, data.getHydrapulperCol5Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					
					

					if(data.isHydrapulperCol6() == true)
					{
						util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
					}
					else if(data.isHydrapulperCol6() == false) 
					{
						util.addValue(row, col++, "No",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					}else
					{
						util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					}
					util.addValue(row, col++, data.getHydrapulperCol6Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					

					if(data.isHydrapulperCol7() == true)
					{
						util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
					}
					else if(data.isHydrapulperCol7() == false) 
					{
						util.addValue(row, col++, "No",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					}else
					{
						util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					}
					util.addValue(row, col++, data.getHydrapulperCol7Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					
					
					
					
					util.addValue(row, col++, data.getHydrapulperCol8Inbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					util.addValue(row, col++, data.getHydrapulperCol8outbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					util.addValue(row, col++, data.getHydrapulperCol8Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					
					
					
					
					if(data.isHydrapulperCol9() == true)
					{
						util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
					}
					else if(data.isHydrapulperCol9() == false) 
					{
						util.addValue(row, col++, "No",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					}else
					{
						util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					}
					util.addValue(row, col++, data.getHydrapulperCol9Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					
			  		
					
					util.addValue(row, col++, data.getHydrapulperCol10Inbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					util.addValue(row, col++, data.getHydrapulperCol10outbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					util.addValue(row, col++, data.getHydrapulperCol10Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					
					
					
					if(data.isHydrapulperCol11() == true)
					{
						util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
					}
					else if(data.isHydrapulperCol11() == false) 
					{
						util.addValue(row, col++, "No",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					}else
					{
						util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					}
					util.addValue(row, col++, data.getHydrapulperCol11Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					
					
					
					
					if(data.isHydrapulperCol12() == true)
					{
						util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
					}
					else if(data.isHydrapulperCol12() == false) 
					{
						util.addValue(row, col++, "No",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					}else
					{
						util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					}
					util.addValue(row, col++, data.getHydrapulperCol12Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					
					
					if(data.isHydrapulperCol13() == true)
					{
						util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
					}
					else if(data.isHydrapulperCol13() == false) 
					{
						util.addValue(row, col++, "No",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					}else
					{
						util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					}
					util.addValue(row, col++, data.getHydrapulperCol13Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					
					
					
					util.addValue(row, col++, data.getHydrapulperCol14Inbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					util.addValue(row, col++, data.getHydrapulperCol14outbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					util.addValue(row, col++, data.getHydrapulperCol14Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					
					
					
					if(data.isHydrapulperCol15() == true)
					{
						util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
					}
					else if(data.isHydrapulperCol15() == false) 
					{
						util.addValue(row, col++, "No",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					}else
					{
						util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					}
					util.addValue(row, col++, data.getHydrapulperCol15Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					
					
					
					util.addValue(row, col++, data.getHydrapulperCol16Inbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					util.addValue(row, col++, data.getHydrapulperCol16outbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					util.addValue(row, col++, data.getHydrapulperCol16Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					
					
					util.addValue(row, col++, data.getDesccol1(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					util.addValue(row, col++, data.getDesccol1Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
					 
					

					row++;
			}
		 
			col = 0;
			util.addValue(row+2, col++, "OBCC Completed = "+l+"%",Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeight);
			
		util.write(outputStream);
	
	}
	
	
public void getExcelReportForMachineTender(List<MachineTender> dayoperatordata,List<MachineTender> nightoperatordata, File file, ServletOutputStream outputStream,long l) throws IOException {
		
	Workbook2007Util util = new Workbook2007Util(file,0);
	 	
	util.setSheetName("Machine Tender", 0);
	  
	
	short rowHeight = 280;
	short rowHeightHeader = 900;
	int row=3;
	int col=0;


	for(MachineTender data:dayoperatordata){
		col =0;
		 if(data.isMachinedown())
			   util.addValue(row, col++, "YES", Workbook2007Util.Style.STYLE_NORMAL_CENTER_RED, rowHeight);
		   else
			   util.addValue(row, col++,"NO", Workbook2007Util.Style.STYLE_NORMAL_CENTER_GREEN, rowHeight); 
		 	util.addValue(row, col++, data.getEdate(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_GREEN, rowHeight);
			util.addValue(row, col++, CommonUtil.capitalizeFirstLetter(data.getPosition()), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.capitalizeFirstLetter(data.getShift()), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, data.getCrew(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
	 		 
			  
			
			util.addValue(row, col++, data.getFormingSectionCol1(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);	
			util.addValue(row, col++, data.getFormingSectionCol1Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			
			util.addValue(row, col++, data.getFormingSectionCol2(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);	
			util.addValue(row, col++, data.getFormingSectionCol2Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			util.addValue(row, col++, data.getFormingSectionCol3(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);	
			util.addValue(row, col++, data.getFormingSectionCol3Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			util.addValue(row, col++, data.getFormingSectionCol4(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);	
			util.addValue(row, col++, data.getFormingSectionCol4Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			util.addValue(row, col++, data.getFormingSectionCol5(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);	
			util.addValue(row, col++, data.getFormingSectionCol5Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			util.addValue(row, col++, data.getFormingSectionCol6(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);	
			util.addValue(row, col++, data.getFormingSectionCol6Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			util.addValue(row, col++, data.getFormingSectionCol7(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);	
			util.addValue(row, col++, data.getFormingSectionCol7Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			util.addValue(row, col++, data.getFormingSectionCol8(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);	
			util.addValue(row, col++, data.getFormingSectionCol8Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			util.addValue(row, col++, data.getFormingSectionCol9(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);	
			util.addValue(row, col++, data.getFormingSectionCol9Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			util.addValue(row, col++, data.getFormingSectionCol10(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);	
			util.addValue(row, col++, data.getFormingSectionCol10Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			util.addValue(row, col++, data.getFormingSectionCol11(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);	
			util.addValue(row, col++, data.getFormingSectionCol11Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			util.addValue(row, col++, data.getFormingSectionCol12(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);	
			util.addValue(row, col++, data.getFormingSectionCol12Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			 
			
			
			
			if(data.isFormingSectionCol13() == true)
			{
				util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isFormingSectionCol13() == false) 
			{
				util.addValue(row, col++, "No",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			
			util.addValue(row, col++, data.getFormingSectionCol13Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			if(data.isFormingSectionCol14() == true)
			{
				util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isFormingSectionCol14() == false) 
			{
				util.addValue(row, col++, "No",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			
			util.addValue(row, col++, data.getFormingSectionCol14Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			//section
			
			util.addValue(row, col++, data.getSuctionPressureRollCol1(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);	
			util.addValue(row, col++, data.getSuctionPressureRollCol1Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			util.addValue(row, col++, data.getSuctionPressureRollCol2(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);	
			util.addValue(row, col++, data.getSuctionPressureRollCol2Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			util.addValue(row, col++, data.getSuctionPressureRollCol3(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);	
			util.addValue(row, col++, data.getSuctionPressureRollCol3Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getSuctionPressureRollCol4(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);	
			util.addValue(row, col++, data.getSuctionPressureRollCol4Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getSuctionPressureRollCol5(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);	
			util.addValue(row, col++, data.getSuctionPressureRollCol5Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getSuctionPressureRollCol6(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);	
			util.addValue(row, col++, data.getSuctionPressureRollCol6Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			 
			
			if(data.isSuctionPressureRollCol7() == true)
			{
				util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isSuctionPressureRollCol7() == false) 
			{
				util.addValue(row, col++, "No",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			
			util.addValue(row, col++, data.getSuctionPressureRollCol7Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			//yankee dryer
			
			
			util.addValue(row, col++, data.getYankeeDryerCol1(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);	
			util.addValue(row, col++, data.getYankeeDryerCol1Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			util.addValue(row, col++, data.getYankeeDryerCol2(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);	
			util.addValue(row, col++, data.getYankeeDryerCol2Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			
			if(data.isYankeeDryerCol3() == true)
			{
				util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isYankeeDryerCol3() == false) 
			{
				util.addValue(row, col++, "No",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			
			util.addValue(row, col++, data.getYankeeDryerCol3Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			util.addValue(row, col++, data.getYankeeDryerCol4(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);	
			util.addValue(row, col++, data.getYankeeDryerCol4Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			
			if(data.isYankeeDryerCol5() == true)
			{
				util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isYankeeDryerCol5() == false) 
			{
				util.addValue(row, col++, "No",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			util.addValue(row, col++, data.getYankeeDryerCol5Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			//Drive Roll
			
			
			
			util.addValue(row, col++, data.getDriveRollCol1(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);	
			util.addValue(row, col++, data.getDriveRollCol1Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			util.addValue(row, col++, data.getDriveRollCol2(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);	
			util.addValue(row, col++, data.getDriveRollCol2Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getDriveRollCol3(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);	
			util.addValue(row, col++, data.getDriveRollCol3Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getDriveRollCol4(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);	
			util.addValue(row, col++, data.getDriveRollCol4Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getDriveRollCol5(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);	
			util.addValue(row, col++, data.getDriveRollCol5Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getDriveRollCol6(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);	
			util.addValue(row, col++, data.getDriveRollCol6Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getDriveRollCol7(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);	
			util.addValue(row, col++, data.getDriveRollCol7Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			
			//press Section
			
			util.addValue(row, col++, data.getPressSectionCol1(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);	
			util.addValue(row, col++, data.getPressSectionCol1Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			util.addValue(row, col++, data.getPressSectionCol2(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);	
			util.addValue(row, col++, data.getPressSectionCol2Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getPressSectionCol3(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);	
			util.addValue(row, col++, data.getPressSectionCol3Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getPressSectionCol4(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);	
			util.addValue(row, col++, data.getPressSectionCol4Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, data.getPressSectionCol5(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);	
			util.addValue(row, col++, data.getPressSectionCol5Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			 
			

			if(data.isPressSectionCol6() == true)
			{
				util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isPressSectionCol6() == false) 
			{
				util.addValue(row, col++, "No",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			util.addValue(row, col++, data.getPressSectionCol6Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			util.addValue(row, col++, data.getPressSectionCol7(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);	
			util.addValue(row, col++, data.getPressSectionCol7Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			if(data.isPressSectionCol8() == true)
			{
				util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isPressSectionCol8() == false) 
			{
				util.addValue(row, col++, "No",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			util.addValue(row, col++, data.getPressSectionCol8Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight); 
			
			//upper presss
			
			util.addValue(row, col++, data.getUpperPressCol1(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);	
			util.addValue(row, col++, data.getUpperPressCol1Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			util.addValue(row, col++, data.getUpperPressCol2(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);	
			util.addValue(row, col++, data.getUpperPressCol2Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			if(data.isUpperPressCol3() == true)
			{
				util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isUpperPressCol3() == false) 
			{
				util.addValue(row, col++, "No",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			util.addValue(row, col++, data.getUpperPressCol3Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight); 
			
			if(data.isUpperPressCol4() == true)
			{
				util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isUpperPressCol4() == false) 
			{
				util.addValue(row, col++, "No",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			util.addValue(row, col++, data.getUpperPressCol4Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight); 
			
			if(data.isUpperPressCol5() == true)
			{
				util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isUpperPressCol5() == false) 
			{
				util.addValue(row, col++, "No",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			util.addValue(row, col++, data.getUpperPressCol5Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight); 
			
			if(data.isUpperPressCol6() == true)
			{
				util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isUpperPressCol6() == false) 
			{
				util.addValue(row, col++, "No",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			util.addValue(row, col++, data.getUpperPressCol6Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight); 
			


			if(data.isUpperPressCol7() == true)
			{
				util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isUpperPressCol7() == false) 
			{
				util.addValue(row, col++, "No",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			util.addValue(row, col++, data.getUpperPressCol7Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight); 
			
			if(data.isUpperPressCol8() == true)
			{
				util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isUpperPressCol8() == false) 
			{
				util.addValue(row, col++, "No",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			util.addValue(row, col++, data.getUpperPressCol8Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight); 
			
			if(data.getUpperPressCol9()!=null)
			{
				util.addValue(row, col++,data.getUpperPressCol9(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			util.addValue(row, col++, data.getUpperPressCol9Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight); 
			
			//chemical
			
			
			
			util.addValue(row, col++, data.getChemicalTotesCol1(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);	
			util.addValue(row, col++, data.getChemicalTotesCol1Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			util.addValue(row, col++, data.getChemicalTotesCol2(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);	
			util.addValue(row, col++, data.getChemicalTotesCol2Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			util.addValue(row, col++, data.getChemicalTotesCol3(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);	
			util.addValue(row, col++, data.getChemicalTotesCol3Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			util.addValue(row, col++, data.getChemicalTotesCol4(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);	
			util.addValue(row, col++, data.getChemicalTotesCol4Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
		
			util.addValue(row, col++, data.getChemicalTotesCol5(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);	
			util.addValue(row, col++, data.getChemicalTotesCol5Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			
			//last shift Desc
			
			
			
			
			if(data.isFillupcentcol1() == true)
			{
				util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isFillupcentcol1() == false) 
			{
				util.addValue(row, col++, "No",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			util.addValue(row, col++, data.getFillupcentcol1Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			
			if(data.isFillupcentcol2() == true)
			{
				util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isFillupcentcol2() == false) 
			{
				util.addValue(row, col++, "No",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			util.addValue(row, col++, data.getFillupcentcol2Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			
			if(data.isFillupcentcol4() == true)
			{
				util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isFillupcentcol4() == false) 
			{
				util.addValue(row, col++, "No",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}
			util.addValue(row, col++, data.getFillupcentcol4Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			if(data.isFillupcentcol3() == true)
			{
				util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
			}
			else if(data.isFillupcentcol3() == false) 
			{
				util.addValue(row, col++, "No",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}else
			{
				util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			}	
			util.addValue(row, col++, data.getFillupcentcol5Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			util.addValue(row, col++, data.getFillupcentcol6(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);	
			util.addValue(row, col++, data.getFillupcentcol6Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			util.addValue(row, col++, data.getFillupcentcol7(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);	
			util.addValue(row, col++, data.getFillupcentcol7Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
		 
			
		 
		row++;
	}
	
	 row = row+2;
	 col=0;
	 util.addValue(row, col++, "Machine Down", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);	
	 util.addValue(row, col++, "Date", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
	 util.addValue(row, col++, "Position", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
	 util.addValue(row, col++, "Shift", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);
	 util.addValue(row, col++, "Crew", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeightHeader);	
	
	 util.addValue(row, col++, "Fan Pump sealing water", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
	 util.addValue(row, col++, "Description", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
	
	 util.addValue(row, col++, "Fan pump Gearbox", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
	 util.addValue(row, col++, "Description", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
	 
	 util.addValue(row, col++, "Fan pump Gearbox Temprature West", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
	 util.addValue(row, col++, "Fan pump Gearbox Temprature East", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
	 util.addValue(row, col++, "Description", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
	 
	 
	 util.addValue(row, col++, "Fan Pump Moter Temprature Inbound", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
	 util.addValue(row, col++, "Fan Pump Moter Temprature Outbound", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
	 util.addValue(row, col++, "Description", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
	 
	 
	 util.addValue(row, col++, "Inlet Pressure", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
	 util.addValue(row, col++, "Description", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
	 
	 util.addValue(row, col++, "Outlet Pressure", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
	 util.addValue(row, col++, "Description", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
	 
	 util.addValue(row, col++, "#1 Selectifier screen North", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
	 util.addValue(row, col++, "Description", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
	 
	 util.addValue(row, col++, "#1 Selectifier screen North Motor Temprature West ", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
	 util.addValue(row, col++, "#1 Selectifier screen North Motor Temprature East ", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
	 util.addValue(row, col++, "Description", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
	 
	 util.addValue(row, col++, "#2 Selectifier screen South", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
	 util.addValue(row, col++, "Description", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
	 
	 util.addValue(row, col++, "#2 Selectifier screen South Motor Temprature West", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
	 util.addValue(row, col++, "#2 Selectifier screen South Motor Temprature East", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
	 util.addValue(row, col++, "Description", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
	 
	 
	 
	 util.addValue(row, col++, "Lube oil area", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
	 util.addValue(row, col++, "Description", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
	 
	 util.addValue(row, col++, "#1 Lube pump North", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
	 util.addValue(row, col++, "Description", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
	 
	 
	 util.addValue(row, col++, "#1 Lube pump North Motor Temprature North", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
	 util.addValue(row, col++, "#1 Lube pump North Motor Temprature South", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
	 util.addValue(row, col++, "Description", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
	 
	 
	 util.addValue(row, col++, "#2 Lube pump South", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
	 util.addValue(row, col++, "Description", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
	 
	 
	 util.addValue(row, col++, "#2 Lube pump South Motor Temprature North", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
	 util.addValue(row, col++, "#2 Lube pump South Motor Temprature South", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
	 util.addValue(row, col++, "Description", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
	 
	 util.addValue(row, col++, "Vacuum pump motor 100 Hp", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
	 util.addValue(row, col++, "Description", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
	 
	 
	 util.addValue(row, col++, "Vacuum pump motor 100 Hp", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
	 util.addValue(row, col++, "Description", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
	 
	 util.addValue(row, col++, "Vacuum pump#8", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
	 util.addValue(row, col++, "Description", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
	 
	 
	 util.addValue(row, col++, "Vacuum pump#8 bearing (North) Inbound", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
	 util.addValue(row, col++, "Vacuum pump#8 bearing (North) Outbound", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
	 util.addValue(row, col++, "Description", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
	 
	 
	 util.addValue(row, col++, "Vacuum pump#8 bearing (South) Inbound", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
	 util.addValue(row, col++, "Vacuum pump#8 bearing (South) Outbound", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
	 util.addValue(row, col++, "Description", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
	 
	 
	 util.addValue(row, col++, "Vacuum pump motor 1500 Hp", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
	 util.addValue(row, col++, "Description", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
	 
	 
	 util.addValue(row, col++, "Vacuum pump motor 1500 Hp Temprature North", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
	 util.addValue(row, col++, "Vacuum pump motor 1500 Hp Temprature South ", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
	 util.addValue(row, col++, "Description", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
	 
	 
	 util.addValue(row, col++, "Vacuum pump#02", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
	 util.addValue(row, col++, "Description", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
	 
	 
	 util.addValue(row, col++, "Vacuum pump#02 bearing (North)", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
	 util.addValue(row, col++, "Description", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
	 
	 util.addValue(row, col++, "Vacuum pump#02 bearing (South)", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
	 util.addValue(row, col++, "Description", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
	 
	 util.addValue(row, col++, "Vacuum pump#03", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
	 util.addValue(row, col++, "Description", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
	 
	 util.addValue(row, col++, "Vacuum pump#03 bearing (North)", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
	 util.addValue(row, col++, "Description", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
	 
	 
	 util.addValue(row, col++, "Vacuum pump#03 bearing (South)", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
	 util.addValue(row, col++, "Description", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
	 
	 util.addValue(row, col++, "Vacuum pump motor 1750 Hp", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
	 util.addValue(row, col++, "Description", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
	 
	 
	 util.addValue(row, col++, "Vacuum pump motor 1750 HpTemprature North", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
	 util.addValue(row, col++, "Vacuum pump motor 1750 HpTemprature South ", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
	 util.addValue(row, col++, "Description", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
	 
	 
	 util.addValue(row, col++, "Vacuum pump#11", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
	 util.addValue(row, col++, "Description", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
	 
	 
	 util.addValue(row, col++, "Vacuum pump#11 bearing (North)", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
	 util.addValue(row, col++, "Description", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
	 
	 
	 util.addValue(row, col++, "Vacuum pump#11 bearing (South)", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
	 util.addValue(row, col++, "Description", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
	 
	  
	 util.addValue(row, col++, "Vacuum pump#12", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
	 util.addValue(row, col++, "Description", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
	 
	 
	 
	 util.addValue(row, col++, "Vacuum pump#12 bearing (North)", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
	 util.addValue(row, col++, "Description", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
	 
	 
	 util.addValue(row, col++, "Vacuum pump#12 bearing (South)", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
	 util.addValue(row, col++, "Description", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
	 
	 util.addValue(row, col++, "Vacuum pump#13", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
	 util.addValue(row, col++, "Description", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
	 
	 util.addValue(row, col++, "Vacuum pump#13 bearing (North)", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
	 util.addValue(row, col++, "Description", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
	 
	 
	 util.addValue(row, col++, "Vacuum pump#13 bearing (South)", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
	 util.addValue(row, col++, "Description", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
	
	 
	 util.addValue(row, col++, "Vacuum pump#14", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
	 util.addValue(row, col++, "Description", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
	 
	 util.addValue(row, col++, "Vacuum pump#14 bearing (North)", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
	 util.addValue(row, col++, "Description", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
	 
	 
	 util.addValue(row, col++, "Vacuum pump#14 bearing (South)", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
	 util.addValue(row, col++, "Description", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
	 
	 
	 
	 util.addValue(row, col++, "Vacuum pump#15", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
	 util.addValue(row, col++, "Description", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
	 
	 util.addValue(row, col++, "Vacuum pump#15 bearing (North)", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
	 util.addValue(row, col++, "Description", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
	 
	 
	 util.addValue(row, col++, "Vacuum pump#15 bearing (South)", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
	 util.addValue(row, col++, "Description", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
	 
	 
	 util.addValue(row, col++, "Vacuum pump#16", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
	 util.addValue(row, col++, "Description", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
	 
	 util.addValue(row, col++, "Vacuum pump#16 bearing (North)", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
	 util.addValue(row, col++, "Description", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
	 
	 
	 util.addValue(row, col++, "Vacuum pump#16 bearing (South)", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
	 util.addValue(row, col++, "Description", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
	 
	 
	 util.addValue(row, col++, "Vacuum pump#17", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
	 util.addValue(row, col++, "Description", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
	 
	 util.addValue(row, col++, "Vacuum pump#17 bearing (North)", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
	 util.addValue(row, col++, "Description", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
	 
	 
	 util.addValue(row, col++, "Vacuum pump#17 bearing (South)", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
	 util.addValue(row, col++, "Description", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
	 
	 
	 util.addValue(row, col++, "River water strainer", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
	 util.addValue(row, col++, "Description", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
	 
	 
	 util.addValue(row, col++, "River water filter", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
	 util.addValue(row, col++, "Description", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
	 
	 util.addValue(row, col++, "#2 Fresh Water booster pump", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
	 util.addValue(row, col++, "Description", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
	 
	 util.addValue(row, col++, "#2 Fresh Water booster pump Motor Temprature North", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
	 util.addValue(row, col++, "#2 Fresh Water booster pump Motor Temprature South", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
	 util.addValue(row, col++, "Description", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
	 
	 
	 util.addValue(row, col++, "#3 Fresh Water booster pump", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
	 util.addValue(row, col++, "Description", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
	 
	 
	 util.addValue(row, col++, "#3 Fresh Water booster pump Motor Temprature North", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
	 util.addValue(row, col++, "#3 Fresh Water booster pump Motor Temprature South", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
	 util.addValue(row, col++, "Description", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
	 
	 
	 util.addValue(row, col++, "HP Shower Pump", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
	 util.addValue(row, col++, "Description", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
	 
	 util.addValue(row, col++, "HP Shower Pump Motor Temprature Inbound", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
	 util.addValue(row, col++, "HP Shower Pump Motor Temprature Outbound", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
	 util.addValue(row, col++, "Description", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
	 
	 
	 util.addValue(row, col++, "HP Shower pump filter", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
	 util.addValue(row, col++, "Description", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
	 
	 
	 util.addValue(row, col++, "Fill up Centerline sheets", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
	 util.addValue(row, col++, "Description", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
	 
	 
	 util.addValue(row, col++, "Logbook update with M/c adjustments and process changes during the shift", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
	 util.addValue(row, col++, "Description", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
	 
	 
	 util.addValue(row, col++, "Wash M/c floors from the of after dryers to refiners", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
	 util.addValue(row, col++, "Description", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
	 
	 util.addValue(row, col++, "Clean control room", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
	 util.addValue(row, col++, "Description", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
	 
	 
	 util.addValue(row, col++, "Empty all wet end trash cans ", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
	 util.addValue(row, col++, "Description", Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeightHeader);
	 
	 
	 row = row+1;
	 
	 for(MachineTender data:nightoperatordata){
			col =0;
				 if(data.isMachinedown()==true)				
					util.addValue(row, col++, "YES", Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
				else
					util.addValue(row, col++, "NO", Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			
			 	util.addValue(row, col++, data.getEdate(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_GREEN, rowHeight);
				util.addValue(row, col++, CommonUtil.capitalizeFirstLetter(data.getPosition()), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
				util.addValue(row, col++, CommonUtil.capitalizeFirstLetter(data.getShift()), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
				util.addValue(row, col++, data.getCrew(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
		 		 
		 	 
				
				
				util.addValue(row, col++, data.getFanPumpCol1(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getFanPumpCol1Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				
				if(data.isFanPumpCol2() == true)
				{
					util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
				}
				else if(data.isFanPumpCol2() == false) 
				{
					util.addValue(row, col++, "No",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}else
				{
					util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}
				util.addValue(row, col++, data.getFanPumpCol2Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight); 
				
			
				util.addValue(row, col++, data.getFanPumpCol3Inbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getFanPumpCol3Outbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getFanPumpCol3Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				
				
				util.addValue(row, col++, data.getFanPumpCol4Inbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getFanPumpCol4Outbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getFanPumpCol4Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				
				
				util.addValue(row, col++, data.getSelectifierScreenCol1(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getSelectifierScreenCol1Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				util.addValue(row, col++, data.getSelectifierScreenCol2(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getSelectifierScreenCol2Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				util.addValue(row, col++, data.getSelectifierScreenCol3(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getSelectifierScreenCol3Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				

				util.addValue(row, col++, data.getSelectifierScreenCol4Inbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getSelectifierScreenCol4Outbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getSelectifierScreenCol4Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				
				util.addValue(row, col++, data.getSelectifierScreenCol5(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getSelectifierScreenCol5Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				
				util.addValue(row, col++, data.getSelectifierScreenCol6Inbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getSelectifierScreenCol6Outbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getSelectifierScreenCol6Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				
				
				util.addValue(row, col++, data.getSelectifierScreenCol7(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getSelectifierScreenCol7Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				
				
				
				if(data.isSelectifierScreenCol8() == true)
				{
					util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
				}
				else if(data.isSelectifierScreenCol8() == false) 
				{
					util.addValue(row, col++, "No",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}else
				{
					util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}
				util.addValue(row, col++, data.getSelectifierScreenCol8Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight); 
				
				
				
				util.addValue(row, col++, data.getSelectifierScreenCol9Inbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getSelectifierScreenCol9Outbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getSelectifierScreenCol9Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				if(data.isSelectifierScreenCol10() == true)
				{
					util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
				}
				else if(data.isFormingSectionCol13() == false) 
				{
					util.addValue(row, col++, "No",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}else
				{
					util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}
				util.addValue(row, col++, data.getSelectifierScreenCol10Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight); 
				 
				
				util.addValue(row, col++, data.getSelectifierScreenCol11Inbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getSelectifierScreenCol11Outbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getSelectifierScreenCol11Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				
				
				

				if(data.isVacumePumpCol1() == true)
				{
					util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
				}
				else if(data.isVacumePumpCol1() == false) 
				{
					util.addValue(row, col++, "No",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}else
				{
					util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}
				util.addValue(row, col++, data.getVacumePumpCol1Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight); 
				
				
				if(data.isVacumePumpCol2() == true)
				{
					util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
				}
				else if(data.isVacumePumpCol2() == false) 
				{
					util.addValue(row, col++, "No",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}else
				{
					util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}
				util.addValue(row, col++, data.getVacumePumpCol2Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight); 
				 
				
				
				if(data.isVacumePumpCol3() == true)
				{
					util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
				}
				else if(data.isVacumePumpCol3() == false) 
				{
					util.addValue(row, col++, "No",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}else
				{
					util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}
				util.addValue(row, col++, data.getVacumePumpCol3Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				 
				
				
				util.addValue(row, col++, data.getVacumePumpCol4Inbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getVacumePumpCol4Outbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getVacumePumpCol4Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				
				util.addValue(row, col++, data.getVacumePumpCol5Inbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getVacumePumpCol5Outbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getVacumePumpCol5Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				
				

				if(data.isVacumePumpCol6() == true)
				{
					util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
				}
				else if(data.isVacumePumpCol6() == false) 
				{
					util.addValue(row, col++, "No",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}else
				{
					util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}
				util.addValue(row, col++, data.getVacumePumpCol6Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight); 
				
				
				util.addValue(row, col++, data.getVacumePumpCol7Inbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getVacumePumpCol7Outbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getVacumePumpCol7Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				
				if(data.isVacumePumpCol8() == true)
				{
					util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
				}
				else if(data.isVacumePumpCol8() == false) 
				{
					util.addValue(row, col++, "No",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}else
				{
					util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}
				util.addValue(row, col++, data.getVacumePumpCol8Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				 
				util.addValue(row, col++, data.getVacumePumpCol9(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getVacumePumpCol9Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				
				util.addValue(row, col++, data.getVacumePumpCol10(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getVacumePumpCol10Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				
				
				if(data.isVacumePumpCol11() == true)
				{
					util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
				}
				else if(data.isVacumePumpCol11() == false) 
				{
					util.addValue(row, col++, "No",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}else
				{
					util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}
				util.addValue(row, col++, data.getVacumePumpCol11Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				 
				util.addValue(row, col++, data.getVacumePumpCol12(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getVacumePumpCol12Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				 
				util.addValue(row, col++, data.getVacumePumpCol13(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getVacumePumpCol13Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				if(data.isVacumePumpCol14() == true)
				{
					util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
				}
				else if(data.isVacumePumpCol14() == false) 
				{
					util.addValue(row, col++, "No",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}else
				{
					util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}
				util.addValue(row, col++, data.getVacumePumpCol14Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight); 
				
				
				util.addValue(row, col++, data.getVacumePumpCol15Inbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getVacumePumpCol15Outbound(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getVacumePumpCol15Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				
				
				if(data.isVacumePumpCol16() == true)
				{
					util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
				}
				else if(data.isVacumePumpCol16() == false) 
				{
					util.addValue(row, col++, "No",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}else
				{
					util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}
				util.addValue(row, col++, data.getVacumePumpCol16Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				 
				
				util.addValue(row, col++, data.getVacumePumpCol17(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getVacumePumpCol17Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				
				util.addValue(row, col++, data.getVacumePumpCol18(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getVacumePumpCol18Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				
				
				if(data.isVacumePumpCol19() == true)
				{
					util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
				}
				else if(data.isVacumePumpCol19() == false) 
				{
					util.addValue(row, col++, "No",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}else
				{
					util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}
				util.addValue(row, col++, data.getVacumePumpCol19Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				 
				util.addValue(row, col++, data.getVacumePumpCol20(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getVacumePumpCol20Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				 
				util.addValue(row, col++, data.getVacumePumpCol21(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getVacumePumpCol21Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				
				
				if(data.isVacumePumpCol22() == true)
				{
					util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
				}
				else if(data.isVacumePumpCol22() == false) 
				{
					util.addValue(row, col++, "No",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}else
				{
					util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}
				util.addValue(row, col++, data.getVacumePumpCol22Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				 
				
				util.addValue(row, col++, data.getVacumePumpCol23(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getVacumePumpCol23Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				
				util.addValue(row, col++, data.getVacumePumpCol24(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getVacumePumpCol24Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				
				
				if(data.isVacumePumpCol25() == true)
				{
					util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
				}
				else if(data.isVacumePumpCol25() == false) 
				{
					util.addValue(row, col++, "No",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}else
				{
					util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}
				util.addValue(row, col++, data.getVacumePumpCol25Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				 
				util.addValue(row, col++, data.getVacumePumpCol26(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getVacumePumpCol26Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				util.addValue(row, col++, data.getVacumePumpCol27(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getVacumePumpCol27Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				
				if(data.isVacumePumpCol28() == true)
				{
					util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
				}
				else if(data.isVacumePumpCol28() == false) 
				{
					util.addValue(row, col++, "No",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}else
				{
					util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}
				util.addValue(row, col++, data.getVacumePumpCol28Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				 
				
				util.addValue(row, col++, data.getVacumePumpCol29(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getVacumePumpCol29Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				util.addValue(row, col++, data.getVacumePumpCol30(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getVacumePumpCol30Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				
				if(data.isVacumePumpCol31() == true)
				{
					util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
				}
				else if(data.isVacumePumpCol31() == false) 
				{
					util.addValue(row, col++, "No",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}else
				{
					util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}
				util.addValue(row, col++, data.getVacumePumpCol31Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				 
				util.addValue(row, col++, data.getVacumePumpCol32(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getVacumePumpCol32Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				util.addValue(row, col++, data.getVacumePumpCol33(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getVacumePumpCol33Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				
				if(data.isVacumePumpCol34() == true)
				{
					util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
				}
				else if(data.isVacumePumpCol34() == false) 
				{
					util.addValue(row, col++, "No",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}else
				{
					util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}
				util.addValue(row, col++, data.getVacumePumpCol34Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				 
				util.addValue(row, col++, data.getVacumePumpCol35(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getVacumePumpCol35Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				
				util.addValue(row, col++, data.getVacumePumpCol36(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getVacumePumpCol36Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				
				util.addValue(row, col++, data.getRiverWaterCol1(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getRiverWaterCol1Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				util.addValue(row, col++, data.getRiverWaterCol2(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getRiverWaterCol2Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				
				if(data.isShowercol1() == true)
				{
					util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
				}
				else if(data.isShowercol1() == false) 
				{
					util.addValue(row, col++, "No",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}else
				{
					util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}
				util.addValue(row, col++, data.getShowercol1Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight); 
				
				
				
				util.addValue(row, col++, data.getShowercol2North(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getShowercol2South(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getShowercol2Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				
				if(data.isShowercol3() == true)
				{
					util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
				}
				else if(data.isShowercol3() == false) 
				{
					util.addValue(row, col++, "No",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}else
				{
					util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}
				util.addValue(row, col++, data.getShowercol3Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight); 
				
				util.addValue(row, col++, data.getShowercol4North(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getShowercol4South(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getShowercol4Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				
				if(data.isShowercol5() == true)
				{
					util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
				}
				else if(data.isShowercol5() == false) 
				{
					util.addValue(row, col++, "No",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}else
				{
					util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}
				util.addValue(row, col++, data.getShowercol5Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight); 
				
				
				util.addValue(row, col++, data.getShowercol6North(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getShowercol6South(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getShowercol6Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				
				util.addValue(row, col++, data.getShowercol7(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				util.addValue(row, col++, data.getShowercol7Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				
				
				
				if(data.isFillupcentcol1() == true)
				{
					util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
				}
				else if(data.isFillupcentcol1() == false) 
				{
					util.addValue(row, col++, "No",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}else
				{
					util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}
				util.addValue(row, col++, data.getFillupcentcol1Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				
				
				if(data.isFillupcentcol2() == true)
				{
					util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
				}
				else if(data.isFillupcentcol2() == false) 
				{
					util.addValue(row, col++, "No",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}else
				{
					util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}
				util.addValue(row, col++, data.getFillupcentcol2Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				
				
				
				if(data.isFillupcentcol3() == true)
				{
					util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
				}
				else if(data.isFillupcentcol3() == false) 
				{
					util.addValue(row, col++, "No",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}else
				{
					util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}
				util.addValue(row, col++, data.getFillupcentcol3Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				
				if(data.isFillupcentcol4() == true)
				{
					util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
				}
				else if(data.isFillupcentcol4() == false) 
				{
					util.addValue(row, col++, "No",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}else
				{
					util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}
				util.addValue(row, col++, data.getFillupcentcol4Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				
				
				if(data.isFillupcentcol8() == true)
				{
					util.addValue(row, col++, "Yes",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);		
				}
				else if(data.isFillupcentcol8() == false) 
				{
					util.addValue(row, col++, "No",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}else
				{
					util.addValue(row, col++, "",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
				}
				util.addValue(row, col++, data.getFillupcentcol8Desc(),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			 
			
			row++;
			
		}
	 	col = 0;
	 	util.addValue(row+2, col++, "OBCC Completed = "+l+"%",Workbook2007Util.Style.STYLE_BOLD_JUSTIFY, rowHeight);
	util.write(outputStream);
	
	}

	public void getExcelReportbyPercentage(Map<Date, Double> operatordata,Map<Date, Double> backtenderoperatordata2,Map<Date, Double> machineoperatordata3,Map<Date, Double> stokeoperatordata4,
			Map<Date, Double> utilityoperatordata5,Map<Date, Double> r1operatordata,Map<Date, Double> avg,File file, ServletOutputStream outputStream) throws IOException {
		
		Workbook2007Util util = new Workbook2007Util(file,0);
		   
		
		
		short rowHeight = 280;
		int row=2;
		int col=0;
		
		for (Map.Entry<Date, Double> entry : backtenderoperatordata2.entrySet())
		{
			//String monthYear=getFormatedDateAndMonth(entry.getKey());	
			util.addValue(row, col++, CommonUtil.dateParseOrFormat(entry.getKey()),Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, entry.getValue()+"%",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			row++;
			col = 0;
			
		}
		row = 2;
		for (Map.Entry<Date, Double> entry : stokeoperatordata4.entrySet())
		{
			col=2;
			util.addValue(row, col++, entry.getValue()+"%",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			row++;
		}
		row = 2;
		for (Map.Entry<Date, Double> entry : machineoperatordata3.entrySet())
		{
			col=3;
			util.addValue(row, col++, entry.getValue()+"%",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			row++;
		}
		row = 2;
		for (Map.Entry<Date, Double> entry : r1operatordata.entrySet())
		{
			col=4;
			util.addValue(row, col++, entry.getValue()+"%",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			row++;
		}
		row = 2;
		for (Map.Entry<Date, Double> entry : operatordata.entrySet())
		{
			col=5;
			util.addValue(row, col++, entry.getValue()+"%",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			row++;
		}
		row = 2;
		for (Map.Entry<Date, Double> entry : utilityoperatordata5.entrySet())
		{
			col=6;
			util.addValue(row, col++, entry.getValue()+"%",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			row++;
		}
		row = 2;
		for (Map.Entry<Date, Double> entry : avg.entrySet())
		{
			col=7;
			util.addValue(row, col++, entry.getValue()+"%",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			row++;
		}
		
		util.write(outputStream);
	}

	/**
	 * @param key
	 * @return
	 */
	private String getFormatedDateAndMonth(String key) {
		// TODO Auto-generated method stub
		Date date1;
		String date="";
		Formatter fmt = new Formatter();
		try {
			date1 = dateFormat.parse(key);
			Calendar cal = Calendar.getInstance();
			cal.setTime(date1);

			int month = cal.get(Calendar.MONTH);
			int year = cal.get(Calendar.YEAR);
			
			fmt = new Formatter();
			//fmt.format("%tB %tb %tm", cal, cal, cal);
			fmt.format("%tb",cal);
		      
			System.out.println(fmt+"-"+year);
			date=""+fmt+"-"+year;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return date;
	}

	/**
	 * @param treeMap4
	 * @param treeMap1
	 * @param treeMap6
	 * @param treeMap5
	 * @param treeMap3
	 * @param treeMap2
	 * @param outputStream
	 */
	public void getExcelReportbyPercentageSecond(Map<Date, Double> operatordata,Map<Date, Double> backtenderoperatordata2,Map<Date, Double> machineoperatordata3,Map<Date, Double> stokeoperatordata4,
			Map<Date, Double> utilityoperatordata5,Map<Date, Double> r1operatordata,OutputStream outputStream) throws IOException {
		
		Workbook2007Util util=new Workbook2007Util();
		 
		int row=0;
		int col=0;
		short rowHeight1 = 900;
		
		util.addValue(row, col++,"Month", Workbook2007Util.Style.STYLE_NORMAL_CENTER_SkyColor, rowHeight1);
		util.addValue(row, col++,"Back Tender", Workbook2007Util.Style.STYLE_NORMAL_CENTER_SkyColor, rowHeight1);
		util.addValue(row, col++,"Stock Operator", Workbook2007Util.Style.STYLE_NORMAL_CENTER_SkyColor, rowHeight1);
		util.addValue(row, col++,"Machine Tender", Workbook2007Util.Style.STYLE_NORMAL_CENTER_SkyColor, rowHeight1);
		util.addValue(row, col++,"R1", Workbook2007Util.Style.STYLE_NORMAL_CENTER_SkyColor, rowHeight1);
		util.addValue(row, col++,"R2", Workbook2007Util.Style.STYLE_NORMAL_CENTER_SkyColor, rowHeight1);
		util.addValue(row, col++,"Utility Operator", Workbook2007Util.Style.STYLE_NORMAL_CENTER_SkyColor, rowHeight1);
		
		short rowHeight = 280;
		row=2;
		col=0;
		
		for (Map.Entry<Date, Double> entry : backtenderoperatordata2.entrySet())
		{
			//String monthYear=getFormatedDateAndMonth(entry.getKey());	
			util.addValue(row, col++, CommonUtil.dateParseOrFormat(entry.getKey()),Workbook2007Util.Style.STYLE_NORMAL_CENTER_GREEN, rowHeight);
			util.addValue(row, col++, entry.getValue()+"%",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			row++;
			col = 0;
			
		}
		row = 2;
		for (Map.Entry<Date, Double> entry : stokeoperatordata4.entrySet())
		{
			col=2;
			util.addValue(row, col++, entry.getValue()+"%",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			row++;
		}
		row = 2;
		for (Map.Entry<Date, Double> entry : machineoperatordata3.entrySet())
		{
			col=3;
			util.addValue(row, col++, entry.getValue()+"%",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			row++;
		}
		row = 2;
		for (Map.Entry<Date, Double> entry : r1operatordata.entrySet())
		{
			col=4;
			util.addValue(row, col++, entry.getValue()+"%",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			row++;
		}
		row = 2;
		for (Map.Entry<Date, Double> entry : operatordata.entrySet())
		{
			col=5;
			util.addValue(row, col++, entry.getValue()+"%",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			row++;
		}
		row = 2;
		for (Map.Entry<Date, Double> entry : utilityoperatordata5.entrySet())
		{
			col=6;
			util.addValue(row, col++, entry.getValue()+"%",Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			
			row++;
		}
		
		
		util.write(outputStream);
	}
}

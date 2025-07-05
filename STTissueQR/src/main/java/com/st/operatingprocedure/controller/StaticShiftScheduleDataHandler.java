/**
 *Apr 21, 2016
 *StaticShiftScheduleDataHandler.java
 * TODO
 *com.st.operatingprocedure.controller
 *StaticShiftScheduleDataHandler.java
 *Sunil Singh Bora
 */
package com.st.operatingprocedure.controller;

import java.io.File;
import java.io.IOException;

import jakarta.servlet.ServletOutputStream;

import org.springframework.stereotype.Component;

import com.st.common.Workbook2007Util;

/**
 * @author roshan
 *
 */
@Component
public class StaticShiftScheduleDataHandler {

	/**
	 * @param file
	 * @param outputStream
	 * @throws IOException 
	 */
	public void shiftscheduledownload1(File file,
			ServletOutputStream outputStream) throws IOException {
		// TODO Auto-generated method stub
		Workbook2007Util util = new Workbook2007Util(file,0);
		int row=1;
		int col=0;
		int lastcol=0;
		short rowHeight = 280;
		util.addValue(row, col, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		util.write(outputStream);
	}

}

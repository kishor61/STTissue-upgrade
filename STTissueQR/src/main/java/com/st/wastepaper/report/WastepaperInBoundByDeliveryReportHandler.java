/**
 *Oct 27, 2015
 *WastepaperInBoundByDeliveryReportHandler.java
 * TODO
 *com.st.wastepaper.report
 *WastepaperInBoundByDeliveryReportHandler.java
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
import com.st.wastepaper.model.WastepaperDetail;

/**
 * @author roshan
 *
 */
@Component
public class WastepaperInBoundByDeliveryReportHandler {

	/**
	 * @param details
	  * @param file
	 * @param outputStream
	 * @throws IOException 
	 */
	private SimpleDateFormat dateFormat=new SimpleDateFormat("MM-dd-yyyy");
	public void createwastepaperinboundbydeliveryreport(
			List<WastepaperDetail> details, File file, ServletOutputStream outputStream) throws IOException {
		// TODO Auto-generated method stub
		Workbook2007Util util=new Workbook2007Util(file,0);
		util.setSheetName("WastePaper In Bound By Delivery Report", 0);
		short rowHeight=280;
		
		int col=0;
		int row=2;
		for (WastepaperDetail wd : details) {
			col=0;
			util.addValue(row, col++, dateFormat.format(wd.getUnloadedDate()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, wd.getTotalbales(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			//util.addValue(row, col++, wd.getBalesondate(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, wd.getBales(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
//			util.addValue(row, col++, wd.getBalesondaterejected(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, wd.getEnroute(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
//			util.addValue(row, col++, wd.getBalesondatedeleted(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, wd.getBalesondaterejected(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			row++;
		}
		util.write(outputStream);
	}

}

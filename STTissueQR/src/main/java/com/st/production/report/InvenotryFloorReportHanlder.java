/**
 *Dec 11, 2014
 *InvenotryReportHanlder.java
 * TODO
 *com.st.production.report
 *InvenotryReportHanlder.java
 *Sunil Singh Bora
 */
package com.st.production.report;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import org.springframework.stereotype.Component;

import com.st.common.CommonUtil;
import com.st.common.Workbook2007Util;
import com.st.production.model.WrapperProduction;

/**
 * @author sbora
 *
 */
@Component
public class InvenotryFloorReportHanlder {

	/**
	 * @param productions
	 * @param outputStream
	 * @throws IOException 
	 */
	public void createExcelReport(List<WrapperProduction> productions,
			OutputStream outputStream) throws IOException {
		
		
		Workbook2007Util util=new Workbook2007Util();
		
		
		int row=0;
		int col=0;
		short rowHeight=280;
		
		util.addValue(row, col++, "Cust", Workbook2007Util.Style.STYLE_HEADER_01, rowHeight);
		util.addValue(row, col++, "Type Sort", Workbook2007Util.Style.STYLE_HEADER_01, rowHeight);
		util.addValue(row, col++, "Color", Workbook2007Util.Style.STYLE_HEADER_01, rowHeight);
		util.addValue(row, col++, "GradeCode", Workbook2007Util.Style.STYLE_HEADER_01, rowHeight);
		util.addValue(row, col++, "Customer Code", Workbook2007Util.Style.STYLE_HEADER_01, rowHeight);
		util.addValue(row, col++, "Roll Count", Workbook2007Util.Style.STYLE_HEADER_01, rowHeight);
		util.addValue(row, col++, "Core Size", Workbook2007Util.Style.STYLE_HEADER_01, rowHeight);
		util.addValue(row, col++, "Roll Width", Workbook2007Util.Style.STYLE_HEADER_01, rowHeight);
		util.addValue(row, col++, "Diameter", Workbook2007Util.Style.STYLE_HEADER_01, rowHeight);
		util.addValue(row, col++, "Ply", Workbook2007Util.Style.STYLE_HEADER_01, rowHeight);
		util.addValue(row, col++, "Tons", Workbook2007Util.Style.STYLE_HEADER_01, rowHeight);
		util.addValue(row, col++, "Grade", Workbook2007Util.Style.STYLE_HEADER_01, rowHeight);
		util.addValue(row, col++, "PO#", Workbook2007Util.Style.STYLE_HEADER_01, rowHeight);
		util.addValue(row, col++, "P/U #'s", Workbook2007Util.Style.STYLE_HEADER_01, rowHeight);
		
		for (WrapperProduction wrapperProduction : productions) {
			row++;
			col=0;
			
			util.addValue(row, col++, CommonUtil.checkNull(wrapperProduction.getCustomer()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, CommonUtil.checkNull(wrapperProduction.getShortType()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, CommonUtil.checkNull(wrapperProduction.getColor()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, CommonUtil.checkNull(wrapperProduction.getGradeCode()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, CommonUtil.checkNull(wrapperProduction.getCustomerGradeCode()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, wrapperProduction.getRollCount(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, CommonUtil.checkNull(wrapperProduction.getCoreSize()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, CommonUtil.checkNull(wrapperProduction.getRollWidth()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, CommonUtil.checkNull(wrapperProduction.getDiameter()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, wrapperProduction.getPly(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, CommonUtil.round(wrapperProduction.getWhiteWeight(), 4), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, CommonUtil.checkNull(wrapperProduction.getGrade()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, CommonUtil.checkNull(wrapperProduction.getPoNumber()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, CommonUtil.checkNull(wrapperProduction.getShippingNo()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		}
		
		
		for (int i = 0; i < 12; i++) {
			util.setAutoSizeColumn(i);
		}
		
		util.write(outputStream);
		
	}

}

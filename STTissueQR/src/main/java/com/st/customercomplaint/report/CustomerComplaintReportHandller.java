/**
 *Oct 28, 2015
 *CustomerComplaintReportHandller.java
 * TODO
 *com.st.customercomplaint.report
 *CustomerComplaintReportHandller.java
 *Sunil Singh Bora
 */
package com.st.customercomplaint.report;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

import jakarta.servlet.ServletOutputStream;

import org.springframework.stereotype.Component;

import productspecificationsignoffsheet.ProductSpecificationSignOffSheet;

import com.st.common.CommonUtil;
import com.st.common.Workbook2007Util;
import com.st.customercomplaint.model.CustomerComplaint;

/**
 * @author roshan
 *
 */
@Component
public class CustomerComplaintReportHandller {

	/**
	 * @param reportData
	 * @param file
	 * @param outputStream
	 */
	private SimpleDateFormat dateFormat=new SimpleDateFormat("MM-dd-yyyy");
	public void customercomplaintreportExport(
			List<CustomerComplaint> reportData, File file,
			ServletOutputStream outputStream) throws IOException {
		
		Workbook2007Util util = new Workbook2007Util(file,0);
		util.setSheetName("Customer Complaint Report", 0);
		short rowHeight = 280;
		int row=2;
		int col=0;
		int lastcol=0;
		for(CustomerComplaint cc:reportData)
		{
			col=0;
			lastcol=1;
			
			util.addValue(row, col++, dateFormat.format(cc.getDate()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, cc.getComplaintissue(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, cc.getDescription(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, cc.getGrade(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, cc.getCustomer(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, cc.getType(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, dateFormat.format(cc.getProddate()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, cc.getCorrectiveaction(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, cc.getRemarks(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, cc.getResp(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, dateFormat.format(cc.getTargetdate()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, cc.getStatus(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			row++;
		}
		util.write(outputStream);
	}
	/**
	 * @param datas
	 * @param outputStream
	 * @throws IOException 
	 */
	public void complaintCustomerReportSendMailFunction(List<CustomerComplaint> datas, FileOutputStream outputStream) throws IOException {
		// TODO Auto-generated method stub

		
		Workbook2007Util util = new Workbook2007Util();
		util.setSheetName("Customer Complaint Report", 0);
		short rowHeight = 280;
		int row=1;
			
		util.addValue(row, 0, "Customer Complaint Report", Workbook2007Util.Style.STYLE_HEADER_01, (short)400);
		util.mergeCell(row, row, 0, 11);
		row++;
		int col=0;
		util.addValue(row, col++, "Date", Workbook2007Util.Style.STYLE_NORMAL_CENTER_BORDER_f5da81, rowHeight);
		util.addValue(row, col++, "Complaint / Issue", Workbook2007Util.Style.STYLE_NORMAL_CENTER_BORDER_f5da81, rowHeight);
		util.addValue(row, col++, "Description", Workbook2007Util.Style.STYLE_NORMAL_CENTER_BORDER_f5da81, rowHeight);
		util.addValue(row, col++, "Grade", Workbook2007Util.Style.STYLE_NORMAL_CENTER_BORDER_f5da81, rowHeight);
		util.addValue(row, col++, "Customer", Workbook2007Util.Style.STYLE_NORMAL_CENTER_BORDER_f5da81, rowHeight);
		util.addValue(row, col++, "Type", Workbook2007Util.Style.STYLE_NORMAL_CENTER_BORDER_f5da81, rowHeight);
		util.addValue(row, col++, "Prod. Date", Workbook2007Util.Style.STYLE_NORMAL_CENTER_BORDER_f5da81, rowHeight);
		util.addValue(row, col++, "Corrective Action", Workbook2007Util.Style.STYLE_NORMAL_CENTER_BORDER_f5da81, rowHeight);
		util.addValue(row, col++, "Follow Up/Remarks", Workbook2007Util.Style.STYLE_NORMAL_CENTER_BORDER_f5da81, rowHeight);
		util.addValue(row, col++, "Resp", Workbook2007Util.Style.STYLE_NORMAL_CENTER_BORDER_f5da81, rowHeight);
		util.addValue(row, col++, "Target Date", Workbook2007Util.Style.STYLE_NORMAL_CENTER_BORDER_f5da81, rowHeight);
		util.addValue(row, col++, "Status", Workbook2007Util.Style.STYLE_NORMAL_CENTER_BORDER_f5da81, rowHeight);
		
		row++;
		 
		for(CustomerComplaint data:datas){
			col=0;
			util.addValue(row, col++, dateFormat.format(data.getDate()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, data.getComplaintissue(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, data.getDescription(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, data.getGrade(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, data.getCustomer(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, data.getType(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, dateFormat.format(data.getProddate()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, data.getCorrectiveaction(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, data.getRemarks(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, data.getResp(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, dateFormat.format(data.getTargetdate()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, data.getStatus(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			row++;
		}
		for (int i = 0; i <19; i++) {
			util.setAutoSizeColumn(i);
		}
		util.write(outputStream);
	
		
	}

}

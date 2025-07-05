/**
 *Aug 12, 2015
 *wastePaperByVandorReportHandler.java
 * TODO
 *com.st.wastepaper.report
 *wastePaperByVandorReportHandler.java
 *Sunil Singh Bora
 */
package com.st.wastepaper.report;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletOutputStream;

import org.springframework.stereotype.Component;

import com.st.common.CommonUtil;
import com.st.common.Workbook2007Util;
import com.st.wastepaper.model.WastePaperBaleInventory;
import com.st.wastepaper.model.WastepaperDetail;

/**
 * @author roshan
 *
 */
@Component
public class WastePaperByVandorReportHandler {

	/**
	 * @param details
	 * @param file
	 * @param outputStream
	 */
	private SimpleDateFormat dateFormat=new SimpleDateFormat("MM-dd-yyyy");
	public void getByVandorReport(List<WastepaperDetail> details, String vendorname, File file,
			ServletOutputStream outputStream) throws IOException {
		// TODO Auto-generated method stub
		Workbook2007Util util = new Workbook2007Util(file,0);
		short rowHeight = 280;
		int row=3;
		int col=0;
		
		int _totalBalesCount=0;
		String vandorName="";
		
		double netTonsTotal=0;
		double pricePerTonTotal=0;
		double extensionTotal=0;
		double freightInvociedTotal=0;
		double freightChbkTotal=0;
		String freightChbkPending="";
		double grandTotal=0;
		
		for(WastepaperDetail wpd:details){
			col=0;
			
			util.addValue(row, col++, wpd.getReceiptNo(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, wpd.getMasterPO(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, wpd.getReleaseNo(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, wpd.getVandorName(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			if(wpd.getDroppedDate()==null ||wpd.getUnloadedDate()==null){
				util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
				util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
				
			}else{
				util.addValue(row, col++, dateFormat.format(wpd.getDroppedDate()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
				util.addValue(row, col++, dateFormat.format(wpd.getUnloadedDate()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
					
			}
			util.addValue(row, col++, wpd.getItemDescription(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, CommonUtil.round(wpd.getBales(), 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, CommonUtil.round(wpd.getNetTons(), 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, "$"+CommonUtil.round(wpd.getPricePerTon(), 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, "$"+CommonUtil.round(wpd.getExtention(), 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, wpd.getCarrier(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, wpd.getTrailerNo(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, wpd.getShippingCity(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, wpd.getShippingState(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, "$"+CommonUtil.round(wpd.getEstimatedFreight(), 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, "$"+CommonUtil.round(wpd.getFreightInvoiced(), 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, "$"+CommonUtil.round(wpd.getFreightCHBK(), 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, "$"+CommonUtil.round(wpd.getGrandTotal(), 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, wpd.getDestination(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, wpd.getComment(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			//Code Starts From Here For Grand Total Done By Roshan Tailor
			
			
			
			row++;
			
		}
		List<WastepaperDetail> wastepaperDetails=new ArrayList<WastepaperDetail>();
		final WastepaperDetail wastepaperDetail=new WastepaperDetail();
		
		for(WastepaperDetail wp:details){
			_totalBalesCount=wp.getBales()+_totalBalesCount;
			wastepaperDetail.setTotalbales(_totalBalesCount);
			
			vandorName=wp.getVandorName();
			wastepaperDetail.setVandorName(vandorName);
			
			netTonsTotal=wp.getNetTons()+netTonsTotal;
			wastepaperDetail.setNetTons(netTonsTotal);
			
			pricePerTonTotal=wp.getPricePerTon()+pricePerTonTotal;
			wastepaperDetail.setPricePerTon(pricePerTonTotal);
			
			extensionTotal=wp.getExtention()+extensionTotal;
			//System.out.println(extensionTotal);
			wastepaperDetail.setExtention(extensionTotal);
			
			freightInvociedTotal=wp.getFreightInvoiced()+freightInvociedTotal;
			wastepaperDetail.setFreightInvoiced(freightInvociedTotal);
			
			freightChbkTotal=wp.getFreightCHBK()+freightChbkTotal;
			wastepaperDetail.setFreightCHBK(freightChbkTotal);
			
			grandTotal=wp.getGrandTotal()+grandTotal;
			wastepaperDetail.setGrandTotal(grandTotal);
			
			wastepaperDetails.add(wastepaperDetail);
				
		}
		col=0;
		util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		if(vendorname==""){
		util.addValue(row, col++, "Total", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		}else{
		util.addValue(row, col++, ""+vandorName+" Total", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		}
		util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(row, col++, CommonUtil.round(_totalBalesCount, 2), Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(row, col++, CommonUtil.round(netTonsTotal, 2), Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(row, col++, "$"+CommonUtil.round(pricePerTonTotal, 2), Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(row, col++, "$"+CommonUtil.round(extensionTotal, 2), Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(row, col++, "$"+CommonUtil.round(freightInvociedTotal, 2), Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(row, col++, "$"+CommonUtil.round(freightChbkTotal, 2), Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(row, col++, "$"+CommonUtil.round(grandTotal, 2), Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		
		util.write(outputStream);
		
	}

}

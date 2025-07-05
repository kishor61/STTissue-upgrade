
package com.st.wastepaper.report;

import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.stereotype.Component;

import com.st.common.CommonUtil;
import com.st.common.Workbook2007Util;
import com.st.wastepaper.model.WastepaperDetail;

/**
 * @author roshan
 *
 */
@Component
public class WastepaperReportHandler {

	/**
	 * @param details
	 * @param outputStream
	 * @throws IOException 
	 */
	public void createWastepaperDetailReport(List<WastepaperDetail> details,
			OutputStream outputStream) throws IOException {
		
		Workbook2007Util util=new Workbook2007Util();
		
		short rowHeight=280;
		
		int col=0;
		int row=0;
		
		//util.addValue(row, col++, "Receipt No", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(row, col++, "MasterPO", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(row, col++, "Release No", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(row, col++, "Vandor Name", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(row, col++, "Dropped Date", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(row, col++, "Unloaded Date", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(row, col++, "Item Description", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(row, col++, "Bales", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(row, col++, "Net  Tons", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(row, col++, "$ Price Per Ton", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(row, col++, "$ Extention", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(row, col++, "Carrier", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(row, col++, "Trailer No", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(row, col++, "Shipping City", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(row, col++, "Shipping State", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(row, col++, "Estimated Freight", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(row, col++, "Freight Invoice No", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(row, col++, "Freight Invoiced $", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(row, col++, "Detention Charge", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(row, col++, "$ Freight CHBK", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		//Code Starts From Here Done By Roshan Tailor Date:- 06/25/2015 MM/DD/YYYY Night Shift
		util.addValue(row, col++, "Deduction", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		//Code Ends Here Done By Roshan Tailor Date:- 06/25/2015 MM/DD/YYYY Night Shift
		util.addValue(row, col++, "$ Grand Total", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(row, col++, "Destination", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(row, col++, "Comment", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		
		
		SimpleDateFormat dateFormat=new SimpleDateFormat("MM/dd/yyyy");
		int _totalBales=0;
		double _totalNettons=0.0;
		double _totalPricePertons=0.0;
		double _totalExtension=0.0;
		double _totalEstimatedFreight=0.0;
		double _totalFreightInvoiced=0.0;
		double _totalDetentionCharge=0.0;
		double _totalFreightCHBK=0.0;
		double _totalDeduction=0.0;
		double _totalGrandTotal=0.0;
		for (WastepaperDetail wd : details) {
			col=0;
			row++;
			
			//util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, CommonUtil.checkNull(wd.getMasterPO()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, wd.getReleaseNo(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, CommonUtil.checkNull(wd.getVandorName()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			if(wd.getDroppedDate()==null){
				util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			}else{
				util.addValue(row, col++, dateFormat.format(wd.getDroppedDate()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			}
			if(wd.getUnloadedDate()==null){
				util.addValue(row, col++,"", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			}else{
				util.addValue(row, col++, dateFormat.format(wd.getUnloadedDate()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			}
			util.addValue(row, col++, CommonUtil.checkNull(wd.getItemDescription()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, CommonUtil.round(wd.getBales(), 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, CommonUtil.round(wd.getNetTons(), 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, "$"+CommonUtil.round(wd.getPricePerTon(), 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, "$"+CommonUtil.round(wd.getExtention(), 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, wd.getCarrier(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, wd.getTrailerNo(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, wd.getShippingCity(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, wd.getShippingState(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, "$"+CommonUtil.round(wd.getEstimatedFreight(), 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			// Line Coded For Freight Invoice No.
			if(wd.getFreightInvoiceNo()==null){
				int NofreightinvoiceNu=0;
				util.addValue(row, col++, NofreightinvoiceNu, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			}else{
				util.addValue(row, col++, CommonUtil.checkNull(wd.getFreightInvoiceNo()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);	
			}
			
			util.addValue(row, col++, "$"+wd.getFreightInvoiced(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, "$"+wd.getDetentionCharges(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			
			
			double baleWeight=wd.getNetTons();
			double StandardWeightTon=20;
			if(baleWeight>=StandardWeightTon)
			{
				double rightTons=0.0;
				//wastepaperDetail.setFreightCHBK(rightTons);
				util.addValue(row, col++, "$"+"("+rightTons+")", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			}else{
				String _checkCarrier=wd.getCarrier();
				double chbk=(StandardWeightTon-baleWeight)/StandardWeightTon;
				double freightInvoiced=wd.getFreightInvoiced();
				double finalchbk=chbk*freightInvoiced;
				String _text="Pending";
				if(_checkCarrier==null){
					continue;
					
				}/* else if(freightInvoiced==0 && ! _checkCarrier.equalsIgnoreCase("Dlvd Price")){
					util.addValue(row, col++, _text, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
				}else if(_checkCarrier.equalsIgnoreCase("Dlvd Price")){
					int retval = Double.compare(StandardWeightTon, CommonUtil.round(baleWeight, 2));
					//System.out.println("freightInvoiced::"+freightInvoiced);
					//System.out.println("Careerir::"+wd.getCarrier());
					if(retval > 0){
							String fcbForDlvdPrice1="0";
							double fcbForDlvdPrice2=0.0;
							wd.setFreightCHBKPending(fcbForDlvdPrice1);
							wd.setFreightCHBK(fcbForDlvdPrice2);
							util.addValue(row, col++, "$"+"("+fcbForDlvdPrice2+")", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
					}else{
						util.addValue(row, col++, _text, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
					}
				}else{
				//util.addValue(row, col++, "$"+"("+CommonUtil.round(finalchbk, 2)+")", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
				util.addValue(row, col++, "$"+"("+CommonUtil.round(wd.getFreightCHBK(), 2)+")", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
				}*/
				else if(wd.getFreightCHBKPending()==null){
					util.addValue(row, col++, "$"+"("+CommonUtil.round(wd.getFreightCHBK(), 2)+")", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
				}
				else if(wd.getFreightCHBKPending().equalsIgnoreCase("Pending")){
					util.addValue(row, col++, _text, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
				}else if( !wd.getFreightCHBKPending().equalsIgnoreCase("Pending")){
					util.addValue(row, col++, "$"+"("+CommonUtil.round(wd.getFreightCHBK(), 2)+")", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
				}else{
					util.addValue(row, col++, "Contact To Roshan", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
				}
			}
			util.addValue(row, col++,"$"+"("+CommonUtil.round(wd.getDeduction(), 2)+")", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);	
			//Code Ends Here Done By Roshan Tailor Date :-06/25/2015 MM/DD/YYYY Night Shift
			util.addValue(row, col++, "$"+CommonUtil.round(wd.getGrandTotal(), 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, wd.getDestination(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, wd.getComment(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			
			_totalBales=wd.getBales()+_totalBales;
			_totalNettons=wd.getNetTons()+_totalNettons;
			_totalPricePertons=wd.getPricePerTon()+_totalPricePertons;
			_totalExtension=wd.getExtention()+_totalExtension;
			_totalEstimatedFreight=wd.getEstimatedFreight()+_totalEstimatedFreight;
			_totalFreightInvoiced=wd.getFreightInvoiced()+_totalFreightInvoiced;
			_totalDetentionCharge=wd.getDetentionCharges()+_totalDetentionCharge;
			_totalFreightCHBK=wd.getFreightCHBK()+_totalFreightCHBK;
			_totalDeduction=wd.getDeduction()+_totalDeduction;
			_totalGrandTotal=wd.getGrandTotal()+_totalGrandTotal;
			if(wd.getReleaseNo()==12318){
				System.out.println("_totalGrandTotal111111::"+wd.getGrandTotal());
			}
		}
		row++;
		col=0;
		
				util.addValue(row, col++, "Total", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
				util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
				util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
				util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
				util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
				util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
				util.addValue(row, col++, _totalBales, Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
				util.addValue(row, col++, CommonUtil.round(_totalNettons, 2), Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
				/*util.addValue(row, col++, "$"+CommonUtil.round(_totalPricePertons, 2), Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);*/
				util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
				util.addValue(row, col++, "$"+CommonUtil.round(_totalExtension, 2), Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
				util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
				util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
				util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
				util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
				util.addValue(row, col++, "$"+CommonUtil.round(_totalEstimatedFreight, 2), Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
				util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
				util.addValue(row, col++, "$"+CommonUtil.round(_totalFreightInvoiced, 2), Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
				util.addValue(row, col++, "$"+CommonUtil.round(_totalDetentionCharge, 2), Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
				util.addValue(row, col++, "$"+"("+CommonUtil.round(_totalFreightCHBK, 2)+")", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
				util.addValue(row, col++, "$"+"("+CommonUtil.round(_totalDeduction, 2)+")", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
				util.addValue(row, col++, "$"+CommonUtil.round(_totalGrandTotal, 2), Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
				util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
				util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
				if(_totalGrandTotal==12318){
					System.out.println("_totalGrandTotal::"+_totalGrandTotal);
				}
				
		for (int i = 0; i < 24; i++) {
			util.setAutoSizeColumn(i);
		}
		
		
		util.write(outputStream);
		
	}

}

package com.st.wastepaper.report;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

import jakarta.servlet.ServletOutputStream;

import org.springframework.stereotype.Repository;

import com.st.common.CommonUtil;
import com.st.common.Workbook2007Util;
import com.st.common.pdfutil.PdfStyle;
import com.st.wastepaper.model.WastePaperBaleInventory;
import com.st.wastepaper.model.WastepaperDetail;

@Repository
public class WastePaperReceivingReportExcelHandler {

	SimpleDateFormat dateFormat=new SimpleDateFormat("MM-dd-yyyy");
	
	public void getWastePaperReceivingReportExcelFormat(List<WastepaperDetail> datas, List<WastepaperDetail> rejectBales, File file,ServletOutputStream outputStream) throws IOException {
		Workbook2007Util util = new Workbook2007Util(file,0);
		util.setSheetName("ST_Paper_LLC_WASTEPAPER_RECEIVING_REPORT_ExcelFormat", 0);
		
		short rowHeight = 400;
		short rowHeight1 = 280;
		int row=0;
		int col=1;
		int lastcol=0;
		if(datas.size()==1){
			util.addValue(1, 2, datas.get(0).getMasterPO(), Workbook2007Util.Style.STYLE_NORMAL_LEFT_NOBORDER, rowHeight);
			util.addValue(2, 2, datas.get(0).getReleaseNo(), Workbook2007Util.Style.STYLE_NORMAL_LEFT_NOBORDER, rowHeight);
			util.addValue(3, 2, datas.get(0).getVandorName(), Workbook2007Util.Style.STYLE_NORMAL_LEFT_NOBORDER, rowHeight);
			util.addValue(4, 2, datas.get(0).getItemDescription(), Workbook2007Util.Style.STYLE_NORMAL_LEFT_NOBORDER, rowHeight);
			util.addValue(5, 2, dateFormat.format(datas.get(0).getDroppedDate()), Workbook2007Util.Style.STYLE_NORMAL_LEFT_NOBORDER, rowHeight);
			util.addValue(6, 2, dateFormat.format(datas.get(0).getUnloadedDate()), Workbook2007Util.Style.STYLE_NORMAL_LEFT_NOBORDER, rowHeight);
			util.addValue(7, 2, datas.get(0).getCarrier(), Workbook2007Util.Style.STYLE_NORMAL_LEFT_NOBORDER, rowHeight);
			util.addValue(8, 2, datas.get(0).getTrailerNo(), Workbook2007Util.Style.STYLE_NORMAL_LEFT_NOBORDER, rowHeight);
			util.addValue(9, 2, datas.get(0).getShippingCity()+","+datas.get(0).getShippingState(), Workbook2007Util.Style.STYLE_NORMAL_LEFT_NOBORDER, rowHeight);
			double totalNetTons=0;
			for(WastepaperDetail data:datas){
				double NetTons=data.getNetTons();
				totalNetTons=totalNetTons+NetTons;
			}
			util.addValue(10, 2, ""+CommonUtil.round(totalNetTons*2000, 2), Workbook2007Util.Style.STYLE_NORMAL_LEFT_NOBORDER, rowHeight);
			
			row=12;
			col=0;
			double totalBales=0;
			double totalNetTon=0;
			
			for(WastepaperDetail data:datas){
				
				double Bales=data.getBales();
				double tons=data.getNetTons();
				totalBales=totalBales+Bales;
				totalNetTon=totalNetTon+tons;
				
				util.addValue(12, col++, data.getItemDescription(), Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight1);
				util.addValue(12, col++, data.getBales(), Workbook2007Util.Style.STYLE_NORMAL_RIGHT, rowHeight1);
				util.addValue(12, col++, CommonUtil.round(data.getNetTons()*2000, 2), Workbook2007Util.Style.STYLE_NORMAL_RIGHT, rowHeight1);
				util.addValue(12, col++, CommonUtil.round(data.getNetTons(), 2), Workbook2007Util.Style.STYLE_NORMAL_RIGHT, rowHeight1);
			
				row=13;
				col=0;
				util.addValue(13, col++, "Total of Good Received Weight", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight1);
				util.addValue(13, col++, CommonUtil.round(totalBales, 2), Workbook2007Util.Style.STYLE_NORMAL_RIGHT, rowHeight1);
				util.addValue(13, col++, CommonUtil.round(totalNetTon*2000, 2), Workbook2007Util.Style.STYLE_NORMAL_RIGHT, rowHeight1);
				util.addValue(13, col++, CommonUtil.round(totalNetTon, 2), Workbook2007Util.Style.STYLE_NORMAL_RIGHT, rowHeight1);
				
				row=14;
				col=0;
				double rejectweight=0;
				int rejectbales=0;
				
				if(rejectBales.size()>0){
					for(WastepaperDetail reject:rejectBales){
						System.out.println(reject.getRejectbolweight());
						System.out.println(reject.getRejectbalecount());
						rejectweight=rejectweight+reject.getRejectbolweight();
						rejectbales=rejectbales+reject.getRejectbalecount();
						
					}
					
				}
				util.addValue(14, col++, "Total Reject", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight1);
				util.addValue(14, col++, rejectbales, Workbook2007Util.Style.STYLE_NORMAL_RIGHT, rowHeight1);
				util.addValue(14, col++, CommonUtil.round(rejectweight, 2), Workbook2007Util.Style.STYLE_NORMAL_RIGHT, rowHeight1);
				util.addValue(14, col++, CommonUtil.round(rejectweight/2000, 2), Workbook2007Util.Style.STYLE_NORMAL_RIGHT, rowHeight1);
				
				row=15;
				col=0;
				util.addValue(15, col++, "Freight Charge Back", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight1);
				util.addValue(15, col++, 0, Workbook2007Util.Style.STYLE_NORMAL_RIGHT, rowHeight1);
				util.addValue(15, col++, 0, Workbook2007Util.Style.STYLE_NORMAL_RIGHT, rowHeight1);
				
				
				/*if(datas.get(0).getFreightCHBKPending()==null ||datas.get(0).getFreightCHBKPending()=="" && datas.get(1).getFreightCHBKPending()==null ||datas.get(1).getFreightCHBKPending()==""){*/
				if(datas.get(0).getFreightCHBKPending()==null ||datas.get(0).getFreightCHBKPending()==""){
				double totalFCB=0;
					if(datas.size()==1 || datas.size()>1){
						for(WastepaperDetail rs:datas){
							double FCB=rs.getFreightCHBK();
							totalFCB=totalFCB+FCB;
						}
					}
					util.addValue(15, col++,"$("+CommonUtil.round(totalFCB, 2)+")", Workbook2007Util.Style.STYLE_NORMAL_RIGHT, rowHeight1);
				}
				else if(datas.get(0).getFreightCHBKPending().equalsIgnoreCase("Pending")){
					util.addValue(15, col++, "Pending", Workbook2007Util.Style.STYLE_NORMAL_RIGHT, rowHeight1);
				}
				else{
					double totalFCB=0;
					if(datas.size()>1){
						for(WastepaperDetail rs:datas){
							double FCB=rs.getFreightCHBK();
							totalFCB=totalFCB+FCB;
						}
					}
					util.addValue(15, col++, "$("+CommonUtil.round(totalFCB, 2)+")", Workbook2007Util.Style.STYLE_NORMAL_RIGHT, rowHeight1);
				} 
				
				row=16;
				col=0;
				util.addValue(16, col++, "Detention Charges", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight1);
				util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_RIGHT, rowHeight1);
				util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_RIGHT, rowHeight1);
				util.addValue(row, col++, 0, Workbook2007Util.Style.STYLE_NORMAL_RIGHT, rowHeight1);
				
				row=17;
				col=0;
				util.addValue(17, col++, "Tonu Charges", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight1);
				util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_RIGHT, rowHeight1);
				util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_RIGHT, rowHeight1);
				util.addValue(row, col++, 0, Workbook2007Util.Style.STYLE_NORMAL_RIGHT, rowHeight1);
				
			}
		}else if(datas.size()>1){
			util.addValue(1, 2, datas.get(0).getMasterPO(), Workbook2007Util.Style.STYLE_NORMAL_LEFT_NOBORDER, rowHeight);
			util.addValue(2, 2, datas.get(0).getReleaseNo(), Workbook2007Util.Style.STYLE_NORMAL_LEFT_NOBORDER, rowHeight);
			util.addValue(3, 2, datas.get(0).getVandorName(), Workbook2007Util.Style.STYLE_NORMAL_LEFT_NOBORDER, rowHeight);
			util.addValue(4, 2, datas.get(0).getItemDescription(), Workbook2007Util.Style.STYLE_NORMAL_LEFT_NOBORDER, rowHeight);
			util.addValue(5, 2, dateFormat.format(datas.get(0).getDroppedDate()), Workbook2007Util.Style.STYLE_NORMAL_LEFT_NOBORDER, rowHeight);
			util.addValue(6, 2, dateFormat.format(datas.get(0).getUnloadedDate()), Workbook2007Util.Style.STYLE_NORMAL_LEFT_NOBORDER, rowHeight);
			util.addValue(7, 2, datas.get(0).getCarrier(), Workbook2007Util.Style.STYLE_NORMAL_LEFT_NOBORDER, rowHeight);
			util.addValue(8, 2, datas.get(0).getTrailerNo(), Workbook2007Util.Style.STYLE_NORMAL_LEFT_NOBORDER, rowHeight);
			util.addValue(9, 2, datas.get(0).getShippingCity()+","+datas.get(0).getShippingState(), Workbook2007Util.Style.STYLE_NORMAL_LEFT_NOBORDER, rowHeight);
			double totalNetTons=0;
			for(WastepaperDetail data:datas){
				double NetTons=data.getNetTons();
				totalNetTons=totalNetTons+NetTons;
			}
			util.addValue(10, 2, ""+CommonUtil.round(totalNetTons*2000, 2), Workbook2007Util.Style.STYLE_NORMAL_LEFT_NOBORDER, rowHeight);
			
			
			row=12;
			double totalBales=0;
			double totalNetTon=0;
			
			for(WastepaperDetail data:datas){
				col=0;
				
				double Bales=data.getBales();
				double tons=data.getNetTons();
				totalBales=totalBales+Bales;
				totalNetTon=totalNetTon+tons;
				
				util.addValue(row, col++, data.getItemDescription(), Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight1);
				util.addValue(row, col++, data.getBales(), Workbook2007Util.Style.STYLE_NORMAL_RIGHT, rowHeight1);
				util.addValue(row, col++, CommonUtil.round(data.getNetTons()*2000, 2), Workbook2007Util.Style.STYLE_NORMAL_RIGHT, rowHeight1);
				util.addValue(row, col++, CommonUtil.round(data.getNetTons(), 2), Workbook2007Util.Style.STYLE_NORMAL_RIGHT, rowHeight1);
				row++;
			}
			
			
			for(WastepaperDetail data:datas){
				
				row=14;
				col=0;
				util.addValue(row, col++, "Total of Good Received Weight", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight1);
				util.addValue(row, col++, CommonUtil.round(totalBales, 2), Workbook2007Util.Style.STYLE_NORMAL_RIGHT, rowHeight1);
				util.addValue(row, col++, CommonUtil.round(totalNetTon*2000, 2), Workbook2007Util.Style.STYLE_NORMAL_RIGHT, rowHeight1);
				util.addValue(row, col++, CommonUtil.round(totalNetTon, 2), Workbook2007Util.Style.STYLE_NORMAL_RIGHT, rowHeight1);
				
				row++;
				col=0;

				double rejectweight=0;
				int rejectbales=0;
				
				if(rejectBales.size()>0){
					for(WastepaperDetail reject:rejectBales){
						System.out.println(reject.getRejectbolweight());
						System.out.println(reject.getRejectbalecount());
						rejectweight=rejectweight+reject.getRejectbolweight();
						rejectbales=rejectbales+reject.getRejectbalecount();
						
					}
					
				}
				util.addValue(row, col++, "Total Reject", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight1);
				util.addValue(row, col++, rejectbales, Workbook2007Util.Style.STYLE_NORMAL_RIGHT, rowHeight1);
				util.addValue(row, col++, CommonUtil.round(rejectweight, 2), Workbook2007Util.Style.STYLE_NORMAL_RIGHT, rowHeight1);
				util.addValue(row, col++, CommonUtil.round(rejectweight/2000, 2), Workbook2007Util.Style.STYLE_NORMAL_RIGHT, rowHeight1);

				row++;
				col=0;
				util.addValue(row, col++, "Freight Charge Back", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight1);
				util.addValue(row, col++, 0, Workbook2007Util.Style.STYLE_NORMAL_RIGHT, rowHeight1);
				util.addValue(row, col++, 0, Workbook2007Util.Style.STYLE_NORMAL_RIGHT, rowHeight1);


				if(datas.get(0).getFreightCHBKPending()==null ||datas.get(0).getFreightCHBKPending()=="" && datas.get(1).getFreightCHBKPending()==null ||datas.get(1).getFreightCHBKPending()==""){
					double totalFCB=0;
					if(datas.size()>1){
						for(WastepaperDetail rs:datas){
							double FCB=rs.getFreightCHBK();
							totalFCB=totalFCB+FCB;
						}
					}
					util.addValue(row, col++, "$("+CommonUtil.round(totalFCB, 2)+")", Workbook2007Util.Style.STYLE_NORMAL_RIGHT, rowHeight1);
				}
				else if(datas.get(0).getFreightCHBKPending().equalsIgnoreCase("Pending")){
					util.addValue(row, col++, "Pending", Workbook2007Util.Style.STYLE_NORMAL_RIGHT, rowHeight1);
				}
				else{
					double totalFCB=0;
					if(datas.size()>1){
						for(WastepaperDetail rs:datas){
							double FCB=rs.getFreightCHBK();
							totalFCB=totalFCB+FCB;
						}
					}
					util.addValue(row, col++, "$("+CommonUtil.round(totalFCB, 2)+")", Workbook2007Util.Style.STYLE_NORMAL_RIGHT, rowHeight1);
				} 

				row++;
				col=0;
				util.addValue(row, col++, "Detention Charges", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight1);
				util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_RIGHT, rowHeight1);
				util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_RIGHT, rowHeight1);
				util.addValue(row, col++, 0, Workbook2007Util.Style.STYLE_NORMAL_RIGHT, rowHeight1);
				
				row++;
				col=0;
				util.addValue(row, col++, "Tonu Charges", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight1);
				util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_RIGHT, rowHeight1);
				util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_RIGHT, rowHeight1);
				util.addValue(row, col++, 0, Workbook2007Util.Style.STYLE_NORMAL_RIGHT, rowHeight1);
				
			}
			
		}
		
		util.write(outputStream);
	}

}

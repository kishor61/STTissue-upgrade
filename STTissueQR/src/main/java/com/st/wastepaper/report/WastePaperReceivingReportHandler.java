/**
 *Sep 14, 2015
 *WastePaperReceivingReportHandler.java
 * TODO
 *com.st.wastepaper.report
 *WastePaperReceivingReportHandler.java
 *Sunil Singh Bora
 */
package com.st.wastepaper.report;

import java.awt.Color;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.List;
import java.text.SimpleDateFormat;

import jakarta.servlet.ServletOutputStream;

import org.springframework.stereotype.Component;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Phrase;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPRow;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.lowagie.text.pdf.Pfm2afm;
import com.st.common.CommonUtil;
import com.st.common.pdfutil.PdfReportUtil;
import com.st.common.pdfutil.PdfStyle;
import com.st.common.pdfutil.PdfReportUtil.Section;
import com.st.common.pdfutil.PdfReportUtil.Table;
import com.st.wastepaper.model.WastePaperBaleInventory;
import com.st.wastepaper.model.WastepaperDetail;

/**
 * @author roshan
 *
 */
@Component
public class WastePaperReceivingReportHandler {

	/**
	 * @param receivinfReport
	 * @param rejectBales 
	 * @param outputStream
	 * @throws Exception 
	 */
	public void createpdf(List<WastepaperDetail> receivinfReport,
			List<WastepaperDetail> rejectBales, OutputStream outputStream) throws Exception {
		SimpleDateFormat dateFormat=new SimpleDateFormat("MM-dd-yyyy");
		if(receivinfReport!=null && receivinfReport.size()>0){
			
			PdfReportUtil pdfUtil=new PdfReportUtil();
			pdfUtil.setOuputStream(outputStream);
			pdfUtil.setDocumentTitle("PO Number:-"+receivinfReport.get(0).getMasterPO());
			pdfUtil.setPage(PdfStyle.PAGE_LEGAL_PORTRAIT_Receiving_Reports);
			pdfUtil.open();
			
			/*Section header=pdfUtil.new Section(10, 10, PdfStyle.ALIGN_CENTER);
			header.addText("ST Tissue LLC, Wastepaper Recieving Report", PdfStyle.FONT_BOLD_UNDERLINE_16);
			header.addText("\n\n", PdfStyle.FONT_NORMAL_10);
			header.finish();*/
			
			Table table=pdfUtil.new Table(4, new float[]{1,1,1,1});
			table.addCell("ST Paper1, LLC WASTEPAPER RECEIVING REPORT", PdfStyle.FONT_BOLD_10, PdfStyle.ALIGN_CENTER, 4, 1,1,5,5,5,5,new Color(204, 204, 255, 0)  );
			if(receivinfReport.size()==1){
				for(WastepaperDetail rs:receivinfReport){

					table.addCellLeftBorder("Master PO #", PdfStyle.FONT_BOLD_10, PdfStyle.ALIGN_LEFT, 2, 1,0);
					//table.addCell("Master PO #", PdfStyle.FONT_BOLD_10, PdfStyle.ALIGN_CENTER, 2, 1,1, 0, 0, 0, 0);
					table.addCellRightBorder(rs.getMasterPO(), PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2,1,0);
					
					table.addCellLeftBorder("Release #", PdfStyle.FONT_BOLD_10, PdfStyle.ALIGN_LEFT, 2,1,0);
					table.addCellRightBorder(""+rs.getReleaseNo(), PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2,1,0);
					
					table.addCellLeftBorder("Vendor", PdfStyle.FONT_BOLD_10, PdfStyle.ALIGN_LEFT, 2, 1,0);
					table.addCellRightBorder(""+rs.getVandorName(), PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2	, 1,0);
					
					table.addCellLeftBorder("Grade Ordered", PdfStyle.FONT_BOLD_10, PdfStyle.ALIGN_LEFT, 2	, 1,0);
					table.addCellRightBorder(""+rs.getItemDescription(), PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2	, 1,0);
					
					table.addCellLeftBorder("Date Dropped", PdfStyle.FONT_BOLD_10, PdfStyle.ALIGN_LEFT, 2, 1,0);
					table.addCellRightBorder(""+dateFormat.format(rs.getDroppedDate()), PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2	, 1,0);
					
					table.addCellLeftBorder("Date Unloaded", PdfStyle.FONT_BOLD_10, PdfStyle.ALIGN_LEFT, 2	, 1,0);
					table.addCellRightBorder(""+dateFormat.format(rs.getDroppedDate()), PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2	, 1,0);
					
					table.addCellLeftBorder("Carrier", PdfStyle.FONT_BOLD_10, PdfStyle.ALIGN_LEFT, 2, 1,0);
					table.addCellRightBorder(""+rs.getCarrier(), PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2	, 1,0);
					
					table.addCellLeftBorder("Trailer #", PdfStyle.FONT_BOLD_10, PdfStyle.ALIGN_LEFT, 2	, 1,0);
					table.addCellRightBorder(""+rs.getTrailerNo(), PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2	, 1,0);
					
					table.addCellLeftBorder("Origin", PdfStyle.FONT_BOLD_10, PdfStyle.ALIGN_LEFT, 2, 1,0);
					table.addCellRightBorder(""+rs.getShippingCity()+","+rs.getShippingState(), PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2	, 1,0);
					
					table.addCellLeftBorder("Weight", PdfStyle.FONT_BOLD_10, PdfStyle.ALIGN_LEFT, 2	, 1,0);
					table.addCellRightBorder(""+CommonUtil.round(+rs.getNetTons()*2000, 2), PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2	, 1,0);
					
					
					table.addCell("Received Grade", PdfStyle.FONT_BOLD_10, PdfStyle.ALIGN_CENTER ,1	, 1,1,5,5,5,5,new Color(220,220,200,0));
					table.addCell("Bales", PdfStyle.FONT_BOLD_10, PdfStyle.ALIGN_CENTER,  1	, 1,1,5,5,5,5,new Color(220,220,200,0));
					table.addCell("Received Weight", PdfStyle.FONT_BOLD_10, PdfStyle.ALIGN_CENTER, 1	, 1,1,5,5,5,5,new Color(220,220,200,0));
					table.addCell("Tons", PdfStyle.FONT_BOLD_10, PdfStyle.ALIGN_CENTER, 1	, 1,1,5,5,5,5,new Color(220,220,200,0));
					
					
					table.addCell(""+rs.getItemDescription(), PdfStyle.FONT_BOLD_10, PdfStyle.ALIGN_LEFT, 1	, 1);
					table.addCell(""+rs.getBales(), PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_RIGHT, 1	, 1);
					table.addCell(""+CommonUtil.round(rs.getNetTons()*2000, 2), PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_RIGHT, 1	, 1);
					table.addCell(""+CommonUtil.round(rs.getNetTons(), 2), PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_RIGHT, 1	, 1);
					
					table.addCell("Total of Good Received Weight", PdfStyle.FONT_BOLD_10, PdfStyle.ALIGN_LEFT, 1	, 1);
					table.addCell(""+rs.getBales(), PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_RIGHT, 1	, 1);
					table.addCell(""+CommonUtil.round(rs.getNetTons()*2000, 2), PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_RIGHT, 1	, 1);
					table.addCell(""+CommonUtil.round(rs.getNetTons(), 2), PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_RIGHT, 1	, 1);
							
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
					
					table.addCell("Total Rejected", PdfStyle.FONT_BOLD_10, PdfStyle.ALIGN_LEFT, 1	, 1);
					table.addCell(""+rejectbales, PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_RIGHT, 1	, 1);
					table.addCell(""+CommonUtil.round(rejectweight, 2), PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_RIGHT, 1	, 1);
					table.addCell(""+CommonUtil.round(rejectweight/2000, 2), PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_RIGHT, 1	, 1);
					
					table.addCell("Freight Charge Back", PdfStyle.FONT_BOLD_10, PdfStyle.ALIGN_LEFT, 1	, 1);
					table.addCell("0", PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_RIGHT, 1	, 1);
					table.addCell("0", PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_RIGHT, 1	, 1);
					if(rs.getFreightCHBKPending()==null ||rs.getFreightCHBKPending()==""){
						table.addCell("$("+CommonUtil.round(rs.getFreightCHBK(), 2)+")", PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_RIGHT, 1	, 1);
					}
					else if(rs.getFreightCHBKPending().equalsIgnoreCase("Pending")){
						table.addCell("Pending", PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_RIGHT, 1	, 1);
					}
					else if(rs.getFreightCHBKPending()!="Pending"){
						table.addCell("$("+CommonUtil.round(rs.getFreightCHBK(), 2)+")", PdfStyle.FONT_BOLD_10, PdfStyle.ALIGN_RIGHT, 1	, 1);
					}
					table.addCell("Detention Charge", PdfStyle.FONT_BOLD_10, PdfStyle.ALIGN_LEFT, 1	, 1);
					table.addCell("", PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_RIGHT, 1	, 1);
					table.addCell("", PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_RIGHT, 1	, 1);
					table.addCell(""+rs.getDetentionCharges(), PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_RIGHT, 1	, 1);
					
					table.addCell("Tonu Charge", PdfStyle.FONT_BOLD_10, PdfStyle.ALIGN_LEFT, 1	, 1);
					table.addCell("", PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_RIGHT, 1	, 1);
					table.addCell("", PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_RIGHT, 1	, 1);
					table.addCell("0", PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_RIGHT, 1	, 1);
					
					table.addCell(" ", PdfStyle.FONT_BOLD_10, PdfStyle.ALIGN_LEFT, 1	, 1);
					table.addCell(" ", PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_RIGHT, 1	, 1);
					table.addCell(" ", PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_RIGHT, 1	, 1);
					table.addCell(" ", PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_RIGHT, 1	, 1);
				}
			}else if(receivinfReport.size()>1){
				

					table.addCellLeftBorder("Master PO #", PdfStyle.FONT_BOLD_10, PdfStyle.ALIGN_LEFT, 2, 1,0);
					//table.addCell("Master PO #", PdfStyle.FONT_BOLD_10, PdfStyle.ALIGN_CENTER, 2, 1,1, 0, 0, 0, 0);
					table.addCellRightBorder(receivinfReport.get(0).getMasterPO(), PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2,1,0);
					
					table.addCellLeftBorder("Release #", PdfStyle.FONT_BOLD_10, PdfStyle.ALIGN_LEFT, 2,1,0);
					table.addCellRightBorder(""+receivinfReport.get(0).getReleaseNo(), PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2,1,0);
					
					table.addCellLeftBorder("Vendor", PdfStyle.FONT_BOLD_10, PdfStyle.ALIGN_LEFT, 2, 1,0);
					table.addCellRightBorder(""+receivinfReport.get(0).getVandorName(), PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2	, 1,0);
					
					table.addCellLeftBorder("Grade Ordered", PdfStyle.FONT_BOLD_10, PdfStyle.ALIGN_LEFT, 2	, 1,0);
					
					String totalItems="";
					for(WastepaperDetail rs:receivinfReport){
						String items=rs.getItemDescription();
						totalItems=totalItems+","+items;
					}
					String gradeValue = totalItems;
					gradeValue = gradeValue.substring(1);
					
					//table.addCell(""+receivinfReport.get(0).getItemDescription(), PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2	, 1,0);
					table.addCellRightBorder(""+gradeValue, PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2	, 1,0);
					
					table.addCellLeftBorder("Date Dropped", PdfStyle.FONT_BOLD_10, PdfStyle.ALIGN_LEFT, 2, 1,0);
					table.addCellRightBorder(""+dateFormat.format(receivinfReport.get(0).getDroppedDate()), PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2	, 1,0);
					
					table.addCellLeftBorder("Date Unloaded", PdfStyle.FONT_BOLD_10, PdfStyle.ALIGN_LEFT, 2	, 1,0);
					table.addCellRightBorder(""+dateFormat.format(receivinfReport.get(0).getUnloadedDate()), PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2	, 1,0);
					
					table.addCellLeftBorder("Carrier", PdfStyle.FONT_BOLD_10, PdfStyle.ALIGN_LEFT, 2, 1,0);
					table.addCellRightBorder(""+receivinfReport.get(0).getCarrier(), PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2	, 1,0);
					
					table.addCellLeftBorder("Trailer #", PdfStyle.FONT_BOLD_10, PdfStyle.ALIGN_LEFT, 2	, 1,0);
					table.addCellRightBorder(""+receivinfReport.get(0).getTrailerNo(), PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2	, 1,0);
					
					table.addCellLeftBorder("Origin", PdfStyle.FONT_BOLD_10, PdfStyle.ALIGN_LEFT, 2, 1,0);
					table.addCellRightBorder(""+receivinfReport.get(0).getShippingCity()+","+receivinfReport.get(0).getShippingState(), PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2	, 1,0);
					
					double totalNetTons=0;
					for(WastepaperDetail rs:receivinfReport){
						double NetTons=rs.getNetTons();
						totalNetTons=totalNetTons+NetTons;
					}
					table.addCellLeftBorder("Weight", PdfStyle.FONT_BOLD_10, PdfStyle.ALIGN_LEFT, 2	, 1,0);
					table.addCellRightBorder(""+CommonUtil.round(totalNetTons*2000, 2), PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2	, 1,0);
					
					
					table.addCell("Received Grade", PdfStyle.FONT_BOLD_10, PdfStyle.ALIGN_CENTER ,1	, 1,1,5,5,5,5,new Color(220,220,200,0));
					table.addCell("Bales", PdfStyle.FONT_BOLD_10, PdfStyle.ALIGN_CENTER,  1	, 1,1,5,5,5,5,new Color(220,220,200,0));
					table.addCell("Received Weight", PdfStyle.FONT_BOLD_10, PdfStyle.ALIGN_CENTER, 1	, 1,1,5,5,5,5,new Color(220,220,200,0));
					table.addCell("Tons", PdfStyle.FONT_BOLD_10, PdfStyle.ALIGN_CENTER, 1	, 1,1,5,5,5,5,new Color(220,220,200,0));
					
					double totalBales=0;
					double totalNetTon=0;
					
					for(WastepaperDetail rs:receivinfReport){
						double Bales=rs.getBales();
						double tons=rs.getNetTons();
						totalBales=totalBales+Bales;
						totalNetTon=totalNetTon+tons;
						
						table.addCell(""+rs.getItemDescription(), PdfStyle.FONT_BOLD_10, PdfStyle.ALIGN_LEFT, 1	, 1);
						table.addCell(""+rs.getBales(), PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_RIGHT, 1	, 1);
						table.addCell(""+CommonUtil.round(rs.getNetTons()*2000, 2), PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_RIGHT, 1	, 1);
						table.addCell(""+CommonUtil.round(rs.getNetTons(), 2), PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_RIGHT, 1	, 1);
					}
					
					
					
					table.addCell("Total of Good Received Weight", PdfStyle.FONT_BOLD_10, PdfStyle.ALIGN_LEFT, 1	, 1);
					table.addCell(""+totalBales, PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_RIGHT, 1	, 1);
					table.addCell(""+CommonUtil.round(totalNetTon*2000, 2), PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_RIGHT, 1	, 1);
					table.addCell(""+CommonUtil.round(totalNetTon, 2), PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_RIGHT, 1	, 1);
							
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
					table.addCell("Total Rejected", PdfStyle.FONT_BOLD_10, PdfStyle.ALIGN_LEFT, 1	, 1);
					table.addCell(""+rejectbales, PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_RIGHT, 1	, 1);
					table.addCell(""+CommonUtil.round(rejectweight, 2), PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_RIGHT, 1	, 1);
					table.addCell(""+CommonUtil.round(rejectweight/2000, 2), PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_RIGHT, 1	, 1);
					
					table.addCell("Freight Charge Back", PdfStyle.FONT_BOLD_10, PdfStyle.ALIGN_LEFT, 1	, 1);
					table.addCell("0", PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_RIGHT, 1	, 1);
					table.addCell("0", PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_RIGHT, 1	, 1);
					
						if(receivinfReport.get(0).getFreightCHBKPending()==null ||receivinfReport.get(0).getFreightCHBKPending()=="" && receivinfReport.get(1).getFreightCHBKPending()==null ||receivinfReport.get(1).getFreightCHBKPending()==""){
							double totalFCB=0;
							if(receivinfReport.size()>1){
								for(WastepaperDetail rs:receivinfReport){
									double FCB=rs.getFreightCHBK();
									totalFCB=totalFCB+FCB;
								}
							}
							table.addCell("$("+CommonUtil.round(totalFCB, 2)+")", PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_RIGHT, 1	, 1);
						}
						else if(receivinfReport.get(0).getFreightCHBKPending().equalsIgnoreCase("Pending")){
							table.addCell("Pending", PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_RIGHT, 1	, 1);
						}
						else{
							double totalFCB=0;
							if(receivinfReport.size()>1){
								for(WastepaperDetail rs:receivinfReport){
									double FCB=rs.getFreightCHBK();
									totalFCB=totalFCB+FCB;
								}
							}
							table.addCell("$("+CommonUtil.round(totalFCB, 2)+")", PdfStyle.FONT_BOLD_10, PdfStyle.ALIGN_RIGHT, 1	, 1);
							/*if(receivinfReport.get(0).getFreightCHBKPending()!="Pending"){
								
								
							}*/
						} 
						table.addCell("Detention Charge", PdfStyle.FONT_BOLD_10, PdfStyle.ALIGN_LEFT, 1	, 1);
						table.addCell("", PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_RIGHT, 1	, 1);
						table.addCell("", PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_RIGHT, 1	, 1);
						double totalDetentionCharges=0;
						for(WastepaperDetail rs:receivinfReport){
							double DetentionCharges=rs.getDetentionCharges();
							totalDetentionCharges=totalDetentionCharges+DetentionCharges;
						}
						table.addCell("$"+totalDetentionCharges, PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_RIGHT, 1	, 1);
						
						table.addCell("Tonu Charge", PdfStyle.FONT_BOLD_10, PdfStyle.ALIGN_LEFT, 1	, 1);
						table.addCell("", PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_RIGHT, 1	, 1);
						table.addCell("", PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_RIGHT, 1	, 1);
						table.addCell("0", PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_RIGHT, 1	, 1);
						
						table.addCell(" ", PdfStyle.FONT_BOLD_10, PdfStyle.ALIGN_LEFT, 1, 1);
						table.addCell(" ", PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_RIGHT, 1	, 1);
						table.addCell(" ", PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_RIGHT, 1	, 1);
						table.addCell(" ", PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_RIGHT, 1	, 1);
					
				
			}else{
				table.addCell("Problem:", PdfStyle.FONT_BOLD_10, PdfStyle.ALIGN_LEFT, 2, 1,0);
				table.addCell("Need To Communicate With Roshan Soon..", PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2,1,0);
			}
			
			table.addCell("", PdfStyle.FONT_BOLD_10, PdfStyle.ALIGN_LEFT, 2,1,0);
			table.addCell("", PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2,1,0);
			
			table.addCell("", PdfStyle.FONT_BOLD_10, PdfStyle.ALIGN_LEFT, 2,1,0);
			table.addCell("", PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2,1,0);
			
			table.addCell("Copyright 2023 ST Paper1 LLC", PdfStyle.FONT_BOLD_10, PdfStyle.ALIGN_CENTER, 4, 1,1,5,5,5,5,new Color(255,255,204, 0)  );
			table.finish();
			
			
			pdfUtil.close();
		}
		
	}


}

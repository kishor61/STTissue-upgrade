/**
 *Sep 15, 2015
 *WastePaperReceivingReportByPriceHandler.java
 * TODO
 *com.st.wastepaper.report
 *WastePaperReceivingReportByPriceHandler.java
 *Roshan Lal Tailor
 */
package com.st.wastepaper.report;

import java.awt.Color;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.List;

import jakarta.servlet.ServletOutputStream;

import org.springframework.stereotype.Component;

import com.lowagie.text.DocumentException;
import com.st.common.CommonUtil;
import com.st.common.pdfutil.PdfReportUtil;
import com.st.common.pdfutil.PdfStyle;
import com.st.common.pdfutil.PdfReportUtil.Section;
import com.st.common.pdfutil.PdfReportUtil.Table;
import com.st.wastepaper.model.WastepaperDetail;

/**
 * @author roshan
 *
 */
@Component
public class WastePaperReceivingReportByPriceHandler {

	/**
	 * @param receivinfReportByPrice
	 * @param rejectBales 
	 * @param outputStream
	 * @throws Exception 
	 */
	public void createpdfReportByPrice(
			List<WastepaperDetail> receivinfReportByPrice,
			List<WastepaperDetail> rejectBales, OutputStream outputStream) throws Exception {
			SimpleDateFormat dateFormat=new SimpleDateFormat("MM-dd-yyyy");
			if(receivinfReportByPrice!=null && receivinfReportByPrice.size()>0){
			
			PdfReportUtil pdfUtil=new PdfReportUtil();
			pdfUtil.setOuputStream(outputStream);
			pdfUtil.setDocumentTitle("PO Number:-"+receivinfReportByPrice.get(0).getMasterPO());
			pdfUtil.setPage(PdfStyle.PAGE_LEGAL_PORTRAIT);
			pdfUtil.open();
			
			/*Section header=pdfUtil.new Section(10, 10, PdfStyle.ALIGN_CENTER);
			header.addText("ST Tissue LLC, Wastepaper Recieving Report", PdfStyle.FONT_BOLD_UNDERLINE_16);
			header.addText("\n\n", PdfStyle.FONT_NORMAL_10);
			header.finish();*/
			
			Table table=pdfUtil.new Table(6, new float[]{1,1,1,1,1,1});
			table.addCell("ST Paper1, LLC WASTEPAPER RECEIVING REPORT", PdfStyle.FONT_BOLD_10, PdfStyle.ALIGN_CENTER, 6, 1,1,5,5,5,5,new Color(204, 204, 255, 0)  );
			if(receivinfReportByPrice.size()==1){
				for(WastepaperDetail rs:receivinfReportByPrice){

					table.addCellLeftBorder("Master PO #", PdfStyle.FONT_BOLD_10, PdfStyle.ALIGN_LEFT, 3, 1,0);
					table.addCellRightBorder(rs.getMasterPO(), PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 3,1,0);
					
					table.addCellLeftBorder("Release #", PdfStyle.FONT_BOLD_10, PdfStyle.ALIGN_LEFT, 3,1,0);
					table.addCellRightBorder(""+rs.getReleaseNo(), PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 3,1,0);
					
					table.addCellLeftBorder("Vendor", PdfStyle.FONT_BOLD_10, PdfStyle.ALIGN_LEFT, 3, 1,0);
					table.addCellRightBorder(""+rs.getVandorName(), PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 3	, 1,0);
					
					table.addCellLeftBorder("Grade Ordered", PdfStyle.FONT_BOLD_10, PdfStyle.ALIGN_LEFT, 3	, 1,0);
					table.addCellRightBorder(""+rs.getItemDescription(), PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 3	, 1,0);
					
					table.addCellLeftBorder("Date Dropped", PdfStyle.FONT_BOLD_10, PdfStyle.ALIGN_LEFT, 3, 1,0);
					table.addCellRightBorder(""+dateFormat.format(rs.getDroppedDate()), PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 3	, 1,0);
					
					table.addCellLeftBorder("Date Unloaded", PdfStyle.FONT_BOLD_10, PdfStyle.ALIGN_LEFT, 3	, 1,0);
					table.addCellRightBorder(""+dateFormat.format(rs.getDroppedDate()), PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 3	, 1,0);
					
					table.addCellLeftBorder("Carrier", PdfStyle.FONT_BOLD_10, PdfStyle.ALIGN_LEFT, 3, 1,0);
					table.addCellRightBorder(""+rs.getCarrier(), PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 3	, 1,0);
					
					table.addCellLeftBorder("Trailer #", PdfStyle.FONT_BOLD_10, PdfStyle.ALIGN_LEFT, 3	, 1,0);
					table.addCellRightBorder(""+rs.getTrailerNo(), PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 3	, 1,0);
					
					table.addCellLeftBorder("Origin", PdfStyle.FONT_BOLD_10, PdfStyle.ALIGN_LEFT, 3, 1,0);
					table.addCellRightBorder(""+rs.getShippingCity()+","+rs.getShippingState(), PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 3	, 1,0);
					
					table.addCellLeftBorder("Weight", PdfStyle.FONT_BOLD_10, PdfStyle.ALIGN_LEFT, 3	, 1,0);
					table.addCellRightBorder(""+CommonUtil.round(+rs.getNetTons()*2000, 2), PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 3	, 1,0);
					
					table.addCell("Received Grade", PdfStyle.FONT_BOLD_10, PdfStyle.ALIGN_CENTER, 1	, 1,1,5,5,5,5,new Color(220,220,200,0));
					table.addCell("Bales", PdfStyle.FONT_BOLD_10, PdfStyle.ALIGN_CENTER, 1	, 1,1,5,5,5,5,new Color(220,220,200,0));
					table.addCell("Received Weight", PdfStyle.FONT_BOLD_10, PdfStyle.ALIGN_CENTER, 1	, 1,1,5,5,5,5,new Color(220,220,200,0));
					table.addCell("Tons", PdfStyle.FONT_BOLD_10, PdfStyle.ALIGN_CENTER, 1	, 1,1,5,5,5,5,new Color(220,220,200,0));
					table.addCell("Cost Per Ton", PdfStyle.FONT_BOLD_10, PdfStyle.ALIGN_CENTER, 1	, 1,1,5,5,5,5,new Color(220,220,200,0));
					table.addCell("Extension", PdfStyle.FONT_BOLD_10, PdfStyle.ALIGN_CENTER, 1	, 1,1,5,5,5,5,new Color(220,220,200,0));
					
					table.addCell(""+rs.getItemDescription(), PdfStyle.FONT_BOLD_10, PdfStyle.ALIGN_LEFT, 1	, 1);
					table.addCell(""+rs.getBales(), PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_RIGHT, 1	, 1);
					table.addCell(""+CommonUtil.round(rs.getNetTons()*2000, 2), PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_RIGHT, 1	, 1);
					table.addCell(""+CommonUtil.round(rs.getNetTons(), 2), PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_RIGHT, 1	, 1);
					table.addCell(""+CommonUtil.round(rs.getPricePerTon(), 2), PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_RIGHT, 1	, 1);
					table.addCell("$"+CommonUtil.round(rs.getExtention(), 2), PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_RIGHT, 1	, 1);
					
					table.addCell("Total of Good Received Weight", PdfStyle.FONT_BOLD_10, PdfStyle.ALIGN_LEFT, 1	, 1);
					table.addCell(""+rs.getBales(), PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_RIGHT, 1	, 1);
					table.addCell(""+CommonUtil.round(rs.getNetTons()*2000, 2), PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_RIGHT, 1	, 1);
					table.addCell(""+CommonUtil.round(rs.getNetTons(), 2), PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_RIGHT, 1	, 1);
					table.addCell("", PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_RIGHT, 1	, 1);
					table.addCell("$"+CommonUtil.round(rs.getExtention(), 2), PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_RIGHT, 1	, 1);		
					
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
					table.addCell("0", PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_RIGHT, 1	, 1);
					table.addCell("0", PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_RIGHT, 1	, 1);
					
					
					table.addCell("Freight Charge Back", PdfStyle.FONT_BOLD_10, PdfStyle.ALIGN_LEFT, 1	, 1);
					table.addCell("", PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_RIGHT, 1	, 1);
					table.addCell("", PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_RIGHT, 1	, 1);
					table.addCell("", PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_RIGHT, 1	, 1);
					table.addCell("", PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_RIGHT, 1	, 1);
					String check=rs.getFreightCHBKPending();
					System.out.println("check::"+check);
					
					if(rs.getFreightCHBKPending()!="Pending" ||rs.getFreightCHBKPending()!=null){
						table.addCell("$("+CommonUtil.round(+rs.getFreightCHBK(), 2)+")", PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_RIGHT, 1	, 1);
					}
					else if(rs.getFreightCHBKPending().equalsIgnoreCase("Pending")){
						table.addCell("Pending", PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_RIGHT, 1	, 1);
					}
					else if(rs.getFreightCHBKPending()==null ||rs.getFreightCHBKPending()==""){
						table.addCell("$0.0", PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_RIGHT, 1	, 1);
					}
					
					table.addCell("Detention Charge", PdfStyle.FONT_BOLD_10, PdfStyle.ALIGN_LEFT, 1	, 1);
					table.addCell("", PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_RIGHT, 1	, 1);
					table.addCell("", PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_RIGHT, 1	, 1);
					table.addCell("", PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_RIGHT, 1	, 1);
					table.addCell("", PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_RIGHT, 1	, 1);
					table.addCell(""+CommonUtil.round(rs.getDetentionCharges(), 2), PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_RIGHT, 1	, 1);
					
					
					table.addCell("Tonu Charge", PdfStyle.FONT_BOLD_10, PdfStyle.ALIGN_LEFT, 1	, 1);
					table.addCell("", PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_RIGHT, 1	, 1);
					table.addCell("", PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_RIGHT, 1	, 1);
					table.addCell("", PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_RIGHT, 1	, 1);
					table.addCell("", PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_RIGHT, 1	, 1);
					table.addCell("", PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_RIGHT, 1	, 1);
					
					table.addCell("Net Amount Due", PdfStyle.FONT_BOLD_10, PdfStyle.ALIGN_LEFT, 1	, 1);
					table.addCell("", PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_RIGHT, 1	, 1);
					table.addCell("", PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_RIGHT, 1	, 1);
					table.addCell("", PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_RIGHT, 1	, 1);
					table.addCell("", PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_RIGHT, 1	, 1);
					/*table.addCell("$"+CommonUtil.round(rs.getGrandTotal(), 2), PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_RIGHT, 1	, 1);*/
					table.addCell("$"+CommonUtil.round(rs.getExtention()-rs.getFreightCHBK()+rs.getDetentionCharges(), 2), PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_RIGHT, 1	, 1);
					
				}
			}else if(receivinfReportByPrice.size()>1){
				
					table.addCellLeftBorder("Master PO #", PdfStyle.FONT_BOLD_10, PdfStyle.ALIGN_LEFT, 3, 1,0);
					table.addCellRightBorder(receivinfReportByPrice.get(0).getMasterPO(), PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 3,1,0);
					
					table.addCellLeftBorder("Release #", PdfStyle.FONT_BOLD_10, PdfStyle.ALIGN_LEFT, 3,1,0);
					table.addCellRightBorder(""+receivinfReportByPrice.get(0).getReleaseNo(), PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 3,1,0);
					
					table.addCellLeftBorder("Vendor", PdfStyle.FONT_BOLD_10, PdfStyle.ALIGN_LEFT, 3, 1,0);
					table.addCellRightBorder(""+receivinfReportByPrice.get(0).getVandorName(), PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 3	, 1,0);
					
					String totalItems="";
					for(WastepaperDetail rs:receivinfReportByPrice){
						String items=rs.getItemDescription();
						totalItems=totalItems+","+items;
					}
					String gradeValue = totalItems;
					gradeValue = gradeValue.substring(1);
					
					table.addCellLeftBorder("Grade Ordered", PdfStyle.FONT_BOLD_10, PdfStyle.ALIGN_LEFT, 3	, 1,0);
					table.addCellRightBorder(""+gradeValue, PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 3	, 1,0);
					
					table.addCellLeftBorder("Date Dropped", PdfStyle.FONT_BOLD_10, PdfStyle.ALIGN_LEFT, 3, 1,0);
					table.addCellRightBorder(""+dateFormat.format(receivinfReportByPrice.get(0).getDroppedDate()), PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 3	, 1,0);
					
					table.addCellLeftBorder("Date Unloaded", PdfStyle.FONT_BOLD_10, PdfStyle.ALIGN_LEFT, 3	, 1,0);
					table.addCellRightBorder(""+dateFormat.format(receivinfReportByPrice.get(0).getUnloadedDate()), PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 3	, 1,0);
					
					table.addCellLeftBorder("Carrier", PdfStyle.FONT_BOLD_10, PdfStyle.ALIGN_LEFT, 3, 1,0);
					table.addCellRightBorder(""+receivinfReportByPrice.get(0).getCarrier(), PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 3	, 1,0);
					
					table.addCellLeftBorder("Trailer #", PdfStyle.FONT_BOLD_10, PdfStyle.ALIGN_LEFT, 3	, 1,0);
					table.addCellRightBorder(""+receivinfReportByPrice.get(0).getTrailerNo(), PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 3	, 1,0);
					
					table.addCellLeftBorder("Origin", PdfStyle.FONT_BOLD_10, PdfStyle.ALIGN_LEFT, 3, 1,0);
					table.addCellRightBorder(""+receivinfReportByPrice.get(0).getShippingCity()+","+receivinfReportByPrice.get(0).getShippingState(), PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 3	, 1,0);
					
					double totalNetTons=0;
					for(WastepaperDetail rs:receivinfReportByPrice){
						double NetTons=rs.getNetTons();
						totalNetTons=totalNetTons+NetTons;
					}
					table.addCellLeftBorder("Weight", PdfStyle.FONT_BOLD_10, PdfStyle.ALIGN_LEFT, 3	, 1,0);
					table.addCellRightBorder(""+CommonUtil.round(+totalNetTons*2000, 2), PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 3	, 1,0);
					
					table.addCell("Received Grade", PdfStyle.FONT_BOLD_10, PdfStyle.ALIGN_CENTER, 1	, 1,1,5,5,5,5,new Color(220,220,200,0));
					table.addCell("Bales", PdfStyle.FONT_BOLD_10, PdfStyle.ALIGN_CENTER, 1	, 1,1,5,5,5,5,new Color(220,220,200,0));
					table.addCell("Received Weight", PdfStyle.FONT_BOLD_10, PdfStyle.ALIGN_CENTER, 1	, 1,1,5,5,5,5,new Color(220,220,200,0));
					table.addCell("Tons", PdfStyle.FONT_BOLD_10, PdfStyle.ALIGN_CENTER, 1	, 1,1,5,5,5,5,new Color(220,220,200,0));
					table.addCell("Cost Per Ton", PdfStyle.FONT_BOLD_10, PdfStyle.ALIGN_CENTER, 1	, 1,1,5,5,5,5,new Color(220,220,200,0));
					table.addCell("Extension", PdfStyle.FONT_BOLD_10, PdfStyle.ALIGN_CENTER, 1	, 1,1,5,5,5,5,new Color(220,220,200,0));
					
					double totalBales=0;
					double totalNetTon=0;
					double totalExtension=0;
					
					for(WastepaperDetail rs:receivinfReportByPrice){
						double Bales=rs.getBales();
						double tons=rs.getNetTons();
						double extension=rs.getExtention();
						totalBales=totalBales+Bales;
						totalNetTon=totalNetTon+tons;
						totalExtension=totalExtension+extension;
						
					table.addCell(""+rs.getItemDescription(), PdfStyle.FONT_BOLD_10, PdfStyle.ALIGN_LEFT, 1	, 1);
					table.addCell(""+rs.getBales(), PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_RIGHT, 1	, 1);
					table.addCell(""+CommonUtil.round(rs.getNetTons()*2000, 2), PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_RIGHT, 1	, 1);
					table.addCell(""+CommonUtil.round(rs.getNetTons(), 2), PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_RIGHT, 1	, 1);
					table.addCell(""+CommonUtil.round(rs.getPricePerTon(), 2), PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_RIGHT, 1	, 1);
					table.addCell("$"+CommonUtil.round(rs.getExtention(), 2), PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_RIGHT, 1	, 1);
					}
					table.addCell("Total of Good Received Weight", PdfStyle.FONT_BOLD_10, PdfStyle.ALIGN_LEFT, 1	, 1);
					table.addCell(""+totalBales, PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_RIGHT, 1	, 1);
					table.addCell(""+CommonUtil.round(totalNetTon*2000, 2), PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_RIGHT, 1	, 1);
					table.addCell(""+CommonUtil.round(totalNetTon, 2), PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_RIGHT, 1	, 1);
					table.addCell("", PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_RIGHT, 1	, 1);
					table.addCell("$"+CommonUtil.round(totalExtension, 2), PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_RIGHT, 1	, 1);		
					
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
					table.addCell("0", PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_RIGHT, 1	, 1);
					table.addCell("0", PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_RIGHT, 1	, 1);
					
					
					table.addCell("Freight Charge Back", PdfStyle.FONT_BOLD_10, PdfStyle.ALIGN_LEFT, 1	, 1);
					table.addCell("", PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_RIGHT, 1	, 1);
					table.addCell("", PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_RIGHT, 1	, 1);
					table.addCell("", PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_RIGHT, 1	, 1);
					table.addCell("", PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_RIGHT, 1	, 1);
					
					if(receivinfReportByPrice.get(0).getFreightCHBKPending()!="Pending" ||receivinfReportByPrice.get(0).getFreightCHBKPending()!=null && receivinfReportByPrice.get(1).getFreightCHBKPending()!="Pending" ||receivinfReportByPrice.get(1).getFreightCHBKPending()!=null){
						double totalFCB=0;
						if(receivinfReportByPrice.size()>1){
							for(WastepaperDetail rs:receivinfReportByPrice){
								double FCB=rs.getFreightCHBK();
								totalFCB=totalFCB+FCB;
							}
						}
						table.addCell("$("+CommonUtil.round(+totalFCB, 2)+")", PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_RIGHT, 1	, 1);
					}
					else if(receivinfReportByPrice.get(0).getFreightCHBKPending().equalsIgnoreCase("Pending")){
						table.addCell("Pending", PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_RIGHT, 1	, 1);
					}
					/*else if(rs.getFreightCHBKPending()==null ||rs.getFreightCHBKPending()==""){
						table.addCell("$0.0", PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_CENTER, 1	, 1);
					}*/
					else{
						double totalFCB=0;
						if(receivinfReportByPrice.size()>1){
							for(WastepaperDetail rs:receivinfReportByPrice){
								double FCB=rs.getFreightCHBK();
								totalFCB=totalFCB+FCB;
							}
						}
						table.addCell("$"+totalFCB, PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_RIGHT, 1	, 1);
					}
					
					table.addCell("Detention Charge", PdfStyle.FONT_BOLD_10, PdfStyle.ALIGN_LEFT, 1	, 1);
					table.addCell("", PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_RIGHT, 1	, 1);
					table.addCell("", PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_RIGHT, 1	, 1);
					table.addCell("", PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_RIGHT, 1	, 1);
					table.addCell("", PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_RIGHT, 1	, 1);
					double totalDetentionCharges=0;
					for(WastepaperDetail rs:receivinfReportByPrice){
						double DetentionCharges=rs.getDetentionCharges();
						totalDetentionCharges=totalDetentionCharges+DetentionCharges;
					}
					table.addCell("$ "+CommonUtil.round(totalDetentionCharges, 2), PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_RIGHT, 1	, 1);
					
					
					table.addCell("Tonu Charge", PdfStyle.FONT_BOLD_10, PdfStyle.ALIGN_LEFT, 1	, 1);
					table.addCell("", PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_RIGHT, 1	, 1);
					table.addCell("", PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_RIGHT, 1	, 1);
					table.addCell("", PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_RIGHT, 1	, 1);
					table.addCell("", PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_RIGHT, 1	, 1);
					table.addCell("", PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_RIGHT, 1	, 1);
					
					table.addCell("Net Amount Due", PdfStyle.FONT_BOLD_10, PdfStyle.ALIGN_LEFT, 1	, 1);
					table.addCell("", PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_RIGHT, 1	, 1);
					table.addCell("", PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_RIGHT, 1	, 1);
					table.addCell("", PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_RIGHT, 1	, 1);
					table.addCell("", PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_RIGHT, 1	, 1);
					
					double totalGrandTotal=0;
					double totalExtension1=0;
					double totalFreightCHBK=0;
					double totalDetentionCharges1=0;
					
					for(WastepaperDetail rs:receivinfReportByPrice){
						double GrandTotal=rs.getGrandTotal();
						double Extension=rs.getExtention();
						double FreightCHBK=rs.getFreightCHBK();
						double DetentionCharges=rs.getDetentionCharges();
						
						totalGrandTotal=totalGrandTotal+GrandTotal;
						totalExtension1=totalExtension1+Extension;
						totalFreightCHBK=totalFreightCHBK+FreightCHBK;
						totalDetentionCharges1=totalDetentionCharges1+DetentionCharges;
						
						
					}
					double netAmountDue=totalExtension1-totalFreightCHBK+totalDetentionCharges1;
					table.addCell("$ "+CommonUtil.round(netAmountDue, 2), PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_RIGHT, 1	, 1);
					
				}
			else{
					table.addCell("Problem:", PdfStyle.FONT_BOLD_10, PdfStyle.ALIGN_LEFT, 2, 1,0);
					table.addCell("Need To Communicate With Roshan Soon..", PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2,1,0);
			}
			
				
					table.addCell("", PdfStyle.FONT_BOLD_10, PdfStyle.ALIGN_LEFT, 3, 1,0);
					table.addCell("", PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 3,1,0);
					
					table.addCell("", PdfStyle.FONT_BOLD_10, PdfStyle.ALIGN_LEFT, 3, 1,0);
					table.addCell("", PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 3,1,0);
			
					table.addCell("Copyright 2023 ST Paper1 LLC", PdfStyle.FONT_BOLD_10, PdfStyle.ALIGN_CENTER, 6, 1,1,5,5,5,5,new Color(255,255,204, 0)  );
					table.finish();
			
			
			pdfUtil.close();
		}
		
	}

}

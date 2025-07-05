/**
 *Dec 22, 2017
 *QualityReportHandlerPM5.java
 * TODO
 *com.st.qualitypm5.report
 *QualityReportHandlerPM5.java
 *Roshan Lal Tailor
 */
package com.st.qualitypm5.report;

import java.awt.Color;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

import jakarta.servlet.ServletOutputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Phrase;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.st.common.ColumnsOfTable;
import com.st.common.CommonUtil;
import com.st.qualitypm5.model.ReelPM5;
import com.st.qualitypm5.model.RewindPM5;
import com.st.qualitypm5.service.ReelServicePM5;
import com.st.qualitypm5.service.RewindServicePM5;
import com.st.qualitypm6.service.RewindService;

/**
 * @author roshan
 *
 */
@Component
public class QualityReportHandlerPM5 {

	@Autowired
	private ReelServicePM5 reelService;
	
	@Autowired
	private RewindServicePM5 rewindServicePM5;
	
	
	/**
	 * @param reels
	 * @param outputStream
	 * @throws DocumentException 
	 * @throws ParseException 
	 */
	public void createReelReport(List<ReelPM5> reels, ServletOutputStream outputStream) throws DocumentException, ParseException {
		

		int red1 = 0,red2= 0,red3= 0,red4= 0,red5= 0,red6= 0,red7= 0,red8= 0,red9= 0,red10= 0,red11= 0,red12= 0,red13= 0;
		int green1= 0,green2= 0,green3= 0,green4= 0,green5= 0,green6= 0,green7= 0,green8= 0,green9= 0,green10 = 0 ,green11 = 0,green12 = 0,green13 = 0 ;
		int yellow1= 0,yellow2= 0,yellow3= 0,yellow4= 0,yellow5= 0,yellow6= 0,yellow7= 0,yellow8= 0,yellow9= 0,yellow10 = 0,yellow11 = 0,yellow12 = 0 ,yellow13 = 0;
		
		
		int loopi = 0;
		
if(reels!=null && reels.size()>0){
			
			Font fontHeader=FontFactory.getFont("Times-Roman", 6, Font.BOLD);
			Font fontTitle=FontFactory.getFont("Times-Roman", 8, Font.BOLD);
			Font fontNormal=FontFactory.getFont("Times-Roman", 6, Font.BOLD);
			Font fontNormalRed=FontFactory.getFont("Times-Roman", 6, Font.BOLD,Color.RED);
			Font fontNormalBlue=FontFactory.getFont("Times-Roman", 6, Font.BOLD,Color.BLUE);
			
			Rectangle rectangle=new Rectangle(3*355.6f, 4*215.9f);

			Document document=new Document(rectangle,-100f,-100f,30f,10f);
			
			
			PdfWriter.getInstance(document, outputStream);
			
			document.open();
			
			PdfPTable	table=new PdfPTable(33);
			
			table.setWidths(new int[]{2,1,2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,3,3});	
			
			
			table.addCell(getPdfCell("ST Tissue PM 5 Tissue Machine Quality Report-REEL Testing", 33,fontTitle,Color.YELLOW,18f));
			
			//Col header
			table.addCell(getPdfCell("Date", 1,fontHeader,Color.WHITE,30f));
			table.addCell(getPdfCell("Time", 1,fontHeader,Color.WHITE,30f));
			table.addCell(getPdfCell("Grade Code", 1,fontHeader,Color.WHITE,30f));
			table.addCell(getPdfCell("Reel #", 1,fontHeader,Color.WHITE,30f));
			table.addCell(getPdfCell("Scanner Basis wt lbs/3000", 1,fontHeader,Color.LIGHT_GRAY,30f));
			table.addCell(getPdfCell("Actual Basis wt lbs/3000ft", 1,fontHeader,Color.WHITE,30f));
			table.addCell(getPdfCell("Bulk At Reel mils/8 ply", 1,fontHeader,Color.WHITE,30f));
			table.addCell(getPdfCell("MD Tensile g/inch	", 1,fontHeader,Color.WHITE,30f));
			table.addCell(getPdfCell("CD Tensile g/inch", 1,fontHeader,Color.WHITE,30f));
			table.addCell(getPdfCell("MD % Stretch", 1,fontHeader,Color.WHITE,30f));
			table.addCell(getPdfCell("MD/CD Tensile Ratio", 1,fontHeader,Color.WHITE,30f));
			table.addCell(getPdfCell("MD Wet Tensile g/inch", 1,fontHeader,Color.WHITE,30f));
			table.addCell(getPdfCell("FinchCup g/inch", 1,fontHeader,Color.WHITE,30f));
			table.addCell(getPdfCell("CD Wet Tensile g/inch", 1,fontHeader,Color.WHITE,30f));
			table.addCell(getPdfCell("CD Tensile Ratio Wet/Dry", 1,fontHeader,Color.WHITE,30f));
			table.addCell(getPdfCell("Bright ness %", 1,fontHeader,Color.WHITE,30f));
			table.addCell(getPdfCell("FWA Flow (ml/min)", 1,fontHeader,Color.WHITE,30f));
			
			table.addCell(getPdfCell("AKD (gpm)", 1,fontHeader,Color.WHITE,30f));
			table.addCell(getPdfCell("Wet Strength(gpm)", 1,fontHeader,Color.WHITE,30f));
			table.addCell(getPdfCell("2 Sigma BW CD", 1,fontHeader,Color.WHITE,30f));
			
			
			table.addCell(getPdfCell("2 Sigma Moisture CD", 1,fontHeader,Color.WHITE,30f));
			/*table.addCell(getPdfCell("FWA Dosage lb/Ton", 1,fontHeader,Color.WHITE,30f));
			 * <!-- Firstly it was FWA Dosage After Then Changed It To  Moisture %-->
			 * */
			table.addCell(getPdfCell("Moisture %", 1,fontHeader,Color.WHITE,30f));
			table.addCell(getPdfCell("TPH", 1,fontHeader,Color.WHITE,30f));
			table.addCell(getPdfCell("Trim", 1,fontHeader,Color.WHITE,30f));
			table.addCell(getPdfCell("Crepe Ratio", 1,fontHeader,Color.WHITE,30f));
			table.addCell(getPdfCell("Front Roll Diameter", 1,fontHeader,Color.WHITE,30f));
			table.addCell(getPdfCell("Back Roll Diameter", 1,fontHeader,Color.WHITE,30f));
//			Code Starts From Here Done By Roshan Tailor Date :-03/07/2015 MM/DD/YYYY
			table.addCell(getPdfCell("L Value", 1, fontHeader, Color.WHITE, 30f));
			table.addCell(getPdfCell("A Value", 1, fontHeader, Color.WHITE, 30f));
			table.addCell(getPdfCell("B Value", 1, fontHeader, Color.WHITE, 30f));
			table.addCell(getPdfCell("Delta E", 1, fontHeader, Color.WHITE, 30f));
//			Code Ends Here Done By Roshan Tailor
			table.addCell(getPdfCell("Customer", 1,fontHeader,Color.WHITE,30f));
			table.addCell(getPdfCell("Remarks", 1,fontHeader,Color.WHITE,30f));
			
			
			//data
			for (Map<String, Object> map : reelService.getFormatedData(reels)) {
				if(map.get(ColumnsOfTable.COL_01).toString().equalsIgnoreCase("OBJECTIVES")){
					table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_01).toString(), 1,fontNormalBlue,Color.WHITE,15f));
					table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_02).toString(), 1,fontNormalBlue,Color.WHITE,15f));
					table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_03).toString(), 1,fontNormalRed,Color.WHITE,15f));
					table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_04).toString(), 1,fontNormalBlue,Color.WHITE,15f));
					table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_05).toString(), 1,fontNormal,Color.LIGHT_GRAY,15f));
					table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_06).toString(), 1,fontNormalBlue,Color.WHITE,15f));
					table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_07).toString(), 1,fontNormalBlue,Color.WHITE,15f));
					table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_08).toString(), 1,fontNormalBlue,Color.WHITE,15f));
					table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_09).toString(), 1,fontNormalBlue,Color.WHITE,15f));
					table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_10).toString(), 1,fontNormalBlue,Color.WHITE,15f));
					table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_11).toString(), 1,fontNormalBlue,Color.WHITE,15f));
					table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_12).toString(), 1,fontNormalBlue,Color.WHITE,15f));
					table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_34).toString(), 1,fontNormalBlue,Color.WHITE,15f));
					table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_13).toString(), 1,fontNormalBlue,Color.WHITE,15f));
					table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_14).toString(), 1,fontNormalBlue,Color.WHITE,15f));
					table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_15).toString(), 1,fontNormalBlue,Color.WHITE,15f));
					table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_16).toString(), 1,fontNormalBlue,Color.WHITE,15f));
					
					table.addCell(getPdfCell("N/A", 1,fontNormalBlue,Color.WHITE,15f));
					table.addCell(getPdfCell("N/A", 1,fontNormalBlue,Color.WHITE,15f));
					table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_31).toString(), 1,fontNormalBlue,Color.WHITE,15f));
					table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_17).toString(), 1,fontNormalBlue,Color.WHITE,15f));
					table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_18).toString(), 1,fontNormalBlue,Color.WHITE,15f));
					table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_19).toString(), 1,fontNormalBlue,Color.WHITE,15f));
					table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_20).toString(), 1,fontNormalBlue,Color.WHITE,15f));
					table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_21).toString(), 1,fontNormalBlue,Color.WHITE,15f));
					table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_35).toString(), 1,fontNormalBlue,Color.WHITE,15f));
					table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_36).toString(), 1,fontNormalBlue,Color.WHITE,15f));
//					Code Starts From Here Done By Roshan Tailor Date:- 03/07/2015
					table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_22).toString(), 1,fontNormalBlue,Color.WHITE,15f));
					table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_23).toString(), 1,fontNormalBlue,Color.WHITE,15f));
					table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_24).toString(), 1,fontNormalBlue,Color.WHITE,15f));
					table.addCell(getPdfCell("0.0", 1,fontNormalBlue,Color.WHITE,15f));
//					Code Ends Here Done By Roshan Tailor
					table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_25).toString(), 1,fontNormalBlue,Color.WHITE,15f));
					table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_26).toString(), 1,fontNormalBlue,Color.WHITE,15f));
				}else{
					table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_01).toString(), 1,fontNormal,Color.WHITE,15f));
					table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_02).toString(), 1,fontNormal,Color.WHITE,15f));
					table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_03).toString(), 1,fontNormal,Color.WHITE,15f));
					table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_04).toString(), 1,fontNormal,Color.WHITE,15f));
					table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_05).toString(), 1,fontNormal,Color.LIGHT_GRAY,15f));
					
					
					if(map.get(ColumnsOfTable.COL_06_C).toString().equalsIgnoreCase("redcolor")){
						red1 = red1+1;
						table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_06).toString(), 1,fontNormal,Color.RED,15f));
					}else if(map.get(ColumnsOfTable.COL_06_C).toString().equalsIgnoreCase("greencolor")){
						green1 = green1+1;
						table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_06).toString(), 1,fontNormal,Color.GREEN,15f));
					}else if(map.get(ColumnsOfTable.COL_06_C).toString().equalsIgnoreCase("yellowcolor")){
						yellow1 = yellow1+1;
						table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_06).toString(), 1,fontNormal,Color.YELLOW,15f));
					}else{
						green1 = green1+1;
						table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_06).toString(), 1,fontNormal,Color.GREEN,15f));
					}
					
					
					
					if(map.get(ColumnsOfTable.COL_07_C).toString().equalsIgnoreCase("redcolor")){
						red2 = red2+1;
						table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_07).toString(), 1,fontNormal,Color.RED,15f));
					}else if(map.get(ColumnsOfTable.COL_07_C).toString().equalsIgnoreCase("greencolor")){
						green2 = green2+1;
						table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_07).toString(), 1,fontNormal,Color.GREEN,15f));
					}else if(map.get(ColumnsOfTable.COL_07_C).toString().equalsIgnoreCase("yellowcolor")){
						yellow2 = yellow2+1;
						table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_07).toString(), 1,fontNormal,Color.YELLOW,15f));
					}else{
						green2 = green2+1;
						table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_07).toString(), 1,fontNormal,Color.GREEN,15f));
					}
					
					
					if(map.get(ColumnsOfTable.COL_08_C).toString().equalsIgnoreCase("redcolor")){
						red3 = red1+3;
						table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_08).toString(), 1,fontNormal,Color.RED,15f));
					}else if(map.get(ColumnsOfTable.COL_08_C).toString().equalsIgnoreCase("greencolor")){
						table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_08).toString(), 1,fontNormal,Color.GREEN,15f));
						green3 = green3+1;
					}else if(map.get(ColumnsOfTable.COL_08_C).toString().equalsIgnoreCase("yellowcolor")){
						yellow3 = yellow3+1;
						table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_08).toString(), 1,fontNormal,Color.YELLOW,15f));
					}else{
						green3 = green3+1;
						table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_08).toString(), 1,fontNormal,Color.GREEN,15f));
					}
					
					
					if(map.get(ColumnsOfTable.COL_09_C).toString().equalsIgnoreCase("redcolor")){
						red4 = red4+1;
						table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_09).toString(), 1,fontNormal,Color.RED,15f));
					}else if(map.get(ColumnsOfTable.COL_09_C).toString().equalsIgnoreCase("greencolor")){
						green4 = green4+1;
						table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_09).toString(), 1,fontNormal,Color.GREEN,15f));
					}else if(map.get(ColumnsOfTable.COL_09_C).toString().equalsIgnoreCase("yellowcolor")){
						yellow4 = yellow4+1;
						table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_09).toString(), 1,fontNormal,Color.YELLOW,15f));
					}else{
						green4 = green4+1;
						table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_09).toString(), 1,fontNormal,Color.GREEN,15f));
					}
					
					
					
					if(map.get(ColumnsOfTable.COL_10_C).toString().equalsIgnoreCase("redcolor")){
						red5 = red5+1;
						table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_10).toString(), 1,fontNormal,Color.RED,15f));
					}else if(map.get(ColumnsOfTable.COL_10_C).toString().equalsIgnoreCase("greencolor")){
						green5 = green5+1;
						table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_10).toString(), 1,fontNormal,Color.GREEN,15f));
					}else if(map.get(ColumnsOfTable.COL_10_C).toString().equalsIgnoreCase("yellowcolor")){
						yellow5 = yellow5+1;
						table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_10).toString(), 1,fontNormal,Color.YELLOW,15f));
					}else{
						green5 = green5+1;
						table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_10).toString(), 1,fontNormal,Color.GREEN,15f));
					}
					
					
					
					if(map.get(ColumnsOfTable.COL_11_C).toString().equalsIgnoreCase("redcolor")){
						red6 = red6+1;
						table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_11).toString(), 1,fontNormal,Color.RED,15f));
					}else if(map.get(ColumnsOfTable.COL_11_C).toString().equalsIgnoreCase("greencolor")){
						green6 = green6+1;
						table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_11).toString(), 1,fontNormal,Color.GREEN,15f));
					}else if(map.get(ColumnsOfTable.COL_11_C).toString().equalsIgnoreCase("yellowcolor")){
						yellow6 = yellow6+1;
						table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_11).toString(), 1,fontNormal,Color.YELLOW,15f));
					}else{
						green6 = green6+1;
						table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_11).toString(), 1,fontNormal,Color.GREEN,15f));
					}
					
					
					
					if(map.get(ColumnsOfTable.COL_12_C).toString().equalsIgnoreCase("redcolor")){
						red7 = red7+1;
						table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_12).toString(), 1,fontNormal,Color.RED,15f));
					}else if(map.get(ColumnsOfTable.COL_12_C).toString().equalsIgnoreCase("greencolor")){
						green7 = green7+1;
						table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_12).toString(), 1,fontNormal,Color.GREEN,15f));
					}else if(map.get(ColumnsOfTable.COL_12_C).toString().equalsIgnoreCase("yellowcolor")){
						yellow7 = yellow7+1;
						table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_12).toString(), 1,fontNormal,Color.YELLOW,15f));
					}else{
						green7 = green7+1;
						table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_12).toString(), 1,fontNormal,Color.GREEN,15f));
					}
					
					if(map.get(ColumnsOfTable.COL_12_C).toString().equalsIgnoreCase("redcolor")){
						red8 = red8+1;
						table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_12).toString(), 1,fontNormal,Color.RED,15f));
					}else if(map.get(ColumnsOfTable.COL_12_C).toString().equalsIgnoreCase("greencolor")){
						green8 = green8+1;
						table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_12).toString(), 1,fontNormal,Color.GREEN,15f));
					}else if(map.get(ColumnsOfTable.COL_12_C).toString().equalsIgnoreCase("yellowcolor")){
						yellow8 = yellow8+1;
						table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_12).toString(), 1,fontNormal,Color.YELLOW,15f));
					}else{
						green8 = green8+1;
						table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_12).toString(), 1,fontNormal,Color.GREEN,15f));
					}
					
					if(map.get(ColumnsOfTable.COL_13_C).toString().equalsIgnoreCase("redcolor")){
						red9 = red9+1;
						table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_13).toString(), 1,fontNormal,Color.RED,15f));
					}else if(map.get(ColumnsOfTable.COL_13_C).toString().equalsIgnoreCase("greencolor")){
						green9 = green9+1;
						table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_13).toString(), 1,fontNormal,Color.GREEN,15f));
					}else if(map.get(ColumnsOfTable.COL_13_C).toString().equalsIgnoreCase("yellowcolor")){
						yellow9 = yellow9+1;
						table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_13).toString(), 1,fontNormal,Color.YELLOW,15f));
					}else{
						green9 = green9+1;
						table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_13).toString(), 1,fontNormal,Color.GREEN,15f));
					}
					
					
					
					if(map.get(ColumnsOfTable.COL_14_C).toString().equalsIgnoreCase("redcolor")){
						red10 = red10+1;
						table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_14).toString(), 1,fontNormal,Color.RED,15f));
					}else if(map.get(ColumnsOfTable.COL_14_C).toString().equalsIgnoreCase("greencolor")){
						green10 = green10+1;
						table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_14).toString(), 1,fontNormal,Color.GREEN,15f));
					}else if(map.get(ColumnsOfTable.COL_14_C).toString().equalsIgnoreCase("yellowcolor")){
						yellow10 = yellow10+1;
						table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_14).toString(), 1,fontNormal,Color.YELLOW,15f));
					}else{
						green10 = green10+1;
						table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_14).toString(), 1,fontNormal,Color.GREEN,15f));
					}
					
					
					if(map.get(ColumnsOfTable.COL_15_C).toString().equalsIgnoreCase("redcolor")){
						red11 = red11+1;
						table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_15).toString(), 1,fontNormal,Color.RED,15f));
					}else if(map.get(ColumnsOfTable.COL_15_C).toString().equalsIgnoreCase("greencolor")){
						green11 = green11+1;
						table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_15).toString(), 1,fontNormal,Color.GREEN,15f));
					}else if(map.get(ColumnsOfTable.COL_15_C).toString().equalsIgnoreCase("yellowcolor")){
						yellow11 = yellow11+1;
						table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_15).toString(), 1,fontNormal,Color.YELLOW,15f));
					}else{
						green11 = green11+1;
						table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_15).toString(), 1,fontNormal,Color.GREEN,15f));
					}
					
					table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_16).toString(), 1,fontNormal,Color.WHITE,15f));
					
					table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_29).toString(), 1,fontNormalBlue,Color.WHITE,15f));
					table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_30).toString(), 1,fontNormalBlue,Color.WHITE,15f));
					
					if(map.get(ColumnsOfTable.COL_31_C).toString().equalsIgnoreCase("redcolor")){
						red13 = red13+1;
						table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_31).toString(), 1,fontNormal,Color.RED,15f));
					}else if(map.get(ColumnsOfTable.COL_31_C).toString().equalsIgnoreCase("greencolor")){
						green13 = green13+1;
						table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_31).toString(), 1,fontNormal,Color.GREEN,15f));
					}else if(map.get(ColumnsOfTable.COL_31_C).toString().equalsIgnoreCase("yellowcolor")){
						table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_31).toString(), 1,fontNormal,Color.YELLOW,15f));
						yellow13 = yellow13+1;
					}else{
						green13 = green13+1;
						table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_31).toString(), 1,fontNormal,Color.GREEN,15f));
					}
					
					if(map.get(ColumnsOfTable.COL_17_C).toString().equalsIgnoreCase("redcolor")){
						red12 = red12+1;
						table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_17).toString(), 1,fontNormal,Color.RED,15f));
					}else if(map.get(ColumnsOfTable.COL_17_C).toString().equalsIgnoreCase("greencolor")){
						green12 = green12+1;
						table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_17).toString(), 1,fontNormal,Color.GREEN,15f));
					}else if(map.get(ColumnsOfTable.COL_17_C).toString().equalsIgnoreCase("yellowcolor")){
						table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_17).toString(), 1,fontNormal,Color.YELLOW,15f));
						yellow12 = yellow12+1;
					}else{
						green12 = green12+1;
						table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_17).toString(), 1,fontNormal,Color.GREEN,15f));
					}
					
					table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_18).toString(), 1,fontNormal,Color.WHITE,15f));
					table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_19).toString(), 1,fontNormal,Color.WHITE,15f));
					table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_20).toString(), 1,fontNormal,Color.WHITE,15f));
					table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_21).toString(), 1,fontNormal,Color.WHITE,15f));
					table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_35).toString(), 1,fontNormal,Color.WHITE,15f));
					table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_36).toString(), 1,fontNormal,Color.WHITE,15f));
//					Code Starts From Here Done By Roshan Tailor Date :- 03/07/2015 MM/DD/YYYY
					table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_22).toString(), 1,fontNormal,Color.WHITE,15f));
					table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_23).toString(), 1,fontNormal,Color.WHITE,15f));
					table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_24).toString(), 1,fontNormal,Color.WHITE,15f));
					table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_28).toString(), 1,fontNormal,Color.WHITE,15f));					
//					Code Ends Here Done By Roshan Tailor
					table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_25)!=null?map.get(ColumnsOfTable.COL_25).toString():"", 1,fontNormal,Color.WHITE,15f));
					table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_26)!=null?map.get(ColumnsOfTable.COL_26).toString():"", 1,fontNormal,Color.WHITE,15f));
					
					loopi = loopi+1;
				}
			}
			
			double rPre1=CommonUtil.round((red1*100)/loopi, 2);
			double yPre1=CommonUtil.round((yellow1*100)/loopi, 2);
			double gPre1=CommonUtil.round((green1*100)/loopi, 2);


			double rPre2=CommonUtil.round((red2*100)/loopi, 2);
			double yPre2=CommonUtil.round((yellow2*100)/loopi, 2);
			double gPre2=CommonUtil.round((green2*100)/loopi, 2);

			double rPre3=CommonUtil.round((red3*100)/loopi, 2);
			double yPre3=CommonUtil.round((yellow3*100)/loopi, 2);
			double gPre3=CommonUtil.round((green3*100)/loopi, 2);

			double rPre4=CommonUtil.round((red4*100)/loopi, 2);
			double yPre4=CommonUtil.round((yellow4*100)/loopi, 2);
			double gPre4=CommonUtil.round((green4*100)/loopi, 2);

			double rPre5=CommonUtil.round((red5*100)/loopi, 2);
			double yPre5=CommonUtil.round((yellow5*100)/loopi, 2);
			double gPre5=CommonUtil.round((green5*100)/loopi, 2);

			double rPre6=CommonUtil.round((red6*100)/loopi, 2);
			double yPre6=CommonUtil.round((yellow6*100)/loopi, 2);
			double gPre6=CommonUtil.round((green6*100)/loopi, 2);

			double rPre7=CommonUtil.round((red7*100)/loopi, 2);
			double yPre7=CommonUtil.round((yellow7*100)/loopi, 2);
			double gPre7=CommonUtil.round((green7*100)/loopi, 2);

			double rPre8=CommonUtil.round((red8*100)/loopi, 2);
			double yPre8=CommonUtil.round((yellow8*100)/loopi, 2);
			double gPre8=CommonUtil.round((green8*100)/loopi, 2);

			double rPre9=CommonUtil.round((red9*100)/loopi, 2);
			double yPre9=CommonUtil.round((yellow9*100)/loopi, 2);
			double gPre9=CommonUtil.round((green9*100)/loopi, 2);

			double rPre10=CommonUtil.round((red10*100)/loopi, 2);
			double yPre10=CommonUtil.round((yellow10*100)/loopi, 2);
			double gPre10=CommonUtil.round((green10*100)/loopi, 2);

			double rPre11=CommonUtil.round((red11*100)/loopi, 2);
			double yPre11=CommonUtil.round((yellow11*100)/loopi, 2);
			double gPre11=CommonUtil.round((green11*100)/loopi, 2);
			
			double rPre12=CommonUtil.round((red12*100)/loopi, 2);
			double yPre12=CommonUtil.round((yellow12*100)/loopi, 2);
			double gPre12=CommonUtil.round((green12*100)/loopi, 2);
			
			double rPre13=CommonUtil.round((red13*100)/loopi, 2);
			double yPre13=CommonUtil.round((yellow13*100)/loopi, 2);
			double gPre13=CommonUtil.round((green13*100)/loopi, 2);
			

			
			
			table.addCell(getPdfCell("Percentage", 33,fontTitle,Color.YELLOW,18f));
					

			table.addCell(getPdfCell("", 1,fontNormal,Color.cyan,15f));
			table.addCell(getPdfCell("", 1,fontNormal,Color.cyan,15f));
			table.addCell(getPdfCell("", 1,fontNormal,Color.cyan,15f));
			table.addCell(getPdfCell("", 1,fontNormal,Color.cyan,15f));
			table.addCell(getPdfCell("Red", 1,fontNormal,Color.RED,15f));
			table.addCell(getPdfCell(""+CommonUtil.round(rPre1, 2), 1,fontNormal,Color.cyan,15f));
			table.addCell(getPdfCell(""+CommonUtil.round(rPre2, 2), 1,fontNormal,Color.cyan,15f));
			table.addCell(getPdfCell(""+CommonUtil.round(rPre3, 2), 1,fontNormal,Color.cyan,15f));
			table.addCell(getPdfCell(""+CommonUtil.round(rPre4, 2), 1,fontNormal,Color.cyan,15f));
			table.addCell(getPdfCell(""+CommonUtil.round(rPre5, 2), 1,fontNormal,Color.cyan,15f));
			table.addCell(getPdfCell(""+CommonUtil.round(rPre6, 2), 1,fontNormal,Color.cyan,15f));
			table.addCell(getPdfCell(""+CommonUtil.round(rPre7, 2), 1,fontNormal,Color.cyan,15f));
			table.addCell(getPdfCell(""+CommonUtil.round(rPre8, 2), 1,fontNormal,Color.cyan,15f));
			table.addCell(getPdfCell(""+CommonUtil.round(rPre9, 2), 1,fontNormal,Color.cyan,15f));
			table.addCell(getPdfCell(""+CommonUtil.round(rPre10, 2), 1,fontNormal,Color.cyan,15f));
			table.addCell(getPdfCell("", 1,fontNormal,Color.cyan,15f));
			
			table.addCell(getPdfCell("", 1,fontNormal,Color.cyan,15f));
			table.addCell(getPdfCell("", 1,fontNormal,Color.cyan,15f));
			table.addCell(getPdfCell("", 1,fontNormal,Color.cyan,15f));
			
			
			table.addCell(getPdfCell(""+CommonUtil.round(rPre11, 2), 1,fontNormal,Color.cyan,15f));
			table.addCell(getPdfCell(""+CommonUtil.round(rPre13, 2), 1,fontNormal,Color.cyan,15f));
			table.addCell(getPdfCell(""+CommonUtil.round(rPre12, 2), 1,fontNormal,Color.cyan,15f));
			table.addCell(getPdfCell("", 1,fontNormal,Color.cyan,15f));
			table.addCell(getPdfCell("", 1,fontNormal,Color.cyan,15f));
			table.addCell(getPdfCell("", 1,fontNormal,Color.cyan,15f));
			table.addCell(getPdfCell("", 1,fontNormal,Color.cyan,15f));
			table.addCell(getPdfCell("", 1,fontNormal,Color.cyan,15f));
			table.addCell(getPdfCell("", 1,fontNormal,Color.cyan,15f));
			table.addCell(getPdfCell("", 1,fontNormal,Color.cyan,15f));
			table.addCell(getPdfCell("", 1,fontNormal,Color.cyan,15f));
			table.addCell(getPdfCell("", 1,fontNormal,Color.cyan,15f));
			table.addCell(getPdfCell("", 1,fontNormal,Color.cyan,15f));
			table.addCell(getPdfCell("", 1,fontNormal,Color.cyan,15f));






			table.addCell(getPdfCell("", 1,fontNormal,Color.cyan,15f));
			table.addCell(getPdfCell("", 1,fontNormal,Color.cyan,15f));
			table.addCell(getPdfCell("", 1,fontNormal,Color.cyan,15f));
			table.addCell(getPdfCell("", 1,fontNormal,Color.cyan,15f));
			table.addCell(getPdfCell("Green", 1,fontNormal,Color.GREEN,15f));
			table.addCell(getPdfCell(""+CommonUtil.round(gPre1, 2), 1,fontNormal,Color.cyan,15f));
			table.addCell(getPdfCell(""+CommonUtil.round(gPre2, 2), 1,fontNormal,Color.cyan,15f));
			table.addCell(getPdfCell(""+CommonUtil.round(gPre3, 2), 1,fontNormal,Color.cyan,15f));
			table.addCell(getPdfCell(""+CommonUtil.round(gPre4, 2), 1,fontNormal,Color.cyan,15f));
			table.addCell(getPdfCell(""+CommonUtil.round(gPre5, 2), 1,fontNormal,Color.cyan,15f));
			table.addCell(getPdfCell(""+CommonUtil.round(gPre6, 2), 1,fontNormal,Color.cyan,15f));
			table.addCell(getPdfCell(""+CommonUtil.round(gPre7, 2), 1,fontNormal,Color.cyan,15f));
			table.addCell(getPdfCell(""+CommonUtil.round(gPre8, 2), 1,fontNormal,Color.cyan,15f));
			table.addCell(getPdfCell(""+CommonUtil.round(gPre9, 2), 1,fontNormal,Color.cyan,15f));
			table.addCell(getPdfCell(""+CommonUtil.round(gPre10, 2), 1,fontNormal,Color.cyan,15f));
			table.addCell(getPdfCell("", 1,fontNormal,Color.cyan,15f));
			
			table.addCell(getPdfCell("", 1,fontNormal,Color.cyan,15f));
			table.addCell(getPdfCell("", 1,fontNormal,Color.cyan,15f));
			table.addCell(getPdfCell("", 1,fontNormal,Color.cyan,15f));
			
			
			table.addCell(getPdfCell(""+CommonUtil.round(gPre11, 2), 1,fontNormal,Color.cyan,15f));
			table.addCell(getPdfCell(""+CommonUtil.round(gPre13, 2), 1,fontNormal,Color.cyan,15f));
			table.addCell(getPdfCell(""+CommonUtil.round(gPre12, 2), 1,fontNormal,Color.cyan,15f));
			table.addCell(getPdfCell("", 1,fontNormal,Color.cyan,15f));
			table.addCell(getPdfCell("", 1,fontNormal,Color.cyan,15f));
			table.addCell(getPdfCell("", 1,fontNormal,Color.cyan,15f));
			table.addCell(getPdfCell("", 1,fontNormal,Color.cyan,15f));
			table.addCell(getPdfCell("", 1,fontNormal,Color.cyan,15f));
			table.addCell(getPdfCell("", 1,fontNormal,Color.cyan,15f));
			table.addCell(getPdfCell("", 1,fontNormal,Color.cyan,15f));
			table.addCell(getPdfCell("", 1,fontNormal,Color.cyan,15f));
			table.addCell(getPdfCell("", 1,fontNormal,Color.cyan,15f));
			table.addCell(getPdfCell("", 1,fontNormal,Color.cyan,15f));
			table.addCell(getPdfCell("", 1,fontNormal,Color.cyan,15f));





			table.addCell(getPdfCell("", 1,fontNormal,Color.cyan,15f));
			table.addCell(getPdfCell("", 1,fontNormal,Color.cyan,15f));
			table.addCell(getPdfCell("", 1,fontNormal,Color.cyan,15f));
			table.addCell(getPdfCell("", 1,fontNormal,Color.cyan,15f));
			table.addCell(getPdfCell("Yellow", 1,fontNormal,Color.YELLOW,15f));
			table.addCell(getPdfCell(""+CommonUtil.round(yPre1, 2), 1,fontNormal,Color.cyan,15f));
			table.addCell(getPdfCell(""+CommonUtil.round(yPre2, 2), 1,fontNormal,Color.cyan,15f));
			table.addCell(getPdfCell(""+CommonUtil.round(yPre3, 2), 1,fontNormal,Color.cyan,15f));
			table.addCell(getPdfCell(""+CommonUtil.round(yPre4, 2), 1,fontNormal,Color.cyan,15f));
			table.addCell(getPdfCell(""+CommonUtil.round(yPre5, 2), 1,fontNormal,Color.cyan,15f));
			table.addCell(getPdfCell(""+CommonUtil.round(yPre6, 2), 1,fontNormal,Color.cyan,15f));
			table.addCell(getPdfCell(""+CommonUtil.round(yPre7, 2), 1,fontNormal,Color.cyan,15f));
			table.addCell(getPdfCell(""+CommonUtil.round(yPre8, 2), 1,fontNormal,Color.cyan,15f));
			table.addCell(getPdfCell(""+CommonUtil.round(yPre9, 2), 1,fontNormal,Color.cyan,15f));
			table.addCell(getPdfCell(""+CommonUtil.round(yPre10, 2), 1,fontNormal,Color.cyan,15f));
			table.addCell(getPdfCell("", 1,fontNormal,Color.cyan,15f));
			
			table.addCell(getPdfCell("", 1,fontNormal,Color.cyan,15f));
			table.addCell(getPdfCell("", 1,fontNormal,Color.cyan,15f));
			table.addCell(getPdfCell("", 1,fontNormal,Color.cyan,15f));
			
			
			table.addCell(getPdfCell(""+CommonUtil.round(yPre11, 2), 1,fontNormal,Color.cyan,15f));
			table.addCell(getPdfCell(""+CommonUtil.round(yPre13, 2), 1,fontNormal,Color.cyan,15f));
			table.addCell(getPdfCell(""+CommonUtil.round(yPre12, 2), 1,fontNormal,Color.cyan,15f));
			table.addCell(getPdfCell("", 1,fontNormal,Color.cyan,15f));
			table.addCell(getPdfCell("", 1,fontNormal,Color.cyan,15f));
			table.addCell(getPdfCell("", 1,fontNormal,Color.cyan,15f));
			table.addCell(getPdfCell("", 1,fontNormal,Color.cyan,15f));
			table.addCell(getPdfCell("", 1,fontNormal,Color.cyan,15f));
			table.addCell(getPdfCell("", 1,fontNormal,Color.cyan,15f));
			table.addCell(getPdfCell("", 1,fontNormal,Color.cyan,15f));
			table.addCell(getPdfCell("", 1,fontNormal,Color.cyan,15f));
			table.addCell(getPdfCell("", 1,fontNormal,Color.cyan,15f));
			table.addCell(getPdfCell("", 1,fontNormal,Color.cyan,15f));
			table.addCell(getPdfCell("", 1,fontNormal,Color.cyan,15f));
			table.addCell(getPdfCell("", 1,fontNormal,Color.cyan,15f));
			


			
			
			document.add(table);
			
			document.close();
			
		}
	}

	private PdfPCell getPdfCell(String text,int colspan,Font font,Color color,float cellHeight){
		
		PdfPCell cell=new PdfPCell(new Phrase(text,font));
		cell.setColspan(colspan);
		/*cell.setHorizontalAlignment(Element.ALIGN_CENTER);*/
		cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
		cell.setPaddingBottom(4.5f);
		cell.setPaddingLeft(5f);
		cell.setPaddingRight(5f);
		cell.setPaddingTop(3f);
		cell.setBorderColor(Color.BLACK);
		cell.setBorderWidth(0.2f);
		cell.setBackgroundColor(color);
		cell.setFixedHeight(cellHeight);
		return cell;
	}

	/**
	 * @param rewinds
	 * @param outputStream
	 * @throws DocumentException 
	 */
	public void createRewindReport(List<RewindPM5> rewinds, ServletOutputStream outputStream) throws DocumentException {
		
		int red1 = 0 ;
		int green1 = 0 ;
		int yellow1 = 0 ;
		
		int red2 = 0 ;
		int green2 = 0 ;
		int yellow2 = 0 ;
		
		
		
		int loopi = 0;
		
		
		if(rewinds!=null && rewinds.size()>0){
			Font fontHeader=FontFactory.getFont("Times-Roman", 6, Font.BOLD);
			Font fontTitle=FontFactory.getFont("Times-Roman", 8, Font.BOLD);
			Font fontNormal=FontFactory.getFont("Times-Roman", 6, Font.BOLD);
			Font fontNormalRed=FontFactory.getFont("Times-Roman", 6, Font.BOLD,Color.RED);
			Font fontNormalBlue=FontFactory.getFont("Times-Roman", 6, Font.BOLD,Color.BLUE);
			
			Rectangle rectangle=new Rectangle(3*355.6f, 4*215.9f);

			Document document=new Document(rectangle,-100f,-100f,30f,10f);
			
			PdfWriter.getInstance(document, outputStream);
			
			document.open();
			
			PdfPTable	table=new PdfPTable(22);
			
			table.setWidths(new int[]{2,1,2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,3,3});	
			
			
			table.addCell(getPdfCell("ST Tissue PM5 Tissue Machine Quality Report-REWINDTesting", 22,fontTitle,Color.PINK,18f));
			
			//Col header
			table.addCell(getPdfCell("Date", 1,fontHeader,Color.WHITE,30f));
			table.addCell(getPdfCell("Time", 1,fontHeader,Color.WHITE,30f));
			table.addCell(getPdfCell("Grade Code", 1,fontHeader,Color.WHITE,30f));
			table.addCell(getPdfCell("Reel #", 1,fontHeader,Color.WHITE,30f));
			table.addCell(getPdfCell("Set #", 1,fontHeader,Color.WHITE,30f));
			table.addCell(getPdfCell("Actual Basis wt lbs/3000ft", 1,fontHeader,Color.WHITE,30f));
			table.addCell(getPdfCell("Bulk mils/8 ply", 1,fontHeader,Color.WHITE,30f));
			table.addCell(getPdfCell("MD Tensile g/inch	", 1,fontHeader,Color.WHITE,30f));
			table.addCell(getPdfCell("CD Tensile g/inch", 1,fontHeader,Color.WHITE,30f));
			table.addCell(getPdfCell("MD % Stretch", 1,fontHeader,Color.WHITE,30f));
			table.addCell(getPdfCell("MD/CD Tensile Ratio", 1,fontHeader,Color.WHITE,30f));
			table.addCell(getPdfCell("MD Wet Tensile g/inch", 1,fontHeader,Color.WHITE,30f));
			table.addCell(getPdfCell("CD Wet Tensile g/inch", 1,fontHeader,Color.WHITE,30f));
			table.addCell(getPdfCell("CD Tensile Ratio Wet/Dry", 1,fontHeader,Color.WHITE,30f));
			table.addCell(getPdfCell("Bright ness %", 1,fontHeader,Color.WHITE,30f));
			table.addCell(getPdfCell("Dirt Count ppm", 1,fontHeader,Color.WHITE,30f));
			table.addCell(getPdfCell("Absorbency seconds", 1,fontHeader,Color.WHITE,30f));
			table.addCell(getPdfCell("L Value", 1,fontHeader,Color.WHITE,30f));
			table.addCell(getPdfCell("A Value", 1,fontHeader,Color.WHITE,30f));
			table.addCell(getPdfCell("B Value", 1,fontHeader,Color.WHITE,30f));
			table.addCell(getPdfCell("Customer", 1,fontHeader,Color.WHITE,30f));
			table.addCell(getPdfCell("Remarks", 1,fontHeader,Color.WHITE,30f));
			
			
			//data
			for (Map<String, Object> map : rewindServicePM5.getFormatedData(rewinds)) {
				if(map.get(ColumnsOfTable.COL_01).toString().equalsIgnoreCase("OBJECTIVES")){
					table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_01).toString(), 1,fontNormalBlue,Color.WHITE,15f));
					table.addCell(getPdfCell("N/A", 1,fontNormalBlue,Color.WHITE,15f));
					table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_02).toString(), 1,fontNormalRed,Color.WHITE,15f));
					table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_03).toString(), 1,fontNormalBlue,Color.WHITE,15f));
					table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_04).toString(), 1,fontNormalBlue,Color.WHITE,15f));
					table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_05).toString(), 1,fontNormalBlue,Color.WHITE,15f));
					table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_06).toString(), 1,fontNormalBlue,Color.WHITE,15f));
					table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_07).toString(), 1,fontNormalBlue,Color.WHITE,15f));
					table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_08).toString(), 1,fontNormalBlue,Color.WHITE,15f));
					table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_09).toString(), 1,fontNormalBlue,Color.WHITE,15f));
					table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_10).toString(), 1,fontNormalBlue,Color.WHITE,15f));
					table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_11).toString(), 1,fontNormalBlue,Color.WHITE,15f));
					table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_12).toString(), 1,fontNormalBlue,Color.WHITE,15f));
					table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_13).toString(), 1,fontNormalBlue,Color.WHITE,15f));
					table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_14).toString(), 1,fontNormalBlue,Color.WHITE,15f));
					table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_15).toString(), 1,fontNormalBlue,Color.WHITE,15f));
					table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_16).toString(), 1,fontNormalBlue,Color.WHITE,15f));
					table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_17).toString(), 1,fontNormalBlue,Color.WHITE,15f));
					table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_18).toString(), 1,fontNormalBlue,Color.WHITE,15f));
					table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_19).toString(), 1,fontNormalBlue,Color.WHITE,15f));
					table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_20).toString(), 1,fontNormalBlue,Color.WHITE,15f));
					table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_21).toString(), 1,fontNormalBlue,Color.WHITE,15f));

					
				}else{
					
					table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_01).toString(), 1,fontNormal,Color.WHITE,15f));
					table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_19).toString(), 1,fontNormal,Color.WHITE,15f));
					table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_02).toString(), 1,fontNormal,Color.WHITE,15f));
					table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_03).toString(), 1,fontNormal,Color.WHITE,15f));
					table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_04).toString(), 1,fontNormal,Color.WHITE,15f));
					
					
					if(map.get(ColumnsOfTable.COL_05_C).toString().equalsIgnoreCase("redcolor")){
						red1 = red1+1;
						table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_05).toString(), 1,fontNormal,Color.RED,15f));
					}else if(map.get(ColumnsOfTable.COL_05_C).toString().equalsIgnoreCase("greencolor")){
						green1 = green1+1;
						table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_05).toString(), 1,fontNormal,Color.GREEN,15f));
					}else if(map.get(ColumnsOfTable.COL_05_C).toString().equalsIgnoreCase("yellowcolor")){
						yellow1 = yellow1+1;
						table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_05).toString(), 1,fontNormal,Color.YELLOW,15f));
					}else{
						table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_05).toString(), 1,fontNormal,Color.WHITE,15f));
					}		
					
					
					
					
					if(map.get(ColumnsOfTable.COL_06_C).toString().equalsIgnoreCase("redcolor")){
						table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_06).toString(), 1,fontNormal,Color.RED,15f));
						red2 = red2+1;
					}else if(map.get(ColumnsOfTable.COL_06_C).toString().equalsIgnoreCase("greencolor")){
						table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_06).toString(), 1,fontNormal,Color.GREEN,15f));
						green2 = green2+1;
					}else if(map.get(ColumnsOfTable.COL_06_C).toString().equalsIgnoreCase("yellowcolor")){
						table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_06).toString(), 1,fontNormal,Color.YELLOW,15f));
						yellow2 = yellow2+1;
					}else{
						table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_06).toString(), 1,fontNormal,Color.WHITE,15f));
					}
					
					
					if(map.get(ColumnsOfTable.COL_07_C).toString().equalsIgnoreCase("redcolor")){
						table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_07).toString(), 1,fontNormal,Color.RED,15f));
					}else if(map.get(ColumnsOfTable.COL_07_C).toString().equalsIgnoreCase("greencolor")){
						table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_07).toString(), 1,fontNormal,Color.GREEN,15f));
					}else if(map.get(ColumnsOfTable.COL_07_C).toString().equalsIgnoreCase("yellowcolor")){
						table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_07).toString(), 1,fontNormal,Color.YELLOW,15f));
					}else{
						table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_07).toString(), 1,fontNormal,Color.WHITE,15f));
					}
					
					
					
					if(map.get(ColumnsOfTable.COL_08_C).toString().equalsIgnoreCase("redcolor")){
						table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_08).toString(), 1,fontNormal,Color.RED,15f));
					}else if(map.get(ColumnsOfTable.COL_08_C).toString().equalsIgnoreCase("greencolor")){
						table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_08).toString(), 1,fontNormal,Color.GREEN,15f));
					}else if(map.get(ColumnsOfTable.COL_08_C).toString().equalsIgnoreCase("yellowcolor")){
						table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_08).toString(), 1,fontNormal,Color.YELLOW,15f));
					}else{
						table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_08).toString(), 1,fontNormal,Color.WHITE,15f));
					}
					
					
					
					if(map.get(ColumnsOfTable.COL_09_C).toString().equalsIgnoreCase("redcolor")){
						table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_09).toString(), 1,fontNormal,Color.RED,15f));
					}else if(map.get(ColumnsOfTable.COL_09_C).toString().equalsIgnoreCase("greencolor")){
						table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_09).toString(), 1,fontNormal,Color.GREEN,15f));
					}else if(map.get(ColumnsOfTable.COL_09_C).toString().equalsIgnoreCase("yellowcolor")){
						table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_09).toString(), 1,fontNormal,Color.YELLOW,15f));
					}else{
						table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_09).toString(), 1,fontNormal,Color.WHITE,15f));
					}
					
					
					
					if(map.get(ColumnsOfTable.COL_10_C).toString().equalsIgnoreCase("redcolor")){
						table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_10).toString(), 1,fontNormal,Color.RED,15f));
					}else if(map.get(ColumnsOfTable.COL_10_C).toString().equalsIgnoreCase("greencolor")){
						table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_10).toString(), 1,fontNormal,Color.GREEN,15f));
					}else if(map.get(ColumnsOfTable.COL_10_C).toString().equalsIgnoreCase("yellowcolor")){
						table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_10).toString(), 1,fontNormal,Color.YELLOW,15f));
					}else{
						table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_10).toString(), 1,fontNormal,Color.WHITE,15f));
					}
				
					
					
					if(map.get(ColumnsOfTable.COL_11_C).toString().equalsIgnoreCase("redcolor")){
						table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_11).toString(), 1,fontNormal,Color.RED,15f));
					}else if(map.get(ColumnsOfTable.COL_11_C).toString().equalsIgnoreCase("greencolor")){
						table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_11).toString(), 1,fontNormal,Color.GREEN,15f));
					}else if(map.get(ColumnsOfTable.COL_11_C).toString().equalsIgnoreCase("yellowcolor")){
						table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_11).toString(), 1,fontNormal,Color.YELLOW,15f));
					}else{
						table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_11).toString(), 1,fontNormal,Color.WHITE,15f));
					}
					
					
					if(map.get(ColumnsOfTable.COL_12_C).toString().equalsIgnoreCase("redcolor")){
						table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_12).toString(), 1,fontNormal,Color.RED,15f));
					}else if(map.get(ColumnsOfTable.COL_12_C).toString().equalsIgnoreCase("greencolor")){
						table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_12).toString(), 1,fontNormal,Color.GREEN,15f));
					}else if(map.get(ColumnsOfTable.COL_12_C).toString().equalsIgnoreCase("yellowcolor")){
						table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_12).toString(), 1,fontNormal,Color.YELLOW,15f));
					}else{
						table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_12).toString(), 1,fontNormal,Color.WHITE,15f));
					}
					
					
					
					if(map.get(ColumnsOfTable.COL_13_C).toString().equalsIgnoreCase("redcolor")){
						table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_13).toString(), 1,fontNormal,Color.RED,15f));
					}else if(map.get(ColumnsOfTable.COL_13_C).toString().equalsIgnoreCase("greencolor")){
						table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_13).toString(), 1,fontNormal,Color.GREEN,15f));
					}else if(map.get(ColumnsOfTable.COL_13_C).toString().equalsIgnoreCase("yellowcolor")){
						table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_13).toString(), 1,fontNormal,Color.YELLOW,15f));
					}else{
						table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_13).toString(), 1,fontNormal,Color.WHITE,15f));
					}
					
					
					
					if(map.get(ColumnsOfTable.COL_14_C).toString().equalsIgnoreCase("redcolor")){
						table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_14).toString(), 1,fontNormal,Color.RED,15f));
					}else if(map.get(ColumnsOfTable.COL_14_C).toString().equalsIgnoreCase("greencolor")){
						table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_14).toString(), 1,fontNormal,Color.GREEN,15f));
					}else if(map.get(ColumnsOfTable.COL_14_C).toString().equalsIgnoreCase("yellowcolor")){
						table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_14).toString(), 1,fontNormal,Color.YELLOW,15f));
					}else{
						table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_14).toString(), 1,fontNormal,Color.WHITE,15f));
					}
					
					
					
					if(map.get(ColumnsOfTable.COL_15_C).toString().equalsIgnoreCase("redcolor")){
						table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_15).toString(), 1,fontNormal,Color.RED,15f));
					}else if(map.get(ColumnsOfTable.COL_15_C).toString().equalsIgnoreCase("greencolor")){
						table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_15).toString(), 1,fontNormal,Color.GREEN,15f));
					}else if(map.get(ColumnsOfTable.COL_15_C).toString().equalsIgnoreCase("yellowcolor")){
						table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_15).toString(), 1,fontNormal,Color.YELLOW,15f));
					}else{
						table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_15).toString(), 1,fontNormal,Color.WHITE,15f));
					}
					
					
					
					if(map.get(ColumnsOfTable.COL_16_C).toString().equalsIgnoreCase("redcolor")){
						table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_16).toString(), 1,fontNormal,Color.RED,15f));
					}else if(map.get(ColumnsOfTable.COL_16_C).toString().equalsIgnoreCase("greencolor")){
						table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_16).toString(), 1,fontNormal,Color.GREEN,15f));
					}else if(map.get(ColumnsOfTable.COL_16_C).toString().equalsIgnoreCase("yellowcolor")){
						table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_16).toString(), 1,fontNormal,Color.YELLOW,15f));
					}else{
						table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_16).toString(), 1,fontNormal,Color.WHITE,15f));
					}
					
					table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_23)!=null?map.get(ColumnsOfTable.COL_23).toString():"", 1,fontNormal,Color.WHITE,15f));
					table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_24)!=null?map.get(ColumnsOfTable.COL_24).toString():"", 1,fontNormal,Color.WHITE,15f));
					table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_25)!=null?map.get(ColumnsOfTable.COL_25).toString():"", 1,fontNormal,Color.WHITE,15f));
					table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_26)!=null?map.get(ColumnsOfTable.COL_26).toString():"", 1,fontNormal,Color.WHITE,15f));
					table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_27)!=null?map.get(ColumnsOfTable.COL_27).toString():"", 1,fontNormal,Color.WHITE,15f));
					
					 
					loopi = loopi+1;
				}
				
			}
			document.add(table);
			document.close();
			
		}

		
	}
}

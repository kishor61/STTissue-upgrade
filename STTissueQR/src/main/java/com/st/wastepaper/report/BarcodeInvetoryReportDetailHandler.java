/**
 *Jul 31, 2015
 *BarcodeInvetoryReportDetailHandler.java
 * TODO
 *com.st.wastepaperunloadbale.report
 *BarcodeInvetoryReportDetailHandler.java
 *Sunil Singh Bora
 */
package com.st.wastepaper.report;

import java.io.File;
import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletOutputStream;

import org.springframework.stereotype.Component;

import com.st.common.CommonUtil;
import com.st.common.Workbook2007Util;
import com.st.wastepaper.model.BarcodeComman;
import com.st.wastepaper.model.WastePaperBaleInventory;

/**
 * @author roshan
 *
 */
@Component
public class BarcodeInvetoryReportDetailHandler {

	/**
	 * @param unloadbalesdata
	 * @param consumedBalesData
	 * @param openingMonth
	 * @param file
	 * @param outputStream
	 * @throws IOException 
	 */
	public void getBarcodeInventoryReportDetail(
			List<WastePaperBaleInventory> unloadbalesdata,
			List<WastePaperBaleInventory> consumedBalesData,
			List<BarcodeComman> openingMonth, File file,
			ServletOutputStream outputStream) throws IOException {
		// TODO Auto-generated method stub
		Workbook2007Util util = new Workbook2007Util(file,0);
		util.setSheetName("Bale Inventory Detail Report", 0);
		short rowHeight = 280;
		int row=3;
		int col=0;
		int _total_om=0;
		int _totalUnloadBales=0; 
		int _totalConsumedBales=0;
		int op1=0;
		int op2=0;
		int op3=0;
		int op4=0;
		int op5=0;
		int op6=0;
		int op7=0;
		int op8=0;
		int op9=0;
		int op10=0;
		int op11=0;
		int op12=0;
		int op13=0;
		int op14=0;
		int op15=0;
		int op16=0;
		int op17=0;
		int op18=0;
		int op19=0;
		int op20=0;
		int op21=0;
		int op22=0;
		int op23=0;
		int op24=0;
		int op25=0;
		int op26=0;
		int op27=0;
		int op28=0;
		int op29=0;
		int op30=0;
		int op31=0;
		int op32=0;
		int op33=0;
		int op34=0;
		int op35=0;
		
		int ul1=0;
		int ul2=0;
		int ul3=0;
		int ul4=0;
		int ul5=0;
		int ul6=0;
		int ul7=0;
		int ul8=0;
		int ul9=0;
		int ul10=0;
		int ul11=0;
		int ul12=0;
		int ul13=0;
		int ul14=0;
		int ul15=0;
		int ul16=0;
		int ul17=0;
		int ul18=0;
		int ul19=0;
		int ul20=0;
		int ul21=0;
		int ul22=0;
		int ul23=0;
		int ul24=0;
		int ul25=0;
		int ul26=0;
		int ul27=0;
		int ul28=0;
		int ul29=0;
		int ul30=0;
		int ul31=0;
		int ul32=0;
		int ul33=0;
		int ul34=0;
		int ul35=0;
		
		int con1=0;
		int con2=0;
		int con3=0;
		int con4=0;
		int con5=0;
		int con6=0;
		int con7=0;
		int con8=0;
		int con9=0;
		int con10=0;
		int con11=0;
		int con12=0;
		int con13=0;
		int con14=0;
		int con15=0;
		int con16=0;
		int con17=0;
		int con18=0;
		int con19=0;
		int con20=0;
		int con21=0;
		int con22=0;
		int con23=0;
		int con24=0;
		int con25=0;
		int con26=0;
		int con27=0;
		int con28=0;
		int con29=0;
		int con30=0;
		int con31=0;
		int con32=0;
		int con33=0;	
		int con34=0;	
		int con35=0;	

		
		 for(BarcodeComman barcode:openingMonth){
				
			 col=1;	
			 
			 op1=barcode.getMwl();					
			 op2=barcode.getPrtmix();
			 op3=barcode.getMcl();
			 op4=barcode.getMwlwigs();
			 op5=barcode.getCbs();
			 op6=barcode.getCtdGdwd();
			 op7=barcode.getSwlsortedwhite();
			 op8=barcode.getOnpolnNewsprint();
			 op9=barcode.getOinews();
			 op10=barcode.getLightprtsbs();
			 op11=barcode.getHw();
			 op12=barcode.getHeavyprtsbs();
			 op13=barcode.getSow();
			 op14=barcode.getUnprtsbs();
			 op15=barcode.getNewsblank();
			 op16=barcode.getWhitegdwdblend();
			 op17=barcode.getMailundeliverable();
			 op18=barcode.getHoggedbooks();
			 op19=barcode.getOcc();
			 op20=barcode.getDlk();
			 op21=barcode.getMixedpaper();
			 op22=barcode.getSoftwoodchips();
			 op23=barcode.getHardwoodchips() ;
			 op24=barcode.getWhitebroke();
			 op25=barcode.getPwe();
			 op26=barcode.getBrownnapkinbroke();
			 op27=barcode.getPulpwetlap();
			 op28=barcode.getVirginpulp();
			 op29=barcode.getBrownwetLap();
			 op30=barcode.getPulpdryLap();
			 op31=barcode.getOtherrolls();
			 op32=barcode.getStbaleswetlap();
			 op33=barcode.getSttbaledbrokebutl();
			 
			 op34=barcode.getVirginhardwood();
			 op35=barcode.getVirginsoftwood();
			 
			   util.addValue(row, col++,CommonUtil.round(barcode.getMwl(), 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			   util.addValue(row, col++,CommonUtil.round(barcode.getPrtmix(), 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			   util.addValue(row, col++,CommonUtil.round(barcode.getMcl(), 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			   util.addValue(row, col++,CommonUtil.round(barcode.getMwlwigs(), 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			   util.addValue(row, col++,CommonUtil.round(barcode.getCbs(), 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			   util.addValue(row, col++,CommonUtil.round(barcode.getCtdGdwd(), 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			   util.addValue(row, col++,CommonUtil.round(barcode.getSwlsortedwhite(), 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			   util.addValue(row, col++,CommonUtil.round(barcode.getOnpolnNewsprint(), 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			   util.addValue(row, col++,CommonUtil.round(barcode.getOinews(), 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			   util.addValue(row, col++,CommonUtil.round(barcode.getLightprtsbs(), 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			   util.addValue(row, col++,CommonUtil.round(barcode.getHw(), 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			   util.addValue(row, col++,CommonUtil.round(barcode.getHeavyprtsbs(), 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			   util.addValue(row, col++,CommonUtil.round(barcode.getSow(), 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			   util.addValue(row, col++,CommonUtil.round(barcode.getUnprtsbs(), 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			   util.addValue(row, col++,CommonUtil.round(barcode.getNewsblank(), 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			   util.addValue(row, col++,CommonUtil.round(barcode.getWhitegdwdblend(), 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			   util.addValue(row, col++,CommonUtil.round(barcode.getMailundeliverable(), 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			   util.addValue(row, col++,CommonUtil.round(barcode.getHoggedbooks(), 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			   util.addValue(row, col++,CommonUtil.round(barcode.getOcc(), 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			   util.addValue(row, col++,CommonUtil.round(barcode.getDlk(), 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			   util.addValue(row, col++,CommonUtil.round(barcode.getMixedpaper(), 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			   util.addValue(row, col++,CommonUtil.round(barcode.getSoftwoodchips(), 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			   util.addValue(row, col++,CommonUtil.round(barcode.getHardwoodchips(), 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight); 
			   util.addValue(row, col++,CommonUtil.round(barcode.getPwe(), 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			   util.addValue(row, col++,CommonUtil.round(barcode.getWhitebroke(), 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			   util.addValue(row, col++,CommonUtil.round(barcode.getBrownnapkinbroke(), 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			   util.addValue(row, col++,CommonUtil.round(barcode.getPulpwetlap(), 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			   util.addValue(row, col++,CommonUtil.round(barcode.getVirginpulp(), 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			   util.addValue(row, col++,CommonUtil.round(barcode.getBrownwetLap(), 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			   util.addValue(row, col++,CommonUtil.round(barcode.getPulpdryLap(), 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			   util.addValue(row, col++,CommonUtil.round(barcode.getOtherrolls(), 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			   util.addValue(row, col++,CommonUtil.round(barcode.getStbaleswetlap(), 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			   util.addValue(row, col++,CommonUtil.round(barcode.getSttbaledbrokebutl(), 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			   
			   util.addValue(row, col++,CommonUtil.round(barcode.getVirginhardwood(), 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			   util.addValue(row, col++,CommonUtil.round(barcode.getVirginsoftwood(), 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			   
			   
			 
			_total_om=barcode.getMwl()+barcode.getPrtmix()+barcode.getMcl()+
						barcode.getMwlwigs()+barcode.getCbs()+barcode.getCtdGdwd()+barcode.getSwlsortedwhite()+barcode.getOnpolnNewsprint()+barcode.getOinews()+
						barcode.getLightprtsbs()+barcode.getHw()+barcode.getHeavyprtsbs()+barcode.getSow()+barcode.getUnprtsbs()+barcode.getNewsblank()+
						barcode.getWhitegdwdblend()+barcode.getMailundeliverable()+barcode.getHoggedbooks()+barcode.getOcc()+
						barcode.getDlk()+barcode.getMixedpaper()+barcode.getSoftwoodchips()+barcode.getHardwoodchips()+
						barcode.getWhitebroke()+barcode.getPwe()+barcode.getBrownnapkinbroke()+barcode.getPulpwetlap()+barcode.getVirginpulp()+
						barcode.getBrownwetLap()+barcode.getPulpdryLap()+barcode.getOtherrolls()+barcode.getStbaleswetlap()+barcode.getSttbaledbrokebutl()+barcode.getVirginhardwood()+barcode.getVirginsoftwood(); 
			
				util.addValue(row, col++, CommonUtil.round(_total_om, 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			 
		}
		 row++;
		 for(final WastePaperBaleInventory unload:unloadbalesdata){
			 col=1;	
			 ul1=unload.getTotalbalesOfMWL()+ul1;
			 
			 ul2=unload.getTotalbalesOfPrtmix()+ul2;
			 ul3=unload.getTotalbalesOfMCL()+ul3;
			 ul4=unload.getTotalbalesOfMWLWorIGS()+ul4;
			 ul5=unload.getTotalbalesOfCBS()+ul5;
			 ul6=unload.getTotalbalesOfCtdGdwd()+ul6;
			 ul7=unload.getTotalbalesOfSWL()+ul7;
			 ul8=unload.getTotalbalesOfONPOldNewsPrint()+ul8;
			 ul9=unload.getTotalbalesOfOINews()+ul9;
			 ul10=unload.getTotalbalesOfLightPrtSBS()+ul10;
			 ul11=unload.getTotalbalesOfHW()+ul11;
			 ul12=unload.getTotalbalesOfHeavyPrtSBS()+ul12;		
			 ul13=unload.getTotalbalesOfSOW()+ul13;
			 ul14=unload.getTotalbalesOfUnprtSBS()+ul14;
			 ul15=unload.getTotalbalesOfNewsblank()+ul15;
			 ul16=unload.getTotalbalesOfWhiteGdwdBlend()+ul16;
			 ul17=unload.getTotalbalesOfMailUndeliverable()+ul17;
			 ul18=unload.getTotalbalesOfHoggedBooks()+ul18;
			 System.out.println("ul18:::"+ul18);
			 ul19=unload.getTotalbalesOfOCC()+ul19;
			 ul20=unload.getTotalbalesOfDLK()+ul20;
			 ul21=unload.getTotalbalesOfMixedPaper()+ul21;
			 ul22=unload.getTotalbalesOfSoftWoodChips()+ul22;
			 ul23=unload.getTotalbalesOfHardWoodChips()+ul23;
			 ul24=unload.getTotalbalesOfPWE()+ul24;
			 ul25=unload.getTotalbalesOfWhiteBroke()+ul25;
			 ul26=unload.getTotalbalesOfBrownNapkinBroke()+ul26;
			 ul27=unload.getTotalbalesOfPULPWetLap()+ul27;
			 ul28=unload.getTotalbalesOfVirginPulp()+ul28;
			 ul29=unload.getTotalbalesOfBrownWetLap()+ul29;
			 ul30=unload.getTotalbalesOfPulpDryLap()+ul30;
			 ul31=unload.getTotalbalesOfOtherRolls()+ul31;
			 ul32=unload.getTotalbalesOfSTBaleswetlap()+ul32;
			 ul33=unload.getTotalbalesOfSTTBaledBroke()+ul33;
			 
			 ul34=unload.getTotalbalesOfVirginHardWood()+ul34;
			 ul35=unload.getTotalbalesOfVirginSoftWood()+ul35;
			 

		    	util.addValue(row, col++,CommonUtil.round(ul1, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			    util.addValue(row, col++,CommonUtil.round(ul2, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
				util.addValue(row, col++,CommonUtil.round(ul3, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
				util.addValue(row, col++,CommonUtil.round(ul4, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
				util.addValue(row, col++,CommonUtil.round(ul5, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
				util.addValue(row, col++,CommonUtil.round(ul6, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
				util.addValue(row, col++,CommonUtil.round(ul7, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
				util.addValue(row, col++,CommonUtil.round(ul8, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
				util.addValue(row, col++,CommonUtil.round(ul9, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
				util.addValue(row, col++,CommonUtil.round(ul10, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
				util.addValue(row, col++,CommonUtil.round(ul11, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
				util.addValue(row, col++,CommonUtil.round(ul12, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);		
				util.addValue(row, col++,CommonUtil.round(ul13, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
				util.addValue(row, col++,CommonUtil.round(ul14, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
				util.addValue(row, col++,CommonUtil.round(ul15, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
				util.addValue(row, col++,CommonUtil.round(ul16, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
				util.addValue(row, col++,CommonUtil.round(ul17, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
				util.addValue(row, col++,CommonUtil.round(ul18, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
				//System.out.println("OCC::::::"+unload.getTotalbalesOfOCC());
				util.addValue(row, col++,CommonUtil.round(ul19, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
				util.addValue(row, col++,CommonUtil.round(ul20, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
				util.addValue(row, col++,CommonUtil.round(ul21, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
				util.addValue(row, col++,CommonUtil.round(ul22, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
				util.addValue(row, col++,CommonUtil.round(ul23, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
				util.addValue(row, col++,CommonUtil.round(ul25, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
				util.addValue(row, col++,CommonUtil.round(ul24, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
				util.addValue(row, col++,CommonUtil.round(ul26, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
				util.addValue(row, col++,CommonUtil.round(ul27, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
				util.addValue(row, col++,CommonUtil.round(ul28, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
				util.addValue(row, col++,CommonUtil.round(ul29, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
				util.addValue(row, col++,CommonUtil.round(ul30, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
				util.addValue(row, col++,CommonUtil.round(ul31, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
				util.addValue(row, col++,CommonUtil.round(ul32, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
				util.addValue(row, col++,CommonUtil.round(ul33, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
				
				util.addValue(row, col++,CommonUtil.round(ul34, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
				util.addValue(row, col++,CommonUtil.round(ul35, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			
				_totalUnloadBales=			 
						 ul1+ul2+ul3+ul4+ul5+ul6+ul7+ul8+ul9+ul10+ul11+ul12+ul13+ul14+
						 ul15+ul16+ul17+ul18+ul19+ul20+ul21+ul22+ul23+ul24+ul25+ul26+ul27+
						 ul28+ul29+ul30+ul31+ul32+ul33+ul34+ul35;
				util.addValue(row, col++,CommonUtil.round(_totalUnloadBales, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);		
			}
		 row++;
		 for(final WastePaperBaleInventory consume: consumedBalesData){
			 col=1;
				
			 con1=consume.getTotalbalesOfMWL()+con1;
			 con2=consume.getTotalbalesOfPrtmix()+con2;
			 con3=consume.getTotalbalesOfMCL()+con3;
			 con4=consume.getTotalbalesOfMWLWorIGS()+con4;
			 con5=consume.getTotalbalesOfCBS()+con5;
			 con6=consume.getTotalbalesOfCtdGdwd()+con6;
			 con7=consume.getTotalbalesOfSWL()+con7;
			 con8=consume.getTotalbalesOfONPOldNewsPrint()+con8;
			 con9=consume.getTotalbalesOfOINews()+con9;
			 con10=consume.getTotalbalesOfLightPrtSBS()+con10;
			 con11=consume.getTotalbalesOfHW()+con11;
			 con12=consume.getTotalbalesOfHeavyPrtSBS()+con12;		
			 con13=consume.getTotalbalesOfSOW()+con13;
			 con14=consume.getTotalbalesOfUnprtSBS()+con14;
			 con15=consume.getTotalbalesOfNewsblank()+con15;
			 con16=consume.getTotalbalesOfWhiteGdwdBlend()+con16;
			 con17=consume.getTotalbalesOfMailUndeliverable()+con17;
			 con18=consume.getTotalbalesOfHoggedBooks()+con18;
			 con19=consume.getTotalbalesOfOCC()+con19;
			 con20=consume.getTotalbalesOfDLK()+con20;
			 con21=consume.getTotalbalesOfMixedPaper()+con21;
			 con22=consume.getTotalbalesOfSoftWoodChips()+con22;
			 con23=consume.getTotalbalesOfHardWoodChips()+con23;
			 /*con24=consume.getTotalbalesOfPWE()+con24;
			 con25=consume.getTotalbalesOfWhiteBroke()+con25;*/
			 con24=consume.getTotalbalesOfWhiteBroke()+con24;
			 con25=consume.getTotalbalesOfPWE()+con25;
			 
			 con26=consume.getTotalbalesOfBrownNapkinBroke()+con26;
			 con27=consume.getTotalbalesOfPULPWetLap()+con27;
			 con28=consume.getTotalbalesOfVirginPulp()+con28;
			 con29=consume.getTotalbalesOfBrownWetLap()+con29;
			 con30=consume.getTotalbalesOfPulpDryLap()+con30;
			 con31=consume.getTotalbalesOfOtherRolls()+con31;
			 con32=consume.getTotalbalesOfSTBaleswetlap()+con32;
			 con33=consume.getTotalbalesOfSTTBaledBroke()+con33;
			 
			 con34=consume.getTotalbalesOfVirginHardWood()+con34;
			 con35=consume.getTotalbalesOfVirginSoftWood()+con35;
			 
			 	util.addValue(row, col++,CommonUtil.round(con1, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
				util.addValue(row, col++,CommonUtil.round(con2, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
				util.addValue(row, col++,CommonUtil.round(con3, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
				util.addValue(row, col++,CommonUtil.round(con4, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
				util.addValue(row, col++,CommonUtil.round(con5, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
				util.addValue(row, col++,CommonUtil.round(con6, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
				util.addValue(row, col++,CommonUtil.round(con7, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
				util.addValue(row, col++,CommonUtil.round(con8, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
				util.addValue(row, col++,CommonUtil.round(con9, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
				util.addValue(row, col++,CommonUtil.round(con10, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
				util.addValue(row, col++,CommonUtil.round(con11, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
				util.addValue(row, col++,CommonUtil.round(con12, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
				util.addValue(row, col++,CommonUtil.round(con13, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
				util.addValue(row, col++,CommonUtil.round(con14, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
				util.addValue(row, col++,CommonUtil.round(con15, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
				util.addValue(row, col++,CommonUtil.round(con16, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
				util.addValue(row, col++,CommonUtil.round(con17, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
				util.addValue(row, col++,CommonUtil.round(con18, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
				util.addValue(row, col++,CommonUtil.round(con19, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
				util.addValue(row, col++,CommonUtil.round(con20, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
				util.addValue(row, col++,CommonUtil.round(con21, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
				util.addValue(row, col++,CommonUtil.round(con22, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
				util.addValue(row, col++,CommonUtil.round(con23, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
				util.addValue(row, col++,CommonUtil.round(con25, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
				util.addValue(row, col++,CommonUtil.round(con24, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
				util.addValue(row, col++,CommonUtil.round(con26, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
				util.addValue(row, col++,CommonUtil.round(con27, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
				util.addValue(row, col++,CommonUtil.round(con28, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
				util.addValue(row, col++,CommonUtil.round(con29, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
				util.addValue(row, col++,CommonUtil.round(con30, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
				util.addValue(row, col++,CommonUtil.round(con31, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
				util.addValue(row, col++,CommonUtil.round(con32, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
				util.addValue(row, col++,CommonUtil.round(con33, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
				
				util.addValue(row, col++,CommonUtil.round(con34, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
				util.addValue(row, col++,CommonUtil.round(con35, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
				
				
				_totalConsumedBales=con1+con2+con3+con4+con5+con6+con7+con8+con9+con10+
						 con11+con12+con13+con14+con15+con16+con17+con18+con19+con20+
						 con21+con22+con23+con24+con25+con26+con27+con28+con29+con30+
						 con31+con32+con33+con34+con35;
				
				util.addValue(row, col++,CommonUtil.round(_totalConsumedBales, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
				
				
				
			}
		 row++;
		 col=1;
		 
		 	util.addValue(row, col++,CommonUtil.round((op1+ul1)-con1, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++,CommonUtil.round((op2+ul2)-con2, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++,CommonUtil.round((op3+ul3)-con3, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++,CommonUtil.round((op4+ul4)-con4, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++,CommonUtil.round((op5+ul5)-con5, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++,CommonUtil.round((op6+ul6)-con6, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++,CommonUtil.round((op7+ul7)-con7, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++,CommonUtil.round((op8+ul8)-con8, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++,CommonUtil.round((op9+ul9)-con9, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++,CommonUtil.round((op10+ul10)-con10, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++,CommonUtil.round((op11+ul11)-con11, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++,CommonUtil.round((op12+ul12)-con12, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++,CommonUtil.round((op13+ul13)-con13, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++,CommonUtil.round((op14+ul14)-con14, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++,CommonUtil.round((op15+ul15)-con15, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++,CommonUtil.round((op16+ul16)-con16, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++,CommonUtil.round((op17+ul17)-con17, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++,CommonUtil.round((op18+ul18)-con18, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++,CommonUtil.round((op19+ul19)-con19, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++,CommonUtil.round((op20+ul20)-con20, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++,CommonUtil.round((op21+ul21)-con21, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++,CommonUtil.round((op22+ul22)-con22, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++,CommonUtil.round((op23+ul23)-con23, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++,CommonUtil.round((op25+ul25)-con25, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++,CommonUtil.round((op24+ul24)-con24, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++,CommonUtil.round((op26+ul26)-con26, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++,CommonUtil.round((op27+ul27)-con27, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++,CommonUtil.round((op28+ul28)-con28, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++,CommonUtil.round((op29+ul29)-con29, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++,CommonUtil.round((op30+ul30)-con30, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++,CommonUtil.round((op31+ul31)-con31, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++,CommonUtil.round((op32+ul32)-con32, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++,CommonUtil.round((op33+ul33)-con33, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			
			util.addValue(row, col++,CommonUtil.round((op34+ul34)-con34, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++,CommonUtil.round((op35+ul35)-con35, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			
			//For Final Invetory
			util.addValue(row, col++,CommonUtil.round((_total_om+_totalUnloadBales)-_totalConsumedBales, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		 util.write(outputStream);
	}

}

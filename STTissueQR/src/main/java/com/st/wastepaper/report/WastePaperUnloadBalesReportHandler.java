/**
 *Jul 17, 2015
 *WastePaperUnloadBalesReportHandler.java
 * TODO
 *com.st.wastepaperunloadbale.report
 *WastePaperUnloadBalesReportHandler.java
 *Sunil Singh Bora
 */
package com.st.wastepaper.report;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import jakarta.servlet.ServletOutputStream;

import org.springframework.stereotype.Component;

import com.st.common.CommonUtil;
import com.st.common.Workbook2007Util;
import com.st.wastepaper.model.WastePaperBaleInventory;

/**
 * @author roshan
 *
 */
@Component
public class WastePaperUnloadBalesReportHandler {

	/**
	 * @param unloadbalesdata
	 * @param file
	 * @param outputStream
	 * @throws IOException 
	 */
	private SimpleDateFormat dateFormat=new SimpleDateFormat("MM-dd-yyyy");
	public void getWPUnloadBalesReport(List<WastePaperBaleInventory> unloadbalesdata, String flag, File file,
			ServletOutputStream outputStream) throws Exception {
		
		// TODO Auto-generated method stub
		Workbook2007Util util = new Workbook2007Util(file,0);
		if(flag.equalsIgnoreCase("Unload")){
			util.setSheetName("Unload Bales", 0);
		}if(flag.equalsIgnoreCase("Consume")){
			util.setSheetName("Consumed Bales", 0);
		}
		
		short rowHeight = 280;
		int row=2;
		int col=0;
		int lastcol=0;
		//1
		double _otalbalesweightForMWL=0.0;
		int _otalbalesbalesOfMWL=0;
		//2
		double getTotalbalesweightForPrtmix=0.0;
		int getTotalbalesOfPrtmix=0;
		//2
		double getTotalbalesweightForMCL=0.0;
		int getTotalbalesOfMCL=0;
		//2
		double getTotalbalesweightForMWLWorIGS=0.0;
		int getTotalbalesOfMWLWorIGS=0;
		//2
		double getTotalbalesweightForCBS=0.0;
		int getTotalbalesOfCBS=0;
		//2
		double getTotalbalesweightForCtdGdwd=0.0;
		int getTotalbalesOfCtdGdwd=0;
		//2
		double getTotalbalesweightForSWL=0.0;
		int getTotalbalesOfSWL=0;
		//2
		double getTotalbalesweightForONPOldNewsPrint=0.0;
		int getTotalbalesOfONPOldNewsPrint=0;
		//2
		double getTotalbalesweightForOINews=0.0;
		int getTotalbalesOfOINews=0;
		//2
		double getTotalbalesweightForLightPrtSBS=0.0;
		int getTotalbalesOfLightPrtSBS=0;
		//2
		double getTotalbalesweightForHW=0.0;
		int getTotalbalesOfHW=0;
		//2
		double getTotalbalesweightForHeavyPrtSBS=0.0;
		int getTotalbalesOfHeavyPrtSBS=0;
		//2
		double getTotalbalesweightForSOW=0.0;
		int getTotalbalesOfSOW=0;
		//2
		double getTotalbalesweightForUnprtSBS=0.0;
		int getTotalbalesOfUnprtSBS=0;
		//2
		double getTotalbalesweightForNewsblank=0.0;
		int getTotalbalesOfNewsblank=0;
		//2
		double getTotalbalesweightForWhiteGdwdBlend=0.0;
		int getTotalbalesOfWhiteGdwdBlend=0;
		//2
		double getTotalbalesweightForMailUndeliverable=0.0;
		int getTotalbalesOfMailUndeliverable=0;
		//2
		double getTotalbalesweightForHoggedBooks=0.0;
		int getTotalbalesOfHoggedBooks=0;
		//2
		double getTotalbalesweightForOCC=0.0;
		int getTotalbalesOfOCC=0;
		//2
		double getTotalbalesweightForDLK=0.0;
		int getTotalbalesOfDLK=0;
		//2
		double getTotalbalesweightForMixedPaper=0.0;
		int getTotalbalesOfMixedPaper=0;
		//2
		double getTotalbalesweightForSoftWoodChips=0.0;
		int getTotalbalesOfSoftWoodChips=0;
		//2
		double getTotalbalesweightForHardWoodChips=0.0;
		int getTotalbalesOfHardWoodChips=0;
		//2
		double getTotalbalesweightForPWE=0.0;
		int getTotalbalesOfPWE=0;
		//2
		double getTotalbalesweightForWhiteBroke=0.0;
		int getTotalbalesOfWhiteBroke=0;
		//2
		double getTotalbalesweightForBrownNapkinBroke=0.0;
		int getTotalbalesOfBrownNapkinBroke=0;
		//2
		double getTotalbalesweightForPULPWetLap=0.0;
		int getTotalbalesOfPULPWetLap=0;
		//2
		double getTotalbalesweightForVirginPulp=0.0;
		int getTotalbalesOfVirginPulp=0;
		//2
		double getTotalbalesweightForBrownWetLap=0.0;
		int getTotalbalesOfBrownWetLap=0;
		//2
		double getTotalbalesweightForPulpDryLap=0.0;
		int getTotalbalesOfPulpDryLap=0;
		//2
		double getTotalbalesweightForOtherRolls=0.0;
		int getTotalbalesOfOtherRolls=0;
		//2
		double getTotalbalesweightForSTBaleswetlap=0.0;
		int getTotalbalesOfSTBaleswetlap=0;
		//2
		double getTotalbalesweightForSTTBaledBroke=0.0;
		int getTotalbalesOfSTTBaledBroke=0;
		
		
		/*New Grade Code Added From Here 14-11-2017*/
		
		double getTotalbalesweightForVirginHardWood=0.0;
		int getTotalbalesOfVirginHardWood=0;
		
		double getTotalbalesweightForVirginSoftWood=0.0;
		int getTotalbalesOfVirginSoftWood=0;
		
		//get final/grand total here
		int finaltotalbales=0;
		double finaltotalbalesweight=0.0;
		
		for(WastePaperBaleInventory baleInventory:unloadbalesdata){
			col=0;
			lastcol=1;
			
			util.addValue(row, col++, dateFormat.format(baleInventory.getDate()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			//1
			util.addValue(row, col++, baleInventory.getTotalbalesOfMWL(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, CommonUtil.round(baleInventory.getTotalbalesweightForMWL(), 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			//2
			util.addValue(row, col++, baleInventory.getTotalbalesOfPrtmix(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, CommonUtil.round(baleInventory.getTotalbalesweightForPrtmix(), 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			//3
			util.addValue(row, col++, baleInventory.getTotalbalesOfMCL(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, CommonUtil.round(baleInventory.getTotalbalesweightForMCL(), 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			//4
			util.addValue(row, col++, baleInventory.getTotalbalesOfMWLWorIGS(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, CommonUtil.round(baleInventory.getTotalbalesweightForMWLWorIGS(), 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			//5
			util.addValue(row, col++, baleInventory.getTotalbalesOfCBS(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, CommonUtil.round(baleInventory.getTotalbalesweightForCBS(), 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			//6
			util.addValue(row, col++, baleInventory.getTotalbalesOfCtdGdwd(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, CommonUtil.round(baleInventory.getTotalbalesweightForCtdGdwd(), 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			//7
			util.addValue(row, col++, baleInventory.getTotalbalesOfSWL(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, CommonUtil.round(baleInventory.getTotalbalesweightForSWL(), 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			//8
			util.addValue(row, col++, baleInventory.getTotalbalesOfONPOldNewsPrint(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, CommonUtil.round(baleInventory.getTotalbalesweightForONPOldNewsPrint(), 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			//9
			util.addValue(row, col++, baleInventory.getTotalbalesOfOINews(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, CommonUtil.round(baleInventory.getTotalbalesweightForOINews(), 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			//10
			util.addValue(row, col++, baleInventory.getTotalbalesOfLightPrtSBS(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, CommonUtil.round(baleInventory.getTotalbalesweightForLightPrtSBS(), 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			//11
			util.addValue(row, col++, baleInventory.getTotalbalesOfHW(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, CommonUtil.round(baleInventory.getTotalbalesweightForHW(), 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			//12
			util.addValue(row, col++, baleInventory.getTotalbalesOfHeavyPrtSBS(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, CommonUtil.round(baleInventory.getTotalbalesweightForHeavyPrtSBS(), 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			//13
			util.addValue(row, col++, baleInventory.getTotalbalesOfSOW(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, CommonUtil.round(baleInventory.getTotalbalesweightForSOW(), 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			//14
			util.addValue(row, col++, baleInventory.getTotalbalesOfUnprtSBS(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, CommonUtil.round(baleInventory.getTotalbalesweightForUnprtSBS(), 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			//15
			util.addValue(row, col++, baleInventory.getTotalbalesOfNewsblank(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, CommonUtil.round(baleInventory.getTotalbalesweightForNewsblank(), 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			//16
			util.addValue(row, col++, baleInventory.getTotalbalesOfWhiteGdwdBlend(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, CommonUtil.round(baleInventory.getTotalbalesweightForWhiteGdwdBlend(), 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			//17
			util.addValue(row, col++, baleInventory.getTotalbalesOfMailUndeliverable(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, CommonUtil.round(baleInventory.getTotalbalesweightForMailUndeliverable(), 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			//18
			util.addValue(row, col++, baleInventory.getTotalbalesOfHoggedBooks(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, CommonUtil.round(baleInventory.getTotalbalesweightForHoggedBooks(), 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			//19
			util.addValue(row, col++, baleInventory.getTotalbalesOfOCC(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, CommonUtil.round(baleInventory.getTotalbalesweightForOCC(), 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			//20
			util.addValue(row, col++, baleInventory.getTotalbalesOfDLK(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, CommonUtil.round(baleInventory.getTotalbalesweightForDLK(), 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			//21
			util.addValue(row, col++, baleInventory.getTotalbalesOfMixedPaper(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, CommonUtil.round(baleInventory.getTotalbalesweightForMixedPaper(), 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			//22
			util.addValue(row, col++, baleInventory.getTotalbalesOfSoftWoodChips(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, CommonUtil.round(baleInventory.getTotalbalesweightForSoftWoodChips(), 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			//23
			util.addValue(row, col++, baleInventory.getTotalbalesOfHardWoodChips(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, CommonUtil.round(baleInventory.getTotalbalesweightForHardWoodChips(), 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			//24
			util.addValue(row, col++, baleInventory.getTotalbalesOfPWE(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, CommonUtil.round(baleInventory.getTotalbalesweightForPWE(), 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			//25
			util.addValue(row, col++, baleInventory.getTotalbalesOfWhiteBroke(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, CommonUtil.round(baleInventory.getTotalbalesweightForWhiteBroke(), 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			//26
			util.addValue(row, col++, baleInventory.getTotalbalesOfBrownNapkinBroke(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, CommonUtil.round(baleInventory.getTotalbalesweightForBrownNapkinBroke(), 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			//27
			util.addValue(row, col++, baleInventory.getTotalbalesOfPULPWetLap(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, CommonUtil.round(baleInventory.getTotalbalesweightForPULPWetLap(), 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			//28
			util.addValue(row, col++, baleInventory.getTotalbalesOfVirginPulp(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, CommonUtil.round(baleInventory.getTotalbalesweightForVirginPulp(), 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			//29
			util.addValue(row, col++, baleInventory.getTotalbalesOfBrownWetLap(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, CommonUtil.round(baleInventory.getTotalbalesweightForBrownWetLap(), 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			//30
			util.addValue(row, col++, baleInventory.getTotalbalesOfPulpDryLap(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, CommonUtil.round(baleInventory.getTotalbalesweightForPulpDryLap(), 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			//31
			util.addValue(row, col++, baleInventory.getTotalbalesOfOtherRolls(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, CommonUtil.round(baleInventory.getTotalbalesweightForOtherRolls(), 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			//32
			util.addValue(row, col++, baleInventory.getTotalbalesOfSTBaleswetlap(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, CommonUtil.round(baleInventory.getTotalbalesweightForSTBaleswetlap(), 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			//33
			util.addValue(row, col++, baleInventory.getTotalbalesOfSTTBaledBroke(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, CommonUtil.round(baleInventory.getTotalbalesweightForSTTBaledBroke(), 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			
			/*New Grade Added From Here 14-11-2017*/
			
			util.addValue(row, col++, baleInventory.getTotalbalesOfVirginHardWood(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, CommonUtil.round(baleInventory.getTotalbalesweightForVirginHardWood(), 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			
			util.addValue(row, col++, baleInventory.getTotalbalesOfVirginSoftWood(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, CommonUtil.round(baleInventory.getTotalbalesweightForVirginSoftWood(), 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			
			
			//Print Here Total Bales And Total Weight
			util.addValue(row, col++, baleInventory.getTotalbales(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_GREEN, rowHeight);
			util.addValue(row, col++, CommonUtil.round(baleInventory.getTotalbalesweight(), 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER_GREEN, rowHeight);
			
			
			row++;
			//Print Total Columncol
			lastcol=0;
			util.addValue(row, lastcol++, "Total", Workbook2007Util.Style.STYLE_NORMAL_CENTER_GREEN, rowHeight);	
			//1
			_otalbalesbalesOfMWL=_otalbalesbalesOfMWL+baleInventory.getTotalbalesOfMWL();
			util.addValue(row, lastcol++, _otalbalesbalesOfMWL, Workbook2007Util.Style.STYLE_NORMAL_CENTER_GREEN, rowHeight);
			//2
			_otalbalesweightForMWL=_otalbalesweightForMWL+baleInventory.getTotalbalesweightForMWL();
			util.addValue(row, lastcol++, CommonUtil.round(_otalbalesweightForMWL, 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER_GREEN, rowHeight);
			//3
			getTotalbalesOfPrtmix=getTotalbalesOfPrtmix+baleInventory.getTotalbalesOfPrtmix();
			util.addValue(row, lastcol++, getTotalbalesOfPrtmix, Workbook2007Util.Style.STYLE_NORMAL_CENTER_GREEN, rowHeight);
			//4
			getTotalbalesweightForPrtmix=getTotalbalesweightForPrtmix+baleInventory.getTotalbalesweightForPrtmix();
			util.addValue(row, lastcol++, CommonUtil.round(getTotalbalesweightForPrtmix, 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER_GREEN, rowHeight);
			//5
			getTotalbalesOfMCL=getTotalbalesOfMCL+baleInventory.getTotalbalesOfMCL();
			util.addValue(row, lastcol++, getTotalbalesOfMCL, Workbook2007Util.Style.STYLE_NORMAL_CENTER_GREEN, rowHeight);
			//6
			getTotalbalesweightForMCL=getTotalbalesweightForMCL+baleInventory.getTotalbalesweightForMCL();
			util.addValue(row, lastcol++, CommonUtil.round(getTotalbalesweightForMCL, 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER_GREEN, rowHeight);
			//7
			getTotalbalesOfMWLWorIGS=getTotalbalesOfMWLWorIGS+baleInventory.getTotalbalesOfMWLWorIGS();
			util.addValue(row, lastcol++, getTotalbalesOfMWLWorIGS, Workbook2007Util.Style.STYLE_NORMAL_CENTER_GREEN, rowHeight);
			//8
			getTotalbalesweightForMWLWorIGS=getTotalbalesweightForMWLWorIGS+baleInventory.getTotalbalesweightForMWLWorIGS();
			util.addValue(row, lastcol++, CommonUtil.round(getTotalbalesweightForMWLWorIGS, 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER_GREEN, rowHeight);
			//9
			getTotalbalesOfCBS=getTotalbalesOfCBS+baleInventory.getTotalbalesOfCBS();
			util.addValue(row, lastcol++, getTotalbalesOfCBS, Workbook2007Util.Style.STYLE_NORMAL_CENTER_GREEN, rowHeight);
			//10
			getTotalbalesweightForCBS=getTotalbalesweightForCBS+baleInventory.getTotalbalesweightForCBS();
			util.addValue(row, lastcol++, CommonUtil.round(getTotalbalesweightForCBS, 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER_GREEN, rowHeight);
			//11
			getTotalbalesOfCtdGdwd=getTotalbalesOfCtdGdwd+baleInventory.getTotalbalesOfCtdGdwd();
			util.addValue(row, lastcol++, getTotalbalesOfCtdGdwd, Workbook2007Util.Style.STYLE_NORMAL_CENTER_GREEN, rowHeight);
			//12
			getTotalbalesweightForCtdGdwd=getTotalbalesweightForCtdGdwd+baleInventory.getTotalbalesweightForCtdGdwd();
			util.addValue(row, lastcol++, CommonUtil.round(getTotalbalesweightForCtdGdwd, 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER_GREEN, rowHeight);
			//13
			getTotalbalesOfSWL=getTotalbalesOfSWL+baleInventory.getTotalbalesOfSWL();
			util.addValue(row, lastcol++, getTotalbalesOfSWL, Workbook2007Util.Style.STYLE_NORMAL_CENTER_GREEN, rowHeight);
			//14
			getTotalbalesweightForSWL=getTotalbalesweightForSWL+baleInventory.getTotalbalesweightForSWL();
			util.addValue(row, lastcol++, CommonUtil.round(getTotalbalesweightForSWL, 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER_GREEN, rowHeight);
			//15
			getTotalbalesOfONPOldNewsPrint=getTotalbalesOfONPOldNewsPrint+baleInventory.getTotalbalesOfONPOldNewsPrint();
			util.addValue(row, lastcol++, getTotalbalesOfONPOldNewsPrint, Workbook2007Util.Style.STYLE_NORMAL_CENTER_GREEN, rowHeight);
			//16
			getTotalbalesweightForONPOldNewsPrint=getTotalbalesweightForONPOldNewsPrint+baleInventory.getTotalbalesweightForONPOldNewsPrint();
			util.addValue(row, lastcol++, CommonUtil.round(getTotalbalesweightForONPOldNewsPrint, 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER_GREEN, rowHeight);
			//17
			getTotalbalesOfOINews=getTotalbalesOfOINews+baleInventory.getTotalbalesOfOINews();
			util.addValue(row, lastcol++, getTotalbalesOfOINews, Workbook2007Util.Style.STYLE_NORMAL_CENTER_GREEN, rowHeight);
			//18
			getTotalbalesweightForOINews=getTotalbalesweightForOINews+baleInventory.getTotalbalesweightForOINews();
			util.addValue(row, lastcol++, CommonUtil.round(getTotalbalesweightForOINews, 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER_GREEN, rowHeight);
			//19
			getTotalbalesOfLightPrtSBS=getTotalbalesOfLightPrtSBS+baleInventory.getTotalbalesOfLightPrtSBS();
			util.addValue(row, lastcol++, getTotalbalesOfLightPrtSBS, Workbook2007Util.Style.STYLE_NORMAL_CENTER_GREEN, rowHeight);
			//20
			getTotalbalesweightForLightPrtSBS=getTotalbalesweightForLightPrtSBS+baleInventory.getTotalbalesweightForLightPrtSBS();
			util.addValue(row, lastcol++, CommonUtil.round(getTotalbalesweightForLightPrtSBS, 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER_GREEN, rowHeight);
			//21
			getTotalbalesOfHW=getTotalbalesOfHW+baleInventory.getTotalbalesOfHW();
			util.addValue(row, lastcol++, getTotalbalesOfHW, Workbook2007Util.Style.STYLE_NORMAL_CENTER_GREEN, rowHeight);
			//22
			getTotalbalesweightForHW=getTotalbalesweightForHW+baleInventory.getTotalbalesweightForHW();
			util.addValue(row, lastcol++, CommonUtil.round(getTotalbalesweightForHW, 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER_GREEN, rowHeight);
			//23
			getTotalbalesOfHeavyPrtSBS=getTotalbalesOfHeavyPrtSBS+baleInventory.getTotalbalesOfHeavyPrtSBS();
			util.addValue(row, lastcol++, getTotalbalesOfHeavyPrtSBS, Workbook2007Util.Style.STYLE_NORMAL_CENTER_GREEN, rowHeight);
			//24
			getTotalbalesweightForHeavyPrtSBS=getTotalbalesweightForHeavyPrtSBS+baleInventory.getTotalbalesweightForHeavyPrtSBS();
			util.addValue(row, lastcol++, CommonUtil.round(getTotalbalesweightForHeavyPrtSBS, 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER_GREEN, rowHeight);
			//25
			getTotalbalesOfSOW=getTotalbalesOfSOW+baleInventory.getTotalbalesOfSOW();
			util.addValue(row, lastcol++, getTotalbalesOfSOW, Workbook2007Util.Style.STYLE_NORMAL_CENTER_GREEN, rowHeight);
			//26
			getTotalbalesweightForSOW=getTotalbalesweightForSOW+baleInventory.getTotalbalesweightForSOW();
			util.addValue(row, lastcol++, CommonUtil.round(getTotalbalesweightForSOW, 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER_GREEN, rowHeight);
			//27
			getTotalbalesOfUnprtSBS=getTotalbalesOfUnprtSBS+baleInventory.getTotalbalesOfUnprtSBS();
			util.addValue(row, lastcol++, getTotalbalesOfUnprtSBS, Workbook2007Util.Style.STYLE_NORMAL_CENTER_GREEN, rowHeight);
			//28
			getTotalbalesweightForUnprtSBS=getTotalbalesweightForUnprtSBS+baleInventory.getTotalbalesweightForUnprtSBS();
			util.addValue(row, lastcol++, CommonUtil.round(getTotalbalesweightForUnprtSBS, 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER_GREEN, rowHeight);
			//29
			getTotalbalesOfNewsblank=getTotalbalesOfNewsblank+baleInventory.getTotalbalesOfNewsblank();
			util.addValue(row, lastcol++, getTotalbalesOfNewsblank, Workbook2007Util.Style.STYLE_NORMAL_CENTER_GREEN, rowHeight);
			//30
			getTotalbalesweightForNewsblank=getTotalbalesweightForNewsblank+baleInventory.getTotalbalesweightForNewsblank();
			util.addValue(row, lastcol++, CommonUtil.round(getTotalbalesweightForNewsblank, 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER_GREEN, rowHeight);
			//31
			getTotalbalesOfWhiteGdwdBlend=getTotalbalesOfWhiteGdwdBlend+baleInventory.getTotalbalesOfWhiteGdwdBlend();
			util.addValue(row, lastcol++, getTotalbalesOfWhiteGdwdBlend, Workbook2007Util.Style.STYLE_NORMAL_CENTER_GREEN, rowHeight);
			//32
			getTotalbalesweightForWhiteGdwdBlend=getTotalbalesweightForWhiteGdwdBlend+baleInventory.getTotalbalesweightForWhiteGdwdBlend();
			util.addValue(row, lastcol++, CommonUtil.round(getTotalbalesweightForWhiteGdwdBlend, 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER_GREEN, rowHeight);
			//33
			getTotalbalesOfMailUndeliverable=getTotalbalesOfMailUndeliverable+baleInventory.getTotalbalesOfMailUndeliverable();
			util.addValue(row, lastcol++, getTotalbalesOfMailUndeliverable, Workbook2007Util.Style.STYLE_NORMAL_CENTER_GREEN, rowHeight);
			//34
			getTotalbalesweightForMailUndeliverable=getTotalbalesweightForMailUndeliverable+baleInventory.getTotalbalesweightForMailUndeliverable();
			util.addValue(row, lastcol++, CommonUtil.round(getTotalbalesweightForMailUndeliverable, 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER_GREEN, rowHeight);
			//35
			getTotalbalesOfHoggedBooks=getTotalbalesOfHoggedBooks+baleInventory.getTotalbalesOfHoggedBooks();
			util.addValue(row, lastcol++, getTotalbalesOfHoggedBooks, Workbook2007Util.Style.STYLE_NORMAL_CENTER_GREEN, rowHeight);
			//36
			getTotalbalesweightForHoggedBooks=getTotalbalesweightForHoggedBooks+baleInventory.getTotalbalesweightForHoggedBooks();
			util.addValue(row, lastcol++, CommonUtil.round(getTotalbalesweightForHoggedBooks, 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER_GREEN, rowHeight);
			//37
			getTotalbalesOfOCC=getTotalbalesOfOCC+baleInventory.getTotalbalesOfOCC();
			util.addValue(row, lastcol++, getTotalbalesOfOCC, Workbook2007Util.Style.STYLE_NORMAL_CENTER_GREEN, rowHeight);
			//38
			getTotalbalesweightForOCC=getTotalbalesweightForOCC+baleInventory.getTotalbalesweightForOCC();
			util.addValue(row, lastcol++, CommonUtil.round(getTotalbalesweightForOCC, 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER_GREEN, rowHeight);
			//39
			getTotalbalesOfDLK=getTotalbalesOfDLK+baleInventory.getTotalbalesOfDLK();
			util.addValue(row, lastcol++, getTotalbalesOfDLK, Workbook2007Util.Style.STYLE_NORMAL_CENTER_GREEN, rowHeight);
			//40
			getTotalbalesweightForDLK=getTotalbalesweightForDLK+baleInventory.getTotalbalesweightForDLK();
			util.addValue(row, lastcol++, CommonUtil.round(getTotalbalesweightForDLK, 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER_GREEN, rowHeight);
			//33
			getTotalbalesOfMixedPaper=getTotalbalesOfMixedPaper+baleInventory.getTotalbalesOfMixedPaper();
			util.addValue(row, lastcol++, getTotalbalesOfMixedPaper, Workbook2007Util.Style.STYLE_NORMAL_CENTER_GREEN, rowHeight);
			//33
			getTotalbalesweightForMixedPaper=getTotalbalesweightForMixedPaper+baleInventory.getTotalbalesweightForMixedPaper();
			util.addValue(row, lastcol++, CommonUtil.round(getTotalbalesweightForMixedPaper, 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER_GREEN, rowHeight);
			//33
			getTotalbalesOfSoftWoodChips=getTotalbalesOfSoftWoodChips+baleInventory.getTotalbalesOfSoftWoodChips();
			util.addValue(row, lastcol++, getTotalbalesOfSoftWoodChips, Workbook2007Util.Style.STYLE_NORMAL_CENTER_GREEN, rowHeight);
			//33
			getTotalbalesweightForSoftWoodChips=getTotalbalesweightForSoftWoodChips+baleInventory.getTotalbalesweightForSoftWoodChips();
			util.addValue(row, lastcol++, CommonUtil.round(getTotalbalesweightForSoftWoodChips, 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER_GREEN, rowHeight);
			//33
			getTotalbalesOfHardWoodChips=getTotalbalesOfHardWoodChips+baleInventory.getTotalbalesOfHardWoodChips();
			util.addValue(row, lastcol++, getTotalbalesOfHardWoodChips, Workbook2007Util.Style.STYLE_NORMAL_CENTER_GREEN, rowHeight);
			//33
			getTotalbalesweightForHardWoodChips=getTotalbalesweightForHardWoodChips+baleInventory.getTotalbalesweightForHardWoodChips();
			util.addValue(row, lastcol++, CommonUtil.round(getTotalbalesweightForHardWoodChips, 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER_GREEN, rowHeight);
			//33
			getTotalbalesOfPWE=getTotalbalesOfPWE+baleInventory.getTotalbalesOfPWE();
			util.addValue(row, lastcol++, getTotalbalesOfPWE, Workbook2007Util.Style.STYLE_NORMAL_CENTER_GREEN, rowHeight);
			//33
			getTotalbalesweightForPWE=getTotalbalesweightForPWE+baleInventory.getTotalbalesweightForPWE();
			util.addValue(row, lastcol++, CommonUtil.round(getTotalbalesweightForPWE, 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER_GREEN, rowHeight);
			//33
			getTotalbalesOfWhiteBroke=getTotalbalesOfWhiteBroke+baleInventory.getTotalbalesOfWhiteBroke();
			util.addValue(row, lastcol++, getTotalbalesOfWhiteBroke, Workbook2007Util.Style.STYLE_NORMAL_CENTER_GREEN, rowHeight);
			//33
			getTotalbalesweightForWhiteBroke=getTotalbalesweightForWhiteBroke+baleInventory.getTotalbalesweightForWhiteBroke();
			util.addValue(row, lastcol++, CommonUtil.round(getTotalbalesweightForWhiteBroke, 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER_GREEN, rowHeight);
			//33
			getTotalbalesOfBrownNapkinBroke=getTotalbalesOfBrownNapkinBroke+baleInventory.getTotalbalesOfBrownNapkinBroke();
			util.addValue(row, lastcol++, getTotalbalesOfBrownNapkinBroke, Workbook2007Util.Style.STYLE_NORMAL_CENTER_GREEN, rowHeight);
			//33
			getTotalbalesweightForBrownNapkinBroke=getTotalbalesweightForBrownNapkinBroke+baleInventory.getTotalbalesweightForBrownNapkinBroke();
			util.addValue(row, lastcol++, CommonUtil.round(getTotalbalesweightForBrownNapkinBroke, 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER_GREEN, rowHeight);
			//33
			getTotalbalesOfPULPWetLap=getTotalbalesOfPULPWetLap+baleInventory.getTotalbalesOfPULPWetLap();
			util.addValue(row, lastcol++, getTotalbalesOfPULPWetLap, Workbook2007Util.Style.STYLE_NORMAL_CENTER_GREEN, rowHeight);
			//33
			getTotalbalesweightForPULPWetLap=getTotalbalesweightForPULPWetLap+baleInventory.getTotalbalesweightForPULPWetLap();
			util.addValue(row, lastcol++, CommonUtil.round(getTotalbalesweightForPULPWetLap, 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER_GREEN, rowHeight);
			//33
			getTotalbalesOfVirginPulp=getTotalbalesOfVirginPulp+baleInventory.getTotalbalesOfVirginPulp();
			util.addValue(row, lastcol++, getTotalbalesOfVirginPulp, Workbook2007Util.Style.STYLE_NORMAL_CENTER_GREEN, rowHeight);
			//33
			getTotalbalesweightForVirginPulp=getTotalbalesweightForVirginPulp+baleInventory.getTotalbalesweightForVirginPulp();
			util.addValue(row, lastcol++, CommonUtil.round(getTotalbalesweightForVirginPulp, 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER_GREEN, rowHeight);
			//33
			getTotalbalesOfBrownWetLap=getTotalbalesOfBrownWetLap+baleInventory.getTotalbalesOfBrownWetLap();
			util.addValue(row, lastcol++, getTotalbalesOfBrownWetLap, Workbook2007Util.Style.STYLE_NORMAL_CENTER_GREEN, rowHeight);
			//33
			getTotalbalesweightForBrownWetLap=getTotalbalesweightForBrownWetLap+baleInventory.getTotalbalesweightForBrownWetLap();
			util.addValue(row, lastcol++, CommonUtil.round(getTotalbalesweightForBrownWetLap, 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER_GREEN, rowHeight);
			//33
			getTotalbalesOfPulpDryLap=getTotalbalesOfPulpDryLap+baleInventory.getTotalbalesOfPulpDryLap();
			util.addValue(row, lastcol++, getTotalbalesOfPulpDryLap, Workbook2007Util.Style.STYLE_NORMAL_CENTER_GREEN, rowHeight);
			//33
			getTotalbalesweightForPulpDryLap=getTotalbalesweightForPulpDryLap+baleInventory.getTotalbalesweightForPulpDryLap();
			util.addValue(row, lastcol++, CommonUtil.round(getTotalbalesweightForPulpDryLap, 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER_GREEN, rowHeight);
			//33
			getTotalbalesOfOtherRolls=getTotalbalesOfOtherRolls+baleInventory.getTotalbalesOfOtherRolls();
			util.addValue(row, lastcol++, getTotalbalesOfOtherRolls, Workbook2007Util.Style.STYLE_NORMAL_CENTER_GREEN, rowHeight);
			//33
			getTotalbalesweightForOtherRolls=getTotalbalesweightForOtherRolls+baleInventory.getTotalbalesweightForOtherRolls();
			util.addValue(row, lastcol++, CommonUtil.round(getTotalbalesweightForOtherRolls, 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER_GREEN, rowHeight);
			//33
			getTotalbalesOfSTBaleswetlap=getTotalbalesOfSTBaleswetlap+baleInventory.getTotalbalesOfSTBaleswetlap();
			util.addValue(row, lastcol++, getTotalbalesOfSTBaleswetlap, Workbook2007Util.Style.STYLE_NORMAL_CENTER_GREEN, rowHeight);
			//33
			getTotalbalesweightForSTBaleswetlap=getTotalbalesweightForSTBaleswetlap+baleInventory.getTotalbalesweightForSTBaleswetlap();
			util.addValue(row, lastcol++, CommonUtil.round(getTotalbalesweightForSTBaleswetlap, 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER_GREEN, rowHeight);
			//33
			getTotalbalesOfSTTBaledBroke=getTotalbalesOfSTTBaledBroke+baleInventory.getTotalbalesOfSTTBaledBroke();
			util.addValue(row, lastcol++, getTotalbalesOfSTTBaledBroke, Workbook2007Util.Style.STYLE_NORMAL_CENTER_GREEN, rowHeight);
			//33
			getTotalbalesweightForSTTBaledBroke=getTotalbalesweightForSTTBaledBroke+baleInventory.getTotalbalesweightForSTTBaledBroke();
			util.addValue(row, lastcol++, CommonUtil.round(getTotalbalesweightForSTTBaledBroke, 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER_GREEN, rowHeight);
			
			
			/*New Grade Code Added From Here  14-11-2017*/
			getTotalbalesOfVirginHardWood=getTotalbalesOfVirginHardWood+baleInventory.getTotalbalesOfVirginHardWood();
			util.addValue(row, lastcol++, getTotalbalesOfVirginHardWood, Workbook2007Util.Style.STYLE_NORMAL_CENTER_GREEN, rowHeight);
			//33
			getTotalbalesweightForVirginHardWood=getTotalbalesweightForVirginHardWood+baleInventory.getTotalbalesweightForVirginHardWood();
			util.addValue(row, lastcol++, CommonUtil.round(getTotalbalesweightForVirginHardWood, 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER_GREEN, rowHeight);
			
			
			getTotalbalesOfVirginSoftWood=getTotalbalesOfVirginSoftWood+baleInventory.getTotalbalesOfVirginSoftWood();
			util.addValue(row, lastcol++, getTotalbalesOfVirginSoftWood, Workbook2007Util.Style.STYLE_NORMAL_CENTER_GREEN, rowHeight);
			//33
			getTotalbalesweightForVirginSoftWood=getTotalbalesweightForVirginSoftWood+baleInventory.getTotalbalesweightForVirginSoftWood();
			util.addValue(row, lastcol++, CommonUtil.round(getTotalbalesweightForVirginSoftWood, 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER_GREEN, rowHeight);
				
			
			//print Grand total here, Starts
			finaltotalbales=finaltotalbales+baleInventory.getTotalbales();
			util.addValue(row, lastcol++, finaltotalbales, Workbook2007Util.Style.STYLE_NORMAL_CENTER_GREEN, rowHeight);		
					
			finaltotalbalesweight=finaltotalbalesweight+baleInventory.getTotalbalesweight();
			util.addValue(row, lastcol++, CommonUtil.round(finaltotalbalesweight, 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER_GREEN, rowHeight);		
			//print Grand total here, Ends
			
		}
		
		
		util.write(outputStream);
	}

}

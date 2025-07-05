/**
 *Aug 22, 2015
 *BarcodeInvetoryReportHandler.java
 * TODO
 *com.st.wastepaper.report
 *BarcodeInvetoryReportHandler.java
 *Sunil Singh Bora
 */
package com.st.wastepaper.report;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

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
public class BarcodeInvetoryReportHandler {

	/**
	 * @param unloadbalesdata
	 * @param consumedBalesData
	 * @param consumedBalesDataOfOneDay
	 * @param openingMonth 
	 * @param yesterdayDate 
	 * @param file
	 * @param outputStream
	 * @throws IOException 
	 */
	private SimpleDateFormat dateFormat=new SimpleDateFormat("MM-dd-yyyy");
	private SimpleDateFormat dateFormat1=new SimpleDateFormat("MM/dd/yyyy");

	public void getDailyInventeryReport(String name ,Map<String,String>  map,File file,ServletOutputStream outputStream) throws IOException {
		Workbook2007Util util = new Workbook2007Util(file,0);
		util.setSheetName("Inventory Report", 0);
		short rowHeight = 280;
		int row=9;
		int col=2;
		String date=dateFormat.format(new Date());
		/*util.mergeCell(1, 2, 5, 11);
		util.addValue(1,5,"  DAILY INVENTRY REPORT ",Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(row,col++,"  Date    ",Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.setAutoSizeColumn(col);
		util.addValue(row,col++,"Customer Name",Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.setAutoSizeColumn(col);
		util.addValue(row,col++,"Total Orders",Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.setAutoSizeColumn(col);
		util.addValue(row,col++,"Total Shipped",Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.setAutoSizeColumn(col);
		util.addValue(row,col++,"Total Inventry",Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.setAutoSizeColumn(col);*/
		util.addValue(7,4,name,Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(7,2,"Date : "+date,Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		float TS=0,TI=0;
		for (String key: map.keySet()) {			
			col=2;			
			util.addValue(row,col++,key,Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
			String s=map.get(key);
			String array[]= s.split("-");
			float shipeed=0,inventory=0;
			try {
				
			} catch (Exception e) {
				// TODO: handle exception
			}
			shipeed=Math.round(Float.valueOf(array[0]));
			inventory=Math.round(Float.valueOf(array[1]));
			util.addValue(row,col++,shipeed,Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		    util.addValue(row,col++,inventory,Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		    row++;
		    TS=TS+shipeed;
		    TI=TI+inventory;
		}
		util.addValue( row,2,"Gross Total",Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue( row,3,TS,Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue( row,4,TI,Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		/*row=row+1;col=2;
		util.addValue(row,col++,"MTD",Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(row,col++,name,Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(row,col++,map.get("totalTonQty"),Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(row,col++,map.get("totalShiped"),Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(row,col++,map.get("inventry"),Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);*/

		util.write(outputStream);
	}

	public void getBarcodeInventoryReport(
			List<WastePaperBaleInventory> unloadbalesdata,
			List<WastePaperBaleInventory> consumedBalesData,
			List<WastePaperBaleInventory> consumedBalesDataOfOneDay, java.sql.Date preDayOfStartDate, List<BarcodeComman> openingMonth, List<WastePaperBaleInventory> frpData, Date yesterdayDate, Date startdate, File file,
			ServletOutputStream outputStream) throws IOException {
		Workbook2007Util util = new Workbook2007Util(file,0);
		util.setSheetName("Bale Inventory Report", 0);
		short rowHeight = 280;
		int row=2;
		//Variables Starts From Here For FRP Wetlap Data
		int bales_white=0;
		double baleWeight_white=0;
		int bales_Brown=0;
		double baleWeight_brown=0;
		String color="";
		for(final WastePaperBaleInventory frpLocation: frpData){
			color=frpLocation.getLotcolor();
			System.out.println("Color::::::"+color);
			if(color.equalsIgnoreCase("White")){
				bales_white=frpLocation.getStt_wetlapbales_pm6_white();
				baleWeight_white=frpLocation.getStt_wetlapbales_pm6_white_weight();		
			}
			if(color.equalsIgnoreCase("Brown")){
				bales_Brown=frpLocation.getStt_wetlapbales_pm6_brown();
				baleWeight_brown=frpLocation.getStt_wetlapbales_pm6_brown_weight();		
			}
		}
		//Variables Ends Here For FRP Wetlap Data

		//Variable For Bales			//First Starts From Here
		int MWLcbos=0;
		int Prt_mixcbos=0;
		int MCLcbos=0;
		int MWL_W_IGScbos=0;
		int CBScbos=0;
		int Ctd_Gdwdcbos=0;
		int SWLcbos=0;
		int ONPcbos=0;
		int OI_Newscbos=0;
		int Light_Prt_SBScbos=0;
		int HWcbos=0;
		int Heavy_Prt_SBScbos=0;
		int SOWcbos=0;
		int Unprt_SBScbos=0;
		int Newsblankcbos=0;
		int White_Gdwd_Blendcbos=0;
		int Mail_Undeliverablecbos=0;
		int Hogged_Bookscbos=0;
		int OCCcbos=0;
		int DLKcbos=0;
		int Mixed_Papercbos=0;
		int Soft_Wood_Chipscbos=0;
		int Hard_Wood_Chipscbos=0;
		int PWEcbos=0;
		int White_Brokecbos=0;
		int Brown_Napkin_Brokecbos=0;
		int PULP_Wet_Lapcbos=0;
		int Virgin_Pulpcbos=0;
		int Brown_Wet_Lapcbos=0;
		int Pulp_Dry_Lapcbos=0;
		int Other_Rollscbos=0;
		int ST_Bales_wetlapcbos=0;
		int STT_Baled_Broke_Butlcbos=0;
		int STT_WetlapBales_PM6_White=0;
		int STT_WetlapBales_PM6_Brown=0;

		int VirginHardWoodcbos=0;
		int VirginSoftWoodcbos=0;

		int total_cbod_bales=0;//Total Consumed Bales Of One day
		//Variable For Weight
		double MWLcbos_Weight=0;
		double Prt_mixcbos_Weight=0;
		double MCLcbos_Weight=0;
		double MWL_W_IGScbos_Weight=0;
		double CBScbos_Weight=0;
		double Ctd_Gdwdcbos_Weight=0;
		double SWLcbos_Weight=0;
		double ONPcbos_Weight=0;
		double OI_Newscbos_Weight=0;
		double Light_Prt_SBScbos_Weight=0;
		double HWcbos_Weight=0;
		double Heavy_Prt_SBScbos_Weight=0;
		double SOWcbos_Weight=0;
		double Unprt_SBScbos_Weight=0;
		double Newsblankcbos_Weight=0;
		double White_Gdwd_Blendcbos_Weight=0;
		double Mail_Undeliverablecbos_Weight=0;
		double Hogged_Bookscbos_Weight=0;
		double OCCcbos_Weight=0;
		double DLKcbos_Weight=0;
		double Mixed_Papercbos_Weight=0;
		double Soft_Wood_Chipscbos_Weight=0;
		double Hard_Wood_Chipscbos_Weight=0;
		double PWEcbos_Weight=0;
		double White_Brokecbos_Weight=0;
		double Brown_Napkin_Brokecbos_Weight=0;
		double PULP_Wet_Lapcbos_Weight=0;
		double Virgin_Pulpcbos_Weight=0;
		double Brown_Wet_Lapcbos_Weight=0;
		double Pulp_Dry_Lapcbos_Weight=0;
		double Other_Rollscbos_Weight=0;
		double ST_Bales_wetlapcbos_Weight=0;
		double STT_Baled_Broke_Butlcbos_Weight=0;
		double STT_WetlapBales_PM6_White_Weight=0;
		double STT_WetlapBales_PM6_Brown_Weight=0;

		double VirginHardWoodcbos_Weight=0;
		double VirginSoftWoodcbos_Weight=0;


		double total_cbod_weight=0;
		//First Ends Here
		//second Starts From Here 
		//Variable For Opening Month Bales
		int prtmix_om=0;
		int mwl_om=0;
		int mcl_om=0;
		int mwlwigs_om =0; 
		int cbs_om =0;
		int ctdGdwd_om=0;
		int swlsortedwhite_om=0;
		int onpolnNewsprint_om=0;
		int oinews_om=0;
		int lightprtsbs_om =0; 
		int hw_om=0;
		int heavyprtsbs_om=0;
		int sow_om=0;
		int unprtsbs_om=0;
		int newsblank_om=0;
		int whitegdwdblend_om=0;
		int mailundeliverable_om=0;
		int hoggedbooks_om=0;
		int occ_om=0;
		int dlk_om=0;
		int mixedpaper_om=0;
		int softwoodchips_om=0;
		int hardwoodchips_om=0;
		int whitebroke_om=0;
		int pwe_om=0;
		int brownnapkinbroke_om =0;
		int pulpwetlap_om=0;
		int virginpulp_om =0;
		int brownwetLap_om=0;
		int otherrolls_om =0;
		int stbaleswetlap_om=0;
		int sttbaledbrokebutl_om=0;
		int pulpdryLap_om =0;

		int virginhardwood_om =0;
		int virginsoftwood_om =0;
		// int onpolnNewspr_om=0;
		//Variable For Opening Month Bales Weight
		double prtmix_weight_om=0;
		double mwl_weight_om=0;
		double mcl_weight_om=0;
		double mwlwigs_weight_om =0; 
		double cbs_weight_om =0;
		double ctdGdwd_weight_om=0;
		double swlsortedwhite_weight_om=0;
		double onpolnNewsprint_weight_om=0;
		double oinews_weight_om=0;
		double lightprtsbs_weight_om =0; 
		double hw_weight_om=0;
		double heavyprtsbs_weight_om=0;
		double sow_weight_om=0;
		double unprtsbs_weight_om=0;
		double newsblank_weight_om=0;
		double whitegdwdblend_weight_om=0;
		double mailundeliverable_weight_om=0;
		double hoggedbooks_weight_om=0;
		double occ_weight_om=0;
		double dlk_weight_om=0;
		double mixedpaper_weight_om=0;
		double softwoodchips_weight_om=0;
		double hardwoodchips_weight_om=0;
		double whitebroke_weight_om=0;
		double pwe_weight_om=0;
		double brownnapkinbroke_weight_om =0;
		double pulpwetlap_weight_om=0;
		double virginpulp_weight_om =0;
		double brownwetLap_weight_om=0;
		double otherrolls_weight_om =0;
		double stbaleswetlap_weight_om=0;
		double sttbaledbrokebutl_weight_om=0;
		double pulpdryLap_weight_om =0;

		double virginhardwood_weight_om =0;
		double virginsoftwood_weight_om =0;

		double total_Tonnage=0;
		//Second ends Here
		//Third Starts From Here
		int MWL1 = 0,MWL2=0;
		int Prt_mix1 = 0,Prt_mix2=0;
		int MCL1 = 0,MCL2=0;
		int MWL_W_IGS1 = 0,MWL_W_IGS2=0;
		int CBS1 = 0,CBS2=0;
		int Ctd_Gdwd1 = 0,Ctd_Gdwd2=0;
		int SWL1 = 0,SWL2=0;
		int ONP1 = 0,ONP2=0;
		int OI_News1 = 0,OI_News2=0;
		int Light_Prt_SBS1 = 0,Light_Prt_SBS2=0;
		int HW1 = 0,HW2=0;
		int Heavy_Prt_SBS1 = 0,Heavy_Prt_SBS2=0;
		int SOW1 = 0,SOW2=0;
		int Unprt_SBS1 = 0,Unprt_SBS2=0;
		int Newsblank1 = 0,Newsblank2=0;
		int White_Gdwd_Blend1 = 0,White_Gdwd_Blend2=0;
		int Mail_Undeliverable1 = 0,Mail_Undeliverable2=0;
		int Hogged_Books1 = 0,Hogged_Books2=0;
		int OCC1 = 0,OCC2=0;
		int DLK1 = 0,DLK2=0;
		int Mixed_Paper1 = 0,Mixed_Paper2=0;
		int Soft_Wood_Chips1 = 0,Soft_Wood_Chips2=0;
		int Hard_Wood_Chips1 = 0,Hard_Wood_Chips2=0;
		int PWE1 = 0,PWE2=0;
		int White_Broke1 = 0,White_Broke2=0;
		int Brown_Napkin_Broke1 = 0,Brown_Napkin_Broke2=0;
		int PULP_Wet_Lap1 = 0,PULP_Wet_Lap2=0;
		int Virgin_Pulp1 = 0,Virgin_Pulp2=0;
		int Brown_Wet_Lap1 = 0,Brown_Wet_Lap2=0;
		int Pulp_Dry_Lap1 = 0,Pulp_Dry_Lap2=0;
		int Other_Rolls1 = 0,Other_Rolls2=0;
		int ST_Bales_wetlap1 = 0,ST_Bales_wetlap2=0;
		int STT_Baled_Broke_Butl1 = 0,STT_Baled_Broke_Butl2=0;


		int Virgin_Hard_Wood1 = 0,Virgin_Hard_Wood2=0;
		int Virgin_Soft_Wood1 = 0,Virgin_Soft_Wood2=0;


		int _totalUnloadBales=0;
		int _totalConsumedBales=0;

		double MWLW1 = 0; double MWLW2=0;
		double Prt_mixW1 = 0; double Prt_mixW2=0;
		double MCLW1 = 0; double MCLW2=0;
		double MWL_W_IGSW1 = 0; double MWL_W_IGSW2=0;
		double CBSW1 = 0; double CBSW2=0;
		double Ctd_GdwdW1 = 0; double Ctd_GdwdW2=0;
		double SWLW1 = 0; double SWLW2=0;
		double ONPW1 = 0; double ONPW2=0;
		double OI_NewsW1 = 0; double OI_NewsW2=0;
		double Light_Prt_SBSW1 = 0; double Light_Prt_SBSW2=0;
		double HWW1 = 0; double HWW2=0;
		double Heavy_Prt_SBSW1 = 0; double Heavy_Prt_SBSW2=0;
		double SOWW1 = 0; double SOWW2=0;
		double Unprt_SBSW1 = 0; double Unprt_SBSW2=0;
		double NewsblankW1 = 0; double NewsblankW2=0;
		double White_Gdwd_BlendW1 = 0; double White_Gdwd_BlendW2=0;
		double Mail_UndeliverableW1 = 0; double Mail_UndeliverableW2=0;
		double Hogged_BooksW1 = 0; double Hogged_BooksW2=0;
		double OCCW1 = 0; double OCCW2=0;
		double DLKW1 = 0; double DLKW2=0;
		double Mixed_PaperW1 = 0; double Mixed_PaperW2=0;
		double Soft_Wood_ChipsW1 = 0; double Soft_Wood_ChipsW2=0;
		double Hard_Wood_ChipsW1 = 0; double Hard_Wood_ChipsW2=0;
		double PWEW1 = 0; double PWEW2=0;
		double White_BrokeW1 = 0; double White_BrokeW2=0;
		double Brown_Napkin_BrokeW1 = 0; double Brown_Napkin_BrokeW2=0;
		double PULP_Wet_LapW1 = 0; double PULP_Wet_LapW2=0;
		double Virgin_PulpW1 = 0; double Virgin_PulpW2=0;
		double Brown_Wet_LapW1 = 0; double Brown_Wet_LapW2=0;
		double Pulp_Dry_LapW1 = 0; double Pulp_Dry_LapW2=0;
		double Other_RollsW1 = 0; double Other_RollsW2=0;
		double ST_Bales_wetlapW1 = 0; double ST_Bales_wetlapW2=0;
		double STT_Baled_Broke_ButlW1 = 0; double STT_Baled_Broke_ButlW2=0;

		double Virgin_Hard_WoodW1 = 0; double Virgin_Hard_WoodW2=0;
		double Virgin_Soft_WoodW1 = 0; double Virgin_Soft_WoodW2=0;

		double _totalUnloadBalesWeight=0;
		double _totalConsumedBalesWeight=0;

		//Third Ends Here
		for(final WastePaperBaleInventory baleInventory1:unloadbalesdata){
			MWL1=baleInventory1.getTotalbalesOfMWL()+MWL1;

			Prt_mix1=baleInventory1.getTotalbalesOfPrtmix()+Prt_mix1;

			MCL1=baleInventory1.getTotalbalesOfMCL()+MCL1;

			MWL_W_IGS1=baleInventory1.getTotalbalesOfMWLWorIGS()+MWL_W_IGS1;

			CBS1=baleInventory1.getTotalbalesOfCBS()+CBS1;

			Ctd_Gdwd1=baleInventory1.getTotalbalesOfCtdGdwd()+Ctd_Gdwd1;

			SWL1=baleInventory1.getTotalbalesOfSWL()+SWL1;

			ONP1=baleInventory1.getTotalbalesOfONPOldNewsPrint()+ONP1;

			OI_News1=baleInventory1.getTotalbalesOfOINews()+OI_News1;

			Light_Prt_SBS1=baleInventory1.getTotalbalesOfLightPrtSBS()+Light_Prt_SBS1;

			HW1=baleInventory1.getTotalbalesOfHW()+HW1;

			Heavy_Prt_SBS1=baleInventory1.getTotalbalesOfHeavyPrtSBS()+Heavy_Prt_SBS1;

			SOW1=baleInventory1.getTotalbalesOfSOW()+SOW1;

			Unprt_SBS1=baleInventory1.getTotalbalesOfUnprtSBS()+Unprt_SBS1;

			Newsblank1=baleInventory1.getTotalbalesOfNewsblank()+Newsblank1;

			White_Gdwd_Blend1=baleInventory1.getTotalbalesOfWhiteGdwdBlend()+White_Gdwd_Blend1;

			Mail_Undeliverable1=baleInventory1.getTotalbalesOfMailUndeliverable()+Mail_Undeliverable1;

			Hogged_Books1=baleInventory1.getTotalbalesOfHoggedBooks()+Hogged_Books1;

			OCC1=baleInventory1.getTotalbalesOfOCC()+OCC1;

			DLK1=baleInventory1.getTotalbalesOfDLK()+DLK1;

			Mixed_Paper1=baleInventory1.getTotalbalesOfMixedPaper()+Mixed_Paper1;

			Soft_Wood_Chips1=baleInventory1.getTotalbalesOfSoftWoodChips()+Soft_Wood_Chips1;

			Hard_Wood_Chips1=baleInventory1.getTotalbalesOfHardWoodChips()+Hard_Wood_Chips1;

			PWE1=baleInventory1.getTotalbalesOfPWE()+PWE1;

			White_Broke1=baleInventory1.getTotalbalesOfWhiteBroke()+White_Broke1;

			Brown_Napkin_Broke1=baleInventory1.getTotalbalesOfBrownNapkinBroke()+Brown_Napkin_Broke1;

			PULP_Wet_Lap1=baleInventory1.getTotalbalesOfPULPWetLap()+PULP_Wet_Lap1;

			Virgin_Pulp1=baleInventory1.getTotalbalesOfVirginPulp()+Virgin_Pulp1;

			Brown_Wet_Lap1=baleInventory1.getTotalbalesOfBrownWetLap()+Brown_Wet_Lap1;

			Pulp_Dry_Lap1=baleInventory1.getTotalbalesOfPulpDryLap()+Pulp_Dry_Lap1;

			Other_Rolls1=baleInventory1.getTotalbalesOfOtherRolls()+Other_Rolls1;

			ST_Bales_wetlap1=baleInventory1.getTotalbalesOfSTBaleswetlap()+ST_Bales_wetlap1;

			STT_Baled_Broke_Butl1=baleInventory1.getTotalbalesOfSTTBaledBroke()+STT_Baled_Broke_Butl1;

			//
			Virgin_Hard_Wood1=baleInventory1.getTotalbalesOfVirginHardWood()+Virgin_Hard_Wood1;
			Virgin_Soft_Wood1=baleInventory1.getTotalbalesOfVirginSoftWood()+Virgin_Soft_Wood1;
			//

			_totalUnloadBales=MWL1+Prt_mix1+MCL1+MWL_W_IGS1+CBS1+Ctd_Gdwd1+SWL1+ONP1+OI_News1+Light_Prt_SBS1+
					HW1+Heavy_Prt_SBS1+SOW1+Unprt_SBS1+Newsblank1+White_Gdwd_Blend1+Mail_Undeliverable1+Hogged_Books1+OCC1+DLK1+Mixed_Paper1+
					Soft_Wood_Chips1+Hard_Wood_Chips1+PWE1+White_Broke1+Brown_Napkin_Broke1+PULP_Wet_Lap1+Virgin_Pulp1+Brown_Wet_Lap1+Pulp_Dry_Lap1+
					Other_Rolls1+ST_Bales_wetlap1+STT_Baled_Broke_Butl1+Virgin_Hard_Wood1+Virgin_Soft_Wood1;

			//Getter Setter For Weight
			MWLW1=baleInventory1.getTotalbalesweightForMWL()+MWLW1;

			Prt_mixW1=baleInventory1.getTotalbalesweightForPrtmix()+Prt_mixW1;

			MCLW1=baleInventory1.getTotalbalesweightForMCL()+MCLW1;

			MWL_W_IGSW1=baleInventory1.getTotalbalesweightForMWLWorIGS()+MWL_W_IGSW1;

			CBSW1=baleInventory1.getTotalbalesweightForCBS()+CBSW1;

			Ctd_GdwdW1=baleInventory1.getTotalbalesweightForCtdGdwd()+Ctd_GdwdW1;

			SWLW1=baleInventory1.getTotalbalesweightForSWL()+SWLW1;

			ONPW1=baleInventory1.getTotalbalesweightForONPOldNewsPrint()+ONPW1;

			OI_NewsW1=baleInventory1.getTotalbalesweightForOINews()+OI_NewsW1;

			Light_Prt_SBSW1=baleInventory1.getTotalbalesweightForLightPrtSBS()+Light_Prt_SBSW1;

			HWW1=baleInventory1.getTotalbalesweightForHW()+HWW1;

			Heavy_Prt_SBSW1=baleInventory1.getTotalbalesweightForHeavyPrtSBS()+Heavy_Prt_SBSW1;

			SOWW1=baleInventory1.getTotalbalesweightForSOW()+SOWW1;

			Unprt_SBSW1=baleInventory1.getTotalbalesweightForUnprtSBS()+Unprt_SBSW1;

			NewsblankW1=baleInventory1.getTotalbalesweightForNewsblank()+NewsblankW1;

			White_Gdwd_BlendW1=baleInventory1.getTotalbalesweightForWhiteGdwdBlend()+White_Gdwd_BlendW1;

			Mail_UndeliverableW1=baleInventory1.getTotalbalesweightForMailUndeliverable()+Mail_UndeliverableW1;

			Hogged_BooksW1=baleInventory1.getTotalbalesweightForHoggedBooks()+Hogged_BooksW1;

			OCCW1=baleInventory1.getTotalbalesweightForOCC()+OCCW1;

			DLKW1=baleInventory1.getTotalbalesweightForDLK()+DLKW1;

			Mixed_PaperW1=baleInventory1.getTotalbalesweightForMixedPaper()+Mixed_PaperW1;

			Soft_Wood_ChipsW1=baleInventory1.getTotalbalesweightForSoftWoodChips()+Soft_Wood_ChipsW1;

			Hard_Wood_ChipsW1=baleInventory1.getTotalbalesweightForHardWoodChips()+Hard_Wood_ChipsW1;

			PWEW1=baleInventory1.getTotalbalesweightForPWE()+PWEW1;

			White_BrokeW1=baleInventory1.getTotalbalesweightForWhiteBroke()+White_BrokeW1;

			Brown_Napkin_BrokeW1=baleInventory1.getTotalbalesweightForBrownNapkinBroke()+Brown_Napkin_BrokeW1;

			PULP_Wet_LapW1=baleInventory1.getTotalbalesweightForPULPWetLap()+PULP_Wet_LapW1;

			Virgin_PulpW1=baleInventory1.getTotalbalesweightForVirginPulp()+Virgin_PulpW1;

			Brown_Wet_LapW1=baleInventory1.getTotalbalesweightForBrownWetLap()+Brown_Wet_LapW1;

			Pulp_Dry_LapW1=baleInventory1.getTotalbalesweightForPulpDryLap()+Pulp_Dry_LapW1;

			Other_RollsW1=baleInventory1.getTotalbalesweightForOtherRolls()+Other_RollsW1;

			ST_Bales_wetlapW1=baleInventory1.getTotalbalesweightForSTBaleswetlap()+ST_Bales_wetlapW1;

			STT_Baled_Broke_ButlW1=baleInventory1.getTotalbalesweightForSTTBaledBroke()+STT_Baled_Broke_ButlW1;

			//
			Virgin_Hard_WoodW1=baleInventory1.getTotalbalesweightForVirginHardWood()+Virgin_Hard_WoodW1;
			Virgin_Soft_WoodW1=baleInventory1.getTotalbalesweightForVirginSoftWood()+Virgin_Soft_WoodW1;
			//

			_totalUnloadBalesWeight=MWLW1+Prt_mixW1+MCLW1+MWL_W_IGSW1+CBSW1+Ctd_GdwdW1+SWLW1+ONPW1+OI_NewsW1+Light_Prt_SBSW1+
					HWW1+Heavy_Prt_SBSW1+SOWW1+Unprt_SBSW1+NewsblankW1+White_Gdwd_BlendW1+Mail_UndeliverableW1+Hogged_BooksW1+OCCW1+DLKW1+
					Mixed_PaperW1+Soft_Wood_ChipsW1+Hard_Wood_ChipsW1+PWEW1+White_BrokeW1+Brown_Napkin_BrokeW1+PULP_Wet_LapW1+
					Virgin_PulpW1+Brown_Wet_LapW1+Pulp_Dry_LapW1+Other_RollsW1+ST_Bales_wetlapW1+STT_Baled_Broke_ButlW1+Virgin_Hard_WoodW1+Virgin_Soft_WoodW1;
		}
		for(final WastePaperBaleInventory baleInventory2: consumedBalesData){

			MWL2=baleInventory2.getTotalbalesOfMWL()+MWL2;

			Prt_mix2=baleInventory2.getTotalbalesOfPrtmix()+Prt_mix2;

			MCL2=baleInventory2.getTotalbalesOfMCL()+MCL2;

			MWL_W_IGS2=baleInventory2.getTotalbalesOfMWLWorIGS()+MWL_W_IGS2;

			CBS2=baleInventory2.getTotalbalesOfCBS()+CBS2;

			Ctd_Gdwd2=baleInventory2.getTotalbalesOfCtdGdwd()+Ctd_Gdwd2;

			SWL2=baleInventory2.getTotalbalesOfSWL()+SWL2;

			ONP2=baleInventory2.getTotalbalesOfONPOldNewsPrint()+ONP2;

			OI_News2=baleInventory2.getTotalbalesOfOINews()+OI_News2;

			Light_Prt_SBS2=baleInventory2.getTotalbalesOfLightPrtSBS()+Light_Prt_SBS2;

			HW2=baleInventory2.getTotalbalesOfHW()+HW2;

			Heavy_Prt_SBS2=baleInventory2.getTotalbalesOfHeavyPrtSBS()+Heavy_Prt_SBS2;

			SOW2=baleInventory2.getTotalbalesOfSOW()+SOW2;

			Unprt_SBS2=baleInventory2.getTotalbalesOfUnprtSBS()+Unprt_SBS2;

			Newsblank2=baleInventory2.getTotalbalesOfNewsblank()+Newsblank2;

			White_Gdwd_Blend2=baleInventory2.getTotalbalesOfWhiteGdwdBlend()+White_Gdwd_Blend2;

			Mail_Undeliverable2=baleInventory2.getTotalbalesOfMailUndeliverable()+Mail_Undeliverable2;

			Hogged_Books2=baleInventory2.getTotalbalesOfHoggedBooks()+Hogged_Books2;

			OCC2=baleInventory2.getTotalbalesOfOCC()+OCC2;

			DLK2=baleInventory2.getTotalbalesOfDLK()+DLK2;

			Mixed_Paper2=baleInventory2.getTotalbalesOfMixedPaper()+Mixed_Paper2;

			Soft_Wood_Chips2=baleInventory2.getTotalbalesOfSoftWoodChips()+Soft_Wood_Chips2;

			Hard_Wood_Chips2=baleInventory2.getTotalbalesOfHardWoodChips()+Hard_Wood_Chips2;

			PWE2=baleInventory2.getTotalbalesOfPWE()+PWE2;

			White_Broke2=baleInventory2.getTotalbalesOfWhiteBroke()+White_Broke2;

			Brown_Napkin_Broke2=baleInventory2.getTotalbalesOfBrownNapkinBroke()+Brown_Napkin_Broke2;

			PULP_Wet_Lap2=baleInventory2.getTotalbalesOfPULPWetLap()+PULP_Wet_Lap2;

			Virgin_Pulp2=baleInventory2.getTotalbalesOfVirginPulp()+Virgin_Pulp2;

			Brown_Wet_Lap2=baleInventory2.getTotalbalesOfBrownWetLap()+Brown_Wet_Lap2;

			Pulp_Dry_Lap2=baleInventory2.getTotalbalesOfPulpDryLap()+Pulp_Dry_Lap2;

			Other_Rolls2=baleInventory2.getTotalbalesOfOtherRolls()+Other_Rolls2;

			ST_Bales_wetlap2=baleInventory2.getTotalbalesOfSTBaleswetlap()+ST_Bales_wetlap2;

			STT_Baled_Broke_Butl2=baleInventory2.getTotalbalesOfSTTBaledBroke()+STT_Baled_Broke_Butl2;

			//
			Virgin_Hard_Wood2=baleInventory2.getTotalbalesOfVirginHardWood()+Virgin_Hard_Wood2;
			Virgin_Soft_Wood2=baleInventory2.getTotalbalesOfVirginSoftWood()+Virgin_Soft_Wood2;
			//

			_totalConsumedBales=MWL2+Prt_mix2+MCL2+MWL_W_IGS2+CBS2+Ctd_Gdwd2+SWL2+ONP2+OI_News2+Light_Prt_SBS2+
					HW2+Heavy_Prt_SBS2+SOW2+Unprt_SBS2+Newsblank2+White_Gdwd_Blend2+Mail_Undeliverable2+Hogged_Books2+OCC2+DLK2+Mixed_Paper2+
					Soft_Wood_Chips2+Hard_Wood_Chips2+PWE2+White_Broke2+Brown_Napkin_Broke2+PULP_Wet_Lap2+Virgin_Pulp2+Brown_Wet_Lap2+Pulp_Dry_Lap2+
					Other_Rolls2+ST_Bales_wetlap2+STT_Baled_Broke_Butl2+Virgin_Hard_Wood2+Virgin_Soft_Wood2;

			//Getter Setter For Weight

			MWLW2=baleInventory2.getTotalbalesweightForMWL()+MWLW2;

			Prt_mixW2=baleInventory2.getTotalbalesweightForPrtmix()+Prt_mixW2;

			MCLW2=baleInventory2.getTotalbalesweightForMCL()+MCLW2;

			MWL_W_IGSW2=baleInventory2.getTotalbalesweightForMWLWorIGS()+MWL_W_IGSW2;

			CBSW2=baleInventory2.getTotalbalesweightForCBS()+CBSW2;

			Ctd_GdwdW2=baleInventory2.getTotalbalesweightForCtdGdwd()+Ctd_GdwdW2;

			SWLW2=baleInventory2.getTotalbalesweightForSWL()+SWLW2;

			ONPW2=baleInventory2.getTotalbalesweightForONPOldNewsPrint()+ONPW2;

			OI_NewsW2=baleInventory2.getTotalbalesweightForOINews()+OI_NewsW2;

			Light_Prt_SBSW2=baleInventory2.getTotalbalesweightForLightPrtSBS()+Light_Prt_SBSW2;

			HWW2=baleInventory2.getTotalbalesweightForHW()+HWW2;

			Heavy_Prt_SBSW2=baleInventory2.getTotalbalesweightForHeavyPrtSBS()+Heavy_Prt_SBSW2;

			SOWW2=baleInventory2.getTotalbalesweightForSOW()+SOWW2;

			Unprt_SBSW2=baleInventory2.getTotalbalesweightForUnprtSBS()+Unprt_SBSW2;

			NewsblankW2=baleInventory2.getTotalbalesweightForNewsblank()+NewsblankW2;

			White_Gdwd_BlendW2=baleInventory2.getTotalbalesweightForWhiteGdwdBlend()+White_Gdwd_BlendW2;

			Mail_UndeliverableW2=baleInventory2.getTotalbalesweightForMailUndeliverable()+Mail_UndeliverableW2;

			Hogged_BooksW2=baleInventory2.getTotalbalesweightForHoggedBooks()+Hogged_BooksW2;

			OCCW2=baleInventory2.getTotalbalesweightForOCC()+OCCW2;

			DLKW2=baleInventory2.getTotalbalesweightForDLK()+DLKW2;

			Mixed_PaperW2=baleInventory2.getTotalbalesweightForMixedPaper()+Mixed_PaperW2;

			Soft_Wood_ChipsW2=baleInventory2.getTotalbalesweightForSoftWoodChips()+Soft_Wood_ChipsW2;

			Hard_Wood_ChipsW2=baleInventory2.getTotalbalesweightForHardWoodChips()+Hard_Wood_ChipsW2;

			PWEW2=baleInventory2.getTotalbalesweightForPWE()+PWEW2;

			White_BrokeW2=baleInventory2.getTotalbalesweightForWhiteBroke()+White_BrokeW2;

			Brown_Napkin_BrokeW2=baleInventory2.getTotalbalesweightForBrownNapkinBroke()+Brown_Napkin_BrokeW2;

			PULP_Wet_LapW2=baleInventory2.getTotalbalesweightForPULPWetLap()+PULP_Wet_LapW2;

			Virgin_PulpW2=baleInventory2.getTotalbalesweightForVirginPulp()+Virgin_PulpW2;

			Brown_Wet_LapW2=baleInventory2.getTotalbalesweightForBrownWetLap()+Brown_Wet_LapW2;

			Pulp_Dry_LapW2=baleInventory2.getTotalbalesweightForPulpDryLap()+Pulp_Dry_LapW2;

			Other_RollsW2=baleInventory2.getTotalbalesweightForOtherRolls()+Other_RollsW2;

			ST_Bales_wetlapW2=baleInventory2.getTotalbalesweightForSTBaleswetlap()+ST_Bales_wetlapW2;

			STT_Baled_Broke_ButlW2=baleInventory2.getTotalbalesweightForSTTBaledBroke()+STT_Baled_Broke_ButlW2;


			//
			Virgin_Hard_WoodW2=baleInventory2.getTotalbalesweightForVirginHardWood()+Virgin_Hard_WoodW2;
			Virgin_Soft_WoodW2=baleInventory2.getTotalbalesweightForVirginSoftWood()+Virgin_Soft_WoodW2;
			//

			_totalConsumedBalesWeight=MWLW2+Prt_mixW2+MCLW2+MWL_W_IGSW2+CBSW2+Ctd_GdwdW2+SWLW2+ONPW2+OI_NewsW2+Light_Prt_SBSW2+HWW2+Heavy_Prt_SBSW2+SOWW2+
					Unprt_SBSW2+NewsblankW2+White_Gdwd_BlendW2+Mail_UndeliverableW2+Hogged_BooksW2+OCCW2+DLKW2+Mixed_PaperW2+
					Soft_Wood_ChipsW2+Hard_Wood_ChipsW2+PWEW2+White_BrokeW2+Brown_Napkin_BrokeW2+PULP_Wet_LapW2+Virgin_PulpW2+
					Brown_Wet_LapW2+Pulp_Dry_LapW2+Other_RollsW2+ST_Bales_wetlapW2+STT_Baled_Broke_ButlW2+Virgin_Hard_WoodW2+Virgin_Soft_WoodW2;

		}
		util.addValue(0,0,"WASTE PAPER BALE INVENTORY REPORT- "+dateFormat1.format(startdate)+" 7 A.M.",Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		for(final BarcodeComman barcode:openingMonth){
			int col=0;	
			//Setter Getter For Bales
			prtmix_om=barcode.getPrtmix();

			mwl_om=barcode.getMwl();

			mcl_om=barcode.getMcl();

			mwlwigs_om=barcode.getMwlwigs();

			cbs_om =barcode.getCbs();

			ctdGdwd_om =barcode.getCtdGdwd();

			swlsortedwhite_om=barcode.getSwlsortedwhite();


			onpolnNewsprint_om=barcode.getOnpolnNewsprint();


			oinews_om =barcode.getOinews();

			lightprtsbs_om  =barcode.getLightprtsbs();

			hw_om =barcode.getHw();

			heavyprtsbs_om =barcode.getHeavyprtsbs();

			sow_om=barcode.getSow();

			unprtsbs_om=barcode.getUnprtsbs();

			newsblank_om = barcode.getNewsblank();

			whitegdwdblend_om=barcode.getWhitegdwdblend();

			mailundeliverable_om=barcode.getMailundeliverable();   

			hoggedbooks_om=barcode.getHoggedbooks();    

			occ_om =barcode.getOcc();     

			dlk_om= barcode.getDlk();    

			mixedpaper_om=barcode.getMixedpaper();

			softwoodchips_om=barcode.getSoftwoodchips();     

			hardwoodchips_om=barcode.getHardwoodchips();      

			whitebroke_om =barcode.getWhitebroke();     

			pwe_om=barcode.getPwe();      

			brownnapkinbroke_om =barcode.getBrownnapkinbroke();     

			pulpwetlap_om=barcode.getPulpwetlap();      

			virginpulp_om =barcode.getVirginpulp();

			brownwetLap_om = barcode.getBrownwetLap();    

			pulpdryLap_om = barcode.getPulpdryLap();    

			otherrolls_om  = barcode.getOtherrolls(); 

			stbaleswetlap_om= barcode.getStbaleswetlap();    

			sttbaledbrokebutl_om=barcode.getSttbaledbrokebutl();

			//
			virginhardwood_om=barcode.getVirginhardwood();
			virginsoftwood_om=barcode.getVirginsoftwood();
			//

			//Setter Getter For Bales Weight

			prtmix_weight_om=barcode.getPrtmixw();

			mwl_weight_om=barcode.getMwlw();

			mcl_weight_om=barcode.getMclw();

			mwlwigs_weight_om=barcode.getMwlwigsw();

			cbs_weight_om =barcode.getCbsw();

			ctdGdwd_weight_om=barcode.getCtdGdwdw();

			swlsortedwhite_weight_om=barcode.getSwlsortedwhitew();

			onpolnNewsprint_weight_om=barcode.getOnpolnNewsprintw();

			oinews_weight_om=barcode.getOinewsw();

			lightprtsbs_weight_om =barcode.getLightprtsbsw(); 

			hw_weight_om=barcode.getHww();

			heavyprtsbs_weight_om=barcode.getHeavyprtsbsw();

			sow_weight_om=barcode.getSoww();

			unprtsbs_weight_om=barcode.getUnprtsbsw();

			newsblank_weight_om=barcode.getNewsblankw();

			whitegdwdblend_weight_om=barcode.getWhitegdwdblendw();

			mailundeliverable_weight_om=barcode.getMailundeliverablew();

			hoggedbooks_weight_om=barcode.getHoggedbooksw();

			occ_weight_om=barcode.getOccw();

			dlk_weight_om=barcode.getDlkw();

			mixedpaper_weight_om=barcode.getMixedpaperw();

			softwoodchips_weight_om=barcode.getSoftwoodchipsw();

			hardwoodchips_weight_om=barcode.getHardwoodchipsw();

			whitebroke_weight_om=barcode.getWhitebrokew();

			pwe_weight_om=barcode.getPwew();

			brownnapkinbroke_weight_om =barcode.getBrownnapkinbrokew();

			pulpwetlap_weight_om=barcode.getPulpwetlapw();

			virginpulp_weight_om =barcode.getVirginpulpw();

			brownwetLap_weight_om=barcode.getBrownwetLapw();

			otherrolls_weight_om =barcode.getOtherrollsw();

			stbaleswetlap_weight_om=barcode.getStbaleswetlapw();

			sttbaledbrokebutl_weight_om=barcode.getSttbaledbrokebutlw();

			pulpdryLap_weight_om =barcode.getPulpdryLapw();

			//
			virginhardwood_weight_om =barcode.getVirginhardwoodw();
			virginsoftwood_weight_om =barcode.getVirginsoftwoodw();
			//


			int value1=(mwl_om+MWL1)-(MWL2);
			int value2=(prtmix_om+Prt_mix1)-(Prt_mix2);
			int value3=(mcl_om+MCL1)-(MCL2);
			int value4=(mwlwigs_om+MWL_W_IGS1)-(MWL_W_IGS2);
			int value5=(cbs_om+CBS1)-(CBS2);
			int value6=(ctdGdwd_om+Ctd_Gdwd1)-(Ctd_Gdwd2);
			int value7=(swlsortedwhite_om+SWL1)-(SWL2);
			int value8=(onpolnNewsprint_om+ONP1)-(ONP2);
			int value9=(oinews_om+OI_News1)-(OI_News2);
			int value10=(lightprtsbs_om+Light_Prt_SBS1)-(Light_Prt_SBS2);
			int value11=(hw_om+HW1)-(HW2);
			int value12=(heavyprtsbs_om+Heavy_Prt_SBS1)-(Heavy_Prt_SBS2);
			int value13=(sow_om+SOW1)-(SOW2);
			int value14=(unprtsbs_om+Unprt_SBS1)-Unprt_SBS2;
			int value15=(newsblank_om+Newsblank1)-Newsblank2;
			int value16=(whitegdwdblend_om+White_Gdwd_Blend1)-White_Gdwd_Blend2;
			int value17=(mailundeliverable_om+Mail_Undeliverable1)-Mail_Undeliverable2;
			int value18=(hoggedbooks_om+Hogged_Books1)-Hogged_Books2;
			int value19=(occ_om+OCC1)-OCC2;
			int value20=(dlk_om+DLK1)-DLK2;
			int value21=(mixedpaper_om+Mixed_Paper1)-Mixed_Paper2;
			int value22=(softwoodchips_om+Soft_Wood_Chips1)-Soft_Wood_Chips2;
			int value23=(hardwoodchips_om+Hard_Wood_Chips1)-Hard_Wood_Chips2;
			int value24=(pwe_om+PWE1)-PWE2;
			int value25=(whitebroke_om+White_Broke1)-White_Broke2;
			int value26=(brownnapkinbroke_om+Brown_Napkin_Broke1)-Brown_Napkin_Broke2;
			int value27=(pulpwetlap_om+PULP_Wet_Lap1)-PULP_Wet_Lap2;
			int value28=(virginpulp_om+Virgin_Pulp1)-Virgin_Pulp2;
			int value29=(brownwetLap_om+Brown_Wet_Lap1)-Brown_Wet_Lap2;
			int value30=(pulpdryLap_om+Pulp_Dry_Lap1)-Pulp_Dry_Lap2;
			int value31=(otherrolls_om+Other_Rolls1)-Other_Rolls2;
			int value32=(stbaleswetlap_om+ST_Bales_wetlap1)-ST_Bales_wetlap2;
			int value33=(sttbaledbrokebutl_om+STT_Baled_Broke_Butl1)-STT_Baled_Broke_Butl2;

			//
			int value67=(virginhardwood_om+Virgin_Hard_Wood1)-Virgin_Hard_Wood2;
			int value68=(virginsoftwood_om+Virgin_Soft_Wood1)-Virgin_Soft_Wood2;
			//

			int totalBales=value1+value2+value3+value4+value5+value6+value7+value8+value9+value10+
					value11+value12+value13+value14+value15+value16+value17+value18+value19+value20+
					value21+value22+value23+value24+value25+value26+value27+value28+value29+value30+
					value31+value32+value33+bales_white+bales_Brown+value67+value68;

			double value34=(CommonUtil.round(mwl_weight_om, 2)+CommonUtil.round(MWLW1, 2))-(CommonUtil.round(MWLW2, 2));
			double value35=(CommonUtil.round(prtmix_weight_om, 2)+CommonUtil.round(Prt_mixW1, 2))-(CommonUtil.round(Prt_mixW2, 2));
			double value36=(CommonUtil.round(mcl_weight_om, 2)+CommonUtil.round(MCLW1, 2))-(CommonUtil.round(MCLW2, 2));
			double value37=(CommonUtil.round(mwlwigs_weight_om, 2)+CommonUtil.round(MWL_W_IGSW1, 2))-(CommonUtil.round(MWL_W_IGSW2, 2));
			double value38=(CommonUtil.round(cbs_weight_om, 2)+CommonUtil.round(CBSW1, 2))-(CommonUtil.round(CBSW2, 2));
			double value39=(CommonUtil.round(ctdGdwd_weight_om, 2)+CommonUtil.round(Ctd_GdwdW1, 2))-(CommonUtil.round(Ctd_GdwdW2, 2));
			double value40=(CommonUtil.round(swlsortedwhite_weight_om, 2)+CommonUtil.round(SWLW1, 2))-(CommonUtil.round(SWLW2, 2));
			double value41=(CommonUtil.round(onpolnNewsprint_weight_om, 2)+CommonUtil.round(ONPW1, 2))-(CommonUtil.round(ONPW2, 2));
			double value42=(CommonUtil.round(oinews_weight_om, 2)+CommonUtil.round(OI_NewsW1, 2))-(CommonUtil.round(OI_NewsW2, 2));
			double value43=(CommonUtil.round(lightprtsbs_weight_om, 2)+CommonUtil.round(Light_Prt_SBSW1, 2))-(CommonUtil.round(Light_Prt_SBSW2, 2));
			double value44=(CommonUtil.round(hw_weight_om, 2)+CommonUtil.round(HWW1, 2))-(CommonUtil.round(HWW2, 2));
			double value45=(CommonUtil.round(heavyprtsbs_weight_om, 2)+CommonUtil.round(Heavy_Prt_SBSW1, 2))-(CommonUtil.round(Heavy_Prt_SBSW2, 2));
			double value46=(CommonUtil.round(sow_weight_om, 2)+CommonUtil.round(SOWW1, 2))-(CommonUtil.round(SOWW2, 2));
			double value47=(CommonUtil.round(unprtsbs_weight_om, 2)+CommonUtil.round(Unprt_SBSW1, 2))-CommonUtil.round(Unprt_SBSW2, 2);
			double value48=(CommonUtil.round(newsblank_weight_om, 2)+CommonUtil.round(NewsblankW1, 2))-CommonUtil.round(NewsblankW2, 2);
			double value49=(CommonUtil.round(whitegdwdblend_weight_om, 2)+CommonUtil.round(White_Gdwd_BlendW1, 2))-CommonUtil.round(White_Gdwd_BlendW2, 2);
			double value50=(CommonUtil.round(mailundeliverable_weight_om, 2)+CommonUtil.round(Mail_UndeliverableW1, 2))-CommonUtil.round(Mail_UndeliverableW2, 2);
			double value51=(CommonUtil.round(hoggedbooks_weight_om, 2)+CommonUtil.round(Hogged_BooksW1, 2))-CommonUtil.round(Hogged_BooksW2, 2);
			double value52=(CommonUtil.round(occ_weight_om, 2)+CommonUtil.round(OCCW1, 2))-CommonUtil.round(OCCW2, 2);
			double value53=(CommonUtil.round(dlk_weight_om, 2)+CommonUtil.round(DLKW1, 2))-CommonUtil.round(DLKW2, 2);
			double value54=(CommonUtil.round(mixedpaper_weight_om, 2)+CommonUtil.round(Mixed_PaperW1, 2))-CommonUtil.round(Mixed_PaperW2, 2);
			double value55=(CommonUtil.round(softwoodchips_weight_om, 2)+CommonUtil.round(Soft_Wood_ChipsW1, 2))-CommonUtil.round(Soft_Wood_ChipsW2, 2);
			double value56=(CommonUtil.round(hardwoodchips_weight_om, 2)+CommonUtil.round(Hard_Wood_ChipsW1, 2))-CommonUtil.round(Hard_Wood_ChipsW2, 2);
			double value57=(CommonUtil.round(pwe_weight_om, 2)+CommonUtil.round(PWEW1, 2))-CommonUtil.round(PWEW2, 2);
			double value58=(CommonUtil.round(whitebroke_weight_om, 2)+CommonUtil.round(White_BrokeW1, 2))-CommonUtil.round(White_BrokeW2, 2);
			double value59=(CommonUtil.round(brownnapkinbroke_weight_om, 2)+CommonUtil.round(Brown_Napkin_BrokeW1, 2))-CommonUtil.round(Brown_Napkin_BrokeW2, 2);
			double value60=(CommonUtil.round(pulpwetlap_weight_om, 2)+CommonUtil.round(PULP_Wet_LapW1, 2))-CommonUtil.round(PULP_Wet_LapW2, 2);
			double value61=(CommonUtil.round(virginpulp_weight_om, 2)+CommonUtil.round(Virgin_PulpW1, 2))-CommonUtil.round(Virgin_PulpW2, 2);
			double value62=(CommonUtil.round(brownwetLap_weight_om, 2)+CommonUtil.round(Brown_Wet_LapW1, 2))-CommonUtil.round(Brown_Wet_LapW2, 2);
			double value63=(CommonUtil.round(pulpdryLap_weight_om, 2)+CommonUtil.round(Pulp_Dry_LapW1, 2))-CommonUtil.round(Pulp_Dry_LapW2, 2);
			double value64=(CommonUtil.round(otherrolls_weight_om, 2)+CommonUtil.round(Other_RollsW1, 2))-CommonUtil.round(Other_RollsW2, 2);
			double value65=(CommonUtil.round(stbaleswetlap_weight_om, 2)+CommonUtil.round(ST_Bales_wetlapW1, 2))-CommonUtil.round(ST_Bales_wetlapW2, 2);
			double value66=(CommonUtil.round(sttbaledbrokebutl_weight_om, 2)+CommonUtil.round(STT_Baled_Broke_ButlW1, 2))-CommonUtil.round(STT_Baled_Broke_ButlW2, 2);

			//
			double value69=(CommonUtil.round(virginhardwood_weight_om, 2)+CommonUtil.round(Virgin_Hard_WoodW1, 2))-CommonUtil.round(Virgin_Hard_WoodW2, 2);
			double value70=(CommonUtil.round(virginsoftwood_weight_om, 2)+CommonUtil.round(Virgin_Soft_WoodW1, 2))-CommonUtil.round(Virgin_Soft_WoodW2, 2);
			//
			double _final_ivt_total_weight=(CommonUtil.round(total_Tonnage, 2)+CommonUtil.round(_totalUnloadBalesWeight, 2))-(CommonUtil.round(_totalConsumedBalesWeight, 2));


			util.addValue(row, col++,"Total Bales",Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);

			util.addValue(row, col++,CommonUtil.round(value1, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++,CommonUtil.round(value2, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++,CommonUtil.round(value3, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++,CommonUtil.round(value4, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++,CommonUtil.round(value5, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++,CommonUtil.round(value6, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++,CommonUtil.round(value7, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++,CommonUtil.round(value8, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++,CommonUtil.round(value9, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++,CommonUtil.round(value10, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++,CommonUtil.round(value11, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++,CommonUtil.round(value12, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++,CommonUtil.round(value13, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++,CommonUtil.round(value14, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++,CommonUtil.round(value15, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++,CommonUtil.round(value16, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++,CommonUtil.round(value17, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++,CommonUtil.round(value18, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++,CommonUtil.round(value19, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++,CommonUtil.round(value20, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++,CommonUtil.round(value21, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++,CommonUtil.round(value22, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++,CommonUtil.round(value23, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++,CommonUtil.round(value24, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++,CommonUtil.round(value25, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++,CommonUtil.round(value26, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++,CommonUtil.round(value27, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++,CommonUtil.round(value28, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);

			util.addValue(row, col++,CommonUtil.round(value30, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);//
			util.addValue(row, col++,CommonUtil.round(value31, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++,CommonUtil.round(value33, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++,CommonUtil.round(value29, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++,CommonUtil.round(value32, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);

			util.addValue(row, col++,CommonUtil.round(bales_white, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++,CommonUtil.round(bales_Brown, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);

			//
			util.addValue(row, col++,CommonUtil.round(value67, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++,CommonUtil.round(value68, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			//

			util.addValue(row, col++,CommonUtil.round(totalBales, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			row++;

			//Setter Getter For Bales Weight
			col=0;
			util.addValue(row, col++,"Total Tonnage",Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);

			mwl_weight_om=barcode.getMwlw();
			util.addValue(row, col++,CommonUtil.round(value34, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);


			prtmix_weight_om=barcode.getPrtmixw();
			util.addValue(row, col++,CommonUtil.round(value35, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);

			mcl_weight_om=barcode.getMclw();
			util.addValue(row, col++,CommonUtil.round(value36, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);

			mwlwigs_weight_om=barcode.getMwlwigsw();
			util.addValue(row, col++,CommonUtil.round(value37, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);

			cbs_weight_om =barcode.getCbsw();
			util.addValue(row, col++,CommonUtil.round(value38, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);

			ctdGdwd_weight_om=barcode.getCtdGdwdw();
			util.addValue(row, col++,CommonUtil.round(value39, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);

			swlsortedwhite_weight_om=barcode.getSwlsortedwhitew();
			util.addValue(row, col++,CommonUtil.round(value40, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);

			onpolnNewsprint_weight_om=barcode.getOnpolnNewsprintw();
			util.addValue(row, col++,CommonUtil.round(value41, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);

			oinews_weight_om=barcode.getOinewsw();
			util.addValue(row, col++,CommonUtil.round(value42, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);

			lightprtsbs_weight_om =barcode.getLightprtsbsw(); 
			util.addValue(row, col++,CommonUtil.round(value43, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);

			hw_weight_om=barcode.getHww();
			util.addValue(row, col++,CommonUtil.round(value44, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);

			heavyprtsbs_weight_om=barcode.getHeavyprtsbsw();
			util.addValue(row, col++,CommonUtil.round(value45, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);

			sow_weight_om=barcode.getSoww();
			util.addValue(row, col++,CommonUtil.round(value46, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);

			unprtsbs_weight_om=barcode.getUnprtsbsw();
			util.addValue(row, col++,CommonUtil.round(value47, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);

			newsblank_weight_om=barcode.getNewsblankw();
			util.addValue(row, col++,CommonUtil.round(value48, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);

			whitegdwdblend_weight_om=barcode.getWhitegdwdblendw();
			util.addValue(row, col++,CommonUtil.round(value49, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);

			mailundeliverable_weight_om=barcode.getMailundeliverablew();
			util.addValue(row, col++,CommonUtil.round(value50, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);

			hoggedbooks_weight_om=barcode.getHoggedbooksw();
			util.addValue(row, col++,CommonUtil.round(value51, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);

			occ_weight_om=barcode.getOccw();
			util.addValue(row, col++,CommonUtil.round(value52, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);

			dlk_weight_om=barcode.getDlkw();
			util.addValue(row, col++,CommonUtil.round(value53, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);

			mixedpaper_weight_om=barcode.getMixedpaperw();
			util.addValue(row, col++,CommonUtil.round(value54, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);

			softwoodchips_weight_om=barcode.getSoftwoodchipsw();
			util.addValue(row, col++,CommonUtil.round(value55, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);

			hardwoodchips_weight_om=barcode.getHardwoodchipsw();
			util.addValue(row, col++,CommonUtil.round(value56, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);

			pwe_weight_om=barcode.getPwew();
			util.addValue(row, col++,CommonUtil.round(value57, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);

			whitebroke_weight_om=barcode.getWhitebrokew();
			util.addValue(row, col++,CommonUtil.round(value58, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);

			brownnapkinbroke_weight_om =barcode.getBrownnapkinbrokew();
			util.addValue(row, col++,CommonUtil.round(value59, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);

			pulpwetlap_weight_om=barcode.getPulpwetlapw();
			util.addValue(row, col++,CommonUtil.round(value60, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			//28
			virginpulp_weight_om =barcode.getVirginpulpw();
			util.addValue(row, col++,CommonUtil.round(value61, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			//33
			pulpdryLap_weight_om =barcode.getPulpdryLapw();
			util.addValue(row, col++,CommonUtil.round(value63, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			//30
			otherrolls_weight_om =barcode.getOtherrollsw();
			util.addValue(row, col++,CommonUtil.round(value64, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			//32
			sttbaledbrokebutl_weight_om=barcode.getSttbaledbrokebutlw();
			util.addValue(row, col++,CommonUtil.round(value66, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);

			//29
			brownwetLap_weight_om=barcode.getBrownwetLapw();
			util.addValue(row, col++,CommonUtil.round(value62, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			//31
			stbaleswetlap_weight_om=barcode.getStbaleswetlapw();
			util.addValue(row, col++,CommonUtil.round(value65, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);


			//
			virginhardwood_weight_om=barcode.getVirginhardwoodw();
			virginsoftwood_weight_om=barcode.getVirginsoftwoodw();
			//

			total_Tonnage=prtmix_weight_om+mwl_weight_om+mcl_weight_om+mwlwigs_weight_om + cbs_weight_om +ctdGdwd_weight_om+
					swlsortedwhite_weight_om+onpolnNewsprint_weight_om+oinews_weight_om+lightprtsbs_weight_om + hw_weight_om+
					heavyprtsbs_weight_om+sow_weight_om+unprtsbs_weight_om+newsblank_weight_om+whitegdwdblend_weight_om+
					mailundeliverable_weight_om+hoggedbooks_weight_om+occ_weight_om+dlk_weight_om+mixedpaper_weight_om+
					softwoodchips_weight_om+hardwoodchips_weight_om+whitebroke_weight_om+pwe_weight_om+brownnapkinbroke_weight_om +
					pulpwetlap_weight_om+virginpulp_weight_om +brownwetLap_weight_om+otherrolls_weight_om +stbaleswetlap_weight_om+
					sttbaledbrokebutl_weight_om+pulpdryLap_weight_om+baleWeight_white+baleWeight_brown+virginhardwood_weight_om+virginsoftwood_weight_om;

			System.out.println("total_Tonnage::"+total_Tonnage);
			util.addValue(row, col++,CommonUtil.round(baleWeight_white, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++,CommonUtil.round(baleWeight_brown, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);

			//
			util.addValue(row, col++,CommonUtil.round(value69, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++,CommonUtil.round(value70, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			//


			_final_ivt_total_weight=(CommonUtil.round(total_Tonnage, 2)+CommonUtil.round(_totalUnloadBalesWeight, 2))-(CommonUtil.round(_totalConsumedBalesWeight, 2));
			util.addValue(row, col++,CommonUtil.round(_final_ivt_total_weight, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);

		}
		row++;
		for(final WastePaperBaleInventory cBDOD: consumedBalesDataOfOneDay){
			int col=0;
			//Setter Getter For Bales

			util.addValue(row, col++,"Total No.Bales Consumed "+dateFormat.format(yesterdayDate),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);

			MWLcbos=cBDOD.getTotalbalesOfMWL();
			util.addValue(row, col++,CommonUtil.round(MWLcbos, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);

			Prt_mixcbos=cBDOD.getTotalbalesOfPrtmix();
			util.addValue(row, col++,CommonUtil.round(Prt_mixcbos, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);

			MCLcbos=cBDOD.getTotalbalesOfMCL();
			util.addValue(row, col++,CommonUtil.round(MCLcbos, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);

			MWL_W_IGScbos=cBDOD.getTotalbalesOfMWLWorIGS();
			util.addValue(row, col++,CommonUtil.round(MWL_W_IGScbos, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);

			CBScbos=cBDOD.getTotalbalesOfCBS();
			util.addValue(row, col++,CommonUtil.round(CBScbos, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);

			Ctd_Gdwdcbos=cBDOD.getTotalbalesOfCtdGdwd();
			util.addValue(row, col++,CommonUtil.round(Ctd_Gdwdcbos, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);

			SWLcbos=cBDOD.getTotalbalesOfSWL();
			util.addValue(row, col++,CommonUtil.round(SWLcbos, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);

			ONPcbos=cBDOD.getTotalbalesOfONPOldNewsPrint();
			util.addValue(row, col++,CommonUtil.round(ONPcbos, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);

			OI_Newscbos=cBDOD.getTotalbalesOfOINews();
			util.addValue(row, col++,CommonUtil.round(OI_Newscbos, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);

			Light_Prt_SBScbos=cBDOD.getTotalbalesOfLightPrtSBS();
			util.addValue(row, col++,CommonUtil.round(Light_Prt_SBScbos, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);

			HWcbos=cBDOD.getTotalbalesOfHW();
			util.addValue(row, col++,CommonUtil.round(HWcbos, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);

			Heavy_Prt_SBScbos=cBDOD.getTotalbalesOfHeavyPrtSBS();
			util.addValue(row, col++,CommonUtil.round(Heavy_Prt_SBScbos, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);

			SOWcbos=cBDOD.getTotalbalesOfSOW();
			util.addValue(row, col++,CommonUtil.round(SOWcbos, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);

			Unprt_SBScbos=cBDOD.getTotalbalesOfUnprtSBS();
			util.addValue(row, col++,CommonUtil.round(Unprt_SBScbos, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);

			Newsblankcbos=cBDOD.getTotalbalesOfNewsblank();
			util.addValue(row, col++,CommonUtil.round(Newsblankcbos, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);

			White_Gdwd_Blendcbos=cBDOD.getTotalbalesOfWhiteGdwdBlend();
			util.addValue(row, col++,CommonUtil.round(White_Gdwd_Blendcbos, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);

			Mail_Undeliverablecbos=cBDOD.getTotalbalesOfMailUndeliverable();
			util.addValue(row, col++,CommonUtil.round(Mail_Undeliverablecbos, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);

			Hogged_Bookscbos=cBDOD.getTotalbalesOfHoggedBooks();
			util.addValue(row, col++,CommonUtil.round(Hogged_Bookscbos, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);

			OCCcbos=cBDOD.getTotalbalesOfOCC();
			util.addValue(row, col++,CommonUtil.round(OCCcbos, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);

			DLKcbos=cBDOD.getTotalbalesOfDLK();
			util.addValue(row, col++,CommonUtil.round(DLKcbos, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);

			Mixed_Papercbos=cBDOD.getTotalbalesOfMixedPaper();
			util.addValue(row, col++,CommonUtil.round(Mixed_Papercbos, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);

			Soft_Wood_Chipscbos=cBDOD.getTotalbalesOfSoftWoodChips();
			util.addValue(row, col++,CommonUtil.round(Soft_Wood_Chipscbos, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);

			Hard_Wood_Chipscbos=cBDOD.getTotalbalesOfHardWoodChips();
			util.addValue(row, col++,CommonUtil.round(Hard_Wood_Chipscbos, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);

			PWEcbos=cBDOD.getTotalbalesOfPWE();
			util.addValue(row, col++,CommonUtil.round(PWEcbos, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);

			White_Brokecbos=cBDOD.getTotalbalesOfWhiteBroke();
			util.addValue(row, col++,CommonUtil.round(White_Brokecbos, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);

			Brown_Napkin_Brokecbos=cBDOD.getTotalbalesOfBrownNapkinBroke();
			util.addValue(row, col++,CommonUtil.round(Brown_Napkin_Brokecbos, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);

			PULP_Wet_Lapcbos=cBDOD.getTotalbalesOfPULPWetLap();
			util.addValue(row, col++,CommonUtil.round(PULP_Wet_Lapcbos, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);

			Virgin_Pulpcbos=cBDOD.getTotalbalesOfVirginPulp();
			util.addValue(row, col++,CommonUtil.round(Virgin_Pulpcbos, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);

			//Change Here If Have any issue Regarding Sequence 	
			Pulp_Dry_Lapcbos=cBDOD.getTotalbalesOfPulpDryLap();
			util.addValue(row, col++,CommonUtil.round(Pulp_Dry_Lapcbos, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);

			Other_Rollscbos=cBDOD.getTotalbalesOfOtherRolls();
			util.addValue(row, col++,CommonUtil.round(Other_Rollscbos, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);

			STT_Baled_Broke_Butlcbos=cBDOD.getTotalbalesOfSTTBaledBroke();
			util.addValue(row, col++,CommonUtil.round(STT_Baled_Broke_Butlcbos, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);

			Brown_Wet_Lapcbos=cBDOD.getTotalbalesOfBrownWetLap();
			util.addValue(row, col++,CommonUtil.round(Brown_Wet_Lapcbos, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);

			ST_Bales_wetlapcbos=cBDOD.getTotalbalesOfSTBaleswetlap();
			util.addValue(row, col++,CommonUtil.round(ST_Bales_wetlapcbos, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);

			//
			VirginSoftWoodcbos=cBDOD.getTotalbalesOfVirginSoftWood();
			VirginHardWoodcbos=cBDOD.getTotalbalesOfVirginHardWood();

			//
			total_cbod_bales=MWLcbos+Prt_mixcbos+MCLcbos+MWL_W_IGScbos+CBScbos+Ctd_Gdwdcbos+SWLcbos+ONPcbos+OI_Newscbos+
					Light_Prt_SBScbos+HWcbos+Heavy_Prt_SBScbos+SOWcbos+Unprt_SBScbos+Newsblankcbos+White_Gdwd_Blendcbos+
					Mail_Undeliverablecbos+Hogged_Bookscbos+OCCcbos+DLKcbos+Mixed_Papercbos+Soft_Wood_Chipscbos+
					Hard_Wood_Chipscbos+PWEcbos+White_Brokecbos+Brown_Napkin_Brokecbos+PULP_Wet_Lapcbos+
					Virgin_Pulpcbos+Brown_Wet_Lapcbos+Pulp_Dry_Lapcbos+Other_Rollscbos+ST_Bales_wetlapcbos+
					STT_Baled_Broke_Butlcbos+VirginHardWoodcbos+VirginSoftWoodcbos;

			util.addValue(row, col++,"",Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++,"",Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);

			//
			util.addValue(row, col++,CommonUtil.round(VirginHardWoodcbos, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++,CommonUtil.round(VirginSoftWoodcbos, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			//
			util.addValue(row, col++,CommonUtil.round(total_cbod_bales, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight); 

			row++;
			col=0; 

			//Setter Getter For Weight

			util.addValue(row, col++,"Consumed Tonnage",Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);

			MWLcbos_Weight=cBDOD.getTotalbalesweightForMWL();
			util.addValue(row, col++,CommonUtil.round(MWLcbos_Weight, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight); 

			Prt_mixcbos_Weight=cBDOD.getTotalbalesweightForPrtmix();
			util.addValue(row, col++,CommonUtil.round(Prt_mixcbos_Weight, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight); 

			MCLcbos_Weight=cBDOD.getTotalbalesweightForMCL();
			util.addValue(row, col++,CommonUtil.round(MCLcbos_Weight, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight); 

			MWL_W_IGScbos_Weight=cBDOD.getTotalbalesweightForMWLWorIGS();
			util.addValue(row, col++,CommonUtil.round(MWL_W_IGScbos_Weight, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight); 

			CBScbos_Weight=cBDOD.getTotalbalesweightForCBS();
			util.addValue(row, col++,CommonUtil.round(CBScbos_Weight, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight); 

			Ctd_Gdwdcbos_Weight=cBDOD.getTotalbalesweightForCtdGdwd();
			util.addValue(row, col++,CommonUtil.round(Ctd_Gdwdcbos_Weight, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight); 

			SWLcbos_Weight=cBDOD.getTotalbalesweightForSWL();
			util.addValue(row, col++,CommonUtil.round(SWLcbos_Weight, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight); 

			ONPcbos_Weight=cBDOD.getTotalbalesweightForONPOldNewsPrint();
			util.addValue(row, col++,CommonUtil.round(ONPcbos_Weight, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight); 

			OI_Newscbos_Weight=cBDOD.getTotalbalesweightForOINews();
			util.addValue(row, col++,CommonUtil.round(OI_Newscbos_Weight, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight); 

			Light_Prt_SBScbos_Weight=cBDOD.getTotalbalesweightForLightPrtSBS();
			util.addValue(row, col++,CommonUtil.round(Light_Prt_SBScbos_Weight, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight); 

			HWcbos_Weight=cBDOD.getTotalbalesweightForHW();
			util.addValue(row, col++,CommonUtil.round(HWcbos_Weight, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight); 

			Heavy_Prt_SBScbos_Weight=cBDOD.getTotalbalesweightForHeavyPrtSBS();
			util.addValue(row, col++,CommonUtil.round(Heavy_Prt_SBScbos_Weight, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight); 

			SOWcbos_Weight=cBDOD.getTotalbalesweightForSOW();
			util.addValue(row, col++,CommonUtil.round(SOWcbos_Weight, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight); 

			Unprt_SBScbos_Weight=cBDOD.getTotalbalesweightForUnprtSBS();
			util.addValue(row, col++,CommonUtil.round(Unprt_SBScbos_Weight, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight); 

			Newsblankcbos_Weight=cBDOD.getTotalbalesweightForNewsblank();
			util.addValue(row, col++,CommonUtil.round(Newsblankcbos_Weight, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight); 

			White_Gdwd_Blendcbos_Weight=cBDOD.getTotalbalesweightForWhiteGdwdBlend();
			util.addValue(row, col++,CommonUtil.round(White_Gdwd_Blendcbos_Weight, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight); 

			Mail_Undeliverablecbos_Weight=cBDOD.getTotalbalesweightForMailUndeliverable();
			util.addValue(row, col++,CommonUtil.round(Mail_Undeliverablecbos_Weight, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight); 

			Hogged_Bookscbos_Weight=cBDOD.getTotalbalesweightForHoggedBooks();
			util.addValue(row, col++,CommonUtil.round(Hogged_Bookscbos_Weight, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight); 

			OCCcbos_Weight=cBDOD.getTotalbalesweightForOCC();
			util.addValue(row, col++,CommonUtil.round(OCCcbos_Weight, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight); 

			DLKcbos_Weight=cBDOD.getTotalbalesweightForDLK();
			util.addValue(row, col++,CommonUtil.round(DLKcbos_Weight, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight); 

			Mixed_Papercbos_Weight=cBDOD.getTotalbalesweightForMixedPaper();
			util.addValue(row, col++,CommonUtil.round(Mixed_Papercbos_Weight, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight); 

			Soft_Wood_Chipscbos_Weight=cBDOD.getTotalbalesweightForSoftWoodChips();
			util.addValue(row, col++,CommonUtil.round(Soft_Wood_Chipscbos_Weight, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight); 

			Hard_Wood_Chipscbos_Weight=cBDOD.getTotalbalesweightForHardWoodChips();
			util.addValue(row, col++,CommonUtil.round(Hard_Wood_Chipscbos_Weight, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight); 

			PWEcbos_Weight=cBDOD.getTotalbalesweightForPWE();
			util.addValue(row, col++,CommonUtil.round(PWEcbos_Weight, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight); 

			White_Brokecbos_Weight=cBDOD.getTotalbalesweightForWhiteBroke();
			util.addValue(row, col++,CommonUtil.round(White_Brokecbos_Weight, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight); 

			Brown_Napkin_Brokecbos_Weight=cBDOD.getTotalbalesweightForBrownNapkinBroke();
			util.addValue(row, col++,CommonUtil.round(Brown_Napkin_Brokecbos_Weight, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight); 

			PULP_Wet_Lapcbos_Weight=cBDOD.getTotalbalesweightForPULPWetLap();
			util.addValue(row, col++,CommonUtil.round(PULP_Wet_Lapcbos_Weight, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight); 

			Virgin_Pulpcbos_Weight=cBDOD.getTotalbalesweightForVirginPulp();
			util.addValue(row, col++,CommonUtil.round(Virgin_Pulpcbos_Weight, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight); 

			//Change The Sequence of From Here If Required

			Pulp_Dry_Lapcbos_Weight=cBDOD.getTotalbalesweightForPulpDryLap();
			util.addValue(row, col++,CommonUtil.round(Pulp_Dry_Lapcbos_Weight, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight); 

			Other_Rollscbos_Weight=cBDOD.getTotalbalesweightForOtherRolls();
			util.addValue(row, col++,CommonUtil.round(Other_Rollscbos_Weight, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight); 

			STT_Baled_Broke_Butlcbos_Weight=cBDOD.getTotalbalesweightForSTTBaledBroke();
			util.addValue(row, col++,CommonUtil.round(STT_Baled_Broke_Butlcbos_Weight, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight); 

			Brown_Wet_Lapcbos_Weight=cBDOD.getTotalbalesweightForBrownWetLap();
			util.addValue(row, col++,CommonUtil.round(Brown_Wet_Lapcbos_Weight, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight); 

			ST_Bales_wetlapcbos_Weight=cBDOD.getTotalbalesweightForSTBaleswetlap();
			util.addValue(row, col++,CommonUtil.round(ST_Bales_wetlapcbos_Weight, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight); 


			//

			VirginHardWoodcbos_Weight=cBDOD.getTotalbalesweightForVirginHardWood();
			VirginSoftWoodcbos_Weight=cBDOD.getTotalbalesweightForVirginSoftWood();

			//





			total_cbod_weight=MWLcbos_Weight+Prt_mixcbos_Weight+MCLcbos_Weight+MWL_W_IGScbos_Weight+CBScbos_Weight+Ctd_Gdwdcbos_Weight+
					SWLcbos_Weight+ONPcbos_Weight+OI_Newscbos_Weight+Light_Prt_SBScbos_Weight+HWcbos_Weight+Heavy_Prt_SBScbos_Weight+
					SOWcbos_Weight+Unprt_SBScbos_Weight+Newsblankcbos_Weight+White_Gdwd_Blendcbos_Weight+Mail_Undeliverablecbos_Weight+
					Hogged_Bookscbos_Weight+OCCcbos_Weight+DLKcbos_Weight+Mixed_Papercbos_Weight+Soft_Wood_Chipscbos_Weight+
					Hard_Wood_Chipscbos_Weight+PWEcbos_Weight+White_Brokecbos_Weight+Brown_Napkin_Brokecbos_Weight+
					PULP_Wet_Lapcbos_Weight+Virgin_Pulpcbos_Weight+Brown_Wet_Lapcbos_Weight+Pulp_Dry_Lapcbos_Weight+
					Other_Rollscbos_Weight+ST_Bales_wetlapcbos_Weight+STT_Baled_Broke_Butlcbos_Weight+STT_WetlapBales_PM6_White_Weight+STT_WetlapBales_PM6_Brown_Weight;

			util.addValue(row, col++,"",Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight); 
			util.addValue(row, col++,"",Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight); 

			//
			util.addValue(row, col++,CommonUtil.round(VirginHardWoodcbos_Weight, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight); 
			util.addValue(row, col++,CommonUtil.round(VirginSoftWoodcbos_Weight, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight); 
			//

			util.addValue(row, col++,CommonUtil.round(total_cbod_weight, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight); 

			//Ends Added Later

		}
		util.write(outputStream);	 





	}

	/**
	 * @param unloadbalesdata
	 * @param consumedBalesData
	 * @param consumedBalesDataOfOneDay
	 * @param preDayOfStartDate
	 * @param openingMonth
	 * @param frpData
	 * @param yesterdayDate
	 * @param startdate
	 * @param outputStream
	 * @throws IOException 
	 */
	public void getCreateBarcodeInventoryExcelReport(
			List<WastePaperBaleInventory> unloadbalesdata,
			List<WastePaperBaleInventory> consumedBalesData,
			List<WastePaperBaleInventory> consumedBalesDataOfOneDay,
			java.sql.Date preDayOfStartDate, List<BarcodeComman> openingMonth,
			List<WastePaperBaleInventory> frpData, Date yesterdayDate,
			Date startdate, FileOutputStream outputStream) throws IOException {
		Workbook2007Util util = new Workbook2007Util();
		util.setSheetName("Bale Inventory Report", 0);
		short rowHeight = 280;

		//Variables Starts From Here For FRP Wetlap Data
		int bales_white=0;
		double baleWeight_white=0;
		int bales_Brown=0;
		double baleWeight_brown=0;
		String color="";
		for(final WastePaperBaleInventory frpLocation: frpData){
			color=frpLocation.getLotcolor();
			System.out.println("Color::::::"+color);
			if(color.equalsIgnoreCase("White")){
				bales_white=frpLocation.getStt_wetlapbales_pm6_white();
				baleWeight_white=frpLocation.getStt_wetlapbales_pm6_white_weight();		
			}
			if(color.equalsIgnoreCase("Brown")){
				bales_Brown=frpLocation.getStt_wetlapbales_pm6_brown();
				baleWeight_brown=frpLocation.getStt_wetlapbales_pm6_brown_weight();		
			}
		}
		//Variables Ends Here For FRP Wetlap Data

		//Variable For Bales			//First Starts From Here
		int MWLcbos=0;
		int Prt_mixcbos=0;
		int MCLcbos=0;
		int MWL_W_IGScbos=0;
		int CBScbos=0;
		int Ctd_Gdwdcbos=0;
		int SWLcbos=0;
		int ONPcbos=0;
		int OI_Newscbos=0;
		int Light_Prt_SBScbos=0;
		int HWcbos=0;
		int Heavy_Prt_SBScbos=0;
		int SOWcbos=0;
		int Unprt_SBScbos=0;
		int Newsblankcbos=0;
		int White_Gdwd_Blendcbos=0;
		int Mail_Undeliverablecbos=0;
		int Hogged_Bookscbos=0;
		int OCCcbos=0;
		int DLKcbos=0;
		int Mixed_Papercbos=0;
		int Soft_Wood_Chipscbos=0;
		int Hard_Wood_Chipscbos=0;
		int PWEcbos=0;
		int White_Brokecbos=0;
		int Brown_Napkin_Brokecbos=0;
		int PULP_Wet_Lapcbos=0;
		int Virgin_Pulpcbos=0;
		int Brown_Wet_Lapcbos=0;
		int Pulp_Dry_Lapcbos=0;
		int Other_Rollscbos=0;
		int ST_Bales_wetlapcbos=0;
		int STT_Baled_Broke_Butlcbos=0;
		int STT_WetlapBales_PM6_White=0;
		int STT_WetlapBales_PM6_Brown=0;

		int VirginHardWoodcbos=0;
		int VirginSoftWoodcbos=0;

		int total_cbod_bales=0;//Total Consumed Bales Of One day
		//Variable For Weight
		double MWLcbos_Weight=0;
		double Prt_mixcbos_Weight=0;
		double MCLcbos_Weight=0;
		double MWL_W_IGScbos_Weight=0;
		double CBScbos_Weight=0;
		double Ctd_Gdwdcbos_Weight=0;
		double SWLcbos_Weight=0;
		double ONPcbos_Weight=0;
		double OI_Newscbos_Weight=0;
		double Light_Prt_SBScbos_Weight=0;
		double HWcbos_Weight=0;
		double Heavy_Prt_SBScbos_Weight=0;
		double SOWcbos_Weight=0;
		double Unprt_SBScbos_Weight=0;
		double Newsblankcbos_Weight=0;
		double White_Gdwd_Blendcbos_Weight=0;
		double Mail_Undeliverablecbos_Weight=0;
		double Hogged_Bookscbos_Weight=0;
		double OCCcbos_Weight=0;
		double DLKcbos_Weight=0;
		double Mixed_Papercbos_Weight=0;
		double Soft_Wood_Chipscbos_Weight=0;
		double Hard_Wood_Chipscbos_Weight=0;
		double PWEcbos_Weight=0;
		double White_Brokecbos_Weight=0;
		double Brown_Napkin_Brokecbos_Weight=0;
		double PULP_Wet_Lapcbos_Weight=0;
		double Virgin_Pulpcbos_Weight=0;
		double Brown_Wet_Lapcbos_Weight=0;
		double Pulp_Dry_Lapcbos_Weight=0;
		double Other_Rollscbos_Weight=0;
		double ST_Bales_wetlapcbos_Weight=0;
		double STT_Baled_Broke_Butlcbos_Weight=0;
		double STT_WetlapBales_PM6_White_Weight=0;
		double STT_WetlapBales_PM6_Brown_Weight=0;

		double VirginHardWoodcbos_Weight=0;
		double VirginSoftWoodcbos_Weight=0;


		double total_cbod_weight=0;
		//First Ends Here
		//second Starts From Here 
		//Variable For Opening Month Bales
		int prtmix_om=0;
		int mwl_om=0;
		int mcl_om=0;
		int mwlwigs_om =0; 
		int cbs_om =0;
		int ctdGdwd_om=0;
		int swlsortedwhite_om=0;
		int onpolnNewsprint_om=0;
		int oinews_om=0;
		int lightprtsbs_om =0; 
		int hw_om=0;
		int heavyprtsbs_om=0;
		int sow_om=0;
		int unprtsbs_om=0;
		int newsblank_om=0;
		int whitegdwdblend_om=0;
		int mailundeliverable_om=0;
		int hoggedbooks_om=0;
		int occ_om=0;
		int dlk_om=0;
		int mixedpaper_om=0;
		int softwoodchips_om=0;
		int hardwoodchips_om=0;
		int whitebroke_om=0;
		int pwe_om=0;
		int brownnapkinbroke_om =0;
		int pulpwetlap_om=0;
		int virginpulp_om =0;
		int brownwetLap_om=0;
		int otherrolls_om =0;
		int stbaleswetlap_om=0;
		int sttbaledbrokebutl_om=0;
		int pulpdryLap_om =0;

		int virginhardwood_om =0;
		int virginsoftwood_om =0;
		// int onpolnNewspr_om=0;
		//Variable For Opening Month Bales Weight
		double prtmix_weight_om=0;
		double mwl_weight_om=0;
		double mcl_weight_om=0;
		double mwlwigs_weight_om =0; 
		double cbs_weight_om =0;
		double ctdGdwd_weight_om=0;
		double swlsortedwhite_weight_om=0;
		double onpolnNewsprint_weight_om=0;
		double oinews_weight_om=0;
		double lightprtsbs_weight_om =0; 
		double hw_weight_om=0;
		double heavyprtsbs_weight_om=0;
		double sow_weight_om=0;
		double unprtsbs_weight_om=0;
		double newsblank_weight_om=0;
		double whitegdwdblend_weight_om=0;
		double mailundeliverable_weight_om=0;
		double hoggedbooks_weight_om=0;
		double occ_weight_om=0;
		double dlk_weight_om=0;
		double mixedpaper_weight_om=0;
		double softwoodchips_weight_om=0;
		double hardwoodchips_weight_om=0;
		double whitebroke_weight_om=0;
		double pwe_weight_om=0;
		double brownnapkinbroke_weight_om =0;
		double pulpwetlap_weight_om=0;
		double virginpulp_weight_om =0;
		double brownwetLap_weight_om=0;
		double otherrolls_weight_om =0;
		double stbaleswetlap_weight_om=0;
		double sttbaledbrokebutl_weight_om=0;
		double pulpdryLap_weight_om =0;

		double virginhardwood_weight_om =0;
		double virginsoftwood_weight_om =0;

		double total_Tonnage=0;
		//Second ends Here
		//Third Starts From Here
		int MWL1 = 0,MWL2=0;
		int Prt_mix1 = 0,Prt_mix2=0;
		int MCL1 = 0,MCL2=0;
		int MWL_W_IGS1 = 0,MWL_W_IGS2=0;
		int CBS1 = 0,CBS2=0;
		int Ctd_Gdwd1 = 0,Ctd_Gdwd2=0;
		int SWL1 = 0,SWL2=0;
		int ONP1 = 0,ONP2=0;
		int OI_News1 = 0,OI_News2=0;
		int Light_Prt_SBS1 = 0,Light_Prt_SBS2=0;
		int HW1 = 0,HW2=0;
		int Heavy_Prt_SBS1 = 0,Heavy_Prt_SBS2=0;
		int SOW1 = 0,SOW2=0;
		int Unprt_SBS1 = 0,Unprt_SBS2=0;
		int Newsblank1 = 0,Newsblank2=0;
		int White_Gdwd_Blend1 = 0,White_Gdwd_Blend2=0;
		int Mail_Undeliverable1 = 0,Mail_Undeliverable2=0;
		int Hogged_Books1 = 0,Hogged_Books2=0;
		int OCC1 = 0,OCC2=0;
		int DLK1 = 0,DLK2=0;
		int Mixed_Paper1 = 0,Mixed_Paper2=0;
		int Soft_Wood_Chips1 = 0,Soft_Wood_Chips2=0;
		int Hard_Wood_Chips1 = 0,Hard_Wood_Chips2=0;
		int PWE1 = 0,PWE2=0;
		int White_Broke1 = 0,White_Broke2=0;
		int Brown_Napkin_Broke1 = 0,Brown_Napkin_Broke2=0;
		int PULP_Wet_Lap1 = 0,PULP_Wet_Lap2=0;
		int Virgin_Pulp1 = 0,Virgin_Pulp2=0;
		int Brown_Wet_Lap1 = 0,Brown_Wet_Lap2=0;
		int Pulp_Dry_Lap1 = 0,Pulp_Dry_Lap2=0;
		int Other_Rolls1 = 0,Other_Rolls2=0;
		int ST_Bales_wetlap1 = 0,ST_Bales_wetlap2=0;
		int STT_Baled_Broke_Butl1 = 0,STT_Baled_Broke_Butl2=0;


		int Virgin_Hard_Wood1 = 0,Virgin_Hard_Wood2=0;
		int Virgin_Soft_Wood1 = 0,Virgin_Soft_Wood2=0;


		int _totalUnloadBales=0;
		int _totalConsumedBales=0;

		double MWLW1 = 0; double MWLW2=0;
		double Prt_mixW1 = 0; double Prt_mixW2=0;
		double MCLW1 = 0; double MCLW2=0;
		double MWL_W_IGSW1 = 0; double MWL_W_IGSW2=0;
		double CBSW1 = 0; double CBSW2=0;
		double Ctd_GdwdW1 = 0; double Ctd_GdwdW2=0;
		double SWLW1 = 0; double SWLW2=0;
		double ONPW1 = 0; double ONPW2=0;
		double OI_NewsW1 = 0; double OI_NewsW2=0;
		double Light_Prt_SBSW1 = 0; double Light_Prt_SBSW2=0;
		double HWW1 = 0; double HWW2=0;
		double Heavy_Prt_SBSW1 = 0; double Heavy_Prt_SBSW2=0;
		double SOWW1 = 0; double SOWW2=0;
		double Unprt_SBSW1 = 0; double Unprt_SBSW2=0;
		double NewsblankW1 = 0; double NewsblankW2=0;
		double White_Gdwd_BlendW1 = 0; double White_Gdwd_BlendW2=0;
		double Mail_UndeliverableW1 = 0; double Mail_UndeliverableW2=0;
		double Hogged_BooksW1 = 0; double Hogged_BooksW2=0;
		double OCCW1 = 0; double OCCW2=0;
		double DLKW1 = 0; double DLKW2=0;
		double Mixed_PaperW1 = 0; double Mixed_PaperW2=0;
		double Soft_Wood_ChipsW1 = 0; double Soft_Wood_ChipsW2=0;
		double Hard_Wood_ChipsW1 = 0; double Hard_Wood_ChipsW2=0;
		double PWEW1 = 0; double PWEW2=0;
		double White_BrokeW1 = 0; double White_BrokeW2=0;
		double Brown_Napkin_BrokeW1 = 0; double Brown_Napkin_BrokeW2=0;
		double PULP_Wet_LapW1 = 0; double PULP_Wet_LapW2=0;
		double Virgin_PulpW1 = 0; double Virgin_PulpW2=0;
		double Brown_Wet_LapW1 = 0; double Brown_Wet_LapW2=0;
		double Pulp_Dry_LapW1 = 0; double Pulp_Dry_LapW2=0;
		double Other_RollsW1 = 0; double Other_RollsW2=0;
		double ST_Bales_wetlapW1 = 0; double ST_Bales_wetlapW2=0;
		double STT_Baled_Broke_ButlW1 = 0; double STT_Baled_Broke_ButlW2=0;

		double Virgin_Hard_WoodW1 = 0; double Virgin_Hard_WoodW2=0;
		double Virgin_Soft_WoodW1 = 0; double Virgin_Soft_WoodW2=0;

		double _totalUnloadBalesWeight=0;
		double _totalConsumedBalesWeight=0;

		//Third Ends Here
		for(final WastePaperBaleInventory baleInventory1:unloadbalesdata){
			MWL1=baleInventory1.getTotalbalesOfMWL()+MWL1;

			Prt_mix1=baleInventory1.getTotalbalesOfPrtmix()+Prt_mix1;

			MCL1=baleInventory1.getTotalbalesOfMCL()+MCL1;

			MWL_W_IGS1=baleInventory1.getTotalbalesOfMWLWorIGS()+MWL_W_IGS1;

			CBS1=baleInventory1.getTotalbalesOfCBS()+CBS1;

			Ctd_Gdwd1=baleInventory1.getTotalbalesOfCtdGdwd()+Ctd_Gdwd1;

			SWL1=baleInventory1.getTotalbalesOfSWL()+SWL1;

			ONP1=baleInventory1.getTotalbalesOfONPOldNewsPrint()+ONP1;

			OI_News1=baleInventory1.getTotalbalesOfOINews()+OI_News1;

			Light_Prt_SBS1=baleInventory1.getTotalbalesOfLightPrtSBS()+Light_Prt_SBS1;

			HW1=baleInventory1.getTotalbalesOfHW()+HW1;

			Heavy_Prt_SBS1=baleInventory1.getTotalbalesOfHeavyPrtSBS()+Heavy_Prt_SBS1;

			SOW1=baleInventory1.getTotalbalesOfSOW()+SOW1;

			Unprt_SBS1=baleInventory1.getTotalbalesOfUnprtSBS()+Unprt_SBS1;

			Newsblank1=baleInventory1.getTotalbalesOfNewsblank()+Newsblank1;

			White_Gdwd_Blend1=baleInventory1.getTotalbalesOfWhiteGdwdBlend()+White_Gdwd_Blend1;

			Mail_Undeliverable1=baleInventory1.getTotalbalesOfMailUndeliverable()+Mail_Undeliverable1;

			Hogged_Books1=baleInventory1.getTotalbalesOfHoggedBooks()+Hogged_Books1;

			OCC1=baleInventory1.getTotalbalesOfOCC()+OCC1;

			DLK1=baleInventory1.getTotalbalesOfDLK()+DLK1;

			Mixed_Paper1=baleInventory1.getTotalbalesOfMixedPaper()+Mixed_Paper1;

			Soft_Wood_Chips1=baleInventory1.getTotalbalesOfSoftWoodChips()+Soft_Wood_Chips1;

			Hard_Wood_Chips1=baleInventory1.getTotalbalesOfHardWoodChips()+Hard_Wood_Chips1;

			PWE1=baleInventory1.getTotalbalesOfPWE()+PWE1;

			White_Broke1=baleInventory1.getTotalbalesOfWhiteBroke()+White_Broke1;

			Brown_Napkin_Broke1=baleInventory1.getTotalbalesOfBrownNapkinBroke()+Brown_Napkin_Broke1;

			PULP_Wet_Lap1=baleInventory1.getTotalbalesOfPULPWetLap()+PULP_Wet_Lap1;

			Virgin_Pulp1=baleInventory1.getTotalbalesOfVirginPulp()+Virgin_Pulp1;

			Brown_Wet_Lap1=baleInventory1.getTotalbalesOfBrownWetLap()+Brown_Wet_Lap1;

			Pulp_Dry_Lap1=baleInventory1.getTotalbalesOfPulpDryLap()+Pulp_Dry_Lap1;

			Other_Rolls1=baleInventory1.getTotalbalesOfOtherRolls()+Other_Rolls1;

			ST_Bales_wetlap1=baleInventory1.getTotalbalesOfSTBaleswetlap()+ST_Bales_wetlap1;

			STT_Baled_Broke_Butl1=baleInventory1.getTotalbalesOfSTTBaledBroke()+STT_Baled_Broke_Butl1;

			//
			Virgin_Hard_Wood1=baleInventory1.getTotalbalesOfVirginHardWood()+Virgin_Hard_Wood1;
			Virgin_Soft_Wood1=baleInventory1.getTotalbalesOfVirginSoftWood()+Virgin_Soft_Wood1;
			//

			_totalUnloadBales=MWL1+Prt_mix1+MCL1+MWL_W_IGS1+CBS1+Ctd_Gdwd1+SWL1+ONP1+OI_News1+Light_Prt_SBS1+
					HW1+Heavy_Prt_SBS1+SOW1+Unprt_SBS1+Newsblank1+White_Gdwd_Blend1+Mail_Undeliverable1+Hogged_Books1+OCC1+DLK1+Mixed_Paper1+
					Soft_Wood_Chips1+Hard_Wood_Chips1+PWE1+White_Broke1+Brown_Napkin_Broke1+PULP_Wet_Lap1+Virgin_Pulp1+Brown_Wet_Lap1+Pulp_Dry_Lap1+
					Other_Rolls1+ST_Bales_wetlap1+STT_Baled_Broke_Butl1+Virgin_Hard_Wood1+Virgin_Soft_Wood1;

			//Getter Setter For Weight
			MWLW1=baleInventory1.getTotalbalesweightForMWL()+MWLW1;

			Prt_mixW1=baleInventory1.getTotalbalesweightForPrtmix()+Prt_mixW1;

			MCLW1=baleInventory1.getTotalbalesweightForMCL()+MCLW1;

			MWL_W_IGSW1=baleInventory1.getTotalbalesweightForMWLWorIGS()+MWL_W_IGSW1;

			CBSW1=baleInventory1.getTotalbalesweightForCBS()+CBSW1;

			Ctd_GdwdW1=baleInventory1.getTotalbalesweightForCtdGdwd()+Ctd_GdwdW1;

			SWLW1=baleInventory1.getTotalbalesweightForSWL()+SWLW1;

			ONPW1=baleInventory1.getTotalbalesweightForONPOldNewsPrint()+ONPW1;

			OI_NewsW1=baleInventory1.getTotalbalesweightForOINews()+OI_NewsW1;

			Light_Prt_SBSW1=baleInventory1.getTotalbalesweightForLightPrtSBS()+Light_Prt_SBSW1;

			HWW1=baleInventory1.getTotalbalesweightForHW()+HWW1;

			Heavy_Prt_SBSW1=baleInventory1.getTotalbalesweightForHeavyPrtSBS()+Heavy_Prt_SBSW1;

			SOWW1=baleInventory1.getTotalbalesweightForSOW()+SOWW1;

			Unprt_SBSW1=baleInventory1.getTotalbalesweightForUnprtSBS()+Unprt_SBSW1;

			NewsblankW1=baleInventory1.getTotalbalesweightForNewsblank()+NewsblankW1;

			White_Gdwd_BlendW1=baleInventory1.getTotalbalesweightForWhiteGdwdBlend()+White_Gdwd_BlendW1;

			Mail_UndeliverableW1=baleInventory1.getTotalbalesweightForMailUndeliverable()+Mail_UndeliverableW1;

			Hogged_BooksW1=baleInventory1.getTotalbalesweightForHoggedBooks()+Hogged_BooksW1;

			OCCW1=baleInventory1.getTotalbalesweightForOCC()+OCCW1;

			DLKW1=baleInventory1.getTotalbalesweightForDLK()+DLKW1;

			Mixed_PaperW1=baleInventory1.getTotalbalesweightForMixedPaper()+Mixed_PaperW1;

			Soft_Wood_ChipsW1=baleInventory1.getTotalbalesweightForSoftWoodChips()+Soft_Wood_ChipsW1;

			Hard_Wood_ChipsW1=baleInventory1.getTotalbalesweightForHardWoodChips()+Hard_Wood_ChipsW1;

			PWEW1=baleInventory1.getTotalbalesweightForPWE()+PWEW1;

			White_BrokeW1=baleInventory1.getTotalbalesweightForWhiteBroke()+White_BrokeW1;

			Brown_Napkin_BrokeW1=baleInventory1.getTotalbalesweightForBrownNapkinBroke()+Brown_Napkin_BrokeW1;

			PULP_Wet_LapW1=baleInventory1.getTotalbalesweightForPULPWetLap()+PULP_Wet_LapW1;

			Virgin_PulpW1=baleInventory1.getTotalbalesweightForVirginPulp()+Virgin_PulpW1;

			Brown_Wet_LapW1=baleInventory1.getTotalbalesweightForBrownWetLap()+Brown_Wet_LapW1;

			Pulp_Dry_LapW1=baleInventory1.getTotalbalesweightForPulpDryLap()+Pulp_Dry_LapW1;

			Other_RollsW1=baleInventory1.getTotalbalesweightForOtherRolls()+Other_RollsW1;

			ST_Bales_wetlapW1=baleInventory1.getTotalbalesweightForSTBaleswetlap()+ST_Bales_wetlapW1;

			STT_Baled_Broke_ButlW1=baleInventory1.getTotalbalesweightForSTTBaledBroke()+STT_Baled_Broke_ButlW1;

			//
			Virgin_Hard_WoodW1=baleInventory1.getTotalbalesweightForVirginHardWood()+Virgin_Hard_WoodW1;
			Virgin_Soft_WoodW1=baleInventory1.getTotalbalesweightForVirginSoftWood()+Virgin_Soft_WoodW1;
			//

			_totalUnloadBalesWeight=MWLW1+Prt_mixW1+MCLW1+MWL_W_IGSW1+CBSW1+Ctd_GdwdW1+SWLW1+ONPW1+OI_NewsW1+Light_Prt_SBSW1+
					HWW1+Heavy_Prt_SBSW1+SOWW1+Unprt_SBSW1+NewsblankW1+White_Gdwd_BlendW1+Mail_UndeliverableW1+Hogged_BooksW1+OCCW1+DLKW1+
					Mixed_PaperW1+Soft_Wood_ChipsW1+Hard_Wood_ChipsW1+PWEW1+White_BrokeW1+Brown_Napkin_BrokeW1+PULP_Wet_LapW1+
					Virgin_PulpW1+Brown_Wet_LapW1+Pulp_Dry_LapW1+Other_RollsW1+ST_Bales_wetlapW1+STT_Baled_Broke_ButlW1+Virgin_Hard_WoodW1+Virgin_Soft_WoodW1;
		}
		for(final WastePaperBaleInventory baleInventory2: consumedBalesData){

			MWL2=baleInventory2.getTotalbalesOfMWL()+MWL2;

			Prt_mix2=baleInventory2.getTotalbalesOfPrtmix()+Prt_mix2;

			MCL2=baleInventory2.getTotalbalesOfMCL()+MCL2;

			MWL_W_IGS2=baleInventory2.getTotalbalesOfMWLWorIGS()+MWL_W_IGS2;

			CBS2=baleInventory2.getTotalbalesOfCBS()+CBS2;

			Ctd_Gdwd2=baleInventory2.getTotalbalesOfCtdGdwd()+Ctd_Gdwd2;

			SWL2=baleInventory2.getTotalbalesOfSWL()+SWL2;

			ONP2=baleInventory2.getTotalbalesOfONPOldNewsPrint()+ONP2;

			OI_News2=baleInventory2.getTotalbalesOfOINews()+OI_News2;

			Light_Prt_SBS2=baleInventory2.getTotalbalesOfLightPrtSBS()+Light_Prt_SBS2;

			HW2=baleInventory2.getTotalbalesOfHW()+HW2;

			Heavy_Prt_SBS2=baleInventory2.getTotalbalesOfHeavyPrtSBS()+Heavy_Prt_SBS2;

			SOW2=baleInventory2.getTotalbalesOfSOW()+SOW2;

			Unprt_SBS2=baleInventory2.getTotalbalesOfUnprtSBS()+Unprt_SBS2;

			Newsblank2=baleInventory2.getTotalbalesOfNewsblank()+Newsblank2;

			White_Gdwd_Blend2=baleInventory2.getTotalbalesOfWhiteGdwdBlend()+White_Gdwd_Blend2;

			Mail_Undeliverable2=baleInventory2.getTotalbalesOfMailUndeliverable()+Mail_Undeliverable2;

			Hogged_Books2=baleInventory2.getTotalbalesOfHoggedBooks()+Hogged_Books2;

			OCC2=baleInventory2.getTotalbalesOfOCC()+OCC2;

			DLK2=baleInventory2.getTotalbalesOfDLK()+DLK2;

			Mixed_Paper2=baleInventory2.getTotalbalesOfMixedPaper()+Mixed_Paper2;

			Soft_Wood_Chips2=baleInventory2.getTotalbalesOfSoftWoodChips()+Soft_Wood_Chips2;

			Hard_Wood_Chips2=baleInventory2.getTotalbalesOfHardWoodChips()+Hard_Wood_Chips2;

			PWE2=baleInventory2.getTotalbalesOfPWE()+PWE2;

			White_Broke2=baleInventory2.getTotalbalesOfWhiteBroke()+White_Broke2;

			Brown_Napkin_Broke2=baleInventory2.getTotalbalesOfBrownNapkinBroke()+Brown_Napkin_Broke2;

			PULP_Wet_Lap2=baleInventory2.getTotalbalesOfPULPWetLap()+PULP_Wet_Lap2;

			Virgin_Pulp2=baleInventory2.getTotalbalesOfVirginPulp()+Virgin_Pulp2;

			Brown_Wet_Lap2=baleInventory2.getTotalbalesOfBrownWetLap()+Brown_Wet_Lap2;

			Pulp_Dry_Lap2=baleInventory2.getTotalbalesOfPulpDryLap()+Pulp_Dry_Lap2;

			Other_Rolls2=baleInventory2.getTotalbalesOfOtherRolls()+Other_Rolls2;

			ST_Bales_wetlap2=baleInventory2.getTotalbalesOfSTBaleswetlap()+ST_Bales_wetlap2;

			STT_Baled_Broke_Butl2=baleInventory2.getTotalbalesOfSTTBaledBroke()+STT_Baled_Broke_Butl2;

			//
			Virgin_Hard_Wood2=baleInventory2.getTotalbalesOfVirginHardWood()+Virgin_Hard_Wood2;
			Virgin_Soft_Wood2=baleInventory2.getTotalbalesOfVirginSoftWood()+Virgin_Soft_Wood2;
			//

			_totalConsumedBales=MWL2+Prt_mix2+MCL2+MWL_W_IGS2+CBS2+Ctd_Gdwd2+SWL2+ONP2+OI_News2+Light_Prt_SBS2+
					HW2+Heavy_Prt_SBS2+SOW2+Unprt_SBS2+Newsblank2+White_Gdwd_Blend2+Mail_Undeliverable2+Hogged_Books2+OCC2+DLK2+Mixed_Paper2+
					Soft_Wood_Chips2+Hard_Wood_Chips2+PWE2+White_Broke2+Brown_Napkin_Broke2+PULP_Wet_Lap2+Virgin_Pulp2+Brown_Wet_Lap2+Pulp_Dry_Lap2+
					Other_Rolls2+ST_Bales_wetlap2+STT_Baled_Broke_Butl2+Virgin_Hard_Wood2+Virgin_Soft_Wood2;

			//Getter Setter For Weight

			MWLW2=baleInventory2.getTotalbalesweightForMWL()+MWLW2;

			Prt_mixW2=baleInventory2.getTotalbalesweightForPrtmix()+Prt_mixW2;

			MCLW2=baleInventory2.getTotalbalesweightForMCL()+MCLW2;

			MWL_W_IGSW2=baleInventory2.getTotalbalesweightForMWLWorIGS()+MWL_W_IGSW2;

			CBSW2=baleInventory2.getTotalbalesweightForCBS()+CBSW2;

			Ctd_GdwdW2=baleInventory2.getTotalbalesweightForCtdGdwd()+Ctd_GdwdW2;

			SWLW2=baleInventory2.getTotalbalesweightForSWL()+SWLW2;

			ONPW2=baleInventory2.getTotalbalesweightForONPOldNewsPrint()+ONPW2;

			OI_NewsW2=baleInventory2.getTotalbalesweightForOINews()+OI_NewsW2;

			Light_Prt_SBSW2=baleInventory2.getTotalbalesweightForLightPrtSBS()+Light_Prt_SBSW2;

			HWW2=baleInventory2.getTotalbalesweightForHW()+HWW2;

			Heavy_Prt_SBSW2=baleInventory2.getTotalbalesweightForHeavyPrtSBS()+Heavy_Prt_SBSW2;

			SOWW2=baleInventory2.getTotalbalesweightForSOW()+SOWW2;

			Unprt_SBSW2=baleInventory2.getTotalbalesweightForUnprtSBS()+Unprt_SBSW2;

			NewsblankW2=baleInventory2.getTotalbalesweightForNewsblank()+NewsblankW2;

			White_Gdwd_BlendW2=baleInventory2.getTotalbalesweightForWhiteGdwdBlend()+White_Gdwd_BlendW2;

			Mail_UndeliverableW2=baleInventory2.getTotalbalesweightForMailUndeliverable()+Mail_UndeliverableW2;

			Hogged_BooksW2=baleInventory2.getTotalbalesweightForHoggedBooks()+Hogged_BooksW2;

			OCCW2=baleInventory2.getTotalbalesweightForOCC()+OCCW2;

			DLKW2=baleInventory2.getTotalbalesweightForDLK()+DLKW2;

			Mixed_PaperW2=baleInventory2.getTotalbalesweightForMixedPaper()+Mixed_PaperW2;

			Soft_Wood_ChipsW2=baleInventory2.getTotalbalesweightForSoftWoodChips()+Soft_Wood_ChipsW2;

			Hard_Wood_ChipsW2=baleInventory2.getTotalbalesweightForHardWoodChips()+Hard_Wood_ChipsW2;

			PWEW2=baleInventory2.getTotalbalesweightForPWE()+PWEW2;

			White_BrokeW2=baleInventory2.getTotalbalesweightForWhiteBroke()+White_BrokeW2;

			Brown_Napkin_BrokeW2=baleInventory2.getTotalbalesweightForBrownNapkinBroke()+Brown_Napkin_BrokeW2;

			PULP_Wet_LapW2=baleInventory2.getTotalbalesweightForPULPWetLap()+PULP_Wet_LapW2;

			Virgin_PulpW2=baleInventory2.getTotalbalesweightForVirginPulp()+Virgin_PulpW2;

			Brown_Wet_LapW2=baleInventory2.getTotalbalesweightForBrownWetLap()+Brown_Wet_LapW2;

			Pulp_Dry_LapW2=baleInventory2.getTotalbalesweightForPulpDryLap()+Pulp_Dry_LapW2;

			Other_RollsW2=baleInventory2.getTotalbalesweightForOtherRolls()+Other_RollsW2;

			ST_Bales_wetlapW2=baleInventory2.getTotalbalesweightForSTBaleswetlap()+ST_Bales_wetlapW2;

			STT_Baled_Broke_ButlW2=baleInventory2.getTotalbalesweightForSTTBaledBroke()+STT_Baled_Broke_ButlW2;


			//
			Virgin_Hard_WoodW2=baleInventory2.getTotalbalesweightForVirginHardWood()+Virgin_Hard_WoodW2;
			Virgin_Soft_WoodW2=baleInventory2.getTotalbalesweightForVirginSoftWood()+Virgin_Soft_WoodW2;
			//

			_totalConsumedBalesWeight=MWLW2+Prt_mixW2+MCLW2+MWL_W_IGSW2+CBSW2+Ctd_GdwdW2+SWLW2+ONPW2+OI_NewsW2+Light_Prt_SBSW2+HWW2+Heavy_Prt_SBSW2+SOWW2+
					Unprt_SBSW2+NewsblankW2+White_Gdwd_BlendW2+Mail_UndeliverableW2+Hogged_BooksW2+OCCW2+DLKW2+Mixed_PaperW2+
					Soft_Wood_ChipsW2+Hard_Wood_ChipsW2+PWEW2+White_BrokeW2+Brown_Napkin_BrokeW2+PULP_Wet_LapW2+Virgin_PulpW2+
					Brown_Wet_LapW2+Pulp_Dry_LapW2+Other_RollsW2+ST_Bales_wetlapW2+STT_Baled_Broke_ButlW2+Virgin_Hard_WoodW2+Virgin_Soft_WoodW2;

		}
		int row=1;
		int col=0;
		util.addValue(row,col,"WASTE PAPER BALE INVENTORY REPORT- "+dateFormat1.format(startdate)+" 7 A.M.",Workbook2007Util.Style.STYLE_HEADER_01, (short)400);
		util.mergeCell(row, row, 0, 20);

		row++;
		col=0;
		util.addValue(row,col++,"ST. GRADES",Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(row,col++,"MWL",Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(row,col++,"Prt mix",Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(row,col++,"MCL",Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(row,col++,"MWL W/IGS",Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(row,col++,"CBS",Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(row,col++,"Ctd Gdwd",Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(row,col++,"SWL",Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(row,col++,"ONP",Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(row,col++,"OI News",Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(row,col++,"Light Prt SBS	",Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);

		util.addValue(row,col++,"HW",Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(row,col++,"Heavy Prt SBS	",Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(row,col++,"SOW",Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(row,col++,"Unprt SBS",Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(row,col++,"Newsblank",Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(row,col++,"White Gdwd Blend",Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(row,col++,"Mail-Undeliverable",Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(row,col++,"Hogged Books",Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(row,col++,"OCC",Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(row,col++,"DLK",Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);

		util.addValue(row,col++,"Mixed Paper",Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(row,col++,"Soft Wood Chips",Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(row,col++,"Hard Wood Chips",Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(row,col++,"PWE",Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(row,col++,"White Broke",Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(row,col++,"Brown Napkin Broke",Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(row,col++,"PULP Wet Lap",Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(row,col++,"Virgin Pulp",Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(row,col++,"Pulp Dry Lap",Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(row,col++,"Other-Rolls",Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);

		util.addValue(row,col++,"STT Baled Broke-Butl",Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(row,col++,"STT-WetLAp Bales PM6-Brown",Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(row,col++,"STT-Wetlap Bales PM6-White",Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(row,col++,"ST Wetlap Bales FRP-White",Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(row,col++,"ST Wetlap Bales FRP-Brown",Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(row,col++,"Virgin Hard Wood",Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(row,col++,"Virgin Soft Wood",Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(row,col++,"Total",Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);

		row++;
		col=0;

		for(final BarcodeComman barcode:openingMonth){
			col=0;	
			//Setter Getter For Bales
			prtmix_om=barcode.getPrtmix();

			mwl_om=barcode.getMwl();

			mcl_om=barcode.getMcl();

			mwlwigs_om=barcode.getMwlwigs();

			cbs_om =barcode.getCbs();

			ctdGdwd_om =barcode.getCtdGdwd();

			swlsortedwhite_om=barcode.getSwlsortedwhite();


			onpolnNewsprint_om=barcode.getOnpolnNewsprint();


			oinews_om =barcode.getOinews();

			lightprtsbs_om  =barcode.getLightprtsbs();

			hw_om =barcode.getHw();

			heavyprtsbs_om =barcode.getHeavyprtsbs();

			sow_om=barcode.getSow();

			unprtsbs_om=barcode.getUnprtsbs();

			newsblank_om = barcode.getNewsblank();

			whitegdwdblend_om=barcode.getWhitegdwdblend();

			mailundeliverable_om=barcode.getMailundeliverable();   

			hoggedbooks_om=barcode.getHoggedbooks();    

			occ_om =barcode.getOcc();     

			dlk_om= barcode.getDlk();    

			mixedpaper_om=barcode.getMixedpaper();

			softwoodchips_om=barcode.getSoftwoodchips();     

			hardwoodchips_om=barcode.getHardwoodchips();      

			whitebroke_om =barcode.getWhitebroke();     

			pwe_om=barcode.getPwe();      

			brownnapkinbroke_om =barcode.getBrownnapkinbroke();     

			pulpwetlap_om=barcode.getPulpwetlap();      

			virginpulp_om =barcode.getVirginpulp();

			brownwetLap_om = barcode.getBrownwetLap();    

			pulpdryLap_om = barcode.getPulpdryLap();    

			otherrolls_om  = barcode.getOtherrolls(); 

			stbaleswetlap_om= barcode.getStbaleswetlap();    

			sttbaledbrokebutl_om=barcode.getSttbaledbrokebutl();

			//
			virginhardwood_om=barcode.getVirginhardwood();
			virginsoftwood_om=barcode.getVirginsoftwood();
			//

			//Setter Getter For Bales Weight

			prtmix_weight_om=barcode.getPrtmixw();

			mwl_weight_om=barcode.getMwlw();

			mcl_weight_om=barcode.getMclw();

			mwlwigs_weight_om=barcode.getMwlwigsw();

			cbs_weight_om =barcode.getCbsw();

			ctdGdwd_weight_om=barcode.getCtdGdwdw();

			swlsortedwhite_weight_om=barcode.getSwlsortedwhitew();

			onpolnNewsprint_weight_om=barcode.getOnpolnNewsprintw();

			oinews_weight_om=barcode.getOinewsw();

			lightprtsbs_weight_om =barcode.getLightprtsbsw(); 

			hw_weight_om=barcode.getHww();

			heavyprtsbs_weight_om=barcode.getHeavyprtsbsw();

			sow_weight_om=barcode.getSoww();

			unprtsbs_weight_om=barcode.getUnprtsbsw();

			newsblank_weight_om=barcode.getNewsblankw();

			whitegdwdblend_weight_om=barcode.getWhitegdwdblendw();

			mailundeliverable_weight_om=barcode.getMailundeliverablew();

			hoggedbooks_weight_om=barcode.getHoggedbooksw();

			occ_weight_om=barcode.getOccw();

			dlk_weight_om=barcode.getDlkw();

			mixedpaper_weight_om=barcode.getMixedpaperw();

			softwoodchips_weight_om=barcode.getSoftwoodchipsw();

			hardwoodchips_weight_om=barcode.getHardwoodchipsw();

			whitebroke_weight_om=barcode.getWhitebrokew();

			pwe_weight_om=barcode.getPwew();

			brownnapkinbroke_weight_om =barcode.getBrownnapkinbrokew();

			pulpwetlap_weight_om=barcode.getPulpwetlapw();

			virginpulp_weight_om =barcode.getVirginpulpw();

			brownwetLap_weight_om=barcode.getBrownwetLapw();

			otherrolls_weight_om =barcode.getOtherrollsw();

			stbaleswetlap_weight_om=barcode.getStbaleswetlapw();

			sttbaledbrokebutl_weight_om=barcode.getSttbaledbrokebutlw();

			pulpdryLap_weight_om =barcode.getPulpdryLapw();

			//
			virginhardwood_weight_om =barcode.getVirginhardwoodw();
			virginsoftwood_weight_om =barcode.getVirginsoftwoodw();
			//


			int value1=(mwl_om+MWL1)-(MWL2);
			int value2=(prtmix_om+Prt_mix1)-(Prt_mix2);
			int value3=(mcl_om+MCL1)-(MCL2);
			int value4=(mwlwigs_om+MWL_W_IGS1)-(MWL_W_IGS2);
			int value5=(cbs_om+CBS1)-(CBS2);
			int value6=(ctdGdwd_om+Ctd_Gdwd1)-(Ctd_Gdwd2);
			int value7=(swlsortedwhite_om+SWL1)-(SWL2);
			int value8=(onpolnNewsprint_om+ONP1)-(ONP2);
			int value9=(oinews_om+OI_News1)-(OI_News2);
			int value10=(lightprtsbs_om+Light_Prt_SBS1)-(Light_Prt_SBS2);
			int value11=(hw_om+HW1)-(HW2);
			int value12=(heavyprtsbs_om+Heavy_Prt_SBS1)-(Heavy_Prt_SBS2);
			int value13=(sow_om+SOW1)-(SOW2);
			int value14=(unprtsbs_om+Unprt_SBS1)-Unprt_SBS2;
			int value15=(newsblank_om+Newsblank1)-Newsblank2;
			int value16=(whitegdwdblend_om+White_Gdwd_Blend1)-White_Gdwd_Blend2;
			int value17=(mailundeliverable_om+Mail_Undeliverable1)-Mail_Undeliverable2;
			int value18=(hoggedbooks_om+Hogged_Books1)-Hogged_Books2;
			int value19=(occ_om+OCC1)-OCC2;
			int value20=(dlk_om+DLK1)-DLK2;
			int value21=(mixedpaper_om+Mixed_Paper1)-Mixed_Paper2;
			int value22=(softwoodchips_om+Soft_Wood_Chips1)-Soft_Wood_Chips2;
			int value23=(hardwoodchips_om+Hard_Wood_Chips1)-Hard_Wood_Chips2;
			int value24=(pwe_om+PWE1)-PWE2;
			int value25=(whitebroke_om+White_Broke1)-White_Broke2;
			int value26=(brownnapkinbroke_om+Brown_Napkin_Broke1)-Brown_Napkin_Broke2;
			int value27=(pulpwetlap_om+PULP_Wet_Lap1)-PULP_Wet_Lap2;
			int value28=(virginpulp_om+Virgin_Pulp1)-Virgin_Pulp2;
			int value29=(brownwetLap_om+Brown_Wet_Lap1)-Brown_Wet_Lap2;
			int value30=(pulpdryLap_om+Pulp_Dry_Lap1)-Pulp_Dry_Lap2;
			int value31=(otherrolls_om+Other_Rolls1)-Other_Rolls2;
			int value32=(stbaleswetlap_om+ST_Bales_wetlap1)-ST_Bales_wetlap2;
			int value33=(sttbaledbrokebutl_om+STT_Baled_Broke_Butl1)-STT_Baled_Broke_Butl2;

			//
			int value67=(virginhardwood_om+Virgin_Hard_Wood1)-Virgin_Hard_Wood2;
			int value68=(virginsoftwood_om+Virgin_Soft_Wood1)-Virgin_Soft_Wood2;
			//

			int totalBales=value1+value2+value3+value4+value5+value6+value7+value8+value9+value10+
					value11+value12+value13+value14+value15+value16+value17+value18+value19+value20+
					value21+value22+value23+value24+value25+value26+value27+value28+value29+value30+
					value31+value32+value33+bales_white+bales_Brown+value67+value68;

			double value34=(CommonUtil.round(mwl_weight_om, 2)+CommonUtil.round(MWLW1, 2))-(CommonUtil.round(MWLW2, 2));
			double value35=(CommonUtil.round(prtmix_weight_om, 2)+CommonUtil.round(Prt_mixW1, 2))-(CommonUtil.round(Prt_mixW2, 2));
			double value36=(CommonUtil.round(mcl_weight_om, 2)+CommonUtil.round(MCLW1, 2))-(CommonUtil.round(MCLW2, 2));
			double value37=(CommonUtil.round(mwlwigs_weight_om, 2)+CommonUtil.round(MWL_W_IGSW1, 2))-(CommonUtil.round(MWL_W_IGSW2, 2));
			double value38=(CommonUtil.round(cbs_weight_om, 2)+CommonUtil.round(CBSW1, 2))-(CommonUtil.round(CBSW2, 2));
			double value39=(CommonUtil.round(ctdGdwd_weight_om, 2)+CommonUtil.round(Ctd_GdwdW1, 2))-(CommonUtil.round(Ctd_GdwdW2, 2));
			double value40=(CommonUtil.round(swlsortedwhite_weight_om, 2)+CommonUtil.round(SWLW1, 2))-(CommonUtil.round(SWLW2, 2));
			double value41=(CommonUtil.round(onpolnNewsprint_weight_om, 2)+CommonUtil.round(ONPW1, 2))-(CommonUtil.round(ONPW2, 2));
			double value42=(CommonUtil.round(oinews_weight_om, 2)+CommonUtil.round(OI_NewsW1, 2))-(CommonUtil.round(OI_NewsW2, 2));
			double value43=(CommonUtil.round(lightprtsbs_weight_om, 2)+CommonUtil.round(Light_Prt_SBSW1, 2))-(CommonUtil.round(Light_Prt_SBSW2, 2));
			double value44=(CommonUtil.round(hw_weight_om, 2)+CommonUtil.round(HWW1, 2))-(CommonUtil.round(HWW2, 2));
			double value45=(CommonUtil.round(heavyprtsbs_weight_om, 2)+CommonUtil.round(Heavy_Prt_SBSW1, 2))-(CommonUtil.round(Heavy_Prt_SBSW2, 2));
			double value46=(CommonUtil.round(sow_weight_om, 2)+CommonUtil.round(SOWW1, 2))-(CommonUtil.round(SOWW2, 2));
			double value47=(CommonUtil.round(unprtsbs_weight_om, 2)+CommonUtil.round(Unprt_SBSW1, 2))-CommonUtil.round(Unprt_SBSW2, 2);
			double value48=(CommonUtil.round(newsblank_weight_om, 2)+CommonUtil.round(NewsblankW1, 2))-CommonUtil.round(NewsblankW2, 2);
			double value49=(CommonUtil.round(whitegdwdblend_weight_om, 2)+CommonUtil.round(White_Gdwd_BlendW1, 2))-CommonUtil.round(White_Gdwd_BlendW2, 2);
			double value50=(CommonUtil.round(mailundeliverable_weight_om, 2)+CommonUtil.round(Mail_UndeliverableW1, 2))-CommonUtil.round(Mail_UndeliverableW2, 2);
			double value51=(CommonUtil.round(hoggedbooks_weight_om, 2)+CommonUtil.round(Hogged_BooksW1, 2))-CommonUtil.round(Hogged_BooksW2, 2);
			double value52=(CommonUtil.round(occ_weight_om, 2)+CommonUtil.round(OCCW1, 2))-CommonUtil.round(OCCW2, 2);
			double value53=(CommonUtil.round(dlk_weight_om, 2)+CommonUtil.round(DLKW1, 2))-CommonUtil.round(DLKW2, 2);
			double value54=(CommonUtil.round(mixedpaper_weight_om, 2)+CommonUtil.round(Mixed_PaperW1, 2))-CommonUtil.round(Mixed_PaperW2, 2);
			double value55=(CommonUtil.round(softwoodchips_weight_om, 2)+CommonUtil.round(Soft_Wood_ChipsW1, 2))-CommonUtil.round(Soft_Wood_ChipsW2, 2);
			double value56=(CommonUtil.round(hardwoodchips_weight_om, 2)+CommonUtil.round(Hard_Wood_ChipsW1, 2))-CommonUtil.round(Hard_Wood_ChipsW2, 2);
			double value57=(CommonUtil.round(pwe_weight_om, 2)+CommonUtil.round(PWEW1, 2))-CommonUtil.round(PWEW2, 2);
			double value58=(CommonUtil.round(whitebroke_weight_om, 2)+CommonUtil.round(White_BrokeW1, 2))-CommonUtil.round(White_BrokeW2, 2);
			double value59=(CommonUtil.round(brownnapkinbroke_weight_om, 2)+CommonUtil.round(Brown_Napkin_BrokeW1, 2))-CommonUtil.round(Brown_Napkin_BrokeW2, 2);
			double value60=(CommonUtil.round(pulpwetlap_weight_om, 2)+CommonUtil.round(PULP_Wet_LapW1, 2))-CommonUtil.round(PULP_Wet_LapW2, 2);
			double value61=(CommonUtil.round(virginpulp_weight_om, 2)+CommonUtil.round(Virgin_PulpW1, 2))-CommonUtil.round(Virgin_PulpW2, 2);
			double value62=(CommonUtil.round(brownwetLap_weight_om, 2)+CommonUtil.round(Brown_Wet_LapW1, 2))-CommonUtil.round(Brown_Wet_LapW2, 2);
			double value63=(CommonUtil.round(pulpdryLap_weight_om, 2)+CommonUtil.round(Pulp_Dry_LapW1, 2))-CommonUtil.round(Pulp_Dry_LapW2, 2);
			double value64=(CommonUtil.round(otherrolls_weight_om, 2)+CommonUtil.round(Other_RollsW1, 2))-CommonUtil.round(Other_RollsW2, 2);
			double value65=(CommonUtil.round(stbaleswetlap_weight_om, 2)+CommonUtil.round(ST_Bales_wetlapW1, 2))-CommonUtil.round(ST_Bales_wetlapW2, 2);
			double value66=(CommonUtil.round(sttbaledbrokebutl_weight_om, 2)+CommonUtil.round(STT_Baled_Broke_ButlW1, 2))-CommonUtil.round(STT_Baled_Broke_ButlW2, 2);

			//
			double value69=(CommonUtil.round(virginhardwood_weight_om, 2)+CommonUtil.round(Virgin_Hard_WoodW1, 2))-CommonUtil.round(Virgin_Hard_WoodW2, 2);
			double value70=(CommonUtil.round(virginsoftwood_weight_om, 2)+CommonUtil.round(Virgin_Soft_WoodW1, 2))-CommonUtil.round(Virgin_Soft_WoodW2, 2);
			//
			double _final_ivt_total_weight=(CommonUtil.round(total_Tonnage, 2)+CommonUtil.round(_totalUnloadBalesWeight, 2))-(CommonUtil.round(_totalConsumedBalesWeight, 2));


			util.addValue(row, col++,"Total Bales",Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);

			util.addValue(row, col++,CommonUtil.round(value1, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++,CommonUtil.round(value2, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++,CommonUtil.round(value3, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++,CommonUtil.round(value4, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++,CommonUtil.round(value5, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++,CommonUtil.round(value6, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++,CommonUtil.round(value7, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++,CommonUtil.round(value8, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++,CommonUtil.round(value9, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++,CommonUtil.round(value10, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++,CommonUtil.round(value11, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++,CommonUtil.round(value12, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++,CommonUtil.round(value13, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++,CommonUtil.round(value14, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++,CommonUtil.round(value15, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++,CommonUtil.round(value16, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++,CommonUtil.round(value17, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++,CommonUtil.round(value18, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++,CommonUtil.round(value19, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++,CommonUtil.round(value20, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++,CommonUtil.round(value21, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++,CommonUtil.round(value22, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++,CommonUtil.round(value23, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++,CommonUtil.round(value24, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++,CommonUtil.round(value25, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++,CommonUtil.round(value26, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++,CommonUtil.round(value27, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++,CommonUtil.round(value28, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);

			util.addValue(row, col++,CommonUtil.round(value30, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);//
			util.addValue(row, col++,CommonUtil.round(value31, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++,CommonUtil.round(value33, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++,CommonUtil.round(value29, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++,CommonUtil.round(value32, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);

			util.addValue(row, col++,CommonUtil.round(bales_white, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++,CommonUtil.round(bales_Brown, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);

			//
			util.addValue(row, col++,CommonUtil.round(value67, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++,CommonUtil.round(value68, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			//

			util.addValue(row, col++,CommonUtil.round(totalBales, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			row++;

			//Setter Getter For Bales Weight
			col=0;
			util.addValue(row, col++,"Total Tonnage",Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);

			mwl_weight_om=barcode.getMwlw();
			util.addValue(row, col++,CommonUtil.round(value34, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);


			prtmix_weight_om=barcode.getPrtmixw();
			util.addValue(row, col++,CommonUtil.round(value35, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);

			mcl_weight_om=barcode.getMclw();
			util.addValue(row, col++,CommonUtil.round(value36, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);

			mwlwigs_weight_om=barcode.getMwlwigsw();
			util.addValue(row, col++,CommonUtil.round(value37, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);

			cbs_weight_om =barcode.getCbsw();
			util.addValue(row, col++,CommonUtil.round(value38, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);

			ctdGdwd_weight_om=barcode.getCtdGdwdw();
			util.addValue(row, col++,CommonUtil.round(value39, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);

			swlsortedwhite_weight_om=barcode.getSwlsortedwhitew();
			util.addValue(row, col++,CommonUtil.round(value40, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);

			onpolnNewsprint_weight_om=barcode.getOnpolnNewsprintw();
			util.addValue(row, col++,CommonUtil.round(value41, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);

			oinews_weight_om=barcode.getOinewsw();
			util.addValue(row, col++,CommonUtil.round(value42, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);

			lightprtsbs_weight_om =barcode.getLightprtsbsw(); 
			util.addValue(row, col++,CommonUtil.round(value43, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);

			hw_weight_om=barcode.getHww();
			util.addValue(row, col++,CommonUtil.round(value44, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);

			heavyprtsbs_weight_om=barcode.getHeavyprtsbsw();
			util.addValue(row, col++,CommonUtil.round(value45, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);

			sow_weight_om=barcode.getSoww();
			util.addValue(row, col++,CommonUtil.round(value46, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);

			unprtsbs_weight_om=barcode.getUnprtsbsw();
			util.addValue(row, col++,CommonUtil.round(value47, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);

			newsblank_weight_om=barcode.getNewsblankw();
			util.addValue(row, col++,CommonUtil.round(value48, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);

			whitegdwdblend_weight_om=barcode.getWhitegdwdblendw();
			util.addValue(row, col++,CommonUtil.round(value49, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);

			mailundeliverable_weight_om=barcode.getMailundeliverablew();
			util.addValue(row, col++,CommonUtil.round(value50, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);

			hoggedbooks_weight_om=barcode.getHoggedbooksw();
			util.addValue(row, col++,CommonUtil.round(value51, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);

			occ_weight_om=barcode.getOccw();
			util.addValue(row, col++,CommonUtil.round(value52, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);

			dlk_weight_om=barcode.getDlkw();
			util.addValue(row, col++,CommonUtil.round(value53, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);

			mixedpaper_weight_om=barcode.getMixedpaperw();
			util.addValue(row, col++,CommonUtil.round(value54, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);

			softwoodchips_weight_om=barcode.getSoftwoodchipsw();
			util.addValue(row, col++,CommonUtil.round(value55, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);

			hardwoodchips_weight_om=barcode.getHardwoodchipsw();
			util.addValue(row, col++,CommonUtil.round(value56, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);

			pwe_weight_om=barcode.getPwew();
			util.addValue(row, col++,CommonUtil.round(value57, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);

			whitebroke_weight_om=barcode.getWhitebrokew();
			util.addValue(row, col++,CommonUtil.round(value58, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);

			brownnapkinbroke_weight_om =barcode.getBrownnapkinbrokew();
			util.addValue(row, col++,CommonUtil.round(value59, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);

			pulpwetlap_weight_om=barcode.getPulpwetlapw();
			util.addValue(row, col++,CommonUtil.round(value60, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			//28
			virginpulp_weight_om =barcode.getVirginpulpw();
			util.addValue(row, col++,CommonUtil.round(value61, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			//33
			pulpdryLap_weight_om =barcode.getPulpdryLapw();
			util.addValue(row, col++,CommonUtil.round(value63, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			//30
			otherrolls_weight_om =barcode.getOtherrollsw();
			util.addValue(row, col++,CommonUtil.round(value64, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			//32
			sttbaledbrokebutl_weight_om=barcode.getSttbaledbrokebutlw();
			util.addValue(row, col++,CommonUtil.round(value66, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);

			//29
			brownwetLap_weight_om=barcode.getBrownwetLapw();
			util.addValue(row, col++,CommonUtil.round(value62, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			//31
			stbaleswetlap_weight_om=barcode.getStbaleswetlapw();
			util.addValue(row, col++,CommonUtil.round(value65, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);


			//
			virginhardwood_weight_om=barcode.getVirginhardwoodw();
			virginsoftwood_weight_om=barcode.getVirginsoftwoodw();
			//

			total_Tonnage=prtmix_weight_om+mwl_weight_om+mcl_weight_om+mwlwigs_weight_om + cbs_weight_om +ctdGdwd_weight_om+
					swlsortedwhite_weight_om+onpolnNewsprint_weight_om+oinews_weight_om+lightprtsbs_weight_om + hw_weight_om+
					heavyprtsbs_weight_om+sow_weight_om+unprtsbs_weight_om+newsblank_weight_om+whitegdwdblend_weight_om+
					mailundeliverable_weight_om+hoggedbooks_weight_om+occ_weight_om+dlk_weight_om+mixedpaper_weight_om+
					softwoodchips_weight_om+hardwoodchips_weight_om+whitebroke_weight_om+pwe_weight_om+brownnapkinbroke_weight_om +
					pulpwetlap_weight_om+virginpulp_weight_om +brownwetLap_weight_om+otherrolls_weight_om +stbaleswetlap_weight_om+
					sttbaledbrokebutl_weight_om+pulpdryLap_weight_om+baleWeight_white+baleWeight_brown+virginhardwood_weight_om+virginsoftwood_weight_om;

			System.out.println("total_Tonnage::"+total_Tonnage);
			util.addValue(row, col++,CommonUtil.round(baleWeight_white, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++,CommonUtil.round(baleWeight_brown, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);

			//
			util.addValue(row, col++,CommonUtil.round(value69, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++,CommonUtil.round(value70, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			//


			_final_ivt_total_weight=(CommonUtil.round(total_Tonnage, 2)+CommonUtil.round(_totalUnloadBalesWeight, 2))-(CommonUtil.round(_totalConsumedBalesWeight, 2));
			util.addValue(row, col++,CommonUtil.round(_final_ivt_total_weight, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);

		}
		row++;
		for(final WastePaperBaleInventory cBDOD: consumedBalesDataOfOneDay){
			col=0;
			//Setter Getter For Bales

			util.addValue(row, col++,"Total No.Bales Consumed "+dateFormat.format(yesterdayDate),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);

			MWLcbos=cBDOD.getTotalbalesOfMWL();
			util.addValue(row, col++,CommonUtil.round(MWLcbos, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);

			Prt_mixcbos=cBDOD.getTotalbalesOfPrtmix();
			util.addValue(row, col++,CommonUtil.round(Prt_mixcbos, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);

			MCLcbos=cBDOD.getTotalbalesOfMCL();
			util.addValue(row, col++,CommonUtil.round(MCLcbos, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);

			MWL_W_IGScbos=cBDOD.getTotalbalesOfMWLWorIGS();
			util.addValue(row, col++,CommonUtil.round(MWL_W_IGScbos, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);

			CBScbos=cBDOD.getTotalbalesOfCBS();
			util.addValue(row, col++,CommonUtil.round(CBScbos, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);

			Ctd_Gdwdcbos=cBDOD.getTotalbalesOfCtdGdwd();
			util.addValue(row, col++,CommonUtil.round(Ctd_Gdwdcbos, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);

			SWLcbos=cBDOD.getTotalbalesOfSWL();
			util.addValue(row, col++,CommonUtil.round(SWLcbos, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);

			ONPcbos=cBDOD.getTotalbalesOfONPOldNewsPrint();
			util.addValue(row, col++,CommonUtil.round(ONPcbos, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);

			OI_Newscbos=cBDOD.getTotalbalesOfOINews();
			util.addValue(row, col++,CommonUtil.round(OI_Newscbos, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);

			Light_Prt_SBScbos=cBDOD.getTotalbalesOfLightPrtSBS();
			util.addValue(row, col++,CommonUtil.round(Light_Prt_SBScbos, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);

			HWcbos=cBDOD.getTotalbalesOfHW();
			util.addValue(row, col++,CommonUtil.round(HWcbos, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);

			Heavy_Prt_SBScbos=cBDOD.getTotalbalesOfHeavyPrtSBS();
			util.addValue(row, col++,CommonUtil.round(Heavy_Prt_SBScbos, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);

			SOWcbos=cBDOD.getTotalbalesOfSOW();
			util.addValue(row, col++,CommonUtil.round(SOWcbos, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);

			Unprt_SBScbos=cBDOD.getTotalbalesOfUnprtSBS();
			util.addValue(row, col++,CommonUtil.round(Unprt_SBScbos, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);

			Newsblankcbos=cBDOD.getTotalbalesOfNewsblank();
			util.addValue(row, col++,CommonUtil.round(Newsblankcbos, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);

			White_Gdwd_Blendcbos=cBDOD.getTotalbalesOfWhiteGdwdBlend();
			util.addValue(row, col++,CommonUtil.round(White_Gdwd_Blendcbos, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);

			Mail_Undeliverablecbos=cBDOD.getTotalbalesOfMailUndeliverable();
			util.addValue(row, col++,CommonUtil.round(Mail_Undeliverablecbos, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);

			Hogged_Bookscbos=cBDOD.getTotalbalesOfHoggedBooks();
			util.addValue(row, col++,CommonUtil.round(Hogged_Bookscbos, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);

			OCCcbos=cBDOD.getTotalbalesOfOCC();
			util.addValue(row, col++,CommonUtil.round(OCCcbos, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);

			DLKcbos=cBDOD.getTotalbalesOfDLK();
			util.addValue(row, col++,CommonUtil.round(DLKcbos, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);

			Mixed_Papercbos=cBDOD.getTotalbalesOfMixedPaper();
			util.addValue(row, col++,CommonUtil.round(Mixed_Papercbos, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);

			Soft_Wood_Chipscbos=cBDOD.getTotalbalesOfSoftWoodChips();
			util.addValue(row, col++,CommonUtil.round(Soft_Wood_Chipscbos, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);

			Hard_Wood_Chipscbos=cBDOD.getTotalbalesOfHardWoodChips();
			util.addValue(row, col++,CommonUtil.round(Hard_Wood_Chipscbos, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);

			PWEcbos=cBDOD.getTotalbalesOfPWE();
			util.addValue(row, col++,CommonUtil.round(PWEcbos, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);

			White_Brokecbos=cBDOD.getTotalbalesOfWhiteBroke();
			util.addValue(row, col++,CommonUtil.round(White_Brokecbos, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);

			Brown_Napkin_Brokecbos=cBDOD.getTotalbalesOfBrownNapkinBroke();
			util.addValue(row, col++,CommonUtil.round(Brown_Napkin_Brokecbos, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);

			PULP_Wet_Lapcbos=cBDOD.getTotalbalesOfPULPWetLap();
			util.addValue(row, col++,CommonUtil.round(PULP_Wet_Lapcbos, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);

			Virgin_Pulpcbos=cBDOD.getTotalbalesOfVirginPulp();
			util.addValue(row, col++,CommonUtil.round(Virgin_Pulpcbos, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);

			//Change Here If Have any issue Regarding Sequence 	
			Pulp_Dry_Lapcbos=cBDOD.getTotalbalesOfPulpDryLap();
			util.addValue(row, col++,CommonUtil.round(Pulp_Dry_Lapcbos, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);

			Other_Rollscbos=cBDOD.getTotalbalesOfOtherRolls();
			util.addValue(row, col++,CommonUtil.round(Other_Rollscbos, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);

			STT_Baled_Broke_Butlcbos=cBDOD.getTotalbalesOfSTTBaledBroke();
			util.addValue(row, col++,CommonUtil.round(STT_Baled_Broke_Butlcbos, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);

			Brown_Wet_Lapcbos=cBDOD.getTotalbalesOfBrownWetLap();
			util.addValue(row, col++,CommonUtil.round(Brown_Wet_Lapcbos, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);

			ST_Bales_wetlapcbos=cBDOD.getTotalbalesOfSTBaleswetlap();
			util.addValue(row, col++,CommonUtil.round(ST_Bales_wetlapcbos, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);

			//
			VirginSoftWoodcbos=cBDOD.getTotalbalesOfVirginSoftWood();
			VirginHardWoodcbos=cBDOD.getTotalbalesOfVirginHardWood();

			//
			total_cbod_bales=MWLcbos+Prt_mixcbos+MCLcbos+MWL_W_IGScbos+CBScbos+Ctd_Gdwdcbos+SWLcbos+ONPcbos+OI_Newscbos+
					Light_Prt_SBScbos+HWcbos+Heavy_Prt_SBScbos+SOWcbos+Unprt_SBScbos+Newsblankcbos+White_Gdwd_Blendcbos+
					Mail_Undeliverablecbos+Hogged_Bookscbos+OCCcbos+DLKcbos+Mixed_Papercbos+Soft_Wood_Chipscbos+
					Hard_Wood_Chipscbos+PWEcbos+White_Brokecbos+Brown_Napkin_Brokecbos+PULP_Wet_Lapcbos+
					Virgin_Pulpcbos+Brown_Wet_Lapcbos+Pulp_Dry_Lapcbos+Other_Rollscbos+ST_Bales_wetlapcbos+
					STT_Baled_Broke_Butlcbos+VirginHardWoodcbos+VirginSoftWoodcbos;

			util.addValue(row, col++,"",Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++,"",Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);

			//
			util.addValue(row, col++,CommonUtil.round(VirginHardWoodcbos, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++,CommonUtil.round(VirginSoftWoodcbos, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			//
			util.addValue(row, col++,CommonUtil.round(total_cbod_bales, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight); 

			row++;
			col=0; 

			//Setter Getter For Weight

			util.addValue(row, col++,"Consumed Tonnage",Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);

			MWLcbos_Weight=cBDOD.getTotalbalesweightForMWL();
			util.addValue(row, col++,CommonUtil.round(MWLcbos_Weight, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight); 

			Prt_mixcbos_Weight=cBDOD.getTotalbalesweightForPrtmix();
			util.addValue(row, col++,CommonUtil.round(Prt_mixcbos_Weight, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight); 

			MCLcbos_Weight=cBDOD.getTotalbalesweightForMCL();
			util.addValue(row, col++,CommonUtil.round(MCLcbos_Weight, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight); 

			MWL_W_IGScbos_Weight=cBDOD.getTotalbalesweightForMWLWorIGS();
			util.addValue(row, col++,CommonUtil.round(MWL_W_IGScbos_Weight, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight); 

			CBScbos_Weight=cBDOD.getTotalbalesweightForCBS();
			util.addValue(row, col++,CommonUtil.round(CBScbos_Weight, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight); 

			Ctd_Gdwdcbos_Weight=cBDOD.getTotalbalesweightForCtdGdwd();
			util.addValue(row, col++,CommonUtil.round(Ctd_Gdwdcbos_Weight, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight); 

			SWLcbos_Weight=cBDOD.getTotalbalesweightForSWL();
			util.addValue(row, col++,CommonUtil.round(SWLcbos_Weight, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight); 

			ONPcbos_Weight=cBDOD.getTotalbalesweightForONPOldNewsPrint();
			util.addValue(row, col++,CommonUtil.round(ONPcbos_Weight, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight); 

			OI_Newscbos_Weight=cBDOD.getTotalbalesweightForOINews();
			util.addValue(row, col++,CommonUtil.round(OI_Newscbos_Weight, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight); 

			Light_Prt_SBScbos_Weight=cBDOD.getTotalbalesweightForLightPrtSBS();
			util.addValue(row, col++,CommonUtil.round(Light_Prt_SBScbos_Weight, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight); 

			HWcbos_Weight=cBDOD.getTotalbalesweightForHW();
			util.addValue(row, col++,CommonUtil.round(HWcbos_Weight, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight); 

			Heavy_Prt_SBScbos_Weight=cBDOD.getTotalbalesweightForHeavyPrtSBS();
			util.addValue(row, col++,CommonUtil.round(Heavy_Prt_SBScbos_Weight, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight); 

			SOWcbos_Weight=cBDOD.getTotalbalesweightForSOW();
			util.addValue(row, col++,CommonUtil.round(SOWcbos_Weight, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight); 

			Unprt_SBScbos_Weight=cBDOD.getTotalbalesweightForUnprtSBS();
			util.addValue(row, col++,CommonUtil.round(Unprt_SBScbos_Weight, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight); 

			Newsblankcbos_Weight=cBDOD.getTotalbalesweightForNewsblank();
			util.addValue(row, col++,CommonUtil.round(Newsblankcbos_Weight, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight); 

			White_Gdwd_Blendcbos_Weight=cBDOD.getTotalbalesweightForWhiteGdwdBlend();
			util.addValue(row, col++,CommonUtil.round(White_Gdwd_Blendcbos_Weight, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight); 

			Mail_Undeliverablecbos_Weight=cBDOD.getTotalbalesweightForMailUndeliverable();
			util.addValue(row, col++,CommonUtil.round(Mail_Undeliverablecbos_Weight, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight); 

			Hogged_Bookscbos_Weight=cBDOD.getTotalbalesweightForHoggedBooks();
			util.addValue(row, col++,CommonUtil.round(Hogged_Bookscbos_Weight, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight); 

			OCCcbos_Weight=cBDOD.getTotalbalesweightForOCC();
			util.addValue(row, col++,CommonUtil.round(OCCcbos_Weight, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight); 

			DLKcbos_Weight=cBDOD.getTotalbalesweightForDLK();
			util.addValue(row, col++,CommonUtil.round(DLKcbos_Weight, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight); 

			Mixed_Papercbos_Weight=cBDOD.getTotalbalesweightForMixedPaper();
			util.addValue(row, col++,CommonUtil.round(Mixed_Papercbos_Weight, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight); 

			Soft_Wood_Chipscbos_Weight=cBDOD.getTotalbalesweightForSoftWoodChips();
			util.addValue(row, col++,CommonUtil.round(Soft_Wood_Chipscbos_Weight, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight); 

			Hard_Wood_Chipscbos_Weight=cBDOD.getTotalbalesweightForHardWoodChips();
			util.addValue(row, col++,CommonUtil.round(Hard_Wood_Chipscbos_Weight, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight); 

			PWEcbos_Weight=cBDOD.getTotalbalesweightForPWE();
			util.addValue(row, col++,CommonUtil.round(PWEcbos_Weight, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight); 

			White_Brokecbos_Weight=cBDOD.getTotalbalesweightForWhiteBroke();
			util.addValue(row, col++,CommonUtil.round(White_Brokecbos_Weight, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight); 

			Brown_Napkin_Brokecbos_Weight=cBDOD.getTotalbalesweightForBrownNapkinBroke();
			util.addValue(row, col++,CommonUtil.round(Brown_Napkin_Brokecbos_Weight, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight); 

			PULP_Wet_Lapcbos_Weight=cBDOD.getTotalbalesweightForPULPWetLap();
			util.addValue(row, col++,CommonUtil.round(PULP_Wet_Lapcbos_Weight, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight); 

			Virgin_Pulpcbos_Weight=cBDOD.getTotalbalesweightForVirginPulp();
			util.addValue(row, col++,CommonUtil.round(Virgin_Pulpcbos_Weight, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight); 

			//Change The Sequence of From Here If Required

			Pulp_Dry_Lapcbos_Weight=cBDOD.getTotalbalesweightForPulpDryLap();
			util.addValue(row, col++,CommonUtil.round(Pulp_Dry_Lapcbos_Weight, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight); 

			Other_Rollscbos_Weight=cBDOD.getTotalbalesweightForOtherRolls();
			util.addValue(row, col++,CommonUtil.round(Other_Rollscbos_Weight, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight); 

			STT_Baled_Broke_Butlcbos_Weight=cBDOD.getTotalbalesweightForSTTBaledBroke();
			util.addValue(row, col++,CommonUtil.round(STT_Baled_Broke_Butlcbos_Weight, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight); 

			Brown_Wet_Lapcbos_Weight=cBDOD.getTotalbalesweightForBrownWetLap();
			util.addValue(row, col++,CommonUtil.round(Brown_Wet_Lapcbos_Weight, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight); 

			ST_Bales_wetlapcbos_Weight=cBDOD.getTotalbalesweightForSTBaleswetlap();
			util.addValue(row, col++,CommonUtil.round(ST_Bales_wetlapcbos_Weight, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight); 


			//

			VirginHardWoodcbos_Weight=cBDOD.getTotalbalesweightForVirginHardWood();
			VirginSoftWoodcbos_Weight=cBDOD.getTotalbalesweightForVirginSoftWood();

			//





			total_cbod_weight=MWLcbos_Weight+Prt_mixcbos_Weight+MCLcbos_Weight+MWL_W_IGScbos_Weight+CBScbos_Weight+Ctd_Gdwdcbos_Weight+
					SWLcbos_Weight+ONPcbos_Weight+OI_Newscbos_Weight+Light_Prt_SBScbos_Weight+HWcbos_Weight+Heavy_Prt_SBScbos_Weight+
					SOWcbos_Weight+Unprt_SBScbos_Weight+Newsblankcbos_Weight+White_Gdwd_Blendcbos_Weight+Mail_Undeliverablecbos_Weight+
					Hogged_Bookscbos_Weight+OCCcbos_Weight+DLKcbos_Weight+Mixed_Papercbos_Weight+Soft_Wood_Chipscbos_Weight+
					Hard_Wood_Chipscbos_Weight+PWEcbos_Weight+White_Brokecbos_Weight+Brown_Napkin_Brokecbos_Weight+
					PULP_Wet_Lapcbos_Weight+Virgin_Pulpcbos_Weight+Brown_Wet_Lapcbos_Weight+Pulp_Dry_Lapcbos_Weight+
					Other_Rollscbos_Weight+ST_Bales_wetlapcbos_Weight+STT_Baled_Broke_Butlcbos_Weight+STT_WetlapBales_PM6_White_Weight+STT_WetlapBales_PM6_Brown_Weight;

			util.addValue(row, col++,"",Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight); 
			util.addValue(row, col++,"",Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight); 

			//
			util.addValue(row, col++,CommonUtil.round(VirginHardWoodcbos_Weight, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight); 
			util.addValue(row, col++,CommonUtil.round(VirginSoftWoodcbos_Weight, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight); 
			//

			util.addValue(row, col++,CommonUtil.round(total_cbod_weight, 2),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight); 

			//Ends Added Later

		}

		for (int i = 0; i < 40; i++) {
			util.setAutoSizeColumn(i);
		}
		util.write(outputStream);	 





	}

}

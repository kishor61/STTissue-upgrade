/**
 *Jul 8, 2015
 *WastePaperBaleInventoryReport.java
 * TODO
 *com.st.wastepaperdetail.controller
 *WastePaperBaleInventoryReport.java
 *Roshan Lal Tailor
 */
package com.st.wastepaper.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.st.common.CommonUtil;
import com.st.common.exception.ProductionException;
import com.st.wastepaper.mailer.BarcodeInvetoryReportMailer;
import com.st.wastepaper.model.BarcodeComman;
import com.st.wastepaper.model.WastePaperBaleInventory;
import com.st.wastepaper.report.BarcodeInvetoryReportHandler;
import com.st.wastepaper.service.WastePaperBaleInventoryService;
import com.st.wastepaper.service.WastePaperUnloadBaleInventoryService;

/**
 * @author roshan
 *
 */
@Controller
@RequestMapping("/baleinventoryreport")
public class WastePaperBaleInventoryReportController {
	
	private SimpleDateFormat dateFormat=new SimpleDateFormat("MM-dd-yyyy");
	
	private SimpleDateFormat monthFormat=new SimpleDateFormat("MM");
	
	private SimpleDateFormat dayFormat=new SimpleDateFormat("dd");
	
	private SimpleDateFormat yearFormat=new SimpleDateFormat("yyyy");
	
	@Autowired 
	private WastePaperUnloadBaleInventoryService wastePaperUnloadBaleInventoryService;
	
	@Autowired
	private WastePaperBaleInventoryService wastePaperBaleInventoryService;
	
	@Autowired
	private ServletContext context;
	
	@Autowired
	private BarcodeInvetoryReportHandler barcodeInvetoryReportHandler;
	
	@Autowired
	private BarcodeInvetoryReportMailer barcodeInvetoryReportMailer;
	
	private static final String VIEW_PAGE="viewpage";
	
	@RequestMapping("/report")
	public String main(HttpServletRequest request,HttpServletResponse response,Model model){
		
		model.addAttribute("sdate", dateFormat.format(new Date()));
		model.addAttribute(VIEW_PAGE, false);
		return "wastePaperBaleInventoryReport";
	}
	@RequestMapping(value="/report/load",method=RequestMethod.GET)
	public String report(HttpServletRequest request,HttpServletResponse response, Model model) throws Exception{
		
		Date startdate=CommonUtil.checkDate(request.getParameter("sdate"), dateFormat);
		
		String firstDay1=dayFormat.format(startdate);
		Date currentMonthSDate =null;
		if(firstDay1.equalsIgnoreCase("01")){
			Calendar cal = Calendar.getInstance();
	        cal.setTime(startdate);
			cal.add(Calendar.MONTH, -1);
	        cal.set(Calendar.DATE, 1);
			currentMonthSDate = cal.getTime();
			cal.set(Calendar.DATE,cal.getActualMaximum(Calendar.DAY_OF_MONTH));
		}else{
			Calendar cal = Calendar.getInstance();
	        cal.setTime(startdate);
			cal.add(Calendar.MONTH, 0);
	        cal.set(Calendar.DATE, 1);
			currentMonthSDate = cal.getTime();
			cal.set(Calendar.DATE,cal.getActualMaximum(Calendar.DAY_OF_MONTH));
		}
		
		
		//New Condition Applied Here If Date Is 1
		String firstDay=dayFormat.format(startdate);
		System.out.println("firstDay:::"+firstDay);
		java.sql.Date preDayOfStartDate=null;
		if(firstDay.equalsIgnoreCase("01")){
			// Subtract 1 day From startdate
			System.out.println("Yes");
			System.out.println("Starts Date::"+dateFormat.format(startdate));
			
			Calendar t1 = Calendar.getInstance();
			t1.setTime(startdate);
			t1.add(Calendar.MONTH, 0);
			t1.add(Calendar.DATE, -1);
			preDayOfStartDate = new java.sql.Date(t1.getTimeInMillis());
			System.out.println("preDayOfStartDate::"+dateFormat.format(preDayOfStartDate));
			System.out.println("currentMonthSDate::"+dateFormat.format(currentMonthSDate));
		}else{
			// Subtract 1 day From startdate
			System.out.println("NO");
			System.out.println("Starts Date::"+dateFormat.format(startdate));
			
			Calendar t2 = Calendar.getInstance();
			t2.setTime(startdate);
			t2.add(Calendar.DATE, -1);
			preDayOfStartDate = new java.sql.Date(t2.getTimeInMillis());
			System.out.println("preDayOfStartDate::"+dateFormat.format(preDayOfStartDate));
			System.out.println("currentMonthSDate::"+dateFormat.format(currentMonthSDate));
		}
		
		List<WastePaperBaleInventory> unloadbalesdata=wastePaperBaleInventoryService.getUnloadBales(currentMonthSDate,preDayOfStartDate);
		
		List<WastePaperBaleInventory> consumedBalesData=wastePaperUnloadBaleInventoryService.getConsumedData(currentMonthSDate,preDayOfStartDate);
		
		List<WastePaperBaleInventory> frpData=wastePaperBaleInventoryService.getFRPLocationData();
		
		List<WastePaperBaleInventory> frps= new ArrayList<WastePaperBaleInventory>();
		final WastePaperBaleInventory frp=new WastePaperBaleInventory();
		
		int bales_white=0;
		double baleWeight_white=0;
		int bales_Brown=0;
		double baleWeight_brown=0;
		for(final WastePaperBaleInventory frpLocation: frpData){
			
			String color=frpLocation.getLotcolor();
			if(color.equalsIgnoreCase("White")){
				bales_white=frpLocation.getStt_wetlapbales_pm6_white();
				frp.setStt_wetlapbales_pm6_white(bales_white);
				
				baleWeight_white=frpLocation.getStt_wetlapbales_pm6_white_weight();		
				frp.setStt_wetlapbales_pm6_white_weight(baleWeight_white);		
			}
			if(color.equalsIgnoreCase("Brown")){
				bales_Brown=frpLocation.getStt_wetlapbales_pm6_brown();
				frp.setStt_wetlapbales_pm6_brown(bales_Brown);
				
				baleWeight_brown=frpLocation.getStt_wetlapbales_pm6_brown_weight();		
				frp.setStt_wetlapbales_pm6_brown_weight(baleWeight_brown);	
				
			}
			
			frps.add(frp);
			model.addAttribute("frps", frp);	
		}
		
		Calendar cal1 = Calendar.getInstance();
		cal1.setTime(startdate);
		cal1.add(Calendar.DATE, -1);

		Date yesterdayDate=cal1.getTime();
		//Code For One Day Consumed Bales And Weight Starts from Here
		List<WastePaperBaleInventory> consumedBalesDataOfOneDay=wastePaperUnloadBaleInventoryService.getConsumedData(yesterdayDate,yesterdayDate);
		
		List<WastePaperBaleInventory> cbos= new ArrayList<WastePaperBaleInventory>();
		final WastePaperBaleInventory cbo=new WastePaperBaleInventory();
		//Variable For Bales
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
		
		for(WastePaperBaleInventory cBDOD: consumedBalesDataOfOneDay){
			
			//Setter Getter For Bales
			MWLcbos=cBDOD.getTotalbalesOfMWL();
			 cbo.setTotalbalesOfMWL(MWLcbos);
			
			 Prt_mixcbos=cBDOD.getTotalbalesOfPrtmix();
			 cbo.setTotalbalesOfPrtmix(Prt_mixcbos);
			
			 MCLcbos=cBDOD.getTotalbalesOfMCL();
			 cbo.setTotalbalesOfMCL(MCLcbos);
			
			 MWL_W_IGScbos=cBDOD.getTotalbalesOfMWLWorIGS();
			 cbo.setTotalbalesOfMWLWorIGS(MWL_W_IGScbos);
			
			 CBScbos=cBDOD.getTotalbalesOfCBS();
			 cbo.setTotalbalesOfCBS(CBScbos);
			
			 Ctd_Gdwdcbos=cBDOD.getTotalbalesOfCtdGdwd();
			 cbo.setTotalbalesOfCtdGdwd(Ctd_Gdwdcbos);
			
			 SWLcbos=cBDOD.getTotalbalesOfSWL();
			 cbo.setTotalbalesOfSWL(SWLcbos);
			
			 ONPcbos=cBDOD.getTotalbalesOfONPOldNewsPrint();
			 cbo.setTotalbalesOfONPOldNewsPrint(ONPcbos);
			
			 OI_Newscbos=cBDOD.getTotalbalesOfOINews();
			 cbo.setTotalbalesOfOINews(OI_Newscbos);
			
			 Light_Prt_SBScbos=cBDOD.getTotalbalesOfLightPrtSBS();
			 cbo.setTotalbalesOfLightPrtSBS(Light_Prt_SBScbos);
			
			 HWcbos=cBDOD.getTotalbalesOfHW();
			 cbo.setTotalbalesOfHW(HWcbos);
			
			 Heavy_Prt_SBScbos=cBDOD.getTotalbalesOfHeavyPrtSBS();
			 cbo.setTotalbalesOfHeavyPrtSBS(Heavy_Prt_SBScbos);
			
			 SOWcbos=cBDOD.getTotalbalesOfSOW();
			 cbo.setTotalbalesOfSOW(SOWcbos);
			
			 Unprt_SBScbos=cBDOD.getTotalbalesOfUnprtSBS();
			 cbo.setTotalbalesOfUnprtSBS(Unprt_SBScbos);
			
			 Newsblankcbos=cBDOD.getTotalbalesOfNewsblank();
			 cbo.setTotalbalesOfNewsblank(Newsblankcbos);
			
			 White_Gdwd_Blendcbos=cBDOD.getTotalbalesOfWhiteGdwdBlend();
			 cbo.setTotalbalesOfWhiteGdwdBlend(White_Gdwd_Blendcbos);
			
			 Mail_Undeliverablecbos=cBDOD.getTotalbalesOfMailUndeliverable();
			 cbo.setTotalbalesOfMailUndeliverable(Mail_Undeliverablecbos);
			
			 Hogged_Bookscbos=cBDOD.getTotalbalesOfHoggedBooks();
			 cbo.setTotalbalesOfHoggedBooks(Hogged_Bookscbos);
			
			 OCCcbos=cBDOD.getTotalbalesOfOCC();
			 cbo.setTotalbalesOfOCC(OCCcbos);
			
			 DLKcbos=cBDOD.getTotalbalesOfDLK();
			 cbo.setTotalbalesOfDLK(DLKcbos);
			
			 Mixed_Papercbos=cBDOD.getTotalbalesOfMixedPaper();
			 cbo.setTotalbalesOfMixedPaper(Mixed_Papercbos);
			
			 Soft_Wood_Chipscbos=cBDOD.getTotalbalesOfSoftWoodChips();
			 cbo.setTotalbalesOfSoftWoodChips(Soft_Wood_Chipscbos);
			
			 Hard_Wood_Chipscbos=cBDOD.getTotalbalesOfHardWoodChips();
			 cbo.setTotalbalesOfHardWoodChips(Hard_Wood_Chipscbos);
			
			 PWEcbos=cBDOD.getTotalbalesOfPWE();
			 cbo.setTotalbalesOfPWE(PWEcbos);
			
			 White_Brokecbos=cBDOD.getTotalbalesOfWhiteBroke();
			 cbo.setTotalbalesOfWhiteBroke(White_Brokecbos);
			
			 Brown_Napkin_Brokecbos=cBDOD.getTotalbalesOfBrownNapkinBroke();
			 cbo.setTotalbalesOfBrownNapkinBroke(Brown_Napkin_Brokecbos);
			
			 
			 PULP_Wet_Lapcbos=cBDOD.getTotalbalesOfPULPWetLap();
			 cbo.setTotalbalesOfPULPWetLap(PULP_Wet_Lapcbos);
			
			 Virgin_Pulpcbos=cBDOD.getTotalbalesOfVirginPulp();
			 cbo.setTotalbalesOfVirginPulp(Virgin_Pulpcbos);
			
			 Brown_Wet_Lapcbos=cBDOD.getTotalbalesOfBrownWetLap();
			 cbo.setTotalbalesOfBrownWetLap(Brown_Wet_Lapcbos);
			
			 Pulp_Dry_Lapcbos=cBDOD.getTotalbalesOfPulpDryLap();
			 cbo.setTotalbalesOfPulpDryLap(Pulp_Dry_Lapcbos);
			
			 Other_Rollscbos=cBDOD.getTotalbalesOfOtherRolls();
			 cbo.setTotalbalesOfOtherRolls(Other_Rollscbos);
			
			 ST_Bales_wetlapcbos=cBDOD.getTotalbalesOfSTBaleswetlap();
			 cbo.setTotalbalesOfSTBaleswetlap(ST_Bales_wetlapcbos);
			
			 STT_Baled_Broke_Butlcbos=cBDOD.getTotalbalesOfSTTBaledBroke();
			 cbo.setTotalbalesOfSTTBaledBroke(STT_Baled_Broke_Butlcbos);
			 //Starts Added Later
			 STT_WetlapBales_PM6_White=cBDOD.getStt_wetlapbales_pm6_white();
			 cbo.setStt_wetlapbales_pm6_white(STT_WetlapBales_PM6_White);
			 
			 STT_WetlapBales_PM6_Brown=cBDOD.getStt_wetlapbales_pm6_brown();
			 cbo.setStt_wetlapbales_pm6_brown(STT_WetlapBales_PM6_Brown);
			 
			 
			 //
			 VirginHardWoodcbos=cBDOD.getTotalbalesOfVirginHardWood();
			 cbo.setTotalbalesOfVirginHardWood(VirginHardWoodcbos);
			 
			 VirginSoftWoodcbos=cBDOD.getTotalbalesOfVirginSoftWood();
			 cbo.setTotalbalesOfVirginSoftWood(VirginSoftWoodcbos);
			 
			 //
			 
			 
			 total_cbod_bales=MWLcbos+Prt_mixcbos+MCLcbos+MWL_W_IGScbos+CBScbos+Ctd_Gdwdcbos+SWLcbos+ONPcbos+OI_Newscbos+
			 Light_Prt_SBScbos+HWcbos+Heavy_Prt_SBScbos+SOWcbos+Unprt_SBScbos+Newsblankcbos+White_Gdwd_Blendcbos+
			 Mail_Undeliverablecbos+Hogged_Bookscbos+OCCcbos+DLKcbos+Mixed_Papercbos+Soft_Wood_Chipscbos+
			 Hard_Wood_Chipscbos+PWEcbos+White_Brokecbos+Brown_Napkin_Brokecbos+PULP_Wet_Lapcbos+
			 Virgin_Pulpcbos+Brown_Wet_Lapcbos+Pulp_Dry_Lapcbos+Other_Rollscbos+ST_Bales_wetlapcbos+
			 STT_Baled_Broke_Butlcbos+STT_WetlapBales_PM6_White+STT_WetlapBales_PM6_Brown+VirginHardWoodcbos+VirginSoftWoodcbos;
			
			
			 cbo.setTotal_cbod_bales(total_cbod_bales);
			
			 //Ends Added Later
			 
			 //Setter Getter For Weight
			 
			 MWLcbos_Weight=cBDOD.getTotalbalesweightForMWL();
			 cbo.setTotalbalesweightForMWL(MWLcbos_Weight);
			 
			 Prt_mixcbos_Weight=cBDOD.getTotalbalesweightForPrtmix();
			 cbo.setTotalbalesweightForPrtmix(Prt_mixcbos_Weight);
			
			 MCLcbos_Weight=cBDOD.getTotalbalesweightForMCL();
			 cbo.setTotalbalesweightForMCL(MCLcbos_Weight);
			
			 MWL_W_IGScbos_Weight=cBDOD.getTotalbalesweightForMWLWorIGS();
			 cbo.setTotalbalesweightForMWLWorIGS(MWL_W_IGScbos_Weight);
			
			 CBScbos_Weight=cBDOD.getTotalbalesweightForCBS();
			 cbo.setTotalbalesweightForCBS(CBScbos_Weight);
			
			 Ctd_Gdwdcbos_Weight=cBDOD.getTotalbalesweightForCtdGdwd();
			 cbo.setTotalbalesweightForCtdGdwd(Ctd_Gdwdcbos_Weight);
			
			 SWLcbos_Weight=cBDOD.getTotalbalesweightForSWL();
			 cbo.setTotalbalesweightForSWL(SWLcbos_Weight);
			
			 ONPcbos_Weight=cBDOD.getTotalbalesweightForONPOldNewsPrint();
			 cbo.setTotalbalesweightForONPOldNewsPrint(ONPcbos_Weight);
			
			 OI_Newscbos_Weight=cBDOD.getTotalbalesweightForOINews();
			 cbo.setTotalbalesweightForOINews(OI_Newscbos_Weight);
			
			 Light_Prt_SBScbos_Weight=cBDOD.getTotalbalesweightForLightPrtSBS();
			 cbo.setTotalbalesweightForLightPrtSBS(Light_Prt_SBScbos_Weight);
			
			 HWcbos_Weight=cBDOD.getTotalbalesweightForHW();
			 cbo.setTotalbalesweightForHW(HWcbos_Weight);
			
			 Heavy_Prt_SBScbos_Weight=cBDOD.getTotalbalesweightForHeavyPrtSBS();
			 cbo.setTotalbalesweightForHeavyPrtSBS(Heavy_Prt_SBScbos_Weight);
			
			 SOWcbos_Weight=cBDOD.getTotalbalesweightForSOW();
			 cbo.setTotalbalesweightForSOW(SOWcbos_Weight);
			
			 Unprt_SBScbos_Weight=cBDOD.getTotalbalesweightForUnprtSBS();
			 cbo.setTotalbalesweightForUnprtSBS(Unprt_SBScbos_Weight);
			
			 Newsblankcbos_Weight=cBDOD.getTotalbalesweightForNewsblank();
			 cbo.setTotalbalesweightForNewsblank(Newsblankcbos_Weight);
			
			 White_Gdwd_Blendcbos_Weight=cBDOD.getTotalbalesweightForWhiteGdwdBlend();
			 cbo.setTotalbalesweightForWhiteGdwdBlend(White_Gdwd_Blendcbos_Weight);
			
			 Mail_Undeliverablecbos_Weight=cBDOD.getTotalbalesweightForMailUndeliverable();
			 cbo.setTotalbalesweightForMailUndeliverable(Mail_Undeliverablecbos_Weight);
			
			 Hogged_Bookscbos_Weight=cBDOD.getTotalbalesweightForHoggedBooks();
			 cbo.setTotalbalesweightForHoggedBooks(Hogged_Bookscbos_Weight);
			
			 OCCcbos_Weight=cBDOD.getTotalbalesweightForOCC();
			 cbo.setTotalbalesweightForOCC(OCCcbos_Weight);
			
			 DLKcbos_Weight=cBDOD.getTotalbalesweightForDLK();
			 cbo.setTotalbalesweightForDLK(DLKcbos_Weight);
			
			 Mixed_Papercbos_Weight=cBDOD.getTotalbalesweightForMixedPaper();
			 cbo.setTotalbalesweightForMixedPaper(Mixed_Papercbos_Weight);
			
			 Soft_Wood_Chipscbos_Weight=cBDOD.getTotalbalesweightForSoftWoodChips();
			 cbo.setTotalbalesweightForSoftWoodChips(Soft_Wood_Chipscbos_Weight);
			
			 Hard_Wood_Chipscbos_Weight=cBDOD.getTotalbalesweightForHardWoodChips();
			 cbo.setTotalbalesweightForHardWoodChips(Hard_Wood_Chipscbos_Weight);
			
			 PWEcbos_Weight=cBDOD.getTotalbalesweightForPWE();
			 cbo.setTotalbalesweightForPWE(PWEcbos_Weight);
			
			 White_Brokecbos_Weight=cBDOD.getTotalbalesweightForWhiteBroke();
			 cbo.setTotalbalesweightForWhiteBroke(White_Brokecbos_Weight);
			
			 Brown_Napkin_Brokecbos_Weight=cBDOD.getTotalbalesweightForBrownNapkinBroke();
			 cbo.setTotalbalesweightForBrownNapkinBroke(Brown_Napkin_Brokecbos_Weight);
			
			 
			 PULP_Wet_Lapcbos_Weight=cBDOD.getTotalbalesweightForPULPWetLap();
			 cbo.setTotalbalesweightForPULPWetLap(PULP_Wet_Lapcbos_Weight);
			
			 Virgin_Pulpcbos_Weight=cBDOD.getTotalbalesweightForVirginPulp();
			 cbo.setTotalbalesweightForVirginPulp(Virgin_Pulpcbos_Weight);
			
			 Brown_Wet_Lapcbos_Weight=cBDOD.getTotalbalesweightForBrownWetLap();
			 cbo.setTotalbalesweightForBrownWetLap(Brown_Wet_Lapcbos_Weight);
			
			 Pulp_Dry_Lapcbos_Weight=cBDOD.getTotalbalesweightForPulpDryLap();
			 cbo.setTotalbalesweightForPulpDryLap(Pulp_Dry_Lapcbos_Weight);
			
			 Other_Rollscbos_Weight=cBDOD.getTotalbalesweightForOtherRolls();
			 cbo.setTotalbalesweightForOtherRolls(Other_Rollscbos_Weight);
			
			 ST_Bales_wetlapcbos_Weight=cBDOD.getTotalbalesweightForSTBaleswetlap();
			 cbo.setTotalbalesweightForSTBaleswetlap(ST_Bales_wetlapcbos_Weight);
			
			 STT_Baled_Broke_Butlcbos_Weight=cBDOD.getTotalbalesweightForSTTBaledBroke();
			 cbo.setTotalbalesweightForSTTBaledBroke(STT_Baled_Broke_Butlcbos_Weight);
			 
			 //Starts Added Later
			 STT_WetlapBales_PM6_White_Weight=cBDOD.getStt_wetlapbales_pm6_white_weight();
			 cbo.setStt_wetlapbales_pm6_white_weight(STT_WetlapBales_PM6_White_Weight);
			 
			 STT_WetlapBales_PM6_Brown_Weight=cBDOD.getStt_wetlapbales_pm6_brown_weight();
			 cbo.setStt_wetlapbales_pm6_brown_weight(STT_WetlapBales_PM6_Brown_Weight);
			 
			 //
			 
			 VirginHardWoodcbos_Weight=cBDOD.getTotalbalesweightForVirginHardWood();
			 cbo.setTotalbalesweightForVirginHardWood(VirginHardWoodcbos_Weight);
			 
			 
			 VirginSoftWoodcbos_Weight=cBDOD.getTotalbalesweightForVirginSoftWood();
			 cbo.setTotalbalesweightForVirginSoftWood(VirginSoftWoodcbos_Weight);
			 
			 
			 //
			 
			 total_cbod_weight=MWLcbos_Weight+Prt_mixcbos_Weight+MCLcbos_Weight+MWL_W_IGScbos_Weight+CBScbos_Weight+Ctd_Gdwdcbos_Weight+
			 SWLcbos_Weight+ONPcbos_Weight+OI_Newscbos_Weight+Light_Prt_SBScbos_Weight+HWcbos_Weight+Heavy_Prt_SBScbos_Weight+
			 SOWcbos_Weight+Unprt_SBScbos_Weight+Newsblankcbos_Weight+White_Gdwd_Blendcbos_Weight+Mail_Undeliverablecbos_Weight+
			 Hogged_Bookscbos_Weight+OCCcbos_Weight+DLKcbos_Weight+Mixed_Papercbos_Weight+Soft_Wood_Chipscbos_Weight+
			 Hard_Wood_Chipscbos_Weight+PWEcbos_Weight+White_Brokecbos_Weight+Brown_Napkin_Brokecbos_Weight+
			 PULP_Wet_Lapcbos_Weight+Virgin_Pulpcbos_Weight+Brown_Wet_Lapcbos_Weight+Pulp_Dry_Lapcbos_Weight+
			 Other_Rollscbos_Weight+ST_Bales_wetlapcbos_Weight+STT_Baled_Broke_Butlcbos_Weight+STT_WetlapBales_PM6_White_Weight+STT_WetlapBales_PM6_Brown_Weight+VirginHardWoodcbos_Weight+VirginSoftWoodcbos_Weight;
			 
			 cbo.setTotal_cbod_weight(total_cbod_weight);
			 //Ends Added Later
	
		cbos.add(cbo);
		model.addAttribute("cbos", cbo);
	}
		//Code For One Day Consumed Bales And Weight Ends Here
		SimpleDateFormat monthAnd = new SimpleDateFormat("MM");
		SimpleDateFormat yearAnd = new SimpleDateFormat("yyyy");
		 
		//String monthS=monthAnd.format(startdate);
		String monthS=monthAnd.format(preDayOfStartDate);
		int month = Integer.parseInt(monthS);
		/*if(month==1){
			 month=2;
		}*/
		 
		//String yearS=yearAnd.format(startdate);
		String yearS=yearAnd.format(preDayOfStartDate);
		int year = Integer.parseInt(yearS);
		
		//String dayS=dayFormat.format(startdate);
		String dayS=dayFormat.format(preDayOfStartDate);
		
		int day = Integer.parseInt(dayS);
		System.out.println("month::"+month);
		System.out.println("year::"+year);
		
		List<BarcodeComman> openingMonth=null;
		 
			if(day==1 || day==01){
				//openingMonth=wastePaperUnloadBaleInventoryService.getOpenMonth(month-1,year);
				openingMonth=wastePaperUnloadBaleInventoryService.getOpenMonth(month,year);
			}else{
				openingMonth=wastePaperUnloadBaleInventoryService.getOpenMonth(month,year);
			}
		  //openingMonth=wastePaperUnloadBaleInventoryService.getOpenMonth(month,year);
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
		 
		 
		 try{
				List<BarcodeComman> barcodeCommans=new ArrayList<BarcodeComman>();
				final BarcodeComman bc=new BarcodeComman();
				for(final BarcodeComman barcode:openingMonth){
					
					//Setter Getter For Bales
					 prtmix_om=barcode.getPrtmix();
					 bc.setPrtmix(prtmix_om);

					 mwl_om=barcode.getMwl();
					 bc.setMwl(mwl_om);
						
					 mcl_om=barcode.getMcl();
					 bc.setMcl(mcl_om);
							 
					 mwlwigs_om=barcode.getMwlwigs();
					 bc.setMwlwigs(mwlwigs_om);
							 
					 cbs_om =barcode.getCbs();
					 bc.setCbs(cbs_om);
							 
					 ctdGdwd_om =barcode.getCtdGdwd();
					 bc.setCtdGdwd(ctdGdwd_om);
					 
					 swlsortedwhite_om=barcode.getSwlsortedwhite();
					 bc.setSwlsortedwhite(swlsortedwhite_om);
 
					 onpolnNewsprint_om=barcode.getOnpolnNewsprint();
					 bc.setOnpolnNewsprint(onpolnNewsprint_om);
					 
					 oinews_om =barcode.getOinews();
					 bc.setOinews(oinews_om);
					 
					 lightprtsbs_om  =barcode.getLightprtsbs();
					 bc.setLightprtsbs(lightprtsbs_om);
					 
					 hw_om =barcode.getHw();
					 bc.setHw(hw_om);
					 
					 heavyprtsbs_om =barcode.getHeavyprtsbs();
					 bc.setLightprtsbs(heavyprtsbs_om);
							 
					 sow_om=barcode.getSow();
					 bc.setSow(sow_om);
					 
					 unprtsbs_om=barcode.getUnprtsbs();
					 bc.setUnprtsbs(unprtsbs_om);
					 
					 newsblank_om = barcode.getNewsblank();
					 bc.setNewsblank(newsblank_om);
					 
					 whitegdwdblend_om=barcode.getWhitegdwdblend();
					 bc.setWhitegdwdblend(whitegdwdblend_om);
					 
					 mailundeliverable_om=barcode.getMailundeliverable();   
					 bc.setMailundeliverable(mailundeliverable_om);
					
					 hoggedbooks_om=barcode.getHoggedbooks();    
					 bc.setHoggedbooks(hoggedbooks_om);
					
					 occ_om =barcode.getOcc();     
					 bc.setOcc(occ_om);
					 
					 dlk_om= barcode.getDlk();    
					 bc.setDlk(dlk_om);
					 
					 mixedpaper_om=barcode.getMixedpaper();
					 bc.setMixedpaper(mixedpaper_om);
					 
					 softwoodchips_om=barcode.getSoftwoodchips();     
					 bc.setSoftwoodchips(softwoodchips_om);
							 
					 hardwoodchips_om=barcode.getHardwoodchips();      
					 bc.setHardwoodchips(hardwoodchips_om);		 
					
					 whitebroke_om =barcode.getWhitebroke();     
					 bc.setWhitebroke(whitebroke_om);
					
					 pwe_om=barcode.getPwe();      
					 bc.setPwe(pwe_om);
					 
					 brownnapkinbroke_om =barcode.getBrownnapkinbroke();     
					 bc.setBrownnapkinbroke(brownnapkinbroke_om);
					
					 pulpwetlap_om=barcode.getPulpwetlap();      
					 bc.setPulpdryLap(pulpwetlap_om);
					
					 virginpulp_om =barcode.getVirginpulp();
					 bc.setVirginpulp(virginpulp_om);
					
					 brownwetLap_om = barcode.getBrownwetLap();    
					 bc.setBrownwetLap(brownwetLap_om);
					
					 pulpdryLap_om = barcode.getPulpdryLap();    
					 //System.out.println("pulpdryLap_om::"+pulpdryLap_om);
					 bc.setPulpdryLap(pulpdryLap_om);
					
					 otherrolls_om  = barcode.getOtherrolls(); 
					 bc.setOtherrolls(otherrolls_om);
					
					 stbaleswetlap_om= barcode.getStbaleswetlap();    
					 bc.setStbaleswetlap(stbaleswetlap_om);
					
					 sttbaledbrokebutl_om=barcode.getSttbaledbrokebutl();
					 bc.setSttbaledbrokebutl(sttbaledbrokebutl_om);
					 
					 //
					 virginhardwood_om=barcode.getVirginhardwood();
					 bc.setVirginhardwood(virginhardwood_om);
					 
					 virginsoftwood_om=barcode.getVirginsoftwood();
					 bc.setVirginsoftwood(virginsoftwood_om);
					 
					 //
					 
					 //Setter Getter For Bales Weight
					 
					 prtmix_weight_om=barcode.getPrtmixw();
					 bc.setPrtmixw(prtmix_weight_om);
					 
					 mwl_weight_om=barcode.getMwlw();
					 bc.setMwlw(mwl_weight_om);
							 
					 mcl_weight_om=barcode.getMclw();
					 bc.setMclw(mcl_weight_om);
					 
					 mwlwigs_weight_om=barcode.getMwlwigsw();
					 bc.setMwlwigsw(mwlwigs_weight_om);
					 
					 cbs_weight_om =barcode.getCbsw();
					 bc.setCbsw(cbs_weight_om);
							 
					 ctdGdwd_weight_om=barcode.getCtdGdwdw();
					 bc.setCtdGdwdw(ctdGdwd_weight_om);
							 
					 swlsortedwhite_weight_om=barcode.getSwlsortedwhitew();
					 bc.setSwlsortedwhitew(swlsortedwhite_weight_om);
					 
					 onpolnNewsprint_weight_om=barcode.getOnpolnNewsprintw();
					 bc.setOnpolnNewsprintw(onpolnNewsprint_weight_om);
					 
					 oinews_weight_om=barcode.getOinewsw();
					 bc.setOinewsw(oinews_weight_om);
							 
					 lightprtsbs_weight_om =barcode.getLightprtsbsw(); 
					 bc.setLightprtsbsw(lightprtsbs_weight_om);
							 
					 hw_weight_om=barcode.getHww();
					 bc.setHww(hw_weight_om);
							 
					 heavyprtsbs_weight_om=barcode.getHeavyprtsbsw();
					 bc.setHeavyprtsbsw(heavyprtsbs_weight_om);
							 
					 sow_weight_om=barcode.getSoww();
					 bc.setSoww(sow_weight_om);
							 
					 unprtsbs_weight_om=barcode.getUnprtsbsw();
					 bc.setUnprtsbsw(unprtsbs_weight_om);
							 
					 newsblank_weight_om=barcode.getNewsblankw();
					 bc.setNewsblankw(newsblank_weight_om);
							 
					 whitegdwdblend_weight_om=barcode.getWhitegdwdblendw();
					 bc.setWhitegdwdblendw(whitegdwdblend_weight_om);
					 
					 mailundeliverable_weight_om=barcode.getMailundeliverablew();
					 bc.setMailundeliverablew(mailundeliverable_weight_om);
							 
					 hoggedbooks_weight_om=barcode.getHoggedbooksw();
					 bc.setHoggedbooksw(hoggedbooks_weight_om);
							 
					 occ_weight_om=barcode.getOccw();
					 bc.setOccw(occ_weight_om);
							 
					 dlk_weight_om=barcode.getDlkw();
					 bc.setDlkw(dlk_weight_om);
							 
					 mixedpaper_weight_om=barcode.getMixedpaperw();
					 bc.setMixedpaperw(mixedpaper_weight_om);
							 
					 softwoodchips_weight_om=barcode.getSoftwoodchipsw();
					 bc.setSoftwoodchipsw(softwoodchips_weight_om);
							 
					 hardwoodchips_weight_om=barcode.getHardwoodchipsw();
					 bc.setHardwoodchipsw(hardwoodchips_weight_om);
							 
					 whitebroke_weight_om=barcode.getWhitebrokew();
					 bc.setWhitebrokew(whitebroke_weight_om);
							 
					 pwe_weight_om=barcode.getPwew();
					 bc.setPwew(pwe_weight_om);
							 
					 brownnapkinbroke_weight_om =barcode.getBrownnapkinbrokew();
					 bc.setBrownnapkinbrokew(brownnapkinbroke_weight_om);
							 
					 pulpwetlap_weight_om=barcode.getPulpwetlapw();
					 bc.setPulpwetlapw(pulpwetlap_weight_om);
							 
					 virginpulp_weight_om =barcode.getVirginpulpw();
					 bc.setVirginpulpw(virginpulp_weight_om);
							 
					 brownwetLap_weight_om=barcode.getBrownwetLapw();
					 bc.setBrownwetLapw(brownwetLap_weight_om);
							 
					 otherrolls_weight_om =barcode.getOtherrollsw();
					 bc.setOtherrollsw(otherrolls_weight_om);
							 
					 stbaleswetlap_weight_om=barcode.getStbaleswetlapw();
					 bc.setStbaleswetlapw(stbaleswetlap_weight_om);
							 
					 sttbaledbrokebutl_weight_om=barcode.getSttbaledbrokebutlw();
					 bc.setSttbaledbrokebutlw(sttbaledbrokebutl_weight_om);
							 
					 pulpdryLap_weight_om =barcode.getPulpdryLapw();
					 bc.setPulpdryLapw(pulpdryLap_weight_om);
					 
					 //
					 
					 virginhardwood_weight_om =barcode.getVirginhardwoodw();
					 bc.setVirginhardwoodw(virginhardwood_weight_om);
					 
					 
					 virginsoftwood_weight_om =barcode.getVirginsoftwoodw();
					 bc.setVirginsoftwoodw(virginsoftwood_weight_om);
					 
					 //
					 
			total_Tonnage=prtmix_weight_om+mwl_weight_om+mcl_weight_om+mwlwigs_weight_om + cbs_weight_om +ctdGdwd_weight_om+
					  swlsortedwhite_weight_om+onpolnNewsprint_weight_om+oinews_weight_om+lightprtsbs_weight_om + hw_weight_om+
					  heavyprtsbs_weight_om+sow_weight_om+unprtsbs_weight_om+newsblank_weight_om+whitegdwdblend_weight_om+
					  mailundeliverable_weight_om+hoggedbooks_weight_om+occ_weight_om+dlk_weight_om+mixedpaper_weight_om+
					  softwoodchips_weight_om+hardwoodchips_weight_om+whitebroke_weight_om+pwe_weight_om+brownnapkinbroke_weight_om +
					  pulpwetlap_weight_om+virginpulp_weight_om +brownwetLap_weight_om+otherrolls_weight_om +stbaleswetlap_weight_om+
					  sttbaledbrokebutl_weight_om+pulpdryLap_weight_om+baleWeight_white+baleWeight_brown+virginhardwood_weight_om+virginsoftwood_weight_om;
			
			bc.setTotal_tonnage(total_Tonnage);
							 
					 barcodeCommans.add(bc);
					model.addAttribute("bc", bc);
				}
				
			}catch(Exception rlt){
				System.out.println("You Have Problem in WastePaperBaleInventoryReportDetail.java at OpeningMonth List");
				rlt.printStackTrace();
			}
		 try{
				
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
				
				List<WastePaperBaleInventory> ulbs= new ArrayList<WastePaperBaleInventory>();
				final WastePaperBaleInventory ulb=new WastePaperBaleInventory();
				
				for(final WastePaperBaleInventory baleInventory1:unloadbalesdata){
					MWL1=baleInventory1.getTotalbalesOfMWL()+MWL1;
					 ulb.setTotalbalesOfMWL(MWL1);
					
					Prt_mix1=baleInventory1.getTotalbalesOfPrtmix()+Prt_mix1;
					 ulb.setTotalbalesOfPrtmix(Prt_mix1);
					
					MCL1=baleInventory1.getTotalbalesOfMCL()+MCL1;
					 ulb.setTotalbalesOfPrtmix(Prt_mix1);
					
					MWL_W_IGS1=baleInventory1.getTotalbalesOfMWLWorIGS()+MWL_W_IGS1;
					 ulb.setTotalbalesOfMWLWorIGS(MWL_W_IGS1);
					
					CBS1=baleInventory1.getTotalbalesOfCBS()+CBS1;
					 ulb.setTotalbalesOfCBS(CBS1);
					
					Ctd_Gdwd1=baleInventory1.getTotalbalesOfCtdGdwd()+Ctd_Gdwd1;
					 ulb.setTotalbalesOfCtdGdwd(Ctd_Gdwd1);
					
					SWL1=baleInventory1.getTotalbalesOfSWL()+SWL1;
					 ulb.setTotalbalesOfSWL(SWL1);
					
					ONP1=baleInventory1.getTotalbalesOfONPOldNewsPrint()+ONP1;
					 ulb.setTotalbalesOfONPOldNewsPrint(ONP1);
					
					OI_News1=baleInventory1.getTotalbalesOfOINews()+OI_News1;
					 ulb.setTotalbalesOfOINews(OI_News1);
					
					Light_Prt_SBS1=baleInventory1.getTotalbalesOfLightPrtSBS()+Light_Prt_SBS1;
					 ulb.setTotalbalesOfLightPrtSBS(Light_Prt_SBS1);
					
					HW1=baleInventory1.getTotalbalesOfHW()+HW1;
					 ulb.setTotalbalesOfHW(HW2);
					
					Heavy_Prt_SBS1=baleInventory1.getTotalbalesOfHeavyPrtSBS()+Heavy_Prt_SBS1;
					 ulb.setTotalbalesOfHeavyPrtSBS(Heavy_Prt_SBS1);
					
					SOW1=baleInventory1.getTotalbalesOfSOW()+SOW1;
					 ulb.setTotalbalesOfSOW(SOW1);
					
					Unprt_SBS1=baleInventory1.getTotalbalesOfUnprtSBS()+Unprt_SBS1;
					 ulb.setTotalbalesOfUnprtSBS(Unprt_SBS1);
					
					Newsblank1=baleInventory1.getTotalbalesOfNewsblank()+Newsblank1;
					 ulb.setTotalbalesOfNewsblank(Newsblank1);
					
					White_Gdwd_Blend1=baleInventory1.getTotalbalesOfWhiteGdwdBlend()+White_Gdwd_Blend1;
					 ulb.setTotalbalesOfWhiteGdwdBlend(White_Gdwd_Blend1);
					
					Mail_Undeliverable1=baleInventory1.getTotalbalesOfMailUndeliverable()+Mail_Undeliverable1;
					 ulb.setTotalbalesOfMailUndeliverable(Mail_Undeliverable1);
					
					Hogged_Books1=baleInventory1.getTotalbalesOfHoggedBooks()+Hogged_Books1;
					 ulb.setTotalbalesOfHoggedBooks(Hogged_Books1);
					
					OCC1=baleInventory1.getTotalbalesOfOCC()+OCC1;
					 ulb.setTotalbalesOfOCC(OCC1);
					
					DLK1=baleInventory1.getTotalbalesOfDLK()+DLK1;
					 ulb.setTotalbalesOfDLK(DLK1);
					
					Mixed_Paper1=baleInventory1.getTotalbalesOfMixedPaper()+Mixed_Paper1;
					 ulb.setTotalbalesOfMixedPaper(Mixed_Paper1);
					
					Soft_Wood_Chips1=baleInventory1.getTotalbalesOfSoftWoodChips()+Soft_Wood_Chips1;
					 ulb.setTotalbalesOfSoftWoodChips(Soft_Wood_Chips1);
					
					Hard_Wood_Chips1=baleInventory1.getTotalbalesOfHardWoodChips()+Hard_Wood_Chips1;
					 ulb.setTotalbalesOfHardWoodChips(Hard_Wood_Chips1);
					
					PWE1=baleInventory1.getTotalbalesOfPWE()+PWE1;
					 ulb.setTotalbalesOfPWE(PWE1);
					
					White_Broke1=baleInventory1.getTotalbalesOfWhiteBroke()+White_Broke1;
					 ulb.setTotalbalesOfWhiteBroke(White_Broke1);
					
					Brown_Napkin_Broke1=baleInventory1.getTotalbalesOfBrownNapkinBroke()+Brown_Napkin_Broke1;
					 ulb.setTotalbalesOfBrownNapkinBroke(Brown_Napkin_Broke1);
					
					PULP_Wet_Lap1=baleInventory1.getTotalbalesOfPULPWetLap()+PULP_Wet_Lap1;
					 ulb.setTotalbalesOfPULPWetLap(PULP_Wet_Lap1);
					
					Virgin_Pulp1=baleInventory1.getTotalbalesOfVirginPulp()+Virgin_Pulp1;
					 ulb.setTotalbalesOfVirginPulp(Virgin_Pulp1);
					
					Brown_Wet_Lap1=baleInventory1.getTotalbalesOfBrownWetLap()+Brown_Wet_Lap1;
					 ulb.setTotalbalesOfBrownWetLap(Brown_Wet_Lap1);
					
					Pulp_Dry_Lap1=baleInventory1.getTotalbalesOfPulpDryLap()+Pulp_Dry_Lap1;
					 ulb.setTotalbalesOfPulpDryLap(Pulp_Dry_Lap1);
					
					Other_Rolls1=baleInventory1.getTotalbalesOfOtherRolls()+Other_Rolls1;
					 ulb.setTotalbalesOfOtherRolls(Other_Rolls1);
					
					ST_Bales_wetlap1=baleInventory1.getTotalbalesOfSTBaleswetlap()+ST_Bales_wetlap1;
					 ulb.setTotalbalesOfSTBaleswetlap(ST_Bales_wetlap1);
					
					STT_Baled_Broke_Butl1=baleInventory1.getTotalbalesOfSTTBaledBroke()+STT_Baled_Broke_Butl1;
					 ulb.setTotalbalesOfSTTBaledBroke(STT_Baled_Broke_Butl1);
					 
					 //
					 Virgin_Hard_Wood1=baleInventory1.getTotalbalesOfVirginHardWood()+Virgin_Hard_Wood1;
					 ulb.setTotalbalesOfVirginHardWood(Virgin_Hard_Wood1);
					 
					 Virgin_Soft_Wood1=baleInventory1.getTotalbalesOfVirginSoftWood()+Virgin_Soft_Wood1;
					 ulb.setTotalbalesOfVirginSoftWood(Virgin_Soft_Wood1);
					 
					 //
					 
					
					 //unloadDetails.add(wastePaperBaleInventory);	
					_totalUnloadBales=MWL1+Prt_mix1+MCL1+MWL_W_IGS1+CBS1+Ctd_Gdwd1+SWL1+ONP1+OI_News1+Light_Prt_SBS1+
							HW1+Heavy_Prt_SBS1+SOW1+Unprt_SBS1+Newsblank1+White_Gdwd_Blend1+Mail_Undeliverable1+Hogged_Books1+OCC1+DLK1+Mixed_Paper1+
							Soft_Wood_Chips1+Hard_Wood_Chips1+PWE1+White_Broke1+Brown_Napkin_Broke1+PULP_Wet_Lap1+Virgin_Pulp1+Brown_Wet_Lap1+Pulp_Dry_Lap1+
							Other_Rolls1+ST_Bales_wetlap1+STT_Baled_Broke_Butl1+Virgin_Hard_Wood1+Virgin_Soft_Wood1;
					ulb.setTotalUnloadBales(_totalUnloadBales);
					
					//Getter Setter For Weight
					
					MWLW1=baleInventory1.getTotalbalesweightForMWL()+MWLW1;
					ulb.setTotalbalesweightForMWL(MWLW1);	
					
					Prt_mixW1=baleInventory1.getTotalbalesweightForPrtmix()+Prt_mixW1;
					ulb.setTotalbalesweightForPrtmix(Prt_mixW1);
					
					MCLW1=baleInventory1.getTotalbalesweightForMCL()+MCLW1;
					ulb.setTotalbalesweightForMCL(MCLW1);		
					
					MWL_W_IGSW1=baleInventory1.getTotalbalesweightForMWLWorIGS()+MWL_W_IGSW1;
					ulb.setTotalbalesweightForMWLWorIGS(MWL_W_IGSW1);
			
					CBSW1=baleInventory1.getTotalbalesweightForCBS()+CBSW1;
					ulb.setTotalbalesweightForCBS(CBSW1);
			
					Ctd_GdwdW1=baleInventory1.getTotalbalesweightForCtdGdwd()+Ctd_GdwdW1;
					ulb.setTotalbalesweightForCtdGdwd(Ctd_GdwdW1);
			
					SWLW1=baleInventory1.getTotalbalesweightForSWL()+SWLW1;
					ulb.setTotalbalesweightForSWL(SWLW1);
			
					ONPW1=baleInventory1.getTotalbalesweightForONPOldNewsPrint()+ONPW1;
					ulb.setTotalbalesweightForONPOldNewsPrint(ONPW1);
			
					OI_NewsW1=baleInventory1.getTotalbalesweightForOINews()+OI_NewsW1;
					ulb.setTotalbalesweightForOINews(OI_NewsW1);
			
					Light_Prt_SBSW1=baleInventory1.getTotalbalesweightForLightPrtSBS()+Light_Prt_SBSW1;
					ulb.setTotalbalesweightForLightPrtSBS(Light_Prt_SBSW1);
			
					HWW1=baleInventory1.getTotalbalesweightForHW()+HWW1;
					ulb.setTotalbalesweightForHW(HWW1);
			
					Heavy_Prt_SBSW1=baleInventory1.getTotalbalesweightForHeavyPrtSBS()+Heavy_Prt_SBSW1;
					ulb.setTotalbalesweightForHeavyPrtSBS(Heavy_Prt_SBSW1);
			
					SOWW1=baleInventory1.getTotalbalesweightForSOW()+SOWW1;
					ulb.setTotalbalesweightForSOW(SOWW1);
			
					Unprt_SBSW1=baleInventory1.getTotalbalesweightForUnprtSBS()+Unprt_SBSW1;
					ulb.setTotalbalesweightForUnprtSBS(Unprt_SBSW1);
			
					NewsblankW1=baleInventory1.getTotalbalesweightForNewsblank()+NewsblankW1;
					ulb.setTotalbalesweightForNewsblank(NewsblankW1);
			
					White_Gdwd_BlendW1=baleInventory1.getTotalbalesweightForWhiteGdwdBlend()+White_Gdwd_BlendW1;
					ulb.setTotalbalesweightForWhiteGdwdBlend(White_Gdwd_BlendW1);
			
					Mail_UndeliverableW1=baleInventory1.getTotalbalesweightForMailUndeliverable()+Mail_UndeliverableW1;
					ulb.setTotalbalesweightForMailUndeliverable(Mail_UndeliverableW1);
			
					Hogged_BooksW1=baleInventory1.getTotalbalesweightForHoggedBooks()+Hogged_BooksW1;
					ulb.setTotalbalesweightForHoggedBooks(Hogged_BooksW1);
			
					OCCW1=baleInventory1.getTotalbalesweightForOCC()+OCCW1;
					ulb.setTotalbalesweightForOCC(OCCW1);
			
					DLKW1=baleInventory1.getTotalbalesweightForDLK()+DLKW1;
					ulb.setTotalbalesweightForDLK(DLKW1);
			
					Mixed_PaperW1=baleInventory1.getTotalbalesweightForMixedPaper()+Mixed_PaperW1;
					ulb.setTotalbalesweightForMixedPaper(Mixed_PaperW1);
			
					Soft_Wood_ChipsW1=baleInventory1.getTotalbalesweightForSoftWoodChips()+Soft_Wood_ChipsW1;
					ulb.setTotalbalesweightForSoftWoodChips(Soft_Wood_ChipsW1);
			
					Hard_Wood_ChipsW1=baleInventory1.getTotalbalesweightForHardWoodChips()+Hard_Wood_ChipsW1;
					ulb.setTotalbalesweightForHardWoodChips(Hard_Wood_ChipsW1);
			
					PWEW1=baleInventory1.getTotalbalesweightForPWE()+PWEW1;
					ulb.setTotalbalesweightForPWE(PWEW1);
			
					White_BrokeW1=baleInventory1.getTotalbalesweightForWhiteBroke()+White_BrokeW1;
					ulb.setTotalbalesweightForWhiteBroke(White_BrokeW1);
			
					Brown_Napkin_BrokeW1=baleInventory1.getTotalbalesweightForBrownNapkinBroke()+Brown_Napkin_BrokeW1;
					ulb.setTotalbalesweightForBrownNapkinBroke(Brown_Napkin_BrokeW1);
			
					PULP_Wet_LapW1=baleInventory1.getTotalbalesweightForPULPWetLap()+PULP_Wet_LapW1;
					ulb.setTotalbalesweightForPULPWetLap(PULP_Wet_LapW1);
			
					Virgin_PulpW1=baleInventory1.getTotalbalesweightForVirginPulp()+Virgin_PulpW1;
					ulb.setTotalbalesweightForVirginPulp(Virgin_PulpW1);
			
					Brown_Wet_LapW1=baleInventory1.getTotalbalesweightForBrownWetLap()+Brown_Wet_LapW1;
					ulb.setTotalbalesweightForBrownWetLap(Brown_Wet_LapW1);
			
					Pulp_Dry_LapW1=baleInventory1.getTotalbalesweightForPulpDryLap()+Pulp_Dry_LapW1;
					ulb.setTotalbalesweightForPulpDryLap(Pulp_Dry_LapW1);
			
					Other_RollsW1=baleInventory1.getTotalbalesweightForOtherRolls()+Other_RollsW1;
					ulb.setTotalbalesweightForOtherRolls(Other_RollsW1);
			
					ST_Bales_wetlapW1=baleInventory1.getTotalbalesweightForSTBaleswetlap()+ST_Bales_wetlapW1;
					ulb.setTotalbalesweightForSTBaleswetlap(ST_Bales_wetlapW1);
			
					STT_Baled_Broke_ButlW1=baleInventory1.getTotalbalesweightForSTTBaledBroke()+STT_Baled_Broke_ButlW1;
					ulb.setTotalbalesweightForSTTBaledBroke(STT_Baled_Broke_ButlW1);
					
					//
					
					Virgin_Hard_WoodW1=baleInventory1.getTotalbalesweightForVirginHardWood()+Virgin_Hard_WoodW1;
					ulb.setTotalbalesweightForVirginHardWood(Virgin_Hard_WoodW1);
					
					Virgin_Soft_WoodW1=baleInventory1.getTotalbalesweightForVirginSoftWood()+Virgin_Soft_WoodW1;
					ulb.setTotalbalesweightForVirginSoftWood(Virgin_Soft_WoodW1);
					//
					
					_totalUnloadBalesWeight=MWLW1+Prt_mixW1+MCLW1+MWL_W_IGSW1+CBSW1+Ctd_GdwdW1+SWLW1+ONPW1+OI_NewsW1+Light_Prt_SBSW1+
							HWW1+Heavy_Prt_SBSW1+SOWW1+Unprt_SBSW1+NewsblankW1+White_Gdwd_BlendW1+Mail_UndeliverableW1+Hogged_BooksW1+OCCW1+DLKW1+
							Mixed_PaperW1+Soft_Wood_ChipsW1+Hard_Wood_ChipsW1+PWEW1+White_BrokeW1+Brown_Napkin_BrokeW1+PULP_Wet_LapW1+
							Virgin_PulpW1+Brown_Wet_LapW1+Pulp_Dry_LapW1+Other_RollsW1+ST_Bales_wetlapW1+STT_Baled_Broke_ButlW1+Virgin_Hard_WoodW1+Virgin_Soft_WoodW1;
					ulb.setTotalunloadbalesweight(_totalUnloadBalesWeight);
					
					ulbs.add(ulb);
					model.addAttribute("ulbs", ulb);
				}
				 List<WastePaperBaleInventory> cbs= new ArrayList<WastePaperBaleInventory>();
				 final WastePaperBaleInventory cb=new WastePaperBaleInventory();
				
				for(final WastePaperBaleInventory baleInventory2: consumedBalesData){
					
					MWL2=baleInventory2.getTotalbalesOfMWL()+MWL2;
					 cb.setTotalbalesOfMWL(MWL2);
					
					Prt_mix2=baleInventory2.getTotalbalesOfPrtmix()+Prt_mix2;
					 cb.setTotalbalesOfPrtmix(Prt_mix2);
					
					MCL2=baleInventory2.getTotalbalesOfMCL()+MCL2;
					 cb.setTotalbalesOfMCL(MCL2);
					
					MWL_W_IGS2=baleInventory2.getTotalbalesOfMWLWorIGS()+MWL_W_IGS2;
					 cb.setTotalbalesOfMWLWorIGS(MWL_W_IGS2);
					
					CBS2=baleInventory2.getTotalbalesOfCBS()+CBS2;
					 cb.setTotalbalesOfCBS(CBS2);
					
					Ctd_Gdwd2=baleInventory2.getTotalbalesOfCtdGdwd()+Ctd_Gdwd2;
					 cb.setTotalbalesOfCtdGdwd(Ctd_Gdwd2);
					
					SWL2=baleInventory2.getTotalbalesOfSWL()+SWL2;
					 cb.setTotalbalesOfSWL(SWL2);
					
					ONP2=baleInventory2.getTotalbalesOfONPOldNewsPrint()+ONP2;
					 cb.setTotalbalesOfONPOldNewsPrint(ONP2);
					
					OI_News2=baleInventory2.getTotalbalesOfOINews()+OI_News2;
					 cb.setTotalbalesOfOINews(OI_News2);
					
					Light_Prt_SBS2=baleInventory2.getTotalbalesOfLightPrtSBS()+Light_Prt_SBS2;
					 cb.setTotalbalesOfLightPrtSBS(Light_Prt_SBS2);
					
					HW2=baleInventory2.getTotalbalesOfHW()+HW2;
					 cb.setTotalbalesOfHW(HW2);
					
					Heavy_Prt_SBS2=baleInventory2.getTotalbalesOfHeavyPrtSBS()+Heavy_Prt_SBS2;
					 cb.setTotalbalesOfHeavyPrtSBS(Heavy_Prt_SBS2);
					
					SOW2=baleInventory2.getTotalbalesOfSOW()+SOW2;
					 cb.setTotalbalesOfSOW(SOW2);
					
					Unprt_SBS2=baleInventory2.getTotalbalesOfUnprtSBS()+Unprt_SBS2;
					 cb.setTotalbalesOfUnprtSBS(Unprt_SBS2);
					
					Newsblank2=baleInventory2.getTotalbalesOfNewsblank()+Newsblank2;
					 cb.setTotalbalesOfNewsblank(Newsblank2);
					
					White_Gdwd_Blend2=baleInventory2.getTotalbalesOfWhiteGdwdBlend()+White_Gdwd_Blend2;
					 cb.setTotalbalesOfWhiteGdwdBlend(White_Gdwd_Blend2);
					
					Mail_Undeliverable2=baleInventory2.getTotalbalesOfMailUndeliverable()+Mail_Undeliverable2;
					 cb.setTotalbalesOfMailUndeliverable(Mail_Undeliverable2);
					
					Hogged_Books2=baleInventory2.getTotalbalesOfHoggedBooks()+Hogged_Books2;
					 cb.setTotalbalesOfHoggedBooks(Hogged_Books2);
					
					OCC2=baleInventory2.getTotalbalesOfOCC()+OCC2;
					 cb.setTotalbalesOfOCC(OCC2);
					
					DLK2=baleInventory2.getTotalbalesOfDLK()+DLK2;
					 cb.setTotalbalesOfDLK(DLK2);
					
					Mixed_Paper2=baleInventory2.getTotalbalesOfMixedPaper()+Mixed_Paper2;
					 cb.setTotalbalesOfMixedPaper(Mixed_Paper2);
					
					Soft_Wood_Chips2=baleInventory2.getTotalbalesOfSoftWoodChips()+Soft_Wood_Chips2;
					 cb.setTotalbalesOfSoftWoodChips(Soft_Wood_Chips2);
					
					Hard_Wood_Chips2=baleInventory2.getTotalbalesOfHardWoodChips()+Hard_Wood_Chips2;
					 cb.setTotalbalesOfHardWoodChips(Hard_Wood_Chips2);
					
					PWE2=baleInventory2.getTotalbalesOfPWE()+PWE2;
					 cb.setTotalbalesOfPWE(PWE2);
					
					White_Broke2=baleInventory2.getTotalbalesOfWhiteBroke()+White_Broke2;
					 cb.setTotalbalesOfWhiteBroke(White_Broke2);
					
					Brown_Napkin_Broke2=baleInventory2.getTotalbalesOfBrownNapkinBroke()+Brown_Napkin_Broke2;
					 cb.setTotalbalesOfBrownNapkinBroke(Brown_Napkin_Broke2);
					
					 
					PULP_Wet_Lap2=baleInventory2.getTotalbalesOfPULPWetLap()+PULP_Wet_Lap2;
					 cb.setTotalbalesOfPULPWetLap(PULP_Wet_Lap2);
					
					Virgin_Pulp2=baleInventory2.getTotalbalesOfVirginPulp()+Virgin_Pulp2;
					 cb.setTotalbalesOfVirginPulp(Virgin_Pulp2);
					
					Brown_Wet_Lap2=baleInventory2.getTotalbalesOfBrownWetLap()+Brown_Wet_Lap2;
					 cb.setTotalbalesOfBrownWetLap(Brown_Wet_Lap2);
					
					Pulp_Dry_Lap2=baleInventory2.getTotalbalesOfPulpDryLap()+Pulp_Dry_Lap2;
					 cb.setTotalbalesOfPulpDryLap(Pulp_Dry_Lap2);
					 
					Other_Rolls2=baleInventory2.getTotalbalesOfOtherRolls()+Other_Rolls2;
					 cb.setTotalbalesOfOtherRolls(Other_Rolls2);
					
					ST_Bales_wetlap2=baleInventory2.getTotalbalesOfSTBaleswetlap()+ST_Bales_wetlap2;
					 cb.setTotalbalesOfSTBaleswetlap(ST_Bales_wetlap2);
					
					STT_Baled_Broke_Butl2=baleInventory2.getTotalbalesOfSTTBaledBroke()+STT_Baled_Broke_Butl2;
					cb.setTotalbalesOfSTTBaledBroke(STT_Baled_Broke_Butl2);
					
					//
					
					Virgin_Hard_Wood2=baleInventory2.getTotalbalesOfVirginHardWood()+Virgin_Hard_Wood2;
					cb.setTotalbalesOfVirginHardWood(Virgin_Hard_Wood2);
					
					Virgin_Soft_Wood2=baleInventory2.getTotalbalesOfVirginSoftWood()+Virgin_Soft_Wood2;
					cb.setTotalbalesOfVirginSoftWood(Virgin_Soft_Wood2);
					
					//
					
					_totalConsumedBales=MWL2+Prt_mix2+MCL2+MWL_W_IGS2+CBS2+Ctd_Gdwd2+SWL2+ONP2+OI_News2+Light_Prt_SBS2+
					HW2+Heavy_Prt_SBS2+SOW2+Unprt_SBS2+Newsblank2+White_Gdwd_Blend2+Mail_Undeliverable2+Hogged_Books2+OCC2+DLK2+Mixed_Paper2+
					Soft_Wood_Chips2+Hard_Wood_Chips2+PWE2+White_Broke2+Brown_Napkin_Broke2+PULP_Wet_Lap2+Virgin_Pulp2+Brown_Wet_Lap2+Pulp_Dry_Lap2+
					Other_Rolls2+ST_Bales_wetlap2+STT_Baled_Broke_Butl2+Virgin_Hard_Wood2+Virgin_Soft_Wood2;
					
					cb.setTotalConsumedBales(_totalConsumedBales);
					
					//Getter Setter For Weight
					
					MWLW2=baleInventory2.getTotalbalesweightForMWL()+MWLW2;
					cb.setTotalbalesweightForMWL(MWLW2);	
					
					Prt_mixW2=baleInventory2.getTotalbalesweightForPrtmix()+Prt_mixW2;
					cb.setTotalbalesweightForPrtmix(Prt_mixW2);
					
					MCLW2=baleInventory2.getTotalbalesweightForMCL()+MCLW2;
					cb.setTotalbalesweightForMCL(MCLW2);		
					
					MWL_W_IGSW2=baleInventory2.getTotalbalesweightForMWLWorIGS()+MWL_W_IGSW2;
					cb.setTotalbalesweightForMWLWorIGS(MWL_W_IGSW2);
			
					CBSW2=baleInventory2.getTotalbalesweightForCBS()+CBSW2;
					cb.setTotalbalesweightForCBS(CBSW2);
			
					Ctd_GdwdW2=baleInventory2.getTotalbalesweightForCtdGdwd()+Ctd_GdwdW2;
					cb.setTotalbalesweightForCtdGdwd(Ctd_GdwdW2);
			
					SWLW2=baleInventory2.getTotalbalesweightForSWL()+SWLW2;
					cb.setTotalbalesweightForSWL(SWLW2);
			
					ONPW2=baleInventory2.getTotalbalesweightForONPOldNewsPrint()+ONPW2;
					cb.setTotalbalesweightForONPOldNewsPrint(ONPW2);
			
					OI_NewsW2=baleInventory2.getTotalbalesweightForOINews()+OI_NewsW2;
					cb.setTotalbalesweightForOINews(OI_NewsW2);
			
					Light_Prt_SBSW2=baleInventory2.getTotalbalesweightForLightPrtSBS()+Light_Prt_SBSW2;
					cb.setTotalbalesweightForLightPrtSBS(Light_Prt_SBSW2);
			
					HWW2=baleInventory2.getTotalbalesweightForHW()+HWW2;
					cb.setTotalbalesweightForHW(HWW2);
			
					Heavy_Prt_SBSW2=baleInventory2.getTotalbalesweightForHeavyPrtSBS()+Heavy_Prt_SBSW2;
					cb.setTotalbalesweightForHeavyPrtSBS(Heavy_Prt_SBSW2);
			
					SOWW2=baleInventory2.getTotalbalesweightForSOW()+SOWW2;
					cb.setTotalbalesweightForSOW(SOWW2);
			
					Unprt_SBSW2=baleInventory2.getTotalbalesweightForUnprtSBS()+Unprt_SBSW2;
					cb.setTotalbalesweightForUnprtSBS(Unprt_SBSW2);
			
					NewsblankW2=baleInventory2.getTotalbalesweightForNewsblank()+NewsblankW2;
					cb.setTotalbalesweightForNewsblank(NewsblankW2);
			
					White_Gdwd_BlendW2=baleInventory2.getTotalbalesweightForWhiteGdwdBlend()+White_Gdwd_BlendW2;
					cb.setTotalbalesweightForWhiteGdwdBlend(White_Gdwd_BlendW2);
			
					Mail_UndeliverableW2=baleInventory2.getTotalbalesweightForMailUndeliverable()+Mail_UndeliverableW2;
					cb.setTotalbalesweightForMailUndeliverable(Mail_UndeliverableW2);
			
					Hogged_BooksW2=baleInventory2.getTotalbalesweightForHoggedBooks()+Hogged_BooksW2;
					cb.setTotalbalesweightForHoggedBooks(Hogged_BooksW2);
			
					OCCW2=baleInventory2.getTotalbalesweightForOCC()+OCCW2;
					cb.setTotalbalesweightForOCC(OCCW2);
			
					DLKW2=baleInventory2.getTotalbalesweightForDLK()+DLKW2;
					cb.setTotalbalesweightForDLK(DLKW2);
			
					Mixed_PaperW2=baleInventory2.getTotalbalesweightForMixedPaper()+Mixed_PaperW2;
					cb.setTotalbalesweightForMixedPaper(Mixed_PaperW2);
			
					Soft_Wood_ChipsW2=baleInventory2.getTotalbalesweightForSoftWoodChips()+Soft_Wood_ChipsW2;
					cb.setTotalbalesweightForSoftWoodChips(Soft_Wood_ChipsW2);
			
					Hard_Wood_ChipsW2=baleInventory2.getTotalbalesweightForHardWoodChips()+Hard_Wood_ChipsW2;
					cb.setTotalbalesweightForHardWoodChips(Hard_Wood_ChipsW2);
			
					PWEW2=baleInventory2.getTotalbalesweightForPWE()+PWEW2;
					cb.setTotalbalesweightForPWE(PWEW2);
			
					White_BrokeW2=baleInventory2.getTotalbalesweightForWhiteBroke()+White_BrokeW2;
					cb.setTotalbalesweightForWhiteBroke(White_BrokeW2);
			
					Brown_Napkin_BrokeW2=baleInventory2.getTotalbalesweightForBrownNapkinBroke()+Brown_Napkin_BrokeW2;
					cb.setTotalbalesweightForBrownNapkinBroke(Brown_Napkin_BrokeW2);
			
					PULP_Wet_LapW2=baleInventory2.getTotalbalesweightForPULPWetLap()+PULP_Wet_LapW2;
					cb.setTotalbalesweightForPULPWetLap(PULP_Wet_LapW2);
			
					Virgin_PulpW2=baleInventory2.getTotalbalesweightForVirginPulp()+Virgin_PulpW2;
					cb.setTotalbalesweightForVirginPulp(Virgin_PulpW2);
			
					Brown_Wet_LapW2=baleInventory2.getTotalbalesweightForBrownWetLap()+Brown_Wet_LapW2;
					cb.setTotalbalesweightForBrownWetLap(Brown_Wet_LapW2);
			
					Pulp_Dry_LapW2=baleInventory2.getTotalbalesweightForPulpDryLap()+Pulp_Dry_LapW2;
					cb.setTotalbalesweightForPulpDryLap(Pulp_Dry_LapW2);
			
					Other_RollsW2=baleInventory2.getTotalbalesweightForOtherRolls()+Other_RollsW2;
					cb.setTotalbalesweightForOtherRolls(Other_RollsW2);
			
					ST_Bales_wetlapW2=baleInventory2.getTotalbalesweightForSTBaleswetlap()+ST_Bales_wetlapW2;
					cb.setTotalbalesweightForSTBaleswetlap(ST_Bales_wetlapW2);
			
					STT_Baled_Broke_ButlW2=baleInventory2.getTotalbalesweightForSTTBaledBroke()+STT_Baled_Broke_ButlW2;
					cb.setTotalbalesweightForSTTBaledBroke(STT_Baled_Broke_ButlW2);
					
					//
					
					Virgin_Hard_WoodW2=baleInventory2.getTotalbalesweightForVirginHardWood()+Virgin_Hard_WoodW2;
					cb.setTotalbalesweightForVirginHardWood(Virgin_Hard_WoodW2);
					
					Virgin_Soft_WoodW2=baleInventory2.getTotalbalesweightForVirginSoftWood()+Virgin_Soft_WoodW2;
					cb.setTotalbalesweightForVirginSoftWood(Virgin_Soft_WoodW2);
					
					//
					
					_totalConsumedBalesWeight=MWLW2+Prt_mixW2+MCLW2+MWL_W_IGSW2+CBSW2+Ctd_GdwdW2+SWLW2+ONPW2+OI_NewsW2+Light_Prt_SBSW2+HWW2+Heavy_Prt_SBSW2+SOWW2+
					Unprt_SBSW2+NewsblankW2+White_Gdwd_BlendW2+Mail_UndeliverableW2+Hogged_BooksW2+OCCW2+DLKW2+Mixed_PaperW2+
					Soft_Wood_ChipsW2+Hard_Wood_ChipsW2+PWEW2+White_BrokeW2+Brown_Napkin_BrokeW2+PULP_Wet_LapW2+Virgin_PulpW2+
					Brown_Wet_LapW2+Pulp_Dry_LapW2+Other_RollsW2+ST_Bales_wetlapW2+STT_Baled_Broke_ButlW2+Virgin_Hard_WoodW2+Virgin_Soft_WoodW2;
					
					cb.setTotalconsumedbalesweight(_totalConsumedBalesWeight);
					cbs.add(cb);
					model.addAttribute("cbs", cb);
				}
				//Formula :- (Opening+Unload)-(Consume);
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
				
				int value67=(virginhardwood_om+Virgin_Hard_Wood1)-Virgin_Hard_Wood2;
				int value68=(virginsoftwood_om+Virgin_Soft_Wood1)-Virgin_Soft_Wood2;
				
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
				
				model.addAttribute("v1", value1);
				model.addAttribute("v2", value2);
				model.addAttribute("v3", value3);
				model.addAttribute("v4", value4);
				model.addAttribute("v5", value5);
				model.addAttribute("v6", value6);
				model.addAttribute("v7", value7);
				model.addAttribute("v8", value8);
				model.addAttribute("v9", value9);
				model.addAttribute("v10", value10);
				model.addAttribute("v11", value11);
				model.addAttribute("v12", value12);
				model.addAttribute("v13", value13);
				model.addAttribute("v14", value14);
				model.addAttribute("v15", value15);
				model.addAttribute("v16", value16);
				model.addAttribute("v17", value17);
				model.addAttribute("v18", value18);
				model.addAttribute("v19", value19);
				model.addAttribute("v20", value20);
				model.addAttribute("v21", value21);
				model.addAttribute("v22", value22);
				model.addAttribute("v23", value23);
				model.addAttribute("v24", value24);
				model.addAttribute("v25", value25);
				model.addAttribute("v26", value26);
				model.addAttribute("v27", value27);
				model.addAttribute("v28", value28);
				model.addAttribute("v29", value29);
				model.addAttribute("v30", value30);
				model.addAttribute("v31", value31);
				model.addAttribute("v32", value32);
				model.addAttribute("v33", value33);
				model.addAttribute("totalBales", totalBales);
				//Below Are For Weight
				model.addAttribute("v34", value34);
				model.addAttribute("v35", value35);
				model.addAttribute("v36", value36);
				model.addAttribute("v37", value37);
				model.addAttribute("v38", value38);
				model.addAttribute("v39", value39);
				model.addAttribute("v40", value40);
				model.addAttribute("v41", value41);
				model.addAttribute("v42", value42);
				model.addAttribute("v43", value43);
				model.addAttribute("v44", value44);
				model.addAttribute("v45", value45);
				model.addAttribute("v46", value46);
				model.addAttribute("v47", value47);
				model.addAttribute("v48", value48);
				model.addAttribute("v49", value49);
				model.addAttribute("v50", value50);
				model.addAttribute("v51", value51);
				model.addAttribute("v52", value52);
				model.addAttribute("v53", value53);
				model.addAttribute("v54", value54);
				model.addAttribute("v55", value55);
				model.addAttribute("v56", value56);
				model.addAttribute("v57", value57);
				model.addAttribute("v58", value58);
				model.addAttribute("v59", value59);
				model.addAttribute("v60", value60);
				model.addAttribute("v61", value61);
				model.addAttribute("v62", value62);
				model.addAttribute("v63", value63);
				model.addAttribute("v64", value64);
				model.addAttribute("v65", value65);
				model.addAttribute("v66", value66);
				
				//
				model.addAttribute("v67", value67);
				model.addAttribute("v68", value68);
				model.addAttribute("v69", value69);
				model.addAttribute("v70", value70);
				//
				model.addAttribute("_final_ivt_total_weight", _final_ivt_total_weight);
		}catch(Exception rlt){
			System.out.println("Roshan Says, You Have Problem In WastePaperBaleInventoryReportDetailController.java"); 
			rlt.printStackTrace();
		}
		model.addAttribute(VIEW_PAGE, true); 
		model.addAttribute("sdate", dateFormat.format(startdate));
		model.addAttribute("yesterdayDate", yesterdayDate);
			
		return "wastePaperBaleInventoryReport";
	
	}
	@RequestMapping(value="/report/email",method=RequestMethod.POST)
	public @ResponseBody boolean mailDataGradeAndHours(HttpServletRequest request,HttpServletResponse response,Model model) throws ProductionException, IOException {
		try {
			Date startdate=CommonUtil.checkDate(request.getParameter("sdate"), dateFormat);
			
			barcodeInvetoryReportMailer.getBarcodeInventoryReportSendEmail(startdate);
			
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	@RequestMapping(value="/export",method=RequestMethod.POST)
	public void export(@RequestParam("sdate")String sdate,HttpServletRequest request,HttpServletResponse response) throws Exception{
		
		Date startdate=CommonUtil.checkDate(request.getParameter("sdate"), dateFormat);
		
		
		String firstDay1=dayFormat.format(startdate);
		Date currentMonthSDate =null;
		if(firstDay1.equalsIgnoreCase("01")){
			Calendar cal = Calendar.getInstance();
	        cal.setTime(startdate);
			cal.add(Calendar.MONTH, -1);
	        cal.set(Calendar.DATE, 1);
			currentMonthSDate = cal.getTime();
			cal.set(Calendar.DATE,cal.getActualMaximum(Calendar.DAY_OF_MONTH));
		}else{
			Calendar cal = Calendar.getInstance();
	        cal.setTime(startdate);
			cal.add(Calendar.MONTH, 0);
	        cal.set(Calendar.DATE, 1);
			currentMonthSDate = cal.getTime();
			cal.set(Calendar.DATE,cal.getActualMaximum(Calendar.DAY_OF_MONTH));
		}
		

		//New Condition Applied Here If Date Is 1
		String firstDay=dayFormat.format(startdate);
		System.out.println("firstDay:::"+firstDay);
		java.sql.Date preDayOfStartDate=null;
		if(firstDay.equalsIgnoreCase("01")){
			// Subtract 1 day From startdate
			System.out.println("Yes");
			System.out.println("Starts Date::"+dateFormat.format(startdate));
			
			Calendar t1 = Calendar.getInstance();
			t1.setTime(startdate);
			t1.add(Calendar.MONTH, 0);
			t1.add(Calendar.DATE, -1);
			preDayOfStartDate = new java.sql.Date(t1.getTimeInMillis());
			System.out.println("preDayOfStartDate::"+dateFormat.format(preDayOfStartDate));
			System.out.println("currentMonthSDate::"+dateFormat.format(currentMonthSDate));
		}else{
			// Subtract 1 day From startdate
			System.out.println("NO");
			System.out.println("Starts Date::"+dateFormat.format(startdate));
			
			Calendar t2 = Calendar.getInstance();
			t2.setTime(startdate);
			t2.add(Calendar.DATE, -1);
			preDayOfStartDate = new java.sql.Date(t2.getTimeInMillis());
		}
		
		List<WastePaperBaleInventory> unloadbalesdata=wastePaperBaleInventoryService.getUnloadBales(currentMonthSDate,preDayOfStartDate);
		
		List<WastePaperBaleInventory> consumedBalesData=wastePaperUnloadBaleInventoryService.getConsumedData(currentMonthSDate,preDayOfStartDate);
		
		
		Calendar cal1 = Calendar.getInstance();
		cal1.setTime(startdate);
		cal1.add(Calendar.DATE, -1);
		System.out.println("Yesterday's date = "+ cal1.getTime());
		Date yesterdayDate=cal1.getTime();
			
		//Code For One Day Consumed Bales And Weight Starts from Here
		List<WastePaperBaleInventory> consumedBalesDataOfOneDay=wastePaperUnloadBaleInventoryService.getConsumedData(yesterdayDate,yesterdayDate);
		
		SimpleDateFormat monthAnd = new SimpleDateFormat("MM");
		SimpleDateFormat yearAnd = new SimpleDateFormat("yyyy");
		 
		//String monthS=monthAnd.format(startdate);
		String monthS=monthAnd.format(preDayOfStartDate);
		int month = Integer.parseInt(monthS);
		/*if(month==1){
			 month=2;
		}*/
		 
		//String yearS=yearAnd.format(startdate);
		String yearS=yearAnd.format(preDayOfStartDate);
		int year = Integer.parseInt(yearS);
		
		//String dayS=dayFormat.format(startdate);
		String dayS=dayFormat.format(preDayOfStartDate);
		int day = Integer.parseInt(dayS);
		
		List<BarcodeComman> openingMonth=null;
		 
		if(day==1 || day==01){
			//openingMonth=wastePaperUnloadBaleInventoryService.getOpenMonth(month-1,year);
			openingMonth=wastePaperUnloadBaleInventoryService.getOpenMonth(month,year);
		}else{
			openingMonth=wastePaperUnloadBaleInventoryService.getOpenMonth(month,year);
		}
		
		//openingMonth=wastePaperUnloadBaleInventoryService.getOpenMonth(month,year);
		
		List<WastePaperBaleInventory> frpData=wastePaperBaleInventoryService.getFRPLocationData();
		response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
		response.setHeader("Content-Disposition", "attachment; filename=Waste_Paper_Bale_Inventory_Report.xlsx");
		File file=new File(context.getRealPath("/")+"WEB-INF/Waste_Paper_Bale_Inventory_Report.xlsx");
		
		barcodeInvetoryReportHandler.getBarcodeInventoryReport(unloadbalesdata,consumedBalesData,consumedBalesDataOfOneDay,preDayOfStartDate,openingMonth,frpData,yesterdayDate,startdate,file,response.getOutputStream());
		
			
		}
}

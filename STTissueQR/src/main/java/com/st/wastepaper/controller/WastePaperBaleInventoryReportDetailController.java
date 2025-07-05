/**
 *Jul 8, 2015
 *WastePaperBaleInventoryReportDetail.java
 * TODO
 *com.st.wastepaperdetailreport.controller
 *WastePaperBaleInventoryReportDetail.java
 *Roshan Lal Tailor
 */
package com.st.wastepaper.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.st.common.CommonUtil;
import com.st.wastepaper.model.BarcodeComman;
import com.st.wastepaper.model.WastePaperBaleInventory;
import com.st.wastepaper.report.BarcodeInvetoryReportDetailHandler;
import com.st.wastepaper.service.WastePaperBaleInventoryService;
import com.st.wastepaper.service.WastePaperUnloadBaleInventoryService;

/**
 * @author roshan
 *
 */
@Controller
@RequestMapping("/baleinventoryreportdetail")
public class WastePaperBaleInventoryReportDetailController {

	private SimpleDateFormat dateFormat=new SimpleDateFormat("MM-dd-yyyy");
	
	private SimpleDateFormat dateFormatSpecial=new SimpleDateFormat("MM-dd-yy");
	
	private SimpleDateFormat monthFormat=new SimpleDateFormat("MM");
	
	private SimpleDateFormat yearFormat=new SimpleDateFormat("yyyy");
	
	
	@Autowired 
	private WastePaperUnloadBaleInventoryService wastePaperUnloadBaleInventoryService;
	
	@Autowired
	private WastePaperBaleInventoryService wastePaperBaleInventoryService;
	
	@Autowired
	private ServletContext context;
	
	@Autowired
	private BarcodeInvetoryReportDetailHandler barcodeInvetoryReportDetailHandler;
	
	private static final String VIEW_PAGE="viewpage";
	
	//private static final String LANDING_PAGE="landingpage";
	
	@RequestMapping(value="/detail")
	public String detail(HttpServletRequest request,HttpServletResponse response, Model model){
		
		//model.addAttribute(LANDING_PAGE, true);
		model.addAttribute("startdate", dateFormat.format(new Date()));
		model.addAttribute("enddate", dateFormat.format(new Date()));
		return "WastePaperBaleInventoryReportDetail";
	}
	@RequestMapping(value="/detailreport/load",method=RequestMethod.GET)
	public String detailreport(HttpServletRequest request,HttpServletResponse response, Model model) throws Exception{
		
		Date startdate=CommonUtil.checkDate(request.getParameter("startdate"), dateFormat);
		Date enddate=CommonUtil.checkDate(request.getParameter("enddate"), dateFormat);
		
		List<WastePaperBaleInventory> unloadbalesdata=wastePaperBaleInventoryService.getUnloadBales(startdate,enddate);
		
		List<WastePaperBaleInventory> consumedBalesData=wastePaperUnloadBaleInventoryService.getConsumedData(startdate,enddate);
		
		//Get Last Month Start Date and End Date, Code Starts From Here
				
		 SimpleDateFormat monthAnd = new SimpleDateFormat("MM");
		 SimpleDateFormat yearAnd = new SimpleDateFormat("yyyy");
		 
		 String monthS=monthAnd.format(startdate);
		 int month = Integer.parseInt(monthS);
		/* if(month==1){
			 month=2;
		 }*/
		 
		 String yearS=yearAnd.format(startdate);
		 int year = Integer.parseInt(yearS);
		 
		System.out.println("Year::"+year+",Month::"+month);
		/*List<WastePaperBaleInventory> unloadbalesdatalastmonth=wastePaperBaleInventoryService.getUnloadBales(firstDateOfPreviousMonth,lastDateOfPreviousMonth);
		List<WastePaperBaleInventory> consumedBalesDatalastmonth=wastePaperUnloadBaleInventoryService.getConsumedData(firstDateOfPreviousMonth,lastDateOfPreviousMonth);*/
		
		 //List<BarcodeComman> openingMonth=wastePaperUnloadBaleInventoryService.getOpenMonth(month-1,year);
		   List<BarcodeComman> openingMonth=wastePaperUnloadBaleInventoryService.getOpenMonth(month,year);
				
				if(openingMonth.size()==0){
					System.out.println("Opening Month Is Zero...");
				}
				 //Variables Of Bales For Opening Month	
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
				 
				 int _total_om=0;
				 
				 //Variables Of Opening Month For Weight
				 double prtmix_omw=0;
				 double mwl_omw=0;
				 double mcl_omw=0;
				 double mwlwigs_omw =0; 
				 double cbs_omw =0;
				 double ctdGdwd_omw=0;
				 double swlsortedwhite_omw=0;
				 double onpolnNewsprint_omw=0;
				 double oinews_omw=0;
				 double lightprtsbs_omw =0; 
				 double hw_omw=0;
				 double heavyprtsbs_omw=0;
				 double sow_omw=0;
				 double unprtsbs_omw=0;
				 double newsblank_omw=0;
				 double whitegdwdblend_omw=0;
				 double mailundeliverable_omw=0;
				 double hoggedbooks_omw=0;
				 double occ_omw=0;
				 double dlk_omw=0;
				 double mixedpaper_omw=0;
				 double softwoodchips_omw=0;
				 double hardwoodchips_omw=0;
				 double whitebroke_omw=0;
				 double pwe_omw=0;
				 double brownnapkinbroke_omw =0;
				 double pulpwetlap_omw=0;
				 double virginpulp_omw =0;
				 double brownwetLap_omw=0;
				 double otherrolls_omw =0;
				 double stbaleswetlap_omw=0;
				 double sttbaledbrokebutl_omw=0;
				 double pulpdryLap_omw =0;
				 
				 double virginhardwoodw_omw =0;
				 double virginsoftwoodw_omw =0;
				 
				 double _total_omw=0;
				try{
					List<BarcodeComman> barcodeCommans=new ArrayList<BarcodeComman>();
					final BarcodeComman bc=new BarcodeComman();
					for(BarcodeComman barcode:openingMonth){
						
						//Setter Getter Starts From Here For Bales
						 mwl_om=barcode.getMwl();
						 bc.setMwl(mwl_om);
						 
						 prtmix_om=barcode.getPrtmix();
						 bc.setPrtmix(prtmix_om);

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
						 bc.setPulpwetlap(pulpwetlap_om);
						 
						 virginpulp_om =barcode.getVirginpulp();
						 bc.setVirginpulp(virginpulp_om);
						
						 brownwetLap_om = barcode.getBrownwetLap();    
						 bc.setBrownwetLap(brownwetLap_om);
						
						 pulpdryLap_om = barcode.getPulpdryLap();    
						 bc.setPulpdryLap(pulpdryLap_om);
						
						 otherrolls_om  = barcode.getOtherrolls(); 
						 bc.setOtherrolls(otherrolls_om);
						
						 stbaleswetlap_om= barcode.getStbaleswetlap();    
						 bc.setStbaleswetlap(stbaleswetlap_om);
						
						 sttbaledbrokebutl_om=barcode.getSttbaledbrokebutl();
						 bc.setSttbaledbrokebutl(sttbaledbrokebutl_om);
						 
						 
						 virginhardwood_om=barcode.getVirginhardwood();
						 bc.setVirginhardwood(virginhardwood_om);
						 
						 
						 virginsoftwood_om=barcode.getVirginsoftwood();
						 bc.setVirginsoftwood(virginsoftwood_om);
						 
						 
						
						 _total_om=prtmix_om+mwl_om+mcl_om+mwlwigs_om+cbs_om +ctdGdwd_om+swlsortedwhite_om+onpolnNewsprint_om+
								oinews_om+lightprtsbs_om +hw_om+heavyprtsbs_om+sow_om+unprtsbs_om+newsblank_om+
								whitegdwdblend_om+mailundeliverable_om+hoggedbooks_om+occ_om+dlk_om+mixedpaper_om+softwoodchips_om+
								hardwoodchips_om+whitebroke_om+pwe_om+brownnapkinbroke_om +pulpwetlap_om+virginpulp_om +
								brownwetLap_om+otherrolls_om +stbaleswetlap_om+sttbaledbrokebutl_om+pulpdryLap_om+virginhardwood_om+virginsoftwood_om;
						 		bc.setTotal(_total_om);
						
						//Setter Getter Starts From Here For Weight
						
						mwl_omw=barcode.getMwlw();
						bc.setMwlw(mwl_omw);
						 
						prtmix_omw=barcode.getPrtmixw();
						bc.setPrtmixw(prtmix_omw);

						mcl_omw=barcode.getMclw();
						bc.setMclw(mcl_omw);
								 
						mwlwigs_omw=barcode.getMwlwigsw();
						bc.setMwlwigsw(mwlwigs_omw);
								 
						cbs_omw =barcode.getCbsw();
						bc.setCbsw(cbs_omw);
								 
						ctdGdwd_omw =barcode.getCtdGdwdw();
						bc.setCtdGdwdw(ctdGdwd_omw);
						 
						swlsortedwhite_omw=barcode.getSwlsortedwhitew();
						bc.setSwlsortedwhitew(swlsortedwhite_omw);
								 
						 
						onpolnNewsprint_omw=barcode.getOnpolnNewsprintw();
						bc.setOnpolnNewsprintw(onpolnNewsprint_omw);
						 
						 
						oinews_omw =barcode.getOinewsw();
						bc.setOinewsw(oinews_omw);
						 
						lightprtsbs_omw  =barcode.getLightprtsbsw();
						bc.setLightprtsbsw(lightprtsbs_omw);
						 
						hw_omw =barcode.getHww();
						bc.setHww(hw_omw);
						 
						heavyprtsbs_omw =barcode.getHeavyprtsbsw();
						bc.setLightprtsbsw(heavyprtsbs_omw);
								 
						sow_omw=barcode.getSoww();
						bc.setSoww(sow_omw);
						 
						unprtsbs_omw=barcode.getUnprtsbsw();
						bc.setUnprtsbsw(unprtsbs_omw);
						 
						newsblank_omw = barcode.getNewsblankw();
						bc.setNewsblankw(newsblank_omw);
						 
						whitegdwdblend_omw=barcode.getWhitegdwdblendw();
						bc.setWhitegdwdblendw(whitegdwdblend_omw);
						 
						mailundeliverable_omw=barcode.getMailundeliverablew();   
						bc.setMailundeliverablew(mailundeliverable_omw);
						
						hoggedbooks_omw=barcode.getHoggedbooksw();    
						bc.setHoggedbooksw(hoggedbooks_omw);
						
						occ_omw =barcode.getOccw();     
						bc.setOccw(occ_omw);
						 
						dlk_omw= barcode.getDlkw();    
						bc.setDlkw(dlk_omw);
						 
						mixedpaper_omw=barcode.getMixedpaperw();
						bc.setMixedpaperw(mixedpaper_omw);
						 
						softwoodchips_omw=barcode.getSoftwoodchipsw();     
						bc.setSoftwoodchipsw(softwoodchips_omw);
								 
						hardwoodchips_omw=barcode.getHardwoodchipsw();      
						bc.setHardwoodchipsw(hardwoodchips_omw);		 
						
						whitebroke_omw =barcode.getWhitebrokew();     
						bc.setWhitebrokew(whitebroke_omw);
						
						pwe_omw=barcode.getPwew();      
						bc.setPwew(pwe_omw);
						 
						brownnapkinbroke_omw =barcode.getBrownnapkinbrokew();     
						bc.setBrownnapkinbrokew(brownnapkinbroke_omw);
						
						pulpwetlap_omw=barcode.getPulpwetlapw();      
						bc.setPulpwetlapw(pulpwetlap_omw);
						 
						virginpulp_omw =barcode.getVirginpulpw();
						bc.setVirginpulpw(virginpulp_omw);
						
						brownwetLap_omw = barcode.getBrownwetLapw();    
						bc.setBrownwetLapw(brownwetLap_omw);
						
						pulpdryLap_omw = barcode.getPulpdryLapw();    
						bc.setPulpdryLapw(pulpdryLap_omw);
						
						otherrolls_omw  = barcode.getOtherrollsw(); 
						bc.setOtherrollsw(otherrolls_omw);
						
						stbaleswetlap_omw= barcode.getStbaleswetlapw();    
						bc.setStbaleswetlapw(stbaleswetlap_omw);
						
						sttbaledbrokebutl_omw=barcode.getSttbaledbrokebutlw();
						bc.setSttbaledbrokebutlw(sttbaledbrokebutl_omw);
						
						
						
						virginhardwoodw_omw=barcode.getVirginhardwoodw();
						bc.setVirginhardwoodw(virginhardwoodw_omw);


						virginsoftwoodw_omw=barcode.getVirginsoftwoodw();
						bc.setVirginsoftwoodw(virginsoftwoodw_omw);
						
						
						
						_total_omw=prtmix_omw+mwl_omw+mcl_omw+mwlwigs_omw+cbs_omw+ctdGdwd_omw+swlsortedwhite_omw+onpolnNewsprint_omw+
								oinews_omw+lightprtsbs_omw+hw_omw+heavyprtsbs_omw+sow_omw+unprtsbs_omw+newsblank_omw+
								whitegdwdblend_omw+mailundeliverable_omw+hoggedbooks_omw+occ_omw+dlk_omw+mixedpaper_omw+softwoodchips_omw+
								hardwoodchips_omw+whitebroke_omw+pwe_omw+brownnapkinbroke_omw+pulpwetlap_omw+virginpulp_omw+
								brownwetLap_omw+otherrolls_omw+stbaleswetlap_omw+sttbaledbrokebutl_omw+pulpdryLap_omw+virginhardwoodw_omw+virginsoftwoodw_omw;
						 		bc.setTotalweight(_total_omw);
						 		
						barcodeCommans.add(bc);
						model.addAttribute("bc", bc);
					}
					
					
				}catch(Exception rlt){
					System.out.println("You Have Problem in WastePaperBaleInventoryReportDetail.java at OpeningMonth List");
					rlt.printStackTrace();
				}
				
		try{
			//Variables Of Unload And Consume For Bales
			int MWL1 = 0; int MWL2=0;
			int Prt_mix1 = 0; int Prt_mix2=0;
			int MCL1 = 0; int MCL2=0;
			int MWL_W_IGS1 = 0; int MWL_W_IGS2=0;
			int CBS1 = 0; int CBS2=0;
			int Ctd_Gdwd1 = 0; int Ctd_Gdwd2=0;
			int SWL1 = 0; int SWL2=0;
			int ONP1 = 0; int ONP2=0;
			int OI_News1 = 0; int OI_News2=0;
			int Light_Prt_SBS1 = 0; int Light_Prt_SBS2=0;
			int HW1 = 0; int HW2=0;
			int Heavy_Prt_SBS1 = 0; int Heavy_Prt_SBS2=0;
			int SOW1 = 0; int SOW2=0;
			int Unprt_SBS1 = 0; int Unprt_SBS2=0;
			int Newsblank1 = 0; int Newsblank2=0;
			int White_Gdwd_Blend1 = 0; int White_Gdwd_Blend2=0;
			int Mail_Undeliverable1 = 0; int Mail_Undeliverable2=0;
			int Hogged_Books1 = 0; int Hogged_Books2=0;
			int OCC1 = 0; int OCC2=0;
			int DLK1 = 0; int DLK2=0;
			int Mixed_Paper1 = 0; int Mixed_Paper2=0;
			int Soft_Wood_Chips1 = 0; int Soft_Wood_Chips2=0;
			int Hard_Wood_Chips1 = 0; int Hard_Wood_Chips2=0;
			int PWE1 = 0; int PWE2=0;
			int White_Broke1 = 0; int White_Broke2=0;
			int Brown_Napkin_Broke1 = 0; int Brown_Napkin_Broke2=0;
			int PULP_Wet_Lap1 = 0; int PULP_Wet_Lap2=0;
			int Virgin_Pulp1 = 0; int Virgin_Pulp2=0;
			int Brown_Wet_Lap1 = 0; int Brown_Wet_Lap2=0;
			int Pulp_Dry_Lap1 = 0; int Pulp_Dry_Lap2=0;
			int Other_Rolls1 = 0; int Other_Rolls2=0;
			int ST_Bales_wetlap1 = 0; int ST_Bales_wetlap2=0;
			int STT_Baled_Broke_Butl1 = 0; int STT_Baled_Broke_Butl2=0;
			
			
			int Virgin_Hard_Wood_1 = 0; int Virgin_Hard_Wood_2=0;
			int Virgin_Soft_Wood_1 = 0; int Virgin_Soft_Wood_2=0;
			
			int _totalUnloadBales=0;
			int _totalConsumedBales=0;
			
			//Variables Of Unload And Consume For Weight
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
				//Setter Getter For Bales
				MWL1=baleInventory1.getTotalbalesOfMWL()+MWL1;
				 ulb.setTotalbalesOfMWL(MWL1);
				
				Prt_mix1=baleInventory1.getTotalbalesOfPrtmix()+Prt_mix1;
				 ulb.setTotalbalesOfPrtmix(Prt_mix1);
				
				MCL1=baleInventory1.getTotalbalesOfMCL()+MCL1;
				 ulb.setTotalbalesOfPrtmix(MCL1);
				
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
				 ulb.setTotalbalesOfHW(HW1);
				
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
				 Virgin_Hard_Wood_1=baleInventory1.getTotalbalesOfVirginHardWood()+Virgin_Hard_Wood_1;
				 ulb.setTotalbalesOfVirginHardWood(Virgin_Hard_Wood_1);
				 
				 
				 Virgin_Soft_Wood_1=baleInventory1.getTotalbalesOfVirginSoftWood()+Virgin_Soft_Wood_1;
				 ulb.setTotalbalesOfVirginSoftWood(Virgin_Soft_Wood_1);
				
				 //
				 
				_totalUnloadBales=MWL1+Prt_mix1+MCL1+MWL_W_IGS1+CBS1+Ctd_Gdwd1+SWL1+ONP1+OI_News1+Light_Prt_SBS1+
						HW1+Heavy_Prt_SBS1+SOW1+Unprt_SBS1+Newsblank1+White_Gdwd_Blend1+Mail_Undeliverable1+Hogged_Books1+OCC1+DLK1+Mixed_Paper1+
						Soft_Wood_Chips1+Hard_Wood_Chips1+PWE1+White_Broke1+Brown_Napkin_Broke1+PULP_Wet_Lap1+Virgin_Pulp1+Brown_Wet_Lap1+Pulp_Dry_Lap1+
						Other_Rolls1+ST_Bales_wetlap1+STT_Baled_Broke_Butl1+Virgin_Hard_Wood_1+Virgin_Soft_Wood_1;
				ulb.setTotalUnloadBales(_totalUnloadBales);
				
				//Setter Getter For Weight
				
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
				
				//Getter Setter For Bales
				MWL2=baleInventory2.getTotalbalesOfMWL()+MWL2;
				cb.setTotalbalesOfMWL(MWL2);
				
				Prt_mix2=baleInventory2.getTotalbalesOfPrtmix()+Prt_mix2;
				cb.setTotalbalesOfPrtmix(Prt_mix2);
				
				MCL2=baleInventory2.getTotalbalesOfMCL()+MCL2;
				cb.setTotalbalesOfPrtmix(MCL2);
				
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
				
				Virgin_Hard_Wood_2=baleInventory2.getTotalbalesOfVirginHardWood()+Virgin_Hard_Wood_2;
				cb.setTotalbalesOfVirginHardWood(Virgin_Hard_Wood_2);
				
				Virgin_Soft_Wood_2=baleInventory2.getTotalbalesOfVirginSoftWood()+Virgin_Soft_Wood_2;
				cb.setTotalbalesOfVirginSoftWood(Virgin_Soft_Wood_2);
				
				//
				

				_totalConsumedBales=MWL2+Prt_mix2+MCL2+MWL_W_IGS2+CBS2+Ctd_Gdwd2+SWL2+ONP2+OI_News2+Light_Prt_SBS2+
						HW2+Heavy_Prt_SBS2+SOW2+Unprt_SBS2+Newsblank2+White_Gdwd_Blend2+Mail_Undeliverable2+Hogged_Books2+OCC2+DLK2+Mixed_Paper2+
						Soft_Wood_Chips2+Hard_Wood_Chips2+PWE2+White_Broke2+Brown_Napkin_Broke2+PULP_Wet_Lap2+Virgin_Pulp2+Brown_Wet_Lap2+Pulp_Dry_Lap2+
						Other_Rolls2+ST_Bales_wetlap2+STT_Baled_Broke_Butl2+Virgin_Hard_Wood_2+Virgin_Soft_Wood_2;
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
			
			
			
			//Formula :- (Opening+Unload)-(Consume); ,Same Formula Used For Weight Also
			
			//Formula Applied For Bales
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
			
			//New Grade Code Added From Here
			int value67=(virginhardwood_om+Virgin_Hard_Wood_1)-Virgin_Hard_Wood_2;
			int value68=(virginsoftwood_om+Virgin_Soft_Wood_1)-Virgin_Soft_Wood_2;
			
			int _final_ivt_total=(_total_om+_totalUnloadBales)-(_totalConsumedBales);
			
			//Formula Applied For Weight
			
			double value34=(CommonUtil.round(mwl_omw, 2)+CommonUtil.round(MWLW1, 2))-(CommonUtil.round(MWLW2, 2));
			double value35=(CommonUtil.round(prtmix_omw, 2)+CommonUtil.round(Prt_mixW1, 2))-(CommonUtil.round(Prt_mixW2, 2));
			double value36=(CommonUtil.round(mcl_omw, 2)+CommonUtil.round(MCLW1, 2))-(CommonUtil.round(MCLW2, 2));
			double value37=(CommonUtil.round(mwlwigs_omw, 2)+CommonUtil.round(MWL_W_IGSW1, 2))-(CommonUtil.round(MWL_W_IGSW2, 2));
			double value38=(CommonUtil.round(cbs_omw, 2)+CommonUtil.round(CBSW1, 2))-(CommonUtil.round(CBSW2, 2));
			double value39=(CommonUtil.round(ctdGdwd_omw, 2)+CommonUtil.round(Ctd_GdwdW1, 2))-(CommonUtil.round(Ctd_GdwdW2, 2));
			double value40=(CommonUtil.round(swlsortedwhite_omw, 2)+CommonUtil.round(SWLW1, 2))-(CommonUtil.round(SWLW2, 2));
			double value41=(CommonUtil.round(onpolnNewsprint_omw, 2)+CommonUtil.round(ONPW1, 2))-(CommonUtil.round(ONPW2, 2));
			double value42=(CommonUtil.round(oinews_omw, 2)+CommonUtil.round(OI_NewsW1, 2))-(CommonUtil.round(OI_NewsW2, 2));
			double value43=(CommonUtil.round(lightprtsbs_omw, 2)+CommonUtil.round(Light_Prt_SBSW1, 2))-(CommonUtil.round(Light_Prt_SBSW2, 2));
			double value44=(CommonUtil.round(hw_omw, 2)+CommonUtil.round(HWW1, 2))-(CommonUtil.round(HWW2, 2));
			double value45=(CommonUtil.round(heavyprtsbs_omw, 2)+CommonUtil.round(Heavy_Prt_SBSW1, 2))-(CommonUtil.round(Heavy_Prt_SBSW2, 2));
			double value46=(CommonUtil.round(sow_omw, 2)+CommonUtil.round(SOWW1, 2))-(CommonUtil.round(SOWW2, 2));
			double value47=(CommonUtil.round(unprtsbs_omw, 2)+CommonUtil.round(Unprt_SBSW1, 2))-CommonUtil.round(Unprt_SBSW2, 2);
			double value48=(CommonUtil.round(newsblank_omw, 2)+CommonUtil.round(NewsblankW1, 2))-CommonUtil.round(NewsblankW2, 2);
			double value49=(CommonUtil.round(whitegdwdblend_omw, 2)+CommonUtil.round(White_Gdwd_BlendW1, 2))-CommonUtil.round(White_Gdwd_BlendW2, 2);
			double value50=(CommonUtil.round(mailundeliverable_omw, 2)+CommonUtil.round(Mail_UndeliverableW1, 2))-CommonUtil.round(Mail_UndeliverableW2, 2);
			double value51=(CommonUtil.round(hoggedbooks_omw, 2)+CommonUtil.round(Hogged_BooksW1, 2))-CommonUtil.round(Hogged_BooksW2, 2);
			double value52=(CommonUtil.round(occ_omw, 2)+CommonUtil.round(OCCW1, 2))-CommonUtil.round(OCCW2, 2);
			double value53=(CommonUtil.round(dlk_omw, 2)+CommonUtil.round(DLKW1, 2))-CommonUtil.round(DLKW2, 2);
			double value54=(CommonUtil.round(mixedpaper_omw, 2)+CommonUtil.round(Mixed_PaperW1, 2))-CommonUtil.round(Mixed_PaperW2, 2);
			double value55=(CommonUtil.round(softwoodchips_omw, 2)+CommonUtil.round(Soft_Wood_ChipsW1, 2))-CommonUtil.round(Soft_Wood_ChipsW2, 2);
			double value56=(CommonUtil.round(hardwoodchips_omw, 2)+CommonUtil.round(Hard_Wood_ChipsW1, 2))-CommonUtil.round(Hard_Wood_ChipsW2, 2);
			double value57=(CommonUtil.round(pwe_omw, 2)+CommonUtil.round(PWEW1, 2))-CommonUtil.round(PWEW2, 2);
			double value58=(CommonUtil.round(whitebroke_omw, 2)+CommonUtil.round(White_BrokeW1, 2))-CommonUtil.round(White_BrokeW2, 2);
			double value59=(CommonUtil.round(brownnapkinbroke_omw, 2)+CommonUtil.round(Brown_Napkin_BrokeW1, 2))-CommonUtil.round(Brown_Napkin_BrokeW2, 2);
			double value60=(CommonUtil.round(pulpwetlap_omw, 2)+CommonUtil.round(PULP_Wet_LapW1, 2))-CommonUtil.round(PULP_Wet_LapW2, 2);
			double value61=(CommonUtil.round(virginpulp_omw, 2)+CommonUtil.round(Virgin_PulpW1, 2))-CommonUtil.round(Virgin_PulpW2, 2);
			double value62=(CommonUtil.round(brownwetLap_omw, 2)+CommonUtil.round(Brown_Wet_LapW1, 2))-CommonUtil.round(Brown_Wet_LapW2, 2);
			double value63=(CommonUtil.round(pulpdryLap_omw, 2)+CommonUtil.round(Pulp_Dry_LapW1, 2))-CommonUtil.round(Pulp_Dry_LapW2, 2);
			double value64=(CommonUtil.round(otherrolls_omw, 2)+CommonUtil.round(Other_RollsW1, 2))-CommonUtil.round(Other_RollsW2, 2);
			double value65=(CommonUtil.round(stbaleswetlap_omw, 2)+CommonUtil.round(ST_Bales_wetlapW1, 2))-CommonUtil.round(ST_Bales_wetlapW2, 2);
			double value66=(CommonUtil.round(sttbaledbrokebutl_omw, 2)+CommonUtil.round(STT_Baled_Broke_ButlW1, 2))-CommonUtil.round(STT_Baled_Broke_ButlW2, 2);
			
			
			
			double value69=(CommonUtil.round(virginhardwoodw_omw, 2)+CommonUtil.round(Virgin_Hard_WoodW1, 2))-CommonUtil.round(Virgin_Hard_WoodW2, 2);
			double value70=(CommonUtil.round(virginsoftwoodw_omw, 2)+CommonUtil.round(Virgin_Soft_WoodW1, 2))-CommonUtil.round(Virgin_Soft_WoodW2, 2);
			
			
			
			double _final_ivt_total_weight=(CommonUtil.round(_total_omw, 2)+CommonUtil.round(_totalUnloadBalesWeight, 2))-(CommonUtil.round(_totalConsumedBalesWeight, 2));
			
			
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
			
			model.addAttribute("v67", value67);
			model.addAttribute("v68", value68);
			model.addAttribute("v69", value69);
			model.addAttribute("v70", value70);
			
			model.addAttribute("_final_ivt_total", _final_ivt_total);		
			model.addAttribute("_final_ivt_total_weight", _final_ivt_total_weight);
			
			try{
				Calendar c = Calendar.getInstance();
				c.set(Calendar.DAY_OF_MONTH, 1);
				
				/*Calendar cal = Calendar.getInstance();
		        cal.setTime(c.getTime());
				cal.add(Calendar.MONTH, 0);
		        cal.set(Calendar.DATE, 5);
		        Date nextFiveDaysDate = cal.getTime();*/
				
				
		        String dateStart = ""+dateFormat.format(c.getTime());
				String dateStop = ""+dateFormat.format(new Date());
				
				Date d1 = null;
				Date d2 = null;
				
				d1 = dateFormat.parse(dateStart);
				d2 = dateFormat.parse(dateStop);
				
				
				long diff = d2.getTime() - d1.getTime();
				long diffDays = diff / (24 * 60 * 60 * 1000);
				
				//System.out.println("Date Starts::"+dateFormat.format(c.getTime()));
				//System.out.println("Date Stop::"+dateFormat.format(new Date()));
				//System.out.println("diffDays::"+diffDays);
				
				if(diffDays<=5){
					 model.addAttribute("showom", true);
					 String[] monthName = { "January", "February", "March", "April", "May", "June", "July","August", "September", "October", "November", "December" };
					 Calendar cal4 = Calendar.getInstance();
					 cal4.add(Calendar.MONTH, -1);
					 String previousMonth = monthName[cal4.get(Calendar.MONTH)];
					 model.addAttribute("previousMonth", previousMonth);
					 
					 Calendar cal5 = Calendar.getInstance();
					 String currentMonth = monthName[cal5.get(Calendar.MONTH)];
					 model.addAttribute("currentMonth", currentMonth);

				}else{
					 model.addAttribute("showom", false);
				}
				
			}catch(Exception rlt){
				rlt.printStackTrace();
				System.out.println("You Have A Problem During To Get Days Diffrence.");
			}
			
			
			
		
	}catch(Exception rlt){
		System.out.println("Roshan Says, You Have Problem In WastePaperBaleInventoryReportDetailController.java"); 
		rlt.printStackTrace();
	}
		model.addAttribute("startdate", dateFormat.format(startdate));
		model.addAttribute("enddate", dateFormat.format(enddate));
		model.addAttribute(VIEW_PAGE, true);
		
		return "WastePaperBaleInventoryReportDetail";
	}
	@RequestMapping(value="/barCodeOpeningMonthForm/{id}",method=RequestMethod.GET)
	public String openingMonth(@PathVariable("id") @DateTimeFormat(pattern="MM-dd-yyyy") Date date1,Model model) throws Exception{
		//List<WastePaperBaleInventory> openingMonth=wastePaperBaleInventoryService.getClosedMonth(month);
		System.out.println(date1);
		
		/*Calendar cal = Calendar.getInstance();
        cal.setTime(date1);

        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);
        int year = cal.get(Calendar.YEAR);
     
        //New Logic When Years Ennds
        if(month==0){
        	month=month+1;
        }
        
        //Decreasing One Month Starts Here
        System.out.println("Before "+cal.getTime());  

        cal.add(Calendar.MONTH, -1);
        System.out.println("After "+cal.getTime()); 
        //Decreasing One Month Ends Here
        //Date date2= cal.getTime();// Commented By Roshan Tailor
*/        
        

		SimpleDateFormat monthAnd = new SimpleDateFormat("MM");
		SimpleDateFormat yearAnd = new SimpleDateFormat("yyyy");
		
		String monthS=monthAnd.format(date1);
		int month = Integer.parseInt(monthS);
		
		String yearS=yearAnd.format(date1);
		int year = Integer.parseInt(yearS);
		
		
        List<BarcodeComman> openingMonth=wastePaperBaleInventoryService.getClosedMonth(month,year);
        System.out.println("openingMonth Size::"+openingMonth.size());
        model.addAttribute("date", dateFormatSpecial.format(new Date()));
        //model.addAttribute("date", date2);//Commented By Roshan Tailor
        model.addAttribute("openingMonth", openingMonth);
		return "barCodeOpeningMonthForm";
		
	}
	
	
	@RequestMapping(value="/addopeningdata",method=RequestMethod.POST)
	public String save(HttpServletRequest request, HttpServletResponse response,Model model) throws IOException{
		Map<String , Object> map=new HashMap<String,Object>();
		Date date = null;
		List<BarcodeComman> barcodeS=new ArrayList<BarcodeComman>();
		try{
			
			date=CommonUtil.checkDate(request.getParameter("date"),dateFormat);
			
			SimpleDateFormat monthAnd = new SimpleDateFormat("MM");
			SimpleDateFormat yearAnd = new SimpleDateFormat("yyyy");
			 
			String monthS=monthAnd.format(date);
			System.out.println("monthS::"+monthS);
			String yearS=yearAnd.format(date);
		 
			int month = Integer.parseInt(monthS);
			int year = Integer.parseInt(yearS);
			
			System.out.println("Month::"+month);
			System.out.println("Year::"+year);
			

			List<BarcodeComman> openingMonthAvailable=wastePaperUnloadBaleInventoryService.getOpenMonthAvailable(month,year);
			
			//System.out.println("openingMonthAvailable::"+openingMonthAvailable);
			
			
			int prtmix=CommonUtil.checkInt(request.getParameter("prtmix"));
			double prtmixw=CommonUtil.checkDouble(request.getParameter("prtmixw"));
			
			int mwl=CommonUtil.checkInt(request.getParameter("mwl"));
			double mwlw=CommonUtil.checkDouble(request.getParameter("mwlw"));
			
			int mcl=CommonUtil.checkInt(request.getParameter("mcl"));
			double mclw=CommonUtil.checkDouble(request.getParameter("mclw"));
			
			int mwlwigs=CommonUtil.checkInt(request.getParameter("mwlwigs"));
			double mwlwigsw=CommonUtil.checkDouble(request.getParameter("mwlwigsw"));
			
			int cbs=CommonUtil.checkInt(request.getParameter("cbs"));
			double cbsw=CommonUtil.checkDouble(request.getParameter("cbsw"));
			
			int ctdgdwd=CommonUtil.checkInt(request.getParameter("ctdgdwd"));
			double ctdgdwdw=CommonUtil.checkDouble(request.getParameter("ctdgdwdw"));
			
			int swlsortedwhite=CommonUtil.checkInt(request.getParameter("swlsortedwhite"));
			double swlsortedwhitew=CommonUtil.checkDouble(request.getParameter("swlsortedwhitew"));
			
			int onpolnNewsprint=CommonUtil.checkInt(request.getParameter("onpolnNewsprint"));
			double onpolnNewsprintw=CommonUtil.checkDouble(request.getParameter("onpolnNewsprintw"));
			
			int oinews=CommonUtil.checkInt(request.getParameter("oinews"));
			double oinewsw=CommonUtil.checkDouble(request.getParameter("oinewsw"));
			
			int lightprtsbs=CommonUtil.checkInt(request.getParameter("lightprtsbs"));
			double lightprtsbsw=CommonUtil.checkDouble(request.getParameter("lightprtsbsw"));
			
			int hw=CommonUtil.checkInt(request.getParameter("hw"));
			double hww=CommonUtil.checkDouble(request.getParameter("hww"));
			
			int heavyprtsbs=CommonUtil.checkInt(request.getParameter("heavyprtsbs"));
			double heavyprtsbsw=CommonUtil.checkDouble(request.getParameter("heavyprtsbsw"));
			
			int sow=CommonUtil.checkInt(request.getParameter("sow"));
			double soww=CommonUtil.checkDouble(request.getParameter("soww"));
			
			int unprtsbs=CommonUtil.checkInt(request.getParameter("unprtsbs"));
			double unprtsbsw=CommonUtil.checkDouble(request.getParameter("unprtsbsw"));
			
			int newsblank=CommonUtil.checkInt(request.getParameter("newsblank"));
			double newsblankw=CommonUtil.checkDouble(request.getParameter("newsblankw"));
			
			int whitegdwdblend=CommonUtil.checkInt(request.getParameter("whitegdwdblend"));
			double whitegdwdblendw=CommonUtil.checkDouble(request.getParameter("whitegdwdblendw"));
			
			int mailundeliverable=CommonUtil.checkInt(request.getParameter("mailundeliverable"));
			double mailundeliverablew=CommonUtil.checkDouble(request.getParameter("mailundeliverablew"));
			
			int hoggedbooks=CommonUtil.checkInt(request.getParameter("hoggedbooks"));
			double hoggedbooksw=CommonUtil.checkDouble(request.getParameter("hoggedbooksw"));
			
			int occ=CommonUtil.checkInt(request.getParameter("occ"));
			double occw=CommonUtil.checkDouble(request.getParameter("occw"));
			
			int dlk=CommonUtil.checkInt(request.getParameter("dlk"));
			double dlkw=CommonUtil.checkDouble(request.getParameter("dlkw"));
			
			int mixedpaper=CommonUtil.checkInt(request.getParameter("mixedpaper"));
			double mixedpaperw=CommonUtil.checkDouble(request.getParameter("mixedpaperw"));
			
			int softwoodchips=CommonUtil.checkInt(request.getParameter("softwoodchips"));
			double softwoodchipsw=CommonUtil.checkDouble(request.getParameter("softwoodchipsw"));
			
			int hardwoodchips=CommonUtil.checkInt(request.getParameter("hardwoodchips"));
			double hardwoodchipsw=CommonUtil.checkDouble(request.getParameter("hardwoodchipsw"));
			
			int whitebroke=CommonUtil.checkInt(request.getParameter("whitebroke"));
			double whitebrokew=CommonUtil.checkDouble(request.getParameter("whitebrokew"));
			
			int pwe=CommonUtil.checkInt(request.getParameter("pwe"));
			double pwew=CommonUtil.checkDouble(request.getParameter("pwew"));
			
			int brownnapkinbroke=CommonUtil.checkInt(request.getParameter("brownnapkinbroke"));
			double brownnapkinbrokew=CommonUtil.checkDouble(request.getParameter("brownnapkinbrokew"));
			
			int pulpwetlap=CommonUtil.checkInt(request.getParameter("pulpwetlap"));
			double pulpwetlapw=CommonUtil.checkDouble(request.getParameter("pulpwetlapw"));
			
			int virginpulp=CommonUtil.checkInt(request.getParameter("virginpulp"));
			double virginpulpw=CommonUtil.checkDouble(request.getParameter("virginpulpw"));
			
			int brownwetLap=CommonUtil.checkInt(request.getParameter("brownwetLap"));
			double brownwetLapw=CommonUtil.checkDouble(request.getParameter("brownwetLapw"));
			
			int pulpdryLap=CommonUtil.checkInt(request.getParameter("pulpdryLap"));
			double pulpdryLapw=CommonUtil.checkDouble(request.getParameter("pulpdryLapw"));
			
			int otherrolls=CommonUtil.checkInt(request.getParameter("otherrolls"));
			double otherrollsw=CommonUtil.checkDouble(request.getParameter("otherrollsw"));
			
			int stbaleswetlap=CommonUtil.checkInt(request.getParameter("stbaleswetlap"));
			double stbaleswetlapw=CommonUtil.checkDouble(request.getParameter("stbaleswetlapw"));
			
			int sttbaledbrokebutl=CommonUtil.checkInt(request.getParameter("sttbaledbrokebutl"));
			double sttbaledbrokebutlw=CommonUtil.checkDouble(request.getParameter("sttbaledbrokebutlw"));
			
			int virginhardwood=CommonUtil.checkInt(request.getParameter("virginhardwood"));
			double virginhardwoodw=CommonUtil.checkDouble(request.getParameter("virginhardwoodw"));

			int virginsoftwood=CommonUtil.checkInt(request.getParameter("virginsoftwood"));
			double virginsoftwoodw=CommonUtil.checkDouble(request.getParameter("virginsoftwoodw"));
			
			final BarcodeComman barcodeComman=new BarcodeComman();
			//final BarcodeComman bc=new BarcodeComman();
			  barcodeComman.setClosemonth(month);
			  barcodeComman.setCloseyear(year);
			  barcodeComman.setPrtmix(prtmix);
			  barcodeComman.setMwl(mwl);
			  barcodeComman.setMwlwigs(mwlwigs);      
			  barcodeComman.setMcl(mcl);      
			  barcodeComman.setMwlwigs(mwlwigs);      
			  barcodeComman.setCbs(cbs);      
			  barcodeComman.setCtdGdwd(ctdgdwd);      
			  barcodeComman.setSwlsortedwhite(swlsortedwhite);      
			  barcodeComman.setOnpolnNewsprint(onpolnNewsprint);      
			  barcodeComman.setOinews(oinews);      
			  barcodeComman.setLightprtsbs(lightprtsbs);      
			  barcodeComman.setHw(hw);      
			  barcodeComman.setHeavyprtsbs(heavyprtsbs);      
			  barcodeComman.setSow(sow);      
			  barcodeComman.setUnprtsbs(unprtsbs);      
			  barcodeComman.setNewsblank(newsblank);      
			  barcodeComman.setWhitegdwdblend(whitegdwdblend);      
			  barcodeComman.setMailundeliverable(mailundeliverable);      
			  barcodeComman.setHoggedbooks(hoggedbooks);      
			  barcodeComman.setOcc(occ);      
			  barcodeComman.setDlk(dlk);      
			  barcodeComman.setMixedpaper(mixedpaper);      
			  barcodeComman.setSoftwoodchips(softwoodchips);      
			  barcodeComman.setHardwoodchips(hardwoodchips);      
			  barcodeComman.setWhitebroke(whitebroke);      
			  barcodeComman.setPwe(pwe);      
			  barcodeComman.setBrownnapkinbroke(brownnapkinbroke);      
			  barcodeComman.setPulpwetlap(pulpwetlap);      
			  barcodeComman.setVirginpulp(virginpulp);      
			  barcodeComman.setBrownwetLap(brownwetLap);      
			  barcodeComman.setPulpdryLap(pulpdryLap);      
			  barcodeComman.setOtherrolls(otherrolls);      
			  barcodeComman.setStbaleswetlap(stbaleswetlap);      
			  barcodeComman.setSttbaledbrokebutl(sttbaledbrokebutl);
			  
			  barcodeComman.setVirginhardwood(virginhardwood);  
			  barcodeComman.setVirginsoftwood(virginsoftwood);
			  
			  //set for Weight
			  barcodeComman.setPrtmixw(prtmixw);    
			  barcodeComman.setMwlw(mwlw);
			  barcodeComman.setMwlwigs(mwlwigs);
			  barcodeComman.setMclw(mclw);      
			  barcodeComman.setMwlwigsw(mwlwigsw);     
			  barcodeComman.setCbsw(cbsw);      
			  barcodeComman.setCtdGdwdw(ctdgdwdw);      
			  barcodeComman.setSwlsortedwhitew(swlsortedwhitew);      
			  barcodeComman.setOnpolnNewsprintw(onpolnNewsprintw);      
			  barcodeComman.setOinewsw(oinewsw);      
			  barcodeComman.setLightprtsbsw(lightprtsbsw);      
			  barcodeComman.setHww(hww);      
			  barcodeComman.setHeavyprtsbsw(heavyprtsbsw);      
			  barcodeComman.setSoww(soww);      
			  barcodeComman.setUnprtsbsw(unprtsbsw);      
			  barcodeComman.setNewsblankw(newsblankw);      
			  barcodeComman.setWhitegdwdblendw(whitegdwdblendw);      
			  barcodeComman.setMailundeliverablew(mailundeliverablew);      
			  barcodeComman.setHoggedbooksw(hoggedbooksw);      
			  barcodeComman.setOccw(occw);      
			  barcodeComman.setDlkw(dlkw);      
			  barcodeComman.setMixedpaperw(mixedpaperw);      
			  barcodeComman.setSoftwoodchipsw(softwoodchipsw);      
			  barcodeComman.setHardwoodchipsw(hardwoodchipsw);      
			  barcodeComman.setWhitebrokew(whitebrokew);      
			  barcodeComman.setPwew(pwew);      
			  barcodeComman.setBrownnapkinbrokew(brownnapkinbrokew);      
			  barcodeComman.setPulpwetlapw(pulpwetlapw);      
			  barcodeComman.setVirginpulpw(virginpulpw);      
			  barcodeComman.setBrownwetLapw(brownwetLapw);      
			  barcodeComman.setPulpdryLapw(pulpdryLapw);      
			  barcodeComman.setOtherrollsw(otherrollsw);      
			  barcodeComman.setStbaleswetlapw(stbaleswetlapw);      
			  barcodeComman.setSttbaledbrokebutlw(sttbaledbrokebutlw);
			  
			  barcodeComman.setVirginhardwoodw(virginhardwoodw);   
			  barcodeComman.setVirginsoftwoodw(virginsoftwoodw);
			  
			  try{
				  if(date==null){
					  model.addAttribute("message", "Please Select Date");
				  }else{
					  if(openingMonthAvailable.size()==0){
							System.out.println("Insert");
							int key=wastePaperBaleInventoryService.save(barcodeComman);
							map.put("id", key);
							map.put("status", true);
							model.addAttribute("message", "Data Saved Successfully");
							//map.put("message", "Data Saved Successfully");
						}else{
							System.out.println("Update");
							wastePaperBaleInventoryService.update(barcodeComman);
							map.put("status", true);
							model.addAttribute("message", "Data Updated Successfully");
							//map.put("message", "Data Updated Successfully");
						}
				  }
				   
			  }catch(Exception r){
				  r.printStackTrace();
			  }
			
			 // barcodeS.add(barcodeComman);
			  //model.addAttribute("bcload", barcodeComman);
			  
		}catch(Exception rlt){
			System.out.println("Roshan Says, You Have A Problem In /addopeiningdata Method");
			rlt.printStackTrace();
		}
		
		return "barCodeOpeningMonthForm";
	}
@RequestMapping(value="/export",method=RequestMethod.POST)
	public void export(@RequestParam("startdate")String sdate,
			@RequestParam("enddate")String edate,
			HttpServletResponse response,HttpServletRequest request) throws Exception{
		System.out.println("Exporting...");
		
		
		Date startdate=CommonUtil.checkDate(sdate, dateFormat);
		Date enddate=CommonUtil.checkDate(edate, dateFormat);
		
		/*System.out.println(sdate);
		System.out.println(edate);
		System.out.println(startdate);
		System.out.println(enddate);*/
		
		List<WastePaperBaleInventory> unloadbalesdata=wastePaperBaleInventoryService.getUnloadBales(startdate,enddate);		
		List<WastePaperBaleInventory> consumedBalesData=wastePaperUnloadBaleInventoryService.getConsumedData(startdate,enddate);
		 SimpleDateFormat monthAnd = new SimpleDateFormat("MM");
		 SimpleDateFormat yearAnd = new SimpleDateFormat("yyyy");
		 
		 String monthS=monthAnd.format(startdate);
		 int month = Integer.parseInt(monthS);
		 /*if(month==1){
			 month=2;
		 }*/
		 
		 String yearS=yearAnd.format(startdate);
		 int year = Integer.parseInt(yearS);
		/*List<BarcodeComman> openingMonth=wastePaperUnloadBaleInventoryService.getOpenMonth(month-1,year);*/
		 List<BarcodeComman> openingMonth=wastePaperUnloadBaleInventoryService.getOpenMonth(month,year);
		response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
		response.setHeader("Content-Disposition", "attachment; filename=Barcode_Inventory_Report-Detail.xlsx");
		File file=new File(context.getRealPath("/")+"WEB-INF/Barcode_Inventory_Report-Detail.xlsx");
		
		barcodeInvetoryReportDetailHandler.getBarcodeInventoryReportDetail(unloadbalesdata,consumedBalesData,openingMonth,file,response.getOutputStream());
		
			
		}
	
}

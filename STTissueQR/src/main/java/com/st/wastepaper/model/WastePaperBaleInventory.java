/**
 *Jul 8, 2015
 *WastePaperBaleInventory.java
 * TODO
 *com.st.wastepaperunloadbale.model
 *WastePaperBaleInventory.java
 *Sunil Singh Bora
 */
package com.st.wastepaper.model;

import java.util.Date;

/**
 * @author roshan
 *
 */
public class WastePaperBaleInventory {
	private Date date;
	private int id;
	private String mwl;
	private String pmix;
	private String mcl;
	private String mwlwigs;
	private String cbs;
	private String ctdgdwd;
	private String unctdflyleafshvgs;
	private String lightprtsbs;
	private String hw;
	private String heavyprtsbs;
	private String sow;
	private String newsblank;
	private String occcorrugated;
	private String mixedpaper;
	private String softwoodchips;
	private String hardwoodchips;
	private String pwe;
	private String pulpwetlap;
	private String virginpulp;
	private String pulpdrylap;
	private String other;
	private String otherrolls;
	private String stbaleswetlap;
	private String virginSoftWood;
	private String virginHardWood;
	private String virginEucalyptus;
	private String scnNews;
	private String virginSW_Fluff;
	
	private int totalbalesOfmwl;
	private double totalbalesweightOfmwl;
	
	private int totalbalesOfpmix;
	private double totalbalesweightOfpmix;
	
	private int totalbalesOfmcl;
	private double totalbalesweightOfmcl;
	
	private int totalbalesOfmwlwigs;
	private double totalbalesweightOfmwlwigs;
	
	private int totalbalesOfcbs;
	private double totalbalesweightOfcbs;
	
	private int totalbalesOfctdgdwd;
	private double totalbalesweightOfctdgdwd;
	
	private int totalbalesOfswl;
	private double totalbalesweightOfswl;
	
	private int totalbalesOfunctdflyleafshvgs;
	private double totalbalesweightOfunctdflyleafshvgs;
	
	private int totalbalesOflightprtsbs;
	private double totalbalesweightOflightprtsbs;
	
	private int totalbalesOfhw;
	private double totalbalesweightOfhw;
	
	private int totalbalesOfheavyprtsbs;
	private double totalbalesweightOfheavyprtsbs;
	
	private int totalbalesOfsow;
	private double totalbalesweightOfsow;
	
	private int totalbalesOfnewsblank;
	private double totalbalesweightOfnewsblank;
	
	private int totalbalesOfocccorrugated;
	private double totalbalesweightOfocccorrugated;
	
	private int totalbalesOfdlk;
	private double totalbalesweightOfdlk;
	
	private int totalbalesOfmixedpaper;
	private double totalbalesweightOfmixedpaper;
	
	private int totalbalesOfsoftwoodchips;
	private double totalbalesweightOfsoftwoodchips;
	
	private int totalbalesOfhardwoodchips;
	private double totalbalesweightOfhardwoodchips;
	
	private int totalbalesOfpwe;
	private double totalbalesweightOfpwe;
	
	private int totalbalesOfpulpwetlap;
	private double totalbalesweightOfpulpwetlap;
	
	private int totalbalesOfvirginpulp;
	private double totalbalesweightOfvirginpulp;
	
	private int totalbalesOfpulpdrylap;
	private double totalbalesweightOfpulpdrylap;
	
	private int totalbalesOfother;
	private double totalbalesweightOfother;
	
	private int totalbalesOfotherrolls;
	private double totalbalesweightOfotherrolls;
	
	private int totalbalesOfstbaleswetlap;
	private double totalbalesweightOfstbaleswetlap;
	
	private int totalbalesOflooseest;
	private double totalbalesweightOflooseest;
	
	
	//Code Starts From Here Done For Final Total Of All Date
	
	  private int FtotalbalesOfmwl;
	  private double FtotalbalesweightOfmwl;
	
	  private int FtotalbalesOfpmix;
	  private double FtotalbalesweightOfpmix;
	
	  private int FtotalbalesOfmcl;
	  private double FtotalbalesweightOfmcl;
	
	  private int FtotalbalesOfmwlwigs;
	  private double FtotalbalesweightOfmwlwigs;
	
	  private int FtotalbalesOfcbs;
	  private double FtotalbalesweightOfcbs;
	
	  private int FtotalbalesOfctdgdwd;
	  private double FtotalbalesweightOfctdgdwd;
	
	  private int FtotalbalesOfswl;
	  private double FtotalbalesweightOfswl;
	
	  private int FtotalbalesOfunctdflyleafshvgs;
	  private double FtotalbalesweightOfunctdflyleafshvgs;
	
	  private int FtotalbalesOflightprtsbs;
	  private double FtotalbalesweightOflightprtsbs;
	
	  private int FtotalbalesOfhw;
	  private double FtotalbalesweightOfhw;
	
	  private int FtotalbalesOfheavyprtsbs;
	  private double FtotalbalesweightOfheavyprtsbs;
	
	  private int FtotalbalesOfsow;
	  private double FtotalbalesweightOfsow;
	
	  private int FtotalbalesOfnewsblank;
	  private double FtotalbalesweightOfnewsblank;
	
	  private int FtotalbalesOfocccorrugated;
	  private double FtotalbalesweightOfocccorrugated;
	
	  private int FtotalbalesOfdlk;
	  private double FtotalbalesweightOfdlk;
	
	  private int FtotalbalesOfmixedpaper;
	  private double FtotalbalesweightOfmixedpaper;
	
	  private int FtotalbalesOfsoftwoodchips;
	  private double FtotalbalesweightOfsoftwoodchips;
	
	  private int FtotalbalesOfhardwoodchips;
	  private double FtotalbalesweightOfhardwoodchips;
	
	  private int FtotalbalesOfpwe;
	  private double FtotalbalesweightOfpwe;
	
	  private int FtotalbalesOfpulpwetlap;
	  private double FtotalbalesweightOfpulpwetlap;
	
	  private int FtotalbalesOfvirginpulp;
	  private double FtotalbalesweightOfvirginpulp;
	
	  private int FtotalbalesOfpulpdrylap;
	  private double FtotalbalesweightOfpulpdrylap;
	
	  private int FtotalbalesOfother;
	  private double FtotalbalesweightOfother;
	
	  private int FtotalbalesOfotherrolls;
	  private double FtotalbalesweightOfotherrolls;
	
	  private int FtotalbalesOfstbaleswetlap;
	  private double FtotalbalesweightOfstbaleswetlap;
	  
	  private double totalbalesweightofVirginSoftWood=0;
	  private int totalbalesofVirginSoftWood=0;
		
	  private double totalbalesweightofVirginHardWood=0;
	  private int totalbalesofVirginHardWood=0;
		
	  private double totalbalesweightofVirginEucalyptus=0;
	  private int totalbalesofVirginEucalyptus=0;
	  
	  private double totalbalesweightofScnNews=0;
	  private int totalbalesofScnNews =0;
		
	  private double totalbalesweightofVirginSW_Fluff=0;
	  private int totalbalesofVirginSW_Fluff=0;
	  
	  //Column Added For Temp. tables
	  private Date consumeddate;
	  private Date consumedtime;
	  private double baleweight;
	  private int gradecode;
	  private Date consumeddatetime;
	
	  //Variable For FRP Data Location
	 
	  
	  
	  private double yieldbroke;
	  private double yieldcgwd;
	  private double yieldcgwdsection;
	  private double yieldsw;
	  private double yieldwhitebland;
	  private double yieldwhiteblend;
	  private double yieldstbaleswetLap;
	  private double yieldscavirginpulp;
	  private double yieldtrimloss;
	  private double yieldtotalofpulpar3;
	  private double yieldtotalofpulpar4;
	  private double yieldtotalmillproduction;
	  private double stvirginproduction;
	private int serialnumber;
	
	private double sowweight;
	private int brownnapkinbroke;
	private double brownnapkinbrokeweight;
	private int hogggedbooks;
	private double hogggedbooksweight;
	private int swl;
	private double swlweight;
	private int occ;
	private double occweight;
	private int dlk;
	private double dlkweight;
	private int mpp;
	private double mppweight;
	private int totalbales;
	private double totalbalesweight;
	private long GradeCode;
	private String Grade;
	private String GlDesc;
	private String DescNotes;
	private double totalbalesweightForSWL;
	private int totalbalesOfSWL;
	
	private double totalbalesweightForMWL;
	private int totalbalesOfMWL;
	
	private double totalbalesweightForPrtmix;
	private int totalbalesOfPrtmix;
	
	private double totalbalesweightForMCL;
	private int totalbalesOfMCL;

	private double totalbalesweightForMWLWorIGS;
	private int totalbalesOfMWLWorIGS;
	
	private double totalbalesweightForCBS;
	private int totalbalesOfCBS;
	
	private double totalbalesweightForCtdGdwd;
	private int totalbalesOfCtdGdwd;
	
	private double totalbalesweightForSWLSortedWhite;
	private int totalbalesOfSWLSortedWhite;
	
	private double totalbalesweightForONPOldNewsPrint;
	private int totalbalesOfONPOldNewsPrint;
	
	private double totalbalesweightForOINews;
	private int totalbalesOfOINews;
	
	private double totalbalesweightForLightPrtSBS;
	private int totalbalesOfLightPrtSBS;
	
	private double totalbalesweightForHW;
	private int totalbalesOfHW;
	
	private double totalbalesweightForHeavyPrtSBS;
	private int totalbalesOfHeavyPrtSBS;
	
	private double totalbalesweightForSOW;
	private int totalbalesOfSOW;
	
	private double totalbalesweightForUnprtSBS;
	private int totalbalesOfUnprtSBS;
	
	private double totalbalesweightForNewsblank;
	private int totalbalesOfNewsblank;
	
	private double totalbalesweightForWhiteGdwdBlend;
	private int totalbalesOfWhiteGdwdBlend;
	
	private double totalbalesweightForMailUndeliverable;
	private int totalbalesOfMailUndeliverable;
	
	private double totalbalesweightForHoggedBooks;
	private int totalbalesOfHoggedBooks;
	
	private double totalbalesweightForOCC;
	private int totalbalesOfOCC;
	
	private double totalbalesweightForDLK;
	private int totalbalesOfDLK;
	
	private double totalbalesweightForMixedPaper;
	private int totalbalesOfMixedPaper;
	
	private double totalbalesweightForSoftWoodChips;
	private int totalbalesOfSoftWoodChips;
	
	private double totalbalesweightForHardWoodChips;
	private int totalbalesOfHardWoodChips;

	private double totalbalesweightForPWE;
	private int totalbalesOfPWE;
	
	private double totalbalesweightForWhiteBroke;
	private int totalbalesOfWhiteBroke;
	
	private double totalbalesweightForBrownNapkinBroke;
	private int totalbalesOfBrownNapkinBroke;
	
	private double totalbalesweightForPULPWetLap;
	private int totalbalesOfPULPWetLap;
	
	private double totalbalesweightForVirginPulp;
	private int totalbalesOfVirginPulp;
	
	private double totalbalesweightForBrownWetLap;
	private int totalbalesOfBrownWetLap;

	
	private double totalbalesweightForPulpDryLap;
	private int totalbalesOfPulpDryLap;
	
	private double totalbalesweightForOtherRolls;
	private int totalbalesOfOtherRolls;
	
	
	private double totalbalesweightForSTBaleswetlap;
	private int totalbalesOfSTBaleswetlap;
	
	
	private double totalbalesweightForSTTBaledBroke;
	private int totalbalesOfSTTBaledBroke;
	
	private int totalConsumedBales;
	private int totalUnloadBales;
	
	private double totalconsumedbalesweight;
	private double totalunloadbalesweight;
	
	private double totalbalesweightForBoxboardClippings;
	private int totalbalesOfBoxboardClippings;
	
	//Starts Column Add Later
	private String lotcolor;
	
	
	private int stt_wetlapbales_pm6_white;
	private int stt_wetlapbales_pm6_brown;
	
	private double stt_wetlapbales_pm6_white_weight;
	
	/*New Grade Code Added Starts From Here 14-11-2017*/
	
	private double totalbalesweightForVirginHardWood;
	private int totalbalesOfVirginHardWood;
	
	
	private double totalbalesweightForVirginSoftWood;
	private int totalbalesOfVirginSoftWood;
	
	private double totalbalesweightForHardWhite;
	private int totalbalesOfHardWhite;
	private double totalbalesweightForVirginequalypuHW;
	private int totalbalesOfVirginequalypuHW;
	
	/**
	 * @return the totalbalesweightForBoxboardClippings
	 */
	public double getTotalbalesweightForBoxboardClippings() {
		return totalbalesweightForBoxboardClippings;
	}
	/**
	 * @param totalbalesweightForBoxboardClippings the totalbalesweightForBoxboardClippings to set
	 */
	public void setTotalbalesweightForBoxboardClippings(double totalbalesweightForBoxboardClippings) {
		this.totalbalesweightForBoxboardClippings = totalbalesweightForBoxboardClippings;
	}
	/**
	 * @return the totalbalesOfBoxboardClippings
	 */
	public int getTotalbalesOfBoxboardClippings() {
		return totalbalesOfBoxboardClippings;
	}
	/**
	 * @param totalbalesOfBoxboardClippings the totalbalesOfBoxboardClippings to set
	 */
	public void setTotalbalesOfBoxboardClippings(int totalbalesOfBoxboardClippings) {
		this.totalbalesOfBoxboardClippings = totalbalesOfBoxboardClippings;
	}
	
	/**
	 * @return the stt_wetlapbales_pm6_white
	 */
	public int getStt_wetlapbales_pm6_white() {
		return stt_wetlapbales_pm6_white;
	}
	/**
	 * @param stt_wetlapbales_pm6_white the stt_wetlapbales_pm6_white to set
	 */
	public void setStt_wetlapbales_pm6_white(int stt_wetlapbales_pm6_white) {
		this.stt_wetlapbales_pm6_white = stt_wetlapbales_pm6_white;
	}
	/**
	 * @return the stt_wetlapbales_pm6_brown
	 */
	public int getStt_wetlapbales_pm6_brown() {
		return stt_wetlapbales_pm6_brown;
	}
	/**
	 * @param stt_wetlapbales_pm6_brown the stt_wetlapbales_pm6_brown to set
	 */
	public void setStt_wetlapbales_pm6_brown(int stt_wetlapbales_pm6_brown) {
		this.stt_wetlapbales_pm6_brown = stt_wetlapbales_pm6_brown;
	}
	/**
	 * @return the stt_wetlapbales_pm6_white_weight
	 */
	public double getStt_wetlapbales_pm6_white_weight() {
		return stt_wetlapbales_pm6_white_weight;
	}
	/**
	 * @param stt_wetlapbales_pm6_white_weight the stt_wetlapbales_pm6_white_weight to set
	 */
	public void setStt_wetlapbales_pm6_white_weight(
			double stt_wetlapbales_pm6_white_weight) {
		this.stt_wetlapbales_pm6_white_weight = stt_wetlapbales_pm6_white_weight;
	}
	/**
	 * @return the stt_wetlapbales_pm6_brown_weight
	 */
	public double getStt_wetlapbales_pm6_brown_weight() {
		return stt_wetlapbales_pm6_brown_weight;
	}
	/**
	 * @param stt_wetlapbales_pm6_brown_weight the stt_wetlapbales_pm6_brown_weight to set
	 */
	public void setStt_wetlapbales_pm6_brown_weight(
			double stt_wetlapbales_pm6_brown_weight) {
		this.stt_wetlapbales_pm6_brown_weight = stt_wetlapbales_pm6_brown_weight;
	}
	private double stt_wetlapbales_pm6_brown_weight;
	
	private int total_cbod_bales;
	
	private double total_cbod_weight;
	//Ends Column Add Later
	
	//Added New Columns Which Are Also In WastePaperDetail.Java Starts From Here 
	private double netTons;
	private int bales;
	//Added New Columns Which Are Also In WastePaperDetail.Java Ends Here 
	/**
	 * @return the serialnumber
	 */
	public int getSerialnumber() {
		return serialnumber;
	}
	/**
	 * @param serialnumber the serialnumber to set
	 */
	public void setSerialnumber(int serialnumber) {
		this.serialnumber = serialnumber;
	}
	
	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}
	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}
	
	/**
	 * @return the sowweight
	 */
	public double getSowweight() {
		return sowweight;
	}
	/**
	 * @param sowweight the sowweight to set
	 */
	public void setSowweight(double sowweight) {
		this.sowweight = sowweight;
	}
	/**
	 * @return the brownnapkinbroke
	 */
	public int getBrownnapkinbroke() {
		return brownnapkinbroke;
	}
	/**
	 * @param brownnapkinbroke the brownnapkinbroke to set
	 */
	public void setBrownnapkinbroke(int brownnapkinbroke) {
		this.brownnapkinbroke = brownnapkinbroke;
	}
	/**
	 * @return the brownnapkinbrokeweight
	 */
	public double getBrownnapkinbrokeweight() {
		return brownnapkinbrokeweight;
	}
	/**
	 * @param brownnapkinbrokeweight the brownnapkinbrokeweight to set
	 */
	public void setBrownnapkinbrokeweight(double brownnapkinbrokeweight) {
		this.brownnapkinbrokeweight = brownnapkinbrokeweight;
	}
	/**
	 * @return the hogggedbooks
	 */
	public int getHogggedbooks() {
		return hogggedbooks;
	}
	/**
	 * @param hogggedbooks the hogggedbooks to set
	 */
	public void setHogggedbooks(int hogggedbooks) {
		this.hogggedbooks = hogggedbooks;
	}
	/**
	 * @return the hogggedbooksweight
	 */
	public double getHogggedbooksweight() {
		return hogggedbooksweight;
	}
	/**
	 * @param hogggedbooksweight the hogggedbooksweight to set
	 */
	public void setHogggedbooksweight(double hogggedbooksweight) {
		this.hogggedbooksweight = hogggedbooksweight;
	}
	/**
	 * @return the swl
	 */
	public int getSwl() {
		return swl;
	}
	/**
	 * @param swl the swl to set
	 */
	public void setSwl(int swl) {
		this.swl = swl;
	}
	/**
	 * @return the swlweight
	 */
	public double getSwlweight() {
		return swlweight;
	}
	/**
	 * @param swlweight the swlweight to set
	 */
	public void setSwlweight(double swlweight) {
		this.swlweight = swlweight;
	}
	/**
	 * @return the occ
	 */
	public int getOcc() {
		return occ;
	}
	/**
	 * @param occ the occ to set
	 */
	public void setOcc(int occ) {
		this.occ = occ;
	}
	/**
	 * @return the occweight
	 */
	public double getOccweight() {
		return occweight;
	}
	/**
	 * @param occweight the occweight to set
	 */
	public void setOccweight(double occweight) {
		this.occweight = occweight;
	}
	/**
	 * @return the dlk
	 */
	public int getDlk() {
		return dlk;
	}
	/**
	 * @param dlk the dlk to set
	 */
	public void setDlk(int dlk) {
		this.dlk = dlk;
	}
	/**
	 * @return the dlkweight
	 */
	public double getDlkweight() {
		return dlkweight;
	}
	/**
	 * @param dlkweight the dlkweight to set
	 */
	public void setDlkweight(double dlkweight) {
		this.dlkweight = dlkweight;
	}
	/**
	 * @return the mpp
	 */
	public int getMpp() {
		return mpp;
	}
	/**
	 * @param mpp the mpp to set
	 */
	public void setMpp(int mpp) {
		this.mpp = mpp;
	}
	/**
	 * @return the mppweight
	 */
	public double getMppweight() {
		return mppweight;
	}
	/**
	 * @param mppweight the mppweight to set
	 */
	public void setMppweight(double mppweight) {
		this.mppweight = mppweight;
	}
	/**
	 * @return the totalbales
	 */
	public int getTotalbales() {
		return totalbales;
	}
	/**
	 * @param totalbales the totalbales to set
	 */
	public void setTotalbales(int totalbales) {
		this.totalbales = totalbales;
	}
	/**
	 * @return the totalbalesweight
	 */
	public double getTotalbalesweight() {
		return totalbalesweight;
	}
	/**
	 * @param totalbalesweight the totalbalesweight to set
	 */
	public void setTotalbalesweight(double totalbalesweight) {
		this.totalbalesweight = totalbalesweight;
	}
	/**
	 * @return the gradeCode
	 */
	public long getGradeCode() {
		return GradeCode;
	}
	/**
	 * @param gradeCode the gradeCode to set
	 */
	public void setGradeCode(long gradeCode) {
		GradeCode = gradeCode;
	}
	/**
	 * @return the grade
	 */
	public String getGrade() {
		return Grade;
	}
	/**
	 * @param grade the grade to set
	 */
	public void setGrade(String grade) {
		Grade = grade;
	}
	/**
	 * @return the glDesc
	 */
	public String getGlDesc() {
		return GlDesc;
	}
	/**
	 * @param glDesc the glDesc to set
	 */
	public void setGlDesc(String glDesc) {
		GlDesc = glDesc;
	}
	/**
	 * @return the descNotes
	 */
	public String getDescNotes() {
		return DescNotes;
	}
	/**
	 * @param descNotes the descNotes to set
	 */
	public void setDescNotes(String descNotes) {
		DescNotes = descNotes;
	}
	/**
	 * @return the totalbalesweightForSWL
	 */
	public double getTotalbalesweightForSWL() {
		return totalbalesweightForSWL;
	}
	/**
	 * @param totalbalesweightForSWL the totalbalesweightForSWL to set
	 */
	public void setTotalbalesweightForSWL(double totalbalesweightForSWL) {
		this.totalbalesweightForSWL = totalbalesweightForSWL;
	}
	/**
	 * @return the totalbalesOfSWL
	 */
	public int getTotalbalesOfSWL() {
		return totalbalesOfSWL;
	}
	/**
	 * @param totalbalesOfSWL the totalbalesOfSWL to set
	 */
	public void setTotalbalesOfSWL(int totalbalesOfSWL) {
		this.totalbalesOfSWL = totalbalesOfSWL;
	}
	/**
	 * @return the totalbalesweightForMWL
	 */
	public double getTotalbalesweightForMWL() {
		return totalbalesweightForMWL;
	}
	/**
	 * @param totalbalesweightForMWL the totalbalesweightForMWL to set
	 */
	public void setTotalbalesweightForMWL(double totalbalesweightForMWL) {
		this.totalbalesweightForMWL = totalbalesweightForMWL;
	}
	/**
	 * @return the totalbalesOfMWL
	 */
	public int getTotalbalesOfMWL() {
		return totalbalesOfMWL;
	}
	/**
	 * @param totalbalesOfMWL the totalbalesOfMWL to set
	 */
	public void setTotalbalesOfMWL(int totalbalesOfMWL) {
		this.totalbalesOfMWL = totalbalesOfMWL;
	}
	/**
	 * @return the totalbalesweightForPrtmix
	 */
	public double getTotalbalesweightForPrtmix() {
		return totalbalesweightForPrtmix;
	}
	/**
	 * @param totalbalesweightForPrtmix the totalbalesweightForPrtmix to set
	 */
	public void setTotalbalesweightForPrtmix(double totalbalesweightForPrtmix) {
		this.totalbalesweightForPrtmix = totalbalesweightForPrtmix;
	}
	/**
	 * @return the totalbalesOfPrtmix
	 */
	public int getTotalbalesOfPrtmix() {
		return totalbalesOfPrtmix;
	}
	/**
	 * @param totalbalesOfPrtmix the totalbalesOfPrtmix to set
	 */
	public void setTotalbalesOfPrtmix(int totalbalesOfPrtmix) {
		this.totalbalesOfPrtmix = totalbalesOfPrtmix;
	}
	/**
	 * @return the totalbalesweightForMCL
	 */
	public double getTotalbalesweightForMCL() {
		return totalbalesweightForMCL;
	}
	/**
	 * @param totalbalesweightForMCL the totalbalesweightForMCL to set
	 */
	public void setTotalbalesweightForMCL(double totalbalesweightForMCL) {
		this.totalbalesweightForMCL = totalbalesweightForMCL;
	}
	/**
	 * @return the totalbalesOfMCL
	 */
	public int getTotalbalesOfMCL() {
		return totalbalesOfMCL;
	}
	/**
	 * @param totalbalesOfMCL the totalbalesOfMCL to set
	 */
	public void setTotalbalesOfMCL(int totalbalesOfMCL) {
		this.totalbalesOfMCL = totalbalesOfMCL;
	}
	/**
	 * @return the totalbalesweightForMWLWorIGS
	 */
	public double getTotalbalesweightForMWLWorIGS() {
		return totalbalesweightForMWLWorIGS;
	}
	/**
	 * @param totalbalesweightForMWLWorIGS the totalbalesweightForMWLWorIGS to set
	 */
	public void setTotalbalesweightForMWLWorIGS(double totalbalesweightForMWLWorIGS) {
		this.totalbalesweightForMWLWorIGS = totalbalesweightForMWLWorIGS;
	}
	/**
	 * @return the totalbalesOfMWLWorIGS
	 */
	public int getTotalbalesOfMWLWorIGS() {
		return totalbalesOfMWLWorIGS;
	}
	/**
	 * @param totalbalesOfMWLWorIGS the totalbalesOfMWLWorIGS to set
	 */
	public void setTotalbalesOfMWLWorIGS(int totalbalesOfMWLWorIGS) {
		this.totalbalesOfMWLWorIGS = totalbalesOfMWLWorIGS;
	}
	/**
	 * @return the totalbalesweightForCBS
	 */
	public double getTotalbalesweightForCBS() {
		return totalbalesweightForCBS;
	}
	/**
	 * @param totalbalesweightForCBS the totalbalesweightForCBS to set
	 */
	public void setTotalbalesweightForCBS(double totalbalesweightForCBS) {
		this.totalbalesweightForCBS = totalbalesweightForCBS;
	}
	/**
	 * @return the totalbalesOfCBS
	 */
	public int getTotalbalesOfCBS() {
		return totalbalesOfCBS;
	}
	/**
	 * @param totalbalesOfCBS the totalbalesOfCBS to set
	 */
	public void setTotalbalesOfCBS(int totalbalesOfCBS) {
		this.totalbalesOfCBS = totalbalesOfCBS;
	}
	/**
	 * @return the totalbalesweightForCtdGdwd
	 */
	public double getTotalbalesweightForCtdGdwd() {
		return totalbalesweightForCtdGdwd;
	}
	/**
	 * @param totalbalesweightForCtdGdwd the totalbalesweightForCtdGdwd to set
	 */
	public void setTotalbalesweightForCtdGdwd(double totalbalesweightForCtdGdwd) {
		this.totalbalesweightForCtdGdwd = totalbalesweightForCtdGdwd;
	}
	/**
	 * @return the totalbalesOfCtdGdwd
	 */
	public int getTotalbalesOfCtdGdwd() {
		return totalbalesOfCtdGdwd;
	}
	/**
	 * @param totalbalesOfCtdGdwd the totalbalesOfCtdGdwd to set
	 */
	public void setTotalbalesOfCtdGdwd(int totalbalesOfCtdGdwd) {
		this.totalbalesOfCtdGdwd = totalbalesOfCtdGdwd;
	}
	/**
	 * @return the totalbalesweightForSWLSortedWhite
	 */
	public double getTotalbalesweightForSWLSortedWhite() {
		return totalbalesweightForSWLSortedWhite;
	}
	/**
	 * @param totalbalesweightForSWLSortedWhite the totalbalesweightForSWLSortedWhite to set
	 */
	public void setTotalbalesweightForSWLSortedWhite(
			double totalbalesweightForSWLSortedWhite) {
		this.totalbalesweightForSWLSortedWhite = totalbalesweightForSWLSortedWhite;
	}
	/**
	 * @return the totalbalesOfSWLSortedWhite
	 */
	public int getTotalbalesOfSWLSortedWhite() {
		return totalbalesOfSWLSortedWhite;
	}
	/**
	 * @param totalbalesOfSWLSortedWhite the totalbalesOfSWLSortedWhite to set
	 */
	public void setTotalbalesOfSWLSortedWhite(int totalbalesOfSWLSortedWhite) {
		this.totalbalesOfSWLSortedWhite = totalbalesOfSWLSortedWhite;
	}
	/**
	 * @return the totalbalesweightForONPOldNewsPrint
	 */
	public double getTotalbalesweightForONPOldNewsPrint() {
		return totalbalesweightForONPOldNewsPrint;
	}
	/**
	 * @param totalbalesweightForONPOldNewsPrint the totalbalesweightForONPOldNewsPrint to set
	 */
	public void setTotalbalesweightForONPOldNewsPrint(
			double totalbalesweightForONPOldNewsPrint) {
		this.totalbalesweightForONPOldNewsPrint = totalbalesweightForONPOldNewsPrint;
	}
	/**
	 * @return the totalbalesOfONPOldNewsPrint
	 */
	public int getTotalbalesOfONPOldNewsPrint() {
		return totalbalesOfONPOldNewsPrint;
	}
	/**
	 * @param totalbalesOfONPOldNewsPrint the totalbalesOfONPOldNewsPrint to set
	 */
	public void setTotalbalesOfONPOldNewsPrint(int totalbalesOfONPOldNewsPrint) {
		this.totalbalesOfONPOldNewsPrint = totalbalesOfONPOldNewsPrint;
	}
	/**
	 * @return the totalbalesweightForOINews
	 */
	public double getTotalbalesweightForOINews() {
		return totalbalesweightForOINews;
	}
	/**
	 * @param totalbalesweightForOINews the totalbalesweightForOINews to set
	 */
	public void setTotalbalesweightForOINews(double totalbalesweightForOINews) {
		this.totalbalesweightForOINews = totalbalesweightForOINews;
	}
	/**
	 * @return the totalbalesOfOINews
	 */
	public int getTotalbalesOfOINews() {
		return totalbalesOfOINews;
	}
	/**
	 * @param totalbalesOfOINews the totalbalesOfOINews to set
	 */
	public void setTotalbalesOfOINews(int totalbalesOfOINews) {
		this.totalbalesOfOINews = totalbalesOfOINews;
	}
	/**
	 * @return the totalbalesweightForLightPrtSBS
	 */
	public double getTotalbalesweightForLightPrtSBS() {
		return totalbalesweightForLightPrtSBS;
	}
	/**
	 * @param totalbalesweightForLightPrtSBS the totalbalesweightForLightPrtSBS to set
	 */
	public void setTotalbalesweightForLightPrtSBS(
			double totalbalesweightForLightPrtSBS) {
		this.totalbalesweightForLightPrtSBS = totalbalesweightForLightPrtSBS;
	}
	/**
	 * @return the totalbalesOfLightPrtSBS
	 */
	public int getTotalbalesOfLightPrtSBS() {
		return totalbalesOfLightPrtSBS;
	}
	/**
	 * @param totalbalesOfLightPrtSBS the totalbalesOfLightPrtSBS to set
	 */
	public void setTotalbalesOfLightPrtSBS(int totalbalesOfLightPrtSBS) {
		this.totalbalesOfLightPrtSBS = totalbalesOfLightPrtSBS;
	}
	/**
	 * @return the totalbalesweightForHW
	 */
	public double getTotalbalesweightForHW() {
		return totalbalesweightForHW;
	}
	/**
	 * @param totalbalesweightForHW the totalbalesweightForHW to set
	 */
	public void setTotalbalesweightForHW(double totalbalesweightForHW) {
		this.totalbalesweightForHW = totalbalesweightForHW;
	}
	/**
	 * @return the totalbalesOfHW
	 */
	public int getTotalbalesOfHW() {
		return totalbalesOfHW;
	}
	/**
	 * @param totalbalesOfHW the totalbalesOfHW to set
	 */
	public void setTotalbalesOfHW(int totalbalesOfHW) {
		this.totalbalesOfHW = totalbalesOfHW;
	}
	/**
	 * @return the totalbalesweightForHeavyPrtSBS
	 */
	public double getTotalbalesweightForHeavyPrtSBS() {
		return totalbalesweightForHeavyPrtSBS;
	}
	/**
	 * @param totalbalesweightForHeavyPrtSBS the totalbalesweightForHeavyPrtSBS to set
	 */
	public void setTotalbalesweightForHeavyPrtSBS(
			double totalbalesweightForHeavyPrtSBS) {
		this.totalbalesweightForHeavyPrtSBS = totalbalesweightForHeavyPrtSBS;
	}
	/**
	 * @return the totalbalesOfHeavyPrtSBS
	 */
	public int getTotalbalesOfHeavyPrtSBS() {
		return totalbalesOfHeavyPrtSBS;
	}
	/**
	 * @param totalbalesOfHeavyPrtSBS the totalbalesOfHeavyPrtSBS to set
	 */
	public void setTotalbalesOfHeavyPrtSBS(int totalbalesOfHeavyPrtSBS) {
		this.totalbalesOfHeavyPrtSBS = totalbalesOfHeavyPrtSBS;
	}
	/**
	 * @return the totalbalesweightForSOW
	 */
	public double getTotalbalesweightForSOW() {
		return totalbalesweightForSOW;
	}
	/**
	 * @param totalbalesweightForSOW the totalbalesweightForSOW to set
	 */
	public void setTotalbalesweightForSOW(double totalbalesweightForSOW) {
		this.totalbalesweightForSOW = totalbalesweightForSOW;
	}
	/**
	 * @return the totalbalesOfSOW
	 */
	public int getTotalbalesOfSOW() {
		return totalbalesOfSOW;
	}
	/**
	 * @param totalbalesOfSOW the totalbalesOfSOW to set
	 */
	public void setTotalbalesOfSOW(int totalbalesOfSOW) {
		this.totalbalesOfSOW = totalbalesOfSOW;
	}
	/**
	 * @return the totalbalesweightForUnprtSBS
	 */
	public double getTotalbalesweightForUnprtSBS() {
		return totalbalesweightForUnprtSBS;
	}
	/**
	 * @param totalbalesweightForUnprtSBS the totalbalesweightForUnprtSBS to set
	 */
	public void setTotalbalesweightForUnprtSBS(double totalbalesweightForUnprtSBS) {
		this.totalbalesweightForUnprtSBS = totalbalesweightForUnprtSBS;
	}
	/**
	 * @return the totalbalesOfUnprtSBS
	 */
	public int getTotalbalesOfUnprtSBS() {
		return totalbalesOfUnprtSBS;
	}
	/**
	 * @param totalbalesOfUnprtSBS the totalbalesOfUnprtSBS to set
	 */
	public void setTotalbalesOfUnprtSBS(int totalbalesOfUnprtSBS) {
		this.totalbalesOfUnprtSBS = totalbalesOfUnprtSBS;
	}
	/**
	 * @return the totalbalesweightForNewsblank
	 */
	public double getTotalbalesweightForNewsblank() {
		return totalbalesweightForNewsblank;
	}
	/**
	 * @param totalbalesweightForNewsblank the totalbalesweightForNewsblank to set
	 */
	public void setTotalbalesweightForNewsblank(double totalbalesweightForNewsblank) {
		this.totalbalesweightForNewsblank = totalbalesweightForNewsblank;
	}
	/**
	 * @return the totalbalesOfNewsblank
	 */
	public int getTotalbalesOfNewsblank() {
		return totalbalesOfNewsblank;
	}
	/**
	 * @param totalbalesOfNewsblank the totalbalesOfNewsblank to set
	 */
	public void setTotalbalesOfNewsblank(int totalbalesOfNewsblank) {
		this.totalbalesOfNewsblank = totalbalesOfNewsblank;
	}
	/**
	 * @return the totalbalesweightForWhiteGdwdBlend
	 */
	public double getTotalbalesweightForWhiteGdwdBlend() {
		return totalbalesweightForWhiteGdwdBlend;
	}
	/**
	 * @param totalbalesweightForWhiteGdwdBlend the totalbalesweightForWhiteGdwdBlend to set
	 */
	public void setTotalbalesweightForWhiteGdwdBlend(
			double totalbalesweightForWhiteGdwdBlend) {
		this.totalbalesweightForWhiteGdwdBlend = totalbalesweightForWhiteGdwdBlend;
	}
	/**
	 * @return the totalbalesOfWhiteGdwdBlend
	 */
	public int getTotalbalesOfWhiteGdwdBlend() {
		return totalbalesOfWhiteGdwdBlend;
	}
	/**
	 * @param totalbalesOfWhiteGdwdBlend the totalbalesOfWhiteGdwdBlend to set
	 */
	public void setTotalbalesOfWhiteGdwdBlend(int totalbalesOfWhiteGdwdBlend) {
		this.totalbalesOfWhiteGdwdBlend = totalbalesOfWhiteGdwdBlend;
	}
	/**
	 * @return the totalbalesweightForMailUndeliverable
	 */
	public double getTotalbalesweightForMailUndeliverable() {
		return totalbalesweightForMailUndeliverable;
	}
	/**
	 * @param totalbalesweightForMailUndeliverable the totalbalesweightForMailUndeliverable to set
	 */
	public void setTotalbalesweightForMailUndeliverable(
			double totalbalesweightForMailUndeliverable) {
		this.totalbalesweightForMailUndeliverable = totalbalesweightForMailUndeliverable;
	}
	/**
	 * @return the totalbalesOfMailUndeliverable
	 */
	public int getTotalbalesOfMailUndeliverable() {
		return totalbalesOfMailUndeliverable;
	}
	/**
	 * @param totalbalesOfMailUndeliverable the totalbalesOfMailUndeliverable to set
	 */
	public void setTotalbalesOfMailUndeliverable(int totalbalesOfMailUndeliverable) {
		this.totalbalesOfMailUndeliverable = totalbalesOfMailUndeliverable;
	}
	/**
	 * @return the totalbalesweightForHoggedBooks
	 */
	public double getTotalbalesweightForHoggedBooks() {
		return totalbalesweightForHoggedBooks;
	}
	/**
	 * @param totalbalesweightForHoggedBooks the totalbalesweightForHoggedBooks to set
	 */
	public void setTotalbalesweightForHoggedBooks(
			double totalbalesweightForHoggedBooks) {
		this.totalbalesweightForHoggedBooks = totalbalesweightForHoggedBooks;
	}
	/**
	 * @return the totalbalesOfHoggedBooks
	 */
	public int getTotalbalesOfHoggedBooks() {
		return totalbalesOfHoggedBooks;
	}
	/**
	 * @param totalbalesOfHoggedBooks the totalbalesOfHoggedBooks to set
	 */
	public void setTotalbalesOfHoggedBooks(int totalbalesOfHoggedBooks) {
		this.totalbalesOfHoggedBooks = totalbalesOfHoggedBooks;
	}
	/**
	 * @return the totalbalesweightForOCC
	 */
	public double getTotalbalesweightForOCC() {
		return totalbalesweightForOCC;
	}
	/**
	 * @param totalbalesweightForOCC the totalbalesweightForOCC to set
	 */
	public void setTotalbalesweightForOCC(double totalbalesweightForOCC) {
		this.totalbalesweightForOCC = totalbalesweightForOCC;
	}
	/**
	 * @return the totalbalesOfOCC
	 */
	public int getTotalbalesOfOCC() {
		return totalbalesOfOCC;
	}
	/**
	 * @param totalbalesOfOCC the totalbalesOfOCC to set
	 */
	public void setTotalbalesOfOCC(int totalbalesOfOCC) {
		this.totalbalesOfOCC = totalbalesOfOCC;
	}
	/**
	 * @return the totalbalesweightForDLK
	 */
	public double getTotalbalesweightForDLK() {
		return totalbalesweightForDLK;
	}
	/**
	 * @param totalbalesweightForDLK the totalbalesweightForDLK to set
	 */
	public void setTotalbalesweightForDLK(double totalbalesweightForDLK) {
		this.totalbalesweightForDLK = totalbalesweightForDLK;
	}
	/**
	 * @return the totalbalesOfDLK
	 */
	public int getTotalbalesOfDLK() {
		return totalbalesOfDLK;
	}
	/**
	 * @param totalbalesOfDLK the totalbalesOfDLK to set
	 */
	public void setTotalbalesOfDLK(int totalbalesOfDLK) {
		this.totalbalesOfDLK = totalbalesOfDLK;
	}
	/**
	 * @return the totalbalesweightForMixedPaper
	 */
	public double getTotalbalesweightForMixedPaper() {
		return totalbalesweightForMixedPaper;
	}
	/**
	 * @param totalbalesweightForMixedPaper the totalbalesweightForMixedPaper to set
	 */
	public void setTotalbalesweightForMixedPaper(
			double totalbalesweightForMixedPaper) {
		this.totalbalesweightForMixedPaper = totalbalesweightForMixedPaper;
	}
	/**
	 * @return the totalbalesOfMixedPaper
	 */
	public int getTotalbalesOfMixedPaper() {
		return totalbalesOfMixedPaper;
	}
	/**
	 * @param totalbalesOfMixedPaper the totalbalesOfMixedPaper to set
	 */
	public void setTotalbalesOfMixedPaper(int totalbalesOfMixedPaper) {
		this.totalbalesOfMixedPaper = totalbalesOfMixedPaper;
	}
	/**
	 * @return the totalbalesweightForSoftWoodChips
	 */
	public double getTotalbalesweightForSoftWoodChips() {
		return totalbalesweightForSoftWoodChips;
	}
	/**
	 * @param totalbalesweightForSoftWoodChips the totalbalesweightForSoftWoodChips to set
	 */
	public void setTotalbalesweightForSoftWoodChips(
			double totalbalesweightForSoftWoodChips) {
		this.totalbalesweightForSoftWoodChips = totalbalesweightForSoftWoodChips;
	}
	/**
	 * @return the totalbalesOfHardWoodChips
	 */
	public int getTotalbalesOfHardWoodChips() {
		return totalbalesOfHardWoodChips;
	}
	/**
	 * @param totalbalesOfHardWoodChips the totalbalesOfHardWoodChips to set
	 */
	public void setTotalbalesOfHardWoodChips(int totalbalesOfHardWoodChips) {
		this.totalbalesOfHardWoodChips = totalbalesOfHardWoodChips;
	}
	/**
	 * @return the totalbalesweightForPWE
	 */
	public double getTotalbalesweightForPWE() {
		return totalbalesweightForPWE;
	}
	/**
	 * @param totalbalesweightForPWE the totalbalesweightForPWE to set
	 */
	public void setTotalbalesweightForPWE(double totalbalesweightForPWE) {
		this.totalbalesweightForPWE = totalbalesweightForPWE;
	}
	/**
	 * @return the totalbalesOfPWE
	 */
	public int getTotalbalesOfPWE() {
		return totalbalesOfPWE;
	}
	/**
	 * @param totalbalesOfPWE the totalbalesOfPWE to set
	 */
	public void setTotalbalesOfPWE(int totalbalesOfPWE) {
		this.totalbalesOfPWE = totalbalesOfPWE;
	}
	/**
	 * @return the totalbalesweightForWhiteBroke
	 */
	public double getTotalbalesweightForWhiteBroke() {
		return totalbalesweightForWhiteBroke;
	}
	/**
	 * @param totalbalesweightForWhiteBroke the totalbalesweightForWhiteBroke to set
	 */
	public void setTotalbalesweightForWhiteBroke(
			double totalbalesweightForWhiteBroke) {
		this.totalbalesweightForWhiteBroke = totalbalesweightForWhiteBroke;
	}
	/**
	 * @return the totalbalesOfWhiteBroke
	 */
	public int getTotalbalesOfWhiteBroke() {
		return totalbalesOfWhiteBroke;
	}
	/**
	 * @param totalbalesOfWhiteBroke the totalbalesOfWhiteBroke to set
	 */
	public void setTotalbalesOfWhiteBroke(int totalbalesOfWhiteBroke) {
		this.totalbalesOfWhiteBroke = totalbalesOfWhiteBroke;
	}
	/**
	 * @return the totalbalesweightForBrownNapkinBroke
	 */
	public double getTotalbalesweightForBrownNapkinBroke() {
		return totalbalesweightForBrownNapkinBroke;
	}
	/**
	 * @param totalbalesweightForBrownNapkinBroke the totalbalesweightForBrownNapkinBroke to set
	 */
	public void setTotalbalesweightForBrownNapkinBroke(
			double totalbalesweightForBrownNapkinBroke) {
		this.totalbalesweightForBrownNapkinBroke = totalbalesweightForBrownNapkinBroke;
	}
	/**
	 * @return the totalbalesOfBrownNapkinBroke
	 */
	public int getTotalbalesOfBrownNapkinBroke() {
		return totalbalesOfBrownNapkinBroke;
	}
	/**
	 * @param totalbalesOfBrownNapkinBroke the totalbalesOfBrownNapkinBroke to set
	 */
	public void setTotalbalesOfBrownNapkinBroke(int totalbalesOfBrownNapkinBroke) {
		this.totalbalesOfBrownNapkinBroke = totalbalesOfBrownNapkinBroke;
	}
	/**
	 * @return the totalbalesweightForPULPWetLap
	 */
	public double getTotalbalesweightForPULPWetLap() {
		return totalbalesweightForPULPWetLap;
	}
	/**
	 * @param totalbalesweightForPULPWetLap the totalbalesweightForPULPWetLap to set
	 */
	public void setTotalbalesweightForPULPWetLap(
			double totalbalesweightForPULPWetLap) {
		this.totalbalesweightForPULPWetLap = totalbalesweightForPULPWetLap;
	}
	/**
	 * @return the totalbalesOfPULPWetLap
	 */
	public int getTotalbalesOfPULPWetLap() {
		return totalbalesOfPULPWetLap;
	}
	/**
	 * @param totalbalesOfPULPWetLap the totalbalesOfPULPWetLap to set
	 */
	public void setTotalbalesOfPULPWetLap(int totalbalesOfPULPWetLap) {
		this.totalbalesOfPULPWetLap = totalbalesOfPULPWetLap;
	}
	/**
	 * @return the totalbalesweightForVirginPulp
	 */
	public double getTotalbalesweightForVirginPulp() {
		return totalbalesweightForVirginPulp;
	}
	/**
	 * @param totalbalesweightForVirginPulp the totalbalesweightForVirginPulp to set
	 */
	public void setTotalbalesweightForVirginPulp(
			double totalbalesweightForVirginPulp) {
		this.totalbalesweightForVirginPulp = totalbalesweightForVirginPulp;
	}
	/**
	 * @return the totalbalesOfVirginPulp
	 */
	public int getTotalbalesOfVirginPulp() {
		return totalbalesOfVirginPulp;
	}
	/**
	 * @param totalbalesOfVirginPulp the totalbalesOfVirginPulp to set
	 */
	public void setTotalbalesOfVirginPulp(int totalbalesOfVirginPulp) {
		this.totalbalesOfVirginPulp = totalbalesOfVirginPulp;
	}
	/**
	 * @return the totalbalesweightForBrownWetLap
	 */
	public double getTotalbalesweightForBrownWetLap() {
		return totalbalesweightForBrownWetLap;
	}
	/**
	 * @param totalbalesweightForBrownWetLap the totalbalesweightForBrownWetLap to set
	 */
	public void setTotalbalesweightForBrownWetLap(
			double totalbalesweightForBrownWetLap) {
		this.totalbalesweightForBrownWetLap = totalbalesweightForBrownWetLap;
	}
	/**
	 * @return the totalbalesOfBrownWetLap
	 */
	public int getTotalbalesOfBrownWetLap() {
		return totalbalesOfBrownWetLap;
	}
	/**
	 * @param totalbalesOfBrownWetLap the totalbalesOfBrownWetLap to set
	 */
	public void setTotalbalesOfBrownWetLap(int totalbalesOfBrownWetLap) {
		this.totalbalesOfBrownWetLap = totalbalesOfBrownWetLap;
	}
	/**
	 * @return the totalbalesweightForPulpDryLap
	 */
	public double getTotalbalesweightForPulpDryLap() {
		return totalbalesweightForPulpDryLap;
	}
	/**
	 * @param totalbalesweightForPulpDryLap the totalbalesweightForPulpDryLap to set
	 */
	public void setTotalbalesweightForPulpDryLap(
			double totalbalesweightForPulpDryLap) {
		this.totalbalesweightForPulpDryLap = totalbalesweightForPulpDryLap;
	}
	/**
	 * @return the totalbalesOfPulpDryLap
	 */
	public int getTotalbalesOfPulpDryLap() {
		return totalbalesOfPulpDryLap;
	}
	/**
	 * @param totalbalesOfPulpDryLap the totalbalesOfPulpDryLap to set
	 */
	public void setTotalbalesOfPulpDryLap(int totalbalesOfPulpDryLap) {
		this.totalbalesOfPulpDryLap = totalbalesOfPulpDryLap;
	}
	/**
	 * @return the totalbalesweightForOtherRolls
	 */
	public double getTotalbalesweightForOtherRolls() {
		return totalbalesweightForOtherRolls;
	}
	/**
	 * @param totalbalesweightForOtherRolls the totalbalesweightForOtherRolls to set
	 */
	public void setTotalbalesweightForOtherRolls(
			double totalbalesweightForOtherRolls) {
		this.totalbalesweightForOtherRolls = totalbalesweightForOtherRolls;
	}
	/**
	 * @return the totalbalesOfOtherRolls
	 */
	public int getTotalbalesOfOtherRolls() {
		return totalbalesOfOtherRolls;
	}
	/**
	 * @param totalbalesOfOtherRolls the totalbalesOfOtherRolls to set
	 */
	public void setTotalbalesOfOtherRolls(int totalbalesOfOtherRolls) {
		this.totalbalesOfOtherRolls = totalbalesOfOtherRolls;
	}
	/**
	 * @return the totalbalesweightForSTBaleswetlap
	 */
	public double getTotalbalesweightForSTBaleswetlap() {
		return totalbalesweightForSTBaleswetlap;
	}
	/**
	 * @param totalbalesweightForSTBaleswetlap the totalbalesweightForSTBaleswetlap to set
	 */
	public void setTotalbalesweightForSTBaleswetlap(
			double totalbalesweightForSTBaleswetlap) {
		this.totalbalesweightForSTBaleswetlap = totalbalesweightForSTBaleswetlap;
	}
	/**
	 * @return the totalbalesOfSTBaleswetlap
	 */
	public int getTotalbalesOfSTBaleswetlap() {
		return totalbalesOfSTBaleswetlap;
	}
	/**
	 * @param totalbalesOfSTBaleswetlap the totalbalesOfSTBaleswetlap to set
	 */
	public void setTotalbalesOfSTBaleswetlap(int totalbalesOfSTBaleswetlap) {
		this.totalbalesOfSTBaleswetlap = totalbalesOfSTBaleswetlap;
	}
	/**
	 * @return the totalbalesweightForSTTBaledBroke
	 */
	public double getTotalbalesweightForSTTBaledBroke() {
		return totalbalesweightForSTTBaledBroke;
	}
	/**
	 * @param totalbalesweightForSTTBaledBroke the totalbalesweightForSTTBaledBroke to set
	 */
	public void setTotalbalesweightForSTTBaledBroke(
			double totalbalesweightForSTTBaledBroke) {
		this.totalbalesweightForSTTBaledBroke = totalbalesweightForSTTBaledBroke;
	}
	/**
	 * @return the totalbalesOfSTTBaledBroke
	 */
	public int getTotalbalesOfSTTBaledBroke() {
		return totalbalesOfSTTBaledBroke;
	}
	/**
	 * @param totalbalesOfSTTBaledBroke the totalbalesOfSTTBaledBroke to set
	 */
	public void setTotalbalesOfSTTBaledBroke(int totalbalesOfSTTBaledBroke) {
		this.totalbalesOfSTTBaledBroke = totalbalesOfSTTBaledBroke;
	}
	/**
	 * @return the totalbalesOfSoftWoodChips
	 */
	public int getTotalbalesOfSoftWoodChips() {
		return totalbalesOfSoftWoodChips;
	}
	/**
	 * @param totalbalesOfSoftWoodChips the totalbalesOfSoftWoodChips to set
	 */
	public void setTotalbalesOfSoftWoodChips(int totalbalesOfSoftWoodChips) {
		this.totalbalesOfSoftWoodChips = totalbalesOfSoftWoodChips;
	}
	/**
	 * @return the totalbalesweightForHardWoodChips
	 */
	public double getTotalbalesweightForHardWoodChips() {
		return totalbalesweightForHardWoodChips;
	}
	/**
	 * @param totalbalesweightForHardWoodChips the totalbalesweightForHardWoodChips to set
	 */
	public void setTotalbalesweightForHardWoodChips(
			double totalbalesweightForHardWoodChips) {
		this.totalbalesweightForHardWoodChips = totalbalesweightForHardWoodChips;
	}
	/**
	 * @return the totalConsumedBales
	 */
	public int getTotalConsumedBales() {
		return totalConsumedBales;
	}
	/**
	 * @param totalConsumedBales the totalConsumedBales to set
	 */
	public void setTotalConsumedBales(int totalConsumedBales) {
		this.totalConsumedBales = totalConsumedBales;
	}
	/**
	 * @return the totalUnloadBales
	 */
	public int getTotalUnloadBales() {
		return totalUnloadBales;
	}
	/**
	 * @param totalUnloadBales the totalUnloadBales to set
	 */
	public void setTotalUnloadBales(int totalUnloadBales) {
		this.totalUnloadBales = totalUnloadBales;
	}	
	/**
	 * @return the total_cbod
	 */
	public int getTotal_cbod_bales() {
		return total_cbod_bales;
	}
	/**
	 * @param total_cbod the total_cbod to set
	 */
	public void setTotal_cbod_bales(int total_cbod_bales) {
		this.total_cbod_bales = total_cbod_bales;
	}
	/**
	 * @return the total_cbod_weight
	 */
	public double getTotal_cbod_weight() {
		return total_cbod_weight;
	}
	/**
	 * @param total_cbod_weight the total_cbod_weight to set
	 */
	public void setTotal_cbod_weight(double total_cbod_weight) {
		this.total_cbod_weight = total_cbod_weight;
	}
	/**
	 * @return the netTons
	 */
	public double getNetTons() {
		return netTons;
	}
	/**
	 * @param netTons the netTons to set
	 */
	public void setNetTons(double netTons) {
		this.netTons = netTons;
	}
	/**
	 * @return the bales
	 */
	public int getBales() {
		return bales;
	}
	/**
	 * @param bales the bales to set
	 */
	public void setBales(int bales) {
		this.bales = bales;
	}
	/**
	 * @return the lotcolor
	 */
	public String getLotcolor() {
		return lotcolor;
	}
	/**
	 * @param lotcolor the lotcolor to set
	 */
	public void setLotcolor(String lotcolor) {
		this.lotcolor = lotcolor;
	}
	/**
	 * @return the totalconsumedbalesweight
	 */
	public double getTotalconsumedbalesweight() {
		return totalconsumedbalesweight;
	}
	/**
	 * @param totalconsumedbalesweight the totalconsumedbalesweight to set
	 */
	public void setTotalconsumedbalesweight(double totalconsumedbalesweight) {
		this.totalconsumedbalesweight = totalconsumedbalesweight;
	}
	/**
	 * @return the totalunloadbalesweight
	 */
	public double getTotalunloadbalesweight() {
		return totalunloadbalesweight;
	}
	/**
	 * @param totalunloadbalesweight the totalunloadbalesweight to set
	 */
	public void setTotalunloadbalesweight(double totalunloadbalesweight) {
		this.totalunloadbalesweight = totalunloadbalesweight;
	}
	public double getTotalbalesweightForVirginHardWood() {
		return totalbalesweightForVirginHardWood;
	}
	public void setTotalbalesweightForVirginHardWood(
			double totalbalesweightForVirginHardWood) {
		this.totalbalesweightForVirginHardWood = totalbalesweightForVirginHardWood;
	}
	public int getTotalbalesOfVirginHardWood() {
		return totalbalesOfVirginHardWood;
	}
	public void setTotalbalesOfVirginHardWood(int totalbalesOfVirginHardWood) {
		this.totalbalesOfVirginHardWood = totalbalesOfVirginHardWood;
	}
	public double getTotalbalesweightForVirginSoftWood() {
		return totalbalesweightForVirginSoftWood;
	}
	public void setTotalbalesweightForVirginSoftWood(
			double totalbalesweightForVirginSoftWood) {
		this.totalbalesweightForVirginSoftWood = totalbalesweightForVirginSoftWood;
	}
	public int getTotalbalesOfVirginSoftWood() {
		return totalbalesOfVirginSoftWood;
	}
	public void setTotalbalesOfVirginSoftWood(int totalbalesOfVirginSoftWood) {
		this.totalbalesOfVirginSoftWood = totalbalesOfVirginSoftWood;
	}
	/**
	 * @return the totalbalesweightForHardWhite
	 */
	public double getTotalbalesweightForHardWhite() {
		return totalbalesweightForHardWhite;
	}
	/**
	 * @param totalbalesweightForHardWhite the totalbalesweightForHardWhite to set
	 */
	public void setTotalbalesweightForHardWhite(double totalbalesweightForHardWhite) {
		this.totalbalesweightForHardWhite = totalbalesweightForHardWhite;
	}
	/**
	 * @return the totalbalesOfHardWhite
	 */
	public int getTotalbalesOfHardWhite() {
		return totalbalesOfHardWhite;
	}
	/**
	 * @param totalbalesOfHardWhite the totalbalesOfHardWhite to set
	 */
	public void setTotalbalesOfHardWhite(int totalbalesOfHardWhite) {
		this.totalbalesOfHardWhite = totalbalesOfHardWhite;
	}
	/**
	 * @return the totalbalesweightForVirginequalypuHW
	 */
	public double getTotalbalesweightForVirginequalypuHW() {
		return totalbalesweightForVirginequalypuHW;
	}
	/**
	 * @param totalbalesweightForVirginequalypuHW the totalbalesweightForVirginequalypuHW to set
	 */
	public void setTotalbalesweightForVirginequalypuHW(double totalbalesweightForVirginequalypuHW) {
		this.totalbalesweightForVirginequalypuHW = totalbalesweightForVirginequalypuHW;
	}
	/**
	 * @return the totalbalesOfVirginequalypuHW
	 */
	public int getTotalbalesOfVirginequalypuHW() {
		return totalbalesOfVirginequalypuHW;
	}
	/**
	 * @param totalbalesOfVirginequalypuHW the totalbalesOfVirginequalypuHW to set
	 */
	public void setTotalbalesOfVirginequalypuHW(int totalbalesOfVirginequalypuHW) {
		this.totalbalesOfVirginequalypuHW = totalbalesOfVirginequalypuHW;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the mwl
	 */
	public String getMwl() {
		return mwl;
	}
	/**
	 * @param mwl the mwl to set
	 */
	public void setMwl(String mwl) {
		this.mwl = mwl;
	}
	/**
	 * @return the pmix
	 */
	public String getPmix() {
		return pmix;
	}
	/**
	 * @param pmix the pmix to set
	 */
	public void setPmix(String pmix) {
		this.pmix = pmix;
	}
	/**
	 * @return the mcl
	 */
	public String getMcl() {
		return mcl;
	}
	/**
	 * @param mcl the mcl to set
	 */
	public void setMcl(String mcl) {
		this.mcl = mcl;
	}
	/**
	 * @return the mwlwigs
	 */
	public String getMwlwigs() {
		return mwlwigs;
	}
	/**
	 * @param mwlwigs the mwlwigs to set
	 */
	public void setMwlwigs(String mwlwigs) {
		this.mwlwigs = mwlwigs;
	}
	/**
	 * @return the cbs
	 */
	public String getCbs() {
		return cbs;
	}
	/**
	 * @param cbs the cbs to set
	 */
	public void setCbs(String cbs) {
		this.cbs = cbs;
	}
	/**
	 * @return the ctdgdwd
	 */
	public String getCtdgdwd() {
		return ctdgdwd;
	}
	/**
	 * @param ctdgdwd the ctdgdwd to set
	 */
	public void setCtdgdwd(String ctdgdwd) {
		this.ctdgdwd = ctdgdwd;
	}
	/**
	 * @return the unctdflyleafshvgs
	 */
	public String getUnctdflyleafshvgs() {
		return unctdflyleafshvgs;
	}
	/**
	 * @param unctdflyleafshvgs the unctdflyleafshvgs to set
	 */
	public void setUnctdflyleafshvgs(String unctdflyleafshvgs) {
		this.unctdflyleafshvgs = unctdflyleafshvgs;
	}
	/**
	 * @return the lightprtsbs
	 */
	public String getLightprtsbs() {
		return lightprtsbs;
	}
	/**
	 * @param lightprtsbs the lightprtsbs to set
	 */
	public void setLightprtsbs(String lightprtsbs) {
		this.lightprtsbs = lightprtsbs;
	}
	/**
	 * @return the hw
	 */
	public String getHw() {
		return hw;
	}
	/**
	 * @param hw the hw to set
	 */
	public void setHw(String hw) {
		this.hw = hw;
	}
	/**
	 * @return the heavyprtsbs
	 */
	public String getHeavyprtsbs() {
		return heavyprtsbs;
	}
	/**
	 * @param heavyprtsbs the heavyprtsbs to set
	 */
	public void setHeavyprtsbs(String heavyprtsbs) {
		this.heavyprtsbs = heavyprtsbs;
	}
	/**
	 * @return the sow
	 */
	public String getSow() {
		return sow;
	}
	/**
	 * @param sow the sow to set
	 */
	public void setSow(String sow) {
		this.sow = sow;
	}
	/**
	 * @return the newsblank
	 */
	public String getNewsblank() {
		return newsblank;
	}
	/**
	 * @param newsblank the newsblank to set
	 */
	public void setNewsblank(String newsblank) {
		this.newsblank = newsblank;
	}
	/**
	 * @return the occcorrugated
	 */
	public String getOcccorrugated() {
		return occcorrugated;
	}
	/**
	 * @param occcorrugated the occcorrugated to set
	 */
	public void setOcccorrugated(String occcorrugated) {
		this.occcorrugated = occcorrugated;
	}
	/**
	 * @return the mixedpaper
	 */
	public String getMixedpaper() {
		return mixedpaper;
	}
	/**
	 * @param mixedpaper the mixedpaper to set
	 */
	public void setMixedpaper(String mixedpaper) {
		this.mixedpaper = mixedpaper;
	}
	/**
	 * @return the softwoodchips
	 */
	public String getSoftwoodchips() {
		return softwoodchips;
	}
	/**
	 * @param softwoodchips the softwoodchips to set
	 */
	public void setSoftwoodchips(String softwoodchips) {
		this.softwoodchips = softwoodchips;
	}
	/**
	 * @return the hardwoodchips
	 */
	public String getHardwoodchips() {
		return hardwoodchips;
	}
	/**
	 * @param hardwoodchips the hardwoodchips to set
	 */
	public void setHardwoodchips(String hardwoodchips) {
		this.hardwoodchips = hardwoodchips;
	}
	/**
	 * @return the pwe
	 */
	public String getPwe() {
		return pwe;
	}
	/**
	 * @param pwe the pwe to set
	 */
	public void setPwe(String pwe) {
		this.pwe = pwe;
	}
	/**
	 * @return the pulpwetlap
	 */
	public String getPulpwetlap() {
		return pulpwetlap;
	}
	/**
	 * @param pulpwetlap the pulpwetlap to set
	 */
	public void setPulpwetlap(String pulpwetlap) {
		this.pulpwetlap = pulpwetlap;
	}
	/**
	 * @return the virginpulp
	 */
	public String getVirginpulp() {
		return virginpulp;
	}
	/**
	 * @param virginpulp the virginpulp to set
	 */
	public void setVirginpulp(String virginpulp) {
		this.virginpulp = virginpulp;
	}
	/**
	 * @return the pulpdrylap
	 */
	public String getPulpdrylap() {
		return pulpdrylap;
	}
	/**
	 * @param pulpdrylap the pulpdrylap to set
	 */
	public void setPulpdrylap(String pulpdrylap) {
		this.pulpdrylap = pulpdrylap;
	}
	/**
	 * @return the other
	 */
	public String getOther() {
		return other;
	}
	/**
	 * @param other the other to set
	 */
	public void setOther(String other) {
		this.other = other;
	}
	/**
	 * @return the otherrolls
	 */
	public String getOtherrolls() {
		return otherrolls;
	}
	/**
	 * @param otherrolls the otherrolls to set
	 */
	public void setOtherrolls(String otherrolls) {
		this.otherrolls = otherrolls;
	}
	/**
	 * @return the stbaleswetlap
	 */
	public String getStbaleswetlap() {
		return stbaleswetlap;
	}
	/**
	 * @param stbaleswetlap the stbaleswetlap to set
	 */
	public void setStbaleswetlap(String stbaleswetlap) {
		this.stbaleswetlap = stbaleswetlap;
	}
	/**
	 * @return the virginSoftWood
	 */
	public String getVirginSoftWood() {
		return virginSoftWood;
	}
	/**
	 * @param virginSoftWood the virginSoftWood to set
	 */
	public void setVirginSoftWood(String virginSoftWood) {
		this.virginSoftWood = virginSoftWood;
	}
	/**
	 * @return the virginHardWood
	 */
	public String getVirginHardWood() {
		return virginHardWood;
	}
	/**
	 * @param virginHardWood the virginHardWood to set
	 */
	public void setVirginHardWood(String virginHardWood) {
		this.virginHardWood = virginHardWood;
	}
	/**
	 * @return the virginEucalyptus
	 */
	public String getVirginEucalyptus() {
		return virginEucalyptus;
	}
	/**
	 * @param virginEucalyptus the virginEucalyptus to set
	 */
	public void setVirginEucalyptus(String virginEucalyptus) {
		this.virginEucalyptus = virginEucalyptus;
	}
	/**
	 * @return the scnNews
	 */
	public String getScnNews() {
		return scnNews;
	}
	/**
	 * @param scnNews the scnNews to set
	 */
	public void setScnNews(String scnNews) {
		this.scnNews = scnNews;
	}
	/**
	 * @return the virginSW_Fluff
	 */
	public String getVirginSW_Fluff() {
		return virginSW_Fluff;
	}
	/**
	 * @param virginSW_Fluff the virginSW_Fluff to set
	 */
	public void setVirginSW_Fluff(String virginSW_Fluff) {
		this.virginSW_Fluff = virginSW_Fluff;
	}
	/**
	 * @return the totalbalesOfmwl
	 */
	public int getTotalbalesOfmwl() {
		return totalbalesOfmwl;
	}
	/**
	 * @param totalbalesOfmwl the totalbalesOfmwl to set
	 */
	public void setTotalbalesOfmwl(int totalbalesOfmwl) {
		this.totalbalesOfmwl = totalbalesOfmwl;
	}
	/**
	 * @return the totalbalesweightOfmwl
	 */
	public double getTotalbalesweightOfmwl() {
		return totalbalesweightOfmwl;
	}
	/**
	 * @param totalbalesweightOfmwl the totalbalesweightOfmwl to set
	 */
	public void setTotalbalesweightOfmwl(double totalbalesweightOfmwl) {
		this.totalbalesweightOfmwl = totalbalesweightOfmwl;
	}
	/**
	 * @return the totalbalesOfpmix
	 */
	public int getTotalbalesOfpmix() {
		return totalbalesOfpmix;
	}
	/**
	 * @param totalbalesOfpmix the totalbalesOfpmix to set
	 */
	public void setTotalbalesOfpmix(int totalbalesOfpmix) {
		this.totalbalesOfpmix = totalbalesOfpmix;
	}
	/**
	 * @return the totalbalesweightOfpmix
	 */
	public double getTotalbalesweightOfpmix() {
		return totalbalesweightOfpmix;
	}
	/**
	 * @param totalbalesweightOfpmix the totalbalesweightOfpmix to set
	 */
	public void setTotalbalesweightOfpmix(double totalbalesweightOfpmix) {
		this.totalbalesweightOfpmix = totalbalesweightOfpmix;
	}
	/**
	 * @return the totalbalesOfmcl
	 */
	public int getTotalbalesOfmcl() {
		return totalbalesOfmcl;
	}
	/**
	 * @param totalbalesOfmcl the totalbalesOfmcl to set
	 */
	public void setTotalbalesOfmcl(int totalbalesOfmcl) {
		this.totalbalesOfmcl = totalbalesOfmcl;
	}
	/**
	 * @return the totalbalesweightOfmcl
	 */
	public double getTotalbalesweightOfmcl() {
		return totalbalesweightOfmcl;
	}
	/**
	 * @param totalbalesweightOfmcl the totalbalesweightOfmcl to set
	 */
	public void setTotalbalesweightOfmcl(double totalbalesweightOfmcl) {
		this.totalbalesweightOfmcl = totalbalesweightOfmcl;
	}
	/**
	 * @return the totalbalesOfmwlwigs
	 */
	public int getTotalbalesOfmwlwigs() {
		return totalbalesOfmwlwigs;
	}
	/**
	 * @param totalbalesOfmwlwigs the totalbalesOfmwlwigs to set
	 */
	public void setTotalbalesOfmwlwigs(int totalbalesOfmwlwigs) {
		this.totalbalesOfmwlwigs = totalbalesOfmwlwigs;
	}
	/**
	 * @return the totalbalesweightOfmwlwigs
	 */
	public double getTotalbalesweightOfmwlwigs() {
		return totalbalesweightOfmwlwigs;
	}
	/**
	 * @param totalbalesweightOfmwlwigs the totalbalesweightOfmwlwigs to set
	 */
	public void setTotalbalesweightOfmwlwigs(double totalbalesweightOfmwlwigs) {
		this.totalbalesweightOfmwlwigs = totalbalesweightOfmwlwigs;
	}
	/**
	 * @return the totalbalesOfcbs
	 */
	public int getTotalbalesOfcbs() {
		return totalbalesOfcbs;
	}
	/**
	 * @param totalbalesOfcbs the totalbalesOfcbs to set
	 */
	public void setTotalbalesOfcbs(int totalbalesOfcbs) {
		this.totalbalesOfcbs = totalbalesOfcbs;
	}
	/**
	 * @return the totalbalesweightOfcbs
	 */
	public double getTotalbalesweightOfcbs() {
		return totalbalesweightOfcbs;
	}
	/**
	 * @param totalbalesweightOfcbs the totalbalesweightOfcbs to set
	 */
	public void setTotalbalesweightOfcbs(double totalbalesweightOfcbs) {
		this.totalbalesweightOfcbs = totalbalesweightOfcbs;
	}
	/**
	 * @return the totalbalesOfctdgdwd
	 */
	public int getTotalbalesOfctdgdwd() {
		return totalbalesOfctdgdwd;
	}
	/**
	 * @param totalbalesOfctdgdwd the totalbalesOfctdgdwd to set
	 */
	public void setTotalbalesOfctdgdwd(int totalbalesOfctdgdwd) {
		this.totalbalesOfctdgdwd = totalbalesOfctdgdwd;
	}
	/**
	 * @return the totalbalesweightOfctdgdwd
	 */
	public double getTotalbalesweightOfctdgdwd() {
		return totalbalesweightOfctdgdwd;
	}
	/**
	 * @param totalbalesweightOfctdgdwd the totalbalesweightOfctdgdwd to set
	 */
	public void setTotalbalesweightOfctdgdwd(double totalbalesweightOfctdgdwd) {
		this.totalbalesweightOfctdgdwd = totalbalesweightOfctdgdwd;
	}
	/**
	 * @return the totalbalesOfswl
	 */
	public int getTotalbalesOfswl() {
		return totalbalesOfswl;
	}
	/**
	 * @param totalbalesOfswl the totalbalesOfswl to set
	 */
	public void setTotalbalesOfswl(int totalbalesOfswl) {
		this.totalbalesOfswl = totalbalesOfswl;
	}
	/**
	 * @return the totalbalesweightOfswl
	 */
	public double getTotalbalesweightOfswl() {
		return totalbalesweightOfswl;
	}
	/**
	 * @param totalbalesweightOfswl the totalbalesweightOfswl to set
	 */
	public void setTotalbalesweightOfswl(double totalbalesweightOfswl) {
		this.totalbalesweightOfswl = totalbalesweightOfswl;
	}
	/**
	 * @return the totalbalesOfunctdflyleafshvgs
	 */
	public int getTotalbalesOfunctdflyleafshvgs() {
		return totalbalesOfunctdflyleafshvgs;
	}
	/**
	 * @param totalbalesOfunctdflyleafshvgs the totalbalesOfunctdflyleafshvgs to set
	 */
	public void setTotalbalesOfunctdflyleafshvgs(int totalbalesOfunctdflyleafshvgs) {
		this.totalbalesOfunctdflyleafshvgs = totalbalesOfunctdflyleafshvgs;
	}
	/**
	 * @return the totalbalesweightOfunctdflyleafshvgs
	 */
	public double getTotalbalesweightOfunctdflyleafshvgs() {
		return totalbalesweightOfunctdflyleafshvgs;
	}
	/**
	 * @param totalbalesweightOfunctdflyleafshvgs the totalbalesweightOfunctdflyleafshvgs to set
	 */
	public void setTotalbalesweightOfunctdflyleafshvgs(double totalbalesweightOfunctdflyleafshvgs) {
		this.totalbalesweightOfunctdflyleafshvgs = totalbalesweightOfunctdflyleafshvgs;
	}
	/**
	 * @return the totalbalesOflightprtsbs
	 */
	public int getTotalbalesOflightprtsbs() {
		return totalbalesOflightprtsbs;
	}
	/**
	 * @param totalbalesOflightprtsbs the totalbalesOflightprtsbs to set
	 */
	public void setTotalbalesOflightprtsbs(int totalbalesOflightprtsbs) {
		this.totalbalesOflightprtsbs = totalbalesOflightprtsbs;
	}
	/**
	 * @return the totalbalesweightOflightprtsbs
	 */
	public double getTotalbalesweightOflightprtsbs() {
		return totalbalesweightOflightprtsbs;
	}
	/**
	 * @param totalbalesweightOflightprtsbs the totalbalesweightOflightprtsbs to set
	 */
	public void setTotalbalesweightOflightprtsbs(double totalbalesweightOflightprtsbs) {
		this.totalbalesweightOflightprtsbs = totalbalesweightOflightprtsbs;
	}
	/**
	 * @return the totalbalesOfhw
	 */
	public int getTotalbalesOfhw() {
		return totalbalesOfhw;
	}
	/**
	 * @param totalbalesOfhw the totalbalesOfhw to set
	 */
	public void setTotalbalesOfhw(int totalbalesOfhw) {
		this.totalbalesOfhw = totalbalesOfhw;
	}
	/**
	 * @return the totalbalesweightOfhw
	 */
	public double getTotalbalesweightOfhw() {
		return totalbalesweightOfhw;
	}
	/**
	 * @param totalbalesweightOfhw the totalbalesweightOfhw to set
	 */
	public void setTotalbalesweightOfhw(double totalbalesweightOfhw) {
		this.totalbalesweightOfhw = totalbalesweightOfhw;
	}
	/**
	 * @return the totalbalesOfheavyprtsbs
	 */
	public int getTotalbalesOfheavyprtsbs() {
		return totalbalesOfheavyprtsbs;
	}
	/**
	 * @param totalbalesOfheavyprtsbs the totalbalesOfheavyprtsbs to set
	 */
	public void setTotalbalesOfheavyprtsbs(int totalbalesOfheavyprtsbs) {
		this.totalbalesOfheavyprtsbs = totalbalesOfheavyprtsbs;
	}
	/**
	 * @return the totalbalesweightOfheavyprtsbs
	 */
	public double getTotalbalesweightOfheavyprtsbs() {
		return totalbalesweightOfheavyprtsbs;
	}
	/**
	 * @param totalbalesweightOfheavyprtsbs the totalbalesweightOfheavyprtsbs to set
	 */
	public void setTotalbalesweightOfheavyprtsbs(double totalbalesweightOfheavyprtsbs) {
		this.totalbalesweightOfheavyprtsbs = totalbalesweightOfheavyprtsbs;
	}
	/**
	 * @return the totalbalesOfsow
	 */
	public int getTotalbalesOfsow() {
		return totalbalesOfsow;
	}
	/**
	 * @param totalbalesOfsow the totalbalesOfsow to set
	 */
	public void setTotalbalesOfsow(int totalbalesOfsow) {
		this.totalbalesOfsow = totalbalesOfsow;
	}
	/**
	 * @return the totalbalesweightOfsow
	 */
	public double getTotalbalesweightOfsow() {
		return totalbalesweightOfsow;
	}
	/**
	 * @param totalbalesweightOfsow the totalbalesweightOfsow to set
	 */
	public void setTotalbalesweightOfsow(double totalbalesweightOfsow) {
		this.totalbalesweightOfsow = totalbalesweightOfsow;
	}
	/**
	 * @return the totalbalesOfnewsblank
	 */
	public int getTotalbalesOfnewsblank() {
		return totalbalesOfnewsblank;
	}
	/**
	 * @param totalbalesOfnewsblank the totalbalesOfnewsblank to set
	 */
	public void setTotalbalesOfnewsblank(int totalbalesOfnewsblank) {
		this.totalbalesOfnewsblank = totalbalesOfnewsblank;
	}
	/**
	 * @return the totalbalesweightOfnewsblank
	 */
	public double getTotalbalesweightOfnewsblank() {
		return totalbalesweightOfnewsblank;
	}
	/**
	 * @param totalbalesweightOfnewsblank the totalbalesweightOfnewsblank to set
	 */
	public void setTotalbalesweightOfnewsblank(double totalbalesweightOfnewsblank) {
		this.totalbalesweightOfnewsblank = totalbalesweightOfnewsblank;
	}
	/**
	 * @return the totalbalesOfocccorrugated
	 */
	public int getTotalbalesOfocccorrugated() {
		return totalbalesOfocccorrugated;
	}
	/**
	 * @param totalbalesOfocccorrugated the totalbalesOfocccorrugated to set
	 */
	public void setTotalbalesOfocccorrugated(int totalbalesOfocccorrugated) {
		this.totalbalesOfocccorrugated = totalbalesOfocccorrugated;
	}
	/**
	 * @return the totalbalesweightOfocccorrugated
	 */
	public double getTotalbalesweightOfocccorrugated() {
		return totalbalesweightOfocccorrugated;
	}
	/**
	 * @param totalbalesweightOfocccorrugated the totalbalesweightOfocccorrugated to set
	 */
	public void setTotalbalesweightOfocccorrugated(double totalbalesweightOfocccorrugated) {
		this.totalbalesweightOfocccorrugated = totalbalesweightOfocccorrugated;
	}
	/**
	 * @return the totalbalesOfdlk
	 */
	public int getTotalbalesOfdlk() {
		return totalbalesOfdlk;
	}
	/**
	 * @param totalbalesOfdlk the totalbalesOfdlk to set
	 */
	public void setTotalbalesOfdlk(int totalbalesOfdlk) {
		this.totalbalesOfdlk = totalbalesOfdlk;
	}
	/**
	 * @return the totalbalesweightOfdlk
	 */
	public double getTotalbalesweightOfdlk() {
		return totalbalesweightOfdlk;
	}
	/**
	 * @param totalbalesweightOfdlk the totalbalesweightOfdlk to set
	 */
	public void setTotalbalesweightOfdlk(double totalbalesweightOfdlk) {
		this.totalbalesweightOfdlk = totalbalesweightOfdlk;
	}
	/**
	 * @return the totalbalesOfmixedpaper
	 */
	public int getTotalbalesOfmixedpaper() {
		return totalbalesOfmixedpaper;
	}
	/**
	 * @param totalbalesOfmixedpaper the totalbalesOfmixedpaper to set
	 */
	public void setTotalbalesOfmixedpaper(int totalbalesOfmixedpaper) {
		this.totalbalesOfmixedpaper = totalbalesOfmixedpaper;
	}
	/**
	 * @return the totalbalesweightOfmixedpaper
	 */
	public double getTotalbalesweightOfmixedpaper() {
		return totalbalesweightOfmixedpaper;
	}
	/**
	 * @param totalbalesweightOfmixedpaper the totalbalesweightOfmixedpaper to set
	 */
	public void setTotalbalesweightOfmixedpaper(double totalbalesweightOfmixedpaper) {
		this.totalbalesweightOfmixedpaper = totalbalesweightOfmixedpaper;
	}
	/**
	 * @return the totalbalesOfsoftwoodchips
	 */
	public int getTotalbalesOfsoftwoodchips() {
		return totalbalesOfsoftwoodchips;
	}
	/**
	 * @param totalbalesOfsoftwoodchips the totalbalesOfsoftwoodchips to set
	 */
	public void setTotalbalesOfsoftwoodchips(int totalbalesOfsoftwoodchips) {
		this.totalbalesOfsoftwoodchips = totalbalesOfsoftwoodchips;
	}
	/**
	 * @return the totalbalesweightOfsoftwoodchips
	 */
	public double getTotalbalesweightOfsoftwoodchips() {
		return totalbalesweightOfsoftwoodchips;
	}
	/**
	 * @param totalbalesweightOfsoftwoodchips the totalbalesweightOfsoftwoodchips to set
	 */
	public void setTotalbalesweightOfsoftwoodchips(double totalbalesweightOfsoftwoodchips) {
		this.totalbalesweightOfsoftwoodchips = totalbalesweightOfsoftwoodchips;
	}
	/**
	 * @return the totalbalesOfhardwoodchips
	 */
	public int getTotalbalesOfhardwoodchips() {
		return totalbalesOfhardwoodchips;
	}
	/**
	 * @param totalbalesOfhardwoodchips the totalbalesOfhardwoodchips to set
	 */
	public void setTotalbalesOfhardwoodchips(int totalbalesOfhardwoodchips) {
		this.totalbalesOfhardwoodchips = totalbalesOfhardwoodchips;
	}
	/**
	 * @return the totalbalesweightOfhardwoodchips
	 */
	public double getTotalbalesweightOfhardwoodchips() {
		return totalbalesweightOfhardwoodchips;
	}
	/**
	 * @param totalbalesweightOfhardwoodchips the totalbalesweightOfhardwoodchips to set
	 */
	public void setTotalbalesweightOfhardwoodchips(double totalbalesweightOfhardwoodchips) {
		this.totalbalesweightOfhardwoodchips = totalbalesweightOfhardwoodchips;
	}
	/**
	 * @return the totalbalesOfpwe
	 */
	public int getTotalbalesOfpwe() {
		return totalbalesOfpwe;
	}
	/**
	 * @param totalbalesOfpwe the totalbalesOfpwe to set
	 */
	public void setTotalbalesOfpwe(int totalbalesOfpwe) {
		this.totalbalesOfpwe = totalbalesOfpwe;
	}
	/**
	 * @return the totalbalesweightOfpwe
	 */
	public double getTotalbalesweightOfpwe() {
		return totalbalesweightOfpwe;
	}
	/**
	 * @param totalbalesweightOfpwe the totalbalesweightOfpwe to set
	 */
	public void setTotalbalesweightOfpwe(double totalbalesweightOfpwe) {
		this.totalbalesweightOfpwe = totalbalesweightOfpwe;
	}
	/**
	 * @return the totalbalesOfpulpwetlap
	 */
	public int getTotalbalesOfpulpwetlap() {
		return totalbalesOfpulpwetlap;
	}
	/**
	 * @param totalbalesOfpulpwetlap the totalbalesOfpulpwetlap to set
	 */
	public void setTotalbalesOfpulpwetlap(int totalbalesOfpulpwetlap) {
		this.totalbalesOfpulpwetlap = totalbalesOfpulpwetlap;
	}
	/**
	 * @return the totalbalesweightOfpulpwetlap
	 */
	public double getTotalbalesweightOfpulpwetlap() {
		return totalbalesweightOfpulpwetlap;
	}
	/**
	 * @param totalbalesweightOfpulpwetlap the totalbalesweightOfpulpwetlap to set
	 */
	public void setTotalbalesweightOfpulpwetlap(double totalbalesweightOfpulpwetlap) {
		this.totalbalesweightOfpulpwetlap = totalbalesweightOfpulpwetlap;
	}
	/**
	 * @return the totalbalesOfvirginpulp
	 */
	public int getTotalbalesOfvirginpulp() {
		return totalbalesOfvirginpulp;
	}
	/**
	 * @param totalbalesOfvirginpulp the totalbalesOfvirginpulp to set
	 */
	public void setTotalbalesOfvirginpulp(int totalbalesOfvirginpulp) {
		this.totalbalesOfvirginpulp = totalbalesOfvirginpulp;
	}
	/**
	 * @return the totalbalesweightOfvirginpulp
	 */
	public double getTotalbalesweightOfvirginpulp() {
		return totalbalesweightOfvirginpulp;
	}
	/**
	 * @param totalbalesweightOfvirginpulp the totalbalesweightOfvirginpulp to set
	 */
	public void setTotalbalesweightOfvirginpulp(double totalbalesweightOfvirginpulp) {
		this.totalbalesweightOfvirginpulp = totalbalesweightOfvirginpulp;
	}
	/**
	 * @return the totalbalesOfpulpdrylap
	 */
	public int getTotalbalesOfpulpdrylap() {
		return totalbalesOfpulpdrylap;
	}
	/**
	 * @param totalbalesOfpulpdrylap the totalbalesOfpulpdrylap to set
	 */
	public void setTotalbalesOfpulpdrylap(int totalbalesOfpulpdrylap) {
		this.totalbalesOfpulpdrylap = totalbalesOfpulpdrylap;
	}
	/**
	 * @return the totalbalesweightOfpulpdrylap
	 */
	public double getTotalbalesweightOfpulpdrylap() {
		return totalbalesweightOfpulpdrylap;
	}
	/**
	 * @param totalbalesweightOfpulpdrylap the totalbalesweightOfpulpdrylap to set
	 */
	public void setTotalbalesweightOfpulpdrylap(double totalbalesweightOfpulpdrylap) {
		this.totalbalesweightOfpulpdrylap = totalbalesweightOfpulpdrylap;
	}
	/**
	 * @return the totalbalesOfother
	 */
	public int getTotalbalesOfother() {
		return totalbalesOfother;
	}
	/**
	 * @param totalbalesOfother the totalbalesOfother to set
	 */
	public void setTotalbalesOfother(int totalbalesOfother) {
		this.totalbalesOfother = totalbalesOfother;
	}
	/**
	 * @return the totalbalesweightOfother
	 */
	public double getTotalbalesweightOfother() {
		return totalbalesweightOfother;
	}
	/**
	 * @param totalbalesweightOfother the totalbalesweightOfother to set
	 */
	public void setTotalbalesweightOfother(double totalbalesweightOfother) {
		this.totalbalesweightOfother = totalbalesweightOfother;
	}
	/**
	 * @return the totalbalesOfotherrolls
	 */
	public int getTotalbalesOfotherrolls() {
		return totalbalesOfotherrolls;
	}
	/**
	 * @param totalbalesOfotherrolls the totalbalesOfotherrolls to set
	 */
	public void setTotalbalesOfotherrolls(int totalbalesOfotherrolls) {
		this.totalbalesOfotherrolls = totalbalesOfotherrolls;
	}
	/**
	 * @return the totalbalesweightOfotherrolls
	 */
	public double getTotalbalesweightOfotherrolls() {
		return totalbalesweightOfotherrolls;
	}
	/**
	 * @param totalbalesweightOfotherrolls the totalbalesweightOfotherrolls to set
	 */
	public void setTotalbalesweightOfotherrolls(double totalbalesweightOfotherrolls) {
		this.totalbalesweightOfotherrolls = totalbalesweightOfotherrolls;
	}
	/**
	 * @return the totalbalesOfstbaleswetlap
	 */
	public int getTotalbalesOfstbaleswetlap() {
		return totalbalesOfstbaleswetlap;
	}
	/**
	 * @param totalbalesOfstbaleswetlap the totalbalesOfstbaleswetlap to set
	 */
	public void setTotalbalesOfstbaleswetlap(int totalbalesOfstbaleswetlap) {
		this.totalbalesOfstbaleswetlap = totalbalesOfstbaleswetlap;
	}
	/**
	 * @return the totalbalesweightOfstbaleswetlap
	 */
	public double getTotalbalesweightOfstbaleswetlap() {
		return totalbalesweightOfstbaleswetlap;
	}
	/**
	 * @param totalbalesweightOfstbaleswetlap the totalbalesweightOfstbaleswetlap to set
	 */
	public void setTotalbalesweightOfstbaleswetlap(double totalbalesweightOfstbaleswetlap) {
		this.totalbalesweightOfstbaleswetlap = totalbalesweightOfstbaleswetlap;
	}
	/**
	 * @return the totalbalesOflooseest
	 */
	public int getTotalbalesOflooseest() {
		return totalbalesOflooseest;
	}
	/**
	 * @param totalbalesOflooseest the totalbalesOflooseest to set
	 */
	public void setTotalbalesOflooseest(int totalbalesOflooseest) {
		this.totalbalesOflooseest = totalbalesOflooseest;
	}
	/**
	 * @return the totalbalesweightOflooseest
	 */
	public double getTotalbalesweightOflooseest() {
		return totalbalesweightOflooseest;
	}
	/**
	 * @param totalbalesweightOflooseest the totalbalesweightOflooseest to set
	 */
	public void setTotalbalesweightOflooseest(double totalbalesweightOflooseest) {
		this.totalbalesweightOflooseest = totalbalesweightOflooseest;
	}
	/**
	 * @return the ftotalbalesOfmwl
	 */
	public int getFtotalbalesOfmwl() {
		return FtotalbalesOfmwl;
	}
	/**
	 * @param ftotalbalesOfmwl the ftotalbalesOfmwl to set
	 */
	public void setFtotalbalesOfmwl(int ftotalbalesOfmwl) {
		FtotalbalesOfmwl = ftotalbalesOfmwl;
	}
	/**
	 * @return the ftotalbalesweightOfmwl
	 */
	public double getFtotalbalesweightOfmwl() {
		return FtotalbalesweightOfmwl;
	}
	/**
	 * @param ftotalbalesweightOfmwl the ftotalbalesweightOfmwl to set
	 */
	public void setFtotalbalesweightOfmwl(double ftotalbalesweightOfmwl) {
		FtotalbalesweightOfmwl = ftotalbalesweightOfmwl;
	}
	/**
	 * @return the ftotalbalesOfpmix
	 */
	public int getFtotalbalesOfpmix() {
		return FtotalbalesOfpmix;
	}
	/**
	 * @param ftotalbalesOfpmix the ftotalbalesOfpmix to set
	 */
	public void setFtotalbalesOfpmix(int ftotalbalesOfpmix) {
		FtotalbalesOfpmix = ftotalbalesOfpmix;
	}
	/**
	 * @return the ftotalbalesweightOfpmix
	 */
	public double getFtotalbalesweightOfpmix() {
		return FtotalbalesweightOfpmix;
	}
	/**
	 * @param ftotalbalesweightOfpmix the ftotalbalesweightOfpmix to set
	 */
	public void setFtotalbalesweightOfpmix(double ftotalbalesweightOfpmix) {
		FtotalbalesweightOfpmix = ftotalbalesweightOfpmix;
	}
	/**
	 * @return the ftotalbalesOfmcl
	 */
	public int getFtotalbalesOfmcl() {
		return FtotalbalesOfmcl;
	}
	/**
	 * @param ftotalbalesOfmcl the ftotalbalesOfmcl to set
	 */
	public void setFtotalbalesOfmcl(int ftotalbalesOfmcl) {
		FtotalbalesOfmcl = ftotalbalesOfmcl;
	}
	/**
	 * @return the ftotalbalesweightOfmcl
	 */
	public double getFtotalbalesweightOfmcl() {
		return FtotalbalesweightOfmcl;
	}
	/**
	 * @param ftotalbalesweightOfmcl the ftotalbalesweightOfmcl to set
	 */
	public void setFtotalbalesweightOfmcl(double ftotalbalesweightOfmcl) {
		FtotalbalesweightOfmcl = ftotalbalesweightOfmcl;
	}
	/**
	 * @return the ftotalbalesOfmwlwigs
	 */
	public int getFtotalbalesOfmwlwigs() {
		return FtotalbalesOfmwlwigs;
	}
	/**
	 * @param ftotalbalesOfmwlwigs the ftotalbalesOfmwlwigs to set
	 */
	public void setFtotalbalesOfmwlwigs(int ftotalbalesOfmwlwigs) {
		FtotalbalesOfmwlwigs = ftotalbalesOfmwlwigs;
	}
	/**
	 * @return the ftotalbalesweightOfmwlwigs
	 */
	public double getFtotalbalesweightOfmwlwigs() {
		return FtotalbalesweightOfmwlwigs;
	}
	/**
	 * @param ftotalbalesweightOfmwlwigs the ftotalbalesweightOfmwlwigs to set
	 */
	public void setFtotalbalesweightOfmwlwigs(double ftotalbalesweightOfmwlwigs) {
		FtotalbalesweightOfmwlwigs = ftotalbalesweightOfmwlwigs;
	}
	/**
	 * @return the ftotalbalesOfcbs
	 */
	public int getFtotalbalesOfcbs() {
		return FtotalbalesOfcbs;
	}
	/**
	 * @param ftotalbalesOfcbs the ftotalbalesOfcbs to set
	 */
	public void setFtotalbalesOfcbs(int ftotalbalesOfcbs) {
		FtotalbalesOfcbs = ftotalbalesOfcbs;
	}
	/**
	 * @return the ftotalbalesweightOfcbs
	 */
	public double getFtotalbalesweightOfcbs() {
		return FtotalbalesweightOfcbs;
	}
	/**
	 * @param ftotalbalesweightOfcbs the ftotalbalesweightOfcbs to set
	 */
	public void setFtotalbalesweightOfcbs(double ftotalbalesweightOfcbs) {
		FtotalbalesweightOfcbs = ftotalbalesweightOfcbs;
	}
	/**
	 * @return the ftotalbalesOfctdgdwd
	 */
	public int getFtotalbalesOfctdgdwd() {
		return FtotalbalesOfctdgdwd;
	}
	/**
	 * @param ftotalbalesOfctdgdwd the ftotalbalesOfctdgdwd to set
	 */
	public void setFtotalbalesOfctdgdwd(int ftotalbalesOfctdgdwd) {
		FtotalbalesOfctdgdwd = ftotalbalesOfctdgdwd;
	}
	/**
	 * @return the ftotalbalesweightOfctdgdwd
	 */
	public double getFtotalbalesweightOfctdgdwd() {
		return FtotalbalesweightOfctdgdwd;
	}
	/**
	 * @param ftotalbalesweightOfctdgdwd the ftotalbalesweightOfctdgdwd to set
	 */
	public void setFtotalbalesweightOfctdgdwd(double ftotalbalesweightOfctdgdwd) {
		FtotalbalesweightOfctdgdwd = ftotalbalesweightOfctdgdwd;
	}
	/**
	 * @return the ftotalbalesOfswl
	 */
	public int getFtotalbalesOfswl() {
		return FtotalbalesOfswl;
	}
	/**
	 * @param ftotalbalesOfswl the ftotalbalesOfswl to set
	 */
	public void setFtotalbalesOfswl(int ftotalbalesOfswl) {
		FtotalbalesOfswl = ftotalbalesOfswl;
	}
	/**
	 * @return the ftotalbalesweightOfswl
	 */
	public double getFtotalbalesweightOfswl() {
		return FtotalbalesweightOfswl;
	}
	/**
	 * @param ftotalbalesweightOfswl the ftotalbalesweightOfswl to set
	 */
	public void setFtotalbalesweightOfswl(double ftotalbalesweightOfswl) {
		FtotalbalesweightOfswl = ftotalbalesweightOfswl;
	}
	/**
	 * @return the ftotalbalesOfunctdflyleafshvgs
	 */
	public int getFtotalbalesOfunctdflyleafshvgs() {
		return FtotalbalesOfunctdflyleafshvgs;
	}
	/**
	 * @param ftotalbalesOfunctdflyleafshvgs the ftotalbalesOfunctdflyleafshvgs to set
	 */
	public void setFtotalbalesOfunctdflyleafshvgs(int ftotalbalesOfunctdflyleafshvgs) {
		FtotalbalesOfunctdflyleafshvgs = ftotalbalesOfunctdflyleafshvgs;
	}
	/**
	 * @return the ftotalbalesweightOfunctdflyleafshvgs
	 */
	public double getFtotalbalesweightOfunctdflyleafshvgs() {
		return FtotalbalesweightOfunctdflyleafshvgs;
	}
	/**
	 * @param ftotalbalesweightOfunctdflyleafshvgs the ftotalbalesweightOfunctdflyleafshvgs to set
	 */
	public void setFtotalbalesweightOfunctdflyleafshvgs(double ftotalbalesweightOfunctdflyleafshvgs) {
		FtotalbalesweightOfunctdflyleafshvgs = ftotalbalesweightOfunctdflyleafshvgs;
	}
	/**
	 * @return the ftotalbalesOflightprtsbs
	 */
	public int getFtotalbalesOflightprtsbs() {
		return FtotalbalesOflightprtsbs;
	}
	/**
	 * @param ftotalbalesOflightprtsbs the ftotalbalesOflightprtsbs to set
	 */
	public void setFtotalbalesOflightprtsbs(int ftotalbalesOflightprtsbs) {
		FtotalbalesOflightprtsbs = ftotalbalesOflightprtsbs;
	}
	/**
	 * @return the ftotalbalesweightOflightprtsbs
	 */
	public double getFtotalbalesweightOflightprtsbs() {
		return FtotalbalesweightOflightprtsbs;
	}
	/**
	 * @param ftotalbalesweightOflightprtsbs the ftotalbalesweightOflightprtsbs to set
	 */
	public void setFtotalbalesweightOflightprtsbs(double ftotalbalesweightOflightprtsbs) {
		FtotalbalesweightOflightprtsbs = ftotalbalesweightOflightprtsbs;
	}
	/**
	 * @return the ftotalbalesOfhw
	 */
	public int getFtotalbalesOfhw() {
		return FtotalbalesOfhw;
	}
	/**
	 * @param ftotalbalesOfhw the ftotalbalesOfhw to set
	 */
	public void setFtotalbalesOfhw(int ftotalbalesOfhw) {
		FtotalbalesOfhw = ftotalbalesOfhw;
	}
	/**
	 * @return the ftotalbalesweightOfhw
	 */
	public double getFtotalbalesweightOfhw() {
		return FtotalbalesweightOfhw;
	}
	/**
	 * @param ftotalbalesweightOfhw the ftotalbalesweightOfhw to set
	 */
	public void setFtotalbalesweightOfhw(double ftotalbalesweightOfhw) {
		FtotalbalesweightOfhw = ftotalbalesweightOfhw;
	}
	/**
	 * @return the ftotalbalesOfheavyprtsbs
	 */
	public int getFtotalbalesOfheavyprtsbs() {
		return FtotalbalesOfheavyprtsbs;
	}
	/**
	 * @param ftotalbalesOfheavyprtsbs the ftotalbalesOfheavyprtsbs to set
	 */
	public void setFtotalbalesOfheavyprtsbs(int ftotalbalesOfheavyprtsbs) {
		FtotalbalesOfheavyprtsbs = ftotalbalesOfheavyprtsbs;
	}
	/**
	 * @return the ftotalbalesweightOfheavyprtsbs
	 */
	public double getFtotalbalesweightOfheavyprtsbs() {
		return FtotalbalesweightOfheavyprtsbs;
	}
	/**
	 * @param ftotalbalesweightOfheavyprtsbs the ftotalbalesweightOfheavyprtsbs to set
	 */
	public void setFtotalbalesweightOfheavyprtsbs(double ftotalbalesweightOfheavyprtsbs) {
		FtotalbalesweightOfheavyprtsbs = ftotalbalesweightOfheavyprtsbs;
	}
	/**
	 * @return the ftotalbalesOfsow
	 */
	public int getFtotalbalesOfsow() {
		return FtotalbalesOfsow;
	}
	/**
	 * @param ftotalbalesOfsow the ftotalbalesOfsow to set
	 */
	public void setFtotalbalesOfsow(int ftotalbalesOfsow) {
		FtotalbalesOfsow = ftotalbalesOfsow;
	}
	/**
	 * @return the ftotalbalesweightOfsow
	 */
	public double getFtotalbalesweightOfsow() {
		return FtotalbalesweightOfsow;
	}
	/**
	 * @param ftotalbalesweightOfsow the ftotalbalesweightOfsow to set
	 */
	public void setFtotalbalesweightOfsow(double ftotalbalesweightOfsow) {
		FtotalbalesweightOfsow = ftotalbalesweightOfsow;
	}
	/**
	 * @return the ftotalbalesOfnewsblank
	 */
	public int getFtotalbalesOfnewsblank() {
		return FtotalbalesOfnewsblank;
	}
	/**
	 * @param ftotalbalesOfnewsblank the ftotalbalesOfnewsblank to set
	 */
	public void setFtotalbalesOfnewsblank(int ftotalbalesOfnewsblank) {
		FtotalbalesOfnewsblank = ftotalbalesOfnewsblank;
	}
	/**
	 * @return the ftotalbalesweightOfnewsblank
	 */
	public double getFtotalbalesweightOfnewsblank() {
		return FtotalbalesweightOfnewsblank;
	}
	/**
	 * @param ftotalbalesweightOfnewsblank the ftotalbalesweightOfnewsblank to set
	 */
	public void setFtotalbalesweightOfnewsblank(double ftotalbalesweightOfnewsblank) {
		FtotalbalesweightOfnewsblank = ftotalbalesweightOfnewsblank;
	}
	/**
	 * @return the ftotalbalesOfocccorrugated
	 */
	public int getFtotalbalesOfocccorrugated() {
		return FtotalbalesOfocccorrugated;
	}
	/**
	 * @param ftotalbalesOfocccorrugated the ftotalbalesOfocccorrugated to set
	 */
	public void setFtotalbalesOfocccorrugated(int ftotalbalesOfocccorrugated) {
		FtotalbalesOfocccorrugated = ftotalbalesOfocccorrugated;
	}
	/**
	 * @return the ftotalbalesweightOfocccorrugated
	 */
	public double getFtotalbalesweightOfocccorrugated() {
		return FtotalbalesweightOfocccorrugated;
	}
	/**
	 * @param ftotalbalesweightOfocccorrugated the ftotalbalesweightOfocccorrugated to set
	 */
	public void setFtotalbalesweightOfocccorrugated(double ftotalbalesweightOfocccorrugated) {
		FtotalbalesweightOfocccorrugated = ftotalbalesweightOfocccorrugated;
	}
	/**
	 * @return the ftotalbalesOfdlk
	 */
	public int getFtotalbalesOfdlk() {
		return FtotalbalesOfdlk;
	}
	/**
	 * @param ftotalbalesOfdlk the ftotalbalesOfdlk to set
	 */
	public void setFtotalbalesOfdlk(int ftotalbalesOfdlk) {
		FtotalbalesOfdlk = ftotalbalesOfdlk;
	}
	/**
	 * @return the ftotalbalesweightOfdlk
	 */
	public double getFtotalbalesweightOfdlk() {
		return FtotalbalesweightOfdlk;
	}
	/**
	 * @param ftotalbalesweightOfdlk the ftotalbalesweightOfdlk to set
	 */
	public void setFtotalbalesweightOfdlk(double ftotalbalesweightOfdlk) {
		FtotalbalesweightOfdlk = ftotalbalesweightOfdlk;
	}
	/**
	 * @return the ftotalbalesOfmixedpaper
	 */
	public int getFtotalbalesOfmixedpaper() {
		return FtotalbalesOfmixedpaper;
	}
	/**
	 * @param ftotalbalesOfmixedpaper the ftotalbalesOfmixedpaper to set
	 */
	public void setFtotalbalesOfmixedpaper(int ftotalbalesOfmixedpaper) {
		FtotalbalesOfmixedpaper = ftotalbalesOfmixedpaper;
	}
	/**
	 * @return the ftotalbalesweightOfmixedpaper
	 */
	public double getFtotalbalesweightOfmixedpaper() {
		return FtotalbalesweightOfmixedpaper;
	}
	/**
	 * @param ftotalbalesweightOfmixedpaper the ftotalbalesweightOfmixedpaper to set
	 */
	public void setFtotalbalesweightOfmixedpaper(double ftotalbalesweightOfmixedpaper) {
		FtotalbalesweightOfmixedpaper = ftotalbalesweightOfmixedpaper;
	}
	/**
	 * @return the ftotalbalesOfsoftwoodchips
	 */
	public int getFtotalbalesOfsoftwoodchips() {
		return FtotalbalesOfsoftwoodchips;
	}
	/**
	 * @param ftotalbalesOfsoftwoodchips the ftotalbalesOfsoftwoodchips to set
	 */
	public void setFtotalbalesOfsoftwoodchips(int ftotalbalesOfsoftwoodchips) {
		FtotalbalesOfsoftwoodchips = ftotalbalesOfsoftwoodchips;
	}
	/**
	 * @return the ftotalbalesweightOfsoftwoodchips
	 */
	public double getFtotalbalesweightOfsoftwoodchips() {
		return FtotalbalesweightOfsoftwoodchips;
	}
	/**
	 * @param ftotalbalesweightOfsoftwoodchips the ftotalbalesweightOfsoftwoodchips to set
	 */
	public void setFtotalbalesweightOfsoftwoodchips(double ftotalbalesweightOfsoftwoodchips) {
		FtotalbalesweightOfsoftwoodchips = ftotalbalesweightOfsoftwoodchips;
	}
	/**
	 * @return the ftotalbalesOfhardwoodchips
	 */
	public int getFtotalbalesOfhardwoodchips() {
		return FtotalbalesOfhardwoodchips;
	}
	/**
	 * @param ftotalbalesOfhardwoodchips the ftotalbalesOfhardwoodchips to set
	 */
	public void setFtotalbalesOfhardwoodchips(int ftotalbalesOfhardwoodchips) {
		FtotalbalesOfhardwoodchips = ftotalbalesOfhardwoodchips;
	}
	/**
	 * @return the ftotalbalesweightOfhardwoodchips
	 */
	public double getFtotalbalesweightOfhardwoodchips() {
		return FtotalbalesweightOfhardwoodchips;
	}
	/**
	 * @param ftotalbalesweightOfhardwoodchips the ftotalbalesweightOfhardwoodchips to set
	 */
	public void setFtotalbalesweightOfhardwoodchips(double ftotalbalesweightOfhardwoodchips) {
		FtotalbalesweightOfhardwoodchips = ftotalbalesweightOfhardwoodchips;
	}
	/**
	 * @return the ftotalbalesOfpwe
	 */
	public int getFtotalbalesOfpwe() {
		return FtotalbalesOfpwe;
	}
	/**
	 * @param ftotalbalesOfpwe the ftotalbalesOfpwe to set
	 */
	public void setFtotalbalesOfpwe(int ftotalbalesOfpwe) {
		FtotalbalesOfpwe = ftotalbalesOfpwe;
	}
	/**
	 * @return the ftotalbalesweightOfpwe
	 */
	public double getFtotalbalesweightOfpwe() {
		return FtotalbalesweightOfpwe;
	}
	/**
	 * @param ftotalbalesweightOfpwe the ftotalbalesweightOfpwe to set
	 */
	public void setFtotalbalesweightOfpwe(double ftotalbalesweightOfpwe) {
		FtotalbalesweightOfpwe = ftotalbalesweightOfpwe;
	}
	/**
	 * @return the ftotalbalesOfpulpwetlap
	 */
	public int getFtotalbalesOfpulpwetlap() {
		return FtotalbalesOfpulpwetlap;
	}
	/**
	 * @param ftotalbalesOfpulpwetlap the ftotalbalesOfpulpwetlap to set
	 */
	public void setFtotalbalesOfpulpwetlap(int ftotalbalesOfpulpwetlap) {
		FtotalbalesOfpulpwetlap = ftotalbalesOfpulpwetlap;
	}
	/**
	 * @return the ftotalbalesweightOfpulpwetlap
	 */
	public double getFtotalbalesweightOfpulpwetlap() {
		return FtotalbalesweightOfpulpwetlap;
	}
	/**
	 * @param ftotalbalesweightOfpulpwetlap the ftotalbalesweightOfpulpwetlap to set
	 */
	public void setFtotalbalesweightOfpulpwetlap(double ftotalbalesweightOfpulpwetlap) {
		FtotalbalesweightOfpulpwetlap = ftotalbalesweightOfpulpwetlap;
	}
	/**
	 * @return the ftotalbalesOfvirginpulp
	 */
	public int getFtotalbalesOfvirginpulp() {
		return FtotalbalesOfvirginpulp;
	}
	/**
	 * @param ftotalbalesOfvirginpulp the ftotalbalesOfvirginpulp to set
	 */
	public void setFtotalbalesOfvirginpulp(int ftotalbalesOfvirginpulp) {
		FtotalbalesOfvirginpulp = ftotalbalesOfvirginpulp;
	}
	/**
	 * @return the ftotalbalesweightOfvirginpulp
	 */
	public double getFtotalbalesweightOfvirginpulp() {
		return FtotalbalesweightOfvirginpulp;
	}
	/**
	 * @param ftotalbalesweightOfvirginpulp the ftotalbalesweightOfvirginpulp to set
	 */
	public void setFtotalbalesweightOfvirginpulp(double ftotalbalesweightOfvirginpulp) {
		FtotalbalesweightOfvirginpulp = ftotalbalesweightOfvirginpulp;
	}
	/**
	 * @return the ftotalbalesOfpulpdrylap
	 */
	public int getFtotalbalesOfpulpdrylap() {
		return FtotalbalesOfpulpdrylap;
	}
	/**
	 * @param ftotalbalesOfpulpdrylap the ftotalbalesOfpulpdrylap to set
	 */
	public void setFtotalbalesOfpulpdrylap(int ftotalbalesOfpulpdrylap) {
		FtotalbalesOfpulpdrylap = ftotalbalesOfpulpdrylap;
	}
	/**
	 * @return the ftotalbalesweightOfpulpdrylap
	 */
	public double getFtotalbalesweightOfpulpdrylap() {
		return FtotalbalesweightOfpulpdrylap;
	}
	/**
	 * @param ftotalbalesweightOfpulpdrylap the ftotalbalesweightOfpulpdrylap to set
	 */
	public void setFtotalbalesweightOfpulpdrylap(double ftotalbalesweightOfpulpdrylap) {
		FtotalbalesweightOfpulpdrylap = ftotalbalesweightOfpulpdrylap;
	}
	/**
	 * @return the ftotalbalesOfother
	 */
	public int getFtotalbalesOfother() {
		return FtotalbalesOfother;
	}
	/**
	 * @param ftotalbalesOfother the ftotalbalesOfother to set
	 */
	public void setFtotalbalesOfother(int ftotalbalesOfother) {
		FtotalbalesOfother = ftotalbalesOfother;
	}
	/**
	 * @return the ftotalbalesweightOfother
	 */
	public double getFtotalbalesweightOfother() {
		return FtotalbalesweightOfother;
	}
	/**
	 * @param ftotalbalesweightOfother the ftotalbalesweightOfother to set
	 */
	public void setFtotalbalesweightOfother(double ftotalbalesweightOfother) {
		FtotalbalesweightOfother = ftotalbalesweightOfother;
	}
	/**
	 * @return the ftotalbalesOfotherrolls
	 */
	public int getFtotalbalesOfotherrolls() {
		return FtotalbalesOfotherrolls;
	}
	/**
	 * @param ftotalbalesOfotherrolls the ftotalbalesOfotherrolls to set
	 */
	public void setFtotalbalesOfotherrolls(int ftotalbalesOfotherrolls) {
		FtotalbalesOfotherrolls = ftotalbalesOfotherrolls;
	}
	/**
	 * @return the ftotalbalesweightOfotherrolls
	 */
	public double getFtotalbalesweightOfotherrolls() {
		return FtotalbalesweightOfotherrolls;
	}
	/**
	 * @param ftotalbalesweightOfotherrolls the ftotalbalesweightOfotherrolls to set
	 */
	public void setFtotalbalesweightOfotherrolls(double ftotalbalesweightOfotherrolls) {
		FtotalbalesweightOfotherrolls = ftotalbalesweightOfotherrolls;
	}
	/**
	 * @return the ftotalbalesOfstbaleswetlap
	 */
	public int getFtotalbalesOfstbaleswetlap() {
		return FtotalbalesOfstbaleswetlap;
	}
	/**
	 * @param ftotalbalesOfstbaleswetlap the ftotalbalesOfstbaleswetlap to set
	 */
	public void setFtotalbalesOfstbaleswetlap(int ftotalbalesOfstbaleswetlap) {
		FtotalbalesOfstbaleswetlap = ftotalbalesOfstbaleswetlap;
	}
	/**
	 * @return the ftotalbalesweightOfstbaleswetlap
	 */
	public double getFtotalbalesweightOfstbaleswetlap() {
		return FtotalbalesweightOfstbaleswetlap;
	}
	/**
	 * @param ftotalbalesweightOfstbaleswetlap the ftotalbalesweightOfstbaleswetlap to set
	 */
	public void setFtotalbalesweightOfstbaleswetlap(double ftotalbalesweightOfstbaleswetlap) {
		FtotalbalesweightOfstbaleswetlap = ftotalbalesweightOfstbaleswetlap;
	}
	/**
	 * @return the totalbalesweightofVirginSoftWood
	 */
	public double getTotalbalesweightofVirginSoftWood() {
		return totalbalesweightofVirginSoftWood;
	}
	/**
	 * @param totalbalesweightofVirginSoftWood the totalbalesweightofVirginSoftWood to set
	 */
	public void setTotalbalesweightofVirginSoftWood(double totalbalesweightofVirginSoftWood) {
		this.totalbalesweightofVirginSoftWood = totalbalesweightofVirginSoftWood;
	}
	/**
	 * @return the totalbalesofVirginSoftWood
	 */
	public int getTotalbalesofVirginSoftWood() {
		return totalbalesofVirginSoftWood;
	}
	/**
	 * @param totalbalesofVirginSoftWood the totalbalesofVirginSoftWood to set
	 */
	public void setTotalbalesofVirginSoftWood(int totalbalesofVirginSoftWood) {
		this.totalbalesofVirginSoftWood = totalbalesofVirginSoftWood;
	}
	/**
	 * @return the totalbalesweightofVirginHardWood
	 */
	public double getTotalbalesweightofVirginHardWood() {
		return totalbalesweightofVirginHardWood;
	}
	/**
	 * @param totalbalesweightofVirginHardWood the totalbalesweightofVirginHardWood to set
	 */
	public void setTotalbalesweightofVirginHardWood(double totalbalesweightofVirginHardWood) {
		this.totalbalesweightofVirginHardWood = totalbalesweightofVirginHardWood;
	}
	/**
	 * @return the totalbalesofVirginHardWood
	 */
	public int getTotalbalesofVirginHardWood() {
		return totalbalesofVirginHardWood;
	}
	/**
	 * @param totalbalesofVirginHardWood the totalbalesofVirginHardWood to set
	 */
	public void setTotalbalesofVirginHardWood(int totalbalesofVirginHardWood) {
		this.totalbalesofVirginHardWood = totalbalesofVirginHardWood;
	}
	/**
	 * @return the totalbalesweightofVirginEucalyptus
	 */
	public double getTotalbalesweightofVirginEucalyptus() {
		return totalbalesweightofVirginEucalyptus;
	}
	/**
	 * @param totalbalesweightofVirginEucalyptus the totalbalesweightofVirginEucalyptus to set
	 */
	public void setTotalbalesweightofVirginEucalyptus(double totalbalesweightofVirginEucalyptus) {
		this.totalbalesweightofVirginEucalyptus = totalbalesweightofVirginEucalyptus;
	}
	/**
	 * @return the totalbalesofVirginEucalyptus
	 */
	public int getTotalbalesofVirginEucalyptus() {
		return totalbalesofVirginEucalyptus;
	}
	/**
	 * @param totalbalesofVirginEucalyptus the totalbalesofVirginEucalyptus to set
	 */
	public void setTotalbalesofVirginEucalyptus(int totalbalesofVirginEucalyptus) {
		this.totalbalesofVirginEucalyptus = totalbalesofVirginEucalyptus;
	}
	/**
	 * @return the totalbalesweightofScnNews
	 */
	public double getTotalbalesweightofScnNews() {
		return totalbalesweightofScnNews;
	}
	/**
	 * @param totalbalesweightofScnNews the totalbalesweightofScnNews to set
	 */
	public void setTotalbalesweightofScnNews(double totalbalesweightofScnNews) {
		this.totalbalesweightofScnNews = totalbalesweightofScnNews;
	}
	/**
	 * @return the totalbalesofScnNews
	 */
	public int getTotalbalesofScnNews() {
		return totalbalesofScnNews;
	}
	/**
	 * @param totalbalesofScnNews the totalbalesofScnNews to set
	 */
	public void setTotalbalesofScnNews(int totalbalesofScnNews) {
		this.totalbalesofScnNews = totalbalesofScnNews;
	}
	/**
	 * @return the totalbalesweightofVirginSW_Fluff
	 */
	public double getTotalbalesweightofVirginSW_Fluff() {
		return totalbalesweightofVirginSW_Fluff;
	}
	/**
	 * @param totalbalesweightofVirginSW_Fluff the totalbalesweightofVirginSW_Fluff to set
	 */
	public void setTotalbalesweightofVirginSW_Fluff(double totalbalesweightofVirginSW_Fluff) {
		this.totalbalesweightofVirginSW_Fluff = totalbalesweightofVirginSW_Fluff;
	}
	/**
	 * @return the totalbalesofVirginSW_Fluff
	 */
	public int getTotalbalesofVirginSW_Fluff() {
		return totalbalesofVirginSW_Fluff;
	}
	/**
	 * @param totalbalesofVirginSW_Fluff the totalbalesofVirginSW_Fluff to set
	 */
	public void setTotalbalesofVirginSW_Fluff(int totalbalesofVirginSW_Fluff) {
		this.totalbalesofVirginSW_Fluff = totalbalesofVirginSW_Fluff;
	}
	/**
	 * @return the consumeddate
	 */
	public Date getConsumeddate() {
		return consumeddate;
	}
	/**
	 * @param consumeddate the consumeddate to set
	 */
	public void setConsumeddate(Date consumeddate) {
		this.consumeddate = consumeddate;
	}
	/**
	 * @return the consumedtime
	 */
	public Date getConsumedtime() {
		return consumedtime;
	}
	/**
	 * @param consumedtime the consumedtime to set
	 */
	public void setConsumedtime(Date consumedtime) {
		this.consumedtime = consumedtime;
	}
	/**
	 * @return the baleweight
	 */
	public double getBaleweight() {
		return baleweight;
	}
	/**
	 * @param baleweight the baleweight to set
	 */
	public void setBaleweight(double baleweight) {
		this.baleweight = baleweight;
	}
	/**
	 * @return the gradecode
	 */
	public int getGradecode() {
		return gradecode;
	}
	/**
	 * @param gradecode the gradecode to set
	 */
	public void setGradecode(int gradecode) {
		this.gradecode = gradecode;
	}
	/**
	 * @return the consumeddatetime
	 */
	public Date getConsumeddatetime() {
		return consumeddatetime;
	}
	/**
	 * @param consumeddatetime the consumeddatetime to set
	 */
	public void setConsumeddatetime(Date consumeddatetime) {
		this.consumeddatetime = consumeddatetime;
	}
	/**
	 * @return the yieldbroke
	 */
	public double getYieldbroke() {
		return yieldbroke;
	}
	/**
	 * @param yieldbroke the yieldbroke to set
	 */
	public void setYieldbroke(double yieldbroke) {
		this.yieldbroke = yieldbroke;
	}
	/**
	 * @return the yieldcgwd
	 */
	public double getYieldcgwd() {
		return yieldcgwd;
	}
	/**
	 * @param yieldcgwd the yieldcgwd to set
	 */
	public void setYieldcgwd(double yieldcgwd) {
		this.yieldcgwd = yieldcgwd;
	}
	/**
	 * @return the yieldcgwdsection
	 */
	public double getYieldcgwdsection() {
		return yieldcgwdsection;
	}
	/**
	 * @param yieldcgwdsection the yieldcgwdsection to set
	 */
	public void setYieldcgwdsection(double yieldcgwdsection) {
		this.yieldcgwdsection = yieldcgwdsection;
	}
	/**
	 * @return the yieldsw
	 */
	public double getYieldsw() {
		return yieldsw;
	}
	/**
	 * @param yieldsw the yieldsw to set
	 */
	public void setYieldsw(double yieldsw) {
		this.yieldsw = yieldsw;
	}
	/**
	 * @return the yieldwhitebland
	 */
	public double getYieldwhitebland() {
		return yieldwhitebland;
	}
	/**
	 * @param yieldwhitebland the yieldwhitebland to set
	 */
	public void setYieldwhitebland(double yieldwhitebland) {
		this.yieldwhitebland = yieldwhitebland;
	}
	/**
	 * @return the yieldwhiteblend
	 */
	public double getYieldwhiteblend() {
		return yieldwhiteblend;
	}
	/**
	 * @param yieldwhiteblend the yieldwhiteblend to set
	 */
	public void setYieldwhiteblend(double yieldwhiteblend) {
		this.yieldwhiteblend = yieldwhiteblend;
	}
	/**
	 * @return the yieldstbaleswetLap
	 */
	public double getYieldstbaleswetLap() {
		return yieldstbaleswetLap;
	}
	/**
	 * @param yieldstbaleswetLap the yieldstbaleswetLap to set
	 */
	public void setYieldstbaleswetLap(double yieldstbaleswetLap) {
		this.yieldstbaleswetLap = yieldstbaleswetLap;
	}
	/**
	 * @return the yieldscavirginpulp
	 */
	public double getYieldscavirginpulp() {
		return yieldscavirginpulp;
	}
	/**
	 * @param yieldscavirginpulp the yieldscavirginpulp to set
	 */
	public void setYieldscavirginpulp(double yieldscavirginpulp) {
		this.yieldscavirginpulp = yieldscavirginpulp;
	}
	/**
	 * @return the yieldtrimloss
	 */
	public double getYieldtrimloss() {
		return yieldtrimloss;
	}
	/**
	 * @param yieldtrimloss the yieldtrimloss to set
	 */
	public void setYieldtrimloss(double yieldtrimloss) {
		this.yieldtrimloss = yieldtrimloss;
	}
	/**
	 * @return the yieldtotalofpulpar3
	 */
	public double getYieldtotalofpulpar3() {
		return yieldtotalofpulpar3;
	}
	/**
	 * @param yieldtotalofpulpar3 the yieldtotalofpulpar3 to set
	 */
	public void setYieldtotalofpulpar3(double yieldtotalofpulpar3) {
		this.yieldtotalofpulpar3 = yieldtotalofpulpar3;
	}
	/**
	 * @return the yieldtotalofpulpar4
	 */
	public double getYieldtotalofpulpar4() {
		return yieldtotalofpulpar4;
	}
	/**
	 * @param yieldtotalofpulpar4 the yieldtotalofpulpar4 to set
	 */
	public void setYieldtotalofpulpar4(double yieldtotalofpulpar4) {
		this.yieldtotalofpulpar4 = yieldtotalofpulpar4;
	}
	/**
	 * @return the yieldtotalmillproduction
	 */
	public double getYieldtotalmillproduction() {
		return yieldtotalmillproduction;
	}
	/**
	 * @param yieldtotalmillproduction the yieldtotalmillproduction to set
	 */
	public void setYieldtotalmillproduction(double yieldtotalmillproduction) {
		this.yieldtotalmillproduction = yieldtotalmillproduction;
	}
	/**
	 * @return the stvirginproduction
	 */
	public double getStvirginproduction() {
		return stvirginproduction;
	}
	/**
	 * @param stvirginproduction the stvirginproduction to set
	 */
	public void setStvirginproduction(double stvirginproduction) {
		this.stvirginproduction = stvirginproduction;
	}
}

/**
 * 
 */
package com.st.frpproduction.model;

import java.util.Date;

/**
 * @author sbora
 *
 */
public class FrpProdcution {
	private int id;
	private Date date;
	private double hdStorage;
	private double dcsWPFeedADST;
	private double primaryPressADST;
	private double wetLapProdADST;
	private double totalProdADST;
	private double trackerWPfeed;
	private double yieldDcs;
	private double yieldTracker;
	private double freshWater;
	private double mrMwlAndSwl;
	private double mrSowAndCbs;
	private double mrDlk;
	private double mrOcc;
	private double mrWhiteGrades;
	private double mrGroundwood;
	private double mrOther;
	private double wpmMwl;
	private double wpmPrintMix;
	private double wpmSow;
	private double wpmCbs;
	private double wpmSowAndCbs;
	private double wpmCtdGrwd;
	private double wpmSwl;
	private double wpmOcc;
	private double wpmNewsNewsblank;
	private double wpmDlk;
	private double wpmOther;
	private double wpmTotal;
	private String targetBrightness;
	private double dailyAvg;
	private String pmTargetBrite;
	private String pmAvgBrite;
	private String comments;
	private String prodType;
	private String grade;
	
	//New fields
	private double wpMailUndeliverable;
	
	private double freshWater2;
	
//	Code Starts From Here Done By Roshan Tailor Date :- 03/17/2015
	private String clarifierunderflowpumpruningYN;
	private double sludgepressconsistency;
	private double screwpressconsistency;
	private double mixratiobrightness;
	private double eric;
	private String astar;
	private String bstar;
//	Code Ends Here Done By Roshan Tailor
	
	//Temp
	private double dcsWPFeedADSTTotal;
	private double totalProdADSTTotal;
	private double trackerWPfeedTotal;
	
	//Code Starts From Here Done By Roshan Tailor 04/27/2016
	private double col1;
	private double col2;
	private double col3;
	private double col4;
	private double col5;
	private double col6;
	private double col7;
	private double col8;
	private double col9;
	private double col10;
	private double col11;
	
	private double totalcol1;
	private double totalcol2;
	private double totalcol3;
	private double totalcol4;
	private double totalcol5;
	private double totalcol6;
	private double totalcol7;
	private double totalcol8;
	private double totalcol9;
	private double totalcol10;
	private double totalcol11;
	
	private double col1forday;
	private double col1fornight;
	private double col2forday;
	private double col2fornight;
	private double col3forday;
	private double col3fornight;
	private double col4forday;
	private double col4fornight;
	private double col5forday;
	private double col5fornight;
	private double col6forday;
	private double col6fornight;
	private double col7forday;
	private double col7fornight;
	private double col8forday;
	private double col8fornight;
	private double col9forday;
	private double col9fornight;
	private double col10forday;
	private double col10fornight;
	private double col11forday;
	private double col11fornight;
	//Code Ends Here Done By Roshan Tailor 04/27/2016
	public double getDcsWPFeedADSTTotal() {
		return dcsWPFeedADSTTotal;
	}
	public void setDcsWPFeedADSTTotal(double dcsWPFeedADSTTotal) {
		this.dcsWPFeedADSTTotal = dcsWPFeedADSTTotal;
	}
	public double getTotalProdADSTTotal() {
		return totalProdADSTTotal;
	}
	public void setTotalProdADSTTotal(double totalProdADSTTotal) {
		this.totalProdADSTTotal = totalProdADSTTotal;
	}
	public double getTrackerWPfeedTotal() {
		return trackerWPfeedTotal;
	}
	public void setTrackerWPfeedTotal(double trackerWPfeedTotal) {
		this.trackerWPfeedTotal = trackerWPfeedTotal;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public double getHdStorage() {
		return hdStorage;
	}
	public void setHdStorage(double hdStorage) {
		this.hdStorage = hdStorage;
	}
	public double getDcsWPFeedADST() {
		return dcsWPFeedADST;
	}
	public void setDcsWPFeedADST(double dcsWPFeedADST) {
		this.dcsWPFeedADST = dcsWPFeedADST;
	}
	public double getPrimaryPressADST() {
		return primaryPressADST;
	}
	public void setPrimaryPressADST(double primaryPressADST) {
		this.primaryPressADST = primaryPressADST;
	}
	public double getWetLapProdADST() {
		return wetLapProdADST;
	}
	public void setWetLapProdADST(double wetLapProdADST) {
		this.wetLapProdADST = wetLapProdADST;
	}
	public double getTotalProdADST() {
		return totalProdADST;
	}
	public void setTotalProdADST(double totalProdADST) {
		this.totalProdADST = totalProdADST;
	}
	public double getTrackerWPfeed() {
		return trackerWPfeed;
	}
	public void setTrackerWPfeed(double trackerWPfeed) {
		this.trackerWPfeed = trackerWPfeed;
	}

	
	public double getYieldDcs() {
		return yieldDcs;
	}
	public void setYieldDcs(double yieldDcs) {
		this.yieldDcs = yieldDcs;
	}
	public double getYieldTracker() {
		return yieldTracker;
	}
	public void setYieldTracker(double yieldTracker) {
		this.yieldTracker = yieldTracker;
	}
	public double getFreshWater() {
		return freshWater;
	}
	public void setFreshWater(double freshWater) {
		this.freshWater = freshWater;
	}
	public double getMrMwlAndSwl() {
		return mrMwlAndSwl;
	}
	public void setMrMwlAndSwl(double mrMwlAndSwl) {
		this.mrMwlAndSwl = mrMwlAndSwl;
	}
	public double getMrSowAndCbs() {
		return mrSowAndCbs;
	}
	public void setMrSowAndCbs(double mrSowAndCbs) {
		this.mrSowAndCbs = mrSowAndCbs;
	}
	public double getMrDlk() {
		return mrDlk;
	}
	public void setMrDlk(double mrDlk) {
		this.mrDlk = mrDlk;
	}
	public double getMrOcc() {
		return mrOcc;
	}
	public void setMrOcc(double mrOcc) {
		this.mrOcc = mrOcc;
	}
	public double getMrWhiteGrades() {
		return mrWhiteGrades;
	}
	public void setMrWhiteGrades(double mrWhiteGrades) {
		this.mrWhiteGrades = mrWhiteGrades;
	}
	public double getMrGroundwood() {
		return mrGroundwood;
	}
	public void setMrGroundwood(double mrGroundwood) {
		this.mrGroundwood = mrGroundwood;
	}
	public double getMrOther() {
		return mrOther;
	}
	public void setMrOther(double mrOther) {
		this.mrOther = mrOther;
	}
	
	public double getWpmMwl() {
		return wpmMwl;
	}
	public void setWpmMwl(double wpmMwl) {
		this.wpmMwl = wpmMwl;
	}
	public double getWpmPrintMix() {
		return wpmPrintMix;
	}
	public void setWpmPrintMix(double wpmPrintMix) {
		this.wpmPrintMix = wpmPrintMix;
	}
	public double getWpmSow() {
		return wpmSow;
	}
	public void setWpmSow(double wpmSow) {
		this.wpmSow = wpmSow;
	}
	public double getWpmCbs() {
		return wpmCbs;
	}
	public void setWpmCbs(double wpmCbs) {
		this.wpmCbs = wpmCbs;
	}
	public double getWpmSowAndCbs() {
		return wpmSowAndCbs;
	}
	public void setWpmSowAndCbs(double wpmSowAndCbs) {
		this.wpmSowAndCbs = wpmSowAndCbs;
	}
	public double getWpmCtdGrwd() {
		return wpmCtdGrwd;
	}
	public void setWpmCtdGrwd(double wpmCtdGrwd) {
		this.wpmCtdGrwd = wpmCtdGrwd;
	}
	public double getWpmSwl() {
		return wpmSwl;
	}
	public void setWpmSwl(double wpmSwl) {
		this.wpmSwl = wpmSwl;
	}
	public double getWpmOcc() {
		return wpmOcc;
	}
	public void setWpmOcc(double wpmOcc) {
		this.wpmOcc = wpmOcc;
	}
	public double getWpmNewsNewsblank() {
		return wpmNewsNewsblank;
	}
	public void setWpmNewsNewsblank(double wpmNewsNewsblank) {
		this.wpmNewsNewsblank = wpmNewsNewsblank;
	}
	public double getWpmDlk() {
		return wpmDlk;
	}
	public void setWpmDlk(double wpmDlk) {
		this.wpmDlk = wpmDlk;
	}
	public double getWpmOther() {
		return wpmOther;
	}
	public void setWpmOther(double wpmOther) {
		this.wpmOther = wpmOther;
	}
	public String getTargetBrightness() {
		return targetBrightness;
	}
	public void setTargetBrightness(String targetBrightness) {
		this.targetBrightness = targetBrightness;
	}
	public double getDailyAvg() {
		return dailyAvg;
	}
	public void setDailyAvg(double dailyAvg) {
		this.dailyAvg = dailyAvg;
	}
	public String getPmTargetBrite() {
		return pmTargetBrite;
	}
	public void setPmTargetBrite(String pmTargetBrite) {
		this.pmTargetBrite = pmTargetBrite;
	}
	public String getPmAvgBrite() {
		return pmAvgBrite;
	}
	public void setPmAvgBrite(String pmAvgBrite) {
		this.pmAvgBrite = pmAvgBrite;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	/**
	 * @return the prodType
	 */
	public String getProdType() {
		return prodType;
	}
	/**
	 * @param prodType the prodType to set
	 */
	public void setProdType(String prodType) {
		this.prodType = prodType;
	}
	/**
	 * @return the wpmTotal
	 */
	public double getWpmTotal() {
		return wpmTotal;
	}
	/**
	 * @param wpmTotal the wpmTotal to set
	 */
	public void setWpmTotal(double wpmTotal) {
		this.wpmTotal = wpmTotal;
	}
	public double getWpMailUndeliverable() {
		return wpMailUndeliverable;
	}
	public void setWpMailUndeliverable(double wpMailUndeliverable) {
		this.wpMailUndeliverable = wpMailUndeliverable;
	}
	/**
	 * @return the grade
	 */
	public String getGrade() {
		return grade;
	}
	/**
	 * @param grade the grade to set
	 */
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public double getFreshWater2() {
		return freshWater2;
	}
	public void setFreshWater2(double freshWater2) {
		this.freshWater2 = freshWater2;
	}
//	Code Starts From Here Done By Roshan Tailor Date :- 03/17/2015
	public String getClarifierunderflowpumpruningYN() {
		return clarifierunderflowpumpruningYN;
	}
	public void setClarifierunderflowpumpruningYN(String clarifierunderflowpumpruningYN) {
		this.clarifierunderflowpumpruningYN=clarifierunderflowpumpruningYN;
	}
	public double getSludgepressconsistency() {
		return sludgepressconsistency;
	}
	public void setSludgepressconsistency(double sludgepressconsistency) {
		this.sludgepressconsistency=sludgepressconsistency;
	}
	public double getScrewpressconsistency() {
		return screwpressconsistency;
	}
	public void setScrewpressconsistency(double screwpressconsistency) {
		this.screwpressconsistency=screwpressconsistency;
	}
	public double getMixratiobrightness() {
		return mixratiobrightness;
	}
	public void setMixratiobrightness(double mixratiobrightness) {
		this.mixratiobrightness=mixratiobrightness;
	}
	public double getEric() {
		return eric;
	}
	public void setEric(double eric) {
		this.eric=eric;
	}
	public String getAstar() {
		return astar;
	}
	public void setAstar(String astar) {
		this.astar=astar;
	}
	public String getBstar() {
		return bstar;
	}
	public void setBstar(String bstar) {
		this.bstar=bstar;
	}
//	Code Ends Here Done By Roshan Tailor
	public double getCol1() {
		return col1;
	}
	public void setCol1(double col1) {
		this.col1 = col1;
	}
	public double getCol2() {
		return col2;
	}
	public void setCol2(double col2) {
		this.col2 = col2;
	}
	public double getCol3() {
		return col3;
	}
	public void setCol3(double col3) {
		this.col3 = col3;
	}
	public double getCol4() {
		return col4;
	}
	public void setCol4(double col4) {
		this.col4 = col4;
	}
	public double getCol5() {
		return col5;
	}
	public void setCol5(double col5) {
		this.col5 = col5;
	}
	public double getCol6() {
		return col6;
	}
	public void setCol6(double col6) {
		this.col6 = col6;
	}
	public double getCol7() {
		return col7;
	}
	public void setCol7(double col7) {
		this.col7 = col7;
	}
	public double getCol8() {
		return col8;
	}
	public void setCol8(double col8) {
		this.col8 = col8;
	}
	public double getCol9() {
		return col9;
	}
	public void setCol9(double col9) {
		this.col9 = col9;
	}
	public double getCol10() {
		return col10;
	}
	public void setCol10(double col10) {
		this.col10 = col10;
	}
	public double getCol11() {
		return col11;
	}
	public void setCol11(double col11) {
		this.col11 = col11;
	}
	public double getTotalcol1() {
		return totalcol1;
	}
	public void setTotalcol1(double totalcol1) {
		this.totalcol1 = totalcol1;
	}
	public double getTotalcol2() {
		return totalcol2;
	}
	public void setTotalcol2(double totalcol2) {
		this.totalcol2 = totalcol2;
	}
	public double getTotalcol3() {
		return totalcol3;
	}
	public void setTotalcol3(double totalcol3) {
		this.totalcol3 = totalcol3;
	}
	public double getTotalcol4() {
		return totalcol4;
	}
	public void setTotalcol4(double totalcol4) {
		this.totalcol4 = totalcol4;
	}
	public double getTotalcol5() {
		return totalcol5;
	}
	public void setTotalcol5(double totalcol5) {
		this.totalcol5 = totalcol5;
	}
	public double getTotalcol6() {
		return totalcol6;
	}
	public void setTotalcol6(double totalcol6) {
		this.totalcol6 = totalcol6;
	}
	public double getTotalcol7() {
		return totalcol7;
	}
	public void setTotalcol7(double totalcol7) {
		this.totalcol7 = totalcol7;
	}
	public double getTotalcol8() {
		return totalcol8;
	}
	public void setTotalcol8(double totalcol8) {
		this.totalcol8 = totalcol8;
	}
	public double getTotalcol9() {
		return totalcol9;
	}
	public void setTotalcol9(double totalcol9) {
		this.totalcol9 = totalcol9;
	}
	public double getTotalcol10() {
		return totalcol10;
	}
	public void setTotalcol10(double totalcol10) {
		this.totalcol10 = totalcol10;
	}
	public double getTotalcol11() {
		return totalcol11;
	}
	public void setTotalcol11(double totalcol11) {
		this.totalcol11 = totalcol11;
	}
	public double getCol1forday() {
		return col1forday;
	}
	public void setCol1forday(double col1forday) {
		this.col1forday = col1forday;
	}
	public double getCol1fornight() {
		return col1fornight;
	}
	public void setCol1fornight(double col1fornight) {
		this.col1fornight = col1fornight;
	}
	public double getCol2forday() {
		return col2forday;
	}
	public void setCol2forday(double col2forday) {
		this.col2forday = col2forday;
	}
	public double getCol2fornight() {
		return col2fornight;
	}
	public void setCol2fornight(double col2fornight) {
		this.col2fornight = col2fornight;
	}
	public double getCol3forday() {
		return col3forday;
	}
	public void setCol3forday(double col3forday) {
		this.col3forday = col3forday;
	}
	public double getCol3fornight() {
		return col3fornight;
	}
	public void setCol3fornight(double col3fornight) {
		this.col3fornight = col3fornight;
	}
	public double getCol4forday() {
		return col4forday;
	}
	public void setCol4forday(double col4forday) {
		this.col4forday = col4forday;
	}
	public double getCol4fornight() {
		return col4fornight;
	}
	public void setCol4fornight(double col4fornight) {
		this.col4fornight = col4fornight;
	}
	public double getCol5forday() {
		return col5forday;
	}
	public void setCol5forday(double col5forday) {
		this.col5forday = col5forday;
	}
	public double getCol5fornight() {
		return col5fornight;
	}
	public void setCol5fornight(double col5fornight) {
		this.col5fornight = col5fornight;
	}
	public double getCol6forday() {
		return col6forday;
	}
	public void setCol6forday(double col6forday) {
		this.col6forday = col6forday;
	}
	public double getCol6fornight() {
		return col6fornight;
	}
	public void setCol6fornight(double col6fornight) {
		this.col6fornight = col6fornight;
	}
	public double getCol7forday() {
		return col7forday;
	}
	public void setCol7forday(double col7forday) {
		this.col7forday = col7forday;
	}
	public double getCol7fornight() {
		return col7fornight;
	}
	public void setCol7fornight(double col7fornight) {
		this.col7fornight = col7fornight;
	}
	public double getCol8forday() {
		return col8forday;
	}
	public void setCol8forday(double col8forday) {
		this.col8forday = col8forday;
	}
	public double getCol8fornight() {
		return col8fornight;
	}
	public void setCol8fornight(double col8fornight) {
		this.col8fornight = col8fornight;
	}
	public double getCol9forday() {
		return col9forday;
	}
	public void setCol9forday(double col9forday) {
		this.col9forday = col9forday;
	}
	public double getCol9fornight() {
		return col9fornight;
	}
	public void setCol9fornight(double col9fornight) {
		this.col9fornight = col9fornight;
	}
	public double getCol10forday() {
		return col10forday;
	}
	public void setCol10forday(double col10forday) {
		this.col10forday = col10forday;
	}
	public double getCol10fornight() {
		return col10fornight;
	}
	public void setCol10fornight(double col10fornight) {
		this.col10fornight = col10fornight;
	}
	public double getCol11forday() {
		return col11forday;
	}
	public void setCol11forday(double col11forday) {
		this.col11forday = col11forday;
	}
	public double getCol11fornight() {
		return col11fornight;
	}
	public void setCol11fornight(double col11fornight) {
		this.col11fornight = col11fornight;
	}

}

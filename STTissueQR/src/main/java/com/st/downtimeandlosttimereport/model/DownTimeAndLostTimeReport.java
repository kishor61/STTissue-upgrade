/**
 *Sep 12, 2017
 *DownTimeAndLostTimeReport.java
 * TODO
 *com.st.downtimeandlosttimereport.model
 *DownTimeAndLostTimeReport.java
 *Roshan Lal Tailor
 */
package com.st.downtimeandlosttimereport.model;

import java.sql.Timestamp;
import java.util.Date;

import com.st.efficiency.model.PrimaryCode;
import com.st.efficiency.model.SecondaryCode;

/**
 * @author roshan
 *
 */
public class DownTimeAndLostTimeReport {

	private int id;
	private String code;
	private String note;
	
	private PrimaryCode primaryCode;

	private Date date;
	private String shift;
	private String crew;
	private Timestamp startTime;
	private Timestamp endTime;
	private String reel;
	private String gradeCode;
	private String comment;
	
	private SecondaryCode secondaryCode;
	
	
	//Field for form
	private String fdate;
	private String fstartTimeHH;
	private String fstartTimeMM;
	private String fendTimeHH="0";
	private String fendTimeMM="0";
	
	
	
	//Field for Report
	private Date startDate;
	private Date endDate;
	private String pcode;
	private String scode;
	
	//Field for temp update
	private String queryString;
	
	private int type;
	
	//For Total Secondary Codes
	private double totalannualoutage;
	private double totalbladechange;
	private double totalboilout;
	private double totalbreakbackedge;
	private double totalbreakfrontedge;
	private double totalbreakmiddle;
	private double totalbreakatreel;
	private double totalbreakatyankee;
	private double totalcleanupwashup;
	private double totalelectrical;
	private double totalfeltwash;
	private double totalfieldday;
	private double totalfireatreel;
	private double totalgradechange;
	private double totalheadboxflushing;
	private double totalheadboxsealfixing;
	private double totalhoodfire;
	private double totalinstrumentation;
	private double totaljetslittertrimsadjustment;
	private double totallackofair;
	private double totallackofsteam;
	private double totallackofstock;
	private double totalmechanical;
	private double totalmissedturnup;
	private double totalnoemptyspool;
	private double totalnowater;
	private double totalpoweroutage;
	private double totalscheduleclothingchange;
	private double totalsmoldering;
	private double totalsprayboomchange;
	private double totalstartup;
	private double totalstriptheYankee;
	private double totalturnup;
	private double totalunscheduledclothingchange;
	
	private double totalhr;
	private double totalmin;
	private double reelton;
	private String comments;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public PrimaryCode getPrimaryCode() {
		return primaryCode;
	}

	public void setPrimaryCode(PrimaryCode primaryCode) {
		this.primaryCode = primaryCode;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getShift() {
		return shift;
	}

	public void setShift(String shift) {
		this.shift = shift;
	}

	public String getCrew() {
		return crew;
	}

	public void setCrew(String crew) {
		this.crew = crew;
	}

	public Timestamp getStartTime() {
		return startTime;
	}

	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}

	public Timestamp getEndTime() {
		return endTime;
	}

	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}

	public String getReel() {
		return reel;
	}

	public void setReel(String reel) {
		this.reel = reel;
	}

	public String getGradeCode() {
		return gradeCode;
	}

	public void setGradeCode(String gradeCode) {
		this.gradeCode = gradeCode;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public SecondaryCode getSecondaryCode() {
		return secondaryCode;
	}

	public void setSecondaryCode(SecondaryCode secondaryCode) {
		this.secondaryCode = secondaryCode;
	}

	public String getFdate() {
		return fdate;
	}

	public void setFdate(String fdate) {
		this.fdate = fdate;
	}

	public String getFstartTimeHH() {
		return fstartTimeHH;
	}

	public void setFstartTimeHH(String fstartTimeHH) {
		this.fstartTimeHH = fstartTimeHH;
	}

	public String getFstartTimeMM() {
		return fstartTimeMM;
	}

	public void setFstartTimeMM(String fstartTimeMM) {
		this.fstartTimeMM = fstartTimeMM;
	}

	public String getFendTimeHH() {
		return fendTimeHH;
	}

	public void setFendTimeHH(String fendTimeHH) {
		this.fendTimeHH = fendTimeHH;
	}

	public String getFendTimeMM() {
		return fendTimeMM;
	}

	public void setFendTimeMM(String fendTimeMM) {
		this.fendTimeMM = fendTimeMM;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getPcode() {
		return pcode;
	}

	public void setPcode(String pcode) {
		this.pcode = pcode;
	}

	public String getScode() {
		return scode;
	}

	public void setScode(String scode) {
		this.scode = scode;
	}

	public String getQueryString() {
		return queryString;
	}

	public void setQueryString(String queryString) {
		this.queryString = queryString;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}


	public void setTotalmin(int totalmin) {
		this.totalmin = totalmin;
	}

	public double getReelton() {
		return reelton;
	}

	public void setReelton(double reelton) {
		this.reelton = reelton;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	

	public void setTotalunscheduledclothingchange(int totalunscheduledclothingchange) {
		this.totalunscheduledclothingchange = totalunscheduledclothingchange;
	}

	public void setTotalbladechange(int totalbladechange) {
		this.totalbladechange = totalbladechange;
	}

	public double getTotalannualoutage() {
		return totalannualoutage;
	}

	public void setTotalannualoutage(double totalannualoutage) {
		this.totalannualoutage = totalannualoutage;
	}

	public double getTotalbladechange() {
		return totalbladechange;
	}

	public void setTotalbladechange(double totalbladechange) {
		this.totalbladechange = totalbladechange;
	}

	public double getTotalboilout() {
		return totalboilout;
	}

	public void setTotalboilout(double totalboilout) {
		this.totalboilout = totalboilout;
	}

	public double getTotalbreakbackedge() {
		return totalbreakbackedge;
	}

	public void setTotalbreakbackedge(double totalbreakbackedge) {
		this.totalbreakbackedge = totalbreakbackedge;
	}

	public double getTotalbreakfrontedge() {
		return totalbreakfrontedge;
	}

	public void setTotalbreakfrontedge(double totalbreakfrontedge) {
		this.totalbreakfrontedge = totalbreakfrontedge;
	}

	public double getTotalbreakmiddle() {
		return totalbreakmiddle;
	}

	public void setTotalbreakmiddle(double totalbreakmiddle) {
		this.totalbreakmiddle = totalbreakmiddle;
	}

	public double getTotalbreakatreel() {
		return totalbreakatreel;
	}

	public void setTotalbreakatreel(double totalbreakatreel) {
		this.totalbreakatreel = totalbreakatreel;
	}

	public double getTotalbreakatyankee() {
		return totalbreakatyankee;
	}

	public void setTotalbreakatyankee(double totalbreakatyankee) {
		this.totalbreakatyankee = totalbreakatyankee;
	}

	public double getTotalcleanupwashup() {
		return totalcleanupwashup;
	}

	public void setTotalcleanupwashup(double totalcleanupwashup) {
		this.totalcleanupwashup = totalcleanupwashup;
	}

	public double getTotalelectrical() {
		return totalelectrical;
	}

	public void setTotalelectrical(double totalelectrical) {
		this.totalelectrical = totalelectrical;
	}

	public double getTotalfeltwash() {
		return totalfeltwash;
	}

	public void setTotalfeltwash(double totalfeltwash) {
		this.totalfeltwash = totalfeltwash;
	}

	public double getTotalfieldday() {
		return totalfieldday;
	}

	public void setTotalfieldday(double totalfieldday) {
		this.totalfieldday = totalfieldday;
	}

	public double getTotalfireatreel() {
		return totalfireatreel;
	}

	public void setTotalfireatreel(double totalfireatreel) {
		this.totalfireatreel = totalfireatreel;
	}

	public double getTotalgradechange() {
		return totalgradechange;
	}

	public void setTotalgradechange(double totalgradechange) {
		this.totalgradechange = totalgradechange;
	}

	public double getTotalheadboxflushing() {
		return totalheadboxflushing;
	}

	public void setTotalheadboxflushing(double totalheadboxflushing) {
		this.totalheadboxflushing = totalheadboxflushing;
	}

	public double getTotalheadboxsealfixing() {
		return totalheadboxsealfixing;
	}

	public void setTotalheadboxsealfixing(double totalheadboxsealfixing) {
		this.totalheadboxsealfixing = totalheadboxsealfixing;
	}

	public double getTotalhoodfire() {
		return totalhoodfire;
	}

	public void setTotalhoodfire(double totalhoodfire) {
		this.totalhoodfire = totalhoodfire;
	}

	public double getTotalinstrumentation() {
		return totalinstrumentation;
	}

	public void setTotalinstrumentation(double totalinstrumentation) {
		this.totalinstrumentation = totalinstrumentation;
	}

	public double getTotaljetslittertrimsadjustment() {
		return totaljetslittertrimsadjustment;
	}

	public void setTotaljetslittertrimsadjustment(
			double totaljetslittertrimsadjustment) {
		this.totaljetslittertrimsadjustment = totaljetslittertrimsadjustment;
	}

	public double getTotallackofair() {
		return totallackofair;
	}

	public void setTotallackofair(double totallackofair) {
		this.totallackofair = totallackofair;
	}

	public double getTotallackofsteam() {
		return totallackofsteam;
	}

	public void setTotallackofsteam(double totallackofsteam) {
		this.totallackofsteam = totallackofsteam;
	}

	public double getTotallackofstock() {
		return totallackofstock;
	}

	public void setTotallackofstock(double totallackofstock) {
		this.totallackofstock = totallackofstock;
	}

	public double getTotalmechanical() {
		return totalmechanical;
	}

	public void setTotalmechanical(double totalmechanical) {
		this.totalmechanical = totalmechanical;
	}

	public double getTotalmissedturnup() {
		return totalmissedturnup;
	}

	public void setTotalmissedturnup(double totalmissedturnup) {
		this.totalmissedturnup = totalmissedturnup;
	}

	public double getTotalnoemptyspool() {
		return totalnoemptyspool;
	}

	public void setTotalnoemptyspool(double totalnoemptyspool) {
		this.totalnoemptyspool = totalnoemptyspool;
	}

	public double getTotalnowater() {
		return totalnowater;
	}

	public void setTotalnowater(double totalnowater) {
		this.totalnowater = totalnowater;
	}

	public double getTotalpoweroutage() {
		return totalpoweroutage;
	}

	public void setTotalpoweroutage(double totalpoweroutage) {
		this.totalpoweroutage = totalpoweroutage;
	}

	public double getTotalscheduleclothingchange() {
		return totalscheduleclothingchange;
	}

	public void setTotalscheduleclothingchange(double totalscheduleclothingchange) {
		this.totalscheduleclothingchange = totalscheduleclothingchange;
	}

	public double getTotalsmoldering() {
		return totalsmoldering;
	}

	public void setTotalsmoldering(double totalsmoldering) {
		this.totalsmoldering = totalsmoldering;
	}

	public double getTotalsprayboomchange() {
		return totalsprayboomchange;
	}

	public void setTotalsprayboomchange(double totalsprayboomchange) {
		this.totalsprayboomchange = totalsprayboomchange;
	}

	public double getTotalstartup() {
		return totalstartup;
	}

	public void setTotalstartup(double totalstartup) {
		this.totalstartup = totalstartup;
	}

	public double getTotalstriptheYankee() {
		return totalstriptheYankee;
	}

	public void setTotalstriptheYankee(double totalstriptheYankee) {
		this.totalstriptheYankee = totalstriptheYankee;
	}

	public double getTotalturnup() {
		return totalturnup;
	}

	public void setTotalturnup(double totalturnup) {
		this.totalturnup = totalturnup;
	}

	public double getTotalunscheduledclothingchange() {
		return totalunscheduledclothingchange;
	}

	public void setTotalunscheduledclothingchange(
			double totalunscheduledclothingchange) {
		this.totalunscheduledclothingchange = totalunscheduledclothingchange;
	}

	public double getTotalhr() {
		return totalhr;
	}

	public void setTotalhr(double totalhr) {
		this.totalhr = totalhr;
	}

	public double getTotalmin() {
		return totalmin;
	}

	public void setTotalmin(double totalmin) {
		this.totalmin = totalmin;
	}
}

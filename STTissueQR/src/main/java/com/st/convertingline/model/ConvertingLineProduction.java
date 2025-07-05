/**
 *May 13, 2017
 *ConvertingLineProduction.java
 * TODO
 *com.st.convertingline.model
 *ConvertingLineProduction.java
 *Roshan Lal Tailor
 */
package com.st.convertingline.model;

import java.sql.Timestamp;
import java.util.Date;

/**
 * @author roshan
 *
 */
public class ConvertingLineProduction {

	
	private String parentrollid;
	private Date date;
	private String shift;
	private String parentgradecode;
	private String skucode;
	
	private double parentweight;
	private double parentdiameter;
	private double parentrollwidth;
	private double parentcore;
	private double firstcase;
	private double secodcase;
	private double palletcount;
	private double firstcasetotal;
	private double secondcasetotal;
	private String firstcaseandskutotal;
	private String secondcaseandskutotal;
	private double totalcases;
	private double firstCaseeffi;
	private double secondCaseeffi;
	
	private double tsnscases;
	private double actualefficency;
	private Timestamp startTime;
	private Timestamp endTime;
	private double hourworked;
	private double earnedhours;
	private int uptime;
	private double totalEfficiency;
	private String day;
	private int flagcount;
	private String dontshow;
	
	//
	private double grandtotalhourworked;
	private double grandtotalUptime;
	private double grandtotalfistcases;
	private double grandtotalsecondcases;
	private double grandtotalcases;
	private String mapsize;
	private String rowview;
	
	private int speed;
	
	
	
	private double staffedtime;
	private double operatingminute;
	private double downtimeminute;
	private double rewinderspeed;
	private double casesproduced1stgrade;
	private double casesproduced2ndgrade;
	private double totalcasesproduced;
	
	private String month;
	private String year;
	private double downtime;
	
	
	public String getParentrollid() {
		return parentrollid;
	}
	public void setParentrollid(String parentrollid) {
		this.parentrollid = parentrollid;
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
	public String getParentgradecode() {
		return parentgradecode;
	}
	public void setParentgradecode(String parentgradecode) {
		this.parentgradecode = parentgradecode;
	}
	public String getSkucode() {
		return skucode;
	}
	public void setSkucode(String skucode) {
		this.skucode = skucode;
	}
	public double getParentweight() {
		return parentweight;
	}
	public void setParentweight(double parentweight) {
		this.parentweight = parentweight;
	}
	public double getParentdiameter() {
		return parentdiameter;
	}
	public void setParentdiameter(double parentdiameter) {
		this.parentdiameter = parentdiameter;
	}
	public double getParentrollwidth() {
		return parentrollwidth;
	}
	public void setParentrollwidth(double parentrollwidth) {
		this.parentrollwidth = parentrollwidth;
	}
	public double getParentcore() {
		return parentcore;
	}
	public void setParentcore(double parentcore) {
		this.parentcore = parentcore;
	}
	public double getFirstcase() {
		return firstcase;
	}
	public void setFirstcase(double firstcase) {
		this.firstcase = firstcase;
	}
	public double getSecodcase() {
		return secodcase;
	}
	public void setSecodcase(double secodcase) {
		this.secodcase = secodcase;
	}
	public double getPalletcount() {
		return palletcount;
	}
	public void setPalletcount(double palletcount) {
		this.palletcount = palletcount;
	}
	public double getFirstcasetotal() {
		return firstcasetotal;
	}
	public void setFirstcasetotal(double firstcasetotal) {
		this.firstcasetotal = firstcasetotal;
	}
	public double getSecondcasetotal() {
		return secondcasetotal;
	}
	public void setSecondcasetotal(double secondcasetotal) {
		this.secondcasetotal = secondcasetotal;
	}
	public double getTotalcases() {
		return totalcases;
	}
	public void setTotalcases(double totalcases) {
		this.totalcases = totalcases;
	}
	public double getFirstCaseeffi() {
		return firstCaseeffi;
	}
	public void setFirstCaseeffi(double firstCaseeffi) {
		this.firstCaseeffi = firstCaseeffi;
	}
	public double getSecondCaseeffi() {
		return secondCaseeffi;
	}
	public void setSecondCaseeffi(double secondCaseeffi) {
		this.secondCaseeffi = secondCaseeffi;
	}
	public double getTsnscases() {
		return tsnscases;
	}
	public void setTsnscases(double tsnscases) {
		this.tsnscases = tsnscases;
	}
	public double getActualefficency() {
		return actualefficency;
	}
	public void setActualefficency(double actualefficency) {
		this.actualefficency = actualefficency;
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
	public double getHourworked() {
		return hourworked;
	}
	public void setHourworked(double hourworked) {
		this.hourworked = hourworked;
	}
	public String getFirstcaseandskutotal() {
		return firstcaseandskutotal;
	}
	public void setFirstcaseandskutotal(String firstcaseandskutotal) {
		this.firstcaseandskutotal = firstcaseandskutotal;
	}
	public String getSecondcaseandskutotal() {
		return secondcaseandskutotal;
	}
	public void setSecondcaseandskutotal(String secondcaseandskutotal) {
		this.secondcaseandskutotal = secondcaseandskutotal;
	}
	public double getEarnedhours() {
		return earnedhours;
	}
	public void setEarnedhours(double earnedhours) {
		this.earnedhours = earnedhours;
	}
	public int getUptime() {
		return uptime;
	}
	public void setUptime(int uptime) {
		this.uptime = uptime;
	}
	public double getTotalEfficiency() {
		return totalEfficiency;
	}
	public void setTotalEfficiency(double totalEfficiency) {
		this.totalEfficiency = totalEfficiency;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public int getFlagcount() {
		return flagcount;
	}
	public void setFlagcount(int flagcount) {
		this.flagcount = flagcount;
	}
	public String getDontshow() {
		return dontshow;
	}
	public void setDontshow(String dontshow) {
		this.dontshow = dontshow;
	}
	public double getGrandtotalhourworked() {
		return grandtotalhourworked;
	}
	public void setGrandtotalhourworked(double grandtotalhourworked) {
		this.grandtotalhourworked = grandtotalhourworked;
	}
	public double getGrandtotalUptime() {
		return grandtotalUptime;
	}
	public void setGrandtotalUptime(double grandtotalUptime) {
		this.grandtotalUptime = grandtotalUptime;
	}
	public double getGrandtotalfistcases() {
		return grandtotalfistcases;
	}
	public void setGrandtotalfistcases(double grandtotalfistcases) {
		this.grandtotalfistcases = grandtotalfistcases;
	}
	public double getGrandtotalsecondcases() {
		return grandtotalsecondcases;
	}
	public void setGrandtotalsecondcases(double grandtotalsecondcases) {
		this.grandtotalsecondcases = grandtotalsecondcases;
	}
	public double getGrandtotalcases() {
		return grandtotalcases;
	}
	public void setGrandtotalcases(double grandtotalcases) {
		this.grandtotalcases = grandtotalcases;
	}
	public String getMapsize() {
		return mapsize;
	}
	public void setMapsize(String mapsize) {
		this.mapsize = mapsize;
	}
	public String getRowview() {
		return rowview;
	}
	public void setRowview(String rowview) {
		this.rowview = rowview;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public double getStaffedtime() {
		return staffedtime;
	}
	public void setStaffedtime(double staffedtime) {
		this.staffedtime = staffedtime;
	}
	public double getOperatingminute() {
		return operatingminute;
	}
	public void setOperatingminute(double operatingminute) {
		this.operatingminute = operatingminute;
	}
	public double getDowntimeminute() {
		return downtimeminute;
	}
	public void setDowntimeminute(double downtimeminute) {
		this.downtimeminute = downtimeminute;
	}
	public double getRewinderspeed() {
		return rewinderspeed;
	}
	public void setRewinderspeed(double rewinderspeed) {
		this.rewinderspeed = rewinderspeed;
	}
	public double getCasesproduced1stgrade() {
		return casesproduced1stgrade;
	}
	public void setCasesproduced1stgrade(double casesproduced1stgrade) {
		this.casesproduced1stgrade = casesproduced1stgrade;
	}
	public double getCasesproduced2ndgrade() {
		return casesproduced2ndgrade;
	}
	public void setCasesproduced2ndgrade(double casesproduced2ndgrade) {
		this.casesproduced2ndgrade = casesproduced2ndgrade;
	}
	public double getTotalcasesproduced() {
		return totalcasesproduced;
	}
	public void setTotalcasesproduced(double totalcasesproduced) {
		this.totalcasesproduced = totalcasesproduced;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public double getDowntime() {
		return downtime;
	}
	public void setDowntime(double downtime) {
		this.downtime = downtime;
	}
 
	
}

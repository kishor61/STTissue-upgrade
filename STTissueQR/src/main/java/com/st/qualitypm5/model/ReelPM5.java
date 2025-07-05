/**
 *Dec 22, 2017
 *ReelPM5.java
 * TODO
 *com.st.qualitypm5.model
 *ReelPM5.java
 *Roshan Lal Tailor
 */
package com.st.qualitypm5.model;

import java.util.Date;

/**
 * @author roshan
 *
 */
public class ReelPM5 {

	private int id;
	private Date date;
	private Date time;
	private String gradeCode;
	private String reel;
	private double scannerBasisWt;
	private double actualBasisWt;
	private double bulk;
	private double finchCup;
	private double mdTensile;
	private double cdTensile;
	private double mdStretch;
	private double mdcdTensileRatio;
	private double mdWetTensile;
	private double cdWetTensile;
	private double wetDryRatio;
	private double brightness;
	private double fwaFlow;
	private double dirtCount;
	private double fwaDosage;
	private double tph;
	private double trim;
	private double crepeRatio;
	private double frontRollDiameter;
	private double backRollDiameter;
	
	private double lvalue;
	private double avalue;
	private double bvalue;
	private double deltae;

	private String customer;
	private String customer1;
	private String customer2;
	
	private String remarks;
	
	private double gmtbw;

	private double  akd;
	private double wetstrength;
	private double drystrengthflow;
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
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public String getGradeCode() {
		return gradeCode;
	}
	public void setGradeCode(String gradeCode) {
		this.gradeCode = gradeCode;
	}
	public String getReel() {
		return reel;
	}
	public void setReel(String reel) {
		this.reel = reel;
	}
	public double getScannerBasisWt() {
		return scannerBasisWt;
	}
	public void setScannerBasisWt(double scannerBasisWt) {
		this.scannerBasisWt = scannerBasisWt;
	}
	public double getActualBasisWt() {
		return actualBasisWt;
	}
	public void setActualBasisWt(double actualBasisWt) {
		this.actualBasisWt = actualBasisWt;
	}
	public double getFinchCup() {
		return finchCup;
	}
	public void setFinchCup(double finchCup) {
		this.finchCup = finchCup;
	}
	public double getBulk() {
		return bulk;
	}
	public void setBulk(double bulk) {
		this.bulk = bulk;
	}
	public double getMdTensile() {
		return mdTensile;
	}
	public void setMdTensile(double mdTensile) {
		this.mdTensile = mdTensile;
	}
	public double getCdTensile() {
		return cdTensile;
	}
	public void setCdTensile(double cdTensile) {
		this.cdTensile = cdTensile;
	}
	public double getMdStretch() {
		return mdStretch;
	}
	public void setMdStretch(double mdStretch) {
		this.mdStretch = mdStretch;
	}
	public double getMdcdTensileRatio() {
		return mdcdTensileRatio;
	}
	public void setMdcdTensileRatio(double mdcdTensileRatio) {
		this.mdcdTensileRatio = mdcdTensileRatio;
	}
	public double getMdWetTensile() {
		return mdWetTensile;
	}
	public void setMdWetTensile(double mdWetTensile) {
		this.mdWetTensile = mdWetTensile;
	}
	public double getCdWetTensile() {
		return cdWetTensile;
	}
	public void setCdWetTensile(double cdWetTensile) {
		this.cdWetTensile = cdWetTensile;
	}
	public double getWetDryRatio() {
		return wetDryRatio;
	}
	public void setWetDryRatio(double wetDryRatio) {
		this.wetDryRatio = wetDryRatio;
	}
	public double getBrightness() {
		return brightness;
	}
	public void setBrightness(double brightness) {
		this.brightness = brightness;
	}
	public double getFwaFlow() {
		return fwaFlow;
	}
	public void setFwaFlow(double fwaFlow) {
		this.fwaFlow = fwaFlow;
	}
	public double getDirtCount() {
		return dirtCount;
	}
	public void setDirtCount(double dirtCount) {
		this.dirtCount = dirtCount;
	}
	public double getFwaDosage() {
		return fwaDosage;
	}
	public void setFwaDosage(double fwaDosage) {
		this.fwaDosage = fwaDosage;
	}
	public double getTph() {
		return tph;
	}
	public void setTph(double tph) {
		this.tph = tph;
	}
	public double getTrim() {
		return trim;
	}
	public void setTrim(double trim) {
		this.trim = trim;
	}
	public double getCrepeRatio() {
		return crepeRatio;
	}
	public void setCrepeRatio(double crepeRatio) {
		this.crepeRatio = crepeRatio;
	}
	public double getLvalue() {
		return lvalue;
	}
	public void setLvalue(double lvalue) {
		this.lvalue = lvalue;
	}
	public double getAvalue() {
		return avalue;
	}
	public void setAvalue(double avalue) {
		this.avalue = avalue;
	}
	public double getBvalue() {
		return bvalue;
	}
	public void setBvalue(double bvalue) {
		this.bvalue = bvalue;
	}
	public double getDeltae() {
		return deltae;
	}
	public void setDeltae(double deltae) {
		this.deltae = deltae;
	}
	public String getCustomer() {
		return customer;
	}
	public void setCustomer(String customer) {
		this.customer = customer;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public double getGmtbw() {
		return gmtbw;
	}
	public void setGmtbw(double gmtbw) {
		this.gmtbw = gmtbw;
	}
	public double getAkd() {
		return akd;
	}
	public void setAkd(double akd) {
		this.akd = akd;
	}
	public double getWetstrength() {
		return wetstrength;
	}
	public void setWetstrength(double wetstrength) {
		this.wetstrength = wetstrength;
	}
	public double getDrystrengthflow() {
		return drystrengthflow;
	}
	public void setDrystrengthflow(double drystrengthflow) {
		this.drystrengthflow = drystrengthflow;
	}
	/**
	 * @return the customer1
	 */
	public String getCustomer1() {
		return customer1;
	}
	/**
	 * @param customer1 the customer1 to set
	 */
	public void setCustomer1(String customer1) {
		this.customer1 = customer1;
	}
	/**
	 * @return the customer2
	 */
	public String getCustomer2() {
		return customer2;
	}
	/**
	 * @param customer2 the customer2 to set
	 */
	public void setCustomer2(String customer2) {
		this.customer2 = customer2;
	}
	/**
	 * @return the frontRollDiameter
	 */
	public double getFrontRollDiameter() {
		return frontRollDiameter;
	}
	/**
	 * @param frontRollDiameter the frontRollDiameter to set
	 */
	public void setFrontRollDiameter(double frontRollDiameter) {
		this.frontRollDiameter = frontRollDiameter;
	}
	/**
	 * @return the backRollDiameter
	 */
	public double getBackRollDiameter() {
		return backRollDiameter;
	}
	/**
	 * @param backRollDiameter the backRollDiameter to set
	 */
	public void setBackRollDiameter(double backRollDiameter) {
		this.backRollDiameter = backRollDiameter;
	}
	
	
}

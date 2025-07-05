package com.st.qualitypm6.model;

import java.util.Date;
import java.util.List;

import com.st.certificate.model.Rewdinder;

public class Reel {
	private int id;
	private Date date;
	private Date time;
	private String gradeCode;
	private String reel;
	private String rollid;
	private double scannerBasisWt;
	private double actualBasisWt;
	private double bulk;
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

//	Code Starts From Here Done By Roshan Tailor Date:- 03/05/0215 MM/DD/YYYY
	private double lvalue;
	private double avalue;
	private double bvalue;
	private double deltae;
//	Code Ends Here Done By Roshan Tailor
	private String customer;
//	Code Ends Here Done By kishor vaishnav
	private String customer1;
	private String customer2;
	private String remarks;

	private double gmtbw;

	private double akd;
	private double wetstrength;
	private double drystrengthflow;
	private List<Rewdinder> rewdinders;

	public int getId() {
		return id;
	}

	public Date getDate() {
		return date;
	}

	public Date getTime() {
		return time;
	}

	public String getGradeCode() {
		return gradeCode;
	}

	public String getReel() {
		return reel;
	}

	public double getScannerBasisWt() {
		return scannerBasisWt;
	}

	public double getActualBasisWt() {
		return actualBasisWt;
	}

	public double getBulk() {
		return bulk;
	}

	public double getMdTensile() {
		return mdTensile;
	}

	public double getCdTensile() {
		return cdTensile;
	}

	public double getMdStretch() {
		return mdStretch;
	}

	public double getMdcdTensileRatio() {
		return mdcdTensileRatio;
	}

	public double getMdWetTensile() {
		return mdWetTensile;
	}

	public double getCdWetTensile() {
		return cdWetTensile;
	}

	public double getBrightness() {
		return brightness;
	}

	public double getFwaFlow() {
		return fwaFlow;
	}

	public double getDirtCount() {
		return dirtCount;
	}

	public double getFwaDosage() {
		return fwaDosage;
	}

	public double getTph() {
		return tph;
	}

	public double getTrim() {
		return trim;
	}

	public double getCrepeRatio() {
		return crepeRatio;
	}

//	Code Starts From Here Done By Roshan Tailor Date:- 05/03/2015  MM/DD/YYYY 
	// Below Code Is For Getter Method
	public double getLvalue() {
		return lvalue;
	}

	public double getAvalue() {
		return avalue;
	}

	public double getBvalue() {
		return bvalue;
	}
//	Code Ends Here Done By Roshan Tailor

	public String getCustomer() {
		return customer;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public void setGradeCode(String gradeCode) {
		this.gradeCode = gradeCode;
	}

	public void setReel(String reel) {
		this.reel = reel;
	}

	public void setScannerBasisWt(double scannerBasisWt) {
		this.scannerBasisWt = scannerBasisWt;
	}

	public void setActualBasisWt(double actualBasisWt) {
		this.actualBasisWt = actualBasisWt;
	}

	public void setBulk(double bulk) {
		this.bulk = bulk;
	}

	public void setMdTensile(double mdTensile) {
		this.mdTensile = mdTensile;
	}

	public void setCdTensile(double cdTensile) {
		this.cdTensile = cdTensile;
	}

	public void setMdStretch(double mdStretch) {
		this.mdStretch = mdStretch;
	}

	public void setMdcdTensileRatio(double mdcdTensileRatio) {
		this.mdcdTensileRatio = mdcdTensileRatio;
	}

	public void setMdWetTensile(double mdWetTensile) {
		this.mdWetTensile = mdWetTensile;
	}

	public void setCdWetTensile(double cdWetTensile) {
		this.cdWetTensile = cdWetTensile;
	}

	public void setBrightness(double brightness) {
		this.brightness = brightness;
	}

	public void setFwaFlow(double fwaFlow) {
		this.fwaFlow = fwaFlow;
	}

	public void setDirtCount(double dirtCount) {
		this.dirtCount = dirtCount;
	}

	public void setFwaDosage(double fwaDosage) {
		this.fwaDosage = fwaDosage;
	}

	public void setTph(double tph) {
		this.tph = tph;
	}

	public void setTrim(double trim) {
		this.trim = trim;
	}

	public void setCrepeRatio(double crepeRatio) {
		this.crepeRatio = crepeRatio;
	}

//	Code Starts From Here Done By Roshan Tailor Date :- 30/05/2015 MM/DD/YYYY
//	These Are Setter Method.
	public void setLvalue(double lvalue) {
		this.lvalue = lvalue;
	}

	public void setAvalue(double avalue) {
		this.avalue = avalue;
	}

	public void setBvalue(double bvalue) {
		this.bvalue = bvalue;
	}
//	Code Ends Here Done By Roshan Tailor 

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public double getWetDryRatio() {
		return wetDryRatio;
	}

	public void setWetDryRatio(double wetDryRatio) {
		this.wetDryRatio = wetDryRatio;
	}

	public double getGmtbw() {
		return gmtbw;
	}

	public void setGmtbw(double gmtbw) {
		this.gmtbw = gmtbw;
	}

	public double getDeltae() {
		return deltae;
	}

	public void setDeltae(double deltae) {
		this.deltae = deltae;
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
	 * @return the rollid
	 */
	public String getRollid() {
		return rollid;
	}

	/**
	 * @param rollid the rollid to set
	 */
	public void setRollid(String rollid) {
		this.rollid = rollid;
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

	public List<Rewdinder> getRewdinders() {
		return rewdinders;
	}

	public void setRewdinders(List<Rewdinder> rewdinders) {
		this.rewdinders = rewdinders;
	}

	@Override
	public String toString() {
		return "Reel [id=" + id + ", date=" + date + ", time=" + time + ", gradeCode=" + gradeCode + ", reel=" + reel
				+ ", rollid=" + rollid + ", scannerBasisWt=" + scannerBasisWt + ", actualBasisWt=" + actualBasisWt
				+ ", bulk=" + bulk + ", mdTensile=" + mdTensile + ", cdTensile=" + cdTensile + ", mdStretch="
				+ mdStretch + ", mdcdTensileRatio=" + mdcdTensileRatio + ", mdWetTensile=" + mdWetTensile
				+ ", cdWetTensile=" + cdWetTensile + ", wetDryRatio=" + wetDryRatio + ", brightness=" + brightness
				+ ", fwaFlow=" + fwaFlow + ", dirtCount=" + dirtCount + ", fwaDosage=" + fwaDosage + ", tph=" + tph
				+ ", trim=" + trim + ", crepeRatio=" + crepeRatio + ", lvalue=" + lvalue + ", avalue=" + avalue
				+ ", bvalue=" + bvalue + ", deltae=" + deltae + ", customer=" + customer + ", customer1=" + customer1
				+ ", customer2=" + customer2 + ", remarks=" + remarks + ", gmtbw=" + gmtbw + ", akd=" + akd
				+ ", wetstrength=" + wetstrength + ", drystrengthflow=" + drystrengthflow + ", rewdinders=" + rewdinders
				+ "]";
	}
	
	

}

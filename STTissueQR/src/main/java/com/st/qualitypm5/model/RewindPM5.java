/**
 *Dec 25, 2017
 *RewindPM5.java
 * TODO
 *com.st.qualitypm5.model
 *RewindPM5.java
 *Roshan Lal Tailor
 */
package com.st.qualitypm5.model;

import java.util.Date;

/**
 * @author roshan
 *
 */
public class RewindPM5 {
	private int id;
	private Date date;
	private String gradeCode;
	private String reel;
	private String setNo;
	private double actualBasisWt;
	private double bulk;
	private double mdTensile;
	private double cdTensile;
	private double mdStretch;
	private double mdcdTensileRatio;
	private double mdWetTensile;
	private double cdWetTensile;
	private double cdTensileRatio;
	private double brightness;
	private double dirtCount;
	private double absorbencySeconds;
	private double lvalue;
	private double avalue;
	private double bvalue;
	private String customer;
	private String remarks;


	
	//Temporary Time field
	private Date time;
	
	public int getId() {
		return id;
	}

	public Date getDate() {
		return date;
	}

	public String getGradeCode() {
		return gradeCode;
	}

	public String getReel() {
		return reel;
	}

	public String getSetNo() {
		return setNo;
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

	public double getCdTensileRatio() {
		return cdTensileRatio;
	}

	public double getBrightness() {
		return brightness;
	}

	public double getDirtCount() {
		return dirtCount;
	}

	public double getAbsorbencySeconds() {
		return absorbencySeconds;
	}
//	Code Starts From Here Done By Roshan Tailor For Getter Method Date :- 03/07/2015 MM/DD/YYYY
	public double getLvalue() {
		return lvalue;
	}
	public double  getAvalue() {
		return avalue;
	}
	public double  getBvalue() {
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

	public void setGradeCode(String gradeCode) {
		this.gradeCode = gradeCode;
	}

	public void setReel(String reel) {
		this.reel = reel;
	}

	public void setSetNo(String setNo) {
		this.setNo = setNo;
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

	public void setCdTensileRatio(double cdTensileRatio) {
		this.cdTensileRatio = cdTensileRatio;
	}

	public void setBrightness(double brightness) {
		this.brightness = brightness;
	}

	public void setDirtCount(double dirtCount) {
		this.dirtCount = dirtCount;
	}

	public void setAbsorbencySeconds(double absorbencySeconds) {
		this.absorbencySeconds = absorbencySeconds;
	}

//	Code Done By Roshan Tailor For Setter Method Date :- 03/07/2015 MM/DD/YYYY
	public void  setLvalue(double lvalue) {
		this.lvalue=lvalue;
	}
	public void setAvalue(double avalue) {
		this.avalue=avalue;
	}
	
	public void setBvalue(double bvalue) {
		this.bvalue=bvalue;
	}
//	Code Ends Here Done By Roshan Tailor For Setter Method
	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}



	/**
	 * @return the time
	 */
	public Date getTime() {
		return time;
	}

	/**
	 * @param time the time to set
	 */
	public void setTime(Date time) {
		this.time = time;
	}

}

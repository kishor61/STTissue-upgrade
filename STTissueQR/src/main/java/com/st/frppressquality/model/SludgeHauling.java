/**
 *Jan 17, 2015
 *SludgeHauling.java
 * TODO
 *com.st.frppressquality.model
 *SludgeHauling.java
 *Sunil Singh Bora
 */
package com.st.frppressquality.model;

import java.util.Date;

/**
 * @author roshan
 *
 */
public class SludgeHauling {
	private int id;
	private Date date=new Date();
	private String grade;
	private double sludgeHauled;
	private double sludgeConsistency;
	private double rejectsBwHauled;
	private double rejectsBwConsistency;
	private String frpSludgePressRunning;
	private String frpScrewPressRunning;
	private double coddischarge;
	
//	Code Starts From Here Done By Roshan Tailor
	private double effluentConsistency;
//	Code Ends Here Done By Roshan Tailor

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

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getFrpSludgePressRunning() {
		return frpSludgePressRunning;
	}

	public double getSludgeHauled() {
		return sludgeHauled;
	}

	public void setSludgeHauled(double sludgeHauled) {
		this.sludgeHauled = sludgeHauled;
	}

	public double getSludgeConsistency() {
		return sludgeConsistency;
	}

	public void setSludgeConsistency(double sludgeConsistency) {
		this.sludgeConsistency = sludgeConsistency;
	}


	public double getRejectsBwHauled() {
		return rejectsBwHauled;
	}

	public void setRejectsBwHauled(double rejectsBwHauled) {
		this.rejectsBwHauled = rejectsBwHauled;
	}

	public double getRejectsBwConsistency() {
		return rejectsBwConsistency;
	}

	public void setRejectsBwConsistency(double rejectsBwConsistency) {
		this.rejectsBwConsistency = rejectsBwConsistency;
	}

	public void setFrpSludgePressRunning(String frpSludgePressRunning) {
		this.frpSludgePressRunning = frpSludgePressRunning;
	}

	public String getFrpScrewPressRunning() {
		return frpScrewPressRunning;
	}

	public void setFrpScrewPressRunning(String frpScrewPressRunning) {
		this.frpScrewPressRunning = frpScrewPressRunning;
	}

	public double getEffluentConsistency() {
		return effluentConsistency;
	}

	public void setEffluentConsistency(double effluentConsistency) {
		this.effluentConsistency = effluentConsistency;
	}

	public double getCoddischarge() {
		return coddischarge;
	}

	public void setCoddischarge(double coddischarge) {
		this.coddischarge = coddischarge;
	}

}

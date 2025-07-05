/**
 *Jan 12, 2018
 *Despatch.java
 * TODO
 *com.st.despatch.model
 *Despatch.java
 *Roshan Lal Tailor
 */
package com.st.despatch.model;

import java.util.Date;

/**
 * @author roshan
 *
 */
public class Despatch {

	private Date pickupdate;
	private String pickuppoint;
	private String pickupcity;
	private String pickupstate;
	private int releasenumber;
	private String careeririd;
	private String unloadcomments;
	private String grade;
	private String loadstatus;
	private String cellnumber;
	private int carrierRate;
	
	public Date getPickupdate() {
		return pickupdate;
	}
	public void setPickupdate(Date pickupdate) {
		this.pickupdate = pickupdate;
	}
	public String getPickuppoint() {
		return pickuppoint;
	}
	public void setPickuppoint(String pickuppoint) {
		this.pickuppoint = pickuppoint;
	}
	public String getPickupcity() {
		return pickupcity;
	}
	public void setPickupcity(String pickupcity) {
		this.pickupcity = pickupcity;
	}
	public String getPickupstate() {
		return pickupstate;
	}
	public void setPickupstate(String pickupstate) {
		this.pickupstate = pickupstate;
	}
	public int getReleasenumber() {
		return releasenumber;
	}
	public void setReleasenumber(int releasenumber) {
		this.releasenumber = releasenumber;
	}
	public String getCareeririd() {
		return careeririd;
	}
	public void setCareeririd(String careeririd) {
		this.careeririd = careeririd;
	}
	public String getUnloadcomments() {
		return unloadcomments;
	}
	public void setUnloadcomments(String unloadcomments) {
		this.unloadcomments = unloadcomments;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getLoadstatus() {
		return loadstatus;
	}
	public void setLoadstatus(String loadstatus) {
		this.loadstatus = loadstatus;
	}
	public String getCellnumber() {
		return cellnumber;
	}
	public void setCellnumber(String cellnumber) {
		this.cellnumber = cellnumber;
	}
	/**
	 * @return the carrierRate
	 */
	public int getCarrierRate() {
		return carrierRate;
	}
	/**
	 * @param carrierRate the carrierRate to set
	 */
	public void setCarrierRate(int carrierRate) {
		this.carrierRate = carrierRate;
	}
	 
}

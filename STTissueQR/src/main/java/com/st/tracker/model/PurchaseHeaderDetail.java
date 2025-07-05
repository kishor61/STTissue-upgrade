/**
 * 
 */
package com.st.tracker.model;

import java.util.Date;

/**
 * @author sbora
 * 
 */
public class PurchaseHeaderDetail {
	// Header Field
	private int releaseNumber;
	private Date entryDate;
	private String pickUpPoint;
	private String pickUpCity;
	private String carrierID;
	private Date pickUpDate;
	private Date deliveryDate;
	private Date acceptDate;
	private String unloaderID;
	private Date unloadDate;
	private Date unloadTime;
	private double grossWeight;
	private double tareWeight;
	private double netWeight;
	private String unloadComment;
	private String loadStatus;
	private String trailer;
	private String vendor;
	private String vendorNumber;
	private String palletCount;
	private String pickUpState;
	private Date weightDate;
	private double bolWeightTotal;
	private String ticketNumber;
	private double moisture;
	private double dryTonCalc;
	private String masterPO;
	private double bolGoodTotal;
	private Date pickUpTime;

	// Detail Fields
	private String entryNumber;
	private String gradeCode;
	private String grade;
	private String baleCount;
	private String baleQuality;
	private String bolWeight;
	private String location;

	//Temp Field
	private int count;
	
	public int getReleaseNumber() {
		return releaseNumber;
	}

	public void setReleaseNumber(int releaseNumber) {
		this.releaseNumber = releaseNumber;
	}

	public Date getEntryDate() {
		return entryDate;
	}

	public void setEntryDate(Date entryDate) {
		this.entryDate = entryDate;
	}

	public String getPickUpPoint() {
		return pickUpPoint;
	}

	public void setPickUpPoint(String pickUpPoint) {
		this.pickUpPoint = pickUpPoint;
	}

	public String getPickUpCity() {
		return pickUpCity;
	}

	public void setPickUpCity(String pickUpCity) {
		this.pickUpCity = pickUpCity;
	}

	public String getCarrierID() {
		return carrierID;
	}

	public void setCarrierID(String carrierID) {
		this.carrierID = carrierID;
	}

	public Date getPickUpDate() {
		return pickUpDate;
	}

	public void setPickUpDate(Date pickUpDate) {
		this.pickUpDate = pickUpDate;
	}

	public Date getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public Date getAcceptDate() {
		return acceptDate;
	}

	public void setAcceptDate(Date acceptDate) {
		this.acceptDate = acceptDate;
	}

	public String getUnloaderID() {
		return unloaderID;
	}

	public void setUnloaderID(String unloaderID) {
		this.unloaderID = unloaderID;
	}

	public Date getUnloadDate() {
		return unloadDate;
	}

	public void setUnloadDate(Date unloadDate) {
		this.unloadDate = unloadDate;
	}

	public Date getUnloadTime() {
		return unloadTime;
	}

	public void setUnloadTime(Date unloadTime) {
		this.unloadTime = unloadTime;
	}

	public double getGrossWeight() {
		return grossWeight;
	}

	public void setGrossWeight(double grossWeight) {
		this.grossWeight = grossWeight;
	}

	public double getTareWeight() {
		return tareWeight;
	}

	public void setTareWeight(double tareWeight) {
		this.tareWeight = tareWeight;
	}

	public double getNetWeight() {
		return netWeight;
	}

	public void setNetWeight(double netWeight) {
		this.netWeight = netWeight;
	}

	public String getUnloadComment() {
		return unloadComment;
	}

	public void setUnloadComment(String unloadComment) {
		this.unloadComment = unloadComment;
	}

	public String getLoadStatus() {
		return loadStatus;
	}

	public void setLoadStatus(String loadStatus) {
		this.loadStatus = loadStatus;
	}

	public String getTrailer() {
		return trailer;
	}

	public void setTrailer(String trailer) {
		this.trailer = trailer;
	}

	public String getVendor() {
		return vendor;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
	}

	public String getVendorNumber() {
		return vendorNumber;
	}

	public void setVendorNumber(String vendorNumber) {
		this.vendorNumber = vendorNumber;
	}

	public String getPalletCount() {
		return palletCount;
	}

	public void setPalletCount(String palletCount) {
		this.palletCount = palletCount;
	}

	public String getPickUpState() {
		return pickUpState;
	}

	public void setPickUpState(String pickUpState) {
		this.pickUpState = pickUpState;
	}

	public Date getWeightDate() {
		return weightDate;
	}

	public void setWeightDate(Date weightDate) {
		this.weightDate = weightDate;
	}

	public double getBolWeightTotal() {
		return bolWeightTotal;
	}

	public void setBolWeightTotal(double bolWeightTotal) {
		this.bolWeightTotal = bolWeightTotal;
	}

	public String getTicketNumber() {
		return ticketNumber;
	}

	public void setTicketNumber(String ticketNumber) {
		this.ticketNumber = ticketNumber;
	}

	public double getMoisture() {
		return moisture;
	}

	public void setMoisture(double moisture) {
		this.moisture = moisture;
	}

	public double getDryTonCalc() {
		return dryTonCalc;
	}

	public void setDryTonCalc(double dryTonCalc) {
		this.dryTonCalc = dryTonCalc;
	}

	public String getMasterPO() {
		return masterPO;
	}

	public void setMasterPO(String masterPO) {
		this.masterPO = masterPO;
	}

	public double getBolGoodTotal() {
		return bolGoodTotal;
	}

	public void setBolGoodTotal(double bolGoodTotal) {
		this.bolGoodTotal = bolGoodTotal;
	}

	public Date getPickUpTime() {
		return pickUpTime;
	}

	public void setPickUpTime(Date pickUpTime) {
		this.pickUpTime = pickUpTime;
	}

	public String getEntryNumber() {
		return entryNumber;
	}

	public void setEntryNumber(String entryNumber) {
		this.entryNumber = entryNumber;
	}

	public String getGradeCode() {
		return gradeCode;
	}

	public void setGradeCode(String gradeCode) {
		this.gradeCode = gradeCode;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getBaleCount() {
		return baleCount;
	}

	public void setBaleCount(String baleCount) {
		this.baleCount = baleCount;
	}

	public String getBaleQuality() {
		return baleQuality;
	}

	public void setBaleQuality(String baleQuality) {
		this.baleQuality = baleQuality;
	}

	public String getBolWeight() {
		return bolWeight;
	}

	public void setBolWeight(String bolWeight) {
		this.bolWeight = bolWeight;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

}

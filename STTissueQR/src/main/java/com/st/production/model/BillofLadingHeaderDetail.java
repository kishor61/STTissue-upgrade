/**
 *Dec 11, 2014
 *BillofLadingHeaderDetail.java
 * TODO
 *com.st.production.model
 *BillofLadingHeaderDetail.java
 *Sunil Singh Bora
 */
package com.st.production.model;

import java.util.Date;

/**
 * @author sbora
 *
 */
public class BillofLadingHeaderDetail {
	// Details
	private String poNumber;
	private double shippingNumber;
	private String rollId;
	private double lineId;
	private String rollNumber;
	private String machineNumber;
	private Date productionDate;
	private String gradeCode;
	private String custCode;
	private String rollSize;
	private double rollWeight;
	private int ply;
	private double pieces;
	private String comment;
	private String barcode;
	private double scanDateTime;
	private String grade;

	// Temp
	private int countRoll;

	public String getPoNumber() {
		return poNumber;
	}

	public void setPoNumber(String poNumber) {
		this.poNumber = poNumber;
	}

	public double getShippingNumber() {
		return shippingNumber;
	}

	public void setShippingNumber(double shippingNumber) {
		this.shippingNumber = shippingNumber;
	}

	public String getRollId() {
		return rollId;
	}

	public void setRollId(String rollId) {
		this.rollId = rollId;
	}

	public double getLineId() {
		return lineId;
	}

	public void setLineId(double lineId) {
		this.lineId = lineId;
	}

	public String getRollNumber() {
		return rollNumber;
	}

	public void setRollNumber(String rollNumber) {
		this.rollNumber = rollNumber;
	}

	public String getMachineNumber() {
		return machineNumber;
	}

	public void setMachineNumber(String machineNumber) {
		this.machineNumber = machineNumber;
	}

	public Date getProductionDate() {
		return productionDate;
	}

	public void setProductionDate(Date productionDate) {
		this.productionDate = productionDate;
	}

	public String getGradeCode() {
		return gradeCode;
	}

	public void setGradeCode(String gradeCode) {
		this.gradeCode = gradeCode;
	}

	public String getCustCode() {
		return custCode;
	}

	public void setCustCode(String custCode) {
		this.custCode = custCode;
	}

	public String getRollSize() {
		return rollSize;
	}

	public void setRollSize(String rollSize) {
		this.rollSize = rollSize;
	}

	public double getRollWeight() {
		return rollWeight;
	}

	public void setRollWeight(double rollWeight) {
		this.rollWeight = rollWeight;
	}

	public int getPly() {
		return ply;
	}

	public void setPly(int ply) {
		this.ply = ply;
	}

	public double getPieces() {
		return pieces;
	}

	public void setPieces(double pieces) {
		this.pieces = pieces;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public double getScanDateTime() {
		return scanDateTime;
	}

	public void setScanDateTime(double scanDateTime) {
		this.scanDateTime = scanDateTime;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public int getCountRoll() {
		return countRoll;
	}

	public void setCountRoll(int countRoll) {
		this.countRoll = countRoll;
	}

}

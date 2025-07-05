/**
 * 
 */
package com.st.tracker.model;

import java.util.Date;

/**
 * @author sbora
 * 
 */
public class BaleInventory {
	private String tagId;
	private int releaseNumber;
	private int gradeCode;
	private String quality;
	private double baleWeight;
	private Date unloadDate;
	private Date unloadTime;
	private Date consumedDate;
	private Date consumedTime;
	private Date actualConsumedDateTime;
	private String pulper;
	private String whseLocation;
	private String originalLocation;
	private String ticket;
	private double consumedWeight;
	private int sequence;
	private boolean adjusted;
	
	//Field for Grade
	private String grade;

	public String getTagId() {
		return tagId;
	}

	public void setTagId(String tagId) {
		this.tagId = tagId;
	}

	public int getReleaseNumber() {
		return releaseNumber;
	}

	public void setReleaseNumber(int releaseNumber) {
		this.releaseNumber = releaseNumber;
	}

	public int getGradeCode() {
		return gradeCode;
	}

	public void setGradeCode(int gradeCode) {
		this.gradeCode = gradeCode;
	}

	public String getQuality() {
		return quality;
	}

	public void setQuality(String quality) {
		this.quality = quality;
	}

	public double getBaleWeight() {
		return baleWeight;
	}

	public void setBaleWeight(double baleWeight) {
		this.baleWeight = baleWeight;
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

	public Date getConsumedDate() {
		return consumedDate;
	}

	public void setConsumedDate(Date consumedDate) {
		this.consumedDate = consumedDate;
	}

	public Date getConsumedTime() {
		return consumedTime;
	}

	public void setConsumedTime(Date consumedTime) {
		this.consumedTime = consumedTime;
	}

	public Date getActualConsumedDateTime() {
		return actualConsumedDateTime;
	}

	public void setActualConsumedDateTime(Date actualConsumedDateTime) {
		this.actualConsumedDateTime = actualConsumedDateTime;
	}

	public String getPulper() {
		return pulper;
	}

	public void setPulper(String pulper) {
		this.pulper = pulper;
	}

	public String getWhseLocation() {
		return whseLocation;
	}

	public void setWhseLocation(String whseLocation) {
		this.whseLocation = whseLocation;
	}

	public String getOriginalLocation() {
		return originalLocation;
	}

	public void setOriginalLocation(String originalLocation) {
		this.originalLocation = originalLocation;
	}

	public String getTicket() {
		return ticket;
	}

	public void setTicket(String ticket) {
		this.ticket = ticket;
	}

	public double getConsumedWeight() {
		return consumedWeight;
	}

	public void setConsumedWeight(double consumedWeight) {
		this.consumedWeight = consumedWeight;
	}

	public int getSequence() {
		return sequence;
	}

	public void setSequence(int sequence) {
		this.sequence = sequence;
	}

	public boolean isAdjusted() {
		return adjusted;
	}

	public void setAdjusted(boolean adjusted) {
		this.adjusted = adjusted;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

}

/**
 * 
 */
package com.st.productionpm5.model;

import java.util.Date;

/**
 * @author sbora
 *
 */
public class MachineProductionPM5 {
	private String rollID;
	private String machineNumber;
	private double reelNumber;
	private Date dateEntered;
	private Date timeEntered;
	private Date dateTimeEntered;
	private Date startTime;
	private double timeSpent;
	private String shift;
	private String team;
	private String initials;
	private String felt;
	private String wire;
	private String gradeCode;
	private String furnishCode;
	private String diameter;
	private String footage;
	private double numberBreaks;
	private double goodWeight;
	private double redWeight;
	private double rejectedWeight;
	private double headWeight;
	private String comments;
	private Date dateUsed;
	private double machineSpeed;
	private String reelSpeed;
	private int count;
	private String status;
	private String lastRoll;
	
	//Temp
	private double tbdRate;
	
	//Code Starts From Here Done By Roshan Tailor Date :=23/11/2015
	private int numberofrollswithbreaks;
	private double totalpercentage;
	private double percentageofrollswithbreaks;
	private int totalrollsproduce;
	//Code Ends Here Done By Roshan Tailor Date :- 23/11/2015
	
	public String getRollID() {
		return rollID;
	}
	public void setRollID(String rollID) {
		this.rollID = rollID;
	}
	public String getMachineNumber() {
		return machineNumber;
	}
	public void setMachineNumber(String machineNumber) {
		this.machineNumber = machineNumber;
	}
	public double getReelNumber() {
		return reelNumber;
	}
	public void setReelNumber(double reelNumber) {
		this.reelNumber = reelNumber;
	}
	public Date getDateEntered() {
		return dateEntered;
	}
	public void setDateEntered(Date dateEntered) {
		this.dateEntered = dateEntered;
	}
	public Date getTimeEntered() {
		return timeEntered;
	}
	public void setTimeEntered(Date timeEntered) {
		this.timeEntered = timeEntered;
	}
	public Date getDateTimeEntered() {
		return dateTimeEntered;
	}
	public void setDateTimeEntered(Date dateTimeEntered) {
		this.dateTimeEntered = dateTimeEntered;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public double getTimeSpent() {
		return timeSpent;
	}
	public void setTimeSpent(double timeSpent) {
		this.timeSpent = timeSpent;
	}
	public String getShift() {
		return shift;
	}
	public void setShift(String shift) {
		this.shift = shift;
	}
	public String getTeam() {
		return team;
	}
	public void setTeam(String team) {
		this.team = team;
	}
	public String getInitials() {
		return initials;
	}
	public void setInitials(String initials) {
		this.initials = initials;
	}
	public String getFelt() {
		return felt;
	}
	public void setFelt(String felt) {
		this.felt = felt;
	}
	public String getWire() {
		return wire;
	}
	public void setWire(String wire) {
		this.wire = wire;
	}
	public String getGradeCode() {
		return gradeCode;
	}
	public void setGradeCode(String gradeCode) {
		this.gradeCode = gradeCode;
	}
	public String getDiameter() {
		return diameter;
	}
	public void setDiameter(String diameter) {
		this.diameter = diameter;
	}
	public String getFootage() {
		return footage;
	}
	public void setFootage(String footage) {
		this.footage = footage;
	}
	public double getNumberBreaks() {
		return numberBreaks;
	}
	public void setNumberBreaks(double numberBreaks) {
		this.numberBreaks = numberBreaks;
	}
	public double getGoodWeight() {
		return goodWeight;
	}
	public void setGoodWeight(double goodWeight) {
		this.goodWeight = goodWeight;
	}
	public double getRedWeight() {
		return redWeight;
	}
	public void setRedWeight(double redWeight) {
		this.redWeight = redWeight;
	}
	public double getRejectedWeight() {
		return rejectedWeight;
	}
	public void setRejectedWeight(double rejectedWeight) {
		this.rejectedWeight = rejectedWeight;
	}
	public double getHeadWeight() {
		return headWeight;
	}
	public void setHeadWeight(double headWeight) {
		this.headWeight = headWeight;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public Date getDateUsed() {
		return dateUsed;
	}
	public void setDateUsed(Date dateUsed) {
		this.dateUsed = dateUsed;
	}
	public double getMachineSpeed() {
		return machineSpeed;
	}
	public void setMachineSpeed(double machineSpeed) {
		this.machineSpeed = machineSpeed;
	}
	public String getReelSpeed() {
		return reelSpeed;
	}
	public void setReelSpeed(String reelSpeed) {
		this.reelSpeed = reelSpeed;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getLastRoll() {
		return lastRoll;
	}
	public void setLastRoll(String lastRoll) {
		this.lastRoll = lastRoll;
	}
	public double getTbdRate() {
		return tbdRate;
	}
	public void setTbdRate(double tbdRate) {
		this.tbdRate = tbdRate;
	}
	public int getNumberofrollswithbreaks() {
		return numberofrollswithbreaks;
	}
	public void setNumberofrollswithbreaks(int numberofrollswithbreaks) {
		this.numberofrollswithbreaks = numberofrollswithbreaks;
	}
	public double getTotalpercentage() {
		return totalpercentage;
	}
	public void setTotalpercentage(double totalpercentage) {
		this.totalpercentage = totalpercentage;
	}
	public double getPercentageofrollswithbreaks() {
		return percentageofrollswithbreaks;
	}
	public void setPercentageofrollswithbreaks(double percentageofrollswithbreaks) {
		this.percentageofrollswithbreaks = percentageofrollswithbreaks;
	}
	public int getTotalrollsproduce() {
		return totalrollsproduce;
	}
	public void setTotalrollsproduce(int totalrollsproduce) {
		this.totalrollsproduce = totalrollsproduce;
	}
	public String getFurnishCode() {
		return furnishCode;
	}
	public void setFurnishCode(String furnishCode) {
		this.furnishCode = furnishCode;
	}
	
}

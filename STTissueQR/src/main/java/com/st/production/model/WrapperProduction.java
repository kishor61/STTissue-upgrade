/**
 * 
 */
package com.st.production.model;

import java.util.Date;

/**
 * @author sbora
 *
 */
public class WrapperProduction {
	private String wrapperNumber;
	private String rollID;
	private Date dateEntered;
	private Date timeEntered;
	private Date dateTimeEntered;
	private String rollNumber;
	private String setPosition;
	private String shift;
	private String gradeCode;
	private String furnishCode;
	private String customerGradeCode;
	private double whiteWeight;
	private double redWeight;
	private double rejectWeight;
	private boolean qualityHold;
	private String orderNumber;
	private double productionTime;
	private String team;
	private String initials;
	private String diameter;
	private String rollWidth;
	private int ply;
	private String coreSize;
	private String barcode;
	private String comment;
	private Date transferDate;
	private String transferLocation;
	private String customer;
	private String redValue;
	private String redCode;
	private String redCodeValue;
	private String redCustomer;
	private boolean parentRoll;
	private boolean labelPrinted;
	private double breaks;
	private Date startDateTime;
	private Date dateShipped;
	private String nextSet;
	private Date invoiceDate;
	private String invoiceNumber;
	private String invoiceType;
	private String slabDate;
	//Code Starts From Here Done By Roshan Tailor Date :- 2015-11-17
	private int numberofrollswithbreaks;
	private double percentageofrollswithbreaks;
	private double totalpercentage;
	private int totalrollsproduce;
	//Code Ends Here Done By Roshan Tailor Date :- 2015-11-17
	
	//Code Starts From Here Done By Roshan Tailor Date :- 07/05/2016
	private String coresize; 
	//Code Ends Here Done By Roshan Tailor Date:- 07/05/2015
	
	//Temp
	private double tbdRate;
	private int minutes;
	
	private int rollCount;
	private String color;
	private String shortType;
	private String grade;
	private String poNumber;
	private String shippingNo;
	
	private double whiteWeightMax;
	private double whiteWeightMin;
	
	private double diam;
	private double rwidth;
	private String weightVar;
	private double reelNumber1;
	private String machineRollID1;
	private double reelWidth;
	private double reelWeight;
	private double coreSizeN;
	
	//Temp for newRed/REject
	private boolean isNewRed;
	
	
	private int dayrollproduse;
	private int nightrollproduse;
	private int daybreaks;
	private int nightbreaks;
	
	public String getWrapperNumber() {
		return wrapperNumber;
	}
	public void setWrapperNumber(String wrapperNumber) {
		this.wrapperNumber = wrapperNumber;
	}
	public String getRollID() {
		return rollID;
	}
	public void setRollID(String rollID) {
		this.rollID = rollID;
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
	public String getRollNumber() {
		return rollNumber;
	}
	public void setRollNumber(String rollNumber) {
		this.rollNumber = rollNumber;
	}
	public String getSetPosition() {
		return setPosition;
	}
	public void setSetPosition(String setPosition) {
		this.setPosition = setPosition;
	}
	public String getShift() {
		return shift;
	}
	public void setShift(String shift) {
		this.shift = shift;
	}
	public String getGradeCode() {
		return gradeCode;
	}
	public void setGradeCode(String gradeCode) {
		this.gradeCode = gradeCode;
	}
	public String getCustomerGradeCode() {
		return customerGradeCode;
	}
	public void setCustomerGradeCode(String customerGradeCode) {
		this.customerGradeCode = customerGradeCode;
	}
	public double getWhiteWeight() {
		return whiteWeight;
	}
	public void setWhiteWeight(double whiteWeight) {
		this.whiteWeight = whiteWeight;
	}
	public double getRedWeight() {
		return redWeight;
	}
	public void setRedWeight(double redWeight) {
		this.redWeight = redWeight;
	}
	public double getRejectWeight() {
		return rejectWeight;
	}
	public void setRejectWeight(double rejectWeight) {
		this.rejectWeight = rejectWeight;
	}
	public boolean isQualityHold() {
		return qualityHold;
	}
	public void setQualityHold(boolean qualityHold) {
		this.qualityHold = qualityHold;
	}
	public String getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}
	public double getProductionTime() {
		return productionTime;
	}
	public void setProductionTime(double productionTime) {
		this.productionTime = productionTime;
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
	public String getDiameter() {
		return diameter;
	}
	public void setDiameter(String diameter) {
		this.diameter = diameter;
	}
	public String getRollWidth() {
		return rollWidth;
	}
	public void setRollWidth(String rollWidth) {
		this.rollWidth = rollWidth;
	}
	public int getPly() {
		return ply;
	}
	public void setPly(int ply) {
		this.ply = ply;
	}
	public String getCoreSize() {
		return coreSize;
	}
	public void setCoreSize(String coreSize) {
		this.coreSize = coreSize;
	}
	public String getBarcode() {
		return barcode;
	}
	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Date getTransferDate() {
		return transferDate;
	}
	public void setTransferDate(Date transferDate) {
		this.transferDate = transferDate;
	}
	public String getTransferLocation() {
		return transferLocation;
	}
	public void setTransferLocation(String transferLocation) {
		this.transferLocation = transferLocation;
	}
	public String getCustomer() {
		return customer;
	}
	public void setCustomer(String customer) {
		this.customer = customer;
	}
	public String getRedValue() {
		return redValue;
	}
	public void setRedValue(String redValue) {
		this.redValue = redValue;
	}
	public String getRedCode() {
		return redCode;
	}
	public void setRedCode(String redCode) {
		this.redCode = redCode;
	}
	public String getRedCodeValue() {
		return redCodeValue;
	}
	public void setRedCodeValue(String redCodeValue) {
		this.redCodeValue = redCodeValue;
	}
	public String getRedCustomer() {
		return redCustomer;
	}
	public void setRedCustomer(String redCustomer) {
		this.redCustomer = redCustomer;
	}
	public boolean isParentRoll() {
		return parentRoll;
	}
	public void setParentRoll(boolean parentRoll) {
		this.parentRoll = parentRoll;
	}
	public boolean isLabelPrinted() {
		return labelPrinted;
	}
	public void setLabelPrinted(boolean labelPrinted) {
		this.labelPrinted = labelPrinted;
	}
	public double getBreaks() {
		return breaks;
	}
	public void setBreaks(double breaks) {
		this.breaks = breaks;
	}
	public Date getStartDateTime() {
		return startDateTime;
	}
	public void setStartDateTime(Date startDateTime) {
		this.startDateTime = startDateTime;
	}
	public Date getDateShipped() {
		return dateShipped;
	}
	public void setDateShipped(Date dateShipped) {
		this.dateShipped = dateShipped;
	}
	public String getNextSet() {
		return nextSet;
	}
	public void setNextSet(String nextSet) {
		this.nextSet = nextSet;
	}
	public Date getInvoiceDate() {
		return invoiceDate;
	}
	public void setInvoiceDate(Date invoiceDate) {
		this.invoiceDate = invoiceDate;
	}
	public String getInvoiceNumber() {
		return invoiceNumber;
	}
	public void setInvoiceNumber(String invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}
	public String getInvoiceType() {
		return invoiceType;
	}
	public void setInvoiceType(String invoiceType) {
		this.invoiceType = invoiceType;
	}
	public String getSlabDate() {
		return slabDate;
	}
	public void setSlabDate(String slabDate) {
		this.slabDate = slabDate;
	}
	/**
	 * @return the tbdRate
	 */
	public double getTbdRate() {
		return tbdRate;
	}
	/**
	 * @param tbdRate the tbdRate to set
	 */
	public void setTbdRate(double tbdRate) {
		this.tbdRate = tbdRate;
	}
	/**
	 * @return the minutes
	 */
	public int getMinutes() {
		return minutes;
	}
	/**
	 * @param minutes the minutes to set
	 */
	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getRollCount() {
		return rollCount;
	}
	public void setRollCount(int rollCount) {
		this.rollCount = rollCount;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getPoNumber() {
		return poNumber;
	}
	public void setPoNumber(String poNumber) {
		this.poNumber = poNumber;
	}
	public String getShortType() {
		return shortType;
	}
	public void setShortType(String shortType) {
		this.shortType = shortType;
	}
	public String getShippingNo() {
		return shippingNo;
	}
	public void setShippingNo(String shippingNo) {
		this.shippingNo = shippingNo;
	}
	public boolean isNewRed() {
		return isNewRed;
	}
	public void setNewRed(boolean isNewRed) {
		this.isNewRed = isNewRed;
	}
	public double getWhiteWeightMax() {
		return whiteWeightMax;
	}
	public void setWhiteWeightMax(double whiteWeightMax) {
		this.whiteWeightMax = whiteWeightMax;
	}
	public double getWhiteWeightMin() {
		return whiteWeightMin;
	}
	public void setWhiteWeightMin(double whiteWeightMin) {
		this.whiteWeightMin = whiteWeightMin;
	}
	public double getDiam() {
		return diam;
	}
	public void setDiam(double diam) {
		this.diam = diam;
	}
	public double getRwidth() {
		return rwidth;
	}
	public void setRwidth(double rwidth) {
		this.rwidth = rwidth;
	}
	public String getWeightVar() {
		return weightVar;
	}
	public void setWeightVar(String weightVar) {
		this.weightVar = weightVar;
	}
	public double getReelNumber1() {
		return reelNumber1;
	}
	public void setReelNumber1(double reelNumber1) {
		this.reelNumber1 = reelNumber1;
	}
	public String getMachineRollID1() {
		return machineRollID1;
	}
	public void setMachineRollID1(String machineRollID1) {
		this.machineRollID1 = machineRollID1;
	}
	public double getReelWidth() {
		return reelWidth;
	}
	public void setReelWidth(double reelWidth) {
		this.reelWidth = reelWidth;
	}
	public double getReelWeight() {
		return reelWeight;
	}
	public void setReelWeight(double reelWeight) {
		this.reelWeight = reelWeight;
	}
	public double getCoreSizeN() {
		return coreSizeN;
	}
	public void setCoreSizeN(double coreSizeN) {
		this.coreSizeN = coreSizeN;
	}
	public int getNumberofrollswithbreaks() {
		return numberofrollswithbreaks;
	}
	public void setNumberofrollswithbreaks(int numberofrollswithbreaks) {
		this.numberofrollswithbreaks = numberofrollswithbreaks;
	}
	public double getPercentageofrollswithbreaks() {
		return percentageofrollswithbreaks;
	}
	public void setPercentageofrollswithbreaks(double percentageofrollswithbreaks) {
		this.percentageofrollswithbreaks = percentageofrollswithbreaks;
	}
	public double getTotalpercentage() {
		return totalpercentage;
	}
	public void setTotalpercentage(double totalpercentage) {
		this.totalpercentage = totalpercentage;
	}
	/**
	 * @return the totalrollsproduce
	 */
	public int getTotalrollsproduce() {
		return totalrollsproduce;
	}
	/**
	 * @param totalrollsproduce the totalrollsproduce to set
	 */
	public void setTotalrollsproduce(int totalrollsproduce) {
		this.totalrollsproduce = totalrollsproduce;
	}
	public String getCoresize() {
		return coresize;
	}
	public void setCoresize(String coresize) {
		this.coresize = coresize;
	}
	public int getDayrollproduse() {
		return dayrollproduse;
	}
	public void setDayrollproduse(int dayrollproduse) {
		this.dayrollproduse = dayrollproduse;
	}
	public int getNightrollproduse() {
		return nightrollproduse;
	}
	public void setNightrollproduse(int nightrollproduse) {
		this.nightrollproduse = nightrollproduse;
	}
	public int getDaybreaks() {
		return daybreaks;
	}
	public void setDaybreaks(int daybreaks) {
		this.daybreaks = daybreaks;
	}
	public int getNightbreaks() {
		return nightbreaks;
	}
	public void setNightbreaks(int nightbreaks) {
		this.nightbreaks = nightbreaks;
	}
	public String getFurnishCode() {
		return furnishCode;
	}
	public void setFurnishCode(String furnishCode) {
		this.furnishCode = furnishCode;
	}

}

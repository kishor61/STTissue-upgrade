/**
 *Jan 19, 2015
 *FrpDailyData.java
 * TODO
 *com.st.frppressquality.model
 *FrpDailyData.java
 *Sunil Singh Bora
 */
package com.st.frppressquality.model;

/**
 * @author sbora
 *
 */
public class FrpDailyData {
	private String date;
	private String grade;

	private double wastepaperFed;
	private double wastepaperFedBDST;

	private double totalProduction;
	private double totalProductionBDST;

	private double sludgeHauled;
	private double sludgeConsistency;

	private double sludgeHauledLBS;
	private double sludgeHauledBDST;

	private double rejectsBwHauled;
	private double rejectsBwConsistency;

	private double rejectsBwHauledLBS;
	private double rejectsBwHauledBDST;
	
	private double totalSolidsSentToIP;

	private String frpSludgePressRunning;
	private String frpScrewPressRunning;

	private double yield;

	private double millWater1008;
	private double millWater1009;
	private double waterCost;
	private double waterCostPeADST;
	
	private double stSludgeConsistency=0;
	private double stIpSludgeConsistency=0;
	
	
	// Wrapper
	private double wrapperTon;
	private double wrapperTonBDST;
	private double sewerLoss=0;
	private double fiberToFrp=0;
	private double prodSlabOff=0;
	private double wetLapProd=0;
	
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public double getWastepaperFed() {
		return wastepaperFed;
	}
	public void setWastepaperFed(double wastepaperFed) {
		this.wastepaperFed = wastepaperFed;
	}
	public double getWastepaperFedBDST() {
		return wastepaperFedBDST;
	}
	public void setWastepaperFedBDST(double wastepaperFedBDST) {
		this.wastepaperFedBDST = wastepaperFedBDST;
	}
	public double getTotalProduction() {
		return totalProduction;
	}
	public void setTotalProduction(double totalProduction) {
		this.totalProduction = totalProduction;
	}
	public double getTotalProductionBDST() {
		return totalProductionBDST;
	}
	public void setTotalProductionBDST(double totalProductionBDST) {
		this.totalProductionBDST = totalProductionBDST;
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
	public double getSludgeHauledLBS() {
		return sludgeHauledLBS;
	}
	public void setSludgeHauledLBS(double sludgeHauledLBS) {
		this.sludgeHauledLBS = sludgeHauledLBS;
	}
	public double getSludgeHauledBDST() {
		return sludgeHauledBDST;
	}
	public void setSludgeHauledBDST(double sludgeHauledBDST) {
		this.sludgeHauledBDST = sludgeHauledBDST;
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
	public double getRejectsBwHauledLBS() {
		return rejectsBwHauledLBS;
	}
	public void setRejectsBwHauledLBS(double rejectsBwHauledLBS) {
		this.rejectsBwHauledLBS = rejectsBwHauledLBS;
	}
	public double getRejectsBwHauledBDST() {
		return rejectsBwHauledBDST;
	}
	public void setRejectsBwHauledBDST(double rejectsBwHauledBDST) {
		this.rejectsBwHauledBDST = rejectsBwHauledBDST;
	}
	public double getTotalSolidsSentToIP() {
		return totalSolidsSentToIP;
	}
	public void setTotalSolidsSentToIP(double totalSolidsSentToIP) {
		this.totalSolidsSentToIP = totalSolidsSentToIP;
	}
	public String getFrpSludgePressRunning() {
		return frpSludgePressRunning;
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
	public double getYield() {
		return yield;
	}
	public void setYield(double yield) {
		this.yield = yield;
	}
	public double getMillWater1008() {
		return millWater1008;
	}
	public void setMillWater1008(double millWater1008) {
		this.millWater1008 = millWater1008;
	}
	public double getMillWater1009() {
		return millWater1009;
	}
	public void setMillWater1009(double millWater1009) {
		this.millWater1009 = millWater1009;
	}
	public double getWaterCost() {
		return waterCost;
	}
	public void setWaterCost(double waterCost) {
		this.waterCost = waterCost;
	}
	public double getWaterCostPeADST() {
		return waterCostPeADST;
	}
	public void setWaterCostPeADST(double waterCostPeADST) {
		this.waterCostPeADST = waterCostPeADST;
	}
	public double getStSludgeConsistency() {
		return stSludgeConsistency;
	}
	public void setStSludgeConsistency(double stSludgeConsistency) {
		this.stSludgeConsistency = stSludgeConsistency;
	}
	public double getStIpSludgeConsistency() {
		return stIpSludgeConsistency;
	}
	public void setStIpSludgeConsistency(double stIpSludgeConsistency) {
		this.stIpSludgeConsistency = stIpSludgeConsistency;
	}
	public double getWrapperTon() {
		return wrapperTon;
	}
	public void setWrapperTon(double wrapperTon) {
		this.wrapperTon = wrapperTon;
	}
	public double getWrapperTonBDST() {
		return wrapperTonBDST;
	}
	public void setWrapperTonBDST(double wrapperTonBDST) {
		this.wrapperTonBDST = wrapperTonBDST;
	}
	public double getSewerLoss() {
		return sewerLoss;
	}
	public void setSewerLoss(double sewerLoss) {
		this.sewerLoss = sewerLoss;
	}
	public double getFiberToFrp() {
		return fiberToFrp;
	}
	public void setFiberToFrp(double fiberToFrp) {
		this.fiberToFrp = fiberToFrp;
	}
	public double getProdSlabOff() {
		return prodSlabOff;
	}
	public void setProdSlabOff(double prodSlabOff) {
		this.prodSlabOff = prodSlabOff;
	}
	public double getWetLapProd() {
		return wetLapProd;
	}
	public void setWetLapProd(double wetLapProd) {
		this.wetLapProd = wetLapProd;
	}

}

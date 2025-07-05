package com.st.centerline.model;

import java.util.Date;


public class CenterlineGrade {
	private int id;
	private String grade;
	private String crew;
	private String shift;
	
	private double yankeeSpeed;
	private double qcsBasisWtTarget;
	private double reelMoisture;
	private double crepe;
	private double yankeeSteam;
	private double yankeeRelease;
	private double yankeeAdesive;
	private double jetWireRatio;
	private double fanPumpFlowRate;
	private double afterDryerSteam;
	private String sprLoading;
	private double feltPassivator;
	private double sprayboomPressure;
	private double sprayboomTemparature;
	private double wefanSpeed;
	private double defanSpeed;
	private double makeUpAirDamper;
	private double exhaustDamper;
	private double exhaustFanSpeed;
	private double wehoodTemperature;
	private double dehoodTemperature;
	private double yankeeAP;
	private double afterDryerAP;
	private double secArmLoading;
	private double reelOffset;
	private double uhleBoxNorthValve;
	private double uhleBoxSouthValve;
	private double faltBox1VacuumValve;
	private double faltBox2VacuumValve;
	private double faltBox4VacuumValve;
	private double fanPumpSpeed;
	private double totalHead;
	private double headboxLevel;
	private String horizontalSlice;
	private String verticalSlice;
	private double selectifierRejectFlow1;
	private double selectifierRejectFlow2;
	private double secScreenCycleTime;
	private double lowDensityCycleTime;
	private double refinersEnergy;
	private double numberOfRefiners;
	private double refinerInletConsistency;
	private double machineChestConsistency;
	private double stockFlow;
	private double sweetnerFlow;
	private double broke;
	private double wetStrength;

	private double yankeeSpeedMinC;
	private double qcsBasisWtTargetMinC;
	private double reelMoistureMinC;
	private double crepeMinC;
	private double yankeeSteamMinC;
	private double yankeeReleaseMinC;
	private double yankeeAdesiveMinC;
	private double jetWireRatioMinC;
	private double fanPumpFlowRateMinC;
	private double afterDryerSteamMinC;
	private String sprLoadingMinC;
	private double feltPassivatorMinC;
	private double sprayboomPressureMinC;
	private double sprayboomTemparatureMinC;
	private double wefanSpeedMinC;
	private double defanSpeedMinC;
	private double makeUpAirDamperMinC;
	private double exhaustDamperMinC;
	private double exhaustFanSpeedMinC;
	private double wehoodTemperatureMinC;
	private double dehoodTemperatureMinC;
	private double yankeeAPMinC;
	private double afterDryerAPMinC;
	private double secArmLoadingMinC;
	private double reelOffsetMinC;
	private double uhleBoxNorthValveMinC;
	private double uhleBoxSouthValveMinC;
	private double faltBox1VacuumValveMinC;
	private double faltBox2VacuumValveMinC;
	private double faltBox4VacuumValveMinC;
	private double fanPumpSpeedMinC;
	private double totalHeadMinC;
	private double headboxLevelMinC;
	private String horizontalSliceMinC;
	private String verticalSliceMinC;
	private double selectifierRejectFlow1MinC;
	private double selectifierRejectFlow2MinC;
	private double secScreenCycleTimeMinC;
	private double lowDensityCycleTimeMinC;
	private double refinersEnergyMinC;
	private double numberOfRefinersMinC;
	private double refinerInletConsistencyMinC;
	private double machineChestConsistencyMinC;
	private double stockFlowMinC;
	private double sweetnerFlowMinC;
	private double brokeMinC;
	private double wetStrengthMinC;
	
	private double yankeeSpeedMaxC;
	private double qcsBasisWtTargetMaxC;
	private double reelMoistureMaxC;
	private double crepeMaxC;
	private double yankeeSteamMaxC;
	private double yankeeReleaseMaxC;
	private double yankeeAdesiveMaxC;
	private double jetWireRatioMaxC;
	private double fanPumpFlowRateMaxC;
	private double afterDryerSteamMaxC;
	private String sprLoadingMaxC;
	private double feltPassivatorMaxC;
	private double sprayboomPressureMaxC;
	private double sprayboomTemparatureMaxC;
	private double wefanSpeedMaxC;
	private double defanSpeedMaxC;
	private double makeUpAirDamperMaxC;
	private double exhaustDamperMaxC;
	private double exhaustFanSpeedMaxC;
	private double wehoodTemperatureMaxC;
	private double dehoodTemperatureMaxC;
	private double yankeeAPMaxC;
	private double afterDryerAPMaxC;
	private double secArmLoadingMaxC;
	private double reelOffsetMaxC;
	private double uhleBoxNorthValveMaxC;
	private double uhleBoxSouthValveMaxC;
	private double faltBox1VacuumValveMaxC;
	private double faltBox2VacuumValveMaxC;
	private double faltBox4VacuumValveMaxC;
	private double fanPumpSpeedMaxC;
	private double totalHeadMaxC;
	private double headboxLevelMaxC;
	private String horizontalSliceMaxC;
	private String verticalSliceMaxC;
	private double selectifierRejectFlow1MaxC;
	private double selectifierRejectFlow2MaxC;
	private double secScreenCycleTimeMaxC;
	private double lowDensityCycleTimeMaxC;
	private double refinersEnergyMaxC;
	private double numberOfRefinersMaxC;
	private double refinerInletConsistencyMaxC;
	private double machineChestConsistencyMaxC;
	private double stockFlowMaxC;
	private double sweetnerFlowMaxC;
	private double brokeMaxC;
	private double wetStrengthMaxC;
	
	
	
	//New Field added 2014-09-02
	private double afterDryerDrawMinC;
	private double afterDryerDraw;
	private double afterDryerDrawMaxC;
	
	private String horizontalSliceDcsMinC;
	private String horizontalSliceDcs;
	private String horizontalSliceDcsMaxC;
	
	private String verticalSliceDcsMinC;
	private String verticalSliceDcs;
	private String verticalSliceDcsMaxC;
	
	
	//New Filed Added By Roshan 
	
	private double sprloadingfrontMinC;
	private double sprloadingfront;
	private double sprloadingfrontMaxC;

	private double sprloadingbackMinC;
	private double sprloadingback;
	private double sprloadingbackMaxC;

	private double pickuprollvacuumMinC;
	private double pickuprollvacuum;
	private double pickuprollvacuumMaxC;

	private double uhleboxvacuumMinC;
	private double uhleboxvacuum;
	private double uhleboxvacuumMaxC;

	private double sprvacuumMinC;
	private double sprvacuum;
	private double sprvacuumMaxC;

	private double primaryscreenrejectflowMinC;
	private double 	primaryscreenrejectflow;
	private double primaryscreenrejectflowMaxC;

	private double blendchestcyMinC;
	private double blendchestcy;
	private double blendchestcyMaxC;

	private double refiner1powerMinC;
	private double refiner1power;
	private double refiner1powerMaxC;

	private double refiner2powerMinC;
	private double refiner2power;
	private double refiner2powerMaxC;

	private double refiner1inletcyMinC;
	private double refiner1inletcy;
	private double refiner1inletcyMaxC;

	private double refiner2inletcyMinC;
	private double refiner2inletcy;
	private double refiner2inletcyMaxC;



	private double basisweighttargetMinC;
	private double basisweighttarget;
	private double basisweighttargetMaxC;


	private double moisturetargetMinC;
	private double moisturetarget;
	private double moisturetargetMaxC;
	
	
	private double yankeemapflowMinC;
	private double yankeemapflow;
	private double yankeemapflowMaxC;
	
	
	private double machinechestpumpspeedMinC;
	private double machinechestpumpspeed;
	private double machinechestpumpspeedMaxC;
	
	
	
	private String fissueDate;
	
	private Date issueDate;
	private String revision;
	
	
	private Date rltDate;
	
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getCrew() {
		return crew;
	}
	public void setCrew(String crew) {
		this.crew = crew;
	}
	public String getShift() {
		return shift;
	}
	public void setShift(String shift) {
		this.shift = shift;
	}
	public double getYankeeSpeed() {
		return yankeeSpeed;
	}
	public void setYankeeSpeed(double yankeeSpeed) {
		this.yankeeSpeed = yankeeSpeed;
	}

	public double getReelMoisture() {
		return reelMoisture;
	}
	public void setReelMoisture(double reelMoisture) {
		this.reelMoisture = reelMoisture;
	}
	public double getCrepe() {
		return crepe;
	}
	public void setCrepe(double crepe) {
		this.crepe = crepe;
	}
	public double getYankeeSteam() {
		return yankeeSteam;
	}
	public void setYankeeSteam(double yankeeSteam) {
		this.yankeeSteam = yankeeSteam;
	}
	public double getYankeeRelease() {
		return yankeeRelease;
	}
	public void setYankeeRelease(double yankeeRelease) {
		this.yankeeRelease = yankeeRelease;
	}
	public double getYankeeAdesive() {
		return yankeeAdesive;
	}
	public void setYankeeAdesive(double yankeeAdesive) {
		this.yankeeAdesive = yankeeAdesive;
	}
	public double getJetWireRatio() {
		return jetWireRatio;
	}
	public void setJetWireRatio(double jetWireRatio) {
		this.jetWireRatio = jetWireRatio;
	}
	public double getFanPumpFlowRate() {
		return fanPumpFlowRate;
	}
	public void setFanPumpFlowRate(double fanPumpFlowRate) {
		this.fanPumpFlowRate = fanPumpFlowRate;
	}
	public double getAfterDryerSteam() {
		return afterDryerSteam;
	}
	public void setAfterDryerSteam(double afterDryerSteam) {
		this.afterDryerSteam = afterDryerSteam;
	}
	public String getSprLoading() {
		return sprLoading;
	}
	public void setSprLoading(String sprLoading) {
		this.sprLoading = sprLoading;
	}
	public double getFeltPassivator() {
		return feltPassivator;
	}
	public void setFeltPassivator(double feltPassivator) {
		this.feltPassivator = feltPassivator;
	}
	public double getSprayboomPressure() {
		return sprayboomPressure;
	}
	public void setSprayboomPressure(double sprayboomPressure) {
		this.sprayboomPressure = sprayboomPressure;
	}
	public double getSprayboomTemparature() {
		return sprayboomTemparature;
	}
	public void setSprayboomTemparature(double sprayboomTemparature) {
		this.sprayboomTemparature = sprayboomTemparature;
	}
	public double getWefanSpeed() {
		return wefanSpeed;
	}
	public void setWefanSpeed(double wefanSpeed) {
		this.wefanSpeed = wefanSpeed;
	}
	public double getDefanSpeed() {
		return defanSpeed;
	}
	public void setDefanSpeed(double defanSpeed) {
		this.defanSpeed = defanSpeed;
	}
	public double getMakeUpAirDamper() {
		return makeUpAirDamper;
	}
	public void setMakeUpAirDamper(double makeUpAirDamper) {
		this.makeUpAirDamper = makeUpAirDamper;
	}
	public double getExhaustDamper() {
		return exhaustDamper;
	}
	public void setExhaustDamper(double exhaustDamper) {
		this.exhaustDamper = exhaustDamper;
	}
	public double getExhaustFanSpeed() {
		return exhaustFanSpeed;
	}
	public void setExhaustFanSpeed(double exhaustFanSpeed) {
		this.exhaustFanSpeed = exhaustFanSpeed;
	}
	public double getWehoodTemperature() {
		return wehoodTemperature;
	}
	public void setWehoodTemperature(double wehoodTemperature) {
		this.wehoodTemperature = wehoodTemperature;
	}
	public double getDehoodTemperature() {
		return dehoodTemperature;
	}
	public void setDehoodTemperature(double dehoodTemperature) {
		this.dehoodTemperature = dehoodTemperature;
	}
	public double getYankeeAP() {
		return yankeeAP;
	}
	public void setYankeeAP(double yankeeAP) {
		this.yankeeAP = yankeeAP;
	}
	public double getAfterDryerAP() {
		return afterDryerAP;
	}
	public void setAfterDryerAP(double afterDryerAP) {
		this.afterDryerAP = afterDryerAP;
	}
	public double getSecArmLoading() {
		return secArmLoading;
	}
	public void setSecArmLoading(double secArmLoading) {
		this.secArmLoading = secArmLoading;
	}
	public double getReelOffset() {
		return reelOffset;
	}
	public void setReelOffset(double reelOffset) {
		this.reelOffset = reelOffset;
	}
	public double getUhleBoxNorthValve() {
		return uhleBoxNorthValve;
	}
	public void setUhleBoxNorthValve(double uhleBoxNorthValve) {
		this.uhleBoxNorthValve = uhleBoxNorthValve;
	}
	public double getUhleBoxSouthValve() {
		return uhleBoxSouthValve;
	}
	public void setUhleBoxSouthValve(double uhleBoxSouthValve) {
		this.uhleBoxSouthValve = uhleBoxSouthValve;
	}
	public double getFaltBox1VacuumValve() {
		return faltBox1VacuumValve;
	}
	public void setFaltBox1VacuumValve(double faltBox1VacuumValve) {
		this.faltBox1VacuumValve = faltBox1VacuumValve;
	}
	public double getFaltBox2VacuumValve() {
		return faltBox2VacuumValve;
	}
	public void setFaltBox2VacuumValve(double faltBox2VacuumValve) {
		this.faltBox2VacuumValve = faltBox2VacuumValve;
	}
	public double getFaltBox4VacuumValve() {
		return faltBox4VacuumValve;
	}
	public void setFaltBox4VacuumValve(double faltBox4VacuumValve) {
		this.faltBox4VacuumValve = faltBox4VacuumValve;
	}
	public double getFanPumpSpeed() {
		return fanPumpSpeed;
	}
	public void setFanPumpSpeed(double fanPumpSpeed) {
		this.fanPumpSpeed = fanPumpSpeed;
	}
	public double getTotalHead() {
		return totalHead;
	}
	public void setTotalHead(double totalHead) {
		this.totalHead = totalHead;
	}
	public double getHeadboxLevel() {
		return headboxLevel;
	}
	public void setHeadboxLevel(double headboxLevel) {
		this.headboxLevel = headboxLevel;
	}
	public String getHorizontalSlice() {
		return horizontalSlice;
	}
	public void setHorizontalSlice(String horizontalSlice) {
		this.horizontalSlice = horizontalSlice;
	}
	public String getVerticalSlice() {
		return verticalSlice;
	}
	public void setVerticalSlice(String verticalSlice) {
		this.verticalSlice = verticalSlice;
	}
	public double getSelectifierRejectFlow1() {
		return selectifierRejectFlow1;
	}
	public void setSelectifierRejectFlow1(double selectifierRejectFlow1) {
		this.selectifierRejectFlow1 = selectifierRejectFlow1;
	}
	public double getSelectifierRejectFlow2() {
		return selectifierRejectFlow2;
	}
	public void setSelectifierRejectFlow2(double selectifierRejectFlow2) {
		this.selectifierRejectFlow2 = selectifierRejectFlow2;
	}
	public double getSecScreenCycleTime() {
		return secScreenCycleTime;
	}
	public void setSecScreenCycleTime(double secScreenCycleTime) {
		this.secScreenCycleTime = secScreenCycleTime;
	}
	public double getLowDensityCycleTime() {
		return lowDensityCycleTime;
	}
	public void setLowDensityCycleTime(double lowDensityCycleTime) {
		this.lowDensityCycleTime = lowDensityCycleTime;
	}
	public double getRefinersEnergy() {
		return refinersEnergy;
	}
	public void setRefinersEnergy(double refinersEnergy) {
		this.refinersEnergy = refinersEnergy;
	}
	public double getNumberOfRefiners() {
		return numberOfRefiners;
	}
	public void setNumberOfRefiners(double numberOfRefiners) {
		this.numberOfRefiners = numberOfRefiners;
	}
	public double getRefinerInletConsistency() {
		return refinerInletConsistency;
	}
	public void setRefinerInletConsistency(double refinerInletConsistency) {
		this.refinerInletConsistency = refinerInletConsistency;
	}
	public double getMachineChestConsistency() {
		return machineChestConsistency;
	}
	public void setMachineChestConsistency(double machineChestConsistency) {
		this.machineChestConsistency = machineChestConsistency;
	}
	public double getStockFlow() {
		return stockFlow;
	}
	public void setStockFlow(double stockFlow) {
		this.stockFlow = stockFlow;
	}
	public double getSweetnerFlow() {
		return sweetnerFlow;
	}
	public void setSweetnerFlow(double sweetnerFlow) {
		this.sweetnerFlow = sweetnerFlow;
	}
	public double getBroke() {
		return broke;
	}
	public void setBroke(double broke) {
		this.broke = broke;
	}
	public double getWetStrength() {
		return wetStrength;
	}
	public void setWetStrength(double wetStrength) {
		this.wetStrength = wetStrength;
	}
	public double getYankeeSpeedMinC() {
		return yankeeSpeedMinC;
	}
	public void setYankeeSpeedMinC(double yankeeSpeedMinC) {
		this.yankeeSpeedMinC = yankeeSpeedMinC;
	}

	public double getReelMoistureMinC() {
		return reelMoistureMinC;
	}
	public void setReelMoistureMinC(double reelMoistureMinC) {
		this.reelMoistureMinC = reelMoistureMinC;
	}
	public double getCrepeMinC() {
		return crepeMinC;
	}
	public void setCrepeMinC(double crepeMinC) {
		this.crepeMinC = crepeMinC;
	}
	public double getYankeeSteamMinC() {
		return yankeeSteamMinC;
	}
	public void setYankeeSteamMinC(double yankeeSteamMinC) {
		this.yankeeSteamMinC = yankeeSteamMinC;
	}
	public double getYankeeReleaseMinC() {
		return yankeeReleaseMinC;
	}
	public void setYankeeReleaseMinC(double yankeeReleaseMinC) {
		this.yankeeReleaseMinC = yankeeReleaseMinC;
	}
	public double getYankeeAdesiveMinC() {
		return yankeeAdesiveMinC;
	}
	public void setYankeeAdesiveMinC(double yankeeAdesiveMinC) {
		this.yankeeAdesiveMinC = yankeeAdesiveMinC;
	}
	public double getJetWireRatioMinC() {
		return jetWireRatioMinC;
	}
	public void setJetWireRatioMinC(double jetWireRatioMinC) {
		this.jetWireRatioMinC = jetWireRatioMinC;
	}
	public double getFanPumpFlowRateMinC() {
		return fanPumpFlowRateMinC;
	}
	public void setFanPumpFlowRateMinC(double fanPumpFlowRateMinC) {
		this.fanPumpFlowRateMinC = fanPumpFlowRateMinC;
	}
	public double getAfterDryerSteamMinC() {
		return afterDryerSteamMinC;
	}
	public void setAfterDryerSteamMinC(double afterDryerSteamMinC) {
		this.afterDryerSteamMinC = afterDryerSteamMinC;
	}
	public String getSprLoadingMinC() {
		return sprLoadingMinC;
	}
	public void setSprLoadingMinC(String sprLoadingMinC) {
		this.sprLoadingMinC = sprLoadingMinC;
	}
	public double getFeltPassivatorMinC() {
		return feltPassivatorMinC;
	}
	public void setFeltPassivatorMinC(double feltPassivatorMinC) {
		this.feltPassivatorMinC = feltPassivatorMinC;
	}
	public double getSprayboomPressureMinC() {
		return sprayboomPressureMinC;
	}
	public void setSprayboomPressureMinC(double sprayboomPressureMinC) {
		this.sprayboomPressureMinC = sprayboomPressureMinC;
	}
	public double getSprayboomTemparatureMinC() {
		return sprayboomTemparatureMinC;
	}
	public void setSprayboomTemparatureMinC(double sprayboomTemparatureMinC) {
		this.sprayboomTemparatureMinC = sprayboomTemparatureMinC;
	}
	public double getWefanSpeedMinC() {
		return wefanSpeedMinC;
	}
	public void setWefanSpeedMinC(double wefanSpeedMinC) {
		this.wefanSpeedMinC = wefanSpeedMinC;
	}
	public double getDefanSpeedMinC() {
		return defanSpeedMinC;
	}
	public void setDefanSpeedMinC(double defanSpeedMinC) {
		this.defanSpeedMinC = defanSpeedMinC;
	}
	public double getMakeUpAirDamperMinC() {
		return makeUpAirDamperMinC;
	}
	public void setMakeUpAirDamperMinC(double makeUpAirDamperMinC) {
		this.makeUpAirDamperMinC = makeUpAirDamperMinC;
	}
	public double getExhaustDamperMinC() {
		return exhaustDamperMinC;
	}
	public void setExhaustDamperMinC(double exhaustDamperMinC) {
		this.exhaustDamperMinC = exhaustDamperMinC;
	}
	public double getExhaustFanSpeedMinC() {
		return exhaustFanSpeedMinC;
	}
	public void setExhaustFanSpeedMinC(double exhaustFanSpeedMinC) {
		this.exhaustFanSpeedMinC = exhaustFanSpeedMinC;
	}
	public double getWehoodTemperatureMinC() {
		return wehoodTemperatureMinC;
	}
	public void setWehoodTemperatureMinC(double wehoodTemperatureMinC) {
		this.wehoodTemperatureMinC = wehoodTemperatureMinC;
	}
	public double getDehoodTemperatureMinC() {
		return dehoodTemperatureMinC;
	}
	public void setDehoodTemperatureMinC(double dehoodTemperatureMinC) {
		this.dehoodTemperatureMinC = dehoodTemperatureMinC;
	}
	public double getYankeeAPMinC() {
		return yankeeAPMinC;
	}
	public void setYankeeAPMinC(double yankeeAPMinC) {
		this.yankeeAPMinC = yankeeAPMinC;
	}
	public double getAfterDryerAPMinC() {
		return afterDryerAPMinC;
	}
	public void setAfterDryerAPMinC(double afterDryerAPMinC) {
		this.afterDryerAPMinC = afterDryerAPMinC;
	}
	public double getSecArmLoadingMinC() {
		return secArmLoadingMinC;
	}
	public void setSecArmLoadingMinC(double secArmLoadingMinC) {
		this.secArmLoadingMinC = secArmLoadingMinC;
	}
	public double getReelOffsetMinC() {
		return reelOffsetMinC;
	}
	public void setReelOffsetMinC(double reelOffsetMinC) {
		this.reelOffsetMinC = reelOffsetMinC;
	}
	public double getUhleBoxNorthValveMinC() {
		return uhleBoxNorthValveMinC;
	}
	public void setUhleBoxNorthValveMinC(double uhleBoxNorthValveMinC) {
		this.uhleBoxNorthValveMinC = uhleBoxNorthValveMinC;
	}
	public double getUhleBoxSouthValveMinC() {
		return uhleBoxSouthValveMinC;
	}
	public void setUhleBoxSouthValveMinC(double uhleBoxSouthValveMinC) {
		this.uhleBoxSouthValveMinC = uhleBoxSouthValveMinC;
	}
	public double getFaltBox1VacuumValveMinC() {
		return faltBox1VacuumValveMinC;
	}
	public void setFaltBox1VacuumValveMinC(double faltBox1VacuumValveMinC) {
		this.faltBox1VacuumValveMinC = faltBox1VacuumValveMinC;
	}
	public double getFaltBox2VacuumValveMinC() {
		return faltBox2VacuumValveMinC;
	}
	public void setFaltBox2VacuumValveMinC(double faltBox2VacuumValveMinC) {
		this.faltBox2VacuumValveMinC = faltBox2VacuumValveMinC;
	}
	public double getFaltBox4VacuumValveMinC() {
		return faltBox4VacuumValveMinC;
	}
	public void setFaltBox4VacuumValveMinC(double faltBox4VacuumValveMinC) {
		this.faltBox4VacuumValveMinC = faltBox4VacuumValveMinC;
	}
	public double getFanPumpSpeedMinC() {
		return fanPumpSpeedMinC;
	}
	public void setFanPumpSpeedMinC(double fanPumpSpeedMinC) {
		this.fanPumpSpeedMinC = fanPumpSpeedMinC;
	}
	public double getTotalHeadMinC() {
		return totalHeadMinC;
	}
	public void setTotalHeadMinC(double totalHeadMinC) {
		this.totalHeadMinC = totalHeadMinC;
	}
	public double getHeadboxLevelMinC() {
		return headboxLevelMinC;
	}
	public void setHeadboxLevelMinC(double headboxLevelMinC) {
		this.headboxLevelMinC = headboxLevelMinC;
	}
	public String getHorizontalSliceMinC() {
		return horizontalSliceMinC;
	}
	public void setHorizontalSliceMinC(String horizontalSliceMinC) {
		this.horizontalSliceMinC = horizontalSliceMinC;
	}
	public String getVerticalSliceMinC() {
		return verticalSliceMinC;
	}
	public void setVerticalSliceMinC(String verticalSliceMinC) {
		this.verticalSliceMinC = verticalSliceMinC;
	}
	public double getSelectifierRejectFlow1MinC() {
		return selectifierRejectFlow1MinC;
	}
	public void setSelectifierRejectFlow1MinC(double selectifierRejectFlow1MinC) {
		this.selectifierRejectFlow1MinC = selectifierRejectFlow1MinC;
	}
	public double getSelectifierRejectFlow2MinC() {
		return selectifierRejectFlow2MinC;
	}
	public void setSelectifierRejectFlow2MinC(double selectifierRejectFlow2MinC) {
		this.selectifierRejectFlow2MinC = selectifierRejectFlow2MinC;
	}
	public double getSecScreenCycleTimeMinC() {
		return secScreenCycleTimeMinC;
	}
	public void setSecScreenCycleTimeMinC(double secScreenCycleTimeMinC) {
		this.secScreenCycleTimeMinC = secScreenCycleTimeMinC;
	}
	public double getLowDensityCycleTimeMinC() {
		return lowDensityCycleTimeMinC;
	}
	public void setLowDensityCycleTimeMinC(double lowDensityCycleTimeMinC) {
		this.lowDensityCycleTimeMinC = lowDensityCycleTimeMinC;
	}
	public double getRefinersEnergyMinC() {
		return refinersEnergyMinC;
	}
	public void setRefinersEnergyMinC(double refinersEnergyMinC) {
		this.refinersEnergyMinC = refinersEnergyMinC;
	}
	public double getNumberOfRefinersMinC() {
		return numberOfRefinersMinC;
	}
	public void setNumberOfRefinersMinC(double numberOfRefinersMinC) {
		this.numberOfRefinersMinC = numberOfRefinersMinC;
	}
	public double getRefinerInletConsistencyMinC() {
		return refinerInletConsistencyMinC;
	}
	public void setRefinerInletConsistencyMinC(double refinerInletConsistencyMinC) {
		this.refinerInletConsistencyMinC = refinerInletConsistencyMinC;
	}
	public double getMachineChestConsistencyMinC() {
		return machineChestConsistencyMinC;
	}
	public void setMachineChestConsistencyMinC(double machineChestConsistencyMinC) {
		this.machineChestConsistencyMinC = machineChestConsistencyMinC;
	}
	public double getStockFlowMinC() {
		return stockFlowMinC;
	}
	public void setStockFlowMinC(double stockFlowMinC) {
		this.stockFlowMinC = stockFlowMinC;
	}
	public double getSweetnerFlowMinC() {
		return sweetnerFlowMinC;
	}
	public void setSweetnerFlowMinC(double sweetnerFlowMinC) {
		this.sweetnerFlowMinC = sweetnerFlowMinC;
	}
	public double getBrokeMinC() {
		return brokeMinC;
	}
	public void setBrokeMinC(double brokeMinC) {
		this.brokeMinC = brokeMinC;
	}
	public double getWetStrengthMinC() {
		return wetStrengthMinC;
	}
	public void setWetStrengthMinC(double wetStrengthMinC) {
		this.wetStrengthMinC = wetStrengthMinC;
	}
	public double getYankeeSpeedMaxC() {
		return yankeeSpeedMaxC;
	}
	public void setYankeeSpeedMaxC(double yankeeSpeedMaxC) {
		this.yankeeSpeedMaxC = yankeeSpeedMaxC;
	}

	public double getReelMoistureMaxC() {
		return reelMoistureMaxC;
	}
	public void setReelMoistureMaxC(double reelMoistureMaxC) {
		this.reelMoistureMaxC = reelMoistureMaxC;
	}
	public double getCrepeMaxC() {
		return crepeMaxC;
	}
	public void setCrepeMaxC(double crepeMaxC) {
		this.crepeMaxC = crepeMaxC;
	}
	public double getYankeeSteamMaxC() {
		return yankeeSteamMaxC;
	}
	public void setYankeeSteamMaxC(double yankeeSteamMaxC) {
		this.yankeeSteamMaxC = yankeeSteamMaxC;
	}
	public double getYankeeReleaseMaxC() {
		return yankeeReleaseMaxC;
	}
	public void setYankeeReleaseMaxC(double yankeeReleaseMaxC) {
		this.yankeeReleaseMaxC = yankeeReleaseMaxC;
	}
	public double getYankeeAdesiveMaxC() {
		return yankeeAdesiveMaxC;
	}
	public void setYankeeAdesiveMaxC(double yankeeAdesiveMaxC) {
		this.yankeeAdesiveMaxC = yankeeAdesiveMaxC;
	}
	public double getJetWireRatioMaxC() {
		return jetWireRatioMaxC;
	}
	public void setJetWireRatioMaxC(double jetWireRatioMaxC) {
		this.jetWireRatioMaxC = jetWireRatioMaxC;
	}
	public double getFanPumpFlowRateMaxC() {
		return fanPumpFlowRateMaxC;
	}
	public void setFanPumpFlowRateMaxC(double fanPumpFlowRateMaxC) {
		this.fanPumpFlowRateMaxC = fanPumpFlowRateMaxC;
	}
	public double getAfterDryerSteamMaxC() {
		return afterDryerSteamMaxC;
	}
	public void setAfterDryerSteamMaxC(double afterDryerSteamMaxC) {
		this.afterDryerSteamMaxC = afterDryerSteamMaxC;
	}
	public String getSprLoadingMaxC() {
		return sprLoadingMaxC;
	}
	public void setSprLoadingMaxC(String sprLoadingMaxC) {
		this.sprLoadingMaxC = sprLoadingMaxC;
	}
	public double getFeltPassivatorMaxC() {
		return feltPassivatorMaxC;
	}
	public void setFeltPassivatorMaxC(double feltPassivatorMaxC) {
		this.feltPassivatorMaxC = feltPassivatorMaxC;
	}
	public double getSprayboomPressureMaxC() {
		return sprayboomPressureMaxC;
	}
	public void setSprayboomPressureMaxC(double sprayboomPressureMaxC) {
		this.sprayboomPressureMaxC = sprayboomPressureMaxC;
	}
	public double getSprayboomTemparatureMaxC() {
		return sprayboomTemparatureMaxC;
	}
	public void setSprayboomTemparatureMaxC(double sprayboomTemparatureMaxC) {
		this.sprayboomTemparatureMaxC = sprayboomTemparatureMaxC;
	}
	public double getWefanSpeedMaxC() {
		return wefanSpeedMaxC;
	}
	public void setWefanSpeedMaxC(double wefanSpeedMaxC) {
		this.wefanSpeedMaxC = wefanSpeedMaxC;
	}
	public double getDefanSpeedMaxC() {
		return defanSpeedMaxC;
	}
	public void setDefanSpeedMaxC(double defanSpeedMaxC) {
		this.defanSpeedMaxC = defanSpeedMaxC;
	}
	public double getMakeUpAirDamperMaxC() {
		return makeUpAirDamperMaxC;
	}
	public void setMakeUpAirDamperMaxC(double makeUpAirDamperMaxC) {
		this.makeUpAirDamperMaxC = makeUpAirDamperMaxC;
	}
	public double getExhaustDamperMaxC() {
		return exhaustDamperMaxC;
	}
	public void setExhaustDamperMaxC(double exhaustDamperMaxC) {
		this.exhaustDamperMaxC = exhaustDamperMaxC;
	}
	public double getExhaustFanSpeedMaxC() {
		return exhaustFanSpeedMaxC;
	}
	public void setExhaustFanSpeedMaxC(double exhaustFanSpeedMaxC) {
		this.exhaustFanSpeedMaxC = exhaustFanSpeedMaxC;
	}
	public double getWehoodTemperatureMaxC() {
		return wehoodTemperatureMaxC;
	}
	public void setWehoodTemperatureMaxC(double wehoodTemperatureMaxC) {
		this.wehoodTemperatureMaxC = wehoodTemperatureMaxC;
	}
	public double getDehoodTemperatureMaxC() {
		return dehoodTemperatureMaxC;
	}
	public void setDehoodTemperatureMaxC(double dehoodTemperatureMaxC) {
		this.dehoodTemperatureMaxC = dehoodTemperatureMaxC;
	}
	public double getYankeeAPMaxC() {
		return yankeeAPMaxC;
	}
	public void setYankeeAPMaxC(double yankeeAPMaxC) {
		this.yankeeAPMaxC = yankeeAPMaxC;
	}
	public double getAfterDryerAPMaxC() {
		return afterDryerAPMaxC;
	}
	public void setAfterDryerAPMaxC(double afterDryerAPMaxC) {
		this.afterDryerAPMaxC = afterDryerAPMaxC;
	}
	public double getSecArmLoadingMaxC() {
		return secArmLoadingMaxC;
	}
	public void setSecArmLoadingMaxC(double secArmLoadingMaxC) {
		this.secArmLoadingMaxC = secArmLoadingMaxC;
	}
	public double getReelOffsetMaxC() {
		return reelOffsetMaxC;
	}
	public void setReelOffsetMaxC(double reelOffsetMaxC) {
		this.reelOffsetMaxC = reelOffsetMaxC;
	}
	public double getUhleBoxNorthValveMaxC() {
		return uhleBoxNorthValveMaxC;
	}
	public void setUhleBoxNorthValveMaxC(double uhleBoxNorthValveMaxC) {
		this.uhleBoxNorthValveMaxC = uhleBoxNorthValveMaxC;
	}
	public double getUhleBoxSouthValveMaxC() {
		return uhleBoxSouthValveMaxC;
	}
	public void setUhleBoxSouthValveMaxC(double uhleBoxSouthValveMaxC) {
		this.uhleBoxSouthValveMaxC = uhleBoxSouthValveMaxC;
	}
	public double getFaltBox1VacuumValveMaxC() {
		return faltBox1VacuumValveMaxC;
	}
	public void setFaltBox1VacuumValveMaxC(double faltBox1VacuumValveMaxC) {
		this.faltBox1VacuumValveMaxC = faltBox1VacuumValveMaxC;
	}
	public double getFaltBox2VacuumValveMaxC() {
		return faltBox2VacuumValveMaxC;
	}
	public void setFaltBox2VacuumValveMaxC(double faltBox2VacuumValveMaxC) {
		this.faltBox2VacuumValveMaxC = faltBox2VacuumValveMaxC;
	}
	public double getFaltBox4VacuumValveMaxC() {
		return faltBox4VacuumValveMaxC;
	}
	public void setFaltBox4VacuumValveMaxC(double faltBox4VacuumValveMaxC) {
		this.faltBox4VacuumValveMaxC = faltBox4VacuumValveMaxC;
	}
	public double getFanPumpSpeedMaxC() {
		return fanPumpSpeedMaxC;
	}
	public void setFanPumpSpeedMaxC(double fanPumpSpeedMaxC) {
		this.fanPumpSpeedMaxC = fanPumpSpeedMaxC;
	}
	public double getTotalHeadMaxC() {
		return totalHeadMaxC;
	}
	public void setTotalHeadMaxC(double totalHeadMaxC) {
		this.totalHeadMaxC = totalHeadMaxC;
	}
	public double getHeadboxLevelMaxC() {
		return headboxLevelMaxC;
	}
	public void setHeadboxLevelMaxC(double headboxLevelMaxC) {
		this.headboxLevelMaxC = headboxLevelMaxC;
	}
	public String getHorizontalSliceMaxC() {
		return horizontalSliceMaxC;
	}
	public void setHorizontalSliceMaxC(String horizontalSliceMaxC) {
		this.horizontalSliceMaxC = horizontalSliceMaxC;
	}
	public String getVerticalSliceMaxC() {
		return verticalSliceMaxC;
	}
	public void setVerticalSliceMaxC(String verticalSliceMaxC) {
		this.verticalSliceMaxC = verticalSliceMaxC;
	}
	public double getSelectifierRejectFlow1MaxC() {
		return selectifierRejectFlow1MaxC;
	}
	public void setSelectifierRejectFlow1MaxC(double selectifierRejectFlow1MaxC) {
		this.selectifierRejectFlow1MaxC = selectifierRejectFlow1MaxC;
	}
	public double getSelectifierRejectFlow2MaxC() {
		return selectifierRejectFlow2MaxC;
	}
	public void setSelectifierRejectFlow2MaxC(double selectifierRejectFlow2MaxC) {
		this.selectifierRejectFlow2MaxC = selectifierRejectFlow2MaxC;
	}
	public double getSecScreenCycleTimeMaxC() {
		return secScreenCycleTimeMaxC;
	}
	public void setSecScreenCycleTimeMaxC(double secScreenCycleTimeMaxC) {
		this.secScreenCycleTimeMaxC = secScreenCycleTimeMaxC;
	}
	public double getLowDensityCycleTimeMaxC() {
		return lowDensityCycleTimeMaxC;
	}
	public void setLowDensityCycleTimeMaxC(double lowDensityCycleTimeMaxC) {
		this.lowDensityCycleTimeMaxC = lowDensityCycleTimeMaxC;
	}
	public double getRefinersEnergyMaxC() {
		return refinersEnergyMaxC;
	}
	public void setRefinersEnergyMaxC(double refinersEnergyMaxC) {
		this.refinersEnergyMaxC = refinersEnergyMaxC;
	}
	public double getNumberOfRefinersMaxC() {
		return numberOfRefinersMaxC;
	}
	public void setNumberOfRefinersMaxC(double numberOfRefinersMaxC) {
		this.numberOfRefinersMaxC = numberOfRefinersMaxC;
	}
	public double getRefinerInletConsistencyMaxC() {
		return refinerInletConsistencyMaxC;
	}
	public void setRefinerInletConsistencyMaxC(double refinerInletConsistencyMaxC) {
		this.refinerInletConsistencyMaxC = refinerInletConsistencyMaxC;
	}
	public double getMachineChestConsistencyMaxC() {
		return machineChestConsistencyMaxC;
	}
	public void setMachineChestConsistencyMaxC(double machineChestConsistencyMaxC) {
		this.machineChestConsistencyMaxC = machineChestConsistencyMaxC;
	}
	public double getStockFlowMaxC() {
		return stockFlowMaxC;
	}
	public void setStockFlowMaxC(double stockFlowMaxC) {
		this.stockFlowMaxC = stockFlowMaxC;
	}
	public double getSweetnerFlowMaxC() {
		return sweetnerFlowMaxC;
	}
	public void setSweetnerFlowMaxC(double sweetnerFlowMaxC) {
		this.sweetnerFlowMaxC = sweetnerFlowMaxC;
	}
	public double getBrokeMaxC() {
		return brokeMaxC;
	}
	public void setBrokeMaxC(double brokeMaxC) {
		this.brokeMaxC = brokeMaxC;
	}
	public double getWetStrengthMaxC() {
		return wetStrengthMaxC;
	}
	public void setWetStrengthMaxC(double wetStrengthMaxC) {
		this.wetStrengthMaxC = wetStrengthMaxC;
	}
	public double getQcsBasisWtTarget() {
		return qcsBasisWtTarget;
	}
	public void setQcsBasisWtTarget(double qcsBasisWtTarget) {
		this.qcsBasisWtTarget = qcsBasisWtTarget;
	}
	public double getQcsBasisWtTargetMinC() {
		return qcsBasisWtTargetMinC;
	}
	public void setQcsBasisWtTargetMinC(double qcsBasisWtTargetMinC) {
		this.qcsBasisWtTargetMinC = qcsBasisWtTargetMinC;
	}
	public double getQcsBasisWtTargetMaxC() {
		return qcsBasisWtTargetMaxC;
	}
	public void setQcsBasisWtTargetMaxC(double qcsBasisWtTargetMaxC) {
		this.qcsBasisWtTargetMaxC = qcsBasisWtTargetMaxC;
	}

	
	/**
	 * @return the issueDate
	 */
	public Date getIssueDate() {
		return issueDate;
	}
	/**
	 * @param issueDate the issueDate to set
	 */
	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}
	/**
	 * @return the revision
	 */
	public String getRevision() {
		return revision;
	}
	/**
	 * @param revision the revision to set
	 */
	public void setRevision(String revision) {
		this.revision = revision;
	}
	/**
	 * @return the fissueDate
	 */
	public String getFissueDate() {
		return fissueDate;
	}
	/**
	 * @param fissueDate the fissueDate to set
	 */
	public void setFissueDate(String fissueDate) {
		this.fissueDate = fissueDate;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	public String getHorizontalSliceDcsMinC() {
		return horizontalSliceDcsMinC;
	}
	public void setHorizontalSliceDcsMinC(String horizontalSliceDcsMinC) {
		this.horizontalSliceDcsMinC = horizontalSliceDcsMinC;
	}
	public String getHorizontalSliceDcs() {
		return horizontalSliceDcs;
	}
	public void setHorizontalSliceDcs(String horizontalSliceDcs) {
		this.horizontalSliceDcs = horizontalSliceDcs;
	}
	public String getHorizontalSliceDcsMaxC() {
		return horizontalSliceDcsMaxC;
	}
	public void setHorizontalSliceDcsMaxC(String horizontalSliceDcsMaxC) {
		this.horizontalSliceDcsMaxC = horizontalSliceDcsMaxC;
	}
	public String getVerticalSliceDcsMinC() {
		return verticalSliceDcsMinC;
	}
	public void setVerticalSliceDcsMinC(String verticalSliceDcsMinC) {
		this.verticalSliceDcsMinC = verticalSliceDcsMinC;
	}
	public String getVerticalSliceDcs() {
		return verticalSliceDcs;
	}
	public void setVerticalSliceDcs(String verticalSliceDcs) {
		this.verticalSliceDcs = verticalSliceDcs;
	}
	public String getVerticalSliceDcsMaxC() {
		return verticalSliceDcsMaxC;
	}
	public void setVerticalSliceDcsMaxC(String verticalSliceDcsMaxC) {
		this.verticalSliceDcsMaxC = verticalSliceDcsMaxC;
	}
	/**
	 * @return the afterDryerDrawMinC
	 */
	public double getAfterDryerDrawMinC() {
		return afterDryerDrawMinC;
	}
	/**
	 * @param afterDryerDrawMinC the afterDryerDrawMinC to set
	 */
	public void setAfterDryerDrawMinC(double afterDryerDrawMinC) {
		this.afterDryerDrawMinC = afterDryerDrawMinC;
	}
	/**
	 * @return the afterDryerDraw
	 */
	public double getAfterDryerDraw() {
		return afterDryerDraw;
	}
	/**
	 * @param afterDryerDraw the afterDryerDraw to set
	 */
	public void setAfterDryerDraw(double afterDryerDraw) {
		this.afterDryerDraw = afterDryerDraw;
	}
	/**
	 * @return the afterDryerDrawMaxC
	 */
	public double getAfterDryerDrawMaxC() {
		return afterDryerDrawMaxC;
	}
	/**
	 * @param afterDryerDrawMaxC the afterDryerDrawMaxC to set
	 */
	public void setAfterDryerDrawMaxC(double afterDryerDrawMaxC) {
		this.afterDryerDrawMaxC = afterDryerDrawMaxC;
	}
	public Date getRltDate() {
		return rltDate;
	}
	public void setRltDate(Date rltDate) {
		this.rltDate = rltDate;
	}
	public double getSprloadingfrontMinC() {
		return sprloadingfrontMinC;
	}
	public void setSprloadingfrontMinC(double sprloadingfrontMinC) {
		this.sprloadingfrontMinC = sprloadingfrontMinC;
	}
	public double getSprloadingfront() {
		return sprloadingfront;
	}
	public void setSprloadingfront(double sprloadingfront) {
		this.sprloadingfront = sprloadingfront;
	}
	public double getSprloadingfrontMaxC() {
		return sprloadingfrontMaxC;
	}
	public void setSprloadingfrontMaxC(double sprloadingfrontMaxC) {
		this.sprloadingfrontMaxC = sprloadingfrontMaxC;
	}
	public double getSprloadingbackMinC() {
		return sprloadingbackMinC;
	}
	public void setSprloadingbackMinC(double sprloadingbackMinC) {
		this.sprloadingbackMinC = sprloadingbackMinC;
	}
	public double getSprloadingback() {
		return sprloadingback;
	}
	public void setSprloadingback(double sprloadingback) {
		this.sprloadingback = sprloadingback;
	}
	public double getSprloadingbackMaxC() {
		return sprloadingbackMaxC;
	}
	public void setSprloadingbackMaxC(double sprloadingbackMaxC) {
		this.sprloadingbackMaxC = sprloadingbackMaxC;
	}
	public double getPickuprollvacuumMinC() {
		return pickuprollvacuumMinC;
	}
	public void setPickuprollvacuumMinC(double pickuprollvacuumMinC) {
		this.pickuprollvacuumMinC = pickuprollvacuumMinC;
	}
	public double getPickuprollvacuum() {
		return pickuprollvacuum;
	}
	public void setPickuprollvacuum(double pickuprollvacuum) {
		this.pickuprollvacuum = pickuprollvacuum;
	}
	public double getPickuprollvacuumMaxC() {
		return pickuprollvacuumMaxC;
	}
	public void setPickuprollvacuumMaxC(double pickuprollvacuumMaxC) {
		this.pickuprollvacuumMaxC = pickuprollvacuumMaxC;
	}
	public double getUhleboxvacuumMinC() {
		return uhleboxvacuumMinC;
	}
	public void setUhleboxvacuumMinC(double uhleboxvacuumMinC) {
		this.uhleboxvacuumMinC = uhleboxvacuumMinC;
	}
	public double getUhleboxvacuum() {
		return uhleboxvacuum;
	}
	public void setUhleboxvacuum(double uhleboxvacuum) {
		this.uhleboxvacuum = uhleboxvacuum;
	}
	public double getUhleboxvacuumMaxC() {
		return uhleboxvacuumMaxC;
	}
	public void setUhleboxvacuumMaxC(double uhleboxvacuumMaxC) {
		this.uhleboxvacuumMaxC = uhleboxvacuumMaxC;
	}
	public double getSprvacuumMinC() {
		return sprvacuumMinC;
	}
	public void setSprvacuumMinC(double sprvacuumMinC) {
		this.sprvacuumMinC = sprvacuumMinC;
	}
	public double getSprvacuum() {
		return sprvacuum;
	}
	public void setSprvacuum(double sprvacuum) {
		this.sprvacuum = sprvacuum;
	}
	public double getSprvacuumMaxC() {
		return sprvacuumMaxC;
	}
	public void setSprvacuumMaxC(double sprvacuumMaxC) {
		this.sprvacuumMaxC = sprvacuumMaxC;
	}
	public double getPrimaryscreenrejectflowMinC() {
		return primaryscreenrejectflowMinC;
	}
	public void setPrimaryscreenrejectflowMinC(double primaryscreenrejectflowMinC) {
		this.primaryscreenrejectflowMinC = primaryscreenrejectflowMinC;
	}
	public double getPrimaryscreenrejectflow() {
		return primaryscreenrejectflow;
	}
	public void setPrimaryscreenrejectflow(double primaryscreenrejectflow) {
		this.primaryscreenrejectflow = primaryscreenrejectflow;
	}
	public double getPrimaryscreenrejectflowMaxC() {
		return primaryscreenrejectflowMaxC;
	}
	public void setPrimaryscreenrejectflowMaxC(double primaryscreenrejectflowMaxC) {
		this.primaryscreenrejectflowMaxC = primaryscreenrejectflowMaxC;
	}
	public double getBlendchestcyMinC() {
		return blendchestcyMinC;
	}
	public void setBlendchestcyMinC(double blendchestcyMinC) {
		this.blendchestcyMinC = blendchestcyMinC;
	}
	public double getBlendchestcy() {
		return blendchestcy;
	}
	public void setBlendchestcy(double blendchestcy) {
		this.blendchestcy = blendchestcy;
	}
	public double getBlendchestcyMaxC() {
		return blendchestcyMaxC;
	}
	public void setBlendchestcyMaxC(double blendchestcyMaxC) {
		this.blendchestcyMaxC = blendchestcyMaxC;
	}
	public double getRefiner1powerMinC() {
		return refiner1powerMinC;
	}
	public void setRefiner1powerMinC(double refiner1powerMinC) {
		this.refiner1powerMinC = refiner1powerMinC;
	}
	public double getRefiner1power() {
		return refiner1power;
	}
	public void setRefiner1power(double refiner1power) {
		this.refiner1power = refiner1power;
	}
	public double getRefiner1powerMaxC() {
		return refiner1powerMaxC;
	}
	public void setRefiner1powerMaxC(double refiner1powerMaxC) {
		this.refiner1powerMaxC = refiner1powerMaxC;
	}
	public double getRefiner2powerMinC() {
		return refiner2powerMinC;
	}
	public void setRefiner2powerMinC(double refiner2powerMinC) {
		this.refiner2powerMinC = refiner2powerMinC;
	}
	public double getRefiner2power() {
		return refiner2power;
	}
	public void setRefiner2power(double refiner2power) {
		this.refiner2power = refiner2power;
	}
	public double getRefiner2powerMaxC() {
		return refiner2powerMaxC;
	}
	public void setRefiner2powerMaxC(double refiner2powerMaxC) {
		this.refiner2powerMaxC = refiner2powerMaxC;
	}
	public double getRefiner1inletcyMinC() {
		return refiner1inletcyMinC;
	}
	public void setRefiner1inletcyMinC(double refiner1inletcyMinC) {
		this.refiner1inletcyMinC = refiner1inletcyMinC;
	}
	public double getRefiner1inletcy() {
		return refiner1inletcy;
	}
	public void setRefiner1inletcy(double refiner1inletcy) {
		this.refiner1inletcy = refiner1inletcy;
	}
	public double getRefiner1inletcyMaxC() {
		return refiner1inletcyMaxC;
	}
	public void setRefiner1inletcyMaxC(double refiner1inletcyMaxC) {
		this.refiner1inletcyMaxC = refiner1inletcyMaxC;
	}
	public double getRefiner2inletcyMinC() {
		return refiner2inletcyMinC;
	}
	public void setRefiner2inletcyMinC(double refiner2inletcyMinC) {
		this.refiner2inletcyMinC = refiner2inletcyMinC;
	}
	public double getRefiner2inletcy() {
		return refiner2inletcy;
	}
	public void setRefiner2inletcy(double refiner2inletcy) {
		this.refiner2inletcy = refiner2inletcy;
	}
	public double getRefiner2inletcyMaxC() {
		return refiner2inletcyMaxC;
	}
	public void setRefiner2inletcyMaxC(double refiner2inletcyMaxC) {
		this.refiner2inletcyMaxC = refiner2inletcyMaxC;
	}
	public double getBasisweighttargetMinC() {
		return basisweighttargetMinC;
	}
	public void setBasisweighttargetMinC(double basisweighttargetMinC) {
		this.basisweighttargetMinC = basisweighttargetMinC;
	}
	public double getBasisweighttarget() {
		return basisweighttarget;
	}
	public void setBasisweighttarget(double basisweighttarget) {
		this.basisweighttarget = basisweighttarget;
	}
	public double getBasisweighttargetMaxC() {
		return basisweighttargetMaxC;
	}
	public void setBasisweighttargetMaxC(double basisweighttargetMaxC) {
		this.basisweighttargetMaxC = basisweighttargetMaxC;
	}
	public double getMoisturetargetMinC() {
		return moisturetargetMinC;
	}
	public void setMoisturetargetMinC(double moisturetargetMinC) {
		this.moisturetargetMinC = moisturetargetMinC;
	}
	public double getMoisturetarget() {
		return moisturetarget;
	}
	public void setMoisturetarget(double moisturetarget) {
		this.moisturetarget = moisturetarget;
	}
	public double getMoisturetargetMaxC() {
		return moisturetargetMaxC;
	}
	public void setMoisturetargetMaxC(double moisturetargetMaxC) {
		this.moisturetargetMaxC = moisturetargetMaxC;
	}
	public double getYankeemapflowMinC() {
		return yankeemapflowMinC;
	}
	public void setYankeemapflowMinC(double yankeemapflowMinC) {
		this.yankeemapflowMinC = yankeemapflowMinC;
	}
	public double getYankeemapflow() {
		return yankeemapflow;
	}
	public void setYankeemapflow(double yankeemapflow) {
		this.yankeemapflow = yankeemapflow;
	}
	public double getYankeemapflowMaxC() {
		return yankeemapflowMaxC;
	}
	public void setYankeemapflowMaxC(double yankeemapflowMaxC) {
		this.yankeemapflowMaxC = yankeemapflowMaxC;
	}
	public double getMachinechestpumpspeedMinC() {
		return machinechestpumpspeedMinC;
	}
	public void setMachinechestpumpspeedMinC(double machinechestpumpspeedMinC) {
		this.machinechestpumpspeedMinC = machinechestpumpspeedMinC;
	}
	public double getMachinechestpumpspeed() {
		return machinechestpumpspeed;
	}
	public void setMachinechestpumpspeed(double machinechestpumpspeed) {
		this.machinechestpumpspeed = machinechestpumpspeed;
	}
	public double getMachinechestpumpspeedMaxC() {
		return machinechestpumpspeedMaxC;
	}
	public void setMachinechestpumpspeedMaxC(double machinechestpumpspeedMaxC) {
		this.machinechestpumpspeedMaxC = machinechestpumpspeedMaxC;
	}
	}

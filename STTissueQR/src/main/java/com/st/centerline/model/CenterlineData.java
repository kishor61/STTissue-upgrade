package com.st.centerline.model;

import java.util.Date;

public class CenterlineData {
	
	private int id;
	private int gradeId;
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
	private Date date;
	private Date issueDate;
	private String revision;
	private String noteSecA;
	private String noteSecB;
	
	
	//New Field
	private double afterDryerDraw;
	private String horizontalSliceDcs;
	private String verticalSliceDcs;
	
	//
	private String fdate;
	private String fissueDate;
	
	//New Field RLT
	private double sprloadingfront;
	private double sprloadingback;
	private double pickuprollvacuum;
	private double uhleboxvacuum;
	private double sprvacuum;
	private double primaryscreenrejectflow;
	private double blendchestcy;
	private double refiner1power;
	private double refiner2power;
	private double refiner1inletcy;
	private double refiner2inletcy;
	
	private double basisweighttarget;
	private double moisturetarget;
	private double yankeemapflow;
	private double machinechestpumpspeed;
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public double getQcsBasisWtTarget() {
		return qcsBasisWtTarget;
	}

	public void setQcsBasisWtTarget(double qcsBasisWtTarget) {
		this.qcsBasisWtTarget = qcsBasisWtTarget;
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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Date getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}

	public String getRevision() {
		return revision;
	}

	public void setRevision(String revision) {
		this.revision = revision;
	}

	public String getNoteSecA() {
		return noteSecA;
	}

	public void setNoteSecA(String noteSecA) {
		this.noteSecA = noteSecA;
	}

	public String getNoteSecB() {
		return noteSecB;
	}

	public void setNoteSecB(String noteSecB) {
		this.noteSecB = noteSecB;
	}

	public String getFdate() {
		return fdate;
	}

	public void setFdate(String fdate) {
		this.fdate = fdate;
	}

	public String getFissueDate() {
		return fissueDate;
	}

	public void setFissueDate(String fissueDate) {
		this.fissueDate = fissueDate;
	}

	/**
	 * @return the gradeId
	 */
	public int getGradeId() {
		return gradeId;
	}

	/**
	 * @param gradeId the gradeId to set
	 */
	public void setGradeId(int gradeId) {
		this.gradeId = gradeId;
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
	 * @return the horizontalSliceDcs
	 */
	public String getHorizontalSliceDcs() {
		return horizontalSliceDcs;
	}

	/**
	 * @param horizontalSliceDcs the horizontalSliceDcs to set
	 */
	public void setHorizontalSliceDcs(String horizontalSliceDcs) {
		this.horizontalSliceDcs = horizontalSliceDcs;
	}

	/**
	 * @return the verticalSliceDcs
	 */
	public String getVerticalSliceDcs() {
		return verticalSliceDcs;
	}

	/**
	 * @param verticalSliceDcs the verticalSliceDcs to set
	 */
	public void setVerticalSliceDcs(String verticalSliceDcs) {
		this.verticalSliceDcs = verticalSliceDcs;
	}

	public double getSprloadingfront() {
		return sprloadingfront;
	}

	public void setSprloadingfront(double sprloadingfront) {
		this.sprloadingfront = sprloadingfront;
	}

	public double getSprloadingback() {
		return sprloadingback;
	}

	public void setSprloadingback(double sprloadingback) {
		this.sprloadingback = sprloadingback;
	}

	public double getPickuprollvacuum() {
		return pickuprollvacuum;
	}

	public void setPickuprollvacuum(double pickuprollvacuum) {
		this.pickuprollvacuum = pickuprollvacuum;
	}

	public double getUhleboxvacuum() {
		return uhleboxvacuum;
	}

	public void setUhleboxvacuum(double uhleboxvacuum) {
		this.uhleboxvacuum = uhleboxvacuum;
	}

	public double getSprvacuum() {
		return sprvacuum;
	}

	public void setSprvacuum(double sprvacuum) {
		this.sprvacuum = sprvacuum;
	}

	public double getPrimaryscreenrejectflow() {
		return primaryscreenrejectflow;
	}

	public void setPrimaryscreenrejectflow(double primaryscreenrejectflow) {
		this.primaryscreenrejectflow = primaryscreenrejectflow;
	}

	public double getBlendchestcy() {
		return blendchestcy;
	}

	public void setBlendchestcy(double blendchestcy) {
		this.blendchestcy = blendchestcy;
	}

	public double getRefiner1power() {
		return refiner1power;
	}

	public void setRefiner1power(double refiner1power) {
		this.refiner1power = refiner1power;
	}

	public double getRefiner2power() {
		return refiner2power;
	}

	public void setRefiner2power(double refiner2power) {
		this.refiner2power = refiner2power;
	}

	public double getRefiner1inletcy() {
		return refiner1inletcy;
	}

	public void setRefiner1inletcy(double refiner1inletcy) {
		this.refiner1inletcy = refiner1inletcy;
	}

	public double getRefiner2inletcy() {
		return refiner2inletcy;
	}

	public void setRefiner2inletcy(double refiner2inletcy) {
		this.refiner2inletcy = refiner2inletcy;
	}

	public double getBasisweighttarget() {
		return basisweighttarget;
	}

	public void setBasisweighttarget(double basisweighttarget) {
		this.basisweighttarget = basisweighttarget;
	}

	public double getMoisturetarget() {
		return moisturetarget;
	}

	public void setMoisturetarget(double moisturetarget) {
		this.moisturetarget = moisturetarget;
	}

	public double getYankeemapflow() {
		return yankeemapflow;
	}

	public void setYankeemapflow(double yankeemapflow) {
		this.yankeemapflow = yankeemapflow;
	}

	public double getMachinechestpumpspeed() {
		return machinechestpumpspeed;
	}

	public void setMachinechestpumpspeed(double machinechestpumpspeed) {
		this.machinechestpumpspeed = machinechestpumpspeed;
	}



}

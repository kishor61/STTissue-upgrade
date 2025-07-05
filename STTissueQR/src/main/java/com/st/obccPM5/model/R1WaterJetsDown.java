/**
 *Oct 21, 2019
 *R1OperatorPM5.java
 * TODO
 *com.st.obccPM5.model
 *R1OperatorPM5.java
 *Roshan Lal Tailor
 */
package com.st.obccPM5.model;

/**
 * @author sohan
 *
 */
public class R1WaterJetsDown {
	
	private int id;
	private String position;
	private String operatorName;
	private String edate;
	private String crew;
	private String shift;
	private boolean machinedown;
	
	
	private boolean extractorTabeLevel;
	private boolean allRollersInWorkingCondition;
	private boolean anyAbnormalSounds;
	private boolean hydralicMotorIssues;
	private boolean anyHydralicLeaks;
	private boolean sensorsAndLimitSwitchesWorking;
	private boolean chainAndSprocketsAllOk;
	private boolean wetAndCraneWorking;
	private boolean allHookesworking;
	
	private boolean waterPressure;
	private String pumpControlStationInUse;
	private String pumpControlStationInUse2;
	private boolean anyTableMovementIssue;
	private String frontAndBackTableScrewOk;
	private String frontAndBackTableScrewOk2;
	private boolean tableAndLiftScrewsBlownDown;
	private boolean anyTrimShootIssues;
	private boolean tableDrainClean;
	private boolean flueshLinesClean;
	private boolean checkCoolingWater;
	private boolean allPanelLightsWorking;
	private boolean airShaftsHolding;
	private boolean anyBreakingIssues;
	
	private String extractorTabeLevelDesc;
	private String allRollersInWorkingConditionDesc;
	private String anyAbnormalSoundsDesc;
	private String hydralicMotorIssuesDesc;
	private String anyHydralicLeaksDesc;
	private String sensorsAndLimitSwitchesWorkingDesc;
	private String chainAndSprocketsAllOkDesc;
	private String wetAndCraneWorkingDesc;
	private String allHookesworkingDesc;
	
	private String waterPressureDesc;
	private String pumpControlStationInUseDesc;
	private String anyTableMovementIssueDesc;
	private String frontAndBackTableScrewOkDesc;
	private String tableAndLiftScrewsBlownDownDesc;
	private String anyTrimShootIssuesDesc;
	private String tableDrainCleanDesc;
	private String flueshLinesCleanDesc;
	private String checkCoolingWaterDesc;
	private String allPanelLightsWorkingDesc;
	private String airShaftsHoldingDesc;
	private String anyBreakingIssuesDesc;
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
	/**
	 * @return the position
	 */
	public String getPosition() {
		return position;
	}
	/**
	 * @param position the position to set
	 */
	public void setPosition(String position) {
		this.position = position;
	}
	/**
	 * @return the operatorName
	 */
	public String getOperatorName() {
		return operatorName;
	}
	/**
	 * @param operatorName the operatorName to set
	 */
	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}
	/**
	 * @return the edate
	 */
	public String getEdate() {
		return edate;
	}
	/**
	 * @param edate the edate to set
	 */
	public void setEdate(String edate) {
		this.edate = edate;
	}
	/**
	 * @return the crew
	 */
	public String getCrew() {
		return crew;
	}
	/**
	 * @param crew the crew to set
	 */
	public void setCrew(String crew) {
		this.crew = crew;
	}
	/**
	 * @return the shift
	 */
	public String getShift() {
		return shift;
	}
	/**
	 * @param shift the shift to set
	 */
	public void setShift(String shift) {
		this.shift = shift;
	}
	/**
	 * @return the machinedown
	 */
	public boolean isMachinedown() {
		return machinedown;
	}
	/**
	 * @param machinedown the machinedown to set
	 */
	public void setMachinedown(boolean machinedown) {
		this.machinedown = machinedown;
	}
	/**
	 * @return the extractorTabeLevel
	 */
	public boolean isExtractorTabeLevel() {
		return extractorTabeLevel;
	}
	/**
	 * @param extractorTabeLevel the extractorTabeLevel to set
	 */
	public void setExtractorTabeLevel(boolean extractorTabeLevel) {
		this.extractorTabeLevel = extractorTabeLevel;
	}
	/**
	 * @return the allRollersInWorkingCondition
	 */
	public boolean isAllRollersInWorkingCondition() {
		return allRollersInWorkingCondition;
	}
	/**
	 * @param allRollersInWorkingCondition the allRollersInWorkingCondition to set
	 */
	public void setAllRollersInWorkingCondition(boolean allRollersInWorkingCondition) {
		this.allRollersInWorkingCondition = allRollersInWorkingCondition;
	}
	/**
	 * @return the anyAbnormalSounds
	 */
	public boolean isAnyAbnormalSounds() {
		return anyAbnormalSounds;
	}
	/**
	 * @param anyAbnormalSounds the anyAbnormalSounds to set
	 */
	public void setAnyAbnormalSounds(boolean anyAbnormalSounds) {
		this.anyAbnormalSounds = anyAbnormalSounds;
	}
	/**
	 * @return the hydralicMotorIssues
	 */
	public boolean isHydralicMotorIssues() {
		return hydralicMotorIssues;
	}
	/**
	 * @param hydralicMotorIssues the hydralicMotorIssues to set
	 */
	public void setHydralicMotorIssues(boolean hydralicMotorIssues) {
		this.hydralicMotorIssues = hydralicMotorIssues;
	}
	/**
	 * @return the anyHydralicLeaks
	 */
	public boolean isAnyHydralicLeaks() {
		return anyHydralicLeaks;
	}
	/**
	 * @param anyHydralicLeaks the anyHydralicLeaks to set
	 */
	public void setAnyHydralicLeaks(boolean anyHydralicLeaks) {
		this.anyHydralicLeaks = anyHydralicLeaks;
	}
	/**
	 * @return the sensorsAndLimitSwitchesWorking
	 */
	public boolean isSensorsAndLimitSwitchesWorking() {
		return sensorsAndLimitSwitchesWorking;
	}
	/**
	 * @param sensorsAndLimitSwitchesWorking the sensorsAndLimitSwitchesWorking to set
	 */
	public void setSensorsAndLimitSwitchesWorking(boolean sensorsAndLimitSwitchesWorking) {
		this.sensorsAndLimitSwitchesWorking = sensorsAndLimitSwitchesWorking;
	}
	/**
	 * @return the chainAndSprocketsAllOk
	 */
	public boolean isChainAndSprocketsAllOk() {
		return chainAndSprocketsAllOk;
	}
	/**
	 * @param chainAndSprocketsAllOk the chainAndSprocketsAllOk to set
	 */
	public void setChainAndSprocketsAllOk(boolean chainAndSprocketsAllOk) {
		this.chainAndSprocketsAllOk = chainAndSprocketsAllOk;
	}
	/**
	 * @return the wetAndCraneWorking
	 */
	public boolean isWetAndCraneWorking() {
		return wetAndCraneWorking;
	}
	/**
	 * @param wetAndCraneWorking the wetAndCraneWorking to set
	 */
	public void setWetAndCraneWorking(boolean wetAndCraneWorking) {
		this.wetAndCraneWorking = wetAndCraneWorking;
	}
	/**
	 * @return the allHookesworking
	 */
	public boolean isAllHookesworking() {
		return allHookesworking;
	}
	/**
	 * @param allHookesworking the allHookesworking to set
	 */
	public void setAllHookesworking(boolean allHookesworking) {
		this.allHookesworking = allHookesworking;
	}
	/**
	 * @return the waterPressure
	 */
	public boolean isWaterPressure() {
		return waterPressure;
	}
	/**
	 * @param waterPressure the waterPressure to set
	 */
	public void setWaterPressure(boolean waterPressure) {
		this.waterPressure = waterPressure;
	}
	/**
	 * @return the anyTableMovementIssue
	 */
	public boolean isAnyTableMovementIssue() {
		return anyTableMovementIssue;
	}
	/**
	 * @param anyTableMovementIssue the anyTableMovementIssue to set
	 */
	public void setAnyTableMovementIssue(boolean anyTableMovementIssue) {
		this.anyTableMovementIssue = anyTableMovementIssue;
	}
	
	/**
	 * @return the pumpControlStationInUse
	 */
	public String getPumpControlStationInUse() {
		return pumpControlStationInUse;
	}
	/**
	 * @param pumpControlStationInUse the pumpControlStationInUse to set
	 */
	public void setPumpControlStationInUse(String pumpControlStationInUse) {
		this.pumpControlStationInUse = pumpControlStationInUse;
	}
	/**
	 * @return the pumpControlStationInUse2
	 */
	public String getPumpControlStationInUse2() {
		return pumpControlStationInUse2;
	}
	/**
	 * @param pumpControlStationInUse2 the pumpControlStationInUse2 to set
	 */
	public void setPumpControlStationInUse2(String pumpControlStationInUse2) {
		this.pumpControlStationInUse2 = pumpControlStationInUse2;
	}
	/**
	 * @return the frontAndBackTableScrewOk
	 */
	public String getFrontAndBackTableScrewOk() {
		return frontAndBackTableScrewOk;
	}
	/**
	 * @param frontAndBackTableScrewOk the frontAndBackTableScrewOk to set
	 */
	public void setFrontAndBackTableScrewOk(String frontAndBackTableScrewOk) {
		this.frontAndBackTableScrewOk = frontAndBackTableScrewOk;
	}
	/**
	 * @return the frontAndBackTableScrewOk2
	 */
	public String getFrontAndBackTableScrewOk2() {
		return frontAndBackTableScrewOk2;
	}
	/**
	 * @param frontAndBackTableScrewOk2 the frontAndBackTableScrewOk2 to set
	 */
	public void setFrontAndBackTableScrewOk2(String frontAndBackTableScrewOk2) {
		this.frontAndBackTableScrewOk2 = frontAndBackTableScrewOk2;
	}
	/**
	 * @return the tableAndLiftScrewsBlownDown
	 */
	public boolean isTableAndLiftScrewsBlownDown() {
		return tableAndLiftScrewsBlownDown;
	}
	/**
	 * @param tableAndLiftScrewsBlownDown the tableAndLiftScrewsBlownDown to set
	 */
	public void setTableAndLiftScrewsBlownDown(boolean tableAndLiftScrewsBlownDown) {
		this.tableAndLiftScrewsBlownDown = tableAndLiftScrewsBlownDown;
	}
	/**
	 * @return the anyTrimShootIssues
	 */
	public boolean isAnyTrimShootIssues() {
		return anyTrimShootIssues;
	}
	/**
	 * @param anyTrimShootIssues the anyTrimShootIssues to set
	 */
	public void setAnyTrimShootIssues(boolean anyTrimShootIssues) {
		this.anyTrimShootIssues = anyTrimShootIssues;
	}
	/**
	 * @return the tableDrainClean
	 */
	public boolean isTableDrainClean() {
		return tableDrainClean;
	}
	/**
	 * @param tableDrainClean the tableDrainClean to set
	 */
	public void setTableDrainClean(boolean tableDrainClean) {
		this.tableDrainClean = tableDrainClean;
	}
	/**
	 * @return the flueshLinesClean
	 */
	public boolean isFlueshLinesClean() {
		return flueshLinesClean;
	}
	/**
	 * @param flueshLinesClean the flueshLinesClean to set
	 */
	public void setFlueshLinesClean(boolean flueshLinesClean) {
		this.flueshLinesClean = flueshLinesClean;
	}
	/**
	 * @return the checkCoolingWater
	 */
	public boolean isCheckCoolingWater() {
		return checkCoolingWater;
	}
	/**
	 * @param checkCoolingWater the checkCoolingWater to set
	 */
	public void setCheckCoolingWater(boolean checkCoolingWater) {
		this.checkCoolingWater = checkCoolingWater;
	}
	/**
	 * @return the allPanelLightsWorking
	 */
	public boolean isAllPanelLightsWorking() {
		return allPanelLightsWorking;
	}
	/**
	 * @param allPanelLightsWorking the allPanelLightsWorking to set
	 */
	public void setAllPanelLightsWorking(boolean allPanelLightsWorking) {
		this.allPanelLightsWorking = allPanelLightsWorking;
	}
	/**
	 * @return the airShaftsHolding
	 */
	public boolean isAirShaftsHolding() {
		return airShaftsHolding;
	}
	/**
	 * @param airShaftsHolding the airShaftsHolding to set
	 */
	public void setAirShaftsHolding(boolean airShaftsHolding) {
		this.airShaftsHolding = airShaftsHolding;
	}
	/**
	 * @return the anyBreakingIssues
	 */
	public boolean isAnyBreakingIssues() {
		return anyBreakingIssues;
	}
	/**
	 * @param anyBreakingIssues the anyBreakingIssues to set
	 */
	public void setAnyBreakingIssues(boolean anyBreakingIssues) {
		this.anyBreakingIssues = anyBreakingIssues;
	}
	/**
	 * @return the extractorTabeLevelDesc
	 */
	public String getExtractorTabeLevelDesc() {
		return extractorTabeLevelDesc;
	}
	/**
	 * @param extractorTabeLevelDesc the extractorTabeLevelDesc to set
	 */
	public void setExtractorTabeLevelDesc(String extractorTabeLevelDesc) {
		this.extractorTabeLevelDesc = extractorTabeLevelDesc;
	}
	/**
	 * @return the allRollersInWorkingConditionDesc
	 */
	public String getAllRollersInWorkingConditionDesc() {
		return allRollersInWorkingConditionDesc;
	}
	/**
	 * @param allRollersInWorkingConditionDesc the allRollersInWorkingConditionDesc to set
	 */
	public void setAllRollersInWorkingConditionDesc(String allRollersInWorkingConditionDesc) {
		this.allRollersInWorkingConditionDesc = allRollersInWorkingConditionDesc;
	}
	/**
	 * @return the anyAbnormalSoundsDesc
	 */
	public String getAnyAbnormalSoundsDesc() {
		return anyAbnormalSoundsDesc;
	}
	/**
	 * @param anyAbnormalSoundsDesc the anyAbnormalSoundsDesc to set
	 */
	public void setAnyAbnormalSoundsDesc(String anyAbnormalSoundsDesc) {
		this.anyAbnormalSoundsDesc = anyAbnormalSoundsDesc;
	}
	/**
	 * @return the hydralicMotorIssuesDesc
	 */
	public String getHydralicMotorIssuesDesc() {
		return hydralicMotorIssuesDesc;
	}
	/**
	 * @param hydralicMotorIssuesDesc the hydralicMotorIssuesDesc to set
	 */
	public void setHydralicMotorIssuesDesc(String hydralicMotorIssuesDesc) {
		this.hydralicMotorIssuesDesc = hydralicMotorIssuesDesc;
	}
	/**
	 * @return the anyHydralicLeaksDesc
	 */
	public String getAnyHydralicLeaksDesc() {
		return anyHydralicLeaksDesc;
	}
	/**
	 * @param anyHydralicLeaksDesc the anyHydralicLeaksDesc to set
	 */
	public void setAnyHydralicLeaksDesc(String anyHydralicLeaksDesc) {
		this.anyHydralicLeaksDesc = anyHydralicLeaksDesc;
	}
	/**
	 * @return the sensorsAndLimitSwitchesWorkingDesc
	 */
	public String getSensorsAndLimitSwitchesWorkingDesc() {
		return sensorsAndLimitSwitchesWorkingDesc;
	}
	/**
	 * @param sensorsAndLimitSwitchesWorkingDesc the sensorsAndLimitSwitchesWorkingDesc to set
	 */
	public void setSensorsAndLimitSwitchesWorkingDesc(String sensorsAndLimitSwitchesWorkingDesc) {
		this.sensorsAndLimitSwitchesWorkingDesc = sensorsAndLimitSwitchesWorkingDesc;
	}
	/**
	 * @return the chainAndSprocketsAllOkDesc
	 */
	public String getChainAndSprocketsAllOkDesc() {
		return chainAndSprocketsAllOkDesc;
	}
	/**
	 * @param chainAndSprocketsAllOkDesc the chainAndSprocketsAllOkDesc to set
	 */
	public void setChainAndSprocketsAllOkDesc(String chainAndSprocketsAllOkDesc) {
		this.chainAndSprocketsAllOkDesc = chainAndSprocketsAllOkDesc;
	}
	/**
	 * @return the wetAndCraneWorkingDesc
	 */
	public String getWetAndCraneWorkingDesc() {
		return wetAndCraneWorkingDesc;
	}
	/**
	 * @param wetAndCraneWorkingDesc the wetAndCraneWorkingDesc to set
	 */
	public void setWetAndCraneWorkingDesc(String wetAndCraneWorkingDesc) {
		this.wetAndCraneWorkingDesc = wetAndCraneWorkingDesc;
	}
	/**
	 * @return the allHookesworkingDesc
	 */
	public String getAllHookesworkingDesc() {
		return allHookesworkingDesc;
	}
	/**
	 * @param allHookesworkingDesc the allHookesworkingDesc to set
	 */
	public void setAllHookesworkingDesc(String allHookesworkingDesc) {
		this.allHookesworkingDesc = allHookesworkingDesc;
	}
	/**
	 * @return the waterPressureDesc
	 */
	public String getWaterPressureDesc() {
		return waterPressureDesc;
	}
	/**
	 * @param waterPressureDesc the waterPressureDesc to set
	 */
	public void setWaterPressureDesc(String waterPressureDesc) {
		this.waterPressureDesc = waterPressureDesc;
	}
	/**
	 * @return the pumpControlStationInUseDesc
	 */
	public String getPumpControlStationInUseDesc() {
		return pumpControlStationInUseDesc;
	}
	/**
	 * @param pumpControlStationInUseDesc the pumpControlStationInUseDesc to set
	 */
	public void setPumpControlStationInUseDesc(String pumpControlStationInUseDesc) {
		this.pumpControlStationInUseDesc = pumpControlStationInUseDesc;
	}
	/**
	 * @return the anyTableMovementIssueDesc
	 */
	public String getAnyTableMovementIssueDesc() {
		return anyTableMovementIssueDesc;
	}
	/**
	 * @param anyTableMovementIssueDesc the anyTableMovementIssueDesc to set
	 */
	public void setAnyTableMovementIssueDesc(String anyTableMovementIssueDesc) {
		this.anyTableMovementIssueDesc = anyTableMovementIssueDesc;
	}
	/**
	 * @return the frontAndBackTableScrewOkDesc
	 */
	public String getFrontAndBackTableScrewOkDesc() {
		return frontAndBackTableScrewOkDesc;
	}
	/**
	 * @param frontAndBackTableScrewOkDesc the frontAndBackTableScrewOkDesc to set
	 */
	public void setFrontAndBackTableScrewOkDesc(String frontAndBackTableScrewOkDesc) {
		this.frontAndBackTableScrewOkDesc = frontAndBackTableScrewOkDesc;
	}
	/**
	 * @return the tableAndLiftScrewsBlownDownDesc
	 */
	public String getTableAndLiftScrewsBlownDownDesc() {
		return tableAndLiftScrewsBlownDownDesc;
	}
	/**
	 * @param tableAndLiftScrewsBlownDownDesc the tableAndLiftScrewsBlownDownDesc to set
	 */
	public void setTableAndLiftScrewsBlownDownDesc(String tableAndLiftScrewsBlownDownDesc) {
		this.tableAndLiftScrewsBlownDownDesc = tableAndLiftScrewsBlownDownDesc;
	}
	/**
	 * @return the anyTrimShootIssuesDesc
	 */
	public String getAnyTrimShootIssuesDesc() {
		return anyTrimShootIssuesDesc;
	}
	/**
	 * @param anyTrimShootIssuesDesc the anyTrimShootIssuesDesc to set
	 */
	public void setAnyTrimShootIssuesDesc(String anyTrimShootIssuesDesc) {
		this.anyTrimShootIssuesDesc = anyTrimShootIssuesDesc;
	}
	/**
	 * @return the tableDrainCleanDesc
	 */
	public String getTableDrainCleanDesc() {
		return tableDrainCleanDesc;
	}
	/**
	 * @param tableDrainCleanDesc the tableDrainCleanDesc to set
	 */
	public void setTableDrainCleanDesc(String tableDrainCleanDesc) {
		this.tableDrainCleanDesc = tableDrainCleanDesc;
	}
	/**
	 * @return the flueshLinesCleanDesc
	 */
	public String getFlueshLinesCleanDesc() {
		return flueshLinesCleanDesc;
	}
	/**
	 * @param flueshLinesCleanDesc the flueshLinesCleanDesc to set
	 */
	public void setFlueshLinesCleanDesc(String flueshLinesCleanDesc) {
		this.flueshLinesCleanDesc = flueshLinesCleanDesc;
	}
	/**
	 * @return the checkCoolingWaterDesc
	 */
	public String getCheckCoolingWaterDesc() {
		return checkCoolingWaterDesc;
	}
	/**
	 * @param checkCoolingWaterDesc the checkCoolingWaterDesc to set
	 */
	public void setCheckCoolingWaterDesc(String checkCoolingWaterDesc) {
		this.checkCoolingWaterDesc = checkCoolingWaterDesc;
	}
	/**
	 * @return the allPanelLightsWorkingDesc
	 */
	public String getAllPanelLightsWorkingDesc() {
		return allPanelLightsWorkingDesc;
	}
	/**
	 * @param allPanelLightsWorkingDesc the allPanelLightsWorkingDesc to set
	 */
	public void setAllPanelLightsWorkingDesc(String allPanelLightsWorkingDesc) {
		this.allPanelLightsWorkingDesc = allPanelLightsWorkingDesc;
	}
	/**
	 * @return the airShaftsHoldingDesc
	 */
	public String getAirShaftsHoldingDesc() {
		return airShaftsHoldingDesc;
	}
	/**
	 * @param airShaftsHoldingDesc the airShaftsHoldingDesc to set
	 */
	public void setAirShaftsHoldingDesc(String airShaftsHoldingDesc) {
		this.airShaftsHoldingDesc = airShaftsHoldingDesc;
	}
	/**
	 * @return the anyBreakingIssuesDesc
	 */
	public String getAnyBreakingIssuesDesc() {
		return anyBreakingIssuesDesc;
	}
	/**
	 * @param anyBreakingIssuesDesc the anyBreakingIssuesDesc to set
	 */
	public void setAnyBreakingIssuesDesc(String anyBreakingIssuesDesc) {
		this.anyBreakingIssuesDesc = anyBreakingIssuesDesc;
	}
}

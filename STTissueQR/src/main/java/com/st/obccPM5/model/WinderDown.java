/**
 *May 7, 2021
 *WinderDown.java
 * TODO
 *com.st.obccPM5.model
 *WinderDown.java
 *Sohan Lal 
 */
package com.st.obccPM5.model;

/**
 * @author Sohanlal
 *
 */
public class WinderDown {

	private int id;
	private String position;
	private String operatorName;
	private String edate;
	private String crew;
	private String shift;
	private boolean machinedown;	
	private boolean power;
	private boolean blade;
	private boolean sizeadjustmentmovement;
	private boolean rollkickerworkingproperly;
	private boolean anyhydraulicleaks;
	private boolean uprightbumperandcushionbumperworkingproperly;
	private boolean anycontrolpanelissues;
	private boolean anynoticeableissueswithconveyor;
	private String powerDesc;
	private String bladeDesc;
	private String sizeadjustmentmovementDesc;
	private String rollkickerworkingproperlyDesc;
	private String anyhydraulicleaksDesc;
	private String uprightbumperandcushionbumperworkingproperlyDesc;
	private String anycontrolpanelissuesDesc;
	private String anynoticeableissueswithconveyorDesc;
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
	 * @return the power
	 */
	public boolean isPower() {
		return power;
	}
	/**
	 * @param power the power to set
	 */
	public void setPower(boolean power) {
		this.power = power;
	}
	/**
	 * @return the blade
	 */
	public boolean isBlade() {
		return blade;
	}
	/**
	 * @param blade the blade to set
	 */
	public void setBlade(boolean blade) {
		this.blade = blade;
	}
	/**
	 * @return the sizeadjustmentmovement
	 */
	public boolean isSizeadjustmentmovement() {
		return sizeadjustmentmovement;
	}
	/**
	 * @param sizeadjustmentmovement the sizeadjustmentmovement to set
	 */
	public void setSizeadjustmentmovement(boolean sizeadjustmentmovement) {
		this.sizeadjustmentmovement = sizeadjustmentmovement;
	}
	/**
	 * @return the rollkickerworkingproperly
	 */
	public boolean isRollkickerworkingproperly() {
		return rollkickerworkingproperly;
	}
	/**
	 * @param rollkickerworkingproperly the rollkickerworkingproperly to set
	 */
	public void setRollkickerworkingproperly(boolean rollkickerworkingproperly) {
		this.rollkickerworkingproperly = rollkickerworkingproperly;
	}
	/**
	 * @return the anyhydraulicleaks
	 */
	public boolean isAnyhydraulicleaks() {
		return anyhydraulicleaks;
	}
	/**
	 * @param anyhydraulicleaks the anyhydraulicleaks to set
	 */
	public void setAnyhydraulicleaks(boolean anyhydraulicleaks) {
		this.anyhydraulicleaks = anyhydraulicleaks;
	}
	/**
	 * @return the uprightbumperandcushionbumperworkingproperly
	 */
	public boolean isUprightbumperandcushionbumperworkingproperly() {
		return uprightbumperandcushionbumperworkingproperly;
	}
	/**
	 * @param uprightbumperandcushionbumperworkingproperly the uprightbumperandcushionbumperworkingproperly to set
	 */
	public void setUprightbumperandcushionbumperworkingproperly(boolean uprightbumperandcushionbumperworkingproperly) {
		this.uprightbumperandcushionbumperworkingproperly = uprightbumperandcushionbumperworkingproperly;
	}
	/**
	 * @return the anycontrolpanelissues
	 */
	public boolean isAnycontrolpanelissues() {
		return anycontrolpanelissues;
	}
	/**
	 * @param anycontrolpanelissues the anycontrolpanelissues to set
	 */
	public void setAnycontrolpanelissues(boolean anycontrolpanelissues) {
		this.anycontrolpanelissues = anycontrolpanelissues;
	}
	/**
	 * @return the anynoticeableissueswithconveyor
	 */
	public boolean isAnynoticeableissueswithconveyor() {
		return anynoticeableissueswithconveyor;
	}
	/**
	 * @param anynoticeableissueswithconveyor the anynoticeableissueswithconveyor to set
	 */
	public void setAnynoticeableissueswithconveyor(boolean anynoticeableissueswithconveyor) {
		this.anynoticeableissueswithconveyor = anynoticeableissueswithconveyor;
	}
	/**
	 * @return the powerDesc
	 */
	public String getPowerDesc() {
		return powerDesc;
	}
	/**
	 * @param powerDesc the powerDesc to set
	 */
	public void setPowerDesc(String powerDesc) {
		this.powerDesc = powerDesc;
	}
	/**
	 * @return the bladeDesc
	 */
	public String getBladeDesc() {
		return bladeDesc;
	}
	/**
	 * @param bladeDesc the bladeDesc to set
	 */
	public void setBladeDesc(String bladeDesc) {
		this.bladeDesc = bladeDesc;
	}
	/**
	 * @return the sizeadjustmentmovementDesc
	 */
	public String getSizeadjustmentmovementDesc() {
		return sizeadjustmentmovementDesc;
	}
	/**
	 * @param sizeadjustmentmovementDesc the sizeadjustmentmovementDesc to set
	 */
	public void setSizeadjustmentmovementDesc(String sizeadjustmentmovementDesc) {
		this.sizeadjustmentmovementDesc = sizeadjustmentmovementDesc;
	}
	/**
	 * @return the rollkickerworkingproperlyDesc
	 */
	public String getRollkickerworkingproperlyDesc() {
		return rollkickerworkingproperlyDesc;
	}
	/**
	 * @param rollkickerworkingproperlyDesc the rollkickerworkingproperlyDesc to set
	 */
	public void setRollkickerworkingproperlyDesc(String rollkickerworkingproperlyDesc) {
		this.rollkickerworkingproperlyDesc = rollkickerworkingproperlyDesc;
	}
	/**
	 * @return the anyhydraulicleaksDesc
	 */
	public String getAnyhydraulicleaksDesc() {
		return anyhydraulicleaksDesc;
	}
	/**
	 * @param anyhydraulicleaksDesc the anyhydraulicleaksDesc to set
	 */
	public void setAnyhydraulicleaksDesc(String anyhydraulicleaksDesc) {
		this.anyhydraulicleaksDesc = anyhydraulicleaksDesc;
	}
	/**
	 * @return the uprightbumperandcushionbumperworkingproperlyDesc
	 */
	public String getUprightbumperandcushionbumperworkingproperlyDesc() {
		return uprightbumperandcushionbumperworkingproperlyDesc;
	}
	/**
	 * @param uprightbumperandcushionbumperworkingproperlyDesc the uprightbumperandcushionbumperworkingproperlyDesc to set
	 */
	public void setUprightbumperandcushionbumperworkingproperlyDesc(
			String uprightbumperandcushionbumperworkingproperlyDesc) {
		this.uprightbumperandcushionbumperworkingproperlyDesc = uprightbumperandcushionbumperworkingproperlyDesc;
	}
	/**
	 * @return the anycontrolpanelissuesDesc
	 */
	public String getAnycontrolpanelissuesDesc() {
		return anycontrolpanelissuesDesc;
	}
	/**
	 * @param anycontrolpanelissuesDesc the anycontrolpanelissuesDesc to set
	 */
	public void setAnycontrolpanelissuesDesc(String anycontrolpanelissuesDesc) {
		this.anycontrolpanelissuesDesc = anycontrolpanelissuesDesc;
	}
	/**
	 * @return the anynoticeableissueswithconveyorDesc
	 */
	public String getAnynoticeableissueswithconveyorDesc() {
		return anynoticeableissueswithconveyorDesc;
	}
	/**
	 * @param anynoticeableissueswithconveyorDesc the anynoticeableissueswithconveyorDesc to set
	 */
	public void setAnynoticeableissueswithconveyorDesc(String anynoticeableissueswithconveyorDesc) {
		this.anynoticeableissueswithconveyorDesc = anynoticeableissueswithconveyorDesc;
	}
}

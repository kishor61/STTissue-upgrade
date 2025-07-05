/**
 *Nov 28, 2019
 *RewindUnwind.java
 * TODO
 *com.st.convertingline.model
 *RewindUnwind.java
 *Roshan Lal Tailor
 */
package com.st.convertingline.model;

import java.util.Date;

/**
 * @author kishore
 *
 */
public class RewinderAndUnwindStand {
	private int id;
	private String position;
	private String crew;
	private String operatorname;
	private String date;
	private String shift;
	private boolean machinedown;
	
	private String itemonrewind;
	private String boxesHmi;
	private String footagenumber;
	private String diameternumber;
	private String actualfootage;
	private String actualdiameter;
	private String papergrade;
	private String logsawstone;
	private String unwindstandcleaned;
	private String transferglue;
	private String tailtieglue;
	private String nomore1stlog;
	private String rolllength;
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
	 * @return the operatorname
	 */
	public String getOperatorname() {
		return operatorname;
	}
	/**
	 * @param operatorname the operatorname to set
	 */
	public void setOperatorname(String operatorname) {
		this.operatorname = operatorname;
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
	 * @return the itemonrewind
	 */
	public String getItemonrewind() {
		return itemonrewind;
	}
	/**
	 * @param itemonrewind the itemonrewind to set
	 */
	public void setItemonrewind(String itemonrewind) {
		this.itemonrewind = itemonrewind;
	}
	/**
	 * @return the boxesHmi
	 */
	public String getBoxesHmi() {
		return boxesHmi;
	}
	/**
	 * @param boxesHmi the boxesHmi to set
	 */
	public void setBoxesHmi(String boxesHmi) {
		this.boxesHmi = boxesHmi;
	}
	/**
	 * @return the footagenumber
	 */
	public String getFootagenumber() {
		return footagenumber;
	}
	/**
	 * @param footagenumber the footagenumber to set
	 */
	public void setFootagenumber(String footagenumber) {
		this.footagenumber = footagenumber;
	}
	/**
	 * @return the diameternumber
	 */
	public String getDiameternumber() {
		return diameternumber;
	}
	/**
	 * @param diameternumber the diameternumber to set
	 */
	public void setDiameternumber(String diameternumber) {
		this.diameternumber = diameternumber;
	}
	/**
	 * @return the actualfootage
	 */
	public String getActualfootage() {
		return actualfootage;
	}
	/**
	 * @param actualfootage the actualfootage to set
	 */
	public void setActualfootage(String actualfootage) {
		this.actualfootage = actualfootage;
	}
	/**
	 * @return the actualdiameter
	 */
	public String getActualdiameter() {
		return actualdiameter;
	}
	/**
	 * @param actualdiameter the actualdiameter to set
	 */
	public void setActualdiameter(String actualdiameter) {
		this.actualdiameter = actualdiameter;
	}
	/**
	 * @return the papergrade
	 */
	public String getPapergrade() {
		return papergrade;
	}
	/**
	 * @param papergrade the papergrade to set
	 */
	public void setPapergrade(String papergrade) {
		this.papergrade = papergrade;
	}
	/**
	 * @return the unwindstandcleaned
	 */
	public String getUnwindstandcleaned() {
		return unwindstandcleaned;
	}
	/**
	 * @param unwindstandcleaned the unwindstandcleaned to set
	 */
	public void setUnwindstandcleaned(String unwindstandcleaned) {
		this.unwindstandcleaned = unwindstandcleaned;
	}
	/**
	 * @return the transferglue
	 */
	public String getTransferglue() {
		return transferglue;
	}
	/**
	 * @param transferglue the transferglue to set
	 */
	public void setTransferglue(String transferglue) {
		this.transferglue = transferglue;
	}
	/**
	 * @return the tailtieglue
	 */
	public String getTailtieglue() {
		return tailtieglue;
	}
	/**
	 * @param tailtieglue the tailtieglue to set
	 */
	public void setTailtieglue(String tailtieglue) {
		this.tailtieglue = tailtieglue;
	}
	/**
	 * @return the nomore1stlog
	 */
	public String getNomore1stlog() {
		return nomore1stlog;
	}
	/**
	 * @param nomore1stlog the nomore1stlog to set
	 */
	public void setNomore1stlog(String nomore1stlog) {
		this.nomore1stlog = nomore1stlog;
	}
	/**
	 * @return the rolllength
	 */
	public String getRolllength() {
		return rolllength;
	}
	/**
	 * @param rolllength the rolllength to set
	 */
	public void setRolllength(String rolllength) {
		this.rolllength = rolllength;
	}
	
	/**
	 * @return the logsawstone
	 */
	public String getLogsawstone() {
		return logsawstone;
	}
	/**
	 * @param logsawstone the logsawstone to set
	 */
	public void setLogsawstone(String logsawstone) {
		this.logsawstone = logsawstone;
	}
	/**
	 * @return the date
	 */
	public String getDate() {
		return date;
	}
	/**
	 * @param date the date to set
	 */
	public void setDate(String date) {
		this.date = date;
	}
	


}

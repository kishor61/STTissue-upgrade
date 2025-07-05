/**
 *03-Dec-2019
 *OpRoute_7.java
 * TODO
 *com.st.frpobcc.model
 *OpRoute_7.java
 *Sohan Lal Bairwa
 */
package com.st.frpobcc.model;

/**
 * @author sohan
 *
 */
public class OpRoute_7 {
	
	private int id;
	private String position;
	private String crew;
	private String operatorname;
	private String date;
	private String shift;
	private boolean machinedown;
	
	private String comments;
	private String cmt9amarea;
	private String cmt1pmarea;
	private String cmt5pmarea;
	private String cmt9pmarea;
	private String cmt1amarea;
	private String cmt5amarea;
	private String ok;
	private String button1pm;
	private String button5pm;
	private String button9pm;
	private String button1am;
	private String button5am;
	private String techniciansinitials_freq;
	private String techniciansinitials_9am;
	private String techniciansinitials_1pm;
	private String techniciansinitials_5pm;
	private String techniciansinitials_9pm;
	private String techniciansinitials_1am;
	private String techniciansinitials_5am;
	private String vbritetank1_freq;
	private String vbritetank1_9am;
	private String vbritetank1_1pm;
	private String vbritetank1_5pm;
	private String vbritetank1_9pm;
	private String vbritetank1_1am;
	private String vbritetank1_5am;
	private String vbritetank2_freq;
	private String vbritetank2_9am;
	private String vbritetank2_1pm;
	private String vbritetank2_5pm;
	private String vbritetank2_9pm;
	private String vbritetank2_1am;
	private String vbritetank2_5am;
	private String vbritetank3_freq;
	private String vbritetank3_9am;
	private String vbritetank3_1pm;
	private String vbritetank3_5pm;
	private String vbritetank3_9pm;
	private String vbritetank3_1am;
	private String vbritetank3_5am;
	
	private String causticunloadingarea1_freq;
	private String causticunloadingarea1_9am;
	private String causticunloadingarea1_1pm;
	private String causticunloadingarea1_5pm;
	private String causticunloadingarea1_9pm;
	private String causticunloadingarea1_1am;
	private String causticunloadingarea1_5am;
	private String causticunloadingarea2_freq;
	private String causticunloadingarea2_9am;
	private String causticunloadingarea2_1pm;
	private String causticunloadingarea2_5pm;
	private String causticunloadingarea2_9pm;
	private String causticunloadingarea2_1am;
	private String causticunloadingarea2_5am;
	
	private String clarifier1_freq;
	private String clarifier1_9am;
	private String clarifier1_1pm;
	private String clarifier1_5pm;
	private String clarifier1_9pm;
	private String clarifier1_1am;
	private String clarifier1_5am;
	private String clarifier2_freq;
	private String clarifier2_9am;
	private String clarifier2_1pm;
	private String clarifier2_5pm;
	private String clarifier2_9pm;
	private String clarifier2_1am;
	private String clarifier2_5am;
	private String clarifier3_freq;
	private String clarifier3_9am;
	private String clarifier3_1pm;
	private String clarifier3_5pm;
	private String clarifier3_9pm;
	private String clarifier3_1am;
	private String clarifier3_5am;
	private String clarifier4_freq;
	private String clarifier4_9am;
	private String clarifier4_1pm;
	private String clarifier4_5pm;
	private String clarifier4_9pm;
	private String clarifier4_1am;
	private String clarifier4_5am;
	private String clarifier5_freq;
	private String clarifier5_9am;
	private String clarifier5_1pm;
	private String clarifier5_5pm;
	private String clarifier5_9pm;
	private String clarifier5_1am;
	private String clarifier5_5am;
	
	private String sludgepumpsdikedrain1_freq;
	private String sludgepumpsdikedrain1_9am;
	private String sludgepumpsdikedrain1_1pm;
	private String sludgepumpsdikedrain1_5pm;
	private String sludgepumpsdikedrain1_9pm;
	private String sludgepumpsdikedrain1_1am;
	private String sludgepumpsdikedrain1_5am;
	private String sludgepumpsdikedrain2_freq;
	private String sludgepumpsdikedrain2_9am;
	private String sludgepumpsdikedrain2_1pm;
	private String sludgepumpsdikedrain2_5pm;
	private String sludgepumpsdikedrain2_9pm;
	private String sludgepumpsdikedrain2_1am;
	private String sludgepumpsdikedrain2_5am;
	
	private String mill_firewatersystem1_freq;
	private String mill_firewatersystem1_9am;
	private String mill_firewatersystem1_1pm;
	private String mill_firewatersystem1_5pm;
	private String mill_firewatersystem1_9pm;
	private String mill_firewatersystem1_1am;
	private String mill_firewatersystem1_5am;
	private String mill_firewatersystem2_freq;
	private String mill_firewatersystem2_9am;
	private String mill_firewatersystem2_1pm;
	private String mill_firewatersystem2_5pm;
	private String mill_firewatersystem2_9pm;
	private String mill_firewatersystem2_1am;
	private String mill_firewatersystem2_5am;
	private String mill_firewatersystem3_freq;
	private String mill_firewatersystem3_9am;
	private String mill_firewatersystem3_1pm;
	private String mill_firewatersystem3_5pm;
	private String mill_firewatersystem3_9pm;
	private String mill_firewatersystem3_1am;
	private String mill_firewatersystem3_5am;
	private String mill_firewatersystem4_freq;
	private String mill_firewatersystem4_9am;
	private String mill_firewatersystem4_1pm;
	private String mill_firewatersystem4_5pm;
	private String mill_firewatersystem4_9pm;
	private String mill_firewatersystem4_1am;
	private String mill_firewatersystem4_5am;
	private String mill_firewatersystem5_freq;
	private String mill_firewatersystem5_9am;
	private String mill_firewatersystem5_1pm;
	private String mill_firewatersystem5_5pm;
	private String mill_firewatersystem5_9pm;
	private String mill_firewatersystem5_1am;
	private String mill_firewatersystem5_5am;
	private String mill_firewatersystem6_freq;
	private String mill_firewatersystem6_9am;
	private String mill_firewatersystem6_1pm;
	private String mill_firewatersystem6_5pm;
	private String mill_firewatersystem6_9pm;
	private String mill_firewatersystem6_1am;
	private String mill_firewatersystem6_5am;
	private String mill_firewatersystem7_freq;
	private String mill_firewatersystem7_9am;
	private String mill_firewatersystem7_1pm;
	private String mill_firewatersystem7_5pm;
	private String mill_firewatersystem7_9pm;
	private String mill_firewatersystem7_1am;
	private String mill_firewatersystem7_5am;

	private String plantaircompressors1_freq;
	private String plantaircompressors1_9am;
	private String plantaircompressors1_1pm;
	private String plantaircompressors1_5pm;
	private String plantaircompressors1_9pm;
	private String plantaircompressors1_1am;
	private String plantaircompressors1_5am;
	private String plantaircompressors2_freq;
	private String plantaircompressors2_9am;
	private String plantaircompressors2_1pm;
	private String plantaircompressors2_5pm;
	private String plantaircompressors2_9pm;
	private String plantaircompressors2_1am;
	private String plantaircompressors2_5am;
	private String plantaircompressors3_freq;
	private String plantaircompressors3_9am;
	private String plantaircompressors3_1pm;
	private String plantaircompressors3_5pm;
	private String plantaircompressors3_9pm;
	private String plantaircompressors3_1am;
	private String plantaircompressors3_5am;
	private String plantaircompressors4_freq;
	private String plantaircompressors4_9am;
	private String plantaircompressors4_1pm;
	private String plantaircompressors4_5pm;
	private String plantaircompressors4_9pm;
	private String plantaircompressors4_1am;
	private String plantaircompressors4_5am;
	private String plantaircompressors5_freq;
	private String plantaircompressors5_9am;
	private String plantaircompressors5_1pm;
	private String plantaircompressors5_5pm;
	private String plantaircompressors5_9pm;
	private String plantaircompressors5_1am;
	private String plantaircompressors5_5am;
	private String plantaircompressors6_freq;
	private String plantaircompressors6_9am;
	private String plantaircompressors6_1pm;
	private String plantaircompressors6_5pm;
	private String plantaircompressors6_9pm;
	private String plantaircompressors6_1am;
	private String plantaircompressors6_5am;
	private String plantaircompressors7_freq;
	private String plantaircompressors7_9am;
	private String plantaircompressors7_1pm;
	private String plantaircompressors7_5pm;
	private String plantaircompressors7_9pm;
	private String plantaircompressors7_1am;
	private String plantaircompressors7_5am;
	private String plantaircompressors8_freq;
	private String plantaircompressors8_9am;
	private String plantaircompressors8_1pm;
	private String plantaircompressors8_5pm;
	private String plantaircompressors8_9pm;
	private String plantaircompressors8_1am;
	private String plantaircompressors8_5am;
	private String plantaircompressors9_freq;
	private String plantaircompressors9_9am;
	private String plantaircompressors9_1pm;
	private String plantaircompressors9_5pm;
	private String plantaircompressors9_9pm;
	private String plantaircompressors9_1am;
	private String plantaircompressors9_5am;
	private String plantaircompressors10_freq;
	private String plantaircompressors10_9am;
	private String plantaircompressors10_1pm;
	private String plantaircompressors10_5pm;
	private String plantaircompressors10_9pm;
	private String plantaircompressors10_1am;
	private String plantaircompressors10_5am;
	private String plantaircompressors11_freq;
	private String plantaircompressors11_9am;
	private String plantaircompressors11_1pm;
	private String plantaircompressors11_5pm;
	private String plantaircompressors11_9pm;
	private String plantaircompressors11_1am;
	private String plantaircompressors11_5am;
	private String plantaircompressors12_freq;
	private String plantaircompressors12_9am;
	private String plantaircompressors12_1pm;
	private String plantaircompressors12_5pm;
	private String plantaircompressors12_9pm;
	private String plantaircompressors12_1am;
	private String plantaircompressors12_5am;
	private String plantaircompressors13_freq;
	private String plantaircompressors13_9am;
	private String plantaircompressors13_1pm;
	private String plantaircompressors13_5pm;
	private String plantaircompressors13_9pm;
	private String plantaircompressors13_1am;
	private String plantaircompressors13_5am;
	private String plantaircompressors14_freq;
	private String plantaircompressors14_9am;
	private String plantaircompressors14_1pm;
	private String plantaircompressors14_5pm;
	private String plantaircompressors14_9pm;
	private String plantaircompressors14_1am;
	private String plantaircompressors14_5am;
	private String plantaircompressors15_freq;
	private String plantaircompressors15_9am;
	private String plantaircompressors15_1pm;
	private String plantaircompressors15_5pm;
	private String plantaircompressors15_9pm;
	private String plantaircompressors15_1am;
	private String plantaircompressors15_5am;
	private String plantaircompressors16_freq;
	private String plantaircompressors16_9am;
	private String plantaircompressors16_1pm;
	private String plantaircompressors16_5pm;
	private String plantaircompressors16_9pm;
	private String plantaircompressors16_1am;
	private String plantaircompressors16_5am;
	
	private String millairdryer1_freq;
	private String millairdryer1_9am;
	private String millairdryer1_1pm;
	private String millairdryer1_5pm;
	private String millairdryer1_9pm;
	private String millairdryer1_1am;
	private String millairdryer1_5am;
	private String millairdryer2_freq;
	private String millairdryer2_9am;
	private String millairdryer2_1pm;
	private String millairdryer2_5pm;
	private String millairdryer2_9pm;
	private String millairdryer2_1am;
	private String millairdryer2_5am;
	private String millairdryer3_freq;
	private String millairdryer3_9am;
	private String millairdryer3_1pm;
	private String millairdryer3_5pm;
	private String millairdryer3_9pm;
	private String millairdryer3_1am;
	private String millairdryer3_5am;
	private String millairdryer4_freq;
	private String millairdryer4_9am;
	private String millairdryer4_1pm;
	private String millairdryer4_5pm;
	private String millairdryer4_9pm;
	private String millairdryer4_1am;
	private String millairdryer4_5am;
	private String millairdryer5_freq;
	private String millairdryer5_9am;
	private String millairdryer5_1pm;
	private String millairdryer5_5pm;
	private String millairdryer5_9pm;
	private String millairdryer5_1am;
	private String millairdryer5_5am;
	private String millairdryer6_freq;
	private String millairdryer6_9am;
	private String millairdryer6_1pm;
	private String millairdryer6_5pm;
	private String millairdryer6_9pm;
	private String millairdryer6_1am;
	private String millairdryer6_5am;
	private String millairdryer7_freq;
	private String millairdryer7_9am;
	private String millairdryer7_1pm;
	private String millairdryer7_5pm;
	private String millairdryer7_9pm;
	private String millairdryer7_1am;
	private String millairdryer7_5am;
	
	private String polymerareawaterflowrate1_freq;
	private String polymerareawaterflowrate1_9am;
	private String polymerareawaterflowrate1_1pm;
	private String polymerareawaterflowrate1_5pm;
	private String polymerareawaterflowrate1_9pm;
	private String polymerareawaterflowrate1_1am;
	private String polymerareawaterflowrate1_5am;
	private String polymerareawaterflowrate2_freq;
	private String polymerareawaterflowrate2_9am;
	private String polymerareawaterflowrate2_1pm;
	private String polymerareawaterflowrate2_5pm;
	private String polymerareawaterflowrate2_9pm;
	private String polymerareawaterflowrate2_1am;
	private String polymerareawaterflowrate2_5am;
	private String polymerareawaterflowrate3_freq;
	private String polymerareawaterflowrate3_9am;
	private String polymerareawaterflowrate3_1pm;
	private String polymerareawaterflowrate3_5pm;
	private String polymerareawaterflowrate3_9pm;
	private String polymerareawaterflowrate3_1am;
	private String polymerareawaterflowrate3_5am;
	
	private String polymerflowrate1_freq;
	private String polymerflowrate1_9am;
	private String polymerflowrate1_1pm;
	private String polymerflowrate1_5pm;
	private String polymerflowrate1_9pm;
	private String polymerflowrate1_1am;
	private String polymerflowrate1_5am;
	private String polymerflowrate2_freq;
	private String polymerflowrate2_9am;
	private String polymerflowrate2_1pm;
	private String polymerflowrate2_5pm;
	private String polymerflowrate2_9pm;
	private String polymerflowrate2_1am;
	private String polymerflowrate2_5am;
	private String polymerflowrate3_freq;
	private String polymerflowrate3_9am;
	private String polymerflowrate3_1pm;
	private String polymerflowrate3_5pm;
	private String polymerflowrate3_9pm;
	private String polymerflowrate3_1am;
	private String polymerflowrate3_5am;

	private String totelevels1_freq;
	private String totelevels1_9am;
	private String totelevels1_1pm;
	private String totelevels1_5pm;
	private String totelevels1_9pm;
	private String totelevels1_1am;
	private String totelevels1_5am;
	private String totelevels2_freq;
	private String totelevels2_9am;
	private String totelevels2_1pm;
	private String totelevels2_5pm;
	private String totelevels2_9pm;
	private String totelevels2_1am;
	private String totelevels2_5am;
	private String totelevels3_freq;
	private String totelevels3_9am;
	private String totelevels3_1pm;
	private String totelevels3_5pm;
	private String totelevels3_9pm;
	private String totelevels3_1am;
	private String totelevels3_5am;
	
	private String totelevels4_freq;
	private String totelevels4_9am;
	private String totelevels4_1pm;
	private String totelevels4_5pm;
	private String totelevels4_9pm;
	private String totelevels4_1am;
	private String totelevels4_5am;
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
	 * @return the vbritetank1_freq
	 */
	public String getVbritetank1_freq() {
		return vbritetank1_freq;
	}
	/**
	 * @param vbritetank1_freq the vbritetank1_freq to set
	 */
	public void setVbritetank1_freq(String vbritetank1_freq) {
		this.vbritetank1_freq = vbritetank1_freq;
	}
	/**
	 * @return the vbritetank1_9am
	 */
	public String getVbritetank1_9am() {
		return vbritetank1_9am;
	}
	/**
	 * @param vbritetank1_9am the vbritetank1_9am to set
	 */
	public void setVbritetank1_9am(String vbritetank1_9am) {
		this.vbritetank1_9am = vbritetank1_9am;
	}
	/**
	 * @return the vbritetank1_1pm
	 */
	public String getVbritetank1_1pm() {
		return vbritetank1_1pm;
	}
	/**
	 * @param vbritetank1_1pm the vbritetank1_1pm to set
	 */
	public void setVbritetank1_1pm(String vbritetank1_1pm) {
		this.vbritetank1_1pm = vbritetank1_1pm;
	}
	/**
	 * @return the vbritetank1_5pm
	 */
	public String getVbritetank1_5pm() {
		return vbritetank1_5pm;
	}
	/**
	 * @param vbritetank1_5pm the vbritetank1_5pm to set
	 */
	public void setVbritetank1_5pm(String vbritetank1_5pm) {
		this.vbritetank1_5pm = vbritetank1_5pm;
	}
	/**
	 * @return the vbritetank1_9pm
	 */
	public String getVbritetank1_9pm() {
		return vbritetank1_9pm;
	}
	/**
	 * @param vbritetank1_9pm the vbritetank1_9pm to set
	 */
	public void setVbritetank1_9pm(String vbritetank1_9pm) {
		this.vbritetank1_9pm = vbritetank1_9pm;
	}
	/**
	 * @return the vbritetank1_1am
	 */
	public String getVbritetank1_1am() {
		return vbritetank1_1am;
	}
	/**
	 * @param vbritetank1_1am the vbritetank1_1am to set
	 */
	public void setVbritetank1_1am(String vbritetank1_1am) {
		this.vbritetank1_1am = vbritetank1_1am;
	}
	/**
	 * @return the vbritetank1_5am
	 */
	public String getVbritetank1_5am() {
		return vbritetank1_5am;
	}
	/**
	 * @param vbritetank1_5am the vbritetank1_5am to set
	 */
	public void setVbritetank1_5am(String vbritetank1_5am) {
		this.vbritetank1_5am = vbritetank1_5am;
	}
	/**
	 * @return the vbritetank2_freq
	 */
	public String getVbritetank2_freq() {
		return vbritetank2_freq;
	}
	/**
	 * @param vbritetank2_freq the vbritetank2_freq to set
	 */
	public void setVbritetank2_freq(String vbritetank2_freq) {
		this.vbritetank2_freq = vbritetank2_freq;
	}
	/**
	 * @return the vbritetank2_9am
	 */
	public String getVbritetank2_9am() {
		return vbritetank2_9am;
	}
	/**
	 * @param vbritetank2_9am the vbritetank2_9am to set
	 */
	public void setVbritetank2_9am(String vbritetank2_9am) {
		this.vbritetank2_9am = vbritetank2_9am;
	}
	/**
	 * @return the vbritetank2_1pm
	 */
	public String getVbritetank2_1pm() {
		return vbritetank2_1pm;
	}
	/**
	 * @param vbritetank2_1pm the vbritetank2_1pm to set
	 */
	public void setVbritetank2_1pm(String vbritetank2_1pm) {
		this.vbritetank2_1pm = vbritetank2_1pm;
	}
	/**
	 * @return the vbritetank2_5pm
	 */
	public String getVbritetank2_5pm() {
		return vbritetank2_5pm;
	}
	/**
	 * @param vbritetank2_5pm the vbritetank2_5pm to set
	 */
	public void setVbritetank2_5pm(String vbritetank2_5pm) {
		this.vbritetank2_5pm = vbritetank2_5pm;
	}
	/**
	 * @return the vbritetank2_9pm
	 */
	public String getVbritetank2_9pm() {
		return vbritetank2_9pm;
	}
	/**
	 * @param vbritetank2_9pm the vbritetank2_9pm to set
	 */
	public void setVbritetank2_9pm(String vbritetank2_9pm) {
		this.vbritetank2_9pm = vbritetank2_9pm;
	}
	/**
	 * @return the vbritetank2_1am
	 */
	public String getVbritetank2_1am() {
		return vbritetank2_1am;
	}
	/**
	 * @param vbritetank2_1am the vbritetank2_1am to set
	 */
	public void setVbritetank2_1am(String vbritetank2_1am) {
		this.vbritetank2_1am = vbritetank2_1am;
	}
	/**
	 * @return the vbritetank2_5am
	 */
	public String getVbritetank2_5am() {
		return vbritetank2_5am;
	}
	/**
	 * @param vbritetank2_5am the vbritetank2_5am to set
	 */
	public void setVbritetank2_5am(String vbritetank2_5am) {
		this.vbritetank2_5am = vbritetank2_5am;
	}
	/**
	 * @return the vbritetank3_freq
	 */
	public String getVbritetank3_freq() {
		return vbritetank3_freq;
	}
	/**
	 * @param vbritetank3_freq the vbritetank3_freq to set
	 */
	public void setVbritetank3_freq(String vbritetank3_freq) {
		this.vbritetank3_freq = vbritetank3_freq;
	}
	/**
	 * @return the vbritetank3_9am
	 */
	public String getVbritetank3_9am() {
		return vbritetank3_9am;
	}
	/**
	 * @param vbritetank3_9am the vbritetank3_9am to set
	 */
	public void setVbritetank3_9am(String vbritetank3_9am) {
		this.vbritetank3_9am = vbritetank3_9am;
	}
	/**
	 * @return the vbritetank3_1pm
	 */
	public String getVbritetank3_1pm() {
		return vbritetank3_1pm;
	}
	/**
	 * @param vbritetank3_1pm the vbritetank3_1pm to set
	 */
	public void setVbritetank3_1pm(String vbritetank3_1pm) {
		this.vbritetank3_1pm = vbritetank3_1pm;
	}
	/**
	 * @return the vbritetank3_5pm
	 */
	public String getVbritetank3_5pm() {
		return vbritetank3_5pm;
	}
	/**
	 * @param vbritetank3_5pm the vbritetank3_5pm to set
	 */
	public void setVbritetank3_5pm(String vbritetank3_5pm) {
		this.vbritetank3_5pm = vbritetank3_5pm;
	}
	/**
	 * @return the vbritetank3_9pm
	 */
	public String getVbritetank3_9pm() {
		return vbritetank3_9pm;
	}
	/**
	 * @param vbritetank3_9pm the vbritetank3_9pm to set
	 */
	public void setVbritetank3_9pm(String vbritetank3_9pm) {
		this.vbritetank3_9pm = vbritetank3_9pm;
	}
	/**
	 * @return the vbritetank3_1am
	 */
	public String getVbritetank3_1am() {
		return vbritetank3_1am;
	}
	/**
	 * @param vbritetank3_1am the vbritetank3_1am to set
	 */
	public void setVbritetank3_1am(String vbritetank3_1am) {
		this.vbritetank3_1am = vbritetank3_1am;
	}
	/**
	 * @return the vbritetank3_5am
	 */
	public String getVbritetank3_5am() {
		return vbritetank3_5am;
	}
	/**
	 * @param vbritetank3_5am the vbritetank3_5am to set
	 */
	public void setVbritetank3_5am(String vbritetank3_5am) {
		this.vbritetank3_5am = vbritetank3_5am;
	}
	/**
	 * @return the causticunloadingarea1_freq
	 */
	public String getCausticunloadingarea1_freq() {
		return causticunloadingarea1_freq;
	}
	/**
	 * @param causticunloadingarea1_freq the causticunloadingarea1_freq to set
	 */
	public void setCausticunloadingarea1_freq(String causticunloadingarea1_freq) {
		this.causticunloadingarea1_freq = causticunloadingarea1_freq;
	}
	/**
	 * @return the causticunloadingarea1_9am
	 */
	public String getCausticunloadingarea1_9am() {
		return causticunloadingarea1_9am;
	}
	/**
	 * @param causticunloadingarea1_9am the causticunloadingarea1_9am to set
	 */
	public void setCausticunloadingarea1_9am(String causticunloadingarea1_9am) {
		this.causticunloadingarea1_9am = causticunloadingarea1_9am;
	}
	/**
	 * @return the causticunloadingarea1_1pm
	 */
	public String getCausticunloadingarea1_1pm() {
		return causticunloadingarea1_1pm;
	}
	/**
	 * @param causticunloadingarea1_1pm the causticunloadingarea1_1pm to set
	 */
	public void setCausticunloadingarea1_1pm(String causticunloadingarea1_1pm) {
		this.causticunloadingarea1_1pm = causticunloadingarea1_1pm;
	}
	/**
	 * @return the causticunloadingarea1_5pm
	 */
	public String getCausticunloadingarea1_5pm() {
		return causticunloadingarea1_5pm;
	}
	/**
	 * @param causticunloadingarea1_5pm the causticunloadingarea1_5pm to set
	 */
	public void setCausticunloadingarea1_5pm(String causticunloadingarea1_5pm) {
		this.causticunloadingarea1_5pm = causticunloadingarea1_5pm;
	}
	/**
	 * @return the causticunloadingarea1_9pm
	 */
	public String getCausticunloadingarea1_9pm() {
		return causticunloadingarea1_9pm;
	}
	/**
	 * @param causticunloadingarea1_9pm the causticunloadingarea1_9pm to set
	 */
	public void setCausticunloadingarea1_9pm(String causticunloadingarea1_9pm) {
		this.causticunloadingarea1_9pm = causticunloadingarea1_9pm;
	}
	/**
	 * @return the causticunloadingarea1_1am
	 */
	public String getCausticunloadingarea1_1am() {
		return causticunloadingarea1_1am;
	}
	/**
	 * @param causticunloadingarea1_1am the causticunloadingarea1_1am to set
	 */
	public void setCausticunloadingarea1_1am(String causticunloadingarea1_1am) {
		this.causticunloadingarea1_1am = causticunloadingarea1_1am;
	}
	/**
	 * @return the causticunloadingarea1_5am
	 */
	public String getCausticunloadingarea1_5am() {
		return causticunloadingarea1_5am;
	}
	/**
	 * @param causticunloadingarea1_5am the causticunloadingarea1_5am to set
	 */
	public void setCausticunloadingarea1_5am(String causticunloadingarea1_5am) {
		this.causticunloadingarea1_5am = causticunloadingarea1_5am;
	}
	/**
	 * @return the causticunloadingarea2_freq
	 */
	public String getCausticunloadingarea2_freq() {
		return causticunloadingarea2_freq;
	}
	/**
	 * @param causticunloadingarea2_freq the causticunloadingarea2_freq to set
	 */
	public void setCausticunloadingarea2_freq(String causticunloadingarea2_freq) {
		this.causticunloadingarea2_freq = causticunloadingarea2_freq;
	}
	/**
	 * @return the causticunloadingarea2_9am
	 */
	public String getCausticunloadingarea2_9am() {
		return causticunloadingarea2_9am;
	}
	/**
	 * @param causticunloadingarea2_9am the causticunloadingarea2_9am to set
	 */
	public void setCausticunloadingarea2_9am(String causticunloadingarea2_9am) {
		this.causticunloadingarea2_9am = causticunloadingarea2_9am;
	}
	/**
	 * @return the causticunloadingarea2_1pm
	 */
	public String getCausticunloadingarea2_1pm() {
		return causticunloadingarea2_1pm;
	}
	/**
	 * @param causticunloadingarea2_1pm the causticunloadingarea2_1pm to set
	 */
	public void setCausticunloadingarea2_1pm(String causticunloadingarea2_1pm) {
		this.causticunloadingarea2_1pm = causticunloadingarea2_1pm;
	}
	/**
	 * @return the causticunloadingarea2_5pm
	 */
	public String getCausticunloadingarea2_5pm() {
		return causticunloadingarea2_5pm;
	}
	/**
	 * @param causticunloadingarea2_5pm the causticunloadingarea2_5pm to set
	 */
	public void setCausticunloadingarea2_5pm(String causticunloadingarea2_5pm) {
		this.causticunloadingarea2_5pm = causticunloadingarea2_5pm;
	}
	/**
	 * @return the causticunloadingarea2_9pm
	 */
	public String getCausticunloadingarea2_9pm() {
		return causticunloadingarea2_9pm;
	}
	/**
	 * @param causticunloadingarea2_9pm the causticunloadingarea2_9pm to set
	 */
	public void setCausticunloadingarea2_9pm(String causticunloadingarea2_9pm) {
		this.causticunloadingarea2_9pm = causticunloadingarea2_9pm;
	}
	/**
	 * @return the causticunloadingarea2_1am
	 */
	public String getCausticunloadingarea2_1am() {
		return causticunloadingarea2_1am;
	}
	/**
	 * @param causticunloadingarea2_1am the causticunloadingarea2_1am to set
	 */
	public void setCausticunloadingarea2_1am(String causticunloadingarea2_1am) {
		this.causticunloadingarea2_1am = causticunloadingarea2_1am;
	}
	/**
	 * @return the causticunloadingarea2_5am
	 */
	public String getCausticunloadingarea2_5am() {
		return causticunloadingarea2_5am;
	}
	/**
	 * @param causticunloadingarea2_5am the causticunloadingarea2_5am to set
	 */
	public void setCausticunloadingarea2_5am(String causticunloadingarea2_5am) {
		this.causticunloadingarea2_5am = causticunloadingarea2_5am;
	}
	/**
	 * @return the clarifier1_freq
	 */
	public String getClarifier1_freq() {
		return clarifier1_freq;
	}
	/**
	 * @param clarifier1_freq the clarifier1_freq to set
	 */
	public void setClarifier1_freq(String clarifier1_freq) {
		this.clarifier1_freq = clarifier1_freq;
	}
	/**
	 * @return the clarifier1_9am
	 */
	public String getClarifier1_9am() {
		return clarifier1_9am;
	}
	/**
	 * @param clarifier1_9am the clarifier1_9am to set
	 */
	public void setClarifier1_9am(String clarifier1_9am) {
		this.clarifier1_9am = clarifier1_9am;
	}
	/**
	 * @return the clarifier1_1pm
	 */
	public String getClarifier1_1pm() {
		return clarifier1_1pm;
	}
	/**
	 * @param clarifier1_1pm the clarifier1_1pm to set
	 */
	public void setClarifier1_1pm(String clarifier1_1pm) {
		this.clarifier1_1pm = clarifier1_1pm;
	}
	/**
	 * @return the clarifier1_5pm
	 */
	public String getClarifier1_5pm() {
		return clarifier1_5pm;
	}
	/**
	 * @param clarifier1_5pm the clarifier1_5pm to set
	 */
	public void setClarifier1_5pm(String clarifier1_5pm) {
		this.clarifier1_5pm = clarifier1_5pm;
	}
	/**
	 * @return the clarifier1_9pm
	 */
	public String getClarifier1_9pm() {
		return clarifier1_9pm;
	}
	/**
	 * @param clarifier1_9pm the clarifier1_9pm to set
	 */
	public void setClarifier1_9pm(String clarifier1_9pm) {
		this.clarifier1_9pm = clarifier1_9pm;
	}
	/**
	 * @return the clarifier1_1am
	 */
	public String getClarifier1_1am() {
		return clarifier1_1am;
	}
	/**
	 * @param clarifier1_1am the clarifier1_1am to set
	 */
	public void setClarifier1_1am(String clarifier1_1am) {
		this.clarifier1_1am = clarifier1_1am;
	}
	/**
	 * @return the clarifier1_5am
	 */
	public String getClarifier1_5am() {
		return clarifier1_5am;
	}
	/**
	 * @param clarifier1_5am the clarifier1_5am to set
	 */
	public void setClarifier1_5am(String clarifier1_5am) {
		this.clarifier1_5am = clarifier1_5am;
	}
	/**
	 * @return the clarifier2_freq
	 */
	public String getClarifier2_freq() {
		return clarifier2_freq;
	}
	/**
	 * @param clarifier2_freq the clarifier2_freq to set
	 */
	public void setClarifier2_freq(String clarifier2_freq) {
		this.clarifier2_freq = clarifier2_freq;
	}
	/**
	 * @return the clarifier2_9am
	 */
	public String getClarifier2_9am() {
		return clarifier2_9am;
	}
	/**
	 * @param clarifier2_9am the clarifier2_9am to set
	 */
	public void setClarifier2_9am(String clarifier2_9am) {
		this.clarifier2_9am = clarifier2_9am;
	}
	/**
	 * @return the clarifier2_1pm
	 */
	public String getClarifier2_1pm() {
		return clarifier2_1pm;
	}
	/**
	 * @param clarifier2_1pm the clarifier2_1pm to set
	 */
	public void setClarifier2_1pm(String clarifier2_1pm) {
		this.clarifier2_1pm = clarifier2_1pm;
	}
	/**
	 * @return the clarifier2_5pm
	 */
	public String getClarifier2_5pm() {
		return clarifier2_5pm;
	}
	/**
	 * @param clarifier2_5pm the clarifier2_5pm to set
	 */
	public void setClarifier2_5pm(String clarifier2_5pm) {
		this.clarifier2_5pm = clarifier2_5pm;
	}
	/**
	 * @return the clarifier2_9pm
	 */
	public String getClarifier2_9pm() {
		return clarifier2_9pm;
	}
	/**
	 * @param clarifier2_9pm the clarifier2_9pm to set
	 */
	public void setClarifier2_9pm(String clarifier2_9pm) {
		this.clarifier2_9pm = clarifier2_9pm;
	}
	/**
	 * @return the clarifier2_1am
	 */
	public String getClarifier2_1am() {
		return clarifier2_1am;
	}
	/**
	 * @param clarifier2_1am the clarifier2_1am to set
	 */
	public void setClarifier2_1am(String clarifier2_1am) {
		this.clarifier2_1am = clarifier2_1am;
	}
	/**
	 * @return the clarifier2_5am
	 */
	public String getClarifier2_5am() {
		return clarifier2_5am;
	}
	/**
	 * @param clarifier2_5am the clarifier2_5am to set
	 */
	public void setClarifier2_5am(String clarifier2_5am) {
		this.clarifier2_5am = clarifier2_5am;
	}
	/**
	 * @return the clarifier3_freq
	 */
	public String getClarifier3_freq() {
		return clarifier3_freq;
	}
	/**
	 * @param clarifier3_freq the clarifier3_freq to set
	 */
	public void setClarifier3_freq(String clarifier3_freq) {
		this.clarifier3_freq = clarifier3_freq;
	}
	/**
	 * @return the clarifier3_9am
	 */
	public String getClarifier3_9am() {
		return clarifier3_9am;
	}
	/**
	 * @param clarifier3_9am the clarifier3_9am to set
	 */
	public void setClarifier3_9am(String clarifier3_9am) {
		this.clarifier3_9am = clarifier3_9am;
	}
	/**
	 * @return the clarifier3_1pm
	 */
	public String getClarifier3_1pm() {
		return clarifier3_1pm;
	}
	/**
	 * @param clarifier3_1pm the clarifier3_1pm to set
	 */
	public void setClarifier3_1pm(String clarifier3_1pm) {
		this.clarifier3_1pm = clarifier3_1pm;
	}
	/**
	 * @return the clarifier3_5pm
	 */
	public String getClarifier3_5pm() {
		return clarifier3_5pm;
	}
	/**
	 * @param clarifier3_5pm the clarifier3_5pm to set
	 */
	public void setClarifier3_5pm(String clarifier3_5pm) {
		this.clarifier3_5pm = clarifier3_5pm;
	}
	/**
	 * @return the clarifier3_9pm
	 */
	public String getClarifier3_9pm() {
		return clarifier3_9pm;
	}
	/**
	 * @param clarifier3_9pm the clarifier3_9pm to set
	 */
	public void setClarifier3_9pm(String clarifier3_9pm) {
		this.clarifier3_9pm = clarifier3_9pm;
	}
	/**
	 * @return the clarifier3_1am
	 */
	public String getClarifier3_1am() {
		return clarifier3_1am;
	}
	/**
	 * @param clarifier3_1am the clarifier3_1am to set
	 */
	public void setClarifier3_1am(String clarifier3_1am) {
		this.clarifier3_1am = clarifier3_1am;
	}
	/**
	 * @return the clarifier3_5am
	 */
	public String getClarifier3_5am() {
		return clarifier3_5am;
	}
	/**
	 * @param clarifier3_5am the clarifier3_5am to set
	 */
	public void setClarifier3_5am(String clarifier3_5am) {
		this.clarifier3_5am = clarifier3_5am;
	}
	/**
	 * @return the clarifier4_freq
	 */
	public String getClarifier4_freq() {
		return clarifier4_freq;
	}
	/**
	 * @param clarifier4_freq the clarifier4_freq to set
	 */
	public void setClarifier4_freq(String clarifier4_freq) {
		this.clarifier4_freq = clarifier4_freq;
	}
	/**
	 * @return the clarifier4_9am
	 */
	public String getClarifier4_9am() {
		return clarifier4_9am;
	}
	/**
	 * @param clarifier4_9am the clarifier4_9am to set
	 */
	public void setClarifier4_9am(String clarifier4_9am) {
		this.clarifier4_9am = clarifier4_9am;
	}
	/**
	 * @return the clarifier4_1pm
	 */
	public String getClarifier4_1pm() {
		return clarifier4_1pm;
	}
	/**
	 * @param clarifier4_1pm the clarifier4_1pm to set
	 */
	public void setClarifier4_1pm(String clarifier4_1pm) {
		this.clarifier4_1pm = clarifier4_1pm;
	}
	/**
	 * @return the clarifier4_5pm
	 */
	public String getClarifier4_5pm() {
		return clarifier4_5pm;
	}
	/**
	 * @param clarifier4_5pm the clarifier4_5pm to set
	 */
	public void setClarifier4_5pm(String clarifier4_5pm) {
		this.clarifier4_5pm = clarifier4_5pm;
	}
	/**
	 * @return the clarifier4_9pm
	 */
	public String getClarifier4_9pm() {
		return clarifier4_9pm;
	}
	/**
	 * @param clarifier4_9pm the clarifier4_9pm to set
	 */
	public void setClarifier4_9pm(String clarifier4_9pm) {
		this.clarifier4_9pm = clarifier4_9pm;
	}
	/**
	 * @return the clarifier4_1am
	 */
	public String getClarifier4_1am() {
		return clarifier4_1am;
	}
	/**
	 * @param clarifier4_1am the clarifier4_1am to set
	 */
	public void setClarifier4_1am(String clarifier4_1am) {
		this.clarifier4_1am = clarifier4_1am;
	}
	/**
	 * @return the clarifier4_5am
	 */
	public String getClarifier4_5am() {
		return clarifier4_5am;
	}
	/**
	 * @param clarifier4_5am the clarifier4_5am to set
	 */
	public void setClarifier4_5am(String clarifier4_5am) {
		this.clarifier4_5am = clarifier4_5am;
	}
	/**
	 * @return the clarifier5_freq
	 */
	public String getClarifier5_freq() {
		return clarifier5_freq;
	}
	/**
	 * @param clarifier5_freq the clarifier5_freq to set
	 */
	public void setClarifier5_freq(String clarifier5_freq) {
		this.clarifier5_freq = clarifier5_freq;
	}
	/**
	 * @return the clarifier5_9am
	 */
	public String getClarifier5_9am() {
		return clarifier5_9am;
	}
	/**
	 * @param clarifier5_9am the clarifier5_9am to set
	 */
	public void setClarifier5_9am(String clarifier5_9am) {
		this.clarifier5_9am = clarifier5_9am;
	}
	/**
	 * @return the clarifier5_1pm
	 */
	public String getClarifier5_1pm() {
		return clarifier5_1pm;
	}
	/**
	 * @param clarifier5_1pm the clarifier5_1pm to set
	 */
	public void setClarifier5_1pm(String clarifier5_1pm) {
		this.clarifier5_1pm = clarifier5_1pm;
	}
	/**
	 * @return the clarifier5_5pm
	 */
	public String getClarifier5_5pm() {
		return clarifier5_5pm;
	}
	/**
	 * @param clarifier5_5pm the clarifier5_5pm to set
	 */
	public void setClarifier5_5pm(String clarifier5_5pm) {
		this.clarifier5_5pm = clarifier5_5pm;
	}
	/**
	 * @return the clarifier5_9pm
	 */
	public String getClarifier5_9pm() {
		return clarifier5_9pm;
	}
	/**
	 * @param clarifier5_9pm the clarifier5_9pm to set
	 */
	public void setClarifier5_9pm(String clarifier5_9pm) {
		this.clarifier5_9pm = clarifier5_9pm;
	}
	/**
	 * @return the clarifier5_1am
	 */
	public String getClarifier5_1am() {
		return clarifier5_1am;
	}
	/**
	 * @param clarifier5_1am the clarifier5_1am to set
	 */
	public void setClarifier5_1am(String clarifier5_1am) {
		this.clarifier5_1am = clarifier5_1am;
	}
	/**
	 * @return the clarifier5_5am
	 */
	public String getClarifier5_5am() {
		return clarifier5_5am;
	}
	/**
	 * @param clarifier5_5am the clarifier5_5am to set
	 */
	public void setClarifier5_5am(String clarifier5_5am) {
		this.clarifier5_5am = clarifier5_5am;
	}
	/**
	 * @return the sludgepumpsdikedrain1_freq
	 */
	public String getSludgepumpsdikedrain1_freq() {
		return sludgepumpsdikedrain1_freq;
	}
	/**
	 * @param sludgepumpsdikedrain1_freq the sludgepumpsdikedrain1_freq to set
	 */
	public void setSludgepumpsdikedrain1_freq(String sludgepumpsdikedrain1_freq) {
		this.sludgepumpsdikedrain1_freq = sludgepumpsdikedrain1_freq;
	}
	/**
	 * @return the sludgepumpsdikedrain1_9am
	 */
	public String getSludgepumpsdikedrain1_9am() {
		return sludgepumpsdikedrain1_9am;
	}
	/**
	 * @param sludgepumpsdikedrain1_9am the sludgepumpsdikedrain1_9am to set
	 */
	public void setSludgepumpsdikedrain1_9am(String sludgepumpsdikedrain1_9am) {
		this.sludgepumpsdikedrain1_9am = sludgepumpsdikedrain1_9am;
	}
	/**
	 * @return the sludgepumpsdikedrain1_1pm
	 */
	public String getSludgepumpsdikedrain1_1pm() {
		return sludgepumpsdikedrain1_1pm;
	}
	/**
	 * @param sludgepumpsdikedrain1_1pm the sludgepumpsdikedrain1_1pm to set
	 */
	public void setSludgepumpsdikedrain1_1pm(String sludgepumpsdikedrain1_1pm) {
		this.sludgepumpsdikedrain1_1pm = sludgepumpsdikedrain1_1pm;
	}
	/**
	 * @return the sludgepumpsdikedrain1_5pm
	 */
	public String getSludgepumpsdikedrain1_5pm() {
		return sludgepumpsdikedrain1_5pm;
	}
	/**
	 * @param sludgepumpsdikedrain1_5pm the sludgepumpsdikedrain1_5pm to set
	 */
	public void setSludgepumpsdikedrain1_5pm(String sludgepumpsdikedrain1_5pm) {
		this.sludgepumpsdikedrain1_5pm = sludgepumpsdikedrain1_5pm;
	}
	/**
	 * @return the sludgepumpsdikedrain1_9pm
	 */
	public String getSludgepumpsdikedrain1_9pm() {
		return sludgepumpsdikedrain1_9pm;
	}
	/**
	 * @param sludgepumpsdikedrain1_9pm the sludgepumpsdikedrain1_9pm to set
	 */
	public void setSludgepumpsdikedrain1_9pm(String sludgepumpsdikedrain1_9pm) {
		this.sludgepumpsdikedrain1_9pm = sludgepumpsdikedrain1_9pm;
	}
	/**
	 * @return the sludgepumpsdikedrain1_1am
	 */
	public String getSludgepumpsdikedrain1_1am() {
		return sludgepumpsdikedrain1_1am;
	}
	/**
	 * @param sludgepumpsdikedrain1_1am the sludgepumpsdikedrain1_1am to set
	 */
	public void setSludgepumpsdikedrain1_1am(String sludgepumpsdikedrain1_1am) {
		this.sludgepumpsdikedrain1_1am = sludgepumpsdikedrain1_1am;
	}
	/**
	 * @return the sludgepumpsdikedrain1_5am
	 */
	public String getSludgepumpsdikedrain1_5am() {
		return sludgepumpsdikedrain1_5am;
	}
	/**
	 * @param sludgepumpsdikedrain1_5am the sludgepumpsdikedrain1_5am to set
	 */
	public void setSludgepumpsdikedrain1_5am(String sludgepumpsdikedrain1_5am) {
		this.sludgepumpsdikedrain1_5am = sludgepumpsdikedrain1_5am;
	}
	/**
	 * @return the sludgepumpsdikedrain2_freq
	 */
	public String getSludgepumpsdikedrain2_freq() {
		return sludgepumpsdikedrain2_freq;
	}
	/**
	 * @param sludgepumpsdikedrain2_freq the sludgepumpsdikedrain2_freq to set
	 */
	public void setSludgepumpsdikedrain2_freq(String sludgepumpsdikedrain2_freq) {
		this.sludgepumpsdikedrain2_freq = sludgepumpsdikedrain2_freq;
	}
	/**
	 * @return the sludgepumpsdikedrain2_9am
	 */
	public String getSludgepumpsdikedrain2_9am() {
		return sludgepumpsdikedrain2_9am;
	}
	/**
	 * @param sludgepumpsdikedrain2_9am the sludgepumpsdikedrain2_9am to set
	 */
	public void setSludgepumpsdikedrain2_9am(String sludgepumpsdikedrain2_9am) {
		this.sludgepumpsdikedrain2_9am = sludgepumpsdikedrain2_9am;
	}
	/**
	 * @return the sludgepumpsdikedrain2_1pm
	 */
	public String getSludgepumpsdikedrain2_1pm() {
		return sludgepumpsdikedrain2_1pm;
	}
	/**
	 * @param sludgepumpsdikedrain2_1pm the sludgepumpsdikedrain2_1pm to set
	 */
	public void setSludgepumpsdikedrain2_1pm(String sludgepumpsdikedrain2_1pm) {
		this.sludgepumpsdikedrain2_1pm = sludgepumpsdikedrain2_1pm;
	}
	/**
	 * @return the sludgepumpsdikedrain2_5pm
	 */
	public String getSludgepumpsdikedrain2_5pm() {
		return sludgepumpsdikedrain2_5pm;
	}
	/**
	 * @param sludgepumpsdikedrain2_5pm the sludgepumpsdikedrain2_5pm to set
	 */
	public void setSludgepumpsdikedrain2_5pm(String sludgepumpsdikedrain2_5pm) {
		this.sludgepumpsdikedrain2_5pm = sludgepumpsdikedrain2_5pm;
	}
	/**
	 * @return the sludgepumpsdikedrain2_9pm
	 */
	public String getSludgepumpsdikedrain2_9pm() {
		return sludgepumpsdikedrain2_9pm;
	}
	/**
	 * @param sludgepumpsdikedrain2_9pm the sludgepumpsdikedrain2_9pm to set
	 */
	public void setSludgepumpsdikedrain2_9pm(String sludgepumpsdikedrain2_9pm) {
		this.sludgepumpsdikedrain2_9pm = sludgepumpsdikedrain2_9pm;
	}
	/**
	 * @return the sludgepumpsdikedrain2_1am
	 */
	public String getSludgepumpsdikedrain2_1am() {
		return sludgepumpsdikedrain2_1am;
	}
	/**
	 * @param sludgepumpsdikedrain2_1am the sludgepumpsdikedrain2_1am to set
	 */
	public void setSludgepumpsdikedrain2_1am(String sludgepumpsdikedrain2_1am) {
		this.sludgepumpsdikedrain2_1am = sludgepumpsdikedrain2_1am;
	}
	/**
	 * @return the sludgepumpsdikedrain2_5am
	 */
	public String getSludgepumpsdikedrain2_5am() {
		return sludgepumpsdikedrain2_5am;
	}
	/**
	 * @param sludgepumpsdikedrain2_5am the sludgepumpsdikedrain2_5am to set
	 */
	public void setSludgepumpsdikedrain2_5am(String sludgepumpsdikedrain2_5am) {
		this.sludgepumpsdikedrain2_5am = sludgepumpsdikedrain2_5am;
	}
	/**
	 * @return the mill_firewatersystem1_freq
	 */
	public String getMill_firewatersystem1_freq() {
		return mill_firewatersystem1_freq;
	}
	/**
	 * @param mill_firewatersystem1_freq the mill_firewatersystem1_freq to set
	 */
	public void setMill_firewatersystem1_freq(String mill_firewatersystem1_freq) {
		this.mill_firewatersystem1_freq = mill_firewatersystem1_freq;
	}
	/**
	 * @return the mill_firewatersystem1_9am
	 */
	public String getMill_firewatersystem1_9am() {
		return mill_firewatersystem1_9am;
	}
	/**
	 * @param mill_firewatersystem1_9am the mill_firewatersystem1_9am to set
	 */
	public void setMill_firewatersystem1_9am(String mill_firewatersystem1_9am) {
		this.mill_firewatersystem1_9am = mill_firewatersystem1_9am;
	}
	/**
	 * @return the mill_firewatersystem1_1pm
	 */
	public String getMill_firewatersystem1_1pm() {
		return mill_firewatersystem1_1pm;
	}
	/**
	 * @param mill_firewatersystem1_1pm the mill_firewatersystem1_1pm to set
	 */
	public void setMill_firewatersystem1_1pm(String mill_firewatersystem1_1pm) {
		this.mill_firewatersystem1_1pm = mill_firewatersystem1_1pm;
	}
	/**
	 * @return the mill_firewatersystem1_5pm
	 */
	public String getMill_firewatersystem1_5pm() {
		return mill_firewatersystem1_5pm;
	}
	/**
	 * @param mill_firewatersystem1_5pm the mill_firewatersystem1_5pm to set
	 */
	public void setMill_firewatersystem1_5pm(String mill_firewatersystem1_5pm) {
		this.mill_firewatersystem1_5pm = mill_firewatersystem1_5pm;
	}
	/**
	 * @return the mill_firewatersystem1_9pm
	 */
	public String getMill_firewatersystem1_9pm() {
		return mill_firewatersystem1_9pm;
	}
	/**
	 * @param mill_firewatersystem1_9pm the mill_firewatersystem1_9pm to set
	 */
	public void setMill_firewatersystem1_9pm(String mill_firewatersystem1_9pm) {
		this.mill_firewatersystem1_9pm = mill_firewatersystem1_9pm;
	}
	/**
	 * @return the mill_firewatersystem1_1am
	 */
	public String getMill_firewatersystem1_1am() {
		return mill_firewatersystem1_1am;
	}
	/**
	 * @param mill_firewatersystem1_1am the mill_firewatersystem1_1am to set
	 */
	public void setMill_firewatersystem1_1am(String mill_firewatersystem1_1am) {
		this.mill_firewatersystem1_1am = mill_firewatersystem1_1am;
	}
	/**
	 * @return the mill_firewatersystem1_5am
	 */
	public String getMill_firewatersystem1_5am() {
		return mill_firewatersystem1_5am;
	}
	/**
	 * @param mill_firewatersystem1_5am the mill_firewatersystem1_5am to set
	 */
	public void setMill_firewatersystem1_5am(String mill_firewatersystem1_5am) {
		this.mill_firewatersystem1_5am = mill_firewatersystem1_5am;
	}
	/**
	 * @return the mill_firewatersystem2_freq
	 */
	public String getMill_firewatersystem2_freq() {
		return mill_firewatersystem2_freq;
	}
	/**
	 * @param mill_firewatersystem2_freq the mill_firewatersystem2_freq to set
	 */
	public void setMill_firewatersystem2_freq(String mill_firewatersystem2_freq) {
		this.mill_firewatersystem2_freq = mill_firewatersystem2_freq;
	}
	/**
	 * @return the mill_firewatersystem2_9am
	 */
	public String getMill_firewatersystem2_9am() {
		return mill_firewatersystem2_9am;
	}
	/**
	 * @param mill_firewatersystem2_9am the mill_firewatersystem2_9am to set
	 */
	public void setMill_firewatersystem2_9am(String mill_firewatersystem2_9am) {
		this.mill_firewatersystem2_9am = mill_firewatersystem2_9am;
	}
	/**
	 * @return the mill_firewatersystem2_1pm
	 */
	public String getMill_firewatersystem2_1pm() {
		return mill_firewatersystem2_1pm;
	}
	/**
	 * @param mill_firewatersystem2_1pm the mill_firewatersystem2_1pm to set
	 */
	public void setMill_firewatersystem2_1pm(String mill_firewatersystem2_1pm) {
		this.mill_firewatersystem2_1pm = mill_firewatersystem2_1pm;
	}
	/**
	 * @return the mill_firewatersystem2_5pm
	 */
	public String getMill_firewatersystem2_5pm() {
		return mill_firewatersystem2_5pm;
	}
	/**
	 * @param mill_firewatersystem2_5pm the mill_firewatersystem2_5pm to set
	 */
	public void setMill_firewatersystem2_5pm(String mill_firewatersystem2_5pm) {
		this.mill_firewatersystem2_5pm = mill_firewatersystem2_5pm;
	}
	/**
	 * @return the mill_firewatersystem2_9pm
	 */
	public String getMill_firewatersystem2_9pm() {
		return mill_firewatersystem2_9pm;
	}
	/**
	 * @param mill_firewatersystem2_9pm the mill_firewatersystem2_9pm to set
	 */
	public void setMill_firewatersystem2_9pm(String mill_firewatersystem2_9pm) {
		this.mill_firewatersystem2_9pm = mill_firewatersystem2_9pm;
	}
	/**
	 * @return the mill_firewatersystem2_1am
	 */
	public String getMill_firewatersystem2_1am() {
		return mill_firewatersystem2_1am;
	}
	/**
	 * @param mill_firewatersystem2_1am the mill_firewatersystem2_1am to set
	 */
	public void setMill_firewatersystem2_1am(String mill_firewatersystem2_1am) {
		this.mill_firewatersystem2_1am = mill_firewatersystem2_1am;
	}
	/**
	 * @return the mill_firewatersystem2_5am
	 */
	public String getMill_firewatersystem2_5am() {
		return mill_firewatersystem2_5am;
	}
	/**
	 * @param mill_firewatersystem2_5am the mill_firewatersystem2_5am to set
	 */
	public void setMill_firewatersystem2_5am(String mill_firewatersystem2_5am) {
		this.mill_firewatersystem2_5am = mill_firewatersystem2_5am;
	}
	/**
	 * @return the mill_firewatersystem3_freq
	 */
	public String getMill_firewatersystem3_freq() {
		return mill_firewatersystem3_freq;
	}
	/**
	 * @param mill_firewatersystem3_freq the mill_firewatersystem3_freq to set
	 */
	public void setMill_firewatersystem3_freq(String mill_firewatersystem3_freq) {
		this.mill_firewatersystem3_freq = mill_firewatersystem3_freq;
	}
	/**
	 * @return the mill_firewatersystem3_9am
	 */
	public String getMill_firewatersystem3_9am() {
		return mill_firewatersystem3_9am;
	}
	/**
	 * @param mill_firewatersystem3_9am the mill_firewatersystem3_9am to set
	 */
	public void setMill_firewatersystem3_9am(String mill_firewatersystem3_9am) {
		this.mill_firewatersystem3_9am = mill_firewatersystem3_9am;
	}
	/**
	 * @return the mill_firewatersystem3_1pm
	 */
	public String getMill_firewatersystem3_1pm() {
		return mill_firewatersystem3_1pm;
	}
	/**
	 * @param mill_firewatersystem3_1pm the mill_firewatersystem3_1pm to set
	 */
	public void setMill_firewatersystem3_1pm(String mill_firewatersystem3_1pm) {
		this.mill_firewatersystem3_1pm = mill_firewatersystem3_1pm;
	}
	/**
	 * @return the mill_firewatersystem3_5pm
	 */
	public String getMill_firewatersystem3_5pm() {
		return mill_firewatersystem3_5pm;
	}
	/**
	 * @param mill_firewatersystem3_5pm the mill_firewatersystem3_5pm to set
	 */
	public void setMill_firewatersystem3_5pm(String mill_firewatersystem3_5pm) {
		this.mill_firewatersystem3_5pm = mill_firewatersystem3_5pm;
	}
	/**
	 * @return the mill_firewatersystem3_9pm
	 */
	public String getMill_firewatersystem3_9pm() {
		return mill_firewatersystem3_9pm;
	}
	/**
	 * @param mill_firewatersystem3_9pm the mill_firewatersystem3_9pm to set
	 */
	public void setMill_firewatersystem3_9pm(String mill_firewatersystem3_9pm) {
		this.mill_firewatersystem3_9pm = mill_firewatersystem3_9pm;
	}
	/**
	 * @return the mill_firewatersystem3_1am
	 */
	public String getMill_firewatersystem3_1am() {
		return mill_firewatersystem3_1am;
	}
	/**
	 * @param mill_firewatersystem3_1am the mill_firewatersystem3_1am to set
	 */
	public void setMill_firewatersystem3_1am(String mill_firewatersystem3_1am) {
		this.mill_firewatersystem3_1am = mill_firewatersystem3_1am;
	}
	/**
	 * @return the mill_firewatersystem3_5am
	 */
	public String getMill_firewatersystem3_5am() {
		return mill_firewatersystem3_5am;
	}
	/**
	 * @param mill_firewatersystem3_5am the mill_firewatersystem3_5am to set
	 */
	public void setMill_firewatersystem3_5am(String mill_firewatersystem3_5am) {
		this.mill_firewatersystem3_5am = mill_firewatersystem3_5am;
	}
	/**
	 * @return the mill_firewatersystem4_freq
	 */
	public String getMill_firewatersystem4_freq() {
		return mill_firewatersystem4_freq;
	}
	/**
	 * @param mill_firewatersystem4_freq the mill_firewatersystem4_freq to set
	 */
	public void setMill_firewatersystem4_freq(String mill_firewatersystem4_freq) {
		this.mill_firewatersystem4_freq = mill_firewatersystem4_freq;
	}
	/**
	 * @return the mill_firewatersystem4_9am
	 */
	public String getMill_firewatersystem4_9am() {
		return mill_firewatersystem4_9am;
	}
	/**
	 * @param mill_firewatersystem4_9am the mill_firewatersystem4_9am to set
	 */
	public void setMill_firewatersystem4_9am(String mill_firewatersystem4_9am) {
		this.mill_firewatersystem4_9am = mill_firewatersystem4_9am;
	}
	/**
	 * @return the mill_firewatersystem4_1pm
	 */
	public String getMill_firewatersystem4_1pm() {
		return mill_firewatersystem4_1pm;
	}
	/**
	 * @param mill_firewatersystem4_1pm the mill_firewatersystem4_1pm to set
	 */
	public void setMill_firewatersystem4_1pm(String mill_firewatersystem4_1pm) {
		this.mill_firewatersystem4_1pm = mill_firewatersystem4_1pm;
	}
	/**
	 * @return the mill_firewatersystem4_5pm
	 */
	public String getMill_firewatersystem4_5pm() {
		return mill_firewatersystem4_5pm;
	}
	/**
	 * @param mill_firewatersystem4_5pm the mill_firewatersystem4_5pm to set
	 */
	public void setMill_firewatersystem4_5pm(String mill_firewatersystem4_5pm) {
		this.mill_firewatersystem4_5pm = mill_firewatersystem4_5pm;
	}
	/**
	 * @return the mill_firewatersystem4_9pm
	 */
	public String getMill_firewatersystem4_9pm() {
		return mill_firewatersystem4_9pm;
	}
	/**
	 * @param mill_firewatersystem4_9pm the mill_firewatersystem4_9pm to set
	 */
	public void setMill_firewatersystem4_9pm(String mill_firewatersystem4_9pm) {
		this.mill_firewatersystem4_9pm = mill_firewatersystem4_9pm;
	}
	/**
	 * @return the mill_firewatersystem4_1am
	 */
	public String getMill_firewatersystem4_1am() {
		return mill_firewatersystem4_1am;
	}
	/**
	 * @param mill_firewatersystem4_1am the mill_firewatersystem4_1am to set
	 */
	public void setMill_firewatersystem4_1am(String mill_firewatersystem4_1am) {
		this.mill_firewatersystem4_1am = mill_firewatersystem4_1am;
	}
	/**
	 * @return the mill_firewatersystem4_5am
	 */
	public String getMill_firewatersystem4_5am() {
		return mill_firewatersystem4_5am;
	}
	/**
	 * @param mill_firewatersystem4_5am the mill_firewatersystem4_5am to set
	 */
	public void setMill_firewatersystem4_5am(String mill_firewatersystem4_5am) {
		this.mill_firewatersystem4_5am = mill_firewatersystem4_5am;
	}
	/**
	 * @return the mill_firewatersystem5_freq
	 */
	public String getMill_firewatersystem5_freq() {
		return mill_firewatersystem5_freq;
	}
	/**
	 * @param mill_firewatersystem5_freq the mill_firewatersystem5_freq to set
	 */
	public void setMill_firewatersystem5_freq(String mill_firewatersystem5_freq) {
		this.mill_firewatersystem5_freq = mill_firewatersystem5_freq;
	}
	/**
	 * @return the mill_firewatersystem5_9am
	 */
	public String getMill_firewatersystem5_9am() {
		return mill_firewatersystem5_9am;
	}
	/**
	 * @param mill_firewatersystem5_9am the mill_firewatersystem5_9am to set
	 */
	public void setMill_firewatersystem5_9am(String mill_firewatersystem5_9am) {
		this.mill_firewatersystem5_9am = mill_firewatersystem5_9am;
	}
	/**
	 * @return the mill_firewatersystem5_1pm
	 */
	public String getMill_firewatersystem5_1pm() {
		return mill_firewatersystem5_1pm;
	}
	/**
	 * @param mill_firewatersystem5_1pm the mill_firewatersystem5_1pm to set
	 */
	public void setMill_firewatersystem5_1pm(String mill_firewatersystem5_1pm) {
		this.mill_firewatersystem5_1pm = mill_firewatersystem5_1pm;
	}
	/**
	 * @return the mill_firewatersystem5_5pm
	 */
	public String getMill_firewatersystem5_5pm() {
		return mill_firewatersystem5_5pm;
	}
	/**
	 * @param mill_firewatersystem5_5pm the mill_firewatersystem5_5pm to set
	 */
	public void setMill_firewatersystem5_5pm(String mill_firewatersystem5_5pm) {
		this.mill_firewatersystem5_5pm = mill_firewatersystem5_5pm;
	}
	/**
	 * @return the mill_firewatersystem5_9pm
	 */
	public String getMill_firewatersystem5_9pm() {
		return mill_firewatersystem5_9pm;
	}
	/**
	 * @param mill_firewatersystem5_9pm the mill_firewatersystem5_9pm to set
	 */
	public void setMill_firewatersystem5_9pm(String mill_firewatersystem5_9pm) {
		this.mill_firewatersystem5_9pm = mill_firewatersystem5_9pm;
	}
	/**
	 * @return the mill_firewatersystem5_1am
	 */
	public String getMill_firewatersystem5_1am() {
		return mill_firewatersystem5_1am;
	}
	/**
	 * @param mill_firewatersystem5_1am the mill_firewatersystem5_1am to set
	 */
	public void setMill_firewatersystem5_1am(String mill_firewatersystem5_1am) {
		this.mill_firewatersystem5_1am = mill_firewatersystem5_1am;
	}
	/**
	 * @return the mill_firewatersystem5_5am
	 */
	public String getMill_firewatersystem5_5am() {
		return mill_firewatersystem5_5am;
	}
	/**
	 * @param mill_firewatersystem5_5am the mill_firewatersystem5_5am to set
	 */
	public void setMill_firewatersystem5_5am(String mill_firewatersystem5_5am) {
		this.mill_firewatersystem5_5am = mill_firewatersystem5_5am;
	}
	/**
	 * @return the mill_firewatersystem6_freq
	 */
	public String getMill_firewatersystem6_freq() {
		return mill_firewatersystem6_freq;
	}
	/**
	 * @param mill_firewatersystem6_freq the mill_firewatersystem6_freq to set
	 */
	public void setMill_firewatersystem6_freq(String mill_firewatersystem6_freq) {
		this.mill_firewatersystem6_freq = mill_firewatersystem6_freq;
	}
	/**
	 * @return the mill_firewatersystem6_9am
	 */
	public String getMill_firewatersystem6_9am() {
		return mill_firewatersystem6_9am;
	}
	/**
	 * @param mill_firewatersystem6_9am the mill_firewatersystem6_9am to set
	 */
	public void setMill_firewatersystem6_9am(String mill_firewatersystem6_9am) {
		this.mill_firewatersystem6_9am = mill_firewatersystem6_9am;
	}
	/**
	 * @return the mill_firewatersystem6_1pm
	 */
	public String getMill_firewatersystem6_1pm() {
		return mill_firewatersystem6_1pm;
	}
	/**
	 * @param mill_firewatersystem6_1pm the mill_firewatersystem6_1pm to set
	 */
	public void setMill_firewatersystem6_1pm(String mill_firewatersystem6_1pm) {
		this.mill_firewatersystem6_1pm = mill_firewatersystem6_1pm;
	}
	/**
	 * @return the mill_firewatersystem6_5pm
	 */
	public String getMill_firewatersystem6_5pm() {
		return mill_firewatersystem6_5pm;
	}
	/**
	 * @param mill_firewatersystem6_5pm the mill_firewatersystem6_5pm to set
	 */
	public void setMill_firewatersystem6_5pm(String mill_firewatersystem6_5pm) {
		this.mill_firewatersystem6_5pm = mill_firewatersystem6_5pm;
	}
	/**
	 * @return the mill_firewatersystem6_9pm
	 */
	public String getMill_firewatersystem6_9pm() {
		return mill_firewatersystem6_9pm;
	}
	/**
	 * @param mill_firewatersystem6_9pm the mill_firewatersystem6_9pm to set
	 */
	public void setMill_firewatersystem6_9pm(String mill_firewatersystem6_9pm) {
		this.mill_firewatersystem6_9pm = mill_firewatersystem6_9pm;
	}
	/**
	 * @return the mill_firewatersystem6_1am
	 */
	public String getMill_firewatersystem6_1am() {
		return mill_firewatersystem6_1am;
	}
	/**
	 * @param mill_firewatersystem6_1am the mill_firewatersystem6_1am to set
	 */
	public void setMill_firewatersystem6_1am(String mill_firewatersystem6_1am) {
		this.mill_firewatersystem6_1am = mill_firewatersystem6_1am;
	}
	/**
	 * @return the mill_firewatersystem6_5am
	 */
	public String getMill_firewatersystem6_5am() {
		return mill_firewatersystem6_5am;
	}
	/**
	 * @param mill_firewatersystem6_5am the mill_firewatersystem6_5am to set
	 */
	public void setMill_firewatersystem6_5am(String mill_firewatersystem6_5am) {
		this.mill_firewatersystem6_5am = mill_firewatersystem6_5am;
	}
	/**
	 * @return the mill_firewatersystem7_freq
	 */
	public String getMill_firewatersystem7_freq() {
		return mill_firewatersystem7_freq;
	}
	/**
	 * @param mill_firewatersystem7_freq the mill_firewatersystem7_freq to set
	 */
	public void setMill_firewatersystem7_freq(String mill_firewatersystem7_freq) {
		this.mill_firewatersystem7_freq = mill_firewatersystem7_freq;
	}
	/**
	 * @return the mill_firewatersystem7_9am
	 */
	public String getMill_firewatersystem7_9am() {
		return mill_firewatersystem7_9am;
	}
	/**
	 * @param mill_firewatersystem7_9am the mill_firewatersystem7_9am to set
	 */
	public void setMill_firewatersystem7_9am(String mill_firewatersystem7_9am) {
		this.mill_firewatersystem7_9am = mill_firewatersystem7_9am;
	}
	/**
	 * @return the mill_firewatersystem7_1pm
	 */
	public String getMill_firewatersystem7_1pm() {
		return mill_firewatersystem7_1pm;
	}
	/**
	 * @param mill_firewatersystem7_1pm the mill_firewatersystem7_1pm to set
	 */
	public void setMill_firewatersystem7_1pm(String mill_firewatersystem7_1pm) {
		this.mill_firewatersystem7_1pm = mill_firewatersystem7_1pm;
	}
	/**
	 * @return the mill_firewatersystem7_5pm
	 */
	public String getMill_firewatersystem7_5pm() {
		return mill_firewatersystem7_5pm;
	}
	/**
	 * @param mill_firewatersystem7_5pm the mill_firewatersystem7_5pm to set
	 */
	public void setMill_firewatersystem7_5pm(String mill_firewatersystem7_5pm) {
		this.mill_firewatersystem7_5pm = mill_firewatersystem7_5pm;
	}
	/**
	 * @return the mill_firewatersystem7_9pm
	 */
	public String getMill_firewatersystem7_9pm() {
		return mill_firewatersystem7_9pm;
	}
	/**
	 * @param mill_firewatersystem7_9pm the mill_firewatersystem7_9pm to set
	 */
	public void setMill_firewatersystem7_9pm(String mill_firewatersystem7_9pm) {
		this.mill_firewatersystem7_9pm = mill_firewatersystem7_9pm;
	}
	/**
	 * @return the mill_firewatersystem7_1am
	 */
	public String getMill_firewatersystem7_1am() {
		return mill_firewatersystem7_1am;
	}
	/**
	 * @param mill_firewatersystem7_1am the mill_firewatersystem7_1am to set
	 */
	public void setMill_firewatersystem7_1am(String mill_firewatersystem7_1am) {
		this.mill_firewatersystem7_1am = mill_firewatersystem7_1am;
	}
	/**
	 * @return the mill_firewatersystem7_5am
	 */
	public String getMill_firewatersystem7_5am() {
		return mill_firewatersystem7_5am;
	}
	/**
	 * @param mill_firewatersystem7_5am the mill_firewatersystem7_5am to set
	 */
	public void setMill_firewatersystem7_5am(String mill_firewatersystem7_5am) {
		this.mill_firewatersystem7_5am = mill_firewatersystem7_5am;
	}
	/**
	 * @return the plantaircompressors1_freq
	 */
	public String getPlantaircompressors1_freq() {
		return plantaircompressors1_freq;
	}
	/**
	 * @param plantaircompressors1_freq the plantaircompressors1_freq to set
	 */
	public void setPlantaircompressors1_freq(String plantaircompressors1_freq) {
		this.plantaircompressors1_freq = plantaircompressors1_freq;
	}
	/**
	 * @return the plantaircompressors1_9am
	 */
	public String getPlantaircompressors1_9am() {
		return plantaircompressors1_9am;
	}
	/**
	 * @param plantaircompressors1_9am the plantaircompressors1_9am to set
	 */
	public void setPlantaircompressors1_9am(String plantaircompressors1_9am) {
		this.plantaircompressors1_9am = plantaircompressors1_9am;
	}
	/**
	 * @return the plantaircompressors1_1pm
	 */
	public String getPlantaircompressors1_1pm() {
		return plantaircompressors1_1pm;
	}
	/**
	 * @param plantaircompressors1_1pm the plantaircompressors1_1pm to set
	 */
	public void setPlantaircompressors1_1pm(String plantaircompressors1_1pm) {
		this.plantaircompressors1_1pm = plantaircompressors1_1pm;
	}
	/**
	 * @return the plantaircompressors1_5pm
	 */
	public String getPlantaircompressors1_5pm() {
		return plantaircompressors1_5pm;
	}
	/**
	 * @param plantaircompressors1_5pm the plantaircompressors1_5pm to set
	 */
	public void setPlantaircompressors1_5pm(String plantaircompressors1_5pm) {
		this.plantaircompressors1_5pm = plantaircompressors1_5pm;
	}
	/**
	 * @return the plantaircompressors1_9pm
	 */
	public String getPlantaircompressors1_9pm() {
		return plantaircompressors1_9pm;
	}
	/**
	 * @param plantaircompressors1_9pm the plantaircompressors1_9pm to set
	 */
	public void setPlantaircompressors1_9pm(String plantaircompressors1_9pm) {
		this.plantaircompressors1_9pm = plantaircompressors1_9pm;
	}
	/**
	 * @return the plantaircompressors1_1am
	 */
	public String getPlantaircompressors1_1am() {
		return plantaircompressors1_1am;
	}
	/**
	 * @param plantaircompressors1_1am the plantaircompressors1_1am to set
	 */
	public void setPlantaircompressors1_1am(String plantaircompressors1_1am) {
		this.plantaircompressors1_1am = plantaircompressors1_1am;
	}
	/**
	 * @return the plantaircompressors1_5am
	 */
	public String getPlantaircompressors1_5am() {
		return plantaircompressors1_5am;
	}
	/**
	 * @param plantaircompressors1_5am the plantaircompressors1_5am to set
	 */
	public void setPlantaircompressors1_5am(String plantaircompressors1_5am) {
		this.plantaircompressors1_5am = plantaircompressors1_5am;
	}
	/**
	 * @return the plantaircompressors2_freq
	 */
	public String getPlantaircompressors2_freq() {
		return plantaircompressors2_freq;
	}
	/**
	 * @param plantaircompressors2_freq the plantaircompressors2_freq to set
	 */
	public void setPlantaircompressors2_freq(String plantaircompressors2_freq) {
		this.plantaircompressors2_freq = plantaircompressors2_freq;
	}
	/**
	 * @return the plantaircompressors2_9am
	 */
	public String getPlantaircompressors2_9am() {
		return plantaircompressors2_9am;
	}
	/**
	 * @param plantaircompressors2_9am the plantaircompressors2_9am to set
	 */
	public void setPlantaircompressors2_9am(String plantaircompressors2_9am) {
		this.plantaircompressors2_9am = plantaircompressors2_9am;
	}
	/**
	 * @return the plantaircompressors2_1pm
	 */
	public String getPlantaircompressors2_1pm() {
		return plantaircompressors2_1pm;
	}
	/**
	 * @param plantaircompressors2_1pm the plantaircompressors2_1pm to set
	 */
	public void setPlantaircompressors2_1pm(String plantaircompressors2_1pm) {
		this.plantaircompressors2_1pm = plantaircompressors2_1pm;
	}
	/**
	 * @return the plantaircompressors2_5pm
	 */
	public String getPlantaircompressors2_5pm() {
		return plantaircompressors2_5pm;
	}
	/**
	 * @param plantaircompressors2_5pm the plantaircompressors2_5pm to set
	 */
	public void setPlantaircompressors2_5pm(String plantaircompressors2_5pm) {
		this.plantaircompressors2_5pm = plantaircompressors2_5pm;
	}
	/**
	 * @return the plantaircompressors2_9pm
	 */
	public String getPlantaircompressors2_9pm() {
		return plantaircompressors2_9pm;
	}
	/**
	 * @param plantaircompressors2_9pm the plantaircompressors2_9pm to set
	 */
	public void setPlantaircompressors2_9pm(String plantaircompressors2_9pm) {
		this.plantaircompressors2_9pm = plantaircompressors2_9pm;
	}
	/**
	 * @return the plantaircompressors2_1am
	 */
	public String getPlantaircompressors2_1am() {
		return plantaircompressors2_1am;
	}
	/**
	 * @param plantaircompressors2_1am the plantaircompressors2_1am to set
	 */
	public void setPlantaircompressors2_1am(String plantaircompressors2_1am) {
		this.plantaircompressors2_1am = plantaircompressors2_1am;
	}
	/**
	 * @return the plantaircompressors2_5am
	 */
	public String getPlantaircompressors2_5am() {
		return plantaircompressors2_5am;
	}
	/**
	 * @param plantaircompressors2_5am the plantaircompressors2_5am to set
	 */
	public void setPlantaircompressors2_5am(String plantaircompressors2_5am) {
		this.plantaircompressors2_5am = plantaircompressors2_5am;
	}
	/**
	 * @return the plantaircompressors3_freq
	 */
	public String getPlantaircompressors3_freq() {
		return plantaircompressors3_freq;
	}
	/**
	 * @param plantaircompressors3_freq the plantaircompressors3_freq to set
	 */
	public void setPlantaircompressors3_freq(String plantaircompressors3_freq) {
		this.plantaircompressors3_freq = plantaircompressors3_freq;
	}
	/**
	 * @return the plantaircompressors3_9am
	 */
	public String getPlantaircompressors3_9am() {
		return plantaircompressors3_9am;
	}
	/**
	 * @param plantaircompressors3_9am the plantaircompressors3_9am to set
	 */
	public void setPlantaircompressors3_9am(String plantaircompressors3_9am) {
		this.plantaircompressors3_9am = plantaircompressors3_9am;
	}
	/**
	 * @return the plantaircompressors3_1pm
	 */
	public String getPlantaircompressors3_1pm() {
		return plantaircompressors3_1pm;
	}
	/**
	 * @param plantaircompressors3_1pm the plantaircompressors3_1pm to set
	 */
	public void setPlantaircompressors3_1pm(String plantaircompressors3_1pm) {
		this.plantaircompressors3_1pm = plantaircompressors3_1pm;
	}
	/**
	 * @return the plantaircompressors3_5pm
	 */
	public String getPlantaircompressors3_5pm() {
		return plantaircompressors3_5pm;
	}
	/**
	 * @param plantaircompressors3_5pm the plantaircompressors3_5pm to set
	 */
	public void setPlantaircompressors3_5pm(String plantaircompressors3_5pm) {
		this.plantaircompressors3_5pm = plantaircompressors3_5pm;
	}
	/**
	 * @return the plantaircompressors3_9pm
	 */
	public String getPlantaircompressors3_9pm() {
		return plantaircompressors3_9pm;
	}
	/**
	 * @param plantaircompressors3_9pm the plantaircompressors3_9pm to set
	 */
	public void setPlantaircompressors3_9pm(String plantaircompressors3_9pm) {
		this.plantaircompressors3_9pm = plantaircompressors3_9pm;
	}
	/**
	 * @return the plantaircompressors3_1am
	 */
	public String getPlantaircompressors3_1am() {
		return plantaircompressors3_1am;
	}
	/**
	 * @param plantaircompressors3_1am the plantaircompressors3_1am to set
	 */
	public void setPlantaircompressors3_1am(String plantaircompressors3_1am) {
		this.plantaircompressors3_1am = plantaircompressors3_1am;
	}
	/**
	 * @return the plantaircompressors3_5am
	 */
	public String getPlantaircompressors3_5am() {
		return plantaircompressors3_5am;
	}
	/**
	 * @param plantaircompressors3_5am the plantaircompressors3_5am to set
	 */
	public void setPlantaircompressors3_5am(String plantaircompressors3_5am) {
		this.plantaircompressors3_5am = plantaircompressors3_5am;
	}
	/**
	 * @return the plantaircompressors4_freq
	 */
	public String getPlantaircompressors4_freq() {
		return plantaircompressors4_freq;
	}
	/**
	 * @param plantaircompressors4_freq the plantaircompressors4_freq to set
	 */
	public void setPlantaircompressors4_freq(String plantaircompressors4_freq) {
		this.plantaircompressors4_freq = plantaircompressors4_freq;
	}
	/**
	 * @return the plantaircompressors4_9am
	 */
	public String getPlantaircompressors4_9am() {
		return plantaircompressors4_9am;
	}
	/**
	 * @param plantaircompressors4_9am the plantaircompressors4_9am to set
	 */
	public void setPlantaircompressors4_9am(String plantaircompressors4_9am) {
		this.plantaircompressors4_9am = plantaircompressors4_9am;
	}
	/**
	 * @return the plantaircompressors4_1pm
	 */
	public String getPlantaircompressors4_1pm() {
		return plantaircompressors4_1pm;
	}
	/**
	 * @param plantaircompressors4_1pm the plantaircompressors4_1pm to set
	 */
	public void setPlantaircompressors4_1pm(String plantaircompressors4_1pm) {
		this.plantaircompressors4_1pm = plantaircompressors4_1pm;
	}
	/**
	 * @return the plantaircompressors4_5pm
	 */
	public String getPlantaircompressors4_5pm() {
		return plantaircompressors4_5pm;
	}
	/**
	 * @param plantaircompressors4_5pm the plantaircompressors4_5pm to set
	 */
	public void setPlantaircompressors4_5pm(String plantaircompressors4_5pm) {
		this.plantaircompressors4_5pm = plantaircompressors4_5pm;
	}
	/**
	 * @return the plantaircompressors4_9pm
	 */
	public String getPlantaircompressors4_9pm() {
		return plantaircompressors4_9pm;
	}
	/**
	 * @param plantaircompressors4_9pm the plantaircompressors4_9pm to set
	 */
	public void setPlantaircompressors4_9pm(String plantaircompressors4_9pm) {
		this.plantaircompressors4_9pm = plantaircompressors4_9pm;
	}
	/**
	 * @return the plantaircompressors4_1am
	 */
	public String getPlantaircompressors4_1am() {
		return plantaircompressors4_1am;
	}
	/**
	 * @param plantaircompressors4_1am the plantaircompressors4_1am to set
	 */
	public void setPlantaircompressors4_1am(String plantaircompressors4_1am) {
		this.plantaircompressors4_1am = plantaircompressors4_1am;
	}
	/**
	 * @return the plantaircompressors4_5am
	 */
	public String getPlantaircompressors4_5am() {
		return plantaircompressors4_5am;
	}
	/**
	 * @param plantaircompressors4_5am the plantaircompressors4_5am to set
	 */
	public void setPlantaircompressors4_5am(String plantaircompressors4_5am) {
		this.plantaircompressors4_5am = plantaircompressors4_5am;
	}
	/**
	 * @return the plantaircompressors5_freq
	 */
	public String getPlantaircompressors5_freq() {
		return plantaircompressors5_freq;
	}
	/**
	 * @param plantaircompressors5_freq the plantaircompressors5_freq to set
	 */
	public void setPlantaircompressors5_freq(String plantaircompressors5_freq) {
		this.plantaircompressors5_freq = plantaircompressors5_freq;
	}
	/**
	 * @return the plantaircompressors5_9am
	 */
	public String getPlantaircompressors5_9am() {
		return plantaircompressors5_9am;
	}
	/**
	 * @param plantaircompressors5_9am the plantaircompressors5_9am to set
	 */
	public void setPlantaircompressors5_9am(String plantaircompressors5_9am) {
		this.plantaircompressors5_9am = plantaircompressors5_9am;
	}
	/**
	 * @return the plantaircompressors5_1pm
	 */
	public String getPlantaircompressors5_1pm() {
		return plantaircompressors5_1pm;
	}
	/**
	 * @param plantaircompressors5_1pm the plantaircompressors5_1pm to set
	 */
	public void setPlantaircompressors5_1pm(String plantaircompressors5_1pm) {
		this.plantaircompressors5_1pm = plantaircompressors5_1pm;
	}
	/**
	 * @return the plantaircompressors5_5pm
	 */
	public String getPlantaircompressors5_5pm() {
		return plantaircompressors5_5pm;
	}
	/**
	 * @param plantaircompressors5_5pm the plantaircompressors5_5pm to set
	 */
	public void setPlantaircompressors5_5pm(String plantaircompressors5_5pm) {
		this.plantaircompressors5_5pm = plantaircompressors5_5pm;
	}
	/**
	 * @return the plantaircompressors5_9pm
	 */
	public String getPlantaircompressors5_9pm() {
		return plantaircompressors5_9pm;
	}
	/**
	 * @param plantaircompressors5_9pm the plantaircompressors5_9pm to set
	 */
	public void setPlantaircompressors5_9pm(String plantaircompressors5_9pm) {
		this.plantaircompressors5_9pm = plantaircompressors5_9pm;
	}
	/**
	 * @return the plantaircompressors5_1am
	 */
	public String getPlantaircompressors5_1am() {
		return plantaircompressors5_1am;
	}
	/**
	 * @param plantaircompressors5_1am the plantaircompressors5_1am to set
	 */
	public void setPlantaircompressors5_1am(String plantaircompressors5_1am) {
		this.plantaircompressors5_1am = plantaircompressors5_1am;
	}
	/**
	 * @return the plantaircompressors5_5am
	 */
	public String getPlantaircompressors5_5am() {
		return plantaircompressors5_5am;
	}
	/**
	 * @param plantaircompressors5_5am the plantaircompressors5_5am to set
	 */
	public void setPlantaircompressors5_5am(String plantaircompressors5_5am) {
		this.plantaircompressors5_5am = plantaircompressors5_5am;
	}
	/**
	 * @return the plantaircompressors6_freq
	 */
	public String getPlantaircompressors6_freq() {
		return plantaircompressors6_freq;
	}
	/**
	 * @param plantaircompressors6_freq the plantaircompressors6_freq to set
	 */
	public void setPlantaircompressors6_freq(String plantaircompressors6_freq) {
		this.plantaircompressors6_freq = plantaircompressors6_freq;
	}
	/**
	 * @return the plantaircompressors6_9am
	 */
	public String getPlantaircompressors6_9am() {
		return plantaircompressors6_9am;
	}
	/**
	 * @param plantaircompressors6_9am the plantaircompressors6_9am to set
	 */
	public void setPlantaircompressors6_9am(String plantaircompressors6_9am) {
		this.plantaircompressors6_9am = plantaircompressors6_9am;
	}
	/**
	 * @return the plantaircompressors6_1pm
	 */
	public String getPlantaircompressors6_1pm() {
		return plantaircompressors6_1pm;
	}
	/**
	 * @param plantaircompressors6_1pm the plantaircompressors6_1pm to set
	 */
	public void setPlantaircompressors6_1pm(String plantaircompressors6_1pm) {
		this.plantaircompressors6_1pm = plantaircompressors6_1pm;
	}
	/**
	 * @return the plantaircompressors6_5pm
	 */
	public String getPlantaircompressors6_5pm() {
		return plantaircompressors6_5pm;
	}
	/**
	 * @param plantaircompressors6_5pm the plantaircompressors6_5pm to set
	 */
	public void setPlantaircompressors6_5pm(String plantaircompressors6_5pm) {
		this.plantaircompressors6_5pm = plantaircompressors6_5pm;
	}
	/**
	 * @return the plantaircompressors6_9pm
	 */
	public String getPlantaircompressors6_9pm() {
		return plantaircompressors6_9pm;
	}
	/**
	 * @param plantaircompressors6_9pm the plantaircompressors6_9pm to set
	 */
	public void setPlantaircompressors6_9pm(String plantaircompressors6_9pm) {
		this.plantaircompressors6_9pm = plantaircompressors6_9pm;
	}
	/**
	 * @return the plantaircompressors6_1am
	 */
	public String getPlantaircompressors6_1am() {
		return plantaircompressors6_1am;
	}
	/**
	 * @param plantaircompressors6_1am the plantaircompressors6_1am to set
	 */
	public void setPlantaircompressors6_1am(String plantaircompressors6_1am) {
		this.plantaircompressors6_1am = plantaircompressors6_1am;
	}
	/**
	 * @return the plantaircompressors6_5am
	 */
	public String getPlantaircompressors6_5am() {
		return plantaircompressors6_5am;
	}
	/**
	 * @param plantaircompressors6_5am the plantaircompressors6_5am to set
	 */
	public void setPlantaircompressors6_5am(String plantaircompressors6_5am) {
		this.plantaircompressors6_5am = plantaircompressors6_5am;
	}
	/**
	 * @return the plantaircompressors7_freq
	 */
	public String getPlantaircompressors7_freq() {
		return plantaircompressors7_freq;
	}
	/**
	 * @param plantaircompressors7_freq the plantaircompressors7_freq to set
	 */
	public void setPlantaircompressors7_freq(String plantaircompressors7_freq) {
		this.plantaircompressors7_freq = plantaircompressors7_freq;
	}
	/**
	 * @return the plantaircompressors7_9am
	 */
	public String getPlantaircompressors7_9am() {
		return plantaircompressors7_9am;
	}
	/**
	 * @param plantaircompressors7_9am the plantaircompressors7_9am to set
	 */
	public void setPlantaircompressors7_9am(String plantaircompressors7_9am) {
		this.plantaircompressors7_9am = plantaircompressors7_9am;
	}
	/**
	 * @return the plantaircompressors7_1pm
	 */
	public String getPlantaircompressors7_1pm() {
		return plantaircompressors7_1pm;
	}
	/**
	 * @param plantaircompressors7_1pm the plantaircompressors7_1pm to set
	 */
	public void setPlantaircompressors7_1pm(String plantaircompressors7_1pm) {
		this.plantaircompressors7_1pm = plantaircompressors7_1pm;
	}
	/**
	 * @return the plantaircompressors7_5pm
	 */
	public String getPlantaircompressors7_5pm() {
		return plantaircompressors7_5pm;
	}
	/**
	 * @param plantaircompressors7_5pm the plantaircompressors7_5pm to set
	 */
	public void setPlantaircompressors7_5pm(String plantaircompressors7_5pm) {
		this.plantaircompressors7_5pm = plantaircompressors7_5pm;
	}
	/**
	 * @return the plantaircompressors7_9pm
	 */
	public String getPlantaircompressors7_9pm() {
		return plantaircompressors7_9pm;
	}
	/**
	 * @param plantaircompressors7_9pm the plantaircompressors7_9pm to set
	 */
	public void setPlantaircompressors7_9pm(String plantaircompressors7_9pm) {
		this.plantaircompressors7_9pm = plantaircompressors7_9pm;
	}
	/**
	 * @return the plantaircompressors7_1am
	 */
	public String getPlantaircompressors7_1am() {
		return plantaircompressors7_1am;
	}
	/**
	 * @param plantaircompressors7_1am the plantaircompressors7_1am to set
	 */
	public void setPlantaircompressors7_1am(String plantaircompressors7_1am) {
		this.plantaircompressors7_1am = plantaircompressors7_1am;
	}
	/**
	 * @return the plantaircompressors7_5am
	 */
	public String getPlantaircompressors7_5am() {
		return plantaircompressors7_5am;
	}
	/**
	 * @param plantaircompressors7_5am the plantaircompressors7_5am to set
	 */
	public void setPlantaircompressors7_5am(String plantaircompressors7_5am) {
		this.plantaircompressors7_5am = plantaircompressors7_5am;
	}
	/**
	 * @return the plantaircompressors8_freq
	 */
	public String getPlantaircompressors8_freq() {
		return plantaircompressors8_freq;
	}
	/**
	 * @param plantaircompressors8_freq the plantaircompressors8_freq to set
	 */
	public void setPlantaircompressors8_freq(String plantaircompressors8_freq) {
		this.plantaircompressors8_freq = plantaircompressors8_freq;
	}
	/**
	 * @return the plantaircompressors8_9am
	 */
	public String getPlantaircompressors8_9am() {
		return plantaircompressors8_9am;
	}
	/**
	 * @param plantaircompressors8_9am the plantaircompressors8_9am to set
	 */
	public void setPlantaircompressors8_9am(String plantaircompressors8_9am) {
		this.plantaircompressors8_9am = plantaircompressors8_9am;
	}
	/**
	 * @return the plantaircompressors8_1pm
	 */
	public String getPlantaircompressors8_1pm() {
		return plantaircompressors8_1pm;
	}
	/**
	 * @param plantaircompressors8_1pm the plantaircompressors8_1pm to set
	 */
	public void setPlantaircompressors8_1pm(String plantaircompressors8_1pm) {
		this.plantaircompressors8_1pm = plantaircompressors8_1pm;
	}
	/**
	 * @return the plantaircompressors8_5pm
	 */
	public String getPlantaircompressors8_5pm() {
		return plantaircompressors8_5pm;
	}
	/**
	 * @param plantaircompressors8_5pm the plantaircompressors8_5pm to set
	 */
	public void setPlantaircompressors8_5pm(String plantaircompressors8_5pm) {
		this.plantaircompressors8_5pm = plantaircompressors8_5pm;
	}
	/**
	 * @return the plantaircompressors8_9pm
	 */
	public String getPlantaircompressors8_9pm() {
		return plantaircompressors8_9pm;
	}
	/**
	 * @param plantaircompressors8_9pm the plantaircompressors8_9pm to set
	 */
	public void setPlantaircompressors8_9pm(String plantaircompressors8_9pm) {
		this.plantaircompressors8_9pm = plantaircompressors8_9pm;
	}
	/**
	 * @return the plantaircompressors8_1am
	 */
	public String getPlantaircompressors8_1am() {
		return plantaircompressors8_1am;
	}
	/**
	 * @param plantaircompressors8_1am the plantaircompressors8_1am to set
	 */
	public void setPlantaircompressors8_1am(String plantaircompressors8_1am) {
		this.plantaircompressors8_1am = plantaircompressors8_1am;
	}
	/**
	 * @return the plantaircompressors8_5am
	 */
	public String getPlantaircompressors8_5am() {
		return plantaircompressors8_5am;
	}
	/**
	 * @param plantaircompressors8_5am the plantaircompressors8_5am to set
	 */
	public void setPlantaircompressors8_5am(String plantaircompressors8_5am) {
		this.plantaircompressors8_5am = plantaircompressors8_5am;
	}
	/**
	 * @return the plantaircompressors9_freq
	 */
	public String getPlantaircompressors9_freq() {
		return plantaircompressors9_freq;
	}
	/**
	 * @param plantaircompressors9_freq the plantaircompressors9_freq to set
	 */
	public void setPlantaircompressors9_freq(String plantaircompressors9_freq) {
		this.plantaircompressors9_freq = plantaircompressors9_freq;
	}
	/**
	 * @return the plantaircompressors9_9am
	 */
	public String getPlantaircompressors9_9am() {
		return plantaircompressors9_9am;
	}
	/**
	 * @param plantaircompressors9_9am the plantaircompressors9_9am to set
	 */
	public void setPlantaircompressors9_9am(String plantaircompressors9_9am) {
		this.plantaircompressors9_9am = plantaircompressors9_9am;
	}
	/**
	 * @return the plantaircompressors9_1pm
	 */
	public String getPlantaircompressors9_1pm() {
		return plantaircompressors9_1pm;
	}
	/**
	 * @param plantaircompressors9_1pm the plantaircompressors9_1pm to set
	 */
	public void setPlantaircompressors9_1pm(String plantaircompressors9_1pm) {
		this.plantaircompressors9_1pm = plantaircompressors9_1pm;
	}
	/**
	 * @return the plantaircompressors9_5pm
	 */
	public String getPlantaircompressors9_5pm() {
		return plantaircompressors9_5pm;
	}
	/**
	 * @param plantaircompressors9_5pm the plantaircompressors9_5pm to set
	 */
	public void setPlantaircompressors9_5pm(String plantaircompressors9_5pm) {
		this.plantaircompressors9_5pm = plantaircompressors9_5pm;
	}
	/**
	 * @return the plantaircompressors9_9pm
	 */
	public String getPlantaircompressors9_9pm() {
		return plantaircompressors9_9pm;
	}
	/**
	 * @param plantaircompressors9_9pm the plantaircompressors9_9pm to set
	 */
	public void setPlantaircompressors9_9pm(String plantaircompressors9_9pm) {
		this.plantaircompressors9_9pm = plantaircompressors9_9pm;
	}
	/**
	 * @return the plantaircompressors9_1am
	 */
	public String getPlantaircompressors9_1am() {
		return plantaircompressors9_1am;
	}
	/**
	 * @param plantaircompressors9_1am the plantaircompressors9_1am to set
	 */
	public void setPlantaircompressors9_1am(String plantaircompressors9_1am) {
		this.plantaircompressors9_1am = plantaircompressors9_1am;
	}
	/**
	 * @return the plantaircompressors9_5am
	 */
	public String getPlantaircompressors9_5am() {
		return plantaircompressors9_5am;
	}
	/**
	 * @param plantaircompressors9_5am the plantaircompressors9_5am to set
	 */
	public void setPlantaircompressors9_5am(String plantaircompressors9_5am) {
		this.plantaircompressors9_5am = plantaircompressors9_5am;
	}
	/**
	 * @return the plantaircompressors10_freq
	 */
	public String getPlantaircompressors10_freq() {
		return plantaircompressors10_freq;
	}
	/**
	 * @param plantaircompressors10_freq the plantaircompressors10_freq to set
	 */
	public void setPlantaircompressors10_freq(String plantaircompressors10_freq) {
		this.plantaircompressors10_freq = plantaircompressors10_freq;
	}
	/**
	 * @return the plantaircompressors10_9am
	 */
	public String getPlantaircompressors10_9am() {
		return plantaircompressors10_9am;
	}
	/**
	 * @param plantaircompressors10_9am the plantaircompressors10_9am to set
	 */
	public void setPlantaircompressors10_9am(String plantaircompressors10_9am) {
		this.plantaircompressors10_9am = plantaircompressors10_9am;
	}
	/**
	 * @return the plantaircompressors10_1pm
	 */
	public String getPlantaircompressors10_1pm() {
		return plantaircompressors10_1pm;
	}
	/**
	 * @param plantaircompressors10_1pm the plantaircompressors10_1pm to set
	 */
	public void setPlantaircompressors10_1pm(String plantaircompressors10_1pm) {
		this.plantaircompressors10_1pm = plantaircompressors10_1pm;
	}
	/**
	 * @return the plantaircompressors10_5pm
	 */
	public String getPlantaircompressors10_5pm() {
		return plantaircompressors10_5pm;
	}
	/**
	 * @param plantaircompressors10_5pm the plantaircompressors10_5pm to set
	 */
	public void setPlantaircompressors10_5pm(String plantaircompressors10_5pm) {
		this.plantaircompressors10_5pm = plantaircompressors10_5pm;
	}
	/**
	 * @return the plantaircompressors10_9pm
	 */
	public String getPlantaircompressors10_9pm() {
		return plantaircompressors10_9pm;
	}
	/**
	 * @param plantaircompressors10_9pm the plantaircompressors10_9pm to set
	 */
	public void setPlantaircompressors10_9pm(String plantaircompressors10_9pm) {
		this.plantaircompressors10_9pm = plantaircompressors10_9pm;
	}
	/**
	 * @return the plantaircompressors10_1am
	 */
	public String getPlantaircompressors10_1am() {
		return plantaircompressors10_1am;
	}
	/**
	 * @param plantaircompressors10_1am the plantaircompressors10_1am to set
	 */
	public void setPlantaircompressors10_1am(String plantaircompressors10_1am) {
		this.plantaircompressors10_1am = plantaircompressors10_1am;
	}
	/**
	 * @return the plantaircompressors10_5am
	 */
	public String getPlantaircompressors10_5am() {
		return plantaircompressors10_5am;
	}
	/**
	 * @param plantaircompressors10_5am the plantaircompressors10_5am to set
	 */
	public void setPlantaircompressors10_5am(String plantaircompressors10_5am) {
		this.plantaircompressors10_5am = plantaircompressors10_5am;
	}
	/**
	 * @return the plantaircompressors11_freq
	 */
	public String getPlantaircompressors11_freq() {
		return plantaircompressors11_freq;
	}
	/**
	 * @param plantaircompressors11_freq the plantaircompressors11_freq to set
	 */
	public void setPlantaircompressors11_freq(String plantaircompressors11_freq) {
		this.plantaircompressors11_freq = plantaircompressors11_freq;
	}
	/**
	 * @return the plantaircompressors11_9am
	 */
	public String getPlantaircompressors11_9am() {
		return plantaircompressors11_9am;
	}
	/**
	 * @param plantaircompressors11_9am the plantaircompressors11_9am to set
	 */
	public void setPlantaircompressors11_9am(String plantaircompressors11_9am) {
		this.plantaircompressors11_9am = plantaircompressors11_9am;
	}
	/**
	 * @return the plantaircompressors11_1pm
	 */
	public String getPlantaircompressors11_1pm() {
		return plantaircompressors11_1pm;
	}
	/**
	 * @param plantaircompressors11_1pm the plantaircompressors11_1pm to set
	 */
	public void setPlantaircompressors11_1pm(String plantaircompressors11_1pm) {
		this.plantaircompressors11_1pm = plantaircompressors11_1pm;
	}
	/**
	 * @return the plantaircompressors11_5pm
	 */
	public String getPlantaircompressors11_5pm() {
		return plantaircompressors11_5pm;
	}
	/**
	 * @param plantaircompressors11_5pm the plantaircompressors11_5pm to set
	 */
	public void setPlantaircompressors11_5pm(String plantaircompressors11_5pm) {
		this.plantaircompressors11_5pm = plantaircompressors11_5pm;
	}
	/**
	 * @return the plantaircompressors11_9pm
	 */
	public String getPlantaircompressors11_9pm() {
		return plantaircompressors11_9pm;
	}
	/**
	 * @param plantaircompressors11_9pm the plantaircompressors11_9pm to set
	 */
	public void setPlantaircompressors11_9pm(String plantaircompressors11_9pm) {
		this.plantaircompressors11_9pm = plantaircompressors11_9pm;
	}
	/**
	 * @return the plantaircompressors11_1am
	 */
	public String getPlantaircompressors11_1am() {
		return plantaircompressors11_1am;
	}
	/**
	 * @param plantaircompressors11_1am the plantaircompressors11_1am to set
	 */
	public void setPlantaircompressors11_1am(String plantaircompressors11_1am) {
		this.plantaircompressors11_1am = plantaircompressors11_1am;
	}
	/**
	 * @return the plantaircompressors11_5am
	 */
	public String getPlantaircompressors11_5am() {
		return plantaircompressors11_5am;
	}
	/**
	 * @param plantaircompressors11_5am the plantaircompressors11_5am to set
	 */
	public void setPlantaircompressors11_5am(String plantaircompressors11_5am) {
		this.plantaircompressors11_5am = plantaircompressors11_5am;
	}
	/**
	 * @return the plantaircompressors12_freq
	 */
	public String getPlantaircompressors12_freq() {
		return plantaircompressors12_freq;
	}
	/**
	 * @param plantaircompressors12_freq the plantaircompressors12_freq to set
	 */
	public void setPlantaircompressors12_freq(String plantaircompressors12_freq) {
		this.plantaircompressors12_freq = plantaircompressors12_freq;
	}
	/**
	 * @return the plantaircompressors12_9am
	 */
	public String getPlantaircompressors12_9am() {
		return plantaircompressors12_9am;
	}
	/**
	 * @param plantaircompressors12_9am the plantaircompressors12_9am to set
	 */
	public void setPlantaircompressors12_9am(String plantaircompressors12_9am) {
		this.plantaircompressors12_9am = plantaircompressors12_9am;
	}
	/**
	 * @return the plantaircompressors12_1pm
	 */
	public String getPlantaircompressors12_1pm() {
		return plantaircompressors12_1pm;
	}
	/**
	 * @param plantaircompressors12_1pm the plantaircompressors12_1pm to set
	 */
	public void setPlantaircompressors12_1pm(String plantaircompressors12_1pm) {
		this.plantaircompressors12_1pm = plantaircompressors12_1pm;
	}
	/**
	 * @return the plantaircompressors12_5pm
	 */
	public String getPlantaircompressors12_5pm() {
		return plantaircompressors12_5pm;
	}
	/**
	 * @param plantaircompressors12_5pm the plantaircompressors12_5pm to set
	 */
	public void setPlantaircompressors12_5pm(String plantaircompressors12_5pm) {
		this.plantaircompressors12_5pm = plantaircompressors12_5pm;
	}
	/**
	 * @return the plantaircompressors12_9pm
	 */
	public String getPlantaircompressors12_9pm() {
		return plantaircompressors12_9pm;
	}
	/**
	 * @param plantaircompressors12_9pm the plantaircompressors12_9pm to set
	 */
	public void setPlantaircompressors12_9pm(String plantaircompressors12_9pm) {
		this.plantaircompressors12_9pm = plantaircompressors12_9pm;
	}
	/**
	 * @return the plantaircompressors12_1am
	 */
	public String getPlantaircompressors12_1am() {
		return plantaircompressors12_1am;
	}
	/**
	 * @param plantaircompressors12_1am the plantaircompressors12_1am to set
	 */
	public void setPlantaircompressors12_1am(String plantaircompressors12_1am) {
		this.plantaircompressors12_1am = plantaircompressors12_1am;
	}
	/**
	 * @return the plantaircompressors12_5am
	 */
	public String getPlantaircompressors12_5am() {
		return plantaircompressors12_5am;
	}
	/**
	 * @param plantaircompressors12_5am the plantaircompressors12_5am to set
	 */
	public void setPlantaircompressors12_5am(String plantaircompressors12_5am) {
		this.plantaircompressors12_5am = plantaircompressors12_5am;
	}
	/**
	 * @return the plantaircompressors13_freq
	 */
	public String getPlantaircompressors13_freq() {
		return plantaircompressors13_freq;
	}
	/**
	 * @param plantaircompressors13_freq the plantaircompressors13_freq to set
	 */
	public void setPlantaircompressors13_freq(String plantaircompressors13_freq) {
		this.plantaircompressors13_freq = plantaircompressors13_freq;
	}
	/**
	 * @return the plantaircompressors13_9am
	 */
	public String getPlantaircompressors13_9am() {
		return plantaircompressors13_9am;
	}
	/**
	 * @param plantaircompressors13_9am the plantaircompressors13_9am to set
	 */
	public void setPlantaircompressors13_9am(String plantaircompressors13_9am) {
		this.plantaircompressors13_9am = plantaircompressors13_9am;
	}
	/**
	 * @return the plantaircompressors13_1pm
	 */
	public String getPlantaircompressors13_1pm() {
		return plantaircompressors13_1pm;
	}
	/**
	 * @param plantaircompressors13_1pm the plantaircompressors13_1pm to set
	 */
	public void setPlantaircompressors13_1pm(String plantaircompressors13_1pm) {
		this.plantaircompressors13_1pm = plantaircompressors13_1pm;
	}
	/**
	 * @return the plantaircompressors13_5pm
	 */
	public String getPlantaircompressors13_5pm() {
		return plantaircompressors13_5pm;
	}
	/**
	 * @param plantaircompressors13_5pm the plantaircompressors13_5pm to set
	 */
	public void setPlantaircompressors13_5pm(String plantaircompressors13_5pm) {
		this.plantaircompressors13_5pm = plantaircompressors13_5pm;
	}
	/**
	 * @return the plantaircompressors13_9pm
	 */
	public String getPlantaircompressors13_9pm() {
		return plantaircompressors13_9pm;
	}
	/**
	 * @param plantaircompressors13_9pm the plantaircompressors13_9pm to set
	 */
	public void setPlantaircompressors13_9pm(String plantaircompressors13_9pm) {
		this.plantaircompressors13_9pm = plantaircompressors13_9pm;
	}
	/**
	 * @return the plantaircompressors13_1am
	 */
	public String getPlantaircompressors13_1am() {
		return plantaircompressors13_1am;
	}
	/**
	 * @param plantaircompressors13_1am the plantaircompressors13_1am to set
	 */
	public void setPlantaircompressors13_1am(String plantaircompressors13_1am) {
		this.plantaircompressors13_1am = plantaircompressors13_1am;
	}
	/**
	 * @return the plantaircompressors13_5am
	 */
	public String getPlantaircompressors13_5am() {
		return plantaircompressors13_5am;
	}
	/**
	 * @param plantaircompressors13_5am the plantaircompressors13_5am to set
	 */
	public void setPlantaircompressors13_5am(String plantaircompressors13_5am) {
		this.plantaircompressors13_5am = plantaircompressors13_5am;
	}
	/**
	 * @return the plantaircompressors14_freq
	 */
	public String getPlantaircompressors14_freq() {
		return plantaircompressors14_freq;
	}
	/**
	 * @param plantaircompressors14_freq the plantaircompressors14_freq to set
	 */
	public void setPlantaircompressors14_freq(String plantaircompressors14_freq) {
		this.plantaircompressors14_freq = plantaircompressors14_freq;
	}
	/**
	 * @return the plantaircompressors14_9am
	 */
	public String getPlantaircompressors14_9am() {
		return plantaircompressors14_9am;
	}
	/**
	 * @param plantaircompressors14_9am the plantaircompressors14_9am to set
	 */
	public void setPlantaircompressors14_9am(String plantaircompressors14_9am) {
		this.plantaircompressors14_9am = plantaircompressors14_9am;
	}
	/**
	 * @return the plantaircompressors14_1pm
	 */
	public String getPlantaircompressors14_1pm() {
		return plantaircompressors14_1pm;
	}
	/**
	 * @param plantaircompressors14_1pm the plantaircompressors14_1pm to set
	 */
	public void setPlantaircompressors14_1pm(String plantaircompressors14_1pm) {
		this.plantaircompressors14_1pm = plantaircompressors14_1pm;
	}
	/**
	 * @return the plantaircompressors14_5pm
	 */
	public String getPlantaircompressors14_5pm() {
		return plantaircompressors14_5pm;
	}
	/**
	 * @param plantaircompressors14_5pm the plantaircompressors14_5pm to set
	 */
	public void setPlantaircompressors14_5pm(String plantaircompressors14_5pm) {
		this.plantaircompressors14_5pm = plantaircompressors14_5pm;
	}
	/**
	 * @return the plantaircompressors14_9pm
	 */
	public String getPlantaircompressors14_9pm() {
		return plantaircompressors14_9pm;
	}
	/**
	 * @param plantaircompressors14_9pm the plantaircompressors14_9pm to set
	 */
	public void setPlantaircompressors14_9pm(String plantaircompressors14_9pm) {
		this.plantaircompressors14_9pm = plantaircompressors14_9pm;
	}
	/**
	 * @return the plantaircompressors14_1am
	 */
	public String getPlantaircompressors14_1am() {
		return plantaircompressors14_1am;
	}
	/**
	 * @param plantaircompressors14_1am the plantaircompressors14_1am to set
	 */
	public void setPlantaircompressors14_1am(String plantaircompressors14_1am) {
		this.plantaircompressors14_1am = plantaircompressors14_1am;
	}
	/**
	 * @return the plantaircompressors14_5am
	 */
	public String getPlantaircompressors14_5am() {
		return plantaircompressors14_5am;
	}
	/**
	 * @param plantaircompressors14_5am the plantaircompressors14_5am to set
	 */
	public void setPlantaircompressors14_5am(String plantaircompressors14_5am) {
		this.plantaircompressors14_5am = plantaircompressors14_5am;
	}
	/**
	 * @return the plantaircompressors15_freq
	 */
	public String getPlantaircompressors15_freq() {
		return plantaircompressors15_freq;
	}
	/**
	 * @param plantaircompressors15_freq the plantaircompressors15_freq to set
	 */
	public void setPlantaircompressors15_freq(String plantaircompressors15_freq) {
		this.plantaircompressors15_freq = plantaircompressors15_freq;
	}
	/**
	 * @return the plantaircompressors15_9am
	 */
	public String getPlantaircompressors15_9am() {
		return plantaircompressors15_9am;
	}
	/**
	 * @param plantaircompressors15_9am the plantaircompressors15_9am to set
	 */
	public void setPlantaircompressors15_9am(String plantaircompressors15_9am) {
		this.plantaircompressors15_9am = plantaircompressors15_9am;
	}
	/**
	 * @return the plantaircompressors15_1pm
	 */
	public String getPlantaircompressors15_1pm() {
		return plantaircompressors15_1pm;
	}
	/**
	 * @param plantaircompressors15_1pm the plantaircompressors15_1pm to set
	 */
	public void setPlantaircompressors15_1pm(String plantaircompressors15_1pm) {
		this.plantaircompressors15_1pm = plantaircompressors15_1pm;
	}
	/**
	 * @return the plantaircompressors15_5pm
	 */
	public String getPlantaircompressors15_5pm() {
		return plantaircompressors15_5pm;
	}
	/**
	 * @param plantaircompressors15_5pm the plantaircompressors15_5pm to set
	 */
	public void setPlantaircompressors15_5pm(String plantaircompressors15_5pm) {
		this.plantaircompressors15_5pm = plantaircompressors15_5pm;
	}
	/**
	 * @return the plantaircompressors15_9pm
	 */
	public String getPlantaircompressors15_9pm() {
		return plantaircompressors15_9pm;
	}
	/**
	 * @param plantaircompressors15_9pm the plantaircompressors15_9pm to set
	 */
	public void setPlantaircompressors15_9pm(String plantaircompressors15_9pm) {
		this.plantaircompressors15_9pm = plantaircompressors15_9pm;
	}
	/**
	 * @return the plantaircompressors15_1am
	 */
	public String getPlantaircompressors15_1am() {
		return plantaircompressors15_1am;
	}
	/**
	 * @param plantaircompressors15_1am the plantaircompressors15_1am to set
	 */
	public void setPlantaircompressors15_1am(String plantaircompressors15_1am) {
		this.plantaircompressors15_1am = plantaircompressors15_1am;
	}
	/**
	 * @return the plantaircompressors15_5am
	 */
	public String getPlantaircompressors15_5am() {
		return plantaircompressors15_5am;
	}
	/**
	 * @param plantaircompressors15_5am the plantaircompressors15_5am to set
	 */
	public void setPlantaircompressors15_5am(String plantaircompressors15_5am) {
		this.plantaircompressors15_5am = plantaircompressors15_5am;
	}
	/**
	 * @return the plantaircompressors16_freq
	 */
	public String getPlantaircompressors16_freq() {
		return plantaircompressors16_freq;
	}
	/**
	 * @param plantaircompressors16_freq the plantaircompressors16_freq to set
	 */
	public void setPlantaircompressors16_freq(String plantaircompressors16_freq) {
		this.plantaircompressors16_freq = plantaircompressors16_freq;
	}
	/**
	 * @return the plantaircompressors16_9am
	 */
	public String getPlantaircompressors16_9am() {
		return plantaircompressors16_9am;
	}
	/**
	 * @param plantaircompressors16_9am the plantaircompressors16_9am to set
	 */
	public void setPlantaircompressors16_9am(String plantaircompressors16_9am) {
		this.plantaircompressors16_9am = plantaircompressors16_9am;
	}
	/**
	 * @return the plantaircompressors16_1pm
	 */
	public String getPlantaircompressors16_1pm() {
		return plantaircompressors16_1pm;
	}
	/**
	 * @param plantaircompressors16_1pm the plantaircompressors16_1pm to set
	 */
	public void setPlantaircompressors16_1pm(String plantaircompressors16_1pm) {
		this.plantaircompressors16_1pm = plantaircompressors16_1pm;
	}
	/**
	 * @return the plantaircompressors16_5pm
	 */
	public String getPlantaircompressors16_5pm() {
		return plantaircompressors16_5pm;
	}
	/**
	 * @param plantaircompressors16_5pm the plantaircompressors16_5pm to set
	 */
	public void setPlantaircompressors16_5pm(String plantaircompressors16_5pm) {
		this.plantaircompressors16_5pm = plantaircompressors16_5pm;
	}
	/**
	 * @return the plantaircompressors16_9pm
	 */
	public String getPlantaircompressors16_9pm() {
		return plantaircompressors16_9pm;
	}
	/**
	 * @param plantaircompressors16_9pm the plantaircompressors16_9pm to set
	 */
	public void setPlantaircompressors16_9pm(String plantaircompressors16_9pm) {
		this.plantaircompressors16_9pm = plantaircompressors16_9pm;
	}
	/**
	 * @return the plantaircompressors16_1am
	 */
	public String getPlantaircompressors16_1am() {
		return plantaircompressors16_1am;
	}
	/**
	 * @param plantaircompressors16_1am the plantaircompressors16_1am to set
	 */
	public void setPlantaircompressors16_1am(String plantaircompressors16_1am) {
		this.plantaircompressors16_1am = plantaircompressors16_1am;
	}
	/**
	 * @return the plantaircompressors16_5am
	 */
	public String getPlantaircompressors16_5am() {
		return plantaircompressors16_5am;
	}
	/**
	 * @param plantaircompressors16_5am the plantaircompressors16_5am to set
	 */
	public void setPlantaircompressors16_5am(String plantaircompressors16_5am) {
		this.plantaircompressors16_5am = plantaircompressors16_5am;
	}
	/**
	 * @return the millairdryer1_freq
	 */
	public String getMillairdryer1_freq() {
		return millairdryer1_freq;
	}
	/**
	 * @param millairdryer1_freq the millairdryer1_freq to set
	 */
	public void setMillairdryer1_freq(String millairdryer1_freq) {
		this.millairdryer1_freq = millairdryer1_freq;
	}
	/**
	 * @return the millairdryer1_9am
	 */
	public String getMillairdryer1_9am() {
		return millairdryer1_9am;
	}
	/**
	 * @param millairdryer1_9am the millairdryer1_9am to set
	 */
	public void setMillairdryer1_9am(String millairdryer1_9am) {
		this.millairdryer1_9am = millairdryer1_9am;
	}
	/**
	 * @return the millairdryer1_1pm
	 */
	public String getMillairdryer1_1pm() {
		return millairdryer1_1pm;
	}
	/**
	 * @param millairdryer1_1pm the millairdryer1_1pm to set
	 */
	public void setMillairdryer1_1pm(String millairdryer1_1pm) {
		this.millairdryer1_1pm = millairdryer1_1pm;
	}
	/**
	 * @return the millairdryer1_5pm
	 */
	public String getMillairdryer1_5pm() {
		return millairdryer1_5pm;
	}
	/**
	 * @param millairdryer1_5pm the millairdryer1_5pm to set
	 */
	public void setMillairdryer1_5pm(String millairdryer1_5pm) {
		this.millairdryer1_5pm = millairdryer1_5pm;
	}
	/**
	 * @return the millairdryer1_9pm
	 */
	public String getMillairdryer1_9pm() {
		return millairdryer1_9pm;
	}
	/**
	 * @param millairdryer1_9pm the millairdryer1_9pm to set
	 */
	public void setMillairdryer1_9pm(String millairdryer1_9pm) {
		this.millairdryer1_9pm = millairdryer1_9pm;
	}
	/**
	 * @return the millairdryer1_1am
	 */
	public String getMillairdryer1_1am() {
		return millairdryer1_1am;
	}
	/**
	 * @param millairdryer1_1am the millairdryer1_1am to set
	 */
	public void setMillairdryer1_1am(String millairdryer1_1am) {
		this.millairdryer1_1am = millairdryer1_1am;
	}
	/**
	 * @return the millairdryer1_5am
	 */
	public String getMillairdryer1_5am() {
		return millairdryer1_5am;
	}
	/**
	 * @param millairdryer1_5am the millairdryer1_5am to set
	 */
	public void setMillairdryer1_5am(String millairdryer1_5am) {
		this.millairdryer1_5am = millairdryer1_5am;
	}
	/**
	 * @return the millairdryer2_freq
	 */
	public String getMillairdryer2_freq() {
		return millairdryer2_freq;
	}
	/**
	 * @param millairdryer2_freq the millairdryer2_freq to set
	 */
	public void setMillairdryer2_freq(String millairdryer2_freq) {
		this.millairdryer2_freq = millairdryer2_freq;
	}
	/**
	 * @return the millairdryer2_9am
	 */
	public String getMillairdryer2_9am() {
		return millairdryer2_9am;
	}
	/**
	 * @param millairdryer2_9am the millairdryer2_9am to set
	 */
	public void setMillairdryer2_9am(String millairdryer2_9am) {
		this.millairdryer2_9am = millairdryer2_9am;
	}
	/**
	 * @return the millairdryer2_1pm
	 */
	public String getMillairdryer2_1pm() {
		return millairdryer2_1pm;
	}
	/**
	 * @param millairdryer2_1pm the millairdryer2_1pm to set
	 */
	public void setMillairdryer2_1pm(String millairdryer2_1pm) {
		this.millairdryer2_1pm = millairdryer2_1pm;
	}
	/**
	 * @return the millairdryer2_5pm
	 */
	public String getMillairdryer2_5pm() {
		return millairdryer2_5pm;
	}
	/**
	 * @param millairdryer2_5pm the millairdryer2_5pm to set
	 */
	public void setMillairdryer2_5pm(String millairdryer2_5pm) {
		this.millairdryer2_5pm = millairdryer2_5pm;
	}
	/**
	 * @return the millairdryer2_9pm
	 */
	public String getMillairdryer2_9pm() {
		return millairdryer2_9pm;
	}
	/**
	 * @param millairdryer2_9pm the millairdryer2_9pm to set
	 */
	public void setMillairdryer2_9pm(String millairdryer2_9pm) {
		this.millairdryer2_9pm = millairdryer2_9pm;
	}
	/**
	 * @return the millairdryer2_1am
	 */
	public String getMillairdryer2_1am() {
		return millairdryer2_1am;
	}
	/**
	 * @param millairdryer2_1am the millairdryer2_1am to set
	 */
	public void setMillairdryer2_1am(String millairdryer2_1am) {
		this.millairdryer2_1am = millairdryer2_1am;
	}
	/**
	 * @return the millairdryer2_5am
	 */
	public String getMillairdryer2_5am() {
		return millairdryer2_5am;
	}
	/**
	 * @param millairdryer2_5am the millairdryer2_5am to set
	 */
	public void setMillairdryer2_5am(String millairdryer2_5am) {
		this.millairdryer2_5am = millairdryer2_5am;
	}
	/**
	 * @return the millairdryer3_freq
	 */
	public String getMillairdryer3_freq() {
		return millairdryer3_freq;
	}
	/**
	 * @param millairdryer3_freq the millairdryer3_freq to set
	 */
	public void setMillairdryer3_freq(String millairdryer3_freq) {
		this.millairdryer3_freq = millairdryer3_freq;
	}
	/**
	 * @return the millairdryer3_9am
	 */
	public String getMillairdryer3_9am() {
		return millairdryer3_9am;
	}
	/**
	 * @param millairdryer3_9am the millairdryer3_9am to set
	 */
	public void setMillairdryer3_9am(String millairdryer3_9am) {
		this.millairdryer3_9am = millairdryer3_9am;
	}
	/**
	 * @return the millairdryer3_1pm
	 */
	public String getMillairdryer3_1pm() {
		return millairdryer3_1pm;
	}
	/**
	 * @param millairdryer3_1pm the millairdryer3_1pm to set
	 */
	public void setMillairdryer3_1pm(String millairdryer3_1pm) {
		this.millairdryer3_1pm = millairdryer3_1pm;
	}
	/**
	 * @return the millairdryer3_5pm
	 */
	public String getMillairdryer3_5pm() {
		return millairdryer3_5pm;
	}
	/**
	 * @param millairdryer3_5pm the millairdryer3_5pm to set
	 */
	public void setMillairdryer3_5pm(String millairdryer3_5pm) {
		this.millairdryer3_5pm = millairdryer3_5pm;
	}
	/**
	 * @return the millairdryer3_9pm
	 */
	public String getMillairdryer3_9pm() {
		return millairdryer3_9pm;
	}
	/**
	 * @param millairdryer3_9pm the millairdryer3_9pm to set
	 */
	public void setMillairdryer3_9pm(String millairdryer3_9pm) {
		this.millairdryer3_9pm = millairdryer3_9pm;
	}
	/**
	 * @return the millairdryer3_1am
	 */
	public String getMillairdryer3_1am() {
		return millairdryer3_1am;
	}
	/**
	 * @param millairdryer3_1am the millairdryer3_1am to set
	 */
	public void setMillairdryer3_1am(String millairdryer3_1am) {
		this.millairdryer3_1am = millairdryer3_1am;
	}
	/**
	 * @return the millairdryer3_5am
	 */
	public String getMillairdryer3_5am() {
		return millairdryer3_5am;
	}
	/**
	 * @param millairdryer3_5am the millairdryer3_5am to set
	 */
	public void setMillairdryer3_5am(String millairdryer3_5am) {
		this.millairdryer3_5am = millairdryer3_5am;
	}
	/**
	 * @return the millairdryer4_freq
	 */
	public String getMillairdryer4_freq() {
		return millairdryer4_freq;
	}
	/**
	 * @param millairdryer4_freq the millairdryer4_freq to set
	 */
	public void setMillairdryer4_freq(String millairdryer4_freq) {
		this.millairdryer4_freq = millairdryer4_freq;
	}
	/**
	 * @return the millairdryer4_9am
	 */
	public String getMillairdryer4_9am() {
		return millairdryer4_9am;
	}
	/**
	 * @param millairdryer4_9am the millairdryer4_9am to set
	 */
	public void setMillairdryer4_9am(String millairdryer4_9am) {
		this.millairdryer4_9am = millairdryer4_9am;
	}
	/**
	 * @return the millairdryer4_1pm
	 */
	public String getMillairdryer4_1pm() {
		return millairdryer4_1pm;
	}
	/**
	 * @param millairdryer4_1pm the millairdryer4_1pm to set
	 */
	public void setMillairdryer4_1pm(String millairdryer4_1pm) {
		this.millairdryer4_1pm = millairdryer4_1pm;
	}
	/**
	 * @return the millairdryer4_5pm
	 */
	public String getMillairdryer4_5pm() {
		return millairdryer4_5pm;
	}
	/**
	 * @param millairdryer4_5pm the millairdryer4_5pm to set
	 */
	public void setMillairdryer4_5pm(String millairdryer4_5pm) {
		this.millairdryer4_5pm = millairdryer4_5pm;
	}
	/**
	 * @return the millairdryer4_9pm
	 */
	public String getMillairdryer4_9pm() {
		return millairdryer4_9pm;
	}
	/**
	 * @param millairdryer4_9pm the millairdryer4_9pm to set
	 */
	public void setMillairdryer4_9pm(String millairdryer4_9pm) {
		this.millairdryer4_9pm = millairdryer4_9pm;
	}
	/**
	 * @return the millairdryer4_1am
	 */
	public String getMillairdryer4_1am() {
		return millairdryer4_1am;
	}
	/**
	 * @param millairdryer4_1am the millairdryer4_1am to set
	 */
	public void setMillairdryer4_1am(String millairdryer4_1am) {
		this.millairdryer4_1am = millairdryer4_1am;
	}
	/**
	 * @return the millairdryer4_5am
	 */
	public String getMillairdryer4_5am() {
		return millairdryer4_5am;
	}
	/**
	 * @param millairdryer4_5am the millairdryer4_5am to set
	 */
	public void setMillairdryer4_5am(String millairdryer4_5am) {
		this.millairdryer4_5am = millairdryer4_5am;
	}
	/**
	 * @return the millairdryer5_freq
	 */
	public String getMillairdryer5_freq() {
		return millairdryer5_freq;
	}
	/**
	 * @param millairdryer5_freq the millairdryer5_freq to set
	 */
	public void setMillairdryer5_freq(String millairdryer5_freq) {
		this.millairdryer5_freq = millairdryer5_freq;
	}
	/**
	 * @return the millairdryer5_9am
	 */
	public String getMillairdryer5_9am() {
		return millairdryer5_9am;
	}
	/**
	 * @param millairdryer5_9am the millairdryer5_9am to set
	 */
	public void setMillairdryer5_9am(String millairdryer5_9am) {
		this.millairdryer5_9am = millairdryer5_9am;
	}
	/**
	 * @return the millairdryer5_1pm
	 */
	public String getMillairdryer5_1pm() {
		return millairdryer5_1pm;
	}
	/**
	 * @param millairdryer5_1pm the millairdryer5_1pm to set
	 */
	public void setMillairdryer5_1pm(String millairdryer5_1pm) {
		this.millairdryer5_1pm = millairdryer5_1pm;
	}
	/**
	 * @return the millairdryer5_5pm
	 */
	public String getMillairdryer5_5pm() {
		return millairdryer5_5pm;
	}
	/**
	 * @param millairdryer5_5pm the millairdryer5_5pm to set
	 */
	public void setMillairdryer5_5pm(String millairdryer5_5pm) {
		this.millairdryer5_5pm = millairdryer5_5pm;
	}
	/**
	 * @return the millairdryer5_9pm
	 */
	public String getMillairdryer5_9pm() {
		return millairdryer5_9pm;
	}
	/**
	 * @param millairdryer5_9pm the millairdryer5_9pm to set
	 */
	public void setMillairdryer5_9pm(String millairdryer5_9pm) {
		this.millairdryer5_9pm = millairdryer5_9pm;
	}
	/**
	 * @return the millairdryer5_1am
	 */
	public String getMillairdryer5_1am() {
		return millairdryer5_1am;
	}
	/**
	 * @param millairdryer5_1am the millairdryer5_1am to set
	 */
	public void setMillairdryer5_1am(String millairdryer5_1am) {
		this.millairdryer5_1am = millairdryer5_1am;
	}
	/**
	 * @return the millairdryer5_5am
	 */
	public String getMillairdryer5_5am() {
		return millairdryer5_5am;
	}
	/**
	 * @param millairdryer5_5am the millairdryer5_5am to set
	 */
	public void setMillairdryer5_5am(String millairdryer5_5am) {
		this.millairdryer5_5am = millairdryer5_5am;
	}
	/**
	 * @return the millairdryer6_freq
	 */
	public String getMillairdryer6_freq() {
		return millairdryer6_freq;
	}
	/**
	 * @param millairdryer6_freq the millairdryer6_freq to set
	 */
	public void setMillairdryer6_freq(String millairdryer6_freq) {
		this.millairdryer6_freq = millairdryer6_freq;
	}
	/**
	 * @return the millairdryer6_9am
	 */
	public String getMillairdryer6_9am() {
		return millairdryer6_9am;
	}
	/**
	 * @param millairdryer6_9am the millairdryer6_9am to set
	 */
	public void setMillairdryer6_9am(String millairdryer6_9am) {
		this.millairdryer6_9am = millairdryer6_9am;
	}
	/**
	 * @return the millairdryer6_1pm
	 */
	public String getMillairdryer6_1pm() {
		return millairdryer6_1pm;
	}
	/**
	 * @param millairdryer6_1pm the millairdryer6_1pm to set
	 */
	public void setMillairdryer6_1pm(String millairdryer6_1pm) {
		this.millairdryer6_1pm = millairdryer6_1pm;
	}
	/**
	 * @return the millairdryer6_5pm
	 */
	public String getMillairdryer6_5pm() {
		return millairdryer6_5pm;
	}
	/**
	 * @param millairdryer6_5pm the millairdryer6_5pm to set
	 */
	public void setMillairdryer6_5pm(String millairdryer6_5pm) {
		this.millairdryer6_5pm = millairdryer6_5pm;
	}
	/**
	 * @return the millairdryer6_9pm
	 */
	public String getMillairdryer6_9pm() {
		return millairdryer6_9pm;
	}
	/**
	 * @param millairdryer6_9pm the millairdryer6_9pm to set
	 */
	public void setMillairdryer6_9pm(String millairdryer6_9pm) {
		this.millairdryer6_9pm = millairdryer6_9pm;
	}
	/**
	 * @return the millairdryer6_1am
	 */
	public String getMillairdryer6_1am() {
		return millairdryer6_1am;
	}
	/**
	 * @param millairdryer6_1am the millairdryer6_1am to set
	 */
	public void setMillairdryer6_1am(String millairdryer6_1am) {
		this.millairdryer6_1am = millairdryer6_1am;
	}
	/**
	 * @return the millairdryer6_5am
	 */
	public String getMillairdryer6_5am() {
		return millairdryer6_5am;
	}
	/**
	 * @param millairdryer6_5am the millairdryer6_5am to set
	 */
	public void setMillairdryer6_5am(String millairdryer6_5am) {
		this.millairdryer6_5am = millairdryer6_5am;
	}
	/**
	 * @return the millairdryer7_freq
	 */
	public String getMillairdryer7_freq() {
		return millairdryer7_freq;
	}
	/**
	 * @param millairdryer7_freq the millairdryer7_freq to set
	 */
	public void setMillairdryer7_freq(String millairdryer7_freq) {
		this.millairdryer7_freq = millairdryer7_freq;
	}
	/**
	 * @return the millairdryer7_9am
	 */
	public String getMillairdryer7_9am() {
		return millairdryer7_9am;
	}
	/**
	 * @param millairdryer7_9am the millairdryer7_9am to set
	 */
	public void setMillairdryer7_9am(String millairdryer7_9am) {
		this.millairdryer7_9am = millairdryer7_9am;
	}
	/**
	 * @return the millairdryer7_1pm
	 */
	public String getMillairdryer7_1pm() {
		return millairdryer7_1pm;
	}
	/**
	 * @param millairdryer7_1pm the millairdryer7_1pm to set
	 */
	public void setMillairdryer7_1pm(String millairdryer7_1pm) {
		this.millairdryer7_1pm = millairdryer7_1pm;
	}
	/**
	 * @return the millairdryer7_5pm
	 */
	public String getMillairdryer7_5pm() {
		return millairdryer7_5pm;
	}
	/**
	 * @param millairdryer7_5pm the millairdryer7_5pm to set
	 */
	public void setMillairdryer7_5pm(String millairdryer7_5pm) {
		this.millairdryer7_5pm = millairdryer7_5pm;
	}
	/**
	 * @return the millairdryer7_9pm
	 */
	public String getMillairdryer7_9pm() {
		return millairdryer7_9pm;
	}
	/**
	 * @param millairdryer7_9pm the millairdryer7_9pm to set
	 */
	public void setMillairdryer7_9pm(String millairdryer7_9pm) {
		this.millairdryer7_9pm = millairdryer7_9pm;
	}
	/**
	 * @return the millairdryer7_1am
	 */
	public String getMillairdryer7_1am() {
		return millairdryer7_1am;
	}
	/**
	 * @param millairdryer7_1am the millairdryer7_1am to set
	 */
	public void setMillairdryer7_1am(String millairdryer7_1am) {
		this.millairdryer7_1am = millairdryer7_1am;
	}
	/**
	 * @return the millairdryer7_5am
	 */
	public String getMillairdryer7_5am() {
		return millairdryer7_5am;
	}
	/**
	 * @param millairdryer7_5am the millairdryer7_5am to set
	 */
	public void setMillairdryer7_5am(String millairdryer7_5am) {
		this.millairdryer7_5am = millairdryer7_5am;
	}
	/**
	 * @return the polymerareawaterflowrate1_freq
	 */
	public String getPolymerareawaterflowrate1_freq() {
		return polymerareawaterflowrate1_freq;
	}
	/**
	 * @param polymerareawaterflowrate1_freq the polymerareawaterflowrate1_freq to set
	 */
	public void setPolymerareawaterflowrate1_freq(String polymerareawaterflowrate1_freq) {
		this.polymerareawaterflowrate1_freq = polymerareawaterflowrate1_freq;
	}
	/**
	 * @return the polymerareawaterflowrate1_9am
	 */
	public String getPolymerareawaterflowrate1_9am() {
		return polymerareawaterflowrate1_9am;
	}
	/**
	 * @param polymerareawaterflowrate1_9am the polymerareawaterflowrate1_9am to set
	 */
	public void setPolymerareawaterflowrate1_9am(String polymerareawaterflowrate1_9am) {
		this.polymerareawaterflowrate1_9am = polymerareawaterflowrate1_9am;
	}
	/**
	 * @return the polymerareawaterflowrate1_1pm
	 */
	public String getPolymerareawaterflowrate1_1pm() {
		return polymerareawaterflowrate1_1pm;
	}
	/**
	 * @param polymerareawaterflowrate1_1pm the polymerareawaterflowrate1_1pm to set
	 */
	public void setPolymerareawaterflowrate1_1pm(String polymerareawaterflowrate1_1pm) {
		this.polymerareawaterflowrate1_1pm = polymerareawaterflowrate1_1pm;
	}
	/**
	 * @return the polymerareawaterflowrate1_5pm
	 */
	public String getPolymerareawaterflowrate1_5pm() {
		return polymerareawaterflowrate1_5pm;
	}
	/**
	 * @param polymerareawaterflowrate1_5pm the polymerareawaterflowrate1_5pm to set
	 */
	public void setPolymerareawaterflowrate1_5pm(String polymerareawaterflowrate1_5pm) {
		this.polymerareawaterflowrate1_5pm = polymerareawaterflowrate1_5pm;
	}
	/**
	 * @return the polymerareawaterflowrate1_9pm
	 */
	public String getPolymerareawaterflowrate1_9pm() {
		return polymerareawaterflowrate1_9pm;
	}
	/**
	 * @param polymerareawaterflowrate1_9pm the polymerareawaterflowrate1_9pm to set
	 */
	public void setPolymerareawaterflowrate1_9pm(String polymerareawaterflowrate1_9pm) {
		this.polymerareawaterflowrate1_9pm = polymerareawaterflowrate1_9pm;
	}
	/**
	 * @return the polymerareawaterflowrate1_1am
	 */
	public String getPolymerareawaterflowrate1_1am() {
		return polymerareawaterflowrate1_1am;
	}
	/**
	 * @param polymerareawaterflowrate1_1am the polymerareawaterflowrate1_1am to set
	 */
	public void setPolymerareawaterflowrate1_1am(String polymerareawaterflowrate1_1am) {
		this.polymerareawaterflowrate1_1am = polymerareawaterflowrate1_1am;
	}
	/**
	 * @return the polymerareawaterflowrate1_5am
	 */
	public String getPolymerareawaterflowrate1_5am() {
		return polymerareawaterflowrate1_5am;
	}
	/**
	 * @param polymerareawaterflowrate1_5am the polymerareawaterflowrate1_5am to set
	 */
	public void setPolymerareawaterflowrate1_5am(String polymerareawaterflowrate1_5am) {
		this.polymerareawaterflowrate1_5am = polymerareawaterflowrate1_5am;
	}
	/**
	 * @return the polymerareawaterflowrate2_freq
	 */
	public String getPolymerareawaterflowrate2_freq() {
		return polymerareawaterflowrate2_freq;
	}
	/**
	 * @param polymerareawaterflowrate2_freq the polymerareawaterflowrate2_freq to set
	 */
	public void setPolymerareawaterflowrate2_freq(String polymerareawaterflowrate2_freq) {
		this.polymerareawaterflowrate2_freq = polymerareawaterflowrate2_freq;
	}
	/**
	 * @return the polymerareawaterflowrate2_9am
	 */
	public String getPolymerareawaterflowrate2_9am() {
		return polymerareawaterflowrate2_9am;
	}
	/**
	 * @param polymerareawaterflowrate2_9am the polymerareawaterflowrate2_9am to set
	 */
	public void setPolymerareawaterflowrate2_9am(String polymerareawaterflowrate2_9am) {
		this.polymerareawaterflowrate2_9am = polymerareawaterflowrate2_9am;
	}
	/**
	 * @return the polymerareawaterflowrate2_1pm
	 */
	public String getPolymerareawaterflowrate2_1pm() {
		return polymerareawaterflowrate2_1pm;
	}
	/**
	 * @param polymerareawaterflowrate2_1pm the polymerareawaterflowrate2_1pm to set
	 */
	public void setPolymerareawaterflowrate2_1pm(String polymerareawaterflowrate2_1pm) {
		this.polymerareawaterflowrate2_1pm = polymerareawaterflowrate2_1pm;
	}
	/**
	 * @return the polymerareawaterflowrate2_5pm
	 */
	public String getPolymerareawaterflowrate2_5pm() {
		return polymerareawaterflowrate2_5pm;
	}
	/**
	 * @param polymerareawaterflowrate2_5pm the polymerareawaterflowrate2_5pm to set
	 */
	public void setPolymerareawaterflowrate2_5pm(String polymerareawaterflowrate2_5pm) {
		this.polymerareawaterflowrate2_5pm = polymerareawaterflowrate2_5pm;
	}
	/**
	 * @return the polymerareawaterflowrate2_9pm
	 */
	public String getPolymerareawaterflowrate2_9pm() {
		return polymerareawaterflowrate2_9pm;
	}
	/**
	 * @param polymerareawaterflowrate2_9pm the polymerareawaterflowrate2_9pm to set
	 */
	public void setPolymerareawaterflowrate2_9pm(String polymerareawaterflowrate2_9pm) {
		this.polymerareawaterflowrate2_9pm = polymerareawaterflowrate2_9pm;
	}
	/**
	 * @return the polymerareawaterflowrate2_1am
	 */
	public String getPolymerareawaterflowrate2_1am() {
		return polymerareawaterflowrate2_1am;
	}
	/**
	 * @param polymerareawaterflowrate2_1am the polymerareawaterflowrate2_1am to set
	 */
	public void setPolymerareawaterflowrate2_1am(String polymerareawaterflowrate2_1am) {
		this.polymerareawaterflowrate2_1am = polymerareawaterflowrate2_1am;
	}
	/**
	 * @return the polymerareawaterflowrate2_5am
	 */
	public String getPolymerareawaterflowrate2_5am() {
		return polymerareawaterflowrate2_5am;
	}
	/**
	 * @param polymerareawaterflowrate2_5am the polymerareawaterflowrate2_5am to set
	 */
	public void setPolymerareawaterflowrate2_5am(String polymerareawaterflowrate2_5am) {
		this.polymerareawaterflowrate2_5am = polymerareawaterflowrate2_5am;
	}
	/**
	 * @return the polymerareawaterflowrate3_freq
	 */
	public String getPolymerareawaterflowrate3_freq() {
		return polymerareawaterflowrate3_freq;
	}
	/**
	 * @param polymerareawaterflowrate3_freq the polymerareawaterflowrate3_freq to set
	 */
	public void setPolymerareawaterflowrate3_freq(String polymerareawaterflowrate3_freq) {
		this.polymerareawaterflowrate3_freq = polymerareawaterflowrate3_freq;
	}
	/**
	 * @return the polymerareawaterflowrate3_9am
	 */
	public String getPolymerareawaterflowrate3_9am() {
		return polymerareawaterflowrate3_9am;
	}
	/**
	 * @param polymerareawaterflowrate3_9am the polymerareawaterflowrate3_9am to set
	 */
	public void setPolymerareawaterflowrate3_9am(String polymerareawaterflowrate3_9am) {
		this.polymerareawaterflowrate3_9am = polymerareawaterflowrate3_9am;
	}
	/**
	 * @return the polymerareawaterflowrate3_1pm
	 */
	public String getPolymerareawaterflowrate3_1pm() {
		return polymerareawaterflowrate3_1pm;
	}
	/**
	 * @param polymerareawaterflowrate3_1pm the polymerareawaterflowrate3_1pm to set
	 */
	public void setPolymerareawaterflowrate3_1pm(String polymerareawaterflowrate3_1pm) {
		this.polymerareawaterflowrate3_1pm = polymerareawaterflowrate3_1pm;
	}
	/**
	 * @return the polymerareawaterflowrate3_5pm
	 */
	public String getPolymerareawaterflowrate3_5pm() {
		return polymerareawaterflowrate3_5pm;
	}
	/**
	 * @param polymerareawaterflowrate3_5pm the polymerareawaterflowrate3_5pm to set
	 */
	public void setPolymerareawaterflowrate3_5pm(String polymerareawaterflowrate3_5pm) {
		this.polymerareawaterflowrate3_5pm = polymerareawaterflowrate3_5pm;
	}
	/**
	 * @return the polymerareawaterflowrate3_9pm
	 */
	public String getPolymerareawaterflowrate3_9pm() {
		return polymerareawaterflowrate3_9pm;
	}
	/**
	 * @param polymerareawaterflowrate3_9pm the polymerareawaterflowrate3_9pm to set
	 */
	public void setPolymerareawaterflowrate3_9pm(String polymerareawaterflowrate3_9pm) {
		this.polymerareawaterflowrate3_9pm = polymerareawaterflowrate3_9pm;
	}
	/**
	 * @return the polymerareawaterflowrate3_1am
	 */
	public String getPolymerareawaterflowrate3_1am() {
		return polymerareawaterflowrate3_1am;
	}
	/**
	 * @param polymerareawaterflowrate3_1am the polymerareawaterflowrate3_1am to set
	 */
	public void setPolymerareawaterflowrate3_1am(String polymerareawaterflowrate3_1am) {
		this.polymerareawaterflowrate3_1am = polymerareawaterflowrate3_1am;
	}
	/**
	 * @return the polymerareawaterflowrate3_5am
	 */
	public String getPolymerareawaterflowrate3_5am() {
		return polymerareawaterflowrate3_5am;
	}
	/**
	 * @param polymerareawaterflowrate3_5am the polymerareawaterflowrate3_5am to set
	 */
	public void setPolymerareawaterflowrate3_5am(String polymerareawaterflowrate3_5am) {
		this.polymerareawaterflowrate3_5am = polymerareawaterflowrate3_5am;
	}
	/**
	 * @return the polymerflowrate1_freq
	 */
	public String getPolymerflowrate1_freq() {
		return polymerflowrate1_freq;
	}
	/**
	 * @param polymerflowrate1_freq the polymerflowrate1_freq to set
	 */
	public void setPolymerflowrate1_freq(String polymerflowrate1_freq) {
		this.polymerflowrate1_freq = polymerflowrate1_freq;
	}
	/**
	 * @return the polymerflowrate1_9am
	 */
	public String getPolymerflowrate1_9am() {
		return polymerflowrate1_9am;
	}
	/**
	 * @param polymerflowrate1_9am the polymerflowrate1_9am to set
	 */
	public void setPolymerflowrate1_9am(String polymerflowrate1_9am) {
		this.polymerflowrate1_9am = polymerflowrate1_9am;
	}
	/**
	 * @return the polymerflowrate1_1pm
	 */
	public String getPolymerflowrate1_1pm() {
		return polymerflowrate1_1pm;
	}
	/**
	 * @param polymerflowrate1_1pm the polymerflowrate1_1pm to set
	 */
	public void setPolymerflowrate1_1pm(String polymerflowrate1_1pm) {
		this.polymerflowrate1_1pm = polymerflowrate1_1pm;
	}
	/**
	 * @return the polymerflowrate1_5pm
	 */
	public String getPolymerflowrate1_5pm() {
		return polymerflowrate1_5pm;
	}
	/**
	 * @param polymerflowrate1_5pm the polymerflowrate1_5pm to set
	 */
	public void setPolymerflowrate1_5pm(String polymerflowrate1_5pm) {
		this.polymerflowrate1_5pm = polymerflowrate1_5pm;
	}
	/**
	 * @return the polymerflowrate1_9pm
	 */
	public String getPolymerflowrate1_9pm() {
		return polymerflowrate1_9pm;
	}
	/**
	 * @param polymerflowrate1_9pm the polymerflowrate1_9pm to set
	 */
	public void setPolymerflowrate1_9pm(String polymerflowrate1_9pm) {
		this.polymerflowrate1_9pm = polymerflowrate1_9pm;
	}
	/**
	 * @return the polymerflowrate1_1am
	 */
	public String getPolymerflowrate1_1am() {
		return polymerflowrate1_1am;
	}
	/**
	 * @param polymerflowrate1_1am the polymerflowrate1_1am to set
	 */
	public void setPolymerflowrate1_1am(String polymerflowrate1_1am) {
		this.polymerflowrate1_1am = polymerflowrate1_1am;
	}
	/**
	 * @return the polymerflowrate1_5am
	 */
	public String getPolymerflowrate1_5am() {
		return polymerflowrate1_5am;
	}
	/**
	 * @param polymerflowrate1_5am the polymerflowrate1_5am to set
	 */
	public void setPolymerflowrate1_5am(String polymerflowrate1_5am) {
		this.polymerflowrate1_5am = polymerflowrate1_5am;
	}
	/**
	 * @return the polymerflowrate2_freq
	 */
	public String getPolymerflowrate2_freq() {
		return polymerflowrate2_freq;
	}
	/**
	 * @param polymerflowrate2_freq the polymerflowrate2_freq to set
	 */
	public void setPolymerflowrate2_freq(String polymerflowrate2_freq) {
		this.polymerflowrate2_freq = polymerflowrate2_freq;
	}
	/**
	 * @return the polymerflowrate2_9am
	 */
	public String getPolymerflowrate2_9am() {
		return polymerflowrate2_9am;
	}
	/**
	 * @param polymerflowrate2_9am the polymerflowrate2_9am to set
	 */
	public void setPolymerflowrate2_9am(String polymerflowrate2_9am) {
		this.polymerflowrate2_9am = polymerflowrate2_9am;
	}
	/**
	 * @return the polymerflowrate2_1pm
	 */
	public String getPolymerflowrate2_1pm() {
		return polymerflowrate2_1pm;
	}
	/**
	 * @param polymerflowrate2_1pm the polymerflowrate2_1pm to set
	 */
	public void setPolymerflowrate2_1pm(String polymerflowrate2_1pm) {
		this.polymerflowrate2_1pm = polymerflowrate2_1pm;
	}
	/**
	 * @return the polymerflowrate2_5pm
	 */
	public String getPolymerflowrate2_5pm() {
		return polymerflowrate2_5pm;
	}
	/**
	 * @param polymerflowrate2_5pm the polymerflowrate2_5pm to set
	 */
	public void setPolymerflowrate2_5pm(String polymerflowrate2_5pm) {
		this.polymerflowrate2_5pm = polymerflowrate2_5pm;
	}
	/**
	 * @return the polymerflowrate2_9pm
	 */
	public String getPolymerflowrate2_9pm() {
		return polymerflowrate2_9pm;
	}
	/**
	 * @param polymerflowrate2_9pm the polymerflowrate2_9pm to set
	 */
	public void setPolymerflowrate2_9pm(String polymerflowrate2_9pm) {
		this.polymerflowrate2_9pm = polymerflowrate2_9pm;
	}
	/**
	 * @return the polymerflowrate2_1am
	 */
	public String getPolymerflowrate2_1am() {
		return polymerflowrate2_1am;
	}
	/**
	 * @param polymerflowrate2_1am the polymerflowrate2_1am to set
	 */
	public void setPolymerflowrate2_1am(String polymerflowrate2_1am) {
		this.polymerflowrate2_1am = polymerflowrate2_1am;
	}
	/**
	 * @return the polymerflowrate2_5am
	 */
	public String getPolymerflowrate2_5am() {
		return polymerflowrate2_5am;
	}
	/**
	 * @param polymerflowrate2_5am the polymerflowrate2_5am to set
	 */
	public void setPolymerflowrate2_5am(String polymerflowrate2_5am) {
		this.polymerflowrate2_5am = polymerflowrate2_5am;
	}
	/**
	 * @return the polymerflowrate3_freq
	 */
	public String getPolymerflowrate3_freq() {
		return polymerflowrate3_freq;
	}
	/**
	 * @param polymerflowrate3_freq the polymerflowrate3_freq to set
	 */
	public void setPolymerflowrate3_freq(String polymerflowrate3_freq) {
		this.polymerflowrate3_freq = polymerflowrate3_freq;
	}
	/**
	 * @return the polymerflowrate3_9am
	 */
	public String getPolymerflowrate3_9am() {
		return polymerflowrate3_9am;
	}
	/**
	 * @param polymerflowrate3_9am the polymerflowrate3_9am to set
	 */
	public void setPolymerflowrate3_9am(String polymerflowrate3_9am) {
		this.polymerflowrate3_9am = polymerflowrate3_9am;
	}
	/**
	 * @return the polymerflowrate3_1pm
	 */
	public String getPolymerflowrate3_1pm() {
		return polymerflowrate3_1pm;
	}
	/**
	 * @param polymerflowrate3_1pm the polymerflowrate3_1pm to set
	 */
	public void setPolymerflowrate3_1pm(String polymerflowrate3_1pm) {
		this.polymerflowrate3_1pm = polymerflowrate3_1pm;
	}
	/**
	 * @return the polymerflowrate3_5pm
	 */
	public String getPolymerflowrate3_5pm() {
		return polymerflowrate3_5pm;
	}
	/**
	 * @param polymerflowrate3_5pm the polymerflowrate3_5pm to set
	 */
	public void setPolymerflowrate3_5pm(String polymerflowrate3_5pm) {
		this.polymerflowrate3_5pm = polymerflowrate3_5pm;
	}
	/**
	 * @return the polymerflowrate3_9pm
	 */
	public String getPolymerflowrate3_9pm() {
		return polymerflowrate3_9pm;
	}
	/**
	 * @param polymerflowrate3_9pm the polymerflowrate3_9pm to set
	 */
	public void setPolymerflowrate3_9pm(String polymerflowrate3_9pm) {
		this.polymerflowrate3_9pm = polymerflowrate3_9pm;
	}
	/**
	 * @return the polymerflowrate3_1am
	 */
	public String getPolymerflowrate3_1am() {
		return polymerflowrate3_1am;
	}
	/**
	 * @param polymerflowrate3_1am the polymerflowrate3_1am to set
	 */
	public void setPolymerflowrate3_1am(String polymerflowrate3_1am) {
		this.polymerflowrate3_1am = polymerflowrate3_1am;
	}
	/**
	 * @return the polymerflowrate3_5am
	 */
	public String getPolymerflowrate3_5am() {
		return polymerflowrate3_5am;
	}
	/**
	 * @param polymerflowrate3_5am the polymerflowrate3_5am to set
	 */
	public void setPolymerflowrate3_5am(String polymerflowrate3_5am) {
		this.polymerflowrate3_5am = polymerflowrate3_5am;
	}
	/**
	 * @return the totelevels1_freq
	 */
	public String getTotelevels1_freq() {
		return totelevels1_freq;
	}
	/**
	 * @param totelevels1_freq the totelevels1_freq to set
	 */
	public void setTotelevels1_freq(String totelevels1_freq) {
		this.totelevels1_freq = totelevels1_freq;
	}
	/**
	 * @return the totelevels1_9am
	 */
	public String getTotelevels1_9am() {
		return totelevels1_9am;
	}
	/**
	 * @param totelevels1_9am the totelevels1_9am to set
	 */
	public void setTotelevels1_9am(String totelevels1_9am) {
		this.totelevels1_9am = totelevels1_9am;
	}
	/**
	 * @return the totelevels1_1pm
	 */
	public String getTotelevels1_1pm() {
		return totelevels1_1pm;
	}
	/**
	 * @param totelevels1_1pm the totelevels1_1pm to set
	 */
	public void setTotelevels1_1pm(String totelevels1_1pm) {
		this.totelevels1_1pm = totelevels1_1pm;
	}
	/**
	 * @return the totelevels1_5pm
	 */
	public String getTotelevels1_5pm() {
		return totelevels1_5pm;
	}
	/**
	 * @param totelevels1_5pm the totelevels1_5pm to set
	 */
	public void setTotelevels1_5pm(String totelevels1_5pm) {
		this.totelevels1_5pm = totelevels1_5pm;
	}
	/**
	 * @return the totelevels1_9pm
	 */
	public String getTotelevels1_9pm() {
		return totelevels1_9pm;
	}
	/**
	 * @param totelevels1_9pm the totelevels1_9pm to set
	 */
	public void setTotelevels1_9pm(String totelevels1_9pm) {
		this.totelevels1_9pm = totelevels1_9pm;
	}
	/**
	 * @return the totelevels1_1am
	 */
	public String getTotelevels1_1am() {
		return totelevels1_1am;
	}
	/**
	 * @param totelevels1_1am the totelevels1_1am to set
	 */
	public void setTotelevels1_1am(String totelevels1_1am) {
		this.totelevels1_1am = totelevels1_1am;
	}
	/**
	 * @return the totelevels1_5am
	 */
	public String getTotelevels1_5am() {
		return totelevels1_5am;
	}
	/**
	 * @param totelevels1_5am the totelevels1_5am to set
	 */
	public void setTotelevels1_5am(String totelevels1_5am) {
		this.totelevels1_5am = totelevels1_5am;
	}
	/**
	 * @return the totelevels2_freq
	 */
	public String getTotelevels2_freq() {
		return totelevels2_freq;
	}
	/**
	 * @param totelevels2_freq the totelevels2_freq to set
	 */
	public void setTotelevels2_freq(String totelevels2_freq) {
		this.totelevels2_freq = totelevels2_freq;
	}
	/**
	 * @return the totelevels2_9am
	 */
	public String getTotelevels2_9am() {
		return totelevels2_9am;
	}
	/**
	 * @param totelevels2_9am the totelevels2_9am to set
	 */
	public void setTotelevels2_9am(String totelevels2_9am) {
		this.totelevels2_9am = totelevels2_9am;
	}
	/**
	 * @return the totelevels2_1pm
	 */
	public String getTotelevels2_1pm() {
		return totelevels2_1pm;
	}
	/**
	 * @param totelevels2_1pm the totelevels2_1pm to set
	 */
	public void setTotelevels2_1pm(String totelevels2_1pm) {
		this.totelevels2_1pm = totelevels2_1pm;
	}
	/**
	 * @return the totelevels2_5pm
	 */
	public String getTotelevels2_5pm() {
		return totelevels2_5pm;
	}
	/**
	 * @param totelevels2_5pm the totelevels2_5pm to set
	 */
	public void setTotelevels2_5pm(String totelevels2_5pm) {
		this.totelevels2_5pm = totelevels2_5pm;
	}
	/**
	 * @return the totelevels2_9pm
	 */
	public String getTotelevels2_9pm() {
		return totelevels2_9pm;
	}
	/**
	 * @param totelevels2_9pm the totelevels2_9pm to set
	 */
	public void setTotelevels2_9pm(String totelevels2_9pm) {
		this.totelevels2_9pm = totelevels2_9pm;
	}
	/**
	 * @return the totelevels2_1am
	 */
	public String getTotelevels2_1am() {
		return totelevels2_1am;
	}
	/**
	 * @param totelevels2_1am the totelevels2_1am to set
	 */
	public void setTotelevels2_1am(String totelevels2_1am) {
		this.totelevels2_1am = totelevels2_1am;
	}
	/**
	 * @return the totelevels2_5am
	 */
	public String getTotelevels2_5am() {
		return totelevels2_5am;
	}
	/**
	 * @param totelevels2_5am the totelevels2_5am to set
	 */
	public void setTotelevels2_5am(String totelevels2_5am) {
		this.totelevels2_5am = totelevels2_5am;
	}
	/**
	 * @return the totelevels3_freq
	 */
	public String getTotelevels3_freq() {
		return totelevels3_freq;
	}
	/**
	 * @param totelevels3_freq the totelevels3_freq to set
	 */
	public void setTotelevels3_freq(String totelevels3_freq) {
		this.totelevels3_freq = totelevels3_freq;
	}
	/**
	 * @return the totelevels3_9am
	 */
	public String getTotelevels3_9am() {
		return totelevels3_9am;
	}
	/**
	 * @param totelevels3_9am the totelevels3_9am to set
	 */
	public void setTotelevels3_9am(String totelevels3_9am) {
		this.totelevels3_9am = totelevels3_9am;
	}
	/**
	 * @return the totelevels3_1pm
	 */
	public String getTotelevels3_1pm() {
		return totelevels3_1pm;
	}
	/**
	 * @param totelevels3_1pm the totelevels3_1pm to set
	 */
	public void setTotelevels3_1pm(String totelevels3_1pm) {
		this.totelevels3_1pm = totelevels3_1pm;
	}
	/**
	 * @return the totelevels3_5pm
	 */
	public String getTotelevels3_5pm() {
		return totelevels3_5pm;
	}
	/**
	 * @param totelevels3_5pm the totelevels3_5pm to set
	 */
	public void setTotelevels3_5pm(String totelevels3_5pm) {
		this.totelevels3_5pm = totelevels3_5pm;
	}
	/**
	 * @return the totelevels3_9pm
	 */
	public String getTotelevels3_9pm() {
		return totelevels3_9pm;
	}
	/**
	 * @param totelevels3_9pm the totelevels3_9pm to set
	 */
	public void setTotelevels3_9pm(String totelevels3_9pm) {
		this.totelevels3_9pm = totelevels3_9pm;
	}
	/**
	 * @return the totelevels3_1am
	 */
	public String getTotelevels3_1am() {
		return totelevels3_1am;
	}
	/**
	 * @param totelevels3_1am the totelevels3_1am to set
	 */
	public void setTotelevels3_1am(String totelevels3_1am) {
		this.totelevels3_1am = totelevels3_1am;
	}
	/**
	 * @return the totelevels3_5am
	 */
	public String getTotelevels3_5am() {
		return totelevels3_5am;
	}
	/**
	 * @param totelevels3_5am the totelevels3_5am to set
	 */
	public void setTotelevels3_5am(String totelevels3_5am) {
		this.totelevels3_5am = totelevels3_5am;
	}
	/**
	 * @return the totelevels4_freq
	 */
	public String getTotelevels4_freq() {
		return totelevels4_freq;
	}
	/**
	 * @param totelevels4_freq the totelevels4_freq to set
	 */
	public void setTotelevels4_freq(String totelevels4_freq) {
		this.totelevels4_freq = totelevels4_freq;
	}
	/**
	 * @return the totelevels4_9am
	 */
	public String getTotelevels4_9am() {
		return totelevels4_9am;
	}
	/**
	 * @param totelevels4_9am the totelevels4_9am to set
	 */
	public void setTotelevels4_9am(String totelevels4_9am) {
		this.totelevels4_9am = totelevels4_9am;
	}
	/**
	 * @return the totelevels4_1pm
	 */
	public String getTotelevels4_1pm() {
		return totelevels4_1pm;
	}
	/**
	 * @param totelevels4_1pm the totelevels4_1pm to set
	 */
	public void setTotelevels4_1pm(String totelevels4_1pm) {
		this.totelevels4_1pm = totelevels4_1pm;
	}
	/**
	 * @return the totelevels4_5pm
	 */
	public String getTotelevels4_5pm() {
		return totelevels4_5pm;
	}
	/**
	 * @param totelevels4_5pm the totelevels4_5pm to set
	 */
	public void setTotelevels4_5pm(String totelevels4_5pm) {
		this.totelevels4_5pm = totelevels4_5pm;
	}
	/**
	 * @return the totelevels4_9pm
	 */
	public String getTotelevels4_9pm() {
		return totelevels4_9pm;
	}
	/**
	 * @param totelevels4_9pm the totelevels4_9pm to set
	 */
	public void setTotelevels4_9pm(String totelevels4_9pm) {
		this.totelevels4_9pm = totelevels4_9pm;
	}
	/**
	 * @return the totelevels4_1am
	 */
	public String getTotelevels4_1am() {
		return totelevels4_1am;
	}
	/**
	 * @param totelevels4_1am the totelevels4_1am to set
	 */
	public void setTotelevels4_1am(String totelevels4_1am) {
		this.totelevels4_1am = totelevels4_1am;
	}
	/**
	 * @return the totelevels4_5am
	 */
	public String getTotelevels4_5am() {
		return totelevels4_5am;
	}
	/**
	 * @param totelevels4_5am the totelevels4_5am to set
	 */
	public void setTotelevels4_5am(String totelevels4_5am) {
		this.totelevels4_5am = totelevels4_5am;
	}
	/**
	 * @return the comments
	 */
	public String getComments() {
		return comments;
	}
	/**
	 * @param comments the comments to set
	 */
	public void setComments(String comments) {
		this.comments = comments;
	}
	/**
	 * @return the techniciansinitials_freq
	 */
	public String getTechniciansinitials_freq() {
		return techniciansinitials_freq;
	}
	/**
	 * @param techniciansinitials_freq the techniciansinitials_freq to set
	 */
	public void setTechniciansinitials_freq(String techniciansinitials_freq) {
		this.techniciansinitials_freq = techniciansinitials_freq;
	}
	/**
	 * @return the techniciansinitials_9am
	 */
	public String getTechniciansinitials_9am() {
		return techniciansinitials_9am;
	}
	/**
	 * @param techniciansinitials_9am the techniciansinitials_9am to set
	 */
	public void setTechniciansinitials_9am(String techniciansinitials_9am) {
		this.techniciansinitials_9am = techniciansinitials_9am;
	}
	/**
	 * @return the techniciansinitials_1pm
	 */
	public String getTechniciansinitials_1pm() {
		return techniciansinitials_1pm;
	}
	/**
	 * @param techniciansinitials_1pm the techniciansinitials_1pm to set
	 */
	public void setTechniciansinitials_1pm(String techniciansinitials_1pm) {
		this.techniciansinitials_1pm = techniciansinitials_1pm;
	}
	/**
	 * @return the techniciansinitials_5pm
	 */
	public String getTechniciansinitials_5pm() {
		return techniciansinitials_5pm;
	}
	/**
	 * @param techniciansinitials_5pm the techniciansinitials_5pm to set
	 */
	public void setTechniciansinitials_5pm(String techniciansinitials_5pm) {
		this.techniciansinitials_5pm = techniciansinitials_5pm;
	}
	/**
	 * @return the techniciansinitials_9pm
	 */
	public String getTechniciansinitials_9pm() {
		return techniciansinitials_9pm;
	}
	/**
	 * @param techniciansinitials_9pm the techniciansinitials_9pm to set
	 */
	public void setTechniciansinitials_9pm(String techniciansinitials_9pm) {
		this.techniciansinitials_9pm = techniciansinitials_9pm;
	}
	/**
	 * @return the techniciansinitials_1am
	 */
	public String getTechniciansinitials_1am() {
		return techniciansinitials_1am;
	}
	/**
	 * @param techniciansinitials_1am the techniciansinitials_1am to set
	 */
	public void setTechniciansinitials_1am(String techniciansinitials_1am) {
		this.techniciansinitials_1am = techniciansinitials_1am;
	}
	/**
	 * @return the techniciansinitials_5am
	 */
	public String getTechniciansinitials_5am() {
		return techniciansinitials_5am;
	}
	/**
	 * @param techniciansinitials_5am the techniciansinitials_5am to set
	 */
	public void setTechniciansinitials_5am(String techniciansinitials_5am) {
		this.techniciansinitials_5am = techniciansinitials_5am;
	}
	/**
	 * @return the cmt9amarea
	 */
	public String getCmt9amarea() {
		return cmt9amarea;
	}
	/**
	 * @param cmt9amarea the cmt9amarea to set
	 */
	public void setCmt9amarea(String cmt9amarea) {
		this.cmt9amarea = cmt9amarea;
	}
	/**
	 * @return the cmt1pmarea
	 */
	public String getCmt1pmarea() {
		return cmt1pmarea;
	}
	/**
	 * @param cmt1pmarea the cmt1pmarea to set
	 */
	public void setCmt1pmarea(String cmt1pmarea) {
		this.cmt1pmarea = cmt1pmarea;
	}
	/**
	 * @return the cmt5pmarea
	 */
	public String getCmt5pmarea() {
		return cmt5pmarea;
	}
	/**
	 * @param cmt5pmarea the cmt5pmarea to set
	 */
	public void setCmt5pmarea(String cmt5pmarea) {
		this.cmt5pmarea = cmt5pmarea;
	}
	/**
	 * @return the cmt9pmarea
	 */
	public String getCmt9pmarea() {
		return cmt9pmarea;
	}
	/**
	 * @param cmt9pmarea the cmt9pmarea to set
	 */
	public void setCmt9pmarea(String cmt9pmarea) {
		this.cmt9pmarea = cmt9pmarea;
	}
	/**
	 * @return the cmt1amarea
	 */
	public String getCmt1amarea() {
		return cmt1amarea;
	}
	/**
	 * @param cmt1amarea the cmt1amarea to set
	 */
	public void setCmt1amarea(String cmt1amarea) {
		this.cmt1amarea = cmt1amarea;
	}
	/**
	 * @return the cmt5amarea
	 */
	public String getCmt5amarea() {
		return cmt5amarea;
	}
	/**
	 * @param cmt5amarea the cmt5amarea to set
	 */
	public void setCmt5amarea(String cmt5amarea) {
		this.cmt5amarea = cmt5amarea;
	}
	/**
	 * @return the ok
	 */
	public String getOk() {
		return ok;
	}
	/**
	 * @param ok the ok to set
	 */
	public void setOk(String ok) {
		this.ok = ok;
	}
	/**
	 * @return the button1pm
	 */
	public String getButton1pm() {
		return button1pm;
	}
	/**
	 * @param button1pm the button1pm to set
	 */
	public void setButton1pm(String button1pm) {
		this.button1pm = button1pm;
	}
	/**
	 * @return the button5pm
	 */
	public String getButton5pm() {
		return button5pm;
	}
	/**
	 * @param button5pm the button5pm to set
	 */
	public void setButton5pm(String button5pm) {
		this.button5pm = button5pm;
	}
	/**
	 * @return the button9pm
	 */
	public String getButton9pm() {
		return button9pm;
	}
	/**
	 * @param button9pm the button9pm to set
	 */
	public void setButton9pm(String button9pm) {
		this.button9pm = button9pm;
	}
	/**
	 * @return the button1am
	 */
	public String getButton1am() {
		return button1am;
	}
	/**
	 * @param button1am the button1am to set
	 */
	public void setButton1am(String button1am) {
		this.button1am = button1am;
	}
	/**
	 * @return the button5am
	 */
	public String getButton5am() {
		return button5am;
	}
	/**
	 * @param button5am the button5am to set
	 */
	public void setButton5am(String button5am) {
		this.button5am = button5am;
	}

}

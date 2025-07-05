/**
 *03-Dec-2019
 *OpRoute_5.java
 * TODO
 *com.st.frpobcc.model
 *OpRoute_5.java
 *Roshan Lal Tailor
 */
package com.st.frpobcc.model;

/**
 * @author sohan
 *
 */
public class OpRoute_5 {
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
	private String visualcheckofudrainsforstock1_freq;
	private String visualcheckofudrainsforstock1_10am;
	private String visualcheckofudrainsforstock1_02pm;
	private String visualcheckofudrainsforstock1_06pm;
	private String visualcheckofudrainsforstock1_10pm;
	private String visualcheckofudrainsforstock1_02am;
	private String visualcheckofudrainsforstock1_06am;
	private String visualcheckofudrainsforstock2_freq;
	private String visualcheckofudrainsforstock2_10am;
	private String visualcheckofudrainsforstock2_02pm;
	private String visualcheckofudrainsforstock2_06pm;
	private String visualcheckofudrainsforstock2_10pm;
	private String visualcheckofudrainsforstock2_02am;
	private String visualcheckofudrainsforstock2_06am;
	private String visualcheckofudrainsforstock3_freq;
	private String visualcheckofudrainsforstock3_10am;
	private String visualcheckofudrainsforstock3_02pm;
	private String visualcheckofudrainsforstock3_06pm;
	private String visualcheckofudrainsforstock3_10pm;
	private String visualcheckofudrainsforstock3_02am;
	private String visualcheckofudrainsforstock3_06am;
	private String visualcheckofudrainsforstock4_freq;
	private String visualcheckofudrainsforstock4_10am;
	private String visualcheckofudrainsforstock4_02pm;
	private String visualcheckofudrainsforstock4_06pm;
	private String visualcheckofudrainsforstock4_10pm;
	private String visualcheckofudrainsforstock4_02am;
	private String visualcheckofudrainsforstock4_06am;
	private String visualcheckofudrainsforstock5_freq;
	private String visualcheckofudrainsforstock5_10am;
	private String visualcheckofudrainsforstock5_02pm;
	private String visualcheckofudrainsforstock5_06pm;
	private String visualcheckofudrainsforstock5_10pm;
	private String visualcheckofudrainsforstock5_02am;
	private String visualcheckofudrainsforstock5_06am;
	private String visualcheckofudrainsforstock6_freq;
	private String visualcheckofudrainsforstock6_10am;
	private String visualcheckofudrainsforstock6_02pm;
	private String visualcheckofudrainsforstock6_06pm;
	private String visualcheckofudrainsforstock6_10pm;
	private String visualcheckofudrainsforstock6_02am;
	private String visualcheckofudrainsforstock6_06am;
	private String visualcheckofudrainsforstock7_freq;
	private String visualcheckofudrainsforstock7_10am;
	private String visualcheckofudrainsforstock7_02pm;
	private String visualcheckofudrainsforstock7_06pm;
	private String visualcheckofudrainsforstock7_10pm;
	private String visualcheckofudrainsforstock7_02am;
	private String visualcheckofudrainsforstock7_06am;
	private String visualcheckofudrainsforstock8_freq;
	private String visualcheckofudrainsforstock8_10am;
	private String visualcheckofudrainsforstock8_02pm;
	private String visualcheckofudrainsforstock8_06pm;
	private String visualcheckofudrainsforstock8_10pm;
	private String visualcheckofudrainsforstock8_02am;
	private String visualcheckofudrainsforstock8_06am;
	private String visualcheckofudrainsforstock9_freq;
	private String visualcheckofudrainsforstock9_10am;
	private String visualcheckofudrainsforstock9_02pm;
	private String visualcheckofudrainsforstock9_06pm;
	private String visualcheckofudrainsforstock9_10pm;
	private String visualcheckofudrainsforstock9_02am;
	private String visualcheckofudrainsforstock9_06am;
	private String visualcheckofudrainsforstock10_freq;
	private String visualcheckofudrainsforstock10_10am;
	private String visualcheckofudrainsforstock10_02pm;
	private String visualcheckofudrainsforstock10_06pm;
	private String visualcheckofudrainsforstock10_10pm;
	private String visualcheckofudrainsforstock10_02am;
	private String visualcheckofudrainsforstock10_06am;
	private String visualcheckofudrainsforstock11_freq;
	private String visualcheckofudrainsforstock11_10am;
	private String visualcheckofudrainsforstock11_02pm;
	private String visualcheckofudrainsforstock11_06pm;
	private String visualcheckofudrainsforstock11_10pm;
	private String visualcheckofudrainsforstock11_02am;
	private String visualcheckofudrainsforstock11_06am;
	private String visualcheckofudrainsforstock12_freq;
	private String visualcheckofudrainsforstock12_10am;
	private String visualcheckofudrainsforstock12_02pm;
	private String visualcheckofudrainsforstock12_06pm;
	private String visualcheckofudrainsforstock12_10pm;
	private String visualcheckofudrainsforstock12_02am;
	private String visualcheckofudrainsforstock12_06am;
	private String visualcheckofudrainsforstock13_freq;
	private String visualcheckofudrainsforstock13_10am;
	private String visualcheckofudrainsforstock13_02pm;
	private String visualcheckofudrainsforstock13_06pm;
	private String visualcheckofudrainsforstock13_10pm;
	private String visualcheckofudrainsforstock13_02am;
	private String visualcheckofudrainsforstock13_06am;
	private String visualcheckofudrainsforstock14_freq;
	private String visualcheckofudrainsforstock14_10am;
	private String visualcheckofudrainsforstock14_02pm;
	private String visualcheckofudrainsforstock14_06pm;
	private String visualcheckofudrainsforstock14_10pm;
	private String visualcheckofudrainsforstock14_02am;
	private String visualcheckofudrainsforstock14_06am;
	private String visualcheckofudrainsforstock15_freq;
	private String visualcheckofudrainsforstock15_10am;
	private String visualcheckofudrainsforstock15_02pm;
	private String visualcheckofudrainsforstock15_06pm;
	private String visualcheckofudrainsforstock15_10pm;
	private String visualcheckofudrainsforstock15_02am;
	private String visualcheckofudrainsforstock15_06am;
	private String visualcheckofudrainsforstock16_freq;
	private String visualcheckofudrainsforstock16_10am;
	private String visualcheckofudrainsforstock16_02pm;
	private String visualcheckofudrainsforstock16_06pm;
	private String visualcheckofudrainsforstock16_10pm;
	private String visualcheckofudrainsforstock16_02am;
	private String visualcheckofudrainsforstock16_06am;
	private String visualcheckofudrainsforstock17_freq;
	private String visualcheckofudrainsforstock17_10am;
	private String visualcheckofudrainsforstock17_02pm;
	private String visualcheckofudrainsforstock17_06pm;
	private String visualcheckofudrainsforstock17_10pm;
	private String visualcheckofudrainsforstock17_02am;
	private String visualcheckofudrainsforstock17_06am;
	private String visualcheckofudrainsforstock18_freq;
	private String visualcheckofudrainsforstock18_10am;
	private String visualcheckofudrainsforstock18_02pm;
	private String visualcheckofudrainsforstock18_06pm;
	private String visualcheckofudrainsforstock18_10pm;
	private String visualcheckofudrainsforstock18_02am;
	private String visualcheckofudrainsforstock18_06am;
	private String visualcheckofudrainsforstock19_freq;
	private String visualcheckofudrainsforstock19_10am;
	private String visualcheckofudrainsforstock19_02pm;
	private String visualcheckofudrainsforstock19_06pm;
	private String visualcheckofudrainsforstock19_10pm;
	private String visualcheckofudrainsforstock19_02am;
	private String visualcheckofudrainsforstock19_06am;
	private String visualcheckofudrainsforstock20_freq;
	private String visualcheckofudrainsforstock20_10am;
	private String visualcheckofudrainsforstock20_02pm;
	private String visualcheckofudrainsforstock20_06pm;
	private String visualcheckofudrainsforstock20_10pm;
	private String visualcheckofudrainsforstock20_02am;
	private String visualcheckofudrainsforstock20_06am;
	private String visualcheckofudrainsforstock21_freq;
	private String visualcheckofudrainsforstock21_10am;
	private String visualcheckofudrainsforstock21_02pm;
	private String visualcheckofudrainsforstock21_06pm;
	private String visualcheckofudrainsforstock21_10pm;
	private String visualcheckofudrainsforstock21_02am;
	private String visualcheckofudrainsforstock21_06am;
	
	private String totes1_freq;
	private String totes1_10am;
	private String totes1_02pm;
	private String totes1_06pm;
	private String totes1_10pm;
	private String totes1_02am;
	private String totes1_06am;
	private String totes2_freq;
	private String totes2_10am;
	private String totes2_02pm;
	private String totes2_06pm;
	private String totes2_10pm;
	private String totes2_02am;
	private String totes2_06am;
	
	private String tubeconveyordrive1_freq;
	private String tubeconveyordrive1_10am;
	private String tubeconveyordrive1_02pm;
	private String tubeconveyordrive1_06pm;
	private String tubeconveyordrive1_10pm;
	private String tubeconveyordrive1_02am;
	private String tubeconveyordrive1_06am;
	private String tubeconveyordrive2_freq;
	private String tubeconveyordrive2_10am;
	private String tubeconveyordrive2_02pm;
	private String tubeconveyordrive2_06pm;
	private String tubeconveyordrive2_10pm;
	private String tubeconveyordrive2_02am;
	private String tubeconveyordrive2_06am;
	private String tubeconveyordrive3_freq;
	private String tubeconveyordrive3_10am;
	private String tubeconveyordrive3_02pm;
	private String tubeconveyordrive3_06pm;
	private String tubeconveyordrive3_10pm;
	private String tubeconveyordrive3_02am;
	private String tubeconveyordrive3_06am;
	private String tubeconveyordrive4_freq;
	private String tubeconveyordrive4_10am;
	private String tubeconveyordrive4_02pm;
	private String tubeconveyordrive4_06pm;
	private String tubeconveyordrive4_10pm;
	private String tubeconveyordrive4_02am;
	private String tubeconveyordrive4_06am;
	private String tubeconveyordrive5_freq;
	private String tubeconveyordrive5_10am;
	private String tubeconveyordrive5_02pm;
	private String tubeconveyordrive5_06pm;
	private String tubeconveyordrive5_10pm;
	private String tubeconveyordrive5_02am;
	private String tubeconveyordrive5_06am;
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
	 * @return the visualcheckofudrainsforstock1_freq
	 */
	public String getVisualcheckofudrainsforstock1_freq() {
		return visualcheckofudrainsforstock1_freq;
	}
	/**
	 * @param visualcheckofudrainsforstock1_freq the visualcheckofudrainsforstock1_freq to set
	 */
	public void setVisualcheckofudrainsforstock1_freq(String visualcheckofudrainsforstock1_freq) {
		this.visualcheckofudrainsforstock1_freq = visualcheckofudrainsforstock1_freq;
	}
	/**
	 * @return the visualcheckofudrainsforstock1_10am
	 */
	public String getVisualcheckofudrainsforstock1_10am() {
		return visualcheckofudrainsforstock1_10am;
	}
	/**
	 * @param visualcheckofudrainsforstock1_10am the visualcheckofudrainsforstock1_10am to set
	 */
	public void setVisualcheckofudrainsforstock1_10am(String visualcheckofudrainsforstock1_10am) {
		this.visualcheckofudrainsforstock1_10am = visualcheckofudrainsforstock1_10am;
	}
	/**
	 * @return the visualcheckofudrainsforstock1_02pm
	 */
	public String getVisualcheckofudrainsforstock1_02pm() {
		return visualcheckofudrainsforstock1_02pm;
	}
	/**
	 * @param visualcheckofudrainsforstock1_02pm the visualcheckofudrainsforstock1_02pm to set
	 */
	public void setVisualcheckofudrainsforstock1_02pm(String visualcheckofudrainsforstock1_02pm) {
		this.visualcheckofudrainsforstock1_02pm = visualcheckofudrainsforstock1_02pm;
	}
	/**
	 * @return the visualcheckofudrainsforstock1_06pm
	 */
	public String getVisualcheckofudrainsforstock1_06pm() {
		return visualcheckofudrainsforstock1_06pm;
	}
	/**
	 * @param visualcheckofudrainsforstock1_06pm the visualcheckofudrainsforstock1_06pm to set
	 */
	public void setVisualcheckofudrainsforstock1_06pm(String visualcheckofudrainsforstock1_06pm) {
		this.visualcheckofudrainsforstock1_06pm = visualcheckofudrainsforstock1_06pm;
	}
	/**
	 * @return the visualcheckofudrainsforstock1_10pm
	 */
	public String getVisualcheckofudrainsforstock1_10pm() {
		return visualcheckofudrainsforstock1_10pm;
	}
	/**
	 * @param visualcheckofudrainsforstock1_10pm the visualcheckofudrainsforstock1_10pm to set
	 */
	public void setVisualcheckofudrainsforstock1_10pm(String visualcheckofudrainsforstock1_10pm) {
		this.visualcheckofudrainsforstock1_10pm = visualcheckofudrainsforstock1_10pm;
	}
	/**
	 * @return the visualcheckofudrainsforstock1_02am
	 */
	public String getVisualcheckofudrainsforstock1_02am() {
		return visualcheckofudrainsforstock1_02am;
	}
	/**
	 * @param visualcheckofudrainsforstock1_02am the visualcheckofudrainsforstock1_02am to set
	 */
	public void setVisualcheckofudrainsforstock1_02am(String visualcheckofudrainsforstock1_02am) {
		this.visualcheckofudrainsforstock1_02am = visualcheckofudrainsforstock1_02am;
	}
	/**
	 * @return the visualcheckofudrainsforstock1_06am
	 */
	public String getVisualcheckofudrainsforstock1_06am() {
		return visualcheckofudrainsforstock1_06am;
	}
	/**
	 * @param visualcheckofudrainsforstock1_06am the visualcheckofudrainsforstock1_06am to set
	 */
	public void setVisualcheckofudrainsforstock1_06am(String visualcheckofudrainsforstock1_06am) {
		this.visualcheckofudrainsforstock1_06am = visualcheckofudrainsforstock1_06am;
	}
	/**
	 * @return the visualcheckofudrainsforstock2_freq
	 */
	public String getVisualcheckofudrainsforstock2_freq() {
		return visualcheckofudrainsforstock2_freq;
	}
	/**
	 * @param visualcheckofudrainsforstock2_freq the visualcheckofudrainsforstock2_freq to set
	 */
	public void setVisualcheckofudrainsforstock2_freq(String visualcheckofudrainsforstock2_freq) {
		this.visualcheckofudrainsforstock2_freq = visualcheckofudrainsforstock2_freq;
	}
	/**
	 * @return the visualcheckofudrainsforstock2_10am
	 */
	public String getVisualcheckofudrainsforstock2_10am() {
		return visualcheckofudrainsforstock2_10am;
	}
	/**
	 * @param visualcheckofudrainsforstock2_10am the visualcheckofudrainsforstock2_10am to set
	 */
	public void setVisualcheckofudrainsforstock2_10am(String visualcheckofudrainsforstock2_10am) {
		this.visualcheckofudrainsforstock2_10am = visualcheckofudrainsforstock2_10am;
	}
	/**
	 * @return the visualcheckofudrainsforstock2_02pm
	 */
	public String getVisualcheckofudrainsforstock2_02pm() {
		return visualcheckofudrainsforstock2_02pm;
	}
	/**
	 * @param visualcheckofudrainsforstock2_02pm the visualcheckofudrainsforstock2_02pm to set
	 */
	public void setVisualcheckofudrainsforstock2_02pm(String visualcheckofudrainsforstock2_02pm) {
		this.visualcheckofudrainsforstock2_02pm = visualcheckofudrainsforstock2_02pm;
	}
	/**
	 * @return the visualcheckofudrainsforstock2_06pm
	 */
	public String getVisualcheckofudrainsforstock2_06pm() {
		return visualcheckofudrainsforstock2_06pm;
	}
	/**
	 * @param visualcheckofudrainsforstock2_06pm the visualcheckofudrainsforstock2_06pm to set
	 */
	public void setVisualcheckofudrainsforstock2_06pm(String visualcheckofudrainsforstock2_06pm) {
		this.visualcheckofudrainsforstock2_06pm = visualcheckofudrainsforstock2_06pm;
	}
	/**
	 * @return the visualcheckofudrainsforstock2_10pm
	 */
	public String getVisualcheckofudrainsforstock2_10pm() {
		return visualcheckofudrainsforstock2_10pm;
	}
	/**
	 * @param visualcheckofudrainsforstock2_10pm the visualcheckofudrainsforstock2_10pm to set
	 */
	public void setVisualcheckofudrainsforstock2_10pm(String visualcheckofudrainsforstock2_10pm) {
		this.visualcheckofudrainsforstock2_10pm = visualcheckofudrainsforstock2_10pm;
	}
	/**
	 * @return the visualcheckofudrainsforstock2_02am
	 */
	public String getVisualcheckofudrainsforstock2_02am() {
		return visualcheckofudrainsforstock2_02am;
	}
	/**
	 * @param visualcheckofudrainsforstock2_02am the visualcheckofudrainsforstock2_02am to set
	 */
	public void setVisualcheckofudrainsforstock2_02am(String visualcheckofudrainsforstock2_02am) {
		this.visualcheckofudrainsforstock2_02am = visualcheckofudrainsforstock2_02am;
	}
	/**
	 * @return the visualcheckofudrainsforstock2_06am
	 */
	public String getVisualcheckofudrainsforstock2_06am() {
		return visualcheckofudrainsforstock2_06am;
	}
	/**
	 * @param visualcheckofudrainsforstock2_06am the visualcheckofudrainsforstock2_06am to set
	 */
	public void setVisualcheckofudrainsforstock2_06am(String visualcheckofudrainsforstock2_06am) {
		this.visualcheckofudrainsforstock2_06am = visualcheckofudrainsforstock2_06am;
	}
	/**
	 * @return the visualcheckofudrainsforstock3_freq
	 */
	public String getVisualcheckofudrainsforstock3_freq() {
		return visualcheckofudrainsforstock3_freq;
	}
	/**
	 * @param visualcheckofudrainsforstock3_freq the visualcheckofudrainsforstock3_freq to set
	 */
	public void setVisualcheckofudrainsforstock3_freq(String visualcheckofudrainsforstock3_freq) {
		this.visualcheckofudrainsforstock3_freq = visualcheckofudrainsforstock3_freq;
	}
	/**
	 * @return the visualcheckofudrainsforstock3_10am
	 */
	public String getVisualcheckofudrainsforstock3_10am() {
		return visualcheckofudrainsforstock3_10am;
	}
	/**
	 * @param visualcheckofudrainsforstock3_10am the visualcheckofudrainsforstock3_10am to set
	 */
	public void setVisualcheckofudrainsforstock3_10am(String visualcheckofudrainsforstock3_10am) {
		this.visualcheckofudrainsforstock3_10am = visualcheckofudrainsforstock3_10am;
	}
	/**
	 * @return the visualcheckofudrainsforstock3_02pm
	 */
	public String getVisualcheckofudrainsforstock3_02pm() {
		return visualcheckofudrainsforstock3_02pm;
	}
	/**
	 * @param visualcheckofudrainsforstock3_02pm the visualcheckofudrainsforstock3_02pm to set
	 */
	public void setVisualcheckofudrainsforstock3_02pm(String visualcheckofudrainsforstock3_02pm) {
		this.visualcheckofudrainsforstock3_02pm = visualcheckofudrainsforstock3_02pm;
	}
	/**
	 * @return the visualcheckofudrainsforstock3_06pm
	 */
	public String getVisualcheckofudrainsforstock3_06pm() {
		return visualcheckofudrainsforstock3_06pm;
	}
	/**
	 * @param visualcheckofudrainsforstock3_06pm the visualcheckofudrainsforstock3_06pm to set
	 */
	public void setVisualcheckofudrainsforstock3_06pm(String visualcheckofudrainsforstock3_06pm) {
		this.visualcheckofudrainsforstock3_06pm = visualcheckofudrainsforstock3_06pm;
	}
	/**
	 * @return the visualcheckofudrainsforstock3_10pm
	 */
	public String getVisualcheckofudrainsforstock3_10pm() {
		return visualcheckofudrainsforstock3_10pm;
	}
	/**
	 * @param visualcheckofudrainsforstock3_10pm the visualcheckofudrainsforstock3_10pm to set
	 */
	public void setVisualcheckofudrainsforstock3_10pm(String visualcheckofudrainsforstock3_10pm) {
		this.visualcheckofudrainsforstock3_10pm = visualcheckofudrainsforstock3_10pm;
	}
	/**
	 * @return the visualcheckofudrainsforstock3_02am
	 */
	public String getVisualcheckofudrainsforstock3_02am() {
		return visualcheckofudrainsforstock3_02am;
	}
	/**
	 * @param visualcheckofudrainsforstock3_02am the visualcheckofudrainsforstock3_02am to set
	 */
	public void setVisualcheckofudrainsforstock3_02am(String visualcheckofudrainsforstock3_02am) {
		this.visualcheckofudrainsforstock3_02am = visualcheckofudrainsforstock3_02am;
	}
	/**
	 * @return the visualcheckofudrainsforstock3_06am
	 */
	public String getVisualcheckofudrainsforstock3_06am() {
		return visualcheckofudrainsforstock3_06am;
	}
	/**
	 * @param visualcheckofudrainsforstock3_06am the visualcheckofudrainsforstock3_06am to set
	 */
	public void setVisualcheckofudrainsforstock3_06am(String visualcheckofudrainsforstock3_06am) {
		this.visualcheckofudrainsforstock3_06am = visualcheckofudrainsforstock3_06am;
	}
	/**
	 * @return the visualcheckofudrainsforstock4_freq
	 */
	public String getVisualcheckofudrainsforstock4_freq() {
		return visualcheckofudrainsforstock4_freq;
	}
	/**
	 * @param visualcheckofudrainsforstock4_freq the visualcheckofudrainsforstock4_freq to set
	 */
	public void setVisualcheckofudrainsforstock4_freq(String visualcheckofudrainsforstock4_freq) {
		this.visualcheckofudrainsforstock4_freq = visualcheckofudrainsforstock4_freq;
	}
	/**
	 * @return the visualcheckofudrainsforstock4_10am
	 */
	public String getVisualcheckofudrainsforstock4_10am() {
		return visualcheckofudrainsforstock4_10am;
	}
	/**
	 * @param visualcheckofudrainsforstock4_10am the visualcheckofudrainsforstock4_10am to set
	 */
	public void setVisualcheckofudrainsforstock4_10am(String visualcheckofudrainsforstock4_10am) {
		this.visualcheckofudrainsforstock4_10am = visualcheckofudrainsforstock4_10am;
	}
	/**
	 * @return the visualcheckofudrainsforstock4_02pm
	 */
	public String getVisualcheckofudrainsforstock4_02pm() {
		return visualcheckofudrainsforstock4_02pm;
	}
	/**
	 * @param visualcheckofudrainsforstock4_02pm the visualcheckofudrainsforstock4_02pm to set
	 */
	public void setVisualcheckofudrainsforstock4_02pm(String visualcheckofudrainsforstock4_02pm) {
		this.visualcheckofudrainsforstock4_02pm = visualcheckofudrainsforstock4_02pm;
	}
	/**
	 * @return the visualcheckofudrainsforstock4_06pm
	 */
	public String getVisualcheckofudrainsforstock4_06pm() {
		return visualcheckofudrainsforstock4_06pm;
	}
	/**
	 * @param visualcheckofudrainsforstock4_06pm the visualcheckofudrainsforstock4_06pm to set
	 */
	public void setVisualcheckofudrainsforstock4_06pm(String visualcheckofudrainsforstock4_06pm) {
		this.visualcheckofudrainsforstock4_06pm = visualcheckofudrainsforstock4_06pm;
	}
	/**
	 * @return the visualcheckofudrainsforstock4_10pm
	 */
	public String getVisualcheckofudrainsforstock4_10pm() {
		return visualcheckofudrainsforstock4_10pm;
	}
	/**
	 * @param visualcheckofudrainsforstock4_10pm the visualcheckofudrainsforstock4_10pm to set
	 */
	public void setVisualcheckofudrainsforstock4_10pm(String visualcheckofudrainsforstock4_10pm) {
		this.visualcheckofudrainsforstock4_10pm = visualcheckofudrainsforstock4_10pm;
	}
	/**
	 * @return the visualcheckofudrainsforstock4_02am
	 */
	public String getVisualcheckofudrainsforstock4_02am() {
		return visualcheckofudrainsforstock4_02am;
	}
	/**
	 * @param visualcheckofudrainsforstock4_02am the visualcheckofudrainsforstock4_02am to set
	 */
	public void setVisualcheckofudrainsforstock4_02am(String visualcheckofudrainsforstock4_02am) {
		this.visualcheckofudrainsforstock4_02am = visualcheckofudrainsforstock4_02am;
	}
	/**
	 * @return the visualcheckofudrainsforstock4_06am
	 */
	public String getVisualcheckofudrainsforstock4_06am() {
		return visualcheckofudrainsforstock4_06am;
	}
	/**
	 * @param visualcheckofudrainsforstock4_06am the visualcheckofudrainsforstock4_06am to set
	 */
	public void setVisualcheckofudrainsforstock4_06am(String visualcheckofudrainsforstock4_06am) {
		this.visualcheckofudrainsforstock4_06am = visualcheckofudrainsforstock4_06am;
	}
	/**
	 * @return the visualcheckofudrainsforstock5_freq
	 */
	public String getVisualcheckofudrainsforstock5_freq() {
		return visualcheckofudrainsforstock5_freq;
	}
	/**
	 * @param visualcheckofudrainsforstock5_freq the visualcheckofudrainsforstock5_freq to set
	 */
	public void setVisualcheckofudrainsforstock5_freq(String visualcheckofudrainsforstock5_freq) {
		this.visualcheckofudrainsforstock5_freq = visualcheckofudrainsforstock5_freq;
	}
	/**
	 * @return the visualcheckofudrainsforstock5_10am
	 */
	public String getVisualcheckofudrainsforstock5_10am() {
		return visualcheckofudrainsforstock5_10am;
	}
	/**
	 * @param visualcheckofudrainsforstock5_10am the visualcheckofudrainsforstock5_10am to set
	 */
	public void setVisualcheckofudrainsforstock5_10am(String visualcheckofudrainsforstock5_10am) {
		this.visualcheckofudrainsforstock5_10am = visualcheckofudrainsforstock5_10am;
	}
	/**
	 * @return the visualcheckofudrainsforstock5_02pm
	 */
	public String getVisualcheckofudrainsforstock5_02pm() {
		return visualcheckofudrainsforstock5_02pm;
	}
	/**
	 * @param visualcheckofudrainsforstock5_02pm the visualcheckofudrainsforstock5_02pm to set
	 */
	public void setVisualcheckofudrainsforstock5_02pm(String visualcheckofudrainsforstock5_02pm) {
		this.visualcheckofudrainsforstock5_02pm = visualcheckofudrainsforstock5_02pm;
	}
	/**
	 * @return the visualcheckofudrainsforstock5_06pm
	 */
	public String getVisualcheckofudrainsforstock5_06pm() {
		return visualcheckofudrainsforstock5_06pm;
	}
	/**
	 * @param visualcheckofudrainsforstock5_06pm the visualcheckofudrainsforstock5_06pm to set
	 */
	public void setVisualcheckofudrainsforstock5_06pm(String visualcheckofudrainsforstock5_06pm) {
		this.visualcheckofudrainsforstock5_06pm = visualcheckofudrainsforstock5_06pm;
	}
	/**
	 * @return the visualcheckofudrainsforstock5_10pm
	 */
	public String getVisualcheckofudrainsforstock5_10pm() {
		return visualcheckofudrainsforstock5_10pm;
	}
	/**
	 * @param visualcheckofudrainsforstock5_10pm the visualcheckofudrainsforstock5_10pm to set
	 */
	public void setVisualcheckofudrainsforstock5_10pm(String visualcheckofudrainsforstock5_10pm) {
		this.visualcheckofudrainsforstock5_10pm = visualcheckofudrainsforstock5_10pm;
	}
	/**
	 * @return the visualcheckofudrainsforstock5_02am
	 */
	public String getVisualcheckofudrainsforstock5_02am() {
		return visualcheckofudrainsforstock5_02am;
	}
	/**
	 * @param visualcheckofudrainsforstock5_02am the visualcheckofudrainsforstock5_02am to set
	 */
	public void setVisualcheckofudrainsforstock5_02am(String visualcheckofudrainsforstock5_02am) {
		this.visualcheckofudrainsforstock5_02am = visualcheckofudrainsforstock5_02am;
	}
	/**
	 * @return the visualcheckofudrainsforstock5_06am
	 */
	public String getVisualcheckofudrainsforstock5_06am() {
		return visualcheckofudrainsforstock5_06am;
	}
	/**
	 * @param visualcheckofudrainsforstock5_06am the visualcheckofudrainsforstock5_06am to set
	 */
	public void setVisualcheckofudrainsforstock5_06am(String visualcheckofudrainsforstock5_06am) {
		this.visualcheckofudrainsforstock5_06am = visualcheckofudrainsforstock5_06am;
	}
	/**
	 * @return the visualcheckofudrainsforstock6_freq
	 */
	public String getVisualcheckofudrainsforstock6_freq() {
		return visualcheckofudrainsforstock6_freq;
	}
	/**
	 * @param visualcheckofudrainsforstock6_freq the visualcheckofudrainsforstock6_freq to set
	 */
	public void setVisualcheckofudrainsforstock6_freq(String visualcheckofudrainsforstock6_freq) {
		this.visualcheckofudrainsforstock6_freq = visualcheckofudrainsforstock6_freq;
	}
	/**
	 * @return the visualcheckofudrainsforstock6_10am
	 */
	public String getVisualcheckofudrainsforstock6_10am() {
		return visualcheckofudrainsforstock6_10am;
	}
	/**
	 * @param visualcheckofudrainsforstock6_10am the visualcheckofudrainsforstock6_10am to set
	 */
	public void setVisualcheckofudrainsforstock6_10am(String visualcheckofudrainsforstock6_10am) {
		this.visualcheckofudrainsforstock6_10am = visualcheckofudrainsforstock6_10am;
	}
	/**
	 * @return the visualcheckofudrainsforstock6_02pm
	 */
	public String getVisualcheckofudrainsforstock6_02pm() {
		return visualcheckofudrainsforstock6_02pm;
	}
	/**
	 * @param visualcheckofudrainsforstock6_02pm the visualcheckofudrainsforstock6_02pm to set
	 */
	public void setVisualcheckofudrainsforstock6_02pm(String visualcheckofudrainsforstock6_02pm) {
		this.visualcheckofudrainsforstock6_02pm = visualcheckofudrainsforstock6_02pm;
	}
	/**
	 * @return the visualcheckofudrainsforstock6_06pm
	 */
	public String getVisualcheckofudrainsforstock6_06pm() {
		return visualcheckofudrainsforstock6_06pm;
	}
	/**
	 * @param visualcheckofudrainsforstock6_06pm the visualcheckofudrainsforstock6_06pm to set
	 */
	public void setVisualcheckofudrainsforstock6_06pm(String visualcheckofudrainsforstock6_06pm) {
		this.visualcheckofudrainsforstock6_06pm = visualcheckofudrainsforstock6_06pm;
	}
	/**
	 * @return the visualcheckofudrainsforstock6_10pm
	 */
	public String getVisualcheckofudrainsforstock6_10pm() {
		return visualcheckofudrainsforstock6_10pm;
	}
	/**
	 * @param visualcheckofudrainsforstock6_10pm the visualcheckofudrainsforstock6_10pm to set
	 */
	public void setVisualcheckofudrainsforstock6_10pm(String visualcheckofudrainsforstock6_10pm) {
		this.visualcheckofudrainsforstock6_10pm = visualcheckofudrainsforstock6_10pm;
	}
	/**
	 * @return the visualcheckofudrainsforstock6_02am
	 */
	public String getVisualcheckofudrainsforstock6_02am() {
		return visualcheckofudrainsforstock6_02am;
	}
	/**
	 * @param visualcheckofudrainsforstock6_02am the visualcheckofudrainsforstock6_02am to set
	 */
	public void setVisualcheckofudrainsforstock6_02am(String visualcheckofudrainsforstock6_02am) {
		this.visualcheckofudrainsforstock6_02am = visualcheckofudrainsforstock6_02am;
	}
	/**
	 * @return the visualcheckofudrainsforstock6_06am
	 */
	public String getVisualcheckofudrainsforstock6_06am() {
		return visualcheckofudrainsforstock6_06am;
	}
	/**
	 * @param visualcheckofudrainsforstock6_06am the visualcheckofudrainsforstock6_06am to set
	 */
	public void setVisualcheckofudrainsforstock6_06am(String visualcheckofudrainsforstock6_06am) {
		this.visualcheckofudrainsforstock6_06am = visualcheckofudrainsforstock6_06am;
	}
	/**
	 * @return the visualcheckofudrainsforstock7_freq
	 */
	public String getVisualcheckofudrainsforstock7_freq() {
		return visualcheckofudrainsforstock7_freq;
	}
	/**
	 * @param visualcheckofudrainsforstock7_freq the visualcheckofudrainsforstock7_freq to set
	 */
	public void setVisualcheckofudrainsforstock7_freq(String visualcheckofudrainsforstock7_freq) {
		this.visualcheckofudrainsforstock7_freq = visualcheckofudrainsforstock7_freq;
	}
	/**
	 * @return the visualcheckofudrainsforstock7_10am
	 */
	public String getVisualcheckofudrainsforstock7_10am() {
		return visualcheckofudrainsforstock7_10am;
	}
	/**
	 * @param visualcheckofudrainsforstock7_10am the visualcheckofudrainsforstock7_10am to set
	 */
	public void setVisualcheckofudrainsforstock7_10am(String visualcheckofudrainsforstock7_10am) {
		this.visualcheckofudrainsforstock7_10am = visualcheckofudrainsforstock7_10am;
	}
	/**
	 * @return the visualcheckofudrainsforstock7_02pm
	 */
	public String getVisualcheckofudrainsforstock7_02pm() {
		return visualcheckofudrainsforstock7_02pm;
	}
	/**
	 * @param visualcheckofudrainsforstock7_02pm the visualcheckofudrainsforstock7_02pm to set
	 */
	public void setVisualcheckofudrainsforstock7_02pm(String visualcheckofudrainsforstock7_02pm) {
		this.visualcheckofudrainsforstock7_02pm = visualcheckofudrainsforstock7_02pm;
	}
	/**
	 * @return the visualcheckofudrainsforstock7_06pm
	 */
	public String getVisualcheckofudrainsforstock7_06pm() {
		return visualcheckofudrainsforstock7_06pm;
	}
	/**
	 * @param visualcheckofudrainsforstock7_06pm the visualcheckofudrainsforstock7_06pm to set
	 */
	public void setVisualcheckofudrainsforstock7_06pm(String visualcheckofudrainsforstock7_06pm) {
		this.visualcheckofudrainsforstock7_06pm = visualcheckofudrainsforstock7_06pm;
	}
	/**
	 * @return the visualcheckofudrainsforstock7_10pm
	 */
	public String getVisualcheckofudrainsforstock7_10pm() {
		return visualcheckofudrainsforstock7_10pm;
	}
	/**
	 * @param visualcheckofudrainsforstock7_10pm the visualcheckofudrainsforstock7_10pm to set
	 */
	public void setVisualcheckofudrainsforstock7_10pm(String visualcheckofudrainsforstock7_10pm) {
		this.visualcheckofudrainsforstock7_10pm = visualcheckofudrainsforstock7_10pm;
	}
	/**
	 * @return the visualcheckofudrainsforstock7_02am
	 */
	public String getVisualcheckofudrainsforstock7_02am() {
		return visualcheckofudrainsforstock7_02am;
	}
	/**
	 * @param visualcheckofudrainsforstock7_02am the visualcheckofudrainsforstock7_02am to set
	 */
	public void setVisualcheckofudrainsforstock7_02am(String visualcheckofudrainsforstock7_02am) {
		this.visualcheckofudrainsforstock7_02am = visualcheckofudrainsforstock7_02am;
	}
	/**
	 * @return the visualcheckofudrainsforstock7_06am
	 */
	public String getVisualcheckofudrainsforstock7_06am() {
		return visualcheckofudrainsforstock7_06am;
	}
	/**
	 * @param visualcheckofudrainsforstock7_06am the visualcheckofudrainsforstock7_06am to set
	 */
	public void setVisualcheckofudrainsforstock7_06am(String visualcheckofudrainsforstock7_06am) {
		this.visualcheckofudrainsforstock7_06am = visualcheckofudrainsforstock7_06am;
	}
	/**
	 * @return the visualcheckofudrainsforstock8_freq
	 */
	public String getVisualcheckofudrainsforstock8_freq() {
		return visualcheckofudrainsforstock8_freq;
	}
	/**
	 * @param visualcheckofudrainsforstock8_freq the visualcheckofudrainsforstock8_freq to set
	 */
	public void setVisualcheckofudrainsforstock8_freq(String visualcheckofudrainsforstock8_freq) {
		this.visualcheckofudrainsforstock8_freq = visualcheckofudrainsforstock8_freq;
	}
	/**
	 * @return the visualcheckofudrainsforstock8_10am
	 */
	public String getVisualcheckofudrainsforstock8_10am() {
		return visualcheckofudrainsforstock8_10am;
	}
	/**
	 * @param visualcheckofudrainsforstock8_10am the visualcheckofudrainsforstock8_10am to set
	 */
	public void setVisualcheckofudrainsforstock8_10am(String visualcheckofudrainsforstock8_10am) {
		this.visualcheckofudrainsforstock8_10am = visualcheckofudrainsforstock8_10am;
	}
	/**
	 * @return the visualcheckofudrainsforstock8_02pm
	 */
	public String getVisualcheckofudrainsforstock8_02pm() {
		return visualcheckofudrainsforstock8_02pm;
	}
	/**
	 * @param visualcheckofudrainsforstock8_02pm the visualcheckofudrainsforstock8_02pm to set
	 */
	public void setVisualcheckofudrainsforstock8_02pm(String visualcheckofudrainsforstock8_02pm) {
		this.visualcheckofudrainsforstock8_02pm = visualcheckofudrainsforstock8_02pm;
	}
	/**
	 * @return the visualcheckofudrainsforstock8_06pm
	 */
	public String getVisualcheckofudrainsforstock8_06pm() {
		return visualcheckofudrainsforstock8_06pm;
	}
	/**
	 * @param visualcheckofudrainsforstock8_06pm the visualcheckofudrainsforstock8_06pm to set
	 */
	public void setVisualcheckofudrainsforstock8_06pm(String visualcheckofudrainsforstock8_06pm) {
		this.visualcheckofudrainsforstock8_06pm = visualcheckofudrainsforstock8_06pm;
	}
	/**
	 * @return the visualcheckofudrainsforstock8_10pm
	 */
	public String getVisualcheckofudrainsforstock8_10pm() {
		return visualcheckofudrainsforstock8_10pm;
	}
	/**
	 * @param visualcheckofudrainsforstock8_10pm the visualcheckofudrainsforstock8_10pm to set
	 */
	public void setVisualcheckofudrainsforstock8_10pm(String visualcheckofudrainsforstock8_10pm) {
		this.visualcheckofudrainsforstock8_10pm = visualcheckofudrainsforstock8_10pm;
	}
	/**
	 * @return the visualcheckofudrainsforstock8_02am
	 */
	public String getVisualcheckofudrainsforstock8_02am() {
		return visualcheckofudrainsforstock8_02am;
	}
	/**
	 * @param visualcheckofudrainsforstock8_02am the visualcheckofudrainsforstock8_02am to set
	 */
	public void setVisualcheckofudrainsforstock8_02am(String visualcheckofudrainsforstock8_02am) {
		this.visualcheckofudrainsforstock8_02am = visualcheckofudrainsforstock8_02am;
	}
	/**
	 * @return the visualcheckofudrainsforstock8_06am
	 */
	public String getVisualcheckofudrainsforstock8_06am() {
		return visualcheckofudrainsforstock8_06am;
	}
	/**
	 * @param visualcheckofudrainsforstock8_06am the visualcheckofudrainsforstock8_06am to set
	 */
	public void setVisualcheckofudrainsforstock8_06am(String visualcheckofudrainsforstock8_06am) {
		this.visualcheckofudrainsforstock8_06am = visualcheckofudrainsforstock8_06am;
	}
	/**
	 * @return the visualcheckofudrainsforstock9_freq
	 */
	public String getVisualcheckofudrainsforstock9_freq() {
		return visualcheckofudrainsforstock9_freq;
	}
	/**
	 * @param visualcheckofudrainsforstock9_freq the visualcheckofudrainsforstock9_freq to set
	 */
	public void setVisualcheckofudrainsforstock9_freq(String visualcheckofudrainsforstock9_freq) {
		this.visualcheckofudrainsforstock9_freq = visualcheckofudrainsforstock9_freq;
	}
	/**
	 * @return the visualcheckofudrainsforstock9_10am
	 */
	public String getVisualcheckofudrainsforstock9_10am() {
		return visualcheckofudrainsforstock9_10am;
	}
	/**
	 * @param visualcheckofudrainsforstock9_10am the visualcheckofudrainsforstock9_10am to set
	 */
	public void setVisualcheckofudrainsforstock9_10am(String visualcheckofudrainsforstock9_10am) {
		this.visualcheckofudrainsforstock9_10am = visualcheckofudrainsforstock9_10am;
	}
	/**
	 * @return the visualcheckofudrainsforstock9_02pm
	 */
	public String getVisualcheckofudrainsforstock9_02pm() {
		return visualcheckofudrainsforstock9_02pm;
	}
	/**
	 * @param visualcheckofudrainsforstock9_02pm the visualcheckofudrainsforstock9_02pm to set
	 */
	public void setVisualcheckofudrainsforstock9_02pm(String visualcheckofudrainsforstock9_02pm) {
		this.visualcheckofudrainsforstock9_02pm = visualcheckofudrainsforstock9_02pm;
	}
	/**
	 * @return the visualcheckofudrainsforstock9_06pm
	 */
	public String getVisualcheckofudrainsforstock9_06pm() {
		return visualcheckofudrainsforstock9_06pm;
	}
	/**
	 * @param visualcheckofudrainsforstock9_06pm the visualcheckofudrainsforstock9_06pm to set
	 */
	public void setVisualcheckofudrainsforstock9_06pm(String visualcheckofudrainsforstock9_06pm) {
		this.visualcheckofudrainsforstock9_06pm = visualcheckofudrainsforstock9_06pm;
	}
	/**
	 * @return the visualcheckofudrainsforstock9_10pm
	 */
	public String getVisualcheckofudrainsforstock9_10pm() {
		return visualcheckofudrainsforstock9_10pm;
	}
	/**
	 * @param visualcheckofudrainsforstock9_10pm the visualcheckofudrainsforstock9_10pm to set
	 */
	public void setVisualcheckofudrainsforstock9_10pm(String visualcheckofudrainsforstock9_10pm) {
		this.visualcheckofudrainsforstock9_10pm = visualcheckofudrainsforstock9_10pm;
	}
	/**
	 * @return the visualcheckofudrainsforstock9_02am
	 */
	public String getVisualcheckofudrainsforstock9_02am() {
		return visualcheckofudrainsforstock9_02am;
	}
	/**
	 * @param visualcheckofudrainsforstock9_02am the visualcheckofudrainsforstock9_02am to set
	 */
	public void setVisualcheckofudrainsforstock9_02am(String visualcheckofudrainsforstock9_02am) {
		this.visualcheckofudrainsforstock9_02am = visualcheckofudrainsforstock9_02am;
	}
	/**
	 * @return the visualcheckofudrainsforstock9_06am
	 */
	public String getVisualcheckofudrainsforstock9_06am() {
		return visualcheckofudrainsforstock9_06am;
	}
	/**
	 * @param visualcheckofudrainsforstock9_06am the visualcheckofudrainsforstock9_06am to set
	 */
	public void setVisualcheckofudrainsforstock9_06am(String visualcheckofudrainsforstock9_06am) {
		this.visualcheckofudrainsforstock9_06am = visualcheckofudrainsforstock9_06am;
	}
	/**
	 * @return the visualcheckofudrainsforstock10_freq
	 */
	public String getVisualcheckofudrainsforstock10_freq() {
		return visualcheckofudrainsforstock10_freq;
	}
	/**
	 * @param visualcheckofudrainsforstock10_freq the visualcheckofudrainsforstock10_freq to set
	 */
	public void setVisualcheckofudrainsforstock10_freq(String visualcheckofudrainsforstock10_freq) {
		this.visualcheckofudrainsforstock10_freq = visualcheckofudrainsforstock10_freq;
	}
	/**
	 * @return the visualcheckofudrainsforstock10_10am
	 */
	public String getVisualcheckofudrainsforstock10_10am() {
		return visualcheckofudrainsforstock10_10am;
	}
	/**
	 * @param visualcheckofudrainsforstock10_10am the visualcheckofudrainsforstock10_10am to set
	 */
	public void setVisualcheckofudrainsforstock10_10am(String visualcheckofudrainsforstock10_10am) {
		this.visualcheckofudrainsforstock10_10am = visualcheckofudrainsforstock10_10am;
	}
	/**
	 * @return the visualcheckofudrainsforstock10_02pm
	 */
	public String getVisualcheckofudrainsforstock10_02pm() {
		return visualcheckofudrainsforstock10_02pm;
	}
	/**
	 * @param visualcheckofudrainsforstock10_02pm the visualcheckofudrainsforstock10_02pm to set
	 */
	public void setVisualcheckofudrainsforstock10_02pm(String visualcheckofudrainsforstock10_02pm) {
		this.visualcheckofudrainsforstock10_02pm = visualcheckofudrainsforstock10_02pm;
	}
	/**
	 * @return the visualcheckofudrainsforstock10_06pm
	 */
	public String getVisualcheckofudrainsforstock10_06pm() {
		return visualcheckofudrainsforstock10_06pm;
	}
	/**
	 * @param visualcheckofudrainsforstock10_06pm the visualcheckofudrainsforstock10_06pm to set
	 */
	public void setVisualcheckofudrainsforstock10_06pm(String visualcheckofudrainsforstock10_06pm) {
		this.visualcheckofudrainsforstock10_06pm = visualcheckofudrainsforstock10_06pm;
	}
	/**
	 * @return the visualcheckofudrainsforstock10_10pm
	 */
	public String getVisualcheckofudrainsforstock10_10pm() {
		return visualcheckofudrainsforstock10_10pm;
	}
	/**
	 * @param visualcheckofudrainsforstock10_10pm the visualcheckofudrainsforstock10_10pm to set
	 */
	public void setVisualcheckofudrainsforstock10_10pm(String visualcheckofudrainsforstock10_10pm) {
		this.visualcheckofudrainsforstock10_10pm = visualcheckofudrainsforstock10_10pm;
	}
	/**
	 * @return the visualcheckofudrainsforstock10_02am
	 */
	public String getVisualcheckofudrainsforstock10_02am() {
		return visualcheckofudrainsforstock10_02am;
	}
	/**
	 * @param visualcheckofudrainsforstock10_02am the visualcheckofudrainsforstock10_02am to set
	 */
	public void setVisualcheckofudrainsforstock10_02am(String visualcheckofudrainsforstock10_02am) {
		this.visualcheckofudrainsforstock10_02am = visualcheckofudrainsforstock10_02am;
	}
	/**
	 * @return the visualcheckofudrainsforstock10_06am
	 */
	public String getVisualcheckofudrainsforstock10_06am() {
		return visualcheckofudrainsforstock10_06am;
	}
	/**
	 * @param visualcheckofudrainsforstock10_06am the visualcheckofudrainsforstock10_06am to set
	 */
	public void setVisualcheckofudrainsforstock10_06am(String visualcheckofudrainsforstock10_06am) {
		this.visualcheckofudrainsforstock10_06am = visualcheckofudrainsforstock10_06am;
	}
	/**
	 * @return the visualcheckofudrainsforstock11_freq
	 */
	public String getVisualcheckofudrainsforstock11_freq() {
		return visualcheckofudrainsforstock11_freq;
	}
	/**
	 * @param visualcheckofudrainsforstock11_freq the visualcheckofudrainsforstock11_freq to set
	 */
	public void setVisualcheckofudrainsforstock11_freq(String visualcheckofudrainsforstock11_freq) {
		this.visualcheckofudrainsforstock11_freq = visualcheckofudrainsforstock11_freq;
	}
	/**
	 * @return the visualcheckofudrainsforstock11_10am
	 */
	public String getVisualcheckofudrainsforstock11_10am() {
		return visualcheckofudrainsforstock11_10am;
	}
	/**
	 * @param visualcheckofudrainsforstock11_10am the visualcheckofudrainsforstock11_10am to set
	 */
	public void setVisualcheckofudrainsforstock11_10am(String visualcheckofudrainsforstock11_10am) {
		this.visualcheckofudrainsforstock11_10am = visualcheckofudrainsforstock11_10am;
	}
	/**
	 * @return the visualcheckofudrainsforstock11_02pm
	 */
	public String getVisualcheckofudrainsforstock11_02pm() {
		return visualcheckofudrainsforstock11_02pm;
	}
	/**
	 * @param visualcheckofudrainsforstock11_02pm the visualcheckofudrainsforstock11_02pm to set
	 */
	public void setVisualcheckofudrainsforstock11_02pm(String visualcheckofudrainsforstock11_02pm) {
		this.visualcheckofudrainsforstock11_02pm = visualcheckofudrainsforstock11_02pm;
	}
	/**
	 * @return the visualcheckofudrainsforstock11_06pm
	 */
	public String getVisualcheckofudrainsforstock11_06pm() {
		return visualcheckofudrainsforstock11_06pm;
	}
	/**
	 * @param visualcheckofudrainsforstock11_06pm the visualcheckofudrainsforstock11_06pm to set
	 */
	public void setVisualcheckofudrainsforstock11_06pm(String visualcheckofudrainsforstock11_06pm) {
		this.visualcheckofudrainsforstock11_06pm = visualcheckofudrainsforstock11_06pm;
	}
	/**
	 * @return the visualcheckofudrainsforstock11_10pm
	 */
	public String getVisualcheckofudrainsforstock11_10pm() {
		return visualcheckofudrainsforstock11_10pm;
	}
	/**
	 * @param visualcheckofudrainsforstock11_10pm the visualcheckofudrainsforstock11_10pm to set
	 */
	public void setVisualcheckofudrainsforstock11_10pm(String visualcheckofudrainsforstock11_10pm) {
		this.visualcheckofudrainsforstock11_10pm = visualcheckofudrainsforstock11_10pm;
	}
	/**
	 * @return the visualcheckofudrainsforstock11_02am
	 */
	public String getVisualcheckofudrainsforstock11_02am() {
		return visualcheckofudrainsforstock11_02am;
	}
	/**
	 * @param visualcheckofudrainsforstock11_02am the visualcheckofudrainsforstock11_02am to set
	 */
	public void setVisualcheckofudrainsforstock11_02am(String visualcheckofudrainsforstock11_02am) {
		this.visualcheckofudrainsforstock11_02am = visualcheckofudrainsforstock11_02am;
	}
	/**
	 * @return the visualcheckofudrainsforstock11_06am
	 */
	public String getVisualcheckofudrainsforstock11_06am() {
		return visualcheckofudrainsforstock11_06am;
	}
	/**
	 * @param visualcheckofudrainsforstock11_06am the visualcheckofudrainsforstock11_06am to set
	 */
	public void setVisualcheckofudrainsforstock11_06am(String visualcheckofudrainsforstock11_06am) {
		this.visualcheckofudrainsforstock11_06am = visualcheckofudrainsforstock11_06am;
	}
	/**
	 * @return the visualcheckofudrainsforstock12_freq
	 */
	public String getVisualcheckofudrainsforstock12_freq() {
		return visualcheckofudrainsforstock12_freq;
	}
	/**
	 * @param visualcheckofudrainsforstock12_freq the visualcheckofudrainsforstock12_freq to set
	 */
	public void setVisualcheckofudrainsforstock12_freq(String visualcheckofudrainsforstock12_freq) {
		this.visualcheckofudrainsforstock12_freq = visualcheckofudrainsforstock12_freq;
	}
	/**
	 * @return the visualcheckofudrainsforstock12_10am
	 */
	public String getVisualcheckofudrainsforstock12_10am() {
		return visualcheckofudrainsforstock12_10am;
	}
	/**
	 * @param visualcheckofudrainsforstock12_10am the visualcheckofudrainsforstock12_10am to set
	 */
	public void setVisualcheckofudrainsforstock12_10am(String visualcheckofudrainsforstock12_10am) {
		this.visualcheckofudrainsforstock12_10am = visualcheckofudrainsforstock12_10am;
	}
	/**
	 * @return the visualcheckofudrainsforstock12_02pm
	 */
	public String getVisualcheckofudrainsforstock12_02pm() {
		return visualcheckofudrainsforstock12_02pm;
	}
	/**
	 * @param visualcheckofudrainsforstock12_02pm the visualcheckofudrainsforstock12_02pm to set
	 */
	public void setVisualcheckofudrainsforstock12_02pm(String visualcheckofudrainsforstock12_02pm) {
		this.visualcheckofudrainsforstock12_02pm = visualcheckofudrainsforstock12_02pm;
	}
	/**
	 * @return the visualcheckofudrainsforstock12_06pm
	 */
	public String getVisualcheckofudrainsforstock12_06pm() {
		return visualcheckofudrainsforstock12_06pm;
	}
	/**
	 * @param visualcheckofudrainsforstock12_06pm the visualcheckofudrainsforstock12_06pm to set
	 */
	public void setVisualcheckofudrainsforstock12_06pm(String visualcheckofudrainsforstock12_06pm) {
		this.visualcheckofudrainsforstock12_06pm = visualcheckofudrainsforstock12_06pm;
	}
	/**
	 * @return the visualcheckofudrainsforstock12_10pm
	 */
	public String getVisualcheckofudrainsforstock12_10pm() {
		return visualcheckofudrainsforstock12_10pm;
	}
	/**
	 * @param visualcheckofudrainsforstock12_10pm the visualcheckofudrainsforstock12_10pm to set
	 */
	public void setVisualcheckofudrainsforstock12_10pm(String visualcheckofudrainsforstock12_10pm) {
		this.visualcheckofudrainsforstock12_10pm = visualcheckofudrainsforstock12_10pm;
	}
	/**
	 * @return the visualcheckofudrainsforstock12_02am
	 */
	public String getVisualcheckofudrainsforstock12_02am() {
		return visualcheckofudrainsforstock12_02am;
	}
	/**
	 * @param visualcheckofudrainsforstock12_02am the visualcheckofudrainsforstock12_02am to set
	 */
	public void setVisualcheckofudrainsforstock12_02am(String visualcheckofudrainsforstock12_02am) {
		this.visualcheckofudrainsforstock12_02am = visualcheckofudrainsforstock12_02am;
	}
	/**
	 * @return the visualcheckofudrainsforstock12_06am
	 */
	public String getVisualcheckofudrainsforstock12_06am() {
		return visualcheckofudrainsforstock12_06am;
	}
	/**
	 * @param visualcheckofudrainsforstock12_06am the visualcheckofudrainsforstock12_06am to set
	 */
	public void setVisualcheckofudrainsforstock12_06am(String visualcheckofudrainsforstock12_06am) {
		this.visualcheckofudrainsforstock12_06am = visualcheckofudrainsforstock12_06am;
	}
	/**
	 * @return the visualcheckofudrainsforstock13_freq
	 */
	public String getVisualcheckofudrainsforstock13_freq() {
		return visualcheckofudrainsforstock13_freq;
	}
	/**
	 * @param visualcheckofudrainsforstock13_freq the visualcheckofudrainsforstock13_freq to set
	 */
	public void setVisualcheckofudrainsforstock13_freq(String visualcheckofudrainsforstock13_freq) {
		this.visualcheckofudrainsforstock13_freq = visualcheckofudrainsforstock13_freq;
	}
	/**
	 * @return the visualcheckofudrainsforstock13_10am
	 */
	public String getVisualcheckofudrainsforstock13_10am() {
		return visualcheckofudrainsforstock13_10am;
	}
	/**
	 * @param visualcheckofudrainsforstock13_10am the visualcheckofudrainsforstock13_10am to set
	 */
	public void setVisualcheckofudrainsforstock13_10am(String visualcheckofudrainsforstock13_10am) {
		this.visualcheckofudrainsforstock13_10am = visualcheckofudrainsforstock13_10am;
	}
	/**
	 * @return the visualcheckofudrainsforstock13_02pm
	 */
	public String getVisualcheckofudrainsforstock13_02pm() {
		return visualcheckofudrainsforstock13_02pm;
	}
	/**
	 * @param visualcheckofudrainsforstock13_02pm the visualcheckofudrainsforstock13_02pm to set
	 */
	public void setVisualcheckofudrainsforstock13_02pm(String visualcheckofudrainsforstock13_02pm) {
		this.visualcheckofudrainsforstock13_02pm = visualcheckofudrainsforstock13_02pm;
	}
	/**
	 * @return the visualcheckofudrainsforstock13_06pm
	 */
	public String getVisualcheckofudrainsforstock13_06pm() {
		return visualcheckofudrainsforstock13_06pm;
	}
	/**
	 * @param visualcheckofudrainsforstock13_06pm the visualcheckofudrainsforstock13_06pm to set
	 */
	public void setVisualcheckofudrainsforstock13_06pm(String visualcheckofudrainsforstock13_06pm) {
		this.visualcheckofudrainsforstock13_06pm = visualcheckofudrainsforstock13_06pm;
	}
	/**
	 * @return the visualcheckofudrainsforstock13_10pm
	 */
	public String getVisualcheckofudrainsforstock13_10pm() {
		return visualcheckofudrainsforstock13_10pm;
	}
	/**
	 * @param visualcheckofudrainsforstock13_10pm the visualcheckofudrainsforstock13_10pm to set
	 */
	public void setVisualcheckofudrainsforstock13_10pm(String visualcheckofudrainsforstock13_10pm) {
		this.visualcheckofudrainsforstock13_10pm = visualcheckofudrainsforstock13_10pm;
	}
	/**
	 * @return the visualcheckofudrainsforstock13_02am
	 */
	public String getVisualcheckofudrainsforstock13_02am() {
		return visualcheckofudrainsforstock13_02am;
	}
	/**
	 * @param visualcheckofudrainsforstock13_02am the visualcheckofudrainsforstock13_02am to set
	 */
	public void setVisualcheckofudrainsforstock13_02am(String visualcheckofudrainsforstock13_02am) {
		this.visualcheckofudrainsforstock13_02am = visualcheckofudrainsforstock13_02am;
	}
	/**
	 * @return the visualcheckofudrainsforstock13_06am
	 */
	public String getVisualcheckofudrainsforstock13_06am() {
		return visualcheckofudrainsforstock13_06am;
	}
	/**
	 * @param visualcheckofudrainsforstock13_06am the visualcheckofudrainsforstock13_06am to set
	 */
	public void setVisualcheckofudrainsforstock13_06am(String visualcheckofudrainsforstock13_06am) {
		this.visualcheckofudrainsforstock13_06am = visualcheckofudrainsforstock13_06am;
	}
	/**
	 * @return the visualcheckofudrainsforstock14_freq
	 */
	public String getVisualcheckofudrainsforstock14_freq() {
		return visualcheckofudrainsforstock14_freq;
	}
	/**
	 * @param visualcheckofudrainsforstock14_freq the visualcheckofudrainsforstock14_freq to set
	 */
	public void setVisualcheckofudrainsforstock14_freq(String visualcheckofudrainsforstock14_freq) {
		this.visualcheckofudrainsforstock14_freq = visualcheckofudrainsforstock14_freq;
	}
	/**
	 * @return the visualcheckofudrainsforstock14_10am
	 */
	public String getVisualcheckofudrainsforstock14_10am() {
		return visualcheckofudrainsforstock14_10am;
	}
	/**
	 * @param visualcheckofudrainsforstock14_10am the visualcheckofudrainsforstock14_10am to set
	 */
	public void setVisualcheckofudrainsforstock14_10am(String visualcheckofudrainsforstock14_10am) {
		this.visualcheckofudrainsforstock14_10am = visualcheckofudrainsforstock14_10am;
	}
	/**
	 * @return the visualcheckofudrainsforstock14_02pm
	 */
	public String getVisualcheckofudrainsforstock14_02pm() {
		return visualcheckofudrainsforstock14_02pm;
	}
	/**
	 * @param visualcheckofudrainsforstock14_02pm the visualcheckofudrainsforstock14_02pm to set
	 */
	public void setVisualcheckofudrainsforstock14_02pm(String visualcheckofudrainsforstock14_02pm) {
		this.visualcheckofudrainsforstock14_02pm = visualcheckofudrainsforstock14_02pm;
	}
	/**
	 * @return the visualcheckofudrainsforstock14_06pm
	 */
	public String getVisualcheckofudrainsforstock14_06pm() {
		return visualcheckofudrainsforstock14_06pm;
	}
	/**
	 * @param visualcheckofudrainsforstock14_06pm the visualcheckofudrainsforstock14_06pm to set
	 */
	public void setVisualcheckofudrainsforstock14_06pm(String visualcheckofudrainsforstock14_06pm) {
		this.visualcheckofudrainsforstock14_06pm = visualcheckofudrainsforstock14_06pm;
	}
	/**
	 * @return the visualcheckofudrainsforstock14_10pm
	 */
	public String getVisualcheckofudrainsforstock14_10pm() {
		return visualcheckofudrainsforstock14_10pm;
	}
	/**
	 * @param visualcheckofudrainsforstock14_10pm the visualcheckofudrainsforstock14_10pm to set
	 */
	public void setVisualcheckofudrainsforstock14_10pm(String visualcheckofudrainsforstock14_10pm) {
		this.visualcheckofudrainsforstock14_10pm = visualcheckofudrainsforstock14_10pm;
	}
	/**
	 * @return the visualcheckofudrainsforstock14_02am
	 */
	public String getVisualcheckofudrainsforstock14_02am() {
		return visualcheckofudrainsforstock14_02am;
	}
	/**
	 * @param visualcheckofudrainsforstock14_02am the visualcheckofudrainsforstock14_02am to set
	 */
	public void setVisualcheckofudrainsforstock14_02am(String visualcheckofudrainsforstock14_02am) {
		this.visualcheckofudrainsforstock14_02am = visualcheckofudrainsforstock14_02am;
	}
	/**
	 * @return the visualcheckofudrainsforstock14_06am
	 */
	public String getVisualcheckofudrainsforstock14_06am() {
		return visualcheckofudrainsforstock14_06am;
	}
	/**
	 * @param visualcheckofudrainsforstock14_06am the visualcheckofudrainsforstock14_06am to set
	 */
	public void setVisualcheckofudrainsforstock14_06am(String visualcheckofudrainsforstock14_06am) {
		this.visualcheckofudrainsforstock14_06am = visualcheckofudrainsforstock14_06am;
	}
	/**
	 * @return the visualcheckofudrainsforstock15_freq
	 */
	public String getVisualcheckofudrainsforstock15_freq() {
		return visualcheckofudrainsforstock15_freq;
	}
	/**
	 * @param visualcheckofudrainsforstock15_freq the visualcheckofudrainsforstock15_freq to set
	 */
	public void setVisualcheckofudrainsforstock15_freq(String visualcheckofudrainsforstock15_freq) {
		this.visualcheckofudrainsforstock15_freq = visualcheckofudrainsforstock15_freq;
	}
	/**
	 * @return the visualcheckofudrainsforstock15_10am
	 */
	public String getVisualcheckofudrainsforstock15_10am() {
		return visualcheckofudrainsforstock15_10am;
	}
	/**
	 * @param visualcheckofudrainsforstock15_10am the visualcheckofudrainsforstock15_10am to set
	 */
	public void setVisualcheckofudrainsforstock15_10am(String visualcheckofudrainsforstock15_10am) {
		this.visualcheckofudrainsforstock15_10am = visualcheckofudrainsforstock15_10am;
	}
	/**
	 * @return the visualcheckofudrainsforstock15_02pm
	 */
	public String getVisualcheckofudrainsforstock15_02pm() {
		return visualcheckofudrainsforstock15_02pm;
	}
	/**
	 * @param visualcheckofudrainsforstock15_02pm the visualcheckofudrainsforstock15_02pm to set
	 */
	public void setVisualcheckofudrainsforstock15_02pm(String visualcheckofudrainsforstock15_02pm) {
		this.visualcheckofudrainsforstock15_02pm = visualcheckofudrainsforstock15_02pm;
	}
	/**
	 * @return the visualcheckofudrainsforstock15_06pm
	 */
	public String getVisualcheckofudrainsforstock15_06pm() {
		return visualcheckofudrainsforstock15_06pm;
	}
	/**
	 * @param visualcheckofudrainsforstock15_06pm the visualcheckofudrainsforstock15_06pm to set
	 */
	public void setVisualcheckofudrainsforstock15_06pm(String visualcheckofudrainsforstock15_06pm) {
		this.visualcheckofudrainsforstock15_06pm = visualcheckofudrainsforstock15_06pm;
	}
	/**
	 * @return the visualcheckofudrainsforstock15_10pm
	 */
	public String getVisualcheckofudrainsforstock15_10pm() {
		return visualcheckofudrainsforstock15_10pm;
	}
	/**
	 * @param visualcheckofudrainsforstock15_10pm the visualcheckofudrainsforstock15_10pm to set
	 */
	public void setVisualcheckofudrainsforstock15_10pm(String visualcheckofudrainsforstock15_10pm) {
		this.visualcheckofudrainsforstock15_10pm = visualcheckofudrainsforstock15_10pm;
	}
	/**
	 * @return the visualcheckofudrainsforstock15_02am
	 */
	public String getVisualcheckofudrainsforstock15_02am() {
		return visualcheckofudrainsforstock15_02am;
	}
	/**
	 * @param visualcheckofudrainsforstock15_02am the visualcheckofudrainsforstock15_02am to set
	 */
	public void setVisualcheckofudrainsforstock15_02am(String visualcheckofudrainsforstock15_02am) {
		this.visualcheckofudrainsforstock15_02am = visualcheckofudrainsforstock15_02am;
	}
	/**
	 * @return the visualcheckofudrainsforstock15_06am
	 */
	public String getVisualcheckofudrainsforstock15_06am() {
		return visualcheckofudrainsforstock15_06am;
	}
	/**
	 * @param visualcheckofudrainsforstock15_06am the visualcheckofudrainsforstock15_06am to set
	 */
	public void setVisualcheckofudrainsforstock15_06am(String visualcheckofudrainsforstock15_06am) {
		this.visualcheckofudrainsforstock15_06am = visualcheckofudrainsforstock15_06am;
	}
	/**
	 * @return the visualcheckofudrainsforstock16_freq
	 */
	public String getVisualcheckofudrainsforstock16_freq() {
		return visualcheckofudrainsforstock16_freq;
	}
	/**
	 * @param visualcheckofudrainsforstock16_freq the visualcheckofudrainsforstock16_freq to set
	 */
	public void setVisualcheckofudrainsforstock16_freq(String visualcheckofudrainsforstock16_freq) {
		this.visualcheckofudrainsforstock16_freq = visualcheckofudrainsforstock16_freq;
	}
	/**
	 * @return the visualcheckofudrainsforstock16_10am
	 */
	public String getVisualcheckofudrainsforstock16_10am() {
		return visualcheckofudrainsforstock16_10am;
	}
	/**
	 * @param visualcheckofudrainsforstock16_10am the visualcheckofudrainsforstock16_10am to set
	 */
	public void setVisualcheckofudrainsforstock16_10am(String visualcheckofudrainsforstock16_10am) {
		this.visualcheckofudrainsforstock16_10am = visualcheckofudrainsforstock16_10am;
	}
	/**
	 * @return the visualcheckofudrainsforstock16_02pm
	 */
	public String getVisualcheckofudrainsforstock16_02pm() {
		return visualcheckofudrainsforstock16_02pm;
	}
	/**
	 * @param visualcheckofudrainsforstock16_02pm the visualcheckofudrainsforstock16_02pm to set
	 */
	public void setVisualcheckofudrainsforstock16_02pm(String visualcheckofudrainsforstock16_02pm) {
		this.visualcheckofudrainsforstock16_02pm = visualcheckofudrainsforstock16_02pm;
	}
	/**
	 * @return the visualcheckofudrainsforstock16_06pm
	 */
	public String getVisualcheckofudrainsforstock16_06pm() {
		return visualcheckofudrainsforstock16_06pm;
	}
	/**
	 * @param visualcheckofudrainsforstock16_06pm the visualcheckofudrainsforstock16_06pm to set
	 */
	public void setVisualcheckofudrainsforstock16_06pm(String visualcheckofudrainsforstock16_06pm) {
		this.visualcheckofudrainsforstock16_06pm = visualcheckofudrainsforstock16_06pm;
	}
	/**
	 * @return the visualcheckofudrainsforstock16_10pm
	 */
	public String getVisualcheckofudrainsforstock16_10pm() {
		return visualcheckofudrainsforstock16_10pm;
	}
	/**
	 * @param visualcheckofudrainsforstock16_10pm the visualcheckofudrainsforstock16_10pm to set
	 */
	public void setVisualcheckofudrainsforstock16_10pm(String visualcheckofudrainsforstock16_10pm) {
		this.visualcheckofudrainsforstock16_10pm = visualcheckofudrainsforstock16_10pm;
	}
	/**
	 * @return the visualcheckofudrainsforstock16_02am
	 */
	public String getVisualcheckofudrainsforstock16_02am() {
		return visualcheckofudrainsforstock16_02am;
	}
	/**
	 * @param visualcheckofudrainsforstock16_02am the visualcheckofudrainsforstock16_02am to set
	 */
	public void setVisualcheckofudrainsforstock16_02am(String visualcheckofudrainsforstock16_02am) {
		this.visualcheckofudrainsforstock16_02am = visualcheckofudrainsforstock16_02am;
	}
	/**
	 * @return the visualcheckofudrainsforstock16_06am
	 */
	public String getVisualcheckofudrainsforstock16_06am() {
		return visualcheckofudrainsforstock16_06am;
	}
	/**
	 * @param visualcheckofudrainsforstock16_06am the visualcheckofudrainsforstock16_06am to set
	 */
	public void setVisualcheckofudrainsforstock16_06am(String visualcheckofudrainsforstock16_06am) {
		this.visualcheckofudrainsforstock16_06am = visualcheckofudrainsforstock16_06am;
	}
	/**
	 * @return the visualcheckofudrainsforstock17_freq
	 */
	public String getVisualcheckofudrainsforstock17_freq() {
		return visualcheckofudrainsforstock17_freq;
	}
	/**
	 * @param visualcheckofudrainsforstock17_freq the visualcheckofudrainsforstock17_freq to set
	 */
	public void setVisualcheckofudrainsforstock17_freq(String visualcheckofudrainsforstock17_freq) {
		this.visualcheckofudrainsforstock17_freq = visualcheckofudrainsforstock17_freq;
	}
	/**
	 * @return the visualcheckofudrainsforstock17_10am
	 */
	public String getVisualcheckofudrainsforstock17_10am() {
		return visualcheckofudrainsforstock17_10am;
	}
	/**
	 * @param visualcheckofudrainsforstock17_10am the visualcheckofudrainsforstock17_10am to set
	 */
	public void setVisualcheckofudrainsforstock17_10am(String visualcheckofudrainsforstock17_10am) {
		this.visualcheckofudrainsforstock17_10am = visualcheckofudrainsforstock17_10am;
	}
	/**
	 * @return the visualcheckofudrainsforstock17_02pm
	 */
	public String getVisualcheckofudrainsforstock17_02pm() {
		return visualcheckofudrainsforstock17_02pm;
	}
	/**
	 * @param visualcheckofudrainsforstock17_02pm the visualcheckofudrainsforstock17_02pm to set
	 */
	public void setVisualcheckofudrainsforstock17_02pm(String visualcheckofudrainsforstock17_02pm) {
		this.visualcheckofudrainsforstock17_02pm = visualcheckofudrainsforstock17_02pm;
	}
	/**
	 * @return the visualcheckofudrainsforstock17_06pm
	 */
	public String getVisualcheckofudrainsforstock17_06pm() {
		return visualcheckofudrainsforstock17_06pm;
	}
	/**
	 * @param visualcheckofudrainsforstock17_06pm the visualcheckofudrainsforstock17_06pm to set
	 */
	public void setVisualcheckofudrainsforstock17_06pm(String visualcheckofudrainsforstock17_06pm) {
		this.visualcheckofudrainsforstock17_06pm = visualcheckofudrainsforstock17_06pm;
	}
	/**
	 * @return the visualcheckofudrainsforstock17_10pm
	 */
	public String getVisualcheckofudrainsforstock17_10pm() {
		return visualcheckofudrainsforstock17_10pm;
	}
	/**
	 * @param visualcheckofudrainsforstock17_10pm the visualcheckofudrainsforstock17_10pm to set
	 */
	public void setVisualcheckofudrainsforstock17_10pm(String visualcheckofudrainsforstock17_10pm) {
		this.visualcheckofudrainsforstock17_10pm = visualcheckofudrainsforstock17_10pm;
	}
	/**
	 * @return the visualcheckofudrainsforstock17_02am
	 */
	public String getVisualcheckofudrainsforstock17_02am() {
		return visualcheckofudrainsforstock17_02am;
	}
	/**
	 * @param visualcheckofudrainsforstock17_02am the visualcheckofudrainsforstock17_02am to set
	 */
	public void setVisualcheckofudrainsforstock17_02am(String visualcheckofudrainsforstock17_02am) {
		this.visualcheckofudrainsforstock17_02am = visualcheckofudrainsforstock17_02am;
	}
	/**
	 * @return the visualcheckofudrainsforstock17_06am
	 */
	public String getVisualcheckofudrainsforstock17_06am() {
		return visualcheckofudrainsforstock17_06am;
	}
	/**
	 * @param visualcheckofudrainsforstock17_06am the visualcheckofudrainsforstock17_06am to set
	 */
	public void setVisualcheckofudrainsforstock17_06am(String visualcheckofudrainsforstock17_06am) {
		this.visualcheckofudrainsforstock17_06am = visualcheckofudrainsforstock17_06am;
	}
	/**
	 * @return the visualcheckofudrainsforstock18_freq
	 */
	public String getVisualcheckofudrainsforstock18_freq() {
		return visualcheckofudrainsforstock18_freq;
	}
	/**
	 * @param visualcheckofudrainsforstock18_freq the visualcheckofudrainsforstock18_freq to set
	 */
	public void setVisualcheckofudrainsforstock18_freq(String visualcheckofudrainsforstock18_freq) {
		this.visualcheckofudrainsforstock18_freq = visualcheckofudrainsforstock18_freq;
	}
	/**
	 * @return the visualcheckofudrainsforstock18_10am
	 */
	public String getVisualcheckofudrainsforstock18_10am() {
		return visualcheckofudrainsforstock18_10am;
	}
	/**
	 * @param visualcheckofudrainsforstock18_10am the visualcheckofudrainsforstock18_10am to set
	 */
	public void setVisualcheckofudrainsforstock18_10am(String visualcheckofudrainsforstock18_10am) {
		this.visualcheckofudrainsforstock18_10am = visualcheckofudrainsforstock18_10am;
	}
	/**
	 * @return the visualcheckofudrainsforstock18_02pm
	 */
	public String getVisualcheckofudrainsforstock18_02pm() {
		return visualcheckofudrainsforstock18_02pm;
	}
	/**
	 * @param visualcheckofudrainsforstock18_02pm the visualcheckofudrainsforstock18_02pm to set
	 */
	public void setVisualcheckofudrainsforstock18_02pm(String visualcheckofudrainsforstock18_02pm) {
		this.visualcheckofudrainsforstock18_02pm = visualcheckofudrainsforstock18_02pm;
	}
	/**
	 * @return the visualcheckofudrainsforstock18_06pm
	 */
	public String getVisualcheckofudrainsforstock18_06pm() {
		return visualcheckofudrainsforstock18_06pm;
	}
	/**
	 * @param visualcheckofudrainsforstock18_06pm the visualcheckofudrainsforstock18_06pm to set
	 */
	public void setVisualcheckofudrainsforstock18_06pm(String visualcheckofudrainsforstock18_06pm) {
		this.visualcheckofudrainsforstock18_06pm = visualcheckofudrainsforstock18_06pm;
	}
	/**
	 * @return the visualcheckofudrainsforstock18_10pm
	 */
	public String getVisualcheckofudrainsforstock18_10pm() {
		return visualcheckofudrainsforstock18_10pm;
	}
	/**
	 * @param visualcheckofudrainsforstock18_10pm the visualcheckofudrainsforstock18_10pm to set
	 */
	public void setVisualcheckofudrainsforstock18_10pm(String visualcheckofudrainsforstock18_10pm) {
		this.visualcheckofudrainsforstock18_10pm = visualcheckofudrainsforstock18_10pm;
	}
	/**
	 * @return the visualcheckofudrainsforstock18_02am
	 */
	public String getVisualcheckofudrainsforstock18_02am() {
		return visualcheckofudrainsforstock18_02am;
	}
	/**
	 * @param visualcheckofudrainsforstock18_02am the visualcheckofudrainsforstock18_02am to set
	 */
	public void setVisualcheckofudrainsforstock18_02am(String visualcheckofudrainsforstock18_02am) {
		this.visualcheckofudrainsforstock18_02am = visualcheckofudrainsforstock18_02am;
	}
	/**
	 * @return the visualcheckofudrainsforstock18_06am
	 */
	public String getVisualcheckofudrainsforstock18_06am() {
		return visualcheckofudrainsforstock18_06am;
	}
	/**
	 * @param visualcheckofudrainsforstock18_06am the visualcheckofudrainsforstock18_06am to set
	 */
	public void setVisualcheckofudrainsforstock18_06am(String visualcheckofudrainsforstock18_06am) {
		this.visualcheckofudrainsforstock18_06am = visualcheckofudrainsforstock18_06am;
	}
	/**
	 * @return the visualcheckofudrainsforstock19_freq
	 */
	public String getVisualcheckofudrainsforstock19_freq() {
		return visualcheckofudrainsforstock19_freq;
	}
	/**
	 * @param visualcheckofudrainsforstock19_freq the visualcheckofudrainsforstock19_freq to set
	 */
	public void setVisualcheckofudrainsforstock19_freq(String visualcheckofudrainsforstock19_freq) {
		this.visualcheckofudrainsforstock19_freq = visualcheckofudrainsforstock19_freq;
	}
	/**
	 * @return the visualcheckofudrainsforstock19_10am
	 */
	public String getVisualcheckofudrainsforstock19_10am() {
		return visualcheckofudrainsforstock19_10am;
	}
	/**
	 * @param visualcheckofudrainsforstock19_10am the visualcheckofudrainsforstock19_10am to set
	 */
	public void setVisualcheckofudrainsforstock19_10am(String visualcheckofudrainsforstock19_10am) {
		this.visualcheckofudrainsforstock19_10am = visualcheckofudrainsforstock19_10am;
	}
	/**
	 * @return the visualcheckofudrainsforstock19_02pm
	 */
	public String getVisualcheckofudrainsforstock19_02pm() {
		return visualcheckofudrainsforstock19_02pm;
	}
	/**
	 * @param visualcheckofudrainsforstock19_02pm the visualcheckofudrainsforstock19_02pm to set
	 */
	public void setVisualcheckofudrainsforstock19_02pm(String visualcheckofudrainsforstock19_02pm) {
		this.visualcheckofudrainsforstock19_02pm = visualcheckofudrainsforstock19_02pm;
	}
	/**
	 * @return the visualcheckofudrainsforstock19_06pm
	 */
	public String getVisualcheckofudrainsforstock19_06pm() {
		return visualcheckofudrainsforstock19_06pm;
	}
	/**
	 * @param visualcheckofudrainsforstock19_06pm the visualcheckofudrainsforstock19_06pm to set
	 */
	public void setVisualcheckofudrainsforstock19_06pm(String visualcheckofudrainsforstock19_06pm) {
		this.visualcheckofudrainsforstock19_06pm = visualcheckofudrainsforstock19_06pm;
	}
	/**
	 * @return the visualcheckofudrainsforstock19_10pm
	 */
	public String getVisualcheckofudrainsforstock19_10pm() {
		return visualcheckofudrainsforstock19_10pm;
	}
	/**
	 * @param visualcheckofudrainsforstock19_10pm the visualcheckofudrainsforstock19_10pm to set
	 */
	public void setVisualcheckofudrainsforstock19_10pm(String visualcheckofudrainsforstock19_10pm) {
		this.visualcheckofudrainsforstock19_10pm = visualcheckofudrainsforstock19_10pm;
	}
	/**
	 * @return the visualcheckofudrainsforstock19_02am
	 */
	public String getVisualcheckofudrainsforstock19_02am() {
		return visualcheckofudrainsforstock19_02am;
	}
	/**
	 * @param visualcheckofudrainsforstock19_02am the visualcheckofudrainsforstock19_02am to set
	 */
	public void setVisualcheckofudrainsforstock19_02am(String visualcheckofudrainsforstock19_02am) {
		this.visualcheckofudrainsforstock19_02am = visualcheckofudrainsforstock19_02am;
	}
	/**
	 * @return the visualcheckofudrainsforstock19_06am
	 */
	public String getVisualcheckofudrainsforstock19_06am() {
		return visualcheckofudrainsforstock19_06am;
	}
	/**
	 * @param visualcheckofudrainsforstock19_06am the visualcheckofudrainsforstock19_06am to set
	 */
	public void setVisualcheckofudrainsforstock19_06am(String visualcheckofudrainsforstock19_06am) {
		this.visualcheckofudrainsforstock19_06am = visualcheckofudrainsforstock19_06am;
	}
	/**
	 * @return the visualcheckofudrainsforstock20_freq
	 */
	public String getVisualcheckofudrainsforstock20_freq() {
		return visualcheckofudrainsforstock20_freq;
	}
	/**
	 * @param visualcheckofudrainsforstock20_freq the visualcheckofudrainsforstock20_freq to set
	 */
	public void setVisualcheckofudrainsforstock20_freq(String visualcheckofudrainsforstock20_freq) {
		this.visualcheckofudrainsforstock20_freq = visualcheckofudrainsforstock20_freq;
	}
	/**
	 * @return the visualcheckofudrainsforstock20_10am
	 */
	public String getVisualcheckofudrainsforstock20_10am() {
		return visualcheckofudrainsforstock20_10am;
	}
	/**
	 * @param visualcheckofudrainsforstock20_10am the visualcheckofudrainsforstock20_10am to set
	 */
	public void setVisualcheckofudrainsforstock20_10am(String visualcheckofudrainsforstock20_10am) {
		this.visualcheckofudrainsforstock20_10am = visualcheckofudrainsforstock20_10am;
	}
	/**
	 * @return the visualcheckofudrainsforstock20_02pm
	 */
	public String getVisualcheckofudrainsforstock20_02pm() {
		return visualcheckofudrainsforstock20_02pm;
	}
	/**
	 * @param visualcheckofudrainsforstock20_02pm the visualcheckofudrainsforstock20_02pm to set
	 */
	public void setVisualcheckofudrainsforstock20_02pm(String visualcheckofudrainsforstock20_02pm) {
		this.visualcheckofudrainsforstock20_02pm = visualcheckofudrainsforstock20_02pm;
	}
	/**
	 * @return the visualcheckofudrainsforstock20_06pm
	 */
	public String getVisualcheckofudrainsforstock20_06pm() {
		return visualcheckofudrainsforstock20_06pm;
	}
	/**
	 * @param visualcheckofudrainsforstock20_06pm the visualcheckofudrainsforstock20_06pm to set
	 */
	public void setVisualcheckofudrainsforstock20_06pm(String visualcheckofudrainsforstock20_06pm) {
		this.visualcheckofudrainsforstock20_06pm = visualcheckofudrainsforstock20_06pm;
	}
	/**
	 * @return the visualcheckofudrainsforstock20_10pm
	 */
	public String getVisualcheckofudrainsforstock20_10pm() {
		return visualcheckofudrainsforstock20_10pm;
	}
	/**
	 * @param visualcheckofudrainsforstock20_10pm the visualcheckofudrainsforstock20_10pm to set
	 */
	public void setVisualcheckofudrainsforstock20_10pm(String visualcheckofudrainsforstock20_10pm) {
		this.visualcheckofudrainsforstock20_10pm = visualcheckofudrainsforstock20_10pm;
	}
	/**
	 * @return the visualcheckofudrainsforstock20_02am
	 */
	public String getVisualcheckofudrainsforstock20_02am() {
		return visualcheckofudrainsforstock20_02am;
	}
	/**
	 * @param visualcheckofudrainsforstock20_02am the visualcheckofudrainsforstock20_02am to set
	 */
	public void setVisualcheckofudrainsforstock20_02am(String visualcheckofudrainsforstock20_02am) {
		this.visualcheckofudrainsforstock20_02am = visualcheckofudrainsforstock20_02am;
	}
	/**
	 * @return the visualcheckofudrainsforstock20_06am
	 */
	public String getVisualcheckofudrainsforstock20_06am() {
		return visualcheckofudrainsforstock20_06am;
	}
	/**
	 * @param visualcheckofudrainsforstock20_06am the visualcheckofudrainsforstock20_06am to set
	 */
	public void setVisualcheckofudrainsforstock20_06am(String visualcheckofudrainsforstock20_06am) {
		this.visualcheckofudrainsforstock20_06am = visualcheckofudrainsforstock20_06am;
	}
	/**
	 * @return the visualcheckofudrainsforstock21_freq
	 */
	public String getVisualcheckofudrainsforstock21_freq() {
		return visualcheckofudrainsforstock21_freq;
	}
	/**
	 * @param visualcheckofudrainsforstock21_freq the visualcheckofudrainsforstock21_freq to set
	 */
	public void setVisualcheckofudrainsforstock21_freq(String visualcheckofudrainsforstock21_freq) {
		this.visualcheckofudrainsforstock21_freq = visualcheckofudrainsforstock21_freq;
	}
	/**
	 * @return the visualcheckofudrainsforstock21_10am
	 */
	public String getVisualcheckofudrainsforstock21_10am() {
		return visualcheckofudrainsforstock21_10am;
	}
	/**
	 * @param visualcheckofudrainsforstock21_10am the visualcheckofudrainsforstock21_10am to set
	 */
	public void setVisualcheckofudrainsforstock21_10am(String visualcheckofudrainsforstock21_10am) {
		this.visualcheckofudrainsforstock21_10am = visualcheckofudrainsforstock21_10am;
	}
	/**
	 * @return the visualcheckofudrainsforstock21_02pm
	 */
	public String getVisualcheckofudrainsforstock21_02pm() {
		return visualcheckofudrainsforstock21_02pm;
	}
	/**
	 * @param visualcheckofudrainsforstock21_02pm the visualcheckofudrainsforstock21_02pm to set
	 */
	public void setVisualcheckofudrainsforstock21_02pm(String visualcheckofudrainsforstock21_02pm) {
		this.visualcheckofudrainsforstock21_02pm = visualcheckofudrainsforstock21_02pm;
	}
	/**
	 * @return the visualcheckofudrainsforstock21_06pm
	 */
	public String getVisualcheckofudrainsforstock21_06pm() {
		return visualcheckofudrainsforstock21_06pm;
	}
	/**
	 * @param visualcheckofudrainsforstock21_06pm the visualcheckofudrainsforstock21_06pm to set
	 */
	public void setVisualcheckofudrainsforstock21_06pm(String visualcheckofudrainsforstock21_06pm) {
		this.visualcheckofudrainsforstock21_06pm = visualcheckofudrainsforstock21_06pm;
	}
	/**
	 * @return the visualcheckofudrainsforstock21_10pm
	 */
	public String getVisualcheckofudrainsforstock21_10pm() {
		return visualcheckofudrainsforstock21_10pm;
	}
	/**
	 * @param visualcheckofudrainsforstock21_10pm the visualcheckofudrainsforstock21_10pm to set
	 */
	public void setVisualcheckofudrainsforstock21_10pm(String visualcheckofudrainsforstock21_10pm) {
		this.visualcheckofudrainsforstock21_10pm = visualcheckofudrainsforstock21_10pm;
	}
	/**
	 * @return the visualcheckofudrainsforstock21_02am
	 */
	public String getVisualcheckofudrainsforstock21_02am() {
		return visualcheckofudrainsforstock21_02am;
	}
	/**
	 * @param visualcheckofudrainsforstock21_02am the visualcheckofudrainsforstock21_02am to set
	 */
	public void setVisualcheckofudrainsforstock21_02am(String visualcheckofudrainsforstock21_02am) {
		this.visualcheckofudrainsforstock21_02am = visualcheckofudrainsforstock21_02am;
	}
	/**
	 * @return the visualcheckofudrainsforstock21_06am
	 */
	public String getVisualcheckofudrainsforstock21_06am() {
		return visualcheckofudrainsforstock21_06am;
	}
	/**
	 * @param visualcheckofudrainsforstock21_06am the visualcheckofudrainsforstock21_06am to set
	 */
	public void setVisualcheckofudrainsforstock21_06am(String visualcheckofudrainsforstock21_06am) {
		this.visualcheckofudrainsforstock21_06am = visualcheckofudrainsforstock21_06am;
	}
	/**
	 * @return the totes1_freq
	 */
	public String getTotes1_freq() {
		return totes1_freq;
	}
	/**
	 * @param totes1_freq the totes1_freq to set
	 */
	public void setTotes1_freq(String totes1_freq) {
		this.totes1_freq = totes1_freq;
	}
	/**
	 * @return the totes1_10am
	 */
	public String getTotes1_10am() {
		return totes1_10am;
	}
	/**
	 * @param totes1_10am the totes1_10am to set
	 */
	public void setTotes1_10am(String totes1_10am) {
		this.totes1_10am = totes1_10am;
	}
	/**
	 * @return the totes1_02pm
	 */
	public String getTotes1_02pm() {
		return totes1_02pm;
	}
	/**
	 * @param totes1_02pm the totes1_02pm to set
	 */
	public void setTotes1_02pm(String totes1_02pm) {
		this.totes1_02pm = totes1_02pm;
	}
	/**
	 * @return the totes1_06pm
	 */
	public String getTotes1_06pm() {
		return totes1_06pm;
	}
	/**
	 * @param totes1_06pm the totes1_06pm to set
	 */
	public void setTotes1_06pm(String totes1_06pm) {
		this.totes1_06pm = totes1_06pm;
	}
	/**
	 * @return the totes1_10pm
	 */
	public String getTotes1_10pm() {
		return totes1_10pm;
	}
	/**
	 * @param totes1_10pm the totes1_10pm to set
	 */
	public void setTotes1_10pm(String totes1_10pm) {
		this.totes1_10pm = totes1_10pm;
	}
	/**
	 * @return the totes1_02am
	 */
	public String getTotes1_02am() {
		return totes1_02am;
	}
	/**
	 * @param totes1_02am the totes1_02am to set
	 */
	public void setTotes1_02am(String totes1_02am) {
		this.totes1_02am = totes1_02am;
	}
	/**
	 * @return the totes1_06am
	 */
	public String getTotes1_06am() {
		return totes1_06am;
	}
	/**
	 * @param totes1_06am the totes1_06am to set
	 */
	public void setTotes1_06am(String totes1_06am) {
		this.totes1_06am = totes1_06am;
	}
	/**
	 * @return the totes2_freq
	 */
	public String getTotes2_freq() {
		return totes2_freq;
	}
	/**
	 * @param totes2_freq the totes2_freq to set
	 */
	public void setTotes2_freq(String totes2_freq) {
		this.totes2_freq = totes2_freq;
	}
	/**
	 * @return the totes2_10am
	 */
	public String getTotes2_10am() {
		return totes2_10am;
	}
	/**
	 * @param totes2_10am the totes2_10am to set
	 */
	public void setTotes2_10am(String totes2_10am) {
		this.totes2_10am = totes2_10am;
	}
	/**
	 * @return the totes2_02pm
	 */
	public String getTotes2_02pm() {
		return totes2_02pm;
	}
	/**
	 * @param totes2_02pm the totes2_02pm to set
	 */
	public void setTotes2_02pm(String totes2_02pm) {
		this.totes2_02pm = totes2_02pm;
	}
	/**
	 * @return the totes2_06pm
	 */
	public String getTotes2_06pm() {
		return totes2_06pm;
	}
	/**
	 * @param totes2_06pm the totes2_06pm to set
	 */
	public void setTotes2_06pm(String totes2_06pm) {
		this.totes2_06pm = totes2_06pm;
	}
	/**
	 * @return the totes2_10pm
	 */
	public String getTotes2_10pm() {
		return totes2_10pm;
	}
	/**
	 * @param totes2_10pm the totes2_10pm to set
	 */
	public void setTotes2_10pm(String totes2_10pm) {
		this.totes2_10pm = totes2_10pm;
	}
	/**
	 * @return the totes2_02am
	 */
	public String getTotes2_02am() {
		return totes2_02am;
	}
	/**
	 * @param totes2_02am the totes2_02am to set
	 */
	public void setTotes2_02am(String totes2_02am) {
		this.totes2_02am = totes2_02am;
	}
	/**
	 * @return the totes2_06am
	 */
	public String getTotes2_06am() {
		return totes2_06am;
	}
	/**
	 * @param totes2_06am the totes2_06am to set
	 */
	public void setTotes2_06am(String totes2_06am) {
		this.totes2_06am = totes2_06am;
	}
	/**
	 * @return the tubeconveyordrive1_freq
	 */
	public String getTubeconveyordrive1_freq() {
		return tubeconveyordrive1_freq;
	}
	/**
	 * @param tubeconveyordrive1_freq the tubeconveyordrive1_freq to set
	 */
	public void setTubeconveyordrive1_freq(String tubeconveyordrive1_freq) {
		this.tubeconveyordrive1_freq = tubeconveyordrive1_freq;
	}
	/**
	 * @return the tubeconveyordrive1_10am
	 */
	public String getTubeconveyordrive1_10am() {
		return tubeconveyordrive1_10am;
	}
	/**
	 * @param tubeconveyordrive1_10am the tubeconveyordrive1_10am to set
	 */
	public void setTubeconveyordrive1_10am(String tubeconveyordrive1_10am) {
		this.tubeconveyordrive1_10am = tubeconveyordrive1_10am;
	}
	/**
	 * @return the tubeconveyordrive1_02pm
	 */
	public String getTubeconveyordrive1_02pm() {
		return tubeconveyordrive1_02pm;
	}
	/**
	 * @param tubeconveyordrive1_02pm the tubeconveyordrive1_02pm to set
	 */
	public void setTubeconveyordrive1_02pm(String tubeconveyordrive1_02pm) {
		this.tubeconveyordrive1_02pm = tubeconveyordrive1_02pm;
	}
	/**
	 * @return the tubeconveyordrive1_06pm
	 */
	public String getTubeconveyordrive1_06pm() {
		return tubeconveyordrive1_06pm;
	}
	/**
	 * @param tubeconveyordrive1_06pm the tubeconveyordrive1_06pm to set
	 */
	public void setTubeconveyordrive1_06pm(String tubeconveyordrive1_06pm) {
		this.tubeconveyordrive1_06pm = tubeconveyordrive1_06pm;
	}
	/**
	 * @return the tubeconveyordrive1_10pm
	 */
	public String getTubeconveyordrive1_10pm() {
		return tubeconveyordrive1_10pm;
	}
	/**
	 * @param tubeconveyordrive1_10pm the tubeconveyordrive1_10pm to set
	 */
	public void setTubeconveyordrive1_10pm(String tubeconveyordrive1_10pm) {
		this.tubeconveyordrive1_10pm = tubeconveyordrive1_10pm;
	}
	/**
	 * @return the tubeconveyordrive1_02am
	 */
	public String getTubeconveyordrive1_02am() {
		return tubeconveyordrive1_02am;
	}
	/**
	 * @param tubeconveyordrive1_02am the tubeconveyordrive1_02am to set
	 */
	public void setTubeconveyordrive1_02am(String tubeconveyordrive1_02am) {
		this.tubeconveyordrive1_02am = tubeconveyordrive1_02am;
	}
	/**
	 * @return the tubeconveyordrive1_06am
	 */
	public String getTubeconveyordrive1_06am() {
		return tubeconveyordrive1_06am;
	}
	/**
	 * @param tubeconveyordrive1_06am the tubeconveyordrive1_06am to set
	 */
	public void setTubeconveyordrive1_06am(String tubeconveyordrive1_06am) {
		this.tubeconveyordrive1_06am = tubeconveyordrive1_06am;
	}
	/**
	 * @return the tubeconveyordrive2_freq
	 */
	public String getTubeconveyordrive2_freq() {
		return tubeconveyordrive2_freq;
	}
	/**
	 * @param tubeconveyordrive2_freq the tubeconveyordrive2_freq to set
	 */
	public void setTubeconveyordrive2_freq(String tubeconveyordrive2_freq) {
		this.tubeconveyordrive2_freq = tubeconveyordrive2_freq;
	}
	/**
	 * @return the tubeconveyordrive2_10am
	 */
	public String getTubeconveyordrive2_10am() {
		return tubeconveyordrive2_10am;
	}
	/**
	 * @param tubeconveyordrive2_10am the tubeconveyordrive2_10am to set
	 */
	public void setTubeconveyordrive2_10am(String tubeconveyordrive2_10am) {
		this.tubeconveyordrive2_10am = tubeconveyordrive2_10am;
	}
	/**
	 * @return the tubeconveyordrive2_02pm
	 */
	public String getTubeconveyordrive2_02pm() {
		return tubeconveyordrive2_02pm;
	}
	/**
	 * @param tubeconveyordrive2_02pm the tubeconveyordrive2_02pm to set
	 */
	public void setTubeconveyordrive2_02pm(String tubeconveyordrive2_02pm) {
		this.tubeconveyordrive2_02pm = tubeconveyordrive2_02pm;
	}
	/**
	 * @return the tubeconveyordrive2_06pm
	 */
	public String getTubeconveyordrive2_06pm() {
		return tubeconveyordrive2_06pm;
	}
	/**
	 * @param tubeconveyordrive2_06pm the tubeconveyordrive2_06pm to set
	 */
	public void setTubeconveyordrive2_06pm(String tubeconveyordrive2_06pm) {
		this.tubeconveyordrive2_06pm = tubeconveyordrive2_06pm;
	}
	/**
	 * @return the tubeconveyordrive2_10pm
	 */
	public String getTubeconveyordrive2_10pm() {
		return tubeconveyordrive2_10pm;
	}
	/**
	 * @param tubeconveyordrive2_10pm the tubeconveyordrive2_10pm to set
	 */
	public void setTubeconveyordrive2_10pm(String tubeconveyordrive2_10pm) {
		this.tubeconveyordrive2_10pm = tubeconveyordrive2_10pm;
	}
	/**
	 * @return the tubeconveyordrive2_02am
	 */
	public String getTubeconveyordrive2_02am() {
		return tubeconveyordrive2_02am;
	}
	/**
	 * @param tubeconveyordrive2_02am the tubeconveyordrive2_02am to set
	 */
	public void setTubeconveyordrive2_02am(String tubeconveyordrive2_02am) {
		this.tubeconveyordrive2_02am = tubeconveyordrive2_02am;
	}
	/**
	 * @return the tubeconveyordrive2_06am
	 */
	public String getTubeconveyordrive2_06am() {
		return tubeconveyordrive2_06am;
	}
	/**
	 * @param tubeconveyordrive2_06am the tubeconveyordrive2_06am to set
	 */
	public void setTubeconveyordrive2_06am(String tubeconveyordrive2_06am) {
		this.tubeconveyordrive2_06am = tubeconveyordrive2_06am;
	}
	/**
	 * @return the tubeconveyordrive3_freq
	 */
	public String getTubeconveyordrive3_freq() {
		return tubeconveyordrive3_freq;
	}
	/**
	 * @param tubeconveyordrive3_freq the tubeconveyordrive3_freq to set
	 */
	public void setTubeconveyordrive3_freq(String tubeconveyordrive3_freq) {
		this.tubeconveyordrive3_freq = tubeconveyordrive3_freq;
	}
	/**
	 * @return the tubeconveyordrive3_10am
	 */
	public String getTubeconveyordrive3_10am() {
		return tubeconveyordrive3_10am;
	}
	/**
	 * @param tubeconveyordrive3_10am the tubeconveyordrive3_10am to set
	 */
	public void setTubeconveyordrive3_10am(String tubeconveyordrive3_10am) {
		this.tubeconveyordrive3_10am = tubeconveyordrive3_10am;
	}
	/**
	 * @return the tubeconveyordrive3_02pm
	 */
	public String getTubeconveyordrive3_02pm() {
		return tubeconveyordrive3_02pm;
	}
	/**
	 * @param tubeconveyordrive3_02pm the tubeconveyordrive3_02pm to set
	 */
	public void setTubeconveyordrive3_02pm(String tubeconveyordrive3_02pm) {
		this.tubeconveyordrive3_02pm = tubeconveyordrive3_02pm;
	}
	/**
	 * @return the tubeconveyordrive3_06pm
	 */
	public String getTubeconveyordrive3_06pm() {
		return tubeconveyordrive3_06pm;
	}
	/**
	 * @param tubeconveyordrive3_06pm the tubeconveyordrive3_06pm to set
	 */
	public void setTubeconveyordrive3_06pm(String tubeconveyordrive3_06pm) {
		this.tubeconveyordrive3_06pm = tubeconveyordrive3_06pm;
	}
	/**
	 * @return the tubeconveyordrive3_10pm
	 */
	public String getTubeconveyordrive3_10pm() {
		return tubeconveyordrive3_10pm;
	}
	/**
	 * @param tubeconveyordrive3_10pm the tubeconveyordrive3_10pm to set
	 */
	public void setTubeconveyordrive3_10pm(String tubeconveyordrive3_10pm) {
		this.tubeconveyordrive3_10pm = tubeconveyordrive3_10pm;
	}
	/**
	 * @return the tubeconveyordrive3_02am
	 */
	public String getTubeconveyordrive3_02am() {
		return tubeconveyordrive3_02am;
	}
	/**
	 * @param tubeconveyordrive3_02am the tubeconveyordrive3_02am to set
	 */
	public void setTubeconveyordrive3_02am(String tubeconveyordrive3_02am) {
		this.tubeconveyordrive3_02am = tubeconveyordrive3_02am;
	}
	/**
	 * @return the tubeconveyordrive3_06am
	 */
	public String getTubeconveyordrive3_06am() {
		return tubeconveyordrive3_06am;
	}
	/**
	 * @param tubeconveyordrive3_06am the tubeconveyordrive3_06am to set
	 */
	public void setTubeconveyordrive3_06am(String tubeconveyordrive3_06am) {
		this.tubeconveyordrive3_06am = tubeconveyordrive3_06am;
	}
	/**
	 * @return the tubeconveyordrive4_freq
	 */
	public String getTubeconveyordrive4_freq() {
		return tubeconveyordrive4_freq;
	}
	/**
	 * @param tubeconveyordrive4_freq the tubeconveyordrive4_freq to set
	 */
	public void setTubeconveyordrive4_freq(String tubeconveyordrive4_freq) {
		this.tubeconveyordrive4_freq = tubeconveyordrive4_freq;
	}
	/**
	 * @return the tubeconveyordrive4_10am
	 */
	public String getTubeconveyordrive4_10am() {
		return tubeconveyordrive4_10am;
	}
	/**
	 * @param tubeconveyordrive4_10am the tubeconveyordrive4_10am to set
	 */
	public void setTubeconveyordrive4_10am(String tubeconveyordrive4_10am) {
		this.tubeconveyordrive4_10am = tubeconveyordrive4_10am;
	}
	/**
	 * @return the tubeconveyordrive4_02pm
	 */
	public String getTubeconveyordrive4_02pm() {
		return tubeconveyordrive4_02pm;
	}
	/**
	 * @param tubeconveyordrive4_02pm the tubeconveyordrive4_02pm to set
	 */
	public void setTubeconveyordrive4_02pm(String tubeconveyordrive4_02pm) {
		this.tubeconveyordrive4_02pm = tubeconveyordrive4_02pm;
	}
	/**
	 * @return the tubeconveyordrive4_06pm
	 */
	public String getTubeconveyordrive4_06pm() {
		return tubeconveyordrive4_06pm;
	}
	/**
	 * @param tubeconveyordrive4_06pm the tubeconveyordrive4_06pm to set
	 */
	public void setTubeconveyordrive4_06pm(String tubeconveyordrive4_06pm) {
		this.tubeconveyordrive4_06pm = tubeconveyordrive4_06pm;
	}
	/**
	 * @return the tubeconveyordrive4_10pm
	 */
	public String getTubeconveyordrive4_10pm() {
		return tubeconveyordrive4_10pm;
	}
	/**
	 * @param tubeconveyordrive4_10pm the tubeconveyordrive4_10pm to set
	 */
	public void setTubeconveyordrive4_10pm(String tubeconveyordrive4_10pm) {
		this.tubeconveyordrive4_10pm = tubeconveyordrive4_10pm;
	}
	/**
	 * @return the tubeconveyordrive4_02am
	 */
	public String getTubeconveyordrive4_02am() {
		return tubeconveyordrive4_02am;
	}
	/**
	 * @param tubeconveyordrive4_02am the tubeconveyordrive4_02am to set
	 */
	public void setTubeconveyordrive4_02am(String tubeconveyordrive4_02am) {
		this.tubeconveyordrive4_02am = tubeconveyordrive4_02am;
	}
	/**
	 * @return the tubeconveyordrive4_06am
	 */
	public String getTubeconveyordrive4_06am() {
		return tubeconveyordrive4_06am;
	}
	/**
	 * @param tubeconveyordrive4_06am the tubeconveyordrive4_06am to set
	 */
	public void setTubeconveyordrive4_06am(String tubeconveyordrive4_06am) {
		this.tubeconveyordrive4_06am = tubeconveyordrive4_06am;
	}
	/**
	 * @return the tubeconveyordrive5_freq
	 */
	public String getTubeconveyordrive5_freq() {
		return tubeconveyordrive5_freq;
	}
	/**
	 * @param tubeconveyordrive5_freq the tubeconveyordrive5_freq to set
	 */
	public void setTubeconveyordrive5_freq(String tubeconveyordrive5_freq) {
		this.tubeconveyordrive5_freq = tubeconveyordrive5_freq;
	}
	/**
	 * @return the tubeconveyordrive5_10am
	 */
	public String getTubeconveyordrive5_10am() {
		return tubeconveyordrive5_10am;
	}
	/**
	 * @param tubeconveyordrive5_10am the tubeconveyordrive5_10am to set
	 */
	public void setTubeconveyordrive5_10am(String tubeconveyordrive5_10am) {
		this.tubeconveyordrive5_10am = tubeconveyordrive5_10am;
	}
	/**
	 * @return the tubeconveyordrive5_02pm
	 */
	public String getTubeconveyordrive5_02pm() {
		return tubeconveyordrive5_02pm;
	}
	/**
	 * @param tubeconveyordrive5_02pm the tubeconveyordrive5_02pm to set
	 */
	public void setTubeconveyordrive5_02pm(String tubeconveyordrive5_02pm) {
		this.tubeconveyordrive5_02pm = tubeconveyordrive5_02pm;
	}
	/**
	 * @return the tubeconveyordrive5_06pm
	 */
	public String getTubeconveyordrive5_06pm() {
		return tubeconveyordrive5_06pm;
	}
	/**
	 * @param tubeconveyordrive5_06pm the tubeconveyordrive5_06pm to set
	 */
	public void setTubeconveyordrive5_06pm(String tubeconveyordrive5_06pm) {
		this.tubeconveyordrive5_06pm = tubeconveyordrive5_06pm;
	}
	/**
	 * @return the tubeconveyordrive5_10pm
	 */
	public String getTubeconveyordrive5_10pm() {
		return tubeconveyordrive5_10pm;
	}
	/**
	 * @param tubeconveyordrive5_10pm the tubeconveyordrive5_10pm to set
	 */
	public void setTubeconveyordrive5_10pm(String tubeconveyordrive5_10pm) {
		this.tubeconveyordrive5_10pm = tubeconveyordrive5_10pm;
	}
	/**
	 * @return the tubeconveyordrive5_02am
	 */
	public String getTubeconveyordrive5_02am() {
		return tubeconveyordrive5_02am;
	}
	/**
	 * @param tubeconveyordrive5_02am the tubeconveyordrive5_02am to set
	 */
	public void setTubeconveyordrive5_02am(String tubeconveyordrive5_02am) {
		this.tubeconveyordrive5_02am = tubeconveyordrive5_02am;
	}
	/**
	 * @return the tubeconveyordrive5_06am
	 */
	public String getTubeconveyordrive5_06am() {
		return tubeconveyordrive5_06am;
	}
	/**
	 * @param tubeconveyordrive5_06am the tubeconveyordrive5_06am to set
	 */
	public void setTubeconveyordrive5_06am(String tubeconveyordrive5_06am) {
		this.tubeconveyordrive5_06am = tubeconveyordrive5_06am;
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

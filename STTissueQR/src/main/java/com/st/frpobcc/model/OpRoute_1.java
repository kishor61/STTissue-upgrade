/**
 *27Nov219
 *OpRoute_1.java
 * TODO
 *com.st.frpobcc.model
 *OpRoute_1.java
 *Roshan Lal Tailor
 */
package com.st.frpobcc.model;

/**
 * @author sohan
 *
 */
public class OpRoute_1 {
	
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
	private String hdcleaner1_freq;
	private String hdcleaner1_9am;	
	private String hdcleaner1_1pm;	
	private String hdcleaner1_5pm;	
	private String hdcleaner1_9pm;	
	private String hdcleaner1_1am;	
	private String hdcleaner1_5am;
	private String hdcleaner2_freq;
	private String hdcleaner2_9am;	
	private String hdcleaner2_1pm;	
	private String hdcleaner2_5pm;	
	private String hdcleaner2_9pm;	
	private String hdcleaner2_1am;	
	private String hdcleaner2_5am;
	private String hdcleaner3_freq;
	private String hdcleaner3_9am;	
	private String hdcleaner3_1pm;	
	private String hdcleaner3_5pm;	
	private String hdcleaner3_9pm;	
	private String hdcleaner3_1am;	
	private String hdcleaner3_5am;
	private String hdcleaner4_freq;
	private String hdcleaner4_9am;	
	private String hdcleaner4_1pm;	
	private String hdcleaner4_5pm;	
	private String hdcleaner4_9pm;	
	private String hdcleaner4_1am;	
	private String hdcleaner4_5am;
	private String hdcleanerb_freq;
	private String hdcleanerb_9am;	
	private String hdcleanerb_1pm;	
	private String hdcleanerb_5pm;	
	private String hdcleanerb_9pm;	
	private String hdcleanerb_1am;	
	private String hdcleanerb_5am;		

	private String drumscreen1_freq;
	private String drumscreen1_9am;	
	private String drumscreen1_1pm;	
	private String drumscreen1_5pm;	
	private String drumscreen1_9pm;	
	private String drumscreen1_1am;	
	private String drumscreen1_5am;
	private String drumscreen2_freq;
	private String drumscreen2_9am;	
	private String drumscreen2_1pm;	
	private String drumscreen2_5pm;	
	private String drumscreen2_9pm;	
	private String drumscreen2_1am;	
	private String drumscreen2_5am;
	private String drumscreen3_freq;
	private String drumscreen3_9am;	
	private String drumscreen3_1pm;
	private String drumscreen3_5pm;	
	private String drumscreen3_9pm;
	private String drumscreen3_1am;	
	private String drumscreen3_5am;	

	private String coarsescreens1_freq;
	private String coarsescreens1_9am;	
	private String coarsescreens1_1pm;	
	private String coarsescreens1_5pm;	
	private String coarsescreens1_9pm;	
	private String coarsescreens1_1am;	
	private String coarsescreens1_5am;
	private String coarsescreens2_freq;
	private String coarsescreens2_9am;	
	private String coarsescreens2_1pm;	
	private String coarsescreens2_5pm;	
	private String coarsescreens2_9pm;	
	private String coarsescreens2_1am;	
	private String coarsescreens2_5am;
	private String coarsescreens3_freq;
	private String coarsescreens3_9am;	
	private String coarsescreens3_1pm;	
	private String coarsescreens3_5pm;	
	private String coarsescreens3_9pm;	
	private String coarsescreens3_1am;	
	private String coarsescreens3_5am;
	private String coarsescreens4_freq;
	private String coarsescreens4_9am;	
	private String coarsescreens4_1pm;	
	private String coarsescreens4_5pm;	
	private String coarsescreens4_9pm;	
	private String coarsescreens4_1am;	
	private String coarsescreens4_5am;
	private String coarsescreens5_freq;
	private String coarsescreens5_9am;	
	private String coarsescreens5_1pm;	
	private String coarsescreens5_5pm;	
	private String coarsescreens5_9pm;	
	private String coarsescreens5_1am;	
	private String coarsescreens5_5am;
	private String coarsescreens6_freq;
	private String coarsescreens6_9am;	
	private String coarsescreens6_1pm;	
	private String coarsescreens6_5pm;	
	private String coarsescreens6_9pm;	
	private String coarsescreens6_1am;	
	private String coarsescreens6_5am;
	private String coarsescreens7_freq;
	private String coarsescreens7_9am;	
	private String coarsescreens7_1pm;	
	private String coarsescreens7_5pm;	
	private String coarsescreens7_9pm;	
	private String coarsescreens7_1am;	
	private String coarsescreens7_5am;	

	private String finescreens1_freq;
	private String finescreens1_9am;	
	private String finescreens1_1pm;	
	private String finescreens1_5pm;	
	private String finescreens1_9pm;	
	private String finescreens1_1am;	
	private String finescreens1_5am;	
	private String finescreens2_freq;
	private String finescreens2_9am;	
	private String finescreens2_1pm;	
	private String finescreens2_5pm;	
	private String finescreens2_9pm;	
	private String finescreens2_1am;	
	private String finescreens2_5am;	
	private String finescreens3_freq;
	private String finescreens3_9am;	
	private String finescreens3_1pm;	
	private String finescreens3_5pm;	
	private String finescreens3_9pm;	
	private String finescreens3_1am;	
	private String finescreens3_5am;	
	private String finescreens4_freq;
	private String finescreens4_9am;	
	private String finescreens4_1pm;	
	private String finescreens4_5pm;	
	private String finescreens4_9pm;	
	private String finescreens4_1am;	
	private String finescreens4_5am;	
	private String finescreens5_freq;
	private String finescreens5_9am;	
	private String finescreens5_1pm;	
	private String finescreens5_5pm;	
	private String finescreens5_9pm;	
	private String finescreens5_1am;	
	private String finescreens5_5am;	
	private String finescreens6_freq;
	private String finescreens6_9am;	
	private String finescreens6_1pm;	
	private String finescreens6_5pm;	
	private String finescreens6_9pm;	
	private String finescreens6_1am;	
	private String finescreens6_5am;	


	private String showerpumps1_freq;
	private String showerpumps1_9am;	
	private String showerpumps1_1pm;	
	private String showerpumps1_5pm;	
	private String showerpumps1_9pm;	
	private String showerpumps1_1am;	
	private String showerpumps1_5am;	
	private String showerpumps2_freq;
	private String showerpumps2_9am;	
	private String showerpumps2_1pm;	
	private String showerpumps2_5pm;	
	private String showerpumps2_9pm;	
	private String showerpumps2_1am;	
	private String showerpumps2_5am;	


	private String deckerfeedpump1_freq;
	private String deckerfeedpump1_9am;	
	private String deckerfeedpump1_1pm;	
	private String deckerfeedpump1_5pm;	
	private String deckerfeedpump1_9pm;	
	private String deckerfeedpump1_1am;	
	private String deckerfeedpump1_5am;	
	private String deckerfeedpump2_freq;
	private String deckerfeedpump2_9am;	
	private String deckerfeedpump2_1pm;	
	private String deckerfeedpump2_5pm;	
	private String deckerfeedpump2_9pm;	
	private String deckerfeedpump2_1am;	
	private String deckerfeedpump2_5am;	

	private String daf1_freq;
	private String daf1_9am;	
	private String daf1_1pm;	
	private String daf1_5pm;	
	private String daf1_9pm;	
	private String daf1_1am;	
	private String daf1_5am;	
	private String daf2_freq;
	private String daf2_9am;	
	private String daf2_1pm;	
	private String daf2_5pm;	
	private String daf2_9pm;	
	private String daf2_1am;	
	private String daf2_5am;	

	private String rollupprocessfloorwashuphoses1_freq;
	private String rollupprocessfloorwashuphoses1_9am;	
	private String rollupprocessfloorwashuphoses1_1pm;	
	private String rollupprocessfloorwashuphoses1_5pm;	
	private String rollupprocessfloorwashuphoses1_9pm;	
	private String rollupprocessfloorwashuphoses1_1am;	
	private String rollupprocessfloorwashuphoses1_5am;
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
	 * @return the hdcleaner1_freq
	 */
	public String getHdcleaner1_freq() {
		return hdcleaner1_freq;
	}
	/**
	 * @param hdcleaner1_freq the hdcleaner1_freq to set
	 */
	public void setHdcleaner1_freq(String hdcleaner1_freq) {
		this.hdcleaner1_freq = hdcleaner1_freq;
	}
	/**
	 * @return the hdcleaner1_9am
	 */
	public String getHdcleaner1_9am() {
		return hdcleaner1_9am;
	}
	/**
	 * @param hdcleaner1_9am the hdcleaner1_9am to set
	 */
	public void setHdcleaner1_9am(String hdcleaner1_9am) {
		this.hdcleaner1_9am = hdcleaner1_9am;
	}
	/**
	 * @return the hdcleaner1_1pm
	 */
	public String getHdcleaner1_1pm() {
		return hdcleaner1_1pm;
	}
	/**
	 * @param hdcleaner1_1pm the hdcleaner1_1pm to set
	 */
	public void setHdcleaner1_1pm(String hdcleaner1_1pm) {
		this.hdcleaner1_1pm = hdcleaner1_1pm;
	}
	/**
	 * @return the hdcleaner1_5pm
	 */
	public String getHdcleaner1_5pm() {
		return hdcleaner1_5pm;
	}
	/**
	 * @param hdcleaner1_5pm the hdcleaner1_5pm to set
	 */
	public void setHdcleaner1_5pm(String hdcleaner1_5pm) {
		this.hdcleaner1_5pm = hdcleaner1_5pm;
	}
	/**
	 * @return the hdcleaner1_9pm
	 */
	public String getHdcleaner1_9pm() {
		return hdcleaner1_9pm;
	}
	/**
	 * @param hdcleaner1_9pm the hdcleaner1_9pm to set
	 */
	public void setHdcleaner1_9pm(String hdcleaner1_9pm) {
		this.hdcleaner1_9pm = hdcleaner1_9pm;
	}
	/**
	 * @return the hdcleaner1_1am
	 */
	public String getHdcleaner1_1am() {
		return hdcleaner1_1am;
	}
	/**
	 * @param hdcleaner1_1am the hdcleaner1_1am to set
	 */
	public void setHdcleaner1_1am(String hdcleaner1_1am) {
		this.hdcleaner1_1am = hdcleaner1_1am;
	}
	/**
	 * @return the hdcleaner1_5am
	 */
	public String getHdcleaner1_5am() {
		return hdcleaner1_5am;
	}
	/**
	 * @param hdcleaner1_5am the hdcleaner1_5am to set
	 */
	public void setHdcleaner1_5am(String hdcleaner1_5am) {
		this.hdcleaner1_5am = hdcleaner1_5am;
	}
	/**
	 * @return the hdcleaner2_freq
	 */
	public String getHdcleaner2_freq() {
		return hdcleaner2_freq;
	}
	/**
	 * @param hdcleaner2_freq the hdcleaner2_freq to set
	 */
	public void setHdcleaner2_freq(String hdcleaner2_freq) {
		this.hdcleaner2_freq = hdcleaner2_freq;
	}
	/**
	 * @return the hdcleaner2_9am
	 */
	public String getHdcleaner2_9am() {
		return hdcleaner2_9am;
	}
	/**
	 * @param hdcleaner2_9am the hdcleaner2_9am to set
	 */
	public void setHdcleaner2_9am(String hdcleaner2_9am) {
		this.hdcleaner2_9am = hdcleaner2_9am;
	}
	/**
	 * @return the hdcleaner2_1pm
	 */
	public String getHdcleaner2_1pm() {
		return hdcleaner2_1pm;
	}
	/**
	 * @param hdcleaner2_1pm the hdcleaner2_1pm to set
	 */
	public void setHdcleaner2_1pm(String hdcleaner2_1pm) {
		this.hdcleaner2_1pm = hdcleaner2_1pm;
	}
	/**
	 * @return the hdcleaner2_5pm
	 */
	public String getHdcleaner2_5pm() {
		return hdcleaner2_5pm;
	}
	/**
	 * @param hdcleaner2_5pm the hdcleaner2_5pm to set
	 */
	public void setHdcleaner2_5pm(String hdcleaner2_5pm) {
		this.hdcleaner2_5pm = hdcleaner2_5pm;
	}
	/**
	 * @return the hdcleaner2_9pm
	 */
	public String getHdcleaner2_9pm() {
		return hdcleaner2_9pm;
	}
	/**
	 * @param hdcleaner2_9pm the hdcleaner2_9pm to set
	 */
	public void setHdcleaner2_9pm(String hdcleaner2_9pm) {
		this.hdcleaner2_9pm = hdcleaner2_9pm;
	}
	/**
	 * @return the hdcleaner2_1am
	 */
	public String getHdcleaner2_1am() {
		return hdcleaner2_1am;
	}
	/**
	 * @param hdcleaner2_1am the hdcleaner2_1am to set
	 */
	public void setHdcleaner2_1am(String hdcleaner2_1am) {
		this.hdcleaner2_1am = hdcleaner2_1am;
	}
	/**
	 * @return the hdcleaner2_5am
	 */
	public String getHdcleaner2_5am() {
		return hdcleaner2_5am;
	}
	/**
	 * @param hdcleaner2_5am the hdcleaner2_5am to set
	 */
	public void setHdcleaner2_5am(String hdcleaner2_5am) {
		this.hdcleaner2_5am = hdcleaner2_5am;
	}
	/**
	 * @return the hdcleaner3_freq
	 */
	public String getHdcleaner3_freq() {
		return hdcleaner3_freq;
	}
	/**
	 * @param hdcleaner3_freq the hdcleaner3_freq to set
	 */
	public void setHdcleaner3_freq(String hdcleaner3_freq) {
		this.hdcleaner3_freq = hdcleaner3_freq;
	}
	/**
	 * @return the hdcleaner3_9am
	 */
	public String getHdcleaner3_9am() {
		return hdcleaner3_9am;
	}
	/**
	 * @param hdcleaner3_9am the hdcleaner3_9am to set
	 */
	public void setHdcleaner3_9am(String hdcleaner3_9am) {
		this.hdcleaner3_9am = hdcleaner3_9am;
	}
	/**
	 * @return the hdcleaner3_1pm
	 */
	public String getHdcleaner3_1pm() {
		return hdcleaner3_1pm;
	}
	/**
	 * @param hdcleaner3_1pm the hdcleaner3_1pm to set
	 */
	public void setHdcleaner3_1pm(String hdcleaner3_1pm) {
		this.hdcleaner3_1pm = hdcleaner3_1pm;
	}
	/**
	 * @return the hdcleaner3_5pm
	 */
	public String getHdcleaner3_5pm() {
		return hdcleaner3_5pm;
	}
	/**
	 * @param hdcleaner3_5pm the hdcleaner3_5pm to set
	 */
	public void setHdcleaner3_5pm(String hdcleaner3_5pm) {
		this.hdcleaner3_5pm = hdcleaner3_5pm;
	}
	/**
	 * @return the hdcleaner3_9pm
	 */
	public String getHdcleaner3_9pm() {
		return hdcleaner3_9pm;
	}
	/**
	 * @param hdcleaner3_9pm the hdcleaner3_9pm to set
	 */
	public void setHdcleaner3_9pm(String hdcleaner3_9pm) {
		this.hdcleaner3_9pm = hdcleaner3_9pm;
	}
	/**
	 * @return the hdcleaner3_1am
	 */
	public String getHdcleaner3_1am() {
		return hdcleaner3_1am;
	}
	/**
	 * @param hdcleaner3_1am the hdcleaner3_1am to set
	 */
	public void setHdcleaner3_1am(String hdcleaner3_1am) {
		this.hdcleaner3_1am = hdcleaner3_1am;
	}
	/**
	 * @return the hdcleaner3_5am
	 */
	public String getHdcleaner3_5am() {
		return hdcleaner3_5am;
	}
	/**
	 * @param hdcleaner3_5am the hdcleaner3_5am to set
	 */
	public void setHdcleaner3_5am(String hdcleaner3_5am) {
		this.hdcleaner3_5am = hdcleaner3_5am;
	}
	/**
	 * @return the hdcleaner4_freq
	 */
	public String getHdcleaner4_freq() {
		return hdcleaner4_freq;
	}
	/**
	 * @param hdcleaner4_freq the hdcleaner4_freq to set
	 */
	public void setHdcleaner4_freq(String hdcleaner4_freq) {
		this.hdcleaner4_freq = hdcleaner4_freq;
	}
	/**
	 * @return the hdcleaner4_9am
	 */
	public String getHdcleaner4_9am() {
		return hdcleaner4_9am;
	}
	/**
	 * @param hdcleaner4_9am the hdcleaner4_9am to set
	 */
	public void setHdcleaner4_9am(String hdcleaner4_9am) {
		this.hdcleaner4_9am = hdcleaner4_9am;
	}
	/**
	 * @return the hdcleaner4_1pm
	 */
	public String getHdcleaner4_1pm() {
		return hdcleaner4_1pm;
	}
	/**
	 * @param hdcleaner4_1pm the hdcleaner4_1pm to set
	 */
	public void setHdcleaner4_1pm(String hdcleaner4_1pm) {
		this.hdcleaner4_1pm = hdcleaner4_1pm;
	}
	/**
	 * @return the hdcleaner4_5pm
	 */
	public String getHdcleaner4_5pm() {
		return hdcleaner4_5pm;
	}
	/**
	 * @param hdcleaner4_5pm the hdcleaner4_5pm to set
	 */
	public void setHdcleaner4_5pm(String hdcleaner4_5pm) {
		this.hdcleaner4_5pm = hdcleaner4_5pm;
	}
	/**
	 * @return the hdcleaner4_9pm
	 */
	public String getHdcleaner4_9pm() {
		return hdcleaner4_9pm;
	}
	/**
	 * @param hdcleaner4_9pm the hdcleaner4_9pm to set
	 */
	public void setHdcleaner4_9pm(String hdcleaner4_9pm) {
		this.hdcleaner4_9pm = hdcleaner4_9pm;
	}
	/**
	 * @return the hdcleaner4_1am
	 */
	public String getHdcleaner4_1am() {
		return hdcleaner4_1am;
	}
	/**
	 * @param hdcleaner4_1am the hdcleaner4_1am to set
	 */
	public void setHdcleaner4_1am(String hdcleaner4_1am) {
		this.hdcleaner4_1am = hdcleaner4_1am;
	}
	/**
	 * @return the hdcleaner4_5am
	 */
	public String getHdcleaner4_5am() {
		return hdcleaner4_5am;
	}
	/**
	 * @param hdcleaner4_5am the hdcleaner4_5am to set
	 */
	public void setHdcleaner4_5am(String hdcleaner4_5am) {
		this.hdcleaner4_5am = hdcleaner4_5am;
	}
	/**
	 * @return the hdcleanerb_freq
	 */
	public String getHdcleanerb_freq() {
		return hdcleanerb_freq;
	}
	/**
	 * @param hdcleanerb_freq the hdcleanerb_freq to set
	 */
	public void setHdcleanerb_freq(String hdcleanerb_freq) {
		this.hdcleanerb_freq = hdcleanerb_freq;
	}
	/**
	 * @return the hdcleanerb_9am
	 */
	public String getHdcleanerb_9am() {
		return hdcleanerb_9am;
	}
	/**
	 * @param hdcleanerb_9am the hdcleanerb_9am to set
	 */
	public void setHdcleanerb_9am(String hdcleanerb_9am) {
		this.hdcleanerb_9am = hdcleanerb_9am;
	}
	/**
	 * @return the hdcleanerb_1pm
	 */
	public String getHdcleanerb_1pm() {
		return hdcleanerb_1pm;
	}
	/**
	 * @param hdcleanerb_1pm the hdcleanerb_1pm to set
	 */
	public void setHdcleanerb_1pm(String hdcleanerb_1pm) {
		this.hdcleanerb_1pm = hdcleanerb_1pm;
	}
	/**
	 * @return the hdcleanerb_5pm
	 */
	public String getHdcleanerb_5pm() {
		return hdcleanerb_5pm;
	}
	/**
	 * @param hdcleanerb_5pm the hdcleanerb_5pm to set
	 */
	public void setHdcleanerb_5pm(String hdcleanerb_5pm) {
		this.hdcleanerb_5pm = hdcleanerb_5pm;
	}
	/**
	 * @return the hdcleanerb_9pm
	 */
	public String getHdcleanerb_9pm() {
		return hdcleanerb_9pm;
	}
	/**
	 * @param hdcleanerb_9pm the hdcleanerb_9pm to set
	 */
	public void setHdcleanerb_9pm(String hdcleanerb_9pm) {
		this.hdcleanerb_9pm = hdcleanerb_9pm;
	}
	/**
	 * @return the hdcleanerb_1am
	 */
	public String getHdcleanerb_1am() {
		return hdcleanerb_1am;
	}
	/**
	 * @param hdcleanerb_1am the hdcleanerb_1am to set
	 */
	public void setHdcleanerb_1am(String hdcleanerb_1am) {
		this.hdcleanerb_1am = hdcleanerb_1am;
	}
	/**
	 * @return the hdcleanerb_5am
	 */
	public String getHdcleanerb_5am() {
		return hdcleanerb_5am;
	}
	/**
	 * @param hdcleanerb_5am the hdcleanerb_5am to set
	 */
	public void setHdcleanerb_5am(String hdcleanerb_5am) {
		this.hdcleanerb_5am = hdcleanerb_5am;
	}
	/**
	 * @return the drumscreen1_freq
	 */
	public String getDrumscreen1_freq() {
		return drumscreen1_freq;
	}
	/**
	 * @param drumscreen1_freq the drumscreen1_freq to set
	 */
	public void setDrumscreen1_freq(String drumscreen1_freq) {
		this.drumscreen1_freq = drumscreen1_freq;
	}
	/**
	 * @return the drumscreen1_9am
	 */
	public String getDrumscreen1_9am() {
		return drumscreen1_9am;
	}
	/**
	 * @param drumscreen1_9am the drumscreen1_9am to set
	 */
	public void setDrumscreen1_9am(String drumscreen1_9am) {
		this.drumscreen1_9am = drumscreen1_9am;
	}
	/**
	 * @return the drumscreen1_1pm
	 */
	public String getDrumscreen1_1pm() {
		return drumscreen1_1pm;
	}
	/**
	 * @param drumscreen1_1pm the drumscreen1_1pm to set
	 */
	public void setDrumscreen1_1pm(String drumscreen1_1pm) {
		this.drumscreen1_1pm = drumscreen1_1pm;
	}
	/**
	 * @return the drumscreen1_5pm
	 */
	public String getDrumscreen1_5pm() {
		return drumscreen1_5pm;
	}
	/**
	 * @param drumscreen1_5pm the drumscreen1_5pm to set
	 */
	public void setDrumscreen1_5pm(String drumscreen1_5pm) {
		this.drumscreen1_5pm = drumscreen1_5pm;
	}
	/**
	 * @return the drumscreen1_9pm
	 */
	public String getDrumscreen1_9pm() {
		return drumscreen1_9pm;
	}
	/**
	 * @param drumscreen1_9pm the drumscreen1_9pm to set
	 */
	public void setDrumscreen1_9pm(String drumscreen1_9pm) {
		this.drumscreen1_9pm = drumscreen1_9pm;
	}
	/**
	 * @return the drumscreen1_1am
	 */
	public String getDrumscreen1_1am() {
		return drumscreen1_1am;
	}
	/**
	 * @param drumscreen1_1am the drumscreen1_1am to set
	 */
	public void setDrumscreen1_1am(String drumscreen1_1am) {
		this.drumscreen1_1am = drumscreen1_1am;
	}
	/**
	 * @return the drumscreen1_5am
	 */
	public String getDrumscreen1_5am() {
		return drumscreen1_5am;
	}
	/**
	 * @param drumscreen1_5am the drumscreen1_5am to set
	 */
	public void setDrumscreen1_5am(String drumscreen1_5am) {
		this.drumscreen1_5am = drumscreen1_5am;
	}
	/**
	 * @return the drumscreen2_freq
	 */
	public String getDrumscreen2_freq() {
		return drumscreen2_freq;
	}
	/**
	 * @param drumscreen2_freq the drumscreen2_freq to set
	 */
	public void setDrumscreen2_freq(String drumscreen2_freq) {
		this.drumscreen2_freq = drumscreen2_freq;
	}
	/**
	 * @return the drumscreen2_9am
	 */
	public String getDrumscreen2_9am() {
		return drumscreen2_9am;
	}
	/**
	 * @param drumscreen2_9am the drumscreen2_9am to set
	 */
	public void setDrumscreen2_9am(String drumscreen2_9am) {
		this.drumscreen2_9am = drumscreen2_9am;
	}
	/**
	 * @return the drumscreen2_1pm
	 */
	public String getDrumscreen2_1pm() {
		return drumscreen2_1pm;
	}
	/**
	 * @param drumscreen2_1pm the drumscreen2_1pm to set
	 */
	public void setDrumscreen2_1pm(String drumscreen2_1pm) {
		this.drumscreen2_1pm = drumscreen2_1pm;
	}
	/**
	 * @return the drumscreen2_5pm
	 */
	public String getDrumscreen2_5pm() {
		return drumscreen2_5pm;
	}
	/**
	 * @param drumscreen2_5pm the drumscreen2_5pm to set
	 */
	public void setDrumscreen2_5pm(String drumscreen2_5pm) {
		this.drumscreen2_5pm = drumscreen2_5pm;
	}
	/**
	 * @return the drumscreen2_9pm
	 */
	public String getDrumscreen2_9pm() {
		return drumscreen2_9pm;
	}
	/**
	 * @param drumscreen2_9pm the drumscreen2_9pm to set
	 */
	public void setDrumscreen2_9pm(String drumscreen2_9pm) {
		this.drumscreen2_9pm = drumscreen2_9pm;
	}
	/**
	 * @return the drumscreen2_1am
	 */
	public String getDrumscreen2_1am() {
		return drumscreen2_1am;
	}
	/**
	 * @param drumscreen2_1am the drumscreen2_1am to set
	 */
	public void setDrumscreen2_1am(String drumscreen2_1am) {
		this.drumscreen2_1am = drumscreen2_1am;
	}
	/**
	 * @return the drumscreen2_5am
	 */
	public String getDrumscreen2_5am() {
		return drumscreen2_5am;
	}
	/**
	 * @param drumscreen2_5am the drumscreen2_5am to set
	 */
	public void setDrumscreen2_5am(String drumscreen2_5am) {
		this.drumscreen2_5am = drumscreen2_5am;
	}
	/**
	 * @return the drumscreen3_freq
	 */
	public String getDrumscreen3_freq() {
		return drumscreen3_freq;
	}
	/**
	 * @param drumscreen3_freq the drumscreen3_freq to set
	 */
	public void setDrumscreen3_freq(String drumscreen3_freq) {
		this.drumscreen3_freq = drumscreen3_freq;
	}
	/**
	 * @return the drumscreen3_9am
	 */
	public String getDrumscreen3_9am() {
		return drumscreen3_9am;
	}
	/**
	 * @param drumscreen3_9am the drumscreen3_9am to set
	 */
	public void setDrumscreen3_9am(String drumscreen3_9am) {
		this.drumscreen3_9am = drumscreen3_9am;
	}
	/**
	 * @return the drumscreen3_1pm
	 */
	public String getDrumscreen3_1pm() {
		return drumscreen3_1pm;
	}
	/**
	 * @param drumscreen3_1pm the drumscreen3_1pm to set
	 */
	public void setDrumscreen3_1pm(String drumscreen3_1pm) {
		this.drumscreen3_1pm = drumscreen3_1pm;
	}
	/**
	 * @return the drumscreen3_5pm
	 */
	public String getDrumscreen3_5pm() {
		return drumscreen3_5pm;
	}
	/**
	 * @param drumscreen3_5pm the drumscreen3_5pm to set
	 */
	public void setDrumscreen3_5pm(String drumscreen3_5pm) {
		this.drumscreen3_5pm = drumscreen3_5pm;
	}
	/**
	 * @return the drumscreen3_9pm
	 */
	public String getDrumscreen3_9pm() {
		return drumscreen3_9pm;
	}
	/**
	 * @param drumscreen3_9pm the drumscreen3_9pm to set
	 */
	public void setDrumscreen3_9pm(String drumscreen3_9pm) {
		this.drumscreen3_9pm = drumscreen3_9pm;
	}
	/**
	 * @return the drumscreen3_1am
	 */
	public String getDrumscreen3_1am() {
		return drumscreen3_1am;
	}
	/**
	 * @param drumscreen3_1am the drumscreen3_1am to set
	 */
	public void setDrumscreen3_1am(String drumscreen3_1am) {
		this.drumscreen3_1am = drumscreen3_1am;
	}
	/**
	 * @return the drumscreen3_5am
	 */
	public String getDrumscreen3_5am() {
		return drumscreen3_5am;
	}
	/**
	 * @param drumscreen3_5am the drumscreen3_5am to set
	 */
	public void setDrumscreen3_5am(String drumscreen3_5am) {
		this.drumscreen3_5am = drumscreen3_5am;
	}
	/**
	 * @return the coarsescreens1_freq
	 */
	public String getCoarsescreens1_freq() {
		return coarsescreens1_freq;
	}
	/**
	 * @param coarsescreens1_freq the coarsescreens1_freq to set
	 */
	public void setCoarsescreens1_freq(String coarsescreens1_freq) {
		this.coarsescreens1_freq = coarsescreens1_freq;
	}
	/**
	 * @return the coarsescreens1_9am
	 */
	public String getCoarsescreens1_9am() {
		return coarsescreens1_9am;
	}
	/**
	 * @param coarsescreens1_9am the coarsescreens1_9am to set
	 */
	public void setCoarsescreens1_9am(String coarsescreens1_9am) {
		this.coarsescreens1_9am = coarsescreens1_9am;
	}
	/**
	 * @return the coarsescreens1_1pm
	 */
	public String getCoarsescreens1_1pm() {
		return coarsescreens1_1pm;
	}
	/**
	 * @param coarsescreens1_1pm the coarsescreens1_1pm to set
	 */
	public void setCoarsescreens1_1pm(String coarsescreens1_1pm) {
		this.coarsescreens1_1pm = coarsescreens1_1pm;
	}
	/**
	 * @return the coarsescreens1_5pm
	 */
	public String getCoarsescreens1_5pm() {
		return coarsescreens1_5pm;
	}
	/**
	 * @param coarsescreens1_5pm the coarsescreens1_5pm to set
	 */
	public void setCoarsescreens1_5pm(String coarsescreens1_5pm) {
		this.coarsescreens1_5pm = coarsescreens1_5pm;
	}
	/**
	 * @return the coarsescreens1_9pm
	 */
	public String getCoarsescreens1_9pm() {
		return coarsescreens1_9pm;
	}
	/**
	 * @param coarsescreens1_9pm the coarsescreens1_9pm to set
	 */
	public void setCoarsescreens1_9pm(String coarsescreens1_9pm) {
		this.coarsescreens1_9pm = coarsescreens1_9pm;
	}
	/**
	 * @return the coarsescreens1_1am
	 */
	public String getCoarsescreens1_1am() {
		return coarsescreens1_1am;
	}
	/**
	 * @param coarsescreens1_1am the coarsescreens1_1am to set
	 */
	public void setCoarsescreens1_1am(String coarsescreens1_1am) {
		this.coarsescreens1_1am = coarsescreens1_1am;
	}
	/**
	 * @return the coarsescreens1_5am
	 */
	public String getCoarsescreens1_5am() {
		return coarsescreens1_5am;
	}
	/**
	 * @param coarsescreens1_5am the coarsescreens1_5am to set
	 */
	public void setCoarsescreens1_5am(String coarsescreens1_5am) {
		this.coarsescreens1_5am = coarsescreens1_5am;
	}
	/**
	 * @return the coarsescreens2_freq
	 */
	public String getCoarsescreens2_freq() {
		return coarsescreens2_freq;
	}
	/**
	 * @param coarsescreens2_freq the coarsescreens2_freq to set
	 */
	public void setCoarsescreens2_freq(String coarsescreens2_freq) {
		this.coarsescreens2_freq = coarsescreens2_freq;
	}
	/**
	 * @return the coarsescreens2_9am
	 */
	public String getCoarsescreens2_9am() {
		return coarsescreens2_9am;
	}
	/**
	 * @param coarsescreens2_9am the coarsescreens2_9am to set
	 */
	public void setCoarsescreens2_9am(String coarsescreens2_9am) {
		this.coarsescreens2_9am = coarsescreens2_9am;
	}
	/**
	 * @return the coarsescreens2_1pm
	 */
	public String getCoarsescreens2_1pm() {
		return coarsescreens2_1pm;
	}
	/**
	 * @param coarsescreens2_1pm the coarsescreens2_1pm to set
	 */
	public void setCoarsescreens2_1pm(String coarsescreens2_1pm) {
		this.coarsescreens2_1pm = coarsescreens2_1pm;
	}
	/**
	 * @return the coarsescreens2_5pm
	 */
	public String getCoarsescreens2_5pm() {
		return coarsescreens2_5pm;
	}
	/**
	 * @param coarsescreens2_5pm the coarsescreens2_5pm to set
	 */
	public void setCoarsescreens2_5pm(String coarsescreens2_5pm) {
		this.coarsescreens2_5pm = coarsescreens2_5pm;
	}
	/**
	 * @return the coarsescreens2_9pm
	 */
	public String getCoarsescreens2_9pm() {
		return coarsescreens2_9pm;
	}
	/**
	 * @param coarsescreens2_9pm the coarsescreens2_9pm to set
	 */
	public void setCoarsescreens2_9pm(String coarsescreens2_9pm) {
		this.coarsescreens2_9pm = coarsescreens2_9pm;
	}
	/**
	 * @return the coarsescreens2_1am
	 */
	public String getCoarsescreens2_1am() {
		return coarsescreens2_1am;
	}
	/**
	 * @param coarsescreens2_1am the coarsescreens2_1am to set
	 */
	public void setCoarsescreens2_1am(String coarsescreens2_1am) {
		this.coarsescreens2_1am = coarsescreens2_1am;
	}
	/**
	 * @return the coarsescreens2_5am
	 */
	public String getCoarsescreens2_5am() {
		return coarsescreens2_5am;
	}
	/**
	 * @param coarsescreens2_5am the coarsescreens2_5am to set
	 */
	public void setCoarsescreens2_5am(String coarsescreens2_5am) {
		this.coarsescreens2_5am = coarsescreens2_5am;
	}
	/**
	 * @return the coarsescreens3_freq
	 */
	public String getCoarsescreens3_freq() {
		return coarsescreens3_freq;
	}
	/**
	 * @param coarsescreens3_freq the coarsescreens3_freq to set
	 */
	public void setCoarsescreens3_freq(String coarsescreens3_freq) {
		this.coarsescreens3_freq = coarsescreens3_freq;
	}
	/**
	 * @return the coarsescreens3_9am
	 */
	public String getCoarsescreens3_9am() {
		return coarsescreens3_9am;
	}
	/**
	 * @param coarsescreens3_9am the coarsescreens3_9am to set
	 */
	public void setCoarsescreens3_9am(String coarsescreens3_9am) {
		this.coarsescreens3_9am = coarsescreens3_9am;
	}
	/**
	 * @return the coarsescreens3_1pm
	 */
	public String getCoarsescreens3_1pm() {
		return coarsescreens3_1pm;
	}
	/**
	 * @param coarsescreens3_1pm the coarsescreens3_1pm to set
	 */
	public void setCoarsescreens3_1pm(String coarsescreens3_1pm) {
		this.coarsescreens3_1pm = coarsescreens3_1pm;
	}
	/**
	 * @return the coarsescreens3_5pm
	 */
	public String getCoarsescreens3_5pm() {
		return coarsescreens3_5pm;
	}
	/**
	 * @param coarsescreens3_5pm the coarsescreens3_5pm to set
	 */
	public void setCoarsescreens3_5pm(String coarsescreens3_5pm) {
		this.coarsescreens3_5pm = coarsescreens3_5pm;
	}
	/**
	 * @return the coarsescreens3_9pm
	 */
	public String getCoarsescreens3_9pm() {
		return coarsescreens3_9pm;
	}
	/**
	 * @param coarsescreens3_9pm the coarsescreens3_9pm to set
	 */
	public void setCoarsescreens3_9pm(String coarsescreens3_9pm) {
		this.coarsescreens3_9pm = coarsescreens3_9pm;
	}
	/**
	 * @return the coarsescreens3_1am
	 */
	public String getCoarsescreens3_1am() {
		return coarsescreens3_1am;
	}
	/**
	 * @param coarsescreens3_1am the coarsescreens3_1am to set
	 */
	public void setCoarsescreens3_1am(String coarsescreens3_1am) {
		this.coarsescreens3_1am = coarsescreens3_1am;
	}
	/**
	 * @return the coarsescreens3_5am
	 */
	public String getCoarsescreens3_5am() {
		return coarsescreens3_5am;
	}
	/**
	 * @param coarsescreens3_5am the coarsescreens3_5am to set
	 */
	public void setCoarsescreens3_5am(String coarsescreens3_5am) {
		this.coarsescreens3_5am = coarsescreens3_5am;
	}
	/**
	 * @return the coarsescreens4_freq
	 */
	public String getCoarsescreens4_freq() {
		return coarsescreens4_freq;
	}
	/**
	 * @param coarsescreens4_freq the coarsescreens4_freq to set
	 */
	public void setCoarsescreens4_freq(String coarsescreens4_freq) {
		this.coarsescreens4_freq = coarsescreens4_freq;
	}
	/**
	 * @return the coarsescreens4_9am
	 */
	public String getCoarsescreens4_9am() {
		return coarsescreens4_9am;
	}
	/**
	 * @param coarsescreens4_9am the coarsescreens4_9am to set
	 */
	public void setCoarsescreens4_9am(String coarsescreens4_9am) {
		this.coarsescreens4_9am = coarsescreens4_9am;
	}
	/**
	 * @return the coarsescreens4_1pm
	 */
	public String getCoarsescreens4_1pm() {
		return coarsescreens4_1pm;
	}
	/**
	 * @param coarsescreens4_1pm the coarsescreens4_1pm to set
	 */
	public void setCoarsescreens4_1pm(String coarsescreens4_1pm) {
		this.coarsescreens4_1pm = coarsescreens4_1pm;
	}
	/**
	 * @return the coarsescreens4_5pm
	 */
	public String getCoarsescreens4_5pm() {
		return coarsescreens4_5pm;
	}
	/**
	 * @param coarsescreens4_5pm the coarsescreens4_5pm to set
	 */
	public void setCoarsescreens4_5pm(String coarsescreens4_5pm) {
		this.coarsescreens4_5pm = coarsescreens4_5pm;
	}
	/**
	 * @return the coarsescreens4_9pm
	 */
	public String getCoarsescreens4_9pm() {
		return coarsescreens4_9pm;
	}
	/**
	 * @param coarsescreens4_9pm the coarsescreens4_9pm to set
	 */
	public void setCoarsescreens4_9pm(String coarsescreens4_9pm) {
		this.coarsescreens4_9pm = coarsescreens4_9pm;
	}
	/**
	 * @return the coarsescreens4_1am
	 */
	public String getCoarsescreens4_1am() {
		return coarsescreens4_1am;
	}
	/**
	 * @param coarsescreens4_1am the coarsescreens4_1am to set
	 */
	public void setCoarsescreens4_1am(String coarsescreens4_1am) {
		this.coarsescreens4_1am = coarsescreens4_1am;
	}
	/**
	 * @return the coarsescreens4_5am
	 */
	public String getCoarsescreens4_5am() {
		return coarsescreens4_5am;
	}
	/**
	 * @param coarsescreens4_5am the coarsescreens4_5am to set
	 */
	public void setCoarsescreens4_5am(String coarsescreens4_5am) {
		this.coarsescreens4_5am = coarsescreens4_5am;
	}
	/**
	 * @return the coarsescreens5_freq
	 */
	public String getCoarsescreens5_freq() {
		return coarsescreens5_freq;
	}
	/**
	 * @param coarsescreens5_freq the coarsescreens5_freq to set
	 */
	public void setCoarsescreens5_freq(String coarsescreens5_freq) {
		this.coarsescreens5_freq = coarsescreens5_freq;
	}
	/**
	 * @return the coarsescreens5_9am
	 */
	public String getCoarsescreens5_9am() {
		return coarsescreens5_9am;
	}
	/**
	 * @param coarsescreens5_9am the coarsescreens5_9am to set
	 */
	public void setCoarsescreens5_9am(String coarsescreens5_9am) {
		this.coarsescreens5_9am = coarsescreens5_9am;
	}
	/**
	 * @return the coarsescreens5_1pm
	 */
	public String getCoarsescreens5_1pm() {
		return coarsescreens5_1pm;
	}
	/**
	 * @param coarsescreens5_1pm the coarsescreens5_1pm to set
	 */
	public void setCoarsescreens5_1pm(String coarsescreens5_1pm) {
		this.coarsescreens5_1pm = coarsescreens5_1pm;
	}
	/**
	 * @return the coarsescreens5_5pm
	 */
	public String getCoarsescreens5_5pm() {
		return coarsescreens5_5pm;
	}
	/**
	 * @param coarsescreens5_5pm the coarsescreens5_5pm to set
	 */
	public void setCoarsescreens5_5pm(String coarsescreens5_5pm) {
		this.coarsescreens5_5pm = coarsescreens5_5pm;
	}
	/**
	 * @return the coarsescreens5_9pm
	 */
	public String getCoarsescreens5_9pm() {
		return coarsescreens5_9pm;
	}
	/**
	 * @param coarsescreens5_9pm the coarsescreens5_9pm to set
	 */
	public void setCoarsescreens5_9pm(String coarsescreens5_9pm) {
		this.coarsescreens5_9pm = coarsescreens5_9pm;
	}
	/**
	 * @return the coarsescreens5_1am
	 */
	public String getCoarsescreens5_1am() {
		return coarsescreens5_1am;
	}
	/**
	 * @param coarsescreens5_1am the coarsescreens5_1am to set
	 */
	public void setCoarsescreens5_1am(String coarsescreens5_1am) {
		this.coarsescreens5_1am = coarsescreens5_1am;
	}
	/**
	 * @return the coarsescreens5_5am
	 */
	public String getCoarsescreens5_5am() {
		return coarsescreens5_5am;
	}
	/**
	 * @param coarsescreens5_5am the coarsescreens5_5am to set
	 */
	public void setCoarsescreens5_5am(String coarsescreens5_5am) {
		this.coarsescreens5_5am = coarsescreens5_5am;
	}
	/**
	 * @return the coarsescreens6_freq
	 */
	public String getCoarsescreens6_freq() {
		return coarsescreens6_freq;
	}
	/**
	 * @param coarsescreens6_freq the coarsescreens6_freq to set
	 */
	public void setCoarsescreens6_freq(String coarsescreens6_freq) {
		this.coarsescreens6_freq = coarsescreens6_freq;
	}
	/**
	 * @return the coarsescreens6_9am
	 */
	public String getCoarsescreens6_9am() {
		return coarsescreens6_9am;
	}
	/**
	 * @param coarsescreens6_9am the coarsescreens6_9am to set
	 */
	public void setCoarsescreens6_9am(String coarsescreens6_9am) {
		this.coarsescreens6_9am = coarsescreens6_9am;
	}
	/**
	 * @return the coarsescreens6_1pm
	 */
	public String getCoarsescreens6_1pm() {
		return coarsescreens6_1pm;
	}
	/**
	 * @param coarsescreens6_1pm the coarsescreens6_1pm to set
	 */
	public void setCoarsescreens6_1pm(String coarsescreens6_1pm) {
		this.coarsescreens6_1pm = coarsescreens6_1pm;
	}
	/**
	 * @return the coarsescreens6_5pm
	 */
	public String getCoarsescreens6_5pm() {
		return coarsescreens6_5pm;
	}
	/**
	 * @param coarsescreens6_5pm the coarsescreens6_5pm to set
	 */
	public void setCoarsescreens6_5pm(String coarsescreens6_5pm) {
		this.coarsescreens6_5pm = coarsescreens6_5pm;
	}
	/**
	 * @return the coarsescreens6_9pm
	 */
	public String getCoarsescreens6_9pm() {
		return coarsescreens6_9pm;
	}
	/**
	 * @param coarsescreens6_9pm the coarsescreens6_9pm to set
	 */
	public void setCoarsescreens6_9pm(String coarsescreens6_9pm) {
		this.coarsescreens6_9pm = coarsescreens6_9pm;
	}
	/**
	 * @return the coarsescreens6_1am
	 */
	public String getCoarsescreens6_1am() {
		return coarsescreens6_1am;
	}
	/**
	 * @param coarsescreens6_1am the coarsescreens6_1am to set
	 */
	public void setCoarsescreens6_1am(String coarsescreens6_1am) {
		this.coarsescreens6_1am = coarsescreens6_1am;
	}
	/**
	 * @return the coarsescreens6_5am
	 */
	public String getCoarsescreens6_5am() {
		return coarsescreens6_5am;
	}
	/**
	 * @param coarsescreens6_5am the coarsescreens6_5am to set
	 */
	public void setCoarsescreens6_5am(String coarsescreens6_5am) {
		this.coarsescreens6_5am = coarsescreens6_5am;
	}
	/**
	 * @return the coarsescreens7_freq
	 */
	public String getCoarsescreens7_freq() {
		return coarsescreens7_freq;
	}
	/**
	 * @param coarsescreens7_freq the coarsescreens7_freq to set
	 */
	public void setCoarsescreens7_freq(String coarsescreens7_freq) {
		this.coarsescreens7_freq = coarsescreens7_freq;
	}
	/**
	 * @return the coarsescreens7_9am
	 */
	public String getCoarsescreens7_9am() {
		return coarsescreens7_9am;
	}
	/**
	 * @param coarsescreens7_9am the coarsescreens7_9am to set
	 */
	public void setCoarsescreens7_9am(String coarsescreens7_9am) {
		this.coarsescreens7_9am = coarsescreens7_9am;
	}
	/**
	 * @return the coarsescreens7_1pm
	 */
	public String getCoarsescreens7_1pm() {
		return coarsescreens7_1pm;
	}
	/**
	 * @param coarsescreens7_1pm the coarsescreens7_1pm to set
	 */
	public void setCoarsescreens7_1pm(String coarsescreens7_1pm) {
		this.coarsescreens7_1pm = coarsescreens7_1pm;
	}
	/**
	 * @return the coarsescreens7_5pm
	 */
	public String getCoarsescreens7_5pm() {
		return coarsescreens7_5pm;
	}
	/**
	 * @param coarsescreens7_5pm the coarsescreens7_5pm to set
	 */
	public void setCoarsescreens7_5pm(String coarsescreens7_5pm) {
		this.coarsescreens7_5pm = coarsescreens7_5pm;
	}
	/**
	 * @return the coarsescreens7_9pm
	 */
	public String getCoarsescreens7_9pm() {
		return coarsescreens7_9pm;
	}
	/**
	 * @param coarsescreens7_9pm the coarsescreens7_9pm to set
	 */
	public void setCoarsescreens7_9pm(String coarsescreens7_9pm) {
		this.coarsescreens7_9pm = coarsescreens7_9pm;
	}
	/**
	 * @return the coarsescreens7_1am
	 */
	public String getCoarsescreens7_1am() {
		return coarsescreens7_1am;
	}
	/**
	 * @param coarsescreens7_1am the coarsescreens7_1am to set
	 */
	public void setCoarsescreens7_1am(String coarsescreens7_1am) {
		this.coarsescreens7_1am = coarsescreens7_1am;
	}
	/**
	 * @return the coarsescreens7_5am
	 */
	public String getCoarsescreens7_5am() {
		return coarsescreens7_5am;
	}
	/**
	 * @param coarsescreens7_5am the coarsescreens7_5am to set
	 */
	public void setCoarsescreens7_5am(String coarsescreens7_5am) {
		this.coarsescreens7_5am = coarsescreens7_5am;
	}
	/**
	 * @return the finescreens1_freq
	 */
	public String getFinescreens1_freq() {
		return finescreens1_freq;
	}
	/**
	 * @param finescreens1_freq the finescreens1_freq to set
	 */
	public void setFinescreens1_freq(String finescreens1_freq) {
		this.finescreens1_freq = finescreens1_freq;
	}
	/**
	 * @return the finescreens1_9am
	 */
	public String getFinescreens1_9am() {
		return finescreens1_9am;
	}
	/**
	 * @param finescreens1_9am the finescreens1_9am to set
	 */
	public void setFinescreens1_9am(String finescreens1_9am) {
		this.finescreens1_9am = finescreens1_9am;
	}
	/**
	 * @return the finescreens1_1pm
	 */
	public String getFinescreens1_1pm() {
		return finescreens1_1pm;
	}
	/**
	 * @param finescreens1_1pm the finescreens1_1pm to set
	 */
	public void setFinescreens1_1pm(String finescreens1_1pm) {
		this.finescreens1_1pm = finescreens1_1pm;
	}
	/**
	 * @return the finescreens1_5pm
	 */
	public String getFinescreens1_5pm() {
		return finescreens1_5pm;
	}
	/**
	 * @param finescreens1_5pm the finescreens1_5pm to set
	 */
	public void setFinescreens1_5pm(String finescreens1_5pm) {
		this.finescreens1_5pm = finescreens1_5pm;
	}
	/**
	 * @return the finescreens1_9pm
	 */
	public String getFinescreens1_9pm() {
		return finescreens1_9pm;
	}
	/**
	 * @param finescreens1_9pm the finescreens1_9pm to set
	 */
	public void setFinescreens1_9pm(String finescreens1_9pm) {
		this.finescreens1_9pm = finescreens1_9pm;
	}
	/**
	 * @return the finescreens1_1am
	 */
	public String getFinescreens1_1am() {
		return finescreens1_1am;
	}
	/**
	 * @param finescreens1_1am the finescreens1_1am to set
	 */
	public void setFinescreens1_1am(String finescreens1_1am) {
		this.finescreens1_1am = finescreens1_1am;
	}
	/**
	 * @return the finescreens1_5am
	 */
	public String getFinescreens1_5am() {
		return finescreens1_5am;
	}
	/**
	 * @param finescreens1_5am the finescreens1_5am to set
	 */
	public void setFinescreens1_5am(String finescreens1_5am) {
		this.finescreens1_5am = finescreens1_5am;
	}
	/**
	 * @return the finescreens2_freq
	 */
	public String getFinescreens2_freq() {
		return finescreens2_freq;
	}
	/**
	 * @param finescreens2_freq the finescreens2_freq to set
	 */
	public void setFinescreens2_freq(String finescreens2_freq) {
		this.finescreens2_freq = finescreens2_freq;
	}
	/**
	 * @return the finescreens2_9am
	 */
	public String getFinescreens2_9am() {
		return finescreens2_9am;
	}
	/**
	 * @param finescreens2_9am the finescreens2_9am to set
	 */
	public void setFinescreens2_9am(String finescreens2_9am) {
		this.finescreens2_9am = finescreens2_9am;
	}
	/**
	 * @return the finescreens2_1pm
	 */
	public String getFinescreens2_1pm() {
		return finescreens2_1pm;
	}
	/**
	 * @param finescreens2_1pm the finescreens2_1pm to set
	 */
	public void setFinescreens2_1pm(String finescreens2_1pm) {
		this.finescreens2_1pm = finescreens2_1pm;
	}
	/**
	 * @return the finescreens2_5pm
	 */
	public String getFinescreens2_5pm() {
		return finescreens2_5pm;
	}
	/**
	 * @param finescreens2_5pm the finescreens2_5pm to set
	 */
	public void setFinescreens2_5pm(String finescreens2_5pm) {
		this.finescreens2_5pm = finescreens2_5pm;
	}
	/**
	 * @return the finescreens2_9pm
	 */
	public String getFinescreens2_9pm() {
		return finescreens2_9pm;
	}
	/**
	 * @param finescreens2_9pm the finescreens2_9pm to set
	 */
	public void setFinescreens2_9pm(String finescreens2_9pm) {
		this.finescreens2_9pm = finescreens2_9pm;
	}
	/**
	 * @return the finescreens2_1am
	 */
	public String getFinescreens2_1am() {
		return finescreens2_1am;
	}
	/**
	 * @param finescreens2_1am the finescreens2_1am to set
	 */
	public void setFinescreens2_1am(String finescreens2_1am) {
		this.finescreens2_1am = finescreens2_1am;
	}
	/**
	 * @return the finescreens2_5am
	 */
	public String getFinescreens2_5am() {
		return finescreens2_5am;
	}
	/**
	 * @param finescreens2_5am the finescreens2_5am to set
	 */
	public void setFinescreens2_5am(String finescreens2_5am) {
		this.finescreens2_5am = finescreens2_5am;
	}
	/**
	 * @return the finescreens3_freq
	 */
	public String getFinescreens3_freq() {
		return finescreens3_freq;
	}
	/**
	 * @param finescreens3_freq the finescreens3_freq to set
	 */
	public void setFinescreens3_freq(String finescreens3_freq) {
		this.finescreens3_freq = finescreens3_freq;
	}
	/**
	 * @return the finescreens3_9am
	 */
	public String getFinescreens3_9am() {
		return finescreens3_9am;
	}
	/**
	 * @param finescreens3_9am the finescreens3_9am to set
	 */
	public void setFinescreens3_9am(String finescreens3_9am) {
		this.finescreens3_9am = finescreens3_9am;
	}
	/**
	 * @return the finescreens3_1pm
	 */
	public String getFinescreens3_1pm() {
		return finescreens3_1pm;
	}
	/**
	 * @param finescreens3_1pm the finescreens3_1pm to set
	 */
	public void setFinescreens3_1pm(String finescreens3_1pm) {
		this.finescreens3_1pm = finescreens3_1pm;
	}
	/**
	 * @return the finescreens3_5pm
	 */
	public String getFinescreens3_5pm() {
		return finescreens3_5pm;
	}
	/**
	 * @param finescreens3_5pm the finescreens3_5pm to set
	 */
	public void setFinescreens3_5pm(String finescreens3_5pm) {
		this.finescreens3_5pm = finescreens3_5pm;
	}
	/**
	 * @return the finescreens3_9pm
	 */
	public String getFinescreens3_9pm() {
		return finescreens3_9pm;
	}
	/**
	 * @param finescreens3_9pm the finescreens3_9pm to set
	 */
	public void setFinescreens3_9pm(String finescreens3_9pm) {
		this.finescreens3_9pm = finescreens3_9pm;
	}
	/**
	 * @return the finescreens3_1am
	 */
	public String getFinescreens3_1am() {
		return finescreens3_1am;
	}
	/**
	 * @param finescreens3_1am the finescreens3_1am to set
	 */
	public void setFinescreens3_1am(String finescreens3_1am) {
		this.finescreens3_1am = finescreens3_1am;
	}
	/**
	 * @return the finescreens3_5am
	 */
	public String getFinescreens3_5am() {
		return finescreens3_5am;
	}
	/**
	 * @param finescreens3_5am the finescreens3_5am to set
	 */
	public void setFinescreens3_5am(String finescreens3_5am) {
		this.finescreens3_5am = finescreens3_5am;
	}
	/**
	 * @return the finescreens4_freq
	 */
	public String getFinescreens4_freq() {
		return finescreens4_freq;
	}
	/**
	 * @param finescreens4_freq the finescreens4_freq to set
	 */
	public void setFinescreens4_freq(String finescreens4_freq) {
		this.finescreens4_freq = finescreens4_freq;
	}
	/**
	 * @return the finescreens4_9am
	 */
	public String getFinescreens4_9am() {
		return finescreens4_9am;
	}
	/**
	 * @param finescreens4_9am the finescreens4_9am to set
	 */
	public void setFinescreens4_9am(String finescreens4_9am) {
		this.finescreens4_9am = finescreens4_9am;
	}
	/**
	 * @return the finescreens4_1pm
	 */
	public String getFinescreens4_1pm() {
		return finescreens4_1pm;
	}
	/**
	 * @param finescreens4_1pm the finescreens4_1pm to set
	 */
	public void setFinescreens4_1pm(String finescreens4_1pm) {
		this.finescreens4_1pm = finescreens4_1pm;
	}
	/**
	 * @return the finescreens4_5pm
	 */
	public String getFinescreens4_5pm() {
		return finescreens4_5pm;
	}
	/**
	 * @param finescreens4_5pm the finescreens4_5pm to set
	 */
	public void setFinescreens4_5pm(String finescreens4_5pm) {
		this.finescreens4_5pm = finescreens4_5pm;
	}
	/**
	 * @return the finescreens4_9pm
	 */
	public String getFinescreens4_9pm() {
		return finescreens4_9pm;
	}
	/**
	 * @param finescreens4_9pm the finescreens4_9pm to set
	 */
	public void setFinescreens4_9pm(String finescreens4_9pm) {
		this.finescreens4_9pm = finescreens4_9pm;
	}
	/**
	 * @return the finescreens4_1am
	 */
	public String getFinescreens4_1am() {
		return finescreens4_1am;
	}
	/**
	 * @param finescreens4_1am the finescreens4_1am to set
	 */
	public void setFinescreens4_1am(String finescreens4_1am) {
		this.finescreens4_1am = finescreens4_1am;
	}
	/**
	 * @return the finescreens4_5am
	 */
	public String getFinescreens4_5am() {
		return finescreens4_5am;
	}
	/**
	 * @param finescreens4_5am the finescreens4_5am to set
	 */
	public void setFinescreens4_5am(String finescreens4_5am) {
		this.finescreens4_5am = finescreens4_5am;
	}
	/**
	 * @return the finescreens5_freq
	 */
	public String getFinescreens5_freq() {
		return finescreens5_freq;
	}
	/**
	 * @param finescreens5_freq the finescreens5_freq to set
	 */
	public void setFinescreens5_freq(String finescreens5_freq) {
		this.finescreens5_freq = finescreens5_freq;
	}
	/**
	 * @return the finescreens5_9am
	 */
	public String getFinescreens5_9am() {
		return finescreens5_9am;
	}
	/**
	 * @param finescreens5_9am the finescreens5_9am to set
	 */
	public void setFinescreens5_9am(String finescreens5_9am) {
		this.finescreens5_9am = finescreens5_9am;
	}
	/**
	 * @return the finescreens5_1pm
	 */
	public String getFinescreens5_1pm() {
		return finescreens5_1pm;
	}
	/**
	 * @param finescreens5_1pm the finescreens5_1pm to set
	 */
	public void setFinescreens5_1pm(String finescreens5_1pm) {
		this.finescreens5_1pm = finescreens5_1pm;
	}
	/**
	 * @return the finescreens5_5pm
	 */
	public String getFinescreens5_5pm() {
		return finescreens5_5pm;
	}
	/**
	 * @param finescreens5_5pm the finescreens5_5pm to set
	 */
	public void setFinescreens5_5pm(String finescreens5_5pm) {
		this.finescreens5_5pm = finescreens5_5pm;
	}
	/**
	 * @return the finescreens5_9pm
	 */
	public String getFinescreens5_9pm() {
		return finescreens5_9pm;
	}
	/**
	 * @param finescreens5_9pm the finescreens5_9pm to set
	 */
	public void setFinescreens5_9pm(String finescreens5_9pm) {
		this.finescreens5_9pm = finescreens5_9pm;
	}
	/**
	 * @return the finescreens5_1am
	 */
	public String getFinescreens5_1am() {
		return finescreens5_1am;
	}
	/**
	 * @param finescreens5_1am the finescreens5_1am to set
	 */
	public void setFinescreens5_1am(String finescreens5_1am) {
		this.finescreens5_1am = finescreens5_1am;
	}
	/**
	 * @return the finescreens5_5am
	 */
	public String getFinescreens5_5am() {
		return finescreens5_5am;
	}
	/**
	 * @param finescreens5_5am the finescreens5_5am to set
	 */
	public void setFinescreens5_5am(String finescreens5_5am) {
		this.finescreens5_5am = finescreens5_5am;
	}
	/**
	 * @return the finescreens6_freq
	 */
	public String getFinescreens6_freq() {
		return finescreens6_freq;
	}
	/**
	 * @param finescreens6_freq the finescreens6_freq to set
	 */
	public void setFinescreens6_freq(String finescreens6_freq) {
		this.finescreens6_freq = finescreens6_freq;
	}
	/**
	 * @return the finescreens6_9am
	 */
	public String getFinescreens6_9am() {
		return finescreens6_9am;
	}
	/**
	 * @param finescreens6_9am the finescreens6_9am to set
	 */
	public void setFinescreens6_9am(String finescreens6_9am) {
		this.finescreens6_9am = finescreens6_9am;
	}
	/**
	 * @return the finescreens6_1pm
	 */
	public String getFinescreens6_1pm() {
		return finescreens6_1pm;
	}
	/**
	 * @param finescreens6_1pm the finescreens6_1pm to set
	 */
	public void setFinescreens6_1pm(String finescreens6_1pm) {
		this.finescreens6_1pm = finescreens6_1pm;
	}
	/**
	 * @return the finescreens6_5pm
	 */
	public String getFinescreens6_5pm() {
		return finescreens6_5pm;
	}
	/**
	 * @param finescreens6_5pm the finescreens6_5pm to set
	 */
	public void setFinescreens6_5pm(String finescreens6_5pm) {
		this.finescreens6_5pm = finescreens6_5pm;
	}
	/**
	 * @return the finescreens6_9pm
	 */
	public String getFinescreens6_9pm() {
		return finescreens6_9pm;
	}
	/**
	 * @param finescreens6_9pm the finescreens6_9pm to set
	 */
	public void setFinescreens6_9pm(String finescreens6_9pm) {
		this.finescreens6_9pm = finescreens6_9pm;
	}
	/**
	 * @return the finescreens6_1am
	 */
	public String getFinescreens6_1am() {
		return finescreens6_1am;
	}
	/**
	 * @param finescreens6_1am the finescreens6_1am to set
	 */
	public void setFinescreens6_1am(String finescreens6_1am) {
		this.finescreens6_1am = finescreens6_1am;
	}
	/**
	 * @return the finescreens6_5am
	 */
	public String getFinescreens6_5am() {
		return finescreens6_5am;
	}
	/**
	 * @param finescreens6_5am the finescreens6_5am to set
	 */
	public void setFinescreens6_5am(String finescreens6_5am) {
		this.finescreens6_5am = finescreens6_5am;
	}
	/**
	 * @return the showerpumps1_freq
	 */
	public String getShowerpumps1_freq() {
		return showerpumps1_freq;
	}
	/**
	 * @param showerpumps1_freq the showerpumps1_freq to set
	 */
	public void setShowerpumps1_freq(String showerpumps1_freq) {
		this.showerpumps1_freq = showerpumps1_freq;
	}
	/**
	 * @return the showerpumps1_9am
	 */
	public String getShowerpumps1_9am() {
		return showerpumps1_9am;
	}
	/**
	 * @param showerpumps1_9am the showerpumps1_9am to set
	 */
	public void setShowerpumps1_9am(String showerpumps1_9am) {
		this.showerpumps1_9am = showerpumps1_9am;
	}
	/**
	 * @return the showerpumps1_1pm
	 */
	public String getShowerpumps1_1pm() {
		return showerpumps1_1pm;
	}
	/**
	 * @param showerpumps1_1pm the showerpumps1_1pm to set
	 */
	public void setShowerpumps1_1pm(String showerpumps1_1pm) {
		this.showerpumps1_1pm = showerpumps1_1pm;
	}
	/**
	 * @return the showerpumps1_5pm
	 */
	public String getShowerpumps1_5pm() {
		return showerpumps1_5pm;
	}
	/**
	 * @param showerpumps1_5pm the showerpumps1_5pm to set
	 */
	public void setShowerpumps1_5pm(String showerpumps1_5pm) {
		this.showerpumps1_5pm = showerpumps1_5pm;
	}
	/**
	 * @return the showerpumps1_9pm
	 */
	public String getShowerpumps1_9pm() {
		return showerpumps1_9pm;
	}
	/**
	 * @param showerpumps1_9pm the showerpumps1_9pm to set
	 */
	public void setShowerpumps1_9pm(String showerpumps1_9pm) {
		this.showerpumps1_9pm = showerpumps1_9pm;
	}
	/**
	 * @return the showerpumps1_1am
	 */
	public String getShowerpumps1_1am() {
		return showerpumps1_1am;
	}
	/**
	 * @param showerpumps1_1am the showerpumps1_1am to set
	 */
	public void setShowerpumps1_1am(String showerpumps1_1am) {
		this.showerpumps1_1am = showerpumps1_1am;
	}
	/**
	 * @return the showerpumps1_5am
	 */
	public String getShowerpumps1_5am() {
		return showerpumps1_5am;
	}
	/**
	 * @param showerpumps1_5am the showerpumps1_5am to set
	 */
	public void setShowerpumps1_5am(String showerpumps1_5am) {
		this.showerpumps1_5am = showerpumps1_5am;
	}
	/**
	 * @return the showerpumps2_freq
	 */
	public String getShowerpumps2_freq() {
		return showerpumps2_freq;
	}
	/**
	 * @param showerpumps2_freq the showerpumps2_freq to set
	 */
	public void setShowerpumps2_freq(String showerpumps2_freq) {
		this.showerpumps2_freq = showerpumps2_freq;
	}
	/**
	 * @return the showerpumps2_9am
	 */
	public String getShowerpumps2_9am() {
		return showerpumps2_9am;
	}
	/**
	 * @param showerpumps2_9am the showerpumps2_9am to set
	 */
	public void setShowerpumps2_9am(String showerpumps2_9am) {
		this.showerpumps2_9am = showerpumps2_9am;
	}
	/**
	 * @return the showerpumps2_1pm
	 */
	public String getShowerpumps2_1pm() {
		return showerpumps2_1pm;
	}
	/**
	 * @param showerpumps2_1pm the showerpumps2_1pm to set
	 */
	public void setShowerpumps2_1pm(String showerpumps2_1pm) {
		this.showerpumps2_1pm = showerpumps2_1pm;
	}
	/**
	 * @return the showerpumps2_5pm
	 */
	public String getShowerpumps2_5pm() {
		return showerpumps2_5pm;
	}
	/**
	 * @param showerpumps2_5pm the showerpumps2_5pm to set
	 */
	public void setShowerpumps2_5pm(String showerpumps2_5pm) {
		this.showerpumps2_5pm = showerpumps2_5pm;
	}
	/**
	 * @return the showerpumps2_9pm
	 */
	public String getShowerpumps2_9pm() {
		return showerpumps2_9pm;
	}
	/**
	 * @param showerpumps2_9pm the showerpumps2_9pm to set
	 */
	public void setShowerpumps2_9pm(String showerpumps2_9pm) {
		this.showerpumps2_9pm = showerpumps2_9pm;
	}
	/**
	 * @return the showerpumps2_1am
	 */
	public String getShowerpumps2_1am() {
		return showerpumps2_1am;
	}
	/**
	 * @param showerpumps2_1am the showerpumps2_1am to set
	 */
	public void setShowerpumps2_1am(String showerpumps2_1am) {
		this.showerpumps2_1am = showerpumps2_1am;
	}
	/**
	 * @return the showerpumps2_5am
	 */
	public String getShowerpumps2_5am() {
		return showerpumps2_5am;
	}
	/**
	 * @param showerpumps2_5am the showerpumps2_5am to set
	 */
	public void setShowerpumps2_5am(String showerpumps2_5am) {
		this.showerpumps2_5am = showerpumps2_5am;
	}
	/**
	 * @return the deckerfeedpump1_freq
	 */
	public String getDeckerfeedpump1_freq() {
		return deckerfeedpump1_freq;
	}
	/**
	 * @param deckerfeedpump1_freq the deckerfeedpump1_freq to set
	 */
	public void setDeckerfeedpump1_freq(String deckerfeedpump1_freq) {
		this.deckerfeedpump1_freq = deckerfeedpump1_freq;
	}
	/**
	 * @return the deckerfeedpump1_9am
	 */
	public String getDeckerfeedpump1_9am() {
		return deckerfeedpump1_9am;
	}
	/**
	 * @param deckerfeedpump1_9am the deckerfeedpump1_9am to set
	 */
	public void setDeckerfeedpump1_9am(String deckerfeedpump1_9am) {
		this.deckerfeedpump1_9am = deckerfeedpump1_9am;
	}
	/**
	 * @return the deckerfeedpump1_1pm
	 */
	public String getDeckerfeedpump1_1pm() {
		return deckerfeedpump1_1pm;
	}
	/**
	 * @param deckerfeedpump1_1pm the deckerfeedpump1_1pm to set
	 */
	public void setDeckerfeedpump1_1pm(String deckerfeedpump1_1pm) {
		this.deckerfeedpump1_1pm = deckerfeedpump1_1pm;
	}
	/**
	 * @return the deckerfeedpump1_5pm
	 */
	public String getDeckerfeedpump1_5pm() {
		return deckerfeedpump1_5pm;
	}
	/**
	 * @param deckerfeedpump1_5pm the deckerfeedpump1_5pm to set
	 */
	public void setDeckerfeedpump1_5pm(String deckerfeedpump1_5pm) {
		this.deckerfeedpump1_5pm = deckerfeedpump1_5pm;
	}
	/**
	 * @return the deckerfeedpump1_9pm
	 */
	public String getDeckerfeedpump1_9pm() {
		return deckerfeedpump1_9pm;
	}
	/**
	 * @param deckerfeedpump1_9pm the deckerfeedpump1_9pm to set
	 */
	public void setDeckerfeedpump1_9pm(String deckerfeedpump1_9pm) {
		this.deckerfeedpump1_9pm = deckerfeedpump1_9pm;
	}
	/**
	 * @return the deckerfeedpump1_1am
	 */
	public String getDeckerfeedpump1_1am() {
		return deckerfeedpump1_1am;
	}
	/**
	 * @param deckerfeedpump1_1am the deckerfeedpump1_1am to set
	 */
	public void setDeckerfeedpump1_1am(String deckerfeedpump1_1am) {
		this.deckerfeedpump1_1am = deckerfeedpump1_1am;
	}
	/**
	 * @return the deckerfeedpump1_5am
	 */
	public String getDeckerfeedpump1_5am() {
		return deckerfeedpump1_5am;
	}
	/**
	 * @param deckerfeedpump1_5am the deckerfeedpump1_5am to set
	 */
	public void setDeckerfeedpump1_5am(String deckerfeedpump1_5am) {
		this.deckerfeedpump1_5am = deckerfeedpump1_5am;
	}
	/**
	 * @return the deckerfeedpump2_freq
	 */
	public String getDeckerfeedpump2_freq() {
		return deckerfeedpump2_freq;
	}
	/**
	 * @param deckerfeedpump2_freq the deckerfeedpump2_freq to set
	 */
	public void setDeckerfeedpump2_freq(String deckerfeedpump2_freq) {
		this.deckerfeedpump2_freq = deckerfeedpump2_freq;
	}
	/**
	 * @return the deckerfeedpump2_9am
	 */
	public String getDeckerfeedpump2_9am() {
		return deckerfeedpump2_9am;
	}
	/**
	 * @param deckerfeedpump2_9am the deckerfeedpump2_9am to set
	 */
	public void setDeckerfeedpump2_9am(String deckerfeedpump2_9am) {
		this.deckerfeedpump2_9am = deckerfeedpump2_9am;
	}
	/**
	 * @return the deckerfeedpump2_1pm
	 */
	public String getDeckerfeedpump2_1pm() {
		return deckerfeedpump2_1pm;
	}
	/**
	 * @param deckerfeedpump2_1pm the deckerfeedpump2_1pm to set
	 */
	public void setDeckerfeedpump2_1pm(String deckerfeedpump2_1pm) {
		this.deckerfeedpump2_1pm = deckerfeedpump2_1pm;
	}
	/**
	 * @return the deckerfeedpump2_5pm
	 */
	public String getDeckerfeedpump2_5pm() {
		return deckerfeedpump2_5pm;
	}
	/**
	 * @param deckerfeedpump2_5pm the deckerfeedpump2_5pm to set
	 */
	public void setDeckerfeedpump2_5pm(String deckerfeedpump2_5pm) {
		this.deckerfeedpump2_5pm = deckerfeedpump2_5pm;
	}
	/**
	 * @return the deckerfeedpump2_9pm
	 */
	public String getDeckerfeedpump2_9pm() {
		return deckerfeedpump2_9pm;
	}
	/**
	 * @param deckerfeedpump2_9pm the deckerfeedpump2_9pm to set
	 */
	public void setDeckerfeedpump2_9pm(String deckerfeedpump2_9pm) {
		this.deckerfeedpump2_9pm = deckerfeedpump2_9pm;
	}
	/**
	 * @return the deckerfeedpump2_1am
	 */
	public String getDeckerfeedpump2_1am() {
		return deckerfeedpump2_1am;
	}
	/**
	 * @param deckerfeedpump2_1am the deckerfeedpump2_1am to set
	 */
	public void setDeckerfeedpump2_1am(String deckerfeedpump2_1am) {
		this.deckerfeedpump2_1am = deckerfeedpump2_1am;
	}
	/**
	 * @return the deckerfeedpump2_5am
	 */
	public String getDeckerfeedpump2_5am() {
		return deckerfeedpump2_5am;
	}
	/**
	 * @param deckerfeedpump2_5am the deckerfeedpump2_5am to set
	 */
	public void setDeckerfeedpump2_5am(String deckerfeedpump2_5am) {
		this.deckerfeedpump2_5am = deckerfeedpump2_5am;
	}
	/**
	 * @return the daf1_freq
	 */
	public String getDaf1_freq() {
		return daf1_freq;
	}
	/**
	 * @param daf1_freq the daf1_freq to set
	 */
	public void setDaf1_freq(String daf1_freq) {
		this.daf1_freq = daf1_freq;
	}
	/**
	 * @return the daf1_9am
	 */
	public String getDaf1_9am() {
		return daf1_9am;
	}
	/**
	 * @param daf1_9am the daf1_9am to set
	 */
	public void setDaf1_9am(String daf1_9am) {
		this.daf1_9am = daf1_9am;
	}
	/**
	 * @return the daf1_1pm
	 */
	public String getDaf1_1pm() {
		return daf1_1pm;
	}
	/**
	 * @param daf1_1pm the daf1_1pm to set
	 */
	public void setDaf1_1pm(String daf1_1pm) {
		this.daf1_1pm = daf1_1pm;
	}
	/**
	 * @return the daf1_5pm
	 */
	public String getDaf1_5pm() {
		return daf1_5pm;
	}
	/**
	 * @param daf1_5pm the daf1_5pm to set
	 */
	public void setDaf1_5pm(String daf1_5pm) {
		this.daf1_5pm = daf1_5pm;
	}
	/**
	 * @return the daf1_9pm
	 */
	public String getDaf1_9pm() {
		return daf1_9pm;
	}
	/**
	 * @param daf1_9pm the daf1_9pm to set
	 */
	public void setDaf1_9pm(String daf1_9pm) {
		this.daf1_9pm = daf1_9pm;
	}
	/**
	 * @return the daf1_1am
	 */
	public String getDaf1_1am() {
		return daf1_1am;
	}
	/**
	 * @param daf1_1am the daf1_1am to set
	 */
	public void setDaf1_1am(String daf1_1am) {
		this.daf1_1am = daf1_1am;
	}
	/**
	 * @return the daf1_5am
	 */
	public String getDaf1_5am() {
		return daf1_5am;
	}
	/**
	 * @param daf1_5am the daf1_5am to set
	 */
	public void setDaf1_5am(String daf1_5am) {
		this.daf1_5am = daf1_5am;
	}
	/**
	 * @return the daf2_freq
	 */
	public String getDaf2_freq() {
		return daf2_freq;
	}
	/**
	 * @param daf2_freq the daf2_freq to set
	 */
	public void setDaf2_freq(String daf2_freq) {
		this.daf2_freq = daf2_freq;
	}
	/**
	 * @return the daf2_9am
	 */
	public String getDaf2_9am() {
		return daf2_9am;
	}
	/**
	 * @param daf2_9am the daf2_9am to set
	 */
	public void setDaf2_9am(String daf2_9am) {
		this.daf2_9am = daf2_9am;
	}
	/**
	 * @return the daf2_1pm
	 */
	public String getDaf2_1pm() {
		return daf2_1pm;
	}
	/**
	 * @param daf2_1pm the daf2_1pm to set
	 */
	public void setDaf2_1pm(String daf2_1pm) {
		this.daf2_1pm = daf2_1pm;
	}
	/**
	 * @return the daf2_5pm
	 */
	public String getDaf2_5pm() {
		return daf2_5pm;
	}
	/**
	 * @param daf2_5pm the daf2_5pm to set
	 */
	public void setDaf2_5pm(String daf2_5pm) {
		this.daf2_5pm = daf2_5pm;
	}
	/**
	 * @return the daf2_9pm
	 */
	public String getDaf2_9pm() {
		return daf2_9pm;
	}
	/**
	 * @param daf2_9pm the daf2_9pm to set
	 */
	public void setDaf2_9pm(String daf2_9pm) {
		this.daf2_9pm = daf2_9pm;
	}
	/**
	 * @return the daf2_1am
	 */
	public String getDaf2_1am() {
		return daf2_1am;
	}
	/**
	 * @param daf2_1am the daf2_1am to set
	 */
	public void setDaf2_1am(String daf2_1am) {
		this.daf2_1am = daf2_1am;
	}
	/**
	 * @return the daf2_5am
	 */
	public String getDaf2_5am() {
		return daf2_5am;
	}
	/**
	 * @param daf2_5am the daf2_5am to set
	 */
	public void setDaf2_5am(String daf2_5am) {
		this.daf2_5am = daf2_5am;
	}
	/**
	 * @return the rollupprocessfloorwashuphoses1_freq
	 */
	public String getRollupprocessfloorwashuphoses1_freq() {
		return rollupprocessfloorwashuphoses1_freq;
	}
	/**
	 * @param rollupprocessfloorwashuphoses1_freq the rollupprocessfloorwashuphoses1_freq to set
	 */
	public void setRollupprocessfloorwashuphoses1_freq(String rollupprocessfloorwashuphoses1_freq) {
		this.rollupprocessfloorwashuphoses1_freq = rollupprocessfloorwashuphoses1_freq;
	}
	/**
	 * @return the rollupprocessfloorwashuphoses1_9am
	 */
	public String getRollupprocessfloorwashuphoses1_9am() {
		return rollupprocessfloorwashuphoses1_9am;
	}
	/**
	 * @param rollupprocessfloorwashuphoses1_9am the rollupprocessfloorwashuphoses1_9am to set
	 */
	public void setRollupprocessfloorwashuphoses1_9am(String rollupprocessfloorwashuphoses1_9am) {
		this.rollupprocessfloorwashuphoses1_9am = rollupprocessfloorwashuphoses1_9am;
	}
	/**
	 * @return the rollupprocessfloorwashuphoses1_1pm
	 */
	public String getRollupprocessfloorwashuphoses1_1pm() {
		return rollupprocessfloorwashuphoses1_1pm;
	}
	/**
	 * @param rollupprocessfloorwashuphoses1_1pm the rollupprocessfloorwashuphoses1_1pm to set
	 */
	public void setRollupprocessfloorwashuphoses1_1pm(String rollupprocessfloorwashuphoses1_1pm) {
		this.rollupprocessfloorwashuphoses1_1pm = rollupprocessfloorwashuphoses1_1pm;
	}
	/**
	 * @return the rollupprocessfloorwashuphoses1_5pm
	 */
	public String getRollupprocessfloorwashuphoses1_5pm() {
		return rollupprocessfloorwashuphoses1_5pm;
	}
	/**
	 * @param rollupprocessfloorwashuphoses1_5pm the rollupprocessfloorwashuphoses1_5pm to set
	 */
	public void setRollupprocessfloorwashuphoses1_5pm(String rollupprocessfloorwashuphoses1_5pm) {
		this.rollupprocessfloorwashuphoses1_5pm = rollupprocessfloorwashuphoses1_5pm;
	}
	/**
	 * @return the rollupprocessfloorwashuphoses1_9pm
	 */
	public String getRollupprocessfloorwashuphoses1_9pm() {
		return rollupprocessfloorwashuphoses1_9pm;
	}
	/**
	 * @param rollupprocessfloorwashuphoses1_9pm the rollupprocessfloorwashuphoses1_9pm to set
	 */
	public void setRollupprocessfloorwashuphoses1_9pm(String rollupprocessfloorwashuphoses1_9pm) {
		this.rollupprocessfloorwashuphoses1_9pm = rollupprocessfloorwashuphoses1_9pm;
	}
	/**
	 * @return the rollupprocessfloorwashuphoses1_1am
	 */
	public String getRollupprocessfloorwashuphoses1_1am() {
		return rollupprocessfloorwashuphoses1_1am;
	}
	/**
	 * @param rollupprocessfloorwashuphoses1_1am the rollupprocessfloorwashuphoses1_1am to set
	 */
	public void setRollupprocessfloorwashuphoses1_1am(String rollupprocessfloorwashuphoses1_1am) {
		this.rollupprocessfloorwashuphoses1_1am = rollupprocessfloorwashuphoses1_1am;
	}
	/**
	 * @return the rollupprocessfloorwashuphoses1_5am
	 */
	public String getRollupprocessfloorwashuphoses1_5am() {
		return rollupprocessfloorwashuphoses1_5am;
	}
	/**
	 * @param rollupprocessfloorwashuphoses1_5am the rollupprocessfloorwashuphoses1_5am to set
	 */
	public void setRollupprocessfloorwashuphoses1_5am(String rollupprocessfloorwashuphoses1_5am) {
		this.rollupprocessfloorwashuphoses1_5am = rollupprocessfloorwashuphoses1_5am;
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

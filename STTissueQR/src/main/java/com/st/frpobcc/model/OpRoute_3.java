/**
 *28-Nov-2019
 *OpRoute_3.java
 * TODO
 *com.st.frpobcc.model
 *OpRoute_3.java
 *Roshan Lal Tailor
 */
package com.st.frpobcc.model;

/**
 * @author sohan
 *
 */
public class OpRoute_3 {
	
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
	private String first_stage_decker1_1_freq;
	private String first_stage_decker1_1_8am;
	private String first_stage_decker1_1_12pm;
	private String first_stage_decker1_1_4pm;
	private String first_stage_decker1_1_8pm;
	private String first_stage_decker1_1_12am;
	private String first_stage_decker1_1_4am;
	private String first_stage_decker1_2_freq;
	private String first_stage_decker1_2_8am;
	private String first_stage_decker1_2_12pm;
	private String first_stage_decker1_2_4pm;
	private String first_stage_decker1_2_8pm;
	private String first_stage_decker1_2_12am;
	private String first_stage_decker1_2_4am;
	private String first_stage_decker1_3_freq;
	private String first_stage_decker1_3_8am;
	private String first_stage_decker1_3_12pm;
	private String first_stage_decker1_3_4pm;
	private String first_stage_decker1_3_8pm;
	private String first_stage_decker1_3_12am;
	private String first_stage_decker1_3_4am;
	private String first_stage_decker1_4_freq;
	private String first_stage_decker1_4_8am;
	private String first_stage_decker1_4_12pm;
	private String first_stage_decker1_4_4pm;
	private String first_stage_decker1_4_8pm;
	private String first_stage_decker1_4_12am;
	private String first_stage_decker1_4_4am;
	private String first_stage_decker1_5_freq;
	private String first_stage_decker1_5_8am;
	private String first_stage_decker1_5_12pm;
	private String first_stage_decker1_5_4pm;
	private String first_stage_decker1_5_8pm;
	private String first_stage_decker1_5_12am;
	private String first_stage_decker1_5_4am;
	private String first_stage_decker1_6_freq;
	private String first_stage_decker1_6_8am;
	private String first_stage_decker1_6_12pm;
	private String first_stage_decker1_6_4pm;
	private String first_stage_decker1_6_8pm;
	private String first_stage_decker1_6_12am;
	private String first_stage_decker1_6_4am;
	private String first_stage_decker1_7_freq;
	private String first_stage_decker1_7_8am;
	private String first_stage_decker1_7_12pm;
	private String first_stage_decker1_7_4pm;
	private String first_stage_decker1_7_8pm;
	private String first_stage_decker1_7_12am;
	private String first_stage_decker1_7_4am;
	private String first_stage_decker1_8_freq;
	private String first_stage_decker1_8_8am;
	private String first_stage_decker1_8_12pm;
	private String first_stage_decker1_8_4pm;
	private String first_stage_decker1_8_8pm;
	private String first_stage_decker1_8_12am;
	private String first_stage_decker1_8_4am;
	private String first_stage_decker1_9_freq;
	private String first_stage_decker1_9_8am;
	private String first_stage_decker1_9_12pm;
	private String first_stage_decker1_9_4pm;
	private String first_stage_decker1_9_8pm;
	private String first_stage_decker1_9_12am;
	private String first_stage_decker1_9_4am;
	private String first_stage_decker1_10_freq;
	private String first_stage_decker1_10_8am;
	private String first_stage_decker1_10_12pm;
	private String first_stage_decker1_10_4pm;
	private String first_stage_decker1_10_8pm;
	private String first_stage_decker1_10_12am;
	private String first_stage_decker1_10_4am;
	
	private String first_stage_decker2_1_freq;
	private String first_stage_decker2_1_8am;
	private String first_stage_decker2_1_12pm;
	private String first_stage_decker2_1_4pm;
	private String first_stage_decker2_1_8pm;
	private String first_stage_decker2_1_12am;
	private String first_stage_decker2_1_4am;
	private String first_stage_decker2_2_freq;
	private String first_stage_decker2_2_8am;
	private String first_stage_decker2_2_12pm;
	private String first_stage_decker2_2_4pm;
	private String first_stage_decker2_2_8pm;
	private String first_stage_decker2_2_12am;
	private String first_stage_decker2_2_4am;
	private String first_stage_decker2_3_freq;
	private String first_stage_decker2_3_8am;
	private String first_stage_decker2_3_12pm;
	private String first_stage_decker2_3_4pm;
	private String first_stage_decker2_3_8pm;
	private String first_stage_decker2_3_12am;
	private String first_stage_decker2_3_4am;
	private String first_stage_decker2_4_freq;
	private String first_stage_decker2_4_8am;
	private String first_stage_decker2_4_12pm;
	private String first_stage_decker2_4_4pm;
	private String first_stage_decker2_4_8pm;
	private String first_stage_decker2_4_12am;
	private String first_stage_decker2_4_4am;
	private String first_stage_decker2_5_freq;
	private String first_stage_decker2_5_8am;
	private String first_stage_decker2_5_12pm;
	private String first_stage_decker2_5_4pm;
	private String first_stage_decker2_5_8pm;
	private String first_stage_decker2_5_12am;
	private String first_stage_decker2_5_4am;
	private String first_stage_decker2_6_freq;
	private String first_stage_decker2_6_8am;
	private String first_stage_decker2_6_12pm;
	private String first_stage_decker2_6_4pm;
	private String first_stage_decker2_6_8pm;
	private String first_stage_decker2_6_12am;
	private String first_stage_decker2_6_4am;
	private String first_stage_decker2_7_freq;
	private String first_stage_decker2_7_8am;
	private String first_stage_decker2_7_12pm;
	private String first_stage_decker2_7_4pm;
	private String first_stage_decker2_7_8pm;
	private String first_stage_decker2_7_12am;
	private String first_stage_decker2_7_4am;
	private String first_stage_decker2_8_freq;
	private String first_stage_decker2_8_8am;
	private String first_stage_decker2_8_12pm;
	private String first_stage_decker2_8_4pm;
	private String first_stage_decker2_8_8pm;
	private String first_stage_decker2_8_12am;
	private String first_stage_decker2_8_4am;
	private String first_stage_decker2_9_freq;
	private String first_stage_decker2_9_8am;
	private String first_stage_decker2_9_12pm;
	private String first_stage_decker2_9_4pm;
	private String first_stage_decker2_9_8pm;
	private String first_stage_decker2_9_12am;
	private String first_stage_decker2_9_4am;
	private String first_stage_decker2_10_freq;
	private String first_stage_decker2_10_8am;
	private String first_stage_decker2_10_12pm;
	private String first_stage_decker2_10_4pm;
	private String first_stage_decker2_10_8pm;
	private String first_stage_decker2_10_12am;
	private String first_stage_decker2_10_4am;
	
	private String second_stage_decker1_1_freq;
	private String second_stage_decker1_1_8am;
	private String second_stage_decker1_1_12pm;
	private String second_stage_decker1_1_4pm;
	private String second_stage_decker1_1_8pm;
	private String second_stage_decker1_1_12am;
	private String second_stage_decker1_1_4am;
	private String second_stage_decker1_2_freq;
	private String second_stage_decker1_2_8am;
	private String second_stage_decker1_2_12pm;
	private String second_stage_decker1_2_4pm;
	private String second_stage_decker1_2_8pm;
	private String second_stage_decker1_2_12am;
	private String second_stage_decker1_2_4am;
	private String second_stage_decker1_3_freq;
	private String second_stage_decker1_3_8am;
	private String second_stage_decker1_3_12pm;
	private String second_stage_decker1_3_4pm;
	private String second_stage_decker1_3_8pm;
	private String second_stage_decker1_3_12am;
	private String second_stage_decker1_3_4am;
	private String second_stage_decker1_4_freq;
	private String second_stage_decker1_4_8am;
	private String second_stage_decker1_4_12pm;
	private String second_stage_decker1_4_4pm;
	private String second_stage_decker1_4_8pm;
	private String second_stage_decker1_4_12am;
	private String second_stage_decker1_4_4am;
	private String second_stage_decker1_5_freq;
	private String second_stage_decker1_5_8am;
	private String second_stage_decker1_5_12pm;
	private String second_stage_decker1_5_4pm;
	private String second_stage_decker1_5_8pm;
	private String second_stage_decker1_5_12am;
	private String second_stage_decker1_5_4am;
	private String second_stage_decker1_6_freq;
	private String second_stage_decker1_6_8am;
	private String second_stage_decker1_6_12pm;
	private String second_stage_decker1_6_4pm;
	private String second_stage_decker1_6_8pm;
	private String second_stage_decker1_6_12am;
	private String second_stage_decker1_6_4am;
	private String second_stage_decker1_7_freq;
	private String second_stage_decker1_7_8am;
	private String second_stage_decker1_7_12pm;
	private String second_stage_decker1_7_4pm;
	private String second_stage_decker1_7_8pm;
	private String second_stage_decker1_7_12am;
	private String second_stage_decker1_7_4am;
	private String second_stage_decker1_8_freq;
	private String second_stage_decker1_8_8am;
	private String second_stage_decker1_8_12pm;
	private String second_stage_decker1_8_4pm;
	private String second_stage_decker1_8_8pm;
	private String second_stage_decker1_8_12am;
	private String second_stage_decker1_8_4am;
	private String second_stage_decker1_9_freq;
	private String second_stage_decker1_9_8am;
	private String second_stage_decker1_9_12pm;
	private String second_stage_decker1_9_4pm;
	private String second_stage_decker1_9_8pm;
	private String second_stage_decker1_9_12am;
	private String second_stage_decker1_9_4am;
	private String second_stage_decker1_10_freq;
	private String second_stage_decker1_10_8am;
	private String second_stage_decker1_10_12pm;
	private String second_stage_decker1_10_4pm;
	private String second_stage_decker1_10_8pm;
	private String second_stage_decker1_10_12am;
	private String second_stage_decker1_10_4am;
	
	private String second_stage_decker2_1_freq;
	private String second_stage_decker2_1_8am;
	private String second_stage_decker2_1_12pm;
	private String second_stage_decker2_1_4pm;
	private String second_stage_decker2_1_8pm;
	private String second_stage_decker2_1_12am;
	private String second_stage_decker2_1_4am;
	private String second_stage_decker2_2_freq;
	private String second_stage_decker2_2_8am;
	private String second_stage_decker2_2_12pm;
	private String second_stage_decker2_2_4pm;
	private String second_stage_decker2_2_8pm;
	private String second_stage_decker2_2_12am;
	private String second_stage_decker2_2_4am;
	private String second_stage_decker2_3_freq;
	private String second_stage_decker2_3_8am;
	private String second_stage_decker2_3_12pm;
	private String second_stage_decker2_3_4pm;
	private String second_stage_decker2_3_8pm;
	private String second_stage_decker2_3_12am;
	private String second_stage_decker2_3_4am;
	private String second_stage_decker2_4_freq;
	private String second_stage_decker2_4_8am;
	private String second_stage_decker2_4_12pm;
	private String second_stage_decker2_4_4pm;
	private String second_stage_decker2_4_8pm;
	private String second_stage_decker2_4_12am;
	private String second_stage_decker2_4_4am;
	private String second_stage_decker2_5_freq;
	private String second_stage_decker2_5_8am;
	private String second_stage_decker2_5_12pm;
	private String second_stage_decker2_5_4pm;
	private String second_stage_decker2_5_8pm;
	private String second_stage_decker2_5_12am;
	private String second_stage_decker2_5_4am;
	private String second_stage_decker2_6_freq;
	private String second_stage_decker2_6_8am;
	private String second_stage_decker2_6_12pm;
	private String second_stage_decker2_6_4pm;
	private String second_stage_decker2_6_8pm;
	private String second_stage_decker2_6_12am;
	private String second_stage_decker2_6_4am;
	private String second_stage_decker2_7_freq;
	private String second_stage_decker2_7_8am;
	private String second_stage_decker2_7_12pm;
	private String second_stage_decker2_7_4pm;
	private String second_stage_decker2_7_8pm;
	private String second_stage_decker2_7_12am;
	private String second_stage_decker2_7_4am;
	private String second_stage_decker2_8_freq;
	private String second_stage_decker2_8_8am;
	private String second_stage_decker2_8_12pm;
	private String second_stage_decker2_8_4pm;
	private String second_stage_decker2_8_8pm;
	private String second_stage_decker2_8_12am;
	private String second_stage_decker2_8_4am;
	private String second_stage_decker2_9_freq;
	private String second_stage_decker2_9_8am;
	private String second_stage_decker2_9_12pm;
	private String second_stage_decker2_9_4pm;
	private String second_stage_decker2_9_8pm;
	private String second_stage_decker2_9_12am;
	private String second_stage_decker2_9_4am;
	private String second_stage_decker2_10_freq;
	private String second_stage_decker2_10_8am;
	private String second_stage_decker2_10_12pm;
	private String second_stage_decker2_10_4pm;
	private String second_stage_decker2_10_8pm;
	private String second_stage_decker2_10_12am;
	private String second_stage_decker2_10_4am;
	
	private String rollup_washup_hosesfreq;
	private String rollup_washup_hoses8am;
	private String rollup_washup_hoses12pm;
	private String rollup_washup_hoses4pm;
	private String rollup_washup_hoses8pm;
	private String rollup_washup_hoses12am;
	private String rollup_washup_hoses4am;
	
	
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
 * @return the first_stage_decker1_1_freq
 */
public String getFirst_stage_decker1_1_freq() {
	return first_stage_decker1_1_freq;
}
/**
 * @param first_stage_decker1_1_freq the first_stage_decker1_1_freq to set
 */
public void setFirst_stage_decker1_1_freq(String first_stage_decker1_1_freq) {
	this.first_stage_decker1_1_freq = first_stage_decker1_1_freq;
}
/**
 * @return the first_stage_decker1_1_8am
 */
public String getFirst_stage_decker1_1_8am() {
	return first_stage_decker1_1_8am;
}
/**
 * @param first_stage_decker1_1_8am the first_stage_decker1_1_8am to set
 */
public void setFirst_stage_decker1_1_8am(String first_stage_decker1_1_8am) {
	this.first_stage_decker1_1_8am = first_stage_decker1_1_8am;
}
/**
 * @return the first_stage_decker1_1_12pm
 */
public String getFirst_stage_decker1_1_12pm() {
	return first_stage_decker1_1_12pm;
}
/**
 * @param first_stage_decker1_1_12pm the first_stage_decker1_1_12pm to set
 */
public void setFirst_stage_decker1_1_12pm(String first_stage_decker1_1_12pm) {
	this.first_stage_decker1_1_12pm = first_stage_decker1_1_12pm;
}
/**
 * @return the first_stage_decker1_1_4pm
 */
public String getFirst_stage_decker1_1_4pm() {
	return first_stage_decker1_1_4pm;
}
/**
 * @param first_stage_decker1_1_4pm the first_stage_decker1_1_4pm to set
 */
public void setFirst_stage_decker1_1_4pm(String first_stage_decker1_1_4pm) {
	this.first_stage_decker1_1_4pm = first_stage_decker1_1_4pm;
}
/**
 * @return the first_stage_decker1_1_8pm
 */
public String getFirst_stage_decker1_1_8pm() {
	return first_stage_decker1_1_8pm;
}
/**
 * @param first_stage_decker1_1_8pm the first_stage_decker1_1_8pm to set
 */
public void setFirst_stage_decker1_1_8pm(String first_stage_decker1_1_8pm) {
	this.first_stage_decker1_1_8pm = first_stage_decker1_1_8pm;
}
/**
 * @return the first_stage_decker1_1_12am
 */
public String getFirst_stage_decker1_1_12am() {
	return first_stage_decker1_1_12am;
}
/**
 * @param first_stage_decker1_1_12am the first_stage_decker1_1_12am to set
 */
public void setFirst_stage_decker1_1_12am(String first_stage_decker1_1_12am) {
	this.first_stage_decker1_1_12am = first_stage_decker1_1_12am;
}
/**
 * @return the first_stage_decker1_1_4am
 */
public String getFirst_stage_decker1_1_4am() {
	return first_stage_decker1_1_4am;
}
/**
 * @param first_stage_decker1_1_4am the first_stage_decker1_1_4am to set
 */
public void setFirst_stage_decker1_1_4am(String first_stage_decker1_1_4am) {
	this.first_stage_decker1_1_4am = first_stage_decker1_1_4am;
}
/**
 * @return the first_stage_decker1_2_freq
 */
public String getFirst_stage_decker1_2_freq() {
	return first_stage_decker1_2_freq;
}
/**
 * @param first_stage_decker1_2_freq the first_stage_decker1_2_freq to set
 */
public void setFirst_stage_decker1_2_freq(String first_stage_decker1_2_freq) {
	this.first_stage_decker1_2_freq = first_stage_decker1_2_freq;
}
/**
 * @return the first_stage_decker1_2_8am
 */
public String getFirst_stage_decker1_2_8am() {
	return first_stage_decker1_2_8am;
}
/**
 * @param first_stage_decker1_2_8am the first_stage_decker1_2_8am to set
 */
public void setFirst_stage_decker1_2_8am(String first_stage_decker1_2_8am) {
	this.first_stage_decker1_2_8am = first_stage_decker1_2_8am;
}
/**
 * @return the first_stage_decker1_2_12pm
 */
public String getFirst_stage_decker1_2_12pm() {
	return first_stage_decker1_2_12pm;
}
/**
 * @param first_stage_decker1_2_12pm the first_stage_decker1_2_12pm to set
 */
public void setFirst_stage_decker1_2_12pm(String first_stage_decker1_2_12pm) {
	this.first_stage_decker1_2_12pm = first_stage_decker1_2_12pm;
}
/**
 * @return the first_stage_decker1_2_4pm
 */
public String getFirst_stage_decker1_2_4pm() {
	return first_stage_decker1_2_4pm;
}
/**
 * @param first_stage_decker1_2_4pm the first_stage_decker1_2_4pm to set
 */
public void setFirst_stage_decker1_2_4pm(String first_stage_decker1_2_4pm) {
	this.first_stage_decker1_2_4pm = first_stage_decker1_2_4pm;
}
/**
 * @return the first_stage_decker1_2_8pm
 */
public String getFirst_stage_decker1_2_8pm() {
	return first_stage_decker1_2_8pm;
}
/**
 * @param first_stage_decker1_2_8pm the first_stage_decker1_2_8pm to set
 */
public void setFirst_stage_decker1_2_8pm(String first_stage_decker1_2_8pm) {
	this.first_stage_decker1_2_8pm = first_stage_decker1_2_8pm;
}
/**
 * @return the first_stage_decker1_2_12am
 */
public String getFirst_stage_decker1_2_12am() {
	return first_stage_decker1_2_12am;
}
/**
 * @param first_stage_decker1_2_12am the first_stage_decker1_2_12am to set
 */
public void setFirst_stage_decker1_2_12am(String first_stage_decker1_2_12am) {
	this.first_stage_decker1_2_12am = first_stage_decker1_2_12am;
}
/**
 * @return the first_stage_decker1_2_4am
 */
public String getFirst_stage_decker1_2_4am() {
	return first_stage_decker1_2_4am;
}
/**
 * @param first_stage_decker1_2_4am the first_stage_decker1_2_4am to set
 */
public void setFirst_stage_decker1_2_4am(String first_stage_decker1_2_4am) {
	this.first_stage_decker1_2_4am = first_stage_decker1_2_4am;
}
/**
 * @return the first_stage_decker1_3_freq
 */
public String getFirst_stage_decker1_3_freq() {
	return first_stage_decker1_3_freq;
}
/**
 * @param first_stage_decker1_3_freq the first_stage_decker1_3_freq to set
 */
public void setFirst_stage_decker1_3_freq(String first_stage_decker1_3_freq) {
	this.first_stage_decker1_3_freq = first_stage_decker1_3_freq;
}
/**
 * @return the first_stage_decker1_3_8am
 */
public String getFirst_stage_decker1_3_8am() {
	return first_stage_decker1_3_8am;
}
/**
 * @param first_stage_decker1_3_8am the first_stage_decker1_3_8am to set
 */
public void setFirst_stage_decker1_3_8am(String first_stage_decker1_3_8am) {
	this.first_stage_decker1_3_8am = first_stage_decker1_3_8am;
}
/**
 * @return the first_stage_decker1_3_12pm
 */
public String getFirst_stage_decker1_3_12pm() {
	return first_stage_decker1_3_12pm;
}
/**
 * @param first_stage_decker1_3_12pm the first_stage_decker1_3_12pm to set
 */
public void setFirst_stage_decker1_3_12pm(String first_stage_decker1_3_12pm) {
	this.first_stage_decker1_3_12pm = first_stage_decker1_3_12pm;
}
/**
 * @return the first_stage_decker1_3_4pm
 */
public String getFirst_stage_decker1_3_4pm() {
	return first_stage_decker1_3_4pm;
}
/**
 * @param first_stage_decker1_3_4pm the first_stage_decker1_3_4pm to set
 */
public void setFirst_stage_decker1_3_4pm(String first_stage_decker1_3_4pm) {
	this.first_stage_decker1_3_4pm = first_stage_decker1_3_4pm;
}
/**
 * @return the first_stage_decker1_3_8pm
 */
public String getFirst_stage_decker1_3_8pm() {
	return first_stage_decker1_3_8pm;
}
/**
 * @param first_stage_decker1_3_8pm the first_stage_decker1_3_8pm to set
 */
public void setFirst_stage_decker1_3_8pm(String first_stage_decker1_3_8pm) {
	this.first_stage_decker1_3_8pm = first_stage_decker1_3_8pm;
}
/**
 * @return the first_stage_decker1_3_12am
 */
public String getFirst_stage_decker1_3_12am() {
	return first_stage_decker1_3_12am;
}
/**
 * @param first_stage_decker1_3_12am the first_stage_decker1_3_12am to set
 */
public void setFirst_stage_decker1_3_12am(String first_stage_decker1_3_12am) {
	this.first_stage_decker1_3_12am = first_stage_decker1_3_12am;
}
/**
 * @return the first_stage_decker1_3_4am
 */
public String getFirst_stage_decker1_3_4am() {
	return first_stage_decker1_3_4am;
}
/**
 * @param first_stage_decker1_3_4am the first_stage_decker1_3_4am to set
 */
public void setFirst_stage_decker1_3_4am(String first_stage_decker1_3_4am) {
	this.first_stage_decker1_3_4am = first_stage_decker1_3_4am;
}
/**
 * @return the first_stage_decker1_4_freq
 */
public String getFirst_stage_decker1_4_freq() {
	return first_stage_decker1_4_freq;
}
/**
 * @param first_stage_decker1_4_freq the first_stage_decker1_4_freq to set
 */
public void setFirst_stage_decker1_4_freq(String first_stage_decker1_4_freq) {
	this.first_stage_decker1_4_freq = first_stage_decker1_4_freq;
}
/**
 * @return the first_stage_decker1_4_8am
 */
public String getFirst_stage_decker1_4_8am() {
	return first_stage_decker1_4_8am;
}
/**
 * @param first_stage_decker1_4_8am the first_stage_decker1_4_8am to set
 */
public void setFirst_stage_decker1_4_8am(String first_stage_decker1_4_8am) {
	this.first_stage_decker1_4_8am = first_stage_decker1_4_8am;
}
/**
 * @return the first_stage_decker1_4_12pm
 */
public String getFirst_stage_decker1_4_12pm() {
	return first_stage_decker1_4_12pm;
}
/**
 * @param first_stage_decker1_4_12pm the first_stage_decker1_4_12pm to set
 */
public void setFirst_stage_decker1_4_12pm(String first_stage_decker1_4_12pm) {
	this.first_stage_decker1_4_12pm = first_stage_decker1_4_12pm;
}
/**
 * @return the first_stage_decker1_4_4pm
 */
public String getFirst_stage_decker1_4_4pm() {
	return first_stage_decker1_4_4pm;
}
/**
 * @param first_stage_decker1_4_4pm the first_stage_decker1_4_4pm to set
 */
public void setFirst_stage_decker1_4_4pm(String first_stage_decker1_4_4pm) {
	this.first_stage_decker1_4_4pm = first_stage_decker1_4_4pm;
}
/**
 * @return the first_stage_decker1_4_8pm
 */
public String getFirst_stage_decker1_4_8pm() {
	return first_stage_decker1_4_8pm;
}
/**
 * @param first_stage_decker1_4_8pm the first_stage_decker1_4_8pm to set
 */
public void setFirst_stage_decker1_4_8pm(String first_stage_decker1_4_8pm) {
	this.first_stage_decker1_4_8pm = first_stage_decker1_4_8pm;
}
/**
 * @return the first_stage_decker1_4_12am
 */
public String getFirst_stage_decker1_4_12am() {
	return first_stage_decker1_4_12am;
}
/**
 * @param first_stage_decker1_4_12am the first_stage_decker1_4_12am to set
 */
public void setFirst_stage_decker1_4_12am(String first_stage_decker1_4_12am) {
	this.first_stage_decker1_4_12am = first_stage_decker1_4_12am;
}
/**
 * @return the first_stage_decker1_4_4am
 */
public String getFirst_stage_decker1_4_4am() {
	return first_stage_decker1_4_4am;
}
/**
 * @param first_stage_decker1_4_4am the first_stage_decker1_4_4am to set
 */
public void setFirst_stage_decker1_4_4am(String first_stage_decker1_4_4am) {
	this.first_stage_decker1_4_4am = first_stage_decker1_4_4am;
}
/**
 * @return the first_stage_decker1_5_freq
 */
public String getFirst_stage_decker1_5_freq() {
	return first_stage_decker1_5_freq;
}
/**
 * @param first_stage_decker1_5_freq the first_stage_decker1_5_freq to set
 */
public void setFirst_stage_decker1_5_freq(String first_stage_decker1_5_freq) {
	this.first_stage_decker1_5_freq = first_stage_decker1_5_freq;
}
/**
 * @return the first_stage_decker1_5_8am
 */
public String getFirst_stage_decker1_5_8am() {
	return first_stage_decker1_5_8am;
}
/**
 * @param first_stage_decker1_5_8am the first_stage_decker1_5_8am to set
 */
public void setFirst_stage_decker1_5_8am(String first_stage_decker1_5_8am) {
	this.first_stage_decker1_5_8am = first_stage_decker1_5_8am;
}
/**
 * @return the first_stage_decker1_5_12pm
 */
public String getFirst_stage_decker1_5_12pm() {
	return first_stage_decker1_5_12pm;
}
/**
 * @param first_stage_decker1_5_12pm the first_stage_decker1_5_12pm to set
 */
public void setFirst_stage_decker1_5_12pm(String first_stage_decker1_5_12pm) {
	this.first_stage_decker1_5_12pm = first_stage_decker1_5_12pm;
}
/**
 * @return the first_stage_decker1_5_4pm
 */
public String getFirst_stage_decker1_5_4pm() {
	return first_stage_decker1_5_4pm;
}
/**
 * @param first_stage_decker1_5_4pm the first_stage_decker1_5_4pm to set
 */
public void setFirst_stage_decker1_5_4pm(String first_stage_decker1_5_4pm) {
	this.first_stage_decker1_5_4pm = first_stage_decker1_5_4pm;
}
/**
 * @return the first_stage_decker1_5_8pm
 */
public String getFirst_stage_decker1_5_8pm() {
	return first_stage_decker1_5_8pm;
}
/**
 * @param first_stage_decker1_5_8pm the first_stage_decker1_5_8pm to set
 */
public void setFirst_stage_decker1_5_8pm(String first_stage_decker1_5_8pm) {
	this.first_stage_decker1_5_8pm = first_stage_decker1_5_8pm;
}
/**
 * @return the first_stage_decker1_5_12am
 */
public String getFirst_stage_decker1_5_12am() {
	return first_stage_decker1_5_12am;
}
/**
 * @param first_stage_decker1_5_12am the first_stage_decker1_5_12am to set
 */
public void setFirst_stage_decker1_5_12am(String first_stage_decker1_5_12am) {
	this.first_stage_decker1_5_12am = first_stage_decker1_5_12am;
}
/**
 * @return the first_stage_decker1_5_4am
 */
public String getFirst_stage_decker1_5_4am() {
	return first_stage_decker1_5_4am;
}
/**
 * @param first_stage_decker1_5_4am the first_stage_decker1_5_4am to set
 */
public void setFirst_stage_decker1_5_4am(String first_stage_decker1_5_4am) {
	this.first_stage_decker1_5_4am = first_stage_decker1_5_4am;
}
/**
 * @return the first_stage_decker1_6_freq
 */
public String getFirst_stage_decker1_6_freq() {
	return first_stage_decker1_6_freq;
}
/**
 * @param first_stage_decker1_6_freq the first_stage_decker1_6_freq to set
 */
public void setFirst_stage_decker1_6_freq(String first_stage_decker1_6_freq) {
	this.first_stage_decker1_6_freq = first_stage_decker1_6_freq;
}
/**
 * @return the first_stage_decker1_6_8am
 */
public String getFirst_stage_decker1_6_8am() {
	return first_stage_decker1_6_8am;
}
/**
 * @param first_stage_decker1_6_8am the first_stage_decker1_6_8am to set
 */
public void setFirst_stage_decker1_6_8am(String first_stage_decker1_6_8am) {
	this.first_stage_decker1_6_8am = first_stage_decker1_6_8am;
}
/**
 * @return the first_stage_decker1_6_12pm
 */
public String getFirst_stage_decker1_6_12pm() {
	return first_stage_decker1_6_12pm;
}
/**
 * @param first_stage_decker1_6_12pm the first_stage_decker1_6_12pm to set
 */
public void setFirst_stage_decker1_6_12pm(String first_stage_decker1_6_12pm) {
	this.first_stage_decker1_6_12pm = first_stage_decker1_6_12pm;
}
/**
 * @return the first_stage_decker1_6_4pm
 */
public String getFirst_stage_decker1_6_4pm() {
	return first_stage_decker1_6_4pm;
}
/**
 * @param first_stage_decker1_6_4pm the first_stage_decker1_6_4pm to set
 */
public void setFirst_stage_decker1_6_4pm(String first_stage_decker1_6_4pm) {
	this.first_stage_decker1_6_4pm = first_stage_decker1_6_4pm;
}
/**
 * @return the first_stage_decker1_6_8pm
 */
public String getFirst_stage_decker1_6_8pm() {
	return first_stage_decker1_6_8pm;
}
/**
 * @param first_stage_decker1_6_8pm the first_stage_decker1_6_8pm to set
 */
public void setFirst_stage_decker1_6_8pm(String first_stage_decker1_6_8pm) {
	this.first_stage_decker1_6_8pm = first_stage_decker1_6_8pm;
}
/**
 * @return the first_stage_decker1_6_12am
 */
public String getFirst_stage_decker1_6_12am() {
	return first_stage_decker1_6_12am;
}
/**
 * @param first_stage_decker1_6_12am the first_stage_decker1_6_12am to set
 */
public void setFirst_stage_decker1_6_12am(String first_stage_decker1_6_12am) {
	this.first_stage_decker1_6_12am = first_stage_decker1_6_12am;
}
/**
 * @return the first_stage_decker1_6_4am
 */
public String getFirst_stage_decker1_6_4am() {
	return first_stage_decker1_6_4am;
}
/**
 * @param first_stage_decker1_6_4am the first_stage_decker1_6_4am to set
 */
public void setFirst_stage_decker1_6_4am(String first_stage_decker1_6_4am) {
	this.first_stage_decker1_6_4am = first_stage_decker1_6_4am;
}
/**
 * @return the first_stage_decker1_7_freq
 */
public String getFirst_stage_decker1_7_freq() {
	return first_stage_decker1_7_freq;
}
/**
 * @param first_stage_decker1_7_freq the first_stage_decker1_7_freq to set
 */
public void setFirst_stage_decker1_7_freq(String first_stage_decker1_7_freq) {
	this.first_stage_decker1_7_freq = first_stage_decker1_7_freq;
}
/**
 * @return the first_stage_decker1_7_8am
 */
public String getFirst_stage_decker1_7_8am() {
	return first_stage_decker1_7_8am;
}
/**
 * @param first_stage_decker1_7_8am the first_stage_decker1_7_8am to set
 */
public void setFirst_stage_decker1_7_8am(String first_stage_decker1_7_8am) {
	this.first_stage_decker1_7_8am = first_stage_decker1_7_8am;
}
/**
 * @return the first_stage_decker1_7_12pm
 */
public String getFirst_stage_decker1_7_12pm() {
	return first_stage_decker1_7_12pm;
}
/**
 * @param first_stage_decker1_7_12pm the first_stage_decker1_7_12pm to set
 */
public void setFirst_stage_decker1_7_12pm(String first_stage_decker1_7_12pm) {
	this.first_stage_decker1_7_12pm = first_stage_decker1_7_12pm;
}
/**
 * @return the first_stage_decker1_7_4pm
 */
public String getFirst_stage_decker1_7_4pm() {
	return first_stage_decker1_7_4pm;
}
/**
 * @param first_stage_decker1_7_4pm the first_stage_decker1_7_4pm to set
 */
public void setFirst_stage_decker1_7_4pm(String first_stage_decker1_7_4pm) {
	this.first_stage_decker1_7_4pm = first_stage_decker1_7_4pm;
}
/**
 * @return the first_stage_decker1_7_8pm
 */
public String getFirst_stage_decker1_7_8pm() {
	return first_stage_decker1_7_8pm;
}
/**
 * @param first_stage_decker1_7_8pm the first_stage_decker1_7_8pm to set
 */
public void setFirst_stage_decker1_7_8pm(String first_stage_decker1_7_8pm) {
	this.first_stage_decker1_7_8pm = first_stage_decker1_7_8pm;
}
/**
 * @return the first_stage_decker1_7_12am
 */
public String getFirst_stage_decker1_7_12am() {
	return first_stage_decker1_7_12am;
}
/**
 * @param first_stage_decker1_7_12am the first_stage_decker1_7_12am to set
 */
public void setFirst_stage_decker1_7_12am(String first_stage_decker1_7_12am) {
	this.first_stage_decker1_7_12am = first_stage_decker1_7_12am;
}
/**
 * @return the first_stage_decker1_7_4am
 */
public String getFirst_stage_decker1_7_4am() {
	return first_stage_decker1_7_4am;
}
/**
 * @param first_stage_decker1_7_4am the first_stage_decker1_7_4am to set
 */
public void setFirst_stage_decker1_7_4am(String first_stage_decker1_7_4am) {
	this.first_stage_decker1_7_4am = first_stage_decker1_7_4am;
}
/**
 * @return the first_stage_decker1_8_freq
 */
public String getFirst_stage_decker1_8_freq() {
	return first_stage_decker1_8_freq;
}
/**
 * @param first_stage_decker1_8_freq the first_stage_decker1_8_freq to set
 */
public void setFirst_stage_decker1_8_freq(String first_stage_decker1_8_freq) {
	this.first_stage_decker1_8_freq = first_stage_decker1_8_freq;
}
/**
 * @return the first_stage_decker1_8_8am
 */
public String getFirst_stage_decker1_8_8am() {
	return first_stage_decker1_8_8am;
}
/**
 * @param first_stage_decker1_8_8am the first_stage_decker1_8_8am to set
 */
public void setFirst_stage_decker1_8_8am(String first_stage_decker1_8_8am) {
	this.first_stage_decker1_8_8am = first_stage_decker1_8_8am;
}
/**
 * @return the first_stage_decker1_8_12pm
 */
public String getFirst_stage_decker1_8_12pm() {
	return first_stage_decker1_8_12pm;
}
/**
 * @param first_stage_decker1_8_12pm the first_stage_decker1_8_12pm to set
 */
public void setFirst_stage_decker1_8_12pm(String first_stage_decker1_8_12pm) {
	this.first_stage_decker1_8_12pm = first_stage_decker1_8_12pm;
}
/**
 * @return the first_stage_decker1_8_4pm
 */
public String getFirst_stage_decker1_8_4pm() {
	return first_stage_decker1_8_4pm;
}
/**
 * @param first_stage_decker1_8_4pm the first_stage_decker1_8_4pm to set
 */
public void setFirst_stage_decker1_8_4pm(String first_stage_decker1_8_4pm) {
	this.first_stage_decker1_8_4pm = first_stage_decker1_8_4pm;
}
/**
 * @return the first_stage_decker1_8_8pm
 */
public String getFirst_stage_decker1_8_8pm() {
	return first_stage_decker1_8_8pm;
}
/**
 * @param first_stage_decker1_8_8pm the first_stage_decker1_8_8pm to set
 */
public void setFirst_stage_decker1_8_8pm(String first_stage_decker1_8_8pm) {
	this.first_stage_decker1_8_8pm = first_stage_decker1_8_8pm;
}
/**
 * @return the first_stage_decker1_8_12am
 */
public String getFirst_stage_decker1_8_12am() {
	return first_stage_decker1_8_12am;
}
/**
 * @param first_stage_decker1_8_12am the first_stage_decker1_8_12am to set
 */
public void setFirst_stage_decker1_8_12am(String first_stage_decker1_8_12am) {
	this.first_stage_decker1_8_12am = first_stage_decker1_8_12am;
}
/**
 * @return the first_stage_decker1_8_4am
 */
public String getFirst_stage_decker1_8_4am() {
	return first_stage_decker1_8_4am;
}
/**
 * @param first_stage_decker1_8_4am the first_stage_decker1_8_4am to set
 */
public void setFirst_stage_decker1_8_4am(String first_stage_decker1_8_4am) {
	this.first_stage_decker1_8_4am = first_stage_decker1_8_4am;
}
/**
 * @return the first_stage_decker1_9_freq
 */
public String getFirst_stage_decker1_9_freq() {
	return first_stage_decker1_9_freq;
}
/**
 * @param first_stage_decker1_9_freq the first_stage_decker1_9_freq to set
 */
public void setFirst_stage_decker1_9_freq(String first_stage_decker1_9_freq) {
	this.first_stage_decker1_9_freq = first_stage_decker1_9_freq;
}
/**
 * @return the first_stage_decker1_9_8am
 */
public String getFirst_stage_decker1_9_8am() {
	return first_stage_decker1_9_8am;
}
/**
 * @param first_stage_decker1_9_8am the first_stage_decker1_9_8am to set
 */
public void setFirst_stage_decker1_9_8am(String first_stage_decker1_9_8am) {
	this.first_stage_decker1_9_8am = first_stage_decker1_9_8am;
}
/**
 * @return the first_stage_decker1_9_12pm
 */
public String getFirst_stage_decker1_9_12pm() {
	return first_stage_decker1_9_12pm;
}
/**
 * @param first_stage_decker1_9_12pm the first_stage_decker1_9_12pm to set
 */
public void setFirst_stage_decker1_9_12pm(String first_stage_decker1_9_12pm) {
	this.first_stage_decker1_9_12pm = first_stage_decker1_9_12pm;
}
/**
 * @return the first_stage_decker1_9_4pm
 */
public String getFirst_stage_decker1_9_4pm() {
	return first_stage_decker1_9_4pm;
}
/**
 * @param first_stage_decker1_9_4pm the first_stage_decker1_9_4pm to set
 */
public void setFirst_stage_decker1_9_4pm(String first_stage_decker1_9_4pm) {
	this.first_stage_decker1_9_4pm = first_stage_decker1_9_4pm;
}
/**
 * @return the first_stage_decker1_9_8pm
 */
public String getFirst_stage_decker1_9_8pm() {
	return first_stage_decker1_9_8pm;
}
/**
 * @param first_stage_decker1_9_8pm the first_stage_decker1_9_8pm to set
 */
public void setFirst_stage_decker1_9_8pm(String first_stage_decker1_9_8pm) {
	this.first_stage_decker1_9_8pm = first_stage_decker1_9_8pm;
}
/**
 * @return the first_stage_decker1_9_12am
 */
public String getFirst_stage_decker1_9_12am() {
	return first_stage_decker1_9_12am;
}
/**
 * @param first_stage_decker1_9_12am the first_stage_decker1_9_12am to set
 */
public void setFirst_stage_decker1_9_12am(String first_stage_decker1_9_12am) {
	this.first_stage_decker1_9_12am = first_stage_decker1_9_12am;
}
/**
 * @return the first_stage_decker1_9_4am
 */
public String getFirst_stage_decker1_9_4am() {
	return first_stage_decker1_9_4am;
}
/**
 * @param first_stage_decker1_9_4am the first_stage_decker1_9_4am to set
 */
public void setFirst_stage_decker1_9_4am(String first_stage_decker1_9_4am) {
	this.first_stage_decker1_9_4am = first_stage_decker1_9_4am;
}
/**
 * @return the first_stage_decker1_10_freq
 */
public String getFirst_stage_decker1_10_freq() {
	return first_stage_decker1_10_freq;
}
/**
 * @param first_stage_decker1_10_freq the first_stage_decker1_10_freq to set
 */
public void setFirst_stage_decker1_10_freq(String first_stage_decker1_10_freq) {
	this.first_stage_decker1_10_freq = first_stage_decker1_10_freq;
}
/**
 * @return the first_stage_decker1_10_8am
 */
public String getFirst_stage_decker1_10_8am() {
	return first_stage_decker1_10_8am;
}
/**
 * @param first_stage_decker1_10_8am the first_stage_decker1_10_8am to set
 */
public void setFirst_stage_decker1_10_8am(String first_stage_decker1_10_8am) {
	this.first_stage_decker1_10_8am = first_stage_decker1_10_8am;
}
/**
 * @return the first_stage_decker1_10_12pm
 */
public String getFirst_stage_decker1_10_12pm() {
	return first_stage_decker1_10_12pm;
}
/**
 * @param first_stage_decker1_10_12pm the first_stage_decker1_10_12pm to set
 */
public void setFirst_stage_decker1_10_12pm(String first_stage_decker1_10_12pm) {
	this.first_stage_decker1_10_12pm = first_stage_decker1_10_12pm;
}
/**
 * @return the first_stage_decker1_10_4pm
 */
public String getFirst_stage_decker1_10_4pm() {
	return first_stage_decker1_10_4pm;
}
/**
 * @param first_stage_decker1_10_4pm the first_stage_decker1_10_4pm to set
 */
public void setFirst_stage_decker1_10_4pm(String first_stage_decker1_10_4pm) {
	this.first_stage_decker1_10_4pm = first_stage_decker1_10_4pm;
}
/**
 * @return the first_stage_decker1_10_8pm
 */
public String getFirst_stage_decker1_10_8pm() {
	return first_stage_decker1_10_8pm;
}
/**
 * @param first_stage_decker1_10_8pm the first_stage_decker1_10_8pm to set
 */
public void setFirst_stage_decker1_10_8pm(String first_stage_decker1_10_8pm) {
	this.first_stage_decker1_10_8pm = first_stage_decker1_10_8pm;
}
/**
 * @return the first_stage_decker1_10_12am
 */
public String getFirst_stage_decker1_10_12am() {
	return first_stage_decker1_10_12am;
}
/**
 * @param first_stage_decker1_10_12am the first_stage_decker1_10_12am to set
 */
public void setFirst_stage_decker1_10_12am(String first_stage_decker1_10_12am) {
	this.first_stage_decker1_10_12am = first_stage_decker1_10_12am;
}
/**
 * @return the first_stage_decker1_10_4am
 */
public String getFirst_stage_decker1_10_4am() {
	return first_stage_decker1_10_4am;
}
/**
 * @param first_stage_decker1_10_4am the first_stage_decker1_10_4am to set
 */
public void setFirst_stage_decker1_10_4am(String first_stage_decker1_10_4am) {
	this.first_stage_decker1_10_4am = first_stage_decker1_10_4am;
}
/**
 * @return the first_stage_decker2_1_freq
 */
public String getFirst_stage_decker2_1_freq() {
	return first_stage_decker2_1_freq;
}
/**
 * @param first_stage_decker2_1_freq the first_stage_decker2_1_freq to set
 */
public void setFirst_stage_decker2_1_freq(String first_stage_decker2_1_freq) {
	this.first_stage_decker2_1_freq = first_stage_decker2_1_freq;
}
/**
 * @return the first_stage_decker2_1_8am
 */
public String getFirst_stage_decker2_1_8am() {
	return first_stage_decker2_1_8am;
}
/**
 * @param first_stage_decker2_1_8am the first_stage_decker2_1_8am to set
 */
public void setFirst_stage_decker2_1_8am(String first_stage_decker2_1_8am) {
	this.first_stage_decker2_1_8am = first_stage_decker2_1_8am;
}
/**
 * @return the first_stage_decker2_1_12pm
 */
public String getFirst_stage_decker2_1_12pm() {
	return first_stage_decker2_1_12pm;
}
/**
 * @param first_stage_decker2_1_12pm the first_stage_decker2_1_12pm to set
 */
public void setFirst_stage_decker2_1_12pm(String first_stage_decker2_1_12pm) {
	this.first_stage_decker2_1_12pm = first_stage_decker2_1_12pm;
}
/**
 * @return the first_stage_decker2_1_4pm
 */
public String getFirst_stage_decker2_1_4pm() {
	return first_stage_decker2_1_4pm;
}
/**
 * @param first_stage_decker2_1_4pm the first_stage_decker2_1_4pm to set
 */
public void setFirst_stage_decker2_1_4pm(String first_stage_decker2_1_4pm) {
	this.first_stage_decker2_1_4pm = first_stage_decker2_1_4pm;
}
/**
 * @return the first_stage_decker2_1_8pm
 */
public String getFirst_stage_decker2_1_8pm() {
	return first_stage_decker2_1_8pm;
}
/**
 * @param first_stage_decker2_1_8pm the first_stage_decker2_1_8pm to set
 */
public void setFirst_stage_decker2_1_8pm(String first_stage_decker2_1_8pm) {
	this.first_stage_decker2_1_8pm = first_stage_decker2_1_8pm;
}
/**
 * @return the first_stage_decker2_1_12am
 */
public String getFirst_stage_decker2_1_12am() {
	return first_stage_decker2_1_12am;
}
/**
 * @param first_stage_decker2_1_12am the first_stage_decker2_1_12am to set
 */
public void setFirst_stage_decker2_1_12am(String first_stage_decker2_1_12am) {
	this.first_stage_decker2_1_12am = first_stage_decker2_1_12am;
}
/**
 * @return the first_stage_decker2_1_4am
 */
public String getFirst_stage_decker2_1_4am() {
	return first_stage_decker2_1_4am;
}
/**
 * @param first_stage_decker2_1_4am the first_stage_decker2_1_4am to set
 */
public void setFirst_stage_decker2_1_4am(String first_stage_decker2_1_4am) {
	this.first_stage_decker2_1_4am = first_stage_decker2_1_4am;
}
/**
 * @return the first_stage_decker2_2_freq
 */
public String getFirst_stage_decker2_2_freq() {
	return first_stage_decker2_2_freq;
}
/**
 * @param first_stage_decker2_2_freq the first_stage_decker2_2_freq to set
 */
public void setFirst_stage_decker2_2_freq(String first_stage_decker2_2_freq) {
	this.first_stage_decker2_2_freq = first_stage_decker2_2_freq;
}
/**
 * @return the first_stage_decker2_2_8am
 */
public String getFirst_stage_decker2_2_8am() {
	return first_stage_decker2_2_8am;
}
/**
 * @param first_stage_decker2_2_8am the first_stage_decker2_2_8am to set
 */
public void setFirst_stage_decker2_2_8am(String first_stage_decker2_2_8am) {
	this.first_stage_decker2_2_8am = first_stage_decker2_2_8am;
}
/**
 * @return the first_stage_decker2_2_12pm
 */
public String getFirst_stage_decker2_2_12pm() {
	return first_stage_decker2_2_12pm;
}
/**
 * @param first_stage_decker2_2_12pm the first_stage_decker2_2_12pm to set
 */
public void setFirst_stage_decker2_2_12pm(String first_stage_decker2_2_12pm) {
	this.first_stage_decker2_2_12pm = first_stage_decker2_2_12pm;
}
/**
 * @return the first_stage_decker2_2_4pm
 */
public String getFirst_stage_decker2_2_4pm() {
	return first_stage_decker2_2_4pm;
}
/**
 * @param first_stage_decker2_2_4pm the first_stage_decker2_2_4pm to set
 */
public void setFirst_stage_decker2_2_4pm(String first_stage_decker2_2_4pm) {
	this.first_stage_decker2_2_4pm = first_stage_decker2_2_4pm;
}
/**
 * @return the first_stage_decker2_2_8pm
 */
public String getFirst_stage_decker2_2_8pm() {
	return first_stage_decker2_2_8pm;
}
/**
 * @param first_stage_decker2_2_8pm the first_stage_decker2_2_8pm to set
 */
public void setFirst_stage_decker2_2_8pm(String first_stage_decker2_2_8pm) {
	this.first_stage_decker2_2_8pm = first_stage_decker2_2_8pm;
}
/**
 * @return the first_stage_decker2_2_12am
 */
public String getFirst_stage_decker2_2_12am() {
	return first_stage_decker2_2_12am;
}
/**
 * @param first_stage_decker2_2_12am the first_stage_decker2_2_12am to set
 */
public void setFirst_stage_decker2_2_12am(String first_stage_decker2_2_12am) {
	this.first_stage_decker2_2_12am = first_stage_decker2_2_12am;
}
/**
 * @return the first_stage_decker2_2_4am
 */
public String getFirst_stage_decker2_2_4am() {
	return first_stage_decker2_2_4am;
}
/**
 * @param first_stage_decker2_2_4am the first_stage_decker2_2_4am to set
 */
public void setFirst_stage_decker2_2_4am(String first_stage_decker2_2_4am) {
	this.first_stage_decker2_2_4am = first_stage_decker2_2_4am;
}
/**
 * @return the first_stage_decker2_3_freq
 */
public String getFirst_stage_decker2_3_freq() {
	return first_stage_decker2_3_freq;
}
/**
 * @param first_stage_decker2_3_freq the first_stage_decker2_3_freq to set
 */
public void setFirst_stage_decker2_3_freq(String first_stage_decker2_3_freq) {
	this.first_stage_decker2_3_freq = first_stage_decker2_3_freq;
}
/**
 * @return the first_stage_decker2_3_8am
 */
public String getFirst_stage_decker2_3_8am() {
	return first_stage_decker2_3_8am;
}
/**
 * @param first_stage_decker2_3_8am the first_stage_decker2_3_8am to set
 */
public void setFirst_stage_decker2_3_8am(String first_stage_decker2_3_8am) {
	this.first_stage_decker2_3_8am = first_stage_decker2_3_8am;
}
/**
 * @return the first_stage_decker2_3_12pm
 */
public String getFirst_stage_decker2_3_12pm() {
	return first_stage_decker2_3_12pm;
}
/**
 * @param first_stage_decker2_3_12pm the first_stage_decker2_3_12pm to set
 */
public void setFirst_stage_decker2_3_12pm(String first_stage_decker2_3_12pm) {
	this.first_stage_decker2_3_12pm = first_stage_decker2_3_12pm;
}
/**
 * @return the first_stage_decker2_3_4pm
 */
public String getFirst_stage_decker2_3_4pm() {
	return first_stage_decker2_3_4pm;
}
/**
 * @param first_stage_decker2_3_4pm the first_stage_decker2_3_4pm to set
 */
public void setFirst_stage_decker2_3_4pm(String first_stage_decker2_3_4pm) {
	this.first_stage_decker2_3_4pm = first_stage_decker2_3_4pm;
}
/**
 * @return the first_stage_decker2_3_8pm
 */
public String getFirst_stage_decker2_3_8pm() {
	return first_stage_decker2_3_8pm;
}
/**
 * @param first_stage_decker2_3_8pm the first_stage_decker2_3_8pm to set
 */
public void setFirst_stage_decker2_3_8pm(String first_stage_decker2_3_8pm) {
	this.first_stage_decker2_3_8pm = first_stage_decker2_3_8pm;
}
/**
 * @return the first_stage_decker2_3_12am
 */
public String getFirst_stage_decker2_3_12am() {
	return first_stage_decker2_3_12am;
}
/**
 * @param first_stage_decker2_3_12am the first_stage_decker2_3_12am to set
 */
public void setFirst_stage_decker2_3_12am(String first_stage_decker2_3_12am) {
	this.first_stage_decker2_3_12am = first_stage_decker2_3_12am;
}
/**
 * @return the first_stage_decker2_3_4am
 */
public String getFirst_stage_decker2_3_4am() {
	return first_stage_decker2_3_4am;
}
/**
 * @param first_stage_decker2_3_4am the first_stage_decker2_3_4am to set
 */
public void setFirst_stage_decker2_3_4am(String first_stage_decker2_3_4am) {
	this.first_stage_decker2_3_4am = first_stage_decker2_3_4am;
}
/**
 * @return the first_stage_decker2_4_freq
 */
public String getFirst_stage_decker2_4_freq() {
	return first_stage_decker2_4_freq;
}
/**
 * @param first_stage_decker2_4_freq the first_stage_decker2_4_freq to set
 */
public void setFirst_stage_decker2_4_freq(String first_stage_decker2_4_freq) {
	this.first_stage_decker2_4_freq = first_stage_decker2_4_freq;
}
/**
 * @return the first_stage_decker2_4_8am
 */
public String getFirst_stage_decker2_4_8am() {
	return first_stage_decker2_4_8am;
}
/**
 * @param first_stage_decker2_4_8am the first_stage_decker2_4_8am to set
 */
public void setFirst_stage_decker2_4_8am(String first_stage_decker2_4_8am) {
	this.first_stage_decker2_4_8am = first_stage_decker2_4_8am;
}
/**
 * @return the first_stage_decker2_4_12pm
 */
public String getFirst_stage_decker2_4_12pm() {
	return first_stage_decker2_4_12pm;
}
/**
 * @param first_stage_decker2_4_12pm the first_stage_decker2_4_12pm to set
 */
public void setFirst_stage_decker2_4_12pm(String first_stage_decker2_4_12pm) {
	this.first_stage_decker2_4_12pm = first_stage_decker2_4_12pm;
}
/**
 * @return the first_stage_decker2_4_4pm
 */
public String getFirst_stage_decker2_4_4pm() {
	return first_stage_decker2_4_4pm;
}
/**
 * @param first_stage_decker2_4_4pm the first_stage_decker2_4_4pm to set
 */
public void setFirst_stage_decker2_4_4pm(String first_stage_decker2_4_4pm) {
	this.first_stage_decker2_4_4pm = first_stage_decker2_4_4pm;
}
/**
 * @return the first_stage_decker2_4_8pm
 */
public String getFirst_stage_decker2_4_8pm() {
	return first_stage_decker2_4_8pm;
}
/**
 * @param first_stage_decker2_4_8pm the first_stage_decker2_4_8pm to set
 */
public void setFirst_stage_decker2_4_8pm(String first_stage_decker2_4_8pm) {
	this.first_stage_decker2_4_8pm = first_stage_decker2_4_8pm;
}
/**
 * @return the first_stage_decker2_4_12am
 */
public String getFirst_stage_decker2_4_12am() {
	return first_stage_decker2_4_12am;
}
/**
 * @param first_stage_decker2_4_12am the first_stage_decker2_4_12am to set
 */
public void setFirst_stage_decker2_4_12am(String first_stage_decker2_4_12am) {
	this.first_stage_decker2_4_12am = first_stage_decker2_4_12am;
}
/**
 * @return the first_stage_decker2_4_4am
 */
public String getFirst_stage_decker2_4_4am() {
	return first_stage_decker2_4_4am;
}
/**
 * @param first_stage_decker2_4_4am the first_stage_decker2_4_4am to set
 */
public void setFirst_stage_decker2_4_4am(String first_stage_decker2_4_4am) {
	this.first_stage_decker2_4_4am = first_stage_decker2_4_4am;
}
/**
 * @return the first_stage_decker2_5_freq
 */
public String getFirst_stage_decker2_5_freq() {
	return first_stage_decker2_5_freq;
}
/**
 * @param first_stage_decker2_5_freq the first_stage_decker2_5_freq to set
 */
public void setFirst_stage_decker2_5_freq(String first_stage_decker2_5_freq) {
	this.first_stage_decker2_5_freq = first_stage_decker2_5_freq;
}
/**
 * @return the first_stage_decker2_5_8am
 */
public String getFirst_stage_decker2_5_8am() {
	return first_stage_decker2_5_8am;
}
/**
 * @param first_stage_decker2_5_8am the first_stage_decker2_5_8am to set
 */
public void setFirst_stage_decker2_5_8am(String first_stage_decker2_5_8am) {
	this.first_stage_decker2_5_8am = first_stage_decker2_5_8am;
}
/**
 * @return the first_stage_decker2_5_12pm
 */
public String getFirst_stage_decker2_5_12pm() {
	return first_stage_decker2_5_12pm;
}
/**
 * @param first_stage_decker2_5_12pm the first_stage_decker2_5_12pm to set
 */
public void setFirst_stage_decker2_5_12pm(String first_stage_decker2_5_12pm) {
	this.first_stage_decker2_5_12pm = first_stage_decker2_5_12pm;
}
/**
 * @return the first_stage_decker2_5_4pm
 */
public String getFirst_stage_decker2_5_4pm() {
	return first_stage_decker2_5_4pm;
}
/**
 * @param first_stage_decker2_5_4pm the first_stage_decker2_5_4pm to set
 */
public void setFirst_stage_decker2_5_4pm(String first_stage_decker2_5_4pm) {
	this.first_stage_decker2_5_4pm = first_stage_decker2_5_4pm;
}
/**
 * @return the first_stage_decker2_5_8pm
 */
public String getFirst_stage_decker2_5_8pm() {
	return first_stage_decker2_5_8pm;
}
/**
 * @param first_stage_decker2_5_8pm the first_stage_decker2_5_8pm to set
 */
public void setFirst_stage_decker2_5_8pm(String first_stage_decker2_5_8pm) {
	this.first_stage_decker2_5_8pm = first_stage_decker2_5_8pm;
}
/**
 * @return the first_stage_decker2_5_12am
 */
public String getFirst_stage_decker2_5_12am() {
	return first_stage_decker2_5_12am;
}
/**
 * @param first_stage_decker2_5_12am the first_stage_decker2_5_12am to set
 */
public void setFirst_stage_decker2_5_12am(String first_stage_decker2_5_12am) {
	this.first_stage_decker2_5_12am = first_stage_decker2_5_12am;
}
/**
 * @return the first_stage_decker2_5_4am
 */
public String getFirst_stage_decker2_5_4am() {
	return first_stage_decker2_5_4am;
}
/**
 * @param first_stage_decker2_5_4am the first_stage_decker2_5_4am to set
 */
public void setFirst_stage_decker2_5_4am(String first_stage_decker2_5_4am) {
	this.first_stage_decker2_5_4am = first_stage_decker2_5_4am;
}
/**
 * @return the first_stage_decker2_6_freq
 */
public String getFirst_stage_decker2_6_freq() {
	return first_stage_decker2_6_freq;
}
/**
 * @param first_stage_decker2_6_freq the first_stage_decker2_6_freq to set
 */
public void setFirst_stage_decker2_6_freq(String first_stage_decker2_6_freq) {
	this.first_stage_decker2_6_freq = first_stage_decker2_6_freq;
}
/**
 * @return the first_stage_decker2_6_8am
 */
public String getFirst_stage_decker2_6_8am() {
	return first_stage_decker2_6_8am;
}
/**
 * @param first_stage_decker2_6_8am the first_stage_decker2_6_8am to set
 */
public void setFirst_stage_decker2_6_8am(String first_stage_decker2_6_8am) {
	this.first_stage_decker2_6_8am = first_stage_decker2_6_8am;
}
/**
 * @return the first_stage_decker2_6_12pm
 */
public String getFirst_stage_decker2_6_12pm() {
	return first_stage_decker2_6_12pm;
}
/**
 * @param first_stage_decker2_6_12pm the first_stage_decker2_6_12pm to set
 */
public void setFirst_stage_decker2_6_12pm(String first_stage_decker2_6_12pm) {
	this.first_stage_decker2_6_12pm = first_stage_decker2_6_12pm;
}
/**
 * @return the first_stage_decker2_6_4pm
 */
public String getFirst_stage_decker2_6_4pm() {
	return first_stage_decker2_6_4pm;
}
/**
 * @param first_stage_decker2_6_4pm the first_stage_decker2_6_4pm to set
 */
public void setFirst_stage_decker2_6_4pm(String first_stage_decker2_6_4pm) {
	this.first_stage_decker2_6_4pm = first_stage_decker2_6_4pm;
}
/**
 * @return the first_stage_decker2_6_8pm
 */
public String getFirst_stage_decker2_6_8pm() {
	return first_stage_decker2_6_8pm;
}
/**
 * @param first_stage_decker2_6_8pm the first_stage_decker2_6_8pm to set
 */
public void setFirst_stage_decker2_6_8pm(String first_stage_decker2_6_8pm) {
	this.first_stage_decker2_6_8pm = first_stage_decker2_6_8pm;
}
/**
 * @return the first_stage_decker2_6_12am
 */
public String getFirst_stage_decker2_6_12am() {
	return first_stage_decker2_6_12am;
}
/**
 * @param first_stage_decker2_6_12am the first_stage_decker2_6_12am to set
 */
public void setFirst_stage_decker2_6_12am(String first_stage_decker2_6_12am) {
	this.first_stage_decker2_6_12am = first_stage_decker2_6_12am;
}
/**
 * @return the first_stage_decker2_6_4am
 */
public String getFirst_stage_decker2_6_4am() {
	return first_stage_decker2_6_4am;
}
/**
 * @param first_stage_decker2_6_4am the first_stage_decker2_6_4am to set
 */
public void setFirst_stage_decker2_6_4am(String first_stage_decker2_6_4am) {
	this.first_stage_decker2_6_4am = first_stage_decker2_6_4am;
}
/**
 * @return the first_stage_decker2_7_freq
 */
public String getFirst_stage_decker2_7_freq() {
	return first_stage_decker2_7_freq;
}
/**
 * @param first_stage_decker2_7_freq the first_stage_decker2_7_freq to set
 */
public void setFirst_stage_decker2_7_freq(String first_stage_decker2_7_freq) {
	this.first_stage_decker2_7_freq = first_stage_decker2_7_freq;
}
/**
 * @return the first_stage_decker2_7_8am
 */
public String getFirst_stage_decker2_7_8am() {
	return first_stage_decker2_7_8am;
}
/**
 * @param first_stage_decker2_7_8am the first_stage_decker2_7_8am to set
 */
public void setFirst_stage_decker2_7_8am(String first_stage_decker2_7_8am) {
	this.first_stage_decker2_7_8am = first_stage_decker2_7_8am;
}
/**
 * @return the first_stage_decker2_7_12pm
 */
public String getFirst_stage_decker2_7_12pm() {
	return first_stage_decker2_7_12pm;
}
/**
 * @param first_stage_decker2_7_12pm the first_stage_decker2_7_12pm to set
 */
public void setFirst_stage_decker2_7_12pm(String first_stage_decker2_7_12pm) {
	this.first_stage_decker2_7_12pm = first_stage_decker2_7_12pm;
}
/**
 * @return the first_stage_decker2_7_4pm
 */
public String getFirst_stage_decker2_7_4pm() {
	return first_stage_decker2_7_4pm;
}
/**
 * @param first_stage_decker2_7_4pm the first_stage_decker2_7_4pm to set
 */
public void setFirst_stage_decker2_7_4pm(String first_stage_decker2_7_4pm) {
	this.first_stage_decker2_7_4pm = first_stage_decker2_7_4pm;
}
/**
 * @return the first_stage_decker2_7_8pm
 */
public String getFirst_stage_decker2_7_8pm() {
	return first_stage_decker2_7_8pm;
}
/**
 * @param first_stage_decker2_7_8pm the first_stage_decker2_7_8pm to set
 */
public void setFirst_stage_decker2_7_8pm(String first_stage_decker2_7_8pm) {
	this.first_stage_decker2_7_8pm = first_stage_decker2_7_8pm;
}
/**
 * @return the first_stage_decker2_7_12am
 */
public String getFirst_stage_decker2_7_12am() {
	return first_stage_decker2_7_12am;
}
/**
 * @param first_stage_decker2_7_12am the first_stage_decker2_7_12am to set
 */
public void setFirst_stage_decker2_7_12am(String first_stage_decker2_7_12am) {
	this.first_stage_decker2_7_12am = first_stage_decker2_7_12am;
}
/**
 * @return the first_stage_decker2_7_4am
 */
public String getFirst_stage_decker2_7_4am() {
	return first_stage_decker2_7_4am;
}
/**
 * @param first_stage_decker2_7_4am the first_stage_decker2_7_4am to set
 */
public void setFirst_stage_decker2_7_4am(String first_stage_decker2_7_4am) {
	this.first_stage_decker2_7_4am = first_stage_decker2_7_4am;
}
/**
 * @return the first_stage_decker2_8_freq
 */
public String getFirst_stage_decker2_8_freq() {
	return first_stage_decker2_8_freq;
}
/**
 * @param first_stage_decker2_8_freq the first_stage_decker2_8_freq to set
 */
public void setFirst_stage_decker2_8_freq(String first_stage_decker2_8_freq) {
	this.first_stage_decker2_8_freq = first_stage_decker2_8_freq;
}
/**
 * @return the first_stage_decker2_8_8am
 */
public String getFirst_stage_decker2_8_8am() {
	return first_stage_decker2_8_8am;
}
/**
 * @param first_stage_decker2_8_8am the first_stage_decker2_8_8am to set
 */
public void setFirst_stage_decker2_8_8am(String first_stage_decker2_8_8am) {
	this.first_stage_decker2_8_8am = first_stage_decker2_8_8am;
}
/**
 * @return the first_stage_decker2_8_12pm
 */
public String getFirst_stage_decker2_8_12pm() {
	return first_stage_decker2_8_12pm;
}
/**
 * @param first_stage_decker2_8_12pm the first_stage_decker2_8_12pm to set
 */
public void setFirst_stage_decker2_8_12pm(String first_stage_decker2_8_12pm) {
	this.first_stage_decker2_8_12pm = first_stage_decker2_8_12pm;
}
/**
 * @return the first_stage_decker2_8_4pm
 */
public String getFirst_stage_decker2_8_4pm() {
	return first_stage_decker2_8_4pm;
}
/**
 * @param first_stage_decker2_8_4pm the first_stage_decker2_8_4pm to set
 */
public void setFirst_stage_decker2_8_4pm(String first_stage_decker2_8_4pm) {
	this.first_stage_decker2_8_4pm = first_stage_decker2_8_4pm;
}
/**
 * @return the first_stage_decker2_8_8pm
 */
public String getFirst_stage_decker2_8_8pm() {
	return first_stage_decker2_8_8pm;
}
/**
 * @param first_stage_decker2_8_8pm the first_stage_decker2_8_8pm to set
 */
public void setFirst_stage_decker2_8_8pm(String first_stage_decker2_8_8pm) {
	this.first_stage_decker2_8_8pm = first_stage_decker2_8_8pm;
}
/**
 * @return the first_stage_decker2_8_12am
 */
public String getFirst_stage_decker2_8_12am() {
	return first_stage_decker2_8_12am;
}
/**
 * @param first_stage_decker2_8_12am the first_stage_decker2_8_12am to set
 */
public void setFirst_stage_decker2_8_12am(String first_stage_decker2_8_12am) {
	this.first_stage_decker2_8_12am = first_stage_decker2_8_12am;
}
/**
 * @return the first_stage_decker2_8_4am
 */
public String getFirst_stage_decker2_8_4am() {
	return first_stage_decker2_8_4am;
}
/**
 * @param first_stage_decker2_8_4am the first_stage_decker2_8_4am to set
 */
public void setFirst_stage_decker2_8_4am(String first_stage_decker2_8_4am) {
	this.first_stage_decker2_8_4am = first_stage_decker2_8_4am;
}
/**
 * @return the first_stage_decker2_9_freq
 */
public String getFirst_stage_decker2_9_freq() {
	return first_stage_decker2_9_freq;
}
/**
 * @param first_stage_decker2_9_freq the first_stage_decker2_9_freq to set
 */
public void setFirst_stage_decker2_9_freq(String first_stage_decker2_9_freq) {
	this.first_stage_decker2_9_freq = first_stage_decker2_9_freq;
}
/**
 * @return the first_stage_decker2_9_8am
 */
public String getFirst_stage_decker2_9_8am() {
	return first_stage_decker2_9_8am;
}
/**
 * @param first_stage_decker2_9_8am the first_stage_decker2_9_8am to set
 */
public void setFirst_stage_decker2_9_8am(String first_stage_decker2_9_8am) {
	this.first_stage_decker2_9_8am = first_stage_decker2_9_8am;
}
/**
 * @return the first_stage_decker2_9_12pm
 */
public String getFirst_stage_decker2_9_12pm() {
	return first_stage_decker2_9_12pm;
}
/**
 * @param first_stage_decker2_9_12pm the first_stage_decker2_9_12pm to set
 */
public void setFirst_stage_decker2_9_12pm(String first_stage_decker2_9_12pm) {
	this.first_stage_decker2_9_12pm = first_stage_decker2_9_12pm;
}
/**
 * @return the first_stage_decker2_9_4pm
 */
public String getFirst_stage_decker2_9_4pm() {
	return first_stage_decker2_9_4pm;
}
/**
 * @param first_stage_decker2_9_4pm the first_stage_decker2_9_4pm to set
 */
public void setFirst_stage_decker2_9_4pm(String first_stage_decker2_9_4pm) {
	this.first_stage_decker2_9_4pm = first_stage_decker2_9_4pm;
}
/**
 * @return the first_stage_decker2_9_8pm
 */
public String getFirst_stage_decker2_9_8pm() {
	return first_stage_decker2_9_8pm;
}
/**
 * @param first_stage_decker2_9_8pm the first_stage_decker2_9_8pm to set
 */
public void setFirst_stage_decker2_9_8pm(String first_stage_decker2_9_8pm) {
	this.first_stage_decker2_9_8pm = first_stage_decker2_9_8pm;
}
/**
 * @return the first_stage_decker2_9_12am
 */
public String getFirst_stage_decker2_9_12am() {
	return first_stage_decker2_9_12am;
}
/**
 * @param first_stage_decker2_9_12am the first_stage_decker2_9_12am to set
 */
public void setFirst_stage_decker2_9_12am(String first_stage_decker2_9_12am) {
	this.first_stage_decker2_9_12am = first_stage_decker2_9_12am;
}
/**
 * @return the first_stage_decker2_9_4am
 */
public String getFirst_stage_decker2_9_4am() {
	return first_stage_decker2_9_4am;
}
/**
 * @param first_stage_decker2_9_4am the first_stage_decker2_9_4am to set
 */
public void setFirst_stage_decker2_9_4am(String first_stage_decker2_9_4am) {
	this.first_stage_decker2_9_4am = first_stage_decker2_9_4am;
}
/**
 * @return the first_stage_decker2_10_freq
 */
public String getFirst_stage_decker2_10_freq() {
	return first_stage_decker2_10_freq;
}
/**
 * @param first_stage_decker2_10_freq the first_stage_decker2_10_freq to set
 */
public void setFirst_stage_decker2_10_freq(String first_stage_decker2_10_freq) {
	this.first_stage_decker2_10_freq = first_stage_decker2_10_freq;
}
/**
 * @return the first_stage_decker2_10_8am
 */
public String getFirst_stage_decker2_10_8am() {
	return first_stage_decker2_10_8am;
}
/**
 * @param first_stage_decker2_10_8am the first_stage_decker2_10_8am to set
 */
public void setFirst_stage_decker2_10_8am(String first_stage_decker2_10_8am) {
	this.first_stage_decker2_10_8am = first_stage_decker2_10_8am;
}
/**
 * @return the first_stage_decker2_10_12pm
 */
public String getFirst_stage_decker2_10_12pm() {
	return first_stage_decker2_10_12pm;
}
/**
 * @param first_stage_decker2_10_12pm the first_stage_decker2_10_12pm to set
 */
public void setFirst_stage_decker2_10_12pm(String first_stage_decker2_10_12pm) {
	this.first_stage_decker2_10_12pm = first_stage_decker2_10_12pm;
}
/**
 * @return the first_stage_decker2_10_4pm
 */
public String getFirst_stage_decker2_10_4pm() {
	return first_stage_decker2_10_4pm;
}
/**
 * @param first_stage_decker2_10_4pm the first_stage_decker2_10_4pm to set
 */
public void setFirst_stage_decker2_10_4pm(String first_stage_decker2_10_4pm) {
	this.first_stage_decker2_10_4pm = first_stage_decker2_10_4pm;
}
/**
 * @return the first_stage_decker2_10_8pm
 */
public String getFirst_stage_decker2_10_8pm() {
	return first_stage_decker2_10_8pm;
}
/**
 * @param first_stage_decker2_10_8pm the first_stage_decker2_10_8pm to set
 */
public void setFirst_stage_decker2_10_8pm(String first_stage_decker2_10_8pm) {
	this.first_stage_decker2_10_8pm = first_stage_decker2_10_8pm;
}
/**
 * @return the first_stage_decker2_10_12am
 */
public String getFirst_stage_decker2_10_12am() {
	return first_stage_decker2_10_12am;
}
/**
 * @param first_stage_decker2_10_12am the first_stage_decker2_10_12am to set
 */
public void setFirst_stage_decker2_10_12am(String first_stage_decker2_10_12am) {
	this.first_stage_decker2_10_12am = first_stage_decker2_10_12am;
}
/**
 * @return the first_stage_decker2_10_4am
 */
public String getFirst_stage_decker2_10_4am() {
	return first_stage_decker2_10_4am;
}
/**
 * @param first_stage_decker2_10_4am the first_stage_decker2_10_4am to set
 */
public void setFirst_stage_decker2_10_4am(String first_stage_decker2_10_4am) {
	this.first_stage_decker2_10_4am = first_stage_decker2_10_4am;
}
/**
 * @return the second_stage_decker1_1_freq
 */
public String getSecond_stage_decker1_1_freq() {
	return second_stage_decker1_1_freq;
}
/**
 * @param second_stage_decker1_1_freq the second_stage_decker1_1_freq to set
 */
public void setSecond_stage_decker1_1_freq(String second_stage_decker1_1_freq) {
	this.second_stage_decker1_1_freq = second_stage_decker1_1_freq;
}
/**
 * @return the second_stage_decker1_1_8am
 */
public String getSecond_stage_decker1_1_8am() {
	return second_stage_decker1_1_8am;
}
/**
 * @param second_stage_decker1_1_8am the second_stage_decker1_1_8am to set
 */
public void setSecond_stage_decker1_1_8am(String second_stage_decker1_1_8am) {
	this.second_stage_decker1_1_8am = second_stage_decker1_1_8am;
}
/**
 * @return the second_stage_decker1_1_12pm
 */
public String getSecond_stage_decker1_1_12pm() {
	return second_stage_decker1_1_12pm;
}
/**
 * @param second_stage_decker1_1_12pm the second_stage_decker1_1_12pm to set
 */
public void setSecond_stage_decker1_1_12pm(String second_stage_decker1_1_12pm) {
	this.second_stage_decker1_1_12pm = second_stage_decker1_1_12pm;
}
/**
 * @return the second_stage_decker1_1_4pm
 */
public String getSecond_stage_decker1_1_4pm() {
	return second_stage_decker1_1_4pm;
}
/**
 * @param second_stage_decker1_1_4pm the second_stage_decker1_1_4pm to set
 */
public void setSecond_stage_decker1_1_4pm(String second_stage_decker1_1_4pm) {
	this.second_stage_decker1_1_4pm = second_stage_decker1_1_4pm;
}
/**
 * @return the second_stage_decker1_1_8pm
 */
public String getSecond_stage_decker1_1_8pm() {
	return second_stage_decker1_1_8pm;
}
/**
 * @param second_stage_decker1_1_8pm the second_stage_decker1_1_8pm to set
 */
public void setSecond_stage_decker1_1_8pm(String second_stage_decker1_1_8pm) {
	this.second_stage_decker1_1_8pm = second_stage_decker1_1_8pm;
}
/**
 * @return the second_stage_decker1_1_12am
 */
public String getSecond_stage_decker1_1_12am() {
	return second_stage_decker1_1_12am;
}
/**
 * @param second_stage_decker1_1_12am the second_stage_decker1_1_12am to set
 */
public void setSecond_stage_decker1_1_12am(String second_stage_decker1_1_12am) {
	this.second_stage_decker1_1_12am = second_stage_decker1_1_12am;
}
/**
 * @return the second_stage_decker1_1_4am
 */
public String getSecond_stage_decker1_1_4am() {
	return second_stage_decker1_1_4am;
}
/**
 * @param second_stage_decker1_1_4am the second_stage_decker1_1_4am to set
 */
public void setSecond_stage_decker1_1_4am(String second_stage_decker1_1_4am) {
	this.second_stage_decker1_1_4am = second_stage_decker1_1_4am;
}
/**
 * @return the second_stage_decker1_2_freq
 */
public String getSecond_stage_decker1_2_freq() {
	return second_stage_decker1_2_freq;
}
/**
 * @param second_stage_decker1_2_freq the second_stage_decker1_2_freq to set
 */
public void setSecond_stage_decker1_2_freq(String second_stage_decker1_2_freq) {
	this.second_stage_decker1_2_freq = second_stage_decker1_2_freq;
}
/**
 * @return the second_stage_decker1_2_8am
 */
public String getSecond_stage_decker1_2_8am() {
	return second_stage_decker1_2_8am;
}
/**
 * @param second_stage_decker1_2_8am the second_stage_decker1_2_8am to set
 */
public void setSecond_stage_decker1_2_8am(String second_stage_decker1_2_8am) {
	this.second_stage_decker1_2_8am = second_stage_decker1_2_8am;
}
/**
 * @return the second_stage_decker1_2_12pm
 */
public String getSecond_stage_decker1_2_12pm() {
	return second_stage_decker1_2_12pm;
}
/**
 * @param second_stage_decker1_2_12pm the second_stage_decker1_2_12pm to set
 */
public void setSecond_stage_decker1_2_12pm(String second_stage_decker1_2_12pm) {
	this.second_stage_decker1_2_12pm = second_stage_decker1_2_12pm;
}
/**
 * @return the second_stage_decker1_2_4pm
 */
public String getSecond_stage_decker1_2_4pm() {
	return second_stage_decker1_2_4pm;
}
/**
 * @param second_stage_decker1_2_4pm the second_stage_decker1_2_4pm to set
 */
public void setSecond_stage_decker1_2_4pm(String second_stage_decker1_2_4pm) {
	this.second_stage_decker1_2_4pm = second_stage_decker1_2_4pm;
}
/**
 * @return the second_stage_decker1_2_8pm
 */
public String getSecond_stage_decker1_2_8pm() {
	return second_stage_decker1_2_8pm;
}
/**
 * @param second_stage_decker1_2_8pm the second_stage_decker1_2_8pm to set
 */
public void setSecond_stage_decker1_2_8pm(String second_stage_decker1_2_8pm) {
	this.second_stage_decker1_2_8pm = second_stage_decker1_2_8pm;
}
/**
 * @return the second_stage_decker1_2_12am
 */
public String getSecond_stage_decker1_2_12am() {
	return second_stage_decker1_2_12am;
}
/**
 * @param second_stage_decker1_2_12am the second_stage_decker1_2_12am to set
 */
public void setSecond_stage_decker1_2_12am(String second_stage_decker1_2_12am) {
	this.second_stage_decker1_2_12am = second_stage_decker1_2_12am;
}
/**
 * @return the second_stage_decker1_2_4am
 */
public String getSecond_stage_decker1_2_4am() {
	return second_stage_decker1_2_4am;
}
/**
 * @param second_stage_decker1_2_4am the second_stage_decker1_2_4am to set
 */
public void setSecond_stage_decker1_2_4am(String second_stage_decker1_2_4am) {
	this.second_stage_decker1_2_4am = second_stage_decker1_2_4am;
}
/**
 * @return the second_stage_decker1_3_freq
 */
public String getSecond_stage_decker1_3_freq() {
	return second_stage_decker1_3_freq;
}
/**
 * @param second_stage_decker1_3_freq the second_stage_decker1_3_freq to set
 */
public void setSecond_stage_decker1_3_freq(String second_stage_decker1_3_freq) {
	this.second_stage_decker1_3_freq = second_stage_decker1_3_freq;
}
/**
 * @return the second_stage_decker1_3_8am
 */
public String getSecond_stage_decker1_3_8am() {
	return second_stage_decker1_3_8am;
}
/**
 * @param second_stage_decker1_3_8am the second_stage_decker1_3_8am to set
 */
public void setSecond_stage_decker1_3_8am(String second_stage_decker1_3_8am) {
	this.second_stage_decker1_3_8am = second_stage_decker1_3_8am;
}
/**
 * @return the second_stage_decker1_3_12pm
 */
public String getSecond_stage_decker1_3_12pm() {
	return second_stage_decker1_3_12pm;
}
/**
 * @param second_stage_decker1_3_12pm the second_stage_decker1_3_12pm to set
 */
public void setSecond_stage_decker1_3_12pm(String second_stage_decker1_3_12pm) {
	this.second_stage_decker1_3_12pm = second_stage_decker1_3_12pm;
}
/**
 * @return the second_stage_decker1_3_4pm
 */
public String getSecond_stage_decker1_3_4pm() {
	return second_stage_decker1_3_4pm;
}
/**
 * @param second_stage_decker1_3_4pm the second_stage_decker1_3_4pm to set
 */
public void setSecond_stage_decker1_3_4pm(String second_stage_decker1_3_4pm) {
	this.second_stage_decker1_3_4pm = second_stage_decker1_3_4pm;
}
/**
 * @return the second_stage_decker1_3_8pm
 */
public String getSecond_stage_decker1_3_8pm() {
	return second_stage_decker1_3_8pm;
}
/**
 * @param second_stage_decker1_3_8pm the second_stage_decker1_3_8pm to set
 */
public void setSecond_stage_decker1_3_8pm(String second_stage_decker1_3_8pm) {
	this.second_stage_decker1_3_8pm = second_stage_decker1_3_8pm;
}
/**
 * @return the second_stage_decker1_3_12am
 */
public String getSecond_stage_decker1_3_12am() {
	return second_stage_decker1_3_12am;
}
/**
 * @param second_stage_decker1_3_12am the second_stage_decker1_3_12am to set
 */
public void setSecond_stage_decker1_3_12am(String second_stage_decker1_3_12am) {
	this.second_stage_decker1_3_12am = second_stage_decker1_3_12am;
}
/**
 * @return the second_stage_decker1_3_4am
 */
public String getSecond_stage_decker1_3_4am() {
	return second_stage_decker1_3_4am;
}
/**
 * @param second_stage_decker1_3_4am the second_stage_decker1_3_4am to set
 */
public void setSecond_stage_decker1_3_4am(String second_stage_decker1_3_4am) {
	this.second_stage_decker1_3_4am = second_stage_decker1_3_4am;
}
/**
 * @return the second_stage_decker1_4_freq
 */
public String getSecond_stage_decker1_4_freq() {
	return second_stage_decker1_4_freq;
}
/**
 * @param second_stage_decker1_4_freq the second_stage_decker1_4_freq to set
 */
public void setSecond_stage_decker1_4_freq(String second_stage_decker1_4_freq) {
	this.second_stage_decker1_4_freq = second_stage_decker1_4_freq;
}
/**
 * @return the second_stage_decker1_4_8am
 */
public String getSecond_stage_decker1_4_8am() {
	return second_stage_decker1_4_8am;
}
/**
 * @param second_stage_decker1_4_8am the second_stage_decker1_4_8am to set
 */
public void setSecond_stage_decker1_4_8am(String second_stage_decker1_4_8am) {
	this.second_stage_decker1_4_8am = second_stage_decker1_4_8am;
}
/**
 * @return the second_stage_decker1_4_12pm
 */
public String getSecond_stage_decker1_4_12pm() {
	return second_stage_decker1_4_12pm;
}
/**
 * @param second_stage_decker1_4_12pm the second_stage_decker1_4_12pm to set
 */
public void setSecond_stage_decker1_4_12pm(String second_stage_decker1_4_12pm) {
	this.second_stage_decker1_4_12pm = second_stage_decker1_4_12pm;
}
/**
 * @return the second_stage_decker1_4_4pm
 */
public String getSecond_stage_decker1_4_4pm() {
	return second_stage_decker1_4_4pm;
}
/**
 * @param second_stage_decker1_4_4pm the second_stage_decker1_4_4pm to set
 */
public void setSecond_stage_decker1_4_4pm(String second_stage_decker1_4_4pm) {
	this.second_stage_decker1_4_4pm = second_stage_decker1_4_4pm;
}
/**
 * @return the second_stage_decker1_4_8pm
 */
public String getSecond_stage_decker1_4_8pm() {
	return second_stage_decker1_4_8pm;
}
/**
 * @param second_stage_decker1_4_8pm the second_stage_decker1_4_8pm to set
 */
public void setSecond_stage_decker1_4_8pm(String second_stage_decker1_4_8pm) {
	this.second_stage_decker1_4_8pm = second_stage_decker1_4_8pm;
}
/**
 * @return the second_stage_decker1_4_12am
 */
public String getSecond_stage_decker1_4_12am() {
	return second_stage_decker1_4_12am;
}
/**
 * @param second_stage_decker1_4_12am the second_stage_decker1_4_12am to set
 */
public void setSecond_stage_decker1_4_12am(String second_stage_decker1_4_12am) {
	this.second_stage_decker1_4_12am = second_stage_decker1_4_12am;
}
/**
 * @return the second_stage_decker1_4_4am
 */
public String getSecond_stage_decker1_4_4am() {
	return second_stage_decker1_4_4am;
}
/**
 * @param second_stage_decker1_4_4am the second_stage_decker1_4_4am to set
 */
public void setSecond_stage_decker1_4_4am(String second_stage_decker1_4_4am) {
	this.second_stage_decker1_4_4am = second_stage_decker1_4_4am;
}
/**
 * @return the second_stage_decker1_5_freq
 */
public String getSecond_stage_decker1_5_freq() {
	return second_stage_decker1_5_freq;
}
/**
 * @param second_stage_decker1_5_freq the second_stage_decker1_5_freq to set
 */
public void setSecond_stage_decker1_5_freq(String second_stage_decker1_5_freq) {
	this.second_stage_decker1_5_freq = second_stage_decker1_5_freq;
}
/**
 * @return the second_stage_decker1_5_8am
 */
public String getSecond_stage_decker1_5_8am() {
	return second_stage_decker1_5_8am;
}
/**
 * @param second_stage_decker1_5_8am the second_stage_decker1_5_8am to set
 */
public void setSecond_stage_decker1_5_8am(String second_stage_decker1_5_8am) {
	this.second_stage_decker1_5_8am = second_stage_decker1_5_8am;
}
/**
 * @return the second_stage_decker1_5_12pm
 */
public String getSecond_stage_decker1_5_12pm() {
	return second_stage_decker1_5_12pm;
}
/**
 * @param second_stage_decker1_5_12pm the second_stage_decker1_5_12pm to set
 */
public void setSecond_stage_decker1_5_12pm(String second_stage_decker1_5_12pm) {
	this.second_stage_decker1_5_12pm = second_stage_decker1_5_12pm;
}
/**
 * @return the second_stage_decker1_5_4pm
 */
public String getSecond_stage_decker1_5_4pm() {
	return second_stage_decker1_5_4pm;
}
/**
 * @param second_stage_decker1_5_4pm the second_stage_decker1_5_4pm to set
 */
public void setSecond_stage_decker1_5_4pm(String second_stage_decker1_5_4pm) {
	this.second_stage_decker1_5_4pm = second_stage_decker1_5_4pm;
}
/**
 * @return the second_stage_decker1_5_8pm
 */
public String getSecond_stage_decker1_5_8pm() {
	return second_stage_decker1_5_8pm;
}
/**
 * @param second_stage_decker1_5_8pm the second_stage_decker1_5_8pm to set
 */
public void setSecond_stage_decker1_5_8pm(String second_stage_decker1_5_8pm) {
	this.second_stage_decker1_5_8pm = second_stage_decker1_5_8pm;
}
/**
 * @return the second_stage_decker1_5_12am
 */
public String getSecond_stage_decker1_5_12am() {
	return second_stage_decker1_5_12am;
}
/**
 * @param second_stage_decker1_5_12am the second_stage_decker1_5_12am to set
 */
public void setSecond_stage_decker1_5_12am(String second_stage_decker1_5_12am) {
	this.second_stage_decker1_5_12am = second_stage_decker1_5_12am;
}
/**
 * @return the second_stage_decker1_5_4am
 */
public String getSecond_stage_decker1_5_4am() {
	return second_stage_decker1_5_4am;
}
/**
 * @param second_stage_decker1_5_4am the second_stage_decker1_5_4am to set
 */
public void setSecond_stage_decker1_5_4am(String second_stage_decker1_5_4am) {
	this.second_stage_decker1_5_4am = second_stage_decker1_5_4am;
}
/**
 * @return the second_stage_decker1_6_freq
 */
public String getSecond_stage_decker1_6_freq() {
	return second_stage_decker1_6_freq;
}
/**
 * @param second_stage_decker1_6_freq the second_stage_decker1_6_freq to set
 */
public void setSecond_stage_decker1_6_freq(String second_stage_decker1_6_freq) {
	this.second_stage_decker1_6_freq = second_stage_decker1_6_freq;
}
/**
 * @return the second_stage_decker1_6_8am
 */
public String getSecond_stage_decker1_6_8am() {
	return second_stage_decker1_6_8am;
}
/**
 * @param second_stage_decker1_6_8am the second_stage_decker1_6_8am to set
 */
public void setSecond_stage_decker1_6_8am(String second_stage_decker1_6_8am) {
	this.second_stage_decker1_6_8am = second_stage_decker1_6_8am;
}
/**
 * @return the second_stage_decker1_6_12pm
 */
public String getSecond_stage_decker1_6_12pm() {
	return second_stage_decker1_6_12pm;
}
/**
 * @param second_stage_decker1_6_12pm the second_stage_decker1_6_12pm to set
 */
public void setSecond_stage_decker1_6_12pm(String second_stage_decker1_6_12pm) {
	this.second_stage_decker1_6_12pm = second_stage_decker1_6_12pm;
}
/**
 * @return the second_stage_decker1_6_4pm
 */
public String getSecond_stage_decker1_6_4pm() {
	return second_stage_decker1_6_4pm;
}
/**
 * @param second_stage_decker1_6_4pm the second_stage_decker1_6_4pm to set
 */
public void setSecond_stage_decker1_6_4pm(String second_stage_decker1_6_4pm) {
	this.second_stage_decker1_6_4pm = second_stage_decker1_6_4pm;
}
/**
 * @return the second_stage_decker1_6_8pm
 */
public String getSecond_stage_decker1_6_8pm() {
	return second_stage_decker1_6_8pm;
}
/**
 * @param second_stage_decker1_6_8pm the second_stage_decker1_6_8pm to set
 */
public void setSecond_stage_decker1_6_8pm(String second_stage_decker1_6_8pm) {
	this.second_stage_decker1_6_8pm = second_stage_decker1_6_8pm;
}
/**
 * @return the second_stage_decker1_6_12am
 */
public String getSecond_stage_decker1_6_12am() {
	return second_stage_decker1_6_12am;
}
/**
 * @param second_stage_decker1_6_12am the second_stage_decker1_6_12am to set
 */
public void setSecond_stage_decker1_6_12am(String second_stage_decker1_6_12am) {
	this.second_stage_decker1_6_12am = second_stage_decker1_6_12am;
}
/**
 * @return the second_stage_decker1_6_4am
 */
public String getSecond_stage_decker1_6_4am() {
	return second_stage_decker1_6_4am;
}
/**
 * @param second_stage_decker1_6_4am the second_stage_decker1_6_4am to set
 */
public void setSecond_stage_decker1_6_4am(String second_stage_decker1_6_4am) {
	this.second_stage_decker1_6_4am = second_stage_decker1_6_4am;
}
/**
 * @return the second_stage_decker1_7_freq
 */
public String getSecond_stage_decker1_7_freq() {
	return second_stage_decker1_7_freq;
}
/**
 * @param second_stage_decker1_7_freq the second_stage_decker1_7_freq to set
 */
public void setSecond_stage_decker1_7_freq(String second_stage_decker1_7_freq) {
	this.second_stage_decker1_7_freq = second_stage_decker1_7_freq;
}
/**
 * @return the second_stage_decker1_7_8am
 */
public String getSecond_stage_decker1_7_8am() {
	return second_stage_decker1_7_8am;
}
/**
 * @param second_stage_decker1_7_8am the second_stage_decker1_7_8am to set
 */
public void setSecond_stage_decker1_7_8am(String second_stage_decker1_7_8am) {
	this.second_stage_decker1_7_8am = second_stage_decker1_7_8am;
}
/**
 * @return the second_stage_decker1_7_12pm
 */
public String getSecond_stage_decker1_7_12pm() {
	return second_stage_decker1_7_12pm;
}
/**
 * @param second_stage_decker1_7_12pm the second_stage_decker1_7_12pm to set
 */
public void setSecond_stage_decker1_7_12pm(String second_stage_decker1_7_12pm) {
	this.second_stage_decker1_7_12pm = second_stage_decker1_7_12pm;
}
/**
 * @return the second_stage_decker1_7_4pm
 */
public String getSecond_stage_decker1_7_4pm() {
	return second_stage_decker1_7_4pm;
}
/**
 * @param second_stage_decker1_7_4pm the second_stage_decker1_7_4pm to set
 */
public void setSecond_stage_decker1_7_4pm(String second_stage_decker1_7_4pm) {
	this.second_stage_decker1_7_4pm = second_stage_decker1_7_4pm;
}
/**
 * @return the second_stage_decker1_7_8pm
 */
public String getSecond_stage_decker1_7_8pm() {
	return second_stage_decker1_7_8pm;
}
/**
 * @param second_stage_decker1_7_8pm the second_stage_decker1_7_8pm to set
 */
public void setSecond_stage_decker1_7_8pm(String second_stage_decker1_7_8pm) {
	this.second_stage_decker1_7_8pm = second_stage_decker1_7_8pm;
}
/**
 * @return the second_stage_decker1_7_12am
 */
public String getSecond_stage_decker1_7_12am() {
	return second_stage_decker1_7_12am;
}
/**
 * @param second_stage_decker1_7_12am the second_stage_decker1_7_12am to set
 */
public void setSecond_stage_decker1_7_12am(String second_stage_decker1_7_12am) {
	this.second_stage_decker1_7_12am = second_stage_decker1_7_12am;
}
/**
 * @return the second_stage_decker1_7_4am
 */
public String getSecond_stage_decker1_7_4am() {
	return second_stage_decker1_7_4am;
}
/**
 * @param second_stage_decker1_7_4am the second_stage_decker1_7_4am to set
 */
public void setSecond_stage_decker1_7_4am(String second_stage_decker1_7_4am) {
	this.second_stage_decker1_7_4am = second_stage_decker1_7_4am;
}
/**
 * @return the second_stage_decker1_8_freq
 */
public String getSecond_stage_decker1_8_freq() {
	return second_stage_decker1_8_freq;
}
/**
 * @param second_stage_decker1_8_freq the second_stage_decker1_8_freq to set
 */
public void setSecond_stage_decker1_8_freq(String second_stage_decker1_8_freq) {
	this.second_stage_decker1_8_freq = second_stage_decker1_8_freq;
}
/**
 * @return the second_stage_decker1_8_8am
 */
public String getSecond_stage_decker1_8_8am() {
	return second_stage_decker1_8_8am;
}
/**
 * @param second_stage_decker1_8_8am the second_stage_decker1_8_8am to set
 */
public void setSecond_stage_decker1_8_8am(String second_stage_decker1_8_8am) {
	this.second_stage_decker1_8_8am = second_stage_decker1_8_8am;
}
/**
 * @return the second_stage_decker1_8_12pm
 */
public String getSecond_stage_decker1_8_12pm() {
	return second_stage_decker1_8_12pm;
}
/**
 * @param second_stage_decker1_8_12pm the second_stage_decker1_8_12pm to set
 */
public void setSecond_stage_decker1_8_12pm(String second_stage_decker1_8_12pm) {
	this.second_stage_decker1_8_12pm = second_stage_decker1_8_12pm;
}
/**
 * @return the second_stage_decker1_8_4pm
 */
public String getSecond_stage_decker1_8_4pm() {
	return second_stage_decker1_8_4pm;
}
/**
 * @param second_stage_decker1_8_4pm the second_stage_decker1_8_4pm to set
 */
public void setSecond_stage_decker1_8_4pm(String second_stage_decker1_8_4pm) {
	this.second_stage_decker1_8_4pm = second_stage_decker1_8_4pm;
}
/**
 * @return the second_stage_decker1_8_8pm
 */
public String getSecond_stage_decker1_8_8pm() {
	return second_stage_decker1_8_8pm;
}
/**
 * @param second_stage_decker1_8_8pm the second_stage_decker1_8_8pm to set
 */
public void setSecond_stage_decker1_8_8pm(String second_stage_decker1_8_8pm) {
	this.second_stage_decker1_8_8pm = second_stage_decker1_8_8pm;
}
/**
 * @return the second_stage_decker1_8_12am
 */
public String getSecond_stage_decker1_8_12am() {
	return second_stage_decker1_8_12am;
}
/**
 * @param second_stage_decker1_8_12am the second_stage_decker1_8_12am to set
 */
public void setSecond_stage_decker1_8_12am(String second_stage_decker1_8_12am) {
	this.second_stage_decker1_8_12am = second_stage_decker1_8_12am;
}
/**
 * @return the second_stage_decker1_8_4am
 */
public String getSecond_stage_decker1_8_4am() {
	return second_stage_decker1_8_4am;
}
/**
 * @param second_stage_decker1_8_4am the second_stage_decker1_8_4am to set
 */
public void setSecond_stage_decker1_8_4am(String second_stage_decker1_8_4am) {
	this.second_stage_decker1_8_4am = second_stage_decker1_8_4am;
}
/**
 * @return the second_stage_decker1_9_freq
 */
public String getSecond_stage_decker1_9_freq() {
	return second_stage_decker1_9_freq;
}
/**
 * @param second_stage_decker1_9_freq the second_stage_decker1_9_freq to set
 */
public void setSecond_stage_decker1_9_freq(String second_stage_decker1_9_freq) {
	this.second_stage_decker1_9_freq = second_stage_decker1_9_freq;
}
/**
 * @return the second_stage_decker1_9_8am
 */
public String getSecond_stage_decker1_9_8am() {
	return second_stage_decker1_9_8am;
}
/**
 * @param second_stage_decker1_9_8am the second_stage_decker1_9_8am to set
 */
public void setSecond_stage_decker1_9_8am(String second_stage_decker1_9_8am) {
	this.second_stage_decker1_9_8am = second_stage_decker1_9_8am;
}
/**
 * @return the second_stage_decker1_9_12pm
 */
public String getSecond_stage_decker1_9_12pm() {
	return second_stage_decker1_9_12pm;
}
/**
 * @param second_stage_decker1_9_12pm the second_stage_decker1_9_12pm to set
 */
public void setSecond_stage_decker1_9_12pm(String second_stage_decker1_9_12pm) {
	this.second_stage_decker1_9_12pm = second_stage_decker1_9_12pm;
}
/**
 * @return the second_stage_decker1_9_4pm
 */
public String getSecond_stage_decker1_9_4pm() {
	return second_stage_decker1_9_4pm;
}
/**
 * @param second_stage_decker1_9_4pm the second_stage_decker1_9_4pm to set
 */
public void setSecond_stage_decker1_9_4pm(String second_stage_decker1_9_4pm) {
	this.second_stage_decker1_9_4pm = second_stage_decker1_9_4pm;
}
/**
 * @return the second_stage_decker1_9_8pm
 */
public String getSecond_stage_decker1_9_8pm() {
	return second_stage_decker1_9_8pm;
}
/**
 * @param second_stage_decker1_9_8pm the second_stage_decker1_9_8pm to set
 */
public void setSecond_stage_decker1_9_8pm(String second_stage_decker1_9_8pm) {
	this.second_stage_decker1_9_8pm = second_stage_decker1_9_8pm;
}
/**
 * @return the second_stage_decker1_9_12am
 */
public String getSecond_stage_decker1_9_12am() {
	return second_stage_decker1_9_12am;
}
/**
 * @param second_stage_decker1_9_12am the second_stage_decker1_9_12am to set
 */
public void setSecond_stage_decker1_9_12am(String second_stage_decker1_9_12am) {
	this.second_stage_decker1_9_12am = second_stage_decker1_9_12am;
}
/**
 * @return the second_stage_decker1_9_4am
 */
public String getSecond_stage_decker1_9_4am() {
	return second_stage_decker1_9_4am;
}
/**
 * @param second_stage_decker1_9_4am the second_stage_decker1_9_4am to set
 */
public void setSecond_stage_decker1_9_4am(String second_stage_decker1_9_4am) {
	this.second_stage_decker1_9_4am = second_stage_decker1_9_4am;
}
/**
 * @return the second_stage_decker1_10_freq
 */
public String getSecond_stage_decker1_10_freq() {
	return second_stage_decker1_10_freq;
}
/**
 * @param second_stage_decker1_10_freq the second_stage_decker1_10_freq to set
 */
public void setSecond_stage_decker1_10_freq(String second_stage_decker1_10_freq) {
	this.second_stage_decker1_10_freq = second_stage_decker1_10_freq;
}
/**
 * @return the second_stage_decker1_10_8am
 */
public String getSecond_stage_decker1_10_8am() {
	return second_stage_decker1_10_8am;
}
/**
 * @param second_stage_decker1_10_8am the second_stage_decker1_10_8am to set
 */
public void setSecond_stage_decker1_10_8am(String second_stage_decker1_10_8am) {
	this.second_stage_decker1_10_8am = second_stage_decker1_10_8am;
}
/**
 * @return the second_stage_decker1_10_12pm
 */
public String getSecond_stage_decker1_10_12pm() {
	return second_stage_decker1_10_12pm;
}
/**
 * @param second_stage_decker1_10_12pm the second_stage_decker1_10_12pm to set
 */
public void setSecond_stage_decker1_10_12pm(String second_stage_decker1_10_12pm) {
	this.second_stage_decker1_10_12pm = second_stage_decker1_10_12pm;
}
/**
 * @return the second_stage_decker1_10_4pm
 */
public String getSecond_stage_decker1_10_4pm() {
	return second_stage_decker1_10_4pm;
}
/**
 * @param second_stage_decker1_10_4pm the second_stage_decker1_10_4pm to set
 */
public void setSecond_stage_decker1_10_4pm(String second_stage_decker1_10_4pm) {
	this.second_stage_decker1_10_4pm = second_stage_decker1_10_4pm;
}
/**
 * @return the second_stage_decker1_10_8pm
 */
public String getSecond_stage_decker1_10_8pm() {
	return second_stage_decker1_10_8pm;
}
/**
 * @param second_stage_decker1_10_8pm the second_stage_decker1_10_8pm to set
 */
public void setSecond_stage_decker1_10_8pm(String second_stage_decker1_10_8pm) {
	this.second_stage_decker1_10_8pm = second_stage_decker1_10_8pm;
}
/**
 * @return the second_stage_decker1_10_12am
 */
public String getSecond_stage_decker1_10_12am() {
	return second_stage_decker1_10_12am;
}
/**
 * @param second_stage_decker1_10_12am the second_stage_decker1_10_12am to set
 */
public void setSecond_stage_decker1_10_12am(String second_stage_decker1_10_12am) {
	this.second_stage_decker1_10_12am = second_stage_decker1_10_12am;
}
/**
 * @return the second_stage_decker1_10_4am
 */
public String getSecond_stage_decker1_10_4am() {
	return second_stage_decker1_10_4am;
}
/**
 * @param second_stage_decker1_10_4am the second_stage_decker1_10_4am to set
 */
public void setSecond_stage_decker1_10_4am(String second_stage_decker1_10_4am) {
	this.second_stage_decker1_10_4am = second_stage_decker1_10_4am;
}
/**
 * @return the second_stage_decker2_1_freq
 */
public String getSecond_stage_decker2_1_freq() {
	return second_stage_decker2_1_freq;
}
/**
 * @param second_stage_decker2_1_freq the second_stage_decker2_1_freq to set
 */
public void setSecond_stage_decker2_1_freq(String second_stage_decker2_1_freq) {
	this.second_stage_decker2_1_freq = second_stage_decker2_1_freq;
}
/**
 * @return the second_stage_decker2_1_8am
 */
public String getSecond_stage_decker2_1_8am() {
	return second_stage_decker2_1_8am;
}
/**
 * @param second_stage_decker2_1_8am the second_stage_decker2_1_8am to set
 */
public void setSecond_stage_decker2_1_8am(String second_stage_decker2_1_8am) {
	this.second_stage_decker2_1_8am = second_stage_decker2_1_8am;
}
/**
 * @return the second_stage_decker2_1_12pm
 */
public String getSecond_stage_decker2_1_12pm() {
	return second_stage_decker2_1_12pm;
}
/**
 * @param second_stage_decker2_1_12pm the second_stage_decker2_1_12pm to set
 */
public void setSecond_stage_decker2_1_12pm(String second_stage_decker2_1_12pm) {
	this.second_stage_decker2_1_12pm = second_stage_decker2_1_12pm;
}
/**
 * @return the second_stage_decker2_1_4pm
 */
public String getSecond_stage_decker2_1_4pm() {
	return second_stage_decker2_1_4pm;
}
/**
 * @param second_stage_decker2_1_4pm the second_stage_decker2_1_4pm to set
 */
public void setSecond_stage_decker2_1_4pm(String second_stage_decker2_1_4pm) {
	this.second_stage_decker2_1_4pm = second_stage_decker2_1_4pm;
}
/**
 * @return the second_stage_decker2_1_8pm
 */
public String getSecond_stage_decker2_1_8pm() {
	return second_stage_decker2_1_8pm;
}
/**
 * @param second_stage_decker2_1_8pm the second_stage_decker2_1_8pm to set
 */
public void setSecond_stage_decker2_1_8pm(String second_stage_decker2_1_8pm) {
	this.second_stage_decker2_1_8pm = second_stage_decker2_1_8pm;
}
/**
 * @return the second_stage_decker2_1_12am
 */
public String getSecond_stage_decker2_1_12am() {
	return second_stage_decker2_1_12am;
}
/**
 * @param second_stage_decker2_1_12am the second_stage_decker2_1_12am to set
 */
public void setSecond_stage_decker2_1_12am(String second_stage_decker2_1_12am) {
	this.second_stage_decker2_1_12am = second_stage_decker2_1_12am;
}
/**
 * @return the second_stage_decker2_1_4am
 */
public String getSecond_stage_decker2_1_4am() {
	return second_stage_decker2_1_4am;
}
/**
 * @param second_stage_decker2_1_4am the second_stage_decker2_1_4am to set
 */
public void setSecond_stage_decker2_1_4am(String second_stage_decker2_1_4am) {
	this.second_stage_decker2_1_4am = second_stage_decker2_1_4am;
}
/**
 * @return the second_stage_decker2_2_freq
 */
public String getSecond_stage_decker2_2_freq() {
	return second_stage_decker2_2_freq;
}
/**
 * @param second_stage_decker2_2_freq the second_stage_decker2_2_freq to set
 */
public void setSecond_stage_decker2_2_freq(String second_stage_decker2_2_freq) {
	this.second_stage_decker2_2_freq = second_stage_decker2_2_freq;
}
/**
 * @return the second_stage_decker2_2_8am
 */
public String getSecond_stage_decker2_2_8am() {
	return second_stage_decker2_2_8am;
}
/**
 * @param second_stage_decker2_2_8am the second_stage_decker2_2_8am to set
 */
public void setSecond_stage_decker2_2_8am(String second_stage_decker2_2_8am) {
	this.second_stage_decker2_2_8am = second_stage_decker2_2_8am;
}
/**
 * @return the second_stage_decker2_2_12pm
 */
public String getSecond_stage_decker2_2_12pm() {
	return second_stage_decker2_2_12pm;
}
/**
 * @param second_stage_decker2_2_12pm the second_stage_decker2_2_12pm to set
 */
public void setSecond_stage_decker2_2_12pm(String second_stage_decker2_2_12pm) {
	this.second_stage_decker2_2_12pm = second_stage_decker2_2_12pm;
}
/**
 * @return the second_stage_decker2_2_4pm
 */
public String getSecond_stage_decker2_2_4pm() {
	return second_stage_decker2_2_4pm;
}
/**
 * @param second_stage_decker2_2_4pm the second_stage_decker2_2_4pm to set
 */
public void setSecond_stage_decker2_2_4pm(String second_stage_decker2_2_4pm) {
	this.second_stage_decker2_2_4pm = second_stage_decker2_2_4pm;
}
/**
 * @return the second_stage_decker2_2_8pm
 */
public String getSecond_stage_decker2_2_8pm() {
	return second_stage_decker2_2_8pm;
}
/**
 * @param second_stage_decker2_2_8pm the second_stage_decker2_2_8pm to set
 */
public void setSecond_stage_decker2_2_8pm(String second_stage_decker2_2_8pm) {
	this.second_stage_decker2_2_8pm = second_stage_decker2_2_8pm;
}
/**
 * @return the second_stage_decker2_2_12am
 */
public String getSecond_stage_decker2_2_12am() {
	return second_stage_decker2_2_12am;
}
/**
 * @param second_stage_decker2_2_12am the second_stage_decker2_2_12am to set
 */
public void setSecond_stage_decker2_2_12am(String second_stage_decker2_2_12am) {
	this.second_stage_decker2_2_12am = second_stage_decker2_2_12am;
}
/**
 * @return the second_stage_decker2_2_4am
 */
public String getSecond_stage_decker2_2_4am() {
	return second_stage_decker2_2_4am;
}
/**
 * @param second_stage_decker2_2_4am the second_stage_decker2_2_4am to set
 */
public void setSecond_stage_decker2_2_4am(String second_stage_decker2_2_4am) {
	this.second_stage_decker2_2_4am = second_stage_decker2_2_4am;
}
/**
 * @return the second_stage_decker2_3_freq
 */
public String getSecond_stage_decker2_3_freq() {
	return second_stage_decker2_3_freq;
}
/**
 * @param second_stage_decker2_3_freq the second_stage_decker2_3_freq to set
 */
public void setSecond_stage_decker2_3_freq(String second_stage_decker2_3_freq) {
	this.second_stage_decker2_3_freq = second_stage_decker2_3_freq;
}
/**
 * @return the second_stage_decker2_3_8am
 */
public String getSecond_stage_decker2_3_8am() {
	return second_stage_decker2_3_8am;
}
/**
 * @param second_stage_decker2_3_8am the second_stage_decker2_3_8am to set
 */
public void setSecond_stage_decker2_3_8am(String second_stage_decker2_3_8am) {
	this.second_stage_decker2_3_8am = second_stage_decker2_3_8am;
}
/**
 * @return the second_stage_decker2_3_12pm
 */
public String getSecond_stage_decker2_3_12pm() {
	return second_stage_decker2_3_12pm;
}
/**
 * @param second_stage_decker2_3_12pm the second_stage_decker2_3_12pm to set
 */
public void setSecond_stage_decker2_3_12pm(String second_stage_decker2_3_12pm) {
	this.second_stage_decker2_3_12pm = second_stage_decker2_3_12pm;
}
/**
 * @return the second_stage_decker2_3_4pm
 */
public String getSecond_stage_decker2_3_4pm() {
	return second_stage_decker2_3_4pm;
}
/**
 * @param second_stage_decker2_3_4pm the second_stage_decker2_3_4pm to set
 */
public void setSecond_stage_decker2_3_4pm(String second_stage_decker2_3_4pm) {
	this.second_stage_decker2_3_4pm = second_stage_decker2_3_4pm;
}
/**
 * @return the second_stage_decker2_3_8pm
 */
public String getSecond_stage_decker2_3_8pm() {
	return second_stage_decker2_3_8pm;
}
/**
 * @param second_stage_decker2_3_8pm the second_stage_decker2_3_8pm to set
 */
public void setSecond_stage_decker2_3_8pm(String second_stage_decker2_3_8pm) {
	this.second_stage_decker2_3_8pm = second_stage_decker2_3_8pm;
}
/**
 * @return the second_stage_decker2_3_12am
 */
public String getSecond_stage_decker2_3_12am() {
	return second_stage_decker2_3_12am;
}
/**
 * @param second_stage_decker2_3_12am the second_stage_decker2_3_12am to set
 */
public void setSecond_stage_decker2_3_12am(String second_stage_decker2_3_12am) {
	this.second_stage_decker2_3_12am = second_stage_decker2_3_12am;
}
/**
 * @return the second_stage_decker2_3_4am
 */
public String getSecond_stage_decker2_3_4am() {
	return second_stage_decker2_3_4am;
}
/**
 * @param second_stage_decker2_3_4am the second_stage_decker2_3_4am to set
 */
public void setSecond_stage_decker2_3_4am(String second_stage_decker2_3_4am) {
	this.second_stage_decker2_3_4am = second_stage_decker2_3_4am;
}
/**
 * @return the second_stage_decker2_4_freq
 */
public String getSecond_stage_decker2_4_freq() {
	return second_stage_decker2_4_freq;
}
/**
 * @param second_stage_decker2_4_freq the second_stage_decker2_4_freq to set
 */
public void setSecond_stage_decker2_4_freq(String second_stage_decker2_4_freq) {
	this.second_stage_decker2_4_freq = second_stage_decker2_4_freq;
}
/**
 * @return the second_stage_decker2_4_8am
 */
public String getSecond_stage_decker2_4_8am() {
	return second_stage_decker2_4_8am;
}
/**
 * @param second_stage_decker2_4_8am the second_stage_decker2_4_8am to set
 */
public void setSecond_stage_decker2_4_8am(String second_stage_decker2_4_8am) {
	this.second_stage_decker2_4_8am = second_stage_decker2_4_8am;
}
/**
 * @return the second_stage_decker2_4_12pm
 */
public String getSecond_stage_decker2_4_12pm() {
	return second_stage_decker2_4_12pm;
}
/**
 * @param second_stage_decker2_4_12pm the second_stage_decker2_4_12pm to set
 */
public void setSecond_stage_decker2_4_12pm(String second_stage_decker2_4_12pm) {
	this.second_stage_decker2_4_12pm = second_stage_decker2_4_12pm;
}
/**
 * @return the second_stage_decker2_4_4pm
 */
public String getSecond_stage_decker2_4_4pm() {
	return second_stage_decker2_4_4pm;
}
/**
 * @param second_stage_decker2_4_4pm the second_stage_decker2_4_4pm to set
 */
public void setSecond_stage_decker2_4_4pm(String second_stage_decker2_4_4pm) {
	this.second_stage_decker2_4_4pm = second_stage_decker2_4_4pm;
}
/**
 * @return the second_stage_decker2_4_8pm
 */
public String getSecond_stage_decker2_4_8pm() {
	return second_stage_decker2_4_8pm;
}
/**
 * @param second_stage_decker2_4_8pm the second_stage_decker2_4_8pm to set
 */
public void setSecond_stage_decker2_4_8pm(String second_stage_decker2_4_8pm) {
	this.second_stage_decker2_4_8pm = second_stage_decker2_4_8pm;
}
/**
 * @return the second_stage_decker2_4_12am
 */
public String getSecond_stage_decker2_4_12am() {
	return second_stage_decker2_4_12am;
}
/**
 * @param second_stage_decker2_4_12am the second_stage_decker2_4_12am to set
 */
public void setSecond_stage_decker2_4_12am(String second_stage_decker2_4_12am) {
	this.second_stage_decker2_4_12am = second_stage_decker2_4_12am;
}
/**
 * @return the second_stage_decker2_4_4am
 */
public String getSecond_stage_decker2_4_4am() {
	return second_stage_decker2_4_4am;
}
/**
 * @param second_stage_decker2_4_4am the second_stage_decker2_4_4am to set
 */
public void setSecond_stage_decker2_4_4am(String second_stage_decker2_4_4am) {
	this.second_stage_decker2_4_4am = second_stage_decker2_4_4am;
}
/**
 * @return the second_stage_decker2_5_freq
 */
public String getSecond_stage_decker2_5_freq() {
	return second_stage_decker2_5_freq;
}
/**
 * @param second_stage_decker2_5_freq the second_stage_decker2_5_freq to set
 */
public void setSecond_stage_decker2_5_freq(String second_stage_decker2_5_freq) {
	this.second_stage_decker2_5_freq = second_stage_decker2_5_freq;
}
/**
 * @return the second_stage_decker2_5_8am
 */
public String getSecond_stage_decker2_5_8am() {
	return second_stage_decker2_5_8am;
}
/**
 * @param second_stage_decker2_5_8am the second_stage_decker2_5_8am to set
 */
public void setSecond_stage_decker2_5_8am(String second_stage_decker2_5_8am) {
	this.second_stage_decker2_5_8am = second_stage_decker2_5_8am;
}
/**
 * @return the second_stage_decker2_5_12pm
 */
public String getSecond_stage_decker2_5_12pm() {
	return second_stage_decker2_5_12pm;
}
/**
 * @param second_stage_decker2_5_12pm the second_stage_decker2_5_12pm to set
 */
public void setSecond_stage_decker2_5_12pm(String second_stage_decker2_5_12pm) {
	this.second_stage_decker2_5_12pm = second_stage_decker2_5_12pm;
}
/**
 * @return the second_stage_decker2_5_4pm
 */
public String getSecond_stage_decker2_5_4pm() {
	return second_stage_decker2_5_4pm;
}
/**
 * @param second_stage_decker2_5_4pm the second_stage_decker2_5_4pm to set
 */
public void setSecond_stage_decker2_5_4pm(String second_stage_decker2_5_4pm) {
	this.second_stage_decker2_5_4pm = second_stage_decker2_5_4pm;
}
/**
 * @return the second_stage_decker2_5_8pm
 */
public String getSecond_stage_decker2_5_8pm() {
	return second_stage_decker2_5_8pm;
}
/**
 * @param second_stage_decker2_5_8pm the second_stage_decker2_5_8pm to set
 */
public void setSecond_stage_decker2_5_8pm(String second_stage_decker2_5_8pm) {
	this.second_stage_decker2_5_8pm = second_stage_decker2_5_8pm;
}
/**
 * @return the second_stage_decker2_5_12am
 */
public String getSecond_stage_decker2_5_12am() {
	return second_stage_decker2_5_12am;
}
/**
 * @param second_stage_decker2_5_12am the second_stage_decker2_5_12am to set
 */
public void setSecond_stage_decker2_5_12am(String second_stage_decker2_5_12am) {
	this.second_stage_decker2_5_12am = second_stage_decker2_5_12am;
}
/**
 * @return the second_stage_decker2_5_4am
 */
public String getSecond_stage_decker2_5_4am() {
	return second_stage_decker2_5_4am;
}
/**
 * @param second_stage_decker2_5_4am the second_stage_decker2_5_4am to set
 */
public void setSecond_stage_decker2_5_4am(String second_stage_decker2_5_4am) {
	this.second_stage_decker2_5_4am = second_stage_decker2_5_4am;
}
/**
 * @return the second_stage_decker2_6_freq
 */
public String getSecond_stage_decker2_6_freq() {
	return second_stage_decker2_6_freq;
}
/**
 * @param second_stage_decker2_6_freq the second_stage_decker2_6_freq to set
 */
public void setSecond_stage_decker2_6_freq(String second_stage_decker2_6_freq) {
	this.second_stage_decker2_6_freq = second_stage_decker2_6_freq;
}
/**
 * @return the second_stage_decker2_6_8am
 */
public String getSecond_stage_decker2_6_8am() {
	return second_stage_decker2_6_8am;
}
/**
 * @param second_stage_decker2_6_8am the second_stage_decker2_6_8am to set
 */
public void setSecond_stage_decker2_6_8am(String second_stage_decker2_6_8am) {
	this.second_stage_decker2_6_8am = second_stage_decker2_6_8am;
}
/**
 * @return the second_stage_decker2_6_12pm
 */
public String getSecond_stage_decker2_6_12pm() {
	return second_stage_decker2_6_12pm;
}
/**
 * @param second_stage_decker2_6_12pm the second_stage_decker2_6_12pm to set
 */
public void setSecond_stage_decker2_6_12pm(String second_stage_decker2_6_12pm) {
	this.second_stage_decker2_6_12pm = second_stage_decker2_6_12pm;
}
/**
 * @return the second_stage_decker2_6_4pm
 */
public String getSecond_stage_decker2_6_4pm() {
	return second_stage_decker2_6_4pm;
}
/**
 * @param second_stage_decker2_6_4pm the second_stage_decker2_6_4pm to set
 */
public void setSecond_stage_decker2_6_4pm(String second_stage_decker2_6_4pm) {
	this.second_stage_decker2_6_4pm = second_stage_decker2_6_4pm;
}
/**
 * @return the second_stage_decker2_6_8pm
 */
public String getSecond_stage_decker2_6_8pm() {
	return second_stage_decker2_6_8pm;
}
/**
 * @param second_stage_decker2_6_8pm the second_stage_decker2_6_8pm to set
 */
public void setSecond_stage_decker2_6_8pm(String second_stage_decker2_6_8pm) {
	this.second_stage_decker2_6_8pm = second_stage_decker2_6_8pm;
}
/**
 * @return the second_stage_decker2_6_12am
 */
public String getSecond_stage_decker2_6_12am() {
	return second_stage_decker2_6_12am;
}
/**
 * @param second_stage_decker2_6_12am the second_stage_decker2_6_12am to set
 */
public void setSecond_stage_decker2_6_12am(String second_stage_decker2_6_12am) {
	this.second_stage_decker2_6_12am = second_stage_decker2_6_12am;
}
/**
 * @return the second_stage_decker2_6_4am
 */
public String getSecond_stage_decker2_6_4am() {
	return second_stage_decker2_6_4am;
}
/**
 * @param second_stage_decker2_6_4am the second_stage_decker2_6_4am to set
 */
public void setSecond_stage_decker2_6_4am(String second_stage_decker2_6_4am) {
	this.second_stage_decker2_6_4am = second_stage_decker2_6_4am;
}
/**
 * @return the second_stage_decker2_7_freq
 */
public String getSecond_stage_decker2_7_freq() {
	return second_stage_decker2_7_freq;
}
/**
 * @param second_stage_decker2_7_freq the second_stage_decker2_7_freq to set
 */
public void setSecond_stage_decker2_7_freq(String second_stage_decker2_7_freq) {
	this.second_stage_decker2_7_freq = second_stage_decker2_7_freq;
}
/**
 * @return the second_stage_decker2_7_8am
 */
public String getSecond_stage_decker2_7_8am() {
	return second_stage_decker2_7_8am;
}
/**
 * @param second_stage_decker2_7_8am the second_stage_decker2_7_8am to set
 */
public void setSecond_stage_decker2_7_8am(String second_stage_decker2_7_8am) {
	this.second_stage_decker2_7_8am = second_stage_decker2_7_8am;
}
/**
 * @return the second_stage_decker2_7_12pm
 */
public String getSecond_stage_decker2_7_12pm() {
	return second_stage_decker2_7_12pm;
}
/**
 * @param second_stage_decker2_7_12pm the second_stage_decker2_7_12pm to set
 */
public void setSecond_stage_decker2_7_12pm(String second_stage_decker2_7_12pm) {
	this.second_stage_decker2_7_12pm = second_stage_decker2_7_12pm;
}
/**
 * @return the second_stage_decker2_7_4pm
 */
public String getSecond_stage_decker2_7_4pm() {
	return second_stage_decker2_7_4pm;
}
/**
 * @param second_stage_decker2_7_4pm the second_stage_decker2_7_4pm to set
 */
public void setSecond_stage_decker2_7_4pm(String second_stage_decker2_7_4pm) {
	this.second_stage_decker2_7_4pm = second_stage_decker2_7_4pm;
}
/**
 * @return the second_stage_decker2_7_8pm
 */
public String getSecond_stage_decker2_7_8pm() {
	return second_stage_decker2_7_8pm;
}
/**
 * @param second_stage_decker2_7_8pm the second_stage_decker2_7_8pm to set
 */
public void setSecond_stage_decker2_7_8pm(String second_stage_decker2_7_8pm) {
	this.second_stage_decker2_7_8pm = second_stage_decker2_7_8pm;
}
/**
 * @return the second_stage_decker2_7_12am
 */
public String getSecond_stage_decker2_7_12am() {
	return second_stage_decker2_7_12am;
}
/**
 * @param second_stage_decker2_7_12am the second_stage_decker2_7_12am to set
 */
public void setSecond_stage_decker2_7_12am(String second_stage_decker2_7_12am) {
	this.second_stage_decker2_7_12am = second_stage_decker2_7_12am;
}
/**
 * @return the second_stage_decker2_7_4am
 */
public String getSecond_stage_decker2_7_4am() {
	return second_stage_decker2_7_4am;
}
/**
 * @param second_stage_decker2_7_4am the second_stage_decker2_7_4am to set
 */
public void setSecond_stage_decker2_7_4am(String second_stage_decker2_7_4am) {
	this.second_stage_decker2_7_4am = second_stage_decker2_7_4am;
}
/**
 * @return the second_stage_decker2_8_freq
 */
public String getSecond_stage_decker2_8_freq() {
	return second_stage_decker2_8_freq;
}
/**
 * @param second_stage_decker2_8_freq the second_stage_decker2_8_freq to set
 */
public void setSecond_stage_decker2_8_freq(String second_stage_decker2_8_freq) {
	this.second_stage_decker2_8_freq = second_stage_decker2_8_freq;
}
/**
 * @return the second_stage_decker2_8_8am
 */
public String getSecond_stage_decker2_8_8am() {
	return second_stage_decker2_8_8am;
}
/**
 * @param second_stage_decker2_8_8am the second_stage_decker2_8_8am to set
 */
public void setSecond_stage_decker2_8_8am(String second_stage_decker2_8_8am) {
	this.second_stage_decker2_8_8am = second_stage_decker2_8_8am;
}
/**
 * @return the second_stage_decker2_8_12pm
 */
public String getSecond_stage_decker2_8_12pm() {
	return second_stage_decker2_8_12pm;
}
/**
 * @param second_stage_decker2_8_12pm the second_stage_decker2_8_12pm to set
 */
public void setSecond_stage_decker2_8_12pm(String second_stage_decker2_8_12pm) {
	this.second_stage_decker2_8_12pm = second_stage_decker2_8_12pm;
}
/**
 * @return the second_stage_decker2_8_4pm
 */
public String getSecond_stage_decker2_8_4pm() {
	return second_stage_decker2_8_4pm;
}
/**
 * @param second_stage_decker2_8_4pm the second_stage_decker2_8_4pm to set
 */
public void setSecond_stage_decker2_8_4pm(String second_stage_decker2_8_4pm) {
	this.second_stage_decker2_8_4pm = second_stage_decker2_8_4pm;
}
/**
 * @return the second_stage_decker2_8_8pm
 */
public String getSecond_stage_decker2_8_8pm() {
	return second_stage_decker2_8_8pm;
}
/**
 * @param second_stage_decker2_8_8pm the second_stage_decker2_8_8pm to set
 */
public void setSecond_stage_decker2_8_8pm(String second_stage_decker2_8_8pm) {
	this.second_stage_decker2_8_8pm = second_stage_decker2_8_8pm;
}
/**
 * @return the second_stage_decker2_8_12am
 */
public String getSecond_stage_decker2_8_12am() {
	return second_stage_decker2_8_12am;
}
/**
 * @param second_stage_decker2_8_12am the second_stage_decker2_8_12am to set
 */
public void setSecond_stage_decker2_8_12am(String second_stage_decker2_8_12am) {
	this.second_stage_decker2_8_12am = second_stage_decker2_8_12am;
}
/**
 * @return the second_stage_decker2_8_4am
 */
public String getSecond_stage_decker2_8_4am() {
	return second_stage_decker2_8_4am;
}
/**
 * @param second_stage_decker2_8_4am the second_stage_decker2_8_4am to set
 */
public void setSecond_stage_decker2_8_4am(String second_stage_decker2_8_4am) {
	this.second_stage_decker2_8_4am = second_stage_decker2_8_4am;
}
/**
 * @return the second_stage_decker2_9_freq
 */
public String getSecond_stage_decker2_9_freq() {
	return second_stage_decker2_9_freq;
}
/**
 * @param second_stage_decker2_9_freq the second_stage_decker2_9_freq to set
 */
public void setSecond_stage_decker2_9_freq(String second_stage_decker2_9_freq) {
	this.second_stage_decker2_9_freq = second_stage_decker2_9_freq;
}
/**
 * @return the second_stage_decker2_9_8am
 */
public String getSecond_stage_decker2_9_8am() {
	return second_stage_decker2_9_8am;
}
/**
 * @param second_stage_decker2_9_8am the second_stage_decker2_9_8am to set
 */
public void setSecond_stage_decker2_9_8am(String second_stage_decker2_9_8am) {
	this.second_stage_decker2_9_8am = second_stage_decker2_9_8am;
}
/**
 * @return the second_stage_decker2_9_12pm
 */
public String getSecond_stage_decker2_9_12pm() {
	return second_stage_decker2_9_12pm;
}
/**
 * @param second_stage_decker2_9_12pm the second_stage_decker2_9_12pm to set
 */
public void setSecond_stage_decker2_9_12pm(String second_stage_decker2_9_12pm) {
	this.second_stage_decker2_9_12pm = second_stage_decker2_9_12pm;
}
/**
 * @return the second_stage_decker2_9_4pm
 */
public String getSecond_stage_decker2_9_4pm() {
	return second_stage_decker2_9_4pm;
}
/**
 * @param second_stage_decker2_9_4pm the second_stage_decker2_9_4pm to set
 */
public void setSecond_stage_decker2_9_4pm(String second_stage_decker2_9_4pm) {
	this.second_stage_decker2_9_4pm = second_stage_decker2_9_4pm;
}
/**
 * @return the second_stage_decker2_9_8pm
 */
public String getSecond_stage_decker2_9_8pm() {
	return second_stage_decker2_9_8pm;
}
/**
 * @param second_stage_decker2_9_8pm the second_stage_decker2_9_8pm to set
 */
public void setSecond_stage_decker2_9_8pm(String second_stage_decker2_9_8pm) {
	this.second_stage_decker2_9_8pm = second_stage_decker2_9_8pm;
}
/**
 * @return the second_stage_decker2_9_12am
 */
public String getSecond_stage_decker2_9_12am() {
	return second_stage_decker2_9_12am;
}
/**
 * @param second_stage_decker2_9_12am the second_stage_decker2_9_12am to set
 */
public void setSecond_stage_decker2_9_12am(String second_stage_decker2_9_12am) {
	this.second_stage_decker2_9_12am = second_stage_decker2_9_12am;
}
/**
 * @return the second_stage_decker2_9_4am
 */
public String getSecond_stage_decker2_9_4am() {
	return second_stage_decker2_9_4am;
}
/**
 * @param second_stage_decker2_9_4am the second_stage_decker2_9_4am to set
 */
public void setSecond_stage_decker2_9_4am(String second_stage_decker2_9_4am) {
	this.second_stage_decker2_9_4am = second_stage_decker2_9_4am;
}
/**
 * @return the second_stage_decker2_10_freq
 */
public String getSecond_stage_decker2_10_freq() {
	return second_stage_decker2_10_freq;
}
/**
 * @param second_stage_decker2_10_freq the second_stage_decker2_10_freq to set
 */
public void setSecond_stage_decker2_10_freq(String second_stage_decker2_10_freq) {
	this.second_stage_decker2_10_freq = second_stage_decker2_10_freq;
}
/**
 * @return the second_stage_decker2_10_8am
 */
public String getSecond_stage_decker2_10_8am() {
	return second_stage_decker2_10_8am;
}
/**
 * @param second_stage_decker2_10_8am the second_stage_decker2_10_8am to set
 */
public void setSecond_stage_decker2_10_8am(String second_stage_decker2_10_8am) {
	this.second_stage_decker2_10_8am = second_stage_decker2_10_8am;
}
/**
 * @return the second_stage_decker2_10_12pm
 */
public String getSecond_stage_decker2_10_12pm() {
	return second_stage_decker2_10_12pm;
}
/**
 * @param second_stage_decker2_10_12pm the second_stage_decker2_10_12pm to set
 */
public void setSecond_stage_decker2_10_12pm(String second_stage_decker2_10_12pm) {
	this.second_stage_decker2_10_12pm = second_stage_decker2_10_12pm;
}
/**
 * @return the second_stage_decker2_10_4pm
 */
public String getSecond_stage_decker2_10_4pm() {
	return second_stage_decker2_10_4pm;
}
/**
 * @param second_stage_decker2_10_4pm the second_stage_decker2_10_4pm to set
 */
public void setSecond_stage_decker2_10_4pm(String second_stage_decker2_10_4pm) {
	this.second_stage_decker2_10_4pm = second_stage_decker2_10_4pm;
}
/**
 * @return the second_stage_decker2_10_8pm
 */
public String getSecond_stage_decker2_10_8pm() {
	return second_stage_decker2_10_8pm;
}
/**
 * @param second_stage_decker2_10_8pm the second_stage_decker2_10_8pm to set
 */
public void setSecond_stage_decker2_10_8pm(String second_stage_decker2_10_8pm) {
	this.second_stage_decker2_10_8pm = second_stage_decker2_10_8pm;
}
/**
 * @return the second_stage_decker2_10_12am
 */
public String getSecond_stage_decker2_10_12am() {
	return second_stage_decker2_10_12am;
}
/**
 * @param second_stage_decker2_10_12am the second_stage_decker2_10_12am to set
 */
public void setSecond_stage_decker2_10_12am(String second_stage_decker2_10_12am) {
	this.second_stage_decker2_10_12am = second_stage_decker2_10_12am;
}
/**
 * @return the second_stage_decker2_10_4am
 */
public String getSecond_stage_decker2_10_4am() {
	return second_stage_decker2_10_4am;
}
/**
 * @param second_stage_decker2_10_4am the second_stage_decker2_10_4am to set
 */
public void setSecond_stage_decker2_10_4am(String second_stage_decker2_10_4am) {
	this.second_stage_decker2_10_4am = second_stage_decker2_10_4am;
}
/**
 * @return the rollup_washup_hosesfreq
 */
public String getRollup_washup_hosesfreq() {
	return rollup_washup_hosesfreq;
}
/**
 * @param rollup_washup_hosesfreq the rollup_washup_hosesfreq to set
 */
public void setRollup_washup_hosesfreq(String rollup_washup_hosesfreq) {
	this.rollup_washup_hosesfreq = rollup_washup_hosesfreq;
}
/**
 * @return the rollup_washup_hoses8am
 */
public String getRollup_washup_hoses8am() {
	return rollup_washup_hoses8am;
}
/**
 * @param rollup_washup_hoses8am the rollup_washup_hoses8am to set
 */
public void setRollup_washup_hoses8am(String rollup_washup_hoses8am) {
	this.rollup_washup_hoses8am = rollup_washup_hoses8am;
}
/**
 * @return the rollup_washup_hoses12pm
 */
public String getRollup_washup_hoses12pm() {
	return rollup_washup_hoses12pm;
}
/**
 * @param rollup_washup_hoses12pm the rollup_washup_hoses12pm to set
 */
public void setRollup_washup_hoses12pm(String rollup_washup_hoses12pm) {
	this.rollup_washup_hoses12pm = rollup_washup_hoses12pm;
}
/**
 * @return the rollup_washup_hoses4pm
 */
public String getRollup_washup_hoses4pm() {
	return rollup_washup_hoses4pm;
}
/**
 * @param rollup_washup_hoses4pm the rollup_washup_hoses4pm to set
 */
public void setRollup_washup_hoses4pm(String rollup_washup_hoses4pm) {
	this.rollup_washup_hoses4pm = rollup_washup_hoses4pm;
}
/**
 * @return the rollup_washup_hoses8pm
 */
public String getRollup_washup_hoses8pm() {
	return rollup_washup_hoses8pm;
}
/**
 * @param rollup_washup_hoses8pm the rollup_washup_hoses8pm to set
 */
public void setRollup_washup_hoses8pm(String rollup_washup_hoses8pm) {
	this.rollup_washup_hoses8pm = rollup_washup_hoses8pm;
}
/**
 * @return the rollup_washup_hoses12am
 */
public String getRollup_washup_hoses12am() {
	return rollup_washup_hoses12am;
}
/**
 * @param rollup_washup_hoses12am the rollup_washup_hoses12am to set
 */
public void setRollup_washup_hoses12am(String rollup_washup_hoses12am) {
	this.rollup_washup_hoses12am = rollup_washup_hoses12am;
}
/**
 * @return the rollup_washup_hoses4am
 */
public String getRollup_washup_hoses4am() {
	return rollup_washup_hoses4am;
}
/**
 * @param rollup_washup_hoses4am the rollup_washup_hoses4am to set
 */
public void setRollup_washup_hoses4am(String rollup_washup_hoses4am) {
	this.rollup_washup_hoses4am = rollup_washup_hoses4am;
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

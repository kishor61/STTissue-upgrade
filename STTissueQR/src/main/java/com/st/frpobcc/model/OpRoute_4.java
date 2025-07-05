/**
 *02-Dec-2019
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
public class OpRoute_4 {
	
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
	private String dumpchests1_freq;
	private String dumpchests1_10am;
	private String dumpchests1_02pm;
	private String dumpchests1_06pm;
	private String dumpchests1_10pm;
	private String dumpchests1_02am;
	private String dumpchests1_06am;
	private String dumpchests2_freq;
	private String dumpchests2_10am;
	private String dumpchests2_02pm;
	private String dumpchests2_06pm;
	private String dumpchests2_10pm;
	private String dumpchests2_02am;
	private String dumpchests2_06am;
	private String dumpchests3_freq;
	private String dumpchests3_10am;
	private String dumpchests3_02pm;
	private String dumpchests3_06pm;
	private String dumpchests3_10pm;
	private String dumpchests3_02am;
	private String dumpchests3_06am;
	private String dumpchests4_freq;
	private String dumpchests4_10am;
	private String dumpchests4_02pm;
	private String dumpchests4_06pm;
	private String dumpchests4_10pm;
	private String dumpchests4_02am;
	private String dumpchests4_06am;
	private String dumpchests5_freq;
	private String dumpchests5_10am;
	private String dumpchests5_02pm;
	private String dumpchests5_06pm;
	private String dumpchests5_10pm;
	private String dumpchests5_02am;
	private String dumpchests5_06am;
	
	private String contaminexpump1_freq;
	private String contaminexpump1_10am;
	private String contaminexpump1_02pm;
	private String contaminexpump1_06pm;
	private String contaminexpump1_10pm;
	private String contaminexpump1_02am;
	private String contaminexpump1_06am;
	private String contaminexpump2_freq;
	private String contaminexpump2_10am;
	private String contaminexpump2_02pm;
	private String contaminexpump2_06pm;
	private String contaminexpump2_10pm;
	private String contaminexpump2_02am;
	private String contaminexpump2_06am;
	private String contaminexpump3_freq;
	private String contaminexpump3_10am;
	private String contaminexpump3_02pm;
	private String contaminexpump3_06pm;
	private String contaminexpump3_10pm;
	private String contaminexpump3_02am;
	private String contaminexpump3_06am;
	
	private String rejectscollectionbunker1_freq;
	private String rejectscollectionbunker1_10am;
	private String rejectscollectionbunker1_02pm;
	private String rejectscollectionbunker1_06pm;
	private String rejectscollectionbunker1_10pm;
	private String rejectscollectionbunker1_02am;
	private String rejectscollectionbunker1_06am;
	private String rejectscollectionbunker2_freq;
	private String rejectscollectionbunker2_10am;
	private String rejectscollectionbunker2_02pm;
	private String rejectscollectionbunker2_06pm;
	private String rejectscollectionbunker2_10pm;
	private String rejectscollectionbunker2_02am;
	private String rejectscollectionbunker2_06am;
	
	private String batchpulperbasement1_freq;
	private String batchpulperbasement1_10am;
	private String batchpulperbasement1_02pm;
	private String batchpulperbasement1_06pm;
	private String batchpulperbasement1_10pm;
	private String batchpulperbasement1_02am;
	private String batchpulperbasement1_06am;
	private String batchpulperbasement2_freq;
	private String batchpulperbasement2_10am;
	private String batchpulperbasement2_02pm;
	private String batchpulperbasement2_06pm;
	private String batchpulperbasement2_10pm;
	private String batchpulperbasement2_02am;
	private String batchpulperbasement2_06am;
	private String batchpulperbasement3_freq;
	private String batchpulperbasement3_10am;
	private String batchpulperbasement3_02pm;
	private String batchpulperbasement3_06pm;
	private String batchpulperbasement3_10pm;
	private String batchpulperbasement3_02am;
	private String batchpulperbasement3_06am;
	private String batchpulperbasement4_freq;
	private String batchpulperbasement4_10am;
	private String batchpulperbasement4_02pm;
	private String batchpulperbasement4_06pm;
	private String batchpulperbasement4_10pm;
	private String batchpulperbasement4_02am;
	private String batchpulperbasement4_06am;
	
	private String detrasher1_freq;
	private String detrasher1_10am;
	private String detrasher1_02pm;
	private String detrasher1_06pm;
	private String detrasher1_10pm;
	private String detrasher1_02am;
	private String detrasher1_06am;
	private String detrasher2_freq;
	private String detrasher2_10am;
	private String detrasher2_02pm;
	private String detrasher2_06pm;
	private String detrasher2_10pm;
	private String detrasher2_02am;
	private String detrasher2_06am;
	private String detrasher3_freq;
	private String detrasher3_10am;
	private String detrasher3_02pm;
	private String detrasher3_06pm;
	private String detrasher3_10pm;
	private String detrasher3_02am;
	private String detrasher3_06am;
	
	private String rejectspress1_freq;
	private String rejectspress1_10am;
	private String rejectspress1_02pm;
	private String rejectspress1_06pm;
	private String rejectspress1_10pm;
	private String rejectspress1_02am;
	private String rejectspress1_06am;
	private String rejectspress2_freq;
	private String rejectspress2_10am;
	private String rejectspress2_02pm;
	private String rejectspress2_06pm;
	private String rejectspress2_10pm;
	private String rejectspress2_02am;
	private String rejectspress2_06am;
	private String rejectspress3_freq;
	private String rejectspress3_10am;
	private String rejectspress3_02pm;
	private String rejectspress3_06pm;
	private String rejectspress3_10pm;
	private String rejectspress3_02am;
	private String rejectspress3_06am;
	
	private String dewateringscrew1_freq;
	private String dewateringscrew1_10am;
	private String dewateringscrew1_02pm;
	private String dewateringscrew1_06pm;
	private String dewateringscrew1_10pm;
	private String dewateringscrew1_02am;
	private String dewateringscrew1_06am;
	private String dewateringscrew2_freq;
	private String dewateringscrew2_10am;
	private String dewateringscrew2_02pm;
	private String dewateringscrew2_06pm;
	private String dewateringscrew2_10pm;
	private String dewateringscrew2_02am;
	private String dewateringscrew2_06am;
	private String dewateringscrew3_freq;
	private String dewateringscrew3_10am;
	private String dewateringscrew3_02pm;
	private String dewateringscrew3_06pm;
	private String dewateringscrew3_10pm;
	private String dewateringscrew3_02am;
	private String dewateringscrew3_06am;
	
	private String clarifiedwaterchest1_freq;
	private String clarifiedwaterchest1_10am;
	private String clarifiedwaterchest1_02pm;
	private String clarifiedwaterchest1_06pm;
	private String clarifiedwaterchest1_10pm;
	private String clarifiedwaterchest1_02am;
	private String clarifiedwaterchest1_06am;
	private String clarifiedwaterchest2_freq;
	private String clarifiedwaterchest2_10am;
	private String clarifiedwaterchest2_02pm;
	private String clarifiedwaterchest2_06pm;
	private String clarifiedwaterchest2_10pm;
	private String clarifiedwaterchest2_02am;
	private String clarifiedwaterchest2_06am;
	
	private String deinkwhitewaterchest1_freq;
	private String deinkwhitewaterchest1_10am;
	private String deinkwhitewaterchest1_02pm;
	private String deinkwhitewaterchest1_06pm;
	private String deinkwhitewaterchest1_10pm;
	private String deinkwhitewaterchest1_02am;
	private String deinkwhitewaterchest1_06am;
	private String deinkwhitewaterchest2_freq;
	private String deinkwhitewaterchest2_10am;
	private String deinkwhitewaterchest2_02pm;
	private String deinkwhitewaterchest2_06pm;
	private String deinkwhitewaterchest2_10pm;
	private String deinkwhitewaterchest2_02am;
	private String deinkwhitewaterchest2_06am;
	private String deinkwhitewaterchest3_freq;
	private String deinkwhitewaterchest3_10am;
	private String deinkwhitewaterchest3_02pm;
	private String deinkwhitewaterchest3_06pm;
	private String deinkwhitewaterchest3_10pm;
	private String deinkwhitewaterchest3_02am;
	private String deinkwhitewaterchest3_06am;
	private String deinkwhitewaterchest4_freq;
	private String deinkwhitewaterchest4_10am;
	private String deinkwhitewaterchest4_02pm;
	private String deinkwhitewaterchest4_06pm;
	private String deinkwhitewaterchest4_10pm;
	private String deinkwhitewaterchest4_02am;
	private String deinkwhitewaterchest4_06am;
	private String deinkwhitewaterchest5_freq;
	private String deinkwhitewaterchest5_10am;
	private String deinkwhitewaterchest5_02pm;
	private String deinkwhitewaterchest5_06pm;
	private String deinkwhitewaterchest5_10pm;
	private String deinkwhitewaterchest5_02am;
	private String deinkwhitewaterchest5_06am;
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
	 * @return the dumpchests1_freq
	 */
	public String getDumpchests1_freq() {
		return dumpchests1_freq;
	}
	/**
	 * @param dumpchests1_freq the dumpchests1_freq to set
	 */
	public void setDumpchests1_freq(String dumpchests1_freq) {
		this.dumpchests1_freq = dumpchests1_freq;
	}
	/**
	 * @return the dumpchests1_10am
	 */
	public String getDumpchests1_10am() {
		return dumpchests1_10am;
	}
	/**
	 * @param dumpchests1_10am the dumpchests1_10am to set
	 */
	public void setDumpchests1_10am(String dumpchests1_10am) {
		this.dumpchests1_10am = dumpchests1_10am;
	}
	/**
	 * @return the dumpchests1_02pm
	 */
	public String getDumpchests1_02pm() {
		return dumpchests1_02pm;
	}
	/**
	 * @param dumpchests1_02pm the dumpchests1_02pm to set
	 */
	public void setDumpchests1_02pm(String dumpchests1_02pm) {
		this.dumpchests1_02pm = dumpchests1_02pm;
	}
	/**
	 * @return the dumpchests1_06pm
	 */
	public String getDumpchests1_06pm() {
		return dumpchests1_06pm;
	}
	/**
	 * @param dumpchests1_06pm the dumpchests1_06pm to set
	 */
	public void setDumpchests1_06pm(String dumpchests1_06pm) {
		this.dumpchests1_06pm = dumpchests1_06pm;
	}
	/**
	 * @return the dumpchests1_10pm
	 */
	public String getDumpchests1_10pm() {
		return dumpchests1_10pm;
	}
	/**
	 * @param dumpchests1_10pm the dumpchests1_10pm to set
	 */
	public void setDumpchests1_10pm(String dumpchests1_10pm) {
		this.dumpchests1_10pm = dumpchests1_10pm;
	}
	/**
	 * @return the dumpchests1_02am
	 */
	public String getDumpchests1_02am() {
		return dumpchests1_02am;
	}
	/**
	 * @param dumpchests1_02am the dumpchests1_02am to set
	 */
	public void setDumpchests1_02am(String dumpchests1_02am) {
		this.dumpchests1_02am = dumpchests1_02am;
	}
	/**
	 * @return the dumpchests1_06am
	 */
	public String getDumpchests1_06am() {
		return dumpchests1_06am;
	}
	/**
	 * @param dumpchests1_06am the dumpchests1_06am to set
	 */
	public void setDumpchests1_06am(String dumpchests1_06am) {
		this.dumpchests1_06am = dumpchests1_06am;
	}
	/**
	 * @return the dumpchests2_freq
	 */
	public String getDumpchests2_freq() {
		return dumpchests2_freq;
	}
	/**
	 * @param dumpchests2_freq the dumpchests2_freq to set
	 */
	public void setDumpchests2_freq(String dumpchests2_freq) {
		this.dumpchests2_freq = dumpchests2_freq;
	}
	/**
	 * @return the dumpchests2_10am
	 */
	public String getDumpchests2_10am() {
		return dumpchests2_10am;
	}
	/**
	 * @param dumpchests2_10am the dumpchests2_10am to set
	 */
	public void setDumpchests2_10am(String dumpchests2_10am) {
		this.dumpchests2_10am = dumpchests2_10am;
	}
	/**
	 * @return the dumpchests2_02pm
	 */
	public String getDumpchests2_02pm() {
		return dumpchests2_02pm;
	}
	/**
	 * @param dumpchests2_02pm the dumpchests2_02pm to set
	 */
	public void setDumpchests2_02pm(String dumpchests2_02pm) {
		this.dumpchests2_02pm = dumpchests2_02pm;
	}
	/**
	 * @return the dumpchests2_06pm
	 */
	public String getDumpchests2_06pm() {
		return dumpchests2_06pm;
	}
	/**
	 * @param dumpchests2_06pm the dumpchests2_06pm to set
	 */
	public void setDumpchests2_06pm(String dumpchests2_06pm) {
		this.dumpchests2_06pm = dumpchests2_06pm;
	}
	/**
	 * @return the dumpchests2_10pm
	 */
	public String getDumpchests2_10pm() {
		return dumpchests2_10pm;
	}
	/**
	 * @param dumpchests2_10pm the dumpchests2_10pm to set
	 */
	public void setDumpchests2_10pm(String dumpchests2_10pm) {
		this.dumpchests2_10pm = dumpchests2_10pm;
	}
	/**
	 * @return the dumpchests2_02am
	 */
	public String getDumpchests2_02am() {
		return dumpchests2_02am;
	}
	/**
	 * @param dumpchests2_02am the dumpchests2_02am to set
	 */
	public void setDumpchests2_02am(String dumpchests2_02am) {
		this.dumpchests2_02am = dumpchests2_02am;
	}
	/**
	 * @return the dumpchests2_06am
	 */
	public String getDumpchests2_06am() {
		return dumpchests2_06am;
	}
	/**
	 * @param dumpchests2_06am the dumpchests2_06am to set
	 */
	public void setDumpchests2_06am(String dumpchests2_06am) {
		this.dumpchests2_06am = dumpchests2_06am;
	}
	/**
	 * @return the dumpchests3_freq
	 */
	public String getDumpchests3_freq() {
		return dumpchests3_freq;
	}
	/**
	 * @param dumpchests3_freq the dumpchests3_freq to set
	 */
	public void setDumpchests3_freq(String dumpchests3_freq) {
		this.dumpchests3_freq = dumpchests3_freq;
	}
	/**
	 * @return the dumpchests3_10am
	 */
	public String getDumpchests3_10am() {
		return dumpchests3_10am;
	}
	/**
	 * @param dumpchests3_10am the dumpchests3_10am to set
	 */
	public void setDumpchests3_10am(String dumpchests3_10am) {
		this.dumpchests3_10am = dumpchests3_10am;
	}
	/**
	 * @return the dumpchests3_02pm
	 */
	public String getDumpchests3_02pm() {
		return dumpchests3_02pm;
	}
	/**
	 * @param dumpchests3_02pm the dumpchests3_02pm to set
	 */
	public void setDumpchests3_02pm(String dumpchests3_02pm) {
		this.dumpchests3_02pm = dumpchests3_02pm;
	}
	/**
	 * @return the dumpchests3_06pm
	 */
	public String getDumpchests3_06pm() {
		return dumpchests3_06pm;
	}
	/**
	 * @param dumpchests3_06pm the dumpchests3_06pm to set
	 */
	public void setDumpchests3_06pm(String dumpchests3_06pm) {
		this.dumpchests3_06pm = dumpchests3_06pm;
	}
	/**
	 * @return the dumpchests3_10pm
	 */
	public String getDumpchests3_10pm() {
		return dumpchests3_10pm;
	}
	/**
	 * @param dumpchests3_10pm the dumpchests3_10pm to set
	 */
	public void setDumpchests3_10pm(String dumpchests3_10pm) {
		this.dumpchests3_10pm = dumpchests3_10pm;
	}
	/**
	 * @return the dumpchests3_02am
	 */
	public String getDumpchests3_02am() {
		return dumpchests3_02am;
	}
	/**
	 * @param dumpchests3_02am the dumpchests3_02am to set
	 */
	public void setDumpchests3_02am(String dumpchests3_02am) {
		this.dumpchests3_02am = dumpchests3_02am;
	}
	/**
	 * @return the dumpchests3_06am
	 */
	public String getDumpchests3_06am() {
		return dumpchests3_06am;
	}
	/**
	 * @param dumpchests3_06am the dumpchests3_06am to set
	 */
	public void setDumpchests3_06am(String dumpchests3_06am) {
		this.dumpchests3_06am = dumpchests3_06am;
	}
	/**
	 * @return the dumpchests4_freq
	 */
	public String getDumpchests4_freq() {
		return dumpchests4_freq;
	}
	/**
	 * @param dumpchests4_freq the dumpchests4_freq to set
	 */
	public void setDumpchests4_freq(String dumpchests4_freq) {
		this.dumpchests4_freq = dumpchests4_freq;
	}
	/**
	 * @return the dumpchests4_10am
	 */
	public String getDumpchests4_10am() {
		return dumpchests4_10am;
	}
	/**
	 * @param dumpchests4_10am the dumpchests4_10am to set
	 */
	public void setDumpchests4_10am(String dumpchests4_10am) {
		this.dumpchests4_10am = dumpchests4_10am;
	}
	/**
	 * @return the dumpchests4_02pm
	 */
	public String getDumpchests4_02pm() {
		return dumpchests4_02pm;
	}
	/**
	 * @param dumpchests4_02pm the dumpchests4_02pm to set
	 */
	public void setDumpchests4_02pm(String dumpchests4_02pm) {
		this.dumpchests4_02pm = dumpchests4_02pm;
	}
	/**
	 * @return the dumpchests4_06pm
	 */
	public String getDumpchests4_06pm() {
		return dumpchests4_06pm;
	}
	/**
	 * @param dumpchests4_06pm the dumpchests4_06pm to set
	 */
	public void setDumpchests4_06pm(String dumpchests4_06pm) {
		this.dumpchests4_06pm = dumpchests4_06pm;
	}
	/**
	 * @return the dumpchests4_10pm
	 */
	public String getDumpchests4_10pm() {
		return dumpchests4_10pm;
	}
	/**
	 * @param dumpchests4_10pm the dumpchests4_10pm to set
	 */
	public void setDumpchests4_10pm(String dumpchests4_10pm) {
		this.dumpchests4_10pm = dumpchests4_10pm;
	}
	/**
	 * @return the dumpchests4_02am
	 */
	public String getDumpchests4_02am() {
		return dumpchests4_02am;
	}
	/**
	 * @param dumpchests4_02am the dumpchests4_02am to set
	 */
	public void setDumpchests4_02am(String dumpchests4_02am) {
		this.dumpchests4_02am = dumpchests4_02am;
	}
	/**
	 * @return the dumpchests4_06am
	 */
	public String getDumpchests4_06am() {
		return dumpchests4_06am;
	}
	/**
	 * @param dumpchests4_06am the dumpchests4_06am to set
	 */
	public void setDumpchests4_06am(String dumpchests4_06am) {
		this.dumpchests4_06am = dumpchests4_06am;
	}
	/**
	 * @return the dumpchests5_freq
	 */
	public String getDumpchests5_freq() {
		return dumpchests5_freq;
	}
	/**
	 * @param dumpchests5_freq the dumpchests5_freq to set
	 */
	public void setDumpchests5_freq(String dumpchests5_freq) {
		this.dumpchests5_freq = dumpchests5_freq;
	}
	/**
	 * @return the dumpchests5_10am
	 */
	public String getDumpchests5_10am() {
		return dumpchests5_10am;
	}
	/**
	 * @param dumpchests5_10am the dumpchests5_10am to set
	 */
	public void setDumpchests5_10am(String dumpchests5_10am) {
		this.dumpchests5_10am = dumpchests5_10am;
	}
	/**
	 * @return the dumpchests5_02pm
	 */
	public String getDumpchests5_02pm() {
		return dumpchests5_02pm;
	}
	/**
	 * @param dumpchests5_02pm the dumpchests5_02pm to set
	 */
	public void setDumpchests5_02pm(String dumpchests5_02pm) {
		this.dumpchests5_02pm = dumpchests5_02pm;
	}
	/**
	 * @return the dumpchests5_06pm
	 */
	public String getDumpchests5_06pm() {
		return dumpchests5_06pm;
	}
	/**
	 * @param dumpchests5_06pm the dumpchests5_06pm to set
	 */
	public void setDumpchests5_06pm(String dumpchests5_06pm) {
		this.dumpchests5_06pm = dumpchests5_06pm;
	}
	/**
	 * @return the dumpchests5_10pm
	 */
	public String getDumpchests5_10pm() {
		return dumpchests5_10pm;
	}
	/**
	 * @param dumpchests5_10pm the dumpchests5_10pm to set
	 */
	public void setDumpchests5_10pm(String dumpchests5_10pm) {
		this.dumpchests5_10pm = dumpchests5_10pm;
	}
	/**
	 * @return the dumpchests5_02am
	 */
	public String getDumpchests5_02am() {
		return dumpchests5_02am;
	}
	/**
	 * @param dumpchests5_02am the dumpchests5_02am to set
	 */
	public void setDumpchests5_02am(String dumpchests5_02am) {
		this.dumpchests5_02am = dumpchests5_02am;
	}
	/**
	 * @return the dumpchests5_06am
	 */
	public String getDumpchests5_06am() {
		return dumpchests5_06am;
	}
	/**
	 * @param dumpchests5_06am the dumpchests5_06am to set
	 */
	public void setDumpchests5_06am(String dumpchests5_06am) {
		this.dumpchests5_06am = dumpchests5_06am;
	}
	/**
	 * @return the contaminexpump1_freq
	 */
	public String getContaminexpump1_freq() {
		return contaminexpump1_freq;
	}
	/**
	 * @param contaminexpump1_freq the contaminexpump1_freq to set
	 */
	public void setContaminexpump1_freq(String contaminexpump1_freq) {
		this.contaminexpump1_freq = contaminexpump1_freq;
	}
	/**
	 * @return the contaminexpump1_10am
	 */
	public String getContaminexpump1_10am() {
		return contaminexpump1_10am;
	}
	/**
	 * @param contaminexpump1_10am the contaminexpump1_10am to set
	 */
	public void setContaminexpump1_10am(String contaminexpump1_10am) {
		this.contaminexpump1_10am = contaminexpump1_10am;
	}
	/**
	 * @return the contaminexpump1_02pm
	 */
	public String getContaminexpump1_02pm() {
		return contaminexpump1_02pm;
	}
	/**
	 * @param contaminexpump1_02pm the contaminexpump1_02pm to set
	 */
	public void setContaminexpump1_02pm(String contaminexpump1_02pm) {
		this.contaminexpump1_02pm = contaminexpump1_02pm;
	}
	/**
	 * @return the contaminexpump1_06pm
	 */
	public String getContaminexpump1_06pm() {
		return contaminexpump1_06pm;
	}
	/**
	 * @param contaminexpump1_06pm the contaminexpump1_06pm to set
	 */
	public void setContaminexpump1_06pm(String contaminexpump1_06pm) {
		this.contaminexpump1_06pm = contaminexpump1_06pm;
	}
	/**
	 * @return the contaminexpump1_10pm
	 */
	public String getContaminexpump1_10pm() {
		return contaminexpump1_10pm;
	}
	/**
	 * @param contaminexpump1_10pm the contaminexpump1_10pm to set
	 */
	public void setContaminexpump1_10pm(String contaminexpump1_10pm) {
		this.contaminexpump1_10pm = contaminexpump1_10pm;
	}
	/**
	 * @return the contaminexpump1_02am
	 */
	public String getContaminexpump1_02am() {
		return contaminexpump1_02am;
	}
	/**
	 * @param contaminexpump1_02am the contaminexpump1_02am to set
	 */
	public void setContaminexpump1_02am(String contaminexpump1_02am) {
		this.contaminexpump1_02am = contaminexpump1_02am;
	}
	/**
	 * @return the contaminexpump1_06am
	 */
	public String getContaminexpump1_06am() {
		return contaminexpump1_06am;
	}
	/**
	 * @param contaminexpump1_06am the contaminexpump1_06am to set
	 */
	public void setContaminexpump1_06am(String contaminexpump1_06am) {
		this.contaminexpump1_06am = contaminexpump1_06am;
	}
	/**
	 * @return the contaminexpump2_freq
	 */
	public String getContaminexpump2_freq() {
		return contaminexpump2_freq;
	}
	/**
	 * @param contaminexpump2_freq the contaminexpump2_freq to set
	 */
	public void setContaminexpump2_freq(String contaminexpump2_freq) {
		this.contaminexpump2_freq = contaminexpump2_freq;
	}
	/**
	 * @return the contaminexpump2_10am
	 */
	public String getContaminexpump2_10am() {
		return contaminexpump2_10am;
	}
	/**
	 * @param contaminexpump2_10am the contaminexpump2_10am to set
	 */
	public void setContaminexpump2_10am(String contaminexpump2_10am) {
		this.contaminexpump2_10am = contaminexpump2_10am;
	}
	/**
	 * @return the contaminexpump2_02pm
	 */
	public String getContaminexpump2_02pm() {
		return contaminexpump2_02pm;
	}
	/**
	 * @param contaminexpump2_02pm the contaminexpump2_02pm to set
	 */
	public void setContaminexpump2_02pm(String contaminexpump2_02pm) {
		this.contaminexpump2_02pm = contaminexpump2_02pm;
	}
	/**
	 * @return the contaminexpump2_06pm
	 */
	public String getContaminexpump2_06pm() {
		return contaminexpump2_06pm;
	}
	/**
	 * @param contaminexpump2_06pm the contaminexpump2_06pm to set
	 */
	public void setContaminexpump2_06pm(String contaminexpump2_06pm) {
		this.contaminexpump2_06pm = contaminexpump2_06pm;
	}
	/**
	 * @return the contaminexpump2_10pm
	 */
	public String getContaminexpump2_10pm() {
		return contaminexpump2_10pm;
	}
	/**
	 * @param contaminexpump2_10pm the contaminexpump2_10pm to set
	 */
	public void setContaminexpump2_10pm(String contaminexpump2_10pm) {
		this.contaminexpump2_10pm = contaminexpump2_10pm;
	}
	/**
	 * @return the contaminexpump2_02am
	 */
	public String getContaminexpump2_02am() {
		return contaminexpump2_02am;
	}
	/**
	 * @param contaminexpump2_02am the contaminexpump2_02am to set
	 */
	public void setContaminexpump2_02am(String contaminexpump2_02am) {
		this.contaminexpump2_02am = contaminexpump2_02am;
	}
	/**
	 * @return the contaminexpump2_06am
	 */
	public String getContaminexpump2_06am() {
		return contaminexpump2_06am;
	}
	/**
	 * @param contaminexpump2_06am the contaminexpump2_06am to set
	 */
	public void setContaminexpump2_06am(String contaminexpump2_06am) {
		this.contaminexpump2_06am = contaminexpump2_06am;
	}
	/**
	 * @return the contaminexpump3_freq
	 */
	public String getContaminexpump3_freq() {
		return contaminexpump3_freq;
	}
	/**
	 * @param contaminexpump3_freq the contaminexpump3_freq to set
	 */
	public void setContaminexpump3_freq(String contaminexpump3_freq) {
		this.contaminexpump3_freq = contaminexpump3_freq;
	}
	/**
	 * @return the contaminexpump3_10am
	 */
	public String getContaminexpump3_10am() {
		return contaminexpump3_10am;
	}
	/**
	 * @param contaminexpump3_10am the contaminexpump3_10am to set
	 */
	public void setContaminexpump3_10am(String contaminexpump3_10am) {
		this.contaminexpump3_10am = contaminexpump3_10am;
	}
	/**
	 * @return the contaminexpump3_02pm
	 */
	public String getContaminexpump3_02pm() {
		return contaminexpump3_02pm;
	}
	/**
	 * @param contaminexpump3_02pm the contaminexpump3_02pm to set
	 */
	public void setContaminexpump3_02pm(String contaminexpump3_02pm) {
		this.contaminexpump3_02pm = contaminexpump3_02pm;
	}
	/**
	 * @return the contaminexpump3_06pm
	 */
	public String getContaminexpump3_06pm() {
		return contaminexpump3_06pm;
	}
	/**
	 * @param contaminexpump3_06pm the contaminexpump3_06pm to set
	 */
	public void setContaminexpump3_06pm(String contaminexpump3_06pm) {
		this.contaminexpump3_06pm = contaminexpump3_06pm;
	}
	/**
	 * @return the contaminexpump3_10pm
	 */
	public String getContaminexpump3_10pm() {
		return contaminexpump3_10pm;
	}
	/**
	 * @param contaminexpump3_10pm the contaminexpump3_10pm to set
	 */
	public void setContaminexpump3_10pm(String contaminexpump3_10pm) {
		this.contaminexpump3_10pm = contaminexpump3_10pm;
	}
	/**
	 * @return the contaminexpump3_02am
	 */
	public String getContaminexpump3_02am() {
		return contaminexpump3_02am;
	}
	/**
	 * @param contaminexpump3_02am the contaminexpump3_02am to set
	 */
	public void setContaminexpump3_02am(String contaminexpump3_02am) {
		this.contaminexpump3_02am = contaminexpump3_02am;
	}
	/**
	 * @return the contaminexpump3_06am
	 */
	public String getContaminexpump3_06am() {
		return contaminexpump3_06am;
	}
	/**
	 * @param contaminexpump3_06am the contaminexpump3_06am to set
	 */
	public void setContaminexpump3_06am(String contaminexpump3_06am) {
		this.contaminexpump3_06am = contaminexpump3_06am;
	}
	/**
	 * @return the rejectscollectionbunker1_freq
	 */
	public String getRejectscollectionbunker1_freq() {
		return rejectscollectionbunker1_freq;
	}
	/**
	 * @param rejectscollectionbunker1_freq the rejectscollectionbunker1_freq to set
	 */
	public void setRejectscollectionbunker1_freq(String rejectscollectionbunker1_freq) {
		this.rejectscollectionbunker1_freq = rejectscollectionbunker1_freq;
	}
	/**
	 * @return the rejectscollectionbunker1_10am
	 */
	public String getRejectscollectionbunker1_10am() {
		return rejectscollectionbunker1_10am;
	}
	/**
	 * @param rejectscollectionbunker1_10am the rejectscollectionbunker1_10am to set
	 */
	public void setRejectscollectionbunker1_10am(String rejectscollectionbunker1_10am) {
		this.rejectscollectionbunker1_10am = rejectscollectionbunker1_10am;
	}
	/**
	 * @return the rejectscollectionbunker1_02pm
	 */
	public String getRejectscollectionbunker1_02pm() {
		return rejectscollectionbunker1_02pm;
	}
	/**
	 * @param rejectscollectionbunker1_02pm the rejectscollectionbunker1_02pm to set
	 */
	public void setRejectscollectionbunker1_02pm(String rejectscollectionbunker1_02pm) {
		this.rejectscollectionbunker1_02pm = rejectscollectionbunker1_02pm;
	}
	/**
	 * @return the rejectscollectionbunker1_06pm
	 */
	public String getRejectscollectionbunker1_06pm() {
		return rejectscollectionbunker1_06pm;
	}
	/**
	 * @param rejectscollectionbunker1_06pm the rejectscollectionbunker1_06pm to set
	 */
	public void setRejectscollectionbunker1_06pm(String rejectscollectionbunker1_06pm) {
		this.rejectscollectionbunker1_06pm = rejectscollectionbunker1_06pm;
	}
	/**
	 * @return the rejectscollectionbunker1_10pm
	 */
	public String getRejectscollectionbunker1_10pm() {
		return rejectscollectionbunker1_10pm;
	}
	/**
	 * @param rejectscollectionbunker1_10pm the rejectscollectionbunker1_10pm to set
	 */
	public void setRejectscollectionbunker1_10pm(String rejectscollectionbunker1_10pm) {
		this.rejectscollectionbunker1_10pm = rejectscollectionbunker1_10pm;
	}
	/**
	 * @return the rejectscollectionbunker1_02am
	 */
	public String getRejectscollectionbunker1_02am() {
		return rejectscollectionbunker1_02am;
	}
	/**
	 * @param rejectscollectionbunker1_02am the rejectscollectionbunker1_02am to set
	 */
	public void setRejectscollectionbunker1_02am(String rejectscollectionbunker1_02am) {
		this.rejectscollectionbunker1_02am = rejectscollectionbunker1_02am;
	}
	/**
	 * @return the rejectscollectionbunker1_06am
	 */
	public String getRejectscollectionbunker1_06am() {
		return rejectscollectionbunker1_06am;
	}
	/**
	 * @param rejectscollectionbunker1_06am the rejectscollectionbunker1_06am to set
	 */
	public void setRejectscollectionbunker1_06am(String rejectscollectionbunker1_06am) {
		this.rejectscollectionbunker1_06am = rejectscollectionbunker1_06am;
	}
	/**
	 * @return the rejectscollectionbunker2_freq
	 */
	public String getRejectscollectionbunker2_freq() {
		return rejectscollectionbunker2_freq;
	}
	/**
	 * @param rejectscollectionbunker2_freq the rejectscollectionbunker2_freq to set
	 */
	public void setRejectscollectionbunker2_freq(String rejectscollectionbunker2_freq) {
		this.rejectscollectionbunker2_freq = rejectscollectionbunker2_freq;
	}
	/**
	 * @return the rejectscollectionbunker2_10am
	 */
	public String getRejectscollectionbunker2_10am() {
		return rejectscollectionbunker2_10am;
	}
	/**
	 * @param rejectscollectionbunker2_10am the rejectscollectionbunker2_10am to set
	 */
	public void setRejectscollectionbunker2_10am(String rejectscollectionbunker2_10am) {
		this.rejectscollectionbunker2_10am = rejectscollectionbunker2_10am;
	}
	/**
	 * @return the rejectscollectionbunker2_02pm
	 */
	public String getRejectscollectionbunker2_02pm() {
		return rejectscollectionbunker2_02pm;
	}
	/**
	 * @param rejectscollectionbunker2_02pm the rejectscollectionbunker2_02pm to set
	 */
	public void setRejectscollectionbunker2_02pm(String rejectscollectionbunker2_02pm) {
		this.rejectscollectionbunker2_02pm = rejectscollectionbunker2_02pm;
	}
	/**
	 * @return the rejectscollectionbunker2_06pm
	 */
	public String getRejectscollectionbunker2_06pm() {
		return rejectscollectionbunker2_06pm;
	}
	/**
	 * @param rejectscollectionbunker2_06pm the rejectscollectionbunker2_06pm to set
	 */
	public void setRejectscollectionbunker2_06pm(String rejectscollectionbunker2_06pm) {
		this.rejectscollectionbunker2_06pm = rejectscollectionbunker2_06pm;
	}
	/**
	 * @return the rejectscollectionbunker2_10pm
	 */
	public String getRejectscollectionbunker2_10pm() {
		return rejectscollectionbunker2_10pm;
	}
	/**
	 * @param rejectscollectionbunker2_10pm the rejectscollectionbunker2_10pm to set
	 */
	public void setRejectscollectionbunker2_10pm(String rejectscollectionbunker2_10pm) {
		this.rejectscollectionbunker2_10pm = rejectscollectionbunker2_10pm;
	}
	/**
	 * @return the rejectscollectionbunker2_02am
	 */
	public String getRejectscollectionbunker2_02am() {
		return rejectscollectionbunker2_02am;
	}
	/**
	 * @param rejectscollectionbunker2_02am the rejectscollectionbunker2_02am to set
	 */
	public void setRejectscollectionbunker2_02am(String rejectscollectionbunker2_02am) {
		this.rejectscollectionbunker2_02am = rejectscollectionbunker2_02am;
	}
	/**
	 * @return the rejectscollectionbunker2_06am
	 */
	public String getRejectscollectionbunker2_06am() {
		return rejectscollectionbunker2_06am;
	}
	/**
	 * @param rejectscollectionbunker2_06am the rejectscollectionbunker2_06am to set
	 */
	public void setRejectscollectionbunker2_06am(String rejectscollectionbunker2_06am) {
		this.rejectscollectionbunker2_06am = rejectscollectionbunker2_06am;
	}
	/**
	 * @return the batchpulperbasement1_freq
	 */
	public String getBatchpulperbasement1_freq() {
		return batchpulperbasement1_freq;
	}
	/**
	 * @param batchpulperbasement1_freq the batchpulperbasement1_freq to set
	 */
	public void setBatchpulperbasement1_freq(String batchpulperbasement1_freq) {
		this.batchpulperbasement1_freq = batchpulperbasement1_freq;
	}
	/**
	 * @return the batchpulperbasement1_10am
	 */
	public String getBatchpulperbasement1_10am() {
		return batchpulperbasement1_10am;
	}
	/**
	 * @param batchpulperbasement1_10am the batchpulperbasement1_10am to set
	 */
	public void setBatchpulperbasement1_10am(String batchpulperbasement1_10am) {
		this.batchpulperbasement1_10am = batchpulperbasement1_10am;
	}
	/**
	 * @return the batchpulperbasement1_02pm
	 */
	public String getBatchpulperbasement1_02pm() {
		return batchpulperbasement1_02pm;
	}
	/**
	 * @param batchpulperbasement1_02pm the batchpulperbasement1_02pm to set
	 */
	public void setBatchpulperbasement1_02pm(String batchpulperbasement1_02pm) {
		this.batchpulperbasement1_02pm = batchpulperbasement1_02pm;
	}
	/**
	 * @return the batchpulperbasement1_06pm
	 */
	public String getBatchpulperbasement1_06pm() {
		return batchpulperbasement1_06pm;
	}
	/**
	 * @param batchpulperbasement1_06pm the batchpulperbasement1_06pm to set
	 */
	public void setBatchpulperbasement1_06pm(String batchpulperbasement1_06pm) {
		this.batchpulperbasement1_06pm = batchpulperbasement1_06pm;
	}
	/**
	 * @return the batchpulperbasement1_10pm
	 */
	public String getBatchpulperbasement1_10pm() {
		return batchpulperbasement1_10pm;
	}
	/**
	 * @param batchpulperbasement1_10pm the batchpulperbasement1_10pm to set
	 */
	public void setBatchpulperbasement1_10pm(String batchpulperbasement1_10pm) {
		this.batchpulperbasement1_10pm = batchpulperbasement1_10pm;
	}
	/**
	 * @return the batchpulperbasement1_02am
	 */
	public String getBatchpulperbasement1_02am() {
		return batchpulperbasement1_02am;
	}
	/**
	 * @param batchpulperbasement1_02am the batchpulperbasement1_02am to set
	 */
	public void setBatchpulperbasement1_02am(String batchpulperbasement1_02am) {
		this.batchpulperbasement1_02am = batchpulperbasement1_02am;
	}
	/**
	 * @return the batchpulperbasement1_06am
	 */
	public String getBatchpulperbasement1_06am() {
		return batchpulperbasement1_06am;
	}
	/**
	 * @param batchpulperbasement1_06am the batchpulperbasement1_06am to set
	 */
	public void setBatchpulperbasement1_06am(String batchpulperbasement1_06am) {
		this.batchpulperbasement1_06am = batchpulperbasement1_06am;
	}
	/**
	 * @return the batchpulperbasement2_freq
	 */
	public String getBatchpulperbasement2_freq() {
		return batchpulperbasement2_freq;
	}
	/**
	 * @param batchpulperbasement2_freq the batchpulperbasement2_freq to set
	 */
	public void setBatchpulperbasement2_freq(String batchpulperbasement2_freq) {
		this.batchpulperbasement2_freq = batchpulperbasement2_freq;
	}
	/**
	 * @return the batchpulperbasement2_10am
	 */
	public String getBatchpulperbasement2_10am() {
		return batchpulperbasement2_10am;
	}
	/**
	 * @param batchpulperbasement2_10am the batchpulperbasement2_10am to set
	 */
	public void setBatchpulperbasement2_10am(String batchpulperbasement2_10am) {
		this.batchpulperbasement2_10am = batchpulperbasement2_10am;
	}
	/**
	 * @return the batchpulperbasement2_02pm
	 */
	public String getBatchpulperbasement2_02pm() {
		return batchpulperbasement2_02pm;
	}
	/**
	 * @param batchpulperbasement2_02pm the batchpulperbasement2_02pm to set
	 */
	public void setBatchpulperbasement2_02pm(String batchpulperbasement2_02pm) {
		this.batchpulperbasement2_02pm = batchpulperbasement2_02pm;
	}
	/**
	 * @return the batchpulperbasement2_06pm
	 */
	public String getBatchpulperbasement2_06pm() {
		return batchpulperbasement2_06pm;
	}
	/**
	 * @param batchpulperbasement2_06pm the batchpulperbasement2_06pm to set
	 */
	public void setBatchpulperbasement2_06pm(String batchpulperbasement2_06pm) {
		this.batchpulperbasement2_06pm = batchpulperbasement2_06pm;
	}
	/**
	 * @return the batchpulperbasement2_10pm
	 */
	public String getBatchpulperbasement2_10pm() {
		return batchpulperbasement2_10pm;
	}
	/**
	 * @param batchpulperbasement2_10pm the batchpulperbasement2_10pm to set
	 */
	public void setBatchpulperbasement2_10pm(String batchpulperbasement2_10pm) {
		this.batchpulperbasement2_10pm = batchpulperbasement2_10pm;
	}
	/**
	 * @return the batchpulperbasement2_02am
	 */
	public String getBatchpulperbasement2_02am() {
		return batchpulperbasement2_02am;
	}
	/**
	 * @param batchpulperbasement2_02am the batchpulperbasement2_02am to set
	 */
	public void setBatchpulperbasement2_02am(String batchpulperbasement2_02am) {
		this.batchpulperbasement2_02am = batchpulperbasement2_02am;
	}
	/**
	 * @return the batchpulperbasement2_06am
	 */
	public String getBatchpulperbasement2_06am() {
		return batchpulperbasement2_06am;
	}
	/**
	 * @param batchpulperbasement2_06am the batchpulperbasement2_06am to set
	 */
	public void setBatchpulperbasement2_06am(String batchpulperbasement2_06am) {
		this.batchpulperbasement2_06am = batchpulperbasement2_06am;
	}
	/**
	 * @return the batchpulperbasement3_freq
	 */
	public String getBatchpulperbasement3_freq() {
		return batchpulperbasement3_freq;
	}
	/**
	 * @param batchpulperbasement3_freq the batchpulperbasement3_freq to set
	 */
	public void setBatchpulperbasement3_freq(String batchpulperbasement3_freq) {
		this.batchpulperbasement3_freq = batchpulperbasement3_freq;
	}
	/**
	 * @return the batchpulperbasement3_10am
	 */
	public String getBatchpulperbasement3_10am() {
		return batchpulperbasement3_10am;
	}
	/**
	 * @param batchpulperbasement3_10am the batchpulperbasement3_10am to set
	 */
	public void setBatchpulperbasement3_10am(String batchpulperbasement3_10am) {
		this.batchpulperbasement3_10am = batchpulperbasement3_10am;
	}
	/**
	 * @return the batchpulperbasement3_02pm
	 */
	public String getBatchpulperbasement3_02pm() {
		return batchpulperbasement3_02pm;
	}
	/**
	 * @param batchpulperbasement3_02pm the batchpulperbasement3_02pm to set
	 */
	public void setBatchpulperbasement3_02pm(String batchpulperbasement3_02pm) {
		this.batchpulperbasement3_02pm = batchpulperbasement3_02pm;
	}
	/**
	 * @return the batchpulperbasement3_06pm
	 */
	public String getBatchpulperbasement3_06pm() {
		return batchpulperbasement3_06pm;
	}
	/**
	 * @param batchpulperbasement3_06pm the batchpulperbasement3_06pm to set
	 */
	public void setBatchpulperbasement3_06pm(String batchpulperbasement3_06pm) {
		this.batchpulperbasement3_06pm = batchpulperbasement3_06pm;
	}
	/**
	 * @return the batchpulperbasement3_10pm
	 */
	public String getBatchpulperbasement3_10pm() {
		return batchpulperbasement3_10pm;
	}
	/**
	 * @param batchpulperbasement3_10pm the batchpulperbasement3_10pm to set
	 */
	public void setBatchpulperbasement3_10pm(String batchpulperbasement3_10pm) {
		this.batchpulperbasement3_10pm = batchpulperbasement3_10pm;
	}
	/**
	 * @return the batchpulperbasement3_02am
	 */
	public String getBatchpulperbasement3_02am() {
		return batchpulperbasement3_02am;
	}
	/**
	 * @param batchpulperbasement3_02am the batchpulperbasement3_02am to set
	 */
	public void setBatchpulperbasement3_02am(String batchpulperbasement3_02am) {
		this.batchpulperbasement3_02am = batchpulperbasement3_02am;
	}
	/**
	 * @return the batchpulperbasement3_06am
	 */
	public String getBatchpulperbasement3_06am() {
		return batchpulperbasement3_06am;
	}
	/**
	 * @param batchpulperbasement3_06am the batchpulperbasement3_06am to set
	 */
	public void setBatchpulperbasement3_06am(String batchpulperbasement3_06am) {
		this.batchpulperbasement3_06am = batchpulperbasement3_06am;
	}
	/**
	 * @return the batchpulperbasement4_freq
	 */
	public String getBatchpulperbasement4_freq() {
		return batchpulperbasement4_freq;
	}
	/**
	 * @param batchpulperbasement4_freq the batchpulperbasement4_freq to set
	 */
	public void setBatchpulperbasement4_freq(String batchpulperbasement4_freq) {
		this.batchpulperbasement4_freq = batchpulperbasement4_freq;
	}
	/**
	 * @return the batchpulperbasement4_10am
	 */
	public String getBatchpulperbasement4_10am() {
		return batchpulperbasement4_10am;
	}
	/**
	 * @param batchpulperbasement4_10am the batchpulperbasement4_10am to set
	 */
	public void setBatchpulperbasement4_10am(String batchpulperbasement4_10am) {
		this.batchpulperbasement4_10am = batchpulperbasement4_10am;
	}
	/**
	 * @return the batchpulperbasement4_02pm
	 */
	public String getBatchpulperbasement4_02pm() {
		return batchpulperbasement4_02pm;
	}
	/**
	 * @param batchpulperbasement4_02pm the batchpulperbasement4_02pm to set
	 */
	public void setBatchpulperbasement4_02pm(String batchpulperbasement4_02pm) {
		this.batchpulperbasement4_02pm = batchpulperbasement4_02pm;
	}
	/**
	 * @return the batchpulperbasement4_06pm
	 */
	public String getBatchpulperbasement4_06pm() {
		return batchpulperbasement4_06pm;
	}
	/**
	 * @param batchpulperbasement4_06pm the batchpulperbasement4_06pm to set
	 */
	public void setBatchpulperbasement4_06pm(String batchpulperbasement4_06pm) {
		this.batchpulperbasement4_06pm = batchpulperbasement4_06pm;
	}
	/**
	 * @return the batchpulperbasement4_10pm
	 */
	public String getBatchpulperbasement4_10pm() {
		return batchpulperbasement4_10pm;
	}
	/**
	 * @param batchpulperbasement4_10pm the batchpulperbasement4_10pm to set
	 */
	public void setBatchpulperbasement4_10pm(String batchpulperbasement4_10pm) {
		this.batchpulperbasement4_10pm = batchpulperbasement4_10pm;
	}
	/**
	 * @return the batchpulperbasement4_02am
	 */
	public String getBatchpulperbasement4_02am() {
		return batchpulperbasement4_02am;
	}
	/**
	 * @param batchpulperbasement4_02am the batchpulperbasement4_02am to set
	 */
	public void setBatchpulperbasement4_02am(String batchpulperbasement4_02am) {
		this.batchpulperbasement4_02am = batchpulperbasement4_02am;
	}
	/**
	 * @return the batchpulperbasement4_06am
	 */
	public String getBatchpulperbasement4_06am() {
		return batchpulperbasement4_06am;
	}
	/**
	 * @param batchpulperbasement4_06am the batchpulperbasement4_06am to set
	 */
	public void setBatchpulperbasement4_06am(String batchpulperbasement4_06am) {
		this.batchpulperbasement4_06am = batchpulperbasement4_06am;
	}
	/**
	 * @return the detrasher1_freq
	 */
	public String getDetrasher1_freq() {
		return detrasher1_freq;
	}
	/**
	 * @param detrasher1_freq the detrasher1_freq to set
	 */
	public void setDetrasher1_freq(String detrasher1_freq) {
		this.detrasher1_freq = detrasher1_freq;
	}
	/**
	 * @return the detrasher1_10am
	 */
	public String getDetrasher1_10am() {
		return detrasher1_10am;
	}
	/**
	 * @param detrasher1_10am the detrasher1_10am to set
	 */
	public void setDetrasher1_10am(String detrasher1_10am) {
		this.detrasher1_10am = detrasher1_10am;
	}
	/**
	 * @return the detrasher1_02pm
	 */
	public String getDetrasher1_02pm() {
		return detrasher1_02pm;
	}
	/**
	 * @param detrasher1_02pm the detrasher1_02pm to set
	 */
	public void setDetrasher1_02pm(String detrasher1_02pm) {
		this.detrasher1_02pm = detrasher1_02pm;
	}
	/**
	 * @return the detrasher1_06pm
	 */
	public String getDetrasher1_06pm() {
		return detrasher1_06pm;
	}
	/**
	 * @param detrasher1_06pm the detrasher1_06pm to set
	 */
	public void setDetrasher1_06pm(String detrasher1_06pm) {
		this.detrasher1_06pm = detrasher1_06pm;
	}
	/**
	 * @return the detrasher1_10pm
	 */
	public String getDetrasher1_10pm() {
		return detrasher1_10pm;
	}
	/**
	 * @param detrasher1_10pm the detrasher1_10pm to set
	 */
	public void setDetrasher1_10pm(String detrasher1_10pm) {
		this.detrasher1_10pm = detrasher1_10pm;
	}
	/**
	 * @return the detrasher1_02am
	 */
	public String getDetrasher1_02am() {
		return detrasher1_02am;
	}
	/**
	 * @param detrasher1_02am the detrasher1_02am to set
	 */
	public void setDetrasher1_02am(String detrasher1_02am) {
		this.detrasher1_02am = detrasher1_02am;
	}
	/**
	 * @return the detrasher1_06am
	 */
	public String getDetrasher1_06am() {
		return detrasher1_06am;
	}
	/**
	 * @param detrasher1_06am the detrasher1_06am to set
	 */
	public void setDetrasher1_06am(String detrasher1_06am) {
		this.detrasher1_06am = detrasher1_06am;
	}
	/**
	 * @return the detrasher2_freq
	 */
	public String getDetrasher2_freq() {
		return detrasher2_freq;
	}
	/**
	 * @param detrasher2_freq the detrasher2_freq to set
	 */
	public void setDetrasher2_freq(String detrasher2_freq) {
		this.detrasher2_freq = detrasher2_freq;
	}
	/**
	 * @return the detrasher2_10am
	 */
	public String getDetrasher2_10am() {
		return detrasher2_10am;
	}
	/**
	 * @param detrasher2_10am the detrasher2_10am to set
	 */
	public void setDetrasher2_10am(String detrasher2_10am) {
		this.detrasher2_10am = detrasher2_10am;
	}
	/**
	 * @return the detrasher2_02pm
	 */
	public String getDetrasher2_02pm() {
		return detrasher2_02pm;
	}
	/**
	 * @param detrasher2_02pm the detrasher2_02pm to set
	 */
	public void setDetrasher2_02pm(String detrasher2_02pm) {
		this.detrasher2_02pm = detrasher2_02pm;
	}
	/**
	 * @return the detrasher2_06pm
	 */
	public String getDetrasher2_06pm() {
		return detrasher2_06pm;
	}
	/**
	 * @param detrasher2_06pm the detrasher2_06pm to set
	 */
	public void setDetrasher2_06pm(String detrasher2_06pm) {
		this.detrasher2_06pm = detrasher2_06pm;
	}
	/**
	 * @return the detrasher2_10pm
	 */
	public String getDetrasher2_10pm() {
		return detrasher2_10pm;
	}
	/**
	 * @param detrasher2_10pm the detrasher2_10pm to set
	 */
	public void setDetrasher2_10pm(String detrasher2_10pm) {
		this.detrasher2_10pm = detrasher2_10pm;
	}
	/**
	 * @return the detrasher2_02am
	 */
	public String getDetrasher2_02am() {
		return detrasher2_02am;
	}
	/**
	 * @param detrasher2_02am the detrasher2_02am to set
	 */
	public void setDetrasher2_02am(String detrasher2_02am) {
		this.detrasher2_02am = detrasher2_02am;
	}
	/**
	 * @return the detrasher2_06am
	 */
	public String getDetrasher2_06am() {
		return detrasher2_06am;
	}
	/**
	 * @param detrasher2_06am the detrasher2_06am to set
	 */
	public void setDetrasher2_06am(String detrasher2_06am) {
		this.detrasher2_06am = detrasher2_06am;
	}
	/**
	 * @return the detrasher3_freq
	 */
	public String getDetrasher3_freq() {
		return detrasher3_freq;
	}
	/**
	 * @param detrasher3_freq the detrasher3_freq to set
	 */
	public void setDetrasher3_freq(String detrasher3_freq) {
		this.detrasher3_freq = detrasher3_freq;
	}
	/**
	 * @return the detrasher3_10am
	 */
	public String getDetrasher3_10am() {
		return detrasher3_10am;
	}
	/**
	 * @param detrasher3_10am the detrasher3_10am to set
	 */
	public void setDetrasher3_10am(String detrasher3_10am) {
		this.detrasher3_10am = detrasher3_10am;
	}
	/**
	 * @return the detrasher3_02pm
	 */
	public String getDetrasher3_02pm() {
		return detrasher3_02pm;
	}
	/**
	 * @param detrasher3_02pm the detrasher3_02pm to set
	 */
	public void setDetrasher3_02pm(String detrasher3_02pm) {
		this.detrasher3_02pm = detrasher3_02pm;
	}
	/**
	 * @return the detrasher3_06pm
	 */
	public String getDetrasher3_06pm() {
		return detrasher3_06pm;
	}
	/**
	 * @param detrasher3_06pm the detrasher3_06pm to set
	 */
	public void setDetrasher3_06pm(String detrasher3_06pm) {
		this.detrasher3_06pm = detrasher3_06pm;
	}
	/**
	 * @return the detrasher3_10pm
	 */
	public String getDetrasher3_10pm() {
		return detrasher3_10pm;
	}
	/**
	 * @param detrasher3_10pm the detrasher3_10pm to set
	 */
	public void setDetrasher3_10pm(String detrasher3_10pm) {
		this.detrasher3_10pm = detrasher3_10pm;
	}
	/**
	 * @return the detrasher3_02am
	 */
	public String getDetrasher3_02am() {
		return detrasher3_02am;
	}
	/**
	 * @param detrasher3_02am the detrasher3_02am to set
	 */
	public void setDetrasher3_02am(String detrasher3_02am) {
		this.detrasher3_02am = detrasher3_02am;
	}
	/**
	 * @return the detrasher3_06am
	 */
	public String getDetrasher3_06am() {
		return detrasher3_06am;
	}
	/**
	 * @param detrasher3_06am the detrasher3_06am to set
	 */
	public void setDetrasher3_06am(String detrasher3_06am) {
		this.detrasher3_06am = detrasher3_06am;
	}
	/**
	 * @return the rejectspress1_freq
	 */
	public String getRejectspress1_freq() {
		return rejectspress1_freq;
	}
	/**
	 * @param rejectspress1_freq the rejectspress1_freq to set
	 */
	public void setRejectspress1_freq(String rejectspress1_freq) {
		this.rejectspress1_freq = rejectspress1_freq;
	}
	/**
	 * @return the rejectspress1_10am
	 */
	public String getRejectspress1_10am() {
		return rejectspress1_10am;
	}
	/**
	 * @param rejectspress1_10am the rejectspress1_10am to set
	 */
	public void setRejectspress1_10am(String rejectspress1_10am) {
		this.rejectspress1_10am = rejectspress1_10am;
	}
	/**
	 * @return the rejectspress1_02pm
	 */
	public String getRejectspress1_02pm() {
		return rejectspress1_02pm;
	}
	/**
	 * @param rejectspress1_02pm the rejectspress1_02pm to set
	 */
	public void setRejectspress1_02pm(String rejectspress1_02pm) {
		this.rejectspress1_02pm = rejectspress1_02pm;
	}
	/**
	 * @return the rejectspress1_06pm
	 */
	public String getRejectspress1_06pm() {
		return rejectspress1_06pm;
	}
	/**
	 * @param rejectspress1_06pm the rejectspress1_06pm to set
	 */
	public void setRejectspress1_06pm(String rejectspress1_06pm) {
		this.rejectspress1_06pm = rejectspress1_06pm;
	}
	/**
	 * @return the rejectspress1_10pm
	 */
	public String getRejectspress1_10pm() {
		return rejectspress1_10pm;
	}
	/**
	 * @param rejectspress1_10pm the rejectspress1_10pm to set
	 */
	public void setRejectspress1_10pm(String rejectspress1_10pm) {
		this.rejectspress1_10pm = rejectspress1_10pm;
	}
	/**
	 * @return the rejectspress1_02am
	 */
	public String getRejectspress1_02am() {
		return rejectspress1_02am;
	}
	/**
	 * @param rejectspress1_02am the rejectspress1_02am to set
	 */
	public void setRejectspress1_02am(String rejectspress1_02am) {
		this.rejectspress1_02am = rejectspress1_02am;
	}
	/**
	 * @return the rejectspress1_06am
	 */
	public String getRejectspress1_06am() {
		return rejectspress1_06am;
	}
	/**
	 * @param rejectspress1_06am the rejectspress1_06am to set
	 */
	public void setRejectspress1_06am(String rejectspress1_06am) {
		this.rejectspress1_06am = rejectspress1_06am;
	}
	/**
	 * @return the rejectspress2_freq
	 */
	public String getRejectspress2_freq() {
		return rejectspress2_freq;
	}
	/**
	 * @param rejectspress2_freq the rejectspress2_freq to set
	 */
	public void setRejectspress2_freq(String rejectspress2_freq) {
		this.rejectspress2_freq = rejectspress2_freq;
	}
	/**
	 * @return the rejectspress2_10am
	 */
	public String getRejectspress2_10am() {
		return rejectspress2_10am;
	}
	/**
	 * @param rejectspress2_10am the rejectspress2_10am to set
	 */
	public void setRejectspress2_10am(String rejectspress2_10am) {
		this.rejectspress2_10am = rejectspress2_10am;
	}
	/**
	 * @return the rejectspress2_02pm
	 */
	public String getRejectspress2_02pm() {
		return rejectspress2_02pm;
	}
	/**
	 * @param rejectspress2_02pm the rejectspress2_02pm to set
	 */
	public void setRejectspress2_02pm(String rejectspress2_02pm) {
		this.rejectspress2_02pm = rejectspress2_02pm;
	}
	/**
	 * @return the rejectspress2_06pm
	 */
	public String getRejectspress2_06pm() {
		return rejectspress2_06pm;
	}
	/**
	 * @param rejectspress2_06pm the rejectspress2_06pm to set
	 */
	public void setRejectspress2_06pm(String rejectspress2_06pm) {
		this.rejectspress2_06pm = rejectspress2_06pm;
	}
	/**
	 * @return the rejectspress2_10pm
	 */
	public String getRejectspress2_10pm() {
		return rejectspress2_10pm;
	}
	/**
	 * @param rejectspress2_10pm the rejectspress2_10pm to set
	 */
	public void setRejectspress2_10pm(String rejectspress2_10pm) {
		this.rejectspress2_10pm = rejectspress2_10pm;
	}
	/**
	 * @return the rejectspress2_02am
	 */
	public String getRejectspress2_02am() {
		return rejectspress2_02am;
	}
	/**
	 * @param rejectspress2_02am the rejectspress2_02am to set
	 */
	public void setRejectspress2_02am(String rejectspress2_02am) {
		this.rejectspress2_02am = rejectspress2_02am;
	}
	/**
	 * @return the rejectspress2_06am
	 */
	public String getRejectspress2_06am() {
		return rejectspress2_06am;
	}
	/**
	 * @param rejectspress2_06am the rejectspress2_06am to set
	 */
	public void setRejectspress2_06am(String rejectspress2_06am) {
		this.rejectspress2_06am = rejectspress2_06am;
	}
	/**
	 * @return the rejectspress3_freq
	 */
	public String getRejectspress3_freq() {
		return rejectspress3_freq;
	}
	/**
	 * @param rejectspress3_freq the rejectspress3_freq to set
	 */
	public void setRejectspress3_freq(String rejectspress3_freq) {
		this.rejectspress3_freq = rejectspress3_freq;
	}
	/**
	 * @return the rejectspress3_10am
	 */
	public String getRejectspress3_10am() {
		return rejectspress3_10am;
	}
	/**
	 * @param rejectspress3_10am the rejectspress3_10am to set
	 */
	public void setRejectspress3_10am(String rejectspress3_10am) {
		this.rejectspress3_10am = rejectspress3_10am;
	}
	/**
	 * @return the rejectspress3_02pm
	 */
	public String getRejectspress3_02pm() {
		return rejectspress3_02pm;
	}
	/**
	 * @param rejectspress3_02pm the rejectspress3_02pm to set
	 */
	public void setRejectspress3_02pm(String rejectspress3_02pm) {
		this.rejectspress3_02pm = rejectspress3_02pm;
	}
	/**
	 * @return the rejectspress3_06pm
	 */
	public String getRejectspress3_06pm() {
		return rejectspress3_06pm;
	}
	/**
	 * @param rejectspress3_06pm the rejectspress3_06pm to set
	 */
	public void setRejectspress3_06pm(String rejectspress3_06pm) {
		this.rejectspress3_06pm = rejectspress3_06pm;
	}
	/**
	 * @return the rejectspress3_10pm
	 */
	public String getRejectspress3_10pm() {
		return rejectspress3_10pm;
	}
	/**
	 * @param rejectspress3_10pm the rejectspress3_10pm to set
	 */
	public void setRejectspress3_10pm(String rejectspress3_10pm) {
		this.rejectspress3_10pm = rejectspress3_10pm;
	}
	/**
	 * @return the rejectspress3_02am
	 */
	public String getRejectspress3_02am() {
		return rejectspress3_02am;
	}
	/**
	 * @param rejectspress3_02am the rejectspress3_02am to set
	 */
	public void setRejectspress3_02am(String rejectspress3_02am) {
		this.rejectspress3_02am = rejectspress3_02am;
	}
	/**
	 * @return the rejectspress3_06am
	 */
	public String getRejectspress3_06am() {
		return rejectspress3_06am;
	}
	/**
	 * @param rejectspress3_06am the rejectspress3_06am to set
	 */
	public void setRejectspress3_06am(String rejectspress3_06am) {
		this.rejectspress3_06am = rejectspress3_06am;
	}
	/**
	 * @return the dewateringscrew1_freq
	 */
	public String getDewateringscrew1_freq() {
		return dewateringscrew1_freq;
	}
	/**
	 * @param dewateringscrew1_freq the dewateringscrew1_freq to set
	 */
	public void setDewateringscrew1_freq(String dewateringscrew1_freq) {
		this.dewateringscrew1_freq = dewateringscrew1_freq;
	}
	/**
	 * @return the dewateringscrew1_10am
	 */
	public String getDewateringscrew1_10am() {
		return dewateringscrew1_10am;
	}
	/**
	 * @param dewateringscrew1_10am the dewateringscrew1_10am to set
	 */
	public void setDewateringscrew1_10am(String dewateringscrew1_10am) {
		this.dewateringscrew1_10am = dewateringscrew1_10am;
	}
	/**
	 * @return the dewateringscrew1_02pm
	 */
	public String getDewateringscrew1_02pm() {
		return dewateringscrew1_02pm;
	}
	/**
	 * @param dewateringscrew1_02pm the dewateringscrew1_02pm to set
	 */
	public void setDewateringscrew1_02pm(String dewateringscrew1_02pm) {
		this.dewateringscrew1_02pm = dewateringscrew1_02pm;
	}
	/**
	 * @return the dewateringscrew1_06pm
	 */
	public String getDewateringscrew1_06pm() {
		return dewateringscrew1_06pm;
	}
	/**
	 * @param dewateringscrew1_06pm the dewateringscrew1_06pm to set
	 */
	public void setDewateringscrew1_06pm(String dewateringscrew1_06pm) {
		this.dewateringscrew1_06pm = dewateringscrew1_06pm;
	}
	/**
	 * @return the dewateringscrew1_10pm
	 */
	public String getDewateringscrew1_10pm() {
		return dewateringscrew1_10pm;
	}
	/**
	 * @param dewateringscrew1_10pm the dewateringscrew1_10pm to set
	 */
	public void setDewateringscrew1_10pm(String dewateringscrew1_10pm) {
		this.dewateringscrew1_10pm = dewateringscrew1_10pm;
	}
	/**
	 * @return the dewateringscrew1_02am
	 */
	public String getDewateringscrew1_02am() {
		return dewateringscrew1_02am;
	}
	/**
	 * @param dewateringscrew1_02am the dewateringscrew1_02am to set
	 */
	public void setDewateringscrew1_02am(String dewateringscrew1_02am) {
		this.dewateringscrew1_02am = dewateringscrew1_02am;
	}
	/**
	 * @return the dewateringscrew1_06am
	 */
	public String getDewateringscrew1_06am() {
		return dewateringscrew1_06am;
	}
	/**
	 * @param dewateringscrew1_06am the dewateringscrew1_06am to set
	 */
	public void setDewateringscrew1_06am(String dewateringscrew1_06am) {
		this.dewateringscrew1_06am = dewateringscrew1_06am;
	}
	/**
	 * @return the dewateringscrew2_freq
	 */
	public String getDewateringscrew2_freq() {
		return dewateringscrew2_freq;
	}
	/**
	 * @param dewateringscrew2_freq the dewateringscrew2_freq to set
	 */
	public void setDewateringscrew2_freq(String dewateringscrew2_freq) {
		this.dewateringscrew2_freq = dewateringscrew2_freq;
	}
	/**
	 * @return the dewateringscrew2_10am
	 */
	public String getDewateringscrew2_10am() {
		return dewateringscrew2_10am;
	}
	/**
	 * @param dewateringscrew2_10am the dewateringscrew2_10am to set
	 */
	public void setDewateringscrew2_10am(String dewateringscrew2_10am) {
		this.dewateringscrew2_10am = dewateringscrew2_10am;
	}
	/**
	 * @return the dewateringscrew2_02pm
	 */
	public String getDewateringscrew2_02pm() {
		return dewateringscrew2_02pm;
	}
	/**
	 * @param dewateringscrew2_02pm the dewateringscrew2_02pm to set
	 */
	public void setDewateringscrew2_02pm(String dewateringscrew2_02pm) {
		this.dewateringscrew2_02pm = dewateringscrew2_02pm;
	}
	/**
	 * @return the dewateringscrew2_06pm
	 */
	public String getDewateringscrew2_06pm() {
		return dewateringscrew2_06pm;
	}
	/**
	 * @param dewateringscrew2_06pm the dewateringscrew2_06pm to set
	 */
	public void setDewateringscrew2_06pm(String dewateringscrew2_06pm) {
		this.dewateringscrew2_06pm = dewateringscrew2_06pm;
	}
	/**
	 * @return the dewateringscrew2_10pm
	 */
	public String getDewateringscrew2_10pm() {
		return dewateringscrew2_10pm;
	}
	/**
	 * @param dewateringscrew2_10pm the dewateringscrew2_10pm to set
	 */
	public void setDewateringscrew2_10pm(String dewateringscrew2_10pm) {
		this.dewateringscrew2_10pm = dewateringscrew2_10pm;
	}
	/**
	 * @return the dewateringscrew2_02am
	 */
	public String getDewateringscrew2_02am() {
		return dewateringscrew2_02am;
	}
	/**
	 * @param dewateringscrew2_02am the dewateringscrew2_02am to set
	 */
	public void setDewateringscrew2_02am(String dewateringscrew2_02am) {
		this.dewateringscrew2_02am = dewateringscrew2_02am;
	}
	/**
	 * @return the dewateringscrew2_06am
	 */
	public String getDewateringscrew2_06am() {
		return dewateringscrew2_06am;
	}
	/**
	 * @param dewateringscrew2_06am the dewateringscrew2_06am to set
	 */
	public void setDewateringscrew2_06am(String dewateringscrew2_06am) {
		this.dewateringscrew2_06am = dewateringscrew2_06am;
	}
	/**
	 * @return the dewateringscrew3_freq
	 */
	public String getDewateringscrew3_freq() {
		return dewateringscrew3_freq;
	}
	/**
	 * @param dewateringscrew3_freq the dewateringscrew3_freq to set
	 */
	public void setDewateringscrew3_freq(String dewateringscrew3_freq) {
		this.dewateringscrew3_freq = dewateringscrew3_freq;
	}
	/**
	 * @return the dewateringscrew3_10am
	 */
	public String getDewateringscrew3_10am() {
		return dewateringscrew3_10am;
	}
	/**
	 * @param dewateringscrew3_10am the dewateringscrew3_10am to set
	 */
	public void setDewateringscrew3_10am(String dewateringscrew3_10am) {
		this.dewateringscrew3_10am = dewateringscrew3_10am;
	}
	/**
	 * @return the dewateringscrew3_02pm
	 */
	public String getDewateringscrew3_02pm() {
		return dewateringscrew3_02pm;
	}
	/**
	 * @param dewateringscrew3_02pm the dewateringscrew3_02pm to set
	 */
	public void setDewateringscrew3_02pm(String dewateringscrew3_02pm) {
		this.dewateringscrew3_02pm = dewateringscrew3_02pm;
	}
	/**
	 * @return the dewateringscrew3_06pm
	 */
	public String getDewateringscrew3_06pm() {
		return dewateringscrew3_06pm;
	}
	/**
	 * @param dewateringscrew3_06pm the dewateringscrew3_06pm to set
	 */
	public void setDewateringscrew3_06pm(String dewateringscrew3_06pm) {
		this.dewateringscrew3_06pm = dewateringscrew3_06pm;
	}
	/**
	 * @return the dewateringscrew3_10pm
	 */
	public String getDewateringscrew3_10pm() {
		return dewateringscrew3_10pm;
	}
	/**
	 * @param dewateringscrew3_10pm the dewateringscrew3_10pm to set
	 */
	public void setDewateringscrew3_10pm(String dewateringscrew3_10pm) {
		this.dewateringscrew3_10pm = dewateringscrew3_10pm;
	}
	/**
	 * @return the dewateringscrew3_02am
	 */
	public String getDewateringscrew3_02am() {
		return dewateringscrew3_02am;
	}
	/**
	 * @param dewateringscrew3_02am the dewateringscrew3_02am to set
	 */
	public void setDewateringscrew3_02am(String dewateringscrew3_02am) {
		this.dewateringscrew3_02am = dewateringscrew3_02am;
	}
	/**
	 * @return the dewateringscrew3_06am
	 */
	public String getDewateringscrew3_06am() {
		return dewateringscrew3_06am;
	}
	/**
	 * @param dewateringscrew3_06am the dewateringscrew3_06am to set
	 */
	public void setDewateringscrew3_06am(String dewateringscrew3_06am) {
		this.dewateringscrew3_06am = dewateringscrew3_06am;
	}
	/**
	 * @return the clarifiedwaterchest1_freq
	 */
	public String getClarifiedwaterchest1_freq() {
		return clarifiedwaterchest1_freq;
	}
	/**
	 * @param clarifiedwaterchest1_freq the clarifiedwaterchest1_freq to set
	 */
	public void setClarifiedwaterchest1_freq(String clarifiedwaterchest1_freq) {
		this.clarifiedwaterchest1_freq = clarifiedwaterchest1_freq;
	}
	/**
	 * @return the clarifiedwaterchest1_10am
	 */
	public String getClarifiedwaterchest1_10am() {
		return clarifiedwaterchest1_10am;
	}
	/**
	 * @param clarifiedwaterchest1_10am the clarifiedwaterchest1_10am to set
	 */
	public void setClarifiedwaterchest1_10am(String clarifiedwaterchest1_10am) {
		this.clarifiedwaterchest1_10am = clarifiedwaterchest1_10am;
	}
	/**
	 * @return the clarifiedwaterchest1_02pm
	 */
	public String getClarifiedwaterchest1_02pm() {
		return clarifiedwaterchest1_02pm;
	}
	/**
	 * @param clarifiedwaterchest1_02pm the clarifiedwaterchest1_02pm to set
	 */
	public void setClarifiedwaterchest1_02pm(String clarifiedwaterchest1_02pm) {
		this.clarifiedwaterchest1_02pm = clarifiedwaterchest1_02pm;
	}
	/**
	 * @return the clarifiedwaterchest1_06pm
	 */
	public String getClarifiedwaterchest1_06pm() {
		return clarifiedwaterchest1_06pm;
	}
	/**
	 * @param clarifiedwaterchest1_06pm the clarifiedwaterchest1_06pm to set
	 */
	public void setClarifiedwaterchest1_06pm(String clarifiedwaterchest1_06pm) {
		this.clarifiedwaterchest1_06pm = clarifiedwaterchest1_06pm;
	}
	/**
	 * @return the clarifiedwaterchest1_10pm
	 */
	public String getClarifiedwaterchest1_10pm() {
		return clarifiedwaterchest1_10pm;
	}
	/**
	 * @param clarifiedwaterchest1_10pm the clarifiedwaterchest1_10pm to set
	 */
	public void setClarifiedwaterchest1_10pm(String clarifiedwaterchest1_10pm) {
		this.clarifiedwaterchest1_10pm = clarifiedwaterchest1_10pm;
	}
	/**
	 * @return the clarifiedwaterchest1_02am
	 */
	public String getClarifiedwaterchest1_02am() {
		return clarifiedwaterchest1_02am;
	}
	/**
	 * @param clarifiedwaterchest1_02am the clarifiedwaterchest1_02am to set
	 */
	public void setClarifiedwaterchest1_02am(String clarifiedwaterchest1_02am) {
		this.clarifiedwaterchest1_02am = clarifiedwaterchest1_02am;
	}
	/**
	 * @return the clarifiedwaterchest1_06am
	 */
	public String getClarifiedwaterchest1_06am() {
		return clarifiedwaterchest1_06am;
	}
	/**
	 * @param clarifiedwaterchest1_06am the clarifiedwaterchest1_06am to set
	 */
	public void setClarifiedwaterchest1_06am(String clarifiedwaterchest1_06am) {
		this.clarifiedwaterchest1_06am = clarifiedwaterchest1_06am;
	}
	/**
	 * @return the clarifiedwaterchest2_freq
	 */
	public String getClarifiedwaterchest2_freq() {
		return clarifiedwaterchest2_freq;
	}
	/**
	 * @param clarifiedwaterchest2_freq the clarifiedwaterchest2_freq to set
	 */
	public void setClarifiedwaterchest2_freq(String clarifiedwaterchest2_freq) {
		this.clarifiedwaterchest2_freq = clarifiedwaterchest2_freq;
	}
	/**
	 * @return the clarifiedwaterchest2_10am
	 */
	public String getClarifiedwaterchest2_10am() {
		return clarifiedwaterchest2_10am;
	}
	/**
	 * @param clarifiedwaterchest2_10am the clarifiedwaterchest2_10am to set
	 */
	public void setClarifiedwaterchest2_10am(String clarifiedwaterchest2_10am) {
		this.clarifiedwaterchest2_10am = clarifiedwaterchest2_10am;
	}
	/**
	 * @return the clarifiedwaterchest2_02pm
	 */
	public String getClarifiedwaterchest2_02pm() {
		return clarifiedwaterchest2_02pm;
	}
	/**
	 * @param clarifiedwaterchest2_02pm the clarifiedwaterchest2_02pm to set
	 */
	public void setClarifiedwaterchest2_02pm(String clarifiedwaterchest2_02pm) {
		this.clarifiedwaterchest2_02pm = clarifiedwaterchest2_02pm;
	}
	/**
	 * @return the clarifiedwaterchest2_06pm
	 */
	public String getClarifiedwaterchest2_06pm() {
		return clarifiedwaterchest2_06pm;
	}
	/**
	 * @param clarifiedwaterchest2_06pm the clarifiedwaterchest2_06pm to set
	 */
	public void setClarifiedwaterchest2_06pm(String clarifiedwaterchest2_06pm) {
		this.clarifiedwaterchest2_06pm = clarifiedwaterchest2_06pm;
	}
	/**
	 * @return the clarifiedwaterchest2_10pm
	 */
	public String getClarifiedwaterchest2_10pm() {
		return clarifiedwaterchest2_10pm;
	}
	/**
	 * @param clarifiedwaterchest2_10pm the clarifiedwaterchest2_10pm to set
	 */
	public void setClarifiedwaterchest2_10pm(String clarifiedwaterchest2_10pm) {
		this.clarifiedwaterchest2_10pm = clarifiedwaterchest2_10pm;
	}
	/**
	 * @return the clarifiedwaterchest2_02am
	 */
	public String getClarifiedwaterchest2_02am() {
		return clarifiedwaterchest2_02am;
	}
	/**
	 * @param clarifiedwaterchest2_02am the clarifiedwaterchest2_02am to set
	 */
	public void setClarifiedwaterchest2_02am(String clarifiedwaterchest2_02am) {
		this.clarifiedwaterchest2_02am = clarifiedwaterchest2_02am;
	}
	/**
	 * @return the clarifiedwaterchest2_06am
	 */
	public String getClarifiedwaterchest2_06am() {
		return clarifiedwaterchest2_06am;
	}
	/**
	 * @param clarifiedwaterchest2_06am the clarifiedwaterchest2_06am to set
	 */
	public void setClarifiedwaterchest2_06am(String clarifiedwaterchest2_06am) {
		this.clarifiedwaterchest2_06am = clarifiedwaterchest2_06am;
	}
	/**
	 * @return the deinkwhitewaterchest1_freq
	 */
	public String getDeinkwhitewaterchest1_freq() {
		return deinkwhitewaterchest1_freq;
	}
	/**
	 * @param deinkwhitewaterchest1_freq the deinkwhitewaterchest1_freq to set
	 */
	public void setDeinkwhitewaterchest1_freq(String deinkwhitewaterchest1_freq) {
		this.deinkwhitewaterchest1_freq = deinkwhitewaterchest1_freq;
	}
	/**
	 * @return the deinkwhitewaterchest1_10am
	 */
	public String getDeinkwhitewaterchest1_10am() {
		return deinkwhitewaterchest1_10am;
	}
	/**
	 * @param deinkwhitewaterchest1_10am the deinkwhitewaterchest1_10am to set
	 */
	public void setDeinkwhitewaterchest1_10am(String deinkwhitewaterchest1_10am) {
		this.deinkwhitewaterchest1_10am = deinkwhitewaterchest1_10am;
	}
	/**
	 * @return the deinkwhitewaterchest1_02pm
	 */
	public String getDeinkwhitewaterchest1_02pm() {
		return deinkwhitewaterchest1_02pm;
	}
	/**
	 * @param deinkwhitewaterchest1_02pm the deinkwhitewaterchest1_02pm to set
	 */
	public void setDeinkwhitewaterchest1_02pm(String deinkwhitewaterchest1_02pm) {
		this.deinkwhitewaterchest1_02pm = deinkwhitewaterchest1_02pm;
	}
	/**
	 * @return the deinkwhitewaterchest1_06pm
	 */
	public String getDeinkwhitewaterchest1_06pm() {
		return deinkwhitewaterchest1_06pm;
	}
	/**
	 * @param deinkwhitewaterchest1_06pm the deinkwhitewaterchest1_06pm to set
	 */
	public void setDeinkwhitewaterchest1_06pm(String deinkwhitewaterchest1_06pm) {
		this.deinkwhitewaterchest1_06pm = deinkwhitewaterchest1_06pm;
	}
	/**
	 * @return the deinkwhitewaterchest1_10pm
	 */
	public String getDeinkwhitewaterchest1_10pm() {
		return deinkwhitewaterchest1_10pm;
	}
	/**
	 * @param deinkwhitewaterchest1_10pm the deinkwhitewaterchest1_10pm to set
	 */
	public void setDeinkwhitewaterchest1_10pm(String deinkwhitewaterchest1_10pm) {
		this.deinkwhitewaterchest1_10pm = deinkwhitewaterchest1_10pm;
	}
	/**
	 * @return the deinkwhitewaterchest1_02am
	 */
	public String getDeinkwhitewaterchest1_02am() {
		return deinkwhitewaterchest1_02am;
	}
	/**
	 * @param deinkwhitewaterchest1_02am the deinkwhitewaterchest1_02am to set
	 */
	public void setDeinkwhitewaterchest1_02am(String deinkwhitewaterchest1_02am) {
		this.deinkwhitewaterchest1_02am = deinkwhitewaterchest1_02am;
	}
	/**
	 * @return the deinkwhitewaterchest1_06am
	 */
	public String getDeinkwhitewaterchest1_06am() {
		return deinkwhitewaterchest1_06am;
	}
	/**
	 * @param deinkwhitewaterchest1_06am the deinkwhitewaterchest1_06am to set
	 */
	public void setDeinkwhitewaterchest1_06am(String deinkwhitewaterchest1_06am) {
		this.deinkwhitewaterchest1_06am = deinkwhitewaterchest1_06am;
	}
	/**
	 * @return the deinkwhitewaterchest2_freq
	 */
	public String getDeinkwhitewaterchest2_freq() {
		return deinkwhitewaterchest2_freq;
	}
	/**
	 * @param deinkwhitewaterchest2_freq the deinkwhitewaterchest2_freq to set
	 */
	public void setDeinkwhitewaterchest2_freq(String deinkwhitewaterchest2_freq) {
		this.deinkwhitewaterchest2_freq = deinkwhitewaterchest2_freq;
	}
	/**
	 * @return the deinkwhitewaterchest2_10am
	 */
	public String getDeinkwhitewaterchest2_10am() {
		return deinkwhitewaterchest2_10am;
	}
	/**
	 * @param deinkwhitewaterchest2_10am the deinkwhitewaterchest2_10am to set
	 */
	public void setDeinkwhitewaterchest2_10am(String deinkwhitewaterchest2_10am) {
		this.deinkwhitewaterchest2_10am = deinkwhitewaterchest2_10am;
	}
	/**
	 * @return the deinkwhitewaterchest2_02pm
	 */
	public String getDeinkwhitewaterchest2_02pm() {
		return deinkwhitewaterchest2_02pm;
	}
	/**
	 * @param deinkwhitewaterchest2_02pm the deinkwhitewaterchest2_02pm to set
	 */
	public void setDeinkwhitewaterchest2_02pm(String deinkwhitewaterchest2_02pm) {
		this.deinkwhitewaterchest2_02pm = deinkwhitewaterchest2_02pm;
	}
	/**
	 * @return the deinkwhitewaterchest2_06pm
	 */
	public String getDeinkwhitewaterchest2_06pm() {
		return deinkwhitewaterchest2_06pm;
	}
	/**
	 * @param deinkwhitewaterchest2_06pm the deinkwhitewaterchest2_06pm to set
	 */
	public void setDeinkwhitewaterchest2_06pm(String deinkwhitewaterchest2_06pm) {
		this.deinkwhitewaterchest2_06pm = deinkwhitewaterchest2_06pm;
	}
	/**
	 * @return the deinkwhitewaterchest2_10pm
	 */
	public String getDeinkwhitewaterchest2_10pm() {
		return deinkwhitewaterchest2_10pm;
	}
	/**
	 * @param deinkwhitewaterchest2_10pm the deinkwhitewaterchest2_10pm to set
	 */
	public void setDeinkwhitewaterchest2_10pm(String deinkwhitewaterchest2_10pm) {
		this.deinkwhitewaterchest2_10pm = deinkwhitewaterchest2_10pm;
	}
	/**
	 * @return the deinkwhitewaterchest2_02am
	 */
	public String getDeinkwhitewaterchest2_02am() {
		return deinkwhitewaterchest2_02am;
	}
	/**
	 * @param deinkwhitewaterchest2_02am the deinkwhitewaterchest2_02am to set
	 */
	public void setDeinkwhitewaterchest2_02am(String deinkwhitewaterchest2_02am) {
		this.deinkwhitewaterchest2_02am = deinkwhitewaterchest2_02am;
	}
	/**
	 * @return the deinkwhitewaterchest2_06am
	 */
	public String getDeinkwhitewaterchest2_06am() {
		return deinkwhitewaterchest2_06am;
	}
	/**
	 * @param deinkwhitewaterchest2_06am the deinkwhitewaterchest2_06am to set
	 */
	public void setDeinkwhitewaterchest2_06am(String deinkwhitewaterchest2_06am) {
		this.deinkwhitewaterchest2_06am = deinkwhitewaterchest2_06am;
	}
	/**
	 * @return the deinkwhitewaterchest3_freq
	 */
	public String getDeinkwhitewaterchest3_freq() {
		return deinkwhitewaterchest3_freq;
	}
	/**
	 * @param deinkwhitewaterchest3_freq the deinkwhitewaterchest3_freq to set
	 */
	public void setDeinkwhitewaterchest3_freq(String deinkwhitewaterchest3_freq) {
		this.deinkwhitewaterchest3_freq = deinkwhitewaterchest3_freq;
	}
	/**
	 * @return the deinkwhitewaterchest3_10am
	 */
	public String getDeinkwhitewaterchest3_10am() {
		return deinkwhitewaterchest3_10am;
	}
	/**
	 * @param deinkwhitewaterchest3_10am the deinkwhitewaterchest3_10am to set
	 */
	public void setDeinkwhitewaterchest3_10am(String deinkwhitewaterchest3_10am) {
		this.deinkwhitewaterchest3_10am = deinkwhitewaterchest3_10am;
	}
	/**
	 * @return the deinkwhitewaterchest3_02pm
	 */
	public String getDeinkwhitewaterchest3_02pm() {
		return deinkwhitewaterchest3_02pm;
	}
	/**
	 * @param deinkwhitewaterchest3_02pm the deinkwhitewaterchest3_02pm to set
	 */
	public void setDeinkwhitewaterchest3_02pm(String deinkwhitewaterchest3_02pm) {
		this.deinkwhitewaterchest3_02pm = deinkwhitewaterchest3_02pm;
	}
	/**
	 * @return the deinkwhitewaterchest3_06pm
	 */
	public String getDeinkwhitewaterchest3_06pm() {
		return deinkwhitewaterchest3_06pm;
	}
	/**
	 * @param deinkwhitewaterchest3_06pm the deinkwhitewaterchest3_06pm to set
	 */
	public void setDeinkwhitewaterchest3_06pm(String deinkwhitewaterchest3_06pm) {
		this.deinkwhitewaterchest3_06pm = deinkwhitewaterchest3_06pm;
	}
	/**
	 * @return the deinkwhitewaterchest3_10pm
	 */
	public String getDeinkwhitewaterchest3_10pm() {
		return deinkwhitewaterchest3_10pm;
	}
	/**
	 * @param deinkwhitewaterchest3_10pm the deinkwhitewaterchest3_10pm to set
	 */
	public void setDeinkwhitewaterchest3_10pm(String deinkwhitewaterchest3_10pm) {
		this.deinkwhitewaterchest3_10pm = deinkwhitewaterchest3_10pm;
	}
	/**
	 * @return the deinkwhitewaterchest3_02am
	 */
	public String getDeinkwhitewaterchest3_02am() {
		return deinkwhitewaterchest3_02am;
	}
	/**
	 * @param deinkwhitewaterchest3_02am the deinkwhitewaterchest3_02am to set
	 */
	public void setDeinkwhitewaterchest3_02am(String deinkwhitewaterchest3_02am) {
		this.deinkwhitewaterchest3_02am = deinkwhitewaterchest3_02am;
	}
	/**
	 * @return the deinkwhitewaterchest3_06am
	 */
	public String getDeinkwhitewaterchest3_06am() {
		return deinkwhitewaterchest3_06am;
	}
	/**
	 * @param deinkwhitewaterchest3_06am the deinkwhitewaterchest3_06am to set
	 */
	public void setDeinkwhitewaterchest3_06am(String deinkwhitewaterchest3_06am) {
		this.deinkwhitewaterchest3_06am = deinkwhitewaterchest3_06am;
	}
	/**
	 * @return the deinkwhitewaterchest4_freq
	 */
	public String getDeinkwhitewaterchest4_freq() {
		return deinkwhitewaterchest4_freq;
	}
	/**
	 * @param deinkwhitewaterchest4_freq the deinkwhitewaterchest4_freq to set
	 */
	public void setDeinkwhitewaterchest4_freq(String deinkwhitewaterchest4_freq) {
		this.deinkwhitewaterchest4_freq = deinkwhitewaterchest4_freq;
	}
	/**
	 * @return the deinkwhitewaterchest4_10am
	 */
	public String getDeinkwhitewaterchest4_10am() {
		return deinkwhitewaterchest4_10am;
	}
	/**
	 * @param deinkwhitewaterchest4_10am the deinkwhitewaterchest4_10am to set
	 */
	public void setDeinkwhitewaterchest4_10am(String deinkwhitewaterchest4_10am) {
		this.deinkwhitewaterchest4_10am = deinkwhitewaterchest4_10am;
	}
	/**
	 * @return the deinkwhitewaterchest4_02pm
	 */
	public String getDeinkwhitewaterchest4_02pm() {
		return deinkwhitewaterchest4_02pm;
	}
	/**
	 * @param deinkwhitewaterchest4_02pm the deinkwhitewaterchest4_02pm to set
	 */
	public void setDeinkwhitewaterchest4_02pm(String deinkwhitewaterchest4_02pm) {
		this.deinkwhitewaterchest4_02pm = deinkwhitewaterchest4_02pm;
	}
	/**
	 * @return the deinkwhitewaterchest4_06pm
	 */
	public String getDeinkwhitewaterchest4_06pm() {
		return deinkwhitewaterchest4_06pm;
	}
	/**
	 * @param deinkwhitewaterchest4_06pm the deinkwhitewaterchest4_06pm to set
	 */
	public void setDeinkwhitewaterchest4_06pm(String deinkwhitewaterchest4_06pm) {
		this.deinkwhitewaterchest4_06pm = deinkwhitewaterchest4_06pm;
	}
	/**
	 * @return the deinkwhitewaterchest4_10pm
	 */
	public String getDeinkwhitewaterchest4_10pm() {
		return deinkwhitewaterchest4_10pm;
	}
	/**
	 * @param deinkwhitewaterchest4_10pm the deinkwhitewaterchest4_10pm to set
	 */
	public void setDeinkwhitewaterchest4_10pm(String deinkwhitewaterchest4_10pm) {
		this.deinkwhitewaterchest4_10pm = deinkwhitewaterchest4_10pm;
	}
	/**
	 * @return the deinkwhitewaterchest4_02am
	 */
	public String getDeinkwhitewaterchest4_02am() {
		return deinkwhitewaterchest4_02am;
	}
	/**
	 * @param deinkwhitewaterchest4_02am the deinkwhitewaterchest4_02am to set
	 */
	public void setDeinkwhitewaterchest4_02am(String deinkwhitewaterchest4_02am) {
		this.deinkwhitewaterchest4_02am = deinkwhitewaterchest4_02am;
	}
	/**
	 * @return the deinkwhitewaterchest4_06am
	 */
	public String getDeinkwhitewaterchest4_06am() {
		return deinkwhitewaterchest4_06am;
	}
	/**
	 * @param deinkwhitewaterchest4_06am the deinkwhitewaterchest4_06am to set
	 */
	public void setDeinkwhitewaterchest4_06am(String deinkwhitewaterchest4_06am) {
		this.deinkwhitewaterchest4_06am = deinkwhitewaterchest4_06am;
	}
	/**
	 * @return the deinkwhitewaterchest5_freq
	 */
	public String getDeinkwhitewaterchest5_freq() {
		return deinkwhitewaterchest5_freq;
	}
	/**
	 * @param deinkwhitewaterchest5_freq the deinkwhitewaterchest5_freq to set
	 */
	public void setDeinkwhitewaterchest5_freq(String deinkwhitewaterchest5_freq) {
		this.deinkwhitewaterchest5_freq = deinkwhitewaterchest5_freq;
	}
	/**
	 * @return the deinkwhitewaterchest5_10am
	 */
	public String getDeinkwhitewaterchest5_10am() {
		return deinkwhitewaterchest5_10am;
	}
	/**
	 * @param deinkwhitewaterchest5_10am the deinkwhitewaterchest5_10am to set
	 */
	public void setDeinkwhitewaterchest5_10am(String deinkwhitewaterchest5_10am) {
		this.deinkwhitewaterchest5_10am = deinkwhitewaterchest5_10am;
	}
	/**
	 * @return the deinkwhitewaterchest5_02pm
	 */
	public String getDeinkwhitewaterchest5_02pm() {
		return deinkwhitewaterchest5_02pm;
	}
	/**
	 * @param deinkwhitewaterchest5_02pm the deinkwhitewaterchest5_02pm to set
	 */
	public void setDeinkwhitewaterchest5_02pm(String deinkwhitewaterchest5_02pm) {
		this.deinkwhitewaterchest5_02pm = deinkwhitewaterchest5_02pm;
	}
	/**
	 * @return the deinkwhitewaterchest5_06pm
	 */
	public String getDeinkwhitewaterchest5_06pm() {
		return deinkwhitewaterchest5_06pm;
	}
	/**
	 * @param deinkwhitewaterchest5_06pm the deinkwhitewaterchest5_06pm to set
	 */
	public void setDeinkwhitewaterchest5_06pm(String deinkwhitewaterchest5_06pm) {
		this.deinkwhitewaterchest5_06pm = deinkwhitewaterchest5_06pm;
	}
	/**
	 * @return the deinkwhitewaterchest5_10pm
	 */
	public String getDeinkwhitewaterchest5_10pm() {
		return deinkwhitewaterchest5_10pm;
	}
	/**
	 * @param deinkwhitewaterchest5_10pm the deinkwhitewaterchest5_10pm to set
	 */
	public void setDeinkwhitewaterchest5_10pm(String deinkwhitewaterchest5_10pm) {
		this.deinkwhitewaterchest5_10pm = deinkwhitewaterchest5_10pm;
	}
	/**
	 * @return the deinkwhitewaterchest5_02am
	 */
	public String getDeinkwhitewaterchest5_02am() {
		return deinkwhitewaterchest5_02am;
	}
	/**
	 * @param deinkwhitewaterchest5_02am the deinkwhitewaterchest5_02am to set
	 */
	public void setDeinkwhitewaterchest5_02am(String deinkwhitewaterchest5_02am) {
		this.deinkwhitewaterchest5_02am = deinkwhitewaterchest5_02am;
	}
	/**
	 * @return the deinkwhitewaterchest5_06am
	 */
	public String getDeinkwhitewaterchest5_06am() {
		return deinkwhitewaterchest5_06am;
	}
	/**
	 * @param deinkwhitewaterchest5_06am the deinkwhitewaterchest5_06am to set
	 */
	public void setDeinkwhitewaterchest5_06am(String deinkwhitewaterchest5_06am) {
		this.deinkwhitewaterchest5_06am = deinkwhitewaterchest5_06am;
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

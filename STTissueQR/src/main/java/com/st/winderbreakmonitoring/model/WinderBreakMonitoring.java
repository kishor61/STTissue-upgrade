/**
 *Oct 29, 2015
 *WinderBreakMonitoring.java
 * TODO
 *com.st.winderbreakmonitoring.model
 *WinderBreakMonitoring.java
 *Sunil Singh Bora
 */
package com.st.winderbreakmonitoring.model;

import java.util.Date;

/**
 * @author roshan
 *
 */
public class WinderBreakMonitoring {

	private int id;
	private Date date;
	private String Shift;
	private String Crew;
	private String Reel;
	private String SetNo;
	private String BreakAt;
	private String Losstime;
	private String Reasonforbreak;
	private String LeftoutinSpool;
	private String winderbreakreason;
	
	private String breakAt;
	private Date stoptime;
	private Date starttime;
	private String downtime;
	private String reason;
	
	private String primarycode;
	private String secondarycode;
	
	private String gradeCode;
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
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}
	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}
	/**
	 * @return the shift
	 */
	public String getShift() {
		return Shift;
	}
	/**
	 * @param shift the shift to set
	 */
	public void setShift(String shift) {
		Shift = shift;
	}
	/**
	 * @return the crew
	 */
	public String getCrew() {
		return Crew;
	}
	/**
	 * @param crew the crew to set
	 */
	public void setCrew(String crew) {
		Crew = crew;
	}
	/**
	 * @return the reel
	 */
	public String getReel() {
		return Reel;
	}
	/**
	 * @param reel the reel to set
	 */
	public void setReel(String reel) {
		Reel = reel;
	}
	/**
	 * @return the setNo
	 */
	public String getSetNo() {
		return SetNo;
	}
	/**
	 * @param setNo the setNo to set
	 */
	public void setSetNo(String setNo) {
		SetNo = setNo;
	}
	/**
	 * @return the breakAt
	 */
	public String getBreakAt() {
		return BreakAt;
	}
	/**
	 * @param breakAt the breakAt to set
	 */
	public void setBreakAt(String breakAt) {
		BreakAt = breakAt;
	}
	/**
	 * @return the losstime
	 */
	public String getLosstime() {
		return Losstime;
	}
	/**
	 * @param losstime the losstime to set
	 */
	public void setLosstime(String losstime) {
		Losstime = losstime;
	}
	/**
	 * @return the reasonforbreak
	 */
	public String getReasonforbreak() {
		return Reasonforbreak;
	}
	/**
	 * @param reasonforbreak the reasonforbreak to set
	 */
	public void setReasonforbreak(String reasonforbreak) {
		Reasonforbreak = reasonforbreak;
	}
	/**
	 * @return the leftoutinSpool
	 */
	public String getLeftoutinSpool() {
		return LeftoutinSpool;
	}
	/**
	 * @param leftoutinSpool the leftoutinSpool to set
	 */
	public void setLeftoutinSpool(String leftoutinSpool) {
		LeftoutinSpool = leftoutinSpool;
	}
	/**
	 * @return the winderbreakreason
	 */
	public String getWinderbreakreason() {
		return winderbreakreason;
	}
	/**
	 * @param winderbreakreason the winderbreakreason to set
	 */
	public void setWinderbreakreason(String winderbreakreason) {
		this.winderbreakreason = winderbreakreason;
	}
	public Date getStoptime() {
		return stoptime;
	}
	public void setStoptime(Date stoptime) {
		this.stoptime = stoptime;
	}
	public Date getStarttime() {
		return starttime;
	}
	public void setStarttime(Date starttime) {
		this.starttime = starttime;
	}
	public String getDowntime() {
		return downtime;
	}
	public void setDowntime(String downtime) {
		this.downtime = downtime;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getPrimarycode() {
		return primarycode;
	}
	public void setPrimarycode(String primarycode) {
		this.primarycode = primarycode;
	}
	public String getSecondarycode() {
		return secondarycode;
	}
	public void setSecondarycode(String secondarycode) {
		this.secondarycode = secondarycode;
	}
	public String getGradeCode() {
		return gradeCode;
	}
	public void setGradeCode(String gradeCode) {
		this.gradeCode = gradeCode;
	}
}

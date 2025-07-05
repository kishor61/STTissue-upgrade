/**
 *May 1, 2017
 *CLRewinder.java
 * TODO
 *com.st.clrewinder.model
 *CLRewinder.java
 *Roshan Lal Tailor
 */
package com.st.clrewinder.model;

import java.util.Date;

/**
 * @author roshan
 *
 */
public class CLRewinder {

	private int id;
	private Date date;
	private String Shift;
	private String Crew;
	private String Reel;
	private String SetNo;
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
	
	private int occurrence;
	private long totalhr;
	private long totalmin;
	
	private long grandtotalhr;
	private long grandtotalmin;
	private String comment;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getShift() {
		return Shift;
	}

	public void setShift(String shift) {
		Shift = shift;
	}

	public String getCrew() {
		return Crew;
	}

	public void setCrew(String crew) {
		Crew = crew;
	}

	public String getReel() {
		return Reel;
	}

	public void setReel(String reel) {
		Reel = reel;
	}

	public String getSetNo() {
		return SetNo;
	}

	public void setSetNo(String setNo) {
		SetNo = setNo;
	}

	public String getLosstime() {
		return Losstime;
	}

	public void setLosstime(String losstime) {
		Losstime = losstime;
	}

	public String getReasonforbreak() {
		return Reasonforbreak;
	}

	public void setReasonforbreak(String reasonforbreak) {
		Reasonforbreak = reasonforbreak;
	}

	public String getLeftoutinSpool() {
		return LeftoutinSpool;
	}

	public void setLeftoutinSpool(String leftoutinSpool) {
		LeftoutinSpool = leftoutinSpool;
	}

	public String getWinderbreakreason() {
		return winderbreakreason;
	}

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

	public String getBreakAt() {
		return breakAt;
	}

	public void setBreakAt(String breakAt) {
		this.breakAt = breakAt;
	}

	public int getOccurrence() {
		return occurrence;
	}

	public void setOccurrence(int occurrence) {
		this.occurrence = occurrence;
	}

	public long getTotalhr() {
		return totalhr;
	}

	public void setTotalhr(long totalhr) {
		this.totalhr = totalhr;
	}

	public long getTotalmin() {
		return totalmin;
	}

	public void setTotalmin(long totalmin) {
		this.totalmin = totalmin;
	}

	public long getGrandtotalhr() {
		return grandtotalhr;
	}

	public void setGrandtotalhr(long grandtotalhr) {
		this.grandtotalhr = grandtotalhr;
	}

	public long getGrandtotalmin() {
		return grandtotalmin;
	}

	public void setGrandtotalmin(long grandtotalmin) {
		this.grandtotalmin = grandtotalmin;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
}

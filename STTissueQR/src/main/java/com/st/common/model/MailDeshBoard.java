/**
 *09-Jun-2020
 *MailDehBoard.java
 * TODO
 *com.st.common.model
 *MailDehBoard.java
 *Sohan Lal
 */
package com.st.common.model;

import java.util.Date;

/**
 * @author sohan
 *
 */
public class MailDeshBoard {
	private int id;
	private Date date;
	private Date time;
	private String reportId;
	private String reportName;	
	private String frquencyOfMail;
	private String timeToCheck;
	private String status;
	private String erroCode;
	private String senderName;
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
	 * @return the time
	 */
	public Date getTime() {
		return time;
	}
	/**
	 * @param time the time to set
	 */
	public void setTime(Date time) {
		this.time = time;
	}
	/**
	 * @return the reportName
	 */
	public String getReportName() {
		return reportName;
	}
	/**
	 * @return the reportId
	 */
	public String getReportId() {
		return reportId;
	}
	/**
	 * @param reportId the reportId to set
	 */
	public void setReportId(String reportId) {
		this.reportId = reportId;
	}
	/**
	 * @param reportName the reportName to set
	 */
	public void setReportName(String reportName) {
		this.reportName = reportName;
	}
	/**
	 * @return the frquencyOfMail
	 */
	public String getFrquencyOfMail() {
		return frquencyOfMail;
	}
	/**
	 * @param frquencyOfMail the frquencyOfMail to set
	 */
	public void setFrquencyOfMail(String frquencyOfMail) {
		this.frquencyOfMail = frquencyOfMail;
	}
	/**
	 * @return the timeToCheck
	 */
	public String getTimeToCheck() {
		return timeToCheck;
	}
	/**
	 * @param timeToCheck the timeToCheck to set
	 */
	public void setTimeToCheck(String timeToCheck) {
		this.timeToCheck = timeToCheck;
	}
	
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * @return the erroCode
	 */
	public String getErroCode() {
		return erroCode;
	}
	/**
	 * @param erroCode the erroCode to set
	 */
	public void setErroCode(String erroCode) {
		this.erroCode = erroCode;
	}
	/**
	 * @return the senderName
	 */
	public String getSenderName() {
		return senderName;
	}
	/**
	 * @param senderName the senderName to set
	 */
	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}
}

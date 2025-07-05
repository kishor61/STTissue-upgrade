/**
 *22-Jan-2020
 *PositiveObservationP.java
 * TODO
 *com.st.safetylog.model
 *PositiveObservationP.java
 *Roshan Lal Tailor
 */
package com.st.safetylog.model;

/**
 * @author sohan
 *
 */
public class PositiveObservationP {

	private int id;
	private String date;
	private int auditStatus;
	private String auditorId;
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
	 * @return the auditStatus
	 */
	public int getAuditStatus() {
		return auditStatus;
	}
	/**
	 * @param auditStatus the auditStatus to set
	 */
	public void setAuditStatus(int auditStatus) {
		this.auditStatus = auditStatus;
	}
	/**
	 * @return the auditorId
	 */
	public String getAuditorId() {
		return auditorId;
	}
	/**
	 * @param auditorId the auditorId to set
	 */
	public void setAuditorId(String auditorId) {
		this.auditorId = auditorId;
	}
	
}

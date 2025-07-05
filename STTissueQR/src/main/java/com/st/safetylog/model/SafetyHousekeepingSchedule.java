/**
 * 
 */
package com.st.safetylog.model;

import java.util.Date;

/**
 * @author sbora
 *
 */
public class SafetyHousekeepingSchedule {
	private int id;
	private int auditor;
	private int area;
	private String recurrence;
	private Date date;
	private boolean auditStatus;
/*	private String weekId;
	private String monthId;
	private String dayId;
	*/
	
	private boolean deleted;
	
	private Date fromDate;
	private Date toDate;
	
	//Temp
	private String formatedDate;
	private String areaName;
	private String auditorName;
	private String auditorEamil;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAuditor() {
		return auditor;
	}
	public void setAuditor(int auditor) {
		this.auditor = auditor;
	}
	public int getArea() {
		return area;
	}
	public void setArea(int area) {
		this.area = area;
	}
	public String getRecurrence() {
		return recurrence;
	}
	public void setRecurrence(String recurrence) {
		this.recurrence = recurrence;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public boolean isDeleted() {
		return deleted;
	}
	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
	public Date getToDate() {
		return toDate;
	}
	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}
	public Date getFromDate() {
		return fromDate;
	}
	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}
/*	public String getMonthId() {
		return monthId;
	}
	public void setMonthId(String monthId) {
		this.monthId = monthId;
	}
	public String getWeekId() {
		return weekId;
	}
	public void setWeekId(String weekId) {
		this.weekId = weekId;
	}
	public String getDayId() {
		return dayId;
	}
	public void setDayId(String dayId) {
		this.dayId = dayId;
	}*/
	public String getFormatedDate() {
		return formatedDate;
	}
	public void setFormatedDate(String formatedDate) {
		this.formatedDate = formatedDate;
	}
	public String getAreaName() {
		return areaName;
	}
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
	public String getAuditorName() {
		return auditorName;
	}
	public void setAuditorName(String auditorName) {
		this.auditorName = auditorName;
	}
	public String getAuditorEamil() {
		return auditorEamil;
	}
	public void setAuditorEamil(String auditorEamil) {
		this.auditorEamil = auditorEamil;
	}
	public boolean isAuditStatus() {
		return auditStatus;
	}
	public void setAuditStatus(boolean auditStatus) {
		this.auditStatus = auditStatus;
	}
	
}

/**
 * 
 */
package com.st.safetylog.model;

import java.util.Date;

/**
 * @author roshan
 * 
 */
public class SafetyLog {
	private int id;
	private Date date;
	private String description;
	private String employee;
	private int forkliftShutdown;
	private int propertyDamage;
	private int unsafeWork;
	private int fire;
	private int nearMiss;
	private int firstAid;
	private int recordable;
	private int lostTime;
	private int other;
	private Date dayToCompletion;
	private String area;
	private String remarks;
	private String actionitems;
	private String categoryofincidents;

	private Date incidentDate;
	
	//Temp
	private int numOfdays;
	private int daysToReport;
	
	
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getEmployee() {
		return employee;
	}

	public void setEmployee(String employee) {
		this.employee = employee;
	}

	public int getForkliftShutdown() {
		return forkliftShutdown;
	}

	public void setForkliftShutdown(int forkliftShutdown) {
		this.forkliftShutdown = forkliftShutdown;
	}

	public int getPropertyDamage() {
		return propertyDamage;
	}

	public void setPropertyDamage(int propertyDamage) {
		this.propertyDamage = propertyDamage;
	}

	public int getUnsafeWork() {
		return unsafeWork;
	}

	public void setUnsafeWork(int unsafeWork) {
		this.unsafeWork = unsafeWork;
	}

	public int getFire() {
		return fire;
	}

	public void setFire(int fire) {
		this.fire = fire;
	}

	public int getNearMiss() {
		return nearMiss;
	}

	public void setNearMiss(int nearMiss) {
		this.nearMiss = nearMiss;
	}

	public int getFirstAid() {
		return firstAid;
	}

	public void setFirstAid(int firstAid) {
		this.firstAid = firstAid;
	}

	public int getRecordable() {
		return recordable;
	}

	public void setRecordable(int recordable) {
		this.recordable = recordable;
	}

	public int getLostTime() {
		return lostTime;
	}

	public void setLostTime(int lostTime) {
		this.lostTime = lostTime;
	}

	public int getOther() {
		return other;
	}

	public void setOther(int other) {
		this.other = other;
	}

	

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Date getDayToCompletion() {
		return dayToCompletion;
	}

	public void setDayToCompletion(Date dayToCompletion) {
		this.dayToCompletion = dayToCompletion;
	}

	public int getNumOfdays() {
		return numOfdays;
	}

	public void setNumOfdays(int numOfdays) {
		this.numOfdays = numOfdays;
	}

	public Date getIncidentDate() {
		return incidentDate;
	}

	public void setIncidentDate(Date incidentDate) {
		this.incidentDate = incidentDate;
	}

	public int getDaysToReport() {
		return daysToReport;
	}

	public void setDaysToReport(int daysToReport) {
		this.daysToReport = daysToReport;
	}

	public String getActionitems() {
		return actionitems;
	}

	public void setActionitems(String actionitems) {
		this.actionitems = actionitems;
	}

	public String getCategoryofincidents() {
		return categoryofincidents;
	}

	public void setCategoryofincidents(String categoryofincidents) {
		this.categoryofincidents = categoryofincidents;
	}

}

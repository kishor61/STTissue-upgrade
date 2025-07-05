/**
 *May 24, 2021
 *EmergencyIncident.java
 * TODO
 *com.st.Emergency.model
 *EmergencyIncident.java
 *Sohan Lal 
 */
package com.st.Emergency.model;

/**
 * @author kishore
 *
 */

public class EmergencyIncident {
	private int id;
	private String effectedbytheincident;
	private String incidentType;
	private String employeeNumber;
	private String sdate;
	private String edate;
	private String crew;
	private String shift;
	private String safeReport;
	private String status;
	private String yourStartArea;
	private String dateOfIncident ;
	private String timeOfIncident;
	private String dateReported;
	private String starIncidentLocation;
	private String locationIncidentOccured;
	private String descpOfEvent;
	private String starCategory;
	private String furtherFollowUpRequested;
	private String investigation;
	private boolean edited;
	
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
	 * @return the incidentType
	 */
	public String getIncidentType() {
		return incidentType;
	}
	/**
	 * @param incidentType the incidentType to set
	 */
	public void setIncidentType(String incidentType) {
		this.incidentType = incidentType;
	}
	/**
	 * @return the effectedbytheincident
	 */
	public String getEffectedbytheincident() {
		return effectedbytheincident;
	}
	/**
	 * @param effectedbytheincident the effectedbytheincident to set
	 */
	public void setEffectedbytheincident(String effectedbytheincident) {
		this.effectedbytheincident = effectedbytheincident;
	}
	/**
	 * @return the employeeNumber
	 */
	public String getEmployeeNumber() {
		return employeeNumber;
	}
	/**
	 * @param employeeNumber the employeeNumber to set
	 */
	public void setEmployeeNumber(String employeeNumber) {
		this.employeeNumber = employeeNumber;
	}
	/**
	 * @return the edate
	 */
	public String getEdate() {
		return edate;
	}
	/**
	 * @return the sdate
	 */
	public String getSdate() {
		return sdate;
	}
	/**
	 * @param sdate the sdate to set
	 */
	public void setSdate(String sdate) {
		this.sdate = sdate;
	}
	/**
	 * @param edate the edate to set
	 */
	public void setEdate(String edate) {
		this.edate = edate;
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
	 * @return the safeReport
	 */
	public String getSafeReport() {
		return safeReport;
	}
	/**
	 * @param safeReport the safeReport to set
	 */
	public void setSafeReport(String safeReport) {
		this.safeReport = safeReport;
	}
	
	/**
	 * @return the yourStartArea
	 */
	public String getYourStartArea() {
		return yourStartArea;
	}
	/**
	 * @param yourStartArea the yourStartArea to set
	 */
	public void setYourStartArea(String yourStartArea) {
		this.yourStartArea = yourStartArea;
	}
	
	
	/**
	 * @return the starIncidentLocation
	 */
	public String getStarIncidentLocation() {
		return starIncidentLocation;
	}
	/**
	 * @param starIncidentLocation the starIncidentLocation to set
	 */
	public void setStarIncidentLocation(String starIncidentLocation) {
		this.starIncidentLocation = starIncidentLocation;
	}
	/**
	 * @return the locationIncidentOccured
	 */
	public String getLocationIncidentOccured() {
		return locationIncidentOccured;
	}
	/**
	 * @param locationIncidentOccured the locationIncidentOccured to set
	 */
	public void setLocationIncidentOccured(String locationIncidentOccured) {
		this.locationIncidentOccured = locationIncidentOccured;
	}
	/**
	 * @return the descpOfEvent
	 */
	public String getDescpOfEvent() {
		return descpOfEvent;
	}
	/**
	 * @param descpOfEvent the descpOfEvent to set
	 */
	public void setDescpOfEvent(String descpOfEvent) {
		this.descpOfEvent = descpOfEvent;
	}
	/**
	 * @return the starCategory
	 */
	public String getStarCategory() {
		return starCategory;
	}
	/**
	 * @param starCategory the starCategory to set
	 */
	public void setStarCategory(String starCategory) {
		this.starCategory = starCategory;
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
	 * @return the dateOfIncident
	 */
	public String getDateOfIncident() {
		return dateOfIncident;
	}
	/**
	 * @param dateOfIncident the dateOfIncident to set
	 */
	public void setDateOfIncident(String dateOfIncident) {
		this.dateOfIncident = dateOfIncident;
	}
	/**
	 * @return the timeOfIncident
	 */
	public String getTimeOfIncident() {
		return timeOfIncident;
	}
	/**
	 * @param timeOfIncident the timeOfIncident to set
	 */
	public void setTimeOfIncident(String timeOfIncident) {
		this.timeOfIncident = timeOfIncident;
	}
	/**
	 * @return the dateReported
	 */
	public String getDateReported() {
		return dateReported;
	}
	/**
	 * @param dateReported the dateReported to set
	 */
	public void setDateReported(String dateReported) {
		this.dateReported = dateReported;
	}
	/**
	 * @return the furtherFollowUpRequested
	 */
	public String getFurtherFollowUpRequested() {
		return furtherFollowUpRequested;
	}
	/**
	 * @param furtherFollowUpRequested the furtherFollowUpRequested to set
	 */
	public void setFurtherFollowUpRequested(String furtherFollowUpRequested) {
		this.furtherFollowUpRequested = furtherFollowUpRequested;
	}
	/**
	 * @return the edited
	 */
	public boolean isEdited() {
		return edited;
	}
	/**
	 * @param edited the edited to set
	 */
	public void setEdited(boolean edited) {
		this.edited = edited;
	}
	/**
	 * @return the investigation
	 */
	public String getInvestigation() {
		return investigation;
	}
	/**
	 * @param investigation the investigation to set
	 */
	public void setInvestigation(String investigation) {
		this.investigation = investigation;
	}
	
	
	
}

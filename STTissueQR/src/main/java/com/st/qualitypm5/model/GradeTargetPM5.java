/**
 *Dec 21, 2017
 *GradeTargetPM5.java
 * TODO
 *com.st.qualitypm5.model
 *GradeTargetPM5.java
 *Roshan Lal Tailor
 */
package com.st.qualitypm5.model;

/**
 * @author roshan
 *
 */
public class GradeTargetPM5 {

	private String gradeCode;
	private String physicalProperty;
	private double rejectMin;
	private double controlMin;
	private double target;
	private double controlMax;
	private double rejectMax;
	private String note;
	
	private String propertyName;
	private String unitName;
	public String getGradeCode() {
		return gradeCode;
	}
	public void setGradeCode(String gradeCode) {
		this.gradeCode = gradeCode;
	}
	public String getPhysicalProperty() {
		return physicalProperty;
	}
	public void setPhysicalProperty(String physicalProperty) {
		this.physicalProperty = physicalProperty;
	}
	public double getRejectMin() {
		return rejectMin;
	}
	public void setRejectMin(double rejectMin) {
		this.rejectMin = rejectMin;
	}
	public double getControlMin() {
		return controlMin;
	}
	public void setControlMin(double controlMin) {
		this.controlMin = controlMin;
	}
	public double getTarget() {
		return target;
	}
	public void setTarget(double target) {
		this.target = target;
	}
	public double getControlMax() {
		return controlMax;
	}
	public void setControlMax(double controlMax) {
		this.controlMax = controlMax;
	}
	public double getRejectMax() {
		return rejectMax;
	}
	public void setRejectMax(double rejectMax) {
		this.rejectMax = rejectMax;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public String getPropertyName() {
		return propertyName;
	}
	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}
	public String getUnitName() {
		return unitName;
	}
	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}
}

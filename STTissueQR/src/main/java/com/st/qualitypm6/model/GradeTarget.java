package com.st.qualitypm6.model;

public class GradeTarget {
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

	public String getPhysicalProperty() {
		return physicalProperty;
	}

	public double getRejectMin() {
		return rejectMin;
	}

	public double getControlMin() {
		return controlMin;
	}

	public double getTarget() {
		return target;
	}

	public double getControlMax() {
		return controlMax;
	}

	public double getRejectMax() {
		return rejectMax;
	}

	public String getNote() {
		return note;
	}

	public void setGradeCode(String gradeCode) {
		this.gradeCode = gradeCode;
	}

	public void setPhysicalProperty(String physicalProperty) {
		this.physicalProperty = physicalProperty;
	}

	public void setRejectMin(double rejectMin) {
		this.rejectMin = rejectMin;
	}

	public void setControlMin(double controlMin) {
		this.controlMin = controlMin;
	}

	public void setTarget(double target) {
		this.target = target;
	}

	public void setControlMax(double controlMax) {
		this.controlMax = controlMax;
	}

	public void setRejectMax(double rejectMax) {
		this.rejectMax = rejectMax;
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

/**
 * 
 */
package com.st.production.model;

/**
 * @author sbora
 *
 */
public class MachineProductionSummary {
	private String gradeCode;
	private double dayWeight=0;
	private double nightWeight=0;
	private double rejected;
	private String comments="";
	
	
	public String getGradeCode() {
		return gradeCode;
	}
	public void setGradeCode(String gradeCode) {
		this.gradeCode = gradeCode;
	}
	public double getDayWeight() {
		return dayWeight;
	}
	public void setDayWeight(double dayWeight) {
		this.dayWeight = dayWeight;
	}
	public double getNightWeight() {
		return nightWeight;
	}
	public void setNightWeight(double nightWeight) {
		this.nightWeight = nightWeight;
	}
	public double getRejected() {
		return rejected;
	}
	public void setRejected(double rejected) {
		this.rejected = rejected;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
}

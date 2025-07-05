/**
 * 
 */
package com.st.tracker.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sbora
 *
 */
public class ProjectionData {
	
	private int gradeCode;
	private String grade;
	private double weight;
	
	private List<Integer> inbounds=new ArrayList<>(); 
	private List<PurchaseHeaderDetail> headerDetails=new ArrayList<>();
	
	public int getGradeCode() {
		return gradeCode;
	}
	public void setGradeCode(int gradeCode) {
		this.gradeCode = gradeCode;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public List<Integer> getInbounds() {
		return inbounds;
	}
	public void setInbounds(List<Integer> inbounds) {
		this.inbounds = inbounds;
	}
	public List<PurchaseHeaderDetail> getHeaderDetails() {
		return headerDetails;
	}
	public void setHeaderDetails(List<PurchaseHeaderDetail> headerDetails) {
		this.headerDetails = headerDetails;
	}
	
	
}

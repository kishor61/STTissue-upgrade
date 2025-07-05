package com.st.qualitypm6.model;

import java.util.Date;

public class Grade {
	private String gradeCode;
	private Date revisionDate;
	private String tmNo;
	private String description;
	private String customerGrade;
	private String customer;
	private String tissueApproval;
	private String customerApproval;
	private String notes;
	private String visualStandard;
	private String trimMin;
	private String trimTarget;
	private String trimMax;
	private String diameterMin;
	private String diameterTarget;
	private String diameterMax;
	private String breakMin;
	private String breakTarget;
	private String breakMax;
	private String specialInstruction;
	

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Grade [gradeCode=" + gradeCode + ", revisionDate=" + revisionDate + ", tmNo=" + tmNo + ", description="
				+ description + ", customerGrade=" + customerGrade + ", customer=" + customer + ", tissueApproval="
				+ tissueApproval + ", customerApproval=" + customerApproval + ", notes=" + notes + ", visualStandard="
				+ visualStandard + ", trimMin=" + trimMin + ", trimTarget=" + trimTarget + ", trimMax=" + trimMax
				+ ", diameterMin=" + diameterMin + ", diameterTarget=" + diameterTarget + ", diameterMax=" + diameterMax
				+ ", breakMin=" + breakMin + ", breakTarget=" + breakTarget + ", breakMax=" + breakMax
				+ ", specialInstruction=" + specialInstruction + "]";
	}



	public String getVisualStandard() {
		return visualStandard;
	}



	public String getDiameterMin() {
		return diameterMin;
	}

	public String getDiameterTarget() {
		return diameterTarget;
	}

	public String getDiameterMax() {
		return diameterMax;
	}

	public String getBreakMin() {
		return breakMin;
	}

	public String getBreakTarget() {
		return breakTarget;
	}

	public String getBreakMax() {
		return breakMax;
	}

	public String getSpecialInstruction() {
		return specialInstruction;
	}

	public void setVisualStandard(String visualStandard) {
		this.visualStandard = visualStandard;
	}



	public void setDiameterMin(String diameterMin) {
		this.diameterMin = diameterMin;
	}

	public void setDiameterTarget(String diameterTarget) {
		this.diameterTarget = diameterTarget;
	}

	public void setDiameterMax(String diameterMax) {
		this.diameterMax = diameterMax;
	}

	public void setBreakMin(String breakMin) {
		this.breakMin = breakMin;
	}

	public void setBreakTarget(String breakTarget) {
		this.breakTarget = breakTarget;
	}

	public void setBreakMax(String breakMax) {
		this.breakMax = breakMax;
	}

	public void setSpecialInstruction(String specialInstruction) {
		this.specialInstruction = specialInstruction;
	}

	public String getGradeCode() {
		return gradeCode;
	}

	public Date getRevisionDate() {
		return revisionDate;
	}

	public String getTmNo() {
		return tmNo;
	}

	public String getDescription() {
		return description;
	}

	public String getCustomerGrade() {
		return customerGrade;
	}

	public String getCustomer() {
		return customer;
	}

	public String getNotes() {
		return notes;
	}

	public void setGradeCode(String gradeCode) {
		this.gradeCode = gradeCode;
	}

	public void setRevisionDate(Date revisionDate) {
		this.revisionDate = revisionDate;
	}

	public void setTmNo(String tmNo) {
		this.tmNo = tmNo;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setCustomerGrade(String customerGrade) {
		this.customerGrade = customerGrade;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String getCustomerApproval() {
		return customerApproval;
	}

	public void setCustomerApproval(String customerApproval) {
		this.customerApproval = customerApproval;
	}

	public String getTissueApproval() {
		return tissueApproval;
	}

	public void setTissueApproval(String tissueApproval) {
		this.tissueApproval = tissueApproval;
	}



	public String getTrimMin() {
		return trimMin;
	}



	public void setTrimMin(String trimMin) {
		this.trimMin = trimMin;
	}



	public String getTrimTarget() {
		return trimTarget;
	}



	public void setTrimTarget(String trimTarget) {
		this.trimTarget = trimTarget;
	}



	public String getTrimMax() {
		return trimMax;
	}



	public void setTrimMax(String trimMax) {
		this.trimMax = trimMax;
	}

}

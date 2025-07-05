/**
 *Oct 27, 2015
 *CustomerComplaint.java
 * TODO
 *com.st.customercomplaint.model
 *CustomerComplaint.java
 *Sunil Singh Bora
 */
package com.st.customercomplaint.model;

import java.util.Date;

/**
 * @author roshan
 *
 */
public class CustomerComplaint {

	
	private int id;
	private Date date;
	private String description;
	private String grade;
	private String customer;
	private String type;
	private Date proddate;
	private String remarks;
	private String resp;
	private Date targetdate;
	private String status;
	private String attachment;
	private String kaizen;
	
	private String complaintissue;
	private String correctiveaction;
	
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
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return the grade
	 */
	public String getGrade() {
		return grade;
	}
	/**
	 * @param grade the grade to set
	 */
	public void setGrade(String grade) {
		this.grade = grade;
	}
	/**
	 * @return the customer
	 */
	public String getCustomer() {
		return customer;
	}
	/**
	 * @param customer the customer to set
	 */
	public void setCustomer(String customer) {
		this.customer = customer;
	}
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * @return the proddate
	 */
	public Date getProddate() {
		return proddate;
	}
	/**
	 * @param proddate the proddate to set
	 */
	public void setProddate(Date proddate) {
		this.proddate = proddate;
	}
	/**
	 * @return the remarks
	 */
	public String getRemarks() {
		return remarks;
	}
	/**
	 * @param remarks the remarks to set
	 */
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	/**
	 * @return the resp
	 */
	public String getResp() {
		return resp;
	}
	/**
	 * @param resp the resp to set
	 */
	public void setResp(String resp) {
		this.resp = resp;
	}
	/**
	 * @return the targetdate
	 */
	public Date getTargetdate() {
		return targetdate;
	}
	/**
	 * @param targetdate the targetdate to set
	 */
	public void setTargetdate(Date targetdate) {
		this.targetdate = targetdate;
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
	public String getAttachment() {
		return attachment;
	}
	public void setAttachment(String attachment) {
		this.attachment = attachment;
	}
	public String getKaizen() {
		return kaizen;
	}
	public void setKaizen(String kaizen) {
		this.kaizen = kaizen;
	}
	public String getComplaintissue() {
		return complaintissue;
	}
	public void setComplaintissue(String complaintissue) {
		this.complaintissue = complaintissue;
	}
	public String getCorrectiveaction() {
		return correctiveaction;
	}
	public void setCorrectiveaction(String correctiveaction) {
		this.correctiveaction = correctiveaction;
	}
	
}

/**
 *Nov 12, 2014
 *Customer.java
 * TODO
 *com.st.certificate.model
 *Customer.java
 *Sunil Singh Bora
 */
package com.st.certificate.model;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author sbora
 *
 */
public class Rewdinder {
	
	
	private Date sdate;
	private Date edate;
	private String custCode;
	private String customer;
	private String grade;
	private int reel;
	private Date date;
	private String rollId;
	private int set;
	private String position;
	
	
	public String getRollId() {
		return rollId;
	}

	public void setRollId(String rollId) {
		this.rollId = rollId;
	}

	public int getSet() {
		return set;
	}

	public void setSet(int set) {
		this.set = set;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	private List<Map<String, Object>> customers;
	private List<String> grades;
	

	public List<Map<String, Object>> getCustomers() {
		return customers;
	}

	public void setCustomers(List<Map<String, Object>> customers) {
		this.customers = customers;
	}

	public List<String> getGrades() {
		return grades;
	}

	public void setGrades(List<String> grades) {
		this.grades = grades;
	}

	public Date getSdate() {
		return sdate;
	}

	public void setSdate(Date sdate) {
		this.sdate = sdate;
	}

	public Date getEdate() {
		return edate;
	}

	public void setEdate(Date edate) {
		this.edate = edate;
	}

	public String getCustCode() {
		return custCode;
	}

	public void setCustCode(String custCode) {
		this.custCode = custCode;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public int getReel() {
		return reel;
	}

	public void setReel(int reel) {
		this.reel = reel;
	}

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	
}	

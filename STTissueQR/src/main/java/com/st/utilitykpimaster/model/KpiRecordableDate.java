/**
 * 
 */
package com.st.utilitykpimaster.model;

import java.util.Date;

/**
 * @author sbora
 * 
 */
public class KpiRecordableDate {
	private int id;
	private Date date;
	private String remarks;

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

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
}

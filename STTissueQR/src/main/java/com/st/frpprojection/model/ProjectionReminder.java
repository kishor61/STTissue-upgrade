/**
 * 
 */
package com.st.frpprojection.model;

import java.util.Date;

/**
 * @author sbora
 *
 */
public class ProjectionReminder {
	private int id;
	private int formulaId;
	private Date date;
	
	private String fcode;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getFormulaId() {
		return formulaId;
	}

	public void setFormulaId(int formulaId) {
		this.formulaId = formulaId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getFcode() {
		return fcode;
	}

	public void setFcode(String fcode) {
		this.fcode = fcode;
	}

}

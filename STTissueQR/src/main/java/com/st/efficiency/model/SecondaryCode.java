/**
 * 
 */
package com.st.efficiency.model;

/**
 * @author sbora
 * 
 */
public class SecondaryCode {
	private int id;
	private String code;
	private String note;
	
	private PrimaryCode primaryCode;
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	/**
	 * @return the primaryCode
	 */
	public PrimaryCode getPrimaryCode() {
		return primaryCode;
	}

	/**
	 * @param primaryCode the primaryCode to set
	 */
	public void setPrimaryCode(PrimaryCode primaryCode) {
		this.primaryCode = primaryCode;
	}



}

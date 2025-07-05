/**
 * 
 */
package com.st.efficiencypm5.model;

/**
 * @author sbora
 * 
 */
public class SecondaryCodePM5 {
	private int id;
	private String code;
	private String note;
	
	private PrimaryCodePM5 primaryCode;
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
	public PrimaryCodePM5 getPrimaryCode() {
		return primaryCode;
	}

	/**
	 * @param primaryCode the primaryCode to set
	 */
	public void setPrimaryCode(PrimaryCodePM5 primaryCode) {
		this.primaryCode = primaryCode;
	}



}

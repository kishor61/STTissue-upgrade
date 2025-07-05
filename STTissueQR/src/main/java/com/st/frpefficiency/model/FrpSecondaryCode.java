/**
 * 
 */
package com.st.frpefficiency.model;

/**
 * @author sbora
 * 
 */
public class FrpSecondaryCode {
	private int id;
	private String code;
	private String note;
	
	private FrpPrimaryCode primaryCode;
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
	public FrpPrimaryCode getPrimaryCode() {
		return primaryCode;
	}

	/**
	 * @param primaryCode the primaryCode to set
	 */
	public void setPrimaryCode(FrpPrimaryCode primaryCode) {
		this.primaryCode = primaryCode;
	}



}

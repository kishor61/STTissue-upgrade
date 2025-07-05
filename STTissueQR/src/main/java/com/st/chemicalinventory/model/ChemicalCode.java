/**
 * 
 */
package com.st.chemicalinventory.model;

/**
 * @author sbora
 * 
 */
public class ChemicalCode {
	private int id;
	private String code;
	private double min;
	private double target;
	private double max;
	private boolean deleted;
	private String unit;
	
	
	//Temp Secondary Code
	private String secondaryCode;
	private String primaryCode;
	
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

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	/**
	 * @return the secondaryCode
	 */
	public String getSecondaryCode() {
		return secondaryCode;
	}

	/**
	 * @param secondaryCode the secondaryCode to set
	 */
	public void setSecondaryCode(String secondaryCode) {
		this.secondaryCode = secondaryCode;
	}

	/**
	 * @return the primaryCode
	 */
	public String getPrimaryCode() {
		return primaryCode;
	}

	/**
	 * @param primaryCode the primaryCode to set
	 */
	public void setPrimaryCode(String primaryCode) {
		this.primaryCode = primaryCode;
	}

	public double getMin() {
		return min;
	}

	public void setMin(double min) {
		this.min = min;
	}

	public double getTarget() {
		return target;
	}

	public void setTarget(double target) {
		this.target = target;
	}

	public double getMax() {
		return max;
	}

	public void setMax(double max) {
		this.max = max;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

}

/**
 * 
 */
package com.st.chemicalinventory.model;

/**
 * @author sbora
 * 
 */
public class Chemical {
	private int id;
	private int sid;
	private int cid;
	private boolean deleted;
	
	//Temp
	private String chemicalCode;
	private String primaryName;
	private String secondaryName;
	
	private int chemicalDataId;
	private double consumption;

	
	private double min;
	private double target;
	private double max;
	private String unit;
	
	
	/**
	 * 
	 */
	public Chemical() {}
	
	public Chemical(int id) {this.id=id;}
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}



	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getChemicalCode() {
		return chemicalCode;
	}

	public void setChemicalCode(String chemicalCode) {
		this.chemicalCode = chemicalCode;
	}

	public String getPrimaryName() {
		return primaryName;
	}

	public void setPrimaryName(String primaryName) {
		this.primaryName = primaryName;
	}

	public String getSecondaryName() {
		return secondaryName;
	}

	public void setSecondaryName(String secondaryName) {
		this.secondaryName = secondaryName;
	}

	public int getChemicalDataId() {
		return chemicalDataId;
	}

	public void setChemicalDataId(int chemicalDataId) {
		this.chemicalDataId = chemicalDataId;
	}

	public double getConsumption() {
		return consumption;
	}

	public void setConsumption(double consumption) {
		this.consumption = consumption;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object arg0) {
		Chemical chemical=(Chemical)arg0;
		return chemical.getId()==getId();
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

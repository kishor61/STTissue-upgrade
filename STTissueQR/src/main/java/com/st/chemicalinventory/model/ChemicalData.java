/**
 *Nov 17, 2014
 *ChemicalData.java
 * TODO
 *com.st.chemicalinventory.model
 *ChemicalData.java
 *Sunil Singh Bora
 */
package com.st.chemicalinventory.model;

import java.util.Date;

/**
 * @author sbora
 *
 */
public class ChemicalData {

	
	private int id;
	private int cid;
	private Date date;
	private String entryId;
	private double consumption;

	//Temp
	private String chemicalCode;
	private String primaryName;
	private String secondaryName;
	private int ccid;
	private int pid;
	private int sid;
	
	private double totalConsumption;
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}


	public String getEntryId() {
		return entryId;
	}

	public void setEntryId(String entryId) {
		this.entryId = entryId;
	}

	public double getConsumption() {
		return consumption;
	}

	public void setConsumption(double consumption) {
		this.consumption = consumption;
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

	public int getCcid() {
		return ccid;
	}

	public void setCcid(int ccid) {
		this.ccid = ccid;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public double getTotalConsumption() {
		return totalConsumption;
	}

	public void setTotalConsumption(double totalConsumption) {
		this.totalConsumption = totalConsumption;
	}

}

/**
 *Jan 10, 2015
 *OperatingProcedure.java
 * TODO
 *com.st.operatingprocedure.model
 *OperatingProcedure.java
 *Sunil Singh Bora
 */
package com.st.operatingprocedure.model;

import java.util.Date;

/**
 * @author sbora
 *
 */
public class OperatingProcedure {
	private int id;
	private String type;
	private String name;
	private String file;
	private String subType;
	
	private String maincategoname;
	private String entersubcatname;
	private String area;
	

	private Date entryDate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}

	public Date getEntryDate() {
		return entryDate;
	}

	public void setEntryDate(Date entryDate) {
		this.entryDate = entryDate;
	}

	public String getSubType() {
		return subType;
	}

	public void setSubType(String subType) {
		this.subType = subType;
	}

	public String getMaincategoname() {
		return maincategoname;
	}

	public void setMaincategoname(String maincategoname) {
		this.maincategoname = maincategoname;
	}

	public String getEntersubcatname() {
		return entersubcatname;
	}

	public void setEntersubcatname(String entersubcatname) {
		this.entersubcatname = entersubcatname;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

}

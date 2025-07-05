/**
 * 
 */
package com.st.chemicalinventory.model;

/**
 * @author sbora
 *
 */
public class ChemicalSecondaryCode {
	private int id;
	private String name;
	private int pid;
	private boolean deleted;
	
	
	//Temp
	private String primaryCode;
	private int count;

	
	/**
	 * 
	 */
	public ChemicalSecondaryCode() {}
	public ChemicalSecondaryCode(int id) {this.id=id;}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public boolean isDeleted() {
		return deleted;
	}
	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
	public String getPrimaryCode() {
		return primaryCode;
	}
	public void setPrimaryCode(String primaryCode) {
		this.primaryCode = primaryCode;
	}
	
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	
	@Override
	public boolean equals(Object obj) {
		ChemicalSecondaryCode chemicalSecondaryCode=(ChemicalSecondaryCode)obj;
		return chemicalSecondaryCode.getId()==this.getId();
	}
}

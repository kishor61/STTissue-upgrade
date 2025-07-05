/**
 * 
 */
package com.st.chemicalinventory.model;

/**
 * @author sbora
 *
 */
public class ChemicalPrimaryCode {
	private int id;
	private String name;
	private boolean deleted;
	
	
	//Temp
	private int count;
		
	/**
	 * 
	 */
	public ChemicalPrimaryCode() {}
	public ChemicalPrimaryCode(int id) {this.id=id;}
	
	
	
	
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
	public boolean isDeleted() {
		return deleted;
	}
	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
	
	@Override
	public boolean equals(Object obj) {
		ChemicalPrimaryCode chemicalPrimaryCode=(ChemicalPrimaryCode)obj;
		return chemicalPrimaryCode.getId()==this.getId();
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
}

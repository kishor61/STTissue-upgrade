/**
 *Jan 12, 2015
 *Type.java
 * TODO
 *com.st.operatingprocedure.model
 *Type.java
 *Sunil Singh Bora
 */
package com.st.operatingprocedure.model;

import java.util.Set;
import java.util.TreeSet;

/**
 * @author sbora
 *
 */
public class Type {
	private String name;

	private Set<String> subType=new TreeSet<String>();

	/**
	 * 
	 */
	public Type(String name) {
		this.name=name;
	}


	public Set<String> getSubType() {
		return subType;
	}

	public void setSubType(Set<String> subType) {
		this.subType = subType;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object arg0) {
		if(arg0 instanceof Type){
			Type type=(Type)arg0;
			if(type.getName().equals(this.getName())){
				return true;
			}else{
				return false;
			}
		}
		return false;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}

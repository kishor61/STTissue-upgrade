/**
 * 
 */
package com.st.safetylog.model;

/**
 * @author sbora
 *
 */
public class SafetyHousekeepingStdType {
	private String id;
	private String name;
	private boolean deleted;
	
	
	//Temp
	private double score;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		SafetyHousekeepingStdType housekeepingStdType=(SafetyHousekeepingStdType)obj;
		return housekeepingStdType.getId().equals(getId());
	}
	public boolean isDeleted() {
		return deleted;
	}
	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
}

/**
 *Dec 15, 2015
 *TempReleaseData.java
 * TODO
 *com.st.wastepaper.dao
 *TempReleaseData.java
 *Sunil Singh Bora
 */
package com.st.wastepaper.dao;

/**
 * @author roshan
 *
 */
public class TempReleaseData {
	private int releaseNo;
	private double weight;
	
	
	/**
	 * 
	 */
	public TempReleaseData() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @return the releaseNo
	 */
	public int getReleaseNo() {
		return releaseNo;
	}
	/**
	 * @param releaseNo the releaseNo to set
	 */
	public void setReleaseNo(int releaseNo) {
		this.releaseNo = releaseNo;
	}
	/**
	 * @return the weight
	 */
	public double getWeight() {
		return weight;
	}
	/**
	 * @param weight the weight to set
	 */
	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		TempReleaseData data=(TempReleaseData)obj;
		
		return (data.getReleaseNo() == this.releaseNo && data.getWeight() == this.weight);
	}
}

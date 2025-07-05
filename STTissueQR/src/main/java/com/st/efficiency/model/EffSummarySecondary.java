/**
 * 
 */
package com.st.efficiency.model;


/**
 * @author sbora
 *
 */
public class EffSummarySecondary {
	private String code;
	private int hh;
	private int mm;
	private int totalMin;
	
	private int counter;
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public int getHh() {
		return hh;
	}
	public void setHh(int hh) {
		this.hh = hh;
	}
	public int getMm() {
		return mm;
	}
	public void setMm(int mm) {
		this.mm = mm;
	}
	/**
	 * @return the totalMin
	 */
	public int getTotalMin() {
		return totalMin;
	}
	/**
	 * @param totalMin the totalMin to set
	 */
	public void setTotalMin(int totalMin) {
		this.totalMin = totalMin;
	}
	public int getCounter() {
		return counter;
	}
	public void setCounter(int counter) {
		this.counter = counter;
	}
}

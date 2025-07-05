/**
 * 
 */
package com.st.efficiencypm5.model;

import java.util.ArrayList;
import java.util.List;


/**
 * @author sbora
 *
 */
public class EffSummaryPrimaryPM5 {
	private String code;
	private int hh;
	private int mm;
	private int totalMin;
	
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

	public int getTotalMin() {
		return totalMin;
	}

	public void setTotalMin(int totalMin) {
		this.totalMin = totalMin;
	}

	private List<EffSummarySecondaryPM5> summarySecondaries=new ArrayList<>();

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @return the summarySecondaries
	 */
	public List<EffSummarySecondaryPM5> getSummarySecondaries() {
		return summarySecondaries;
	}

	/**
	 * @param summarySecondaries the summarySecondaries to set
	 */
	public void setSummarySecondaries(List<EffSummarySecondaryPM5> summarySecondaries) {
		this.summarySecondaries = summarySecondaries;
	}
}

/**
 * 
 */
package com.st.frpefficiency.model;

import java.util.ArrayList;
import java.util.List;


/**
 * @author sbora
 *
 */
public class FrpEffSummaryPrimary {
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

	private List<FrpEffSummarySecondary> summarySecondaries=new ArrayList<>();

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
	public List<FrpEffSummarySecondary> getSummarySecondaries() {
		return summarySecondaries;
	}

	/**
	 * @param summarySecondaries the summarySecondaries to set
	 */
	public void setSummarySecondaries(List<FrpEffSummarySecondary> summarySecondaries) {
		this.summarySecondaries = summarySecondaries;
	}
}

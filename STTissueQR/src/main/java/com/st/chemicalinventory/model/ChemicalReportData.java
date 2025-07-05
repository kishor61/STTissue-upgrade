/**
 *Nov 17, 2014
 *ChemicalReportData.java
 * TODO
 *com.st.chemicalinventory.model
 *ChemicalReportData.java
 *Sunil Singh Bora
 */
package com.st.chemicalinventory.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author sbora
 *
 */
public class ChemicalReportData {
	private Date date;
	private String entryId;
	
	private List<ChemicalData> datas=new ArrayList<ChemicalData>();
	private List<ChemicalPrimaryCode> primaryCodes=new ArrayList<ChemicalPrimaryCode>();
	private List<ChemicalSecondaryCode> secondaryCodes=new ArrayList<ChemicalSecondaryCode>();
	private List<ReportData> reportDatas=new ArrayList<ChemicalReportData.ReportData>();
	

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

	public List<ChemicalData> getDatas() {
		return datas;
	}

	public void setDatas(List<ChemicalData> datas) {
		this.datas = datas;
	}

	public List<ChemicalPrimaryCode> getPrimaryCodes() {
		return primaryCodes;
	}

	public void setPrimaryCodes(List<ChemicalPrimaryCode> primaryCodes) {
		this.primaryCodes = primaryCodes;
	}

	public List<ChemicalSecondaryCode> getSecondaryCodes() {
		return secondaryCodes;
	}

	public void setSecondaryCodes(List<ChemicalSecondaryCode> secondaryCodes) {
		this.secondaryCodes = secondaryCodes;
	}
	
	
	public List<ReportData> getReportDatas() {
		return reportDatas;
	}

	public void setReportDatas(List<ReportData> reportDatas) {
		this.reportDatas = reportDatas;
	}

	

	public class ReportData{
		private String date;
		private String entryId;
		private List<Double> values=new ArrayList<Double>();
		
		public String getDate() {
			return date;
		}

		public void setDate(String date) {
			this.date = date;
		}

		public List<Double> getValues() {
			return values;
		}

		public void setValues(List<Double> values) {
			this.values = values;
		}

		public String getEntryId() {
			return entryId;
		}

		public void setEntryId(String entryId) {
			this.entryId = entryId;
		}

	}
}

/**
 * 
 */
package com.st.frpefficiency.model;

import java.sql.Timestamp;
import java.util.Date;

/**
 * @author sbora
 *
 */
public class FrpEfficiency {
	private int id;
	private Date date;
	private String shift;
	private String crew;
	private Timestamp startTime;
	private Timestamp endTime;
	private String batchNo;
	private String grade;
	private String comment;
	
	private FrpSecondaryCode secondaryCode;
	
	
	//Field for form
	private String fdate;
	private String fstartTimeHH;
	private String fstartTimeMM;
	private String fendTimeHH="0";
	private String fendTimeMM="0";
	
	
	
	//Field for Report
	private Date startDate;
	private Date endDate;
	private String pcode;
	private String scode;
	
	//Field for temp update
	private String queryString;
	
	public String getFdate() {
		return fdate;
	}

	public void setFdate(String fdate) {
		this.fdate = fdate;
	}





	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getShift() {
		return shift;
	}

	public void setShift(String shift) {
		this.shift = shift;
	}

	public String getCrew() {
		return crew;
	}

	public void setCrew(String crew) {
		this.crew = crew;
	}

	public Timestamp getStartTime() {
		return startTime;
	}

	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}

	public Timestamp getEndTime() {
		return endTime;
	}

	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}



	public String getBatchNo() {
		return batchNo;
	}

	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}



	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public FrpSecondaryCode getSecondaryCode() {
		return secondaryCode;
	}

	public void setSecondaryCode(FrpSecondaryCode secondaryCode) {
		this.secondaryCode = secondaryCode;
	}

	/**
	 * @return the fendTimeHH
	 */
	public String getFendTimeHH() {
		return fendTimeHH;
	}

	/**
	 * @param fendTimeHH the fendTimeHH to set
	 */
	public void setFendTimeHH(String fendTimeHH) {
		this.fendTimeHH = fendTimeHH;
	}

	/**
	 * @return the fendTimeMM
	 */
	public String getFendTimeMM() {
		return fendTimeMM;
	}

	/**
	 * @param fendTimeMM the fendTimeMM to set
	 */
	public void setFendTimeMM(String fendTimeMM) {
		this.fendTimeMM = fendTimeMM;
	}

	/**
	 * @return the startDate
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/**
	 * @return the endDate
	 */
	public Date getEndDate() {
		return endDate;
	}

	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	/**
	 * @return the fstartTimeHH
	 */
	public String getFstartTimeHH() {
		return fstartTimeHH;
	}

	/**
	 * @param fstartTimeHH the fstartTimeHH to set
	 */
	public void setFstartTimeHH(String fstartTimeHH) {
		this.fstartTimeHH = fstartTimeHH;
	}

	/**
	 * @return the fstartTimeMM
	 */
	public String getFstartTimeMM() {
		return fstartTimeMM;
	}

	/**
	 * @param fstartTimeMM the fstartTimeMM to set
	 */
	public void setFstartTimeMM(String fstartTimeMM) {
		this.fstartTimeMM = fstartTimeMM;
	}

	/**
	 * @return the pcode
	 */
	public String getPcode() {
		return pcode;
	}

	/**
	 * @param pcode the pcode to set
	 */
	public void setPcode(String pcode) {
		this.pcode = pcode;
	}

	/**
	 * @return the scode
	 */
	public String getScode() {
		return scode;
	}

	/**
	 * @param scode the scode to set
	 */
	public void setScode(String scode) {
		this.scode = scode;
	}

	/**
	 * @return the queryString
	 */
	public String getQueryString() {
		return queryString;
	}

	/**
	 * @param queryString the queryString to set
	 */
	public void setQueryString(String queryString) {
		this.queryString = queryString;
	}
	
}

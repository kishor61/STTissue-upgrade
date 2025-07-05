/**
 *Dec 15, 2015
 *FrpGoals.java
 * TODO
 *com.st.frpgoals.model
 *FrpGoals.java
 *Sunil Singh Bora
 */
package com.st.frpgoals.model;

import java.util.Date;

/**
 * @author sbora
 *
 */
public class FrpGoals {
	private int id;
	private int month;
	private int year;
	private Date sdate;
	private Date edate;
	private double sowAndCbsF;
	private double newsBankF;
	private double occF;
	private double dlkF;
	private double mailF;
	private double mixedOtherF;
	private double cutbookF;
	private double sowAndCbsW;
	private double newsBankW;
	private double occW;
	private double dlkW;
	private double mailW;
	private double mixedOtherW;
	private double cutbookW;
	
	//Temp date files
	private String sdateTmp;
	private String edateTmp;
	
	//Setter Getter For Waste paper Weight Starts From Here
	private double sowandcbsweight;
	private double newsblankweight;
	private double occweight;
	private double dlkweight;
	private double mailweight;
	private double mixedcraftweight;
	private double cutorhoggedBookweight;
	//Setter Getter For Waste Paper Weight Ends At Here 
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the month
	 */
	public int getMonth() {
		return month;
	}
	/**
	 * @param month the month to set
	 */
	public void setMonth(int month) {
		this.month = month;
	}
	/**
	 * @return the year
	 */
	public int getYear() {
		return year;
	}
	/**
	 * @param year the year to set
	 */
	public void setYear(int year) {
		this.year = year;
	}
	public Date getSdate() {
		return sdate;
	}
	public void setSdate(Date sdate) {
		this.sdate = sdate;
	}
	public Date getEdate() {
		return edate;
	}
	public void setEdate(Date edate) {
		this.edate = edate;
	}
	public double getSowAndCbsF() {
		return sowAndCbsF;
	}
	public void setSowAndCbsF(double sowAndCbsF) {
		this.sowAndCbsF = sowAndCbsF;
	}
	public double getNewsBankF() {
		return newsBankF;
	}
	public void setNewsBankF(double newsBankF) {
		this.newsBankF = newsBankF;
	}
	public double getOccF() {
		return occF;
	}
	public void setOccF(double occF) {
		this.occF = occF;
	}
	public double getDlkF() {
		return dlkF;
	}
	public void setDlkF(double dlkF) {
		this.dlkF = dlkF;
	}
	public double getMailF() {
		return mailF;
	}
	public void setMailF(double mailF) {
		this.mailF = mailF;
	}
	public double getMixedOtherF() {
		return mixedOtherF;
	}
	public void setMixedOtherF(double mixedOtherF) {
		this.mixedOtherF = mixedOtherF;
	}
	public double getCutbookF() {
		return cutbookF;
	}
	public void setCutbookF(double cutbookF) {
		this.cutbookF = cutbookF;
	}
	public double getSowAndCbsW() {
		return sowAndCbsW;
	}
	public void setSowAndCbsW(double sowAndCbsW) {
		this.sowAndCbsW = sowAndCbsW;
	}
	public double getNewsBankW() {
		return newsBankW;
	}
	public void setNewsBankW(double newsBankW) {
		this.newsBankW = newsBankW;
	}
	public double getOccW() {
		return occW;
	}
	public void setOccW(double occW) {
		this.occW = occW;
	}
	public double getDlkW() {
		return dlkW;
	}
	public void setDlkW(double dlkW) {
		this.dlkW = dlkW;
	}
	public double getMailW() {
		return mailW;
	}
	public void setMailW(double mailW) {
		this.mailW = mailW;
	}
	public double getMixedOtherW() {
		return mixedOtherW;
	}
	public void setMixedOtherW(double mixedOtherW) {
		this.mixedOtherW = mixedOtherW;
	}
	public double getCutbookW() {
		return cutbookW;
	}
	public void setCutbookW(double cutbookW) {
		this.cutbookW = cutbookW;
	}
	public String getSdateTmp() {
		return sdateTmp;
	}
	public void setSdateTmp(String sdateTmp) {
		this.sdateTmp = sdateTmp;
	}
	public String getEdateTmp() {
		return edateTmp;
	}
	public void setEdateTmp(String edateTmp) {
		this.edateTmp = edateTmp;
	}
	/**
	 * @return the sowandcbsweight
	 */
	public double getSowandcbsweight() {
		return sowandcbsweight;
	}
	/**
	 * @param sowandcbsweight the sowandcbsweight to set
	 */
	public void setSowandcbsweight(double sowandcbsweight) {
		this.sowandcbsweight = sowandcbsweight;
	}
	/**
	 * @return the newsblankweight
	 */
	public double getNewsblankweight() {
		return newsblankweight;
	}
	/**
	 * @param newsblankweight the newsblankweight to set
	 */
	public void setNewsblankweight(double newsblankweight) {
		this.newsblankweight = newsblankweight;
	}
	/**
	 * @return the occweigh
	 */
	public double getOccweight() {
		return occweight;
	}
	/**
	 * @param occweigh the occweigh to set
	 */
	public void setOccweight(double occweight) {
		this.occweight = occweight;
	}
	/**
	 * @return the dlkweight
	 */
	public double getDlkweight() {
		return dlkweight;
	}
	/**
	 * @param dlkweight the dlkweight to set
	 */
	public void setDlkweight(double dlkweight) {
		this.dlkweight = dlkweight;
	}
	/**
	 * @return the mailweight
	 */
	public double getMailweight() {
		return mailweight;
	}
	/**
	 * @param mailweight the mailweight to set
	 */
	public void setMailweight(double mailweight) {
		this.mailweight = mailweight;
	}
	/**
	 * @return the mixedcraftweight
	 */
	public double getMixedcraftweight() {
		return mixedcraftweight;
	}
	/**
	 * @param mixedcraftweight the mixedcraftweight to set
	 */
	public void setMixedcraftweight(double mixedcraftweight) {
		this.mixedcraftweight = mixedcraftweight;
	}
	/**
	 * @return the cutorhoggedBookweight
	 */
	public double getCutorhoggedBookweight() {
		return cutorhoggedBookweight;
	}
	/**
	 * @param cutorhoggedBookweight the cutorhoggedBookweight to set
	 */
	public void setCutorhoggedBookweight(double cutorhoggedBookweight) {
		this.cutorhoggedBookweight = cutorhoggedBookweight;
	}
	

}

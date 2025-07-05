/**
 *Feb 17, 2015
 *WastepaperDetail.java
 * TODO
 *com.st.wastepaper.model
 *WastepaperDetail.java
 *Sunil Singh Bora
 */
package com.st.wastepaper.model;

import java.util.Date;

import com.st.common.CommonUtil;

/**
 * @author sbora
 *
 */
public class WastepaperDetail {
	//Code Added By Roshan Tailor
	private int id;
	//Added Code By Roshan Tailor Ends Here
	private int receiptNo;
	private String masterPO;
	private int releaseNo;
	private int scaReleaseNo;
	private String vandorName;
	private Date droppedDate;
	private Date unloadedDate;
	private String itemDescription;
	private int bales;
	private double netTons;
	private double minOftheTons;
	private double pricePerTon;
	private double extention;
	private String carrier;
	private String trailerNo;
	private String shippingCity;
	private String shippingState;
	private double estimatedFreight;
	private String freightInvoiceNo;
	private double freightInvoiced;
	private double freightCHBK;
	private String freightCHBKPending;
	private double grandTotal;
	private String destination;
	private String comment;
	private double DetentionCharges;
	private double deduction;//This is added by Roshan Tailor, Accordingly Requirement Of Dinesh Sir/Accounts  
	private int totalbales;
	private double extentiontotal;
	
	private int balesondate;
	private int balesondaterejected;
	private int balesondatedeleted;
	private int enroute;
	private Date rejectdate;
	private int gradeid;
	
	private int loopcount;
	
	//Code For Rejected Bales
		private double rejectbolweight;
		private int rejectbalecount;
	//
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public int getReceiptNo() {
		return receiptNo;
	}

	public void setReceiptNo(int receiptNo) {
		this.receiptNo = receiptNo;
	}

	public String getMasterPO() {
		return masterPO;
	}

	public void setMasterPO(String masterPO) {
		this.masterPO = masterPO;
	}

	public int getReleaseNo() {
		return releaseNo;
	}

	public void setReleaseNo(int releaseNo) {
		this.releaseNo = releaseNo;
	}

	public int getScaReleaseNo() {
		return scaReleaseNo;
	}

	public void setScaReleaseNo(int scaReleaseNo) {
		this.scaReleaseNo = scaReleaseNo;
	}

	public String getVandorName() {
		return vandorName;
	}

	public void setVandorName(String vandorName) {
		this.vandorName = vandorName;
	}

	public Date getDroppedDate() {
		return droppedDate;
	}

	public void setDroppedDate(Date droppedDate) {
		this.droppedDate = droppedDate;
	}

	public Date getUnloadedDate() {
		return unloadedDate;
	}

	public void setUnloadedDate(Date unloadedDate) {
		this.unloadedDate = unloadedDate;
	}


	public String getItemDescription() {
		return itemDescription;
	}

	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}

	public int getBales() {
		return bales;
	}

	public void setBales(int bales) {
		this.bales = bales;
	}



	public double getNetTons() {
		return netTons;
	}

	public void setNetTons(double netTons) {
		this.netTons = netTons;
	}

	public double getMinOftheTons() {
		return minOftheTons;
	}

	public void setMinOftheTons(double minOftheTons) {
		this.minOftheTons = minOftheTons;
	}

	public double getPricePerTon() {
		return pricePerTon;
	}

	public void setPricePerTon(double pricePerTon) {
		this.pricePerTon = pricePerTon;
	}
//Code Modified By Roshan Tailor Date:- 04/06/2015
	public double getExtention(){
		return((this.netTons)*(this.pricePerTon));
		//return extention;
		//To get the $ Extension by multiplying the netTon and priceperTon
	}
//Modified Code Ends Here Done By Roshan Tailor Date:-04/06/2015
	public void setExtention(double extention) {
		this.extention = extention;
	
	}

	public String getCarrier() {
		return carrier;
	}

	public void setCarrier(String carrier) {
		this.carrier = carrier;
	}

	public String getTrailerNo() {
		return trailerNo;
	}

	public void setTrailerNo(String trailerNo) {
		this.trailerNo = trailerNo;
	}

	public String getShippingCity() {
		return shippingCity;
	}

	public void setShippingCity(String shippingCity) {
		this.shippingCity = shippingCity;
	}

	public String getShippingState() {
		return shippingState;
	}

	public void setShippingState(String shippingState) {
		this.shippingState = shippingState;
	}

	public double getEstimatedFreight() {
		return estimatedFreight;
	}

	public void setEstimatedFreight(double estimatedFreight) {
		this.estimatedFreight = estimatedFreight;
	}

	public String getFreightInvoiceNo() {
		return freightInvoiceNo;
	}

	public void setFreightInvoiceNo(String freightInvoiceNo) {
		this.freightInvoiceNo = freightInvoiceNo;
	}

	public double getFreightInvoiced() {
		return freightInvoiced;
	}

	public void setFreightInvoiced(double freightInvoiced) {
		this.freightInvoiced = freightInvoiced;
	}

	public double getFreightCHBK() {
		return freightCHBK;
	}

	public void setFreightCHBK(double freightCHBK) {
		this.freightCHBK = freightCHBK;
	}

	public double getGrandTotal() {
		return grandTotal;
	}

	public void setGrandTotal(double grandTotal) {
		this.grandTotal = CommonUtil.round(grandTotal, 2);
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public double getDetentionCharges() {
		return DetentionCharges;
	}

	public void setDetentionCharges(double detentionCharges) {
		DetentionCharges = detentionCharges;
	}

	/**
	 * @param wastepaperDetail
	 */
	public void addtomasterUpdate(WastepaperDetail wastepaperDetail) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @return the freightCHBKPending
	 */
	public String getFreightCHBKPending() {
		return freightCHBKPending;
	}

	/**
	 * @param freightCHBKPending the freightCHBKPending to set
	 */
	public void setFreightCHBKPending(String freightCHBKPending) {
		this.freightCHBKPending = freightCHBKPending;
	}

	/**
	 * @return the deduction
	 */
	public double getDeduction() {
		return deduction;
	}

	/**
	 * @param deduction the deduction to set
	 */
	public void setDeduction(double deduction) {
		this.deduction = deduction;
	}

	/**
	 * @return the totalbales
	 */
	public int getTotalbales() {
		return totalbales;
	}

	/**
	 * @param totalbales the totalbales to set
	 */
	public void setTotalbales(int totalbales) {
		this.totalbales = totalbales;
	}

	/**
	 * @return the extentiontotal
	 */
	public double getExtentiontotal() {
		return extentiontotal;
	}

	/**
	 * @param extentiontotal the extentiontotal to set
	 */
	public void setExtentiontotal(double extentiontotal) {
		this.extentiontotal = extentiontotal;
	}

	/**
	 * @return the balesondate
	 */
	public int getBalesondate() {
		return balesondate;
	}

	/**
	 * @param balesondate the balesondate to set
	 */
	public void setBalesondate(int balesondate) {
		this.balesondate = balesondate;
	}

	/**
	 * @return the rejectdate
	 */
	public Date getRejectdate() {
		return rejectdate;
	}

	/**
	 * @param rejectdate the rejectdate to set
	 */
	public void setRejectdate(Date rejectdate) {
		this.rejectdate = rejectdate;
	}

	/**
	 * @return the balesondaterejected
	 */
	public int getBalesondaterejected() {
		return balesondaterejected;
	}

	/**
	 * @param balesondaterejected the balesondaterejected to set
	 */
	public void setBalesondaterejected(int balesondaterejected) {
		this.balesondaterejected = balesondaterejected;
	}

	public int getBalesondatedeleted() {
		return balesondatedeleted;
	}

	public void setBalesondatedeleted(int balesondatedeleted) {
		this.balesondatedeleted = balesondatedeleted;
	}

	public int getEnroute() {
		return enroute;
	}

	public void setEnroute(int enroute) {
		this.enroute = enroute;
	}

	public int getGradeid() {
		return gradeid;
	}

	public void setGradeid(int gradeid) {
		this.gradeid = gradeid;
	}

	public int getLoopcount() {
		return loopcount;
	}

	public void setLoopcount(int loopcount) {
		this.loopcount = loopcount;
	}

	public double getRejectbolweight() {
		return rejectbolweight;
	}

	public void setRejectbolweight(double rejectbolweight) {
		this.rejectbolweight = rejectbolweight;
	}

	public int getRejectbalecount() {
		return rejectbalecount;
	}

	public void setRejectbalecount(int rejectbalecount) {
		this.rejectbalecount = rejectbalecount;
	}	
}

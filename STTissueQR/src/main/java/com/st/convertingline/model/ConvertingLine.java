/**
 *Mar 25, 2017
 *ConvertingLine.java
 * TODO
 *com.st.convertingline.model
 *ConvertingLine.java
 *Roshan Lal Tailor
 */
package com.st.convertingline.model;

import java.util.Date;

/**
 * @author roshan
 *
 */
public class ConvertingLine {

	private int id;
	private Date date;
	private String customer;
	private String skucode; 
	
	private Double january;
	private Double february;
	private Double march;
	private Double april;
	private Double may;
	private Double june;
	private Double july;
	private Double august;
	private Double september;
	private Double october;
	private Double november;
	private Double december;
	private String month;
	
	
	//
	private Double januaryqty;
	private Double februaryqty;
	private Double marchqty;
	private Double aprilqty;
	private Double mayqty;
	private Double juneqty;
	private Double julyqty;
	private Double augustqty;
	private Double septemberqty;
	private Double octoberqty;
	private Double novemberqty;
	private Double decemberqty;
	//Total OrderedPO
	
	private Double januaryorderedpo;
	private Double februaryorderedpo;
	private Double marchorderedpo;
	private Double aprilorderedpo;
	private Double mayorderedpo;
	private Double juneorderedpo;
	private Double julyorderedpo;
	private Double augustorderedpo;
	private Double septemberorderedpo;
	private Double octoberorderedpo;
	private Double novemberorderedpo;
	private Double decemberorderedpo;
	
	private String productcode;

	
	//
	private double shipQty;
	private double orderQty;
	
	private double totalshipqty;
	private double totalorderqty;
	private int totalshiped;
	
	private String status;
	
	private String mapsize;
	private String rowview;
	
	private double priceperunit;
	
	private String ackpocreation;
	
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

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public String getSkucode() {
		return skucode;
	}

	public void setSkucode(String skucode) {
		this.skucode = skucode;
	}

	public Double getJanuary() {
		return january;
	}

	public void setJanuary(Double january) {
		this.january = january;
	}

	public Double getFebruary() {
		return february;
	}

	public void setFebruary(Double february) {
		this.february = february;
	}

	public Double getMarch() {
		return march;
	}

	public void setMarch(Double march) {
		this.march = march;
	}

	public Double getApril() {
		return april;
	}

	public void setApril(Double april) {
		this.april = april;
	}

	public Double getMay() {
		return may;
	}

	public void setMay(Double may) {
		this.may = may;
	}

	public Double getJune() {
		return june;
	}

	public void setJune(Double june) {
		this.june = june;
	}

	public Double getJuly() {
		return july;
	}

	public void setJuly(Double july) {
		this.july = july;
	}

	public Double getAugust() {
		return august;
	}

	public void setAugust(Double august) {
		this.august = august;
	}

	public Double getSeptember() {
		return september;
	}

	public void setSeptember(Double september) {
		this.september = september;
	}

	public Double getOctober() {
		return october;
	}

	public void setOctober(Double october) {
		this.october = october;
	}

	public Double getNovember() {
		return november;
	}

	public void setNovember(Double november) {
		this.november = november;
	}

	public Double getDecember() {
		return december;
	}

	public void setDecember(Double december) {
		this.december = december;
	}

	public String getProductcode() {
		return productcode;
	}

	public void setProductcode(String productcode) {
		this.productcode = productcode;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public Double getJanuaryqty() {
		return januaryqty;
	}

	public void setJanuaryqty(Double januaryqty) {
		this.januaryqty = januaryqty;
	}

	public Double getFebruaryqty() {
		return februaryqty;
	}

	public void setFebruaryqty(Double februaryqty) {
		this.februaryqty = februaryqty;
	}

	public Double getMarchqty() {
		return marchqty;
	}

	public void setMarchqty(Double marchqty) {
		this.marchqty = marchqty;
	}

	public Double getAprilqty() {
		return aprilqty;
	}

	public void setAprilqty(Double aprilqty) {
		this.aprilqty = aprilqty;
	}

	public Double getMayqty() {
		return mayqty;
	}

	public void setMayqty(Double mayqty) {
		this.mayqty = mayqty;
	}

	public Double getJuneqty() {
		return juneqty;
	}

	public void setJuneqty(Double juneqty) {
		this.juneqty = juneqty;
	}

	public Double getJulyqty() {
		return julyqty;
	}

	public void setJulyqty(Double julyqty) {
		this.julyqty = julyqty;
	}

	public Double getAugustqty() {
		return augustqty;
	}

	public void setAugustqty(Double augustqty) {
		this.augustqty = augustqty;
	}

	public Double getSeptemberqty() {
		return septemberqty;
	}

	public void setSeptemberqty(Double septemberqty) {
		this.septemberqty = septemberqty;
	}

	public Double getOctoberqty() {
		return octoberqty;
	}

	public void setOctoberqty(Double octoberqty) {
		this.octoberqty = octoberqty;
	}

	public Double getNovemberqty() {
		return novemberqty;
	}

	public void setNovemberqty(Double novemberqty) {
		this.novemberqty = novemberqty;
	}

	public Double getDecemberqty() {
		return decemberqty;
	}

	public void setDecemberqty(Double decemberqty) {
		this.decemberqty = decemberqty;
	}

	public Double getJanuaryorderedpo() {
		return januaryorderedpo;
	}

	public void setJanuaryorderedpo(Double januaryorderedpo) {
		this.januaryorderedpo = januaryorderedpo;
	}

	public Double getFebruaryorderedpo() {
		return februaryorderedpo;
	}

	public void setFebruaryorderedpo(Double februaryorderedpo) {
		this.februaryorderedpo = februaryorderedpo;
	}

	public Double getMarchorderedpo() {
		return marchorderedpo;
	}

	public void setMarchorderedpo(Double marchorderedpo) {
		this.marchorderedpo = marchorderedpo;
	}

	public Double getAprilorderedpo() {
		return aprilorderedpo;
	}

	public void setAprilorderedpo(Double aprilorderedpo) {
		this.aprilorderedpo = aprilorderedpo;
	}

	public Double getMayorderedpo() {
		return mayorderedpo;
	}

	public void setMayorderedpo(Double mayorderedpo) {
		this.mayorderedpo = mayorderedpo;
	}

	public Double getJuneorderedpo() {
		return juneorderedpo;
	}

	public void setJuneorderedpo(Double juneorderedpo) {
		this.juneorderedpo = juneorderedpo;
	}

	public Double getJulyorderedpo() {
		return julyorderedpo;
	}

	public void setJulyorderedpo(Double julyorderedpo) {
		this.julyorderedpo = julyorderedpo;
	}

	public Double getAugustorderedpo() {
		return augustorderedpo;
	}

	public void setAugustorderedpo(Double augustorderedpo) {
		this.augustorderedpo = augustorderedpo;
	}

	public Double getSeptemberorderedpo() {
		return septemberorderedpo;
	}

	public void setSeptemberorderedpo(Double septemberorderedpo) {
		this.septemberorderedpo = septemberorderedpo;
	}

	public Double getOctoberorderedpo() {
		return octoberorderedpo;
	}

	public void setOctoberorderedpo(Double octoberorderedpo) {
		this.octoberorderedpo = octoberorderedpo;
	}

	public Double getNovemberorderedpo() {
		return novemberorderedpo;
	}

	public void setNovemberorderedpo(Double novemberorderedpo) {
		this.novemberorderedpo = novemberorderedpo;
	}

	public Double getDecemberorderedpo() {
		return decemberorderedpo;
	}

	public void setDecemberorderedpo(Double decemberorderedpo) {
		this.decemberorderedpo = decemberorderedpo;
	}

	public double getShipQty() {
		return shipQty;
	}

	public void setShipQty(double shipQty) {
		this.shipQty = shipQty;
	}

	public double getOrderQty() {
		return orderQty;
	}

	public void setOrderQty(double orderQty) {
		this.orderQty = orderQty;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMapsize() {
		return mapsize;
	}

	public void setMapsize(String mapsize) {
		this.mapsize = mapsize;
	}

	public String getRowview() {
		return rowview;
	}

	public void setRowview(String rowview) {
		this.rowview = rowview;
	}

	public double getTotalshipqty() {
		return totalshipqty;
	}

	public void setTotalshipqty(double totalshipqty) {
		this.totalshipqty = totalshipqty;
	}

	public double getTotalorderqty() {
		return totalorderqty;
	}

	public void setTotalorderqty(double totalorderqty) {
		this.totalorderqty = totalorderqty;
	}

	public int getTotalshiped() {
		return totalshiped;
	}

	public void setTotalshiped(int totalshiped) {
		this.totalshiped = totalshiped;
	}

	public double getPriceperunit() {
		return priceperunit;
	}

	public void setPriceperunit(double priceperunit) {
		this.priceperunit = priceperunit;
	}

	public String getAckpocreation() {
		return ackpocreation;
	}

	public void setAckpocreation(String ackpocreation) {
		this.ackpocreation = ackpocreation;
	}
	
	
	
}

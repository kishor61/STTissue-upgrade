/**
 *Dec 1, 2014
 *SummaryData.java
 * TODO
 *com.st.pmothers.model
 *SummaryData.java
 *Sunil Singh Bora
 */
package com.st.pmothers.model;

import java.util.Date;

/**
 * @author sbora
 *
 */
public class SummaryData {
	private int id;
	private Date date;
	private Date productionDate;
	private double safety_Y01;
	private double safety_Y02;
	private double safety_Y03;
	private double safety_Y04;
//	private double safety_Y05;
//	private double safety_MTD01;
//	private double safety_MTD02;
	private double safety_MTD03;
	private double safety_MTD04;
//	private double safety_MTD05;
	private double safety_G01;
	private double safety_G02;
//	private double safety_G03;
//	private double safety_G04;
//	private double safety_G05;
	private String safetyComment;
	private double housekeeping_Y01;
	private double housekeeping_MTD01;
	private double housekeeping_G01;
	private String housekeepingCommnet;
	private double quality_Y01;
	private double quality_Y02;
	private double quality_Y03;
	private double quality_Y04;
	private double quality_MTD01;
	private double quality_MTD02;
	private double quality_MTD03;
	private double quality_MTD04;
	private double quality_G01;
	//private double quality_G02;
	// private double quality_G03;
	// private double quality_G04;
	private String qualityComment;
	private double fiberProd_Y01;
	private double fiberProd_Y02;
	private double fiberProd_Y03;
	private double fiberProd_Y04;
	private double fiberProd_Y05;
	private double fiberProd_Y06;
	private double fiberProd_Y07;
	private double fiberProd_Y08;
	private double fiberProd_Y09;
	private double fiberProd_MTD01;
	private double fiberProd_MTD02;
	private double fiberProd_MTD03;
	private double fiberProd_MTD04;
	private double fiberProd_MTD05;
	private double fiberProd_MTD06;
	private double fiberProd_MTD07;
	private double fiberProd_MTD08;
	private double fiberProd_MTD09;
	// private double fiberProd_G01;
	// private double fiberProd_G02;
	private double fiberProd_G03;
	private double fiberProd_G04;
	private double fiberProd_G05;
	private double fiberProd_G06;
	private double fiberProd_G07;
	private double fiberProd_G08;
	private double fiberProd_G09;
	private String fiberProdComment;
	private double paperProd_Y01;
	private double paperProd_Y02;
	private double paperProd_Y03;
	private String paperProd_Y04;
	private double paperProd_Y05;
	private double paperProd_Y06;
	private double paperProd_Y07;
	private double paperProd_MTD01;
	private double paperProd_MTD02;
	private double paperProd_MTD03;
	// private double paperProd_MTD04;
	// private double paperProd_MTD05;
	private double paperProd_MTD06;
	private double paperProd_MTD07;
	// private double paperProd_G01;
	// private double paperProd_G02;
	private double paperProd_G03;
	// private double paperProd_G04;
	// private double paperProd_G05;
	private double paperProd_G06;
	private double paperProd_G07;
	private String paperProdComment;
	private double shipping_Y01;
	private double shipping_Y02;
	private double shipping_Y03;
	private double shipping_Y04;
	// private double shipping_MTD01;
	// private double shipping_MTD02;
	// private double shipping_MTD03;
	// private double shipping_MTD04;
	// private double shipping_G01;
	// private double shipping_G02;
	// private double shipping_G03;
	// private double shipping_G04;
	private String shippingComment;
	private double costs_Y01;
	private double costs_Y02;
	private double costs_MTD01;
	private double costs_MTD02;
	private double costs_G01;
	private double costs_G02;
	private String costsComment;

	
	private String safetyMeetingTopic;

	private String notes;
	
	//New Field
	private String meetingToday;
	private String attendee;
	private String visitor;
	
	
	public double getFiberProd_Y01() {
		return fiberProd_Y01;
	}

	public void setFiberProd_Y01(double fiberProd_Y01) {
		this.fiberProd_Y01 = fiberProd_Y01;
	}

	public double getFiberProd_Y02() {
		return fiberProd_Y02;
	}

	public void setFiberProd_Y02(double fiberProd_Y02) {
		this.fiberProd_Y02 = fiberProd_Y02;
	}

	public double getFiberProd_Y03() {
		return fiberProd_Y03;
	}

	public void setFiberProd_Y03(double fiberProd_Y03) {
		this.fiberProd_Y03 = fiberProd_Y03;
	}

	public double getFiberProd_Y04() {
		return fiberProd_Y04;
	}

	public void setFiberProd_Y04(double fiberProd_Y04) {
		this.fiberProd_Y04 = fiberProd_Y04;
	}

	public double getFiberProd_Y05() {
		return fiberProd_Y05;
	}

	public void setFiberProd_Y05(double fiberProd_Y05) {
		this.fiberProd_Y05 = fiberProd_Y05;
	}

	public double getFiberProd_Y06() {
		return fiberProd_Y06;
	}

	public void setFiberProd_Y06(double fiberProd_Y06) {
		this.fiberProd_Y06 = fiberProd_Y06;
	}

	public double getFiberProd_Y07() {
		return fiberProd_Y07;
	}

	public void setFiberProd_Y07(double fiberProd_Y07) {
		this.fiberProd_Y07 = fiberProd_Y07;
	}

	public double getFiberProd_Y08() {
		return fiberProd_Y08;
	}

	public void setFiberProd_Y08(double fiberProd_Y08) {
		this.fiberProd_Y08 = fiberProd_Y08;
	}

	public double getFiberProd_Y09() {
		return fiberProd_Y09;
	}

	public void setFiberProd_Y09(double fiberProd_Y09) {
		this.fiberProd_Y09 = fiberProd_Y09;
	}

	public double getFiberProd_MTD01() {
		return fiberProd_MTD01;
	}

	public void setFiberProd_MTD01(double fiberProd_MTD01) {
		this.fiberProd_MTD01 = fiberProd_MTD01;
	}

	public double getFiberProd_MTD02() {
		return fiberProd_MTD02;
	}

	public void setFiberProd_MTD02(double fiberProd_MTD02) {
		this.fiberProd_MTD02 = fiberProd_MTD02;
	}

	public double getFiberProd_MTD03() {
		return fiberProd_MTD03;
	}

	public void setFiberProd_MTD03(double fiberProd_MTD03) {
		this.fiberProd_MTD03 = fiberProd_MTD03;
	}

	public double getFiberProd_MTD04() {
		return fiberProd_MTD04;
	}

	public void setFiberProd_MTD04(double fiberProd_MTD04) {
		this.fiberProd_MTD04 = fiberProd_MTD04;
	}

	public double getFiberProd_MTD05() {
		return fiberProd_MTD05;
	}

	public void setFiberProd_MTD05(double fiberProd_MTD05) {
		this.fiberProd_MTD05 = fiberProd_MTD05;
	}

	public double getFiberProd_MTD06() {
		return fiberProd_MTD06;
	}

	public void setFiberProd_MTD06(double fiberProd_MTD06) {
		this.fiberProd_MTD06 = fiberProd_MTD06;
	}

	public double getFiberProd_MTD07() {
		return fiberProd_MTD07;
	}

	public void setFiberProd_MTD07(double fiberProd_MTD07) {
		this.fiberProd_MTD07 = fiberProd_MTD07;
	}

	public double getFiberProd_MTD08() {
		return fiberProd_MTD08;
	}

	public void setFiberProd_MTD08(double fiberProd_MTD08) {
		this.fiberProd_MTD08 = fiberProd_MTD08;
	}

	public double getFiberProd_MTD09() {
		return fiberProd_MTD09;
	}

	public void setFiberProd_MTD09(double fiberProd_MTD09) {
		this.fiberProd_MTD09 = fiberProd_MTD09;
	}

	public double getFiberProd_G03() {
		return fiberProd_G03;
	}

	public void setFiberProd_G03(double fiberProd_G03) {
		this.fiberProd_G03 = fiberProd_G03;
	}

	public double getFiberProd_G04() {
		return fiberProd_G04;
	}

	public void setFiberProd_G04(double fiberProd_G04) {
		this.fiberProd_G04 = fiberProd_G04;
	}

	public double getFiberProd_G05() {
		return fiberProd_G05;
	}

	public void setFiberProd_G05(double fiberProd_G05) {
		this.fiberProd_G05 = fiberProd_G05;
	}

	public double getFiberProd_G06() {
		return fiberProd_G06;
	}

	public void setFiberProd_G06(double fiberProd_G06) {
		this.fiberProd_G06 = fiberProd_G06;
	}

	public double getFiberProd_G07() {
		return fiberProd_G07;
	}

	public void setFiberProd_G07(double fiberProd_G07) {
		this.fiberProd_G07 = fiberProd_G07;
	}

	public double getFiberProd_G08() {
		return fiberProd_G08;
	}

	public void setFiberProd_G08(double fiberProd_G08) {
		this.fiberProd_G08 = fiberProd_G08;
	}

	public double getFiberProd_G09() {
		return fiberProd_G09;
	}

	public void setFiberProd_G09(double fiberProd_G09) {
		this.fiberProd_G09 = fiberProd_G09;
	}

	public String getFiberProdComment() {
		return fiberProdComment;
	}

	public void setFiberProdComment(String fiberProdComment) {
		this.fiberProdComment = fiberProdComment;
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

	public Date getProductionDate() {
		return productionDate;
	}

	public void setProductionDate(Date productionDate) {
		this.productionDate = productionDate;
	}

	public double getSafety_Y01() {
		return safety_Y01;
	}

	public void setSafety_Y01(double safety_Y01) {
		this.safety_Y01 = safety_Y01;
	}

	public double getSafety_Y02() {
		return safety_Y02;
	}

	public void setSafety_Y02(double safety_Y02) {
		this.safety_Y02 = safety_Y02;
	}

	public double getSafety_Y03() {
		return safety_Y03;
	}

	public void setSafety_Y03(double safety_Y03) {
		this.safety_Y03 = safety_Y03;
	}

	public double getSafety_Y04() {
		return safety_Y04;
	}

	public void setSafety_Y04(double safety_Y04) {
		this.safety_Y04 = safety_Y04;
	}

	public double getSafety_MTD03() {
		return safety_MTD03;
	}

	public void setSafety_MTD03(double safety_MTD03) {
		this.safety_MTD03 = safety_MTD03;
	}

	public double getSafety_MTD04() {
		return safety_MTD04;
	}

	public void setSafety_MTD04(double safety_MTD04) {
		this.safety_MTD04 = safety_MTD04;
	}

	public double getSafety_G01() {
		return safety_G01;
	}

	public void setSafety_G01(double safety_G01) {
		this.safety_G01 = safety_G01;
	}

	public double getSafety_G02() {
		return safety_G02;
	}

	public void setSafety_G02(double safety_G02) {
		this.safety_G02 = safety_G02;
	}

	public String getSafetyComment() {
		return safetyComment;
	}

	public void setSafetyComment(String safetyComment) {
		this.safetyComment = safetyComment;
	}

	public double getHousekeeping_Y01() {
		return housekeeping_Y01;
	}

	public void setHousekeeping_Y01(double housekeeping_Y01) {
		this.housekeeping_Y01 = housekeeping_Y01;
	}

	public double getHousekeeping_MTD01() {
		return housekeeping_MTD01;
	}

	public void setHousekeeping_MTD01(double housekeeping_MTD01) {
		this.housekeeping_MTD01 = housekeeping_MTD01;
	}

	public double getHousekeeping_G01() {
		return housekeeping_G01;
	}

	public void setHousekeeping_G01(double housekeeping_G01) {
		this.housekeeping_G01 = housekeeping_G01;
	}

	public String getHousekeepingCommnet() {
		return housekeepingCommnet;
	}

	public void setHousekeepingCommnet(String housekeepingCommnet) {
		this.housekeepingCommnet = housekeepingCommnet;
	}

	public double getQuality_Y01() {
		return quality_Y01;
	}

	public void setQuality_Y01(double quality_Y01) {
		this.quality_Y01 = quality_Y01;
	}

	public double getQuality_Y02() {
		return quality_Y02;
	}

	public void setQuality_Y02(double quality_Y02) {
		this.quality_Y02 = quality_Y02;
	}

	public double getQuality_Y03() {
		return quality_Y03;
	}

	public void setQuality_Y03(double quality_Y03) {
		this.quality_Y03 = quality_Y03;
	}

	public double getQuality_Y04() {
		return quality_Y04;
	}

	public void setQuality_Y04(double quality_Y04) {
		this.quality_Y04 = quality_Y04;
	}

	public double getQuality_MTD01() {
		return quality_MTD01;
	}

	public void setQuality_MTD01(double quality_MTD01) {
		this.quality_MTD01 = quality_MTD01;
	}

	public double getQuality_MTD02() {
		return quality_MTD02;
	}

	public void setQuality_MTD02(double quality_MTD02) {
		this.quality_MTD02 = quality_MTD02;
	}

	public double getQuality_MTD03() {
		return quality_MTD03;
	}

	public void setQuality_MTD03(double quality_MTD03) {
		this.quality_MTD03 = quality_MTD03;
	}

	public double getQuality_MTD04() {
		return quality_MTD04;
	}

	public void setQuality_MTD04(double quality_MTD04) {
		this.quality_MTD04 = quality_MTD04;
	}

	public double getQuality_G01() {
		return quality_G01;
	}

	public void setQuality_G01(double quality_G01) {
		this.quality_G01 = quality_G01;
	}



	public String getQualityComment() {
		return qualityComment;
	}

	public void setQualityComment(String qualityComment) {
		this.qualityComment = qualityComment;
	}

	public double getPaperProd_Y01() {
		return paperProd_Y01;
	}

	public void setPaperProd_Y01(double paperProd_Y01) {
		this.paperProd_Y01 = paperProd_Y01;
	}

	public double getPaperProd_Y02() {
		return paperProd_Y02;
	}

	public void setPaperProd_Y02(double paperProd_Y02) {
		this.paperProd_Y02 = paperProd_Y02;
	}

	public double getPaperProd_Y03() {
		return paperProd_Y03;
	}

	public void setPaperProd_Y03(double paperProd_Y03) {
		this.paperProd_Y03 = paperProd_Y03;
	}

	public String getPaperProd_Y04() {
		return paperProd_Y04;
	}

	public void setPaperProd_Y04(String paperProd_Y04) {
		this.paperProd_Y04 = paperProd_Y04;
	}

	public double getPaperProd_Y05() {
		return paperProd_Y05;
	}

	public void setPaperProd_Y05(double paperProd_Y05) {
		this.paperProd_Y05 = paperProd_Y05;
	}

	public double getPaperProd_Y06() {
		return paperProd_Y06;
	}

	public void setPaperProd_Y06(double paperProd_Y06) {
		this.paperProd_Y06 = paperProd_Y06;
	}

	public double getPaperProd_Y07() {
		return paperProd_Y07;
	}

	public void setPaperProd_Y07(double paperProd_Y07) {
		this.paperProd_Y07 = paperProd_Y07;
	}

	public double getPaperProd_MTD01() {
		return paperProd_MTD01;
	}

	public void setPaperProd_MTD01(double paperProd_MTD01) {
		this.paperProd_MTD01 = paperProd_MTD01;
	}

	public double getPaperProd_MTD02() {
		return paperProd_MTD02;
	}

	public void setPaperProd_MTD02(double paperProd_MTD02) {
		this.paperProd_MTD02 = paperProd_MTD02;
	}

	public double getPaperProd_MTD03() {
		return paperProd_MTD03;
	}

	public void setPaperProd_MTD03(double paperProd_MTD03) {
		this.paperProd_MTD03 = paperProd_MTD03;
	}

	public double getPaperProd_MTD06() {
		return paperProd_MTD06;
	}

	public void setPaperProd_MTD06(double paperProd_MTD06) {
		this.paperProd_MTD06 = paperProd_MTD06;
	}

	public double getPaperProd_MTD07() {
		return paperProd_MTD07;
	}

	public void setPaperProd_MTD07(double paperProd_MTD07) {
		this.paperProd_MTD07 = paperProd_MTD07;
	}

	public double getPaperProd_G03() {
		return paperProd_G03;
	}

	public void setPaperProd_G03(double paperProd_G03) {
		this.paperProd_G03 = paperProd_G03;
	}

	public double getPaperProd_G06() {
		return paperProd_G06;
	}

	public void setPaperProd_G06(double paperProd_G06) {
		this.paperProd_G06 = paperProd_G06;
	}

	public double getPaperProd_G07() {
		return paperProd_G07;
	}

	public void setPaperProd_G07(double paperProd_G07) {
		this.paperProd_G07 = paperProd_G07;
	}

	public String getPaperProdComment() {
		return paperProdComment;
	}

	public void setPaperProdComment(String paperProdComment) {
		this.paperProdComment = paperProdComment;
	}

	public double getShipping_Y01() {
		return shipping_Y01;
	}

	public void setShipping_Y01(double shipping_Y01) {
		this.shipping_Y01 = shipping_Y01;
	}

	public double getShipping_Y02() {
		return shipping_Y02;
	}

	public void setShipping_Y02(double shipping_Y02) {
		this.shipping_Y02 = shipping_Y02;
	}

	public double getShipping_Y03() {
		return shipping_Y03;
	}

	public void setShipping_Y03(double shipping_Y03) {
		this.shipping_Y03 = shipping_Y03;
	}

	public double getShipping_Y04() {
		return shipping_Y04;
	}

	public void setShipping_Y04(double shipping_Y04) {
		this.shipping_Y04 = shipping_Y04;
	}

	public String getShippingComment() {
		return shippingComment;
	}

	public void setShippingComment(String shippingComment) {
		this.shippingComment = shippingComment;
	}

	public double getCosts_Y01() {
		return costs_Y01;
	}

	public void setCosts_Y01(double costs_Y01) {
		this.costs_Y01 = costs_Y01;
	}

	public double getCosts_Y02() {
		return costs_Y02;
	}

	public void setCosts_Y02(double costs_Y02) {
		this.costs_Y02 = costs_Y02;
	}

	public double getCosts_MTD01() {
		return costs_MTD01;
	}

	public void setCosts_MTD01(double costs_MTD01) {
		this.costs_MTD01 = costs_MTD01;
	}

	public double getCosts_MTD02() {
		return costs_MTD02;
	}

	public void setCosts_MTD02(double costs_MTD02) {
		this.costs_MTD02 = costs_MTD02;
	}

	public double getCosts_G01() {
		return costs_G01;
	}

	public void setCosts_G01(double costs_G01) {
		this.costs_G01 = costs_G01;
	}

	public double getCosts_G02() {
		return costs_G02;
	}

	public void setCosts_G02(double costs_G02) {
		this.costs_G02 = costs_G02;
	}

	public String getCostsComment() {
		return costsComment;
	}

	public void setCostsComment(String costsComment) {
		this.costsComment = costsComment;
	}

	public String getSafetyMeetingTopic() {
		return safetyMeetingTopic;
	}

	public void setSafetyMeetingTopic(String safetyMeetingTopic) {
		this.safetyMeetingTopic = safetyMeetingTopic;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String getVisitor() {
		return visitor;
	}

	public void setVisitor(String visitor) {
		this.visitor = visitor;
	}

	public String getAttendee() {
		return attendee;
	}

	public void setAttendee(String attendee) {
		this.attendee = attendee;
	}

	public String getMeetingToday() {
		return meetingToday;
	}

	public void setMeetingToday(String meetingToday) {
		this.meetingToday = meetingToday;
	}

}

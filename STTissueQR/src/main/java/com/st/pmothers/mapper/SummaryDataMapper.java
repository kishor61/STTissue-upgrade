/**
 *Dec 1, 2014
 *SummaryDataMapper.java
 * TODO
 *com.st.pmothers.mapper
 *SummaryDataMapper.java
 *Sunil Singh Bora
 */
package com.st.pmothers.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import org.springframework.jdbc.core.RowMapper;

import com.st.pmothers.model.SummaryData;

/**
 * @author sbora
 *
 */
public class SummaryDataMapper implements RowMapper<SummaryData> {

	/* (non-Javadoc)
	 * @see org.springframework.jdbc.core.RowMapper#mapRow(java.sql.ResultSet, int)
	 */
	@Override
	public SummaryData mapRow(ResultSet rs, int arg1) throws SQLException {
		SummaryData summaryData=new SummaryData();
		summaryData.setId(rs.getInt("ID"));
		summaryData.setDate(new Date(rs.getTimestamp("Date").getTime()));
		summaryData.setProductionDate(new Date(rs.getTimestamp("ProductionDate").getTime()));
		summaryData.setSafety_Y01(rs.getDouble("Safety_Y01"));
		summaryData.setSafety_Y02(rs.getDouble("Safety_Y02"));
		summaryData.setSafety_Y03(rs.getDouble("Safety_Y03"));
		summaryData.setSafety_Y04(rs.getDouble("Safety_Y04"));
//		summaryData.setSafety_Y05(rs.getDouble("Safety_Y05"));
//		summaryData.setSafety_MTD01(rs.getDouble("Safety_MTD01"));
//		summaryData.setSafety_MTD02(rs.getDouble("Safety_MTD02"));
		summaryData.setSafety_MTD03(rs.getDouble("Safety_MTD03"));
		summaryData.setSafety_MTD04(rs.getDouble("Safety_MTD04"));
//		summaryData.setSafety_MTD05(rs.getDouble("Safety_MTD05"));
		summaryData.setSafety_G01(rs.getDouble("Safety_G01"));
		summaryData.setSafety_G02(rs.getDouble("Safety_G02"));
//		summaryData.setSafety_G03(rs.getDouble("Safety_G03"));
//		summaryData.setSafety_G04(rs.getDouble("Safety_G04"));
//		summaryData.setSafety_G05(rs.getDouble("Safety_G05"));
		summaryData.setSafetyComment(rs.getString("SafetyComment"));
		summaryData.setHousekeeping_Y01(rs.getDouble("Housekeeping_Y01"));
		summaryData.setHousekeeping_MTD01(rs.getDouble("Housekeeping_MTD01"));
		summaryData.setHousekeeping_G01(rs.getDouble("Housekeeping_G01"));
		summaryData.setHousekeepingCommnet(rs.getString("HousekeepingCommnet"));
		summaryData.setQuality_Y01(rs.getDouble("Quality_Y01"));
		summaryData.setQuality_Y02(rs.getDouble("Quality_Y02"));
		summaryData.setQuality_Y03(rs.getDouble("Quality_Y03"));
		summaryData.setQuality_Y04(rs.getDouble("Quality_Y04"));
		summaryData.setQuality_MTD01(rs.getDouble("Quality_MTD01"));
		summaryData.setQuality_MTD02(rs.getDouble("Quality_MTD02"));
		summaryData.setQuality_MTD03(rs.getDouble("Quality_MTD03"));
		summaryData.setQuality_MTD04(rs.getDouble("Quality_MTD04"));
		summaryData.setQuality_G01(rs.getDouble("Quality_G01"));
//		summaryData.setQuality_G02(rs.getDouble("Quality_G02"));
//		summaryData.setQuality_G03(rs.getDouble("Quality_G03"));
//		summaryData.setQuality_G04(rs.getDouble("Quality_G04"));
		summaryData.setQualityComment(rs.getString("QualityComment"));
		summaryData.setFiberProd_Y01(rs.getDouble("FiberProd_Y01"));
		summaryData.setFiberProd_Y02(rs.getDouble("FiberProd_Y02"));
		summaryData.setFiberProd_Y03(rs.getDouble("FiberProd_Y03"));
		summaryData.setFiberProd_Y04(rs.getDouble("FiberProd_Y04"));
		summaryData.setFiberProd_Y05(rs.getDouble("FiberProd_Y05"));
		summaryData.setFiberProd_Y06(rs.getDouble("FiberProd_Y06"));
		summaryData.setFiberProd_Y07(rs.getDouble("FiberProd_Y07"));
		summaryData.setFiberProd_Y08(rs.getDouble("FiberProd_Y08"));
		summaryData.setFiberProd_Y09(rs.getDouble("FiberProd_Y09"));
		summaryData.setFiberProd_MTD01(rs.getDouble("FiberProd_MTD01"));
		summaryData.setFiberProd_MTD02(rs.getDouble("FiberProd_MTD02"));
		summaryData.setFiberProd_MTD03(rs.getDouble("FiberProd_MTD03"));
		summaryData.setFiberProd_MTD04(rs.getDouble("FiberProd_MTD04"));
		summaryData.setFiberProd_MTD05(rs.getDouble("FiberProd_MTD05"));
		summaryData.setFiberProd_MTD06(rs.getDouble("FiberProd_MTD06"));
		summaryData.setFiberProd_MTD07(rs.getDouble("FiberProd_MTD07"));
		summaryData.setFiberProd_MTD08(rs.getDouble("FiberProd_MTD08"));
		summaryData.setFiberProd_MTD09(rs.getDouble("FiberProd_MTD09"));
//		summaryData.setFiberProd_G01(rs.getDouble("FiberProd_G01"));
//		summaryData.setFiberProd_G02(rs.getDouble("FiberProd_G02"));
		summaryData.setFiberProd_G03(rs.getDouble("FiberProd_G03"));
		summaryData.setFiberProd_G04(rs.getDouble("FiberProd_G04"));
		summaryData.setFiberProd_G05(rs.getDouble("FiberProd_G05"));
		summaryData.setFiberProd_G06(rs.getDouble("FiberProd_G06"));
		summaryData.setFiberProd_G07(rs.getDouble("FiberProd_G07"));
		summaryData.setFiberProd_G08(rs.getDouble("FiberProd_G08"));
		summaryData.setFiberProd_G09(rs.getDouble("FiberProd_G09"));
		summaryData.setFiberProdComment(rs.getString("FiberProdComment"));
		summaryData.setPaperProd_Y01(rs.getDouble("PaperProd_Y01"));
		summaryData.setPaperProd_Y02(rs.getDouble("PaperProd_Y02"));
		summaryData.setPaperProd_Y03(rs.getDouble("PaperProd_Y03"));
		summaryData.setPaperProd_Y04(rs.getString("PaperProd_Y04"));
		summaryData.setPaperProd_Y05(rs.getDouble("PaperProd_Y05"));
		summaryData.setPaperProd_Y06(rs.getDouble("PaperProd_Y06"));
		summaryData.setPaperProd_Y07(rs.getDouble("PaperProd_Y07"));
		summaryData.setPaperProd_MTD01(rs.getDouble("PaperProd_MTD01"));
		summaryData.setPaperProd_MTD02(rs.getDouble("PaperProd_MTD02"));
		summaryData.setPaperProd_MTD03(rs.getDouble("PaperProd_MTD03"));
//		summaryData.setPaperProd_MTD04(rs.getDouble("PaperProd_MTD04"));
//		summaryData.setPaperProd_MTD05(rs.getDouble("PaperProd_MTD05"));
		summaryData.setPaperProd_MTD06(rs.getDouble("PaperProd_MTD06"));
		summaryData.setPaperProd_MTD07(rs.getDouble("PaperProd_MTD07"));
//		summaryData.setPaperProd_G01(rs.getDouble("PaperProd_G01"));
//		summaryData.setPaperProd_G02(rs.getDouble("PaperProd_G02"));
		summaryData.setPaperProd_G03(rs.getDouble("PaperProd_G03"));
//		summaryData.setPaperProd_G04(rs.getDouble("PaperProd_G04"));
//		summaryData.setPaperProd_G05(rs.getDouble("PaperProd_G05"));
		summaryData.setPaperProd_G06(rs.getDouble("PaperProd_G06"));
		summaryData.setPaperProd_G07(rs.getDouble("PaperProd_G07"));
		summaryData.setPaperProdComment(rs.getString("PaperProdComment"));
		summaryData.setShipping_Y01(rs.getDouble("Shipping_Y01"));
		summaryData.setShipping_Y02(rs.getDouble("Shipping_Y02"));
		summaryData.setShipping_Y03(rs.getDouble("Shipping_Y03"));
		summaryData.setShipping_Y04(rs.getDouble("Shipping_Y04"));
//		summaryData.setShipping_MTD01(rs.getDouble("Shipping_MTD01"));
//		summaryData.setShipping_MTD02(rs.getDouble("Shipping_MTD02"));
//		summaryData.setShipping_MTD03(rs.getDouble("Shipping_MTD03"));
//		summaryData.setShipping_MTD04(rs.getDouble("Shipping_MTD04"));
//		summaryData.setShipping_G01(rs.getDouble("Shipping_G01"));
//		summaryData.setShipping_G02(rs.getDouble("Shipping_G02"));
//		summaryData.setShipping_G03(rs.getDouble("Shipping_G03"));
//		summaryData.setShipping_G04(rs.getDouble("Shipping_G04"));
		summaryData.setShippingComment(rs.getString("ShippingComment"));
		summaryData.setCosts_Y01(rs.getDouble("Costs_Y01"));
		summaryData.setCosts_Y02(rs.getDouble("Costs_Y02"));
		summaryData.setCosts_MTD01(rs.getDouble("Costs_MTD01"));
		summaryData.setCosts_MTD02(rs.getDouble("Costs_MTD02"));
		summaryData.setCosts_G01(rs.getDouble("Costs_G01"));
		summaryData.setCosts_G02(rs.getDouble("Costs_G02"));
		summaryData.setCostsComment(rs.getString("CostsComment"));

		summaryData.setSafetyMeetingTopic(rs.getString("SafetyMeetingTopic"));
		summaryData.setNotes(rs.getString("Notes"));
		
		summaryData.setMeetingToday(rs.getString("MeetingToday"));
		summaryData.setAttendee(rs.getString("Attendee"));
		summaryData.setVisitor(rs.getString("Visitor"));
		
		return summaryData;
	}

}

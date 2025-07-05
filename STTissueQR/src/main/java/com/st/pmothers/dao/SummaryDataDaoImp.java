/**
 *Dec 1, 2014
 *SummaryDataDaoImp.java
 * TODO
 *com.st.pmothers.dao
 *SummaryDataDaoImp.java
 *Sunil Singh Bora
 */
package com.st.pmothers.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.st.common.CommonUtil;
import com.st.pmothers.mapper.SummaryDataMapper;
import com.st.pmothers.model.SummaryData;

/**
 * @author sbora
 *
 */
@Repository
public class SummaryDataDaoImp implements SummaryDataDao {
	private static final Logger logger=LoggerFactory.getLogger(SummaryDataDaoImp.class);
	
	@Autowired
	private DataSource dataSource;

	@Autowired
	@Qualifier("dataSourceProduction")
	private DataSource dataSourceP;
	
	/* (non-Javadoc)
	 * @see com.st.pmothers.dao.SummaryDataDao#saveOrUpdate(com.st.pmothers.model.SummaryData)
	 */
	@Override
	public int saveOrUpdate(final SummaryData summaryData) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		
		int key=0;
		
		if(summaryData.getId()==0){
			KeyHolder keyHolder=new GeneratedKeyHolder();
			
			final String sql="insert into [dailySummaryData]"
					+ "("
					+ "[Date],"
					+ "[ProductionDate],"
					+ "[Safety_Y01],"
					+ "[Safety_Y02],"
					+ "[Safety_Y03],"
					+ "[Safety_Y04],"
//					+ "[Safety_Y05],"
//					+ "[Safety_MTD01],"
//					+ "[Safety_MTD02],"
					+ "[Safety_MTD03],"
					+ "[Safety_MTD04],"
//					+ "[Safety_MTD05],"
					+ "[Safety_G01],"
					+ "[Safety_G02],"
//					+ "[Safety_G03],"
//					+ "[Safety_G04],"
//					+ "[Safety_G05],"
					+ "[SafetyComment],"
					+ "[Housekeeping_Y01],"
					+ "[Housekeeping_MTD01],"
					+ "[Housekeeping_G01],"
					+ "[HousekeepingCommnet],"
					+ "[Quality_Y01],"
					+ "[Quality_Y02],"
					+ "[Quality_Y03],"
					+ "[Quality_Y04],"
					+ "[Quality_MTD01],"
					+ "[Quality_MTD02],"
					+ "[Quality_MTD03],"
					+ "[Quality_MTD04],"
					+ "[Quality_G01],"
//					+ "[Quality_G02],"
//					+ "[Quality_G03],"
//					+ "[Quality_G04],"
					+ "[QualityComment],"
					+ "[FiberProd_Y01],"
					+ "[FiberProd_Y02],"
					+ "[FiberProd_Y03],"
					+ "[FiberProd_Y04],"
					+ "[FiberProd_Y05],"
					+ "[FiberProd_Y06],"
					+ "[FiberProd_Y07],"
					+ "[FiberProd_Y08],"
					+ "[FiberProd_Y09],"
					+ "[FiberProd_MTD01],"
					+ "[FiberProd_MTD02],"
					+ "[FiberProd_MTD03],"
					+ "[FiberProd_MTD04],"
					+ "[FiberProd_MTD05],"
					+ "[FiberProd_MTD06],"
					+ "[FiberProd_MTD07],"
					+ "[FiberProd_MTD08],"
					+ "[FiberProd_MTD09],"
//					+ "[FiberProd_G01],"
//					+ "[FiberProd_G02],"
					+ "[FiberProd_G03],"
					+ "[FiberProd_G04],"
					+ "[FiberProd_G05],"
					+ "[FiberProd_G06],"
					+ "[FiberProd_G07],"
					+ "[FiberProd_G08],"
					+ "[FiberProd_G09],"
					+ "[FiberProdComment],"
					+ "[PaperProd_Y01],"
					+ "[PaperProd_Y02],"
					+ "[PaperProd_Y03],"
					+ "[PaperProd_Y04],"
					+ "[PaperProd_Y05],"
					+ "[PaperProd_Y06],"
					+ "[PaperProd_Y07],"
					+ "[PaperProd_MTD01],"
					+ "[PaperProd_MTD02],"
					+ "[PaperProd_MTD03],"
//					+ "[PaperProd_MTD04],"
//					+ "[PaperProd_MTD05],"
					+ "[PaperProd_MTD06],"
					+ "[PaperProd_MTD07],"
//					+ "[PaperProd_G01],"
//					+ "[PaperProd_G02],"
					+ "[PaperProd_G03],"
//					+ "[PaperProd_G04],"
//					+ "[PaperProd_G05],"
					+ "[PaperProd_G06],"
					+ "[PaperProd_G07],"
					+ "[PaperProdComment],"
					+ "[Shipping_Y01],"
					+ "[Shipping_Y02],"
					+ "[Shipping_Y03],"
					+ "[Shipping_Y04],"
//					+ "[Shipping_MTD01],"
//					+ "[Shipping_MTD02],"
//					+ "[Shipping_MTD03],"
//					+ "[Shipping_MTD04],"
//					+ "[Shipping_G01],"
//					+ "[Shipping_G02],"
//					+ "[Shipping_G03],"
//					+ "[Shipping_G04],"
					+ "[ShippingComment],"
					+ "[Costs_Y01],"
					+ "[Costs_Y02],"
					+ "[Costs_MTD01],"
					+ "[Costs_MTD02],"
					+ "[Costs_G01],"
					+ "[Costs_G02],"
					+ "[CostsComment],"
					+ "[SafetyMeetingTopic], "
					+ "[Notes], "
					+ "[MeetingToday], "
					+ "[Attendee], "
					+ "[Visitor] "
					+ ")"
					+ " values("
					+ "?,?,?,?,?,?,?,?,?,?"
					+ ",?,?,?,?,?,?,?,?,?,?"
					+ ",?,?,?,?,?,?,?,?,?,?"
					+ ",?,?,?,?,?,?,?,?,?,?"
					+ ",?,?,?,?,?,?,?,?,?,?"
					+ ",?,?,?,?,?,?,?,?,?,?"
					+ ",?,?,?,?,?,?,?,?,?,?"
					+ ",?,?,?,?,?,?,?,?,?,?"
					+ ",?,?,?,?"
					+ ")";
			
			jdbcTemplate.update(new PreparedStatementCreator() {
				
				@Override
				public PreparedStatement createPreparedStatement(Connection arg0)
						throws SQLException {
					PreparedStatement statement=arg0.prepareStatement(sql, new String[]{"ID"});
					
					statement.setTimestamp(1, new Timestamp(summaryData.getDate().getTime()));
					statement.setTimestamp(2, new Timestamp(summaryData.getProductionDate().getTime()));
					statement.setDouble(3, summaryData.getSafety_Y01());
					statement.setDouble(4, summaryData.getSafety_Y02());
					statement.setDouble(5, summaryData.getSafety_Y03());
					statement.setDouble(6, summaryData.getSafety_Y04());
//					statement.setDouble(7, summaryData.getSafety_Y05());
				//	statement.setDouble(8, summaryData.getSafety_MTD01());
				//	statement.setDouble(9, summaryData.getSafety_MTD02());
					statement.setDouble(7, summaryData.getSafety_MTD03());
					statement.setDouble(8, summaryData.getSafety_MTD04());
//					statement.setDouble(10, summaryData.getSafety_MTD05());
					statement.setDouble(9, summaryData.getSafety_G01());
					statement.setDouble(10, summaryData.getSafety_G02());
				//	statement.setDouble(15, summaryData.getSafety_G03());
//					statement.setDouble(16, summaryData.getSafety_G04());
//					statement.setDouble(17, summaryData.getSafety_G05());
					statement.setString(11, summaryData.getSafetyComment());
					statement.setDouble(12, summaryData.getHousekeeping_Y01());
					statement.setDouble(13, summaryData.getHousekeeping_MTD01());
					statement.setDouble(14, summaryData.getHousekeeping_G01());
					statement.setString(15, summaryData.getHousekeepingCommnet());
					statement.setDouble(16, summaryData.getQuality_Y01());
					statement.setDouble(17, summaryData.getQuality_Y02());
					statement.setDouble(18, summaryData.getQuality_Y03());
					statement.setDouble(19, summaryData.getQuality_Y04());
					statement.setDouble(20, summaryData.getQuality_MTD01());
					statement.setDouble(21, summaryData.getQuality_MTD02());
					statement.setDouble(22, summaryData.getQuality_MTD03());
					statement.setDouble(23, summaryData.getQuality_MTD04());
					statement.setDouble(24, summaryData.getQuality_G01());
//					statement.setDouble(27, summaryData.getQuality_G02());
//					statement.setDouble(33, summaryData.getQuality_G03());
//					statement.setDouble(34, summaryData.getQuality_G04());
					statement.setString(25, summaryData.getQualityComment());
					statement.setDouble(26, summaryData.getFiberProd_Y01());
					statement.setDouble(27, summaryData.getFiberProd_Y02());
					statement.setDouble(28, summaryData.getFiberProd_Y03());
					statement.setDouble(29, summaryData.getFiberProd_Y04());
					statement.setDouble(30, summaryData.getFiberProd_Y05());
					statement.setDouble(31, summaryData.getFiberProd_Y06());
					statement.setDouble(32, summaryData.getFiberProd_Y07());
					statement.setDouble(33, summaryData.getFiberProd_Y08());
					statement.setDouble(34, summaryData.getFiberProd_Y09());
					statement.setDouble(35, summaryData.getFiberProd_MTD01());
					statement.setDouble(36, summaryData.getFiberProd_MTD02());
					statement.setDouble(37, summaryData.getFiberProd_MTD03());
					statement.setDouble(38, summaryData.getFiberProd_MTD04());
					statement.setDouble(39, summaryData.getFiberProd_MTD05());
					statement.setDouble(40, summaryData.getFiberProd_MTD06());
					statement.setDouble(41, summaryData.getFiberProd_MTD07());
					statement.setDouble(42, summaryData.getFiberProd_MTD08());
					statement.setDouble(43, summaryData.getFiberProd_MTD09());
//					statement.setDouble(54, summaryData.getFiberProd_G01());
//					statement.setDouble(55, summaryData.getFiberProd_G02());
					statement.setDouble(44, summaryData.getFiberProd_G03());
					statement.setDouble(45, summaryData.getFiberProd_G04());
					statement.setDouble(46, summaryData.getFiberProd_G05());
					statement.setDouble(47, summaryData.getFiberProd_G06());
					statement.setDouble(48, summaryData.getFiberProd_G07());
					statement.setDouble(49, summaryData.getFiberProd_G08());
					statement.setDouble(50, summaryData.getFiberProd_G09());
					statement.setString(51, summaryData.getFiberProdComment());
					statement.setDouble(52, summaryData.getPaperProd_Y01());
					statement.setDouble(53, summaryData.getPaperProd_Y02());
					statement.setDouble(54, summaryData.getPaperProd_Y03());
					statement.setString(55, summaryData.getPaperProd_Y04());
					statement.setDouble(56, summaryData.getPaperProd_Y05());
					statement.setDouble(57, summaryData.getPaperProd_Y06());
					statement.setDouble(58, summaryData.getPaperProd_Y07());
					statement.setDouble(59, summaryData.getPaperProd_MTD01());
					statement.setDouble(60, summaryData.getPaperProd_MTD02());
					statement.setDouble(61, summaryData.getPaperProd_MTD03());
//					statement.setDouble(74, summaryData.getPaperProd_MTD04());
//					statement.setDouble(75, summaryData.getPaperProd_MTD05());
					statement.setDouble(62, summaryData.getPaperProd_MTD06());
					statement.setDouble(63, summaryData.getPaperProd_MTD07());
//					statement.setDouble(78, summaryData.getPaperProd_G01());
//					statement.setDouble(79, summaryData.getPaperProd_G02());
					statement.setDouble(64, summaryData.getPaperProd_G03());
//					statement.setDouble(81, summaryData.getPaperProd_G04());
//					statement.setDouble(82, summaryData.getPaperProd_G05());
					statement.setDouble(65, summaryData.getPaperProd_G06());
					statement.setDouble(66, summaryData.getPaperProd_G07());
					statement.setString(67, summaryData.getPaperProdComment());
					statement.setDouble(68, summaryData.getShipping_Y01());
					statement.setDouble(69, summaryData.getShipping_Y02());
					statement.setDouble(70, summaryData.getShipping_Y03());
					statement.setDouble(71, summaryData.getShipping_Y04());
//					statement.setDouble(90, summaryData.getShipping_MTD01());
//					statement.setDouble(91, summaryData.getShipping_MTD02());
//					statement.setDouble(92, summaryData.getShipping_MTD03());
//					statement.setDouble(93, summaryData.getShipping_MTD04());
//					statement.setDouble(94, summaryData.getShipping_G01());
//					statement.setDouble(95, summaryData.getShipping_G02());
//					statement.setDouble(96, summaryData.getShipping_G03());
//					statement.setDouble(97, summaryData.getShipping_G04());
					statement.setString(72, summaryData.getShippingComment());
					statement.setDouble(73, summaryData.getCosts_Y01());
					statement.setDouble(74, summaryData.getCosts_Y02());
					statement.setDouble(75, summaryData.getCosts_MTD01());
					statement.setDouble(76, summaryData.getCosts_MTD02());
					statement.setDouble(77, summaryData.getCosts_G01());
					statement.setDouble(78, summaryData.getCosts_G02());
					statement.setString(79, summaryData.getCostsComment());
					statement.setString(80, summaryData.getSafetyMeetingTopic());
					statement.setString(81, summaryData.getNotes());
					statement.setString(82, summaryData.getMeetingToday());
					statement.setString(83, summaryData.getAttendee());
					statement.setString(84, summaryData.getVisitor());
					
					return statement;
				}
			},keyHolder);
			
			key=keyHolder.getKey().intValue();
		}else{
			
			final String sql="update [dailySummaryData] set "
					
					+ "[Date]=?,"
					+ "[ProductionDate]=?,"
					+ "[Safety_Y01]=?,"
					+ "[Safety_Y02]=?,"
					+ "[Safety_Y03]=?,"
					+ "[Safety_Y04]=?,"
//					+ "[Safety_Y05]=?,"
//					+ "[Safety_MTD01]=?,"
//					+ "[Safety_MTD02]=?,"
					+ "[Safety_MTD03]=?,"
					+ "[Safety_MTD04]=?,"
//					+ "[Safety_MTD05]=?,"
					+ "[Safety_G01]=?,"
					+ "[Safety_G02]=?,"
//					+ "[Safety_G03]=?,"
//					+ "[Safety_G04]=?,"
//					+ "[Safety_G05]=?,"
					+ "[SafetyComment]=?,"
					+ "[Housekeeping_Y01]=?,"
					+ "[Housekeeping_MTD01]=?,"
					+ "[Housekeeping_G01]=?,"
					+ "[HousekeepingCommnet]=?,"
					+ "[Quality_Y01]=?,"
					+ "[Quality_Y02]=?,"
					+ "[Quality_Y03]=?,"
					+ "[Quality_Y04]=?,"
					+ "[Quality_MTD01]=?,"
					+ "[Quality_MTD02]=?,"
					+ "[Quality_MTD03]=?,"
					+ "[Quality_MTD04]=?,"
					+ "[Quality_G01]=?,"
//					+ "[Quality_G02]=?,"
//					+ "[Quality_G03]=?,"
//					+ "[Quality_G04]=?,"
					+ "[QualityComment]=?,"
					+ "[FiberProd_Y01]=?,"
					+ "[FiberProd_Y02]=?,"
					+ "[FiberProd_Y03]=?,"
					+ "[FiberProd_Y04]=?,"
					+ "[FiberProd_Y05]=?,"
					+ "[FiberProd_Y06]=?,"
					+ "[FiberProd_Y07]=?,"
					+ "[FiberProd_Y08]=?,"
					+ "[FiberProd_Y09]=?,"
					+ "[FiberProd_MTD01]=?,"
					+ "[FiberProd_MTD02]=?,"
					+ "[FiberProd_MTD03]=?,"
					+ "[FiberProd_MTD04]=?,"
					+ "[FiberProd_MTD05]=?,"
					+ "[FiberProd_MTD06]=?,"
					+ "[FiberProd_MTD07]=?,"
					+ "[FiberProd_MTD08]=?,"
					+ "[FiberProd_MTD09]=?,"
//					+ "[FiberProd_G01]=?,"
//					+ "[FiberProd_G02]=?,"
					+ "[FiberProd_G03]=?,"
					+ "[FiberProd_G04]=?,"
					+ "[FiberProd_G05]=?,"
					+ "[FiberProd_G06]=?,"
					+ "[FiberProd_G07]=?,"
					+ "[FiberProd_G08]=?,"
					+ "[FiberProd_G09]=?,"
					+ "[FiberProdComment]=?,"
					+ "[PaperProd_Y01]=?,"
					+ "[PaperProd_Y02]=?,"
					+ "[PaperProd_Y03]=?,"
					+ "[PaperProd_Y04]=?,"
					+ "[PaperProd_Y05]=?,"
					+ "[PaperProd_Y06]=?,"
					+ "[PaperProd_Y07]=?,"
					+ "[PaperProd_MTD01]=?,"
					+ "[PaperProd_MTD02]=?,"
					+ "[PaperProd_MTD03]=?,"
//					+ "[PaperProd_MTD04]=?,"
//					+ "[PaperProd_MTD05]=?,"
					+ "[PaperProd_MTD06]=?,"
					+ "[PaperProd_MTD07]=?,"
//					+ "[PaperProd_G01]=?,"
//					+ "[PaperProd_G02]=?,"
					+ "[PaperProd_G03]=?,"
//					+ "[PaperProd_G04]=?,"
//					+ "[PaperProd_G05]=?,"
					+ "[PaperProd_G06]=?,"
					+ "[PaperProd_G07]=?,"
					+ "[PaperProdComment]=?,"
					+ "[Shipping_Y01]=?,"
					+ "[Shipping_Y02]=?,"
					+ "[Shipping_Y03]=?,"
					+ "[Shipping_Y04]=?,"
//					+ "[Shipping_MTD01]=?,"
//					+ "[Shipping_MTD02]=?,"
//					+ "[Shipping_MTD03]=?,"
//					+ "[Shipping_MTD04]=?,"
//					+ "[Shipping_G01]=?,"
//					+ "[Shipping_G02]=?,"
//					+ "[Shipping_G03]=?,"
//					+ "[Shipping_G04]=?,"
					+ "[ShippingComment]=?,"
					+ "[Costs_Y01]=?,"
					+ "[Costs_Y02]=?,"
					+ "[Costs_MTD01]=?,"
					+ "[Costs_MTD02]=?,"
					+ "[Costs_G01]=?,"
					+ "[Costs_G02]=?,"
					+ "[CostsComment]=?,"
					+ "[SafetyMeetingTopic]=?, "
					+ "[Notes]=?,"
					+ "[MeetingToday]=?, "
					+ "[Attendee]=?, "
					+ "[Visitor]=?  "
					
					+ " where [ID]=? ";
			
			jdbcTemplate.update(new PreparedStatementCreator() {
				
				@Override
				public PreparedStatement createPreparedStatement(Connection arg0)
						throws SQLException {
					PreparedStatement statement=arg0.prepareStatement(sql);
					
					statement.setTimestamp(1, new Timestamp(summaryData.getDate().getTime()));
					statement.setTimestamp(2, new Timestamp(summaryData.getProductionDate().getTime()));
					statement.setDouble(3, summaryData.getSafety_Y01());
					statement.setDouble(4, summaryData.getSafety_Y02());
					statement.setDouble(5, summaryData.getSafety_Y03());
					statement.setDouble(6, summaryData.getSafety_Y04());
//					statement.setDouble(7, summaryData.getSafety_Y05());
				//	statement.setDouble(8, summaryData.getSafety_MTD01());
				//	statement.setDouble(9, summaryData.getSafety_MTD02());
					statement.setDouble(7, summaryData.getSafety_MTD03());
					statement.setDouble(8, summaryData.getSafety_MTD04());
//					statement.setDouble(10, summaryData.getSafety_MTD05());
					statement.setDouble(9, summaryData.getSafety_G01());
					statement.setDouble(10, summaryData.getSafety_G02());
				//	statement.setDouble(15, summaryData.getSafety_G03());
//					statement.setDouble(16, summaryData.getSafety_G04());
//					statement.setDouble(17, summaryData.getSafety_G05());
					statement.setString(11, summaryData.getSafetyComment());
					statement.setDouble(12, summaryData.getHousekeeping_Y01());
					statement.setDouble(13, summaryData.getHousekeeping_MTD01());
					statement.setDouble(14, summaryData.getHousekeeping_G01());
					statement.setString(15, summaryData.getHousekeepingCommnet());
					statement.setDouble(16, summaryData.getQuality_Y01());
					statement.setDouble(17, summaryData.getQuality_Y02());
					statement.setDouble(18, summaryData.getQuality_Y03());
					statement.setDouble(19, summaryData.getQuality_Y04());
					statement.setDouble(20, summaryData.getQuality_MTD01());
					statement.setDouble(21, summaryData.getQuality_MTD02());
					statement.setDouble(22, summaryData.getQuality_MTD03());
					statement.setDouble(23, summaryData.getQuality_MTD04());
					statement.setDouble(24, summaryData.getQuality_G01());
//					statement.setDouble(27, summaryData.getQuality_G02());
//					statement.setDouble(33, summaryData.getQuality_G03());
//					statement.setDouble(34, summaryData.getQuality_G04());
					statement.setString(25, summaryData.getQualityComment());
					statement.setDouble(26, summaryData.getFiberProd_Y01());
					statement.setDouble(27, summaryData.getFiberProd_Y02());
					statement.setDouble(28, summaryData.getFiberProd_Y03());
					statement.setDouble(29, summaryData.getFiberProd_Y04());
					statement.setDouble(30, summaryData.getFiberProd_Y05());
					statement.setDouble(31, summaryData.getFiberProd_Y06());
					statement.setDouble(32, summaryData.getFiberProd_Y07());
					statement.setDouble(33, summaryData.getFiberProd_Y08());
					statement.setDouble(34, summaryData.getFiberProd_Y09());
					statement.setDouble(35, summaryData.getFiberProd_MTD01());
					statement.setDouble(36, summaryData.getFiberProd_MTD02());
					statement.setDouble(37, summaryData.getFiberProd_MTD03());
					statement.setDouble(38, summaryData.getFiberProd_MTD04());
					statement.setDouble(39, summaryData.getFiberProd_MTD05());
					statement.setDouble(40, summaryData.getFiberProd_MTD06());
					statement.setDouble(41, summaryData.getFiberProd_MTD07());
					statement.setDouble(42, summaryData.getFiberProd_MTD08());
					statement.setDouble(43, summaryData.getFiberProd_MTD09());
//					statement.setDouble(54, summaryData.getFiberProd_G01());
//					statement.setDouble(55, summaryData.getFiberProd_G02());
					statement.setDouble(44, summaryData.getFiberProd_G03());
					statement.setDouble(45, summaryData.getFiberProd_G04());
					statement.setDouble(46, summaryData.getFiberProd_G05());
					statement.setDouble(47, summaryData.getFiberProd_G06());
					statement.setDouble(48, summaryData.getFiberProd_G07());
					statement.setDouble(49, summaryData.getFiberProd_G08());
					statement.setDouble(50, summaryData.getFiberProd_G09());
					statement.setString(51, summaryData.getFiberProdComment());
					statement.setDouble(52, summaryData.getPaperProd_Y01());
					statement.setDouble(53, summaryData.getPaperProd_Y02());
					statement.setDouble(54, summaryData.getPaperProd_Y03());
					statement.setString(55, summaryData.getPaperProd_Y04());
					statement.setDouble(56, summaryData.getPaperProd_Y05());
					statement.setDouble(57, summaryData.getPaperProd_Y06());
					statement.setDouble(58, summaryData.getPaperProd_Y07());
					statement.setDouble(59, summaryData.getPaperProd_MTD01());
					statement.setDouble(60, summaryData.getPaperProd_MTD02());
					statement.setDouble(61, summaryData.getPaperProd_MTD03());
//					statement.setDouble(74, summaryData.getPaperProd_MTD04());
//					statement.setDouble(75, summaryData.getPaperProd_MTD05());
					statement.setDouble(62, summaryData.getPaperProd_MTD06());
					statement.setDouble(63, summaryData.getPaperProd_MTD07());
//					statement.setDouble(78, summaryData.getPaperProd_G01());
//					statement.setDouble(79, summaryData.getPaperProd_G02());
					statement.setDouble(64, summaryData.getPaperProd_G03());
//					statement.setDouble(81, summaryData.getPaperProd_G04());
//					statement.setDouble(82, summaryData.getPaperProd_G05());
					statement.setDouble(65, summaryData.getPaperProd_G06());
					statement.setDouble(66, summaryData.getPaperProd_G07());
					statement.setString(67, summaryData.getPaperProdComment());
					statement.setDouble(68, summaryData.getShipping_Y01());
					statement.setDouble(69, summaryData.getShipping_Y02());
					statement.setDouble(70, summaryData.getShipping_Y03());
					statement.setDouble(71, summaryData.getShipping_Y04());
//					statement.setDouble(90, summaryData.getShipping_MTD01());
//					statement.setDouble(91, summaryData.getShipping_MTD02());
//					statement.setDouble(92, summaryData.getShipping_MTD03());
//					statement.setDouble(93, summaryData.getShipping_MTD04());
//					statement.setDouble(94, summaryData.getShipping_G01());
//					statement.setDouble(95, summaryData.getShipping_G02());
//					statement.setDouble(96, summaryData.getShipping_G03());
//					statement.setDouble(97, summaryData.getShipping_G04());
					statement.setString(72, summaryData.getShippingComment());
					statement.setDouble(73, summaryData.getCosts_Y01());
					statement.setDouble(74, summaryData.getCosts_Y02());
					statement.setDouble(75, summaryData.getCosts_MTD01());
					statement.setDouble(76, summaryData.getCosts_MTD02());
					statement.setDouble(77, summaryData.getCosts_G01());
					statement.setDouble(78, summaryData.getCosts_G02());
					statement.setString(79, summaryData.getCostsComment());
					statement.setString(80, summaryData.getSafetyMeetingTopic());
					statement.setString(81, summaryData.getNotes());

					statement.setString(82, summaryData.getMeetingToday());
					statement.setString(83, summaryData.getAttendee());
					statement.setString(84, summaryData.getVisitor());
					statement.setInt(85, summaryData.getId());

					
					return statement;
				}
			});
			key=summaryData.getId();
		}
		
		
		return key;
	}

	/* (non-Javadoc)
	 * @see com.st.pmothers.dao.SummaryDataDao#getDateList(java.util.Date, java.util.Date)
	 */
	@Override
	public List<Map<String, Object>> getDateList(Date sdate, Date edate) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		
		String sql="SELECT  [ID],[Date],[ProductionDate] FROM [dailySummaryData] where ([Date] between ? and ?) order by [ID]";
		
		List<Map<String, Object>> list=jdbcTemplate.queryForList(sql, new Object[]{
			new Timestamp(sdate.getTime()),
			new Timestamp(edate.getTime())
		});
		
		return list;
	}

	/* (non-Javadoc)
	 * @see com.st.pmothers.dao.SummaryDataDao#getSummaryData(int)
	 */
	@Override
	public SummaryData getSummaryData(int id) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		String sql="SELECT  *  FROM [dailySummaryData] where [ID]=? ";
		SummaryData data=jdbcTemplate.queryForObject(sql, new Object[]{id}, new SummaryDataMapper());
		return data;
	}

	/* (non-Javadoc)
	 * @see com.st.pmothers.dao.SummaryDataDao#getMonthToDateData(java.util.Date)
	 */
	@Override
	public SummaryData getMonthToDateData(Date date) {
		SummaryData data=new SummaryData();
		
		
		
		Date sdate=CommonUtil.getFirstDate(date);
		
		Timestamp sTimestamp=new Timestamp(sdate.getTime());
		Timestamp eTimestamp=new Timestamp(date.getTime());
		
		
		
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		
		
		
		//Safety Data
		String sqlSafety="SELECT "
				+ " Nz(sum([Recordable]),0) as [RecordableTotal], "
				+ " Nz(sum([LostTime]),0) as [LostTimeTotal], "
				+ " Nz(sum([FirstAid]),0) as [FirstAidTotal], "
				+ " Nz(sum([NearMiss]),0) as [NearMissTotal] "
				+ " FROM [safetyLogData] "
				+ " where [Date] between ? and ? ";
		List<Map<String, Object>> safetyList=jdbcTemplate.queryForList(sqlSafety,new Object[]{sTimestamp,eTimestamp});
		
		if(safetyList.size()>0){
			Map<String, Object> map=safetyList.get(0);
//			data.setSafety_MTD01(((Number)map.get("RECORDABLETOTAL")).doubleValue());
//			data.setSafety_MTD02(((Number)map.get("LOSTTIMETOTAL")).doubleValue());
			data.setSafety_MTD03(((Number)map.get("FIRSTAIDTOTAL")).doubleValue());
			data.setSafety_MTD04(((Number)map.get("NEARMISSTOTAL")).doubleValue());
		}
		
		
		JdbcTemplate jdbcTemplateP=new JdbcTemplate(dataSourceP);
	
		Calendar scal=Calendar.getInstance();
		scal.setTime(date);
		scal.add(Calendar.HOUR_OF_DAY, 7);
		scal.add(Calendar.MINUTE, 0);
		scal.add(Calendar.SECOND, 0);
		scal.add(Calendar.MILLISECOND, 0);
		
		Calendar ecal=Calendar.getInstance();
		ecal.setTime(date);
		ecal.add(Calendar.HOUR_OF_DAY, 6);
		ecal.add(Calendar.MINUTE, 59);
		ecal.add(Calendar.SECOND, 59);
		ecal.add(Calendar.MILLISECOND, 0);
		ecal.add(Calendar.DATE, 1);
		
		
		String sqlP="SELECT DISTINCT [SetNumber],[Shift]  FROM [tblRewinderProduction]  where  [DateTimeEntered] between ? and ? ";
		
		//System.out.println(sqlP);
		List<Map<String, Object>> maps=jdbcTemplateP.queryForList(sqlP,new Object[]{
				new Timestamp(scal.getTime().getTime()),
				new Timestamp(ecal.getTime().getTime())
		});
		
		int dayCount=0;
		int nightCount=0;
		for (Map<String, Object> map : maps) {
			
			if(map.get("Shift")!=null){
				
				
				if(map.get("Shift").equals("Day")){
					dayCount+=1;
				}else if(map.get("Shift").equals("Night")){
					nightCount+=1;
				}
			}
		}
		
		data.setPaperProd_Y04(dayCount+"/"+nightCount);
		
		
		try {
			String sqlP2="SELECT count(ShippingNumber) FROM tblBillofLadingHeader where [ShippingDate]=?";
			
			int loadCount=jdbcTemplateP.queryForObject(sqlP2, new Object[]{
					new Timestamp(date.getTime())
			},Integer.class);		
			
			data.setShipping_Y01(loadCount);
		} catch (Exception e) {
			logger.error("Daily Summary Report - Error in fetching shipping load count."+e.getMessage());
		}
		
		
		
		Calendar maxCal=Calendar.getInstance();
		maxCal.add(Calendar.DATE, 100);
	
		try {
			String sqlp3="SELECT sum([WhiteWeight])/2000 FROM tblwrapperproduction "
					+ "WHERE [dateentered]<= ?   "
					+ "AND "
					+ "Isnull([dateshipped],?)>?  "
					+ "AND  "
					+ "Round([whiteweight], 2) > 0 ";
			int whiteTons=jdbcTemplateP.queryForObject(sqlp3, new Object[]{
					new Timestamp(date.getTime()),
					new Timestamp(maxCal.getTime().getTime()),
					new Timestamp(date.getTime())
			},Integer.class);
		
			data.setShipping_Y02(whiteTons);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Daily Summary Report - Error in fetching white inventory count."+e.getMessage());
		}
		
		try {
			/*String sqlp3="select count(*)  from [tblWrapperProduction] where [DateTimeEntered] <= ? and [RedWeight]>0 and [DateShipped] is NULL and [WrapperNumber] <> 'ZZZ' ";
			 * */
			String sqlp3="SELECT sum([redweight])/2000 FROM tblwrapperproduction "
					+ "WHERE [dateentered]<= ?   "
					+ "AND "
					+ "Isnull([dateshipped],?)>?  "
					+ "AND  "
					+ "Round([redweight], 2) > 0 ";
			
			int redTons=jdbcTemplateP.queryForObject(sqlp3, new Object[]{
					new Timestamp(date.getTime()),
					new Timestamp(maxCal.getTime().getTime()),
					new Timestamp(date.getTime())
			},Integer.class);
		
			data.setShipping_Y03(redTons);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Daily Summary Report - Error in fetching red inventory count."+e.getMessage());
		}
		
		return data;
	}

	/* (non-Javadoc)
	 * @see com.st.pmothers.dao.SummaryDataDao#delete(int)
	 */
	@Override
	public void delete(int id) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		String sql="delete from [dailySummaryData] where [ID]=?";
		jdbcTemplate.update(sql,new Object[]{id});
		
	}
}

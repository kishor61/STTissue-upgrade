/**
 *Feb 1, 2018
 *CenterlineDaoImpPM5.java
 * TODO
 *com.st.centerlinePM5.dao
 *CenterlineDaoImpPM5.java
 *Roshan Lal Tailor
 */
package com.st.centerlinePM5.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.st.centerline.mapper.CenterlineDataMapper;
import com.st.centerline.model.CenterlineData;
import com.st.centerline.model.CenterlineGrade;
import com.st.centerlinePM5.mapper.CenterlineDataPM5Mapper;
import com.st.centerlinePM5.mapper.CenterlineGradePM5Mapper;

/**
 * @author roshan
 *
 */
@Repository
public class CenterlineDaoImpPM5 implements CenterlineDaoPM5 {

	@Autowired
	private DataSource dataSource;
	/* (non-Javadoc)
	 * @see com.st.centerlinePM5.dao.CenterlineDaoPM5#getCenterlineGrades()
	 */
	@Override
	public List<Map<String, Object>> getCenterlineGrades() {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);

		String sql="select [ID],[Grade] from [centerLineGrade_pm5]";
		
		List<Map<String, Object>> clGrades = jdbcTemplate.queryForList(sql);
		return clGrades;
	}
	/* (non-Javadoc)
	 * @see com.st.centerlinePM5.dao.CenterlineDaoPM5#getCenterlineGradeIds()
	 */
	@Override
	public List<CenterlineGrade> getCenterlineGradeIds() {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		String sql="select [ID],[Grade] from [centerLineGrade_pm5]";
		List<Map<String, Object>> clGrades = jdbcTemplate.queryForList(sql);
		List<CenterlineGrade> centerlineGrades=new ArrayList<>();
		for (Map<String, Object> map : clGrades) {
			if(map!=null){
				CenterlineGrade centerlineGrade=new CenterlineGrade();
				centerlineGrade.setId(Integer.parseInt(map.get("ID").toString()));
				centerlineGrade.setGrade(map.get("Grade").toString());
				centerlineGrades.add(centerlineGrade);
			}
		}
		return centerlineGrades;
	}
	/* (non-Javadoc)
	 * @see com.st.centerlinePM5.dao.CenterlineDaoPM5#getCenterlineGrade(int)
	 */
	@Override
	public CenterlineGrade getCenterlineGrade(int grade) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		
		
		String sql="select * from [centerLineGrade_pm5] where [ID]=? ";
		CenterlineGrade centerlineGrade=jdbcTemplate.queryForObject(sql, new Object[]{grade}, new CenterlineGradePM5Mapper());
	
		return centerlineGrade;
	}
	/* (non-Javadoc)
	 * @see com.st.centerlinePM5.dao.CenterlineDaoPM5#update(com.st.centerline.model.CenterlineGrade)
	 */
	@Override
	public void update(final CenterlineGrade centerlineGrade) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		final String sql="update [centerLineGrade_pm5] SET "
				+ "[Grade]=?,"
				+ "[YankeeSpeedMinC]=?,"
				+ "[YankeeSpeed]=?,"
				+ "[YankeeSpeedMaxC]=?,"
				+ "[QCSBasisWtTargetMinC]=?,"
				+ "[QCSBasisWtTarget]=?,"
				+ "[QCSBasisWtTargetMaxC]=?,"
				+ "[ReelMoistureMinC]=?,"
				+ "[ReelMoisture]=?,"
				+ "[ReelMoistureMaxC]=?,"
				+ "[CrepeMinC]=?,"
				+ "[Crepe]=?,"
				+ "[CrepeMaxC]=?,"
				+ "[YankeeSteamMinC]=?,"
				+ "[YankeeSteam]=?,"
				+ "[YankeeSteamMaxC]=?,"
				+ "[YankeeReleaseMinC]=?,"
				+ "[YankeeRelease]=?,"
				+ "[YankeeReleaseMaxC]=?,"
				+ "[YankeeAdesiveMinC]=?,"
				+ "[YankeeAdesive]=?,"
				+ "[YankeeAdesiveMaxC]=?,"
				+ "[JetWireRatioMinC]=?,"
				+ "[JetWireRatio]=?,"
				+ "[JetWireRatioMaxC]=?,"
				+ "[FanPumpFlowRateMinC]=?,"
				+ "[FanPumpFlowRate]=?,"
				+ "[FanPumpFlowRateMaxC]=?,"
				+ "[AfterDryerSteamMinC]=?,"
				+ "[AfterDryerSteam]=?,"
				+ "[AfterDryerSteamMaxC]=?,"
				+ "[SPRLoadingMinC]=?,"
				+ "[SPRLoading]=?,"
				+ "[SPRLoadingMaxC]=?,"
				+ "[FeltPassivatorMinC]=?,"
				+ "[FeltPassivator]=?,"
				+ "[FeltPassivatorMaxC]=?,"
				+ "[SprayboomPressureMinC]=?,"
				+ "[SprayboomPressure]=?,"
				+ "[SprayboomPressureMaxC]=?,"
				+ "[SprayboomTemparatureMinC]=?,"
				+ "[SprayboomTemparature]=?,"
				+ "[SprayboomTemparatureMaxC]=?,"
				+ "[WEFanSpeedMinC]=?,"
				+ "[WEFanSpeed]=?,"
				+ "[WEFanSpeedMaxC]=?,"
				+ "[DEFanSpeedMinC]=?,"
				+ "[DEFanSpeed]=?,"
				+ "[DEFanSpeedMaxC]=?,"
				+ "[MakeUpAirDamperMinC]=?,"
				+ "[MakeUpAirDamper]=?,"
				+ "[MakeUpAirDamperMaxC]=?,"
				+ "[ExhaustDamperMinC]=?,"
				+ "[ExhaustDamper]=?,"
				+ "[ExhaustDamperMaxC]=?,"
				+ "[ExhaustFanSpeedMinC]=?,"
				+ "[ExhaustFanSpeed]=?,"
				+ "[ExhaustFanSpeedMaxC]=?,"
				+ "[WEHoodTemperatureMinC]=?,"
				+ "[WEHoodTemperature]=?,"
				+ "[WEHoodTemperatureMaxC]=?,"
				+ "[DEHoodTemperatureMinC]=?,"
				+ "[DEHoodTemperature]=?,"
				+ "[DEHoodTemperatureMaxC]=?,"
				+ "[YankeeAPMinC]=?,"
				+ "[YankeeAP]=?,"
				+ "[YankeeAPMaxC]=?,"
				+ "[AfterDryerAPMinC]=?,"
				+ "[AfterDryerAP]=?,"
				+ "[AfterDryerAPMaxC]=?,"
				+ "[SecArmLoadingMinC]=?,"
				+ "[SecArmLoading]=?,"
				+ "[SecArmLoadingMaxC]=?,"
				+ "[ReelOffsetMinC]=?,"
				+ "[ReelOffset]=?,"
				+ "[ReelOffsetMaxC]=?,"
				+ "[UhleBoxNorthValveMinC]=?,"
				+ "[UhleBoxNorthValve]=?,"
				+ "[UhleBoxNorthValveMaxC]=?,"
				+ "[UhleBoxSouthValveMinC]=?,"
				+ "[UhleBoxSouthValve]=?,"
				+ "[UhleBoxSouthValveMaxC]=?,"
				+ "[FaltBox1VacuumValveMinC]=?,"
				+ "[FaltBox1VacuumValve]=?,"
				+ "[FaltBox1VacuumValveMaxC]=?,"
				+ "[FaltBox2VacuumValveMinC]=?,"
				+ "[FaltBox2VacuumValve]=?,"
				+ "[FaltBox2VacuumValveMaxC]=?,"
				+ "[FaltBox4VacuumValveMinC]=?,"
				+ "[FaltBox4VacuumValve]=?,"
				+ "[FaltBox4VacuumValveMaxC]=?,"
				+ "[FanPumpSpeedMinC]=?,"
				+ "[FanPumpSpeed]=?,"
				+ "[FanPumpSpeedMaxC]=?,"
				+ "[TotalHeadMinC]=?,"
				+ "[TotalHead]=?,"
				+ "[TotalHeadMaxC]=?,"
				+ "[HeadboxLevelMinC]=?,"
				+ "[HeadboxLevel]=?,"
				+ "[HeadboxLevelMaxC]=?,"
				+ "[HorizontalSliceMinC]=?,"
				+ "[HorizontalSlice]=?,"
				+ "[HorizontalSliceMaxC]=?,"
				+ "[VerticalSliceMinC]=?,"
				+ "[VerticalSlice]=?,"
				+ "[VerticalSliceMaxC]=?,"
				+ "[SelectifierRejectFlow1MinC]=?,"
				+ "[SelectifierRejectFlow1]=?,"
				+ "[SelectifierRejectFlow1MaxC]=?,"
				+ "[SelectifierRejectFlow2MinC]=?,"
				+ "[SelectifierRejectFlow2]=?,"
				+ "[SelectifierRejectFlow2MaxC]=?,"
				+ "[SecScreenCycleTimeMinC]=?,"
				+ "[SecScreenCycleTime]=?,"
				+ "[SecScreenCycleTimeMaxC]=?,"
				+ "[LowDensityCycleTimeMinC]=?,"
				+ "[LowDensityCycleTime]=?,"
				+ "[LowDensityCycleTimeMaxC]=?,"
				+ "[RefinersEnergyMinC]=?,"
				+ "[RefinersEnergy]=?,"
				+ "[RefinersEnergyMaxC]=?,"
				+ "[NumberOfRefinersMinC]=?,"
				+ "[NumberOfRefiners]=?,"
				+ "[NumberOfRefinersMaxC]=?,"
				+ "[RefinerInletConsistencyMinC]=?,"
				+ "[RefinerInletConsistency]=?,"
				+ "[RefinerInletConsistencyMaxC]=?,"
				+ "[MachineChestConsistencyMinC]=?,"
				+ "[MachineChestConsistency]=?,"
				+ "[MachineChestConsistencyMaxC]=?,"
				+ "[StockFlowMinC]=?,"
				+ "[StockFlow]=?,"
				+ "[StockFlowMaxC]=?,"
				+ "[SweetnerFlowMinC]=?,"
				+ "[SweetnerFlow]=?,"
				+ "[SweetnerFlowMaxC]=?,"
				+ "[BrokeMinC]=?,"
				+ "[Broke]=?,"
				+ "[BrokeMaxC]=?,"
				+ "[WetStrengthMinC]=?,"
				+ "[WetStrength]=?,"
				+ "[WetStrengthMaxC]=?, "
				+ "[IssueDate]=?,"
				+ "[Revision]=?,"
				
				//New Fields
				
				+ "[AfterDryerDrawMinC]=?, "
				+ "[AfterDryerDraw]=?, "
				+ "[AfterDryerDrawMaxC]=?, "
				
				+ "[HorizontalSliceDcsMinC]=?, "
				+ "[HorizontalSliceDcs]=?, "
				+ "[HorizontalSliceDcsMaxC]=?, "
				
				+ "[VerticalSliceDcsMinC]=?, "
				+ "[VerticalSliceDcs]=?, "
				+ "[VerticalSliceDcsMaxC]=?,"
				
				//New Fields Added By Roshan 
				+ "[sprloadingfrontMinC]=?,"
				+ "[sprloadingfront]=?,"
				+ "[sprloadingfrontMaxC]=?,"

				+ "[sprloadingbackMinC]=?,"
				+ "[sprloadingback]=?,"
				+ "[sprloadingbackMaxC]=?,"

				+ "[pickuprollvacuumMinC]=?,"
				+ "[pickuprollvacuum]=?,"
				+ "[pickuprollvacuumMaxC]=?,"

				+ "[uhleboxvacuumMinC]=?,"
				+ "[uhleboxvacuum]=?,"
				+ "[uhleboxvacuumMaxC]=?,"

				+ "[sprvacuumMinC]=?,"
				+ "[sprvacuum]=?,"
				+ "[sprvacuumMaxC]=?,"

				+ "[primaryscreenrejectflowMinC]=?,"
				+ "[primaryscreenrejectflow]=?,"
				+ "[primaryscreenrejectflowMaxC]=?,"

				+ "[blendchestcyMinC]=?,"
				+ "[blendchestcy]=?,"
				+ "[blendchestcyMaxC]=?,"

				+ "[refiner1powerMinC]=?,"
				+ "[refiner1power]=?,"
				+ "[refiner1powerMaxC]=?,"

				+ "[refiner2powerMinC]=?,"
				+ "[refiner2power]=?,"
				+ "[refiner2powerMaxC]=?,"

				+ "[refiner1inletcyMinC]=?,"
				+ "[refiner1inletcy]=?,"
				+ "[refiner1inletcyMaxC]=?,"

				+ "[refiner2inletcyMinC]=?,"
				+ "[refiner2inletcy]=?,"
				+ "[refiner2inletcyMaxC]=?,"
				
				+ "[basisweighttargetMinC]=?,"
				+ "[basisweighttarget]=?,"
				+ "[basisweighttargetMaxC]=?,"
				
				
				+ "[moisturetargetMinC]=?,"
				+ "[moisturetarget]=?,"
				+ "[moisturetargetMaxC]=?,"
				
				+ "[yankeemapflowMinC]=?,"
				+ "[yankeemapflow]=?,"
				+ "[yankeemapflowMaxC]=?,"
				
				+ "[machinechestpumpspeedMinC]=?,"
				+ "[machinechestpumpspeed]=?,"
				+ "[machinechestpumpspeedMaxC]=?"
				
				
				
				
				+ " where [ID]=?";
		
			jdbcTemplate.update(new PreparedStatementCreator() {
				
				@Override
				public PreparedStatement createPreparedStatement(Connection conn)
						throws SQLException {
					
					PreparedStatement statement=conn.prepareStatement(sql);
					
					statement.setString(1, centerlineGrade.getGrade());
					statement.setDouble(2, centerlineGrade.getYankeeSpeedMinC());
					statement.setDouble(3, centerlineGrade.getYankeeSpeed());
					statement.setDouble(4, centerlineGrade.getYankeeSpeedMaxC());
					statement.setDouble(5, centerlineGrade.getQcsBasisWtTargetMinC());
					statement.setDouble(6, centerlineGrade.getQcsBasisWtTarget());
					statement.setDouble(7, centerlineGrade.getQcsBasisWtTargetMaxC());
					statement.setDouble(8, centerlineGrade.getReelMoistureMinC());
					statement.setDouble(9, centerlineGrade.getReelMoisture());
					statement.setDouble(10, centerlineGrade.getReelMoistureMaxC());
					statement.setDouble(11, centerlineGrade.getCrepeMinC());
					statement.setDouble(12, centerlineGrade.getCrepe());
					statement.setDouble(13, centerlineGrade.getCrepeMaxC());
					statement.setDouble(14, centerlineGrade.getYankeeSteamMinC());
					statement.setDouble(15, centerlineGrade.getYankeeSteam());
					statement.setDouble(16, centerlineGrade.getYankeeSteamMaxC());
					statement.setDouble(17, centerlineGrade.getYankeeReleaseMinC());
					statement.setDouble(18, centerlineGrade.getYankeeRelease());
					statement.setDouble(19, centerlineGrade.getYankeeReleaseMaxC());
					statement.setDouble(20, centerlineGrade.getYankeeAdesiveMinC());
					statement.setDouble(21, centerlineGrade.getYankeeAdesive());
					statement.setDouble(22, centerlineGrade.getYankeeAdesiveMaxC());
					statement.setDouble(23, centerlineGrade.getJetWireRatioMinC());
					statement.setDouble(24, centerlineGrade.getJetWireRatio());
					statement.setDouble(25, centerlineGrade.getJetWireRatioMaxC());
					statement.setDouble(26, centerlineGrade.getFanPumpFlowRateMinC());
					statement.setDouble(27, centerlineGrade.getFanPumpFlowRate());
					statement.setDouble(28, centerlineGrade.getFanPumpFlowRateMaxC());
					statement.setDouble(29, centerlineGrade.getAfterDryerSteamMinC());
					statement.setDouble(30, centerlineGrade.getAfterDryerSteam());
					statement.setDouble(31, centerlineGrade.getAfterDryerSteamMaxC());
					statement.setString(32, centerlineGrade.getSprLoadingMinC());
					statement.setString(33, centerlineGrade.getSprLoading());
					statement.setString(34, centerlineGrade.getSprLoadingMaxC());
					statement.setDouble(35, centerlineGrade.getFeltPassivatorMinC());
					statement.setDouble(36, centerlineGrade.getFeltPassivator());
					statement.setDouble(37, centerlineGrade.getFeltPassivatorMaxC());
					statement.setDouble(38, centerlineGrade.getSprayboomPressureMinC());
					statement.setDouble(39, centerlineGrade.getSprayboomPressure());
					statement.setDouble(40, centerlineGrade.getSprayboomPressureMaxC());
					statement.setDouble(41, centerlineGrade.getSprayboomTemparatureMinC());
					statement.setDouble(42, centerlineGrade.getSprayboomTemparature());
					statement.setDouble(43, centerlineGrade.getSprayboomTemparatureMaxC());
					statement.setDouble(44, centerlineGrade.getWefanSpeedMinC());
					statement.setDouble(45, centerlineGrade.getWefanSpeed());
					statement.setDouble(46, centerlineGrade.getWefanSpeedMaxC());
					statement.setDouble(47, centerlineGrade.getDefanSpeedMinC());
					statement.setDouble(48, centerlineGrade.getDefanSpeed());
					statement.setDouble(49, centerlineGrade.getDefanSpeedMaxC());
					statement.setDouble(50, centerlineGrade.getMakeUpAirDamperMinC());
					statement.setDouble(51, centerlineGrade.getMakeUpAirDamper());
					statement.setDouble(52, centerlineGrade.getMakeUpAirDamperMaxC());
					statement.setDouble(53, centerlineGrade.getExhaustDamperMinC());
					statement.setDouble(54, centerlineGrade.getExhaustDamper());
					statement.setDouble(55, centerlineGrade.getExhaustDamperMaxC());
					statement.setDouble(56, centerlineGrade.getExhaustFanSpeedMinC());
					statement.setDouble(57, centerlineGrade.getExhaustFanSpeed());
					statement.setDouble(58, centerlineGrade.getExhaustFanSpeedMaxC());
					statement.setDouble(59, centerlineGrade.getWehoodTemperatureMinC());
					statement.setDouble(60, centerlineGrade.getWehoodTemperature());
					statement.setDouble(61, centerlineGrade.getWehoodTemperatureMaxC());
					statement.setDouble(62, centerlineGrade.getDehoodTemperatureMinC());
					statement.setDouble(63, centerlineGrade.getDehoodTemperature());
					statement.setDouble(64, centerlineGrade.getDehoodTemperatureMaxC());
					statement.setDouble(65, centerlineGrade.getYankeeAPMinC());
					statement.setDouble(66, centerlineGrade.getYankeeAP());
					statement.setDouble(67, centerlineGrade.getYankeeAPMaxC());
					statement.setDouble(68, centerlineGrade.getAfterDryerAPMinC());
					statement.setDouble(69, centerlineGrade.getAfterDryerAP());
					statement.setDouble(70, centerlineGrade.getAfterDryerAPMaxC());
					statement.setDouble(71, centerlineGrade.getSecArmLoadingMinC());
					statement.setDouble(72, centerlineGrade.getSecArmLoading());
					statement.setDouble(73, centerlineGrade.getSecArmLoadingMaxC());
					statement.setDouble(74, centerlineGrade.getReelOffsetMinC());
					statement.setDouble(75, centerlineGrade.getReelOffset());
					statement.setDouble(76, centerlineGrade.getReelOffsetMaxC());
					statement.setDouble(77, centerlineGrade.getUhleBoxNorthValveMinC());
					statement.setDouble(78, centerlineGrade.getUhleBoxNorthValve());
					statement.setDouble(79, centerlineGrade.getUhleBoxNorthValveMaxC());
					statement.setDouble(80, centerlineGrade.getUhleBoxSouthValveMinC());
					statement.setDouble(81, centerlineGrade.getUhleBoxSouthValve());
					statement.setDouble(82, centerlineGrade.getUhleBoxSouthValveMaxC());
					statement.setDouble(83, centerlineGrade.getFaltBox1VacuumValveMinC());
					statement.setDouble(84, centerlineGrade.getFaltBox1VacuumValve());
					statement.setDouble(85, centerlineGrade.getFaltBox1VacuumValveMaxC());
					statement.setDouble(86, centerlineGrade.getFaltBox2VacuumValveMinC());
					statement.setDouble(87, centerlineGrade.getFaltBox2VacuumValve());
					statement.setDouble(88, centerlineGrade.getFaltBox2VacuumValveMaxC());
					statement.setDouble(89, centerlineGrade.getFaltBox4VacuumValveMinC());
					statement.setDouble(90, centerlineGrade.getFaltBox4VacuumValve());
					statement.setDouble(91, centerlineGrade.getFaltBox4VacuumValveMaxC());
					statement.setDouble(92, centerlineGrade.getFanPumpSpeedMinC());
					statement.setDouble(93, centerlineGrade.getFanPumpSpeed());
					statement.setDouble(94, centerlineGrade.getFanPumpSpeedMaxC());
					statement.setDouble(95, centerlineGrade.getTotalHeadMinC());
					statement.setDouble(96, centerlineGrade.getTotalHead());
					statement.setDouble(97, centerlineGrade.getTotalHeadMaxC());
					statement.setDouble(98, centerlineGrade.getHeadboxLevelMinC());
					statement.setDouble(99, centerlineGrade.getHeadboxLevel());
					statement.setDouble(100, centerlineGrade.getHeadboxLevelMaxC());
					statement.setString(101, centerlineGrade.getHorizontalSliceMinC());
					statement.setString(102, centerlineGrade.getHorizontalSlice());
					statement.setString(103, centerlineGrade.getHorizontalSliceMaxC());
					statement.setString(104, centerlineGrade.getVerticalSliceMinC());
					statement.setString(105, centerlineGrade.getVerticalSlice());
					statement.setString(106, centerlineGrade.getVerticalSliceMaxC());
					statement.setDouble(107, centerlineGrade.getSelectifierRejectFlow1MinC());
					statement.setDouble(108, centerlineGrade.getSelectifierRejectFlow1());
					statement.setDouble(109, centerlineGrade.getSelectifierRejectFlow1MaxC());
					statement.setDouble(110, centerlineGrade.getSelectifierRejectFlow2MinC());
					statement.setDouble(111, centerlineGrade.getSelectifierRejectFlow2());
					statement.setDouble(112, centerlineGrade.getSelectifierRejectFlow2MaxC());
					statement.setDouble(113, centerlineGrade.getSecScreenCycleTimeMinC());
					statement.setDouble(114, centerlineGrade.getSecScreenCycleTime());
					statement.setDouble(115, centerlineGrade.getSecScreenCycleTimeMaxC());
					statement.setDouble(116, centerlineGrade.getLowDensityCycleTimeMinC());
					statement.setDouble(117, centerlineGrade.getLowDensityCycleTime());
					statement.setDouble(118, centerlineGrade.getLowDensityCycleTimeMaxC());
					statement.setDouble(119, centerlineGrade.getRefinersEnergyMinC());
					statement.setDouble(120, centerlineGrade.getRefinersEnergy());
					statement.setDouble(121, centerlineGrade.getRefinersEnergyMaxC());
					statement.setDouble(122, centerlineGrade.getNumberOfRefinersMinC());
					statement.setDouble(123, centerlineGrade.getNumberOfRefiners());
					statement.setDouble(124, centerlineGrade.getNumberOfRefinersMaxC());
					statement.setDouble(125, centerlineGrade.getRefinerInletConsistencyMinC());
					statement.setDouble(126, centerlineGrade.getRefinerInletConsistency());
					statement.setDouble(127, centerlineGrade.getRefinerInletConsistencyMaxC());
					statement.setDouble(128, centerlineGrade.getMachineChestConsistencyMinC());
					statement.setDouble(129, centerlineGrade.getMachineChestConsistency());
					statement.setDouble(130, centerlineGrade.getMachineChestConsistencyMaxC());
					statement.setDouble(131, centerlineGrade.getStockFlowMinC());
					statement.setDouble(132, centerlineGrade.getStockFlow());
					statement.setDouble(133, centerlineGrade.getStockFlowMaxC());
					statement.setDouble(134, centerlineGrade.getSweetnerFlowMinC());
					statement.setDouble(135, centerlineGrade.getSweetnerFlow());
					statement.setDouble(136, centerlineGrade.getSweetnerFlowMaxC());
					statement.setDouble(137, centerlineGrade.getBrokeMinC());
					statement.setDouble(138, centerlineGrade.getBroke());
					statement.setDouble(139, centerlineGrade.getBrokeMaxC());
					statement.setDouble(140, centerlineGrade.getWetStrengthMinC());
					statement.setDouble(141, centerlineGrade.getWetStrength());
					statement.setDouble(142, centerlineGrade.getWetStrengthMaxC());
					if(centerlineGrade.getIssueDate()==null){
						statement.setNull(143,Types.DATE);	
					}else{
						statement.setDate(143,new Date(centerlineGrade.getIssueDate().getTime()));
					}
					statement.setString(144, centerlineGrade.getRevision());
					
					
					//New Fields
					statement.setDouble(145, centerlineGrade.getAfterDryerDrawMinC());
					statement.setDouble(146, centerlineGrade.getAfterDryerDraw());
					statement.setDouble(147, centerlineGrade.getAfterDryerDrawMaxC());
					
					statement.setString(148, centerlineGrade.getHorizontalSliceDcsMinC());
					statement.setString(149, centerlineGrade.getHorizontalSliceDcs());
					statement.setString(150, centerlineGrade.getHorizontalSliceDcsMaxC());
					

					statement.setString(151, centerlineGrade.getVerticalSliceDcsMinC());
					statement.setString(152, centerlineGrade.getVerticalSliceDcs());
					statement.setString(153, centerlineGrade.getVerticalSliceDcsMaxC());
					
					statement.setDouble(154, centerlineGrade.getSprloadingfrontMinC());
					statement.setDouble(155, centerlineGrade.getSprloadingfront());
					statement.setDouble(156, centerlineGrade.getSprloadingfrontMaxC());
					statement.setDouble(157, centerlineGrade.getSprloadingbackMinC());
					statement.setDouble(158, centerlineGrade.getSprloadingback());
					statement.setDouble(159, centerlineGrade.getSprloadingbackMaxC());
					statement.setDouble(160, centerlineGrade.getPickuprollvacuumMinC());
					statement.setDouble(161, centerlineGrade.getPickuprollvacuum());
					statement.setDouble(162, centerlineGrade.getPickuprollvacuumMaxC());
					statement.setDouble(163, centerlineGrade.getUhleboxvacuumMinC());
					
					statement.setDouble(164, centerlineGrade.getUhleboxvacuum());
					statement.setDouble(165, centerlineGrade.getUhleboxvacuumMaxC());
					statement.setDouble(166, centerlineGrade.getSprvacuumMinC());
					statement.setDouble(167, centerlineGrade.getSprvacuum());
					statement.setDouble(168, centerlineGrade.getSprvacuumMaxC());
					statement.setDouble(169, centerlineGrade.getPrimaryscreenrejectflowMinC());
					statement.setDouble(170, centerlineGrade.getPrimaryscreenrejectflow());
					statement.setDouble(171, centerlineGrade.getPrimaryscreenrejectflowMaxC());
					statement.setDouble(172, centerlineGrade.getBlendchestcyMinC());
					statement.setDouble(173, centerlineGrade.getBlendchestcy());
					
					statement.setDouble(174, centerlineGrade.getBlendchestcyMaxC());
					statement.setDouble(175, centerlineGrade.getRefiner1powerMinC());
					statement.setDouble(176, centerlineGrade.getRefiner1power());
					statement.setDouble(177, centerlineGrade.getRefiner1powerMaxC());
					statement.setDouble(178, centerlineGrade.getRefiner2powerMinC());
					statement.setDouble(179, centerlineGrade.getRefiner2power());
					statement.setDouble(180, centerlineGrade.getRefiner2powerMaxC());
					statement.setDouble(181, centerlineGrade.getRefiner1inletcyMinC());
					statement.setDouble(182, centerlineGrade.getRefiner1inletcy());
					statement.setDouble(183, centerlineGrade.getRefiner1inletcyMaxC());
					
					
					statement.setDouble(184, centerlineGrade.getRefiner2inletcyMinC());
					statement.setDouble(185, centerlineGrade.getRefiner2inletcy());
					statement.setDouble(186, centerlineGrade.getRefiner2inletcyMaxC());
					
					//More New Fields Are Added Here
					
					statement.setDouble(187, centerlineGrade.getBasisweighttargetMinC());
					statement.setDouble(188, centerlineGrade.getBasisweighttarget());
					statement.setDouble(189, centerlineGrade.getBasisweighttargetMaxC());
					
					
					statement.setDouble(190, centerlineGrade.getMoisturetargetMinC());
					statement.setDouble(191, centerlineGrade.getMoisturetarget());
					statement.setDouble(192, centerlineGrade.getMoisturetargetMaxC());
					
					statement.setDouble(193, centerlineGrade.getYankeemapflowMinC());
					statement.setDouble(194, centerlineGrade.getYankeemapflow());
					statement.setDouble(195, centerlineGrade.getYankeemapflowMaxC());
					
					
					statement.setDouble(196, centerlineGrade.getMachinechestpumpspeedMinC());
					statement.setDouble(197, centerlineGrade.getMachinechestpumpspeed());
					statement.setDouble(198, centerlineGrade.getMachinechestpumpspeedMaxC());
					
					
					statement.setInt(199, centerlineGrade.getId());
					
					return statement;
				}
			});
	}
	/* (non-Javadoc)
	 * @see com.st.centerlinePM5.dao.CenterlineDaoPM5#save(com.st.centerline.model.CenterlineGrade)
	 */
	@Override
	public int save(final CenterlineGrade centerlineGrade) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		KeyHolder holder=new GeneratedKeyHolder();
		final String sql="insert into [centerLineGrade_pm5]"
				+ "("
				+ "[Grade],"
				+ "[YankeeSpeedMinC],"
				+ "[YankeeSpeed],"
				+ "[YankeeSpeedMaxC],"
				+ "[QCSBasisWtTargetMinC],"
				+ "[QCSBasisWtTarget],"
				+ "[QCSBasisWtTargetMaxC],"
				+ "[ReelMoistureMinC],"
				+ "[ReelMoisture],"
				+ "[ReelMoistureMaxC],"
				+ "[CrepeMinC],"
				+ "[Crepe],"
				+ "[CrepeMaxC],"
				+ "[YankeeSteamMinC],"
				+ "[YankeeSteam],"
				+ "[YankeeSteamMaxC],"
				+ "[YankeeReleaseMinC],"
				+ "[YankeeRelease],"
				+ "[YankeeReleaseMaxC],"
				+ "[YankeeAdesiveMinC],"
				+ "[YankeeAdesive],"
				+ "[YankeeAdesiveMaxC],"
				+ "[JetWireRatioMinC],"
				+ "[JetWireRatio],"
				+ "[JetWireRatioMaxC],"
				+ "[FanPumpFlowRateMinC],"
				+ "[FanPumpFlowRate],"
				+ "[FanPumpFlowRateMaxC],"
				+ "[AfterDryerSteamMinC],"
				+ "[AfterDryerSteam],"
				+ "[AfterDryerSteamMaxC],"
				+ "[SPRLoadingMinC],"
				+ "[SPRLoading],"
				+ "[SPRLoadingMaxC],"
				+ "[FeltPassivatorMinC],"
				+ "[FeltPassivator],"
				+ "[FeltPassivatorMaxC],"
				+ "[SprayboomPressureMinC],"
				+ "[SprayboomPressure],"
				+ "[SprayboomPressureMaxC],"
				+ "[SprayboomTemparatureMinC],"
				+ "[SprayboomTemparature],"
				+ "[SprayboomTemparatureMaxC],"
				+ "[WEFanSpeedMinC],"
				+ "[WEFanSpeed],"
				+ "[WEFanSpeedMaxC],"
				+ "[DEFanSpeedMinC],"
				+ "[DEFanSpeed],"
				+ "[DEFanSpeedMaxC],"
				+ "[MakeUpAirDamperMinC],"
				+ "[MakeUpAirDamper],"
				+ "[MakeUpAirDamperMaxC],"
				+ "[ExhaustDamperMinC],"
				+ "[ExhaustDamper],"
				+ "[ExhaustDamperMaxC],"
				+ "[ExhaustFanSpeedMinC],"
				+ "[ExhaustFanSpeed],"
				+ "[ExhaustFanSpeedMaxC],"
				+ "[WEHoodTemperatureMinC],"
				+ "[WEHoodTemperature],"
				+ "[WEHoodTemperatureMaxC],"
				+ "[DEHoodTemperatureMinC],"
				+ "[DEHoodTemperature],"
				+ "[DEHoodTemperatureMaxC],"
				+ "[YankeeAPMinC],"
				+ "[YankeeAP],"
				+ "[YankeeAPMaxC],"
				+ "[AfterDryerAPMinC],"
				+ "[AfterDryerAP],"
				+ "[AfterDryerAPMaxC],"
				+ "[SecArmLoadingMinC],"
				+ "[SecArmLoading],"
				+ "[SecArmLoadingMaxC],"
				+ "[ReelOffsetMinC],"
				+ "[ReelOffset],"
				+ "[ReelOffsetMaxC],"
				+ "[UhleBoxNorthValveMinC],"
				+ "[UhleBoxNorthValve],"
				+ "[UhleBoxNorthValveMaxC],"
				+ "[UhleBoxSouthValveMinC],"
				+ "[UhleBoxSouthValve],"
				+ "[UhleBoxSouthValveMaxC],"
				+ "[FaltBox1VacuumValveMinC],"
				+ "[FaltBox1VacuumValve],"
				+ "[FaltBox1VacuumValveMaxC],"
				+ "[FaltBox2VacuumValveMinC],"
				+ "[FaltBox2VacuumValve],"
				+ "[FaltBox2VacuumValveMaxC],"
				+ "[FaltBox4VacuumValveMinC],"
				+ "[FaltBox4VacuumValve],"
				+ "[FaltBox4VacuumValveMaxC],"
				+ "[FanPumpSpeedMinC],"
				+ "[FanPumpSpeed],"
				+ "[FanPumpSpeedMaxC],"
				+ "[TotalHeadMinC],"
				+ "[TotalHead],"
				+ "[TotalHeadMaxC],"
				+ "[HeadboxLevelMinC],"
				+ "[HeadboxLevel],"
				+ "[HeadboxLevelMaxC],"
				+ "[HorizontalSliceMinC],"
				+ "[HorizontalSlice],"
				+ "[HorizontalSliceMaxC],"
				+ "[VerticalSliceMinC],"
				+ "[VerticalSlice],"
				+ "[VerticalSliceMaxC],"
				+ "[SelectifierRejectFlow1MinC],"
				+ "[SelectifierRejectFlow1],"
				+ "[SelectifierRejectFlow1MaxC],"
				+ "[SelectifierRejectFlow2MinC],"
				+ "[SelectifierRejectFlow2],"
				+ "[SelectifierRejectFlow2MaxC],"
				+ "[SecScreenCycleTimeMinC],"
				+ "[SecScreenCycleTime],"
				+ "[SecScreenCycleTimeMaxC],"
				+ "[LowDensityCycleTimeMinC],"
				+ "[LowDensityCycleTime],"
				+ "[LowDensityCycleTimeMaxC],"
				+ "[RefinersEnergyMinC],"
				+ "[RefinersEnergy],"
				+ "[RefinersEnergyMaxC],"
				+ "[NumberOfRefinersMinC],"
				+ "[NumberOfRefiners],"
				+ "[NumberOfRefinersMaxC],"
				+ "[RefinerInletConsistencyMinC],"
				+ "[RefinerInletConsistency],"
				+ "[RefinerInletConsistencyMaxC],"
				+ "[MachineChestConsistencyMinC],"
				+ "[MachineChestConsistency],"
				+ "[MachineChestConsistencyMaxC],"
				+ "[StockFlowMinC],"
				+ "[StockFlow],"
				+ "[StockFlowMaxC],"
				+ "[SweetnerFlowMinC],"
				+ "[SweetnerFlow],"
				+ "[SweetnerFlowMaxC],"
				+ "[BrokeMinC],"
				+ "[Broke],"
				+ "[BrokeMaxC],"
				+ "[WetStrengthMinC],"
				+ "[WetStrength],"
				+ "[WetStrengthMaxC],"
				+ "[IssueDate],"
				+ "[Revision],"
				
				+ "[AfterDryerDrawMinC],"
				+ "[AfterDryerDraw],"
				+ "[AfterDryerDrawMaxC],"
				
				+ "[HorizontalSliceDcsMinC],"
				+ "[HorizontalSliceDcs],"
				+ "[HorizontalSliceDcsMaxC],"
				
				+ "[VerticalSliceDcsMinC],"
				+ "[VerticalSliceDcs],"
				+ "[VerticalSliceDcsMaxC],"
				
				
				+ "[sprloadingfrontMinC],"
				+ "[sprloadingfront],"
				+ "[sprloadingfrontMaxC],"

				+ "[sprloadingbackMinC],"
				+ "[sprloadingback],"
				+ "[sprloadingbackMaxC],"

				+ "[pickuprollvacuumMinC],"
				+ "[pickuprollvacuum],"
				+ "[pickuprollvacuumMaxC],"

				+ "[uhleboxvacuumMinC],"
				+ "[uhleboxvacuum],"
				+ "[uhleboxvacuumMaxC],"

				+ "[sprvacuumMinC],"
				+ "[sprvacuum],"
				+ "[sprvacuumMaxC],"

				+ "[primaryscreenrejectflowMinC],"
				+ "[primaryscreenrejectflow],"
				+ "[primaryscreenrejectflowMaxC],"

				+ "[blendchestcyMinC],"
				+ "[blendchestcy],"
				+ "[blendchestcyMaxC],"

				+ "[refiner1powerMinC],"
				+ "[refiner1power],"
				+ "[refiner1powerMaxC],"

				+ "[refiner2powerMinC],"
				+ "[refiner2power],"
				+ "[refiner2powerMaxC],"

				+ "[refiner1inletcyMinC],"
				+ "[refiner1inletcy],"
				+ "[refiner1inletcyMaxC],"

				+ "[refiner2inletcyMinC],"
				+ "[refiner2inletcy],"
				+ "[refiner2inletcyMaxC],"
				
				+ "[basisweighttargetMinC],"
				+ "[basisweighttarget],"
				+ "[basisweighttargetMaxC],"
				
				
				+ "[moisturetargetMinC],"
				+ "[moisturetarget],"
				+ "[moisturetargetMaxC],"
				
				
								
				+ "[yankeemapflowMinC],"
				+ "[yankeemapflow],"
				+ "[yankeemapflowMaxC],"
				
				
				+ "[machinechestpumpspeedMinC],"
				+ "[machinechestpumpspeed],"
				+ "[machinechestpumpspeedMaxC]"


				
				+ ") "
				+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,"
				+ "?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,"
				+ "?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?"
				+ ",?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,"
				+ "?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,"
				+ "?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,"
				+ "?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,"
				+ "?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,"
				+ "?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		
		jdbcTemplate.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection conn)
					throws SQLException {
				PreparedStatement statement=conn.prepareStatement(sql,new String[]{"ID"});
				statement.setString(1, centerlineGrade.getGrade());
				statement.setDouble(2, centerlineGrade.getYankeeSpeedMinC());
				statement.setDouble(3, centerlineGrade.getYankeeSpeed());
				statement.setDouble(4, centerlineGrade.getYankeeSpeedMaxC());
				statement.setDouble(5, centerlineGrade.getQcsBasisWtTargetMinC());
				statement.setDouble(6, centerlineGrade.getQcsBasisWtTarget());
				statement.setDouble(7, centerlineGrade.getQcsBasisWtTargetMaxC());
				statement.setDouble(8, centerlineGrade.getReelMoistureMinC());
				statement.setDouble(9, centerlineGrade.getReelMoisture());
				statement.setDouble(10, centerlineGrade.getReelMoistureMaxC());
				statement.setDouble(11, centerlineGrade.getCrepeMinC());
				statement.setDouble(12, centerlineGrade.getCrepe());
				statement.setDouble(13, centerlineGrade.getCrepeMaxC());
				statement.setDouble(14, centerlineGrade.getYankeeSteamMinC());
				statement.setDouble(15, centerlineGrade.getYankeeSteam());
				statement.setDouble(16, centerlineGrade.getYankeeSteamMaxC());
				statement.setDouble(17, centerlineGrade.getYankeeReleaseMinC());
				statement.setDouble(18, centerlineGrade.getYankeeRelease());
				statement.setDouble(19, centerlineGrade.getYankeeReleaseMaxC());
				statement.setDouble(20, centerlineGrade.getYankeeAdesiveMinC());
				statement.setDouble(21, centerlineGrade.getYankeeAdesive());
				statement.setDouble(22, centerlineGrade.getYankeeAdesiveMaxC());
				statement.setDouble(23, centerlineGrade.getJetWireRatioMinC());
				statement.setDouble(24, centerlineGrade.getJetWireRatio());
				statement.setDouble(25, centerlineGrade.getJetWireRatioMaxC());
				statement.setDouble(26, centerlineGrade.getFanPumpFlowRateMinC());
				statement.setDouble(27, centerlineGrade.getFanPumpFlowRate());
				statement.setDouble(28, centerlineGrade.getFanPumpFlowRateMaxC());
				statement.setDouble(29, centerlineGrade.getAfterDryerSteamMinC());
				statement.setDouble(30, centerlineGrade.getAfterDryerSteam());
				statement.setDouble(31, centerlineGrade.getAfterDryerSteamMaxC());
				statement.setString(32, centerlineGrade.getSprLoadingMinC());
				statement.setString(33, centerlineGrade.getSprLoading());
				statement.setString(34, centerlineGrade.getSprLoadingMaxC());
				statement.setDouble(35, centerlineGrade.getFeltPassivatorMinC());
				statement.setDouble(36, centerlineGrade.getFeltPassivator());
				statement.setDouble(37, centerlineGrade.getFeltPassivatorMaxC());
				statement.setDouble(38, centerlineGrade.getSprayboomPressureMinC());
				statement.setDouble(39, centerlineGrade.getSprayboomPressure());
				statement.setDouble(40, centerlineGrade.getSprayboomPressureMaxC());
				statement.setDouble(41, centerlineGrade.getSprayboomTemparatureMinC());
				statement.setDouble(42, centerlineGrade.getSprayboomTemparature());
				statement.setDouble(43, centerlineGrade.getSprayboomTemparatureMaxC());
				statement.setDouble(44, centerlineGrade.getWefanSpeedMinC());
				statement.setDouble(45, centerlineGrade.getWefanSpeed());
				statement.setDouble(46, centerlineGrade.getWefanSpeedMaxC());
				statement.setDouble(47, centerlineGrade.getDefanSpeedMinC());
				statement.setDouble(48, centerlineGrade.getDefanSpeed());
				statement.setDouble(49, centerlineGrade.getDefanSpeedMaxC());
				statement.setDouble(50, centerlineGrade.getMakeUpAirDamperMinC());
				statement.setDouble(51, centerlineGrade.getMakeUpAirDamper());
				statement.setDouble(52, centerlineGrade.getMakeUpAirDamperMaxC());
				statement.setDouble(53, centerlineGrade.getExhaustDamperMinC());
				statement.setDouble(54, centerlineGrade.getExhaustDamper());
				statement.setDouble(55, centerlineGrade.getExhaustDamperMaxC());
				statement.setDouble(56, centerlineGrade.getExhaustFanSpeedMinC());
				statement.setDouble(57, centerlineGrade.getExhaustFanSpeed());
				statement.setDouble(58, centerlineGrade.getExhaustFanSpeedMaxC());
				statement.setDouble(59, centerlineGrade.getWehoodTemperatureMinC());
				statement.setDouble(60, centerlineGrade.getWehoodTemperature());
				statement.setDouble(61, centerlineGrade.getWehoodTemperatureMaxC());
				statement.setDouble(62, centerlineGrade.getDehoodTemperatureMinC());
				statement.setDouble(63, centerlineGrade.getDehoodTemperature());
				statement.setDouble(64, centerlineGrade.getDehoodTemperatureMaxC());
				statement.setDouble(65, centerlineGrade.getYankeeAPMinC());
				statement.setDouble(66, centerlineGrade.getYankeeAP());
				statement.setDouble(67, centerlineGrade.getYankeeAPMaxC());
				statement.setDouble(68, centerlineGrade.getAfterDryerAPMinC());
				statement.setDouble(69, centerlineGrade.getAfterDryerAP());
				statement.setDouble(70, centerlineGrade.getAfterDryerAPMaxC());
				statement.setDouble(71, centerlineGrade.getSecArmLoadingMinC());
				statement.setDouble(72, centerlineGrade.getSecArmLoading());
				statement.setDouble(73, centerlineGrade.getSecArmLoadingMaxC());
				statement.setDouble(74, centerlineGrade.getReelOffsetMinC());
				statement.setDouble(75, centerlineGrade.getReelOffset());
				statement.setDouble(76, centerlineGrade.getReelOffsetMaxC());
				statement.setDouble(77, centerlineGrade.getUhleBoxNorthValveMinC());
				statement.setDouble(78, centerlineGrade.getUhleBoxNorthValve());
				statement.setDouble(79, centerlineGrade.getUhleBoxNorthValveMaxC());
				statement.setDouble(80, centerlineGrade.getUhleBoxSouthValveMinC());
				statement.setDouble(81, centerlineGrade.getUhleBoxSouthValve());
				statement.setDouble(82, centerlineGrade.getUhleBoxSouthValveMaxC());
				statement.setDouble(83, centerlineGrade.getFaltBox1VacuumValveMinC());
				statement.setDouble(84, centerlineGrade.getFaltBox1VacuumValve());
				statement.setDouble(85, centerlineGrade.getFaltBox1VacuumValveMaxC());
				statement.setDouble(86, centerlineGrade.getFaltBox2VacuumValveMinC());
				statement.setDouble(87, centerlineGrade.getFaltBox2VacuumValve());
				statement.setDouble(88, centerlineGrade.getFaltBox2VacuumValveMaxC());
				statement.setDouble(89, centerlineGrade.getFaltBox4VacuumValveMinC());
				statement.setDouble(90, centerlineGrade.getFaltBox4VacuumValve());
				statement.setDouble(91, centerlineGrade.getFaltBox4VacuumValveMaxC());
				statement.setDouble(92, centerlineGrade.getFanPumpSpeedMinC());
				statement.setDouble(93, centerlineGrade.getFanPumpSpeed());
				statement.setDouble(94, centerlineGrade.getFanPumpSpeedMaxC());
				statement.setDouble(95, centerlineGrade.getTotalHeadMinC());
				statement.setDouble(96, centerlineGrade.getTotalHead());
				statement.setDouble(97, centerlineGrade.getTotalHeadMaxC());
				statement.setDouble(98, centerlineGrade.getHeadboxLevelMinC());
				statement.setDouble(99, centerlineGrade.getHeadboxLevel());
				statement.setDouble(100, centerlineGrade.getHeadboxLevelMaxC());
				statement.setString(101, centerlineGrade.getHorizontalSliceMinC());
				statement.setString(102, centerlineGrade.getHorizontalSlice());
				statement.setString(103, centerlineGrade.getHorizontalSliceMaxC());
				statement.setString(104, centerlineGrade.getVerticalSliceMinC());
				statement.setString(105, centerlineGrade.getVerticalSlice());
				statement.setString(106, centerlineGrade.getVerticalSliceMaxC());
				statement.setDouble(107, centerlineGrade.getSelectifierRejectFlow1MinC());
				statement.setDouble(108, centerlineGrade.getSelectifierRejectFlow1());
				statement.setDouble(109, centerlineGrade.getSelectifierRejectFlow1MaxC());
				statement.setDouble(110, centerlineGrade.getSelectifierRejectFlow2MinC());
				statement.setDouble(111, centerlineGrade.getSelectifierRejectFlow2());
				statement.setDouble(112, centerlineGrade.getSelectifierRejectFlow2MaxC());
				statement.setDouble(113, centerlineGrade.getSecScreenCycleTimeMinC());
				statement.setDouble(114, centerlineGrade.getSecScreenCycleTime());
				statement.setDouble(115, centerlineGrade.getSecScreenCycleTimeMaxC());
				statement.setDouble(116, centerlineGrade.getLowDensityCycleTimeMinC());
				statement.setDouble(117, centerlineGrade.getLowDensityCycleTime());
				statement.setDouble(118, centerlineGrade.getLowDensityCycleTimeMaxC());
				statement.setDouble(119, centerlineGrade.getRefinersEnergyMinC());
				statement.setDouble(120, centerlineGrade.getRefinersEnergy());
				statement.setDouble(121, centerlineGrade.getRefinersEnergyMaxC());
				statement.setDouble(122, centerlineGrade.getNumberOfRefinersMinC());
				statement.setDouble(123, centerlineGrade.getNumberOfRefiners());
				statement.setDouble(124, centerlineGrade.getNumberOfRefinersMaxC());
				statement.setDouble(125, centerlineGrade.getRefinerInletConsistencyMinC());
				statement.setDouble(126, centerlineGrade.getRefinerInletConsistency());
				statement.setDouble(127, centerlineGrade.getRefinerInletConsistencyMaxC());
				statement.setDouble(128, centerlineGrade.getMachineChestConsistencyMinC());
				statement.setDouble(129, centerlineGrade.getMachineChestConsistency());
				statement.setDouble(130, centerlineGrade.getMachineChestConsistencyMaxC());
				statement.setDouble(131, centerlineGrade.getStockFlowMinC());
				statement.setDouble(132, centerlineGrade.getStockFlow());
				statement.setDouble(133, centerlineGrade.getStockFlowMaxC());
				statement.setDouble(134, centerlineGrade.getSweetnerFlowMinC());
				statement.setDouble(135, centerlineGrade.getSweetnerFlow());
				statement.setDouble(136, centerlineGrade.getSweetnerFlowMaxC());
				statement.setDouble(137, centerlineGrade.getBrokeMinC());
				statement.setDouble(138, centerlineGrade.getBroke());
				statement.setDouble(139, centerlineGrade.getBrokeMaxC());
				statement.setDouble(140, centerlineGrade.getWetStrengthMinC());
				statement.setDouble(141, centerlineGrade.getWetStrength());
				statement.setDouble(142, centerlineGrade.getWetStrengthMaxC());
				if(centerlineGrade.getIssueDate()==null){
					statement.setNull(143,Types.DATE);	
				}else{
					statement.setDate(143,new Date(centerlineGrade.getIssueDate().getTime()));
				}
				statement.setString(144, centerlineGrade.getRevision());
				
				//New Fields
				statement.setDouble(145, centerlineGrade.getAfterDryerDrawMinC());
				statement.setDouble(146, centerlineGrade.getAfterDryerDraw());
				statement.setDouble(147, centerlineGrade.getAfterDryerDrawMaxC());
				
				statement.setString(148, centerlineGrade.getHorizontalSliceDcsMinC());
				statement.setString(149, centerlineGrade.getHorizontalSliceDcs());
				statement.setString(150, centerlineGrade.getHorizontalSliceDcsMaxC());
				

				statement.setString(151, centerlineGrade.getVerticalSliceDcsMinC());
				statement.setString(152, centerlineGrade.getVerticalSliceDcs());
				statement.setString(153, centerlineGrade.getVerticalSliceDcsMaxC());
//New Fields Added Here By Roshan  Tailor
				statement.setDouble(154, centerlineGrade.getSprloadingfrontMinC());
				statement.setDouble(155, centerlineGrade.getSprloadingfront());
				statement.setDouble(156, centerlineGrade.getSprloadingfrontMaxC());
				statement.setDouble(157, centerlineGrade.getSprloadingbackMinC());
				statement.setDouble(158, centerlineGrade.getSprloadingback());
				statement.setDouble(159, centerlineGrade.getSprloadingbackMaxC());
				statement.setDouble(160, centerlineGrade.getPickuprollvacuumMinC());
				statement.setDouble(161, centerlineGrade.getPickuprollvacuum());
				statement.setDouble(162, centerlineGrade.getPickuprollvacuumMaxC());
				statement.setDouble(163, centerlineGrade.getUhleboxvacuumMinC());
				
				statement.setDouble(164, centerlineGrade.getUhleboxvacuum());
				statement.setDouble(165, centerlineGrade.getUhleboxvacuumMaxC());
				statement.setDouble(166, centerlineGrade.getSprvacuumMinC());
				statement.setDouble(167, centerlineGrade.getSprvacuum());
				statement.setDouble(168, centerlineGrade.getSprvacuumMaxC());
				statement.setDouble(169, centerlineGrade.getPrimaryscreenrejectflowMinC());
				statement.setDouble(170, centerlineGrade.getPrimaryscreenrejectflow());
				statement.setDouble(171, centerlineGrade.getPrimaryscreenrejectflowMaxC());
				statement.setDouble(172, centerlineGrade.getBlendchestcyMinC());
				statement.setDouble(173, centerlineGrade.getBlendchestcy());
				
				statement.setDouble(174, centerlineGrade.getBlendchestcyMaxC());
				statement.setDouble(175, centerlineGrade.getRefiner1powerMinC());
				statement.setDouble(176, centerlineGrade.getRefiner1power());
				statement.setDouble(177, centerlineGrade.getRefiner1powerMaxC());
				statement.setDouble(178, centerlineGrade.getRefiner2powerMinC());
				statement.setDouble(179, centerlineGrade.getRefiner2power());
				statement.setDouble(180, centerlineGrade.getRefiner2powerMaxC());
				statement.setDouble(181, centerlineGrade.getRefiner1inletcyMinC());
				statement.setDouble(182, centerlineGrade.getRefiner1inletcy());
				statement.setDouble(183, centerlineGrade.getRefiner1inletcyMaxC());
				
				
				statement.setDouble(184, centerlineGrade.getRefiner2inletcyMinC());
				statement.setDouble(185, centerlineGrade.getRefiner2inletcy());
				statement.setDouble(186, centerlineGrade.getRefiner2inletcyMaxC());
				
				//New More Fields Are Added Here
				
				statement.setDouble(187, centerlineGrade.getBasisweighttargetMinC());
				statement.setDouble(188, centerlineGrade.getBasisweighttarget());
				statement.setDouble(189, centerlineGrade.getBasisweighttargetMaxC());
				
				statement.setDouble(190, centerlineGrade.getMoisturetargetMinC());
				statement.setDouble(191, centerlineGrade.getMoisturetarget());
				statement.setDouble(192, centerlineGrade.getMoisturetargetMaxC());
				
				statement.setDouble(193, centerlineGrade.getYankeemapflowMinC());
				statement.setDouble(194, centerlineGrade.getYankeemapflow());
				statement.setDouble(195, centerlineGrade.getYankeemapflowMaxC());
				
				statement.setDouble(196, centerlineGrade.getMachinechestpumpspeedMinC());
				statement.setDouble(197, centerlineGrade.getMachinechestpumpspeed());
				statement.setDouble(198, centerlineGrade.getMachinechestpumpspeedMaxC());
				
				
				
				//Fields Ends Here
				return statement;
			}
		},holder);
		
		return holder.getKey().intValue();
	}
	/* (non-Javadoc)
	 * @see com.st.centerlinePM5.dao.CenterlineDaoPM5#getCenterlineData(int)
	 */
	@Override
	public CenterlineData getCenterlineData(int id) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		
		String sql="select * from [centerLineData_pm5] where [ID]=? ";
		CenterlineData centerlineData=jdbcTemplate.queryForObject(sql, new Object[]{id}, new CenterlineDataPM5Mapper());
	
		return centerlineData;
	}
	/* (non-Javadoc)
	 * @see com.st.centerlinePM5.dao.CenterlineDaoPM5#save(com.st.centerline.model.CenterlineData)
	 */
	@Override
	public int save(final CenterlineData centerlineData) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		KeyHolder keyHolder=new GeneratedKeyHolder();
		final String sql="insert into [centerLineData_pm5] "
				+ "("
				+ "[GradeID],"
				+ "[Crew],"
				+ "[Shift],"
				+ "[YankeeSpeed],"
				+ "[QCSBasisWtTarget],"
				+ "[ReelMoisture],"
				+ "[Crepe],"
				+ "[YankeeSteam],"
				+ "[YankeeRelease],"
				+ "[YankeeAdesive],"
				+ "[JetWireRatio],"
				+ "[FanPumpFlowRate],"
				+ "[AfterDryerSteam],"
				+ "[SPRLoading],"
				+ "[FeltPassivator],"
				+ "[SprayboomPressure],"
				+ "[SprayboomTemparature],"
				+ "[WEFanSpeed],"
				+ "[DEFanSpeed],"
				+ "[MakeUpAirDamper],"
				+ "[ExhaustDamper],"
				+ "[ExhaustFanSpeed],"
				+ "[WEHoodTemperature],"
				+ "[DEHoodTemperature],"
				+ "[YankeeAP],"
				+ "[AfterDryerAP],"
				+ "[SecArmLoading],"
				+ "[ReelOffset],"
				+ "[UhleBoxNorthValve],"
				+ "[UhleBoxSouthValve],"
				+ "[FaltBox1VacuumValve],"
				+ "[FaltBox2VacuumValve],"
				+ "[FaltBox4VacuumValve],"
				+ "[FanPumpSpeed],"
				+ "[TotalHead],"
				+ "[HeadboxLevel],"
				+ "[HorizontalSlice],"
				+ "[VerticalSlice],"
				+ "[SelectifierRejectFlow1],"
				+ "[SelectifierRejectFlow2],"
				+ "[SecScreenCycleTime],"
				+ "[LowDensityCycleTime],"
				+ "[RefinersEnergy],"
				+ "[NumberOfRefiners],"
				+ "[RefinerInletConsistency],"
				+ "[MachineChestConsistency],"
				+ "[StockFlow],"
				+ "[SweetnerFlow],"
				+ "[Broke],"
				+ "[WetStrength],"
				+ "[Date],"
				+ "[IssueDate],"
				+ "[Revision],"
				+ "[NoteSecA],"
				+ "[NoteSecB],"
				
				//New Field
				+ "[AfterDryerDraw],"
				+ "[HorizontalSliceDcs],"
				+ "[VerticalSliceDcs],"
				
				+ "[sprloadingfront],"
				+ "[sprloadingback],"
				+ "[pickuprollvacuum],"
				+ "[uhleboxvacuum],"
				+ "[sprvacuum],"
				+ "[primaryscreenrejectflow],"
				+ "[blendchestcy],"
				+ "[refiner1power],"
				+ "[refiner2power],"
				+ "[refiner1inletcy],"
				+ "[refiner2inletcy],"
				
				+ "[basisweighttarget],"
				+ "[moisturetarget],"
				+ "[yankeemapflow],"
				+ "[machinechestpumpspeed]"
				
				+ ")"
				+ " values(?,?,?,?,?,?,?,?,?,?,"
				+ "?,?,?,?,?,?,?,?,?,?,?,?,?,"
				+ "?,?,?,?,?,?,?,?,?,?,?,?,"
				+ "?,?,?,?,?,?,?,?,?,?,"
				+ "?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		
				jdbcTemplate.update(new PreparedStatementCreator() {
					
					@Override
					public PreparedStatement createPreparedStatement(Connection arg0)
							throws SQLException {
						PreparedStatement statement=arg0.prepareStatement(sql, new String[]{"ID"});
						statement.setInt(1,centerlineData.getGradeId());
						statement.setString(2,centerlineData.getCrew());
						statement.setString(3,centerlineData.getShift());
						statement.setDouble(4,centerlineData.getYankeeSpeed());
						statement.setDouble(5,centerlineData.getQcsBasisWtTarget());
						statement.setDouble(6,centerlineData.getReelMoisture());
						statement.setDouble(7,centerlineData.getCrepe());
						statement.setDouble(8,centerlineData.getYankeeSteam());
						statement.setDouble(9,centerlineData.getYankeeRelease());
						statement.setDouble(10,centerlineData.getYankeeAdesive());
						statement.setDouble(11,centerlineData.getJetWireRatio());
						statement.setDouble(12,centerlineData.getFanPumpFlowRate());
						statement.setDouble(13,centerlineData.getAfterDryerSteam());
						statement.setString(14,centerlineData.getSprLoading());
						statement.setDouble(15,centerlineData.getFeltPassivator());
						statement.setDouble(16,centerlineData.getSprayboomPressure());
						statement.setDouble(17,centerlineData.getSprayboomTemparature());
						statement.setDouble(18,centerlineData.getWefanSpeed());
						statement.setDouble(19,centerlineData.getDefanSpeed());
						statement.setDouble(20,centerlineData.getMakeUpAirDamper());
						statement.setDouble(21,centerlineData.getExhaustDamper());
						statement.setDouble(22,centerlineData.getExhaustFanSpeed());
						statement.setDouble(23,centerlineData.getWehoodTemperature());
						statement.setDouble(24,centerlineData.getDehoodTemperature());
						statement.setDouble(25,centerlineData.getYankeeAP());
						statement.setDouble(26,centerlineData.getAfterDryerAP());
						statement.setDouble(27,centerlineData.getSecArmLoading());
						statement.setDouble(28,centerlineData.getReelOffset());
						statement.setDouble(29,centerlineData.getUhleBoxNorthValve());
						statement.setDouble(30,centerlineData.getUhleBoxSouthValve());
						statement.setDouble(31,centerlineData.getFaltBox1VacuumValve());
						statement.setDouble(32,centerlineData.getFaltBox2VacuumValve());
						statement.setDouble(33,centerlineData.getFaltBox4VacuumValve());
						statement.setDouble(34,centerlineData.getFanPumpSpeed());
						statement.setDouble(35,centerlineData.getTotalHead());
						statement.setDouble(36,centerlineData.getHeadboxLevel());
						statement.setString(37,centerlineData.getHorizontalSlice());
						statement.setString(38,centerlineData.getVerticalSlice());
						statement.setDouble(39,centerlineData.getSelectifierRejectFlow1());
						statement.setDouble(40,centerlineData.getSelectifierRejectFlow2());
						statement.setDouble(41,centerlineData.getSecScreenCycleTime());
						statement.setDouble(42,centerlineData.getLowDensityCycleTime());
						statement.setDouble(43,centerlineData.getRefinersEnergy());
						statement.setDouble(44,centerlineData.getNumberOfRefiners());
						statement.setDouble(45,centerlineData.getRefinerInletConsistency());
						statement.setDouble(46,centerlineData.getMachineChestConsistency());
						statement.setDouble(47,centerlineData.getStockFlow());
						statement.setDouble(48,centerlineData.getSweetnerFlow());
						statement.setDouble(49,centerlineData.getBroke());
						statement.setDouble(50,centerlineData.getWetStrength());
						
						if(centerlineData.getDate()==null){
							statement.setNull(51, Types.DATE);
						}else{
							statement.setDate(51,new Date(centerlineData.getDate().getTime()));
						}
						if(centerlineData.getIssueDate()==null){
							statement.setNull(52, Types.DATE);
						}else{
							statement.setDate(52,new Date(centerlineData.getIssueDate().getTime()));
						}
						
						statement.setString(53,centerlineData.getRevision());
						statement.setString(54,centerlineData.getNoteSecA());
						statement.setString(55,centerlineData.getNoteSecB());
						
						//New Fields
						statement.setDouble(56,centerlineData.getAfterDryerDraw());
						statement.setString(57,centerlineData.getHorizontalSliceDcs());
						statement.setString(58,centerlineData.getVerticalSliceDcs());
						
						//New Fields Added RLT
						statement.setDouble(59, centerlineData.getSprloadingfront());
						statement.setDouble(60, centerlineData.getSprloadingback());
						statement.setDouble(61, centerlineData.getPickuprollvacuum());
						statement.setDouble(62, centerlineData.getUhleboxvacuum());
						statement.setDouble(63, centerlineData.getSprvacuum());
						statement.setDouble(64, centerlineData.getPrimaryscreenrejectflow());
						statement.setDouble(65, centerlineData.getBlendchestcy());
						statement.setDouble(66, centerlineData.getRefiner1power());
						statement.setDouble(67, centerlineData.getRefiner2power());
						statement.setDouble(68, centerlineData.getRefiner1inletcy());
						statement.setDouble(69, centerlineData.getRefiner2inletcy());
						
						
						statement.setDouble(70, centerlineData.getBasisweighttarget());
						statement.setDouble(71, centerlineData.getMoisturetarget());
						statement.setDouble(72, centerlineData.getYankeemapflow());
						statement.setDouble(73, centerlineData.getMachinechestpumpspeed());
						
						
						return statement;
					}
				},keyHolder);
		
		
		return keyHolder.getKey().intValue();
	}
	/* (non-Javadoc)
	 * @see com.st.centerlinePM5.dao.CenterlineDaoPM5#update(com.st.centerline.model.CenterlineData)
	 */
	@Override
	public void update(final CenterlineData centerlineData) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		final String sql="update [centerLineData_pm5] set "
				+ "[GradeID]=?,"
				+ "[Crew]=?,"
				+ "[Shift]=?,"
				+ "[YankeeSpeed]=?,"
				+ "[QCSBasisWtTarget]=?,"
				+ "[ReelMoisture]=?,"
				+ "[Crepe]=?,"
				+ "[YankeeSteam]=?,"
				+ "[YankeeRelease]=?,"
				+ "[YankeeAdesive]=?,"
				+ "[JetWireRatio]=?,"
				+ "[FanPumpFlowRate]=?,"
				+ "[AfterDryerSteam]=?,"
				+ "[SPRLoading]=?,"
				+ "[FeltPassivator]=?,"
				+ "[SprayboomPressure]=?,"
				+ "[SprayboomTemparature]=?,"
				+ "[WEFanSpeed]=?,"
				+ "[DEFanSpeed]=?,"
				+ "[MakeUpAirDamper]=?,"
				+ "[ExhaustDamper]=?,"
				+ "[ExhaustFanSpeed]=?,"
				+ "[WEHoodTemperature]=?,"
				+ "[DEHoodTemperature]=?,"
				+ "[YankeeAP]=?,"
				+ "[AfterDryerAP]=?,"
				+ "[SecArmLoading]=?,"
				+ "[ReelOffset]=?,"
				+ "[UhleBoxNorthValve]=?,"
				+ "[UhleBoxSouthValve]=?,"
				+ "[FaltBox1VacuumValve]=?,"
				+ "[FaltBox2VacuumValve]=?,"
				+ "[FaltBox4VacuumValve]=?,"
				+ "[FanPumpSpeed]=?,"
				+ "[TotalHead]=?,"
				+ "[HeadboxLevel]=?,"
				+ "[HorizontalSlice]=?,"
				+ "[VerticalSlice]=?,"
				+ "[SelectifierRejectFlow1]=?,"
				+ "[SelectifierRejectFlow2]=?,"
				+ "[SecScreenCycleTime]=?,"
				+ "[LowDensityCycleTime]=?,"
				+ "[RefinersEnergy]=?,"
				+ "[NumberOfRefiners]=?,"
				+ "[RefinerInletConsistency]=?,"
				+ "[MachineChestConsistency]=?,"
				+ "[StockFlow]=?,"
				+ "[SweetnerFlow]=?,"
				+ "[Broke]=?,"
				+ "[WetStrength]=?,"
				+ "[Date]=?,"
				+ "[IssueDate]=?,"
				+ "[Revision]=?,"
				+ "[NoteSecA]=?,"
				+ "[NoteSecB]=?, "
				
				//New Field
				+ "[AfterDryerDraw]=?, "
				+ "[HorizontalSliceDcs]=?, "
				+ "[VerticalSliceDcs]=?, "
			
				+ "[sprloadingfront]=?, "
				+ "[sprloadingback]=?, "
				+ "[pickuprollvacuum]=?, "
				+ "[uhleboxvacuum]=?, "
				+ "[sprvacuum]=?, "
				+ "[primaryscreenrejectflow]=?, "
				+ "[blendchestcy]=?, "
				+ "[refiner1power]=?, "
				+ "[refiner2power]=?, "
				+ "[refiner1inletcy]=?, "
				+ "[refiner2inletcy]=?, "
				
				
				+ "[basisweighttarget]=?, "
				+ "[moisturetarget]=?, "
				+ "[yankeemapflow]=?, "
				+ "[machinechestpumpspeed]=? "
				
				+ " where [ID]=?";
		
				jdbcTemplate.update(new PreparedStatementCreator() {
					
					@Override
					public PreparedStatement createPreparedStatement(Connection arg0)
							throws SQLException {
						PreparedStatement statement=arg0.prepareStatement(sql);
						statement.setInt(1,centerlineData.getGradeId());
						statement.setString(2,centerlineData.getCrew());
						statement.setString(3,centerlineData.getShift());
						statement.setDouble(4,centerlineData.getYankeeSpeed());
						statement.setDouble(5,centerlineData.getQcsBasisWtTarget());
						statement.setDouble(6,centerlineData.getReelMoisture());
						statement.setDouble(7,centerlineData.getCrepe());
						statement.setDouble(8,centerlineData.getYankeeSteam());
						statement.setDouble(9,centerlineData.getYankeeRelease());
						statement.setDouble(10,centerlineData.getYankeeAdesive());
						statement.setDouble(11,centerlineData.getJetWireRatio());
						statement.setDouble(12,centerlineData.getFanPumpFlowRate());
						statement.setDouble(13,centerlineData.getAfterDryerSteam());
						statement.setString(14,centerlineData.getSprLoading());
						statement.setDouble(15,centerlineData.getFeltPassivator());
						statement.setDouble(16,centerlineData.getSprayboomPressure());
						statement.setDouble(17,centerlineData.getSprayboomTemparature());
						statement.setDouble(18,centerlineData.getWefanSpeed());
						statement.setDouble(19,centerlineData.getDefanSpeed());
						statement.setDouble(20,centerlineData.getMakeUpAirDamper());
						statement.setDouble(21,centerlineData.getExhaustDamper());
						statement.setDouble(22,centerlineData.getExhaustFanSpeed());
						statement.setDouble(23,centerlineData.getWehoodTemperature());
						statement.setDouble(24,centerlineData.getDehoodTemperature());
						statement.setDouble(25,centerlineData.getYankeeAP());
						statement.setDouble(26,centerlineData.getAfterDryerAP());
						statement.setDouble(27,centerlineData.getSecArmLoading());
						statement.setDouble(28,centerlineData.getReelOffset());
						statement.setDouble(29,centerlineData.getUhleBoxNorthValve());
						statement.setDouble(30,centerlineData.getUhleBoxSouthValve());
						statement.setDouble(31,centerlineData.getFaltBox1VacuumValve());
						statement.setDouble(32,centerlineData.getFaltBox2VacuumValve());
						statement.setDouble(33,centerlineData.getFaltBox4VacuumValve());
						statement.setDouble(34,centerlineData.getFanPumpSpeed());
						statement.setDouble(35,centerlineData.getTotalHead());
						statement.setDouble(36,centerlineData.getHeadboxLevel());
						statement.setString(37,centerlineData.getHorizontalSlice());
						statement.setString(38,centerlineData.getVerticalSlice());
						statement.setDouble(39,centerlineData.getSelectifierRejectFlow1());
						statement.setDouble(40,centerlineData.getSelectifierRejectFlow2());
						statement.setDouble(41,centerlineData.getSecScreenCycleTime());
						statement.setDouble(42,centerlineData.getLowDensityCycleTime());
						statement.setDouble(43,centerlineData.getRefinersEnergy());
						statement.setDouble(44,centerlineData.getNumberOfRefiners());
						statement.setDouble(45,centerlineData.getRefinerInletConsistency());
						statement.setDouble(46,centerlineData.getMachineChestConsistency());
						statement.setDouble(47,centerlineData.getStockFlow());
						statement.setDouble(48,centerlineData.getSweetnerFlow());
						statement.setDouble(49,centerlineData.getBroke());
						statement.setDouble(50,centerlineData.getWetStrength());
						if(centerlineData.getDate()==null){
							statement.setNull(51, Types.DATE);
						}else{
							statement.setDate(51,new Date(centerlineData.getDate().getTime()));
						}
						if(centerlineData.getIssueDate()==null){
							statement.setNull(52, Types.DATE);
						}else{
							statement.setDate(52,new Date(centerlineData.getIssueDate().getTime()));
						}
						statement.setString(53,centerlineData.getRevision());
						statement.setString(54,centerlineData.getNoteSecA());
						statement.setString(55,centerlineData.getNoteSecB());
						
						//New Fields
						statement.setDouble(56,centerlineData.getAfterDryerDraw());
						statement.setString(57,centerlineData.getHorizontalSliceDcs());
						statement.setString(58,centerlineData.getVerticalSliceDcs());
						
						
						
						statement.setDouble(59,centerlineData.getSprloadingfront());
						statement.setDouble(60,centerlineData.getSprloadingback());
						statement.setDouble(61,centerlineData.getPickuprollvacuum());
						statement.setDouble(62,centerlineData.getUhleboxvacuum());
						statement.setDouble(63,centerlineData.getSprvacuum());
						statement.setDouble(64,centerlineData.getPrimaryscreenrejectflow());
						statement.setDouble(65,centerlineData.getBlendchestcy());
						statement.setDouble(66,centerlineData.getRefiner1power());
						statement.setDouble(67,centerlineData.getRefiner2power());
						statement.setDouble(68,centerlineData.getRefiner1inletcy());
						statement.setDouble(69,centerlineData.getRefiner2inletcy());
						
						
						statement.setDouble(70,centerlineData.getBasisweighttarget());
						statement.setDouble(71,centerlineData.getMoisturetarget());
						statement.setDouble(72,centerlineData.getYankeemapflow());
						statement.setDouble(73,centerlineData.getMachinechestpumpspeed());
						
						
						
						statement.setInt(74, centerlineData.getId());
						
						return statement;
					}
				});
		

	}
	/* (non-Javadoc)
	 * @see com.st.centerlinePM5.dao.CenterlineDaoPM5#getCurrentRunningGrade()
	 */
	@Override
	public List<Map<String, Object>> getCurrentRunningGrade() {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		Calendar calendar=Calendar.getInstance();
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		
		String sql="SELECT g.[Grade],d.[ID],d.[Date] FROM [centerLineData_pm5] d,[centerLineGrade] g where [Date]=? and g.[ID]=d.[GradeID]";
		List<Map<String, Object>> map=jdbcTemplate.queryForList(sql, new Object[]{new Date(calendar.getTime().getTime())});
		return map;
	}
	/* (non-Javadoc)
	 * @see com.st.centerlinePM5.dao.CenterlineDaoPM5#delete(int)
	 */
	@Override
	public void delete(int id) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		
		String sql="delete from [centerLineData_pm5] where [ID]=? ";
		jdbcTemplate.update(sql,new Object[]{id});
		
		
	}
	/* (non-Javadoc)
	 * @see com.st.centerlinePM5.dao.CenterlineDaoPM5#getCenterlineData(java.util.Date, java.util.Date, int)
	 */
	@Override
	public List<CenterlineData> getCenterlineData(java.util.Date sdate,
			java.util.Date edate, int grade) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		String sql="select * from [centerLineData_pm5] where [GradeID]=? and [Date] BETWEEN  ? AND ? order by [Date] desc,[GradeID],[ID]";
		List<CenterlineData> centerlineData=jdbcTemplate.query(sql, new Object[]{grade,new Date(sdate.getTime()),new Date(edate.getTime())},new CenterlineDataMapper());
 		
		return centerlineData;
	}
	/* (non-Javadoc)
	 * @see com.st.centerlinePM5.dao.CenterlineDaoPM5#getCenterlineData(java.util.Date, java.util.Date)
	 */
	@Override
	public List<CenterlineData> getCenterlineData(java.util.Date sdate,
			java.util.Date edate) {

		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		String sql="select * from [centerLineData_pm5] where [Date] BETWEEN  ? AND ? order by [Date] desc,[GradeID],[ID]";
		List<CenterlineData> centerlineData=jdbcTemplate.query(sql, new Object[]{new Date(sdate.getTime()),new Date(edate.getTime())},new CenterlineDataMapper());
		/*for (CenterlineData centerlineData2 : centerlineData) {
		//	System.out.println(centerlineData2.getDate()+"\t"+centerlineData2.getGrade());
		}*/
		
		return centerlineData;
	}

}

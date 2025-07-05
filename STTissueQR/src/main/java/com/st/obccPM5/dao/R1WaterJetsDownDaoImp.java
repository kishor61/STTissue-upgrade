/**
 *Oct 22, 2019
 *R1OperatorDaoImpl.java
 * TODO
 *com.st.obccPM5.dao
 *R1OperatorDaoImpl.java
 *sohan
 */
package com.st.obccPM5.dao;

import javax.sql.DataSource;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.st.common.CommonUtil;
import com.st.common.DatabaseUtil;
import com.st.obccPM5.model.R1WaterJetsDown;

/**
 * @author sohan lal
 *
 */
@Repository
public class R1WaterJetsDownDaoImp implements R1WaterJetsDownDao {

	@Autowired
	@Qualifier("dataSourceOBCC")
	private DataSource dataSourceQRT;
	
	private SimpleDateFormat dateFormat=new SimpleDateFormat("MM-dd-yyyy");
	private SimpleDateFormat fromuser=new SimpleDateFormat("yyyy-MM-dd");

	
	/* (non-Javadoc)
	 * @see com.st.oBcc1pm5.dao.R1OperatorPM5Dao#saveorUpdate(com.st.oBcc1pm5.model.R1OperatorPM5)
	 */
	@Override
	public void saveorUpdate(R1WaterJetsDown data) {
		NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(dataSourceQRT);
	 	MapSqlParameterSource paramSource=new MapSqlParameterSource();
	 	
	 	paramSource.addValue("position",data.getPosition());
		paramSource.addValue("operatorname",data.getOperatorName());
		paramSource.addValue("date",data.getEdate());
		paramSource.addValue("crew",data.getCrew());
		paramSource.addValue("shift",data.getShift());
		paramSource.addValue("machinedown",data.isMachinedown());
		
		
		paramSource.addValue("extractorTabeLevel",data.isExtractorTabeLevel());
		paramSource.addValue("allRollersInWorkingCondition",data.isAllRollersInWorkingCondition());
		paramSource.addValue("anyAbnormalSounds",data.isAnyAbnormalSounds());
		paramSource.addValue("hydralicMotorIssues",data.isHydralicMotorIssues());
		paramSource.addValue("anyHydralicLeaks",data.isAnyHydralicLeaks());
		paramSource.addValue("sensorsAndLimitSwitchesWorking",data.isSensorsAndLimitSwitchesWorking());
		paramSource.addValue("chainAndSprocketsAllOk",data.isChainAndSprocketsAllOk());
		paramSource.addValue("wetAndCraneWorking",data.isWetAndCraneWorking());
		paramSource.addValue("allHookesworking",data.isAllHookesworking());
			
		paramSource.addValue("waterPressure",data.isWaterPressure());
		paramSource.addValue("pumpControlStationInUse",data.getPumpControlStationInUse());
		paramSource.addValue("pumpControlStationInUse2",data.getPumpControlStationInUse2());
		paramSource.addValue("anyTableMovementIssue",data.isAnyTableMovementIssue());
		paramSource.addValue("frontAndBackTableScrewOk",data.getFrontAndBackTableScrewOk());
		paramSource.addValue("frontAndBackTableScrewOk2",data.getFrontAndBackTableScrewOk2());
		paramSource.addValue("tableAndLiftScrewsBlownDown",data.isTableAndLiftScrewsBlownDown());
		paramSource.addValue("anyTrimShootIssues",data.isAnyTrimShootIssues());
		paramSource.addValue("tableDrainClean",data.isTableDrainClean());
		paramSource.addValue("flueshLinesClean",data.isFlueshLinesClean());
		paramSource.addValue("checkCoolingWater",data.isCheckCoolingWater());
		paramSource.addValue("allPanelLightsWorking",data.isAllPanelLightsWorking());
		paramSource.addValue("airShaftsHolding",data.isAirShaftsHolding());
		paramSource.addValue("anyBreakingIssues",data.isAnyBreakingIssues());
		paramSource.addValue("extractorTabeLevelDesc",data.getExtractorTabeLevelDesc());
		paramSource.addValue("allRollersInWorkingConditionDesc",data.getAllRollersInWorkingConditionDesc());
		paramSource.addValue("anyAbnormalSoundsDesc",data.getAnyAbnormalSoundsDesc());
		paramSource.addValue("hydralicMotorIssuesDesc",data.getHydralicMotorIssuesDesc());
		paramSource.addValue("anyHydralicLeaksDesc",data.getAnyHydralicLeaksDesc());
		paramSource.addValue("sensorsAndLimitSwitchesWorkingDesc",data.getSensorsAndLimitSwitchesWorkingDesc());
		paramSource.addValue("chainAndSprocketsAllOkDesc",data.getChainAndSprocketsAllOkDesc());
		paramSource.addValue("wetAndCraneWorkingDesc",data.getWetAndCraneWorkingDesc());
		paramSource.addValue("allHookesworkingDesc",data.getAllHookesworkingDesc());
		
		paramSource.addValue("waterPressureDesc",data.getWaterPressureDesc());
		paramSource.addValue("pumpControlStationInUseDesc",data.getPumpControlStationInUseDesc());
		paramSource.addValue("anyTableMovementIssueDesc",data.getAnyTableMovementIssueDesc());
		paramSource.addValue("frontAndBackTableScrewOkDesc",data.getFrontAndBackTableScrewOkDesc());
		paramSource.addValue("tableAndLiftScrewsBlownDownDesc",data.getTableAndLiftScrewsBlownDownDesc());
		paramSource.addValue("anyTrimShootIssuesDesc",data.getAnyTrimShootIssuesDesc());
		paramSource.addValue("tableDrainCleanDesc",data.getTableDrainCleanDesc());
		paramSource.addValue("flueshLinesCleanDesc",data.getFlueshLinesCleanDesc());
		paramSource.addValue("checkCoolingWaterDesc",data.getCheckCoolingWaterDesc());
		paramSource.addValue("allPanelLightsWorkingDesc",data.getAllPanelLightsWorkingDesc());
		paramSource.addValue("airShaftsHoldingDesc",data.getAirShaftsHoldingDesc());
		paramSource.addValue("anyBreakingIssuesDesc",data.getAnyBreakingIssuesDesc());
		
		
		
		if (data.getId() == 0) {	
			
			String sql=DatabaseUtil.getSQL("sql/R1WaterJetsDown.sql");
			jdbcTemplate.update(sql, paramSource);
		}	
		else
		{
			paramSource.addValue("id",data.getId());
			String sql=DatabaseUtil.getSQL("sql/updateR1WaterJetsDown.sql");
			jdbcTemplate.update(sql, paramSource);
		}

	}

	/* (non-Javadoc)
	 * @see com.st.oBcc1pm5.dao.R1OperatorPM5Dao#getOperatorDataList(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public List<R1WaterJetsDown> getOperatorDataList(String position,	String shift, String sdate, String edate) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSourceQRT);
		String sql = "select * from [R1WaterJetsDown] where position=? AND shift=? AND date BETWEEN ? AND ? ";
		
		List<R1WaterJetsDown> r1OperatorPM5datalist=null;
		try {
				r1OperatorPM5datalist=jdbcTemplate.query(sql, new Object[]{position,shift,sdate,edate},new RowMapper<R1WaterJetsDown>()
				{
						
					
					@Override
					public R1WaterJetsDown mapRow(ResultSet rs ,int arg1)
							throws SQLException {
						
							R1WaterJetsDown data=new R1WaterJetsDown();
						try {
							String newDate = dateFormat.format(fromuser.parse(rs.getString("date")));
							data.setId(rs.getInt("id"));
							data.setPosition(rs.getString("position"));
							data.setOperatorName(rs.getString("operatorname"));
							data.setEdate(newDate);
							data.setCrew(rs.getString("crew"));
							data.setShift(rs.getString("shift"));
							data.setMachinedown(rs.getBoolean("machinedown"));
							
							data.setExtractorTabeLevel(rs.getBoolean("extractorTabeLevel"));
							data.setAllRollersInWorkingCondition(rs.getBoolean("allRollersInWorkingCondition"));
							data.setAnyAbnormalSounds(rs.getBoolean("anyAbnormalSounds"));
							data.setHydralicMotorIssues(rs.getBoolean("hydralicMotorIssues"));
							data.setAnyHydralicLeaks(rs.getBoolean("anyHydralicLeaks"));
							data.setSensorsAndLimitSwitchesWorking(rs.getBoolean("sensorsAndLimitSwitchesWorking"));
							data.setChainAndSprocketsAllOk(rs.getBoolean("chainAndSprocketsAllOk"));
							data.setWetAndCraneWorking(rs.getBoolean("wetAndCraneWorking"));
							data.setAllHookesworking(rs.getBoolean("allHookesworking"));
							
							data.setWaterPressure(rs.getBoolean("waterPressure"));
							data.setPumpControlStationInUse(rs.getString("pumpControlStationInUse"));
							data.setPumpControlStationInUse2(rs.getString("pumpControlStationInUse2"));
							data.setAnyTableMovementIssue(rs.getBoolean("anyTableMovementIssue"));
							data.setFrontAndBackTableScrewOk(rs.getString("frontAndBackTableScrewOk"));
							data.setFrontAndBackTableScrewOk2(rs.getString("frontAndBackTableScrewOk2"));
							data.setTableAndLiftScrewsBlownDown(rs.getBoolean("tableAndLiftScrewsBlownDown"));
							data.setAnyTrimShootIssues(rs.getBoolean("anyTrimShootIssues"));
							data.setTableDrainClean(rs.getBoolean("tableDrainClean"));
							data.setFlueshLinesClean(rs.getBoolean("flueshLinesClean"));
							data.setCheckCoolingWater(rs.getBoolean("checkCoolingWater"));
							data.setAllPanelLightsWorking(rs.getBoolean("allPanelLightsWorking"));
							data.setAirShaftsHolding(rs.getBoolean("airShaftsHolding"));
							data.setAnyBreakingIssues(rs.getBoolean("anyBreakingIssues"));
							
							data.setExtractorTabeLevelDesc(rs.getString("extractorTabeLevelDesc"));
							data.setAllRollersInWorkingConditionDesc(rs.getString("allRollersInWorkingConditionDesc"));
							data.setAnyAbnormalSoundsDesc(rs.getString("anyAbnormalSoundsDesc"));
							data.setHydralicMotorIssuesDesc(rs.getString("hydralicMotorIssuesDesc"));
							data.setAnyHydralicLeaksDesc(rs.getString("anyHydralicLeaksDesc"));
							data.setSensorsAndLimitSwitchesWorkingDesc(rs.getString("sensorsAndLimitSwitchesWorkingDesc"));
							data.setChainAndSprocketsAllOkDesc(rs.getString("chainAndSprocketsAllOkDesc"));
							data.setWetAndCraneWorkingDesc(rs.getString("wetAndCraneWorkingDesc"));
							data.setAllHookesworkingDesc(rs.getString("allHookesworkingDesc"));
							
							data.setWaterPressureDesc(rs.getString("waterPressureDesc"));
							data.setPumpControlStationInUseDesc(rs.getString("pumpControlStationInUseDesc"));
							data.setAnyTableMovementIssueDesc(rs.getString("anyTableMovementIssueDesc"));
							data.setFrontAndBackTableScrewOkDesc(rs.getString("frontAndBackTableScrewOkDesc"));
							data.setTableAndLiftScrewsBlownDownDesc(rs.getString("tableAndLiftScrewsBlownDownDesc"));
							data.setAnyTrimShootIssuesDesc(rs.getString("anyTrimShootIssuesDesc"));
							data.setTableDrainCleanDesc(rs.getString("tableDrainCleanDesc"));
							data.setFlueshLinesCleanDesc(rs.getString("flueshLinesCleanDesc"));
							data.setCheckCoolingWaterDesc(rs.getString("checkCoolingWaterDesc"));
							data.setAllPanelLightsWorkingDesc(rs.getString("allPanelLightsWorkingDesc"));
							data.setAirShaftsHoldingDesc(rs.getString("airShaftsHoldingDesc"));
							data.setAnyBreakingIssuesDesc(rs.getString("anyBreakingIssuesDesc"));
							 
						} catch (Exception e) {
							
						}
						return data;
					}
				});
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return r1OperatorPM5datalist;
	}
	@Override
	public List<R1WaterJetsDown> getOperatorDataListForBothShift(String position, String sdate, String edate) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSourceQRT);
		String sql = "select * from [R1WaterJetsDown] where position=? AND date BETWEEN ? AND ?  order by date";
		
		List<R1WaterJetsDown> r1OperatorPM5datalist=null;
		try {
				r1OperatorPM5datalist=jdbcTemplate.query(sql, new Object[]{position,sdate,edate},new RowMapper<R1WaterJetsDown>()
				{
						
					
					@Override
					public R1WaterJetsDown mapRow(ResultSet rs ,int arg1)
							throws SQLException {
						
							R1WaterJetsDown data=new R1WaterJetsDown();
						try {
							String newDate = dateFormat.format(fromuser.parse(rs.getString("date")));
							data.setId(rs.getInt("id"));
							data.setPosition(rs.getString("position"));
							data.setOperatorName(rs.getString("operatorname"));
							data.setEdate(newDate);
							data.setCrew(rs.getString("crew"));
							data.setShift(rs.getString("shift"));
							data.setMachinedown(rs.getBoolean("machinedown"));
							
							data.setExtractorTabeLevel(rs.getBoolean("extractorTabeLevel"));
							data.setAllRollersInWorkingCondition(rs.getBoolean("allRollersInWorkingCondition"));
							data.setAnyAbnormalSounds(rs.getBoolean("anyAbnormalSounds"));
							data.setHydralicMotorIssues(rs.getBoolean("hydralicMotorIssues"));
							data.setAnyHydralicLeaks(rs.getBoolean("anyHydralicLeaks"));
							data.setSensorsAndLimitSwitchesWorking(rs.getBoolean("sensorsAndLimitSwitchesWorking"));
							data.setChainAndSprocketsAllOk(rs.getBoolean("chainAndSprocketsAllOk"));
							data.setWetAndCraneWorking(rs.getBoolean("wetAndCraneWorking"));
							data.setAllHookesworking(rs.getBoolean("allHookesworking"));
							
							data.setWaterPressure(rs.getBoolean("waterPressure"));
							data.setPumpControlStationInUse(rs.getString("pumpControlStationInUse"));
							data.setPumpControlStationInUse2(rs.getString("pumpControlStationInUse2"));
							data.setAnyTableMovementIssue(rs.getBoolean("anyTableMovementIssue"));
							data.setFrontAndBackTableScrewOk(rs.getString("frontAndBackTableScrewOk"));
							data.setFrontAndBackTableScrewOk2(rs.getString("frontAndBackTableScrewOk2"));
							data.setTableAndLiftScrewsBlownDown(rs.getBoolean("tableAndLiftScrewsBlownDown"));
							data.setAnyTrimShootIssues(rs.getBoolean("anyTrimShootIssues"));
							data.setTableDrainClean(rs.getBoolean("tableDrainClean"));
							data.setFlueshLinesClean(rs.getBoolean("flueshLinesClean"));
							data.setCheckCoolingWater(rs.getBoolean("checkCoolingWater"));
							data.setAllPanelLightsWorking(rs.getBoolean("allPanelLightsWorking"));
							data.setAirShaftsHolding(rs.getBoolean("airShaftsHolding"));
							data.setAnyBreakingIssues(rs.getBoolean("anyBreakingIssues"));
							
							data.setExtractorTabeLevelDesc(rs.getString("extractorTabeLevelDesc"));
							data.setAllRollersInWorkingConditionDesc(rs.getString("allRollersInWorkingConditionDesc"));
							data.setAnyAbnormalSoundsDesc(rs.getString("anyAbnormalSoundsDesc"));
							data.setHydralicMotorIssuesDesc(rs.getString("hydralicMotorIssuesDesc"));
							data.setAnyHydralicLeaksDesc(rs.getString("anyHydralicLeaksDesc"));
							data.setSensorsAndLimitSwitchesWorkingDesc(rs.getString("sensorsAndLimitSwitchesWorkingDesc"));
							data.setChainAndSprocketsAllOkDesc(rs.getString("chainAndSprocketsAllOkDesc"));
							data.setWetAndCraneWorkingDesc(rs.getString("wetAndCraneWorkingDesc"));
							data.setAllHookesworkingDesc(rs.getString("allHookesworkingDesc"));
							
							data.setWaterPressureDesc(rs.getString("waterPressureDesc"));
							data.setPumpControlStationInUseDesc(rs.getString("pumpControlStationInUseDesc"));
							data.setAnyTableMovementIssueDesc(rs.getString("anyTableMovementIssueDesc"));
							data.setFrontAndBackTableScrewOkDesc(rs.getString("frontAndBackTableScrewOkDesc"));
							data.setTableAndLiftScrewsBlownDownDesc(rs.getString("tableAndLiftScrewsBlownDownDesc"));
							data.setAnyTrimShootIssuesDesc(rs.getString("anyTrimShootIssuesDesc"));
							data.setTableDrainCleanDesc(rs.getString("tableDrainCleanDesc"));
							data.setFlueshLinesCleanDesc(rs.getString("flueshLinesCleanDesc"));
							data.setCheckCoolingWaterDesc(rs.getString("checkCoolingWaterDesc"));
							data.setAllPanelLightsWorkingDesc(rs.getString("allPanelLightsWorkingDesc"));
							data.setAirShaftsHoldingDesc(rs.getString("airShaftsHoldingDesc"));
							data.setAnyBreakingIssuesDesc(rs.getString("anyBreakingIssuesDesc"));
							 
						} catch (Exception e) {
							
						}
						return data;
					}
				});
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return r1OperatorPM5datalist;
	}

	@Override
	public R1WaterJetsDown getOperatorData(String position, String shift,	String date, String crew) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSourceQRT);
		String sql = "select * from [R1WaterJetsDown] where [position]=? AND [date]=? AND [shift] = ? ";

		R1WaterJetsDown r1OperatorPM5data=null;
		try {
				r1OperatorPM5data=jdbcTemplate.queryForObject(sql, new Object[]{position, date, shift },new RowMapper<R1WaterJetsDown>()
				{
						
					
					@Override
					public R1WaterJetsDown mapRow(ResultSet rs ,int arg1)
							throws SQLException {
						
							R1WaterJetsDown data=new R1WaterJetsDown();
						try {
							String newDate = dateFormat.format(fromuser.parse(rs.getString("date")));
							data.setId(rs.getInt("id"));
							data.setPosition(rs.getString("position"));
							data.setOperatorName(rs.getString("operatorname"));
							data.setEdate(newDate);
							data.setCrew(rs.getString("crew"));
							data.setShift(rs.getString("shift"));
							data.setMachinedown(rs.getBoolean("machinedown"));
							data.setExtractorTabeLevel(rs.getBoolean("extractorTabeLevel"));
							data.setAllRollersInWorkingCondition(rs.getBoolean("allRollersInWorkingCondition"));
							data.setAnyAbnormalSounds(rs.getBoolean("anyAbnormalSounds"));
							data.setHydralicMotorIssues(rs.getBoolean("hydralicMotorIssues"));
							data.setAnyHydralicLeaks(rs.getBoolean("anyHydralicLeaks"));
							data.setSensorsAndLimitSwitchesWorking(rs.getBoolean("sensorsAndLimitSwitchesWorking"));
							data.setChainAndSprocketsAllOk(rs.getBoolean("chainAndSprocketsAllOk"));
							data.setWetAndCraneWorking(rs.getBoolean("wetAndCraneWorking"));
							data.setAllHookesworking(rs.getBoolean("allHookesworking"));
							
							data.setWaterPressure(rs.getBoolean("waterPressure"));
							data.setPumpControlStationInUse(rs.getString("pumpControlStationInUse"));
							data.setPumpControlStationInUse2(rs.getString("pumpControlStationInUse2"));
							data.setAnyTableMovementIssue(rs.getBoolean("anyTableMovementIssue"));
							data.setFrontAndBackTableScrewOk(rs.getString("frontAndBackTableScrewOk"));
							data.setFrontAndBackTableScrewOk2(rs.getString("frontAndBackTableScrewOk2"));
							data.setTableAndLiftScrewsBlownDown(rs.getBoolean("tableAndLiftScrewsBlownDown"));
							data.setAnyTrimShootIssues(rs.getBoolean("anyTrimShootIssues"));
							data.setTableDrainClean(rs.getBoolean("tableDrainClean"));
							data.setFlueshLinesClean(rs.getBoolean("flueshLinesClean"));
							data.setCheckCoolingWater(rs.getBoolean("checkCoolingWater"));
							data.setAllPanelLightsWorking(rs.getBoolean("allPanelLightsWorking"));
							data.setAirShaftsHolding(rs.getBoolean("airShaftsHolding"));
							data.setAnyBreakingIssues(rs.getBoolean("anyBreakingIssues"));
							
							data.setExtractorTabeLevelDesc(rs.getString("extractorTabeLevelDesc"));
							data.setAllRollersInWorkingConditionDesc(rs.getString("allRollersInWorkingConditionDesc"));
							data.setAnyAbnormalSoundsDesc(rs.getString("anyAbnormalSoundsDesc"));
							data.setHydralicMotorIssuesDesc(rs.getString("hydralicMotorIssuesDesc"));
							data.setAnyHydralicLeaksDesc(rs.getString("anyHydralicLeaksDesc"));
							data.setSensorsAndLimitSwitchesWorkingDesc(rs.getString("sensorsAndLimitSwitchesWorkingDesc"));
							data.setChainAndSprocketsAllOkDesc(rs.getString("chainAndSprocketsAllOkDesc"));
							data.setWetAndCraneWorkingDesc(rs.getString("wetAndCraneWorkingDesc"));
							data.setAllHookesworkingDesc(rs.getString("allHookesworkingDesc"));
							
							data.setWaterPressureDesc(rs.getString("waterPressureDesc"));
							data.setPumpControlStationInUseDesc(rs.getString("pumpControlStationInUseDesc"));
							data.setAnyTableMovementIssueDesc(rs.getString("anyTableMovementIssueDesc"));
							data.setFrontAndBackTableScrewOkDesc(rs.getString("frontAndBackTableScrewOkDesc"));
							data.setTableAndLiftScrewsBlownDownDesc(rs.getString("tableAndLiftScrewsBlownDownDesc"));
							data.setAnyTrimShootIssuesDesc(rs.getString("anyTrimShootIssuesDesc"));
							data.setTableDrainCleanDesc(rs.getString("tableDrainCleanDesc"));
							data.setFlueshLinesCleanDesc(rs.getString("flueshLinesCleanDesc"));
							data.setCheckCoolingWaterDesc(rs.getString("checkCoolingWaterDesc"));
							data.setAllPanelLightsWorkingDesc(rs.getString("allPanelLightsWorkingDesc"));
							data.setAirShaftsHoldingDesc(rs.getString("airShaftsHoldingDesc"));
							data.setAnyBreakingIssuesDesc(rs.getString("anyBreakingIssuesDesc"));
							
						} catch (Exception e) {
							
						}
						return data;
					}
				
					
				});
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return r1OperatorPM5data;
	}
	/* (non-Javadoc)
	 * @see com.st.oBcc1pm5.dao.LeadOperatorPM5Dao#getDataCountDatePercentage(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public long getDataCountDatePercentage(String position, String sdate,String edate,String shift) throws ParseException {
		
		SimpleDateFormat format=new SimpleDateFormat("MM-dd-yyyy");
		
		List<R1WaterJetsDown> daydata=null, nightdata=null;
		if(shift.equals("both"))
		{
			 daydata=getOperatorDataList(position,"day",sdate,edate);
			 nightdata=getOperatorDataList(position,"night",sdate,edate);
		}else if(shift.equals("day"))
		{
			daydata=getOperatorDataList(position,"day",sdate,edate);
		}
		else
		{
			nightdata=getOperatorDataList(position,"night",sdate,edate);
		}
			
		
		int count=0,no=0;long set=0,daypercent=0,nightpercent=0,percentage=0;
		int days = CommonUtil.getDaysDiffernce(format.parse(sdate), format.parse(edate))+1;
		List<Integer> al=new ArrayList<Integer>();
		List<Integer> al2=new ArrayList<Integer>();
	if(daydata!=null||nightdata!=null)	
	{
		if(shift.equals("day")||shift.equals("both"))
		{
			 for(R1WaterJetsDown data:daydata) { 
				 if(data.isMachinedown()==false) { 
					 if(data.isExtractorTabeLevel()==true){count++;}
					 if(data.isAllRollersInWorkingCondition()==true){count++;}
					 if(data.isAnyAbnormalSounds()==true){count++;}
					 if(data.isHydralicMotorIssues()==true){count++;}
					 if(data.isAnyHydralicLeaks()==true){count++;}
					 if(data.isSensorsAndLimitSwitchesWorking()==true){count++;}
					 if(data.isChainAndSprocketsAllOk()==true){count++;}
					 if(data.isWetAndCraneWorking()==true){count++;}
					 if(data.isAllHookesworking()==true){count++;}
					 if(data.isWaterPressure()==true){count++;}					 
					 if(data.isAnyTableMovementIssue()==true){count++;}
					 if(data.getPumpControlStationInUse()!=null){count++;}
					 if(data.getFrontAndBackTableScrewOk()!=null){count++;}
					 if(data.getPumpControlStationInUse2()!=null){count++;}
					 if(data.getFrontAndBackTableScrewOk2()!=null){count++;}
					 if(data.isTableAndLiftScrewsBlownDown()==true){count++;}
					 if(data.isAnyTrimShootIssues()==true){count++;}
					 if(data.isTableDrainClean()==true){count++;}
					 if(data.isFlueshLinesClean()==true){count++;}
					 if(data.isCheckCoolingWater()==true){count++;}
					 if(data.isAllPanelLightsWorking()==true){count++;}
					 if(data.isAirShaftsHolding()==true){count++;}
					 if(data.isAnyBreakingIssues()==true){count++;}
				 }else count=6;
			  al.add(count); count=0; 
			 }
			 for(int n:al) { 
				 if(n>=5) { set=set+100; } 
			 } 
			 daypercent=set/days; no++; 
		}
		if(shift.equals("night")||shift.equals("both")) { 
			set=0; 
			  for(R1WaterJetsDown data:nightdata) { 
				  if(data.isMachinedown()==false){
					  if(data.isExtractorTabeLevel()==true){count++;}
						 if(data.isAllRollersInWorkingCondition()==true){count++;}
						 if(data.isAnyAbnormalSounds()==true){count++;}
						 if(data.isHydralicMotorIssues()==true){count++;}
						 if(data.isAnyHydralicLeaks()==true){count++;}
						 if(data.isSensorsAndLimitSwitchesWorking()==true){count++;}
						 if(data.isChainAndSprocketsAllOk()==true){count++;}
						 if(data.isWetAndCraneWorking()==true){count++;}
						 if(data.isAllHookesworking()==true){count++;}
						 if(data.isWaterPressure()==true){count++;}						 
						 if(data.isAnyTableMovementIssue()==true){count++;}
						 if(data.getPumpControlStationInUse()!=null){count++;}
						 if(data.getFrontAndBackTableScrewOk()!=null){count++;}
						 if(data.getPumpControlStationInUse2()!=null){count++;}
						 if(data.getFrontAndBackTableScrewOk2()!=null){count++;}
						 if(data.isTableAndLiftScrewsBlownDown()==true){count++;}
						 if(data.isAnyTrimShootIssues()==true){count++;}
						 if(data.isTableDrainClean()==true){count++;}
						 if(data.isFlueshLinesClean()==true){count++;}
						 if(data.isCheckCoolingWater()==true){count++;}
						 if(data.isAllPanelLightsWorking()==true){count++;}
						 if(data.isAirShaftsHolding()==true){count++;}
						 if(data.isAnyBreakingIssues()==true){count++;}
			 }else count=6;
			  al2.add(count); count=0; 
			  }
			 
		 for(int n:al2)
		{
			if(n>=5)
			{
				set=set+100;
			}
		}
			nightpercent=set/days;
			no++;
		}
	if(no==0)
		no=1;
		percentage=(daypercent+nightpercent)/no;
	}
		return percentage;
	}
}

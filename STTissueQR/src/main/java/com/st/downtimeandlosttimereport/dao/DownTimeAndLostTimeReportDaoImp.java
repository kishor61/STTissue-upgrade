/**
 *Sep 12, 2017
 *DownTimeAndLostTimeReportDaoImp.java
 * TODO
 *com.st.downtimeandlosttimereport.dao
 *DownTimeAndLostTimeReportDaoImp.java
 *Roshan Lal Tailor
 */
package com.st.downtimeandlosttimereport.dao;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.joda.time.Days;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.st.common.CommonUtil;
import com.st.downtimeandlosttimereport.mapper.DownTimeAndLostTimeSecondaryCodeMapper;
import com.st.downtimeandlosttimereport.model.DownTimeAndLostTimeReport;
import com.st.efficiency.dao.EfficiencyDao;
import com.st.efficiency.model.Efficiency;
import com.st.production.dao.MachineProductionDao;
import com.st.production.model.MachineProduction;

/**
 * @author roshan
 *
 */
@Repository
public class DownTimeAndLostTimeReportDaoImp implements DownTimeAndLostTimeReportDao {

	@Autowired
	private DataSource dataSource;
	
	
	@Autowired
	private MachineProductionDao machineProductionDao;
	
	@Autowired
	private EfficiencyDao efficiencyDao;
	
	/* (non-Javadoc)
	 * @see com.st.downtimeandlosttimereport.dao.DownTimeAndLostTimeReportDao#getDataDateWise()
	 */
	@Override
	public List<DownTimeAndLostTimeReport> getDataDateWise(Date sdate, Date edate) {
		
		NamedParameterJdbcTemplate  jdbcTemplate=new NamedParameterJdbcTemplate(dataSource);
		List<DownTimeAndLostTimeReport> unloadDetails= new ArrayList<DownTimeAndLostTimeReport>();
		
		
		Calendar calendar=Calendar.getInstance();
		calendar.setTime(sdate);
		System.out.println("Fetching BARCODE UNLOAD BALES - GRADEWISE <START>");
		
		int days=Days.daysBetween(new DateTime(sdate.getTime()), new DateTime(edate.getTime())).getDays();
		
		Calendar date=Calendar.getInstance();
		date.setTime(sdate);
		
		for (int i = 0; i <=days; i++) {
			
			Calendar scal=Calendar.getInstance();
			scal.setTime(date.getTime());
			scal.set(Calendar.HOUR_OF_DAY, 7);
			scal.set(Calendar.MINUTE, 0);
			scal.set(Calendar.SECOND, 0);
			scal.set(Calendar.MILLISECOND, 0);
	
			
			Calendar ecal=Calendar.getInstance();
			ecal.setTime(date.getTime());
			ecal.set(Calendar.HOUR_OF_DAY, 6);
			ecal.set(Calendar.MINUTE, 59);
			ecal.set(Calendar.SECOND, 59);
			ecal.set(Calendar.MILLISECOND, 0);
			ecal.add(Calendar.DATE, 1);
			
			
			Calendar frmCal=Calendar.getInstance();
			frmCal.setTime(scal.getTime());
			frmCal.add(Calendar.DATE, -1);
			
			Calendar toCal=Calendar.getInstance();
			toCal.setTime(ecal.getTime());
			toCal.add(Calendar.DATE, 1);
			
			
			MapSqlParameterSource source=new MapSqlParameterSource();
			
			source.addValue("sdate", new Timestamp(scal.getTime().getTime()));
			source.addValue("edate", new Timestamp(ecal.getTime().getTime()));	
			
			final DownTimeAndLostTimeReport wastePaperBaleInventory=new DownTimeAndLostTimeReport();
			
			double _totalAnnualOutage=0;
			double _totalBladeChange=0;
			double _totalBoilout=0;
			double _totalBreakBackEdge=0;
			double _totalBreakFrontEdge=0;
			double _totalBreakMiddle=0;
			double _totalBreakatreel=0;
			double _totalBreakatYankee=0;
			double _totalCleanupWashup=0;
			double _totalElectrical=0;
			double _totalFeltWash=0;
			double _totalFieldday=0;
			double _totalFireatReel=0;
			double _totalGradeChange=0;
			double _totalHeadboxflushing=0;
			double _totalHeadboxsealfixing=0;
			double _totalHoodfire=0;
			double _totalInstrumentation=0;
			double _totalJetslittertrimsadjustment=0;
			double _totalLackofAir=0;
			double _totalLackofSteam=0;
			double _totalLackofStock=0;
			double _totalMechanical=0;
			double _totalMissedTurnup=0;
			double _totalNoEmptySpool=0;
			double _totalNoWater=0;
			double _totalPowerOutage=0;
			double _totalScheduleClothingChange=0;
			double _totalSmoldering=0;
			double _totalSprayboomchange=0;
			double _totalStartup=0;
			double _totalStriptheYankee=0;
			double _totalTurnup=0;
			double _totalUnscheduledclothingchange=0;
			
			double totalHR=0;
			double totalMin=0; 
			
			double reelTon=0;
			Date dateS=scal.getTime();
			wastePaperBaleInventory.setDate(dateS);
			
			try{
				
				String sql_query="SELECT "
						+ "d.[ID],"
						+ "d.[Date],"
						+ "d.[Shift],"
						+ "d.[Crew],"
						+ "d.[StartTime],"
						+ "d.[EndTime],"
						+ "d.[Reel],"
						+ "d.[GradeCode],"
						+ "d.[Comment],"
						+ "sc.[code] as scode,"
						+ "sc.[ID] as sid,"
						+ "pc.[code] as pcode,"
						+ "pc.[Type] as ptype"
						+ " FROM [efficiencyData] d,"
						+ "efficiencySecondaryCode sc,"
						+ "efficiencyPrimaryCode pc "
						+ " where ( d.[Date] between :sdate and :edate) and "
						+ "sc.[ID]=d.[SecodaryCode] and "
						+ "pc.[ID]=sc.[PrimaryCodeID] order by scode ASC";
				
				List<Map<String, Object>> maps=jdbcTemplate.queryForList(sql_query,source);	
				if(maps.size()>0){
					for (final Map<String, Object> map1 : maps) {
						
						String scode=(String)map1.get("scode");
						String gradeCode=(String)map1.get("GradeCode");
						
						wastePaperBaleInventory.setStartTime((Timestamp) map1.get("StartTime"));
						wastePaperBaleInventory.setEndTime((Timestamp) map1.get("EndTime"));
						
						SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
						
						String strTime = format.format(wastePaperBaleInventory.getStartTime());
						String endTime = format.format(wastePaperBaleInventory.getEndTime());
						
						
						double downTime=(CommonUtil.getHoursDuration(format.parse(strTime), format.parse(endTime))*60+CommonUtil.getMinutesDuration(format.parse(strTime), format.parse(endTime)));
						
						
						wastePaperBaleInventory.setGradeCode(gradeCode);
						if(scode.equalsIgnoreCase("Annual Outage")){
							_totalAnnualOutage=_totalAnnualOutage+downTime;
							wastePaperBaleInventory.setTotalannualoutage(_totalAnnualOutage);
						}
						//
						if(scode.equalsIgnoreCase("Blade Change")){
							_totalBladeChange=_totalBladeChange+downTime;
							wastePaperBaleInventory.setTotalbladechange(_totalBladeChange);
						}
						//
						if(scode.equalsIgnoreCase("Boil-out")){
							_totalBoilout=_totalBoilout+1;
							wastePaperBaleInventory.setTotalboilout(_totalBoilout);
						}
						//
						if(scode.equalsIgnoreCase("Break - Back Edge")){
							_totalBreakBackEdge=_totalBreakBackEdge+downTime;
							wastePaperBaleInventory.setTotalbreakbackedge(_totalBreakBackEdge);
						}
						//
						if(scode.equalsIgnoreCase("Break - Front Edge")){
							_totalBreakFrontEdge=_totalBreakFrontEdge+downTime;
							wastePaperBaleInventory.setTotalbreakfrontedge(_totalBreakFrontEdge);
						}
						//
						if(scode.equalsIgnoreCase("Break - Middle")){
							_totalBreakMiddle=_totalBreakMiddle+downTime;
							wastePaperBaleInventory.setTotalbreakmiddle(_totalBreakMiddle);
						}
						//
						if(scode.equalsIgnoreCase("Break at reel")){
							_totalBreakatreel=_totalBreakatreel+downTime;
							wastePaperBaleInventory.setTotalbreakatreel(_totalBreakatreel);
						}
						//
						if(scode.equalsIgnoreCase("Break at Yankee")){
							_totalBreakatYankee=_totalBreakatYankee+downTime;
							wastePaperBaleInventory.setTotalbreakatyankee(_totalBreakatYankee);
						}
						//
						if(scode.equalsIgnoreCase("Clean-up/Wash-up")){
							_totalCleanupWashup=_totalCleanupWashup+downTime;
							wastePaperBaleInventory.setTotalcleanupwashup(_totalCleanupWashup);
						}
						//
						if(scode.equalsIgnoreCase("Electrical")){
							_totalElectrical=_totalElectrical+downTime;
							wastePaperBaleInventory.setTotalelectrical(_totalElectrical);
						}
						//
						if(scode.equalsIgnoreCase("Felt Wash")){
							_totalFeltWash=_totalFeltWash+downTime;
							wastePaperBaleInventory.setTotalfeltwash(_totalFeltWash);
						}
						//
						if(scode.equalsIgnoreCase("Field day")){
							_totalFieldday=_totalFieldday+downTime;
							wastePaperBaleInventory.setTotalfieldday(_totalFieldday);
						}
						//
						if(scode.equalsIgnoreCase("Fire at Reel")){
							_totalFireatReel=_totalFireatReel+downTime;
							wastePaperBaleInventory.setTotalfireatreel(_totalFireatReel);
						}
						//
						if(scode.equalsIgnoreCase("Grade Change")){
							_totalGradeChange=_totalGradeChange+downTime;
							wastePaperBaleInventory.setTotalgradechange(_totalGradeChange);
						}
						//
						if(scode.equalsIgnoreCase("Head box flushing")){
							_totalHeadboxflushing=_totalHeadboxflushing+downTime;
							wastePaperBaleInventory.setTotalheadboxflushing(_totalHeadboxflushing);
						}
						//
						if(scode.equalsIgnoreCase("Head box seal  fixing")){
							_totalHeadboxsealfixing=_totalHeadboxsealfixing+downTime;
							wastePaperBaleInventory.setTotalheadboxsealfixing(_totalHeadboxsealfixing);
						}
						//
						if(scode.equalsIgnoreCase("Hood fire")){
							_totalHoodfire=_totalHoodfire+downTime;
							wastePaperBaleInventory.setTotalhoodfire(_totalHoodfire);
						}
						//
						if(scode.equalsIgnoreCase("Instrumentation")){
							_totalInstrumentation=_totalInstrumentation+downTime;
							wastePaperBaleInventory.setTotalinstrumentation(_totalInstrumentation);
						}
						//
						if(scode.equalsIgnoreCase("Jet slitter trims adjustment")){
							_totalJetslittertrimsadjustment=_totalJetslittertrimsadjustment+downTime;
							wastePaperBaleInventory.setTotaljetslittertrimsadjustment(_totalJetslittertrimsadjustment);
						}
						//
						if(scode.equalsIgnoreCase("Lack of Air")){
							_totalLackofAir=_totalLackofAir+downTime;
							wastePaperBaleInventory.setTotallackofair(_totalLackofAir);
						}
						//
						if(scode.equalsIgnoreCase("Lack of Steam")){
							_totalLackofSteam=_totalLackofSteam+downTime;
							wastePaperBaleInventory.setTotallackofsteam(_totalLackofSteam);
						}
						//
						if(scode.equalsIgnoreCase("Lack of Stock")){
							_totalLackofStock=_totalLackofStock+downTime;
							wastePaperBaleInventory.setTotallackofstock(_totalLackofStock);
						}
						//
						if(scode.equalsIgnoreCase("Mechanical")){
							_totalMechanical=_totalMechanical+downTime;
							wastePaperBaleInventory.setTotalmechanical(_totalMechanical);
						}
						//
						if(scode.equalsIgnoreCase("Missed Turn-up")){
							_totalMissedTurnup=_totalMissedTurnup+downTime;
							wastePaperBaleInventory.setTotalmissedturnup(_totalMissedTurnup);
						}
						//
						if(scode.equalsIgnoreCase("No Empty Spool")){
							_totalNoEmptySpool=_totalNoEmptySpool+downTime;
							wastePaperBaleInventory.setTotalnoemptyspool(_totalNoEmptySpool);
						}
						//
						if(scode.equalsIgnoreCase("No Water")){
							_totalNoWater=_totalNoWater+downTime;
							wastePaperBaleInventory.setTotalnowater(_totalNoWater);
						}
						//
						if(scode.equalsIgnoreCase("Power Outage")){
							_totalPowerOutage=_totalPowerOutage+downTime;
							wastePaperBaleInventory.setTotalpoweroutage(_totalPowerOutage);
						}
						//
						if(scode.equalsIgnoreCase("Schedule Clothing Change")){
							_totalScheduleClothingChange=_totalScheduleClothingChange+downTime;
							wastePaperBaleInventory.setTotalscheduleclothingchange(_totalScheduleClothingChange);
						}
						//
						if(scode.equalsIgnoreCase("Smoldering")){
							_totalSmoldering=_totalSmoldering+downTime;
							wastePaperBaleInventory.setTotalsmoldering(_totalSmoldering);
						}
						//
						if(scode.equalsIgnoreCase("Spray boom change")){
							_totalSprayboomchange=_totalSprayboomchange+downTime;
							wastePaperBaleInventory.setTotalsprayboomchange(_totalSprayboomchange);
						}
						//
						if(scode.equalsIgnoreCase("Start-up")){
							_totalStartup=_totalStartup+downTime;
							wastePaperBaleInventory.setTotalstartup(_totalStartup);
						}
						//
						if(scode.equalsIgnoreCase("Strip the Yankee")){
							_totalStriptheYankee=_totalStriptheYankee+downTime;
							wastePaperBaleInventory.setTotalstriptheYankee(_totalStriptheYankee);
						}
						//
						if(scode.equalsIgnoreCase("Turn-up")){
							_totalTurnup=_totalTurnup+downTime;
							wastePaperBaleInventory.setTotalturnup(_totalTurnup);
						}
						//
						if(scode.equalsIgnoreCase("Unscheduled clothing change")){
							_totalUnscheduledclothingchange=_totalUnscheduledclothingchange+downTime;
							wastePaperBaleInventory.setTotalunscheduledclothingchange(_totalUnscheduledclothingchange);
						}
						
						wastePaperBaleInventory.setFendTimeHH(""+CommonUtil.getHoursDuration(new Date(wastePaperBaleInventory.getStartTime().getTime()), new Date(wastePaperBaleInventory.getEndTime().getTime())));
						wastePaperBaleInventory.setFendTimeMM(""+CommonUtil.getMinutesDuration(new Date(wastePaperBaleInventory.getStartTime().getTime()), new Date(wastePaperBaleInventory.getEndTime().getTime())));
					
						totalHR=totalHR+CommonUtil.getHoursDuration(new Date(wastePaperBaleInventory.getStartTime().getTime()), new Date(wastePaperBaleInventory.getEndTime().getTime()));
						totalMin=totalMin+CommonUtil.getMinutesDuration(new Date(wastePaperBaleInventory.getStartTime().getTime()), new Date(wastePaperBaleInventory.getEndTime().getTime()));
						
						
						wastePaperBaleInventory.setTotalhr(totalHR);
						wastePaperBaleInventory.setTotalmin(totalMin);
						
					}
					try{
						List<MachineProduction> machineProductions=machineProductionDao.getMachineProductions(new Timestamp(scal.getTime().getTime()),new Timestamp(ecal.getTime().getTime()));
						
						for (MachineProduction machineProduction : machineProductions) {
							reelTon+=machineProduction.getGoodWeight();
						}
						wastePaperBaleInventory.setReelton(CommonUtil.round(reelTon, 2));
						
						Efficiency efficiency=new Efficiency();
						efficiency.setStartDate(scal.getTime());
						efficiency.setEndDate(ecal.getTime());
						List<String> comments=new ArrayList<>();
						
						List<Efficiency> efficiencies=efficiencyDao.getEfficiencies(efficiency);
						
						for (Efficiency eff : efficiencies) {
							if(!StringUtils.isEmpty(eff.getComment())){
								comments.add(eff.getComment());
							}
						}
						String commentList=StringUtils.join(comments, ", ");
						wastePaperBaleInventory.setComments(commentList);
						
					}catch(Exception rlt){
						rlt.printStackTrace();
					}
				}
			}catch(Exception rlt){
				rlt.printStackTrace();
			}
			
			 unloadDetails.add(wastePaperBaleInventory);	
			 date.add(Calendar.DATE, 1);	
		}
		
		return unloadDetails;
	}

	/* (non-Javadoc)
	 * @see com.st.downtimeandlosttimereport.dao.DownTimeAndLostTimeReportDao#getsecondaryCode()
	 */
	@Override
	public List<DownTimeAndLostTimeReport> getsecondaryCode() {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		String sql="select * from [efficiencySecondaryCode] ORDER BY [code] ASC";
		List<DownTimeAndLostTimeReport> secondarycodes=jdbcTemplate.query(sql, new DownTimeAndLostTimeSecondaryCodeMapper());
		return secondarycodes;
	}

}

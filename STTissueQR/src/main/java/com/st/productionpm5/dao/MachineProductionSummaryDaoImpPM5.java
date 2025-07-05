/**
 *May 23, 2016
 *MachineProductionSummaryDaoImp.java
 * TODO
 *com.st.production.dao
 *MachineProductionSummaryDaoImp.java
 *Sunil Singh Bora
 */
package com.st.productionpm5.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import com.st.common.CommonUtil;
import com.st.common.DatabaseUtil;
import com.st.common.exception.ProductionException;
import com.st.production.model.MachineAndWrapper;
import com.st.production.model.MachineProduction;
import com.st.productionpm5.model.MachineAndWrapperPM5;
import com.st.productionpm5.model.MachineProductionPM5;
import com.st.wastepaper.model.WastepaperDetail;

/**
 * @author roshan
 *
 */
@Component
public class MachineProductionSummaryDaoImpPM5 implements MachineProductionSummaryDaoPM5{

	@Autowired
	@Qualifier("dataSourceProduction")
	private DataSource dataSourceP;

	SimpleDateFormat dateFormat=new SimpleDateFormat("MM-dd-yyyy");
	private SimpleDateFormat yearformat=new SimpleDateFormat("yyyy");
	
	/* (non-Javadoc)
	 * @see com.st.production.dao.MachineProductionSummaryDao#getMachineAndWrapperSummaryReport(java.util.Date, java.util.Date)
	 */
	@Override
	public List<MachineAndWrapperPM5> getMachineAndWrapperSummaryReport(Date sdate, Date edate) throws ProductionException {
		final NamedParameterJdbcTemplate jdbcTemplate=new NamedParameterJdbcTemplate(dataSourceP);
		MapSqlParameterSource parameterSource=new MapSqlParameterSource();
		parameterSource.addValue("sdate", new Timestamp(sdate.getTime()));
		parameterSource.addValue("edate", new Timestamp(edate.getTime()));
		
		String sql=DatabaseUtil.getSQL("sql/MachineVsWrapperSummary1.sql");

		
		List<MachineAndWrapperPM5> machineAndWrappers=new ArrayList<MachineAndWrapperPM5>();
		try {
			machineAndWrappers=jdbcTemplate.query(sql, parameterSource, new RowMapper<MachineAndWrapperPM5>(){

				@Override
				public MachineAndWrapperPM5 mapRow(ResultSet rs, int arg1)
						throws SQLException {
					MachineAndWrapperPM5 machineAndWrapper=new MachineAndWrapperPM5();
					//machineAndWrapper.setRollID(rs.getString("RollID"));
					machineAndWrapper.setDateEntered(new Date(rs.getTimestamp("DateEntered").getTime()));
					machineAndWrapper.setReelNumber(rs.getDouble("ReelNumber"));
					machineAndWrapper.setGradeCode(rs.getString("GradeCode"));
					machineAndWrapper.setReelWhiteWeight(rs.getDouble("ReelWhiteWeight"));
					machineAndWrapper.setReelRedWeight(rs.getDouble("ReelRedWeight"));
					machineAndWrapper.setReelRejectWeight(rs.getDouble("ReelRejectWeight"));
					machineAndWrapper.setTeam(rs.getString("Team"));
					
					
					//Wrapper data
					String yr = yearformat.format(machineAndWrapper.getDateEntered());
					String sql=DatabaseUtil.getSQL("sql/MachineVsWrapperSummary2.sql");
					MapSqlParameterSource parameterSource=new MapSqlParameterSource();
					parameterSource.addValue("reelNo", machineAndWrapper.getReelNumber());
					parameterSource.addValue("dateEntered", machineAndWrapper.getDateEntered());
					parameterSource.addValue("yr", yr);
					
					
					List<MachineAndWrapperPM5> wrappers=jdbcTemplate.query(sql, parameterSource, new RowMapper<MachineAndWrapperPM5>() {

						@Override
						public MachineAndWrapperPM5 mapRow(ResultSet rs, int arg1)
								throws SQLException {
							MachineAndWrapperPM5 wrapper=new MachineAndWrapperPM5();
							wrapper.setWrappedCount(rs.getDouble("WrappedCount"));
							wrapper.setWrappedWhite(rs.getDouble("WrappedWhite"));
							wrapper.setWrappedRed(rs.getDouble("WrappedRed"));
							wrapper.setWrappedReject(rs.getDouble("WrappedReject"));
							wrapper.setWrapperWidth(rs.getDouble("WrapperWidth"));
							
							return wrapper;
						}
					});
					
					if(wrappers.size()>0){
						MachineAndWrapperPM5 wrapper=wrappers.get(0);
						machineAndWrapper.setWrappedCount(wrapper.getWrappedCount());
						machineAndWrapper.setWrappedWhite(wrapper.getWrappedWhite());
						machineAndWrapper.setWrappedRed(wrapper.getWrappedRed());
						machineAndWrapper.setWrappedReject(wrapper.getWrappedReject());
						machineAndWrapper.setWrapperWidth(wrapper.getWrapperWidth());
						
					}
					
					
					
					
					machineAndWrapper.setMachReelWidth(rs.getDouble("MachReelWidth"));
					
					
					
					//Calculated
					machineAndWrapper.setReelSumTons(machineAndWrapper.getReelWhiteWeight()
						//	machineAndWrapper.getReelRedWeight()+
						//	machineAndWrapper.getReelRejectWeight()
						);
					
					machineAndWrapper.setWrappedSumLbs(machineAndWrapper.getWrappedWhite()+
							machineAndWrapper.getWrappedRed()+
							machineAndWrapper.getWrappedReject());
					machineAndWrapper.setWrappedSumTons(CommonUtil.round(machineAndWrapper.getWrappedSumLbs()/2000, 2));
					machineAndWrapper.setVariance(CommonUtil.round(machineAndWrapper.getReelSumTons()-machineAndWrapper.getWrappedSumTons(), 2));
					if(machineAndWrapper.getReelSumTons()!=0){
						double variancePerc=(machineAndWrapper.getVariance()/machineAndWrapper.getReelSumTons())*100;
						machineAndWrapper.setVariancePercent(CommonUtil.round(variancePerc, 2)+"%");
					}
					
					machineAndWrapper.setWidthVariance(machineAndWrapper.getMachReelWidth()-machineAndWrapper.getWrapperWidth());
					
					
					return machineAndWrapper;
				}
				
			});
		} catch (Exception e) {
			throw new ProductionException(e);
		}
		
		return machineAndWrappers;
	}

	/* (non-Javadoc)
	 * @see com.st.production.dao.MachineProductionSummaryDao#getMachineBreakFreeProduction(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public List<MachineProductionPM5> getMachineBreakFreeProduction(Date sdate,
			Date edate, String shift) {
		// TODO Auto-generated method stub
		
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSourceP);
		
		List<MachineProductionPM5> details=new ArrayList<MachineProductionPM5>();
		
		int days=(int)CommonUtil.getDaysDiffernce(sdate, edate);
		Calendar calendar=Calendar.getInstance();
		calendar.setTime(sdate);
		
		for (int i = 0; i <=days; i++) {
			Date dateS=calendar.getTime();
			
			Calendar scal=Calendar.getInstance();
			scal.setTime(dateS);
			scal.set(Calendar.HOUR_OF_DAY, 7);
			scal.set(Calendar.MINUTE, 0);
			scal.set(Calendar.SECOND, 0);
			scal.set(Calendar.MILLISECOND, 0);
			
			Calendar ecal=Calendar.getInstance();
			ecal.setTime(dateS);
			ecal.set(Calendar.HOUR_OF_DAY, 6);
			ecal.set(Calendar.MINUTE, 59);
			ecal.set(Calendar.SECOND, 59);
			ecal.set(Calendar.MILLISECOND, 0);
			ecal.add(Calendar.DATE, 1);
			
			
			try{
				String sql="";
				List<Map<String, Object>> maps=null;
				if(shift==""){
					sql="SELECT COUNT(*) As [Total_Rolls_Produce],a.[Shift],b.[Total_Rolls_With_Breaks],b.[RollID],b.[GradeCode]  FROM [production].[dbo].[tblMachineProduction] a "
							+ "INNER JOIN ( "
							+ "SELECT COUNT(*) As [Total_Rolls_With_Breaks],[Shift],[RollID],[GradeCode] FROM [production].[dbo].[tblMachineProduction]  "
							+ "Where ([DateTimeEntered] between ? and ? ) AND [MachineNumber] <> 'ZZZ' AND [NumberBreaks]>0  AND [MachineNumber]='TM5'"
							+ "Group By [tblMachineProduction].[Shift],[RollID],[GradeCode] ) as b on b.Shift=a.Shift "
							+ "Where (a.[DateTimeEntered] between ? and ? ) AND a.[MachineNumber] <> 'ZZZ'  AND [MachineNumber]='TM5'"
							+ "Group By a.[Shift],b.[Total_Rolls_With_Breaks],b.[RollID],b.[GradeCode]";
					maps=jdbcTemplate.queryForList(sql, new Object[]{
							scal.getTime(),
							ecal.getTime(),
							scal.getTime(),
							ecal.getTime()
							});
				}else{
					sql="SELECT COUNT(*) As [Total_Rolls_Produce],a.[Shift],b.[Total_Rolls_With_Breaks],b.[RollID],b.[GradeCode]  FROM [production].[dbo].[tblMachineProduction] a "
							+ "INNER JOIN ( "
							+ "SELECT COUNT(*) As [Total_Rolls_With_Breaks],[Shift],[RollID],[GradeCode] FROM [production].[dbo].[tblMachineProduction]  "
							+ "Where ([DateTimeEntered] between ? and ? ) AND [MachineNumber] <> 'ZZZ' AND [NumberBreaks]>0 And [Shift]=? AND [MachineNumber]='TM5' "
							+ "Group By [tblMachineProduction].[Shift],[RollID],[GradeCode] ) as b on b.Shift=a.Shift "
							+ "Where (a.[DateTimeEntered] between ? and ? ) AND a.[MachineNumber] <> 'ZZZ' AND [MachineNumber]='TM5' "
							+ "Group By a.[Shift],b.[Total_Rolls_With_Breaks],b.[RollID],b.[GradeCode]";
					maps=jdbcTemplate.queryForList(sql, new Object[]{
							scal.getTime(),
							ecal.getTime(),
							shift,
							scal.getTime(),
							ecal.getTime()
							
							});
				}
				
				
				double finalbreakfreeper=0;
				if(maps.size()>1){
					for (Map<String, Object> map : maps) {
						final MachineProductionPM5 data=new MachineProductionPM5();
						data.setDateEntered(dateS);
						
						int Total_Rolls_Produce=(Integer)map.get("Total_Rolls_Produce".toUpperCase());
						int Total_Rolls_With_Breaks=(Integer)map.get("Total_Rolls_With_Breaks".toUpperCase());
						String Shift=(String)map.get("Shift".toUpperCase());
						String RollID=(String)map.get("RollID".toUpperCase());
						String GradeCode=(String)map.get("GradeCode".toUpperCase());
						
						data.setNumberofrollswithbreaks(Total_Rolls_With_Breaks);
						data.setTotalrollsproduce(Total_Rolls_Produce);
						data.setShift(Shift);
						data.setRollID(RollID);
						data.setGradeCode(GradeCode);
						
						Integer obj1 = new Integer(Total_Rolls_With_Breaks);
						Integer obj2 = new Integer(Total_Rolls_Produce);
						 
						double d1 = obj1.doubleValue();
						double d2 = obj2.doubleValue();
						double cal1=(d1/d2)*100;
						double cal2=100-cal1;
					
						finalbreakfreeper=finalbreakfreeper+data.getPercentageofrollswithbreaks();
						data.setPercentageofrollswithbreaks(CommonUtil.round(cal2, 2));
						
						details.add(data);
						
					}
				}else if(maps.size()==1){
					for (Map<String, Object> map : maps) {
						final MachineProductionPM5 data=new MachineProductionPM5();
						data.setDateEntered(dateS);
						
						int Total_Rolls_Produce=(Integer)map.get("Total_Rolls_Produce".toUpperCase());
						int Total_Rolls_With_Breaks=(Integer)map.get("Total_Rolls_With_Breaks".toUpperCase());
						String Shift=(String)map.get("Shift".toUpperCase());
						String RollID=(String)map.get("RollID".toUpperCase());
						String GradeCode=(String)map.get("GradeCode".toUpperCase());
						
						data.setNumberofrollswithbreaks(Total_Rolls_With_Breaks);
						data.setTotalrollsproduce(Total_Rolls_Produce);
						data.setShift(Shift);
						data.setRollID(RollID);
						data.setGradeCode(GradeCode);
						
						Integer obj1 = new Integer(Total_Rolls_With_Breaks);
						Integer obj2 = new Integer(Total_Rolls_Produce);
						 
						double d1 = obj1.doubleValue();
						double d2 = obj2.doubleValue();
						double cal1=(d1/d2)*100;
						double cal2=100-cal1;
					
						finalbreakfreeper=finalbreakfreeper+data.getPercentageofrollswithbreaks();
						data.setPercentageofrollswithbreaks(CommonUtil.round(cal2, 2));
						/*
						if(shift.equalsIgnoreCase("Day")){
							data.setNumberofrollswithbreaks(0);
							data.setTotalrollsproduce(0);
							data.setShift("Night");
							data.setRollID("0");
							data.setGradeCode("0");
						}else if(shift.equalsIgnoreCase("Night")){
							data.setNumberofrollswithbreaks(0);
							data.setTotalrollsproduce(0);
							data.setShift("Day");
							data.setRollID("0");
							data.setGradeCode("0");
						}*/
						
						details.add(data);
						
					}
					//This Code Is To Show The One Day Data May Be It Day Or Night
					/*
					 	Code Starts From Here Done By Roshan Tailor Date 09/07/2016  
					 */
					for (Map<String, Object> map : maps) {
						
						
						
						if(shift==""){
							final MachineProductionPM5 data=new MachineProductionPM5();
							String Shift=(String)map.get("Shift".toUpperCase());
							if(Shift.equalsIgnoreCase("Day")){
								
								data.setDateEntered(dateS);
								data.setNumberofrollswithbreaks(0);
								data.setTotalrollsproduce(0);
								data.setShift("Night");
								data.setRollID("0");
								data.setGradeCode("0");
								data.setPercentageofrollswithbreaks(CommonUtil.round(100, 2));
							}else if(Shift.equalsIgnoreCase("Night")){
								data.setDateEntered(dateS);
								data.setNumberofrollswithbreaks(0);
								data.setTotalrollsproduce(0);
								data.setShift("Day");
								data.setRollID("0");
								data.setGradeCode("0");
								data.setPercentageofrollswithbreaks(CommonUtil.round(100, 2));
							}
							
							details.add(data);
							
						}else if(shift.equalsIgnoreCase("Day")){
							
						}else if(shift.equalsIgnoreCase("Night")){
							
						}else{
							
						}
						
					}
					/*
				 	Code Ends Here Done By Roshan Tailor Date 09/07/2016  
				 */
				}
				else if(maps.size()==0){
					
					if(shift.equalsIgnoreCase("Day")){
						
						for(int j=1;j<=1;j++){
							final MachineProductionPM5 data=new MachineProductionPM5();
							data.setDateEntered(dateS);
							if(j==1){
								data.setShift("Day");
								data.setNumberofrollswithbreaks(0);
								data.setTotalrollsproduce(0);
								
								data.setRollID("0");
								data.setGradeCode("0");
								data.setPercentageofrollswithbreaks(CommonUtil.round(100, 2));
							}
							details.add(data);
							
						}
					}else if(shift.equalsIgnoreCase("Night")){
						
						for(int j=1;j<=1;j++){
							final MachineProductionPM5 data=new MachineProductionPM5();
							data.setDateEntered(dateS);
							if(j==1){
								data.setShift("Night");
								data.setNumberofrollswithbreaks(0);
								data.setTotalrollsproduce(0);
								
								data.setRollID("0");
								data.setGradeCode("0");
								data.setPercentageofrollswithbreaks(CommonUtil.round(100, 2));
							}
							details.add(data);
						}
						
					}else if(shift==""){
						for(int j=1;j<=2;j++){
							final MachineProductionPM5 data=new MachineProductionPM5();
							data.setDateEntered(dateS);
							if(j==1){
								data.setShift("Day");
								data.setNumberofrollswithbreaks(0);
								data.setTotalrollsproduce(0);
								
								data.setRollID("0");
								data.setGradeCode("0");
								data.setPercentageofrollswithbreaks(CommonUtil.round(100, 2));
							}else if(j==2){
								data.setShift("Night");
								data.setNumberofrollswithbreaks(0);
								data.setTotalrollsproduce(0);
								data.setRollID("0");
								data.setGradeCode("0");
								data.setPercentageofrollswithbreaks(CommonUtil.round(100, 2));
							}
							details.add(data);
						}
					}
					
				}
				
			}catch(Exception rlt){
				rlt.printStackTrace();
				System.out.println("Hello Roshan..You Have An Problem In MachineProductionSummaryDaoImp.java File When You Are Fetching Report For BreakFreeRollPercentage");
			}
			//System.out.println(dateS);
			calendar.add(Calendar.DATE, 1);
		}
		return details;
	}

}

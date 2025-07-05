/**
 * 
 */
package com.st.productionpm5.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.joda.time.DateTime;
import org.joda.time.Days;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.st.common.CommonUtil;
import com.st.common.DatabaseUtil;
import com.st.common.exception.ProductionException;
import com.st.productionpm5.model.MachineAndWrapperPM5;
import com.st.productionpm5.model.MachineProductionPM5;

/**
 * @author sbora
 *
 */
@Repository
public class MachineProductionDaoImpPM5 implements MachineProductionDaoPM5 {

	@Autowired
	@Qualifier("dataSourceProduction")
	private DataSource dataSourceP;

	SimpleDateFormat dateFormat=new SimpleDateFormat("MM-dd-yyyy");
	SimpleDateFormat timeFormat=new SimpleDateFormat("HH:mm:sss");
	private SimpleDateFormat yearformat=new SimpleDateFormat("yyyy");

	@Override
	public List<MachineProductionPM5> getMachineProductions(Date sdate, Date edate) throws ProductionException {

		
		
		
		Calendar calendar=Calendar.getInstance();
		calendar.setTime(edate);
		calendar.add(Calendar.DATE, -1);
		
		
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSourceP);
		String sql="select "
				+ "[DateTimeEntered],"
				+ "[GoodWeight],"
				+ "[MachineSpeed],"
				+ "[GradeCode],"
				+ "[RejectedWeight],"
				+ "[Shift],"
				+ "[Comments]"
				+ " from [tblMachineProduction] where "
			
				+ "([DateEntered] between ? and ? "
				+ " or "	
				+ "[DateTimeEntered] between ? and ? ) AND  [MachineNumber]='TM5'"
				+ " order by [DateTimeEntered]";
		
		List<MachineProductionPM5> machineProductions=null;
		
	//	System.out.println(sql);
		
		try {
			machineProductions=jdbcTemplate.query(sql, new Object[]{
					new Timestamp(CommonUtil.checkDate(dateFormat.format(sdate), dateFormat).getTime()),
					new Timestamp(CommonUtil.checkDate(dateFormat.format(calendar.getTime()), dateFormat).getTime()),
					new Timestamp(sdate.getTime()),
					new Timestamp(edate.getTime())
					
			}, new RowMapper<MachineProductionPM5>() {

				@Override
				public MachineProductionPM5 mapRow(ResultSet rs, int arg1) throws SQLException {
					MachineProductionPM5 machineProduction=new MachineProductionPM5();
					Timestamp dateTime=rs.getTimestamp("DateTimeEntered");
					if(dateTime!=null){
						machineProduction.setDateTimeEntered(new Date(dateTime.getTime()));
					}
					
					machineProduction.setGoodWeight(rs.getDouble("GoodWeight"));
					machineProduction.setMachineSpeed(rs.getDouble("MachineSpeed"));
					machineProduction.setGradeCode(rs.getString("GradeCode"));
					machineProduction.setRejectedWeight(rs.getDouble("RejectedWeight"));
					machineProduction.setShift(rs.getString("Shift"));
					machineProduction.setComments(rs.getString("Comments"));
					
					return machineProduction;
				}
			});
		} catch (Exception e) {
			throw new ProductionException(e);
		}
		
		return machineProductions;
	}



	/* (non-Javadoc)
	 * @see com.st.production.dao.MachineProductionDao#getMachineProductionsByMonth(java.util.Date, java.util.Date)
	 */
	@Override
	public List<MachineProductionPM5> getMachineProductionsByMonth(Date sdate,
			Date edate) throws ProductionException {
		
		Calendar calendar=Calendar.getInstance();
		calendar.setTime(edate);
		calendar.add(Calendar.DATE, -1);
		
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSourceP);
		String sql="SELECT sum([GoodWeight]) as goodWg "
				
				+ " from [tblMachineProduction] where "
				+ "[DateEntered] between ? and ? "
				+ " or "
				+ "[TimeEntered] between ? and ? ";
		List<MachineProductionPM5> machineProductions=null;
		try {
			machineProductions=jdbcTemplate.query(sql, new Object[]{
					new Timestamp(CommonUtil.checkDate(dateFormat.format(sdate), dateFormat).getTime()),
					new Timestamp(CommonUtil.checkDate(dateFormat.format(calendar.getTime()), dateFormat).getTime()),
					new Timestamp(CommonUtil.checkDate(timeFormat.format(sdate), timeFormat).getTime()),
					new Timestamp(CommonUtil.checkDate(timeFormat.format(edate.getTime()), timeFormat).getTime()),
	
			}, new RowMapper<MachineProductionPM5>() {

				@Override
				public MachineProductionPM5 mapRow(ResultSet rs, int arg1) throws SQLException {
					MachineProductionPM5 machineProduction=new MachineProductionPM5();
					machineProduction.setGoodWeight(rs.getDouble("goodWg"));
					return machineProduction;
				}
			});
			
		} catch (Exception e) {
			throw new ProductionException(e);
		}
		return machineProductions;
	}



	/* (non-Javadoc)
	 * @see com.st.production.dao.MachineProductionDao#getMachineProductions(java.util.Date, java.util.Date, java.lang.String)
	 */
	@Override
	public List<MachineProductionPM5> getMachineProductions(Date sdate,
			Date edate, String shift) throws ProductionException {
		
	//	System.out.println(sdate);
	//	System.out.println(edate);
		
		Calendar calendar=Calendar.getInstance();
		calendar.setTime(edate);
		calendar.add(Calendar.DATE, -1);
		
		
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSourceP);
		
		Object [] param=null;
		
		String sql="select "
				+ "[DateTimeEntered],"
				+ "[GoodWeight],"
				+ "[MachineSpeed],"
				+ "[GradeCode],"
				+ "[RejectedWeight],"
				+ "[Shift],"
				+ "[Comments]"
				+ " from [tblMachineProduction] where "
				+ "( [DateEntered] between ? and ? "
				+ " OR "
				+ "[TimeEntered] between ? and ? ) AND [MachineNumber]='TM5' ";
				if(shift.equalsIgnoreCase("Day") || shift.equalsIgnoreCase("Night")){
					sql+=" and [Shift]=?";
					
					param=new Object[]{
							new Timestamp(CommonUtil.checkDate(dateFormat.format(sdate), dateFormat).getTime()),
							new Timestamp(CommonUtil.checkDate(dateFormat.format(calendar.getTime()), dateFormat).getTime()),
							new Timestamp(CommonUtil.checkDate(timeFormat.format(sdate), timeFormat).getTime()),
							new Timestamp(CommonUtil.checkDate(timeFormat.format(edate.getTime()), timeFormat).getTime()),
							
							shift
					};
					
				}else{
					param=new Object[]{
							new Timestamp(CommonUtil.checkDate(dateFormat.format(sdate), dateFormat).getTime()),
							new Timestamp(CommonUtil.checkDate(dateFormat.format(calendar.getTime()), dateFormat).getTime()),
							new Timestamp(CommonUtil.checkDate(timeFormat.format(sdate), timeFormat).getTime()),
							new Timestamp(CommonUtil.checkDate(timeFormat.format(edate.getTime()), timeFormat).getTime()),
			
					};
				}
				
				sql+=" order by [GradeCode]";
				
			//	System.out.println(sql);
				
				List<MachineProductionPM5> machineProductions=null;
				
		try {
			machineProductions=jdbcTemplate.query(sql, param, new RowMapper<MachineProductionPM5>() {

				@Override
				public MachineProductionPM5 mapRow(ResultSet rs, int arg1) throws SQLException {
					MachineProductionPM5 machineProduction=new MachineProductionPM5();
					Timestamp dateTime=rs.getTimestamp("DateTimeEntered");
					if(dateTime!=null){
						machineProduction.setDateTimeEntered(new Date(dateTime.getTime()));
					}

					machineProduction.setGoodWeight(rs.getDouble("GoodWeight"));
					machineProduction.setMachineSpeed(rs.getDouble("MachineSpeed"));
					machineProduction.setGradeCode(rs.getString("GradeCode"));
					machineProduction.setRejectedWeight(rs.getDouble("RejectedWeight"));
					machineProduction.setShift(rs.getString("Shift"));
					machineProduction.setComments(rs.getString("Comments"));
					
					return machineProduction;
				}
			});
		} catch (Exception e) {
			throw new ProductionException(e);
		}
		return machineProductions;
	}



	/* (non-Javadoc)
	 * @see com.st.production.dao.MachineProductionDao#getGradeAndHourData(java.util.Date, java.util.Date)
	 */
	@Override
	public List<Map<String, Object>> getGradeAndHourData(Date sdate, Date edate) throws ProductionException {
final JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSourceP);
		
		int days=Days.daysBetween(new DateTime(sdate.getTime()), new DateTime(edate.getTime())).getDays();
		
		 List<Map<String, Object>> datas=new ArrayList<Map<String,Object>>();
		
		 SimpleDateFormat dateFormat=new SimpleDateFormat("MM-dd-yyyy");
		 
		
		for(int i=0;i<days+1;i++){
			
			final Calendar scal=Calendar.getInstance();
			scal.setTime(sdate);
			scal.set(Calendar.HOUR_OF_DAY, 7);
			scal.set(Calendar.MINUTE, 0);
			scal.set(Calendar.SECOND, 0);
			scal.set(Calendar.MILLISECOND, 0);
			
			final Calendar ecal=Calendar.getInstance();
			ecal.setTime(sdate);
			ecal.set(Calendar.HOUR_OF_DAY, 6);
			ecal.set(Calendar.MINUTE, 59);
			ecal.set(Calendar.SECOND, 59);
			ecal.set(Calendar.MILLISECOND, 0);
			ecal.add(Calendar.DATE, 1);
			
		//	System.out.println(scal.getTime());
		//	System.out.println(ecal.getTime());
			
			
			try {
				String sql="select m.[DateEntered],max(m.[MachineSpeed]) as MachineSpeed,"
						+ "sum(ISNULL(m.[GoodWeight],0)) as GoodWeight, "
						+ "sum(ISNULL(m.[RedWeight],0)) as RedWeight, "
						+ "sum(ISNULL(m.[RejectedWeight],0)) as RejectedWeight, "
						+ "m.[GradeCode], max(g.[TBDRate]) as TBDRate "
						+ " from [tblMachineProduction] m, tlkpGradeCode AS g where  "
						+ " m.[DateTimeEntered] between ? and ? "
						+ " And  (g.GradeCode=m.GradeCode)   and m.MachineNumber='TM5' "
						+ " group by m.[DateEntered],m.[GradeCode]  "
						+ " order by m.[DateEntered] ";
				
				
			//	System.out.println(sql);
				
				List<MachineProductionPM5> machineProductions=jdbcTemplate.query(sql, new Object[]{
						new Timestamp(ecal.getTime().getTime()),
						new Timestamp(scal.getTime().getTime())
				}, new RowMapper<MachineProductionPM5>() {

					@Override
					public MachineProductionPM5 mapRow(ResultSet rs, int arg1) throws SQLException {
						MachineProductionPM5 machineProduction=new MachineProductionPM5();
						machineProduction.setDateEntered(new Date(rs.getTimestamp("DateEntered").getTime()));
						machineProduction.setGoodWeight(rs.getDouble("GoodWeight"));
						machineProduction.setMachineSpeed(rs.getDouble("MachineSpeed"));
						machineProduction.setRejectedWeight(rs.getDouble("RejectedWeight"));
						machineProduction.setRedWeight(rs.getDouble("RedWeight"));
						machineProduction.setGradeCode(rs.getString("GradeCode"));
						machineProduction.setTbdRate(rs.getDouble("TBDRate"));
						
						
						return machineProduction;
					}
				});
			
			//	System.out.println(machineProductions.size());
				
				double totalGross=0;
				for (MachineProductionPM5 machineProduction : machineProductions) {
					totalGross+=machineProduction.getGoodWeight()/2000 +machineProduction.getRedWeight()/2000+machineProduction.getRejectedWeight()/2000;
				}
				
				double totalNet=totalGross*0.99;
				
				for (MachineProductionPM5 machineProduction : machineProductions) {
					
					
					Map<String, Object> map=new HashMap<String, Object>();
					
					double whiteGross=machineProduction.getGoodWeight()/2000;
					double whiteNet=whiteGross*0.99;
					
					double redGross=machineProduction.getRedWeight()/2000;
					double redNet=redGross*0.99;
					
					double rejectGross=machineProduction.getRejectedWeight()/2000;
					double rejectNet=rejectGross*0.99;
					
					double grossWrapped=whiteGross;
					double netWrapped=whiteNet;
					
					
					
					if(machineProduction.getDateEntered()!=null){
						map.put("DateEntered", dateFormat.format(machineProduction.getDateEntered()));	
					}else{
						map.put("DateEntered", "");
					}
					map.put("GradeCode", machineProduction.getGradeCode());
					map.put("MachineSpeed", machineProduction.getMachineSpeed());
					
					map.put("WhiteGross",CommonUtil.round(whiteGross, 2));
					map.put("WhiteNet",CommonUtil.round( whiteNet, 2));
					map.put("RedGross",CommonUtil.round( redGross, 2));
					map.put("RedNet",CommonUtil.round( redNet, 2));
					map.put("RejectGross",CommonUtil.round(rejectGross, 2));
					map.put("RejectNet",CommonUtil.round(rejectNet, 2));
					map.put("GrossWrapped",CommonUtil.round( grossWrapped, 2));
					map.put("NetWrapped",CommonUtil.round( netWrapped, 2));
					
					double hrs=0;
					if(totalGross>0){
						hrs=((whiteGross+redGross+rejectGross)/totalGross)*24;
					}
					map.put("HoursSpent",CommonUtil.round( hrs, 2));
					map.put("NetTonsPerHour",CommonUtil.round( totalNet/24, 2));
					map.put("NetTonsPerDay",CommonUtil.round( totalNet, 2));
					
					map.put("TBDRate",machineProduction.getTbdRate());
					
					double targetTon=(machineProduction.getTbdRate()*hrs)/24;
					
					map.put("TargetTonsCalc",CommonUtil.round(targetTon, 2));
					
					double effic=0;
					if(targetTon!=0){
						effic=(whiteNet)/targetTon;
					}
					
					map.put("EfficiencyCalc",CommonUtil.round(effic*100, 2));
										
					
					datas.add(map);
					
					
				}
			} catch (Exception e) {
				e.printStackTrace();
				throw new ProductionException(e);
			}
				
				



		
			
			sdate=ecal.getTime();
		}
		
		
		return datas;	
		
		
		
	}



	/* (non-Javadoc)
	 * @see com.st.production.dao.MachineProductionDao#getMachineAndWrapper(java.util.Date, java.util.Date)
	 */
	@Override
	public List<MachineAndWrapperPM5> getMachineAndWrapper(Date sdate, Date edate) throws ProductionException {
		final NamedParameterJdbcTemplate jdbcTemplate=new NamedParameterJdbcTemplate(dataSourceP);
		MapSqlParameterSource parameterSource=new MapSqlParameterSource();
		parameterSource.addValue("sdate", new Timestamp(sdate.getTime()));
		parameterSource.addValue("edate", new Timestamp(edate.getTime()));
		
		String sql=DatabaseUtil.getSQL("sql/MachineVsWrapperPM5.sql");

		
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
					
					
					
					//Wrapper data
					String yr = yearformat.format(machineAndWrapper.getDateEntered());
					//System.out.println("yr"+yr);
					String sql=DatabaseUtil.getSQL("sql/MachineVsWrapper2.sql");
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
	 * @see com.st.production.dao.MachineProductionDao#getMachineProductionsForRollBreak(java.util.Date, java.util.Date, java.lang.String)
	 */
	@Override
	public List<MachineProductionPM5> getMachineProductionsForRollBreak(Date sdate,
			Date edate, String shift,int brakSize) throws ProductionException {
		// TODO Auto-generated method stub
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSourceP);
		Object[] param=null;
		 
		String sql="";
		List<MachineProductionPM5> machineProductions=null;
		if(brakSize>0){
			if(shift.equalsIgnoreCase("Day")|| shift.equalsIgnoreCase("Night")){
				sql="SELECT COUNT(*) As [Total_Rolls_Produce],a.[Shift],b.[Total_Rolls_With_Breaks]   "
						+ "FROM [production].[dbo].[tblMachineProduction] a "
						+ "INNER JOIN ( "
						+ "SELECT COUNT(*) As [Total_Rolls_With_Breaks],[Shift]   "
						+ "FROM [production].[dbo].[tblMachineProduction]  "
						+ "Where ([DateTimeEntered] between ? and ? )  "
						+ "AND [MachineNumber] <> 'ZZZ' AND [NumberBreaks]>0 and [Shift]=? AND [MachineNumber]='TM5' "
						+ "Group By [tblMachineProduction].[Shift] "
						+ ") as b on b.Shift=a.Shift "
						+ "Where (a.[DateTimeEntered] between ? and ? )  "
						+ "AND a.[MachineNumber] <> 'ZZZ'   AND [MachineNumber]='TM5'  "
						+ "Group By a.[Shift],b.[Total_Rolls_With_Breaks] ";
						param=new Object[]{
								new Timestamp(sdate.getTime()),
								new Timestamp(edate.getTime()),
								shift,
								new Timestamp(sdate.getTime()),
								new Timestamp(edate.getTime())
							};
			}else{
				sql="SELECT COUNT(*) As [Total_Rolls_Produce],a.[Shift],b.[Total_Rolls_With_Breaks]  "
						+ "FROM [production].[dbo].[tblMachineProduction] a "
						+ "INNER JOIN ( "
						+ "SELECT COUNT(*) As [Total_Rolls_With_Breaks],[Shift]   "
						+ "FROM [production].[dbo].[tblMachineProduction]  "
						+ "Where ([DateTimeEntered] between ? and ? )  "
						+ "AND [MachineNumber] <> 'ZZZ' AND [NumberBreaks]>0 AND [MachineNumber]='TM5'  "
						+ "Group By [tblMachineProduction].[Shift] "
						+ ") as b on b.Shift=a.Shift "
						+ "Where (a.[DateTimeEntered] between ? and ? )  "
						+ "AND a.[MachineNumber] <> 'ZZZ'    AND [MachineNumber]='TM5' "
						+ "Group By a.[Shift],b.[Total_Rolls_With_Breaks]";
						param=new Object[]{
								new Timestamp(sdate.getTime()),
								new Timestamp(edate.getTime()),
								new Timestamp(sdate.getTime()),
								new Timestamp(edate.getTime())
							};
			}
			
			
			try{

				machineProductions=jdbcTemplate.query(sql,
						param, 
						new RowMapper<MachineProductionPM5>(){

							@Override
							public MachineProductionPM5 mapRow(ResultSet rs, int arg1)
									throws SQLException {
								
								MachineProductionPM5 macineProduction=new MachineProductionPM5();
								macineProduction.setNumberofrollswithbreaks(rs.getInt("Total_Rolls_With_Breaks"));
								macineProduction.setShift(rs.getString("Shift"));
								macineProduction.setTotalrollsproduce(rs.getInt("Total_Rolls_Produce"));
								
								//Apply % Calculation For Break Free
								int totalRoll=rs.getInt("Total_Rolls_With_Breaks");
								
								double finalbreakfreeper=0;
								double toatlpercentage;
								double hundrad =100;
								
								if(totalRoll>0){
									macineProduction.setNumberofrollswithbreaks(rs.getInt("Total_Rolls_With_Breaks"));
									macineProduction.setTotalrollsproduce(rs.getInt("Total_Rolls_Produce"));
									int totalRollBreaks=rs.getInt("Total_Rolls_With_Breaks");
									int totalRollProduse=rs.getInt("Total_Rolls_Produce");
									
									Integer obj1 = new Integer(totalRollBreaks);
									Integer obj2 = new Integer(totalRollProduse);
									 
									double d1 = obj1.doubleValue();
									double d2 = obj2.doubleValue();
									double cal1=(d1/d2)*100;
									//System.out.println(cal1);
									double cal2=100-cal1;
								
									finalbreakfreeper=finalbreakfreeper+macineProduction.getPercentageofrollswithbreaks();
									macineProduction.setPercentageofrollswithbreaks(CommonUtil.round(cal2, 2));
									 
								}else{
									macineProduction.setPercentageofrollswithbreaks(hundrad);
								}
								//Calculation Ends Here
								return macineProduction;
							}
					
						});
			
			}catch(Exception rlt){
				System.out.println("You Have Problem In MachineProducationDaoImp.java");
				rlt.printStackTrace();
			}
		}else{
			

			
			
			if(shift.equalsIgnoreCase("Day")|| shift.equalsIgnoreCase("Night")){
				sql="SELECT COUNT(*) As [Total_Rolls_Produce],a.[Shift] "
						+ "FROM [production].[dbo].[tblMachineProduction] a "
						+ "Where (a.[DateTimeEntered] between ? and ? )   "
						+ "AND a.[MachineNumber] <> 'ZZZ'   and [Shift]=? AND [MachineNumber]='TM5' "
						+ "Group By a.[Shift]";
						param=new Object[]{
							new Timestamp(sdate.getTime()),
							new Timestamp(edate.getTime()),
							shift
						};
				}else{
					sql=" SELECT COUNT(*) As [Total_Rolls_Produce],a.[Shift] "
							+ "FROM [production].[dbo].[tblMachineProduction] a"
							+ " Where (a.[DateTimeEntered] between ? and ? )   "
							+ "AND a.[MachineNumber] <> 'ZZZ' AND [MachineNumber]='TM5'  "
							+ "Group By a.[Shift]";
							param=new Object[]{
								new Timestamp(sdate.getTime()),
								new Timestamp(edate.getTime())
							};
				}
			
			
			
			try {
				machineProductions=jdbcTemplate.query(sql,
						param, 
						new RowMapper<MachineProductionPM5>(){

							@Override
							public MachineProductionPM5 mapRow(ResultSet rs, int arg1)
									throws SQLException {
								
								MachineProductionPM5 wrapperProduction=new MachineProductionPM5();
								wrapperProduction.setShift(rs.getString("Shift"));
								wrapperProduction.setTotalrollsproduce(rs.getInt("Total_Rolls_Produce"));
								
								double hundrad =100;
								 
									wrapperProduction.setPercentageofrollswithbreaks(hundrad);
								//Calculation Ends Here
								return wrapperProduction;
							}
							
						});
			} catch (Exception e) {
				throw new ProductionException(e);
			}
		
			
		}
		
		
		return machineProductions;
	}



	/* (non-Javadoc)
	 * @see com.st.production.dao.MachineProductionDao#checkMachineProductionsForRollBreak(java.util.Date, java.util.Date, java.lang.String)
	 */
	@Override
	public List<MachineProductionPM5> checkMachineProductionsForRollBreak(
			Date sdate, Date edate, String shift) {
		
		
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSourceP);
		Object[] param=null;
		String sql;
		 
			sql=" SELECT COUNT(*) As [Total_Rolls_With_Breaks],[Shift]    "
					+ "FROM [production].[dbo].[tblMachineProduction]   "
					+ "Where ([DateTimeEntered] between ? and ? )   "
					+ "AND [MachineNumber] <> 'ZZZ' AND [NumberBreaks]>0  AND [MachineNumber]='TM5'  "
					+ "Group By [tblMachineProduction].[Shift] ";
					param=new Object[]{
						new Timestamp(sdate.getTime()),
						new Timestamp(edate.getTime())
					};
			 
			List<MachineProductionPM5> wrapperProductions=null;
			try {
				wrapperProductions=jdbcTemplate.query(sql,
						param, 
						new RowMapper<MachineProductionPM5>(){

							@Override
							public MachineProductionPM5 mapRow(ResultSet rs, int arg1)
									throws SQLException {
								
								MachineProductionPM5 wrapperProduction=new MachineProductionPM5();
								wrapperProduction.setNumberofrollswithbreaks(rs.getInt("Total_Rolls_With_Breaks"));
								wrapperProduction.setShift(rs.getString("Shift"));
								return wrapperProduction;
							}
							
						});
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return wrapperProductions;
		}


}

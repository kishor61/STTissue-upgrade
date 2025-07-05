/**
 * 
 */
package com.st.frppressquality.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.sql.DataSource;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.st.common.CommonUtil;
import com.st.frppressquality.mapper.FrpPressQualityMapper;
import com.st.frppressquality.model.FrpDailyData;
import com.st.frppressquality.model.FrpPressQuality;
import com.st.frppressquality.model.SludgeHauling;
import com.st.frppressquality.model.StickiesData;
import com.st.frpproduction.model.FrpProdcution;

/**
 * @author sbora
 *
 */
@Repository
public class FrpPressQualityDaoImp implements FrpPressQualityDao {
	
	private static final Logger logger=LoggerFactory.getLogger(FrpPressQualityDaoImp.class);
	
	@Autowired
	private DataSource dataSource;

	
	/* (non-Javadoc)
	 * @see com.st.frppressquality.dao.FrpPressQualityDao#save(com.st.frppressquality.model.FrpPressQuality)
	 */
	@Override
	public int save(final FrpPressQuality frpPressQuality) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		KeyHolder keyHolder=new GeneratedKeyHolder();
		
		final String sql="insert into [frpPressQualityData]"
				+ "("
				+"[Date],"
				+"[Lot],"
				+"[Initials],"
//				Code Starts From Here Done By Roshan Tailor
				+"[Bleachingchemical],"
//				Code Ends Here Done By Roshan Tailor
				+"[Grade],"
				+"[Brightness],"
//				Code Starts From Here Done By Roshan Tailor Date ;- 03/30/2015 MM/DD/YYYY
				+"[LValue],"
				+"[aValue],"
				+"[bValue],"
//				Code Ends Here Done By Roshan Tailor
				+"[Dirt],"
				+"[Stickies],"
				+"[Consistency],"
				+"[Ash],"
				+"[CURunning],"
				+"[Comments],"
				+"[QualityType],"
				+"[Freeness],"
//				Code Starts From Here Done By Roshan Tailor Date :- 03/24/2015 MM/DD/YYYY
				+"[Eric],"
				+"[Astar],"
				+"[Bstar],"
				+"[line] "
//				Code Ends Here Done By Roshan Tailor.
				+ ")"
				+ " values("
				+ "?,?,?,?,"
				+ "?,?,?,?,?,?,?,"//Here Roshan Tailor Added 3 ? Date :- 03/30/2015
								+ "?,?,?,?,?,?,?,?,?,?"					//Roshan Added 3 ? Here
				+ ")";
		
		jdbcTemplate.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection arg0)
					throws SQLException {
				PreparedStatement statement=arg0.prepareStatement(sql,new String[]{"ID"});
				statement.setTimestamp(1, new Timestamp(frpPressQuality.getDate().getTime()));
				statement.setInt(2,frpPressQuality.getLot());
				statement.setString(3,frpPressQuality.getInitials());
//				Code Starts From Here Done BY Roshan Tailor DAte :- 04/01/2015
				statement.setDouble(4, frpPressQuality.getBleachingchemical());
//				Code Ends Here Done By Roshan Tailor
				statement.setString(5,frpPressQuality.getGrade());
				statement.setDouble(6,frpPressQuality.getBrightness());
//				Code Starts From Here Done By Roshan Tailor Date ;- 03/30/2015
				statement.setDouble(7, frpPressQuality.getLvalue());
				statement.setDouble(8, frpPressQuality.getAvalue());
				statement.setDouble(9, frpPressQuality.getBvalue());
//				Code Ends Here Done By Roshan Tailor
				statement.setDouble(10,frpPressQuality.getDirt());
				statement.setDouble(11,frpPressQuality.getStickies());
				statement.setDouble(12,frpPressQuality.getConsistency());
				statement.setDouble(13,frpPressQuality.getAsh());
				statement.setString(14,frpPressQuality.getCuRunning());
				statement.setString(15,frpPressQuality.getComments());
				statement.setString(16,frpPressQuality.getQualityType());
				statement.setDouble(17, frpPressQuality.getFreeness());
//				Code Starts From Here Done By Roshan Tailor Date :- 03/24/2015 MM/DD/YYYY
				statement.setDouble(18, frpPressQuality.getEric());
				statement.setString(19, frpPressQuality.getAstar());
				statement.setString(20, frpPressQuality.getBstar());
				statement.setString(21, frpPressQuality.getLine());
//				Code Ends Here Done By Roshan Tailor 

				return statement;
			}
		},keyHolder);
		
		return keyHolder.getKey().intValue();
	}

	/* (non-Javadoc)
	 * @see com.st.frppressquality.dao.FrpPressQualityDao#update(com.st.frppressquality.model.FrpPressQuality)
	 */
	@Override
	public void update(final FrpPressQuality frpPressQuality) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		final String sql="update [frpPressQualityData] set "
				+"[Date]=?,"
				+"[Lot]=?,"
				+"[Initials]=?,"
//				Code Starts From Here Done By Roshan Tailor DAte ;- 04/01/2015
				+"[Bleachingchemical]=?,"
//				Code Ends Hre Done By Roshan Tailor
				+"[Grade]=?,"
				+"[Brightness]=?,"
//				Code Starts From Here Done By Roshan Tailor Date ;- 03/30/2015 MM/DD/YYYY
				+"[LValue]=?,"
				+"[aValue]=?,"
				+"[bValue]=?,"
//				Code Ends Here Done By Roshan Tailor
				+"[Dirt]=?,"
				+"[Stickies]=?,"
				+"[Consistency]=?,"
				+"[Ash]=?,"
				+"[CURunning]=?,"
				+"[Comments]=?,"
				+"[QualityType]=?,"
				+"[Freeness]=?,"
//				Code Starts From Here Done By Roshan Tailor Date :- 03/24/2015 MM/DD/YYYY
				+"[Eric]=?,"
				+"[Astar]=?,"
				+"[Bstar]=?,"
				+"[line]=?"
//				Code Ends Here Done By Roshan Tailor
				+ " where [ID]=?";
		
		jdbcTemplate.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection arg0)
					throws SQLException {
				PreparedStatement statement=arg0.prepareStatement(sql);
				statement.setTimestamp(1, new Timestamp(frpPressQuality.getDate().getTime()));
				statement.setInt(2,frpPressQuality.getLot());
				statement.setString(3,frpPressQuality.getInitials());
//				Code Starts From Here Done BY Roshan Tailor Date :- 04/01/2015
				statement.setDouble(4, frpPressQuality.getBleachingchemical());
//				Code Ends Here Done By Roshan Tailor
				statement.setString(5,frpPressQuality.getGrade());
				statement.setDouble(6,frpPressQuality.getBrightness());
//				Code Starts From Here Done By Roshan Tailor Date :- 03/30/2015
				statement.setDouble(7,frpPressQuality.getLvalue());
				statement.setDouble(8,frpPressQuality.getAvalue());
				statement.setDouble(9,frpPressQuality.getBvalue());
//				Code Ends Here Done By Roshan Tailor
				statement.setDouble(10,frpPressQuality.getDirt());
				statement.setDouble(11,frpPressQuality.getStickies());
				statement.setDouble(12,frpPressQuality.getConsistency());
				statement.setDouble(13,frpPressQuality.getAsh());
				statement.setString(14,frpPressQuality.getCuRunning());
				statement.setString(15,frpPressQuality.getComments());
				statement.setString(16,frpPressQuality.getQualityType());
				statement.setDouble(17, frpPressQuality.getFreeness());
//				Code Starts From Here Done By Roshan Tailor Date:-03/24/2015
				statement.setDouble(18, frpPressQuality.getEric());
				statement.setString(19, frpPressQuality.getAstar());
				statement.setString(20, frpPressQuality.getBstar());
				statement.setString(21, frpPressQuality.getLine());
//				Code Ends Here Done By Roshan Tailor
				statement.setInt(22,frpPressQuality.getId());  //Before Here Was 14 Now 17


				return statement;
			}
		});
		
	}

	
	@Override
	public List<FrpPressQuality> getFrpPressQualities(Date sdate, Date edate,
			String type) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		
		Calendar scal=Calendar.getInstance();
		scal.setTime(sdate);
		
		Calendar ecal=Calendar.getInstance();
		ecal.setTime(edate);
		ecal.add(Calendar.DATE, 1);
		
		
		String sql="select * from [frpPressQualityData] where "
				+ "([Date] between ? and ?) and [QualityType]=? "
				+ " order by [Date]";
		List<FrpPressQuality> frpPressQualities=jdbcTemplate.query(sql, new Object[]{
				new Timestamp(scal.getTime().getTime()),
				new Timestamp(ecal.getTime().getTime()),
				type
		},new FrpPressQualityMapper());
		
		return frpPressQualities;
	}

	/* (non-Javadoc)
	 * @see com.st.frppressquality.dao.FrpPressQualityDao#isExist(com.st.frppressquality.model.FrpPressQuality)
	 */
	@Override
	public boolean isLotExist(FrpPressQuality frpPressQuality) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		String sql="select count(*) from [frpPressQualityData] where [Lot]=?";
		int count=jdbcTemplate.queryForObject(sql, new Object[]{frpPressQuality.getLot()}, Integer.class);
		
		if(frpPressQuality.getId()==0){
			if(count>0){
				return true;
			}else{
				return false;
			}
		}else{
			if(count==1){
				String sql2="select * from [frpPressQualityData] where [ID]=?";
				FrpPressQuality pressQuality=jdbcTemplate.queryForObject(sql2, new Object[]{frpPressQuality.getId()}, new FrpPressQualityMapper());
				if(pressQuality.getLot()==frpPressQuality.getLot()){
					return false;
				}else{
					return true;
				}
				
			}else{
				return false;
			}
			
		}
	}

	/* (non-Javadoc)
	 * @see com.st.frppressquality.dao.FrpPressQualityDao#delete(int)
	 */
	@Override
	public void delete(int id) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		String sql="delete from [frpPressQualityData] where [ID]=?";
		jdbcTemplate.update(sql, new Object[]{id});
		
	}

	/* (non-Javadoc)
	 * @see com.st.frppressquality.dao.FrpPressQualityDao#getFrpPressQuality(int)
	 */
	@Override
	public FrpPressQuality getFrpPressQuality(int id) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		String sql2="select * from [frpPressQualityData] where [ID]=?";
		FrpPressQuality pressQuality=jdbcTemplate.queryForObject(sql2, new Object[]{id}, new FrpPressQualityMapper());
		return pressQuality;
	}

	/* (non-Javadoc)
	 * @see com.st.frppressquality.dao.FrpPressQualityDao#getBirghtnessAvgOfDay()
	 */
	@Override
	public double getBirghtnessAvgOfDay() {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		
		Calendar sCal=Calendar.getInstance();
		sCal.setTime(CommonUtil.getShiftDate());
		sCal.set(Calendar.HOUR_OF_DAY, 7);
		sCal.set(Calendar.MINUTE, 0);
		sCal.set(Calendar.SECOND, 0);
		sCal.set(Calendar.MILLISECOND, 0);
		//sCal.add(Calendar.DATE, -1);
		
		Calendar eCal=Calendar.getInstance();
		eCal.setTime(new Date());
		
		
		String sql="SELECT avg([Brightness]) "
				+ "FROM frpPressQualityData where "
				+ "[QualityType]='TPQ' "
				+ "and "
				+ "[Brightness]>0 "
				+ "and "
				+ "[Date] between ? and ? ";
		Double avg=0d;
		try {
			avg=jdbcTemplate.queryForObject(sql, new Object[]{
				new Timestamp(sCal.getTime().getTime()),
				new Timestamp(eCal.getTime().getTime())
			}, Double.class);
			if(avg==null){
				avg=0d;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return avg;
	}

	/* (non-Javadoc)
	 * @see com.st.frppressquality.dao.FrpPressQualityDao#getBirghtnessAvgOfLastDay()
	 */
	@Override
	public double getBirghtnessAvgByDate(Date date) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		
		Calendar sCal=Calendar.getInstance();
		sCal.setTime(date);
		sCal.set(Calendar.HOUR_OF_DAY, 7);
		sCal.set(Calendar.MINUTE, 0);
		sCal.set(Calendar.SECOND, 0);
		sCal.set(Calendar.MILLISECOND, 0);
		sCal.add(Calendar.DATE, -1);
		
		Calendar eCal=Calendar.getInstance();
		eCal.setTime(date);
		eCal.set(Calendar.HOUR_OF_DAY, 6);
		eCal.set(Calendar.MINUTE, 59);
		eCal.set(Calendar.SECOND, 59);
		eCal.set(Calendar.MILLISECOND, 0);
		
		
		String sql="SELECT avg([Brightness]) "
				+ "FROM frpPressQualityData where "
				+ "[QualityType]='TPQ' "
				+ "and "
				+ "[Brightness]>0 "
				+ "and "
				+ "[Date] between ? and ? ";
		Double avg=0d;
		try {
			avg=jdbcTemplate.queryForObject(sql, new Object[]{
				new Timestamp(sCal.getTime().getTime()),
				new Timestamp(eCal.getTime().getTime())
			}, Double.class);
			if(avg==null){
				avg=0d;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return avg;
	}
	
	/*
	 *  Code changed 
	 *  Calculate last entry from database
	 * */
	
	@Override
	public double getBirghtnessAvgOfLastDay() {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		
	/*	Calendar sCal=Calendar.getInstance();
		sCal.setTime(CommonUtil.getShiftDate());
		sCal.set(Calendar.HOUR_OF_DAY, 7);
		sCal.set(Calendar.MINUTE, 0);
		sCal.set(Calendar.SECOND, 0);
		sCal.set(Calendar.MILLISECOND, 0);
		sCal.add(Calendar.DATE, -1);
		
		Calendar eCal=Calendar.getInstance();
		eCal.setTime(new Date());*/
	//TODO	
		
				String sql="SELECT TOP 1 [Brightness] FROM frpPressQualityData where [Brightness]>0 And [QualityType]='TPQ2' order by [Date] desc ";
		Double avg=0d;
		try {
			avg=jdbcTemplate.queryForObject(sql, Double.class);
			if(avg==null){
				avg=0d;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return avg;
	}
	
	
	
	@Override
	public double getSludgConsistencyAvg(Date date) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		
		Calendar sCal=Calendar.getInstance();
		sCal.setTime(date);
		sCal.set(Calendar.HOUR_OF_DAY, 7);
		sCal.set(Calendar.MINUTE, 0);
		sCal.set(Calendar.SECOND, 0);
		sCal.set(Calendar.MILLISECOND, 0);
		
		Calendar eCal=Calendar.getInstance();
		eCal.setTime(date);
		eCal.set(Calendar.HOUR_OF_DAY, 6);
		eCal.set(Calendar.MINUTE, 59);
		eCal.set(Calendar.SECOND, 59);
		eCal.set(Calendar.MILLISECOND, 0);
		eCal.add(Calendar.DATE, 1);
		
		String sql="SELECT avg([Consistency]) "
				+ "FROM frpPressQualityData where "
				+ "[QualityType]='SPC' "
				+ "and "
				+ "[Consistency]>0 "
				+ "and "
				+ "[Date] between ? and ? ";
		Double avg=0d;
		try {
			avg=jdbcTemplate.queryForObject(sql, new Object[]{
				new Timestamp(sCal.getTime().getTime()),
				new Timestamp(eCal.getTime().getTime())
			}, Double.class);
			if(avg==null){
				avg=0d;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return avg;
	}

	/* (non-Javadoc)
	 * @see com.st.frppressquality.dao.FrpPressQualityDao#saveOrUpdate(com.st.frppressquality.model.SludgeHauling)
	 */
	@Override
	public int saveOrUpdate(final SludgeHauling sludgeHauling) {
		int id=0;
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		
		if(sludgeHauling.getId()==0){
			KeyHolder keyHolder=new GeneratedKeyHolder();
			final String sql="insert into [sludgeHauling]("
					+ "[Date],"
					+ "[Grade],"
					+ "[SludgeHauled],"
					+ "[SludgeConsistency],"
					+ "[RejectsBwHauled],"
					+ "[RejectsBwConsistency],"
					+ "[FrpSludgePressRunning],"
					+ "[FrpScrewPressRunning],"
					+ "[EffluentConsistency],"
					+ "[coddischarge]"
					+ ") values(?,?,?,?,?,?,?,?,?,?)";
			
			
			jdbcTemplate.update(new PreparedStatementCreator() {
				
				@Override
				public PreparedStatement createPreparedStatement(Connection arg0)
						throws SQLException {
					PreparedStatement statement=arg0.prepareStatement(sql, new String[]{"ID"});
					
					statement.setTimestamp(1, new Timestamp(sludgeHauling.getDate().getTime()));
					statement.setString(2, sludgeHauling.getGrade());
					statement.setDouble(3, sludgeHauling.getSludgeHauled());
					statement.setDouble(4, sludgeHauling.getSludgeConsistency());
					statement.setDouble(5, sludgeHauling.getRejectsBwHauled());
					statement.setDouble(6, sludgeHauling.getRejectsBwConsistency());
					statement.setString(7, sludgeHauling.getFrpSludgePressRunning());
					statement.setString(8, sludgeHauling.getFrpScrewPressRunning());
					statement.setDouble(9, sludgeHauling.getEffluentConsistency());
					statement.setDouble(10, sludgeHauling.getCoddischarge());
					
					return statement;
				}
			},keyHolder);
			id=keyHolder.getKey().intValue();
			
		}else{
			final String sql="update [sludgeHauling] set "
					+ "[Date]=?,"
					+ "[Grade]=?,"
					+ "[SludgeHauled]=?,"
					+ "[SludgeConsistency]=?,"
					+ "[RejectsBwHauled]=?,"
					+ "[RejectsBwConsistency]=?,"
					+ "[FrpSludgePressRunning]=?,"
					+ "[FrpScrewPressRunning]=?,"
					+ "[EffluentConsistency]=?,"
					+ "[coddischarge]=?  "
					+ " where [ID]=? ";
			
			
			jdbcTemplate.update(new PreparedStatementCreator() {
				
				@Override
				public PreparedStatement createPreparedStatement(Connection arg0)
						throws SQLException {
					PreparedStatement statement=arg0.prepareStatement(sql);
					
					statement.setTimestamp(1, new Timestamp(sludgeHauling.getDate().getTime()));
					statement.setString(2, sludgeHauling.getGrade());
					statement.setDouble(3, sludgeHauling.getSludgeHauled());
					statement.setDouble(4, sludgeHauling.getSludgeConsistency());
					statement.setDouble(5, sludgeHauling.getRejectsBwHauled());
					statement.setDouble(6, sludgeHauling.getRejectsBwConsistency());
					statement.setString(7, sludgeHauling.getFrpSludgePressRunning());
					statement.setString(8, sludgeHauling.getFrpScrewPressRunning());
					statement.setDouble(9, sludgeHauling.getEffluentConsistency());
					statement.setDouble(10, sludgeHauling.getCoddischarge());
					
					statement.setInt(11, sludgeHauling.getId());
					
					return statement;
				}
			});
			
			id=sludgeHauling.getId();
		}
		
		
		return id;
	}

	/* (non-Javadoc)
	 * @see com.st.frppressquality.dao.FrpPressQualityDao#getSludgeHauling(java.util.Date, java.util.Date)
	 */
	@Override
	public List<SludgeHauling> getSludgeHauling(Date sdate, Date edate) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		String sql="select * from [sludgeHauling] where [Date] between ? and  ? order by [Date]";
		
		List<SludgeHauling> sludgeHaulings=jdbcTemplate.query(sql, new Object[]{
			new Timestamp(sdate.getTime()),
			new Timestamp(edate.getTime())
		}, new RowMapper<SludgeHauling>(){

			@Override
			public SludgeHauling mapRow(ResultSet rs, int arg1)
					throws SQLException {
				SludgeHauling sludgeHauling=new SludgeHauling();
				sludgeHauling.setId(rs.getInt("ID"));
				sludgeHauling.setDate(rs.getDate("Date"));
				sludgeHauling.setGrade(rs.getString("Grade"));
				sludgeHauling.setSludgeHauled(rs.getDouble("SludgeHauled"));
				sludgeHauling.setSludgeConsistency(rs.getDouble("SludgeConsistency"));
				sludgeHauling.setRejectsBwHauled(rs.getDouble("RejectsBwHauled"));
				sludgeHauling.setRejectsBwConsistency(rs.getDouble("RejectsBwConsistency"));
				sludgeHauling.setFrpSludgePressRunning(rs.getString("FrpSludgePressRunning"));
				sludgeHauling.setFrpScrewPressRunning(rs.getString("FrpScrewPressRunning"));
				sludgeHauling.setEffluentConsistency(rs.getDouble("EffluentConsistency"));
				sludgeHauling.setCoddischarge(rs.getDouble("coddischarge"));
				return sludgeHauling;
			}
			
		});
		return sludgeHaulings;
	}

	/* (non-Javadoc)
	 * @see com.st.frppressquality.dao.FrpPressQualityDao#deleteSludgeHauling(int)
	 */
	@Override
	public void deleteSludgeHauling(int id) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		String sql="delete from [sludgeHauling] where [ID]=? ";
		jdbcTemplate.update(sql, new Object[]{id});
	}

	/* (non-Javadoc)
	 * @see com.st.frppressquality.dao.FrpPressQualityDao#getSludgeHauling(int)
	 */
	@Override
	public SludgeHauling getSludgeHauling(int id) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		String sql="select * from [sludgeHauling] where [ID]=?";
		
		SludgeHauling sludgeHauling=jdbcTemplate.queryForObject(sql, new Object[]{
			id
		}, new RowMapper<SludgeHauling>(){

			@Override
			public SludgeHauling mapRow(ResultSet rs, int arg1)
					throws SQLException {
				SludgeHauling sludgeHauling=new SludgeHauling();
				sludgeHauling.setId(rs.getInt("ID"));
				sludgeHauling.setDate(rs.getDate("Date"));
				sludgeHauling.setGrade(rs.getString("Grade"));
				sludgeHauling.setSludgeHauled(rs.getDouble("SludgeHauled"));
				sludgeHauling.setSludgeConsistency(rs.getDouble("SludgeConsistency"));
				sludgeHauling.setRejectsBwHauled(rs.getDouble("RejectsBwHauled"));
				sludgeHauling.setRejectsBwConsistency(rs.getDouble("RejectsBwConsistency"));
				sludgeHauling.setFrpSludgePressRunning(rs.getString("FrpSludgePressRunning"));
				sludgeHauling.setFrpScrewPressRunning(rs.getString("FrpScrewPressRunning"));
				sludgeHauling.setEffluentConsistency(rs.getDouble("EffluentConsistency"));
				return sludgeHauling;
			}
			
		});
		
		return sludgeHauling;
	}

	/* (non-Javadoc)
	 * @see com.st.frppressquality.dao.FrpPressQualityDao#getDailyReportData(java.util.Date, java.util.Date)
	 */
	@Override
	public List<FrpDailyData> getDailyReportData(Date sdate, Date edate) {
		
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		
		List<FrpDailyData> dailyDatas=new ArrayList<FrpDailyData>();
		
		SimpleDateFormat dateFormat=new SimpleDateFormat("MM/dd/yyyy");
		
		
		while (sdate.before(edate) || CommonUtil.isEqual(sdate, edate)) {
			
			Calendar calendar=Calendar.getInstance();
			calendar.setTime(sdate);
			
			
			String sql="select [DcsWPFeedADST] ,[TotalProdADST], [ProdType],[FreshWater],[FreshWater2] from [frpProductionData] where [Date]=? ";
			
			List<FrpProdcution> prodcutions=jdbcTemplate.query(sql, new Object[]{
					new Timestamp(calendar.getTime().getTime())
			}, new RowMapper<FrpProdcution>(){

				@Override
				public FrpProdcution mapRow(ResultSet rs, int arg1)
						throws SQLException {
					FrpProdcution frpProdcution=new FrpProdcution();
					frpProdcution.setTotalProdADST(rs.getDouble("TotalProdADST"));
					frpProdcution.setDcsWPFeedADST(rs.getDouble("DcsWPFeedADST"));
					frpProdcution.setProdType(rs.getString("ProdType"));
					frpProdcution.setFreshWater(rs.getDouble("FreshWater"));
					frpProdcution.setFreshWater2(rs.getDouble("FreshWater2"));
										
					return frpProdcution;
				}
				
			});
			
			Set<String> grades=new HashSet<String>();
			
			double dcsWPFeedADST=0;
			double totalProdADST=0;
			double freshWater=0;
			double freshWater2=0;
			
			
			for (FrpProdcution frpProdcution : prodcutions) {
				if(frpProdcution.getProdType().equalsIgnoreCase("KF")){
					grades.add("K");
				}else{
					grades.add("W");
				}
				
				dcsWPFeedADST+=frpProdcution.getDcsWPFeedADST();
				totalProdADST+=frpProdcution.getTotalProdADST();
				freshWater+=frpProdcution.getFreshWater();
				freshWater2+=frpProdcution.getFreshWater2();
			}
			
			
			String sql2="select * from [sludgeHauling] where [Date]=?";
			
			List<SludgeHauling> sludgeHaulings=jdbcTemplate.query(sql2, new Object[]{
					new Timestamp(calendar.getTime().getTime())
				}, new RowMapper<SludgeHauling>(){

					@Override
					public SludgeHauling mapRow(ResultSet rs, int arg1)
							throws SQLException {
						SludgeHauling sludgeHauling=new SludgeHauling();
						sludgeHauling.setId(rs.getInt("ID"));
						sludgeHauling.setDate(rs.getDate("Date"));
						sludgeHauling.setGrade(rs.getString("Grade"));
						sludgeHauling.setSludgeHauled(rs.getDouble("SludgeHauled"));
						sludgeHauling.setSludgeConsistency(rs.getDouble("SludgeConsistency"));
						sludgeHauling.setRejectsBwHauled(rs.getDouble("RejectsBwHauled"));
						sludgeHauling.setRejectsBwConsistency(rs.getDouble("RejectsBwConsistency"));
						sludgeHauling.setFrpSludgePressRunning(rs.getString("FrpSludgePressRunning"));
						sludgeHauling.setFrpScrewPressRunning(rs.getString("FrpScrewPressRunning"));
						
						return sludgeHauling;
					}
					
				});
			
			
			double sludgeHauled=0;
			double sludgeConsistency=0;
			double rejectsBwHauled=0;
			double rejectsBwConsistency=0;
			String frpSludgePressRunning="";
			String frpScrewPressRunning="";
			
			for (SludgeHauling sludgeHauling : sludgeHaulings) {
				if(sludgeHauling.getGrade().equalsIgnoreCase("B")){
					grades.add("K");
				}else{
					grades.add("W");
				}
				sludgeHauled+=sludgeHauling.getSludgeHauled();
				sludgeConsistency+=sludgeHauling.getSludgeConsistency();
				rejectsBwHauled+=sludgeHauling.getRejectsBwHauled();
				rejectsBwConsistency+=sludgeHauling.getRejectsBwConsistency();
				frpSludgePressRunning=sludgeHauling.getFrpSludgePressRunning();
				frpScrewPressRunning=sludgeHauling.getFrpScrewPressRunning();
			}
			
			
			FrpDailyData dailyData=new FrpDailyData();
			dailyData.setDate(dateFormat.format(calendar.getTime()));
			dailyData.setGrade(StringUtils.join(grades, "/"));
			
			dailyData.setWastepaperFed(dcsWPFeedADST);
			dailyData.setWastepaperFedBDST(CommonUtil.round(dcsWPFeedADST*0.9, 2));
			
			dailyData.setTotalProduction(totalProdADST);
			dailyData.setTotalProductionBDST(CommonUtil.round(totalProdADST*0.9, 2));
			
			dailyData.setSludgeHauled(sludgeHauled);
			dailyData.setSludgeConsistency(sludgeConsistency);
			
			dailyData.setSludgeHauledLBS(CommonUtil.round(sludgeHauled*(sludgeConsistency/100), 2));
			dailyData.setSludgeHauledBDST(CommonUtil.round(dailyData.getSludgeHauledLBS()/2000, 2));
			
			dailyData.setRejectsBwHauled(rejectsBwHauled);
			dailyData.setRejectsBwConsistency(rejectsBwConsistency);
			
			dailyData.setRejectsBwHauledLBS(CommonUtil.round(rejectsBwHauled*(rejectsBwConsistency/100), 2));
			dailyData.setRejectsBwHauledBDST(CommonUtil.round(dailyData.getRejectsBwHauledLBS()/2000, 2));
			
			dailyData.setTotalSolidsSentToIP(CommonUtil.round(dailyData.getWastepaperFedBDST()+dailyData.getTotalProductionBDST()+dailyData.getRejectsBwHauledBDST()+dailyData.getSludgeHauledBDST(), 2));
			
			dailyData.setFrpScrewPressRunning(frpScrewPressRunning);
			dailyData.setFrpSludgePressRunning(frpSludgePressRunning);
			
			
			if(dcsWPFeedADST!=0){
				dailyData.setYield(CommonUtil.round(totalProdADST/dcsWPFeedADST, 2));
			}
			
			
			dailyData.setMillWater1008(freshWater);
			dailyData.setMillWater1009(freshWater2);
			
			dailyData.setWaterCost(CommonUtil.round((freshWater2/1000)*2.16, 2));
			
			if(totalProdADST!=0){
				dailyData.setWaterCostPeADST(CommonUtil.round(dailyData.getWaterCost()/totalProdADST, 2));
			}
			
			
			dailyDatas.add(dailyData);
			
			
			
			calendar.add(Calendar.DATE, 1);
			sdate=calendar.getTime();
			
			
		}
		
		
		return dailyDatas;
	}

	/* (non-Javadoc)
	 * @see com.st.frppressquality.dao.FrpPressQualityDao#getMonthlyReportData(java.util.Date, java.util.Date)
	 */
	@Override
	public List<FrpDailyData> getMonthlyReportData(Date sdate, Date edate) {
JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		
		List<FrpDailyData> dailyDatas=new ArrayList<FrpDailyData>();
		
		SimpleDateFormat dateFormat=new SimpleDateFormat("MM/dd/yyyy");
		
		
		while (sdate.before(edate) || CommonUtil.isEqual(sdate, edate)) {
			
			Calendar calendar=Calendar.getInstance();
			calendar.setTime(sdate);
			
			
			String sql="select [DcsWPFeedADST] ,[TotalProdADST], [ProdType],[FreshWater],[FreshWater2] from [frpProductionData] where [Date]=? ";
			
			List<FrpProdcution> prodcutions=jdbcTemplate.query(sql, new Object[]{
					new Timestamp(calendar.getTime().getTime())
			}, new RowMapper<FrpProdcution>(){

				@Override
				public FrpProdcution mapRow(ResultSet rs, int arg1)
						throws SQLException {
					FrpProdcution frpProdcution=new FrpProdcution();
					frpProdcution.setTotalProdADST(rs.getDouble("TotalProdADST"));
					frpProdcution.setDcsWPFeedADST(rs.getDouble("DcsWPFeedADST"));
					frpProdcution.setProdType(rs.getString("ProdType"));
					frpProdcution.setFreshWater(rs.getDouble("FreshWater"));
					frpProdcution.setFreshWater2(rs.getDouble("FreshWater2"));
										
					return frpProdcution;
				}
				
			});
			
			Set<String> grades=new HashSet<String>();
			
			double dcsWPFeedADST=0;
			double totalProdADST=0;
			
			
			for (FrpProdcution frpProdcution : prodcutions) {
				if(frpProdcution.getProdType().equalsIgnoreCase("KF")){
					grades.add("K");
				}else{
					grades.add("W");
				}
				
				dcsWPFeedADST+=frpProdcution.getDcsWPFeedADST();
				totalProdADST+=frpProdcution.getTotalProdADST();
			}
			
			
			String sql2="select * from [sludgeHauling] where [Date]=?";
			
			List<SludgeHauling> sludgeHaulings=jdbcTemplate.query(sql2, new Object[]{
					new Timestamp(calendar.getTime().getTime())
				}, new RowMapper<SludgeHauling>(){

					@Override
					public SludgeHauling mapRow(ResultSet rs, int arg1)
							throws SQLException {
						SludgeHauling sludgeHauling=new SludgeHauling();
						sludgeHauling.setId(rs.getInt("ID"));
						sludgeHauling.setDate(rs.getDate("Date"));
						sludgeHauling.setGrade(rs.getString("Grade"));
						sludgeHauling.setSludgeHauled(rs.getDouble("SludgeHauled"));
						sludgeHauling.setSludgeConsistency(rs.getDouble("SludgeConsistency"));
						sludgeHauling.setRejectsBwHauled(rs.getDouble("RejectsBwHauled"));
						sludgeHauling.setRejectsBwConsistency(rs.getDouble("RejectsBwConsistency"));
						sludgeHauling.setFrpSludgePressRunning(rs.getString("FrpSludgePressRunning"));
						sludgeHauling.setFrpScrewPressRunning(rs.getString("FrpScrewPressRunning"));
						
						return sludgeHauling;
					}
					
				});
			
			
			double sludgeHauled=0;
			double sludgeConsistency=0;
			double rejectsBwHauled=0;
			double rejectsBwConsistency=0;
			
			
			for (SludgeHauling sludgeHauling : sludgeHaulings) {
				if(sludgeHauling.getGrade().equalsIgnoreCase("B")){
					grades.add("K");
				}else{
					grades.add("W");
				}
				sludgeHauled+=sludgeHauling.getSludgeHauled();
				sludgeConsistency+=sludgeHauling.getSludgeConsistency();
				rejectsBwHauled+=sludgeHauling.getRejectsBwHauled();
				rejectsBwConsistency+=sludgeHauling.getRejectsBwConsistency();
			}
			
			
			FrpDailyData dailyData=new FrpDailyData();
			dailyData.setDate(dateFormat.format(calendar.getTime()));
			dailyData.setGrade(StringUtils.join(grades, "/"));
			
			dailyData.setWastepaperFed(dcsWPFeedADST);
			dailyData.setWastepaperFedBDST(CommonUtil.round(dcsWPFeedADST*0.9, 2));
			
			dailyData.setTotalProduction(totalProdADST);
			dailyData.setTotalProductionBDST(CommonUtil.round(totalProdADST*0.9, 2));
			
			dailyData.setSludgeHauled(sludgeHauled);
			dailyData.setSludgeConsistency(sludgeConsistency);
			
			dailyData.setSludgeHauledLBS(CommonUtil.round(sludgeHauled*(sludgeConsistency/100), 2));
			dailyData.setSludgeHauledBDST(CommonUtil.round(dailyData.getSludgeHauledLBS()/2000, 2));
			
			dailyData.setRejectsBwHauled(rejectsBwHauled);
			dailyData.setRejectsBwConsistency(rejectsBwConsistency);
			
			dailyData.setRejectsBwHauledLBS(CommonUtil.round(rejectsBwHauled*(rejectsBwConsistency/100), 2));
			dailyData.setRejectsBwHauledBDST(CommonUtil.round(dailyData.getRejectsBwHauledLBS()/2000, 2));
			
			dailyData.setTotalSolidsSentToIP(CommonUtil.round(dailyData.getWastepaperFedBDST()+dailyData.getTotalProductionBDST()+dailyData.getRejectsBwHauledBDST()+dailyData.getSludgeHauledBDST(), 2));
			
			
			Calendar scal=Calendar.getInstance();
			scal.setTime(calendar.getTime());
			scal.set(Calendar.HOUR_OF_DAY, 7);
			scal.set(Calendar.MINUTE, 0);
			scal.set(Calendar.SECOND, 0);
			scal.set(Calendar.MILLISECOND, 0);
			
			Calendar ecal=Calendar.getInstance();
			ecal.setTime(scal.getTime());
			ecal.set(Calendar.HOUR_OF_DAY, 6);
			ecal.set(Calendar.MINUTE, 59);
			ecal.set(Calendar.SECOND, 59);
			ecal.set(Calendar.MILLISECOND, 0);
			ecal.add(Calendar.DATE, 1);
			
			
		//	System.out.println("SDATE="+scal.getTime()+"\t"+"SDATE="+ecal.getTime());
			
			
			//SQL Brightness
			
			String sql3="SELECT max([Consistency]) "
					+ " FROM frpPressQualityData where  [QualityType]='SPC'  "
					+ " and "
					+ " [Consistency]>0 "
					+ " And"
					+ " [Date] between ? and ? ";
			
			double consAvg=0;
			try {
				consAvg=jdbcTemplate.queryForObject(sql3,new Object[]{
						new Timestamp(scal.getTime().getTime()),
						new Timestamp(ecal.getTime().getTime())
					}, Double.class);
			} catch (Exception e) {
				//System.out.println("Avg Cons Error="+e.getMessage());
			}
			
			dailyData.setStSludgeConsistency(CommonUtil.round(consAvg, 2));
			
			
			

			String sql4="SELECT avg(Consistency) "
					+ " FROM frpPressQualityData where  [QualityType]='IPSC'  "
					+ " and "
					+ " [Consistency]>0  "
					+ " And "
					+ " [Date] between ? and ? ";
			
			double consIpAvg=0;
			try {
				consIpAvg=jdbcTemplate.queryForObject(sql4,new Object[]{
						new Timestamp(scal.getTime().getTime()),
						new Timestamp(ecal.getTime().getTime())
					}, Double.class);
			} catch (Exception e) {
				//System.out.println("Avg IP Cons Error="+e.getMessage());
			}
			
			dailyData.setStIpSludgeConsistency(CommonUtil.round(consIpAvg, 2));
			
			dailyDatas.add(dailyData);
			
			
			
			calendar.add(Calendar.DATE, 1);
			sdate=calendar.getTime();
			
			
		}
		
		
		return dailyDatas;
	}

	/* (non-Javadoc)
	 * @see com.st.frppressquality.dao.FrpPressQualityDao#getFiberBalanceReportData(java.util.Date, java.util.Date)
	 */
	@Override
	public List<FrpDailyData> getFiberBalanceReportData(Date sdate, Date edate,String grade) {
		
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		
		List<FrpDailyData> dailyDatas=new ArrayList<FrpDailyData>();
		
		SimpleDateFormat dateFormat=new SimpleDateFormat("MM-dd-yyyy");
		
		
		while (sdate.before(edate) || CommonUtil.isEqual(sdate, edate)) {
			
			Calendar calendar=Calendar.getInstance();
			calendar.setTime(sdate);
			
			
			String sql="select [DcsWPFeedADST] ,[TotalProdADST], [ProdType],[FreshWater],[FreshWater2],[WetLapProdADST] from [frpProductionData] where [Date]=? ";
			
			if(grade.equalsIgnoreCase("W")){
				sql+=" And [ProdType]='BW'";
				}else if(grade.equalsIgnoreCase("K")){
				sql+=" And [ProdType]='KF'";
			}
			
			List<FrpProdcution> prodcutions=jdbcTemplate.query(sql, new Object[]{
					new Timestamp(calendar.getTime().getTime())
			}, new RowMapper<FrpProdcution>(){

				@Override
				public FrpProdcution mapRow(ResultSet rs, int arg1)
						throws SQLException {
					FrpProdcution frpProdcution=new FrpProdcution();
					frpProdcution.setTotalProdADST(rs.getDouble("TotalProdADST"));
					frpProdcution.setDcsWPFeedADST(rs.getDouble("DcsWPFeedADST"));
					frpProdcution.setProdType(rs.getString("ProdType"));
					frpProdcution.setFreshWater(rs.getDouble("FreshWater"));
					frpProdcution.setFreshWater2(rs.getDouble("FreshWater2"));
					frpProdcution.setWetLapProdADST(rs.getDouble("WetLapProdADST"));
										
					return frpProdcution;
				}
				
			});
			
			Set<String> grades=new HashSet<String>();
			
			double dcsWPFeedADST=0;
			double totalProdADST=0;
			double wetLapProd=0;
			
			for (FrpProdcution frpProdcution : prodcutions) {
				if(frpProdcution.getProdType().equalsIgnoreCase("KF")){
					grades.add("K");
				}else{
					grades.add("W");
				}
				
				dcsWPFeedADST+=frpProdcution.getDcsWPFeedADST();
				totalProdADST+=frpProdcution.getTotalProdADST();
				wetLapProd+=frpProdcution.getWetLapProdADST();
			}
			
			String sql2="select * from [sludgeHauling] where [Date]=? ";
			
			if(grade.equalsIgnoreCase("W")){
				sql2+=" And [Grade]='W'";
				}else if(grade.equalsIgnoreCase("K")){
				sql2+=" And [Grade]='B'";
			}
			
			
			List<SludgeHauling> sludgeHaulings=jdbcTemplate.query(sql2, new Object[]{
					new Timestamp(calendar.getTime().getTime())
				}, new RowMapper<SludgeHauling>(){

					@Override
					public SludgeHauling mapRow(ResultSet rs, int arg1)
							throws SQLException {
						SludgeHauling sludgeHauling=new SludgeHauling();
						sludgeHauling.setId(rs.getInt("ID"));
						sludgeHauling.setDate(rs.getDate("Date"));
						sludgeHauling.setGrade(rs.getString("Grade"));
						sludgeHauling.setSludgeHauled(rs.getDouble("SludgeHauled"));
						sludgeHauling.setSludgeConsistency(rs.getDouble("SludgeConsistency"));
						sludgeHauling.setRejectsBwHauled(rs.getDouble("RejectsBwHauled"));
						sludgeHauling.setRejectsBwConsistency(rs.getDouble("RejectsBwConsistency"));
						sludgeHauling.setFrpSludgePressRunning(rs.getString("FrpSludgePressRunning"));
						sludgeHauling.setFrpScrewPressRunning(rs.getString("FrpScrewPressRunning"));
						
						return sludgeHauling;
					}
					
				});
			
			
			double sludgeHauled=0;
			double sludgeConsistency=0;
			double rejectsBwHauled=0;
			double rejectsBwConsistency=0;
			
			
			for (SludgeHauling sludgeHauling : sludgeHaulings) {
				if(sludgeHauling.getGrade().equalsIgnoreCase("B")){
					grades.add("K");
				}else{
					grades.add("W");
				}
				sludgeHauled+=sludgeHauling.getSludgeHauled();
				sludgeConsistency+=sludgeHauling.getSludgeConsistency();
				rejectsBwHauled+=sludgeHauling.getRejectsBwHauled();
				rejectsBwConsistency+=sludgeHauling.getRejectsBwConsistency();
			}
			
			
			FrpDailyData dailyData=new FrpDailyData();
			dailyData.setDate(dateFormat.format(calendar.getTime()));
			dailyData.setGrade(StringUtils.join(grades, "/"));
			
			dailyData.setWastepaperFed(dcsWPFeedADST);
			dailyData.setWastepaperFedBDST(CommonUtil.round(dcsWPFeedADST*0.9, 2));
			
			dailyData.setTotalProduction(totalProdADST);
			dailyData.setTotalProductionBDST(CommonUtil.round(totalProdADST*0.9, 2));
			
			dailyData.setSludgeHauled(sludgeHauled);
			dailyData.setSludgeConsistency(sludgeConsistency);
			
			dailyData.setSludgeHauledLBS(CommonUtil.round(sludgeHauled*(sludgeConsistency/100), 2));
			dailyData.setSludgeHauledBDST(CommonUtil.round(dailyData.getSludgeHauledLBS()/2000, 2));
			
			dailyData.setRejectsBwHauled(rejectsBwHauled);
			dailyData.setRejectsBwConsistency(rejectsBwConsistency);
			
			dailyData.setRejectsBwHauledLBS(CommonUtil.round(rejectsBwHauled*(rejectsBwConsistency/100), 2));
			dailyData.setRejectsBwHauledBDST(CommonUtil.round(dailyData.getRejectsBwHauledLBS()/2000, 2));
			
			dailyData.setTotalSolidsSentToIP(CommonUtil.round(dailyData.getWastepaperFedBDST()+dailyData.getTotalProductionBDST()+dailyData.getRejectsBwHauledBDST()+dailyData.getSludgeHauledBDST(), 2));
			
			dailyData.setWetLapProd(CommonUtil.round(wetLapProd, 2));

			dailyDatas.add(dailyData);
			
			
			calendar.add(Calendar.DATE, 1);
			sdate=calendar.getTime();
			
			
		}
		
		
		return dailyDatas;
	}

	/* (non-Javadoc)
	 * @see com.st.frppressquality.dao.FrpPressQualityDao#getBirghtness()
	 */
	@Override
	public List<Map<String, Object>> getBirghtness() {
		//TODO
			JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		
			Calendar sCal=Calendar.getInstance();
			sCal.setTime(CommonUtil.getShiftDate());
			//sCal.setTime(CommonUtil.getFirstDate(new Date()));
			sCal.set(Calendar.HOUR_OF_DAY, 7);
			sCal.set(Calendar.MINUTE, 0);
			sCal.set(Calendar.SECOND, 0);
			sCal.set(Calendar.MILLISECOND, 0);
			sCal.add(Calendar.DATE, -2);
			
			Calendar eCal=Calendar.getInstance();
			eCal.setTime(new Date());
			
		//	System.out.println(sCal.getTime());
		//	System.out.println(eCal.getTime());
			
			String sql="SELECT [Brightness],[Date] FROM frpPressQualityData where [Brightness]>0 And [QualityType]='TPQ2' and [Date] between ? and ? ";
			
			List<Map<String, Object>> list=jdbcTemplate.queryForList(sql, new Object[]{
					new Timestamp(sCal.getTime().getTime()),
					new Timestamp(eCal.getTime().getTime()),
			});
			
			
		//	System.out.println(list.size());
			
			return list;
	}

	/* (non-Javadoc)
	 * @see com.st.frppressquality.dao.FrpPressQualityDao#getPressQualityInfo(java.util.Date)
	 */
//	Code Starts From Here Done By Roshan Tailor Date 03/20/2015
//Code Modified By Roshan Tailor Date :- 03/21/2015
	@Override
	public Map<String, Object> getPressQualityInfo(Date date) {
	
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		
		Map<String, Object> map=new HashMap<String, Object>();
		Calendar sdate=Calendar.getInstance();
		sdate.setTime(date);
		sdate.set(Calendar.HOUR_OF_DAY,7);
		sdate.set(Calendar.MINUTE,0);
		sdate.set(Calendar.SECOND,0);
		sdate.set(Calendar.MILLISECOND,0);
		
		Calendar edate=Calendar.getInstance();
		edate.setTime(date);
		edate.set(Calendar.HOUR_OF_DAY, 6);
		edate.set(Calendar.MINUTE, 59);
		edate.set(Calendar.SECOND, 59);
		edate.set(Calendar.MILLISECOND, 0);
		edate.add(Calendar.DATE, 1);
		
		
		
		
		String CURuning="";
		String astar="";
		String bstar="";
		double avgCons1=0;
		double avgCons2=0;
		double avgsecpressqbrightness=0;// Brightness For SECPRESSQ
		
		double avgtertpressbrightness=0;//Brightness For TPQ1 And TPQ2 
		double avgtertpressdirt=0;
		double avgtertpressstickies=0;
		double avgtertpressash=0;
		double eric=0;
		
		// Query For Clarifier UnderFlow Running YES OR NOT
		try{
			
			String sql="SELECT TOP 1  [CURunning] FROM  frpPressQualityData WHERE  [Date] between ? and ? and [QualityType]='SPC' order by [Date]"; 
			CURuning=jdbcTemplate.queryForObject(sql,new Object[]{
					new Timestamp(sdate.getTime().getTime()),
					new Timestamp(edate.getTime().getTime())
			},String.class);
			
		}catch(Exception e){
			logger.error("Error in calculating avg for CURunning");
		//	e.printStackTrace();
		}
		// Query for Sludge Press Consistency Data Coming From SludgeHauling Table
		try {
			
				String sql="select AVG([SludgeConsistency])"
						+ " FROM sludgeHauling Where [SludgeConsistency]>0 And  [Date] between ? and ?"; 
				avgCons1=jdbcTemplate.queryForObject(sql,new Object[]{
						new Timestamp(date.getTime()),
						new Timestamp(date.getTime())
//						sdate,edate
						},Double.class);
		} catch (Exception e) {
			logger.error("Error in calculating avg for SludgeConsistency");
			//e.printStackTrace();
		}
		// Query for Screw Press Consistency  Data Coming From SludgeHauling Table
		try {
			
			String sql="select AVG([Consistency])"
					+ " FROM frpPressQualityData Where [Consistency]>0 And [QualityType]='SPC' And  [Date] between ? and ?"; 
		//	System.out.println(sql);
			avgCons2=jdbcTemplate.queryForObject(sql,new Object[]{
					new Timestamp(sdate.getTime().getTime()),
					new Timestamp(edate.getTime().getTime())
					//date,date
					},Double.class);
		} catch (Exception e) {
			//e.printStackTrace();
			logger.error("Error in calculating avg for Consistency");
			
		}
		// Query for Avg. Brightness Data Coming From frpPressQualityData Table For SECPRESSQ
		try {
			
			String sql="select AVG([Brightness]) FROM frpPressQualityData WHERE [Brightness]>0 And [QualityType]='SECPRESSQ' And [Date] between ? and ? ";
			avgsecpressqbrightness=jdbcTemplate.queryForObject(sql,new Object[]{
					new Timestamp(sdate.getTime().getTime()),
					new Timestamp(edate.getTime().getTime())
			},Double.class);
		} catch (Exception e) {
			logger.error("Error in calculating avg for Brightness");
			//e.printStackTrace();
		}
		
		//Query For Avg. Brightness Data Coming From frpPressQualityData Table For TPQ1 And TPQ2
		try{
			
			String sql="SELECT AVG([Brightness]) FROM frpPressQualityData WHERE [Brightness]>0 And [QualityType]='TPQ' And [Date] Between ? and ? ";
			avgtertpressbrightness=jdbcTemplate.queryForObject(sql,new Object[]{
					new Timestamp(sdate.getTime().getTime()),
					new Timestamp(edate.getTime().getTime())
			},Double.class);
		}
		catch(Exception e){
		//	e.printStackTrace();
			logger.error("You Have A Problem In FrpPressQualityDaoImp.java In Query For tertpressbrightness Avg.");
		}
		
		// Query For tertpressdirt Avg.
		try{
			
			String sql="select AVG([Dirt]) FROM frpPressQualityData Where [Dirt]>0 And [QualityType]='TPQ' And [Date] between ? and ? ";
			avgtertpressdirt=jdbcTemplate.queryForObject(sql,new Object[]{
					new Timestamp(sdate.getTime().getTime()),
					new Timestamp(edate.getTime().getTime())
			},Double.class);
		}
		catch(Exception e){
			logger.error("You Have A Problem In FrpPressQualityDaoImp.java In  Query For tertpressdirt Avg. ");
		//	e.printStackTrace();
		}
		
		//Query For tertpressstickies Avg.
		try{
			
			String sql="select AVG([Stickies]) FROM frpPressQualityData Where [Stickies]>0 AND [QualityType]='TPQ' And [Date] between ? and ? ";
			avgtertpressstickies=jdbcTemplate.queryForObject(sql,new Object[]{
					new Timestamp(sdate.getTime().getTime()),
					new Timestamp(edate.getTime().getTime())
			},Double.class);
		}
		catch(Exception e){
			logger.error("You Have A Problem In FrpPressQualityDaoImp.java In Query For tertpressstickies Avg.");
		//e.printStackTrace();	
		}
		
		//Query For tertpressash Avg.
		try{
			
			String sql="select AVG([Ash]) FROM frpPressQualityData Where [Ash]>0 AND [QualityType]='TPQ' And [Date] between ? and ? ";
			avgtertpressash=jdbcTemplate.queryForObject(sql,new Object[]{
					new Timestamp(sdate.getTime().getTime()),
					new Timestamp(edate.getTime().getTime())
			},Double.class);
		}
		catch(Exception e){
			logger.error("You Have A Problem In FrpPressQualityDaoImp.java In Query For tertpressstickies Avg.");
			//e.printStackTrace();
		}
		
		//Query For A* Top 1
		try{
			
			String sql="SELECT TOP 1 (Astar) FROM frpPressQualityData WHERE [QualityType]='SECPRESSQ' AND [Date] between ? and ? order by [Date]";
			astar=jdbcTemplate.queryForObject(sql,new Object[]{
					new Timestamp(sdate.getTime().getTime()),
					new Timestamp(edate.getTime().getTime())
			},String.class);
		}
		catch(Exception e){
			logger.error("You Have A Problem In FrpPressQualityDaoImp.java In Query For A* Top 1");
			//e.printStackTrace();
		}
		
		//Query For B* Top 1
		try{
		
			String sql="SELECT TOP 1 (Bstar) FROM frpPressQualityData WHERE [QualityType]='SECPRESSQ' AND [Date] between ? and ? order by [Date]";
			bstar=jdbcTemplate.queryForObject(sql,new Object[]{
					new Timestamp(sdate.getTime().getTime()),
					new Timestamp(edate.getTime().getTime())
			},String.class);
		}
		catch(Exception e){
			logger.error("You Have A Problem In FrpPressQualityDaoImp.java In Query For B* Top 1");
			//e.printStackTrace();
		}
		
		//Query For Eric
	//	System.out.println("S Date::::->"+sdate.getTime());
	//	System.out.println("E Date::::->"+edate.getTime());
		try{
			
			String sql="select AVG([Eric]) FROM frpPressQualityData Where [Eric]>0 AND [QualityType]='SECPRESSQ' And [Date] Between ? and ?";
			eric=jdbcTemplate.queryForObject(sql,new Object[]{
					new Timestamp(sdate.getTime().getTime()),
					new Timestamp(edate.getTime().getTime())
			},Double.class);
		}
		catch(Exception e){
			logger.error("You Have A Problem In FrpPressQualityDaoImp.java In Query ForEric Top 1");
			//e.printStackTrace();
		}
	
		//map For SEC Press OR SECPRESSQ.
		map.put("avgsecpressqbrightness", avgsecpressqbrightness);
		map.put("avgeric", eric);
		map.put("avgastar", astar);
		map.put("avgbstar", bstar);
		//map For TERT Press OR TPQ1 AND TPQ2.
		map.put("avgtertpressbrightness", avgtertpressbrightness);
		map.put("avgtertpressdirt", avgtertpressdirt);
		map.put("avgtertpressstickies", avgtertpressstickies);
		map.put("avgtertpressash", avgtertpressash);
		//Map For Sludge Press Consistency.
		map.put("avgCons1", avgCons1);
		//Map For Screw Press Consistency.
		map.put("avgCons2", avgCons2);
		//Map For Clarifier Under Running Or Not.
		
		if(StringUtils.isNotEmpty(CURuning)){
			map.put("CURuning", CURuning);
		}
		//Map Ends.
		return map;
	}

	/* (non-Javadoc)
	 * @see com.st.frppressquality.dao.FrpPressQualityDao#saveOrUpdate(com.st.frppressquality.model.StickiesData)
	 */
	@Override
	public int saveOrUpdate(final StickiesData stickiesData) {

		int id=0;
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		
		if(stickiesData.getId()==0){
			KeyHolder keyHolder=new GeneratedKeyHolder();
			final String sql="insert into [stickiesData]("
					+ "[Date],"					
					+ "[ttimeA],"
					+ "[tinitialsA],"
					+ "[tcountA],"
					+ "[ttotalareaA],"
					+ "[tavgareaA],"
					+ "[tppmA],"
					+ "[tcommentA],"
					+ "[retimeA],"
					+ "[reinitialsA],"
					+ "[recountA],"
					+ "[retotalareaA],"
					+ "[reavgareaA],"
					+ "[reppmA],"
					+ "[recommentA],"
					+ "[patimeA],"
					+ "[painitialsA],"
					+ "[pacountA],"
					+ "[patotalareaA],"
					+ "[paavgareaA],"
					+ "[pappmA],"
					+ "[pacommentA],"				
					+ "[totimeB],"
					+ "[toinitialsB],"
					+ "[tocountB],"
					+ "[tototalareaB],"
					+ "[toavgareaB],"
					+ "[toppmB],"
					+ "[tocommentB],"
					+ "[retimeB],"
					+ "[reinitialsB],"
					+ "[recountB],"
					+ "[retotalareaB],"
					+ "[reavgareaB],"
					+ "[reppmB],"
					+ "[recommentB],"
					+ "[patimeB],"
					+ "[painitialsB],"
					+ "[pacountB],"
					+ "[patotalareaB],"
					+ "[paavgareaB],"
					+ "[pappmB],"
					+ "[pacommentB],"
					+ "[psftimeA],"
					+ "[psfinitialsA],"
					+ "[psfcountA],"
					+ "[psftotalareaA],"
					+ "[psfavgareaA],"
					+ "[psfppmA],"
					+ "[psfcommentA],"
					+ "[psatimeA],"
					+ "[psainitialsA],"
					+ "[psacountA],"
					+ "[psatotalareaA],"
					+ "[psaavgareaA],"
					+ "[psappmA],"					
					+ "[psacommentA],"
					+ "[psftimeB],"
					+ "[psfinitialsB],"
					+ "[psfcountB],"
					+ "[psftotalareaB],"
					+ "[psfavgareaB],"
					+ "[psfppmB],"
					+ "[psfcommentB],"
					+ "[psatimeB],"
					+ "[psainitialsB],"
					+ "[psacountB],"
					+ "[psatotalareaB],"
					+ "[psaavgareaB],"
					+ "[psappmB],"
					+ "[psacommentB],"
					+ "[efficiencyA],"
					+ "[efficiencyB]"
					+ ") values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			
			
			jdbcTemplate.update(new PreparedStatementCreator() {
				
				@Override
				public PreparedStatement createPreparedStatement(Connection arg0)
						throws SQLException {
					PreparedStatement statement=arg0.prepareStatement(sql, new String[]{"ID"});
					
					statement.setTimestamp(1, new Timestamp(stickiesData.getDate().getTime()));
					statement.setString(2, stickiesData.getTtimeA());
					statement.setString(3, stickiesData.getTinitialsA());
					statement.setString(4, stickiesData.getTcountA());
					statement.setString(5, stickiesData.getTtotalareaA());
					statement.setString(6, stickiesData.getTavgareaA());
					statement.setString(7, stickiesData.getTppmA());
					statement.setString(8, stickiesData.getTcommentA());
					
					statement.setString(9, stickiesData.getRetimeA());
					statement.setString(10, stickiesData.getReinitialsA());
					statement.setString(11, stickiesData.getRecountA());
					statement.setString(12, stickiesData.getRetotalareaA());
					statement.setString(13, stickiesData.getReavgareaA());
					statement.setString(14, stickiesData.getReppmA());
					statement.setString(15, stickiesData.getRecommentA());
					
					statement.setString(16, stickiesData.getPatimeA());
					statement.setString(17, stickiesData.getPainitialsA());
					statement.setString(18, stickiesData.getPacountA());
					statement.setString(19, stickiesData.getPatotalareaA());
					statement.setString(20, stickiesData.getPaavgareaA());
					statement.setString(21, stickiesData.getPappmA());
					statement.setString(22, stickiesData.getPacommentA());
					
					statement.setString(23, stickiesData.getTotimeB());
					statement.setString(24, stickiesData.getToinitialsB());
					statement.setString(25, stickiesData.getTocountB());
					statement.setString(26, stickiesData.getTototalareaB());
					statement.setString(27, stickiesData.getToavgareaB());
					statement.setString(28, stickiesData.getToppmB());
					statement.setString(29, stickiesData.getTocommentB());
					
					statement.setString(30, stickiesData.getRetimeB());
					statement.setString(31, stickiesData.getReinitialsB());
					statement.setString(32, stickiesData.getRecountB());
					statement.setString(33, stickiesData.getRetotalareaB());
					statement.setString(34, stickiesData.getReavgareaB());
					statement.setString(35, stickiesData.getReppmB());
					statement.setString(36, stickiesData.getRecommentB());
					
					statement.setString(37, stickiesData.getPatimeB());
					statement.setString(38, stickiesData.getPainitialsB());
					statement.setString(39, stickiesData.getPacountB());
					statement.setString(40, stickiesData.getPatotalareaB());
					statement.setString(41, stickiesData.getPaavgareaB());
					statement.setString(42, stickiesData.getPappmB());
					statement.setString(43, stickiesData.getPacommentB());
					
					statement.setString(44, stickiesData.getPsftimeA());
					statement.setString(45, stickiesData.getPsfinitialsA());
					statement.setString(46, stickiesData.getPsfcountA());
					statement.setString(47, stickiesData.getPsftotalareaA());
					statement.setString(48, stickiesData.getPsfavgareaA());
					statement.setString(49, stickiesData.getPsfppmA());
					statement.setString(50, stickiesData.getPsfcommentA());
					statement.setString(51, stickiesData.getPsatimeA());
					statement.setString(52, stickiesData.getPsainitialsA());
					statement.setString(53, stickiesData.getPsacountA());
					statement.setString(54, stickiesData.getPsatotalareaA());
					statement.setString(55, stickiesData.getPsaavgareaA());
					statement.setString(56, stickiesData.getPsappmA());
					statement.setString(57, stickiesData.getPsacommentA());
					
					statement.setString(58, stickiesData.getPsftimeB());
					statement.setString(59, stickiesData.getPsfinitialsB());
					statement.setString(60, stickiesData.getPsfcountB());
					statement.setString(61, stickiesData.getPsftotalareaB());
					statement.setString(62, stickiesData.getPsfavgareaB());
					statement.setString(63, stickiesData.getPsfppmB());
					statement.setString(64, stickiesData.getPsfcommentB());
					statement.setString(65, stickiesData.getPsatimeB());
					statement.setString(66, stickiesData.getPsainitialsB());
					statement.setString(67, stickiesData.getPsacountB());
					statement.setString(68, stickiesData.getPsatotalareaB());
					statement.setString(69, stickiesData.getPsaavgareaB());
					statement.setString(70, stickiesData.getPsappmB());
					statement.setString(71, stickiesData.getPsacommentB());
					
					statement.setString(72, stickiesData.getEfficiencyA());
					statement.setString(73, stickiesData.getEfficiencyB());
									
					
					
					return statement;
				}
			},keyHolder);
			id=keyHolder.getKey().intValue();
			
		}else{
			final String sql="update [stickiesData] set "
					+ "[Date]=?,"
					+ "[ttimeA]=?,"
					+ "[tinitialsA]=?,"
					+ "[tcountA]=?,"
					+ "[ttotalareaA]=?,"
					+ "[tavgareaA]=?,"
					+ "[tppmA]=?,"
					+ "[tcommentA]=?,"
					+ "[retimeA]=?,"
					+ "[reinitialsA]=?,"
					+ "[recountA]=?,"
					+ "[retotalareaA]=?,"
					+ "[reavgareaA]=?,"
					+ "[reppmA]=?,"
					+ "[recommentA]=?,"
					+ "[patimeA]=?,"
					+ "[painitialsA]=?,"
					+ "[pacountA]=?,"
					+ "[patotalareaA]=?,"
					+ "[paavgareaA]=?,"
					+ "[pappmA]=?,"
					+ "[pacommentA]=?,"
					+ "[totimeB]=?,"
					+ "[toinitialsB]=?,"
					+ "[tocountB]=?,"
					+ "[tototalareaB]=?,"
					+ "[toavgareaB]=?,"
					+ "[toppmB]=?,"
					+ "[tocommentB]=?,"
					+ "[retimeB]=?,"
					+ "[reinitialsB]=?,"
					+ "[recountB]=?,"
					+ "[retotalareaB]=?,"
					+ "[reavgareaB]=?,"
					+ "[reppmB]=?,"
					+ "[recommentB]=?,"
					+ "[patimeB]=?,"
					+ "[painitialsB]=?,"
					+ "[pacountB]=?,"
					+ "[patotalareaB]=?,"
					+ "[paavgareaB]=?,"
					+ "[pappmB]=?,"
					+ "[pacommentB]=?,"
					+ "[psftimeA]=?,"
					+ "[psfinitialsA]=?,"
					+ "[psfcountA]=?,"
					+ "[psftotalareaA]=?,"
					+ "[psfavgareaA]=?,"
					+ "[psfppmA]=?,"
					+ "[psfcommentA]=?,"
					+ "[psatimeA]=?,"
					+ "[psainitialsA]=?,"
					+ "[psacountA]=?,"
					+ "[psatotalareaA]=?,"
					+ "[psaavgareaA]=?,"
					+ "[psappmA]=?,"
					+ "[psacommentA]=?,"
					+ "[psftimeB]=?,"
					+ "[psfinitialsB]=?,"
					+ "[psfcountB]=?,"
					+ "[psftotalareaB]=?,"
					+ "[psfavgareaB]=?,"
					+ "[psfppmB]=?,"
					+ "[psfcommentB]=?,"
					+ "[psatimeB]=?,"
					+ "[psainitialsB]=?,"
					+ "[psacountB]=?,"
					+ "[psatotalareaB]=?,"
					+ "[psaavgareaB]=?,"
					+ "[psappmB]=?,"
					+ "[psacommentB]=?,"
					+ "[efficiencyA]=?,"
					+ "[efficiencyB]=?"
					+ " where [ID]=? ";
			
			
			jdbcTemplate.update(new PreparedStatementCreator() {
				
				@Override
				public PreparedStatement createPreparedStatement(Connection arg0)
						throws SQLException {
					PreparedStatement statement=arg0.prepareStatement(sql);
					
					
					statement.setTimestamp(1, new Timestamp(stickiesData.getDate().getTime()));
					statement.setString(2, stickiesData.getTtimeA());
					statement.setString(3, stickiesData.getTinitialsA());
					statement.setString(4, stickiesData.getTcountA());
					statement.setString(5, stickiesData.getTtotalareaA());
					statement.setString(6, stickiesData.getTavgareaA());
					statement.setString(7, stickiesData.getTppmA());
					statement.setString(8, stickiesData.getTcommentA());
					
					statement.setString(9, stickiesData.getRetimeA());
					statement.setString(10, stickiesData.getReinitialsA());
					statement.setString(11, stickiesData.getRecountA());
					statement.setString(12, stickiesData.getRetotalareaA());
					statement.setString(13, stickiesData.getReavgareaA());
					statement.setString(14, stickiesData.getReppmA());
					statement.setString(15, stickiesData.getRecommentA());
					
					statement.setString(16, stickiesData.getPatimeA());
					statement.setString(17, stickiesData.getPainitialsA());
					statement.setString(18, stickiesData.getPacountA());
					statement.setString(19, stickiesData.getPatotalareaA());
					statement.setString(20, stickiesData.getPaavgareaA());
					statement.setString(21, stickiesData.getPappmA());
					statement.setString(22, stickiesData.getPacommentA());
					
					statement.setString(23, stickiesData.getTotimeB());
					statement.setString(24, stickiesData.getToinitialsB());
					statement.setString(25, stickiesData.getTocountB());
					statement.setString(26, stickiesData.getTototalareaB());
					statement.setString(27, stickiesData.getToavgareaB());
					statement.setString(28, stickiesData.getToppmB());
					statement.setString(29, stickiesData.getTocommentB());
					
					statement.setString(30, stickiesData.getRetimeB());
					statement.setString(31, stickiesData.getReinitialsB());
					statement.setString(32, stickiesData.getRecountB());
					statement.setString(33, stickiesData.getRetotalareaB());
					statement.setString(34, stickiesData.getReavgareaB());
					statement.setString(35, stickiesData.getReppmB());
					statement.setString(36, stickiesData.getRecommentB());
					
					statement.setString(37, stickiesData.getPatimeB());
					statement.setString(38, stickiesData.getPainitialsB());
					statement.setString(39, stickiesData.getPacountB());
					statement.setString(40, stickiesData.getPatotalareaB());
					statement.setString(41, stickiesData.getPaavgareaB());
					statement.setString(42, stickiesData.getPappmB());
					statement.setString(43, stickiesData.getPacommentB());
				
					statement.setString(44, stickiesData.getPsftimeA());
					statement.setString(45, stickiesData.getPsfinitialsA());
					statement.setString(46, stickiesData.getPsfcountA());
					statement.setString(47, stickiesData.getPsftotalareaA());
					statement.setString(48, stickiesData.getPsfavgareaA());
					statement.setString(49, stickiesData.getPsfppmA());
					statement.setString(50, stickiesData.getPsfcommentA());
					statement.setString(51, stickiesData.getPsatimeA());
					statement.setString(52, stickiesData.getPsainitialsA());
					statement.setString(53, stickiesData.getPsacountA());
					statement.setString(54, stickiesData.getPsatotalareaA());
					statement.setString(55, stickiesData.getPsaavgareaA());
					statement.setString(56, stickiesData.getPsappmA());
					statement.setString(57, stickiesData.getPsacommentA());
					
					statement.setString(58, stickiesData.getPsftimeB());
					statement.setString(59, stickiesData.getPsfinitialsB());
					statement.setString(60, stickiesData.getPsfcountB());
					statement.setString(61, stickiesData.getPsftotalareaB());
					statement.setString(62, stickiesData.getPsfavgareaB());
					statement.setString(63, stickiesData.getPsfppmB());
					statement.setString(64, stickiesData.getPsfcommentB());
					statement.setString(65, stickiesData.getPsatimeB());
					statement.setString(66, stickiesData.getPsainitialsB());
					statement.setString(67, stickiesData.getPsacountB());
					statement.setString(68, stickiesData.getPsatotalareaB());
					statement.setString(69, stickiesData.getPsaavgareaB());
					statement.setString(70, stickiesData.getPsappmB());
					statement.setString(71, stickiesData.getPsacommentB());
					
					statement.setString(72, stickiesData.getEfficiencyA());
					statement.setString(73, stickiesData.getEfficiencyB());
					
					statement.setInt(74, stickiesData.getId());
					
					return statement;
				}
			});
			
			id=stickiesData.getId();
		}
		
		
		return id;
	
	}

	/* (non-Javadoc)
	 * @see com.st.frppressquality.dao.FrpPressQualityDao#getStickiesData(java.util.Date, java.util.Date)
	 */
	@Override
	public List<StickiesData> getStickiesData(Date sdate, Date edate) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		
		Calendar scal=Calendar.getInstance();
		scal.setTime(sdate);
		Calendar ecal=Calendar.getInstance();
		ecal.setTime(edate);
		
		String sql="select * from [stickiesData] where [Date] between ? and ?";
		
		List<StickiesData> StickiesData=jdbcTemplate.query(sql, new Object[]{
				new Timestamp(scal.getTime().getTime()),
				new Timestamp(ecal.getTime().getTime())
		}, new RowMapper<StickiesData>(){

			@Override
			public StickiesData mapRow(ResultSet rs, int arg1)
					throws SQLException {
				StickiesData StickiesData=new StickiesData();
				StickiesData.setId(rs.getInt("ID"));
				StickiesData.setDate(rs.getDate("Date"));
				StickiesData.setTtimeA(rs.getString("ttimeA"));
				StickiesData.setTinitialsA(rs.getString("tinitialsA"));
				StickiesData.setTcountA(rs.getString("tcountA"));
				StickiesData.setTtotalareaA(rs.getString("ttotalareaA"));
				StickiesData.setTavgareaA(rs.getString("tavgareaA"));
				StickiesData.setTppmA(rs.getString("tppmA"));
				StickiesData.setTcommentA(rs.getString("tcommentA"));
				StickiesData.setRetimeA(rs.getString("retimeA"));
				StickiesData.setReinitialsA(rs.getString("reinitialsA"));
				StickiesData.setRecountA(rs.getString("recountA"));
				StickiesData.setRetotalareaA(rs.getString("retotalareaA"));
				StickiesData.setReavgareaA(rs.getString("reavgareaA"));
				StickiesData.setReppmA(rs.getString("reppmA"));
				StickiesData.setRecommentA(rs.getString("recommentA"));
				StickiesData.setPatimeA(rs.getString("patimeA"));
				StickiesData.setPainitialsA(rs.getString("painitialsA"));
				StickiesData.setPacountA(rs.getString("pacountA"));
				StickiesData.setPatotalareaA(rs.getString("patotalareaA"));
				StickiesData.setPaavgareaA(rs.getString("paavgareaA"));
				StickiesData.setPappmA(rs.getString("pappmA"));
				StickiesData.setPacommentA(rs.getString("pacommentA"));
				StickiesData.setTotimeB(rs.getString("totimeB"));
				StickiesData.setToinitialsB(rs.getString("toinitialsB"));
				StickiesData.setTocountB(rs.getString("tocountB"));
				StickiesData.setTototalareaB(rs.getString("tototalareaB"));
				StickiesData.setToavgareaB(rs.getString("toavgareaB"));
				StickiesData.setToppmB(rs.getString("toppmB"));
				StickiesData.setTocommentB(rs.getString("tocommentB"));
				StickiesData.setRetimeB(rs.getString("retimeB"));
				StickiesData.setReinitialsB(rs.getString("reinitialsB"));
				StickiesData.setRecountB(rs.getString("recountB"));
				StickiesData.setRetotalareaB(rs.getString("retotalareaB"));
				StickiesData.setReavgareaB(rs.getString("reavgareaB"));
				StickiesData.setReppmB(rs.getString("reppmB"));
				StickiesData.setRecommentB(rs.getString("recommentB"));
				StickiesData.setPatimeB(rs.getString("patimeB"));
				StickiesData.setPainitialsB(rs.getString("painitialsB"));
				StickiesData.setPacountB(rs.getString("pacountB"));
				StickiesData.setPatotalareaB(rs.getString("patotalareaB"));
				StickiesData.setPaavgareaB(rs.getString("paavgareaB"));
				StickiesData.setPappmB(rs.getString("pappmB"));
				StickiesData.setPacommentB(rs.getString("pacommentB"));
				
				StickiesData.setPsftimeA(rs.getString("psftimeA"));
				StickiesData.setPsfinitialsA(rs.getString("psfinitialsA"));
				StickiesData.setPsfcountA(rs.getString("psfcountA"));
				StickiesData.setPsftotalareaA(rs.getString("psftotalareaA"));
				StickiesData.setPsfavgareaA(rs.getString("psfavgareaA"));
				StickiesData.setPsfppmA(rs.getString("psfppmA"));
				StickiesData.setPsfcommentA(rs.getString("psfcommentA"));
				StickiesData.setPsatimeA(rs.getString("psatimeA"));
				StickiesData.setPsainitialsA(rs.getString("psainitialsA"));
				StickiesData.setPsacountA(rs.getString("psacountA"));
				StickiesData.setPsatotalareaA(rs.getString("psatotalareaA"));
				StickiesData.setPsaavgareaA(rs.getString("psaavgareaA"));
				StickiesData.setPsappmA(rs.getString("psappmA"));
				StickiesData.setPsacommentA(rs.getString("psacommentA"));
				StickiesData.setPsftimeB(rs.getString("psftimeB"));
				StickiesData.setPsfinitialsB(rs.getString("psfinitialsB"));
				StickiesData.setPsfcountB(rs.getString("psfcountB"));
				StickiesData.setPsftotalareaB(rs.getString("psftotalareaB"));
				StickiesData.setPsfavgareaB(rs.getString("psfavgareaB"));
				StickiesData.setPsfppmB(rs.getString("psfppmB"));
				StickiesData.setPsfcommentB(rs.getString("psfcommentB"));
				StickiesData.setPsatimeB(rs.getString("psatimeB"));
				StickiesData.setPsainitialsB(rs.getString("psainitialsB"));
				StickiesData.setPsacountB(rs.getString("psacountB"));
				StickiesData.setPsatotalareaB(rs.getString("psatotalareaB"));
				StickiesData.setPsaavgareaB(rs.getString("psaavgareaB"));
				StickiesData.setPsappmB(rs.getString("psappmB"));
				StickiesData.setPsacommentB(rs.getString("psacommentB"));
				StickiesData.setEfficiencyA(rs.getString("efficiencyA"));
				StickiesData.setEfficiencyB(rs.getString("efficiencyB"));
				
				return StickiesData;
			}
			
		});
		
		return StickiesData;
	}

	/* (non-Javadoc)
	 * @see com.st.frppressquality.dao.FrpPressQualityDao#update(com.st.frppressquality.model.StickiesData)
	 */
	@Override
	public void update(final StickiesData stickiesData) {
		// TODO Auto-generated method stub
		
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		final String sql="update [stickiesData] set "
				+ "[Date]=?,"
				+ "[ttimeA]=?,"
				+ "[tinitialsA]=?,"
				+ "[tcountA]=?,"
				+ "[ttotalareaA]=?,"
				+ "[tavgareaA]=?,"
				+ "[tppmA]=?,"
				+ "[tcommentA]=?,"
				+ "[retimeA]=?,"
				+ "[reinitialsA]=?,"
				+ "[recountA]=?,"
				+ "[retotalareaA]=?,"
				+ "[reavgareaA]=?,"
				+ "[reppmA]=?,"
				+ "[recommentA]=?,"
				+ "[patimeA]=?,"
				+ "[painitialsA]=?,"
				+ "[pacountA]=?,"
				+ "[patotalareaA]=?,"
				+ "[paavgareaA]=?,"
				+ "[pappmA]=?,"
				+ "[pacommentA]=?,"
				+ "[totimeB]=?,"
				+ "[toinitialsB]=?,"
				+ "[tocountB]=?,"
				+ "[tototalareaB]=?,"
				+ "[toavgareaB]=?,"
				+ "[toppmB]=?,"
				+ "[tocommentB]=?,"
				+ "[retimeB]=?,"
				+ "[reinitialsB]=?,"
				+ "[recountB]=?,"
				+ "[retotalareaB]=?,"
				+ "[reavgareaB]=?,"
				+ "[reppmB]=?,"
				+ "[recommentB]=?,"
				+ "[patimeB]=?,"
				+ "[painitialsB]=?,"
				+ "[pacountB]=?,"
				+ "[patotalareaB]=?,"
				+ "[paavgareaB]=?,"
				+ "[pappmB]=?,"
				+ "[pacommentB]=?,"
				+ "[psftimeA]=?,"
				+ "[psfinitialsA]=?,"
				+ "[psfcountA]=?,"
				+ "[psftotalareaA]=?,"
				+ "[psfavgareaA]=?,"
				+ "[psfppmA]=?,"
				+ "[psfcommentA]=?,"
				+ "[psatimeA]=?,"
				+ "[psainitialsA]=?,"
				+ "[psacountA]=?,"
				+ "[psatotalareaA]=?,"
				+ "[psaavgareaA]=?,"
				+ "[psappmA]=?,"
				+ "[psacommentA]=?,"
				+ "[psftimeB]=?,"
				+ "[psfinitialsB]=?,"
				+ "[psfcountB]=?,"
				+ "[psftotalareaB]=?,"
				+ "[psfavgareaB]=?,"
				+ "[psfppmB]=?,"
				+ "[psfcommentB]=?,"
				+ "[psatimeB]=?,"
				+ "[psainitialsB]=?,"
				+ "[psacountB]=?,"
				+ "[psatotalareaB]=?,"
				+ "[psaavgareaB]=?,"
				+ "[psappmB]=?,"
				+ "[psacommentB]=?,"
				+ "[efficiencyA]=?,"
				+ "[efficiencyB]=?"
				+ " where [ID]=? ";
		
		
		jdbcTemplate.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection arg0)
					throws SQLException {
				PreparedStatement statement=arg0.prepareStatement(sql);
				
				
				statement.setTimestamp(1, new Timestamp(stickiesData.getDate().getTime()));
				statement.setString(2, stickiesData.getTtimeA());
				statement.setString(3, stickiesData.getTinitialsA());
				statement.setString(4, stickiesData.getTcountA());
				statement.setString(5, stickiesData.getTtotalareaA());
				statement.setString(6, stickiesData.getTavgareaA());
				statement.setString(7, stickiesData.getTppmA());
				statement.setString(8, stickiesData.getTcommentA());
				
				statement.setString(9, stickiesData.getRetimeA());
				statement.setString(10, stickiesData.getReinitialsA());
				statement.setString(11, stickiesData.getRecountA());
				statement.setString(12, stickiesData.getRetotalareaA());
				statement.setString(13, stickiesData.getReavgareaA());
				statement.setString(14, stickiesData.getReppmA());
				statement.setString(15, stickiesData.getRecommentA());
				
				statement.setString(16, stickiesData.getPatimeA());
				statement.setString(17, stickiesData.getPainitialsA());
				statement.setString(18, stickiesData.getPacountA());
				statement.setString(19, stickiesData.getPatotalareaA());
				statement.setString(20, stickiesData.getPaavgareaA());
				statement.setString(21, stickiesData.getPappmA());
				statement.setString(22, stickiesData.getPacommentA());
				
				statement.setString(23, stickiesData.getTotimeB());
				statement.setString(24, stickiesData.getToinitialsB());
				statement.setString(25, stickiesData.getTocountB());
				statement.setString(26, stickiesData.getTototalareaB());
				statement.setString(27, stickiesData.getToavgareaB());
				statement.setString(28, stickiesData.getToppmB());
				statement.setString(29, stickiesData.getTocommentB());
				
				statement.setString(30, stickiesData.getRetimeB());
				statement.setString(31, stickiesData.getReinitialsB());
				statement.setString(32, stickiesData.getRecountB());
				statement.setString(33, stickiesData.getRetotalareaB());
				statement.setString(34, stickiesData.getReavgareaB());
				statement.setString(35, stickiesData.getReppmB());
				statement.setString(36, stickiesData.getRecommentB());
				
				statement.setString(37, stickiesData.getPatimeB());
				statement.setString(38, stickiesData.getPainitialsB());
				statement.setString(39, stickiesData.getPacountB());
				statement.setString(40, stickiesData.getPatotalareaB());
				statement.setString(41, stickiesData.getPaavgareaB());
				statement.setString(42, stickiesData.getPappmB());
				statement.setString(43, stickiesData.getPacommentB());
			
				statement.setString(44, stickiesData.getPsftimeA());
				statement.setString(45, stickiesData.getPsfinitialsA());
				statement.setString(46, stickiesData.getPsfcountA());
				statement.setString(47, stickiesData.getPsftotalareaA());
				statement.setString(48, stickiesData.getPsfavgareaA());
				statement.setString(49, stickiesData.getPsfppmA());
				statement.setString(50, stickiesData.getPsfcommentA());
				statement.setString(51, stickiesData.getPsatimeA());
				statement.setString(52, stickiesData.getPsainitialsA());
				statement.setString(53, stickiesData.getPsacountA());
				statement.setString(54, stickiesData.getPsatotalareaA());
				statement.setString(55, stickiesData.getPsaavgareaA());
				statement.setString(56, stickiesData.getPsappmA());
				statement.setString(57, stickiesData.getPsacommentA());
				
				statement.setString(58, stickiesData.getPsftimeB());
				statement.setString(59, stickiesData.getPsfinitialsB());
				statement.setString(60, stickiesData.getPsfcountB());
				statement.setString(61, stickiesData.getPsftotalareaB());
				statement.setString(62, stickiesData.getPsfavgareaB());
				statement.setString(63, stickiesData.getPsfppmB());
				statement.setString(64, stickiesData.getPsfcommentB());
				statement.setString(65, stickiesData.getPsatimeB());
				statement.setString(66, stickiesData.getPsainitialsB());
				statement.setString(67, stickiesData.getPsacountB());
				statement.setString(68, stickiesData.getPsatotalareaB());
				statement.setString(69, stickiesData.getPsaavgareaB());
				statement.setString(70, stickiesData.getPsappmB());
				statement.setString(71, stickiesData.getPsacommentB());
				
				statement.setString(72, stickiesData.getEfficiencyA());
				statement.setString(73, stickiesData.getEfficiencyB());
				
				statement.setInt(74, stickiesData.getId());
				
				return statement;
			}
		});
		
	
	
		
	}

	/* (non-Javadoc)
	 * @see com.st.frppressquality.dao.FrpPressQualityDao#deleteStickiedata(int)
	 */
	@Override
	public void deleteStickiedata(int id) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		String sql="delete from [stickiesData] where [ID]=?";
		jdbcTemplate.update(sql, new Object[]{id});
		
	}

	@Override
	public List<StickiesData> getStickiesDataById(int id) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		
		
		String sql="select * from [stickiesData] where [id]=?";
		
		List<StickiesData> StickiesData=jdbcTemplate.query(sql, new Object[]{
				id
		}, new RowMapper<StickiesData>(){

			@Override
			public StickiesData mapRow(ResultSet rs, int arg1)
					throws SQLException {
				StickiesData StickiesData=new StickiesData();
				StickiesData.setId(rs.getInt("ID"));
				StickiesData.setDate(rs.getDate("Date"));
				StickiesData.setTtimeA(rs.getString("ttimeA"));
				StickiesData.setTinitialsA(rs.getString("tinitialsA"));
				StickiesData.setTcountA(rs.getString("tcountA"));
				StickiesData.setTtotalareaA(rs.getString("ttotalareaA"));
				StickiesData.setTavgareaA(rs.getString("tavgareaA"));
				StickiesData.setTppmA(rs.getString("tppmA"));
				StickiesData.setTcommentA(rs.getString("tcommentA"));
				StickiesData.setRetimeA(rs.getString("retimeA"));
				StickiesData.setReinitialsA(rs.getString("reinitialsA"));
				StickiesData.setRecountA(rs.getString("recountA"));
				StickiesData.setRetotalareaA(rs.getString("retotalareaA"));
				StickiesData.setReavgareaA(rs.getString("reavgareaA"));
				StickiesData.setReppmA(rs.getString("reppmA"));
				StickiesData.setRecommentA(rs.getString("recommentA"));
				StickiesData.setPatimeA(rs.getString("patimeA"));
				StickiesData.setPainitialsA(rs.getString("painitialsA"));
				StickiesData.setPacountA(rs.getString("pacountA"));
				StickiesData.setPatotalareaA(rs.getString("patotalareaA"));
				StickiesData.setPaavgareaA(rs.getString("paavgareaA"));
				StickiesData.setPappmA(rs.getString("pappmA"));
				StickiesData.setPacommentA(rs.getString("pacommentA"));
				StickiesData.setTotimeB(rs.getString("totimeB"));
				StickiesData.setToinitialsB(rs.getString("toinitialsB"));
				StickiesData.setTocountB(rs.getString("tocountB"));
				StickiesData.setTototalareaB(rs.getString("tototalareaB"));
				StickiesData.setToavgareaB(rs.getString("toavgareaB"));
				StickiesData.setToppmB(rs.getString("toppmB"));
				StickiesData.setTocommentB(rs.getString("tocommentB"));
				StickiesData.setRetimeB(rs.getString("retimeB"));
				StickiesData.setReinitialsB(rs.getString("reinitialsB"));
				StickiesData.setRecountB(rs.getString("recountB"));
				StickiesData.setRetotalareaB(rs.getString("retotalareaB"));
				StickiesData.setReavgareaB(rs.getString("reavgareaB"));
				StickiesData.setReppmB(rs.getString("reppmB"));
				StickiesData.setRecommentB(rs.getString("recommentB"));
				StickiesData.setPatimeB(rs.getString("patimeB"));
				StickiesData.setPainitialsB(rs.getString("painitialsB"));
				StickiesData.setPacountB(rs.getString("pacountB"));
				StickiesData.setPatotalareaB(rs.getString("patotalareaB"));
				StickiesData.setPaavgareaB(rs.getString("paavgareaB"));
				StickiesData.setPappmB(rs.getString("pappmB"));
				StickiesData.setPacommentB(rs.getString("pacommentB"));
				
				StickiesData.setPsftimeA(rs.getString("psftimeA"));
				StickiesData.setPsfinitialsA(rs.getString("psfinitialsA"));
				StickiesData.setPsfcountA(rs.getString("psfcountA"));
				StickiesData.setPsftotalareaA(rs.getString("psftotalareaA"));
				StickiesData.setPsfavgareaA(rs.getString("psfavgareaA"));
				StickiesData.setPsfppmA(rs.getString("psfppmA"));
				StickiesData.setPsfcommentA(rs.getString("psfcommentA"));
				StickiesData.setPsatimeA(rs.getString("psatimeA"));
				StickiesData.setPsainitialsA(rs.getString("psainitialsA"));
				StickiesData.setPsacountA(rs.getString("psacountA"));
				StickiesData.setPsatotalareaA(rs.getString("psatotalareaA"));
				StickiesData.setPsaavgareaA(rs.getString("psaavgareaA"));
				StickiesData.setPsappmA(rs.getString("psappmA"));
				StickiesData.setPsacommentA(rs.getString("psacommentA"));
				StickiesData.setPsftimeB(rs.getString("psftimeB"));
				StickiesData.setPsfinitialsB(rs.getString("psfinitialsB"));
				StickiesData.setPsfcountB(rs.getString("psfcountB"));
				StickiesData.setPsftotalareaB(rs.getString("psftotalareaB"));
				StickiesData.setPsfavgareaB(rs.getString("psfavgareaB"));
				StickiesData.setPsfppmB(rs.getString("psfppmB"));
				StickiesData.setPsfcommentB(rs.getString("psfcommentB"));
				StickiesData.setPsatimeB(rs.getString("psatimeB"));
				StickiesData.setPsainitialsB(rs.getString("psainitialsB"));
				StickiesData.setPsacountB(rs.getString("psacountB"));
				StickiesData.setPsatotalareaB(rs.getString("psatotalareaB"));
				StickiesData.setPsaavgareaB(rs.getString("psaavgareaB"));
				StickiesData.setPsappmB(rs.getString("psappmB"));
				StickiesData.setPsacommentB(rs.getString("psacommentB"));
				StickiesData.setEfficiencyA(rs.getString("efficiencyA"));
				StickiesData.setEfficiencyB(rs.getString("efficiencyB"));
				
				return StickiesData;
			}
			
		});
		
		return StickiesData;
	}

}

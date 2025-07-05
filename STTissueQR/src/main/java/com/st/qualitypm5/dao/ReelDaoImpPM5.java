/**
 *Dec 22, 2017
 *ReelDaoImpPM5.java
 * TODO
 *com.st.qualitypm5.dao
 *ReelDaoImpPM5.java
 *Roshan Lal Tailor
 */
package com.st.qualitypm5.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.commons.lang3.math.NumberUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.st.common.ColumnsOfTable;
import com.st.common.CommonProperties;
import com.st.common.CommonUtil;
import com.st.common.GradeTargetUtil;
import com.st.qualitypm5.mapper.ReelMapperPM5;
import com.st.qualitypm5.model.ReelPM5;
import com.st.qualitypm6.dao.ReelDaoImp;
import com.st.qualitypm6.mapper.GradeTargetMapper;
import com.st.qualitypm6.mapper.ReelMapper;
import com.st.qualitypm6.model.GradeTarget;
import com.st.qualitypm6.model.Reel;

/**
 * @author roshan
 *
 */
@Repository
public class ReelDaoImpPM5 implements ReelDaoPM5 {
	private static final Logger logger=LoggerFactory.getLogger(ReelDaoImp.class);
	
	@Autowired
	private DataSource dataSource;
	@Override
	public List<ReelPM5> getReels(String gradeCode, Date date) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		
	//	System.out.println("Shift date="+date);
		
		Calendar scal=Calendar.getInstance();
		scal.setTime(date);
		scal.set(Calendar.HOUR_OF_DAY, 7);
		scal.set(Calendar.MINUTE, 0);
		scal.set(Calendar.SECOND, 0);
		scal.set(Calendar.MILLISECOND, 0);
		
		Calendar ecal=Calendar.getInstance();
		ecal.setTime(date);
		ecal.set(Calendar.HOUR_OF_DAY, 6);
		ecal.set(Calendar.MINUTE, 59);
		ecal.set(Calendar.SECOND, 59);
		ecal.set(Calendar.MILLISECOND, 0);
		ecal.add(Calendar.DATE, 1);
		
	//	System.out.println("Start Date="+scal.getTime());
	//	System.out.println("End Date="+ecal.getTime());
		
		String sql="select * from [reelTesting_pm5] where"
				+ " [GradeCode]=?"
				+ " and "
				+ " [Date] between ? and ?  "
				+ " order by [Date], [Reel], [ID]";
		
		List<ReelPM5> reels = jdbcTemplate.query(sql, new Object[] { gradeCode,
				new Timestamp(scal.getTime().getTime()),
				new Timestamp(ecal.getTime().getTime()) }, new ReelMapperPM5());
		
		return reels;
	}
	
	
	@Override
	public boolean isReelNumberExist(String reelNo,String year) {
		boolean reelFlag=false;
		
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		String sql="select count(*) from [reelTesting_pm5] where [Reel]='"+reelNo+"' and year(date)='"+year+"'";
		System.out.println(sql);
		int count=jdbcTemplate.queryForObject(sql,Integer.class);
		if(count!=0){
			reelFlag=true;
		}
		
		return reelFlag;
	}
	@Override
	public boolean isReelNumberExist(String reelNo) {
		boolean reelFlag=false;
		
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		String sql="select count(*) from [reelTesting_pm5] where [Reel]='"+reelNo+"'";
		
		int count=jdbcTemplate.queryForObject(sql,Integer.class);
		if(count!=0){
			reelFlag=true;
		}
		
		return reelFlag;
	}
	
	/*@Override
	public List<Reel> getReels(String gradeCode, Date date, String entryAutoFlag) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		
		String sql="select * from [reelTesting] where [GradeCode]=? and [Date]=? and [enterAutoFlag]=?   order by [Date], [Reel], [ID]";
		List<Reel> reels=null;
		try {
			reels=jdbcTemplate.query(sql, new Object[]{gradeCode,new java.sql.Date(date.getTime()),entryAutoFlag}, new ReelMapper());

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return reels;
	}*/
	
	@Override
	public List<String> getReels() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		String sql = "select [reel] from [reelTesting_pm5] order by [Date] DESC,[Reel] DESC, [ID]  DESC";

		@SuppressWarnings({ "unchecked", "rawtypes" })
		List<String> reels = jdbcTemplate.query(sql, new RowMapper() {
			@Override
			public Object mapRow(ResultSet rs, int arg1) throws SQLException {
				return rs.getString(1);
			}
		});

		return reels;
	}

	@Override
	public List<String> getReelByGradeCode(String gradeCode) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		String sql = "select [reel] from [reelTesting_pm5] where [GradeCode]='"+gradeCode+"'   order by [Date], [Reel], [ID]";

		@SuppressWarnings({ "unchecked", "rawtypes" })
		List<String> reels = jdbcTemplate.query(sql,new RowMapper() {
			@Override
			public Object mapRow(ResultSet rs, int arg1) throws SQLException {
				return rs.getString(1);
			}
		});
		 Collections.reverse(reels);
		return reels;
	}
	
	@Override
	public void delete(final List<String> idsList) {
		
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		String sql="delete from [reelTesting_pm5] where [id]=?";
		
		jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement statement, int arg1) throws SQLException {
				String string=idsList.get(arg1);
				statement.setString(1, string);
			}
			
			@Override
			public int getBatchSize() {
				return idsList.size();
			}
		});
		
	
	}
	
	@Override
	public Object getCustomerName(String gradeCode, String reelNo) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		String custName="";
		String sql="select [Customer] from [reelTesting_pm5] where [GradeCode]=? and [Reel]=?";
		try{
			custName=jdbcTemplate.queryForObject(sql, new Object[]{gradeCode,reelNo}, String.class);
			
		}catch(Exception e){
			e.getStackTrace();
		}
		
		return custName;
	}
	
	@Override
	public int save(final ReelPM5 reel) throws Exception {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		
		final String sql="insert into [reelTesting_pm5]"
				+ "("
				+ "[Date],"
				+ "[Time],"
				+ "[GradeCode],"
				+ "[Reel],"
				+ "[ScannerBasisWt],"
				+ "[ActualBasisWt],"
				+ "[Bulk],"
				+ "[MDTensile],"
				+ "[CDTensile],"
				+ "[MDStretch],"
				+ "[MDCDTensileRatio],"
				+ "[MDWetTensile],"
				+ "[CDWetTensile],"
				+ "[CDTensileRatio],"
				+ "[Brightness],"
				+ "[FWAFlow],"
				+ "[DirtCount],"
				+ "[FWADosage],"
				+ "[TPH],"
				+ "[Trim],"
				+ "[CrepeRatio],"
//				Code Starts From Done By Roshan Tailor Date:- 03/05/2015 MM/DD//YYYY
				+ "[Lvalue],"
				+ "[Avalue],"
				+ "[Bvalue],"
				+ "[deltae],"
//				Code Ends Here Done By Roshan Tailor
				+ "[Customer],"
				+ "[Remarks],"
				+ "[akd],"
				+ "[wetstrength],"
				+ "[drystrengthflow] , "
				+ "[Customer1],"
				+ "[Customer2],"
				+ "[FinchCup] )"
			//	+ "[enterAutoFlag] ) "
				+ " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)"; //Changes Done Here Also By Roshan Tailor
									
			 KeyHolder keyHolder=new GeneratedKeyHolder();
			 
			 jdbcTemplate.update(new PreparedStatementCreator() {
				
				@Override
				public PreparedStatement createPreparedStatement(Connection arg0)
						throws SQLException {
						PreparedStatement statement=arg0.prepareStatement(sql,new String[]{"ID"});
						
						statement.setTimestamp(1, new Timestamp(reel.getDate().getTime()));
						
						if(reel.getTime()!=null){
							statement.setTimestamp(2, new Timestamp(reel.getTime().getTime()));
						}else{
							statement.setNull(2, Types.TIMESTAMP);
						}
						statement.setString(3, reel.getGradeCode());
						statement.setString(4, reel.getReel());
						statement.setDouble(5, reel.getScannerBasisWt());
						statement.setDouble(6, reel.getActualBasisWt());
						statement.setDouble(7, reel.getBulk());
						statement.setDouble(8, reel.getMdTensile());
						statement.setDouble(9, reel.getCdTensile());
						statement.setDouble(10, reel.getMdStretch());
						statement.setDouble(11, reel.getMdcdTensileRatio());
						statement.setDouble(12, reel.getMdWetTensile());
						statement.setDouble(13, reel.getCdWetTensile());
						statement.setDouble(14, reel.getWetDryRatio());
						statement.setDouble(15, reel.getBrightness());
						statement.setDouble(16, reel.getFwaFlow());
						statement.setDouble(17, reel.getDirtCount());
						statement.setDouble(18, reel.getFwaDosage());
						statement.setDouble(19, reel.getTph());
						statement.setDouble(20, reel.getTrim());
						statement.setDouble(21, reel.getCrepeRatio());
//						Code Starts From Here Done By Roshan Tailor Date:-03/05/2015 MM/DD/YYYY
						statement.setDouble(22, reel.getLvalue());
						statement.setDouble(23, reel.getAvalue());
						statement.setDouble(24, reel.getBvalue());
						statement.setDouble(25, reel.getDeltae());
//						Code Ends Here Done By Roshan Tailor
						statement.setString(26, reel.getCustomer());
						statement.setString(27, reel.getRemarks());
						
						statement.setDouble(28, reel.getAkd());
						statement.setDouble(29, reel.getWetstrength());
						statement.setDouble(30, reel.getDrystrengthflow());
						
						statement.setString(31, reel.getCustomer1());
						statement.setString(32, reel.getCustomer2());
						statement.setDouble(33, reel.getFinchCup());
					//	statement.setString(24, entryAutoFlag);
						
					return statement;
				}
			},keyHolder);
			 
			 
					
			 return keyHolder.getKey().intValue();	
		
	}

	/*@Override
	public void update(final Reel reel, final String entryAutoFlag) throws Exception {
		String sql="update [reelTesting] SET "
				
							+ "[Date]=?,"
							+ "[Time]=?,"
							+ "[GradeCode]=?,"
							+ "[Reel]=?,"
							+ "[ScannerBasisWt]=?,"
							+ "[ActualBasisWt]=?,"
							+ "[Bulk]=?,"
							+ "[MDTensile]=?,"
							+ "[CDTensile]=?,"
							+ "[MDStretch]=?,"
							+ "[MDCDTensileRatio]=?,"
							+ "[MDWetTensile]=?,"
							+ "[CDWetTensile]=?,"
							+ "[CDTensileRatio]=?,"
							+ "[Brightness]=?,"
							+ "[FWAFlow]=?,"
							+ "[DirtCount]=?,"
							+ "[FWADosage]=?,"
							+ "[TPH]=?,"
							+ "[Trim]=?,"
							+ "[CrepeRatio]=?,"
							+ "[Customer]=?,"
							+ "[Remarks]=?,"
							+ "[enterAutoFlag]=? "
							+ " where [ID]=?";
					

					JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
					jdbcTemplate.execute(sql, new PreparedStatementCallback<Boolean>() {

						@Override
						public Boolean doInPreparedStatement(
								PreparedStatement statement) throws SQLException,
								DataAccessException {
							statement.setTimestamp(1, new Timestamp(reel.getDate().getTime()));
							
							if(reel.getTime()!=null){
								statement.setTimestamp(2, new Timestamp(reel.getTime().getTime()));
							}else{
								statement.setNull(2, Types.TIMESTAMP);
							}
							
							
							statement.setString(3, reel.getGradeCode());
							statement.setString(4, reel.getReel());
							statement.setDouble(5, reel.getScannerBasisWt());
							statement.setDouble(6, reel.getActualBasisWt());
							statement.setDouble(7, reel.getBulk());
							statement.setDouble(8, reel.getMdTensile());
							statement.setDouble(9, reel.getCdTensile());
							statement.setDouble(10, reel.getMdStretch());
							statement.setDouble(11, reel.getMdcdTensileRatio());
							statement.setDouble(12, reel.getMdWetTensile());
							statement.setDouble(13, reel.getCdWetTensile());
							statement.setDouble(14, reel.getCdTensileRatio());
							statement.setDouble(15, reel.getBrightness());
							statement.setDouble(16, reel.getFwaFlow());
							statement.setDouble(17, reel.getDirtCount());
							statement.setDouble(18, reel.getFwaDosage());
							statement.setDouble(19, reel.getTph());
							statement.setDouble(20, reel.getTrim());
							statement.setDouble(21, reel.getCrepeRatio());
							statement.setString(22, reel.getCustomer());
							statement.setString(23, reel.getRemarks());
							statement.setString(24, entryAutoFlag);
							
							statement.setInt(25, reel.getId());
							return statement.execute();
						}
					});
			
					
					
					
	}*/


/*	@Override
	public List<Reel> getReels(Date sdate, Date edate) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		
		Calendar scal=Calendar.getInstance();
		scal.setTime(sdate);
		scal.set(Calendar.HOUR_OF_DAY, 7);
		scal.set(Calendar.MINUTE, 0);
		scal.set(Calendar.SECOND, 0);
		scal.set(Calendar.MILLISECOND, 0);
		
		Calendar ecal=Calendar.getInstance();
		ecal.setTime(edate);
		ecal.set(Calendar.HOUR_OF_DAY, 6);
		ecal.set(Calendar.MINUTE, 59);
		ecal.set(Calendar.SECOND, 0);
		ecal.set(Calendar.MILLISECOND, 0);
		ecal.add(Calendar.DATE, 1);
		
		
		
		String sql="select * from [reelTesting] where [Date] BETWEEN  ? AND ?   order by [Date], [Reel], [ID]";
		List<Reel> reels=null;
		try {
			reels=jdbcTemplate.query(sql, new Object[]{new java.sql.Date(scal.getTime().getTime()),new java.sql.Date(ecal.getTime().getTime())}, new ReelMapper());

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return reels;
	}


	@Override
	public List<Reel> getReelsByGrade(Date sdate, Date edate, String gradeCode) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		
		Calendar scal=Calendar.getInstance();
		scal.setTime(sdate);
		scal.set(Calendar.HOUR_OF_DAY, 7);
		scal.set(Calendar.MINUTE, 0);
		scal.set(Calendar.SECOND, 0);
		scal.set(Calendar.MILLISECOND, 0);
		
		Calendar ecal=Calendar.getInstance();
		ecal.setTime(edate);
		ecal.set(Calendar.HOUR_OF_DAY, 6);
		ecal.set(Calendar.MINUTE, 59);
		ecal.set(Calendar.SECOND, 0);
		ecal.set(Calendar.MILLISECOND, 0);
		ecal.add(Calendar.DATE, 1);
		
		String sql="select * from [reelTesting] where [GradeCode]=? and [Date] BETWEEN  ? AND ?   order by [Date], [Reel], [ID]";
		List<Reel> reels=null;
		try {
			reels=jdbcTemplate.query(sql, new Object[]{gradeCode,new java.sql.Date(scal.getTime().getTime()),new java.sql.Date(ecal.getTime().getTime())}, new ReelMapper());

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return reels;
	}


	@Override
	public List<Reel> getReelsByCustomer(Date sdate, Date edate, String customer) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		Calendar scal=Calendar.getInstance();
		scal.setTime(sdate);
		scal.set(Calendar.HOUR_OF_DAY, 7);
		scal.set(Calendar.MINUTE, 0);
		scal.set(Calendar.SECOND, 0);
		scal.set(Calendar.MILLISECOND, 0);
		
		Calendar ecal=Calendar.getInstance();
		ecal.setTime(edate);
		ecal.set(Calendar.HOUR_OF_DAY, 6);
		ecal.set(Calendar.MINUTE, 59);
		ecal.set(Calendar.SECOND, 0);
		ecal.set(Calendar.MILLISECOND, 0);
		ecal.add(Calendar.DATE, 1);
		String sql="select * from [reelTesting] where [Customer]=? and [Date] BETWEEN  ? AND ?   order by [Date], [Reel], [ID]";
		List<Reel> reels=null;
		try {
			reels=jdbcTemplate.query(sql, new Object[]{customer,new java.sql.Date(scal.getTime().getTime()),new java.sql.Date(ecal.getTime().getTime())}, new ReelMapper());

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return reels;
	}
*/

	@Override
	public void update(final ReelPM5 reel) throws Exception {
		String sql="update [reelTesting_pm5] SET "
				
							+ "[Date]=?,"
							+ "[Time]=?,"
							+ "[GradeCode]=?,"
							+ "[Reel]=?,"
							+ "[ScannerBasisWt]=?,"
							+ "[ActualBasisWt]=?,"
							+ "[Bulk]=?,"
							+ "[MDTensile]=?,"							
							+ "[CDTensile]=?,"
							+ "[MDStretch]=?,"
							+ "[MDCDTensileRatio]=?,"
							+ "[MDWetTensile]=?,"
							+ "[CDWetTensile]=?,"
							+ "[CDTensileRatio]=?,"
							+ "[Brightness]=?,"
							+ "[FWAFlow]=?,"
							+ "[DirtCount]=?,"
							+ "[FWADosage]=?,"
							+ "[TPH]=?,"
							+ "[Trim]=?,"
							+ "[CrepeRatio]=?,"
//							Code Starts From Here Done By Roshan Tailor Date :- 03/10/2015 MM/DD/YYYY
							+ "[Lvalue]=?,"
							+ "[Avalue]=?,"
							+ "[Bvalue]=?,"
							+ "[deltae]=?,"
//							Code Ends Here Done By Roshan Tailor
							+ "[Customer]=?,"
							+ "[Remarks]=?,"
							+ "[akd]=?,"
							+ "[wetstrength]=?,"
							+ "[drystrengthflow]=?,"
							+ "[Customer1]=?,"
							+ "[Customer2]=?,"
							+ "[FinchCup]=?"
							+ " where [ID]=?";
					

					JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
					jdbcTemplate.execute(sql, new PreparedStatementCallback<Boolean>() {

						@Override
						public Boolean doInPreparedStatement(
								PreparedStatement statement) throws SQLException,
								DataAccessException {
							statement.setTimestamp(1, new Timestamp(reel.getDate().getTime()));
							
							if(reel.getTime()!=null){
								statement.setTimestamp(2, new Timestamp(reel.getTime().getTime()));
							}else{
								statement.setNull(2, Types.TIMESTAMP);
							}
						
							statement.setString(3, reel.getGradeCode());
							statement.setString(4, reel.getReel());
							statement.setDouble(5, reel.getScannerBasisWt());
							statement.setDouble(6, reel.getActualBasisWt());
							statement.setDouble(7, reel.getBulk());
							statement.setDouble(8, reel.getMdTensile());
							statement.setDouble(9, reel.getCdTensile());
							statement.setDouble(10, reel.getMdStretch());
							statement.setDouble(11, reel.getMdcdTensileRatio());
							statement.setDouble(12, reel.getMdWetTensile());
							statement.setDouble(13, reel.getCdWetTensile());
							statement.setDouble(14, reel.getWetDryRatio());
							statement.setDouble(15, reel.getBrightness());
							statement.setDouble(16, reel.getFwaFlow());
							statement.setDouble(17, reel.getDirtCount());
							statement.setDouble(18, reel.getFwaDosage());
							statement.setDouble(19, reel.getTph());
							statement.setDouble(20, reel.getTrim());
							statement.setDouble(21, reel.getCrepeRatio());
//							Code Starts From Here Done Roshan Tailor Date:- 05/03/2015  MM/DD/YYYY
							statement.setDouble(22, reel.getLvalue());
							statement.setDouble(23, reel.getAvalue());
							statement.setDouble(24, reel.getBvalue());
							statement.setDouble(25, reel.getDeltae());
//							Code Ends Here Done By Roshan Tailor						

							statement.setString(26, reel.getCustomer());
							statement.setString(27, reel.getRemarks());
							
							statement.setDouble(28, reel.getAkd());
							statement.setDouble(29, reel.getWetstrength());
							statement.setDouble(30, reel.getDrystrengthflow());
							statement.setString(31, reel.getCustomer1());
							statement.setString(32, reel.getCustomer2());
							statement.setDouble(33, reel.getFinchCup());
							statement.setInt(34, reel.getId());
							return statement.execute();
						}
					});
			
					
		
	}



	/*@Override
	public List<Reel> getReelsByGrade(String gradeCode) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		
		String sql="select * from [reelTesting] where [GradeCode]=?   order by [Date], [Reel], [ID]";
		List<Reel> reels=null;
		try {
			reels=jdbcTemplate.query(sql, new Object[]{gradeCode}, new ReelMapper());

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return reels;
	}


	@Override
	public List<Reel> getReelsByCustomer(String customer) {
	JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		
		String sql="select * from [reelTesting] where [Customer]=?    order by [Date], [Reel], [ID]";
		List<Reel> reels=null;
		try {
			reels=jdbcTemplate.query(sql, new Object[]{customer}, new ReelMapper());

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return reels;
	}


	@Override
	public List<Reel> getReelsByReel(Date sdate, Date edate, String reel) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		Calendar scal=Calendar.getInstance();
		scal.setTime(sdate);
		scal.set(Calendar.HOUR_OF_DAY, 7);
		scal.set(Calendar.MINUTE, 0);
		scal.set(Calendar.SECOND, 0);
		scal.set(Calendar.MILLISECOND, 0);
		
		Calendar ecal=Calendar.getInstance();
		ecal.setTime(edate);
		ecal.set(Calendar.HOUR_OF_DAY, 6);
		ecal.set(Calendar.MINUTE, 59);
		ecal.set(Calendar.SECOND, 0);
		ecal.set(Calendar.MILLISECOND, 0);
		ecal.add(Calendar.DATE, 1);
		String sql="select * from [reelTesting] where [Reel]=? and [Date] BETWEEN  ? AND ?  order by [Date], [Reel], [ID]";
		List<Reel> reels=null;
		try {
			reels=jdbcTemplate.query(sql, new Object[]{reel,new java.sql.Date(scal.getTime().getTime()),new java.sql.Date(ecal.getTime().getTime())}, new ReelMapper());

		} catch (Exception e) {
			e.printStackTrace();
		}

		return reels;
	}


	@Override
	public List<Reel> getReelsByGradeCustomer(Date sdate, Date edate,
			String gradeCode, String customer) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		Calendar scal=Calendar.getInstance();
		scal.setTime(sdate);
		scal.set(Calendar.HOUR_OF_DAY, 7);
		scal.set(Calendar.MINUTE, 0);
		scal.set(Calendar.SECOND, 0);
		scal.set(Calendar.MILLISECOND, 0);
		
		Calendar ecal=Calendar.getInstance();
		ecal.setTime(edate);
		ecal.set(Calendar.HOUR_OF_DAY, 6);
		ecal.set(Calendar.MINUTE, 59);
		ecal.set(Calendar.SECOND, 0);
		ecal.set(Calendar.MILLISECOND, 0);
		ecal.add(Calendar.DATE, 1);
		String sql="select * from [reelTesting] where [GradeCode]=? and [Customer]=? and [Date] BETWEEN  ? AND ?  order by [Date], [Reel], [ID]";
		List<Reel> reels=null;
		try {
			reels=jdbcTemplate.query(sql, new Object[]{gradeCode,customer,new java.sql.Date(scal.getTime().getTime()),new java.sql.Date(ecal.getTime().getTime())}, new ReelMapper());

		} catch (Exception e) {
			e.printStackTrace();
		}

		return reels;	
	}


	@Override
	public List<Reel> getReelsByGradeReel(Date sdate, Date edate,
			String gradeCode, String reel) {
	JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
	Calendar scal=Calendar.getInstance();
	scal.setTime(sdate);
	scal.set(Calendar.HOUR_OF_DAY, 7);
	scal.set(Calendar.MINUTE, 0);
	scal.set(Calendar.SECOND, 0);
	scal.set(Calendar.MILLISECOND, 0);
	
	Calendar ecal=Calendar.getInstance();
	ecal.setTime(edate);
	ecal.set(Calendar.HOUR_OF_DAY, 6);
	ecal.set(Calendar.MINUTE, 59);
	ecal.set(Calendar.SECOND, 0);
	ecal.set(Calendar.MILLISECOND, 0);
	ecal.add(Calendar.DATE, 1);
		String sql="select * from [reelTesting] where [GradeCode]=? and [Reel]=? and [Date] BETWEEN  ? AND ?   order by [Date], [Reel], [ID]";
		List<Reel> reels=null;
		try {
			reels=jdbcTemplate.query(sql, new Object[]{gradeCode,reel,new java.sql.Date(scal.getTime().getTime()),new java.sql.Date(ecal.getTime().getTime())}, new ReelMapper());

		} catch (Exception e) {
			e.printStackTrace();
		}

		return reels;	
	}


	@Override
	public List<Reel> getReelsByGradeCustomerReel(Date sdate, Date edate,
			String gradeCode, String customer, String reel) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		Calendar scal=Calendar.getInstance();
		scal.setTime(sdate);
		scal.set(Calendar.HOUR_OF_DAY, 7);
		scal.set(Calendar.MINUTE, 0);
		scal.set(Calendar.SECOND, 0);
		scal.set(Calendar.MILLISECOND, 0);
		
		Calendar ecal=Calendar.getInstance();
		ecal.setTime(edate);
		ecal.set(Calendar.HOUR_OF_DAY, 6);
		ecal.set(Calendar.MINUTE, 59);
		ecal.set(Calendar.SECOND, 0);
		ecal.set(Calendar.MILLISECOND, 0);
		ecal.add(Calendar.DATE, 1);
		String sql="select * from [reelTesting] where [GradeCode]=? and [Customer]=? and [Reel]=? and [Date] BETWEEN  ? AND ?   order by [Date], [Reel], [ID]";
		List<Reel> reels=null;
		try {
			reels=jdbcTemplate.query(sql, new Object[]{gradeCode,customer,reel,new java.sql.Date(scal.getTime().getTime()),new java.sql.Date(ecal.getTime().getTime())}, new ReelMapper());

		} catch (Exception e) {
			e.printStackTrace();
		}

		return reels;	
	}


	@Override
	public List<Reel> getReelsByCustomerReel(Date sdate, Date edate,
			String customer, String reel) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		Calendar scal=Calendar.getInstance();
		scal.setTime(sdate);
		scal.set(Calendar.HOUR_OF_DAY, 7);
		scal.set(Calendar.MINUTE, 0);
		scal.set(Calendar.SECOND, 0);
		scal.set(Calendar.MILLISECOND, 0);
		
		Calendar ecal=Calendar.getInstance();
		ecal.setTime(edate);
		ecal.set(Calendar.HOUR_OF_DAY, 6);
		ecal.set(Calendar.MINUTE, 59);
		ecal.set(Calendar.SECOND, 0);
		ecal.set(Calendar.MILLISECOND, 0);
		ecal.add(Calendar.DATE, 1);
		String sql="select * from [reelTesting] where [Customer]=? and [Reel]=? and [Date] BETWEEN  ? AND ?  order by [Date], [Reel], [ID]";
		List<Reel> reels=null;
		try {
			reels=jdbcTemplate.query(sql, new Object[]{customer,reel,new java.sql.Date(scal.getTime().getTime()),new java.sql.Date(ecal.getTime().getTime())}, new ReelMapper());

		} catch (Exception e) {
			e.printStackTrace();
		}

		return reels;	
	}
*/

	@Override
	public ReelPM5 getReelById(int id) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		
		String sql="select * from [reelTesting_pm5] where [ID]=?";
		ReelPM5 reel=null;
		try {
			reel=jdbcTemplate.queryForObject(sql, new Object[]{id}, new ReelMapperPM5());

		} catch (Exception e) {
			e.printStackTrace();
		}
		return reel;
	}


	/*@Override
	public void updateEntryById(List<Integer> ids, String entryFlag) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		
		String sql="update [reelTesting] set [enterAutoFlag]=? where [ID]=?";
		try {
			
			for (Integer integer : ids) {
				jdbcTemplate.update(sql, new Object[]{entryFlag,integer});
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}*/


	@Override
	public List<ReelPM5> getReelByReelNo(String reelNo) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		
		String sql="select * from [reelTesting_pm5] where [Reel]=?";
		List<ReelPM5> reels=null;
		try {
			reels=jdbcTemplate.query(sql, new Object[]{reelNo}, new ReelMapperPM5());

		} catch (Exception e) {
			e.printStackTrace();
		}
		return reels;
	}



	@Override
	public List<Map<String, Object>> findMatch(ReelPM5 reel) {
		List<Map<String, Object>> result=new ArrayList<>();
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		
		String gradeCode=reel.getGradeCode();
		if(gradeCode!=null && !gradeCode.trim().equals("")){
			String gc_2=gradeCode.substring(gradeCode.indexOf("-")+1);
			gc_2=gc_2.substring(0, gc_2.indexOf("-"));
			String sql1=null;
			if(gc_2.equals("98")){
				sql1="select [GradeCode] from [grade_pm5] where [GradeCode] like '%-98-%'";
			}else{
				sql1="select [GradeCode] from [grade_pm5] where [GradeCode] not like '%-98-%'";
			}
			List<String> grades=jdbcTemplate.query(sql1,new RowMapper<String>() {
				@Override
				public String mapRow(ResultSet rs, int arg1) throws SQLException {
					return rs.getString(1);
				}
			});
			
			for (Iterator<String> iterator = grades.iterator(); iterator.hasNext();) {
				String grade = (String) iterator.next();
			//	System.out.println(grade);
				String sql="select * from [gradeTarget_pm5] where [GradeCode]=?";
				List<GradeTarget> gradeTargets=jdbcTemplate.query(sql, new Object[]{grade},new GradeTargetMapper());
				if(gradeTargets.size()>0){
					
					Map<String, Object> map=new HashMap<String, Object>();
					
					map.put(ColumnsOfTable.COL_01, grade);
					
					
					GradeTarget GP01=GradeTargetUtil.getGradeTarget(gradeTargets, "GP01");
					if(GradeTargetUtil.checkRange(reel.getActualBasisWt(), GP01)!=CommonProperties.COLOR_GREEN
							&&
					  GradeTargetUtil.checkRange(reel.getActualBasisWt(), GP01)!=CommonProperties.COLOR_NONE){
						iterator.remove();
						continue;
					}
					map.put(ColumnsOfTable.COL_02, GP01.getTarget());
					
					GradeTarget GP02=GradeTargetUtil.getGradeTarget(gradeTargets, "GP02");
					if(GradeTargetUtil.checkRange(reel.getBrightness(), GP02)!=CommonProperties.COLOR_GREEN
							&&
						GradeTargetUtil.checkRange(reel.getBrightness(), GP02)!=CommonProperties.COLOR_NONE){
						iterator.remove();
						continue;
					}
					map.put(ColumnsOfTable.COL_03, GP02.getTarget());
					
					GradeTarget GP03=GradeTargetUtil.getGradeTarget(gradeTargets, "GP03");
					if(GradeTargetUtil.checkRange(reel.getBulk(), GP03)!=CommonProperties.COLOR_GREEN
							&&
						GradeTargetUtil.checkRange(reel.getBulk(), GP03)!=CommonProperties.COLOR_NONE){
						iterator.remove();
						continue;
					}
					map.put(ColumnsOfTable.COL_04, GP03.getTarget());
					
					GradeTarget GP04=GradeTargetUtil.getGradeTarget(gradeTargets, "GP04");
					if(GradeTargetUtil.checkRange(reel.getMdTensile(), GP04)!=CommonProperties.COLOR_GREEN
							&&
							GradeTargetUtil.checkRange(reel.getMdTensile(), GP04)!=CommonProperties.COLOR_NONE){
						iterator.remove();
						continue;
					}
					map.put(ColumnsOfTable.COL_05, GP04.getTarget());
					
					GradeTarget GP05=GradeTargetUtil.getGradeTarget(gradeTargets, "GP05");
					if(GradeTargetUtil.checkRange(reel.getMdWetTensile(), GP05)!=CommonProperties.COLOR_GREEN
							&&
						GradeTargetUtil.checkRange(reel.getMdWetTensile(), GP05)!=CommonProperties.COLOR_NONE){
						
						iterator.remove();
						continue;
					}
					map.put(ColumnsOfTable.COL_06, GP05.getTarget());
					
					GradeTarget GP06=GradeTargetUtil.getGradeTarget(gradeTargets, "GP06");
					if(GradeTargetUtil.checkRange(reel.getCdTensile(), GP06)!=CommonProperties.COLOR_GREEN
							&&
						GradeTargetUtil.checkRange(reel.getCdTensile(), GP06)!=CommonProperties.COLOR_NONE){
						iterator.remove();
						continue;
					}
					map.put(ColumnsOfTable.COL_07, GP06.getTarget());
					
					GradeTarget GP07=GradeTargetUtil.getGradeTarget(gradeTargets, "GP07");
					if(GradeTargetUtil.checkRange(reel.getCdWetTensile(), GP07)!=CommonProperties.COLOR_GREEN
							&&
							GradeTargetUtil.checkRange(reel.getCdWetTensile(), GP07)!=CommonProperties.COLOR_NONE){
						iterator.remove();
						continue;
					}
					map.put(ColumnsOfTable.COL_08, GP07.getTarget());
					
					GradeTarget GP08=GradeTargetUtil.getGradeTarget(gradeTargets, "GP08");
					if(GradeTargetUtil.checkRange(reel.getMdStretch(), GP08)!=CommonProperties.COLOR_GREEN
							&&
						GradeTargetUtil.checkRange(reel.getMdStretch(), GP08)!=CommonProperties.COLOR_NONE){
						iterator.remove();
						continue;
					}
					map.put(ColumnsOfTable.COL_09, GP08.getTarget());
					
					/*GradeTarget GP09=GradeTargetUtil.getGradeTarget(gradeTargets, "GP09");
					if(GradeTargetUtil.checkRange(reel.getMdcdTensileRatio(), GP09)!=CommonProperties.COLOR_GREEN
							&&
					   GradeTargetUtil.checkRange(reel.getMdcdTensileRatio(), GP09)!=CommonProperties.COLOR_NONE){
						
						iterator.remove();
						continue;
					}
					
					GradeTarget GP10=GradeTargetUtil.getGradeTarget(gradeTargets, "GP10");
					if(GradeTargetUtil.checkRange(reel.getCdTensileRatio(), GP10)!=CommonProperties.COLOR_GREEN
							&&
					   GradeTargetUtil.checkRange(reel.getCdTensileRatio(), GP10)!=CommonProperties.COLOR_NONE){
						
						iterator.remove();
						continue;
					}

					GradeTarget GP11=GradeTargetUtil.getGradeTarget(gradeTargets, "GP11");
					if(GradeTargetUtil.checkRange(reel.getDirtCount(), GP11)!=CommonProperties.COLOR_GREEN
							&&
					   GradeTargetUtil.checkRange(reel.getDirtCount(), GP11)!=CommonProperties.COLOR_NONE){
						
						iterator.remove();
						continue;
					}
					*/
					
					
					
					result.add(map);
				}else{
					iterator.remove();
				}
				
				
			}
			
			/*for (String string : result) {
				
				
				
				
			}*/
			
		}

		
		return result;
	}

	

	@Override
	public String getMaxReel() {
		String maxReel=null;
		
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		
		String sql="select TOP 1 [Reel] from [reelTesting_pm5]"
				+ " where [Date]=(SELECT  max(DATE)"
				+"	FROM [reelTesting_pm5]) order by ID desc";
		try {
			maxReel=jdbcTemplate.queryForObject(sql, String.class);
			//System.out.println("Higest Reel Id Is :::->"+maxReel);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return maxReel;
	}


	@Override
	public Map<String, Date> getPrevNextReelDate(String reel) {
		 Map<String, Date>  map=new HashMap<>();
		 
		 JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		 
		 String prevReel=(NumberUtils.toInt(reel,0)-1)+"";
		 String nextReel=(NumberUtils.toInt(reel,0)+1)+"";
		 
		// System.out.println("prevReel "+prevReel);
		// System.out.println("nextReel "+nextReel);
		 
		 String sql="select [Date] from [reelTesting_pm5] where [Reel]=?";
		 Timestamp pTimestamp=null;
		 Timestamp nTimestamp=null;
		try {
			pTimestamp=jdbcTemplate.queryForObject(sql, new Object[]{prevReel},Timestamp.class);
		} catch (Exception e) {
			logger.error("Previous reel not available in database:-"+e.getMessage());
		}
		
		try {
			nTimestamp=jdbcTemplate.queryForObject(sql, new Object[]{nextReel},Timestamp.class);
		} catch (Exception e) {
			logger.error("Next Reel not available in database:-"+e.getMessage());
		}
		if(pTimestamp!=null){
			map.put(CommonProperties.REEL_PREV, new Date(pTimestamp.getTime()));	
		}else{
			map.put(CommonProperties.REEL_PREV, null);
		}
		
		if(nTimestamp!=null){
			map.put(CommonProperties.REEL_NEXT, new Date(nTimestamp.getTime()));	
		}else{
			map.put(CommonProperties.REEL_NEXT, null);
		}
		
		
		return map;
	}


	/* (non-Javadoc)
	 * @see com.st.qualityreport.dao.ReelDao#getBirghtnessAvgOfDay()
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
		
		String sql="SELECT avg(Brightness) as [avg] "
				+ "FROM reelTesting_pm5 "
				+ " where [Date] between ? and  ? ";
		
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
	 * @see com.st.qualityreport.dao.ReelDao#getBirghtnessAvgOfLastDay()
	 */
	@Override
	public double getBirghtnessAvgOfLastDay() {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		
		//System.out.println(CommonUtil.getShiftDate());

		Calendar sCal=Calendar.getInstance();
		sCal.setTime(CommonUtil.getShiftDate());
		sCal.set(Calendar.HOUR_OF_DAY, 7);
		sCal.set(Calendar.MINUTE, 0);
		sCal.set(Calendar.SECOND, 0);
		sCal.set(Calendar.MILLISECOND, 0);
	//	sCal.add(Calendar.DATE, -1);
		
		Calendar eCal=Calendar.getInstance();
		eCal.setTime(new Date());
		
		
		// System.out.println(sCal.getTime());
		// System.out.println(eCal.getTime());
		
		
		String sql="SELECT avg(Brightness) as [avg] "
				+ "FROM reelTesting_pm5 "
				+ " where [Date] between ? and  ? ";
		
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
	 * @see com.st.qualityreport.dao.ReelDao#getBirghtnessAvgOfLastDay(java.lang.String)
	 */
	@Override
	public double getBirghtnessAvgOfLastDay(String grade) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		
		//System.out.println(CommonUtil.getShiftDate());

		Calendar sCal=Calendar.getInstance();
		sCal.setTime(CommonUtil.getShiftDate());
		sCal.set(Calendar.HOUR_OF_DAY, 7);
		sCal.set(Calendar.MINUTE, 0);
		sCal.set(Calendar.SECOND, 0);
		sCal.set(Calendar.MILLISECOND, 0);
	//	sCal.add(Calendar.DATE, -1);
		
		Calendar eCal=Calendar.getInstance();
		eCal.setTime(new Date());
		
		
		// System.out.println(sCal.getTime());
		// System.out.println(eCal.getTime());
		
		
		String sql="SELECT avg(Brightness) as [avg] "
				+ "FROM reelTesting_pm5 "
				+ " where ([Date] between ? and  ?) and [GradeCode]=? and [Brightness]>0";
		
		Double avg=0d;
		
		try {
			avg=jdbcTemplate.queryForObject(sql, new Object[]{
				new Timestamp(sCal.getTime().getTime()),
				new Timestamp(eCal.getTime().getTime()),
				grade
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
	 * @see com.st.qualitypm6.dao.ReelDao#getGrades(java.util.Date, java.util.Date, java.lang.String)
	 */
	@Override
	public List<String> getGrades(Date sdate, Date edate, String customer) {
		
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		
		Calendar scal=Calendar.getInstance();
		scal.setTime(sdate);
		scal.set(Calendar.HOUR_OF_DAY, 7);
		scal.set(Calendar.MINUTE, 0);
		scal.set(Calendar.SECOND, 0);
		scal.set(Calendar.MILLISECOND, 0);
		
		Calendar ecal=Calendar.getInstance();
		ecal.setTime(edate);
		ecal.set(Calendar.HOUR_OF_DAY, 6);
		ecal.set(Calendar.MINUTE, 59);
		ecal.set(Calendar.SECOND, 0);
		ecal.set(Calendar.MILLISECOND, 0);
		ecal.add(Calendar.DATE, 1);
		
		String sql="select distinct[GradeCode] from [reelTesting_pm5] "
				+ " where "
				+ " [Customer]=? "
				+ " and "
				+ " [Date] between ? and ? ";
		
		List<String> list=jdbcTemplate.queryForList(sql, new Object[]{
				customer,
				new Timestamp(scal.getTime().getTime()),
				new Timestamp(ecal.getTime().getTime()),
		}, String.class);
		
		return list;
	}

	
//	Code Starts From Here Done By Roshan Tailor Date:- 04/07/2015
	/* (non-Javadoc)
	 * @see com.st.qualitypm6.dao.ReelDao#getcurrentreel(java.lang.String)
	 */
	@Override
	public String getcurrentreel(String currentReelNumber ,String CurrentGradeCodeByAjax) {
		// TODO Auto-generated method stub
		
		String ReelNumber=null;
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		
//		String sql="select TOP 1 [Reel] from [reelTesting]"
//				+ " where [Date]=(SELECT  max(DATE)"
//				+"	FROM [reelTesting])  order by ID desc";
		
		String sql="select TOP 1 [Reel] from [reelTesting_pm5] where ((reelTesting_pm5.[GradeCode])=?)"
				+ " order by ID desc";
		try {
			ReelNumber=jdbcTemplate.queryForObject(sql,new Object[]{
					CurrentGradeCodeByAjax
			}, String.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ReelNumber;
	}
//	Code Ends Here Done By Roshan Tailor	
	
//	Code Starts From Here Done By Roshan Tailor Date :- 04/16/2015
	/* (non-Javadoc)
	 * @see com.st.qualitypm6.dao.ReelDao#getlastgradecode()
	 */
	@Override
	public String getlastgradecode() {
		// TODO Auto-generated method stub
		String LastUpdatedGradeCode=null;
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		String sql="select TOP 1 [GradeCode] from [reelTesting_pm5] order by ID desc";
		try{
			LastUpdatedGradeCode=jdbcTemplate.queryForObject(sql, String.class);
		}catch(Exception e){
			logger.error("Roshan Says That You Have A Problem In getlastgradecode Method In ReelDaoImp.java ",e.getMessage());
			e.printStackTrace();
		}
		return LastUpdatedGradeCode;
	}
//	Code Ends Here Done By Roshan Tailor


	/* (non-Javadoc)
	 * @see com.st.qualitypm6.dao.ReelDao#getReelData(java.util.Date, java.util.Date, java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public List<ReelPM5> getReelData(Date sdate, Date edate, String grade,
			String customer, String reel, String type) {
		
		NamedParameterJdbcTemplate jdbcTemplate=new NamedParameterJdbcTemplate(dataSource);
		MapSqlParameterSource parameterSource=new MapSqlParameterSource();
		
		Calendar scal=Calendar.getInstance();
		scal.setTime(sdate);
		scal.set(Calendar.HOUR_OF_DAY, 6);
		scal.set(Calendar.MINUTE, 0);
		scal.set(Calendar.SECOND, 0);
		scal.set(Calendar.MILLISECOND, 0);
		
		Calendar ecal=Calendar.getInstance();
		ecal.setTime(edate);
		ecal.set(Calendar.HOUR_OF_DAY, 5);
		ecal.set(Calendar.MINUTE, 59);
		ecal.set(Calendar.SECOND, 0);
		ecal.set(Calendar.MILLISECOND, 0);
		ecal.add(Calendar.DATE, 1);
		
		parameterSource.addValue("sdate", new Timestamp(scal.getTime().getTime()));
		parameterSource.addValue("edate", new Timestamp(ecal.getTime().getTime()));
		
		String sql="select * from [reelTesting_pm5] where ([Date] between :sdate and :edate) ";
		
		if(StringUtils.isNotEmpty(grade)){
			sql+=" and [GradeCode]=:gradeCode ";
			
			parameterSource.addValue("gradeCode", grade);
		}
		
		if(StringUtils.isNotEmpty(customer)){
			sql+=" and [Customer]=:customer ";
			parameterSource.addValue("customer", customer);
		}
		
		if(StringUtils.isNotEmpty(reel)){
			sql+=" and [Reel]=:reel ";
			parameterSource.addValue("reel", reel);
		}
		
		if(StringUtils.isNotEmpty(type)){
			sql+=" and [GradeCode] like :type ";
			parameterSource.addValue("type", "%-"+type+"-%");
		}
		
		sql+="   order by [Date], [Reel], [ID]";
		
		List<ReelPM5> reels=null;
		try {
			reels=jdbcTemplate.query(sql, parameterSource, new ReelMapperPM5());

		} catch (Exception e) {
			e.printStackTrace();
		}
		return reels;

	}


	/* (non-Javadoc)
	 * @see com.st.qualitypm5.dao.ReelDaoPM5#getReelsByCustomer(java.util.Date, java.util.Date, java.lang.String)
	 */
	@Override
	public List<Reel> getReelsByCustomer(Date date1, Date date2, String customer) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		Calendar scal=Calendar.getInstance();
		scal.setTime(date1);
		scal.set(Calendar.HOUR_OF_DAY, 6);
		scal.set(Calendar.MINUTE, 0);
		scal.set(Calendar.SECOND, 0);
		scal.set(Calendar.MILLISECOND, 0);
		
		Calendar ecal=Calendar.getInstance();
		ecal.setTime(date2);
		ecal.set(Calendar.HOUR_OF_DAY, 5);
		ecal.set(Calendar.MINUTE, 59);
		ecal.set(Calendar.SECOND, 59);
		ecal.set(Calendar.MILLISECOND, 0);
		ecal.add(Calendar.DATE, 1);
		String sql="select * from [reelTesting_pm5] where [Customer]=? and [Date] BETWEEN  ? AND ? order by  [ID],[Date]";
		List<Reel> reels=null;
		try {
			reels=jdbcTemplate.query(sql, new Object[]{customer,new java.sql.Date(scal.getTime().getTime()),new java.sql.Date(ecal.getTime().getTime())}, new ReelMapper());

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return reels;
	}


	/* (non-Javadoc)
	 * @see com.st.qualitypm5.dao.ReelDaoPM5#getReelsByGradeCustomer(java.util.Date, java.util.Date, java.lang.String, java.lang.String)
	 */
	@Override
	public List<Reel> getReelsByGradeCustomer(Date sdate, Date edate, String gradeCode, String customer) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		Calendar scal=Calendar.getInstance();
		scal.setTime(sdate);
		scal.set(Calendar.HOUR_OF_DAY, 6);
		scal.set(Calendar.MINUTE, 0);
		scal.set(Calendar.SECOND, 0);
		scal.set(Calendar.MILLISECOND, 0);
		
		Calendar ecal=Calendar.getInstance();
		ecal.setTime(edate);
		ecal.set(Calendar.HOUR_OF_DAY, 5);
		ecal.set(Calendar.MINUTE, 59);
		ecal.set(Calendar.SECOND, 59);
		ecal.set(Calendar.MILLISECOND, 0);
		ecal.add(Calendar.DATE, 1);
		String sql="select * from [reelTesting_pm5] where [GradeCode] LIKE ? and [Customer]=? and [Date] BETWEEN  ? AND ? order by  [ID],[Date]";
		List<Reel> reels=null;
		try {
			reels=jdbcTemplate.query(sql, new Object[]{gradeCode,customer,new java.sql.Date(scal.getTime().getTime()),new java.sql.Date(ecal.getTime().getTime())}, new ReelMapper());

		} catch (Exception e) {
			e.printStackTrace();
		}

		return reels;	
	}
}

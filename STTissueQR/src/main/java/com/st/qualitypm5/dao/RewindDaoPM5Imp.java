/**
 *Dec 25, 2017
 *RewindDaoPM5Imp.java
 * TODO
 *com.st.qualitypm5.dao
 *RewindDaoPM5Imp.java
 *Roshan Lal Tailor
 */
package com.st.qualitypm5.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.st.common.Columns;
import com.st.qualitypm5.mapper.Rewind1PM5Mapper;
import com.st.qualitypm5.model.RewindPM5;
import com.st.qualitypm6.mapper.RewindlMapper;
import com.st.qualitypm6.model.Rewind;

/**
 * @author roshan
 *
 */
@Repository
public class RewindDaoPM5Imp implements RewindDaoPM5{

	@Autowired
	private DataSource dataSource;
	
	/* (non-Javadoc)
	 * @see com.st.qualitypm5.dao.RewindDaoPM5#getRewinds(java.lang.String, java.util.Date)
	 */
	@Override
	public List<RewindPM5> getRewinds(String gradeCode, Date date) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		
		Calendar scal=Calendar.getInstance();
		scal.setTime(date);
		scal.set(Calendar.HOUR_OF_DAY,6);
		scal.set(Calendar.MINUTE, 0);
		scal.set(Calendar.SECOND, 0);
		scal.set(Calendar.MILLISECOND, 0);
		
		Calendar ecal=Calendar.getInstance();
		ecal.setTime(scal.getTime());
		ecal.add(Calendar.DATE, 1);
		
		String sql="select * from [rewindTesting_pm5] where"
				+ " [GradeCode]=?"
				+ " and "
				+ " [Date] between ? and ?  "
				+ " order by [Date],[Reel],[SetNo],[ID]";
		List<RewindPM5> rewinds=null;
		try{
			rewinds=jdbcTemplate.query(sql, 
					new Object[]{
					gradeCode
					,
					new Timestamp(scal.getTime().getTime()),
					new Timestamp(ecal.getTime().getTime())
					},
					new Rewind1PM5Mapper());
	
		}catch(Exception e){
			e.printStackTrace();	
		}
		
		return rewinds;
	}

	/* (non-Javadoc)
	 * @see com.st.qualitypm5.dao.RewindDaoPM5#getRewindById(int)
	 */
	@Override
	public RewindPM5 getRewindById(int id) {

		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		
		String sql="select * from [rewindTesting_pm5] where [ID]=?";
		RewindPM5 rewind=null;
		try{
			rewind=jdbcTemplate.queryForObject(sql, new Object[]{id}, new Rewind1PM5Mapper());
	
		}catch(Exception e){
			e.printStackTrace();	
		}

		return rewind;
	}

	/* (non-Javadoc)
	 * @see com.st.qualitypm5.dao.RewindDaoPM5#update(com.st.qualitypm5.model.RewindPM5)
	 */
	@Override
	public void update(final RewindPM5 rewind) {
		String sql="update [rewindTesting_pm5] SET "
				
					+ "[Date]=?,"
					+ "[GradeCode]=?,"
					+ "[Reel]=?,"
					+ "[SetNo]=?,"
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
					+ "[DirtCount]=?,"
					+ "[AbsorbencySeconds]=?,"
					+ "[Lvalue]=?,"
					+ "[Avalue]=?,"
					+ "[Bvalue]=?,"
					+ "[Customer]=?,"
					+ "[Remarks]=?"
					+ " "
					+ " where [ID]=?";
		
			JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
			jdbcTemplate.execute(sql, new PreparedStatementCallback<Boolean>() {

				@Override
				public Boolean doInPreparedStatement(
						PreparedStatement statement) throws SQLException,
						DataAccessException {

					statement.setTimestamp(Columns.COL_01, new Timestamp(rewind.getDate().getTime()));
					statement.setString(Columns.COL_02, rewind.getGradeCode());
					statement.setString(Columns.COL_03, rewind.getReel());
					statement.setString(Columns.COL_04, rewind.getSetNo());
					statement.setDouble(Columns.COL_05, rewind.getActualBasisWt());
					statement.setDouble(Columns.COL_06, rewind.getBulk());
					statement.setDouble(Columns.COL_07, rewind.getMdTensile());
					statement.setDouble(Columns.COL_08, rewind.getCdTensile());
					statement.setDouble(Columns.COL_09, rewind.getMdStretch());
					statement.setDouble(Columns.COL_10, rewind.getMdcdTensileRatio());
					statement.setDouble(Columns.COL_11, rewind.getMdWetTensile());
					statement.setDouble(Columns.COL_12, rewind.getCdWetTensile());
					statement.setDouble(Columns.COL_13, rewind.getCdTensileRatio());
					statement.setDouble(Columns.COL_14, rewind.getBrightness());
					statement.setDouble(Columns.COL_15, rewind.getDirtCount());
					statement.setDouble(Columns.COL_16, rewind.getAbsorbencySeconds());
					statement.setDouble(Columns.COL_17, rewind.getLvalue());
					statement.setDouble(Columns.COL_18, rewind.getAvalue());
					statement.setDouble(Columns.COL_19, rewind.getBvalue());
					statement.setString(Columns.COL_20, rewind.getCustomer());
					statement.setString(Columns.COL_21, rewind.getRemarks());
					
					statement.setInt(Columns.COL_22, rewind.getId());
					
					return statement.execute();
				}
			
			});
		
	}

	/* (non-Javadoc)
	 * @see com.st.qualitypm5.dao.RewindDaoPM5#isSetNumberExist(java.lang.String)
	 */
	@Override
	public boolean isSetNumberExist(String setNo) {
		boolean reelFlag=false;
		
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		String sql="select count(*) from [rewindTesting_pm5] where [SetNo]='"+setNo+"'";
		
		int count=jdbcTemplate.queryForObject(sql,Integer.class);
		if(count!=0){
			reelFlag=true;
		}
		
		return reelFlag;
	}

	/* (non-Javadoc)
	 * @see com.st.qualitypm5.dao.RewindDaoPM5#save(com.st.qualitypm5.model.RewindPM5)
	 */
	@Override
	public int save(final RewindPM5 rewind) {
		
		KeyHolder keyHolder=new GeneratedKeyHolder();
		
		final String sql="insert into [rewindTesting_pm5]"
				+ "("
				+ "[Date],"
				+ "[GradeCode],"
				+ "[Reel],"
				+ "[SetNo],"
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
				+ "[DirtCount],"
				+ "[AbsorbencySeconds],"
				+ "[Lvalue],"
				+ "[Avalue],"
				+ "[Bvalue],"
				+ "[Customer],"
				+ "[Remarks] ) "
				+ "  values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		jdbcTemplate.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection arg0)
					throws SQLException {
				PreparedStatement statement=arg0.prepareStatement(sql,new String[]{"ID"});
				statement.setTimestamp(Columns.COL_01, new Timestamp(rewind.getDate().getTime()));
				statement.setString(Columns.COL_02, rewind.getGradeCode());
				statement.setString(Columns.COL_03, rewind.getReel());
				statement.setString(Columns.COL_04, rewind.getSetNo().toUpperCase());
				statement.setDouble(Columns.COL_05, rewind.getActualBasisWt());
				statement.setDouble(Columns.COL_06, rewind.getBulk());
				statement.setDouble(Columns.COL_07, rewind.getMdTensile());
				statement.setDouble(Columns.COL_08, rewind.getCdTensile());
				statement.setDouble(Columns.COL_09, rewind.getMdStretch());
				statement.setDouble(Columns.COL_10, rewind.getMdcdTensileRatio());
				statement.setDouble(Columns.COL_11, rewind.getMdWetTensile());
				statement.setDouble(Columns.COL_12, rewind.getCdWetTensile());
				statement.setDouble(Columns.COL_13, rewind.getCdTensileRatio());
				statement.setDouble(Columns.COL_14, rewind.getBrightness());
				statement.setDouble(Columns.COL_15, rewind.getDirtCount());
				statement.setDouble(Columns.COL_16, rewind.getAbsorbencySeconds());
				statement.setDouble(Columns.COL_17, rewind.getLvalue());
				statement.setDouble(Columns.COL_18, rewind.getAvalue());
				statement.setDouble(Columns.COL_19, rewind.getBvalue());
				statement.setString(Columns.COL_20, rewind.getCustomer());
				statement.setString(Columns.COL_21, rewind.getRemarks());
				return statement;
			}
		},keyHolder);
		return keyHolder.getKey().intValue();
	}

	/* (non-Javadoc)
	 * @see com.st.qualitypm5.dao.RewindDaoPM5#delete(java.util.List)
	 */
	@Override
	public void delete(final List<String> idsList) {
		
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		String sql="delete from [rewindTesting_pm5] where [id]=?";
		
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

	/* (non-Javadoc)
	 * @see com.st.qualitypm5.dao.RewindDaoPM5#getRewindInfo(java.lang.String, java.lang.String)
	 */
	@Override
	public List<RewindPM5> getRewindInfo(String reel, String set) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		
		String sql="select * from [rewindTesting_pm5] where ";
		if(StringUtils.isNotEmpty(reel) && StringUtils.isEmpty(set)){
			sql+= " [Reel]='"+reel+"' ";
		}else if(StringUtils.isNotEmpty(set) && StringUtils.isEmpty(reel)){
			sql+= " [SetNo]= '"+set+"' ";
		}else{
			sql+= " [Reel]='"+reel+"' and [SetNo]='"+set+"' ";
		}
		sql+=" order by [Date],[Reel],[SetNo],[ID]";

		List<RewindPM5> rewinds=jdbcTemplate.query(sql, new Rewind1PM5Mapper());
		return rewinds;
	}

	/* (non-Javadoc)
	 * @see com.st.qualitypm5.dao.RewindDaoPM5#getRewindData(java.util.Date, java.util.Date, java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public List<RewindPM5> getRewindData(Date sdate, Date edate, String grade, String customer, String reel, String type) {
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
		
		String sql="select * from [rewindTesting_pm5] where ([Date] between :sdate and :edate) ";
		
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
		
		sql+="  order by [Date],[Reel],[SetNo],[ID]";
		List<RewindPM5> rewinds=null;
		try{
			rewinds=jdbcTemplate.query(sql,parameterSource, new Rewind1PM5Mapper());
	
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rewinds;
	}

}

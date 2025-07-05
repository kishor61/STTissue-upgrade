package com.st.qualitypm6.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
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
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.st.common.Columns;
import com.st.qualitypm6.mapper.RewindlMapper;
import com.st.qualitypm6.model.Rewind;

@Repository
public class RewindDaoImp implements RewindDao {
	@Autowired
	private DataSource dataSource;
	@Override
	public List<Rewind> getRewinds(String gradeCode, String reel, Date date) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		String sql = "select * from [rewindTesting] where [GradeCode]=? and [Date]=? and [Reel]=? order by [Date],[Reel],[SetNo],[ID]";

		List<Rewind> rewinds = jdbcTemplate.query(sql, new Object[] { gradeCode,
				new java.sql.Date(date.getTime()), reel }, new RewindlMapper());
		return rewinds;
	}
	

	
	@Override
	public boolean isSetNumberExist(String setNo) {
		boolean reelFlag=false;
		
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		String sql="select count(*) from [rewindTesting] where [SetNo]='"+setNo+"'";
		
		int count=jdbcTemplate.queryForObject(sql,Integer.class);
		if(count!=0){
			reelFlag=true;
		}
		
		return reelFlag;
	}
	
	@Override
	public void delete(final List<String> idsList) {
		
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		String sql="delete from [rewindTesting] where [id]=?";
		
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
	public int save(final Rewind rewind) throws Exception {
		
		KeyHolder keyHolder=new GeneratedKeyHolder();
		
		final String sql="insert into [rewindTesting]"
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
//				Code Starts From Here Done By Roshan Tailor Date ;- 03/07/2015
				+ "[Lvalue],"
				+ "[Avalue],"
				+ "[Bvalue],"
//				Code Ends Here Done By Roshan Tailor
				+ "[Customer],"
				+ "[Remarks] ) "
				//+ "[enterAutoFlag] ) "
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
//				Code Starts From Here Done By Roshan Tailor Date :- 03/07/2015  MM/DD/YYYY
				statement.setDouble(Columns.COL_17, rewind.getLvalue());
				statement.setDouble(Columns.COL_18, rewind.getAvalue());
				statement.setDouble(Columns.COL_19, rewind.getBvalue());
//				Code Ends Here Done By Roshan Tailor
				statement.setString(Columns.COL_20, rewind.getCustomer());
				statement.setString(Columns.COL_21, rewind.getRemarks());
				//statement.setString(Columns.COL_19, entryAutoFlag);
				return statement;
			}
		},keyHolder);
			/*	*/
				

		
		return keyHolder.getKey().intValue();
	}
	/*@Override
	public void update(final Rewind rewind, final String entryAutoFlag) throws Exception {
		String sql="update [rewindTesting] SET "
		
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
				//	System.out.println(rewind.getCustomer());
					statement.setString(Columns.COL_17, rewind.getCustomer());
					statement.setString(Columns.COL_18, rewind.getRemarks());
					statement.setString(Columns.COL_19, entryAutoFlag);
					statement.setInt(Columns.COL_20, rewind.getId());
					
					return statement.execute();
				}
			
			});
	}*/



	@Override
	public void update(final Rewind rewind) {
		String sql="update [rewindTesting] SET "
				
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
//					Code Starts From Here Done By Roshan Tailor To Update rewinfTesting Table.Date:- 03/07/2015  MM/DD/YYYY 
					+ "[Lvalue]=?,"
					+ "[Avalue]=?,"
					+ "[Bvalue]=?,"
//					Code Ends Here Done By Roshan Tailor
					+ "[Customer]=?,"
					+ "[Remarks]=?"
					+ " "
					+ " where [ID]=?";
			
//					String Lvalue=""+rewind.getLvalue();
//					String Avalue=""+rewind.getAvalue();
//					String Bvalue=""+rewind.getBvalue();
		
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
				//	System.out.println(rewind.getCustomer());
//					Code Starts From Here Done By Roshan Tailor To Add Columns In rewindTesting Table Date:- 03/07/2015 MM/DD/YYYY
					statement.setDouble(Columns.COL_17, rewind.getLvalue());
					statement.setDouble(Columns.COL_18, rewind.getAvalue());
					statement.setDouble(Columns.COL_19, rewind.getBvalue());
//					Code Ends Here Done By Roshan Tailor
					statement.setString(Columns.COL_20, rewind.getCustomer());
					statement.setString(Columns.COL_21, rewind.getRemarks());
					
					statement.setInt(Columns.COL_22, rewind.getId());
					
					return statement.execute();
				}
			
			});
		
	}

	
	
	@Override
	public List<Rewind> getRewinds(String gradeCode, Date jdate, String reelNo) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		
		String sql="select * from [rewindTesting] where [GradeCode]=? and [Date]=? and [Reel]=?  order by [Date],[Reel],[SetNo],[ID]";
		List<Rewind> rewinds=null;
		try{
			rewinds=jdbcTemplate.query(sql, new Object[]{gradeCode,new java.sql.Date(jdate.getTime()),reelNo}, new RewindlMapper());
	
		}catch(Exception e){
			e.printStackTrace();	
		}
		
		return rewinds;
	}

	@Override
	public Rewind getRewindById(int id) {

		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		
		String sql="select * from [rewindTesting] where [ID]=?";
		Rewind rewind=null;
		try{
			rewind=jdbcTemplate.queryForObject(sql, new Object[]{id}, new RewindlMapper());
	
		}catch(Exception e){
			e.printStackTrace();	
		}

		return rewind;
	}

	@Override
	public List<Rewind> getRewinds(String gradeCode, Date date) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		
		Calendar scal=Calendar.getInstance();
		scal.setTime(date);
		scal.set(Calendar.HOUR_OF_DAY, 6);
		scal.set(Calendar.MINUTE, 0);
		scal.set(Calendar.SECOND, 0);
		scal.set(Calendar.MILLISECOND, 0);
		
		Calendar ecal=Calendar.getInstance();
		ecal.setTime(scal.getTime());
		ecal.add(Calendar.DATE, 1);
		
		String sql="select * from [rewindTesting] where"
				+ " [GradeCode]=?"
				+ " and "
				+ " [Date] between ? and ?  "
				+ " order by [Date],[Reel],[SetNo],[ID]";
		List<Rewind> rewinds=null;
		try{
			rewinds=jdbcTemplate.query(sql, 
					new Object[]{
					gradeCode
					,
					new Timestamp(scal.getTime().getTime()),
					new Timestamp(ecal.getTime().getTime())
					},
					new RewindlMapper());
	
		}catch(Exception e){
			e.printStackTrace();	
		}
		
		return rewinds;
	}

	/* (non-Javadoc)
	 * @see com.st.qualityreport.dao.RewindDao#getRewindInfo(java.lang.String, java.lang.String)
	 */
	@Override
	public List<Rewind> getRewindInfo(String reel, String set) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		
		String sql="select * from [rewindTesting] where ";
		if(StringUtils.isNotEmpty(reel) && StringUtils.isEmpty(set)){
			sql+= " [Reel]='"+reel+"' ";
		}else if(StringUtils.isNotEmpty(set) && StringUtils.isEmpty(reel)){
			sql+= " [SetNo]= '"+set+"' ";
		}else{
			sql+= " [Reel]='"+reel+"' and [SetNo]='"+set+"' ";
		}
		
		sql+=" order by [Date],[Reel],[SetNo],[ID]";
		
		
		List<Rewind> rewinds=jdbcTemplate.query(sql, new RewindlMapper());
		
		
		return rewinds;
	}

	/* (non-Javadoc)
	 * @see com.st.qualitypm6.dao.RewindDao#getRewindByGradeCustomerGraph(java.util.Date, java.util.Date, java.lang.String, java.lang.String)
	 */
	@Override
	public List<Rewind> getRewindByGradeCustomerGraph(List<String> reels,
			String gradeCode, String customer) {
		List<Rewind> rewinds=new ArrayList<Rewind>();
		
		if(reels.size()>0){
			NamedParameterJdbcTemplate jdbcTemplate=new NamedParameterJdbcTemplate(dataSource);
			MapSqlParameterSource source=new MapSqlParameterSource();
			source.addValue("gradeCode", gradeCode);
			source.addValue("customer", customer);
			source.addValue("reels", reels);
			
			String sql="SELECT [Reel],"
					+ " avg([ActualBasisWt]) as [ActualBasisWtA], "
					+ " avg([Bulk]) as [BulkA], "
					+ " avg([MDTensile]) as [MDTensileA], "
					+ " avg([CDTensile]) as [CDTensileA], "
					+ " avg([MDStretch]) as [MDStretchA], "
					+ " avg([Brightness]) as [BrightnessA] "
					+ " FROM [rewindTesting] "
					+ " where [GradeCode]=:gradeCode and [Customer]=:customer and  [Reel] in(:reels) "
					+ " group by [Reel] "
					+ " order by [Reel] ";
			
			try {
				rewinds=jdbcTemplate.query(sql, source, new RowMapper<Rewind>(){

					@Override
					public Rewind mapRow(ResultSet rs, int arg1)
							throws SQLException {
						Rewind rewind=new Rewind();
						rewind.setReel(rs.getString("Reel"));
						rewind.setActualBasisWt(rs.getDouble("ActualBasisWtA"));
						rewind.setBulk(rs.getDouble("BulkA"));
						rewind.setCdTensile(rs.getDouble("CDTensileA"));
						rewind.setMdTensile(rs.getDouble("MDTensileA"));
						rewind.setMdStretch(rs.getDouble("MDStretchA"));
						rewind.setBrightness(rs.getDouble("BrightnessA"));
						return rewind;
					}
					
				});

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		

		return rewinds;
	}

	/* (non-Javadoc)
	 * @see com.st.qualitypm6.dao.RewindDao#getRewindData(java.util.Date, java.util.Date, java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public List<Rewind> getRewindData(Date sdate, Date edate, String grade,
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
		
		String sql="select * from [rewindTesting] where ([Date] between :sdate and :edate) ";
		
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
		List<Rewind> rewinds=null;
		try{
			rewinds=jdbcTemplate.query(sql,parameterSource, new RewindlMapper());
	
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rewinds;
	}

}

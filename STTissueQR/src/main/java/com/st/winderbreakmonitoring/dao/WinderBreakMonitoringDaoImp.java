/**
 *Oct 30, 2015
 *WinderBreakMonitoringDaoImp.java
 * TODO
 *com.st.winderbreakmonitoring.dao
 *WinderBreakMonitoringDaoImp.java
 *Sunil Singh Bora
 */
package com.st.winderbreakmonitoring.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.st.customercomplaint.mapper.CustomerComplaintMapper;
import com.st.customercomplaint.model.CustomerComplaint;
import com.st.winderbreakmonitoring.mapper.WinderBreakMonitoringMapper;
import com.st.winderbreakmonitoring.mapper.WinderBreakMonitoringReasonBreakMapper;
import com.st.winderbreakmonitoring.mapper.WinderBreakMonitoringSecondaryReasonBreakMapper;
import com.st.winderbreakmonitoring.model.WinderBreakMonitoring;

/**
 * @author roshan
 *
 */
@Repository
public class WinderBreakMonitoringDaoImp implements WinderBreakMonitoringDao{

	@Autowired
	private DataSource dataSource;
	
	/* (non-Javadoc)
	 * @see com.st.winderbreakmonitoring.dao.WinderBreakMonitoringDao#getWinderBreakData(java.util.Date, java.util.Date)
	 */
	@Override
	public List<WinderBreakMonitoring> getWinderBreakData(Date sdate, Date edate) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
    
	Calendar scal=Calendar.getInstance();
	scal.setTime(sdate);
	
	Calendar ecal=Calendar.getInstance();
	ecal.setTime(edate);
	ecal.add(Calendar.DATE, 1);
	
	
	String sql="select * from [winderbreakmonitoring] where "
			+ "([dates] between ? and ?) order by [dates]";
	/*List<WinderBreakMonitoring> winderbreakmonitoringData=jdbcTemplate.query(sql, new Object[]{
			new Timestamp(scal.getTime().getTime()),
			new Timestamp(ecal.getTime().getTime())
	},new WinderBreakMonitoringMapper());*/
	List<WinderBreakMonitoring> winderbreakmonitoringData=jdbcTemplate.query(sql, new Object[]{
			sdate,edate
	},new WinderBreakMonitoringMapper());
	return winderbreakmonitoringData;
}

	/* (non-Javadoc)
	 * @see com.st.winderbreakmonitoring.dao.WinderBreakMonitoringDao#save(com.st.winderbreakmonitoring.model.WinderBreakMonitoring)
	 */
	@Override
	public int save(final WinderBreakMonitoring wm) {
		// TODO Auto-generated method stub
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		KeyHolder keyHolder=new GeneratedKeyHolder();
		
		final String sql="insert into [winderbreakmonitoring]"
				+ "("
				+"[Dates],"
				+"[Shift],"
				+"[Crew],"
				+"[Reel],"
				+"[SetNo],"
				+"[BreakAt],"
				+"[Losstime],"
				+"[Reasonforbreak],"
				+"[LeftoutinSpool],"
				+"[Stoptime],"
				+"[Starttime],"
				+"[Downtime],"
				+"[gradeCode]"
				+ ")"
				+ " values("
				+ "?,"
				+ "?,"
				+ "?,?,?,?,?,?,?,?,?,?,?"	
				+ ")";
		
		jdbcTemplate.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection arg0)
					throws SQLException {
				PreparedStatement statement=arg0.prepareStatement(sql,new String[]{"ID"});
				statement.setTimestamp(1, new Timestamp(wm.getDate().getTime()));
				statement.setString(2, wm.getShift());
				statement.setString(3, wm.getCrew());
				statement.setString(4, wm.getReel());
				statement.setString(5, wm.getSetNo());
				statement.setString(6, wm.getBreakAt());
				statement.setString(7, wm.getLosstime());
				statement.setString(8, wm.getReasonforbreak());
				statement.setString(9, wm.getLeftoutinSpool());
				
				statement.setTimestamp(10, new Timestamp(wm.getStoptime().getTime()));
				//statement.setDate(10, (java.sql.Date) wm.getStoptime());
				//statement.setDate(11, (java.sql.Date) wm.getStarttime());
				statement.setTimestamp(11, new Timestamp(wm.getStarttime().getTime()));
				statement.setString(12, wm.getDowntime());
				statement.setString(13, wm.getGradeCode());
				
				return statement;
			}
		},keyHolder);
		
		return keyHolder.getKey().intValue();
	}

	/* (non-Javadoc)
	 * @see com.st.winderbreakmonitoring.dao.WinderBreakMonitoringDao#update(com.st.winderbreakmonitoring.model.WinderBreakMonitoring)
	 */
	@Override
	public void update(final WinderBreakMonitoring wm) {
		// TODO Auto-generated method stub


		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		final String sql="update [winderbreakmonitoring] set "
				+"[Dates]=?,"
				+"[Shift]=?,"
				+"[Crew]=?,"
				+"[Reel]=?,"
				+"[SetNo]=?,"
				+"[BreakAt]=?,"
				+"[Losstime]=?,"
				+"[Reasonforbreak]=?,"
				+"[LeftoutinSpool]=?,"
				+"[Stoptime]=?,"
				+"[Starttime]=?,"
				+"[Downtime]=?,"
				+"[gradeCode]=?"
				+ " where [ID]=?";
		
		jdbcTemplate.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection arg0)
					throws SQLException {
				PreparedStatement statement=arg0.prepareStatement(sql);
				statement.setTimestamp(1, new Timestamp(wm.getDate().getTime()));
				statement.setString(2,wm.getShift());
				statement.setString(3,wm.getCrew());
				statement.setString(4,wm.getReel());
				statement.setString(5,wm.getSetNo());
				statement.setString(6, wm.getBreakAt());
				statement.setString(7, wm.getLosstime());
				statement.setString(8, wm.getReasonforbreak());
				statement.setString(9, wm.getLeftoutinSpool());
				
				statement.setTimestamp(10, new Timestamp(wm.getStoptime().getTime()));
				statement.setTimestamp(11, new Timestamp(wm.getStarttime().getTime()));
				
				//statement.setDate(10, (java.sql.Date) wm.getStoptime());
				//statement.setDate(11, (java.sql.Date) wm.getStarttime());
				
				/*statement.setString(10, wm.getStoptime());
				statement.setString(11, wm.getStarttime());*/
				statement.setString(12, wm.getDowntime());
				statement.setString(13, wm.getGradeCode());
				statement.setInt(14, wm.getId());
				return statement;
			}
		});
	
	}

	/* (non-Javadoc)
	 * @see com.st.winderbreakmonitoring.dao.WinderBreakMonitoringDao#getWinderBreakMonitoringReport(java.util.Date, java.util.Date)
	 */
	@Override
	public List<WinderBreakMonitoring> getWinderBreakMonitoringReport(
			Date sdate, Date edate) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		String sql="Select * From [winderbreakmonitoring] where [Dates] between ? And ? ";
		List<WinderBreakMonitoring> winderdata=jdbcTemplate.query(sql,new Object[]{sdate,edate}, new WinderBreakMonitoringMapper());
		return winderdata;
	}

	/* (non-Javadoc)
	 * @see com.st.winderbreakmonitoring.dao.WinderBreakMonitoringDao#delete(int)
	 */
	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		String sql="delete from [winderbreakmonitoring] where [ID]=?";
		jdbcTemplate.update(sql, new Object[]{id});
	
	}

	/* (non-Javadoc)
	 * @see com.st.winderbreakmonitoring.dao.WinderBreakMonitoringDao#getWinderBreakReason()
	 */
	@Override
	public List<WinderBreakMonitoring> getWinderBreakReason() {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
	String sql="select * from [winderbreakmonitoringbreakreason] order by [Reasonofbreak]";
	List<WinderBreakMonitoring> winderbreakmonitoringBreakReasonData=jdbcTemplate.query(sql,new WinderBreakMonitoringReasonBreakMapper());
	return winderbreakmonitoringBreakReasonData;
}

	/* (non-Javadoc)
	 * @see com.st.winderbreakmonitoring.dao.WinderBreakMonitoringDao#savebreakreason(com.st.winderbreakmonitoring.model.WinderBreakMonitoring)
	 */
	@Override
	public int savebreakreason(final WinderBreakMonitoring wm) {
		// TODO Auto-generated method stub
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		KeyHolder keyHolder=new GeneratedKeyHolder();
		
		final String sql="insert into [winderbreakmonitoringbreakreason]"
				+ "("
				+"[Reasonofbreak]"
				+ ")"
				+ " values("
				+ "?"
				+ ")";
		
		jdbcTemplate.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection arg0)
					throws SQLException {
				PreparedStatement statement=arg0.prepareStatement(sql,new String[]{"ID"});
				statement.setString(1, wm.getReasonforbreak());
				return statement;
			}
		},keyHolder);
		
		return keyHolder.getKey().intValue();
	}

	/* (non-Javadoc)
	 * @see com.st.winderbreakmonitoring.dao.WinderBreakMonitoringDao#getEditWinderBreakReason(int)
	 */
	@Override
	public List<WinderBreakMonitoring> getEditWinderBreakReason(int id) {
		// TODO Auto-generated method stub
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		String sql="select * from [winderbreakmonitoringbreakreason] where ([id])=?";
		List<WinderBreakMonitoring> cc= jdbcTemplate.query(sql,new Object[]{id}, new WinderBreakMonitoringReasonBreakMapper());
		return cc;
	}

	/* (non-Javadoc)
	 * @see com.st.winderbreakmonitoring.dao.WinderBreakMonitoringDao#updatebreakreason(com.st.winderbreakmonitoring.model.WinderBreakMonitoring)
	 */
	@Override
	public void updatebreakreason(final WinderBreakMonitoring wm) {
		// TODO Auto-generated method stub
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		final String sql="update [winderbreakmonitoringbreakreason] set "
				+"[Reasonofbreak]=?"
				+ " where [ID]=?";
		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection arg0)
					throws SQLException {
				PreparedStatement statement=arg0.prepareStatement(sql);
				statement.setString(1,wm.getReasonforbreak());	
				statement.setInt(2, wm.getId());
				return statement;
			}
		});
	}

	/* (non-Javadoc)
	 * @see com.st.winderbreakmonitoring.dao.WinderBreakMonitoringDao#deleteBreakReason(int)
	 */
	@Override
	public void deleteBreakReason(int id) {
		// TODO Auto-generated method stub
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		String sql="delete from [winderbreakmonitoringbreakreason] where [ID]=?";
		jdbcTemplate.update(sql, new Object[]{id});
	}

	/* (non-Javadoc)
	 * @see com.st.winderbreakmonitoring.dao.WinderBreakMonitoringDao#getWinderBreakDataOfID(int)
	 */
	@Override
	public List<WinderBreakMonitoring> getWinderBreakDataOfID(int id) {
		// TODO Auto-generated method stub
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		String sql="select * from [winderbreakmonitoring] where ([id])=?";
		List<WinderBreakMonitoring> cc= jdbcTemplate.query(sql,new Object[]{id}, new WinderBreakMonitoringMapper());
		return cc;
	}

	/* (non-Javadoc)
	 * @see com.st.winderbreakmonitoring.dao.WinderBreakMonitoringDao#savebreakreason1(com.st.winderbreakmonitoring.model.WinderBreakMonitoring)
	 */
	@Override
	public int savebreakreason1(final WinderBreakMonitoring wm) {
		// TODO Auto-generated method stub
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		KeyHolder keyHolder=new GeneratedKeyHolder();
		
		final String sql="insert into [winderbreakmonitoringsecondaycode]"
				+ "("
				+"[PrimaryCode],"
				+"[SecondaryCode]"
				+ ")"
				+ " values("
				+ "?,?"
				+ ")";
		
		jdbcTemplate.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection arg0)
					throws SQLException {
				PreparedStatement statement=arg0.prepareStatement(sql,new String[]{"ID"});
				statement.setString(1, wm.getPrimarycode());
				statement.setString(2, wm.getSecondarycode());
				
				return statement;
			}
		},keyHolder);
		
		return keyHolder.getKey().intValue();
	}

	/* (non-Javadoc)
	 * @see com.st.winderbreakmonitoring.dao.WinderBreakMonitoringDao#updatebreakreason1(com.st.winderbreakmonitoring.model.WinderBreakMonitoring)
	 */
	@Override
	public void updatebreakreason1(final WinderBreakMonitoring wm) {
		// TODO Auto-generated method stub
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		final String sql="update [winderbreakmonitoringsecondaycode] set "
				+"[PrimaryCode]=?,"
				+"[SecondaryCode]=?"
				+ " where [ID]=?";
		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection arg0)
					throws SQLException {
				PreparedStatement statement=arg0.prepareStatement(sql);
				statement.setString(1,wm.getPrimarycode());
				statement.setString(2,wm.getSecondarycode());
				statement.setInt(3, wm.getId());
				return statement;
			}
		});
	}

	/* (non-Javadoc)
	 * @see com.st.winderbreakmonitoring.dao.WinderBreakMonitoringDao#getWinderSecondaryBreakReason()
	 */
	@Override
	public List<WinderBreakMonitoring> getWinderSecondaryBreakReason() {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
	String sql="select * from [winderbreakmonitoringsecondaycode] order by [PrimaryCode]";
	List<WinderBreakMonitoring> winderbreakmonitoringBreakReasonData=jdbcTemplate.query(sql,new WinderBreakMonitoringSecondaryReasonBreakMapper());
	return winderbreakmonitoringBreakReasonData;
}

	/* (non-Javadoc)
	 * @see com.st.winderbreakmonitoring.dao.WinderBreakMonitoringDao#getSecondaryReason(java.lang.String)
	 */
	@Override
	public List<WinderBreakMonitoring> getSecondaryReason(String reasonforbreak) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		String sql="Select * From [winderbreakmonitoringsecondaycode] where [PrimaryCode]=? ";
		List<WinderBreakMonitoring> winderdata=jdbcTemplate.query(sql,new Object[]{reasonforbreak}, new WinderBreakMonitoringSecondaryReasonBreakMapper());
		return winderdata;
	}

	/* (non-Javadoc)
	 * @see com.st.winderbreakmonitoring.dao.WinderBreakMonitoringDao#getEditWinderBreakSecondaryReason(int)
	 */
	@Override
	public List<WinderBreakMonitoring> getEditWinderBreakSecondaryReason(int id) {
		// TODO Auto-generated method stub
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		String sql="select * from [winderbreakmonitoringsecondaycode] where ([id])=?";
		List<WinderBreakMonitoring> cc= jdbcTemplate.query(sql,new Object[]{id}, new WinderBreakMonitoringSecondaryReasonBreakMapper());
		return cc;
	}

	/* (non-Javadoc)
	 * @see com.st.winderbreakmonitoring.dao.WinderBreakMonitoringDao#deleteBreakReason1(int)
	 */
	@Override
	public void deleteBreakReason1(int id) {
		// TODO Auto-generated method stub
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		String sql="delete from [winderbreakmonitoringsecondaycode] where [ID]=?";
		jdbcTemplate.update(sql, new Object[]{id});
	}
}

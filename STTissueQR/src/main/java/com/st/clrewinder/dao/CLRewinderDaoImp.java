/**
 *May 1, 2017
 *CLRewinderDaoImp.java
 * TODO
 *com.st.clrewinder.dao
 *CLRewinderDaoImp.java
 *Roshan Lal Tailor
 */
package com.st.clrewinder.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
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

import com.st.clrewinder.mapper.CLRewinderMapper;
import com.st.clrewinder.mapper.CLRewinderMapperForTotalDownTime;
import com.st.clrewinder.mapper.CLRewinderPrimaryCodeMapper;
import com.st.clrewinder.mapper.CLRewinderSecondaryReasonBreakMapper;
import com.st.clrewinder.mapper.CLRewinderSecondaryReasonBreakMapperGroupBy;
import com.st.clrewinder.mapper.CLWinderReasonBreakMapper;
import com.st.clrewinder.mapper.CLWinderReasonBreakMapperGroupBy;
import com.st.clrewinder.model.CLRewinder;


/**
 * @author roshan
 *
 */
@Repository
public class CLRewinderDaoImp implements CLRewinderDao{

	@Autowired
	private DataSource dataSource;
	/* (non-Javadoc)
	 * @see com.st.clrewinder.dao.CLRewinderDao#getWinderBreakData(java.util.Date, java.util.Date)
	 */
	@Override
	public List<CLRewinder> getWinderBreakData(Date sdate, Date edate) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
    
	Calendar scal=Calendar.getInstance();
	scal.setTime(sdate);
	
	Calendar ecal=Calendar.getInstance();
	ecal.setTime(edate);
	ecal.add(Calendar.DATE, 1);
	
	
	String sql="select * from [tbl_clrewindermonitoring] where "
			+ "([dates] between ? and ?) order by [dates]";
	/*List<WinderBreakMonitoring> winderbreakmonitoringData=jdbcTemplate.query(sql, new Object[]{
			new Timestamp(scal.getTime().getTime()),
			new Timestamp(ecal.getTime().getTime())
	},new WinderBreakMonitoringMapper());*/
	List<CLRewinder> winderbreakmonitoringData=jdbcTemplate.query(sql, new Object[]{
			sdate,edate
	},new CLRewinderMapper());
	return winderbreakmonitoringData;
}

	/* (non-Javadoc)
	 * @see com.st.clrewinder.dao.CLRewinderDao#save(com.st.clrewinder.model.CLRewinder)
	 */
	@Override
	public int save(final CLRewinder wm) {
		// TODO Auto-generated method stub
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		KeyHolder keyHolder=new GeneratedKeyHolder();
		
		final String sql="insert into [tbl_clrewindermonitoring]"
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
	 * @see com.st.clrewinder.dao.CLRewinderDao#update(com.st.clrewinder.model.CLRewinder)
	 */
	@Override
	public void update(final CLRewinder wm) {
		// TODO Auto-generated method stub


		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		final String sql="update [tbl_clrewindermonitoring] set "
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
	 * @see com.st.clrewinder.dao.CLRewinderDao#getWinderBreakMonitoringReport(java.util.Date, java.util.Date)
	 */
	@Override
	public List<CLRewinder> getWinderBreakMonitoringReport(Date sdate,
			Date edate) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		String sql="Select * From [tbl_clrewindermonitoring] where [Dates] between ? And ? ";
		List<CLRewinder> winderdata=jdbcTemplate.query(sql,new Object[]{sdate,edate}, new CLRewinderMapper());
		return winderdata;
	}

	/* (non-Javadoc)
	 * @see com.st.clrewinder.dao.CLRewinderDao#delete(int)
	 */
	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		String sql="delete from [tbl_clrewindermonitoring] where [ID]=?";
		jdbcTemplate.update(sql, new Object[]{id});
	
	}

	/* (non-Javadoc)
	 * @see com.st.clrewinder.dao.CLRewinderDao#getWinderBreakReason()
	 */
	@Override
	public List<CLRewinder> getWinderBreakReason() {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
	/*String sql="select * from [tbl_clrewindermonitoringbreakreason] order by [Reasonofbreak]";*/
	String sql="select * from [tbl_clrewindermonitoringsecondaycode] order by [SecondaryCode]";
	//List<CLRewinder> winderbreakmonitoringBreakReasonData=jdbcTemplate.query(sql,new CLWinderReasonBreakMapper());
	List<CLRewinder> winderbreakmonitoringBreakReasonData=jdbcTemplate.query(sql,new CLRewinderSecondaryReasonBreakMapper());
	return winderbreakmonitoringBreakReasonData;
	
/*
	JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
	String sql="  Select [id],[Reasonofbreak] From [tbl_clrewindermonitoringbreakreason] group by [Reasonofbreak],[id]";
	List<CLRewinder> winderdata=jdbcTemplate.query(sql,new Object[]{}, new CLWinderReasonBreakMapper());
	return winderdata;
*/
}

	/* (non-Javadoc)
	 * @see com.st.clrewinder.dao.CLRewinderDao#savebreakreason(com.st.clrewinder.model.CLRewinder)
	 */
	@Override
	public int savebreakreason(final CLRewinder wm) {
		// TODO Auto-generated method stub
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		KeyHolder keyHolder=new GeneratedKeyHolder();
		
		final String sql="insert into [tbl_clrewindermonitoringbreakreason]"
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
	 * @see com.st.clrewinder.dao.CLRewinderDao#getEditWinderBreakReason(int)
	 */
	@Override
	public List<CLRewinder> getEditWinderBreakReason(int id) {
		// TODO Auto-generated method stub
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		String sql="select * from [tbl_clrewindermonitoringbreakreason] where ([id])=?";
		List<CLRewinder> cc= jdbcTemplate.query(sql,new Object[]{id}, new CLWinderReasonBreakMapper());
		return cc;
	}

	/* (non-Javadoc)
	 * @see com.st.clrewinder.dao.CLRewinderDao#updatebreakreason(com.st.clrewinder.model.CLRewinder)
	 */
	@Override
	public void updatebreakreason(final CLRewinder wm) {
		// TODO Auto-generated method stub
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		final String sql="update [tbl_clrewindermonitoringbreakreason] set "
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
	 * @see com.st.clrewinder.dao.CLRewinderDao#deleteBreakReason(int)
	 */
	@Override
	public void deleteBreakReason(int id) {
		// TODO Auto-generated method stub
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		String sql="delete from [tbl_clrewindermonitoringbreakreason] where [ID]=?";
		jdbcTemplate.update(sql, new Object[]{id});
	}

	/* (non-Javadoc)
	 * @see com.st.clrewinder.dao.CLRewinderDao#getWinderBreakDataOfID(int)
	 */
	@Override
	public List<CLRewinder> getWinderBreakDataOfID(int id) {
		// TODO Auto-generated method stub
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		String sql="select * from [tbl_clrewindermonitoring] where ([id])=?";
		List<CLRewinder> cc= jdbcTemplate.query(sql,new Object[]{id}, new CLRewinderMapper());
		return cc;
	}

	/* (non-Javadoc)
	 * @see com.st.clrewinder.dao.CLRewinderDao#savebreakreason1(com.st.clrewinder.model.CLRewinder)
	 */
	@Override
	public int savebreakreason1(final CLRewinder wm) {
		// TODO Auto-generated method stub
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		KeyHolder keyHolder=new GeneratedKeyHolder();
		
		final String sql="insert into [tbl_clrewindermonitoringsecondaycode]"
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
	 * @see com.st.clrewinder.dao.CLRewinderDao#updatebreakreason1(com.st.clrewinder.model.CLRewinder)
	 */
	@Override
	public void updatebreakreason1(final CLRewinder wm) {
		// TODO Auto-generated method stub
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		final String sql="update [tbl_clrewindermonitoringsecondaycode] set "
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
	 * @see com.st.clrewinder.dao.CLRewinderDao#getWinderSecondaryBreakReason()
	 */
	@Override
	public List<CLRewinder> getWinderSecondaryBreakReason() {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
	String sql="select * from [tbl_clrewindermonitoringsecondaycode] order by [PrimaryCode]";
	List<CLRewinder> winderbreakmonitoringBreakReasonData=jdbcTemplate.query(sql,new CLRewinderSecondaryReasonBreakMapper());
	return winderbreakmonitoringBreakReasonData;
}

	/* (non-Javadoc)
	 * @see com.st.clrewinder.dao.CLRewinderDao#getSecondaryReason(java.lang.String)
	 */
	@Override
	public List<CLRewinder> getSecondaryReason(String reasonforbreak) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
	/*	String sql="Select * From [tbl_clrewindermonitoringsecondaycode] where [PrimaryCode]=? ";*/
		String sql="Select * From [tbl_clrewindermonitoringsecondaycode] where [SecondaryCode]=? ";
		List<CLRewinder> winderdata=jdbcTemplate.query(sql,new Object[]{reasonforbreak}, new CLRewinderSecondaryReasonBreakMapper());
		return winderdata;
	}

	/* (non-Javadoc)
	 * @see com.st.clrewinder.dao.CLRewinderDao#getEditWinderBreakSecondaryReason(int)
	 */
	@Override
	public List<CLRewinder> getEditWinderBreakSecondaryReason(int id) {
		// TODO Auto-generated method stub
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		String sql="select * from [tbl_clrewindermonitoringsecondaycode] where ([id])=?";
		List<CLRewinder> cc= jdbcTemplate.query(sql,new Object[]{id}, new CLRewinderSecondaryReasonBreakMapper());
		return cc;
	}

	/* (non-Javadoc)
	 * @see com.st.clrewinder.dao.CLRewinderDao#deleteBreakReason1(int)
	 */
	@Override
	public void deleteBreakReason1(int id) {
		// TODO Auto-generated method stub
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		String sql="delete from [tbl_clrewindermonitoringsecondaycode] where [ID]=?";
		jdbcTemplate.update(sql, new Object[]{id});
	
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see com.st.clrewinder.dao.CLRewinderDao#deleteSecondaryBreakReason(int)
	 */
	@Override
	public void deleteSecondaryBreakReason(int id) {
		// TODO Auto-generated method stub
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		String sql="delete from [tbl_clrewindermonitoringsecondaycode] where [ID]=?";
		jdbcTemplate.update(sql, new Object[]{id});
	}

	/* (non-Javadoc)
	 * @see com.st.clrewinder.dao.CLRewinderDao#getWinderBreakReasonShow()
	 */
	@Override
	public List<CLRewinder> getWinderBreakReasonShow() {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
	String sql="select * from [tbl_clrewindermonitoringbreakreason] order by [Reasonofbreak]";
	//String sql="select * from [tbl_clrewindermonitoringsecondaycode] order by [SecondaryCode]";
	//List<CLRewinder> winderbreakmonitoringBreakReasonData=jdbcTemplate.query(sql,new CLWinderReasonBreakMapper());
	List<CLRewinder> winderbreakmonitoringBreakReasonData=jdbcTemplate.query(sql,new CLWinderReasonBreakMapper());
	return winderbreakmonitoringBreakReasonData;
}

	/* (non-Javadoc)
	 * @see com.st.clrewinder.dao.CLRewinderDao#getSecondaryReason()
	 */
	@Override
	public List<CLRewinder> getSecondaryReason() {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		String sql="  Select [PrimaryCode] From [tbl_clrewindermonitoringsecondaycode] group by [PrimaryCode]";
		List<CLRewinder> winderdata=jdbcTemplate.query(sql,new Object[]{}, new CLRewinderPrimaryCodeMapper());
		return winderdata;
	}

	/* (non-Javadoc)
	 * @see com.st.clrewinder.dao.CLRewinderDao#getPrimaryReason()
	 */
	@Override
	public List<CLRewinder> getPrimaryReason() {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		String sql="  Select [id],[Reasonofbreak] From [tbl_clrewindermonitoringbreakreason] group by [Reasonofbreak],[id]";
		List<CLRewinder> winderdata=jdbcTemplate.query(sql,new Object[]{}, new CLWinderReasonBreakMapper());
		return winderdata;
	}

	/* (non-Javadoc)
	 * @see com.st.clrewinder.dao.CLRewinderDao#getWinderSecondaryBreakReasonGroupBy()
	 */
	@Override
	public List<CLRewinder> getWinderSecondaryBreakReasonGroupBy() {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
	String sql="select [PrimaryCode] from [tbl_clrewindermonitoringsecondaycode] Group by [PrimaryCode]";
	List<CLRewinder> winderbreakmonitoringBreakReasonData=jdbcTemplate.query(sql,new CLRewinderSecondaryReasonBreakMapperGroupBy());
	return winderbreakmonitoringBreakReasonData;
}

	/* (non-Javadoc)
	 * @see com.st.clrewinder.dao.CLRewinderDao#getWinderBreakReasonShowGroupBy()
	 */
	@Override
	public List<CLRewinder> getWinderBreakReasonShowGroupBy() {
	JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
	String sql="select [SecondaryCode] from [tbl_clrewindermonitoringsecondaycode] Group by [SecondaryCode]";
	List<CLRewinder> winderbreakmonitoringBreakReasonData=jdbcTemplate.query(sql,new CLWinderReasonBreakMapperGroupBy());
	return winderbreakmonitoringBreakReasonData;
}

	/* (non-Javadoc)
	 * @see com.st.clrewinder.dao.CLRewinderDao#getEfficiencySummaryReportData(java.util.Date, java.util.Date, java.lang.String, java.lang.String)
	 */
	@Override
	public List<CLRewinder> getEfficiencySummaryReportData(Date sdate, Date edate, String pcode, String scode,String primaryCode) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
    
	Calendar scal=Calendar.getInstance();
	scal.setTime(sdate);
	
	Calendar ecal=Calendar.getInstance();
	ecal.setTime(edate);
	ecal.add(Calendar.DATE, 1);
	
	
	String sql=null;
	List<CLRewinder> winderbreakmonitoringData=null;
	if(pcode.equalsIgnoreCase("ALL") && scode.equalsIgnoreCase("ALL")){
		sql=" select Reasonforbreak,Stoptime,Starttime,LeftoutinSpool from [tbl_clrewindermonitoring] where ([dates] between ? and ?)  "
				+ "and Losstime=? group by Reasonforbreak,Stoptime,Starttime,LeftoutinSpool ";
		winderbreakmonitoringData=jdbcTemplate.query(sql, new Object[]{ sdate,edate,primaryCode},new CLRewinderMapperForTotalDownTime());
	}else{
		sql=" select Reasonforbreak,Stoptime,Starttime,LeftoutinSpool from [tbl_clrewindermonitoring] where ([dates] between ? and ?)  "
				+ "and Losstime=? and  Reasonforbreak=? group by Reasonforbreak,Stoptime,Starttime,LeftoutinSpool ";
		winderbreakmonitoringData=jdbcTemplate.query(sql, new Object[]{ sdate,edate,pcode,scode},new CLRewinderMapperForTotalDownTime());
	}
	return winderbreakmonitoringData;
}

	/* (non-Javadoc)
	 * @see com.st.clrewinder.dao.CLRewinderDao#getWinderBreakReasonPrimaryReason()
	 */
	@Override
	public List<CLRewinder> getWinderBreakReasonPrimaryReason() {	
	JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
	String sql="  Select [id],[Reasonofbreak] From [tbl_clrewindermonitoringbreakreason] group by [Reasonofbreak],[id]";
	List<CLRewinder> winderdata=jdbcTemplate.query(sql,new Object[]{}, new CLWinderReasonBreakMapper());
	return winderdata;
}
	
	
	
}

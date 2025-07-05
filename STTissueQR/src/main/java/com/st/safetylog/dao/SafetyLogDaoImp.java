/**
 * 
 */
package com.st.safetylog.dao;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.st.safetylog.mapper.SafetyLogMapper;
import com.st.safetylog.model.SafetyLog;

/**
 * @author sbora
 *
 */
@Repository
public class SafetyLogDaoImp implements SafetyLogDao {

	
	@Autowired
	private DataSource dataSource;
	
	/* (non-Javadoc)
	 * @see com.st.safetylog.dao.SafetyLogDao#saveOrUpdate(com.st.safetylog.model.SafetyLog)
	 */
	@Override
	public void saveOrUpdate(SafetyLog safetyLog) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		
		if(safetyLog.getId()>0){
			String sql="update [safetyLogData] SET "
					+ "[Date]=?,"
					+ "[Description]=?,"
					+ "[Employee]=?,"
					+ "[ForkliftShutdown]=?,"
					+ "[PropertyDamage]=?,"
					+ "[UnsafeWork]=?,"
					+ "[Fire]=?,"
					+ "[NearMiss]=?,"
					+ "[FirstAid]=?,"
					+ "[Recordable]=?,"	
					+ "[LostTime]=?,"	
					+ "[Other]=?,"
					//+ "[DaysToCompletion]=?,"
					+ "[Area]=?,"
					+ "[Remarks]=?,"
					+ "[IncidentDate]=?,"
					+ "[actionitems]=?,"
					+ "[categoryofincidents]=? "
					+ " where "
					+ " [ID]=?";
			jdbcTemplate.update(sql, new Object[]{
					new Timestamp(safetyLog.getDate().getTime()),
					safetyLog.getDescription(),
					safetyLog.getEmployee(),
					safetyLog.getForkliftShutdown(),
					safetyLog.getPropertyDamage(),
					safetyLog.getUnsafeWork(),
					safetyLog.getFire(),
					safetyLog.getNearMiss(),
					safetyLog.getFirstAid(),
					safetyLog.getRecordable(),
					safetyLog.getLostTime(),
					safetyLog.getOther(),
					//safetyLog.getDaysToCompletion(),
					safetyLog.getArea(),
					safetyLog.getRemarks(),
					new Timestamp(safetyLog.getIncidentDate().getTime()),
					safetyLog.getActionitems(),
					safetyLog.getCategoryofincidents(),
					safetyLog.getId()
			});
		}else{
			String sql="insert into [safetyLogData] ( "
					+ "[Date],"
					+ "[Description],"
					+ "[Employee],"
					+ "[ForkliftShutdown],"
					+ "[PropertyDamage],"
					+ "[UnsafeWork],"
					+ "[Fire],"
					+ "[NearMiss],"
					+ "[FirstAid],"
					+ "[Recordable],"	
					+ "[LostTime],"	
					+ "[Other],"
				//	+ "[DaysToCompletion],"
					+ "[Area],"
					+ "[Remarks],"
					+ "[IncidentDate],"
					+ "[actionitems],"
					+ "[categoryofincidents]) "
					+ " "
					+ " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ";
			jdbcTemplate.update(sql, new Object[]{
					new Timestamp(safetyLog.getDate().getTime()),
					safetyLog.getDescription(),
					safetyLog.getEmployee(),
					safetyLog.getForkliftShutdown(),
					safetyLog.getPropertyDamage(),
					safetyLog.getUnsafeWork(),
					safetyLog.getFire(),
					safetyLog.getNearMiss(),
					safetyLog.getFirstAid(),
					safetyLog.getRecordable(),
					safetyLog.getLostTime(),
					safetyLog.getOther(),
				//	safetyLog.getDaysToCompletion(),
					safetyLog.getArea(),
					safetyLog.getRemarks(),
					new Timestamp(safetyLog.getIncidentDate().getTime()),
					safetyLog.getActionitems(),
					safetyLog.getCategoryofincidents()
			});
		}
		
	}

	/* (non-Javadoc)
	 * @see com.st.safetylog.dao.SafetyLogDao#getSafetyLogs(java.util.Date, java.util.Date)
	 */
	@Override
	public List<SafetyLog> getSafetyLogs(Date sdate, Date edate) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		
		String sql="select * from [safetyLogData] where [Date] between ? and  ?  order by [Date]";
		List<SafetyLog> safetyLogs=jdbcTemplate.query(sql,	new Object[]{
				new Timestamp(sdate.getTime()),
				new Timestamp(edate.getTime())
		},new SafetyLogMapper());
		
		return safetyLogs;
	}

	/* (non-Javadoc)
	 * @see com.st.safetylog.dao.SafetyLogDao#getSafetyLog(int)
	 */
	@Override
	public SafetyLog getSafetyLog(int id) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		String sql="select * from [safetyLogData] where [ID]=?";
		SafetyLog safetyLog=jdbcTemplate.queryForObject(sql,new Object[]{
				id
		},new SafetyLogMapper());
		
		return safetyLog;
	}

	/* (non-Javadoc)
	 * @see com.st.safetylog.dao.SafetyLogDao#delete(int)
	 */
	@Override
	public void delete(int id) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		String sql="delete from [safetyLogData] where [ID]=?";
		jdbcTemplate.update(sql, new Object[]{id});
		
	}

	/* (non-Javadoc)
	 * @see com.st.safetylog.dao.SafetyLogDao#close(int)
	 */
	@Override
	public void close(SafetyLog safetyLog) {
		
		
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		String sql="update [safetyLogData] set [DayToCompletion]=? where [ID]=?";
		jdbcTemplate.update(sql, new Object[]{new Timestamp(new Date().getTime()),safetyLog.getId()});
	}

	/* (non-Javadoc)
	 * @see com.st.safetylog.dao.SafetyLogDao#updateSafetyLogReview(int, java.util.Date)
	 */
	@Override
	public void updateSafetyLogReview(int id, Date date) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		String sql="update [safetyLogData] set [DayToCompletion]=? where [ID]=?";
		jdbcTemplate.update(sql, new Object[]{new Timestamp(date.getTime()),id});
	}

	/* (non-Javadoc)
	 * @see com.st.safetylog.dao.SafetyLogDao#resetLog(com.st.safetylog.model.SafetyLog)
	 */
	@Override
	public void resetLog(SafetyLog safetyLog) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		String sql="update [safetyLogData] set [DayToCompletion]=? where [ID]=?";
		jdbcTemplate.update(sql, new Object[]{null,safetyLog.getId()});
	}

}

/**
 *May 24, 2016
 *SafetyHousekeepingSchedulesStatusMapper.java
 * TODO
 *com.st.safetylog.mapper
 *SafetyHousekeepingSchedulesStatusMapper.java
 *Sunil Singh Bora
 */
package com.st.safetylog.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import com.st.safetylog.model.SafetyHousekeepingSchedule;


/**
 * @author sbora
 *
 */
public class SafetyHousekeepingSchedulesStatusMapper implements RowMapper<SafetyHousekeepingSchedule> {

	/* (non-Javadoc)
	 * @see org.springframework.jdbc.core.RowMapper#mapRow(java.sql.ResultSet, int)
	 */
	@Override
	public SafetyHousekeepingSchedule mapRow(ResultSet rs, int arg1)
			throws SQLException {
		// TODO Auto-generated method stub
		SafetyHousekeepingSchedule housekeeping=new SafetyHousekeepingSchedule();
		housekeeping.setAuditor(rs.getInt("Auditor"));
		housekeeping.setArea(rs.getInt("Area"));
		housekeeping.setAuditStatus(rs.getBoolean("AuditStatus"));
		housekeeping.setAuditorName(rs.getString("AuditorName"));
		return housekeeping;
	}

}

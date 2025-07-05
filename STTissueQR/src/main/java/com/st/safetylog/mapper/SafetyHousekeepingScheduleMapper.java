/**
 * 
 */
package com.st.safetylog.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.jdbc.core.RowMapper;

import com.st.safetylog.model.SafetyHousekeepingSchedule;

/**
 * @author sbora
 *
 */
public class SafetyHousekeepingScheduleMapper implements
		RowMapper<SafetyHousekeepingSchedule> {

	/* (non-Javadoc)
	 * @see org.springframework.jdbc.core.RowMapper#mapRow(java.sql.ResultSet, int)
	 */
	@Override
	public SafetyHousekeepingSchedule mapRow(ResultSet rs, int arg1)
			throws SQLException {
		SafetyHousekeepingSchedule housekeepingSchedule=new SafetyHousekeepingSchedule();
		housekeepingSchedule.setId(rs.getInt("ID"));
		housekeepingSchedule.setAuditor(rs.getInt("Auditor"));
		housekeepingSchedule.setArea(rs.getInt("Area"));
		Date date=new Date(rs.getTimestamp("Date").getTime());
		housekeepingSchedule.setDate(date);
		housekeepingSchedule.setRecurrence(rs.getString("Recurrence"));
		housekeepingSchedule.setAuditStatus(rs.getBoolean("AuditStatus"));
/*		housekeepingSchedule.setWeekId(rs.getString("WeekID"));
		housekeepingSchedule.setMonthId(rs.getString("MonthID"));
		housekeepingSchedule.setDayId(rs.getString("DayID"));*/
	
		
		housekeepingSchedule.setFormatedDate(new SimpleDateFormat("MM-dd-yyyy").format(date));
		
		return housekeepingSchedule;
	}

}

/**
 * 
 */
package com.st.safetylog.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

import org.springframework.jdbc.core.RowMapper;

import com.st.common.CommonUtil;
import com.st.safetylog.model.SafetyLog;

/**
 * @author sbora
 *
 */
public class SafetyLogMapper implements RowMapper<SafetyLog> {

	/* (non-Javadoc)
	 * @see org.springframework.jdbc.core.RowMapper#mapRow(java.sql.ResultSet, int)
	 */
	@Override
	public SafetyLog mapRow(ResultSet rs, int arg1) throws SQLException {
		SafetyLog safetyLog=new SafetyLog();
		safetyLog.setId(rs.getInt("ID"));
		Timestamp date=rs.getTimestamp("Date");
		safetyLog.setDate(new Date(date.getTime()));
		safetyLog.setDescription(rs.getString("Description"));
		safetyLog.setEmployee(rs.getString("Employee"));
		safetyLog.setForkliftShutdown(rs.getInt("ForkliftShutdown"));
		safetyLog.setPropertyDamage(rs.getInt("PropertyDamage"));
		safetyLog.setUnsafeWork(rs.getInt("UnsafeWork"));
		safetyLog.setFire(rs.getInt("Fire"));
		safetyLog.setNearMiss(rs.getInt("NearMiss"));
		safetyLog.setFirstAid(rs.getInt("FirstAid"));
		safetyLog.setRecordable(rs.getInt("Recordable"));
		safetyLog.setLostTime(rs.getInt("LostTime"));
		safetyLog.setOther(rs.getInt("Other"));
		Timestamp dayToComplete=rs.getTimestamp("DayToCompletion");
		if(dayToComplete!=null){
			safetyLog.setDayToCompletion(new Date(dayToComplete.getTime()));
			safetyLog.setNumOfdays(CommonUtil.getDaysDiffernce(new Date(date.getTime()),new Date(dayToComplete.getTime())));
		}
		
		
		Timestamp incidentDate=rs.getTimestamp("IncidentDate");
		if(incidentDate!=null){
			safetyLog.setIncidentDate(new Date(incidentDate.getTime()));
			safetyLog.setDaysToReport(CommonUtil.getDaysDiffernce(new Date(incidentDate.getTime()),new Date(date.getTime())));
		}
		
		safetyLog.setArea(rs.getString("Area"));
		safetyLog.setActionitems(rs.getString("actionitems"));
		safetyLog.setCategoryofincidents(rs.getString("categoryofincidents"));
		safetyLog.setRemarks(rs.getString("Remarks"));
		
		
		
		return safetyLog;
	}

}

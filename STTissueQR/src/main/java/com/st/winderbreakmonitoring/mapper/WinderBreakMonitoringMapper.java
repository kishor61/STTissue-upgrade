/**
 *Oct 30, 2015
 *WinderBreakMonitoringMapper.java
 * TODO
 *com.st.winderbreakmonitoring.mapper
 *WinderBreakMonitoringMapper.java
 *Sunil Singh Bora
 */
package com.st.winderbreakmonitoring.mapper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import org.springframework.jdbc.core.RowMapper;

import com.st.common.Columns;
import com.st.customercomplaint.model.CustomerComplaint;
import com.st.winderbreakmonitoring.model.WinderBreakMonitoring;

/**
 * @author roshan
 *
 */
public class WinderBreakMonitoringMapper implements RowMapper<WinderBreakMonitoring>{

	/* (non-Javadoc)
	 * @see org.springframework.jdbc.core.RowMapper#mapRow(java.sql.ResultSet, int)
	 */
	@Override
	public WinderBreakMonitoring mapRow(ResultSet rs, int arg1)
			throws SQLException {
		// TODO Auto-generated method stub
		WinderBreakMonitoring wmd=new WinderBreakMonitoring();
		wmd.setId(rs.getInt("ID"));
		wmd.setDate(new Date(rs.getTimestamp("Dates").getTime()));
		wmd.setShift(rs.getString("Shift"));
		wmd.setCrew(rs.getString("Crew"));
		wmd.setReel(rs.getString("Reel"));
		wmd.setSetNo(rs.getString("SetNo"));
		wmd.setBreakAt(rs.getString("BreakAt"));
		wmd.setLosstime(rs.getString("Losstime"));
		wmd.setReasonforbreak(rs.getString("Reasonforbreak")==null?"":rs.getString("Reasonforbreak".toUpperCase()));
		//wmd.setReasonforbreak(rs.getString("Reasonofbreak".toUpperCase()));
		wmd.setLeftoutinSpool(rs.getString("LeftoutinSpool"));
		
		/*wmd.setStoptime(rs.getString("Stoptime"));
		wmd.setStarttime(rs.getString("Starttime"));*/
		
		wmd.setStoptime(rs.getTimestamp("Stoptime"));
		wmd.setStarttime(rs.getTimestamp("Starttime"));
		
		wmd.setDowntime(rs.getString("Downtime"));
		wmd.setGradeCode(rs.getString("gradeCode"));
		
		return wmd;
	}

}

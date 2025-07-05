/**
 *Oct 31, 2015
 *WinderBreakMonitoringReasonBreakMapper.java
 * TODO
 *com.st.winderbreakmonitoring.mapper
 *WinderBreakMonitoringReasonBreakMapper.java
 *Sunil Singh Bora
 */
package com.st.winderbreakmonitoring.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import org.springframework.jdbc.core.RowMapper;

import com.st.winderbreakmonitoring.model.WinderBreakMonitoring;

/**
 * @author roshan
 *
 */
public class WinderBreakMonitoringReasonBreakMapper  implements RowMapper<WinderBreakMonitoring> {

	/* (non-Javadoc)
	 * @see org.springframework.jdbc.core.RowMapper#mapRow(java.sql.ResultSet, int)
	 */
	@Override
	public WinderBreakMonitoring mapRow(ResultSet rs, int arg1)
			throws SQLException {
		// TODO Auto-generated method stub
		WinderBreakMonitoring wmd=new WinderBreakMonitoring();
		wmd.setId(rs.getInt("ID"));
		//wmd.setReasonforbreak(rs.getString("Reasonforbreak")==null?"Not Found":rs.getString("Reasonforbreak".toUpperCase()));
		wmd.setReasonforbreak(rs.getString("Reasonofbreak".toUpperCase()));
		return wmd;
	}

}

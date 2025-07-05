/**
 *Jun 7, 2016
 *WinderBreakMonitoringSecondaryReasonBreakMapper.java
 * TODO
 *com.st.winderbreakmonitoring.mapper
 *WinderBreakMonitoringSecondaryReasonBreakMapper.java
 *Sunil Singh Bora
 */
package com.st.winderbreakmonitoring.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.st.winderbreakmonitoring.model.WinderBreakMonitoring;

/**
 * @author roshan
 *
 */
public class WinderBreakMonitoringSecondaryReasonBreakMapper  implements RowMapper<WinderBreakMonitoring> {

	/* (non-Javadoc)
	 * @see org.springframework.jdbc.core.RowMapper#mapRow(java.sql.ResultSet, int)
	 */
	@Override
	public WinderBreakMonitoring mapRow(ResultSet rs, int arg1)
			throws SQLException {
		// TODO Auto-generated method stub
		WinderBreakMonitoring wmd=new WinderBreakMonitoring();
		wmd.setId(rs.getInt("ID"));
		wmd.setPrimarycode(rs.getString("PrimaryCode".toUpperCase()));
		wmd.setSecondarycode(rs.getString("SecondaryCode".toUpperCase()));
		return wmd;
	}

}

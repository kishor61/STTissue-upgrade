/**
 *Sep 12, 2017
 *DownTimeAndLostTimeSecondaryCodeMapper.java
 * TODO
 *com.st.downtimeandlosttimereport.mapper
 *DownTimeAndLostTimeSecondaryCodeMapper.java
 *Roshan Lal Tailor
 */
package com.st.downtimeandlosttimereport.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.st.common.Columns;
import com.st.downtimeandlosttimereport.model.DownTimeAndLostTimeReport;
import com.st.efficiency.model.PrimaryCode;

/**
 * @author roshan
 *
 */
public class DownTimeAndLostTimeSecondaryCodeMapper implements RowMapper<DownTimeAndLostTimeReport> {

	/* (non-Javadoc)
	 * @see org.springframework.jdbc.core.RowMapper#mapRow(java.sql.ResultSet, int)
	 */
	@Override
	public DownTimeAndLostTimeReport mapRow(ResultSet rs, int arg1) throws SQLException {
		DownTimeAndLostTimeReport code=new DownTimeAndLostTimeReport();
		code.setId(rs.getInt(Columns.COL_01));
		code.setCode(rs.getString(Columns.COL_02));
		code.setNote(rs.getString(Columns.COL_03));
		PrimaryCode primaryCode=new PrimaryCode();
		primaryCode.setId(rs.getInt(Columns.COL_04));
		code.setPrimaryCode(primaryCode);
		return code;
	}

}
/**
 * 
 */
package com.st.efficiency.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.st.common.Columns;
import com.st.efficiency.model.PrimaryCode;

/**
 * @author sbora
 *
 */
public class PrimaryCodeMapper implements RowMapper<PrimaryCode> {

	/* (non-Javadoc)
	 * @see org.springframework.jdbc.core.RowMapper#mapRow(java.sql.ResultSet, int)
	 */
	@Override
	public PrimaryCode mapRow(ResultSet rs, int arg1) throws SQLException {
		PrimaryCode code=new PrimaryCode();
		code.setId(rs.getInt(Columns.COL_01));
		code.setCode(rs.getString(Columns.COL_02));
		code.setNote(rs.getString(Columns.COL_03));
		return code;
	}

}

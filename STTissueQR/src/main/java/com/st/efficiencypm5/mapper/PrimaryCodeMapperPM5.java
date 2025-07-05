/**
 * 
 */
package com.st.efficiencypm5.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.st.common.Columns;
import com.st.efficiency.model.PrimaryCode;
import com.st.efficiencypm5.model.PrimaryCodePM5;

/**
 * @author sbora
 *
 */
public class PrimaryCodeMapperPM5 implements RowMapper<PrimaryCodePM5> {

	/* (non-Javadoc)
	 * @see org.springframework.jdbc.core.RowMapper#mapRow(java.sql.ResultSet, int)
	 */
	@Override
	public PrimaryCodePM5 mapRow(ResultSet rs, int arg1) throws SQLException {
		PrimaryCodePM5 code=new PrimaryCodePM5();
		code.setId(rs.getInt(Columns.COL_01));
		code.setCode(rs.getString(Columns.COL_02));
		code.setNote(rs.getString(Columns.COL_03));
		return code;
	}

}

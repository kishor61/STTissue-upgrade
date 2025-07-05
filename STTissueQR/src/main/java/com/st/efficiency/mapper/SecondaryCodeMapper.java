/**
 * 
 */
package com.st.efficiency.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.st.common.Columns;
import com.st.efficiency.model.PrimaryCode;
import com.st.efficiency.model.SecondaryCode;

/**
 * @author sbora
 *
 */
public class SecondaryCodeMapper implements RowMapper<SecondaryCode> {

	/* (non-Javadoc)
	 * @see org.springframework.jdbc.core.RowMapper#mapRow(java.sql.ResultSet, int)
	 */
	@Override
	public SecondaryCode mapRow(ResultSet rs, int arg1) throws SQLException {
		SecondaryCode code=new SecondaryCode();
		code.setId(rs.getInt(Columns.COL_01));
		code.setCode(rs.getString(Columns.COL_02));
		code.setNote(rs.getString(Columns.COL_03));
		PrimaryCode primaryCode=new PrimaryCode();
		primaryCode.setId(rs.getInt(Columns.COL_04));
		code.setPrimaryCode(primaryCode);
		return code;
	}

}

/**
 * 
 */
package com.st.frpefficiency.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.st.common.Columns;
import com.st.frpefficiency.model.FrpPrimaryCode;

/**
 * @author sbora
 *
 */
public class FrpPrimaryCodeMapper implements RowMapper<FrpPrimaryCode> {

	/* (non-Javadoc)
	 * @see org.springframework.jdbc.core.RowMapper#mapRow(java.sql.ResultSet, int)
	 */
	@Override
	public FrpPrimaryCode mapRow(ResultSet rs, int arg1) throws SQLException {
		FrpPrimaryCode code=new FrpPrimaryCode();
		code.setId(rs.getInt(Columns.COL_01));
		code.setCode(rs.getString(Columns.COL_02));
		code.setNote(rs.getString(Columns.COL_03));
		return code;
	}

}

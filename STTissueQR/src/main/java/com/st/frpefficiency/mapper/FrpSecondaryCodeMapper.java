/**
 * 
 */
package com.st.frpefficiency.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.st.common.Columns;
import com.st.frpefficiency.model.FrpPrimaryCode;
import com.st.frpefficiency.model.FrpSecondaryCode;

/**
 * @author sbora
 *
 */
public class FrpSecondaryCodeMapper implements RowMapper<FrpSecondaryCode> {

	/* (non-Javadoc)
	 * @see org.springframework.jdbc.core.RowMapper#mapRow(java.sql.ResultSet, int)
	 */
	@Override
	public FrpSecondaryCode mapRow(ResultSet rs, int arg1) throws SQLException {
		FrpSecondaryCode code=new FrpSecondaryCode();
		code.setId(rs.getInt(Columns.COL_01));
		code.setCode(rs.getString(Columns.COL_02));
		code.setNote(rs.getString(Columns.COL_03));
		FrpPrimaryCode primaryCode=new FrpPrimaryCode();
		primaryCode.setId(rs.getInt(Columns.COL_04));
		code.setPrimaryCode(primaryCode);
		return code;
	}

}

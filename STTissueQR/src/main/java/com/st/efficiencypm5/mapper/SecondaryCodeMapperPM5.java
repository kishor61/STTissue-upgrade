/**
 * 
 */
package com.st.efficiencypm5.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.st.common.Columns;
import com.st.efficiency.model.PrimaryCode;
import com.st.efficiency.model.SecondaryCode;
import com.st.efficiencypm5.model.PrimaryCodePM5;
import com.st.efficiencypm5.model.SecondaryCodePM5;

/**
 * @author sbora
 *
 */
public class SecondaryCodeMapperPM5 implements RowMapper<SecondaryCodePM5> {

	/* (non-Javadoc)
	 * @see org.springframework.jdbc.core.RowMapper#mapRow(java.sql.ResultSet, int)
	 */
	@Override
	public SecondaryCodePM5 mapRow(ResultSet rs, int arg1) throws SQLException {
		SecondaryCodePM5 code=new SecondaryCodePM5();
		code.setId(rs.getInt(Columns.COL_01));
		code.setCode(rs.getString(Columns.COL_02));
		code.setNote(rs.getString(Columns.COL_03));
		PrimaryCodePM5 primaryCode=new PrimaryCodePM5();
		primaryCode.setId(rs.getInt(Columns.COL_04));
		code.setPrimaryCode(primaryCode);
		return code;
	}

}

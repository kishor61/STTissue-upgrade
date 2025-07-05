/**
 * 
 */
package com.st.chemicalinventory.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.st.chemicalinventory.model.ChemicalSecondaryCode;

/**
 * @author sbora
 *
 */
public class ChemicalSecondaryCodeMapper implements
		RowMapper<ChemicalSecondaryCode> {

	/* (non-Javadoc)
	 * @see org.springframework.jdbc.core.RowMapper#mapRow(java.sql.ResultSet, int)
	 */
	@Override
	public ChemicalSecondaryCode mapRow(ResultSet rs, int arg1)
			throws SQLException {
		ChemicalSecondaryCode chemicalSecondaryCode=new ChemicalSecondaryCode();
		
		chemicalSecondaryCode.setId(rs.getInt("ID"));
		chemicalSecondaryCode.setName(rs.getString("Name"));
		chemicalSecondaryCode.setPid(rs.getInt("PID"));
		chemicalSecondaryCode.setDeleted(rs.getBoolean("Deleted"));
		try {
			chemicalSecondaryCode.setPrimaryCode(rs.getString("PrimaryCode"));
		} catch (Exception e) {}
		
		return chemicalSecondaryCode;
	}

}

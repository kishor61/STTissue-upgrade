/**
 * 
 */
package com.st.chemicalinventory.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.st.chemicalinventory.model.ChemicalPrimaryCode;

/**
 * @author sbora
 *
 */
public class ChemicalPrimaryCodeMapper implements RowMapper<ChemicalPrimaryCode> {

	/* (non-Javadoc)
	 * @see org.springframework.jdbc.core.RowMapper#mapRow(java.sql.ResultSet, int)
	 */
	@Override
	public ChemicalPrimaryCode mapRow(ResultSet rs, int arg1)
			throws SQLException {
		ChemicalPrimaryCode chemicalPrimaryCode=new ChemicalPrimaryCode();
		chemicalPrimaryCode.setId(rs.getInt("ID"));
		chemicalPrimaryCode.setName(rs.getString("Name"));
		chemicalPrimaryCode.setDeleted(rs.getBoolean("Deleted"));
		return chemicalPrimaryCode;
	}

}

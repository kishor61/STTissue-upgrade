/**
 * 
 */
package com.st.chemicalinventory.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.st.chemicalinventory.model.ChemicalCode;

/**
 * @author sbora
 *
 */
public class ChemicalCodeMapper implements
		RowMapper<ChemicalCode> {

	/* (non-Javadoc)
	 * @see org.springframework.jdbc.core.RowMapper#mapRow(java.sql.ResultSet, int)
	 */
	@Override
	public ChemicalCode mapRow(ResultSet rs, int arg1)
			throws SQLException {
		ChemicalCode chemicalCode=new ChemicalCode();
		
		chemicalCode.setId(rs.getInt("ID"));
		chemicalCode.setCode(rs.getString("Code"));
		chemicalCode.setMin(rs.getDouble("Min"));
		chemicalCode.setTarget(rs.getDouble("Target"));
		chemicalCode.setMax(rs.getDouble("Max"));
		chemicalCode.setDeleted(rs.getBoolean("Deleted"));
		chemicalCode.setUnit(rs.getString("Unit"));
		return chemicalCode;
	}

}

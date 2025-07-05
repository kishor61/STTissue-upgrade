/**
 *Mar 4, 2016
 *FrpProdcutionOperatorDataEntryMapper.java
 * TODO
 *com.st.frpprojection.mapper
 *FrpProdcutionOperatorDataEntryMapper.java
 *Sunil Singh Bora
 */
package com.st.frpprojection.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import org.springframework.jdbc.core.RowMapper;

import com.st.frpproduction.model.FrpProdcutionOperatorDataEntry;


/**
 * @author roshan
 *
 */
public class FrpProdcutionOperatorDataEntryMapper implements RowMapper<FrpProdcutionOperatorDataEntry> {

	/* (non-Javadoc)
	 * @see org.springframework.jdbc.core.RowMapper#mapRow(java.sql.ResultSet, int)
	 */
	@Override
	public FrpProdcutionOperatorDataEntry mapRow(ResultSet rs, int arg1)
			throws SQLException {
		// TODO Auto-generated method stub
		FrpProdcutionOperatorDataEntry cc=new FrpProdcutionOperatorDataEntry();
		cc.setId(rs.getInt("ID"));
		cc.setDate(new Date(rs.getTimestamp("dates").getTime()));
		cc.setShift(rs.getString("shift"));
		cc.setCol1(rs.getDouble("col1"));
		cc.setCol1(rs.getDouble("col1"));
		cc.setCol1(rs.getDouble("col1"));
		cc.setCol1(rs.getDouble("col1"));
		cc.setCol1(rs.getDouble("col1"));
		cc.setCol1(rs.getDouble("col1"));
		cc.setCol1(rs.getDouble("col1"));
		cc.setCol1(rs.getDouble("col1"));
		cc.setCol1(rs.getDouble("col1"));
		cc.setCol1(rs.getDouble("col1"));
		
		return cc;
	}

}

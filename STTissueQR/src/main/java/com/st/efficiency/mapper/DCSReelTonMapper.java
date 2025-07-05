/**
 *Dec 1, 2015
 *DCSReelTonMapper.java
 * TODO
 *com.st.efficiency.mapper
 *DCSReelTonMapper.java
 *Sunil Singh Bora
 */
package com.st.efficiency.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import org.springframework.jdbc.core.RowMapper;

import com.st.efficiency.model.EfficiencyShiftData;

/**
 * @author sbora
 *
 */
public class DCSReelTonMapper implements RowMapper<EfficiencyShiftData> {

	/* (non-Javadoc)
	 * @see org.springframework.jdbc.core.RowMapper#mapRow(java.sql.ResultSet, int)
	 */
	@Override
	public EfficiencyShiftData mapRow(ResultSet rs, int arg1)
			throws SQLException {
		// TODO Auto-generated method stub
			EfficiencyShiftData dcs=new EfficiencyShiftData();
			dcs.setId(rs.getInt("ID"));
			dcs.setDate(new Date(rs.getTimestamp("Date").getTime()));
			dcs.setShift(rs.getString("Shift"));
			dcs.setActualWt(rs.getDouble("ton"));
		return dcs;
	}

}

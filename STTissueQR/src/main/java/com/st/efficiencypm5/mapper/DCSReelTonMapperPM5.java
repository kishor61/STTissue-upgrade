/**
 *Dec 1, 2015
 *DCSReelTonMapper.java
 * TODO
 *com.st.efficiency.mapper
 *DCSReelTonMapper.java
 *Sunil Singh Bora
 */
package com.st.efficiencypm5.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import org.springframework.jdbc.core.RowMapper;

import com.st.efficiency.model.EfficiencyShiftData;
import com.st.efficiencypm5.model.EfficiencyShiftDataPM5;

/**
 * @author sbora
 *
 */
public class DCSReelTonMapperPM5 implements RowMapper<EfficiencyShiftDataPM5> {

	/* (non-Javadoc)
	 * @see org.springframework.jdbc.core.RowMapper#mapRow(java.sql.ResultSet, int)
	 */
	@Override
	public EfficiencyShiftDataPM5 mapRow(ResultSet rs, int arg1)
			throws SQLException {
		// TODO Auto-generated method stub
			EfficiencyShiftDataPM5 dcs=new EfficiencyShiftDataPM5();
			dcs.setId(rs.getInt("ID"));
			dcs.setDate(new Date(rs.getTimestamp("Date").getTime()));
			dcs.setShift(rs.getString("Shift"));
			dcs.setActualWt(rs.getDouble("ton"));
		return dcs;
	}

}

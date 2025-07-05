/**
 *Dec 22, 2015
 *FrpGoalsCheckDataMapper.java
 * TODO
 *com.st.frpgoals.mapper
 *FrpGoalsCheckDataMapper.java
 *Sunil Singh Bora
 */
package com.st.frpgoals.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.st.frpgoals.model.FrpGoals;

/**
 * @author roshan
 *
 */
public class FrpGoalsCheckDataMapper implements RowMapper<FrpGoals> {

	/* (non-Javadoc)
	 * @see org.springframework.jdbc.core.RowMapper#mapRow(java.sql.ResultSet, int)
	 */
	@Override
	public FrpGoals mapRow(ResultSet rs, int arg1) throws SQLException {
		// TODO Auto-generated method stub
		FrpGoals frpgoals=new FrpGoals();
		frpgoals.setMonth(rs.getInt("monthS"));
		frpgoals.setYear(rs.getInt("yearS"));
		return frpgoals;
	}

}

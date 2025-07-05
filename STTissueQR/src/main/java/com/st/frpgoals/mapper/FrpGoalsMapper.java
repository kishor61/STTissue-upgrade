/**
 *Dec 22, 2015
 *FrpGoalsMapper.java
 * TODO
 *com.st.frpgoals.mapper
 *FrpGoalsMapper.java
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
public class FrpGoalsMapper implements RowMapper<FrpGoals>  {

	/* (non-Javadoc)
	 * @see org.springframework.jdbc.core.RowMapper#mapRow(java.sql.ResultSet, int)
	 */
	@Override
	public FrpGoals mapRow(ResultSet rs, int arg1) throws SQLException {
		// TODO Auto-generated method stub
		FrpGoals frpgoals=new FrpGoals();
		frpgoals.setMonth(rs.getInt("monthS"));
		frpgoals.setYear(rs.getInt("yearS"));
		frpgoals.setSowAndCbsF(rs.getDouble("sowAndCbsF"));
		frpgoals.setNewsBankF(rs.getDouble("newsBankF"));
		frpgoals.setOccF(rs.getDouble("occF"));
		frpgoals.setDlkF(rs.getDouble("dlkF"));
		frpgoals.setMailF(rs.getDouble("mailF"));
		frpgoals.setMixedOtherF(rs.getDouble("mixedOtherF"));
		frpgoals.setCutbookF(rs.getDouble("cutbookF"));
		frpgoals.setSowAndCbsW(rs.getDouble("sowAndCbsP"));
		frpgoals.setNewsBankW(rs.getDouble("newsBankP"));
		frpgoals.setOccW(rs.getDouble("occP"));
		frpgoals.setDlkW(rs.getDouble("dlkP"));
		frpgoals.setMailW(rs.getDouble("mailP"));
		frpgoals.setMixedOtherW(rs.getDouble("mixedOtherP"));
		frpgoals.setCutbookW(rs.getDouble("cutbookP"));
		return frpgoals;
	}

}

/**
 * 
 */
package com.st.efficiencypm5.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import org.springframework.jdbc.core.RowMapper;

import com.st.common.Columns;
import com.st.common.CommonUtil;
import com.st.efficiencypm5.model.EfficiencyPM5;
import com.st.efficiencypm5.model.SecondaryCodePM5;

/**
 * @author sbora
 *
 */
public class EfficiencyMapperPM5 implements RowMapper<EfficiencyPM5> {

	
	@Override
	public EfficiencyPM5 mapRow(ResultSet rs, int arg1) throws SQLException {
		EfficiencyPM5 efficency=new EfficiencyPM5();
		efficency.setId(rs.getInt(Columns.COL_01));
		efficency.setDate(rs.getDate(Columns.COL_02));
		efficency.setShift(rs.getString(Columns.COL_03));
		efficency.setCrew(rs.getString(Columns.COL_04));
		efficency.setStartTime(rs.getTimestamp(Columns.COL_05));
		efficency.setEndTime(rs.getTimestamp(Columns.COL_06));
		efficency.setReel(rs.getString(Columns.COL_07));
		efficency.setGradeCode(rs.getString(Columns.COL_08));
		efficency.setComment(rs.getString(Columns.COL_09));
		SecondaryCodePM5 secondaryCode=new SecondaryCodePM5();
		secondaryCode.setId(rs.getInt(Columns.COL_10));
		efficency.setSecondaryCode(secondaryCode);

	//	System.out.println(new Date(efficency.getStartTime().getTime()));
	//	System.out.println(new Date(efficency.getEndTime().getTime()));
		
		efficency.setFendTimeHH(""+CommonUtil.getHoursDuration(new Date(efficency.getStartTime().getTime()), new Date(efficency.getEndDate().getTime())));
		efficency.setFendTimeHH(""+CommonUtil.getMinutesDuration(new Date(efficency.getStartTime().getTime()), new Date(efficency.getEndDate().getTime())));
		
		return efficency;
	}

}

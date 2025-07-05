/**
 *May 1, 2017
 *CLRewinderMapper.java
 * TODO
 *com.st.clrewinder.mapper
 *CLRewinderMapper.java
 *Roshan Lal Tailor
 */
package com.st.clrewinder.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.st.clrewinder.model.CLRewinder;

/**
 * @author roshan
 *
 */
@Component
public class CLRewinderMapper implements RowMapper<CLRewinder>{


	/* (non-Javadoc)
	 * @see org.springframework.jdbc.core.RowMapper#mapRow(java.sql.ResultSet, int)
	 */
	@Override
	public CLRewinder mapRow(ResultSet rs, int arg1)
			throws SQLException {
		// TODO Auto-generated method stub
		CLRewinder wmd=new CLRewinder();
		wmd.setId(rs.getInt("ID"));
		wmd.setDate(new Date(rs.getTimestamp("Dates").getTime()));
		wmd.setShift(rs.getString("Shift"));
		wmd.setCrew(rs.getString("Crew"));
		wmd.setReel(rs.getString("Reel"));
		wmd.setSetNo(rs.getString("SetNo"));
		wmd.setBreakAt(rs.getString("BreakAt"));
		wmd.setLosstime(rs.getString("Losstime"));
		wmd.setReasonforbreak(rs.getString("Reasonforbreak")==null?"":rs.getString("Reasonforbreak".toUpperCase()));
		//wmd.setReasonforbreak(rs.getString("Reasonofbreak".toUpperCase()));
		wmd.setLeftoutinSpool(rs.getString("LeftoutinSpool"));
		
		/*wmd.setStoptime(rs.getString("Stoptime"));
		wmd.setStarttime(rs.getString("Starttime"));*/
		
		wmd.setStoptime(rs.getTimestamp("Stoptime"));
		wmd.setStarttime(rs.getTimestamp("Starttime"));
		
		wmd.setDowntime(rs.getString("Downtime"));
		wmd.setGradeCode(rs.getString("gradeCode"));
		
		return wmd;
	}



}

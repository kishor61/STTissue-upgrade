/**
 *Jun 8, 2017
 *CLRewinderMapperForTotalDownTime.java
 * TODO
 *com.st.clrewinder.mapper
 *CLRewinderMapperForTotalDownTime.java
 *Roshan Lal Tailor
 */
package com.st.clrewinder.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import org.springframework.jdbc.core.RowMapper;

import com.st.clrewinder.model.CLRewinder;

/**
 * @author roshan
 *
 */
public class CLRewinderMapperForTotalDownTime  implements RowMapper<CLRewinder> {


	/* (non-Javadoc)
	 * @see org.springframework.jdbc.core.RowMapper#mapRow(java.sql.ResultSet, int)
	 */
	@Override
	public CLRewinder mapRow(ResultSet rs, int arg1)
			throws SQLException {
		// TODO Auto-generated method stub
		CLRewinder wmd=new CLRewinder();
		
		wmd.setReasonforbreak(rs.getString("Reasonforbreak")==null?"":rs.getString("Reasonforbreak".toUpperCase()));
		wmd.setStoptime(rs.getTimestamp("Stoptime"));
		wmd.setStarttime(rs.getTimestamp("Starttime"));
		wmd.setComment(rs.getString("LeftoutinSpool"));
		
		return wmd;
	}



}

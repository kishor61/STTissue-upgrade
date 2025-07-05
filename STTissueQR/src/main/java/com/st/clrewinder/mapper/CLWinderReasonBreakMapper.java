/**
 *May 1, 2017
 *CLWinderReasonBreakMapper.java
 * TODO
 *com.st.clrewinder.mapper
 *CLWinderReasonBreakMapper.java
 *Roshan Lal Tailor
 */
package com.st.clrewinder.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.st.clrewinder.model.CLRewinder;

/**
 * @author roshan
 *
 */
@Component
public class CLWinderReasonBreakMapper implements RowMapper<CLRewinder> {

	/* (non-Javadoc)
	 * @see org.springframework.jdbc.core.RowMapper#mapRow(java.sql.ResultSet, int)
	 */
	@Override
	public CLRewinder mapRow(ResultSet rs, int arg1)
			throws SQLException {
		// TODO Auto-generated method stub
		CLRewinder wmd=new CLRewinder();
		wmd.setId(rs.getInt("ID"));
		//wmd.setReasonforbreak(rs.getString("Reasonforbreak")==null?"Not Found":rs.getString("Reasonforbreak".toUpperCase()));
		wmd.setReasonforbreak(rs.getString("Reasonofbreak".toUpperCase()));
		return wmd;
	}

}

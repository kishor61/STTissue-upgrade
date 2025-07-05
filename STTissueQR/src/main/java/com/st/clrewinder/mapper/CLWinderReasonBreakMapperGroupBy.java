/**
 *Jun 8, 2017
 *CLWinderReasonBreakMapperGroupBy.java
 * TODO
 *com.st.clrewinder.mapper
 *CLWinderReasonBreakMapperGroupBy.java
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
public class CLWinderReasonBreakMapperGroupBy    implements RowMapper<CLRewinder> {

	/* (non-Javadoc)
	 * @see org.springframework.jdbc.core.RowMapper#mapRow(java.sql.ResultSet, int)
	 */
	@Override
	public CLRewinder mapRow(ResultSet rs, int arg1)
			throws SQLException {
		// TODO Auto-generated method stub
		CLRewinder wmd=new CLRewinder();
		wmd.setSecondarycode(rs.getString("SecondaryCode".toUpperCase()));
		return wmd;
	}

}

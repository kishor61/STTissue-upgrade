/**
 *Oct 12, 2017
 *ManintenanceLogCr6Pm6FrpMapper.java
 * TODO
 *com.st.manintenancelogcr6pm6frp.mapper
 *ManintenanceLogCr6Pm6FrpMapper.java
 *Roshan Lal Tailor
 */
package com.st.manintenancelogcr6pm6frp.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.st.manintenancelogcr6pm6frp.model.ManintenanceLogCr6Pm6Frp;

/**
 * @author roshan
 *
 */
@Component
public class ManintenanceLogCr6Pm6FrpMapper implements RowMapper<ManintenanceLogCr6Pm6Frp>{

	/* (non-Javadoc)
	 * @see org.springframework.jdbc.core.RowMapper#mapRow(java.sql.ResultSet, int)
	 */
	@Override
	public ManintenanceLogCr6Pm6Frp mapRow(ResultSet rs, int arg1)
			throws SQLException {
		
		ManintenanceLogCr6Pm6Frp data= new ManintenanceLogCr6Pm6Frp();
		
		data.setAreaname(rs.getString("name"));
		// TODO Auto-generated method stub
		return data;
	}

}

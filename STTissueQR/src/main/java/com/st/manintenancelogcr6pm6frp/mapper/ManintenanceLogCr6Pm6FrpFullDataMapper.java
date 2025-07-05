/**
 *Oct 12, 2017
 *ManintenanceLogCr6Pm6FrpFullDataMapper.java
 * TODO
 *com.st.manintenancelogcr6pm6frp.mapper
 *ManintenanceLogCr6Pm6FrpFullDataMapper.java
 *Roshan Lal Tailor
 */
package com.st.manintenancelogcr6pm6frp.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.st.manintenancelogcr6pm6frp.model.ManintenanceLogCr6Pm6Frp;

/**
 * @author roshan
 *
 */
@Component
public class ManintenanceLogCr6Pm6FrpFullDataMapper implements RowMapper<ManintenanceLogCr6Pm6Frp>{

	private SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
	/* (non-Javadoc)
	 * @see org.springframework.jdbc.core.RowMapper#mapRow(java.sql.ResultSet, int)
	 */
	@Override
	public ManintenanceLogCr6Pm6Frp mapRow(ResultSet rs, int arg1)
			throws SQLException {
		
		ManintenanceLogCr6Pm6Frp data= new ManintenanceLogCr6Pm6Frp();
		
		data.setId(rs.getInt("id"));
		data.setDate(new Date(rs.getTimestamp("date").getTime()));
		data.setTime(timeFormat.format(new Date(rs.getTimestamp("date").getTime())));
		data.setProdtypeorgradecode(rs.getString("ProdTypeOrGradeCode"));
		data.setArea(rs.getString("area"));
		data.setError(rs.getString("error"));
		data.setComments(rs.getString("comments"));
		data.setUsertype(rs.getString("usertype"));
		
		data.setTeam(rs.getString("team"));
		data.setShift(rs.getString("shift"));
		// TODO Auto-generated method stub
		return data;
	}

}

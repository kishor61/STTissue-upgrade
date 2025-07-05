/**
 * 
 */
package com.st.frppressquality.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import org.springframework.jdbc.core.RowMapper;

import com.st.frppressquality.model.FrpPressQuality;

/**
 * @author sbora
 *
 */
public class FrpPressQualityMapper implements RowMapper<FrpPressQuality> {


	@Override
	public FrpPressQuality mapRow(ResultSet rs, int arg1) throws SQLException {
		FrpPressQuality frpPressQuality= new FrpPressQuality();
		
		frpPressQuality.setId(rs.getInt("ID"));
		frpPressQuality.setDate(new Date(rs.getTimestamp("Date").getTime()));
		frpPressQuality.setLot(rs.getInt("Lot"));
		frpPressQuality.setInitials(rs.getString("Initials"));
//		Code Starts From Here Done By Roshan Tailor
		frpPressQuality.setBleachingchemical(rs.getDouble("bleachingchemical"));
//		Code Ends Here Done By Roshan Tailor
		frpPressQuality.setGrade(rs.getString("Grade"));
		frpPressQuality.setBrightness(rs.getDouble("Brightness"));
//		Code Starts From Here Done By Roshan Tailor Date :- 03/30/2015
		frpPressQuality.setLvalue(rs.getDouble("LValue"));
		frpPressQuality.setAvalue(rs.getDouble("aValue"));
		frpPressQuality.setBvalue(rs.getDouble("bValue"));
//		Code Ends Here Done By Roshan Tailor
		frpPressQuality.setDirt(rs.getDouble("Dirt"));
		frpPressQuality.setStickies(rs.getDouble("Stickies"));
		frpPressQuality.setConsistency(rs.getDouble("Consistency"));
		frpPressQuality.setAsh(rs.getDouble("Ash"));
		frpPressQuality.setCuRunning(rs.getString("CURunning"));
		frpPressQuality.setComments(rs.getString("Comments"));
		frpPressQuality.setQualityType(rs.getString("QualityType"));
		frpPressQuality.setFreeness(rs.getDouble("Freeness"));
//		Code Starts From Here Done By Roshan Tailor Date :- 03/24/2015
		frpPressQuality.setEric(rs.getDouble("Eric"));
		frpPressQuality.setAstar(rs.getString("Astar"));
		frpPressQuality.setBstar(rs.getString("Bstar"));
		frpPressQuality.setLine(rs.getString("line"));
//		Code Ends Here Done BY Roshan Tailor
		
		return frpPressQuality;
	}

}

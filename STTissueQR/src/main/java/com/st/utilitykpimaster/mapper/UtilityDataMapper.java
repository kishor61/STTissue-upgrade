/**
 * 
 */
package com.st.utilitykpimaster.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import org.springframework.jdbc.core.RowMapper;

import com.st.utilitykpimaster.model.UtilityData;

/**
 * @author sbora
 *
 */
public class UtilityDataMapper implements RowMapper<UtilityData> {

	
	@Override
	public UtilityData mapRow(ResultSet rs, int arg1) throws SQLException {
		UtilityData utilityData=new UtilityData();
		
		utilityData.setId(rs.getInt("ID"));
		utilityData.setDate(new Date(rs.getTimestamp("Date").getTime()));
		utilityData.setLb60(rs.getInt("Lb60"));
		utilityData.setConsumption1(rs.getInt("Consumption1"));
		utilityData.setLb150(rs.getInt("Lb150"));
		utilityData.setConsumption2(rs.getInt("Consumption2"));
		utilityData.setMillWater(rs.getInt("MillWater"));
		utilityData.setConsumption3(rs.getInt("Consumption3"));
		utilityData.setCondensate(rs.getInt("Condensate"));
		utilityData.setConsumption4(rs.getInt("Consumption4"));
		utilityData.setRiverWater(rs.getInt("RiverWater"));
		utilityData.setRiverWaterData(rs.getInt("RiverWaterData"));
		return utilityData;
	}

}

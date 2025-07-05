/**
 *Dec 25, 2017
 *RewindPM5lMapper.java
 * TODO
 *com.st.qualitypm5.mapper
 *RewindPM5lMapper.java
 *Roshan Lal Tailor
 */
package com.st.qualitypm5.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import org.springframework.jdbc.core.RowMapper;

import com.st.common.Columns;
import com.st.qualitypm5.model.RewindPM5;
import com.st.qualitypm6.model.Rewind;

/**
 * @author roshan
 *
 */
public class Rewind1PM5Mapper implements RowMapper<RewindPM5>{

	@Override
	public RewindPM5 mapRow(ResultSet rs, int arg1) throws SQLException {
		RewindPM5 rewind=new RewindPM5();
		
		rewind.setId(rs.getInt(Columns.COL_01));
		rewind.setDate(new Date(rs.getTimestamp(Columns.COL_02).getTime()));
		rewind.setTime(new Date(rs.getTimestamp(Columns.COL_02).getTime()));
		rewind.setGradeCode(rs.getString(Columns.COL_03));
		rewind.setReel(rs.getString(Columns.COL_04));
		rewind.setSetNo(rs.getString(Columns.COL_05)==null?"":rs.getString(Columns.COL_05).toUpperCase());
		rewind.setActualBasisWt(rs.getDouble(Columns.COL_06));
		rewind.setBulk(rs.getDouble(Columns.COL_07));
		rewind.setMdTensile(rs.getDouble(Columns.COL_08));
		rewind.setCdTensile(rs.getDouble(Columns.COL_09));
		rewind.setMdStretch(rs.getDouble(Columns.COL_10));
		rewind.setMdcdTensileRatio(rs.getDouble(Columns.COL_11));
		rewind.setMdWetTensile(rs.getDouble(Columns.COL_12));
		rewind.setCdWetTensile(rs.getDouble(Columns.COL_13));
		rewind.setCdTensileRatio(rs.getDouble(Columns.COL_14));
		rewind.setBrightness(rs.getDouble(Columns.COL_15));
		rewind.setDirtCount(rs.getDouble(Columns.COL_16));
		rewind.setAbsorbencySeconds(rs.getDouble(Columns.COL_17));
//		Code Starts From Here Done By Roshan Tailor Date :- 03/07/2015
		rewind.setLvalue(rs.getDouble(Columns.COL_18));
		rewind.setAvalue(rs.getDouble(Columns.COL_19));
		rewind.setBvalue(rs.getDouble(Columns.COL_20));
//		Code Ends Here Done By Roshan Tailor 
		rewind.setCustomer(rs.getString(Columns.COL_21));
		rewind.setRemarks(rs.getString(Columns.COL_22));
		return rewind;
	}

}

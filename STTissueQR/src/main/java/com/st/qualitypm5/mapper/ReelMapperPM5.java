/**
 *Dec 22, 2017
 *ReelMapperPM5.java
 * TODO
 *com.st.qualitypm5.mapper
 *ReelMapperPM5.java
 *Roshan Lal Tailor
 */
package com.st.qualitypm5.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import org.springframework.jdbc.core.RowMapper;

import com.st.common.Columns;
import com.st.qualitypm5.model.ReelPM5;

/**
 * @author roshan
 *
 */
public class ReelMapperPM5 implements RowMapper<ReelPM5> {

	@Override
	public ReelPM5 mapRow(ResultSet rs, int arg1) throws SQLException {
		ReelPM5 reel=new ReelPM5();
		
		reel.setId(rs.getInt(Columns.COL_01));
		reel.setDate(new Date(rs.getTimestamp(Columns.COL_02).getTime()));
		
		if(rs.getTimestamp(Columns.COL_03)!=null){
			reel.setTime(new Date(rs.getTimestamp(Columns.COL_03).getTime()));	
		}
		
		reel.setGradeCode(rs.getString(Columns.COL_04));
		reel.setReel(rs.getString(Columns.COL_05));
		reel.setScannerBasisWt(rs.getDouble(Columns.COL_06));
		reel.setActualBasisWt(rs.getDouble(Columns.COL_07));
		reel.setBulk(rs.getDouble(Columns.COL_08));
		reel.setMdTensile(rs.getDouble(Columns.COL_09));
		reel.setCdTensile(rs.getDouble(Columns.COL_10));
		reel.setMdStretch(rs.getDouble(Columns.COL_11));
		reel.setMdcdTensileRatio(rs.getDouble(Columns.COL_12));
		reel.setMdWetTensile(rs.getDouble(Columns.COL_13));
		reel.setCdWetTensile(rs.getDouble(Columns.COL_14));
		reel.setWetDryRatio(rs.getDouble(Columns.COL_15));
		reel.setBrightness(rs.getDouble(Columns.COL_16));
		reel.setFwaFlow(rs.getDouble(Columns.COL_17));
		reel.setDirtCount(rs.getDouble(Columns.COL_18));
		reel.setFwaDosage(rs.getDouble(Columns.COL_19));
		reel.setTph(rs.getDouble(Columns.COL_20));
		reel.setTrim(rs.getDouble(Columns.COL_21));
		reel.setCrepeRatio(rs.getDouble(Columns.COL_22));
//		Code Starts From Here Done By Roshan Tailor Date :- 03/05/2015    MM/DD/YYYY
		reel.setLvalue(rs.getDouble(Columns.COL_23));
		reel.setAvalue(rs.getDouble(Columns.COL_24));
		reel.setBvalue(rs.getDouble(Columns.COL_25));
		reel.setDeltae(rs.getDouble(Columns.COL_26));
//		Code Ends Here Done By Roshan Tailor 
		reel.setCustomer(rs.getString(Columns.COL_27));
		reel.setRemarks(rs.getString(Columns.COL_28));
		
		
		
		
		reel.setAkd(rs.getDouble(Columns.COL_29));
		reel.setWetstrength(rs.getDouble(Columns.COL_30));
		reel.setDrystrengthflow(rs.getDouble(Columns.COL_31));
		reel.setCustomer1(rs.getString("Customer1"));
		reel.setCustomer2(rs.getString("Customer2"));
		reel.setFinchCup(rs.getDouble("FinchCup"));
		return reel;
	}

}

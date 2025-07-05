/**
 *Apr 23, 2015
 *FrpYieldMapper.java
 * TODO
 *com.st.frpyield.mapper
 *FrpYieldMapper.java
 *Sunil Singh Bora
 */
package com.st.frpyield.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

import org.springframework.jdbc.core.RowMapper;

import com.st.frpyield.model.FrpYield;

/**
 * @author roshan
 *
 */
public class FrpYieldMapper implements RowMapper<FrpYield>{

	@Override
	public FrpYield mapRow(ResultSet rs, int arg1) throws SQLException {
		
		FrpYield frpYield= new FrpYield();
		
		frpYield.setId(rs.getInt("id"));
		//frpYield.setDate(rs.getDouble("Date"));
		Timestamp date=rs.getTimestamp("date");
		if(date==null){
		}else{
			frpYield.setDate(new Date(rs.getTimestamp("date").getTime()));
		}
		frpYield.setSampleno(rs.getDouble("sampleno"));
		frpYield.setRfdetrasherrejcts(rs.getDouble("rfdetrasherrejcts"));
		frpYield.setRfhdcleaner(rs.getDouble("rfhdcleaner"));
		frpYield.setRftertiarycoarse(rs.getDouble("rftertiarycoarse"));
		frpYield.setRftertiaryfine(rs.getDouble("rftertiaryfine"));
		frpYield.setRffrwdcleaner(rs.getDouble("rffrwdcleaner"));
		frpYield.setRfprimcell(rs.getDouble("rfprimcell"));
		frpYield.setRfseccell(rs.getDouble("rfseccell"));
		frpYield.setRffsdclarifier(rs.getDouble("rffsdclarifier"));
		frpYield.setCyofdww(rs.getDouble("cyofdww"));
		frpYield.setRchdcleaner(rs.getDouble("rchdcleaner"));
		frpYield.setRctertiarycoarse(rs.getDouble("rctertiarycoarse"));
		frpYield.setRctertiaryfine(rs.getDouble("rctertiaryfine"));
		frpYield.setRcfrwdcleaner(rs.getDouble("rcfrwdcleaner"));
		frpYield.setRcprimcell(rs.getDouble("rcprimcell"));
		frpYield.setRcseccell(rs.getDouble("rcseccell"));
		frpYield.setRcfsdclarifier(rs.getDouble("rcfsdclarifier"));
		frpYield.setAshdww(rs.getDouble("ashdww"));
		frpYield.setAshpupler(rs.getDouble("ashpupler"));
		frpYield.setAshtertiarypress(rs.getDouble("ashtertiarypress"));
		
		return frpYield;
	}

	

}

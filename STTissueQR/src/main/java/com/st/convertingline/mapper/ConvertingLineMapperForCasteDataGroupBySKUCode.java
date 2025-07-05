/**
 *Nov 16, 2017
 *ConvertingLineMapperForCasteDataGroupBySKUCode.java
 * TODO
 *com.st.convertingline.mapper
 *ConvertingLineMapperForCasteDataGroupBySKUCode.java
 *Roshan Lal Tailor
 */
package com.st.convertingline.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.st.convertingline.model.ConvertingLine;

/**
 * @author roshan
 *
 */
public class ConvertingLineMapperForCasteDataGroupBySKUCode   implements RowMapper<ConvertingLine> {

	/* (non-Javadoc)
	 * @see org.springframework.jdbc.core.RowMapper#mapRow(java.sql.ResultSet, int)
	 */
	@Override
	public ConvertingLine mapRow(ResultSet rs, int arg1) throws SQLException {
		ConvertingLine reel=new ConvertingLine();
		
		reel.setSkucode(rs.getString("skucode"));
		reel.setJanuary(rs.getDouble("January"));
		reel.setFebruary(rs.getDouble("February"));
		reel.setMarch(rs.getDouble("March"));
		reel.setApril(rs.getDouble("April"));
		reel.setMay(rs.getDouble("May"));
		reel.setJune(rs.getDouble("June"));
		reel.setJuly(rs.getDouble("July"));
		reel.setAugust(rs.getDouble("August"));
		reel.setSeptember(rs.getDouble("September"));
		reel.setOctober(rs.getDouble("October"));
		reel.setNovember(rs.getDouble("November"));
		reel.setDecember(rs.getDouble("December"));
		
		//To Set The By Default Parameters
		double defaultV=0;
		reel.setJanuaryqty(defaultV);reel.setFebruaryqty(defaultV);reel.setMarchqty(defaultV);reel.setAprilqty(defaultV);reel.setMayqty(defaultV);reel.setJuneqty(defaultV);
		reel.setJulyqty(defaultV);reel.setAugustqty(defaultV);reel.setSeptemberqty(defaultV);reel.setOctoberqty(defaultV);reel.setNovemberqty(defaultV);reel.setDecemberqty(defaultV);

		reel.setJanuaryorderedpo(defaultV);reel.setFebruaryorderedpo(defaultV);reel.setMarchorderedpo(defaultV);reel.setAprilorderedpo(defaultV);reel.setMayorderedpo(defaultV);reel.setJuneorderedpo(defaultV);
		reel.setJulyorderedpo(defaultV);reel.setAugustorderedpo(defaultV);reel.setSeptemberorderedpo(defaultV);reel.setOctoberorderedpo(defaultV);reel.setNovemberorderedpo(defaultV);reel.setDecemberorderedpo(defaultV);

		return reel;
	}

}

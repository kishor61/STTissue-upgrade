/**
 * 
 */
package com.st.utilitykpimaster.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.st.utilitykpimaster.model.KpiRecordableDate;

/**
 * @author sbora
 *
 */
public class KpiRecordableDateMapper implements RowMapper<KpiRecordableDate> {

	/* (non-Javadoc)
	 * @see org.springframework.jdbc.core.RowMapper#mapRow(java.sql.ResultSet, int)
	 */
	@Override
	public KpiRecordableDate mapRow(ResultSet rs, int arg1)
			throws SQLException {

		KpiRecordableDate kpiRecordableDate=new KpiRecordableDate();
		kpiRecordableDate.setId(rs.getInt("ID"));
		kpiRecordableDate.setDate(rs.getDate("Date"));
		kpiRecordableDate.setRemarks(rs.getString("Remarks"));
		return kpiRecordableDate;
	}

}

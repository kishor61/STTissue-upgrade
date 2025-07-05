/**
 *Dec 21, 2017
 *GradeTargetPM5Mapper.java
 * TODO
 *com.st.qualitypm5.mapper
 *GradeTargetPM5Mapper.java
 *Roshan Lal Tailor
 */
package com.st.qualitypm5.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.st.common.Columns;
import com.st.qualitypm5.model.GradeTargetPM5;

/**
 * @author roshan
 *
 */
public class GradeTargetPM5Mapper implements RowMapper<GradeTargetPM5>{

	@Override
	public GradeTargetPM5 mapRow(ResultSet rs, int arg1) throws SQLException {
		GradeTargetPM5 gradeTarget=new GradeTargetPM5();

		gradeTarget.setGradeCode(rs.getString(Columns.COL_01));
		gradeTarget.setPhysicalProperty(rs.getString(Columns.COL_02));
		gradeTarget.setRejectMin(rs.getDouble(Columns.COL_03));
		gradeTarget.setControlMin(rs.getDouble(Columns.COL_04));
		gradeTarget.setTarget(rs.getDouble(Columns.COL_05));
		gradeTarget.setControlMax(rs.getDouble(Columns.COL_06));
		gradeTarget.setRejectMax(rs.getDouble(Columns.COL_07));
		gradeTarget.setNote(rs.getString(Columns.COL_08));
		return gradeTarget;
		
	}

}

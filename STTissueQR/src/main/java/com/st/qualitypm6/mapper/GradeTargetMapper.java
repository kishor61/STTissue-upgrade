package com.st.qualitypm6.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.st.common.Columns;
import com.st.qualitypm6.model.GradeTarget;

public class GradeTargetMapper implements RowMapper<GradeTarget> {

	@Override
	public GradeTarget mapRow(ResultSet rs, int arg1) throws SQLException {
		GradeTarget gradeTarget=new GradeTarget();

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

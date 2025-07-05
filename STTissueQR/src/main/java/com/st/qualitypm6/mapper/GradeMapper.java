package com.st.qualitypm6.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.st.common.Columns;
import com.st.qualitypm6.model.Grade;

public class GradeMapper implements RowMapper<Grade> {

	@Override
	public Grade mapRow(ResultSet rs, int arg1) throws SQLException {
		Grade grade=new Grade();
		grade.setGradeCode(rs.getString(Columns.COL_01));
		grade.setRevisionDate(rs.getDate(Columns.COL_02));
		grade.setTmNo(rs.getString(Columns.COL_03));
		grade.setDescription(rs.getString(Columns.COL_04));
		grade.setCustomerGrade(rs.getString(Columns.COL_05));
		grade.setCustomer(rs.getString(Columns.COL_06));
		grade.setTissueApproval(rs.getString(Columns.COL_07));
		grade.setCustomerApproval(rs.getString(Columns.COL_08));
		grade.setNotes(rs.getString(Columns.COL_09));
		grade.setVisualStandard(rs.getString(Columns.COL_10));
		grade.setTrimMin(rs.getString(Columns.COL_11));
		grade.setTrimTarget(rs.getString(Columns.COL_12));
		grade.setTrimMax(rs.getString(Columns.COL_13));
		grade.setDiameterMin(rs.getString(Columns.COL_14));
		grade.setDiameterTarget(rs.getString(Columns.COL_15));
		grade.setDiameterMax(rs.getString(Columns.COL_16));
		grade.setBreakMin(rs.getString(Columns.COL_17));
		grade.setBreakTarget(rs.getString(Columns.COL_18));
		grade.setBreakMax(rs.getString(Columns.COL_19));
		grade.setSpecialInstruction(rs.getString(Columns.COL_20));
				
		return grade;
	}

}

/**
 *Jul 9, 2015
 *WastePaperBaleInventoryGradeMapper.java
 * TODO
 *com.st.wastepaperunloadbale.mapper
 *WastePaperBaleInventoryGradeMapper.java
 *Sunil Singh Bora
 */
package com.st.wastepaper.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.st.wastepaper.comman.WastePaperUnloadBaleComman;
import com.st.wastepaper.model.WastePaperBaleInventory;


/**
 * @author roshan
 *
 */
public class WastePaperBaleInventoryGradeMapper implements RowMapper<WastePaperBaleInventory> {

	@Override
	public WastePaperBaleInventory mapRow(ResultSet rs, int arg1)
			throws SQLException {
		WastePaperBaleInventory wastePaperBaleInventory =new WastePaperBaleInventory();
		wastePaperBaleInventory.setGradeCode(rs.getLong("GradeCode"));
		wastePaperBaleInventory.setGrade(rs.getString("Grade"));
		wastePaperBaleInventory.setGlDesc(rs.getString("GLDesc"));
		wastePaperBaleInventory.setDescNotes(rs.getString("DescNotes"));
		return wastePaperBaleInventory;
	}

}

package com.st.qualitypm6.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.stereotype.Repository;

import com.st.common.Columns;
import com.st.common.CommonProperties;
import com.st.qualitypm6.mapper.GradeMapper;
import com.st.qualitypm6.model.Grade;
@Repository
public class GradeDaoImp implements GradeDao {
	private static final Logger logger=LoggerFactory.getLogger(GradeDaoImp.class);
	@Autowired
	private DataSource dataSource;
	
	@Override
	public void save(final Grade grade) throws Exception {
			String sql="insert into [grade]("
					+"[GradeCode],"
					+"[RevisionDate],"
					+"[TMNo],"
					+"[Description],"
					+"[CustomerGrade],"
					+"[Customer],"
					+"[TissueApproval],"
					+"[CustomerApproval],"
					+"[Notes],"
					+"[VisualStandard],"
					+"[TrimMin],"
					+"[TrimTarget],"
					+"[TrimMax],"
					+"[DiameterMin],"
					+"[DiameterTarget],"
					+"[DiameterMax],"
					+"[BreakMin],"
					+"[BreakTarget],"
					+"[BreakMax],"
					+"[SpecialInstruction]) "
				+ " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
			jdbcTemplate.execute(sql, new PreparedStatementCallback<Boolean>() {

				@Override
				public Boolean doInPreparedStatement(PreparedStatement statement)
						throws SQLException, DataAccessException {
					statement.setString(Columns.COL_01, grade.getGradeCode().trim());
					statement.setDate(Columns.COL_02, new Date(grade.getRevisionDate().getTime()));
					statement.setString(Columns.COL_03, grade.getTmNo());
					statement.setString(Columns.COL_04, grade.getDescription());
					statement.setString(Columns.COL_05, grade.getCustomerGrade());
					statement.setString(Columns.COL_06, grade.getCustomer());
					statement.setString(Columns.COL_07, grade.getTissueApproval());
					statement.setString(Columns.COL_08, grade.getCustomerApproval());
					statement.setString(Columns.COL_09, grade.getNotes());
					statement.setString(Columns.COL_10, grade.getVisualStandard());
					statement.setString(Columns.COL_11, grade.getTrimMin());
					statement.setString(Columns.COL_12, grade.getTrimTarget());
					statement.setString(Columns.COL_13, grade.getTrimMax());
					statement.setString(Columns.COL_14, grade.getDiameterMin());
					statement.setString(Columns.COL_15, grade.getDiameterTarget());
					statement.setString(Columns.COL_16, grade.getDiameterMax());
					statement.setString(Columns.COL_17, grade.getBreakMin());
					statement.setString(Columns.COL_18, grade.getBreakTarget());
					statement.setString(Columns.COL_19, grade.getBreakMax());
					statement.setString(Columns.COL_20, grade.getSpecialInstruction());
					
					return statement.execute();
				}
			});
			
		
	}

	@Override
	public int totalGrade() {

		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		String sql="SELECT COUNT(GradeCode) FROM grade";
		int total=jdbcTemplate.queryForObject(sql, Integer.class);
		
		return total;
				
	}

	@Override
	public List<Grade> getGrades(int page) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		String sql="select * from grade order by GradeCode";
		List<Grade> grades=jdbcTemplate.query(sql, new GradeMapper());
		
		int sindex=page*CommonProperties.DATA_PER_PAGE;
		int eindex=sindex+CommonProperties.DATA_PER_PAGE;
		if(grades.size()>sindex && grades.size()<eindex){
			return grades.subList(sindex, grades.size());
		}else{
			return grades.subList(sindex, eindex);
		}
		
	}

	@Override
	public List<Grade> getGrades() {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		String sql="select * from grade order by GradeCode";
		List<Grade> grades=jdbcTemplate.query(sql, new GradeMapper());
		return grades;
	}

	@Override
	public List<Map<String, Object>> getGradesProperties() {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		String sql="select * from gradePhysicalProperties order by PhysicalPropertyID";
		List<Map<String, Object>> grades=jdbcTemplate.queryForList(sql);
		return grades;
	}

	@Override
	public Grade getGrade(String gradeCode) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		String sql="select * from [grade] where [GradeCode]=?";
		Grade grade=null;
		try {
			grade=jdbcTemplate.queryForObject(sql, new Object[]{gradeCode}, new GradeMapper());
		} catch (Exception e) {
			logger.error("Grade Code exist:"+e.getMessage());
		}
		return grade;
	}

	@Override
	public void update(final Grade grade) throws Exception {
		String sql="update [grade] SET "
				+"[RevisionDate]=?,"
				+"[TMNo]=?,"
				+"[Description]=?,"
				+"[CustomerGrade]=?,"
				+"[Customer]=?,"
				+"[TissueApproval]=?,"
				+"[CustomerApproval]=?,"
				+"[Notes]=?,"
				+"[VisualStandard]=?,"
				+"[TrimMin]=?,"
				+"[TrimTarget]=?,"
				+"[TrimMax]=?,"
				+"[DiameterMin]=?,"
				+"[DiameterTarget]=?,"
				+"[DiameterMax]=?,"
				+"[BreakMin]=?,"
				+"[BreakTarget]=?,"
				+"[BreakMax]=?,"
				+"[SpecialInstruction]=? "
			+ " where [GradeCode]=?";
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		jdbcTemplate.execute(sql, new PreparedStatementCallback<Boolean>() {

			@Override
			public Boolean doInPreparedStatement(PreparedStatement statement)
					throws SQLException, DataAccessException {
				statement.setDate(Columns.COL_01, new Date(grade.getRevisionDate().getTime()));
				statement.setString(Columns.COL_02, grade.getTmNo());
				statement.setString(Columns.COL_03, grade.getDescription());
				statement.setString(Columns.COL_04, grade.getCustomerGrade());
				statement.setString(Columns.COL_05, grade.getCustomer());
				statement.setString(Columns.COL_06, grade.getTissueApproval());
				statement.setString(Columns.COL_07, grade.getCustomerApproval());
				statement.setString(Columns.COL_08, grade.getNotes());
				statement.setString(Columns.COL_09, grade.getVisualStandard());
				statement.setString(Columns.COL_10, grade.getTrimMin());
				statement.setString(Columns.COL_11, grade.getTrimTarget());
				statement.setString(Columns.COL_12, grade.getTrimMax());
				statement.setString(Columns.COL_13, grade.getDiameterMin());
				statement.setString(Columns.COL_14, grade.getDiameterTarget());
				statement.setString(Columns.COL_15, grade.getDiameterMax());
				statement.setString(Columns.COL_16, grade.getBreakMin());
				statement.setString(Columns.COL_17, grade.getBreakTarget());
				statement.setString(Columns.COL_18, grade.getBreakMax());
				statement.setString(Columns.COL_19, grade.getSpecialInstruction());
				
				statement.setString(Columns.COL_20, grade.getGradeCode().trim());
				
				return statement.execute();
			}
		});
	}


}

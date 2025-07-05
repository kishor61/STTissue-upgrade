/**
 * 
 */
package com.st.frpprojectionJon.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.st.common.CommonUtil;
import com.st.frpprojection.mapper.FrpProjectionMapper;
import com.st.frpprojection.model.FrpProjection;
import com.st.frpprojection.model.ProjectionReminder;
import com.st.tracker.model.ProjectionData;
import com.st.tracker.model.PurchaseHeaderDetail;

/**
 * @author sbora
 *
 */
@Repository
public class FrpProjectionJonDaoImp implements FrpProjectionJonDao{

	@Autowired
	private DataSource dataSource;
	@Autowired
	@Qualifier("dataSourceTracker")
	private DataSource dataSourceT;

	
	@Override
	public int saveFormula(final FrpProjection frpProjection) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		KeyHolder holder=new GeneratedKeyHolder();
		
		final String sql="insert into [frpProjectionJon]("
				+ "[Type],"
				+ "[Type2],"
				+ "[Input],"
				+ "[Occ],"
				+ "[Dlk],"
				+ "[SowAndMail],"
				+ "[Growndwood],"
				+ "[Others],"
				+ "[MwlAndSwl],"
				+ "[Sow],"
				+ "[Cbs],"
				+ "[Remarks],"
				+ "[OccMinR],"
				+ "[OccMinC],"
				+ "[OccTarget],"
				+ "[OccMaxC],"
				+ "[OccMaxR],"
				+ "[DlkMinR],"
				+ "[DlkMinC],"
				+ "[DlkTarget],"
				+ "[DlkMaxC],"
				+ "[DlkMaxR],"
				+ "[SowAndMailMinR],"
				+ "[SowAndMailMinC],"
				+ "[SowAndMailTarget],"
				+ "[SowAndMailMaxC],"
				+ "[SowAndMailMaxR],"
				+ "[GrowndwoodMinR],"
				+ "[GrowndwoodMinC],"
				+ "[GrowndwoodTarget],"
				+ "[GrowndwoodMaxC],"
				+ "[GrowndwoodMaxR],"
				+ "[MwlAndSwlMinR],"
				+ "[MwlAndSwlMinC],"
				+ "[MwlAndSwlTarget],"
				+ "[MwlAndSwlMaxC],"
				+ "[MwlAndSwlMaxR],"
				+ "[SowMinR],"
				+ "[SowMinC],"
				+ "[SowTarget],"
				+ "[SowMaxC],"
				+ "[SowMaxR],"
				+ "[CbsMinR],"
				+ "[CbsMinC],"
				+ "[CbsTarget],"
				+ "[CbsMaxC],"
				+ "[CbsMaxR],"
				+ "[OthersMinR],"
				+ "[OthersMinC],"
				+ "[OthersTarget],"
				+ "[OthersMaxC],"
				+ "[OthersMaxR],"
				+ "[MixedPaper],"
				+ "[MixedPaperMinR],"
				+ "[MixedPaperMinC],"
				+ "[MixedPaperTarget],"
				+ "[MixedPaperMaxC],"
				+ "[MixedPaperMaxR],"
				+ "[CutBook],"
				+ "[CutBookMinR],"
				+ "[CutBookMinC],"
				+ "[CutBookTarget],"
				+ "[CutBookMaxC],"
				+ "[CutBookMaxR],"
				+ "[hw],"
				+ "[hwMinR],"
				+ "[hwMinC],"
				+ "[hwTarget],"
				+ "[hwMaxC],"
				+ "[hwMaxR],"
				+ "[unprtsbs],"
				+ "[unprtsbsMinR],"
				+ "[unprtsbsMinC],"
				+ "[unprtsbsTarget],"
				+ "[unprtsbsMaxC],"
				+ "[unprtsbsMaxR] "

				
				+ ") values(?,?,?,?,?,?,?,?,?,?,?,?,"
				+ "?,?,?,?,?,?,?,?,?,?,?,?,"
				+ "?,?,?,?,?,?,?,?,?,?,?,?,"
				+ "?,?,?,?,?,?,?,?,?,?,?,?,"
				+ "?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		
		jdbcTemplate.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection arg0)
					throws SQLException {
				PreparedStatement statement=arg0.prepareStatement(sql, new String[]{"ID"});
				statement.setString(1, frpProjection.getType());
				statement.setString(2, frpProjection.getType2());
				statement.setDouble(3, frpProjection.getInput());
				statement.setDouble(4, frpProjection.getOcc());
				statement.setDouble(5, frpProjection.getDlk());
				statement.setDouble(6, frpProjection.getSowAndMail());
				statement.setDouble(7, frpProjection.getGrowndwood());
				statement.setDouble(8, frpProjection.getOthers());
				statement.setDouble(9, frpProjection.getMwlAndSwl());
				statement.setDouble(10, frpProjection.getSow());
				statement.setDouble(11, frpProjection.getCbs());
				statement.setString(12, frpProjection.getRemarks());
				// New Fields
				statement.setDouble(13, frpProjection.getOccMinR());
				statement.setDouble(14, frpProjection.getOccMinC());
				statement.setDouble(15, frpProjection.getOccTarget());
				statement.setDouble(16, frpProjection.getOccMaxC());
				statement.setDouble(17, frpProjection.getOccMaxR());
				statement.setDouble(18, frpProjection.getDlkMinR());
				statement.setDouble(19, frpProjection.getDlkMinC());
				statement.setDouble(20, frpProjection.getDlkTarget());
				statement.setDouble(21, frpProjection.getDlkMaxC());
				statement.setDouble(22, frpProjection.getDlkMaxR());
				statement.setDouble(23, frpProjection.getSowAndMailMinR());
				statement.setDouble(24, frpProjection.getSowAndMailMinC());
				statement.setDouble(25, frpProjection.getSowAndMailTarget());
				statement.setDouble(26, frpProjection.getSowAndMailMaxC());
				statement.setDouble(27, frpProjection.getSowAndMailMaxR());
				statement.setDouble(28, frpProjection.getGrowndwoodMinR());
				statement.setDouble(29, frpProjection.getGrowndwoodMinC());
				statement.setDouble(30, frpProjection.getGrowndwoodTarget());
				statement.setDouble(31, frpProjection.getGrowndwoodMaxC());
				statement.setDouble(32, frpProjection.getGrowndwoodMaxR());
				statement.setDouble(33, frpProjection.getMwlAndSwlMinR());
				statement.setDouble(34, frpProjection.getMwlAndSwlMinC());
				statement.setDouble(35, frpProjection.getMwlAndSwlTarget());
				statement.setDouble(36, frpProjection.getMwlAndSwlMaxC());
				statement.setDouble(37, frpProjection.getMwlAndSwlMaxR());
				statement.setDouble(38, frpProjection.getSowMinR());
				statement.setDouble(39, frpProjection.getSowMinC());
				statement.setDouble(40, frpProjection.getSowTarget());
				statement.setDouble(41, frpProjection.getSowMaxC());
				statement.setDouble(42, frpProjection.getSowMaxR());
				statement.setDouble(43, frpProjection.getCbsMinR());
				statement.setDouble(44, frpProjection.getCbsMinC());
				statement.setDouble(45, frpProjection.getCbsTarget());
				statement.setDouble(46, frpProjection.getCbsMaxC());
				statement.setDouble(47, frpProjection.getCbsMaxR());
				statement.setDouble(48, frpProjection.getOthersMinR());
				statement.setDouble(49, frpProjection.getOthersMinC());
				statement.setDouble(50, frpProjection.getOthersTarget());
				statement.setDouble(51, frpProjection.getOthersMaxC());
				statement.setDouble(52, frpProjection.getOthersMaxR());
				
				statement.setDouble(53, frpProjection.getMixedPaper());
				statement.setDouble(54, frpProjection.getMixedPaperMinR());
				statement.setDouble(55, frpProjection.getMixedPaperMinC());
				statement.setDouble(56, frpProjection.getMixedPaperTarget());
				statement.setDouble(57, frpProjection.getMixedPaperMaxC());
				statement.setDouble(58, frpProjection.getMixedPaperMaxR());
				

				statement.setDouble(59, frpProjection.getCutBook());
				statement.setDouble(60, frpProjection.getCutBookMinR());
				statement.setDouble(61, frpProjection.getCutBookMinC());
				statement.setDouble(62, frpProjection.getCutBookTarget());
				statement.setDouble(63, frpProjection.getCutBookMaxC());
				statement.setDouble(64, frpProjection.getCutBookMaxR());
				
				statement.setDouble(65, frpProjection.getHw());
				statement.setDouble(66, frpProjection.getHwMinR());
				statement.setDouble(67, frpProjection.getHwMinC());
				statement.setDouble(68, frpProjection.getHwTarget());
				statement.setDouble(69, frpProjection.getHwMaxC());
				statement.setDouble(70, frpProjection.getHwMaxR());
				
				
				statement.setDouble(71, frpProjection.getUnprtsbs());
				statement.setDouble(72, frpProjection.getUnprtsbsMinR());
				statement.setDouble(73, frpProjection.getUnprtsbsMinC());
				statement.setDouble(74, frpProjection.getUnprtsbsTarget());
				statement.setDouble(75, frpProjection.getUnprtsbsMaxC());
				statement.setDouble(76, frpProjection.getUnprtsbsMaxR());
				
				return statement;
			}
		},holder);
		
		return holder.getKey().intValue();
	}

	/* (non-Javadoc)
	 * @see com.st.frpprojection.dao.FrpProjectionDao#update(com.st.frpprojection.model.FrpProjection)
	 */
	@Override
	public void updateFormula(final FrpProjection frpProjection) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
			final String sql="update [frpProjectionJon] set "
				+ "[Type]=?,"
				+ "[Type2]=?,"
				+ "[Input]=?,"
				+ "[Occ]=?,"
				+ "[Dlk]=?,"
				+ "[SowAndMail]=?,"
				+ "[Growndwood]=?,"
				+ "[Others]=?,"
				+ "[MwlAndSwl]=?,"
				+ "[Sow]=?,"
				+ "[Cbs]=?,"
				+ "[Remarks]=?,"
				+ "[OccMinR]=?,"
				+ "[OccMinC]=?,"
				+ "[OccTarget]=?,"
				+ "[OccMaxC]=?,"
				+ "[OccMaxR]=?,"
				+ "[DlkMinR]=?,"
				+ "[DlkMinC]=?,"
				+ "[DlkTarget]=?,"
				+ "[DlkMaxC]=?,"
				+ "[DlkMaxR]=?,"
				+ "[SowAndMailMinR]=?,"
				+ "[SowAndMailMinC]=?,"
				+ "[SowAndMailTarget]=?,"
				+ "[SowAndMailMaxC]=?,"
				+ "[SowAndMailMaxR]=?,"
				+ "[GrowndwoodMinR]=?,"
				+ "[GrowndwoodMinC]=?,"
				+ "[GrowndwoodTarget]=?,"
				+ "[GrowndwoodMaxC]=?,"
				+ "[GrowndwoodMaxR]=?,"
				+ "[MwlAndSwlMinR]=?,"
				+ "[MwlAndSwlMinC]=?,"
				+ "[MwlAndSwlTarget]=?,"
				+ "[MwlAndSwlMaxC]=?,"
				+ "[MwlAndSwlMaxR]=?,"
				+ "[SowMinR]=?,"
				+ "[SowMinC]=?,"
				+ "[SowTarget]=?,"
				+ "[SowMaxC]=?,"
				+ "[SowMaxR]=?,"
				+ "[CbsMinR]=?,"
				+ "[CbsMinC]=?,"
				+ "[CbsTarget]=?,"
				+ "[CbsMaxC]=?,"
				+ "[CbsMaxR]=?,"
				+ "[OthersMinR]=?,"
				+ "[OthersMinC]=?,"
				+ "[OthersTarget]=?,"
				+ "[OthersMaxC]=?,"
				+ "[OthersMaxR]=?,"
				
				+ "[MixedPaper]=?,"
				+ "[MixedPaperMinR]=?,"
				+ "[MixedPaperMinC]=?,"
				+ "[MixedPaperTarget]=?,"
				+ "[MixedPaperMaxC]=?,"
				+ "[MixedPaperMaxR]=?,"

				+ "[CutBook]=?,"
				+ "[CutBookMinR]=?,"
				+ "[CutBookMinC]=?,"
				+ "[CutBookTarget]=?,"
				+ "[CutBookMaxC]=?,"
				+ "[CutBookMaxR]=?,"
				+ "[hw]=?,"
				+ "[hwMinR]=?,"
				+ "[hwMinC]=?,"
				+ "[hwTarget]=?,"
				+ "[hwMaxC]=?,"
				+ "[hwMaxR]=?,"
				+ "[unprtsbs]=?,"
				+ "[unprtsbsMinR]=?,"
				+ "[unprtsbsMinC]=?,"
				+ "[unprtsbsTarget]=?,"
				+ "[unprtsbsMaxC]=?,"
				+ "[unprtsbsMaxR]=? "
				
				+ " where [ID]=?";
		
		jdbcTemplate.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection arg0)
					throws SQLException {
				PreparedStatement statement=arg0.prepareStatement(sql);
				statement.setString(1, frpProjection.getType());
				statement.setString(2, frpProjection.getType2());
				statement.setDouble(3, frpProjection.getInput());
				statement.setDouble(4, frpProjection.getOcc());
				statement.setDouble(5, frpProjection.getDlk());
				statement.setDouble(6, frpProjection.getSowAndMail());
				statement.setDouble(7, frpProjection.getGrowndwood());
				statement.setDouble(8, frpProjection.getOthers());
				statement.setDouble(9, frpProjection.getMwlAndSwl());
				statement.setDouble(10, frpProjection.getSow());
				statement.setDouble(11, frpProjection.getCbs());
				statement.setString(12, frpProjection.getRemarks());
				// New Fields
				statement.setDouble(13, frpProjection.getOccMinR());
				statement.setDouble(14, frpProjection.getOccMinC());
				statement.setDouble(15, frpProjection.getOccTarget());
				statement.setDouble(16, frpProjection.getOccMaxC());
				statement.setDouble(17, frpProjection.getOccMaxR());
				statement.setDouble(18, frpProjection.getDlkMinR());
				statement.setDouble(19, frpProjection.getDlkMinC());
				statement.setDouble(20, frpProjection.getDlkTarget());
				statement.setDouble(21, frpProjection.getDlkMaxC());
				statement.setDouble(22, frpProjection.getDlkMaxR());
				statement.setDouble(23, frpProjection.getSowAndMailMinR());
				statement.setDouble(24, frpProjection.getSowAndMailMinC());
				statement.setDouble(25, frpProjection.getSowAndMailTarget());
				statement.setDouble(26, frpProjection.getSowAndMailMaxC());
				statement.setDouble(27, frpProjection.getSowAndMailMaxR());
				statement.setDouble(28, frpProjection.getGrowndwoodMinR());
				statement.setDouble(29, frpProjection.getGrowndwoodMinC());
				statement.setDouble(30, frpProjection.getGrowndwoodTarget());
				statement.setDouble(31, frpProjection.getGrowndwoodMaxC());
				statement.setDouble(32, frpProjection.getGrowndwoodMaxR());
				statement.setDouble(33, frpProjection.getMwlAndSwlMinR());
				statement.setDouble(34, frpProjection.getMwlAndSwlMinC());
				statement.setDouble(35, frpProjection.getMwlAndSwlTarget());
				statement.setDouble(36, frpProjection.getMwlAndSwlMaxC());
				statement.setDouble(37, frpProjection.getMwlAndSwlMaxR());
				statement.setDouble(38, frpProjection.getSowMinR());
				statement.setDouble(39, frpProjection.getSowMinC());
				statement.setDouble(40, frpProjection.getSowTarget());
				statement.setDouble(41, frpProjection.getSowMaxC());
				statement.setDouble(42, frpProjection.getSowMaxR());
				statement.setDouble(43, frpProjection.getCbsMinR());
				statement.setDouble(44, frpProjection.getCbsMinC());
				statement.setDouble(45, frpProjection.getCbsTarget());
				statement.setDouble(46, frpProjection.getCbsMaxC());
				statement.setDouble(47, frpProjection.getCbsMaxR());
				statement.setDouble(48, frpProjection.getOthersMinR());
				statement.setDouble(49, frpProjection.getOthersMinC());
				statement.setDouble(50, frpProjection.getOthersTarget());
				statement.setDouble(51, frpProjection.getOthersMaxC());
				statement.setDouble(52, frpProjection.getOthersMaxR());
				
				statement.setDouble(53, frpProjection.getMixedPaper());
				statement.setDouble(54, frpProjection.getMixedPaperMinR());
				statement.setDouble(55, frpProjection.getMixedPaperMinC());
				statement.setDouble(56, frpProjection.getMixedPaperTarget());
				statement.setDouble(57, frpProjection.getMixedPaperMaxC());
				statement.setDouble(58, frpProjection.getMixedPaperMaxR());
				
				
				statement.setDouble(59, frpProjection.getCutBook());
				statement.setDouble(60, frpProjection.getCutBookMinR());
				statement.setDouble(61, frpProjection.getCutBookMinC());
				statement.setDouble(62, frpProjection.getCutBookTarget());
				statement.setDouble(63, frpProjection.getCutBookMaxC());
				statement.setDouble(64, frpProjection.getCutBookMaxR());
				
				statement.setDouble(65, frpProjection.getHw());
				statement.setDouble(66, frpProjection.getHwMinR());
				statement.setDouble(67, frpProjection.getHwMinC());
				statement.setDouble(68, frpProjection.getHwTarget());
				statement.setDouble(69, frpProjection.getHwMaxC());
				statement.setDouble(70, frpProjection.getHwMaxR());
				
				statement.setDouble(71, frpProjection.getUnprtsbs());
				statement.setDouble(72, frpProjection.getUnprtsbsMinR());
				statement.setDouble(73, frpProjection.getUnprtsbsMinC());
				statement.setDouble(74, frpProjection.getUnprtsbsTarget());
				statement.setDouble(75, frpProjection.getUnprtsbsMaxC());
				statement.setDouble(76, frpProjection.getUnprtsbsMaxR());
				
				statement.setInt(77, frpProjection.getId());
				return statement;
			}
		});
	}

	
	@Override
	public List<FrpProjection> getProjectionFormulae() {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		String sql="select * from [frpProjectionJon] order by [Type] desc";
		List<FrpProjection> projections=jdbcTemplate.query(sql,new FrpProjectionMapper());
		return projections;
	}

	
	@Override
	public FrpProjection getProjectionFormula(int id) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		String sql="select * from [frpProjectionJon] where [ID]=?";
		FrpProjection projection=jdbcTemplate.queryForObject(sql,new Object[]{id}, new FrpProjectionMapper());
		return projection;
	}

	
	@Override
	public List<Integer> getGradeIds() {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		String sql="select [GradeCode] from [tlkpGrade] ";
		/*if(type!=null){
			if(type.equalsIgnoreCase("WH")){
				sql+= "where ([Type]='W' or [Type]='WK') ";
			}else if(type.equalsIgnoreCase("KF")){
				sql+= "where ([Type]='K' or [Type]='WK') ";
			}
		}*/
		sql+= " order by [GradeCode]";
		
		List<Integer> ids=jdbcTemplate.query(sql, new RowMapper<Integer>() {

			@Override
			public Integer mapRow(ResultSet rs, int arg1) throws SQLException {
				return rs.getInt(1);
			}
		
		});
		
	//	System.out.println("Grade="+ids);
		
		//ids.add(11);//HW
		//ids.add(14);//Unprt SBS
		return ids;
	}

	/* (non-Javadoc)
	 * @see com.st.frpprojection.dao.FrpProjectionDao#getProjectionFormula(java.util.List)
	 */
	@Override
	public List<FrpProjection> getProjectionFormula(List<String> productIds) {
		NamedParameterJdbcTemplate jdbcTemplate=new NamedParameterJdbcTemplate(dataSource);
		MapSqlParameterSource parameterSource=new MapSqlParameterSource();
		parameterSource.addValue("ids", productIds);
		
		String sql="select * from [frpProjectionJon] where [ID] in(:ids)";
		
		List<FrpProjection> projections=jdbcTemplate.query(sql, parameterSource, new FrpProjectionMapper());
		
		return projections;
	}

	/* (non-Javadoc)
	 * @see com.st.frpprojection.dao.FrpProjectionDao#getProjectionFormulae(java.lang.String)
	 */
	@Override
	public List<FrpProjection> getProjectionFormulae(String type) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		String sql="select * from [frpProjectionJon] where [Type]=? order by [Type] desc";
		List<FrpProjection> projections=jdbcTemplate.query(sql,new Object[]{type},new FrpProjectionMapper());
		return projections;
	}

	/* (non-Javadoc)
	 * @see com.st.frpprojection.dao.FrpProjectionDao#delete(int)
	 */
	@Override
	public void delete(int id) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		String sql="delete from [frpProjectionJon] where [ID]=? ";
		jdbcTemplate.update(sql,new Object[]{id});
	}

	/* (non-Javadoc)
	 * @see com.st.frpprojection.dao.FrpProjectionDao#saveReminders(java.util.List)
	 */
	@Override
	public void saveReminders(final List<ProjectionReminder> reminders) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		
		String deleteSql="delete from [frpProjectionReminder]";
		
		jdbcTemplate.update(deleteSql);
		
		String sql="insert into [frpProjectionReminder]([formulaID],[Date]) values(?,?)";
		
		jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement rs, int arg1) throws SQLException {
				ProjectionReminder reminder=reminders.get(arg1);
				rs.setLong(1, reminder.getFormulaId());
				rs.setTimestamp(2, new Timestamp(reminder.getDate().getTime()));
			}
			
			@Override
			public int getBatchSize() {
				return reminders.size();
			}
		});
		
		
		
	}

	/* (non-Javadoc)
	 * @see com.st.frpprojection.dao.FrpProjectionDao#getProjectionReminder()
	 */
	@Override
	public List<Map<String, Object>> getProjectionReminder(Date date) {
		
		
		
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		
		String sql="select Type,Type2 from frpProjectionJon where ID=(SELECT formulaID  FROM frpProjectionReminder where [Date]=?)";
		
		List<Map<String, Object>> maps=jdbcTemplate.queryForList(sql, new Object[]{new Timestamp(date.getTime())});
		
		
		
		return maps;
	}

	/* (non-Javadoc)
	 * @see com.st.frpprojectionJon.dao.FrpProjectionJonDao#getProjectionData(java.util.Date, java.util.Date, java.util.List)
	 */
	@Override
	public List<ProjectionData> getProjectionData(Date sdate, Date edate, List<Integer> gradeIds) {
		
		
		NamedParameterJdbcTemplate jdbcTemplate=new NamedParameterJdbcTemplate(dataSourceT);
		
		Date date=CommonUtil.getDateTime(edate, new Date());
		
		
		// Date fromfrpprojectionreport
		MapSqlParameterSource parameterSource=new MapSqlParameterSource();
		parameterSource.addValue("date", new Timestamp(date.getTime()));
		parameterSource.addValue("grades", gradeIds);
		
		String sql="SELECT "
				+ "sum(b.[BaleWeight])/2000 AS [Weight],  "
				+ "b.[GradeCode],  "
				+ "g.[Grade] "
				+ "FROM tblBaleInventory AS b, tlkpGrade AS g "
				+ "WHERE "
				//+ "b.[WhseLocation] not like '%PB%' AND  b.[WhseLocation] not like '%WL%' "
				//+"AND "
				+ "	b.[UnloadDate]<=:date "				
				+ "And "
				+ "b.[GradeCode]=g.[GradeCode] "
				+ "And "
				+ " b.[ConsumedDate]is  Null "
				+ " And "
				+ "  b.[GradeCode] in (:grades) "
				+ " GROUP BY b.[GradeCode], g.[Grade] "
				+ " order by b.[GradeCode]";
		
				
		List<ProjectionData> proDatas=jdbcTemplate.query(sql,parameterSource,new RowMapper<ProjectionData>() {

			@Override
			public ProjectionData mapRow(ResultSet rs, int arg1)
					throws SQLException {
					ProjectionData projectionData=new ProjectionData();
					projectionData.setWeight(rs.getDouble("Weight"));
					projectionData.setGradeCode(rs.getInt("GradeCode"));
					projectionData.setGrade(rs.getString("Grade"));
				return projectionData;
			}
		});
		
		
		
		List<ProjectionData> projections=new ArrayList<ProjectionData>(proDatas);
		
		proDatas.clear();
		
		List<ProjectionData> projectionDatas=new ArrayList<ProjectionData>();
		
		for (ProjectionData projectionData : projections) {
			projectionDatas.add(projectionData);
		}
		
		for (Integer id : gradeIds) {
			ProjectionData projection=getProjectDataByGrade(projections,id);
			if(projection==null){
				String sqlgrade="select [Grade] from [tlkpGrade] where [GradeCode]=:grade";
				MapSqlParameterSource source=new MapSqlParameterSource();
				source.addValue("grade", id);
				String grade=jdbcTemplate.queryForObject(sqlgrade, source, String.class);
				ProjectionData data=new ProjectionData();
				data.setGrade(grade);
				data.setGradeCode(id);
				projectionDatas.add(data);
			}
		}
		
		
		Collections.sort(projectionDatas, new Comparator<ProjectionData>() {
			@Override
			public int compare(ProjectionData arg0, ProjectionData arg1) {
				return Integer.valueOf(arg0.getGradeCode()).compareTo(arg1.getGradeCode());
			}
		});
		
	//	System.out.println(gradeIds);
		
		
		for (ProjectionData projectionData : projectionDatas) {
			
			MapSqlParameterSource parameterSource2=new MapSqlParameterSource();
			parameterSource2.addValue("sdate", new Timestamp(sdate.getTime()));
			parameterSource2.addValue("edate", new Timestamp(edate.getTime()));
			parameterSource2.addValue("gradeCode", projectionData.getGradeCode());
			String sql3="SELECT "
					+ "count(*) as [Count],"
					+ "d.[GradeCode], "
					+ "h.[DeliveryDate] "
					+ "FROM tblPurchaseHeader AS h, tblPurchaseDetail AS d WHERE "
					+ "(h.DeliveryDate between :sdate  and :edate) "
					+ " and "
					+ " d.[ReleaseNumber]=h.[ReleaseNumber] "
					+ "And "
					+ " h.[LoadStatus]='Enroute' "
					+ " And "
					+ "d.[GradeCode]=:gradeCode "
					+ "Group by d.[GradeCode],h.[DeliveryDate] ";
			
			
			List<PurchaseHeaderDetail> headerDetails=jdbcTemplate.query(sql3, parameterSource2, new RowMapper<PurchaseHeaderDetail>() {

				@Override
				public PurchaseHeaderDetail mapRow(ResultSet rs, int arg1)
						throws SQLException {
					PurchaseHeaderDetail headerDetail=new PurchaseHeaderDetail();
					headerDetail.setCount(rs.getInt("count"));
					headerDetail.setGrade(rs.getString("GradeCode"));
					headerDetail.setDeliveryDate(new Date(rs.getTimestamp("DeliveryDate").getTime()));
					return headerDetail;
				}
			});
			
			//Yard 
			MapSqlParameterSource parameterSource3=new MapSqlParameterSource();
			parameterSource3.addValue("gradeCode", projectionData.getGradeCode());
			
			String sql4="SELECT "
					+ "count(*) as [Count] "
					+ "FROM tblPurchaseHeader AS h, tblPurchaseDetail AS d WHERE  "
					+ "d.[ReleaseNumber]=h.[ReleaseNumber] "
					+ "And "
					+ "d.[GradeCode]=:gradeCode "
					+ "And "
					+ "h.[LoadStatus]='Yard' "
					+ "Group by d.[GradeCode] ";
			
			int yardCount=0;
			try {
				yardCount=jdbcTemplate.queryForObject(sql4, parameterSource3, Integer.class);
			} catch (Exception e) {
				//Row 
			}
					
			
			//Pending
			//Yard 
			MapSqlParameterSource parameterSource4=new MapSqlParameterSource();
			parameterSource4.addValue("gradeCode", projectionData.getGradeCode());
			parameterSource4.addValue("sdate", new Timestamp(sdate.getTime()));
			
			String sql5="SELECT "
					+ "count(*) as [Count] "
					+ "FROM tblPurchaseHeader AS h, tblPurchaseDetail AS d WHERE  "
					+ "d.[ReleaseNumber]=h.[ReleaseNumber] "
					+ "And "
					+ "h.DeliveryDate<:sdate "
					+ "And "
					+ "d.[GradeCode]=:gradeCode "
					+ "And "
					+ "h.[LoadStatus]='Enroute' "
					+ "Group by d.[GradeCode] ";
			
			int pendingCount=0;
			try {
				pendingCount=jdbcTemplate.queryForObject(sql5, parameterSource4, Integer.class);
			} catch (Exception e) {
				//Row 
			}
			
			
			projectionData.setHeaderDetails(headerDetails);
			
			Calendar sCal=Calendar.getInstance();
			sCal.setTime(sdate);
			sCal.set(Calendar.HOUR_OF_DAY,0);
			sCal.set(Calendar.MINUTE,0);
			sCal.set(Calendar.SECOND,0);
			sCal.set(Calendar.MILLISECOND,0);
			
			int days=CommonUtil.getDaysDiffernce(sdate, edate);
			for(int i=0;i<=days;i++){
				int inbound=getInbound(headerDetails,sCal.getTime());
				
				if(i==0){
					//System.out.println("Pending Count="+pendingCount+"\tYard="+yardCount+"\t Grade="+projectionData.getGradeCode());
					
					inbound+=(yardCount+pendingCount);
				}
				
				projectionData.getInbounds().add(inbound*20);
					sCal.add(Calendar.DATE, 1);
			}
			
			
		}		
		return projectionDatas;
	
	}

	/**
	 * @param projections
	 * @param id
	 * @return
	 */
	private ProjectionData getProjectDataByGrade(
			List<ProjectionData> projections, Integer id) {
		ProjectionData projection=null;
		for (ProjectionData projectionData : projections) {
			if(projectionData.getGradeCode()==id){
				projection=projectionData;
				break;
			}
		}
		return projection;
	}


	private int getInbound(List<PurchaseHeaderDetail> headerDetails, Date time) {
		int inbound=0;
		for (PurchaseHeaderDetail purchaseHeaderDetail : headerDetails) {
			if(CommonUtil.isEqual(time, purchaseHeaderDetail.getDeliveryDate())){
				inbound=purchaseHeaderDetail.getCount();
				break;
			}
		}
		return inbound;
	}


	
		
}

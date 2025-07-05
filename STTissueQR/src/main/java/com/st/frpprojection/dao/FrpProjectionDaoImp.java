/**
 * 
 */
package com.st.frpprojection.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.st.frpprojection.mapper.FrpProjectionMapper;
import com.st.frpprojection.model.FrpProjection;
import com.st.frpprojection.model.ProjectionReminder;

/**
 * @author sbora
 *
 */
@Repository
public class FrpProjectionDaoImp implements FrpProjectionDao{

	@Autowired
	private DataSource dataSource;

	
	@Override
	public int saveFormula(final FrpProjection frpProjection) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		KeyHolder holder=new GeneratedKeyHolder();
		
		final String sql="insert into [frpProjection]("
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
			final String sql="update [frpProjection] set "
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
		String sql="select * from [frpProjection] order by [Type] desc";
		List<FrpProjection> projections=jdbcTemplate.query(sql,new FrpProjectionMapper());
		return projections;
	}

	
	@Override
	public FrpProjection getProjectionFormula(int id) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		String sql="select * from [frpProjection] where [ID]=?";
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
		
		String sql="select * from [frpProjection] where [ID] in(:ids)";
		
		List<FrpProjection> projections=jdbcTemplate.query(sql, parameterSource, new FrpProjectionMapper());
		
		return projections;
	}

	/* (non-Javadoc)
	 * @see com.st.frpprojection.dao.FrpProjectionDao#getProjectionFormulae(java.lang.String)
	 */
	@Override
	public List<FrpProjection> getProjectionFormulae(String type) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		String sql="select * from [frpProjection] where [Type]=? order by [Type] desc";
		List<FrpProjection> projections=jdbcTemplate.query(sql,new Object[]{type},new FrpProjectionMapper());
		return projections;
	}

	/* (non-Javadoc)
	 * @see com.st.frpprojection.dao.FrpProjectionDao#delete(int)
	 */
	@Override
	public void delete(int id) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		String sql="delete from [frpProjection] where [ID]=? ";
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
		
		String sql="select Type,Type2 from frpProjection where ID=(SELECT formulaID  FROM frpProjectionReminder where [Date]=?)";
		
		List<Map<String, Object>> maps=jdbcTemplate.queryForList(sql, new Object[]{new Timestamp(date.getTime())});
		
		
		
		return maps;
	}

	
	
		
}

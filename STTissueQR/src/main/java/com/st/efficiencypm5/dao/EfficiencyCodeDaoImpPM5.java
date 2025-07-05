/**
 * 
 */
package com.st.efficiencypm5.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.st.efficiencypm5.mapper.PrimaryCodeMapperPM5;
import com.st.efficiencypm5.mapper.SecondaryCodeMapperPM5;
import com.st.efficiencypm5.model.EfficiencyPM5;
import com.st.efficiencypm5.model.PrimaryCodePM5;
import com.st.efficiencypm5.model.SecondaryCodePM5;


/**
 * @author sbora
 *
 */
@Repository
public class EfficiencyCodeDaoImpPM5 implements EfficiencyCodeDaoPM5 {
	
	@Autowired
	private DataSource dataSource;
	
	@Override
	public PrimaryCodePM5 getPrimaryCode(int id) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		String sql="select * from [efficiencyPrimaryCode_pm5] where [ID]=?";
		PrimaryCodePM5 code=jdbcTemplate.queryForObject(sql, new Object[]{id}, new PrimaryCodeMapperPM5());
		return code;
	}

	/* (non-Javadoc)
	 * @see com.st.efficiency.dao.EfficencyCodeDao#getSecondaryCode()
	 */
	@Override
	public SecondaryCodePM5 getSecondaryCode(int id) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		String sql="select * from [efficiencySecondaryCode_pm5] where [ID]=?";
		SecondaryCodePM5 code=jdbcTemplate.queryForObject(sql, new Object[]{id}, new SecondaryCodeMapperPM5());
		if(code!=null){
			String sql2="select * from [efficiencyPrimaryCode_pm5] where [ID]=?";
			PrimaryCodePM5 pcode=jdbcTemplate.queryForObject(sql2, new Object[]{code.getPrimaryCode().getId()}, new PrimaryCodeMapperPM5());
			code.setPrimaryCode(pcode);
		}
		return code;
	}

	/* (non-Javadoc)
	 * @see com.st.efficiency.dao.EfficencyCodeDao#getPrimaryCodes()
	 */
	@Override
	public List<PrimaryCodePM5> getPrimaryCodes() {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		String sql="select * from [efficiencyPrimaryCode_pm5] order by [ID] desc";
		List<PrimaryCodePM5> codes=jdbcTemplate.query(sql, new PrimaryCodeMapperPM5());
		return codes;
	}

	/* (non-Javadoc)
	 * @see com.st.efficiency.dao.EfficencyCodeDao#getSecondaryCodes(com.st.efficiency.model.PrimaryCode)
	 */
	@Override
	public List<SecondaryCodePM5> getSecondaryCodes(PrimaryCodePM5 code) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		String sql="select * from [efficiencySecondaryCode_pm5] where [PrimaryCodeID]=? order by [ID] desc";
		List<SecondaryCodePM5> codes=jdbcTemplate.query(sql,new Object[]{code.getId()}, new SecondaryCodeMapperPM5());
		if(codes!=null){
			for (SecondaryCodePM5 secondaryCode : codes) {
				if(code!=null){
					String sql2="select * from [efficiencyPrimaryCode_pm5] where [ID]=?";
					PrimaryCodePM5 pcode=jdbcTemplate.queryForObject(sql2, new Object[]{secondaryCode.getPrimaryCode().getId()}, new PrimaryCodeMapperPM5());
					secondaryCode.setPrimaryCode(pcode);
				}
			}
		}
		
		return codes;
	}

	/* (non-Javadoc)
	 * @see com.st.efficiency.dao.EfficencyCodeDao#add(com.st.efficiency.model.PrimaryCode)
	 */
	@Override
	public int add(final PrimaryCodePM5 code) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		KeyHolder holder=new GeneratedKeyHolder();
		final String sql="insert into [efficiencyPrimaryCode_pm5]("
				+ "[Code],"
				+ "[Note]"
				+ ") values(?,?)";
		
		jdbcTemplate.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection arg0)
					throws SQLException {
				PreparedStatement statement=arg0.prepareStatement(sql, new String[]{"ID"});
				statement.setString(1, code.getCode());
				statement.setString(2, code.getNote());
				
				return statement;
			}
		},holder);
		
		return holder.getKey().intValue();
	}

	/* (non-Javadoc)
	 * @see com.st.efficiency.dao.EfficencyCodeDao#add(com.st.efficiency.model.SecondaryCode)
	 */
	@Override
	public int add(final SecondaryCodePM5 code) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		KeyHolder holder=new GeneratedKeyHolder();
		final String sql="insert into [efficiencySecondaryCode_pm5]("
				+ "[Code],"
				+ "[Note],"
				+ "[PrimaryCodeID]"
				+ ") values(?,?,?)";
		
		jdbcTemplate.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection arg0)
					throws SQLException {
				PreparedStatement statement=arg0.prepareStatement(sql, new String[]{"ID"});
				statement.setString(1, code.getCode());
				statement.setString(2, code.getNote());
				statement.setInt(3, code.getPrimaryCode().getId());
				
				return statement;
			}
		},holder);
		
		return holder.getKey().intValue();
	}

	/* (non-Javadoc)
	 * @see com.st.efficiency.dao.EfficencyCodeDao#update(com.st.efficiency.model.PrimaryCode)
	 */
	@Override
	public void update(final PrimaryCodePM5 code) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		final String sql="update [efficiencyPrimaryCode_pm5] SET"
				+ "[Code]=?,"
				+ "[Note]=?"
				+ " where [ID]=?";
		jdbcTemplate.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection arg0)
					throws SQLException {
				PreparedStatement statement=arg0.prepareStatement(sql);
				statement.setString(1, code.getCode());
				statement.setString(2, code.getNote());
				statement.setInt(3, code.getId());
				
				return statement;
			}
		});
	}

	/* (non-Javadoc)
	 * @see com.st.efficiency.dao.EfficencyCodeDao#update(com.st.efficiency.model.SecondaryCode)
	 */
	@Override
	public void update(final SecondaryCodePM5 code) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		final String sql="update [efficiencySecondaryCode_pm5] SET"
				+ "[Code]=?,"
				+ "[Note]=?,"
				+ "[PrimaryCodeID]=?"
				+ " where [ID]=?";
		jdbcTemplate.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection arg0)
					throws SQLException {
				PreparedStatement statement=arg0.prepareStatement(sql);
				statement.setString(1, code.getCode());
				statement.setString(2, code.getNote());
				statement.setInt(3, code.getPrimaryCode().getId());
				statement.setInt(4, code.getId());
				
				return statement;
			}
		});

	}

	/* (non-Javadoc)
	 * @see com.st.efficiency.dao.EfficencyCodeDao#delete(com.st.efficiency.model.PrimaryCode)
	 */
	@Override
	public void delete(PrimaryCodePM5 code) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		String sql="delete from [efficiencyPrimaryCode_pm5] "
				+ " where [ID]=?";
		
		jdbcTemplate.update(sql, new Object[]{code.getId()});

	}

	/* (non-Javadoc)
	 * @see com.st.efficiency.dao.EfficencyCodeDao#delete(com.st.efficiency.model.SecondaryCode)
	 */
	@Override
	public void delete(SecondaryCodePM5 code) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		String sql="delete from [efficiencySecondaryCode_pm5] "
				+ " where [ID]=?";
		jdbcTemplate.update(sql, new Object[]{code.getId()});

	}

	/* (non-Javadoc)
	 * @see com.st.efficiency.dao.EfficencyCodeDao#getSecondaryCodes()
	 */
	@Override
	public List<SecondaryCodePM5> getSecondaryCodes() {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		String sql="select * from [efficiencySecondaryCode_pm5] order by [ID] desc";
		List<SecondaryCodePM5> codes=jdbcTemplate.query(sql, new SecondaryCodeMapperPM5());
		if(codes!=null){
			for (SecondaryCodePM5 secondaryCode : codes) {
				String sql2="select * from [efficiencyPrimaryCode_pm5] where [ID]=?";
				PrimaryCodePM5 pcode=jdbcTemplate.queryForObject(sql2, new Object[]{secondaryCode.getPrimaryCode().getId()}, new PrimaryCodeMapperPM5());
				secondaryCode.setPrimaryCode(pcode);
			}
		}
		return codes;
	}


	@Override
	public List<EfficiencyPM5> getSummaryData(Date sdate, Date edate, int pcode,
			int scode) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		Object [] param=null;
		
		String sql="SELECT  "
				+ "e.[StartTime],e.[EndTime],p.[code] as pcode,s.[code] as scode "
				+ "FROM [efficiencyData_pm5] e, [efficiencyPrimaryCode_pm5] p, [efficiencySecondaryCode_pm5] s "
				+ "where "
				+ "(e.[Date] Between ? And ?) "
				+ "and "
				+ "p.[ID]=s.[PrimaryCodeID] "
				+ "and "
				+ "s.[ID]=e.[SecodaryCode] ";
				
			if(pcode!=0 && scode!=0){
				sql	+=" and p.[ID]= ? and s.[ID]= ?";
				param=new Object[]{
						new Timestamp(sdate.getTime()),
						new Timestamp(edate.getTime()),
						pcode,scode
				};
			}else if(scode!=0){
				sql	+=" and s.[ID]= ? ";
				param=new Object[]{
						new Timestamp(sdate.getTime()),
						new Timestamp(edate.getTime()),
						scode
				};
			}else if(pcode!=0){
				sql	+=" and p.[ID]= ? ";
				param=new Object[]{
						new Timestamp(sdate.getTime()),
						new Timestamp(edate.getTime()),
						pcode
				};
			}else{
				param=new Object[]{
						new Timestamp(sdate.getTime()),
						new Timestamp(edate.getTime())
				};
			}
				
				
			sql	+= " order by "
				+ "p.[code],s.[code] ";
		
		List<EfficiencyPM5> efficiencies=jdbcTemplate.query(sql, param,new RowMapper<EfficiencyPM5>(){

			@Override
			public EfficiencyPM5 mapRow(ResultSet rs, int arg1)
					throws SQLException {
				EfficiencyPM5 efficiency=new EfficiencyPM5();
				efficiency.setStartTime(rs.getTimestamp("StartTime"));
				efficiency.setEndTime(rs.getTimestamp("EndTime"));
				efficiency.setPcode(rs.getString("pcode"));
				efficiency.setScode(rs.getString("scode"));
				return efficiency;
			}
			
		});
		
		return efficiencies;
	}

}

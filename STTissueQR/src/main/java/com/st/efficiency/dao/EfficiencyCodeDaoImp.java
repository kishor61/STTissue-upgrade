/**
 * 
 */
package com.st.efficiency.dao;

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

import com.st.efficiency.mapper.PrimaryCodeMapper;
import com.st.efficiency.mapper.SecondaryCodeMapper;
import com.st.efficiency.model.Efficiency;
import com.st.efficiency.model.PrimaryCode;
import com.st.efficiency.model.SecondaryCode;

/**
 * @author sbora
 *
 */
@Repository
public class EfficiencyCodeDaoImp implements EfficiencyCodeDao {
	
	@Autowired
	private DataSource dataSource;
	
	@Override
	public PrimaryCode getPrimaryCode(int id) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		String sql="select * from [efficiencyPrimaryCode] where [ID]=?";
		PrimaryCode code=jdbcTemplate.queryForObject(sql, new Object[]{id}, new PrimaryCodeMapper());
		return code;
	}

	/* (non-Javadoc)
	 * @see com.st.efficiency.dao.EfficencyCodeDao#getSecondaryCode()
	 */
	@Override
	public SecondaryCode getSecondaryCode(int id) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		String sql="select * from [efficiencySecondaryCode] where [ID]=?";
		SecondaryCode code=jdbcTemplate.queryForObject(sql, new Object[]{id}, new SecondaryCodeMapper());
		if(code!=null){
			String sql2="select * from [efficiencyPrimaryCode] where [ID]=?";
			PrimaryCode pcode=jdbcTemplate.queryForObject(sql2, new Object[]{code.getPrimaryCode().getId()}, new PrimaryCodeMapper());
			code.setPrimaryCode(pcode);
		}
		return code;
	}

	/* (non-Javadoc)
	 * @see com.st.efficiency.dao.EfficencyCodeDao#getPrimaryCodes()
	 */
	@Override
	public List<PrimaryCode> getPrimaryCodes() {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		String sql="select * from [efficiencyPrimaryCode] order by [ID] desc";
		List<PrimaryCode> codes=jdbcTemplate.query(sql, new PrimaryCodeMapper());
		return codes;
	}

	/* (non-Javadoc)
	 * @see com.st.efficiency.dao.EfficencyCodeDao#getSecondaryCodes(com.st.efficiency.model.PrimaryCode)
	 */
	@Override
	public List<SecondaryCode> getSecondaryCodes(PrimaryCode code) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		String sql="select * from [efficiencySecondaryCode] where [PrimaryCodeID]=? order by [ID] desc";
		List<SecondaryCode> codes=jdbcTemplate.query(sql,new Object[]{code.getId()}, new SecondaryCodeMapper());
		if(codes!=null){
			for (SecondaryCode secondaryCode : codes) {
				if(code!=null){
					String sql2="select * from [efficiencyPrimaryCode] where [ID]=?";
					PrimaryCode pcode=jdbcTemplate.queryForObject(sql2, new Object[]{secondaryCode.getPrimaryCode().getId()}, new PrimaryCodeMapper());
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
	public int add(final PrimaryCode code) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		KeyHolder holder=new GeneratedKeyHolder();
		final String sql="insert into [efficiencyPrimaryCode]("
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
	public int add(final SecondaryCode code) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		KeyHolder holder=new GeneratedKeyHolder();
		final String sql="insert into [efficiencySecondaryCode]("
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
	public void update(final PrimaryCode code) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		final String sql="update [efficiencyPrimaryCode] SET"
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
	public void update(final SecondaryCode code) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		final String sql="update [efficiencySecondaryCode] SET"
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
	public void delete(PrimaryCode code) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		String sql="delete from [efficiencyPrimaryCode] "
				+ " where [ID]=?";
		
		jdbcTemplate.update(sql, new Object[]{code.getId()});

	}

	/* (non-Javadoc)
	 * @see com.st.efficiency.dao.EfficencyCodeDao#delete(com.st.efficiency.model.SecondaryCode)
	 */
	@Override
	public void delete(SecondaryCode code) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		String sql="delete from [efficiencySecondaryCode] "
				+ " where [ID]=?";
		jdbcTemplate.update(sql, new Object[]{code.getId()});

	}

	/* (non-Javadoc)
	 * @see com.st.efficiency.dao.EfficencyCodeDao#getSecondaryCodes()
	 */
	@Override
	public List<SecondaryCode> getSecondaryCodes() {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		String sql="select * from [efficiencySecondaryCode] order by [ID] desc";
		List<SecondaryCode> codes=jdbcTemplate.query(sql, new SecondaryCodeMapper());
		if(codes!=null){
			for (SecondaryCode secondaryCode : codes) {
				String sql2="select * from [efficiencyPrimaryCode] where [ID]=?";
				PrimaryCode pcode=jdbcTemplate.queryForObject(sql2, new Object[]{secondaryCode.getPrimaryCode().getId()}, new PrimaryCodeMapper());
				secondaryCode.setPrimaryCode(pcode);
			}
		}
		return codes;
	}


	@Override
	public List<Efficiency> getSummaryData(Date sdate, Date edate, int pcode,
			int scode) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		Object [] param=null;
		
		String sql="SELECT  "
				+ "e.[StartTime],e.[EndTime],p.[code] as pcode,s.[code] as scode "
				+ "FROM [efficiencyData] e, [efficiencyPrimaryCode] p, [efficiencySecondaryCode] s "
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
		
		List<Efficiency> efficiencies=jdbcTemplate.query(sql, param,new RowMapper<Efficiency>(){

			@Override
			public Efficiency mapRow(ResultSet rs, int arg1)
					throws SQLException {
				Efficiency efficiency=new Efficiency();
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

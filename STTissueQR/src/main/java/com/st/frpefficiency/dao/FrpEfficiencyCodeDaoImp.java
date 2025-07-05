/**
 * 
 */
package com.st.frpefficiency.dao;

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

import com.st.frpefficiency.mapper.FrpPrimaryCodeMapper;
import com.st.frpefficiency.mapper.FrpSecondaryCodeMapper;
import com.st.frpefficiency.model.FrpEfficiency;
import com.st.frpefficiency.model.FrpPrimaryCode;
import com.st.frpefficiency.model.FrpSecondaryCode;


/**
 * @author sbora
 *
 */
@Repository
public class FrpEfficiencyCodeDaoImp implements FrpEfficiencyCodeDao {
	
	@Autowired
	private DataSource dataSource;
	
	@Override
	public FrpPrimaryCode getPrimaryCode(int id) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		String sql="select * from [frpEfficiencyPrimaryCode] where [ID]=?";
		FrpPrimaryCode code=jdbcTemplate.queryForObject(sql, new Object[]{id}, new FrpPrimaryCodeMapper());
		return code;
	}

	/* (non-Javadoc)
	 * @see com.st.efficiency.dao.EfficencyCodeDao#getSecondaryCode()
	 */
	@Override
	public FrpSecondaryCode getSecondaryCode(int id) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		String sql="select * from [frpEfficiencySecondaryCode] where [ID]=?";
		FrpSecondaryCode code=jdbcTemplate.queryForObject(sql, new Object[]{id}, new FrpSecondaryCodeMapper());
		if(code!=null){
			String sql2="select * from [frpEfficiencyPrimaryCode] where [ID]=?";
			FrpPrimaryCode pcode=jdbcTemplate.queryForObject(sql2, new Object[]{code.getPrimaryCode().getId()}, new FrpPrimaryCodeMapper());
			code.setPrimaryCode(pcode);
		}
		return code;
	}

	/* (non-Javadoc)
	 * @see com.st.efficiency.dao.EfficencyCodeDao#getPrimaryCodes()
	 */
	@Override
	public List<FrpPrimaryCode> getPrimaryCodes() {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		String sql="select * from [frpEfficiencyPrimaryCode] order by [ID] desc";
		List<FrpPrimaryCode> codes=jdbcTemplate.query(sql, new FrpPrimaryCodeMapper());
		return codes;
	}

	/* (non-Javadoc)
	 * @see com.st.efficiency.dao.EfficencyCodeDao#getSecondaryCodes(com.st.efficiency.model.PrimaryCode)
	 */
	@Override
	public List<FrpSecondaryCode> getSecondaryCodes(FrpPrimaryCode code) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		String sql="select * from [frpEfficiencySecondaryCode] where [PrimaryCodeID]=? order by [ID] desc";
		List<FrpSecondaryCode> codes=jdbcTemplate.query(sql,new Object[]{code.getId()}, new FrpSecondaryCodeMapper());
		if(codes!=null){
			for (FrpSecondaryCode secondaryCode : codes) {
				if(code!=null){
					String sql2="select * from [frpEfficiencyPrimaryCode] where [ID]=?";
					FrpPrimaryCode pcode=jdbcTemplate.queryForObject(sql2, new Object[]{secondaryCode.getPrimaryCode().getId()}, new FrpPrimaryCodeMapper());
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
	public int add(final FrpPrimaryCode code) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		KeyHolder holder=new GeneratedKeyHolder();
		final String sql="insert into [frpEfficiencyPrimaryCode]("
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
	public int add(final FrpSecondaryCode code) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		KeyHolder holder=new GeneratedKeyHolder();
		final String sql="insert into [frpEfficiencySecondaryCode]("
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
	public void update(final FrpPrimaryCode code) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		final String sql="update [frpEfficiencyPrimaryCode] SET"
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
	public void update(final FrpSecondaryCode code) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		final String sql="update [frpEfficiencySecondaryCode] SET"
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
	public void delete(FrpPrimaryCode code) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		String sql="delete from [frpEfficiencyPrimaryCode] "
				+ " where [ID]=?";
		
		jdbcTemplate.update(sql, new Object[]{code.getId()});

	}

	/* (non-Javadoc)
	 * @see com.st.efficiency.dao.EfficencyCodeDao#delete(com.st.efficiency.model.SecondaryCode)
	 */
	@Override
	public void delete(FrpSecondaryCode code) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		String sql="delete from [frpEfficiencySecondaryCode] "
				+ " where [ID]=?";
		jdbcTemplate.update(sql, new Object[]{code.getId()});

	}

	/* (non-Javadoc)
	 * @see com.st.efficiency.dao.EfficencyCodeDao#getSecondaryCodes()
	 */
	@Override
	public List<FrpSecondaryCode> getSecondaryCodes() {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		String sql="select * from [frpEfficiencySecondaryCode] order by [ID] desc";
		List<FrpSecondaryCode> codes=jdbcTemplate.query(sql, new FrpSecondaryCodeMapper());
		if(codes!=null){
			for (FrpSecondaryCode secondaryCode : codes) {
				String sql2="select * from [frpEfficiencyPrimaryCode] where [ID]=?";
				FrpPrimaryCode pcode=jdbcTemplate.queryForObject(sql2, new Object[]{secondaryCode.getPrimaryCode().getId()}, new FrpPrimaryCodeMapper());
				secondaryCode.setPrimaryCode(pcode);
			}
		}
		return codes;
	}

	/* (non-Javadoc)
	 * @see com.st.frpefficiency.dao.FrpEfficiencyCodeDao#getSummaryData(java.util.Date, java.util.Date, int, int)
	 */
	@Override
	public List<FrpEfficiency> getSummaryData(Date sdate, Date edate,
			int pcode, int scode) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		Object [] param=null;
		
		String sql="SELECT  "
				+ "e.[StartTime],e.[EndTime],p.[code] as pcode,s.[code] as scode "
				+ "FROM [frpEfficiencyData] e, [frpEfficiencyPrimaryCode] p, [frpEfficiencySecondaryCode] s "
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
		
		List<FrpEfficiency> efficiencies=jdbcTemplate.query(sql, param,new RowMapper<FrpEfficiency>(){

			@Override
			public FrpEfficiency mapRow(ResultSet rs, int arg1)
					throws SQLException {
				FrpEfficiency efficiency=new FrpEfficiency();
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

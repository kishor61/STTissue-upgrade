/**
 * 
 */
package com.st.frpefficiency.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.st.common.CommonUtil;
import com.st.frpefficiency.model.FrpEfficiency;
import com.st.frpefficiency.model.FrpPrimaryCode;
import com.st.frpefficiency.model.FrpSecondaryCode;

/**
 * @author sbora
 *
 */
@Repository
public class FrpEfficiencyDaoImp implements FrpEfficiencyDao {

	@Autowired
	private DataSource dataSource;
	
	@Override
	public int add(final FrpEfficiency efficency) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		KeyHolder holder=new GeneratedKeyHolder();
		
		final String sql="insert into [frpEfficiencyData]"
				+ "("
				+"[Date],"
				+"[Shift],"
				+"[Crew],"
				+"[StartTime],"
				+"[EndTime],"
				+"[BatchNo],"
				+"[Grade],"
				+"[Comment],"
				+"[SecodaryCode]"
				+ ") values(?,?,?,?,?,?,?,?,?)";
		
			jdbcTemplate.update(new PreparedStatementCreator() {
				
				@Override
				public PreparedStatement createPreparedStatement(Connection arg0)
						throws SQLException {
					PreparedStatement statement=arg0.prepareStatement(sql, new String[]{"ID"});
					statement.setTimestamp(1, new Timestamp(CommonUtil.getDateTime(efficency.getDate(), efficency.getStartTime()).getTime()));
					statement.setString(2, efficency.getShift());
					statement.setString(3, efficency.getCrew());
					statement.setTimestamp(4, efficency.getStartTime());
					statement.setTimestamp(5, efficency.getEndTime());
					statement.setString(6, efficency.getBatchNo());
					statement.setString(7, efficency.getGrade());
					statement.setString(8, efficency.getComment());
					statement.setInt(9, efficency.getSecondaryCode().getId());
					
					return statement;
				}
			},holder);
		
		return holder.getKey().intValue();
	}

	
	@Override
	public List<FrpEfficiency> getEfficiencies(FrpEfficiency efficiency) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		String sql="SELECT "
				+ "d.[ID],"
				+ "d.[Date],"
				+ "d.[Shift],"
				+ "d.[Crew],"
				+ "d.[StartTime],"
				+ "d.[EndTime],"
				+ "d.[BatchNo],"
				+ "d.[Grade],"
				+ "d.[Comment],"
				+ "sc.[code] as scode,"
				+ "sc.[ID] as sid,"
				+ "pc.[code] as pcode"
				+ " FROM [frpEfficiencyData] d,"
				+ "frpEfficiencySecondaryCode sc,"
				+ "frpEfficiencyPrimaryCode pc "
				+ " where ( d.[Date] between ? and ?) and "
				+ "sc.[ID]=d.[SecodaryCode] and "
				+ "pc.[ID]=sc.[PrimaryCodeID] ";
		
			if(efficiency.getPcode()!=null && !(efficiency.getPcode().trim().equals(""))){
				sql+=" and pc.[ID]="+efficiency.getPcode()+" ";
			}
			
			if(efficiency.getScode()!=null && !(efficiency.getScode().trim().equals(""))){
				sql+=" and sc.[ID]="+efficiency.getScode()+" ";
			}
		
			sql+=" order by d.[Date]";
			
			List<FrpEfficiency> efficiencies=jdbcTemplate.query(sql, new Object[]{
					new Date(efficiency.getStartDate().getTime()),
					new Date(efficiency.getEndDate().getTime())
			}, new RowMapper<FrpEfficiency>() {

				@Override
				public FrpEfficiency mapRow(ResultSet rs, int arg1)
						throws SQLException {
					FrpEfficiency efficiency=new FrpEfficiency();
					efficiency.setId(rs.getInt("ID"));
					efficiency.setDate(new Date(rs.getTimestamp("Date").getTime()));
					efficiency.setShift(rs.getString("Shift"));
					efficiency.setCrew(rs.getString("Crew"));
					efficiency.setStartTime(rs.getTimestamp("StartTime"));
					efficiency.setEndTime(rs.getTimestamp("EndTime"));
					efficiency.setBatchNo(rs.getString("BatchNo"));
					efficiency.setGrade(rs.getString("Grade"));
					efficiency.setComment(rs.getString("Comment"));
					
					FrpSecondaryCode secondaryCode=new FrpSecondaryCode();
					secondaryCode.setCode(rs.getString("scode"));
					secondaryCode.setId(rs.getInt("sid"));
					efficiency.setSecondaryCode(secondaryCode);
					
					FrpPrimaryCode primaryCode=new FrpPrimaryCode();
					primaryCode.setCode(rs.getString("pcode"));
					secondaryCode.setPrimaryCode(primaryCode);
					
					efficiency.setFendTimeHH(""+CommonUtil.getHoursDuration(new Date(efficiency.getStartTime().getTime()), new Date(efficiency.getEndTime().getTime())));
					efficiency.setFendTimeMM(""+CommonUtil.getMinutesDuration(new Date(efficiency.getStartTime().getTime()), new Date(efficiency.getEndTime().getTime())));
					
					
					
					return efficiency;
				}
			});
		
		return efficiencies;
	}


	
	@Override
	public FrpEfficiency getEfficiency(int id) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		String sql="SELECT "
				+ "d.[ID],"
				+ "d.[Date],"
				+ "d.[Shift],"
				+ "d.[Crew],"
				+ "d.[StartTime],"
				+ "d.[EndTime],"
				+ "d.[BatchNo],"
				+ "d.[Grade],"
				+ "d.[Comment],"
				+ "sc.[ID] as sid,"
				+ "sc.[code] as scode,"
				+ "pc.[code] as pcode"
				+ " FROM [frpEfficiencyData] d,"
				+ "frpEfficiencySecondaryCode sc,"
				+ "frpEfficiencyPrimaryCode pc "
				+ " where d.[ID]=?"
				+ " and "
				+ "sc.[ID]=d.[SecodaryCode]"
				+ " and "
				+ "pc.[ID]=sc.[PrimaryCodeID]";
		
		FrpEfficiency efficiency=jdbcTemplate.queryForObject(sql, new Object[]{id}, new RowMapper<FrpEfficiency>() {

			@Override
			public FrpEfficiency mapRow(ResultSet rs, int arg1)
					throws SQLException {
				FrpEfficiency efficiency=new FrpEfficiency();
				efficiency.setId(rs.getInt("ID"));
				efficiency.setDate(new Date(rs.getTimestamp("Date").getTime()));
				efficiency.setShift(rs.getString("Shift"));
				efficiency.setCrew(rs.getString("Crew"));
				efficiency.setStartTime(rs.getTimestamp("StartTime"));
				efficiency.setEndTime(rs.getTimestamp("EndTime"));
				efficiency.setBatchNo(rs.getString("BatchNo"));
				efficiency.setGrade(rs.getString("Grade"));
				efficiency.setComment(rs.getString("Comment"));
				
				FrpSecondaryCode secondaryCode=new FrpSecondaryCode();
				secondaryCode.setCode(rs.getString("scode"));
				secondaryCode.setId(rs.getInt("sid"));
				efficiency.setSecondaryCode(secondaryCode);
				
				FrpPrimaryCode primaryCode=new FrpPrimaryCode();
				primaryCode.setCode(rs.getString("pcode"));
				secondaryCode.setPrimaryCode(primaryCode);
				
				return efficiency;
			}
		
		});
		return efficiency;
	}


	/* (non-Javadoc)
	 * @see com.st.efficiency.dao.EfficiencyDao#update(com.st.efficiency.model.Efficiency)
	 */
	@Override
	public void update(final FrpEfficiency efficency) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		
		final String sql="update[frpEfficiencyData] set "
				+"[Date]=?,"
				+"[Shift]=?,"
				+"[Crew]=?,"
				+"[StartTime]=?,"
				+"[EndTime]=?,"
				+"[BatchNo]=?,"
				+"[Grade]=?,"
				+"[Comment]=?,"
				+"[SecodaryCode]=?"
				+ " where [ID]=? ";
		
			jdbcTemplate.update(new PreparedStatementCreator() {
				
				@Override
				public PreparedStatement createPreparedStatement(Connection arg0)
						throws SQLException {
					PreparedStatement statement=arg0.prepareStatement(sql);
					statement.setTimestamp(1, new Timestamp(CommonUtil.getDateTime(efficency.getDate(), efficency.getStartTime()).getTime()));
					statement.setString(2, efficency.getShift());
					statement.setString(3, efficency.getCrew());
					statement.setTimestamp(4, efficency.getStartTime());
					statement.setTimestamp(5, efficency.getEndTime());
					statement.setString(6, efficency.getBatchNo());
					statement.setString(7, efficency.getGrade());
					statement.setString(8, efficency.getComment());
					statement.setInt(9, efficency.getSecondaryCode().getId());
					statement.setInt(10, efficency.getId());
					
					return statement;
				}
			});
		
	}


	
	@Override
	public void delete(int id) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		String sql="delete from [frpEfficiencyData] where [ID]=?";
		jdbcTemplate.update(sql, new Object[]{id});
		
	}

}

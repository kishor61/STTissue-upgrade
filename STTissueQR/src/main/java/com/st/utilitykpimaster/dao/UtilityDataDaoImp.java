/**
 * 
 */
package com.st.utilitykpimaster.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.st.common.CommonUtil;
import com.st.utilitykpimaster.mapper.UtilityDataMapper;
import com.st.utilitykpimaster.model.UtilityData;

/**
 * @author sbora
 *
 */
@Repository
public class UtilityDataDaoImp implements UtilityDataDao {

	@Autowired
	private DataSource dataSource;
	
	/* (non-Javadoc)
	 * @see com.st.utilitydata.dao.UtilityDataDao#save(com.st.utilitydata.model.UtilityData)
	 */
	@Override
	public int save(final UtilityData utilityData) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		KeyHolder keyHolder=new GeneratedKeyHolder();
		
		final String sql="insert into [utilityData]"
				+ "("
				+"[Date],"
				+"[Lb60],"
				+"[Consumption1],"
				+"[Lb150],"
				+"[Consumption2],"
				+"[MillWater],"
				+"[Consumption3],"
				+"[Condensate],"
				+"[Consumption4],"
				+"[RiverWater],"
				+"[RiverWaterData]"
				+ ")"
				+ " values("
				+ "?,?,?,"
				+ "?,?,?,"
				+ "?,?,?,?,?"
				+ ")";
		jdbcTemplate.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection arg0)
					throws SQLException {
				PreparedStatement statement=arg0.prepareStatement(sql, new String[]{"ID"});
				statement.setTimestamp(1, new Timestamp(utilityData.getDate().getTime()));
				statement.setInt(2, utilityData.getLb60());
				statement.setInt(3, utilityData.getConsumption1());
				statement.setInt(4, utilityData.getLb150());
				statement.setInt(5, utilityData.getConsumption2());
				statement.setInt(6, utilityData.getMillWater());
				statement.setInt(7, utilityData.getConsumption3());
				statement.setInt(8, utilityData.getCondensate());
				statement.setInt(9, utilityData.getConsumption4());
				statement.setInt(10, utilityData.getRiverWater());
				statement.setInt(11, utilityData.getRiverWaterData());

				return statement;
			}
		},keyHolder);
		
		return keyHolder.getKey().intValue();
	}

	
	@Override
	public void update(final UtilityData utilityData) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		final String sql="update [utilityData] set "
				+"[Date]=?,"
				+"[Lb60]=?,"
				+"[Consumption1]=?,"
				+"[Lb150]=?,"
				+"[Consumption2]=?,"
				+"[MillWater]=?,"
				+"[Consumption3]=?,"
				+"[Condensate]=?,"
				+"[Consumption4]=?,"
				+"[RiverWater]=?,"
				+"[RiverWaterData]=? "
				+ " where [ID]=?";
		jdbcTemplate.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection arg0)
					throws SQLException {
				PreparedStatement statement=arg0.prepareStatement(sql);
				statement.setTimestamp(1, new Timestamp(utilityData.getDate().getTime()));
				statement.setInt(2, utilityData.getLb60());
				statement.setInt(3, utilityData.getConsumption1());
				statement.setInt(4, utilityData.getLb150());
				statement.setInt(5, utilityData.getConsumption2());
				statement.setInt(6, utilityData.getMillWater());
				statement.setInt(7, utilityData.getConsumption3());
				statement.setInt(8, utilityData.getCondensate());
				statement.setInt(9, utilityData.getConsumption4());
				statement.setInt(10, utilityData.getRiverWater());
				statement.setInt(11, utilityData.getRiverWaterData());
				statement.setInt(12, utilityData.getId());

				return statement;
			}
		});
		
	}


	@Override
	public UtilityData getPrevUtilityData(int id) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		
		String sql1="select * from [utilityData] where [ID]=?";
		
		UtilityData utilityData=jdbcTemplate.queryForObject(sql1, new Object[]{id},new UtilityDataMapper());
		
		String sql2="select TOP 1 * from [utilityData] where "
				+ "[Date]<("
				+ "select [Date] from [utilityData] where [ID]=?"
				+ ") order by [Date] desc";
		
		UtilityData prevUtilityData=null;
		try {
			prevUtilityData=jdbcTemplate.queryForObject(sql2,new Object[]{id}, new UtilityDataMapper());
		} catch (EmptyResultDataAccessException e) {
			e.printStackTrace();
		}
		
		if(prevUtilityData!=null){
			
			int days=CommonUtil.getDaysDiffernce(prevUtilityData.getDate(),utilityData.getDate());
			
			if(days==1){
				int consumption1=utilityData.getLb60()-prevUtilityData.getLb60();
				int consumption2=utilityData.getLb150()-prevUtilityData.getLb150();
				int consumption3=utilityData.getMillWater()-prevUtilityData.getMillWater();
				int consumption4=utilityData.getCondensate()-prevUtilityData.getCondensate();
				
				if(consumption1>0){
					utilityData.setConsumption1(consumption1);
				}
				
				if(consumption2>0){
					utilityData.setConsumption2(consumption2);
				}


				if (consumption3 > 0) {
					utilityData.setConsumption3(consumption3);
				}

				if (consumption4 > 0) {
					utilityData.setConsumption4(consumption4);
				}
				
				
				
				
				final UtilityData data=prevUtilityData;
				
				final String sql="update [utilityData] set "
						+"[Consumption1]=?,"
						+"[Consumption2]=?,"
						+"[Consumption3]=?,"
						+"[Consumption4]=?,"
						+"[RiverWater]=? "
						+ " where [ID]=?";
				jdbcTemplate.update(new PreparedStatementCreator() {
					
					@Override
					public PreparedStatement createPreparedStatement(Connection arg0)
							throws SQLException {
						PreparedStatement statement=arg0.prepareStatement(sql);
						statement.setInt(1, data.getConsumption1());
						statement.setInt(2, data.getConsumption2());
						statement.setInt(3, data.getConsumption3());
						statement.setInt(4, data.getConsumption4());
						statement.setInt(5, data.getRiverWater());
						statement.setInt(6, data.getId());

						return statement;
					}
				});
			}
			
			
		}
		
		return utilityData;
	}



	@Override
	public List<UtilityData> getUtilityDatasL31() {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		
		String sql="select TOP 1 * from [utilityData] order by [Date] desc";
		
		List<UtilityData> utilityDatas=jdbcTemplate.query(sql, new UtilityDataMapper());
		Collections.reverse(utilityDatas);
		
		return utilityDatas;
	}



	@Override
	public void delete(int id) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		
		
		String sql="delete from [utilityData] where [ID]=?";
		jdbcTemplate.update(sql, new Object[]{id});
		
	}


	
	@Override
	public List<UtilityData> getPrevUtilityData(Date sdate, Date edate) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		
		Calendar scal=Calendar.getInstance();
		scal.setTime(sdate);
		
		Calendar ecal=Calendar.getInstance();
		ecal.setTime(edate);
		ecal.add(Calendar.DATE, 1);
		
		String sql="select * from [utilityData]"
				+ " where [Date] between ? and ? "
				+ " order by [Date]";
		
		List<UtilityData> utilityDatas=jdbcTemplate.query(sql, new Object[]{
				new Timestamp(scal.getTime().getTime()),
				new Timestamp(ecal.getTime().getTime()),
		}, new UtilityDataMapper());
		
		return utilityDatas;

	}


	
	@Override
	public UtilityData getUtilityData(int id) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		
		String sql="select * from [utilityData] where [ID]=?";
		
		UtilityData utilityData=jdbcTemplate.queryForObject(sql, new Object[]{id},new UtilityDataMapper());
		
		return utilityData;
	}

}

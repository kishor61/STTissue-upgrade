/**
 * 
 */
package com.st.utilitykpimaster.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.st.utilitykpimaster.mapper.KpiRecordableDateMapper;
import com.st.utilitykpimaster.model.KpiRecordableDate;

/**
 * @author sbora
 *
 */
@Repository
public class KpiRecordableDateDaoImp implements KpiRecordableDateDao {

	@Autowired
	private DataSource dataSource;

	@Override
	public int save(final KpiRecordableDate kpiRecordableDate) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		KeyHolder holder=new GeneratedKeyHolder();
		final String sql="insert into [kpiRecordableDate]"
				+ "("
				+ "[Date],"
				+ "[Remarks]"
				+ ") values(?,?)";
		
		jdbcTemplate.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection arg0)
					throws SQLException {

				PreparedStatement statement=arg0.prepareStatement(sql,new String[]{"ID"});
				statement.setDate(1, new Date(kpiRecordableDate.getDate().getTime()));
				statement.setString(2, kpiRecordableDate.getRemarks());
				return statement;
				
			}
		},holder);
		
		return holder.getKey().intValue();
	}

	
	@Override
	public List<KpiRecordableDate> getKpiRecordableDate() {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		String sql="select * from [kpiRecordableDate] order by [Date] desc";
		
		List<KpiRecordableDate> kpiRecordableDates=jdbcTemplate.query(sql, new KpiRecordableDateMapper());
		
		return kpiRecordableDates;
	}


	@Override
	public void delete(int id) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		String sql="delete from [kpiRecordableDate] where id=?";
		jdbcTemplate.update(sql,new Object[]{id});
		
	}


	@Override
	public KpiRecordableDate getLastKpiRecordableDate() {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		String sql="select TOP 1 * from [kpiRecordableDate] order by [Date] desc";
		
		KpiRecordableDate kpiRecordableDate=jdbcTemplate.queryForObject(sql, new KpiRecordableDateMapper());
		
		return kpiRecordableDate;
	}

}

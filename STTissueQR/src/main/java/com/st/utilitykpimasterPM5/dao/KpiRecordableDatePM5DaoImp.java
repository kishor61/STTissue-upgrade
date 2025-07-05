/**
 *Mar 21, 2018
 *KpiRecordableDatePM5DaoImp.java
 * TODO
 *com.st.utilitykpimasterPM5.dao
 *KpiRecordableDatePM5DaoImp.java
 *Roshan Lal Tailor
 */
package com.st.utilitykpimasterPM5.dao;

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
 * @author roshan
 *
 */
@Repository
public class KpiRecordableDatePM5DaoImp implements KpiRecordableDatePM5Dao {

	@Autowired
	private DataSource dataSource;

	/* (non-Javadoc)
	 * @see com.st.utilitykpimasterPM5.dao.KpiRecordableDatePM5Dao#getKpiRecordableDate()
	 */
	@Override
	public List<KpiRecordableDate> getKpiRecordableDate() {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		String sql="select * from [kpiRecordableDate_PM5] order by [Date] desc";
		
		List<KpiRecordableDate> kpiRecordableDates=jdbcTemplate.query(sql, new KpiRecordableDateMapper());
		
		return kpiRecordableDates;
	}

	/* (non-Javadoc)
	 * @see com.st.utilitykpimasterPM5.dao.KpiRecordableDatePM5Dao#save(com.st.utilitykpimaster.model.KpiRecordableDate)
	 */
	@Override
	public int save(final KpiRecordableDate kpiRecordableDate) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		KeyHolder holder=new GeneratedKeyHolder();
		final String sql="insert into [kpiRecordableDate_PM5]"
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

	/* (non-Javadoc)
	 * @see com.st.utilitykpimasterPM5.dao.KpiRecordableDatePM5Dao#delete(int)
	 */
	@Override
	public void delete(int id) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		String sql="delete from [kpiRecordableDate_PM5] where id=?";
		jdbcTemplate.update(sql,new Object[]{id});
		
	}

}

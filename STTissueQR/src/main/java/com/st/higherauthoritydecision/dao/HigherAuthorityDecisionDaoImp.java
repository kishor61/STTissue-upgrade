/**
 *Dec 7, 2016
 *HigherAuthorityDecisionDaoImp.java
 * TODO
 *com.st.higherauthoritydecision.dao
 *HigherAuthorityDecisionDaoImp.java
 *Roshan Lal Tailor
 */
package com.st.higherauthoritydecision.dao;

import java.sql.Connection;
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
import org.springframework.stereotype.Repository;

import com.st.higherauthoritydecision.model.HigherAuthorityDecision;

/**
 * @author roshan
 *
 */
@Repository
public class HigherAuthorityDecisionDaoImp implements HigherAuthorityDecisionDao {

	
	@Autowired
	private DataSource dataSource;
	/* (non-Javadoc)
	 * @see com.st.higherauthoritydecision.dao.HigherAuthorityDecisionDao#getdata()
	 */
	@Override
	public List<HigherAuthorityDecision> getdata() {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		String sql="select * from autoMailFiringStatus ";
		List<HigherAuthorityDecision> fpLists=jdbcTemplate.query(sql, new Object[]{},new RowMapper<HigherAuthorityDecision>(){

			@Override
			public HigherAuthorityDecision mapRow(ResultSet rs, int arg1)
					throws SQLException {
				HigherAuthorityDecision fpList=new HigherAuthorityDecision();
				//fpList.setId(rs.getInt("ID"));
				fpList.setId(rs.getInt("id"));
				fpList.setStatus(rs.getString("status"));
				return fpList;
			}});
		
		
		return fpLists;
	}
	/* (non-Javadoc)
	 * @see com.st.higherauthoritydecision.dao.HigherAuthorityDecisionDao#getdata(int)
	 */
	@Override
	public List<HigherAuthorityDecision> getdata(int i) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		String sql="select * from autoMailFiringStatus where id=? ";
		List<HigherAuthorityDecision> fpLists=jdbcTemplate.query(sql, new Object[]{i},new RowMapper<HigherAuthorityDecision>(){

			@Override
			public HigherAuthorityDecision mapRow(ResultSet rs, int arg1)
					throws SQLException {
				HigherAuthorityDecision fpList=new HigherAuthorityDecision();
				//fpList.setId(rs.getInt("ID"));
				fpList.setId(rs.getInt("id"));
				fpList.setStatus(rs.getString("status"));
				return fpList;
			}});
		
		
		return fpLists;
	}
	/* (non-Javadoc)
	 * @see com.st.higherauthoritydecision.dao.HigherAuthorityDecisionDao#updateStatusForMails(com.st.higherauthoritydecision.model.HigherAuthorityDecision)
	 */
	@Override
	public void updateStatusForMails(final HigherAuthorityDecision had) {
		// TODO Auto-generated method stub


		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		final String sql="update autoMailFiringStatus set "
				+"[status]=?"
				+ " where [ID]=?";
		
		jdbcTemplate.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection arg0)
					throws SQLException {
				PreparedStatement statement=arg0.prepareStatement(sql);
				statement.setString(1,had.getStatus());
				statement.setInt(2, had.getId());
				return statement;
			}
		});
	
	}

}

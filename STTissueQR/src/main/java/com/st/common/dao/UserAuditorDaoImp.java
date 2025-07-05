/**
 * 
 */
package com.st.common.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.st.common.model.UserAuditor;

/**
 * @author sbora
 *
 */
@Repository
public class UserAuditorDaoImp implements UserAuditorDao{

	@Autowired
	private JdbcTemplate dataSourceQRTTemplate;

	/* (non-Javadoc)
	 * @see com.st.common.dao.UserAutiorDao#getUserAutiors()
	 */
	@Override
	public List<UserAuditor> getUserAutiors() {
		String sql="select * from [userAuditor]";
		List<UserAuditor> autiors=dataSourceQRTTemplate.query(sql, new RowMapper<UserAuditor>(){

			@Override
			public UserAuditor mapRow(ResultSet rs, int arg1)
					throws SQLException {
				UserAuditor autior=new UserAuditor();
				autior.setId(rs.getInt("ID"));
				autior.setName(rs.getString("name"));
				autior.setEmail(rs.getString("email"));
				autior.setStatus(rs.getString("status"));
				
				return autior;
			}
			
		});
		
		return autiors;
	}

	
	@Override
	public void saveOrUpdate(UserAuditor auditor) {
		if(auditor.getId()==0){
			String sql="insert into [userAuditor]("
					+ "[name],"
					+ "[email],"
					+ "[status]"
					+ ") values(?,?,?)";
			dataSourceQRTTemplate.update(sql, new Object[]{auditor.getName(),auditor.getEmail(),"Active"});
		}else{
			String sql="update [userAuditor] set "
					+ "[name]=?,"
					+ "[email]=? "
					+ " where [ID]=?";
			dataSourceQRTTemplate.update(sql, new Object[]{auditor.getName(),auditor.getEmail(),auditor.getId()});
		}
	}


	/* (non-Javadoc)
	 * @see com.st.common.dao.UserAuditorDao#getUserAuditor(int)
	 */
	@Override
	public UserAuditor getUserAuditor(int id) {
		
		String sql="select * from [userAuditor] where [ID]=? ";
		UserAuditor autior=dataSourceQRTTemplate.queryForObject(sql,new Object[]{id}, new RowMapper<UserAuditor>(){

			@Override
			public UserAuditor mapRow(ResultSet rs, int arg1)
					throws SQLException {
				UserAuditor autior=new UserAuditor();
				autior.setId(rs.getInt("ID"));
				autior.setName(rs.getString("name"));
				autior.setEmail(rs.getString("email"));
				
				return autior;
			}
			
		});
		return autior;
		
	}


	/* (non-Javadoc)
	 * @see com.st.common.dao.UserAuditorDao#editAuditorStatus(com.st.common.model.UserAuditor)
	 */
	@Override
	public void editAuditorStatus(final UserAuditor data) {
		final String sql="update [userAuditor] set "
				+"[status]=?"
				+ " where [email]=?";
		
		dataSourceQRTTemplate.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection arg0)
					throws SQLException {
				PreparedStatement statement=arg0.prepareStatement(sql);
				statement.setString(1, data.getStatus());
				statement.setString(2, data.getEmail());
				return statement;
			}
		});
		
	}


	/* (non-Javadoc)
	 * @see com.st.common.dao.UserAuditorDao#getUserAutiorsActive()
	 */
	@Override
	public List<UserAuditor> getUserAutiorsActive() {
		String sql="select * from [userAuditor] where status='Active' ";
		List<UserAuditor> autiors=dataSourceQRTTemplate.query(sql, new RowMapper<UserAuditor>(){

			@Override
			public UserAuditor mapRow(ResultSet rs, int arg1)
					throws SQLException {
				UserAuditor autior=new UserAuditor();
				autior.setId(rs.getInt("ID"));
				autior.setName(rs.getString("name"));
				autior.setEmail(rs.getString("email"));
				autior.setStatus(rs.getString("status"));
				
				return autior;
			}
			
		});
		
		return autiors;
	}
	
}

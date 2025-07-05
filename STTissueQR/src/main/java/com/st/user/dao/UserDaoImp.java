package com.st.user.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.st.user.mapper.UserMapper;
import com.st.user.model.User;

@Repository
public class UserDaoImp implements UserDao {

	@Autowired
	private JdbcTemplate dataSourceQRTTemplate;
	 
	@Override
	public User getUser(String username) {
		String sql="select * from [user] where [username]=?";
		User user=(User)dataSourceQRTTemplate.queryForObject(sql,new Object[]{
				username
		},new UserMapper());
		return user;
	}

}

package com.st.qualitypm6.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerDaoImp implements CustomerDao{

	@Autowired
	private DataSource dataSource;
	
	@Override
	public List<String> getCustomers() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		String sql = "select DISTINCT([name]) from [customerDetail]";

		@SuppressWarnings({ "unchecked", "rawtypes" })
		List<String> customers = jdbcTemplate.query(sql, new RowMapper() {
			@Override
			public Object mapRow(ResultSet rs, int arg1) throws SQLException {
				return rs.getString(1);
			}
		});

		return customers;
	}

	@Override
	public void saveCustomer(String name, String location, String city,
			String state) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String sql="insert into [customerDetail](name,location,city,state) "
				+ "values(?,?,?,?)";
		jdbcTemplate.update(sql, new Object[]{name,location,city,state});
	}

	@Override
	public List<Map<String, Object>> getCustomersFullInfo() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		String sql = "select * from [customerDetail]";
		List<Map<String, Object>> maps=new ArrayList<>();
		try {
			maps=jdbcTemplate.queryForList(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return maps;
	}
	
	

	@Override
	public void delete(List<String> customerIds) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		for (String string : customerIds) {
			String sql = "delete from [customerDetail] where [ID]='"+string+"'";
			jdbcTemplate.update(sql);
		}
		
	}

	
	@Override
	public void updateCustomer(int id, String name, String location,
			String city, String state) {

			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			String sql="update [customerDetail]"
					+ "set "
					+ "name=?,"
					+ "location=?,"
					+ "city=?,"
					+ "state=?  "
					+ " where [ID]=?";
			jdbcTemplate.update(sql, new Object[]{name,location,city,state,id});
	}

	
	@Override
	public List<Map<String, Object>> getCustomerById(int id) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		String sql = "select * from [customerDetail] where [ID]=?";
		List<Map<String, Object>> maps=new ArrayList<>();
		try {
			maps=jdbcTemplate.queryForList(sql,new Object[]{id});
		} catch (Exception e) {
			e.printStackTrace();
		}
		return maps;
	}

}

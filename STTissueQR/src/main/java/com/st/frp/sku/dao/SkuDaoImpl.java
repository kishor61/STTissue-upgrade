/**
 *Mar 24, 2017
 *SkuDaoImpl.java
 * TODO
 *com.st.frp.sku.dao
 *SkuDaoImpl.java
 *Roshan Lal Tailor
 */
package com.st.frp.sku.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.st.frp.sku.model.SkuModel;
import com.st.frp.sku.model.SkuProductCodeModel;
import com.st.obcc.model.R1Operator;
import com.st.obcc.model.UtilityOperator;

/**
 * @author roshan
 *
 */
@Repository
public class SkuDaoImpl implements SkuDao {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.st.frp.sku.dao.SkuDao#save(java.lang.String)
	 */

	@Autowired
	private DataSource dataSource;

	@Override
	public void save(String name,String address1,String address2,String city,String state,String zip) {
		// TODO Auto-generated method stub
	String sql = "insert into sku_customer(name,address1,address2,city,state,zip) values(?,?,?,?,?,?)";
	JdbcTemplate  JdbcTemplate = new JdbcTemplate(dataSource);
	JdbcTemplate.update(sql, new Object[] { name,address1,address2,city,state,zip});
	}
	
	/* (non-Javadoc)
	 * @see com.st.frp.sku.dao.SkuDao#update(java.lang.String, int)
	 */
	@Override
	public void update(String name,String address1,String address2,String city,String state,String zip,int id) {
		// TODO Auto-generated method stub
		
	String sql = "update sku_customer set name = ?,address1 = ?,address2 = ?,city = ?,state = ?,zip = ? where id=?";
	JdbcTemplate  JdbcTemplate = new JdbcTemplate(dataSource);
	JdbcTemplate.update(sql, new Object[] { name,address1,address2,city,state,zip,id});	
	}
	 
	
	/* (non-Javadoc)
	 * @see com.st.frp.sku.dao.SkuDao#getCustomerNameList()
	 */
	@Override
	public List<SkuModel> getCustomerNameList() {
		// TODO Auto-generated method stub
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String sql = "select * from [sku_customer]";
		List<SkuModel> skuModel = null;
		try {
			skuModel = jdbcTemplate.query(sql, new RowMapper<SkuModel>(){

						@Override
						public SkuModel mapRow(ResultSet rs, int arg1)
								throws SQLException {
							SkuModel data = new SkuModel();
							data.setId(rs.getInt("id"));
							data.setName(rs.getString("name"));
							data.setAddress1(rs.getString("address1"));
							data.setAddress2(rs.getString("address2"));
							data.setCity(rs.getString("city"));
							data.setState(rs.getString("state"));
							data.setZip(rs.getString("zip"));
						return data;
						}

					});
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return skuModel;
	}
	
	/* (non-Javadoc)
	 * @see com.st.frp.sku.dao.SkuDao#deleteCust(int)
	 */
	@Override
	public void deleteCust(int id) {
		// TODO Auto-generated method stub
		
		String sql = "delete sku_customer  where id=?";
		JdbcTemplate  JdbcTemplate = new JdbcTemplate(dataSource);
		JdbcTemplate.update(sql, new Object[] {id});	
		
	}
 
	/* (non-Javadoc)
	 * @see com.st.frp.sku.dao.SkuDao#saveProductCode(java.lang.String)
	 */
	@Override
	public void saveProductCode(String productCode) {
		// TODO Auto-generated method stub
		String sql = "insert into sku_productCode(product_code) values(?)";
		JdbcTemplate  JdbcTemplate = new JdbcTemplate(dataSource);
		JdbcTemplate.update(sql, new Object[] { productCode});
	}
	/* (non-Javadoc)
	 * @see com.st.frp.sku.dao.SkuDao#updateProductCode(java.lang.String, int)
	 */
	@Override
	public void updateProductCode(String productCode, int id) {
		// TODO Auto-generated method stub
		String sql = "update sku_productCode set product_code = ? where id=?";
		JdbcTemplate  JdbcTemplate = new JdbcTemplate(dataSource);
		JdbcTemplate.update(sql, new Object[] { productCode,id});	
	}
	
	/* (non-Javadoc)
	 * @see com.st.frp.sku.dao.SkuDao#getProductCodeList()
	 */
	@Override
	public List<SkuProductCodeModel> getProductCodeList() {
		// TODO Auto-generated method stub
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String sql = "select * from [sku_productCode]";
		List<SkuProductCodeModel> skuProductCodeModel = null;
		try {
			skuProductCodeModel = jdbcTemplate.query(sql, new RowMapper<SkuProductCodeModel>(){

						@Override
						public SkuProductCodeModel mapRow(ResultSet rs, int arg1)
								throws SQLException {
							SkuProductCodeModel data = new SkuProductCodeModel();
							data.setId(rs.getInt("id"));
							data.setProductCode(rs.getString("product_code"));
						return data;
						}

					});
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return skuProductCodeModel;
	}
	
	
	/* (non-Javadoc)
	 * @see com.st.frp.sku.dao.SkuDao#deleteProdCode(int)
	 */
	@Override
	public void deleteProdCode(int id) {
		// TODO Auto-generated method stub
		String sql = "delete sku_productCode  where id=?";
		JdbcTemplate  JdbcTemplate = new JdbcTemplate(dataSource);
		JdbcTemplate.update(sql, new Object[] {id});
	}
	
	
	
	
	
}

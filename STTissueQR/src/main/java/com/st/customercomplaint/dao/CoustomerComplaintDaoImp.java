/**
 *Oct 27, 2015
 *CoustomerComplaintDaoImp.java
 * TODO
 *com.st.customercomplaint.dao
 *CoustomerComplaintDaoImp.java
 *Sunil Singh Bora
 */
package com.st.customercomplaint.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.st.centerline.mapper.CenterlineGradeMapper;
import com.st.centerline.model.CenterlineGrade;
import com.st.customercomplaint.model.CustomerComplaint;
import com.st.customercomplaint.mapper.*;
import com.st.efficiency.mapper.SecondaryCodeMapper;
import com.st.efficiency.model.SecondaryCode;
import com.st.frpyield.mapper.FrpYieldMapper;
import com.st.frpyield.model.FrpYield;
/**
 * @author roshan
 *
 */

@Repository
public class CoustomerComplaintDaoImp implements CoustomerComplaintDao {
	
	@Autowired
	private DataSource dataSource;
	@Autowired
	@Qualifier("dataSourceTracker")
	private DataSource dataSourceT;

	/* (non-Javadoc)
	 * @see com.st.customercomplaint.dao.CoustomerComplaintDao#getCustomerComplaint(java.util.Date, java.util.Date)
	 */
	@Override
		public List<CustomerComplaint> getCustomerComplaint(Date sdate, Date edate) {
			JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
			
		Calendar scal=Calendar.getInstance();
		scal.setTime(sdate);
		
		Calendar ecal=Calendar.getInstance();
		ecal.setTime(edate);
		ecal.add(Calendar.DATE, 1);
		
		
		String sql="select * from [customercomplaint] where "
				+ "([dates] between ? and ?) order by [dates]";
		/*String sql="select * from [frpRfTesting] order by [Date]";*/
		List<CustomerComplaint> customercomplaintdatas=jdbcTemplate.query(sql, new Object[]{
				new Timestamp(scal.getTime().getTime()),
				new Timestamp(ecal.getTime().getTime())
		},new CustomerComplaintMapper());
		return customercomplaintdatas;
}

	/* (non-Javadoc)
	 * @see com.st.customercomplaint.dao.CoustomerComplaintDao#save(com.st.customercomplaint.model.CustomerComplaint)
	 */
	@Override
	public int save(final CustomerComplaint complaint) {
		// TODO Auto-generated method stub
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		KeyHolder keyHolder=new GeneratedKeyHolder();
		
		final String sql="insert into [customercomplaint]"
				+ "("
				+"[dates],"
				+"[Description],"
				+"[Grade],"
				+"[Customer],"
				+"[Type],"
				+"[Proddate],"
				+"[Remarks],"
				+"[Resp],"
				+"[Targetdate],"
				+"[Status],"
				+"[attachment],"
				+"[kaizen],"
				+"[complaintissue],"
				+"[correctiveaction]"
				+ ")"
				+ " values("
				+ "?,"
				+ "?,"
				+ "?,?,?,?,?,?,?,?,?,?,?,?"	
				+ ")";
		
		jdbcTemplate.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection arg0)
					throws SQLException {
				PreparedStatement statement=arg0.prepareStatement(sql,new String[]{"ID"});
				statement.setTimestamp(1, new Timestamp(complaint.getDate().getTime()));
				statement.setString(2,complaint.getDescription());
				statement.setString(3,complaint.getGrade());
				statement.setString(4,complaint.getCustomer());
				statement.setString(5,complaint.getType());
				statement.setTimestamp(6, new Timestamp(complaint.getProddate().getTime()));
				statement.setString(7, complaint.getRemarks());
				statement.setString(8, complaint.getResp());
				statement.setTimestamp(9, new Timestamp(complaint.getTargetdate().getTime()));
				statement.setString(10, complaint.getStatus());
				
				statement.setString(11, complaint.getAttachment());
				statement.setString(12, complaint.getKaizen());
				
				statement.setString(13, complaint.getComplaintissue());
				statement.setString(14, complaint.getCorrectiveaction());
				
				return statement;
			}
		},keyHolder);
		
		return keyHolder.getKey().intValue();
	}

	/* (non-Javadoc)
	 * @see com.st.customercomplaint.dao.CoustomerComplaintDao#update(com.st.customercomplaint.model.CustomerComplaint)
	 */
	@Override
	public void update(final CustomerComplaint complaint) {

		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		final String sql="update [customercomplaint] set "
				+"[dates]=?,"
				+"[Description]=?,"
				+"[Grade]=?,"
				+"[Customer]=?,"
				+"[Type]=?,"
				+"[Proddate]=?,"
				+"[Remarks]=?,"
				+"[Resp]=?,"
				+"[Targetdate]=?,"
				+"[Status]=?,"
				+"[attachment]=?,"
				+"[kaizen]=?,"
				+"[complaintissue]=?,"
				+"[correctiveaction]=?"
				+ " where [ID]=?";
		
		jdbcTemplate.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection arg0)
					throws SQLException {
				PreparedStatement statement=arg0.prepareStatement(sql);
				statement.setTimestamp(1, new Timestamp(complaint.getDate().getTime()));
				statement.setString(2,complaint.getDescription());
				statement.setString(3,complaint.getGrade());
				statement.setString(4,complaint.getCustomer());
				statement.setString(5,complaint.getType());
				statement.setTimestamp(6, new Timestamp(complaint.getProddate().getTime()));
				statement.setString(7, complaint.getRemarks());
				statement.setString(8, complaint.getResp());
				statement.setTimestamp(9, new Timestamp(complaint.getTargetdate().getTime()));
				statement.setString(10, complaint.getStatus());
				
				statement.setString(11, complaint.getAttachment());
				statement.setString(12, complaint.getKaizen());
				
				statement.setString(13, complaint.getComplaintissue());
				statement.setString(14, complaint.getCorrectiveaction());
				
				statement.setInt(15, complaint.getId());
				return statement;
			}
		});
	}

	/* (non-Javadoc)
	 * @see com.st.customercomplaint.dao.CoustomerComplaintDao#getComplaintCustomerReport(java.util.Date, java.util.Date)
	 */
	@Override
	public List<CustomerComplaint> getComplaintCustomerReport(Date sdate,
			Date edate) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		String sql="Select * From [customercomplaint] where [dates] between ? And ? ";
		List<CustomerComplaint> codes=jdbcTemplate.query(sql,new Object[]{sdate,edate}, new CustomerComplaintMapper());
		return codes;
	}

	/* (non-Javadoc)
	 * @see com.st.customercomplaint.dao.CoustomerComplaintDao#delete(int)
	 */
	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		String sql="delete from [customercomplaint] where [ID]=?";
		jdbcTemplate.update(sql, new Object[]{id});
	}

	/* (non-Javadoc)
	 * @see com.st.customercomplaint.dao.CoustomerComplaintDao#editComplaintCustomerReport(int)
	 */
	@Override
	public List<CustomerComplaint> editComplaintCustomerReport(int id) {
		// TODO Auto-generated method stub
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		String sql="select * from [customercomplaint] where ([id])=?";
		List<CustomerComplaint> cc= jdbcTemplate.query(sql,new Object[]{id}, new CustomerComplaintMapper());
		return cc;
	}


}

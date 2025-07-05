/**
 *Oct 27, 2015
 *CustomerComplaintMapper.java
 * TODO
 *com.st.customercomplaint.mapper
 *CustomerComplaintMapper.java
 *Sunil Singh Bora
 */
package com.st.customercomplaint.mapper;

import org.springframework.jdbc.core.RowMapper;

//import com.healthmarketscience.jackcess.Row;
import com.st.customercomplaint.model.CustomerComplaint;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
/**
 * @author roshan
 *
 */
public class CustomerComplaintMapper implements RowMapper<CustomerComplaint>{

	/* (non-Javadoc)
	 * @see org.springframework.jdbc.core.RowMapper#mapRow(java.sql.ResultSet, int)
	 */
	@Override
	public CustomerComplaint mapRow(ResultSet rs, int arg1)
			throws SQLException {
		// TODO Auto-generated method stub
		CustomerComplaint cc=new CustomerComplaint();
		cc.setId(rs.getInt("ID"));
		cc.setDate(new Date(rs.getTimestamp("dates").getTime()));
		cc.setDescription(rs.getString("Description"));
		cc.setGrade(rs.getString("Grade"));
		cc.setCustomer(rs.getString("Customer"));
		cc.setType(rs.getString("Type"));
		cc.setProddate(new Date(rs.getTimestamp("Proddate").getTime()));
		cc.setRemarks(rs.getString("Remarks"));
		cc.setResp(rs.getString("Resp"));
		cc.setTargetdate(new Date(rs.getTimestamp("Targetdate").getTime()));
		cc.setStatus(rs.getString("Status"));
		
		cc.setAttachment(rs.getString("attachment"));
		cc.setKaizen(rs.getString("kaizen"));
		cc.setComplaintissue(rs.getString("complaintissue"));
		cc.setCorrectiveaction(rs.getString("correctiveaction"));
		
		return cc;
	}

}

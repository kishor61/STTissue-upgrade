/**
 *07-Dec-2019
 *OpRoute_9DaoImp.java
 * TODO
 *com.st.frpobcc.dao
 *OpRoute_9DaoImp.java
 *Sohan Lal Bairwa
 */
package com.st.frpobcc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.st.common.DatabaseUtil;
import com.st.frpobcc.model.OpRoute_9;

/**
 * @author sohan
 *
 */
@Repository
public class OpRoute_9DaoImp implements OpRoute_9Dao {

	@Autowired
	@Qualifier("dataSourceOBCC")
	private DataSource dataSourceQRT;
	/* (non-Javadoc)
	 * @see com.st.frpobcc.dao.OpRoute_9Dao#saveorUpdate(com.st.frpobcc.model.OpRoute_9)
	 */
	@Override
	public void saveorUpdate(OpRoute_9 data) {
		NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(dataSourceQRT);
	 	MapSqlParameterSource paramSource=new MapSqlParameterSource();
		
		paramSource.addValue("position",data.getPosition());
		paramSource.addValue("date",data.getDate());
		paramSource.addValue("crew",data.getCrew());
		paramSource.addValue("machinedown",data.isMachinedown());
		
		paramSource.addValue("comments",data.getComments());
		paramSource.addValue("cmt9amarea", data.getCmt9amarea());
		paramSource.addValue("cmt1pmarea", data.getCmt1pmarea());
		paramSource.addValue("cmt5pmarea", data.getCmt5pmarea());
		paramSource.addValue("cmt9pmarea", data.getCmt9pmarea());
		paramSource.addValue("cmt1amarea", data.getCmt1amarea());
		paramSource.addValue("cmt5amarea", data.getCmt5amarea());
		paramSource.addValue("ok",data.getOk());
		paramSource.addValue("button1pm",data.getButton1pm());
		paramSource.addValue("button5pm",data.getButton5pm());
		paramSource.addValue("button9pm",data.getButton9pm());
		paramSource.addValue("button1am",data.getButton1am());
		paramSource.addValue("button5am",data.getButton5am());			
		paramSource.addValue("techniciansinitials1",data.getTechniciansinitials1());
		paramSource.addValue("techniciansinitials2",data.getTechniciansinitials2());	
		paramSource.addValue("techniciansinitials3",data.getTechniciansinitials3());	
		paramSource.addValue("techniciansinitials4",data.getTechniciansinitials4());	
		paramSource.addValue("techniciansinitials5",data.getTechniciansinitials5());	
		paramSource.addValue("techniciansinitials6",data.getTechniciansinitials6());	
		paramSource.addValue("techniciansinitials7",data.getTechniciansinitials7());
		paramSource.addValue("oproute_9b_linebasement1_10am",data.getOproute_9b_linebasement1_10am());
		paramSource.addValue("oproute_9b_linebasement1_2pm",data.getOproute_9b_linebasement1_2pm());
		paramSource.addValue("oproute_9b_linebasement1_6pm",data.getOproute_9b_linebasement1_6pm());
		paramSource.addValue("oproute_9b_linebasement1_10pm",data.getOproute_9b_linebasement1_10pm());
		paramSource.addValue("oproute_9b_linebasement1_2am",data.getOproute_9b_linebasement1_2am());
		paramSource.addValue("oproute_9b_linebasement1_6am",data.getOproute_9b_linebasement1_6am());
		paramSource.addValue("oproute_9b_linebasement2_10am",data.getOproute_9b_linebasement2_10am());
		paramSource.addValue("oproute_9b_linebasement2_2pm",data.getOproute_9b_linebasement2_2pm());
		paramSource.addValue("oproute_9b_linebasement2_6pm",data.getOproute_9b_linebasement2_6pm());
		paramSource.addValue("oproute_9b_linebasement2_10pm",data.getOproute_9b_linebasement2_10pm());
		paramSource.addValue("oproute_9b_linebasement2_2am",data.getOproute_9b_linebasement2_2am());
		paramSource.addValue("oproute_9b_linebasement2_6am",data.getOproute_9b_linebasement2_6am());
		paramSource.addValue("oproute_9b_linebasement3_10am",data.getOproute_9b_linebasement3_10am());
		paramSource.addValue("oproute_9b_linebasement3_2pm",data.getOproute_9b_linebasement3_2pm());
		paramSource.addValue("oproute_9b_linebasement3_6pm",data.getOproute_9b_linebasement3_6pm());
		paramSource.addValue("oproute_9b_linebasement3_10pm",data.getOproute_9b_linebasement3_10pm());
		paramSource.addValue("oproute_9b_linebasement3_2am",data.getOproute_9b_linebasement3_2am());
		paramSource.addValue("oproute_9b_linebasement3_6am",data.getOproute_9b_linebasement3_6am());
		paramSource.addValue("oproute_9b_linebasement4_10am",data.getOproute_9b_linebasement4_10am());
		paramSource.addValue("oproute_9b_linebasement4_2pm",data.getOproute_9b_linebasement4_2pm());
		paramSource.addValue("oproute_9b_linebasement4_6pm",data.getOproute_9b_linebasement4_6pm());
		paramSource.addValue("oproute_9b_linebasement4_10pm",data.getOproute_9b_linebasement4_10pm());
		paramSource.addValue("oproute_9b_linebasement4_2am",data.getOproute_9b_linebasement4_2am());
		paramSource.addValue("oproute_9b_linebasement4_6am",data.getOproute_9b_linebasement4_6am());	
		paramSource.addValue("oproute_9b_linebasement5_10am",data.getOproute_9b_linebasement5_10am());
		paramSource.addValue("oproute_9b_linebasement5_2pm",data.getOproute_9b_linebasement5_2pm());
		paramSource.addValue("oproute_9b_linebasement5_6pm",data.getOproute_9b_linebasement5_6pm());
		paramSource.addValue("oproute_9b_linebasement5_10pm",data.getOproute_9b_linebasement5_10pm());
		paramSource.addValue("oproute_9b_linebasement5_2am",data.getOproute_9b_linebasement5_2am());
		paramSource.addValue("oproute_9b_linebasement5_6am",data.getOproute_9b_linebasement5_6am());
		paramSource.addValue("oproute_9b_linebasement6_10am",data.getOproute_9b_linebasement6_10am());
		paramSource.addValue("oproute_9b_linebasement6_2pm",data.getOproute_9b_linebasement6_2pm());
		paramSource.addValue("oproute_9b_linebasement6_6pm",data.getOproute_9b_linebasement6_6pm());
		paramSource.addValue("oproute_9b_linebasement6_10pm",data.getOproute_9b_linebasement6_10pm());
		paramSource.addValue("oproute_9b_linebasement6_2am",data.getOproute_9b_linebasement6_2am());
		paramSource.addValue("oproute_9b_linebasement6_6am",data.getOproute_9b_linebasement6_6am());
		paramSource.addValue("oproute_9b_linebasement7_10am",data.getOproute_9b_linebasement7_10am());
		paramSource.addValue("oproute_9b_linebasement7_2pm",data.getOproute_9b_linebasement7_2pm());
		paramSource.addValue("oproute_9b_linebasement7_6pm",data.getOproute_9b_linebasement7_6pm());
		paramSource.addValue("oproute_9b_linebasement7_10pm",data.getOproute_9b_linebasement7_10pm());
		paramSource.addValue("oproute_9b_linebasement7_2am",data.getOproute_9b_linebasement7_2am());
		paramSource.addValue("oproute_9b_linebasement7_6am",data.getOproute_9b_linebasement7_6am());
		paramSource.addValue("oproute_9b_linebasement8_10am",data.getOproute_9b_linebasement8_10am());
		paramSource.addValue("oproute_9b_linebasement8_2pm",data.getOproute_9b_linebasement8_2pm());
		paramSource.addValue("oproute_9b_linebasement8_6pm",data.getOproute_9b_linebasement8_6pm());
		paramSource.addValue("oproute_9b_linebasement8_10pm",data.getOproute_9b_linebasement8_10pm());
		paramSource.addValue("oproute_9b_linebasement8_2am",data.getOproute_9b_linebasement8_2am());
		paramSource.addValue("oproute_9b_linebasement8_6am",data.getOproute_9b_linebasement8_6am());
		paramSource.addValue("oproute_9b_linebasement9_10am",data.getOproute_9b_linebasement9_10am());
		paramSource.addValue("oproute_9b_linebasement9_2pm",data.getOproute_9b_linebasement9_2pm());
		paramSource.addValue("oproute_9b_linebasement9_6pm",data.getOproute_9b_linebasement9_6pm());
		paramSource.addValue("oproute_9b_linebasement9_10pm",data.getOproute_9b_linebasement9_10pm());
		paramSource.addValue("oproute_9b_linebasement9_2am",data.getOproute_9b_linebasement9_2am());
		paramSource.addValue("oproute_9b_linebasement9_6am",data.getOproute_9b_linebasement9_6am());	
		paramSource.addValue("oproute_9b_linebasement10_10am",data.getOproute_9b_linebasement10_10am());
		paramSource.addValue("oproute_9b_linebasement10_2pm",data.getOproute_9b_linebasement10_2pm());
		paramSource.addValue("oproute_9b_linebasement10_6pm",data.getOproute_9b_linebasement10_6pm());
		paramSource.addValue("oproute_9b_linebasement10_10pm",data.getOproute_9b_linebasement10_10pm());
		paramSource.addValue("oproute_9b_linebasement10_2am",data.getOproute_9b_linebasement10_2am());
		paramSource.addValue("oproute_9b_linebasement10_6am",data.getOproute_9b_linebasement10_6am());
		paramSource.addValue("oproute_9b_linebasement11_10am",data.getOproute_9b_linebasement11_10am());
		paramSource.addValue("oproute_9b_linebasement11_2pm",data.getOproute_9b_linebasement11_2pm());
		paramSource.addValue("oproute_9b_linebasement11_6pm",data.getOproute_9b_linebasement11_6pm());
		paramSource.addValue("oproute_9b_linebasement11_10pm",data.getOproute_9b_linebasement11_10pm());
		paramSource.addValue("oproute_9b_linebasement11_2am",data.getOproute_9b_linebasement11_2am());
		paramSource.addValue("oproute_9b_linebasement11_6am",data.getOproute_9b_linebasement11_6am());
		paramSource.addValue("oproute_9b_linebasement12_10am",data.getOproute_9b_linebasement12_10am());
		paramSource.addValue("oproute_9b_linebasement12_2pm",data.getOproute_9b_linebasement12_2pm());
		paramSource.addValue("oproute_9b_linebasement12_6pm",data.getOproute_9b_linebasement12_6pm());
		paramSource.addValue("oproute_9b_linebasement12_10pm",data.getOproute_9b_linebasement12_10pm());
		paramSource.addValue("oproute_9b_linebasement12_2am",data.getOproute_9b_linebasement12_2am());
		paramSource.addValue("oproute_9b_linebasement12_6am",data.getOproute_9b_linebasement12_6am());
		paramSource.addValue("oproute_9b_linebasement13_10am",data.getOproute_9b_linebasement13_10am());
		paramSource.addValue("oproute_9b_linebasement13_2pm",data.getOproute_9b_linebasement13_2pm());
		paramSource.addValue("oproute_9b_linebasement13_6pm",data.getOproute_9b_linebasement13_6pm());
		paramSource.addValue("oproute_9b_linebasement13_10pm",data.getOproute_9b_linebasement13_10pm());
		paramSource.addValue("oproute_9b_linebasement13_2am",data.getOproute_9b_linebasement13_2am());
		paramSource.addValue("oproute_9b_linebasement13_6am",data.getOproute_9b_linebasement13_6am());
		paramSource.addValue("oproute_9b_linebasement14_10am",data.getOproute_9b_linebasement14_10am());
		paramSource.addValue("oproute_9b_linebasement14_2pm",data.getOproute_9b_linebasement14_2pm());
		paramSource.addValue("oproute_9b_linebasement14_6pm",data.getOproute_9b_linebasement14_6pm());
		paramSource.addValue("oproute_9b_linebasement14_10pm",data.getOproute_9b_linebasement14_10pm());
		paramSource.addValue("oproute_9b_linebasement14_2am",data.getOproute_9b_linebasement14_2am());
		paramSource.addValue("oproute_9b_linebasement14_6am",data.getOproute_9b_linebasement14_6am());
		
		paramSource.addValue("cmt9amarea", data.getCmt9amarea());
		paramSource.addValue("cmt1pmarea", data.getCmt1pmarea());
		paramSource.addValue("cmt5pmarea", data.getCmt5pmarea());
		paramSource.addValue("cmt9pmarea", data.getCmt9pmarea());
		paramSource.addValue("cmt1amarea", data.getCmt1amarea());
		paramSource.addValue("cmt5amarea", data.getCmt5amarea());
		
		if (data.getId() == 0) {	
			
			String sql=DatabaseUtil.getSQL("sql/insertOpRoute_9.sql");
			jdbcTemplate.update(sql, paramSource);
		}	
		else
		{
			paramSource.addValue("id",data.getId());
			String sql=DatabaseUtil.getSQL("sql/updateOpRoute_9.sql");
			jdbcTemplate.update(sql, paramSource);
		}	
	}
	/* (non-Javadoc)
	 * @see com.st.frpobcc.dao.OpRoute_9Dao#getData(java.lang.String)
	 */
	@Override
	public List<OpRoute_9> getData(String sdate,String edate) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSourceQRT);
		String sql = "select * from [OpRoute_9] where date BETWEEN ? AND ?";
		List<OpRoute_9> oproute_9=null;
		try {
			oproute_9 = jdbcTemplate.query(sql, new Object[] {sdate,edate}, new RowMapper<OpRoute_9>() {

		@Override
		public OpRoute_9 mapRow(ResultSet rs, int arg1) throws SQLException {
		OpRoute_9 data=new OpRoute_9();
		data.setId (rs.getInt("id"));
		data.setPosition(rs.getString("position"));
		data.setDate(rs.getString("date"));
		data.setCrew(rs.getString("crew"));
		data.setComments(rs.getString("comments"));
		data.setTechniciansinitials1(rs.getString("techniciansinitials1"));
		data.setTechniciansinitials2(rs.getString("techniciansinitials2"));
		data.setTechniciansinitials3(rs.getString("techniciansinitials3"));
		data.setTechniciansinitials4(rs.getString("techniciansinitials4"));
		data.setTechniciansinitials5(rs.getString("techniciansinitials5"));
		data.setTechniciansinitials6(rs.getString("techniciansinitials6"));
		data.setTechniciansinitials7(rs.getString("techniciansinitials7"));
		data.setOproute_9b_linebasement1_10am(rs.getString("oproute_9b_linebasement1_10am"));
		data.setOproute_9b_linebasement1_2pm(rs.getString("oproute_9b_linebasement1_2pm"));
		data.setOproute_9b_linebasement1_6pm(rs.getString("oproute_9b_linebasement1_6pm"));
		data.setOproute_9b_linebasement1_10pm(rs.getString("oproute_9b_linebasement1_10pm"));
		data.setOproute_9b_linebasement1_2am(rs.getString("oproute_9b_linebasement1_2am"));
		data.setOproute_9b_linebasement1_6am(rs.getString("oproute_9b_linebasement1_6am"));
		data.setOproute_9b_linebasement2_10am(rs.getString("oproute_9b_linebasement2_10am"));
		data.setOproute_9b_linebasement2_2pm(rs.getString("oproute_9b_linebasement2_2pm"));
		data.setOproute_9b_linebasement2_6pm(rs.getString("oproute_9b_linebasement2_6pm"));
		data.setOproute_9b_linebasement2_10pm(rs.getString("oproute_9b_linebasement2_10pm"));
		data.setOproute_9b_linebasement2_2am(rs.getString("oproute_9b_linebasement2_2am"));
		data.setOproute_9b_linebasement2_6am(rs.getString("oproute_9b_linebasement2_6am"));
		data.setOproute_9b_linebasement3_10am(rs.getString("oproute_9b_linebasement3_10am"));
		data.setOproute_9b_linebasement3_2pm(rs.getString("oproute_9b_linebasement3_2pm"));
		data.setOproute_9b_linebasement3_6pm(rs.getString("oproute_9b_linebasement3_6pm"));
		data.setOproute_9b_linebasement3_10pm(rs.getString("oproute_9b_linebasement3_10pm"));
		data.setOproute_9b_linebasement3_2am(rs.getString("oproute_9b_linebasement3_2am"));
		data.setOproute_9b_linebasement3_6am(rs.getString("oproute_9b_linebasement3_6am"));
		data.setOproute_9b_linebasement4_10am(rs.getString("oproute_9b_linebasement4_10am"));
		data.setOproute_9b_linebasement4_2pm(rs.getString("oproute_9b_linebasement4_2pm"));
		data.setOproute_9b_linebasement4_6pm(rs.getString("oproute_9b_linebasement4_6pm"));
		data.setOproute_9b_linebasement4_10pm(rs.getString("oproute_9b_linebasement4_10pm"));
		data.setOproute_9b_linebasement4_2am(rs.getString("oproute_9b_linebasement4_2am"));
		data.setOproute_9b_linebasement4_6am(rs.getString("oproute_9b_linebasement4_6am"));
		data.setOproute_9b_linebasement5_10am(rs.getString("oproute_9b_linebasement5_10am"));
		data.setOproute_9b_linebasement5_2pm(rs.getString("oproute_9b_linebasement5_2pm"));
		data.setOproute_9b_linebasement5_6pm(rs.getString("oproute_9b_linebasement5_6pm"));
		data.setOproute_9b_linebasement5_10pm(rs.getString("oproute_9b_linebasement5_10pm"));
		data.setOproute_9b_linebasement5_2am(rs.getString("oproute_9b_linebasement5_2am"));
		data.setOproute_9b_linebasement5_6am(rs.getString("oproute_9b_linebasement5_6am"));
		data.setOproute_9b_linebasement6_10am(rs.getString("oproute_9b_linebasement6_10am"));
		data.setOproute_9b_linebasement6_2pm(rs.getString("oproute_9b_linebasement6_2pm"));
		data.setOproute_9b_linebasement6_6pm(rs.getString("oproute_9b_linebasement6_6pm"));
		data.setOproute_9b_linebasement6_10pm(rs.getString("oproute_9b_linebasement6_10pm"));
		data.setOproute_9b_linebasement6_2am(rs.getString("oproute_9b_linebasement6_2am"));
		data.setOproute_9b_linebasement6_6am(rs.getString("oproute_9b_linebasement6_6am"));
		data.setOproute_9b_linebasement7_10am(rs.getString("oproute_9b_linebasement7_10am"));
		data.setOproute_9b_linebasement7_2pm(rs.getString("oproute_9b_linebasement7_2pm"));
		data.setOproute_9b_linebasement7_6pm(rs.getString("oproute_9b_linebasement7_6pm"));
		data.setOproute_9b_linebasement7_10pm(rs.getString("oproute_9b_linebasement7_10pm"));
		data.setOproute_9b_linebasement7_2am(rs.getString("oproute_9b_linebasement7_2am"));
		data.setOproute_9b_linebasement7_6am(rs.getString("oproute_9b_linebasement7_6am"));
		data.setOproute_9b_linebasement8_10am(rs.getString("oproute_9b_linebasement8_10am"));
		data.setOproute_9b_linebasement8_2pm(rs.getString("oproute_9b_linebasement8_2pm"));
		data.setOproute_9b_linebasement8_6pm(rs.getString("oproute_9b_linebasement8_6pm"));
		data.setOproute_9b_linebasement8_10pm(rs.getString("oproute_9b_linebasement8_10pm"));
		data.setOproute_9b_linebasement8_2am(rs.getString("oproute_9b_linebasement8_2am"));
		data.setOproute_9b_linebasement8_6am(rs.getString("oproute_9b_linebasement8_6am"));
		data.setOproute_9b_linebasement9_10am(rs.getString("oproute_9b_linebasement9_10am"));
		data.setOproute_9b_linebasement9_2pm(rs.getString("oproute_9b_linebasement9_2pm"));
		data.setOproute_9b_linebasement9_6pm(rs.getString("oproute_9b_linebasement9_6pm"));
		data.setOproute_9b_linebasement9_10pm(rs.getString("oproute_9b_linebasement9_10pm"));
		data.setOproute_9b_linebasement9_2am(rs.getString("oproute_9b_linebasement9_2am"));
		data.setOproute_9b_linebasement9_6am(rs.getString("oproute_9b_linebasement9_6am"));
		data.setOproute_9b_linebasement10_10am(rs.getString("oproute_9b_linebasement10_10am"));
		data.setOproute_9b_linebasement10_2pm(rs.getString("oproute_9b_linebasement10_2pm"));
		data.setOproute_9b_linebasement10_6pm(rs.getString("oproute_9b_linebasement10_6pm"));
		data.setOproute_9b_linebasement10_10pm(rs.getString("oproute_9b_linebasement10_10pm"));
		data.setOproute_9b_linebasement10_2am(rs.getString("oproute_9b_linebasement10_2am"));
		data.setOproute_9b_linebasement10_6am(rs.getString("oproute_9b_linebasement10_6am"));
		data.setOproute_9b_linebasement11_10am(rs.getString("oproute_9b_linebasement11_10am"));
		data.setOproute_9b_linebasement11_2pm(rs.getString("oproute_9b_linebasement11_2pm"));
		data.setOproute_9b_linebasement11_6pm(rs.getString("oproute_9b_linebasement11_6pm"));
		data.setOproute_9b_linebasement11_10pm(rs.getString("oproute_9b_linebasement11_10pm"));
		data.setOproute_9b_linebasement11_2am(rs.getString("oproute_9b_linebasement11_2am"));
		data.setOproute_9b_linebasement11_6am(rs.getString("oproute_9b_linebasement11_6am"));
		data.setOproute_9b_linebasement12_10am(rs.getString("oproute_9b_linebasement12_10am"));
		data.setOproute_9b_linebasement12_2pm(rs.getString("oproute_9b_linebasement12_2pm"));
		data.setOproute_9b_linebasement12_6pm(rs.getString("oproute_9b_linebasement12_6pm"));
		data.setOproute_9b_linebasement12_10pm(rs.getString("oproute_9b_linebasement12_10pm"));
		data.setOproute_9b_linebasement12_2am(rs.getString("oproute_9b_linebasement12_2am"));
		data.setOproute_9b_linebasement12_6am(rs.getString("oproute_9b_linebasement12_6am"));
		data.setOproute_9b_linebasement13_10am(rs.getString("oproute_9b_linebasement13_10am"));
		data.setOproute_9b_linebasement13_2pm(rs.getString("oproute_9b_linebasement13_2pm"));
		data.setOproute_9b_linebasement13_6pm(rs.getString("oproute_9b_linebasement13_6pm"));
		data.setOproute_9b_linebasement13_10pm(rs.getString("oproute_9b_linebasement13_10pm"));
		data.setOproute_9b_linebasement13_2am(rs.getString("oproute_9b_linebasement13_2am"));
		data.setOproute_9b_linebasement13_6am(rs.getString("oproute_9b_linebasement13_6am"));
		data.setOproute_9b_linebasement14_10am(rs.getString("oproute_9b_linebasement14_10am"));
		data.setOproute_9b_linebasement14_2pm(rs.getString("oproute_9b_linebasement14_2pm"));
		data.setOproute_9b_linebasement14_6pm(rs.getString("oproute_9b_linebasement14_6pm"));
		data.setOproute_9b_linebasement14_10pm(rs.getString("oproute_9b_linebasement14_10pm"));
		data.setOproute_9b_linebasement14_2am(rs.getString("oproute_9b_linebasement14_2am"));
		data.setOproute_9b_linebasement14_6am(rs.getString("oproute_9b_linebasement14_6am"));
		
		data.setCmt9amarea(rs.getString("cmt9amarea"));
		data.setCmt1pmarea(rs.getString("cmt1pmarea"));
		data.setCmt5pmarea(rs.getString("cmt5pmarea"));
		data.setCmt9pmarea(rs.getString("cmt9pmarea"));
		data.setCmt1amarea(rs.getString("cmt1amarea"));
		data.setCmt5amarea(rs.getString("cmt5amarea"));
		data.setOk(rs.getString("ok"));
		data.setButton1pm(rs.getString("button1pm"));
		data.setButton5pm(rs.getString("button5pm"));
		data.setButton9pm(rs.getString("button9pm"));
		data.setButton1am(rs.getString("button1am"));
		data.setButton5am(rs.getString("button5am"));
		return data;
		}						
		 });
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return oproute_9;
	}
	@Override
	public long getCountDatePercentage(String sdate,String edate) throws Exception {
		
		int _10am=0,_2pm=0,_6pm=0,_10pm=0,_2am=0,_6am=0;
		long _10ampercent=0,_2pmpercent=0,_6pmpercent=0,_10pmpercent=0,_2ampercent=0,_6ampercent=0;
	 	long percent=0;
		List<OpRoute_9> lst= getData(sdate,edate);
		for(OpRoute_9 data:lst)
		{
			if(data.getOproute_9b_linebasement1_10am()!=null&&!data.getOproute_9b_linebasement1_10am().equals("")){_10am++;}
			if(data.getOproute_9b_linebasement2_10am()!=null&&!data.getOproute_9b_linebasement2_10am().equals("")){_10am++;}
			if(data.getOproute_9b_linebasement3_10am()!=null&&!data.getOproute_9b_linebasement3_10am().equals("")){_10am++;}
			if(data.getOproute_9b_linebasement4_10am()!=null&&!data.getOproute_9b_linebasement4_10am().equals("")){_10am++;}
			if(data.getOproute_9b_linebasement5_10am()!=null&&!data.getOproute_9b_linebasement5_10am().equals("")){_10am++;}
			if(data.getOproute_9b_linebasement6_10am()!=null&&!data.getOproute_9b_linebasement6_10am().equals("")){_10am++;}
			if(data.getOproute_9b_linebasement7_10am()!=null&&!data.getOproute_9b_linebasement7_10am().equals("")){_10am++;}
			if(data.getOproute_9b_linebasement8_10am()!=null&&!data.getOproute_9b_linebasement8_10am().equals("")){_10am++;}
			if(data.getOproute_9b_linebasement9_10am()!=null&&!data.getOproute_9b_linebasement9_10am().equals("")){_10am++;}
			if(data.getOproute_9b_linebasement10_10am()!=null&&!data.getOproute_9b_linebasement10_10am().equals("")){_10am++;}
			if(data.getOproute_9b_linebasement11_10am()!=null&&!data.getOproute_9b_linebasement11_10am().equals("")){_10am++;}
			if(data.getOproute_9b_linebasement12_10am()!=null&&!data.getOproute_9b_linebasement12_10am().equals("")){_10am++;}
			if(data.getOproute_9b_linebasement13_10am()!=null&&!data.getOproute_9b_linebasement13_10am().equals("")){_10am++;}
			if(data.getOproute_9b_linebasement14_10am()!=null&&!data.getOproute_9b_linebasement14_10am().equals("")){_10am++;}

			if(data.getOproute_9b_linebasement1_2pm()!=null&&!data.getOproute_9b_linebasement1_2pm().equals("")){_2pm++;}
			if(data.getOproute_9b_linebasement2_2pm()!=null&&!data.getOproute_9b_linebasement2_2pm().equals("")){_2pm++;}
			if(data.getOproute_9b_linebasement3_2pm()!=null&&!data.getOproute_9b_linebasement3_2pm().equals("")){_2pm++;}
			if(data.getOproute_9b_linebasement4_2pm()!=null&&!data.getOproute_9b_linebasement4_2pm().equals("")){_2pm++;}
			if(data.getOproute_9b_linebasement5_2pm()!=null&&!data.getOproute_9b_linebasement5_2pm().equals("")){_2pm++;}
			if(data.getOproute_9b_linebasement6_2pm()!=null&&!data.getOproute_9b_linebasement6_2pm().equals("")){_2pm++;}
			if(data.getOproute_9b_linebasement7_2pm()!=null&&!data.getOproute_9b_linebasement7_2pm().equals("")){_2pm++;}
			if(data.getOproute_9b_linebasement8_2pm()!=null&&!data.getOproute_9b_linebasement8_2pm().equals("")){_2pm++;}
			if(data.getOproute_9b_linebasement9_2pm()!=null&&!data.getOproute_9b_linebasement9_2pm().equals("")){_2pm++;}
			if(data.getOproute_9b_linebasement10_2pm()!=null&&!data.getOproute_9b_linebasement10_2pm().equals("")){_2pm++;}
			if(data.getOproute_9b_linebasement11_2pm()!=null&&!data.getOproute_9b_linebasement11_2pm().equals("")){_2pm++;}
			if(data.getOproute_9b_linebasement12_2pm()!=null&&!data.getOproute_9b_linebasement12_2pm().equals("")){_2pm++;}
			if(data.getOproute_9b_linebasement13_2pm()!=null&&!data.getOproute_9b_linebasement13_2pm().equals("")){_2pm++;}
			if(data.getOproute_9b_linebasement14_2pm()!=null&&!data.getOproute_9b_linebasement14_2pm().equals("")){_2pm++;}

			if(data.getOproute_9b_linebasement1_6pm()!=null&&!data.getOproute_9b_linebasement1_6pm().equals("")){_6pm++;}
			if(data.getOproute_9b_linebasement2_6pm()!=null&&!data.getOproute_9b_linebasement2_6pm().equals("")){_6pm++;}
			if(data.getOproute_9b_linebasement3_6pm()!=null&&!data.getOproute_9b_linebasement3_6pm().equals("")){_6pm++;}
			if(data.getOproute_9b_linebasement4_6pm()!=null&&!data.getOproute_9b_linebasement4_6pm().equals("")){_6pm++;}
			if(data.getOproute_9b_linebasement5_6pm()!=null&&!data.getOproute_9b_linebasement5_6pm().equals("")){_6pm++;}
			if(data.getOproute_9b_linebasement6_6pm()!=null&&!data.getOproute_9b_linebasement6_6pm().equals("")){_6pm++;}
			if(data.getOproute_9b_linebasement7_6pm()!=null&&!data.getOproute_9b_linebasement7_6pm().equals("")){_6pm++;}
			if(data.getOproute_9b_linebasement8_6pm()!=null&&!data.getOproute_9b_linebasement8_6pm().equals("")){_6pm++;}
			if(data.getOproute_9b_linebasement9_6pm()!=null&&!data.getOproute_9b_linebasement9_6pm().equals("")){_6pm++;}
			if(data.getOproute_9b_linebasement10_6pm()!=null&&!data.getOproute_9b_linebasement10_6pm().equals("")){_6pm++;}
			if(data.getOproute_9b_linebasement11_6pm()!=null&&!data.getOproute_9b_linebasement11_6pm().equals("")){_6pm++;}
			if(data.getOproute_9b_linebasement12_6pm()!=null&&!data.getOproute_9b_linebasement12_6pm().equals("")){_6pm++;}
			if(data.getOproute_9b_linebasement13_6pm()!=null&&!data.getOproute_9b_linebasement13_6pm().equals("")){_6pm++;}
			if(data.getOproute_9b_linebasement14_6pm()!=null&&!data.getOproute_9b_linebasement14_6pm().equals("")){_6pm++;}

			if(data.getOproute_9b_linebasement1_10pm()!=null&&!data.getOproute_9b_linebasement1_10pm().equals("")){_10pm++;}
			if(data.getOproute_9b_linebasement2_10pm()!=null&&!data.getOproute_9b_linebasement2_10pm().equals("")){_10pm++;}
			if(data.getOproute_9b_linebasement3_10pm()!=null&&!data.getOproute_9b_linebasement3_10pm().equals("")){_10pm++;}
			if(data.getOproute_9b_linebasement4_10pm()!=null&&!data.getOproute_9b_linebasement4_10pm().equals("")){_10pm++;}
			if(data.getOproute_9b_linebasement5_10pm()!=null&&!data.getOproute_9b_linebasement5_10pm().equals("")){_10pm++;}
			if(data.getOproute_9b_linebasement6_10pm()!=null&&!data.getOproute_9b_linebasement6_10pm().equals("")){_10pm++;}
			if(data.getOproute_9b_linebasement7_10pm()!=null&&!data.getOproute_9b_linebasement7_10pm().equals("")){_10pm++;}
			if(data.getOproute_9b_linebasement8_10pm()!=null&&!data.getOproute_9b_linebasement8_10pm().equals("")){_10pm++;}
			if(data.getOproute_9b_linebasement9_10pm()!=null&&!data.getOproute_9b_linebasement9_10pm().equals("")){_10pm++;}
			if(data.getOproute_9b_linebasement10_10pm()!=null&&!data.getOproute_9b_linebasement10_10pm().equals("")){_10pm++;}
			if(data.getOproute_9b_linebasement11_10pm()!=null&&!data.getOproute_9b_linebasement11_10pm().equals("")){_10pm++;}
			if(data.getOproute_9b_linebasement12_10pm()!=null&&!data.getOproute_9b_linebasement12_10pm().equals("")){_10pm++;}
			if(data.getOproute_9b_linebasement13_10pm()!=null&&!data.getOproute_9b_linebasement13_10pm().equals("")){_10pm++;}
			if(data.getOproute_9b_linebasement14_10pm()!=null&&!data.getOproute_9b_linebasement14_10pm().equals("")){_10pm++;}

			if(data.getOproute_9b_linebasement1_2am()!=null&&!data.getOproute_9b_linebasement1_2am().equals("")){_2am++;}
			if(data.getOproute_9b_linebasement2_2am()!=null&&!data.getOproute_9b_linebasement2_2am().equals("")){_2am++;}
			if(data.getOproute_9b_linebasement3_2am()!=null&&!data.getOproute_9b_linebasement3_2am().equals("")){_2am++;}
			if(data.getOproute_9b_linebasement4_2am()!=null&&!data.getOproute_9b_linebasement4_2am().equals("")){_2am++;}
			if(data.getOproute_9b_linebasement5_2am()!=null&&!data.getOproute_9b_linebasement5_2am().equals("")){_2am++;}
			if(data.getOproute_9b_linebasement6_2am()!=null&&!data.getOproute_9b_linebasement6_2am().equals("")){_2am++;}
			if(data.getOproute_9b_linebasement7_2am()!=null&&!data.getOproute_9b_linebasement7_2am().equals("")){_2am++;}
			if(data.getOproute_9b_linebasement8_2am()!=null&&!data.getOproute_9b_linebasement8_2am().equals("")){_2am++;}
			if(data.getOproute_9b_linebasement9_2am()!=null&&!data.getOproute_9b_linebasement9_2am().equals("")){_2am++;}
			if(data.getOproute_9b_linebasement10_2am()!=null&&!data.getOproute_9b_linebasement10_2am().equals("")){_2am++;}
			if(data.getOproute_9b_linebasement11_2am()!=null&&!data.getOproute_9b_linebasement11_2am().equals("")){_2am++;}
			if(data.getOproute_9b_linebasement12_2am()!=null&&!data.getOproute_9b_linebasement12_2am().equals("")){_2am++;}
			if(data.getOproute_9b_linebasement13_2am()!=null&&!data.getOproute_9b_linebasement13_2am().equals("")){_2am++;}
			if(data.getOproute_9b_linebasement14_2am()!=null&&!data.getOproute_9b_linebasement14_2am().equals("")){_2am++;}

			if(data.getOproute_9b_linebasement1_6am()!=null&&!data.getOproute_9b_linebasement1_6am().equals("")){_6am++;}
			if(data.getOproute_9b_linebasement2_6am()!=null&&!data.getOproute_9b_linebasement2_6am().equals("")){_6am++;}
			if(data.getOproute_9b_linebasement3_6am()!=null&&!data.getOproute_9b_linebasement3_6am().equals("")){_6am++;}
			if(data.getOproute_9b_linebasement4_6am()!=null&&!data.getOproute_9b_linebasement4_6am().equals("")){_6am++;}
			if(data.getOproute_9b_linebasement5_6am()!=null&&!data.getOproute_9b_linebasement5_6am().equals("")){_6am++;}
			if(data.getOproute_9b_linebasement6_6am()!=null&&!data.getOproute_9b_linebasement6_6am().equals("")){_6am++;}
			if(data.getOproute_9b_linebasement7_6am()!=null&&!data.getOproute_9b_linebasement7_6am().equals("")){_6am++;}
			if(data.getOproute_9b_linebasement8_6am()!=null&&!data.getOproute_9b_linebasement8_6am().equals("")){_6am++;}
			if(data.getOproute_9b_linebasement9_6am()!=null&&!data.getOproute_9b_linebasement9_6am().equals("")){_6am++;}
			if(data.getOproute_9b_linebasement10_6am()!=null&&!data.getOproute_9b_linebasement10_6am().equals("")){_6am++;}
			if(data.getOproute_9b_linebasement11_6am()!=null&&!data.getOproute_9b_linebasement11_6am().equals("")){_6am++;}
			if(data.getOproute_9b_linebasement12_6am()!=null&&!data.getOproute_9b_linebasement12_6am().equals("")){_6am++;}
			if(data.getOproute_9b_linebasement13_6am()!=null&&!data.getOproute_9b_linebasement13_6am().equals("")){_6am++;}
			if(data.getOproute_9b_linebasement14_6am()!=null&&!data.getOproute_9b_linebasement14_6am().equals("")){_6am++;}

			if(_10am>=5) {_10ampercent=100;}
			if(_2pm>=5) {_2pmpercent=100;}
			if(_6pm>=5) {_6pmpercent=100;}
			if(_10pm>=5) {_10pmpercent=100;}
			if(_2am>=5) {_2ampercent=100;}
			if(_6am>=5) {_6ampercent=100;}
			if(data.getCmt9amarea()!=null&&!data.getCmt9amarea().equals(""))
			{_10ampercent=100;}
			if(data.getCmt1pmarea()!=null&&!data.getCmt1pmarea().equals(""))
			{_2pmpercent=100;}				
			if(data.getCmt5pmarea()!=null&&!data.getCmt5pmarea().equals(""))
			{_6pmpercent=100;}
			if(data.getCmt9pmarea()!=null&&!data.getCmt9pmarea().equals(""))
			{_10pmpercent=100;}
			if(data.getCmt1amarea()!=null&&!data.getCmt1amarea().equals(""))
			{_2ampercent=100;}
			if(data.getCmt5amarea()!=null&&!data.getCmt5amarea().equals(""))
			{_6ampercent=100;}
			percent=(_10ampercent+_2pmpercent+_6pmpercent+_10pmpercent+_2ampercent+_6ampercent)/6;
		}
		
		return percent;
	}
	@Override
	public List<Integer> getCount(String sdate,String edate) throws Exception {
		
		int _10am=0,_2pm=0,_6pm=0,_10pm=0,_2am=0,_6am=0;
		List<Integer> al=new ArrayList<Integer>();
	 	int count=0;
		List<OpRoute_9> lst= getData(sdate,edate);
		for(OpRoute_9 data:lst)
		{
			if(data.getOproute_9b_linebasement1_10am()!=null&&!data.getOproute_9b_linebasement1_10am().equals("")){_10am++;}
			if(data.getOproute_9b_linebasement2_10am()!=null&&!data.getOproute_9b_linebasement2_10am().equals("")){_10am++;}
			if(data.getOproute_9b_linebasement3_10am()!=null&&!data.getOproute_9b_linebasement3_10am().equals("")){_10am++;}
			if(data.getOproute_9b_linebasement4_10am()!=null&&!data.getOproute_9b_linebasement4_10am().equals("")){_10am++;}
			if(data.getOproute_9b_linebasement5_10am()!=null&&!data.getOproute_9b_linebasement5_10am().equals("")){_10am++;}
			if(data.getOproute_9b_linebasement6_10am()!=null&&!data.getOproute_9b_linebasement6_10am().equals("")){_10am++;}
			if(data.getOproute_9b_linebasement7_10am()!=null&&!data.getOproute_9b_linebasement7_10am().equals("")){_10am++;}
			if(data.getOproute_9b_linebasement8_10am()!=null&&!data.getOproute_9b_linebasement8_10am().equals("")){_10am++;}
			if(data.getOproute_9b_linebasement9_10am()!=null&&!data.getOproute_9b_linebasement9_10am().equals("")){_10am++;}
			if(data.getOproute_9b_linebasement10_10am()!=null&&!data.getOproute_9b_linebasement10_10am().equals("")){_10am++;}
			if(data.getOproute_9b_linebasement11_10am()!=null&&!data.getOproute_9b_linebasement11_10am().equals("")){_10am++;}
			if(data.getOproute_9b_linebasement12_10am()!=null&&!data.getOproute_9b_linebasement12_10am().equals("")){_10am++;}
			if(data.getOproute_9b_linebasement13_10am()!=null&&!data.getOproute_9b_linebasement13_10am().equals("")){_10am++;}
			if(data.getOproute_9b_linebasement14_10am()!=null&&!data.getOproute_9b_linebasement14_10am().equals("")){_10am++;}

			if(data.getOproute_9b_linebasement1_2pm()!=null&&!data.getOproute_9b_linebasement1_2pm().equals("")){_2pm++;}
			if(data.getOproute_9b_linebasement2_2pm()!=null&&!data.getOproute_9b_linebasement2_2pm().equals("")){_2pm++;}
			if(data.getOproute_9b_linebasement3_2pm()!=null&&!data.getOproute_9b_linebasement3_2pm().equals("")){_2pm++;}
			if(data.getOproute_9b_linebasement4_2pm()!=null&&!data.getOproute_9b_linebasement4_2pm().equals("")){_2pm++;}
			if(data.getOproute_9b_linebasement5_2pm()!=null&&!data.getOproute_9b_linebasement5_2pm().equals("")){_2pm++;}
			if(data.getOproute_9b_linebasement6_2pm()!=null&&!data.getOproute_9b_linebasement6_2pm().equals("")){_2pm++;}
			if(data.getOproute_9b_linebasement7_2pm()!=null&&!data.getOproute_9b_linebasement7_2pm().equals("")){_2pm++;}
			if(data.getOproute_9b_linebasement8_2pm()!=null&&!data.getOproute_9b_linebasement8_2pm().equals("")){_2pm++;}
			if(data.getOproute_9b_linebasement9_2pm()!=null&&!data.getOproute_9b_linebasement9_2pm().equals("")){_2pm++;}
			if(data.getOproute_9b_linebasement10_2pm()!=null&&!data.getOproute_9b_linebasement10_2pm().equals("")){_2pm++;}
			if(data.getOproute_9b_linebasement11_2pm()!=null&&!data.getOproute_9b_linebasement11_2pm().equals("")){_2pm++;}
			if(data.getOproute_9b_linebasement12_2pm()!=null&&!data.getOproute_9b_linebasement12_2pm().equals("")){_2pm++;}
			if(data.getOproute_9b_linebasement13_2pm()!=null&&!data.getOproute_9b_linebasement13_2pm().equals("")){_2pm++;}
			if(data.getOproute_9b_linebasement14_2pm()!=null&&!data.getOproute_9b_linebasement14_2pm().equals("")){_2pm++;}

			if(data.getOproute_9b_linebasement1_6pm()!=null&&!data.getOproute_9b_linebasement1_6pm().equals("")){_6pm++;}
			if(data.getOproute_9b_linebasement2_6pm()!=null&&!data.getOproute_9b_linebasement2_6pm().equals("")){_6pm++;}
			if(data.getOproute_9b_linebasement3_6pm()!=null&&!data.getOproute_9b_linebasement3_6pm().equals("")){_6pm++;}
			if(data.getOproute_9b_linebasement4_6pm()!=null&&!data.getOproute_9b_linebasement4_6pm().equals("")){_6pm++;}
			if(data.getOproute_9b_linebasement5_6pm()!=null&&!data.getOproute_9b_linebasement5_6pm().equals("")){_6pm++;}
			if(data.getOproute_9b_linebasement6_6pm()!=null&&!data.getOproute_9b_linebasement6_6pm().equals("")){_6pm++;}
			if(data.getOproute_9b_linebasement7_6pm()!=null&&!data.getOproute_9b_linebasement7_6pm().equals("")){_6pm++;}
			if(data.getOproute_9b_linebasement8_6pm()!=null&&!data.getOproute_9b_linebasement8_6pm().equals("")){_6pm++;}
			if(data.getOproute_9b_linebasement9_6pm()!=null&&!data.getOproute_9b_linebasement9_6pm().equals("")){_6pm++;}
			if(data.getOproute_9b_linebasement10_6pm()!=null&&!data.getOproute_9b_linebasement10_6pm().equals("")){_6pm++;}
			if(data.getOproute_9b_linebasement11_6pm()!=null&&!data.getOproute_9b_linebasement11_6pm().equals("")){_6pm++;}
			if(data.getOproute_9b_linebasement12_6pm()!=null&&!data.getOproute_9b_linebasement12_6pm().equals("")){_6pm++;}
			if(data.getOproute_9b_linebasement13_6pm()!=null&&!data.getOproute_9b_linebasement13_6pm().equals("")){_6pm++;}
			if(data.getOproute_9b_linebasement14_6pm()!=null&&!data.getOproute_9b_linebasement14_6pm().equals("")){_6pm++;}

			if(data.getOproute_9b_linebasement1_10pm()!=null&&!data.getOproute_9b_linebasement1_10pm().equals("")){_10pm++;}
			if(data.getOproute_9b_linebasement2_10pm()!=null&&!data.getOproute_9b_linebasement2_10pm().equals("")){_10pm++;}
			if(data.getOproute_9b_linebasement3_10pm()!=null&&!data.getOproute_9b_linebasement3_10pm().equals("")){_10pm++;}
			if(data.getOproute_9b_linebasement4_10pm()!=null&&!data.getOproute_9b_linebasement4_10pm().equals("")){_10pm++;}
			if(data.getOproute_9b_linebasement5_10pm()!=null&&!data.getOproute_9b_linebasement5_10pm().equals("")){_10pm++;}
			if(data.getOproute_9b_linebasement6_10pm()!=null&&!data.getOproute_9b_linebasement6_10pm().equals("")){_10pm++;}
			if(data.getOproute_9b_linebasement7_10pm()!=null&&!data.getOproute_9b_linebasement7_10pm().equals("")){_10pm++;}
			if(data.getOproute_9b_linebasement8_10pm()!=null&&!data.getOproute_9b_linebasement8_10pm().equals("")){_10pm++;}
			if(data.getOproute_9b_linebasement9_10pm()!=null&&!data.getOproute_9b_linebasement9_10pm().equals("")){_10pm++;}
			if(data.getOproute_9b_linebasement10_10pm()!=null&&!data.getOproute_9b_linebasement10_10pm().equals("")){_10pm++;}
			if(data.getOproute_9b_linebasement11_10pm()!=null&&!data.getOproute_9b_linebasement11_10pm().equals("")){_10pm++;}
			if(data.getOproute_9b_linebasement12_10pm()!=null&&!data.getOproute_9b_linebasement12_10pm().equals("")){_10pm++;}
			if(data.getOproute_9b_linebasement13_10pm()!=null&&!data.getOproute_9b_linebasement13_10pm().equals("")){_10pm++;}
			if(data.getOproute_9b_linebasement14_10pm()!=null&&!data.getOproute_9b_linebasement14_10pm().equals("")){_10pm++;}

			if(data.getOproute_9b_linebasement1_2am()!=null&&!data.getOproute_9b_linebasement1_2am().equals("")){_2am++;}
			if(data.getOproute_9b_linebasement2_2am()!=null&&!data.getOproute_9b_linebasement2_2am().equals("")){_2am++;}
			if(data.getOproute_9b_linebasement3_2am()!=null&&!data.getOproute_9b_linebasement3_2am().equals("")){_2am++;}
			if(data.getOproute_9b_linebasement4_2am()!=null&&!data.getOproute_9b_linebasement4_2am().equals("")){_2am++;}
			if(data.getOproute_9b_linebasement5_2am()!=null&&!data.getOproute_9b_linebasement5_2am().equals("")){_2am++;}
			if(data.getOproute_9b_linebasement6_2am()!=null&&!data.getOproute_9b_linebasement6_2am().equals("")){_2am++;}
			if(data.getOproute_9b_linebasement7_2am()!=null&&!data.getOproute_9b_linebasement7_2am().equals("")){_2am++;}
			if(data.getOproute_9b_linebasement8_2am()!=null&&!data.getOproute_9b_linebasement8_2am().equals("")){_2am++;}
			if(data.getOproute_9b_linebasement9_2am()!=null&&!data.getOproute_9b_linebasement9_2am().equals("")){_2am++;}
			if(data.getOproute_9b_linebasement10_2am()!=null&&!data.getOproute_9b_linebasement10_2am().equals("")){_2am++;}
			if(data.getOproute_9b_linebasement11_2am()!=null&&!data.getOproute_9b_linebasement11_2am().equals("")){_2am++;}
			if(data.getOproute_9b_linebasement12_2am()!=null&&!data.getOproute_9b_linebasement12_2am().equals("")){_2am++;}
			if(data.getOproute_9b_linebasement13_2am()!=null&&!data.getOproute_9b_linebasement13_2am().equals("")){_2am++;}
			if(data.getOproute_9b_linebasement14_2am()!=null&&!data.getOproute_9b_linebasement14_2am().equals("")){_2am++;}

			if(data.getOproute_9b_linebasement1_6am()!=null&&!data.getOproute_9b_linebasement1_6am().equals("")){_6am++;}
			if(data.getOproute_9b_linebasement2_6am()!=null&&!data.getOproute_9b_linebasement2_6am().equals("")){_6am++;}
			if(data.getOproute_9b_linebasement3_6am()!=null&&!data.getOproute_9b_linebasement3_6am().equals("")){_6am++;}
			if(data.getOproute_9b_linebasement4_6am()!=null&&!data.getOproute_9b_linebasement4_6am().equals("")){_6am++;}
			if(data.getOproute_9b_linebasement5_6am()!=null&&!data.getOproute_9b_linebasement5_6am().equals("")){_6am++;}
			if(data.getOproute_9b_linebasement6_6am()!=null&&!data.getOproute_9b_linebasement6_6am().equals("")){_6am++;}
			if(data.getOproute_9b_linebasement7_6am()!=null&&!data.getOproute_9b_linebasement7_6am().equals("")){_6am++;}
			if(data.getOproute_9b_linebasement8_6am()!=null&&!data.getOproute_9b_linebasement8_6am().equals("")){_6am++;}
			if(data.getOproute_9b_linebasement9_6am()!=null&&!data.getOproute_9b_linebasement9_6am().equals("")){_6am++;}
			if(data.getOproute_9b_linebasement10_6am()!=null&&!data.getOproute_9b_linebasement10_6am().equals("")){_6am++;}
			if(data.getOproute_9b_linebasement11_6am()!=null&&!data.getOproute_9b_linebasement11_6am().equals("")){_6am++;}
			if(data.getOproute_9b_linebasement12_6am()!=null&&!data.getOproute_9b_linebasement12_6am().equals("")){_6am++;}
			if(data.getOproute_9b_linebasement13_6am()!=null&&!data.getOproute_9b_linebasement13_6am().equals("")){_6am++;}
			if(data.getOproute_9b_linebasement14_6am()!=null&&!data.getOproute_9b_linebasement14_6am().equals("")){_6am++;}

			if(_10am>=5) {count++;}
			if(_2pm>=5) {count++;}
			if(_6pm>=5) {count++;}
			if(_10pm>=5) {count++;}
			if(_2am>=5) {count++;}
			if(_6am>=5) {count++;}
			al.add(count);
			count=0;_10am=0;_2pm=0;_6pm=0;_10pm=0;_2am=0;_6am=0;
		}
		
		return al;
	}
}

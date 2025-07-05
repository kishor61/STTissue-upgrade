/**
 *06-Dec-2019
 *OpRoute_8DaoImp.java
 * TODO
 *com.st.frpobcc.dao
 *OpRoute_8DaoImp.java
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
import com.st.frpobcc.model.OpRoute_8;

/**
 * @author sohan
 *
 */
@Repository
public class OpRoute_8DaoImp implements OpRoute_8Dao {

	@Autowired
	@Qualifier("dataSourceOBCC")
	private DataSource dataSourceQRT;
	/* (non-Javadoc)
	 * @see com.st.frpobcc.dao.OpRoute_8Dao#saveorUpdate(com.st.frpobcc.model.OpRoute_8)
	 */
	@Override
	public void saveorUpdate(OpRoute_8 data) {
		
		NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(dataSourceQRT);
	 	MapSqlParameterSource paramSource=new MapSqlParameterSource();
		
		paramSource.addValue("position",data.getPosition());
		paramSource.addValue("date",data.getDate());
		paramSource.addValue("crew",data.getCrew());
		paramSource.addValue("shift",data.getShift());
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
		paramSource.addValue("oproute_8outside1_8am",data.getOproute_8outside1_8am());
		paramSource.addValue("oproute_8outside1_12pm",data.getOproute_8outside1_12pm());
		paramSource.addValue("oproute_8outside1_4pm",data.getOproute_8outside1_4pm());
		paramSource.addValue("oproute_8outside1_8pm",data.getOproute_8outside1_8pm());
		paramSource.addValue("oproute_8outside1_12am",data.getOproute_8outside1_12am());
		paramSource.addValue("oproute_8outside1_4am",data.getOproute_8outside1_4am());
		paramSource.addValue("oproute_8outside2_8am",data.getOproute_8outside2_8am());
		paramSource.addValue("oproute_8outside2_12pm",data.getOproute_8outside2_12pm());
		paramSource.addValue("oproute_8outside2_4pm",data.getOproute_8outside2_4pm());
		paramSource.addValue("oproute_8outside2_8pm",data.getOproute_8outside2_8pm());
		paramSource.addValue("oproute_8outside2_12am",data.getOproute_8outside2_12am());
		paramSource.addValue("oproute_8outside2_4am",data.getOproute_8outside2_4am());
		paramSource.addValue("oproute_8outside3_8am",data.getOproute_8outside3_8am());
		paramSource.addValue("oproute_8outside3_12pm",data.getOproute_8outside3_12pm());
		paramSource.addValue("oproute_8outside3_4pm",data.getOproute_8outside3_4pm());
		paramSource.addValue("oproute_8outside3_8pm",data.getOproute_8outside3_8pm());
		paramSource.addValue("oproute_8outside3_12am",data.getOproute_8outside3_12am());
		paramSource.addValue("oproute_8outside3_4am",data.getOproute_8outside3_4am());
		paramSource.addValue("oproute_8outside4_8am",data.getOproute_8outside4_8am());
		paramSource.addValue("oproute_8outside4_12pm",data.getOproute_8outside4_12pm());
		paramSource.addValue("oproute_8outside4_4pm",data.getOproute_8outside4_4pm());
		paramSource.addValue("oproute_8outside4_8pm",data.getOproute_8outside4_8pm());
		paramSource.addValue("oproute_8outside4_12am",data.getOproute_8outside4_12am());
		paramSource.addValue("oproute_8outside4_4am",data.getOproute_8outside4_4am());	
		paramSource.addValue("oproute_8outside5_8am",data.getOproute_8outside5_8am());
		paramSource.addValue("oproute_8outside5_12pm",data.getOproute_8outside5_12pm());
		paramSource.addValue("oproute_8outside5_4pm",data.getOproute_8outside5_4pm());
		paramSource.addValue("oproute_8outside5_8pm",data.getOproute_8outside5_8pm());
		paramSource.addValue("oproute_8outside5_12am",data.getOproute_8outside5_12am());
		paramSource.addValue("oproute_8outside5_4am",data.getOproute_8outside5_4am());
		paramSource.addValue("oproute_8outside6_8am",data.getOproute_8outside6_8am());
		paramSource.addValue("oproute_8outside6_12pm",data.getOproute_8outside6_12pm());
		paramSource.addValue("oproute_8outside6_4pm",data.getOproute_8outside6_4pm());
		paramSource.addValue("oproute_8outside6_8pm",data.getOproute_8outside6_8pm());
		paramSource.addValue("oproute_8outside6_12am",data.getOproute_8outside6_12am());
		paramSource.addValue("oproute_8outside6_4am",data.getOproute_8outside6_4am());
		paramSource.addValue("oproute_8outside7_8am",data.getOproute_8outside7_8am());
		paramSource.addValue("oproute_8outside7_12pm",data.getOproute_8outside7_12pm());
		paramSource.addValue("oproute_8outside7_4pm",data.getOproute_8outside7_4pm());
		paramSource.addValue("oproute_8outside7_8pm",data.getOproute_8outside7_8pm());
		paramSource.addValue("oproute_8outside7_12am",data.getOproute_8outside7_12am());
		paramSource.addValue("oproute_8outside7_4am",data.getOproute_8outside7_4am());
		paramSource.addValue("oproute_8outside8_8am",data.getOproute_8outside8_8am());
		paramSource.addValue("oproute_8outside8_12pm",data.getOproute_8outside8_12pm());
		paramSource.addValue("oproute_8outside8_4pm",data.getOproute_8outside8_4pm());
		paramSource.addValue("oproute_8outside8_8pm",data.getOproute_8outside8_8pm());
		paramSource.addValue("oproute_8outside8_12am",data.getOproute_8outside8_12am());
		paramSource.addValue("oproute_8outside8_4am",data.getOproute_8outside8_4am());
		paramSource.addValue("oproute_8outside9_8am",data.getOproute_8outside9_8am());
		paramSource.addValue("oproute_8outside9_12pm",data.getOproute_8outside9_12pm());
		paramSource.addValue("oproute_8outside9_4pm",data.getOproute_8outside9_4pm());
		paramSource.addValue("oproute_8outside9_8pm",data.getOproute_8outside9_8pm());
		paramSource.addValue("oproute_8outside9_12am",data.getOproute_8outside9_12am());
		paramSource.addValue("oproute_8outside9_4am",data.getOproute_8outside9_4am());	
		paramSource.addValue("oproute_8outside10_8am",data.getOproute_8outside10_8am());
		paramSource.addValue("oproute_8outside10_12pm",data.getOproute_8outside10_12pm());
		paramSource.addValue("oproute_8outside10_4pm",data.getOproute_8outside10_4pm());
		paramSource.addValue("oproute_8outside10_8pm",data.getOproute_8outside10_8pm());
		paramSource.addValue("oproute_8outside10_12am",data.getOproute_8outside10_12am());
		paramSource.addValue("oproute_8outside10_4am",data.getOproute_8outside10_4am());
		paramSource.addValue("oproute_8outside11_8am",data.getOproute_8outside11_8am());
		paramSource.addValue("oproute_8outside11_12pm",data.getOproute_8outside11_12pm());
		paramSource.addValue("oproute_8outside11_4pm",data.getOproute_8outside11_4pm());
		paramSource.addValue("oproute_8outside11_8pm",data.getOproute_8outside11_8pm());
		paramSource.addValue("oproute_8outside11_12am",data.getOproute_8outside11_12am());
		paramSource.addValue("oproute_8outside11_4am",data.getOproute_8outside11_4am());
		paramSource.addValue("oproute_8outside12_8am",data.getOproute_8outside12_8am());
		paramSource.addValue("oproute_8outside12_12pm",data.getOproute_8outside12_12pm());
		paramSource.addValue("oproute_8outside12_4pm",data.getOproute_8outside12_4pm());
		paramSource.addValue("oproute_8outside12_8pm",data.getOproute_8outside12_8pm());
		paramSource.addValue("oproute_8outside12_12am",data.getOproute_8outside12_12am());
		paramSource.addValue("oproute_8outside12_4am",data.getOproute_8outside12_4am());
		paramSource.addValue("oproute_8outside13_8am",data.getOproute_8outside13_8am());
		paramSource.addValue("oproute_8outside13_12pm",data.getOproute_8outside13_12pm());
		paramSource.addValue("oproute_8outside13_4pm",data.getOproute_8outside13_4pm());
		paramSource.addValue("oproute_8outside13_8pm",data.getOproute_8outside13_8pm());
		paramSource.addValue("oproute_8outside13_12am",data.getOproute_8outside13_12am());
		paramSource.addValue("oproute_8outside13_4am",data.getOproute_8outside13_4am());
		paramSource.addValue("oproute_8outside14_8am",data.getOproute_8outside14_8am());
		paramSource.addValue("oproute_8outside14_12pm",data.getOproute_8outside14_12pm());
		paramSource.addValue("oproute_8outside14_4pm",data.getOproute_8outside14_4pm());
		paramSource.addValue("oproute_8outside14_8pm",data.getOproute_8outside14_8pm());
		paramSource.addValue("oproute_8outside14_12am",data.getOproute_8outside14_12am());
		paramSource.addValue("oproute_8outside14_4am",data.getOproute_8outside14_4am());
		paramSource.addValue("oproute_8outside15_8am",data.getOproute_8outside15_8am());
		paramSource.addValue("oproute_8outside15_12pm",data.getOproute_8outside15_12pm());
		paramSource.addValue("oproute_8outside15_4pm",data.getOproute_8outside15_4pm());
		paramSource.addValue("oproute_8outside15_8pm",data.getOproute_8outside15_8pm());
		paramSource.addValue("oproute_8outside15_12am",data.getOproute_8outside15_12am());
		paramSource.addValue("oproute_8outside15_4am",data.getOproute_8outside15_4am());
		paramSource.addValue("oproute_8outside16_8am",data.getOproute_8outside16_8am());
		paramSource.addValue("oproute_8outside16_12pm",data.getOproute_8outside16_12pm());
		paramSource.addValue("oproute_8outside16_4pm",data.getOproute_8outside16_4pm());
		paramSource.addValue("oproute_8outside16_8pm",data.getOproute_8outside16_8pm());
		paramSource.addValue("oproute_8outside16_12am",data.getOproute_8outside16_12am());
		paramSource.addValue("oproute_8outside16_4am",data.getOproute_8outside16_4am());
		paramSource.addValue("oproute_8outside17_8am",data.getOproute_8outside17_8am());
		paramSource.addValue("oproute_8outside17_12pm",data.getOproute_8outside17_12pm());
		paramSource.addValue("oproute_8outside17_4pm",data.getOproute_8outside17_4pm());
		paramSource.addValue("oproute_8outside17_8pm",data.getOproute_8outside17_8pm());
		paramSource.addValue("oproute_8outside17_12am",data.getOproute_8outside17_12am());
		paramSource.addValue("oproute_8outside17_4am",data.getOproute_8outside17_4am());
		paramSource.addValue("oproute_8outside18_8am",data.getOproute_8outside18_8am());
		paramSource.addValue("oproute_8outside18_12pm",data.getOproute_8outside18_12pm());
		paramSource.addValue("oproute_8outside18_4pm",data.getOproute_8outside18_4pm());
		paramSource.addValue("oproute_8outside18_8pm",data.getOproute_8outside18_8pm());
		paramSource.addValue("oproute_8outside18_12am",data.getOproute_8outside18_12am());
		paramSource.addValue("oproute_8outside18_4am",data.getOproute_8outside18_4am());
		paramSource.addValue("oproute_8outside19_8am",data.getOproute_8outside19_8am());
		paramSource.addValue("oproute_8outside19_12pm",data.getOproute_8outside19_12pm());
		paramSource.addValue("oproute_8outside19_4pm",data.getOproute_8outside19_4pm());
		paramSource.addValue("oproute_8outside19_8pm",data.getOproute_8outside19_8pm());
		paramSource.addValue("oproute_8outside19_12am",data.getOproute_8outside19_12am());
		paramSource.addValue("oproute_8outside19_4am",data.getOproute_8outside19_4am());
		paramSource.addValue("oproute_8outside20_8am",data.getOproute_8outside20_8am());
		paramSource.addValue("oproute_8outside20_12pm",data.getOproute_8outside20_12pm());
		paramSource.addValue("oproute_8outside20_4pm",data.getOproute_8outside20_4pm());
		paramSource.addValue("oproute_8outside20_8pm",data.getOproute_8outside20_8pm());
		paramSource.addValue("oproute_8outside20_12am",data.getOproute_8outside20_12am());
		paramSource.addValue("oproute_8outside20_4am",data.getOproute_8outside20_4am());
		paramSource.addValue("oproute_8outside21_8am",data.getOproute_8outside21_8am());
		paramSource.addValue("oproute_8outside21_12pm",data.getOproute_8outside21_12pm());
		paramSource.addValue("oproute_8outside21_4pm",data.getOproute_8outside21_4pm());
		paramSource.addValue("oproute_8outside21_8pm",data.getOproute_8outside21_8pm());
		paramSource.addValue("oproute_8outside21_12am",data.getOproute_8outside21_12am());
		paramSource.addValue("oproute_8outside21_4am",data.getOproute_8outside21_4am());
		paramSource.addValue("oproute_8outside22_8am",data.getOproute_8outside22_8am());
		paramSource.addValue("oproute_8outside22_12pm",data.getOproute_8outside22_12pm());
		paramSource.addValue("oproute_8outside22_4pm",data.getOproute_8outside22_4pm());
		paramSource.addValue("oproute_8outside22_8pm",data.getOproute_8outside22_8pm());
		paramSource.addValue("oproute_8outside22_12am",data.getOproute_8outside22_12am());
		paramSource.addValue("oproute_8outside22_4am",data.getOproute_8outside22_4am());
		paramSource.addValue("oproute_8outside23_8am",data.getOproute_8outside23_8am());
		paramSource.addValue("oproute_8outside23_12pm",data.getOproute_8outside23_12pm());
		paramSource.addValue("oproute_8outside23_4pm",data.getOproute_8outside23_4pm());
		paramSource.addValue("oproute_8outside23_8pm",data.getOproute_8outside23_8pm());
		paramSource.addValue("oproute_8outside23_12am",data.getOproute_8outside23_12am());
		paramSource.addValue("oproute_8outside23_4am",data.getOproute_8outside23_4am());
		paramSource.addValue("oproute_8outside24_8am",data.getOproute_8outside24_8am());
		paramSource.addValue("oproute_8outside24_12pm",data.getOproute_8outside24_12pm());
		paramSource.addValue("oproute_8outside24_4pm",data.getOproute_8outside24_4pm());
		paramSource.addValue("oproute_8outside24_8pm",data.getOproute_8outside24_8pm());
		paramSource.addValue("oproute_8outside24_12am",data.getOproute_8outside24_12am());
		paramSource.addValue("oproute_8outside24_4am",data.getOproute_8outside24_4am());
		paramSource.addValue("oproute_8outside25_8am",data.getOproute_8outside25_8am());
		paramSource.addValue("oproute_8outside25_12pm",data.getOproute_8outside25_12pm());
		paramSource.addValue("oproute_8outside25_4pm",data.getOproute_8outside25_4pm());
		paramSource.addValue("oproute_8outside25_8pm",data.getOproute_8outside25_8pm());
		paramSource.addValue("oproute_8outside25_12am",data.getOproute_8outside25_12am());
		paramSource.addValue("oproute_8outside25_4am",data.getOproute_8outside25_4am());
		paramSource.addValue("oproute_8outside26_8am",data.getOproute_8outside26_8am());
		paramSource.addValue("oproute_8outside26_12pm",data.getOproute_8outside26_12pm());
		paramSource.addValue("oproute_8outside26_4pm",data.getOproute_8outside26_4pm());
		paramSource.addValue("oproute_8outside26_8pm",data.getOproute_8outside26_8pm());
		paramSource.addValue("oproute_8outside26_12am",data.getOproute_8outside26_12am());
		paramSource.addValue("oproute_8outside26_4am",data.getOproute_8outside26_4am());
		paramSource.addValue("oproute_8outside27_8am",data.getOproute_8outside27_8am());
		paramSource.addValue("oproute_8outside27_12pm",data.getOproute_8outside27_12pm());
		paramSource.addValue("oproute_8outside27_4pm",data.getOproute_8outside27_4pm());
		paramSource.addValue("oproute_8outside27_8pm",data.getOproute_8outside27_8pm());
		paramSource.addValue("oproute_8outside27_12am",data.getOproute_8outside27_12am());
		paramSource.addValue("oproute_8outside27_4am",data.getOproute_8outside27_4am());
		paramSource.addValue("oproute_8outside28_8am",data.getOproute_8outside28_8am());
		paramSource.addValue("oproute_8outside28_12pm",data.getOproute_8outside28_12pm());
		paramSource.addValue("oproute_8outside28_4pm",data.getOproute_8outside28_4pm());
		paramSource.addValue("oproute_8outside28_8pm",data.getOproute_8outside28_8pm());
		paramSource.addValue("oproute_8outside28_12am",data.getOproute_8outside28_12am());
		paramSource.addValue("oproute_8outside28_4am",data.getOproute_8outside28_4am());
		paramSource.addValue("oproute_8outside29_8am",data.getOproute_8outside29_8am());
		paramSource.addValue("oproute_8outside29_12pm",data.getOproute_8outside29_12pm());
		paramSource.addValue("oproute_8outside29_4pm",data.getOproute_8outside29_4pm());
		paramSource.addValue("oproute_8outside29_8pm",data.getOproute_8outside29_8pm());
		paramSource.addValue("oproute_8outside29_12am",data.getOproute_8outside29_12am());
		paramSource.addValue("oproute_8outside29_4am",data.getOproute_8outside29_4am());		
		paramSource.addValue("oproute_8outside30_8am",data.getOproute_8outside30_8am());
		paramSource.addValue("oproute_8outside30_12pm",data.getOproute_8outside30_12pm());
		paramSource.addValue("oproute_8outside30_4pm",data.getOproute_8outside30_4pm());
		paramSource.addValue("oproute_8outside30_8pm",data.getOproute_8outside30_8pm());
		paramSource.addValue("oproute_8outside30_12am",data.getOproute_8outside30_12am());
		paramSource.addValue("oproute_8outside30_4am",data.getOproute_8outside30_4am());
		
		paramSource.addValue("cmt9amarea", data.getCmt9amarea());
		paramSource.addValue("cmt1pmarea", data.getCmt1pmarea());
		paramSource.addValue("cmt5pmarea", data.getCmt5pmarea());
		paramSource.addValue("cmt9pmarea", data.getCmt9pmarea());
		paramSource.addValue("cmt1amarea", data.getCmt1amarea());
		paramSource.addValue("cmt5amarea", data.getCmt5amarea());
		
		if (data.getId() == 0) {	
			
			String sql=DatabaseUtil.getSQL("sql/insertOpRoute_8.sql");
			jdbcTemplate.update(sql, paramSource);
		}	
		else
		{
			paramSource.addValue("id",data.getId());
			String sql=DatabaseUtil.getSQL("sql/updateOpRoute_8.sql");
			jdbcTemplate.update(sql, paramSource);
		}	
	}
	/* (non-Javadoc)
	 * @see com.st.frpobcc.dao.OpRoute_8Dao#getData(java.lang.String)
	 */
	@Override
	public List<OpRoute_8> getData(String sdate,String edate) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSourceQRT);
		String sql = "select * from [OpRoute_8] where date BETWEEN ? AND ?";
		List<OpRoute_8> oproute_8=null;
		try {
			oproute_8 = jdbcTemplate.query(sql, new Object[] {sdate,edate}, new RowMapper<OpRoute_8>() {

		@Override
		public OpRoute_8 mapRow(ResultSet rs, int arg1) throws SQLException {
		OpRoute_8 data=new OpRoute_8();
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
		data.setOproute_8outside1_8am(rs.getString("oproute_8outside1_8am"));
		data.setOproute_8outside1_12pm(rs.getString("oproute_8outside1_12pm"));
		data.setOproute_8outside1_4pm(rs.getString("oproute_8outside1_4pm"));
		data.setOproute_8outside1_8pm(rs.getString("oproute_8outside1_8pm"));
		data.setOproute_8outside1_12am(rs.getString("oproute_8outside1_12am"));
		data.setOproute_8outside1_4am(rs.getString("oproute_8outside1_4am"));
		data.setOproute_8outside2_8am(rs.getString("oproute_8outside2_8am"));
		data.setOproute_8outside2_12pm(rs.getString("oproute_8outside2_12pm"));
		data.setOproute_8outside2_4pm(rs.getString("oproute_8outside2_4pm"));
		data.setOproute_8outside2_8pm(rs.getString("oproute_8outside2_8pm"));
		data.setOproute_8outside2_12am(rs.getString("oproute_8outside2_12am"));
		data.setOproute_8outside2_4am(rs.getString("oproute_8outside2_4am"));
		data.setOproute_8outside3_8am(rs.getString("oproute_8outside3_8am"));
		data.setOproute_8outside3_12pm(rs.getString("oproute_8outside3_12pm"));
		data.setOproute_8outside3_4pm(rs.getString("oproute_8outside3_4pm"));
		data.setOproute_8outside3_8pm(rs.getString("oproute_8outside3_8pm"));
		data.setOproute_8outside3_12am(rs.getString("oproute_8outside3_12am"));
		data.setOproute_8outside3_4am(rs.getString("oproute_8outside3_4am"));
		data.setOproute_8outside4_8am(rs.getString("oproute_8outside4_8am"));
		data.setOproute_8outside4_12pm(rs.getString("oproute_8outside4_12pm"));
		data.setOproute_8outside4_4pm(rs.getString("oproute_8outside4_4pm"));
		data.setOproute_8outside4_8pm(rs.getString("oproute_8outside4_8pm"));
		data.setOproute_8outside4_12am(rs.getString("oproute_8outside4_12am"));
		data.setOproute_8outside4_4am(rs.getString("oproute_8outside4_4am"));
		data.setOproute_8outside5_8am(rs.getString("oproute_8outside5_8am"));
		data.setOproute_8outside5_12pm(rs.getString("oproute_8outside5_12pm"));
		data.setOproute_8outside5_4pm(rs.getString("oproute_8outside5_4pm"));
		data.setOproute_8outside5_8pm(rs.getString("oproute_8outside5_8pm"));
		data.setOproute_8outside5_12am(rs.getString("oproute_8outside5_12am"));
		data.setOproute_8outside5_4am(rs.getString("oproute_8outside5_4am"));
		data.setOproute_8outside6_8am(rs.getString("oproute_8outside6_8am"));
		data.setOproute_8outside6_12pm(rs.getString("oproute_8outside6_12pm"));
		data.setOproute_8outside6_4pm(rs.getString("oproute_8outside6_4pm"));
		data.setOproute_8outside6_8pm(rs.getString("oproute_8outside6_8pm"));
		data.setOproute_8outside6_12am(rs.getString("oproute_8outside6_12am"));
		data.setOproute_8outside6_4am(rs.getString("oproute_8outside6_4am"));
		data.setOproute_8outside7_8am(rs.getString("oproute_8outside7_8am"));
		data.setOproute_8outside7_12pm(rs.getString("oproute_8outside7_12pm"));
		data.setOproute_8outside7_4pm(rs.getString("oproute_8outside7_4pm"));
		data.setOproute_8outside7_8pm(rs.getString("oproute_8outside7_8pm"));
		data.setOproute_8outside7_12am(rs.getString("oproute_8outside7_12am"));
		data.setOproute_8outside7_4am(rs.getString("oproute_8outside7_4am"));
		data.setOproute_8outside8_8am(rs.getString("oproute_8outside8_8am"));
		data.setOproute_8outside8_12pm(rs.getString("oproute_8outside8_12pm"));
		data.setOproute_8outside8_4pm(rs.getString("oproute_8outside8_4pm"));
		data.setOproute_8outside8_8pm(rs.getString("oproute_8outside8_8pm"));
		data.setOproute_8outside8_12am(rs.getString("oproute_8outside8_12am"));
		data.setOproute_8outside8_4am(rs.getString("oproute_8outside8_4am"));
		data.setOproute_8outside9_8am(rs.getString("oproute_8outside9_8am"));
		data.setOproute_8outside9_12pm(rs.getString("oproute_8outside9_12pm"));
		data.setOproute_8outside9_4pm(rs.getString("oproute_8outside9_4pm"));
		data.setOproute_8outside9_8pm(rs.getString("oproute_8outside9_8pm"));
		data.setOproute_8outside9_12am(rs.getString("oproute_8outside9_12am"));
		data.setOproute_8outside9_4am(rs.getString("oproute_8outside9_4am"));
		data.setOproute_8outside10_8am(rs.getString("oproute_8outside10_8am"));
		data.setOproute_8outside10_12pm(rs.getString("oproute_8outside10_12pm"));
		data.setOproute_8outside10_4pm(rs.getString("oproute_8outside10_4pm"));
		data.setOproute_8outside10_8pm(rs.getString("oproute_8outside10_8pm"));
		data.setOproute_8outside10_12am(rs.getString("oproute_8outside10_12am"));
		data.setOproute_8outside10_4am(rs.getString("oproute_8outside10_4am"));
		data.setOproute_8outside11_8am(rs.getString("oproute_8outside11_8am"));
		data.setOproute_8outside11_12pm(rs.getString("oproute_8outside11_12pm"));
		data.setOproute_8outside11_4pm(rs.getString("oproute_8outside11_4pm"));
		data.setOproute_8outside11_8pm(rs.getString("oproute_8outside11_8pm"));
		data.setOproute_8outside11_12am(rs.getString("oproute_8outside11_12am"));
		data.setOproute_8outside11_4am(rs.getString("oproute_8outside11_4am"));
		data.setOproute_8outside12_8am(rs.getString("oproute_8outside12_8am"));
		data.setOproute_8outside12_12pm(rs.getString("oproute_8outside12_12pm"));
		data.setOproute_8outside12_4pm(rs.getString("oproute_8outside12_4pm"));
		data.setOproute_8outside12_8pm(rs.getString("oproute_8outside12_8pm"));
		data.setOproute_8outside12_12am(rs.getString("oproute_8outside12_12am"));
		data.setOproute_8outside12_4am(rs.getString("oproute_8outside12_4am"));
		data.setOproute_8outside13_8am(rs.getString("oproute_8outside13_8am"));
		data.setOproute_8outside13_12pm(rs.getString("oproute_8outside13_12pm"));
		data.setOproute_8outside13_4pm(rs.getString("oproute_8outside13_4pm"));
		data.setOproute_8outside13_8pm(rs.getString("oproute_8outside13_8pm"));
		data.setOproute_8outside13_12am(rs.getString("oproute_8outside13_12am"));
		data.setOproute_8outside13_4am(rs.getString("oproute_8outside13_4am"));
		data.setOproute_8outside14_8am(rs.getString("oproute_8outside14_8am"));
		data.setOproute_8outside14_12pm(rs.getString("oproute_8outside14_12pm"));
		data.setOproute_8outside14_4pm(rs.getString("oproute_8outside14_4pm"));
		data.setOproute_8outside14_8pm(rs.getString("oproute_8outside14_8pm"));
		data.setOproute_8outside14_12am(rs.getString("oproute_8outside14_12am"));
		data.setOproute_8outside14_4am(rs.getString("oproute_8outside14_4am"));
		data.setOproute_8outside15_8am(rs.getString("oproute_8outside15_8am"));
		data.setOproute_8outside15_12pm(rs.getString("oproute_8outside15_12pm"));
		data.setOproute_8outside15_4pm(rs.getString("oproute_8outside15_4pm"));
		data.setOproute_8outside15_8pm(rs.getString("oproute_8outside15_8pm"));
		data.setOproute_8outside15_12am(rs.getString("oproute_8outside15_12am"));
		data.setOproute_8outside15_4am(rs.getString("oproute_8outside15_4am"));
		data.setOproute_8outside16_8am(rs.getString("oproute_8outside16_8am"));
		data.setOproute_8outside16_12pm(rs.getString("oproute_8outside16_12pm"));
		data.setOproute_8outside16_4pm(rs.getString("oproute_8outside16_4pm"));
		data.setOproute_8outside16_8pm(rs.getString("oproute_8outside16_8pm"));
		data.setOproute_8outside16_12am(rs.getString("oproute_8outside16_12am"));
		data.setOproute_8outside16_4am(rs.getString("oproute_8outside16_4am"));
		data.setOproute_8outside17_8am(rs.getString("oproute_8outside17_8am"));
		data.setOproute_8outside17_12pm(rs.getString("oproute_8outside17_12pm"));
		data.setOproute_8outside17_4pm(rs.getString("oproute_8outside17_4pm"));
		data.setOproute_8outside17_8pm(rs.getString("oproute_8outside17_8pm"));
		data.setOproute_8outside17_12am(rs.getString("oproute_8outside17_12am"));
		data.setOproute_8outside17_4am(rs.getString("oproute_8outside17_4am"));
		data.setOproute_8outside18_8am(rs.getString("oproute_8outside18_8am"));
		data.setOproute_8outside18_12pm(rs.getString("oproute_8outside18_12pm"));
		data.setOproute_8outside18_4pm(rs.getString("oproute_8outside18_4pm"));
		data.setOproute_8outside18_8pm(rs.getString("oproute_8outside18_8pm"));
		data.setOproute_8outside18_12am(rs.getString("oproute_8outside18_12am"));
		data.setOproute_8outside18_4am(rs.getString("oproute_8outside18_4am"));
		data.setOproute_8outside19_8am(rs.getString("oproute_8outside19_8am"));
		data.setOproute_8outside19_12pm(rs.getString("oproute_8outside19_12pm"));
		data.setOproute_8outside19_4pm(rs.getString("oproute_8outside19_4pm"));
		data.setOproute_8outside19_8pm(rs.getString("oproute_8outside19_8pm"));
		data.setOproute_8outside19_12am(rs.getString("oproute_8outside19_12am"));
		data.setOproute_8outside19_4am(rs.getString("oproute_8outside19_4am"));
		data.setOproute_8outside20_8am(rs.getString("oproute_8outside20_8am"));
		data.setOproute_8outside20_12pm(rs.getString("oproute_8outside20_12pm"));
		data.setOproute_8outside20_4pm(rs.getString("oproute_8outside20_4pm"));
		data.setOproute_8outside20_8pm(rs.getString("oproute_8outside20_8pm"));
		data.setOproute_8outside20_12am(rs.getString("oproute_8outside20_12am"));
		data.setOproute_8outside20_4am(rs.getString("oproute_8outside20_4am"));
		data.setOproute_8outside21_8am(rs.getString("oproute_8outside21_8am"));
		data.setOproute_8outside21_12pm(rs.getString("oproute_8outside21_12pm"));
		data.setOproute_8outside21_4pm(rs.getString("oproute_8outside21_4pm"));
		data.setOproute_8outside21_8pm(rs.getString("oproute_8outside21_8pm"));
		data.setOproute_8outside21_12am(rs.getString("oproute_8outside21_12am"));
		data.setOproute_8outside21_4am(rs.getString("oproute_8outside21_4am"));
		data.setOproute_8outside22_8am(rs.getString("oproute_8outside22_8am"));
		data.setOproute_8outside22_12pm(rs.getString("oproute_8outside22_12pm"));
		data.setOproute_8outside22_4pm(rs.getString("oproute_8outside22_4pm"));
		data.setOproute_8outside22_8pm(rs.getString("oproute_8outside22_8pm"));
		data.setOproute_8outside22_12am(rs.getString("oproute_8outside22_12am"));
		data.setOproute_8outside22_4am(rs.getString("oproute_8outside22_4am"));
		data.setOproute_8outside23_8am(rs.getString("oproute_8outside23_8am"));
		data.setOproute_8outside23_12pm(rs.getString("oproute_8outside23_12pm"));
		data.setOproute_8outside23_4pm(rs.getString("oproute_8outside23_4pm"));
		data.setOproute_8outside23_8pm(rs.getString("oproute_8outside23_8pm"));
		data.setOproute_8outside23_12am(rs.getString("oproute_8outside23_12am"));
		data.setOproute_8outside23_4am(rs.getString("oproute_8outside23_4am"));
		data.setOproute_8outside24_8am(rs.getString("oproute_8outside24_8am"));
		data.setOproute_8outside24_12pm(rs.getString("oproute_8outside24_12pm"));
		data.setOproute_8outside24_4pm(rs.getString("oproute_8outside24_4pm"));
		data.setOproute_8outside24_8pm(rs.getString("oproute_8outside24_8pm"));
		data.setOproute_8outside24_12am(rs.getString("oproute_8outside24_12am"));
		data.setOproute_8outside24_4am(rs.getString("oproute_8outside24_4am"));
		data.setOproute_8outside25_8am(rs.getString("oproute_8outside25_8am"));
		data.setOproute_8outside25_12pm(rs.getString("oproute_8outside25_12pm"));
		data.setOproute_8outside25_4pm(rs.getString("oproute_8outside25_4pm"));
		data.setOproute_8outside25_8pm(rs.getString("oproute_8outside25_8pm"));
		data.setOproute_8outside25_12am(rs.getString("oproute_8outside25_12am"));
		data.setOproute_8outside25_4am(rs.getString("oproute_8outside25_4am"));
		data.setOproute_8outside26_8am(rs.getString("oproute_8outside26_8am"));
		data.setOproute_8outside26_12pm(rs.getString("oproute_8outside26_12pm"));
		data.setOproute_8outside26_4pm(rs.getString("oproute_8outside26_4pm"));
		data.setOproute_8outside26_8pm(rs.getString("oproute_8outside26_8pm"));
		data.setOproute_8outside26_12am(rs.getString("oproute_8outside26_12am"));
		data.setOproute_8outside26_4am(rs.getString("oproute_8outside26_4am"));
		data.setOproute_8outside27_8am(rs.getString("oproute_8outside27_8am"));
		data.setOproute_8outside27_12pm(rs.getString("oproute_8outside27_12pm"));
		data.setOproute_8outside27_4pm(rs.getString("oproute_8outside27_4pm"));
		data.setOproute_8outside27_8pm(rs.getString("oproute_8outside27_8pm"));
		data.setOproute_8outside27_12am(rs.getString("oproute_8outside27_12am"));
		data.setOproute_8outside27_4am(rs.getString("oproute_8outside27_4am"));
		data.setOproute_8outside28_8am(rs.getString("oproute_8outside28_8am"));
		data.setOproute_8outside28_12pm(rs.getString("oproute_8outside28_12pm"));
		data.setOproute_8outside28_4pm(rs.getString("oproute_8outside28_4pm"));
		data.setOproute_8outside28_8pm(rs.getString("oproute_8outside28_8pm"));
		data.setOproute_8outside28_12am(rs.getString("oproute_8outside28_12am"));
		data.setOproute_8outside28_4am(rs.getString("oproute_8outside28_4am"));
		data.setOproute_8outside29_8am(rs.getString("oproute_8outside29_8am"));
		data.setOproute_8outside29_12pm(rs.getString("oproute_8outside29_12pm"));
		data.setOproute_8outside29_4pm(rs.getString("oproute_8outside29_4pm"));
		data.setOproute_8outside29_8pm(rs.getString("oproute_8outside29_8pm"));
		data.setOproute_8outside29_12am(rs.getString("oproute_8outside29_12am"));
		data.setOproute_8outside29_4am(rs.getString("oproute_8outside29_4am"));
		data.setOproute_8outside30_8am(rs.getString("oproute_8outside30_8am"));
		data.setOproute_8outside30_12pm(rs.getString("oproute_8outside30_12pm"));
		data.setOproute_8outside30_4pm(rs.getString("oproute_8outside30_4pm"));
		data.setOproute_8outside30_8pm(rs.getString("oproute_8outside30_8pm"));
		data.setOproute_8outside30_12am(rs.getString("oproute_8outside30_12am"));
		data.setOproute_8outside30_4am(rs.getString("oproute_8outside30_4am"));
		
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
		return oproute_8;
	}
	@Override
	public long getCountDatePercentage(String sdate,String edate) throws Exception {
		int _8am=0,_12pm=0,_4pm=0,_8pm=0,_12am=0,_4am=0;
		long _8ampercent=0, _12pmpercent=0,_4pmpercent=0,_8pmpercent=0,_12ampercent=0,_4ampercent=0;
	 	long percent=0;
		List<OpRoute_8> lst= getData(sdate,edate);
		for(OpRoute_8 data:lst)
		{
			if(data.getOproute_8outside1_8am()!=null&&!data.getOproute_8outside1_8am().equals("")){_8am++;}
			if(data.getOproute_8outside2_8am()!=null&&!data.getOproute_8outside2_8am().equals("")){_8am++;}
			if(data.getOproute_8outside3_8am()!=null&&!data.getOproute_8outside3_8am().equals("")){_8am++;}
			if(data.getOproute_8outside4_8am()!=null&&!data.getOproute_8outside4_8am().equals("")){_8am++;}
			if(data.getOproute_8outside5_8am()!=null&&!data.getOproute_8outside5_8am().equals("")){_8am++;}
			if(data.getOproute_8outside6_8am()!=null&&!data.getOproute_8outside6_8am().equals("")){_8am++;}
			if(data.getOproute_8outside7_8am()!=null&&!data.getOproute_8outside7_8am().equals("")){_8am++;}
			if(data.getOproute_8outside8_8am()!=null&&!data.getOproute_8outside8_8am().equals("")){_8am++;}
			if(data.getOproute_8outside9_8am()!=null&&!data.getOproute_8outside9_8am().equals("")){_8am++;}
			if(data.getOproute_8outside10_8am()!=null&&!data.getOproute_8outside10_8am().equals("")){_8am++;}
			if(data.getOproute_8outside11_8am()!=null&&!data.getOproute_8outside11_8am().equals("")){_8am++;}
			if(data.getOproute_8outside12_8am()!=null&&!data.getOproute_8outside12_8am().equals("")){_8am++;}
			if(data.getOproute_8outside13_8am()!=null&&!data.getOproute_8outside13_8am().equals("")){_8am++;}
			if(data.getOproute_8outside14_8am()!=null&&!data.getOproute_8outside14_8am().equals("")){_8am++;}
			if(data.getOproute_8outside15_8am()!=null&&!data.getOproute_8outside15_8am().equals("")){_8am++;}
			if(data.getOproute_8outside16_8am()!=null&&!data.getOproute_8outside16_8am().equals("")){_8am++;}
			if(data.getOproute_8outside17_8am()!=null&&!data.getOproute_8outside17_8am().equals("")){_8am++;}
			if(data.getOproute_8outside18_8am()!=null&&!data.getOproute_8outside18_8am().equals("")){_8am++;}
			if(data.getOproute_8outside19_8am()!=null&&!data.getOproute_8outside19_8am().equals("")){_8am++;}
			if(data.getOproute_8outside20_8am()!=null&&!data.getOproute_8outside20_8am().equals("")){_8am++;}
			if(data.getOproute_8outside21_8am()!=null&&!data.getOproute_8outside21_8am().equals("")){_8am++;}
			if(data.getOproute_8outside22_8am()!=null&&!data.getOproute_8outside22_8am().equals("")){_8am++;}
			if(data.getOproute_8outside23_8am()!=null&&!data.getOproute_8outside23_8am().equals("")){_8am++;}
			if(data.getOproute_8outside24_8am()!=null&&!data.getOproute_8outside24_8am().equals("")){_8am++;}
			if(data.getOproute_8outside25_8am()!=null&&!data.getOproute_8outside25_8am().equals("")){_8am++;}
			if(data.getOproute_8outside26_8am()!=null&&!data.getOproute_8outside26_8am().equals("")){_8am++;}
			if(data.getOproute_8outside27_8am()!=null&&!data.getOproute_8outside27_8am().equals("")){_8am++;}
			if(data.getOproute_8outside28_8am()!=null&&!data.getOproute_8outside28_8am().equals("")){_8am++;}
			if(data.getOproute_8outside29_8am()!=null&&!data.getOproute_8outside29_8am().equals("")){_8am++;}
			if(data.getOproute_8outside30_8am()!=null&&!data.getOproute_8outside30_8am().equals("")){_8am++;}
			if(data.getOproute_8outside1_12pm()!=null&&!data.getOproute_8outside1_12pm().equals("")){_12pm++;}
			if(data.getOproute_8outside2_12pm()!=null&&!data.getOproute_8outside2_12pm().equals("")){_12pm++;}
			if(data.getOproute_8outside3_12pm()!=null&&!data.getOproute_8outside3_12pm().equals("")){_12pm++;}
			if(data.getOproute_8outside4_12pm()!=null&&!data.getOproute_8outside4_12pm().equals("")){_12pm++;}
			if(data.getOproute_8outside5_12pm()!=null&&!data.getOproute_8outside5_12pm().equals("")){_12pm++;}
			if(data.getOproute_8outside6_12pm()!=null&&!data.getOproute_8outside6_12pm().equals("")){_12pm++;}
			if(data.getOproute_8outside7_12pm()!=null&&!data.getOproute_8outside7_12pm().equals("")){_12pm++;}
			if(data.getOproute_8outside8_12pm()!=null&&!data.getOproute_8outside8_12pm().equals("")){_12pm++;}
			if(data.getOproute_8outside9_12pm()!=null&&!data.getOproute_8outside9_12pm().equals("")){_12pm++;}
			if(data.getOproute_8outside10_12pm()!=null&&!data.getOproute_8outside10_12pm().equals("")){_12pm++;}
			if(data.getOproute_8outside11_12pm()!=null&&!data.getOproute_8outside11_12pm().equals("")){_12pm++;}
			if(data.getOproute_8outside12_12pm()!=null&&!data.getOproute_8outside12_12pm().equals("")){_12pm++;}
			if(data.getOproute_8outside13_12pm()!=null&&!data.getOproute_8outside13_12pm().equals("")){_12pm++;}
			if(data.getOproute_8outside14_12pm()!=null&&!data.getOproute_8outside14_12pm().equals("")){_12pm++;}
			if(data.getOproute_8outside15_12pm()!=null&&!data.getOproute_8outside15_12pm().equals("")){_12pm++;}
			if(data.getOproute_8outside16_12pm()!=null&&!data.getOproute_8outside16_12pm().equals("")){_12pm++;}
			if(data.getOproute_8outside17_12pm()!=null&&!data.getOproute_8outside17_12pm().equals("")){_12pm++;}
			if(data.getOproute_8outside18_12pm()!=null&&!data.getOproute_8outside18_12pm().equals("")){_12pm++;}
			if(data.getOproute_8outside19_12pm()!=null&&!data.getOproute_8outside19_12pm().equals("")){_12pm++;}
			if(data.getOproute_8outside20_12pm()!=null&&!data.getOproute_8outside20_12pm().equals("")){_12pm++;}
			if(data.getOproute_8outside21_12pm()!=null&&!data.getOproute_8outside21_12pm().equals("")){_12pm++;}
			if(data.getOproute_8outside22_12pm()!=null&&!data.getOproute_8outside22_12pm().equals("")){_12pm++;}
			if(data.getOproute_8outside23_12pm()!=null&&!data.getOproute_8outside23_12pm().equals("")){_12pm++;}
			if(data.getOproute_8outside24_12pm()!=null&&!data.getOproute_8outside24_12pm().equals("")){_12pm++;}
			if(data.getOproute_8outside25_12pm()!=null&&!data.getOproute_8outside25_12pm().equals("")){_12pm++;}
			if(data.getOproute_8outside26_12pm()!=null&&!data.getOproute_8outside26_12pm().equals("")){_12pm++;}
			if(data.getOproute_8outside27_12pm()!=null&&!data.getOproute_8outside27_12pm().equals("")){_12pm++;}
			if(data.getOproute_8outside28_12pm()!=null&&!data.getOproute_8outside28_12pm().equals("")){_12pm++;}
			if(data.getOproute_8outside29_12pm()!=null&&!data.getOproute_8outside29_12pm().equals("")){_12pm++;}
			if(data.getOproute_8outside30_12pm()!=null&&!data.getOproute_8outside30_12pm().equals("")){_12pm++;}

			if(data.getOproute_8outside1_4pm()!=null&&!data.getOproute_8outside1_4pm().equals("")){_4pm++;}
			if(data.getOproute_8outside2_4pm()!=null&&!data.getOproute_8outside2_4pm().equals("")){_4pm++;}
			if(data.getOproute_8outside3_4pm()!=null&&!data.getOproute_8outside3_4pm().equals("")){_4pm++;}
			if(data.getOproute_8outside4_4pm()!=null&&!data.getOproute_8outside4_4pm().equals("")){_4pm++;}
			if(data.getOproute_8outside5_4pm()!=null&&!data.getOproute_8outside5_4pm().equals("")){_4pm++;}
			if(data.getOproute_8outside6_4pm()!=null&&!data.getOproute_8outside6_4pm().equals("")){_4pm++;}
			if(data.getOproute_8outside7_4pm()!=null&&!data.getOproute_8outside7_4pm().equals("")){_4pm++;}
			if(data.getOproute_8outside8_4pm()!=null&&!data.getOproute_8outside8_4pm().equals("")){_4pm++;}
			if(data.getOproute_8outside9_4pm()!=null&&!data.getOproute_8outside9_4pm().equals("")){_4pm++;}
			if(data.getOproute_8outside10_4pm()!=null&&!data.getOproute_8outside10_4pm().equals("")){_4pm++;}
			if(data.getOproute_8outside11_4pm()!=null&&!data.getOproute_8outside11_4pm().equals("")){_4pm++;}
			if(data.getOproute_8outside12_4pm()!=null&&!data.getOproute_8outside12_4pm().equals("")){_4pm++;}
			if(data.getOproute_8outside13_4pm()!=null&&!data.getOproute_8outside13_4pm().equals("")){_4pm++;}
			if(data.getOproute_8outside14_4pm()!=null&&!data.getOproute_8outside14_4pm().equals("")){_4pm++;}
			if(data.getOproute_8outside15_4pm()!=null&&!data.getOproute_8outside15_4pm().equals("")){_4pm++;}
			if(data.getOproute_8outside16_4pm()!=null&&!data.getOproute_8outside16_4pm().equals("")){_4pm++;}
			if(data.getOproute_8outside17_4pm()!=null&&!data.getOproute_8outside17_4pm().equals("")){_4pm++;}
			if(data.getOproute_8outside18_4pm()!=null&&!data.getOproute_8outside18_4pm().equals("")){_4pm++;}
			if(data.getOproute_8outside19_4pm()!=null&&!data.getOproute_8outside19_4pm().equals("")){_4pm++;}
			if(data.getOproute_8outside20_4pm()!=null&&!data.getOproute_8outside20_4pm().equals("")){_4pm++;}
			if(data.getOproute_8outside21_4pm()!=null&&!data.getOproute_8outside21_4pm().equals("")){_4pm++;}
			if(data.getOproute_8outside22_4pm()!=null&&!data.getOproute_8outside22_4pm().equals("")){_4pm++;}
			if(data.getOproute_8outside23_4pm()!=null&&!data.getOproute_8outside23_4pm().equals("")){_4pm++;}
			if(data.getOproute_8outside24_4pm()!=null&&!data.getOproute_8outside24_4pm().equals("")){_4pm++;}
			if(data.getOproute_8outside25_4pm()!=null&&!data.getOproute_8outside25_4pm().equals("")){_4pm++;}
			if(data.getOproute_8outside26_4pm()!=null&&!data.getOproute_8outside26_4pm().equals("")){_4pm++;}
			if(data.getOproute_8outside27_4pm()!=null&&!data.getOproute_8outside27_4pm().equals("")){_4pm++;}
			if(data.getOproute_8outside28_4pm()!=null&&!data.getOproute_8outside28_4pm().equals("")){_4pm++;}
			if(data.getOproute_8outside29_4pm()!=null&&!data.getOproute_8outside29_4pm().equals("")){_4pm++;}
			if(data.getOproute_8outside30_4pm()!=null&&!data.getOproute_8outside30_4pm().equals("")){_4pm++;}

			if(data.getOproute_8outside1_8pm()!=null&&!data.getOproute_8outside1_8pm().equals("")){_8pm++;}
			if(data.getOproute_8outside2_8pm()!=null&&!data.getOproute_8outside2_8pm().equals("")){_8pm++;}
			if(data.getOproute_8outside3_8pm()!=null&&!data.getOproute_8outside3_8pm().equals("")){_8pm++;}
			if(data.getOproute_8outside4_8pm()!=null&&!data.getOproute_8outside4_8pm().equals("")){_8pm++;}
			if(data.getOproute_8outside5_8pm()!=null&&!data.getOproute_8outside5_8pm().equals("")){_8pm++;}
			if(data.getOproute_8outside6_8pm()!=null&&!data.getOproute_8outside6_8pm().equals("")){_8pm++;}
			if(data.getOproute_8outside7_8pm()!=null&&!data.getOproute_8outside7_8pm().equals("")){_8pm++;}
			if(data.getOproute_8outside8_8pm()!=null&&!data.getOproute_8outside8_8pm().equals("")){_8pm++;}
			if(data.getOproute_8outside9_8pm()!=null&&!data.getOproute_8outside9_8pm().equals("")){_8pm++;}
			if(data.getOproute_8outside10_8pm()!=null&&!data.getOproute_8outside10_8pm().equals("")){_8pm++;}
			if(data.getOproute_8outside11_8pm()!=null&&!data.getOproute_8outside11_8pm().equals("")){_8pm++;}
			if(data.getOproute_8outside12_8pm()!=null&&!data.getOproute_8outside12_8pm().equals("")){_8pm++;}
			if(data.getOproute_8outside13_8pm()!=null&&!data.getOproute_8outside13_8pm().equals("")){_8pm++;}
			if(data.getOproute_8outside14_8pm()!=null&&!data.getOproute_8outside14_8pm().equals("")){_8pm++;}
			if(data.getOproute_8outside15_8pm()!=null&&!data.getOproute_8outside15_8pm().equals("")){_8pm++;}
			if(data.getOproute_8outside16_8pm()!=null&&!data.getOproute_8outside16_8pm().equals("")){_8pm++;}
			if(data.getOproute_8outside17_8pm()!=null&&!data.getOproute_8outside17_8pm().equals("")){_8pm++;}
			if(data.getOproute_8outside18_8pm()!=null&&!data.getOproute_8outside18_8pm().equals("")){_8pm++;}
			if(data.getOproute_8outside19_8pm()!=null&&!data.getOproute_8outside19_8pm().equals("")){_8pm++;}
			if(data.getOproute_8outside20_8pm()!=null&&!data.getOproute_8outside20_8pm().equals("")){_8pm++;}
			if(data.getOproute_8outside21_8pm()!=null&&!data.getOproute_8outside21_8pm().equals("")){_8pm++;}
			if(data.getOproute_8outside22_8pm()!=null&&!data.getOproute_8outside22_8pm().equals("")){_8pm++;}
			if(data.getOproute_8outside23_8pm()!=null&&!data.getOproute_8outside23_8pm().equals("")){_8pm++;}
			if(data.getOproute_8outside24_8pm()!=null&&!data.getOproute_8outside24_8pm().equals("")){_8pm++;}
			if(data.getOproute_8outside25_8pm()!=null&&!data.getOproute_8outside25_8pm().equals("")){_8pm++;}
			if(data.getOproute_8outside26_8pm()!=null&&!data.getOproute_8outside26_8pm().equals("")){_8pm++;}
			if(data.getOproute_8outside27_8pm()!=null&&!data.getOproute_8outside27_8pm().equals("")){_8pm++;}
			if(data.getOproute_8outside28_8pm()!=null&&!data.getOproute_8outside28_8pm().equals("")){_8pm++;}
			if(data.getOproute_8outside29_8pm()!=null&&!data.getOproute_8outside29_8pm().equals("")){_8pm++;}
			if(data.getOproute_8outside30_8pm()!=null&&!data.getOproute_8outside30_8pm().equals("")){_8pm++;}

			if(data.getOproute_8outside1_12am()!=null&&!data.getOproute_8outside1_12am().equals("")){_12am++;}
			if(data.getOproute_8outside2_12am()!=null&&!data.getOproute_8outside2_12am().equals("")){_12am++;}
			if(data.getOproute_8outside3_12am()!=null&&!data.getOproute_8outside3_12am().equals("")){_12am++;}
			if(data.getOproute_8outside4_12am()!=null&&!data.getOproute_8outside4_12am().equals("")){_12am++;}
			if(data.getOproute_8outside5_12am()!=null&&!data.getOproute_8outside5_12am().equals("")){_12am++;}
			if(data.getOproute_8outside6_12am()!=null&&!data.getOproute_8outside6_12am().equals("")){_12am++;}
			if(data.getOproute_8outside7_12am()!=null&&!data.getOproute_8outside7_12am().equals("")){_12am++;}
			if(data.getOproute_8outside8_12am()!=null&&!data.getOproute_8outside8_12am().equals("")){_12am++;}
			if(data.getOproute_8outside9_12am()!=null&&!data.getOproute_8outside9_12am().equals("")){_12am++;}
			if(data.getOproute_8outside10_12am()!=null&&!data.getOproute_8outside10_12am().equals("")){_12am++;}
			if(data.getOproute_8outside11_12am()!=null&&!data.getOproute_8outside11_12am().equals("")){_12am++;}
			if(data.getOproute_8outside12_12am()!=null&&!data.getOproute_8outside12_12am().equals("")){_12am++;}
			if(data.getOproute_8outside13_12am()!=null&&!data.getOproute_8outside13_12am().equals("")){_12am++;}
			if(data.getOproute_8outside14_12am()!=null&&!data.getOproute_8outside14_12am().equals("")){_12am++;}
			if(data.getOproute_8outside15_12am()!=null&&!data.getOproute_8outside15_12am().equals("")){_12am++;}
			if(data.getOproute_8outside16_12am()!=null&&!data.getOproute_8outside16_12am().equals("")){_12am++;}
			if(data.getOproute_8outside17_12am()!=null&&!data.getOproute_8outside17_12am().equals("")){_12am++;}
			if(data.getOproute_8outside18_12am()!=null&&!data.getOproute_8outside18_12am().equals("")){_12am++;}
			if(data.getOproute_8outside19_12am()!=null&&!data.getOproute_8outside19_12am().equals("")){_12am++;}
			if(data.getOproute_8outside20_12am()!=null&&!data.getOproute_8outside20_12am().equals("")){_12am++;}
			if(data.getOproute_8outside21_12am()!=null&&!data.getOproute_8outside21_12am().equals("")){_12am++;}
			if(data.getOproute_8outside22_12am()!=null&&!data.getOproute_8outside22_12am().equals("")){_12am++;}
			if(data.getOproute_8outside23_12am()!=null&&!data.getOproute_8outside23_12am().equals("")){_12am++;}
			if(data.getOproute_8outside24_12am()!=null&&!data.getOproute_8outside24_12am().equals("")){_12am++;}
			if(data.getOproute_8outside25_12am()!=null&&!data.getOproute_8outside25_12am().equals("")){_12am++;}
			if(data.getOproute_8outside26_12am()!=null&&!data.getOproute_8outside26_12am().equals("")){_12am++;}
			if(data.getOproute_8outside27_12am()!=null&&!data.getOproute_8outside27_12am().equals("")){_12am++;}
			if(data.getOproute_8outside28_12am()!=null&&!data.getOproute_8outside28_12am().equals("")){_12am++;}
			if(data.getOproute_8outside29_12am()!=null&&!data.getOproute_8outside29_12am().equals("")){_12am++;}
			if(data.getOproute_8outside30_12am()!=null&&!data.getOproute_8outside30_12am().equals("")){_12am++;}

			if(data.getOproute_8outside1_4am()!=null&&!data.getOproute_8outside1_4am().equals("")){_4am++;}
			if(data.getOproute_8outside2_4am()!=null&&!data.getOproute_8outside2_4am().equals("")){_4am++;}
			if(data.getOproute_8outside3_4am()!=null&&!data.getOproute_8outside3_4am().equals("")){_4am++;}
			if(data.getOproute_8outside4_4am()!=null&&!data.getOproute_8outside4_4am().equals("")){_4am++;}
			if(data.getOproute_8outside5_4am()!=null&&!data.getOproute_8outside5_4am().equals("")){_4am++;}
			if(data.getOproute_8outside6_4am()!=null&&!data.getOproute_8outside6_4am().equals("")){_4am++;}
			if(data.getOproute_8outside7_4am()!=null&&!data.getOproute_8outside7_4am().equals("")){_4am++;}
			if(data.getOproute_8outside8_4am()!=null&&!data.getOproute_8outside8_4am().equals("")){_4am++;}
			if(data.getOproute_8outside9_4am()!=null&&!data.getOproute_8outside9_4am().equals("")){_4am++;}
			if(data.getOproute_8outside10_4am()!=null&&!data.getOproute_8outside10_4am().equals("")){_4am++;}
			if(data.getOproute_8outside11_4am()!=null&&!data.getOproute_8outside11_4am().equals("")){_4am++;}
			if(data.getOproute_8outside12_4am()!=null&&!data.getOproute_8outside12_4am().equals("")){_4am++;}
			if(data.getOproute_8outside13_4am()!=null&&!data.getOproute_8outside13_4am().equals("")){_4am++;}
			if(data.getOproute_8outside14_4am()!=null&&!data.getOproute_8outside14_4am().equals("")){_4am++;}
			if(data.getOproute_8outside15_4am()!=null&&!data.getOproute_8outside15_4am().equals("")){_4am++;}
			if(data.getOproute_8outside16_4am()!=null&&!data.getOproute_8outside16_4am().equals("")){_4am++;}
			if(data.getOproute_8outside17_4am()!=null&&!data.getOproute_8outside17_4am().equals("")){_4am++;}
			if(data.getOproute_8outside18_4am()!=null&&!data.getOproute_8outside18_4am().equals("")){_4am++;}
			if(data.getOproute_8outside19_4am()!=null&&!data.getOproute_8outside19_4am().equals("")){_4am++;}
			if(data.getOproute_8outside20_4am()!=null&&!data.getOproute_8outside20_4am().equals("")){_4am++;}
			if(data.getOproute_8outside21_4am()!=null&&!data.getOproute_8outside21_4am().equals("")){_4am++;}
			if(data.getOproute_8outside22_4am()!=null&&!data.getOproute_8outside22_4am().equals("")){_4am++;}
			if(data.getOproute_8outside23_4am()!=null&&!data.getOproute_8outside23_4am().equals("")){_4am++;}
			if(data.getOproute_8outside24_4am()!=null&&!data.getOproute_8outside24_4am().equals("")){_4am++;}
			if(data.getOproute_8outside25_4am()!=null&&!data.getOproute_8outside25_4am().equals("")){_4am++;}
			if(data.getOproute_8outside26_4am()!=null&&!data.getOproute_8outside26_4am().equals("")){_4am++;}
			if(data.getOproute_8outside27_4am()!=null&&!data.getOproute_8outside27_4am().equals("")){_4am++;}
			if(data.getOproute_8outside28_4am()!=null&&!data.getOproute_8outside28_4am().equals("")){_4am++;}
			if(data.getOproute_8outside29_4am()!=null&&!data.getOproute_8outside29_4am().equals("")){_4am++;}
			if(data.getOproute_8outside30_4am()!=null&&!data.getOproute_8outside30_4am().equals("")){_4am++;}

			if(_8am>=5){_8ampercent=100;}
			if(_12pm>=5){_12pmpercent=100;}
			if(_4pm>=5){_4pmpercent=100;}
			if(_8pm>=5){_8pmpercent=100;}
			if(_12am>=5){_12ampercent=100;}
			if(_4am>=5){_4ampercent=100;}
			if(data.getCmt9amarea()!=null&&!data.getCmt9amarea().equals(""))
			{_8ampercent=100;}
			if(data.getCmt1pmarea()!=null&&!data.getCmt1pmarea().equals(""))
			{_12pmpercent=100;}			
			if(data.getCmt5pmarea()!=null&&!data.getCmt5pmarea().equals(""))
			{_4pmpercent=100;}
			if(data.getCmt9pmarea()!=null&&!data.getCmt9pmarea().equals(""))
			{_8pmpercent=100;}
			if(data.getCmt1amarea()!=null&&!data.getCmt1amarea().equals(""))
			{_12ampercent=100;}
			if(data.getCmt5amarea()!=null&&!data.getCmt5amarea().equals(""))
			{_4ampercent=100;}
			 percent=(_8ampercent+_12pmpercent+_4pmpercent+_8pmpercent+_12ampercent+_4ampercent)/6;
		}
		return percent;
	}
	@Override
	public List<Integer> getCount(String sdate,String edate) throws Exception {
		int count=0, _8am=0,_12pm=0,_4pm=0,_8pm=0,_12am=0,_4am=0;
		List<Integer> al=new ArrayList<Integer>();
		List<OpRoute_8> lst= getData(sdate,edate);
		for(OpRoute_8 data:lst)
		{
			if(data.getOproute_8outside1_8am()!=null&&!data.getOproute_8outside1_8am().equals("")){_8am++;}
			if(data.getOproute_8outside2_8am()!=null&&!data.getOproute_8outside2_8am().equals("")){_8am++;}
			if(data.getOproute_8outside3_8am()!=null&&!data.getOproute_8outside3_8am().equals("")){_8am++;}
			if(data.getOproute_8outside4_8am()!=null&&!data.getOproute_8outside4_8am().equals("")){_8am++;}
			if(data.getOproute_8outside5_8am()!=null&&!data.getOproute_8outside5_8am().equals("")){_8am++;}
			if(data.getOproute_8outside6_8am()!=null&&!data.getOproute_8outside6_8am().equals("")){_8am++;}
			if(data.getOproute_8outside7_8am()!=null&&!data.getOproute_8outside7_8am().equals("")){_8am++;}
			if(data.getOproute_8outside8_8am()!=null&&!data.getOproute_8outside8_8am().equals("")){_8am++;}
			if(data.getOproute_8outside9_8am()!=null&&!data.getOproute_8outside9_8am().equals("")){_8am++;}
			if(data.getOproute_8outside10_8am()!=null&&!data.getOproute_8outside10_8am().equals("")){_8am++;}
			if(data.getOproute_8outside11_8am()!=null&&!data.getOproute_8outside11_8am().equals("")){_8am++;}
			if(data.getOproute_8outside12_8am()!=null&&!data.getOproute_8outside12_8am().equals("")){_8am++;}
			if(data.getOproute_8outside13_8am()!=null&&!data.getOproute_8outside13_8am().equals("")){_8am++;}
			if(data.getOproute_8outside14_8am()!=null&&!data.getOproute_8outside14_8am().equals("")){_8am++;}
			if(data.getOproute_8outside15_8am()!=null&&!data.getOproute_8outside15_8am().equals("")){_8am++;}
			if(data.getOproute_8outside16_8am()!=null&&!data.getOproute_8outside16_8am().equals("")){_8am++;}
			if(data.getOproute_8outside17_8am()!=null&&!data.getOproute_8outside17_8am().equals("")){_8am++;}
			if(data.getOproute_8outside18_8am()!=null&&!data.getOproute_8outside18_8am().equals("")){_8am++;}
			if(data.getOproute_8outside19_8am()!=null&&!data.getOproute_8outside19_8am().equals("")){_8am++;}
			if(data.getOproute_8outside20_8am()!=null&&!data.getOproute_8outside20_8am().equals("")){_8am++;}
			if(data.getOproute_8outside21_8am()!=null&&!data.getOproute_8outside21_8am().equals("")){_8am++;}
			if(data.getOproute_8outside22_8am()!=null&&!data.getOproute_8outside22_8am().equals("")){_8am++;}
			if(data.getOproute_8outside23_8am()!=null&&!data.getOproute_8outside23_8am().equals("")){_8am++;}
			if(data.getOproute_8outside24_8am()!=null&&!data.getOproute_8outside24_8am().equals("")){_8am++;}
			if(data.getOproute_8outside25_8am()!=null&&!data.getOproute_8outside25_8am().equals("")){_8am++;}
			if(data.getOproute_8outside26_8am()!=null&&!data.getOproute_8outside26_8am().equals("")){_8am++;}
			if(data.getOproute_8outside27_8am()!=null&&!data.getOproute_8outside27_8am().equals("")){_8am++;}
			if(data.getOproute_8outside28_8am()!=null&&!data.getOproute_8outside28_8am().equals("")){_8am++;}
			if(data.getOproute_8outside29_8am()!=null&&!data.getOproute_8outside29_8am().equals("")){_8am++;}
			if(data.getOproute_8outside30_8am()!=null&&!data.getOproute_8outside30_8am().equals("")){_8am++;}
			if(data.getOproute_8outside1_12pm()!=null&&!data.getOproute_8outside1_12pm().equals("")){_12pm++;}
			if(data.getOproute_8outside2_12pm()!=null&&!data.getOproute_8outside2_12pm().equals("")){_12pm++;}
			if(data.getOproute_8outside3_12pm()!=null&&!data.getOproute_8outside3_12pm().equals("")){_12pm++;}
			if(data.getOproute_8outside4_12pm()!=null&&!data.getOproute_8outside4_12pm().equals("")){_12pm++;}
			if(data.getOproute_8outside5_12pm()!=null&&!data.getOproute_8outside5_12pm().equals("")){_12pm++;}
			if(data.getOproute_8outside6_12pm()!=null&&!data.getOproute_8outside6_12pm().equals("")){_12pm++;}
			if(data.getOproute_8outside7_12pm()!=null&&!data.getOproute_8outside7_12pm().equals("")){_12pm++;}
			if(data.getOproute_8outside8_12pm()!=null&&!data.getOproute_8outside8_12pm().equals("")){_12pm++;}
			if(data.getOproute_8outside9_12pm()!=null&&!data.getOproute_8outside9_12pm().equals("")){_12pm++;}
			if(data.getOproute_8outside10_12pm()!=null&&!data.getOproute_8outside10_12pm().equals("")){_12pm++;}
			if(data.getOproute_8outside11_12pm()!=null&&!data.getOproute_8outside11_12pm().equals("")){_12pm++;}
			if(data.getOproute_8outside12_12pm()!=null&&!data.getOproute_8outside12_12pm().equals("")){_12pm++;}
			if(data.getOproute_8outside13_12pm()!=null&&!data.getOproute_8outside13_12pm().equals("")){_12pm++;}
			if(data.getOproute_8outside14_12pm()!=null&&!data.getOproute_8outside14_12pm().equals("")){_12pm++;}
			if(data.getOproute_8outside15_12pm()!=null&&!data.getOproute_8outside15_12pm().equals("")){_12pm++;}
			if(data.getOproute_8outside16_12pm()!=null&&!data.getOproute_8outside16_12pm().equals("")){_12pm++;}
			if(data.getOproute_8outside17_12pm()!=null&&!data.getOproute_8outside17_12pm().equals("")){_12pm++;}
			if(data.getOproute_8outside18_12pm()!=null&&!data.getOproute_8outside18_12pm().equals("")){_12pm++;}
			if(data.getOproute_8outside19_12pm()!=null&&!data.getOproute_8outside19_12pm().equals("")){_12pm++;}
			if(data.getOproute_8outside20_12pm()!=null&&!data.getOproute_8outside20_12pm().equals("")){_12pm++;}
			if(data.getOproute_8outside21_12pm()!=null&&!data.getOproute_8outside21_12pm().equals("")){_12pm++;}
			if(data.getOproute_8outside22_12pm()!=null&&!data.getOproute_8outside22_12pm().equals("")){_12pm++;}
			if(data.getOproute_8outside23_12pm()!=null&&!data.getOproute_8outside23_12pm().equals("")){_12pm++;}
			if(data.getOproute_8outside24_12pm()!=null&&!data.getOproute_8outside24_12pm().equals("")){_12pm++;}
			if(data.getOproute_8outside25_12pm()!=null&&!data.getOproute_8outside25_12pm().equals("")){_12pm++;}
			if(data.getOproute_8outside26_12pm()!=null&&!data.getOproute_8outside26_12pm().equals("")){_12pm++;}
			if(data.getOproute_8outside27_12pm()!=null&&!data.getOproute_8outside27_12pm().equals("")){_12pm++;}
			if(data.getOproute_8outside28_12pm()!=null&&!data.getOproute_8outside28_12pm().equals("")){_12pm++;}
			if(data.getOproute_8outside29_12pm()!=null&&!data.getOproute_8outside29_12pm().equals("")){_12pm++;}
			if(data.getOproute_8outside30_12pm()!=null&&!data.getOproute_8outside30_12pm().equals("")){_12pm++;}

			if(data.getOproute_8outside1_4pm()!=null&&!data.getOproute_8outside1_4pm().equals("")){_4pm++;}
			if(data.getOproute_8outside2_4pm()!=null&&!data.getOproute_8outside2_4pm().equals("")){_4pm++;}
			if(data.getOproute_8outside3_4pm()!=null&&!data.getOproute_8outside3_4pm().equals("")){_4pm++;}
			if(data.getOproute_8outside4_4pm()!=null&&!data.getOproute_8outside4_4pm().equals("")){_4pm++;}
			if(data.getOproute_8outside5_4pm()!=null&&!data.getOproute_8outside5_4pm().equals("")){_4pm++;}
			if(data.getOproute_8outside6_4pm()!=null&&!data.getOproute_8outside6_4pm().equals("")){_4pm++;}
			if(data.getOproute_8outside7_4pm()!=null&&!data.getOproute_8outside7_4pm().equals("")){_4pm++;}
			if(data.getOproute_8outside8_4pm()!=null&&!data.getOproute_8outside8_4pm().equals("")){_4pm++;}
			if(data.getOproute_8outside9_4pm()!=null&&!data.getOproute_8outside9_4pm().equals("")){_4pm++;}
			if(data.getOproute_8outside10_4pm()!=null&&!data.getOproute_8outside10_4pm().equals("")){_4pm++;}
			if(data.getOproute_8outside11_4pm()!=null&&!data.getOproute_8outside11_4pm().equals("")){_4pm++;}
			if(data.getOproute_8outside12_4pm()!=null&&!data.getOproute_8outside12_4pm().equals("")){_4pm++;}
			if(data.getOproute_8outside13_4pm()!=null&&!data.getOproute_8outside13_4pm().equals("")){_4pm++;}
			if(data.getOproute_8outside14_4pm()!=null&&!data.getOproute_8outside14_4pm().equals("")){_4pm++;}
			if(data.getOproute_8outside15_4pm()!=null&&!data.getOproute_8outside15_4pm().equals("")){_4pm++;}
			if(data.getOproute_8outside16_4pm()!=null&&!data.getOproute_8outside16_4pm().equals("")){_4pm++;}
			if(data.getOproute_8outside17_4pm()!=null&&!data.getOproute_8outside17_4pm().equals("")){_4pm++;}
			if(data.getOproute_8outside18_4pm()!=null&&!data.getOproute_8outside18_4pm().equals("")){_4pm++;}
			if(data.getOproute_8outside19_4pm()!=null&&!data.getOproute_8outside19_4pm().equals("")){_4pm++;}
			if(data.getOproute_8outside20_4pm()!=null&&!data.getOproute_8outside20_4pm().equals("")){_4pm++;}
			if(data.getOproute_8outside21_4pm()!=null&&!data.getOproute_8outside21_4pm().equals("")){_4pm++;}
			if(data.getOproute_8outside22_4pm()!=null&&!data.getOproute_8outside22_4pm().equals("")){_4pm++;}
			if(data.getOproute_8outside23_4pm()!=null&&!data.getOproute_8outside23_4pm().equals("")){_4pm++;}
			if(data.getOproute_8outside24_4pm()!=null&&!data.getOproute_8outside24_4pm().equals("")){_4pm++;}
			if(data.getOproute_8outside25_4pm()!=null&&!data.getOproute_8outside25_4pm().equals("")){_4pm++;}
			if(data.getOproute_8outside26_4pm()!=null&&!data.getOproute_8outside26_4pm().equals("")){_4pm++;}
			if(data.getOproute_8outside27_4pm()!=null&&!data.getOproute_8outside27_4pm().equals("")){_4pm++;}
			if(data.getOproute_8outside28_4pm()!=null&&!data.getOproute_8outside28_4pm().equals("")){_4pm++;}
			if(data.getOproute_8outside29_4pm()!=null&&!data.getOproute_8outside29_4pm().equals("")){_4pm++;}
			if(data.getOproute_8outside30_4pm()!=null&&!data.getOproute_8outside30_4pm().equals("")){_4pm++;}

			if(data.getOproute_8outside1_8pm()!=null&&!data.getOproute_8outside1_8pm().equals("")){_8pm++;}
			if(data.getOproute_8outside2_8pm()!=null&&!data.getOproute_8outside2_8pm().equals("")){_8pm++;}
			if(data.getOproute_8outside3_8pm()!=null&&!data.getOproute_8outside3_8pm().equals("")){_8pm++;}
			if(data.getOproute_8outside4_8pm()!=null&&!data.getOproute_8outside4_8pm().equals("")){_8pm++;}
			if(data.getOproute_8outside5_8pm()!=null&&!data.getOproute_8outside5_8pm().equals("")){_8pm++;}
			if(data.getOproute_8outside6_8pm()!=null&&!data.getOproute_8outside6_8pm().equals("")){_8pm++;}
			if(data.getOproute_8outside7_8pm()!=null&&!data.getOproute_8outside7_8pm().equals("")){_8pm++;}
			if(data.getOproute_8outside8_8pm()!=null&&!data.getOproute_8outside8_8pm().equals("")){_8pm++;}
			if(data.getOproute_8outside9_8pm()!=null&&!data.getOproute_8outside9_8pm().equals("")){_8pm++;}
			if(data.getOproute_8outside10_8pm()!=null&&!data.getOproute_8outside10_8pm().equals("")){_8pm++;}
			if(data.getOproute_8outside11_8pm()!=null&&!data.getOproute_8outside11_8pm().equals("")){_8pm++;}
			if(data.getOproute_8outside12_8pm()!=null&&!data.getOproute_8outside12_8pm().equals("")){_8pm++;}
			if(data.getOproute_8outside13_8pm()!=null&&!data.getOproute_8outside13_8pm().equals("")){_8pm++;}
			if(data.getOproute_8outside14_8pm()!=null&&!data.getOproute_8outside14_8pm().equals("")){_8pm++;}
			if(data.getOproute_8outside15_8pm()!=null&&!data.getOproute_8outside15_8pm().equals("")){_8pm++;}
			if(data.getOproute_8outside16_8pm()!=null&&!data.getOproute_8outside16_8pm().equals("")){_8pm++;}
			if(data.getOproute_8outside17_8pm()!=null&&!data.getOproute_8outside17_8pm().equals("")){_8pm++;}
			if(data.getOproute_8outside18_8pm()!=null&&!data.getOproute_8outside18_8pm().equals("")){_8pm++;}
			if(data.getOproute_8outside19_8pm()!=null&&!data.getOproute_8outside19_8pm().equals("")){_8pm++;}
			if(data.getOproute_8outside20_8pm()!=null&&!data.getOproute_8outside20_8pm().equals("")){_8pm++;}
			if(data.getOproute_8outside21_8pm()!=null&&!data.getOproute_8outside21_8pm().equals("")){_8pm++;}
			if(data.getOproute_8outside22_8pm()!=null&&!data.getOproute_8outside22_8pm().equals("")){_8pm++;}
			if(data.getOproute_8outside23_8pm()!=null&&!data.getOproute_8outside23_8pm().equals("")){_8pm++;}
			if(data.getOproute_8outside24_8pm()!=null&&!data.getOproute_8outside24_8pm().equals("")){_8pm++;}
			if(data.getOproute_8outside25_8pm()!=null&&!data.getOproute_8outside25_8pm().equals("")){_8pm++;}
			if(data.getOproute_8outside26_8pm()!=null&&!data.getOproute_8outside26_8pm().equals("")){_8pm++;}
			if(data.getOproute_8outside27_8pm()!=null&&!data.getOproute_8outside27_8pm().equals("")){_8pm++;}
			if(data.getOproute_8outside28_8pm()!=null&&!data.getOproute_8outside28_8pm().equals("")){_8pm++;}
			if(data.getOproute_8outside29_8pm()!=null&&!data.getOproute_8outside29_8pm().equals("")){_8pm++;}
			if(data.getOproute_8outside30_8pm()!=null&&!data.getOproute_8outside30_8pm().equals("")){_8pm++;}

			if(data.getOproute_8outside1_12am()!=null&&!data.getOproute_8outside1_12am().equals("")){_12am++;}
			if(data.getOproute_8outside2_12am()!=null&&!data.getOproute_8outside2_12am().equals("")){_12am++;}
			if(data.getOproute_8outside3_12am()!=null&&!data.getOproute_8outside3_12am().equals("")){_12am++;}
			if(data.getOproute_8outside4_12am()!=null&&!data.getOproute_8outside4_12am().equals("")){_12am++;}
			if(data.getOproute_8outside5_12am()!=null&&!data.getOproute_8outside5_12am().equals("")){_12am++;}
			if(data.getOproute_8outside6_12am()!=null&&!data.getOproute_8outside6_12am().equals("")){_12am++;}
			if(data.getOproute_8outside7_12am()!=null&&!data.getOproute_8outside7_12am().equals("")){_12am++;}
			if(data.getOproute_8outside8_12am()!=null&&!data.getOproute_8outside8_12am().equals("")){_12am++;}
			if(data.getOproute_8outside9_12am()!=null&&!data.getOproute_8outside9_12am().equals("")){_12am++;}
			if(data.getOproute_8outside10_12am()!=null&&!data.getOproute_8outside10_12am().equals("")){_12am++;}
			if(data.getOproute_8outside11_12am()!=null&&!data.getOproute_8outside11_12am().equals("")){_12am++;}
			if(data.getOproute_8outside12_12am()!=null&&!data.getOproute_8outside12_12am().equals("")){_12am++;}
			if(data.getOproute_8outside13_12am()!=null&&!data.getOproute_8outside13_12am().equals("")){_12am++;}
			if(data.getOproute_8outside14_12am()!=null&&!data.getOproute_8outside14_12am().equals("")){_12am++;}
			if(data.getOproute_8outside15_12am()!=null&&!data.getOproute_8outside15_12am().equals("")){_12am++;}
			if(data.getOproute_8outside16_12am()!=null&&!data.getOproute_8outside16_12am().equals("")){_12am++;}
			if(data.getOproute_8outside17_12am()!=null&&!data.getOproute_8outside17_12am().equals("")){_12am++;}
			if(data.getOproute_8outside18_12am()!=null&&!data.getOproute_8outside18_12am().equals("")){_12am++;}
			if(data.getOproute_8outside19_12am()!=null&&!data.getOproute_8outside19_12am().equals("")){_12am++;}
			if(data.getOproute_8outside20_12am()!=null&&!data.getOproute_8outside20_12am().equals("")){_12am++;}
			if(data.getOproute_8outside21_12am()!=null&&!data.getOproute_8outside21_12am().equals("")){_12am++;}
			if(data.getOproute_8outside22_12am()!=null&&!data.getOproute_8outside22_12am().equals("")){_12am++;}
			if(data.getOproute_8outside23_12am()!=null&&!data.getOproute_8outside23_12am().equals("")){_12am++;}
			if(data.getOproute_8outside24_12am()!=null&&!data.getOproute_8outside24_12am().equals("")){_12am++;}
			if(data.getOproute_8outside25_12am()!=null&&!data.getOproute_8outside25_12am().equals("")){_12am++;}
			if(data.getOproute_8outside26_12am()!=null&&!data.getOproute_8outside26_12am().equals("")){_12am++;}
			if(data.getOproute_8outside27_12am()!=null&&!data.getOproute_8outside27_12am().equals("")){_12am++;}
			if(data.getOproute_8outside28_12am()!=null&&!data.getOproute_8outside28_12am().equals("")){_12am++;}
			if(data.getOproute_8outside29_12am()!=null&&!data.getOproute_8outside29_12am().equals("")){_12am++;}
			if(data.getOproute_8outside30_12am()!=null&&!data.getOproute_8outside30_12am().equals("")){_12am++;}

			if(data.getOproute_8outside1_4am()!=null&&!data.getOproute_8outside1_4am().equals("")){_4am++;}
			if(data.getOproute_8outside2_4am()!=null&&!data.getOproute_8outside2_4am().equals("")){_4am++;}
			if(data.getOproute_8outside3_4am()!=null&&!data.getOproute_8outside3_4am().equals("")){_4am++;}
			if(data.getOproute_8outside4_4am()!=null&&!data.getOproute_8outside4_4am().equals("")){_4am++;}
			if(data.getOproute_8outside5_4am()!=null&&!data.getOproute_8outside5_4am().equals("")){_4am++;}
			if(data.getOproute_8outside6_4am()!=null&&!data.getOproute_8outside6_4am().equals("")){_4am++;}
			if(data.getOproute_8outside7_4am()!=null&&!data.getOproute_8outside7_4am().equals("")){_4am++;}
			if(data.getOproute_8outside8_4am()!=null&&!data.getOproute_8outside8_4am().equals("")){_4am++;}
			if(data.getOproute_8outside9_4am()!=null&&!data.getOproute_8outside9_4am().equals("")){_4am++;}
			if(data.getOproute_8outside10_4am()!=null&&!data.getOproute_8outside10_4am().equals("")){_4am++;}
			if(data.getOproute_8outside11_4am()!=null&&!data.getOproute_8outside11_4am().equals("")){_4am++;}
			if(data.getOproute_8outside12_4am()!=null&&!data.getOproute_8outside12_4am().equals("")){_4am++;}
			if(data.getOproute_8outside13_4am()!=null&&!data.getOproute_8outside13_4am().equals("")){_4am++;}
			if(data.getOproute_8outside14_4am()!=null&&!data.getOproute_8outside14_4am().equals("")){_4am++;}
			if(data.getOproute_8outside15_4am()!=null&&!data.getOproute_8outside15_4am().equals("")){_4am++;}
			if(data.getOproute_8outside16_4am()!=null&&!data.getOproute_8outside16_4am().equals("")){_4am++;}
			if(data.getOproute_8outside17_4am()!=null&&!data.getOproute_8outside17_4am().equals("")){_4am++;}
			if(data.getOproute_8outside18_4am()!=null&&!data.getOproute_8outside18_4am().equals("")){_4am++;}
			if(data.getOproute_8outside19_4am()!=null&&!data.getOproute_8outside19_4am().equals("")){_4am++;}
			if(data.getOproute_8outside20_4am()!=null&&!data.getOproute_8outside20_4am().equals("")){_4am++;}
			if(data.getOproute_8outside21_4am()!=null&&!data.getOproute_8outside21_4am().equals("")){_4am++;}
			if(data.getOproute_8outside22_4am()!=null&&!data.getOproute_8outside22_4am().equals("")){_4am++;}
			if(data.getOproute_8outside23_4am()!=null&&!data.getOproute_8outside23_4am().equals("")){_4am++;}
			if(data.getOproute_8outside24_4am()!=null&&!data.getOproute_8outside24_4am().equals("")){_4am++;}
			if(data.getOproute_8outside25_4am()!=null&&!data.getOproute_8outside25_4am().equals("")){_4am++;}
			if(data.getOproute_8outside26_4am()!=null&&!data.getOproute_8outside26_4am().equals("")){_4am++;}
			if(data.getOproute_8outside27_4am()!=null&&!data.getOproute_8outside27_4am().equals("")){_4am++;}
			if(data.getOproute_8outside28_4am()!=null&&!data.getOproute_8outside28_4am().equals("")){_4am++;}
			if(data.getOproute_8outside29_4am()!=null&&!data.getOproute_8outside29_4am().equals("")){_4am++;}
			if(data.getOproute_8outside30_4am()!=null&&!data.getOproute_8outside30_4am().equals("")){_4am++;}

			if(_8am>=5){count++;}
			if(_12pm>=5){count++;}
			if(_4pm>=5){count++;}
			if(_8pm>=5){count++;}
			if(_12am>=5){count++;}
			if(_4am>=5){count++;}
			al.add(count);
			 count=0; _8am=0;_12pm=0;_4pm=0;_8pm=0;_12am=0;_4am=0;
		}
		return al;
	}
}

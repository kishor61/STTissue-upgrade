/**
 *27-Nov-2019
 *OpRoute_DaoImp.java
 * TODO
 *com.st.frpobcc.dao
 *OpRoute_DaoImp.java
 *Roshan Lal Tailor
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
import com.st.frpobcc.model.OpRoute_1;
/**
 * @author sohan
 *
 */
@Repository
public class OpRoute_1DaoImp implements OpRoute_1Dao {
	
	@Autowired
	@Qualifier("dataSourceOBCC")
	private DataSource dataSourceQRT;
	/* (non-Javadoc)
	 * @see com.st.frpobcc.dao.OpRoute_1Dao#saveorUpdate(com.st.frpobcc.model.OpRoute_1)
	 */
	@Override
	public void saveorUpdate(OpRoute_1 data) {
		NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(dataSourceQRT);
	 	MapSqlParameterSource paramSource=new MapSqlParameterSource();
		
		paramSource.addValue("position",data.getPosition());
		paramSource.addValue("operatorName",data.getOperatorname());
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
		paramSource.addValue("techniciansinitials_freq",data.getTechniciansinitials_freq());
		paramSource.addValue("techniciansinitials_9am",data.getTechniciansinitials_9am());	
		paramSource.addValue("techniciansinitials_1pm",data.getTechniciansinitials_1pm());	
		paramSource.addValue("techniciansinitials_5pm",data.getTechniciansinitials_5pm());	
		paramSource.addValue("techniciansinitials_9pm",data.getTechniciansinitials_9pm());	
		paramSource.addValue("techniciansinitials_1am",data.getTechniciansinitials_1am());	
		paramSource.addValue("techniciansinitials_5am",data.getTechniciansinitials_5am());
		paramSource.addValue("techniciansinitials_freq",data.getTechniciansinitials_freq());
		paramSource.addValue("techniciansinitials_9am",data.getTechniciansinitials_9am());	
		paramSource.addValue("techniciansinitials_1pm",data.getTechniciansinitials_1pm());	
		paramSource.addValue("techniciansinitials_5pm",data.getTechniciansinitials_5pm());	
		paramSource.addValue("techniciansinitials_9pm",data.getTechniciansinitials_9pm());	
		paramSource.addValue("techniciansinitials_1am",data.getTechniciansinitials_1am());	
		paramSource.addValue("techniciansinitials_5am",data.getTechniciansinitials_5am());
		paramSource.addValue("hdcleaner1_freq",data.getHdcleaner1_freq());
		paramSource.addValue("hdcleaner1_9am",data.getHdcleaner1_9am());	
		paramSource.addValue("hdcleaner1_1pm",data.getHdcleaner1_1pm());	
		paramSource.addValue("hdcleaner1_5pm",data.getHdcleaner1_5pm());	
		paramSource.addValue("hdcleaner1_9pm",data.getHdcleaner1_9pm());	
		paramSource.addValue("hdcleaner1_1am",data.getHdcleaner1_1am());	
		paramSource.addValue("hdcleaner1_5am",data.getHdcleaner1_5am());
		paramSource.addValue("hdcleaner2_freq",data.getHdcleaner2_freq());
		paramSource.addValue("hdcleaner2_9am",data.getHdcleaner2_9am());	
		paramSource.addValue("hdcleaner2_1pm",data.getHdcleaner2_1pm());	
		paramSource.addValue("hdcleaner2_5pm",data.getHdcleaner2_5pm());	
		paramSource.addValue("hdcleaner2_9pm",data.getHdcleaner2_9pm());	
		paramSource.addValue("hdcleaner2_1am",data.getHdcleaner2_1am());	
		paramSource.addValue("hdcleaner2_5am",data.getHdcleaner2_5am());
		paramSource.addValue("hdcleaner3_freq",data.getHdcleaner3_freq());
		paramSource.addValue("hdcleaner3_9am",data.getHdcleaner3_9am());	
		paramSource.addValue("hdcleaner3_1pm",data.getHdcleaner3_1pm());	
		paramSource.addValue("hdcleaner3_5pm",data.getHdcleaner3_5pm());	
		paramSource.addValue("hdcleaner3_9pm",data.getHdcleaner3_9pm());	
		paramSource.addValue("hdcleaner3_1am",data.getHdcleaner3_1am());	
		paramSource.addValue("hdcleaner3_5am",data.getHdcleaner3_5am());
		paramSource.addValue("hdcleaner4_freq",data.getHdcleaner4_freq());
		paramSource.addValue("hdcleaner4_9am",data.getHdcleaner4_9am());	
		paramSource.addValue("hdcleaner4_1pm",data.getHdcleaner4_1pm());	
		paramSource.addValue("hdcleaner4_5pm",data.getHdcleaner4_5pm());	
		paramSource.addValue("hdcleaner4_9pm",data.getHdcleaner4_9pm());	
		paramSource.addValue("hdcleaner4_1am",data.getHdcleaner4_1am());	
		paramSource.addValue("hdcleaner4_5am",data.getHdcleaner4_5am());
		paramSource.addValue("hdcleanerb_freq",data.getHdcleanerb_freq());
		paramSource.addValue("hdcleanerb_9am",data.getHdcleanerb_9am());	
		paramSource.addValue("hdcleanerb_1pm",data.getHdcleanerb_1pm());	
		paramSource.addValue("hdcleanerb_5pm",data.getHdcleanerb_5pm());	
		paramSource.addValue("hdcleanerb_9pm",data.getHdcleanerb_9pm());	
		paramSource.addValue("hdcleanerb_1am",data.getHdcleanerb_1am());	
		paramSource.addValue("hdcleanerb_5am",data.getHdcleanerb_5am());		

		paramSource.addValue("drumscreen1_freq",data.getDrumscreen1_freq());
		paramSource.addValue("drumscreen1_9am",data.getDrumscreen1_9am());	
		paramSource.addValue("drumscreen1_1pm",data.getDrumscreen1_1pm());	
		paramSource.addValue("drumscreen1_5pm",data.getDrumscreen1_5pm());	
		paramSource.addValue("drumscreen1_9pm",data.getDrumscreen1_9pm());	
		paramSource.addValue("drumscreen1_1am",data.getDrumscreen1_1am());	
		paramSource.addValue("drumscreen1_5am",data.getDrumscreen1_5am());
		paramSource.addValue("drumscreen2_freq",data.getDrumscreen2_freq());
		paramSource.addValue("drumscreen2_9am",data.getDrumscreen2_9am());	
		paramSource.addValue("drumscreen2_1pm",data.getDrumscreen2_1pm());	
		paramSource.addValue("drumscreen2_5pm",data.getDrumscreen2_5pm());	
		paramSource.addValue("drumscreen2_9pm",data.getDrumscreen2_9pm());	
		paramSource.addValue("drumscreen2_1am",data.getDrumscreen2_1am());	
		paramSource.addValue("drumscreen2_5am",data.getDrumscreen2_5am());	
		paramSource.addValue("drumscreen3_freq",data.getDrumscreen3_freq());
		paramSource.addValue("drumscreen3_9am",data.getDrumscreen3_9am());	
		paramSource.addValue("drumscreen3_1pm",data.getDrumscreen3_1pm());	
		paramSource.addValue("drumscreen3_5pm",data.getDrumscreen3_5pm());	
		paramSource.addValue("drumscreen3_9pm",data.getDrumscreen3_9pm());	
		paramSource.addValue("drumscreen3_1am",data.getDrumscreen3_1am());	
		paramSource.addValue("drumscreen3_5am",data.getDrumscreen3_5am());	

		paramSource.addValue("coarsescreens1_freq",data.getCoarsescreens1_freq());
		paramSource.addValue("coarsescreens1_9am",data.getCoarsescreens1_9am());	
		paramSource.addValue("coarsescreens1_1pm",data.getCoarsescreens1_1pm());	
		paramSource.addValue("coarsescreens1_5pm",data.getCoarsescreens1_5pm());	
		paramSource.addValue("coarsescreens1_9pm",data.getCoarsescreens1_9pm());	
		paramSource.addValue("coarsescreens1_1am",data.getCoarsescreens1_1am());	
		paramSource.addValue("coarsescreens1_5am",data.getCoarsescreens1_5am());
		paramSource.addValue("coarsescreens2_freq",data.getCoarsescreens2_freq());
		paramSource.addValue("coarsescreens2_9am",data.getCoarsescreens2_9am());	
		paramSource.addValue("coarsescreens2_1pm",data.getCoarsescreens2_1pm());	
		paramSource.addValue("coarsescreens2_5pm",data.getCoarsescreens2_5pm());	
		paramSource.addValue("coarsescreens2_9pm",data.getCoarsescreens2_9pm());	
		paramSource.addValue("coarsescreens2_1am",data.getCoarsescreens2_1am());	
		paramSource.addValue("coarsescreens2_5am",data.getCoarsescreens2_5am());
		paramSource.addValue("coarsescreens3_freq",data.getCoarsescreens3_freq());
		paramSource.addValue("coarsescreens3_9am",data.getCoarsescreens3_9am());	
		paramSource.addValue("coarsescreens3_1pm",data.getCoarsescreens3_1pm());	
		paramSource.addValue("coarsescreens3_5pm",data.getCoarsescreens3_5pm());	
		paramSource.addValue("coarsescreens3_9pm",data.getCoarsescreens3_9pm());	
		paramSource.addValue("coarsescreens3_1am",data.getCoarsescreens3_1am());	
		paramSource.addValue("coarsescreens3_5am",data.getCoarsescreens3_5am());
		paramSource.addValue("coarsescreens4_freq",data.getCoarsescreens4_freq());
		paramSource.addValue("coarsescreens4_9am",data.getCoarsescreens4_9am());	
		paramSource.addValue("coarsescreens4_1pm",data.getCoarsescreens4_1pm());	
		paramSource.addValue("coarsescreens4_5pm",data.getCoarsescreens4_5pm());	
		paramSource.addValue("coarsescreens4_9pm",data.getCoarsescreens4_9pm());	
		paramSource.addValue("coarsescreens4_1am",data.getCoarsescreens4_1am());	
		paramSource.addValue("coarsescreens4_5am",data.getCoarsescreens4_5am());
		paramSource.addValue("coarsescreens5_freq",data.getCoarsescreens5_freq());
		paramSource.addValue("coarsescreens5_9am",data.getCoarsescreens5_9am());	
		paramSource.addValue("coarsescreens5_1pm",data.getCoarsescreens5_1pm());	
		paramSource.addValue("coarsescreens5_5pm",data.getCoarsescreens5_5pm());	
		paramSource.addValue("coarsescreens5_9pm",data.getCoarsescreens5_9pm());	
		paramSource.addValue("coarsescreens5_1am",data.getCoarsescreens5_1am());	
		paramSource.addValue("coarsescreens5_5am",data.getCoarsescreens5_5am());
		paramSource.addValue("coarsescreens6_freq",data.getCoarsescreens6_freq());
		paramSource.addValue("coarsescreens6_9am",data.getCoarsescreens6_9am());	
		paramSource.addValue("coarsescreens6_1pm",data.getCoarsescreens6_1pm());	
		paramSource.addValue("coarsescreens6_5pm",data.getCoarsescreens6_5pm());	
		paramSource.addValue("coarsescreens6_9pm",data.getCoarsescreens6_9pm());	
		paramSource.addValue("coarsescreens6_1am",data.getCoarsescreens6_1am());	
		paramSource.addValue("coarsescreens6_5am",data.getCoarsescreens6_5am());
		paramSource.addValue("coarsescreens7_freq",data.getCoarsescreens7_freq());
		paramSource.addValue("coarsescreens7_9am",data.getCoarsescreens7_9am());	
		paramSource.addValue("coarsescreens7_1pm",data.getCoarsescreens7_1pm());	
		paramSource.addValue("coarsescreens7_5pm",data.getCoarsescreens7_5pm());	
		paramSource.addValue("coarsescreens7_9pm",data.getCoarsescreens7_9pm());	
		paramSource.addValue("coarsescreens7_1am",data.getCoarsescreens7_1am());	
		paramSource.addValue("coarsescreens7_5am",data.getCoarsescreens7_5am());	

		paramSource.addValue("finescreens1_freq",data.getFinescreens1_freq());
		paramSource.addValue("finescreens1_9am",data.getFinescreens1_9am());	
		paramSource.addValue("finescreens1_1pm",data.getFinescreens1_1pm());	
		paramSource.addValue("finescreens1_5pm",data.getFinescreens1_5pm());	
		paramSource.addValue("finescreens1_9pm",data.getFinescreens1_9pm());	
		paramSource.addValue("finescreens1_1am",data.getFinescreens1_1am());	
		paramSource.addValue("finescreens1_5am",data.getFinescreens1_5am());	
		paramSource.addValue("finescreens2_freq",data.getFinescreens2_freq());
		paramSource.addValue("finescreens2_9am",data.getFinescreens2_9pm());	
		paramSource.addValue("finescreens2_1pm",data.getFinescreens2_1pm());	
		paramSource.addValue("finescreens2_5pm",data.getFinescreens2_5pm());	
		paramSource.addValue("finescreens2_9pm",data.getFinescreens2_9pm());	
		paramSource.addValue("finescreens2_1am",data.getFinescreens2_1am());	
		paramSource.addValue("finescreens2_5am",data.getFinescreens2_5am());	
		paramSource.addValue("finescreens3_freq",data.getFinescreens3_freq());
		paramSource.addValue("finescreens3_9am",data.getFinescreens3_9am());	
		paramSource.addValue("finescreens3_1pm",data.getFinescreens3_1pm());	
		paramSource.addValue("finescreens3_5pm",data.getFinescreens3_5pm());	
		paramSource.addValue("finescreens3_9pm",data.getFinescreens3_9pm());	
		paramSource.addValue("finescreens3_1am",data.getFinescreens3_1am());	
		paramSource.addValue("finescreens3_5am",data.getFinescreens3_5am());	
		paramSource.addValue("finescreens4_freq",data.getFinescreens4_freq());
		paramSource.addValue("finescreens4_9am",data.getFinescreens4_9am());	
		paramSource.addValue("finescreens4_1pm",data.getFinescreens4_1pm());	
		paramSource.addValue("finescreens4_5pm",data.getFinescreens4_5pm());	
		paramSource.addValue("finescreens4_9pm",data.getFinescreens4_9pm());	
		paramSource.addValue("finescreens4_1am",data.getFinescreens4_1am());	
		paramSource.addValue("finescreens4_5am",data.getFinescreens4_5am());	
		paramSource.addValue("finescreens5_freq",data.getFinescreens5_freq());
		paramSource.addValue("finescreens5_9am",data.getFinescreens5_9am());	
		paramSource.addValue("finescreens5_1pm",data.getFinescreens5_1pm());	
		paramSource.addValue("finescreens5_5pm",data.getFinescreens5_5pm());	
		paramSource.addValue("finescreens5_9pm",data.getFinescreens5_9pm());	
		paramSource.addValue("finescreens5_1am",data.getFinescreens5_1am());	
		paramSource.addValue("finescreens5_5am",data.getFinescreens5_5am());	
		paramSource.addValue("finescreens6_freq",data.getFinescreens6_freq());
		paramSource.addValue("finescreens6_9am",data.getFinescreens6_9am());	
		paramSource.addValue("finescreens6_1pm",data.getFinescreens6_1pm());	
		paramSource.addValue("finescreens6_5pm",data.getFinescreens6_5pm());	
		paramSource.addValue("finescreens6_9pm",data.getFinescreens6_9pm());	
		paramSource.addValue("finescreens6_1am",data.getFinescreens6_1am());	
		paramSource.addValue("finescreens6_5am",data.getFinescreens6_5am());	


		paramSource.addValue("showerpumps1_freq",data.getShowerpumps1_freq());
		paramSource.addValue("showerpumps1_9am",data.getShowerpumps1_9am());	
		paramSource.addValue("showerpumps1_1pm",data.getShowerpumps1_1pm());	
		paramSource.addValue("showerpumps1_5pm",data.getShowerpumps1_5pm());	
		paramSource.addValue("showerpumps1_9pm",data.getShowerpumps1_9pm());	
		paramSource.addValue("showerpumps1_1am",data.getShowerpumps1_1am());	
		paramSource.addValue("showerpumps1_5am",data.getShowerpumps1_5am());	
		paramSource.addValue("showerpumps2_freq",data.getShowerpumps2_freq());
		paramSource.addValue("showerpumps2_9am",data.getShowerpumps2_9am());	
		paramSource.addValue("showerpumps2_1pm",data.getShowerpumps2_1pm());	
		paramSource.addValue("showerpumps2_5pm",data.getShowerpumps2_5pm());	
		paramSource.addValue("showerpumps2_9pm",data.getShowerpumps2_9pm());	
		paramSource.addValue("showerpumps2_1am",data.getShowerpumps2_1am());	
		paramSource.addValue("showerpumps2_5am",data.getShowerpumps2_5am());	


		paramSource.addValue("deckerfeedpump1_freq",data.getDeckerfeedpump1_freq());
		paramSource.addValue("deckerfeedpump1_9am",data.getDeckerfeedpump1_9am());	
		paramSource.addValue("deckerfeedpump1_1pm",data.getDeckerfeedpump1_1pm());	
		paramSource.addValue("deckerfeedpump1_5pm",data.getDeckerfeedpump1_5pm());	
		paramSource.addValue("deckerfeedpump1_9pm",data.getDeckerfeedpump1_9pm());	
		paramSource.addValue("deckerfeedpump1_1am",data.getDeckerfeedpump1_1am());	
		paramSource.addValue("deckerfeedpump1_5am",data.getDeckerfeedpump1_5am());	
		paramSource.addValue("deckerfeedpump2_freq",data.getDeckerfeedpump2_freq());
		paramSource.addValue("deckerfeedpump2_9am",data.getDeckerfeedpump2_9am());	
		paramSource.addValue("deckerfeedpump2_1pm",data.getDeckerfeedpump2_1pm());	
		paramSource.addValue("deckerfeedpump2_5pm",data.getDeckerfeedpump2_5pm());	
		paramSource.addValue("deckerfeedpump2_9pm",data.getDeckerfeedpump2_9pm());	
		paramSource.addValue("deckerfeedpump2_1am",data.getDeckerfeedpump2_1am());	
		paramSource.addValue("deckerfeedpump2_5am",data.getDeckerfeedpump2_5am());	

		paramSource.addValue("daf1_freq",data.getDaf1_freq());
		paramSource.addValue("daf1_9am",data.getDaf1_9am());	
		paramSource.addValue("daf1_1pm",data.getDaf1_1pm());	
		paramSource.addValue("daf1_5pm",data.getDaf1_5pm());	
		paramSource.addValue("daf1_9pm",data.getDaf1_9pm());	
		paramSource.addValue("daf1_1am",data.getDaf1_1am());	
		paramSource.addValue("daf1_5am",data.getDaf1_5am());	
		paramSource.addValue("daf2_freq",data.getDaf2_freq());
		paramSource.addValue("daf2_9am",data.getDaf2_9am());	
		paramSource.addValue("daf2_1pm",data.getDaf2_1pm());	
		paramSource.addValue("daf2_5pm",data.getDaf2_5pm());	
		paramSource.addValue("daf2_9pm",data.getDaf2_9pm());	
		paramSource.addValue("daf2_1am",data.getDaf2_1am());	
		paramSource.addValue("daf2_5am",data.getDaf2_5am());	

		paramSource.addValue("rollupprocessfloorwashuphoses1_freq",data.getRollupprocessfloorwashuphoses1_freq());
		paramSource.addValue("rollupprocessfloorwashuphoses1_9am",data.getRollupprocessfloorwashuphoses1_9am());	
		paramSource.addValue("rollupprocessfloorwashuphoses1_1pm",data.getRollupprocessfloorwashuphoses1_1pm());	
		paramSource.addValue("rollupprocessfloorwashuphoses1_5pm",data.getRollupprocessfloorwashuphoses1_5pm());	
		paramSource.addValue("rollupprocessfloorwashuphoses1_9pm",data.getRollupprocessfloorwashuphoses1_9pm());	
		paramSource.addValue("rollupprocessfloorwashuphoses1_1am",data.getRollupprocessfloorwashuphoses1_1am());	
		paramSource.addValue("rollupprocessfloorwashuphoses1_5am",data.getRollupprocessfloorwashuphoses1_5am());								
		
		if (data.getId() == 0) {	
			String sql=DatabaseUtil.getSQL("sql/insertOpRoute_1.sql");
			jdbcTemplate.update(sql, paramSource);
		}
		else
		{
			paramSource.addValue("id",data.getId());
			String sql=DatabaseUtil.getSQL("sql/updateOpRoute_1.sql");
			jdbcTemplate.update(sql, paramSource);
		}
		
	}
	/* (non-Javadoc)
	 * @see com.st.frpobcc.dao.OpRoute_1Dao#getData(java.lang.String)
	 */
	@Override
	public List<OpRoute_1> getData(String sdate,String edate) {		
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSourceQRT);
		String sql = "select * from [OpRoute_1] where date BETWEEN ? AND ?";
		List<OpRoute_1> oproute_1=null;
		try {
			oproute_1 = jdbcTemplate.query(sql, new Object[] {sdate,edate}, new RowMapper<OpRoute_1>() {
						
						@Override
						public OpRoute_1 mapRow(ResultSet rs, int arg1) throws SQLException {
							OpRoute_1 data=new OpRoute_1();
							data.setId(rs.getInt("id"));
							data.setPosition(rs.getString("position"));
							data.setCrew(rs.getString("crew"));
							data.setDate(rs.getString("date"));
							data.setMachinedown(rs.getBoolean("machinedown"));
							data.setComments(rs.getString("comments"));
							data.setTechniciansinitials_freq(rs.getString("techniciansinitials_freq"));
							data.setTechniciansinitials_9am(rs.getString("techniciansinitials_9am"));
							data.setTechniciansinitials_1pm(rs.getString("techniciansinitials_1pm"));
							data.setTechniciansinitials_5pm(rs.getString("techniciansinitials_5pm"));
							data.setTechniciansinitials_9pm(rs.getString("techniciansinitials_9pm"));
							data.setTechniciansinitials_1am(rs.getString("techniciansinitials_1am"));
							data.setTechniciansinitials_5am(rs.getString("techniciansinitials_5am"));
							data.setHdcleaner1_freq(rs.getString("hdcleaner1_freq"));
							data.setHdcleaner1_9am(rs.getString("hdcleaner1_9am"));
							data.setHdcleaner1_1pm(rs.getString("hdcleaner1_1pm"));
							data.setHdcleaner1_5pm(rs.getString("hdcleaner1_5pm"));
							data.setHdcleaner1_9pm(rs.getString("hdcleaner1_9pm"));
							data.setHdcleaner1_1am(rs.getString("hdcleaner1_1am"));
							data.setHdcleaner1_5am(rs.getString("hdcleaner1_5am"));
							data.setHdcleaner2_freq(rs.getString("hdcleaner2_freq"));
							data.setHdcleaner2_9am(rs.getString("hdcleaner2_9am"));
							data.setHdcleaner2_1pm(rs.getString("hdcleaner2_1pm"));
							data.setHdcleaner2_5pm(rs.getString("hdcleaner2_5pm"));
							data.setHdcleaner2_9pm(rs.getString("hdcleaner2_9pm"));
							data.setHdcleaner2_1am(rs.getString("hdcleaner2_1am"));
							data.setHdcleaner2_5am(rs.getString("hdcleaner2_5am"));
							data.setHdcleaner3_freq(rs.getString("hdcleaner3_freq"));
							data.setHdcleaner3_9am(rs.getString("hdcleaner3_9am"));
							data.setHdcleaner3_1pm(rs.getString("hdcleaner3_1pm"));
							data.setHdcleaner3_5pm(rs.getString("hdcleaner3_5pm"));
							data.setHdcleaner3_9pm(rs.getString("hdcleaner3_9pm"));
							data.setHdcleaner3_1am(rs.getString("hdcleaner3_1am"));
							data.setHdcleaner3_5am(rs.getString("hdcleaner3_5am"));
							data.setHdcleaner4_freq(rs.getString("hdcleaner4_freq"));
							data.setHdcleaner4_9am(rs.getString("hdcleaner4_9am"));
							data.setHdcleaner4_1pm(rs.getString("hdcleaner4_1pm"));
							data.setHdcleaner4_5pm(rs.getString("hdcleaner4_5pm"));
							data.setHdcleaner4_9pm(rs.getString("hdcleaner4_9pm"));
							data.setHdcleaner4_1am(rs.getString("hdcleaner4_1am"));
							data.setHdcleaner4_5am(rs.getString("hdcleaner4_5am"));
							data.setHdcleanerb_freq(rs.getString("hdcleanerb_freq"));
							data.setHdcleanerb_9am(rs.getString("hdcleanerb_9am"));
							data.setHdcleanerb_1pm(rs.getString("hdcleanerb_1pm"));
							data.setHdcleanerb_5pm(rs.getString("hdcleanerb_5pm"));
							data.setHdcleanerb_9pm(rs.getString("hdcleanerb_9pm"));
							data.setHdcleanerb_1am(rs.getString("hdcleanerb_1am"));
							data.setHdcleanerb_5am(rs.getString("hdcleanerb_5am"));
							data.setDrumscreen1_freq(rs.getString("drumscreen1_freq"));
							data.setDrumscreen1_9am(rs.getString("drumscreen1_9am"));
							data.setDrumscreen1_1pm(rs.getString("drumscreen1_1pm"));
							data.setDrumscreen1_5pm(rs.getString("drumscreen1_5pm"));
							data.setDrumscreen1_9pm(rs.getString("drumscreen1_9pm"));
							data.setDrumscreen1_1am(rs.getString("drumscreen1_1am"));
							data.setDrumscreen1_5am(rs.getString("drumscreen1_5am"));
							data.setDrumscreen2_freq(rs.getString("drumscreen2_freq"));
							data.setDrumscreen2_9am(rs.getString("drumscreen2_9am"));
							data.setDrumscreen2_1pm(rs.getString("drumscreen2_1pm"));
							data.setDrumscreen2_5pm(rs.getString("drumscreen2_5pm"));
							data.setDrumscreen2_9pm(rs.getString("drumscreen2_9pm"));
							data.setDrumscreen2_1am(rs.getString("drumscreen2_1am"));
							data.setDrumscreen2_5am(rs.getString("drumscreen2_5am"));
							data.setDrumscreen3_freq(rs.getString("drumscreen3_freq"));
							data.setDrumscreen3_9am(rs.getString("drumscreen3_9am"));
							data.setDrumscreen3_1pm(rs.getString("drumscreen3_1pm"));
							data.setDrumscreen3_5pm(rs.getString("drumscreen3_5pm"));
							data.setDrumscreen3_9pm(rs.getString("drumscreen3_9pm"));
							data.setDrumscreen3_1am(rs.getString("drumscreen3_1am"));
							data.setDrumscreen3_5am(rs.getString("drumscreen3_5am"));
							data.setCoarsescreens1_freq(rs.getString("coarsescreens1_freq"));
							data.setCoarsescreens1_9am(rs.getString("coarsescreens1_9am"));
							data.setCoarsescreens1_1pm(rs.getString("coarsescreens1_1pm"));
							data.setCoarsescreens1_5pm(rs.getString("coarsescreens1_5pm"));
							data.setCoarsescreens1_9pm(rs.getString("coarsescreens1_9pm"));
							data.setCoarsescreens1_1am(rs.getString("coarsescreens1_1am"));
							data.setCoarsescreens1_5am(rs.getString("coarsescreens1_5am"));
							data.setCoarsescreens2_freq(rs.getString("coarsescreens2_freq"));
							data.setCoarsescreens2_9am(rs.getString("coarsescreens2_9am"));
							data.setCoarsescreens2_1pm(rs.getString("coarsescreens2_1pm"));
							data.setCoarsescreens2_5pm(rs.getString("coarsescreens2_5pm"));
							data.setCoarsescreens2_9pm(rs.getString("coarsescreens2_9pm"));
							data.setCoarsescreens2_1am(rs.getString("coarsescreens2_1am"));
							data.setCoarsescreens2_5am(rs.getString("coarsescreens2_5am"));
							data.setCoarsescreens3_freq(rs.getString("coarsescreens3_freq"));
							data.setCoarsescreens3_9am(rs.getString("coarsescreens3_9am"));
							data.setCoarsescreens3_1pm(rs.getString("coarsescreens3_1pm"));
							data.setCoarsescreens3_5pm(rs.getString("coarsescreens3_5pm"));
							data.setCoarsescreens3_9pm(rs.getString("coarsescreens3_9pm"));
							data.setCoarsescreens3_1am(rs.getString("coarsescreens3_1am"));
							data.setCoarsescreens3_5am(rs.getString("coarsescreens3_5am"));
							data.setCoarsescreens4_freq(rs.getString("coarsescreens4_freq"));
							data.setCoarsescreens4_9am(rs.getString("coarsescreens4_9am"));
							data.setCoarsescreens4_1pm(rs.getString("coarsescreens4_1pm"));
							data.setCoarsescreens4_5pm(rs.getString("coarsescreens4_5pm"));
							data.setCoarsescreens4_9pm(rs.getString("coarsescreens4_9pm"));
							data.setCoarsescreens4_1am(rs.getString("coarsescreens4_1am"));
							data.setCoarsescreens4_5am(rs.getString("coarsescreens4_5am"));
							data.setCoarsescreens5_freq(rs.getString("coarsescreens5_freq"));
							data.setCoarsescreens5_9am(rs.getString("coarsescreens5_9am"));
							data.setCoarsescreens5_1pm(rs.getString("coarsescreens5_1pm"));
							data.setCoarsescreens5_5pm(rs.getString("coarsescreens5_5pm"));
							data.setCoarsescreens5_9pm(rs.getString("coarsescreens5_9pm"));
							data.setCoarsescreens5_1am(rs.getString("coarsescreens5_1am"));
							data.setCoarsescreens5_5am(rs.getString("coarsescreens5_5am"));
							data.setCoarsescreens6_freq(rs.getString("coarsescreens6_freq"));
							data.setCoarsescreens6_9am(rs.getString("coarsescreens6_9am"));
							data.setCoarsescreens6_1pm(rs.getString("coarsescreens6_1pm"));
							data.setCoarsescreens6_5pm(rs.getString("coarsescreens6_5pm"));
							data.setCoarsescreens6_9pm(rs.getString("coarsescreens6_9pm"));
							data.setCoarsescreens6_1am(rs.getString("coarsescreens6_1am"));
							data.setCoarsescreens6_5am(rs.getString("coarsescreens6_5am"));
							data.setCoarsescreens7_freq(rs.getString("coarsescreens7_freq"));
							data.setCoarsescreens7_9am(rs.getString("coarsescreens7_9am"));
							data.setCoarsescreens7_1pm(rs.getString("coarsescreens7_1pm"));
							data.setCoarsescreens7_5pm(rs.getString("coarsescreens7_5pm"));
							data.setCoarsescreens7_9pm(rs.getString("coarsescreens7_9pm"));
							data.setCoarsescreens7_1am(rs.getString("coarsescreens7_1am"));
							data.setCoarsescreens7_5am(rs.getString("coarsescreens7_5am"));
							data.setFinescreens1_freq(rs.getString("finescreens1_freq"));
							data.setFinescreens1_9am(rs.getString("finescreens1_9am"));
							data.setFinescreens1_1pm(rs.getString("finescreens1_1pm"));
							data.setFinescreens1_5pm(rs.getString("finescreens1_5pm"));
							data.setFinescreens1_9pm(rs.getString("finescreens1_9pm"));
							data.setFinescreens1_1am(rs.getString("finescreens1_1am"));
							data.setFinescreens1_5am(rs.getString("finescreens1_5am"));
							data.setFinescreens2_freq(rs.getString("finescreens2_freq"));
							data.setFinescreens2_9am(rs.getString("finescreens2_9am"));
							data.setFinescreens2_1pm(rs.getString("finescreens2_1pm"));
							data.setFinescreens2_5pm(rs.getString("finescreens2_5pm"));
							data.setFinescreens2_9pm(rs.getString("finescreens2_9pm"));
							data.setFinescreens2_1am(rs.getString("finescreens2_1am"));
							data.setFinescreens2_5am(rs.getString("finescreens2_5am"));
							data.setFinescreens3_freq(rs.getString("finescreens3_freq"));
							data.setFinescreens3_9am(rs.getString("finescreens3_9am"));
							data.setFinescreens3_1pm(rs.getString("finescreens3_1pm"));
							data.setFinescreens3_5pm(rs.getString("finescreens3_5pm"));
							data.setFinescreens3_9pm(rs.getString("finescreens3_9pm"));
							data.setFinescreens3_1am(rs.getString("finescreens3_1am"));
							data.setFinescreens3_5am(rs.getString("finescreens3_5am"));
							data.setFinescreens4_freq(rs.getString("finescreens4_freq"));
							data.setFinescreens4_9am(rs.getString("finescreens4_9am"));
							data.setFinescreens4_1pm(rs.getString("finescreens4_1pm"));
							data.setFinescreens4_5pm(rs.getString("finescreens4_5pm"));
							data.setFinescreens4_9pm(rs.getString("finescreens4_9pm"));
							data.setFinescreens4_1am(rs.getString("finescreens4_1am"));
							data.setFinescreens4_5am(rs.getString("finescreens4_5am"));
							data.setFinescreens5_freq(rs.getString("finescreens5_freq"));
							data.setFinescreens5_9am(rs.getString("finescreens5_9am"));
							data.setFinescreens5_1pm(rs.getString("finescreens5_1pm"));
							data.setFinescreens5_5pm(rs.getString("finescreens5_5pm"));
							data.setFinescreens5_9pm(rs.getString("finescreens5_9pm"));
							data.setFinescreens5_1am(rs.getString("finescreens5_1am"));
							data.setFinescreens5_5am(rs.getString("finescreens5_5am"));
							data.setFinescreens6_freq(rs.getString("finescreens6_freq"));
							data.setFinescreens6_9am(rs.getString("finescreens6_9am"));
							data.setFinescreens6_1pm(rs.getString("finescreens6_1pm"));
							data.setFinescreens6_5pm(rs.getString("finescreens6_5pm"));
							data.setFinescreens6_9pm(rs.getString("finescreens6_9pm"));
							data.setFinescreens6_1am(rs.getString("finescreens6_1am"));
							data.setFinescreens6_5am(rs.getString("finescreens6_5am"));
							data.setShowerpumps1_freq(rs.getString("showerpumps1_freq"));
							data.setShowerpumps1_9am(rs.getString("showerpumps1_9am"));
							data.setShowerpumps1_1pm(rs.getString("showerpumps1_1pm"));
							data.setShowerpumps1_5pm(rs.getString("showerpumps1_5pm"));
							data.setShowerpumps1_9pm(rs.getString("showerpumps1_9pm"));
							data.setShowerpumps1_1am(rs.getString("showerpumps1_1am"));
							data.setShowerpumps1_5am(rs.getString("showerpumps1_5am"));
							data.setShowerpumps2_freq(rs.getString("showerpumps2_freq"));
							data.setShowerpumps2_9am(rs.getString("showerpumps2_9am"));
							data.setShowerpumps2_1pm(rs.getString("showerpumps2_1pm"));
							data.setShowerpumps2_5pm(rs.getString("showerpumps2_5pm"));
							data.setShowerpumps2_9pm(rs.getString("showerpumps2_9pm"));
							data.setShowerpumps2_1am(rs.getString("showerpumps2_1am"));
							data.setShowerpumps2_5am(rs.getString("showerpumps2_5am"));
							data.setDeckerfeedpump1_freq(rs.getString("deckerfeedpump1_freq"));
							data.setDeckerfeedpump1_9am(rs.getString("deckerfeedpump1_9am"));
							data.setDeckerfeedpump1_1pm(rs.getString("deckerfeedpump1_1pm"));
							data.setDeckerfeedpump1_5pm(rs.getString("deckerfeedpump1_5pm"));
							data.setDeckerfeedpump1_9pm(rs.getString("deckerfeedpump1_9pm"));
							data.setDeckerfeedpump1_1am(rs.getString("deckerfeedpump1_1am"));
							data.setDeckerfeedpump1_5am(rs.getString("deckerfeedpump1_5am"));
							data.setDeckerfeedpump2_freq(rs.getString("deckerfeedpump2_freq"));
							data.setDeckerfeedpump2_9am(rs.getString("deckerfeedpump2_9am"));
							data.setDeckerfeedpump2_1pm(rs.getString("deckerfeedpump2_1pm"));
							data.setDeckerfeedpump2_5pm(rs.getString("deckerfeedpump2_5pm"));
							data.setDeckerfeedpump2_9pm(rs.getString("deckerfeedpump2_9pm"));
							data.setDeckerfeedpump2_1am(rs.getString("deckerfeedpump2_1am"));
							data.setDeckerfeedpump2_5am(rs.getString("deckerfeedpump2_5am"));
							data.setDaf1_freq(rs.getString("daf1_freq"));
							data.setDaf1_9am(rs.getString("daf1_9am"));
							data.setDaf1_1pm(rs.getString("daf1_1pm"));
							data.setDaf1_5pm(rs.getString("daf1_5pm"));
							data.setDaf1_9pm(rs.getString("daf1_9pm"));
							data.setDaf1_1am(rs.getString("daf1_1am"));
							data.setDaf1_5am(rs.getString("daf1_5am"));
							data.setDaf2_freq(rs.getString("daf2_freq"));
							data.setDaf2_9am(rs.getString("daf2_9am"));
							data.setDaf2_1pm(rs.getString("daf2_1pm"));
							data.setDaf2_5pm(rs.getString("daf2_5pm"));
							data.setDaf2_9pm(rs.getString("daf2_9pm"));
							data.setDaf2_1am(rs.getString("daf2_1am"));
							data.setDaf2_5am(rs.getString("daf2_5am"));
							data.setRollupprocessfloorwashuphoses1_freq(rs.getString("rollupprocessfloorwashuphoses1_freq"));
							data.setRollupprocessfloorwashuphoses1_9am(rs.getString("rollupprocessfloorwashuphoses1_9am"));
							data.setRollupprocessfloorwashuphoses1_1pm(rs.getString("rollupprocessfloorwashuphoses1_1pm"));
							data.setRollupprocessfloorwashuphoses1_5pm(rs.getString("rollupprocessfloorwashuphoses1_5pm"));
							data.setRollupprocessfloorwashuphoses1_9pm(rs.getString("rollupprocessfloorwashuphoses1_9pm"));
							data.setRollupprocessfloorwashuphoses1_1am(rs.getString("rollupprocessfloorwashuphoses1_1am"));
							data.setRollupprocessfloorwashuphoses1_5am(rs.getString("rollupprocessfloorwashuphoses1_5am"));
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
		return oproute_1;
	}

	
	@Override
	public long getCountDatePercentage(String sdate,String edate) throws Exception {
		
		int _9am=0,_1pm=0,_5pm=0,_9pm=0,_1am=0,_5am=0;
		int _9ampercent=0, _1pmpercent=0,_5pmpercent=0,_9pmpercent=0,_1ampercent=0,_5ampercent=0;
	 	long percent=0;
		List<OpRoute_1> lst= getData(sdate,edate);
		for(OpRoute_1 data:lst)
		{
			if(data.getHdcleaner1_9am()!=null&&!data.getHdcleaner1_9am().equals("")){_9am++;}
			if(data.getHdcleaner2_9am()!=null&&!data.getHdcleaner2_9am().equals("")){_9am++;}
			if(data.getHdcleaner3_9am()!=null&&!data.getHdcleaner3_9am().equals("")){_9am++;}
			if(data.getHdcleaner4_9am()!=null&&!data.getHdcleaner4_9am().equals("")){_9am++;}
			if(data.getHdcleanerb_9am()!=null&&!data.getHdcleanerb_9am().equals("")){_9am++;}
			if(data.getDrumscreen1_9am()!=null&&!data.getDrumscreen1_9am().equals("")){_9am++;}
			if(data.getDrumscreen2_9am()!=null&&!data.getDrumscreen2_9am().equals("")){_9am++;}
			if(data.getDrumscreen3_9am()!=null&&!data.getDrumscreen3_9am().equals("")){_9am++;}
			if(data.getCoarsescreens1_9am()!=null&&!data.getCoarsescreens1_9am().equals("")){_9am++;}
			if(data.getCoarsescreens2_9am()!=null&&!data.getCoarsescreens2_9am().equals("")){_9am++;}
			if(data.getCoarsescreens3_9am()!=null&&!data.getCoarsescreens3_9am().equals("")){_9am++;}
			if(data.getCoarsescreens4_9am()!=null&&!data.getCoarsescreens4_9am().equals("")){_9am++;}
			if(data.getCoarsescreens5_9am()!=null&&!data.getCoarsescreens5_9am().equals("")){_9am++;}
			if(data.getCoarsescreens6_9am()!=null&&!data.getCoarsescreens6_9am().equals("")){_9am++;}
			if(data.getCoarsescreens7_9am()!=null&&!data.getCoarsescreens7_9am().equals("")){_9am++;}
			if(data.getFinescreens1_9am()!=null&&!data.getFinescreens1_9am().equals("")){_9am++;}
			if(data.getFinescreens2_9am()!=null&&!data.getFinescreens2_9am().equals("")){_9am++;}
			if(data.getFinescreens3_9am()!=null&&!data.getFinescreens3_9am().equals("")){_9am++;}
			if(data.getFinescreens4_9am()!=null&&!data.getFinescreens4_9am().equals("")){_9am++;}
			if(data.getFinescreens5_9am()!=null&&!data.getFinescreens5_9am().equals("")){_9am++;}
			if(data.getFinescreens6_9am()!=null&&!data.getFinescreens6_9am().equals("")){_9am++;}
			if(data.getShowerpumps1_9am()!=null&&!data.getShowerpumps1_9am().equals("")){_9am++;}
			if(data.getShowerpumps2_9am()!=null&&!data.getShowerpumps2_9am().equals("")){_9am++;}
			if(data.getDeckerfeedpump1_9am()!=null&&!data.getDeckerfeedpump1_9am().equals("")){_9am++;}
			if(data.getDeckerfeedpump2_9am()!=null&&!data.getDeckerfeedpump2_9am().equals("")){_9am++;}
			if(data.getDaf1_9am()!=null&&!data.getDaf1_9am().equals("")){_9am++;}
			if(data.getDaf2_9am()!=null&&!data.getDaf2_9am().equals("")){_9am++;}
			if(data.getRollupprocessfloorwashuphoses1_9am()!=null&&!data.getRollupprocessfloorwashuphoses1_9am().equals("")){_9am++;}
			
			if(data.getHdcleaner1_1pm()!=null&&!data.getHdcleaner1_1pm().equals("")){_1pm++;}
			if(data.getHdcleaner2_1pm()!=null&&!data.getHdcleaner2_1pm().equals("")){_1pm++;}
			if(data.getHdcleaner3_1pm()!=null&&!data.getHdcleaner3_1pm().equals("")){_1pm++;}
			if(data.getHdcleaner4_1pm()!=null&&!data.getHdcleaner4_1pm().equals("")){_1pm++;}
			if(data.getHdcleanerb_1pm()!=null&&!data.getHdcleanerb_1pm().equals("")){_1pm++;}
			if(data.getDrumscreen1_1pm()!=null&&!data.getDrumscreen1_1pm().equals("")){_1pm++;}
			if(data.getDrumscreen2_1pm()!=null&&!data.getDrumscreen2_1pm().equals("")){_1pm++;}
			if(data.getDrumscreen3_1pm()!=null&&!data.getDrumscreen3_1pm().equals("")){_1pm++;}
			if(data.getCoarsescreens1_1pm()!=null&&!data.getCoarsescreens1_1pm().equals("")){_1pm++;}
			if(data.getCoarsescreens2_1pm()!=null&&!data.getCoarsescreens2_1pm().equals("")){_1pm++;}
			if(data.getCoarsescreens3_1pm()!=null&&!data.getCoarsescreens3_1pm().equals("")){_1pm++;}
			if(data.getCoarsescreens4_1pm()!=null&&!data.getCoarsescreens4_1pm().equals("")){_1pm++;}
			if(data.getCoarsescreens5_1pm()!=null&&!data.getCoarsescreens5_1pm().equals("")){_1pm++;}
			if(data.getCoarsescreens6_1pm()!=null&&!data.getCoarsescreens6_1pm().equals("")){_1pm++;}
			if(data.getCoarsescreens7_1pm()!=null&&!data.getCoarsescreens7_1pm().equals("")){_1pm++;}
			if(data.getFinescreens1_1pm()!=null&&!data.getFinescreens1_1pm().equals("")){_1pm++;}
			if(data.getFinescreens2_1pm()!=null&&!data.getFinescreens2_1pm().equals("")){_1pm++;}
			if(data.getFinescreens3_1pm()!=null&&!data.getFinescreens3_1pm().equals("")){_1pm++;}
			if(data.getFinescreens4_1pm()!=null&&!data.getFinescreens4_1pm().equals("")){_1pm++;}
			if(data.getFinescreens5_1pm()!=null&&!data.getFinescreens5_1pm().equals("")){_1pm++;}
			if(data.getFinescreens6_1pm()!=null&&!data.getFinescreens6_1pm().equals("")){_1pm++;}
			if(data.getShowerpumps1_1pm()!=null&&!data.getShowerpumps1_1pm().equals("")){_1pm++;}
			if(data.getShowerpumps2_1pm()!=null&&!data.getShowerpumps2_1pm().equals("")){_1pm++;}
			if(data.getDeckerfeedpump1_1pm()!=null&&!data.getDeckerfeedpump1_1pm().equals("")){_1pm++;}
			if(data.getDeckerfeedpump2_1pm()!=null&&!data.getDeckerfeedpump2_1pm().equals("")){_1pm++;}
			if(data.getDaf1_1pm()!=null&&!data.getDaf1_1pm().equals("")){_1pm++;}
			if(data.getDaf2_1pm()!=null&&!data.getDaf2_1pm().equals("")){_1pm++;}
			if(data.getRollupprocessfloorwashuphoses1_1pm()!=null&&!data.getRollupprocessfloorwashuphoses1_1pm().equals("")){_1pm++;}

			if(data.getHdcleaner1_5pm()!=null&&!data.getHdcleaner1_5pm().equals("")){_5pm++;}
			if(data.getHdcleaner2_5pm()!=null&&!data.getHdcleaner2_5pm().equals("")){_5pm++;}
			if(data.getHdcleaner3_5pm()!=null&&!data.getHdcleaner3_5pm().equals("")){_5pm++;}
			if(data.getHdcleaner4_5pm()!=null&&!data.getHdcleaner4_5pm().equals("")){_5pm++;}
			if(data.getHdcleanerb_5pm()!=null&&!data.getHdcleanerb_5pm().equals("")){_5pm++;}
			if(data.getDrumscreen1_5pm()!=null&&!data.getDrumscreen1_5pm().equals("")){_5pm++;}
			if(data.getDrumscreen2_5pm()!=null&&!data.getDrumscreen2_5pm().equals("")){_5pm++;}
			if(data.getDrumscreen3_5pm()!=null&&!data.getDrumscreen3_5pm().equals("")){_5pm++;}
			if(data.getCoarsescreens1_5pm()!=null&&!data.getCoarsescreens1_5pm().equals("")){_5pm++;}
			if(data.getCoarsescreens2_5pm()!=null&&!data.getCoarsescreens2_5pm().equals("")){_5pm++;}
			if(data.getCoarsescreens3_5pm()!=null&&!data.getCoarsescreens3_5pm().equals("")){_5pm++;}
			if(data.getCoarsescreens4_5pm()!=null&&!data.getCoarsescreens4_5pm().equals("")){_5pm++;}
			if(data.getCoarsescreens5_5pm()!=null&&!data.getCoarsescreens5_5pm().equals("")){_5pm++;}
			if(data.getCoarsescreens6_5pm()!=null&&!data.getCoarsescreens6_5pm().equals("")){_5pm++;}
			if(data.getCoarsescreens7_5pm()!=null&&!data.getCoarsescreens7_5pm().equals("")){_5pm++;}
			if(data.getFinescreens1_5pm()!=null&&!data.getFinescreens1_5pm().equals("")){_5pm++;}
			if(data.getFinescreens2_5pm()!=null&&!data.getFinescreens2_5pm().equals("")){_5pm++;}
			if(data.getFinescreens3_5pm()!=null&&!data.getFinescreens3_5pm().equals("")){_5pm++;}
			if(data.getFinescreens4_5pm()!=null&&!data.getFinescreens4_5pm().equals("")){_5pm++;}
			if(data.getFinescreens5_5pm()!=null&&!data.getFinescreens5_5pm().equals("")){_5pm++;}
			if(data.getFinescreens6_5pm()!=null&&!data.getFinescreens6_5pm().equals("")){_5pm++;}
			if(data.getShowerpumps1_5pm()!=null&&!data.getShowerpumps1_5pm().equals("")){_5pm++;}
			if(data.getShowerpumps2_5pm()!=null&&!data.getShowerpumps2_5pm().equals("")){_5pm++;}
			if(data.getDeckerfeedpump1_5pm()!=null&&!data.getDeckerfeedpump1_5pm().equals("")){_5pm++;}
			if(data.getDeckerfeedpump2_5pm()!=null&&!data.getDeckerfeedpump2_5pm().equals("")){_5pm++;}
			if(data.getDaf1_5pm()!=null&&!data.getDaf1_5pm().equals("")){_5pm++;}
			if(data.getDaf2_5pm()!=null&&!data.getDaf2_5pm().equals("")){_5pm++;}
			if(data.getRollupprocessfloorwashuphoses1_5pm()!=null&&!data.getRollupprocessfloorwashuphoses1_5pm().equals("")){_5pm++;}

			if(data.getHdcleaner1_9pm()!=null&&!data.getHdcleaner1_9pm().equals("")){_9pm++;}
			if(data.getHdcleaner2_9pm()!=null&&!data.getHdcleaner2_9pm().equals("")){_9pm++;}
			if(data.getHdcleaner3_9pm()!=null&&!data.getHdcleaner3_9pm().equals("")){_9pm++;}
			if(data.getHdcleaner4_9pm()!=null&&!data.getHdcleaner4_9pm().equals("")){_9pm++;}
			if(data.getHdcleanerb_9pm()!=null&&!data.getHdcleanerb_9pm().equals("")){_9pm++;}
			if(data.getDrumscreen1_9pm()!=null&&!data.getDrumscreen1_9pm().equals("")){_9pm++;}
			if(data.getDrumscreen2_9pm()!=null&&!data.getDrumscreen2_9pm().equals("")){_9pm++;}
			if(data.getDrumscreen3_9pm()!=null&&!data.getDrumscreen3_9pm().equals("")){_9pm++;}
			if(data.getCoarsescreens1_9pm()!=null&&!data.getCoarsescreens1_9pm().equals("")){_9pm++;}
			if(data.getCoarsescreens2_9pm()!=null&&!data.getCoarsescreens2_9pm().equals("")){_9pm++;}
			if(data.getCoarsescreens3_9pm()!=null&&!data.getCoarsescreens3_9pm().equals("")){_9pm++;}
			if(data.getCoarsescreens4_9pm()!=null&&!data.getCoarsescreens4_9pm().equals("")){_9pm++;}
			if(data.getCoarsescreens5_9pm()!=null&&!data.getCoarsescreens5_9pm().equals("")){_9pm++;}
			if(data.getCoarsescreens6_9pm()!=null&&!data.getCoarsescreens6_9pm().equals("")){_9pm++;}
			if(data.getCoarsescreens7_9pm()!=null&&!data.getCoarsescreens7_9pm().equals("")){_9pm++;}
			if(data.getFinescreens1_9pm()!=null&&!data.getFinescreens1_9pm().equals("")){_9pm++;}
			if(data.getFinescreens2_9pm()!=null&&!data.getFinescreens2_9pm().equals("")){_9pm++;}
			if(data.getFinescreens3_9pm()!=null&&!data.getFinescreens3_9pm().equals("")){_9pm++;}
			if(data.getFinescreens4_9pm()!=null&&!data.getFinescreens4_9pm().equals("")){_9pm++;}
			if(data.getFinescreens5_9pm()!=null&&!data.getFinescreens5_9pm().equals("")){_9pm++;}
			if(data.getFinescreens6_9pm()!=null&&!data.getFinescreens6_9pm().equals("")){_9pm++;}
			if(data.getShowerpumps1_9pm()!=null&&!data.getShowerpumps1_9pm().equals("")){_9pm++;}
			if(data.getShowerpumps2_9pm()!=null&&!data.getShowerpumps2_9pm().equals("")){_9pm++;}
			if(data.getDeckerfeedpump1_9pm()!=null&&!data.getDeckerfeedpump1_9pm().equals("")){_9pm++;}
			if(data.getDeckerfeedpump2_9pm()!=null&&!data.getDeckerfeedpump2_9pm().equals("")){_9pm++;}
			if(data.getDaf1_9pm()!=null&&!data.getDaf1_9pm().equals("")){_9pm++;}
			if(data.getDaf2_9pm()!=null&&!data.getDaf2_9pm().equals("")){_9pm++;}
			if(data.getRollupprocessfloorwashuphoses1_9pm()!=null&&!data.getRollupprocessfloorwashuphoses1_9pm().equals("")){_9pm++;}

			if(data.getHdcleaner1_1am()!=null&&!data.getHdcleaner1_1am().equals("")){_1am++;}
			if(data.getHdcleaner2_1am()!=null&&!data.getHdcleaner2_1am().equals("")){_1am++;}
			if(data.getHdcleaner3_1am()!=null&&!data.getHdcleaner3_1am().equals("")){_1am++;}
			if(data.getHdcleaner4_1am()!=null&&!data.getHdcleaner4_1am().equals("")){_1am++;}
			if(data.getHdcleanerb_1am()!=null&&!data.getHdcleanerb_1am().equals("")){_1am++;}
			if(data.getDrumscreen1_1am()!=null&&!data.getDrumscreen1_1am().equals("")){_1am++;}
			if(data.getDrumscreen2_1am()!=null&&!data.getDrumscreen2_1am().equals("")){_1am++;}
			if(data.getDrumscreen3_1am()!=null&&!data.getDrumscreen3_1am().equals("")){_1am++;}
			if(data.getCoarsescreens1_1am()!=null&&!data.getCoarsescreens1_1am().equals("")){_1am++;}
			if(data.getCoarsescreens2_1am()!=null&&!data.getCoarsescreens2_1am().equals("")){_1am++;}
			if(data.getCoarsescreens3_1am()!=null&&!data.getCoarsescreens3_1am().equals("")){_1am++;}
			if(data.getCoarsescreens4_1am()!=null&&!data.getCoarsescreens4_1am().equals("")){_1am++;}
			if(data.getCoarsescreens5_1am()!=null&&!data.getCoarsescreens5_1am().equals("")){_1am++;}
			if(data.getCoarsescreens6_1am()!=null&&!data.getCoarsescreens6_1am().equals("")){_1am++;}
			if(data.getCoarsescreens7_1am()!=null&&!data.getCoarsescreens7_1am().equals("")){_1am++;}
			if(data.getFinescreens1_1am()!=null&&!data.getFinescreens1_1am().equals("")){_1am++;}
			if(data.getFinescreens2_1am()!=null&&!data.getFinescreens2_1am().equals("")){_1am++;}
			if(data.getFinescreens3_1am()!=null&&!data.getFinescreens3_1am().equals("")){_1am++;}
			if(data.getFinescreens4_1am()!=null&&!data.getFinescreens4_1am().equals("")){_1am++;}
			if(data.getFinescreens5_1am()!=null&&!data.getFinescreens5_1am().equals("")){_1am++;}
			if(data.getFinescreens6_1am()!=null&&!data.getFinescreens6_1am().equals("")){_1am++;}
			if(data.getShowerpumps1_1am()!=null&&!data.getShowerpumps1_1am().equals("")){_1am++;}
			if(data.getShowerpumps2_1am()!=null&&!data.getShowerpumps2_1am().equals("")){_1am++;}
			if(data.getDeckerfeedpump1_1am()!=null&&!data.getDeckerfeedpump1_1am().equals("")){_1am++;}
			if(data.getDeckerfeedpump2_1am()!=null&&!data.getDeckerfeedpump2_1am().equals("")){_1am++;}
			if(data.getDaf1_1am()!=null&&!data.getDaf1_1am().equals("")){_1am++;}
			if(data.getDaf2_1am()!=null&&!data.getDaf2_1am().equals("")){_1am++;}
			if(data.getRollupprocessfloorwashuphoses1_1am()!=null&&!data.getRollupprocessfloorwashuphoses1_1am().equals("")){_1am++;}

			if(data.getHdcleaner1_5am()!=null&&!data.getHdcleaner1_5am().equals("")){_5am++;}
			if(data.getHdcleaner2_5am()!=null&&!data.getHdcleaner2_5am().equals("")){_5am++;}
			if(data.getHdcleaner3_5am()!=null&&!data.getHdcleaner3_5am().equals("")){_5am++;}
			if(data.getHdcleaner4_5am()!=null&&!data.getHdcleaner4_5am().equals("")){_5am++;}
			if(data.getHdcleanerb_5am()!=null&&!data.getHdcleanerb_5am().equals("")){_5am++;}
			if(data.getDrumscreen1_5am()!=null&&!data.getDrumscreen1_5am().equals("")){_5am++;}
			if(data.getDrumscreen2_5am()!=null&&!data.getDrumscreen2_5am().equals("")){_5am++;}
			if(data.getDrumscreen3_5am()!=null&&!data.getDrumscreen3_5am().equals("")){_5am++;}
			if(data.getCoarsescreens1_5am()!=null&&!data.getCoarsescreens1_5am().equals("")){_5am++;}
			if(data.getCoarsescreens2_5am()!=null&&!data.getCoarsescreens2_5am().equals("")){_5am++;}
			if(data.getCoarsescreens3_5am()!=null&&!data.getCoarsescreens3_5am().equals("")){_5am++;}
			if(data.getCoarsescreens4_5am()!=null&&!data.getCoarsescreens4_5am().equals("")){_5am++;}
			if(data.getCoarsescreens5_5am()!=null&&!data.getCoarsescreens5_5am().equals("")){_5am++;}
			if(data.getCoarsescreens6_5am()!=null&&!data.getCoarsescreens6_5am().equals("")){_5am++;}
			if(data.getCoarsescreens7_5am()!=null&&!data.getCoarsescreens7_5am().equals("")){_5am++;}
			if(data.getFinescreens1_5am()!=null&&!data.getFinescreens1_5am().equals("")){_5am++;}
			if(data.getFinescreens2_5am()!=null&&!data.getFinescreens2_5am().equals("")){_5am++;}
			if(data.getFinescreens3_5am()!=null&&!data.getFinescreens3_5am().equals("")){_5am++;}
			if(data.getFinescreens4_5am()!=null&&!data.getFinescreens4_5am().equals("")){_5am++;}
			if(data.getFinescreens5_5am()!=null&&!data.getFinescreens5_5am().equals("")){_5am++;}
			if(data.getFinescreens6_5am()!=null&&!data.getFinescreens6_5am().equals("")){_5am++;}
			if(data.getShowerpumps1_5am()!=null&&!data.getShowerpumps1_5am().equals("")){_5am++;}
			if(data.getShowerpumps2_5am()!=null&&!data.getShowerpumps2_5am().equals("")){_5am++;}
			if(data.getDeckerfeedpump1_5am()!=null&&!data.getDeckerfeedpump1_5am().equals("")){_5am++;}
			if(data.getDeckerfeedpump2_5am()!=null&&!data.getDeckerfeedpump2_5am().equals("")){_5am++;}
			if(data.getDaf1_5am()!=null&&!data.getDaf1_5am().equals("")){_5am++;}
			if(data.getDaf2_5am()!=null&&!data.getDaf2_5am().equals("")){_5am++;}
			if(data.getRollupprocessfloorwashuphoses1_5am()!=null&&!data.getRollupprocessfloorwashuphoses1_5am().equals("")){_5am++;}
			
			if(_9am>=5) _9ampercent=100;  
			if(_1pm>=5) _1pmpercent=100;  
			if(_5pm>=5)	_5pmpercent=100;  
			if(_9pm>=5)	_9pmpercent=100; 
			if(_1am>=5)	_1ampercent=100; 
			if(_5am>=5)	_5ampercent=100;
			
			if(data.getCmt9amarea()!=null&&!data.getCmt9amarea().equals(""))
				_9ampercent=100;
			if(data.getCmt1pmarea()!=null&&!data.getCmt1pmarea().equals(""))
				_1pmpercent=100;				
			if(data.getCmt5pmarea()!=null&&!data.getCmt5pmarea().equals(""))
				_5pmpercent=100;
			if(data.getCmt9pmarea()!=null&&!data.getCmt9pmarea().equals(""))
				_9pmpercent=100;
			if(data.getCmt1amarea()!=null&&!data.getCmt1amarea().equals(""))
				_1ampercent=100;
			if(data.getCmt5amarea()!=null&&!data.getCmt5amarea().equals(""))
				_5ampercent=100;
			
			 percent=(_9ampercent+_1pmpercent+_5pmpercent+_9pmpercent+_1ampercent+_5ampercent)/6;
	}
		return   percent;
 }
	@Override
	public List<Integer> getCount(String sdate,String edate) throws Exception {
		
		int _9am=0,_1pm=0,_5pm=0,_9pm=0,_1am=0,_5am=0;
	 	int count=0;
		List<OpRoute_1> lst= getData(sdate,edate);
		List<Integer> al=new ArrayList<Integer>();
		for(OpRoute_1 data:lst)
		{
			if(data.getHdcleaner1_9am()!=null&&!data.getHdcleaner1_9am().equals("")){_9am++;}
			if(data.getHdcleaner2_9am()!=null&&!data.getHdcleaner2_9am().equals("")){_9am++;}
			if(data.getHdcleaner3_9am()!=null&&!data.getHdcleaner3_9am().equals("")){_9am++;}
			if(data.getHdcleaner4_9am()!=null&&!data.getHdcleaner4_9am().equals("")){_9am++;}
			if(data.getHdcleanerb_9am()!=null&&!data.getHdcleanerb_9am().equals("")){_9am++;}
			if(data.getDrumscreen1_9am()!=null&&!data.getDrumscreen1_9am().equals("")){_9am++;}
			if(data.getDrumscreen2_9am()!=null&&!data.getDrumscreen2_9am().equals("")){_9am++;}
			if(data.getDrumscreen3_9am()!=null&&!data.getDrumscreen3_9am().equals("")){_9am++;}
			if(data.getCoarsescreens1_9am()!=null&&!data.getCoarsescreens1_9am().equals("")){_9am++;}
			if(data.getCoarsescreens2_9am()!=null&&!data.getCoarsescreens2_9am().equals("")){_9am++;}
			if(data.getCoarsescreens3_9am()!=null&&!data.getCoarsescreens3_9am().equals("")){_9am++;}
			if(data.getCoarsescreens4_9am()!=null&&!data.getCoarsescreens4_9am().equals("")){_9am++;}
			if(data.getCoarsescreens5_9am()!=null&&!data.getCoarsescreens5_9am().equals("")){_9am++;}
			if(data.getCoarsescreens6_9am()!=null&&!data.getCoarsescreens6_9am().equals("")){_9am++;}
			if(data.getCoarsescreens7_9am()!=null&&!data.getCoarsescreens7_9am().equals("")){_9am++;}
			if(data.getFinescreens1_9am()!=null&&!data.getFinescreens1_9am().equals("")){_9am++;}
			if(data.getFinescreens2_9am()!=null&&!data.getFinescreens2_9am().equals("")){_9am++;}
			if(data.getFinescreens3_9am()!=null&&!data.getFinescreens3_9am().equals("")){_9am++;}
			if(data.getFinescreens4_9am()!=null&&!data.getFinescreens4_9am().equals("")){_9am++;}
			if(data.getFinescreens5_9am()!=null&&!data.getFinescreens5_9am().equals("")){_9am++;}
			if(data.getFinescreens6_9am()!=null&&!data.getFinescreens6_9am().equals("")){_9am++;}
			if(data.getShowerpumps1_9am()!=null&&!data.getShowerpumps1_9am().equals("")){_9am++;}
			if(data.getShowerpumps2_9am()!=null&&!data.getShowerpumps2_9am().equals("")){_9am++;}
			if(data.getDeckerfeedpump1_9am()!=null&&!data.getDeckerfeedpump1_9am().equals("")){_9am++;}
			if(data.getDeckerfeedpump2_9am()!=null&&!data.getDeckerfeedpump2_9am().equals("")){_9am++;}
			if(data.getDaf1_9am()!=null&&!data.getDaf1_9am().equals("")){_9am++;}
			if(data.getDaf2_9am()!=null&&!data.getDaf2_9am().equals("")){_9am++;}
			if(data.getRollupprocessfloorwashuphoses1_9am()!=null&&!data.getRollupprocessfloorwashuphoses1_9am().equals("")){_9am++;}
			
			if(data.getHdcleaner1_1pm()!=null&&!data.getHdcleaner1_1pm().equals("")){_1pm++;}
			if(data.getHdcleaner2_1pm()!=null&&!data.getHdcleaner2_1pm().equals("")){_1pm++;}
			if(data.getHdcleaner3_1pm()!=null&&!data.getHdcleaner3_1pm().equals("")){_1pm++;}
			if(data.getHdcleaner4_1pm()!=null&&!data.getHdcleaner4_1pm().equals("")){_1pm++;}
			if(data.getHdcleanerb_1pm()!=null&&!data.getHdcleanerb_1pm().equals("")){_1pm++;}
			if(data.getDrumscreen1_1pm()!=null&&!data.getDrumscreen1_1pm().equals("")){_1pm++;}
			if(data.getDrumscreen2_1pm()!=null&&!data.getDrumscreen2_1pm().equals("")){_1pm++;}
			if(data.getDrumscreen3_1pm()!=null&&!data.getDrumscreen3_1pm().equals("")){_1pm++;}
			if(data.getCoarsescreens1_1pm()!=null&&!data.getCoarsescreens1_1pm().equals("")){_1pm++;}
			if(data.getCoarsescreens2_1pm()!=null&&!data.getCoarsescreens2_1pm().equals("")){_1pm++;}
			if(data.getCoarsescreens3_1pm()!=null&&!data.getCoarsescreens3_1pm().equals("")){_1pm++;}
			if(data.getCoarsescreens4_1pm()!=null&&!data.getCoarsescreens4_1pm().equals("")){_1pm++;}
			if(data.getCoarsescreens5_1pm()!=null&&!data.getCoarsescreens5_1pm().equals("")){_1pm++;}
			if(data.getCoarsescreens6_1pm()!=null&&!data.getCoarsescreens6_1pm().equals("")){_1pm++;}
			if(data.getCoarsescreens7_1pm()!=null&&!data.getCoarsescreens7_1pm().equals("")){_1pm++;}
			if(data.getFinescreens1_1pm()!=null&&!data.getFinescreens1_1pm().equals("")){_1pm++;}
			if(data.getFinescreens2_1pm()!=null&&!data.getFinescreens2_1pm().equals("")){_1pm++;}
			if(data.getFinescreens3_1pm()!=null&&!data.getFinescreens3_1pm().equals("")){_1pm++;}
			if(data.getFinescreens4_1pm()!=null&&!data.getFinescreens4_1pm().equals("")){_1pm++;}
			if(data.getFinescreens5_1pm()!=null&&!data.getFinescreens5_1pm().equals("")){_1pm++;}
			if(data.getFinescreens6_1pm()!=null&&!data.getFinescreens6_1pm().equals("")){_1pm++;}
			if(data.getShowerpumps1_1pm()!=null&&!data.getShowerpumps1_1pm().equals("")){_1pm++;}
			if(data.getShowerpumps2_1pm()!=null&&!data.getShowerpumps2_1pm().equals("")){_1pm++;}
			if(data.getDeckerfeedpump1_1pm()!=null&&!data.getDeckerfeedpump1_1pm().equals("")){_1pm++;}
			if(data.getDeckerfeedpump2_1pm()!=null&&!data.getDeckerfeedpump2_1pm().equals("")){_1pm++;}
			if(data.getDaf1_1pm()!=null&&!data.getDaf1_1pm().equals("")){_1pm++;}
			if(data.getDaf2_1pm()!=null&&!data.getDaf2_1pm().equals("")){_1pm++;}
			if(data.getRollupprocessfloorwashuphoses1_1pm()!=null&&!data.getRollupprocessfloorwashuphoses1_1pm().equals("")){_1pm++;}

			if(data.getHdcleaner1_5pm()!=null&&!data.getHdcleaner1_5pm().equals("")){_5pm++;}
			if(data.getHdcleaner2_5pm()!=null&&!data.getHdcleaner2_5pm().equals("")){_5pm++;}
			if(data.getHdcleaner3_5pm()!=null&&!data.getHdcleaner3_5pm().equals("")){_5pm++;}
			if(data.getHdcleaner4_5pm()!=null&&!data.getHdcleaner4_5pm().equals("")){_5pm++;}
			if(data.getHdcleanerb_5pm()!=null&&!data.getHdcleanerb_5pm().equals("")){_5pm++;}
			if(data.getDrumscreen1_5pm()!=null&&!data.getDrumscreen1_5pm().equals("")){_5pm++;}
			if(data.getDrumscreen2_5pm()!=null&&!data.getDrumscreen2_5pm().equals("")){_5pm++;}
			if(data.getDrumscreen3_5pm()!=null&&!data.getDrumscreen3_5pm().equals("")){_5pm++;}
			if(data.getCoarsescreens1_5pm()!=null&&!data.getCoarsescreens1_5pm().equals("")){_5pm++;}
			if(data.getCoarsescreens2_5pm()!=null&&!data.getCoarsescreens2_5pm().equals("")){_5pm++;}
			if(data.getCoarsescreens3_5pm()!=null&&!data.getCoarsescreens3_5pm().equals("")){_5pm++;}
			if(data.getCoarsescreens4_5pm()!=null&&!data.getCoarsescreens4_5pm().equals("")){_5pm++;}
			if(data.getCoarsescreens5_5pm()!=null&&!data.getCoarsescreens5_5pm().equals("")){_5pm++;}
			if(data.getCoarsescreens6_5pm()!=null&&!data.getCoarsescreens6_5pm().equals("")){_5pm++;}
			if(data.getCoarsescreens7_5pm()!=null&&!data.getCoarsescreens7_5pm().equals("")){_5pm++;}
			if(data.getFinescreens1_5pm()!=null&&!data.getFinescreens1_5pm().equals("")){_5pm++;}
			if(data.getFinescreens2_5pm()!=null&&!data.getFinescreens2_5pm().equals("")){_5pm++;}
			if(data.getFinescreens3_5pm()!=null&&!data.getFinescreens3_5pm().equals("")){_5pm++;}
			if(data.getFinescreens4_5pm()!=null&&!data.getFinescreens4_5pm().equals("")){_5pm++;}
			if(data.getFinescreens5_5pm()!=null&&!data.getFinescreens5_5pm().equals("")){_5pm++;}
			if(data.getFinescreens6_5pm()!=null&&!data.getFinescreens6_5pm().equals("")){_5pm++;}
			if(data.getShowerpumps1_5pm()!=null&&!data.getShowerpumps1_5pm().equals("")){_5pm++;}
			if(data.getShowerpumps2_5pm()!=null&&!data.getShowerpumps2_5pm().equals("")){_5pm++;}
			if(data.getDeckerfeedpump1_5pm()!=null&&!data.getDeckerfeedpump1_5pm().equals("")){_5pm++;}
			if(data.getDeckerfeedpump2_5pm()!=null&&!data.getDeckerfeedpump2_5pm().equals("")){_5pm++;}
			if(data.getDaf1_5pm()!=null&&!data.getDaf1_5pm().equals("")){_5pm++;}
			if(data.getDaf2_5pm()!=null&&!data.getDaf2_5pm().equals("")){_5pm++;}
			if(data.getRollupprocessfloorwashuphoses1_5pm()!=null&&!data.getRollupprocessfloorwashuphoses1_5pm().equals("")){_5pm++;}

			if(data.getHdcleaner1_9pm()!=null&&!data.getHdcleaner1_9pm().equals("")){_9pm++;}
			if(data.getHdcleaner2_9pm()!=null&&!data.getHdcleaner2_9pm().equals("")){_9pm++;}
			if(data.getHdcleaner3_9pm()!=null&&!data.getHdcleaner3_9pm().equals("")){_9pm++;}
			if(data.getHdcleaner4_9pm()!=null&&!data.getHdcleaner4_9pm().equals("")){_9pm++;}
			if(data.getHdcleanerb_9pm()!=null&&!data.getHdcleanerb_9pm().equals("")){_9pm++;}
			if(data.getDrumscreen1_9pm()!=null&&!data.getDrumscreen1_9pm().equals("")){_9pm++;}
			if(data.getDrumscreen2_9pm()!=null&&!data.getDrumscreen2_9pm().equals("")){_9pm++;}
			if(data.getDrumscreen3_9pm()!=null&&!data.getDrumscreen3_9pm().equals("")){_9pm++;}
			if(data.getCoarsescreens1_9pm()!=null&&!data.getCoarsescreens1_9pm().equals("")){_9pm++;}
			if(data.getCoarsescreens2_9pm()!=null&&!data.getCoarsescreens2_9pm().equals("")){_9pm++;}
			if(data.getCoarsescreens3_9pm()!=null&&!data.getCoarsescreens3_9pm().equals("")){_9pm++;}
			if(data.getCoarsescreens4_9pm()!=null&&!data.getCoarsescreens4_9pm().equals("")){_9pm++;}
			if(data.getCoarsescreens5_9pm()!=null&&!data.getCoarsescreens5_9pm().equals("")){_9pm++;}
			if(data.getCoarsescreens6_9pm()!=null&&!data.getCoarsescreens6_9pm().equals("")){_9pm++;}
			if(data.getCoarsescreens7_9pm()!=null&&!data.getCoarsescreens7_9pm().equals("")){_9pm++;}
			if(data.getFinescreens1_9pm()!=null&&!data.getFinescreens1_9pm().equals("")){_9pm++;}
			if(data.getFinescreens2_9pm()!=null&&!data.getFinescreens2_9pm().equals("")){_9pm++;}
			if(data.getFinescreens3_9pm()!=null&&!data.getFinescreens3_9pm().equals("")){_9pm++;}
			if(data.getFinescreens4_9pm()!=null&&!data.getFinescreens4_9pm().equals("")){_9pm++;}
			if(data.getFinescreens5_9pm()!=null&&!data.getFinescreens5_9pm().equals("")){_9pm++;}
			if(data.getFinescreens6_9pm()!=null&&!data.getFinescreens6_9pm().equals("")){_9pm++;}
			if(data.getShowerpumps1_9pm()!=null&&!data.getShowerpumps1_9pm().equals("")){_9pm++;}
			if(data.getShowerpumps2_9pm()!=null&&!data.getShowerpumps2_9pm().equals("")){_9pm++;}
			if(data.getDeckerfeedpump1_9pm()!=null&&!data.getDeckerfeedpump1_9pm().equals("")){_9pm++;}
			if(data.getDeckerfeedpump2_9pm()!=null&&!data.getDeckerfeedpump2_9pm().equals("")){_9pm++;}
			if(data.getDaf1_9pm()!=null&&!data.getDaf1_9pm().equals("")){_9pm++;}
			if(data.getDaf2_9pm()!=null&&!data.getDaf2_9pm().equals("")){_9pm++;}
			if(data.getRollupprocessfloorwashuphoses1_9pm()!=null&&!data.getRollupprocessfloorwashuphoses1_9pm().equals("")){_9pm++;}

			if(data.getHdcleaner1_1am()!=null&&!data.getHdcleaner1_1am().equals("")){_1am++;}
			if(data.getHdcleaner2_1am()!=null&&!data.getHdcleaner2_1am().equals("")){_1am++;}
			if(data.getHdcleaner3_1am()!=null&&!data.getHdcleaner3_1am().equals("")){_1am++;}
			if(data.getHdcleaner4_1am()!=null&&!data.getHdcleaner4_1am().equals("")){_1am++;}
			if(data.getHdcleanerb_1am()!=null&&!data.getHdcleanerb_1am().equals("")){_1am++;}
			if(data.getDrumscreen1_1am()!=null&&!data.getDrumscreen1_1am().equals("")){_1am++;}
			if(data.getDrumscreen2_1am()!=null&&!data.getDrumscreen2_1am().equals("")){_1am++;}
			if(data.getDrumscreen3_1am()!=null&&!data.getDrumscreen3_1am().equals("")){_1am++;}
			if(data.getCoarsescreens1_1am()!=null&&!data.getCoarsescreens1_1am().equals("")){_1am++;}
			if(data.getCoarsescreens2_1am()!=null&&!data.getCoarsescreens2_1am().equals("")){_1am++;}
			if(data.getCoarsescreens3_1am()!=null&&!data.getCoarsescreens3_1am().equals("")){_1am++;}
			if(data.getCoarsescreens4_1am()!=null&&!data.getCoarsescreens4_1am().equals("")){_1am++;}
			if(data.getCoarsescreens5_1am()!=null&&!data.getCoarsescreens5_1am().equals("")){_1am++;}
			if(data.getCoarsescreens6_1am()!=null&&!data.getCoarsescreens6_1am().equals("")){_1am++;}
			if(data.getCoarsescreens7_1am()!=null&&!data.getCoarsescreens7_1am().equals("")){_1am++;}
			if(data.getFinescreens1_1am()!=null&&!data.getFinescreens1_1am().equals("")){_1am++;}
			if(data.getFinescreens2_1am()!=null&&!data.getFinescreens2_1am().equals("")){_1am++;}
			if(data.getFinescreens3_1am()!=null&&!data.getFinescreens3_1am().equals("")){_1am++;}
			if(data.getFinescreens4_1am()!=null&&!data.getFinescreens4_1am().equals("")){_1am++;}
			if(data.getFinescreens5_1am()!=null&&!data.getFinescreens5_1am().equals("")){_1am++;}
			if(data.getFinescreens6_1am()!=null&&!data.getFinescreens6_1am().equals("")){_1am++;}
			if(data.getShowerpumps1_1am()!=null&&!data.getShowerpumps1_1am().equals("")){_1am++;}
			if(data.getShowerpumps2_1am()!=null&&!data.getShowerpumps2_1am().equals("")){_1am++;}
			if(data.getDeckerfeedpump1_1am()!=null&&!data.getDeckerfeedpump1_1am().equals("")){_1am++;}
			if(data.getDeckerfeedpump2_1am()!=null&&!data.getDeckerfeedpump2_1am().equals("")){_1am++;}
			if(data.getDaf1_1am()!=null&&!data.getDaf1_1am().equals("")){_1am++;}
			if(data.getDaf2_1am()!=null&&!data.getDaf2_1am().equals("")){_1am++;}
			if(data.getRollupprocessfloorwashuphoses1_1am()!=null&&!data.getRollupprocessfloorwashuphoses1_1am().equals("")){_1am++;}

			if(data.getHdcleaner1_5am()!=null&&!data.getHdcleaner1_5am().equals("")){_5am++;}
			if(data.getHdcleaner2_5am()!=null&&!data.getHdcleaner2_5am().equals("")){_5am++;}
			if(data.getHdcleaner3_5am()!=null&&!data.getHdcleaner3_5am().equals("")){_5am++;}
			if(data.getHdcleaner4_5am()!=null&&!data.getHdcleaner4_5am().equals("")){_5am++;}
			if(data.getHdcleanerb_5am()!=null&&!data.getHdcleanerb_5am().equals("")){_5am++;}
			if(data.getDrumscreen1_5am()!=null&&!data.getDrumscreen1_5am().equals("")){_5am++;}
			if(data.getDrumscreen2_5am()!=null&&!data.getDrumscreen2_5am().equals("")){_5am++;}
			if(data.getDrumscreen3_5am()!=null&&!data.getDrumscreen3_5am().equals("")){_5am++;}
			if(data.getCoarsescreens1_5am()!=null&&!data.getCoarsescreens1_5am().equals("")){_5am++;}
			if(data.getCoarsescreens2_5am()!=null&&!data.getCoarsescreens2_5am().equals("")){_5am++;}
			if(data.getCoarsescreens3_5am()!=null&&!data.getCoarsescreens3_5am().equals("")){_5am++;}
			if(data.getCoarsescreens4_5am()!=null&&!data.getCoarsescreens4_5am().equals("")){_5am++;}
			if(data.getCoarsescreens5_5am()!=null&&!data.getCoarsescreens5_5am().equals("")){_5am++;}
			if(data.getCoarsescreens6_5am()!=null&&!data.getCoarsescreens6_5am().equals("")){_5am++;}
			if(data.getCoarsescreens7_5am()!=null&&!data.getCoarsescreens7_5am().equals("")){_5am++;}
			if(data.getFinescreens1_5am()!=null&&!data.getFinescreens1_5am().equals("")){_5am++;}
			if(data.getFinescreens2_5am()!=null&&!data.getFinescreens2_5am().equals("")){_5am++;}
			if(data.getFinescreens3_5am()!=null&&!data.getFinescreens3_5am().equals("")){_5am++;}
			if(data.getFinescreens4_5am()!=null&&!data.getFinescreens4_5am().equals("")){_5am++;}
			if(data.getFinescreens5_5am()!=null&&!data.getFinescreens5_5am().equals("")){_5am++;}
			if(data.getFinescreens6_5am()!=null&&!data.getFinescreens6_5am().equals("")){_5am++;}
			if(data.getShowerpumps1_5am()!=null&&!data.getShowerpumps1_5am().equals("")){_5am++;}
			if(data.getShowerpumps2_5am()!=null&&!data.getShowerpumps2_5am().equals("")){_5am++;}
			if(data.getDeckerfeedpump1_5am()!=null&&!data.getDeckerfeedpump1_5am().equals("")){_5am++;}
			if(data.getDeckerfeedpump2_5am()!=null&&!data.getDeckerfeedpump2_5am().equals("")){_5am++;}
			if(data.getDaf1_5am()!=null&&!data.getDaf1_5am().equals("")){_5am++;}
			if(data.getDaf2_5am()!=null&&!data.getDaf2_5am().equals("")){_5am++;}
			if(data.getRollupprocessfloorwashuphoses1_5am()!=null&&!data.getRollupprocessfloorwashuphoses1_5am().equals("")){_5am++;}
			
			if(_9am>=5){count++;}
			if(_1pm>=5){count++;}
			if(_5pm>=5){count++;}
			if(_9pm>=5){count++;}
			if(_1am>=5){count++;}
			if(_5am>=5){count++;}
			
			al.add(count);
			
			 _9am=0;_1pm=0;_5pm=0;_9pm=0;_1am=0;_5am=0;
			 count=0;
		}
		
		return al;
	}
}

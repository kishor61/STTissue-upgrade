/**
 *02-Dec2019
 *OpRoute_DaoImp.java
 * TODO
 *com.st.frpobcc.dao
 *OpRoute_4DaoImp.java
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
import com.st.frpobcc.model.OpRoute_4;

/**
 * @author sohan
 *
 */
@Repository
public class OpRoute_4DaoImp implements OpRoute_4Dao {
	
	@Autowired
	@Qualifier("dataSourceOBCC")
	private DataSource dataSourceQRT;
	/* (non-Javadoc)
	 * @see com.st.frpobcc.dao.OpRoute_1Dao#saveorUpdate(com.st.frpobcc.model.OpRoute_1)
	 */
	@Override
	public void saveorUpdate(OpRoute_4 data) {
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
		paramSource.addValue("dumpchests1_freq",data.getDumpchests1_freq());
		paramSource.addValue("dumpchests1_10am",data.getDumpchests1_10am());
		paramSource.addValue("dumpchests1_02pm",data.getDumpchests1_02pm());
		paramSource.addValue("dumpchests1_06pm",data.getDumpchests1_06pm());
		paramSource.addValue("dumpchests1_10pm",data.getDumpchests1_10pm());
		paramSource.addValue("dumpchests1_02am",data.getDumpchests1_02am());
		paramSource.addValue("dumpchests1_06am",data.getDumpchests1_06am());
		paramSource.addValue("dumpchests2_freq",data.getDumpchests2_freq());
		paramSource.addValue("dumpchests2_10am",data.getDumpchests2_10am());
		paramSource.addValue("dumpchests2_02pm",data.getDumpchests2_02pm());
		paramSource.addValue("dumpchests2_06pm",data.getDumpchests2_06pm());
		paramSource.addValue("dumpchests2_10pm",data.getDumpchests2_10pm());
		paramSource.addValue("dumpchests2_02am",data.getDumpchests2_02am());
		paramSource.addValue("dumpchests2_06am",data.getDumpchests2_06am());
		paramSource.addValue("dumpchests3_freq",data.getDumpchests3_freq());
		paramSource.addValue("dumpchests3_10am",data.getDumpchests3_10am());
		paramSource.addValue("dumpchests3_02pm",data.getDumpchests3_02pm());
		paramSource.addValue("dumpchests3_06pm",data.getDumpchests3_06pm());
		paramSource.addValue("dumpchests3_10pm",data.getDumpchests3_10pm());
		paramSource.addValue("dumpchests3_02am",data.getDumpchests3_02am());
		paramSource.addValue("dumpchests3_06am",data.getDumpchests3_06am());
		paramSource.addValue("dumpchests4_freq",data.getDumpchests4_freq());
		paramSource.addValue("dumpchests4_10am",data.getDumpchests4_10am());
		paramSource.addValue("dumpchests4_02pm",data.getDumpchests4_02pm());
		paramSource.addValue("dumpchests4_06pm",data.getDumpchests4_06pm());
		paramSource.addValue("dumpchests4_10pm",data.getDumpchests4_10pm());
		paramSource.addValue("dumpchests4_02am",data.getDumpchests4_02am());
		paramSource.addValue("dumpchests4_06am",data.getDumpchests4_06am());	
		paramSource.addValue("dumpchests5_freq",data.getDumpchests5_freq());
		paramSource.addValue("dumpchests5_10am",data.getDumpchests5_10am());
		paramSource.addValue("dumpchests5_02pm",data.getDumpchests5_02pm());
		paramSource.addValue("dumpchests5_06pm",data.getDumpchests5_06pm());
		paramSource.addValue("dumpchests5_10pm",data.getDumpchests5_10pm());
		paramSource.addValue("dumpchests5_02am",data.getDumpchests5_02am());
		paramSource.addValue("dumpchests5_06am",data.getDumpchests5_06am());
		
		paramSource.addValue("rejectscollectionbunker1_freq",data.getRejectscollectionbunker1_freq());
		paramSource.addValue("rejectscollectionbunker1_10am",data.getRejectscollectionbunker1_10am());
		paramSource.addValue("rejectscollectionbunker1_02pm",data.getRejectscollectionbunker1_02pm());
		paramSource.addValue("rejectscollectionbunker1_06pm",data.getRejectscollectionbunker1_06pm());
		paramSource.addValue("rejectscollectionbunker1_10pm",data.getRejectscollectionbunker1_10pm());
		paramSource.addValue("rejectscollectionbunker1_02am",data.getRejectscollectionbunker1_02am());
		paramSource.addValue("rejectscollectionbunker1_06am",data.getRejectscollectionbunker1_06am());
		paramSource.addValue("rejectscollectionbunker2_freq",data.getRejectscollectionbunker2_freq());
		paramSource.addValue("rejectscollectionbunker2_10am",data.getRejectscollectionbunker2_10am());
		paramSource.addValue("rejectscollectionbunker2_02pm",data.getRejectscollectionbunker2_02pm());
		paramSource.addValue("rejectscollectionbunker2_06pm",data.getRejectscollectionbunker2_06pm());
		paramSource.addValue("rejectscollectionbunker2_10pm",data.getRejectscollectionbunker2_10pm());
		paramSource.addValue("rejectscollectionbunker2_02am",data.getRejectscollectionbunker2_02am());
		paramSource.addValue("rejectscollectionbunker2_06am",data.getRejectscollectionbunker2_06am());
		
		paramSource.addValue("batchpulperbasement1_freq",data.getBatchpulperbasement1_freq());
		paramSource.addValue("batchpulperbasement1_10am",data.getBatchpulperbasement1_10am());
		paramSource.addValue("batchpulperbasement1_02pm",data.getBatchpulperbasement1_02pm());
		paramSource.addValue("batchpulperbasement1_06pm",data.getBatchpulperbasement1_06pm());
		paramSource.addValue("batchpulperbasement1_10pm",data.getBatchpulperbasement1_10pm());
		paramSource.addValue("batchpulperbasement1_02am",data.getBatchpulperbasement1_02am());
		paramSource.addValue("batchpulperbasement1_06am",data.getBatchpulperbasement1_06am());
		paramSource.addValue("batchpulperbasement2_freq",data.getBatchpulperbasement2_freq());
		paramSource.addValue("batchpulperbasement2_10am",data.getBatchpulperbasement2_10am());
		paramSource.addValue("batchpulperbasement2_02pm",data.getBatchpulperbasement2_02pm());
		paramSource.addValue("batchpulperbasement2_06pm",data.getBatchpulperbasement2_06pm());
		paramSource.addValue("batchpulperbasement2_10pm",data.getBatchpulperbasement2_10pm());
		paramSource.addValue("batchpulperbasement2_02am",data.getBatchpulperbasement2_02am());
		paramSource.addValue("batchpulperbasement2_06am",data.getBatchpulperbasement2_06am());
		paramSource.addValue("batchpulperbasement3_freq",data.getBatchpulperbasement3_freq());
		paramSource.addValue("batchpulperbasement3_10am",data.getBatchpulperbasement3_10am());
		paramSource.addValue("batchpulperbasement3_02pm",data.getBatchpulperbasement3_02pm());
		paramSource.addValue("batchpulperbasement3_06pm",data.getBatchpulperbasement3_06pm());
		paramSource.addValue("batchpulperbasement3_10pm",data.getBatchpulperbasement3_10pm());
		paramSource.addValue("batchpulperbasement3_02am",data.getBatchpulperbasement3_02am());
		paramSource.addValue("batchpulperbasement3_06am",data.getBatchpulperbasement3_06am());
		paramSource.addValue("batchpulperbasement4_freq",data.getBatchpulperbasement4_freq());
		paramSource.addValue("batchpulperbasement4_10am",data.getBatchpulperbasement4_10am());
		paramSource.addValue("batchpulperbasement4_02pm",data.getBatchpulperbasement4_02pm());
		paramSource.addValue("batchpulperbasement4_06pm",data.getBatchpulperbasement4_06pm());
		paramSource.addValue("batchpulperbasement4_10pm",data.getBatchpulperbasement4_10pm());
		paramSource.addValue("batchpulperbasement4_02am",data.getBatchpulperbasement4_02am());
		paramSource.addValue("batchpulperbasement4_06am",data.getBatchpulperbasement4_06am());
		
		paramSource.addValue("detrasher1_freq",data.getDetrasher1_freq());
		paramSource.addValue("detrasher1_10am",data.getDetrasher1_10am());
		paramSource.addValue("detrasher1_02pm",data.getDetrasher1_02pm());
		paramSource.addValue("detrasher1_06pm",data.getDetrasher1_06pm());
		paramSource.addValue("detrasher1_10pm",data.getDetrasher1_10pm());
		paramSource.addValue("detrasher1_02am",data.getDetrasher1_02am());
		paramSource.addValue("detrasher1_06am",data.getDetrasher1_06am());
		paramSource.addValue("detrasher2_freq",data.getDetrasher2_freq());
		paramSource.addValue("detrasher2_10am",data.getDetrasher2_10am());
		paramSource.addValue("detrasher2_02pm",data.getDetrasher2_02pm());
		paramSource.addValue("detrasher2_06pm",data.getDetrasher2_06pm());
		paramSource.addValue("detrasher2_10pm",data.getDetrasher2_10pm());
		paramSource.addValue("detrasher2_02am",data.getDetrasher2_02am());
		paramSource.addValue("detrasher2_06am",data.getDetrasher2_06am());
		paramSource.addValue("detrasher3_freq",data.getDetrasher3_freq());
		paramSource.addValue("detrasher3_10am",data.getDetrasher3_10am());
		paramSource.addValue("detrasher3_02pm",data.getDetrasher3_02pm());
		paramSource.addValue("detrasher3_06pm",data.getDetrasher3_06pm());
		paramSource.addValue("detrasher3_10pm",data.getDetrasher3_10pm());
		paramSource.addValue("detrasher3_02am",data.getDetrasher3_02am());
		paramSource.addValue("detrasher3_06am",data.getDetrasher3_06am());
		
		paramSource.addValue("contaminexpump1_freq",data.getContaminexpump1_freq());
		paramSource.addValue("contaminexpump1_10am",data.getContaminexpump1_10am());
		paramSource.addValue("contaminexpump1_02pm",data.getContaminexpump1_02pm());
		paramSource.addValue("contaminexpump1_06pm",data.getContaminexpump1_06pm());
		paramSource.addValue("contaminexpump1_10pm",data.getContaminexpump1_10pm());
		paramSource.addValue("contaminexpump1_02am",data.getContaminexpump1_02am());
		paramSource.addValue("contaminexpump1_06am",data.getContaminexpump1_06am());
		paramSource.addValue("contaminexpump2_freq",data.getContaminexpump2_freq());
		paramSource.addValue("contaminexpump2_10am",data.getContaminexpump2_10am());
		paramSource.addValue("contaminexpump2_02pm",data.getContaminexpump2_02pm());
		paramSource.addValue("contaminexpump2_06pm",data.getContaminexpump2_06pm());
		paramSource.addValue("contaminexpump2_10pm",data.getContaminexpump2_10pm());
		paramSource.addValue("contaminexpump2_02am",data.getContaminexpump2_02am());
		paramSource.addValue("contaminexpump2_06am",data.getContaminexpump2_06am());
		paramSource.addValue("contaminexpump3_freq",data.getContaminexpump3_freq());
		paramSource.addValue("contaminexpump3_10am",data.getContaminexpump3_10am());
		paramSource.addValue("contaminexpump3_02pm",data.getContaminexpump3_02pm());
		paramSource.addValue("contaminexpump3_06pm",data.getContaminexpump3_06pm());
		paramSource.addValue("contaminexpump3_10pm",data.getContaminexpump3_10pm());
		paramSource.addValue("contaminexpump3_02am",data.getContaminexpump3_02am());
		paramSource.addValue("contaminexpump3_06am",data.getContaminexpump3_06am());
		
		paramSource.addValue("rejectspress1_freq",data.getRejectspress1_freq());
		paramSource.addValue("rejectspress1_10am",data.getRejectspress1_10am());
		paramSource.addValue("rejectspress1_02pm",data.getRejectspress1_02pm());
		paramSource.addValue("rejectspress1_06pm",data.getRejectspress1_06pm());
		paramSource.addValue("rejectspress1_10pm",data.getRejectspress1_10pm());
		paramSource.addValue("rejectspress1_02am",data.getRejectspress1_02am());
		paramSource.addValue("rejectspress1_06am",data.getRejectspress1_06am());
		paramSource.addValue("rejectspress2_freq",data.getRejectspress2_freq());
		paramSource.addValue("rejectspress2_10am",data.getRejectspress2_10am());
		paramSource.addValue("rejectspress2_02pm",data.getRejectspress2_02pm());
		paramSource.addValue("rejectspress2_06pm",data.getRejectspress2_06pm());
		paramSource.addValue("rejectspress2_10pm",data.getRejectspress2_10pm());
		paramSource.addValue("rejectspress2_02am",data.getRejectspress2_02am());
		paramSource.addValue("rejectspress2_06am",data.getRejectspress2_06am());
		paramSource.addValue("rejectspress3_freq",data.getRejectspress3_freq());
		paramSource.addValue("rejectspress3_10am",data.getRejectspress3_10am());
		paramSource.addValue("rejectspress3_02pm",data.getRejectspress3_02pm());
		paramSource.addValue("rejectspress3_06pm",data.getRejectspress3_06pm());
		paramSource.addValue("rejectspress3_10pm",data.getRejectspress3_10pm());
		paramSource.addValue("rejectspress3_02am",data.getRejectspress3_02am());
		paramSource.addValue("rejectspress3_06am",data.getRejectspress3_06am());
		
		paramSource.addValue("dewateringscrew1_freq",data.getDewateringscrew1_freq());
		paramSource.addValue("dewateringscrew1_10am",data.getDewateringscrew1_10am());
		paramSource.addValue("dewateringscrew1_02pm",data.getDewateringscrew1_02pm());
		paramSource.addValue("dewateringscrew1_06pm",data.getDewateringscrew1_06pm());
		paramSource.addValue("dewateringscrew1_10pm",data.getDewateringscrew1_10pm());
		paramSource.addValue("dewateringscrew1_02am",data.getDewateringscrew1_02am());
		paramSource.addValue("dewateringscrew1_06am",data.getDewateringscrew1_06am());
		paramSource.addValue("dewateringscrew2_freq",data.getDewateringscrew2_freq());
		paramSource.addValue("dewateringscrew2_10am",data.getDewateringscrew2_10am());
		paramSource.addValue("dewateringscrew2_02pm",data.getDewateringscrew2_02pm());
		paramSource.addValue("dewateringscrew2_06pm",data.getDewateringscrew2_06pm());
		paramSource.addValue("dewateringscrew2_10pm",data.getDewateringscrew2_10pm());
		paramSource.addValue("dewateringscrew2_02am",data.getDewateringscrew2_02am());
		paramSource.addValue("dewateringscrew2_06am",data.getDewateringscrew2_06am());
		paramSource.addValue("dewateringscrew3_freq",data.getDewateringscrew3_freq());
		paramSource.addValue("dewateringscrew3_10am",data.getDewateringscrew3_10am());
		paramSource.addValue("dewateringscrew3_02pm",data.getDewateringscrew3_02pm());
		paramSource.addValue("dewateringscrew3_06pm",data.getDewateringscrew3_06pm());
		paramSource.addValue("dewateringscrew3_10pm",data.getDewateringscrew3_10pm());
		paramSource.addValue("dewateringscrew3_02am",data.getDewateringscrew3_02am());
		paramSource.addValue("dewateringscrew3_06am",data.getDewateringscrew3_06am());
		
		paramSource.addValue("clarifiedwaterchest1_freq",data.getClarifiedwaterchest1_freq());
		paramSource.addValue("clarifiedwaterchest1_10am",data.getClarifiedwaterchest1_10am());
		paramSource.addValue("clarifiedwaterchest1_02pm",data.getClarifiedwaterchest1_02pm());
		paramSource.addValue("clarifiedwaterchest1_06pm",data.getClarifiedwaterchest1_06pm());
		paramSource.addValue("clarifiedwaterchest1_10pm",data.getClarifiedwaterchest1_10pm());
		paramSource.addValue("clarifiedwaterchest1_02am",data.getClarifiedwaterchest1_02am());
		paramSource.addValue("clarifiedwaterchest1_06am",data.getClarifiedwaterchest1_06am());
		paramSource.addValue("clarifiedwaterchest2_freq",data.getClarifiedwaterchest2_freq());
		paramSource.addValue("clarifiedwaterchest2_10am",data.getClarifiedwaterchest2_10am());
		paramSource.addValue("clarifiedwaterchest2_02pm",data.getClarifiedwaterchest2_02pm());
		paramSource.addValue("clarifiedwaterchest2_06pm",data.getClarifiedwaterchest2_06pm());
		paramSource.addValue("clarifiedwaterchest2_10pm",data.getClarifiedwaterchest2_10pm());
		paramSource.addValue("clarifiedwaterchest2_02am",data.getClarifiedwaterchest2_02am());
		paramSource.addValue("clarifiedwaterchest2_06am",data.getClarifiedwaterchest2_06am());
		
		paramSource.addValue("deinkwhitewaterchest1_freq",data.getDeinkwhitewaterchest1_freq());
		paramSource.addValue("deinkwhitewaterchest1_10am",data.getDeinkwhitewaterchest1_10am());
		paramSource.addValue("deinkwhitewaterchest1_02pm",data.getDeinkwhitewaterchest1_02pm());
		paramSource.addValue("deinkwhitewaterchest1_06pm",data.getDeinkwhitewaterchest1_06pm());
		paramSource.addValue("deinkwhitewaterchest1_10pm",data.getDeinkwhitewaterchest1_10pm());
		paramSource.addValue("deinkwhitewaterchest1_02am",data.getDeinkwhitewaterchest1_02am());
		paramSource.addValue("deinkwhitewaterchest1_06am",data.getDeinkwhitewaterchest1_06am());
		paramSource.addValue("deinkwhitewaterchest2_freq",data.getDeinkwhitewaterchest2_freq());
		paramSource.addValue("deinkwhitewaterchest2_10am",data.getDeinkwhitewaterchest2_10am());
		paramSource.addValue("deinkwhitewaterchest2_02pm",data.getDeinkwhitewaterchest2_02pm());
		paramSource.addValue("deinkwhitewaterchest2_06pm",data.getDeinkwhitewaterchest2_06pm());
		paramSource.addValue("deinkwhitewaterchest2_10pm",data.getDeinkwhitewaterchest2_10pm());
		paramSource.addValue("deinkwhitewaterchest2_02am",data.getDeinkwhitewaterchest2_02am());
		paramSource.addValue("deinkwhitewaterchest2_06am",data.getDeinkwhitewaterchest2_06am());
		paramSource.addValue("deinkwhitewaterchest3_freq",data.getDeinkwhitewaterchest3_freq());
		paramSource.addValue("deinkwhitewaterchest3_10am",data.getDeinkwhitewaterchest3_10am());
		paramSource.addValue("deinkwhitewaterchest3_02pm",data.getDeinkwhitewaterchest3_02pm());
		paramSource.addValue("deinkwhitewaterchest3_06pm",data.getDeinkwhitewaterchest3_06pm());
		paramSource.addValue("deinkwhitewaterchest3_10pm",data.getDeinkwhitewaterchest3_10pm());
		paramSource.addValue("deinkwhitewaterchest3_02am",data.getDeinkwhitewaterchest3_02am());
		paramSource.addValue("deinkwhitewaterchest3_06am",data.getDeinkwhitewaterchest3_06am());
		paramSource.addValue("deinkwhitewaterchest4_freq",data.getDeinkwhitewaterchest4_freq());
		paramSource.addValue("deinkwhitewaterchest4_10am",data.getDeinkwhitewaterchest4_10am());
		paramSource.addValue("deinkwhitewaterchest4_02pm",data.getDeinkwhitewaterchest4_02pm());
		paramSource.addValue("deinkwhitewaterchest4_06pm",data.getDeinkwhitewaterchest4_06pm());
		paramSource.addValue("deinkwhitewaterchest4_10pm",data.getDeinkwhitewaterchest4_10pm());
		paramSource.addValue("deinkwhitewaterchest4_02am",data.getDeinkwhitewaterchest4_02am());
		paramSource.addValue("deinkwhitewaterchest4_06am",data.getDeinkwhitewaterchest4_06am());	
		paramSource.addValue("deinkwhitewaterchest5_freq",data.getDeinkwhitewaterchest5_freq());
		paramSource.addValue("deinkwhitewaterchest5_10am",data.getDeinkwhitewaterchest5_10am());
		paramSource.addValue("deinkwhitewaterchest5_02pm",data.getDeinkwhitewaterchest5_02pm());
		paramSource.addValue("deinkwhitewaterchest5_06pm",data.getDeinkwhitewaterchest5_06pm());
		paramSource.addValue("deinkwhitewaterchest5_10pm",data.getDeinkwhitewaterchest5_10pm());
		paramSource.addValue("deinkwhitewaterchest5_02am",data.getDeinkwhitewaterchest5_02am());
		paramSource.addValue("deinkwhitewaterchest5_06am",data.getDeinkwhitewaterchest5_06am());
	
		paramSource.addValue("cmt9amarea", data.getCmt9amarea());
		paramSource.addValue("cmt1pmarea", data.getCmt1pmarea());
		paramSource.addValue("cmt5pmarea", data.getCmt5pmarea());
		paramSource.addValue("cmt9pmarea", data.getCmt9pmarea());
		paramSource.addValue("cmt1amarea", data.getCmt1amarea());
		paramSource.addValue("cmt5amarea", data.getCmt5amarea());
		
			if (data.getId() == 0) {	
				String sql=DatabaseUtil.getSQL("sql/insertOpRoute_4.sql");
				jdbcTemplate.update(sql, paramSource);
			}	
			else
			{
				paramSource.addValue("id",data.getId());
				String sql=DatabaseUtil.getSQL("sql/updateOpRoute_4.sql");
				jdbcTemplate.update(sql, paramSource);
			}		
}
	/* (non-Javadoc)
	 * @see com.st.frpobcc.dao.OpRoute_4Dao#getData(java.lang.String)
	 */
	@Override
	public List<OpRoute_4> getData(String sdate,String edate) {		
				JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSourceQRT);
				String sql = "select * from [OpRoute_4] where date BETWEEN ? AND ?";
				List<OpRoute_4> oproute_4=null;
				try {
					oproute_4 = jdbcTemplate.query(sql, new Object[] {sdate,edate}, new RowMapper<OpRoute_4>() {
		
			@Override
			public OpRoute_4 mapRow(ResultSet rs, int arg1) throws SQLException {
			OpRoute_4 data=new OpRoute_4();
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
			data.setDumpchests1_freq(rs.getString("dumpchests1_freq"));
			data.setDumpchests1_10am(rs.getString("dumpchests1_10am"));
			data.setDumpchests1_02pm(rs.getString("dumpchests1_02pm"));
			data.setDumpchests1_06pm(rs.getString("dumpchests1_06pm"));
			data.setDumpchests1_10pm(rs.getString("dumpchests1_10pm"));
			data.setDumpchests1_02am(rs.getString("dumpchests1_02am"));
			data.setDumpchests1_06am(rs.getString("dumpchests1_06am"));
			data.setDumpchests2_freq(rs.getString("dumpchests2_freq"));
			data.setDumpchests2_10am(rs.getString("dumpchests2_10am"));
			data.setDumpchests2_02pm(rs.getString("dumpchests2_02pm"));
			data.setDumpchests2_06pm(rs.getString("dumpchests2_06pm"));
			data.setDumpchests2_10pm(rs.getString("dumpchests2_10pm"));
			data.setDumpchests2_02am(rs.getString("dumpchests2_02am"));
			data.setDumpchests2_06am(rs.getString("dumpchests2_06am"));
			data.setDumpchests3_freq(rs.getString("dumpchests3_freq"));
			data.setDumpchests3_10am(rs.getString("dumpchests3_10am"));
			data.setDumpchests3_02pm(rs.getString("dumpchests3_02pm"));
			data.setDumpchests3_06pm(rs.getString("dumpchests3_06pm"));
			data.setDumpchests3_10pm(rs.getString("dumpchests3_10pm"));
			data.setDumpchests3_02am(rs.getString("dumpchests3_02am"));
			data.setDumpchests3_06am(rs.getString("dumpchests3_06am"));
			data.setDumpchests4_freq(rs.getString("dumpchests4_freq"));
			data.setDumpchests4_10am(rs.getString("dumpchests4_10am"));
			data.setDumpchests4_02pm(rs.getString("dumpchests4_02pm"));
			data.setDumpchests4_06pm(rs.getString("dumpchests4_06pm"));
			data.setDumpchests4_10pm(rs.getString("dumpchests4_10pm"));
			data.setDumpchests4_02am(rs.getString("dumpchests4_02am"));
			data.setDumpchests4_06am(rs.getString("dumpchests4_06am"));
			data.setDumpchests5_freq(rs.getString("dumpchests5_freq"));
			data.setDumpchests5_10am(rs.getString("dumpchests5_10am"));
			data.setDumpchests5_02pm(rs.getString("dumpchests5_02pm"));
			data.setDumpchests5_06pm(rs.getString("dumpchests5_06pm"));
			data.setDumpchests5_10pm(rs.getString("dumpchests5_10pm"));
			data.setDumpchests5_02am(rs.getString("dumpchests5_02am"));
			data.setDumpchests5_06am(rs.getString("dumpchests5_06am"));
			data.setContaminexpump1_freq(rs.getString("contaminexpump1_freq"));
			data.setContaminexpump1_10am(rs.getString("contaminexpump1_10am"));
			data.setContaminexpump1_02pm(rs.getString("contaminexpump1_02pm"));
			data.setContaminexpump1_06pm(rs.getString("contaminexpump1_06pm"));
			data.setContaminexpump1_10pm(rs.getString("contaminexpump1_10pm"));
			data.setContaminexpump1_02am(rs.getString("contaminexpump1_02am"));
			data.setContaminexpump1_06am(rs.getString("contaminexpump1_06am"));
			data.setContaminexpump2_freq(rs.getString("contaminexpump2_freq"));
			data.setContaminexpump2_10am(rs.getString("contaminexpump2_10am"));
			data.setContaminexpump2_02pm(rs.getString("contaminexpump2_02pm"));
			data.setContaminexpump2_06pm(rs.getString("contaminexpump2_06pm"));
			data.setContaminexpump2_10pm(rs.getString("contaminexpump2_10pm"));
			data.setContaminexpump2_02am(rs.getString("contaminexpump2_02am"));
			data.setContaminexpump2_06am(rs.getString("contaminexpump2_06am"));
			data.setContaminexpump3_freq(rs.getString("contaminexpump3_freq"));
			data.setContaminexpump3_10am(rs.getString("contaminexpump3_10am"));
			data.setContaminexpump3_02pm(rs.getString("contaminexpump3_02pm"));
			data.setContaminexpump3_06pm(rs.getString("contaminexpump3_06pm"));
			data.setContaminexpump3_10pm(rs.getString("contaminexpump3_10pm"));
			data.setContaminexpump3_02am(rs.getString("contaminexpump3_02am"));
			data.setContaminexpump3_06am(rs.getString("contaminexpump3_06am"));
			data.setRejectscollectionbunker1_freq(rs.getString("rejectscollectionbunker1_freq"));
			data.setRejectscollectionbunker1_10am(rs.getString("rejectscollectionbunker1_10am"));
			data.setRejectscollectionbunker1_02pm(rs.getString("rejectscollectionbunker1_02pm"));
			data.setRejectscollectionbunker1_06pm(rs.getString("rejectscollectionbunker1_06pm"));
			data.setRejectscollectionbunker1_10pm(rs.getString("rejectscollectionbunker1_10pm"));
			data.setRejectscollectionbunker1_02am(rs.getString("rejectscollectionbunker1_02am"));
			data.setRejectscollectionbunker1_06am(rs.getString("rejectscollectionbunker1_06am"));
			data.setRejectscollectionbunker2_freq(rs.getString("rejectscollectionbunker2_freq"));
			data.setRejectscollectionbunker2_10am(rs.getString("rejectscollectionbunker2_10am"));
			data.setRejectscollectionbunker2_02pm(rs.getString("rejectscollectionbunker2_02pm"));
			data.setRejectscollectionbunker2_06pm(rs.getString("rejectscollectionbunker2_06pm"));
			data.setRejectscollectionbunker2_10pm(rs.getString("rejectscollectionbunker2_10pm"));
			data.setRejectscollectionbunker2_02am(rs.getString("rejectscollectionbunker2_02am"));
			data.setRejectscollectionbunker2_06am(rs.getString("rejectscollectionbunker2_06am"));
			data.setBatchpulperbasement1_freq(rs.getString("batchpulperbasement1_freq"));
			data.setBatchpulperbasement1_10am(rs.getString("batchpulperbasement1_10am"));
			data.setBatchpulperbasement1_02pm(rs.getString("batchpulperbasement1_02pm"));
			data.setBatchpulperbasement1_06pm(rs.getString("batchpulperbasement1_06pm"));
			data.setBatchpulperbasement1_10pm(rs.getString("batchpulperbasement1_10pm"));
			data.setBatchpulperbasement1_02am(rs.getString("batchpulperbasement1_02am"));
			data.setBatchpulperbasement1_06am(rs.getString("batchpulperbasement1_06am"));
			data.setBatchpulperbasement2_freq(rs.getString("batchpulperbasement2_freq"));
			data.setBatchpulperbasement2_10am(rs.getString("batchpulperbasement2_10am"));
			data.setBatchpulperbasement2_02pm(rs.getString("batchpulperbasement2_02pm"));
			data.setBatchpulperbasement2_06pm(rs.getString("batchpulperbasement2_06pm"));
			data.setBatchpulperbasement2_10pm(rs.getString("batchpulperbasement2_10pm"));
			data.setBatchpulperbasement2_02am(rs.getString("batchpulperbasement2_02am"));
			data.setBatchpulperbasement2_06am(rs.getString("batchpulperbasement2_06am"));
			data.setBatchpulperbasement3_freq(rs.getString("batchpulperbasement3_freq"));
			data.setBatchpulperbasement3_10am(rs.getString("batchpulperbasement3_10am"));
			data.setBatchpulperbasement3_02pm(rs.getString("batchpulperbasement3_02pm"));
			data.setBatchpulperbasement3_06pm(rs.getString("batchpulperbasement3_06pm"));
			data.setBatchpulperbasement3_10pm(rs.getString("batchpulperbasement3_10pm"));
			data.setBatchpulperbasement3_02am(rs.getString("batchpulperbasement3_02am"));
			data.setBatchpulperbasement3_06am(rs.getString("batchpulperbasement3_06am"));
			data.setBatchpulperbasement4_freq(rs.getString("batchpulperbasement4_freq"));
			data.setBatchpulperbasement4_10am(rs.getString("batchpulperbasement4_10am"));
			data.setBatchpulperbasement4_02pm(rs.getString("batchpulperbasement4_02pm"));
			data.setBatchpulperbasement4_06pm(rs.getString("batchpulperbasement4_06pm"));
			data.setBatchpulperbasement4_10pm(rs.getString("batchpulperbasement4_10pm"));
			data.setBatchpulperbasement4_02am(rs.getString("batchpulperbasement4_02am"));
			data.setBatchpulperbasement4_06am(rs.getString("batchpulperbasement4_06am"));
			data.setDetrasher1_freq(rs.getString("detrasher1_freq"));
			data.setDetrasher1_10am(rs.getString("detrasher1_10am"));
			data.setDetrasher1_02pm(rs.getString("detrasher1_02pm"));
			data.setDetrasher1_06pm(rs.getString("detrasher1_06pm"));
			data.setDetrasher1_10pm(rs.getString("detrasher1_10pm"));
			data.setDetrasher1_02am(rs.getString("detrasher1_02am"));
			data.setDetrasher1_06am(rs.getString("detrasher1_06am"));
			data.setDetrasher2_freq(rs.getString("detrasher2_freq"));
			data.setDetrasher2_10am(rs.getString("detrasher2_10am"));
			data.setDetrasher2_02pm(rs.getString("detrasher2_02pm"));
			data.setDetrasher2_06pm(rs.getString("detrasher2_06pm"));
			data.setDetrasher2_10pm(rs.getString("detrasher2_10pm"));
			data.setDetrasher2_02am(rs.getString("detrasher2_02am"));
			data.setDetrasher2_06am(rs.getString("detrasher2_06am"));
			data.setDetrasher3_freq(rs.getString("detrasher3_freq"));
			data.setDetrasher3_10am(rs.getString("detrasher3_10am"));
			data.setDetrasher3_02pm(rs.getString("detrasher3_02pm"));
			data.setDetrasher3_06pm(rs.getString("detrasher3_06pm"));
			data.setDetrasher3_10pm(rs.getString("detrasher3_10pm"));
			data.setDetrasher3_02am(rs.getString("detrasher3_02am"));
			data.setDetrasher3_06am(rs.getString("detrasher3_06am"));
			data.setRejectspress1_freq(rs.getString("rejectspress1_freq"));
			data.setRejectspress1_10am(rs.getString("rejectspress1_10am"));
			data.setRejectspress1_02pm(rs.getString("rejectspress1_02pm"));
			data.setRejectspress1_06pm(rs.getString("rejectspress1_06pm"));
			data.setRejectspress1_10pm(rs.getString("rejectspress1_10pm"));
			data.setRejectspress1_02am(rs.getString("rejectspress1_02am"));
			data.setRejectspress1_06am(rs.getString("rejectspress1_06am"));
			data.setRejectspress2_freq(rs.getString("rejectspress2_freq"));
			data.setRejectspress2_10am(rs.getString("rejectspress2_10am"));
			data.setRejectspress2_02pm(rs.getString("rejectspress2_02pm"));
			data.setRejectspress2_06pm(rs.getString("rejectspress2_06pm"));
			data.setRejectspress2_10pm(rs.getString("rejectspress2_10pm"));
			data.setRejectspress2_02am(rs.getString("rejectspress2_02am"));
			data.setRejectspress2_06am(rs.getString("rejectspress2_06am"));
			data.setRejectspress3_freq(rs.getString("rejectspress3_freq"));
			data.setRejectspress3_10am(rs.getString("rejectspress3_10am"));
			data.setRejectspress3_02pm(rs.getString("rejectspress3_02pm"));
			data.setRejectspress3_06pm(rs.getString("rejectspress3_06pm"));
			data.setRejectspress3_10pm(rs.getString("rejectspress3_10pm"));
			data.setRejectspress3_02am(rs.getString("rejectspress3_02am"));
			data.setRejectspress3_06am(rs.getString("rejectspress3_06am"));
			data.setDewateringscrew1_freq(rs.getString("dewateringscrew1_freq"));
			data.setDewateringscrew1_10am(rs.getString("dewateringscrew1_10am"));
			data.setDewateringscrew1_02pm(rs.getString("dewateringscrew1_02pm"));
			data.setDewateringscrew1_06pm(rs.getString("dewateringscrew1_06pm"));
			data.setDewateringscrew1_10pm(rs.getString("dewateringscrew1_10pm"));
			data.setDewateringscrew1_02am(rs.getString("dewateringscrew1_02am"));
			data.setDewateringscrew1_06am(rs.getString("dewateringscrew1_06am"));
			data.setDewateringscrew2_freq(rs.getString("dewateringscrew2_freq"));
			data.setDewateringscrew2_10am(rs.getString("dewateringscrew2_10am"));
			data.setDewateringscrew2_02pm(rs.getString("dewateringscrew2_02pm"));
			data.setDewateringscrew2_06pm(rs.getString("dewateringscrew2_06pm"));
			data.setDewateringscrew2_10pm(rs.getString("dewateringscrew2_10pm"));
			data.setDewateringscrew2_02am(rs.getString("dewateringscrew2_02am"));
			data.setDewateringscrew2_06am(rs.getString("dewateringscrew2_06am"));
			data.setDewateringscrew3_freq(rs.getString("dewateringscrew3_freq"));
			data.setDewateringscrew3_10am(rs.getString("dewateringscrew3_10am"));
			data.setDewateringscrew3_02pm(rs.getString("dewateringscrew3_02pm"));
			data.setDewateringscrew3_06pm(rs.getString("dewateringscrew3_06pm"));
			data.setDewateringscrew3_10pm(rs.getString("dewateringscrew3_10pm"));
			data.setDewateringscrew3_02am(rs.getString("dewateringscrew3_02am"));
			data.setDewateringscrew3_06am(rs.getString("dewateringscrew3_06am"));
			data.setClarifiedwaterchest1_freq(rs.getString("clarifiedwaterchest1_freq"));
			data.setClarifiedwaterchest1_10am(rs.getString("clarifiedwaterchest1_10am"));
			data.setClarifiedwaterchest1_02pm(rs.getString("clarifiedwaterchest1_02pm"));
			data.setClarifiedwaterchest1_06pm(rs.getString("clarifiedwaterchest1_06pm"));
			data.setClarifiedwaterchest1_10pm(rs.getString("clarifiedwaterchest1_10pm"));
			data.setClarifiedwaterchest1_02am(rs.getString("clarifiedwaterchest1_02am"));
			data.setClarifiedwaterchest1_06am(rs.getString("clarifiedwaterchest1_06am"));
			data.setClarifiedwaterchest2_freq(rs.getString("clarifiedwaterchest2_freq"));
			data.setClarifiedwaterchest2_10am(rs.getString("clarifiedwaterchest2_10am"));
			data.setClarifiedwaterchest2_02pm(rs.getString("clarifiedwaterchest2_02pm"));
			data.setClarifiedwaterchest2_06pm(rs.getString("clarifiedwaterchest2_06pm"));
			data.setClarifiedwaterchest2_10pm(rs.getString("clarifiedwaterchest2_10pm"));
			data.setClarifiedwaterchest2_02am(rs.getString("clarifiedwaterchest2_02am"));
			data.setClarifiedwaterchest2_06am(rs.getString("clarifiedwaterchest2_06am"));
			data.setDeinkwhitewaterchest1_freq(rs.getString("deinkwhitewaterchest1_freq"));
			data.setDeinkwhitewaterchest1_10am(rs.getString("deinkwhitewaterchest1_10am"));
			data.setDeinkwhitewaterchest1_02pm(rs.getString("deinkwhitewaterchest1_02pm"));
			data.setDeinkwhitewaterchest1_06pm(rs.getString("deinkwhitewaterchest1_06pm"));
			data.setDeinkwhitewaterchest1_10pm(rs.getString("deinkwhitewaterchest1_10pm"));
			data.setDeinkwhitewaterchest1_02am(rs.getString("deinkwhitewaterchest1_02am"));
			data.setDeinkwhitewaterchest1_06am(rs.getString("deinkwhitewaterchest1_06am"));
			data.setDeinkwhitewaterchest2_freq(rs.getString("deinkwhitewaterchest2_freq"));
			data.setDeinkwhitewaterchest2_10am(rs.getString("deinkwhitewaterchest2_10am"));
			data.setDeinkwhitewaterchest2_02pm(rs.getString("deinkwhitewaterchest2_02pm"));
			data.setDeinkwhitewaterchest2_06pm(rs.getString("deinkwhitewaterchest2_06pm"));
			data.setDeinkwhitewaterchest2_10pm(rs.getString("deinkwhitewaterchest2_10pm"));
			data.setDeinkwhitewaterchest2_02am(rs.getString("deinkwhitewaterchest2_02am"));
			data.setDeinkwhitewaterchest2_06am(rs.getString("deinkwhitewaterchest2_06am"));
			data.setDeinkwhitewaterchest3_freq(rs.getString("deinkwhitewaterchest3_freq"));
			data.setDeinkwhitewaterchest3_10am(rs.getString("deinkwhitewaterchest3_10am"));
			data.setDeinkwhitewaterchest3_02pm(rs.getString("deinkwhitewaterchest3_02pm"));
			data.setDeinkwhitewaterchest3_06pm(rs.getString("deinkwhitewaterchest3_06pm"));
			data.setDeinkwhitewaterchest3_10pm(rs.getString("deinkwhitewaterchest3_10pm"));
			data.setDeinkwhitewaterchest3_02am(rs.getString("deinkwhitewaterchest3_02am"));
			data.setDeinkwhitewaterchest3_06am(rs.getString("deinkwhitewaterchest3_06am"));
			data.setDeinkwhitewaterchest4_freq(rs.getString("deinkwhitewaterchest4_freq"));
			data.setDeinkwhitewaterchest4_10am(rs.getString("deinkwhitewaterchest4_10am"));
			data.setDeinkwhitewaterchest4_02pm(rs.getString("deinkwhitewaterchest4_02pm"));
			data.setDeinkwhitewaterchest4_06pm(rs.getString("deinkwhitewaterchest4_06pm"));
			data.setDeinkwhitewaterchest4_10pm(rs.getString("deinkwhitewaterchest4_10pm"));
			data.setDeinkwhitewaterchest4_02am(rs.getString("deinkwhitewaterchest4_02am"));
			data.setDeinkwhitewaterchest4_06am(rs.getString("deinkwhitewaterchest4_06am"));
			data.setDeinkwhitewaterchest5_freq(rs.getString("deinkwhitewaterchest5_freq"));
			data.setDeinkwhitewaterchest5_10am(rs.getString("deinkwhitewaterchest5_10am"));
			data.setDeinkwhitewaterchest5_02pm(rs.getString("deinkwhitewaterchest5_02pm"));
			data.setDeinkwhitewaterchest5_06pm(rs.getString("deinkwhitewaterchest5_06pm"));
			data.setDeinkwhitewaterchest5_10pm(rs.getString("deinkwhitewaterchest5_10pm"));
			data.setDeinkwhitewaterchest5_02am(rs.getString("deinkwhitewaterchest5_02am"));
			data.setDeinkwhitewaterchest5_06am(rs.getString("deinkwhitewaterchest5_06am"));
			
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
			return oproute_4;
	}
	@Override
	public long getCountDatePercentage(String sdate,String edate) throws Exception {
		
		int _10am=0,_02pm=0,_06pm=0,_10pm=0,_02am=0,_06am=0;
		long _10ampercent=0,_02pmpercent=0,_06pmpercent=0,_10pmpercent=0,_02ampercent=0,_06ampercent=0;
	 	long percent=0;
		List<OpRoute_4> lst= getData(sdate,edate);
		for(OpRoute_4 data:lst)
		{
			if(data.getDumpchests1_10am()!=null&&!data.getDumpchests1_10am().equals("")){_10am++;}
			if(data.getDumpchests2_10am()!=null&&!data.getDumpchests2_10am().equals("")){_10am++;}
			if(data.getDumpchests3_10am()!=null&&!data.getDumpchests3_10am().equals("")){_10am++;}
			if(data.getDumpchests4_10am()!=null&&!data.getDumpchests4_10am().equals("")){_10am++;}
			if(data.getDumpchests5_10am()!=null&&!data.getDumpchests5_10am().equals("")){_10am++;}
			if(data.getContaminexpump1_10am()!=null&&!data.getContaminexpump1_10am().equals("")){_10am++;}
			if(data.getContaminexpump2_10am()!=null&&!data.getContaminexpump2_10am().equals("")){_10am++;}
			if(data.getContaminexpump3_10am()!=null&&!data.getContaminexpump3_10am().equals("")){_10am++;}
			if(data.getRejectscollectionbunker1_10am()!=null&&!data.getRejectscollectionbunker1_10am().equals("")){_10am++;}
			if(data.getRejectscollectionbunker2_10am()!=null&&!data.getRejectscollectionbunker2_10am().equals("")){_10am++;}
			if(data.getBatchpulperbasement1_10am()!=null&&!data.getBatchpulperbasement1_10am().equals("")){_10am++;}
			if(data.getBatchpulperbasement2_10am()!=null&&!data.getBatchpulperbasement2_10am().equals("")){_10am++;}
			if(data.getBatchpulperbasement3_10am()!=null&&!data.getBatchpulperbasement3_10am().equals("")){_10am++;}
			if(data.getBatchpulperbasement4_10am()!=null&&!data.getBatchpulperbasement4_10am().equals("")){_10am++;}
			if(data.getDetrasher1_10am()!=null&&!data.getDetrasher1_10am().equals("")){_10am++;}
			if(data.getDetrasher2_10am()!=null&&!data.getDetrasher2_10am().equals("")){_10am++;}
			if(data.getDetrasher3_10am()!=null&&!data.getDetrasher3_10am().equals("")){_10am++;}
			if(data.getRejectspress1_10am()!=null&&!data.getRejectspress1_10am().equals("")){_10am++;}
			if(data.getRejectspress2_10am()!=null&&!data.getRejectspress2_10am().equals("")){_10am++;}
			if(data.getRejectspress3_10am()!=null&&!data.getRejectspress3_10am().equals("")){_10am++;}
			if(data.getDewateringscrew1_10am()!=null&&!data.getDewateringscrew1_10am().equals("")){_10am++;}
			if(data.getDewateringscrew2_10am()!=null&&!data.getDewateringscrew2_10am().equals("")){_10am++;}
			if(data.getDewateringscrew3_10am()!=null&&!data.getDewateringscrew3_10am().equals("")){_10am++;}
			if(data.getClarifiedwaterchest1_10am()!=null&&!data.getClarifiedwaterchest1_10am().equals("")){_10am++;}
			if(data.getClarifiedwaterchest2_10am()!=null&&!data.getClarifiedwaterchest2_10am().equals("")){_10am++;}
			if(data.getDeinkwhitewaterchest1_10am()!=null&&!data.getDeinkwhitewaterchest1_10am().equals("")){_10am++;}
			if(data.getDeinkwhitewaterchest2_10am()!=null&&!data.getDeinkwhitewaterchest2_10am().equals("")){_10am++;}
			if(data.getDeinkwhitewaterchest3_10am()!=null&&!data.getDeinkwhitewaterchest3_10am().equals("")){_10am++;}
			if(data.getDeinkwhitewaterchest4_10am()!=null&&!data.getDeinkwhitewaterchest4_10am().equals("")){_10am++;}
			if(data.getDeinkwhitewaterchest5_10am()!=null&&!data.getDeinkwhitewaterchest5_10am().equals("")){_10am++;}

			if(data.getDumpchests1_02pm()!=null&&!data.getDumpchests1_02pm().equals("")){_02pm++;}
			if(data.getDumpchests2_02pm()!=null&&!data.getDumpchests2_02pm().equals("")){_02pm++;}
			if(data.getDumpchests3_02pm()!=null&&!data.getDumpchests3_02pm().equals("")){_02pm++;}
			if(data.getDumpchests4_02pm()!=null&&!data.getDumpchests4_02pm().equals("")){_02pm++;}
			if(data.getDumpchests5_02pm()!=null&&!data.getDumpchests5_02pm().equals("")){_02pm++;}
			if(data.getContaminexpump1_02pm()!=null&&!data.getContaminexpump1_02pm().equals("")){_02pm++;}
			if(data.getContaminexpump2_02pm()!=null&&!data.getContaminexpump2_02pm().equals("")){_02pm++;}
			if(data.getContaminexpump3_02pm()!=null&&!data.getContaminexpump3_02pm().equals("")){_02pm++;}
			if(data.getRejectscollectionbunker1_02pm()!=null&&!data.getRejectscollectionbunker1_02pm().equals("")){_02pm++;}
			if(data.getRejectscollectionbunker2_02pm()!=null&&!data.getRejectscollectionbunker2_02pm().equals("")){_02pm++;}
			if(data.getBatchpulperbasement1_02pm()!=null&&!data.getBatchpulperbasement1_02pm().equals("")){_02pm++;}
			if(data.getBatchpulperbasement2_02pm()!=null&&!data.getBatchpulperbasement2_02pm().equals("")){_02pm++;}
			if(data.getBatchpulperbasement3_02pm()!=null&&!data.getBatchpulperbasement3_02pm().equals("")){_02pm++;}
			if(data.getBatchpulperbasement4_02pm()!=null&&!data.getBatchpulperbasement4_02pm().equals("")){_02pm++;}
			if(data.getDetrasher1_02pm()!=null&&!data.getDetrasher1_02pm().equals("")){_02pm++;}
			if(data.getDetrasher2_02pm()!=null&&!data.getDetrasher2_02pm().equals("")){_02pm++;}
			if(data.getDetrasher3_02pm()!=null&&!data.getDetrasher3_02pm().equals("")){_02pm++;}
			if(data.getRejectspress1_02pm()!=null&&!data.getRejectspress1_02pm().equals("")){_02pm++;}
			if(data.getRejectspress2_02pm()!=null&&!data.getRejectspress2_02pm().equals("")){_02pm++;}
			if(data.getRejectspress3_02pm()!=null&&!data.getRejectspress3_02pm().equals("")){_02pm++;}
			if(data.getDewateringscrew1_02pm()!=null&&!data.getDewateringscrew1_02pm().equals("")){_02pm++;}
			if(data.getDewateringscrew2_02pm()!=null&&!data.getDewateringscrew2_02pm().equals("")){_02pm++;}
			if(data.getDewateringscrew3_02pm()!=null&&!data.getDewateringscrew3_02pm().equals("")){_02pm++;}
			if(data.getClarifiedwaterchest1_02pm()!=null&&!data.getClarifiedwaterchest1_02pm().equals("")){_02pm++;}
			if(data.getClarifiedwaterchest2_02pm()!=null&&!data.getClarifiedwaterchest2_02pm().equals("")){_02pm++;}
			if(data.getDeinkwhitewaterchest1_02pm()!=null&&!data.getDeinkwhitewaterchest1_02pm().equals("")){_02pm++;}
			if(data.getDeinkwhitewaterchest2_02pm()!=null&&!data.getDeinkwhitewaterchest2_02pm().equals("")){_02pm++;}
			if(data.getDeinkwhitewaterchest3_02pm()!=null&&!data.getDeinkwhitewaterchest3_02pm().equals("")){_02pm++;}
			if(data.getDeinkwhitewaterchest4_02pm()!=null&&!data.getDeinkwhitewaterchest4_02pm().equals("")){_02pm++;}
			if(data.getDeinkwhitewaterchest5_02pm()!=null&&!data.getDeinkwhitewaterchest5_02pm().equals("")){_02pm++;}

			if(data.getDumpchests1_06pm()!=null&&!data.getDumpchests1_06pm().equals("")){_06pm++;}
			if(data.getDumpchests2_06pm()!=null&&!data.getDumpchests2_06pm().equals("")){_06pm++;}
			if(data.getDumpchests3_06pm()!=null&&!data.getDumpchests3_06pm().equals("")){_06pm++;}
			if(data.getDumpchests4_06pm()!=null&&!data.getDumpchests4_06pm().equals("")){_06pm++;}
			if(data.getDumpchests5_06pm()!=null&&!data.getDumpchests5_06pm().equals("")){_06pm++;}
			if(data.getContaminexpump1_06pm()!=null&&!data.getContaminexpump1_06pm().equals("")){_06pm++;}
			if(data.getContaminexpump2_06pm()!=null&&!data.getContaminexpump2_06pm().equals("")){_06pm++;}
			if(data.getContaminexpump3_06pm()!=null&&!data.getContaminexpump3_06pm().equals("")){_06pm++;}
			if(data.getRejectscollectionbunker1_06pm()!=null&&!data.getRejectscollectionbunker1_06pm().equals("")){_06pm++;}
			if(data.getRejectscollectionbunker2_06pm()!=null&&!data.getRejectscollectionbunker2_06pm().equals("")){_06pm++;}
			if(data.getBatchpulperbasement1_06pm()!=null&&!data.getBatchpulperbasement1_06pm().equals("")){_06pm++;}
			if(data.getBatchpulperbasement2_06pm()!=null&&!data.getBatchpulperbasement2_06pm().equals("")){_06pm++;}
			if(data.getBatchpulperbasement3_06pm()!=null&&!data.getBatchpulperbasement3_06pm().equals("")){_06pm++;}
			if(data.getBatchpulperbasement4_06pm()!=null&&!data.getBatchpulperbasement4_06pm().equals("")){_06pm++;}
			if(data.getDetrasher1_06pm()!=null&&!data.getDetrasher1_06pm().equals("")){_06pm++;}
			if(data.getDetrasher2_06pm()!=null&&!data.getDetrasher2_06pm().equals("")){_06pm++;}
			if(data.getDetrasher3_06pm()!=null&&!data.getDetrasher3_06pm().equals("")){_06pm++;}
			if(data.getRejectspress1_06pm()!=null&&!data.getRejectspress1_06pm().equals("")){_06pm++;}
			if(data.getRejectspress2_06pm()!=null&&!data.getRejectspress2_06pm().equals("")){_06pm++;}
			if(data.getRejectspress3_06pm()!=null&&!data.getRejectspress3_06pm().equals("")){_06pm++;}
			if(data.getDewateringscrew1_06pm()!=null&&!data.getDewateringscrew1_06pm().equals("")){_06pm++;}
			if(data.getDewateringscrew2_06pm()!=null&&!data.getDewateringscrew2_06pm().equals("")){_06pm++;}
			if(data.getDewateringscrew3_06pm()!=null&&!data.getDewateringscrew3_06pm().equals("")){_06pm++;}
			if(data.getClarifiedwaterchest1_06pm()!=null&&!data.getClarifiedwaterchest1_06pm().equals("")){_06pm++;}
			if(data.getClarifiedwaterchest2_06pm()!=null&&!data.getClarifiedwaterchest2_06pm().equals("")){_06pm++;}
			if(data.getDeinkwhitewaterchest1_06pm()!=null&&!data.getDeinkwhitewaterchest1_06pm().equals("")){_06pm++;}
			if(data.getDeinkwhitewaterchest2_06pm()!=null&&!data.getDeinkwhitewaterchest2_06pm().equals("")){_06pm++;}
			if(data.getDeinkwhitewaterchest3_06pm()!=null&&!data.getDeinkwhitewaterchest3_06pm().equals("")){_06pm++;}
			if(data.getDeinkwhitewaterchest4_06pm()!=null&&!data.getDeinkwhitewaterchest4_06pm().equals("")){_06pm++;}
			if(data.getDeinkwhitewaterchest5_06pm()!=null&&!data.getDeinkwhitewaterchest5_06pm().equals("")){_06pm++;}

			if(data.getDumpchests1_10pm()!=null&&!data.getDumpchests1_10pm().equals("")){_10pm++;}
			if(data.getDumpchests2_10pm()!=null&&!data.getDumpchests2_10pm().equals("")){_10pm++;}
			if(data.getDumpchests3_10pm()!=null&&!data.getDumpchests3_10pm().equals("")){_10pm++;}
			if(data.getDumpchests4_10pm()!=null&&!data.getDumpchests4_10pm().equals("")){_10pm++;}
			if(data.getDumpchests5_10pm()!=null&&!data.getDumpchests5_10pm().equals("")){_10pm++;}
			if(data.getContaminexpump1_10pm()!=null&&!data.getContaminexpump1_10pm().equals("")){_10pm++;}
			if(data.getContaminexpump2_10pm()!=null&&!data.getContaminexpump2_10pm().equals("")){_10pm++;}
			if(data.getContaminexpump3_10pm()!=null&&!data.getContaminexpump3_10pm().equals("")){_10pm++;}
			if(data.getRejectscollectionbunker1_10pm()!=null&&!data.getRejectscollectionbunker1_10pm().equals("")){_10pm++;}
			if(data.getRejectscollectionbunker2_10pm()!=null&&!data.getRejectscollectionbunker2_10pm().equals("")){_10pm++;}
			if(data.getBatchpulperbasement1_10pm()!=null&&!data.getBatchpulperbasement1_10pm().equals("")){_10pm++;}
			if(data.getBatchpulperbasement2_10pm()!=null&&!data.getBatchpulperbasement2_10pm().equals("")){_10pm++;}
			if(data.getBatchpulperbasement3_10pm()!=null&&!data.getBatchpulperbasement3_10pm().equals("")){_10pm++;}
			if(data.getBatchpulperbasement4_10pm()!=null&&!data.getBatchpulperbasement4_10pm().equals("")){_10pm++;}
			if(data.getDetrasher1_10pm()!=null&&!data.getDetrasher1_10pm().equals("")){_10pm++;}
			if(data.getDetrasher2_10pm()!=null&&!data.getDetrasher2_10pm().equals("")){_10pm++;}
			if(data.getDetrasher3_10pm()!=null&&!data.getDetrasher3_10pm().equals("")){_10pm++;}
			if(data.getRejectspress1_10pm()!=null&&!data.getRejectspress1_10pm().equals("")){_10pm++;}
			if(data.getRejectspress2_10pm()!=null&&!data.getRejectspress2_10pm().equals("")){_10pm++;}
			if(data.getRejectspress3_10pm()!=null&&!data.getRejectspress3_10pm().equals("")){_10pm++;}
			if(data.getDewateringscrew1_10pm()!=null&&!data.getDewateringscrew1_10pm().equals("")){_10pm++;}
			if(data.getDewateringscrew2_10pm()!=null&&!data.getDewateringscrew2_10pm().equals("")){_10pm++;}
			if(data.getDewateringscrew3_10pm()!=null&&!data.getDewateringscrew3_10pm().equals("")){_10pm++;}
			if(data.getClarifiedwaterchest1_10pm()!=null&&!data.getClarifiedwaterchest1_10pm().equals("")){_10pm++;}
			if(data.getClarifiedwaterchest2_10pm()!=null&&!data.getClarifiedwaterchest2_10pm().equals("")){_10pm++;}
			if(data.getDeinkwhitewaterchest1_10pm()!=null&&!data.getDeinkwhitewaterchest1_10pm().equals("")){_10pm++;}
			if(data.getDeinkwhitewaterchest2_10pm()!=null&&!data.getDeinkwhitewaterchest2_10pm().equals("")){_10pm++;}
			if(data.getDeinkwhitewaterchest3_10pm()!=null&&!data.getDeinkwhitewaterchest3_10pm().equals("")){_10pm++;}
			if(data.getDeinkwhitewaterchest4_10pm()!=null&&!data.getDeinkwhitewaterchest4_10pm().equals("")){_10pm++;}
			if(data.getDeinkwhitewaterchest5_10pm()!=null&&!data.getDeinkwhitewaterchest5_10pm().equals("")){_10pm++;}

			if(data.getDumpchests1_02am()!=null&&!data.getDumpchests1_02am().equals("")){_02am++;}
			if(data.getDumpchests2_02am()!=null&&!data.getDumpchests2_02am().equals("")){_02am++;}
			if(data.getDumpchests3_02am()!=null&&!data.getDumpchests3_02am().equals("")){_02am++;}
			if(data.getDumpchests4_02am()!=null&&!data.getDumpchests4_02am().equals("")){_02am++;}
			if(data.getDumpchests5_02am()!=null&&!data.getDumpchests5_02am().equals("")){_02am++;}
			if(data.getContaminexpump1_02am()!=null&&!data.getContaminexpump1_02am().equals("")){_02am++;}
			if(data.getContaminexpump2_02am()!=null&&!data.getContaminexpump2_02am().equals("")){_02am++;}
			if(data.getContaminexpump3_02am()!=null&&!data.getContaminexpump3_02am().equals("")){_02am++;}
			if(data.getRejectscollectionbunker1_02am()!=null&&!data.getRejectscollectionbunker1_02am().equals("")){_02am++;}
			if(data.getRejectscollectionbunker2_02am()!=null&&!data.getRejectscollectionbunker2_02am().equals("")){_02am++;}
			if(data.getBatchpulperbasement1_02am()!=null&&!data.getBatchpulperbasement1_02am().equals("")){_02am++;}
			if(data.getBatchpulperbasement2_02am()!=null&&!data.getBatchpulperbasement2_02am().equals("")){_02am++;}
			if(data.getBatchpulperbasement3_02am()!=null&&!data.getBatchpulperbasement3_02am().equals("")){_02am++;}
			if(data.getBatchpulperbasement4_02am()!=null&&!data.getBatchpulperbasement4_02am().equals("")){_02am++;}
			if(data.getDetrasher1_02am()!=null&&!data.getDetrasher1_02am().equals("")){_02am++;}
			if(data.getDetrasher2_02am()!=null&&!data.getDetrasher2_02am().equals("")){_02am++;}
			if(data.getDetrasher3_02am()!=null&&!data.getDetrasher3_02am().equals("")){_02am++;}
			if(data.getRejectspress1_02am()!=null&&!data.getRejectspress1_02am().equals("")){_02am++;}
			if(data.getRejectspress2_02am()!=null&&!data.getRejectspress2_02am().equals("")){_02am++;}
			if(data.getRejectspress3_02am()!=null&&!data.getRejectspress3_02am().equals("")){_02am++;}
			if(data.getDewateringscrew1_02am()!=null&&!data.getDewateringscrew1_02am().equals("")){_02am++;}
			if(data.getDewateringscrew2_02am()!=null&&!data.getDewateringscrew2_02am().equals("")){_02am++;}
			if(data.getDewateringscrew3_02am()!=null&&!data.getDewateringscrew3_02am().equals("")){_02am++;}
			if(data.getClarifiedwaterchest1_02am()!=null&&!data.getClarifiedwaterchest1_02am().equals("")){_02am++;}
			if(data.getClarifiedwaterchest2_02am()!=null&&!data.getClarifiedwaterchest2_02am().equals("")){_02am++;}
			if(data.getDeinkwhitewaterchest1_02am()!=null&&!data.getDeinkwhitewaterchest1_02am().equals("")){_02am++;}
			if(data.getDeinkwhitewaterchest2_02am()!=null&&!data.getDeinkwhitewaterchest2_02am().equals("")){_02am++;}
			if(data.getDeinkwhitewaterchest3_02am()!=null&&!data.getDeinkwhitewaterchest3_02am().equals("")){_02am++;}
			if(data.getDeinkwhitewaterchest4_02am()!=null&&!data.getDeinkwhitewaterchest4_02am().equals("")){_02am++;}
			if(data.getDeinkwhitewaterchest5_02am()!=null&&!data.getDeinkwhitewaterchest5_02am().equals("")){_02am++;}

			if(data.getDumpchests1_06am()!=null&&!data.getDumpchests1_06am().equals("")){_06am++;}
			if(data.getDumpchests2_06am()!=null&&!data.getDumpchests2_06am().equals("")){_06am++;}
			if(data.getDumpchests3_06am()!=null&&!data.getDumpchests3_06am().equals("")){_06am++;}
			if(data.getDumpchests4_06am()!=null&&!data.getDumpchests4_06am().equals("")){_06am++;}
			if(data.getDumpchests5_06am()!=null&&!data.getDumpchests5_06am().equals("")){_06am++;}
			if(data.getContaminexpump1_06am()!=null&&!data.getContaminexpump1_06am().equals("")){_06am++;}
			if(data.getContaminexpump2_06am()!=null&&!data.getContaminexpump2_06am().equals("")){_06am++;}
			if(data.getContaminexpump3_06am()!=null&&!data.getContaminexpump3_06am().equals("")){_06am++;}
			if(data.getRejectscollectionbunker1_06am()!=null&&!data.getRejectscollectionbunker1_06am().equals("")){_06am++;}
			if(data.getRejectscollectionbunker2_06am()!=null&&!data.getRejectscollectionbunker2_06am().equals("")){_06am++;}
			if(data.getBatchpulperbasement1_06am()!=null&&!data.getBatchpulperbasement1_06am().equals("")){_06am++;}
			if(data.getBatchpulperbasement2_06am()!=null&&!data.getBatchpulperbasement2_06am().equals("")){_06am++;}
			if(data.getBatchpulperbasement3_06am()!=null&&!data.getBatchpulperbasement3_06am().equals("")){_06am++;}
			if(data.getBatchpulperbasement4_06am()!=null&&!data.getBatchpulperbasement4_06am().equals("")){_06am++;}
			if(data.getDetrasher1_06am()!=null&&!data.getDetrasher1_06am().equals("")){_06am++;}
			if(data.getDetrasher2_06am()!=null&&!data.getDetrasher2_06am().equals("")){_06am++;}
			if(data.getDetrasher3_06am()!=null&&!data.getDetrasher3_06am().equals("")){_06am++;}
			if(data.getRejectspress1_06am()!=null&&!data.getRejectspress1_06am().equals("")){_06am++;}
			if(data.getRejectspress2_06am()!=null&&!data.getRejectspress2_06am().equals("")){_06am++;}
			if(data.getRejectspress3_06am()!=null&&!data.getRejectspress3_06am().equals("")){_06am++;}
			if(data.getDewateringscrew1_06am()!=null&&!data.getDewateringscrew1_06am().equals("")){_06am++;}
			if(data.getDewateringscrew2_06am()!=null&&!data.getDewateringscrew2_06am().equals("")){_06am++;}
			if(data.getDewateringscrew3_06am()!=null&&!data.getDewateringscrew3_06am().equals("")){_06am++;}
			if(data.getClarifiedwaterchest1_06am()!=null&&!data.getClarifiedwaterchest1_06am().equals("")){_06am++;}
			if(data.getClarifiedwaterchest2_06am()!=null&&!data.getClarifiedwaterchest2_06am().equals("")){_06am++;}
			if(data.getDeinkwhitewaterchest1_06am()!=null&&!data.getDeinkwhitewaterchest1_06am().equals("")){_06am++;}
			if(data.getDeinkwhitewaterchest2_06am()!=null&&!data.getDeinkwhitewaterchest2_06am().equals("")){_06am++;}
			if(data.getDeinkwhitewaterchest3_06am()!=null&&!data.getDeinkwhitewaterchest3_06am().equals("")){_06am++;}
			if(data.getDeinkwhitewaterchest4_06am()!=null&&!data.getDeinkwhitewaterchest4_06am().equals("")){_06am++;}
			if(data.getDeinkwhitewaterchest5_06am()!=null&&!data.getDeinkwhitewaterchest5_06am().equals("")){_06am++;}

			if(_10am>=5){_10ampercent=100;}
			if(_02pm>=5){_02pmpercent=100;}
			if(_06pm>=5){_06pmpercent=100;}
			if(_10pm>=5){_10pmpercent=100;}
			if(_02am>=5){_02ampercent=100;}
			if(_06am>=5){_06ampercent=100;}
			if(data.getCmt9amarea()!=null&&!data.getCmt9amarea().equals(""))
			{_10ampercent=100;}
			if(data.getCmt1pmarea()!=null&&!data.getCmt1pmarea().equals(""))
			{_02pmpercent=100;}			
			if(data.getCmt5pmarea()!=null&&!data.getCmt5pmarea().equals(""))
			{_06pmpercent=100;}
			if(data.getCmt9pmarea()!=null&&!data.getCmt9pmarea().equals(""))
			{_10pmpercent=100;}
			if(data.getCmt1amarea()!=null&&!data.getCmt1amarea().equals(""))
			{_02ampercent=100;}
			if(data.getCmt5amarea()!=null&&!data.getCmt5amarea().equals(""))
			{_06ampercent=100;}
			percent=(_10ampercent+_02pmpercent+_06pmpercent+_10pmpercent+_02ampercent+_06ampercent)/6;
			_10am=0;_02pm=0;_06pm=0;_10pm=0;_02am=0;_06am=0;
		}
		return percent;
	}
	@Override
	public List<Integer> getCount(String sdate,String edate) throws Exception {
		
		int count=0, _10am=0,_02pm=0,_06pm=0,_10pm=0,_02am=0,_06am=0;
		List<Integer> al=new ArrayList<Integer>();
		List<OpRoute_4> lst= getData(sdate,edate);
		for(OpRoute_4 data:lst)
		{
			if(data.getDumpchests1_10am()!=null&&!data.getDumpchests1_10am().equals("")){_10am++;}
			if(data.getDumpchests2_10am()!=null&&!data.getDumpchests2_10am().equals("")){_10am++;}
			if(data.getDumpchests3_10am()!=null&&!data.getDumpchests3_10am().equals("")){_10am++;}
			if(data.getDumpchests4_10am()!=null&&!data.getDumpchests4_10am().equals("")){_10am++;}
			if(data.getDumpchests5_10am()!=null&&!data.getDumpchests5_10am().equals("")){_10am++;}
			if(data.getContaminexpump1_10am()!=null&&!data.getContaminexpump1_10am().equals("")){_10am++;}
			if(data.getContaminexpump2_10am()!=null&&!data.getContaminexpump2_10am().equals("")){_10am++;}
			if(data.getContaminexpump3_10am()!=null&&!data.getContaminexpump3_10am().equals("")){_10am++;}
			if(data.getRejectscollectionbunker1_10am()!=null&&!data.getRejectscollectionbunker1_10am().equals("")){_10am++;}
			if(data.getRejectscollectionbunker2_10am()!=null&&!data.getRejectscollectionbunker2_10am().equals("")){_10am++;}
			if(data.getBatchpulperbasement1_10am()!=null&&!data.getBatchpulperbasement1_10am().equals("")){_10am++;}
			if(data.getBatchpulperbasement2_10am()!=null&&!data.getBatchpulperbasement2_10am().equals("")){_10am++;}
			if(data.getBatchpulperbasement3_10am()!=null&&!data.getBatchpulperbasement3_10am().equals("")){_10am++;}
			if(data.getBatchpulperbasement4_10am()!=null&&!data.getBatchpulperbasement4_10am().equals("")){_10am++;}
			if(data.getDetrasher1_10am()!=null&&!data.getDetrasher1_10am().equals("")){_10am++;}
			if(data.getDetrasher2_10am()!=null&&!data.getDetrasher2_10am().equals("")){_10am++;}
			if(data.getDetrasher3_10am()!=null&&!data.getDetrasher3_10am().equals("")){_10am++;}
			if(data.getRejectspress1_10am()!=null&&!data.getRejectspress1_10am().equals("")){_10am++;}
			if(data.getRejectspress2_10am()!=null&&!data.getRejectspress2_10am().equals("")){_10am++;}
			if(data.getRejectspress3_10am()!=null&&!data.getRejectspress3_10am().equals("")){_10am++;}
			if(data.getDewateringscrew1_10am()!=null&&!data.getDewateringscrew1_10am().equals("")){_10am++;}
			if(data.getDewateringscrew2_10am()!=null&&!data.getDewateringscrew2_10am().equals("")){_10am++;}
			if(data.getDewateringscrew3_10am()!=null&&!data.getDewateringscrew3_10am().equals("")){_10am++;}
			if(data.getClarifiedwaterchest1_10am()!=null&&!data.getClarifiedwaterchest1_10am().equals("")){_10am++;}
			if(data.getClarifiedwaterchest2_10am()!=null&&!data.getClarifiedwaterchest2_10am().equals("")){_10am++;}
			if(data.getDeinkwhitewaterchest1_10am()!=null&&!data.getDeinkwhitewaterchest1_10am().equals("")){_10am++;}
			if(data.getDeinkwhitewaterchest2_10am()!=null&&!data.getDeinkwhitewaterchest2_10am().equals("")){_10am++;}
			if(data.getDeinkwhitewaterchest3_10am()!=null&&!data.getDeinkwhitewaterchest3_10am().equals("")){_10am++;}
			if(data.getDeinkwhitewaterchest4_10am()!=null&&!data.getDeinkwhitewaterchest4_10am().equals("")){_10am++;}
			if(data.getDeinkwhitewaterchest5_10am()!=null&&!data.getDeinkwhitewaterchest5_10am().equals("")){_10am++;}

			if(data.getDumpchests1_02pm()!=null&&!data.getDumpchests1_02pm().equals("")){_02pm++;}
			if(data.getDumpchests2_02pm()!=null&&!data.getDumpchests2_02pm().equals("")){_02pm++;}
			if(data.getDumpchests3_02pm()!=null&&!data.getDumpchests3_02pm().equals("")){_02pm++;}
			if(data.getDumpchests4_02pm()!=null&&!data.getDumpchests4_02pm().equals("")){_02pm++;}
			if(data.getDumpchests5_02pm()!=null&&!data.getDumpchests5_02pm().equals("")){_02pm++;}
			if(data.getContaminexpump1_02pm()!=null&&!data.getContaminexpump1_02pm().equals("")){_02pm++;}
			if(data.getContaminexpump2_02pm()!=null&&!data.getContaminexpump2_02pm().equals("")){_02pm++;}
			if(data.getContaminexpump3_02pm()!=null&&!data.getContaminexpump3_02pm().equals("")){_02pm++;}
			if(data.getRejectscollectionbunker1_02pm()!=null&&!data.getRejectscollectionbunker1_02pm().equals("")){_02pm++;}
			if(data.getRejectscollectionbunker2_02pm()!=null&&!data.getRejectscollectionbunker2_02pm().equals("")){_02pm++;}
			if(data.getBatchpulperbasement1_02pm()!=null&&!data.getBatchpulperbasement1_02pm().equals("")){_02pm++;}
			if(data.getBatchpulperbasement2_02pm()!=null&&!data.getBatchpulperbasement2_02pm().equals("")){_02pm++;}
			if(data.getBatchpulperbasement3_02pm()!=null&&!data.getBatchpulperbasement3_02pm().equals("")){_02pm++;}
			if(data.getBatchpulperbasement4_02pm()!=null&&!data.getBatchpulperbasement4_02pm().equals("")){_02pm++;}
			if(data.getDetrasher1_02pm()!=null&&!data.getDetrasher1_02pm().equals("")){_02pm++;}
			if(data.getDetrasher2_02pm()!=null&&!data.getDetrasher2_02pm().equals("")){_02pm++;}
			if(data.getDetrasher3_02pm()!=null&&!data.getDetrasher3_02pm().equals("")){_02pm++;}
			if(data.getRejectspress1_02pm()!=null&&!data.getRejectspress1_02pm().equals("")){_02pm++;}
			if(data.getRejectspress2_02pm()!=null&&!data.getRejectspress2_02pm().equals("")){_02pm++;}
			if(data.getRejectspress3_02pm()!=null&&!data.getRejectspress3_02pm().equals("")){_02pm++;}
			if(data.getDewateringscrew1_02pm()!=null&&!data.getDewateringscrew1_02pm().equals("")){_02pm++;}
			if(data.getDewateringscrew2_02pm()!=null&&!data.getDewateringscrew2_02pm().equals("")){_02pm++;}
			if(data.getDewateringscrew3_02pm()!=null&&!data.getDewateringscrew3_02pm().equals("")){_02pm++;}
			if(data.getClarifiedwaterchest1_02pm()!=null&&!data.getClarifiedwaterchest1_02pm().equals("")){_02pm++;}
			if(data.getClarifiedwaterchest2_02pm()!=null&&!data.getClarifiedwaterchest2_02pm().equals("")){_02pm++;}
			if(data.getDeinkwhitewaterchest1_02pm()!=null&&!data.getDeinkwhitewaterchest1_02pm().equals("")){_02pm++;}
			if(data.getDeinkwhitewaterchest2_02pm()!=null&&!data.getDeinkwhitewaterchest2_02pm().equals("")){_02pm++;}
			if(data.getDeinkwhitewaterchest3_02pm()!=null&&!data.getDeinkwhitewaterchest3_02pm().equals("")){_02pm++;}
			if(data.getDeinkwhitewaterchest4_02pm()!=null&&!data.getDeinkwhitewaterchest4_02pm().equals("")){_02pm++;}
			if(data.getDeinkwhitewaterchest5_02pm()!=null&&!data.getDeinkwhitewaterchest5_02pm().equals("")){_02pm++;}

			if(data.getDumpchests1_06pm()!=null&&!data.getDumpchests1_06pm().equals("")){_06pm++;}
			if(data.getDumpchests2_06pm()!=null&&!data.getDumpchests2_06pm().equals("")){_06pm++;}
			if(data.getDumpchests3_06pm()!=null&&!data.getDumpchests3_06pm().equals("")){_06pm++;}
			if(data.getDumpchests4_06pm()!=null&&!data.getDumpchests4_06pm().equals("")){_06pm++;}
			if(data.getDumpchests5_06pm()!=null&&!data.getDumpchests5_06pm().equals("")){_06pm++;}
			if(data.getContaminexpump1_06pm()!=null&&!data.getContaminexpump1_06pm().equals("")){_06pm++;}
			if(data.getContaminexpump2_06pm()!=null&&!data.getContaminexpump2_06pm().equals("")){_06pm++;}
			if(data.getContaminexpump3_06pm()!=null&&!data.getContaminexpump3_06pm().equals("")){_06pm++;}
			if(data.getRejectscollectionbunker1_06pm()!=null&&!data.getRejectscollectionbunker1_06pm().equals("")){_06pm++;}
			if(data.getRejectscollectionbunker2_06pm()!=null&&!data.getRejectscollectionbunker2_06pm().equals("")){_06pm++;}
			if(data.getBatchpulperbasement1_06pm()!=null&&!data.getBatchpulperbasement1_06pm().equals("")){_06pm++;}
			if(data.getBatchpulperbasement2_06pm()!=null&&!data.getBatchpulperbasement2_06pm().equals("")){_06pm++;}
			if(data.getBatchpulperbasement3_06pm()!=null&&!data.getBatchpulperbasement3_06pm().equals("")){_06pm++;}
			if(data.getBatchpulperbasement4_06pm()!=null&&!data.getBatchpulperbasement4_06pm().equals("")){_06pm++;}
			if(data.getDetrasher1_06pm()!=null&&!data.getDetrasher1_06pm().equals("")){_06pm++;}
			if(data.getDetrasher2_06pm()!=null&&!data.getDetrasher2_06pm().equals("")){_06pm++;}
			if(data.getDetrasher3_06pm()!=null&&!data.getDetrasher3_06pm().equals("")){_06pm++;}
			if(data.getRejectspress1_06pm()!=null&&!data.getRejectspress1_06pm().equals("")){_06pm++;}
			if(data.getRejectspress2_06pm()!=null&&!data.getRejectspress2_06pm().equals("")){_06pm++;}
			if(data.getRejectspress3_06pm()!=null&&!data.getRejectspress3_06pm().equals("")){_06pm++;}
			if(data.getDewateringscrew1_06pm()!=null&&!data.getDewateringscrew1_06pm().equals("")){_06pm++;}
			if(data.getDewateringscrew2_06pm()!=null&&!data.getDewateringscrew2_06pm().equals("")){_06pm++;}
			if(data.getDewateringscrew3_06pm()!=null&&!data.getDewateringscrew3_06pm().equals("")){_06pm++;}
			if(data.getClarifiedwaterchest1_06pm()!=null&&!data.getClarifiedwaterchest1_06pm().equals("")){_06pm++;}
			if(data.getClarifiedwaterchest2_06pm()!=null&&!data.getClarifiedwaterchest2_06pm().equals("")){_06pm++;}
			if(data.getDeinkwhitewaterchest1_06pm()!=null&&!data.getDeinkwhitewaterchest1_06pm().equals("")){_06pm++;}
			if(data.getDeinkwhitewaterchest2_06pm()!=null&&!data.getDeinkwhitewaterchest2_06pm().equals("")){_06pm++;}
			if(data.getDeinkwhitewaterchest3_06pm()!=null&&!data.getDeinkwhitewaterchest3_06pm().equals("")){_06pm++;}
			if(data.getDeinkwhitewaterchest4_06pm()!=null&&!data.getDeinkwhitewaterchest4_06pm().equals("")){_06pm++;}
			if(data.getDeinkwhitewaterchest5_06pm()!=null&&!data.getDeinkwhitewaterchest5_06pm().equals("")){_06pm++;}

			if(data.getDumpchests1_10pm()!=null&&!data.getDumpchests1_10pm().equals("")){_10pm++;}
			if(data.getDumpchests2_10pm()!=null&&!data.getDumpchests2_10pm().equals("")){_10pm++;}
			if(data.getDumpchests3_10pm()!=null&&!data.getDumpchests3_10pm().equals("")){_10pm++;}
			if(data.getDumpchests4_10pm()!=null&&!data.getDumpchests4_10pm().equals("")){_10pm++;}
			if(data.getDumpchests5_10pm()!=null&&!data.getDumpchests5_10pm().equals("")){_10pm++;}
			if(data.getContaminexpump1_10pm()!=null&&!data.getContaminexpump1_10pm().equals("")){_10pm++;}
			if(data.getContaminexpump2_10pm()!=null&&!data.getContaminexpump2_10pm().equals("")){_10pm++;}
			if(data.getContaminexpump3_10pm()!=null&&!data.getContaminexpump3_10pm().equals("")){_10pm++;}
			if(data.getRejectscollectionbunker1_10pm()!=null&&!data.getRejectscollectionbunker1_10pm().equals("")){_10pm++;}
			if(data.getRejectscollectionbunker2_10pm()!=null&&!data.getRejectscollectionbunker2_10pm().equals("")){_10pm++;}
			if(data.getBatchpulperbasement1_10pm()!=null&&!data.getBatchpulperbasement1_10pm().equals("")){_10pm++;}
			if(data.getBatchpulperbasement2_10pm()!=null&&!data.getBatchpulperbasement2_10pm().equals("")){_10pm++;}
			if(data.getBatchpulperbasement3_10pm()!=null&&!data.getBatchpulperbasement3_10pm().equals("")){_10pm++;}
			if(data.getBatchpulperbasement4_10pm()!=null&&!data.getBatchpulperbasement4_10pm().equals("")){_10pm++;}
			if(data.getDetrasher1_10pm()!=null&&!data.getDetrasher1_10pm().equals("")){_10pm++;}
			if(data.getDetrasher2_10pm()!=null&&!data.getDetrasher2_10pm().equals("")){_10pm++;}
			if(data.getDetrasher3_10pm()!=null&&!data.getDetrasher3_10pm().equals("")){_10pm++;}
			if(data.getRejectspress1_10pm()!=null&&!data.getRejectspress1_10pm().equals("")){_10pm++;}
			if(data.getRejectspress2_10pm()!=null&&!data.getRejectspress2_10pm().equals("")){_10pm++;}
			if(data.getRejectspress3_10pm()!=null&&!data.getRejectspress3_10pm().equals("")){_10pm++;}
			if(data.getDewateringscrew1_10pm()!=null&&!data.getDewateringscrew1_10pm().equals("")){_10pm++;}
			if(data.getDewateringscrew2_10pm()!=null&&!data.getDewateringscrew2_10pm().equals("")){_10pm++;}
			if(data.getDewateringscrew3_10pm()!=null&&!data.getDewateringscrew3_10pm().equals("")){_10pm++;}
			if(data.getClarifiedwaterchest1_10pm()!=null&&!data.getClarifiedwaterchest1_10pm().equals("")){_10pm++;}
			if(data.getClarifiedwaterchest2_10pm()!=null&&!data.getClarifiedwaterchest2_10pm().equals("")){_10pm++;}
			if(data.getDeinkwhitewaterchest1_10pm()!=null&&!data.getDeinkwhitewaterchest1_10pm().equals("")){_10pm++;}
			if(data.getDeinkwhitewaterchest2_10pm()!=null&&!data.getDeinkwhitewaterchest2_10pm().equals("")){_10pm++;}
			if(data.getDeinkwhitewaterchest3_10pm()!=null&&!data.getDeinkwhitewaterchest3_10pm().equals("")){_10pm++;}
			if(data.getDeinkwhitewaterchest4_10pm()!=null&&!data.getDeinkwhitewaterchest4_10pm().equals("")){_10pm++;}
			if(data.getDeinkwhitewaterchest5_10pm()!=null&&!data.getDeinkwhitewaterchest5_10pm().equals("")){_10pm++;}

			if(data.getDumpchests1_02am()!=null&&!data.getDumpchests1_02am().equals("")){_02am++;}
			if(data.getDumpchests2_02am()!=null&&!data.getDumpchests2_02am().equals("")){_02am++;}
			if(data.getDumpchests3_02am()!=null&&!data.getDumpchests3_02am().equals("")){_02am++;}
			if(data.getDumpchests4_02am()!=null&&!data.getDumpchests4_02am().equals("")){_02am++;}
			if(data.getDumpchests5_02am()!=null&&!data.getDumpchests5_02am().equals("")){_02am++;}
			if(data.getContaminexpump1_02am()!=null&&!data.getContaminexpump1_02am().equals("")){_02am++;}
			if(data.getContaminexpump2_02am()!=null&&!data.getContaminexpump2_02am().equals("")){_02am++;}
			if(data.getContaminexpump3_02am()!=null&&!data.getContaminexpump3_02am().equals("")){_02am++;}
			if(data.getRejectscollectionbunker1_02am()!=null&&!data.getRejectscollectionbunker1_02am().equals("")){_02am++;}
			if(data.getRejectscollectionbunker2_02am()!=null&&!data.getRejectscollectionbunker2_02am().equals("")){_02am++;}
			if(data.getBatchpulperbasement1_02am()!=null&&!data.getBatchpulperbasement1_02am().equals("")){_02am++;}
			if(data.getBatchpulperbasement2_02am()!=null&&!data.getBatchpulperbasement2_02am().equals("")){_02am++;}
			if(data.getBatchpulperbasement3_02am()!=null&&!data.getBatchpulperbasement3_02am().equals("")){_02am++;}
			if(data.getBatchpulperbasement4_02am()!=null&&!data.getBatchpulperbasement4_02am().equals("")){_02am++;}
			if(data.getDetrasher1_02am()!=null&&!data.getDetrasher1_02am().equals("")){_02am++;}
			if(data.getDetrasher2_02am()!=null&&!data.getDetrasher2_02am().equals("")){_02am++;}
			if(data.getDetrasher3_02am()!=null&&!data.getDetrasher3_02am().equals("")){_02am++;}
			if(data.getRejectspress1_02am()!=null&&!data.getRejectspress1_02am().equals("")){_02am++;}
			if(data.getRejectspress2_02am()!=null&&!data.getRejectspress2_02am().equals("")){_02am++;}
			if(data.getRejectspress3_02am()!=null&&!data.getRejectspress3_02am().equals("")){_02am++;}
			if(data.getDewateringscrew1_02am()!=null&&!data.getDewateringscrew1_02am().equals("")){_02am++;}
			if(data.getDewateringscrew2_02am()!=null&&!data.getDewateringscrew2_02am().equals("")){_02am++;}
			if(data.getDewateringscrew3_02am()!=null&&!data.getDewateringscrew3_02am().equals("")){_02am++;}
			if(data.getClarifiedwaterchest1_02am()!=null&&!data.getClarifiedwaterchest1_02am().equals("")){_02am++;}
			if(data.getClarifiedwaterchest2_02am()!=null&&!data.getClarifiedwaterchest2_02am().equals("")){_02am++;}
			if(data.getDeinkwhitewaterchest1_02am()!=null&&!data.getDeinkwhitewaterchest1_02am().equals("")){_02am++;}
			if(data.getDeinkwhitewaterchest2_02am()!=null&&!data.getDeinkwhitewaterchest2_02am().equals("")){_02am++;}
			if(data.getDeinkwhitewaterchest3_02am()!=null&&!data.getDeinkwhitewaterchest3_02am().equals("")){_02am++;}
			if(data.getDeinkwhitewaterchest4_02am()!=null&&!data.getDeinkwhitewaterchest4_02am().equals("")){_02am++;}
			if(data.getDeinkwhitewaterchest5_02am()!=null&&!data.getDeinkwhitewaterchest5_02am().equals("")){_02am++;}

			if(data.getDumpchests1_06am()!=null&&!data.getDumpchests1_06am().equals("")){_06am++;}
			if(data.getDumpchests2_06am()!=null&&!data.getDumpchests2_06am().equals("")){_06am++;}
			if(data.getDumpchests3_06am()!=null&&!data.getDumpchests3_06am().equals("")){_06am++;}
			if(data.getDumpchests4_06am()!=null&&!data.getDumpchests4_06am().equals("")){_06am++;}
			if(data.getDumpchests5_06am()!=null&&!data.getDumpchests5_06am().equals("")){_06am++;}
			if(data.getContaminexpump1_06am()!=null&&!data.getContaminexpump1_06am().equals("")){_06am++;}
			if(data.getContaminexpump2_06am()!=null&&!data.getContaminexpump2_06am().equals("")){_06am++;}
			if(data.getContaminexpump3_06am()!=null&&!data.getContaminexpump3_06am().equals("")){_06am++;}
			if(data.getRejectscollectionbunker1_06am()!=null&&!data.getRejectscollectionbunker1_06am().equals("")){_06am++;}
			if(data.getRejectscollectionbunker2_06am()!=null&&!data.getRejectscollectionbunker2_06am().equals("")){_06am++;}
			if(data.getBatchpulperbasement1_06am()!=null&&!data.getBatchpulperbasement1_06am().equals("")){_06am++;}
			if(data.getBatchpulperbasement2_06am()!=null&&!data.getBatchpulperbasement2_06am().equals("")){_06am++;}
			if(data.getBatchpulperbasement3_06am()!=null&&!data.getBatchpulperbasement3_06am().equals("")){_06am++;}
			if(data.getBatchpulperbasement4_06am()!=null&&!data.getBatchpulperbasement4_06am().equals("")){_06am++;}
			if(data.getDetrasher1_06am()!=null&&!data.getDetrasher1_06am().equals("")){_06am++;}
			if(data.getDetrasher2_06am()!=null&&!data.getDetrasher2_06am().equals("")){_06am++;}
			if(data.getDetrasher3_06am()!=null&&!data.getDetrasher3_06am().equals("")){_06am++;}
			if(data.getRejectspress1_06am()!=null&&!data.getRejectspress1_06am().equals("")){_06am++;}
			if(data.getRejectspress2_06am()!=null&&!data.getRejectspress2_06am().equals("")){_06am++;}
			if(data.getRejectspress3_06am()!=null&&!data.getRejectspress3_06am().equals("")){_06am++;}
			if(data.getDewateringscrew1_06am()!=null&&!data.getDewateringscrew1_06am().equals("")){_06am++;}
			if(data.getDewateringscrew2_06am()!=null&&!data.getDewateringscrew2_06am().equals("")){_06am++;}
			if(data.getDewateringscrew3_06am()!=null&&!data.getDewateringscrew3_06am().equals("")){_06am++;}
			if(data.getClarifiedwaterchest1_06am()!=null&&!data.getClarifiedwaterchest1_06am().equals("")){_06am++;}
			if(data.getClarifiedwaterchest2_06am()!=null&&!data.getClarifiedwaterchest2_06am().equals("")){_06am++;}
			if(data.getDeinkwhitewaterchest1_06am()!=null&&!data.getDeinkwhitewaterchest1_06am().equals("")){_06am++;}
			if(data.getDeinkwhitewaterchest2_06am()!=null&&!data.getDeinkwhitewaterchest2_06am().equals("")){_06am++;}
			if(data.getDeinkwhitewaterchest3_06am()!=null&&!data.getDeinkwhitewaterchest3_06am().equals("")){_06am++;}
			if(data.getDeinkwhitewaterchest4_06am()!=null&&!data.getDeinkwhitewaterchest4_06am().equals("")){_06am++;}
			if(data.getDeinkwhitewaterchest5_06am()!=null&&!data.getDeinkwhitewaterchest5_06am().equals("")){_06am++;}

			if(_10am>=5){count++;}
			if(_02pm>=5){count++;}
			if(_06pm>=5){count++;}
			if(_10pm>=5){count++;}
			if(_02am>=5){count++;}
			if(_06am>=5){count++;}
			al.add(count);
			count=0;_10am=0;_02pm=0;_06pm=0;_10pm=0;_02am=0;_06am=0;
		}
		return al;
	}
}

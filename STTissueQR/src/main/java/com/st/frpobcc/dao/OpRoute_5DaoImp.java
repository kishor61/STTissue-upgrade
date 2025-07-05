/**
 *03-Dec-2019
 *OpRoute_DaoImp.java
 * TODO
 *com.st.frpobcc.dao
 *OpRoute_5DaoImp.java
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
import com.st.frpobcc.model.OpRoute_5;

/**
 * @author sohan
 *
 */
@Repository
public class OpRoute_5DaoImp implements OpRoute_5Dao {
	
	@Autowired
	@Qualifier("dataSourceOBCC")
	private DataSource dataSourceQRT;
	/* (non-Javadoc)
	 * @see com.st.frpobcc.dao.OpRoute_1Dao#saveorUpdate(com.st.frpobcc.model.OpRoute_1)
	 */
	@Override
	public void saveorUpdate(OpRoute_5 data) {
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
		paramSource.addValue("visualcheckofudrainsforstock1_freq",data.getVisualcheckofudrainsforstock1_freq());
		paramSource.addValue("visualcheckofudrainsforstock1_10am",data.getVisualcheckofudrainsforstock1_10am());
		paramSource.addValue("visualcheckofudrainsforstock1_02pm",data.getVisualcheckofudrainsforstock1_02pm());
		paramSource.addValue("visualcheckofudrainsforstock1_06pm",data.getVisualcheckofudrainsforstock1_06pm());
		paramSource.addValue("visualcheckofudrainsforstock1_10pm",data.getVisualcheckofudrainsforstock1_10pm());
		paramSource.addValue("visualcheckofudrainsforstock1_02am",data.getVisualcheckofudrainsforstock1_02am());
		paramSource.addValue("visualcheckofudrainsforstock1_06am",data.getVisualcheckofudrainsforstock1_06am());
		paramSource.addValue("visualcheckofudrainsforstock2_freq",data.getVisualcheckofudrainsforstock2_freq());
		paramSource.addValue("visualcheckofudrainsforstock2_10am",data.getVisualcheckofudrainsforstock2_10am());
		paramSource.addValue("visualcheckofudrainsforstock2_02pm",data.getVisualcheckofudrainsforstock2_02pm());
		paramSource.addValue("visualcheckofudrainsforstock2_06pm",data.getVisualcheckofudrainsforstock2_06pm());
		paramSource.addValue("visualcheckofudrainsforstock2_10pm",data.getVisualcheckofudrainsforstock2_10pm());
		paramSource.addValue("visualcheckofudrainsforstock2_02am",data.getVisualcheckofudrainsforstock2_02am());
		paramSource.addValue("visualcheckofudrainsforstock2_06am",data.getVisualcheckofudrainsforstock2_06am());
		paramSource.addValue("visualcheckofudrainsforstock3_freq",data.getVisualcheckofudrainsforstock3_freq());
		paramSource.addValue("visualcheckofudrainsforstock3_10am",data.getVisualcheckofudrainsforstock3_10am());
		paramSource.addValue("visualcheckofudrainsforstock3_02pm",data.getVisualcheckofudrainsforstock3_02pm());
		paramSource.addValue("visualcheckofudrainsforstock3_06pm",data.getVisualcheckofudrainsforstock3_06pm());
		paramSource.addValue("visualcheckofudrainsforstock3_10pm",data.getVisualcheckofudrainsforstock3_10pm());
		paramSource.addValue("visualcheckofudrainsforstock3_02am",data.getVisualcheckofudrainsforstock3_02am());
		paramSource.addValue("visualcheckofudrainsforstock3_06am",data.getVisualcheckofudrainsforstock3_06am());
		paramSource.addValue("visualcheckofudrainsforstock4_freq",data.getVisualcheckofudrainsforstock4_freq());
		paramSource.addValue("visualcheckofudrainsforstock4_10am",data.getVisualcheckofudrainsforstock4_10am());
		paramSource.addValue("visualcheckofudrainsforstock4_02pm",data.getVisualcheckofudrainsforstock4_02pm());
		paramSource.addValue("visualcheckofudrainsforstock4_06pm",data.getVisualcheckofudrainsforstock4_06pm());
		paramSource.addValue("visualcheckofudrainsforstock4_10pm",data.getVisualcheckofudrainsforstock4_10pm());
		paramSource.addValue("visualcheckofudrainsforstock4_02am",data.getVisualcheckofudrainsforstock4_02am());
		paramSource.addValue("visualcheckofudrainsforstock4_06am",data.getVisualcheckofudrainsforstock4_06am());	
		paramSource.addValue("visualcheckofudrainsforstock5_freq",data.getVisualcheckofudrainsforstock5_freq());
		paramSource.addValue("visualcheckofudrainsforstock5_10am",data.getVisualcheckofudrainsforstock5_10am());
		paramSource.addValue("visualcheckofudrainsforstock5_02pm",data.getVisualcheckofudrainsforstock5_02pm());
		paramSource.addValue("visualcheckofudrainsforstock5_06pm",data.getVisualcheckofudrainsforstock5_06pm());
		paramSource.addValue("visualcheckofudrainsforstock5_10pm",data.getVisualcheckofudrainsforstock5_10pm());
		paramSource.addValue("visualcheckofudrainsforstock5_02am",data.getVisualcheckofudrainsforstock5_02am());
		paramSource.addValue("visualcheckofudrainsforstock5_06am",data.getVisualcheckofudrainsforstock5_06am());
		paramSource.addValue("visualcheckofudrainsforstock6_freq",data.getVisualcheckofudrainsforstock6_freq());
		paramSource.addValue("visualcheckofudrainsforstock6_10am",data.getVisualcheckofudrainsforstock6_10am());
		paramSource.addValue("visualcheckofudrainsforstock6_02pm",data.getVisualcheckofudrainsforstock6_02pm());
		paramSource.addValue("visualcheckofudrainsforstock6_06pm",data.getVisualcheckofudrainsforstock6_06pm());
		paramSource.addValue("visualcheckofudrainsforstock6_10pm",data.getVisualcheckofudrainsforstock6_10pm());
		paramSource.addValue("visualcheckofudrainsforstock6_02am",data.getVisualcheckofudrainsforstock6_02am());
		paramSource.addValue("visualcheckofudrainsforstock6_06am",data.getVisualcheckofudrainsforstock6_06am());
		paramSource.addValue("visualcheckofudrainsforstock7_freq",data.getVisualcheckofudrainsforstock7_freq());
		paramSource.addValue("visualcheckofudrainsforstock7_10am",data.getVisualcheckofudrainsforstock7_10am());
		paramSource.addValue("visualcheckofudrainsforstock7_02pm",data.getVisualcheckofudrainsforstock7_02pm());
		paramSource.addValue("visualcheckofudrainsforstock7_06pm",data.getVisualcheckofudrainsforstock7_06pm());
		paramSource.addValue("visualcheckofudrainsforstock7_10pm",data.getVisualcheckofudrainsforstock7_10pm());
		paramSource.addValue("visualcheckofudrainsforstock7_02am",data.getVisualcheckofudrainsforstock7_02am());
		paramSource.addValue("visualcheckofudrainsforstock7_06am",data.getVisualcheckofudrainsforstock7_06am());
		paramSource.addValue("visualcheckofudrainsforstock8_freq",data.getVisualcheckofudrainsforstock8_freq());
		paramSource.addValue("visualcheckofudrainsforstock8_10am",data.getVisualcheckofudrainsforstock8_10am());
		paramSource.addValue("visualcheckofudrainsforstock8_02pm",data.getVisualcheckofudrainsforstock8_02pm());
		paramSource.addValue("visualcheckofudrainsforstock8_06pm",data.getVisualcheckofudrainsforstock8_06pm());
		paramSource.addValue("visualcheckofudrainsforstock8_10pm",data.getVisualcheckofudrainsforstock8_10pm());
		paramSource.addValue("visualcheckofudrainsforstock8_02am",data.getVisualcheckofudrainsforstock8_02am());
		paramSource.addValue("visualcheckofudrainsforstock8_06am",data.getVisualcheckofudrainsforstock8_06am());
		paramSource.addValue("visualcheckofudrainsforstock9_freq",data.getVisualcheckofudrainsforstock9_freq());
		paramSource.addValue("visualcheckofudrainsforstock9_10am",data.getVisualcheckofudrainsforstock9_10am());
		paramSource.addValue("visualcheckofudrainsforstock9_02pm",data.getVisualcheckofudrainsforstock9_02pm());
		paramSource.addValue("visualcheckofudrainsforstock9_06pm",data.getVisualcheckofudrainsforstock9_06pm());
		paramSource.addValue("visualcheckofudrainsforstock9_10pm",data.getVisualcheckofudrainsforstock9_10pm());
		paramSource.addValue("visualcheckofudrainsforstock9_02am",data.getVisualcheckofudrainsforstock9_02am());
		paramSource.addValue("visualcheckofudrainsforstock9_06am",data.getVisualcheckofudrainsforstock9_06am());	
		paramSource.addValue("visualcheckofudrainsforstock10_freq",data.getVisualcheckofudrainsforstock10_freq());
		paramSource.addValue("visualcheckofudrainsforstock10_10am",data.getVisualcheckofudrainsforstock10_10am());
		paramSource.addValue("visualcheckofudrainsforstock10_02pm",data.getVisualcheckofudrainsforstock10_02pm());
		paramSource.addValue("visualcheckofudrainsforstock10_06pm",data.getVisualcheckofudrainsforstock10_06pm());
		paramSource.addValue("visualcheckofudrainsforstock10_10pm",data.getVisualcheckofudrainsforstock10_10pm());
		paramSource.addValue("visualcheckofudrainsforstock10_02am",data.getVisualcheckofudrainsforstock10_02am());
		paramSource.addValue("visualcheckofudrainsforstock10_06am",data.getVisualcheckofudrainsforstock10_06am());
		paramSource.addValue("visualcheckofudrainsforstock11_freq",data.getVisualcheckofudrainsforstock11_freq());
		paramSource.addValue("visualcheckofudrainsforstock11_10am",data.getVisualcheckofudrainsforstock11_10am());
		paramSource.addValue("visualcheckofudrainsforstock11_02pm",data.getVisualcheckofudrainsforstock11_02pm());
		paramSource.addValue("visualcheckofudrainsforstock11_06pm",data.getVisualcheckofudrainsforstock11_06pm());
		paramSource.addValue("visualcheckofudrainsforstock11_10pm",data.getVisualcheckofudrainsforstock11_10pm());
		paramSource.addValue("visualcheckofudrainsforstock11_02am",data.getVisualcheckofudrainsforstock11_02am());
		paramSource.addValue("visualcheckofudrainsforstock11_06am",data.getVisualcheckofudrainsforstock11_06am());
		paramSource.addValue("visualcheckofudrainsforstock12_freq",data.getVisualcheckofudrainsforstock12_freq());
		paramSource.addValue("visualcheckofudrainsforstock12_10am",data.getVisualcheckofudrainsforstock12_10am());
		paramSource.addValue("visualcheckofudrainsforstock12_02pm",data.getVisualcheckofudrainsforstock12_02pm());
		paramSource.addValue("visualcheckofudrainsforstock12_06pm",data.getVisualcheckofudrainsforstock12_06pm());
		paramSource.addValue("visualcheckofudrainsforstock12_10pm",data.getVisualcheckofudrainsforstock12_10pm());
		paramSource.addValue("visualcheckofudrainsforstock12_02am",data.getVisualcheckofudrainsforstock12_02am());
		paramSource.addValue("visualcheckofudrainsforstock12_06am",data.getVisualcheckofudrainsforstock12_06am());
		paramSource.addValue("visualcheckofudrainsforstock13_freq",data.getVisualcheckofudrainsforstock13_freq());
		paramSource.addValue("visualcheckofudrainsforstock13_10am",data.getVisualcheckofudrainsforstock13_10am());
		paramSource.addValue("visualcheckofudrainsforstock13_02pm",data.getVisualcheckofudrainsforstock13_02pm());
		paramSource.addValue("visualcheckofudrainsforstock13_06pm",data.getVisualcheckofudrainsforstock13_06pm());
		paramSource.addValue("visualcheckofudrainsforstock13_10pm",data.getVisualcheckofudrainsforstock13_10pm());
		paramSource.addValue("visualcheckofudrainsforstock13_02am",data.getVisualcheckofudrainsforstock13_02am());
		paramSource.addValue("visualcheckofudrainsforstock13_06am",data.getVisualcheckofudrainsforstock13_06am());
		paramSource.addValue("visualcheckofudrainsforstock14_freq",data.getVisualcheckofudrainsforstock14_freq());
		paramSource.addValue("visualcheckofudrainsforstock14_10am",data.getVisualcheckofudrainsforstock14_10am());
		paramSource.addValue("visualcheckofudrainsforstock14_02pm",data.getVisualcheckofudrainsforstock14_02pm());
		paramSource.addValue("visualcheckofudrainsforstock14_06pm",data.getVisualcheckofudrainsforstock14_06pm());
		paramSource.addValue("visualcheckofudrainsforstock14_10pm",data.getVisualcheckofudrainsforstock14_10pm());
		paramSource.addValue("visualcheckofudrainsforstock14_02am",data.getVisualcheckofudrainsforstock14_02am());
		paramSource.addValue("visualcheckofudrainsforstock14_06am",data.getVisualcheckofudrainsforstock14_06am());	
		paramSource.addValue("visualcheckofudrainsforstock15_freq",data.getVisualcheckofudrainsforstock15_freq());
		paramSource.addValue("visualcheckofudrainsforstock15_10am",data.getVisualcheckofudrainsforstock15_10am());
		paramSource.addValue("visualcheckofudrainsforstock15_02pm",data.getVisualcheckofudrainsforstock15_02pm());
		paramSource.addValue("visualcheckofudrainsforstock15_06pm",data.getVisualcheckofudrainsforstock15_06pm());
		paramSource.addValue("visualcheckofudrainsforstock15_10pm",data.getVisualcheckofudrainsforstock15_10pm());
		paramSource.addValue("visualcheckofudrainsforstock15_02am",data.getVisualcheckofudrainsforstock15_02am());
		paramSource.addValue("visualcheckofudrainsforstock15_06am",data.getVisualcheckofudrainsforstock15_06am());
		paramSource.addValue("visualcheckofudrainsforstock16_freq",data.getVisualcheckofudrainsforstock16_freq());
		paramSource.addValue("visualcheckofudrainsforstock16_10am",data.getVisualcheckofudrainsforstock16_10am());
		paramSource.addValue("visualcheckofudrainsforstock16_02pm",data.getVisualcheckofudrainsforstock16_02pm());
		paramSource.addValue("visualcheckofudrainsforstock16_06pm",data.getVisualcheckofudrainsforstock16_06pm());
		paramSource.addValue("visualcheckofudrainsforstock16_10pm",data.getVisualcheckofudrainsforstock16_10pm());
		paramSource.addValue("visualcheckofudrainsforstock16_02am",data.getVisualcheckofudrainsforstock16_02am());
		paramSource.addValue("visualcheckofudrainsforstock16_06am",data.getVisualcheckofudrainsforstock16_06am());
		paramSource.addValue("visualcheckofudrainsforstock17_freq",data.getVisualcheckofudrainsforstock17_freq());
		paramSource.addValue("visualcheckofudrainsforstock17_10am",data.getVisualcheckofudrainsforstock17_10am());
		paramSource.addValue("visualcheckofudrainsforstock17_02pm",data.getVisualcheckofudrainsforstock17_02pm());
		paramSource.addValue("visualcheckofudrainsforstock17_06pm",data.getVisualcheckofudrainsforstock17_06pm());
		paramSource.addValue("visualcheckofudrainsforstock17_10pm",data.getVisualcheckofudrainsforstock17_10pm());
		paramSource.addValue("visualcheckofudrainsforstock17_02am",data.getVisualcheckofudrainsforstock17_02am());
		paramSource.addValue("visualcheckofudrainsforstock17_06am",data.getVisualcheckofudrainsforstock17_06am());
		paramSource.addValue("visualcheckofudrainsforstock18_freq",data.getVisualcheckofudrainsforstock18_freq());
		paramSource.addValue("visualcheckofudrainsforstock18_10am",data.getVisualcheckofudrainsforstock18_10am());
		paramSource.addValue("visualcheckofudrainsforstock18_02pm",data.getVisualcheckofudrainsforstock18_02pm());
		paramSource.addValue("visualcheckofudrainsforstock18_06pm",data.getVisualcheckofudrainsforstock18_06pm());
		paramSource.addValue("visualcheckofudrainsforstock18_10pm",data.getVisualcheckofudrainsforstock18_10pm());
		paramSource.addValue("visualcheckofudrainsforstock18_02am",data.getVisualcheckofudrainsforstock18_02am());
		paramSource.addValue("visualcheckofudrainsforstock18_06am",data.getVisualcheckofudrainsforstock18_06am());
		paramSource.addValue("visualcheckofudrainsforstock19_freq",data.getVisualcheckofudrainsforstock19_freq());
		paramSource.addValue("visualcheckofudrainsforstock19_10am",data.getVisualcheckofudrainsforstock19_10am());
		paramSource.addValue("visualcheckofudrainsforstock19_02pm",data.getVisualcheckofudrainsforstock19_02pm());
		paramSource.addValue("visualcheckofudrainsforstock19_06pm",data.getVisualcheckofudrainsforstock19_06pm());
		paramSource.addValue("visualcheckofudrainsforstock19_10pm",data.getVisualcheckofudrainsforstock19_10pm());
		paramSource.addValue("visualcheckofudrainsforstock19_02am",data.getVisualcheckofudrainsforstock19_02am());
		paramSource.addValue("visualcheckofudrainsforstock19_06am",data.getVisualcheckofudrainsforstock19_06am());	
		paramSource.addValue("visualcheckofudrainsforstock20_freq",data.getVisualcheckofudrainsforstock20_freq());
		paramSource.addValue("visualcheckofudrainsforstock20_10am",data.getVisualcheckofudrainsforstock20_10am());
		paramSource.addValue("visualcheckofudrainsforstock20_02pm",data.getVisualcheckofudrainsforstock20_02pm());
		paramSource.addValue("visualcheckofudrainsforstock20_06pm",data.getVisualcheckofudrainsforstock20_06pm());
		paramSource.addValue("visualcheckofudrainsforstock20_10pm",data.getVisualcheckofudrainsforstock20_10pm());
		paramSource.addValue("visualcheckofudrainsforstock20_02am",data.getVisualcheckofudrainsforstock20_02am());
		paramSource.addValue("visualcheckofudrainsforstock20_06am",data.getVisualcheckofudrainsforstock20_06am());
		paramSource.addValue("visualcheckofudrainsforstock21_10am",data.getVisualcheckofudrainsforstock21_10am());
		paramSource.addValue("visualcheckofudrainsforstock21_02pm",data.getVisualcheckofudrainsforstock21_02pm());
		paramSource.addValue("visualcheckofudrainsforstock21_06pm",data.getVisualcheckofudrainsforstock21_06pm());
		paramSource.addValue("visualcheckofudrainsforstock21_10pm",data.getVisualcheckofudrainsforstock21_10pm());
		paramSource.addValue("visualcheckofudrainsforstock21_02am",data.getVisualcheckofudrainsforstock21_02am());
		paramSource.addValue("visualcheckofudrainsforstock21_06am",data.getVisualcheckofudrainsforstock21_06am());
		
		paramSource.addValue("totes1_freq",data.getTotes1_freq());
		paramSource.addValue("totes1_10am",data.getTotes1_10am());
		paramSource.addValue("totes1_02pm",data.getTotes1_02pm());
		paramSource.addValue("totes1_06pm",data.getTotes1_06pm());
		paramSource.addValue("totes1_10pm",data.getTotes1_10pm());
		paramSource.addValue("totes1_02am",data.getTotes1_02am());
		paramSource.addValue("totes1_06am",data.getTotes1_06am());
		paramSource.addValue("totes2_freq",data.getTotes2_freq());
		paramSource.addValue("totes2_10am",data.getTotes2_10am());
		paramSource.addValue("totes2_02pm",data.getTotes2_02pm());
		paramSource.addValue("totes2_06pm",data.getTotes2_06pm());
		paramSource.addValue("totes2_10pm",data.getTotes2_10pm());
		paramSource.addValue("totes2_02am",data.getTotes2_02am());
		paramSource.addValue("totes2_06am",data.getTotes2_06am());
		
		paramSource.addValue("tubeconveyordrive1_freq",data.getTubeconveyordrive1_freq());
		paramSource.addValue("tubeconveyordrive1_10am",data.getTubeconveyordrive1_10am());
		paramSource.addValue("tubeconveyordrive1_02pm",data.getTubeconveyordrive1_02pm());
		paramSource.addValue("tubeconveyordrive1_06pm",data.getTubeconveyordrive1_06pm());
		paramSource.addValue("tubeconveyordrive1_10pm",data.getTubeconveyordrive1_10pm());
		paramSource.addValue("tubeconveyordrive1_02am",data.getTubeconveyordrive1_02am());
		paramSource.addValue("tubeconveyordrive1_06am",data.getTubeconveyordrive1_06am());
		paramSource.addValue("tubeconveyordrive2_freq",data.getTubeconveyordrive2_freq());
		paramSource.addValue("tubeconveyordrive2_10am",data.getTubeconveyordrive2_10am());
		paramSource.addValue("tubeconveyordrive2_02pm",data.getTubeconveyordrive2_02pm());
		paramSource.addValue("tubeconveyordrive2_06pm",data.getTubeconveyordrive2_06pm());
		paramSource.addValue("tubeconveyordrive2_10pm",data.getTubeconveyordrive2_10pm());
		paramSource.addValue("tubeconveyordrive2_02am",data.getTubeconveyordrive2_02am());
		paramSource.addValue("tubeconveyordrive2_06am",data.getTubeconveyordrive2_06am());
		paramSource.addValue("tubeconveyordrive3_freq",data.getTubeconveyordrive3_freq());
		paramSource.addValue("tubeconveyordrive3_10am",data.getTubeconveyordrive3_10am());
		paramSource.addValue("tubeconveyordrive3_02pm",data.getTubeconveyordrive3_02pm());
		paramSource.addValue("tubeconveyordrive3_06pm",data.getTubeconveyordrive3_06pm());
		paramSource.addValue("tubeconveyordrive3_10pm",data.getTubeconveyordrive3_10pm());
		paramSource.addValue("tubeconveyordrive3_02am",data.getTubeconveyordrive3_02am());
		paramSource.addValue("tubeconveyordrive3_06am",data.getTubeconveyordrive3_06am());
		paramSource.addValue("tubeconveyordrive4_freq",data.getTubeconveyordrive4_freq());
		paramSource.addValue("tubeconveyordrive4_10am",data.getTubeconveyordrive4_10am());
		paramSource.addValue("tubeconveyordrive4_02pm",data.getTubeconveyordrive4_02pm());
		paramSource.addValue("tubeconveyordrive4_06pm",data.getTubeconveyordrive4_06pm());
		paramSource.addValue("tubeconveyordrive4_10pm",data.getTubeconveyordrive4_10pm());
		paramSource.addValue("tubeconveyordrive4_02am",data.getTubeconveyordrive4_02am());
		paramSource.addValue("tubeconveyordrive4_06am",data.getTubeconveyordrive4_06am());	
		paramSource.addValue("tubeconveyordrive5_freq",data.getTubeconveyordrive5_freq());
		paramSource.addValue("tubeconveyordrive5_10am",data.getTubeconveyordrive5_10am());
		paramSource.addValue("tubeconveyordrive5_02pm",data.getTubeconveyordrive5_02pm());
		paramSource.addValue("tubeconveyordrive5_06pm",data.getTubeconveyordrive5_06pm());
		paramSource.addValue("tubeconveyordrive5_10pm",data.getTubeconveyordrive5_10pm());
		paramSource.addValue("tubeconveyordrive5_02am",data.getTubeconveyordrive5_02am());
		paramSource.addValue("tubeconveyordrive5_06am",data.getTubeconveyordrive5_06am());
		
		paramSource.addValue("cmt9amarea", data.getCmt9amarea());
		paramSource.addValue("cmt1pmarea", data.getCmt1pmarea());
		paramSource.addValue("cmt5pmarea", data.getCmt5pmarea());
		paramSource.addValue("cmt9pmarea", data.getCmt9pmarea());
		paramSource.addValue("cmt1amarea", data.getCmt1amarea());
		paramSource.addValue("cmt5amarea", data.getCmt5amarea());
				
		if (data.getId() == 0) {	
			
			String sql=DatabaseUtil.getSQL("sql/insertOpRoute_5.sql");
			jdbcTemplate.update(sql, paramSource);
		}	
		else
		{
			paramSource.addValue("id",data.getId());
			String sql=DatabaseUtil.getSQL("sql/updateOpRoute_5.sql");
			jdbcTemplate.update(sql, paramSource);
		}
		
	}
	/* (non-Javadoc)
	 * @see com.st.frpobcc.dao.OpRoute_5Dao#getData(java.lang.String)
	 */
	@Override
	public List<OpRoute_5> getData(String sdate,String edate) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSourceQRT);
		String sql = "select * from [OpRoute_5] where date BETWEEN ? AND ?";
		List<OpRoute_5> oproute_5=null;
		try {
			oproute_5 = jdbcTemplate.query(sql, new Object[] {sdate,edate}, new RowMapper<OpRoute_5>() {

		@Override
		public OpRoute_5 mapRow(ResultSet rs, int arg1) throws SQLException {
		OpRoute_5 data=new OpRoute_5();
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
		data.setVisualcheckofudrainsforstock1_freq(rs.getString("visualcheckofudrainsforstock1_freq"));
		data.setVisualcheckofudrainsforstock1_10am(rs.getString("visualcheckofudrainsforstock1_10am"));
		data.setVisualcheckofudrainsforstock1_02pm(rs.getString("visualcheckofudrainsforstock1_02pm"));
		data.setVisualcheckofudrainsforstock1_06pm(rs.getString("visualcheckofudrainsforstock1_06pm"));
		data.setVisualcheckofudrainsforstock1_10pm(rs.getString("visualcheckofudrainsforstock1_10pm"));
		data.setVisualcheckofudrainsforstock1_02am(rs.getString("visualcheckofudrainsforstock1_02am"));
		data.setVisualcheckofudrainsforstock1_06am(rs.getString("visualcheckofudrainsforstock1_06am"));
		data.setVisualcheckofudrainsforstock2_freq(rs.getString("visualcheckofudrainsforstock2_freq"));
		data.setVisualcheckofudrainsforstock2_10am(rs.getString("visualcheckofudrainsforstock2_10am"));
		data.setVisualcheckofudrainsforstock2_02pm(rs.getString("visualcheckofudrainsforstock2_02pm"));
		data.setVisualcheckofudrainsforstock2_06pm(rs.getString("visualcheckofudrainsforstock2_06pm"));
		data.setVisualcheckofudrainsforstock2_10pm(rs.getString("visualcheckofudrainsforstock2_10pm"));
		data.setVisualcheckofudrainsforstock2_02am(rs.getString("visualcheckofudrainsforstock2_02am"));
		data.setVisualcheckofudrainsforstock2_06am(rs.getString("visualcheckofudrainsforstock2_06am"));
		data.setVisualcheckofudrainsforstock3_freq(rs.getString("visualcheckofudrainsforstock3_freq"));
		data.setVisualcheckofudrainsforstock3_10am(rs.getString("visualcheckofudrainsforstock3_10am"));
		data.setVisualcheckofudrainsforstock3_02pm(rs.getString("visualcheckofudrainsforstock3_02pm"));
		data.setVisualcheckofudrainsforstock3_06pm(rs.getString("visualcheckofudrainsforstock3_06pm"));
		data.setVisualcheckofudrainsforstock3_10pm(rs.getString("visualcheckofudrainsforstock3_10pm"));
		data.setVisualcheckofudrainsforstock3_02am(rs.getString("visualcheckofudrainsforstock3_02am"));
		data.setVisualcheckofudrainsforstock3_06am(rs.getString("visualcheckofudrainsforstock3_06am"));
		data.setVisualcheckofudrainsforstock4_freq(rs.getString("visualcheckofudrainsforstock4_freq"));
		data.setVisualcheckofudrainsforstock4_10am(rs.getString("visualcheckofudrainsforstock4_10am"));
		data.setVisualcheckofudrainsforstock4_02pm(rs.getString("visualcheckofudrainsforstock4_02pm"));
		data.setVisualcheckofudrainsforstock4_06pm(rs.getString("visualcheckofudrainsforstock4_06pm"));
		data.setVisualcheckofudrainsforstock4_10pm(rs.getString("visualcheckofudrainsforstock4_10pm"));
		data.setVisualcheckofudrainsforstock4_02am(rs.getString("visualcheckofudrainsforstock4_02am"));
		data.setVisualcheckofudrainsforstock4_06am(rs.getString("visualcheckofudrainsforstock4_06am"));
		data.setVisualcheckofudrainsforstock5_freq(rs.getString("visualcheckofudrainsforstock5_freq"));
		data.setVisualcheckofudrainsforstock5_10am(rs.getString("visualcheckofudrainsforstock5_10am"));
		data.setVisualcheckofudrainsforstock5_02pm(rs.getString("visualcheckofudrainsforstock5_02pm"));
		data.setVisualcheckofudrainsforstock5_06pm(rs.getString("visualcheckofudrainsforstock5_06pm"));
		data.setVisualcheckofudrainsforstock5_10pm(rs.getString("visualcheckofudrainsforstock5_10pm"));
		data.setVisualcheckofudrainsforstock5_02am(rs.getString("visualcheckofudrainsforstock5_02am"));
		data.setVisualcheckofudrainsforstock5_06am(rs.getString("visualcheckofudrainsforstock5_06am"));
		data.setVisualcheckofudrainsforstock6_freq(rs.getString("visualcheckofudrainsforstock6_freq"));
		data.setVisualcheckofudrainsforstock6_10am(rs.getString("visualcheckofudrainsforstock6_10am"));
		data.setVisualcheckofudrainsforstock6_02pm(rs.getString("visualcheckofudrainsforstock6_02pm"));
		data.setVisualcheckofudrainsforstock6_06pm(rs.getString("visualcheckofudrainsforstock6_06pm"));
		data.setVisualcheckofudrainsforstock6_10pm(rs.getString("visualcheckofudrainsforstock6_10pm"));
		data.setVisualcheckofudrainsforstock6_02am(rs.getString("visualcheckofudrainsforstock6_02am"));
		data.setVisualcheckofudrainsforstock6_06am(rs.getString("visualcheckofudrainsforstock6_06am"));
		data.setVisualcheckofudrainsforstock7_freq(rs.getString("visualcheckofudrainsforstock7_freq"));
		data.setVisualcheckofudrainsforstock7_10am(rs.getString("visualcheckofudrainsforstock7_10am"));
		data.setVisualcheckofudrainsforstock7_02pm(rs.getString("visualcheckofudrainsforstock7_02pm"));
		data.setVisualcheckofudrainsforstock7_06pm(rs.getString("visualcheckofudrainsforstock7_06pm"));
		data.setVisualcheckofudrainsforstock7_10pm(rs.getString("visualcheckofudrainsforstock7_10pm"));
		data.setVisualcheckofudrainsforstock7_02am(rs.getString("visualcheckofudrainsforstock7_02am"));
		data.setVisualcheckofudrainsforstock7_06am(rs.getString("visualcheckofudrainsforstock7_06am"));
		data.setVisualcheckofudrainsforstock8_freq(rs.getString("visualcheckofudrainsforstock8_freq"));
		data.setVisualcheckofudrainsforstock8_10am(rs.getString("visualcheckofudrainsforstock8_10am"));
		data.setVisualcheckofudrainsforstock8_02pm(rs.getString("visualcheckofudrainsforstock8_02pm"));
		data.setVisualcheckofudrainsforstock8_06pm(rs.getString("visualcheckofudrainsforstock8_06pm"));
		data.setVisualcheckofudrainsforstock8_10pm(rs.getString("visualcheckofudrainsforstock8_10pm"));
		data.setVisualcheckofudrainsforstock8_02am(rs.getString("visualcheckofudrainsforstock8_02am"));
		data.setVisualcheckofudrainsforstock8_06am(rs.getString("visualcheckofudrainsforstock8_06am"));
		data.setVisualcheckofudrainsforstock9_freq(rs.getString("visualcheckofudrainsforstock9_freq"));
		data.setVisualcheckofudrainsforstock9_10am(rs.getString("visualcheckofudrainsforstock9_10am"));
		data.setVisualcheckofudrainsforstock9_02pm(rs.getString("visualcheckofudrainsforstock9_02pm"));
		data.setVisualcheckofudrainsforstock9_06pm(rs.getString("visualcheckofudrainsforstock9_06pm"));
		data.setVisualcheckofudrainsforstock9_10pm(rs.getString("visualcheckofudrainsforstock9_10pm"));
		data.setVisualcheckofudrainsforstock9_02am(rs.getString("visualcheckofudrainsforstock9_02am"));
		data.setVisualcheckofudrainsforstock9_06am(rs.getString("visualcheckofudrainsforstock9_06am"));
		data.setVisualcheckofudrainsforstock10_freq(rs.getString("visualcheckofudrainsforstock10_freq"));
		data.setVisualcheckofudrainsforstock10_10am(rs.getString("visualcheckofudrainsforstock10_10am"));
		data.setVisualcheckofudrainsforstock10_02pm(rs.getString("visualcheckofudrainsforstock10_02pm"));
		data.setVisualcheckofudrainsforstock10_06pm(rs.getString("visualcheckofudrainsforstock10_06pm"));
		data.setVisualcheckofudrainsforstock10_10pm(rs.getString("visualcheckofudrainsforstock10_10pm"));
		data.setVisualcheckofudrainsforstock10_02am(rs.getString("visualcheckofudrainsforstock10_02am"));
		data.setVisualcheckofudrainsforstock10_06am(rs.getString("visualcheckofudrainsforstock10_06am"));
		data.setVisualcheckofudrainsforstock11_freq(rs.getString("visualcheckofudrainsforstock11_freq"));
		data.setVisualcheckofudrainsforstock11_10am(rs.getString("visualcheckofudrainsforstock11_10am"));
		data.setVisualcheckofudrainsforstock11_02pm(rs.getString("visualcheckofudrainsforstock11_02pm"));
		data.setVisualcheckofudrainsforstock11_06pm(rs.getString("visualcheckofudrainsforstock11_06pm"));
		data.setVisualcheckofudrainsforstock11_10pm(rs.getString("visualcheckofudrainsforstock11_10pm"));
		data.setVisualcheckofudrainsforstock11_02am(rs.getString("visualcheckofudrainsforstock11_02am"));
		data.setVisualcheckofudrainsforstock11_06am(rs.getString("visualcheckofudrainsforstock11_06am"));
		data.setVisualcheckofudrainsforstock12_freq(rs.getString("visualcheckofudrainsforstock12_freq"));
		data.setVisualcheckofudrainsforstock12_10am(rs.getString("visualcheckofudrainsforstock12_10am"));
		data.setVisualcheckofudrainsforstock12_02pm(rs.getString("visualcheckofudrainsforstock12_02pm"));
		data.setVisualcheckofudrainsforstock12_06pm(rs.getString("visualcheckofudrainsforstock12_06pm"));
		data.setVisualcheckofudrainsforstock12_10pm(rs.getString("visualcheckofudrainsforstock12_10pm"));
		data.setVisualcheckofudrainsforstock12_02am(rs.getString("visualcheckofudrainsforstock12_02am"));
		data.setVisualcheckofudrainsforstock12_06am(rs.getString("visualcheckofudrainsforstock12_06am"));
		data.setVisualcheckofudrainsforstock13_freq(rs.getString("visualcheckofudrainsforstock13_freq"));
		data.setVisualcheckofudrainsforstock13_10am(rs.getString("visualcheckofudrainsforstock13_10am"));
		data.setVisualcheckofudrainsforstock13_02pm(rs.getString("visualcheckofudrainsforstock13_02pm"));
		data.setVisualcheckofudrainsforstock13_06pm(rs.getString("visualcheckofudrainsforstock13_06pm"));
		data.setVisualcheckofudrainsforstock13_10pm(rs.getString("visualcheckofudrainsforstock13_10pm"));
		data.setVisualcheckofudrainsforstock13_02am(rs.getString("visualcheckofudrainsforstock13_02am"));
		data.setVisualcheckofudrainsforstock13_06am(rs.getString("visualcheckofudrainsforstock13_06am"));
		data.setVisualcheckofudrainsforstock14_freq(rs.getString("visualcheckofudrainsforstock14_freq"));
		data.setVisualcheckofudrainsforstock14_10am(rs.getString("visualcheckofudrainsforstock14_10am"));
		data.setVisualcheckofudrainsforstock14_02pm(rs.getString("visualcheckofudrainsforstock14_02pm"));
		data.setVisualcheckofudrainsforstock14_06pm(rs.getString("visualcheckofudrainsforstock14_06pm"));
		data.setVisualcheckofudrainsforstock14_10pm(rs.getString("visualcheckofudrainsforstock14_10pm"));
		data.setVisualcheckofudrainsforstock14_02am(rs.getString("visualcheckofudrainsforstock14_02am"));
		data.setVisualcheckofudrainsforstock14_06am(rs.getString("visualcheckofudrainsforstock14_06am"));
		data.setVisualcheckofudrainsforstock15_freq(rs.getString("visualcheckofudrainsforstock15_freq"));
		data.setVisualcheckofudrainsforstock15_10am(rs.getString("visualcheckofudrainsforstock15_10am"));
		data.setVisualcheckofudrainsforstock15_02pm(rs.getString("visualcheckofudrainsforstock15_02pm"));
		data.setVisualcheckofudrainsforstock15_06pm(rs.getString("visualcheckofudrainsforstock15_06pm"));
		data.setVisualcheckofudrainsforstock15_10pm(rs.getString("visualcheckofudrainsforstock15_10pm"));
		data.setVisualcheckofudrainsforstock15_02am(rs.getString("visualcheckofudrainsforstock15_02am"));
		data.setVisualcheckofudrainsforstock15_06am(rs.getString("visualcheckofudrainsforstock15_06am"));
		data.setVisualcheckofudrainsforstock16_freq(rs.getString("visualcheckofudrainsforstock16_freq"));
		data.setVisualcheckofudrainsforstock16_10am(rs.getString("visualcheckofudrainsforstock16_10am"));
		data.setVisualcheckofudrainsforstock16_02pm(rs.getString("visualcheckofudrainsforstock16_02pm"));
		data.setVisualcheckofudrainsforstock16_06pm(rs.getString("visualcheckofudrainsforstock16_06pm"));
		data.setVisualcheckofudrainsforstock16_10pm(rs.getString("visualcheckofudrainsforstock16_10pm"));
		data.setVisualcheckofudrainsforstock16_02am(rs.getString("visualcheckofudrainsforstock16_02am"));
		data.setVisualcheckofudrainsforstock16_06am(rs.getString("visualcheckofudrainsforstock16_06am"));
		data.setVisualcheckofudrainsforstock17_freq(rs.getString("visualcheckofudrainsforstock17_freq"));
		data.setVisualcheckofudrainsforstock17_10am(rs.getString("visualcheckofudrainsforstock17_10am"));
		data.setVisualcheckofudrainsforstock17_02pm(rs.getString("visualcheckofudrainsforstock17_02pm"));
		data.setVisualcheckofudrainsforstock17_06pm(rs.getString("visualcheckofudrainsforstock17_06pm"));
		data.setVisualcheckofudrainsforstock17_10pm(rs.getString("visualcheckofudrainsforstock17_10pm"));
		data.setVisualcheckofudrainsforstock17_02am(rs.getString("visualcheckofudrainsforstock17_02am"));
		data.setVisualcheckofudrainsforstock17_06am(rs.getString("visualcheckofudrainsforstock17_06am"));
		data.setVisualcheckofudrainsforstock18_freq(rs.getString("visualcheckofudrainsforstock18_freq"));
		data.setVisualcheckofudrainsforstock18_10am(rs.getString("visualcheckofudrainsforstock18_10am"));
		data.setVisualcheckofudrainsforstock18_02pm(rs.getString("visualcheckofudrainsforstock18_02pm"));
		data.setVisualcheckofudrainsforstock18_06pm(rs.getString("visualcheckofudrainsforstock18_06pm"));
		data.setVisualcheckofudrainsforstock18_10pm(rs.getString("visualcheckofudrainsforstock18_10pm"));
		data.setVisualcheckofudrainsforstock18_02am(rs.getString("visualcheckofudrainsforstock18_02am"));
		data.setVisualcheckofudrainsforstock18_06am(rs.getString("visualcheckofudrainsforstock18_06am"));
		data.setVisualcheckofudrainsforstock19_freq(rs.getString("visualcheckofudrainsforstock19_freq"));
		data.setVisualcheckofudrainsforstock19_10am(rs.getString("visualcheckofudrainsforstock19_10am"));
		data.setVisualcheckofudrainsforstock19_02pm(rs.getString("visualcheckofudrainsforstock19_02pm"));
		data.setVisualcheckofudrainsforstock19_06pm(rs.getString("visualcheckofudrainsforstock19_06pm"));
		data.setVisualcheckofudrainsforstock19_10pm(rs.getString("visualcheckofudrainsforstock19_10pm"));
		data.setVisualcheckofudrainsforstock19_02am(rs.getString("visualcheckofudrainsforstock19_02am"));
		data.setVisualcheckofudrainsforstock19_06am(rs.getString("visualcheckofudrainsforstock19_06am"));
		data.setVisualcheckofudrainsforstock20_freq(rs.getString("visualcheckofudrainsforstock20_freq"));
		data.setVisualcheckofudrainsforstock20_10am(rs.getString("visualcheckofudrainsforstock20_10am"));
		data.setVisualcheckofudrainsforstock20_02pm(rs.getString("visualcheckofudrainsforstock20_02pm"));
		data.setVisualcheckofudrainsforstock20_06pm(rs.getString("visualcheckofudrainsforstock20_06pm"));
		data.setVisualcheckofudrainsforstock20_10pm(rs.getString("visualcheckofudrainsforstock20_10pm"));
		data.setVisualcheckofudrainsforstock20_02am(rs.getString("visualcheckofudrainsforstock20_02am"));
		data.setVisualcheckofudrainsforstock20_06am(rs.getString("visualcheckofudrainsforstock20_06am"));
		data.setVisualcheckofudrainsforstock21_10am(rs.getString("visualcheckofudrainsforstock21_10am"));
		data.setVisualcheckofudrainsforstock21_02pm(rs.getString("visualcheckofudrainsforstock21_02pm"));
		data.setVisualcheckofudrainsforstock21_06pm(rs.getString("visualcheckofudrainsforstock21_06pm"));
		data.setVisualcheckofudrainsforstock21_10pm(rs.getString("visualcheckofudrainsforstock21_10pm"));
		data.setVisualcheckofudrainsforstock21_02am(rs.getString("visualcheckofudrainsforstock21_02am"));
		data.setVisualcheckofudrainsforstock21_06am(rs.getString("visualcheckofudrainsforstock21_06am"));
		data.setTotes1_freq(rs.getString("totes1_freq"));
		data.setTotes1_10am(rs.getString("totes1_10am"));
		data.setTotes1_02pm(rs.getString("totes1_02pm"));
		data.setTotes1_06pm(rs.getString("totes1_06pm"));
		data.setTotes1_10pm(rs.getString("totes1_10pm"));
		data.setTotes1_02am(rs.getString("totes1_02am"));
		data.setTotes1_06am(rs.getString("totes1_06am"));
		data.setTotes2_freq(rs.getString("totes2_freq"));
		data.setTotes2_10am(rs.getString("totes2_10am"));
		data.setTotes2_02pm(rs.getString("totes2_02pm"));
		data.setTotes2_06pm(rs.getString("totes2_06pm"));
		data.setTotes2_10pm(rs.getString("totes2_10pm"));
		data.setTotes2_02am(rs.getString("totes2_02am"));
		data.setTotes2_06am(rs.getString("totes2_06am"));
		data.setTubeconveyordrive1_freq(rs.getString("tubeconveyordrive1_freq"));
		data.setTubeconveyordrive1_10am(rs.getString("tubeconveyordrive1_10am"));
		data.setTubeconveyordrive1_02pm(rs.getString("tubeconveyordrive1_02pm"));
		data.setTubeconveyordrive1_06pm(rs.getString("tubeconveyordrive1_06pm"));
		data.setTubeconveyordrive1_10pm(rs.getString("tubeconveyordrive1_10pm"));
		data.setTubeconveyordrive1_02am(rs.getString("tubeconveyordrive1_02am"));
		data.setTubeconveyordrive1_06am(rs.getString("tubeconveyordrive1_06am"));
		data.setTubeconveyordrive2_freq(rs.getString("tubeconveyordrive2_freq"));
		data.setTubeconveyordrive2_10am(rs.getString("tubeconveyordrive2_10am"));
		data.setTubeconveyordrive2_02pm(rs.getString("tubeconveyordrive2_02pm"));
		data.setTubeconveyordrive2_06pm(rs.getString("tubeconveyordrive2_06pm"));
		data.setTubeconveyordrive2_10pm(rs.getString("tubeconveyordrive2_10pm"));
		data.setTubeconveyordrive2_02am(rs.getString("tubeconveyordrive2_02am"));
		data.setTubeconveyordrive2_06am(rs.getString("tubeconveyordrive2_06am"));
		data.setTubeconveyordrive3_freq(rs.getString("tubeconveyordrive3_freq"));
		data.setTubeconveyordrive3_10am(rs.getString("tubeconveyordrive3_10am"));
		data.setTubeconveyordrive3_02pm(rs.getString("tubeconveyordrive3_02pm"));
		data.setTubeconveyordrive3_06pm(rs.getString("tubeconveyordrive3_06pm"));
		data.setTubeconveyordrive3_10pm(rs.getString("tubeconveyordrive3_10pm"));
		data.setTubeconveyordrive3_02am(rs.getString("tubeconveyordrive3_02am"));
		data.setTubeconveyordrive3_06am(rs.getString("tubeconveyordrive3_06am"));
		data.setTubeconveyordrive4_freq(rs.getString("tubeconveyordrive4_freq"));
		data.setTubeconveyordrive4_10am(rs.getString("tubeconveyordrive4_10am"));
		data.setTubeconveyordrive4_02pm(rs.getString("tubeconveyordrive4_02pm"));
		data.setTubeconveyordrive4_06pm(rs.getString("tubeconveyordrive4_06pm"));
		data.setTubeconveyordrive4_10pm(rs.getString("tubeconveyordrive4_10pm"));
		data.setTubeconveyordrive4_02am(rs.getString("tubeconveyordrive4_02am"));
		data.setTubeconveyordrive4_06am(rs.getString("tubeconveyordrive4_06am"));
		data.setTubeconveyordrive5_freq(rs.getString("tubeconveyordrive5_freq"));
		data.setTubeconveyordrive5_10am(rs.getString("tubeconveyordrive5_10am"));
		data.setTubeconveyordrive5_02pm(rs.getString("tubeconveyordrive5_02pm"));
		data.setTubeconveyordrive5_06pm(rs.getString("tubeconveyordrive5_06pm"));
		data.setTubeconveyordrive5_10pm(rs.getString("tubeconveyordrive5_10pm"));
		data.setTubeconveyordrive5_02am(rs.getString("tubeconveyordrive5_02am"));
		data.setTubeconveyordrive5_06am(rs.getString("tubeconveyordrive5_06am"));
		
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
	return oproute_5;
}
	@Override
	public long getCountDatePercentage(String sdate,String edate) throws Exception {
		
		int _10am=0,_02pm=0,_06pm=0,_10pm=0,_02am=0,_06am=0;
		long _10ampercent=0,_02pmpercent=0,_06pmpercent=0,_10pmpercent=0,_02ampercent=0,_06ampercent=0;
	 	long percent=0;
		List<OpRoute_5> lst= getData(sdate,edate);
		for(OpRoute_5 data:lst)
		{
			if(data.getVisualcheckofudrainsforstock1_10am()!=null&&!data.getVisualcheckofudrainsforstock1_10am().equals("")){_10am++;}
			if(data.getVisualcheckofudrainsforstock2_10am()!=null&&!data.getVisualcheckofudrainsforstock2_10am().equals("")){_10am++;}
			if(data.getVisualcheckofudrainsforstock3_10am()!=null&&!data.getVisualcheckofudrainsforstock3_10am().equals("")){_10am++;}
			if(data.getVisualcheckofudrainsforstock4_10am()!=null&&!data.getVisualcheckofudrainsforstock4_10am().equals("")){_10am++;}
			if(data.getVisualcheckofudrainsforstock5_10am()!=null&&!data.getVisualcheckofudrainsforstock5_10am().equals("")){_10am++;}
			if(data.getVisualcheckofudrainsforstock6_10am()!=null&&!data.getVisualcheckofudrainsforstock6_10am().equals("")){_10am++;}
			if(data.getVisualcheckofudrainsforstock7_10am()!=null&&!data.getVisualcheckofudrainsforstock7_10am().equals("")){_10am++;}
			if(data.getVisualcheckofudrainsforstock8_10am()!=null&&!data.getVisualcheckofudrainsforstock8_10am().equals("")){_10am++;}
			if(data.getVisualcheckofudrainsforstock9_10am()!=null&&!data.getVisualcheckofudrainsforstock9_10am().equals("")){_10am++;}
			if(data.getVisualcheckofudrainsforstock10_10am()!=null&&!data.getVisualcheckofudrainsforstock10_10am().equals("")){_10am++;}
			if(data.getVisualcheckofudrainsforstock11_10am()!=null&&!data.getVisualcheckofudrainsforstock11_10am().equals("")){_10am++;}
			if(data.getVisualcheckofudrainsforstock12_10am()!=null&&!data.getVisualcheckofudrainsforstock12_10am().equals("")){_10am++;}
			if(data.getVisualcheckofudrainsforstock13_10am()!=null&&!data.getVisualcheckofudrainsforstock13_10am().equals("")){_10am++;}
			if(data.getVisualcheckofudrainsforstock14_10am()!=null&&!data.getVisualcheckofudrainsforstock14_10am().equals("")){_10am++;}
			if(data.getVisualcheckofudrainsforstock15_10am()!=null&&!data.getVisualcheckofudrainsforstock15_10am().equals("")){_10am++;}
			if(data.getVisualcheckofudrainsforstock16_10am()!=null&&!data.getVisualcheckofudrainsforstock16_10am().equals("")){_10am++;}
			if(data.getVisualcheckofudrainsforstock17_10am()!=null&&!data.getVisualcheckofudrainsforstock17_10am().equals("")){_10am++;}
			if(data.getVisualcheckofudrainsforstock18_10am()!=null&&!data.getVisualcheckofudrainsforstock18_10am().equals("")){_10am++;}
			if(data.getVisualcheckofudrainsforstock19_10am()!=null&&!data.getVisualcheckofudrainsforstock19_10am().equals("")){_10am++;}
			if(data.getVisualcheckofudrainsforstock20_10am()!=null&&!data.getVisualcheckofudrainsforstock20_10am().equals("")){_10am++;}
			if(data.getTotes1_10am()!=null&&!data.getTotes1_10am().equals("")){_10am++;}
			if(data.getTotes2_10am()!=null&&!data.getTotes2_10am().equals("")){_10am++;}
			if(data.getTubeconveyordrive1_10am()!=null&&!data.getTubeconveyordrive1_10am().equals("")){_10am++;}
			if(data.getTubeconveyordrive2_10am()!=null&&!data.getTubeconveyordrive2_10am().equals("")){_10am++;}
			if(data.getTubeconveyordrive3_10am()!=null&&!data.getTubeconveyordrive3_10am().equals("")){_10am++;}
			if(data.getTubeconveyordrive4_10am()!=null&&!data.getTubeconveyordrive4_10am().equals("")){_10am++;}
			if(data.getTubeconveyordrive5_10am()!=null&&!data.getTubeconveyordrive5_10am().equals("")){_10am++;}
			
			if(data.getVisualcheckofudrainsforstock1_02pm()!=null&&!data.getVisualcheckofudrainsforstock1_02pm().equals("")){_02pm++;}
			if(data.getVisualcheckofudrainsforstock2_02pm()!=null&&!data.getVisualcheckofudrainsforstock2_02pm().equals("")){_02pm++;}
			if(data.getVisualcheckofudrainsforstock3_02pm()!=null&&!data.getVisualcheckofudrainsforstock3_02pm().equals("")){_02pm++;}
			if(data.getVisualcheckofudrainsforstock4_02pm()!=null&&!data.getVisualcheckofudrainsforstock4_02pm().equals("")){_02pm++;}
			if(data.getVisualcheckofudrainsforstock5_02pm()!=null&&!data.getVisualcheckofudrainsforstock5_02pm().equals("")){_02pm++;}
			if(data.getVisualcheckofudrainsforstock6_02pm()!=null&&!data.getVisualcheckofudrainsforstock6_02pm().equals("")){_02pm++;}
			if(data.getVisualcheckofudrainsforstock7_02pm()!=null&&!data.getVisualcheckofudrainsforstock7_02pm().equals("")){_02pm++;}
			if(data.getVisualcheckofudrainsforstock8_02pm()!=null&&!data.getVisualcheckofudrainsforstock8_02pm().equals("")){_02pm++;}
			if(data.getVisualcheckofudrainsforstock9_02pm()!=null&&!data.getVisualcheckofudrainsforstock9_02pm().equals("")){_02pm++;}
			if(data.getVisualcheckofudrainsforstock10_02pm()!=null&&!data.getVisualcheckofudrainsforstock10_02pm().equals("")){_02pm++;}
			if(data.getVisualcheckofudrainsforstock11_02pm()!=null&&!data.getVisualcheckofudrainsforstock11_02pm().equals("")){_02pm++;}
			if(data.getVisualcheckofudrainsforstock12_02pm()!=null&&!data.getVisualcheckofudrainsforstock12_02pm().equals("")){_02pm++;}
			if(data.getVisualcheckofudrainsforstock13_02pm()!=null&&!data.getVisualcheckofudrainsforstock13_02pm().equals("")){_02pm++;}
			if(data.getVisualcheckofudrainsforstock14_02pm()!=null&&!data.getVisualcheckofudrainsforstock14_02pm().equals("")){_02pm++;}
			if(data.getVisualcheckofudrainsforstock15_02pm()!=null&&!data.getVisualcheckofudrainsforstock15_02pm().equals("")){_02pm++;}
			if(data.getVisualcheckofudrainsforstock16_02pm()!=null&&!data.getVisualcheckofudrainsforstock16_02pm().equals("")){_02pm++;}
			if(data.getVisualcheckofudrainsforstock17_02pm()!=null&&!data.getVisualcheckofudrainsforstock17_02pm().equals("")){_02pm++;}
			if(data.getVisualcheckofudrainsforstock18_02pm()!=null&&!data.getVisualcheckofudrainsforstock18_02pm().equals("")){_02pm++;}
			if(data.getVisualcheckofudrainsforstock19_02pm()!=null&&!data.getVisualcheckofudrainsforstock19_02pm().equals("")){_02pm++;}
			if(data.getVisualcheckofudrainsforstock20_02pm()!=null&&!data.getVisualcheckofudrainsforstock20_02pm().equals("")){_02pm++;}
			if(data.getTotes1_02pm()!=null&&!data.getTotes1_02pm().equals("")){_02pm++;}
			if(data.getTotes2_02pm()!=null&&!data.getTotes2_02pm().equals("")){_02pm++;}
			if(data.getTubeconveyordrive1_02pm()!=null&&!data.getTubeconveyordrive1_02pm().equals("")){_02pm++;}
			if(data.getTubeconveyordrive2_02pm()!=null&&!data.getTubeconveyordrive2_02pm().equals("")){_02pm++;}
			if(data.getTubeconveyordrive3_02pm()!=null&&!data.getTubeconveyordrive3_02pm().equals("")){_02pm++;}
			if(data.getTubeconveyordrive4_02pm()!=null&&!data.getTubeconveyordrive4_02pm().equals("")){_02pm++;}
			if(data.getTubeconveyordrive5_02pm()!=null&&!data.getTubeconveyordrive5_02pm().equals("")){_02pm++;}

			if(data.getVisualcheckofudrainsforstock1_06pm()!=null&&!data.getVisualcheckofudrainsforstock1_06pm().equals("")){_06pm++;}
			if(data.getVisualcheckofudrainsforstock2_06pm()!=null&&!data.getVisualcheckofudrainsforstock2_06pm().equals("")){_06pm++;}
			if(data.getVisualcheckofudrainsforstock3_06pm()!=null&&!data.getVisualcheckofudrainsforstock3_06pm().equals("")){_06pm++;}
			if(data.getVisualcheckofudrainsforstock4_06pm()!=null&&!data.getVisualcheckofudrainsforstock4_06pm().equals("")){_06pm++;}
			if(data.getVisualcheckofudrainsforstock5_06pm()!=null&&!data.getVisualcheckofudrainsforstock5_06pm().equals("")){_06pm++;}
			if(data.getVisualcheckofudrainsforstock6_06pm()!=null&&!data.getVisualcheckofudrainsforstock6_06pm().equals("")){_06pm++;}
			if(data.getVisualcheckofudrainsforstock7_06pm()!=null&&!data.getVisualcheckofudrainsforstock7_06pm().equals("")){_06pm++;}
			if(data.getVisualcheckofudrainsforstock8_06pm()!=null&&!data.getVisualcheckofudrainsforstock8_06pm().equals("")){_06pm++;}
			if(data.getVisualcheckofudrainsforstock9_06pm()!=null&&!data.getVisualcheckofudrainsforstock9_06pm().equals("")){_06pm++;}
			if(data.getVisualcheckofudrainsforstock10_06pm()!=null&&!data.getVisualcheckofudrainsforstock10_06pm().equals("")){_06pm++;}
			if(data.getVisualcheckofudrainsforstock11_06pm()!=null&&!data.getVisualcheckofudrainsforstock11_06pm().equals("")){_06pm++;}
			if(data.getVisualcheckofudrainsforstock12_06pm()!=null&&!data.getVisualcheckofudrainsforstock12_06pm().equals("")){_06pm++;}
			if(data.getVisualcheckofudrainsforstock13_06pm()!=null&&!data.getVisualcheckofudrainsforstock13_06pm().equals("")){_06pm++;}
			if(data.getVisualcheckofudrainsforstock14_06pm()!=null&&!data.getVisualcheckofudrainsforstock14_06pm().equals("")){_06pm++;}
			if(data.getVisualcheckofudrainsforstock15_06pm()!=null&&!data.getVisualcheckofudrainsforstock15_06pm().equals("")){_06pm++;}
			if(data.getVisualcheckofudrainsforstock16_06pm()!=null&&!data.getVisualcheckofudrainsforstock16_06pm().equals("")){_06pm++;}
			if(data.getVisualcheckofudrainsforstock17_06pm()!=null&&!data.getVisualcheckofudrainsforstock17_06pm().equals("")){_06pm++;}
			if(data.getVisualcheckofudrainsforstock18_06pm()!=null&&!data.getVisualcheckofudrainsforstock18_06pm().equals("")){_06pm++;}
			if(data.getVisualcheckofudrainsforstock19_06pm()!=null&&!data.getVisualcheckofudrainsforstock19_06pm().equals("")){_06pm++;}
			if(data.getVisualcheckofudrainsforstock20_06pm()!=null&&!data.getVisualcheckofudrainsforstock20_06pm().equals("")){_06pm++;}
			if(data.getTotes1_06pm()!=null&&!data.getTotes1_06pm().equals("")){_06pm++;}
			if(data.getTotes2_06pm()!=null&&!data.getTotes2_06pm().equals("")){_06pm++;}
			if(data.getTubeconveyordrive1_06pm()!=null&&!data.getTubeconveyordrive1_06pm().equals("")){_06pm++;}
			if(data.getTubeconveyordrive2_06pm()!=null&&!data.getTubeconveyordrive2_06pm().equals("")){_06pm++;}
			if(data.getTubeconveyordrive3_06pm()!=null&&!data.getTubeconveyordrive3_06pm().equals("")){_06pm++;}
			if(data.getTubeconveyordrive4_06pm()!=null&&!data.getTubeconveyordrive4_06pm().equals("")){_06pm++;}
			if(data.getTubeconveyordrive5_06pm()!=null&&!data.getTubeconveyordrive5_06pm().equals("")){_06pm++;}

			if(data.getVisualcheckofudrainsforstock1_10pm()!=null&&!data.getVisualcheckofudrainsforstock1_10pm().equals("")){_10pm++;}
			if(data.getVisualcheckofudrainsforstock2_10pm()!=null&&!data.getVisualcheckofudrainsforstock2_10pm().equals("")){_10pm++;}
			if(data.getVisualcheckofudrainsforstock3_10pm()!=null&&!data.getVisualcheckofudrainsforstock3_10pm().equals("")){_10pm++;}
			if(data.getVisualcheckofudrainsforstock4_10pm()!=null&&!data.getVisualcheckofudrainsforstock4_10pm().equals("")){_10pm++;}
			if(data.getVisualcheckofudrainsforstock5_10pm()!=null&&!data.getVisualcheckofudrainsforstock5_10pm().equals("")){_10pm++;}
			if(data.getVisualcheckofudrainsforstock6_10pm()!=null&&!data.getVisualcheckofudrainsforstock6_10pm().equals("")){_10pm++;}
			if(data.getVisualcheckofudrainsforstock7_10pm()!=null&&!data.getVisualcheckofudrainsforstock7_10pm().equals("")){_10pm++;}
			if(data.getVisualcheckofudrainsforstock8_10pm()!=null&&!data.getVisualcheckofudrainsforstock8_10pm().equals("")){_10pm++;}
			if(data.getVisualcheckofudrainsforstock9_10pm()!=null&&!data.getVisualcheckofudrainsforstock9_10pm().equals("")){_10pm++;}
			if(data.getVisualcheckofudrainsforstock10_10pm()!=null&&!data.getVisualcheckofudrainsforstock10_10pm().equals("")){_10pm++;}
			if(data.getVisualcheckofudrainsforstock11_10pm()!=null&&!data.getVisualcheckofudrainsforstock11_10pm().equals("")){_10pm++;}
			if(data.getVisualcheckofudrainsforstock12_10pm()!=null&&!data.getVisualcheckofudrainsforstock12_10pm().equals("")){_10pm++;}
			if(data.getVisualcheckofudrainsforstock13_10pm()!=null&&!data.getVisualcheckofudrainsforstock13_10pm().equals("")){_10pm++;}
			if(data.getVisualcheckofudrainsforstock14_10pm()!=null&&!data.getVisualcheckofudrainsforstock14_10pm().equals("")){_10pm++;}
			if(data.getVisualcheckofudrainsforstock15_10pm()!=null&&!data.getVisualcheckofudrainsforstock15_10pm().equals("")){_10pm++;}
			if(data.getVisualcheckofudrainsforstock16_10pm()!=null&&!data.getVisualcheckofudrainsforstock16_10pm().equals("")){_10pm++;}
			if(data.getVisualcheckofudrainsforstock17_10pm()!=null&&!data.getVisualcheckofudrainsforstock17_10pm().equals("")){_10pm++;}
			if(data.getVisualcheckofudrainsforstock18_10pm()!=null&&!data.getVisualcheckofudrainsforstock18_10pm().equals("")){_10pm++;}
			if(data.getVisualcheckofudrainsforstock19_10pm()!=null&&!data.getVisualcheckofudrainsforstock19_10pm().equals("")){_10pm++;}
			if(data.getVisualcheckofudrainsforstock20_10pm()!=null&&!data.getVisualcheckofudrainsforstock20_10pm().equals("")){_10pm++;}
			if(data.getTotes1_10pm()!=null&&!data.getTotes1_10pm().equals("")){_10pm++;}
			if(data.getTotes2_10pm()!=null&&!data.getTotes2_10pm().equals("")){_10pm++;}
			if(data.getTubeconveyordrive1_10pm()!=null&&!data.getTubeconveyordrive1_10pm().equals("")){_10pm++;}
			if(data.getTubeconveyordrive2_10pm()!=null&&!data.getTubeconveyordrive2_10pm().equals("")){_10pm++;}
			if(data.getTubeconveyordrive3_10pm()!=null&&!data.getTubeconveyordrive3_10pm().equals("")){_10pm++;}
			if(data.getTubeconveyordrive4_10pm()!=null&&!data.getTubeconveyordrive4_10pm().equals("")){_10pm++;}
			if(data.getTubeconveyordrive5_10pm()!=null&&!data.getTubeconveyordrive5_10pm().equals("")){_10pm++;}

			if(data.getVisualcheckofudrainsforstock1_02am()!=null&&!data.getVisualcheckofudrainsforstock1_02am().equals("")){_02am++;}
			if(data.getVisualcheckofudrainsforstock2_02am()!=null&&!data.getVisualcheckofudrainsforstock2_02am().equals("")){_02am++;}
			if(data.getVisualcheckofudrainsforstock3_02am()!=null&&!data.getVisualcheckofudrainsforstock3_02am().equals("")){_02am++;}
			if(data.getVisualcheckofudrainsforstock4_02am()!=null&&!data.getVisualcheckofudrainsforstock4_02am().equals("")){_02am++;}
			if(data.getVisualcheckofudrainsforstock5_02am()!=null&&!data.getVisualcheckofudrainsforstock5_02am().equals("")){_02am++;}
			if(data.getVisualcheckofudrainsforstock6_02am()!=null&&!data.getVisualcheckofudrainsforstock6_02am().equals("")){_02am++;}
			if(data.getVisualcheckofudrainsforstock7_02am()!=null&&!data.getVisualcheckofudrainsforstock7_02am().equals("")){_02am++;}
			if(data.getVisualcheckofudrainsforstock8_02am()!=null&&!data.getVisualcheckofudrainsforstock8_02am().equals("")){_02am++;}
			if(data.getVisualcheckofudrainsforstock9_02am()!=null&&!data.getVisualcheckofudrainsforstock9_02am().equals("")){_02am++;}
			if(data.getVisualcheckofudrainsforstock10_02am()!=null&&!data.getVisualcheckofudrainsforstock10_02am().equals("")){_02am++;}
			if(data.getVisualcheckofudrainsforstock11_02am()!=null&&!data.getVisualcheckofudrainsforstock11_02am().equals("")){_02am++;}
			if(data.getVisualcheckofudrainsforstock12_02am()!=null&&!data.getVisualcheckofudrainsforstock12_02am().equals("")){_02am++;}
			if(data.getVisualcheckofudrainsforstock13_02am()!=null&&!data.getVisualcheckofudrainsforstock13_02am().equals("")){_02am++;}
			if(data.getVisualcheckofudrainsforstock14_02am()!=null&&!data.getVisualcheckofudrainsforstock14_02am().equals("")){_02am++;}
			if(data.getVisualcheckofudrainsforstock15_02am()!=null&&!data.getVisualcheckofudrainsforstock15_02am().equals("")){_02am++;}
			if(data.getVisualcheckofudrainsforstock16_02am()!=null&&!data.getVisualcheckofudrainsforstock16_02am().equals("")){_02am++;}
			if(data.getVisualcheckofudrainsforstock17_02am()!=null&&!data.getVisualcheckofudrainsforstock17_02am().equals("")){_02am++;}
			if(data.getVisualcheckofudrainsforstock18_02am()!=null&&!data.getVisualcheckofudrainsforstock18_02am().equals("")){_02am++;}
			if(data.getVisualcheckofudrainsforstock19_02am()!=null&&!data.getVisualcheckofudrainsforstock19_02am().equals("")){_02am++;}
			if(data.getVisualcheckofudrainsforstock20_02am()!=null&&!data.getVisualcheckofudrainsforstock20_02am().equals("")){_02am++;}
			if(data.getTotes1_02am()!=null&&!data.getTotes1_02am().equals("")){_02am++;}
			if(data.getTotes2_02am()!=null&&!data.getTotes2_02am().equals("")){_02am++;}
			if(data.getTubeconveyordrive1_02am()!=null&&!data.getTubeconveyordrive1_02am().equals("")){_02am++;}
			if(data.getTubeconveyordrive2_02am()!=null&&!data.getTubeconveyordrive2_02am().equals("")){_02am++;}
			if(data.getTubeconveyordrive3_02am()!=null&&!data.getTubeconveyordrive3_02am().equals("")){_02am++;}
			if(data.getTubeconveyordrive4_02am()!=null&&!data.getTubeconveyordrive4_02am().equals("")){_02am++;}
			if(data.getTubeconveyordrive5_02am()!=null&&!data.getTubeconveyordrive5_02am().equals("")){_02am++;}

			if(data.getVisualcheckofudrainsforstock1_06am()!=null&&!data.getVisualcheckofudrainsforstock1_06am().equals("")){_06am++;}
			if(data.getVisualcheckofudrainsforstock2_06am()!=null&&!data.getVisualcheckofudrainsforstock2_06am().equals("")){_06am++;}
			if(data.getVisualcheckofudrainsforstock3_06am()!=null&&!data.getVisualcheckofudrainsforstock3_06am().equals("")){_06am++;}
			if(data.getVisualcheckofudrainsforstock4_06am()!=null&&!data.getVisualcheckofudrainsforstock4_06am().equals("")){_06am++;}
			if(data.getVisualcheckofudrainsforstock5_06am()!=null&&!data.getVisualcheckofudrainsforstock5_06am().equals("")){_06am++;}
			if(data.getVisualcheckofudrainsforstock6_06am()!=null&&!data.getVisualcheckofudrainsforstock6_06am().equals("")){_06am++;}
			if(data.getVisualcheckofudrainsforstock7_06am()!=null&&!data.getVisualcheckofudrainsforstock7_06am().equals("")){_06am++;}
			if(data.getVisualcheckofudrainsforstock8_06am()!=null&&!data.getVisualcheckofudrainsforstock8_06am().equals("")){_06am++;}
			if(data.getVisualcheckofudrainsforstock9_06am()!=null&&!data.getVisualcheckofudrainsforstock9_06am().equals("")){_06am++;}
			if(data.getVisualcheckofudrainsforstock10_06am()!=null&&!data.getVisualcheckofudrainsforstock10_06am().equals("")){_06am++;}
			if(data.getVisualcheckofudrainsforstock11_06am()!=null&&!data.getVisualcheckofudrainsforstock11_06am().equals("")){_06am++;}
			if(data.getVisualcheckofudrainsforstock12_06am()!=null&&!data.getVisualcheckofudrainsforstock12_06am().equals("")){_06am++;}
			if(data.getVisualcheckofudrainsforstock13_06am()!=null&&!data.getVisualcheckofudrainsforstock13_06am().equals("")){_06am++;}
			if(data.getVisualcheckofudrainsforstock14_06am()!=null&&!data.getVisualcheckofudrainsforstock14_06am().equals("")){_06am++;}
			if(data.getVisualcheckofudrainsforstock15_06am()!=null&&!data.getVisualcheckofudrainsforstock15_06am().equals("")){_06am++;}
			if(data.getVisualcheckofudrainsforstock16_06am()!=null&&!data.getVisualcheckofudrainsforstock16_06am().equals("")){_06am++;}
			if(data.getVisualcheckofudrainsforstock17_06am()!=null&&!data.getVisualcheckofudrainsforstock17_06am().equals("")){_06am++;}
			if(data.getVisualcheckofudrainsforstock18_06am()!=null&&!data.getVisualcheckofudrainsforstock18_06am().equals("")){_06am++;}
			if(data.getVisualcheckofudrainsforstock19_06am()!=null&&!data.getVisualcheckofudrainsforstock19_06am().equals("")){_06am++;}
			if(data.getVisualcheckofudrainsforstock20_06am()!=null&&!data.getVisualcheckofudrainsforstock20_06am().equals("")){_06am++;}
			if(data.getTotes1_06am()!=null&&!data.getTotes1_06am().equals("")){_06am++;}
			if(data.getTotes2_06am()!=null&&!data.getTotes2_06am().equals("")){_06am++;}
			if(data.getTubeconveyordrive1_06am()!=null&&!data.getTubeconveyordrive1_06am().equals("")){_06am++;}
			if(data.getTubeconveyordrive2_06am()!=null&&!data.getTubeconveyordrive2_06am().equals("")){_06am++;}
			if(data.getTubeconveyordrive3_06am()!=null&&!data.getTubeconveyordrive3_06am().equals("")){_06am++;}
			if(data.getTubeconveyordrive4_06am()!=null&&!data.getTubeconveyordrive4_06am().equals("")){_06am++;}
			if(data.getTubeconveyordrive5_06am()!=null&&!data.getTubeconveyordrive5_06am().equals("")){_06am++;}

			
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
		List<OpRoute_5> lst= getData(sdate,edate);
		for(OpRoute_5 data:lst)
		{
			if(data.getVisualcheckofudrainsforstock1_10am()!=null&&!data.getVisualcheckofudrainsforstock1_10am().equals("")){_10am++;}
			if(data.getVisualcheckofudrainsforstock2_10am()!=null&&!data.getVisualcheckofudrainsforstock2_10am().equals("")){_10am++;}
			if(data.getVisualcheckofudrainsforstock3_10am()!=null&&!data.getVisualcheckofudrainsforstock3_10am().equals("")){_10am++;}
			if(data.getVisualcheckofudrainsforstock4_10am()!=null&&!data.getVisualcheckofudrainsforstock4_10am().equals("")){_10am++;}
			if(data.getVisualcheckofudrainsforstock5_10am()!=null&&!data.getVisualcheckofudrainsforstock5_10am().equals("")){_10am++;}
			if(data.getVisualcheckofudrainsforstock6_10am()!=null&&!data.getVisualcheckofudrainsforstock6_10am().equals("")){_10am++;}
			if(data.getVisualcheckofudrainsforstock7_10am()!=null&&!data.getVisualcheckofudrainsforstock7_10am().equals("")){_10am++;}
			if(data.getVisualcheckofudrainsforstock8_10am()!=null&&!data.getVisualcheckofudrainsforstock8_10am().equals("")){_10am++;}
			if(data.getVisualcheckofudrainsforstock9_10am()!=null&&!data.getVisualcheckofudrainsforstock9_10am().equals("")){_10am++;}
			if(data.getVisualcheckofudrainsforstock10_10am()!=null&&!data.getVisualcheckofudrainsforstock10_10am().equals("")){_10am++;}
			if(data.getVisualcheckofudrainsforstock11_10am()!=null&&!data.getVisualcheckofudrainsforstock11_10am().equals("")){_10am++;}
			if(data.getVisualcheckofudrainsforstock12_10am()!=null&&!data.getVisualcheckofudrainsforstock12_10am().equals("")){_10am++;}
			if(data.getVisualcheckofudrainsforstock13_10am()!=null&&!data.getVisualcheckofudrainsforstock13_10am().equals("")){_10am++;}
			if(data.getVisualcheckofudrainsforstock14_10am()!=null&&!data.getVisualcheckofudrainsforstock14_10am().equals("")){_10am++;}
			if(data.getVisualcheckofudrainsforstock15_10am()!=null&&!data.getVisualcheckofudrainsforstock15_10am().equals("")){_10am++;}
			if(data.getVisualcheckofudrainsforstock16_10am()!=null&&!data.getVisualcheckofudrainsforstock16_10am().equals("")){_10am++;}
			if(data.getVisualcheckofudrainsforstock17_10am()!=null&&!data.getVisualcheckofudrainsforstock17_10am().equals("")){_10am++;}
			if(data.getVisualcheckofudrainsforstock18_10am()!=null&&!data.getVisualcheckofudrainsforstock18_10am().equals("")){_10am++;}
			if(data.getVisualcheckofudrainsforstock19_10am()!=null&&!data.getVisualcheckofudrainsforstock19_10am().equals("")){_10am++;}
			if(data.getVisualcheckofudrainsforstock20_10am()!=null&&!data.getVisualcheckofudrainsforstock20_10am().equals("")){_10am++;}
			if(data.getTotes1_10am()!=null&&!data.getTotes1_10am().equals("")){_10am++;}
			if(data.getTotes2_10am()!=null&&!data.getTotes2_10am().equals("")){_10am++;}
			if(data.getTubeconveyordrive1_10am()!=null&&!data.getTubeconveyordrive1_10am().equals("")){_10am++;}
			if(data.getTubeconveyordrive2_10am()!=null&&!data.getTubeconveyordrive2_10am().equals("")){_10am++;}
			if(data.getTubeconveyordrive3_10am()!=null&&!data.getTubeconveyordrive3_10am().equals("")){_10am++;}
			if(data.getTubeconveyordrive4_10am()!=null&&!data.getTubeconveyordrive4_10am().equals("")){_10am++;}
			if(data.getTubeconveyordrive5_10am()!=null&&!data.getTubeconveyordrive5_10am().equals("")){_10am++;}
			
			if(data.getVisualcheckofudrainsforstock1_02pm()!=null&&!data.getVisualcheckofudrainsforstock1_02pm().equals("")){_02pm++;}
			if(data.getVisualcheckofudrainsforstock2_02pm()!=null&&!data.getVisualcheckofudrainsforstock2_02pm().equals("")){_02pm++;}
			if(data.getVisualcheckofudrainsforstock3_02pm()!=null&&!data.getVisualcheckofudrainsforstock3_02pm().equals("")){_02pm++;}
			if(data.getVisualcheckofudrainsforstock4_02pm()!=null&&!data.getVisualcheckofudrainsforstock4_02pm().equals("")){_02pm++;}
			if(data.getVisualcheckofudrainsforstock5_02pm()!=null&&!data.getVisualcheckofudrainsforstock5_02pm().equals("")){_02pm++;}
			if(data.getVisualcheckofudrainsforstock6_02pm()!=null&&!data.getVisualcheckofudrainsforstock6_02pm().equals("")){_02pm++;}
			if(data.getVisualcheckofudrainsforstock7_02pm()!=null&&!data.getVisualcheckofudrainsforstock7_02pm().equals("")){_02pm++;}
			if(data.getVisualcheckofudrainsforstock8_02pm()!=null&&!data.getVisualcheckofudrainsforstock8_02pm().equals("")){_02pm++;}
			if(data.getVisualcheckofudrainsforstock9_02pm()!=null&&!data.getVisualcheckofudrainsforstock9_02pm().equals("")){_02pm++;}
			if(data.getVisualcheckofudrainsforstock10_02pm()!=null&&!data.getVisualcheckofudrainsforstock10_02pm().equals("")){_02pm++;}
			if(data.getVisualcheckofudrainsforstock11_02pm()!=null&&!data.getVisualcheckofudrainsforstock11_02pm().equals("")){_02pm++;}
			if(data.getVisualcheckofudrainsforstock12_02pm()!=null&&!data.getVisualcheckofudrainsforstock12_02pm().equals("")){_02pm++;}
			if(data.getVisualcheckofudrainsforstock13_02pm()!=null&&!data.getVisualcheckofudrainsforstock13_02pm().equals("")){_02pm++;}
			if(data.getVisualcheckofudrainsforstock14_02pm()!=null&&!data.getVisualcheckofudrainsforstock14_02pm().equals("")){_02pm++;}
			if(data.getVisualcheckofudrainsforstock15_02pm()!=null&&!data.getVisualcheckofudrainsforstock15_02pm().equals("")){_02pm++;}
			if(data.getVisualcheckofudrainsforstock16_02pm()!=null&&!data.getVisualcheckofudrainsforstock16_02pm().equals("")){_02pm++;}
			if(data.getVisualcheckofudrainsforstock17_02pm()!=null&&!data.getVisualcheckofudrainsforstock17_02pm().equals("")){_02pm++;}
			if(data.getVisualcheckofudrainsforstock18_02pm()!=null&&!data.getVisualcheckofudrainsforstock18_02pm().equals("")){_02pm++;}
			if(data.getVisualcheckofudrainsforstock19_02pm()!=null&&!data.getVisualcheckofudrainsforstock19_02pm().equals("")){_02pm++;}
			if(data.getVisualcheckofudrainsforstock20_02pm()!=null&&!data.getVisualcheckofudrainsforstock20_02pm().equals("")){_02pm++;}
			if(data.getTotes1_02pm()!=null&&!data.getTotes1_02pm().equals("")){_02pm++;}
			if(data.getTotes2_02pm()!=null&&!data.getTotes2_02pm().equals("")){_02pm++;}
			if(data.getTubeconveyordrive1_02pm()!=null&&!data.getTubeconveyordrive1_02pm().equals("")){_02pm++;}
			if(data.getTubeconveyordrive2_02pm()!=null&&!data.getTubeconveyordrive2_02pm().equals("")){_02pm++;}
			if(data.getTubeconveyordrive3_02pm()!=null&&!data.getTubeconveyordrive3_02pm().equals("")){_02pm++;}
			if(data.getTubeconveyordrive4_02pm()!=null&&!data.getTubeconveyordrive4_02pm().equals("")){_02pm++;}
			if(data.getTubeconveyordrive5_02pm()!=null&&!data.getTubeconveyordrive5_02pm().equals("")){_02pm++;}

			if(data.getVisualcheckofudrainsforstock1_06pm()!=null&&!data.getVisualcheckofudrainsforstock1_06pm().equals("")){_06pm++;}
			if(data.getVisualcheckofudrainsforstock2_06pm()!=null&&!data.getVisualcheckofudrainsforstock2_06pm().equals("")){_06pm++;}
			if(data.getVisualcheckofudrainsforstock3_06pm()!=null&&!data.getVisualcheckofudrainsforstock3_06pm().equals("")){_06pm++;}
			if(data.getVisualcheckofudrainsforstock4_06pm()!=null&&!data.getVisualcheckofudrainsforstock4_06pm().equals("")){_06pm++;}
			if(data.getVisualcheckofudrainsforstock5_06pm()!=null&&!data.getVisualcheckofudrainsforstock5_06pm().equals("")){_06pm++;}
			if(data.getVisualcheckofudrainsforstock6_06pm()!=null&&!data.getVisualcheckofudrainsforstock6_06pm().equals("")){_06pm++;}
			if(data.getVisualcheckofudrainsforstock7_06pm()!=null&&!data.getVisualcheckofudrainsforstock7_06pm().equals("")){_06pm++;}
			if(data.getVisualcheckofudrainsforstock8_06pm()!=null&&!data.getVisualcheckofudrainsforstock8_06pm().equals("")){_06pm++;}
			if(data.getVisualcheckofudrainsforstock9_06pm()!=null&&!data.getVisualcheckofudrainsforstock9_06pm().equals("")){_06pm++;}
			if(data.getVisualcheckofudrainsforstock10_06pm()!=null&&!data.getVisualcheckofudrainsforstock10_06pm().equals("")){_06pm++;}
			if(data.getVisualcheckofudrainsforstock11_06pm()!=null&&!data.getVisualcheckofudrainsforstock11_06pm().equals("")){_06pm++;}
			if(data.getVisualcheckofudrainsforstock12_06pm()!=null&&!data.getVisualcheckofudrainsforstock12_06pm().equals("")){_06pm++;}
			if(data.getVisualcheckofudrainsforstock13_06pm()!=null&&!data.getVisualcheckofudrainsforstock13_06pm().equals("")){_06pm++;}
			if(data.getVisualcheckofudrainsforstock14_06pm()!=null&&!data.getVisualcheckofudrainsforstock14_06pm().equals("")){_06pm++;}
			if(data.getVisualcheckofudrainsforstock15_06pm()!=null&&!data.getVisualcheckofudrainsforstock15_06pm().equals("")){_06pm++;}
			if(data.getVisualcheckofudrainsforstock16_06pm()!=null&&!data.getVisualcheckofudrainsforstock16_06pm().equals("")){_06pm++;}
			if(data.getVisualcheckofudrainsforstock17_06pm()!=null&&!data.getVisualcheckofudrainsforstock17_06pm().equals("")){_06pm++;}
			if(data.getVisualcheckofudrainsforstock18_06pm()!=null&&!data.getVisualcheckofudrainsforstock18_06pm().equals("")){_06pm++;}
			if(data.getVisualcheckofudrainsforstock19_06pm()!=null&&!data.getVisualcheckofudrainsforstock19_06pm().equals("")){_06pm++;}
			if(data.getVisualcheckofudrainsforstock20_06pm()!=null&&!data.getVisualcheckofudrainsforstock20_06pm().equals("")){_06pm++;}
			if(data.getTotes1_06pm()!=null&&!data.getTotes1_06pm().equals("")){_06pm++;}
			if(data.getTotes2_06pm()!=null&&!data.getTotes2_06pm().equals("")){_06pm++;}
			if(data.getTubeconveyordrive1_06pm()!=null&&!data.getTubeconveyordrive1_06pm().equals("")){_06pm++;}
			if(data.getTubeconveyordrive2_06pm()!=null&&!data.getTubeconveyordrive2_06pm().equals("")){_06pm++;}
			if(data.getTubeconveyordrive3_06pm()!=null&&!data.getTubeconveyordrive3_06pm().equals("")){_06pm++;}
			if(data.getTubeconveyordrive4_06pm()!=null&&!data.getTubeconveyordrive4_06pm().equals("")){_06pm++;}
			if(data.getTubeconveyordrive5_06pm()!=null&&!data.getTubeconveyordrive5_06pm().equals("")){_06pm++;}

			if(data.getVisualcheckofudrainsforstock1_10pm()!=null&&!data.getVisualcheckofudrainsforstock1_10pm().equals("")){_10pm++;}
			if(data.getVisualcheckofudrainsforstock2_10pm()!=null&&!data.getVisualcheckofudrainsforstock2_10pm().equals("")){_10pm++;}
			if(data.getVisualcheckofudrainsforstock3_10pm()!=null&&!data.getVisualcheckofudrainsforstock3_10pm().equals("")){_10pm++;}
			if(data.getVisualcheckofudrainsforstock4_10pm()!=null&&!data.getVisualcheckofudrainsforstock4_10pm().equals("")){_10pm++;}
			if(data.getVisualcheckofudrainsforstock5_10pm()!=null&&!data.getVisualcheckofudrainsforstock5_10pm().equals("")){_10pm++;}
			if(data.getVisualcheckofudrainsforstock6_10pm()!=null&&!data.getVisualcheckofudrainsforstock6_10pm().equals("")){_10pm++;}
			if(data.getVisualcheckofudrainsforstock7_10pm()!=null&&!data.getVisualcheckofudrainsforstock7_10pm().equals("")){_10pm++;}
			if(data.getVisualcheckofudrainsforstock8_10pm()!=null&&!data.getVisualcheckofudrainsforstock8_10pm().equals("")){_10pm++;}
			if(data.getVisualcheckofudrainsforstock9_10pm()!=null&&!data.getVisualcheckofudrainsforstock9_10pm().equals("")){_10pm++;}
			if(data.getVisualcheckofudrainsforstock10_10pm()!=null&&!data.getVisualcheckofudrainsforstock10_10pm().equals("")){_10pm++;}
			if(data.getVisualcheckofudrainsforstock11_10pm()!=null&&!data.getVisualcheckofudrainsforstock11_10pm().equals("")){_10pm++;}
			if(data.getVisualcheckofudrainsforstock12_10pm()!=null&&!data.getVisualcheckofudrainsforstock12_10pm().equals("")){_10pm++;}
			if(data.getVisualcheckofudrainsforstock13_10pm()!=null&&!data.getVisualcheckofudrainsforstock13_10pm().equals("")){_10pm++;}
			if(data.getVisualcheckofudrainsforstock14_10pm()!=null&&!data.getVisualcheckofudrainsforstock14_10pm().equals("")){_10pm++;}
			if(data.getVisualcheckofudrainsforstock15_10pm()!=null&&!data.getVisualcheckofudrainsforstock15_10pm().equals("")){_10pm++;}
			if(data.getVisualcheckofudrainsforstock16_10pm()!=null&&!data.getVisualcheckofudrainsforstock16_10pm().equals("")){_10pm++;}
			if(data.getVisualcheckofudrainsforstock17_10pm()!=null&&!data.getVisualcheckofudrainsforstock17_10pm().equals("")){_10pm++;}
			if(data.getVisualcheckofudrainsforstock18_10pm()!=null&&!data.getVisualcheckofudrainsforstock18_10pm().equals("")){_10pm++;}
			if(data.getVisualcheckofudrainsforstock19_10pm()!=null&&!data.getVisualcheckofudrainsforstock19_10pm().equals("")){_10pm++;}
			if(data.getVisualcheckofudrainsforstock20_10pm()!=null&&!data.getVisualcheckofudrainsforstock20_10pm().equals("")){_10pm++;}
			if(data.getTotes1_10pm()!=null&&!data.getTotes1_10pm().equals("")){_10pm++;}
			if(data.getTotes2_10pm()!=null&&!data.getTotes2_10pm().equals("")){_10pm++;}
			if(data.getTubeconveyordrive1_10pm()!=null&&!data.getTubeconveyordrive1_10pm().equals("")){_10pm++;}
			if(data.getTubeconveyordrive2_10pm()!=null&&!data.getTubeconveyordrive2_10pm().equals("")){_10pm++;}
			if(data.getTubeconveyordrive3_10pm()!=null&&!data.getTubeconveyordrive3_10pm().equals("")){_10pm++;}
			if(data.getTubeconveyordrive4_10pm()!=null&&!data.getTubeconveyordrive4_10pm().equals("")){_10pm++;}
			if(data.getTubeconveyordrive5_10pm()!=null&&!data.getTubeconveyordrive5_10pm().equals("")){_10pm++;}

			if(data.getVisualcheckofudrainsforstock1_02am()!=null&&!data.getVisualcheckofudrainsforstock1_02am().equals("")){_02am++;}
			if(data.getVisualcheckofudrainsforstock2_02am()!=null&&!data.getVisualcheckofudrainsforstock2_02am().equals("")){_02am++;}
			if(data.getVisualcheckofudrainsforstock3_02am()!=null&&!data.getVisualcheckofudrainsforstock3_02am().equals("")){_02am++;}
			if(data.getVisualcheckofudrainsforstock4_02am()!=null&&!data.getVisualcheckofudrainsforstock4_02am().equals("")){_02am++;}
			if(data.getVisualcheckofudrainsforstock5_02am()!=null&&!data.getVisualcheckofudrainsforstock5_02am().equals("")){_02am++;}
			if(data.getVisualcheckofudrainsforstock6_02am()!=null&&!data.getVisualcheckofudrainsforstock6_02am().equals("")){_02am++;}
			if(data.getVisualcheckofudrainsforstock7_02am()!=null&&!data.getVisualcheckofudrainsforstock7_02am().equals("")){_02am++;}
			if(data.getVisualcheckofudrainsforstock8_02am()!=null&&!data.getVisualcheckofudrainsforstock8_02am().equals("")){_02am++;}
			if(data.getVisualcheckofudrainsforstock9_02am()!=null&&!data.getVisualcheckofudrainsforstock9_02am().equals("")){_02am++;}
			if(data.getVisualcheckofudrainsforstock10_02am()!=null&&!data.getVisualcheckofudrainsforstock10_02am().equals("")){_02am++;}
			if(data.getVisualcheckofudrainsforstock11_02am()!=null&&!data.getVisualcheckofudrainsforstock11_02am().equals("")){_02am++;}
			if(data.getVisualcheckofudrainsforstock12_02am()!=null&&!data.getVisualcheckofudrainsforstock12_02am().equals("")){_02am++;}
			if(data.getVisualcheckofudrainsforstock13_02am()!=null&&!data.getVisualcheckofudrainsforstock13_02am().equals("")){_02am++;}
			if(data.getVisualcheckofudrainsforstock14_02am()!=null&&!data.getVisualcheckofudrainsforstock14_02am().equals("")){_02am++;}
			if(data.getVisualcheckofudrainsforstock15_02am()!=null&&!data.getVisualcheckofudrainsforstock15_02am().equals("")){_02am++;}
			if(data.getVisualcheckofudrainsforstock16_02am()!=null&&!data.getVisualcheckofudrainsforstock16_02am().equals("")){_02am++;}
			if(data.getVisualcheckofudrainsforstock17_02am()!=null&&!data.getVisualcheckofudrainsforstock17_02am().equals("")){_02am++;}
			if(data.getVisualcheckofudrainsforstock18_02am()!=null&&!data.getVisualcheckofudrainsforstock18_02am().equals("")){_02am++;}
			if(data.getVisualcheckofudrainsforstock19_02am()!=null&&!data.getVisualcheckofudrainsforstock19_02am().equals("")){_02am++;}
			if(data.getVisualcheckofudrainsforstock20_02am()!=null&&!data.getVisualcheckofudrainsforstock20_02am().equals("")){_02am++;}
			if(data.getTotes1_02am()!=null&&!data.getTotes1_02am().equals("")){_02am++;}
			if(data.getTotes2_02am()!=null&&!data.getTotes2_02am().equals("")){_02am++;}
			if(data.getTubeconveyordrive1_02am()!=null&&!data.getTubeconveyordrive1_02am().equals("")){_02am++;}
			if(data.getTubeconveyordrive2_02am()!=null&&!data.getTubeconveyordrive2_02am().equals("")){_02am++;}
			if(data.getTubeconveyordrive3_02am()!=null&&!data.getTubeconveyordrive3_02am().equals("")){_02am++;}
			if(data.getTubeconveyordrive4_02am()!=null&&!data.getTubeconveyordrive4_02am().equals("")){_02am++;}
			if(data.getTubeconveyordrive5_02am()!=null&&!data.getTubeconveyordrive5_02am().equals("")){_02am++;}

			if(data.getVisualcheckofudrainsforstock1_06am()!=null&&!data.getVisualcheckofudrainsforstock1_06am().equals("")){_06am++;}
			if(data.getVisualcheckofudrainsforstock2_06am()!=null&&!data.getVisualcheckofudrainsforstock2_06am().equals("")){_06am++;}
			if(data.getVisualcheckofudrainsforstock3_06am()!=null&&!data.getVisualcheckofudrainsforstock3_06am().equals("")){_06am++;}
			if(data.getVisualcheckofudrainsforstock4_06am()!=null&&!data.getVisualcheckofudrainsforstock4_06am().equals("")){_06am++;}
			if(data.getVisualcheckofudrainsforstock5_06am()!=null&&!data.getVisualcheckofudrainsforstock5_06am().equals("")){_06am++;}
			if(data.getVisualcheckofudrainsforstock6_06am()!=null&&!data.getVisualcheckofudrainsforstock6_06am().equals("")){_06am++;}
			if(data.getVisualcheckofudrainsforstock7_06am()!=null&&!data.getVisualcheckofudrainsforstock7_06am().equals("")){_06am++;}
			if(data.getVisualcheckofudrainsforstock8_06am()!=null&&!data.getVisualcheckofudrainsforstock8_06am().equals("")){_06am++;}
			if(data.getVisualcheckofudrainsforstock9_06am()!=null&&!data.getVisualcheckofudrainsforstock9_06am().equals("")){_06am++;}
			if(data.getVisualcheckofudrainsforstock10_06am()!=null&&!data.getVisualcheckofudrainsforstock10_06am().equals("")){_06am++;}
			if(data.getVisualcheckofudrainsforstock11_06am()!=null&&!data.getVisualcheckofudrainsforstock11_06am().equals("")){_06am++;}
			if(data.getVisualcheckofudrainsforstock12_06am()!=null&&!data.getVisualcheckofudrainsforstock12_06am().equals("")){_06am++;}
			if(data.getVisualcheckofudrainsforstock13_06am()!=null&&!data.getVisualcheckofudrainsforstock13_06am().equals("")){_06am++;}
			if(data.getVisualcheckofudrainsforstock14_06am()!=null&&!data.getVisualcheckofudrainsforstock14_06am().equals("")){_06am++;}
			if(data.getVisualcheckofudrainsforstock15_06am()!=null&&!data.getVisualcheckofudrainsforstock15_06am().equals("")){_06am++;}
			if(data.getVisualcheckofudrainsforstock16_06am()!=null&&!data.getVisualcheckofudrainsforstock16_06am().equals("")){_06am++;}
			if(data.getVisualcheckofudrainsforstock17_06am()!=null&&!data.getVisualcheckofudrainsforstock17_06am().equals("")){_06am++;}
			if(data.getVisualcheckofudrainsforstock18_06am()!=null&&!data.getVisualcheckofudrainsforstock18_06am().equals("")){_06am++;}
			if(data.getVisualcheckofudrainsforstock19_06am()!=null&&!data.getVisualcheckofudrainsforstock19_06am().equals("")){_06am++;}
			if(data.getVisualcheckofudrainsforstock20_06am()!=null&&!data.getVisualcheckofudrainsforstock20_06am().equals("")){_06am++;}
			if(data.getTotes1_06am()!=null&&!data.getTotes1_06am().equals("")){_06am++;}
			if(data.getTotes2_06am()!=null&&!data.getTotes2_06am().equals("")){_06am++;}
			if(data.getTubeconveyordrive1_06am()!=null&&!data.getTubeconveyordrive1_06am().equals("")){_06am++;}
			if(data.getTubeconveyordrive2_06am()!=null&&!data.getTubeconveyordrive2_06am().equals("")){_06am++;}
			if(data.getTubeconveyordrive3_06am()!=null&&!data.getTubeconveyordrive3_06am().equals("")){_06am++;}
			if(data.getTubeconveyordrive4_06am()!=null&&!data.getTubeconveyordrive4_06am().equals("")){_06am++;}
			if(data.getTubeconveyordrive5_06am()!=null&&!data.getTubeconveyordrive5_06am().equals("")){_06am++;}

			
			if(_10am>=5){count++;}
			if(_02pm>=5){count++;}
			if(_06pm>=5){count++;}
			if(_10pm>=5){count++;}
			if(_02am>=5){count++;}
			if(_06am>=5){count++;}
			al.add(count);
			_10am=0;_02pm=0;_06pm=0;_10pm=0;_02am=0;_06am=0;
			count=0;
		}
		return al;
	}
}

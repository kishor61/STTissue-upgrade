/**
 *Oct 23, 2019
 *StockOperatorPM5DaoImp.java
 * TODO
 *com.st.obccPM5.dao
 *StockOperatorPM5DaoImp.java
 *Roshan Lal Tailor
 */
package com.st.obccPM5.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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

import com.st.common.CommonUtil;
import com.st.common.DatabaseUtil;
import com.st.obccPM5.model.StockOperatorPM5;

/**
 * @author sohan
 *
 */
@Repository
public class StockOperatorPM5DaoImp implements StockOperatorPM5Dao {

	@Autowired
	@Qualifier("dataSourceOBCC")
	private DataSource dataSourceQRT;
	private SimpleDateFormat dateFormat=new SimpleDateFormat("MM-dd-yyyy");
	private SimpleDateFormat fromuser=new SimpleDateFormat("yyyy-MM-dd");
	
	
	/* (non-Javadoc)
	 * @see com.st.oBcc1pm5.dao.StockOperatorPM5Dao#saveorUpdate(com.st.oBcc1pm5.model.StockOperatorPM5)
	 */
	@Override
	public void saveorUpdate(StockOperatorPM5 data) {
		
		NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(dataSourceQRT);
	 	MapSqlParameterSource paramSource=new MapSqlParameterSource();
	 	
	 	paramSource.addValue("position",data.getPosition());
		paramSource.addValue("operatorName",data.getOperatorName());
		paramSource.addValue("edate",data.getEdate());
		paramSource.addValue("crew",data.getCrew());
		paramSource.addValue("shift",data.getShift());
		paramSource.addValue("machinedown",data.isMachinedown());
		
		paramSource.addValue("fibersupplytankcol1",data.getFibersupplytankcol1());
		paramSource.addValue("fibersupplytankcol2",data.getFibersupplytankcol2());
		paramSource.addValue("fibersupplytankcol3",data.isFibersupplytankcol3());
		paramSource.addValue("fibersupplytankcol4Inbound",data.getFibersupplytankcol4Inbound());
		paramSource.addValue("fibersupplytankcol4Outbound",data.getFibersupplytankcol4Outbound());
		paramSource.addValue("fibersupplytankcol5Inbound",data.getFibersupplytankcol5Inbound());
		paramSource.addValue("fibersupplytankcol5Outbound",data.getFibersupplytankcol5Outbound());
		paramSource.addValue("fibersupplytankcol6",data.isFibersupplytankcol6());
		
		
		paramSource.addValue("mixchestcol1",data.getMixchestcol1());
		paramSource.addValue("mixchestcol2Inbound",data.getMixchestcol2Inbound());
		paramSource.addValue("mixchestcol2Outbound",data.getMixchestcol2Outbound());
		paramSource.addValue("mixchestcol3",data.isMixchestcol3());
		paramSource.addValue("mixchestcol4",data.isMixchestcol4());
		paramSource.addValue("mixchestcol5Inbound",data.getMixchestcol5Inbound());
		paramSource.addValue("mixchestcol5Outbound",data.getMixchestcol5Outbound());
		
		
		paramSource.addValue("blendchestcol1",data.getBlendchestcol1());
		paramSource.addValue("blendchestcol2",data.isBlendchestcol2());
		paramSource.addValue("blendchestcol3Inbound",data.getBlendchestcol3Inbound());
		paramSource.addValue("blendchestcol3Outbound",data.getBlendchestcol3Outbound());
		
		
		paramSource.addValue("machinechestcol1",data.getMachinechestcol1());
		paramSource.addValue("machinechestcol2",data.isMachinechestcol2());		
		paramSource.addValue("machinechestcol3Inbound",data.getMachinechestcol3Inbound());		
		paramSource.addValue("machinechestcol3Outbound",data.getMachinechestcol3Outbound());
		paramSource.addValue("machinechestcol4",data.isMachinechestcol4());
		paramSource.addValue("machinechestcol5Inbound",data.getMachinechestcol5Inbound());
		paramSource.addValue("machinechestcol5Outbound",data.getMachinechestcol5Outbound());
		
		
		
		paramSource.addValue("couchpitcol1",data.isCouchpitcol1());
		paramSource.addValue("couchpitcol2Inbound",data.getCouchpitcol2Inbound());
		paramSource.addValue("couchpitcol2Outbound",data.getCouchpitcol2Outbound());
		paramSource.addValue("couchpitcol3",data.isCouchpitcol3());
		paramSource.addValue("couchpitcol4Inbound",data.getCouchpitcol4Inbound());
		paramSource.addValue("couchpitcol4Outbound",data.getCouchpitcol4Outbound());
		paramSource.addValue("couchpitcol5Inbound",data.getCouchpitcol5Inbound());
		paramSource.addValue("couchpitcol5Outbound",data.getCouchpitcol5Outbound());
		paramSource.addValue("couchpitcol6",data.isCouchpitcol6());
		
		
		
		
		
		paramSource.addValue("fibersupplytankcol1Desc",data.getFibersupplytankcol1Desc());
		paramSource.addValue("fibersupplytankcol2Desc",data.getFibersupplytankcol2Desc());
		paramSource.addValue("fibersupplytankcol3Desc",data.getFibersupplytankcol3Desc());
		paramSource.addValue("fibersupplytankcol4Desc",data.getFibersupplytankcol4Desc());
		paramSource.addValue("fibersupplytankcolDesc",data.getFibersupplytankcol4Desc());
		paramSource.addValue("fibersupplytankcol5Desc",data.getFibersupplytankcol5Desc());
		paramSource.addValue("fibersupplytankcol5Desc",data.getFibersupplytankcol5Desc());
		paramSource.addValue("fibersupplytankcol6Desc",data.getFibersupplytankcol6Desc());
		
		
		paramSource.addValue("mixchestcol1Desc",data.getMixchestcol1Desc());
		paramSource.addValue("mixchestcol2Desc",data.getMixchestcol2Desc());
		paramSource.addValue("mixchestcol2Desc",data.getMixchestcol2Desc());
		paramSource.addValue("mixchestcol3Desc",data.getMixchestcol3Desc());
		paramSource.addValue("mixchestcol4Desc",data.getMixchestcol4Desc());
		paramSource.addValue("mixchestcol5Desc",data.getMixchestcol5Desc());
		paramSource.addValue("mixchestcol5Desc",data.getMixchestcol5Desc());
		
		
		paramSource.addValue("blendchestcol1Desc",data.getBlendchestcol1Desc());
		paramSource.addValue("blendchestcol2Desc",data.getBlendchestcol2Desc());
		paramSource.addValue("blendchestcol3Desc",data.getBlendchestcol3Desc());
		
		
		paramSource.addValue("machinechestcol1Desc",data.getMachinechestcol1Desc());
		paramSource.addValue("machinechestcol2Desc",data.getMachinechestcol2Desc());		
		paramSource.addValue("machinechestcol3Desc",data.getMachinechestcol3Desc());		
		paramSource.addValue("machinechestcol3Desc",data.getMachinechestcol3Desc());
		paramSource.addValue("machinechestcol4Desc",data.getMachinechestcol4Desc());
		paramSource.addValue("machinechestcol5Desc",data.getMachinechestcol5Desc());
		paramSource.addValue("machinechestcol5Desc",data.getMachinechestcol5Desc());
		
		
		paramSource.addValue("couchpitcol1Desc",data.getCouchpitcol1Desc());
		paramSource.addValue("couchpitcol2Desc",data.getCouchpitcol2Desc());
		paramSource.addValue("couchpitcol2Desc",data.getCouchpitcol2Desc());
		paramSource.addValue("couchpitcol3Desc",data.getCouchpitcol3Desc());
		paramSource.addValue("couchpitcol4Desc",data.getCouchpitcol4Desc());
		paramSource.addValue("couchpitcol4Desc",data.getCouchpitcol4Desc());
		paramSource.addValue("couchpitcol5Desc",data.getCouchpitcol5Desc());
		paramSource.addValue("couchpitcol6Desc",data.getCouchpitcol6Desc());
		
		paramSource.addValue("cleanscannerheadcol1",data.isCleanscannerheadcol1());
		paramSource.addValue("cleanscannerheadcol1Desc",data.getCleanscannerheadcol1Desc());
		paramSource.addValue("spoolstarterworkingproperlycol1",data.isSpoolstarterworkingproperlycol1());
		paramSource.addValue("spoolstarterworkingproperlycol1Desc",data.getSpoolstarterworkingproperlycol1Desc());
		paramSource.addValue("beakpassacceptablecol1",data.isBeakpassacceptablecol1());
		paramSource.addValue("beakpassacceptablecol1Desc",data.getBeakpassacceptablecol1Desc());
		
		paramSource.addValue("refiner1col1",data.isRefiner1col1());
		paramSource.addValue("refiner1col1Desc",data.getRefiner1col1Desc());
		paramSource.addValue("refiner1col2Inbound",data.getRefiner1col2Inbound());
		paramSource.addValue("refiner1col2Outbound",data.getRefiner1col2Outbound());
		paramSource.addValue("refiner1col2Desc",data.getRefiner1col2Desc());
		paramSource.addValue("refiner1col3",data.getRefiner1col3());
		paramSource.addValue("refiner1col3Desc",data.getRefiner1col3Desc());
		paramSource.addValue("refiner1col4",data.getRefiner1col4());
		paramSource.addValue("refiner1col4Desc",data.getRefiner1col4Desc());
		paramSource.addValue("refiner2col1",data.isRefiner2col1());
		paramSource.addValue("refiner2col1Desc",data.getRefiner2col1Desc());
		paramSource.addValue("refiner2col2Inbound",data.getRefiner2col2Inbound());
		paramSource.addValue("refiner2col2Outbound",data.getRefiner2col2Outbound());
		paramSource.addValue("refiner2col2Desc",data.getRefiner2col2Desc());
		paramSource.addValue("refiner2col3",data.getRefiner2col3());
		paramSource.addValue("refiner2col3Desc",data.getRefiner2col3Desc());
		paramSource.addValue("refiner2col4",data.getRefiner2col4());
		paramSource.addValue("refiner2col4Desc",data.getRefiner2col4Desc());
		paramSource.addValue("whitewaterpumpscol1",data.isWhitewaterpumpscol1());
		paramSource.addValue("whitewaterpumpscol1Desc",data.getWhitewaterpumpscol1Desc());
		paramSource.addValue("whitewaterpumpscol2Inbound",data.getWhitewaterpumpscol2Inbound());
		paramSource.addValue("whitewaterpumpscol2Outbound",data.getWhitewaterpumpscol2Outbound());
		paramSource.addValue("whitewaterpumpscol2Desc",data.getWhitewaterpumpscol2Desc());
		paramSource.addValue("whitewaterpumpscol3",data.isWhitewaterpumpscol3());
		paramSource.addValue("whitewaterpumpscol3Desc",data.getWhitewaterpumpscol3Desc());
		paramSource.addValue("whitewaterpumpscol4Inbound",data.getWhitewaterpumpscol4Inbound());
		paramSource.addValue("whitewaterpumpscol4Outbound",data.getWhitewaterpumpscol4Outbound());
		paramSource.addValue("whitewaterpumpscol4Desc",data.getWhitewaterpumpscol4Desc());
		paramSource.addValue("whitewaterpumpscol5",data.getWhitewaterpumpscol5());
		paramSource.addValue("whitewaterpumpscol5Desc",data.getWhitewaterpumpscol5Desc());
		paramSource.addValue("whitewaterpumpscol6",data.getWhitewaterpumpscol6());
		paramSource.addValue("whitewaterpumpscol6Desc",data.getWhitewaterpumpscol6Desc());
		paramSource.addValue("whitewaterpumpscol7",data.getWhitewaterpumpscol7());
		paramSource.addValue("whitewaterpumpscol7Desc",data.getWhitewaterpumpscol7Desc());
		paramSource.addValue("yankeepulpercol1",data.isYankeepulpercol1());
		paramSource.addValue("yankeepulpercol1Desc",data.getYankeepulpercol1Desc());
		paramSource.addValue("yankeepulpercol2Inbound",data.getYankeepulpercol2Inbound());
		paramSource.addValue("yankeepulpercol2Outbound",data.getYankeepulpercol2Outbound());
		paramSource.addValue("yankeepulpercol2Desc",data.getYankeepulpercol2Desc());
		paramSource.addValue("yankeepulpercol3",data.isYankeepulpercol3());
		paramSource.addValue("yankeepulpercol3Desc",data.getYankeepulpercol3Desc());
		paramSource.addValue("yankeepulpercol4Inbound",data.getYankeepulpercol4Inbound());
		paramSource.addValue("yankeepulpercol4Outbound",data.getYankeepulpercol4Outbound());
		paramSource.addValue("yankeepulpercol4Desc",data.getYankeepulpercol4Desc());
		paramSource.addValue("yankeepulpercol5",data.isYankeepulpercol5());
		paramSource.addValue("yankeepulpercol5Desc",data.getYankeepulpercol5Desc());
		paramSource.addValue("yankeepulpercol6Inbound",data.getYankeepulpercol6Inbound());
		paramSource.addValue("yankeepulpercol6Outbound",data.getYankeepulpercol6Outbound());
		paramSource.addValue("yankeepulpercol6Desc",data.getYankeepulpercol6Desc());
		paramSource.addValue("borkechestcol1",data.isBorkechestcol3());
		paramSource.addValue("borkechestcol1Desc",data.getBorkechestcol1Desc());
		paramSource.addValue("borkechestcol2Inbound",data.getBorkechestcol2Inbound());
		paramSource.addValue("borkechestcol2Outbound",data.getBorkechestcol2Outbound());
		paramSource.addValue("borkechestcol2Desc",data.getBorkechestcol2Desc());
		paramSource.addValue("borkechestcol3",data.isBorkechestcol3());
		paramSource.addValue("borkechestcol3Desc",data.getBorkechestcol3Desc());
		paramSource.addValue("borkechestcol4Inbound",data.getBorkechestcol4Inbound());
		paramSource.addValue("borkechestcol4Outbound",data.getBorkechestcol4Outbound());
		paramSource.addValue("borkechestcol4Desc",data.getBorkechestcol4Desc());
		paramSource.addValue("saveallcol1",data.getSaveallcol1());
		paramSource.addValue("saveallcol1Desc",data.getSaveallcol1Desc());
		paramSource.addValue("saveallcol2",data.getSaveallcol2());
		paramSource.addValue("saveallcol2Desc",data.getSaveallcol2Desc());
		paramSource.addValue("saveallcol3",data.isSaveallcol3());
		paramSource.addValue("saveallcol3Desc",data.getSaveallcol3Desc());
		paramSource.addValue("saveallcol4Inbound",data.getSaveallcol4Inbound());
		paramSource.addValue("saveallcol4Outbound",data.getSaveallcol4Outbound());
		paramSource.addValue("saveallcol4Desc",data.getSaveallcol4Desc());
		paramSource.addValue("sydrapulpercol1Inbound",data.getSydrapulpercol1Inbound());
		paramSource.addValue("sydrapulpercol1Outbound",data.getSydrapulpercol1Outbound());
		paramSource.addValue("sydrapulpercol1Desc",data.getSydrapulpercol1Desc());
		paramSource.addValue("sydrapulpercol2",data.getSydrapulpercol2());
		paramSource.addValue("sydrapulpercol2Desc",data.getSydrapulpercol2Desc());
		paramSource.addValue("sydrapulpercol3",data.isSydrapulpercol3());
		paramSource.addValue("sydrapulpercol3Desc",data.getSydrapulpercol3Desc());
		paramSource.addValue("sydrapulpercol4Inbound",data.getSydrapulpercol4Inbound());
		paramSource.addValue("sydrapulpercol4Outbound",data.getSydrapulpercol4Outbound());
		paramSource.addValue("sydrapulpercol4Desc",data.getSydrapulpercol4Desc());
		paramSource.addValue("sydrapulpercol5",data.getSydrapulpercol5());
		paramSource.addValue("sydrapulpercol5Desc",data.getSydrapulpercol5Desc());
	
		
		
		if (data.getId() == 0) {	
			
			String sql=DatabaseUtil.getSQL("sql/insertStockoperator_pm5.sql");
			jdbcTemplate.update(sql, paramSource);
		}	
		else
		{
			System.out.println("i am in stock else part");
			paramSource.addValue("id",data.getId());
			String sql=DatabaseUtil.getSQL("sql/updateStockOperator_pm5.sql");
			jdbcTemplate.update(sql, paramSource);
		}
		
	}


	
	@Override
	public List<StockOperatorPM5> getStockOperatorPm5DataList(String position,String startDate, String endDate, String shift) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSourceQRT);
		String sql = "select * from [StockOperator_PM5] where position=? AND shift=? AND date BETWEEN ? AND ? ";
		List<StockOperatorPM5> stockOperatorPM5=new ArrayList<StockOperatorPM5>();
		try {
			
			stockOperatorPM5=jdbcTemplate.query(sql, new Object[]{ position,shift,startDate,endDate},new RowMapper<StockOperatorPM5>(){
			
				@Override
				public StockOperatorPM5 mapRow(ResultSet rs, int arg1)
						throws SQLException {
					StockOperatorPM5 data=new StockOperatorPM5();
					try {
						String newDate = dateFormat.format(fromuser.parse(rs.getString("date")));
						
						data.setId(rs.getInt("id"));
						data.setPosition(rs.getString("position"));
						data.setOperatorName(rs.getString("operatorname"));
						data.setEdate(newDate);
						data.setCrew(rs.getString("crew"));
						data.setShift(rs.getString("shift"));
						data.setMachinedown(rs.getBoolean("machinedown"));
						data.setFibersupplytankcol1(rs.getString("fibersupplytankcol1"));
						data.setFibersupplytankcol2(rs.getString("fibersupplytankcol2"));
						data.setFibersupplytankcol3(rs.getBoolean("fibersupplytankcol3"));
						data.setFibersupplytankcol4Inbound(rs.getString("fibersupplytankcol4Inbound"));
						data.setFibersupplytankcol4Outbound(rs.getString("fibersupplytankcol4Outbound"));
						data.setFibersupplytankcol5Inbound(rs.getString("fibersupplytankcol5Inbound"));
						data.setFibersupplytankcol5Outbound(rs.getString("fibersupplytankcol5Outbound"));
						data.setFibersupplytankcol6(rs.getBoolean("fibersupplytankcol6"));
						
						data.setMixchestcol1(rs.getString("mixchestcol1"));
						data.setMixchestcol2Inbound(rs.getString("mixchestcol2Inbound"));
						data.setMixchestcol2Outbound(rs.getString("mixchestcol2Outbound"));
						data.setMixchestcol3(rs.getBoolean("mixchestcol3"));
						data.setMixchestcol4(rs.getBoolean("mixchestcol4"));
						data.setMixchestcol5Inbound(rs.getString("mixchestcol5Inbound"));
						data.setMixchestcol5Outbound(rs.getString("mixchestcol5Outbound"));
						
						data.setBlendchestcol1(rs.getString("blendchestcol1"));
						data.setBlendchestcol2(rs.getBoolean("blendchestcol2"));
						data.setBlendchestcol3Inbound(rs.getString("blendchestcol3Inbound"));
						data.setBlendchestcol3Outbound(rs.getString("blendchestcol3Outbound"));
						
						data.setMachinechestcol1(rs.getString("machinechestcol1"));
						data.setMachinechestcol2(rs.getBoolean("machinechestcol2"));
						data.setMachinechestcol3Inbound(rs.getString("machinechestcol3Inbound"));
						data.setMachinechestcol3Outbound(rs.getString("machinechestcol3Outbound"));
						data.setMachinechestcol4(rs.getBoolean("machinechestcol4"));
						data.setMachinechestcol5Inbound(rs.getString("machinechestcol5Inbound"));
						data.setMachinechestcol5Outbound(rs.getString("machinechestcol5Outbound"));
			
						
						data.setCouchpitcol1(rs.getBoolean("couchpitcol1"));
						data.setCouchpitcol2Inbound(rs.getString("couchpitcol2Inbound"));
						data.setCouchpitcol2Outbound(rs.getString("couchpitcol2Outbound"));
						data.setCouchpitcol3(rs.getBoolean("couchpitcol3"));
						data.setCouchpitcol4Inbound(rs.getString("couchpitcol4Inbound"));
						data.setCouchpitcol4Outbound(rs.getString("couchpitcol4Outbound"));
						data.setCouchpitcol5Inbound(rs.getString("couchpitcol5Inbound"));
						data.setCouchpitcol5Outbound(rs.getString("couchpitcol5Outbound"));
						data.setCouchpitcol6(rs.getBoolean("couchpitcol6"));
						
					
						
						data.setFibersupplytankcol1Desc(rs.getString("fibersupplytankcol1Desc"));
						data.setFibersupplytankcol2Desc(rs.getString("fibersupplytankcol2Desc"));
						data.setFibersupplytankcol3Desc(rs.getString("fibersupplytankcol3Desc"));
						data.setFibersupplytankcol4Desc(rs.getString("fibersupplytankcol4Desc"));
						data.setFibersupplytankcol5Desc(rs.getString("fibersupplytankcol5Desc"));
						data.setFibersupplytankcol6Desc(rs.getString("fibersupplytankcol6Desc"));
						
						data.setMixchestcol1Desc(rs.getString("mixchestcol1Desc"));
						data.setMixchestcol2Desc(rs.getString("mixchestcol2Desc"));
						data.setMixchestcol3Desc(rs.getString("mixchestcol3Desc"));
						data.setMixchestcol4Desc(rs.getString("mixchestcol4Desc"));
						data.setMixchestcol5Desc(rs.getString("mixchestcol5Desc"));
						
						data.setBlendchestcol1Desc(rs.getString("blendchestcol1Desc"));
						data.setBlendchestcol2Desc(rs.getString("blendchestcol2Desc"));
						data.setBlendchestcol3Desc(rs.getString("blendchestcol3Desc"));
						
						data.setMachinechestcol1Desc(rs.getString("machinechestcol1Desc"));
						data.setMachinechestcol2Desc(rs.getString("machinechestcol2Desc"));
						data.setMachinechestcol3Desc(rs.getString("machinechestcol3Desc"));
						data.setMachinechestcol4Desc(rs.getString("machinechestcol4Desc"));
						data.setMachinechestcol5Desc(rs.getString("machinechestcol5Desc"));
										

						data.setCouchpitcol1Desc(rs.getString("couchpitcol1Desc"));
						data.setCouchpitcol2Desc(rs.getString("couchpitcol2Desc"));
						data.setCouchpitcol3Desc(rs.getString("couchpitcol3Desc"));
						data.setCouchpitcol4Desc(rs.getString("couchpitcol4Desc"));
						data.setCouchpitcol5Desc(rs.getString("couchpitcol5Desc"));
						data.setCouchpitcol6Desc(rs.getString("couchpitcol6Desc"));
						
						data.setCleanscannerheadcol1(rs.getBoolean("cleanscannerheadcol1"));
						data.setSpoolstarterworkingproperlycol1(rs.getBoolean("spoolstarterworkingproperlycol1"));
						data.setBeakpassacceptablecol1(rs.getBoolean("beakpassacceptablecol1"));
						data.setCleanscannerheadcol1Desc(rs.getString("cleanscannerheadcol1Desc"));
						data.setSpoolstarterworkingproperlycol1Desc(rs.getString("spoolstarterworkingproperlycol1Desc"));						
						data.setBeakpassacceptablecol1Desc(rs.getString("beakpassacceptablecol1Desc"));
						
								data.setRefiner1col1(rs.getBoolean("refiner1col1"));
								data.setRefiner1col1Desc(rs.getString("refiner1col1Desc"));
								data.setRefiner1col2Inbound(rs.getString("refiner1col2Inbound"));
								data.setRefiner1col2Outbound(rs.getString("refiner1col2Outbound"));
								data.setRefiner1col2Desc(rs.getString("refiner1col2Desc"));
								data.setRefiner1col3(rs.getString("refiner1col3"));
								data.setRefiner1col3Desc(rs.getString("refiner1col3Desc"));
								data.setRefiner1col4(rs.getString("refiner1col4"));
								data.setRefiner1col4Desc(rs.getString("refiner1col4Desc"));
								data.setRefiner2col1(rs.getBoolean("refiner2col1"));
								data.setRefiner2col1Desc(rs.getString("refiner2col1Desc"));
								data.setRefiner2col2Inbound(rs.getString("refiner2col2Inbound"));
								data.setRefiner2col2Outbound(rs.getString("refiner2col2Outbound"));
								data.setRefiner2col2Desc(rs.getString("refiner2col2Desc"));
								data.setRefiner2col3(rs.getString("refiner2col3"));
								data.setRefiner2col3Desc(rs.getString("refiner2col3Desc"));
								data.setRefiner2col4(rs.getString("refiner2col4"));
								data.setRefiner2col4Desc(rs.getString("refiner2col4Desc"));
								data.setWhitewaterpumpscol1(rs.getBoolean("whitewaterpumpscol1"));
								data.setWhitewaterpumpscol1Desc(rs.getString("whitewaterpumpscol1Desc"));
								data.setWhitewaterpumpscol2Inbound(rs.getString("whitewaterpumpscol2Inbound"));
								data.setWhitewaterpumpscol2Outbound(rs.getString("whitewaterpumpscol2Outbound"));
								data.setWhitewaterpumpscol2Desc(rs.getString("whitewaterpumpscol2Desc"));
								data.setWhitewaterpumpscol3(rs.getBoolean("whitewaterpumpscol3"));
								data.setWhitewaterpumpscol3Desc(rs.getString("whitewaterpumpscol3Desc"));
								data.setWhitewaterpumpscol4Inbound(rs.getString("whitewaterpumpscol4Inbound"));
								data.setWhitewaterpumpscol4Outbound(rs.getString("wwhitewaterpumpscol4Outbound"));
								data.setWhitewaterpumpscol4Desc(rs.getString("whitewaterpumpscol4Desc"));
								data.setWhitewaterpumpscol5(rs.getString("whitewaterpumpscol5"));
								data.setWhitewaterpumpscol5Desc(rs.getString("whitewaterpumpscol5Desc"));
								data.setWhitewaterpumpscol6(rs.getString("whitewaterpumpscol6"));
								data.setWhitewaterpumpscol6Desc(rs.getString("whitewaterpumpscol6Desc"));
								data.setWhitewaterpumpscol7(rs.getString("whitewaterpumpscol7"));
								data.setWhitewaterpumpscol7Desc(rs.getString("whitewaterpumpscol7Desc"));
								data.setYankeepulpercol1(rs.getBoolean("yankeepulpercol1"));
								data.setYankeepulpercol1Desc(rs.getString("yankeepulpercol1Desc"));
								data.setYankeepulpercol2Inbound(rs.getString("yankeepulpercol2Inbound"));
								data.setYankeepulpercol2Outbound(rs.getString("yankeepulpercol2Outbound"));
								data.setYankeepulpercol2Desc(rs.getString("yankeepulpercol2Desc"));
								data.setYankeepulpercol3(rs.getBoolean("yankeepulpercol3"));
								data.setYankeepulpercol3Desc(rs.getString("yankeepulpercol3Desc"));
								data.setYankeepulpercol4Inbound(rs.getString("yankeepulpercol4Inbound"));
								data.setYankeepulpercol4Outbound(rs.getString("yankeepulpercol4Outbound"));
								data.setYankeepulpercol4Desc(rs.getString("yankeepulpercol4Desc"));
								data.setYankeepulpercol5(rs.getBoolean("yankeepulpercol5"));
								data.setYankeepulpercol5Desc(rs.getString("yankeepulpercol5Desc"));
								data.setYankeepulpercol6Inbound(rs.getString("yankeepulpercol6Inbound"));
								data.setYankeepulpercol6Outbound(rs.getString("yankeepulpercol6Outbound"));
								data.setYankeepulpercol6Desc(rs.getString("yankeepulpercol6Desc"));
								data.setBorkechestcol1(rs.getBoolean("borkechestcol1"));
								data.setBorkechestcol1Desc(rs.getString("borkechestcol1Desc"));
								data.setBorkechestcol2Inbound(rs.getString("borkechestcol2Inbound"));
								data.setBorkechestcol2Outbound(rs.getString("borkechestcol2Outbound"));
								data.setBorkechestcol2Desc(rs.getString("borkechestcol2Desc"));
								data.setBorkechestcol3(rs.getBoolean("borkechestcol3"));
								data.setBorkechestcol3Desc(rs.getString("borkechestcol3Desc"));
								data.setBorkechestcol4Inbound(rs.getString("borkechestcol4Inbound"));
								data.setBorkechestcol4Outbound(rs.getString("borkechestcol4Outbound"));
								data.setBorkechestcol4Desc(rs.getString("borkechestcol4Desc"));
								data.setSaveallcol1(rs.getString("saveallcol1"));
								data.setSaveallcol1Desc(rs.getString("saveallcol1Desc"));
								data.setSaveallcol2(rs.getString("saveallcol2"));
								data.setSaveallcol2Desc(rs.getString("saveallcol2Desc"));
								data.setSaveallcol3(rs.getBoolean("saveallcol3"));
								data.setSaveallcol3Desc(rs.getString("saveallcol3Desc"));
								data.setSaveallcol4Inbound(rs.getString("saveallcol4Inbound"));
								data.setSaveallcol4Outbound(rs.getString("saveallcol4Outbound"));
								data.setSaveallcol4Desc(rs.getString("saveallcol4Desc"));
								data.setSydrapulpercol1Inbound(rs.getString("sydrapulpercol1Inbound"));
								data.setSydrapulpercol1Outbound(rs.getString("sydrapulpercol1Outbound"));
								data.setSydrapulpercol1Desc(rs.getString("sydrapulpercol1Desc"));
								data.setSydrapulpercol2(rs.getString("sydrapulpercol2"));
								data.setSydrapulpercol2Desc(rs.getString("sydrapulpercol2Desc"));
								data.setSydrapulpercol3(rs.getBoolean("sydrapulpercol3"));
								data.setSydrapulpercol3Desc(rs.getString("sydrapulpercol3Desc"));
								data.setSydrapulpercol4Inbound(rs.getString("sydrapulpercol4Inbound"));
								data.setSydrapulpercol4Outbound(rs.getString("sydrapulpercol4Outbound"));
								data.setSydrapulpercol1Desc(rs.getString("sydrapulpercol4Desc"));
								data.setSydrapulpercol1Desc(rs.getString("sydrapulpercol5"));
								data.setSydrapulpercol1Desc(rs.getString("sydrapulpercol5Desc"));
						
						
					} catch (Exception e) {
						// TODO: handle exception
					}

					return data;
				}
				
			});
		} catch (Exception e) {
			System.out.println(e);
		}
		return stockOperatorPM5;
	}

	/* (non-Javadoc)
	 * @see com.st.oBcc1pm5.dao.StockOperatorPM5Dao#getDataCountDatePercentage(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public long getDataCountDatePercentage(String position, String sdate,String edate,String shift) throws ParseException {
		SimpleDateFormat format=new SimpleDateFormat("MM-dd-yyyy");
		
		List<StockOperatorPM5> daydata=null, nightdata=null;
		if(shift.equals("both"))
		{
			 daydata=getStockOperatorPm5DataList(position,sdate,edate,"day");
			 nightdata=getStockOperatorPm5DataList(position,sdate,edate,"night");
		}else if(shift.equals("day"))
		{
			daydata=getStockOperatorPm5DataList(position,sdate,edate,"day");
		}
		else
		{
			nightdata=getStockOperatorPm5DataList(position,sdate,edate,"night");
		}
			
		
		int count=0,no=0;long set=0,daypercent=0,nightpercent=0,percentage=0;
		int days = CommonUtil.getDaysDiffernce(format.parse(sdate), format.parse(edate))+1;
		List<Integer> al=new ArrayList<Integer>();
		List<Integer> al2=new ArrayList<Integer>();
	if(daydata!=null||nightdata!=null)	
	{
		if(shift.equals("day")||shift.equals("both"))
		{
			for(StockOperatorPM5 data:daydata)
			{
			if(data.isMachinedown()!=true)
			{				
				if(data.getFibersupplytankcol1()!=null&&!data.getFibersupplytankcol1().equals("")){count++;}
				if(data.getFibersupplytankcol2()!=null&&!data.getFibersupplytankcol2().equals("")){count++;}
				
				if(data.isFibersupplytankcol3()==true||data.isFibersupplytankcol3()==false){ count++; }
				
				if(data.getFibersupplytankcol4Inbound()!=null&&!data.getFibersupplytankcol4Inbound().equals("")){count++;}
				if(data.getFibersupplytankcol4Outbound()!=null&&!data.getFibersupplytankcol4Outbound().equals("")){count++;}
				if(data.getFibersupplytankcol5Inbound()!=null&&!data.getFibersupplytankcol5Inbound().equals("")){count++;}
				if(data.getFibersupplytankcol5Outbound()!=null&&!data.getFibersupplytankcol5Outbound().equals("")){count++;}
				
				if(data.isFibersupplytankcol6()==true||data.isFibersupplytankcol6()==false)
				{
					count++;
				}
				
				if(data.getMixchestcol1()!=null&&!data.getMixchestcol1().equals("")){count++;}
				if(data.getMixchestcol2Inbound()!=null&&!data.getMixchestcol2Inbound().equals("")){count++;}
				if(data.getMixchestcol2Outbound()!=null&&!data.getMixchestcol2Outbound().equals("")){count++;}
				if(data.isMixchestcol3()==true||data.isMixchestcol3()==false)
				{
					 count++;
				}
				if(data.isMixchestcol4()==true||data.isMixchestcol4()==false)
				{
					count++;
				}
				if(data.getMixchestcol5Inbound()!=null&&!data.getMixchestcol5Inbound().equals("")){count++;}
				if(data.getMixchestcol5Outbound()!=null&&!data.getMixchestcol5Outbound().equals("")){count++;}
				if(data.getBlendchestcol1()!=null&&!data.getBlendchestcol1().equals("")){count++;}
				if(data.isBlendchestcol2()==true||data.isBlendchestcol2()==false)
				{
					 count++;
				}
				if(data.getBlendchestcol3Inbound()!=null&&!data.getBlendchestcol3Inbound().equals("")){count++;}
				if(data.getBlendchestcol3Outbound()!=null&&!data.getBlendchestcol3Outbound().equals("")){count++;}
				if(data.getMachinechestcol1()!=null&&!data.getMachinechestcol1().equals("")){count++;}
				if(data.isMachinechestcol2()==true||data.isMachinechestcol2()==false)
				{
					 count++;
				}
				if(data.getMachinechestcol3Inbound()!=null&&!data.getMachinechestcol3Inbound().equals("")){count++;}
				if(data.getMachinechestcol3Outbound()!=null&&!data.getMachinechestcol3Outbound().equals("")){count++;}
				if(data.isMachinechestcol4()==true||data.isMachinechestcol4()==false)
				{
					 count++;
				}
				if(data.getMachinechestcol5Inbound()!=null&&!data.getMachinechestcol5Inbound().equals("")){count++;}
				if(data.getMachinechestcol5Outbound()!=null&&!data.getMachinechestcol5Outbound().equals("")){count++;}
				if(data.isCouchpitcol1()==true||data.isCouchpitcol1()==false)
				{
					 count++;
				}
				if(data.getCouchpitcol2Inbound()!=null&&!data.getCouchpitcol2Inbound().equals("")){count++;}
				if(data.getCouchpitcol2Outbound()!=null&&!data.getCouchpitcol2Outbound().equals("")){count++;}
				if(data.isCouchpitcol3()==true||data.isCouchpitcol3()==false)
				{
					count++;
				}
				if(data.getCouchpitcol4Inbound()!=null&&!data.getCouchpitcol4Inbound().equals("")){count++;}
				if(data.getCouchpitcol4Outbound()!=null&&!data.getCouchpitcol4Outbound().equals("")){count++;}
				if(data.getCouchpitcol5Inbound()!=null&&!data.getCouchpitcol5Inbound().equals("")){count++;}
				if(data.getCouchpitcol5Outbound()!=null&&!data.getCouchpitcol5Outbound().equals("")){count++;}
				if(data.isCouchpitcol6()==true||data.isCouchpitcol6()==false)
				{
					count++;
				}
				if(data.isCleanscannerheadcol1()==true||data.isCleanscannerheadcol1()==false)
				{
					 count++;
				}
				if(data.isSpoolstarterworkingproperlycol1()==true||data.isSpoolstarterworkingproperlycol1()==false)
				{
					 count++;
				}
				if(data.isBeakpassacceptablecol1()==true||data.isBeakpassacceptablecol1()==false)
				{
					count++;
				}
			}
			else
			count=6;
			al.add(count);
			count=0;
		}
			for(int n:al)
			{
				if(n>=5)
				{
					set=set+100;
				}
			}
			daypercent=set/days;
			no++;
		}
		if(shift.equals("night")||shift.equals("both")) {
			 set=0;
			 for(StockOperatorPM5 data:nightdata){
					
				if(data.isMachinedown()!=true)
				{	
					if(data.isRefiner1col1()==true||data.isRefiner1col1()==false)
					{
						 count++;
					}		
					if(data.getRefiner1col2Inbound()!=null&&!data.getRefiner1col2Inbound().equals("")){ count++;}
					if(data.getRefiner1col2Outbound()!=null&&!data.getRefiner1col2Outbound().equals("")){ count++;}
					if(data.getRefiner1col3()!=null&&!data.getRefiner1col3().equals("")){ count++;}
					if(data.getRefiner1col4()!=null&&!data.getRefiner1col4().equals("")){ count++;}
					if(data.isRefiner2col1()==true||data.isRefiner2col1()==false)
					{
						 count++;
					} if(data.getRefiner2col2Inbound()!=null&&!data.getRefiner2col2Inbound().equals("")){ count++;}
					 if(data.getRefiner2col2Outbound()!=null&&!data.getRefiner2col2Outbound().equals("")){ count++;}
					if(data.getRefiner2col3()!=null&&!data.getRefiner2col3().equals("")){ count++;}
					if(data.getRefiner2col4()!=null&&!data.getRefiner2col4().equals("")){ count++;}
					if(data.isWhitewaterpumpscol1()==true||data.isWhitewaterpumpscol1()==false)
					{
						 count++;
					}
					 if(data.getWhitewaterpumpscol2Inbound()!=null&&!data.getWhitewaterpumpscol2Inbound().equals("")){ count++;}
					 if(data.getWhitewaterpumpscol2Outbound()!=null&&!data.getWhitewaterpumpscol2Outbound().equals("")){ count++;}
					if(data.isWhitewaterpumpscol3()==true||data.isWhitewaterpumpscol3()==false)
					{
						 count++;
					}
					 if(data.getWhitewaterpumpscol4Inbound()!=null&&!data.getWhitewaterpumpscol4Inbound().equals("")){ count++;}
					 if(data.getWhitewaterpumpscol4Outbound()!=null&&!data.getWhitewaterpumpscol4Outbound().equals("")){ count++;}
					 if(data.getWhitewaterpumpscol5()!=null&&!data.getWhitewaterpumpscol5().equals("")){ count++;}
					 if(data.getWhitewaterpumpscol6()!=null&&!data.getWhitewaterpumpscol6().equals("")){ count++;}
					 if(data.getWhitewaterpumpscol7()!=null&&!data.getWhitewaterpumpscol7().equals("")){ count++;}
					if(data.isYankeepulpercol1()==true||data.isYankeepulpercol1()==false)
					{
						 count++;
					}
					 if(data.getYankeepulpercol2Inbound()!=null&&!data.getYankeepulpercol2Inbound().equals("")){ count++;}
					 if(data.getYankeepulpercol2Outbound()!=null&&!data.getYankeepulpercol2Outbound().equals("")){ count++;}
					if(data.isYankeepulpercol3()==true||data.isYankeepulpercol3()==false)
					{
						 count++;
					}
					 if(data.getYankeepulpercol4Inbound()!=null&&!data.getYankeepulpercol4Inbound().equals("")){ count++;}
					 if(data.getYankeepulpercol4Outbound()!=null&&!data.getYankeepulpercol4Outbound().equals("")){ count++;}
					if(data.isYankeepulpercol5()==true||data.isYankeepulpercol5()==false)
					{
						 count++;
					}
					 if(data.getYankeepulpercol6Inbound()!=null&&!data.getYankeepulpercol6Inbound().equals("")){ count++;}
					 if(data.getYankeepulpercol6Outbound()!=null&&!data.getYankeepulpercol6Outbound().equals("")){ count++;}
					if(data.isBorkechestcol1()==true||data.isBorkechestcol1()==false)
					{
						 count++;
					}
					 if(data.getBorkechestcol2Inbound()!=null&&!data.getBorkechestcol2Inbound().equals("")){ count++;}
					 if(data.getBorkechestcol2Outbound()!=null&&!data.getBorkechestcol2Outbound().equals("")){ count++;}
					if(data.isBorkechestcol3()==true||data.isBorkechestcol3()==false)
					{
						 count++;
					}
					 if(data.getBorkechestcol4Inbound()!=null&&!data.getBorkechestcol4Inbound().equals("")){ count++;}
					 if(data.getBorkechestcol4Outbound()!=null&&!data.getBorkechestcol4Outbound().equals("")){ count++;}
					 if(data.getSaveallcol1()!=null&&!data.getSaveallcol1().equals("")){ count++;}
					 if(data.getSaveallcol2()!=null&&!data.getSaveallcol2().equals("")){ count++;}
					if(data.isSaveallcol3()==true||data.isSaveallcol3()==false)
					{
						count++;
					}
					if(data.getSaveallcol4Inbound()!=null&&!data.getSaveallcol4Inbound().equals("")){ count++;}
					 if(data.getSaveallcol4Outbound()!=null&&!data.getSaveallcol4Outbound().equals("")){ count++;}
					if(data.getSydrapulpercol1Inbound()!=null&&!data.getSydrapulpercol1Inbound().equals("")){ count++;}
					if(data.getSydrapulpercol1Outbound()!=null&&!data.getSydrapulpercol1Outbound().equals("")){ count++;}
					if(data.getSydrapulpercol2()!=null&&!data.getSydrapulpercol2().equals("")){ count++;}
					if(data.isSydrapulpercol3()==true||data.isSydrapulpercol3()==false)
					{
						 count++;
					}
					if(data.getSydrapulpercol4Inbound()!=null&&!data.getSydrapulpercol4Inbound().equals("")){ count++;}
					if(data.getSydrapulpercol4Outbound()!=null&&!data.getSydrapulpercol4Outbound().equals("")){ count++;}
					if(data.getSydrapulpercol5()!=null&&!data.getSydrapulpercol5().equals("")){ count++;}
					
					
				}
				else
					count=6;
					al2.add(count);
					count=0;
				}
					 for(int n:al2)
					{
						if(n>=5)
						{
							set=set+100;
						}
					}
					nightpercent=set/days;			 
					no++;
				}
		if(no==0)no=1;
		percentage=(daypercent+nightpercent)/no;
	}
	return percentage;
}



	/* (non-Javadoc)
	 * @see com.st.obccPM5.dao.StockOperatorPM5Dao#getOperatorData(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public StockOperatorPM5 getOperatorData(String position, String shift, String date) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSourceQRT);
		String sql = "select * from [StockOperator_PM5] where position=? AND shift=? AND date =? ";
		StockOperatorPM5 stockOperatorPM5=null;
		try {
			
			stockOperatorPM5=jdbcTemplate.queryForObject(sql, new Object[]{ position,shift,date},new RowMapper<StockOperatorPM5>(){
			
				@Override
				public StockOperatorPM5 mapRow(ResultSet rs, int arg1)
						throws SQLException {
					StockOperatorPM5 data=new StockOperatorPM5();
					try {
						String newDate = dateFormat.format(fromuser.parse(rs.getString("date")));
						
						data.setId(rs.getInt("id"));
						data.setPosition(rs.getString("position"));
						data.setOperatorName(rs.getString("operatorname"));
						data.setEdate(newDate);
						data.setCrew(rs.getString("crew"));
						data.setShift(rs.getString("shift"));
						data.setMachinedown(rs.getBoolean("machinedown"));
						data.setFibersupplytankcol1(rs.getString("fibersupplytankcol1"));
						data.setFibersupplytankcol2(rs.getString("fibersupplytankcol2"));
						data.setFibersupplytankcol3(rs.getBoolean("fibersupplytankcol3"));
						data.setFibersupplytankcol4Inbound(rs.getString("fibersupplytankcol4Inbound"));
						data.setFibersupplytankcol4Outbound(rs.getString("fibersupplytankcol4Outbound"));
						data.setFibersupplytankcol5Inbound(rs.getString("fibersupplytankcol5Inbound"));
						data.setFibersupplytankcol5Outbound(rs.getString("fibersupplytankcol5Outbound"));
						data.setFibersupplytankcol6(rs.getBoolean("fibersupplytankcol6"));
						
						data.setMixchestcol1(rs.getString("mixchestcol1"));
						data.setMixchestcol2Inbound(rs.getString("mixchestcol2Inbound"));
						data.setMixchestcol2Outbound(rs.getString("mixchestcol2Outbound"));
						data.setMixchestcol3(rs.getBoolean("mixchestcol3"));
						data.setMixchestcol4(rs.getBoolean("mixchestcol4"));
						data.setMixchestcol5Inbound(rs.getString("mixchestcol5Inbound"));
						data.setMixchestcol5Outbound(rs.getString("mixchestcol5Outbound"));
						
						data.setBlendchestcol1(rs.getString("blendchestcol1"));
						data.setBlendchestcol2(rs.getBoolean("blendchestcol2"));
						data.setBlendchestcol3Inbound(rs.getString("blendchestcol3Inbound"));
						data.setBlendchestcol3Outbound(rs.getString("blendchestcol3Outbound"));
						
						data.setMachinechestcol1(rs.getString("machinechestcol1"));
						data.setMachinechestcol2(rs.getBoolean("machinechestcol2"));
						data.setMachinechestcol3Inbound(rs.getString("machinechestcol3Inbound"));
						data.setMachinechestcol3Outbound(rs.getString("machinechestcol3Outbound"));
						data.setMachinechestcol4(rs.getBoolean("machinechestcol4"));
						data.setMachinechestcol5Inbound(rs.getString("machinechestcol5Inbound"));
						data.setMachinechestcol5Outbound(rs.getString("machinechestcol5Outbound"));
			
						
						data.setCouchpitcol1(rs.getBoolean("couchpitcol1"));
						data.setCouchpitcol2Inbound(rs.getString("couchpitcol2Inbound"));
						data.setCouchpitcol2Outbound(rs.getString("couchpitcol2Outbound"));
						data.setCouchpitcol3(rs.getBoolean("couchpitcol3"));
						data.setCouchpitcol4Inbound(rs.getString("couchpitcol4Inbound"));
						data.setCouchpitcol4Outbound(rs.getString("couchpitcol4Outbound"));
						data.setCouchpitcol5Inbound(rs.getString("couchpitcol5Inbound"));
						data.setCouchpitcol5Outbound(rs.getString("couchpitcol5Outbound"));
						data.setCouchpitcol6(rs.getBoolean("couchpitcol6"));
						
					
						
						data.setFibersupplytankcol1Desc(rs.getString("fibersupplytankcol1Desc"));
						data.setFibersupplytankcol2Desc(rs.getString("fibersupplytankcol2Desc"));
						data.setFibersupplytankcol3Desc(rs.getString("fibersupplytankcol3Desc"));
						data.setFibersupplytankcol4Desc(rs.getString("fibersupplytankcol4Desc"));
						data.setFibersupplytankcol5Desc(rs.getString("fibersupplytankcol5Desc"));
						data.setFibersupplytankcol6Desc(rs.getString("fibersupplytankcol6Desc"));
						
						data.setMixchestcol1Desc(rs.getString("mixchestcol1Desc"));
						data.setMixchestcol2Desc(rs.getString("mixchestcol2Desc"));
						data.setMixchestcol3Desc(rs.getString("mixchestcol3Desc"));
						data.setMixchestcol4Desc(rs.getString("mixchestcol4Desc"));
						data.setMixchestcol5Desc(rs.getString("mixchestcol5Desc"));
						
						data.setBlendchestcol1Desc(rs.getString("blendchestcol1Desc"));
						data.setBlendchestcol2Desc(rs.getString("blendchestcol2Desc"));
						data.setBlendchestcol3Desc(rs.getString("blendchestcol3Desc"));
						
						data.setMachinechestcol1Desc(rs.getString("machinechestcol1Desc"));
						data.setMachinechestcol2Desc(rs.getString("machinechestcol2Desc"));
						data.setMachinechestcol3Desc(rs.getString("machinechestcol3Desc"));
						data.setMachinechestcol4Desc(rs.getString("machinechestcol4Desc"));
						data.setMachinechestcol5Desc(rs.getString("machinechestcol5Desc"));
										

						data.setCouchpitcol1Desc(rs.getString("couchpitcol1Desc"));
						data.setCouchpitcol2Desc(rs.getString("couchpitcol2Desc"));
						data.setCouchpitcol3Desc(rs.getString("couchpitcol3Desc"));
						data.setCouchpitcol4Desc(rs.getString("couchpitcol4Desc"));
						data.setCouchpitcol5Desc(rs.getString("couchpitcol5Desc"));
						data.setCouchpitcol6Desc(rs.getString("couchpitcol6Desc"));
						
						data.setCleanscannerheadcol1(rs.getBoolean("cleanscannerheadcol1"));
						data.setSpoolstarterworkingproperlycol1(rs.getBoolean("spoolstarterworkingproperlycol1"));
						data.setBeakpassacceptablecol1(rs.getBoolean("beakpassacceptablecol1"));
						data.setCleanscannerheadcol1Desc(rs.getString("cleanscannerheadcol1Desc"));
						data.setSpoolstarterworkingproperlycol1Desc(rs.getString("spoolstarterworkingproperlycol1Desc"));						
						data.setBeakpassacceptablecol1Desc(rs.getString("beakpassacceptablecol1Desc"));
						
								data.setRefiner1col1(rs.getBoolean("refiner1col1"));
								data.setRefiner1col1Desc(rs.getString("refiner1col1Desc"));
								data.setRefiner1col2Inbound(rs.getString("refiner1col2Inbound"));
								data.setRefiner1col2Outbound(rs.getString("refiner1col2Outbound"));
								data.setRefiner1col2Desc(rs.getString("refiner1col2Desc"));
								data.setRefiner1col3(rs.getString("refiner1col3"));
								data.setRefiner1col3Desc(rs.getString("refiner1col3Desc"));
								data.setRefiner1col4(rs.getString("refiner1col4"));
								data.setRefiner1col4Desc(rs.getString("refiner1col4Desc"));
								data.setRefiner2col1(rs.getBoolean("refiner2col1"));
								data.setRefiner2col1Desc(rs.getString("refiner2col1Desc"));
								data.setRefiner2col2Inbound(rs.getString("refiner2col2Inbound"));
								data.setRefiner2col2Outbound(rs.getString("refiner2col2Outbound"));
								data.setRefiner2col2Desc(rs.getString("refiner2col2Desc"));
								data.setRefiner2col3(rs.getString("refiner2col3"));
								data.setRefiner2col3Desc(rs.getString("refiner2col3Desc"));
								data.setRefiner2col4(rs.getString("refiner2col4"));
								data.setRefiner2col4Desc(rs.getString("refiner2col4Desc"));
								data.setWhitewaterpumpscol1(rs.getBoolean("whitewaterpumpscol1"));
								data.setWhitewaterpumpscol1Desc(rs.getString("whitewaterpumpscol1Desc"));
								data.setWhitewaterpumpscol2Inbound(rs.getString("whitewaterpumpscol2Inbound"));
								data.setWhitewaterpumpscol2Outbound(rs.getString("whitewaterpumpscol2Outbound"));
								data.setWhitewaterpumpscol2Desc(rs.getString("whitewaterpumpscol2Desc"));
								data.setWhitewaterpumpscol3(rs.getBoolean("whitewaterpumpscol3"));
								data.setWhitewaterpumpscol3Desc(rs.getString("whitewaterpumpscol3Desc"));
								data.setWhitewaterpumpscol4Inbound(rs.getString("whitewaterpumpscol4Inbound"));
								data.setWhitewaterpumpscol4Outbound(rs.getString("wwhitewaterpumpscol4Outbound"));
								data.setWhitewaterpumpscol4Desc(rs.getString("whitewaterpumpscol4Desc"));
								data.setWhitewaterpumpscol5(rs.getString("whitewaterpumpscol5"));
								data.setWhitewaterpumpscol5Desc(rs.getString("whitewaterpumpscol5Desc"));
								data.setWhitewaterpumpscol6(rs.getString("whitewaterpumpscol6"));
								data.setWhitewaterpumpscol6Desc(rs.getString("whitewaterpumpscol6Desc"));
								data.setWhitewaterpumpscol7(rs.getString("whitewaterpumpscol7"));
								data.setWhitewaterpumpscol7Desc(rs.getString("whitewaterpumpscol7Desc"));
								data.setYankeepulpercol1(rs.getBoolean("yankeepulpercol1"));
								data.setYankeepulpercol1Desc(rs.getString("yankeepulpercol1Desc"));
								data.setYankeepulpercol2Inbound(rs.getString("yankeepulpercol2Inbound"));
								data.setYankeepulpercol2Outbound(rs.getString("yankeepulpercol2Outbound"));
								data.setYankeepulpercol2Desc(rs.getString("yankeepulpercol2Desc"));
								data.setYankeepulpercol3(rs.getBoolean("yankeepulpercol3"));
								data.setYankeepulpercol3Desc(rs.getString("yankeepulpercol3Desc"));
								data.setYankeepulpercol4Inbound(rs.getString("yankeepulpercol4Inbound"));
								data.setYankeepulpercol4Outbound(rs.getString("yankeepulpercol4Outbound"));
								data.setYankeepulpercol4Desc(rs.getString("yankeepulpercol4Desc"));
								data.setYankeepulpercol5(rs.getBoolean("yankeepulpercol5"));
								data.setYankeepulpercol5Desc(rs.getString("yankeepulpercol5Desc"));
								data.setYankeepulpercol6Inbound(rs.getString("yankeepulpercol6Inbound"));
								data.setYankeepulpercol6Outbound(rs.getString("yankeepulpercol6Outbound"));
								data.setYankeepulpercol6Desc(rs.getString("yankeepulpercol6Desc"));
								data.setBorkechestcol1(rs.getBoolean("borkechestcol1"));
								data.setBorkechestcol1Desc(rs.getString("borkechestcol1Desc"));
								data.setBorkechestcol2Inbound(rs.getString("borkechestcol2Inbound"));
								data.setBorkechestcol2Outbound(rs.getString("borkechestcol2Outbound"));
								data.setBorkechestcol2Desc(rs.getString("borkechestcol2Desc"));
								data.setBorkechestcol3(rs.getBoolean("borkechestcol3"));
								data.setBorkechestcol3Desc(rs.getString("borkechestcol3Desc"));
								data.setBorkechestcol4Inbound(rs.getString("borkechestcol4Inbound"));
								data.setBorkechestcol4Outbound(rs.getString("borkechestcol4Outbound"));
								data.setBorkechestcol4Desc(rs.getString("borkechestcol4Desc"));
								data.setSaveallcol1(rs.getString("saveallcol1"));
								data.setSaveallcol1Desc(rs.getString("saveallcol1Desc"));
								data.setSaveallcol2(rs.getString("saveallcol2"));
								data.setSaveallcol2Desc(rs.getString("saveallcol2Desc"));
								data.setSaveallcol3(rs.getBoolean("saveallcol3"));
								data.setSaveallcol3Desc(rs.getString("saveallcol3Desc"));
								data.setSaveallcol4Inbound(rs.getString("saveallcol4Inbound"));
								data.setSaveallcol4Outbound(rs.getString("saveallcol4Outbound"));
								data.setSaveallcol4Desc(rs.getString("saveallcol4Desc"));
								data.setSydrapulpercol1Inbound(rs.getString("sydrapulpercol1Inbound"));
								data.setSydrapulpercol1Outbound(rs.getString("sydrapulpercol1Outbound"));
								data.setSydrapulpercol1Desc(rs.getString("sydrapulpercol1Desc"));
								data.setSydrapulpercol2(rs.getString("sydrapulpercol2"));
								data.setSydrapulpercol2Desc(rs.getString("sydrapulpercol2Desc"));
								data.setSydrapulpercol3(rs.getBoolean("sydrapulpercol3"));
								data.setSydrapulpercol3Desc(rs.getString("sydrapulpercol3Desc"));
								data.setSydrapulpercol4Inbound(rs.getString("sydrapulpercol4Inbound"));
								data.setSydrapulpercol4Outbound(rs.getString("sydrapulpercol4Outbound"));
								data.setSydrapulpercol1Desc(rs.getString("sydrapulpercol4Desc"));
								data.setSydrapulpercol1Desc(rs.getString("sydrapulpercol5"));
								data.setSydrapulpercol1Desc(rs.getString("sydrapulpercol5Desc"));
						
						
					} catch (Exception e) {
						// TODO: handle exception
					}

					return data;
				}
				
			});
		} catch (Exception e) {
			System.out.println(e);
		}
		return stockOperatorPM5;
	}
}

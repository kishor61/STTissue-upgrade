/**
 *Jun 13, 2016
 *BackTenderDaoImpl.java
 * TODO
 *com.st.obcc.dao
 *BackTenderDaoImpl.java
 *Sunil Singh Bora
 */
package com.st.obcc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
import com.st.obcc.model.BackTender;
import com.st.obcc.model.MachineTender;
import com.st.obcc.model.R1Operator;
import com.st.obcc.model.StockOperator;

/**
 * @author snavhaal
 *
 */
@Repository
public class BackTenderDaoImpl implements BackTenderDao {

	@Autowired
	@Qualifier("dataSourceOBCC")
	private DataSource dataSourceQRT;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.st.obcc.dao.BackTenderDao#saveorUpdate(com.st.obcc.model.BackTender)
	 */
	
	private SimpleDateFormat dateFormat=new SimpleDateFormat("MM-dd-yyyy");
	private SimpleDateFormat fromuser=new SimpleDateFormat("yyyy-MM-dd");
	
	@Override
	public void saveorUpdate(BackTender data) {
		// TODO Auto-generated method stub
		 
			NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(dataSourceQRT);
		 	MapSqlParameterSource paramSource=new MapSqlParameterSource();
			
			paramSource.addValue("position",data.getPosition());
			paramSource.addValue("operatorName",data.getOperatorName());
			paramSource.addValue("edate",data.getEdate());
			paramSource.addValue("crew",data.getCrew());
			paramSource.addValue("shift",data.getShift());
			
			paramSource.addValue("machinedown",data.isMachinedown());
			paramSource.addValue("reelCol1",data.getReelCol1());
			paramSource.addValue("reelCol2",data.getReelCol2());
			
			paramSource.addValue("reelCol3Inbound",data.getReelCol3Inbound());
			paramSource.addValue("reelCol3Outbound",data.getReelCol3Outbound());
			
			paramSource.addValue("reelCol4",data.isReelCol4());
			paramSource.addValue("reelCol5",data.getReelCol5());
			
			paramSource.addValue("machineLubricationCol1",data.getMachineLubricationCol1());
			paramSource.addValue("machineLubricationCol2",data.getMachineLubricationCol2());
			paramSource.addValue("machineLubricationCol3",data.getMachineLubricationCol3());
			paramSource.addValue("machineLubricationCol4",data.getMachineLubricationCol4());
			paramSource.addValue("machineLubricationCol5",data.getMachineLubricationCol5());
			
			paramSource.addValue("condensateCol1",data.isCondensateCol1());
			
			paramSource.addValue("condensateCol2Inbound",data.getCondensateCol2Inbound());
			paramSource.addValue("condensateCol2Outbound",data.getCondensateCol2Outbound());
			
			paramSource.addValue("condensateCol3",data.isCondensateCol3());
			
			paramSource.addValue("condensateCol4Inbound",data.getCondensateCol4Inbound());
			paramSource.addValue("condensateCol4Outbound",data.getCondensateCol4Outbound());
			
			paramSource.addValue("condensateCol5",data.isCondensateCol5()); 
			paramSource.addValue("condensateCol6",data.isCondensateCol6());
			
			paramSource.addValue("condensateCol7Inbound",data.getCondensateCol7Inbound());
			paramSource.addValue("condensateCol7Outbound",data.getCondensateCol7Outbound());
			 
			paramSource.addValue("condensateCol8",data.isCondensateCol8());
			
			paramSource.addValue("condensateCol9Inbound",data.getCondensateCol9Inbound());
			paramSource.addValue("condensateCol9Outbound",data.getCondensateCol9Outbound());
			
			 
			paramSource.addValue("condensateCol10",data.isCondensateCol10());
			
			paramSource.addValue("condensateCol11Inbound",data.getCondensateCol11Inbound());
			paramSource.addValue("condensateCol11Outbound",data.getCondensateCol11Outbound());
			
			 
			paramSource.addValue("condensateCol12",data.isCondensateCol12());
			paramSource.addValue("condensateCol13",data.isCondensateCol13());
			
			paramSource.addValue("condensateCol14Inbound",data.getCondensateCol14Inbound());
			paramSource.addValue("condensateCol14Outbound",data.getCondensateCol14Outbound());
			
			//paramSource.addValue("condensateCol14",data.isCondensateCol14());
			paramSource.addValue("condensateCol15",data.getCondensateCol15());
			 
			
			
			paramSource.addValue("showerWaterCol1",data.isShowerWaterCol1());
			paramSource.addValue("showerWaterCol2",data.isShowerWaterCol2());
			
			paramSource.addValue("showerWaterCol3Inbound",data.getShowerWaterCol3Inbound());
			paramSource.addValue("showerWaterCol3Outbound",data.getShowerWaterCol3Outbound());
			
			paramSource.addValue("showerWaterCol4",data.isShowerWaterCol4()); 
			
			paramSource.addValue("showerWaterCol5Inbound",data.getShowerWaterCol5Inbound());
			paramSource.addValue("showerWaterCol5Outbound",data.getShowerWaterCol5Outbound());
			
			paramSource.addValue("showerWaterCol6",data.isShowerWaterCol6());
			
			paramSource.addValue("showerWaterCol7Inbound",data.getShowerWaterCol7Inbound());
			paramSource.addValue("showerWaterCol7Outbound",data.getShowerWaterCol7Outbound());
			
			paramSource.addValue("showerWaterCol8",data.getShowerWaterCol8());
			paramSource.addValue("showerWaterCol9",data.getShowerWaterCol9());
			
			
			paramSource.addValue("lubricationCol1",data.getLubricationCol1());
			paramSource.addValue("lubricationCol2",data.getLubricationCol2());
			paramSource.addValue("lubricationCol3",data.getLubricationCol3());
			paramSource.addValue("lubricationCol4",data.getLubricationCol4()); 
			paramSource.addValue("lubricationCol5",data.getLubricationCol5()); 
			paramSource.addValue("lubricationCol6",data.getLubricationCol6());
			paramSource.addValue("lubricationCol7",data.getLubricationCol7());
			
			
			
			paramSource.addValue("afterDryerCol1",data.isAfterDryerCol1());
			paramSource.addValue("afterDryerCol2",data.getAfterDryerCol2());
			paramSource.addValue("afterDryerCol3",data.getAfterDryerCol3());
			paramSource.addValue("afterDryerCol4",data.isAfterDryerCol4()); 
			paramSource.addValue("afterDryerCol5",data.getAfterDryerCol5()); 
			paramSource.addValue("afterDryerCol6",data.getAfterDryerCol6());
			 
			
			
			paramSource.addValue("eqptScannerCol1",data.isEqptScannerCol1());
			paramSource.addValue("eqptScannerCol2",data.getEqptScannerCol2());
			paramSource.addValue("eqptScannerCol3",data.isEqptScannerCol3());
			paramSource.addValue("eqptScannerCol4",data.isEqptScannerCol4()); 
			paramSource.addValue("eqptScannerCol5",data.isEqptScannerCol5()); 
			
			
			paramSource.addValue("eqptReelSectionCol1",data.isEqptReelSectionCol1());
			paramSource.addValue("eqptReelSectionCol2",data.getEqptReelSectionCol2());
			paramSource.addValue("eqptReelSectionCol3",data.getEqptReelSectionCol3());
			paramSource.addValue("eqptReelSectionCol4",data.getEqptReelSectionCol4()); 
			paramSource.addValue("eqptReelSectionCol5",data.getEqptReelSectionCol5()); 
			
			
			
			paramSource.addValue("oilFlowCol1",data.isOilFlowCol1());
			paramSource.addValue("oilFlowCol2",data.isOilFlowCol2());
			paramSource.addValue("oilFlowCol3",data.isOilFlowCol3());
			paramSource.addValue("oilFlowCol4",data.isOilFlowCol4()); 
			paramSource.addValue("oilFlowCol5",data.getOilFlowCol5()); 
			paramSource.addValue("oilFlowCol6",data.getOilFlowCol6());
			paramSource.addValue("oilFlowCol7",data.getOilFlowCol7());
			
			
			
			
			paramSource.addValue("mezzanineCol1",data.isMezzanineCol1());
			paramSource.addValue("mezzanineCol2",data.isMezzanineCol2());
			paramSource.addValue("mezzanineCol3",data.isMezzanineCol3());
			paramSource.addValue("mezzanineCol4",data.isMezzanineCol4()); 
			paramSource.addValue("mezzanineCol5",data.isMezzanineCol5()); 
			
			
			
			paramSource.addValue("reelCol1Desc",data.getReelCol1Desc());
			paramSource.addValue("reelCol2Desc",data.getReelCol2Desc());
			paramSource.addValue("reelCol3Desc",data.getReelCol3Desc());
			paramSource.addValue("reelCol4Desc",data.getReelCol4Desc()); 
			paramSource.addValue("reelCol5Desc",data.getReelCol5Desc()); 
			
			paramSource.addValue("machineLubricationCol1Desc",data.getMachineLubricationCol1Desc());
			paramSource.addValue("machineLubricationCol2Desc",data.getMachineLubricationCol2Desc());
			paramSource.addValue("machineLubricationCol3Desc",data.getMachineLubricationCol3Desc());
			paramSource.addValue("machineLubricationCol4Desc",data.getMachineLubricationCol4Desc()); 
			paramSource.addValue("machineLubricationCol5Desc",data.getMachineLubricationCol5Desc()); 
			
			
			
			
			paramSource.addValue("condensateCol1Desc",data.getCondensateCol1Desc());
			paramSource.addValue("condensateCol2Desc",data.getCondensateCol2Desc());
			paramSource.addValue("condensateCol3Desc",data.getCondensateCol3Desc());
			paramSource.addValue("condensateCol4Desc",data.getCondensateCol4Desc()); 
			paramSource.addValue("condensateCol5Desc",data.getCondensateCol5Desc()); 
			paramSource.addValue("condensateCol6Desc",data.getCondensateCol6Desc());
			paramSource.addValue("condensateCol7Desc",data.getCondensateCol7Desc());
			paramSource.addValue("condensateCol8Desc",data.getCondensateCol8Desc());
			paramSource.addValue("condensateCol9Desc",data.getCondensateCol9Desc());
			paramSource.addValue("condensateCol10Desc",data.getCondensateCol10Desc());
			paramSource.addValue("condensateCol11Desc",data.getCondensateCol11Desc());
			paramSource.addValue("condensateCol12Desc",data.getCondensateCol12Desc());
			paramSource.addValue("condensateCol13Desc",data.getCondensateCol13Desc());
			paramSource.addValue("condensateCol14Desc",data.getCondensateCol14Desc());
			paramSource.addValue("condensateCol15Desc",data.getCondensateCol15Desc());
			
			
			
			paramSource.addValue("showerWaterCol1Desc",data.getShowerWaterCol1Desc());
			paramSource.addValue("showerWaterCol2Desc",data.getShowerWaterCol2Desc());
			paramSource.addValue("showerWaterCol3Desc",data.getShowerWaterCol3Desc());
			paramSource.addValue("showerWaterCol4Desc",data.getShowerWaterCol4Desc()); 
			paramSource.addValue("showerWaterCol5Desc",data.getShowerWaterCol5Desc()); 
			paramSource.addValue("showerWaterCol6Desc",data.getShowerWaterCol6Desc());
			paramSource.addValue("showerWaterCol7Desc",data.getShowerWaterCol7Desc());
			paramSource.addValue("showerWaterCol8Desc",data.getShowerWaterCol8Desc());
			paramSource.addValue("showerWaterCol9Desc",data.getShowerWaterCol9Desc());
			
			
			
			paramSource.addValue("lubricationCol1Desc",data.getLubricationCol1Desc());
			paramSource.addValue("lubricationCol2Desc",data.getLubricationCol2Desc());
			paramSource.addValue("lubricationCol3Desc",data.getLubricationCol3Desc());
			paramSource.addValue("lubricationCol4Desc",data.getLubricationCol4Desc()); 
			paramSource.addValue("lubricationCo5Desc",data.getLubricationCo5Desc()); 
			paramSource.addValue("lubricationCo6Desc",data.getLubricationCo6Desc());
			paramSource.addValue("lubricationCo7Desc",data.getLubricationCo7Desc());
			
			
			
			paramSource.addValue("afterDryerCol1Desc",data.getAfterDryerCol1Desc());
			paramSource.addValue("afterDryerCol2Desc",data.getAfterDryerCol2Desc());
			paramSource.addValue("afterDryerCol3Desc",data.getAfterDryerCol3Desc());
			paramSource.addValue("afterDryerCol4Desc",data.getAfterDryerCol4Desc()); 
			paramSource.addValue("afterDryerCol5Desc",data.getAfterDryerCol5Desc()); 
			paramSource.addValue("afterDryerCol6Desc",data.getAfterDryerCol6Desc());
			
			 
			
			paramSource.addValue("eqptScannerCol1Desc",data.getEqptScannerCol1Desc());
			paramSource.addValue("eqptScannerCol2Desc",data.getEqptScannerCol2Desc());
			paramSource.addValue("eqptScannerCol3Desc",data.getEqptScannerCol3Desc());
			paramSource.addValue("eqptScannerCol4Desc",data.getEqptScannerCol4Desc()); 
			paramSource.addValue("eqptScannerCol5Desc",data.getEqptScannerCol5Desc()); 
			
			
			paramSource.addValue("eqptReelSectionCol1Desc",data.getEqptReelSectionCol1Desc());
			paramSource.addValue("eqptReelSectionCol2Desc",data.getEqptReelSectionCol2Desc());
			paramSource.addValue("eqptReelSectionCol3Desc",data.getEqptReelSectionCol3Desc());
			paramSource.addValue("eqptReelSectionCol4Desc",data.getEqptReelSectionCol4Desc()); 
			paramSource.addValue("eqptReelSectionCol5Desc",data.getEqptReelSectionCol5Desc()); 
			
			
			
			paramSource.addValue("oilFlowCol1Desc",data.getOilFlowCol1Desc());
			paramSource.addValue("oilFlowCol2Desc",data.getOilFlowCol2Desc());
			paramSource.addValue("oilFlowCol3Desc",data.getOilFlowCol3Desc());
			paramSource.addValue("oilFlowCol4Desc",data.getOilFlowCol4Desc()); 
			paramSource.addValue("oilFlowCol5Desc",data.getOilFlowCol5Desc()); 
			paramSource.addValue("oilFlowCol6Desc",data.getOilFlowCol6Desc());
			paramSource.addValue("oilFlowCol7Desc",data.getOilFlowCol7Desc());
			
			
			
			paramSource.addValue("mezzanineCol1Desc",data.getMezzanineCol1Desc());
			paramSource.addValue("mezzanineCol2Desc",data.getMezzanineCol2Desc());
			paramSource.addValue("mezzanineCol3Desc",data.getMezzanineCol3Desc());
			paramSource.addValue("mezzanineCol4Desc",data.getMezzanineCol4Desc()); 
			paramSource.addValue("mezzanineCol5Desc",data.getMezzanineCol5Desc()); 
			
			paramSource.addValue("fillupcol1",data.getFillupcol1());
			paramSource.addValue("fillupcol2",data.getFillupcol2());
			paramSource.addValue("fillupcol3",data.getFillupcol3());
			paramSource.addValue("fillupcol4",data.getFillupcol4());
			paramSource.addValue("fillupcol5",data.getFillupcol5());
			paramSource.addValue("fillupcol6",data.getFillupcol6());
			paramSource.addValue("fillupcol7",data.getFillupcol7());
			 
			
			paramSource.addValue("fillupcol1Desc",data.getFillupcol1Desc());
			paramSource.addValue("fillupcol2Desc",data.getFillupcol2Desc());
			paramSource.addValue("fillupcol3Desc",data.getFillupcol3Desc());
			paramSource.addValue("fillupcol4Desc",data.getFillupcol4Desc());
			paramSource.addValue("fillupcol5Desc",data.getFillupcol5Desc());
			paramSource.addValue("fillupcol6Desc",data.getFillupcol6Desc());
			paramSource.addValue("fillupcol7Desc",data.getFillupcol7Desc());
			 
			 //Code Starts From Here Done By Roshan Tailor
			paramSource.addValue("checkbladechange",data.getCheckbladechange());
			paramSource.addValue("checkbladechangeremark",data.getCheckbladechangeremark());
			paramSource.addValue("celovesforholes",data.getCelovesforholes());
			paramSource.addValue("celovesforholesremark",data.getCelovesforholesremark());
			//Code Ends Here Done By Roshan Tailor
			
			
			if (data.getId() == 0) {	
			
				String sql=DatabaseUtil.getSQL("sql/insertBackTender.sql");
				jdbcTemplate.update(sql, paramSource);
			}	
			else
			{
				paramSource.addValue("id",data.getId());
				String sql=DatabaseUtil.getSQL("sql/updateBackTender.sql");
				jdbcTemplate.update(sql, paramSource);
			}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.st.obcc.dao.BackTenderDao#getOperatorData(java.lang.String,
	 * java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public BackTender getOperatorData(String position, String shift,
			String date, String crew) throws Exception {

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSourceQRT);
		String sql = "select * from [backTender] where [position]=? AND [date]=? AND [shift] = ?  ";

		BackTender backTender = null;

		try {
			backTender = jdbcTemplate.queryForObject(sql, new Object[] {
					position, date, shift }, new RowMapper<BackTender>() {

				@Override
				public BackTender mapRow(ResultSet rs, int arg1)
						throws SQLException {
					BackTender data = new BackTender();

					data.setId(rs.getInt("id"));
					data.setPosition(rs.getString("position"));
					data.setOperatorName(rs.getString("operator_name"));
					data.setEdate(rs.getString("date"));
					data.setCrew(rs.getString("crew"));
					data.setShift(rs.getString("shift"));
					
					data.setMachinedown(rs.getBoolean("machinedown"));
					data.setReelCol1(rs.getString("reel_col1"));
					data.setReelCol2(rs.getString("reel_col2"));
					
					data.setReelCol3Inbound(rs.getString("reel_3_inbound"));
					data.setReelCol3Outbound(rs.getString("reel_3_outbound"));
					
					data.setReelCol4(rs.getBoolean("reel_col4"));
					data.setReelCol5(rs.getString("reel_col5"));

					data.setMachineLubricationCol1(rs.getString("machine_lubrication_col1"));
					data.setMachineLubricationCol2(rs.getString("machine_lubrication_col2"));
					data.setMachineLubricationCol3(rs.getString("machine_lubrication_col3"));
					data.setMachineLubricationCol4(rs.getString("machine_lubrication_col4"));
					data.setMachineLubricationCol5(rs.getString("machine_lubrication_col5"));

					data.setCondensateCol1(rs.getBoolean("condensate_col1"));
					
					data.setCondensateCol2Inbound(rs.getString("condensate_col2_inbound"));
					data.setCondensateCol2Outbound(rs.getString("condensate_col2_outbound"));
					
					data.setCondensateCol3(rs.getBoolean("condensate_col3"));
					
					data.setCondensateCol4Inbound(rs.getString("condensate_col4_inbound"));
					data.setCondensateCol4Outbound(rs.getString("condensate_col4_outbound"));
					
					data.setCondensateCol5(rs.getBoolean("condensate_col5"));
					data.setCondensateCol6(rs.getBoolean("condensate_col6"));
					
					data.setCondensateCol7Inbound(rs.getString("condensate_col7_inbound"));
					data.setCondensateCol7Outbound(rs.getString("condensate_col7_outbound"));
					
					data.setCondensateCol8(rs.getBoolean("condensate_col8"));
					
					 
					data.setCondensateCol9Inbound(rs.getString("condensate_col9_inbound"));
					data.setCondensateCol9Outbound(rs.getString("condensate_col9_outbound"));
					
					
					data.setCondensateCol10(rs.getBoolean("condensate_col10"));
					
					data.setCondensateCol11Inbound(rs.getString("condensate_col11_inbound"));
					data.setCondensateCol11Outbound(rs.getString("condensate_col11_outbound"));
					
					data.setCondensateCol12(rs.getBoolean("condensate_col12"));
					data.setCondensateCol13(rs.getBoolean("condensate_col13"));
					
					data.setCondensateCol14Inbound(rs.getString("condensate_col14_inbound"));
					data.setCondensateCol14Outbound(rs.getString("condensate_col14_outbound"));
					
					data.setCondensateCol15(rs.getString("condensate_col15"));

					data.setShowerWaterCol1(rs.getBoolean("shower_water_col1"));
					data.setShowerWaterCol2(rs.getBoolean("shower_water_col2"));
					
					data.setShowerWaterCol3Inbound(rs.getString("shower_water_col3_inbound"));
					data.setShowerWaterCol3Outbound(rs.getString("shower_water_col3_outbound"));
					
					data.setShowerWaterCol4(rs.getBoolean("shower_water_col4"));
					
					data.setShowerWaterCol5Inbound(rs.getString("shower_water_col5_inbound"));
					data.setShowerWaterCol5Outbound(rs.getString("shower_water_col5_outbound"));
					
					//data.setShowerWaterCol5(rs.getBoolean("shower_water_col5"));
					data.setShowerWaterCol6(rs.getBoolean("shower_water_col6"));
					
					data.setShowerWaterCol7Inbound(rs.getString("shower_water_col7_inbound"));
					data.setShowerWaterCol7Outbound(rs.getString("shower_water_col7_outbound"));
					
					//data.setShowerWaterCol7(rs.getBoolean("shower_water_col7"));
					data.setShowerWaterCol8(rs.getString("shower_water_col8"));
					data.setShowerWaterCol9(rs.getString("shower_water_col9"));

					data.setLubricationCol1(rs.getString("lubrication_col1"));
					data.setLubricationCol2(rs.getString("lubrication_col2"));
					data.setLubricationCol3(rs.getString("lubrication_col3"));
					data.setLubricationCol4(rs.getString("lubrication_col4"));
					data.setLubricationCol5(rs.getString("lubrication_col5"));
					data.setLubricationCol6(rs.getString("lubrication_col6"));
					data.setLubricationCol7(rs.getString("lubrication_col7"));

					data.setAfterDryerCol1(rs.getBoolean("after_dryer_col1"));
					data.setAfterDryerCol2(rs.getString("after_dryer_col2"));
					data.setAfterDryerCol3(rs.getString("after_dryer_col3"));
					data.setAfterDryerCol4(rs.getBoolean("after_dryer_col4"));
					data.setAfterDryerCol5(rs.getString("after_dryer_col5"));
					data.setAfterDryerCol6(rs.getString("after_dryer_col6"));

					data.setEqptScannerCol1(rs.getBoolean("eqpt_scanner_col1"));
					data.setEqptScannerCol2(rs.getString("eqpt_scanner_col2"));
					data.setEqptScannerCol3(rs.getBoolean("eqpt_scanner_col3"));
					data.setEqptScannerCol4(rs.getBoolean("eqpt_scanner_col4"));
					data.setEqptScannerCol5(rs.getBoolean("eqpt_scanner_col5"));

					data.setEqptReelSectionCol1(rs.getBoolean("eqpt_reelSection_col1"));
					data.setEqptReelSectionCol2(rs.getString("eqpt_reelSection_col2"));
					data.setEqptReelSectionCol3(rs.getString("eqpt_reelSection_col3"));
					data.setEqptReelSectionCol4(rs.getString("eqpt_reelSection_col4"));
					data.setEqptReelSectionCol5(rs.getString("eqpt_reelSection_col5"));

					data.setOilFlowCol1(rs.getBoolean("oilFlow_col1"));
					data.setOilFlowCol2(rs.getBoolean("oilFlow_col2"));
					data.setOilFlowCol3(rs.getBoolean("oilFlow_col3"));
					data.setOilFlowCol4(rs.getBoolean("oilFlow_col4"));
					data.setOilFlowCol5(rs.getString("oilFlow_col5"));
					data.setOilFlowCol6(rs.getString("oilFlow_col6"));
					data.setOilFlowCol7(rs.getString("oilFlow_col7"));

					data.setMezzanineCol1(rs.getBoolean("mezzanine_col1"));
					data.setMezzanineCol2(rs.getBoolean("mezzanine_col2"));
					data.setMezzanineCol3(rs.getBoolean("mezzanine_col3"));
					data.setMezzanineCol4(rs.getBoolean("mezzanine_col4"));
					data.setMezzanineCol5(rs.getBoolean("mezzanine_col5"));

					data.setReelCol1Desc(rs.getString("reel_col1_desc"));
					data.setReelCol2Desc(rs.getString("reel_col2_desc"));
					data.setReelCol3Desc(rs.getString("reel_col3_desc"));
					data.setReelCol4Desc(rs.getString("reel_col4_desc"));
					data.setReelCol5Desc(rs.getString("reel_col5_desc"));

					data.setMachineLubricationCol1Desc(rs.getString("machine_lubrication_col1_desc"));
					data.setMachineLubricationCol2Desc(rs.getString("machine_lubrication_col2_desc"));
					data.setMachineLubricationCol3Desc(rs.getString("machine_lubrication_col3_desc"));
					data.setMachineLubricationCol4Desc(rs.getString("machine_lubrication_col4_desc"));
					data.setMachineLubricationCol5Desc(rs.getString("machine_lubrication_col5_desc"));

					data.setCondensateCol1Desc(rs.getString("condensate_col1_desc"));
					data.setCondensateCol2Desc(rs.getString("condensate_col2_desc"));
					data.setCondensateCol3Desc(rs.getString("condensate_col3_desc"));
					data.setCondensateCol4Desc(rs.getString("condensate_col4_desc"));
					data.setCondensateCol5Desc(rs.getString("condensate_col5_desc"));
					data.setCondensateCol6Desc(rs.getString("condensate_col6_desc"));
					data.setCondensateCol7Desc(rs.getString("condensate_col7_desc"));
					data.setCondensateCol8Desc(rs.getString("condensate_col8_desc"));
					data.setCondensateCol9Desc(rs.getString("condensate_col9_desc"));
					data.setCondensateCol10Desc(rs.getString("condensate_col10_desc"));
					data.setCondensateCol11Desc(rs.getString("condensate_col11_desc"));
					data.setCondensateCol12Desc(rs.getString("condensate_col12_desc"));
					data.setCondensateCol13Desc(rs.getString("condensate_col13_desc"));
					data.setCondensateCol14Desc(rs.getString("condensate_col14_desc"));
					data.setCondensateCol15Desc(rs.getString("condensate_col15_desc"));

					data.setShowerWaterCol1Desc(rs.getString("shower_water_col1_desc"));
					data.setShowerWaterCol2Desc(rs.getString("shower_water_col2_desc"));
					data.setShowerWaterCol3Desc(rs.getString("shower_water_col3_desc"));
					data.setShowerWaterCol4Desc(rs.getString("shower_water_col4_desc"));
					data.setShowerWaterCol5Desc(rs.getString("shower_water_col5_desc"));
					data.setShowerWaterCol6Desc(rs.getString("shower_water_col6_desc"));
					data.setShowerWaterCol7Desc(rs.getString("shower_water_col7_desc"));
					data.setShowerWaterCol8Desc(rs.getString("shower_water_col8_desc"));
					data.setShowerWaterCol9Desc(rs.getString("shower_water_col9_desc"));

					data.setLubricationCol1Desc(rs.getString("lubrication_col1_desc"));
					data.setLubricationCol2Desc(rs.getString("lubrication_col2_desc"));
					data.setLubricationCol3Desc(rs.getString("lubrication_col3_desc"));
					data.setLubricationCol4Desc(rs.getString("lubrication_col4_desc"));
					data.setLubricationCo5Desc(rs.getString("lubrication_col5_desc"));
					data.setLubricationCo6Desc(rs.getString("lubrication_col6_desc"));
					data.setLubricationCo7Desc(rs.getString("lubrication_col7_desc"));

					data.setAfterDryerCol1Desc(rs.getString("after_dryer_col1_desc"));
					data.setAfterDryerCol2Desc(rs.getString("after_dryer_col2_desc"));
					data.setAfterDryerCol3Desc(rs.getString("after_dryer_col3_desc"));
					data.setAfterDryerCol4Desc(rs.getString("after_dryer_col4_desc"));
					data.setAfterDryerCol5Desc(rs.getString("after_dryer_col5_desc"));
					data.setAfterDryerCol6Desc(rs.getString("after_dryer_col6_desc"));

					data.setEqptScannerCol1Desc(rs.getString("eqpt_scanner_col1_desc"));
					data.setEqptScannerCol2Desc(rs.getString("eqpt_scanner_col2_desc"));
					data.setEqptScannerCol3Desc(rs.getString("eqpt_scanner_col3_desc"));
					data.setEqptScannerCol4Desc(rs.getString("eqpt_scanner_col4_desc"));
					data.setEqptScannerCol5Desc(rs.getString("eqpt_scanner_col5_desc"));

					data.setEqptReelSectionCol1Desc(rs.getString("eqpt_reelSection_col1_desc"));
					data.setEqptReelSectionCol2Desc(rs.getString("eqpt_reelSection_col2_desc"));
					data.setEqptReelSectionCol3Desc(rs.getString("eqpt_reelSection_col3_desc"));
					data.setEqptReelSectionCol4Desc(rs.getString("eqpt_reelSection_col4_desc"));
					data.setEqptReelSectionCol5Desc(rs.getString("eqpt_reelSection_col5_desc"));

					data.setOilFlowCol1Desc(rs.getString("oilFlow_col1_desc"));
					data.setOilFlowCol2Desc(rs.getString("oilFlow_col2_desc"));
					data.setOilFlowCol3Desc(rs.getString("oilFlow_col3_desc"));
					data.setOilFlowCol4Desc(rs.getString("oilFlow_col4_desc"));
					data.setOilFlowCol5Desc(rs.getString("oilFlow_col5_desc"));
					data.setOilFlowCol6Desc(rs.getString("oilFlow_col6_desc"));
					data.setOilFlowCol7Desc(rs.getString("oilFlow_col7_desc"));

					data.setMezzanineCol1Desc(rs.getString("mezzanine_col1_desc"));
					data.setMezzanineCol2Desc(rs.getString("mezzanine_col2_desc"));
					data.setMezzanineCol3Desc(rs.getString("mezzanine_col3_desc"));
					data.setMezzanineCol4Desc(rs.getString("mezzanine_col4_desc"));
					data.setMezzanineCol5Desc(rs.getString("mezzanine_col5_desc"));
					
					
					data.setFillupcol1(rs.getString("fillupcol1"));
					data.setFillupcol2(rs.getString("fillupcol2"));
					data.setFillupcol3(rs.getString("fillupcol3"));
					data.setFillupcol4(rs.getString("fillupcol4"));
					data.setFillupcol5(rs.getString("fillupcol5"));
					data.setFillupcol6(rs.getString("fillupcol6"));
					data.setFillupcol7(rs.getString("fillupcol7"));
					 
					
					data.setFillupcol1Desc(rs.getString("fillupcol1_Desc"));
					data.setFillupcol2Desc(rs.getString("fillupcol2_Desc"));
					data.setFillupcol3Desc(rs.getString("fillupcol3_Desc"));
					data.setFillupcol4Desc(rs.getString("fillupcol4_Desc"));
					data.setFillupcol5Desc(rs.getString("fillupcol5_Desc"));
					data.setFillupcol6Desc(rs.getString("fillupcol6_Desc"));
					data.setFillupcol7Desc(rs.getString("fillupcol7_Desc"));
					//Code Starts From Here Done By Roshan Tailor
					data.setCheckbladechange(rs.getString("checkbladechange"));
					data.setCheckbladechangeremark(rs.getString("checkbladechangeremark"));
					data.setCelovesforholes(rs.getString("celovesforholes"));
					data.setCelovesforholesremark(rs.getString("celovesforholesremark"));
					//Code Ends Here Done By Roshan Tailor
					 
					
					
					return data;
				}

			});
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return backTender;

	}
	
	
	/* (non-Javadoc)
	 * @see com.st.obcc.dao.BackTenderDao#getOperatorDataList(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public List<BackTender> getOperatorDataList(String position,String shift, String Sdate,
			String edate) throws Exception {
		// TODO Auto-generated method stub
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSourceQRT);
		String sql = "select * from [backTender] where [position]=? AND [shift] =? AND [date] BETWEEN ? AND ?";
		 
		List<BackTender> backTender = null;

		try {
			backTender = jdbcTemplate.query(sql, new Object[] {position, shift, Sdate,edate }, new RowMapper<BackTender>() {

				@Override
				public BackTender mapRow(ResultSet rs, int arg1)
						throws SQLException {
					BackTender data = new BackTender();
					try
					{
						String newDate = dateFormat.format(fromuser.parse(rs.getString("date")));
					
					data.setId(rs.getInt("id"));
					data.setPosition(rs.getString("position"));
					data.setOperatorName(rs.getString("operator_name"));
					data.setEdate(newDate);
					data.setCrew(rs.getString("crew"));
					data.setShift(rs.getString("shift"));
					data.setMachinedown(rs.getBoolean("machinedown"));
					data.setReelCol1(rs.getString("reel_col1"));
					data.setReelCol2(rs.getString("reel_col2"));
					
					data.setReelCol3Inbound(rs.getString("reel_3_inbound"));
					data.setReelCol3Outbound(rs.getString("reel_3_outbound"));
					
					data.setReelCol4(rs.getBoolean("reel_col4"));
					data.setReelCol5(rs.getString("reel_col5"));

					data.setMachineLubricationCol1(rs.getString("machine_lubrication_col1"));
					data.setMachineLubricationCol2(rs.getString("machine_lubrication_col2"));
					data.setMachineLubricationCol3(rs.getString("machine_lubrication_col3"));
					data.setMachineLubricationCol4(rs.getString("machine_lubrication_col4"));
					data.setMachineLubricationCol5(rs.getString("machine_lubrication_col5"));

					data.setCondensateCol1(rs.getBoolean("condensate_col1"));
					
					data.setCondensateCol2Inbound(rs.getString("condensate_col2_inbound"));
					data.setCondensateCol2Outbound(rs.getString("condensate_col2_outbound"));
					
					data.setCondensateCol3(rs.getBoolean("condensate_col3"));
					
					data.setCondensateCol4Inbound(rs.getString("condensate_col4_inbound"));
					data.setCondensateCol4Outbound(rs.getString("condensate_col4_outbound"));
					
					data.setCondensateCol5(rs.getBoolean("condensate_col5"));
					data.setCondensateCol6(rs.getBoolean("condensate_col6"));
					
					data.setCondensateCol7Inbound(rs.getString("condensate_col7_inbound"));
					data.setCondensateCol7Outbound(rs.getString("condensate_col7_outbound"));
					
					data.setCondensateCol8(rs.getBoolean("condensate_col8"));
					
					 
					data.setCondensateCol9Inbound(rs.getString("condensate_col9_inbound"));
					data.setCondensateCol9Outbound(rs.getString("condensate_col9_outbound"));
					
					
					data.setCondensateCol10(rs.getBoolean("condensate_col10"));
					
					data.setCondensateCol11Inbound(rs.getString("condensate_col11_inbound"));
					data.setCondensateCol11Outbound(rs.getString("condensate_col11_outbound"));
					
					data.setCondensateCol12(rs.getBoolean("condensate_col12"));
					data.setCondensateCol13(rs.getBoolean("condensate_col13"));
					
					data.setCondensateCol14Inbound(rs.getString("condensate_col14_inbound"));
					data.setCondensateCol14Outbound(rs.getString("condensate_col14_outbound"));
					
					data.setCondensateCol15(rs.getString("condensate_col15"));

					data.setShowerWaterCol1(rs.getBoolean("shower_water_col1"));
					data.setShowerWaterCol2(rs.getBoolean("shower_water_col2"));
					
					data.setShowerWaterCol3Inbound(rs.getString("shower_water_col3_inbound"));
					data.setShowerWaterCol3Outbound(rs.getString("shower_water_col3_outbound"));
					
					data.setShowerWaterCol4(rs.getBoolean("shower_water_col4"));
					
					data.setShowerWaterCol5Inbound(rs.getString("shower_water_col5_inbound"));
					data.setShowerWaterCol5Outbound(rs.getString("shower_water_col5_outbound"));
					
					//data.setShowerWaterCol5(rs.getBoolean("shower_water_col5"));
					data.setShowerWaterCol6(rs.getBoolean("shower_water_col6"));
					
					data.setShowerWaterCol7Inbound(rs.getString("shower_water_col7_inbound"));
					data.setShowerWaterCol7Outbound(rs.getString("shower_water_col7_outbound"));
					
					//data.setShowerWaterCol7(rs.getBoolean("shower_water_col7"));
					data.setShowerWaterCol8(rs.getString("shower_water_col8"));
					data.setShowerWaterCol9(rs.getString("shower_water_col9"));

					data.setLubricationCol1(rs.getString("lubrication_col1"));
					data.setLubricationCol2(rs.getString("lubrication_col2"));
					data.setLubricationCol3(rs.getString("lubrication_col3"));
					data.setLubricationCol4(rs.getString("lubrication_col4"));
					data.setLubricationCol5(rs.getString("lubrication_col5"));
					data.setLubricationCol6(rs.getString("lubrication_col6"));
					data.setLubricationCol7(rs.getString("lubrication_col7"));

					data.setAfterDryerCol1(rs.getBoolean("after_dryer_col1"));
					data.setAfterDryerCol2(rs.getString("after_dryer_col2"));
					data.setAfterDryerCol3(rs.getString("after_dryer_col3"));
					data.setAfterDryerCol4(rs.getBoolean("after_dryer_col4"));
					data.setAfterDryerCol5(rs.getString("after_dryer_col5"));
					data.setAfterDryerCol6(rs.getString("after_dryer_col6"));

					data.setEqptScannerCol1(rs.getBoolean("eqpt_scanner_col1"));
					data.setEqptScannerCol2(rs.getString("eqpt_scanner_col2"));
					data.setEqptScannerCol3(rs.getBoolean("eqpt_scanner_col3"));
					data.setEqptScannerCol4(rs.getBoolean("eqpt_scanner_col4"));
					data.setEqptScannerCol5(rs.getBoolean("eqpt_scanner_col5"));

					data.setEqptReelSectionCol1(rs.getBoolean("eqpt_reelSection_col1"));
					data.setEqptReelSectionCol2(rs.getString("eqpt_reelSection_col2"));
					data.setEqptReelSectionCol3(rs.getString("eqpt_reelSection_col3"));
					data.setEqptReelSectionCol4(rs.getString("eqpt_reelSection_col4"));
					data.setEqptReelSectionCol5(rs.getString("eqpt_reelSection_col5"));

					data.setOilFlowCol1(rs.getBoolean("oilFlow_col1"));
					data.setOilFlowCol2(rs.getBoolean("oilFlow_col2"));
					data.setOilFlowCol3(rs.getBoolean("oilFlow_col3"));
					data.setOilFlowCol4(rs.getBoolean("oilFlow_col4"));
					data.setOilFlowCol5(rs.getString("oilFlow_col5"));
					data.setOilFlowCol6(rs.getString("oilFlow_col6"));
					data.setOilFlowCol7(rs.getString("oilFlow_col7"));

					data.setMezzanineCol1(rs.getBoolean("mezzanine_col1"));
					data.setMezzanineCol2(rs.getBoolean("mezzanine_col2"));
					data.setMezzanineCol3(rs.getBoolean("mezzanine_col3"));
					data.setMezzanineCol4(rs.getBoolean("mezzanine_col4"));
					data.setMezzanineCol5(rs.getBoolean("mezzanine_col5"));

					data.setReelCol1Desc(rs.getString("reel_col1_desc"));
					data.setReelCol2Desc(rs.getString("reel_col2_desc"));
					data.setReelCol3Desc(rs.getString("reel_col3_desc"));
					data.setReelCol4Desc(rs.getString("reel_col4_desc"));
					data.setReelCol5Desc(rs.getString("reel_col5_desc"));

					data.setMachineLubricationCol1Desc(rs.getString("machine_lubrication_col1_desc"));
					data.setMachineLubricationCol2Desc(rs.getString("machine_lubrication_col2_desc"));
					data.setMachineLubricationCol3Desc(rs.getString("machine_lubrication_col3_desc"));
					data.setMachineLubricationCol4Desc(rs.getString("machine_lubrication_col4_desc"));
					data.setMachineLubricationCol5Desc(rs.getString("machine_lubrication_col5_desc"));

					data.setCondensateCol1Desc(rs.getString("condensate_col1_desc"));
					data.setCondensateCol2Desc(rs.getString("condensate_col2_desc"));
					data.setCondensateCol3Desc(rs.getString("condensate_col3_desc"));
					data.setCondensateCol4Desc(rs.getString("condensate_col4_desc"));
					data.setCondensateCol5Desc(rs.getString("condensate_col5_desc"));
					data.setCondensateCol6Desc(rs.getString("condensate_col6_desc"));
					data.setCondensateCol7Desc(rs.getString("condensate_col7_desc"));
					data.setCondensateCol8Desc(rs.getString("condensate_col8_desc"));
					data.setCondensateCol9Desc(rs.getString("condensate_col9_desc"));
					data.setCondensateCol10Desc(rs.getString("condensate_col10_desc"));
					data.setCondensateCol11Desc(rs.getString("condensate_col11_desc"));
					data.setCondensateCol12Desc(rs.getString("condensate_col12_desc"));
					data.setCondensateCol13Desc(rs.getString("condensate_col13_desc"));
					data.setCondensateCol14Desc(rs.getString("condensate_col14_desc"));
					data.setCondensateCol15Desc(rs.getString("condensate_col15_desc"));

					data.setShowerWaterCol1Desc(rs.getString("shower_water_col1_desc"));
					data.setShowerWaterCol2Desc(rs.getString("shower_water_col2_desc"));
					data.setShowerWaterCol3Desc(rs.getString("shower_water_col3_desc"));
					data.setShowerWaterCol4Desc(rs.getString("shower_water_col4_desc"));
					data.setShowerWaterCol5Desc(rs.getString("shower_water_col5_desc"));
					data.setShowerWaterCol6Desc(rs.getString("shower_water_col6_desc"));
					data.setShowerWaterCol7Desc(rs.getString("shower_water_col7_desc"));
					data.setShowerWaterCol8Desc(rs.getString("shower_water_col8_desc"));
					data.setShowerWaterCol9Desc(rs.getString("shower_water_col9_desc"));

					data.setLubricationCol1Desc(rs.getString("lubrication_col1_desc"));
					data.setLubricationCol2Desc(rs.getString("lubrication_col2_desc"));
					data.setLubricationCol3Desc(rs.getString("lubrication_col3_desc"));
					data.setLubricationCol4Desc(rs.getString("lubrication_col4_desc"));
					data.setLubricationCo5Desc(rs.getString("lubrication_col5_desc"));
					data.setLubricationCo6Desc(rs.getString("lubrication_col6_desc"));
					data.setLubricationCo7Desc(rs.getString("lubrication_col7_desc"));

					data.setAfterDryerCol1Desc(rs.getString("after_dryer_col1_desc"));
					data.setAfterDryerCol2Desc(rs.getString("after_dryer_col2_desc"));
					data.setAfterDryerCol3Desc(rs.getString("after_dryer_col3_desc"));
					data.setAfterDryerCol4Desc(rs.getString("after_dryer_col4_desc"));
					data.setAfterDryerCol5Desc(rs.getString("after_dryer_col5_desc"));

					data.setEqptScannerCol1Desc(rs.getString("eqpt_scanner_col1_desc"));
					data.setEqptScannerCol2Desc(rs.getString("eqpt_scanner_col2_desc"));
					data.setEqptScannerCol3Desc(rs.getString("eqpt_scanner_col3_desc"));
					data.setEqptScannerCol4Desc(rs.getString("eqpt_scanner_col4_desc"));
					data.setEqptScannerCol5Desc(rs.getString("eqpt_scanner_col5_desc"));

					data.setEqptReelSectionCol1Desc(rs.getString("eqpt_reelSection_col1_desc"));
					data.setEqptReelSectionCol2Desc(rs.getString("eqpt_reelSection_col2_desc"));
					data.setEqptReelSectionCol3Desc(rs.getString("eqpt_reelSection_col3_desc"));
					data.setEqptReelSectionCol4Desc(rs.getString("eqpt_reelSection_col4_desc"));
					data.setEqptReelSectionCol5Desc(rs.getString("eqpt_reelSection_col5_desc"));

					data.setOilFlowCol1Desc(rs.getString("oilFlow_col1_desc"));
					data.setOilFlowCol2Desc(rs.getString("oilFlow_col2_desc"));
					data.setOilFlowCol3Desc(rs.getString("oilFlow_col3_desc"));
					data.setOilFlowCol4Desc(rs.getString("oilFlow_col4_desc"));
					data.setOilFlowCol5Desc(rs.getString("oilFlow_col5_desc"));
					data.setOilFlowCol6Desc(rs.getString("oilFlow_col6_desc"));
					data.setOilFlowCol7Desc(rs.getString("oilFlow_col7_desc"));

					data.setMezzanineCol1Desc(rs.getString("mezzanine_col1_desc"));
					data.setMezzanineCol2Desc(rs.getString("mezzanine_col2_desc"));
					data.setMezzanineCol3Desc(rs.getString("mezzanine_col3_desc"));
					data.setMezzanineCol4Desc(rs.getString("mezzanine_col4_desc"));
					data.setMezzanineCol5Desc(rs.getString("mezzanine_col5_desc"));
					
					
					data.setFillupcol1(rs.getString("fillupcol1"));
					data.setFillupcol2(rs.getString("fillupcol2"));
					data.setFillupcol3(rs.getString("fillupcol3"));
					data.setFillupcol4(rs.getString("fillupcol4"));
					data.setFillupcol5(rs.getString("fillupcol5"));
					data.setFillupcol6(rs.getString("fillupcol6"));
					data.setFillupcol7(rs.getString("fillupcol7"));
					 
					
					data.setFillupcol1Desc(rs.getString("fillupcol1_Desc"));
					data.setFillupcol2Desc(rs.getString("fillupcol2_Desc"));
					data.setFillupcol3Desc(rs.getString("fillupcol3_Desc"));
					data.setFillupcol4Desc(rs.getString("fillupcol4_Desc"));
					data.setFillupcol5Desc(rs.getString("fillupcol5_Desc"));
					data.setFillupcol6Desc(rs.getString("fillupcol6_Desc"));
					data.setFillupcol7Desc(rs.getString("fillupcol7_Desc"));
					
					//Code Starts From Here Done By Roshan Tailor
					data.setCheckbladechange(rs.getString("checkbladechange"));
					data.setCheckbladechangeremark(rs.getString("checkbladechangeremark"));
					
					data.setCelovesforholes(rs.getString("celovesforholes"));
					data.setCelovesforholesremark(rs.getString("celovesforholesremark"));
					
					//Code Ends Here Done By Roshan Tailor
					}catch(Exception e)
					{
						System.out.println(e.getMessage());
					}
					 
					return data;
				}

			});
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return backTender;
	}

	@Override
	public long getDataCountDatePercentage(String position,String shift, String sdate,String edate) throws Exception {
		
		SimpleDateFormat format=new SimpleDateFormat("MM-dd-yyyy");		
		List<BackTender> daydata=null, nightdata=null;
		if(shift.equals("both"))
		{
			 daydata=getOperatorDataList(position,"day",sdate,edate);
			 nightdata=getOperatorDataList(position,"night",sdate,edate);
		}else if(shift.equals("day"))
		{
			daydata=getOperatorDataList(position,"day",sdate,edate);
		}
		else
		{
			nightdata=getOperatorDataList(position,"night",sdate,edate);
		}
			
		
		int count=0,no=0;long set=0,daypercent=0,nightpercent=0,percentage=0;
		int days = CommonUtil.getDaysDiffernce(format.parse(sdate), format.parse(edate))+1;
		List<Integer> al=new ArrayList<Integer>();
		List<Integer> al2=new ArrayList<Integer>();
		if(daydata!=null||nightdata!=null)	
		{
			if(shift.equals("day")||shift.equals("both"))
			{
			for(BackTender data:daydata){
			 if(data.isMachinedown()!=true)
			{
				 if(data.getReelCol1()!=null&&!data.getReelCol1().equals(""))
				 {count++;}
				 if(data.getReelCol2()!=null&&!data.getReelCol2().equals("")){count++;} 
				 if(data.getReelCol3Inbound()!=null&&!data.getReelCol3Inbound().equals(""))
				 {count++;} 				 
				 if(data.getReelCol3Outbound()!=null&&!data.getReelCol3Outbound().equals("")) 
				 {count++;} 
				if(data.isReelCol4() == true&&data.isReelCol4() == false)
				{count++;} 
				 if(data.getReelCol5()!=null&&!data.getReelCol5().equals("")) 
				 {count++;} 
				 if(data.getMachineLubricationCol1()!=null&&!data.getMachineLubricationCol1().equals("")) 
				 {count++;} 
				 if(data.getMachineLubricationCol2()!=null&&!data.getMachineLubricationCol2().equals("")) 
				{count++;} 
				if(data.getMachineLubricationCol3() != null)
				{count++;} 
				 if(data.getMachineLubricationCol4()!=null&&!data.getMachineLubricationCol4().equals("")) 
				 {count++;} 
				 if(data.getMachineLubricationCol5()!=null&&!data.getMachineLubricationCol5().equals("")) 
				 {count++;} 
				if(data.isCondensateCol1() == true&&data.isCondensateCol1() == false)
				{count++;} 
				 if(data.getCondensateCol2Inbound()!=null&&!data.getCondensateCol2Inbound().equals("")) 
				 {count++;} 
				 if(data.getCondensateCol2Outbound()!=null&&!data.getCondensateCol2Outbound().equals("")) 
				 {count++;} 
				if(data.isCondensateCol3() == true&&data.isCondensateCol3() == false)
				{count++;} 
				
				 if(data.getCondensateCol4Inbound()!=null&&!data.getCondensateCol4Inbound().equals("")) 
				 {count++;} 
				 if(data.getCondensateCol4Outbound()!=null&&!data.getCondensateCol4Outbound().equals("")) 
				 {count++;} 
				 
				if(data.isCondensateCol5() == true&&data.isCondensateCol3() == false)
				{count++;} 
				if(data.isCondensateCol6() == true&&data.isCondensateCol3() == false)
				{count++;} 
				 if(data.getCondensateCol7Inbound()!=null&&!data.getCondensateCol7Inbound().equals("")) 
				 {count++;} 
				if(data.getCondensateCol7Outbound()!=null&&!data.getCondensateCol7Outbound().equals("")) 
				 {count++;} 
				if(data.isCondensateCol8() == true&&data.isCondensateCol8() == false)
				{count++;} 
				 if(data.getCondensateCol9Inbound()!=null&&!data.getCondensateCol9Inbound().equals("")) 
				 {count++;} 				
				if(data.getCondensateCol9Outbound()!=null&&!data.getCondensateCol9Outbound().equals("")) 
				 {count++;} 
				if(data.isCondensateCol10() == true&&data.isCondensateCol10() == false)
				{count++;} 
				 if(data.getCondensateCol11Inbound()!=null&&!data.getCondensateCol11Inbound().equals("")) 
				 {count++;} 
				 if(data.getCondensateCol11Outbound()!=null&&!data.getCondensateCol11Outbound().equals("")) 
				 {count++;} 
				if(data.isCondensateCol12() == true&&data.isCondensateCol12() == false)
				{count++;} 
				if(data.isCondensateCol13() == true&&data.isCondensateCol13() == false)
				{count++;} 
				 if(data.getCondensateCol14Inbound()!=null&&!data.getCondensateCol14Inbound().equals("")) 
				 {count++;} 
				if(data.getCondensateCol14Outbound()!=null&&!data.getCondensateCol14Outbound().equals("")) 
				 {count++;} 
				if(data.getCondensateCol15()!= null)
				{count++;} 
				if(data.isShowerWaterCol1() == true&&data.isShowerWaterCol1() == false)
				{count++;} 
				if(data.isShowerWaterCol2() == true&&data.isShowerWaterCol2() == false)
				{count++;} 
				 if(data.getShowerWaterCol3Inbound()!=null&&!data.getShowerWaterCol3Inbound().equals("")) 
				 {count++;} 
				 if(data.getShowerWaterCol3Outbound()!=null&&!data.getShowerWaterCol3Outbound().equals("")) 
				{count++;} 
				if(data.isShowerWaterCol4() == true&&data.isShowerWaterCol4() == false)
				{count++;} 
				 if(data.getShowerWaterCol5Inbound()!=null&&!data.getShowerWaterCol5Inbound().equals("")) 
				{count++;} 
				if(data.getShowerWaterCol5Outbound()!=null&&!data.getShowerWaterCol5Outbound().equals("")) 
				{count++;} 
				if(data.isShowerWaterCol6() == true&&data.isShowerWaterCol6() == false)
				{count++;} 
				 if(data.getShowerWaterCol7Inbound()!=null&&!data.getShowerWaterCol7Inbound().equals("")) 
				 {count++;} 
				 if(data.getShowerWaterCol7Outbound()!=null&&!data.getShowerWaterCol7Outbound().equals("")) 
				 {count++;} 
				 if(data.getShowerWaterCol8()!=null&&!data.getShowerWaterCol8().equals("")) 
				 {count++;} 
				 if(data.getShowerWaterCol9()!=null&&!data.getShowerWaterCol9().equals("")) 
				 {count++;} 
				 if(data.getLubricationCol1()!=null&&!data.getLubricationCol1().equals("")) 
				 {count++;} 
				 if(data.getLubricationCol2()!=null&&!data.getLubricationCol2().equals("")) 
				 {count++;} 
				 if(data.getLubricationCol3()!=null&&!data.getLubricationCol3().equals("")) 
				  {count++;} 
				 if(data.getLubricationCol4()!=null&&!data.getLubricationCol4().equals("")) 
				 {count++;} 
				 if(data.getLubricationCol5()!=null&&!data.getLubricationCol5().equals("")) 
				 {count++;} 
				 if(data.getLubricationCol6()!=null&&!data.getLubricationCol6().equals("")) 
				 {count++;} 
				 if(data.getLubricationCol7()!=null&&!data.getLubricationCol7().equals("")) 
				 {count++;} 
				 if(data.getFillupcol1()!=null&&!data.getFillupcol1().equals("")) 
				  {count++;} 
				 if(data.getFillupcol2()!=null&&!data.getFillupcol2().equals("")) 
				 {count++;} 
				 if(data.getFillupcol3()!=null&&!data.getFillupcol3().equals("")) 
				 {count++;} 
				 if(data.getFillupcol5()!=null&&!data.getFillupcol5().equals("")) 
				  {count++;} 
				 if(data.getFillupcol6()!=null&&!data.getFillupcol6().equals("")) 
				 {count++;} 
				 if(data.getFillupcol7()!=null&&!data.getFillupcol7().equals("")) 
				 {count++;} 
			}else
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
		if(shift.equals("night")||shift.equals("both"))
		{
		 	for(BackTender data:nightdata){
				if(data.isMachinedown()!=true)
				{						
						if(data.isAfterDryerCol1() == true&&data.isAfterDryerCol1() == true)
						{count++;}
						 if(data.getAfterDryerCol2()!=null&&!data.getAfterDryerCol2().equals("")){count++;} 
						
						 if(data.getAfterDryerCol3()!=null&&!data.getAfterDryerCol3().equals("")){count++;} 
						
						if(data.isAfterDryerCol4() == true&&data.isAfterDryerCol4() == true)
						{count++;}
						if(data.getAfterDryerCol5()!= null)
						{count++;}
						if(data.getAfterDryerCol6()!= null)
						{count++;}
						if(data.isEqptScannerCol1() == true&&data.isEqptScannerCol1() == true)
						{count++;}						
						if(data.getEqptScannerCol2()!= null)
						{count++;}
						if(data.isEqptScannerCol3() == true&&data.isEqptScannerCol3() == true)
						{count++;}
						if(data.isEqptScannerCol4() == true&&data.isEqptScannerCol4() == true)
						{count++;}
						if(data.isEqptScannerCol5() == true&&data.isEqptScannerCol5() == true)
						{count++;}
						if(data.isEqptReelSectionCol1() == true&&data.isEqptReelSectionCol1() == true)
						{count++;}
						 if(data.getEqptReelSectionCol2()!=null&&!data.getEqptReelSectionCol2().equals("")){count++;}
						
						 if(data.getEqptReelSectionCol3()!=null&&!data.getEqptReelSectionCol3().equals("")){count++;}
						
						 if(data.getEqptReelSectionCol4()!=null&&!data.getEqptReelSectionCol4().equals("")){count++;}
						
						 if(data.getEqptReelSectionCol5()!=null&&!data.getEqptReelSectionCol5().equals("")){count++;}
						 
						if(data.isOilFlowCol1() == true&&data.isOilFlowCol1() == true)
						{count++;}
						if(data.isOilFlowCol2() == true&&data.isOilFlowCol2() == true)
						{count++;}
						if(data.isOilFlowCol3() == true&&data.isOilFlowCol3() == true)
						{count++;}
						if(data.isOilFlowCol4() == true&&data.isOilFlowCol4() == true)
						{count++;}
						 if(data.getOilFlowCol5()!=null&&!data.getOilFlowCol5().equals("")){count++;}
						 
						 if(data.getOilFlowCol6()!=null&&!data.getOilFlowCol6().equals("")){count++;}
						
						 if(data.getOilFlowCol7()!=null&&!data.getOilFlowCol7().equals("")){count++;}
						
						if(data.isMezzanineCol1() == true&&data.isMezzanineCol1() == true)
						{count++;}
						if(data.isMezzanineCol2() == true&&data.isMezzanineCol2() == true)
						{count++;}
						if(data.isMezzanineCol3() == true&&data.isMezzanineCol3() == true)
						{count++;}
						if(data.isMezzanineCol4() == true&&data.isMezzanineCol4() == true)
						{count++;}
						if(data.isMezzanineCol5() == true&&data.isMezzanineCol5() == true)
						{count++;}
						 if(data.getFillupcol1()!=null&&!data.getFillupcol1().equals("")){count++;}
						
						 if(data.getFillupcol2()!=null&&!data.getFillupcol2().equals("")){count++;}
						
						 if(data.getFillupcol3()!=null&&!data.getFillupcol3().equals("")){count++;}
						
						 if(data.getFillupcol4()!=null&&!data.getFillupcol4().equals("")){count++;}
						 
						 if(data.getFillupcol5()!=null&&!data.getFillupcol5().equals("")){count++;}
						
						 if(data.getFillupcol6()!=null&&!data.getFillupcol6().equals("")){count++;}
						 
						 if(data.getFillupcol7()!=null&&!data.getFillupcol7().equals("")){count++;}
				}else 
					count=6;
				al2.add(count);
				count=0;
			}
			 set=0;
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
	
	
	/*	 (non-Javadoc)
	 * @see com.st.obcc.dao.BackTenderDao#getDataCountDatePercentage(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 
	@Override
	public long getDataCountDatePercentage(String position, String Sdate,
			String edate, String shift) throws Exception {
		// TODO Auto-generated method stub
		
		Date sDate=CommonUtil.checkDate(Sdate, dateFormat);
		Date esDate=CommonUtil.checkDate(edate, dateFormat);
		
		final  int days=CommonUtil.getDaysDiffernce(sDate, esDate);
         int total1 = 0;
         
        
        if(shift.equalsIgnoreCase("day")|| shift.equalsIgnoreCase("night")){
        	total1 = days;
        }else{
        	total1 = days*2;
        }

        final int total = total1;
        
        
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSourceQRT);
		Object[] param=null;
		String sql;
		 
			if(shift.equalsIgnoreCase("day")|| shift.equalsIgnoreCase("night"))
			{
				sql="SELECT COUNT(*) As [TotalDataEntry], ( "
						+ "SELECT COUNT(*) As [totaldata] "
						+ "FROM backTender "
						+ " WHERE (date between ? AND ? ) and shift=?"
						+ " )as TotalExport FROM backTender e1 where shift=?";
						param=new Object[]{
							Sdate,
							edate,
							shift,
							shift
						};
			}
			else
			{
				sql="SELECT COUNT(*) As [TotalDataEntry], ( "
						+ "SELECT COUNT(*) As [totaldata] "
						+ "FROM backTender "
						+ " WHERE (date between ? AND ? )"
						+ " )as TotalExport FROM backTender e1 ";
						param=new Object[]{
							Sdate,
							edate	
						};
			}
			
			 
			List<BackTender> wrapperProductions=null;
			try {
				wrapperProductions=jdbcTemplate.query(sql,param, new RowMapper<BackTender>(){

							@Override
							public BackTender mapRow(ResultSet rs, int arg1)
									throws SQLException {
								
								
								int totalDataEntry = rs.getInt("TotalDataEntry");
								int totalExport = rs.getInt("TotalExport");
								
								int percentage = 0;
								if(total == 0)
								{
									percentage = 100;	
								}
								else
								{
									percentage = totalExport*100/total;
								}
								
								
								BackTender wrapperProduction=new BackTender();
								wrapperProduction.setProcessbarpercentage(percentage);
								return wrapperProduction;
							}
							
						});
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return wrapperProductions.get(0).getProcessbarpercentage();
	}

	 (non-Javadoc)
	 * @see com.st.obcc.dao.BackTenderDao#getDataCountDatePercentage(java.lang.String, java.lang.String)
	 
	@Override
	public double getDataCountDatePercentage(String Sdate, String edate)
			throws Exception {
		// TODO Auto-generated method stub
SimpleDateFormat dateFormat=new SimpleDateFormat("MM-dd-yyyy");
		
		Date sDate=CommonUtil.checkDate(Sdate, dateFormat);
		Date esDate=CommonUtil.checkDate(edate, dateFormat);
		
 
        
        
		final  int days=CommonUtil.getDaysDiffernce(sDate, esDate);
        
        final int total = days*2;
        
       // System.out.println("getDaysDiff"+days);
		
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSourceQRT);
		Object[] param=null;
		String sql;
		 
			sql="SELECT COUNT(*) As [TotalDataEntry], ( "
					+ "SELECT COUNT(*) As [totaldata] "
					+ "FROM backTender "
					+ " WHERE (date between ? AND ? )"
					+ " )as TotalExport FROM backTender e1 ";
					param=new Object[]{
							Sdate,
						edate	
					};
			 
			List<BackTender> wrapperProductions=null;
			try {
				wrapperProductions=jdbcTemplate.query(sql,param, new RowMapper<BackTender>(){

							@Override
							public BackTender mapRow(ResultSet rs, int arg1)
									throws SQLException {
								
								
								int totalDataEntry = rs.getInt("TotalDataEntry");
								int totalExport = rs.getInt("TotalExport");
								
								//int percentage = totalExport*100/totalDataEntry;
								double percentage = totalExport*100/total;
								
								
								BackTender wrapperProduction=new BackTender();
								wrapperProduction.setPercentage(percentage);
								return wrapperProduction;
							}
							
						});
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return wrapperProductions.get(0).getPercentage();
	}
	*/

}

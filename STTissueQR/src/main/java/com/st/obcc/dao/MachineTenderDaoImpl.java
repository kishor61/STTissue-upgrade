/**
 *Jun 22, 2016
 *MachineTenderDaoImpl.java
 * TODO
 *com.st.obcc.dao
 *MachineTenderDaoImpl.java
 *Sunil Singh Bora
 */
package com.st.obcc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
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
import com.st.obcc.model.OperatorData;
import com.st.obcc.model.R1Operator;
import com.st.obcc.model.UtilityOperator;
import com.st.obccPM5.model.LeadOperatorPM5;

/**
 * @author roshan
 *
 */
@Repository
public class MachineTenderDaoImpl implements MachineTenderDao {

	@Autowired
	@Qualifier("dataSourceOBCC")
	private DataSource dataSourceQRT;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.st.obcc.dao.MachineTenderDao#getOperatorData(java.lang.String,
	 * java.lang.String, java.lang.String, java.lang.String)
	 */
	private SimpleDateFormat dateFormat=new SimpleDateFormat("MM-dd-yyyy");
	private SimpleDateFormat fromuser=new SimpleDateFormat("yyyy-MM-dd");
	
	@Override
	public MachineTender getOperatorData(String position, String date,
			String shift, String crew) throws Exception {
		// TODO Auto-generated method stub

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSourceQRT);
		String sql = "select * from [machineTender] where [position]=? AND [date]=? AND [shift] = ?  ";

		MachineTender machineTender = null;
		try {
			machineTender = jdbcTemplate.queryForObject(sql, new Object[] {
					position, date, shift},
					new RowMapper<MachineTender>() {

						@Override
						public MachineTender mapRow(ResultSet rs, int arg1)
								throws SQLException {
							MachineTender data = new MachineTender();
							data.setId(rs.getInt("id"));
							data.setPosition(rs.getString("position"));
							data.setOperatorName(rs.getString("operator_name"));
							data.setEdate(rs.getString("date"));
							data.setShift(rs.getString("shift"));
							data.setCrew(rs.getString("crew"));

							data.setFormingSectionCol1(rs
									.getString("forming_Section_col1"));
							data.setFormingSectionCol2(rs
									.getString("forming_Section_col2"));
							data.setFormingSectionCol3(rs
									.getString("forming_Section_col3"));
							data.setFormingSectionCol4(rs
									.getString("forming_Section_col4"));
							data.setFormingSectionCol5(rs
									.getString("forming_Section_col5"));
							data.setFormingSectionCol6(rs
									.getString("forming_Section_col6"));
							data.setFormingSectionCol7(rs
									.getString("forming_Section_col7"));
							data.setFormingSectionCol8(rs
									.getString("forming_Section_col8"));
							data.setFormingSectionCol9(rs
									.getString("forming_Section_col9"));
							data.setFormingSectionCol10(rs
									.getString("forming_Section_col10"));
							data.setFormingSectionCol11(rs
									.getString("forming_Section_col11"));
							data.setFormingSectionCol12(rs
									.getString("forming_Section_col12"));
							data.setFormingSectionCol13(rs
									.getBoolean("forming_Section_col13"));
							data.setFormingSectionCol14(rs
									.getBoolean("forming_Section_col14"));

							data.setFormingSectionCol1Desc(rs
									.getString("forming_Section_col1_Desc"));
							data.setFormingSectionCol2Desc(rs
									.getString("forming_Section_col2_Desc"));
							data.setFormingSectionCol3Desc(rs
									.getString("forming_Section_col3_Desc"));
							data.setFormingSectionCol4Desc(rs
									.getString("forming_Section_col4_Desc"));
							data.setFormingSectionCol5Desc(rs
									.getString("forming_Section_col5_Desc"));
							data.setFormingSectionCol6Desc(rs
									.getString("forming_Section_col6_Desc"));
							data.setFormingSectionCol7Desc(rs
									.getString("forming_Section_col7_Desc"));
							data.setFormingSectionCol8Desc(rs
									.getString("forming_Section_col8_Desc"));
							data.setFormingSectionCol9Desc(rs
									.getString("forming_Section_col9_Desc"));
							data.setFormingSectionCol10Desc(rs
									.getString("forming_Section_col10_Desc"));
							data.setFormingSectionCol11Desc(rs
									.getString("forming_Section_col11_Desc"));
							data.setFormingSectionCol12Desc(rs
									.getString("forming_Section_col12_Desc"));
							data.setFormingSectionCol13Desc(rs
									.getString("forming_Section_col13_Desc"));
							data.setFormingSectionCol14Desc(rs
									.getString("forming_Section_col14_Desc"));

							data.setSuctionPressureRollCol1(rs
									.getString("suction_pressure_Roll_col1"));
							data.setSuctionPressureRollCol2(rs
									.getString("suction_pressure_Roll_col2"));
							data.setSuctionPressureRollCol3(rs
									.getString("suction_pressure_Roll_col3"));
							data.setSuctionPressureRollCol4(rs
									.getString("suction_pressure_Roll_col4"));
							data.setSuctionPressureRollCol5(rs
									.getString("suction_pressure_Roll_col5"));
							data.setSuctionPressureRollCol6(rs
									.getString("suction_pressure_Roll_col6"));
							data.setSuctionPressureRollCol7(rs
									.getBoolean("suction_pressure_Roll_col7"));

							data.setSuctionPressureRollCol1Desc(rs
									.getString("suction_pressure_Roll_col1_Desc"));
							data.setSuctionPressureRollCol2Desc(rs
									.getString("suction_pressure_Roll_col2_Desc"));
							data.setSuctionPressureRollCol3Desc(rs
									.getString("suction_pressure_Roll_col3_Desc"));
							data.setSuctionPressureRollCol4Desc(rs
									.getString("suction_pressure_Roll_col4_Desc"));
							data.setSuctionPressureRollCol5Desc(rs
									.getString("suction_pressure_Roll_col5_Desc"));
							data.setSuctionPressureRollCol6Desc(rs
									.getString("suction_pressure_Roll_col6_Desc"));
							data.setSuctionPressureRollCol7Desc(rs
									.getString("suction_pressure_Roll_col7_Desc"));

							data.setYankeeDryerCol1(rs
									.getString("yankee_Dryer_col1"));
							data.setYankeeDryerCol2(rs
									.getString("yankee_Dryer_col2"));
							data.setYankeeDryerCol3(rs
									.getBoolean("yankee_Dryer_col3"));
							data.setYankeeDryerCol4(rs
									.getString("yankee_Dryer_col4"));
							data.setYankeeDryerCol5(rs
									.getBoolean("yankee_Dryer_col5"));

							data.setYankeeDryerCol1Desc(rs
									.getString("yankee_Dryer_col1_Desc"));
							data.setYankeeDryerCol2Desc(rs
									.getString("yankee_Dryer_col2_Desc"));
							data.setYankeeDryerCol3Desc(rs
									.getString("yankee_Dryer_col3_Desc"));
							data.setYankeeDryerCol4Desc(rs
									.getString("yankee_Dryer_col4_Desc"));
							data.setYankeeDryerCol5Desc(rs
									.getString("yankee_Dryer_col5_Desc"));

							data.setDriveRollCol1(rs
									.getString("drive_Roll_col1"));
							data.setDriveRollCol2(rs
									.getString("drive_Roll_col2"));
							data.setDriveRollCol3(rs
									.getString("drive_Roll_col3"));
							data.setDriveRollCol4(rs
									.getString("drive_Roll_col4"));
							data.setDriveRollCol5(rs
									.getString("drive_Roll_col5"));
							data.setDriveRollCol6(rs
									.getString("drive_Roll_col6"));
							data.setDriveRollCol7(rs
									.getString("drive_Roll_col7"));

							data.setDriveRollCol1Desc(rs
									.getString("drive_Roll_col1_Desc"));
							data.setDriveRollCol2Desc(rs
									.getString("drive_Roll_col2_Desc"));
							data.setDriveRollCol3Desc(rs
									.getString("drive_Roll_col3_Desc"));
							data.setDriveRollCol4Desc(rs
									.getString("drive_Roll_col4_Desc"));
							data.setDriveRollCol5Desc(rs
									.getString("drive_Roll_col5_Desc"));
							data.setDriveRollCol6Desc(rs
									.getString("drive_Roll_col6_Desc"));
							data.setDriveRollCol7Desc(rs
									.getString("drive_Roll_col7_Desc"));

							data.setPressSectionCol1(rs
									.getString("press_Section_col1"));
							data.setPressSectionCol2(rs
									.getString("press_Section_col2"));
							data.setPressSectionCol3(rs
									.getString("press_Section_col3"));
							data.setPressSectionCol4(rs
									.getString("press_Section_col4"));
							data.setPressSectionCol5(rs
									.getString("press_Section_col5"));
							data.setPressSectionCol6(rs
									.getBoolean("press_Section_col6"));
							data.setPressSectionCol7(rs
									.getString("press_Section_col7"));
							data.setPressSectionCol8(rs
									.getBoolean("press_Section_col8"));

							data.setPressSectionCol1Desc(rs
									.getString("press_Section_col1_Desc"));
							data.setPressSectionCol2Desc(rs
									.getString("press_Section_col2_Desc"));
							data.setPressSectionCol3Desc(rs
									.getString("press_Section_col3_Desc"));
							data.setPressSectionCol4Desc(rs
									.getString("press_Section_col4_Desc"));
							data.setPressSectionCol5Desc(rs
									.getString("press_Section_col5_Desc"));
							data.setPressSectionCol6Desc(rs
									.getString("press_Section_col6_Desc"));
							data.setPressSectionCol7Desc(rs
									.getString("press_Section_col7_Desc"));
							data.setPressSectionCol8Desc(rs
									.getString("press_Section_col8_Desc"));

							data.setUpperPressCol1(rs
									.getString("upper_press_col1"));
							data.setUpperPressCol2(rs
									.getString("upper_press_col2"));
							data.setUpperPressCol3(rs
									.getBoolean("upper_press_col3"));
							data.setUpperPressCol4(rs
									.getBoolean("upper_press_col4"));
							data.setUpperPressCol5(rs
									.getBoolean("upper_press_col5"));
							data.setUpperPressCol6(rs
									.getBoolean("upper_press_col6"));
							data.setUpperPressCol7(rs
									.getBoolean("upper_press_col7"));
							data.setUpperPressCol8(rs
									.getBoolean("upper_press_col8"));
							data.setUpperPressCol9(rs
									.getString("upper_press_col9"));

							data.setUpperPressCol1Desc(rs
									.getString("upper_press_col1_Desc"));
							data.setUpperPressCol2Desc(rs
									.getString("upper_press_col2_Desc"));
							data.setUpperPressCol3Desc(rs
									.getString("upper_press_col3_Desc"));
							data.setUpperPressCol4Desc(rs
									.getString("upper_press_col4_Desc"));
							data.setUpperPressCol5Desc(rs
									.getString("upper_press_col5_Desc"));
							data.setUpperPressCol6Desc(rs
									.getString("upper_press_col6_Desc"));
							data.setUpperPressCol7Desc(rs
									.getString("upper_press_col7_Desc"));
							data.setUpperPressCol8Desc(rs
									.getString("upper_press_col8_Desc"));
							data.setUpperPressCol9Desc(rs
									.getString("upper_press_col9_Desc"));

							data.setChemicalTotesCol1(rs
									.getString("chemical_totes_col1"));
							data.setChemicalTotesCol2(rs
									.getString("chemical_totes_col2"));
							data.setChemicalTotesCol3(rs
									.getString("chemical_totes_col3"));
							data.setChemicalTotesCol4(rs
									.getString("chemical_totes_col4"));
							data.setChemicalTotesCol5(rs
									.getString("chemical_totes_col5"));

							data.setChemicalTotesCol1Desc(rs
									.getString("chemical_totes_col1_Desc"));
							data.setChemicalTotesCol2Desc(rs
									.getString("chemical_totes_col2_Desc"));
							data.setChemicalTotesCol3Desc(rs
									.getString("chemical_totes_col3_Desc"));
							data.setChemicalTotesCol4Desc(rs
									.getString("chemical_totes_col4_Desc"));
							data.setChemicalTotesCol5Desc(rs
									.getString("chemical_totes_col5_Desc"));

							data.setFanPumpCol1(rs.getString("fan_pump_col1"));
							data.setFanPumpCol2(rs.getBoolean("fan_pump_col2"));
							
							data.setFanPumpCol3Inbound(rs.getString("fan_pump_col3_west"));
							data.setFanPumpCol3Outbound(rs.getString("fan_pump_col3_east"));
							 
							data.setFanPumpCol4Inbound(rs.getString("fan_pump_col4_inbound"));
							data.setFanPumpCol4Outbound(rs.getString("fan_pump_col4_outbound"));
							 
							 
							data.setFanPumpCol1Desc(rs
									.getString("fan_pump_col1_Desc"));
							data.setFanPumpCol2Desc(rs
									.getString("fan_pump_col2_Desc"));
							data.setFanPumpCol3Desc(rs
									.getString("fan_pump_col3_Desc"));
							data.setFanPumpCol4Desc(rs
									.getString("fan_pump_col4_Desc"));

							data.setSelectifierScreenCol1(rs
									.getString("selectifier_Screen_col1"));
							data.setSelectifierScreenCol2(rs
									.getString("selectifier_Screen_col2"));
							data.setSelectifierScreenCol3(rs
									.getString("selectifier_Screen_col3"));
							
							data.setSelectifierScreenCol4Inbound(rs.getString("selectifier_Screen_col4_inbound"));
							data.setSelectifierScreenCol4Outbound(rs.getString("selectifier_Screen_col4_outbound"));
							
							
							data.setSelectifierScreenCol5(rs.getString("selectifier_Screen_col5"));
							
							data.setSelectifierScreenCol6Inbound(rs.getString("selectifier_Screen_col6_inbound"));
							data.setSelectifierScreenCol6Outbound(rs.getString("selectifier_Screen_col6_outbound"));
							
							data.setSelectifierScreenCol7(rs
									.getString("selectifier_Screen_col7"));
							data.setSelectifierScreenCol8(rs
									.getBoolean("selectifier_Screen_col8"));
							
							
							data.setSelectifierScreenCol9Inbound(rs.getString("selectifier_Screen_col9_inbound"));
							data.setSelectifierScreenCol9Outbound(rs.getString("selectifier_Screen_col9_outbound"));
							
							data.setSelectifierScreenCol10(rs.getBoolean("selectifier_Screen_col10"));
							data.setSelectifierScreenCol11Inbound(rs.getString("selectifier_Screen_col11_inbound"));
							data.setSelectifierScreenCol11Outbound(rs.getString("selectifier_Screen_col11_outbound"));
							 

							data.setSelectifierScreenCol1Desc(rs.getString("selectifier_Screen_col1_Desc"));
							data.setSelectifierScreenCol2Desc(rs.getString("selectifier_Screen_col2_Desc"));
							data.setSelectifierScreenCol3Desc(rs.getString("selectifier_Screen_col3_Desc"));
							data.setSelectifierScreenCol4Desc(rs.getString("selectifier_Screen_col4_Desc"));
							data.setSelectifierScreenCol5Desc(rs.getString("selectifier_Screen_col5_Desc"));
							data.setSelectifierScreenCol6Desc(rs.getString("selectifier_Screen_col6_Desc"));
							data.setSelectifierScreenCol7Desc(rs.getString("selectifier_Screen_col7_Desc"));
							data.setSelectifierScreenCol8Desc(rs.getString("selectifier_Screen_col8_Desc"));
							data.setSelectifierScreenCol9Desc(rs.getString("selectifier_Screen_col9_Desc"));
							data.setSelectifierScreenCol10Desc(rs.getString("selectifier_Screen_col10_Desc"));
							data.setSelectifierScreenCol11Desc(rs.getString("selectifier_Screen_col11_Desc"));
							 

							data.setVacumePumpCol1(rs.getBoolean("vacume_pump_col1"));
							data.setVacumePumpCol2(rs.getBoolean("vacume_pump_col2"));
							data.setVacumePumpCol3(rs.getBoolean("vacume_pump_col3"));
							
							data.setVacumePumpCol4Inbound(rs.getString("vacume_pump_col4_inbound"));
							data.setVacumePumpCol4Outbound(rs.getString("vacume_pump_col4_outbound"));
							
							data.setVacumePumpCol5Inbound(rs.getString("vacume_pump_col5_inbound"));
							data.setVacumePumpCol5Outbound(rs.getString("vacume_pump_col5_outbound"));
							
							
							data.setVacumePumpCol6(rs.getBoolean("vacume_pump_col6"));
							
							data.setVacumePumpCol7Inbound(rs.getString("vacume_pump_col7_inbound"));
							data.setVacumePumpCol7Outbound(rs.getString("vacume_pump_col7_outbound"));
							
							
							data.setVacumePumpCol8(rs.getBoolean("vacume_pump_col8"));
							
							data.setVacumePumpCol9(rs.getString("vacume_pump_col9"));
							
							data.setVacumePumpCol10(rs.getString("vacume_pump_col10"));
							
							data.setVacumePumpCol11(rs.getBoolean("vacume_pump_col11"));
							data.setVacumePumpCol12(rs.getString("vacume_pump_col12"));
							data.setVacumePumpCol13(rs.getString("vacume_pump_col13"));
							data.setVacumePumpCol14(rs.getBoolean("vacume_pump_col14"));
							
							data.setVacumePumpCol15Inbound(rs.getString("vacume_pump_col15_inbound"));
							data.setVacumePumpCol15Outbound(rs.getString("vacume_pump_col15_outbound"));
							
							data.setVacumePumpCol16(rs.getBoolean("vacume_pump_col16"));
							data.setVacumePumpCol17(rs.getString("vacume_pump_col17"));
							data.setVacumePumpCol18(rs.getString("vacume_pump_col18"));
							data.setVacumePumpCol19(rs.getBoolean("vacume_pump_col19"));
							data.setVacumePumpCol20(rs.getString("vacume_pump_col20"));
							data.setVacumePumpCol21(rs.getString("vacume_pump_col21"));
							data.setVacumePumpCol22(rs.getBoolean("vacume_pump_col22"));
							data.setVacumePumpCol23(rs.getString("vacume_pump_col23"));
							data.setVacumePumpCol24(rs.getString("vacume_pump_col24"));
							data.setVacumePumpCol25(rs.getBoolean("vacume_pump_col25"));
							data.setVacumePumpCol26(rs.getString("vacume_pump_col26"));
							data.setVacumePumpCol27(rs.getString("vacume_pump_col27"));
							data.setVacumePumpCol28(rs.getBoolean("vacume_pump_col28"));
							data.setVacumePumpCol29(rs.getString("vacume_pump_col29"));
							data.setVacumePumpCol30(rs.getString("vacume_pump_col30"));
							data.setVacumePumpCol31(rs.getBoolean("vacume_pump_col31"));
							data.setVacumePumpCol32(rs.getString("vacume_pump_col32"));
							data.setVacumePumpCol33(rs.getString("vacume_pump_col33"));
							data.setVacumePumpCol34(rs.getBoolean("vacume_pump_col34"));
							data.setVacumePumpCol35(rs.getString("vacume_pump_col35"));
							data.setVacumePumpCol36(rs.getString("vacume_pump_col36"));

							data.setVacumePumpCol1Desc(rs.getString("vacume_pump_col1_Desc"));
							data.setVacumePumpCol2Desc(rs.getString("vacume_pump_col2_Desc"));
							data.setVacumePumpCol3Desc(rs.getString("vacume_pump_col3_Desc"));
							data.setVacumePumpCol4Desc(rs.getString("vacume_pump_col4_Desc"));
							data.setVacumePumpCol5Desc(rs.getString("vacume_pump_col5_Desc"));
							data.setVacumePumpCol6Desc(rs.getString("vacume_pump_col6_Desc"));
							data.setVacumePumpCol7Desc(rs.getString("vacume_pump_col7_Desc"));
							data.setVacumePumpCol8Desc(rs.getString("vacume_pump_col8_Desc"));
							data.setVacumePumpCol9Desc(rs.getString("vacume_pump_col9_Desc"));
							data.setVacumePumpCol10Desc(rs.getString("vacume_pump_col10_Desc"));
							data.setVacumePumpCol11Desc(rs.getString("vacume_pump_col11_Desc"));
							data.setVacumePumpCol12Desc(rs.getString("vacume_pump_col12_Desc"));
							data.setVacumePumpCol13Desc(rs.getString("vacume_pump_col13_Desc"));
							data.setVacumePumpCol14Desc(rs.getString("vacume_pump_col14_Desc"));
							data.setVacumePumpCol15Desc(rs.getString("vacume_pump_col15_Desc"));
							data.setVacumePumpCol16Desc(rs.getString("vacume_pump_col16_Desc"));
							data.setVacumePumpCol17Desc(rs
									.getString("vacume_pump_col17_Desc"));
							data.setVacumePumpCol18Desc(rs
									.getString("vacume_pump_col18_Desc"));

							data.setVacumePumpCol19Desc(rs
									.getString("vacume_pump_col19_Desc"));
							data.setVacumePumpCol20Desc(rs
									.getString("vacume_pump_col20_Desc"));
							data.setVacumePumpCol21Desc(rs
									.getString("vacume_pump_col21_Desc"));
							data.setVacumePumpCol22Desc(rs
									.getString("vacume_pump_col22_Desc"));

							data.setVacumePumpCol23Desc(rs
									.getString("vacume_pump_col23_Desc"));
							data.setVacumePumpCol24Desc(rs
									.getString("vacume_pump_col24_Desc"));

							data.setVacumePumpCol25Desc(rs
									.getString("vacume_pump_col25_Desc"));
							data.setVacumePumpCol26Desc(rs
									.getString("vacume_pump_col26_Desc"));
							data.setVacumePumpCol27Desc(rs
									.getString("vacume_pump_col27_Desc"));

							data.setVacumePumpCol28Desc(rs
									.getString("vacume_pump_col28_Desc"));
							data.setVacumePumpCol29Desc(rs
									.getString("vacume_pump_col29_Desc"));
							data.setVacumePumpCol30Desc(rs
									.getString("vacume_pump_col30_Desc"));

							data.setVacumePumpCol31Desc(rs
									.getString("vacume_pump_col31_Desc"));

							data.setVacumePumpCol32Desc(rs
									.getString("vacume_pump_col32_Desc"));
							data.setVacumePumpCol33Desc(rs
									.getString("vacume_pump_col33_Desc"));
							data.setVacumePumpCol34Desc(rs
									.getString("vacume_pump_col34_Desc"));
							data.setVacumePumpCol35Desc(rs
									.getString("vacume_pump_col35_Desc"));

							data.setVacumePumpCol36Desc(rs
									.getString("vacume_pump_col36_Desc"));

							data.setRiverWaterCol1(rs
									.getString("river_water_col1"));
							data.setRiverWaterCol2(rs
									.getString("river_water_col2"));
							
							data.setRiverWaterCol1Out(rs
									.getString("river_water_col1Out"));
							data.setRiverWaterCol2Out(rs
									.getString("river_water_col2Out"));

							data.setRiverWaterCol1Desc(rs
									.getString("river_water_col1_Desc"));
							data.setRiverWaterCol2Desc(rs
									.getString("river_water_col2_Desc"));
							
							data.setShowercol1(rs.getBoolean("showercol1"));
							data.setShowercol2North(rs.getString("showercol2North"));
							data.setShowercol2South(rs.getString("showercol2South"));
							data.setShowercol3(rs.getBoolean("showercol3"));
							data.setShowercol4North(rs.getString("showercol4North"));
							data.setShowercol4South(rs.getString("showercol4South"));
							data.setShowercol5(rs.getBoolean("showercol5"));
							data.setShowercol6North(rs.getString("showercol6North"));
							data.setShowercol6South(rs.getString("showercol6South"));
							data.setShowercol7(rs.getString("showercol7"));
							data.setShowercol7Out(rs.getString("showercol7Out"));
							
							
							data.setShowercol1Desc(rs.getString("showercol1Desc"));
							data.setShowercol2Desc(rs.getString("showercol2Desc"));
							data.setShowercol3Desc(rs.getString("showercol3Desc"));
							data.setShowercol4Desc(rs.getString("showercol4Desc"));
							data.setShowercol5Desc(rs.getString("showercol5Desc"));
							data.setShowercol6Desc(rs.getString("showercol6Desc"));
							data.setShowercol7Desc(rs.getString("showercol7Desc"));
							
							
							data.setFillupcentcol1(rs.getBoolean("fillupcentcol1"));
							data.setFillupcentcol2(rs.getBoolean("fillupcentcol2"));
							data.setFillupcentcol3(rs.getBoolean("fillupcentcol3"));
							data.setFillupcentcol4(rs.getBoolean("fillupcentcol4"));
							data.setFillupcentcol5(rs.getBoolean("fillupcentcol5"));
							data.setFillupcentcol6(rs.getString("fillupcentcol6"));
							data.setFillupcentcol7(rs.getString("fillupcentcol7"));
							data.setFillupcentcol8(rs.getBoolean("fillupcentcol8"));
							data.setFillupcentcol9(rs.getBoolean("fillupcentcol9"));
							 
							
							data.setFillupcentcol1Desc(rs.getString("fillupcentcol1Desc"));
							data.setFillupcentcol2Desc(rs.getString("fillupcentcol2Desc"));
							data.setFillupcentcol3Desc(rs.getString("fillupcentcol3Desc"));
							data.setFillupcentcol4Desc(rs.getString("fillupcentcol4Desc"));
							data.setFillupcentcol5Desc(rs.getString("fillupcentcol5Desc"));
							data.setFillupcentcol6Desc(rs.getString("fillupcentcol6Desc"));
							data.setFillupcentcol7Desc(rs.getString("fillupcentcol7Desc"));
							data.setFillupcentcol8Desc(rs.getString("fillupcentcol8Desc"));
							data.setFillupcentcol9Desc(rs.getString("fillupcentcol9Desc"));
							
							//Code Starts From Here Done By Roshan TAilor
							data.setCheckairfilterforheadbox(rs.getBoolean("checkairfilterforheadbox"));
							data.setCheckairfilterforheadboxremark(rs.getString("checkairfilterforheadboxremark"));
							
							data.setDriveRollCol8(rs.getString("driveRollCol8"));
							data.setDriveRollCol8Desc(rs.getString("driveRollCol8Desc"));
							
							
							data.setBlowwetendanddryendmotor(rs.getBoolean("blowwetendanddryendmotor"));
							data.setBlowwetendanddryendmotorremark(rs.getString("blowwetendanddryendmotorremark"));
							
							
							
							data.setCheckheadboxaircompressorintelfiltercleanliness(rs.getBoolean("checkheadboxaircompressorintelfiltercleanliness"));
							data.setCheckheadboxaircompressorintelfiltercleanlinessdesc(rs.getString("checkheadboxaircompressorintelfiltercleanlinessdesc"));
							
							
							data.setHeadboxairfilterscleaning(rs.getBoolean("headboxairfilterscleaning"));
							data.setHeadboxairfilterscleaningdesc(rs.getString("headboxairfilterscleaningdesc"));
							
							data.setRotatingShowers(rs.getBoolean("rotatingShowers"));
							data.setRotatingShowersremark(rs.getString("rotatingShowersremark"));
							
							data.setRotationShowersValve(rs.getBoolean("rotationShowersValve"));
							data.setRotationShowersValveremark(rs.getString("rotationShowersValveremark"));
							
							//Code Ends Here Done By Roshan Tailor
							 

							return data;
						}

					});
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return machineTender;
	}

	/* (non-Javadoc)
	 * @see com.st.obcc.dao.MachineTenderDao#saveorUpdate(com.st.obcc.model.MachineTender)
	 */
	@Override
	public void saveorUpdate(MachineTender data) {
		// TODO Auto-generated method stub
		
		NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(dataSourceQRT);
	 	MapSqlParameterSource paramSource=new MapSqlParameterSource();
	 	
	 	paramSource.addValue("position",data.getPosition());
		paramSource.addValue("operatorName",data.getOperatorName());
		paramSource.addValue("edate",data.getEdate());
		paramSource.addValue("crew",data.getCrew());
		paramSource.addValue("shift",data.getShift());
		
		paramSource.addValue("machinedown", data.isMachinedown());
		paramSource.addValue("formingSectionCol1",data.getFormingSectionCol1());
		paramSource.addValue("formingSectionCol2",data.getFormingSectionCol2());
		paramSource.addValue("formingSectionCol3",data.getFormingSectionCol3());
		paramSource.addValue("formingSectionCol4",data.getFormingSectionCol4());
		paramSource.addValue("formingSectionCol5",data.getFormingSectionCol5());
		paramSource.addValue("formingSectionCol6",data.getFormingSectionCol6());
		paramSource.addValue("formingSectionCol7",data.getFormingSectionCol7());
		paramSource.addValue("formingSectionCol8",data.getFormingSectionCol8());
		paramSource.addValue("formingSectionCol9",data.getFormingSectionCol9());
		paramSource.addValue("formingSectionCol10",data.getFormingSectionCol10());
		paramSource.addValue("formingSectionCol11",data.getFormingSectionCol11());
		paramSource.addValue("formingSectionCol12",data.getFormingSectionCol12());
		paramSource.addValue("formingSectionCol13",data.isFormingSectionCol13());
		paramSource.addValue("formingSectionCol14",data.isFormingSectionCol14());
		
		
		paramSource.addValue("formingSectionCol1Desc",data.getFormingSectionCol1Desc());
		paramSource.addValue("formingSectionCol2Desc",data.getFormingSectionCol2Desc());
		paramSource.addValue("formingSectionCol3Desc",data.getFormingSectionCol3Desc());
		paramSource.addValue("formingSectionCol4Desc",data.getFormingSectionCol4Desc());
		paramSource.addValue("formingSectionCol5Desc",data.getFormingSectionCol5Desc());
		paramSource.addValue("formingSectionCol6Desc",data.getFormingSectionCol6Desc());
		paramSource.addValue("formingSectionCol7Desc",data.getFormingSectionCol7Desc());
		paramSource.addValue("formingSectionCol8Desc",data.getFormingSectionCol8Desc());
		paramSource.addValue("formingSectionCol9Desc",data.getFormingSectionCol9Desc());
		paramSource.addValue("formingSectionCol10Desc",data.getFormingSectionCol10Desc());
		paramSource.addValue("formingSectionCol11Desc",data.getFormingSectionCol11Desc());
		paramSource.addValue("formingSectionCol12Desc",data.getFormingSectionCol12Desc());
		paramSource.addValue("formingSectionCol13Desc",data.getFormingSectionCol13Desc());
		paramSource.addValue("formingSectionCol14Desc",data.getFormingSectionCol14Desc());
		
		
		
		paramSource.addValue("suctionPressureRollCol1",data.getSuctionPressureRollCol1());
		paramSource.addValue("suctionPressureRollCol2",data.getSuctionPressureRollCol2());
		paramSource.addValue("suctionPressureRollCol3",data.getSuctionPressureRollCol3());
		paramSource.addValue("suctionPressureRollCol4",data.getSuctionPressureRollCol4());
		paramSource.addValue("suctionPressureRollCol5",data.getSuctionPressureRollCol5());
		paramSource.addValue("suctionPressureRollCol6",data.getSuctionPressureRollCol6());
		paramSource.addValue("suctionPressureRollCol7",data.isSuctionPressureRollCol7());
		
		
		paramSource.addValue("suctionPressureRollCol1Desc",data.getSuctionPressureRollCol1Desc());
		paramSource.addValue("suctionPressureRollCol2Desc",data.getSuctionPressureRollCol2Desc());
		paramSource.addValue("suctionPressureRollCol3Desc",data.getSuctionPressureRollCol3Desc());
		paramSource.addValue("suctionPressureRollCol4Desc",data.getSuctionPressureRollCol4Desc());
		paramSource.addValue("suctionPressureRollCol5Desc",data.getSuctionPressureRollCol5Desc());
		paramSource.addValue("suctionPressureRollCol6Desc",data.getSuctionPressureRollCol6Desc());
		paramSource.addValue("suctionPressureRollCol7Desc",data.getSuctionPressureRollCol7Desc());
		
		
		paramSource.addValue("yankeeDryerCol1",data.getYankeeDryerCol1());
		paramSource.addValue("yankeeDryerCol2",data.getYankeeDryerCol2());
		paramSource.addValue("yankeeDryerCol3",data.isYankeeDryerCol3());
		paramSource.addValue("yankeeDryerCol4",data.getYankeeDryerCol4());
		paramSource.addValue("yankeeDryerCol5",data.isYankeeDryerCol5());
		
		
		paramSource.addValue("yankeeDryerCol1Desc",data.getYankeeDryerCol1Desc());
		paramSource.addValue("yankeeDryerCol2Desc",data.getYankeeDryerCol2Desc());
		paramSource.addValue("yankeeDryerCol3Desc",data.getYankeeDryerCol3Desc());
		paramSource.addValue("yankeeDryerCol4Desc",data.getYankeeDryerCol4Desc());
		paramSource.addValue("yankeeDryerCol5Desc",data.getYankeeDryerCol5Desc());
		
		paramSource.addValue("driveRollCol1",data.getDriveRollCol1());
		paramSource.addValue("driveRollCol2",data.getDriveRollCol2());
		paramSource.addValue("driveRollCol3",data.getDriveRollCol3());
		paramSource.addValue("driveRollCol4",data.getDriveRollCol4());
		paramSource.addValue("driveRollCol5",data.getDriveRollCol5());
		paramSource.addValue("driveRollCol6",data.getDriveRollCol6());
		paramSource.addValue("driveRollCol7",data.getDriveRollCol7());
		paramSource.addValue("driveRollCol8",data.getDriveRollCol8());
		
		paramSource.addValue("driveRollCol1Desc",data.getDriveRollCol1Desc());
		paramSource.addValue("driveRollCol2Desc",data.getDriveRollCol2Desc());
		paramSource.addValue("driveRollCol3Desc",data.getDriveRollCol3Desc());
		paramSource.addValue("driveRollCol4Desc",data.getDriveRollCol4Desc());
		paramSource.addValue("driveRollCol5Desc",data.getDriveRollCol5Desc());
		paramSource.addValue("driveRollCol6Desc",data.getDriveRollCol6Desc());
		paramSource.addValue("driveRollCol7Desc",data.getDriveRollCol7Desc());
		paramSource.addValue("driveRollCol8Desc",data.getDriveRollCol8Desc());
		
		paramSource.addValue("pressSectionCol1",data.getPressSectionCol1());
		paramSource.addValue("pressSectionCol2",data.getPressSectionCol2());
		paramSource.addValue("pressSectionCol3",data.getPressSectionCol3());
		paramSource.addValue("pressSectionCol4",data.getPressSectionCol4());
		paramSource.addValue("pressSectionCol5",data.getPressSectionCol5());
		paramSource.addValue("pressSectionCol6",data.isPressSectionCol6());
		paramSource.addValue("pressSectionCol7",data.getPressSectionCol7());
		paramSource.addValue("pressSectionCol8",data.isPressSectionCol8());
		
		
		
		paramSource.addValue("pressSectionCol1Desc",data.getPressSectionCol1Desc());
		paramSource.addValue("pressSectionCol2Desc",data.getPressSectionCol2Desc());
		paramSource.addValue("pressSectionCol3Desc",data.getPressSectionCol3Desc());
		paramSource.addValue("pressSectionCol4Desc",data.getPressSectionCol4Desc());
		paramSource.addValue("pressSectionCol5Desc",data.getPressSectionCol5Desc());
		paramSource.addValue("pressSectionCol6Desc",data.getPressSectionCol6Desc());
		paramSource.addValue("pressSectionCol7Desc",data.getPressSectionCol7Desc());
		paramSource.addValue("pressSectionCol8Desc",data.getPressSectionCol8Desc());
	 
		
		
		paramSource.addValue("upperPressCol1",data.getUpperPressCol1());
		paramSource.addValue("upperPressCol2",data.getUpperPressCol2());
		paramSource.addValue("upperPressCol3",data.isUpperPressCol3());
		paramSource.addValue("upperPressCol4",data.isUpperPressCol4());
		paramSource.addValue("upperPressCol5",data.isUpperPressCol5());
		paramSource.addValue("upperPressCol6",data.isUpperPressCol6());
		paramSource.addValue("upperPressCol7",data.isUpperPressCol7());
		paramSource.addValue("upperPressCol8",data.isUpperPressCol8());
		paramSource.addValue("upperPressCol9",data.getUpperPressCol9());
		
		
		paramSource.addValue("upperPressCol1Desc",data.getUpperPressCol1Desc());
		paramSource.addValue("upperPressCol2Desc",data.getUpperPressCol2Desc());
		paramSource.addValue("upperPressCol3Desc",data.getUpperPressCol3Desc());
		paramSource.addValue("upperPressCol4Desc",data.getUpperPressCol4Desc());
		paramSource.addValue("upperPressCol5Desc",data.getUpperPressCol5Desc());
		paramSource.addValue("upperPressCol6Desc",data.getUpperPressCol6Desc());
		paramSource.addValue("upperPressCol7Desc",data.getUpperPressCol7Desc());
		paramSource.addValue("upperPressCol8Desc",data.getUpperPressCol8Desc());
		paramSource.addValue("upperPressCol9Desc",data.getUpperPressCol9Desc());
		
		paramSource.addValue("chemicalTotesCol1",data.getChemicalTotesCol1());
		paramSource.addValue("chemicalTotesCol2",data.getChemicalTotesCol2());
		paramSource.addValue("chemicalTotesCol3",data.getChemicalTotesCol3());
		paramSource.addValue("chemicalTotesCol4",data.getChemicalTotesCol4());
		paramSource.addValue("chemicalTotesCol5",data.getChemicalTotesCol5());
		
		
		paramSource.addValue("chemicalTotesCol1Desc",data.getChemicalTotesCol1Desc());
		paramSource.addValue("chemicalTotesCol2Desc",data.getChemicalTotesCol2Desc());
		paramSource.addValue("chemicalTotesCol3Desc",data.getChemicalTotesCol3Desc());
		paramSource.addValue("chemicalTotesCol4Desc",data.getChemicalTotesCol4Desc());
		paramSource.addValue("chemicalTotesCol5Desc",data.getChemicalTotesCol5Desc());
		
		
		paramSource.addValue("fanPumpCol1",data.getFanPumpCol1());
		paramSource.addValue("fanPumpCol2",data.isFanPumpCol2());
		
		paramSource.addValue("fanPumpCol3Inbound",data.getFanPumpCol3Inbound());
		paramSource.addValue("fanPumpCol3Outbound",data.getFanPumpCol3Outbound());
		
		paramSource.addValue("fanPumpCol4Inbound",data.getFanPumpCol4Inbound());
		paramSource.addValue("fanPumpCol4Outbound",data.getFanPumpCol4Outbound());
		
		
		paramSource.addValue("fanPumpCol1Desc",data.getFanPumpCol1Desc());
		paramSource.addValue("fanPumpCol2Desc",data.getFanPumpCol2Desc());
		paramSource.addValue("fanPumpCol3Desc",data.getFanPumpCol3Desc());
		paramSource.addValue("fanPumpCol4Desc",data.getFanPumpCol4Desc());
		
		paramSource.addValue("selectifierScreenCol1",data.getSelectifierScreenCol1());
		paramSource.addValue("selectifierScreenCol2",data.getSelectifierScreenCol2());
		paramSource.addValue("selectifierScreenCol3",data.getSelectifierScreenCol3());
		
		paramSource.addValue("selectifierScreenCol4Inbound",data.getSelectifierScreenCol4Inbound());
		paramSource.addValue("selectifierScreenCol4Outbound",data.getSelectifierScreenCol4Outbound());
		
		paramSource.addValue("selectifierScreenCol5",data.getSelectifierScreenCol5());
		
		paramSource.addValue("selectifierScreenCol6Inbound",data.getSelectifierScreenCol6Inbound());
		paramSource.addValue("selectifierScreenCol6Outbound",data.getSelectifierScreenCol6Outbound());
		
		paramSource.addValue("selectifierScreenCol7",data.getSelectifierScreenCol7());
		paramSource.addValue("selectifierScreenCol8",data.isSelectifierScreenCol8());
		
		paramSource.addValue("selectifierScreenCol9Inbound",data.getSelectifierScreenCol9Inbound());
		paramSource.addValue("selectifierScreenCol9Outbound",data.getSelectifierScreenCol9Outbound());
		
		paramSource.addValue("selectifierScreenCol10",data.isSelectifierScreenCol10());
		
		paramSource.addValue("selectifierScreenCol11Inbound",data.getSelectifierScreenCol11Inbound());
		paramSource.addValue("selectifierScreenCol11Outbound",data.getSelectifierScreenCol11Outbound());
		
		
		paramSource.addValue("selectifierScreenCol1Desc",data.getSelectifierScreenCol1Desc());
		paramSource.addValue("selectifierScreenCol2Desc",data.getSelectifierScreenCol2Desc());
		paramSource.addValue("selectifierScreenCol3Desc",data.getSelectifierScreenCol3Desc());
		paramSource.addValue("selectifierScreenCol4Desc",data.getSelectifierScreenCol4Desc());
		paramSource.addValue("selectifierScreenCol5Desc",data.getSelectifierScreenCol5Desc());
		paramSource.addValue("selectifierScreenCol6Desc",data.getSelectifierScreenCol6Desc());
		paramSource.addValue("selectifierScreenCol7Desc",data.getSelectifierScreenCol7Desc());
		paramSource.addValue("selectifierScreenCol8Desc",data.getSelectifierScreenCol8Desc());
		paramSource.addValue("selectifierScreenCol9Desc",data.getSelectifierScreenCol9Desc());
		paramSource.addValue("selectifierScreenCol10Desc",data.getSelectifierScreenCol10Desc());
		paramSource.addValue("selectifierScreenCol11Desc",data.getSelectifierScreenCol11Desc());
		
		paramSource.addValue("vacumePumpCol1",data.isVacumePumpCol1());
		paramSource.addValue("vacumePumpCol2",data.isVacumePumpCol2());
		paramSource.addValue("vacumePumpCol3",data.isVacumePumpCol3());
		
		paramSource.addValue("vacumePumpCol4Inbound",data.getVacumePumpCol4Inbound());
		paramSource.addValue("vacumePumpCol4Outbound",data.getVacumePumpCol4Outbound());
		
		paramSource.addValue("vacumePumpCol5Inbound",data.getVacumePumpCol5Inbound());
		paramSource.addValue("vacumePumpCol5Outbound",data.getVacumePumpCol5Outbound());
		
		paramSource.addValue("vacumePumpCol6",data.isVacumePumpCol6());
		
		paramSource.addValue("vacumePumpCol7Inbound",data.getVacumePumpCol7Inbound());
		paramSource.addValue("vacumePumpCol7Outbound",data.getVacumePumpCol7Outbound());
		
		paramSource.addValue("vacumePumpCol8",data.isVacumePumpCol8());
		
		paramSource.addValue("vacumePumpCol9",data.getVacumePumpCol9());
		paramSource.addValue("vacumePumpCol10",data.getVacumePumpCol10());
		
		paramSource.addValue("vacumePumpCol11",data.isVacumePumpCol11());
		
		paramSource.addValue("vacumePumpCol12",data.getVacumePumpCol12());
		paramSource.addValue("vacumePumpCol13",data.getVacumePumpCol13());
		
		paramSource.addValue("vacumePumpCol14",data.isVacumePumpCol14());
		
		paramSource.addValue("vacumePumpCol15Inbound",data.getVacumePumpCol15Inbound());
		paramSource.addValue("vacumePumpCol15Outbound",data.getVacumePumpCol15Outbound());
		
		paramSource.addValue("vacumePumpCol16",data.isVacumePumpCol16());
		
		paramSource.addValue("vacumePumpCol17",data.getVacumePumpCol17());
		paramSource.addValue("vacumePumpCol18",data.getVacumePumpCol18());
		
		paramSource.addValue("vacumePumpCol19",data.isVacumePumpCol19());
		
		paramSource.addValue("vacumePumpCol20",data.getVacumePumpCol20());
		paramSource.addValue("vacumePumpCol21",data.getVacumePumpCol21());
		
		paramSource.addValue("vacumePumpCol22",data.isVacumePumpCol22());
		
		paramSource.addValue("vacumePumpCol23",data.getVacumePumpCol23());
		paramSource.addValue("vacumePumpCol24",data.getVacumePumpCol24());
		
		paramSource.addValue("vacumePumpCol25",data.isVacumePumpCol25());
		
		paramSource.addValue("vacumePumpCol26",data.getVacumePumpCol26());
		paramSource.addValue("vacumePumpCol27",data.getVacumePumpCol27());
		
		paramSource.addValue("vacumePumpCol28",data.isVacumePumpCol28());
		
		paramSource.addValue("vacumePumpCol29",data.getVacumePumpCol29());
		paramSource.addValue("vacumePumpCol30",data.getVacumePumpCol30());
		
		paramSource.addValue("vacumePumpCol31",data.isVacumePumpCol31());
		
		paramSource.addValue("vacumePumpCol32",data.getVacumePumpCol32());
		paramSource.addValue("vacumePumpCol33",data.getVacumePumpCol33());
		
		paramSource.addValue("vacumePumpCol34",data.isVacumePumpCol34());
		
		paramSource.addValue("vacumePumpCol35",data.getVacumePumpCol35());
		paramSource.addValue("vacumePumpCol36",data.getVacumePumpCol36());
		
		paramSource.addValue("vacumePumpCol1Desc",data.getVacumePumpCol1Desc());
		paramSource.addValue("vacumePumpCol2Desc",data.getVacumePumpCol2Desc());
		paramSource.addValue("vacumePumpCol3Desc",data.getVacumePumpCol3Desc());
		paramSource.addValue("vacumePumpCol4Desc",data.getVacumePumpCol4Desc());
		paramSource.addValue("vacumePumpCol5Desc",data.getVacumePumpCol5Desc());
		paramSource.addValue("vacumePumpCol6Desc",data.getVacumePumpCol6Desc());
		paramSource.addValue("vacumePumpCol7Desc",data.getVacumePumpCol7Desc());
		paramSource.addValue("vacumePumpCol8Desc",data.getVacumePumpCol8Desc()); 
		paramSource.addValue("vacumePumpCol9Desc",data.getVacumePumpCol9Desc());
		paramSource.addValue("vacumePumpCol10Desc",data.getVacumePumpCol10Desc()); 
		paramSource.addValue("vacumePumpCol11Desc",data.getVacumePumpCol11Desc());
		paramSource.addValue("vacumePumpCol12Desc",data.getVacumePumpCol12Desc());
		paramSource.addValue("vacumePumpCol13Desc",data.getVacumePumpCol13Desc());
		paramSource.addValue("vacumePumpCol14Desc",data.getVacumePumpCol14Desc());
		paramSource.addValue("vacumePumpCol15Desc",data.getVacumePumpCol15Desc());
		paramSource.addValue("vacumePumpCol16Desc",data.getVacumePumpCol16Desc());
		paramSource.addValue("vacumePumpCol17Desc",data.getVacumePumpCol17Desc());
		paramSource.addValue("vacumePumpCol18Desc",data.getVacumePumpCol18Desc());
		paramSource.addValue("vacumePumpCol19Desc",data.getVacumePumpCol19Desc());
		paramSource.addValue("vacumePumpCol20Desc",data.getVacumePumpCol20Desc());
		paramSource.addValue("vacumePumpCol21Desc",data.getVacumePumpCol21Desc());
		paramSource.addValue("vacumePumpCol22Desc",data.getVacumePumpCol22Desc());
		paramSource.addValue("vacumePumpCol23Desc",data.getVacumePumpCol23Desc());
		paramSource.addValue("vacumePumpCol24Desc",data.getVacumePumpCol24Desc());
		paramSource.addValue("vacumePumpCol25Desc",data.getVacumePumpCol25Desc());
		paramSource.addValue("vacumePumpCol26Desc",data.getVacumePumpCol26Desc());
		paramSource.addValue("vacumePumpCol27Desc",data.getVacumePumpCol27Desc());
		paramSource.addValue("vacumePumpCol28Desc",data.getVacumePumpCol28Desc());
		paramSource.addValue("vacumePumpCol29Desc",data.getVacumePumpCol29Desc());
		paramSource.addValue("vacumePumpCol30Desc",data.getVacumePumpCol30Desc());
		paramSource.addValue("vacumePumpCol31Desc",data.getVacumePumpCol31Desc());
		paramSource.addValue("vacumePumpCol32Desc",data.getVacumePumpCol32Desc());
		paramSource.addValue("vacumePumpCol33Desc",data.getVacumePumpCol33Desc());
		paramSource.addValue("vacumePumpCol34Desc",data.getVacumePumpCol34Desc());
		paramSource.addValue("vacumePumpCol35Desc",data.getVacumePumpCol35Desc());
		paramSource.addValue("vacumePumpCol36Desc",data.getVacumePumpCol36Desc());
		 
		paramSource.addValue("riverWaterCol1",data.getRiverWaterCol1());
		paramSource.addValue("riverWaterCol2",data.getRiverWaterCol2());
		paramSource.addValue("riverWaterCol1Out",data.getRiverWaterCol1Out());
		paramSource.addValue("riverWaterCol2Out",data.getRiverWaterCol2Out());
		
		paramSource.addValue("riverWaterCol1Desc",data.getRiverWaterCol1Desc());
		paramSource.addValue("riverWaterCol2Desc",data.getRiverWaterCol2Desc());
		
		paramSource.addValue("showercol1",data.isShowercol1());
		paramSource.addValue("showercol2North",data.getShowercol2North());
		paramSource.addValue("showercol2South",data.getShowercol2South());
		paramSource.addValue("showercol3",data.isShowercol3());
		paramSource.addValue("showercol4North",data.getShowercol4North());
		paramSource.addValue("showercol4South",data.getShowercol4South());
		paramSource.addValue("showercol5",data.isShowercol5());
		paramSource.addValue("showercol6North",data.getShowercol6North());
		paramSource.addValue("showercol6South",data.getShowercol6South());
		paramSource.addValue("showercol7",data.getShowercol7());
		paramSource.addValue("showercol7Out",data.getShowercol7Out());
		
		
		paramSource.addValue("showercol1Desc",data.getShowercol1Desc());
		paramSource.addValue("showercol2Desc",data.getShowercol2Desc());
		paramSource.addValue("showercol3Desc",data.getShowercol3Desc());
		paramSource.addValue("showercol4Desc",data.getShowercol4Desc());
		paramSource.addValue("showercol5Desc",data.getShowercol5Desc());
		paramSource.addValue("showercol6Desc",data.getShowercol6Desc());
		paramSource.addValue("showercol7Desc",data.getShowercol7Desc());
		 
		paramSource.addValue("fillupcentcol1",data.isFillupcentcol1());
		paramSource.addValue("fillupcentcol2",data.isFillupcentcol2());
		paramSource.addValue("fillupcentcol3",data.isFillupcentcol3());
		paramSource.addValue("fillupcentcol4",data.isFillupcentcol4());
		paramSource.addValue("fillupcentcol5",data.isFillupcentcol5());
		paramSource.addValue("fillupcentcol6",data.getFillupcentcol6());
		paramSource.addValue("fillupcentcol7",data.getFillupcentcol7());
		paramSource.addValue("fillupcentcol8",data.isFillupcentcol8());
		paramSource.addValue("fillupcentcol9",data.isFillupcentcol9());
		
		paramSource.addValue("fillupcentcol1Desc",data.getFillupcentcol1Desc());
		paramSource.addValue("fillupcentcol2Desc",data.getFillupcentcol2Desc());
		paramSource.addValue("fillupcentcol3Desc",data.getFillupcentcol3Desc());
		paramSource.addValue("fillupcentcol4Desc",data.getFillupcentcol4Desc());
		paramSource.addValue("fillupcentcol5Desc",data.getFillupcentcol5Desc());
		paramSource.addValue("fillupcentcol6Desc",data.getFillupcentcol6Desc());
		paramSource.addValue("fillupcentcol7Desc",data.getFillupcentcol7Desc());
		paramSource.addValue("fillupcentcol8Desc",data.getFillupcentcol8Desc());
		paramSource.addValue("fillupcentcol9Desc",data.getFillupcentcol9Desc());
		
		//Code Starts From Here Done By Roshan Tailor
		paramSource.addValue("checkairfilterforheadbox",data.isCheckairfilterforheadbox());
		paramSource.addValue("checkairfilterforheadboxremark",data.getCheckairfilterforheadboxremark());
		
		
		paramSource.addValue("blowwetendanddryendmotor",data.isBlowwetendanddryendmotor());
		paramSource.addValue("blowwetendanddryendmotorremark",data.getBlowwetendanddryendmotorremark());
		
		paramSource.addValue("checkheadboxaircompressorintelfiltercleanliness",data.isCheckheadboxaircompressorintelfiltercleanliness());
		paramSource.addValue("checkheadboxaircompressorintelfiltercleanlinessdesc",data.getCheckheadboxaircompressorintelfiltercleanlinessdesc());
		
		paramSource.addValue("headboxairfilterscleaning",data.isHeadboxairfilterscleaning());
		paramSource.addValue("headboxairfilterscleaningdesc",data.getHeadboxairfilterscleaningdesc());
		
		paramSource.addValue("rotatingShowers",data.isRotatingShowers());
		paramSource.addValue("rotatingShowersremark",data.getRotatingShowersremark());
		
		paramSource.addValue("rotationShowersValve",data.isRotationShowersValve());
		paramSource.addValue("rotationShowersValveremark",data.getRotationShowersValveremark());
		
		
		
		//Code Ends Here Done By Roshan Tailor
		 
	 
		if (data.getId() == 0) {	
			
			String sql=DatabaseUtil.getSQL("sql/insertMachineTender.sql");
			jdbcTemplate.update(sql, paramSource);
		}	
		else
		{
			paramSource.addValue("id",data.getId());
			String sql=DatabaseUtil.getSQL("sql/updateMachineTender.sql");
			jdbcTemplate.update(sql, paramSource);
		}
		
	 
		
	}
	
	/* (non-Javadoc)
	 * @see com.st.obcc.dao.MachineTenderDao#getOperatorDataList(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public List<MachineTender> getOperatorDataList(String position,String shift, String Sdate,String edate) throws Exception {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSourceQRT);
		String sql = "select * from [machineTender] where [position]=? AND [shift] =? AND [date] BETWEEN ? AND ?";

		List<MachineTender> machineTender = new ArrayList<MachineTender>();
		try {
			machineTender = jdbcTemplate.query(sql, new Object[] {position,shift,Sdate, edate},
					new RowMapper<MachineTender>() {

						@Override
						public MachineTender mapRow(ResultSet rs, int arg1)
								throws SQLException {
							MachineTender data = new MachineTender();
							
							try {
								String newDate = dateFormat.format(fromuser.parse(rs.getString("date")));
							
							data.setId(rs.getInt("id"));
							data.setPosition(rs.getString("position"));
							data.setOperatorName(rs.getString("operator_name"));
							data.setEdate(newDate);
							data.setShift(rs.getString("shift"));
							data.setCrew(rs.getString("crew"));

							data.setMachinedown(rs.getBoolean("machinedown"));
							data.setFormingSectionCol1(rs
									.getString("forming_Section_col1"));
							data.setFormingSectionCol2(rs
									.getString("forming_Section_col2"));
							data.setFormingSectionCol3(rs
									.getString("forming_Section_col3"));
							data.setFormingSectionCol4(rs
									.getString("forming_Section_col4"));
							data.setFormingSectionCol5(rs
									.getString("forming_Section_col5"));
							data.setFormingSectionCol6(rs
									.getString("forming_Section_col6"));
							data.setFormingSectionCol7(rs
									.getString("forming_Section_col7"));
							data.setFormingSectionCol8(rs
									.getString("forming_Section_col8"));
							data.setFormingSectionCol9(rs
									.getString("forming_Section_col9"));
							data.setFormingSectionCol10(rs
									.getString("forming_Section_col10"));
							data.setFormingSectionCol11(rs
									.getString("forming_Section_col11"));
							data.setFormingSectionCol12(rs
									.getString("forming_Section_col12"));
							data.setFormingSectionCol13(rs
									.getBoolean("forming_Section_col13"));
							data.setFormingSectionCol14(rs
									.getBoolean("forming_Section_col14"));

							data.setFormingSectionCol1Desc(rs
									.getString("forming_Section_col1_Desc"));
							data.setFormingSectionCol2Desc(rs
									.getString("forming_Section_col2_Desc"));
							data.setFormingSectionCol3Desc(rs
									.getString("forming_Section_col3_Desc"));
							data.setFormingSectionCol4Desc(rs
									.getString("forming_Section_col4_Desc"));
							data.setFormingSectionCol5Desc(rs
									.getString("forming_Section_col5_Desc"));
							data.setFormingSectionCol6Desc(rs
									.getString("forming_Section_col6_Desc"));
							data.setFormingSectionCol7Desc(rs
									.getString("forming_Section_col7_Desc"));
							data.setFormingSectionCol8Desc(rs
									.getString("forming_Section_col8_Desc"));
							data.setFormingSectionCol9Desc(rs
									.getString("forming_Section_col9_Desc"));
							data.setFormingSectionCol10Desc(rs
									.getString("forming_Section_col10_Desc"));
							data.setFormingSectionCol11Desc(rs
									.getString("forming_Section_col11_Desc"));
							data.setFormingSectionCol12Desc(rs
									.getString("forming_Section_col12_Desc"));
							data.setFormingSectionCol13Desc(rs
									.getString("forming_Section_col13_Desc"));
							data.setFormingSectionCol14Desc(rs
									.getString("forming_Section_col14_Desc"));

							data.setSuctionPressureRollCol1(rs
									.getString("suction_pressure_Roll_col1"));
							data.setSuctionPressureRollCol2(rs
									.getString("suction_pressure_Roll_col2"));
							data.setSuctionPressureRollCol3(rs
									.getString("suction_pressure_Roll_col3"));
							data.setSuctionPressureRollCol4(rs
									.getString("suction_pressure_Roll_col4"));
							data.setSuctionPressureRollCol5(rs
									.getString("suction_pressure_Roll_col5"));
							data.setSuctionPressureRollCol6(rs
									.getString("suction_pressure_Roll_col6"));
							data.setSuctionPressureRollCol7(rs
									.getBoolean("suction_pressure_Roll_col7"));

							data.setSuctionPressureRollCol1Desc(rs
									.getString("suction_pressure_Roll_col1_Desc"));
							data.setSuctionPressureRollCol2Desc(rs
									.getString("suction_pressure_Roll_col2_Desc"));
							data.setSuctionPressureRollCol3Desc(rs
									.getString("suction_pressure_Roll_col3_Desc"));
							data.setSuctionPressureRollCol4Desc(rs
									.getString("suction_pressure_Roll_col4_Desc"));
							data.setSuctionPressureRollCol5Desc(rs
									.getString("suction_pressure_Roll_col5_Desc"));
							data.setSuctionPressureRollCol6Desc(rs
									.getString("suction_pressure_Roll_col6_Desc"));
							data.setSuctionPressureRollCol7Desc(rs
									.getString("suction_pressure_Roll_col7_Desc"));

							data.setYankeeDryerCol1(rs
									.getString("yankee_Dryer_col1"));
							data.setYankeeDryerCol2(rs
									.getString("yankee_Dryer_col2"));
							data.setYankeeDryerCol3(rs
									.getBoolean("yankee_Dryer_col3"));
							data.setYankeeDryerCol4(rs
									.getString("yankee_Dryer_col4"));
							data.setYankeeDryerCol5(rs
									.getBoolean("yankee_Dryer_col5"));

							data.setYankeeDryerCol1Desc(rs
									.getString("yankee_Dryer_col1_Desc"));
							data.setYankeeDryerCol2Desc(rs
									.getString("yankee_Dryer_col2_Desc"));
							data.setYankeeDryerCol3Desc(rs
									.getString("yankee_Dryer_col3_Desc"));
							data.setYankeeDryerCol4Desc(rs
									.getString("yankee_Dryer_col4_Desc"));
							data.setYankeeDryerCol5Desc(rs
									.getString("yankee_Dryer_col5_Desc"));

							data.setDriveRollCol1(rs
									.getString("drive_Roll_col1"));
							data.setDriveRollCol2(rs
									.getString("drive_Roll_col2"));
							data.setDriveRollCol3(rs
									.getString("drive_Roll_col3"));
							data.setDriveRollCol4(rs
									.getString("drive_Roll_col4"));
							data.setDriveRollCol5(rs
									.getString("drive_Roll_col5"));
							data.setDriveRollCol6(rs
									.getString("drive_Roll_col6"));
							data.setDriveRollCol7(rs
									.getString("drive_Roll_col7"));

							data.setDriveRollCol1Desc(rs
									.getString("drive_Roll_col1_Desc"));
							data.setDriveRollCol2Desc(rs
									.getString("drive_Roll_col2_Desc"));
							data.setDriveRollCol3Desc(rs
									.getString("drive_Roll_col3_Desc"));
							data.setDriveRollCol4Desc(rs
									.getString("drive_Roll_col4_Desc"));
							data.setDriveRollCol5Desc(rs
									.getString("drive_Roll_col5_Desc"));
							data.setDriveRollCol6Desc(rs
									.getString("drive_Roll_col6_Desc"));
							data.setDriveRollCol7Desc(rs
									.getString("drive_Roll_col7_Desc"));

							data.setPressSectionCol1(rs
									.getString("press_Section_col1"));
							data.setPressSectionCol2(rs
									.getString("press_Section_col2"));
							data.setPressSectionCol3(rs
									.getString("press_Section_col3"));
							data.setPressSectionCol4(rs
									.getString("press_Section_col4"));
							data.setPressSectionCol5(rs
									.getString("press_Section_col5"));
							data.setPressSectionCol6(rs
									.getBoolean("press_Section_col6"));
							data.setPressSectionCol7(rs
									.getString("press_Section_col7"));
							data.setPressSectionCol8(rs
									.getBoolean("press_Section_col8"));

							data.setPressSectionCol1Desc(rs
									.getString("press_Section_col1_Desc"));
							data.setPressSectionCol2Desc(rs
									.getString("press_Section_col2_Desc"));
							data.setPressSectionCol3Desc(rs
									.getString("press_Section_col3_Desc"));
							data.setPressSectionCol4Desc(rs
									.getString("press_Section_col4_Desc"));
							data.setPressSectionCol5Desc(rs
									.getString("press_Section_col5_Desc"));
							data.setPressSectionCol6Desc(rs
									.getString("press_Section_col6_Desc"));
							data.setPressSectionCol7Desc(rs
									.getString("press_Section_col7_Desc"));
							data.setPressSectionCol8Desc(rs
									.getString("press_Section_col8_Desc"));

							data.setUpperPressCol1(rs
									.getString("upper_press_col1"));
							data.setUpperPressCol2(rs
									.getString("upper_press_col2"));
							data.setUpperPressCol3(rs
									.getBoolean("upper_press_col3"));
							data.setUpperPressCol4(rs
									.getBoolean("upper_press_col4"));
							data.setUpperPressCol5(rs
									.getBoolean("upper_press_col5"));
							data.setUpperPressCol6(rs
									.getBoolean("upper_press_col6"));
							data.setUpperPressCol7(rs
									.getBoolean("upper_press_col7"));
							data.setUpperPressCol8(rs
									.getBoolean("upper_press_col8"));
							data.setUpperPressCol9(rs
									.getString("upper_press_col9"));

							data.setUpperPressCol1Desc(rs
									.getString("upper_press_col1_Desc"));
							data.setUpperPressCol2Desc(rs
									.getString("upper_press_col2_Desc"));
							data.setUpperPressCol3Desc(rs
									.getString("upper_press_col3_Desc"));
							data.setUpperPressCol4Desc(rs
									.getString("upper_press_col4_Desc"));
							data.setUpperPressCol5Desc(rs
									.getString("upper_press_col5_Desc"));
							data.setUpperPressCol6Desc(rs
									.getString("upper_press_col6_Desc"));
							data.setUpperPressCol7Desc(rs
									.getString("upper_press_col7_Desc"));
							data.setUpperPressCol8Desc(rs
									.getString("upper_press_col8_Desc"));
							data.setUpperPressCol9Desc(rs
									.getString("upper_press_col9_Desc"));

							data.setChemicalTotesCol1(rs
									.getString("chemical_totes_col1"));
							data.setChemicalTotesCol2(rs
									.getString("chemical_totes_col2"));
							data.setChemicalTotesCol3(rs
									.getString("chemical_totes_col3"));
							data.setChemicalTotesCol4(rs
									.getString("chemical_totes_col4"));
							data.setChemicalTotesCol5(rs
									.getString("chemical_totes_col5"));

							data.setChemicalTotesCol1Desc(rs
									.getString("chemical_totes_col1_Desc"));
							data.setChemicalTotesCol2Desc(rs
									.getString("chemical_totes_col2_Desc"));
							data.setChemicalTotesCol3Desc(rs
									.getString("chemical_totes_col3_Desc"));
							data.setChemicalTotesCol4Desc(rs
									.getString("chemical_totes_col4_Desc"));
							data.setChemicalTotesCol5Desc(rs
									.getString("chemical_totes_col5_Desc"));

							data.setFanPumpCol1(rs.getString("fan_pump_col1"));
							data.setFanPumpCol2(rs.getBoolean("fan_pump_col2"));
							
							data.setFanPumpCol3Inbound(rs.getString("fan_pump_col3_west"));
							data.setFanPumpCol3Outbound(rs.getString("fan_pump_col3_east"));
							 
							data.setFanPumpCol4Inbound(rs.getString("fan_pump_col4_inbound"));
							data.setFanPumpCol4Outbound(rs.getString("fan_pump_col4_outbound"));
							 
							 
							data.setFanPumpCol1Desc(rs
									.getString("fan_pump_col1_Desc"));
							data.setFanPumpCol2Desc(rs
									.getString("fan_pump_col2_Desc"));
							data.setFanPumpCol3Desc(rs
									.getString("fan_pump_col3_Desc"));
							data.setFanPumpCol4Desc(rs
									.getString("fan_pump_col4_Desc"));

							data.setSelectifierScreenCol1(rs
									.getString("selectifier_Screen_col1"));
							data.setSelectifierScreenCol2(rs
									.getString("selectifier_Screen_col2"));
							data.setSelectifierScreenCol3(rs
									.getString("selectifier_Screen_col3"));
							
							data.setSelectifierScreenCol4Inbound(rs.getString("selectifier_Screen_col4_inbound"));
							data.setSelectifierScreenCol4Outbound(rs.getString("selectifier_Screen_col4_outbound"));
							
							
							data.setSelectifierScreenCol5(rs.getString("selectifier_Screen_col5"));
							
							data.setSelectifierScreenCol6Inbound(rs.getString("selectifier_Screen_col6_inbound"));
							data.setSelectifierScreenCol6Outbound(rs.getString("selectifier_Screen_col6_outbound"));
							
							data.setSelectifierScreenCol7(rs
									.getString("selectifier_Screen_col7"));
							data.setSelectifierScreenCol8(rs
									.getBoolean("selectifier_Screen_col8"));
							
							
							data.setSelectifierScreenCol9Inbound(rs.getString("selectifier_Screen_col9_inbound"));
							data.setSelectifierScreenCol9Outbound(rs.getString("selectifier_Screen_col9_outbound"));
							
							data.setSelectifierScreenCol10(rs.getBoolean("selectifier_Screen_col10"));
							data.setSelectifierScreenCol11Inbound(rs.getString("selectifier_Screen_col11_inbound"));
							data.setSelectifierScreenCol11Outbound(rs.getString("selectifier_Screen_col11_outbound"));
							 

							data.setSelectifierScreenCol1Desc(rs.getString("selectifier_Screen_col1_Desc"));
							data.setSelectifierScreenCol2Desc(rs.getString("selectifier_Screen_col2_Desc"));
							data.setSelectifierScreenCol3Desc(rs.getString("selectifier_Screen_col3_Desc"));
							data.setSelectifierScreenCol4Desc(rs.getString("selectifier_Screen_col4_Desc"));
							data.setSelectifierScreenCol5Desc(rs.getString("selectifier_Screen_col5_Desc"));
							data.setSelectifierScreenCol6Desc(rs.getString("selectifier_Screen_col6_Desc"));
							data.setSelectifierScreenCol7Desc(rs.getString("selectifier_Screen_col7_Desc"));
							data.setSelectifierScreenCol8Desc(rs.getString("selectifier_Screen_col8_Desc"));
							data.setSelectifierScreenCol9Desc(rs.getString("selectifier_Screen_col9_Desc"));
							data.setSelectifierScreenCol10Desc(rs.getString("selectifier_Screen_col10_Desc"));
							data.setSelectifierScreenCol11Desc(rs.getString("selectifier_Screen_col11_Desc"));
							 

							data.setVacumePumpCol1(rs.getBoolean("vacume_pump_col1"));
							data.setVacumePumpCol2(rs.getBoolean("vacume_pump_col2"));
							data.setVacumePumpCol3(rs.getBoolean("vacume_pump_col3"));
							
							data.setVacumePumpCol4Inbound(rs.getString("vacume_pump_col4_inbound"));
							data.setVacumePumpCol4Outbound(rs.getString("vacume_pump_col4_outbound"));
							
							data.setVacumePumpCol5Inbound(rs.getString("vacume_pump_col5_inbound"));
							data.setVacumePumpCol5Inbound(rs.getString("vacume_pump_col5_outbound"));
							
							
							data.setVacumePumpCol6(rs.getBoolean("vacume_pump_col6"));
							
							data.setVacumePumpCol7Inbound(rs.getString("vacume_pump_col7_inbound"));
							data.setVacumePumpCol7Outbound(rs.getString("vacume_pump_col7_outbound"));
							
							
							data.setVacumePumpCol8(rs.getBoolean("vacume_pump_col8"));
							
							data.setVacumePumpCol9(rs.getString("vacume_pump_col9"));
							
							data.setVacumePumpCol10(rs.getString("vacume_pump_col10"));
							
							data.setVacumePumpCol11(rs.getBoolean("vacume_pump_col11"));
							data.setVacumePumpCol12(rs.getString("vacume_pump_col12"));
							data.setVacumePumpCol13(rs.getString("vacume_pump_col13"));
							data.setVacumePumpCol14(rs.getBoolean("vacume_pump_col14"));
							
							data.setVacumePumpCol15Inbound(rs.getString("vacume_pump_col15_inbound"));
							data.setVacumePumpCol15Outbound(rs.getString("vacume_pump_col15_outbound"));
							
							data.setVacumePumpCol16(rs.getBoolean("vacume_pump_col16"));
							data.setVacumePumpCol17(rs.getString("vacume_pump_col17"));
							data.setVacumePumpCol18(rs.getString("vacume_pump_col18"));
							data.setVacumePumpCol19(rs.getBoolean("vacume_pump_col19"));
							data.setVacumePumpCol20(rs.getString("vacume_pump_col20"));
							data.setVacumePumpCol21(rs.getString("vacume_pump_col21"));
							data.setVacumePumpCol22(rs.getBoolean("vacume_pump_col22"));
							data.setVacumePumpCol23(rs.getString("vacume_pump_col23"));
							data.setVacumePumpCol24(rs.getString("vacume_pump_col24"));
							data.setVacumePumpCol25(rs.getBoolean("vacume_pump_col25"));
							data.setVacumePumpCol26(rs.getString("vacume_pump_col26"));
							data.setVacumePumpCol27(rs.getString("vacume_pump_col27"));
							data.setVacumePumpCol28(rs.getBoolean("vacume_pump_col28"));
							data.setVacumePumpCol29(rs.getString("vacume_pump_col29"));
							data.setVacumePumpCol30(rs.getString("vacume_pump_col30"));
							data.setVacumePumpCol31(rs.getBoolean("vacume_pump_col31"));
							data.setVacumePumpCol32(rs.getString("vacume_pump_col32"));
							data.setVacumePumpCol33(rs.getString("vacume_pump_col33"));
							data.setVacumePumpCol34(rs.getBoolean("vacume_pump_col34"));
							data.setVacumePumpCol35(rs.getString("vacume_pump_col35"));
							data.setVacumePumpCol36(rs.getString("vacume_pump_col36"));

							data.setVacumePumpCol1Desc(rs.getString("vacume_pump_col1_Desc"));
							data.setVacumePumpCol2Desc(rs.getString("vacume_pump_col2_Desc"));
							data.setVacumePumpCol3Desc(rs.getString("vacume_pump_col3_Desc"));
							data.setVacumePumpCol4Desc(rs.getString("vacume_pump_col4_Desc"));
							data.setVacumePumpCol5Desc(rs.getString("vacume_pump_col5_Desc"));
							data.setVacumePumpCol6Desc(rs.getString("vacume_pump_col6_Desc"));
							data.setVacumePumpCol7Desc(rs.getString("vacume_pump_col7_Desc"));
							data.setVacumePumpCol8Desc(rs.getString("vacume_pump_col8_Desc"));
							data.setVacumePumpCol9Desc(rs.getString("vacume_pump_col9_Desc"));
							data.setVacumePumpCol10Desc(rs.getString("vacume_pump_col10_Desc"));
							data.setVacumePumpCol11Desc(rs.getString("vacume_pump_col11_Desc"));
							data.setVacumePumpCol12Desc(rs.getString("vacume_pump_col12_Desc"));
							data.setVacumePumpCol13Desc(rs.getString("vacume_pump_col13_Desc"));
							data.setVacumePumpCol14Desc(rs.getString("vacume_pump_col14_Desc"));
							data.setVacumePumpCol15Desc(rs.getString("vacume_pump_col15_Desc"));
							data.setVacumePumpCol16Desc(rs.getString("vacume_pump_col16_Desc"));
							data.setVacumePumpCol17Desc(rs
									.getString("vacume_pump_col17_Desc"));
							data.setVacumePumpCol18Desc(rs
									.getString("vacume_pump_col18_Desc"));

							data.setVacumePumpCol19Desc(rs
									.getString("vacume_pump_col19_Desc"));
							data.setVacumePumpCol20Desc(rs
									.getString("vacume_pump_col20_Desc"));
							data.setVacumePumpCol21Desc(rs
									.getString("vacume_pump_col21_Desc"));
							data.setVacumePumpCol22Desc(rs
									.getString("vacume_pump_col22_Desc"));

							data.setVacumePumpCol23Desc(rs
									.getString("vacume_pump_col23_Desc"));
							data.setVacumePumpCol24Desc(rs
									.getString("vacume_pump_col24_Desc"));

							data.setVacumePumpCol25Desc(rs
									.getString("vacume_pump_col25_Desc"));
							data.setVacumePumpCol26Desc(rs
									.getString("vacume_pump_col26_Desc"));
							data.setVacumePumpCol27Desc(rs
									.getString("vacume_pump_col27_Desc"));

							data.setVacumePumpCol28Desc(rs
									.getString("vacume_pump_col28_Desc"));
							data.setVacumePumpCol29Desc(rs
									.getString("vacume_pump_col29_Desc"));
							data.setVacumePumpCol30Desc(rs
									.getString("vacume_pump_col30_Desc"));

							data.setVacumePumpCol31Desc(rs
									.getString("vacume_pump_col31_Desc"));

							data.setVacumePumpCol32Desc(rs
									.getString("vacume_pump_col32_Desc"));
							data.setVacumePumpCol33Desc(rs
									.getString("vacume_pump_col33_Desc"));
							data.setVacumePumpCol34Desc(rs
									.getString("vacume_pump_col34_Desc"));
							data.setVacumePumpCol35Desc(rs
									.getString("vacume_pump_col35_Desc"));

							data.setVacumePumpCol36Desc(rs
									.getString("vacume_pump_col36_Desc"));

							data.setRiverWaterCol1(rs
									.getString("river_water_col1"));
							data.setRiverWaterCol2(rs
									.getString("river_water_col2"));
							data.setRiverWaterCol1Out(rs
									.getString("river_water_col1Out"));
							data.setRiverWaterCol2Out(rs
									.getString("river_water_col2Out"));

							data.setRiverWaterCol1Desc(rs
									.getString("river_water_col1_Desc"));
							data.setRiverWaterCol2Desc(rs
									.getString("river_water_col2_Desc"));
							
							data.setShowercol1(rs.getBoolean("showercol1"));
							data.setShowercol2North(rs.getString("showercol2North"));
							data.setShowercol2South(rs.getString("showercol2South"));
							data.setShowercol3(rs.getBoolean("showercol3"));
							data.setShowercol4North(rs.getString("showercol4North"));
							data.setShowercol4South(rs.getString("showercol4South"));
							data.setShowercol5(rs.getBoolean("showercol5"));
							data.setShowercol6North(rs.getString("showercol6North"));
							data.setShowercol6South(rs.getString("showercol6South"));
							data.setShowercol7(rs.getString("showercol7"));
							data.setShowercol7Out(rs.getString("showercol7Out"));
							
							
							data.setShowercol1Desc(rs.getString("showercol1Desc"));
							data.setShowercol2Desc(rs.getString("showercol2Desc"));
							data.setShowercol3Desc(rs.getString("showercol3Desc"));
							data.setShowercol4Desc(rs.getString("showercol4Desc"));
							data.setShowercol5Desc(rs.getString("showercol5Desc"));
							data.setShowercol6Desc(rs.getString("showercol6Desc"));
							data.setShowercol7Desc(rs.getString("showercol7Desc"));
							
							
							data.setFillupcentcol1(rs.getBoolean("fillupcentcol1"));
							data.setFillupcentcol2(rs.getBoolean("fillupcentcol2"));
							data.setFillupcentcol3(rs.getBoolean("fillupcentcol3"));
							data.setFillupcentcol4(rs.getBoolean("fillupcentcol4"));
							data.setFillupcentcol5(rs.getBoolean("fillupcentcol5"));
							data.setFillupcentcol6(rs.getString("fillupcentcol6"));
							data.setFillupcentcol7(rs.getString("fillupcentcol7"));
							data.setFillupcentcol8(rs.getBoolean("fillupcentcol8"));
							data.setFillupcentcol9(rs.getBoolean("fillupcentcol9"));
							 
							
							data.setFillupcentcol1Desc(rs.getString("fillupcentcol1Desc"));
							data.setFillupcentcol2Desc(rs.getString("fillupcentcol2Desc"));
							data.setFillupcentcol3Desc(rs.getString("fillupcentcol3Desc"));
							data.setFillupcentcol4Desc(rs.getString("fillupcentcol4Desc"));
							data.setFillupcentcol5Desc(rs.getString("fillupcentcol5Desc"));
							data.setFillupcentcol6Desc(rs.getString("fillupcentcol6Desc"));
							data.setFillupcentcol7Desc(rs.getString("fillupcentcol7Desc"));
							data.setFillupcentcol8Desc(rs.getString("fillupcentcol8Desc"));
							data.setFillupcentcol9Desc(rs.getString("fillupcentcol9Desc"));
							 
							//Code Starts From Here Done By Roshan
							data.setCheckairfilterforheadbox(rs.getBoolean("checkairfilterforheadbox"));
							data.setCheckairfilterforheadboxremark(rs.getString("checkairfilterforheadboxremark"));
							
							
							data.setBlowwetendanddryendmotor(rs.getBoolean("blowwetendanddryendmotor"));
							data.setBlowwetendanddryendmotorremark(rs.getString("blowwetendanddryendmotorremark"));
							
							
							data.setDriveRollCol8(rs.getString("driveRollCol8"));
							data.setDriveRollCol8Desc(rs.getString("driveRollCol8Desc"));
							
							
							
							data.setCheckheadboxaircompressorintelfiltercleanliness(rs.getBoolean("checkheadboxaircompressorintelfiltercleanliness"));
							data.setCheckheadboxaircompressorintelfiltercleanlinessdesc(rs.getString("checkheadboxaircompressorintelfiltercleanlinessdesc"));
							
							
							data.setHeadboxairfilterscleaning(rs.getBoolean("headboxairfilterscleaning"));
							data.setHeadboxairfilterscleaningdesc(rs.getString("headboxairfilterscleaningdesc"));
							
							data.setRotatingShowers(rs.getBoolean("rotatingShowers"));
							data.setRotatingShowersremark(rs.getString("rotatingShowersremark"));
							
							data.setRotationShowersValve(rs.getBoolean("rotationShowersValve"));
							data.setRotationShowersValveremark(rs.getString("rotationShowersValveremark"));
							
							//Code Ends Here Done By Roshan Tailor 
							
							} catch (ParseException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							
							return data;
							
						}

					});
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return machineTender;
	}

	
	
	@Override
	public long getDataCountDatePercentage(String position, String shift, String Sdate,
			String edate) throws Exception {
		
		SimpleDateFormat format=new SimpleDateFormat("MM-dd-yyyy");
	
		List<MachineTender> daydata=null, nightdata=null;
		if(shift.equals("both"))
		{
			 daydata=getOperatorDataList(position,"day",Sdate, edate);
			 nightdata=getOperatorDataList(position,"night",Sdate, edate);
		}else if(shift.equals("day"))
		{
			daydata=getOperatorDataList(position,"day",Sdate, edate);
		}
		else
		{
			 nightdata=getOperatorDataList(position,"night",Sdate, edate);
		}
			
		
		int count=0,no=0;long set=0,daypercent=0,nightpercent=0,percentage=0;
		int days = CommonUtil.getDaysDiffernce(format.parse(Sdate), format.parse(edate))+1;
		List<Integer> al=new ArrayList<Integer>();
		List<Integer> al2=new ArrayList<Integer>();
		if(daydata!=null||nightdata!=null)	
		{
			if(shift.equals("day")||shift.equals("both"))
			{
			for(MachineTender data:daydata){
				if(data.isMachinedown()!=true)
				{				
				 if(data.getFormingSectionCol1()!=null&&!data.getFormingSectionCol1().equals(""))
				 {count++;}
				 if(data.getFormingSectionCol2()!=null&&!data.getFormingSectionCol2().equals(""))
				 {count++;}
				 if(data.getFormingSectionCol3()!=null&&!data.getFormingSectionCol3().equals(""))
				 {count++;}
				 if(data.getFormingSectionCol4()!=null&&!data.getFormingSectionCol4().equals(""))
				 {count++;}
				 if(data.getFormingSectionCol5()!=null&&!data.getFormingSectionCol5().equals(""))
				 {count++;}
				 if(data.getFormingSectionCol6()!=null&&!data.getFormingSectionCol6().equals(""))
				 {count++;}
				 if(data.getFormingSectionCol7()!=null&&!data.getFormingSectionCol7().equals(""))
				 {count++;}
				 if(data.getFormingSectionCol8()!=null&&!data.getFormingSectionCol8().equals(""))
				 {count++;}
				 if(data.getFormingSectionCol9()!=null&&!data.getFormingSectionCol9().equals(""))
				 {count++;}
				 if(data.getFormingSectionCol10()!=null&&!data.getFormingSectionCol10().equals(""))
				 {count++;}
				 if(data.getFormingSectionCol11()!=null&&!data.getFormingSectionCol11().equals(""))
				 {count++;}
				 if(data.getFormingSectionCol12()!=null&&!data.getFormingSectionCol12().equals(""))
				 {count++;}
				if(data.isFormingSectionCol13() == true||data.isFormingSectionCol13() == false)
				 { count++;}
				if(data.isFormingSectionCol14() == true||data.isFormingSectionCol14() == false)
				{ count++;}
				//section
				
				 if(data.getSuctionPressureRollCol1()!=null&&!data.getSuctionPressureRollCol1().equals(""))
				{ count++;}	
				 if(data.getSuctionPressureRollCol2()!=null&&!data.getSuctionPressureRollCol2().equals(""))
				{ count++;}
				 if(data.getSuctionPressureRollCol3()!=null&&!data.getSuctionPressureRollCol3().equals(""))
				{ count++;}
				 if(data.getSuctionPressureRollCol4()!=null&&!data.getSuctionPressureRollCol4().equals(""))
				{ count++;}
				 if(data.getSuctionPressureRollCol5()!=null&&!data.getSuctionPressureRollCol5().equals(""))
				{ count++;}
				 if(data.getSuctionPressureRollCol6()!=null&&!data.getSuctionPressureRollCol6().equals(""))
				{ count++;}
				
				if(data.isSuctionPressureRollCol7() == true||data.isSuctionPressureRollCol7() == false)
				{ count++;}
				//yankee dryer
				
				
				 if(data.getYankeeDryerCol1()!=null&&!data.getYankeeDryerCol1().equals(""))
				 { count++;}
				
				 if(data.getYankeeDryerCol2()!=null&&!data.getYankeeDryerCol2().equals(""))
				 { count++;}
				if(data.isYankeeDryerCol3() == true)
				{ count++;}
				 if(data.getYankeeDryerCol4()!=null||!data.getYankeeDryerCol4().equals(""))
				 { count++;}
				
				 
				 if(data.isYankeeDryerCol5() == true||data.isYankeeDryerCol5() == false)
				{ count++;}
				//Drive Roll
				
				
				
				 if(data.getDriveRollCol1()!=null&&!data.getDriveRollCol1().equals(""))
				{count++;}
				 if(data.getDriveRollCol2()!=null&&!data.getDriveRollCol2().equals(""))
				{count++;}
				 if(data.getDriveRollCol3()!=null&&!data.getDriveRollCol3().equals(""))
				{count++;}
				 if(data.getDriveRollCol4()	!=null&&!data.getDriveRollCol4().equals(""))
				{count++;}
				 if(data.getDriveRollCol5()!=null&&!data.getDriveRollCol5().equals(""))
				{count++;}
				 if(data.getDriveRollCol6()!=null&&!data.getDriveRollCol6().equals(""))
				{count++;}
				 if(data.getDriveRollCol7()!=null&&!data.getDriveRollCol7().equals(""))
				{count++;}
				
				//press Section
				
				 if(data.getPressSectionCol1()!=null&&!data.getPressSectionCol1().equals(""))
				 {count++;}
				 if(data.getPressSectionCol2()!=null&&!data.getPressSectionCol2().equals(""))
				 {count++;}
				 if(data.getPressSectionCol3()!=null&&!data.getPressSectionCol3().equals(""))
				 {count++;}
				 if(data.getPressSectionCol4()!=null&&!data.getPressSectionCol4().equals(""))
				 {count++;}
				 if(data.getPressSectionCol5()!=null&&!data.getPressSectionCol5().equals(""))
				 {count++;}
				if(data.isPressSectionCol6() == true||data.isSuctionPressureRollCol7() == false)
				{ count++;}
				 if(data.getPressSectionCol7()!=null&&!data.getPressSectionCol7().equals(""))
				 {count++;}
				if(data.isPressSectionCol8() == true||data.isPressSectionCol8() == false)
				{ count++;}
				
				//upper presss
				
				 if(data.getUpperPressCol1()!=null&&!data.getUpperPressCol1().equals(""))
				 {count++;}
				 if(data.getUpperPressCol2()!=null&&!data.getUpperPressCol2().equals(""))
				 {count++;}
				if(data.isUpperPressCol3() == true||data.isUpperPressCol3() == false)
				{ count++;}
				if(data.isUpperPressCol4() == true||data.isUpperPressCol4() == false)
				{ count++;}
				if(data.isUpperPressCol5() == true||data.isUpperPressCol5() == false)
				{ count++;}
				if(data.isUpperPressCol6() == true||data.isUpperPressCol6() == false)
				{ count++;}
				if(data.isUpperPressCol7() == true||data.isUpperPressCol7() == false)
				{ count++;}
				if(data.isUpperPressCol8() == true||data.isUpperPressCol8() == false)
				{ count++;}
				if(data.getUpperPressCol9() != null)
				{ count++;}
				
				//chemical
				
				 if(data.getChemicalTotesCol1()!=null&&!data.getChemicalTotesCol1().equals(""))
				 {   count++;}
				 if(data.getChemicalTotesCol2()!=null&&!data.getChemicalTotesCol2().equals(""))
				 {   count++;}
				 if(data.getChemicalTotesCol3()!=null&&!data.getChemicalTotesCol3().equals(""))
				 {   count++;}
				 if(data.getChemicalTotesCol4()!=null&&!data.getChemicalTotesCol4().equals(""))
				 {   count++;}
				 if(data.getChemicalTotesCol5()	!=null&&!data.getChemicalTotesCol5().equals(""))
				 {   count++;}
				//last shift Desc
				if(data.isFillupcentcol1() == true||data.isFillupcentcol1() == false)
				{ count++;}
				if(data.isFillupcentcol2() == true||data.isFillupcentcol2() == false)
				{ count++;}
				if(data.isFillupcentcol3() == true||data.isFillupcentcol3() == false)
				{ count++;}
				if(data.isFillupcentcol4() == true||data.isFillupcentcol4() == false)
				{ count++;}
				 if(data.isFillupcentcol5()== true||data.isFillupcentcol5()== false)
				 { count++;}
				 if(data.getFillupcentcol6()!=null&&!data.getFillupcentcol6().equals(""))
				 { count++;}
				 if(data.getFillupcentcol7()!=null&&!data.getFillupcentcol7().equals(""))
				 { count++;}
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
		if(shift.equals("night")||shift.equals("both")) {
			for(MachineTender data:nightdata){
				if(data.isMachinedown()!=true)
				{					
					if( data.getFanPumpCol1()!=null&&!data.getFanPumpCol1().equals(""))
					{ count++;}
					if(data.isFanPumpCol2() == true||data.isSuctionPressureRollCol7() == false){count++;}
					 if( data.getFanPumpCol3Inbound()!=null&&!data.getFanPumpCol3Inbound().equals(""))
					{ count++;}
					 if( data.getFanPumpCol3Outbound()!=null&&!data.getFanPumpCol3Outbound().equals(""))
					{ count++;}
					 if( data.getFanPumpCol4Inbound()!=null&&!data.getFanPumpCol4Inbound().equals(""))
					{ count++;}
					 if( data.getFanPumpCol4Outbound()!=null&&!data.getFanPumpCol4Outbound().equals(""))
					{ count++;}
					 if( data.getSelectifierScreenCol1()!=null&&!data.getSelectifierScreenCol1().equals(""))
					 { count++;}
					 if( data.getSelectifierScreenCol2()!=null&&!data.getSelectifierScreenCol2().equals(""))
					 { count++;}
					 if( data.getSelectifierScreenCol3()!=null&&!data.getSelectifierScreenCol3().equals(""))
					 { count++;}
					 if( data.getSelectifierScreenCol4Inbound()!=null&&!data.getSelectifierScreenCol4Inbound().equals(""))
					 { count++;}
					 if( data.getSelectifierScreenCol4Outbound()!=null&&!data.getSelectifierScreenCol4Outbound().equals(""))
					 { count++;}
					 if( data.getSelectifierScreenCol5()!=null&&!data.getSelectifierScreenCol5().equals(""))
					 { count++;}
					 if( data.getSelectifierScreenCol6Inbound()!=null&&!data.getSelectifierScreenCol6Inbound().equals(""))
					 { count++;}
					 if( data.getSelectifierScreenCol6Outbound()!=null&&!data.getSelectifierScreenCol6Outbound().equals(""))
					 { count++;}
					 if( data.getSelectifierScreenCol7()!=null&&!data.getSelectifierScreenCol7().equals(""))
					 { count++;}
					 if(data.isSelectifierScreenCol8() == true||data.isSelectifierScreenCol8() == false){count++;}
					 if( data.getSelectifierScreenCol9Inbound()!=null&&!data.getSelectifierScreenCol9Inbound().equals(""))
					 { count++;}
					 if( data.getSelectifierScreenCol9Outbound()!=null&&!data.getSelectifierScreenCol9Outbound().equals(""))
					 { count++;}
					 if(data.isSelectifierScreenCol10() == true||data.isSelectifierScreenCol10() == false){count++;}
					if( data.getSelectifierScreenCol11Inbound()!=null&&!data.getSelectifierScreenCol11Inbound().equals(""))
					 { count++;}
					 if( data.getSelectifierScreenCol11Outbound()!=null&&!data.getSelectifierScreenCol11Outbound().equals(""))
					 { count++;}
					 if(data.isVacumePumpCol1() == true||data.isVacumePumpCol1() == false){count++;}
					if(data.isVacumePumpCol2() == true||data.isVacumePumpCol2() == false){count++;}
					if(data.isVacumePumpCol3() == true||data.isVacumePumpCol3() == false){count++;}
					if( data.getVacumePumpCol4Inbound()!=null&&!data.getVacumePumpCol4Inbound().equals(""))
					{ count++;}
					 if( data.getVacumePumpCol4Outbound()!=null&&!data.getVacumePumpCol4Outbound().equals(""))
					{ count++;}
					 if( data.getVacumePumpCol5Inbound()!=null&&!data.getVacumePumpCol5Inbound().equals(""))
					{ count++;}
					 if( data.getVacumePumpCol5Outbound()!=null&&!data.getVacumePumpCol5Outbound().equals(""))
					{ count++;}
					if(data.isVacumePumpCol6() == true||data.isVacumePumpCol6() == false){count++;}
					if( data.getVacumePumpCol7Inbound()!=null&&!data.getVacumePumpCol7Inbound().equals(""))
					{ count++;}
					 if( data.getVacumePumpCol7Outbound()!=null&&!data.getVacumePumpCol7Outbound().equals(""))
					{ count++;}
					 if(data.isVacumePumpCol8() == true||data.isVacumePumpCol8() == false){count++;}
					if( data.getVacumePumpCol9()!=null&&!data.getVacumePumpCol9().equals(""))
					{ count++;}
					if( data.getVacumePumpCol10()!=null&&!data.getVacumePumpCol10().equals(""))
					{ count++;}
					if(data.isVacumePumpCol11() == true||data.isVacumePumpCol11() == false){count++;}
					if( data.getVacumePumpCol12()!=null&&!data.getVacumePumpCol12().equals(""))
					{ count++;}
					 if( data.getVacumePumpCol13()!=null&&!data.getVacumePumpCol13().equals(""))
					{ count++;}
					 if(data.isVacumePumpCol14() == true||data.isVacumePumpCol14() == false){count++;}
					if( data.getVacumePumpCol15Inbound()!=null&&!data.getVacumePumpCol15Inbound().equals(""))
					{ count++;}
					 if( data.getVacumePumpCol15Outbound()!=null&&!data.getVacumePumpCol15Outbound().equals(""))
					{ count++;}
					 if(data.isVacumePumpCol16() == true||data.isVacumePumpCol16() == false){count++;}		
					 if( data.getVacumePumpCol17()!=null&&!data.getVacumePumpCol17().equals(""))
					{ count++;}
					 if( data.getVacumePumpCol18()!=null&&!data.getVacumePumpCol18().equals(""))
					{ count++;}
					 if(data.isVacumePumpCol19() == true||data.isVacumePumpCol19() == false){count++;}
					if( data.getVacumePumpCol20()!=null&&!data.getVacumePumpCol20().equals(""))
					{ count++;}
					 if( data.getVacumePumpCol21()!=null&&!data.getVacumePumpCol21().equals(""))
					{ count++;}
					 if(data.isVacumePumpCol22() == true||data.isVacumePumpCol22() == false){count++;}
					if( data.getVacumePumpCol23()!=null&&!data.getVacumePumpCol23().equals(""))
					{ count++;}
					 if( data.getVacumePumpCol24()!=null&&!data.getVacumePumpCol24().equals(""))
					{ count++;}
					 if(data.isVacumePumpCol25() == true||data.isVacumePumpCol25() == false){count++;}
					if( data.getVacumePumpCol26()!=null&&!data.getVacumePumpCol26().equals(""))
					{ count++;}
					if( data.getVacumePumpCol27()!=null&&!data.getVacumePumpCol27().equals(""))
					{ count++;}
					 if(data.isVacumePumpCol28() == true||data.isVacumePumpCol28() == false){count++;}
					if( data.getVacumePumpCol29()!=null&&!data.getVacumePumpCol29().equals(""))
					{ count++;}
					if( data.getVacumePumpCol30()!=null&&!data.getVacumePumpCol30().equals(""))
					{ count++;}
					if(data.isVacumePumpCol31() == true||data.isVacumePumpCol31() == false){count++;}
					if( data.getVacumePumpCol32()!=null&&!data.getVacumePumpCol32().equals(""))
					{ count++;}
					 if( data.getVacumePumpCol33()!=null&&!data.getVacumePumpCol33().equals(""))
					{ count++;}
					 if(data.isVacumePumpCol34() == true||data.isVacumePumpCol34() == false){count++;}
					if( data.getVacumePumpCol35()!=null&&!data.getVacumePumpCol35().equals(""))
					{ count++;}
					 if( data.getVacumePumpCol36()!=null&&!data.getVacumePumpCol36().equals(""))
					{ count++;}
					 if( data.getRiverWaterCol1()!=null&&!data.getRiverWaterCol1().equals(""))
					 {count++;}
					if( data.getRiverWaterCol2()!=null&&!data.getRiverWaterCol2().equals(""))
					 {count++;}
					 if(data.isShowercol1() == true||data.isShowercol1() == false){count++;}
					if( data.getShowercol2North()!=null&&!data.getShowercol2North().equals(""))
					{ count++;}
					 if( data.getShowercol2South()!=null&&!data.getShowercol2South().equals(""))
					 {count++;}
					 if(data.isShowercol3() == true||data.isShowercol3() == false){count++;}
					if( data.getShowercol4North()!=null&&!data.getShowercol4North().equals(""))
					{ count++;}
					 if( data.getShowercol4South()!=null&&!data.getShowercol4South().equals(""))
					 {count++;}
					 if(data.isShowercol5() == true||data.isShowercol5() == false){count++;}			
					 if( data.getShowercol6North()!=null&&!data.getShowercol6North().equals(""))
					{ count++;}
					 if( data.getShowercol6South()!=null&&!data.getShowercol6South().equals(""))
					 {count++;}
					if( data.getShowercol7()!=null&&!data.getShowercol7().equals(""))
					{count++;}
					 if(data.isFillupcentcol1() == true||data.isSuctionPressureRollCol7() == false){count++;}
					if(data.isFillupcentcol2() == true||data.isSuctionPressureRollCol7() == false){count++;}
					if(data.isFillupcentcol3() == true||data.isSuctionPressureRollCol7() == false){count++;}
					if(data.isFillupcentcol4() == true||data.isSuctionPressureRollCol7() == false){count++;}
					if(data.isFillupcentcol8() == true||data.isSuctionPressureRollCol7() == false){count++;}
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
	
	/* (non-Javadoc)
	 * @see com.st.obcc.dao.MachineTenderDao#getDataCountDatePercentage(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 
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
						+ "FROM machineTender "
						+ " WHERE (date between ? AND ? ) and shift=?"
						+ " )as TotalExport FROM machineTender e1 where shift=?";
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
						+ "FROM machineTender "
						+ " WHERE (date between ? AND ? )"
						+ " )as TotalExport FROM machineTender e1 ";
						param=new Object[]{
							Sdate,
							edate	
						};
			}
			
			 
			List<MachineTender> wrapperProductions=null;
			try {
				wrapperProductions=jdbcTemplate.query(sql,param, new RowMapper<MachineTender>(){

							@Override
							public MachineTender mapRow(ResultSet rs, int arg1)
									throws SQLException {
								
								
								int totalDataEntry = rs.getInt("TotalDataEntry");
								int totalExport = rs.getInt("TotalExport");
								
								//int percentage = totalExport*100/totalDataEntry;
								int percentage = 0;
								if(total == 0)
								{
									percentage = 100;	
								}
								else
								{
									percentage = totalExport*100/total;
								}
								
								MachineTender wrapperProduction=new MachineTender();
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
	 * @see com.st.obcc.dao.MachineTenderDao#getDataCountDatePercentage(java.lang.String, java.lang.String)
	 
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
					+ "FROM machineTender "
					+ " WHERE (date between ? AND ? )"
					+ " )as TotalExport FROM machineTender e1 ";
					param=new Object[]{
							Sdate,
						edate	
					};
			 
			List<MachineTender> wrapperProductions=null;
			try {
				wrapperProductions=jdbcTemplate.query(sql,param, new RowMapper<MachineTender>(){

							@Override
							public MachineTender mapRow(ResultSet rs, int arg1)
									throws SQLException {
								
								
								int totalDataEntry = rs.getInt("TotalDataEntry");
								int totalExport = rs.getInt("TotalExport");
								
								//int percentage = totalExport*100/totalDataEntry;
								double percentage = totalExport*100/total;
								
								
								MachineTender wrapperProduction=new MachineTender();
								wrapperProduction.setPercentage(percentage);
								return wrapperProduction;
							}
							
						});
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return wrapperProductions.get(0).getPercentage();
	}*/
}

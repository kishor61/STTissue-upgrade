/**
 *Jun 27, 2016
 *R1OperatorDaoImpl.java
 * TODO
 *com.st.obcc.dao
 *R1OperatorDaoImpl.java
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
import com.st.obcc.model.OperatorData;
import com.st.obcc.model.R1Operator;
import com.st.production.model.MachineProduction;

/**
 * @author snavhaal
 *
 */
@Repository
public class R1OperatorDaoImpl implements R1OperatorDao {

	@Autowired
	@Qualifier("dataSourceOBCC")
	private DataSource dataSourceQRT;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.st.obcc.dao.R1OperatorDao#saveorUpdate(com.st.obcc.model.R1Operator)
	 */
	private SimpleDateFormat dateFormat=new SimpleDateFormat("MM-dd-yyyy");
	private SimpleDateFormat fromuser=new SimpleDateFormat("yyyy-MM-dd");
	
	@Override
	public void saveorUpdate(R1Operator data) {
		// TODO Auto-generated method stub
		NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(dataSourceQRT);
	 	MapSqlParameterSource paramSource=new MapSqlParameterSource();
	 	
	 	paramSource.addValue("position",data.getPosition());
		paramSource.addValue("operatorName",data.getOperatorName());
		paramSource.addValue("edate",data.getEdate());
		paramSource.addValue("crew",data.getCrew());
		paramSource.addValue("shift",data.getShift());
		
		
		paramSource.addValue("machinedown", data.isMachinedown());
		paramSource.addValue("leadInRollCol1",data.getLeadInRollCol1());
		paramSource.addValue("leadInRollCol2",data.isLeadInRollCol2());
		paramSource.addValue("leadInRollCol3",data.isLeadInRollCol3());
		paramSource.addValue("leadInRollCol4",data.getLeadInRollCol4());
		paramSource.addValue("leadInRollCol5",data.isLeadInRollCol5());
		
		paramSource.addValue("leadInRollCol1Desc",data.getLeadInRollCol1Desc());
		paramSource.addValue("leadInRollCol2Desc",data.getLeadInRollCol2Desc());
		paramSource.addValue("leadInRollCol3Desc",data.getLeadInRollCol3Desc());
		paramSource.addValue("leadInRollCol4Desc",data.getLeadInRollCol4Desc());
		paramSource.addValue("leadInRollCol5Desc",data.getLeadInRollCol5Desc());
		
		
		
		paramSource.addValue("sectionRollCol1",data.isSectionRollCol1());
		paramSource.addValue("sectionRollCol1Desc",data.getSectionRollCol1Desc());
		
		
		paramSource.addValue("breakAssemblyCol1",data.isBreakAssemblyCol1());
		paramSource.addValue("breakAssemblyCol2",data.isBreakAssemblyCol2());
		paramSource.addValue("breakAssemblyCol1Desc",data.getBreakAssemblyCol1Desc());
		paramSource.addValue("breakAssemblyCol2Desc",data.getBreakAssemblyCol2Desc());
		
		
		paramSource.addValue("slittersCol1",data.isSlittersCol1());
		paramSource.addValue("slittersCol2",data.isSlittersCol2());
		paramSource.addValue("slittersCol3",data.isSlittersCol3());
		
		paramSource.addValue("slittersCol1Desc",data.getSlittersCol1Desc());
		paramSource.addValue("slittersCol2Desc",data.getSlittersCol2Desc());
		paramSource.addValue("slittersCol3Desc",data.getSlittersCol3Desc());
		
		
		paramSource.addValue("trimAssemblyCol1",data.isTrimAssemblyCol1());
		paramSource.addValue("trimAssemblyCol2",data.isTrimAssemblyCol2());
		paramSource.addValue("trimAssemblyCol3",data.isTrimAssemblyCol3());
		paramSource.addValue("trimAssemblyCol4",data.isTrimAssemblyCol4());
		
		
		paramSource.addValue("trimAssemblyCol1Desc",data.getTrimAssemblyCol1Desc());
		paramSource.addValue("trimAssemblyCol2Desc",data.getTrimAssemblyCol1Desc());
		paramSource.addValue("trimAssemblyCol3Desc",data.getTrimAssemblyCol1Desc());
		paramSource.addValue("trimAssemblyCol4Desc",data.getTrimAssemblyCol1Desc());
		
		
		paramSource.addValue("tensiionRollCol1",data.isTensiionRollCol1());
		paramSource.addValue("tensiionRollCol2",data.isTensiionRollCol2());
		paramSource.addValue("tensiionRollCol3",data.isTensiionRollCol3());
		
		paramSource.addValue("tensiionRollCol1Desc",data.getTensiionRollCol1Desc());
		paramSource.addValue("tensiionRollCol2Desc",data.getTensiionRollCol2Desc());
		paramSource.addValue("tensiionRollCol3Desc",data.getTensiionRollCol3Desc());
		
		paramSource.addValue("winderDrum1Col1",data.getWinderDrum1Col1());
		paramSource.addValue("winderDrum1Col2",data.isWinderDrum1Col2());
		paramSource.addValue("winderDrum1Col3",data.isWinderDrum1Col3());
		paramSource.addValue("winderDrum1Col4",data.getWinderDrum1Col4());
		paramSource.addValue("winderDrum1Col5",data.isWinderDrum1Col5());
		/*paramSource.addValue("winderDrum1Col6",data.isWinderDrum1Col6());
		paramSource.addValue("winderDrum1Col7",data.isWinderDrum1Col7());*/
		
		paramSource.addValue("winderDrum1Col1Desc",data.getWinderDrum1Col1Desc());
		paramSource.addValue("winderDrum1Col2Desc",data.getWinderDrum1Col2Desc());
		paramSource.addValue("winderDrum1Col3Desc",data.getWinderDrum1Col3Desc());
		paramSource.addValue("winderDrum1Col4Desc",data.getWinderDrum1Col4Desc());
		paramSource.addValue("winderDrum1Col5Desc",data.getWinderDrum1Col5Desc());
		/*paramSource.addValue("winderDrum1Col6Desc",data.getWinderDrum1Col6Desc());
		paramSource.addValue("winderDrum1Col7Desc",data.getWinderDrum1Col7Desc());*/
		 
		paramSource.addValue("winderDrum2Col1",data.getWinderDrum2Col1());
		paramSource.addValue("winderDrum2Col2",data.isWinderDrum2Col2());
		paramSource.addValue("winderDrum2Col3",data.isWinderDrum2Col3());
		paramSource.addValue("winderDrum2Col4",data.getWinderDrum2Col4());
		paramSource.addValue("winderDrum2Col5",data.isWinderDrum2Col5());
		/*paramSource.addValue("winderDrum2Col6",data.isWinderDrum2Col6());
		paramSource.addValue("winderDrum2Col7",data.isWinderDrum2Col7());*/
		
		paramSource.addValue("winderDrum2Col1Desc",data.getWinderDrum2Col1Desc());
		paramSource.addValue("winderDrum2Col2Desc",data.getWinderDrum2Col2Desc());
		paramSource.addValue("winderDrum2Col3Desc",data.getWinderDrum2Col3Desc());
		paramSource.addValue("winderDrum2Col4Desc",data.getWinderDrum2Col4Desc());
		paramSource.addValue("winderDrum2Col5Desc",data.getWinderDrum2Col5Desc());
		/*paramSource.addValue("winderDrum2Col6Desc",data.getWinderDrum2Col6Desc());
		paramSource.addValue("winderDrum2Col7Desc",data.getWinderDrum2Col7Desc());*/
		
		
		
		paramSource.addValue("rollEjectorCol1",data.isRollEjectorCol1());
		paramSource.addValue("rollEjectorCol2",data.isRollEjectorCol2());
		paramSource.addValue("rollEjectorCol3",data.isRollEjectorCol3());
		
		paramSource.addValue("rollEjectorCol1Desc",data.getRollEjectorCol1Desc());
		paramSource.addValue("rollEjectorCol2Desc",data.getRollEjectorCol2Desc());
		paramSource.addValue("rollEjectorCol3Desc",data.getRollEjectorCol3Desc());
		
		
		paramSource.addValue("riderRollCol1",data.isRiderRollCol1());
		paramSource.addValue("riderRollCol2",data.isRiderRollCol2());
		paramSource.addValue("riderRollCol3",data.isRiderRollCol3());
		paramSource.addValue("riderRollCol4",data.getRiderRollCol4());
		paramSource.addValue("riderRollCol5",data.isRiderRollCol5());
		paramSource.addValue("riderRollCol6",data.isRiderRollCol6());
		paramSource.addValue("riderRollCol7",data.isRiderRollCol7());
		paramSource.addValue("riderRollCol8",data.isRiderRollCol8());
		
		
		paramSource.addValue("riderRollCol1Desc",data.getRiderRollCol1Desc());
		paramSource.addValue("riderRollCol2Desc",data.getRiderRollCol2Desc());
		paramSource.addValue("riderRollCol3Desc",data.getRiderRollCol3Desc());
		paramSource.addValue("riderRollCol4Desc",data.getRiderRollCol4Desc());
		paramSource.addValue("riderRollCol5Desc",data.getRiderRollCol5Desc());
		paramSource.addValue("riderRollCol6Desc",data.getRiderRollCol6Desc());
		paramSource.addValue("riderRollCol7Desc",data.getRiderRollCol7Desc());
		paramSource.addValue("riderRollCol8Desc",data.getRiderRollCol8Desc());
		
		
		paramSource.addValue("bowedRollCol1",data.getBowedRollCol1());
		paramSource.addValue("bowedRollCol2",data.isBowedRollCol2());
		paramSource.addValue("bowedRollCol3",data.isBowedRollCol3());
		
		paramSource.addValue("bowedRollCol1Desc",data.getBowedRollCol1Desc());
		paramSource.addValue("bowedRollCol2Desc",data.getBowedRollCol2Desc());
		paramSource.addValue("bowedRollCol3Desc",data.getBowedRollCol3Desc());
		
		paramSource.addValue("coreChucksCol1",data.isCoreChucksCol1());
		paramSource.addValue("coreChucksCol2",data.isCoreChucksCol2());
		paramSource.addValue("coreChucksCol3",data.isCoreChucksCol3());
		paramSource.addValue("coreChucksCol4",data.isCoreChucksCol4());
		
		paramSource.addValue("coreChucksCol1Desc",data.getCoreChucksCol1Desc());
		paramSource.addValue("coreChucksCol2Desc",data.getCoreChucksCol2Desc());
		paramSource.addValue("coreChucksCol3Desc",data.getCoreChucksCol3Desc());
		paramSource.addValue("coreChucksCol4Desc",data.getCoreChucksCol4Desc());
		
		paramSource.addValue("nipGuardCol1",data.isNipGuardCol1());
		paramSource.addValue("nipGuardCol2",data.isNipGuardCol2());
		paramSource.addValue("nipGuardCol3",data.isNipGuardCol3());
		
		
		paramSource.addValue("nipGuardCol1Desc",data.getNipGuardCol1Desc());
		paramSource.addValue("nipGuardCol2Desc",data.getNipGuardCol2Desc());
		paramSource.addValue("nipGuardCol3Desc",data.getNipGuardCol3Desc());
		
		paramSource.addValue("tableLeftGateCol1",data.isTableLeftGateCol1());
		paramSource.addValue("tableLeftGateCol2",data.isTableLeftGateCol2());
		
		
		paramSource.addValue("tableLeftGateCol1Desc",data.getTableLeftGateCol1Desc());
		paramSource.addValue("tableLeftGateCol2Desc",data.getTableLeftGateCol2Desc());
		
		
		if (data.getId() == 0) {	
			
			String sql=DatabaseUtil.getSQL("sql/insertR1Operator.sql");
			jdbcTemplate.update(sql, paramSource);
		}	
		else
		{
			paramSource.addValue("id",data.getId());
			String sql=DatabaseUtil.getSQL("sql/updateR1Operator.sql");
			jdbcTemplate.update(sql, paramSource);
		}
		
		

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.st.obcc.dao.R1OperatorDao#getOperatorData(java.lang.String,
	 * java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public R1Operator getOperatorData(String position, String date,
			String shift, String crew) throws Exception {
		// TODO Auto-generated method stub

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSourceQRT);
		String sql = "select * from [R1Operator] where [position]=? AND [date]=? AND [shift] = ?  ";

		R1Operator r1Operator = null;
		try {
			r1Operator = jdbcTemplate.queryForObject(sql, new Object[] {
					position, date, shift }, new RowMapper<R1Operator>() {
				/*
				 * (non-Javadoc)
				 * 
				 * @see
				 * org.springframework.jdbc.core.RowMapper#mapRow(java.sql.ResultSet
				 * , int)
				 */
				@Override
				public R1Operator mapRow(ResultSet rs, int arg1)
						throws SQLException {
					// TODO Auto-generated method stub
					R1Operator operator = new R1Operator();

					operator.setId(rs.getInt("id"));
					operator.setPosition(rs.getString("position"));
					operator.setOperatorName(rs.getString("operator_name"));
					operator.setEdate(rs.getString("date"));
					operator.setShift(rs.getString("shift"));
					operator.setCrew(rs.getString("crew"));
					
					operator.setMachinedown(rs.getBoolean("machinedown"));
					operator.setLeadInRollCol1(rs.getString("lead_In_Roll_col1"));
					operator.setLeadInRollCol2(rs.getBoolean("lead_In_Roll_col2"));
					operator.setLeadInRollCol3(rs.getBoolean("lead_In_Roll_col3"));
					operator.setLeadInRollCol4(rs.getString("lead_In_Roll_col4"));
					operator.setLeadInRollCol5(rs.getBoolean("lead_In_Roll_col5"));
					
					operator.setLeadInRollCol1Desc(rs.getString("lead_In_Roll_col1_Desc"));
					operator.setLeadInRollCol2Desc(rs.getString("lead_In_Roll_col2_Desc"));
					operator.setLeadInRollCol3Desc(rs.getString("lead_In_Roll_col3_Desc"));
					operator.setLeadInRollCol4Desc(rs.getString("lead_In_Roll_col4_Desc"));
					operator.setLeadInRollCol5Desc(rs.getString("lead_In_Roll_col5_Desc"));
					
					
					operator.setSectionRollCol1(rs.getBoolean("section_Roll_col1"));
					operator.setSectionRollCol1Desc(rs.getString("section_Roll_col1_Desc"));
					
					operator.setBreakAssemblyCol1(rs.getBoolean("break_assembly_col1"));
					operator.setBreakAssemblyCol2(rs.getBoolean("break_assembly_col2"));
					
					
					operator.setBreakAssemblyCol1Desc(rs.getString("break_assembly_col1_Desc"));
					operator.setBreakAssemblyCol2Desc(rs.getString("break_assembly_col2_Desc"));
					
					operator.setSlittersCol1(rs.getBoolean("slitters_col1"));
					operator.setSlittersCol2(rs.getBoolean("slitters_col2"));
					operator.setSlittersCol3(rs.getBoolean("slitters_col3"));
					
					
					operator.setSlittersCol1Desc(rs.getString("slitters_col1_Desc"));
					operator.setSlittersCol2Desc(rs.getString("slitters_col2_Desc"));
					operator.setSlittersCol3Desc(rs.getString("slitters_col3_Desc"));
					
					
					operator.setTrimAssemblyCol1(rs.getBoolean("trim_assembly_col1"));
					operator.setTrimAssemblyCol2(rs.getBoolean("trim_assembly_col2"));
					operator.setTrimAssemblyCol3(rs.getBoolean("trim_assembly_col3"));
					operator.setTrimAssemblyCol4(rs.getBoolean("trim_assembly_col4"));
					
					
					operator.setTrimAssemblyCol1Desc(rs.getString("trim_assembly_col1_Desc"));
					operator.setTrimAssemblyCol2Desc(rs.getString("trim_assembly_col2_Desc"));
					operator.setTrimAssemblyCol3Desc(rs.getString("trim_assembly_col3_Desc"));
					operator.setTrimAssemblyCol4Desc(rs.getString("trim_assembly_col4_Desc"));
					
					
					operator.setTensiionRollCol1(rs.getBoolean("tensiion_Roll_col1"));
					operator.setTensiionRollCol2(rs.getBoolean("tensiion_Roll_col2"));
					operator.setTensiionRollCol3(rs.getBoolean("tensiion_Roll_col3"));
					
					
					operator.setTensiionRollCol1Desc(rs.getString("tensiion_Roll_col1_Desc"));
					operator.setTensiionRollCol2Desc(rs.getString("tensiion_Roll_col2_Desc"));
					operator.setTensiionRollCol3Desc(rs.getString("tensiion_Roll_col3_Desc"));
					
					
					operator.setWinderDrum1Col1(rs.getString("winder_Drum_col1"));
					operator.setWinderDrum1Col2(rs.getBoolean("winder_Drum_col2"));
					operator.setWinderDrum1Col3(rs.getBoolean("winder_Drum_col3"));
					operator.setWinderDrum1Col4(rs.getString("winder_Drum_col4"));
					operator.setWinderDrum1Col5(rs.getBoolean("winder_Drum_col5"));
					/*operator.setWinderDrum1Col6(rs.getBoolean("winder_Drum_col6"));
					operator.setWinderDrum1Col7(rs.getBoolean("winder_Drum_col7"));*/
					
					operator.setWinderDrum1Col1Desc(rs.getString("winder_Drum_col1_Desc"));
					operator.setWinderDrum1Col2Desc(rs.getString("winder_Drum_col2_Desc"));
					operator.setWinderDrum1Col3Desc(rs.getString("winder_Drum_col3_Desc"));
					operator.setWinderDrum1Col4Desc(rs.getString("winder_Drum_col4_Desc"));
					operator.setWinderDrum1Col5Desc(rs.getString("winder_Drum_col5_Desc"));
					/*operator.setWinderDrum1Col6Desc(rs.getString("winder_Drum_col6_Desc"));
					operator.setWinderDrum1Col7Desc(rs.getString("winder_Drum_col7_Desc"));*/
					
					
					operator.setWinderDrum2Col1(rs.getString("winder_Drum_col1"));
					operator.setWinderDrum2Col2(rs.getBoolean("winder_Drum_col2"));
					operator.setWinderDrum2Col3(rs.getBoolean("winder_Drum_col3"));
					operator.setWinderDrum2Col4(rs.getString("winder_Drum_col4"));
					operator.setWinderDrum2Col5(rs.getBoolean("winder_Drum_col5"));
					/*operator.setWinderDrum2Col6(rs.getBoolean("winder_Drum_col6"));
					operator.setWinderDrum2Col7(rs.getBoolean("winder_Drum_col7"));*/
					
					operator.setWinderDrum2Col1Desc(rs.getString("winder_Drum_col1_Desc"));
					operator.setWinderDrum2Col2Desc(rs.getString("winder_Drum_col2_Desc"));
					operator.setWinderDrum2Col3Desc(rs.getString("winder_Drum_col3_Desc"));
					operator.setWinderDrum2Col4Desc(rs.getString("winder_Drum_col4_Desc"));
					operator.setWinderDrum2Col5Desc(rs.getString("winder_Drum_col5_Desc"));
					/*operator.setWinderDrum2Col6Desc(rs.getString("winder_Drum_col6_Desc"));
					operator.setWinderDrum2Col7Desc(rs.getString("winder_Drum_col7_Desc"));*/
					
					operator.setRollEjectorCol1(rs.getBoolean("roll_Ejector_Col1"));
					operator.setRollEjectorCol2(rs.getBoolean("roll_Ejector_Col2"));
					operator.setRollEjectorCol3(rs.getBoolean("roll_Ejector_Col3"));
					
					operator.setRollEjectorCol1Desc(rs.getString("roll_Ejector_Col1_Desc"));
					operator.setRollEjectorCol2Desc(rs.getString("roll_Ejector_Col2_Desc"));
					operator.setRollEjectorCol3Desc(rs.getString("roll_Ejector_Col3_Desc"));
					
					
					operator.setRiderRollCol1(rs.getBoolean("rider_Roll_Col1"));
					operator.setRiderRollCol2(rs.getBoolean("rider_Roll_Col2"));
					operator.setRiderRollCol3(rs.getBoolean("rider_Roll_Col3"));
					operator.setRiderRollCol4(rs.getString("rider_Roll_Col4"));
					operator.setRiderRollCol5(rs.getBoolean("rider_Roll_Col5"));
					operator.setRiderRollCol6(rs.getBoolean("rider_Roll_Col6"));
					operator.setRiderRollCol7(rs.getBoolean("rider_Roll_Col7"));
					operator.setRiderRollCol8(rs.getBoolean("rider_Roll_Col8"));
					
					
					operator.setRiderRollCol1Desc(rs.getString("rider_Roll_Col1_Desc"));
					operator.setRiderRollCol2Desc(rs.getString("rider_Roll_Col2_Desc"));
					operator.setRiderRollCol3Desc(rs.getString("rider_Roll_Col3_Desc"));
					operator.setRiderRollCol4Desc(rs.getString("rider_Roll_Col4_Desc"));
					operator.setRiderRollCol5Desc(rs.getString("rider_Roll_Col5_Desc"));
					operator.setRiderRollCol6Desc(rs.getString("rider_Roll_Col6_Desc"));
					operator.setRiderRollCol7Desc(rs.getString("rider_Roll_Col7_Desc"));
					operator.setRiderRollCol8Desc(rs.getString("rider_Roll_Col8_Desc"));
					
					operator.setBowedRollCol1(rs.getString("bowed_Roll_Col1"));
					operator.setBowedRollCol2(rs.getBoolean("bowed_Roll_Col2"));
					operator.setBowedRollCol3(rs.getBoolean("bowed_Roll_Col3"));
					
					operator.setBowedRollCol1Desc(rs.getString("bowed_Roll_Col1_Desc"));
					operator.setBowedRollCol2Desc(rs.getString("bowed_Roll_Col2_Desc"));
					operator.setBowedRollCol3Desc(rs.getString("bowed_Roll_Col3_Desc"));
					
					
					operator.setCoreChucksCol1(rs.getBoolean("core_Chucks_col1"));
					operator.setCoreChucksCol2(rs.getBoolean("core_Chucks_col2"));
					operator.setCoreChucksCol3(rs.getBoolean("core_Chucks_col3"));
					operator.setCoreChucksCol4(rs.getBoolean("core_Chucks_col4"));
					
					operator.setCoreChucksCol1Desc(rs.getString("core_Chucks_col1_Desc"));
					operator.setCoreChucksCol2Desc(rs.getString("core_Chucks_col2_Desc"));
					operator.setCoreChucksCol3Desc(rs.getString("core_Chucks_col3_Desc"));
					operator.setCoreChucksCol4Desc(rs.getString("core_Chucks_col4_Desc"));
					
					operator.setNipGuardCol1(rs.getBoolean("nip_Guard_col1"));
					operator.setNipGuardCol2(rs.getBoolean("nip_Guard_col2"));
					operator.setNipGuardCol3(rs.getBoolean("nip_Guard_col3"));
					
					
					operator.setNipGuardCol1Desc(rs.getString("nip_Guard_col1_Desc"));
					operator.setNipGuardCol2Desc(rs.getString("nip_Guard_col2_Desc"));
					operator.setNipGuardCol3Desc(rs.getString("nip_Guard_col3_Desc"));
					
					operator.setTableLeftGateCol1(rs.getBoolean("table_left_gate_col1"));
					operator.setTableLeftGateCol2(rs.getBoolean("table_left_gate_col2"));
					
					operator.setTableLeftGateCol1Desc(rs.getString("table_left_gate_col1_Desc"));
					operator.setTableLeftGateCol2Desc(rs.getString("table_left_gate_col2_Desc"));
					 

					return operator;
				}

			});

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return r1Operator;
	}
	
	
	/* (non-Javadoc)
	 * @see com.st.obcc.dao.R1OperatorDao#getOperatorDataList(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public List<R1Operator> getOperatorDataList(String position, String Sdate,
			String edate) throws Exception {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSourceQRT);
		String sql = "select * from [R1Operator] where [position]=? AND [date] BETWEEN ? AND ?";

		List<R1Operator> r1Operator = new ArrayList<R1Operator>();
		try {
			r1Operator = jdbcTemplate.query(sql, new Object[] {position, Sdate, edate}, new RowMapper<R1Operator>() {
				/*
				 * (non-Javadoc)
				 * 
				 * @see
				 * org.springframework.jdbc.core.RowMapper#mapRow(java.sql.ResultSet
				 * , int)
				 */
				@Override
				public R1Operator mapRow(ResultSet rs, int arg1)
						throws SQLException {
					// TODO Auto-generated method stub
					R1Operator operator = new R1Operator();

					try {
						String newDate = dateFormat.format(fromuser.parse(rs.getString("date")));
					
					
					operator.setId(rs.getInt("id"));
					operator.setPosition(rs.getString("position"));
					operator.setOperatorName(rs.getString("operator_name"));
					operator.setEdate(newDate);
					operator.setShift(rs.getString("shift"));
					operator.setCrew(rs.getString("crew"));
					operator.setMachinedown(rs.getBoolean("machinedown"));
					operator.setLeadInRollCol1(rs.getString("lead_In_Roll_col1"));
					operator.setLeadInRollCol2(rs.getBoolean("lead_In_Roll_col2"));
					operator.setLeadInRollCol3(rs.getBoolean("lead_In_Roll_col3"));
					operator.setLeadInRollCol4(rs.getString("lead_In_Roll_col4"));
					operator.setLeadInRollCol5(rs.getBoolean("lead_In_Roll_col5"));
					
					operator.setLeadInRollCol1Desc(rs.getString("lead_In_Roll_col1_Desc"));
					operator.setLeadInRollCol2Desc(rs.getString("lead_In_Roll_col2_Desc"));
					operator.setLeadInRollCol3Desc(rs.getString("lead_In_Roll_col3_Desc"));
					operator.setLeadInRollCol4Desc(rs.getString("lead_In_Roll_col4_Desc"));
					operator.setLeadInRollCol5Desc(rs.getString("lead_In_Roll_col5_Desc"));
					
					
					operator.setSectionRollCol1(rs.getBoolean("section_Roll_col1"));
					operator.setSectionRollCol1Desc(rs.getString("section_Roll_col1_Desc"));
					
					operator.setBreakAssemblyCol1(rs.getBoolean("break_assembly_col1"));
					operator.setBreakAssemblyCol2(rs.getBoolean("break_assembly_col2"));
					
					
					operator.setBreakAssemblyCol1Desc(rs.getString("break_assembly_col1_Desc"));
					operator.setBreakAssemblyCol2Desc(rs.getString("break_assembly_col2_Desc"));
					
					operator.setSlittersCol1(rs.getBoolean("slitters_col1"));
					operator.setSlittersCol2(rs.getBoolean("slitters_col2"));
					operator.setSlittersCol3(rs.getBoolean("slitters_col3"));
					
					
					operator.setSlittersCol1Desc(rs.getString("slitters_col1_Desc"));
					operator.setSlittersCol2Desc(rs.getString("slitters_col2_Desc"));
					operator.setSlittersCol3Desc(rs.getString("slitters_col3_Desc"));
					
					
					operator.setTrimAssemblyCol1(rs.getBoolean("trim_assembly_col1"));
					operator.setTrimAssemblyCol2(rs.getBoolean("trim_assembly_col2"));
					operator.setTrimAssemblyCol3(rs.getBoolean("trim_assembly_col3"));
					operator.setTrimAssemblyCol4(rs.getBoolean("trim_assembly_col4"));
					
					
					operator.setTrimAssemblyCol1Desc(rs.getString("trim_assembly_col1_Desc"));
					operator.setTrimAssemblyCol2Desc(rs.getString("trim_assembly_col2_Desc"));
					operator.setTrimAssemblyCol3Desc(rs.getString("trim_assembly_col3_Desc"));
					operator.setTrimAssemblyCol4Desc(rs.getString("trim_assembly_col4_Desc"));
					
					
					operator.setTensiionRollCol1(rs.getBoolean("tensiion_Roll_col1"));
					operator.setTensiionRollCol2(rs.getBoolean("tensiion_Roll_col2"));
					operator.setTensiionRollCol3(rs.getBoolean("tensiion_Roll_col3"));
					
					
					operator.setTensiionRollCol1Desc(rs.getString("tensiion_Roll_col1_Desc"));
					operator.setTensiionRollCol2Desc(rs.getString("tensiion_Roll_col2_Desc"));
					operator.setTensiionRollCol3Desc(rs.getString("tensiion_Roll_col3_Desc"));
					
					
					operator.setWinderDrum1Col1(rs.getString("winder_Drum_col1"));
					operator.setWinderDrum1Col2(rs.getBoolean("winder_Drum_col2"));
					operator.setWinderDrum1Col3(rs.getBoolean("winder_Drum_col3"));
					operator.setWinderDrum1Col4(rs.getString("winder_Drum_col4"));
					operator.setWinderDrum1Col5(rs.getBoolean("winder_Drum_col5"));
					/*operator.setWinderDrum1Col6(rs.getBoolean("winder_Drum_col6"));
					operator.setWinderDrum1Col7(rs.getBoolean("winder_Drum_col7"));*/
					
					operator.setWinderDrum1Col1Desc(rs.getString("winder_Drum_col1_Desc"));
					operator.setWinderDrum1Col2Desc(rs.getString("winder_Drum_col2_Desc"));
					operator.setWinderDrum1Col3Desc(rs.getString("winder_Drum_col3_Desc"));
					operator.setWinderDrum1Col4Desc(rs.getString("winder_Drum_col4_Desc"));
					operator.setWinderDrum1Col5Desc(rs.getString("winder_Drum_col5_Desc"));
					/*operator.setWinderDrum1Col6Desc(rs.getString("winder_Drum_col6_Desc"));
					operator.setWinderDrum1Col7Desc(rs.getString("winder_Drum_col7_Desc"));*/
					
					
					operator.setWinderDrum2Col1(rs.getString("winder_Drum_col1"));
					operator.setWinderDrum2Col2(rs.getBoolean("winder_Drum_col2"));
					operator.setWinderDrum2Col3(rs.getBoolean("winder_Drum_col3"));
					operator.setWinderDrum2Col4(rs.getString("winder_Drum_col4"));
					operator.setWinderDrum2Col5(rs.getBoolean("winder_Drum_col5"));
					/*operator.setWinderDrum2Col6(rs.getBoolean("winder_Drum_col6"));
					operator.setWinderDrum2Col7(rs.getBoolean("winder_Drum_col7"));*/
					
					operator.setWinderDrum2Col1Desc(rs.getString("winder_Drum_col1_Desc"));
					operator.setWinderDrum2Col2Desc(rs.getString("winder_Drum_col2_Desc"));
					operator.setWinderDrum2Col3Desc(rs.getString("winder_Drum_col3_Desc"));
					operator.setWinderDrum2Col4Desc(rs.getString("winder_Drum_col4_Desc"));
					operator.setWinderDrum2Col5Desc(rs.getString("winder_Drum_col5_Desc"));
					/*operator.setWinderDrum2Col6Desc(rs.getString("winder_Drum_col6_Desc"));
					operator.setWinderDrum2Col7Desc(rs.getString("winder_Drum_col7_Desc"));*/
					
					operator.setRollEjectorCol1(rs.getBoolean("roll_Ejector_Col1"));
					operator.setRollEjectorCol2(rs.getBoolean("roll_Ejector_Col2"));
					operator.setRollEjectorCol3(rs.getBoolean("roll_Ejector_Col3"));
					
					operator.setRollEjectorCol1Desc(rs.getString("roll_Ejector_Col1_Desc"));
					operator.setRollEjectorCol2Desc(rs.getString("roll_Ejector_Col2_Desc"));
					operator.setRollEjectorCol3Desc(rs.getString("roll_Ejector_Col3_Desc"));
					
					
					operator.setRiderRollCol1(rs.getBoolean("rider_Roll_Col1"));
					operator.setRiderRollCol2(rs.getBoolean("rider_Roll_Col2"));
					operator.setRiderRollCol3(rs.getBoolean("rider_Roll_Col3"));
					operator.setRiderRollCol4(rs.getString("rider_Roll_Col4"));
					operator.setRiderRollCol5(rs.getBoolean("rider_Roll_Col5"));
					operator.setRiderRollCol6(rs.getBoolean("rider_Roll_Col6"));
					operator.setRiderRollCol7(rs.getBoolean("rider_Roll_Col7"));
					operator.setRiderRollCol8(rs.getBoolean("rider_Roll_Col8"));
					
					
					operator.setRiderRollCol1Desc(rs.getString("rider_Roll_Col1_Desc"));
					operator.setRiderRollCol2Desc(rs.getString("rider_Roll_Col2_Desc"));
					operator.setRiderRollCol3Desc(rs.getString("rider_Roll_Col3_Desc"));
					operator.setRiderRollCol4Desc(rs.getString("rider_Roll_Col4_Desc"));
					operator.setRiderRollCol5Desc(rs.getString("rider_Roll_Col5_Desc"));
					operator.setRiderRollCol6Desc(rs.getString("rider_Roll_Col6_Desc"));
					operator.setRiderRollCol7Desc(rs.getString("rider_Roll_Col7_Desc"));
					operator.setRiderRollCol8Desc(rs.getString("rider_Roll_Col8_Desc"));
					
					operator.setBowedRollCol1(rs.getString("bowed_Roll_Col1"));
					operator.setBowedRollCol2(rs.getBoolean("bowed_Roll_Col2"));
					operator.setBowedRollCol3(rs.getBoolean("bowed_Roll_Col3"));
					
					operator.setBowedRollCol1Desc(rs.getString("bowed_Roll_Col1_Desc"));
					operator.setBowedRollCol2Desc(rs.getString("bowed_Roll_Col2_Desc"));
					operator.setBowedRollCol3Desc(rs.getString("bowed_Roll_Col3_Desc"));
					
					
					operator.setCoreChucksCol1(rs.getBoolean("core_Chucks_col1"));
					operator.setCoreChucksCol2(rs.getBoolean("core_Chucks_col2"));
					operator.setCoreChucksCol3(rs.getBoolean("core_Chucks_col3"));
					operator.setCoreChucksCol4(rs.getBoolean("core_Chucks_col4"));
					
					operator.setCoreChucksCol1Desc(rs.getString("core_Chucks_col1_Desc"));
					operator.setCoreChucksCol2Desc(rs.getString("core_Chucks_col2_Desc"));
					operator.setCoreChucksCol3Desc(rs.getString("core_Chucks_col3_Desc"));
					operator.setCoreChucksCol4Desc(rs.getString("core_Chucks_col4_Desc"));
					
					operator.setNipGuardCol1(rs.getBoolean("nip_Guard_col1"));
					operator.setNipGuardCol2(rs.getBoolean("nip_Guard_col2"));
					operator.setNipGuardCol3(rs.getBoolean("nip_Guard_col3"));
					
					
					operator.setNipGuardCol1Desc(rs.getString("nip_Guard_col1_Desc"));
					operator.setNipGuardCol2Desc(rs.getString("nip_Guard_col2_Desc"));
					operator.setNipGuardCol3Desc(rs.getString("nip_Guard_col3_Desc"));
					
					operator.setTableLeftGateCol1(rs.getBoolean("table_left_gate_col1"));
					operator.setTableLeftGateCol2(rs.getBoolean("table_left_gate_col2"));
					
					operator.setTableLeftGateCol1Desc(rs.getString("table_left_gate_col1_Desc"));
					operator.setTableLeftGateCol2Desc(rs.getString("table_left_gate_col2_Desc"));
					 

					
					
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					return operator;
				}

			});

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return r1Operator;
	}

	
	
	@Override
	public long getDataCountDatePercentage1(String position, String sdate,String edate) throws Exception {
		
			
			SimpleDateFormat format=new SimpleDateFormat("MM-dd-yyyy");
			
			List<R1Operator> operatordata= getOperatorDataList( position,sdate,edate);
		
				
			
			int count=0;long set=0,percentage=0;
			int days = CommonUtil.getDaysDiffernce(format.parse(sdate), format.parse(edate))+1;
			List<Integer> al=new ArrayList<Integer>();
		if(operatordata!=null)	
		{
			for(R1Operator data:operatordata)
			{
			   if(data.isMachinedown()!=true)
				{	
							if(data.getLeadInRollCol1() != null)
							{count++;}
							if(data.isLeadInRollCol2() == true||data.isLeadInRollCol2() == false)
							{count++;}
							if(data.isLeadInRollCol3() == true||data.isLeadInRollCol3() == false)
							{count++;}
							if(data.getLeadInRollCol4() != null)
							{count++;}
							if(data.isLeadInRollCol5() == true||data.isLeadInRollCol5() == false)
							{count++;}
							if(data.isSectionRollCol1() == true||data.isSectionRollCol1() == false)
							{count++;}
							if(data.isBreakAssemblyCol1() == true||data.isBreakAssemblyCol1() == false)
							{count++;}
							if(data.isBreakAssemblyCol2() == true||data.isBreakAssemblyCol2() == false)
							{count++;}
							if(data.isSlittersCol1() == true||data.isSlittersCol1() == false)
							{count++;}
							if(data.isSlittersCol2() == true||data.isSlittersCol2() == false)
							{count++;}
							if(data.isSlittersCol3() == true||data.isSlittersCol3() == false)
							{count++;}
							if(data.isTrimAssemblyCol1() == true||data.isTrimAssemblyCol1() == false)
							{count++;}
							if(data.isTrimAssemblyCol2() == true||data.isTrimAssemblyCol2() == false)
							{count++;}
							if(data.isTrimAssemblyCol3() == true||data.isTrimAssemblyCol3() == false)
							{count++;}
							if(data.isTrimAssemblyCol4() == true||data.isTrimAssemblyCol4() == false)
							{count++;}
							if(data.isTensiionRollCol1() == true||data.isTensiionRollCol1() == false)
							{count++;}
							if(data.isTensiionRollCol2() == true||data.isTensiionRollCol2() == false)
							{count++;}
							if(data.isTensiionRollCol3() == true||data.isTensiionRollCol3() == false)
							{count++;}
							if(data.getWinderDrum1Col1() != null)
							{count++;}
							if(data.isWinderDrum1Col2() == true||data.isWinderDrum1Col2() == false)
							{count++;}
							if(data.isWinderDrum1Col3() == true||data.isWinderDrum1Col3() == false)
							{count++;}
							if(data.getWinderDrum1Col4() != null)
							{count++;}
							if(data.isWinderDrum1Col5() == true||data.isWinderDrum1Col5() == false)
							{count++;}
							if(data.getWinderDrum2Col1() != null)
							{count++;}
							if(data.isWinderDrum2Col2() == true||data.isWinderDrum2Col2() == false)
							{count++;}
							if(data.isWinderDrum2Col3() == true||data.isWinderDrum2Col3() == false)
							{count++;}
							if(data.getWinderDrum2Col4() != null)
							{count++;}
							if(data.isWinderDrum2Col5() == true||data.isWinderDrum2Col5() == false)
							{count++;}
							if(data.isRollEjectorCol1() == true||data.isRollEjectorCol1() == false)
							{count++;}
							if(data.isRollEjectorCol2() == true||data.isRollEjectorCol2() == false)
							{count++;}
							if(data.isRollEjectorCol3() == true||data.isRollEjectorCol3() == false)
							{count++;}
							if(data.isRiderRollCol1() == true||data.isRiderRollCol1() == false)
							{count++;}
							if(data.isRiderRollCol2() == true||data.isRiderRollCol2() == false)
							{count++;}
							if(data.isRiderRollCol3() == true||data.isRiderRollCol3() == false)
							{count++;}
							if(data.getRiderRollCol4() != null)
							{count++;}
							if(data.isRiderRollCol5() == true||data.isRiderRollCol5() == false)
							{count++;}
							if(data.isRiderRollCol6() == true||data.isRiderRollCol6() == false)
							{count++;}
							if(data.isRiderRollCol7() == true||data.isRiderRollCol7() == false)
							{count++;}
							if(data.isRiderRollCol8() == true||data.isRiderRollCol8() == false)
							{count++;}			 
							if(data.getBowedRollCol1() != null)
							{count++;}
							if(data.isBowedRollCol2() == true||data.isBowedRollCol2() == false)
							{count++;}
							if(data.isBowedRollCol3() == true||data.isBowedRollCol3() == false)
							{count++;}
							if(data.isCoreChucksCol1() == true||data.isCoreChucksCol1() == false)
							{count++;}
							if(data.isCoreChucksCol2() == true||data.isCoreChucksCol2() == false)
							{count++;}
							if(data.isCoreChucksCol3() == true||data.isCoreChucksCol3() == false)
							{count++;}
							if(data.isCoreChucksCol4() == true||data.isCoreChucksCol4() == false)
							{count++;}
							if(data.isNipGuardCol1() == true||data.isNipGuardCol1() == false)
							{count++;}
							if(data.isNipGuardCol2() == true||data.isNipGuardCol2() == false)
							{count++;}
							if(data.isNipGuardCol3() == true||data.isNipGuardCol3() == false)
							{count++;}
							if(data.isTableLeftGateCol1() == true||data.isTableLeftGateCol1() == false)
							{count++;}
							if(data.isTableLeftGateCol2() == true||data.isTableLeftGateCol2() == false)
							{count++;}
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
		 		days=days*2;
		 		percentage=set/days;
				
		 }
		
		return percentage;
}
	
/*	 (non-Javadoc)
	 * @see com.st.obcc.dao.R1OperatorDao#getDataCountDatePercentage(java.lang.String, java.lang.String, java.lang.String)
	 
	@Override
	public long getDataCountDatePercentage(String position, String sdate,
			String edate) throws Exception {
		
		
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSourceQRT);
		Object[] param=null;
		String sql;
		
		Date sDate=CommonUtil.checkDate(sdate, dateFormat);
		Date esDate=CommonUtil.checkDate(edate, dateFormat);
		
		final  int days=CommonUtil.getDaysDiffernce(sDate, esDate);
         int total1 = 0;
         
         
        	total1 = days*2;s
          

        final int total = total1;
		
		 
			sql="SELECT COUNT(*) As [TotalDataEntry], ( "
					+ "SELECT COUNT(*) As [totaldata] "
					+ "FROM R1Operator "
					+ " WHERE (date between ? AND ? )"
					+ " )as TotalExport FROM R1Operator e1 ";
					param=new Object[]{
						sdate,
						edate	
					};
			 
			List<R1Operator> wrapperProductions=null;
			try {
				wrapperProductions=jdbcTemplate.query(sql,param, new RowMapper<R1Operator>(){

							@Override
							public R1Operator mapRow(ResultSet rs, int arg1)
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
								 
								
								
								R1Operator wrapperProduction=new R1Operator();
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
	 * @see com.st.obcc.dao.R1OperatorDao#getDataCountDatePercentage(java.lang.String, java.lang.String)
	 
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
					+ "FROM R1Operator "
					+ " WHERE (date between ? AND ? )"
					+ " )as TotalExport FROM R1Operator e1 ";
					param=new Object[]{
							Sdate,
						edate	
					};
			 
			List<R1Operator> wrapperProductions=null;
			try {
				wrapperProductions=jdbcTemplate.query(sql,param, new RowMapper<R1Operator>(){

							@Override
							public R1Operator mapRow(ResultSet rs, int arg1)
									throws SQLException {
								
								
								int totalDataEntry = rs.getInt("TotalDataEntry");
								int totalExport = rs.getInt("TotalExport");
								
								//int percentage = totalExport*100/totalDataEntry;
								double percentage = totalExport*100/total;
								
								
								R1Operator wrapperProduction=new R1Operator();
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

 
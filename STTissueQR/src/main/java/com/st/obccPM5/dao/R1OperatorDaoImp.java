/**
 *Oct 22, 2019
 *R1OperatorDaoImpl.java
 * TODO
 *com.st.obccPM5.dao
 *R1OperatorDaoImpl.java
 *sohan
 */
package com.st.obccPM5.dao;

import javax.sql.DataSource;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.st.common.CommonUtil;
import com.st.common.DatabaseUtil;
import com.st.obccPM5.model.R1OperatorPM5;

/**
 * @author sohan lal
 *
 */
@Repository
public class R1OperatorDaoImp implements R1OperatorPM5Dao {

	@Autowired
	@Qualifier("dataSourceOBCC")
	private DataSource dataSourceQRT;
	
	private SimpleDateFormat dateFormat=new SimpleDateFormat("MM-dd-yyyy");
	private SimpleDateFormat fromuser=new SimpleDateFormat("yyyy-MM-dd");

	
	/* (non-Javadoc)
	 * @see com.st.oBcc1pm5.dao.R1OperatorPM5Dao#saveorUpdate(com.st.oBcc1pm5.model.R1OperatorPM5)
	 */
	@Override
	public void saveorUpdate(R1OperatorPM5 data) {
		NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(dataSourceQRT);
	 	MapSqlParameterSource paramSource=new MapSqlParameterSource();
	 	
	 	paramSource.addValue("position",data.getPosition());
		paramSource.addValue("operatorname",data.getOperatorName());
		paramSource.addValue("date",data.getEdate());
		paramSource.addValue("crew",data.getCrew());
		paramSource.addValue("shift",data.getShift());
		paramSource.addValue("machinedown",data.isMachinedown());
		
		
		paramSource.addValue("leadInRollcol1",data.isLeadInRollCol1());
		paramSource.addValue("leadInRollcol2",data.isLeadInRollCol2());
		paramSource.addValue("leadInRollcol3",data.isLeadInRollCol3());
		paramSource.addValue("leadInRollcol4",data.isLeadInRollCol4());
		paramSource.addValue("leadInRollcol5",data.isLeadInRollCol5());
		
		paramSource.addValue("leadInRollcol1Desc",data.getLeadInRollCol1Desc());
		paramSource.addValue("leadInRollcol2Desc",data.getLeadInRollCol2Desc());
		paramSource.addValue("leadInRollcol3Desc",data.getLeadInRollCol3Desc());
		paramSource.addValue("leadInRollcol4Desc",data.getLeadInRollCol4Desc());
		paramSource.addValue("leadInRollcol5Desc",data.getLeadInRollCol5Desc());
		
		
		
		paramSource.addValue("sectionRollcol1",data.isSectionRollCol1());
		paramSource.addValue("sectionRollcol1Desc",data.getSectionRollCol1Desc());
		
		
		paramSource.addValue("breakassemblycol1",data.isBreakAssemblyCol1());
		paramSource.addValue("breakassemblycol2",data.isBreakAssemblyCol2());
		paramSource.addValue("breakassemblycol1Desc",data.getBreakAssemblyCol1Desc());
		paramSource.addValue("breakassemblycol2Desc",data.getBreakAssemblyCol2Desc());
		
		
		paramSource.addValue("slitterscol1",data.isSlittersCol1());
		paramSource.addValue("slitterscol2",data.isSlittersCol2());
		paramSource.addValue("slitterscol3",data.isSlittersCol3());
		
		paramSource.addValue("slitterscol1Desc",data.getSlittersCol1Desc());
		paramSource.addValue("slitterscol2Desc",data.getSlittersCol2Desc());
		paramSource.addValue("slitterscol3Desc",data.getSlittersCol3Desc());
		
		
		paramSource.addValue("trimassemblycol1",data.isTrimAssemblyCol1());
		paramSource.addValue("trimassemblycol2",data.isTrimAssemblyCol2());
		paramSource.addValue("trimassemblycol3",data.isTrimAssemblyCol3());
		paramSource.addValue("trimassemblycol4",data.isTrimAssemblyCol4());
		
		
		paramSource.addValue("trimassemblycol1Desc",data.getTrimAssemblyCol1Desc());
		paramSource.addValue("trimassemblycol2Desc",data.getTrimAssemblyCol2Desc());
		paramSource.addValue("trimassemblycol3Desc",data.getTrimAssemblyCol3Desc());
		paramSource.addValue("trimassemblycol4Desc",data.getTrimAssemblyCol4Desc());
		
		
		paramSource.addValue("tensiionRollcol1",data.isTensiionRollCol1());
		paramSource.addValue("tensiionRollcol2",data.isTensiionRollCol2());
		paramSource.addValue("tensiionRollcol3",data.isTensiionRollCol3());
		
		paramSource.addValue("tensiionRollcol1Desc",data.getTensiionRollCol1Desc());
		paramSource.addValue("tensiionRollcol2Desc",data.getTensiionRollCol2Desc());
		paramSource.addValue("tensiionRollcol3Desc",data.getTensiionRollCol3Desc());
		
		paramSource.addValue("winderDrum1col1",data.isWinderDrum1Col1());
		paramSource.addValue("winderDrum1col2",data.isWinderDrum1Col2());
		paramSource.addValue("winderDrum1col3",data.isWinderDrum1Col3());
		paramSource.addValue("winderDrum1col4",data.isWinderDrum1Col4());
		paramSource.addValue("winderDrum1col5",data.isWinderDrum1Col5());
	
		paramSource.addValue("winderDrum1col1Desc",data.getWinderDrum1Col1Desc());
		paramSource.addValue("winderDrum1col2Desc",data.getWinderDrum1Col2Desc());
		paramSource.addValue("winderDrum1col3Desc",data.getWinderDrum1Col3Desc());
		paramSource.addValue("winderDrum1col4Desc",data.getWinderDrum1Col4Desc());
		paramSource.addValue("winderDrum1col5Desc",data.getWinderDrum1Col5Desc());
		 
		paramSource.addValue("winderDrum2col1",data.isWinderDrum2Col1());
		paramSource.addValue("winderDrum2col2",data.isWinderDrum2Col2());
		paramSource.addValue("winderDrum2col3",data.isWinderDrum2Col3());
		paramSource.addValue("winderDrum2col4",data.isWinderDrum2Col4());
		paramSource.addValue("winderDrum2col5",data.isWinderDrum2Col5());
		
		paramSource.addValue("winderDrum2col1Desc",data.getWinderDrum2Col1Desc());
		paramSource.addValue("winderDrum2col2Desc",data.getWinderDrum2Col2Desc());
		paramSource.addValue("winderDrum2col3Desc",data.getWinderDrum2Col3Desc());
		paramSource.addValue("winderDrum2col4Desc",data.getWinderDrum2Col4Desc());
		paramSource.addValue("winderDrum2col5Desc",data.getWinderDrum2Col5Desc());
		
		
		
		paramSource.addValue("rollEjectorcol1",data.isRollEjectorCol1());
		paramSource.addValue("rollEjectorcol2",data.isRollEjectorCol2());
		paramSource.addValue("rollEjectorcol3",data.isRollEjectorCol3());
		
		paramSource.addValue("rollEjectorcol1Desc",data.getRollEjectorCol1Desc());
		paramSource.addValue("rollEjectorcol2Desc",data.getRollEjectorCol2Desc());
		paramSource.addValue("rollEjectorcol3Desc",data.getRollEjectorCol3Desc());
		
		
		paramSource.addValue("riderRollcol1",data.isRiderRollCol1());
		paramSource.addValue("riderRollcol2",data.isRiderRollCol2());
		paramSource.addValue("riderRollcol3",data.isRiderRollCol3());
		paramSource.addValue("riderRollcol4",data.isRiderRollCol4());
		paramSource.addValue("riderRollcol5",data.isRiderRollCol5());
		paramSource.addValue("riderRollcol6",data.isRiderRollCol6());
		paramSource.addValue("riderRollcol7",data.isRiderRollCol7());
		paramSource.addValue("riderRollcol8",data.isRiderRollCol8());
		
		
		paramSource.addValue("riderRollcol1Desc",data.getRiderRollCol1Desc());
		paramSource.addValue("riderRollcol2Desc",data.getRiderRollCol2Desc());
		paramSource.addValue("riderRollcol3Desc",data.getRiderRollCol3Desc());
		paramSource.addValue("riderRollcol4Desc",data.getRiderRollCol4Desc());
		paramSource.addValue("riderRollcol5Desc",data.getRiderRollCol5Desc());
		paramSource.addValue("riderRollcol6Desc",data.getRiderRollCol6Desc());
		paramSource.addValue("riderRollcol7Desc",data.getRiderRollCol7Desc());
		paramSource.addValue("riderRollcol8Desc",data.getRiderRollCol8Desc());
		
		
		paramSource.addValue("bowedRollcol1",data.isBowedRollCol1());
		paramSource.addValue("bowedRollcol2",data.isBowedRollCol2());
		paramSource.addValue("bowedRollcol3",data.isBowedRollCol3());
		
		paramSource.addValue("bowedRollcol1Desc",data.getBowedRollCol1Desc());
		paramSource.addValue("bowedRollcol2Desc",data.getBowedRollCol2Desc());
		paramSource.addValue("bowedRollcol3Desc",data.getBowedRollCol3Desc());
		
		paramSource.addValue("coreChuckscol1",data.isCoreChucksCol1());
		paramSource.addValue("coreChuckscol2",data.isCoreChucksCol2());
		paramSource.addValue("coreChuckscol3",data.isCoreChucksCol3());
		paramSource.addValue("coreChuckscol4",data.isCoreChucksCol4());
		
		paramSource.addValue("coreChuckscol1Desc",data.getCoreChucksCol1Desc());
		paramSource.addValue("coreChuckscol2Desc",data.getCoreChucksCol2Desc());
		paramSource.addValue("coreChuckscol3Desc",data.getCoreChucksCol3Desc());
		paramSource.addValue("coreChuckscol4Desc",data.getCoreChucksCol4Desc());
		
		paramSource.addValue("nipGuardcol1",data.isNipGuardCol1());
		paramSource.addValue("nipGuardcol2",data.isNipGuardCol2());
		paramSource.addValue("nipGuardcol3",data.isNipGuardCol3());
		
		
		paramSource.addValue("nipGuardcol1Desc",data.getNipGuardCol1Desc());
		paramSource.addValue("nipGuardcol2Desc",data.getNipGuardCol2Desc());
		paramSource.addValue("nipGuardcol3Desc",data.getNipGuardCol3Desc());
		
		paramSource.addValue("tableleftgatecol1",data.isTableLeftGateCol1());
		paramSource.addValue("tableleftgatecol2",data.isTableLeftGateCol2());
		
		
		paramSource.addValue("tableleftgatecol1Desc",data.getTableLeftGateCol1Desc());
		paramSource.addValue("tableleftgatecol2Desc",data.getTableLeftGateCol2Desc());
		
		
		if (data.getId() == 0) {	
			
			String sql=DatabaseUtil.getSQL("sql/insertR1Operator_pm5.sql");
			jdbcTemplate.update(sql, paramSource);
		}	
		else
		{
			paramSource.addValue("id",data.getId());
			String sql=DatabaseUtil.getSQL("sql/updateR1Operator_pm5.sql");
			jdbcTemplate.update(sql, paramSource);
		}

	}
	@Override
	public List<R1OperatorPM5> getOperatorDataList(String position,	String shift, String sdate, String edate) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSourceQRT);
		String sql = "select * from [R1Operator_PM5] where position=? AND shift=? AND date BETWEEN ? AND ? ";
		
		List<R1OperatorPM5> r1OperatorPM5datalist=null;
		try {
				r1OperatorPM5datalist=jdbcTemplate.query(sql, new Object[]{position,shift,sdate,edate},new RowMapper<R1OperatorPM5>()
				{
						
					
					@Override
					public R1OperatorPM5 mapRow(ResultSet rs ,int arg1)
							throws SQLException {
						
							R1OperatorPM5 data=new R1OperatorPM5();
						try {
							String newDate = dateFormat.format(fromuser.parse(rs.getString("date")));
							data.setId(rs.getInt("id"));
							data.setPosition(rs.getString("position"));
							data.setOperatorName(rs.getString("operatorname"));
							data.setEdate(newDate);
							data.setCrew(rs.getString("crew"));
							data.setShift(rs.getString("shift"));
							data.setMachinedown(rs.getBoolean("machinedown"));
							data.setLeadInRollCol1(rs.getBoolean("leadInRollcol1"));
							data.setLeadInRollCol2(rs.getBoolean("leadInRollcol2"));
							data.setLeadInRollCol3(rs.getBoolean("leadInRollcol3"));
							data.setLeadInRollCol4(rs.getBoolean("leadInRollcol4"));
							data.setLeadInRollCol5(rs.getBoolean("leadInRollcol5"));
							
							data.setLeadInRollCol1Desc(rs.getString("leadInRollcol1Desc"));
							data.setLeadInRollCol2Desc(rs.getString("leadInRollcol2Desc"));
							data.setLeadInRollCol3Desc(rs.getString("leadInRollcol3Desc"));
							data.setLeadInRollCol4Desc(rs.getString("leadInRollcol4Desc"));
							data.setLeadInRollCol5Desc(rs.getString("leadInRollcol5Desc"));
							
							
							data.setSectionRollCol1(rs.getBoolean("sectionRollcol1"));
							data.setSectionRollCol1Desc(rs.getString("sectionRollcol1Desc"));
							
							data.setBreakAssemblyCol1(rs.getBoolean("breakassemblycol1"));
							data.setBreakAssemblyCol2(rs.getBoolean("breakassemblycol2"));
							
							
							data.setBreakAssemblyCol1Desc(rs.getString("breakassemblycol1Desc"));
							data.setBreakAssemblyCol2Desc(rs.getString("breakassemblycol2Desc"));
							
							data.setSlittersCol1(rs.getBoolean("slitterscol1"));
							data.setSlittersCol2(rs.getBoolean("slitterscol2"));
							data.setSlittersCol3(rs.getBoolean("slitterscol3"));
							
							
							data.setSlittersCol1Desc(rs.getString("slitterscol1Desc"));
							data.setSlittersCol2Desc(rs.getString("slitterscol2Desc"));
							data.setSlittersCol3Desc(rs.getString("slitterscol3Desc"));
							
							
							data.setTrimAssemblyCol1(rs.getBoolean("trimassemblycol1"));
							data.setTrimAssemblyCol2(rs.getBoolean("trimassemblycol2"));
							data.setTrimAssemblyCol3(rs.getBoolean("trimassemblycol3"));
							data.setTrimAssemblyCol4(rs.getBoolean("trimassemblycol4"));
							
							
							data.setTrimAssemblyCol1Desc(rs.getString("trimassemblycol1Desc"));
							data.setTrimAssemblyCol2Desc(rs.getString("trimassemblycol2Desc"));
							data.setTrimAssemblyCol3Desc(rs.getString("trimassemblycol3Desc"));
							data.setTrimAssemblyCol4Desc(rs.getString("trimassemblycol4Desc"));
							
							
							data.setTensiionRollCol1(rs.getBoolean("tensiionRollcol1"));
							data.setTensiionRollCol2(rs.getBoolean("tensiionRollcol2"));
							data.setTensiionRollCol3(rs.getBoolean("tensiionRollcol3"));
							
							
							data.setTensiionRollCol1Desc(rs.getString("tensiionRollcol1Desc"));
							data.setTensiionRollCol2Desc(rs.getString("tensiionRollcol2Desc"));
							data.setTensiionRollCol3Desc(rs.getString("tensiionRollcol3Desc"));
							
							
							data.setWinderDrum1Col1(rs.getBoolean("winderDrum1col1"));
							data.setWinderDrum1Col2(rs.getBoolean("winderDrum1col2"));
							data.setWinderDrum1Col3(rs.getBoolean("winderDrum1col3"));
							data.setWinderDrum1Col4(rs.getBoolean("winderDrum1col4"));
							data.setWinderDrum1Col5(rs.getBoolean("winderDrum1col5"));
							/*data.setWinderDrum1Col6(rs.getBoolean("winderDrumcol6"));
							data.setWinderDrum1Col7(rs.getBoolean("winderDrumcol7"));*/
							
							data.setWinderDrum1Col1Desc(rs.getString("winderDrum1col1Desc"));
							data.setWinderDrum1Col2Desc(rs.getString("winderDrum1col2Desc"));
							data.setWinderDrum1Col3Desc(rs.getString("winderDrum1col3Desc"));
							data.setWinderDrum1Col4Desc(rs.getString("winderDrum1col4Desc"));
							data.setWinderDrum1Col5Desc(rs.getString("winderDrum1col5Desc"));
							/*data.setWinderDrum1Col6Desc(rs.getString("winderDrum1col6Desc"));
							data.setWinderDrum1Col7Desc(rs.getString("winderDrumcol7Desc"));*/
							
							
							data.setWinderDrum2Col1(rs.getBoolean("winderDrum2col1"));
							data.setWinderDrum2Col2(rs.getBoolean("winderDrum2col2"));
							data.setWinderDrum2Col3(rs.getBoolean("winderDrum2col3"));
							data.setWinderDrum2Col4(rs.getBoolean("winderDrum2col4"));
							data.setWinderDrum2Col5(rs.getBoolean("winderDrum2col5"));
							/*data.setWinderDrum2Col6(rs.getBoolean("winderDrumcol6"));
							data.setWinderDrum2Col7(rs.getBoolean("winderDrumcol7"));*/
							
							data.setWinderDrum2Col1Desc(rs.getString("winderDrum2col1Desc"));
							data.setWinderDrum2Col2Desc(rs.getString("winderDrum2col2Desc"));
							data.setWinderDrum2Col3Desc(rs.getString("winderDrum2col3Desc"));
							data.setWinderDrum2Col4Desc(rs.getString("winderDrum2col4Desc"));
							data.setWinderDrum2Col5Desc(rs.getString("winderDrum2col5Desc"));
							/*data.setWinderDrum2Col6Desc(rs.getString("winderDrumcol6Desc"));
							data.setWinderDrum2Col7Desc(rs.getString("winderDrumcol7Desc"));*/
							
							data.setRollEjectorCol1(rs.getBoolean("rollEjectorcol1"));
							data.setRollEjectorCol2(rs.getBoolean("rollEjectorcol2"));
							data.setRollEjectorCol3(rs.getBoolean("rollEjectorcol3"));
							
							data.setRollEjectorCol1Desc(rs.getString("rollEjectorcol1Desc"));
							data.setRollEjectorCol2Desc(rs.getString("rollEjectorcol2Desc"));
							data.setRollEjectorCol3Desc(rs.getString("rollEjectorcol3Desc"));
							
							
							data.setRiderRollCol1(rs.getBoolean("riderRollcol1"));
							data.setRiderRollCol2(rs.getBoolean("riderRollcol2"));
							data.setRiderRollCol3(rs.getBoolean("riderRollcol3"));
							data.setRiderRollCol4(rs.getBoolean("riderRollcol4"));
							data.setRiderRollCol5(rs.getBoolean("riderRollcol5"));
							data.setRiderRollCol6(rs.getBoolean("riderRollcol6"));
							data.setRiderRollCol7(rs.getBoolean("riderRollcol7"));
							data.setRiderRollCol8(rs.getBoolean("riderRollcol8"));
							
							
							data.setRiderRollCol1Desc(rs.getString("riderRollcol1Desc"));
							data.setRiderRollCol2Desc(rs.getString("riderRollCol2Desc"));
							data.setRiderRollCol3Desc(rs.getString("riderRollcol3Desc"));
							data.setRiderRollCol4Desc(rs.getString("riderRollcol4Desc"));
							data.setRiderRollCol5Desc(rs.getString("riderRollcol5Desc"));
							data.setRiderRollCol6Desc(rs.getString("riderRollcol6Desc"));
							data.setRiderRollCol7Desc(rs.getString("riderRollcol7Desc"));
							data.setRiderRollCol8Desc(rs.getString("riderRollcol8Desc"));
							
							data.setBowedRollCol1(rs.getBoolean("bowedRollcol1"));
							data.setBowedRollCol2(rs.getBoolean("bowedRollcol2"));
							data.setBowedRollCol3(rs.getBoolean("bowedRollcol3"));
							
							data.setBowedRollCol1Desc(rs.getString("bowedRollcol1Desc"));
							data.setBowedRollCol2Desc(rs.getString("bowedRollcol2Desc"));
							data.setBowedRollCol3Desc(rs.getString("bowedRollcol3Desc"));
							
							
							data.setCoreChucksCol1(rs.getBoolean("coreChuckscol1"));
							data.setCoreChucksCol2(rs.getBoolean("coreChuckscol2"));
							data.setCoreChucksCol3(rs.getBoolean("coreChuckscol3"));
							data.setCoreChucksCol4(rs.getBoolean("coreChuckscol4"));
							
							data.setCoreChucksCol1Desc(rs.getString("coreChuckscol1Desc"));
							data.setCoreChucksCol2Desc(rs.getString("coreChuckscol2Desc"));
							data.setCoreChucksCol3Desc(rs.getString("coreChuckscol3Desc"));
							data.setCoreChucksCol4Desc(rs.getString("coreChuckscol4Desc"));
							
							data.setNipGuardCol1(rs.getBoolean("nipGuardcol1"));
							data.setNipGuardCol2(rs.getBoolean("nipGuardcol2"));
							data.setNipGuardCol3(rs.getBoolean("nipGuardcol3"));
							
							
							data.setNipGuardCol1Desc(rs.getString("nipGuardcol1Desc"));
							data.setNipGuardCol2Desc(rs.getString("nipGuardcol2Desc"));
							data.setNipGuardCol3Desc(rs.getString("nipGuardcol3Desc"));
							
							data.setTableLeftGateCol1(rs.getBoolean("tableleftgatecol1"));
							data.setTableLeftGateCol2(rs.getBoolean("tableleftgatecol2"));
							
							data.setTableLeftGateCol1Desc(rs.getString("tableleftgatecol1Desc"));
							data.setTableLeftGateCol2Desc(rs.getString("tableleftgatecol2Desc"));
							 
						} catch (Exception e) {
							
						}
						return data;
					}
				});
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return r1OperatorPM5datalist;
	}

	@Override
	public List<R1OperatorPM5> getOperatorDataListForBothShift(String position, String sdate, String edate) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSourceQRT);
		String sql = "select * from [R1Operator_PM5] where position=? AND date BETWEEN ? AND ? order by date";
		
		List<R1OperatorPM5> r1OperatorPM5datalist=null;
		try {
				r1OperatorPM5datalist=jdbcTemplate.query(sql, new Object[]{position,sdate,edate},new RowMapper<R1OperatorPM5>()
				{
						
					
					@Override
					public R1OperatorPM5 mapRow(ResultSet rs ,int arg1)
							throws SQLException {
						
							R1OperatorPM5 data=new R1OperatorPM5();
						try {
							String newDate = dateFormat.format(fromuser.parse(rs.getString("date")));
							data.setId(rs.getInt("id"));
							data.setPosition(rs.getString("position"));
							data.setOperatorName(rs.getString("operatorname"));
							data.setEdate(newDate);
							data.setCrew(rs.getString("crew"));
							data.setShift(rs.getString("shift"));
							data.setMachinedown(rs.getBoolean("machinedown"));
							data.setLeadInRollCol1(rs.getBoolean("leadInRollcol1"));
							data.setLeadInRollCol2(rs.getBoolean("leadInRollcol2"));
							data.setLeadInRollCol3(rs.getBoolean("leadInRollcol3"));
							data.setLeadInRollCol4(rs.getBoolean("leadInRollcol4"));
							data.setLeadInRollCol5(rs.getBoolean("leadInRollcol5"));
							
							data.setLeadInRollCol1Desc(rs.getString("leadInRollcol1Desc"));
							data.setLeadInRollCol2Desc(rs.getString("leadInRollcol2Desc"));
							data.setLeadInRollCol3Desc(rs.getString("leadInRollcol3Desc"));
							data.setLeadInRollCol4Desc(rs.getString("leadInRollcol4Desc"));
							data.setLeadInRollCol5Desc(rs.getString("leadInRollcol5Desc"));
							
							
							data.setSectionRollCol1(rs.getBoolean("sectionRollcol1"));
							data.setSectionRollCol1Desc(rs.getString("sectionRollcol1Desc"));
							
							data.setBreakAssemblyCol1(rs.getBoolean("breakassemblycol1"));
							data.setBreakAssemblyCol2(rs.getBoolean("breakassemblycol2"));
							
							
							data.setBreakAssemblyCol1Desc(rs.getString("breakassemblycol1Desc"));
							data.setBreakAssemblyCol2Desc(rs.getString("breakassemblycol2Desc"));
							
							data.setSlittersCol1(rs.getBoolean("slitterscol1"));
							data.setSlittersCol2(rs.getBoolean("slitterscol2"));
							data.setSlittersCol3(rs.getBoolean("slitterscol3"));
							
							
							data.setSlittersCol1Desc(rs.getString("slitterscol1Desc"));
							data.setSlittersCol2Desc(rs.getString("slitterscol2Desc"));
							data.setSlittersCol3Desc(rs.getString("slitterscol3Desc"));
							
							
							data.setTrimAssemblyCol1(rs.getBoolean("trimassemblycol1"));
							data.setTrimAssemblyCol2(rs.getBoolean("trimassemblycol2"));
							data.setTrimAssemblyCol3(rs.getBoolean("trimassemblycol3"));
							data.setTrimAssemblyCol4(rs.getBoolean("trimassemblycol4"));
							
							
							data.setTrimAssemblyCol1Desc(rs.getString("trimassemblycol1Desc"));
							data.setTrimAssemblyCol2Desc(rs.getString("trimassemblycol2Desc"));
							data.setTrimAssemblyCol3Desc(rs.getString("trimassemblycol3Desc"));
							data.setTrimAssemblyCol4Desc(rs.getString("trimassemblycol4Desc"));
							
							
							data.setTensiionRollCol1(rs.getBoolean("tensiionRollcol1"));
							data.setTensiionRollCol2(rs.getBoolean("tensiionRollcol2"));
							data.setTensiionRollCol3(rs.getBoolean("tensiionRollcol3"));
							
							
							data.setTensiionRollCol1Desc(rs.getString("tensiionRollcol1Desc"));
							data.setTensiionRollCol2Desc(rs.getString("tensiionRollcol2Desc"));
							data.setTensiionRollCol3Desc(rs.getString("tensiionRollcol3Desc"));
							
							
							data.setWinderDrum1Col1(rs.getBoolean("winderDrum1col1"));
							data.setWinderDrum1Col2(rs.getBoolean("winderDrum1col2"));
							data.setWinderDrum1Col3(rs.getBoolean("winderDrum1col3"));
							data.setWinderDrum1Col4(rs.getBoolean("winderDrum1col4"));
							data.setWinderDrum1Col5(rs.getBoolean("winderDrum1col5"));
							/*data.setWinderDrum1Col6(rs.getBoolean("winderDrumcol6"));
							data.setWinderDrum1Col7(rs.getBoolean("winderDrumcol7"));*/
							
							data.setWinderDrum1Col1Desc(rs.getString("winderDrum1col1Desc"));
							data.setWinderDrum1Col2Desc(rs.getString("winderDrum1col2Desc"));
							data.setWinderDrum1Col3Desc(rs.getString("winderDrum1col3Desc"));
							data.setWinderDrum1Col4Desc(rs.getString("winderDrum1col4Desc"));
							data.setWinderDrum1Col5Desc(rs.getString("winderDrum1col5Desc"));
							/*data.setWinderDrum1Col6Desc(rs.getString("winderDrum1col6Desc"));
							data.setWinderDrum1Col7Desc(rs.getString("winderDrumcol7Desc"));*/
							
							
							data.setWinderDrum2Col1(rs.getBoolean("winderDrum2col1"));
							data.setWinderDrum2Col2(rs.getBoolean("winderDrum2col2"));
							data.setWinderDrum2Col3(rs.getBoolean("winderDrum2col3"));
							data.setWinderDrum2Col4(rs.getBoolean("winderDrum2col4"));
							data.setWinderDrum2Col5(rs.getBoolean("winderDrum2col5"));
							/*data.setWinderDrum2Col6(rs.getBoolean("winderDrumcol6"));
							data.setWinderDrum2Col7(rs.getBoolean("winderDrumcol7"));*/
							
							data.setWinderDrum2Col1Desc(rs.getString("winderDrum2col1Desc"));
							data.setWinderDrum2Col2Desc(rs.getString("winderDrum2col2Desc"));
							data.setWinderDrum2Col3Desc(rs.getString("winderDrum2col3Desc"));
							data.setWinderDrum2Col4Desc(rs.getString("winderDrum2col4Desc"));
							data.setWinderDrum2Col5Desc(rs.getString("winderDrum2col5Desc"));
							/*data.setWinderDrum2Col6Desc(rs.getString("winderDrumcol6Desc"));
							data.setWinderDrum2Col7Desc(rs.getString("winderDrumcol7Desc"));*/
							
							data.setRollEjectorCol1(rs.getBoolean("rollEjectorcol1"));
							data.setRollEjectorCol2(rs.getBoolean("rollEjectorcol2"));
							data.setRollEjectorCol3(rs.getBoolean("rollEjectorcol3"));
							
							data.setRollEjectorCol1Desc(rs.getString("rollEjectorcol1Desc"));
							data.setRollEjectorCol2Desc(rs.getString("rollEjectorcol2Desc"));
							data.setRollEjectorCol3Desc(rs.getString("rollEjectorcol3Desc"));
							
							
							data.setRiderRollCol1(rs.getBoolean("riderRollcol1"));
							data.setRiderRollCol2(rs.getBoolean("riderRollcol2"));
							data.setRiderRollCol3(rs.getBoolean("riderRollcol3"));
							data.setRiderRollCol4(rs.getBoolean("riderRollcol4"));
							data.setRiderRollCol5(rs.getBoolean("riderRollcol5"));
							data.setRiderRollCol6(rs.getBoolean("riderRollcol6"));
							data.setRiderRollCol7(rs.getBoolean("riderRollcol7"));
							data.setRiderRollCol8(rs.getBoolean("riderRollcol8"));
							
							
							data.setRiderRollCol1Desc(rs.getString("riderRollcol1Desc"));
							data.setRiderRollCol2Desc(rs.getString("riderRollCol2Desc"));
							data.setRiderRollCol3Desc(rs.getString("riderRollcol3Desc"));
							data.setRiderRollCol4Desc(rs.getString("riderRollcol4Desc"));
							data.setRiderRollCol5Desc(rs.getString("riderRollcol5Desc"));
							data.setRiderRollCol6Desc(rs.getString("riderRollcol6Desc"));
							data.setRiderRollCol7Desc(rs.getString("riderRollcol7Desc"));
							data.setRiderRollCol8Desc(rs.getString("riderRollcol8Desc"));
							
							data.setBowedRollCol1(rs.getBoolean("bowedRollcol1"));
							data.setBowedRollCol2(rs.getBoolean("bowedRollcol2"));
							data.setBowedRollCol3(rs.getBoolean("bowedRollcol3"));
							
							data.setBowedRollCol1Desc(rs.getString("bowedRollcol1Desc"));
							data.setBowedRollCol2Desc(rs.getString("bowedRollcol2Desc"));
							data.setBowedRollCol3Desc(rs.getString("bowedRollcol3Desc"));
							
							
							data.setCoreChucksCol1(rs.getBoolean("coreChuckscol1"));
							data.setCoreChucksCol2(rs.getBoolean("coreChuckscol2"));
							data.setCoreChucksCol3(rs.getBoolean("coreChuckscol3"));
							data.setCoreChucksCol4(rs.getBoolean("coreChuckscol4"));
							
							data.setCoreChucksCol1Desc(rs.getString("coreChuckscol1Desc"));
							data.setCoreChucksCol2Desc(rs.getString("coreChuckscol2Desc"));
							data.setCoreChucksCol3Desc(rs.getString("coreChuckscol3Desc"));
							data.setCoreChucksCol4Desc(rs.getString("coreChuckscol4Desc"));
							
							data.setNipGuardCol1(rs.getBoolean("nipGuardcol1"));
							data.setNipGuardCol2(rs.getBoolean("nipGuardcol2"));
							data.setNipGuardCol3(rs.getBoolean("nipGuardcol3"));
							
							
							data.setNipGuardCol1Desc(rs.getString("nipGuardcol1Desc"));
							data.setNipGuardCol2Desc(rs.getString("nipGuardcol2Desc"));
							data.setNipGuardCol3Desc(rs.getString("nipGuardcol3Desc"));
							
							data.setTableLeftGateCol1(rs.getBoolean("tableleftgatecol1"));
							data.setTableLeftGateCol2(rs.getBoolean("tableleftgatecol2"));
							
							data.setTableLeftGateCol1Desc(rs.getString("tableleftgatecol1Desc"));
							data.setTableLeftGateCol2Desc(rs.getString("tableleftgatecol2Desc"));
							 
						} catch (Exception e) {
							
						}
						return data;
					}
				});
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return r1OperatorPM5datalist;
	}

	
	@Override
	public R1OperatorPM5 getOperatorData(String position, String shift,	String date, String crew) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSourceQRT);
		String sql = "select * from [R1Operator_PM5] where [position]=? AND [date]=? AND [shift] = ? ";

		R1OperatorPM5 r1OperatorPM5data=null;
		try {
				r1OperatorPM5data=jdbcTemplate.queryForObject(sql, new Object[]{position, date, shift },new RowMapper<R1OperatorPM5>()
				{
						
					
					@Override
					public R1OperatorPM5 mapRow(ResultSet rs ,int arg1)
							throws SQLException {
						
							R1OperatorPM5 data=new R1OperatorPM5();
						try {
							String newDate = dateFormat.format(fromuser.parse(rs.getString("date")));
							data.setId(rs.getInt("id"));
							data.setPosition(rs.getString("position"));
							data.setOperatorName(rs.getString("operatorname"));
							data.setEdate(newDate);
							data.setCrew(rs.getString("crew"));
							data.setShift(rs.getString("shift"));
							data.setMachinedown(rs.getBoolean("machinedown"));
							data.setLeadInRollCol1(rs.getBoolean("leadInRollcol1"));
							data.setLeadInRollCol2(rs.getBoolean("leadInRollcol2"));
							data.setLeadInRollCol3(rs.getBoolean("leadInRollcol3"));
							data.setLeadInRollCol4(rs.getBoolean("leadInRollcol4"));
							data.setLeadInRollCol5(rs.getBoolean("leadInRollcol5"));
							
							data.setLeadInRollCol1Desc(rs.getString("leadInRollcol1Desc"));
							data.setLeadInRollCol2Desc(rs.getString("leadInRollcol2Desc"));
							data.setLeadInRollCol3Desc(rs.getString("leadInRollcol3Desc"));
							data.setLeadInRollCol4Desc(rs.getString("leadInRollcol4Desc"));
							data.setLeadInRollCol5Desc(rs.getString("leadInRollcol5Desc"));
							
							
							data.setSectionRollCol1(rs.getBoolean("sectionRollcol1"));
							data.setSectionRollCol1Desc(rs.getString("sectionRollcol1Desc"));
							
							data.setBreakAssemblyCol1(rs.getBoolean("breakassemblycol1"));
							data.setBreakAssemblyCol2(rs.getBoolean("breakassemblycol2"));
							
							
							data.setBreakAssemblyCol1Desc(rs.getString("breakassemblycol1Desc"));
							data.setBreakAssemblyCol2Desc(rs.getString("breakassemblycol2Desc"));
							
							data.setSlittersCol1(rs.getBoolean("slitterscol1"));
							data.setSlittersCol2(rs.getBoolean("slitterscol2"));
							data.setSlittersCol3(rs.getBoolean("slitterscol3"));
							
							
							data.setSlittersCol1Desc(rs.getString("slitterscol1Desc"));
							data.setSlittersCol2Desc(rs.getString("slitterscol2Desc"));
							data.setSlittersCol3Desc(rs.getString("slitterscol3Desc"));
							
							
							data.setTrimAssemblyCol1(rs.getBoolean("trimassemblycol1"));
							data.setTrimAssemblyCol2(rs.getBoolean("trimassemblycol2"));
							data.setTrimAssemblyCol3(rs.getBoolean("trimassemblycol3"));
							data.setTrimAssemblyCol4(rs.getBoolean("trimassemblycol4"));
							
							
							data.setTrimAssemblyCol1Desc(rs.getString("trimassemblycol1Desc"));
							data.setTrimAssemblyCol2Desc(rs.getString("trimassemblycol2Desc"));
							data.setTrimAssemblyCol3Desc(rs.getString("trimassemblycol3Desc"));
							data.setTrimAssemblyCol4Desc(rs.getString("trimassemblycol4Desc"));
							
							
							data.setTensiionRollCol1(rs.getBoolean("tensiionRollcol1"));
							data.setTensiionRollCol2(rs.getBoolean("tensiionRollcol2"));
							data.setTensiionRollCol3(rs.getBoolean("tensiionRollcol3"));
							
							
							data.setTensiionRollCol1Desc(rs.getString("tensiionRollcol1Desc"));
							data.setTensiionRollCol2Desc(rs.getString("tensiionRollcol2Desc"));
							data.setTensiionRollCol3Desc(rs.getString("tensiionRollcol3Desc"));
							
							
							data.setWinderDrum1Col1(rs.getBoolean("winderDrum1col1"));
							data.setWinderDrum1Col2(rs.getBoolean("winderDrum1col2"));
							data.setWinderDrum1Col3(rs.getBoolean("winderDrum1col3"));
							data.setWinderDrum1Col4(rs.getBoolean("winderDrum1col4"));
							data.setWinderDrum1Col5(rs.getBoolean("winderDrum1col5"));
							/*data.setWinderDrum1Col6(rs.getBoolean("winderDrumcol6"));
							data.setWinderDrum1Col7(rs.getBoolean("winderDrumcol7"));*/
							
							data.setWinderDrum1Col1Desc(rs.getString("winderDrum1col1Desc"));
							data.setWinderDrum1Col2Desc(rs.getString("winderDrum1col2Desc"));
							data.setWinderDrum1Col3Desc(rs.getString("winderDrum1col3Desc"));
							data.setWinderDrum1Col4Desc(rs.getString("winderDrum1col4Desc"));
							data.setWinderDrum1Col5Desc(rs.getString("winderDrum1col5Desc"));
							/*data.setWinderDrum1Col6Desc(rs.getString("winderDrum1col6Desc"));
							data.setWinderDrum1Col7Desc(rs.getString("winderDrumcol7Desc"));*/
							
							
							data.setWinderDrum2Col1(rs.getBoolean("winderDrum2col1"));
							data.setWinderDrum2Col2(rs.getBoolean("winderDrum2col2"));
							data.setWinderDrum2Col3(rs.getBoolean("winderDrum2col3"));
							data.setWinderDrum2Col4(rs.getBoolean("winderDrum2col4"));
							data.setWinderDrum2Col5(rs.getBoolean("winderDrum2col5"));
							/*data.setWinderDrum2Col6(rs.getBoolean("winderDrumcol6"));
							data.setWinderDrum2Col7(rs.getBoolean("winderDrumcol7"));*/
							
							data.setWinderDrum2Col1Desc(rs.getString("winderDrum2col1Desc"));
							data.setWinderDrum2Col2Desc(rs.getString("winderDrum2col2Desc"));
							data.setWinderDrum2Col3Desc(rs.getString("winderDrum2col3Desc"));
							data.setWinderDrum2Col4Desc(rs.getString("winderDrum2col4Desc"));
							data.setWinderDrum2Col5Desc(rs.getString("winderDrum2col5Desc"));
							/*data.setWinderDrum2Col6Desc(rs.getString("winderDrumcol6Desc"));
							data.setWinderDrum2Col7Desc(rs.getString("winderDrumcol7Desc"));*/
							
							data.setRollEjectorCol1(rs.getBoolean("rollEjectorCol1"));
							data.setRollEjectorCol2(rs.getBoolean("rollEjectorCol2"));
							data.setRollEjectorCol3(rs.getBoolean("rollEjectorCol3"));
							
							data.setRollEjectorCol1Desc(rs.getString("rollEjectorCol1Desc"));
							data.setRollEjectorCol2Desc(rs.getString("rollEjectorCol2Desc"));
							data.setRollEjectorCol3Desc(rs.getString("rollEjectorCol3Desc"));
							
							
							data.setRiderRollCol1(rs.getBoolean("riderRollCol1"));
							data.setRiderRollCol2(rs.getBoolean("riderRollCol2"));
							data.setRiderRollCol3(rs.getBoolean("riderRollCol3"));
							data.setRiderRollCol4(rs.getBoolean("riderRollCol4"));
							data.setRiderRollCol5(rs.getBoolean("riderRollCol5"));
							data.setRiderRollCol6(rs.getBoolean("riderRollCol6"));
							data.setRiderRollCol7(rs.getBoolean("riderRollCol7"));
							data.setRiderRollCol8(rs.getBoolean("riderRollCol8"));
							
							
							data.setRiderRollCol1Desc(rs.getString("riderRollCol1Desc"));
							data.setRiderRollCol2Desc(rs.getString("riderRollCol2Desc"));
							data.setRiderRollCol3Desc(rs.getString("riderRollCol3Desc"));
							data.setRiderRollCol4Desc(rs.getString("riderRollCol4Desc"));
							data.setRiderRollCol5Desc(rs.getString("riderRollCol5Desc"));
							data.setRiderRollCol6Desc(rs.getString("riderRollCol6Desc"));
							data.setRiderRollCol7Desc(rs.getString("riderRollCol7Desc"));
							data.setRiderRollCol8Desc(rs.getString("riderRollCol8Desc"));
							
							data.setBowedRollCol1(rs.getBoolean("bowedRollCol1"));
							data.setBowedRollCol2(rs.getBoolean("bowedRollCol2"));
							data.setBowedRollCol3(rs.getBoolean("bowedRollCol3"));
							
							data.setBowedRollCol1Desc(rs.getString("bowedRollCol1Desc"));
							data.setBowedRollCol2Desc(rs.getString("bowedRollCol2Desc"));
							data.setBowedRollCol3Desc(rs.getString("bowedRollCol3Desc"));
							
							
							data.setCoreChucksCol1(rs.getBoolean("coreChuckscol1"));
							data.setCoreChucksCol2(rs.getBoolean("coreChuckscol2"));
							data.setCoreChucksCol3(rs.getBoolean("coreChuckscol3"));
							data.setCoreChucksCol4(rs.getBoolean("coreChuckscol4"));
							
							data.setCoreChucksCol1Desc(rs.getString("coreChuckscol1Desc"));
							data.setCoreChucksCol2Desc(rs.getString("coreChuckscol2Desc"));
							data.setCoreChucksCol3Desc(rs.getString("coreChuckscol3Desc"));
							data.setCoreChucksCol4Desc(rs.getString("coreChuckscol4Desc"));
							
							data.setNipGuardCol1(rs.getBoolean("nipGuardcol1"));
							data.setNipGuardCol2(rs.getBoolean("nipGuardcol2"));
							data.setNipGuardCol3(rs.getBoolean("nipGuardcol3"));
							
							
							data.setNipGuardCol1Desc(rs.getString("nipGuardcol1Desc"));
							data.setNipGuardCol2Desc(rs.getString("nipGuardcol2Desc"));
							data.setNipGuardCol3Desc(rs.getString("nipGuardcol3Desc"));
							
							data.setTableLeftGateCol1(rs.getBoolean("tableleftgatecol1"));
							data.setTableLeftGateCol2(rs.getBoolean("tableleftgatecol2"));
							
							data.setTableLeftGateCol1Desc(rs.getString("tableleftgatecol1Desc"));
							data.setTableLeftGateCol2Desc(rs.getString("tableleftgatecol2Desc"));
							 
						} catch (Exception e) {
							
						}
						return data;
					}
				
					
				});
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return r1OperatorPM5data;
	}
	/* (non-Javadoc)
	 * @see com.st.oBcc1pm5.dao.LeadOperatorPM5Dao#getDataCountDatePercentage(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public long getDataCountDatePercentage(String position, String sdate,String edate,String shift) throws ParseException {
		
		SimpleDateFormat format=new SimpleDateFormat("MM-dd-yyyy");
		
		List<R1OperatorPM5> daydata=null, nightdata=null;
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
			for(R1OperatorPM5 data:daydata)
			{
				if(data.isMachinedown()==false){
				if(data.isLeadInRollCol1()== false||data.isLeadInRollCol1() == true){count++;}
				if(data.isLeadInRollCol2()== false||data.isLeadInRollCol2() == true){count++;}
				if(data.isLeadInRollCol3()== false||data.isLeadInRollCol3() == true){count++;}
				if(data.isLeadInRollCol4()== false||data.isLeadInRollCol4() == true){count++;}
				if(data.isLeadInRollCol5()== false||data.isLeadInRollCol5() == true){count++;}
				if(data.isSectionRollCol1()== false||data.isSectionRollCol1() == true){count++;}
				if(data.isBreakAssemblyCol1()== false||data.isBreakAssemblyCol1() == true){count++;}
				if(data.isBreakAssemblyCol2()== false||data.isBreakAssemblyCol2() == true){count++;}
				if(data.isSlittersCol1()== false||data.isSlittersCol1() == true){count++;}
				if(data.isSlittersCol2()== false||data.isSlittersCol2() == true){count++;}
				if(data.isSlittersCol3()== false||data.isSlittersCol3() == true){count++;}
				if(data.isTrimAssemblyCol1()== false||data.isTrimAssemblyCol1() == true){count++;}
				if(data.isTrimAssemblyCol2()== false||data.isTrimAssemblyCol2() == true){count++;}
				if(data.isTrimAssemblyCol3()== false||data.isTrimAssemblyCol3() == true){count++;}
				if(data.isTrimAssemblyCol4()== false||data.isTrimAssemblyCol4() == true){count++;}
				if(data.isTensiionRollCol1()== false||data.isTensiionRollCol1() == true){count++;}
				if(data.isTensiionRollCol2()== false||data.isTensiionRollCol2() == true){count++;}
				if(data.isTensiionRollCol3()== false||data.isTensiionRollCol3() == true){count++;}
				if(data.isWinderDrum1Col1()== false||data.isWinderDrum1Col1() == true){count++;}
				if(data.isWinderDrum1Col2()== false||data.isWinderDrum1Col2() == true){count++;}
				if(data.isWinderDrum1Col3()== false||data.isWinderDrum1Col3() == true){count++;}
				if(data.isWinderDrum1Col4()== false||data.isWinderDrum1Col4() == true){count++;}
				if(data.isWinderDrum1Col5()== false||data.isWinderDrum1Col5() == true){count++;}
				if(data.isWinderDrum2Col1()== false||data.isWinderDrum2Col1() == true){count++;}
				if(data.isWinderDrum2Col2()== false||data.isWinderDrum2Col2() == true){count++;}
				if(data.isWinderDrum2Col3()== false||data.isWinderDrum2Col3() == true){count++;}
				if(data.isWinderDrum2Col4()== false||data.isWinderDrum2Col4() == true){count++;}
				if(data.isWinderDrum2Col5()== false||data.isWinderDrum2Col5() == true){count++;}
				if(data.isRollEjectorCol1()== false||data.isRollEjectorCol1() == true){count++;}
				if(data.isRollEjectorCol2()== false||data.isRollEjectorCol2() == true){count++;}
				if(data.isRollEjectorCol3()== false||data.isRollEjectorCol3() == true){count++;}
				if(data.isRiderRollCol1()== false||data.isRiderRollCol1() == true){count++;}
				if(data.isRiderRollCol2()== false||data.isRiderRollCol2() == true){count++;}
				if(data.isRiderRollCol3()== false||data.isRiderRollCol3() == true){count++;}
				if(data.isRiderRollCol4()== false||data.isRiderRollCol4() == true){count++;}
				if(data.isRiderRollCol5()== false||data.isRiderRollCol5() == true){count++;}
				if(data.isRiderRollCol6()== false||data.isRiderRollCol6() == true){count++;}
				if(data.isRiderRollCol7()== false||data.isRiderRollCol7() == true){count++;}
				if(data.isRiderRollCol8()== false||data.isRiderRollCol8() == true){count++;}
				if(data.isBowedRollCol1()== false||data.isBowedRollCol1() == true){count++;}
				if(data.isBowedRollCol2()== false||data.isBowedRollCol2() == true){count++;}
				if(data.isBowedRollCol3()== false||data.isBowedRollCol3() == true){count++;}
				if(data.isCoreChucksCol1()== false||data.isCoreChucksCol1() == true){count++;}
				if(data.isCoreChucksCol2()== false||data.isCoreChucksCol2() == true){count++;}
				if(data.isCoreChucksCol3()== false||data.isCoreChucksCol3() == true){count++;}
				if(data.isCoreChucksCol4()== false||data.isCoreChucksCol4() == true){count++;}
				if(data.isNipGuardCol1()== false||data.isNipGuardCol1() == true){count++;}
				if(data.isNipGuardCol2()== false||data.isNipGuardCol2() == true){count++;}
				if(data.isNipGuardCol3()== false||data.isNipGuardCol3() == true){count++;}
				if(data.isTableLeftGateCol1()== false||data.isTableLeftGateCol1() == true){count++;}
				if(data.isTableLeftGateCol2()== false||data.isTableLeftGateCol2() == true){count++;}
				}else count=6;
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
		 for(R1OperatorPM5 data:nightdata)
			{
			 if(data.isMachinedown()==false){
			 if(data.isLeadInRollCol1()== false||data.isLeadInRollCol1() == true){count++;}
			 if(data.isLeadInRollCol2()== false||data.isLeadInRollCol2() == true){count++;}
			 if(data.isLeadInRollCol3()== false||data.isLeadInRollCol3() == true){count++;}
			 if(data.isLeadInRollCol4()== false||data.isLeadInRollCol4() == true){count++;}
			 if(data.isLeadInRollCol5()== false||data.isLeadInRollCol5() == true){count++;}
			 if(data.isSectionRollCol1()== false||data.isSectionRollCol1() == true){count++;}
			 if(data.isBreakAssemblyCol1()== false||data.isBreakAssemblyCol1() == true){count++;}
			 if(data.isBreakAssemblyCol2()== false||data.isBreakAssemblyCol2() == true){count++;}
			 if(data.isSlittersCol1()== false||data.isSlittersCol1() == true){count++;}
			 if(data.isSlittersCol2()== false||data.isSlittersCol2() == true){count++;}
			 if(data.isSlittersCol3()== false||data.isSlittersCol3() == true){count++;}
			 if(data.isTrimAssemblyCol1()== false||data.isTrimAssemblyCol1() == true){count++;}
			 if(data.isTrimAssemblyCol2()== false||data.isTrimAssemblyCol2() == true){count++;}
			 if(data.isTrimAssemblyCol3()== false||data.isTrimAssemblyCol3() == true){count++;}
			 if(data.isTrimAssemblyCol4()== false||data.isTrimAssemblyCol4() == true){count++;}
			 if(data.isTensiionRollCol1()== false||data.isTensiionRollCol1() == true){count++;}
			 if(data.isTensiionRollCol2()== false||data.isTensiionRollCol2() == true){count++;}
			 if(data.isTensiionRollCol3()== false||data.isTensiionRollCol3() == true){count++;}
			 if(data.isWinderDrum1Col1()== false||data.isWinderDrum1Col1() == true){count++;}
			 if(data.isWinderDrum1Col2()== false||data.isWinderDrum1Col2() == true){count++;}
			 if(data.isWinderDrum1Col3()== false||data.isWinderDrum1Col3() == true){count++;}
			 if(data.isWinderDrum1Col4()== false||data.isWinderDrum1Col4() == true){count++;}
			 if(data.isWinderDrum1Col5()== false||data.isWinderDrum1Col5() == true){count++;}
			 if(data.isWinderDrum2Col1()== false||data.isWinderDrum2Col1() == true){count++;}
			 if(data.isWinderDrum2Col2()== false||data.isWinderDrum2Col2() == true){count++;}
			 if(data.isWinderDrum2Col3()== false||data.isWinderDrum2Col3() == true){count++;}
			 if(data.isWinderDrum2Col4()== false||data.isWinderDrum2Col4() == true){count++;}
			 if(data.isWinderDrum2Col5()== false||data.isWinderDrum2Col5() == true){count++;}
			 if(data.isRollEjectorCol1()== false||data.isRollEjectorCol1() == true){count++;}
			 if(data.isRollEjectorCol2()== false||data.isRollEjectorCol2() == true){count++;}
			 if(data.isRollEjectorCol3()== false||data.isRollEjectorCol3() == true){count++;}
			 if(data.isRiderRollCol1()== false||data.isRiderRollCol1() == true){count++;}
			 if(data.isRiderRollCol2()== false||data.isRiderRollCol2() == true){count++;}
			 if(data.isRiderRollCol3()== false||data.isRiderRollCol3() == true){count++;}
			 if(data.isRiderRollCol4()== false||data.isRiderRollCol4() == true){count++;}
			 if(data.isRiderRollCol5()== false||data.isRiderRollCol5() == true){count++;}
			 if(data.isRiderRollCol6()== false||data.isRiderRollCol6() == true){count++;}
			 if(data.isRiderRollCol7()== false||data.isRiderRollCol7() == true){count++;}
			 if(data.isRiderRollCol8()== false||data.isRiderRollCol8() == true){count++;}
			 if(data.isBowedRollCol1()== false||data.isBowedRollCol1() == true){count++;}
			 if(data.isBowedRollCol2()== false||data.isBowedRollCol2() == true){count++;}
			 if(data.isBowedRollCol3()== false||data.isBowedRollCol3() == true){count++;}
			 if(data.isCoreChucksCol1()== false||data.isCoreChucksCol1() == true){count++;}
			 if(data.isCoreChucksCol2()== false||data.isCoreChucksCol2() == true){count++;}
			 if(data.isCoreChucksCol3()== false||data.isCoreChucksCol3() == true){count++;}
			 if(data.isCoreChucksCol4()== false||data.isCoreChucksCol4() == true){count++;}
			 if(data.isNipGuardCol1()== false||data.isNipGuardCol1() == true){count++;}
			 if(data.isNipGuardCol2()== false||data.isNipGuardCol2() == true){count++;}
			 if(data.isNipGuardCol3()== false||data.isNipGuardCol3() == true){count++;}
			 if(data.isTableLeftGateCol1()== false||data.isTableLeftGateCol1() == true){count++;}
			 if(data.isTableLeftGateCol2()== false||data.isTableLeftGateCol2() == true){count++;}
			 }else count=6;
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
	if(no==0)
		no=1;
		percentage=(daypercent+nightpercent)/no;
	}
		return percentage;
	}
}

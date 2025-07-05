/**
 *Oct 21, 2019
 *LeadOperatorPM5DaoImp.java
 * TODO
 *com.st.obccPM5.dao
 *LeadOperatorPM5DaoImp.java
 *Roshan Lal Tailor
 */
package com.st.obccPM5.dao;

import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
import com.st.obccPM5.model.LeadOperatorPM5;

/**
 * @author roshan
 *
 */
@Repository
public class LeadOperatorPM5DaoImp implements LeadOperatorPM5Dao {
	
	@Autowired
	@Qualifier("dataSourceOBCC")
	private DataSource dataSourceQRT;
	
	private SimpleDateFormat dateFormat=new SimpleDateFormat("MM-dd-yyyy");
	private SimpleDateFormat fromuser=new SimpleDateFormat("yyyy-MM-dd");

	
	@Override
	public void saveorUpdate(LeadOperatorPM5 data) {
		
		NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(dataSourceQRT);
	 	MapSqlParameterSource paramSource=new MapSqlParameterSource();
		
		paramSource.addValue("position",data.getPosition());
		paramSource.addValue("operatorName",data.getOperatorName());
		paramSource.addValue("date",data.getEdate());
		paramSource.addValue("crew",data.getCrew());
		paramSource.addValue("shift",data.getShift());
		paramSource.addValue("machinedown",data.isMachinedown());
		
		paramSource.addValue("formatingsectioncol1",data.getFormatingsectioncol1());
		paramSource.addValue("formatingsectioncol2",data.getFormatingsectioncol2());
		paramSource.addValue("formatingsectioncol3",data.getFormatingsectioncol3());
		paramSource.addValue("formatingsectioncol4",data.getFormatingsectioncol4());
		paramSource.addValue("formatingsectioncol5",data.getFormatingsectioncol5());
		paramSource.addValue("formatingsectioncol6",data.getFormatingsectioncol6());
		paramSource.addValue("formatingsectioncol7",data.getFormatingsectioncol7());
		
		paramSource.addValue("couchrollcol1",data.getCouchrollcol1());
		paramSource.addValue("couchrollcol2",data.getCouchrollcol2());
		paramSource.addValue("couchrollcol3",data.getCouchrollcol3());
		paramSource.addValue("couchrollcol4",data.getCouchrollcol4());
		paramSource.addValue("couchrollcol5",data.getCouchrollcol5());
		paramSource.addValue("couchrollcol6",data.isCouchrollcol6());
		paramSource.addValue("couchrollcol7",data.isCouchrollcol7());
		
		
		
		paramSource.addValue("picupfeltguidecol1",data.getPicupfeltguidecol1());
		paramSource.addValue("picupfeltguidecol2",data.getPicupfeltguidecol2());
		paramSource.addValue("picupfeltguidecol3",data.getPicupfeltguidecol3());
		paramSource.addValue("picupfeltguidecol4",data.getPicupfeltguidecol4());

		
		paramSource.addValue("suctionpressurerollcol1",data.getSuctionpressurerollcol1());
		paramSource.addValue("suctionpressurerollcol2",data.getSuctionpressurerollcol2());
		paramSource.addValue("suctionpressurerollcol3",data.getSuctionpressurerollcol3());
		paramSource.addValue("suctionpressurerollcol4",data.getSuctionpressurerollcol4());
		paramSource.addValue("suctionpressurerollcol5",data.getSuctionpressurerollcol5());

		
		paramSource.addValue("yankeedryerCol1",data.getYankeedryerCol1());
		paramSource.addValue("yankeedryerCol2",data.getYankeedryerCol2());
		paramSource.addValue("yankeedryerCol3",data.getYankeedryerCol3());
		paramSource.addValue("yankeedryerCol4",data.getYankeedryerCol4());

		paramSource.addValue("pressfeltareacol1",data.getPressfeltareacol1());
		paramSource.addValue("pressfeltareacol2",data.isPressfeltareacol2());
		paramSource.addValue("pressfeltareacol3",data.getPressfeltareacol3());
		paramSource.addValue("pressfeltareacol4",data.getPressfeltareacol4());
		paramSource.addValue("pressfeltareacol5",data.getPressfeltareacol5());
		paramSource.addValue("pressfeltareacol6",data.getPressfeltareacol6());
		paramSource.addValue("pressfeltareacol7",data.getPressfeltareacol7());
		paramSource.addValue("pressfeltareacol8",data.getPressfeltareacol8());

		
		paramSource.addValue("lubeoilsystemcol1",data.getLubeoilsystemcol1());
		paramSource.addValue("lubeoilsystemcol2",data.getLubeoilsystemcol2());
		paramSource.addValue("lubeoilsystemcol3",data.getLubeoilsystemcol3());
		paramSource.addValue("lubeoilsystemcol4",data.getLubeoilsystemcol4());
		paramSource.addValue("lubeoilsystemcol5",data.getLubeoilsystemcol5());
		paramSource.addValue("lubeoilsystemcol6",data.getLubeoilsystemcol6());
		paramSource.addValue("lubeoilsystemcol7",data.getLubeoilsystemcol7());
		
		
		paramSource.addValue("f5abbaccuraycol1",data.isF5abbaccuraycol1());
		paramSource.addValue("f5abbaccuraycol2",data.isF5abbaccuraycol2());
		paramSource.addValue("f5abbaccuraycol3",data.isF5abbaccuraycol3());
		paramSource.addValue("f5abbaccuraycol4",data.isF5abbaccuraycol4());
		paramSource.addValue("f5abbaccuraycol5",data.isF5abbaccuraycol5());
		paramSource.addValue("f5abbaccuraycol6",data.isF5abbaccuraycol6());
		
		
		paramSource.addValue("formatingsectioncol1Desc",data.getFormatingsectioncol1Desc());
		paramSource.addValue("formatingsectioncol2Desc",data.getFormatingsectioncol2Desc());
		paramSource.addValue("formatingsectioncol3Desc",data.getFormatingsectioncol3Desc());
		paramSource.addValue("formatingsectioncol4Desc",data.getFormatingsectioncol4Desc());
		paramSource.addValue("formatingsectioncol5Desc",data.getFormatingsectioncol5Desc());
		paramSource.addValue("formatingsectioncol6Desc",data.getFormatingsectioncol6Desc());
		paramSource.addValue("formatingsectioncol7Desc",data.getFormatingsectioncol7Desc());
		
		paramSource.addValue("couchrollcol1Desc",data.getCouchrollcol1Desc());
		paramSource.addValue("couchrollcol2Desc",data.getCouchrollcol2Desc());
		paramSource.addValue("couchrollcol3Desc",data.getCouchrollcol3Desc());
		paramSource.addValue("couchrollcol4Desc",data.getCouchrollcol4Desc());
		paramSource.addValue("couchrollcol5Desc",data.getCouchrollcol5Desc());
		paramSource.addValue("couchrollcol6Desc",data.getCouchrollcol6Desc());
		paramSource.addValue("couchrollcol7Desc",data.getCouchrollcol7Desc());
		
		
		paramSource.addValue("picupfeltguidecol1Desc",data.getPicupfeltguidecol1Desc());
		paramSource.addValue("picupfeltguidecol2Desc",data.getPicupfeltguidecol2Desc());
		paramSource.addValue("picupfeltguidecol3Desc",data.getPicupfeltguidecol3Desc());
		paramSource.addValue("picupfeltguidecol4Desc",data.getPicupfeltguidecol4Desc());

		
		paramSource.addValue("suctionpressurerollcol1Desc",data.getSuctionpressurerollcol1Desc());
		paramSource.addValue("suctionpressurerollcol2Desc",data.getSuctionpressurerollcol2Desc());
		paramSource.addValue("suctionpressurerollcol3Desc",data.getSuctionpressurerollcol3Desc());
		paramSource.addValue("suctionpressurerollcol4Desc",data.getSuctionpressurerollcol4Desc());
		paramSource.addValue("suctionpressurerollcol5Desc",data.getSuctionpressurerollcol5Desc());

		
		paramSource.addValue("yankeedryerCol1Desc",data.getYankeedryerCol1Desc());
		paramSource.addValue("yankeedryerCol2Desc",data.getYankeedryerCol2Desc());
		paramSource.addValue("yankeedryerCol3Desc",data.getYankeedryerCol3Desc());
		paramSource.addValue("yankeedryerCol4Desc",data.getYankeedryerCol4Desc());

		paramSource.addValue("pressfeltareacol1Desc",data.getPressfeltareacol1Desc());
		paramSource.addValue("pressfeltareacol2Desc",data.getPressfeltareacol2Desc());
		paramSource.addValue("pressfeltareacol3Desc",data.getPressfeltareacol3Desc());
		paramSource.addValue("pressfeltareacol4Desc",data.getPressfeltareacol4Desc());
		paramSource.addValue("pressfeltareacol5Desc",data.getPressfeltareacol5Desc());
		paramSource.addValue("pressfeltareacol6Desc",data.getPressfeltareacol6Desc());
		paramSource.addValue("pressfeltareacol7Desc",data.getPressfeltareacol7Desc());
		paramSource.addValue("pressfeltareacol8Desc",data.getPressfeltareacol8Desc());

		
		paramSource.addValue("lubeoilsystemcol1Desc",data.getLubeoilsystemcol1Desc());
		paramSource.addValue("lubeoilsystemcol2Desc",data.getLubeoilsystemcol2Desc());
		paramSource.addValue("lubeoilsystemcol3Desc",data.getLubeoilsystemcol3Desc());
		paramSource.addValue("lubeoilsystemcol4Desc",data.getLubeoilsystemcol4Desc());
		paramSource.addValue("lubeoilsystemcol5Desc",data.getLubeoilsystemcol5Desc());
		paramSource.addValue("lubeoilsystemcol6Desc",data.getLubeoilsystemcol6Desc());
		paramSource.addValue("lubeoilsystemcol7Desc",data.getLubeoilsystemcol7Desc());
		
		
		paramSource.addValue("f5abbaccuraycol1Desc",data.getF5abbaccuraycol1Desc());
		paramSource.addValue("f5abbaccuraycol2Desc",data.getF5abbaccuraycol2Desc());
		paramSource.addValue("f5abbaccuraycol3Desc",data.getF5abbaccuraycol3Desc());
		paramSource.addValue("f5abbaccuraycol4Desc",data.getF5abbaccuraycol4Desc());
		paramSource.addValue("f5abbaccuraycol5Desc",data.getF5abbaccuraycol5Desc());
		paramSource.addValue("f5abbaccuraycol6Desc",data.getF5abbaccuraycol6Desc());
		
		
		
				paramSource.addValue("showerwaterSystemcol1",data.getShowerwaterSystemcol1());
				paramSource.addValue("showerwaterSystemcolin2",data.getShowerwaterSystemcolin2());
				paramSource.addValue("showerwaterSystemcolout2",data.getShowerwaterSystemcolout2());
				paramSource.addValue("showerwaterSystemcolin3",data.getShowerwaterSystemcolin3());
				paramSource.addValue("showerwaterSystemcolout3",data.getShowerwaterSystemcolout3());
				paramSource.addValue("showerwaterSystemcol4",data.isShowerwaterSystemcol4());
				paramSource.addValue("showerwaterSystemcolin5",data.getShowerwaterSystemcolin5());
				paramSource.addValue("showerwaterSystemcolout5",data.getShowerwaterSystemcolout5());
				paramSource.addValue("showerwaterSystemcol6",data.getShowerwaterSystemcol6());
				paramSource.addValue("showerwaterSystemcol7",data.getShowerwaterSystemcol7());
				paramSource.addValue("showerwaterSystemcolin8",data.getShowerwaterSystemcolin8());
				paramSource.addValue("showerwaterSystemcolout8",data.getShowerwaterSystemcolout8());
				paramSource.addValue("showerwaterSystemcol9",data.isShowerwaterSystemcol9());
				paramSource.addValue("showerwaterSystemcol10",data.getShowerwaterSystemcol10());
				paramSource.addValue("showerwaterSystemcol11",data.getShowerwaterSystemcol11());
				
				paramSource.addValue("fanpumpcol1",data.getFanpumpcol1());
				paramSource.addValue("fanpumpcolin2",data.getFanpumpcolin2());
				paramSource.addValue("fanpumpcolout2",data.getFanpumpcolout2());
				paramSource.addValue("fanpumpcol3",data.isFanpumpcol3());


				paramSource.addValue("primarythinstockscreencol1",data.getPrimarythinstockscreencol1());
				paramSource.addValue("primarythinstockscreencol2",data.getPrimarythinstockscreencol2());
				paramSource.addValue("primarythinstockscreencol3",data.getPrimarythinstockscreencol3());		
				paramSource.addValue("primarythinstockscreencol4",data.isPrimarythinstockscreencol4());


				paramSource.addValue("vacuumpumpcol1",data.isVacuumpumpcol1());
				paramSource.addValue("vacuumpumpcolin2",data.getVacuumpumpcolin2());
				paramSource.addValue("vacuumpumpcolout2",data.getVacuumpumpcolout2());
				paramSource.addValue("vacuumpumpcol3",data.getVacuumpumpcol3());
				paramSource.addValue("vacuumpumpcol4",data.getVacuumpumpcol4());
				paramSource.addValue("vacuumpumpcol5",data.getVacuumpumpcol5());
				paramSource.addValue("vacuumpumpcol6",data.getVacuumpumpcol6());
				paramSource.addValue("vacuumpumpcol7",data.getVacuumpumpcol7());
				paramSource.addValue("vacuumpumpcol8",data.getVacuumpumpcol8());
				paramSource.addValue("vacuumpumpcol9",data.getVacuumpumpcol9());
				paramSource.addValue("vacuumpumpcol10",data.getVacuumpumpcol10());
				paramSource.addValue("vacuumpumpcol11",data.getVacuumpumpcol11());
				paramSource.addValue("vacuumpumpcol12",data.getVacuumpumpcol12());
				paramSource.addValue("vacuumpumpcol13",data.getVacuumpumpcol13());
				paramSource.addValue("vacuumpumpcol14",data.getVacuumpumpcol14());
				paramSource.addValue("vacuumpumpcol15",data.getVacuumpumpcol15());
				paramSource.addValue("vacuumpumpcol16",data.getVacuumpumpcol16());
				paramSource.addValue("vacuumpumpcol17",data.getVacuumpumpcol17());
				paramSource.addValue("vacuumpumpcol18",data.getVacuumpumpcol18());
				
				paramSource.addValue("showerwaterSystemcol1Desc",data.getShowerwaterSystemcol1Desc());
				paramSource.addValue("showerwaterSystemcol2Desc",data.getShowerwaterSystemcol2Desc());
				paramSource.addValue("showerwaterSystemcol3Desc",data.getShowerwaterSystemcol3Desc());
				paramSource.addValue("showerwaterSystemcol4Desc",data.getShowerwaterSystemcol4Desc());
				paramSource.addValue("showerwaterSystemcol5Desc",data.getShowerwaterSystemcol5Desc());
				paramSource.addValue("showerwaterSystemcol6Desc",data.getShowerwaterSystemcol6Desc());
				paramSource.addValue("showerwaterSystemcol7Desc",data.getShowerwaterSystemcol7Desc());
				paramSource.addValue("showerwaterSystemcol8Desc",data.getShowerwaterSystemcol8Desc());
				paramSource.addValue("showerwaterSystemcol9Desc",data.getShowerwaterSystemcol9Desc());
				paramSource.addValue("showerwaterSystemcol10Desc",data.getShowerwaterSystemcol10Desc());
				paramSource.addValue("showerwaterSystemcol11Desc",data.getShowerwaterSystemcol11Desc());
				
				paramSource.addValue("fanpumpcol1Desc",data.getFanpumpcol1Desc());
				paramSource.addValue("fanpumpcol2Desc",data.getFanpumpcol2Desc());
				paramSource.addValue("fanpumpcol3Desc",data.getFanpumpcol3Desc());


				paramSource.addValue("primarythinstockscreencol1Desc",data.getPrimarythinstockscreencol1Desc());
				paramSource.addValue("primarythinstockscreencol2Desc",data.getPrimarythinstockscreencol2Desc());
				paramSource.addValue("primarythinstockscreencol3Desc",data.getPrimarythinstockscreencol3Desc());
				paramSource.addValue("primarythinstockscreencol4Desc",data.getPrimarythinstockscreencol4Desc());


				paramSource.addValue("vacuumpumpcol1Desc",data.getVacuumpumpcol1Desc());
				paramSource.addValue("vacuumpumpcol2Desc",data.getVacuumpumpcol2Desc());
				paramSource.addValue("vacuumpumpcol3Desc",data.getVacuumpumpcol3Desc());
				paramSource.addValue("vacuumpumpcol4Desc",data.getVacuumpumpcol4Desc());
				paramSource.addValue("vacuumpumpcol5Desc",data.getVacuumpumpcol5Desc());
				paramSource.addValue("vacuumpumpcol6Desc",data.getVacuumpumpcol6Desc());
				paramSource.addValue("vacuumpumpcol7Desc",data.getVacuumpumpcol7Desc());
				paramSource.addValue("vacuumpumpcol8Desc",data.getVacuumpumpcol8Desc());
				paramSource.addValue("vacuumpumpcol9Desc",data.getVacuumpumpcol9Desc());
				paramSource.addValue("vacuumpumpcol10Desc",data.getVacuumpumpcol10Desc());
				paramSource.addValue("vacuumpumpcol11Desc",data.getVacuumpumpcol11Desc());
				paramSource.addValue("vacuumpumpcol12Desc",data.getVacuumpumpcol12Desc());
				paramSource.addValue("vacuumpumpcol13Desc",data.getVacuumpumpcol13Desc());
				paramSource.addValue("vacuumpumpcol14Desc",data.getVacuumpumpcol14Desc());
				paramSource.addValue("vacuumpumpcol15Desc",data.getVacuumpumpcol15Desc());
				paramSource.addValue("vacuumpumpcol16Desc",data.getVacuumpumpcol16Desc());
				paramSource.addValue("vacuumpumpcol17Desc",data.getVacuumpumpcol17Desc());
				paramSource.addValue("vacuumpumpcol18Desc",data.getVacuumpumpcol18Desc());
				
				

		
		
		
		if (data.getId() == 0) {	
		
			String sql=DatabaseUtil.getSQL("sql/insertLeadOperator_pm5.sql");
			jdbcTemplate.update(sql, paramSource);
		}	
		else
		{
			paramSource.addValue("id",data.getId());
			String sql=DatabaseUtil.getSQL("sql/updateLeadOperator_pm5.sql");
			jdbcTemplate.update(sql, paramSource);
		}
	}
	@Override
	public LeadOperatorPM5 getOperatorData(String position,
			String date, String shift){
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSourceQRT);
		String sql = "select * from [leadoperator_pm5] where position=? AND shift=? AND date=? ";
		LeadOperatorPM5 leadoperatorpm5 = null;

		try {
			leadoperatorpm5 = jdbcTemplate.queryForObject(sql, new Object[] {position,shift, date}, new RowMapper<LeadOperatorPM5>() {

				@Override
				public LeadOperatorPM5 mapRow(ResultSet rs, int arg1)
						throws SQLException {
					LeadOperatorPM5 data = new LeadOperatorPM5();
					
					try
					{
						String newDate = dateFormat.format(fromuser.parse(rs.getString("date")));
					
					data.setId(rs.getInt("id"));
					data.setPosition(rs.getString("position"));
					data.setOperatorName(rs.getString("operatorname"));
					data.setEdate(newDate);
					data.setCrew(rs.getString("crew"));
					data.setShift(rs.getString("shift"));
					data.setMachinedown(rs.getBoolean("machinedown"));
					data.setFormatingsectioncol1(rs.getString("formatingsectioncol1"));
					data.setFormatingsectioncol2(rs.getString("formatingsectioncol2"));
					data.setFormatingsectioncol3(rs.getString("formatingsectioncol3"));
					data.setFormatingsectioncol4(rs.getString("formatingsectioncol4"));
					data.setFormatingsectioncol5(rs.getString("formatingsectioncol5"));	
					data.setFormatingsectioncol6(rs.getString("formatingsectioncol6"));
					data.setFormatingsectioncol7(rs.getString("formatingsectioncol7"));	
					
					
					data.setCouchrollcol1(rs.getString("couchrollcol1"));
					data.setCouchrollcol2(rs.getString("couchrollcol2"));
					data.setCouchrollcol3(rs.getString("couchrollcol3"));
					data.setCouchrollcol4(rs.getString("couchrollcol4"));
					data.setCouchrollcol5(rs.getString("couchrollcol5"));
					data.setCouchrollcol6(rs.getBoolean("couchrollcol6"));
					data.setCouchrollcol7(rs.getBoolean("couchrollcol7"));
					
					data.setPicupfeltguidecol1(rs.getString("picupfeltguidecol1"));
					data.setPicupfeltguidecol2(rs.getString("picupfeltguidecol2"));
					data.setPicupfeltguidecol3(rs.getString("picupfeltguidecol3"));
					data.setPicupfeltguidecol4(rs.getString("picupfeltguidecol4"));
					
					data.setSuctionpressurerollcol1(rs.getString("suctionpressurerollcol1"));
					data.setSuctionpressurerollcol2(rs.getString("suctionpressurerollcol2"));
					data.setSuctionpressurerollcol3(rs.getString("suctionpressurerollcol3"));
					data.setSuctionpressurerollcol4(rs.getString("suctionpressurerollcol4"));
					data.setSuctionpressurerollcol5(rs.getString("suctionpressurerollcol5"));
					
					data.setYankeedryerCol1(rs.getString("yankeedryerCol1"));
					data.setYankeedryerCol2(rs.getString("yankeedryerCol2"));
					data.setYankeedryerCol3(rs.getString("yankeedryerCol3"));
					data.setYankeedryerCol4(rs.getString("yankeedryerCol4"));
					
					data.setPressfeltareacol1(rs.getString("pressfeltareacol1"));
					data.setPressfeltareacol2(rs.getBoolean("pressfeltareacol2"));
					data.setPressfeltareacol3(rs.getString("pressfeltareacol3"));
					data.setPressfeltareacol4(rs.getString("pressfeltareacol4"));
					data.setPressfeltareacol5(rs.getString("pressfeltareacol5"));
					data.setPressfeltareacol6(rs.getString("pressfeltareacol6"));
					data.setPressfeltareacol7(rs.getString("pressfeltareacol7"));
					
					data.setLubeoilsystemcol1(rs.getString("lubeoilsystemcol1"));
					data.setLubeoilsystemcol2(rs.getString("lubeoilsystemcol2"));
					data.setLubeoilsystemcol3(rs.getString("lubeoilsystemcol3"));
					data.setLubeoilsystemcol4(rs.getString("lubeoilsystemcol4"));
					data.setLubeoilsystemcol5(rs.getString("lubeoilsystemcol5"));
					data.setLubeoilsystemcol6(rs.getString("lubeoilsystemcol6"));
					data.setLubeoilsystemcol7(rs.getString("lubeoilsystemcol7"));
					
					
					
					data.setF5abbaccuraycol1(rs.getBoolean("f5abbaccuraycol1"));
					data.setF5abbaccuraycol2(rs.getBoolean("f5abbaccuraycol2"));
					data.setF5abbaccuraycol3(rs.getBoolean("f5abbaccuraycol3"));
					data.setF5abbaccuraycol4(rs.getBoolean("f5abbaccuraycol4"));
					data.setF5abbaccuraycol5(rs.getBoolean("f5abbaccuraycol5"));
					
					data.setFormatingsectioncol1Desc(rs.getString("formatingsectioncol1Desc"));
					data.setFormatingsectioncol2Desc(rs.getString("formatingsectioncol2Desc"));
					data.setFormatingsectioncol3Desc(rs.getString("formatingsectioncol3Desc"));
					data.setFormatingsectioncol4Desc(rs.getString("formatingsectioncol4Desc"));
					data.setFormatingsectioncol5Desc(rs.getString("formatingsectioncol5Desc"));
					data.setFormatingsectioncol6Desc(rs.getString("formatingsectioncol6Desc"));
					data.setFormatingsectioncol7Desc(rs.getString("formatingsectioncol7Desc"));
					
					data.setCouchrollcol1Desc(rs.getString("couchrollcol1Desc"));
					data.setCouchrollcol2Desc(rs.getString("couchrollcol2Desc"));
					data.setCouchrollcol3Desc(rs.getString("couchrollcol3Desc"));
					data.setCouchrollcol4Desc(rs.getString("couchrollcol4Desc"));
					data.setCouchrollcol5Desc(rs.getString("couchrollcol5Desc"));
					data.setCouchrollcol6Desc(rs.getString("couchrollcol6Desc"));
					data.setCouchrollcol7Desc(rs.getString("couchrollcol7Desc"));
					
					data.setPicupfeltguidecol1Desc(rs.getString("picupfeltguidecol1Desc"));
					data.setPicupfeltguidecol2Desc(rs.getString("picupfeltguidecol2Desc"));
					data.setPicupfeltguidecol3Desc(rs.getString("picupfeltguidecol3Desc"));
					data.setPicupfeltguidecol4Desc(rs.getString("picupfeltguidecol4Desc"));
					
					data.setSuctionpressurerollcol1Desc(rs.getString("suctionpressurerollcol1Desc"));
					data.setSuctionpressurerollcol2Desc(rs.getString("suctionpressurerollcol2Desc"));
					data.setSuctionpressurerollcol3Desc(rs.getString("suctionpressurerollcol3Desc"));
					data.setSuctionpressurerollcol4Desc(rs.getString("suctionpressurerollcol4Desc"));
					data.setSuctionpressurerollcol5Desc(rs.getString("suctionpressurerollcol5Desc"));
					
					data.setYankeedryerCol1Desc(rs.getString("yankeedryerCol1Desc"));
					data.setYankeedryerCol2Desc(rs.getString("yankeedryerCol2Desc"));
					data.setYankeedryerCol3Desc(rs.getString("yankeedryerCol3Desc"));
					data.setYankeedryerCol4Desc(rs.getString("yankeedryerCol4Desc"));
					
					data.setPressfeltareacol1Desc(rs.getString("pressfeltareacol1Desc"));
					data.setPressfeltareacol2Desc(rs.getString("pressfeltareacol2Desc"));
					data.setPressfeltareacol3Desc(rs.getString("pressfeltareacol3Desc"));
					data.setPressfeltareacol4Desc(rs.getString("pressfeltareacol4Desc"));
					data.setPressfeltareacol5Desc(rs.getString("pressfeltareacol5Desc"));
					data.setPressfeltareacol6Desc(rs.getString("pressfeltareacol6Desc"));
					data.setPressfeltareacol7Desc(rs.getString("pressfeltareacol7Desc"));
					
					
					data.setLubeoilsystemcol1Desc(rs.getString("lubeoilsystemcol1Desc"));
					data.setLubeoilsystemcol2Desc(rs.getString("lubeoilsystemcol2Desc"));
					data.setLubeoilsystemcol3Desc(rs.getString("lubeoilsystemcol3Desc"));
					data.setLubeoilsystemcol4Desc(rs.getString("lubeoilsystemcol4Desc"));
					data.setLubeoilsystemcol5Desc(rs.getString("lubeoilsystemcol5Desc"));
					data.setLubeoilsystemcol6Desc(rs.getString("lubeoilsystemcol6Desc"));
					data.setLubeoilsystemcol7Desc(rs.getString("lubeoilsystemcol7Desc"));
					
					data.setF5abbaccuraycol1Desc(rs.getString("f5abbaccuraycol1Desc"));
					data.setF5abbaccuraycol2Desc(rs.getString("f5abbaccuraycol2Desc"));
					data.setF5abbaccuraycol3Desc(rs.getString("f5abbaccuraycol3Desc"));
					data.setF5abbaccuraycol4Desc(rs.getString("f5abbaccuraycol4Desc"));
					data.setF5abbaccuraycol5Desc(rs.getString("f5abbaccuraycol5Desc"));
					data.setF5abbaccuraycol6Desc(rs.getString("f5abbaccuraycol6Desc"));
					
							data.setShowerwaterSystemcol1(rs.getString("showerwaterSystemcol1"));
							data.setShowerwaterSystemcolin2(rs.getString("showerwaterSystemcolin2"));
							data.setShowerwaterSystemcolout2(rs.getString("showerwaterSystemcolout2"));
							data.setShowerwaterSystemcolin3(rs.getString("showerwaterSystemcolin3"));
							data.setShowerwaterSystemcolout3(rs.getString("showerwaterSystemcolout3"));
							data.setShowerwaterSystemcol4(rs.getBoolean("showerwaterSystemcol4"));
							data.setShowerwaterSystemcolin5(rs.getString("showerwaterSystemcolin5"));
							data.setShowerwaterSystemcolout5(rs.getString("showerwaterSystemcolout5"));
							data.setShowerwaterSystemcol6(rs.getString("showerwaterSystemcol6"));
							data.setShowerwaterSystemcol7(rs.getString("showerwaterSystemcol7"));
							data.setShowerwaterSystemcolin8(rs.getString("showerwaterSystemcolin8"));
							data.setShowerwaterSystemcolout8(rs.getString("showerwaterSystemcolout8"));
							data.setShowerwaterSystemcol9(rs.getBoolean("showerwaterSystemcol9"));
							data.setShowerwaterSystemcol10(rs.getString("showerwaterSystemcol10"));
							data.setShowerwaterSystemcol11(rs.getString("showerwaterSystemcol11"));							
							data.setFanpumpcol1(rs.getString("fanpumpcol1"));
							data.setFanpumpcolin2(rs.getString("fanpumpcolin2"));
							data.setFanpumpcolout2(rs.getString("fanpumpcolout2"));
							data.setFanpumpcol3(rs.getBoolean("fanpumpcol3"));
							data.setPrimarythinstockscreencol1(rs.getString("primarythinstockscreencol1"));
							data.setPrimarythinstockscreencol2(rs.getString("primarythinstockscreencol2"));
							data.setPrimarythinstockscreencol3(rs.getString("primarythinstockscreencol3"));						
							data.setPrimarythinstockscreencol4(rs.getBoolean("primarythinstockscreencol4"));
							data.setVacuumpumpcol1(rs.getBoolean("vacuumpumpcol1"));
							data.setVacuumpumpcolin2(rs.getString("vacuumpumpcolin2"));
							data.setVacuumpumpcolout2(rs.getString("vacuumpumpcolout2"));
							data.setVacuumpumpcol3(rs.getString("vacuumpumpcol3"));
							data.setVacuumpumpcol4(rs.getString("vacuumpumpcol4"));
							data.setVacuumpumpcol5(rs.getString("vacuumpumpcol5"));
							data.setVacuumpumpcol6(rs.getString("vacuumpumpcol6"));
							data.setVacuumpumpcol7(rs.getString("vacuumpumpcol7"));
							data.setVacuumpumpcol8(rs.getString("vacuumpumpcol8"));
							data.setVacuumpumpcol9(rs.getString("vacuumpumpcol9"));
							data.setVacuumpumpcol10(rs.getString("vacuumpumpcol10"));
							data.setVacuumpumpcol11(rs.getString("vacuumpumpcol11"));
							data.setVacuumpumpcol12(rs.getString("vacuumpumpcol12"));
							data.setVacuumpumpcol13(rs.getString("vacuumpumpcol13"));
							data.setVacuumpumpcol14(rs.getString("vacuumpumpcol14"));
							data.setVacuumpumpcol15(rs.getString("vacuumpumpcol15"));
							data.setVacuumpumpcol16(rs.getString("vacuumpumpcol16"));
							data.setVacuumpumpcol17(rs.getString("vacuumpumpcol17"));
							data.setVacuumpumpcol18(rs.getString("vacuumpumpcol18"));

							
							data.setShowerwaterSystemcol1Desc(rs.getString("showerwaterSystemcol1Desc"));
							data.setShowerwaterSystemcol2Desc(rs.getString("showerwaterSystemcol2Desc"));
							data.setShowerwaterSystemcol3Desc(rs.getString("showerwaterSystemcol3Desc"));
							data.setShowerwaterSystemcol4Desc(rs.getString("showerwaterSystemcol4Desc"));
							data.setShowerwaterSystemcol5Desc(rs.getString("showerwaterSystemcol5Desc"));
							data.setShowerwaterSystemcol6Desc(rs.getString("showerwaterSystemcol6Desc"));
							data.setShowerwaterSystemcol7Desc(rs.getString("showerwaterSystemcol7Desc"));
							data.setShowerwaterSystemcol8Desc(rs.getString("showerwaterSystemcol8Desc"));
							data.setShowerwaterSystemcol9Desc(rs.getString("showerwaterSystemcol9Desc"));
							data.setShowerwaterSystemcol10Desc(rs.getString("showerwaterSystemcol10Desc"));
							data.setShowerwaterSystemcol11Desc(rs.getString("showerwaterSystemcol11Desc"));
							data.setFanpumpcol1Desc(rs.getString("fanpumpcol1Desc"));
							data.setFanpumpcol2Desc(rs.getString("fanpumpcol2Desc"));
							data.setFanpumpcol3Desc(rs.getString("fanpumpcol3Desc"));
							data.setPrimarythinstockscreencol1Desc(rs.getString("primarythinstockscreencol1Desc"));
							data.setPrimarythinstockscreencol2Desc(rs.getString("primarythinstockscreencol2Desc"));
							data.setPrimarythinstockscreencol3Desc(rs.getString("primarythinstockscreencol3Desc"));
							data.setPrimarythinstockscreencol4Desc(rs.getString("primarythinstockscreencol4Desc"));
							data.setVacuumpumpcol1Desc(rs.getString("vacuumpumpcol1Desc"));
							data.setVacuumpumpcol2Desc(rs.getString("vacuumpumpcol2Desc"));
							data.setVacuumpumpcol3Desc(rs.getString("vacuumpumpcol3Desc"));
							data.setVacuumpumpcol4Desc(rs.getString("vacuumpumpcol4Desc"));
							data.setVacuumpumpcol5Desc(rs.getString("vacuumpumpcol5Desc"));
							data.setVacuumpumpcol6Desc(rs.getString("vacuumpumpcol6Desc"));
							data.setVacuumpumpcol7Desc(rs.getString("vacuumpumpcol7Desc"));
							data.setVacuumpumpcol8Desc(rs.getString("vacuumpumpcol8Desc"));
							data.setVacuumpumpcol9Desc(rs.getString("vacuumpumpcol9Desc"));
							data.setVacuumpumpcol10Desc(rs.getString("vacuumpumpcol10Desc"));
							data.setVacuumpumpcol11Desc(rs.getString("vacuumpumpcol11Desc"));
							data.setVacuumpumpcol12Desc(rs.getString("vacuumpumpcol12Desc"));
							data.setVacuumpumpcol13Desc(rs.getString("vacuumpumpcol13Desc"));
							data.setVacuumpumpcol14Desc(rs.getString("vacuumpumpcol14Desc"));
							data.setVacuumpumpcol15Desc(rs.getString("vacuumpumpcol15Desc"));
							data.setVacuumpumpcol16Desc(rs.getString("vacuumpumpcol16Desc"));
							data.setVacuumpumpcol17Desc(rs.getString("vacuumpumpcol17Desc"));
							data.setVacuumpumpcol18Desc(rs.getString("vacuumpumpcol18Desc"));
							
					
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
		
		return leadoperatorpm5;
	}	
	@Override
	public List<LeadOperatorPM5> getOperatorDataList(String position,
			String sdate, String edate ,String shift){
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSourceQRT);
		

		String sql = "select * from [leadoperator_pm5] where position=? AND shift=? AND date BETWEEN ? AND ? ";
		 

		List<LeadOperatorPM5> leadoperatorpm5 = null;

		try {
			leadoperatorpm5 = jdbcTemplate.query(sql, new Object[] {position,shift, sdate,edate }, new RowMapper<LeadOperatorPM5>() {

				@Override
				public LeadOperatorPM5 mapRow(ResultSet rs, int arg1)
						throws SQLException {
					LeadOperatorPM5 data = new LeadOperatorPM5();
					
					try
					{
						String newDate = dateFormat.format(fromuser.parse(rs.getString("date")));
					
					data.setId(rs.getInt("id"));
					data.setPosition(rs.getString("position"));
					data.setOperatorName(rs.getString("operatorname"));
					data.setEdate(newDate);
					data.setCrew(rs.getString("crew"));
					data.setShift(rs.getString("shift"));
					data.setMachinedown(rs.getBoolean("machinedown"));
					data.setFormatingsectioncol1(rs.getString("formatingsectioncol1"));
					data.setFormatingsectioncol2(rs.getString("formatingsectioncol2"));
					data.setFormatingsectioncol3(rs.getString("formatingsectioncol3"));
					data.setFormatingsectioncol4(rs.getString("formatingsectioncol4"));
					data.setFormatingsectioncol5(rs.getString("formatingsectioncol5"));	
					data.setFormatingsectioncol6(rs.getString("formatingsectioncol6"));
					data.setFormatingsectioncol7(rs.getString("formatingsectioncol7"));	
					
					
					data.setCouchrollcol1(rs.getString("couchrollcol1"));
					data.setCouchrollcol2(rs.getString("couchrollcol2"));
					data.setCouchrollcol3(rs.getString("couchrollcol3"));
					data.setCouchrollcol4(rs.getString("couchrollcol4"));
					data.setCouchrollcol5(rs.getString("couchrollcol5"));
					data.setCouchrollcol6(rs.getBoolean("couchrollcol6"));
					data.setCouchrollcol7(rs.getBoolean("couchrollcol7"));
					
					data.setPicupfeltguidecol1(rs.getString("picupfeltguidecol1"));
					data.setPicupfeltguidecol2(rs.getString("picupfeltguidecol2"));
					data.setPicupfeltguidecol3(rs.getString("picupfeltguidecol3"));
					data.setPicupfeltguidecol4(rs.getString("picupfeltguidecol4"));
					
					data.setSuctionpressurerollcol1(rs.getString("suctionpressurerollcol1"));
					data.setSuctionpressurerollcol2(rs.getString("suctionpressurerollcol2"));
					data.setSuctionpressurerollcol3(rs.getString("suctionpressurerollcol3"));
					data.setSuctionpressurerollcol4(rs.getString("suctionpressurerollcol4"));
					data.setSuctionpressurerollcol5(rs.getString("suctionpressurerollcol5"));
					
					data.setYankeedryerCol1(rs.getString("yankeedryerCol1"));
					data.setYankeedryerCol2(rs.getString("yankeedryerCol2"));
					data.setYankeedryerCol3(rs.getString("yankeedryerCol3"));
					data.setYankeedryerCol4(rs.getString("yankeedryerCol4"));
					
					data.setPressfeltareacol1(rs.getString("pressfeltareacol1"));
					data.setPressfeltareacol2(rs.getBoolean("pressfeltareacol2"));
					data.setPressfeltareacol3(rs.getString("pressfeltareacol3"));
					data.setPressfeltareacol4(rs.getString("pressfeltareacol4"));
					data.setPressfeltareacol5(rs.getString("pressfeltareacol5"));
					data.setPressfeltareacol6(rs.getString("pressfeltareacol6"));
					data.setPressfeltareacol7(rs.getString("pressfeltareacol7"));
					
					data.setLubeoilsystemcol1(rs.getString("lubeoilsystemcol1"));
					data.setLubeoilsystemcol2(rs.getString("lubeoilsystemcol2"));
					data.setLubeoilsystemcol3(rs.getString("lubeoilsystemcol3"));
					data.setLubeoilsystemcol4(rs.getString("lubeoilsystemcol4"));
					data.setLubeoilsystemcol5(rs.getString("lubeoilsystemcol5"));
					data.setLubeoilsystemcol6(rs.getString("lubeoilsystemcol6"));
					data.setLubeoilsystemcol7(rs.getString("lubeoilsystemcol7"));
					
					
					
					data.setF5abbaccuraycol1(rs.getBoolean("f5abbaccuraycol1"));
					data.setF5abbaccuraycol2(rs.getBoolean("f5abbaccuraycol2"));
					data.setF5abbaccuraycol3(rs.getBoolean("f5abbaccuraycol3"));
					data.setF5abbaccuraycol4(rs.getBoolean("f5abbaccuraycol4"));
					data.setF5abbaccuraycol5(rs.getBoolean("f5abbaccuraycol5"));
					
					data.setFormatingsectioncol1Desc(rs.getString("formatingsectioncol1Desc"));
					data.setFormatingsectioncol2Desc(rs.getString("formatingsectioncol2Desc"));
					data.setFormatingsectioncol3Desc(rs.getString("formatingsectioncol3Desc"));
					data.setFormatingsectioncol4Desc(rs.getString("formatingsectioncol4Desc"));
					data.setFormatingsectioncol5Desc(rs.getString("formatingsectioncol5Desc"));
					data.setFormatingsectioncol6Desc(rs.getString("formatingsectioncol6Desc"));
					data.setFormatingsectioncol7Desc(rs.getString("formatingsectioncol7Desc"));
					
					data.setCouchrollcol1Desc(rs.getString("couchrollcol1Desc"));
					data.setCouchrollcol2Desc(rs.getString("couchrollcol2Desc"));
					data.setCouchrollcol3Desc(rs.getString("couchrollcol3Desc"));
					data.setCouchrollcol4Desc(rs.getString("couchrollcol4Desc"));
					data.setCouchrollcol5Desc(rs.getString("couchrollcol5Desc"));
					data.setCouchrollcol6Desc(rs.getString("couchrollcol6Desc"));
					data.setCouchrollcol7Desc(rs.getString("couchrollcol7Desc"));
					
					data.setPicupfeltguidecol1Desc(rs.getString("picupfeltguidecol1Desc"));
					data.setPicupfeltguidecol2Desc(rs.getString("picupfeltguidecol2Desc"));
					data.setPicupfeltguidecol3Desc(rs.getString("picupfeltguidecol3Desc"));
					data.setPicupfeltguidecol4Desc(rs.getString("picupfeltguidecol4Desc"));
					
					data.setSuctionpressurerollcol1Desc(rs.getString("suctionpressurerollcol1Desc"));
					data.setSuctionpressurerollcol2Desc(rs.getString("suctionpressurerollcol2Desc"));
					data.setSuctionpressurerollcol3Desc(rs.getString("suctionpressurerollcol3Desc"));
					data.setSuctionpressurerollcol4Desc(rs.getString("suctionpressurerollcol4Desc"));
					data.setSuctionpressurerollcol5Desc(rs.getString("suctionpressurerollcol5Desc"));
					
					data.setYankeedryerCol1Desc(rs.getString("yankeedryerCol1Desc"));
					data.setYankeedryerCol2Desc(rs.getString("yankeedryerCol2Desc"));
					data.setYankeedryerCol3Desc(rs.getString("yankeedryerCol3Desc"));
					data.setYankeedryerCol4Desc(rs.getString("yankeedryerCol4Desc"));
					
					data.setPressfeltareacol1Desc(rs.getString("pressfeltareacol1Desc"));
					data.setPressfeltareacol2Desc(rs.getString("pressfeltareacol2Desc"));
					data.setPressfeltareacol3Desc(rs.getString("pressfeltareacol3Desc"));
					data.setPressfeltareacol4Desc(rs.getString("pressfeltareacol4Desc"));
					data.setPressfeltareacol5Desc(rs.getString("pressfeltareacol5Desc"));
					data.setPressfeltareacol6Desc(rs.getString("pressfeltareacol6Desc"));
					data.setPressfeltareacol7Desc(rs.getString("pressfeltareacol7Desc"));
					
					
					data.setLubeoilsystemcol1Desc(rs.getString("lubeoilsystemcol1Desc"));
					data.setLubeoilsystemcol2Desc(rs.getString("lubeoilsystemcol2Desc"));
					data.setLubeoilsystemcol3Desc(rs.getString("lubeoilsystemcol3Desc"));
					data.setLubeoilsystemcol4Desc(rs.getString("lubeoilsystemcol4Desc"));
					data.setLubeoilsystemcol5Desc(rs.getString("lubeoilsystemcol5Desc"));
					data.setLubeoilsystemcol6Desc(rs.getString("lubeoilsystemcol6Desc"));
					data.setLubeoilsystemcol7Desc(rs.getString("lubeoilsystemcol7Desc"));
					
					data.setF5abbaccuraycol1Desc(rs.getString("f5abbaccuraycol1Desc"));
					data.setF5abbaccuraycol2Desc(rs.getString("f5abbaccuraycol2Desc"));
					data.setF5abbaccuraycol3Desc(rs.getString("f5abbaccuraycol3Desc"));
					data.setF5abbaccuraycol4Desc(rs.getString("f5abbaccuraycol4Desc"));
					data.setF5abbaccuraycol5Desc(rs.getString("f5abbaccuraycol5Desc"));
					data.setF5abbaccuraycol6Desc(rs.getString("f5abbaccuraycol6Desc"));
					
							data.setShowerwaterSystemcol1(rs.getString("showerwaterSystemcol1"));
							data.setShowerwaterSystemcolin2(rs.getString("showerwaterSystemcolin2"));
							data.setShowerwaterSystemcolout2(rs.getString("showerwaterSystemcolout2"));
							data.setShowerwaterSystemcolin3(rs.getString("showerwaterSystemcolin3"));
							data.setShowerwaterSystemcolout3(rs.getString("showerwaterSystemcolout3"));
							data.setShowerwaterSystemcol4(rs.getBoolean("showerwaterSystemcol4"));
							data.setShowerwaterSystemcolin5(rs.getString("showerwaterSystemcolin5"));
							data.setShowerwaterSystemcolout5(rs.getString("showerwaterSystemcolout5"));
							data.setShowerwaterSystemcol6(rs.getString("showerwaterSystemcol6"));
							data.setShowerwaterSystemcol7(rs.getString("showerwaterSystemcol7"));
							data.setShowerwaterSystemcolin8(rs.getString("showerwaterSystemcolin8"));
							data.setShowerwaterSystemcolout8(rs.getString("showerwaterSystemcolout8"));
							data.setShowerwaterSystemcol9(rs.getBoolean("showerwaterSystemcol9"));
							data.setShowerwaterSystemcol10(rs.getString("showerwaterSystemcol10"));
							data.setShowerwaterSystemcol11(rs.getString("showerwaterSystemcol11"));							
							data.setFanpumpcol1(rs.getString("fanpumpcol1"));
							data.setFanpumpcolin2(rs.getString("fanpumpcolin2"));
							data.setFanpumpcolout2(rs.getString("fanpumpcolout2"));
							data.setFanpumpcol3(rs.getBoolean("fanpumpcol3"));
							data.setPrimarythinstockscreencol1(rs.getString("primarythinstockscreencol1"));
							data.setPrimarythinstockscreencol2(rs.getString("primarythinstockscreencol2"));
							data.setPrimarythinstockscreencol3(rs.getString("primarythinstockscreencol3"));						
							data.setPrimarythinstockscreencol4(rs.getBoolean("primarythinstockscreencol4"));
							data.setVacuumpumpcol1(rs.getBoolean("vacuumpumpcol1"));
							data.setVacuumpumpcolin2(rs.getString("vacuumpumpcolin2"));
							data.setVacuumpumpcolout2(rs.getString("vacuumpumpcolout2"));
							data.setVacuumpumpcol3(rs.getString("vacuumpumpcol3"));
							data.setVacuumpumpcol4(rs.getString("vacuumpumpcol4"));
							data.setVacuumpumpcol5(rs.getString("vacuumpumpcol5"));
							data.setVacuumpumpcol6(rs.getString("vacuumpumpcol6"));
							data.setVacuumpumpcol7(rs.getString("vacuumpumpcol7"));
							data.setVacuumpumpcol8(rs.getString("vacuumpumpcol8"));
							data.setVacuumpumpcol9(rs.getString("vacuumpumpcol9"));
							data.setVacuumpumpcol10(rs.getString("vacuumpumpcol10"));
							data.setVacuumpumpcol11(rs.getString("vacuumpumpcol11"));
							data.setVacuumpumpcol12(rs.getString("vacuumpumpcol12"));
							data.setVacuumpumpcol13(rs.getString("vacuumpumpcol13"));
							data.setVacuumpumpcol14(rs.getString("vacuumpumpcol14"));
							data.setVacuumpumpcol15(rs.getString("vacuumpumpcol15"));
							data.setVacuumpumpcol16(rs.getString("vacuumpumpcol16"));
							data.setVacuumpumpcol17(rs.getString("vacuumpumpcol17"));
							data.setVacuumpumpcol18(rs.getString("vacuumpumpcol18"));

							
							data.setShowerwaterSystemcol1Desc(rs.getString("showerwaterSystemcol1Desc"));
							data.setShowerwaterSystemcol2Desc(rs.getString("showerwaterSystemcol2Desc"));
							data.setShowerwaterSystemcol3Desc(rs.getString("showerwaterSystemcol3Desc"));
							data.setShowerwaterSystemcol4Desc(rs.getString("showerwaterSystemcol4Desc"));
							data.setShowerwaterSystemcol5Desc(rs.getString("showerwaterSystemcol5Desc"));
							data.setShowerwaterSystemcol6Desc(rs.getString("showerwaterSystemcol6Desc"));
							data.setShowerwaterSystemcol7Desc(rs.getString("showerwaterSystemcol7Desc"));
							data.setShowerwaterSystemcol8Desc(rs.getString("showerwaterSystemcol8Desc"));
							data.setShowerwaterSystemcol9Desc(rs.getString("showerwaterSystemcol9Desc"));
							data.setShowerwaterSystemcol10Desc(rs.getString("showerwaterSystemcol10Desc"));
							data.setShowerwaterSystemcol11Desc(rs.getString("showerwaterSystemcol11Desc"));
							data.setFanpumpcol1Desc(rs.getString("fanpumpcol1Desc"));
							data.setFanpumpcol2Desc(rs.getString("fanpumpcol2Desc"));
							data.setFanpumpcol3Desc(rs.getString("fanpumpcol3Desc"));
							data.setPrimarythinstockscreencol1Desc(rs.getString("primarythinstockscreencol1Desc"));
							data.setPrimarythinstockscreencol2Desc(rs.getString("primarythinstockscreencol2Desc"));
							data.setPrimarythinstockscreencol3Desc(rs.getString("primarythinstockscreencol3Desc"));
							data.setPrimarythinstockscreencol4Desc(rs.getString("primarythinstockscreencol4Desc"));
							data.setVacuumpumpcol1Desc(rs.getString("vacuumpumpcol1Desc"));
							data.setVacuumpumpcol2Desc(rs.getString("vacuumpumpcol2Desc"));
							data.setVacuumpumpcol3Desc(rs.getString("vacuumpumpcol3Desc"));
							data.setVacuumpumpcol4Desc(rs.getString("vacuumpumpcol4Desc"));
							data.setVacuumpumpcol5Desc(rs.getString("vacuumpumpcol5Desc"));
							data.setVacuumpumpcol6Desc(rs.getString("vacuumpumpcol6Desc"));
							data.setVacuumpumpcol7Desc(rs.getString("vacuumpumpcol7Desc"));
							data.setVacuumpumpcol8Desc(rs.getString("vacuumpumpcol8Desc"));
							data.setVacuumpumpcol9Desc(rs.getString("vacuumpumpcol9Desc"));
							data.setVacuumpumpcol10Desc(rs.getString("vacuumpumpcol10Desc"));
							data.setVacuumpumpcol11Desc(rs.getString("vacuumpumpcol11Desc"));
							data.setVacuumpumpcol12Desc(rs.getString("vacuumpumpcol12Desc"));
							data.setVacuumpumpcol13Desc(rs.getString("vacuumpumpcol13Desc"));
							data.setVacuumpumpcol14Desc(rs.getString("vacuumpumpcol14Desc"));
							data.setVacuumpumpcol15Desc(rs.getString("vacuumpumpcol15Desc"));
							data.setVacuumpumpcol16Desc(rs.getString("vacuumpumpcol16Desc"));
							data.setVacuumpumpcol17Desc(rs.getString("vacuumpumpcol17Desc"));
							data.setVacuumpumpcol18Desc(rs.getString("vacuumpumpcol18Desc"));
							
					
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
		
		return leadoperatorpm5;
	}


	/* (non-Javadoc)
	 * @see com.st.oBcc1pm5.dao.LeadOperatorPM5Dao#getDataCountDatePercentage(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public long getDataCountDatePercentage(String position, String sdate,String edate,String shift) throws ParseException {
		
		SimpleDateFormat format=new SimpleDateFormat("MM-dd-yyyy");
		
		List<LeadOperatorPM5> daydata=null, nightdata=null;
		if(shift.equals("both"))
		{
			 daydata=getOperatorDataList(position,sdate,edate,"day");
			 nightdata=getOperatorDataList(position,sdate,edate,"night");
		}else if(shift.equals("day"))
		{
			daydata=getOperatorDataList(position,sdate,edate,"day");
		}
		else
		{
			nightdata=getOperatorDataList(position,sdate,edate,"night");
		}
			
		
		int count=0,no=0;long set=0,daypercent=0,nightpercent=0,percentage=0;
		int days = CommonUtil.getDaysDiffernce(format.parse(sdate), format.parse(edate))+1;
		List<Integer> al=new ArrayList<Integer>();
		List<Integer> al2=new ArrayList<Integer>();
		if(daydata!=null||nightdata!=null)	
		{
			if(shift.equals("day")||shift.equals("both"))
			{
			for(LeadOperatorPM5 data:daydata){
				if(data.isMachinedown()!=true){
				if(data.getFormatingsectioncol1()!=null&&!data.getFormatingsectioncol1().equals("")){count++;}
				if(data.getFormatingsectioncol2()!=null&&!data.getFormatingsectioncol2().equals("")){count++;}
				if(data.getFormatingsectioncol3()!=null&&!data.getFormatingsectioncol3().equals("")){count++;}
				if(data.getFormatingsectioncol4()!=null&&!data.getFormatingsectioncol4().equals("")){count++;}
				if(data.getFormatingsectioncol5()!=null&&!data.getFormatingsectioncol5().equals("")){count++;}
				if(data.getFormatingsectioncol6()!=null&&!data.getFormatingsectioncol6().equals("")){count++;}
				if(data.getFormatingsectioncol7()!=null&&!data.getFormatingsectioncol7().equals("")){count++;}
				if(data.getCouchrollcol1()!=null&&!data.getCouchrollcol1().equals("")){count++;}
				if(data.getCouchrollcol2()!=null&&!data.getCouchrollcol2().equals("")){count++;}
				if(data.getCouchrollcol3()!=null&&!data.getCouchrollcol3().equals("")){count++;}
				if(data.getCouchrollcol4()!=null&&!data.getCouchrollcol4().equals("")){count++;}
				if(data.getCouchrollcol5()!=null&&!data.getCouchrollcol5().equals("")){count++;}
				if(data.isCouchrollcol6()==true||data.isCouchrollcol6()==false){count++;}
				if(data.isCouchrollcol7()==true||data.isCouchrollcol7()==false){count++;}
	
				if(data.getPicupfeltguidecol1()!=null&&!data.getPicupfeltguidecol1().equals("")){count++;}
				if(data.getPicupfeltguidecol2()!=null&&!data.getPicupfeltguidecol2().equals("")){count++;}
				if(data.getPicupfeltguidecol3()!=null&&!data.getPicupfeltguidecol3().equals("")){count++;}
				if(data.getPicupfeltguidecol4()!=null&&!data.getPicupfeltguidecol4().equals("")){count++;}
				if(data.getSuctionpressurerollcol1()!=null&&!data.getSuctionpressurerollcol1().equals("")){count++;}
				if(data.getSuctionpressurerollcol2()!=null&&!data.getSuctionpressurerollcol2().equals("")){count++;}
				if(data.getSuctionpressurerollcol3()!=null&&!data.getSuctionpressurerollcol3().equals("")){count++;}
				if(data.getSuctionpressurerollcol4()!=null&&!data.getSuctionpressurerollcol4().equals("")){count++;}
				if(data.getSuctionpressurerollcol5()!=null&&!data.getSuctionpressurerollcol5().equals("")){count++;}
				if(data.getYankeedryerCol1()!=null&&!data.getYankeedryerCol1().equals("")){count++;}
				if(data.getYankeedryerCol2()!=null&&!data.getYankeedryerCol2().equals("")){count++;}
				if(data.getYankeedryerCol3()!=null&&data.getYankeedryerCol1()!=null&&!data.getYankeedryerCol3().equals("")){count++;}
				if(data.getYankeedryerCol4()!=null&&!data.getYankeedryerCol4().equals("")){count++;}
				if(data.getPressfeltareacol1()!=null&&!data.getPressfeltareacol1().equals("")){count++;}
				if(data.isPressfeltareacol2()==true||data.isPressfeltareacol2()==false){count++;}
				if(data.getPressfeltareacol3()!=null&&!data.getPressfeltareacol3().equals("")){count++;}
				if(data.getPressfeltareacol4()!=null&&!data.getPressfeltareacol4().equals("")){count++;}
				if(data.getPressfeltareacol5()!=null&&!data.getPressfeltareacol5().equals("")){count++;}
				if(data.getPressfeltareacol6()!=null&&!data.getPressfeltareacol6().equals("")){count++;}
				if(data.getPressfeltareacol7()!=null&&!data.getPressfeltareacol7().equals("")){count++;}
				if(data.getPressfeltareacol8()!=null&&!data.getPressfeltareacol8().equals("")){count++;}
				if(data.getLubeoilsystemcol1()!=null&&!data.getLubeoilsystemcol1().equals("")){count++;}
				if(data.getLubeoilsystemcol2()!=null&&!data.getLubeoilsystemcol2().equals("")){count++;}
				if(data.getLubeoilsystemcol3()!=null&&!data.getLubeoilsystemcol3().equals("")){count++;}
				if(data.getLubeoilsystemcol4()!=null&&!data.getLubeoilsystemcol4().equals("")){count++;}
				if(data.getLubeoilsystemcol5()!=null&&!data.getLubeoilsystemcol5().equals("")){count++;}
				if(data.getLubeoilsystemcol6()!=null&&!data.getLubeoilsystemcol6().equals("")){count++;}
				if(data.getLubeoilsystemcol7()!=null&&!data.getLubeoilsystemcol7().equals("")){count++;}
				if(data.isF5abbaccuraycol1()==true||data.isF5abbaccuraycol1()==false){count++;}
				if(data.isF5abbaccuraycol2()==true||data.isF5abbaccuraycol2()==false){count++;}
				if(data.isF5abbaccuraycol3()==true||data.isF5abbaccuraycol3()==false){count++;}
				if(data.isF5abbaccuraycol4()==true||data.isF5abbaccuraycol4()==false){count++;}
				if(data.isF5abbaccuraycol5()==true||data.isF5abbaccuraycol5()==false){count++;}
				if(data.isF5abbaccuraycol6()==true||data.isF5abbaccuraycol6()==false){count++;}
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
			
			for(LeadOperatorPM5 data:nightdata){
				if(data.isMachinedown()!=true) {
				if(data.getShowerwaterSystemcol1()!=null&&!data.getShowerwaterSystemcol1().equals("")){ count++;}
				if(data.getShowerwaterSystemcolin2()!=null&&!data.getShowerwaterSystemcolin2().equals("")){ count++;}
				if(data.getShowerwaterSystemcolout2()!=null&&!data.getShowerwaterSystemcolout2().equals("")){ count++;}
				if(data.getShowerwaterSystemcolin3()!=null&&!data.getShowerwaterSystemcolin3().equals("")){ count++;}
				if(data.getShowerwaterSystemcolout3()!=null&&!data.getShowerwaterSystemcolout3().equals("")){ count++;}
				if(data.isShowerwaterSystemcol4() == true||data.isShowerwaterSystemcol4() == false){ count++;}
				if(data.getShowerwaterSystemcolin5()!=null&&!data.getShowerwaterSystemcolin5().equals("")){ count++;}
				if(data.getShowerwaterSystemcolout5()!=null&&!data.getShowerwaterSystemcolout5().equals("")){ count++;}
				if(data.getShowerwaterSystemcol6()!=null&&!data.getShowerwaterSystemcol6().equals("")){ count++;}
				if(data.getShowerwaterSystemcol7()!=null&&!data.getShowerwaterSystemcol7().equals("")){ count++;}
				if(data.getShowerwaterSystemcolin8()!=null&&!data.getShowerwaterSystemcolin8().equals("")){ count++;}
				if(data.getShowerwaterSystemcolout8()!=null&&!data.getShowerwaterSystemcolout8().equals("")){ count++;}
				if(data.isShowerwaterSystemcol9() == true||data.isShowerwaterSystemcol9() == false){ count++;}
				if(data.getShowerwaterSystemcol1()!=null&&!data.getShowerwaterSystemcol10().equals("")){ count++;}
				if(data.getShowerwaterSystemcol1()!=null&&!data.getShowerwaterSystemcol11().equals("")){ count++;}
				if(data.getFanpumpcol1()!=null&&!data.getFanpumpcol1().equals("")){ count++;}
				if(data.getFanpumpcolin2()!=null&&!data.getFanpumpcolin2().equals("")){ count++;}
				if(data.getFanpumpcolout2()!=null&&!data.getFanpumpcolout2().equals("")){ count++;}
				if(data.isFanpumpcol3() == true||data.isFanpumpcol3() == false){ count++;}
				if(data.getPrimarythinstockscreencol1()!=null&&!data.getPrimarythinstockscreencol1().equals("")){ count++;}
				if(data.getPrimarythinstockscreencol2()!=null&&!data.getPrimarythinstockscreencol2().equals("")){ count++;}
				if(data.getPrimarythinstockscreencol3()!=null&&!data.getPrimarythinstockscreencol3().equals("")){ count++;}
				if(data.isPrimarythinstockscreencol4() == true||data.isPrimarythinstockscreencol4() == false){ count++;}
				if(data.isVacuumpumpcol1() == true||data.isVacuumpumpcol1() == false){ count++;}
				if(data.getVacuumpumpcolin2()!=null&&!data.getVacuumpumpcolin2().equals("")){ count++;}
				if(data.getVacuumpumpcolout2()!=null&&!data.getVacuumpumpcolout2().equals("")){ count++;}
				if(data.getVacuumpumpcol3()!=null&&!data.getVacuumpumpcol3().equals("")){ count++;}
				if(data.getVacuumpumpcol4()!=null&&!data.getVacuumpumpcol4().equals("")){ count++;}
				if(data.getVacuumpumpcol5()!=null&&!data.getVacuumpumpcol5().equals("")){ count++;}
				if(data.getVacuumpumpcol6()!=null&&!data.getVacuumpumpcol6().equals("")){ count++;}
				if(data.getVacuumpumpcol7()!=null&&!data.getVacuumpumpcol7().equals("")){ count++;}
				if(data.getVacuumpumpcol8()!=null&&!data.getVacuumpumpcol8().equals("")){ count++;}
				if(data.getVacuumpumpcol9()!=null&&!data.getVacuumpumpcol9().equals("")){ count++;}
				if(data.getVacuumpumpcol10()!=null&&!data.getVacuumpumpcol10().equals("")){ count++;}
				if(data.getVacuumpumpcol11()!=null&&!data.getVacuumpumpcol11().equals("")){ count++;}
				if(data.getVacuumpumpcol12()!=null&&!data.getVacuumpumpcol12().equals("")){ count++;}
				if(data.getVacuumpumpcol13()!=null&&!data.getVacuumpumpcol13().equals("")){ count++;}
				if(data.getVacuumpumpcol14()!=null&&!data.getVacuumpumpcol14().equals("")){ count++;}
				if(data.getVacuumpumpcol15()!=null&&!data.getVacuumpumpcol15().equals("")){ count++;}
				if(data.getVacuumpumpcol16()!=null&&!data.getVacuumpumpcol16().equals("")){ count++;}
				if(data.getVacuumpumpcol17()!=null&&!data.getVacuumpumpcol17().equals("")){ count++;}
				if(data.getVacuumpumpcol18()!=null&&!data.getVacuumpumpcol18().equals("")){ count++;}
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

}

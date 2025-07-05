/**
 *Mar 17, 2018
 *UtilityOperatorDaoPM5Impl.java
 * TODO
 *com.st.obccPM5.dao
 *UtilityOperatorDaoPM5Impl.java
 *Roshan Lal Tailor
 */
package com.st.obccPM5.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.st.common.CommonUtil;
import com.st.obccPM5.model.UtilityOperatorPM5;

/**
 * @author roshan
 *
 */
@Repository
public class UtilityOperatorDaoPM5Imp implements UtilityOperatorPM5Dao{

	@Autowired
	@Qualifier("dataSourceOBCC")
	private DataSource dataSourceQRT;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.st.obcc.dao.UtilityOperatorDao#getOperatorData(java.lang.String,
	 * java.lang.String, java.lang.String, java.lang.String)
	 */
	
	private SimpleDateFormat dateFormat=new SimpleDateFormat("MM-dd-yyyy");
	private SimpleDateFormat fromuser=new SimpleDateFormat("yyyy-MM-dd");
	
	@Override
	public UtilityOperatorPM5 getOperatorData(String position, String shift,
			String date, String crew) throws Exception {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSourceQRT);
		String sql = "select * from [utilityOperator_pm5] where [position]=? AND [date]=? AND [shift] = ?";
		UtilityOperatorPM5 utilityOperator = null;
		try {
			utilityOperator = jdbcTemplate.queryForObject(sql, new Object[] {
					position, date, shift },
					new RowMapper<UtilityOperatorPM5>() {

						@Override
						public UtilityOperatorPM5 mapRow(ResultSet rs, int arg1)
								throws SQLException {
							UtilityOperatorPM5 data = new UtilityOperatorPM5();
							data.setId(rs.getInt("id"));
							data.setPosition(rs.getString("position"));
							data.setOperatorName(rs.getString("operator_name"));
							data.setEdate(rs.getString("date"));
							data.setShift(rs.getString("shift"));
							data.setCrew(rs.getString("crew"));
							data.setMachinedown(rs.getBoolean("machinedown"));
							data.setChecklistcompleted(rs.getBoolean("checklistcompleted"));
							data.setClampscleanofburrs(rs.getBoolean("clampscleanofburrs"));
							data.setAnyvisibleissue(rs.getBoolean("anyvisibleissue"));
							data.setMotorizedhandtruck(rs.getBoolean("motorizedhandtruck"));
							data.setBatterychangesandcableintact(rs.getBoolean("batterychangesandcableintact"));
							data.setCautionlightoperational(rs.getBoolean("cautionlightoperational"));
							data.setControlarmoperatingproperly(rs.getBoolean("controlarmoperatingproperly"));
							data.setAnymovementissue(rs.getBoolean("anymovementissue"));
							data.setHandtruckblowdown(rs.getBoolean("handtruckblowdown"));
							data.setLiftingproperly(rs.getBoolean("liftingproperly"));
							data.setBothfoldoutwingsopenorclosed(rs.getBoolean("bothfoldoutwingsopenorclosed"));
							data.setBotharetobeopenedandclosedatthesametime(rs.getBoolean("botharetobeopenedandclosedatthesametime"));
							data.setAlllocksoperational(rs.getBoolean("alllocksoperational"));
							data.setAlllightintactandworking(rs.getBoolean("alllightintactandworking"));
							data.setGladhandlocksbeingused(rs.getBoolean("gladhandlocksbeingused"));
							
							data.setChecklistcompletedDesc(rs.getString("checklistcompletedDesc"));
							data.setClampscleanofburrsDesc(rs.getString("clampscleanofburrsDesc"));
							data.setAnyvisibleissueDesc(rs.getString("anyvisibleissueDesc"));
							data.setMotorizedhandtruckDesc(rs.getString("motorizedhandtruckDesc"));
							data.setBatterychangesandcableintactDesc(rs.getString("batterychangesandcableintactDesc"));
							data.setCautionlightoperationalDesc(rs.getString("cautionlightoperationalDesc"));
							data.setControlarmoperatingproperlyDesc(rs.getString("controlarmoperatingproperlyDesc"));
							data.setAnymovementissueDesc(rs.getString("anymovementissueDesc"));
							data.setHandtruckblowdownDesc(rs.getString("handtruckblowdownDesc"));
							data.setLiftingproperlyDesc(rs.getString("liftingproperlyDesc"));
							data.setBothfoldoutwingsopenorclosedDesc(rs.getString("bothfoldoutwingsopenorclosedDesc"));
							data.setBotharetobeopenedandclosedatthesametimeDesc(rs.getString("botharetobeopenedandclosedatthesametimeDesc"));
							data.setAlllocksoperationalDesc(rs.getString("alllocksoperationalDesc"));
							data.setAlllightintactandworkingDesc(rs.getString("alllightintactandworkingDesc"));
							data.setGladhandlocksbeingusedDesc(rs.getString("gladhandlocksbeingusedDesc"));
							return data;
						}

					});
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return utilityOperator;

	}

	
	
	
	
	/* (non-Javadoc)
	 * @see com.st.obcc.dao.UtilityOperatorDao#getOperatorDataList(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public List<UtilityOperatorPM5> getOperatorDataList(String position,String shift,
			String Sdate, String edate) throws Exception {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSourceQRT);
		String sql = "select * from [utilityOperator_pm5] where position=? AND shift=? AND date BETWEEN ? AND ? ";
		List<UtilityOperatorPM5> lst = new ArrayList<UtilityOperatorPM5>();
		try {
			lst = jdbcTemplate.query(sql, new Object[] {position,shift, Sdate, edate },new RowMapper<UtilityOperatorPM5>() {

						@Override
						public UtilityOperatorPM5 mapRow(ResultSet rs, int arg1)
								throws SQLException {
							UtilityOperatorPM5 data = new UtilityOperatorPM5();
							
							try {
								String newDate = dateFormat.format(fromuser.parse(rs.getString("date")));
							
							
							data.setId(rs.getInt("id"));
							data.setPosition(rs.getString("position"));
							data.setOperatorName(rs.getString("operator_name"));
							data.setEdate(newDate);
							data.setShift(rs.getString("shift"));
							data.setCrew(rs.getString("crew"));
							

							data.setMachinedown(rs.getBoolean("machinedown"));
							data.setChecklistcompleted(rs.getBoolean("checklistcompleted"));
							data.setClampscleanofburrs(rs.getBoolean("clampscleanofburrs"));
							data.setAnyvisibleissue(rs.getBoolean("anyvisibleissue"));
							data.setMotorizedhandtruck(rs.getBoolean("motorizedhandtruck"));
							data.setBatterychangesandcableintact(rs.getBoolean("batterychangesandcableintact"));
							data.setCautionlightoperational(rs.getBoolean("cautionlightoperational"));
							data.setControlarmoperatingproperly(rs.getBoolean("controlarmoperatingproperly"));
							data.setAnymovementissue(rs.getBoolean("anymovementissue"));
							data.setHandtruckblowdown(rs.getBoolean("handtruckblowdown"));
							data.setLiftingproperly(rs.getBoolean("liftingproperly"));
							data.setBothfoldoutwingsopenorclosed(rs.getBoolean("bothfoldoutwingsopenorclosed"));
							data.setBotharetobeopenedandclosedatthesametime(rs.getBoolean("botharetobeopenedandclosedatthesametime"));
							data.setAlllocksoperational(rs.getBoolean("alllocksoperational"));
							data.setAlllightintactandworking(rs.getBoolean("alllightintactandworking"));
							data.setGladhandlocksbeingused(rs.getBoolean("gladhandlocksbeingused"));
							
							data.setChecklistcompletedDesc(rs.getString("checklistcompletedDesc"));
							data.setClampscleanofburrsDesc(rs.getString("clampscleanofburrsDesc"));
							data.setAnyvisibleissueDesc(rs.getString("anyvisibleissueDesc"));
							data.setMotorizedhandtruckDesc(rs.getString("motorizedhandtruckDesc"));
							data.setBatterychangesandcableintactDesc(rs.getString("batterychangesandcableintactDesc"));
							data.setCautionlightoperationalDesc(rs.getString("cautionlightoperationalDesc"));
							data.setControlarmoperatingproperlyDesc(rs.getString("controlarmoperatingproperlyDesc"));
							data.setAnymovementissueDesc(rs.getString("anymovementissueDesc"));
							data.setHandtruckblowdownDesc(rs.getString("handtruckblowdownDesc"));
							data.setLiftingproperlyDesc(rs.getString("liftingproperlyDesc"));
							data.setBothfoldoutwingsopenorclosedDesc(rs.getString("bothfoldoutwingsopenorclosedDesc"));
							data.setBotharetobeopenedandclosedatthesametimeDesc(rs.getString("botharetobeopenedandclosedatthesametimeDesc"));
							data.setAlllocksoperationalDesc(rs.getString("alllocksoperationalDesc"));
							data.setAlllightintactandworkingDesc(rs.getString("alllightintactandworkingDesc"));
							data.setGladhandlocksbeingusedDesc(rs.getString("gladhandlocksbeingusedDesc"));
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

		return lst;
	}
	
	@Override
	public List<UtilityOperatorPM5> getOperatorDataListForBothShift(String position,String Sdate, String edate) throws Exception {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSourceQRT);
		String sql = "select * from [utilityOperator_pm5] where position=?  AND date BETWEEN ? AND ? order by date";
		List<UtilityOperatorPM5> lst = new ArrayList<UtilityOperatorPM5>();
		try {
			lst = jdbcTemplate.query(sql, new Object[] {position, Sdate, edate },new RowMapper<UtilityOperatorPM5>() {

						@Override
						public UtilityOperatorPM5 mapRow(ResultSet rs, int arg1)
								throws SQLException {
							UtilityOperatorPM5 data = new UtilityOperatorPM5();
							
							try {
								String newDate = dateFormat.format(fromuser.parse(rs.getString("date")));
							
							
							data.setId(rs.getInt("id"));
							data.setPosition(rs.getString("position"));
							data.setOperatorName(rs.getString("operator_name"));
							data.setEdate(newDate);
							data.setShift(rs.getString("shift"));
							data.setCrew(rs.getString("crew"));
							

							data.setMachinedown(rs.getBoolean("machinedown"));
							data.setChecklistcompleted(rs.getBoolean("checklistcompleted"));
							data.setClampscleanofburrs(rs.getBoolean("clampscleanofburrs"));
							data.setAnyvisibleissue(rs.getBoolean("anyvisibleissue"));
							data.setMotorizedhandtruck(rs.getBoolean("motorizedhandtruck"));
							data.setBatterychangesandcableintact(rs.getBoolean("batterychangesandcableintact"));
							data.setCautionlightoperational(rs.getBoolean("cautionlightoperational"));
							data.setControlarmoperatingproperly(rs.getBoolean("controlarmoperatingproperly"));
							data.setAnymovementissue(rs.getBoolean("anymovementissue"));
							data.setHandtruckblowdown(rs.getBoolean("handtruckblowdown"));
							data.setLiftingproperly(rs.getBoolean("liftingproperly"));
							data.setBothfoldoutwingsopenorclosed(rs.getBoolean("bothfoldoutwingsopenorclosed"));
							data.setBotharetobeopenedandclosedatthesametime(rs.getBoolean("botharetobeopenedandclosedatthesametime"));
							data.setAlllocksoperational(rs.getBoolean("alllocksoperational"));
							data.setAlllightintactandworking(rs.getBoolean("alllightintactandworking"));
							data.setGladhandlocksbeingused(rs.getBoolean("gladhandlocksbeingused"));
							
							data.setChecklistcompletedDesc(rs.getString("checklistcompletedDesc"));
							data.setClampscleanofburrsDesc(rs.getString("clampscleanofburrsDesc"));
							data.setAnyvisibleissueDesc(rs.getString("anyvisibleissueDesc"));
							data.setMotorizedhandtruckDesc(rs.getString("motorizedhandtruckDesc"));
							data.setBatterychangesandcableintactDesc(rs.getString("batterychangesandcableintactDesc"));
							data.setCautionlightoperationalDesc(rs.getString("cautionlightoperationalDesc"));
							data.setControlarmoperatingproperlyDesc(rs.getString("controlarmoperatingproperlyDesc"));
							data.setAnymovementissueDesc(rs.getString("anymovementissueDesc"));
							data.setHandtruckblowdownDesc(rs.getString("handtruckblowdownDesc"));
							data.setLiftingproperlyDesc(rs.getString("liftingproperlyDesc"));
							data.setBothfoldoutwingsopenorclosedDesc(rs.getString("bothfoldoutwingsopenorclosedDesc"));
							data.setBotharetobeopenedandclosedatthesametimeDesc(rs.getString("botharetobeopenedandclosedatthesametimeDesc"));
							data.setAlllocksoperationalDesc(rs.getString("alllocksoperationalDesc"));
							data.setAlllightintactandworkingDesc(rs.getString("alllightintactandworkingDesc"));
							data.setGladhandlocksbeingusedDesc(rs.getString("gladhandlocksbeingusedDesc"));
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

		return lst;
	}
	 
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.st.obcc.dao.UtilityOperatorDao#saveorUpdate(com.st.obcc.model.
	 * UtilityOperator)
	 */
	@Override
	public void saveorUpdate(final UtilityOperatorPM5 utilityOperatorPM5) {
		// TODO Auto-generated method stub

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSourceQRT);

		if (utilityOperatorPM5.getId() == 0) {

			String sql = "insert into utilityOperator_pm5 ([position],[operator_name],[date],[crew],[shift],[checklistcompleted],[clampscleanofburrs],"
					+"[anyvisibleissue],[motorizedhandtruck],[batterychangesandcableintact],"
					+"[cautionlightoperational],[controlarmoperatingproperly],[anymovementissue],"
					+"[handtruckblowdown],[liftingproperly],[bothfoldoutwingsopenorclosed],[botharetobeopenedandclosedatthesametime],"
					+"[alllocksoperational],[alllightintactandworking],[gladhandlocksbeingused],[checklistcompletedDesc],"
					+"[clampscleanofburrsDesc],[anyvisibleissueDesc],[motorizedhandtruckDesc],[batterychangesandcableintactDesc],"
					+"[cautionlightoperationalDesc],[controlarmoperatingproperlyDesc],[anymovementissueDesc],"
					+"[handtruckblowdownDesc],[liftingproperlyDesc],[bothfoldoutwingsopenorclosedDesc],[botharetobeopenedandclosedatthesametimeDesc],[alllocksoperationalDesc],"
					+"[alllightintactandworkingDesc],[gladhandlocksbeingusedDesc],[machinedown]) "
					+" values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

			jdbcTemplate.update(
					sql,
					new Object[] { 
							utilityOperatorPM5.getPosition(),
							utilityOperatorPM5.getOperatorName(),
							utilityOperatorPM5.getEdate(),
							utilityOperatorPM5.getCrew(),
							utilityOperatorPM5.getShift(),
							utilityOperatorPM5.isChecklistcompleted(),
							utilityOperatorPM5.isClampscleanofburrs(),
							utilityOperatorPM5.isAnyvisibleissue(),
							utilityOperatorPM5.isMotorizedhandtruck(),
							utilityOperatorPM5.isBatterychangesandcableintact(),
							utilityOperatorPM5.isCautionlightoperational(),
							utilityOperatorPM5.isControlarmoperatingproperly(),
							utilityOperatorPM5.isAnymovementissue(),
							utilityOperatorPM5.isHandtruckblowdown(),
							utilityOperatorPM5.isLiftingproperly(),
							utilityOperatorPM5.isBothfoldoutwingsopenorclosed(),
							utilityOperatorPM5.isBotharetobeopenedandclosedatthesametime(),
							utilityOperatorPM5.isAlllocksoperational(),
							utilityOperatorPM5.isAlllightintactandworking(),
							utilityOperatorPM5.isGladhandlocksbeingused(),
							utilityOperatorPM5.getChecklistcompletedDesc(),
							utilityOperatorPM5.getClampscleanofburrsDesc(),
							utilityOperatorPM5.getAnyvisibleissueDesc(),
							utilityOperatorPM5.getMotorizedhandtruckDesc(),
							utilityOperatorPM5.getBatterychangesandcableintactDesc(),
							utilityOperatorPM5.getCautionlightoperationalDesc(),
							utilityOperatorPM5.getControlarmoperatingproperlyDesc(),
							utilityOperatorPM5.getAnymovementissueDesc(),
							utilityOperatorPM5.getHandtruckblowdownDesc(),
							utilityOperatorPM5.getLiftingproperlyDesc(),
							utilityOperatorPM5.getBothfoldoutwingsopenorclosedDesc(),
							utilityOperatorPM5.getBotharetobeopenedandclosedatthesametimeDesc(),
							utilityOperatorPM5.getAlllocksoperationalDesc(),
							utilityOperatorPM5.getAlllightintactandworkingDesc(),
							utilityOperatorPM5.getGladhandlocksbeingusedDesc(),
							utilityOperatorPM5.isMachinedown()
					});

		} else {

			final String sql = "UPDATE [utilityOperator_pm5] SET [position] = ?,[operator_name] = ?,[date] = ?,[crew] = ?,[shift] = ?,[checklistcompleted] = ?,[clampscleanofburrs] = ?," + 
					"[anyvisibleissue] = ?,[motorizedhandtruck] = ?,[batterychangesandcableintact] = ?," + 
					"[cautionlightoperational] = ?,[controlarmoperatingproperly] = ?,[anymovementissue] = ?," + 
					"[handtruckblowdown] = ?,[liftingproperly] = ?,[bothfoldoutwingsopenorclosed] = ?,[botharetobeopenedandclosedatthesametime] = ?," + 
					"[alllocksoperational] = ?,[alllightintactandworking] = ?,[gladhandlocksbeingused] = ?,[checklistcompletedDesc] = ?," + 
					"[clampscleanofburrsDesc] = ?,[anyvisibleissueDesc] = ?,[motorizedhandtruckDesc] = ?,[batterychangesandcableintactDesc] = ?," + 
					"[cautionlightoperationalDesc] = ?,[controlarmoperatingproperlyDesc] = ?,[anymovementissueDesc] = ?," + 
					"[handtruckblowdownDesc] = ?,[liftingproperlyDesc] = ?,[bothfoldoutwingsopenorclosedDesc] = ?,[botharetobeopenedandclosedatthesametimeDesc] = ?,[alllocksoperationalDesc] = ?," + 
					"[alllightintactandworkingDesc] = ?,[gladhandlocksbeingusedDesc]=?,[machinedown] = ? WHERE [id]= ?";

			jdbcTemplate.update(new PreparedStatementCreator() {

				@Override
				public PreparedStatement createPreparedStatement(Connection arg0)
						throws SQLException {
					PreparedStatement statement = arg0.prepareStatement(sql);
					statement.setString(1, utilityOperatorPM5.getPosition());
					statement.setString(2, utilityOperatorPM5.getOperatorName());
					statement.setString(3, utilityOperatorPM5.getEdate());
					statement.setString(4, utilityOperatorPM5.getCrew());
					statement.setString(5, utilityOperatorPM5.getShift());

					statement.setBoolean(6,utilityOperatorPM5.isChecklistcompleted());
					statement.setBoolean(7,utilityOperatorPM5.isClampscleanofburrs());
					statement.setBoolean(8,utilityOperatorPM5.isAnyvisibleissue());
					statement.setBoolean(9,utilityOperatorPM5.isMotorizedhandtruck());
					statement.setBoolean(10,utilityOperatorPM5.isBatterychangesandcableintact());
					statement.setBoolean(11,utilityOperatorPM5.isCautionlightoperational());
					statement.setBoolean(12,utilityOperatorPM5.isControlarmoperatingproperly());
					statement.setBoolean(13,utilityOperatorPM5.isAnymovementissue());
					statement.setBoolean(14,utilityOperatorPM5.isHandtruckblowdown());
					statement.setBoolean(15,utilityOperatorPM5.isLiftingproperly());
					statement.setBoolean(16,utilityOperatorPM5.isBothfoldoutwingsopenorclosed());
					statement.setBoolean(17,utilityOperatorPM5.isBotharetobeopenedandclosedatthesametime());
					statement.setBoolean(18,utilityOperatorPM5.isAlllocksoperational());
					statement.setBoolean(19,utilityOperatorPM5.isAlllightintactandworking());
					statement.setBoolean(20,utilityOperatorPM5.isGladhandlocksbeingused());
					
					statement.setString(21,utilityOperatorPM5.getChecklistcompletedDesc());
					statement.setString(22,utilityOperatorPM5.getClampscleanofburrsDesc());
					statement.setString(23,utilityOperatorPM5.getAnyvisibleissueDesc());
					statement.setString(24,utilityOperatorPM5.getMotorizedhandtruckDesc());
					statement.setString(25,utilityOperatorPM5.getBatterychangesandcableintactDesc());
					statement.setString(26,utilityOperatorPM5.getCautionlightoperationalDesc());
					statement.setString(27,utilityOperatorPM5.getControlarmoperatingproperlyDesc());
					statement.setString(28,utilityOperatorPM5.getAnymovementissueDesc());
					statement.setString(29,utilityOperatorPM5.getHandtruckblowdownDesc());
					statement.setString(30,utilityOperatorPM5.getLiftingproperlyDesc());
					statement.setString(31,utilityOperatorPM5.getBothfoldoutwingsopenorclosedDesc());
					statement.setString(32,utilityOperatorPM5.getBotharetobeopenedandclosedatthesametimeDesc());
					statement.setString(33,utilityOperatorPM5.getAlllocksoperationalDesc());
					statement.setString(34,utilityOperatorPM5.getAlllightintactandworkingDesc());
					statement.setString(35,utilityOperatorPM5.getGladhandlocksbeingusedDesc());
					statement.setBoolean(36,utilityOperatorPM5.isMachinedown());
					
					statement.setInt(37, utilityOperatorPM5.getId());
					return statement;
				}
			});

		}

	}





	/* (non-Javadoc)
	 * @see com.st.obcc.dao.UtilityOperatorDao#getDataCountDatePercentage(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public long getDataCountDatePercentage(String position, String shift, String sdate,String edate) throws Exception {
		
			SimpleDateFormat format=new SimpleDateFormat("MM-dd-yyyy");
			
			List<UtilityOperatorPM5 > daydata=null, nightdata=null;
			if(shift.equals("both"))
			{
				 daydata=getOperatorDataList(position,"day",sdate, edate);
				 nightdata=getOperatorDataList(position,"night",sdate, edate);
			}else if(shift.equals("day"))
			{
				daydata=getOperatorDataList(position,"day",sdate, edate);
			}
			else
			{
				nightdata=getOperatorDataList(position,"night",sdate, edate);
			}
				
			
			int count=0,no=0;long set=0,daypercent=0,nightpercent=0,percentage=0;
			int days = CommonUtil.getDaysDiffernce(format.parse(sdate), format.parse(edate))+1;
			List<Integer> al=new ArrayList<Integer>();
			List<Integer> al2=new ArrayList<Integer>();
			if(daydata!=null||nightdata!=null)	
		{
			if(shift.equals("day")||shift.equals("both"))
			{
				for(UtilityOperatorPM5 data:daydata)
				{
					if(data.isMachinedown()!=true)
					{
						if(data.isChecklistcompleted()== true){count++;}
						if(data.isClampscleanofburrs()== true){count++;}
						if(data.isAnyvisibleissue()== true){count++;}
						if(data.isMotorizedhandtruck()== true){count++;}
						if(data.isBatterychangesandcableintact()== true){count++;}
						if(data.isCautionlightoperational()== true){count++;}
						if(data.isControlarmoperatingproperly()== true){count++;}
						if(data.isAnymovementissue()== true){count++;}
						if(data.isHandtruckblowdown()== true){count++;}
						if(data.isLiftingproperly()== true){count++;}
						if(data.isBothfoldoutwingsopenorclosed()== true){count++;}
						if(data.isBotharetobeopenedandclosedatthesametime()== true){count++;}
						if(data.isAlllocksoperational()== true){count++;}
						if(data.isAlllightintactandworking()== true){count++;}
						if(data.isGladhandlocksbeingused()== true){count++;}

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
				 for(UtilityOperatorPM5 data:nightdata)
				{
					 if(data.isMachinedown()!=true)
					{
						 if(data.isChecklistcompleted()== true){count++;}
						 if(data.isClampscleanofburrs()== true){count++;}
						 if(data.isAnyvisibleissue()== true){count++;}
						 if(data.isMotorizedhandtruck()== true){count++;}
						 if(data.isBatterychangesandcableintact()== true){count++;}
						 if(data.isCautionlightoperational()== true){count++;}
						 if(data.isControlarmoperatingproperly()== true){count++;}
						 if(data.isAnymovementissue()== true){count++;}
						 if(data.isHandtruckblowdown()== true){count++;}
						 if(data.isLiftingproperly()== true){count++;}
						 if(data.isBothfoldoutwingsopenorclosed()== true){count++;}
						 if(data.isBotharetobeopenedandclosedatthesametime()== true){count++;}
						 if(data.isAlllocksoperational()== true){count++;}
						 if(data.isAlllightintactandworking()== true){count++;}
						 if(data.isGladhandlocksbeingused()== true){count++;}
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
}

/**
 * 
 */
package com.st.efficiencypm5.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.st.common.CommonUtil;
import com.st.common.DatabaseUtil;
import com.st.efficiencypm5.mapper.DCSReelTonMapperPM5;
import com.st.efficiencypm5.model.EfficiencyPM5;
import com.st.efficiencypm5.model.EfficiencyShiftDataPM5;
import com.st.efficiencypm5.model.PrimaryCodePM5;
import com.st.efficiencypm5.model.SecondaryCodePM5;

/**
 * @author sbora
 *
 */
@Repository
public class EfficiencyDaoImpPM5 implements EfficiencyDaoPM5 {

	@Autowired
	private DataSource dataSource;
	
	@Autowired
	@Qualifier("dataSourceProduction")
	private DataSource dataSourceP;
	
	@Override
	public int add(final EfficiencyPM5 efficency) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		KeyHolder holder=new GeneratedKeyHolder();
		
		final String sql="insert into [efficiencyData_pm5]"
				+ "("
				+"[Date],"
				+"[Shift],"
				+"[Crew],"
				+"[StartTime],"
				+"[EndTime],"
				+"[Reel],"
				+"[GradeCode],"
				+"[Comment],"
				+"[SecodaryCode]"
				+ ") values(?,?,?,?,?,?,?,?,?)";
		
			jdbcTemplate.update(new PreparedStatementCreator() {
				
				@Override
				public PreparedStatement createPreparedStatement(Connection arg0)
						throws SQLException {
					PreparedStatement statement=arg0.prepareStatement(sql, new String[]{"ID"});
					statement.setTimestamp(1, new Timestamp(CommonUtil.getDateTime(efficency.getDate(), efficency.getStartTime()).getTime()));
					statement.setString(2, efficency.getShift());
					statement.setString(3, efficency.getCrew());
					statement.setTimestamp(4, efficency.getStartTime());
					statement.setTimestamp(5, efficency.getEndTime());
					statement.setString(6, efficency.getReel());
					statement.setString(7, efficency.getGradeCode());
					statement.setString(8, efficency.getComment());
					statement.setInt(9, efficency.getSecondaryCode().getId());
					
					return statement;
				}
			},holder);
		
		return holder.getKey().intValue();
	}

	
	@Override
	public List<EfficiencyPM5> getEfficiencies(EfficiencyPM5 efficiency) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		String sql="SELECT "
				+ "d.[ID],"
				+ "d.[Date],"
				+ "d.[Shift],"
				+ "d.[Crew],"
				+ "d.[StartTime],"
				+ "d.[EndTime],"
				+ "d.[Reel],"
				+ "d.[GradeCode],"
				+ "d.[Comment],"
				+ "sc.[code] as scode,"
				+ "sc.[ID] as sid,"
				+ "pc.[code] as pcode,"
				+ "pc.[Type] as ptype"
				+ " FROM [efficiencyData_pm5] d,"
				+ "efficiencySecondaryCode_pm5 sc,"
				+ "efficiencyPrimaryCode_pm5 pc "
				+ " where ( d.[Date] between ? and ?) and "
				+ "sc.[ID]=d.[SecodaryCode] and "
				+ "pc.[ID]=sc.[PrimaryCodeID] ";
		
			if(efficiency.getPcode()!=null && !(efficiency.getPcode().trim().equals(""))){
				sql+=" and pc.[ID]="+efficiency.getPcode()+" ";
			}
			
			if(efficiency.getScode()!=null && !(efficiency.getScode().trim().equals(""))){
				sql+=" and sc.[ID]="+efficiency.getScode()+" ";
			}
		
			sql+=" order by d.[Date]";
			
			/*List<Efficiency> efficiencies=jdbcTemplate.query(sql, new Object[]{
					new Date(efficiency.getStartDate().getTime()),
					new Date(efficiency.getEndDate().getTime())
			}, new RowMapper<Efficiency>() {
*/
			SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy HH:mm:ss");
			
			List<EfficiencyPM5> efficiencies=jdbcTemplate.query(sql, new Object[]{
						sdf.format(efficiency.getStartDate()),
						sdf.format(efficiency.getEndDate())
			}, new RowMapper<EfficiencyPM5>() {
			
				@Override
				public EfficiencyPM5 mapRow(ResultSet rs, int arg1)
						throws SQLException {
					EfficiencyPM5 efficiency=new EfficiencyPM5();
					efficiency.setId(rs.getInt("ID"));
					efficiency.setDate(new Date(rs.getTimestamp("Date").getTime()));
					efficiency.setShift(rs.getString("Shift"));
					efficiency.setCrew(rs.getString("Crew"));
					efficiency.setStartTime(rs.getTimestamp("StartTime"));
					efficiency.setEndTime(rs.getTimestamp("EndTime"));
					efficiency.setReel(rs.getString("Reel"));
					efficiency.setGradeCode(rs.getString("GradeCode"));
					efficiency.setComment(rs.getString("Comment"));
					
					SecondaryCodePM5 secondaryCode=new SecondaryCodePM5();
					secondaryCode.setCode(rs.getString("scode"));
					secondaryCode.setId(rs.getInt("sid"));
					efficiency.setSecondaryCode(secondaryCode);
					
					PrimaryCodePM5 primaryCode=new PrimaryCodePM5();
					primaryCode.setCode(rs.getString("pcode"));
					primaryCode.setType(rs.getInt("ptype"));
					secondaryCode.setPrimaryCode(primaryCode);
					
					efficiency.setFendTimeHH(""+CommonUtil.getHoursDuration(new Date(efficiency.getStartTime().getTime()), new Date(efficiency.getEndTime().getTime())));
					efficiency.setFendTimeMM(""+CommonUtil.getMinutesDuration(new Date(efficiency.getStartTime().getTime()), new Date(efficiency.getEndTime().getTime())));
					
					
					
					return efficiency;
				}
			});
		
		return efficiencies;
	}


	
	@Override
	public EfficiencyPM5 getEfficiency(int id) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		String sql="SELECT "
				+ "d.[ID],"
				+ "d.[Date],"
				+ "d.[Shift],"
				+ "d.[Crew],"
				+ "d.[StartTime],"
				+ "d.[EndTime],"
				+ "d.[Reel],"
				+ "d.[GradeCode],"
				+ "d.[Comment],"
				+ "sc.[ID] as sid,"
				+ "sc.[code] as scode,"
				+ "pc.[code] as pcode"
				+ " FROM [efficiencyData_pm5] d,"
				+ "efficiencySecondaryCode_pm5 sc,"
				+ "efficiencyPrimaryCode_pm5 pc "
				+ " where d.[ID]=?"
				+ " and "
				+ "sc.[ID]=d.[SecodaryCode]"
				+ " and "
				+ "pc.[ID]=sc.[PrimaryCodeID]";
		
		EfficiencyPM5 efficiency=jdbcTemplate.queryForObject(sql, new Object[]{id}, new RowMapper<EfficiencyPM5>() {

			@Override
			public EfficiencyPM5 mapRow(ResultSet rs, int arg1)
					throws SQLException {
				EfficiencyPM5 efficiency=new EfficiencyPM5();
				efficiency.setId(rs.getInt("ID"));
				efficiency.setDate(new Date(rs.getTimestamp("Date").getTime()));
				efficiency.setShift(rs.getString("Shift"));
				efficiency.setCrew(rs.getString("Crew"));
				efficiency.setStartTime(rs.getTimestamp("StartTime"));
				efficiency.setEndTime(rs.getTimestamp("EndTime"));
				efficiency.setReel(rs.getString("Reel"));
				efficiency.setGradeCode(rs.getString("GradeCode"));
				efficiency.setComment(rs.getString("Comment"));
				
				SecondaryCodePM5 secondaryCode=new SecondaryCodePM5();
				secondaryCode.setCode(rs.getString("scode"));
				secondaryCode.setId(rs.getInt("sid"));
				efficiency.setSecondaryCode(secondaryCode);
				
				PrimaryCodePM5 primaryCode=new PrimaryCodePM5();
				primaryCode.setCode(rs.getString("pcode"));
				secondaryCode.setPrimaryCode(primaryCode);
				
				return efficiency;
			}
		
		});
		return efficiency;
	}


	/* (non-Javadoc)
	 * @see com.st.efficiency.dao.EfficiencyDao#update(com.st.efficiency.model.Efficiency)
	 */
	@Override
	public void update(final EfficiencyPM5 efficency) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		
		final String sql="update[efficiencyData_pm5] set "
				+"[Date]=?,"
				+"[Shift]=?,"
				+"[Crew]=?,"
				+"[StartTime]=?,"
				+"[EndTime]=?,"
				+"[Reel]=?,"
				+"[GradeCode]=?,"
				+"[Comment]=?,"
				+"[SecodaryCode]=?"
				+ " where [ID]=? ";
		
			jdbcTemplate.update(new PreparedStatementCreator() {
				
				@Override
				public PreparedStatement createPreparedStatement(Connection arg0)
						throws SQLException {
					PreparedStatement statement=arg0.prepareStatement(sql);
					statement.setTimestamp(1, new Timestamp(CommonUtil.getDateTime(efficency.getDate(), efficency.getStartTime()).getTime()));
					statement.setString(2, efficency.getShift());
					statement.setString(3, efficency.getCrew());
					statement.setTimestamp(4, efficency.getStartTime());
					statement.setTimestamp(5, efficency.getEndTime());
					statement.setString(6, efficency.getReel());
					statement.setString(7, efficency.getGradeCode());
					statement.setString(8, efficency.getComment());
					statement.setInt(9, efficency.getSecondaryCode().getId());
					statement.setInt(10, efficency.getId());
					
					return statement;
				}
			});
		
	}


	
	@Override
	public void delete(int id) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		String sql="delete from [efficiencyData_pm5] where [ID]=?";
		jdbcTemplate.update(sql, new Object[]{id});
		
	}


	/* (non-Javadoc)
	 * @see com.st.efficiency.dao.EfficiencyDao#getEfficiencyShiftData(java.util.Date, java.util.Date, java.lang.String)
	 */
	@Override
	public List<EfficiencyShiftDataPM5> getEfficiencyShiftData(
			java.util.Date sdate, java.util.Date edate,String shift) {
		
		NamedParameterJdbcTemplate jdbcTemplate=new NamedParameterJdbcTemplate(dataSource);
		NamedParameterJdbcTemplate jdbcTemplateP=new NamedParameterJdbcTemplate(dataSourceP);
		Calendar scal=CommonUtil.getStartDate(sdate);
		Calendar ecal=CommonUtil.getEndDate(edate);
		
		
	//	System.out.println(scal.getTime());
	//	System.out.println(ecal.getTime());
		
		MapSqlParameterSource source=new MapSqlParameterSource();
		source.addValue("sdate", new Timestamp(scal.getTime().getTime()));
		source.addValue("edate", new Timestamp(ecal.getTime().getTime()));

		String sqlM=DatabaseUtil.getSQL("sql/EFFI_SHIFT_MACH_PM5.sql");
				
		List<EfficiencyShiftDataPM5> datas=jdbcTemplateP.query(sqlM, source, new RowMapper<EfficiencyShiftDataPM5>() {

			@Override
			public EfficiencyShiftDataPM5 mapRow(ResultSet rs, int arg1)
					throws SQLException {
				EfficiencyShiftDataPM5 data=new EfficiencyShiftDataPM5();
				data.setDate(new java.util.Date(rs.getTimestamp("DATE").getTime()));
				data.setShift(rs.getString("SHIFT"));
				data.setActualWt(CommonUtil.round(rs.getDouble("ACTUALTTON"), 2));
				data.setSlabOff(CommonUtil.round(rs.getDouble("SLABOFFTON"), 2));
				data.setCrew(rs.getString("TEAM"));
				return data;
			}
		});
		
		
		/*Wrapper DATA*/
		
		
		String sqlW=DatabaseUtil.getSQL("sql/EFFI_SHIFT_WRAP_PM5.sql");
		
		List<EfficiencyShiftDataPM5> datasW=jdbcTemplateP.query(sqlW, source,  new RowMapper<EfficiencyShiftDataPM5>() {

			@Override
			public EfficiencyShiftDataPM5 mapRow(ResultSet rs, int arg1)
					throws SQLException {
				EfficiencyShiftDataPM5 data=new EfficiencyShiftDataPM5();
				data.setDate(new java.util.Date(rs.getTimestamp("DATE").getTime()));
				data.setShift(rs.getString("SHIFT"));
				data.setWrapWhite(CommonUtil.round(rs.getDouble("WHITETON"), 2));
				data.setWrapRed(CommonUtil.round(rs.getDouble("REDTON"), 2));
				data.setWrapRej(CommonUtil.round(rs.getDouble("REJTON"), 2));
				data.setWrapTotal(CommonUtil.round(rs.getDouble("TOTALTON"), 2));
				//data.setCrew(rs.getString("TEAM"));
				return data;
			}
		});
		
		
		//Merg Data 1
		for (EfficiencyShiftDataPM5 dataW : datasW) {
			if(datas.contains(dataW)){
				EfficiencyShiftDataPM5 dataM=datas.get(datas.indexOf(dataW));
				dataM.setWrapWhite(dataW.getWrapWhite());
				dataM.setWrapRed(dataW.getWrapRed());
				dataM.setWrapRej(dataW.getWrapRej());
				dataM.setWrapTotal(dataW.getWrapTotal());
			}
		}
		
		datasW.clear();
		
		
		
		// Efficiency DATA
		
		String sqlE=DatabaseUtil.getSQL("sql/EFFI_SHIFT_QTY_PM5.sql"); 
		List<EfficiencyPM5> efficiencies=jdbcTemplate.query(sqlE, source, new RowMapper<EfficiencyPM5>() {
			@Override
			public EfficiencyPM5 mapRow(ResultSet rs, int arg1)
					throws SQLException {/*
				Efficiency efficiency=new Efficiency();
				
				efficiency.setDate(new java.util.Date(rs.getTimestamp("CDATE").getTime()));
				efficiency.setShift(rs.getString("Shift"));
				//efficiency.setCrew(rs.getString("Crew"));
				efficiency.setStartTime(rs.getTimestamp("StartTime"));
				efficiency.setEndTime(rs.getTimestamp("EndTime"));
				efficiency.setType(rs.getInt("TYPE"));
				return efficiency;
			*/

				EfficiencyPM5 efficiency=new EfficiencyPM5();
				
				SimpleDateFormat format= new SimpleDateFormat("HH");
				int result = Integer.parseInt(format.format(rs.getTimestamp("StartTime")));
				if(result>=0 && result<7){
					
					Calendar cal = Calendar.getInstance();
					cal.setTime(rs.getDate("CDATE"));
					cal.add(Calendar.DATE, -1);
					java.util.Date dateBefore30Days = cal.getTime();
					
					efficiency.setDate(dateBefore30Days);
					//System.out.println("Roshan:"+dateBefore30Days);
				}else{
					efficiency.setDate(new java.util.Date(rs.getDate("CDATE").getTime()));
					//System.out.println("Tailor:"+new java.util.Date(rs.getDate("CDATE").getTime()));
				}	
				//efficiency.setDate(new java.util.Date(rs.getTimestamp("CDATE").getTime()));
				efficiency.setShift(rs.getString("Shift"));
				//efficiency.setCrew(rs.getString("Crew"));
				efficiency.setStartTime(rs.getTimestamp("StartTime"));
				efficiency.setEndTime(rs.getTimestamp("EndTime"));
				efficiency.setType(rs.getInt("TYPE"));
				return efficiency;
				
			}
		});
		
		
		// Merge Data
		
		for (EfficiencyPM5 efficiency : efficiencies) {
			if(efficiency.getType()!=3){
				EfficiencyShiftDataPM5 dataE=new EfficiencyShiftDataPM5(efficiency.getDate(), efficiency.getShift());
				
				if(datas.contains(dataE)){
					EfficiencyShiftDataPM5 data=datas.get(datas.indexOf(dataE));
					
					Calendar now = Calendar.getInstance();
					now.setTime(efficiency.getStartTime());
					int hour = now.get(Calendar.HOUR_OF_DAY);
					int minute = now.get(Calendar.MINUTE);
					if(hour==0){
						hour=24;
					}
					
					Calendar now1 = Calendar.getInstance();
					now1.setTime(efficiency.getEndTime());
					int hour1 = now1.get(Calendar.HOUR_OF_DAY);
					if(hour1==0){
						hour1=24;
					}
					int minute1 = now1.get(Calendar.MINUTE);
					
					//int mm=minute1-minute;
					//int hh=hour1-hour;
					
					int mm=0;
					int hh=0;
					
					SimpleDateFormat format = new SimpleDateFormat("MM-dd-yyyy HH:mm:ss");
					SimpleDateFormat dateFormat=new SimpleDateFormat("MM-dd-yyyy HH:mm:ss");
					
					String dateStart = dateFormat.format(efficiency.getStartTime());
					String dateStop = dateFormat.format(efficiency.getEndTime());
					
					java.util.Date d1 = null;
					java.util.Date d2 = null;
					try {
						
						d1 = format.parse(dateStart);
						d2 = format.parse(dateStop);
						
						//in milliseconds
						long diff = d2.getTime() - d1.getTime();

						//long diffSeconds = diff / 1000 % 60;
						long diffMinutes = diff / (60 * 1000) % 60;
						long diffHours = diff / (60 * 60 * 1000) % 24;
						//long diffDays = diff / (24 * 60 * 60 * 1000);

						/*System.out.print(diffHours + " hours, ");
						System.out.print(diffMinutes + " minutes, ");
						System.out.println("**************************");*/
						
						mm=(int) diffMinutes;
						hh=(int) diffHours;

					} catch (Exception e) {
						e.printStackTrace();
					}
					
					/*if(Integer.toString(mm).contains("-")){
						String min=Integer.toString(mm).replaceAll("[()\\s-]+", "");
						mm = Integer.parseInt(min);
					}*/
					 
					 
					if(hh < 0)
					{
						
					    String b = Integer.toString(hh).substring(1);
						//System.out.println("hh"+b);
						hh = Integer.parseInt(b);
					}
					 
					if(mm < 0)
					{
						
					    String a = Integer.toString(mm).substring(1);
						System.out.println("mm::"+a);
						mm = Integer.parseInt(a);
					}
					
					data.setDowntime(data.getDowntime()+mm+(hh*60));
				}
				
			}
		}
		
		efficiencies.clear();
		
		//By DCS DAta
		
		//Filter Data
		/*if(shift.equalsIgnoreCase("ALL")){
			return datas;
		}else{
			
			List<EfficiencyShiftData> efficiencyShiftDatas=new ArrayList<EfficiencyShiftData>();
			
			for (EfficiencyShiftData shiftData : datas) {
				if(shiftData.getShift().equalsIgnoreCase(shift)){
					efficiencyShiftDatas.add(shiftData);
				}
			}
			return efficiencyShiftDatas;
		}*/
		
		return datas;
		
	}


	/* (non-Javadoc)
	 * @see com.st.efficiency.dao.EfficiencyDao#getEfficiencyDCSDataReport(java.util.Date, java.util.Date, java.lang.String, java.lang.Double)
	 */
	@Override
	public List<EfficiencyShiftDataPM5> getEfficiencyDCSDataReport(
			java.util.Date sdate, java.util.Date edate) {
		// TODO Auto-generated method stub
		
		Calendar scal=CommonUtil.getStartDate(sdate);
		Calendar ecal=CommonUtil.getEndDate(edate);
		
			
			
			
			NamedParameterJdbcTemplate jdbcTemplateP=new NamedParameterJdbcTemplate(dataSource);
			String sql="select [Date],[shift],sum(ton) AS ton From [tblreelTonDcs_PM5] "
					+ "where [Date] between :sdate and :edate group by [Date],[shift]" ;
			
			MapSqlParameterSource source=new MapSqlParameterSource();
			/*source.addValue("sdate", new Timestamp(scal.getTime().getTime()));
			source.addValue("edate", new Timestamp(ecal.getTime().getTime()));*/
			source.addValue("sdate", sdate);
			source.addValue("edate", edate);
			//source.addValue("gweight", tons);
			//source.addValue("shift", shift);
			List<EfficiencyShiftDataPM5> datas=jdbcTemplateP.query(sql, source, new RowMapper<EfficiencyShiftDataPM5>() {

				@Override
				public EfficiencyShiftDataPM5 mapRow(ResultSet rs, int arg1)
						throws SQLException {
					// TODO Auto-generated method stub
					EfficiencyShiftDataPM5 data=new EfficiencyShiftDataPM5();
					data.setDate(new Date(rs.getTimestamp("Date").getTime()));
					//wmd.setReasonforbreak(rs.getString("Reasonforbreak")==null?"":rs.getString("Reasonforbreak".toUpperCase()));
					data.setShift(rs.getString("SHIFT")==null?"":rs.getString("SHIFT").toUpperCase());
					data.setActualWt(CommonUtil.round(rs.getDouble("ton"), 2));
					return data;
				}
				
			});
		return datas;
	}


	/* (non-Javadoc)
	 * @see com.st.efficiency.dao.EfficiencyDao#saveDCSData(com.st.efficiency.model.EfficiencyShiftData)
	 */
	@Override
	public int saveDCSData(final EfficiencyShiftDataPM5 eSD) {
		// TODO Auto-generated method stub
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		KeyHolder keyHolder=new GeneratedKeyHolder();
		
		final String sql="insert into tblreelTonDcs_PM5"
				+ "([Date],"
				+ "[shift],"
				+ "[ton])"
				+ " values(?,?,?)";
		jdbcTemplate.update(new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(Connection arg0)
					throws SQLException {
				// TODO Auto-generated method stub
				PreparedStatement statement=arg0.prepareStatement(sql,new String[] {"ID"});
				statement.setTimestamp(1, new Timestamp(eSD.getDate().getTime()));
				statement.setString(2, eSD.getShift());
				statement.setDouble(3, eSD.getActualWt());  
				return statement;
			}
			
		},keyHolder);
		return keyHolder.getKey().intValue();
	}


	/* (non-Javadoc)
	 * @see com.st.efficiency.dao.EfficiencyDao#checkTonPresentOrNot(java.util.Date, java.lang.String)
	 */
	@Override
	public List<EfficiencyShiftDataPM5> checkTonPresentOrNot(java.util.Date sdate,
			String shift) {
		// TODO Auto-generated method stub
		
		NamedParameterJdbcTemplate jdbcTemplateP=new NamedParameterJdbcTemplate(dataSource);
		String sql="select [ID],[Date],[shift],sum(ton) AS ton From [tblreelTonDcs_PM5] Where [Date]=:sdate And [Shift]=:shift Group By [Date],[shift],[ID]" ;
		
		MapSqlParameterSource source=new MapSqlParameterSource();
		
		source.addValue("sdate", sdate);
		source.addValue("shift", shift);
		
		List<EfficiencyShiftDataPM5> datas=jdbcTemplateP.query(sql, source, new RowMapper<EfficiencyShiftDataPM5>() {

			@Override
			public EfficiencyShiftDataPM5 mapRow(ResultSet rs, int arg1)
					throws SQLException {
				// TODO Auto-generated method stub
				EfficiencyShiftDataPM5 data=new EfficiencyShiftDataPM5();
				data.setId(rs.getInt("ID"));
				data.setDate(new Date(rs.getTimestamp("Date").getTime()));
				data.setShift(rs.getString("SHIFT")==null?"":rs.getString("SHIFT").toUpperCase());
				data.setActualWt(CommonUtil.round(rs.getDouble("ton"), 2));
				return data;
			}
			
		});
	return datas;
}


	/* (non-Javadoc)
	 * @see com.st.efficiency.dao.EfficiencyDao#editDCSReport(int)
	 */
	@Override
	public List<EfficiencyShiftDataPM5> editDCSReport(int id) {
		// TODO Auto-generated method stub
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		String sql="select * from [tblreelTonDcs_PM5] where ([id])=?";
		List<EfficiencyShiftDataPM5> cc= jdbcTemplate.query(sql,new Object[]{id}, new DCSReelTonMapperPM5());
		return cc;
	}


	/* (non-Javadoc)
	 * @see com.st.efficiency.dao.EfficiencyDao#updateDCSData(com.st.efficiency.model.EfficiencyShiftData)
	 */
	@Override
	public void updateDCSData(final EfficiencyShiftDataPM5 eSD) {

		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		final String sql="update [tblreelTonDcs_PM5] set "
				+"[Date]=?,"
				+"[shift]=?,"
				+"[ton]=?"
				+ " where [ID]=?";
		
		jdbcTemplate.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection arg0)
					throws SQLException {
				PreparedStatement statement=arg0.prepareStatement(sql);
				statement.setTimestamp(1, new Timestamp(eSD.getDate().getTime()));
				statement.setString(2,eSD.getShift());
				statement.setDouble(3, eSD.getActualWt());
				statement.setInt(4, eSD.getId());
				return statement;
			}
		});
	}


	/* (non-Javadoc)
	 * @see com.st.efficiency.dao.EfficiencyDao#getEfficienciesUnControllableDownTimeMinutes(java.lang.String, java.lang.String)
	 */
	@Override
	public List<EfficiencyPM5> getEfficienciesUnControllableDownTimeMinutes(String sdate, String edate) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		String sql="SELECT "
				+ "d.[ID],"
				+ "d.[Date],"
				+ "d.[Shift],"
				+ "d.[Crew],"
				+ "d.[StartTime],"
				+ "d.[EndTime],"
				+ "d.[Reel],"
				+ "d.[GradeCode],"
				+ "d.[Comment],"
				+ "sc.[code] as scode,"
				+ "sc.[ID] as sid,"
				+ "pc.[code] as pcode,"
				+ "pc.[Type] as ptype"
				+ " FROM [efficiencyData_pm5] d,"
				+ "efficiencySecondaryCode_pm5 sc,"
				+ "efficiencyPrimaryCode_pm5 pc "
				+ " where ( d.[Date] between ? and ?) and "
				+ "sc.[ID]=d.[SecodaryCode] and "
				+ "pc.[ID]=sc.[PrimaryCodeID] and pc.Type='3' ";
			sql+=" order by d.[Date]";
			
			SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy HH:mm:ss");
			
			List<EfficiencyPM5> efficiencies=jdbcTemplate.query(sql, new Object[]{
						sdate,
						edate
			}, new RowMapper<EfficiencyPM5>() {
			
				@Override
				public EfficiencyPM5 mapRow(ResultSet rs, int arg1)
						throws SQLException {
					EfficiencyPM5 efficiency=new EfficiencyPM5();
					efficiency.setId(rs.getInt("ID"));
					efficiency.setDate(new Date(rs.getTimestamp("Date").getTime()));
					efficiency.setShift(rs.getString("Shift"));
					efficiency.setCrew(rs.getString("Crew"));
					efficiency.setStartTime(rs.getTimestamp("StartTime"));
					efficiency.setEndTime(rs.getTimestamp("EndTime"));
					efficiency.setReel(rs.getString("Reel"));
					efficiency.setGradeCode(rs.getString("GradeCode"));
					efficiency.setComment(rs.getString("Comment"));
					
					SecondaryCodePM5 secondaryCode=new SecondaryCodePM5();
					secondaryCode.setCode(rs.getString("scode"));
					secondaryCode.setId(rs.getInt("sid"));
					efficiency.setSecondaryCode(secondaryCode);
					
					PrimaryCodePM5 primaryCode=new PrimaryCodePM5();
					primaryCode.setCode(rs.getString("pcode"));
					primaryCode.setType(rs.getInt("ptype"));
					secondaryCode.setPrimaryCode(primaryCode);
					
					efficiency.setFendTimeHH(""+CommonUtil.getHoursDuration(new Date(efficiency.getStartTime().getTime()), new Date(efficiency.getEndTime().getTime())));
					efficiency.setFendTimeMM(""+CommonUtil.getMinutesDuration(new Date(efficiency.getStartTime().getTime()), new Date(efficiency.getEndTime().getTime())));
					
					
					
					return efficiency;
				}
			});
		
		return efficiencies;
	}

}

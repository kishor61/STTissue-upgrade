/**
 * 
 */
package com.st.efficiency.dao;

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
import com.st.efficiency.mapper.DCSReelTonMapper;
import com.st.efficiency.model.Efficiency;
import com.st.efficiency.model.EfficiencyShiftData;
import com.st.efficiency.model.PrimaryCode;
import com.st.efficiency.model.SecondaryCode;

/**
 * @author sbora
 *
 */
@Repository
public class EfficiencyDaoImp implements EfficiencyDao {

	@Autowired
	private DataSource dataSource;
	
	@Autowired
	@Qualifier("dataSourceProduction")
	private DataSource dataSourceP;
	
	@Override
	public int add(final Efficiency efficency) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		KeyHolder holder=new GeneratedKeyHolder();
		
		final String sql="insert into [efficiencyData]"
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
	public List<Efficiency> getEfficiencies(Efficiency efficiency) {
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
				+ " FROM [efficiencyData] d,"
				+ "efficiencySecondaryCode sc,"
				+ "efficiencyPrimaryCode pc "
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
			
			@SuppressWarnings("deprecation")
			List<Efficiency> efficiencies=jdbcTemplate.query(sql, new Object[]{
						sdf.format(efficiency.getStartDate()),
						sdf.format(efficiency.getEndDate())
			}, new RowMapper<Efficiency>() {
			
				@Override
				public Efficiency mapRow(ResultSet rs, int arg1)
						throws SQLException {
					Efficiency efficiency=new Efficiency();
					efficiency.setId(rs.getInt("ID"));
					efficiency.setDate(new Date(rs.getTimestamp("Date").getTime()));
					efficiency.setShift(rs.getString("Shift"));
					efficiency.setCrew(rs.getString("Crew"));
					efficiency.setStartTime(rs.getTimestamp("StartTime"));
					efficiency.setEndTime(rs.getTimestamp("EndTime"));
					efficiency.setReel(rs.getString("Reel"));
					efficiency.setGradeCode(rs.getString("GradeCode"));
					efficiency.setComment(rs.getString("Comment"));
					
					SecondaryCode secondaryCode=new SecondaryCode();
					secondaryCode.setCode(rs.getString("scode"));
					secondaryCode.setId(rs.getInt("sid"));
					efficiency.setSecondaryCode(secondaryCode);
					
					PrimaryCode primaryCode=new PrimaryCode();
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
	public Efficiency getEfficiency(int id) {
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
				+ " FROM [efficiencyData] d,"
				+ "efficiencySecondaryCode sc,"
				+ "efficiencyPrimaryCode pc "
				+ " where d.[ID]=?"
				+ " and "
				+ "sc.[ID]=d.[SecodaryCode]"
				+ " and "
				+ "pc.[ID]=sc.[PrimaryCodeID]";
		
		Efficiency efficiency=jdbcTemplate.queryForObject(sql, new Object[]{id}, new RowMapper<Efficiency>() {

			@Override
			public Efficiency mapRow(ResultSet rs, int arg1)
					throws SQLException {
				Efficiency efficiency=new Efficiency();
				efficiency.setId(rs.getInt("ID"));
				efficiency.setDate(new Date(rs.getTimestamp("Date").getTime()));
				efficiency.setShift(rs.getString("Shift"));
				efficiency.setCrew(rs.getString("Crew"));
				efficiency.setStartTime(rs.getTimestamp("StartTime"));
				efficiency.setEndTime(rs.getTimestamp("EndTime"));
				efficiency.setReel(rs.getString("Reel"));
				efficiency.setGradeCode(rs.getString("GradeCode"));
				efficiency.setComment(rs.getString("Comment"));
				
				SecondaryCode secondaryCode=new SecondaryCode();
				secondaryCode.setCode(rs.getString("scode"));
				secondaryCode.setId(rs.getInt("sid"));
				efficiency.setSecondaryCode(secondaryCode);
				
				PrimaryCode primaryCode=new PrimaryCode();
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
	public void update(final Efficiency efficency) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		
		final String sql="update[efficiencyData] set "
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
		String sql="delete from [efficiencyData] where [ID]=?";
		jdbcTemplate.update(sql, new Object[]{id});
		
	}


	/* (non-Javadoc)
	 * @see com.st.efficiency.dao.EfficiencyDao#getEfficiencyShiftData(java.util.Date, java.util.Date, java.lang.String)
	 */
	@Override
	public List<EfficiencyShiftData> getEfficiencyShiftData(
			java.util.Date sdate, java.util.Date edate,String shift) {
		
		NamedParameterJdbcTemplate jdbcTemplate=new NamedParameterJdbcTemplate(dataSource);
		NamedParameterJdbcTemplate jdbcTemplateP=new NamedParameterJdbcTemplate(dataSourceP);
		
		Calendar scal=Calendar.getInstance();
		scal.setTime(sdate);
		scal.set(Calendar.HOUR_OF_DAY, 7);
		scal.set(Calendar.MINUTE, 0);
		scal.set(Calendar.SECOND, 0);
		scal.set(Calendar.MILLISECOND, 0);
		
		Calendar ecal=Calendar.getInstance();
		ecal.setTime(edate);
		ecal.set(Calendar.HOUR_OF_DAY, 6);
		ecal.set(Calendar.MINUTE, 59);
		ecal.set(Calendar.SECOND, 59);
		ecal.set(Calendar.MILLISECOND, 0);
		ecal.add(Calendar.DATE, 1);
		
	//	System.out.println(scal.getTime());
	//	System.out.println(ecal.getTime());
		
		MapSqlParameterSource source=new MapSqlParameterSource();
		source.addValue("sdate", new Timestamp(scal.getTime().getTime()));
		source.addValue("edate", new Timestamp(ecal.getTime().getTime()));

		String sqlM=DatabaseUtil.getSQL("sql/EFFI_SHIFT_MACH.sql");
				
		List<EfficiencyShiftData> datas=jdbcTemplateP.query(sqlM, source, new RowMapper<EfficiencyShiftData>() {

			@Override
			public EfficiencyShiftData mapRow(ResultSet rs, int arg1)
					throws SQLException {
				EfficiencyShiftData data=new EfficiencyShiftData();
				data.setDate(new java.util.Date(rs.getTimestamp("DATE").getTime()));
				data.setShift(rs.getString("SHIFT"));
				data.setActualWt(CommonUtil.round(rs.getDouble("ACTUALTTON"), 2));
				data.setSlabOff(CommonUtil.round(rs.getDouble("SLABOFFTON"), 2));
				data.setCrew(rs.getString("TEAM"));
				return data;
			}
		});
		
		
		/*Wrapper DATA*/
		
		
		String sqlW=DatabaseUtil.getSQL("sql/EFFI_SHIFT_WRAP.sql");
		
		List<EfficiencyShiftData> datasW=jdbcTemplateP.query(sqlW, source,  new RowMapper<EfficiencyShiftData>() {

			@Override
			public EfficiencyShiftData mapRow(ResultSet rs, int arg1)
					throws SQLException {
				EfficiencyShiftData data=new EfficiencyShiftData();
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
		for (EfficiencyShiftData dataW : datasW) {
			if(datas.contains(dataW)){
				EfficiencyShiftData dataM=datas.get(datas.indexOf(dataW));
				dataM.setWrapWhite(dataW.getWrapWhite());
				dataM.setWrapRed(dataW.getWrapRed());
				dataM.setWrapRej(dataW.getWrapRej());
				dataM.setWrapTotal(dataW.getWrapTotal());
			}
		}
		
		datasW.clear();
		
		
		
		// Efficiency DATA
		
		String sqlE=DatabaseUtil.getSQL("sql/EFFI_SHIFT_QTY.sql"); 
		List<Efficiency> efficiencies=jdbcTemplate.query(sqlE, source, new RowMapper<Efficiency>() {
			@Override
			public Efficiency mapRow(ResultSet rs, int arg1)
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

				Efficiency efficiency=new Efficiency();
				
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
		
		for (Efficiency efficiency : efficiencies) {
			if(efficiency.getType()!=3){
				EfficiencyShiftData dataE=new EfficiencyShiftData(efficiency.getDate(), efficiency.getShift());
				
				if(datas.contains(dataE)){
					EfficiencyShiftData data=datas.get(datas.indexOf(dataE));
					
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
	public List<EfficiencyShiftData> getEfficiencyDCSDataReport(
			java.util.Date sdate, java.util.Date edate) {
		// TODO Auto-generated method stub
		
		
			Calendar scal=Calendar.getInstance();
			scal.setTime(sdate);
			scal.set(Calendar.HOUR_OF_DAY, 7);
			scal.set(Calendar.MINUTE, 0);
			scal.set(Calendar.SECOND, 0);
			scal.set(Calendar.MILLISECOND, 0);
			
			Calendar ecal=Calendar.getInstance();
			ecal.setTime(edate);
			ecal.set(Calendar.HOUR_OF_DAY, 6);
			ecal.set(Calendar.MINUTE, 59);
			ecal.set(Calendar.SECOND, 59);
			ecal.set(Calendar.MILLISECOND, 0);
			ecal.add(Calendar.DATE, 1);
			
			
			NamedParameterJdbcTemplate jdbcTemplateP=new NamedParameterJdbcTemplate(dataSource);
			String sql="select [Date],[shift],sum(ton) AS ton From [tblreelTonDcs] "
					+ "where [Date] between :sdate and :edate group by [Date],[shift]" ;
			
			MapSqlParameterSource source=new MapSqlParameterSource();
			/*source.addValue("sdate", new Timestamp(scal.getTime().getTime()));
			source.addValue("edate", new Timestamp(ecal.getTime().getTime()));*/
			source.addValue("sdate", sdate);
			source.addValue("edate", edate);
			//source.addValue("gweight", tons);
			//source.addValue("shift", shift);
			List<EfficiencyShiftData> datas=jdbcTemplateP.query(sql, source, new RowMapper<EfficiencyShiftData>() {

				@Override
				public EfficiencyShiftData mapRow(ResultSet rs, int arg1)
						throws SQLException {
					// TODO Auto-generated method stub
					EfficiencyShiftData data=new EfficiencyShiftData();
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
	public int saveDCSData(final EfficiencyShiftData eSD) {
		// TODO Auto-generated method stub
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		KeyHolder keyHolder=new GeneratedKeyHolder();
		
		final String sql="insert into tblreelTonDcs"
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
	public List<EfficiencyShiftData> checkTonPresentOrNot(java.util.Date sdate,
			String shift) {
		// TODO Auto-generated method stub
		
		NamedParameterJdbcTemplate jdbcTemplateP=new NamedParameterJdbcTemplate(dataSource);
		String sql="select [ID],[Date],[shift],sum(ton) AS ton From [tblreelTonDcs] Where [Date]=:sdate And [Shift]=:shift Group By [Date],[shift],[ID]" ;
		
		MapSqlParameterSource source=new MapSqlParameterSource();
		
		source.addValue("sdate", sdate);
		source.addValue("shift", shift);
		
		List<EfficiencyShiftData> datas=jdbcTemplateP.query(sql, source, new RowMapper<EfficiencyShiftData>() {

			@Override
			public EfficiencyShiftData mapRow(ResultSet rs, int arg1)
					throws SQLException {
				// TODO Auto-generated method stub
				EfficiencyShiftData data=new EfficiencyShiftData();
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
	public List<EfficiencyShiftData> editDCSReport(int id) {
		// TODO Auto-generated method stub
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		String sql="select * from [tblreelTonDcs] where ([id])=?";
		List<EfficiencyShiftData> cc= jdbcTemplate.query(sql,new Object[]{id}, new DCSReelTonMapper());
		return cc;
	}


	/* (non-Javadoc)
	 * @see com.st.efficiency.dao.EfficiencyDao#updateDCSData(com.st.efficiency.model.EfficiencyShiftData)
	 */
	@Override
	public void updateDCSData(final EfficiencyShiftData eSD) {

		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		final String sql="update [tblreelTonDcs] set "
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
	public List<Efficiency> getEfficienciesUnControllableDownTimeMinutes(String sdate, String edate) {
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
				+ " FROM [efficiencyData] d,"
				+ "efficiencySecondaryCode sc,"
				+ "efficiencyPrimaryCode pc "
				+ " where ( d.[Date] between ? and ?) and "
				+ "sc.[ID]=d.[SecodaryCode] and "
				+ "pc.[ID]=sc.[PrimaryCodeID] and pc.Type='3' ";
			sql+=" order by d.[Date]";
			
			SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy HH:mm:ss");
			
			List<Efficiency> efficiencies=jdbcTemplate.query(sql, new Object[]{
						sdate,
						edate
			}, new RowMapper<Efficiency>() {
			
				@Override
				public Efficiency mapRow(ResultSet rs, int arg1)
						throws SQLException {
					Efficiency efficiency=new Efficiency();
					efficiency.setId(rs.getInt("ID"));
					efficiency.setDate(new Date(rs.getTimestamp("Date").getTime()));
					efficiency.setShift(rs.getString("Shift"));
					efficiency.setCrew(rs.getString("Crew"));
					efficiency.setStartTime(rs.getTimestamp("StartTime"));
					efficiency.setEndTime(rs.getTimestamp("EndTime"));
					efficiency.setReel(rs.getString("Reel"));
					efficiency.setGradeCode(rs.getString("GradeCode"));
					efficiency.setComment(rs.getString("Comment"));
					
					SecondaryCode secondaryCode=new SecondaryCode();
					secondaryCode.setCode(rs.getString("scode"));
					secondaryCode.setId(rs.getInt("sid"));
					efficiency.setSecondaryCode(secondaryCode);
					
					PrimaryCode primaryCode=new PrimaryCode();
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

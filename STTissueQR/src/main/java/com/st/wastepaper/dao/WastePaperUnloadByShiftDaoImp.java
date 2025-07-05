/**
 *Oct 9, 2015
 *WastePaperUnloadByShiftDaoImp.java
 * TODO
 *com.st.wastepaper.dao
 *WastePaperUnloadByShiftDaoImp.java
 *Sunil Singh Bora
 */
package com.st.wastepaper.dao;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.sql.DataSource;

import org.joda.time.DateTime;
import org.joda.time.Days;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.st.wastepaper.model.WastePaperBaleInventory;
import com.st.wastepaper.model.WastePaperUnloadByShift;

/**
 * @author roshan
 *
 */
@Repository
public class WastePaperUnloadByShiftDaoImp implements WastePaperUnloadByShiftDao {
	
	@Autowired
	@Qualifier("dataSourceProduction")
	private DataSource dataSourceP;	

	/* (non-Javadoc)
	 * @see com.st.wastepaper.dao.WastePaperUnloadByShiftDao#getUnloadByShift(java.util.Date, java.util.Date)
	 */
	@Override
	public List<WastePaperUnloadByShift> getUnloadByShift(Date startdate,Date enddate) {
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		SimpleDateFormat dateFormatTesting = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss");
		SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm:ss");
		NamedParameterJdbcTemplate  jdbcTemplate=new NamedParameterJdbcTemplate(dataSourceP);
		List<WastePaperUnloadByShift> unloadDetails= new ArrayList<WastePaperUnloadByShift>();
		
		Calendar calendar=Calendar.getInstance();
		calendar.setTime(startdate);
		System.out.println("FETCHING UNLOAD BALES BY SHIFT REPORT - By Roshan <START>");
		
		int days=Days.daysBetween(new DateTime(startdate.getTime()), new DateTime(enddate.getTime())).getDays();
		
		Calendar date=Calendar.getInstance();
		date.setTime(startdate);
		
		for (int i = 0; i <=days; i++) {
			
			Calendar scal=Calendar.getInstance();
			scal.setTime(date.getTime());
			scal.set(Calendar.HOUR_OF_DAY, 7);
			scal.set(Calendar.MINUTE, 0);
			scal.set(Calendar.SECOND, 0);
			scal.set(Calendar.MILLISECOND, 0);
	
			
			Calendar ecal=Calendar.getInstance();
			ecal.setTime(date.getTime());
			ecal.set(Calendar.HOUR_OF_DAY, 6);
			ecal.set(Calendar.MINUTE, 59);
			ecal.set(Calendar.SECOND, 59);
			ecal.set(Calendar.MILLISECOND, 0);
			ecal.add(Calendar.DATE, 1);
			
			/*System.out.println("Start Date::"+dateFormatTesting.format(scal.getTime().getTime()));
			System.out.println("End Date::"+dateFormatTesting.format(ecal.getTime().getTime()));*/
			
			Calendar frmCal=Calendar.getInstance();
			frmCal.setTime(scal.getTime());
			frmCal.add(Calendar.DATE, -1);
			
			Calendar toCal=Calendar.getInstance();
			toCal.setTime(ecal.getTime());
			toCal.add(Calendar.DATE, 1);
			
			
			MapSqlParameterSource source=new MapSqlParameterSource();
			
			source.addValue("sdate", new Timestamp(scal.getTime().getTime()));
			source.addValue("edate", new Timestamp(ecal.getTime().getTime()));
			source.addValue("frmDate", new Timestamp(frmCal.getTime().getTime()));
			source.addValue("toDate", new Timestamp(toCal.getTime().getTime()));

			final WastePaperUnloadByShift byShift= new WastePaperUnloadByShift();
			
			int _totalBalesCount=0;
			
			Date dateS=scal.getTime();
			byShift.setUnloaddate(dateS);
			
			String dayOfWeek = new SimpleDateFormat("EEEE", Locale.ENGLISH).format(scal.getTime());
			byShift.setDay(dayOfWeek);	
			
			int totalInDayShift=0;
			int totalInNightSift=0;
			
			try{
				String sql="SELECT [UnloadDate],[UnloadTime],count(*) as balesOnDate FROM "
						+ "( select [ReleaseNumber],[UnloadDate],[UnloadTime] from [tblBaleInventory] where [UnloadDate]"
						+ " between :frmDate and :toDate Group by [UnloadDate],[ReleaseNumber],[UnloadTime])"
						+ " where  DateAdd('n',0,Format([UnloadDate] & ' ' & [UnloadTime],'General Date'))"
						+ " between :sdate and :edate  group by [UnloadDate],[ReleaseNumber],[UnloadTime]";
				
				List<Map<String, Object>> mapList=new ArrayList<Map<String,Object>>();
				try {
					mapList=jdbcTemplate.queryForList(sql,source);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				if(mapList.size()>0){
					for (final Map<String, Object> map1 : mapList) {
						int _totalBales=map1.get("balesOnDate")==null?0:(Integer)map1.get("balesOnDate");
						Date unloadDate=(Date)map1.get("UnloadDate".toUpperCase());
						Timestamp timestamp=(Timestamp)map1.get("UnloadTime");

						Calendar cal=Calendar.getInstance();
						cal.setTimeInMillis(timestamp.getTime());
					
						if((cal.get(Calendar.HOUR_OF_DAY)>=7) && (cal.get(Calendar.HOUR_OF_DAY)<=19)){
							//System.out.println("Day Shift");
							if(dateFormat.format(unloadDate.getTime()).equals(dateFormat.format(scal.getTime().getTime()))){
								_totalBalesCount = _totalBalesCount + _totalBales;
								byShift.setDayshift(_totalBalesCount);	
							}
						}else{
							//System.out.println("Night Shift");
							if(dateFormat.format(unloadDate.getTime()).equals(dateFormat.format(scal.getTime().getTime()))){
								_totalBalesCount = _totalBalesCount + _totalBales;
								byShift.setNightshift(_totalBalesCount);
							}
						}
						int grandtotal=byShift.getDayshift()+byShift.getNightshift();
						byShift.setGrandtotal(grandtotal);
					}
				}
			}catch(Exception rlt){
				rlt.printStackTrace();
				System.out.println("Roshan Says, You Have A Problem In WastePaperUnloadByShiftDaoImp.java");
			}
			unloadDetails.add(byShift);	
			date.add(Calendar.DATE, 1);
		}
		
		return unloadDetails;
	}

}

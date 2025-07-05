package com.st.wastepaper.dao;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

//import org.jfree.chart.needle.ShipNeedle;
import org.joda.time.DateTime;
import org.joda.time.Days;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.st.common.CommonUtil;
import com.st.wastepaper.model.WastePaperTruckUnload;

@Repository
public class WastePaperTrucksUnloadDaoImp implements WastePaperTrucksUnloadDao {

	@Autowired
	@Qualifier("dataSourceProduction")
	private DataSource dataSourceP;
	
	@Autowired
	private DataSource dataSource;
	
	private SimpleDateFormat dateFormat=new SimpleDateFormat("MM-dd-yyyy");
	private SimpleDateFormat dateFormat1=new SimpleDateFormat("MM-dd-yyyy HH:mm:ss a");
	private SimpleDateFormat dateFormat2=new SimpleDateFormat("HH:mm:ss a");
	private SimpleDateFormat dateFormat3=new SimpleDateFormat("HH");
	private SimpleDateFormat dateFormat4=new SimpleDateFormat("mm");
	
	@Override
	public List<WastePaperTruckUnload> getUnloadTrucks(Date sdate, Date edate) {
		
		NamedParameterJdbcTemplate  jdbcTemplate=new NamedParameterJdbcTemplate(dataSourceP);
		List<WastePaperTruckUnload> unloadTrucks= new ArrayList<WastePaperTruckUnload>();
		
		Calendar calendar=Calendar.getInstance();
		calendar.setTime(sdate);
		
		int days=Days.daysBetween(new DateTime(sdate.getTime()), new DateTime(edate.getTime())).getDays();
		
		Calendar date=Calendar.getInstance();
		date.setTime(sdate);
		
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
			
			
			
			MapSqlParameterSource source=new MapSqlParameterSource();
			source.addValue("sdate", new Timestamp(scal.getTime().getTime()));
			source.addValue("edate", new Timestamp(ecal.getTime().getTime()));
			
			//System.out.println("Sdate:"+dateFormat1.format(scal.getTime().getTime()));
			//System.out.println("Edate:"+dateFormat1.format(ecal.getTime().getTime()));
			
			
			double _totalBaleWeightCount=0;
			try{
				String sqlUnloadTrucks="SELECT tblPrintLabels.ReleaseNumber, Count(tblBaleInventory.TagID) AS Bales, tblPrintLabels.Trailer, "
						+ "tblPrintLabels.GradeCode, tblPrintLabels.Grade, tblPrintLabels.PrintDate As UnloadDate, First(tblPrintLabels.PrintTime) AS UnloadDateTime, "
						+ "Sum(tblBaleInventory.BaleWeight) AS TotalWeight, IIf([tblPrintLabels]![GradeCode]=95,'',[tblPrintLabels]![PickupPoint]) AS PickUpPnt "
						+ "FROM tblPrintLabels INNER JOIN tblBaleInventory ON tblPrintLabels.TagID = tblBaleInventory.TagID "
						+ "GROUP BY tblPrintLabels.ReleaseNumber, tblPrintLabels.Trailer, tblPrintLabels.GradeCode, tblPrintLabels.Grade, tblPrintLabels.PrintDate, "
						+ "IIf([tblPrintLabels]![GradeCode]=95,'',[tblPrintLabels]![PickupPoint])  "
						//+ "HAVING (((tblPrintLabels.PrintDate) Between :sdate and :edate));";
						+ "HAVING (((First(tblPrintLabels.PrintTime)) Between :sdate and :edate))";
				
				List<Map<String, Object>> mapList=new ArrayList<Map<String,Object>>();
				try {
					mapList=jdbcTemplate.queryForList(sqlUnloadTrucks,source);
				} catch (Exception e) {
					System.out.println("Roshan Says, You Have An Error In WastePaperTrucksUnloadDaoImp.java..Please Contact To Him.");
					System.out.println(e.getMessage());
				}
				if(mapList.size()>0){
					for (final Map<String, Object> map1 : mapList) {
						
						int releaseNo=(Integer)map1.get("ReleaseNumber".toUpperCase());
						double baleWeight=(Double)map1.get("TotalWeight")==null?0:(Double)(map1.get("TotalWeight"));
						int gradeCode=(Integer)map1.get("GradeCode".toUpperCase());
						int bale=(Integer)map1.get("Bales".toUpperCase());
						String trailer=(String)map1.get("Trailer".toUpperCase());
						Timestamp unloadDATE=(Timestamp)map1.get("UnloadDate");
						Timestamp unloadTIME=(Timestamp)map1.get("UnloadDateTime");
						
						//System.out.println(dateFormat2.format(unloadTIME)+" : "+dateFormat3.format(unloadTIME));
						
						final WastePaperTruckUnload wastePaperUnloadTrucks=new WastePaperTruckUnload();
						
						int HH=Integer.parseInt(dateFormat3.format(unloadTIME));
						int MM=Integer.parseInt(dateFormat4.format(unloadTIME));
						if(HH>=7 && MM>=01 && HH<=19 && MM<=59){
							//System.out.println("Day");
							wastePaperUnloadTrucks.setDayshift("Day");
							wastePaperUnloadTrucks.setNightshift("NotNight");
						}else{
							wastePaperUnloadTrucks.setNightshift("Night");
							wastePaperUnloadTrucks.setDayshift("NotDay");
							//System.out.println("Night");
						}
						
						Date dateS=scal.getTime();
						wastePaperUnloadTrucks.setUnloaddate(dateS);
						
						/*wastePaperUnloadTrucks.setRelease(releaseNo);
						wastePaperUnloadTrucks.setWeight(CommonUtil.round(baleWeight, 2));
						wastePaperUnloadTrucks.setGrade(gradeCode);
						wastePaperUnloadTrucks.setBales(bale);
						wastePaperUnloadTrucks.setTrailer(trailer);
						wastePaperUnloadTrucks.setUnloaddatetime(unloadTIME);
						
						if(releaseNo!=0){
							
							MapSqlParameterSource source1=new MapSqlParameterSource();
							source1.addValue("release", releaseNo);
							
							try{
								String sqlvandor="SELECT tblPurchaseHeader.ReleaseNumber, tblPurchaseHeader.UnloadComment,"
												+ " tblPurchaseHeader.Vendor, tblPurchaseHeader.VendorNumber FROM tblPurchaseHeader where tblPurchaseHeader.ReleaseNumber=:release";
								List<Map<String, Object>> vandorList=new ArrayList<Map<String,Object>>();
								try{
									vandorList=jdbcTemplate.queryForList(sqlvandor,source1);
								}catch(Exception rlt){
									rlt.printStackTrace();
								}
								if(vandorList.size()>0){
									for (final Map<String, Object> map2 : vandorList) {
										String UnloadComment=(String)map2.get("UnloadComment".toUpperCase());
										String Vendor=(String)map2.get("Vendor".toUpperCase());
										String VendorNumber=(String)map2.get("VendorNumber".toUpperCase());
										wastePaperUnloadTrucks.setUnloadcomment(UnloadComment);
										wastePaperUnloadTrucks.setVandor(Vendor);
										wastePaperUnloadTrucks.setVandornumber(VendorNumber);
									}
								}
							}catch(Exception rlt){
								rlt.printStackTrace();
							}
						}*/
						//wastePaperUnloadTrucks.setTruckcount(1);
						unloadTrucks.add(wastePaperUnloadTrucks);	
					}
					
				}
				}
				catch(Exception rlt){
				System.out.println("Roshan Says, You Have An Error In WastePaperTrucksUnloadDaoImp.java..Please Contact To Him.");
				rlt.printStackTrace();
			}
			date.add(Calendar.DATE, 1);
			}
		return unloadTrucks;
	}

}

package com.st.wastepaper.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.joda.time.DateTime;
import org.joda.time.Days;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.st.common.CommonUtil;
import com.st.wastepaper.mapper.OpeningClosingMapper;
import com.st.wastepaper.model.BarcodeComman;
import com.st.wastepaper.model.WastePaperBaleInventory;

@Repository
public class BarcodeUnloadBalesReportDaoImp implements BarcodeUnloadBalesReportDao{

	@Autowired
	@Qualifier("dataSourceProduction")
	private DataSource dataSourceP;
	
	@Autowired
	private DataSource dataSource;
	
	private SimpleDateFormat dateFormat=new SimpleDateFormat("MM-dd-yyyy");
	
	@Override
	public List<WastePaperBaleInventory> getUnloadBales(Date sdate,Date edate) {
		
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSourceP);
		List<WastePaperBaleInventory> unloadDetails= new ArrayList<WastePaperBaleInventory>();
		
		
		System.out.println("Fetching BARCODE Unload BALES -ST PAPER- GRADEWISE <START> - ST Paper");
		
		int days=Days.daysBetween(new DateTime(sdate.getTime()), new DateTime(edate.getTime())).getDays();
		
		Calendar date=Calendar.getInstance();
		date.setTime(sdate);
		
		for (int i = 0; i <=days; i++) {
			

			Calendar scal=Calendar.getInstance();
			scal.setTime(date.getTime());
			scal.set(Calendar.HOUR_OF_DAY, 6);
			scal.set(Calendar.MINUTE, 0);
			scal.set(Calendar.SECOND, 0);
			scal.set(Calendar.MILLISECOND, 0);
	
			
			Calendar ecal=Calendar.getInstance();
			ecal.setTime(date.getTime());
			ecal.set(Calendar.HOUR_OF_DAY, 5);
			ecal.set(Calendar.MINUTE, 59);
			ecal.set(Calendar.SECOND, 59);
			ecal.set(Calendar.MILLISECOND, 0);
			ecal.add(Calendar.DATE, 1);
			
			Calendar frmCal=Calendar.getInstance();
			frmCal.setTime(scal.getTime());
			frmCal.add(Calendar.DATE, -1);
			
			Calendar toCal=Calendar.getInstance();
			toCal.setTime(date.getTime());
			toCal.add(Calendar.DATE, 0);
			MapSqlParameterSource source=new MapSqlParameterSource();
			
			source.addValue("sdate", new Timestamp(scal.getTime().getTime()));
			source.addValue("edate", new Timestamp(ecal.getTime().getTime()));
			
			
			final WastePaperBaleInventory wastePaperBaleInventory=new WastePaperBaleInventory();

			Date dateS=scal.getTime();
			wastePaperBaleInventory.setDate(dateS);
			
			int _totalBalesCount=0;
			double _totalBaleWeightCount=0.0;

			double totalbalesweightofmwl=0;
			int totalbalesofmwl=0;
			
			double totalbalesweightofpmix=0;
			int totalbalesofpmix=0;
			
			double totalbalesweightofmcl=0;
			int totalbalesofmcl=0;
			
			double totalbalesweightofmwlwigs=0;
			int totalbalesofmwlwigs=0;
			
			double totalbalesweightofcbs=0;
			int totalbalesofcbs=0;
			
			double totalbalesweightofctdgdwd=0;
			int totalbalesofctdgdwd=0;
			
			double totalbalesweightofswl=0;
			int totalbalesofswl=0;
			
			double totalbalesweightofunctdflyleafshvgs=0;
			int totalbalesofunctdflyleafshvgs=0;
			
			double totalbalesweightoflightprtsbs=0;
			int totalbalesoflightprtsbs=0;
			
			double totalbalesweightofhw=0;
			int totalbalesofhw=0;
			
			double totalbalesweightofheavyprtsbs=0;
			int totalbalesofheavyprtsbs=0;
			
			double totalbalesweightofsow=0;
			int totalbalesofsow=0;
			
			double totalbalesweightofnewsblank=0;
			int totalbalesofnewsblank=0;
			
			double totalbalesweightofocccorrugated=0;
			int totalbalesofocccorrugated=0;
			
			double totalbalesweightofdlk=0;
			int totalbalesofdlk=0;
			
			double totalbalesweightofmixedpaper=0;
			int totalbalesofmixedpaper=0;
			
			double totalbalesweightofsoftwoodchips=0;
			int totalbalesofsoftwoodchips=0;
			
			double totalbalesweightofhardwoodchips=0;
			int totalbalesofhardwoodchips=0;
			
			double totalbalesweightofpwe=0;
			int totalbalesofpwe=0;
			
			double totalbalesweightofpulpwetlap=0;
			int totalbalesofpulpwetlap=0;
			
			double totalbalesweightofvirginpulp=0;
			int totalbalesofvirginpulp=0;
			
			double totalbalesweightofpulpdrylap=0;
			int totalbalesofpulpdrylap=0;
			
			double totalbalesweightofother=0;
			int totalbalesofother=0;
			
			double totalbalesweightofotherrolls=0;
			int totalbalesofotherrolls=0;
			
			double totalbalesweightofstbaleswetlap=0;
			int totalbalesofstbaleswetlap=0;
			
			double totalbalesweightofVirginSoftWood=0;
			int totalbalesofVirginSoftWood=0;
			
			double totalbalesweightofVirginHardWood=0;
			int totalbalesofVirginHardWood=0;
			
			double totalbalesweightofVirginEucalyptus=0;
			int totalbalesofVirginEucalyptus=0;
			
			double totalbalesweightofScnNews=0;
			int totalbalesofScnNews =0;
			
			double totalbalesweightofVirginSW_Fluff=0;
			int totalbalesofVirginSW_Fluff=0;
			
			
			/*System.out.println("Starts Date:"+dateFormat.format(scal.getTime().getTime()));
			System.out.println("Ends Date:"+dateFormat.format(ecal.getTime().getTime()));*/
			
			try{
				/*String sqlForUnloadDetails="SELECT [UnloadDate], sum(BaleWeight)/2000 as BALEWT,[GradeCode],count(*) as COUNTBALE FROM [tblBaleInventory]  "
						+ "where [UnloadDate] between ? and ? AND [GradeCode] in (select GradeCode from tlkpGrade ) "
						+ "group by [UnloadDate],[GradeCode] ";*/
				/*String sqlForUnloadDetails="SELECT count(*) as COUNTBALE, tblPrintLabels.GradeCode, tblPrintLabels.PrintDate, First(tblPrintLabels.PrintTime) AS TimePrint, "
						+ " Sum(tblBaleInventory.BaleWeight)/2000 as BALEWT FROM tblPrintLabels INNER JOIN tblBaleInventory ON tblPrintLabels.TagID = tblBaleInventory.TagID  "
						+ "GROUP BY  tblPrintLabels.GradeCode, tblPrintLabels.PrintDate HAVING (((tblPrintLabels.PrintDate) between ? and ? ));";
				*/
//				/*
//				 * String
//				 * sqlForUnloadDetails="SELECT tblPrintLabels.ReleaseNumber, Count(tblBaleInventory.TagID) AS COUNTBALE, tblPrintLabels.Trailer, tblPrintLabels.GradeCode, "
//				 * +
//				 * " tblPrintLabels.Grade, tblPrintLabels.PrintDate, First(tblPrintLabels.PrintTime) AS TimePrint, Sum(tblBaleInventory.BaleWeight/2000) AS BALEWT, IIf([tblPrintLabels]![GradeCode]=95,'',[tblPrintLabels]![PickupPoint]) AS PickUpPnt "
//				 * +
//				 * " FROM tblPrintLabels INNER JOIN tblBaleInventory ON tblPrintLabels.TagID = tblBaleInventory.TagID  WHERE ((tblBaleInventory.GradeCode)<>40 And (tblBaleInventory.GradeCode)<>50) "
//				 * +
//				 * " GROUP BY tblPrintLabels.ReleaseNumber, tblPrintLabels.Trailer, tblPrintLabels.GradeCode, tblPrintLabels.Grade, tblPrintLabels.PrintDate, IIf([tblPrintLabels]![GradeCode]=95,'',[tblPrintLabels]![PickupPoint]) "
//				 * + " HAVING ((First(tblPrintLabels.PrintTime) Between ? And ?))";
				
				
//				 */
				System.out.println(new Timestamp(frmCal.getTime().getTime())+""+new Timestamp(toCal.getTime().getTime()));
				 String sqlForUnloadDetails="select bl.ReleaseNumber, bl.[UnloadDate],pl.PrintTime as TimePrint ,sum(bl.BaleWeight)/2000 as BALEWT,pl.[GradeCode],count(*) as COUNTBALE"  
				 		+" from tblBaleInventory as bl INNER JOIN tblPrintLabels as pl ON pl.TagID = bl.TagID "  
				 		+"  where pl.GradeCode in (select GradeCode from [production].[dbo].[tlkpGrade] ) and "
				 		+"  bl.[UnloadDate]  Between ? And ?  group by pl.GradeCode,bl.ReleaseNumber, bl.[UnloadDate],pl.PrintTime";				
				List<Map<String, Object>> mapList=new ArrayList<Map<String,Object>>();
				
				/*System.out.println("SDAte:"+scal.getTime());
				System.out.println("lDAtew:"+ecal.getTime());*/
				
				try {
					mapList=jdbcTemplate.queryForList(sqlForUnloadDetails,new Object[]{
							new Timestamp(frmCal.getTime().getTime()),
							new Timestamp(toCal.getTime().getTime())
							});
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				if(mapList.size()>0){
					
					for (final Map<String, Object> map1 : mapList) {
						
						
							double _totalBaleWeight=map1.get("BALEWT")==null?0:(Double)map1.get("BALEWT");
							int _totalBales=map1.get("COUNTBALE")==null?0:(Integer)map1.get("COUNTBALE");
							int _gradeCode=(Integer)map1.get("GradeCode");
							Integer releaseNumber=(Integer)map1.get("ReleaseNumber");
							
							Date timePrint=(Date)map1.get("TimePrint");
							String timePrint1=(String)timePrint.toString();
							
							/*Below Code Is Related To ST Paper Bales And Add In Critical Condition Beacuse The Date Is Not Entered By Them But Still Issue Is Onn. */							
							if(timePrint1.equalsIgnoreCase("2016-10-20 03:26:11.0") && _gradeCode==13 && releaseNumber==61554){
								_totalBalesCount =_totalBalesCount+ 8;
								wastePaperBaleInventory.setTotalbales(_totalBalesCount);
								_totalBaleWeightCount=_totalBaleWeightCount+4.40;
								wastePaperBaleInventory.setTotalbalesweight(_totalBaleWeightCount);
							
								wastePaperBaleInventory.setTotalbalesweightOfstbaleswetlap(4.40);
								wastePaperBaleInventory.setTotalbalesOfstbaleswetlap(8);
							}
							
							if(_gradeCode==95){
								
								_totalBalesCount = _totalBalesCount + _totalBales;
								wastePaperBaleInventory.setTotalbales(_totalBalesCount);
								
								
								_totalBaleWeightCount=_totalBaleWeightCount+_totalBaleWeight;
								wastePaperBaleInventory.setTotalbalesweight(_totalBaleWeightCount);
								
								totalbalesofstbaleswetlap = totalbalesofstbaleswetlap + _totalBales;
								totalbalesweightofstbaleswetlap=totalbalesweightofstbaleswetlap+_totalBaleWeight;
								
								wastePaperBaleInventory.setTotalbalesweightOfstbaleswetlap(totalbalesweightofstbaleswetlap);
								wastePaperBaleInventory.setTotalbalesOfstbaleswetlap(totalbalesofstbaleswetlap);
							}
							else{
								String sql="select [LoadStatus] as status from tblPurchaseHeader where [ReleaseNumber]=?";
								List<Map<String, Object>> releaseList=new ArrayList<Map<String,Object>>();
								try{
									releaseList=jdbcTemplate.queryForList(sql,new Object[]{releaseNumber});
									if(releaseList.size()>0){
										
										for(final Map<String, Object> map2 : releaseList){
											
											String status=(String)map2.get("status");
											if(!status.equalsIgnoreCase("Complete")){
												
												System.out.println("Release:"+releaseNumber+"Status Is Not Complete....It Is:"+status);
											}else{
												
												/*double _totalBaleWeight=map1.get("BALEWT")==null?0:(Double)map1.get("BALEWT");
												int _totalBales=map1.get("COUNTBALE")==null?0:(Integer)map1.get("COUNTBALE");
												int _gradeCode=(Integer)map1.get("GradeCode");*/
										
												_totalBalesCount = _totalBalesCount + _totalBales;
												wastePaperBaleInventory.setTotalbales(_totalBalesCount);
												
												
												_totalBaleWeightCount=_totalBaleWeightCount+_totalBaleWeight;
												wastePaperBaleInventory.setTotalbalesweight(_totalBaleWeightCount);
												
												if(_gradeCode==1){
													totalbalesofmwl = totalbalesofmwl + _totalBales;
													totalbalesweightofmwl=totalbalesweightofmwl+_totalBaleWeight;
													
													wastePaperBaleInventory.setTotalbalesweightOfmwl(totalbalesweightofmwl);
													wastePaperBaleInventory.setTotalbalesOfmwl(totalbalesofmwl);
												}
												if(_gradeCode==2){
													totalbalesofpmix = totalbalesofpmix + _totalBales;
													totalbalesweightofpmix=totalbalesweightofpmix+_totalBaleWeight;
													
													wastePaperBaleInventory.setTotalbalesweightOfpmix(totalbalesweightofpmix);
													wastePaperBaleInventory.setTotalbalesOfpmix(totalbalesofpmix);
												}
												if(_gradeCode==3){
													totalbalesofmcl = totalbalesofmcl+ _totalBales;
													totalbalesweightofmcl=totalbalesweightofmcl+_totalBaleWeight;
													
													wastePaperBaleInventory.setTotalbalesweightOfmcl(totalbalesweightofmcl);
													wastePaperBaleInventory.setTotalbalesOfmcl(totalbalesofmcl);
												}
												if(_gradeCode==4){
													totalbalesofmwlwigs = totalbalesofmwlwigs + _totalBales;
													totalbalesweightofmwlwigs=totalbalesweightofmwlwigs+_totalBaleWeight;
													
													wastePaperBaleInventory.setTotalbalesweightOfmwlwigs(totalbalesweightofmwlwigs);
													wastePaperBaleInventory.setTotalbalesOfmwlwigs(totalbalesofmwlwigs);
												}
												if(_gradeCode==5){
													totalbalesofcbs = totalbalesofcbs + _totalBales;
													totalbalesweightofcbs=totalbalesweightofcbs+_totalBaleWeight;
													
													wastePaperBaleInventory.setTotalbalesweightOfcbs(totalbalesweightofcbs);
													wastePaperBaleInventory.setTotalbalesOfcbs(totalbalesofcbs);
												}
												if(_gradeCode==6){
													totalbalesofctdgdwd = totalbalesofctdgdwd + _totalBales;
													totalbalesweightofctdgdwd=totalbalesweightofctdgdwd+_totalBaleWeight;
													
													wastePaperBaleInventory.setTotalbalesweightOfctdgdwd(totalbalesweightofctdgdwd);
													wastePaperBaleInventory.setTotalbalesOfctdgdwd(totalbalesofctdgdwd);
												}
												if(_gradeCode==7){
													totalbalesofswl = totalbalesofswl + _totalBales;
													totalbalesweightofswl=totalbalesweightofswl+_totalBaleWeight;
													
													wastePaperBaleInventory.setTotalbalesweightOfswl(totalbalesweightofswl);
													wastePaperBaleInventory.setTotalbalesOfswl(totalbalesofswl);
												}
												if(_gradeCode==8){
													totalbalesofunctdflyleafshvgs = totalbalesofunctdflyleafshvgs + _totalBales;
													totalbalesweightofunctdflyleafshvgs=totalbalesweightofunctdflyleafshvgs+_totalBaleWeight;
													
													wastePaperBaleInventory.setTotalbalesweightOfunctdflyleafshvgs(totalbalesweightofunctdflyleafshvgs);
													wastePaperBaleInventory.setTotalbalesOfunctdflyleafshvgs(totalbalesofunctdflyleafshvgs);
												}
												if(_gradeCode==9){
													totalbalesofScnNews = totalbalesofScnNews + _totalBales;
													totalbalesweightofScnNews=totalbalesweightofScnNews+_totalBaleWeight;
													
													wastePaperBaleInventory.setTotalbalesweightofScnNews(totalbalesweightofScnNews);
													wastePaperBaleInventory.setTotalbalesofScnNews(totalbalesofScnNews);
												}
												if(_gradeCode==10){
													totalbalesoflightprtsbs = totalbalesoflightprtsbs + _totalBales;
													totalbalesweightoflightprtsbs=totalbalesweightoflightprtsbs+_totalBaleWeight;
													
													wastePaperBaleInventory.setTotalbalesweightOflightprtsbs(totalbalesweightoflightprtsbs);
													wastePaperBaleInventory.setTotalbalesOflightprtsbs(totalbalesoflightprtsbs);
												}
												if(_gradeCode==11){
													totalbalesofhw = totalbalesofhw + _totalBales;
													totalbalesweightofhw=totalbalesweightofhw+_totalBaleWeight;
													
													wastePaperBaleInventory.setTotalbalesweightOfhw(totalbalesweightofhw);
													wastePaperBaleInventory.setTotalbalesOfhw(totalbalesofhw);
												}
												if(_gradeCode==12){
													totalbalesofheavyprtsbs = totalbalesofheavyprtsbs + _totalBales;
													totalbalesweightofheavyprtsbs=totalbalesweightofheavyprtsbs+_totalBaleWeight;
													
													wastePaperBaleInventory.setTotalbalesweightOfheavyprtsbs(totalbalesweightofheavyprtsbs);
													wastePaperBaleInventory.setTotalbalesOfheavyprtsbs(totalbalesofheavyprtsbs);
												}
												if(_gradeCode==13){
													totalbalesofsow = totalbalesofsow + _totalBales;
													totalbalesweightofsow=totalbalesweightofsow+_totalBaleWeight;
													
													wastePaperBaleInventory.setTotalbalesweightOfsow(totalbalesweightofsow);
													wastePaperBaleInventory.setTotalbalesOfsow(totalbalesofsow);
												}
												if(_gradeCode==16){
													totalbalesofnewsblank = totalbalesofnewsblank + _totalBales;
													totalbalesweightofnewsblank=totalbalesweightofnewsblank+_totalBaleWeight;
													
													wastePaperBaleInventory.setTotalbalesweightOfnewsblank(totalbalesweightofnewsblank);
													wastePaperBaleInventory.setTotalbalesOfnewsblank(totalbalesofnewsblank);
												}
												if(_gradeCode==23){
													totalbalesofocccorrugated = totalbalesofocccorrugated + _totalBales;
													totalbalesweightofocccorrugated=totalbalesweightofocccorrugated+_totalBaleWeight;
													
													wastePaperBaleInventory.setTotalbalesweightOfocccorrugated(totalbalesweightofocccorrugated);
													wastePaperBaleInventory.setTotalbalesOfocccorrugated(totalbalesofocccorrugated);
												}
												if(_gradeCode==24){
													totalbalesofdlk = totalbalesofdlk + _totalBales;
													totalbalesweightofdlk=totalbalesweightofdlk+_totalBaleWeight;
													
													wastePaperBaleInventory.setTotalbalesweightOfdlk(totalbalesweightofdlk);
													wastePaperBaleInventory.setTotalbalesOfdlk(totalbalesofdlk);
												}
												if(_gradeCode==30){
													totalbalesofmixedpaper = totalbalesofmixedpaper + _totalBales;
													totalbalesweightofmixedpaper=totalbalesweightofmixedpaper+_totalBaleWeight;
													
													wastePaperBaleInventory.setTotalbalesweightOfmixedpaper(totalbalesweightofmixedpaper);
													wastePaperBaleInventory.setTotalbalesOfmixedpaper(totalbalesofmixedpaper);
												}
												/*if(_gradeCode==40){
													totalbalesofsoftwoodchips = totalbalesofsoftwoodchips + _totalBales;
													totalbalesweightofsoftwoodchips=totalbalesweightofsoftwoodchips+_totalBaleWeight;
													
													wastePaperBaleInventory.setTotalbalesweightOfsoftwoodchips(totalbalesweightofsoftwoodchips);
													wastePaperBaleInventory.setTotalbalesOfsoftwoodchips(totalbalesofsoftwoodchips);
												}
												if(_gradeCode==50){
													totalbalesofhardwoodchips = totalbalesofhardwoodchips + _totalBales;
													totalbalesweightofhardwoodchips=totalbalesweightofhardwoodchips+_totalBaleWeight;
													
													wastePaperBaleInventory.setTotalbalesweightOfhardwoodchips(totalbalesweightofhardwoodchips);
													wastePaperBaleInventory.setTotalbalesOfhardwoodchips(totalbalesofhardwoodchips);
												}*/
												if(_gradeCode==56){
													totalbalesofpwe = totalbalesofpwe + _totalBales;
													totalbalesweightofpwe=totalbalesweightofpwe+_totalBaleWeight;
													
													wastePaperBaleInventory.setTotalbalesweightOfpwe(totalbalesweightofpwe);
													wastePaperBaleInventory.setTotalbalesOfpwe(totalbalesofpwe);
												}
												if(_gradeCode==70){
													totalbalesofpulpwetlap = totalbalesofpulpwetlap + _totalBales;
													totalbalesweightofpulpwetlap=totalbalesweightofpulpwetlap+_totalBaleWeight;
													
													wastePaperBaleInventory.setTotalbalesweightOfpulpwetlap(totalbalesweightofpulpwetlap);
													wastePaperBaleInventory.setTotalbalesOfpulpwetlap(totalbalesofpulpwetlap);
												}
												if(_gradeCode==71){
													totalbalesofVirginHardWood = totalbalesofVirginHardWood + _totalBales;
													totalbalesweightofVirginHardWood=totalbalesweightofVirginHardWood+_totalBaleWeight;
													
													wastePaperBaleInventory.setTotalbalesweightofVirginHardWood(totalbalesweightofVirginHardWood);
													wastePaperBaleInventory.setTotalbalesofVirginHardWood(totalbalesofVirginHardWood);
												}
												if(_gradeCode==72){
													totalbalesofVirginSoftWood = totalbalesofVirginSoftWood + _totalBales;
													totalbalesweightofVirginSoftWood=totalbalesweightofVirginSoftWood+_totalBaleWeight;
													
													wastePaperBaleInventory.setTotalbalesweightofVirginSoftWood(totalbalesweightofVirginSoftWood);
													wastePaperBaleInventory.setTotalbalesofVirginSoftWood(totalbalesofVirginSoftWood);
												}												
												if(_gradeCode==73){
													totalbalesofVirginEucalyptus = totalbalesofVirginEucalyptus + _totalBales;
													totalbalesweightofVirginEucalyptus=totalbalesweightofVirginEucalyptus+_totalBaleWeight;
													
													wastePaperBaleInventory.setTotalbalesweightofVirginEucalyptus(totalbalesweightofVirginEucalyptus);
													wastePaperBaleInventory.setTotalbalesofVirginEucalyptus(totalbalesofVirginEucalyptus);
												}
												if(_gradeCode==75){
													totalbalesofvirginpulp = totalbalesofvirginpulp + _totalBales;
													totalbalesweightofvirginpulp=totalbalesweightofvirginpulp+_totalBaleWeight;
													
													wastePaperBaleInventory.setTotalbalesweightOfvirginpulp(totalbalesweightofvirginpulp);
													wastePaperBaleInventory.setTotalbalesOfvirginpulp(totalbalesofvirginpulp);
												}
												if(_gradeCode==79){
													totalbalesofVirginSW_Fluff = totalbalesofVirginSW_Fluff + _totalBales;
													totalbalesweightofVirginSW_Fluff=totalbalesweightofVirginSW_Fluff+_totalBaleWeight;
													
													wastePaperBaleInventory.setTotalbalesweightofVirginSW_Fluff(totalbalesweightofVirginSW_Fluff);
													wastePaperBaleInventory.setTotalbalesofVirginSW_Fluff(totalbalesofVirginSW_Fluff);
												}
												if(_gradeCode==87){
													totalbalesofpulpdrylap = totalbalesofpulpdrylap + _totalBales;
													totalbalesweightofpulpdrylap=totalbalesweightofpulpdrylap+_totalBaleWeight;
													
													wastePaperBaleInventory.setTotalbalesweightOfpulpdrylap(totalbalesweightofpulpdrylap);
													wastePaperBaleInventory.setTotalbalesOfpulpdrylap(totalbalesofpulpdrylap);
												}
												if(_gradeCode==90){
													totalbalesofother = totalbalesofother + _totalBales;
													totalbalesweightofother=totalbalesweightofother+_totalBaleWeight;
													
													wastePaperBaleInventory.setTotalbalesweightOfother(totalbalesweightofother);
													wastePaperBaleInventory.setTotalbalesOfother(totalbalesofother);
												}
												if(_gradeCode==91){
													totalbalesofotherrolls = totalbalesofotherrolls + _totalBales;
													totalbalesweightofotherrolls=totalbalesweightofotherrolls+_totalBaleWeight;
													
													wastePaperBaleInventory.setTotalbalesweightOfotherrolls(totalbalesweightofotherrolls);
													wastePaperBaleInventory.setTotalbalesOfotherrolls(totalbalesofotherrolls);
												}
												/*if(_gradeCode==95){
													totalbalesofstbaleswetlap = totalbalesofstbaleswetlap + _totalBales;
													totalbalesweightofstbaleswetlap=totalbalesweightofstbaleswetlap+_totalBaleWeight;
													
													wastePaperBaleInventory.setTotalbalesweightOfstbaleswetlap(totalbalesweightofstbaleswetlap);
													wastePaperBaleInventory.setTotalbalesOfstbaleswetlap(totalbalesofstbaleswetlap);
												}*/
											}
										}
									}else{
										
									}
								}catch(Exception rlt){
									System.out.println("Roshan Says, You HAve An Error In BarcodeUnloadBalesReportDaoImp.java At Line 204");
									rlt.printStackTrace();
								}
								
							}
							
							
						}
					wastePaperBaleInventory.setTotalbales(_totalBalesCount);
					wastePaperBaleInventory.setTotalbalesweight(_totalBaleWeightCount);
					}
				}
				
				
			catch(Exception rlt){
				System.out.println("You Have A Problem In WastePaperUnloadBaleController.java at first section.");
				rlt.printStackTrace();
			}
			unloadDetails.add(wastePaperBaleInventory);	
			date.add(Calendar.DATE, 1);
			}
		System.out.println("Fetching BARCODE UNLOAD BALES - GRADEWISE <END> - ST Paper");
		return unloadDetails;
	}

	@Override
	public List<BarcodeComman> getOpenMonth(int month, int year) {
		// TODO Auto-generated method stub
		
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);

	    String sql="Select * from barcodeOpeningClosing where [closemonth]=? AND [closeyear]=?";
		
		List<Map<String, Object>> mapList=new ArrayList<Map<String,Object>>();
		
		final BarcodeComman barcodeComman=new BarcodeComman();
		
		List<BarcodeComman> barcodeDetails= new ArrayList<BarcodeComman>();
		try{
			mapList=jdbcTemplate.queryForList(sql,new Object[]{
					month,
					year
			});
		}catch(Exception rlt){
			System.out.println("You Have A Problem In WastePaperConsumedBalesdaoImp.java At getOpenMonth Method.");
			rlt.printStackTrace();
		}
		if(mapList.size()>0){
			for(Map<String, Object> map:mapList){
				int prtmix=map.get("Prtmix")==null?0:(Integer)map.get("Prtmix");
				int mwl=map.get("MWL")==null?0:(Integer)map.get("MWL");
				int mcl=map.get("MCL")==null?0:(Integer)map.get("MCL");
				int mwlwigs=map.get("MWLWIGS")==null?0:(Integer)map.get("MWLWIGS");
				int cbs=map.get("CBS")==null?0:(Integer)map.get("CBS");
				int ctdGdwd=map.get("CtdGdwd")==null?0:(Integer)map.get("CtdGdwd");
				int swlsortedwhite=map.get("SWLSortedWhite")==null?0:(Integer)map.get("SWLSortedWhite");
				int onpolnNewsprint=map.get("ONPOldNewsPrint")==null?0:(Integer)map.get("ONPOldNewsPrint");
				int oinews=map.get("OINews")==null?0:(Integer)map.get("OINews");
				int lightprtsbs=map.get("LightPrtSBS")==null?0:(Integer)map.get("LightPrtSBS");
				int hw=map.get("HW")==null?0:(Integer)map.get("HW");
				int heavyprtsbs=map.get("HeavyPrtSBS")==null?0:(Integer)map.get("HeavyPrtSBS");
				int sow=map.get("SOW")==null?0:(Integer)map.get("SOW");
				int unprtsbs=map.get("UnprtSBS")==null?0:(Integer)map.get("UnprtSBS");
				int newsblank=map.get("Newsblank")==null?0:(Integer)map.get("Newsblank");
				int whitegdwdblend=map.get("WhiteGdwdBlend")==null?0:(Integer)map.get("WhiteGdwdBlend");
				int mailundeliverable=map.get("MailUndeliverable")==null?0:(Integer)map.get("MailUndeliverable");
				int hoggedbooks=map.get("HoggedBooks")==null?0:(Integer)map.get("HoggedBooks");
				int occ=map.get("OCC")==null?0:(Integer)map.get("OCC");
				int dlk=map.get("DLK")==null?0:(Integer)map.get("DLK");
				int mixedpaper=map.get("MixedPaper")==null?0:(Integer)map.get("MixedPaper");
				int softwoodchips=map.get("SoftWoodChips")==null?0:(Integer)map.get("SoftWoodChips");
				int hardwoodchips=map.get("HardWoodChips")==null?0:(Integer)map.get("HardWoodChips");
				int whitebroke=map.get("WhiteBroke")==null?0:(Integer)map.get("WhiteBroke");
				int pwe=map.get("PWE")==null?0:(Integer)map.get("PWE");
				int brownnapkinbroke=map.get("BrownNapkinBroke")==null?0:(Integer)map.get("BrownNapkinBroke");
				int pulpwetlap=map.get("PULPWetLap")==null?0:(Integer)map.get("PULPWetLap");
				int virginpulp=map.get("VirginPulp")==null?0:(Integer)map.get("VirginPulp");
				int brownwetLap=map.get("BrownWetLap")==null?0:(Integer)map.get("BrownWetLap");
				int pulpdryLap=map.get("PulpDryLap")==null?0:(Integer)map.get("PulpDryLap");
				int otherrolls=map.get("OtherRolls")==null?0:(Integer)map.get("OtherRolls");
				int stbaleswetlap=map.get("STBaleswetlap")==null?0:(Integer)map.get("STBaleswetlap");
				int sttbaledbrokebutl=map.get("STTBaledBrokeButl")==null?0:(Integer)map.get("STTBaledBrokeButl");
				int UnctdFlyleafShvgs=map.get("UnctdFlyleafShvgs")==null?0:(Integer)map.get("UnctdFlyleafShvgs");
				int LooseEST=map.get("LooseEST")==null?0:(Integer)map.get("LooseEST");
				int virginSoftWood=map.get("virginSoftWood")==null?0:(Integer)map.get("virginSoftWood");
				int virginHardWood=map.get("virginHardWood")==null?0:(Integer)map.get("virginHardWood");
				int virginEucalyptus=map.get("virginEucalyptus")==null?0:(Integer)map.get("virginEucalyptus");
				//Col For Weight
				
				double Prtmixw=map.get("Prtmixw")==null?0:(double)map.get("Prtmixw");
				double MWLw=map.get("MWLw")==null?0:(double)map.get("MWLw");
				double MCLw=map.get("MCLw")==null?0:(double)map.get("MCLw");
				double MWLWIGSw=map.get("MWLWIGSw")==null?0:(double)map.get("MWLWIGSw");
				double CBSw=map.get("CBSw")==null?0:(double)map.get("CBSw");
				double CtdGdwdw=map.get("CtdGdwdw")==null?0:(double)map.get("CtdGdwdw");
				double SWLSortedWhitew=map.get("SWLSortedWhitew")==null?0:(double)map.get("SWLSortedWhitew");
				double ONPOldNewsPrintw=map.get("ONPOldNewsPrintw")==null?0:(double)map.get("ONPOldNewsPrintw");
				double OINewsw=map.get("OINewsw")==null?0:(double)map.get("OINewsw");
				double LightPrtSBSw=map.get("LightPrtSBSw")==null?0:(double)map.get("LightPrtSBSw");
				double HWw=map.get("HWw")==null?0:(double)map.get("HWw");
				double HeavyPrtSBSw=map.get("HeavyPrtSBSw")==null?0:(double)map.get("HeavyPrtSBSw");
				double SOWw=map.get("SOWw")==null?0:(double)map.get("SOWw");
				double UnprtSBSw=map.get("UnprtSBSw")==null?0:(double)map.get("UnprtSBSw");
				double Newsblankw=map.get("Newsblankw")==null?0:(double)map.get("Newsblankw");
				double WhiteGdwdBlendw=map.get("WhiteGdwdBlendw")==null?0:(double)map.get("WhiteGdwdBlendw");
				double MailUndeliverablew=map.get("MailUndeliverablew")==null?0:(double)map.get("MailUndeliverablew");
				double HoggedBooksw=map.get("HoggedBooksw")==null?0:(double)map.get("HoggedBooksw");
				double OCCw=map.get("OCCw")==null?0:(double)map.get("OCCw");
				double DLKw=map.get("DLKw")==null?0:(double)map.get("DLKw");
				double MixedPaperw=map.get("MixedPaperw")==null?0:(double)map.get("MixedPaperw");
				double SoftWoodChipsw=map.get("SoftWoodChipsw")==null?0:(double)map.get("SoftWoodChipsw");
				double HardWoodChipsw=map.get("HardWoodChipsw")==null?0:(double)map.get("HardWoodChipsw");
				double WhiteBrokew=map.get("WhiteBrokew")==null?0:(double)map.get("WhiteBrokew");
				double PWEw=map.get("PWEw")==null?0:(double)map.get("PWEw");
				double BrownNapkinBrokew=map.get("BrownNapkinBrokew")==null?0:(double)map.get("BrownNapkinBrokew");
				double PULPWetLapw=map.get("PULPWetLapw")==null?0:(double)map.get("PULPWetLapw");
				double VirginPulpw=map.get("VirginPulpw")==null?0:(double)map.get("VirginPulpw");
				double BrownWetLapw=map.get("BrownWetLapw")==null?0:(double)map.get("BrownWetLapw");
				double PulpDryLapw=map.get("PulpDryLapw")==null?0:(double)map.get("PulpDryLapw");
				double OtherRollsw=map.get("OtherRollsw")==null?0:(double)map.get("OtherRollsw");
				double STBaleswetlapw=map.get("STBaleswetlapw")==null?0:(double)map.get("STBaleswetlapw");
				double STTBaledBrokeButlw=map.get("STTBaledBrokeButlw")==null?0:(double)map.get("STTBaledBrokeButlw");
				double UnctdFlyleafShvgsw=map.get("UnctdFlyleafShvgsw")==null?0:(double)map.get("UnctdFlyleafShvgsw");
				double LooseESTw=map.get("LooseESTw")==null?0:(double)map.get("LooseESTw");
				double virginSoftWoodw=map.get("virginSoftWoodw")==null?0:(double)map.get("virginSoftWoodw");
				double virginHardWoodw=map.get("virginHardWoodw")==null?0:(double)map.get("virginHardWoodw");
				double virginEucalyptusw=map.get("virginEucalyptusw")==null?0:(double)map.get("virginEucalyptusw");
				
				barcodeComman.setPrtmix(prtmix);
				barcodeComman.setMwl(mwl);
				barcodeComman.setMcl(mcl);
				barcodeComman.setMwlwigs(mwlwigs);
				barcodeComman.setCbs(cbs);
				barcodeComman.setCtdGdwd(ctdGdwd);
				barcodeComman.setSwlsortedwhite(swlsortedwhite);
				barcodeComman.setOnpolnNewsprint(onpolnNewsprint);
				barcodeComman.setOinews(oinews);
				barcodeComman.setLightprtsbs(lightprtsbs);
				barcodeComman.setHw(hw);
				barcodeComman.setHeavyprtsbs(heavyprtsbs);
				barcodeComman.setSow(sow);
				barcodeComman.setUnprtsbs(unprtsbs);
				barcodeComman.setNewsblank(newsblank);
				barcodeComman.setWhitegdwdblend(whitegdwdblend);
				barcodeComman.setMailundeliverable(mailundeliverable);
				barcodeComman.setHoggedbooks(hoggedbooks);
				barcodeComman.setOcc(occ);
				barcodeComman.setDlk(dlk);
				barcodeComman.setMixedpaper(mixedpaper);
				barcodeComman.setSoftwoodchips(softwoodchips);
				barcodeComman.setHardwoodchips(hardwoodchips);
				barcodeComman.setWhitebroke(whitebroke);
				barcodeComman.setPwe(pwe);
				barcodeComman.setBrownnapkinbroke(brownnapkinbroke);
				barcodeComman.setPulpwetlap(pulpwetlap);
				barcodeComman.setVirginpulp(virginpulp);
				barcodeComman.setBrownwetLap(brownwetLap);
				barcodeComman.setPulpdryLap(pulpdryLap);
				barcodeComman.setOtherrolls(otherrolls);
				barcodeComman.setStbaleswetlap(stbaleswetlap);
				barcodeComman.setSttbaledbrokebutl(sttbaledbrokebutl);
				barcodeComman.setUnctdflyleafshvgs(UnctdFlyleafShvgs);
				barcodeComman.setLooseest(LooseEST);
				barcodeComman.setVirginHardWood(virginHardWood);
				barcodeComman.setVirginHardWood(virginHardWood);
				barcodeComman.setVirginEucalyptus(virginEucalyptus);
				//Col Fpr Weight
				barcodeComman.setPrtmixw(Prtmixw);
				barcodeComman.setMwlw(MWLw);
				barcodeComman.setMclw(MCLw);
				barcodeComman.setMwlwigsw(MWLWIGSw);
				barcodeComman.setCbsw(CBSw);
				barcodeComman.setCtdGdwdw(CtdGdwdw);
				barcodeComman.setSwlsortedwhitew(SWLSortedWhitew);
				barcodeComman.setOnpolnNewsprintw(ONPOldNewsPrintw);
				barcodeComman.setOinewsw(OINewsw);
				barcodeComman.setLightprtsbsw(LightPrtSBSw);
				barcodeComman.setHww(HWw);
				barcodeComman.setHeavyprtsbsw(HeavyPrtSBSw);
				barcodeComman.setSoww(SOWw);
				barcodeComman.setUnprtsbsw(UnprtSBSw);
				barcodeComman.setNewsblankw(Newsblankw);
				barcodeComman.setWhitegdwdblendw(WhiteGdwdBlendw);
				barcodeComman.setMailundeliverablew(MailUndeliverablew);
				barcodeComman.setHoggedbooksw(HoggedBooksw);
				barcodeComman.setOccw(OCCw);
				barcodeComman.setDlkw(DLKw);
				barcodeComman.setMixedpaperw(MixedPaperw);
				barcodeComman.setSoftwoodchipsw(SoftWoodChipsw);
				barcodeComman.setHardwoodchipsw(HardWoodChipsw);
				barcodeComman.setWhitebrokew(WhiteBrokew);
				barcodeComman.setPwew(PWEw);
				barcodeComman.setBrownnapkinbrokew(BrownNapkinBrokew);
				barcodeComman.setPulpwetlapw(PULPWetLapw);
				barcodeComman.setVirginpulpw(VirginPulpw);
				barcodeComman.setBrownwetLapw(BrownWetLapw);
				barcodeComman.setPulpdryLapw(PulpDryLapw);
				barcodeComman.setOtherrollsw(OtherRollsw);
				barcodeComman.setStbaleswetlapw(STBaleswetlapw);
				barcodeComman.setSttbaledbrokebutlw(STTBaledBrokeButlw);
				barcodeComman.setUnctdflyleafshvgsw(UnctdFlyleafShvgsw);
				barcodeComman.setLooseestW(LooseESTw);
				barcodeComman.setVirginHardWoodw(virginHardWoodw);
				barcodeComman.setVirginHardWoodw(virginHardWoodw);
				barcodeComman.setVirginEucalyptusw(virginEucalyptusw);
				
			}
			barcodeDetails.add(barcodeComman);
		}
		
		return barcodeDetails;
	}

	@Override
	public List<BarcodeComman> getClosedMonth(int month, int year) {
		// TODO Auto-generated method stub
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		
		List<BarcodeComman> details=new ArrayList<BarcodeComman>();
		String sql="select * from barcodeOpeningClosing where [closemonth]=? AND [closeyear]=?";
		
		//List<BarcodeComman> monthClosing=jdbcTemplate.query(sql, new OpeningClosingMapper());
		
		List<Map<String, Object>> map=jdbcTemplate.queryForList(sql,new Object[]{
				month,year
		});
		for(Map<String, Object> map1:map){
			final BarcodeComman barcodeComman=new BarcodeComman();
			if(map1.size()>=0){
			
				int Prtmix=map1.get("Prtmix")==null?0:(Integer)map1.get("Prtmix");
				int MWL=map1.get("MWL")==null?0:(Integer)map1.get("MWL");
				int MCL=map1.get("MCL")==null?0:(Integer)map1.get("MCL");
				int MWLWIGS=map1.get("MWLWIGS")==null?0:(Integer)map1.get("MWLWIGS");
				int CBS=map1.get("CBS")==null?0:(Integer)map1.get("CBS");
				int CtdGdwd=map1.get("CtdGdwd")==null?0:(Integer)map1.get("CtdGdwd");
				int SWLSortedWhite=map1.get("SWLSortedWhite")==null?0:(Integer)map1.get("SWLSortedWhite");
				int ONPOldNewsPrint=map1.get("ONPOldNewsPrint")==null?0:(Integer)map1.get("ONPOldNewsPrint");
				int OINews=map1.get("OINews")==null?0:(Integer)map1.get("OINews");
				int LightPrtSBS=map1.get("LightPrtSBS")==null?0:(Integer)map1.get("LightPrtSBS");
				int HW=map1.get("HW")==null?0:(Integer)map1.get("HW");
				int HeavyPrtSBS=map1.get("HeavyPrtSBS")==null?0:(Integer)map1.get("HeavyPrtSBS");
				int SOW=map1.get("SOW")==null?0:(Integer)map1.get("SOW");
				int UnprtSBS=map1.get("UnprtSBS")==null?0:(Integer)map1.get("UnprtSBS");
				int Newsblank=map1.get("Newsblank")==null?0:(Integer)map1.get("Newsblank");
				int WhiteGdwdBlend=map1.get("WhiteGdwdBlend")==null?0:(Integer)map1.get("WhiteGdwdBlend");
				int MailUndeliverable=map1.get("MailUndeliverable")==null?0:(Integer)map1.get("MailUndeliverable");
				int HoggedBooks=map1.get("HoggedBooks")==null?0:(Integer)map1.get("HoggedBooks");
				int OCC=map1.get("OCC")==null?0:(Integer)map1.get("OCC");
				int DLK=map1.get("DLK")==null?0:(Integer)map1.get("DLK");
				int MixedPaper=map1.get("MixedPaper")==null?0:(Integer)map1.get("MixedPaper");
				int SoftWoodChips=map1.get("SoftWoodChips")==null?0:(Integer)map1.get("SoftWoodChips");
				int HardWoodChips=map1.get("HardWoodChips")==null?0:(Integer)map1.get("HardWoodChips");
				int WhiteBroke=map1.get("WhiteBroke")==null?0:(Integer)map1.get("WhiteBroke");
				int PWE=map1.get("PWE")==null?0:(Integer)map1.get("PWE");
				int BrownNapkinBroke=map1.get("BrownNapkinBroke")==null?0:(Integer)map1.get("BrownNapkinBroke");
				int PULPWetLap=map1.get("PULPWetLap")==null?0:(Integer)map1.get("PULPWetLap");
				int VirginPulp=map1.get("VirginPulp")==null?0:(Integer)map1.get("VirginPulp");
				int BrownWetLap=map1.get("BrownWetLap")==null?0:(Integer)map1.get("BrownWetLap");
				int PulpDryLap=map1.get("PulpDryLap")==null?0:(Integer)map1.get("PulpDryLap");
				int OtherRolls=map1.get("OtherRolls")==null?0:(Integer)map1.get("OtherRolls");
				int STBaleswetlap=map1.get("STBaleswetlap")==null?0:(Integer)map1.get("STBaleswetlap");
				int STTBaledBrokeButl=map1.get("STTBaledBrokeButl")==null?0:(Integer)map1.get("STTBaledBrokeButl");
				int UnctdFlyleafShvgs=map1.get("UnctdFlyleafShvgs")==null?0:(Integer)map1.get("UnctdFlyleafShvgs");
				int LooseEST=map1.get("LooseEST")==null?0:(Integer)map1.get("LooseEST");
				//Col For Weight
				
				double Prtmixw=map1.get("Prtmixw")==null?0:(double)map1.get("Prtmixw");
				double MWLw=map1.get("MWLw")==null?0:(double)map1.get("MWLw");
				double MCLw=map1.get("MCLw")==null?0:(double)map1.get("MCLw");
				double MWLWIGSw=map1.get("MWLWIGSw")==null?0:(double)map1.get("MWLWIGSw");
				double CBSw=map1.get("CBSw")==null?0:(double)map1.get("CBSw");
				double CtdGdwdw=map1.get("CtdGdwdw")==null?0:(double)map1.get("CtdGdwdw");
				double SWLSortedWhitew=map1.get("SWLSortedWhitew")==null?0:(double)map1.get("SWLSortedWhitew");
				double ONPOldNewsPrintw=map1.get("ONPOldNewsPrintw")==null?0:(double)map1.get("ONPOldNewsPrintw");
				double OINewsw=map1.get("OINewsw")==null?0:(double)map1.get("OINewsw");
				double LightPrtSBSw=map1.get("LightPrtSBSw")==null?0:(double)map1.get("LightPrtSBSw");
				double HWw=map1.get("HWw")==null?0:(double)map1.get("HWw");
				double HeavyPrtSBSw=map1.get("HeavyPrtSBSw")==null?0:(double)map1.get("HeavyPrtSBSw");
				double SOWw=map1.get("SOWw")==null?0:(double)map1.get("SOWw");
				double UnprtSBSw=map1.get("UnprtSBSw")==null?0:(double)map1.get("UnprtSBSw");
				double Newsblankw=map1.get("Newsblankw")==null?0:(double)map1.get("Newsblankw");
				double WhiteGdwdBlendw=map1.get("WhiteGdwdBlendw")==null?0:(double)map1.get("WhiteGdwdBlendw");
				double MailUndeliverablew=map1.get("MailUndeliverablew")==null?0:(double)map1.get("MailUndeliverablew");
				double HoggedBooksw=map1.get("HoggedBooksw")==null?0:(double)map1.get("HoggedBooksw");
				double OCCw=map1.get("OCCw")==null?0:(double)map1.get("OCCw");
				double DLKw=map1.get("DLKw")==null?0:(double)map1.get("DLKw");
				double MixedPaperw=map1.get("MixedPaperw")==null?0:(double)map1.get("MixedPaperw");
				double SoftWoodChipsw=map1.get("SoftWoodChipsw")==null?0:(double)map1.get("SoftWoodChipsw");
				double HardWoodChipsw=map1.get("HardWoodChipsw")==null?0:(double)map1.get("HardWoodChipsw");
				double WhiteBrokew=map1.get("WhiteBrokew")==null?0:(double)map1.get("WhiteBrokew");
				double PWEw=map1.get("PWEw")==null?0:(double)map1.get("PWEw");
				double BrownNapkinBrokew=map1.get("BrownNapkinBrokew")==null?0:(double)map1.get("BrownNapkinBrokew");
				double PULPWetLapw=map1.get("PULPWetLapw")==null?0:(double)map1.get("PULPWetLapw");
				double VirginPulpw=map1.get("VirginPulpw")==null?0:(double)map1.get("VirginPulpw");
				double BrownWetLapw=map1.get("BrownWetLapw")==null?0:(double)map1.get("BrownWetLapw");
				double PulpDryLapw=map1.get("PulpDryLapw")==null?0:(double)map1.get("PulpDryLapw");
				double OtherRollsw=map1.get("OtherRollsw")==null?0:(double)map1.get("OtherRollsw");
				double STBaleswetlapw=map1.get("STBaleswetlapw")==null?0:(double)map1.get("STBaleswetlapw");
				double STTBaledBrokeButlw=map1.get("STTBaledBrokeButlw")==null?0:(double)map1.get("STTBaledBrokeButlw");
				double UnctdFlyleafShvgsw=map1.get("UnctdFlyleafShvgsw")==null?0:(double)map1.get("UnctdFlyleafShvgsw");
				double LooseESTw=map1.get("LooseESTw")==null?0:(double)map1.get("LooseESTw");
			
				barcodeComman.setPrtmix(Prtmix);
				barcodeComman.setMwl(MWL);
				barcodeComman.setMcl(MCL);
				barcodeComman.setMwlwigs(MWLWIGS);
				barcodeComman.setCbs(CBS);
				barcodeComman.setCtdGdwd(CtdGdwd);
				barcodeComman.setSwlsortedwhite(SWLSortedWhite);
				barcodeComman.setOnpolnNewsprint(ONPOldNewsPrint);
				barcodeComman.setOinews(OINews);
				barcodeComman.setLightprtsbs(LightPrtSBS);
				barcodeComman.setHw(HW);
				barcodeComman.setHeavyprtsbs(HeavyPrtSBS);
				barcodeComman.setSow(SOW);
				barcodeComman.setUnprtsbs(UnprtSBS);
				barcodeComman.setNewsblank(Newsblank);
				barcodeComman.setWhitegdwdblend(WhiteGdwdBlend);
				barcodeComman.setMailundeliverable(MailUndeliverable);
				barcodeComman.setHoggedbooks(HoggedBooks);
				barcodeComman.setOcc(OCC);
				barcodeComman.setDlk(DLK);
				barcodeComman.setMixedpaper(MixedPaper);
				barcodeComman.setSoftwoodchips(SoftWoodChips);
				barcodeComman.setHardwoodchips(HardWoodChips);
				barcodeComman.setWhitebroke(WhiteBroke);
				barcodeComman.setPwe(PWE);
				barcodeComman.setBrownnapkinbroke(BrownNapkinBroke);
				barcodeComman.setPulpwetlap(PULPWetLap);
				barcodeComman.setVirginpulp(VirginPulp);
				barcodeComman.setBrownwetLap(BrownWetLap);
				barcodeComman.setPulpdryLap(PulpDryLap);
				barcodeComman.setOtherrolls(OtherRolls);
				barcodeComman.setStbaleswetlap(STBaleswetlap);
				barcodeComman.setSttbaledbrokebutl(STTBaledBrokeButl);
				barcodeComman.setUnctdflyleafshvgs(UnctdFlyleafShvgs);
				barcodeComman.setLooseest(LooseEST);
				//Set Col For Weight
				
				barcodeComman.setPrtmixw(Prtmixw);
				barcodeComman.setMwlw(MWLw);
				barcodeComman.setMclw(MCLw);
				barcodeComman.setMwlwigsw(MWLWIGSw);
				barcodeComman.setCbsw(CBSw);
				barcodeComman.setCtdGdwdw(CtdGdwdw);
				barcodeComman.setSwlsortedwhitew(SWLSortedWhitew);
				barcodeComman.setOnpolnNewsprintw(ONPOldNewsPrintw);
				barcodeComman.setOinewsw(OINewsw);
				barcodeComman.setLightprtsbsw(LightPrtSBSw);
				barcodeComman.setHww(HWw);
				barcodeComman.setHeavyprtsbsw(HeavyPrtSBSw);
				barcodeComman.setSoww(SOWw);
				barcodeComman.setUnprtsbsw(UnprtSBSw);
				barcodeComman.setNewsblankw(Newsblankw);
				barcodeComman.setWhitegdwdblendw(WhiteGdwdBlendw);
				barcodeComman.setMailundeliverablew(MailUndeliverablew);
				barcodeComman.setHoggedbooksw(HoggedBooksw);
				barcodeComman.setOccw(OCCw);
				barcodeComman.setDlkw(DLKw);
				barcodeComman.setMixedpaperw(MixedPaperw);
				barcodeComman.setSoftwoodchipsw(SoftWoodChipsw);
				barcodeComman.setHardwoodchipsw(HardWoodChipsw);
				barcodeComman.setWhitebrokew(WhiteBrokew);
				barcodeComman.setPwew(PWEw);
				barcodeComman.setBrownnapkinbrokew(BrownNapkinBrokew);
				barcodeComman.setPulpwetlapw(PULPWetLapw);
				barcodeComman.setVirginpulpw(VirginPulpw);
				barcodeComman.setBrownwetLapw(BrownWetLapw);
				barcodeComman.setPulpdryLapw(PulpDryLapw);
				barcodeComman.setOtherrollsw(OtherRollsw);
				barcodeComman.setStbaleswetlapw(STBaleswetlapw);
				barcodeComman.setSttbaledbrokebutlw(STTBaledBrokeButlw);
				barcodeComman.setUnctdflyleafshvgsw(UnctdFlyleafShvgsw);
				barcodeComman.setLooseestW(LooseESTw);
				
				details.add(barcodeComman);
				
			}else{
				
			}
			
			
		
		}
		return details;
	}

	@Override
	public List<BarcodeComman> getOpenMonthAvailable(int month, int year) {
		//public List<BarcodeComman> getOpenMonth(int month, int year) throws ParseException {
		// TODO Auto-generated method stub
	JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
	String sql="Select * from  barcodeOpeningClosing where [closemonth]=? AND [closeyear]=?";
	List<BarcodeComman> availableOrNot=jdbcTemplate.query(sql, new Object[]{
		month,year	
	}, new OpeningClosingMapper());
	
	return availableOrNot;
	
}

	@Override
	public int save(final BarcodeComman barcodeComman) {
		// TODO Auto-generated method stub
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		KeyHolder keyHolder=new GeneratedKeyHolder();
		final String sql="insert into barcodeOpeningClosing"
				+ "([closemonth],"
				+ "[closeyear],"
				+ "[Prtmix],"
				+ "[MWL],"
				+ "[MCL],"
				+ "[MWLWIGS],"
				+ "[CBS],"
				+ "[CtdGdwd],"
				+ "[SWLSortedWhite],"
				+ "[ONPOldNewsPrint],"
				+ "[OINews],"
				+ "[LightPrtSBS],"
				+ "[HW],"
				+ "[HeavyPrtSBS],"
				+ "[SOW],"
				+ "[UnprtSBS],"
				+ "[Newsblank],"
				+ "[WhiteGdwdBlend],"
				+ "[MailUndeliverable],"
				+ "[HoggedBooks],"
				+ "[OCC],"
				+ "[DLK],"
				+ "[MixedPaper],"
				+ "[SoftWoodChips],"
				+ "[HardWoodChips],"
				+ "[WhiteBroke],"
				+ "[PWE],"
				+ "[BrownNapkinBroke],"
				+ "[PULPWetLap],"
				+ "[VirginPulp],"
				+ "[BrownWetLap],"
				+ "[PulpDryLap],"
				+ "[OtherRolls],"
				+ "[STBaleswetlap],"
				+ "[STTBaledBrokeButl],"
				+ "[UnctdFlyleafShvgs],"
				+ "[LooseEST],"
				//For Weight
				+ "[Prtmixw],"
				+ "[MWLw],"
				+ "[MCLw],"
				+ "[MWLWIGSw],"
				+ "[CBSw],"
				+ "[CtdGdwdw],"
				+ "[SWLSortedWhitew],"
				+ "[ONPOldNewsPrintw],"
				+ "[OINewsw],"
				+ "[LightPrtSBSw],"
				+ "[HWw],"
				+ "[HeavyPrtSBSw],"
				+ "[SOWw],"
				+ "[UnprtSBSw],"
				+ "[Newsblankw],"
				+ "[WhiteGdwdBlendw],"
				+ "[MailUndeliverablew],"
				+ "[HoggedBooksw],"
				+ "[OCCw],"
				+ "[DLKw],"
				+ "[MixedPaperw],"
				+ "[SoftWoodChipsw],"
				+ "[HardWoodChipsw],"
				+ "[WhiteBrokew],"
				+ "[PWEw],"
				+ "[BrownNapkinBrokew],"
				+ "[PULPWetLapw],"
				+ "[VirginPulpw],"
				+ "[BrownWetLapw],"
				+ "[PulpDryLapw],"
				+ "[OtherRollsw],"
				+ "[STBaleswetlapw],"
				+ "[STTBaledBrokeButlw],"
				+ "[UnctdFlyleafShvgsw],"
				+ "[LooseESTw])"
				+ " values(?,?,?,?,?,?,?,?,?,?,"
						+ "?,?,?,?,?,?,?,?,?,?,"
						+ "?,?,?,?,?,?,?,?,?,?,"
						+ "?,?,?,?,?,?,?,?,?,?,"
						+ "?,?,?,?,?,?,?,?,?,?,"
						+ "?,?,?,?,?,?,?,?,?,?,"
						+ "?,?,?,?,?,?,?,?,?,?,"
						+ "?,?)";
			jdbcTemplate.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection arg0)
					throws SQLException {
				// TODO Auto-generated method stub
				PreparedStatement statement=arg0.prepareStatement(sql,new String[] {"ID"});
				
			  statement.setInt(1, barcodeComman.getClosemonth());
			  statement.setInt(2, barcodeComman.getCloseyear());
			  statement.setInt(3, barcodeComman.getPrtmix());      
			  statement.setInt(4, barcodeComman.getMwl());      
			  statement.setInt(5, barcodeComman.getMcl() );     
			  statement.setInt(6, barcodeComman.getMwlwigs() );    
			  statement.setInt(7, barcodeComman.getCbs());      
			  statement.setInt(8, barcodeComman.getCtdGdwd() );     
			  statement.setInt(9, barcodeComman.getSwlsortedwhite());
		      statement.setInt(10, barcodeComman.getOnpolnNewsprint());  
			  statement.setInt(11, barcodeComman.getOinews());      
			  statement.setInt(12, barcodeComman.getLightprtsbs());      
			  statement.setInt(13, barcodeComman.getHw() );     
			  statement.setInt(14, barcodeComman.getHeavyprtsbs());      
			  statement.setInt(15, barcodeComman.getSow());      
			  statement.setInt(16, barcodeComman.getUnprtsbs());      
			  statement.setInt(17, barcodeComman.getNewsblank());      
			  statement.setInt(18, barcodeComman.getWhitegdwdblend());      
			  statement.setInt(19, barcodeComman.getMailundeliverable() );     
			  statement.setInt(20, barcodeComman.getHoggedbooks());      
			  statement.setInt(21, barcodeComman.getOcc());      
			  statement.setInt(22, barcodeComman.getDlk());      
			  statement.setInt(23, barcodeComman.getMixedpaper());      
			  statement.setInt(24, barcodeComman.getSoftwoodchips());      
			  statement.setInt(25, barcodeComman.getHardwoodchips());      
			  statement.setInt(26, barcodeComman.getWhitebroke());      
			  statement.setInt(27, barcodeComman.getPwe() );     
			  statement.setInt(28, barcodeComman.getBrownnapkinbroke());      
			  statement.setInt(29, barcodeComman.getPulpwetlap());      
			  statement.setInt(30, barcodeComman.getVirginpulp());      
			  statement.setInt(31, barcodeComman.getBrownwetLap());      
			  statement.setInt(32, barcodeComman.getPulpdryLap());      
			  statement.setInt(33, barcodeComman.getOtherrolls());      
			  statement.setInt(34, barcodeComman.getStbaleswetlap());      
			  statement.setInt(35, barcodeComman.getSttbaledbrokebutl());           
			  statement.setInt(36, barcodeComman.getUnctdflyleafshvgs());
			  statement.setInt(37, barcodeComman.getLooseest());
			  //Now For Weight
			  statement.setDouble(38, barcodeComman.getPrtmixw());      
			  statement.setDouble(39, barcodeComman.getMwlw());      
			  statement.setDouble(40, barcodeComman.getMclw() );     
			  statement.setDouble(41, barcodeComman.getMwlwigsw() );    
			  statement.setDouble(42, barcodeComman.getCbsw());      
			  statement.setDouble(43, barcodeComman.getCtdGdwdw() );     
			  statement.setDouble(44, barcodeComman.getSwlsortedwhitew());
		      statement.setDouble(45, barcodeComman.getOnpolnNewsprintw());  
			  statement.setDouble(46, barcodeComman.getOinewsw());      
			  statement.setDouble(47, barcodeComman.getLightprtsbsw());      
			  statement.setDouble(48, barcodeComman.getHww() );     
			  statement.setDouble(49, barcodeComman.getHeavyprtsbsw());      
			  statement.setDouble(50, barcodeComman.getSoww());      
			  statement.setDouble(51, barcodeComman.getUnprtsbsw());      
			  statement.setDouble(52, barcodeComman.getNewsblankw());      
			  statement.setDouble(53, barcodeComman.getWhitegdwdblendw());      
			  statement.setDouble(54, barcodeComman.getMailundeliverablew() );     
			  statement.setDouble(55, barcodeComman.getHoggedbooksw());      
			  statement.setDouble(56, barcodeComman.getOccw());      
			  statement.setDouble(57, barcodeComman.getDlkw());      
			  statement.setDouble(58, barcodeComman.getMixedpaperw());      
			  statement.setDouble(59, barcodeComman.getSoftwoodchipsw());      
			  statement.setDouble(60, barcodeComman.getHardwoodchipsw());      
			  statement.setDouble(61, barcodeComman.getWhitebrokew());      
			  statement.setDouble(62, barcodeComman.getPwew() );     
			  statement.setDouble(63, barcodeComman.getBrownnapkinbrokew());      
			  statement.setDouble(64, barcodeComman.getPulpwetlapw());      
			  statement.setDouble(65, barcodeComman.getVirginpulpw());      
			  statement.setDouble(66, barcodeComman.getBrownwetLapw());      
			  statement.setDouble(67, barcodeComman.getPulpdryLapw());      
			  statement.setDouble(68, barcodeComman.getOtherrollsw());      
			  statement.setDouble(69, barcodeComman.getStbaleswetlapw());      
			  statement.setDouble(70, barcodeComman.getSttbaledbrokebutlw());    
			  statement.setDouble(71, barcodeComman.getUnctdflyleafshvgsw());
			  statement.setDouble(72, barcodeComman.getLooseestW());
			  
		return statement;
			}
			
			},keyHolder);
			return keyHolder.getKey().intValue();
		}

	@Override
	public void update(final BarcodeComman barcodeComman) {
		// TODO Auto-generated method stub
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		final String sql="update [barcodeOpeningClosing] set "
				+ "[closemonth]=?,"
				+ "[closeyear]=?,"				
				+ "[Prtmix]=?,"
				+ "[MWL]=?,"
				+ "[MCL]=?,"
				+ "[MWLWIGS]=?,"
				+ "[CBS]=?,"
				+ "[CtdGdwd]=?,"
				+ "[SWLSortedWhite]=?,"
				+ "[ONPOldNewsPrint]=?,"
				+ "[OINews]=?,"
				+ "[LightPrtSBS]=?,"
				+ "[HW]=?,"
				+ "[HeavyPrtSBS]=?,"
				+ "[SOW]=?,"
				+ "[UnprtSBS]=?,"
				+ "[Newsblank]=?,"
				+ "[WhiteGdwdBlend]=?,"
				+ "[MailUndeliverable]=?,"
				+ "[HoggedBooks]=?,"
				+ "[OCC]=?,"
				+ "[DLK]=?,"
				+ "[MixedPaper]=?,"
				+ "[SoftWoodChips]=?,"
				+ "[HardWoodChips]=?,"
				+ "[WhiteBroke]=?,"
				+ "[PWE]=?,"
				+ "[BrownNapkinBroke]=?,"
				+ "[PULPWetLap]=?,"
				+ "[VirginPulp]=?,"
				+ "[BrownWetLap]=?,"
				+ "[PulpDryLap]=?,"
				+ "[OtherRolls]=?,"
				+ "[STBaleswetlap]=?,"
				+ "[STTBaledBrokeButl]=?,"
				+ "[UnctdFlyleafShvgs]=?,"
				+ "[LooseEST]=?,"
				//For Weight
				+ "[Prtmixw]=?,"
				+ "[MWLw]=?,"
				+ "[MCLw]=?,"
				+ "[MWLWIGSw]=?,"
				+ "[CBSw]=?,"
				+ "[CtdGdwdw]=?,"
				+ "[SWLSortedWhitew]=?,"
				+ "[ONPOldNewsPrintw]=?,"
				+ "[OINewsw]=?,"
				+ "[LightPrtSBSw]=?,"
				+ "[HWw]=?,"
				+ "[HeavyPrtSBSw]=?,"
				+ "[SOWw]=?,"
				+ "[UnprtSBSw]=?,"
				+ "[Newsblankw]=?,"
				+ "[WhiteGdwdBlendw]=?,"
				+ "[MailUndeliverablew]=?,"
				+ "[HoggedBooksw]=?,"
				+ "[OCCw]=?,"
				+ "[DLKw]=?,"
				+ "[MixedPaperw]=?,"
				+ "[SoftWoodChipsw]=?,"
				+ "[HardWoodChipsw]=?,"
				+ "[WhiteBrokew]=?,"
				+ "[PWEw]=?,"
				+ "[BrownNapkinBrokew]=?,"
				+ "[PULPWetLapw]=?,"
				+ "[VirginPulpw]=?,"
				+ "[BrownWetLapw]=?,"
				+ "[PulpDryLapw]=?,"
				+ "[OtherRollsw]=?,"
				+ "[STBaleswetlapw]=?,"
				+ "[STTBaledBrokeButlw]=?,"
				+ "[UnctdFlyleafShvgsw]=?,"
				+ "[LooseESTw]=?"
				+ " where [closemonth]=? AND [closeyear]=?";
jdbcTemplate.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection arg0)
					throws SQLException {
				PreparedStatement statement=arg0.prepareStatement(sql);
				
				  statement.setInt(1, barcodeComman.getClosemonth());
				  statement.setInt(2, barcodeComman.getCloseyear());
				  statement.setInt(3, barcodeComman.getPrtmix());      
				  statement.setInt(4, barcodeComman.getMwl());      
				  statement.setInt(5, barcodeComman.getMcl() );     
				  statement.setInt(6, barcodeComman.getMwlwigs() );    
				  statement.setInt(7, barcodeComman.getCbs());      
				  statement.setInt(8, barcodeComman.getCtdGdwd() );     
				  statement.setInt(9, barcodeComman.getSwlsortedwhite());
			      statement.setInt(10, barcodeComman.getOnpolnNewsprint());  
				  statement.setInt(11, barcodeComman.getOinews());      
				  statement.setInt(12, barcodeComman.getLightprtsbs());      
				  statement.setInt(13, barcodeComman.getHw() );     
				  statement.setInt(14, barcodeComman.getHeavyprtsbs());      
				  statement.setInt(15, barcodeComman.getSow());      
				  statement.setInt(16, barcodeComman.getUnprtsbs());      
				  statement.setInt(17, barcodeComman.getNewsblank());      
				  statement.setInt(18, barcodeComman.getWhitegdwdblend());      
				  statement.setInt(19, barcodeComman.getMailundeliverable() );     
				  statement.setInt(20, barcodeComman.getHoggedbooks());      
				  statement.setInt(21, barcodeComman.getOcc());      
				  statement.setInt(22, barcodeComman.getDlk());      
				  statement.setInt(23, barcodeComman.getMixedpaper());      
				  statement.setInt(24, barcodeComman.getSoftwoodchips());      
				  statement.setInt(25, barcodeComman.getHardwoodchips());      
				  statement.setInt(26, barcodeComman.getWhitebroke());      
				  statement.setInt(27, barcodeComman.getPwe() );     
				  statement.setInt(28, barcodeComman.getBrownnapkinbroke());      
				  statement.setInt(29, barcodeComman.getPulpwetlap());      
				  statement.setInt(30, barcodeComman.getVirginpulp());      
				  statement.setInt(31, barcodeComman.getBrownwetLap());      
				  statement.setInt(32, barcodeComman.getPulpdryLap());      
				  statement.setInt(33, barcodeComman.getOtherrolls());      
				  statement.setInt(34, barcodeComman.getStbaleswetlap());      
				  statement.setInt(35, barcodeComman.getSttbaledbrokebutl());           
				  statement.setInt(36, barcodeComman.getUnctdflyleafshvgs());
				  statement.setInt(37, barcodeComman.getLooseest());
				  //Now For Weight
				  statement.setDouble(38, barcodeComman.getPrtmixw());      
				  statement.setDouble(39, barcodeComman.getMwlw());      
				  statement.setDouble(40, barcodeComman.getMclw() );     
				  statement.setDouble(41, barcodeComman.getMwlwigsw() );    
				  statement.setDouble(42, barcodeComman.getCbsw());      
				  statement.setDouble(43, barcodeComman.getCtdGdwdw() );     
				  statement.setDouble(44, barcodeComman.getSwlsortedwhitew());
			      statement.setDouble(45, barcodeComman.getOnpolnNewsprintw());  
				  statement.setDouble(46, barcodeComman.getOinewsw());      
				  statement.setDouble(47, barcodeComman.getLightprtsbsw());      
				  statement.setDouble(48, barcodeComman.getHww() );     
				  statement.setDouble(49, barcodeComman.getHeavyprtsbsw());      
				  statement.setDouble(50, barcodeComman.getSoww());      
				  statement.setDouble(51, barcodeComman.getUnprtsbsw());      
				  statement.setDouble(52, barcodeComman.getNewsblankw());      
				  statement.setDouble(53, barcodeComman.getWhitegdwdblendw());      
				  statement.setDouble(54, barcodeComman.getMailundeliverablew() );     
				  statement.setDouble(55, barcodeComman.getHoggedbooksw());      
				  statement.setDouble(56, barcodeComman.getOccw());      
				  statement.setDouble(57, barcodeComman.getDlkw());      
				  statement.setDouble(58, barcodeComman.getMixedpaperw());      
				  statement.setDouble(59, barcodeComman.getSoftwoodchipsw());      
				  statement.setDouble(60, barcodeComman.getHardwoodchipsw());      
				  statement.setDouble(61, barcodeComman.getWhitebrokew());      
				  statement.setDouble(62, barcodeComman.getPwew() );     
				  statement.setDouble(63, barcodeComman.getBrownnapkinbrokew());      
				  statement.setDouble(64, barcodeComman.getPulpwetlapw());      
				  statement.setDouble(65, barcodeComman.getVirginpulpw());      
				  statement.setDouble(66, barcodeComman.getBrownwetLapw());      
				  statement.setDouble(67, barcodeComman.getPulpdryLapw());      
				  statement.setDouble(68, barcodeComman.getOtherrollsw());      
				  statement.setDouble(69, barcodeComman.getStbaleswetlapw());      
				  statement.setDouble(70, barcodeComman.getSttbaledbrokebutlw());  
				  statement.setDouble(71, barcodeComman.getUnctdflyleafshvgsw());
				  statement.setDouble(72, barcodeComman.getLooseestW());
				  
				  statement.setInt(73, barcodeComman.getClosemonth());
				  statement.setInt(74, barcodeComman.getCloseyear());

				return statement;
			}
		});
		
}

	@Override
	public List<WastePaperBaleInventory> getFRPLocationData() {
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSourceP);
		JdbcTemplate jdbcTemplate1=new JdbcTemplate(dataSource);
		List<WastePaperBaleInventory> details= new ArrayList<WastePaperBaleInventory>();
		//List<WastepaperDetail> details=new ArrayList<WastepaperDetail>();
		/*String sql="SELECT sum(WLBaleWeightLBSGross)/2000 as BALEWT, tblWetLapLotHeader.LotColor,count(*) as COUNTBALE FROM tblWetLapLotDetail"
				+ "  Inner Join tblWetLapLotHeader on tblWetLapLotHeader.LotHeaderID =tblWetLapLotDetail.LotHeaderID"
				+ " where  tblWetLapLotHeader.LotColor=@Color and (BaleStatus <> 'Shipped' Or BaleStatus Is Null) Group by [LotColor]";*/
		String sql="SELECT  [LotColor] From [tblWetLapLotHeader]  Group BY [LotColor]";
	
		List<Map<String, Object>> mapv=jdbcTemplate.queryForList(sql);
		if(mapv.size()>0){
			for(Map<String, Object> mapv1:mapv){
				
				String lotColor=(String)mapv1.get("LotColor");
				if(lotColor==null){
					
				}else{
					try{
						
						String frpsql="SELECT sum(WLBaleWeightLBSGross)/2000 as BALEWT, tblWetLapLotHeader.LotColor,count(*) as COUNTBALE FROM tblWetLapLotDetail"
								+ "  Inner Join tblWetLapLotHeader on tblWetLapLotHeader.LotHeaderID =tblWetLapLotDetail.LotHeaderID"
								+ " where  tblWetLapLotHeader.LotColor=? and (BaleStatus <> 'Shipped' Or BaleStatus Is Null) Group by [LotColor]";
						List<Map<String, Object>> mapBale=jdbcTemplate.queryForList(frpsql, new Object[]{lotColor});
						for (Map<String, Object> mapBales : mapBale) {
							final WastePaperBaleInventory wd=new WastePaperBaleInventory();
							double baleWeight=(Double)mapBales.get("BALEWT");
							int bale=(Integer)mapBales.get("COUNTBALE");
							String color=(String)mapBales.get("LotColor");
							
							if(color.equalsIgnoreCase("White")){
								wd.setStt_wetlapbales_pm6_white(bale);
								wd.setStt_wetlapbales_pm6_white_weight(baleWeight);
								wd.setLotcolor(color);
							}
								wd.setStt_wetlapbales_pm6_brown(bale);
								wd.setStt_wetlapbales_pm6_brown_weight(baleWeight);
								wd.setLotcolor(color);
							
							details.add(wd);
						}
					}catch(Exception rlt){
						System.out.println("Problem In Fetching The FRP Location Data");
						rlt.printStackTrace();
					}
				}
				
			}
		}
		return details;
	}

	@Override
	public List<WastePaperBaleInventory> getYardData() {
		
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSourceP);
		List<WastePaperBaleInventory> yardDataDetails= new ArrayList<WastePaperBaleInventory>();
		
		
		System.out.println("Fetching Yard Data - ST PAPER- GRADEWISE <START> - ST Paper");
			
		MapSqlParameterSource source=new MapSqlParameterSource();
		String loadstatus="Yard";
		source.addValue("loadstatus", loadstatus);
			final WastePaperBaleInventory wastePaperBaleInventory=new WastePaperBaleInventory();

			int _totalBalesCount=0;
			int totalbalesofmwl=0;
			int totalbalesofpmix=0;
			int totalbalesofmcl=0;
			int totalbalesofmwlwigs=0;
			int totalbalesofcbs=0;
			int totalbalesofctdgdwd=0;
			int totalbalesofswl=0;
			int totalbalesofunctdflyleafshvgs=0;
			int totalbalesoflightprtsbs=0;
			int totalbalesofhw=0;
			int totalbalesofheavyprtsbs=0;
			int totalbalesofsow=0;
			int totalbalesofnewsblank=0;
			int totalbalesofocccorrugated=0;
			int totalbalesofdlk=0;
			int totalbalesofmixedpaper=0;
			int totalbalesofsoftwoodchips=0;
			int totalbalesofhardwoodchips=0;
			int totalbalesofpwe=0;
			int totalbalesofpulpwetlap=0;
			int totalbalesofvirginpulp=0;
			int totalbalesofpulpdrylap=0;
			int totalbalesofother=0;
			int totalbalesofotherrolls=0;
			int totalbalesofstbaleswetlap=0;
			
			
			try{
				String sqlForYardData="SELECT tblPurchaseHeader.ReleaseNumber, tblPurchaseHeader.PickUpPoint, tblPurchaseHeader.PickUpCity, tlkpPickUpPoint.PickUpState, tlkpPickUpPoint.PickUpPhone, tlkpPickUpPoint.PickUpPhoneExt, tblPurchaseDetail.Grade, [GradeCode]*1 AS GradeSort,"
						+ " tblPurchaseDetail.GradeCode, tblPurchaseHeader.AcceptDate, tblPurchaseHeader.UnloaderID, tblPurchaseHeader.UnloadDate, tblPurchaseHeader.GrossWeight, tblPurchaseHeader.TareWeight, tblPurchaseHeader.NetWeight, tblPurchaseHeader.UnloadComment, tblPurchaseHeader.LoadStatus, "
						+ "tblPurchaseHeader.Trailer, IsNull([Trailer],'a') AS TrailerVar, tlkpCarrierProd.CarrierName, IsNull([CarrierID],'A') AS Expr1, tblPurchaseHeader.UnloadComment, qryGradeCount.GradeCount "
						+ "FROM ((tlkpCarrierProd RIGHT JOIN (tblPurchaseHeader LEFT JOIN tlkpPickUpPoint ON (tblPurchaseHeader.PickUpCity = tlkpPickUpPoint.PickUpCity) AND (tblPurchaseHeader.PickUpPoint = tlkpPickUpPoint.PickUpPoint)) ON tlkpCarrierProd.CarrierCode = tblPurchaseHeader.CarrierID) INNER JOIN  ( "
						+ "SELECT tblPurchaseDetail.ReleaseNumber, Count(tblPurchaseDetail.GradeCode) AS GradeCount FROM tblPurchaseDetail GROUP BY tblPurchaseDetail.ReleaseNumber "
						+ "HAVING (((tblPurchaseDetail.ReleaseNumber)>0)) "
						+ ") As qryGradeCount ON tblPurchaseHeader.ReleaseNumber = qryGradeCount.ReleaseNumber) LEFT JOIN tblPurchaseDetail ON tblPurchaseHeader.ReleaseNumber = tblPurchaseDetail.ReleaseNumber "
						+ "WHERE (tblPurchaseHeader.LoadStatus)='Yard'";
				
				List<Map<String, Object>> mapList=jdbcTemplate.queryForList(sqlForYardData);
				/*try {
					mapList=jdbcTemplate.queryForList(sqlForYardData,new Object[]{source});
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}*/
				if(mapList.size()>0){
					
					for (final Map<String, Object> map1 : mapList) {
						
						
							int _totalBales=map1.get("GradeCount")==null?0:(Integer)map1.get("GradeCount");
							String _gradeCode=(String)map1.get("GradeCode");
							_totalBalesCount = _totalBalesCount + _totalBales;
							wastePaperBaleInventory.setTotalbales(_totalBalesCount);
							
							if(_gradeCode.equalsIgnoreCase("1")){
								totalbalesofmwl = totalbalesofmwl + _totalBales;
								wastePaperBaleInventory.setTotalbalesOfmwl(totalbalesofmwl);
							}
							if(_gradeCode.equalsIgnoreCase("2")){
								totalbalesofpmix = totalbalesofpmix + _totalBales;
								wastePaperBaleInventory.setTotalbalesOfpmix(totalbalesofpmix);
							}
							if(_gradeCode.equalsIgnoreCase("3")){
								totalbalesofmcl = totalbalesofmcl+ _totalBales;
								wastePaperBaleInventory.setTotalbalesOfmcl(totalbalesofmcl);
							}
							if(_gradeCode.equalsIgnoreCase("4")){
								totalbalesofmwlwigs = totalbalesofmwlwigs + _totalBales;
								wastePaperBaleInventory.setTotalbalesOfmwlwigs(totalbalesofmwlwigs);
							}
							if(_gradeCode.equalsIgnoreCase("5")){
								totalbalesofcbs = totalbalesofcbs + _totalBales;
								wastePaperBaleInventory.setTotalbalesOfcbs(totalbalesofcbs);
							}
							if(_gradeCode.equalsIgnoreCase("6")){
								totalbalesofctdgdwd = totalbalesofctdgdwd + _totalBales;
								wastePaperBaleInventory.setTotalbalesOfctdgdwd(totalbalesofctdgdwd);
							}
							if(_gradeCode.equalsIgnoreCase("7")){
								totalbalesofswl = totalbalesofswl + _totalBales;
								wastePaperBaleInventory.setTotalbalesOfswl(totalbalesofswl);
							}
							if(_gradeCode.equalsIgnoreCase("8")){
								totalbalesofunctdflyleafshvgs = totalbalesofunctdflyleafshvgs + _totalBales;
								wastePaperBaleInventory.setTotalbalesOfunctdflyleafshvgs(totalbalesofunctdflyleafshvgs);
							}
							if(_gradeCode.equalsIgnoreCase("10")){
								totalbalesoflightprtsbs = totalbalesoflightprtsbs + _totalBales;
								wastePaperBaleInventory.setTotalbalesOflightprtsbs(totalbalesoflightprtsbs);
							}
							if(_gradeCode.equalsIgnoreCase("11")){
								totalbalesofhw = totalbalesofhw + _totalBales;
								wastePaperBaleInventory.setTotalbalesOfhw(totalbalesofhw);
							}
							if(_gradeCode.equalsIgnoreCase("12")){
								totalbalesofheavyprtsbs = totalbalesofheavyprtsbs + _totalBales;
								wastePaperBaleInventory.setTotalbalesOfheavyprtsbs(totalbalesofheavyprtsbs);
							}
							if(_gradeCode.equalsIgnoreCase("13")){
								totalbalesofsow = totalbalesofsow + _totalBales;
								wastePaperBaleInventory.setTotalbalesOfsow(totalbalesofsow);
							}
							if(_gradeCode.equalsIgnoreCase("16")){
								totalbalesofnewsblank = totalbalesofnewsblank + _totalBales;
								wastePaperBaleInventory.setTotalbalesOfnewsblank(totalbalesofnewsblank);
							}
							if(_gradeCode.equalsIgnoreCase("23")){
								totalbalesofocccorrugated = totalbalesofocccorrugated + _totalBales;
								wastePaperBaleInventory.setTotalbalesOfocccorrugated(totalbalesofocccorrugated);
							}
							if(_gradeCode.equalsIgnoreCase("24")){
								totalbalesofdlk = totalbalesofdlk + _totalBales;
								wastePaperBaleInventory.setTotalbalesOfdlk(totalbalesofdlk);
							}
							if(_gradeCode.equalsIgnoreCase("30")){
								totalbalesofmixedpaper = totalbalesofmixedpaper + _totalBales;
								wastePaperBaleInventory.setTotalbalesOfmixedpaper(totalbalesofmixedpaper);
							}
							/*if(_gradeCode==40){
								totalbalesofsoftwoodchips = totalbalesofsoftwoodchips + _totalBales;
								totalbalesweightofsoftwoodchips=totalbalesweightofsoftwoodchips+_totalBaleWeight;
								
								wastePaperBaleInventory.setTotalbalesweightOfsoftwoodchips(totalbalesweightofsoftwoodchips);
								wastePaperBaleInventory.setTotalbalesOfsoftwoodchips(totalbalesofsoftwoodchips);
							}
							if(_gradeCode==50){
								totalbalesofhardwoodchips = totalbalesofhardwoodchips + _totalBales;
								totalbalesweightofhardwoodchips=totalbalesweightofhardwoodchips+_totalBaleWeight;
								
								wastePaperBaleInventory.setTotalbalesweightOfhardwoodchips(totalbalesweightofhardwoodchips);
								wastePaperBaleInventory.setTotalbalesOfhardwoodchips(totalbalesofhardwoodchips);
							}*/
							if(_gradeCode.equalsIgnoreCase("56")){
								totalbalesofpwe = totalbalesofpwe + _totalBales;
								wastePaperBaleInventory.setTotalbalesOfpwe(totalbalesofpwe);
							}
							if(_gradeCode.equalsIgnoreCase("70")){
								totalbalesofpulpwetlap = totalbalesofpulpwetlap + _totalBales;
								wastePaperBaleInventory.setTotalbalesOfpulpwetlap(totalbalesofpulpwetlap);
							}
							if(_gradeCode.equalsIgnoreCase("75")){
								totalbalesofvirginpulp = totalbalesofvirginpulp + _totalBales;
								wastePaperBaleInventory.setTotalbalesOfvirginpulp(totalbalesofvirginpulp);
							}
							if(_gradeCode.equalsIgnoreCase("87")){
								totalbalesofpulpdrylap = totalbalesofpulpdrylap + _totalBales;
								wastePaperBaleInventory.setTotalbalesOfpulpdrylap(totalbalesofpulpdrylap);
							}
							if(_gradeCode.equalsIgnoreCase("90")){
								totalbalesofother = totalbalesofother + _totalBales;
								wastePaperBaleInventory.setTotalbalesOfother(totalbalesofother);
							}
							if(_gradeCode.equalsIgnoreCase("91")){
								totalbalesofotherrolls = totalbalesofotherrolls + _totalBales;
								wastePaperBaleInventory.setTotalbalesOfotherrolls(totalbalesofotherrolls);
							}
							if(_gradeCode.equalsIgnoreCase("95")){
								totalbalesofstbaleswetlap = totalbalesofstbaleswetlap + _totalBales;
								wastePaperBaleInventory.setTotalbalesOfstbaleswetlap(totalbalesofstbaleswetlap);
							}
							
						}
					wastePaperBaleInventory.setTotalbales(_totalBalesCount);
					
					}
				}
				
				
			catch(Exception rlt){
				System.out.println("You Have A Problem In WastePaperUnloadBaleController.java at first section.");
				rlt.printStackTrace();
			}
			yardDataDetails.add(wastePaperBaleInventory);	
			
		System.out.println("Fetching  Yard Data  - GRADEWISE <END> - ST Paper");
		return yardDataDetails;
	}

}

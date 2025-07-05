package com.st.wastepaper.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.st.common.CommonUtil;
import com.st.wastepaper.model.WastePaperBaleInventory;

@Repository
public class BarcodeConsumedBalesReportDaoImp implements BarcodeConsumedBalesReportDao {

	
	@Autowired
	@Qualifier("dataSourceProduction")
	private DataSource dataSourceP;
	
	@Autowired
	private DataSource dataSource;
	
	@Override
	public List<WastePaperBaleInventory> getCounsumedBales(Date startdate,Date enddate) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSourceP);
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		SimpleDateFormat dateFormatTesting = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss");
		
		//NamedParameterJdbcTemplate  jdbcTemplate=new NamedParameterJdbcTemplate(dataSourceP);
		List<WastePaperBaleInventory> unloadDetails= new ArrayList<WastePaperBaleInventory>();
		
		
		System.out.println(dateFormat.format(startdate));
		System.out.println(dateFormat.format(enddate));
		Calendar calendar=Calendar.getInstance();
		calendar.setTime(startdate);
		System.out.println("Fetching BARCODE CONSUMED BALES - GRADEWISE <START> In ST Paper ");
		
		int days=Days.daysBetween(new DateTime(startdate.getTime()), new DateTime(enddate.getTime())).getDays();
		
		Calendar date=Calendar.getInstance();
		date.setTime(startdate);
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
			toCal.setTime(ecal.getTime());
			toCal.add(Calendar.DATE, 1);
			
			MapSqlParameterSource source=new MapSqlParameterSource();
			
			/*System.out.println("Sdate"+dateFormat.format(scal.getTime()));
			System.out.println("Edate"+dateFormat.format(ecal.getTime()));
			
			System.out.println("frmDate"+dateFormat.format(frmCal.getTime().getTime()));
			System.out.println("toDate"+dateFormat.format(toCal.getTime().getTime()));*/
			
			
			//source.addValue("sdate", dateFormat.format(scal.getTime()));
			//source.addValue("edate", dateFormat.format(scal.getTime()));
			source.addValue("sdate", new Timestamp(scal.getTime().getTime()));
			source.addValue("edate", new Timestamp(ecal.getTime().getTime()));
			
			System.out.println(dateFormat.format(scal.getTime().getTime()));
			System.out.println(dateFormat.format(ecal.getTime().getTime()));
			
			//source.addValue("frmDate", new Timestamp(frmCal.getTime().getTime()));
			//source.addValue("toDate", new Timestamp(toCal.getTime().getTime()));
			
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
			
			try{
				/*String sqlForUnloadDetails="SELECT [ConsumedDate], sum(BaleWeight)/2000 as BALEWT,[GradeCode],count(*) as COUNTBALE FROM [tblBaleInventory]  "
						+ "where [ConsumedDate] between :sdate and :edate AND [GradeCode] in (select GradeCode from tlkpGrade ) "
						+ "group by [ConsumedDate],[GradeCode] ";
				String sqlForUnloadDetails="SELECT [ConsumedDate], sum(BaleWeight)/2000 AS BALEWT, [GradeCode], count(*) AS COUNTBALE FROM "
						+ "(SELECT [ConsumedDate], [ConsumedTime], [BaleWeight], [GradeCode] FROM tblBaleInventory WHERE [ConsumedDate] "
						+ "Between :frmDate and :toDate ORDER BY [ConsumedDate]) WHERE  ConsumedDate & ' ' & ConsumedTime "
						+ "between :sdate and :edate AND [GradeCode] in (select GradeCode from tlkpGrade )GROUP BY [ConsumedDate], [GradeCode]";
				String sqlForUnloadDetails="SELECT DateAdd('n',0,Format([ConsumedDate] & ' ' & [ConsumedTime],'General Date')) AS ConsumedDateTime,[ConsumedDate],"
						+ " Round(sum(BaleWeight)/2000,2) as [BALEWT] ,[GradeCode],count(*) as COUNTBALE  FROM tblBaleInventory WHERE"
						+ "  [ConsumedDate] Between :sdate and :edate Group By [ConsumedDate], "
						+ "DateAdd('n',0,Format([ConsumedDate] & ' ' & [ConsumedTime],'General Date')),[GradeCode]";*/
				//String sqlForUnloadDetails=DatabaseUtil.getSQL("sql/BarcodeConsumedBalesReport.sql");
				String sqlForUnloadDetails="SELECT [ConsumedDate], sum(BaleWeight)/2000 as BALEWT,[GradeCode],count(*) as COUNTBALE FROM [tblBaleInventory] "
						+ "where ([ActualConsumedDateTime] between ? and ? ) AND [GradeCode] in (select GradeCode from tlkpGrade)group by [ConsumedDate],[GradeCode]";
			
				
				/*
				 * String
				 * sqlForUnloadDetails="SELECT  tblBaleInventory.ConsumedDate,sum(tblBaleInventory.BaleWeight)/2000 as BALEWT,"
				 * +
				 * "tblBaleInventory.GradeCode,count(*) as COUNTBALE, tblBaleInventory.ConsumedTime, "
				 * +
				 * "DateAdd('n',0,Format([ConsumedDate] & ' ' & [ConsumedTime],'General Date')) AS ConsumedDateTime, "
				 * +
				 * "tlkpGrade.Grade FROM (tblBaleInventory INNER JOIN tlkpGrade ON tblBaleInventory.GradeCode = tlkpGrade.GradeCode)  "
				 * +
				 * "WHERE ((tblBaleInventory.GradeCode)<>40 And (tblBaleInventory.GradeCode)<>50) AND ((DateAdd('n',0,Format([ConsumedDate] & ' ' & [ConsumedTime],'General Date'))) "
				 * + "Between ? and ?) AND ((IIf(IsNull([ConsumedDate]),'a','b'))='b') " +
				 * "group by [tblBaleInventory.ConsumedDate],[tblBaleInventory.GradeCode],[tblBaleInventory.ConsumedTime],[tlkpGrade.Grade]"
				 * ;
				 */
				
				List<Map<String, Object>> mapList=new ArrayList<Map<String,Object>>();
				System.out.println(""+mapList);
				try {
					/* mapList=jdbcTemplate.queryForList(sqlForUnloadDetails,source); */
					
					mapList=jdbcTemplate.queryForList(sqlForUnloadDetails,new Object[]{
							new Timestamp(scal.getTime().getTime()),
							new Timestamp(ecal.getTime().getTime())
							});
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				
				System.out.println("List Size::"+mapList.size());
				if(mapList.size()>0){
					
					for (final Map<String, Object> map1 : mapList) {
						
						
							double _totalBaleWeight=map1.get("BALEWT")==null?0:(Double)map1.get("BALEWT");
							int _totalBales=map1.get("COUNTBALE")==null?0:(Integer)map1.get("COUNTBALE");
							int _gradeCode=(Integer)map1.get("GradeCode");
							
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
							if(_gradeCode==72){
								totalbalesofVirginSoftWood = totalbalesofVirginSoftWood + _totalBales;
								totalbalesweightofVirginSoftWood=totalbalesweightofVirginSoftWood+_totalBaleWeight;
								
								wastePaperBaleInventory.setTotalbalesweightofVirginSoftWood(totalbalesweightofVirginSoftWood);
								wastePaperBaleInventory.setTotalbalesofVirginSoftWood(totalbalesofVirginSoftWood);
							}
							if(_gradeCode==71){
								totalbalesofVirginHardWood = totalbalesofVirginHardWood + _totalBales;
								totalbalesweightofVirginHardWood=totalbalesweightofVirginHardWood+_totalBaleWeight;
								
								wastePaperBaleInventory.setTotalbalesweightofVirginHardWood(totalbalesweightofVirginHardWood);
								wastePaperBaleInventory.setTotalbalesofVirginHardWood(totalbalesofVirginHardWood);
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
							if(_gradeCode==95){
								totalbalesofstbaleswetlap = totalbalesofstbaleswetlap + _totalBales;
								totalbalesweightofstbaleswetlap=totalbalesweightofstbaleswetlap+_totalBaleWeight;
								
								wastePaperBaleInventory.setTotalbalesweightOfstbaleswetlap(totalbalesweightofstbaleswetlap);
								wastePaperBaleInventory.setTotalbalesOfstbaleswetlap(totalbalesofstbaleswetlap);
							}
							
						}
					wastePaperBaleInventory.setTotalbales(_totalBalesCount);
					wastePaperBaleInventory.setTotalbalesweight(_totalBaleWeightCount);
					}
				}
				
				
			catch(Exception rlt){
				System.out.println("You Have A Problem In BarcodeConsumedBalesReportDaoImp.java at first section.");
				rlt.printStackTrace();
			}
			unloadDetails.add(wastePaperBaleInventory);	
			 date.add(Calendar.DATE, 1);
			}
		System.out.println("Fetching BARCODE CONSUMED BALES - GRADEWISE <END> In ST Paper ");
		return unloadDetails;
	}

	

	@Override
	public List<WastePaperBaleInventory> getselectconsumedbalesdataforTransfer(
			Date startdate, Date enddate) {
		// TODO Auto-generated method stub
		
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		Calendar c = Calendar.getInstance();
		c.setTime(startdate); // Now use today date.
		c.add(Calendar.DATE, -2);
		String FirstDate = sdf.format(c.getTime());
		System.out.println("First Date:"+FirstDate);
		
		SimpleDateFormat sdf1 = new SimpleDateFormat("MM/dd/yyyy");
		Calendar c1 = Calendar.getInstance();
		
		c1.add(Calendar.DATE, 2); // Adding 2 days
		String LastDate = sdf1.format(c1.getTime());
		System.out.println("Last Date:"+LastDate);
		
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSourceP);
		String sql="SELECT [ConsumedDate], [ConsumedTime], [BaleWeight], [GradeCode] FROM [tblBaleInventory] WHERE "
				+ "[ConsumedDate] Between ? and ? ORDER BY [ConsumedDate]";
		List<WastePaperBaleInventory> tempData=jdbcTemplate.query(sql,new Object[]{
				FirstDate,
				LastDate
		},new RowMapper<WastePaperBaleInventory>(){

			@Override
			public WastePaperBaleInventory mapRow(ResultSet rs, int arg1)
					throws SQLException {
				WastePaperBaleInventory wp=new WastePaperBaleInventory();
				//projectionData.setWeight(rs.getDouble("Weight"));
				wp.setConsumeddate(rs.getTimestamp("ConsumedDate"));
				wp.setConsumedtime(rs.getTimestamp("ConsumedTime"));
				wp.setBaleweight(rs.getDouble("BaleWeight"));
				wp.setGradecode(rs.getInt("GradeCode"));
				return wp;
			}
			
		});
		return tempData;
	}
	
	@Override
	public List<WastePaperBaleInventory> getCounsumedBalesFromTempData(
			Date startdate, Date enddate) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public int saveDataInTempTable(final WastePaperBaleInventory wpcd1) {
		// TODO Auto-generated method stub
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSourceP);
		KeyHolder keyHolder=new GeneratedKeyHolder();
		final String sql="insert into tblBaleInventoryConsumedBalesTemp"
				+ "([ConsumedDateTime],"
				+ "[BaleWeight],"
				+ "[GradeCode])"
				+ " values(?,?,?)";
			jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection arg0)
					throws SQLException {
				// TODO Auto-generated method stub
				PreparedStatement statement=arg0.prepareStatement(sql,new String[] {"ID"});
				
			  statement.setTimestamp(1, new Timestamp(wpcd1.getConsumeddatetime().getTime()));
			  statement.setDouble(2, wpcd1.getBaleweight());
			  statement.setInt(3, wpcd1.getGradecode());
			  return statement;
			}
			
			},keyHolder);
			return keyHolder.getKey().intValue();
	}



	@Override
	public List<WastePaperBaleInventory> getCounsumedBalesForMillYieldReort(
			Date startdate, Date enddate) {
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		SimpleDateFormat dateFormatTesting = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss");
		
		JdbcTemplate   jdbcTemplate=new JdbcTemplate(dataSourceP);
		List<WastePaperBaleInventory> unloadDetails= new ArrayList<WastePaperBaleInventory>();
		
		Calendar calendar=Calendar.getInstance();
		calendar.setTime(startdate);
		System.out.println("Fetching BARCODE CONSUMED BALES - For Mill Yield Report <START>");
		
		int days=Days.daysBetween(new DateTime(startdate.getTime()), new DateTime(enddate.getTime())).getDays();
		
		Calendar date=Calendar.getInstance();
		date.setTime(startdate);
		for (int i = 0; i <=days; i++) {
			Date dateS1=calendar.getTime();
			//First
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
			toCal.setTime(ecal.getTime());
			toCal.add(Calendar.DATE, 1);
			//First Ends
			
			//Second
			Calendar scal1=Calendar.getInstance();
			scal1.setTime(date.getTime());
			
			Calendar ecal1=Calendar.getInstance();
			ecal1.setTime(date.getTime());
			ecal1.add(Calendar.DATE, 1);
			
			
			//Second Ends
			/*
			 * MapSqlParameterSource source=new MapSqlParameterSource();
			 * 
			 * source.addValue("sdate", new Timestamp(scal.getTime().getTime()));
			 * source.addValue("edate", new Timestamp(ecal.getTime().getTime()));
			 */
			/*
			 * source.addValue("sdate1",dateFormat.format(scal1.getTime()));
			 * source.addValue("edate1",dateFormat.format(scal1.getTime()));
			 */

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
			
			double totalbalesweightofvirginSW_Fluff=0;
			int totalbalesofvirginSW_Fluff=0;
			
			double totalofpulper3=0;
			double totalofpulper4=0;
			
			try{
				String sqlForUnloadDetails="SELECT [ConsumedDate], sum(BaleWeight)/2000 as BALEWT,[GradeCode],count(*) as COUNTBALE FROM [tblBaleInventory] "
						+ "where ([ActualConsumedDateTime] between ? and ? ) AND [GradeCode] in (select GradeCode from tlkpGrade)group by [ConsumedDate],[GradeCode]";
				
				
				/*
				 * String
				 * sqlForUnloadDetails="SELECT  tblBaleInventory.ConsumedDate,sum(tblBaleInventory.BaleWeight)/2000 as BALEWT,"
				 * +
				 * "tblBaleInventory.GradeCode,count(*) as COUNTBALE, tblBaleInventory.ConsumedTime, "
				 * +
				 * "DateAdd('n',0,Format([ConsumedDate] & ' ' & [ConsumedTime],'General Date')) AS ConsumedDateTime, "
				 * +
				 * "tlkpGrade.Grade FROM (tblBaleInventory INNER JOIN tlkpGrade ON tblBaleInventory.GradeCode = tlkpGrade.GradeCode)  "
				 * +
				 * "WHERE ((tblBaleInventory.GradeCode)<>40 And (tblBaleInventory.GradeCode)<>50) AND ((DateAdd('n',0,Format([ConsumedDate] & ' ' & [ConsumedTime],'General Date'))) "
				 * +
				 * "Between :sdate and :edate) AND ((IIf(IsNull([ConsumedDate]),'a','b'))='b') "
				 * +
				 * "group by [tblBaleInventory.ConsumedDate],[tblBaleInventory.GradeCode],[tblBaleInventory.ConsumedTime],[tlkpGrade.Grade]"
				 * ;
				 */
				
				List<Map<String, Object>> mapList=new ArrayList<Map<String,Object>>();
				try {
					mapList=jdbcTemplate.queryForList(sqlForUnloadDetails,new Object[]{
							new Timestamp(scal.getTime().getTime()),
							new Timestamp(ecal.getTime().getTime())
					});
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				if(mapList.size()>0){
					
					for (final Map<String, Object> map1 : mapList) {				
							
							BigDecimal bd1=(BigDecimal)( map1.get("BALEWT")==null?0:(BigDecimal )map1.get("BALEWT"));
							double _totalBaleWeight=bd1.doubleValue();
							int _totalBales=map1.get("COUNTBALE")==null?0:(int)map1.get("COUNTBALE");
							BigDecimal bd2=(BigDecimal) map1.get("GradeCode");
							int _gradeCode=bd2.intValue();
							
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
							}*/
							if(_gradeCode==50){
								totalbalesofhardwoodchips = totalbalesofhardwoodchips + _totalBales;
								totalbalesweightofhardwoodchips=totalbalesweightofhardwoodchips+_totalBaleWeight;
								
								wastePaperBaleInventory.setTotalbalesweightOfhardwoodchips(totalbalesweightofhardwoodchips);
								wastePaperBaleInventory.setTotalbalesOfhardwoodchips(totalbalesofhardwoodchips);
							}
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
							if(_gradeCode==72){
								totalbalesofVirginSoftWood = totalbalesofVirginSoftWood + _totalBales;
								totalbalesweightofVirginSoftWood=totalbalesweightofVirginSoftWood+_totalBaleWeight;
								
								wastePaperBaleInventory.setTotalbalesweightofVirginSoftWood(totalbalesweightofVirginSoftWood);
								wastePaperBaleInventory.setTotalbalesofVirginSoftWood(totalbalesofVirginSoftWood);
							}
							if(_gradeCode==71){
								totalbalesofVirginHardWood = totalbalesofVirginHardWood + _totalBales;
								totalbalesweightofVirginHardWood=totalbalesweightofVirginHardWood+_totalBaleWeight;
								
								wastePaperBaleInventory.setTotalbalesweightofVirginHardWood(totalbalesweightofVirginHardWood);
								wastePaperBaleInventory.setTotalbalesofVirginHardWood(totalbalesofVirginHardWood);
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
								totalbalesofvirginSW_Fluff = totalbalesofvirginSW_Fluff + _totalBales;
								totalbalesweightofvirginSW_Fluff=totalbalesweightofvirginSW_Fluff+_totalBaleWeight;
								
								wastePaperBaleInventory.setTotalbalesweightofVirginSW_Fluff(totalbalesweightofvirginSW_Fluff);
								wastePaperBaleInventory.setTotalbalesofVirginSW_Fluff(totalbalesofvirginSW_Fluff);
							}
							if(_gradeCode==80){
								totalbalesofother = totalbalesofother + _totalBales;
								totalbalesweightofother=totalbalesweightofother+_totalBaleWeight;
								
								wastePaperBaleInventory.setTotalbalesweightOfother(totalbalesweightofother);
								wastePaperBaleInventory.setTotalbalesOfother(totalbalesofother);
							}
							if(_gradeCode==87){
								totalbalesofpulpdrylap = totalbalesofpulpdrylap + _totalBales;
								totalbalesweightofpulpdrylap=totalbalesweightofpulpdrylap+_totalBaleWeight;
								
								wastePaperBaleInventory.setTotalbalesweightOfpulpdrylap(totalbalesweightofpulpdrylap);
								wastePaperBaleInventory.setTotalbalesOfpulpdrylap(totalbalesofpulpdrylap);
							}
							if(_gradeCode==91){
								totalbalesofotherrolls = totalbalesofotherrolls + _totalBales;
								totalbalesweightofotherrolls=totalbalesweightofotherrolls+_totalBaleWeight;
								
								wastePaperBaleInventory.setTotalbalesweightOfotherrolls(totalbalesweightofotherrolls);
								wastePaperBaleInventory.setTotalbalesOfotherrolls(totalbalesofotherrolls);
							}
							if(_gradeCode==95){
								totalbalesofstbaleswetlap = totalbalesofstbaleswetlap + _totalBales;
								totalbalesweightofstbaleswetlap=totalbalesweightofstbaleswetlap+_totalBaleWeight;
								
								wastePaperBaleInventory.setTotalbalesweightOfstbaleswetlap(totalbalesweightofstbaleswetlap);
								wastePaperBaleInventory.setTotalbalesOfstbaleswetlap(totalbalesofstbaleswetlap);
							}
							
						}
					wastePaperBaleInventory.setTotalbales(_totalBalesCount);
					wastePaperBaleInventory.setTotalbalesweight(_totalBaleWeightCount);
					
					wastePaperBaleInventory.setYieldtotalofpulpar3(totalbalesweightofhw+totalbalesweightofpulpwetlap+totalbalesweightofpulpdrylap+totalbalesweightofvirginpulp
							+totalbalesweightofstbaleswetlap+totalbalesweightofother+totalbalesweightofvirginSW_Fluff);
					wastePaperBaleInventory.setYieldtotalofpulpar4(totalbalesweightofcbs+totalbalesweightofctdgdwd+totalbalesweightofmcl+totalbalesweightofmwlwigs+
							totalbalesweightofunctdflyleafshvgs+totalbalesweightofmwl+totalbalesweightofnewsblank+totalbalesweightofotherrolls+
							totalbalesweightofpmix+totalbalesweightofpwe+totalbalesweightofsow+totalbalesweightofswl+totalbalesweightofocccorrugated+
							totalbalesweightoflightprtsbs+totalbalesweightofheavyprtsbs+totalbalesweightofdlk+totalbalesweightofmixedpaper+totalbalesweightofhardwoodchips);
				}
				}
				
				
			catch(Exception rlt){
				System.out.println("You Have A Problem In BarcodeConsumedBalesReportDaoImp.java at first section.");
				rlt.printStackTrace();
			}
			
			double totalbroke=0;
			double totalcgwd=0;
			double totalcgwdSection=0;
			double totalsw=0;
			double totalwhiteBland=0;
			double totalwhiteBlend=0;
			double totalSTBalesWetLap=0;
			double totalScaVirginPulp=0;
			double totalTrimLoss=0;
			
			try{
				JdbcTemplate jdbcTemplate1=new JdbcTemplate(dataSource);
				String sql="SELECT  * from [yieldreportdata] Where [DateS]=?";
				List<Map<String, Object>> priceton=new ArrayList<Map<String,Object>>();
				priceton=jdbcTemplate1.queryForList(sql, new Object[]{dateS1});
				if(priceton.size()>0){
					for(Map<String, Object> Ton: priceton){
						double broke=Ton.get("broke")==null?0:(Double)Ton.get("broke");
						double STBalesWetLap=Ton.get("STBalesWetLap")==null?0:(Double)Ton.get("STBalesWetLap");
						double cgwd=Ton.get("cgwd")==null?0:(Double)Ton.get("cgwd");
						double cgwdSection=Ton.get("cgwdSection")==null?0:(Double)Ton.get("cgwdSection");
						double sw=Ton.get("sw")==null?0:(Double)Ton.get("sw");
						double whiteBland=Ton.get("whiteBland")==null?0:(Double)Ton.get("whiteBland");
						double whiteBlend=Ton.get("whiteBlend")==null?0:(Double)Ton.get("whiteBlend");
						double scaVirginPulp=Ton.get("ScaVirginPulp")==null?0:(Double)Ton.get("ScaVirginPulp");
						double trimLoss=Ton.get("TrimLoss")==null?0:(Double)Ton.get("TrimLoss");
						
						totalbroke = totalbroke + broke;
						totalcgwd = totalcgwd + cgwd;
						totalcgwdSection = totalcgwdSection + cgwdSection;
						totalsw = totalsw + sw;
						totalwhiteBland = totalwhiteBland + whiteBland;
						totalwhiteBlend = totalwhiteBlend + whiteBlend;
						totalSTBalesWetLap = totalSTBalesWetLap + STBalesWetLap;
						totalScaVirginPulp = totalScaVirginPulp + scaVirginPulp;
						totalTrimLoss = totalTrimLoss + trimLoss;
						
						wastePaperBaleInventory.setYieldbroke(totalbroke);
						wastePaperBaleInventory.setYieldcgwd(totalcgwd);
						wastePaperBaleInventory.setYieldcgwdsection(totalcgwdSection);
						wastePaperBaleInventory.setYieldsw(totalsw);
						wastePaperBaleInventory.setYieldwhitebland(totalwhiteBland);
						wastePaperBaleInventory.setYieldwhiteblend(totalwhiteBlend);
						wastePaperBaleInventory.setYieldstbaleswetLap(totalSTBalesWetLap);
						wastePaperBaleInventory.setYieldscavirginpulp(totalScaVirginPulp);
						wastePaperBaleInventory.setYieldtrimloss(totalTrimLoss);
						
						totalofpulper3=wastePaperBaleInventory.getYieldtotalofpulpar3()+totalbroke;
						totalofpulper4=wastePaperBaleInventory.getYieldtotalofpulpar4()+totalcgwd+totalcgwdSection+totalsw+totalwhiteBland+totalwhiteBlend;
						
						wastePaperBaleInventory.setYieldtotalofpulpar3(totalofpulper3);
						wastePaperBaleInventory.setYieldtotalofpulpar4(totalofpulper4);
					}
					
				}
			}catch(Exception rlt){
				
			}
			//Now Code Starts From Here For Total Mill Production
			double TotalWhiteWeightTM1=0;
			double TotalRedWeightTM1=0;
			//Code First For TM1
			try{
				JdbcTemplate jdbcTemplateP=new JdbcTemplate(dataSourceP);
				String sqlTM1="select "
						+ " w.[WhiteWeight],"
						+ " w.[RedWeight],"
						+ " w.[RejectWeight], "
						+ " w.[Customer],"
						+ "	w.[GradeCode] "
						+ " from [tblWrapperProduction] w,tlkpGradeCode AS g "
						+ " where "
						+ " (w.[DateTimeEntered] between ? and  ?) "
						+ " And "
						+ " (g.[CustCode]=w.[CustomerGradeCode]) "
						+ " And "
						+ " (g.[GradeCode]=w.[GradeCode]) "
						+ " order by w.[DateTimeEntered]";
				
				List<Map<String, Object>> tm1=new ArrayList<Map<String,Object>>();
				tm1=jdbcTemplateP.queryForList(sqlTM1, new Object[]{
						new Timestamp(scal.getTime().getTime()),
						new Timestamp(ecal.getTime().getTime())
					});				
				if(tm1.size()>0){
					for(Map<String, Object> tmone: tm1){
						
						/*double WhiteWeightTM1=tmone.get("WhiteWeight")==null?0:(Double)tmone.get("WhiteWeight");
						double RedWeightTM1=tmone.get("RedWeight")==null?0:(Double)tmone.get("RedWeight");*/
						
						
						BigDecimal bd1 =(BigDecimal)tmone.get("WhiteWeight");
						BigDecimal bd2 =(BigDecimal)tmone.get("RedWeight");
						
						Double WhiteWeightTM1=0.0;
						Double RedWeightTM1=0.0;
						if(bd1==null){
							WhiteWeightTM1=0.0;
						}else{
							WhiteWeightTM1 = bd1.doubleValue();
						}
						
						if(bd2==null){
							RedWeightTM1 =0.0;
						}else{
							RedWeightTM1 = bd2.doubleValue();
						}
						
						
						
						TotalWhiteWeightTM1=TotalWhiteWeightTM1+WhiteWeightTM1;
						TotalRedWeightTM1=TotalRedWeightTM1+RedWeightTM1;
						
					}
					
					TotalWhiteWeightTM1=TotalWhiteWeightTM1/2000;
					
					
					TotalRedWeightTM1=TotalRedWeightTM1/2000;
					
					
					//System.out.println("TotalWhiteWeightTM1::"+TotalWhiteWeightTM1);
					//System.out.println("TotalRedWeightTM1::"+TotalRedWeightTM1);
				}
			}catch(Exception rlt){
				rlt.printStackTrace();
			}
			
			//Now Code Ends Here For Total Mill Production
			
			double totalmillproducation=CommonUtil.round(TotalWhiteWeightTM1, 2)+CommonUtil.round(TotalRedWeightTM1, 2);
			wastePaperBaleInventory.setYieldtotalmillproduction(totalmillproducation);
			
			double TotalWhiteWeightWR1=0;
			double TotalRedWeightWR1=0;
			//Code First For TM1
			try{
				JdbcTemplate jdbcTemplateP=new JdbcTemplate(dataSourceP);
				String sqlTM1="select "
						+ " w.[WhiteWeight],"
						+ " w.[RedWeight],"
						+ " w.[RejectWeight], "
						+ " w.[Customer],"
						+ "	w.[GradeCode] "
						+ " from [tblWrapperProduction] w,tlkpGradeCode AS g "
						+ " where "
						+ " (w.[DateTimeEntered] between ? and  ?) "
						+ " And "
						+ " (g.[CustCode]=w.[CustomerGradeCode]) "
						+ " And "
						+ " (g.[GradeCode]=w.[GradeCode]) "
						+"AND w.[Customer] in('Overall sunset','Cardinal Tissue','Overall')"
						+ " order by w.[DateTimeEntered]";
				
				List<Map<String, Object>> stvirgin=new ArrayList<Map<String,Object>>();
				stvirgin=jdbcTemplateP.queryForList(sqlTM1, new Object[]{
						new Timestamp(scal.getTime().getTime()),
						new Timestamp(ecal.getTime().getTime())
					});
				if(stvirgin.size()>0){
					for(Map<String, Object> tmone: stvirgin){
						
						/*double WhiteWeightTM1=tmone.get("WhiteWeight")==null?0:(Double)tmone.get("WhiteWeight");
						double RedWeightTM1=tmone.get("RedWeight")==null?0:(Double)tmone.get("RedWeight");*/
						
						
						BigDecimal bd1 =(BigDecimal)tmone.get("WhiteWeight");
						BigDecimal bd2 =(BigDecimal)tmone.get("RedWeight");
						
						Double WhiteWeightWR1=0.0;
						Double RedWeightWR1=0.0;
						if(bd1==null){
							WhiteWeightWR1=0.0;
						}else{
							WhiteWeightWR1 = bd1.doubleValue();
						}
						
						if(bd2==null){
							RedWeightWR1 =0.0;
						}else{
							RedWeightWR1 = bd2.doubleValue();
						}
						
						
						
						TotalWhiteWeightWR1=TotalWhiteWeightWR1+WhiteWeightWR1;
						TotalRedWeightWR1=TotalRedWeightWR1+RedWeightWR1;
						
					}
					
					TotalWhiteWeightWR1=TotalWhiteWeightWR1/2000;
					TotalWhiteWeightWR1=TotalWhiteWeightWR1*0.99;
					
					TotalRedWeightWR1=TotalRedWeightWR1/2000;
					TotalRedWeightWR1=TotalRedWeightWR1*0.99;
				}
			}catch(Exception rlt){
				rlt.printStackTrace();
			}			
			wastePaperBaleInventory.setStvirginproduction(TotalWhiteWeightWR1);
			
			unloadDetails.add(wastePaperBaleInventory);	
			date.add(Calendar.DATE, 1);
			calendar.add(Calendar.DATE, 1);
			}
		System.out.println("Fetching BARCODE CONSUMED BALES - For Mill Yield Report <END>");
		return unloadDetails;
	}



	@Override
	public int saveYieldData(final WastePaperBaleInventory yielddata) {
		// TODO Auto-generated method stub
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		KeyHolder keyHolder=new GeneratedKeyHolder();
		final String sql="insert into yieldreportdata"
				+ "([DateS],"
				+ "[broke],"
				+ "[cgwd],"
				+ "[cgwdSection],"
				+ "[sw],"									
				+ "[whiteBland],"
				+ "[whiteBlend],"
				+ "[STBalesWetLap],"
				+ "[ScaVirginPulp],"
				+ "[TrimLoss])"
				+ " values(?,?,?,?,?,?,?,?,?,?)";
			jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection arg0)
					throws SQLException {
				// TODO Auto-generated method stub
				PreparedStatement statement=arg0.prepareStatement(sql,new String[] {"ID"});
				
			  statement.setTimestamp(1, new Timestamp(yielddata.getDate().getTime()));
			  statement.setDouble(2,yielddata.getYieldbroke());
			  statement.setDouble(3,yielddata.getYieldcgwd());
			  statement.setDouble(4,yielddata.getYieldcgwdsection());
			  statement.setDouble(5,yielddata.getYieldsw());
			  statement.setDouble(6,yielddata.getYieldwhitebland());
			  statement.setDouble(7,yielddata.getYieldwhiteblend());
			  statement.setDouble(8,yielddata.getYieldstbaleswetLap());
			  statement.setDouble(9,yielddata.getYieldscavirginpulp());
			  statement.setDouble(10,yielddata.getYieldtrimloss());
			  return statement;
			}
			
			},keyHolder);
			return keyHolder.getKey().intValue();
	}



	@Override
	public List<WastePaperBaleInventory> getMillYieldDataEntry(Date startdate,
			Date enddate) {
		// TODO Auto-generated method stub
		
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		String sql="SELECT * FROM [yieldreportdata] WHERE "
				+ "[DateS] Between ? and ? ORDER BY [DateS]";
		List<WastePaperBaleInventory> tempData=jdbcTemplate.query(sql,new Object[]{startdate,enddate},new RowMapper<WastePaperBaleInventory>(){

			@Override
			public WastePaperBaleInventory mapRow(ResultSet rs, int arg1)
					throws SQLException {
				WastePaperBaleInventory yd=new WastePaperBaleInventory();
				yd.setDate(rs.getTimestamp("DateS"));
				yd.setId(rs.getInt("id"));
				yd.setYieldbroke(rs.getDouble("broke"));
				yd.setYieldcgwd(rs.getDouble("cgwd"));
				yd.setYieldcgwdsection(rs.getDouble("cgwdSection"));
				yd.setYieldsw(rs.getDouble("sw"));
				yd.setYieldwhitebland(rs.getDouble("whiteBland"));
				yd.setYieldwhiteblend(rs.getDouble("whiteBlend"));
				yd.setYieldstbaleswetLap(rs.getDouble("STBalesWetLap"));
				yd.setYieldscavirginpulp(rs.getDouble("ScaVirginPulp"));
				yd.setYieldtrimloss(rs.getDouble("TrimLoss"));
				return yd;
			}
			
		});
		return tempData;
	}



	@Override
	public void updateYieldData(final WastePaperBaleInventory yielddata) {

		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		final String sql="update [yieldreportdata] set "
				+"[broke]=?,"
				+"[cgwd]=?,"
				+"[cgwdSection]=?,"
				+"[sw]=?,"
				+"[whiteBland]=?,"
				+"[whiteBlend]=?,"
				+"[STBalesWetLap]=?,"
				+"[ScaVirginPulp]=?,"
				+"[TrimLoss]=?"
				+ " where [ID]=?";
		
		jdbcTemplate.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection arg0)
					throws SQLException {
				PreparedStatement statement=arg0.prepareStatement(sql);
				statement.setDouble(1,yielddata.getYieldbroke());
				statement.setDouble(2,yielddata.getYieldcgwd());
				statement.setDouble(3,yielddata.getYieldcgwdsection());
				statement.setDouble(4,yielddata.getYieldsw());
				statement.setDouble(5, yielddata.getYieldwhitebland());
				statement.setDouble(6, yielddata.getYieldwhiteblend());
				statement.setDouble(7, yielddata.getYieldstbaleswetLap());
				statement.setDouble(8, yielddata.getYieldscavirginpulp());
				statement.setDouble(9, yielddata.getYieldtrimloss());
				statement.setInt(10, yielddata.getId());
				return statement;
			}
		});
	}
}

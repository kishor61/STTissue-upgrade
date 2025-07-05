/**
 *Jul 8, 2015
 *WastePaperUnloadBaleDaoImp.java
 * TODO
 *com.st.wastepaperunloadbale.dao
 *WastePaperUnloadBaleDaoImp.java
 *roshan
 */
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
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import javax.sql.DataSource;

import org.joda.time.DateTime;
import org.joda.time.Days;
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
import com.st.wastepaper.mapper.WastePaperBaleInventoryGradeMapper;
import com.st.wastepaper.model.BarcodeComman;
import com.st.wastepaper.model.WastePaperBaleInventory;
import com.st.wastepaper.model.WastepaperDetail;


/**
 * @author roshan
 *
 */
@Repository
public class WastePaperUnloadBaleDaoImp implements WastePaperUnloadBaleDao {
	
	@Autowired
	private DataSource dataSource;
	
	@Autowired
	@Qualifier("dataSourceProduction")
	private DataSource dataSourceP;
	/* (non-Javadoc)
	 * @see com.st.wastepaperunloadbale.dao.WastePaperUnloadBaleDao#getUnloadBales(java.util.Date, java.util.Date)
	 */
	@Override
	public List<WastePaperBaleInventory> getUnloadBales(Date sdate,Date edate) throws Exception{

		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		
		SimpleDateFormat dateFormatTesting = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss");
		//JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSourceP);
		NamedParameterJdbcTemplate  jdbcTemplate=new NamedParameterJdbcTemplate(dataSourceP);
		List<WastePaperBaleInventory> unloadDetails= new ArrayList<WastePaperBaleInventory>();
		
		
		Calendar calendar=Calendar.getInstance();
		calendar.setTime(sdate);
		System.out.println("Fetching BARCODE UNLOAD BALES - GRADEWISE <START>");
		
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
			
			/*System.out.println("Sdate:"+dateFormatTesting.format(scal.getTime()));
			System.out.println("Edate:"+dateFormatTesting.format(ecal.getTime()));
			System.out.println("Frm Date:"+dateFormatTesting.format(frmCal.getTime()));
			System.out.println("To Date:"+dateFormatTesting.format(toCal.getTime()));*/
			
			final WastePaperBaleInventory wastePaperBaleInventory=new WastePaperBaleInventory();
			
			int _totalBalesCount=0;
			double _totalBaleWeightCount=0.0;
			
			
			double TotalbalesweightForMWL=0.0;
			int TotalbalesOfMWL=0;

			double TotalbalesweightForPrtmix=0.0;
			int TotalbalesOfPrtmix=0;
			
			double TotalbalesweightForMCL=0.0;
			int TotalbalesOfMCL=0;
			 
			double TotalbalesweightForMWLWorIGS=0.0;
			int TotalbalesOfMWLWorIGS=0;
			
			double TotalbalesweightForCBS=0.0;
			int TotalbalesOfCBS=0;
			
			double TotalbalesweightForCtdGdwd=0.0;
			int TotalbalesOfCtdGdwd=0;
			
			double TotalbalesweightForSWL=0.0;
			int TotalbalesOfSWL=0;
			
			double  TotalbalesweightForONPOldNewsPrint=0.0;
			int TotalbalesOfONPOldNewsPrint=0;
			 
			double TotalbalesweightForOINews=0.0;
			int TotalbalesOfOINews=0;
			
			double TotalbalesweightForLightPrtSBS=0.0;
			int TotalbalesOfLightPrtSBS=0;
			
			double TotalbalesweightForHW=0.0;
			int TotalbalesOfHW=0;
			
			double TotalbalesweightForHeavyPrtSBS=0.0;
			int TotalbalesOfHeavyPrtSBS=0;
			
			double TotalbalesweightForSOW=0.0;
			int TotalbalesOfSOW=0;
			
			double TotalbalesweightForUnprtSBS=0.0;
			int TotalbalesOfUnprtSBS=0;
			
			double TotalbalesweightForNewsblank=0.0;
			int TotalbalesOfNewsblank=0;
			
			double TotalbalesweightForWhiteGdwdBlend=0.0;
			int TotalbalesOfWhiteGdwdBlend=0;
			
			double TotalbalesweightForMailUndeliverable=0.0;
			int TotalbalesOfMailUndeliverable=0;
			
			double TotalbalesweightForHoggedBooks=0.0;
			int TotalbalesOfHoggedBooks=0;
			
			double TotalbalesweightForOCC=0;
			int TotalbalesOfOCC=0;

			double TotalbalesweightForDLK=0;
			int TotalbalesOfDLK=0;

			double TotalbalesweightForMixedPaper=0;
			int TotalbalesOfMixedPaper=0;

			double TotalbalesweightForSoftWoodChips=0;
			int TotalbalesOfSoftWoodChips=0;

			double TotalbalesweightForHardWoodChips=0;
			int TotalbalesOfHardWoodChips=0;

			double TotalbalesweightForPWE=0;
			int TotalbalesOfPWE=0;

			double TotalbalesweightForWhiteBroke=0;
			int TotalbalesOfWhiteBroke=0;

			double TotalbalesweightForBrownNapkinBroke=0;
			int TotalbalesOfBrownNapkinBroke=0;

			double TotalbalesweightForPULPWetLap=0;
			int TotalbalesOfPULPWetLap=0;

			double TotalbalesweightForVirginPulp=0;
			int TotalbalesOfVirginPulp=0;

			double TotalbalesweightForBrownWetLap=0;
			int TotalbalesOfBrownWetLap=0;

			double TotalbalesweightForPulpDryLap=0;
			int TotalbalesOfPulpDryLap=0;

			double TotalbalesweightForOtherRolls=0;
			int TotalbalesOfOtherRolls=0;

			double TotalbalesweightForSTBaleswetlap=0;
			int TotalbalesOfSTBaleswetlap=0;

			double TotalbalesweightForSTTBaledBroke=0;
			int TotalbalesOfSTTBaledBroke=0;
			
			/*New Grade Code Added Starts From Here*/
			
			double TotalbalesweightForVirginHardWood=0;
			int TotalbalesOfVirginHardWood=0;

			double TotalbalesweightForVirginSoftWood=0;
			int TotalbalesOfVirginSoftWood=0;
						
			
			Date dateS=scal.getTime();
			wastePaperBaleInventory.setDate(dateS);
			
			try{
				/*String sqlForUnloadDetails="SELECT [UnloadDate], sum(BaleWeight)/2000 as BALEWT,[GradeCode],count(*) as COUNTBALE FROM [tblBaleInventory] where "
						+ "DateAdd('n',0,Format([UnloadDate] & ' ' & [UnloadTime],'General Date')) between ? and ? AND [GradeCode] in "
						+ "(select GradeCode from tlkpGrade)group by [UnloadDate],[GradeCode]";*/
				
				/*String sqlForUnloadDetails="SELECT [UnloadDate], sum(BaleWeight)/2000 as BALEWT,[GradeCode], "
						+ "count(*) as COUNTBALE FROM ( "
						+ " select [UnloadDate],[UnloadTime],[BaleWeight],[GradeCode] "
						+ "	from [tblBaleInventory] where [UnloadDate] between :frmDate and :toDate "
						+ ") where  DateAdd('n',0,Format([UnloadDate] & ' ' & [UnloadTime],'General Date')) "
						+ "between :sdate and :edate AND [GradeCode] in (select GradeCode from tlkpGrade ) "
						+ "group by [UnloadDate],[GradeCode] ";*/
				
				String sqlForUnloadDetails="select [UnloadDate], sum(BaleWeight)/2000 as BALEWT,[GradeCode],count(*) as COUNTBALE from (select [UnloadDate],[UnloadTime],[BaleWeight],[GradeCode] "
						+ " from [tblBaleInventory] where [UnloadDate] between :frmDate and :toDate )"
						+ " as M where M.GradeCode in (select GradeCode from tlkpGrade ) AND CONVERT(DATETIME, CONVERT(CHAR(8), M.UnloadDate, 112) + ' ' + CONVERT(CHAR(8), M.UnloadTime, 108)) between :sdate and :edate group by M.UnloadDate,M.GradeCode";

				
				List<Map<String, Object>> mapList=new ArrayList<Map<String,Object>>();
				try {
					mapList=jdbcTemplate.queryForList(sqlForUnloadDetails,source);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				
				
				if(mapList.size()>0){
					
					for (final Map<String, Object> map1 : mapList) {
						
						
							//double _totalBaleWeight=map1.get("BALEWT")==null?0:(Double)map1.get("BALEWT");
							BigDecimal d = BigDecimal.ZERO;
							d= (BigDecimal) (map1.get("BALEWT")==null?0:(BigDecimal)(map1.get("BALEWT")));
							double _totalBaleWeight = d.doubleValue(); 
							
							
							int _totalBales=map1.get("COUNTBALE")==null?0:(Integer)map1.get("COUNTBALE");
							
							//int _gradeCode=(Integer)map1.get("GradeCode");
							
							BigDecimal d1 = BigDecimal.ZERO;
							d1= (BigDecimal) (map1.get("GradeCode")==null?0:(BigDecimal)(map1.get("GradeCode")));
							
							int _gradeCode=d1.intValueExact();
							
							_totalBalesCount = _totalBalesCount + _totalBales;
							wastePaperBaleInventory.setTotalbales(_totalBalesCount);
							
							
							_totalBaleWeightCount=_totalBaleWeightCount+_totalBaleWeight;
							wastePaperBaleInventory.setTotalbalesweight(_totalBaleWeightCount);
							
							if(_gradeCode==1){
								
								TotalbalesOfMWL = TotalbalesOfMWL + _totalBales;
								TotalbalesweightForMWL=TotalbalesweightForMWL+_totalBaleWeight;
								
								wastePaperBaleInventory.setTotalbalesweightForMWL(TotalbalesweightForMWL);
								wastePaperBaleInventory.setTotalbalesOfMWL(TotalbalesOfMWL);
							}
							if(_gradeCode==2){
								
								TotalbalesOfPrtmix = TotalbalesOfPrtmix + _totalBales;
								TotalbalesweightForPrtmix=TotalbalesweightForPrtmix+_totalBaleWeight;
								
								
								wastePaperBaleInventory.setTotalbalesweightForPrtmix(TotalbalesweightForPrtmix);
								wastePaperBaleInventory.setTotalbalesOfPrtmix(TotalbalesOfPrtmix);
							}
							if(_gradeCode==3){
								
								TotalbalesOfMCL = TotalbalesOfMCL + _totalBales;
								TotalbalesweightForMCL=TotalbalesweightForMCL+_totalBaleWeight;
								
								
								 wastePaperBaleInventory.setTotalbalesweightForMCL(TotalbalesweightForMCL);
								 wastePaperBaleInventory.setTotalbalesOfMCL(TotalbalesOfMCL);
							}
							if(_gradeCode==4){
								
								TotalbalesOfMWLWorIGS = TotalbalesOfMWLWorIGS + _totalBales;
								TotalbalesweightForMWLWorIGS=TotalbalesweightForMWLWorIGS+_totalBaleWeight;
								
								
								wastePaperBaleInventory.setTotalbalesweightForMWLWorIGS(TotalbalesweightForMWLWorIGS);
								wastePaperBaleInventory.setTotalbalesOfMWLWorIGS(TotalbalesOfMWLWorIGS);
							}
							if(_gradeCode==5){
								
								TotalbalesOfCBS = TotalbalesOfCBS + _totalBales;
								TotalbalesweightForCBS=TotalbalesweightForCBS+_totalBaleWeight;
								
								
								wastePaperBaleInventory.setTotalbalesweightForCBS(TotalbalesweightForCBS);
								wastePaperBaleInventory.setTotalbalesOfCBS(TotalbalesOfCBS);
							}
							if(_gradeCode==6){
								
								TotalbalesOfCtdGdwd = TotalbalesOfCtdGdwd + _totalBales;
								TotalbalesweightForCtdGdwd=TotalbalesweightForCtdGdwd+_totalBaleWeight;
								
								
								wastePaperBaleInventory.setTotalbalesweightForCtdGdwd(TotalbalesweightForCtdGdwd);
								wastePaperBaleInventory.setTotalbalesOfCtdGdwd(TotalbalesOfCtdGdwd);
							}
							if(_gradeCode==7){
								
								TotalbalesOfSWL = TotalbalesOfSWL + _totalBales;
								TotalbalesweightForSWL=TotalbalesweightForSWL+_totalBaleWeight;
								
								
								wastePaperBaleInventory.setTotalbalesweightForSWL(TotalbalesweightForSWL);
								wastePaperBaleInventory.setTotalbalesOfSWL(TotalbalesOfSWL);
							}
							if(_gradeCode==8){
								
								TotalbalesOfONPOldNewsPrint = TotalbalesOfONPOldNewsPrint + _totalBales;
								TotalbalesweightForONPOldNewsPrint=TotalbalesweightForONPOldNewsPrint+_totalBaleWeight;
								
								
								 wastePaperBaleInventory.setTotalbalesweightForONPOldNewsPrint(TotalbalesweightForONPOldNewsPrint);
								 wastePaperBaleInventory.setTotalbalesOfONPOldNewsPrint(TotalbalesOfONPOldNewsPrint);	
							 }
							if(_gradeCode==9){
								
								TotalbalesOfOINews = TotalbalesOfOINews + _totalBales;
								TotalbalesweightForOINews=TotalbalesweightForOINews+_totalBaleWeight;
								
								
								wastePaperBaleInventory.setTotalbalesweightForOINews(TotalbalesweightForOINews);
								wastePaperBaleInventory.setTotalbalesOfOINews(TotalbalesOfOINews);
							}
							if(_gradeCode==10){
								
								TotalbalesOfLightPrtSBS = TotalbalesOfLightPrtSBS + _totalBales;
								TotalbalesweightForLightPrtSBS=TotalbalesweightForLightPrtSBS+_totalBaleWeight;
								
								
								wastePaperBaleInventory.setTotalbalesweightForLightPrtSBS(TotalbalesweightForLightPrtSBS);
								wastePaperBaleInventory.setTotalbalesOfLightPrtSBS(TotalbalesOfLightPrtSBS);
							}
							if(_gradeCode==11){
								
								TotalbalesOfHW = TotalbalesOfHW + _totalBales;
								TotalbalesweightForHW=TotalbalesweightForHW+_totalBaleWeight;
								
								
								wastePaperBaleInventory.setTotalbalesweightForHW(TotalbalesweightForHW);
								wastePaperBaleInventory.setTotalbalesOfHW(TotalbalesOfHW);
							}
							if(_gradeCode==12){
								
								TotalbalesOfHeavyPrtSBS = TotalbalesOfHeavyPrtSBS + _totalBales;
								TotalbalesweightForHeavyPrtSBS=TotalbalesweightForHeavyPrtSBS+_totalBaleWeight;
								
								
								wastePaperBaleInventory.setTotalbalesweightForHeavyPrtSBS(TotalbalesweightForHeavyPrtSBS);
								wastePaperBaleInventory.setTotalbalesOfHeavyPrtSBS(TotalbalesOfHeavyPrtSBS);
							}
							if( _gradeCode==13){
								
								TotalbalesOfSOW = TotalbalesOfSOW + _totalBales;
								TotalbalesweightForSOW=TotalbalesweightForSOW+_totalBaleWeight;
								
								
								wastePaperBaleInventory.setTotalbalesweightForSOW(TotalbalesweightForSOW);
								wastePaperBaleInventory.setTotalbalesOfSOW(TotalbalesOfSOW);	
							}
							if(_gradeCode==14){
								
								TotalbalesOfUnprtSBS = TotalbalesOfUnprtSBS + _totalBales;
								TotalbalesweightForUnprtSBS=TotalbalesweightForUnprtSBS+_totalBaleWeight;
								
								
								wastePaperBaleInventory.setTotalbalesweightForUnprtSBS(TotalbalesweightForUnprtSBS);
								wastePaperBaleInventory.setTotalbalesOfUnprtSBS(TotalbalesOfUnprtSBS);
							}
							if(_gradeCode==16){
								
								TotalbalesOfNewsblank = TotalbalesOfNewsblank + _totalBales;
								TotalbalesweightForNewsblank=TotalbalesweightForNewsblank+_totalBaleWeight;
								
								
								wastePaperBaleInventory.setTotalbalesweightForNewsblank(TotalbalesweightForNewsblank);
								wastePaperBaleInventory.setTotalbalesOfNewsblank(TotalbalesOfNewsblank);
							}
							if(_gradeCode==19){
								
								TotalbalesOfWhiteGdwdBlend = TotalbalesOfWhiteGdwdBlend + _totalBales;
								TotalbalesweightForWhiteGdwdBlend=TotalbalesweightForWhiteGdwdBlend+_totalBaleWeight;
								
								
								wastePaperBaleInventory.setTotalbalesweightForWhiteGdwdBlend(TotalbalesweightForWhiteGdwdBlend);
								wastePaperBaleInventory.setTotalbalesOfWhiteGdwdBlend(TotalbalesOfWhiteGdwdBlend);
							}
							if(_gradeCode==20){
								
								TotalbalesOfMailUndeliverable = TotalbalesOfMailUndeliverable + _totalBales;
								TotalbalesweightForMailUndeliverable=TotalbalesweightForMailUndeliverable+_totalBaleWeight;
								
								
								wastePaperBaleInventory.setTotalbalesweightForMailUndeliverable(TotalbalesweightForMailUndeliverable);
								wastePaperBaleInventory.setTotalbalesOfMailUndeliverable(TotalbalesOfMailUndeliverable);
							}
							if(_gradeCode==21){
								
								TotalbalesOfHoggedBooks = TotalbalesOfHoggedBooks + _totalBales;
								TotalbalesweightForHoggedBooks=TotalbalesweightForHoggedBooks+_totalBaleWeight;
								
								wastePaperBaleInventory.setTotalbalesweightForHoggedBooks(TotalbalesweightForHoggedBooks);
								wastePaperBaleInventory.setTotalbalesOfHoggedBooks(TotalbalesOfHoggedBooks);
							}
							if(_gradeCode==23){
								
								TotalbalesOfOCC = TotalbalesOfOCC + _totalBales;
								TotalbalesweightForOCC=TotalbalesweightForOCC+_totalBaleWeight;
								
								
								wastePaperBaleInventory.setTotalbalesweightForOCC(TotalbalesweightForOCC);
								wastePaperBaleInventory.setTotalbalesOfOCC(TotalbalesOfOCC);
							}
							if(_gradeCode==24){
								
								TotalbalesOfDLK = TotalbalesOfDLK + _totalBales;
								TotalbalesweightForDLK=TotalbalesweightForDLK+_totalBaleWeight;
								
								
								wastePaperBaleInventory.setTotalbalesweightForDLK(TotalbalesweightForDLK);
								wastePaperBaleInventory.setTotalbalesOfDLK(TotalbalesOfDLK);
							}
							if(_gradeCode==30){
								
								TotalbalesOfMixedPaper = TotalbalesOfMixedPaper + _totalBales;
								TotalbalesweightForMixedPaper=TotalbalesweightForMixedPaper+_totalBaleWeight;
								
								
								wastePaperBaleInventory.setTotalbalesweightForMixedPaper(TotalbalesweightForMixedPaper);
								wastePaperBaleInventory.setTotalbalesOfMixedPaper(TotalbalesOfMixedPaper);
							}
							//The Below Code Is Commented According to Discussed With Dinesh Sir Said Not For Use For Us. 
							/*if(_gradeCode==40){
								
								TotalbalesOfSoftWoodChips = TotalbalesOfSoftWoodChips + _totalBales;
								TotalbalesweightForSoftWoodChips=TotalbalesweightForSoftWoodChips+_totalBaleWeight;
								
								
								wastePaperBaleInventory.setTotalbalesweightForSoftWoodChips(TotalbalesweightForSoftWoodChips);
								wastePaperBaleInventory.setTotalbalesOfSoftWoodChips(TotalbalesOfSoftWoodChips);
							}
							if(_gradeCode==50){
								
								TotalbalesOfHardWoodChips = TotalbalesOfHardWoodChips + _totalBales;
								TotalbalesweightForHardWoodChips=TotalbalesweightForHardWoodChips+_totalBaleWeight;
								
								
								wastePaperBaleInventory.setTotalbalesweightForHardWoodChips(TotalbalesweightForHardWoodChips);
								wastePaperBaleInventory.setTotalbalesOfHardWoodChips(TotalbalesOfHardWoodChips);
							}*/
							if(_gradeCode==56){
								
								TotalbalesOfPWE = TotalbalesOfPWE + _totalBales;
								TotalbalesweightForPWE=TotalbalesweightForPWE+_totalBaleWeight;
								
								
								wastePaperBaleInventory.setTotalbalesweightForPWE(TotalbalesweightForPWE);
								wastePaperBaleInventory.setTotalbalesOfPWE(TotalbalesOfPWE);
							}
							if(_gradeCode==60){
								
								TotalbalesOfWhiteBroke = TotalbalesOfWhiteBroke + _totalBales;
								TotalbalesweightForWhiteBroke=TotalbalesweightForWhiteBroke+_totalBaleWeight;
								
								
								wastePaperBaleInventory.setTotalbalesweightForWhiteBroke(TotalbalesweightForWhiteBroke);
								wastePaperBaleInventory.setTotalbalesOfWhiteBroke(TotalbalesOfWhiteBroke);
							}
							if(_gradeCode==65){
								
								TotalbalesOfBrownNapkinBroke = TotalbalesOfBrownNapkinBroke + _totalBales;
								TotalbalesweightForBrownNapkinBroke=TotalbalesweightForBrownNapkinBroke+_totalBaleWeight;
								
								
								wastePaperBaleInventory.setTotalbalesweightForBrownNapkinBroke(TotalbalesweightForBrownNapkinBroke);
								wastePaperBaleInventory.setTotalbalesOfBrownNapkinBroke(TotalbalesOfBrownNapkinBroke);
							}
							if(_gradeCode==70){
								
								TotalbalesOfPULPWetLap = TotalbalesOfPULPWetLap + _totalBales;
								TotalbalesweightForPULPWetLap=TotalbalesweightForPULPWetLap+_totalBaleWeight;
								
								
								wastePaperBaleInventory.setTotalbalesweightForPULPWetLap(TotalbalesweightForPULPWetLap);
								wastePaperBaleInventory.setTotalbalesOfPULPWetLap(TotalbalesOfPULPWetLap);
							}
							if(_gradeCode==75){
								
								TotalbalesOfVirginPulp = TotalbalesOfVirginPulp + _totalBales;
								TotalbalesweightForVirginPulp=TotalbalesweightForVirginPulp+_totalBaleWeight;
								
								
								wastePaperBaleInventory.setTotalbalesweightForVirginPulp(TotalbalesweightForVirginPulp);
								wastePaperBaleInventory.setTotalbalesOfVirginPulp(TotalbalesOfVirginPulp);
							}
							if(_gradeCode==80){
								
								TotalbalesOfBrownWetLap = TotalbalesOfBrownWetLap + _totalBales;
								TotalbalesweightForBrownWetLap=TotalbalesweightForBrownWetLap+_totalBaleWeight;
								
								
								wastePaperBaleInventory.setTotalbalesweightForBrownWetLap(TotalbalesweightForBrownWetLap);
								wastePaperBaleInventory.setTotalbalesOfBrownWetLap(TotalbalesOfBrownWetLap);
							}
							if(_gradeCode==87){
								
								TotalbalesOfPulpDryLap = TotalbalesOfPulpDryLap + _totalBales;
								TotalbalesweightForPulpDryLap=TotalbalesweightForPulpDryLap+_totalBaleWeight;
								
								
								wastePaperBaleInventory.setTotalbalesweightForPulpDryLap(TotalbalesweightForPulpDryLap);
								wastePaperBaleInventory.setTotalbalesOfPulpDryLap(TotalbalesOfPulpDryLap);
							}
							if(_gradeCode==91){
								
								TotalbalesOfOtherRolls = TotalbalesOfOtherRolls + _totalBales;
								TotalbalesweightForOtherRolls=TotalbalesweightForOtherRolls+_totalBaleWeight;
								
								
								wastePaperBaleInventory.setTotalbalesweightForOtherRolls(TotalbalesweightForOtherRolls);
								wastePaperBaleInventory.setTotalbalesOfOtherRolls(TotalbalesOfOtherRolls);
							}
							if(_gradeCode==95){
								
								TotalbalesOfSTBaleswetlap = TotalbalesOfSTBaleswetlap + _totalBales;
								TotalbalesweightForSTBaleswetlap=TotalbalesweightForSTBaleswetlap+_totalBaleWeight;
								
								
								wastePaperBaleInventory.setTotalbalesweightForSTBaleswetlap(TotalbalesweightForSTBaleswetlap);
								wastePaperBaleInventory.setTotalbalesOfSTBaleswetlap(TotalbalesOfSTBaleswetlap);
							}
							if(_gradeCode==98){
								
								TotalbalesOfSTTBaledBroke = TotalbalesOfSTTBaledBroke + _totalBales;
								TotalbalesweightForSTTBaledBroke=TotalbalesweightForSTTBaledBroke+_totalBaleWeight;
								
								
								wastePaperBaleInventory.setTotalbalesweightForSTTBaledBroke(TotalbalesweightForSTTBaledBroke);
								wastePaperBaleInventory.setTotalbalesOfSTTBaledBroke(TotalbalesOfSTTBaledBroke);
							}
							
						/*New Grade Code Added Starts From Here*/
							if(_gradeCode==71){
								
								TotalbalesOfVirginHardWood = TotalbalesOfVirginHardWood + _totalBales;
								TotalbalesweightForVirginHardWood=TotalbalesweightForVirginHardWood+_totalBaleWeight;
								
								
								wastePaperBaleInventory.setTotalbalesweightForVirginHardWood(TotalbalesweightForVirginHardWood);
								wastePaperBaleInventory.setTotalbalesOfVirginHardWood(TotalbalesOfVirginHardWood);
							}
							
							if(_gradeCode==72){
								TotalbalesOfVirginSoftWood = TotalbalesOfVirginSoftWood + _totalBales;
								TotalbalesweightForVirginSoftWood=TotalbalesweightForVirginSoftWood+_totalBaleWeight;
								
								
								wastePaperBaleInventory.setTotalbalesweightForVirginSoftWood(TotalbalesweightForVirginSoftWood);
								wastePaperBaleInventory.setTotalbalesOfVirginSoftWood(TotalbalesOfVirginSoftWood);
							}
							
							else{}
							
						}
					}
				}
				
				
			catch(Exception rlt){
				System.out.println("You Have A Problem In WastePaperUnloadBaleController.java at first section.");
				rlt.printStackTrace();
			}
			 unloadDetails.add(wastePaperBaleInventory);	
			 date.add(Calendar.DATE, 1);
		}
		System.out.println("Fetching BARCODE UNLOAD BALES - GRADEWISE <END>");
		return unloadDetails;
	}
	/* (non-Javadoc)
	 * @see com.st.wastepaperunloadbale.dao.WastePaperUnloadBaleDao#getGrade()
	 */
	@Override
	public List<WastePaperBaleInventory> getGrade() {
		// TODO Auto-generated method stub
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSourceP);
		String sql="select * from tlkpGrade";
		List<WastePaperBaleInventory> grades=jdbcTemplate.query(sql, new WastePaperBaleInventoryGradeMapper());
		return grades;
	
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
				+ "[virginhardwood],"
				+ "[virginsoftwood],"
				+ "[virginhardwoodw],"
				+ "[virginsoftwoodw])"
				+ " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
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
			  //Now For Weight
			  statement.setDouble(36, barcodeComman.getPrtmixw());      
			  statement.setDouble(37, barcodeComman.getMwlw());      
			  statement.setDouble(38, barcodeComman.getMclw() );     
			  statement.setDouble(39, barcodeComman.getMwlwigsw() );    
			  statement.setDouble(40, barcodeComman.getCbsw());      
			  statement.setDouble(41, barcodeComman.getCtdGdwdw() );     
			  statement.setDouble(42, barcodeComman.getSwlsortedwhitew());
		      statement.setDouble(43, barcodeComman.getOnpolnNewsprintw());  
			  statement.setDouble(44, barcodeComman.getOinewsw());      
			  statement.setDouble(45, barcodeComman.getLightprtsbsw());      
			  statement.setDouble(46, barcodeComman.getHww() );     
			  statement.setDouble(47, barcodeComman.getHeavyprtsbsw());      
			  statement.setDouble(48, barcodeComman.getSoww());      
			  statement.setDouble(49, barcodeComman.getUnprtsbsw());      
			  statement.setDouble(50, barcodeComman.getNewsblankw());      
			  statement.setDouble(51, barcodeComman.getWhitegdwdblendw());      
			  statement.setDouble(52, barcodeComman.getMailundeliverablew() );     
			  statement.setDouble(53, barcodeComman.getHoggedbooksw());      
			  statement.setDouble(54, barcodeComman.getOccw());      
			  statement.setDouble(55, barcodeComman.getDlkw());      
			  statement.setDouble(56, barcodeComman.getMixedpaperw());      
			  statement.setDouble(57, barcodeComman.getSoftwoodchipsw());      
			  statement.setDouble(58, barcodeComman.getHardwoodchipsw());      
			  statement.setDouble(59, barcodeComman.getWhitebrokew());      
			  statement.setDouble(60, barcodeComman.getPwew() );     
			  statement.setDouble(61, barcodeComman.getBrownnapkinbrokew());      
			  statement.setDouble(62, barcodeComman.getPulpwetlapw());      
			  statement.setDouble(63, barcodeComman.getVirginpulpw());      
			  statement.setDouble(64, barcodeComman.getBrownwetLapw());      
			  statement.setDouble(65, barcodeComman.getPulpdryLapw());      
			  statement.setDouble(66, barcodeComman.getOtherrollsw());      
			  statement.setDouble(67, barcodeComman.getStbaleswetlapw());      
			  statement.setDouble(68, barcodeComman.getSttbaledbrokebutlw());
			  
			  statement.setDouble(69, barcodeComman.getVirginhardwoodw());
			  statement.setDouble(70, barcodeComman.getVirginsoftwoodw());
			  statement.setDouble(71, barcodeComman.getVirginhardwoodw());
			  statement.setDouble(72, barcodeComman.getVirginsoftwoodw());
						
		return statement;
			}
			
			},keyHolder);
			return keyHolder.getKey().intValue();
		}
	/* (non-Javadoc)
	 * @see com.st.wastepaperunloadbale.dao.WastePaperUnloadBaleDao#getClosedMonth(int, int)
	 */
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
				
				int virginhardwood=map1.get("virginhardwood")==null?0:(Integer)map1.get("virginhardwood");
				int virginsoftwood=map1.get("virginsoftwood")==null?0:(Integer)map1.get("virginsoftwood");
				
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
				
				double virginhardwoodw=map1.get("virginhardwoodw")==null?0:(double)map1.get("virginhardwoodw");
				double virginsoftwoodw=map1.get("virginsoftwoodw")==null?0:(double)map1.get("virginsoftwoodw");
				
			
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
				
				barcodeComman.setVirginhardwood(virginhardwood);
				barcodeComman.setVirginsoftwood(virginsoftwood);
				
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
				
				
				barcodeComman.setVirginhardwoodw(virginhardwoodw);
				barcodeComman.setVirginsoftwoodw(virginsoftwoodw);
				
				details.add(barcodeComman);
				
			}else{
				
			}
			
			
		
		}
		return details;
	}
	/* (non-Javadoc)
	 * @see com.st.wastepaperunloadbale.dao.WastePaperUnloadBaleDao#getClosedMonth(java.util.Date)
	 */
	@Override
	public List<BarcodeComman> getClosedMonth(Date date) {
		// TODO Auto-generated method stub
		return null;
	}
	/* (non-Javadoc)
	 * @see com.st.wastepaperunloadbale.dao.WastePaperUnloadBaleDao#update(com.st.wastepaperunloadbale.model.BarcodeComman)
	 */
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
				+ "[virginhardwood]=?,"
				+ "[virginsoftwood]=?,"
				+ "[virginhardwoodw]=?,"
				+ "[virginsoftwoodw]=?"

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
				  //Now For Weight
				  statement.setDouble(36, barcodeComman.getPrtmixw());      
				  statement.setDouble(37, barcodeComman.getMwlw());      
				  statement.setDouble(38, barcodeComman.getMclw() );     
				  statement.setDouble(39, barcodeComman.getMwlwigsw() );    
				  statement.setDouble(40, barcodeComman.getCbsw());      
				  statement.setDouble(41, barcodeComman.getCtdGdwdw() );     
				  statement.setDouble(42, barcodeComman.getSwlsortedwhitew());
			      statement.setDouble(43, barcodeComman.getOnpolnNewsprintw());  
				  statement.setDouble(44, barcodeComman.getOinewsw());      
				  statement.setDouble(45, barcodeComman.getLightprtsbsw());      
				  statement.setDouble(46, barcodeComman.getHww() );     
				  statement.setDouble(47, barcodeComman.getHeavyprtsbsw());      
				  statement.setDouble(48, barcodeComman.getSoww());      
				  statement.setDouble(49, barcodeComman.getUnprtsbsw());      
				  statement.setDouble(50, barcodeComman.getNewsblankw());      
				  statement.setDouble(51, barcodeComman.getWhitegdwdblendw());      
				  statement.setDouble(52, barcodeComman.getMailundeliverablew() );     
				  statement.setDouble(53, barcodeComman.getHoggedbooksw());      
				  statement.setDouble(54, barcodeComman.getOccw());      
				  statement.setDouble(55, barcodeComman.getDlkw());      
				  statement.setDouble(56, barcodeComman.getMixedpaperw());      
				  statement.setDouble(57, barcodeComman.getSoftwoodchipsw());      
				  statement.setDouble(58, barcodeComman.getHardwoodchipsw());      
				  statement.setDouble(59, barcodeComman.getWhitebrokew());      
				  statement.setDouble(60, barcodeComman.getPwew() );     
				  statement.setDouble(61, barcodeComman.getBrownnapkinbrokew());      
				  statement.setDouble(62, barcodeComman.getPulpwetlapw());      
				  statement.setDouble(63, barcodeComman.getVirginpulpw());      
				  statement.setDouble(64, barcodeComman.getBrownwetLapw());      
				  statement.setDouble(65, barcodeComman.getPulpdryLapw());      
				  statement.setDouble(66, barcodeComman.getOtherrollsw());      
				  statement.setDouble(67, barcodeComman.getStbaleswetlapw());      
				  statement.setDouble(68, barcodeComman.getSttbaledbrokebutlw());  
				  
				  
				  statement.setDouble(69, barcodeComman.getVirginhardwood());  
				  statement.setDouble(70, barcodeComman.getVirginsoftwood());  
				  statement.setDouble(71, barcodeComman.getVirginhardwoodw());  
				  statement.setDouble(72, barcodeComman.getVirginsoftwoodw());  
				
				  statement.setInt(73, barcodeComman.getClosemonth());
				  statement.setInt(74, barcodeComman.getCloseyear());

				return statement;
			}
		});
		
}
	/* (non-Javadoc)
	 * @see com.st.wastepaper.dao.WastePaperUnloadBaleDao#getFRPLocationData()
	 */
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
							//double baleWeight=(Double)mapBales.get("BALEWT");
							
							BigDecimal d = BigDecimal.ZERO;
							d= (BigDecimal) (mapBales.get("BALEWT")==null?0:(BigDecimal)(mapBales.get("BALEWT")));
							double baleWeight = d.doubleValue(); 
							
							
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
	/* (non-Javadoc)
	 * @see com.st.wastepaper.dao.WastePaperUnloadBaleDao#getReceivingReport(int)
	 */
	@Override
	public List<WastepaperDetail> getReceivingReport(int releaseNumber) {
		// TODO Auto-generated method stub
		
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSourceP);
		JdbcTemplate jdbcTemplate1=new JdbcTemplate(dataSource);
		
		List<WastepaperDetail> details=new ArrayList<WastepaperDetail>();
		
		String sqlBale="SELECT [ReleaseNumber],[UnloadDate], sum(BaleWeight)/2000 as [BaleWeightT],[GradeCode],count(*) as [Bales] "
				+ " FROM [tblBaleInventory] where "
				+ " [ReleaseNumber] = ? "
				+ " group by [ReleaseNumber],[UnloadDate],[GradeCode]";
		
		List<Map<String, Object>> maps=jdbcTemplate.queryForList(sqlBale, new Object[]{releaseNumber});
		
		for (Map<String, Object> map : maps) {
			
			String destination="";
			
			final WastepaperDetail wastepaperDetail=new WastepaperDetail();
			
			//int releaseNo=(Integer)map.get("ReleaseNumber".toUpperCase());
			BigDecimal d1 = BigDecimal.ZERO;
			d1= (BigDecimal) (map.get("ReleaseNumber")==null?0:(BigDecimal)(map.get("ReleaseNumber")));
			int releaseNo=d1.intValueExact();
			
//			double baleWeight=(Double)map.get("BaleWeightT".toUpperCase());
			//double baleWeight=(Double)map.get("BaleWeightT")==null?0:(Double)(map.get("BaleWeightT"));
			BigDecimal d2 = BigDecimal.ZERO;
			d2= (BigDecimal) (map.get("BaleWeightT")==null?0:(BigDecimal)(map.get("BaleWeightT")));
			double baleWeight = d2.doubleValue(); 
			
			
			//int gradeCode=(Integer)map.get("GradeCode".toUpperCase());
			BigDecimal d3 = BigDecimal.ZERO;
			d3= (BigDecimal) (map.get("GradeCode")==null?0:(BigDecimal)(map.get("GradeCode")));
			int gradeCode=d3.intValueExact();
			
			int bale=(Integer)map.get("Bales".toUpperCase());
			
			double StandardWeightTon=20.00;
			
			String sqlGrade="select [Grade] from [tlkpGrade] where [GradeCode]=?";
		
			try {
				String grade=jdbcTemplate.queryForObject(sqlGrade,new Object[]{gradeCode}, String.class);
				wastepaperDetail.setItemDescription(grade);
				wastepaperDetail.setGradeid(gradeCode);
			} catch (Exception e) {
				System.out.println("Grade Name not found: "+e.getMessage());
			}
			//Code Starts From Here Done By Roshan Tailor Date :-06/04/2015 MM/DD/YYYY  Night Shift
			try {
				String sqlmasterPO="select [MasterPO] AS PO,[UnLoadComment] AS Comment, [PickUpCity] AS City, [PickUpState] AS State from [tblPurchaseHeader] where [ReleaseNumber]=?";
				List<Map<String, Object>> masterPO=jdbcTemplate.queryForList(sqlmasterPO,new Object[]{releaseNo});
				for(Map<String, Object> masterponcomment:masterPO){
					String masterpo=(String)masterponcomment.get("PO");
					String comment=(String)masterponcomment.get("Comment");
					String _city=(String)masterponcomment.get("City");
					String _state=(String)masterponcomment.get("State");
					wastepaperDetail.setMasterPO(masterpo);
					wastepaperDetail.setComment(comment);
					try{
						String sqlMasterpo="select [MasterPO],[VendorName],[VendorCity],[VendorState] from [tblMasterPOHeader] where [MasterPO]=? ";
						List<Map<String, Object>> maps_2=jdbcTemplate.queryForList(sqlMasterpo,new Object[]{masterpo});
						if(maps_2.size()>0){
							Map<String, Object> map_2=maps_2.get(0);
							String MasterPO=(String)map_2.get("MasterPO");
							
							try{
								/*String sqlLineNumber="Select [LineNumber] AS LinePath from [tblMasterPODetailCity] Where [MasterPO]=? AND [City]=? AND [State]=?";
								List<Map<String, Object>> lineNumbers=new ArrayList<Map<String,Object>>();
								lineNumbers=jdbcTemplate.queryForList(sqlLineNumber, new Object[]{
										MasterPO,
										_city,
										_state
								});*/
								//if(lineNumbers.size()>0){
								String rt="A";
								if(rt.equalsIgnoreCase("B")){/*
									for(Map<String, Object> lines:lineNumbers){
										int _lineNumberForPO=(int)lines.get("LinePath");
										try{
											String sqlPricePerTon="SELECT sum(IIF(ISNULL(Rate),0,Rate)) as TotalPrizePerTon  FROM tblMasterPODetail where [MasterPO]=? AND [GradeCode]=? AND [LineNumber]=?";
											
											List<Map<String, Object>> priceperton=new ArrayList<Map<String,Object>>();
											priceperton=jdbcTemplate.queryForList(sqlPricePerTon, new Object[]{
													masterpo,
													gradeCode,
													_lineNumberForPO
													});
											if(priceperton.size()>0){
												for(Map<String, Object> TonAndCmt: priceperton){
													double price=(Double)TonAndCmt.get("TotalPrizePerTon")==null?0:(Double)(TonAndCmt.get("TotalPrizePerTon"));
													//Code For Price Per Ton Is 0	
													if(price==0){
															try{
																String sqlp="SELECT [PricePerTon] AS price FROM [tblwastepaperdetailreport] where [MasterPO]=? AND [ReleaseNo]=? AND [GradeId]=? ";
																List<Map<String, Object>> priceton=new ArrayList<Map<String,Object>>();
																priceton=jdbcTemplate1.queryForList(sqlp, new Object[]{
																		masterpo,	
																		releaseNo,
																		gradeCode
																});
																if(priceton.size()>0){
																	for(Map<String, Object> Ton: priceton){
																		double ODBprice=(Double)Ton.get("price")==null?0:(Double)(Ton.get("price"));
																		//System.out.println("ODBprice::"+ODBprice);
																		wastepaperDetail.setPricePerTon(ODBprice);
																	}
																}
															}catch(Exception rlt){
																rlt.printStackTrace();
																System.out.println("Roshan Say's, You Have A Problem In tblwastepaperdetailreport Table.");
															}
														}else{
															wastepaperDetail.setPricePerTon(price);
															
														}
													}
											}
										}catch(Exception rlt1){
											rlt1.printStackTrace();
											System.out.println("Problem 2");
										}
									}
								*/}else{
									//Code For Price Per Tone If Line Number Is 0
									try{
										String sqlp="SELECT [PricePerTon] AS price FROM [tblwastepaperdetailreport] where [MasterPO]=? AND [ReleaseNo]=? AND [GradeId]=? ";
										List<Map<String, Object>> priceton=new ArrayList<Map<String,Object>>();
										priceton=jdbcTemplate1.queryForList(sqlp, new Object[]{
												masterpo,	
												releaseNo,
												gradeCode
										});
										if(priceton.size()>0){
											for(Map<String, Object> Ton: priceton){
												double ODBprice=(Double)Ton.get("price")==null?0:(Double)(Ton.get("price"));
												//System.out.println("ODBprice::"+ODBprice);
												wastepaperDetail.setPricePerTon(ODBprice);
											}
										}
									}catch(Exception rlt){
										rlt.printStackTrace();
										System.out.println("Roshan Say's, You Have A Problem In tblwastepaperdetailreport Table.");
									}
									
								}
								
							}catch(Exception rlt){
								System.out.println("You have a problem in try block ,when finding Line Number");
								rlt.printStackTrace();
							}
						}
						else{
								String _noPriceperTone="****";
								double _value = Double.parseDouble(_noPriceperTone);
								wastepaperDetail.setPricePerTon(_value);
							}
						//Code For $ Freight CHBK/Deduction Starts From Here Done By Roshan Tailor
						
						double chbk;
						double finalchbk;
						//Code Starts From Here For FreightInvoiceNo,FreightInvoiced,DetentionCharges. Done By Roshan Tailor Date:- 06/10/2015 Night Shift
						
						try{
							String wastePapersql="Select * from [tblwastepaperdetailreport] where ([ReleaseNo])=? AND ([GradeId])=?";
							List<Map<String, Object>> map6=jdbcTemplate1.queryForList(wastePapersql,new Object[]{
									releaseNo,
									gradeCode
							});
							if(map6.size()>0){
								Map<String, Object> maps6=map6.get(0);
								
								String freightInvoiceNo=(String)maps6.get("FreightInvoiceNo".toUpperCase());
								double freightInvoiced=(double)maps6.get("FreightInvoiced".toUpperCase());
								double detentionCharges=(double)maps6.get("DetentionCharges".toUpperCase());
								Double deduction=(double)maps6.get("Deduction".toUpperCase());
								destination=(String)maps6.get("Destination".toUpperCase());

								double defaultDeduction=0.0;
								wastepaperDetail.setFreightInvoiceNo(freightInvoiceNo);
								wastepaperDetail.setFreightInvoiced(freightInvoiced);
								wastepaperDetail.setDetentionCharges(detentionCharges);
								wastepaperDetail.setDeduction(deduction);
								
								
								if(deduction==null){
								wastepaperDetail.setDeduction(defaultDeduction);	
								}
								if(CommonUtil.round(baleWeight, 2)>=StandardWeightTon)
								{
									double rightTons=0.0;
									wastepaperDetail.setFreightCHBK(rightTons);
								}else{
									//dofkdofk
									//Code Starts From Here For Freight Charge Back, if multiple grades found for a single release
									double FinalTWeight=0;
									List<Map<String, Object>> multipleRelease_freight=null;
									//Round(sum(BaleWeight)/2000,2) as [WeightT]
									//sum(BaleWeight)/2000 as [WeightT]
									try{

										String multipleRelease="SELECT  Round(sum(BaleWeight)/2000,2) as [WeightT],[GradeCode] FROM [tblBaleInventory] where [ReleaseNumber] =? group by [GradeCode]";
										multipleRelease_freight=jdbcTemplate.queryForList(multipleRelease,new Object[]{releaseNo});
										if(multipleRelease_freight.size()>0){
											for (Map<String, Object> mul_re_fre : multipleRelease_freight) {
												//double WeightT=(Double)mul_re_fre.get("WeightT")==null?0:(Double)(mul_re_fre.get("WeightT"));
												
												BigDecimal d8 = BigDecimal.ZERO;
												d8= (BigDecimal) (mul_re_fre.get("WeightT")==null?0:(BigDecimal)(mul_re_fre.get("WeightT")));
												double WeightT = d8.doubleValue(); 
												
												FinalTWeight = FinalTWeight + WeightT;
											}
											
										}
									}catch(Exception rlt){
										rlt.printStackTrace();
									}
									//Code Ends Here Here For Freight Charge Back, if multiple grades found for a single release
									
									chbk=(StandardWeightTon-(CommonUtil.round(FinalTWeight, 2)))/StandardWeightTon;
									finalchbk=chbk*freightInvoiced;
									
									if(freightInvoiced==0 ){
										String _text = "Pending"; 
										wastepaperDetail.setFreightCHBKPending(_text);
										
										/*Code For Pending Status 
										 *If A Release Comes In Two Grades And Its Total Weight Greater Then 20 
										 *Then Status Will Be 0 Rather Then Pending
										 *Code Starts From Here Done By Roshan Tailor
										 */
										double WeightTotal=0;
										try{
											String sql="SELECT Round(sum(BaleWeight)/2000,2) as [WeightT]  FROM [tblBaleInventory] where  [ReleaseNumber] =?";
											List<Map<String, Object>>totalBaleWeight=jdbcTemplate.queryForList(sql, new Object[]{releaseNo});
											for(Map<String , Object> totalBaleWeight1: totalBaleWeight){
												//WeightTotal=(Double)totalBaleWeight1.get("WeightT")==null?0:(Double)(totalBaleWeight1.get("WeightT"));
												
												BigDecimal d9 = BigDecimal.ZERO;
												d9= (BigDecimal) (totalBaleWeight1.get("WeightT")==null?0:(BigDecimal)(totalBaleWeight1.get("WeightT")));
												WeightTotal = d9.doubleValue(); 
												
												WeightTotal=CommonUtil.round(WeightTotal, 2);
												}
										}catch(Exception rlt){
											System.out.println("Error In Panding Status");
											rlt.printStackTrace();
										}
										if(CommonUtil.round(WeightTotal, 2)<20){
											double rightTons=0.0;
											wastepaperDetail.setFreightCHBK(rightTons);
										}else{
											String _text1 = "Not Pending"; 
											wastepaperDetail.setFreightCHBKPending(_text1);
										}
										
									}else{
										if(releaseNo==16232){
											wastepaperDetail.setFreightCHBK(0);//Done Hard Core Said By Customer
										}else{
											wastepaperDetail.setFreightCHBK(finalchbk);
										}
									}
								}
							}else{
								double FreightInvoiced=wastepaperDetail.getFreightInvoiced();
								/*Code For Pending Status 
								 *If A Release Comes In Two Grades And Its Total Weight Greater Then 20 
								 *Then Status Will Be 0 Rather Then Pending
								 *Code Starts From Here Done By Roshan Tailor
								 */
								double WeightTotal=0;
								try{
									String sql="SELECT Round(sum(BaleWeight)/2000,2) as [WeightT]  FROM [tblBaleInventory] where  [ReleaseNumber] =?";
									List<Map<String, Object>>totalBaleWeight=jdbcTemplate.queryForList(sql, new Object[]{releaseNo});
									for(Map<String , Object> totalBaleWeight1: totalBaleWeight){
										//WeightTotal=(Double)totalBaleWeight1.get("WeightT")==null?0:(Double)(totalBaleWeight1.get("WeightT"));
										
										BigDecimal d4 = BigDecimal.ZERO;
										d4= (BigDecimal) (totalBaleWeight1.get("WeightT")==null?0:(BigDecimal)(totalBaleWeight1.get("WeightT")));
										WeightTotal=d4.doubleValue();
										
										WeightTotal=CommonUtil.round(WeightTotal, 2);
										}
								}catch(Exception rlt){
									System.out.println("Error In Panding Status");
									rlt.printStackTrace();
								}
								
								if(FreightInvoiced==0 && CommonUtil.round(WeightTotal, 2)<20){
									String _text = "Pending"; 
									wastepaperDetail.setFreightCHBKPending(_text);
									
								}else{
									double rightTons=0.0;
									wastepaperDetail.setFreightCHBK(rightTons);
								}
							}
						}catch(Exception rlt){
							System.out.println("Roshan Say's,You Have Problem In WastePaperDaoImp.java");
							rlt.printStackTrace();
						}
						 
						/*double _priceperTon=wastepaperDetail.getPricePerTon();
						double _extention=baleWeight*_priceperTon;
						double FreightInvoiced=wastepaperDetail.getFreightInvoiced();
						double DetentionCharges=wastepaperDetail.getDetentionCharges();
						double FreightCHBK=wastepaperDetail.getFreightCHBK();
						double _grantTotal=0;
						double _deduction=wastepaperDetail.getDeduction();*/
						
						/*_grantTotal=(_extention)+(FreightInvoiced)+(DetentionCharges)+((-FreightCHBK));//Freight CBHK Should Be In Negative 
						
						double _totalAfterDeduction=(_grantTotal)-(_deduction);
						
						wastepaperDetail.setGrandTotal(_totalAfterDeduction);
						wastepaperDetail.setExtention(_extention);*/
						
					}catch(Exception rlt1){
						System.out.println("Problem 1");
						rlt1.printStackTrace();
					}
				}
				
			} catch (Exception e) {
				System.out.println("MasterPO not found: "+e.getMessage());
			}
			String master_po=(String)map.get("MasterPO".toUpperCase());
//			Code Ends Here Done By Roshan Tailor Date :- 06/04/2015 MM/DD/YYY Night Shift
			wastepaperDetail.setBales(bale);
			wastepaperDetail.setReleaseNo(releaseNo);
			wastepaperDetail.setNetTons(CommonUtil.round(baleWeight, 2));


			try {
				String sqlPurchase="select [MasterPO],[Vendor],[Trailer],[CarrierID],[PickUpCity],[PickUpState],[WeightDate],[AcceptDate],[UnloadDate] from [tblPurchaseHeader] where [ReleaseNumber]=? ";
				List<Map<String, Object>> maps2=jdbcTemplate.queryForList(sqlPurchase,new Object[]{releaseNo});
				
				if(maps2.size()>0 ){
					Map<String, Object> map2=maps2.get(0);
					
					String masterPo=(String) map2.get("MasterPO".toUpperCase());
					String vendor=(String) map2.get("Vendor".toUpperCase());
						String pickUpCity=(String) map2.get("PickUpCity".toUpperCase());
					String pickUpState=(String) map2.get("PickUpState".toUpperCase());
					Date dropDate=(Date)map2.get("AcceptDate".toUpperCase());
					Date UnloadDate=(Date)map2.get("UnloadDate".toUpperCase());//
					String trailer=(String) map2.get("trailer".toUpperCase());
					String carrierID=(String)map2.get("CarrierID".toUpperCase());
					
					String _checkCarrier;
					try {
						String sqlCarrer="select [CarrierName] from [tlkpCarrier] where [CarrierCode]=?";
						String carrier=jdbcTemplate.queryForObject(sqlCarrer, new Object[]{carrierID}, String.class);
			
						wastepaperDetail.setCarrier(carrier);
						_checkCarrier=wastepaperDetail.getCarrier();
						if(_checkCarrier.equalsIgnoreCase("Dlvd Price")){
							wastepaperDetail.setDestination("Delivered");
						}else{
							wastepaperDetail.setDestination(destination);
						}
						//This Condition Is Applied, Discussion With Accounts Department,This Condition Will Overwrite Setter Method 
						if((_checkCarrier.equalsIgnoreCase("Dlvd Price"))){
							
								int retval = Double.compare(StandardWeightTon, CommonUtil.round(baleWeight, 2));
							
								if(retval > 0){
									String fcbForDlvdPrice1="0";
									double fcbForDlvdPrice2=0.0;
									wastepaperDetail.setFreightCHBKPending(fcbForDlvdPrice1);
									wastepaperDetail.setFreightCHBK(fcbForDlvdPrice2);
							}else{
								
							}
							
						}else{
							//System.out.println("Condition False");
							}
						//Condition Ends Here
						
						//From Here We Will Check The Size Of List Which Is Coming From DataBase And Will Divide it By Estimated Freight
					
						 double baleWeightTemp=0;
						 double baleWeightTotal=0;
						 //Round(sum(BaleWeight)/2000,2) as [BaleWeightT]
						 //sum(BaleWeight)/2000 as [BaleWeightT]
						 try{
							String sql_size="SELECT [ReleaseNumber],[UnloadDate], Round(sum(BaleWeight)/2000,2) as [BaleWeightT],[GradeCode],count(*) as [Bales] "
									+ "FROM [tblBaleInventory] where  [ReleaseNumber] =? AND [gradeCode]=? group by [ReleaseNumber],[UnloadDate],[GradeCode]";
							List<Map<String, Object>> list=jdbcTemplate.queryForList(sql_size, new Object[]{
									releaseNo,gradeCode
							});
							if(list.size()>0){
								
							/*TempReleaseData relData=fetchDataRelData(datas,list,releaseNo);	*/
								
								
								
								int j=1;
								for( Map<String , Object>  list1: list){
									 //baleWeightTemp=(Double)list1.get("BaleWeightT")==null?0:(Double)(list1.get("BaleWeightT"));
									
									BigDecimal d5 = BigDecimal.ZERO;
									d5= (BigDecimal) (list1.get("BaleWeightT")==null?0:(BigDecimal)(list1.get("BaleWeightT")));
									baleWeightTemp = d5.doubleValue(); 
									
									baleWeightTemp=CommonUtil.round(baleWeightTemp, 2);
									/*roshan*/
									try{
										//Round(sum(BaleWeight)/2000,2) as [WeightT]
										//sum(BaleWeight)/2000 as [WeightT]
										String sql_Total_BaleW="SELECT Round(sum(BaleWeight)/2000,2) as [WeightT]  FROM [tblBaleInventory] where  [ReleaseNumber] =?";
										List<Map<String, Object>>totalBaleWeight=jdbcTemplate.queryForList(sql_Total_BaleW, new Object[]{
												releaseNo
										});
										for(Map<String , Object> totalBaleWeight1: totalBaleWeight){
											
											//baleWeightTotal=(Double)totalBaleWeight1.get("WeightT")==null?0:(Double)(totalBaleWeight1.get("WeightT"));
											
											BigDecimal d6 = BigDecimal.ZERO;
											d6= (BigDecimal) (totalBaleWeight1.get("WeightT")==null?0:(BigDecimal)(totalBaleWeight1.get("WeightT")));
											baleWeightTotal = d6.doubleValue(); 
											
											baleWeightTotal=CommonUtil.round(baleWeightTotal, 2);
											//System.out.println("baleWeightTemp::"+baleWeightTemp);
											//System.out.println("baleWeightTotal::"+baleWeightTotal);
											
											//
											try{

												String sql_estimatedfreight="select [ID] AS ID,[EstimateFreightPrice] AS EstimateFreightPrice "
														+ "from [tblwastepaperdetailEstimateFreight] where "
														+ "[Carrier]=? AND [ShippingCity]=? AND [ShippingState]=?";
												List<Map<String, Object>> esti_frieght=jdbcTemplate1.queryForList(sql_estimatedfreight, new Object[]{
														carrier,
														pickUpCity,
														pickUpState
												});
												for(Map<String , Object> freightvalue: esti_frieght){
													int _id=(int)freightvalue.get("ID");
													double _estimatedfreight=CommonUtil.round((Double)freightvalue.get("EstimateFreightPrice"),2);
													wastepaperDetail.setId(_id);
													wastepaperDetail.setEstimatedFreight((_estimatedfreight/baleWeightTotal)*baleWeightTemp);
												}
												/*if(releaseNo==12059){
													System.out.println("Roshan 1::"+CommonUtil.round((CommonUtil.round(_estimatedfreight, 2)/baleWeightTotal)*baleWeightTemp, 2));
													System.out.println("Roshan 2::"+_estimatedfreight/baleWeightTotal*baleWeightTemp);
													System.out.println("Roshan 3::"+CommonUtil.round(_estimatedfreight, 2)/baleWeightTotal*baleWeightTemp);
													System.out.println("Roshan 4::"+_estimatedfreight/CommonUtil.round(baleWeightTotal, 2)*baleWeightTemp);
													System.out.println("Roshan 5::"+_estimatedfreight/baleWeightTotal*CommonUtil.round(baleWeightTemp, 2));
													
													System.out.println("*********************************************");
													System.out.println("_estimatedfreight:"+_estimatedfreight);
													System.out.println("baleWeightTotal:"+CommonUtil.round(baleWeightTotal, 2));
													System.out.println("baleWeightTemp:"+CommonUtil.round(baleWeightTemp, 2));
													System.out.println("*********************************************");
														
													
												}else{
													
												}*/
												
											}catch(Exception rlt){
												System.out.println("You Have An Problem In Query For Estimated Freight.");
												rlt.printStackTrace();
											}
											//
											
										}
									}catch(Exception rlt){
										rlt.printStackTrace();
									}
									j++;
								}
							}else{
								/*try{

									String sql_estimatedfreight="select [ID] AS ID,[EstimateFreightPrice] AS EstimateFreightPrice "
											+ "from [tblwastepaperdetailEstimateFreight] where "
											+ "[Carrier]=? AND [ShippingCity]=? AND [ShippingState]=?";
									List<Map<String, Object>> esti_frieght=jdbcTemplate1.queryForList(sql_estimatedfreight, new Object[]{
											carrier,
											pickUpCity,
											pickUpState
									});
									for(Map<String , Object> freightvalue: esti_frieght){
										int _id=(int)freightvalue.get("ID");
										double _estimatedfreight=(Double)freightvalue.get("EstimateFreightPrice");
										
										wastepaperDetail.setId(_id);
										wastepaperDetail.setEstimatedFreight(_estimatedfreight);
									}
									
								}catch(Exception rlt){
									System.out.println("You Have An Problem In Query For Estimated Freight.");
									rlt.printStackTrace();
								}*/
							}
						
						}catch(Exception rlt){
							System.out.println("Roshan Says, You Have An Error in WastePaperDoaImp.java When Finding The Size Of List");
							rlt.printStackTrace();
						}
						//List Code Ends Here
						/*try{

							String sql_estimatedfreight="select [ID] AS ID,[EstimateFreightPrice] AS EstimateFreightPrice "
									+ "from [tblwastepaperdetailEstimateFreight] where "
									+ "[Carrier]=? AND [ShippingCity]=? AND [ShippingState]=?";
							List<Map<String, Object>> esti_frieght=jdbcTemplate1.queryForList(sql_estimatedfreight, new Object[]{
									carrier,
									pickUpCity,
									pickUpState
							});
							for(Map<String , Object> freightvalue: esti_frieght){
								int _id=(int)freightvalue.get("ID");
								double _estimatedfreight=(Double)freightvalue.get("EstimateFreightPrice");
								
								wastepaperDetail.setId(_id);
								if(list.size()>=2){
									System.out.println("baleWeightTotal::"+baleWeightTotal);
									System.out.println("baleWeightTemp::"+baleWeightTemp);
									System.out.println("_estimatedfreight::"+_estimatedfreight);
									wastepaperDetail.setEstimatedFreight((_estimatedfreight/baleWeightTotal)*baleWeightTemp);
									System.out.println("Freight::"+(_estimatedfreight/baleWeightTotal)*baleWeightTemp);
								}else{
									wastepaperDetail.setEstimatedFreight(_estimatedfreight);
								}
								
							}
							
						}catch(Exception rlt){
							System.out.println("You Have An Problem In Query For Estimated Freight.");
							rlt.printStackTrace();
						}*/
						
					} catch (Exception e) {
						System.out.println("Carrier code not found="+e.getMessage());
					}
					
					//Code Starts From Here Done By Roshan Tailor Date :-06/03/2015
					wastepaperDetail.setMasterPO(masterPo);
					//Code Ends Here Done By Roshan Tailor Date :- 06/03/2015
					wastepaperDetail.setVandorName(vendor);
					wastepaperDetail.setTrailerNo(trailer);
					wastepaperDetail.setShippingCity(pickUpCity);
					wastepaperDetail.setShippingState(pickUpState);
					wastepaperDetail.setDroppedDate(dropDate);
					
					wastepaperDetail.setUnloadedDate(UnloadDate);
					
					//If Freight Invoiced Number Is Null Or Equals To Zero
					//Then Grant Total = Estimated Freight + Extension
					//Apply Condition Below Having If Else Condition
												
					double _priceperTon=wastepaperDetail.getPricePerTon();
					double _extention=CommonUtil.round(baleWeight, 2)*_priceperTon;
					double FreightInvoiced=wastepaperDetail.getFreightInvoiced();
					double DetentionCharges=wastepaperDetail.getDetentionCharges();
					//Apply The Condition Here For Multiple Grade Release Which Have Weight >=20(In Different-2 Grade But Total Is >=20)
					//In This Condition Freight Charge Back Will Be 0.
					//Code Starts From Here
					double TW_release=0;
					try{
						//Round(sum(BaleWeight)/2000,2) as [BaleWeightT]
						//sum(BaleWeight)/2000 as [BaleWeightT]
						//double baleWeight=(Double)map.get("BaleWeightT")==null?0:(Double)(map.get("BaleWeightT"));
						String sql_releaseTW="SELECT Round(sum(BaleWeight)/2000,2) as [BaleWeightT] FROM [tblBaleInventory] where [ReleaseNumber]=? GROUP BY [ReleaseNumber]";
						List<Map<String, Object>> releaseTW=jdbcTemplate.queryForList(sql_releaseTW, new Object[]{releaseNo});
						for(Map<String , Object> TW: releaseTW){
							
							//TW_release=CommonUtil.round((Double)TW.get("BaleWeightT"),2);
							
							BigDecimal d7 = BigDecimal.ZERO;
							d7= (BigDecimal) (TW.get("BaleWeightT")==null?0:(BigDecimal)(TW.get("BaleWeightT")));
							TW_release = d7.doubleValue(); 
							
						}
					}catch(Exception rlt){
						System.out.println("Roshan Says,Apply The Condition Here For Multiple Grade Release Which Have Weight >=20(In Different-2 Grade But Total Is >=20)");
						rlt.printStackTrace();
					}
					//Code Ends Here
					double FreightCHBK=0;
					if(TW_release>=20){
						double setFCBZero=0;
						wastepaperDetail.setFreightCHBK(setFCBZero);
						FreightCHBK=wastepaperDetail.getFreightCHBK();
						
					}else{
						FreightCHBK=wastepaperDetail.getFreightCHBK();
					}
					
					double _grantTotal=0;
					double _deduction=wastepaperDetail.getDeduction();
					
					String _checkFreightInvoicedNumber=wastepaperDetail.getFreightInvoiceNo();
					if(_checkFreightInvoicedNumber==null ||_checkFreightInvoicedNumber=="" || _checkFreightInvoicedNumber.equalsIgnoreCase("0")||_checkFreightInvoicedNumber.equalsIgnoreCase("")){
						_grantTotal=wastepaperDetail.getEstimatedFreight()+_extention;
						double _totalAfterDeduction=(_grantTotal)-(_deduction);
						
						wastepaperDetail.setGrandTotal(_totalAfterDeduction);
						wastepaperDetail.setExtention(_extention);
					}else{
						_grantTotal=(_extention)+(FreightInvoiced)+(DetentionCharges)+((-FreightCHBK));//Freight CBHK Should Be In Negative 
						double _totalAfterDeduction=(_grantTotal)-(_deduction);
						
						wastepaperDetail.setGrandTotal(_totalAfterDeduction);
						wastepaperDetail.setExtention(_extention);
					}
					
					
				}
				
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Error in master detail.");
			}
			details.add(wastepaperDetail);
		}
		return details;
	}
	/* (non-Javadoc)
	 * @see com.st.wastepaper.dao.WastePaperUnloadBaleDao#getRejectBales(int)
	 */
	@Override
	public List<WastepaperDetail> getRejectBales(int releaseNumber) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSourceP);
		
		List<WastepaperDetail> details=new ArrayList<WastepaperDetail>();
		
		String sqlBale="select [BaleCount],[BOLWeight] from [tblpurchaseDetail] where [BaleQuality]='99' AND [ReleaseNumber]=? group by [BaleCount],[BOLWeight];";
		
		List<Map<String, Object>> maps=jdbcTemplate.queryForList(sqlBale, new Object[]{releaseNumber});
		
		if(maps.size()>0){
			final WastepaperDetail wastepaperDetail=new WastepaperDetail();
			//double RejectBOLWeight=0;
			BigDecimal RejectBOLWeight = BigDecimal.ZERO;
			BigDecimal RejectBaleCountDecimal;
			
			double _totalBaleWeight=0;
			int RejectBaleCount=0;
			for (Map<String, Object> map : maps) {
				//RejectBOLWeight=(Double)map.get("BOLWeight")==null?0:(Double)map.get("BOLWeight");
				//RejectBaleCount=(Integer)map.get("BaleCount".toUpperCase());
				
				
				RejectBOLWeight= (BigDecimal) (map.get("BOLWeight")==null?0:(BigDecimal)(map.get("BOLWeight")));
				_totalBaleWeight = RejectBOLWeight.doubleValue(); 
				
				
				RejectBaleCountDecimal=(BigDecimal)map.get("BaleCount".toUpperCase());
				RejectBaleCount=RejectBaleCountDecimal.intValueExact();
				
			}
			wastepaperDetail.setRejectbolweight(_totalBaleWeight);
			wastepaperDetail.setRejectbalecount(RejectBaleCount);
			details.add(wastepaperDetail);
		}
		return details;
	}
	
	
	/* (non-Javadoc)
	 * @see com.st.wastepaper.dao.WastePaperUnloadBaleDao#getDailyInventeryReport(java.lang.String, java.util.Date)
	 */
	@Override
	public Map<String, String> getDailyInventeryReport(String custname, Date sdate,Date edate) {
		
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSourceP);
		Map<String, String> map=new TreeMap<String, String>();		
		
		float totalShiped=0,totalflorTon=0,inventory=0;
	if(custname.equals("inDirect")) {			
		String sql="SELECT gradecode FROM tblWrapperProduction  where dateentered <=? and customer like '%trebor%' order BY  gradecode";
		List<String> list = jdbcTemplate.queryForList(sql, new Object[] {edate},String.class);
		    Set<String> gd=new TreeSet<String>();
		    Set<String> gdset=new TreeSet<String>();
			for(String s:list)
		    {
				if(s.isEmpty())
				{
					
				}
				else
				gd.add(s.trim());
		    }
			Iterator<String> it = gd.iterator();
			while(it.hasNext())
			{
				String gradeCode=it.next();
				System.out.println("gradeCode =" +gradeCode);
				String[] g=gradeCode.split("-");
				String gc=g[0];
				gdset.add(gc);
			}
			Iterator<String> its = gdset.iterator();
			while(its.hasNext())
			{
				String gc=its.next().trim();
				System.out.println("gc =" +gc);
				
				String	florTon="SELECT  sum(WhiteWeight/2000)"  
							+"  FROM tblWrapperProduction  where dateentered <=? and customer like '%trebor%' and gradecode like '"+gc+"%'";
					try {
						totalflorTon=jdbcTemplate.queryForObject(florTon,new Object[] {edate},Float.class);
					} catch (Exception e) {
						System.out.println("florTon"+e);
					}
					String Shiped="SELECT sum(WhiteWeight/2000)"
							+"  FROM tblWrapperProduction where dateentered <= ? and customer  like '%trebor%' and DateShipped is not null and gradecode like  '"+gc+"%'";
					try {
						totalShiped=jdbcTemplate.queryForObject(Shiped,new Object[] {edate},Float.class);
					} catch (Exception e) {
						System.out.println("totalShiped"+e);
					}			
					
					inventory=totalflorTon-totalShiped; 
					totalShiped=Math.round(totalShiped);
					inventory=Math.round(inventory);
					System.out.println("GradeCode = "+gc);
					//System.out.println("totalOrder = "+totalOrder);	
					System.out.println("totalflorTon = "+totalflorTon);	
					System.out.println("totalShiped = "+totalShiped);
					System.out.println("inventory = "+inventory);
					String s=totalShiped+"-"+inventory;
					map.put(gc, s);
			}
	}
	else if(custname.equals("direct")) {				
			
		String sql="SELECT gradecode FROM tblWrapperProduction  where dateentered <=? and customer not like '%trebor%' order BY  gradecode";
		List<String> list = jdbcTemplate.queryForList(sql, new Object[] {edate},String.class);
		    Set<String> gd=new TreeSet<String>();
		    Set<String> gdset=new TreeSet<String>();
			for(String s:list)
		    {
				if(s.isEmpty())
				{
					
				}
				else
				gd.add(s.trim());
		    }
			Iterator<String> it = gd.iterator();
			while(it.hasNext())
			{
				String gradeCode=it.next();
				System.out.println("gradeCode =" +gradeCode);
				String[] g=gradeCode.split("-");
				String gc=g[0];
				gdset.add(gc);
			}
			Iterator<String> its = gdset.iterator();
			while(its.hasNext())
			{
				String gc=its.next().trim();
				System.out.println("gc =" +gc);
				
				String	florTon="SELECT  sum(WhiteWeight/2000)"  
							+"  FROM tblWrapperProduction  where dateentered <=? and customer not like '%trebor%' and gradecode like '"+gc+"%'";
					try {
						totalflorTon=jdbcTemplate.queryForObject(florTon,new Object[] {edate},Float.class);
					} catch (Exception e) {
						System.out.println("florTon"+e);
					}
					String Shiped="SELECT sum(WhiteWeight/2000)"
							+"  FROM tblWrapperProduction where dateentered <= ? and customer not like '%trebor%' and DateShipped is not null and gradecode like  '"+gc+"%'";
					try {
						totalShiped=jdbcTemplate.queryForObject(Shiped,new Object[] {edate},Float.class);
					} catch (Exception e) {
						System.out.println("totalShiped"+e);
					}			
					
					inventory=totalflorTon-totalShiped; 
					/*totalShiped=Math.round(totalShiped);
					inventory=Math.round(inventory);*/
					System.out.println("GradeCode = "+gc);
					//System.out.println("totalOrder = "+totalOrder);	
					System.out.println("totalflorTon = "+totalflorTon);	
					System.out.println("totalShiped = "+totalShiped);
					System.out.println("inventory = "+inventory);
					String s=totalShiped+"-"+inventory;
					map.put(gc, s);
					totalShiped=0;
					totalflorTon=0;
					inventory=0;
		    }
		}
	
		return map;
	}
	
}

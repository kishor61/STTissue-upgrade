/**
 *Jul 18, 2015
 *WastePaperConsumedBaleDaoImp.java
 * TODO
 *com.st.wastepaperconsumedbale.dao
 *WastePaperConsumedBaleDaoImp.java
 *Sunil Singh Bora
 */
package com.st.wastepaper.dao;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

//import org.hsqldb.jdbcDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

//import com.st.chemicalinventory.model.Chemical;
import com.st.common.CommonUtil;
import com.st.wastepaper.mapper.OpeningClosingMapper;
import com.st.wastepaper.model.BarcodeComman;
import com.st.wastepaper.model.WastePaperBaleInventory;

import productspecificationsignoffsheet.ProductSpecificationSignOffSheet;

/**
 * @author roshan
 *
 */
@Repository
public class WastePaperConsumedBaleDaoImp implements WastePaperConsumedBaleDao {

	@Autowired
	private DataSource dataSource;
	@Autowired
	@Qualifier("dataSourceProduction")
	private DataSource dataSourceP;	
	
	
	/* (non-Javadoc)
	 * @see com.st.wastepaperconsumedbale.dao.WastePaperConsumedBaleDao#getConsumedData(java.util.Date, java.util.Date)
	 */
	@Override
	public List<WastePaperBaleInventory> getConsumedData(Date startdate,Date enddate) throws Exception {
		// TODO Auto-generated method stub
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		SimpleDateFormat dateFormatTesting = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss");
		
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSourceP);
		JdbcTemplate jdbcTemplate1=new JdbcTemplate(dataSource);
		
		List<WastePaperBaleInventory> consumedDetails= new ArrayList<WastePaperBaleInventory>();
		
		int days=CommonUtil.getDaysDiffernce(startdate, enddate);
		
		Calendar calendar=Calendar.getInstance();
		calendar.setTime(startdate);
		System.out.println("Fetching BARCODE CONSUMED BALES - GRADEWISE <START>");
		for (int i = 0; i <=days; i++) {
			Date dateS=calendar.getTime();
			
			
			Calendar scal=Calendar.getInstance();
			scal.setTime(dateS);
			scal.set(Calendar.HOUR_OF_DAY, 7);
			scal.set(Calendar.MINUTE, 0);
			scal.set(Calendar.SECOND, 0);
			scal.set(Calendar.MILLISECOND, 0);
	
			
			Calendar ecal=Calendar.getInstance();
			ecal.setTime(dateS);
			ecal.set(Calendar.HOUR_OF_DAY, 6);
			ecal.set(Calendar.MINUTE, 59);
			ecal.set(Calendar.SECOND, 59);
			ecal.set(Calendar.MILLISECOND, 0);
			ecal.add(Calendar.DATE, 1);
			
			/*System.out.println("Start Date::"+dateFormatTesting.format(scal.getTime().getTime()));
			System.out.println("End Date::"+dateFormatTesting.format(ecal.getTime().getTime()));*/
			
			final WastePaperBaleInventory wastePaperBaleInventory=new WastePaperBaleInventory();
			wastePaperBaleInventory.setDate(dateS);
			
			int _totalConsumedBalesCount=0;
			double _totalConsumedBaleWeightCount=0.0;
			
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

			double TotalbalesweightForBoxboardClippings=0;
			int TotalbalesOfBoxboardClippings=0;

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
			
			double totalbalesweightForHardWhite=0;
			int totalbalesOfHardWhite=0;
			double totalbalesweightForVirginequalypuHW=0;
			int totalbalesOfVirginequalypuHW=0;
			
			try{       
				
				/*String sqlforConsumedBale="SELECT [ConsumedDate], sum(BaleWeight)/2000 as BALEWT,[GradeCode],count(*) as COUNTBALE"
						+ " FROM [tblBaleInventory] where ([ConsumedDate] between ? and ? ) AND [GradeCode]=? group by [ConsumedDate],[GradeCode]";*/
				
				String sqlforConsumedBale="SELECT [ConsumedDate], sum(BaleWeight)/2000 as BALEWT,[GradeCode],count(*) as COUNTBALE FROM [tblBaleInventory] "
						+ "where ([ActualConsumedDateTime] between ? and ? ) AND [GradeCode] in (select GradeCode from tlkpGrade)group by [ConsumedDate],[GradeCode]";
			
				List<Map<String, Object>> mapList=new ArrayList<Map<String,Object>>();
					try {
						mapList=jdbcTemplate.queryForList(sqlforConsumedBale,new Object[]{
								new Timestamp(scal.getTime().getTime()),
								new Timestamp(ecal.getTime().getTime())
						});
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
					if(mapList.size()>0){
						for(Map<String, Object> map1:mapList){
							//double _totalConsumedBaleWeight=map1.get("BALEWT")==null?0:(Double)map1.get("BALEWT");
							
							BigDecimal d = BigDecimal.ZERO;
							d= (BigDecimal) (map1.get("BALEWT")==null?0:(BigDecimal)(map1.get("BALEWT")));
							double _totalConsumedBaleWeight = d.doubleValue(); 
							
							int _totalConsumedBales=map1.get("COUNTBALE")==null?0:(Integer)map1.get("COUNTBALE");
							/*BigDecimal d2 = BigDecimal.ZERO;
							d2= (BigDecimal) (map1.get("COUNTBALE")==null?0:(BigDecimal)(map1.get("COUNTBALE")));
							int _totalConsumedBales = d2.intValueExact(); */
							
							
							//int _gradeCode=(Integer)map1.get("GradeCode");
							BigDecimal d1 = BigDecimal.ZERO;
							d1= (BigDecimal) (map1.get("GradeCode")==null?0:(BigDecimal)(map1.get("GradeCode")));
							int _gradeCode=d1.intValueExact();
							
							
							Date _unloaddate=(Date)map1.get("UnloadDate");
							
							_totalConsumedBalesCount = _totalConsumedBalesCount + _totalConsumedBales;
							wastePaperBaleInventory.setTotalbales(_totalConsumedBalesCount);
							
							_totalConsumedBaleWeightCount=_totalConsumedBaleWeightCount+_totalConsumedBaleWeight;
							wastePaperBaleInventory.setTotalbalesweight(_totalConsumedBaleWeightCount);
							
							if(_gradeCode==1){
								
								TotalbalesOfMWL = TotalbalesOfMWL + _totalConsumedBales;
								TotalbalesweightForMWL=TotalbalesweightForMWL+_totalConsumedBaleWeight;
								
								wastePaperBaleInventory.setTotalbalesweightForMWL(TotalbalesweightForMWL);
								wastePaperBaleInventory.setTotalbalesOfMWL(TotalbalesOfMWL);
							}
							if(_gradeCode==2){
								totalbalesOfHardWhite = totalbalesOfHardWhite + _totalConsumedBales;
								totalbalesweightForHardWhite=totalbalesweightForHardWhite+_totalConsumedBaleWeight;
								
								
								wastePaperBaleInventory.setTotalbalesweightForHardWhite(totalbalesweightForHardWhite);
								wastePaperBaleInventory.setTotalbalesOfHardWhite(totalbalesOfHardWhite);
							}
							if(_gradeCode==3){
								
								TotalbalesOfMCL = TotalbalesOfMCL + _totalConsumedBales;
								TotalbalesweightForMCL=TotalbalesweightForMCL+_totalConsumedBaleWeight;
								
								
								 wastePaperBaleInventory.setTotalbalesweightForMCL(TotalbalesweightForMCL);
								 wastePaperBaleInventory.setTotalbalesOfMCL(TotalbalesOfMCL);
							}
							if(_gradeCode==4){
								
								TotalbalesOfMWLWorIGS = TotalbalesOfMWLWorIGS + _totalConsumedBales;
								TotalbalesweightForMWLWorIGS=TotalbalesweightForMWLWorIGS+_totalConsumedBaleWeight;
								
								
								wastePaperBaleInventory.setTotalbalesweightForMWLWorIGS(TotalbalesweightForMWLWorIGS);
								wastePaperBaleInventory.setTotalbalesOfMWLWorIGS(TotalbalesOfMWLWorIGS);
							}
							if(_gradeCode==5){
								
								TotalbalesOfCBS = TotalbalesOfCBS + _totalConsumedBales;
								TotalbalesweightForCBS=TotalbalesweightForCBS+_totalConsumedBaleWeight;
								
								
								wastePaperBaleInventory.setTotalbalesweightForCBS(TotalbalesweightForCBS);
								wastePaperBaleInventory.setTotalbalesOfCBS(TotalbalesOfCBS);
							}
							if(_gradeCode==6){
								
								TotalbalesOfCtdGdwd = TotalbalesOfCtdGdwd + _totalConsumedBales;
								TotalbalesweightForCtdGdwd=TotalbalesweightForCtdGdwd+_totalConsumedBaleWeight;
								
								
								wastePaperBaleInventory.setTotalbalesweightForCtdGdwd(TotalbalesweightForCtdGdwd);
								wastePaperBaleInventory.setTotalbalesOfCtdGdwd(TotalbalesOfCtdGdwd);
							}
							if(_gradeCode==7){
								
								TotalbalesOfSWL = TotalbalesOfSWL + _totalConsumedBales;
								TotalbalesweightForSWL=TotalbalesweightForSWL+_totalConsumedBaleWeight;
								
								
								wastePaperBaleInventory.setTotalbalesweightForSWL(TotalbalesweightForSWL);
								wastePaperBaleInventory.setTotalbalesOfSWL(TotalbalesOfSWL);
							}
							if(_gradeCode==8){
								
								TotalbalesOfONPOldNewsPrint = TotalbalesOfONPOldNewsPrint + _totalConsumedBales;
								TotalbalesweightForONPOldNewsPrint=TotalbalesweightForONPOldNewsPrint+_totalConsumedBaleWeight;
								
								
								 wastePaperBaleInventory.setTotalbalesweightForONPOldNewsPrint(TotalbalesweightForONPOldNewsPrint);
								 wastePaperBaleInventory.setTotalbalesOfONPOldNewsPrint(TotalbalesOfONPOldNewsPrint);	
							 }
							if(_gradeCode==9){
								
								TotalbalesOfOINews = TotalbalesOfOINews + _totalConsumedBales;
								TotalbalesweightForOINews=TotalbalesweightForOINews+_totalConsumedBaleWeight;
								
								
								wastePaperBaleInventory.setTotalbalesweightForOINews(TotalbalesweightForOINews);
								wastePaperBaleInventory.setTotalbalesOfOINews(TotalbalesOfOINews);
							}
							if(_gradeCode==10){
								
								TotalbalesOfLightPrtSBS = TotalbalesOfLightPrtSBS + _totalConsumedBales;
								TotalbalesweightForLightPrtSBS=TotalbalesweightForLightPrtSBS+_totalConsumedBaleWeight;
								
								
								wastePaperBaleInventory.setTotalbalesweightForLightPrtSBS(TotalbalesweightForLightPrtSBS);
								wastePaperBaleInventory.setTotalbalesOfLightPrtSBS(TotalbalesOfLightPrtSBS);
							}
							if(_gradeCode==11){
								
								TotalbalesOfHW = TotalbalesOfHW + _totalConsumedBales;
								TotalbalesweightForHW=TotalbalesweightForHW+_totalConsumedBaleWeight;
								
								
								wastePaperBaleInventory.setTotalbalesweightForHW(TotalbalesweightForHW);
								wastePaperBaleInventory.setTotalbalesOfHW(TotalbalesOfHW);
							}
							if(_gradeCode==12){
								
								TotalbalesOfHeavyPrtSBS = TotalbalesOfHeavyPrtSBS + _totalConsumedBales;
								TotalbalesweightForHeavyPrtSBS=TotalbalesweightForHeavyPrtSBS+_totalConsumedBaleWeight;
								
								
								wastePaperBaleInventory.setTotalbalesweightForHeavyPrtSBS(TotalbalesweightForHeavyPrtSBS);
								wastePaperBaleInventory.setTotalbalesOfHeavyPrtSBS(TotalbalesOfHeavyPrtSBS);
							}
							if( _gradeCode==13){
								
								TotalbalesOfSOW = TotalbalesOfSOW + _totalConsumedBales;
								TotalbalesweightForSOW=TotalbalesweightForSOW+_totalConsumedBaleWeight;
								
								
								wastePaperBaleInventory.setTotalbalesweightForSOW(TotalbalesweightForSOW);
								wastePaperBaleInventory.setTotalbalesOfSOW(TotalbalesOfSOW);	
							}
							if(_gradeCode==14){
								
								TotalbalesOfUnprtSBS = TotalbalesOfUnprtSBS + _totalConsumedBales;
								TotalbalesweightForUnprtSBS=TotalbalesweightForUnprtSBS+_totalConsumedBaleWeight;
								
								
								wastePaperBaleInventory.setTotalbalesweightForUnprtSBS(TotalbalesweightForUnprtSBS);
								wastePaperBaleInventory.setTotalbalesOfUnprtSBS(TotalbalesOfUnprtSBS);
							}
							if(_gradeCode==16){
								
								TotalbalesOfNewsblank = TotalbalesOfNewsblank + _totalConsumedBales;
								TotalbalesweightForNewsblank=TotalbalesweightForNewsblank+_totalConsumedBaleWeight;
								
								
								wastePaperBaleInventory.setTotalbalesweightForNewsblank(TotalbalesweightForNewsblank);
								wastePaperBaleInventory.setTotalbalesOfNewsblank(TotalbalesOfNewsblank);
							}
							if(_gradeCode==19){
								
								TotalbalesOfWhiteGdwdBlend = TotalbalesOfWhiteGdwdBlend + _totalConsumedBales;
								TotalbalesweightForWhiteGdwdBlend=TotalbalesweightForWhiteGdwdBlend+_totalConsumedBaleWeight;
								
								
								wastePaperBaleInventory.setTotalbalesweightForWhiteGdwdBlend(TotalbalesweightForWhiteGdwdBlend);
								wastePaperBaleInventory.setTotalbalesOfWhiteGdwdBlend(TotalbalesOfWhiteGdwdBlend);
							}
							if(_gradeCode==20){
								
								TotalbalesOfMailUndeliverable = TotalbalesOfMailUndeliverable + _totalConsumedBales;
								TotalbalesweightForMailUndeliverable=TotalbalesweightForMailUndeliverable+_totalConsumedBaleWeight;
								
								
								wastePaperBaleInventory.setTotalbalesweightForMailUndeliverable(TotalbalesweightForMailUndeliverable);
								wastePaperBaleInventory.setTotalbalesOfMailUndeliverable(TotalbalesOfMailUndeliverable);
							}
							if(_gradeCode==21){
								
								TotalbalesOfHoggedBooks = TotalbalesOfHoggedBooks + _totalConsumedBales;
								TotalbalesweightForHoggedBooks=TotalbalesweightForHoggedBooks+_totalConsumedBaleWeight;
								
								wastePaperBaleInventory.setTotalbalesweightForHoggedBooks(TotalbalesweightForHoggedBooks);
								wastePaperBaleInventory.setTotalbalesOfHoggedBooks(TotalbalesOfHoggedBooks);
							}
							if(_gradeCode==23){
								
								TotalbalesOfOCC = TotalbalesOfOCC + _totalConsumedBales;
								TotalbalesweightForOCC=TotalbalesweightForOCC+_totalConsumedBaleWeight;
								
								
								wastePaperBaleInventory.setTotalbalesweightForOCC(TotalbalesweightForOCC);
								wastePaperBaleInventory.setTotalbalesOfOCC(TotalbalesOfOCC);
							}
							if(_gradeCode==24){
								
								TotalbalesOfDLK = TotalbalesOfDLK + _totalConsumedBales;
								TotalbalesweightForDLK=TotalbalesweightForDLK+_totalConsumedBaleWeight;
								
								
								wastePaperBaleInventory.setTotalbalesweightForDLK(TotalbalesweightForDLK);
								wastePaperBaleInventory.setTotalbalesOfDLK(TotalbalesOfDLK);
							}
							if(_gradeCode==30){
								
								TotalbalesOfMixedPaper = TotalbalesOfMixedPaper + _totalConsumedBales;
								TotalbalesweightForMixedPaper=TotalbalesweightForMixedPaper+_totalConsumedBaleWeight;
								
								
								wastePaperBaleInventory.setTotalbalesweightForMixedPaper(TotalbalesweightForMixedPaper);
								wastePaperBaleInventory.setTotalbalesOfMixedPaper(TotalbalesOfMixedPaper);
							}
							//The Below Code Is Commented According to Discussed With Dinesh Sir Said Not For Use For Us. 
							/*if(_gradeCode==40){
								
								TotalbalesOfSoftWoodChips = TotalbalesOfSoftWoodChips + _totalConsumedBales;
								TotalbalesweightForSoftWoodChips=TotalbalesweightForSoftWoodChips+_totalConsumedBaleWeight;
								
								
								wastePaperBaleInventory.setTotalbalesweightForSoftWoodChips(TotalbalesweightForSoftWoodChips);
								wastePaperBaleInventory.setTotalbalesOfSoftWoodChips(TotalbalesOfSoftWoodChips);
							}
							if(_gradeCode==50){
								
								TotalbalesOfHardWoodChips = TotalbalesOfHardWoodChips + _totalConsumedBales;
								TotalbalesweightForHardWoodChips=TotalbalesweightForHardWoodChips+_totalConsumedBaleWeight;
								
								
								wastePaperBaleInventory.setTotalbalesweightForHardWoodChips(TotalbalesweightForHardWoodChips);
								wastePaperBaleInventory.setTotalbalesOfHardWoodChips(TotalbalesOfHardWoodChips);
							}*/
							if(_gradeCode==56){
								
								TotalbalesOfPWE = TotalbalesOfPWE + _totalConsumedBales;
								TotalbalesweightForPWE=TotalbalesweightForPWE+_totalConsumedBaleWeight;
								
								
								wastePaperBaleInventory.setTotalbalesweightForPWE(TotalbalesweightForPWE);
								wastePaperBaleInventory.setTotalbalesOfPWE(TotalbalesOfPWE);
							}
							if(_gradeCode==60){
								
								TotalbalesOfWhiteBroke = TotalbalesOfWhiteBroke + _totalConsumedBales;
								TotalbalesweightForWhiteBroke=TotalbalesweightForWhiteBroke+_totalConsumedBaleWeight;
								
								
								wastePaperBaleInventory.setTotalbalesweightForWhiteBroke(TotalbalesweightForWhiteBroke);
								wastePaperBaleInventory.setTotalbalesOfWhiteBroke(TotalbalesOfWhiteBroke);
							}
							if(_gradeCode==65){
								
								TotalbalesOfBrownNapkinBroke = TotalbalesOfBrownNapkinBroke + _totalConsumedBales;
								TotalbalesweightForBrownNapkinBroke=TotalbalesweightForBrownNapkinBroke+_totalConsumedBaleWeight;
								
								
								wastePaperBaleInventory.setTotalbalesweightForBrownNapkinBroke(TotalbalesweightForBrownNapkinBroke);
								wastePaperBaleInventory.setTotalbalesOfBrownNapkinBroke(TotalbalesOfBrownNapkinBroke);
							}
							if(_gradeCode==70){
								
								TotalbalesOfPULPWetLap = TotalbalesOfPULPWetLap + _totalConsumedBales;
								TotalbalesweightForPULPWetLap=TotalbalesweightForPULPWetLap+_totalConsumedBaleWeight;
								
								
								wastePaperBaleInventory.setTotalbalesweightForPULPWetLap(TotalbalesweightForPULPWetLap);
								wastePaperBaleInventory.setTotalbalesOfPULPWetLap(TotalbalesOfPULPWetLap);
							}
							/*New Grade Code Added Starts From Here*/
							if(_gradeCode==71){
								
								TotalbalesOfVirginHardWood = TotalbalesOfVirginHardWood + _totalConsumedBales;
								TotalbalesweightForVirginHardWood=TotalbalesweightForVirginHardWood+_totalConsumedBaleWeight;
								
								
								wastePaperBaleInventory.setTotalbalesweightForVirginHardWood(TotalbalesweightForVirginHardWood);
								wastePaperBaleInventory.setTotalbalesOfVirginHardWood(TotalbalesOfVirginHardWood);
							}
							
							if(_gradeCode==72){
								TotalbalesOfVirginSoftWood = TotalbalesOfVirginSoftWood + _totalConsumedBales;
								TotalbalesweightForVirginSoftWood=TotalbalesweightForVirginSoftWood+_totalConsumedBaleWeight;
								
								
								wastePaperBaleInventory.setTotalbalesweightForVirginSoftWood(TotalbalesweightForVirginSoftWood);
								wastePaperBaleInventory.setTotalbalesOfVirginSoftWood(TotalbalesOfVirginSoftWood);
							}
							if(_gradeCode==73){
								totalbalesOfVirginequalypuHW = totalbalesOfVirginequalypuHW + _totalConsumedBales;
								totalbalesweightForVirginequalypuHW=totalbalesweightForVirginequalypuHW+_totalConsumedBaleWeight;
								
								
								wastePaperBaleInventory.setTotalbalesweightForVirginequalypuHW(totalbalesweightForVirginequalypuHW);
								wastePaperBaleInventory.setTotalbalesOfVirginequalypuHW(totalbalesOfVirginequalypuHW);
							}	
							if(_gradeCode==75){
								
								TotalbalesOfVirginPulp = TotalbalesOfVirginPulp + _totalConsumedBales;
								TotalbalesweightForVirginPulp=TotalbalesweightForVirginPulp+_totalConsumedBaleWeight;
								
								
								wastePaperBaleInventory.setTotalbalesweightForVirginPulp(TotalbalesweightForVirginPulp);
								wastePaperBaleInventory.setTotalbalesOfVirginPulp(TotalbalesOfVirginPulp);
							}
							if(_gradeCode==80){
								
								TotalbalesOfBrownWetLap = TotalbalesOfBrownWetLap + _totalConsumedBales;
								TotalbalesweightForBrownWetLap=TotalbalesweightForBrownWetLap+_totalConsumedBaleWeight;
								
								
								wastePaperBaleInventory.setTotalbalesweightForBrownWetLap(TotalbalesweightForBrownWetLap);
								wastePaperBaleInventory.setTotalbalesOfBrownWetLap(TotalbalesOfBrownWetLap);
							}
							if(_gradeCode==87){
								
								TotalbalesOfPulpDryLap = TotalbalesOfPulpDryLap + _totalConsumedBales;
								TotalbalesweightForPulpDryLap=TotalbalesweightForPulpDryLap+_totalConsumedBaleWeight;
								
								
								wastePaperBaleInventory.setTotalbalesweightForPulpDryLap(TotalbalesweightForPulpDryLap);
								wastePaperBaleInventory.setTotalbalesOfPulpDryLap(TotalbalesOfPulpDryLap);
							}
							if(_gradeCode==91){
								
								TotalbalesOfOtherRolls = TotalbalesOfOtherRolls + _totalConsumedBales;
								TotalbalesweightForOtherRolls=TotalbalesweightForOtherRolls+_totalConsumedBaleWeight;
								
								
								wastePaperBaleInventory.setTotalbalesweightForOtherRolls(TotalbalesweightForOtherRolls);
								wastePaperBaleInventory.setTotalbalesOfOtherRolls(TotalbalesOfOtherRolls);
							}
							if(_gradeCode==95){
								
								TotalbalesOfSTBaleswetlap = TotalbalesOfSTBaleswetlap + _totalConsumedBales;
								TotalbalesweightForSTBaleswetlap=TotalbalesweightForSTBaleswetlap+_totalConsumedBaleWeight;
								
								
								wastePaperBaleInventory.setTotalbalesweightForSTBaleswetlap(TotalbalesweightForSTBaleswetlap);
								wastePaperBaleInventory.setTotalbalesOfSTBaleswetlap(TotalbalesOfSTBaleswetlap);
							}
							if(_gradeCode==98){
								
								TotalbalesOfSTTBaledBroke = TotalbalesOfSTTBaledBroke + _totalConsumedBales;
								TotalbalesweightForSTTBaledBroke=TotalbalesweightForSTTBaledBroke+_totalConsumedBaleWeight;
								
								
								wastePaperBaleInventory.setTotalbalesweightForSTTBaledBroke(TotalbalesweightForSTTBaledBroke);
								wastePaperBaleInventory.setTotalbalesOfSTTBaledBroke(TotalbalesOfSTTBaledBroke);
							}		
							else{}
						}
					}else{
					}
			}catch(Exception rlt){
				System.out.println("Roshan Says, You Have Problem In WastePaperConsumedBaleDqaoImp.Java 1");
				rlt.printStackTrace();
			}
			
			consumedDetails.add(wastePaperBaleInventory);
			calendar.add(Calendar.DATE, 1);
		}
		System.out.println("Fetching BARCODE CONSUMED BALES - GRADEWISE <END>");
		return consumedDetails;
	}
	/* (non-Javadoc)
	 * @see com.st.wastepaperunloadbale.dao.WastePaperConsumedBaleDao#getOpenMonth(java.util.Date, java.util.Date)
	 */
	@Override
	public List<BarcodeComman> getOpenMonth(int month, int year) throws ParseException {
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
				
				int virginhardwood=map.get("virginhardwood")==null?0:(Integer)map.get("virginhardwood");
				int virginsoftwood=map.get("virginsoftwood")==null?0:(Integer)map.get("virginsoftwood");
				
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
				
				double virginhardwoodw=map.get("virginhardwoodw")==null?0:(double)map.get("virginhardwoodw");
				double virginsoftwoodw=map.get("virginsoftwoodw")==null?0:(double)map.get("virginsoftwoodw");
				
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
				
				barcodeComman.setVirginhardwood(virginhardwood);
				barcodeComman.setVirginsoftwood(virginsoftwood);
				barcodeComman.setVirginhardwoodw(virginhardwoodw);
				barcodeComman.setVirginsoftwoodw(virginsoftwoodw);
				
				
			}
			barcodeDetails.add(barcodeComman);
		}
		
		return barcodeDetails;
	}
	/* (non-Javadoc)
	 * @see com.st.wastepaperunloadbale.dao.WastePaperConsumedBaleDao#getOpenMonthAvailable(int, int)
	 */
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
	public List<WastePaperBaleInventory> getConsumedDayData(Date yesterdayDate, Date yesterdayDate2, String shift,
			String line) {

		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSourceP);
		List<WastePaperBaleInventory> consumedDetails= new ArrayList<WastePaperBaleInventory>();
		
		int days=CommonUtil.getDaysDiffernce(yesterdayDate, yesterdayDate);
		
		Calendar calendar=Calendar.getInstance();
		calendar.setTime(yesterdayDate);
		System.out.println("Fetching BARCODE CONSUMED BALES - GRADEWISE <START>");
		for (int i = 0; i <=days; i++) {
			Date dateS=calendar.getTime();
			Calendar scal=Calendar.getInstance();
			Calendar ecal=Calendar.getInstance();
			
			if(shift.equals("day")) {
			
			
			scal.setTime(dateS);
			scal.set(Calendar.HOUR_OF_DAY, 7);
			scal.set(Calendar.MINUTE, 0);
			scal.set(Calendar.SECOND, 0);
			scal.set(Calendar.MILLISECOND, 0);
	
			
		
			ecal.setTime(dateS);
			ecal.set(Calendar.HOUR_OF_DAY, 18);
			ecal.set(Calendar.MINUTE, 59);
			ecal.set(Calendar.SECOND, 59);
			ecal.set(Calendar.MILLISECOND, 0);
		} 
		if (shift.equals("night")) {
			
			
			scal.setTime(dateS);
			scal.set(Calendar.HOUR_OF_DAY, 19);
			scal.set(Calendar.MINUTE, 0);
			scal.set(Calendar.SECOND, 0);
			scal.set(Calendar.MILLISECOND, 0);
	
			
			
			ecal.setTime(dateS);
			ecal.set(Calendar.HOUR_OF_DAY, 6);
			ecal.set(Calendar.MINUTE, 59);
			ecal.set(Calendar.SECOND, 59);
			ecal.set(Calendar.MILLISECOND, 0);
			ecal.add(Calendar.DATE, 1);			
		}
			System.out.println("Start Date::"+yesterdayDate+"End Date::"+yesterdayDate2);
			
			final WastePaperBaleInventory wastePaperBaleInventory=new WastePaperBaleInventory();
			wastePaperBaleInventory.setDate(dateS);
			
			int _totalConsumedBalesCount=0;
			double _totalConsumedBaleWeightCount=0.0;
			
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
			
			double TotalbalesweightForBoxboardClippings=0;
			int TotalbalesOfBoxboardClippings=0;
			/*New Grade Code Added Starts From Here*/
			
			double TotalbalesweightForVirginHardWood=0;
			int TotalbalesOfVirginHardWood=0;

			double TotalbalesweightForVirginSoftWood=0;
			int TotalbalesOfVirginSoftWood=0;
			double totalbalesweightForHardWhite=0;
			int totalbalesOfHardWhite=0;
			double totalbalesweightForVirginequalypuHW=0;
			int totalbalesOfVirginequalypuHW=0;
			try{
				
				String sqlforConsumedBale=null;
				List<Map<String, Object>> mapList=new ArrayList<Map<String,Object>>();
				
				
				/*String sqlforConsumedBale="SELECT [ConsumedDate], sum(BaleWeight)/2000 as BALEWT,[GradeCode],count(*) as COUNTBALE"
						+ " FROM [tblBaleInventory] where ([ConsumedDate] between ? and ? ) AND [GradeCode]=? group by [ConsumedDate],[GradeCode]";*/
				  if(line.contains("mtdLine")) {
					  sqlforConsumedBale="SELECT [ActualConsumedDateTime], sum(BaleWeight)/2000 as BALEWT,[GradeCode],count(*) as COUNTBALE FROM [tblBaleInventory] "
								+ "where ([ActualConsumedDateTime] between ? and ? ) AND Pulper='"+shift+"' AND [GradeCode] in (select GradeCode from tlkpGrade)group by [ActualConsumedDateTime],[GradeCode]  ";
					  try {
							mapList=jdbcTemplate.queryForList(sqlforConsumedBale,new Object[]{
									yesterdayDate,
									yesterdayDate2
							});
						} catch (Exception e) {
							System.out.println(e.getMessage());
						}
				 
				  }else if (line.equalsIgnoreCase("totalweight")) {
					  sqlforConsumedBale="SELECT  sum(BaleWeight)/2000 as BALEWT,[GradeCode],count(*) as COUNTBALE FROM [tblBaleInventory]"
								+ "where  [GradeCode] in (select GradeCode from tlkpGrade)group by [GradeCode] ";
					 try {
							mapList=jdbcTemplate.queryForList(sqlforConsumedBale);
					  } catch (Exception e) {
							System.out.println(e.getMessage());
						}
				  }
				  else if (line.equalsIgnoreCase("consumedweight")) {
					  sqlforConsumedBale="SELECT  sum(BaleWeight)/2000 as BALEWT,[GradeCode],count(*) as COUNTBALE FROM [tblBaleInventory] "
								+ "where ConsumedDate is not null AND ConsumedDate <=? AND [GradeCode] in (select GradeCode from tlkpGrade)group by [GradeCode] ";
					 try {
							mapList=jdbcTemplate.queryForList(sqlforConsumedBale,new Object[]{
								yesterdayDate
						});
					  } catch (Exception e) {
							System.out.println(e.getMessage());
						}
				  }else {
					  sqlforConsumedBale="SELECT [ActualConsumedDateTime], sum(BaleWeight)/2000 as BALEWT,[GradeCode],count(*) as COUNTBALE FROM [tblBaleInventory] "
								+ "where ([ActualConsumedDateTime] between ? and ? ) AND Pulper='"+line+"' AND [GradeCode] in (select GradeCode from tlkpGrade)group by [ActualConsumedDateTime],[GradeCode]  ";
					  try {
							mapList=jdbcTemplate.queryForList(sqlforConsumedBale,new Object[]{
									new Timestamp(scal.getTime().getTime()),
									new Timestamp(ecal.getTime().getTime())
							});
						} catch (Exception e) {
							System.out.println(e.getMessage());
						}
				  }
					if(mapList.size()>0){
						for(Map<String, Object> map1:mapList){
							//double _totalConsumedBaleWeight=map1.get("BALEWT")==null?0:(Double)map1.get("BALEWT");
							
							BigDecimal d = BigDecimal.ZERO;
							d= (BigDecimal) (map1.get("BALEWT")==null?0:(BigDecimal)(map1.get("BALEWT")));
							double _totalConsumedBaleWeight = d.doubleValue(); 
							
							
							int _totalConsumedBales=map1.get("COUNTBALE")==null?0:(Integer)map1.get("COUNTBALE");
							/*BigDecimal d2 = BigDecimal.ZERO;
							d2= (BigDecimal) (map1.get("COUNTBALE")==null?0:(BigDecimal)(map1.get("COUNTBALE")));
							int _totalConsumedBales = d2.intValueExact(); */
							
							
							//int _gradeCode=(Integer)map1.get("GradeCode");
							BigDecimal d1 = BigDecimal.ZERO;
							d1= (BigDecimal) (map1.get("GradeCode")==null?0:(BigDecimal)(map1.get("GradeCode")));
							int _gradeCode=d1.intValueExact();
							
							
							Date _unloaddate=(Date)map1.get("UnloadDate");
							
							_totalConsumedBalesCount = _totalConsumedBalesCount + _totalConsumedBales;
							wastePaperBaleInventory.setTotalbales(_totalConsumedBalesCount);
							
							_totalConsumedBaleWeightCount=_totalConsumedBaleWeightCount+_totalConsumedBaleWeight;
							wastePaperBaleInventory.setTotalbalesweight(_totalConsumedBaleWeightCount);
							
							if(_gradeCode==1){
								
								TotalbalesOfMWL = TotalbalesOfMWL + _totalConsumedBales;
								TotalbalesweightForMWL=TotalbalesweightForMWL+_totalConsumedBaleWeight;
								
								wastePaperBaleInventory.setTotalbalesweightForMWL(TotalbalesweightForMWL);
								wastePaperBaleInventory.setTotalbalesOfMWL(TotalbalesOfMWL);
							}
							/*
							 * if(_gradeCode==2){
							 * 
							 * TotalbalesOfPrtmix = TotalbalesOfPrtmix + _totalConsumedBales;
							 * TotalbalesweightForPrtmix=TotalbalesweightForPrtmix+_totalConsumedBaleWeight;
							 * 
							 * 
							 * wastePaperBaleInventory.setTotalbalesweightForPrtmix(
							 * TotalbalesweightForPrtmix);
							 * wastePaperBaleInventory.setTotalbalesOfPrtmix(TotalbalesOfPrtmix); }
							 */
							if(_gradeCode==3){
								
								TotalbalesOfMCL = TotalbalesOfMCL + _totalConsumedBales;
								TotalbalesweightForMCL=TotalbalesweightForMCL+_totalConsumedBaleWeight;
								
								
								 wastePaperBaleInventory.setTotalbalesweightForMCL(TotalbalesweightForMCL);
								 wastePaperBaleInventory.setTotalbalesOfMCL(TotalbalesOfMCL);
							}
							if(_gradeCode==4){
								
								TotalbalesOfMWLWorIGS = TotalbalesOfMWLWorIGS + _totalConsumedBales;
								TotalbalesweightForMWLWorIGS=TotalbalesweightForMWLWorIGS+_totalConsumedBaleWeight;
								
								
								wastePaperBaleInventory.setTotalbalesweightForMWLWorIGS(TotalbalesweightForMWLWorIGS);
								wastePaperBaleInventory.setTotalbalesOfMWLWorIGS(TotalbalesOfMWLWorIGS);
							}
							if(_gradeCode==5){
								
								TotalbalesOfCBS = TotalbalesOfCBS + _totalConsumedBales;
								TotalbalesweightForCBS=TotalbalesweightForCBS+_totalConsumedBaleWeight;
								
								
								wastePaperBaleInventory.setTotalbalesweightForCBS(TotalbalesweightForCBS);
								wastePaperBaleInventory.setTotalbalesOfCBS(TotalbalesOfCBS);
							}
							if(_gradeCode==6){
								
								TotalbalesOfCtdGdwd = TotalbalesOfCtdGdwd + _totalConsumedBales;
								TotalbalesweightForCtdGdwd=TotalbalesweightForCtdGdwd+_totalConsumedBaleWeight;
								
								
								wastePaperBaleInventory.setTotalbalesweightForCtdGdwd(TotalbalesweightForCtdGdwd);
								wastePaperBaleInventory.setTotalbalesOfCtdGdwd(TotalbalesOfCtdGdwd);
							}
							if(_gradeCode==7){
								
								TotalbalesOfSWL = TotalbalesOfSWL + _totalConsumedBales;
								TotalbalesweightForSWL=TotalbalesweightForSWL+_totalConsumedBaleWeight;
								
								
								wastePaperBaleInventory.setTotalbalesweightForSWL(TotalbalesweightForSWL);
								wastePaperBaleInventory.setTotalbalesOfSWL(TotalbalesOfSWL);
							}
							if(_gradeCode==8){
								
								TotalbalesOfONPOldNewsPrint = TotalbalesOfONPOldNewsPrint + _totalConsumedBales;
								TotalbalesweightForONPOldNewsPrint=TotalbalesweightForONPOldNewsPrint+_totalConsumedBaleWeight;
								
								
								 wastePaperBaleInventory.setTotalbalesweightForONPOldNewsPrint(TotalbalesweightForONPOldNewsPrint);
								 wastePaperBaleInventory.setTotalbalesOfONPOldNewsPrint(TotalbalesOfONPOldNewsPrint);	
							 }
							if(_gradeCode==9){
								
								TotalbalesOfOINews = TotalbalesOfOINews + _totalConsumedBales;
								TotalbalesweightForOINews=TotalbalesweightForOINews+_totalConsumedBaleWeight;
								
								
								wastePaperBaleInventory.setTotalbalesweightForOINews(TotalbalesweightForOINews);
								wastePaperBaleInventory.setTotalbalesOfOINews(TotalbalesOfOINews);
							}
							if(_gradeCode==10){
								
								TotalbalesOfLightPrtSBS = TotalbalesOfLightPrtSBS + _totalConsumedBales;
								TotalbalesweightForLightPrtSBS=TotalbalesweightForLightPrtSBS+_totalConsumedBaleWeight;
								
								
								wastePaperBaleInventory.setTotalbalesweightForLightPrtSBS(TotalbalesweightForLightPrtSBS);
								wastePaperBaleInventory.setTotalbalesOfLightPrtSBS(TotalbalesOfLightPrtSBS);
							}
							if(_gradeCode==11){
								
								TotalbalesOfHW = TotalbalesOfHW + _totalConsumedBales;
								TotalbalesweightForHW=TotalbalesweightForHW+_totalConsumedBaleWeight;
								
								
								wastePaperBaleInventory.setTotalbalesweightForHW(TotalbalesweightForHW);
								wastePaperBaleInventory.setTotalbalesOfHW(TotalbalesOfHW);
							}
							if(_gradeCode==12){
								
								TotalbalesOfHeavyPrtSBS = TotalbalesOfHeavyPrtSBS + _totalConsumedBales;
								TotalbalesweightForHeavyPrtSBS=TotalbalesweightForHeavyPrtSBS+_totalConsumedBaleWeight;
								
								
								wastePaperBaleInventory.setTotalbalesweightForHeavyPrtSBS(TotalbalesweightForHeavyPrtSBS);
								wastePaperBaleInventory.setTotalbalesOfHeavyPrtSBS(TotalbalesOfHeavyPrtSBS);
							}
							if( _gradeCode==13){
								
								TotalbalesOfSOW = TotalbalesOfSOW + _totalConsumedBales;
								TotalbalesweightForSOW=TotalbalesweightForSOW+_totalConsumedBaleWeight;
								
								
								wastePaperBaleInventory.setTotalbalesweightForSOW(TotalbalesweightForSOW);
								wastePaperBaleInventory.setTotalbalesOfSOW(TotalbalesOfSOW);	
							}
							if(_gradeCode==14){
								
								TotalbalesOfUnprtSBS = TotalbalesOfUnprtSBS + _totalConsumedBales;
								TotalbalesweightForUnprtSBS=TotalbalesweightForUnprtSBS+_totalConsumedBaleWeight;
								
								
								wastePaperBaleInventory.setTotalbalesweightForUnprtSBS(TotalbalesweightForUnprtSBS);
								wastePaperBaleInventory.setTotalbalesOfUnprtSBS(TotalbalesOfUnprtSBS);
							}
							if(_gradeCode==16){
								
								TotalbalesOfNewsblank = TotalbalesOfNewsblank + _totalConsumedBales;
								TotalbalesweightForNewsblank=TotalbalesweightForNewsblank+_totalConsumedBaleWeight;
								
								
								wastePaperBaleInventory.setTotalbalesweightForNewsblank(TotalbalesweightForNewsblank);
								wastePaperBaleInventory.setTotalbalesOfNewsblank(TotalbalesOfNewsblank);
							}
							if(_gradeCode==19){
								
								TotalbalesOfWhiteGdwdBlend = TotalbalesOfWhiteGdwdBlend + _totalConsumedBales;
								TotalbalesweightForWhiteGdwdBlend=TotalbalesweightForWhiteGdwdBlend+_totalConsumedBaleWeight;
								
								
								wastePaperBaleInventory.setTotalbalesweightForWhiteGdwdBlend(TotalbalesweightForWhiteGdwdBlend);
								wastePaperBaleInventory.setTotalbalesOfWhiteGdwdBlend(TotalbalesOfWhiteGdwdBlend);
							}
							if(_gradeCode==20){
								
								TotalbalesOfMailUndeliverable = TotalbalesOfMailUndeliverable + _totalConsumedBales;
								TotalbalesweightForMailUndeliverable=TotalbalesweightForMailUndeliverable+_totalConsumedBaleWeight;
								
								
								wastePaperBaleInventory.setTotalbalesweightForMailUndeliverable(TotalbalesweightForMailUndeliverable);
								wastePaperBaleInventory.setTotalbalesOfMailUndeliverable(TotalbalesOfMailUndeliverable);
							}
							if(_gradeCode==21){
								
								TotalbalesOfHoggedBooks = TotalbalesOfHoggedBooks + _totalConsumedBales;
								TotalbalesweightForHoggedBooks=TotalbalesweightForHoggedBooks+_totalConsumedBaleWeight;
								
								wastePaperBaleInventory.setTotalbalesweightForHoggedBooks(TotalbalesweightForHoggedBooks);
								wastePaperBaleInventory.setTotalbalesOfHoggedBooks(TotalbalesOfHoggedBooks);
							}
							if(_gradeCode==22){
								
								TotalbalesOfBoxboardClippings = TotalbalesOfBoxboardClippings + _totalConsumedBales;
								TotalbalesweightForBoxboardClippings=TotalbalesweightForBoxboardClippings+_totalConsumedBaleWeight;
								
								
								wastePaperBaleInventory.setTotalbalesOfBoxboardClippings(TotalbalesOfBoxboardClippings);
								wastePaperBaleInventory.setTotalbalesweightForBoxboardClippings(TotalbalesweightForBoxboardClippings);
							}	
							if(_gradeCode==23){
								
								TotalbalesOfOCC = TotalbalesOfOCC + _totalConsumedBales;
								TotalbalesweightForOCC=TotalbalesweightForOCC+_totalConsumedBaleWeight;
								
								
								wastePaperBaleInventory.setTotalbalesweightForOCC(TotalbalesweightForOCC);
								wastePaperBaleInventory.setTotalbalesOfOCC(TotalbalesOfOCC);
							}
							if(_gradeCode==24){
								
								TotalbalesOfDLK = TotalbalesOfDLK + _totalConsumedBales;
								TotalbalesweightForDLK=TotalbalesweightForDLK+_totalConsumedBaleWeight;
								
								
								wastePaperBaleInventory.setTotalbalesweightForDLK(TotalbalesweightForDLK);
								wastePaperBaleInventory.setTotalbalesOfDLK(TotalbalesOfDLK);
							}
							if(_gradeCode==30){
								
								TotalbalesOfMixedPaper = TotalbalesOfMixedPaper + _totalConsumedBales;
								TotalbalesweightForMixedPaper=TotalbalesweightForMixedPaper+_totalConsumedBaleWeight;
								
								
								wastePaperBaleInventory.setTotalbalesweightForMixedPaper(TotalbalesweightForMixedPaper);
								wastePaperBaleInventory.setTotalbalesOfMixedPaper(TotalbalesOfMixedPaper);
							}
							//The Below Code Is Commented According to Discussed With Dinesh Sir Said Not For Use For Us. 
							/*if(_gradeCode==40){
								
								TotalbalesOfSoftWoodChips = TotalbalesOfSoftWoodChips + _totalConsumedBales;
								TotalbalesweightForSoftWoodChips=TotalbalesweightForSoftWoodChips+_totalConsumedBaleWeight;
								
								
								wastePaperBaleInventory.setTotalbalesweightForSoftWoodChips(TotalbalesweightForSoftWoodChips);
								wastePaperBaleInventory.setTotalbalesOfSoftWoodChips(TotalbalesOfSoftWoodChips);
							}
							if(_gradeCode==50){
								
								TotalbalesOfHardWoodChips = TotalbalesOfHardWoodChips + _totalConsumedBales;
								TotalbalesweightForHardWoodChips=TotalbalesweightForHardWoodChips+_totalConsumedBaleWeight;
								
								
								wastePaperBaleInventory.setTotalbalesweightForHardWoodChips(TotalbalesweightForHardWoodChips);
								wastePaperBaleInventory.setTotalbalesOfHardWoodChips(TotalbalesOfHardWoodChips);
							}*/
							if(_gradeCode==56){
								
								TotalbalesOfPWE = TotalbalesOfPWE + _totalConsumedBales;
								TotalbalesweightForPWE=TotalbalesweightForPWE+_totalConsumedBaleWeight;
								
								
								wastePaperBaleInventory.setTotalbalesweightForPWE(TotalbalesweightForPWE);
								wastePaperBaleInventory.setTotalbalesOfPWE(TotalbalesOfPWE);
							}
							if(_gradeCode==60){
								
								TotalbalesOfWhiteBroke = TotalbalesOfWhiteBroke + _totalConsumedBales;
								TotalbalesweightForWhiteBroke=TotalbalesweightForWhiteBroke+_totalConsumedBaleWeight;
								
								
								wastePaperBaleInventory.setTotalbalesweightForWhiteBroke(TotalbalesweightForWhiteBroke);
								wastePaperBaleInventory.setTotalbalesOfWhiteBroke(TotalbalesOfWhiteBroke);
							}
							if(_gradeCode==65){
								
								TotalbalesOfBrownNapkinBroke = TotalbalesOfBrownNapkinBroke + _totalConsumedBales;
								TotalbalesweightForBrownNapkinBroke=TotalbalesweightForBrownNapkinBroke+_totalConsumedBaleWeight;
								
								
								wastePaperBaleInventory.setTotalbalesweightForBrownNapkinBroke(TotalbalesweightForBrownNapkinBroke);
								wastePaperBaleInventory.setTotalbalesOfBrownNapkinBroke(TotalbalesOfBrownNapkinBroke);
							}
							if(_gradeCode==70){
								
								TotalbalesOfPULPWetLap = TotalbalesOfPULPWetLap + _totalConsumedBales;
								TotalbalesweightForPULPWetLap=TotalbalesweightForPULPWetLap+_totalConsumedBaleWeight;
								
								
								wastePaperBaleInventory.setTotalbalesweightForPULPWetLap(TotalbalesweightForPULPWetLap);
								wastePaperBaleInventory.setTotalbalesOfPULPWetLap(TotalbalesOfPULPWetLap);
							}
							if(_gradeCode==75){
								
								TotalbalesOfVirginPulp = TotalbalesOfVirginPulp + _totalConsumedBales;
								TotalbalesweightForVirginPulp=TotalbalesweightForVirginPulp+_totalConsumedBaleWeight;
								
								
								wastePaperBaleInventory.setTotalbalesweightForVirginPulp(TotalbalesweightForVirginPulp);
								wastePaperBaleInventory.setTotalbalesOfVirginPulp(TotalbalesOfVirginPulp);
							}
							if(_gradeCode==80){
								
								TotalbalesOfBrownWetLap = TotalbalesOfBrownWetLap + _totalConsumedBales;
								TotalbalesweightForBrownWetLap=TotalbalesweightForBrownWetLap+_totalConsumedBaleWeight;
								
								
								wastePaperBaleInventory.setTotalbalesweightForBrownWetLap(TotalbalesweightForBrownWetLap);
								wastePaperBaleInventory.setTotalbalesOfBrownWetLap(TotalbalesOfBrownWetLap);
							}
							if(_gradeCode==87){
								
								TotalbalesOfPulpDryLap = TotalbalesOfPulpDryLap + _totalConsumedBales;
								TotalbalesweightForPulpDryLap=TotalbalesweightForPulpDryLap+_totalConsumedBaleWeight;
								
								
								wastePaperBaleInventory.setTotalbalesweightForPulpDryLap(TotalbalesweightForPulpDryLap);
								wastePaperBaleInventory.setTotalbalesOfPulpDryLap(TotalbalesOfPulpDryLap);
							}
							if(_gradeCode==91){
								
								TotalbalesOfOtherRolls = TotalbalesOfOtherRolls + _totalConsumedBales;
								TotalbalesweightForOtherRolls=TotalbalesweightForOtherRolls+_totalConsumedBaleWeight;
								
								
								wastePaperBaleInventory.setTotalbalesweightForOtherRolls(TotalbalesweightForOtherRolls);
								wastePaperBaleInventory.setTotalbalesOfOtherRolls(TotalbalesOfOtherRolls);
							}
							if(_gradeCode==95){
								
								TotalbalesOfSTBaleswetlap = TotalbalesOfSTBaleswetlap + _totalConsumedBales;
								TotalbalesweightForSTBaleswetlap=TotalbalesweightForSTBaleswetlap+_totalConsumedBaleWeight;
								
								
								wastePaperBaleInventory.setTotalbalesweightForSTBaleswetlap(TotalbalesweightForSTBaleswetlap);
								wastePaperBaleInventory.setTotalbalesOfSTBaleswetlap(TotalbalesOfSTBaleswetlap);
							}
							if(_gradeCode==98){
								
								TotalbalesOfSTTBaledBroke = TotalbalesOfSTTBaledBroke + _totalConsumedBales;
								TotalbalesweightForSTTBaledBroke=TotalbalesweightForSTTBaledBroke+_totalConsumedBaleWeight;
								
								
								wastePaperBaleInventory.setTotalbalesweightForSTTBaledBroke(TotalbalesweightForSTTBaledBroke);
								wastePaperBaleInventory.setTotalbalesOfSTTBaledBroke(TotalbalesOfSTTBaledBroke);
							}
							/*New Grade Code Added Starts From Here*/
							if(_gradeCode==2){
								totalbalesOfHardWhite = totalbalesOfHardWhite + _totalConsumedBales;
								totalbalesweightForHardWhite=totalbalesweightForHardWhite+_totalConsumedBaleWeight;
								
								
								wastePaperBaleInventory.setTotalbalesweightForHardWhite(totalbalesweightForHardWhite);
								wastePaperBaleInventory.setTotalbalesOfHardWhite(totalbalesOfHardWhite);
							}
							if(_gradeCode==71){
								
								TotalbalesOfVirginHardWood = TotalbalesOfVirginHardWood + _totalConsumedBales;
								TotalbalesweightForVirginHardWood=TotalbalesweightForVirginHardWood+_totalConsumedBaleWeight;
								
								
								wastePaperBaleInventory.setTotalbalesweightForVirginHardWood(TotalbalesweightForVirginHardWood);
								wastePaperBaleInventory.setTotalbalesOfVirginHardWood(TotalbalesOfVirginHardWood);
							}
							
							if(_gradeCode==72){
								TotalbalesOfVirginSoftWood = TotalbalesOfVirginSoftWood + _totalConsumedBales;
								TotalbalesweightForVirginSoftWood=TotalbalesweightForVirginSoftWood+_totalConsumedBaleWeight;
								
								
								wastePaperBaleInventory.setTotalbalesweightForVirginSoftWood(TotalbalesweightForVirginSoftWood);
								wastePaperBaleInventory.setTotalbalesOfVirginSoftWood(TotalbalesOfVirginSoftWood);
							}
							if(_gradeCode==73){
								totalbalesOfVirginequalypuHW = totalbalesOfVirginequalypuHW + _totalConsumedBales;
								totalbalesweightForVirginequalypuHW=totalbalesweightForVirginequalypuHW+_totalConsumedBaleWeight;
								
								
								wastePaperBaleInventory.setTotalbalesweightForVirginequalypuHW(totalbalesweightForVirginequalypuHW);
								wastePaperBaleInventory.setTotalbalesOfVirginequalypuHW(totalbalesOfVirginequalypuHW);
							}	
							
							else{}
						}
					}else{
					}
			}catch(Exception rlt){
				System.out.println("Roshan Says, You Have Problem In WastePaperConsumedBaleDqaoImp.Java 1");
				rlt.printStackTrace();
			}
			
			consumedDetails.add(wastePaperBaleInventory);
			calendar.add(Calendar.DATE, 1);
		}
		System.out.println("Fetching BARCODE CONSUMED BALES - GRADEWISE <END>");
		return consumedDetails;
	
	}
	/* (non-Javadoc)
	 * @see com.st.wastepaper.dao.WastePaperConsumedBaleDao#getPulpLine(java.util.Date, java.util.Date)
	 */
	@Override
	public List<String> getPulpLine(Date yesterdayDate, Date yesterdayDate2) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSourceP);
		Calendar calendar=Calendar.getInstance();
		calendar.setTime(yesterdayDate);
		Date dateS=calendar.getTime();
		Calendar scal=Calendar.getInstance();
		Calendar ecal=Calendar.getInstance();
		scal.setTime(dateS);
		scal.set(Calendar.HOUR_OF_DAY, 7);
		scal.set(Calendar.MINUTE, 0);
		scal.set(Calendar.SECOND, 0);
		scal.set(Calendar.MILLISECOND, 0);		
	
		ecal.setTime(dateS);
		ecal.set(Calendar.HOUR_OF_DAY, 18);
		ecal.set(Calendar.MINUTE, 59);
		ecal.set(Calendar.SECOND, 59);
		ecal.set(Calendar.MILLISECOND, 0);
		
		
		String sql=" SELECT  Distinct Pulper as lines FROM [tracker].[dbo].[tblBaleInventory]  where [ActualConsumedDateTime] between ? and ?";
		List<String>pulbList=new ArrayList<String>();
			try {
				pulbList=jdbcTemplate.query(sql,new Object[]{
						new Timestamp(scal.getTime().getTime()),
						new Timestamp(ecal.getTime().getTime())
				},
				new RowMapper<String>() {

					@Override
					public String mapRow(ResultSet rs, int arg1) throws SQLException {
						return rs.getString("lines");
					}
				});
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		return pulbList;
	}

}

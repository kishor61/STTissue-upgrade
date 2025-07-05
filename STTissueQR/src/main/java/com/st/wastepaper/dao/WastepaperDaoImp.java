/**
 *Feb 17, 2015
 *WastepaperDaoImp.java
 * TODO
 *com.st.wastepaper.dao
 *WastepaperDaoImp.java
 *Sunil Singh Bora
 */
package com.st.wastepaper.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
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
import org.springframework.transaction.annotation.Transactional;

import com.st.common.CommonUtil;
import com.st.wastepaper.model.WastePaperBaleInventory;
import com.st.wastepaper.model.WastepaperDetail;



/**
 * @author roshan
 *
 */
@Repository
public class WastepaperDaoImp implements WastepaperDao {

	@Autowired
	@Qualifier("dataSourceTracker")
	private DataSource dataSourceT;
	
	@Autowired
	private DataSource dataSource;
	
	@Autowired
	@Qualifier("dataSourceProduction")
	private DataSource dataSourceP;
	
	
	/* (non-Javadoc)
	 * @see com.st.wastepaper.dao.WastepaperDao#getWastepaperDetailData(java.util.Date, java.util.Date)
	 */
	@Override
	public List<WastepaperDetail> getWastepaperDetailData(Date sdate, Date edate) {
		
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSourceP);
		JdbcTemplate jdbcTemplate1=new JdbcTemplate(dataSource);
		
		List<WastepaperDetail> details=new ArrayList<WastepaperDetail>();
		
		int days=CommonUtil.getDaysDiffernce(sdate, edate);
		
		Calendar calendar=Calendar.getInstance();
		calendar.setTime(sdate);
		int loopCount=1;
		
		List<TempReleaseData> datas=new ArrayList<TempReleaseData>();
		
		for (int i = 0; i <=days; i++) {
			Date dateS=calendar.getTime();
			//Round(sum(BaleWeight)/2000,2) as [BaleWeightT]
			//sum(BaleWeight)/2000 as [BaleWeightT]
			String sqlBale="SELECT [ReleaseNumber],[UnloadDate], Round(sum(BaleWeight)/2000,2) as [BaleWeightT],[GradeCode],count(*) as [Bales] "
					+ " FROM [tblBaleInventory] where "
					+ " [UnloadDate] = ? "
					+ "  AND [GradeCode] <> 80 AND [GradeCode] <> 95 group by [ReleaseNumber],[UnloadDate],[GradeCode]";
			
			List<Map<String, Object>> maps=jdbcTemplate.queryForList(sqlBale, new Object[]{dateS});
			
			for (Map<String, Object> map : maps) {
				
				String destination="";
				
				final WastepaperDetail wastepaperDetail=new WastepaperDetail();
				wastepaperDetail.setUnloadedDate(dateS);
				
				//int releaseNo=(Integer)map.get("ReleaseNumber".toUpperCase());
				BigDecimal d1 = BigDecimal.ZERO;
				d1= (BigDecimal) (map.get("ReleaseNumber")==null?0:(BigDecimal)(map.get("ReleaseNumber")));
				int releaseNo=d1.intValueExact();
				
//				double baleWeight=(Double)map.get("BaleWeightT".toUpperCase());
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
//				Code Ends Here Done By Roshan Tailor Date :- 06/04/2015 MM/DD/YYY Night Shift
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
			calendar.add(Calendar.DATE, 1);
			System.out.println("Loop Runing In Waste Paper Detailed Report "+loopCount+" Times.");	
			loopCount++;
		}
		return details;
	}


	/* (non-Javadoc)
	 * @see com.st.wastepaper.dao.WastepaperDao#getTransferToMaster(java.util.Date, java.util.Date)
	 */
	/*@Override
	public List<WastepaperDetail> getTransferToMaster(Date sDate, Date eDate) {

		
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSourceT);
		JdbcTemplate jdbcTemplate1=new JdbcTemplate(dataSource);
		
		List<WastepaperDetail> details=new ArrayList<WastepaperDetail>();
		
		int days=CommonUtil.getDaysDiffernce(sDate, eDate);
		
		Calendar calendar=Calendar.getInstance();
		calendar.setTime(sDate);
		for (int i = 0; i <=days; i++) {
			Date dateS=calendar.getTime();
			
			
			
			String sqlBale="SELECT [ReleaseNumber],[UnloadDate], sum(BaleWeight)/2000 as [BaleWeightT],[GradeCode],count(*) as [Bales] "
					+ " FROM [tblBaleInventory] where "
					+ " [UnloadDate] = ? "
					+ " group by [ReleaseNumber],[UnloadDate],[GradeCode]";
			
			List<Map<String, Object>> maps=jdbcTemplate.queryForList(sqlBale, new Object[]{dateS});
			
			for (Map<String, Object> map : maps) {
			
				final WastepaperDetail wastepaperDetail=new WastepaperDetail();
				wastepaperDetail.setUnloadedDate(dateS);
				
				int releaseNo=(Integer)map.get("ReleaseNumber".toUpperCase());
				wastepaperDetail.setReleaseNo(releaseNo);
				double baleWeight=(Double)map.get("BaleWeightT".toUpperCase());
				int gradeCode=(Integer)map.get("GradeCode".toUpperCase());
				int bale=(Integer)map.get("Bales".toUpperCase());
				
				System.out.println("Realease Number::"+releaseNo);
				String sqlGrade="select [Grade] from [tlkpGrade] where [GradeCode]=?";
			
				try {
					String grade=jdbcTemplate.queryForObject(sqlGrade,new Object[]{gradeCode}, String.class);
					wastepaperDetail.setItemDescription(grade);
				} catch (Exception e) {
					System.out.println("Grade Name not found: "+e.getMessage());
				}
//				Code Starts From Here Done By Roshan Tailor Date :-06/04/2015 MM/DD/YYYY  Night Shift
				try {
					//String sqlmasterPO="select [MasterPO] [tblPurchaseHeader] where [ReleaseNumber]=? ";
					String sqlmasterPO="select [MasterPO] AS PO,[UnLoadComment] AS Comment from [tblPurchaseHeader] where [ReleaseNumber]=? ";
					//String masterPO=jdbcTemplate.queryForObject(sqlmasterPO,new Object[]{releaseNo}, String.class);
					List<Map<String, Object>> masterPO=jdbcTemplate.queryForList(sqlmasterPO,new Object[]{releaseNo});
					//wastepaperDetail.setMasterPO(masterPO);
					for(Map<String, Object> masterponcomment:masterPO){
						String masterpo=(String)masterponcomment.get("PO");
						String comment=(String)masterponcomment.get("Comment");
						wastepaperDetail.setMasterPO(masterpo);
						wastepaperDetail.setComment(comment);
						try{
							String sqlMasterpo="select [MasterPO],[VendorName],[VendorCity],[VendorState] from [tblMasterPOHeader] where [MasterPO]=? ";
							List<Map<String, Object>> maps_2=jdbcTemplate.queryForList(sqlMasterpo,new Object[]{masterpo});
							if(maps_2.size()>0){
								Map<String, Object> map_2=maps_2.get(0);
								
								String MasterPO=(String)map_2.get("MasterPO".toUpperCase());
								String VendorName=(String)map_2.get("VendorName".toUpperCase());
								String VendorCity=(String)map_2.get("VendorCity".toUpperCase());
								String VendorState=(String)map_2.get("VendorState".toUpperCase());
								try{
									//String sqlPricePerTon="select [Rate] from [tblMasterPODetail] where [MasterPO]=?";
									//SELECT SUM(Rate) AS TotalRate FROM tblMasterPODetail where  [MasterPO]='20579'; //This Query Is For Testing ,Result Showing Perfect. 
									String sqlPricePerTon="SELECT SUM(Rate) AS TotalRate FROM tblMasterPODetail where [MasterPO]=?";
									List<Map<String, Object>> priceperton=jdbcTemplate.queryForList(sqlPricePerTon, new Object[]{MasterPO});
									//wastepaperDetail.setPricePerTon(priceperton);
									for(Map<String, Object> TonAndCmt: priceperton){
										double pricepertone=(Double)TonAndCmt.get("TotalRate");
										//String comment=(String)TonAndCmt.get("Comment");
										wastepaperDetail.setPricePerTon(pricepertone);
										//wastepaperDetail.setComment(comment);
									}
									String pricepertonString = String.valueOf(priceperton);
									System.out.println("pricepertonString:::"+pricepertonString);
									System.out.println("Price Per Tone Is::"+priceperton);
									System.out.println("=================================");
								}catch(Exception rlt1){
									rlt1.printStackTrace();
									System.out.println("Problem 2");
								}
							}
							else{
									String _noPriceperTone="****";
									double _value = Double.parseDouble(_noPriceperTone);
									wastepaperDetail.setPricePerTon(_value);
								}
							//Code For $ Freight CHBK/Deduction Starts From Here Done By Roshan Tailor
							double StandardWeightTon=20.00;
							double chbk;
							double finalchbk;
							double freightInvoiced=2000;
							if(baleWeight>=StandardWeightTon){
								double rightTons=0.0;
								wastepaperDetail.setFreightCHBK(rightTons);
								System.out.println("1");
								
							}else{
								System.out.println("2");
								
								//wastepaperDetail.setFreightInvoiced(freightInvoiced)
								chbk=(StandardWeightTon-baleWeight)/StandardWeightTon;
								finalchbk=chbk*freightInvoiced;
								if(freightInvoiced==0){
									System.out.println("3");
									String _text = "Pending"; 
									double _value = Double.parseDouble(_text);
									wastepaperDetail.setFreightInvoiced(_value);
								}else{
									System.out.println("4");
									wastepaperDetail.setFreightInvoiced(finalchbk);
								}
							}
							//Code For $ Freight CHBK/Deduction Ends Here Done By Roshan Tailor
							
							//Code For $ Grand Total Starts From Here Done By Roshan Tailor 
							//Formula For Grand Total=($ Extention)+(Freight Invoiced $)+(Detention Charges)+($ Freight CHBK/Deduction), this Given By Dinesh Sir

							//Code For $ Grand Total Ends Here Done By Roshan Tailor 
						}catch(Exception rlt1){
							System.out.println("Problem 1");
							rlt1.printStackTrace();
						}
					}
					
				} catch (Exception e) {
					System.out.println("MasterPO not found: "+e.getMessage());
				}
					String master_po=(String)map.get("MasterPO".toUpperCase());
//				Code Ends Here Done By Roshan Tailor Date :- 06/04/2015 MM/DD/YYY Night Shift
				wastepaperDetail.setBales(bale);
				wastepaperDetail.setReleaseNo(releaseNo);
				wastepaperDetail.setNetTons(baleWeight);


				try {
					String sqlPurchase="select [MasterPO],[Vendor],[Trailer],[CarrierID],[PickUpCity],[PickUpState],[WeightDate] from [tblPurchaseHeader] where [ReleaseNumber]=? ";
					List<Map<String, Object>> maps2=jdbcTemplate.queryForList(sqlPurchase,new Object[]{releaseNo});


						
					if(maps2.size()>0 ){
						Map<String, Object> map2=maps2.get(0);
						
						String masterPo=(String) map2.get("MasterPO".toUpperCase());
						String vendor=(String) map2.get("Vendor".toUpperCase());
						String pickUpCity=(String) map2.get("PickUpCity".toUpperCase());
						String pickUpState=(String) map2.get("PickUpState".toUpperCase());
						Date dropDate=(Date)map2.get("WeightDate".toUpperCase());
						String trailer=(String) map2.get("trailer".toUpperCase());
						String carrierID=(String)map2.get("CarrierID".toUpperCase());
						
						try {
							String sqlCarrer="select [CarrierName] from [tlkpCarrier] where [CarrierCode]=?";
							
							String carrier=jdbcTemplate.queryForObject(sqlCarrer, new Object[]{carrierID}, String.class);
							
							wastepaperDetail.setCarrier(carrier);
							
						} catch (Exception e) {
							System.out.println("Carrier code not found="+e.getMessage());
						}
//						Code Starts From Here Done By Roshan Tailor Date :-06/03/2015
						wastepaperDetail.setMasterPO(masterPo);
//						Code Ends Here Done By Roshan Tailor Date :- 06/03/2015
						wastepaperDetail.setVandorName(vendor);
						wastepaperDetail.setTrailerNo(trailer);
						wastepaperDetail.setShippingCity(pickUpCity);
						wastepaperDetail.setShippingState(pickUpState);
						wastepaperDetail.setDroppedDate(dropDate);
						
					}
					
				} catch (Exception e) {
					e.printStackTrace();
					System.out.println("Error in master detail.");
				}

				
				details.add(wastepaperDetail);
				try{
					 final String sqlcopyToMaster="insert into [tblwastepaperdetailreport]"
					 	+ "("
					 	+ "[ReleaseNumber],"
					 	+ "[MasterPO],"
						+ "[VandorName],"
						+ "[DroppedDate],"
						+ "[UnloadedDate],"
						+ "[ItemDiscription],"
						+ "[Bales],"
						+ "[NetTons],"
						+ "[PricePerTon],"
						+ "[Extension],"
						+ "[Carrier],"
						+ "[TrailerNumber],"
						+ "[ShippingCity],"
						+ "[ShippingState],"
						+ "[EstimatedFreight],"
						+ "[FreightInvoiceNumber],"
						+ "[FreightInvoiced],"
						+ "[DetentionCharges],"
						+ "[FreightCHBK],"
						+ "[GrandTotal],"
						+ "[Destination],"
						+ "[Comment] )"
						+ " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
					jdbcTemplate1.update(new PreparedStatementCreator() {
						
						@Override
						public PreparedStatement createPreparedStatement(Connection arg)
								throws SQLException {
							PreparedStatement statement=arg.prepareStatement(sqlcopyToMaster);
							statement.setInt(1, wastepaperDetail.getReleaseNo());
							statement.setString(2, wastepaperDetail.getMasterPO());
							statement.setString(3, wastepaperDetail.getVandorName());
							statement.setTimestamp(4, new Timestamp(wastepaperDetail.getDroppedDate().getTime()));
							statement.setTimestamp(5, new Timestamp(wastepaperDetail.getUnloadedDate().getTime()));
							statement.setString(6, wastepaperDetail.getItemDescription());
							statement.setInt(7, wastepaperDetail.getBales());
							statement.setDouble(8, wastepaperDetail.getNetTons());
							statement.setDouble(9, wastepaperDetail.getPricePerTon());
							statement.setDouble(10, wastepaperDetail.getExtention());
							statement.setString(11, wastepaperDetail.getCarrier());
							statement.setString(12, wastepaperDetail.getTrailerNo());
							statement.setString(13, wastepaperDetail.getShippingCity());
							statement.setString(14, wastepaperDetail.getShippingState());
							statement.setDouble(15, wastepaperDetail.getEstimatedFreight());
							statement.setString(16, wastepaperDetail.getFreightInvoiceNo());
							statement.setDouble(17, wastepaperDetail.getFreightInvoiced());
							statement.setDouble(18, wastepaperDetail.getDetentionCharges());
							statement.setDouble(19, wastepaperDetail.getFreightCHBK());
							statement.setDouble(20, wastepaperDetail.getGrandTotal());
							statement.setString(21, wastepaperDetail.getDestination());
							statement.setString(22, wastepaperDetail.getComment());
							
							return statement;
						}
					});
					
				}catch(Exception e){
					e.printStackTrace();
					System.out.println("Roshan Say's You Have A Probolem In Insert method At WastePaperDaoimp.java");
				}
			}
			
			
			
			calendar.add(Calendar.DATE, 1);
			
		}
		return details;
	}*/


	/**
	 * @param datas 
	 * @param list
	 * @param releaseNo
	 * @return
	 */
	private TempReleaseData fetchDataRelData(List<TempReleaseData> datas, List<Map<String, Object>> list,
			int releaseNo) {
		
		for (Map<String, Object> map : list) {
			double wt=(Double)map.get("BaleWeightT");
			int rel=(Integer)map.get("ReleaseNumber");
			
			
			
		}
		
		
		
		return null;
	}


	/* (non-Javadoc)
	 * @see com.st.wastepaper.dao.WastepaperDao#getAddtomaster(com.st.wastepaper.model.WastepaperDetail)
	 */
	@Override
	@Transactional
	public int getAddtomaster(final WastepaperDetail wastepaperDetail) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		KeyHolder keyHolder=new GeneratedKeyHolder();
		final String sql="insert into tblwastepaperdetailreport"
				+ "([MasterPO],[ReleaseNo],[FreightInvoiceNo],[FreightInvoiced],[DetentionCharges],[Deduction],[Destination],[PricePerTon],[GradeId]) values(?,?,?,?,?,?,?,?,?)";
	   jdbcTemplate.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection arg0)
					throws SQLException {
				PreparedStatement statement=arg0.prepareStatement(sql,new String[] {"ID"});
				statement.setString(1, wastepaperDetail.getMasterPO());
				statement.setInt(2, wastepaperDetail.getReleaseNo());
				statement.setString(3, wastepaperDetail.getFreightInvoiceNo());
				statement.setDouble(4, wastepaperDetail.getFreightInvoiced());
				statement.setDouble(5, wastepaperDetail.getDetentionCharges());
				statement.setDouble(6, wastepaperDetail.getDeduction());
				statement.setString(7, wastepaperDetail.getDestination());
				statement.setDouble(8, wastepaperDetail.getPricePerTon());
				statement.setInt(9, wastepaperDetail.getGradeid());
				return statement;
			}
			
		},keyHolder);
		return keyHolder.getKey().intValue();
	}


	/* (non-Javadoc)
	 * @see com.st.wastepaper.dao.WastepaperDao#checkreleseNumber(int)
	 */
	@Override
	public List<WastepaperDetail> checkreleseNumber(int releaseNo ,int gradeid) {
		List<WastepaperDetail> releaseNumberDetails=new ArrayList<WastepaperDetail>();
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		String sql="select * from [tblwastepaperdetailreport] where [GradeId]=? AND [ReleaseNo]=? ";
		List<Map<String, Object>> releseNumberToCheck= jdbcTemplate.queryForList(sql,new Object[]{gradeid,releaseNo});
		final WastepaperDetail wastepaperDetail=new WastepaperDetail();
		for(Map<String, Object> map:releseNumberToCheck){
			
			int release=(Integer)map.get("ReleaseNo");
			String masterPO=(String)map.get("MasterPO");
			int gradeId=(Integer)map.get("GradeId");
			
			wastepaperDetail.setReleaseNo(release);
			wastepaperDetail.setMasterPO(masterPO);
			wastepaperDetail.setGradeid(gradeId);
			releaseNumberDetails.add(wastepaperDetail);
		}
		return releaseNumberDetails;
	}


	/* (non-Javadoc)
	 * @see com.st.wastepaper.dao.WastepaperDao#addtomasterUpdate(com.st.wastepaper.model.WastepaperDetail)
	 */
	@Override
	public void addtomasterUpdate(final WastepaperDetail wastepaperDetail) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		int releaseNumber=wastepaperDetail.getReleaseNo();
		final String sql="update [tblwastepaperdetailreport] set "
				+"[MasterPO]=?,"
				+"[ReleaseNo]=?,"
				+"[FreightInvoiceNo]=?,"
				+"[FreightInvoiced]=?,"												
				+"[DetentionCharges]=?,"
				+"[Deduction]=?,"
				+"[Destination]=?,"
				+"[PricePerTon]=?,"
				+"[GradeId]=?"
				+ " where [ReleaseNo]=? AND [GradeId]=?";
		
		jdbcTemplate.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection arg0)
					throws SQLException {
				PreparedStatement statement=arg0.prepareStatement(sql);
				
				statement.setString(1, wastepaperDetail.getMasterPO());
				statement.setInt(2, wastepaperDetail.getReleaseNo());
				statement.setString(3, wastepaperDetail.getFreightInvoiceNo());
				statement.setDouble(4, wastepaperDetail.getFreightInvoiced());
				statement.setDouble(5, wastepaperDetail.getDetentionCharges());
				statement.setDouble(6, wastepaperDetail.getDeduction());
				statement.setString(7, wastepaperDetail.getDestination());
				statement.setDouble(8, wastepaperDetail.getPricePerTon());
				statement.setInt(9, wastepaperDetail.getGradeid());
				statement.setInt(10, wastepaperDetail.getReleaseNo());
				statement.setInt(11, wastepaperDetail.getGradeid());

				return statement;
			}
		});
		
	}


	/* (non-Javadoc)
	 * @see com.st.wastepaper.dao.WastepaperDao#getTransferToMaster(java.util.Date, java.util.Date)
	 */
	@Override
	public List<WastepaperDetail> getTransferToMaster(Date sDate, Date eDate) {
		// TODO Auto-generated method stub
		return null;
	}

// Code Starts From Here Done By Roshan Tailor Date :- 07/02/2015 MM/DD/YYYY Night Shift

	/* (non-Javadoc)
	 * @see com.st.wastepaper.dao.WastepaperDao#EditFreight(int)
	 */
	@Override
	public List<WastepaperDetail> EditFreight(int id) {
		List<WastepaperDetail> freightid=new ArrayList<WastepaperDetail>();
		JdbcTemplate jdbcTemplate= new JdbcTemplate(dataSource);
		String sql_query="Select * from tblwastepaperdetailEstimateFreight Where [id]=?";
		System.out.println("sql_query::"+sql_query);
		List<Map<String , Object>> getid=jdbcTemplate.queryForList(sql_query,new Object[]{
			id	
		});
		for(Map<String, Object> map: getid){
			final WastepaperDetail wastepaperDetail=new WastepaperDetail();
			
			int _idEstimatedFreight=(Integer)map.get("ID".toUpperCase());
			String _carrier=(String)map.get("Carrier");
			String _shippingCity=(String)map.get("ShippingCity");
			String _shippingState=(String)map.get("ShippingState");
			double _estimateFreightPrice=(Double)map.get("EstimateFreightPrice");
			
			wastepaperDetail.setId(_idEstimatedFreight);
			wastepaperDetail.setCarrier(_carrier);
			wastepaperDetail.setShippingCity(_shippingCity);
			wastepaperDetail.setShippingState(_shippingState);
			wastepaperDetail.setEstimatedFreight(_estimateFreightPrice);
			freightid.add(wastepaperDetail);
		}
		
		return freightid;
	}


	/* (non-Javadoc)
	 * @see com.st.wastepaper.dao.WastepaperDao#update(com.st.wastepaper.model.WastepaperDetail)
	 */
	@Override
	public void update(final WastepaperDetail wastepaperDetail) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		final String sql="update [tblwastepaperdetailEstimateFreight] set "
				+"[Carrier]=?,"
				+"[ShippingCity]=?,"
				+"[ShippingState]=?,"
				+"[EstimateFreightPrice]=?"
				+ " where [ID]=?";
		
		jdbcTemplate.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection arg0)
					throws SQLException {
				PreparedStatement statement=arg0.prepareStatement(sql);
				statement.setString(1,wastepaperDetail.getCarrier());
				//Rejects Flow Code Starts From Here
				statement.setString(2, wastepaperDetail.getShippingCity());
				statement.setString(3, wastepaperDetail.getShippingState());
				statement.setDouble(4, wastepaperDetail.getEstimatedFreight());
				statement.setInt(5, wastepaperDetail.getId());

				return statement;
			}
		});
		
	}


	/* (non-Javadoc)
	 * @see com.st.wastepaper.dao.WastepaperDao#addNewEstimatedFreight(com.st.wastepaper.model.WastepaperDetail)
	 */
	@Override
	public void addNewEstimatedFreight(final WastepaperDetail wastepaperDetail) {
		// TODO Auto-generated method stub
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		final String sql="insert into tblwastepaperdetailEstimateFreight"
				+ "([Carrier],[ShippingCity],[ShippingState],[EstimateFreightPrice]) values(?,?,?,?)";
	   jdbcTemplate.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection arg0)
					throws SQLException {
				PreparedStatement statement=arg0.prepareStatement(sql);
				statement.setString(1, wastepaperDetail.getCarrier());
				statement.setString(2, wastepaperDetail.getShippingCity());
				statement.setString(3, wastepaperDetail.getShippingState());
				statement.setDouble(4, wastepaperDetail.getEstimatedFreight());
				
				return statement;
			}
			
		});
	}


	/* (non-Javadoc)
	 * @see com.st.wastepaper.dao.WastepaperDao#getWastePaperInBoundByDeliveryData(java.util.Date, java.util.Date)
	 */
	@Override
	public List<WastepaperDetail> getWastePaperInBoundByDeliveryData(
			Date sDate, Date eDate) throws ParseException {

		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		
		JdbcTemplate jdbcTemplate= new JdbcTemplate(dataSourceT);
		List<WastepaperDetail> inboundLoad= new ArrayList<WastepaperDetail>();
		
		
		Calendar calendar=Calendar.getInstance();
		calendar.setTime(sDate);
		
		int days=Days.daysBetween(new DateTime(sDate.getTime()), new DateTime(eDate.getTime())).getDays();
		
		Calendar date=Calendar.getInstance();
		date.setTime(sDate);
		
		for (int i = 0; i <=days; i++) {
			
			Date dateS=calendar.getTime();
			
			MapSqlParameterSource source=new MapSqlParameterSource();
			
			source.addValue("sdate", dateS);
			
			final WastepaperDetail wastepaperDetail=new WastepaperDetail();
			int _totalBalesCount=0;
			int enroute=0;
			int rejected=0;
			int deleted=0;
			wastepaperDetail.setUnloadedDate(dateS);
			
			try{
				
				String sqlForUnloadDetails="select [EntryDate],[LoadStatus],count(*) as balesOnDate from [tblPurchaseHeader] where [EntryDate]=? "
						+ "group by [EntryDate],[LoadStatus]";
				
				List<Map<String, Object>> mapList=new ArrayList<Map<String,Object>>();
				try {
					mapList=jdbcTemplate.queryForList(sqlForUnloadDetails,dateS);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				
				
				if(mapList.size()>0){
					
					for (final Map<String, Object> map1 : mapList) {
							Date unloadDate=(Date)map1.get("EntryDate".toUpperCase());
							String loadStatus=(String)map1.get("LoadStatus".toUpperCase());
							int bales=map1.get("balesondate")==null?0:(Integer)map1.get("balesondate");
							
							_totalBalesCount = _totalBalesCount + bales;
							wastepaperDetail.setTotalbales(_totalBalesCount);
							//Complete,DELETED,Enroute,Rejected,Yard
						if(loadStatus.equalsIgnoreCase("Complete")){
							wastepaperDetail.setBalesondate(bales);
						}if(loadStatus.equalsIgnoreCase("Enroute")){
							enroute=enroute+bales;
							wastepaperDetail.setEnroute(enroute);
						}if(loadStatus.equalsIgnoreCase("Rejected")){
							wastepaperDetail.setBalesondaterejected(bales);
						}if(loadStatus.equalsIgnoreCase("DELETED")){
							wastepaperDetail.setBalesondatedeleted(bales);
						}	
						}
						int finalTotal=wastepaperDetail.getTotalbales()-wastepaperDetail.getEnroute();
						System.out.println(finalTotal);
						wastepaperDetail.setBales(finalTotal);
				}
				}
				
				
			catch(Exception rlt){
				System.out.println("You Have A Problem In WastePaperDaoImp.java at first section.");
				rlt.printStackTrace();
			}
			inboundLoad.add(wastepaperDetail);	
			 calendar.add(Calendar.DATE, 1);
		}
		return inboundLoad;
	}


	/* (non-Javadoc)
	 * @see com.st.wastepaper.dao.WastepaperDao#getWastePaperInBoundByDeliveryData1(java.util.Date, java.util.Date)
	 */
	@Override
	public List<WastepaperDetail> getWastePaperInBoundByDeliveryData1(
			Date sDate, Date eDate) {
		List<WastepaperDetail> freightid1=new ArrayList<WastepaperDetail>();
		JdbcTemplate jdbcTemplate= new JdbcTemplate(dataSourceT);
		String sql1="select [RejectDate],count(*) as balesOnDate from [tblPurchaseHeader] "
				+ "where [UnloadDate] between ? and ? AND (tblPurchaseHeader.LoadStatus)<>'Complete' group by [UnloadDate]";
		List<Map<String , Object>> getid1=jdbcTemplate.queryForList(sql1,new Object[]{
			sDate,eDate	
		});
		for(Map<String, Object> map1: getid1){
			final WastepaperDetail wastepaperDetail=new WastepaperDetail();
			
			Date RejectDate=(Date)map1.get("RejectDate");
			int balesOnDate=(int)map1.get("balesOnDate");
			
			wastepaperDetail.setRejectdate(RejectDate);
			wastepaperDetail.setBalesondate(balesOnDate);
			freightid1.add(wastepaperDetail);
		}
		
		return freightid1;
	}
}

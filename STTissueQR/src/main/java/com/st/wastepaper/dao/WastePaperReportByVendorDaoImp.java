/**
 *Aug 7, 2015
 *WastePaperReportByVendorDaoImp.java
 * TODO
 *com.st.wastepaper.dao
 *WastePaperReportByVendorDaoImp.java
 *Sunil Singh Bora
 */
package com.st.wastepaper.dao;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.st.common.CommonUtil;
import com.st.tracker.model.ProjectionData;
import com.st.wastepaper.model.ByVendor;
import com.st.wastepaper.model.WastepaperDetail;
import com.st.wastepaper.service.WastePaperReportByVendorService;

/**
 * @author roshan
 *
 */
@Repository
public class WastePaperReportByVendorDaoImp implements WastePaperReportByVendorDao {

	@Autowired
	private DataSource dataSource;
	@Autowired
	@Qualifier("dataSourceProduction")
	private DataSource dataSourceP;		
	
	@Override
	public List<ByVendor> vendor() {
		// TODO Auto-generated method stub
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");

		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSourceP);
		String sql="Select VendorName From tblMasterPOHeader Group By VendorName";
		//List<SafetyHousekeepingStdType> housekeepingStdTypes=jdbcTemplate.query(sql, new Object[]{false}, new RowMapper<SafetyHousekeepingStdType>()
		List<ByVendor> vendorList=jdbcTemplate.query(sql,new Object[]{}, new RowMapper<ByVendor>(){

			@Override
			public ByVendor mapRow(ResultSet rs, int arg1)
					throws SQLException {
				ByVendor byVendor=new ByVendor();
				byVendor.setVendorname(rs.getString("VendorName"));
				return byVendor;
			}	
		});
		return vendorList;
	}

	/* (non-Javadoc)
	 * @see com.st.wastepaper.dao.WastePaperReportByVendorDao#loadVendorData(java.util.Date, java.util.Date, java.lang.String)
	 */
	@Override
	public List<WastepaperDetail> loadVendorData(Date sDate, Date eDate,String vendorname) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");

		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSourceP);
		JdbcTemplate jdbcTemplate1=new JdbcTemplate(dataSource);
		
		List<WastepaperDetail> details=new ArrayList<WastepaperDetail>();
		
		//if Condition Starts From Here For All Vendor's List, To Get 
		if(vendorname==""){
			int days=CommonUtil.getDaysDiffernce(sDate, eDate);
			
			Calendar calendar=Calendar.getInstance();
			calendar.setTime(sDate);
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
					
					int releaseNo=(Integer)map.get("ReleaseNumber".toUpperCase());
//					double baleWeight=(Double)map.get("BaleWeightT".toUpperCase());
					double baleWeight=(Double)map.get("BaleWeightT")==null?0:(Double)(map.get("BaleWeightT"));
					int gradeCode=(Integer)map.get("GradeCode".toUpperCase());
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
										String sqlLineNumber="Select [LineNumber] AS LinePath from [tblMasterPODetailCity] Where [MasterPO]=? AND [City]=? AND [State]=?";
										List<Map<String, Object>> lineNumbers=new ArrayList<Map<String,Object>>();
										lineNumbers=jdbcTemplate.queryForList(sqlLineNumber, new Object[]{
												MasterPO,
												_city,
												_state
										});
										if(lineNumbers.size()>0){
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
										}else{
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
														double WeightT=(Double)mul_re_fre.get("WeightT")==null?0:(Double)(mul_re_fre.get("WeightT"));
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
											}else{
												wastepaperDetail.setFreightCHBK(finalchbk);
											}
										}
									}else{
										double FreightInvoiced=wastepaperDetail.getFreightInvoiced();
										if(FreightInvoiced==0 && CommonUtil.round(baleWeight, 2)<20){
											String _text = "Pending"; 
											wastepaperDetail.setFreightCHBKPending(_text);
										}else{
											
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
//					Code Ends Here Done By Roshan Tailor Date :- 06/04/2015 MM/DD/YYY Night Shift
					wastepaperDetail.setBales(bale);
					wastepaperDetail.setReleaseNo(releaseNo);
					wastepaperDetail.setNetTons(CommonUtil.round(baleWeight, 2));


					try {
						String sqlPurchase="select [MasterPO],[Vendor],[Trailer],[CarrierID],[PickUpCity],[PickUpState],[WeightDate],[UnloadDate] from [tblPurchaseHeader] where [ReleaseNumber]=? ";
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
											 baleWeightTemp=(Double)list1.get("BaleWeightT")==null?0:(Double)(list1.get("BaleWeightT"));
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
													baleWeightTotal=(Double)totalBaleWeight1.get("WeightT")==null?0:(Double)(totalBaleWeight1.get("WeightT"));
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
									TW_release=CommonUtil.round((Double)TW.get("BaleWeightT"),2);
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
					
					Collections.sort(details, new Comparator<WastepaperDetail>() {
						@Override
						public int compare(WastepaperDetail arg0, WastepaperDetail arg1) {
							return new String(arg0.getVandorName()).compareTo(arg1.getVandorName());
						}
					});
					details.add(wastepaperDetail);
					
				}
				calendar.add(Calendar.DATE, 1);
				System.out.println("Loop Runing In Waste Paper Detailed Report "+loopCount+" Times.");	
				loopCount++;
			}
			}
		//Else Condition Starts From Here If Want To See Only Single vendor Details
		else{
			int days=CommonUtil.getDaysDiffernce(sDate, eDate);
			
			Calendar calendar=Calendar.getInstance();
			calendar.setTime(sDate);
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
					
					BigDecimal d = BigDecimal.ZERO;
					d= (BigDecimal) (map.get("ReleaseNumber")==null?0:(BigDecimal)(map.get("ReleaseNumber")));
					int releaseNo = d.intValueExact();
					
					
//					double baleWeight=(Double)map.get("BaleWeightT".toUpperCase());
					//double baleWeight=(Double)map.get("BaleWeightT")==null?0:(Double)(map.get("BaleWeightT"));
					BigDecimal d1 = BigDecimal.ZERO;
					d1= (BigDecimal) (map.get("BaleWeightT")==null?0:(BigDecimal)(map.get("BaleWeightT")));
					double baleWeight = d1.doubleValue(); 
					
					
					//int gradeCode=(Integer)map.get("GradeCode".toUpperCase());
					BigDecimal dd = BigDecimal.ZERO;
					dd= (BigDecimal) (map.get("GradeCode")==null?0:(BigDecimal)(map.get("GradeCode")));
					int gradeCode = dd.intValueExact();
					
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
										String sqlLineNumber="Select [LineNumber] AS LinePath from [tblMasterPODetailCity] Where [MasterPO]=? AND [City]=? AND [State]=?";
										List<Map<String, Object>> lineNumbers=new ArrayList<Map<String,Object>>();
										lineNumbers=jdbcTemplate.queryForList(sqlLineNumber, new Object[]{
												MasterPO,
												_city,
												_state
										});
										if(lineNumbers.size()>0){
											for(Map<String, Object> lines:lineNumbers){
												//int _lineNumberForPO=(int)lines.get("LinePath");
												
												BigDecimal dLine = BigDecimal.ZERO;
												dLine= (BigDecimal) (lines.get("LinePath")==null?0:(BigDecimal)(lines.get("LinePath")));
												int _lineNumberForPO = dLine.intValueExact();
												
												try{
													/*String sqlPricePerTon="SELECT sum(IIF(ISNULL(Rate),0,Rate)) as TotalPrizePerTon  FROM tblMasterPODetail where [MasterPO]=? AND [GradeCode]=? AND [LineNumber]=?";*/
													
													String sqlPricePerTon="SELECT ISNULL ( sum(ISNULL(Rate,0)) , 0 )  as TotalPrizePerTon  FROM tblMasterPODetail where [MasterPO]=? AND [GradeCode]=? AND [LineNumber]=?";
													
													List<Map<String, Object>> priceperton=new ArrayList<Map<String,Object>>();
													priceperton=jdbcTemplate.queryForList(sqlPricePerTon, new Object[]{
															masterpo,
															gradeCode,
															_lineNumberForPO
															});
													if(priceperton.size()>0){
														for(Map<String, Object> TonAndCmt: priceperton){
															//double price=(Double)TonAndCmt.get("TotalPrizePerTon")==null?0:(Double)(TonAndCmt.get("TotalPrizePerTon"));
															
															BigDecimal dt = BigDecimal.ZERO;
															dt= (BigDecimal) (TonAndCmt.get("TotalPrizePerTon")==null?0:(BigDecimal)(TonAndCmt.get("TotalPrizePerTon")));
															double price = dt.doubleValue(); 
															
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
										}else{
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
														double WeightT=(Double)mul_re_fre.get("WeightT")==null?0:(Double)(mul_re_fre.get("WeightT"));
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
											}else{
												wastepaperDetail.setFreightCHBK(finalchbk);
											}
										}
									}else{
										double FreightInvoiced=wastepaperDetail.getFreightInvoiced();
										if(FreightInvoiced==0 && CommonUtil.round(baleWeight, 2)<20){
											String _text = "Pending"; 
											wastepaperDetail.setFreightCHBKPending(_text);
										}else{
											
										}
									}
								}catch(Exception rlt){
									System.out.println("Roshan Say's,You Have Problem In WastePaperDaoImp.java");
									rlt.printStackTrace();
								}
								 
								
								
							}catch(Exception rlt1){
								System.out.println("Problem 1");
								rlt1.printStackTrace();
							}
						}
						
					} catch (Exception e) {
						System.out.println("MasterPO not found: "+e.getMessage());
					}
					String master_po=(String)map.get("MasterPO".toUpperCase());
//					Code Ends Here Done By Roshan Tailor Date :- 06/04/2015 MM/DD/YYY Night Shift
					wastepaperDetail.setBales(bale);
					wastepaperDetail.setReleaseNo(releaseNo);
					wastepaperDetail.setNetTons(CommonUtil.round(baleWeight, 2));


					try {
						String sqlPurchase="select [MasterPO],[Vendor],[Trailer],[CarrierID],[PickUpCity],[PickUpState],[WeightDate],[UnloadDate] from [tblPurchaseHeader] where [ReleaseNumber]=? ";
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
											 
											 	BigDecimal de = BigDecimal.ZERO;
												de= (BigDecimal) (list1.get("BaleWeightT")==null?0:(BigDecimal)(list1.get("BaleWeightT")));
												baleWeightTemp = de.doubleValue(); 
												
											 
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
													
													BigDecimal du = BigDecimal.ZERO;
													du= (BigDecimal) (totalBaleWeight1.get("WeightT")==null?0:(BigDecimal)(totalBaleWeight1.get("WeightT")));
													baleWeightTotal = du.doubleValue(); 
													
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
										
									}
								
								}catch(Exception rlt){
									System.out.println("Roshan Says, You Have An Error in WastePaperDoaImp.java When Finding The Size Of List");
									rlt.printStackTrace();
								}
								//List Code Ends Here
								
								
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
									
									BigDecimal dr = BigDecimal.ZERO;
									dr= (BigDecimal) (TW.get("BaleWeightT")==null?0:(BigDecimal)(TW.get("BaleWeightT")));
									TW_release = CommonUtil.round(dr.doubleValue(), 2); 
									
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
					String vandor=wastepaperDetail.getVandorName();
					if(vandor.equalsIgnoreCase(vendorname)){
						details.add(wastepaperDetail);
					}else{
						
					}
				}
				calendar.add(Calendar.DATE, 1);
				System.out.println("Loop Runing In Waste Paper Detailed Report "+loopCount+" Times.");	
				loopCount++;
			
			

			}

		}
		return details;

	}
}
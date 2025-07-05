/**
 *Mar 2, 2016
 *TransferPricePerTonDataDaoImp.java
 * TODO
 *com.st.wastepaper.dao
 *TransferPricePerTonDataDaoImp.java
 *Sunil Singh Bora
 */
package com.st.wastepaper.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.st.common.CommonUtil;
import com.st.wastepaper.model.WastepaperDetail;

/**
 * @author roshan
 *
 */
@Repository
public class TransferPricePerTonDataDaoImp implements TransferPricePerTonDataDao{

	@Autowired
	@Qualifier("dataSourceTracker")
	private DataSource dataSourceT;
	
	@Autowired
	private DataSource dataSource;
	
	/* (non-Javadoc)
	 * @see com.st.wastepaper.dao.TransferPricePerTonDataDao#getTransferAbleData(java.util.Date, java.util.Date)
	 */
	@Override
	public List<WastepaperDetail> getTransferAbleData(Date sdate, Date edate) {
		// TODO Auto-generated method stub
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSourceT);
		JdbcTemplate jdbcTemplate1=new JdbcTemplate(dataSource);
		
		List<WastepaperDetail> details=new ArrayList<WastepaperDetail>();
		
		int days=CommonUtil.getDaysDiffernce(sdate, edate);
		
		Calendar calendar=Calendar.getInstance();
		calendar.setTime(sdate);
		int loopCount=1;
		
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
								final WastepaperDetail wastepaperDetail=new WastepaperDetail();
								wastepaperDetail.setUnloadedDate(dateS);
								
								//int releaseNo=(Integer)map.get("ReleaseNumber".toUpperCase());
								BigDecimal d1 = BigDecimal.ZERO;
								d1= (BigDecimal) (map.get("ReleaseNumber")==null?0:(BigDecimal)(map.get("ReleaseNumber")));
								int releaseNo=d1.intValueExact();
								
								//int gradeCode=(Integer)map.get("GradeCode".toUpperCase());
								BigDecimal d2 = BigDecimal.ZERO;
								d2= (BigDecimal) (map.get("GradeCode")==null?0:(BigDecimal)(map.get("GradeCode")));
								int gradeCode=d2.intValueExact();
								
								
								String sqlGrade="select [Grade] from [tlkpGrade] where [GradeCode]=?";
							
								try {
									String grade=jdbcTemplate.queryForObject(sqlGrade,new Object[]{gradeCode}, String.class);
									wastepaperDetail.setItemDescription(grade);
									wastepaperDetail.setGradeid(gradeCode);
								} catch (Exception e) {
									System.out.println("Grade Name not found: "+e.getMessage());
								}
								
								
								try {
									String sqlmasterPO="select [MasterPO] AS PO,[UnLoadComment] AS Comment, [PickUpCity] AS City, [PickUpState] AS State from [tblPurchaseHeader] where [ReleaseNumber]=?";
									List<Map<String, Object>> masterPO=jdbcTemplate.queryForList(sqlmasterPO,new Object[]{releaseNo});
									for(Map<String, Object> masterponcomment:masterPO){
										String masterpo=(String)masterponcomment.get("PO");
										String _city=(String)masterponcomment.get("City");
										String _state=(String)masterponcomment.get("State");
										wastepaperDetail.setMasterPO(masterpo);
										
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
															BigDecimal d3 = BigDecimal.ZERO;
															d3= (BigDecimal) (lines.get("LinePath")==null?0:(BigDecimal)(lines.get("LinePath")));
															int _lineNumberForPO=d3.intValueExact();
															
															try{
																/*String sqlPricePerTon="SELECT sum(IIF(ISNULL(Rate),0,Rate)) as TotalPrizePerTon  FROM tblMasterPODetail where [MasterPO]=? AND [GradeCode]=? AND [LineNumber]=?";*/
																String sqlPricePerTon="SELECT ISNULL ( sum(ISNULL(Rate,0)) , 0 ) as TotalPrizePerTon  FROM tblMasterPODetail where [MasterPO]=? AND [GradeCode]=? AND [LineNumber]=?";
																
																List<Map<String, Object>> priceperton=new ArrayList<Map<String,Object>>();
																priceperton=jdbcTemplate.queryForList(sqlPricePerTon, new Object[]{
																		masterpo,
																		gradeCode,
																		_lineNumberForPO
																		});
																if(priceperton.size()>0){
																	for(Map<String, Object> TonAndCmt: priceperton){
																		//double price=(Double)TonAndCmt.get("TotalPrizePerTon")==null?0:(Double)(TonAndCmt.get("TotalPrizePerTon"));
																		BigDecimal d4 = BigDecimal.ZERO;
																		d4= (BigDecimal) (TonAndCmt.get("TotalPrizePerTon")==null?0:(BigDecimal)(TonAndCmt.get("TotalPrizePerTon")));
																		double price=d4.doubleValue();
																		
																		wastepaperDetail.setPricePerTon(price);
																		}
																}
															}catch(Exception rlt1){
																rlt1.printStackTrace();
																System.out.println("Problem 2");
															}
														}
													}
													
												}catch(Exception rlt){
													System.out.println("You have a problem in try block ,when finding Line Number");
													rlt.printStackTrace();
												}
											}
											
										}catch(Exception rlt1){
											System.out.println("Problem 1");
											rlt1.printStackTrace();
										}
									}
									
								} catch (Exception e) {
									System.out.println("MasterPO not found: "+e.getMessage());
								}
		wastepaperDetail.setReleaseNo(releaseNo);
		details.add(wastepaperDetail);
								
				}
		calendar.add(Calendar.DATE, 1);
		System.out.println("Loop Runing In Waste Paper Detailed Report "+loopCount+" Times.=>(TransferPricePerTonDataDaoImp.java)");	
		loopCount++;
		}
		return details;
	}

	/* (non-Javadoc)
	 * @see com.st.wastepaper.dao.TransferPricePerTonDataDao#save(com.st.wastepaper.model.WastepaperDetail)
	 */
	@Override
	public int save(final WastepaperDetail detail) {
		// TODO Auto-generated method stub
		JdbcTemplate jdbcTemplate1=new JdbcTemplate(dataSource);
		KeyHolder keyHolder=new GeneratedKeyHolder();
		
		String poNumber=detail.getMasterPO();
		int releaseNumber=detail.getReleaseNo();
		double pricePerTon=detail.getPricePerTon();
		int gradeId=detail.getGradeid();
		
		try{
			String sql="select * from [tblwastepaperdetailreport] where [MasterPO]=? AND [ReleaseNo]=? AND [GradeId]=? ";
			List<Map<String, Object>> map=jdbcTemplate1.queryForList(sql,new Object[]{poNumber,releaseNumber,gradeId});
			
			if(map.size()>0){
				System.out.println("Present Into Data Base.");
			}else{
				System.out.println("Not Present Into Data Base.");
				final String sql1="insert into tblwastepaperdetailreport ([MasterPO],[ReleaseNo],[FreightInvoiceNo],[FreightInvoiced],[DetentionCharges],[Deduction],[Destination],[PricePerTon],[GradeId]) values(?,?,?,?,?,?,?,?,?)";
				jdbcTemplate1.update(new PreparedStatementCreator() {
					
					@Override
					public PreparedStatement createPreparedStatement(Connection arg0)
							throws SQLException {
						PreparedStatement statement=arg0.prepareStatement(sql1,new String[] {"ID"});
						statement.setString(1, detail.getMasterPO());
						statement.setInt(2, detail.getReleaseNo());
						statement.setString(3, detail.getFreightInvoiceNo());
						statement.setDouble(4, detail.getFreightInvoiced());
						statement.setDouble(5, detail.getDetentionCharges());
						statement.setDouble(6, detail.getDeduction());
						statement.setString(7, detail.getDestination());
						statement.setDouble(8, detail.getPricePerTon());
						statement.setInt(9, detail.getGradeid());
						return statement;
					}
					
				},keyHolder);
			}
		}catch(Exception rlt){
			System.out.println("You Have An Error In TransferPricePerTonDataDaoImp.java.. Contact To Roshan ");
			rlt.printStackTrace();
		}
		return 0;
	}

}

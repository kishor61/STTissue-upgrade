
package com.st.productionpm5.dao;

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
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.sql.DataSource;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.joda.time.Days;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.st.common.CommonUtil;
import com.st.common.DatabaseUtil;
import com.st.common.exception.ProductionException;
import com.st.convertingline.model.ConvertingLine;
import com.st.efficiency.dao.EfficiencyDao;
import com.st.efficiency.model.Efficiency;
import com.st.productionpm5.model.BillofLadingHeaderDetailPM5;
import com.st.productionpm5.model.MachineProductionPM5;
import com.st.productionpm5.model.WrapProductionRedCodePM5;
import com.st.productionpm5.model.WrapperProductionPM5;
import com.st.wastepaper.model.WastepaperDetail;

/**
 * @author sbora
 *
 */
@Repository
public class WrapperProductionDaoImpPM5 implements WrapperProductionDaoPM5 {
	
	private static final Logger logger=LoggerFactory.getLogger(WrapperProductionDaoImpPM5.class);
	
	@Autowired
	private JdbcTemplate dataSourceProductionTemplate;
	
	@Autowired
	private EfficiencyDao efficiencyDao;
	
	@Autowired
	private JdbcTemplate dataSourceQRTTemplate;

	@Override
	public List<WrapperProductionPM5> getWrapperProductions(Date sdate, Date edate) throws ProductionException {
		//Cold Query With Old Table tlkpGradeCode
		/*String sql="select "
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
				+ " And "
				+ " w.[WrapperNumber] <> 'ZZZ' "
				+ " order by w.[DateTimeEntered]";*/
		
		//New Query With New Table tlkpGradeCodeTBD
		String sql="select "
		+ " w.[WhiteWeight],"
		+ " w.[RedWeight],"
		+ " w.[RejectWeight], "
		+ " w.[Customer],"
		+ "	w.[GradeCode] "
		+ " from [tblWrapperProduction] w,tlkpGradeCodeTBD AS g "
		+ " where "
		+ " (w.[DateTimeEntered] between ? and  ?) "
		+ " And "
		+ " (g.[CustCode]=w.[CustomerGradeCode]) "
		+ " And "
		+ " (g.[GradeCode]=w.[GradeCode]) "
		+ " And "
		+ " w.[WrapperNumber] <> 'ZZZ' AND w.[WrapperNumber]='WR5' "
		+ " order by w.[DateTimeEntered]";
	//	System.out.println(sql);
		
		List<WrapperProductionPM5> wrapperProductions=null;
		try {
			wrapperProductions=dataSourceProductionTemplate.query(sql,
					new Object[]{
						new Timestamp(sdate.getTime()),
						new Timestamp(edate.getTime())
					}, 
					new RowMapper<WrapperProductionPM5>(){

						@Override
						public WrapperProductionPM5 mapRow(ResultSet rs, int arg1)
								throws SQLException {
							
							WrapperProductionPM5 wrapperProduction=new WrapperProductionPM5();
							wrapperProduction.setWhiteWeight(rs.getDouble("WhiteWeight"));
							wrapperProduction.setRedWeight(rs.getDouble("RedWeight"));
							wrapperProduction.setRejectWeight(rs.getDouble("RejectWeight"));
							wrapperProduction.setCustomer(rs.getString("Customer"));
							wrapperProduction.setGradeCode(rs.getString("GradeCode"));
							
							return wrapperProduction;
						}
				
					});
		} catch (Exception e) {
			throw new ProductionException(e);
		}
		
		return wrapperProductions;
	}


	
	@Override
	public double getTrageTons(List<String> gradeCodes) throws ProductionException {
		Double targetTons=new Double(0);
		
		if(gradeCodes.size()>0){
			
			String sql="SELECT  max([TBDRate]) "
					+ " FROM [tlkpGradeCode] "
					+ " where "
					+ " [GradeCode] in (";
				for (String string : gradeCodes) {
					sql+="'"+string+"',";
				}		
			
					sql+= ")";
			
			
			
			try {
				targetTons=dataSourceProductionTemplate.queryForObject(sql, Double.class);
				
				if(targetTons==null){
					targetTons=(double) 0;
				}
				
			} catch (Exception e) {
				throw new ProductionException(e);
			}
			
		}
		
		return targetTons;
	}



	/* (non-Javadoc)
	 * @see com.st.production.dao.WrapperProductionDao#getWrapperProductionsByMonth(java.util.Date, java.util.Date)
	 */
	@Override
	public List<WrapperProductionPM5> getWrapperProductionsByMonth(Date sdate,
			Date edate) throws ProductionException {
		
		String sql="SELECT "
				+ "Sum(w.WhiteWeight) AS [WhiteWeight], "
				+ "Sum(w.RedWeight) AS [RedWeight], "
				+ "Sum(w.RejectWeight) AS [RejectWeight], "
				+ "w.GradeCode,"
				+ " g.[TBDRate] "
				+ " FROM "
				+ " tblWrapperProduction AS w, tlkpGradeCodeTBD AS g "
				+ " WHERE (w.[DateTimeEntered] Between ? And ?) "
				+ " And "
				+ " (g.[CustCode]=w.[CustomerGradeCode]) "
				+ " And "
				+ " (g.[GradeCode]=w.[GradeCode]) "
				+ " And "
				+ " w.[WrapperNumber] <> 'ZZZ'  AND w.[WrapperNumber]='WR5' "
				+ " GROUP BY w.[GradeCode], g.[TBDRate] ";
		
		
		//System.out.println(sql);
		
		List<WrapperProductionPM5> wrapperProductions=null;
		try {
			wrapperProductions=dataSourceProductionTemplate.query(sql,
					new Object[]{
						new Timestamp(sdate.getTime()),
						new Timestamp(edate.getTime())
					}, 
					new RowMapper<WrapperProductionPM5>(){
						@Override
						public WrapperProductionPM5 mapRow(ResultSet rs, int rowNum) throws SQLException {
							WrapperProductionPM5 wrapperProduction=new WrapperProductionPM5();
							wrapperProduction.setWhiteWeight(rs.getDouble("WhiteWeight"));
							wrapperProduction.setRedWeight(rs.getDouble("RedWeight"));
							wrapperProduction.setRejectWeight(rs.getDouble("RejectWeight"));
							wrapperProduction.setGradeCode(rs.getString("GradeCode"));
							wrapperProduction.setTbdRate(rs.getDouble("TBDRate"));
							
							return wrapperProduction;
						}
				
					});
			
		} catch (Exception e) {
			throw new ProductionException(e);
		}
		return wrapperProductions;
	}




	/* (non-Javadoc)
	 * @see com.st.production.dao.WrapperProductionDao#getWrapperProductions(java.util.Date, java.util.Date, java.lang.String)
	 */
	@Override
	public List<WrapperProductionPM5> getWrapperProductions(Date sdate,
			Date edate, String shift) throws ProductionException {
	Object[] param=null;
	String sql="select "
			+ " [WhiteWeight],"
			+ " [RedWeight],"
			+ " [RejectWeight], "
			+ " [Comment],"
			+ " [Shift] "
			+ " from [tblWrapperProduction]"
			+ " where "
			+ " ([DateTimeEntered] between ? and ?) "
			+ " and "
			+ "[WrapperNumber] <> 'ZZZ'  AND [WrapperNumber]='WR5' ";
			
			if(shift.equalsIgnoreCase("Day")|| shift.equalsIgnoreCase("Night")){
				sql+=" and [Shift]=? ";
				param=new Object[]{
						new Timestamp(sdate.getTime()),
						new Timestamp(edate.getTime()),
						shift
					};
			}else{
				param=new Object[]{
						new Timestamp(sdate.getTime()),
						new Timestamp(edate.getTime())
					};
			}
			
			sql+=" order by [DateTimeEntered]";
			List<WrapperProductionPM5> wrapperProductions=null;
			
		//	System.out.println(sql);
			
		try {
			wrapperProductions=dataSourceProductionTemplate.query(sql,
					param, 
					new RowMapper<WrapperProductionPM5>(){

						@Override
						public WrapperProductionPM5 mapRow(ResultSet rs, int arg1)
								throws SQLException {
							
							WrapperProductionPM5 wrapperProduction=new WrapperProductionPM5();
							wrapperProduction.setWhiteWeight(rs.getDouble("WhiteWeight"));
							wrapperProduction.setRedWeight(rs.getDouble("RedWeight"));
							wrapperProduction.setRejectWeight(rs.getDouble("RejectWeight"));
							wrapperProduction.setComment(rs.getString("Comment"));
							wrapperProduction.setShift(rs.getString("Shift"));
							
							return wrapperProduction;
						}
				
					});
		} catch (Exception e) {
			throw new ProductionException(e);
		}
		
		return wrapperProductions;
	}




	@Override
	public List<WrapperProductionPM5> getWrapperProductionRedCode(Date sdate,
			Date edate) throws ProductionException {
		Object[] param=new Object[]{
						new Timestamp(sdate.getTime()),
						new Timestamp(edate.getTime())
					};
		String sql="select "
				+ "c.[RedCode],p.[GradeCode], "
				+ " Sum(p.RedWeight) AS RedWeightTotal, "
				+ " Sum(p.RejectWeight) AS RejectWeightTotal "
				+ " FROM tblWrapperProduction AS p, tlkpRedCode AS c "
				+ " WHERE "
				+ " (p.[RedWeight]>0 or p.[RejectWeight]>0) "
				+ " AND "
				+ " (p.DateTimeEntered Between ? And ? ) "
				+ " AND "
				+ " c.[RedCode]=p.[RedCode] "
				+ " GROUP BY c.[RedCode],p.[GradeCode]  "
				+ " ORDER BY c.[RedCode],p.[GradeCode]  ";

			List<WrapperProductionPM5> wrapperProductions=null;
			try {
				wrapperProductions=dataSourceProductionTemplate.query(sql,
						param, 
						new RowMapper<WrapperProductionPM5>(){

							@Override
							public WrapperProductionPM5 mapRow(ResultSet rs, int arg1)
									throws SQLException {
								
								WrapperProductionPM5 wrapperProduction=new WrapperProductionPM5();

								wrapperProduction.setRedWeight(rs.getDouble("RedWeightTotal"));
								wrapperProduction.setRejectWeight(rs.getDouble("RejectWeightTotal"));
								wrapperProduction.setRedCode(rs.getString("RedCode"));
								wrapperProduction.setGradeCode(rs.getString("GradeCode"));
								return wrapperProduction;
							}
					
						});
			} catch (Exception e) {
				throw new ProductionException(e.getCause());
			}
			
			return wrapperProductions;
	}




	@Override
	public List<WrapProductionRedCodePM5> getRedCodes() throws ProductionException {
		String sql="SELECT [RedCode], [RedCodeDescription] "
				+ " FROM tlkpRedCode";

		List<WrapProductionRedCodePM5> wrapperProductions=null;
			try {
				wrapperProductions=dataSourceProductionTemplate.query(sql,
						new RowMapper<WrapProductionRedCodePM5>(){

							@Override
							public WrapProductionRedCodePM5 mapRow(ResultSet rs, int arg1)
									throws SQLException {
								
								WrapProductionRedCodePM5 redCode=new WrapProductionRedCodePM5();
								redCode.setRedCode(rs.getString("RedCode"));	
								redCode.setRedCodeDesc(rs.getString("RedCodeDescription"));
								return redCode;
							}
					
						});
			} catch (Exception e) {
				throw new ProductionException(e.getCause());
			}
		return wrapperProductions;
	}



	/* (non-Javadoc)
	 * @see com.st.production.dao.WrapperProductionDao#getCustomerFromWrapper()
	 */
	@Override
	public List<String> getCustomerFromWrapper() {
		
		String sql="SELECT  distinct([Customer]) FROM [tblWrapperProduction] where [Customer] Is Not Null";
		
		List<String> list=dataSourceProductionTemplate.queryForList(sql, String.class);
		
		return list;
	}



	/* (non-Javadoc)
	 * @see com.st.production.dao.WrapperProductionDao#getInventoryWrapperProductions(java.util.Date, java.util.Date, java.lang.String)
	 */
	@Override
	public List<WrapperProductionPM5> getInventoryWrapperProductions(Date date,String customer) {
		
	
		Date nDate=CommonUtil.getDateTime(date, new Date());
		
		
		String sql="SELECT "
				+ "w.[Customer],w.[GradeCode],w.[CustomerGradeCode],w.[CoreSize],w.[RollWidth],w.[Diameter], sum(w.[WhiteWeight]/2000 ) as [Weight],count(*) as [Count] "
				+ " FROM [tblWrapperProduction] w "
				+ " where "
				+ " w.[DateTimeEntered] < ? "
				+ " and "
				+ " w.[Customer]=? "
				+ " group by w.[Customer],w.[GradeCode],w.[CustomerGradeCode],w.[CoreSize],w.[RollWidth],w.[Diameter] "
				+ "";
		
		//System.out.println(sql);
		
		List<WrapperProductionPM5> productions=dataSourceProductionTemplate.query(sql, new Object[]{
				new Timestamp(nDate.getTime()),
				customer
		}, new RowMapper<WrapperProductionPM5>(){

			@Override
			public WrapperProductionPM5 mapRow(ResultSet rs, int arg1)
					throws SQLException {
				WrapperProductionPM5 production=new WrapperProductionPM5();
				production.setCustomer(rs.getString("Customer"));
				production.setGradeCode(rs.getString("GradeCode"));
				production.setCustomerGradeCode(rs.getString("CustomerGradeCode"));
				production.setCoreSize(rs.getString("CoreSize"));
				production.setRollWidth(rs.getString("RollWidth"));
				production.setDiameter(rs.getString("Diameter"));
			//	production.setPly(rs.getInt("Ply"));
				production.setWhiteWeight(rs.getDouble("Weight"));
				production.setRollCount(rs.getInt("Count"));
				
				
				String gradeCode=production.getGradeCode();
				/*if(gradeCode!=null && gradeCode.length()>7){
					String color=gradeCode.substring(gradeCode.indexOf("-")+1, gradeCode.length());
					color=color.substring(0,color.indexOf("-"));
					
					if(color.equalsIgnoreCase("98")){
						production.setColor("Kraft");
					}else{
						production.setColor("Bleached");
					}
				}
				*/
				if(gradeCode!=null && gradeCode.length()>7){
					
					if(gradeCode.contains("-98-")){
						production.setColor("Kraft");
					}else{
						production.setColor("Bleached");
					}
					
					
					if(gradeCode.contains("-1-")){
						production.setShortType("Napkin");
					}else if(gradeCode.contains("-2-")){
						production.setShortType("Bath Tissue");
					}else if(gradeCode.contains("-3-")){
						production.setShortType("Towel");
					}
					
				}
				
				
				
				//
				String sql2="SELECT d.[PONumber],d.[ShippingNumber],d.[Grade],d.[Comment], sum(d.[RollWeight])/2000 as [RollWt],count(*) as [Count] "
						+ " FROM [tblBillofLadingDetail] d ,[tblBillofLadingHeader] h "
						+ " where "
						+ " d.[CustCode]=? "
						+ " and "
						+ " d.[GradeCode]=? "
						+ " and "
						+ " h.[PONumber]=d.[PONumber] "
						+ " and "
						+ " h.[ShippingNumber]=d.[ShippingNumber] "
						+ " and "
						+ " h.[Status]='Shipped' "
						+ " group by d.[PONumber],d.[Grade],d.[Comment],d.[ShippingNumber] ";
				
				
			//	System.out.println(sql2);
				
				List<BillofLadingHeaderDetailPM5> details=dataSourceProductionTemplate.query(sql2, new Object[]{
						production.getCustomerGradeCode(),
						production.getGradeCode()
					}, new RowMapper<BillofLadingHeaderDetailPM5>(){

						@Override
						public BillofLadingHeaderDetailPM5 mapRow(ResultSet rs,
								int arg1) throws SQLException {
							BillofLadingHeaderDetailPM5 detail=new BillofLadingHeaderDetailPM5();
							
							detail.setPoNumber(rs.getString("PONumber"));
							detail.setGrade(rs.getString("Grade"));
							detail.setComment(rs.getString("Comment"));
							detail.setRollWeight(rs.getDouble("RollWt"));
							detail.setCountRoll(rs.getInt("Count"));
							detail.setShippingNumber(rs.getDouble("ShippingNumber"));
							
							return detail;
						}
					
				});
				
				
				
				Set<String> pos=new HashSet<String>();
				Set<String> comments=new HashSet<String>();
				Set<String> grades=new HashSet<String>();
				Set<String> shippingNos=new HashSet<String>();
				
				double rollWeight=0;
				int rollCount=0;
				for (BillofLadingHeaderDetailPM5 billofLadingHeaderDetail : details) {
					if(StringUtils.isNotEmpty(billofLadingHeaderDetail.getPoNumber())){
						pos.add(billofLadingHeaderDetail.getPoNumber());
					}
					if(StringUtils.isNotEmpty(billofLadingHeaderDetail.getGrade())){
						grades.add(billofLadingHeaderDetail.getGrade());			
					}
					if(StringUtils.isNotEmpty(billofLadingHeaderDetail.getComment())){
						comments.add(billofLadingHeaderDetail.getComment());
					}
					
					if(billofLadingHeaderDetail.getShippingNumber()!=0){
						shippingNos.add(new Long((long)Math.floor(billofLadingHeaderDetail.getShippingNumber())).toString());
					}
					
					
					
					rollWeight+=billofLadingHeaderDetail.getRollWeight();
					rollCount+=billofLadingHeaderDetail.getCountRoll();
				}
				
				production.setWhiteWeight(production.getWhiteWeight()-rollWeight);
				production.setRollCount(production.getRollCount()-rollCount);
				
				production.setComment(StringUtils.join(comments, ","));
				production.setPoNumber(StringUtils.join(pos,","));
				production.setGrade(StringUtils.join(grades,","));
				production.setShippingNo(StringUtils.join(shippingNos,","));
				
				return production;
			}
			
		});
		
		return productions;
	}



	/* (non-Javadoc)
	 * @see com.st.production.dao.WrapperProductionDao#getWrapperProductionNoneRedCode(java.util.Date, java.util.Date)
	 */
	@Override
	public List<WrapperProductionPM5> getWrapperProductionNoneRedCode(Date sdate,
			Date edate) throws ProductionException {
		Object[] param=new Object[]{
						new Timestamp(sdate.getTime()),
						new Timestamp(edate.getTime())
					};
		String sql="select "
				+ "p.[GradeCode], "
				+ " Sum(p.RedWeight) AS RedWeightTotal, "
				+ " Sum(p.RejectWeight) AS RejectWeightTotal "
				+ " FROM tblWrapperProduction AS p "
				+ " WHERE "
				+ " (p.[RedWeight]>0 or p.[RejectWeight]>0) "
				+ " AND "
				+ " (p.DateTimeEntered Between ? And ? )  "
				+ " And (p.[RedCode] not  in (select [RedCode] from tlkpRedCode) OR  p.[RedCode] is NULL) "
				+ " group by p.[GradeCode]";
		
		
	//	System.out.println(sdate+"\t"+edate);
		
		//System.out.println(sql);

			List<WrapperProductionPM5> wrapperProductions=null;
			try {
				wrapperProductions=dataSourceProductionTemplate.query(sql,
						param, 
						new RowMapper<WrapperProductionPM5>(){

							@Override
							public WrapperProductionPM5 mapRow(ResultSet rs, int arg1)
									throws SQLException {
								
								WrapperProductionPM5 wrapperProduction=new WrapperProductionPM5();

								wrapperProduction.setRedWeight(rs.getDouble("RedWeightTotal"));
								wrapperProduction.setRejectWeight(rs.getDouble("RejectWeightTotal"));
								wrapperProduction.setRedCode("NONE");
								wrapperProduction.setGradeCode(rs.getString("GradeCode"));
								return wrapperProduction;
							}
					
						});
			} catch (Exception e) {
				throw new ProductionException(e.getCause());
			}
			
			return wrapperProductions;
	}



	/* (non-Javadoc)
	 * @see com.st.production.dao.WrapperProductionDao#getGradeAndHoursData(java.util.Date, java.util.Date)
	 */
	@Override
	public  List<Map<String, Object>> getGradeAndHoursData(Date sdate,Date edate) throws ProductionException {
		final NamedParameterJdbcTemplate jdbcTemplate=new NamedParameterJdbcTemplate(dataSourceProductionTemplate);
		
		int days=Days.daysBetween(new DateTime(sdate.getTime()), new DateTime(edate.getTime())).getDays();
		
		 List<Map<String, Object>> datas=new ArrayList<Map<String,Object>>();
		
		
		for(int i=0;i<days+1;i++){
			
			final Calendar scal=Calendar.getInstance();
			scal.setTime(sdate);
			scal.set(Calendar.HOUR_OF_DAY, 7);
			scal.set(Calendar.MINUTE, 0);
			scal.set(Calendar.SECOND, 0);
			scal.set(Calendar.MILLISECOND, 0);
			
			final Calendar ecal=Calendar.getInstance();
			ecal.setTime(sdate);
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
			
			
			double machineSpeed=Double.MAX_VALUE;
			
			try {
				String sql="select "
						+ "[DateTimeEntered],"
						+ "[GoodWeight],"
						+ "[MachineSpeed],"
						+ "[GradeCode],"
						+ "[RejectedWeight],"
						+ "[Shift],"
						+ "[Comments]"
						+ " from [tblMachineProduction] where "
					
						+ "[DateTimeEntered] between :sdate and :edate AND [MachineNumber]='TM6' order by [DateTimeEntered]";
				
				
				List<MachineProductionPM5> machineProductions=jdbcTemplate.query(sql,source, new RowMapper<MachineProductionPM5>() {

					@Override
					public MachineProductionPM5 mapRow(ResultSet rs, int arg1) throws SQLException {
						MachineProductionPM5 machineProduction=new MachineProductionPM5();
						machineProduction.setDateTimeEntered(new Date(rs.getTimestamp("DateTimeEntered").getTime()));
						machineProduction.setGoodWeight(rs.getDouble("GoodWeight"));
						machineProduction.setMachineSpeed(rs.getDouble("MachineSpeed"));
						machineProduction.setGradeCode(rs.getString("GradeCode"));
						machineProduction.setRejectedWeight(rs.getDouble("RejectedWeight"));
						machineProduction.setShift(rs.getString("Shift"));
						machineProduction.setComments(rs.getString("Comments"));
						
						
						return machineProduction;
					}
				});
			
				for (MachineProductionPM5 machineProduction : machineProductions) {
					if(machineSpeed>machineProduction.getMachineSpeed()){
						machineSpeed=machineProduction.getMachineSpeed();
					}
				}
				
				if(machineSpeed==Double.MAX_VALUE){
					machineSpeed=0;
				}
				
			//	System.out.println(machineSpeed);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
				
				

				try {
					
					String sql=DatabaseUtil.getSQL("GradeAndHour.sql");
			//		System.out.println(sql);
					
				//	System.out.println();
					
					List<WrapperProductionPM5> wrapperProductions=jdbcTemplate.query(sql,source, 
							new RowMapper<WrapperProductionPM5>(){

								@Override
								public WrapperProductionPM5 mapRow(ResultSet rs, int arg1)
										throws SQLException {
									
									WrapperProductionPM5 wrapperProduction=new WrapperProductionPM5();
									wrapperProduction.setDateEntered(new Date(rs.getDate("DateEntered").getTime()));
									wrapperProduction.setWhiteWeight(rs.getDouble("WhiteWeight"));
									wrapperProduction.setRedWeight(rs.getDouble("RedWeight"));
									wrapperProduction.setRejectWeight(rs.getDouble("RejectWeight"));
									wrapperProduction.setCustomer(rs.getString("Customer"));
									wrapperProduction.setGradeCode(rs.getString("GradeCode"));
									wrapperProduction.setFurnishCode(rs.getString("FurnishCode"));
									wrapperProduction.setTbdRate(rs.getDouble("TBDRate"));
									//wrapperProduction.setPly(rs.getInt("Ply"));
									wrapperProduction.setPly(0);
									wrapperProduction.setRollWidth(rs.getDouble("Width")+"");
									
									//Code Strats From Here Done BY Roshan Tailor
									wrapperProduction.setCoresize(rs.getString("CoreSize"));
								
									
									return wrapperProduction;
								}
						
					});
									
					
					double totalGross=0;
					for (WrapperProductionPM5 production : wrapperProductions) {
						//totalGross+=production.getWhiteWeight()/2000 +production.getRedWeight()/2000+production.getRejectWeight()/2000;    //This Is Old Formula Here We Are Including the Un-Controllable Down Time Minutes
						totalGross+=production.getWhiteWeight()/2000 +production.getRedWeight()/2000; //This Is New Formula Here We just exclude the Reject Weight.
					}
					
					double totalNet=totalGross*0.99;
					
					for (WrapperProductionPM5 production : wrapperProductions) {
						if(production.getWhiteWeight()>0){
							Map<String, Object> map=new HashMap<String, Object>();
							
							map.put("MachineSpeed", machineSpeed);
							map.put("DateEntered", new SimpleDateFormat("MM-dd-yyyy").format(production.getDateEntered()));
							map.put("Customer", production.getCustomer());
							map.put("FurnishCode", production.getFurnishCode());
							map.put("Ply", production.getPly());
							String size=production.getCoresize();
							if(size.length()==1){
								size=size+'"';
							}
							if(size.substring(0, 2).equalsIgnoreCase("16")){
								String code=production.getGradeCode();
								System.out.println(code.trim()+"-"+size.substring(0, 2).trim());
								map.put("GradeCode", code.trim()+"-"+size.substring(0, 2).trim());
							}else{
								map.put("GradeCode", production.getGradeCode());
							}
							//map.put("GradeCode", production.getGradeCode());
							
							double whiteGross=production.getWhiteWeight()/2000;
							double whiteNet=whiteGross*0.99;
							/*
							double redGross=production.getRedWeight()/2000;
							double redNet=redGross*0.99;*/
							
							double grossWrapped=whiteGross;
							double netWrapped=whiteNet;
							
							map.put("WhiteGross",CommonUtil.round(whiteGross, 2));
							map.put("WhiteNet",CommonUtil.round( whiteNet, 2));
							map.put("RedGross",CommonUtil.round( 0, 2));
							map.put("RedNet",CommonUtil.round( 0, 2));
							map.put("RejectGross",CommonUtil.round( 0, 2));
							map.put("RejectNet",CommonUtil.round( 0, 2));
							map.put("GrossWrapped",CommonUtil.round( grossWrapped, 2));
							map.put("NetWrapped",CommonUtil.round( netWrapped, 2));
							
							double hrs=0;
							if(totalGross>0){
								
								SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy HH:mm:ss");
								
								List<Efficiency> efficiencies=efficiencyDao.getEfficienciesUnControllableDownTimeMinutes(sdf.format(scal.getTime().getTime()),sdf.format(ecal.getTime().getTime()));
								
								double _unControllableDownTimeMinutes=0;
								for (Efficiency eff : efficiencies) {
									_unControllableDownTimeMinutes+=(CommonUtil.getHoursDuration(eff.getStartTime(), eff.getEndTime())*60+CommonUtil.getMinutesDuration(eff.getStartTime(), eff.getEndTime()));
								}
								
								//System.out.println("_unControllableDownTimeMinutes:"+CommonUtil.round(((1440-_unControllableDownTimeMinutes)/60), 2));
								//hrs=(whiteGross/totalGross)*24;//This Is Old Formula Here We Are Including the Un-Controllable Down Time Minutes
								hrs=(whiteGross/totalGross)*CommonUtil.round(((1440-_unControllableDownTimeMinutes)/60), 2);//This Is New Formula Here We Are Excluding the Un-Controllable Down Time Minutes
								
							}
							map.put("HoursSpent",CommonUtil.round( hrs, 2));
							map.put("NetTonsPerHour",CommonUtil.round( totalNet/24, 2));
							map.put("NetTonsPerDay",CommonUtil.round( totalNet, 2));
							
							map.put("TBDRate",production.getTbdRate());
							
							double targetTon=(production.getTbdRate()*hrs)/24;
							
							map.put("TargetTonsCalc",CommonUtil.round(targetTon, 2));
							
							double effic=0;
							if(targetTon!=0){
								effic=(whiteNet)/targetTon;
							}
							
							map.put("EfficiencyCalc",CommonUtil.round(effic*100, 2));
							
							map.put("RollWidthSum", production.getRollWidth());
							
							datas.add(map);
						}
						
					}
					
					
					//Red
					for (WrapperProductionPM5 production : wrapperProductions) {
						if(production.getRedWeight()>0){
							Map<String, Object> map=new HashMap<String, Object>();
							
							map.put("MachineSpeed", machineSpeed);
							map.put("DateEntered", new SimpleDateFormat("MM-dd-yyyy").format(production.getDateEntered()));
							map.put("Customer", "Mill-Red");
							map.put("Ply", production.getPly());
							
							String size=production.getCoresize();
							if(size.length()==1){
								size=size+'"';
							}
							if(size.substring(0, 2).equalsIgnoreCase("16")){
								String code=production.getGradeCode();
								System.out.println(code.trim()+"-"+size.substring(0, 2).trim());
								map.put("GradeCode", code.trim()+"-"+size.substring(0, 2).trim());
							}else{
								map.put("GradeCode", production.getGradeCode());
							}
							//map.put("GradeCode", production.getGradeCode());
							
							
							double redGross=production.getRedWeight()/2000;
							double redNet=redGross*0.99;
							
							double grossWrapped=redGross;
							double netWrapped=redNet;
							
							map.put("WhiteGross",CommonUtil.round(0, 2));
							map.put("WhiteNet",CommonUtil.round( 0, 2));
							map.put("RedGross",CommonUtil.round( redGross, 2));
							map.put("RedNet",CommonUtil.round( redNet, 2));
							map.put("RejectGross",CommonUtil.round( 0, 2));
							map.put("RejectNet",CommonUtil.round( 0, 2));
							map.put("GrossWrapped",CommonUtil.round( grossWrapped, 2));
							map.put("NetWrapped",CommonUtil.round( netWrapped, 2));
							
							double hrs=0;
							if(totalGross>0){
								hrs=(redGross/totalGross)*24;
							}
							map.put("HoursSpent",CommonUtil.round( hrs, 2));
							map.put("NetTonsPerHour",CommonUtil.round( totalNet/24, 2));
							map.put("NetTonsPerDay",CommonUtil.round( totalNet, 2));
							
							map.put("TBDRate",production.getTbdRate());
							
							
							map.put("TargetTonsCalc","");
							
							
							map.put("EfficiencyCalc","");
							
							map.put("RollWidthSum", production.getRollWidth());
							
							datas.add(map);
						}
					}
					
					//Rejected
					for (WrapperProductionPM5 production : wrapperProductions) {
						if(production.getRejectWeight()>0){
							Map<String, Object> map=new HashMap<String, Object>();
							
							map.put("MachineSpeed", machineSpeed);
							map.put("DateEntered", new SimpleDateFormat("MM-dd-yyyy").format(production.getDateEntered()));
							map.put("Customer", "Mill-Reject");
							map.put("Ply", production.getPly());
							
							String size=production.getCoresize();
							if(size.substring(0, 2).equalsIgnoreCase("16")){
								String code=production.getGradeCode();
								System.out.println(code.trim()+"-"+size.substring(0, 2).trim());
								map.put("GradeCode", code.trim()+"-"+size.substring(0, 2).trim());
							}else{
								map.put("GradeCode", production.getGradeCode());
							}
							
							
							
							double rejectGross=production.getRejectWeight()/2000;
							double rejectNet=rejectGross*0.99;
							
							double grossWrapped=rejectGross;
							double netWrapped=rejectNet;
							
							map.put("WhiteGross",CommonUtil.round(0, 2));
							map.put("WhiteNet",CommonUtil.round( 0, 2));
							map.put("RedGross",CommonUtil.round( 0, 2));
							map.put("RedNet",CommonUtil.round( 0, 2));
							map.put("RejectGross",CommonUtil.round(rejectGross, 2));
							map.put("RejectNet",CommonUtil.round(rejectNet, 2));
							map.put("GrossWrapped",CommonUtil.round(grossWrapped, 2));
							map.put("NetWrapped",CommonUtil.round(netWrapped, 2));
							
							double hrs=0;
							if(totalGross>0){
								hrs=(rejectGross/totalGross)*24;
							}
							map.put("HoursSpent",CommonUtil.round( hrs, 2));
							map.put("NetTonsPerHour",CommonUtil.round( totalNet/24, 2));
							map.put("NetTonsPerDay",CommonUtil.round( totalNet, 2));
							
							map.put("TBDRate",production.getTbdRate());
							
							
							map.put("TargetTonsCalc","");
							
							
							map.put("EfficiencyCalc","");
							
							map.put("RollWidthSum", production.getRollWidth());
							
							datas.add(map);
						}
					}
					
					
					
				} catch (Exception e) {
					e.printStackTrace();
					throw new ProductionException(e);
				}


		
			
			sdate=ecal.getTime();
		}	
		
		
		
		
		
		return datas;
	}



	/* (non-Javadoc)
	 * @see com.st.production.dao.WrapperProductionDao#getWrapperForDailyInventory(java.util.Date, java.util.Date)
	 */
	@Override
	public List<WrapperProductionPM5> getWrapperForDailyInventory(Date sdate,
			Date edate) {
		
		List<WrapperProductionPM5> productions=new ArrayList<WrapperProductionPM5>();
		
		int days=Days.daysBetween(new DateTime(sdate.getTime()), new DateTime(edate.getTime())).getDays();
		for (int i = 0; i < days+1; i++) {

			final Calendar scal = Calendar.getInstance();
			scal.setTime(sdate);
			scal.set(Calendar.HOUR_OF_DAY, 7);
			scal.set(Calendar.MINUTE, 0);
			scal.set(Calendar.SECOND, 0);
			scal.set(Calendar.MILLISECOND, 0);

			final Calendar ecal = Calendar.getInstance();
			ecal.setTime(sdate);
			ecal.set(Calendar.HOUR_OF_DAY, 6);
			ecal.set(Calendar.MINUTE, 59);
			ecal.set(Calendar.SECOND, 59);
			ecal.set(Calendar.MILLISECOND, 0);
			ecal.add(Calendar.DATE, 1);
			
			System.out.println(scal.getTime());
			System.out.println(ecal.getTime());
			
			//White Weight
			{
				String sql=" SELECT "
						+ " [DateEntered],[WrapperNumber],[GradeCode],[CustomerGradeCode],[Customer],[Diameter],[RollWidth],[CoreSize],"
						+ " sum(WhiteWeight) as [WhiteWeightSum],sum(RedWeight) as [RedWeightSum],count(RollID) as [Roll] "
						+ " FROM tblWrapperProduction "
						+ " where "
						+ " [DateTimeEntered] between ? and ? "
						+ " and	"
						+ " [WhiteWeight]>0 AND WrapperNumber='WR5' "
						+ " group by "
						+ "  [DateEntered],[WrapperNumber],[GradeCode],[CustomerGradeCode],[Customer],[Diameter],[RollWidth],[CoreSize] "
						+ " Order by [DateEntered],[Customer]";
				
				System.out.println(sql);
				
				List<WrapperProductionPM5> wrapperProductions=dataSourceProductionTemplate.query(sql, new Object[]{
						new Timestamp(scal.getTime().getTime()),
						new Timestamp(ecal.getTime().getTime())
				}, new RowMapper<WrapperProductionPM5>(){

					@Override
					public WrapperProductionPM5 mapRow(ResultSet rs, int arg1)
							throws SQLException {
						WrapperProductionPM5 production=new WrapperProductionPM5();
						production.setDateEntered(new Date(rs.getTimestamp("DateEntered").getTime()));
						production.setWrapperNumber(rs.getString("WrapperNumber"));
						production.setGradeCode(rs.getString("GradeCode"));
						production.setCustomerGradeCode(rs.getString("CustomerGradeCode"));
						production.setCustomer(rs.getString("Customer"));
						production.setDiameter(rs.getString("Diameter"));
						production.setRollWidth(rs.getString("RollWidth"));
					//	production.setPly(rs.getInt("Ply"));
						production.setCoreSize(rs.getString("CoreSize"));
						production.setWhiteWeight(rs.getDouble("WhiteWeightSum"));
						production.setRollCount(rs.getInt("Roll"));
						return production;
					}
					
				});
				
				productions.addAll(wrapperProductions);
			}
			
			//Red Weight
			{
				String sql=" SELECT "
						+ " [DateEntered],[WrapperNumber],[GradeCode],[CustomerGradeCode],[Customer],[Diameter],[RollWidth],[CoreSize],"
						+ " sum(WhiteWeight) as [WhiteWeightSum],sum(RedWeight) as [RedWeightSum],count(RollID) as [Roll] "
						+ " FROM tblWrapperProduction "
						+ " where "
						+ " [DateTimeEntered] between ? and ? "
						+ " and	"
						+ " [RedWeight]>0   AND WrapperNumber='WR5' "
						+ " group by "
						+ "  [DateEntered],[WrapperNumber],[GradeCode],[CustomerGradeCode],[Customer],[Diameter],[RollWidth],[CoreSize] "
						+ " Order by [DateEntered],[Customer]";
				System.out.println(sql);
				List<WrapperProductionPM5> wrapperProductions=dataSourceProductionTemplate.query(sql, new Object[]{
						new Timestamp(scal.getTime().getTime()),
						new Timestamp(ecal.getTime().getTime())
				}, new RowMapper<WrapperProductionPM5>(){

					@Override
					public WrapperProductionPM5 mapRow(ResultSet rs, int arg1)
							throws SQLException {
						WrapperProductionPM5 production=new WrapperProductionPM5();
						production.setDateEntered(new Date(rs.getTimestamp("DateEntered").getTime()));
						production.setWrapperNumber(rs.getString("WrapperNumber"));
						production.setGradeCode(rs.getString("GradeCode"));
						production.setCustomerGradeCode(rs.getString("CustomerGradeCode"));
						production.setCustomer("Mill");
						production.setDiameter(rs.getString("Diameter"));
						production.setRollWidth(rs.getString("RollWidth"));
					//	production.setPly(rs.getInt("Ply"));
						production.setCoreSize(rs.getString("CoreSize"));
						production.setWhiteWeight(rs.getDouble("WhiteWeightSum"));
						production.setRollCount(rs.getInt("Roll"));
						return production;
					}
					
				});
				
				productions.addAll(wrapperProductions);
			}
			
			
			
			sdate=ecal.getTime();
			
		}
		
		return productions;
	}



	/* (non-Javadoc)
	 * @see com.st.production.dao.WrapperProductionDao#isNewRedEntryExist()
	 */
	@Override
	public Map<String, Object> isNewRedEntryExist() {
		
		Map<String, Object> map=new HashMap<String, Object>();
		
		Calendar sCal=Calendar.getInstance();
		sCal.setTime(new Date());
		sCal.add(Calendar.MINUTE, -5);
		
		Calendar eCal=Calendar.getInstance();
		eCal.setTime(new Date());
		
		
		
		String sql="SELECT count(*) FROM [tblWrapperProduction] where ( [RedWeight]>0 or  [RejectWeight]>0)  and WrapperNumber='WR5' and WrapperNumber<>'ZZZ' and [DateTimeEntered] between ? and ?";
		
		int count=0;
		try {
			count=dataSourceProductionTemplate.queryForObject(sql,new Object[]{
					new Timestamp(sCal.getTime().getTime()),
					new Timestamp(eCal.getTime().getTime())

			}, Integer.class);
		} catch (Exception e) {
			logger.error("Error In get red/reject count="+e.getMessage());
		}
		
		//System.out.println(sCal.getTime()+"\t"+eCal.getTime()+"=="+count);
		
		
		
		if(count>0){
			map.put("flag", true);
		}else{
			map.put("flag", false);
		}
		
		
		
		Calendar calendar=Calendar.getInstance();
		calendar.setTime(CommonUtil.getShiftDate());
		calendar.set(Calendar.HOUR_OF_DAY, 7);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		
		
		String sql2="SELECT count(*) FROM [tblWrapperProduction] where ( [RedWeight]>0 or  [RejectWeight]>0)  and WrapperNumber='WR5' and WrapperNumber<>'ZZZ' and [DateTimeEntered] between ? and ? ";
		
		int count2=0;
		try {
			count2=dataSourceProductionTemplate.queryForObject(sql2,new Object[]{
					new Timestamp(calendar.getTime().getTime()),
					new Timestamp(new Date().getTime())

			}, Integer.class);
		} catch (Exception e) {
			logger.error("Error In get red/reject count="+e.getMessage());
		}
		
		map.put("count", count2);
		
		
		return map;
	}



	/* (non-Javadoc)
	 * @see com.st.production.dao.WrapperProductionDao#getWrapperFullProductionData(java.util.Date, java.util.Date)
	 */
	@Override
	public List<WrapperProductionPM5> getWrapperRedRejectProductionData(Date sdate,
			Date edate) {
		String sql="SELECT * FROM [tblWrapperProduction] where ( [RedWeight]>0 or  [RejectWeight]>0)  and [DateTimeEntered] between ? and ? and WrapperNumber='WR5'  order by [DateTimeEntered]";
		List<WrapperProductionPM5> productions=dataSourceProductionTemplate.query(sql, new Object[]{
				new Timestamp(sdate.getTime()),
				new Timestamp(edate.getTime())
		}, new RowMapper<WrapperProductionPM5>(){

			@Override
			public WrapperProductionPM5 mapRow(ResultSet rs, int arg1)
					throws SQLException {
				WrapperProductionPM5 production=new WrapperProductionPM5();

				production.setWrapperNumber(rs.getString("WrapperNumber"));
				production.setRollID(rs.getString("RollID"));
				Timestamp date=rs.getTimestamp("DateEntered");
				if(date!=null){
					production.setDateEntered(new Date(date.getTime()));
				}
				
				Timestamp dateTime=rs.getTimestamp("DateTimeEntered");
				if(dateTime!=null){
					production.setDateTimeEntered(new Date(dateTime.getTime()));
					
					int min=CommonUtil.getMinutesDiff(new Date(dateTime.getTime()), new Date());
					
					if(min>0 && min<=5){
						production.setNewRed(true);
					}
					
					
				}
				
				production.setRollNumber(rs.getString("RollNumber"));
				production.setSetPosition(rs.getString("SetPosition"));
				production.setShift(rs.getString("Shift"));
				production.setGradeCode(rs.getString("GradeCode"));
				production.setCustomerGradeCode(rs.getString("CustomerGradeCode"));
				production.setWhiteWeight(rs.getDouble("WhiteWeight"));
				production.setRedWeight(rs.getDouble("RedWeight"));
				production.setRejectWeight(rs.getDouble("RejectWeight"));
/*				production.setQualityHold(rs.getBoolean("QualityHold"));
				production.setOrderNumber(rs.getString("OrderNumber"));
				production.setProductionTime(rs.getString("ProductionTime"));
				production.setTeam(rs.getString("Team"));*/
				production.setInitials(rs.getString("Initials"));
				production.setDiameter(rs.getString("Diameter"));
				production.setRollWidth(rs.getString("RollWidth"));
				//production.setPly(rs.getInt("Ply"));
				production.setCoreSize(rs.getString("CoreSize"));
				//production.setBarcode(rs.getString("Barcode"));//This BarCode Commented By Roshan Tailor
				production.setComment(rs.getString("Comment"));
				/*production.setTransferDate(rs.getString("TransferDate"));
				production.setTransferLocation(rs.getString("TransferLocation"));
				production.setCustomer(rs.getString("Customer"));
				production.setRedValue(rs.getString("RedValue"));
				production.setRedCode(rs.getString("RedCode"));
				production.setRedCodeValue(rs.getString("RedCodeValue"));
				production.setRedCustomer(rs.getString("RedCustomer"));
				production.setParentRoll(rs.getString("ParentRoll"));
				production.setLabelPrinted(rs.getString("LabelPrinted"));
				production.setBreaks(rs.getString("Breaks"));
				production.setStartDateTime(rs.getString("StartDateTime"));*/
				
				Timestamp dateShip=rs.getTimestamp("DateShipped");
				if(dateShip!=null){
					production.setDateShipped(new Date(dateShip.getTime()));
				}
			/*	production.setNextSet(rs.getString("NextSet"));
				production.setInvoiceDate(rs.getString("InvoiceDate"));
				production.setInvoiceNumber(rs.getString("InvoiceNumber"));
				production.setInvoiceType(rs.getString("InvoiceType"));
				production.setSlabDate(rs.getString("SlabDate"));
			 */
				
				return production;
			}});
		return productions;
	}



	/* (non-Javadoc)
	 * @see com.st.production.dao.WrapperProductionDao#getWrapperTonsOfShift()
	 */
	@Override
	public WrapperProductionPM5 getWrapperTonsOfShift() {
		
		Date sdate=CommonUtil.getShiftDate();
		
		Calendar cal=Calendar.getInstance();
		cal.setTime(sdate);
		cal.set(Calendar.HOUR_OF_DAY, 7);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		
		WrapperProductionPM5 production=new WrapperProductionPM5();
		
		try {
			
			String sql="SELECT sum(WhiteWeight)/2000 as WhiteWeightT,"
					+ "sum(RedWeight)/2000 as RedWeightT,"
					+ "sum(RejectWeight)/2000 as RejectWeightT "
					+ "FROM tblWrapperProduction where [DateTimeEntered] between ? and ? ";
			List<WrapperProductionPM5> productions=dataSourceProductionTemplate.query(sql, new Object[]{
					new Timestamp(cal.getTime().getTime()),
					new Timestamp(new Date().getTime())
			}, new RowMapper<WrapperProductionPM5>(){

				@Override
				public WrapperProductionPM5 mapRow(ResultSet rs, int arg1)
						throws SQLException {
					WrapperProductionPM5 production=new WrapperProductionPM5();
					production.setWhiteWeight(CommonUtil.round(rs.getDouble("WhiteWeightT"), 2));
					production.setRedWeight(CommonUtil.round(rs.getDouble("RedWeightT"), 2));
					production.setRejectWeight(CommonUtil.round(rs.getDouble("RejectWeightT"), 2));
					return production;
				}
				
			});
			
			if(productions.size()>0){
				production=productions.get(0);
			}
				
			
		} catch (Exception e) {
			logger.error("Data not fond:-"+e.getMessage());
		}
		
		
		return production;
	}



	/* (non-Javadoc)
	 * @see com.st.production.dao.WrapperProductionDao#getWrapperAvgByGrade(java.util.Date, java.util.Date)
	 */
	@Override
	public List<WrapperProductionPM5> getWrapperAvgByGrade(Date sdate, Date edate) {
		
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
		ecal.set(Calendar.SECOND, 0);
		ecal.set(Calendar.MILLISECOND, 0);
		ecal.add(Calendar.DATE, 1);
		
/*		String sql="SELECT GradeCode,Diameter,RollWidth,avg(WhiteWeight)/2000 as WhiteWeightAvg,max(WhiteWeight)/2000 as WhiteWeightMax,min(WhiteWeight)/2000 as WhiteWeightMin"
				+ " FROM tblWrapperProduction "
				+ " where DateTimeEntered between ? and ? "
				+ " group by GradeCode,Diameter,RollWidth ";
				/2000 is removed By Roshan Tailor
*/		
		//Code Starts From Here Done By Roshan Tailor Date :- 05-14-2015
		String sql="SELECT GradeCode,Diameter,RollWidth,avg(WhiteWeight) as WhiteWeightAvg,max(WhiteWeight) as WhiteWeightMax,min(WhiteWeight) as WhiteWeightMin"
				+ " FROM tblWrapperProduction "
				+ " where DateTimeEntered between ? and ? and WhiteWeight>0 AND WrapperNumber='WR5' "
				+ " group by GradeCode,Diameter,RollWidth ";
		//Code Ends Here Done By Roshan Tailor Date :- 05-14-2015
		List<WrapperProductionPM5> productions=dataSourceProductionTemplate.query(sql, new Object[]{
				new Timestamp(scal.getTime().getTime()),
				new Timestamp(ecal.getTime().getTime())
		},new RowMapper<WrapperProductionPM5>(){

			@Override
			public WrapperProductionPM5 mapRow(ResultSet rs, int arg1)
					throws SQLException {
				WrapperProductionPM5 production=new WrapperProductionPM5();
				
				production.setGradeCode(rs.getString("GradeCode"));
				production.setWhiteWeight(CommonUtil.round(rs.getDouble("WhiteWeightAvg"), 2));
				production.setDiameter(rs.getString("Diameter"));
				production.setRollWidth(rs.getString("RollWidth"));
				production.setWhiteWeightMax(CommonUtil.round(rs.getDouble("WhiteWeightMax"), 2));
				production.setWhiteWeightMin(CommonUtil.round(rs.getDouble("WhiteWeightMin"), 2));
				return production;
			}
			
		});
		
		return productions;
	}



	/* (non-Javadoc)
	 * @see com.st.production.dao.WrapperProductionDao#getWrapperDataByDate(java.util.Date, java.util.Date)
	 */
	@Override
	public List<WrapperProductionPM5> getWrapperDataByDate(Date sdate, Date edate) throws ProductionException {
		
		NamedParameterJdbcTemplate jdbcTemplate=new NamedParameterJdbcTemplate(dataSourceProductionTemplate);
		MapSqlParameterSource paramSource=new MapSqlParameterSource();
		paramSource.addValue("sdate", new Timestamp(sdate.getTime()));
		paramSource.addValue("edate", new Timestamp(edate.getTime()));
		
		
		String sql=DatabaseUtil.getSQL("WrapperDataByDate.sql");
		List<WrapperProductionPM5> productions=new ArrayList<WrapperProductionPM5>();
		try {
			 productions=jdbcTemplate.query(sql, paramSource, new RowMapper<WrapperProductionPM5>() {

					@Override
					public WrapperProductionPM5 mapRow(ResultSet rs, int arg1)
							throws SQLException {
						WrapperProductionPM5 production=new WrapperProductionPM5();
						production.setWrapperNumber(rs.getString("WrapperNumber"));
						Timestamp dateEntered=rs.getTimestamp("DateEntered");
						if(dateEntered!=null){
							production.setDateEntered(new Date(dateEntered.getTime()));
						}
						
						Timestamp dateTimeEntered=rs.getTimestamp("DateTimeEntered");
						if(dateTimeEntered!=null){
							production.setDateTimeEntered(new Date(dateTimeEntered.getTime()));
						}
						
						production.setRollID(rs.getString("RollID"));
						production.setShift(rs.getString("Shift"));
					//	production.setTeam(rs.getString("Team"));
						production.setInitials(rs.getString("Initials"));
						production.setGradeCode(rs.getString("GradeCode"));
						production.setCustomerGradeCode(rs.getString("CustomerGradeCode"));
						production.setRollNumber(rs.getString("RollNumber"));
						production.setSetPosition(rs.getString("SetPosition"));
						production.setWhiteWeight(rs.getDouble("WhiteWeight"));
						production.setRedWeight(rs.getDouble("RedWeight"));
						production.setRejectWeight(rs.getDouble("RejectWeight"));
						production.setDiam(CommonUtil.checkDouble(rs.getString("Diameter").replace("\"", "").replace("'", "")));
						production.setRwidth(CommonUtil.checkDouble(rs.getString("RollWidth").replace("\"", "").replace("\'", "")));
						//production.setPly(rs.getInt("Ply"));
						production.setCoreSizeN(CommonUtil.checkDouble(rs.getString("CoreSize").replace("\"", "").replace("\'", "")));
					//	production.setBarcode(rs.getString("Barcode"));
						production.setComment(rs.getString("Comment"));
						
						Timestamp dateShipped=rs.getTimestamp("DateShipped");
						if(dateShipped!=null){
							production.setDateShipped(new Date(dateShipped.getTime()));
						}

					//	production.setOrderNumber(rs.getString("OrderNumber"));
						production.setBreaks(rs.getDouble("Breaks"));
						production.setCustomer(rs.getString("Customer"));
						production.setWeightVar(rs.getString("WeightVar"));
						production.setReelNumber1(rs.getDouble("ReelNumber1"));
						production.setMachineRollID1(rs.getString("MachineRollID1"));
						production.setReelWidth(rs.getDouble("ReelWidth"));
						production.setReelWeight(rs.getDouble("ReelWeight"));
						
						return production;
					}
				});
		} catch (Exception e) {
			throw new ProductionException(e);
		}
		
		return productions;
	}



	/* (non-Javadoc)
	 * @see com.st.production.dao.WrapperProductionDao#getWrapperProductionsForRollBreak(java.util.Date, java.util.Date, java.lang.String)
	 */
	@Override
	public List<WrapperProductionPM5> getWrapperProductionsForRollBreak(Date sdate,
			Date edate, String shift, final int breakSize) throws ProductionException {
		
		Object[] param=null;
		String sql="";
		List<WrapperProductionPM5> wrapperProductions=null;
		List<WrapperProductionPM5> wrapperProductions1=null;
		
		if(breakSize>1){
			if(shift.equalsIgnoreCase("Day")|| shift.equalsIgnoreCase("Night")){
				sql="SELECT COUNT(*) As [Total_Rolls_Produce],a.[Shift],b.[Total_Rolls_With_Breaks]  "
						+ "FROM [production].[dbo].[tblWrapperProduction] a "
						+ "INNER JOIN ( SELECT COUNT(*) As [Total_Rolls_With_Breaks],[Shift]   "
						+ "FROM [production].[dbo].[tblWrapperProduction]  "
						+ "Where ([DateTimeEntered] between ? and ? )  "
						+ "AND [WrapperNumber] <> 'ZZZ' AND [Breaks]>0 and [Shift]=? AND [WrapperNumber]='WR5' "
						+ "Group By [tblWrapperProduction].[Shift] ) as b on b.Shift=a.Shift "
						+ " Where (a.[DateTimeEntered] between ? and ? ) "
						+ "AND a.[WrapperNumber] <> 'ZZZ'  AND [WrapperNumber]='WR5' "
						+ "Group By a.[Shift],b.[Total_Rolls_With_Breaks] ";
						param=new Object[]{
							new Timestamp(sdate.getTime()),
							new Timestamp(edate.getTime()),
							shift,
							new Timestamp(sdate.getTime()),
							new Timestamp(edate.getTime())
						};
				}else{
					sql="SELECT COUNT(*) As [Total_Rolls_Produce],a.[Shift],b.[Total_Rolls_With_Breaks]  "
							+ "FROM [production].[dbo].[tblWrapperProduction] a "
							+ "INNER JOIN ( SELECT COUNT(*) As [Total_Rolls_With_Breaks],[Shift]   "
							+ "FROM [production].[dbo].[tblWrapperProduction]  "
							+ "Where ([DateTimeEntered] between ? and ? )  "
							+ "AND [WrapperNumber] <> 'ZZZ' AND [Breaks]>0  AND [WrapperNumber]='WR5' "
							+ "Group By [tblWrapperProduction].[Shift] ) as b on b.Shift=a.Shift "
							+ " Where (a.[DateTimeEntered] between ? and ? ) "
							+ "AND a.[WrapperNumber] <> 'ZZZ'   AND [WrapperNumber]='WR5'"
							+ "Group By a.[Shift],b.[Total_Rolls_With_Breaks] ";
							param=new Object[]{
								new Timestamp(sdate.getTime()),
								new Timestamp(edate.getTime()),
								new Timestamp(sdate.getTime()),
								new Timestamp(edate.getTime())
							};
				}
			
			
			try {
				wrapperProductions=dataSourceProductionTemplate.query(sql,
						param, 
						new RowMapper<WrapperProductionPM5>(){

							@Override
							public WrapperProductionPM5 mapRow(ResultSet rs, int arg1)
									throws SQLException {
								
								WrapperProductionPM5 wrapperProduction=new WrapperProductionPM5();
								if(breakSize>0){
									wrapperProduction.setNumberofrollswithbreaks(rs.getInt("Total_Rolls_With_Breaks"));
								}else{
									wrapperProduction.setNumberofrollswithbreaks(0);
								}
								wrapperProduction.setShift(rs.getString("Shift"));
								wrapperProduction.setTotalrollsproduce(rs.getInt("Total_Rolls_Produce"));
								
								//Apply % Calculation For Break Free
								int totalRoll=rs.getInt("Total_Rolls_With_Breaks");
								
								double finalbreakfreeper=0;
								double toatlpercentage;
								double hundrad =100;
								
								if(totalRoll>0){
									wrapperProduction.setNumberofrollswithbreaks(rs.getInt("Total_Rolls_With_Breaks"));
									wrapperProduction.setTotalrollsproduce(rs.getInt("Total_Rolls_Produce"));
									int totalRollBreaks=rs.getInt("Total_Rolls_With_Breaks");
									int totalRollProduse=rs.getInt("Total_Rolls_Produce");
									
									Integer obj1 = new Integer(totalRollBreaks);
									Integer obj2 = new Integer(totalRollProduse);
									 
									double d1 = obj1.doubleValue();
									double d2 = obj2.doubleValue();
									double cal1=(d1/d2)*100;
									//System.out.println(cal1);
									double cal2=100-cal1;
								
									finalbreakfreeper=finalbreakfreeper+wrapperProduction.getPercentageofrollswithbreaks();
									wrapperProduction.setPercentageofrollswithbreaks(CommonUtil.round(cal2, 2));
									 
								}else{
									wrapperProduction.setPercentageofrollswithbreaks(hundrad);
								}
								//Calculation Ends Here
								return wrapperProduction;
							}
							
						});
			} catch (Exception e) {
				throw new ProductionException(e);
			}
		}else if(breakSize==1){
			
			//First Get The Total Number Of Rolls Produse
			
			if(shift.equalsIgnoreCase("Day")|| shift.equalsIgnoreCase("Night")){
				sql="SELECT COUNT(*) As [Total_Rolls_Produce],a.[Shift] "
						+ " FROM [production].[dbo].[tblWrapperProduction] a  "
						+ "Where (a.[DateTimeEntered] between ? and ? )  "
						+ "AND a.[WrapperNumber] <> 'ZZZ'  and [Shift]=?  AND [WrapperNumber]='WR5'"
						+ "Group By a.[Shift] ";
						param=new Object[]{
							new Timestamp(sdate.getTime()),
							new Timestamp(edate.getTime()),
							shift
						};
				}else{
					sql="SELECT COUNT(*) As [Total_Rolls_Produce],a.[Shift]  "
							+ "FROM [production].[dbo].[tblWrapperProduction] a "
							+ "Where (a.[DateTimeEntered] between ? and ? ) "
							+ "AND a.[WrapperNumber] <> 'ZZZ'  AND [WrapperNumber]='WR5' "
							+ "Group By a.[Shift] ";
							param=new Object[]{
								new Timestamp(sdate.getTime()),
								new Timestamp(edate.getTime())
							};
				}
			
			
			
			try {
				wrapperProductions=dataSourceProductionTemplate.query(sql,
						param, 
						new RowMapper<WrapperProductionPM5>(){

							@Override
							public WrapperProductionPM5 mapRow(ResultSet rs, int arg1)
									throws SQLException {
								
								WrapperProductionPM5 wrapperProduction=new WrapperProductionPM5();
								wrapperProduction.setShift(rs.getString("Shift"));
								wrapperProduction.setTotalrollsproduce(rs.getInt("Total_Rolls_Produce"));
								
								System.out.println("RRR:"+wrapperProduction.getTotalrollsproduce());
								double hundrad =100;
								 
								wrapperProduction.setPercentageofrollswithbreaks(hundrad);
								//Calculation Ends Here
								return wrapperProduction;
							}
							
						});
			} catch (Exception e) {
				throw new ProductionException(e);
			}
		
			
			try {
				String sql1 = "Truncate table [tblWrappedSheetBreak_pm6]";
				dataSourceQRTTemplate.update(sql1, new Object[] {});
			} catch (Exception turn) {
				turn.printStackTrace();
			}
			
			
			//Now Insert Into Temp Table
			
			for (final WrapperProductionPM5 data : wrapperProductions) {

				final String sql2 = "insert into [tblWrappedSheetBreak_pm6]"
						+ "("
						+ "[Total_Rolls_Produce],"
						+ "[Total_Rolls_With_Breaks],"
						+ "[shift])"
						+ " values(?,?,?)";

				KeyHolder keyHolder = new GeneratedKeyHolder();

				dataSourceQRTTemplate.update(new PreparedStatementCreator() {

					@Override
					public PreparedStatement createPreparedStatement(Connection arg0)
							throws SQLException {
						PreparedStatement statement = arg0.prepareStatement(sql2,
								new String[] { "ID" });

						statement.setInt(1, data.getTotalrollsproduce());
						statement.setInt(2, 0);
						statement.setString(3, data.getShift());
						return statement;
					}
				}, keyHolder);
			}
			
			
			//Find The Rolls With Breaks
			
			
			String sql1="";
			if(shift.equalsIgnoreCase("Day")|| shift.equalsIgnoreCase("Night")){
				sql1="SELECT COUNT(*) As [Total_Rolls_With_Breaks],[Shift]  "
						+ "FROM [production].[dbo].[tblWrapperProduction]  "
						+ "Where ([DateTimeEntered] between ? and ? )  "
						+ "AND [WrapperNumber] <> 'ZZZ' AND Shift=? AND [Breaks]>0  AND [WrapperNumber]='WR5' Group By [tblWrapperProduction].[Shift] ";
						param=new Object[]{
							new Timestamp(sdate.getTime()),
							new Timestamp(edate.getTime()),
							shift
						};
				}else{
					sql1="SELECT COUNT(*) As [Total_Rolls_With_Breaks],[Shift]  "
							+ "FROM [production].[dbo].[tblWrapperProduction]  "
							+ "Where ([DateTimeEntered] between ? and ? )  "
							+ "AND [WrapperNumber] <> 'ZZZ'  AND [Breaks]>0  AND [WrapperNumber]='WR5' Group By [tblWrapperProduction].[Shift] ";
							param=new Object[]{
								new Timestamp(sdate.getTime()),
								new Timestamp(edate.getTime())
							};
				}
			
			try {
				wrapperProductions1=dataSourceProductionTemplate.query(sql1,
						param, 
						new RowMapper<WrapperProductionPM5>(){

							@Override
							public WrapperProductionPM5 mapRow(ResultSet rs, int arg1)
									throws SQLException {
								
								WrapperProductionPM5 wrapperProduction=new WrapperProductionPM5();
								
								wrapperProduction.setNumberofrollswithbreaks(rs.getInt("Total_Rolls_With_Breaks"));
								wrapperProduction.setShift(rs.getString("Shift"));
								
								return wrapperProduction;
							}
							
						});
			} catch (Exception e) {
				throw new ProductionException(e);
			}
			
			//Now Update The Temp Table
			
			for (final WrapperProductionPM5 data1 : wrapperProductions1) {
				
				
				String sql3="update [tblWrappedSheetBreak_pm6] SET "
						
								+ "[Total_Rolls_With_Breaks]=?"
								+ " where [shift]=?";
						

				dataSourceQRTTemplate.execute(sql3, new PreparedStatementCallback<Boolean>() {

							@Override
							public Boolean doInPreparedStatement(
									PreparedStatement statement) throws SQLException,
									DataAccessException {
								statement.setInt(1, data1.getNumberofrollswithbreaks());
								statement.setString(2, data1.getShift());
								return statement.execute();
							}
						});
			}
			
			

			
				
			//Now Select The Data From Temp Table
			

			String sql4="Select [Total_Rolls_Produce] as Total_Rolls_Produce,[Total_Rolls_With_Breaks] as Total_Rolls_With_Breaks ,[Shift] as Shift from [STTissueProductionQRT].[dbo].[tblWrappedSheetBreak_pm6]";
			try {
				wrapperProductions=dataSourceQRTTemplate.query(sql4, 
						new RowMapper<WrapperProductionPM5>(){

							@Override
							public WrapperProductionPM5 mapRow(ResultSet rs, int arg1)
									throws SQLException {
								
								WrapperProductionPM5 wrapperProduction=new WrapperProductionPM5();
								if(breakSize>0){
									wrapperProduction.setNumberofrollswithbreaks(rs.getInt("Total_Rolls_With_Breaks"));
								}else{
									wrapperProduction.setNumberofrollswithbreaks(0);
								}
								wrapperProduction.setShift(rs.getString("Shift"));
								wrapperProduction.setTotalrollsproduce(rs.getInt("Total_Rolls_Produce"));
								
								//Apply % Calculation For Break Free
								int totalRoll=rs.getInt("Total_Rolls_With_Breaks");
								
								double finalbreakfreeper=0;
								double toatlpercentage;
								double hundrad =100;
								
								if(totalRoll>0){
									wrapperProduction.setNumberofrollswithbreaks(rs.getInt("Total_Rolls_With_Breaks"));
									wrapperProduction.setTotalrollsproduce(rs.getInt("Total_Rolls_Produce"));
									int totalRollBreaks=rs.getInt("Total_Rolls_With_Breaks");
									int totalRollProduse=rs.getInt("Total_Rolls_Produce");
									
									Integer obj1 = new Integer(totalRollBreaks);
									Integer obj2 = new Integer(totalRollProduse);
									 
									double d1 = obj1.doubleValue();
									double d2 = obj2.doubleValue();
									double cal1=(d1/d2)*100;
									//System.out.println(cal1);
									double cal2=100-cal1;
								
									finalbreakfreeper=finalbreakfreeper+wrapperProduction.getPercentageofrollswithbreaks();
									wrapperProduction.setPercentageofrollswithbreaks(CommonUtil.round(cal2, 2));
									 
								}else{
									wrapperProduction.setPercentageofrollswithbreaks(hundrad);
								}
								//Calculation Ends Here
								return wrapperProduction;
							}
							
						});
			} catch (Exception e) {
				throw new ProductionException(e);
			}
			
			
			
			
			
		}else{
			
			
			if(shift.equalsIgnoreCase("Day")|| shift.equalsIgnoreCase("Night")){
				sql="SELECT COUNT(*) As [Total_Rolls_Produce],a.[Shift] "
						+ " FROM [production].[dbo].[tblWrapperProduction] a  "
						+ "Where (a.[DateTimeEntered] between ? and ? )  "
						+ "AND a.[WrapperNumber] <> 'ZZZ'  and [Shift]=?  AND [WrapperNumber]='WR5'"
						+ "Group By a.[Shift] ";
						param=new Object[]{
							new Timestamp(sdate.getTime()),
							new Timestamp(edate.getTime()),
							shift
						};
				}else{
					sql="SELECT COUNT(*) As [Total_Rolls_Produce],a.[Shift]  "
							+ "FROM [production].[dbo].[tblWrapperProduction] a "
							+ "Where (a.[DateTimeEntered] between ? and ? ) "
							+ "AND a.[WrapperNumber] <> 'ZZZ'  AND [WrapperNumber]='WR5' "
							+ "Group By a.[Shift] ";
							param=new Object[]{
								new Timestamp(sdate.getTime()),
								new Timestamp(edate.getTime())
							};
				}
			
			
			
			try {
				wrapperProductions=dataSourceProductionTemplate.query(sql,
						param, 
						new RowMapper<WrapperProductionPM5>(){

							@Override
							public WrapperProductionPM5 mapRow(ResultSet rs, int arg1)
									throws SQLException {
								
								WrapperProductionPM5 wrapperProduction=new WrapperProductionPM5();
								wrapperProduction.setShift(rs.getString("Shift"));
								wrapperProduction.setTotalrollsproduce(rs.getInt("Total_Rolls_Produce"));
								
								System.out.println("RRR:"+wrapperProduction.getTotalrollsproduce());
								double hundrad =100;
								 
									wrapperProduction.setPercentageofrollswithbreaks(hundrad);
								//Calculation Ends Here
								return wrapperProduction;
							}
							
						});
			} catch (Exception e) {
				throw new ProductionException(e);
			}
		}
		
		
		
			
			
			return wrapperProductions;
		}



	/* (non-Javadoc)
	 * @see com.st.production.dao.WrapperProductionDao#checkBreaks(java.util.Date, java.util.Date, java.lang.String)
	 */
	@Override
	public List<WrapperProductionPM5> checkBreaks(Date sdate, Date edate,String shift) {
		Object[] param=null;
		String sql;
		 
			sql=" SELECT COUNT(*) As [Total_Rolls_With_Breaks],[Shift] "
					+ "FROM [production].[dbo].[tblWrapperProduction]   "
					+ "Where ([DateTimeEntered] between ? and ? )  "
					+ "AND [WrapperNumber] <> 'ZZZ' AND [Breaks]>0   AND [WrapperNumber]='WR5' "
					+ "Group By [tblWrapperProduction].[Shift] ";
					param=new Object[]{
						new Timestamp(sdate.getTime()),
						new Timestamp(edate.getTime())
					};
			 
			List<WrapperProductionPM5> wrapperProductions=null;
			try {
				wrapperProductions=dataSourceProductionTemplate.query(sql,
						param, 
						new RowMapper<WrapperProductionPM5>(){

							@Override
							public WrapperProductionPM5 mapRow(ResultSet rs, int arg1)
									throws SQLException {
								
								WrapperProductionPM5 wrapperProduction=new WrapperProductionPM5();
								wrapperProduction.setNumberofrollswithbreaks(rs.getInt("Total_Rolls_With_Breaks"));
								wrapperProduction.setShift(rs.getString("Shift"));
								return wrapperProduction;
							}
							
						});
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return wrapperProductions;
		}



	/* (non-Javadoc)
	 * @see com.st.production.dao.WrapperProductionDao#getWrapperRedRejectProductionData_PM5(java.util.Date, java.util.Date)
	 */
	@Override
	public List<WrapperProductionPM5> getWrapperRedRejectProductionData_PM5(
			Date sdate, Date edate) {
		String sql="SELECT * FROM [tblWrapperProduction] where ( [RedWeight]>0 or  [RejectWeight]>0)  and [DateTimeEntered] between ? and ? and WrapperNumber='WR5'  order by [DateTimeEntered]";
		List<WrapperProductionPM5> productions=dataSourceProductionTemplate.query(sql, new Object[]{
				new Timestamp(sdate.getTime()),
				new Timestamp(edate.getTime())
		}, new RowMapper<WrapperProductionPM5>(){

			@Override
			public WrapperProductionPM5 mapRow(ResultSet rs, int arg1)
					throws SQLException {
				WrapperProductionPM5 production=new WrapperProductionPM5();

				production.setWrapperNumber(rs.getString("WrapperNumber"));
				production.setRollID(rs.getString("RollID"));
				Timestamp date=rs.getTimestamp("DateEntered");
				if(date!=null){
					production.setDateEntered(new Date(date.getTime()));
				}
				
				Timestamp dateTime=rs.getTimestamp("DateTimeEntered");
				if(dateTime!=null){
					production.setDateTimeEntered(new Date(dateTime.getTime()));
					
					int min=CommonUtil.getMinutesDiff(new Date(dateTime.getTime()), new Date());
					
					if(min>0 && min<=5){
						production.setNewRed(true);
					}
					
					
				}
				
				production.setRollNumber(rs.getString("RollNumber"));
				production.setSetPosition(rs.getString("SetPosition"));
				production.setShift(rs.getString("Shift"));
				production.setGradeCode(rs.getString("GradeCode"));
				production.setCustomerGradeCode(rs.getString("CustomerGradeCode"));
				production.setWhiteWeight(rs.getDouble("WhiteWeight"));
				production.setRedWeight(rs.getDouble("RedWeight"));
				production.setRejectWeight(rs.getDouble("RejectWeight"));
/*				production.setQualityHold(rs.getBoolean("QualityHold"));
				production.setOrderNumber(rs.getString("OrderNumber"));
				production.setProductionTime(rs.getString("ProductionTime"));
				production.setTeam(rs.getString("Team"));*/
				production.setInitials(rs.getString("Initials"));
				production.setDiameter(rs.getString("Diameter"));
				production.setRollWidth(rs.getString("RollWidth"));
				//production.setPly(rs.getInt("Ply"));
				production.setCoreSize(rs.getString("CoreSize"));
				//production.setBarcode(rs.getString("Barcode"));//This BarCode Commented By Roshan Tailor
				production.setComment(rs.getString("Comment"));
				/*production.setTransferDate(rs.getString("TransferDate"));
				production.setTransferLocation(rs.getString("TransferLocation"));
				production.setCustomer(rs.getString("Customer"));
				production.setRedValue(rs.getString("RedValue"));
				production.setRedCode(rs.getString("RedCode"));
				production.setRedCodeValue(rs.getString("RedCodeValue"));
				production.setRedCustomer(rs.getString("RedCustomer"));
				production.setParentRoll(rs.getString("ParentRoll"));
				production.setLabelPrinted(rs.getString("LabelPrinted"));
				production.setBreaks(rs.getString("Breaks"));
				production.setStartDateTime(rs.getString("StartDateTime"));*/
				
				Timestamp dateShip=rs.getTimestamp("DateShipped");
				if(dateShip!=null){
					production.setDateShipped(new Date(dateShip.getTime()));
				}
			/*	production.setNextSet(rs.getString("NextSet"));
				production.setInvoiceDate(rs.getString("InvoiceDate"));
				production.setInvoiceNumber(rs.getString("InvoiceNumber"));
				production.setInvoiceType(rs.getString("InvoiceType"));
				production.setSlabDate(rs.getString("SlabDate"));
			 */
				
				return production;
			}});
		return productions;
	}



	/* (non-Javadoc)
	 * @see com.st.production.dao.WrapperProductionDao#isNewRedEntryExist_PM5()
	 */
	@Override
	public Map<String, Object> isNewRedEntryExist_PM5() {
		Map<String, Object> map=new HashMap<String, Object>();
		
		Calendar sCal=Calendar.getInstance();
		sCal.setTime(new Date());
		sCal.add(Calendar.MINUTE, -5);
		
		Calendar eCal=Calendar.getInstance();
		eCal.setTime(new Date());
		
		
		
		String sql="SELECT count(*) FROM [tblWrapperProduction] where ( [RedWeight]>0 or  [RejectWeight]>0)  and WrapperNumber='WR5' and WrapperNumber<>'ZZZ' and [DateTimeEntered] between ? and ?";
		
		int count=0;
		try {
			count=dataSourceProductionTemplate.queryForObject(sql,new Object[]{
					new Timestamp(sCal.getTime().getTime()),
					new Timestamp(eCal.getTime().getTime())

			}, Integer.class);
		} catch (Exception e) {
			logger.error("Error In get red/reject count="+e.getMessage());
		}
		
		//System.out.println(sCal.getTime()+"\t"+eCal.getTime()+"=="+count);
		
		
		
		if(count>0){
			map.put("flag", true);
		}else{
			map.put("flag", false);
		}
		
		
		
		Calendar calendar=Calendar.getInstance();
		calendar.setTime(CommonUtil.getShiftDate());
		calendar.set(Calendar.HOUR_OF_DAY, 7);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		
		
		String sql2="SELECT count(*) FROM [tblWrapperProduction] where ( [RedWeight]>0 or  [RejectWeight]>0)  and WrapperNumber='WR5' and WrapperNumber<>'ZZZ' and [DateTimeEntered] between ? and ? ";
		
		int count2=0;
		try {
			count2=dataSourceProductionTemplate.queryForObject(sql2,new Object[]{
					new Timestamp(calendar.getTime().getTime()),
					new Timestamp(new Date().getTime())

			}, Integer.class);
		} catch (Exception e) {
			logger.error("Error In get red/reject count="+e.getMessage());
		}
		
		map.put("count", count2);
		
		
		return map;
	}








}

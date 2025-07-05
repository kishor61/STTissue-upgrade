/**
 * 
 */
package com.st.frpproduction.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.joda.time.Days;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.st.common.Columns;
import com.st.common.CommonUtil;
import com.st.frpproduction.mapper.FrpProdcutionMapper;
import com.st.frpproduction.model.FrpProdcution;
import com.st.frpproduction.model.FrpProdcutionOperatorDataEntry;

/**
 * @author sbora
 *
 */
@Repository
public class FrpProdcutionDaoImp implements FrpProdcutionDao {
	private static final Logger logger=LoggerFactory.getLogger(FrpProdcutionDaoImp.class);
	@Autowired
	private DataSource dataSource;


	@Override
	public int save(final FrpProdcution frpProdcution) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		KeyHolder keyHolder=new GeneratedKeyHolder();
		
		final String sql="insert into [frpProductionData]"
				+ "("
				+ "[Date],"
				+ "[HdStorage],"
				+ "[DcsWPFeedADST],"
				+ "[PrimaryPressADST],"
				+ "[WetLapProdADST],"
				+ "[TotalProdADST],"
				+ "[TrackerWPfeed],"
				+ "[YieldDcs],"
				+ "[YieldTracker],"
				+ "[FreshWater],"
				+ "[MRMwlAndSwl],"
				+ "[MRSowAndCbs],"
				+ "[MRDlk],"
				+ "[MROcc],"
				+ "[MRWhiteGrades],"
				+ "[MRGroundwood],"
				+ "[MROther],"
				+ "[WPMMwl],"
				+ "[WPMPrintMix],"
				+ "[WPMSow],"
				+ "[WPMCbs],"
				+ "[WPMSowAndCbs],"
				+ "[WPMCtdGrwd],"
				+ "[WPMSwl],"
				+ "[WPMOcc],"
				+ "[WPMNewsNewsblank],"
				+ "[WPMDlk],"
				+ "[WPMOther],"
				+ "[WPMTotal],"
				+ "[TargetBrightness],"
				+ "[DailyAvg],"
				+ "[PMTargetBrite],"
				+ "[PMAvgBrite],"
				+ "[Comments],"
				+ "[ProdType],"
				+ "[WPMailUndeliverable],"
				+ "[Grade],"
				+ "[FreshWater2]"
//				Code Starts From Here Done By Roshan Tailor Date :- 06/17/2015
				//New 7 Fields Are Added Here
				//+ "[ClarifierunderflowpumpruningYN],"
				//+ "[Sludgepressconsistency],"
				//+ "[Screwpressconsistency],"
				//+ "[Mixratiobrightness],"
//				+ "[Eric],"
//				+ "[Astar],"
//				+ "[Bstar]"
//				Code Ends Here Done By Roshan Tailor
				+ ") values(?,?,?,?,?,?,"
				+ "?,?,?,?,?,?,?,?,?,?,?,"
				+ "?,?,?,?,?,?,?,?,?,?,?,"
				+ "?,?,"
				+ "?,?,?,?,?,?,?,?)";   //Here Roshan Tailor Added 7 ? (Question Marks). //Remove 3 ? Date :- 03/25/2015
		jdbcTemplate.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection arg0)
					throws SQLException {
				PreparedStatement statement=arg0.prepareStatement(sql,new String[]{"ID"});
				
				Timestamp timestamp=new Timestamp(frpProdcution.getDate().getTime());
				statement.setTimestamp(Columns.COL_01, timestamp);

				statement.setDouble(Columns.COL_02, frpProdcution.getHdStorage());
				statement.setDouble(Columns.COL_03, frpProdcution.getDcsWPFeedADST());
				statement.setDouble(Columns.COL_04, frpProdcution.getPrimaryPressADST());
				statement.setDouble(Columns.COL_05, frpProdcution.getWetLapProdADST());
				statement.setDouble(Columns.COL_06, frpProdcution.getTotalProdADST());
				statement.setDouble(Columns.COL_07, frpProdcution.getTrackerWPfeed());
				statement.setDouble(Columns.COL_08, frpProdcution.getYieldDcs());
				statement.setDouble(Columns.COL_09, frpProdcution.getYieldTracker());
				statement.setDouble(Columns.COL_10, frpProdcution.getFreshWater());
				statement.setDouble(Columns.COL_11, frpProdcution.getMrMwlAndSwl());
				statement.setDouble(Columns.COL_12, frpProdcution.getMrSowAndCbs());
				statement.setDouble(Columns.COL_13, frpProdcution.getMrDlk());
				statement.setDouble(Columns.COL_14, frpProdcution.getMrOcc());
				statement.setDouble(Columns.COL_15, frpProdcution.getMrWhiteGrades());
				statement.setDouble(Columns.COL_16, frpProdcution.getMrGroundwood());
				statement.setDouble(Columns.COL_17, frpProdcution.getMrOther());
				statement.setDouble(Columns.COL_18, frpProdcution.getWpmMwl());
				statement.setDouble(Columns.COL_19, frpProdcution.getWpmPrintMix());
				statement.setDouble(Columns.COL_20, frpProdcution.getWpmSow());
				statement.setDouble(Columns.COL_21, frpProdcution.getWpmCbs());
				statement.setDouble(Columns.COL_22, frpProdcution.getWpmSowAndCbs());
				statement.setDouble(Columns.COL_23, frpProdcution.getWpmCtdGrwd());
				statement.setDouble(Columns.COL_24, frpProdcution.getWpmSwl());
				statement.setDouble(Columns.COL_25, frpProdcution.getWpmOcc());
				statement.setDouble(Columns.COL_26, frpProdcution.getWpmNewsNewsblank());
				statement.setDouble(Columns.COL_27, frpProdcution.getWpmDlk());
				statement.setDouble(Columns.COL_28, frpProdcution.getWpmOther());
				statement.setDouble(Columns.COL_29, frpProdcution.getWpmTotal());
				statement.setString(Columns.COL_30, frpProdcution.getTargetBrightness());
				statement.setDouble(Columns.COL_31, frpProdcution.getDailyAvg());
				statement.setString(Columns.COL_32, frpProdcution.getPmTargetBrite());
				statement.setString(Columns.COL_33, frpProdcution.getPmAvgBrite());
				statement.setString(Columns.COL_34, frpProdcution.getComments());
				statement.setString(Columns.COL_35, frpProdcution.getProdType());
				statement.setDouble(Columns.COL_36, frpProdcution.getWpMailUndeliverable());
				statement.setString(Columns.COL_37, frpProdcution.getGrade());
				statement.setDouble(Columns.COL_38, frpProdcution.getFreshWater2());
//				Code Starts From Here Done By Roshan TAilor Date := 03/17/2015
//				In Database We Counts 39th Column And Will Start From There And Will Go Till 45th Column
				//statement.setString(Columns.COL_39, frpProdcution.getClarifierunderflowpumpruningYN());
				//statement.setDouble(Columns.COL_40, frpProdcution.getSludgepressconsistency());
				//statement.setDouble(Columns.COL_41, frpProdcution.getScrewpressconsistency());
				//statement.setDouble(Columns.COL_42, frpProdcution.getMixratiobrightness());
//				statement.setDouble(Columns.COL_39, frpProdcution.getEric());
//				statement.setString(Columns.COL_40, frpProdcution.getAstar());
//				statement.setString(Columns.COL_41, frpProdcution.getBstar());
//				Code Ends Here Done By Roshan Tailor
				
				return statement;
			}
		},keyHolder);
		
		return keyHolder.getKey().intValue();
	}

	@Override
	public void update(final FrpProdcution frpProdcution) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		
		final String sql="update [frpProductionData] set "
				+ "[Date]=?,"
				+ "[HdStorage]=?,"
				+ "[DcsWPFeedADST]=?,"
				+ "[PrimaryPressADST]=?,"
				+ "[WetLapProdADST]=?,"
				+ "[TotalProdADST]=?,"
				+ "[TrackerWPfeed]=?,"
				+ "[YieldDcs]=?,"
				+ "[YieldTracker]=?,"
				+ "[FreshWater]=?,"
				+ "[MRMwlAndSwl]=?,"
				+ "[MRSowAndCbs]=?,"
				+ "[MRDlk]=?,"
				+ "[MROcc]=?,"
				+ "[MRWhiteGrades]=?,"
				+ "[MRGroundwood]=?,"
				+ "[MROther]=?,"
				+ "[WPMMwl]=?,"
				+ "[WPMPrintMix]=?,"
				+ "[WPMSow]=?,"
				+ "[WPMCbs]=?,"
				+ "[WPMSowAndCbs]=?,"
				+ "[WPMCtdGrwd]=?,"
				+ "[WPMSwl]=?,"
				+ "[WPMOcc]=?,"
				+ "[WPMNewsNewsblank]=?,"
				+ "[WPMDlk]=?,"
				+ "[WPMOther]=?,"
				+ "[WPMTotal]=?,"
				+ "[TargetBrightness]=?,"
				+ "[DailyAvg]=?,"
				+ "[PMTargetBrite]=?,"
				+ "[PMAvgBrite]=?,"
				+ "[Comments]=?,"
				+ "[ProdType]=?,"
				+ "[WPMailUndeliverable]=?,"
				+ "[Grade]=?,"
				+ "[FreshWater2]=? "
//				Code Starts From Here Done By Roshan Tailor Date :- 03/17/2015 MM/DD/YYYY
				//+ "[ClarifierunderflowpumpruningYN]=?, "
				//+ "[Sludgepressconsistency]=?, "
				//+ "[Screwpressconsistency]=?, "
				//+ "[Mixratiobrightness]=?, "
//				+ "[Eric]=?, "
//				+ "[Astar]=?, "
//				+ "[Bstar]=? "
//				Code Ends Here Done By Roshan Tailor
				+" where [ID]=?";
		
		jdbcTemplate.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection arg0)
					throws SQLException {
				PreparedStatement statement=arg0.prepareStatement(sql);
				
				Timestamp timestamp=new Timestamp(frpProdcution.getDate().getTime());
				statement.setTimestamp(Columns.COL_01, timestamp);

				statement.setDouble(Columns.COL_02, frpProdcution.getHdStorage());
				statement.setDouble(Columns.COL_03, frpProdcution.getDcsWPFeedADST());
				statement.setDouble(Columns.COL_04, frpProdcution.getPrimaryPressADST());
				statement.setDouble(Columns.COL_05, frpProdcution.getWetLapProdADST());
				statement.setDouble(Columns.COL_06, frpProdcution.getTotalProdADST());
				statement.setDouble(Columns.COL_07, frpProdcution.getTrackerWPfeed());
				statement.setDouble(Columns.COL_08, frpProdcution.getYieldDcs());
				statement.setDouble(Columns.COL_09, frpProdcution.getYieldTracker());
				statement.setDouble(Columns.COL_10, frpProdcution.getFreshWater());
				statement.setDouble(Columns.COL_11, frpProdcution.getMrMwlAndSwl());
				statement.setDouble(Columns.COL_12, frpProdcution.getMrSowAndCbs());
				statement.setDouble(Columns.COL_13, frpProdcution.getMrDlk());
				statement.setDouble(Columns.COL_14, frpProdcution.getMrOcc());
				statement.setDouble(Columns.COL_15, frpProdcution.getMrWhiteGrades());
				statement.setDouble(Columns.COL_16, frpProdcution.getMrGroundwood());
				statement.setDouble(Columns.COL_17, frpProdcution.getMrOther());
				
				statement.setDouble(Columns.COL_18, frpProdcution.getWpmMwl());
				statement.setDouble(Columns.COL_19, frpProdcution.getWpmPrintMix());
				statement.setDouble(Columns.COL_20, frpProdcution.getWpmSow());
				statement.setDouble(Columns.COL_21, frpProdcution.getWpmCbs());
				statement.setDouble(Columns.COL_22, frpProdcution.getWpmSowAndCbs());
				statement.setDouble(Columns.COL_23, frpProdcution.getWpmCtdGrwd());
				statement.setDouble(Columns.COL_24, frpProdcution.getWpmSwl());
				statement.setDouble(Columns.COL_25, frpProdcution.getWpmOcc());
				statement.setDouble(Columns.COL_26, frpProdcution.getWpmNewsNewsblank());
				statement.setDouble(Columns.COL_27, frpProdcution.getWpmDlk());
				statement.setDouble(Columns.COL_28, frpProdcution.getWpmOther());
				statement.setDouble(Columns.COL_29, frpProdcution.getWpmTotal());
				statement.setString(Columns.COL_30, frpProdcution.getTargetBrightness());
				statement.setDouble(Columns.COL_31, frpProdcution.getDailyAvg());
				statement.setString(Columns.COL_32, frpProdcution.getPmTargetBrite());
				statement.setString(Columns.COL_33, frpProdcution.getPmAvgBrite());
				statement.setString(Columns.COL_34, frpProdcution.getComments());
				statement.setString(Columns.COL_35, frpProdcution.getProdType());

				statement.setDouble(Columns.COL_36, frpProdcution.getWpMailUndeliverable());
				statement.setString(Columns.COL_37, frpProdcution.getGrade());
				
				statement.setDouble(Columns.COL_38, frpProdcution.getFreshWater2());
//				Code Starts From Here Done By Roshan Tailor Date :- 03/17/2015 MM/DD/YYYY
				//statement.setString(Columns.COL_39, frpProdcution.getClarifierunderflowpumpruningYN());
				//statement.setDouble(Columns.COL_40, frpProdcution.getSludgepressconsistency());
				//statement.setDouble(Columns.COL_41, frpProdcution.getScrewpressconsistency());
				//statement.setDouble(Columns.COL_42, frpProdcution.getMixratiobrightness());
//				statement.setDouble(Columns.COL_39, frpProdcution.getEric());
//				statement.setString(Columns.COL_40, frpProdcution.getAstar());
//				statement.setString(Columns.COL_41, frpProdcution.getBstar());
				
//				Code Ends Here Done By Roshan Tailor
				statement.setInt(Columns.COL_39, frpProdcution.getId()); // Before Here Was COL_19//After Then Here Was Col_46 //Now Is 29
				return statement;
			}
		});
	}

	@Override
	public List<FrpProdcution> getFrpProdcutions(Date sdate, Date edate,
			String prodType,String grade) {/*
		// TODO Auto-generated method stub
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		
		if(StringUtils.isNotEmpty(grade)){
			String sql="select * from [frpProductionData] where "
					+ "([Date] between ? and ?) and [ProdType]=? and [Grade]=? order by [Date]";
			
			List<FrpProdcution> frpProdcutions=jdbcTemplate.query(sql, new Object[]{
					new Timestamp(sdate.getTime()),
					new Timestamp(edate.getTime()),
					prodType,
					grade
			}, new FrpProdcutionMapper());
			
			
			return frpProdcutions;

		}else{
			String sql="select * from [frpProductionData] where "
					+ "([Date] between ? and ?) and [ProdType]=? order by [Date]";
			
			List<FrpProdcution> frpProdcutions=jdbcTemplate.query(sql, new Object[]{
					new Timestamp(sdate.getTime()),
					new Timestamp(edate.getTime()),
					prodType
			}, new FrpProdcutionMapper());
			
			
			return frpProdcutions;
			
		}
	*/

		// TODO Auto-generated method stub
		
		List<FrpProdcution> data=new ArrayList<FrpProdcution>();
		
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		Calendar calendar=Calendar.getInstance();
		calendar.setTime(sdate);
		
		System.out.println("sdate:"+sdate);
		int days=Days.daysBetween(new DateTime(sdate.getTime()), new DateTime(edate.getTime())).getDays();
		
		Calendar date=Calendar.getInstance();
		date.setTime(sdate);
		
		
			for (int i = 0; i <=days; i++) {
			
			
			Calendar scal=Calendar.getInstance();
			scal.setTime(date.getTime());
			
			Date dateS=scal.getTime();
			
			final FrpProdcution opdetails=new FrpProdcution();
			opdetails.setDate(dateS);
			
			String sql="SELECT dates,SUM (col1) As Col1AVG, SUM (col2) As Col2AVG, SUM (col3) As Col3AVG, SUM (col4) As Col4AVG, SUM (col5) As Col5AVG"
					+ ", SUM (col6) As Col6AVG, SUM (col7) As Col7AVG, SUM (col8) As Col8AVG, SUM (col9) As Col9AVG, SUM (col10) As Col10AVG, SUM (col11) As Col11AVG"
					+ " FROM FrpProdcutionOperatorDataEntry where [Dates]= ? group by dates";
			
			/*String sql="SELECT TOP 1 shift,col1 As Col1AVG, col2 As Col2AVG, col3 As Col3AVG, col4 As Col4AVG, col5 As Col5AVG, "
					+ "col6 As Col6AVG, col7 As Col7AVG, col8 As Col8AVG, col9 As Col9AVG, col10 As Col10AVG, col11 As Col11AVG "
					+ "FROM FrpProdcutionOperatorDataEntry where [Dates]= ? ORDER BY Shift DESC ";*/
			
			List<Map<String, Object>> data1=jdbcTemplate.queryForList(sql,new Object[]{scal.getTime()});
			

			double col1=0;
			double col2=0;
			double col3=0;
			double col4=0;
			double col5=0;
			double col6=0;
			double col7=0;
			double col8=0;
			double col9=0;
			double col10=0;
			double col11=0;
			Date dateEntry=null;
			
			if(data1.size()>0){
				for (Map<String, Object> datas : data1) {
					
					dateEntry=(Date)datas.get("dates");
					col1=(Double)datas.get("Col1AVG")==null?0:(Double)(datas.get("Col1AVG"));
					col2=(Double)datas.get("Col2AVG")==null?0:(Double)(datas.get("Col2AVG"));
					col3=(Double)datas.get("Col3AVG")==null?0:(Double)(datas.get("Col3AVG"));
					col4=(Double)datas.get("Col4AVG")==null?0:(Double)(datas.get("Col4AVG"));
					col5=(Double)datas.get("Col5AVG")==null?0:(Double)(datas.get("Col5AVG"));
					col6=(Double)datas.get("Col6AVG")==null?0:(Double)(datas.get("Col6AVG"));
					col7=(Double)datas.get("Col7AVG")==null?0:(Double)(datas.get("Col7AVG"));
					col8=(Double)datas.get("Col8AVG")==null?0:(Double)(datas.get("Col8AVG"));
					col9=(Double)datas.get("Col9AVG")==null?0:(Double)(datas.get("Col9AVG"));
					col10=(Double)datas.get("Col10AVG")==null?0:(Double)(datas.get("Col10AVG"));
					
					try {
						String sql2="SELECT TOP 1 shift,col1 As Col1AVG, col2 As Col2AVG, col3 As Col3AVG, col4 As Col4AVG, col5 As Col5AVG, "
								+ "col6 As Col6AVG, col7 As Col7AVG, col8 As Col8AVG, col9 As Col9AVG, col10 As Col10AVG, col11 As Col11AVG "
								+ "FROM FrpProdcutionOperatorDataEntry where [Dates]= ? ORDER BY Shift DESC ";
						
						List<Map<String, Object>> data2=jdbcTemplate.queryForList(sql2,new Object[]{dateEntry});
						if(data2.size()>0){
							for (Map<String, Object> datas2 : data2) {
								col11=(Double)datas2.get("Col11AVG")==null?0:(Double)(datas2.get("Col11AVG"));
							}
							
						}
					}catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}
					
					
					
					opdetails.setCol1(CommonUtil.round(col1, 2));
					opdetails.setCol2(CommonUtil.round(col2, 2));
					opdetails.setCol3(CommonUtil.round(col3, 2));
					opdetails.setCol4(CommonUtil.round(col4, 2));
					opdetails.setCol5(CommonUtil.round(col5, 2));
					opdetails.setCol6(CommonUtil.round(col6, 2));
					opdetails.setCol7(CommonUtil.round(col7, 2));
					opdetails.setCol8(CommonUtil.round(col8, 2));
					opdetails.setCol9(CommonUtil.round(col9, 2));
					opdetails.setCol10(CommonUtil.round(col10, 2));
					opdetails.setCol11(CommonUtil.round(col11, 2));
					
					data.add(opdetails);	
				}
				
				}
			
			
			 date.add(Calendar.DATE, 1);
	}
	return data;

		}

	@Override
	public FrpProdcution getFrpProdcution(int id) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		
		String sql="select * from [frpProductionData] where "
				+ " [ID]=?";
		
		FrpProdcution frpProdcution=jdbcTemplate.queryForObject(sql, new Object[]{
				id
		}, new FrpProdcutionMapper());
		
		return frpProdcution;
	}

	
	@Override
	public void delete(int id) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		
		String sql="delete from [frpProductionData] where "
				+ " [ID]=?";
		
		jdbcTemplate.update(sql, new Object[]{id});
	}

	
	@Override
	public FrpProdcution getFrpProdcutionLast(Date date) {
	JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		
		String sql="select TOP 1 * from [frpProductionData] where "
				+ "[Date]=? order by [Date] desc";
		
		FrpProdcution frpProdcution=null;
		try {
			frpProdcution=jdbcTemplate.queryForObject(sql, new Object[]{
					new Timestamp(date.getTime())
			}, new FrpProdcutionMapper());
			
		} catch (EmptyResultDataAccessException e) {
			logger.error(e.getMessage(),e);
		}

		return frpProdcution;
	}


	@Override
	public FrpProdcution getMTDFrpProdcution(Date edate,String prodType) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		
		Calendar calendar=Calendar.getInstance();
		calendar.setTime(edate);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		
		Date sdate=calendar.getTime();
		String sql="SELECT  "
				+ "sum([DcsWPFeedADST]) as DcsWPFeedADSTDTotal , "
				+ "sum([TotalProdADST])  as TotalProdADSTTotal, "
				+ "sum([TrackerWPfeed]) as TrackerWPfeedTotal "
				+ "FROM [frpProductionData] where ([Date] between ? and ?)  "
				+ "and"
				+ "[ProdType]=?";
		
		FrpProdcution frpProdcution=jdbcTemplate.queryForObject(sql, new Object[]{
				new Timestamp(sdate.getTime()),
				new Timestamp(edate.getTime()),
				prodType
		}, new RowMapper<FrpProdcution>() {

			@Override
			public FrpProdcution mapRow(ResultSet rs, int arg1) throws SQLException {
				FrpProdcution frpProdcution=new FrpProdcution();
				
				frpProdcution.setDcsWPFeedADSTTotal(rs.getDouble("DcsWPFeedADSTDTotal"));
				frpProdcution.setTotalProdADSTTotal(rs.getDouble("TotalProdADSTTotal"));
				frpProdcution.setTrackerWPfeedTotal(rs.getDouble("TrackerWPfeedTotal"));
				
				return frpProdcution;
			}
		});
		
		return frpProdcution;
	}


//	Code Starts From Here Done By Roshan Tailor Date :- 03/18/2015
	
//	Code Ends Here Done By Roshan Tailor
	
	

	
}

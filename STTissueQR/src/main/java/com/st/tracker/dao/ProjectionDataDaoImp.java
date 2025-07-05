/**
 * 
 */
package com.st.tracker.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.st.common.CommonUtil;
import com.st.tracker.model.BaleInventory;
import com.st.tracker.model.ProjectionData;
import com.st.tracker.model.PurchaseHeaderDetail;

/**
 * @author sbora
 *
 */
@Repository
public class ProjectionDataDaoImp implements ProjectionDataDao{

	@Autowired
	@Qualifier("dataSourceTracker")
	private DataSource dataSourceT;
	
	@Autowired
	private DataSource dataSource;
	
	@Autowired
	@Qualifier("dataSourceProduction")
	private DataSource dataSourceP;
	
	@Override
	public List<ProjectionData> getProjectionData(Date sdate, Date edate,
			List<Integer> gradeIds) {
		
		
		
		
		NamedParameterJdbcTemplate jdbcTemplate=new NamedParameterJdbcTemplate(dataSourceP);
		
		Date date=CommonUtil.getDateTime(sdate, new Date());
		
		
		// Date fromfrpprojectionreport
		MapSqlParameterSource parameterSource=new MapSqlParameterSource();
		parameterSource.addValue("date", new Timestamp(date.getTime()));
		parameterSource.addValue("grades", gradeIds);
		
		String sql="SELECT "
				+ "sum(b.[BaleWeight])/2000 AS [Weight],  "
				+ "b.[GradeCode],  "
				+ "g.[Grade] "
				+ "FROM tblBaleInventory AS b, tlkpGrade AS g "
				+ "WHERE "
				+ "	b.[UnloadDate]<=:date "
				+ "And "
				+ "b.[GradeCode]=g.[GradeCode] "
				+ "And "
				+ " b.[ConsumedDate]is Null "
				+ " And "
				+ "  b.[GradeCode] in (:grades) "
				+ " And "
				+ " b.[GradeCode] Not in (5,21)"
				+ " GROUP BY b.[GradeCode], g.[Grade] "
				+ " order by b.[GradeCode]";
		
				
		List<ProjectionData> proDatas=jdbcTemplate.query(sql,parameterSource,new RowMapper<ProjectionData>() {

			@Override
			public ProjectionData mapRow(ResultSet rs, int arg1)
					throws SQLException {
					ProjectionData projectionData=new ProjectionData();
					projectionData.setWeight(rs.getDouble("Weight"));
					projectionData.setGradeCode(rs.getInt("GradeCode"));
					projectionData.setGrade(rs.getString("Grade"));
				return projectionData;
			}
		});
		
		List<ProjectionData> projections=new ArrayList<ProjectionData>(proDatas);
		
		proDatas.clear();
		
		
		
		List<ProjectionData> projectionDatas=new ArrayList<ProjectionData>();
		
		for (ProjectionData projectionData : projections) {
			projectionDatas.add(projectionData);
		}
		
		for (Integer id : gradeIds) {
			ProjectionData projection=getProjectDataByGrade(projections,id);
			if(projection==null){
				String sqlgrade="select [Grade] from [tlkpGrade] where [GradeCode]=:grade";
				MapSqlParameterSource source=new MapSqlParameterSource();
				source.addValue("grade", id);
				String grade=jdbcTemplate.queryForObject(sqlgrade, source, String.class);
				ProjectionData data=new ProjectionData();
				data.setGrade(grade);
				data.setGradeCode(id);
				projectionDatas.add(data);
			}
		}
		
		
		Collections.sort(projectionDatas, new Comparator<ProjectionData>() {
			@Override
			public int compare(ProjectionData arg0, ProjectionData arg1) {
				return new Integer(arg0.getGradeCode()).compareTo(arg1.getGradeCode());
			}
		});
		
	//	System.out.println(gradeIds);
		
		
		for (ProjectionData projectionData : projectionDatas) {
			
			MapSqlParameterSource parameterSource2=new MapSqlParameterSource();
			parameterSource2.addValue("sdate", new Timestamp(sdate.getTime()));
			parameterSource2.addValue("edate", new Timestamp(edate.getTime()));
			parameterSource2.addValue("gradeCode", projectionData.getGradeCode());
			String sql3="SELECT "
					+ "count(*) as [Count],"
					+ "d.[GradeCode], "
					+ "h.[DeliveryDate] "
					+ "FROM tblPurchaseHeader AS h, tblPurchaseDetail AS d WHERE "
					+ "(h.DeliveryDate between :sdate  and :edate) "
					+ " and "
					+ " d.[ReleaseNumber]=h.[ReleaseNumber] "
					+ "And "
					+ " h.[LoadStatus]='Enroute' "
					+ " And "
					+ "d.[GradeCode]=:gradeCode "
					+ "Group by d.[GradeCode],h.[DeliveryDate] ";
			
			
			List<PurchaseHeaderDetail> headerDetails=jdbcTemplate.query(sql3, parameterSource2, new RowMapper<PurchaseHeaderDetail>() {

				@Override
				public PurchaseHeaderDetail mapRow(ResultSet rs, int arg1)
						throws SQLException {
					PurchaseHeaderDetail headerDetail=new PurchaseHeaderDetail();
					headerDetail.setCount(rs.getInt("count"));
					headerDetail.setGrade(rs.getString("GradeCode"));
					headerDetail.setDeliveryDate(new Date(rs.getTimestamp("DeliveryDate").getTime()));
					return headerDetail;
				}
			});
			
			//Yard 
			MapSqlParameterSource parameterSource3=new MapSqlParameterSource();
			parameterSource3.addValue("gradeCode", projectionData.getGradeCode());
			
			String sql4="SELECT "
					+ "count(*) as [Count] "
					+ "FROM tblPurchaseHeader AS h, tblPurchaseDetail AS d WHERE  "
					+ "d.[ReleaseNumber]=h.[ReleaseNumber] "
					+ "And "
					+ "d.[GradeCode]=:gradeCode "
					+ "And "
					+ "h.[LoadStatus]='Yard' "
					+ "Group by d.[GradeCode] ";
			
			int yardCount=0;
			try {
				yardCount=jdbcTemplate.queryForObject(sql4, parameterSource3, Integer.class);
			} catch (Exception e) {
				//Row 
			}
					
			
			//Pending
			//Yard 
			MapSqlParameterSource parameterSource4=new MapSqlParameterSource();
			parameterSource4.addValue("gradeCode", projectionData.getGradeCode());
			parameterSource4.addValue("sdate", new Timestamp(sdate.getTime()));
			
			String sql5="SELECT "
					+ "count(*) as [Count] "
					+ "FROM tblPurchaseHeader AS h, tblPurchaseDetail AS d WHERE  "
					+ "d.[ReleaseNumber]=h.[ReleaseNumber] "
					+ "And "
					+ "h.DeliveryDate<:sdate "
					+ "And "
					+ "d.[GradeCode]=:gradeCode "
					+ "And "
					+ "h.[LoadStatus]='Enroute' "
					+ "Group by d.[GradeCode] ";
			
			int pendingCount=0;
			try {
				pendingCount=jdbcTemplate.queryForObject(sql5, parameterSource4, Integer.class);
			} catch (Exception e) {
				//Row 
			}
			
			
			projectionData.setHeaderDetails(headerDetails);
			
			Calendar sCal=Calendar.getInstance();
			sCal.setTime(sdate);
			sCal.set(Calendar.HOUR_OF_DAY,0);
			sCal.set(Calendar.MINUTE,0);
			sCal.set(Calendar.SECOND,0);
			sCal.set(Calendar.MILLISECOND,0);
			
			int days=CommonUtil.getDaysDiffernce(sdate, edate);
			for(int i=0;i<=days;i++){
				int inbound=getInbound(headerDetails,sCal.getTime());
				if(i==0){
					//System.out.println("Pending Count="+pendingCount+"\tYard="+yardCount+"\t Grade="+projectionData.getGradeCode());
					
					inbound+=(yardCount+pendingCount);
				}
				
				projectionData.getInbounds().add(inbound*20);
				
				sCal.add(Calendar.DATE, 1);
			}
			
			
		}

		
		
		
		
		return projectionDatas;
	}

	
	/**
	 * @param projections
	 * @param id
	 * @return
	 */
	private ProjectionData getProjectDataByGrade(
			List<ProjectionData> projections, Integer id) {
		ProjectionData projection=null;
		for (ProjectionData projectionData : projections) {
			if(projectionData.getGradeCode()==id){
				projection=projectionData;
				break;
			}
		}
		return projection;
	}


	private int getInbound(List<PurchaseHeaderDetail> headerDetails, Date time) {
		int inbound=0;
		for (PurchaseHeaderDetail purchaseHeaderDetail : headerDetails) {
			if(CommonUtil.isEqual(time, purchaseHeaderDetail.getDeliveryDate())){
				inbound=purchaseHeaderDetail.getCount();
				break;
			}
		}
		return inbound;
	}


	
	@Override
	public void saveProjectionDataTemp(final List<ProjectionData> projectionDatas) {
		
		
		JdbcTemplate jdbcTemplateTemp=new JdbcTemplate(dataSource);
		String sql1="delete from [frpProjectionDataTemp]";
		jdbcTemplateTemp.execute(sql1);
		String sql2="delete from [frpProjectionDataTemp2]";
		jdbcTemplateTemp.execute(sql2);
		
		
		String insertSql1="insert into [frpProjectionDataTemp]("
				+ "[Weight],[GradeCode],[Grade]"
				+ ") values(?,?,?)";
		jdbcTemplateTemp.batchUpdate(insertSql1, new BatchPreparedStatementSetter(){

			@Override
			public int getBatchSize() {
				return projectionDatas.size();
			}

			@Override
			public void setValues(PreparedStatement statement, int i)
					throws SQLException {
				ProjectionData projectionData=projectionDatas.get(i);
				statement.setDouble(1, projectionData.getWeight());
				statement.setInt(2, projectionData.getGradeCode());
				statement.setString(3, projectionData.getGrade());
			}
			
		});
		
		for (ProjectionData projectionData : projectionDatas) {
			
			final List<PurchaseHeaderDetail> headerDetails=projectionData.getHeaderDetails();
		
			final String insertSql2="insert into [frpProjectionDataTemp2]("
					+ "[InboundCount],[GradeCode],[DeliveryDate] "
					+ ") values(?,?,?)";


			for (final PurchaseHeaderDetail purchaseHeaderDetail : headerDetails) {
				jdbcTemplateTemp.update(new PreparedStatementCreator() {
					
					@Override
					public PreparedStatement createPreparedStatement(Connection arg0)
							throws SQLException {
						PreparedStatement statement=arg0.prepareStatement(insertSql2);
						statement.setInt(1, purchaseHeaderDetail.getCount());
						statement.setString(2, purchaseHeaderDetail.getGrade());
						statement.setTimestamp(3, new Timestamp(purchaseHeaderDetail.getDeliveryDate().getTime()));
						return statement;
					}
				});
			}
			
		}
		
	}


	/* (non-Javadoc)
	 * @see com.st.tracker.dao.ProjectionDataDao#getProjectionDataTemp()
	 */
	@Override
	public List<ProjectionData> getProjectionDataTemp(Date sdate, Date edate, List<Integer> gradeIds) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		
		
		// Date from
		
		String sql="SELECT "
				+ "[Weight],  "
				+ "[GradeCode],  "
				+ "[Grade] "
				+ "FROM [frpProjectionDataTemp]";
		
			List<ProjectionData> projectionDatas=jdbcTemplate.query(sql,new RowMapper<ProjectionData>() {

			@Override
			public ProjectionData mapRow(ResultSet rs, int arg1)
					throws SQLException {
					ProjectionData projectionData=new ProjectionData();
					projectionData.setWeight(rs.getDouble("Weight"));
					projectionData.setGradeCode(rs.getInt("GradeCode"));
					projectionData.setGrade(rs.getString("Grade"));
				return projectionData;
			}
		});
		
		
		for (ProjectionData projectionData : projectionDatas) {
			
			String sql3="SELECT "
					+ "[InboundCount],"
					+ "[GradeCode], "
					+ "[DeliveryDate] "
					+ "FROM [frpProjectionDataTemp2] "
					+ " WHERE "
					+ " [GradeCode]=? ";
			
			
			List<PurchaseHeaderDetail> headerDetails=jdbcTemplate.query(sql3, new Object[]{new Integer(projectionData.getGradeCode()).toString()}, new RowMapper<PurchaseHeaderDetail>() {

				@Override
				public PurchaseHeaderDetail mapRow(ResultSet rs, int arg1)
						throws SQLException {
					PurchaseHeaderDetail headerDetail=new PurchaseHeaderDetail();
					headerDetail.setCount(rs.getInt("InboundCount"));
					headerDetail.setGrade(rs.getString("GradeCode"));
					headerDetail.setDeliveryDate(new Date(rs.getTimestamp("DeliveryDate").getTime()));
					return headerDetail;
				}
			});
			
			projectionData.setHeaderDetails(headerDetails);
			
			Calendar sCal=Calendar.getInstance();
			sCal.setTime(sdate);
			sCal.set(Calendar.HOUR_OF_DAY,0);
			sCal.set(Calendar.MINUTE,0);
			sCal.set(Calendar.SECOND,0);
			sCal.set(Calendar.MILLISECOND,0);
			
			int days=CommonUtil.getDaysDiffernce(sdate, edate);
			for(int i=0;i<=days;i++){
				int inbound=getInbound(headerDetails,sCal.getTime());
				
				
				projectionData.getInbounds().add(inbound*20);
				
				sCal.add(Calendar.DATE, 1);
			}
			
			
		}

		return projectionDatas;
	}


	/* (non-Javadoc)
	 * @see com.st.tracker.dao.ProjectionDataDao#getConsumedData()
	 */
	@Override
	public List<BaleInventory> getConsumedData(Date sdate, Date edate) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSourceT);
		
		
		
		String sql="SELECT sum([BaleWeight]) as [Weight], [GradeCode] "
				+ "FROM tblBaleInventory where [ActualConsumedDateTime] between ? And ? "
				+ "group by GradeCode";
		List<BaleInventory> projectionDatas=jdbcTemplate.query(sql, new Object[]{
				new Timestamp(sdate.getTime()),
				new Timestamp(edate.getTime())
		}, new RowMapper<BaleInventory>(){

			@Override
			public BaleInventory mapRow(ResultSet rs, int arg1)
					throws SQLException {
				BaleInventory baleInventory=new BaleInventory();
				baleInventory.setBaleWeight(rs.getDouble("Weight"));
				baleInventory.setGradeCode(rs.getInt("GradeCode"));
				return baleInventory;
			}
			
		});
		return projectionDatas;
	}
	
	
	@Override
	public void saveFiberPurchasingDataTemp(final List<ProjectionData> projectionDatas) {
		
		
		JdbcTemplate jdbcTemplateTemp=new JdbcTemplate(dataSource);
		String sql1="delete from [fiberPurchasingDataTemp]";
		jdbcTemplateTemp.execute(sql1);
		String sql2="delete from [fiberPurchasingDataTemp2]";
		jdbcTemplateTemp.execute(sql2);
		
		
		String insertSql1="insert into [fiberPurchasingDataTemp]("
				+ "[Weight],[GradeCode],[Grade]"
				+ ") values(?,?,?)";
		jdbcTemplateTemp.batchUpdate(insertSql1, new BatchPreparedStatementSetter(){

			@Override
			public int getBatchSize() {
				return projectionDatas.size();
			}

			@Override
			public void setValues(PreparedStatement statement, int i)
					throws SQLException {
				ProjectionData projectionData=projectionDatas.get(i);
				statement.setDouble(1, projectionData.getWeight());
				statement.setInt(2, projectionData.getGradeCode());
				statement.setString(3, projectionData.getGrade());
			}
			
		});
		
		for (ProjectionData projectionData : projectionDatas) {
			
			final List<PurchaseHeaderDetail> headerDetails=projectionData.getHeaderDetails();
		
			final String insertSql2="insert into [fiberPurchasingDataTemp2]("
					+ "[InboundCount],[GradeCode],[DeliveryDate] "
					+ ") values(?,?,?)";


			for (final PurchaseHeaderDetail purchaseHeaderDetail : headerDetails) {
				jdbcTemplateTemp.update(new PreparedStatementCreator() {
					
					@Override
					public PreparedStatement createPreparedStatement(Connection arg0)
							throws SQLException {
						PreparedStatement statement=arg0.prepareStatement(insertSql2);
						statement.setInt(1, purchaseHeaderDetail.getCount());
						statement.setString(2, purchaseHeaderDetail.getGrade());
						statement.setTimestamp(3, new Timestamp(purchaseHeaderDetail.getDeliveryDate().getTime()));
						return statement;
					}
				});
			}
			
		}
		
	}


	/* (non-Javadoc)
	 * @see com.st.tracker.dao.ProjectionDataDao#getProjectionDataTemp()
	 */
	@Override
	public List<ProjectionData> getFiberPurchasingDataTemp(Date sdate, Date edate, List<Integer> gradeIds) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		
		
		// Date from
		
		String sql="SELECT "
				+ "[Weight],  "
				+ "[GradeCode],  "
				+ "[Grade] "
				+ "FROM [fiberPurchasingDataTemp]";
		
			List<ProjectionData> projectionDatas=jdbcTemplate.query(sql,new RowMapper<ProjectionData>() {

			@Override
			public ProjectionData mapRow(ResultSet rs, int arg1)
					throws SQLException {
					ProjectionData projectionData=new ProjectionData();
					projectionData.setWeight(rs.getDouble("Weight"));
					projectionData.setGradeCode(rs.getInt("GradeCode"));
					projectionData.setGrade(rs.getString("Grade"));
				return projectionData;
			}
		});
		
		
		for (ProjectionData projectionData : projectionDatas) {
			
			String sql3="SELECT "
					+ "[InboundCount],"
					+ "[GradeCode], "
					+ "[DeliveryDate] "
					+ "FROM [fiberPurchasingDataTemp2] "
					+ " WHERE "
					+ " [GradeCode]=? ";
			
			
			List<PurchaseHeaderDetail> headerDetails=jdbcTemplate.query(sql3, new Object[]{new Integer(projectionData.getGradeCode()).toString()}, new RowMapper<PurchaseHeaderDetail>() {

				@Override
				public PurchaseHeaderDetail mapRow(ResultSet rs, int arg1)
						throws SQLException {
					PurchaseHeaderDetail headerDetail=new PurchaseHeaderDetail();
					headerDetail.setCount(rs.getInt("InboundCount"));
					headerDetail.setGrade(rs.getString("GradeCode"));
					headerDetail.setDeliveryDate(new Date(rs.getTimestamp("DeliveryDate").getTime()));
					return headerDetail;
				}
			});
			
			projectionData.setHeaderDetails(headerDetails);
			
			Calendar sCal=Calendar.getInstance();
			sCal.setTime(sdate);
			sCal.set(Calendar.HOUR_OF_DAY,0);
			sCal.set(Calendar.MINUTE,0);
			sCal.set(Calendar.SECOND,0);
			sCal.set(Calendar.MILLISECOND,0);
			
			int days=CommonUtil.getDaysDiffernce(sdate, edate);
			for(int i=0;i<=days;i++){
				int inbound=getInbound(headerDetails,sCal.getTime());
				
				
				projectionData.getInbounds().add(inbound*20);
				
				sCal.add(Calendar.DATE, 1);
			}
			
			
		}

		return projectionDatas;
	}

}

/**
 *Jun 2, 2016
 *OperatorDaoImpl.java
 * TODO
 *com.st.operator.dao
 *OperatorDaoImpl.java
 *Sarthak NAVHAAL
 */
package com.st.obcc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.sql.DataSource;

import org.joda.time.DateTime;
import org.joda.time.Period;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.st.common.CommonUtil;
import com.st.common.Workbook2007Util;
import com.st.obcc.model.OperatorData;
import com.st.obcc.model.R1Operator;
import com.st.obccPM5.model.StockOperatorPM5;

/**
 * @author snavhaal
 *
 */
@Repository
public class OperatorDaoImpl implements OperatorDao {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.st.operator.dao.OperatorDao#save(com.st.operator.model.OperatorData)
	 */
	@Autowired
	@Qualifier("dataSourceOBCC")
	private DataSource dataSourceQRT;

	private SimpleDateFormat dateFormat=new SimpleDateFormat("MM-dd-yyyy");
	private SimpleDateFormat fromuser=new SimpleDateFormat("yyyy-MM-dd");
	
	@Override
	public void saveorUpdate(final OperatorData operatorData) {
		// TODO Auto-generated method stub
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSourceQRT);

		//System.out.println(operatorData.getId());

		if (operatorData.getId() == 0) {
			String sql = "insert into [R2Operator]("
					+ "[position],"
					+ "[operator_name],"
					+ "[date],"
					+ "[shift],"
					+ "[crew],"
					+"[machinedown],"
					+ "[movement],[movement_desc],"
					+ "[chain_links],[chainLinks_desc],"
					+ "[conveyor_section],[conveyor_section_desc],"
					+ "[moter_col1],[moter_col1_desc],"
					+ "[moter_col2],[moter_col2_desc],"
					+ "[plcControlpanel],[plcControlpanel_desc],"
					+ "[power],[power_desc],"

					+ "[blade],[blade_desc],"
					+ "[vacuum],[vacuum_desc],"
					+ "[sizeAdjustmentMoment],[sizeAdjustmentMoment_desc],"
					+ "[correctsizeorder],[correctsizeorder_desc]"
					+ ") values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

			jdbcTemplate.update(sql,new Object[] { operatorData.getPosition(),
							operatorData.getOperatorname(),
							operatorData.getEdate(), operatorData.getShift(),operatorData.getCrew(),operatorData.isMachinedown(),
							operatorData.isMovementcol1(),
							operatorData.getMovementcol1desc(),
							operatorData.isConveyorcol1(),
							operatorData.getConveyorcol1desc(),
							operatorData.isConveyorcol2(),
							operatorData.getConveyorcol2desc(),
							operatorData.isConveyorcol3(),
							operatorData.getConveyorcol3desc(),
							operatorData.isConveyorcol4(),
							operatorData.getConveyorcol4desc(),
							operatorData.isConveyorcol5(),
							operatorData.getConveyorcol5desc(),
							operatorData.isPowercol1(),
							operatorData.getPowercol1desc(),
							operatorData.isPowercol2(),
							operatorData.getPowercol2desc(),
							operatorData.isPowercol3(),
							operatorData.getPowercol3desc(),
							operatorData.isPowercol4(),
							operatorData.getPowercol4desc(),
							operatorData.isOrdercol1(),
							operatorData.getOrdercol1desc() });

		} else {
			final String sql = "update [R2Operator] set " + "[position]=?,"
					+ "[operator_name]=?," + "[date]=?," + "[shift]=?,"+ "[crew]=?,"+"[machinedown]=?,"
					+ "[movement]=?," + "[movement_desc]=?,"
					+ "[chain_links]=?," + "[chainLinks_desc]=?,"
					+ "[conveyor_section]=?," + "[conveyor_section_desc]=?,"
					+ "[moter_col1]=?," + "[moter_col1_desc]=?,"
					+ "[moter_col2]=?," + "[moter_col2_desc]=?,"
					+ "[plcControlpanel]=?," + "[plcControlpanel_desc]=?,"
					+ "[power]=?," + "[power_desc]=?," + "[blade]=?,"
					+ "[blade_desc]=?," + "[vacuum]=?," + "[vacuum_desc]=?,"
					+ "[sizeAdjustmentMoment]=?,"
					+ "[sizeAdjustmentMoment_desc]=?,"
					+ "[correctsizeorder]=?, " + "[correctsizeorder_desc]=? "

					+ " where [id]=?";

			jdbcTemplate.update(new PreparedStatementCreator() {

				@Override
				public PreparedStatement createPreparedStatement(Connection arg0)
						throws SQLException {
					PreparedStatement statement = arg0.prepareStatement(sql);
					statement.setString(1, operatorData.getPosition());
					statement.setString(2, operatorData.getOperatorname());
					statement.setString(3, operatorData.getEdate());
					statement.setString(4, operatorData.getShift());
					statement.setString(5, operatorData.getCrew());
					statement.setBoolean(6,operatorData.isMachinedown());
					statement.setBoolean(7, operatorData.isMovementcol1());
					statement.setString(8, operatorData.getMovementcol1desc());
					statement.setBoolean(9, operatorData.isConveyorcol1());
					statement.setString(10, operatorData.getConveyorcol1desc());
					statement.setBoolean(11, operatorData.isConveyorcol2());
					statement.setString(12, operatorData.getConveyorcol2desc());

					statement.setBoolean(13, operatorData.isConveyorcol3());
					statement.setString(14, operatorData.getConveyorcol3desc());
					statement.setBoolean(15, operatorData.isConveyorcol4());
					statement.setString(16, operatorData.getConveyorcol4desc());
					statement.setBoolean(17, operatorData.isConveyorcol5());
					statement.setString(18, operatorData.getConveyorcol5desc());

					statement.setBoolean(19, operatorData.isPowercol1());
					statement.setString(20, operatorData.getPowercol1desc());

					statement.setBoolean(21, operatorData.isPowercol2());
					statement.setString(22, operatorData.getPowercol2desc());

					statement.setBoolean(23, operatorData.isPowercol3());
					statement.setString(24, operatorData.getPowercol3desc());

					statement.setBoolean(25, operatorData.isPowercol4());
					statement.setString(26, operatorData.getPowercol4desc());

					statement.setBoolean(27, operatorData.isOrdercol1());
					statement.setString(28, operatorData.getOrdercol1desc());

					statement.setInt(29, operatorData.getId());

					return statement;
				}
			});

		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.st.operator.dao.OperatorDao#getOperatorData(com.st.operator.model
	 * .OperatorData)
	 */
	@Override
	public OperatorData getOperatorData(String position, String shift,
			String date,String crew) throws Exception {

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSourceQRT);
		String sql = "select * from [R2Operator] where [position]=? AND [date]=? AND [shift] = ? ";
		OperatorData operatorData = null;
		try {
			operatorData = jdbcTemplate.queryForObject(sql, new Object[] {
					position, date, shift }, new RowMapper<OperatorData>() {

				@Override
				public OperatorData mapRow(ResultSet rs, int arg1)
						throws SQLException {
					OperatorData data = new OperatorData();
					data.setId(rs.getInt("id"));
					data.setPosition(rs.getString("position"));
					data.setOperatorname(rs.getString("operator_name"));
					data.setEdate(rs.getString("date"));
					data.setShift(rs.getString("shift"));
					data.setCrew(rs.getString("crew"));
					data.setMachinedown(rs.getBoolean("machinedown"));
					data.setMovementcol1(rs.getBoolean("movement"));
					data.setMovementcol1desc(rs.getString("movement_desc"));
					data.setConveyorcol1(rs.getBoolean("chain_links"));
					data.setConveyorcol1desc(rs.getString("chainLinks_desc"));
					data.setConveyorcol2(rs.getBoolean("conveyor_section"));
					data.setConveyorcol2desc(rs
							.getString("conveyor_section_desc"));
					data.setConveyorcol3(rs.getBoolean("moter_col1"));
					data.setConveyorcol3desc(rs.getString("moter_col1_desc"));
					data.setConveyorcol4(rs.getBoolean("moter_col2"));
					data.setConveyorcol4desc(rs.getString("moter_col2_desc"));
					data.setConveyorcol5(rs.getBoolean("plcControlpanel"));
					data.setConveyorcol5desc(rs
							.getString("plcControlpanel_desc"));

					data.setPowercol1(rs.getBoolean("power"));
					data.setPowercol1desc(rs.getString("power_desc"));
					data.setPowercol2(rs.getBoolean("blade"));
					data.setPowercol2desc(rs.getString("blade_desc"));
					data.setPowercol3(rs.getBoolean("vacuum"));
					data.setPowercol3desc(rs.getString("vacuum_desc"));
					data.setPowercol4(rs.getBoolean("sizeAdjustmentMoment"));
					data.setPowercol4desc(rs
							.getString("sizeAdjustmentMoment_desc"));
					data.setOrdercol1(rs.getBoolean("correctsizeorder"));
					data.setOrdercol1desc(rs.getString("correctsizeorder_desc"));

					return data;
				}

			});
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return operatorData;

	}
	
	
	/* (non-Javadoc)
	 * @see com.st.obcc.dao.OperatorDao#getOperatorDataList(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public List<OperatorData> getOperatorDataList(String position,String Sdate, String edate) throws Exception {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSourceQRT);
		String sql = "select * from [R2Operator] where [position]=? AND [date] BETWEEN ? AND ? order by convert(datetime, date, 105) ASC";
		List<OperatorData> lst = new ArrayList<OperatorData>();
		try {
			lst = jdbcTemplate.query(sql, new Object[] {position, Sdate, edate}, new RowMapper<OperatorData>() {

				@Override
				public OperatorData mapRow(ResultSet rs, int arg1)
						throws SQLException {
					OperatorData data = new OperatorData();
					try {
						String newDate = dateFormat.format(fromuser.parse(rs.getString("date")));
					
					data.setId(rs.getInt("id"));
					data.setPosition(rs.getString("position"));
					data.setOperatorname(rs.getString("operator_name"));
					data.setEdate(newDate);
					data.setShift(rs.getString("shift"));
					data.setCrew(rs.getString("crew"));
					data.setMachinedown(rs.getBoolean("machinedown"));
					data.setMovementcol1(rs.getBoolean("movement"));
					data.setMovementcol1desc(rs.getString("movement_desc"));
					data.setConveyorcol1(rs.getBoolean("chain_links"));
					data.setConveyorcol1desc(rs.getString("chainLinks_desc"));
					data.setConveyorcol2(rs.getBoolean("conveyor_section"));
					data.setConveyorcol2desc(rs
							.getString("conveyor_section_desc"));
					data.setConveyorcol3(rs.getBoolean("moter_col1"));
					data.setConveyorcol3desc(rs.getString("moter_col1_desc"));
					data.setConveyorcol4(rs.getBoolean("moter_col2"));
					data.setConveyorcol4desc(rs.getString("moter_col2_desc"));
					data.setConveyorcol5(rs.getBoolean("plcControlpanel"));
					data.setConveyorcol5desc(rs
							.getString("plcControlpanel_desc"));

					data.setPowercol1(rs.getBoolean("power"));
					data.setPowercol1desc(rs.getString("power_desc"));
					data.setPowercol2(rs.getBoolean("blade"));
					data.setPowercol2desc(rs.getString("blade_desc"));
					data.setPowercol3(rs.getBoolean("vacuum"));
					data.setPowercol3desc(rs.getString("vacuum_desc"));
					data.setPowercol4(rs.getBoolean("sizeAdjustmentMoment"));
					data.setPowercol4desc(rs
							.getString("sizeAdjustmentMoment_desc"));
					data.setOrdercol1(rs.getBoolean("correctsizeorder"));
					data.setOrdercol1desc(rs.getString("correctsizeorder_desc"));
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					return data;
				}
					

			});
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return lst;
	}
	
	
	public long getDataCountDatePercentage(String position,String sdate, String edate)
			throws Exception {
		
		SimpleDateFormat format=new SimpleDateFormat("MM-dd-yyyy");
		
		List<OperatorData> datas=getOperatorDataList(position,sdate,edate);
	
			
		
		int count=0;long set=0,percentage=0;
		int days = CommonUtil.getDaysDiffernce(format.parse(sdate), format.parse(edate))+1;
		List<Integer> al=new ArrayList<Integer>();
	if(datas!=null)	
	{
		for(OperatorData data: datas)
		{
				 		if(data.isMachinedown()!=true)
						 {	
							if(data.isMovementcol1() == true||data.isMovementcol1() == false)
							{
								count++;		
							}
							if(data.isConveyorcol1() == true||data.isConveyorcol1() == false)
							{
								count++;
							}	
							if(data.isConveyorcol2() == true||data.isConveyorcol2() == false)
							{
								count++;	
							}
							if(data.isConveyorcol3() == true||data.isConveyorcol3() == false)
							{
								count++;
							}
							if(data.isConveyorcol4() == true||data.isConveyorcol4() == false)
							{
								count++;
							}
							if(data.isConveyorcol5() == true||data.isConveyorcol5() == false)
							{
								count++;	
							}
							if(data.isPowercol1() == true||data.isPowercol1() == false)
							{
								count++;
							}
							if(data.isPowercol2() == true||data.isPowercol2() == false)
							{
								count++;	
							}
							if(data.isPowercol3() == true||data.isPowercol3() == false)
							{
								count++;	
							}
							if(data.isPowercol4() == true||data.isPowercol4() == false)
							{
								count++;	
							}
							if(data.isOrdercol1() == true||data.isOrdercol1() == false)
							{
								count++;	
							}
					 	 }
				 		else
							count=6;
							al.add(count);
							count=0;
				}
		 		for(int n:al)
				{
					if(n>=5)
					{
						set=set+100;
					}
				}
		 		days=days*2;
		 		percentage=set/days;
				
		 }
		
		return percentage;
	}

	/* (non-Javadoc)
	 * @see com.st.obcc.dao.OperatorDao#CheckObcc(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public boolean CheckObcc(String date, String position, String shift) {
		
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSourceQRT);
		
//		SimpleDateFormat dateFormat=new SimpleDateFormat("MM-dd-yyyy");		
//		Date date=CommonUtil.checkDate(dates, dateFormat);
		
		boolean result=false;
		if(position.equals("R2"))
		{
				String sql = "SELECT count(*) FROM R2Operator WHERE date = ? AND shift=?";
			    int count = jdbcTemplate.queryForObject(sql, Integer.class, new Object[] {date,shift});
				    if (count > 0)
				    	result =false;
				    else
				    	result =true;
				    return result;
		}
		else if(position.equals( "stockoperator"))
		{ 
			String sql = "SELECT count(*) FROM stock_operator WHERE date = ? AND shift=?";
			 int count = jdbcTemplate.queryForObject(sql, Integer.class, new Object[] {date,shift});
			    if (count > 0)
			    	result =false;
			    else
			    	result =true;
			    return result;
		}
		else if(position.equals( "machinetender"))
		{
			 String sql = "SELECT count(*) FROM machineTender  WHERE date=? AND shift=?";
			    int count = jdbcTemplate.queryForObject(sql, Integer.class, new Object[] {date,shift});
			    if (count > 0)
			    	result =false;
			    else
			    	result =true;
			    return result;
		}
		else  if(position.equals("R1"))
		{ 
			String sql = "SELECT count(*) FROM R1Operator WHERE date = ? AND shift=?";
			 int count = jdbcTemplate.queryForObject(sql, Integer.class, new Object[] {date,shift});
			    if (count > 0)
			    	result =false;
			    else
			    	result =true;
			    return result;
		}
		else  if(position.equals("backtender"))
		{ 
			String sql = "SELECT count(*) FROM backTender WHERE date = ? AND shift=?";
			 int count = jdbcTemplate.queryForObject(sql, Integer.class, new Object[] {date,shift});
			    if (count > 0)
			    	result =false;
			    else
			    	result =true;
			    return result;
		}
		else  if(position.equals("utilityoperator"))
		{ 
			String sql = "SELECT count(*) FROM utilityOperator WHERE date = ? AND shift=?";
			 int count = jdbcTemplate.queryForObject(sql, Integer.class, new Object[] {date,shift});
			    if (count > 0)
			    	result =false;
			    else
			    	result =true;
			    return result;
		}
		return result;
	}
	
	/* (non-Javadoc)
	 * @see com.st.obcc.dao.OperatorDao#getDataCountDatePercentage(java.lang.String, java.lang.String, java.lang.String)
	 
	@Override
	public long getDataCountDatePercentage(String position, String Sdate,
			String edate) throws Exception {
		// TODO Auto-generated method stub
		 
		SimpleDateFormat dateFormat=new SimpleDateFormat("MM-dd-yyyy");
		
		Date sDate=CommonUtil.checkDate(Sdate, dateFormat);
		Date esDate=CommonUtil.checkDate(edate, dateFormat);
		
 
        
        
		final  int days=CommonUtil.getDaysDiffernce(sDate, esDate);
        
        final int total = days*2;
        
       // System.out.println("getDaysDiff"+days);
		
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSourceQRT);
		Object[] param=null;
		String sql;
		 
			sql="SELECT COUNT(*) As [TotalDataEntry], ( "
					+ "SELECT COUNT(*) As [totaldata] "
					+ "FROM R2Operator "
					+ " WHERE (date between ? AND ? )"
					+ " )as TotalExport FROM R2Operator e1 ";
					param=new Object[]{
							Sdate,
						edate	
					};
			 
			List<OperatorData> wrapperProductions=null;
			try {
				wrapperProductions=jdbcTemplate.query(sql,param, new RowMapper<OperatorData>(){

							@Override
							public OperatorData mapRow(ResultSet rs, int arg1)
									throws SQLException {
								
								
								int totalDataEntry = rs.getInt("TotalDataEntry");
								int totalExport = rs.getInt("TotalExport");
								
								//int percentage = totalExport*100/totalDataEntry;
								int percentage = 0;
								if(total == 0)
								{
									percentage = 100;	
								}
								else
								{
									percentage = totalExport*100/total;
								}
								
								
								OperatorData wrapperProduction=new OperatorData();
								wrapperProduction.setProcessbarpercentage(percentage);
								return wrapperProduction;
							}
							
						});
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return wrapperProductions.get(0).getProcessbarpercentage();
		
	}

	 (non-Javadoc)
	 * @see com.st.obcc.dao.OperatorDao#getDataCountDatePercentage(java.lang.String, java.lang.String)
	 
	@Override
	public double getDataCountDatePercentage(String Sdate, String edate)
			throws Exception {
		// TODO Auto-generated method stub
		
	SimpleDateFormat dateFormat=new SimpleDateFormat("MM-dd-yyyy");
		
		Date sDate=CommonUtil.checkDate(Sdate, dateFormat);
		Date esDate=CommonUtil.checkDate(edate, dateFormat);
		
 
        
        
		final  int days=CommonUtil.getDaysDiffernce(sDate, esDate);
        
        final int total = days*2;
        
       // System.out.println("getDaysDiff"+days);
		
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSourceQRT);
		Object[] param=null;
		String sql;
		 
			sql="SELECT COUNT(*) As [TotalDataEntry], ( "
					+ "SELECT COUNT(*) As [totaldata] "
					+ "FROM R2Operator "
					+ " WHERE (date between ? AND ? )"
					+ " )as TotalExport FROM R2Operator e1 ";
					param=new Object[]{
							Sdate,
						edate	
					};
			 
			List<OperatorData> wrapperProductions=null;
			try {
				wrapperProductions=jdbcTemplate.query(sql,param, new RowMapper<OperatorData>(){

							@Override
							public OperatorData mapRow(ResultSet rs, int arg1)
									throws SQLException {
								
								
								int totalDataEntry = rs.getInt("TotalDataEntry");
								int totalExport = rs.getInt("TotalExport");
								
								//int percentage = totalExport*100/totalDataEntry;
								double percentage = totalExport*100/total;
								
								
								OperatorData wrapperProduction=new OperatorData();
								wrapperProduction.setPercentage(percentage);
								return wrapperProduction;
							}
							
						});
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return wrapperProductions.get(0).getPercentage();
	}
	*/
}

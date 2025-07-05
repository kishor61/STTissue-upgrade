/**
 *Jun 16, 2016
 *UtilityOperatorDaoImpl.java
 * TODO
 *com.st.obcc.dao
 *UtilityOperatorDaoImpl.java
 *Sunil Singh Bora
 */
package com.st.obcc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.st.common.CommonUtil;
import com.st.obcc.model.UtilityOperator;
/**
 * @author snavhaal
 *
 */
@Repository
public class UtilityOperatorDaoImpl implements UtilityOperatorDao {

	@Autowired
	@Qualifier("dataSourceOBCC")
	private DataSource dataSourceQRT;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.st.obcc.dao.UtilityOperatorDao#getOperatorData(java.lang.String,
	 * java.lang.String, java.lang.String, java.lang.String)
	 */
	
	private SimpleDateFormat dateFormat=new SimpleDateFormat("MM-dd-yyyy");
	private SimpleDateFormat fromuser=new SimpleDateFormat("yyyy-MM-dd");
	
	@Override
	public UtilityOperator getOperatorData(String position, String shift,
			String date, String crew) throws Exception {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSourceQRT);
		String sql = "select * from [utilityOperator] where [position]=? AND [date]=? AND [shift] = ?  ";
		UtilityOperator utilityOperator = null;
		try {
			utilityOperator = jdbcTemplate.queryForObject(sql, new Object[] {
					position, date, shift},
					new RowMapper<UtilityOperator>() {

						@Override
						public UtilityOperator mapRow(ResultSet rs, int arg1)
								throws SQLException {
							UtilityOperator data = new UtilityOperator();
							data.setId(rs.getInt("id"));
							data.setPosition(rs.getString("position"));
							data.setOperatorName(rs.getString("operator_name"));
							data.setEdate(rs.getString("date"));
							data.setShift(rs.getString("shift"));
							data.setCrew(rs.getString("crew"));
							data.setMachinedown(rs.getBoolean("machinedown"));
							data.setWrapperFoxCol1(rs
									.getBoolean("wrapper_fox_col1"));
							data.setWrapperFoxCol2(rs
									.getBoolean("wrapper_fox_col2"));
							data.setWrapperFoxCol3(rs
									.getBoolean("wrapper_fox_col3"));
							data.setWrapperFoxCol4(rs
									.getBoolean("wrapper_fox_col4"));
							data.setWrapperFoxCol5(rs
									.getBoolean("wrapper_fox_col5"));

							data.setWrapperFoxCol1Desc(rs
									.getString("wrapper_fox_col1_Desc"));
							data.setWrapperFoxCol2Desc(rs
									.getString("wrapper_fox_col2_Desc"));
							data.setWrapperFoxCol3Desc(rs
									.getString("wrapper_fox_col3_Desc"));
							data.setWrapperFoxCol4Desc(rs
									.getString("wrapper_fox_col4_Desc"));
							data.setWrapperFoxCol5Desc(rs
									.getString("wrapper_fox_col5_Desc"));

							data.setWrapperWuftechCol1(rs
									.getBoolean("wrapper_wulftech_col1"));
							data.setWrapperWuftechCol2(rs
									.getBoolean("wrapper_wulftech_col2"));
							data.setWrapperWuftechCol3(rs
									.getBoolean("wrapper_wulftech_col3"));
							data.setWrapperWuftechCol4(rs
									.getBoolean("wrapper_wulftech_col4"));
							data.setWrapperWuftechCol5(rs
									.getBoolean("wrapper_wulftech_col5"));
							data.setWrapperWuftechCol6(rs
									.getBoolean("wrapper_wulftech_col6"));

							data.setWrapperWuftechCol1Desc(rs
									.getString("wrapper_wulftech_col1_desc"));
							data.setWrapperWuftechCol2Desc(rs
									.getString("wrapper_wulftech_col2_desc"));
							data.setWrapperWuftechCol3Desc(rs
									.getString("wrapper_wulftech_col3_desc"));
							data.setWrapperWuftechCol4Desc(rs
									.getString("wrapper_wulftech_col4_desc"));
							data.setWrapperWuftechCol5Desc(rs
									.getString("wrapper_wulftech_col5_desc"));
							data.setWrapperWuftechCol6Desc(rs
									.getString("wrapper_wulftech_col6_desc"));

							data.setScaleCol1(rs.getBoolean("scale_col1"));
							data.setScaleCol2(rs.getBoolean("scale_col2"));
							data.setScaleCol3(rs.getBoolean("scale_col3"));
							data.setScaleCol4(rs.getBoolean("scale_col4"));

							data.setScaleCol1Desc(rs
									.getString("scale_col1_Desc"));
							data.setScaleCol2Desc(rs
									.getString("scale_col2_Desc"));
							data.setScaleCol3Desc(rs
									.getString("scale_col3_Desc"));
							data.setScaleCol4Desc(rs
									.getString("scale_col4_Desc"));

							return data;
						}

					});
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return utilityOperator;

	}

	
	
	
	
	/* (non-Javadoc)
	 * @see com.st.obcc.dao.UtilityOperatorDao#getOperatorDataList(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public List<UtilityOperator> getOperatorDataList(String position,
			String Sdate, String edate) throws Exception {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSourceQRT);
		String sql = "select * from [utilityOperator] where [position]=? AND [date] BETWEEN ? AND ? order by convert(datetime, date, 105) ASC" ;
		List<UtilityOperator> lst = new ArrayList<UtilityOperator>();
		try {
			lst = jdbcTemplate.query(sql, new Object[] {position, Sdate, edate },new RowMapper<UtilityOperator>() {

						@Override
						public UtilityOperator mapRow(ResultSet rs, int arg1)
								throws SQLException {
							UtilityOperator data = new UtilityOperator();
							
							try {
								String newDate = dateFormat.format(fromuser.parse(rs.getString("date")));
							
							
							data.setId(rs.getInt("id"));
							data.setPosition(rs.getString("position"));
							data.setOperatorName(rs.getString("operator_name"));
							data.setEdate(newDate);
							data.setShift(rs.getString("shift"));
							data.setCrew(rs.getString("crew"));
							data.setMachinedown(rs.getBoolean("machinedown"));
							data.setWrapperFoxCol1(rs
									.getBoolean("wrapper_fox_col1"));
							data.setWrapperFoxCol2(rs
									.getBoolean("wrapper_fox_col2"));
							data.setWrapperFoxCol3(rs
									.getBoolean("wrapper_fox_col3"));
							data.setWrapperFoxCol4(rs
									.getBoolean("wrapper_fox_col4"));
							data.setWrapperFoxCol5(rs
									.getBoolean("wrapper_fox_col5"));

							data.setWrapperFoxCol1Desc(rs
									.getString("wrapper_fox_col1_Desc"));
							data.setWrapperFoxCol2Desc(rs
									.getString("wrapper_fox_col2_Desc"));
							data.setWrapperFoxCol3Desc(rs
									.getString("wrapper_fox_col3_Desc"));
							data.setWrapperFoxCol4Desc(rs
									.getString("wrapper_fox_col4_Desc"));
							data.setWrapperFoxCol5Desc(rs
									.getString("wrapper_fox_col5_Desc"));

							data.setWrapperWuftechCol1(rs
									.getBoolean("wrapper_wulftech_col1"));
							data.setWrapperWuftechCol2(rs
									.getBoolean("wrapper_wulftech_col2"));
							data.setWrapperWuftechCol3(rs
									.getBoolean("wrapper_wulftech_col3"));
							data.setWrapperWuftechCol4(rs
									.getBoolean("wrapper_wulftech_col4"));
							data.setWrapperWuftechCol5(rs
									.getBoolean("wrapper_wulftech_col5"));
							data.setWrapperWuftechCol6(rs
									.getBoolean("wrapper_wulftech_col6"));

							data.setWrapperWuftechCol1Desc(rs
									.getString("wrapper_wulftech_col1_desc"));
							data.setWrapperWuftechCol2Desc(rs
									.getString("wrapper_wulftech_col2_desc"));
							data.setWrapperWuftechCol3Desc(rs
									.getString("wrapper_wulftech_col3_desc"));
							data.setWrapperWuftechCol4Desc(rs
									.getString("wrapper_wulftech_col4_desc"));
							data.setWrapperWuftechCol5Desc(rs
									.getString("wrapper_wulftech_col5_desc"));
							data.setWrapperWuftechCol6Desc(rs
									.getString("wrapper_wulftech_col6_desc"));

							data.setScaleCol1(rs.getBoolean("scale_col1"));
							data.setScaleCol2(rs.getBoolean("scale_col2"));
							data.setScaleCol3(rs.getBoolean("scale_col3"));
							data.setScaleCol4(rs.getBoolean("scale_col4"));

							data.setScaleCol1Desc(rs
									.getString("scale_col1_Desc"));
							data.setScaleCol2Desc(rs
									.getString("scale_col2_Desc"));
							data.setScaleCol3Desc(rs
									.getString("scale_col3_Desc"));
							data.setScaleCol4Desc(rs
									.getString("scale_col4_Desc"));
 
							
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
	
	
	 
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.st.obcc.dao.UtilityOperatorDao#saveorUpdate(com.st.obcc.model.
	 * UtilityOperator)
	 */
	@Override
	public void saveorUpdate(final UtilityOperator utilityOperator) {
		// TODO Auto-generated method stub

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSourceQRT);

		if (utilityOperator.getId() == 0) {

			String sql = "insert into utilityOperator([position],[operator_name],[date],[crew],[shift],[machinedown],[wrapper_fox_col1],[wrapper_fox_col2],[wrapper_fox_col3],[wrapper_fox_col4],[wrapper_fox_col5]"
					+ ",[wrapper_fox_col1_Desc],[wrapper_fox_col2_Desc],[wrapper_fox_col3_Desc],[wrapper_fox_col4_Desc],[wrapper_fox_col5_Desc],[wrapper_wulftech_col1],[wrapper_wulftech_col2],[wrapper_wulftech_col3]"
					+ ",[wrapper_wulftech_col4],[wrapper_wulftech_col5],[wrapper_wulftech_col6],[wrapper_wulftech_col1_desc],[wrapper_wulftech_col2_desc],[wrapper_wulftech_col3_desc],[wrapper_wulftech_col4_desc]"
					+ ",[wrapper_wulftech_col5_desc],[wrapper_wulftech_col6_desc],[scale_col1],[scale_col2],[scale_col3],[scale_col4],[scale_col1_Desc],[scale_col2_Desc],[scale_col3_Desc],[scale_col4_Desc]) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

			jdbcTemplate.update(
					sql,
					new Object[] { utilityOperator.getPosition(),
							utilityOperator.getOperatorName(),
							utilityOperator.getEdate(),
							utilityOperator.getCrew(),
							utilityOperator.getShift(),
							utilityOperator.isMachinedown(),
							utilityOperator.isWrapperFoxCol1(),
							utilityOperator.isWrapperFoxCol2(),
							utilityOperator.isWrapperFoxCol3(),
							utilityOperator.isWrapperFoxCol4(),
							utilityOperator.isWrapperFoxCol5(),
							utilityOperator.getWrapperFoxCol1Desc(),
							utilityOperator.getWrapperFoxCol2Desc(),
							utilityOperator.getWrapperFoxCol3Desc(),
							utilityOperator.getWrapperFoxCol4Desc(),
							utilityOperator.getWrapperFoxCol5Desc(),
							utilityOperator.isWrapperWuftechCol1(),
							utilityOperator.isWrapperWuftechCol2(),
							utilityOperator.isWrapperWuftechCol3(),
							utilityOperator.isWrapperWuftechCol4(),
							utilityOperator.isWrapperWuftechCol5(),
							utilityOperator.isWrapperWuftechCol6(),
							utilityOperator.getWrapperWuftechCol1Desc(),
							utilityOperator.getWrapperWuftechCol2Desc(),
							utilityOperator.getWrapperWuftechCol3Desc(),
							utilityOperator.getWrapperWuftechCol4Desc(),
							utilityOperator.getWrapperWuftechCol5Desc(),
							utilityOperator.getWrapperWuftechCol6Desc(),
							utilityOperator.isScaleCol1(),
							utilityOperator.isScaleCol2(),
							utilityOperator.isScaleCol3(),
							utilityOperator.isScaleCol4(),
							utilityOperator.getScaleCol1Desc(),
							utilityOperator.getScaleCol2Desc(),
							utilityOperator.getScaleCol3Desc(),
							utilityOperator.getScaleCol4Desc()

					});

		} else {

			final String sql = "UPDATE [utilityOperator] SET [position] = ?,[operator_name] = ?,[date] = ?,[crew] = ?,[shift] = ?,[machinedown]=?,[wrapper_fox_col1] = ?,[wrapper_fox_col2] = ?,[wrapper_fox_col3] = ?"
					+ ",[wrapper_fox_col4] = ?,[wrapper_fox_col5] = ?,[wrapper_fox_col1_Desc] = ?,[wrapper_fox_col2_Desc] = ?,[wrapper_fox_col3_Desc] = ?,[wrapper_fox_col4_Desc] = ?,[wrapper_fox_col5_Desc] = ?"
					+ ",[wrapper_wulftech_col1] = ?,[wrapper_wulftech_col2] = ?,[wrapper_wulftech_col3] = ?,[wrapper_wulftech_col4] = ?,[wrapper_wulftech_col5] = ?,[wrapper_wulftech_col6] = ?"
					+ ",[wrapper_wulftech_col1_desc] = ?,[wrapper_wulftech_col2_desc] = ?,[wrapper_wulftech_col3_desc] = ?,[wrapper_wulftech_col4_desc] = ?,[wrapper_wulftech_col5_desc] = ?"
					+ ",[wrapper_wulftech_col6_desc] = ?,[scale_col1] = ?,[scale_col2] = ?,[scale_col3] = ?,[scale_col4] = ?,[scale_col1_Desc] = ?,[scale_col2_Desc] = ?,[scale_col3_Desc] = ?"
					+ ",[scale_col4_Desc] = ? WHERE [id]= ?";

			jdbcTemplate.update(new PreparedStatementCreator() {

				@Override
				public PreparedStatement createPreparedStatement(Connection arg0)
						throws SQLException {
					PreparedStatement statement = arg0.prepareStatement(sql);
					statement.setString(1, utilityOperator.getPosition());
					statement.setString(2, utilityOperator.getOperatorName());
					statement.setString(3, utilityOperator.getEdate());
					statement.setString(4, utilityOperator.getCrew());
					statement.setString(5, utilityOperator.getShift());
					statement.setBoolean(6, utilityOperator.isMachinedown());
					statement.setBoolean(7, utilityOperator.isWrapperFoxCol1());
					statement.setBoolean(8, utilityOperator.isWrapperFoxCol2());
					statement.setBoolean(9, utilityOperator.isWrapperFoxCol3());
					statement.setBoolean(10, utilityOperator.isWrapperFoxCol4());
					statement.setBoolean(11, utilityOperator.isWrapperFoxCol5());

					statement.setString(12,
							utilityOperator.getWrapperFoxCol1Desc());
					statement.setString(13,
							utilityOperator.getWrapperFoxCol2Desc());
					statement.setString(14,
							utilityOperator.getWrapperFoxCol3Desc());
					statement.setString(15,
							utilityOperator.getWrapperFoxCol4Desc());
					statement.setString(16,
							utilityOperator.getWrapperFoxCol5Desc());

					statement.setBoolean(17,
							utilityOperator.isWrapperWuftechCol1());
					statement.setBoolean(18,
							utilityOperator.isWrapperWuftechCol2());
					statement.setBoolean(19,
							utilityOperator.isWrapperWuftechCol3());
					statement.setBoolean(20,
							utilityOperator.isWrapperWuftechCol4());
					statement.setBoolean(21,
							utilityOperator.isWrapperWuftechCol5());
					statement.setBoolean(22,
							utilityOperator.isWrapperWuftechCol6());

					statement.setString(23,
							utilityOperator.getWrapperWuftechCol1Desc());
					statement.setString(24,
							utilityOperator.getWrapperWuftechCol2Desc());
					statement.setString(25,
							utilityOperator.getWrapperWuftechCol3Desc());
					statement.setString(26,
							utilityOperator.getWrapperWuftechCol4Desc());
					statement.setString(27,
							utilityOperator.getWrapperWuftechCol5Desc());
					statement.setString(28,
							utilityOperator.getWrapperWuftechCol6Desc());

					statement.setBoolean(29, utilityOperator.isScaleCol1());
					statement.setBoolean(30, utilityOperator.isScaleCol2());
					statement.setBoolean(31, utilityOperator.isScaleCol3());
					statement.setBoolean(32, utilityOperator.isScaleCol4());

					statement.setString(33, utilityOperator.getScaleCol1Desc());
					statement.setString(34, utilityOperator.getScaleCol2Desc());
					statement.setString(35, utilityOperator.getScaleCol3Desc());
					statement.setString(36, utilityOperator.getScaleCol4Desc());

					statement.setInt(37, utilityOperator.getId());

					return statement;
				}
			});

		}

	}


	public long getDataCountDatePercentage1(String position, String sdate,String edate) throws Exception {
		
		List<UtilityOperator> datas=  getOperatorDataList(position,sdate, edate);
		SimpleDateFormat format=new SimpleDateFormat("MM-dd-yyyy");
		int count=0;long set=0,percentage=0;
		int days = CommonUtil.getDaysDiffernce(format.parse(sdate), format.parse(edate))+1;
	 	List<Integer> al=new ArrayList<Integer>();
	 if(datas!=null)	
	 {	
	 	for(UtilityOperator data:datas)
		{
				if(data.isMachinedown()!=true)
				{	
					if(data.isWrapperFoxCol1() == true||data.isWrapperFoxCol1() == false)
					{
						count++;		
					}
					if(data.isWrapperFoxCol2() == true||data.isWrapperFoxCol2() == false)
					{
							count++;	
					}
					if(data.isWrapperFoxCol3() == true||data.isWrapperFoxCol3() == false)
					{
							count++;	
					}
					if(data.isWrapperFoxCol4() == true||data.isWrapperFoxCol4() == false)
					{
							count++;	
					}
					if(data.isWrapperFoxCol5() == true||data.isWrapperFoxCol5() == false)
					{
							count++;
					}
					if(data.isWrapperWuftechCol1() == true||data.isWrapperWuftechCol1() == false)
					{
								count++;
					}
					if(data.isWrapperWuftechCol2() == true||data.isWrapperWuftechCol2() == false)
					{
							count++;	
					}
					if(data.isWrapperWuftechCol3() == true||data.isWrapperWuftechCol3() == false)
					{
								count++;
					}
					if(data.isWrapperWuftechCol4() == true||data.isWrapperWuftechCol4() == false)
					{
							count++;
					}
					if(data.isWrapperWuftechCol5() == true||data.isWrapperWuftechCol5() == false)
					{
							count++;
					}
					if(data.isWrapperWuftechCol6() == true||data.isWrapperWuftechCol6() == false)
					{
								count++;
					}
					if(data.isScaleCol1() == true||data.isScaleCol1() == false)
					{
								count++;
					}
					if(data.isScaleCol2() == true||data.isScaleCol2() == false)
					{
							count++;	
					}
					if(data.isScaleCol3() == true||data.isScaleCol3() == false)
					{
							count++;	
					}
					if(data.isScaleCol4() == true||data.isScaleCol4() == false)
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
	 * @see com.st.obcc.dao.UtilityOperatorDao#getDataCountDatePercentage(java.lang.String, java.lang.String, java.lang.String)
	 
	@Override
	public long getDataCountDatePercentage(String position, String Sdate,
			String edate) throws Exception {
		// TODO Auto-generated method stub
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSourceQRT);
		Object[] param=null;
		String sql;
		
		Date sDate=CommonUtil.checkDate(Sdate, dateFormat);
		Date esDate=CommonUtil.checkDate(edate, dateFormat);
		
		final  int days=CommonUtil.getDaysDiffernce(sDate, esDate);
        int total1 = 0;
        total1 = days*2;
        final int total = total1;
		
		 
			sql="SELECT COUNT(*) As [TotalDataEntry], ( "
					+ "SELECT COUNT(*) As [totaldata] "
					+ "FROM UtilityOperator "
					+ " WHERE (date between ? AND ? )"
					+ " )as TotalExport FROM UtilityOperator e1 ";
					param=new Object[]{
						Sdate,
						edate	
					};
			 
			List<UtilityOperator> wrapperProductions=null;
			try {
				wrapperProductions=jdbcTemplate.query(sql,param, new RowMapper<UtilityOperator>(){

							@Override
							public UtilityOperator mapRow(ResultSet rs, int arg1)
									throws SQLException {
								
								
								int totalDataEntry = rs.getInt("TotalDataEntry");
								int totalExport = rs.getInt("TotalExport");
								
								int percentage = 0;
								if(total == 0)
								{
									percentage = 100;	
								}
								else
								{
									percentage = totalExport*100/total;
								}
								
								
								UtilityOperator wrapperProduction=new UtilityOperator();
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
	 * @see com.st.obcc.dao.UtilityOperatorDao#getDataCountDatePercentage(java.lang.String, java.lang.String)
	 
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
					+ "FROM utilityOperator "
					+ " WHERE (date between ? AND ? )"
					+ " )as TotalExport FROM utilityOperator e1 ";
					param=new Object[]{
							Sdate,
						edate	
					};
			 
			List<UtilityOperator> wrapperProductions=null;
			try {
				wrapperProductions=jdbcTemplate.query(sql,param, new RowMapper<UtilityOperator>(){

							@Override
							public UtilityOperator mapRow(ResultSet rs, int arg1)
									throws SQLException {
								
								
								int totalDataEntry = rs.getInt("TotalDataEntry");
								int totalExport = rs.getInt("TotalExport");
								
								//int percentage = totalExport*100/totalDataEntry;
								double percentage = totalExport*100/total;
								
								
								UtilityOperator wrapperProduction=new UtilityOperator();
								wrapperProduction.setPercentage(percentage);
								return wrapperProduction;
							}
							
						});
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return wrapperProductions.get(0).getPercentage();
	}*/
	
	
}

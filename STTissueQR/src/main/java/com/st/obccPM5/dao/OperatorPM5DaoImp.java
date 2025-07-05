/**
 *Oct 24, 2019
 *operatorPM5PM5DaoImp.java
 * TODO
 *com.st.obccPM5.dao
 *operatorPM5PM5DaoImp.java
 *Roshan Lal Tailor
 */
package com.st.obccPM5.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.stereotype.Repository;

import com.st.obccPM5.model.OperatorPM5;

/**
 * @author roshan
 *
 */
@Repository
public class OperatorPM5DaoImp implements OperatorPM5Dao {
	
	@Autowired
	@Qualifier("dataSourceOBCC")
	private DataSource dataSourceQRT;

	
	/* (non-Javadoc)
	 * @see com.st.oBcc1pm5.dao.operatorPM5PM5Dao#saveorUpdate(com.st.oBcc1pm5.model.operatorPM5PM5Data)
	 */
	@Override
	public void saveorUpdate(final OperatorPM5 operatorPM5Data) {
		
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSourceQRT);

		//System.out.println(operatorPM5Data.getId());

		if (operatorPM5Data.getId() == 0) {
			String sql = "insert into R2operatorPM5("
					+ "position,"
					+ "operatorPM5_name,"
					+ "date,"
					+ "shift,"
					+ "crew,"
					+ "movement,movement_desc,"
					+ "chain_links,chainLinks_desc,"
					+ "conveyor_section,conveyor_section_desc,"
					+ "moter_col1,moter_col1_desc,"
					+ "moter_col2,moter_col2_desc,"
					+ "plcControlpanel,plcControlpanel_desc,"
					+ "power,power_desc,"

					+ "blade,blade_desc,"
					+ "vacuum,vacuum_desc,"
					+ "sizeAdjustmentMoment,sizeAdjustmentMoment_desc,"
					+ "correctsizeorder,correctsizeorder_desc"
					+ ") values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

			jdbcTemplate.update(sql,new Object[] { 
							operatorPM5Data.getPosition(),
							operatorPM5Data.getOperatorname(),
							operatorPM5Data.getEdate(),
							operatorPM5Data.getShift(),
							operatorPM5Data.getCrew(),
							operatorPM5Data.isMovementcol1(),
							operatorPM5Data.getMovementcol1desc(),
							operatorPM5Data.isConveyorcol1(),
							operatorPM5Data.getConveyorcol1desc(),
							operatorPM5Data.isConveyorcol2(),
							operatorPM5Data.getConveyorcol2desc(),
							operatorPM5Data.isConveyorcol3(),
							operatorPM5Data.getConveyorcol3desc(),
							operatorPM5Data.isConveyorcol4(),
							operatorPM5Data.getConveyorcol4desc(),
							operatorPM5Data.isConveyorcol5(),
							operatorPM5Data.getConveyorcol5desc(),
							operatorPM5Data.isPowercol1(),
							operatorPM5Data.getPowercol1desc(),
							operatorPM5Data.isPowercol2(),
							operatorPM5Data.getPowercol2desc(),
							operatorPM5Data.isPowercol3(),
							operatorPM5Data.getPowercol3desc(),
							operatorPM5Data.isPowercol4(),
							operatorPM5Data.getPowercol4desc(),
							operatorPM5Data.isOrdercol1(),
							operatorPM5Data.getOrdercol1desc() });

		} else {
			final String sql = "update R2operatorPM5 set "
					
					+"position=?,"
					+ "operatorPM5_name=?,"
					+ "date=?," + "shift=?,"
					+ "crew=?,"
					+ "movement=?," 
					+ "movement_desc=?,"
					+ "chain_links=?,"
					+ "chainLinks_desc=?,"
					+ "conveyor_section=?," 
					+ "conveyor_section_desc=?,"
					+ "moter_col1=?," 
					+ "moter_col1_desc=?,"
					+ "moter_col2=?," 
					+ "moter_col2_desc=?,"
					+ "plcControlpanel=?," 
					+ "plcControlpanel_desc=?,"
					+ "power=?," + "power_desc=?," 
					+ "blade=?,"
					+ "blade_desc=?," + "vacuum=?," 
					+ "vacuum_desc=?,"
					+ "sizeAdjustmentMoment=?,"
					+ "sizeAdjustmentMoment_desc=?,"
					+ "correctsizeorder=?, " 
					+ "correctsizeorder_desc=? "

					+ " where id=?";

			jdbcTemplate.update(new PreparedStatementCreator() {

				@Override
				public PreparedStatement createPreparedStatement(Connection arg0)
						throws SQLException {
					PreparedStatement statement = arg0.prepareStatement(sql);
					statement.setString(1, operatorPM5Data.getPosition());
					statement.setString(2, operatorPM5Data.getOperatorname());
					statement.setString(3, operatorPM5Data.getEdate());
					statement.setString(4, operatorPM5Data.getShift());
					statement.setString(5, operatorPM5Data.getCrew());
					statement.setBoolean(6, operatorPM5Data.isMovementcol1());
					statement.setString(7, operatorPM5Data.getMovementcol1desc());
					statement.setBoolean(8, operatorPM5Data.isConveyorcol1());
					statement.setString(9, operatorPM5Data.getConveyorcol1desc());
					statement.setBoolean(10, operatorPM5Data.isConveyorcol2());
					statement.setString(11, operatorPM5Data.getConveyorcol2desc());

					statement.setBoolean(12, operatorPM5Data.isConveyorcol3());
					statement.setString(13, operatorPM5Data.getConveyorcol3desc());
					statement.setBoolean(14, operatorPM5Data.isConveyorcol4());
					statement.setString(15, operatorPM5Data.getConveyorcol4desc());
					statement.setBoolean(16, operatorPM5Data.isConveyorcol5());
					statement.setString(17, operatorPM5Data.getConveyorcol5desc());

					statement.setBoolean(18, operatorPM5Data.isPowercol1());
					statement.setString(19, operatorPM5Data.getPowercol1desc());

					statement.setBoolean(20, operatorPM5Data.isPowercol2());
					statement.setString(21, operatorPM5Data.getPowercol2desc());

					statement.setBoolean(22, operatorPM5Data.isPowercol3());
					statement.setString(23, operatorPM5Data.getPowercol3desc());

					statement.setBoolean(24, operatorPM5Data.isPowercol4());
					statement.setString(25, operatorPM5Data.getPowercol4desc());

					statement.setBoolean(26, operatorPM5Data.isOrdercol1());
					statement.setString(27, operatorPM5Data.getOrdercol1desc());

					statement.setInt(28, operatorPM5Data.getId());


					return statement;
				}
			});

		}

	}

	/* (non-Javadoc)
	 * @see com.st.oBcc1pm5.dao.OperatorPM5Dao#CheckObcc(java.lang.String, java.lang.String)
	 */
	@Override
	public boolean CheckObcc(String date, String position,String shift) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSourceQRT);
	
//		SimpleDateFormat dateFormat=new SimpleDateFormat("MM-dd-yyyy");		
//		Date date=CommonUtil.checkDate(dates, dateFormat);
		
		boolean result=false;
		if(position.equals("R2"))
		{
				String sql = "SELECT count(*) FROM R2Operator_PM5 WHERE date = ? AND shift=?";
			    int count = jdbcTemplate.queryForObject(sql, Integer.class, new Object[] {date,shift});
				    if (count > 0)
				    	result =false;
				    else
				    	result =true;
				    return result;
		}
		else if(position.equals( "WinderDown"))
		{ 
			String sql = "SELECT count(*) FROM WinderDown WHERE date = ? AND shift=?";
			 int count = jdbcTemplate.queryForObject(sql, Integer.class, new Object[] {date,shift});
			    if (count > 0)
			    	result =false;
			    else
			    	result =true;
			    return result;
		}
		else if(position.equals( "stockoperator"))
		{ 
			String sql = "SELECT count(*) FROM StockOperator_PM5 WHERE date = ? AND shift=?";
			 int count = jdbcTemplate.queryForObject(sql, Integer.class, new Object[] {date,shift});
			    if (count > 0)
			    	result =false;
			    else
			    	result =true;
			    return result;
		}
		else if(position.equals( "leadoperator"))
		{
			 String sql = "SELECT count(*) FROM leadoperator_pm5  WHERE date=? AND shift=?";
			    int count = jdbcTemplate.queryForObject(sql, Integer.class, new Object[] {date,shift});
			    if (count > 0)
			    	result =false;
			    else
			    	result =true;
			    return result;
		}
		else  if(position.equals("R1WaterJetsDown"))
		{ 
			String sql = "SELECT count(*) FROM R1WaterJetsDown WHERE date = ? AND shift=?";
			 int count = jdbcTemplate.queryForObject(sql, Integer.class, new Object[] {date,shift});
			    if (count > 0)
			    	result =false;
			    else
			    	result =true;
			    return result;
		}
		else  if(position.equals("R2WaterJetsDown"))
		{ 
			String sql = "SELECT count(*) FROM R2WaterJetsDown WHERE date = ? AND shift=?";
			 int count = jdbcTemplate.queryForObject(sql, Integer.class, new Object[] {date,shift});
			    if (count > 0)
			    	result =false;
			    else
			    	result =true;
			    return result;
		}
		else  if(position.equals("R1"))
		{ 
			String sql = "SELECT count(*) FROM R1Operator_PM5 WHERE date = ? AND shift=?";
			 int count = jdbcTemplate.queryForObject(sql, Integer.class, new Object[] {date,shift});
			    if (count > 0)
			    	result =false;
			    else
			    	result =true;
			    return result;
		}
		else  if(position.equals("utilityoperator"))
		{ 
			String sql = "SELECT count(*) FROM utilityOperator_pm5 WHERE date = ? AND shift=?";
			 int count = jdbcTemplate.queryForObject(sql, Integer.class, new Object[] {date,shift});
			    if (count > 0)
			    	result =false;
			    else
			    	result =true;
			    return result;
		}
		return result;
	}}

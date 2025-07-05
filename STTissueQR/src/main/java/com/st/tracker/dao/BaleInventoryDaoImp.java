/**
 * 
 */
package com.st.tracker.dao;

import java.sql.Timestamp;
import java.util.Date;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.st.common.exception.TrackerException;

/**
 * @author sbora
 *
 */
@Repository
public class BaleInventoryDaoImp implements BaleInventoryDao {

	@Autowired
	@Qualifier("dataSourceTracker")
	private DataSource dataSourceT;
	
	/* (non-Javadoc)
	 * @see com.st.tracker.dao.BaleInventoryDao#getBaleInventories(java.util.Date, java.util.Date)
	 */
	@Override
	public double getConsumedWetLap(Date sdate, Date edate) throws TrackerException {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSourceT);
		Double weight=(double) 0;
		
		String sql="SELECT sum([BaleWeight]) "
				+ " FROM [tblBaleInventory] "
				+ " where "
				+ " ([TagID] like 'W%' or [TagID] like 'B%') "
				+ " and "
				+ " [ActualConsumedDateTime] between ? and ? ";
		
		try {
			weight=jdbcTemplate.queryForObject(sql, new Object[]{
					new Timestamp(sdate.getTime()),
					new Timestamp(edate.getTime())
			},Double.class);
			
			if(weight==null){
				weight=(double) 0;
			}
			
		} catch (Exception e) {
			throw new TrackerException(e);
		}
		
		return weight;
	}

}

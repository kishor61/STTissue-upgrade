/**
 *Jul 4, 2016
 *StockOperatorDao.java
 * TODO
 *com.st.obcc.dao
 *StockOperatorDao.java
 *Sunil Singh Bora
 */
package com.st.obcc.dao;

import java.util.List;

import com.st.obcc.model.StockOperator;

/**
 * @author snavhaal
 *
 */
public interface StockOperatorDao {
	
	void saveorUpdate(StockOperator data);
	
	StockOperator getOperatorData(String position,String date,String shift,String crew) throws Exception;
	
	List<StockOperator> getOperatorDataList(String position,String shift,String Sdate,String edate) throws Exception;
	
	long getDataCountDatePercentage(String position,String shift,String Sdate,String edate) throws Exception;

}

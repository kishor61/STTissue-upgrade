/**
 *Jul 4, 2016
 *StockOperatorService.java
 * TODO
 *com.st.obcc.service
 *StockOperatorService.java
 *Sunil Singh Bora
 */
package com.st.obcc.service;

import java.util.List;

import com.st.obcc.model.StockOperator;

/**
 * @author snavhaal
 *
 */

public interface StockOperatorService {

	void saveorUpdate(StockOperator data);
	
	StockOperator getOperatorData(String position,String date,String shift,String crew) throws Exception;
	
	List<StockOperator> getOperatorDataList(String position,String shift,String Sdate,String edate) throws Exception;
	
	long getDataCountDatePercentage(String position,String shift,String Sdate,String edate) throws Exception;
}

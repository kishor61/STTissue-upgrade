/**
 *Jun 2, 2016
 *OperatorDao.java
 * TODO
 *com.st.operator.dao
 *OperatorDao.java
 *Sunil Singh Bora
 */
package com.st.obcc.dao;

import java.util.List;

import com.st.obcc.model.OperatorData;

/**
 * @author snavhaal
 *
 */
public interface OperatorDao {
	 
	void saveorUpdate(OperatorData operatorData);
	
	OperatorData getOperatorData(String position,String shift,String date,String crew) throws Exception;
	
	List<OperatorData> getOperatorDataList(String position,String Sdate,String edate) throws Exception;
	
	/*long getDataCountDatePercentage(String position,String Sdate,String edate) throws Exception;
	
	double getDataCountDatePercentage(String Sdate,String edate) throws Exception;*/

	
	/**
	 * @param date
	 * @param position
	 * @param shift
	 * @return
	 */
	boolean CheckObcc(String date, String position, String shift);

	
	long getDataCountDatePercentage(String position, String sdate, String edate) throws Exception;
}

/**
 *Jun 27, 2016
 *R1OperatorDao.java
 * TODO
 *com.st.obcc.dao
 *R1OperatorDao.java
 *Sunil Singh Bora
 */
package com.st.obcc.dao;

import java.util.List;

import com.st.obcc.model.R1Operator;

/**
 * @author snavhaal
 *
 */
public interface R1OperatorDao {

	void saveorUpdate(R1Operator data);
	
	R1Operator getOperatorData(String position,String date,String shift,String crew) throws Exception;
	
	
	List<R1Operator> getOperatorDataList(String position,String Sdate,String edate) throws Exception;
	
	/*long getDataCountDatePercentage(String position,String Sdate,String edate) throws Exception;
	
	double getDataCountDatePercentage(String Sdate,String edate) throws Exception;
*/
	/**
	 * @param position
	 * @param sdate
	 * @param edate
	 * @return
	 * @throws Exception 
	 */
	long getDataCountDatePercentage1(String position, String sdate, String edate) throws Exception;
}

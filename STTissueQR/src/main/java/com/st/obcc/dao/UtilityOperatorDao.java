/**
 *Jun 16, 2016
 *UtilityOperatorDao.java
 * TODO
 *com.st.obcc.dao
 *UtilityOperatorDao.java
 *Sunil Singh Bora
 */
package com.st.obcc.dao;

import java.util.List;

import com.st.obcc.model.UtilityOperator;

/**
 * @author snavhaal
 *
 */
public interface UtilityOperatorDao {
	
	void saveorUpdate(UtilityOperator data);
	
	UtilityOperator getOperatorData(String position,String shift,String date,String crew) throws Exception;
	
	List<UtilityOperator> getOperatorDataList(String position,String Sdate,String edate) throws Exception;
	
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

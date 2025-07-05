/**
 *Jun 16, 2016
 *UtilityOperatorPM5Service.java
 * TODO
 *com.st.obcc.service
 *UtilityOperatorPM5Service.java
 *Sunil Singh Bora
 */
package com.st.obcc.service;

import java.util.List;

import com.st.obcc.model.UtilityOperator;


/**
 * @author snavhaal
 *
 */
public interface UtilityOperatorService {

	
	void saveorUpdate(UtilityOperator data);
	
	UtilityOperator getOperatorData(String position,String date,String shift,String crew) throws Exception;
	
	List<UtilityOperator> getOperatorDataList(String position,String Sdate,String edate) throws Exception;
	
	/*long getDataCountDatePercentage(String position,String Sdate,String edate) throws Exception;
	
	double getDataCountDatePercentage(String Sdate,String edate) throws Exception;*/

	/**
	 * @param position
	 * @param Sdate
	 * @param edate
	 * @return
	 * @throws Exception
	 */
	long getDataCountDatePercentage1(String position, String Sdate, String edate)
			throws Exception;
	
}

/**
 *Mar 17, 2018
 *UtilityOperatorPM5Service.java
 * TODO
 *com.st.obccPM5.service
 *UtilityOperatorPM5Service.java
 *Roshan Lal Tailor
 */
package com.st.obccPM5.service;

import java.util.List;


import com.st.obccPM5.model.UtilityOperatorPM5;

/**
 * @author roshan
 *
 */
public interface UtilityOperatorPM5Service {
	
	void saveorUpdate(UtilityOperatorPM5 data);

	
	UtilityOperatorPM5 getOperatorData(String position, String date, String shift,
			String crew) throws Exception;

	long getDataCountDatePercentage(String position,String shift, String Sdate, String edate)
			throws Exception;
	List<UtilityOperatorPM5> getOperatorDataList(String position, String string, String startDate, String endDate) throws Exception;


	/**
	 * @param position
	 * @param startDate
	 * @param endDate
	 * @return
	 * @throws Exception 
	 */
	List<UtilityOperatorPM5> getOperatorDataListForBothShift(String position, String startDate, String endDate) throws Exception;

}

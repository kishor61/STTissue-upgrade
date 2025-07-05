/**
 *Mar 17, 2018
 *UtilityOperatorPM5Dao.java
 * TODO
 *com.st.obccPM5.dao
 *UtilityOperatorPM5Dao.java
 *Roshan Lal Tailor
 */
package com.st.obccPM5.dao;

import java.util.List;


import com.st.obccPM5.model.UtilityOperatorPM5;

/**
 * @author roshan
 *
 */
public interface UtilityOperatorPM5Dao {

	/**
	 * @param data
	 */
	void saveorUpdate(UtilityOperatorPM5 data);

	UtilityOperatorPM5 getOperatorData(String position, String shift, String date,
			String crew) throws Exception;
	long getDataCountDatePercentage(String position,String shift, String sdate, String edate) throws Exception;
	
	List<UtilityOperatorPM5> getOperatorDataList(String position, String shift, String Sdate, String edate)
			throws Exception;

	/**
	 * @param position
	 * @param sdate
	 * @param edate
	 * @return
	 * @throws Exception 
	 */
	List<UtilityOperatorPM5> getOperatorDataListForBothShift(String position, String sdate, String edate) throws Exception;

}

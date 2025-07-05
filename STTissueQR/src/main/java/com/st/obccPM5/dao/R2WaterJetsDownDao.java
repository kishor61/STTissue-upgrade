/**
 *May 10, 2021
 *R2WaterJetsDownDao.java
 * TODO
 *com.st.obccPM5.dao
 *R2WaterJetsDownDao.java
 *Sohan Lal 
 */
package com.st.obccPM5.dao;

import java.text.ParseException;
import java.util.List;

import com.st.obccPM5.model.R2WaterJetsDown;

/**
 * @author Sohanlal
 *
 */
public interface R2WaterJetsDownDao {
	void saveorUpdate(R2WaterJetsDown data);

	/**
	 * @param position
	 * @param shift
	 * @param sdate
	 * @param edate
	 * @return
	 */
	List<R2WaterJetsDown> getOperatorDataList(String position, String shift,
			String sdate, String edate);

	/**
	 * @param position
	 * @param shift
	 * @param sdate
	 * @param edate
	 * @return
	 */
	R2WaterJetsDown getOperatorData(String position, String shift,String date, String crew);

	/**
	 * @param position
	 * @param sdate
	 * @param edate
	 * @param shift
	 * @return
	 * @throws ParseException 
	 */
	long getDataCountDatePercentage(String position, String sdate, String edate, String shift) throws ParseException;

	/**
	 * @param position
	 * @param sdate
	 * @param edate
	 * @return
	 */
	List<R2WaterJetsDown> getOperatorDataListForBothShift(String position, String sdate, String edate);
}


/**
 *Oct 22, 2019
 *R1OperatorPM5Dao.java
 * TODO
 *com.st.obccPM5.dao
 *R1OperatorPM5Dao.java
 *Roshan Lal Tailor
 */
package com.st.obccPM5.dao;

import com.st.obccPM5.model.R1WaterJetsDown;

import java.text.ParseException;
import java.util.List;

/**
 * @author sohan
 *
 */
public interface R1WaterJetsDownDao {
	void saveorUpdate(R1WaterJetsDown data);

	/**
	 * @param position
	 * @param shift
	 * @param sdate
	 * @param edate
	 * @return
	 */
	List<R1WaterJetsDown> getOperatorDataList(String position, String shift,
			String sdate, String edate);

	/**
	 * @param position
	 * @param shift
	 * @param sdate
	 * @param edate
	 * @return
	 */
	R1WaterJetsDown getOperatorData(String position, String shift,String date, String crew);

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
	List<R1WaterJetsDown> getOperatorDataListForBothShift(String position, String sdate, String edate);
}

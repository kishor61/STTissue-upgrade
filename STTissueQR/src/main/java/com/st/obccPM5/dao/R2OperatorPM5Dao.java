/**
 *Oct 22, 2019
 *R2OperatorPM5Dao.java
 * TODO
 *com.st.obccPM5.dao
 *R2OperatorPM5Dao.java
 *Roshan Lal Tailor
 */
package com.st.obccPM5.dao;
import java.text.ParseException;
import java.util.List;

import com.st.obccPM5.model.R2OperatorPM5;

/**
 * @author roshan
 *
 */
public interface R2OperatorPM5Dao {
	void saveorUpdate(R2OperatorPM5 data);

	/**
	 * @param position
	 * @param startDate
	 * @param endDate
	 * @param shift
	 * @return
	 */
	List<R2OperatorPM5> getOperatorDataList(String position, String startDate,
			String endDate, String shift);

	/**
	 * @param position
	 * @param sdate
	 * @param edate
	 * @return
	 */
	List<R2OperatorPM5> getOperatorDataList(String position, String sdate,
			String edate);

	
	R2OperatorPM5 getOperatorData(String position, String shift,
			String date, String crew) throws Exception ;
	
	/**
	 * @param position
	 * @param sdate
	 * @param edate
	 * @param shift 
	 * @return
	 * @throws ParseException 
	 */
	long getDataCountDatePercentage(String position, String sdate, String edate, String shift) throws ParseException;}

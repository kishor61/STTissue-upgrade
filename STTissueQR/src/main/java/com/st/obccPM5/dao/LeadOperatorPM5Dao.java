/**
 *Oct 21, 2019
 *LeadOperatorPM5Dao.java
 * TODO
 *com.st.obccPM5.dao
 *LeadOperatorPM5Dao.java
 *Roshan Lal Tailor
 */
package com.st.obccPM5.dao;

import java.text.ParseException;
import java.util.List;

import com.st.obccPM5.model.LeadOperatorPM5;

/**
 * @author roshan
 *
 */
public interface LeadOperatorPM5Dao {

	void saveorUpdate(LeadOperatorPM5 data);


	/**
	 * @param position
	 * @param sdate
	 * @param edate
	 * @param shift
	 * @return
	 */
	List<LeadOperatorPM5> getOperatorDataList(String position, String sdate,
			String edate, String shift);


	/**
	 * @param position
	 * @param sdate
	 * @param edate
	 * @param shift
	 * @return
	 */
	LeadOperatorPM5 getOperatorData(String position,
			String date, String shift);


	/**
	 * @param position
	 * @param sdate
	 * @param edate
	 * @param shift
	 * @return
	 * @throws ParseException 
	 */
	long getDataCountDatePercentage(String position, String sdate, String edate, String shift) throws ParseException;}

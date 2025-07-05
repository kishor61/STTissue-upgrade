/**
 *Oct 22, 2019
 *R1OperatorPM5Service.java
 * TODO
 *com.st.obccPM5.service
 *R1OperatorPM5Service.java
 *Roshan Lal Tailor
 */
package com.st.obccPM5.service;

import java.text.ParseException;
import java.util.List;

import com.st.obccPM5.model.R1OperatorPM5;

/**
 * @author sohan
 *
 */
public interface R1OperatorPM5Service {
	
	void saveorUpdate(R1OperatorPM5 data);


	/**
	 * @param position
	 * @param startDate
	 * @param endDate
	 * @return
	 * @throws ParseException 
	 */
	long getDataCountDatePercentage(String position, String startDate,String endDate,String shift) throws ParseException;


	/**
	 * @param position
	 * @param shift
	 * @param sdate
	 * @param edate
	 * @return
	 */
	
	List<R1OperatorPM5> getOperatorDataList(String position, String shift,
			String sdate, String edate);


	/**
	 * @param position
	 * @param shift
	 * @param date
	 * @param crew
	 * @return
	 */
	R1OperatorPM5 getOperatorData(String position, String shift, String date, String crew);


	/**
	 * @param position
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	List<R1OperatorPM5> getOperatorDataListForBothShift(String position, String startDate, String endDate);}

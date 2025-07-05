/**
 *Oct 22, 2019
 *R2OperatorPM5Service.java
 * TODO
 *com.st.obccPM5.service
 *R2OperatorPM5Service.java
 *Roshan Lal Tailor
 */
package com.st.obccPM5.service;

import java.text.ParseException;
import java.util.List;

import com.st.obccPM5.model.R2OperatorPM5;

/**
 * @author roshan
 *
 */
public interface R2OperatorPM5Service {
	
	
	
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
	 * @param shift 
	 * @param sdate2
	 * @return
	 */
	long getDataCountDatePercentage(String position, String sdate, String edate, String shift) throws ParseException ;



	/**
	 * @param position
	 * @param sdate
	 * @param edate
	 * @return
	 */
	List<R2OperatorPM5> getOperatorDataList(String position, String sdate,
			String edate);

	/**
	 * @param position
	 * @param date
	 * @param shift
	 * @param crew
	 * @return
	 * @throws Exception 
	 */
	R2OperatorPM5 getOperatorData(String position,  String shift,String date, String crew) throws Exception;
}

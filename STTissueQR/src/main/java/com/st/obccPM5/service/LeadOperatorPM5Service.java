/**
 *Oct 21, 2019
 *LeadOperatorPM5Service.java
 * TODO
 *com.st.oBcc1pm5.service
 *LeadOperatorPM5Service.java
 *Roshan Lal Tailor
 */
package com.st.obccPM5.service;

import java.text.ParseException;
import java.util.List;

import com.st.obccPM5.model.LeadOperatorPM5;
/**
 * @author sohan
 *
 */
public interface LeadOperatorPM5Service {

	void saveorUpdate(LeadOperatorPM5 data);

	/**
	 * @param position
	 * @param date
	 * @param shift
	 * @param crew
	 * @return
	 * @throws Exception 
	 */
	LeadOperatorPM5 getOperatorData(String position, String date, String shift) throws Exception;

	/**
	 * @param position
	 * @param startDate
	 * @param endDate
	 * @param shift
	 * @return
	 */
	List<LeadOperatorPM5> getOperatorDataList(String position,
			String startDate, String endDate,String shift);
	
	/**
	 * @param position
	 * @param startDate
	 * @param endDate
	 * @return
	 * @throws ParseException 
	 */
	long getDataCountDatePercentage(String position, String startDate,String endDate,String shift) throws ParseException;
	}

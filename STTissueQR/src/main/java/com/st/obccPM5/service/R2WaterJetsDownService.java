/**
 *May 10, 2021
 *R2WaterJetsDownService.java
 * TODO
 *com.st.obccPM5.service
 *R2WaterJetsDownService.java
 *Sohan Lal 
 */
package com.st.obccPM5.service;

import java.text.ParseException;
import java.util.List;

import com.st.obccPM5.model.R2WaterJetsDown;

/**
 * @author Sohanlal
 *
 */
public interface R2WaterJetsDownService {
	void saveorUpdate(R2WaterJetsDown data);
	long getDataCountDatePercentage(String position, String startDate,String endDate,String shift) throws ParseException;
	List<R2WaterJetsDown> getOperatorDataList(String position, String shift,
			String sdate, String edate);
	R2WaterJetsDown getOperatorData(String position, String shift, String date, String crew);
	
	List<R2WaterJetsDown> getOperatorDataListForBothShift(String position, String startDate, String endDate);
}


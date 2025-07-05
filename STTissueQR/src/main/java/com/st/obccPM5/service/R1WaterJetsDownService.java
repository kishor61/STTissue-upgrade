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

import com.st.obccPM5.model.R1WaterJetsDown;

/**
 * @author sohan
 *
 */
public interface R1WaterJetsDownService {	
	void saveorUpdate(R1WaterJetsDown data);
	long getDataCountDatePercentage(String position,String shift, String startDate,String endDate) throws ParseException;
	List<R1WaterJetsDown> getOperatorDataList(String position, String shift,
			String sdate, String edate);
	R1WaterJetsDown getOperatorData(String position, String shift, String date, String crew);
	/**
	 * @param position
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	List<R1WaterJetsDown> getOperatorDataListForBothShift(String position, String startDate, String endDate);
}

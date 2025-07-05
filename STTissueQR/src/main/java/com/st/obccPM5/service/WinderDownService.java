/**
 *May 7, 2021
 *WinderDownService1.java
 * TODO
 *com.st.obccPM5.service
 *WinderDownService1.java
 *Sohan Lal 
 */
package com.st.obccPM5.service;

import java.text.ParseException;
import java.util.List;

import com.st.obccPM5.model.WinderDown;

/**
 * @author Sohanlal
 *
 */
public interface WinderDownService {
	void saveorUpdate(WinderDown data);
	long getDataCountDatePercentage(String position, String startDate,String endDate,String shift) throws ParseException;
	List<WinderDown> getOperatorDataList(String position, String shift,
			String sdate, String edate);
	List<WinderDown> getOperatorDataListForBothShift(String position,String sdate, String edate);
	
	WinderDown getOperatorData(String position, String shift, String date, String crew);
}

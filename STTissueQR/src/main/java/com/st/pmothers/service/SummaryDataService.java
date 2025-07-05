/**
 *Dec 1, 2014
 *SummaryDataService.java
 * TODO
 *com.st.pmothers.service
 *SummaryDataService.java
 *Sunil Singh Bora
 */
package com.st.pmothers.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.st.pmothers.model.SummaryData;

/**
 * @author sbora
 *
 */
public interface SummaryDataService {

	/**
	 * @param summaryData
	 * @return
	 */
	int saveOrUpdate(SummaryData summaryData);

	/**
	 * @param checkDate
	 * @param checkDate2
	 * @return
	 */
	List<Map<String, Object>> getDateList(Date sdate, Date edate);

	/**
	 * @param id
	 * @return
	 */
	SummaryData getSummaryData(int id);

	/**
	 * @param checkDate
	 * @return
	 */
	SummaryData getMonthToDateData(Date date);

	/**
	 * @param id
	 */
	void delete(int id);

}

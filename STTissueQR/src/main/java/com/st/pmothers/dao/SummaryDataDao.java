/**
 *Dec 1, 2014
 *SummaryDataDao.java
 * TODO
 *com.st.pmothers.dao
 *SummaryDataDao.java
 *Sunil Singh Bora
 */
package com.st.pmothers.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.st.pmothers.model.SummaryData;

/**
 * @author sbora
 *
 */
public interface SummaryDataDao {

	/**
	 * @param summaryData
	 * @return
	 */
	int saveOrUpdate(SummaryData summaryData);

	/**
	 * @param sdate
	 * @param edate
	 * @return
	 */
	List<Map<String, Object>> getDateList(Date sdate, Date edate);

	/**
	 * @param id
	 * @return
	 */
	SummaryData getSummaryData(int id);

	/**
	 * @param date
	 * @return
	 */
	SummaryData getMonthToDateData(Date date);

	/**
	 * @param id
	 */
	void delete(int id);

}

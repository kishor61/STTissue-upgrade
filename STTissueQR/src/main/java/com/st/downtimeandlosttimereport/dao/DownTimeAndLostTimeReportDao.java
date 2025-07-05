/**
 *Sep 12, 2017
 *DownTimeAndLostTimeReportDao.java
 * TODO
 *com.st.downtimeandlosttimereport.dao
 *DownTimeAndLostTimeReportDao.java
 *Roshan Lal Tailor
 */
package com.st.downtimeandlosttimereport.dao;

import java.util.Date;
import java.util.List;

import com.st.downtimeandlosttimereport.model.DownTimeAndLostTimeReport;

/**
 * @author roshan
 *
 */
public interface DownTimeAndLostTimeReportDao {

	/**
	 * @param eDate 
	 * @param sDate 
	 * @return
	 */
	List<DownTimeAndLostTimeReport> getDataDateWise(Date sDate, Date eDate);

	/**
	 * @return
	 */
	List<DownTimeAndLostTimeReport> getsecondaryCode();

}

/**
 *Sep 12, 2017
 *DownTimeAndLostTimeReportService.java
 * TODO
 *com.st.downtimeandlosttimereport.service
 *DownTimeAndLostTimeReportService.java
 *Roshan Lal Tailor
 */
package com.st.downtimeandlosttimereport.service;

import java.util.Date;
import java.util.List;

import com.st.downtimeandlosttimereport.model.DownTimeAndLostTimeReport;

/**
 * @author roshan
 *
 */
public interface DownTimeAndLostTimeReportService {

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

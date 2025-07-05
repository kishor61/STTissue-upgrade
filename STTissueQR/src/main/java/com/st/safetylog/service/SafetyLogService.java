/**
 * 
 */
package com.st.safetylog.service;

import java.util.Date;
import java.util.List;

import com.st.safetylog.model.SafetyLog;

/**
 * @author sbora
 *
 */
public interface SafetyLogService {

	/**
	 * @param safetyLog
	 */
	void saveOrUpdate(SafetyLog safetyLog);

	/**
	 * @param sDate
	 * @param eDate
	 * @return
	 */
	List<SafetyLog> getSafetyLogs(Date sdate, Date edate);

	/**
	 * @param id
	 * @return
	 */
	SafetyLog getSafetyLog(int id);

	/**
	 * @param id
	 */
	void delete(int id);

	/**
	 * @param safetyLog
	 */
	void closeLog(SafetyLog safetyLog);

	/**
	 * @param id
	 * @param date
	 */
	void updateSafetyLogReview(int id, Date date);

	/**
	 * @param safetyLog
	 */
	void resetLog(SafetyLog safetyLog);

}

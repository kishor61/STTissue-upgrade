/**
 *May 1, 2017
 *CLRewinderService.java
 * TODO
 *com.st.clrewinder.service
 *CLRewinderService.java
 *Roshan Lal Tailor
 */
package com.st.clrewinder.service;

import java.util.Date;
import java.util.List;

import com.st.clrewinder.model.CLRewinder;
import com.st.winderbreakmonitoring.model.WinderBreakMonitoring;

/**
 * @author roshan
 *
 */
public interface CLRewinderService {
	


	/**
	 * @param sdate
	 * @param edate
	 * @return
	 */
	List<CLRewinder> getWinderBreakData(Date sdate, Date edate);

	/**
	 * @param wm
	 * @return
	 */
	int save(CLRewinder wm);

	/**
	 * @param wm
	 */
	void update(CLRewinder wm);

	/**
	 * @param sdate
	 * @param edate
	 * @return
	 */
	List<CLRewinder> getWinderBreakMonitoringReport(Date sdate,
			Date edate);

	/**
	 * @param id
	 */
	void delete(int id);

	/**
	 * @return
	 */
	List<CLRewinder> getWinderBreakReason();

	/**
	 * @param wm
	 * @return
	 */
	int savebreakreason(CLRewinder wm);

	/**
	 * @param id
	 * @return
	 */
	List<CLRewinder> getEditWinderBreakReason(int id);

	/**
	 * @param wm
	 */
	void updatebreakreason(CLRewinder wm);

	/**
	 * @param id
	 */
	void deleteBreakReason(int id);

	/**
	 * @param id
	 * @return
	 */
	List<CLRewinder> getWinderBreakDataOfID(int id);

	/**
	 * @param wm
	 * @return
	 */
	int savebreakreason1(CLRewinder wm);

	/**
	 * @param wm
	 */
	void updatebreakreason1(CLRewinder wm);

	/**
	 * @return
	 */
	List<CLRewinder> getWinderSecondaryBreakReason();

	/**
	 * @param reasonforbreak 
	 * @return
	 */
	List<CLRewinder> getSecondaryReason(String reasonforbreak);

	/**
	 * @param id
	 * @return
	 */
	List<CLRewinder> getEditWinderBreakSecondaryReason(int id);

	/**
	 * @param id
	 */
	void deleteBreakReason1(int id);

	/**
	 * @param id
	 */
	void deleteSecondaryBreakReason(int id);

	/**
	 * @return
	 */
	List<CLRewinder> getWinderBreakReasonShow();

	/**
	 * @return
	 */
	List<CLRewinder> getSecondaryReason();

	/**
	 * @return
	 */
	List<CLRewinder> getPrimaryReason();

	/**
	 * @return
	 */
	List<CLRewinder> getWinderSecondaryBreakReasonGroupBy();

	/**
	 * @return
	 */
	List<CLRewinder> getWinderBreakReasonShowGroupBy();

	/**
	 * @param sdate
	 * @param edate
	 * @param pcode
	 * @param scode
	 * @param string 
	 * @return
	 */
	List<CLRewinder> getEfficiencySummaryReportData(Date sdate, Date edate,
			String pcode, String scode, String string);

	/**
	 * @return
	 */
	List<CLRewinder> getWinderBreakReasonPrimaryReason();


	
	
}

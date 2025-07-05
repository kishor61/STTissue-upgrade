/**
 *Oct 30, 2015
 *WinderBreakMonitoringDao.java
 * TODO
 *com.st.winderbreakmonitoring.dao
 *WinderBreakMonitoringDao.java
 *Sunil Singh Bora
 */
package com.st.winderbreakmonitoring.dao;

import java.util.Date;
import java.util.List;

import com.st.winderbreakmonitoring.model.WinderBreakMonitoring;

/**
 * @author roshan
 *
 */
public interface WinderBreakMonitoringDao {

	/**
	 * @param sdate
	 * @param edate
	 * @return
	 */
	List<WinderBreakMonitoring> getWinderBreakData(Date sdate, Date edate);

	/**
	 * @param wm
	 * @return
	 */
	int save(WinderBreakMonitoring wm);

	/**
	 * @param wm
	 */
	void update(WinderBreakMonitoring wm);

	/**
	 * @param sdate
	 * @param edate
	 * @return
	 */
	List<WinderBreakMonitoring> getWinderBreakMonitoringReport(Date sdate,
			Date edate);

	/**
	 * @param id
	 */
	void delete(int id);

	/**
	 * @return
	 */
	List<WinderBreakMonitoring> getWinderBreakReason();

	/**
	 * @param wm
	 * @return
	 */
	int savebreakreason(WinderBreakMonitoring wm);

	/**
	 * @param id
	 * @return
	 */
	List<WinderBreakMonitoring> getEditWinderBreakReason(int id);

	/**
	 * @param wm
	 */
	void updatebreakreason(WinderBreakMonitoring wm);

	/**
	 * @param id
	 */
	void deleteBreakReason(int id);

	/**
	 * @param id
	 * @return 
	 */
	List<WinderBreakMonitoring> getWinderBreakDataOfID(int id);

	/**
	 * @param wm
	 * @return
	 */
	int savebreakreason1(WinderBreakMonitoring wm);

	/**
	 * @param wm
	 */
	void updatebreakreason1(WinderBreakMonitoring wm);

	/**
	 * @return
	 */
	List<WinderBreakMonitoring> getWinderSecondaryBreakReason();

	/**
	 * @param reasonforbreak
	 * @return
	 */
	List<WinderBreakMonitoring> getSecondaryReason(String reasonforbreak);

	/**
	 * @param id
	 * @return
	 */
	List<WinderBreakMonitoring> getEditWinderBreakSecondaryReason(int id);

	/**
	 * @param id
	 */
	void deleteBreakReason1(int id);

}

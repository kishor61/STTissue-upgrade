/**
 * 
 */
package com.st.safetylog.dao;

import java.util.Date;
import java.util.List;

import com.st.safetylog.model.PositiveObservation;
import com.st.safetylog.model.PositiveObservationP;
import com.st.safetylog.model.SafetyHousekeeping;
import com.st.safetylog.model.SafetyHousekeepingAction;
import com.st.safetylog.model.SafetyHousekeepingSchedule;
import com.st.safetylog.model.SafetyHousekeepingStdType;
import com.st.safetylog.model.SafetyHousekeepingTask;

/**
 * @author sbora
 *
 */
public interface SafetyHousekeepingDao {

	/**
	 * @param type
	 * @return
	 */
	List<SafetyHousekeeping> getSafetyHousekeeping(String type);

	/**
	 * @param housekeeping
	 */
	void saveOrUpdate(SafetyHousekeeping housekeeping);

	/**
	 * @param id
	 */
	void deleteStandard(int id);

	/**
	 * @param id
	 * @return
	 */
	SafetyHousekeeping getSafetyHousekeeping(int id);

	/**
	 * @param housekeepingAction
	 */
	void saveOrUpdate(SafetyHousekeepingAction housekeepingAction);

	/**
	 * @param sid
	 * @param edate 
	 * @param sdate 
	 * @return
	 */
	List<SafetyHousekeepingAction> getSafetyHousekeepingAction(int sid, int taskId);

	/**
	 * @param id
	 * @return
	 */
	SafetyHousekeepingAction getSafetyHousekeepingAction(int id);

	/**
	 * @param id
	 */
	void deleteAction(int id);

	/**
	 * @param housekeepingAction
	 */
	void closeAction(SafetyHousekeepingAction housekeepingAction);

	/**
	 * @param id
	 * @param housekeepingTask 
	 * @param checked
	 */
	void checkTaskStandard(int sid, SafetyHousekeepingTask housekeepingTask, boolean checked);

	/**
	 * @param taskId
	 * @return
	 */
	List<SafetyHousekeeping> getSafetyHousekeepingAndActions(int taskId);

	/**
	 * @param id
	 * @return
	 */
	SafetyHousekeepingTask getSafetyHousekeepingTask(int id);

	/**
	 * @param housekeepingTask
	 * @return 
	 */
	int saveOrUpdate(SafetyHousekeepingTask housekeepingTask);

	/**
	 * @param genKeyId
	 * @return
	 */
	SafetyHousekeepingTask isHousekeepingTaskExist(String genKeyId);

	/**
	 * @param housekeepingSchedule
	 * @return
	 * @throws Exception 
	 */
	int saveOrUpdate(SafetyHousekeepingSchedule housekeepingSchedule) throws Exception;

	
	void deleteSechedule(int id);

	/**
	 * @param sdate
	 * @param edate
	 * @return
	 */
	List<SafetyHousekeepingSchedule> getSafetyHousekeepingSchedules(Date sdate,
			Date edate);


	/**
	 * @return
	 */
	List<SafetyHousekeepingStdType> getSafetyHouseStandard();

	/**
	 * @param housekeepingStdType
	 * @return
	 */
	String saveOrUpdate(SafetyHousekeepingStdType housekeepingStdType);

	/**
	 * @param id
	 * @return
	 */
	SafetyHousekeepingStdType getSafetyHousekeepingStdType(String id);

	/**
	 * @param id
	 */
	void deleteStdType(String id);

	/**
	 * @return
	 */
	List<SafetyHousekeeping> getSafetyHousekeeping();

	/**
	 * @param date
	 * @return
	 */
	List<SafetyHousekeepingSchedule> getScheduledList(Date date);

	/**
	 * @param sDate
	 * @param eDate
	 * @return
	 */
	List<SafetyHousekeepingTask> getSafetyHousekeepingTasks(Date sDate,
			Date eDate);

	/**
	 * @param id
	 * @param auditStatus
	 */
	void scheduleStatus(int id, boolean auditStatus);

	/**
	 * @param taskId
	 * @return
	 */
	boolean actionsColosed(int sid,int taskId);

	
	/**
	 * @param sdate
	 * @param edate
	 * @param area
	 * @param auditor
	 * @return
	 */
	List<SafetyHousekeepingTask> getSafetyHousekeepingTasks(Date sdate,
			Date edate, int area, int auditor);

	/**
	 * @param id
	 * @return
	 */
	boolean taskExist(int id);

	/**
	 * @param edate 
	 * @param sdate 
	 * 
	 */
	void removeUnwantedTasks(Date sdate, Date edate);

	/**
	 * @param taskId
	 */
	void deleteTask(int taskId);

	/**
	 * @return
	 */
	List<SafetyHousekeeping> getSafetyHousekeepingOpen(int area,
			int auditor, String bywhom);

	/**
	 * @param sdate
	 * @param edate
	 * @return
	 */
	List<SafetyHousekeeping> getSafetyHousekeepingClosedItem(Date sdate,
			Date edate);

	/**
	 * @param sdate
	 * @param edate
	 * @return
	 */
	List<SafetyHousekeepingSchedule> getSafetyHousekeepingAuditSchedulesStatus(
			Date sdate, Date edate);

	/**
	 * @param auditorId
	 * @return
	 */
	List<SafetyHousekeepingSchedule> getauditerDetails(int auditorId);

	/**
	 * @param date
	 * @param auditStatus
	 * @param auditorId
	 */
	void positiveStatus(Date date, boolean auditStatus, String auditorId);

	/**
	 * @param sdate
	 * @param edate
	 * @return
	 */
//	List<PositiveObservation> getpositiveStatus(Date sdate, Date edate);
	
	List<PositiveObservation> getpositiveStatus(Date sdate, Date edate);

}

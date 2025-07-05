/**
 * 
 */
package com.st.safetylog.service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.st.common.CommonUtil;
import com.st.safetylog.dao.SafetyHousekeepingDao;
import com.st.safetylog.model.PositiveObservation;
import com.st.safetylog.model.SafetyHousekeeping;
import com.st.safetylog.model.SafetyHousekeepingAction;
import com.st.safetylog.model.SafetyHousekeepingSchedule;
import com.st.safetylog.model.SafetyHousekeepingStdType;
import com.st.safetylog.model.SafetyHousekeepingTask;

/**
 * @author sbora
 *
 */
@Service
public class SafetyHousekeepingServiceImp implements SafetyHousekeepingService {
	
	private static final Logger logger=LoggerFactory.getLogger(SafetyHousekeepingServiceImp.class);
	
	
	@Autowired
	private SafetyHousekeepingDao safetyHousekeepingDao;
	
	

	/* (non-Javadoc)
	 * @see com.st.safetylog.service.SafetyHousekeepingService#getSafetyHousekeeping(java.lang.String)
	 */
	@Transactional
	@Override
	public List<SafetyHousekeeping> getSafetyHousekeeping(String type) {
		
		return safetyHousekeepingDao.getSafetyHousekeeping(type);
	}

	/* (non-Javadoc)
	 * @see com.st.safetylog.service.SafetyHousekeepingService#saveOrUpdate(com.st.safetylog.model.SafetyHousekeeping)
	 */
	@Transactional
	@Override
	public void saveOrUpdate(SafetyHousekeeping housekeeping) {
		safetyHousekeepingDao.saveOrUpdate(housekeeping);
	}

	/* (non-Javadoc)
	 * @see com.st.safetylog.service.SafetyHousekeepingService#deleteStandard(int)
	 */
	@Transactional
	@Override
	public void deleteStandard(int id) {
		safetyHousekeepingDao.deleteStandard(id);
	}

	/* (non-Javadoc)
	 * @see com.st.safetylog.service.SafetyHousekeepingService#getSafetyHousekeeping(int)
	 */
	@Transactional
	@Override
	public SafetyHousekeeping getSafetyHousekeeping(int id) {
		return safetyHousekeepingDao.getSafetyHousekeeping(id);
	}

	/* (non-Javadoc)
	 * @see com.st.safetylog.service.SafetyHousekeepingService#saveOrUpdate(com.st.safetylog.model.SafetyHousekeepingAction)
	 */
	@Transactional
	@Override
	public void saveOrUpdate(SafetyHousekeepingAction housekeepingAction) {
		safetyHousekeepingDao.saveOrUpdate(housekeepingAction);
	}

	/* (non-Javadoc)
	 * @see com.st.safetylog.service.SafetyHousekeepingService#getSafetyHousekeepingAction(int)
	 */
	@Transactional
	@Override
	public List<SafetyHousekeepingAction> getSafetyHousekeepingAction(int sid,int taskId) {
		return safetyHousekeepingDao.getSafetyHousekeepingAction(sid,taskId);
	}

	/* (non-Javadoc)
	 * @see com.st.safetylog.service.SafetyHousekeepingService#getSafetyHousekeepingAction(int)
	 */
	@Transactional
	@Override
	public SafetyHousekeepingAction getSafetyHousekeepingAction(int id) {
		return safetyHousekeepingDao.getSafetyHousekeepingAction(id);
	}

	/* (non-Javadoc)
	 * @see com.st.safetylog.service.SafetyHousekeepingService#deleteAction(int)
	 */
	@Transactional
	@Override
	public void deleteAction(int id) {
		safetyHousekeepingDao.deleteAction(id);
	}

	

	/* (non-Javadoc)
	 * @see com.st.safetylog.service.SafetyHousekeepingService#checkStandard(int, boolean)
	 */
	@Transactional
	@Override
	public void checkTaskStandard(int sid,SafetyHousekeepingTask housekeepingTask, boolean checked) {
		safetyHousekeepingDao.checkTaskStandard(sid,housekeepingTask,checked);
	}

	/* (non-Javadoc)
	 * @see com.st.safetylog.service.SafetyHousekeepingService#closeAction(com.st.safetylog.model.SafetyHousekeepingAction)
	 */
	@Transactional
	@Override
	public void closeAction(SafetyHousekeepingAction housekeepingAction) {
		safetyHousekeepingDao.closeAction(housekeepingAction);
		
	}

	/* (non-Javadoc)
	 * @see com.st.safetylog.service.SafetyHousekeepingService#getSafetyHousekeepingAndActions(java.lang.String)
	 */
	@Transactional
	@Override
	public List<SafetyHousekeeping> getSafetyHousekeepingAndActions(int taskId) {
		return safetyHousekeepingDao.getSafetyHousekeepingAndActions(taskId);
	}

	/* (non-Javadoc)
	 * @see com.st.safetylog.service.SafetyHousekeepingService#getSafetyHousekeepingTask(int)
	 */
	@Transactional
	@Override
	public SafetyHousekeepingTask getSafetyHousekeepingTask(int id) {
		return safetyHousekeepingDao.getSafetyHousekeepingTask(id);
	}

	/* (non-Javadoc)
	 * @see com.st.safetylog.service.SafetyHousekeepingService#saveOrUpdate(com.st.safetylog.model.SafetyHousekeepingTask)
	 */
	@Transactional
	@Override
	public int saveOrUpdate(SafetyHousekeepingTask housekeepingTask) {
		return safetyHousekeepingDao.saveOrUpdate(housekeepingTask);
	}

	/* (non-Javadoc)
	 * @see com.st.safetylog.service.SafetyHousekeepingService#isHousekeepingTaskExist(java.lang.String)
	 */
	@Transactional
	@Override
	public SafetyHousekeepingTask isHousekeepingTaskExist(String genKeyId) {
		return safetyHousekeepingDao.isHousekeepingTaskExist(genKeyId);
	}

	/* (non-Javadoc)
	 * @see com.st.safetylog.service.SafetyHousekeepingService#saveOrUpdate(com.st.safetylog.model.SafetyHousekeepingSchedule)
	 */
	@Transactional
	@Override
	public int saveOrUpdate(SafetyHousekeepingSchedule housekeepingSchedule)
			throws Exception {
		return safetyHousekeepingDao.saveOrUpdate(housekeepingSchedule);
	}



	/* (non-Javadoc)
	 * @see com.st.safetylog.service.SafetyHousekeepingService#deleteSechedule(int)
	 */
	@Transactional
	@Override
	public void deleteSechedule(int id) {
		safetyHousekeepingDao.deleteSechedule(id);
	}

	/* (non-Javadoc)
	 * @see com.st.safetylog.service.SafetyHousekeepingService#getSafetyHousekeepingSchedules(java.util.Date, java.util.Date, java.lang.String)
	 */
	@Transactional
	@Override
	public List<SafetyHousekeepingSchedule> getSafetyHousekeepingSchedules(
			Date sdate, Date edate) {
		return safetyHousekeepingDao.getSafetyHousekeepingSchedules(sdate,edate);
	}



	/* (non-Javadoc)
	 * @see com.st.safetylog.service.SafetyHousekeepingService#getSafetyHouseStandard()
	 */
	@Transactional
	@Override
	public List<SafetyHousekeepingStdType> getSafetyHouseStandard() {
		
		return safetyHousekeepingDao.getSafetyHouseStandard();
	}

	/* (non-Javadoc)
	 * @see com.st.safetylog.service.SafetyHousekeepingService#saveOrUpdate(com.st.safetylog.model.SafetyHousekeepingStdType)
	 */
	@Transactional
	@Override
	public String saveOrUpdate(SafetyHousekeepingStdType housekeepingStdType) {
		return safetyHousekeepingDao.saveOrUpdate(housekeepingStdType);
	}

	/* (non-Javadoc)
	 * @see com.st.safetylog.service.SafetyHousekeepingService#getSafetyHousekeepingStdType(java.lang.String)
	 */
	@Transactional
	@Override
	public SafetyHousekeepingStdType getSafetyHousekeepingStdType(String id) {
		return safetyHousekeepingDao.getSafetyHousekeepingStdType(id);
	}

	/* (non-Javadoc)
	 * @see com.st.safetylog.service.SafetyHousekeepingService#deleteStdType(java.lang.String)
	 */
	@Transactional
	@Override
	public void deleteStdType(String id) {
		safetyHousekeepingDao.deleteStdType(id);
	}

	/* (non-Javadoc)
	 * @see com.st.safetylog.service.SafetyHousekeepingService#getSafetyHousekeeping()
	 */
	@Transactional
	@Override
	public List<SafetyHousekeeping> getSafetyHousekeeping() {
		return safetyHousekeepingDao.getSafetyHousekeeping();
	}

	/* (non-Javadoc)
	 * @see com.st.safetylog.service.SafetyHousekeepingService#getScheduledList(java.util.Date)
	 */
	@Transactional
	@Override
	public List<SafetyHousekeepingSchedule> getScheduledList(Date date) {
		return safetyHousekeepingDao.getScheduledList(date);
	}

	/* (non-Javadoc)
	 * @see com.st.safetylog.service.SafetyHousekeepingService#getSafetyHousekeepingTasks(java.util.Date, java.util.Date)
	 */
	@Transactional
	@Override
	public List<SafetyHousekeepingTask> getSafetyHousekeepingTasks(Date sDate,
			Date eDate) {
		
		return safetyHousekeepingDao.getSafetyHousekeepingTasks(sDate,eDate);
	}

	/* (non-Javadoc)
	 * @see com.st.safetylog.service.SafetyHousekeepingService#scheduleStatus(int, boolean)
	 */
	@Transactional
	@Override
	public void scheduleStatus(int id, boolean auditStatus) {
		safetyHousekeepingDao.scheduleStatus(id,auditStatus);
	}

	/* (non-Javadoc)
	 * @see com.st.safetylog.service.SafetyHousekeepingService#actionsColosed(int)
	 */
	@Transactional
	@Override
	public boolean actionsColosed(int sid,int taskId) {
		return safetyHousekeepingDao.actionsColosed(sid,taskId);
	}
	
	
	/**
	 * Auto Scheduler
	 * 
	 */
	@Transactional
	@Scheduled(cron="${scheduled.time.housekeeping.weekly}")
	public void updateScheduled() {
		SimpleDateFormat dateFormat=new SimpleDateFormat("MM-dd-yyyy");
		
		Date date=new Date();
		
		Calendar scal=Calendar.getInstance();
		scal.setTime(date);
		scal.add(Calendar.DATE, -7);
		
		
		Date sdate=CommonUtil.checkDate(dateFormat.format(scal.getTime()), dateFormat);
		Date edate=CommonUtil.checkDate(dateFormat.format(date), dateFormat);
		
	
		List<SafetyHousekeepingSchedule> housekeepingSchedules=safetyHousekeepingDao.getSafetyHousekeepingSchedules(sdate, edate);
		for (SafetyHousekeepingSchedule safetyHousekeepingSchedule : housekeepingSchedules) {
			List<SafetyHousekeepingTask> tasks=safetyHousekeepingDao.getSafetyHousekeepingTasks(sdate, edate,safetyHousekeepingSchedule.getArea(),safetyHousekeepingSchedule.getAuditor());
			for (SafetyHousekeepingTask safetyHousekeepingTask : tasks) {
				if(StringUtils.isNotEmpty(safetyHousekeepingTask.getCompleted()) 
				|| safetyHousekeepingDao.taskExist(safetyHousekeepingTask.getId())){
					
					logger.info("Closing audit="+safetyHousekeepingSchedule.getId()+" SDATE="+sdate+" EDATE="+edate);
					safetyHousekeepingDao.scheduleStatus(safetyHousekeepingSchedule.getId(), true);
				}
			}
			
		}
		
		safetyHousekeepingDao.removeUnwantedTasks(sdate,edate);
		
	}

	/* (non-Javadoc)
	 * @see com.st.safetylog.service.SafetyHousekeepingService#deleteTask(int)
	 */
	@Transactional
	@Override
	public void deleteTask(int taskId) {
		safetyHousekeepingDao.deleteTask(taskId);
	}

	/* (non-Javadoc)
	 * @see com.st.safetylog.service.SafetyHousekeepingService#getSafetyHousekeepingOpen()
	 */
	@Transactional
	@Override
	public List<SafetyHousekeeping> getSafetyHousekeepingOpen(int area,
			int auditor, String bywhom) {
		return safetyHousekeepingDao.getSafetyHousekeepingOpen(area,auditor,bywhom);
	}

	/* (non-Javadoc)
	 * @see com.st.safetylog.service.SafetyHousekeepingService#getSafetyHousekeepingClosedItem(java.util.Date, java.util.Date)
	 */
	@Override
	public List<SafetyHousekeeping> getSafetyHousekeepingClosedItem(Date sdate,
			Date edate) {
		return safetyHousekeepingDao.getSafetyHousekeepingClosedItem(sdate,edate);
	}

	/* (non-Javadoc)
	 * @see com.st.safetylog.service.SafetyHousekeepingService#getSafetyHousekeepingAuditSchedulesStatus(java.util.Date, java.util.Date)
	 */
	@Transactional
	@Override
	public List<SafetyHousekeepingSchedule> getSafetyHousekeepingAuditSchedulesStatus(Date sdate, Date edate) {
		// TODO Auto-generated method stub
		return safetyHousekeepingDao.getSafetyHousekeepingAuditSchedulesStatus(sdate,edate);
	}

	/* (non-Javadoc)
	 * @see com.st.safetylog.service.SafetyHousekeepingService#getauditerDetails(int)
	 */
	@Transactional
	@Override
	public List<SafetyHousekeepingSchedule> getauditerDetails(int auditorId) {
		// TODO Auto-generated method stub
		return safetyHousekeepingDao.getauditerDetails(auditorId);
	}

	/* (non-Javadoc)
	 * @see com.st.safetylog.service.SafetyHousekeepingService#positiveStatus(java.util.Date, boolean, java.lang.String)
	 */
	@Override
	public void positiveStatus(Date date, boolean auditStatus, String auditorId) {
		
		safetyHousekeepingDao.positiveStatus(date,auditStatus,auditorId);
	}

	/* (non-Javadoc)
	 * @see com.st.safetylog.service.SafetyHousekeepingService#getpositiveStatus(java.util.Date, java.util.Date)
	 */
	@Override
	public List<PositiveObservation> getpositiveStatus(Date sdate, Date edate) {
		// TODO Auto-generated method stub
		return safetyHousekeepingDao.getpositiveStatus(sdate,edate);
	}
}

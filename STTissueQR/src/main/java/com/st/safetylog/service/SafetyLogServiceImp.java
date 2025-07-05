/**
 * 
 */
package com.st.safetylog.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.st.safetylog.dao.SafetyLogDao;
import com.st.safetylog.model.SafetyLog;

/**
 * @author sbora
 *
 */
@Service
public class SafetyLogServiceImp implements SafetyLogService {

	
	@Autowired
	private SafetyLogDao safetyLogDao;
	
	/* (non-Javadoc)
	 * @see com.st.safetylog.service.SafetyLogService#saveOrUpdate(com.st.safetylog.model.SafetyLog)
	 */
	@Transactional
	@Override
	public void saveOrUpdate(SafetyLog safetyLog) {
		safetyLogDao.saveOrUpdate(safetyLog);
	}

	/* (non-Javadoc)
	 * @see com.st.safetylog.service.SafetyLogService#getSafetyLogs(java.util.Date, java.util.Date)
	 */
	@Transactional
	@Override
	public List<SafetyLog> getSafetyLogs(Date sdate, Date edate) {
		// TODO Auto-generated method stub
		return safetyLogDao.getSafetyLogs(sdate,edate);
	}

	/* (non-Javadoc)
	 * @see com.st.safetylog.service.SafetyLogService#getSafetyLog(int)
	 */
	@Transactional
	@Override
	public SafetyLog getSafetyLog(int id) {
		// TODO Auto-generated method stub
		return safetyLogDao.getSafetyLog(id);
	}

	/* (non-Javadoc)
	 * @see com.st.safetylog.service.SafetyLogService#delete(int)
	 */
	@Transactional
	@Override
	public void delete(int id) {
		safetyLogDao.delete(id);
	}

	/* (non-Javadoc)
	 * @see com.st.safetylog.service.SafetyLogService#closeLog(int)
	 */
	@Transactional
	@Override
	public void closeLog(SafetyLog safetyLog) {
		safetyLogDao.close(safetyLog);
	}

	/* (non-Javadoc)
	 * @see com.st.safetylog.service.SafetyLogService#updateSafetyLogReview(int, java.util.Date)
	 */
	@Transactional
	@Override
	public void updateSafetyLogReview(int id, Date date) {
		safetyLogDao.updateSafetyLogReview(id,date);
	}

	/* (non-Javadoc)
	 * @see com.st.safetylog.service.SafetyLogService#resetLog(com.st.safetylog.model.SafetyLog)
	 */
	@Transactional
	@Override
	public void resetLog(SafetyLog safetyLog) {
		safetyLogDao.resetLog(safetyLog);
	}

}

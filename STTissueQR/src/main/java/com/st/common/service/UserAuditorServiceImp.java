/**
 * 
 */
package com.st.common.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.st.common.dao.UserAuditorDao;
import com.st.common.model.UserAuditor;

/**
 * @author sbora
 *
 */
@Service
public class UserAuditorServiceImp implements UserAuditorService {
	@Autowired
	private UserAuditorDao userAuditorDao;

	/* (non-Javadoc)
	 * @see com.st.common.service.UserAuditorService#getUserAutiors()
	 */
	@Transactional
	@Override
	public List<UserAuditor> getUserAutiors() {
		return userAuditorDao.getUserAutiors();
	}

	/* (non-Javadoc)
	 * @see com.st.common.service.UserAuditorService#saveOrUpdate(com.st.common.model.UserAuditor)
	 */
	@Transactional
	@Override
	public void saveOrUpdate(UserAuditor auditor) {
		userAuditorDao.saveOrUpdate(auditor);
	}

	/* (non-Javadoc)
	 * @see com.st.common.service.UserAuditorService#getUserAuditor()
	 */
	@Transactional
	@Override
	public UserAuditor getUserAuditor(int id) {
		return userAuditorDao.getUserAuditor(id);
	}

	/* (non-Javadoc)
	 * @see com.st.common.service.UserAuditorService#editAuditorStatus(com.st.common.model.UserAuditor)
	 */
	@Transactional
	@Override
	public void editAuditorStatus(UserAuditor data) {
		// TODO Auto-generated method stub
		 userAuditorDao.editAuditorStatus(data);
	}

	/* (non-Javadoc)
	 * @see com.st.common.service.UserAuditorService#getUserAutiorsActive()
	 */
	@Transactional
	@Override
	public List<UserAuditor> getUserAutiorsActive() {
		// TODO Auto-generated method stub
		return userAuditorDao.getUserAutiorsActive();
	}
}

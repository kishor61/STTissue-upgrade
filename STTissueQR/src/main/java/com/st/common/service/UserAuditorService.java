/**
 * 
 */
package com.st.common.service;

import java.util.List;

import com.st.common.model.UserAuditor;

/**
 * @author sbora
 *
 */
public interface UserAuditorService {

	/**
	 * @return
	 */
	List<UserAuditor> getUserAutiors();

	/**
	 * @param auditor
	 */
	void saveOrUpdate(UserAuditor auditor);

	/**
	 * @param id 
	 * @return
	 */
	UserAuditor getUserAuditor(int id);

	/**
	 * @param data
	 * @return
	 */
	void editAuditorStatus(UserAuditor data);

	/**
	 * @return
	 */
	List<UserAuditor> getUserAutiorsActive();

}

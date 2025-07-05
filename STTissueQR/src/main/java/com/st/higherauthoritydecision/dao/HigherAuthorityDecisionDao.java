/**
 *Dec 7, 2016
 *HigherAuthorityDecisionDao.java
 * TODO
 *com.st.higherauthoritydecision.dao
 *HigherAuthorityDecisionDao.java
 *Roshan Lal Tailor
 */
package com.st.higherauthoritydecision.dao;

import java.util.List;

import com.st.higherauthoritydecision.model.HigherAuthorityDecision;

/**
 * @author roshan
 *
 */
public interface HigherAuthorityDecisionDao {

	/**
	 * @return
	 */
	List<HigherAuthorityDecision> getdata();

	/**
	 * @param i
	 * @return
	 */
	List<HigherAuthorityDecision> getdata(int i);

	/**
	 * @param had
	 */
	void updateStatusForMails(HigherAuthorityDecision had);

}

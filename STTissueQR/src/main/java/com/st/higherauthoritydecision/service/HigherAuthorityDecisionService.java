/**
 *Dec 7, 2016
 *HigherAuthorityDecisionService.java
 * TODO
 *com.st.higherauthoritydecision.service
 *HigherAuthorityDecisionService.java
 *Roshan Lal Tailor
 */
package com.st.higherauthoritydecision.service;

import java.util.List;

import com.st.higherauthoritydecision.model.HigherAuthorityDecision;

/**
 * @author roshan
 *
 */
public interface HigherAuthorityDecisionService {

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

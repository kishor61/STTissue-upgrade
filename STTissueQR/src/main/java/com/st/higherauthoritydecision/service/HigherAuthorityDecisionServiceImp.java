/**
 *Dec 7, 2016
 *HigherAuthorityDecisionServiceImp.java
 * TODO
 *com.st.higherauthoritydecision.service
 *HigherAuthorityDecisionServiceImp.java
 *Roshan Lal Tailor
 */
package com.st.higherauthoritydecision.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.st.higherauthoritydecision.dao.HigherAuthorityDecisionDao;
import com.st.higherauthoritydecision.model.HigherAuthorityDecision;

/**
 * @author roshan
 *
 */
@Service
public class HigherAuthorityDecisionServiceImp implements HigherAuthorityDecisionService{

	
	@Autowired
	private HigherAuthorityDecisionDao higherauthoritydecisiondao;
	
	/* (non-Javadoc)
	 * @see com.st.higherauthoritydecision.service.HigherAuthorityDecisionService#getdata()
	 */
	@Transactional
	@Override
	public List<HigherAuthorityDecision> getdata() {
		// TODO Auto-generated method stub
		return higherauthoritydecisiondao.getdata();
	}

	/* (non-Javadoc)
	 * @see com.st.higherauthoritydecision.service.HigherAuthorityDecisionService#getdata(int)
	 */
	@Transactional
	@Override
	public List<HigherAuthorityDecision> getdata(int i) {
		// TODO Auto-generated method stub
		return higherauthoritydecisiondao.getdata(i);
	}

	/* (non-Javadoc)
	 * @see com.st.higherauthoritydecision.service.HigherAuthorityDecisionService#updateStatusForMails(com.st.higherauthoritydecision.model.HigherAuthorityDecision)
	 */
	@Transactional
	@Override
	public void updateStatusForMails(HigherAuthorityDecision had) {
		// TODO Auto-generated method stub
		higherauthoritydecisiondao.updateStatusForMails(had);
	}

}

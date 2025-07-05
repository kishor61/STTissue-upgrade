/**
 *Dec 15, 2015
 *FrpGoalsServiceImp.java
 * TODO
 *com.st.frpgoals.service
 *FrpGoalsServiceImp.java
 *Sunil Singh Bora
 */
package com.st.frpgoals.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.st.frpgoals.dao.FrpGoalsDao;
import com.st.frpgoals.model.FrpGoals;

/**
 * @author sbora
 *
 */
@Service
public class FrpGoalsServiceImp implements FrpGoalsService{

	
	@Autowired
	private FrpGoalsDao frpGoalsDao;
	
	/* (non-Javadoc)
	 * @see com.st.frpgoals.service.FrpGoalsService#saveOrUpdate(com.st.frpgoals.model.FrpGoals)
	 */
	@Transactional
	@Override
	public void saveOrUpdate(FrpGoals frpGoals) {
		frpGoalsDao.saveOrUpdate(frpGoals);
	}

	/* (non-Javadoc)
	 * @see com.st.frpgoals.service.FrpGoalsService#getOpenMonthData(int, int)
	 */
	@Transactional
	@Override
	public List<FrpGoals> getOpenMonthData(int month, int year) {
		// TODO Auto-generated method stub
		return frpGoalsDao.getOpenMonthData(month,year);
	}

	/* (non-Javadoc)
	 * @see com.st.frpgoals.service.FrpGoalsService#getFrpGoalsData(int, int)
	 */
	@Transactional
	@Override
	public List<FrpGoals> getFrpGoalsData(int month, int year) {
		// TODO Auto-generated method stub
		return frpGoalsDao.getFrpGoalsData(month,year);
	}

	/* (non-Javadoc)
	 * @see com.st.frpgoals.service.FrpGoalsService#getConsumedData(java.util.Date, java.util.Date)
	 */
	@Transactional
	@Override
	public List<FrpGoals> getConsumedData(Date currentMonthSDate,Date currentMonthLDate) {
		// TODO Auto-generated method stub
		return frpGoalsDao.getConsumedData(currentMonthSDate,currentMonthLDate);
	}

}

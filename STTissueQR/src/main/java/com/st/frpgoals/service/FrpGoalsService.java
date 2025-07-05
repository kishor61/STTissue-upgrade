/**
 *Dec 15, 2015
 *FrpGoalsService.java
 * TODO
 *com.st.frpgoals.service
 *FrpGoalsService.java
 *Sunil Singh Bora
 */
package com.st.frpgoals.service;

import java.util.Date;
import java.util.List;

import com.st.frpgoals.model.FrpGoals;

/**
 * @author sbora
 *
 */
public interface FrpGoalsService {

	/**
	 * @param frpGoals
	 */
	void saveOrUpdate(FrpGoals frpGoals);

	/**
	 * @param month
	 * @param year
	 * @return
	 */
	List<FrpGoals> getOpenMonthData(int month, int year);

	/**
	 * @param month
	 * @param year
	 * @return
	 */
	List<FrpGoals> getFrpGoalsData(int month, int year);

	/**
	 * @param currentMonthSDate
	 * @param currentMonthLDate
	 * @return
	 */
	List<FrpGoals> getConsumedData(Date currentMonthSDate,
			Date currentMonthLDate);

}

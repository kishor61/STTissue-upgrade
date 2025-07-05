/**
 *Feb 1, 2018
 *UtilityDataServicePM5.java
 * TODO
 *com.st.utilitykpimasterPM5.service
 *UtilityDataServicePM5.java
 *Roshan Lal Tailor
 */
package com.st.utilitykpimasterPM5.service;

import java.util.Date;
import java.util.List;

import com.st.utilitykpimaster.model.UtilityData;

/**
 * @author roshan
 *
 */
public interface UtilityDataServicePM5 {

	/**
	 * @return
	 */
	List<UtilityData> getUtilityDatasL31();

	/**
	 * @param id
	 * @return
	 */
	UtilityData getUtilityData(int id);

	/**
	 * @param utilityData
	 * @return
	 */
	int save(UtilityData utilityData);

	/**
	 * @param key
	 * @return
	 */
	UtilityData getPrevUtilityData(int key);

	/**
	 * @param utilityData
	 */
	void update(UtilityData utilityData);

	/**
	 * @param id
	 */
	void delete(int id);

	/**
	 * @param sDate
	 * @param eDate
	 * @return
	 */
	List<UtilityData> getPrevUtilityData(Date sDate, Date eDate);

}

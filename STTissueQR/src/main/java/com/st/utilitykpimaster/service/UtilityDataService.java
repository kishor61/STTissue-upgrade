/**
 * 
 */
package com.st.utilitykpimaster.service;

import java.util.Date;
import java.util.List;

import com.st.utilitykpimaster.model.UtilityData;

/**
 * @author sbora
 *
 */
public interface UtilityDataService {

	/**
	 * @param utilityData
	 * @return
	 */
	int save(UtilityData utilityData);

	/**
	 * @param utilityData
	 */
	void update(UtilityData utilityData);

	/**
	 * @param id
	 * @return
	 */
	UtilityData getPrevUtilityData(int id);

	/**
	 * @return
	 */
	List<UtilityData> getUtilityDatasL31();

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

	/**
	 * @param id
	 * @return
	 */
	UtilityData getUtilityData(int id);

}

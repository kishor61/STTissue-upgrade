/**
 * 
 */
package com.st.utilitykpimaster.dao;

import java.util.Date;
import java.util.List;

import com.st.utilitykpimaster.model.UtilityData;

/**
 * @author sbora
 *
 */
public interface UtilityDataDao {
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
	 * @param sdate
	 * @param edate
	 * @return
	 */
	List<UtilityData> getPrevUtilityData(Date sdate, Date edate);

	/**
	 * @param id
	 * @return
	 */
	UtilityData getUtilityData(int id);

}

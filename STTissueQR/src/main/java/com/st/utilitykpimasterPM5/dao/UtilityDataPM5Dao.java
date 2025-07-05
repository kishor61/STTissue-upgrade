/**
 *Mar 20, 2018
 *UtilityDataPM5Dao.java
 * TODO
 *com.st.utilitykpimasterPM5.dao
 *UtilityDataPM5Dao.java
 *Roshan Lal Tailor
 */
package com.st.utilitykpimasterPM5.dao;

import java.util.Date;
import java.util.List;

import com.st.utilitykpimaster.model.UtilityData;

/**
 * @author roshan
 *
 */
public interface UtilityDataPM5Dao {

	/**
	 * @param id
	 * @return
	 */
	UtilityData getPrevUtilityData(int id);

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
	 */
	void delete(int id);

	/**
	 * @return
	 */
	List<UtilityData> getUtilityDatasL31();

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

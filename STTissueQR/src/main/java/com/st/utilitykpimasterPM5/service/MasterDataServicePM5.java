/**
 *Feb 1, 2018
 *MasterDataServicePM5.java
 * TODO
 *com.st.utilitykpimasterPM5.controller
 *MasterDataServicePM5.java
 *Roshan Lal Tailor
 */
package com.st.utilitykpimasterPM5.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.st.common.exception.ProductionException;
import com.st.common.exception.TrackerException;
import com.st.utilitykpimaster.model.MasterData;
import com.st.utilitykpimaster.model.UtilityData;

/**
 * @author roshan
 *
 */
public interface MasterDataServicePM5 {

	/**
	 * @param masterData
	 * @return
	 */
	int save(MasterData masterData);

	/**
	 * @param masterData
	 */
	void update(MasterData masterData);

	/**
	 * @param id
	 */
	void delete(int id);

	/**
	 * @return
	 */
	List<MasterData> getMasterDatasL31();

	/**
	 * @param id
	 * @return
	 */
	MasterData getMasterData(int id);

	/**
	 * @param sDate
	 * @param eDate
	 * @return
	 */
	List<MasterData> getMasterDatas(Date sDate, Date eDate);
	
	
	List<Map<String, String>>  getReportData(Object data, String type) throws TrackerException, ProductionException;

	/**
	 * @param sdate
	 * @param edate
	 * @return
	 */
	List<MasterData> getMasterDatasBetweenDates(Date sdate, Date edate);

}

/**
 * 
 */
package com.st.utilitykpimaster.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.st.common.exception.ProductionException;
import com.st.common.exception.TrackerException;
import com.st.utilitykpimaster.model.MasterData;

/**
 * @author sbora
 *
 */
public interface MasterDataService {

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
	List<MasterData> getMasterDatasBetweenDate(Date sdate, Date edate);

}

/**
 *Feb 1, 2018
 *MasterDataDaoPM5.java
 * TODO
 *com.st.utilitykpimasterPM5.dao
 *MasterDataDaoPM5.java
 *Roshan Lal Tailor
 */
package com.st.utilitykpimasterPM5.dao;

import java.util.Date;
import java.util.List;

import com.st.utilitykpimaster.model.MasterData;

/**
 * @author roshan
 *
 */
public interface MasterDataDaoPM5 {

	/**
	 * @return
	 */
	List<MasterData> getMasterDatasL31();

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
	 * @param tempdate
	 * @param tempdate2
	 * @return
	 */
	List<MasterData> getMasterDatas(Date tempdate, Date tempdate2);

	/**
	 * @param id
	 * @return
	 */
	MasterData getMasterData(int id);

	/**
	 * @param sdate
	 * @param edate
	 * @return
	 */
	List<MasterData> getMasterDatasBetweenDates(Date sdate, Date edate);

}

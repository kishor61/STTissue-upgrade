/**
 * 
 */
package com.st.utilitykpimaster.dao;

import java.util.Date;
import java.util.List;

import com.st.utilitykpimaster.model.MasterData;

/**
 * @author sbora
 *
 */
public interface MasterDataDao {

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
	 * @param sdate
	 * @param edate
	 * @return
	 */
	List<MasterData> getMasterDatas(Date sdate, Date edate);

	/**
	 * @param sdate
	 * @param edate
	 * @return
	 */
	List<MasterData> getMasterDatasBetweenDate(Date sdate, Date edate);

}

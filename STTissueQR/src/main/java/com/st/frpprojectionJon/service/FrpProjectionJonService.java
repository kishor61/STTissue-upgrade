/**
 * 
 */
package com.st.frpprojectionJon.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.st.frpprojection.model.FrpProjection;
import com.st.frpprojection.model.FrpProjectionData;

/**
 * @author sbora
 *
 */
public interface FrpProjectionJonService {

	/**
	 * @param frpProjection
	 * @return
	 */
	int saveFormula(FrpProjection frpProjection);

	/**
	 * @param frpProjection
	 */
	void updateFormula(FrpProjection frpProjection);

	/**
	 * @param type 
	 * @return
	 */
	List<FrpProjection> getProjectionFormulae();

	/**
	 * @param id
	 * @return
	 */
	FrpProjection getProjectionFormula(int id);

	/**
	 * @param sdate
	 * @param edate
	 * @param type
	 * @param productIds 
	 * @param temp 
	 * @return
	 */
	FrpProjectionData getFrpProjectionData(Date sdate, Date edate,
			List<String> productIds, String temp);

	/**
	 * @param type
	 * @return
	 */
	List<FrpProjection> getProjectionFormulae(String type);

	
	/**
	 * @param grade
	 * @param type
	 * @return 
	 */
	Map<String, Object> getProjectionMixData(String grade, int type);

	/**
	 * @param id
	 */
	void delete(int id);

	/**
	 * @param sdate
	 * @param edate
	 * @param productIds
	 * @param temp
	 * @return
	 */
	FrpProjectionData getFiberPurchasingData(Date sdate, Date edate,
			List<String> productIds, String temp);

	
	List<Map<String, Object>> getProjectionReminder(Date date);
}

/**
 * 
 */
package com.st.frpprojection.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.st.frpprojection.model.FrpProjection;
import com.st.frpprojection.model.ProjectionReminder;

/**
 * @author sbora
 *
 */
public interface FrpProjectionDao {

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
	 * @param type
	 * @return
	 */
	List<Integer> getGradeIds();

	/**
	 * @param productIds
	 * @return
	 */
	List<FrpProjection> getProjectionFormula(List<String> productIds);

	/**
	 * @param type
	 * @return
	 */
	List<FrpProjection> getProjectionFormulae(String type);

	/**
	 * @param id
	 */
	void delete(int id);

	/**
	 * @param reminders
	 */
	void saveReminders(List<ProjectionReminder> reminders);

	/**
	 * @return
	 */
	List<Map<String, Object>> getProjectionReminder(Date date);

	

}

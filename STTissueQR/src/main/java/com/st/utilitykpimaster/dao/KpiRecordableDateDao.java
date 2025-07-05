/**
 * 
 */
package com.st.utilitykpimaster.dao;

import java.util.List;

import com.st.utilitykpimaster.model.KpiRecordableDate;

/**
 * @author sbora
 *
 */
public interface KpiRecordableDateDao {

	/**
	 * @param kpiRecordableDate
	 * @return
	 */
	int save(KpiRecordableDate kpiRecordableDate);

	/**
	 * @return
	 */
	List<KpiRecordableDate> getKpiRecordableDate();

	/**
	 * @param id
	 */
	void delete(int id);

	/**
	 * @return
	 */
	KpiRecordableDate getLastKpiRecordableDate();
	
}

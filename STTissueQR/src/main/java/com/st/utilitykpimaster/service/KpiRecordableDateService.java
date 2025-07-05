/**
 * 
 */
package com.st.utilitykpimaster.service;

import java.util.List;

import com.st.utilitykpimaster.model.KpiRecordableDate;

/**
 * @author sbora
 *
 */
public interface KpiRecordableDateService {

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

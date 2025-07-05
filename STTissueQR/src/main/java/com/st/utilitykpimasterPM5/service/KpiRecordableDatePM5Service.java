/**
 *Mar 21, 2018
 *KpiRecordableDatePM5Service.java
 * TODO
 *com.st.utilitykpimasterPM5.service
 *KpiRecordableDatePM5Service.java
 *Roshan Lal Tailor
 */
package com.st.utilitykpimasterPM5.service;

import java.util.List;

import com.st.utilitykpimaster.model.KpiRecordableDate;

/**
 * @author roshan
 *
 */
public interface KpiRecordableDatePM5Service {

	/**
	 * @return
	 */
	List<KpiRecordableDate> getKpiRecordableDate();

	/**
	 * @param kpiRecordableDate
	 * @return
	 */
	int save(KpiRecordableDate kpiRecordableDate);

	/**
	 * @param id
	 */
	void delete(int id);

	/**
	 * @return
	 */
	KpiRecordableDate getLastKpiRecordableDate();

}

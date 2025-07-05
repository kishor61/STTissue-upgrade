/**
 *Mar 21, 2018
 *KpiRecordableDatePM5Dao.java
 * TODO
 *com.st.utilitykpimasterPM5.dao
 *KpiRecordableDatePM5Dao.java
 *Roshan Lal Tailor
 */
package com.st.utilitykpimasterPM5.dao;

import java.util.List;

import com.st.utilitykpimaster.model.KpiRecordableDate;

/**
 * @author roshan
 *
 */
public interface KpiRecordableDatePM5Dao {

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

}

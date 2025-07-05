/**
 * 
 */
package com.st.efficiencypm5.service;

import java.util.Date;
import java.util.List;

import com.st.efficiency.model.Efficiency;
import com.st.efficiency.model.EfficiencyShiftData;
import com.st.efficiencypm5.model.EfficiencyPM5;
import com.st.efficiencypm5.model.EfficiencyShiftDataPM5;

/**
 * @author sbora
 *
 */
public interface EfficiencyServicePM5 {
	int add(EfficiencyPM5 efficency);
	void update(EfficiencyPM5 efficency);
	void delete(int id);
	EfficiencyPM5 getEfficiency(int id);
	List<EfficiencyPM5> getEfficiencies(EfficiencyPM5 efficiency);
	/**
	 * @param sdate
	 * @param edate
	 * @param shift
	 * @return
	 */
	List<EfficiencyShiftDataPM5> getEfficiencyShiftData(Date sdate, Date edate,
			String shift);
	/**
	 * @param checkDate
	 * @param checkDate2
	 * @return
	 */
	List<EfficiencyShiftDataPM5> getEfficiencyDCSDataReport(Date checkDate,
			Date checkDate2);
	/**
	 * @param eSD
	 * @return
	 */
	int saveDCSData(EfficiencyShiftDataPM5 eSD);
	/**
	 * @param sdate
	 * @param shift
	 * @return
	 */
	List<EfficiencyShiftDataPM5> checkTonPresentOrNot(Date sdate, String shift);
	/**
	 * @param id
	 * @return
	 */
	List<EfficiencyShiftDataPM5> editDCSReport(int id);
	/**
	 * @param eSD
	 */
	void updateDCSData(EfficiencyShiftDataPM5 eSD);
}

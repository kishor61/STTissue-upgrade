/**
 * 
 */
package com.st.efficiency.service;

import java.util.Date;
import java.util.List;

import com.st.efficiency.model.Efficiency;
import com.st.efficiency.model.EfficiencyShiftData;

/**
 * @author sbora
 *
 */
public interface EfficiencyService {
	int add(Efficiency efficency);
	void update(Efficiency efficency);
	void delete(int id);
	Efficiency getEfficiency(int id);
	List<Efficiency> getEfficiencies(Efficiency efficiency);
	/**
	 * @param sdate
	 * @param edate
	 * @param shift
	 * @return
	 */
	List<EfficiencyShiftData> getEfficiencyShiftData(Date sdate, Date edate,
			String shift);
	/**
	 * @param checkDate
	 * @param checkDate2
	 * @return
	 */
	List<EfficiencyShiftData> getEfficiencyDCSDataReport(Date checkDate,
			Date checkDate2);
	/**
	 * @param eSD
	 * @return
	 */
	int saveDCSData(EfficiencyShiftData eSD);
	/**
	 * @param sdate
	 * @param shift
	 * @return
	 */
	List<EfficiencyShiftData> checkTonPresentOrNot(Date sdate, String shift);
	/**
	 * @param id
	 * @return
	 */
	List<EfficiencyShiftData> editDCSReport(int id);
	/**
	 * @param eSD
	 */
	void updateDCSData(EfficiencyShiftData eSD);
}

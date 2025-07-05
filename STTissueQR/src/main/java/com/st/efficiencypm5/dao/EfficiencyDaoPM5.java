/**
 * 
 */
package com.st.efficiencypm5.dao;

import java.util.Date;
import java.util.List;
import com.st.efficiencypm5.model.EfficiencyPM5;
import com.st.efficiencypm5.model.EfficiencyShiftDataPM5;

/**
 * @author sbora
 *
 */
public interface EfficiencyDaoPM5 {
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
	 * @param sdate
	 * @param edate
	 * @return
	 */
	List<EfficiencyShiftDataPM5> getEfficiencyDCSDataReport(Date sdate,
			Date edate);
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
	/**
	 * @param format
	 * @param format2
	 * @return
	 */
	List<EfficiencyPM5> getEfficienciesUnControllableDownTimeMinutes(String sdate, String edate);
	
}

/**
 * 
 */
package com.st.efficiencypm5.service;

import java.util.Date;
import java.util.List;

import com.st.efficiencypm5.model.EfficiencyPM5;
import com.st.efficiencypm5.model.PrimaryCodePM5;
import com.st.efficiencypm5.model.SecondaryCodePM5;

/**
 * @author sbora
 *
 */
public interface EfficiencyCodeServicePM5 {
	PrimaryCodePM5 getPrimaryCode(int id);
	SecondaryCodePM5 getSecondaryCode(int id);
	
	List<PrimaryCodePM5> getPrimaryCodes();
	List<SecondaryCodePM5> getSecondaryCodes();
	List<SecondaryCodePM5> getSecondaryCodes(PrimaryCodePM5 code);
	
	int add(PrimaryCodePM5 code);
	int add(SecondaryCodePM5 code);
	
	void update(PrimaryCodePM5 code);
	void update(SecondaryCodePM5  code);
	
	void delete(PrimaryCodePM5 code);
	void delete(SecondaryCodePM5 code);
	/**
	 * @param sdate
	 * @param edate
	 * @param pcode
	 * @param scode
	 * @return
	 */
	List<EfficiencyPM5> getSummaryData(Date sdate, Date edate, int pcode, int scode);
}

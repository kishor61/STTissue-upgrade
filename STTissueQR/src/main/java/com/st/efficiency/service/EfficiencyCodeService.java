/**
 * 
 */
package com.st.efficiency.service;

import java.util.Date;
import java.util.List;

import com.st.efficiency.model.Efficiency;
import com.st.efficiency.model.PrimaryCode;
import com.st.efficiency.model.SecondaryCode;

/**
 * @author sbora
 *
 */
public interface EfficiencyCodeService {
	PrimaryCode getPrimaryCode(int id);
	SecondaryCode getSecondaryCode(int id);
	
	List<PrimaryCode> getPrimaryCodes();
	List<SecondaryCode> getSecondaryCodes();
	List<SecondaryCode> getSecondaryCodes(PrimaryCode code);
	
	int add(PrimaryCode code);
	int add(SecondaryCode code);
	
	void update(PrimaryCode code);
	void update(SecondaryCode  code);
	
	void delete(PrimaryCode code);
	void delete(SecondaryCode code);
	/**
	 * @param sdate
	 * @param edate
	 * @param pcode
	 * @param scode
	 * @return
	 */
	List<Efficiency> getSummaryData(Date sdate, Date edate, int pcode, int scode);
}

/**
 * 
 */
package com.st.frpefficiency.service;

import java.util.Date;
import java.util.List;

import com.st.frpefficiency.model.FrpEfficiency;
import com.st.frpefficiency.model.FrpPrimaryCode;
import com.st.frpefficiency.model.FrpSecondaryCode;

/**
 * @author sbora
 *
 */
public interface FrpEfficiencyCodeService {
	FrpPrimaryCode getPrimaryCode(int id);
	FrpSecondaryCode getSecondaryCode(int id);
	
	List<FrpPrimaryCode> getPrimaryCodes();
	List<FrpSecondaryCode> getSecondaryCodes();
	List<FrpSecondaryCode> getSecondaryCodes(FrpPrimaryCode code);
	
	int add(FrpPrimaryCode code);
	int add(FrpSecondaryCode code);
	
	void update(FrpPrimaryCode code);
	void update(FrpSecondaryCode  code);
	
	void delete(FrpPrimaryCode code);
	void delete(FrpSecondaryCode code);
	/**
	 * @param sdate
	 * @param edate
	 * @param pcode
	 * @param scode
	 * @return
	 */
	List<FrpEfficiency> getSummaryData(Date sdate, Date edate, int pcode,
			int scode);
}

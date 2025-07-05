/**
 * 
 */
package com.st.frpefficiency.service;

import java.util.List;

import com.st.frpefficiency.model.FrpEfficiency;

/**
 * @author sbora
 *
 */
public interface FrpEfficiencyService {
	int add(FrpEfficiency efficency);
	void update(FrpEfficiency efficency);
	void delete(int id);
	FrpEfficiency getEfficiency(int id);
	List<FrpEfficiency> getEfficiencies(FrpEfficiency efficiency);
}

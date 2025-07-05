/**
 * 
 */
package com.st.frpefficiency.dao;

import java.util.List;

import com.st.frpefficiency.model.FrpEfficiency;

/**
 * @author sbora
 *
 */
public interface FrpEfficiencyDao {
	int add(FrpEfficiency efficency);
	void update(FrpEfficiency efficency);
	void delete(int id);
	FrpEfficiency getEfficiency(int id);
	
	
	List<FrpEfficiency> getEfficiencies(FrpEfficiency efficiency);
	
}

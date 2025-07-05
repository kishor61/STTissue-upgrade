/**
 * 
 */
package com.st.frpproduction.dao;

import java.util.Date;
import java.util.List;

import com.st.frpproduction.model.FrpProdcution;

/**
 * @author sbora
 *
 */
public interface FrpProdcutionDao {
	/**
	 * @param frpProdcution
	 * @return
	 */
	int save(FrpProdcution frpProdcution);

	/**
	 * @param frpProdcution
	 */
	void update(FrpProdcution frpProdcution);
	
	List<FrpProdcution> getFrpProdcutions(Date sdate,Date edate,String prodType, String grade);
	FrpProdcution getFrpProdcution(int id);

	/**
	 * @param id
	 */
	void delete(int id);

	FrpProdcution getFrpProdcutionLast(Date date);
	
	
	FrpProdcution getMTDFrpProdcution(Date date,String prodType);
	
}

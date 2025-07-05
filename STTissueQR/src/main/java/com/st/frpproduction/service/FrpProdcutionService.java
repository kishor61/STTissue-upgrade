/**
 * 
 */
package com.st.frpproduction.service;

import java.util.Date;
import java.util.List;

import com.st.frpproduction.model.FrpProdcution;

/**
 * @author sbora
 *
 */

public interface FrpProdcutionService {

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

	/**
	 * @param date
	 * @return
	 */
	FrpProdcution getFrpProdcutionLast(Date date);



	FrpProdcution getMTDFrpProdcution(Date date,String prodType);
	
}

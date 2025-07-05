/**
 *May 23, 2016
 *MachineProductionSummaryService.java
 * TODO
 *com.st.production.service
 *MachineProductionSummaryService.java
 *Sunil Singh Bora
 */
package com.st.productionpm5.service;

import java.util.Date;
import java.util.List;

import com.st.common.exception.ProductionException;
import com.st.productionpm5.model.MachineAndWrapperPM5;
import com.st.productionpm5.model.MachineProductionPM5;

/**
 * @author sbora
 *
 */
public interface MachineProductionSummaryServicePM5 {

	/**
	 * @param checkDate
	 * @param checkDate2
	 * @return
	 * @throws ProductionException 
	 */
	List<MachineAndWrapperPM5> getMachineAndWrapperSummaryReport(Date checkDate,Date checkDate2) throws ProductionException;

	/**
	 * @param sdate
	 * @param edate
	 * @param shift
	 * @return
	 */
	List<MachineProductionPM5> getMachineBreakFreeProduction(Date sdate,
			Date edate, String shift);

}

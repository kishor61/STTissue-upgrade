/**
 *May 23, 2016
 *MachineProductionSummaryService.java
 * TODO
 *com.st.production.service
 *MachineProductionSummaryService.java
 *Sunil Singh Bora
 */
package com.st.production.service;

import java.util.Date;
import java.util.List;

import com.st.common.exception.ProductionException;
import com.st.production.model.MachineAndWrapper;
import com.st.production.model.MachineProduction;

/**
 * @author sbora
 *
 */
public interface MachineProductionSummaryService {

	/**
	 * @param checkDate
	 * @param checkDate2
	 * @return
	 * @throws ProductionException 
	 */
	List<MachineAndWrapper> getMachineAndWrapperSummaryReport(Date checkDate,Date checkDate2) throws ProductionException;

	/**
	 * @param sdate
	 * @param edate
	 * @param shift
	 * @return
	 */
	List<MachineProduction> getMachineBreakFreeProduction(Date sdate,
			Date edate, String shift);

}

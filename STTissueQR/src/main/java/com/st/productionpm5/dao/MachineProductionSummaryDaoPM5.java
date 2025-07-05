/**
 *May 23, 2016
 *MachineProductionSummaryDao.java
 * TODO
 *com.st.production.dao
 *MachineProductionSummaryDao.java
 *Sunil Singh Bora
 */
package com.st.productionpm5.dao;

import java.util.Date;
import java.util.List;

import com.st.common.exception.ProductionException;
import com.st.productionpm5.model.MachineAndWrapperPM5;
import com.st.productionpm5.model.MachineProductionPM5;

/**
 * @author sbora
 *
 */
public interface MachineProductionSummaryDaoPM5 {

	/**
	 * @param sdate
	 * @param edate
	 * @return
	 * @throws ProductionException 
	 */
	List<MachineAndWrapperPM5> getMachineAndWrapperSummaryReport(Date sdate,
			Date edate) throws ProductionException;

	/**
	 * @param sDate
	 * @param eDate
	 * @param shift
	 * @return
	 */
	List<MachineProductionPM5> getMachineBreakFreeProduction(Date sDate,
			Date eDate, String shift);

}

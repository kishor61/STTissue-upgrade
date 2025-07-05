/**
 *May 23, 2016
 *MachineProductionSummaryDao.java
 * TODO
 *com.st.production.dao
 *MachineProductionSummaryDao.java
 *Sunil Singh Bora
 */
package com.st.production.dao;

import java.util.Date;
import java.util.List;

import com.st.common.exception.ProductionException;
import com.st.production.model.MachineAndWrapper;
import com.st.production.model.MachineProduction;

/**
 * @author sbora
 *
 */
public interface MachineProductionSummaryDao {

	/**
	 * @param sdate
	 * @param edate
	 * @return
	 * @throws ProductionException 
	 */
	List<MachineAndWrapper> getMachineAndWrapperSummaryReport(Date sdate,
			Date edate) throws ProductionException;

	/**
	 * @param sDate
	 * @param eDate
	 * @param shift
	 * @return
	 */
	List<MachineProduction> getMachineBreakFreeProduction(Date sDate,
			Date eDate, String shift);

}

/**
 * 
 */
package com.st.production.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.st.common.exception.ProductionException;
import com.st.production.model.MachineAndWrapper;
import com.st.production.model.MachineProduction;
import com.st.production.model.WrapperProduction;


/**
 * @author sbora
 *
 */
public interface MachineProductionDao {


	
	List<MachineProduction> getMachineProductions(Date sdate, Date edate) throws ProductionException;

	/**
	 * @param time
	 * @param time2
	 * @return
	 * @throws ProductionException 
	 */
	List<MachineProduction> getMachineProductionsByMonth(Date time, Date time2) throws ProductionException;

	List<MachineProduction> getMachineProductions(Date sdate, Date edate,String shift) throws ProductionException;

	/**
	 * @param sdate
	 * @param edate
	 * @return
	 * @throws ProductionException 
	 */
	List<Map<String, Object>> getGradeAndHourData(Date sdate, Date edate) throws ProductionException;

	/**
	 * @param sdate
	 * @param edate
	 * @return
	 * @throws ProductionException 
	 */
	List<MachineAndWrapper> getMachineAndWrapper(Date sdate, Date edate) throws ProductionException;

	/**
	 * @param time
	 * @param time2
	 * @param shift
	 * @param i 
	 * @return
	 * @throws ProductionException 
	 */
	List<MachineProduction> getMachineProductionsForRollBreak(Date time,
			Date time2, String shift, int i) throws ProductionException;

	/**
	 * @param time
	 * @param time2
	 * @param shift
	 * @return
	 */
	List<MachineProduction> checkMachineProductionsForRollBreak(Date time,
			Date time2, String shift);
	
}

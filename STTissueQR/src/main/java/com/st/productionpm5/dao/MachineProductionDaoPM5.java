/**
 * 
 */
package com.st.productionpm5.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.st.common.exception.ProductionException;
import com.st.productionpm5.model.MachineAndWrapperPM5;
import com.st.productionpm5.model.MachineProductionPM5;


/**
 * @author sbora
 *
 */
public interface MachineProductionDaoPM5 {


	
	List<MachineProductionPM5> getMachineProductions(Date sdate, Date edate) throws ProductionException;

	/**
	 * @param time
	 * @param time2
	 * @return
	 * @throws ProductionException 
	 */
	List<MachineProductionPM5> getMachineProductionsByMonth(Date time, Date time2) throws ProductionException;

	List<MachineProductionPM5> getMachineProductions(Date sdate, Date edate,String shift) throws ProductionException;

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
	List<MachineAndWrapperPM5> getMachineAndWrapper(Date sdate, Date edate) throws ProductionException;

	/**
	 * @param time
	 * @param time2
	 * @param shift
	 * @param i 
	 * @return
	 * @throws ProductionException 
	 */
	List<MachineProductionPM5> getMachineProductionsForRollBreak(Date time,
			Date time2, String shift, int i) throws ProductionException;

	/**
	 * @param time
	 * @param time2
	 * @param shift
	 * @return
	 */
	List<MachineProductionPM5> checkMachineProductionsForRollBreak(Date time,
			Date time2, String shift);
	
}

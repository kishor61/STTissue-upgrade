/**
 * 
 */
package com.st.production.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.st.common.exception.ProductionException;
import com.st.production.model.WrapProductionRedCode;
import com.st.production.model.WrapperProduction;

/**
 * @author sbora
 *
 */
public interface WrapperProductionDao {

	/**
	 * @param sdate
	 * @param edate
	 * @return
	 * @throws ProductionException 
	 */
	List<WrapperProduction> getWrapperProductions(Date sdate, Date edate) throws ProductionException;

	double getTrageTons(List<String> gradeCodes) throws ProductionException;

	/**
	 * @param time
	 * @param time2
	 * @return
	 * @throws ProductionException 
	 */
	List<WrapperProduction> getWrapperProductionsByMonth(Date sdate, Date edate) throws ProductionException;


	List<WrapperProduction> getWrapperProductions(Date sdate, Date edate,
			String shift) throws ProductionException;

	/**
	 * @param time
	 * @param time2
	 * @return
	 * @throws ProductionException 
	 */
	List<WrapperProduction> getWrapperProductionRedCode(Date sdate, Date edate) throws ProductionException;

	/**
	 * @return
	 * @throws ProductionException 
	 */
	List<WrapProductionRedCode> getRedCodes() throws ProductionException;

	/**
	 * @return
	 */
	List<String> getCustomerFromWrapper();

	/**
	 * @param sdate
	 * @param customer
	 * @return
	 */
	List<WrapperProduction> getInventoryWrapperProductions(Date sdate,
			String customer);

	/**
	 * @param time
	 * @param time2
	 * @return
	 * @throws ProductionException 
	 */
	List<WrapperProduction> getWrapperProductionNoneRedCode(Date time,
			Date time2) throws ProductionException;

	/**
	 * @param time
	 * @param time2
	 * @return
	 * @throws ProductionException 
	 */
	List<Map<String, Object>> getGradeAndHoursData(Date time, Date time2) throws ProductionException;

	/**
	 * @param sdate
	 * @param edate
	 * @return
	 */
	List<WrapperProduction> getWrapperForDailyInventory(Date sdate, Date edate);

	/**
	 * @return
	 */
	Map<String, Object> isNewRedEntryExist();

	/**
	 * @param sdate
	 * @param edate
	 * @return
	 */
	List<WrapperProduction> getWrapperRedRejectProductionData(Date sdate, Date edate);

	/**
	 * @return
	 */
	WrapperProduction getWrapperTonsOfShift();

	/**
	 * @param sdate
	 * @param edate
	 * @return
	 */
	List<WrapperProduction> getWrapperAvgByGrade(Date sdate, Date edate);

	/**
	 * @param sdate
	 * @param edate
	 * @return
	 * @throws ProductionException 
	 */
	List<WrapperProduction> getWrapperDataByDate(Date sdate, Date edate) throws ProductionException;

	/**
	 * @param time
	 * @param time2
	 * @param shift
	 * @return
	 * @throws ProductionException 
	 */
	List<WrapperProduction> getWrapperProductionsForRollBreak(Date time,
			Date time2, String shift,int breakSize) throws ProductionException;

	/**
	 * @param time
	 * @param time2
	 * @param shift
	 * @return
	 * 
	 */
	List<WrapperProduction> checkBreaks(Date time, Date time2, String shift);

	/**
	 * @param sdate
	 * @param edate
	 * @return
	 */
	List<WrapperProduction> getWrapperRedRejectProductionData_PM5(Date sdate,
			Date edate);

	/**
	 * @return
	 */
	Map<String, Object> isNewRedEntryExist_PM5();
 
}

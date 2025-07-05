/**
 * 
 */
package com.st.productionpm5.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.st.common.exception.ProductionException;
import com.st.productionpm5.model.WrapProductionRedCodePM5;
import com.st.productionpm5.model.WrapperProductionPM5;

/**
 * @author sbora
 *
 */
public interface WrapperProductionDaoPM5 {

	/**
	 * @param sdate
	 * @param edate
	 * @return
	 * @throws ProductionException 
	 */
	List<WrapperProductionPM5> getWrapperProductions(Date sdate, Date edate) throws ProductionException;

	double getTrageTons(List<String> gradeCodes) throws ProductionException;

	/**
	 * @param time
	 * @param time2
	 * @return
	 * @throws ProductionException 
	 */
	List<WrapperProductionPM5> getWrapperProductionsByMonth(Date sdate, Date edate) throws ProductionException;


	List<WrapperProductionPM5> getWrapperProductions(Date sdate, Date edate,
			String shift) throws ProductionException;

	/**
	 * @param time
	 * @param time2
	 * @return
	 * @throws ProductionException 
	 */
	List<WrapperProductionPM5> getWrapperProductionRedCode(Date sdate, Date edate) throws ProductionException;

	/**
	 * @return
	 * @throws ProductionException 
	 */
	List<WrapProductionRedCodePM5> getRedCodes() throws ProductionException;

	/**
	 * @return
	 */
	List<String> getCustomerFromWrapper();

	/**
	 * @param sdate
	 * @param customer
	 * @return
	 */
	List<WrapperProductionPM5> getInventoryWrapperProductions(Date sdate,
			String customer);

	/**
	 * @param time
	 * @param time2
	 * @return
	 * @throws ProductionException 
	 */
	List<WrapperProductionPM5> getWrapperProductionNoneRedCode(Date time,
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
	List<WrapperProductionPM5> getWrapperForDailyInventory(Date sdate, Date edate);

	/**
	 * @return
	 */
	Map<String, Object> isNewRedEntryExist();

	/**
	 * @param sdate
	 * @param edate
	 * @return
	 */
	List<WrapperProductionPM5> getWrapperRedRejectProductionData(Date sdate, Date edate);

	/**
	 * @return
	 */
	WrapperProductionPM5 getWrapperTonsOfShift();

	/**
	 * @param sdate
	 * @param edate
	 * @return
	 */
	List<WrapperProductionPM5> getWrapperAvgByGrade(Date sdate, Date edate);

	/**
	 * @param sdate
	 * @param edate
	 * @return
	 * @throws ProductionException 
	 */
	List<WrapperProductionPM5> getWrapperDataByDate(Date sdate, Date edate) throws ProductionException;

	/**
	 * @param time
	 * @param time2
	 * @param shift
	 * @return
	 * @throws ProductionException 
	 */
	List<WrapperProductionPM5> getWrapperProductionsForRollBreak(Date time,
			Date time2, String shift,int breakSize) throws ProductionException;

	/**
	 * @param time
	 * @param time2
	 * @param shift
	 * @return
	 * 
	 */
	List<WrapperProductionPM5> checkBreaks(Date time, Date time2, String shift);

	/**
	 * @param sdate
	 * @param edate
	 * @return
	 */
	List<WrapperProductionPM5> getWrapperRedRejectProductionData_PM5(Date sdate,
			Date edate);

	/**
	 * @return
	 */
	Map<String, Object> isNewRedEntryExist_PM5();
 
}

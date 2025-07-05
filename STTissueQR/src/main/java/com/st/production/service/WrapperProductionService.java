/**
 * 
 */
package com.st.production.service;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.st.common.exception.ProductionException;
import com.st.production.model.WrapperProduction;

/**
 * @author sbora
 * 
 */
public interface WrapperProductionService {

	/**
	 * @param time
	 * @param time2
	 * @return
	 * @throws ProductionException 
	 */

	List<WrapperProduction> getWrapperProductions(Date sdate, Date edate) throws ProductionException;

	double getTrageTons(List<String> gradeCodes) throws ProductionException;
	
	
	
	List<Map<String, String>> formatDataForWrappedReport(Date sdate, Date edate) throws ProductionException;

	/**
	 * @param file
	 * @param datas
	 * @param sdate
	 * @param edate
	 * @return
	 * @throws IOException 
	 */
	HSSFWorkbook getFormatedWorkbookForDailyReport(File file,
			List<Map<String, String>> datas,List<Map<String, String>> historicalDatas, Date sdate, Date edate) throws IOException;

	/**
	 * @param sdate
	 * @return
	 * @throws ProductionException 
	 */
	List<Map<String, String>> formatHistoricalDataForWrappedReport(Date date) throws ProductionException;

	/**
	 * @param sdate
	 * @param edate
	 * @return 
	 * @throws ProductionException 
	 */
	Map<String, Object> getWrapperDataByRedCode(Date sdate, Date edate) throws ProductionException;

	/**
	 * @param file
	 * @param data
	 * @param sdate
	 * @param edate
	 * @return
	 * @throws IOException 
	 */
	HSSFWorkbook getFormatedWorkbookForWrapperRedCode(File file,
			Map<String, Object> data, Date sdate, Date edate) throws IOException;

	/**
	 * @return
	 */
	List<String> getCustomerFromWrapper();

	/**
	 * @param checkDate
	 * @param checkDate2
	 * @param customer
	 * @return
	 */
	List<WrapperProduction> getInventoryWrapperProductions(Date date,
			String customer);

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
	 */
	List<WrapperProduction> getWrapperForDailyInventory(Date sdate, Date edate);

	/**
	 * @return
	 */
	Map<String, Object> isNewRedEntryExist();

	/**
	 * @param time
	 * @param date
	 * @return
	 */
	List<WrapperProduction> getWrapperRedRejectProductionData(Date sdate, Date edate);

	/**
	 * @return
	 */
	WrapperProduction getWrapperTonsOfShift();

	/**
	 * @param checkDate
	 * @param checkDate2
	 * @return
	 */
	List<WrapperProduction> getWrapperAvgByGrade(Date sdate, Date edate);

	/**
	 * @param checkDate
	 * @param checkDate2
	 * @return
	 * @throws ProductionException 
	 */
	List<WrapperProduction> getWrapperDataByDate(Date checkDate, Date checkDate2) throws ProductionException;

	/**
	 * @param time
	 * @param date
	 * @return
	 */
	List<WrapperProduction> getWrapperRedRejectProductionData_PM5(Date time,
			Date date);

	/**
	 * @return
	 */
	Map<String, Object> isNewRedEntryExist_PM5();

	/**
	 * @return
	 */
	
}

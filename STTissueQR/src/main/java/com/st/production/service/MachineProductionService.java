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
import com.st.production.model.MachineAndWrapper;
import com.st.production.model.MachineProduction;

/**
 * @author sbora
 * 
 */
public interface MachineProductionService {

	List<MachineProduction> getMachineProductions(Date sdate, Date edate) throws ProductionException;

	
	
	
	//Other function
	HSSFWorkbook getFormatedWorkbookForDailyReport(File file,
			List<Map<String, String>> datas, Date sdate, Date edate)
			throws IOException;
	
	List<Map<String, String>> formatDataForDailyReport(Date sdate, Date edate) throws ProductionException;




	/**
	 * @param date
	 * @param date2
	 * @return
	 * @throws ProductionException 
	 */
	Map<String, Object> formatDataForSumaryReport(Date sdate, Date edate,String shift) throws ProductionException;




	/**
	 * @param date
	 * @return
	 * @throws IOException 
	 */
	HSSFWorkbook getFormatedWorkbookForSummaryReport(File file,Map<String, Object> datas,Date date) throws IOException;




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
	 * @param sdate
	 * @param edate
	 * @return
	 * @throws ProductionException 
	 */
	List<Map<String, String>> formatDataForDailyReportNonControlableHours(
			Date sdate, Date edate) throws ProductionException;




	/**`
	 * @param file
	 * @param datas
	 * @param sdate
	 * @param edate
	 * @return
	 * @throws IOException 
	 */
	HSSFWorkbook getFormatedWorkbookForDailyReportNonControlableHours(
			File file, List<Map<String, String>> datas, Date sdate, Date edate) throws IOException;
}

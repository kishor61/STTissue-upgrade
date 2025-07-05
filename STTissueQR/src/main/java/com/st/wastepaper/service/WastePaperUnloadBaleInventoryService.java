/**
 *Jul 18, 2015
 *WastePaperUnloadBaleInventoryService.java
 * TODO
 *com.st.wastepaperconsumedbale.service
 *WastePaperUnloadBaleInventoryService.java
 *Sunil Singh Bora
 */
package com.st.wastepaper.service;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import com.st.wastepaper.model.BarcodeComman;
import com.st.wastepaper.model.WastePaperBaleInventory;

/**
 * @author roshan
 *
 */
public interface WastePaperUnloadBaleInventoryService  {

	/**
	 * @param startdate
	 * @param enddate
	 * @return
	 * @throws Exception 
	 */
	List<WastePaperBaleInventory> getConsumedData(Date startdate, Date enddate) throws Exception;

	/**
	 * @param month
	 * @param year
	 * @return
	 * @throws ParseException 
	 */
	List<BarcodeComman> getOpenMonth(int month,
			int year) throws ParseException;

	/**
	 * @param month
	 * @param year
	 * @return
	 */
	List<BarcodeComman> getOpenMonthAvailable(int month, int year);

	/**
	 * @param yesterdayDate
	 * @param yesterdayDate2
	 * @param string
	 * @param string2
	 * @return
	 */
	List<WastePaperBaleInventory> getConsumedDayData(Date yesterdayDate, Date yesterdayDate2, String string,
			String string2);

	/**
	 * @param yesterdayDate
	 * @param yesterdayDate2
	 * @return
	 */
	List<String> getPulpLine(Date yesterdayDate, Date yesterdayDate2);

}

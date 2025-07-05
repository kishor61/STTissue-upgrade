/**
 *Jul 8, 2015
 *WastePaperUnloadBaleDao.java
 * TODO
 *com.st.wastepaperunloadbale.dao
 *WastePaperUnloadBaleDao.java
 *Sunil Singh Bora
 */
package com.st.wastepaper.dao;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.lowagie.text.pdf.Barcode;
import com.st.wastepaper.model.BarcodeComman;
import com.st.wastepaper.model.WastePaperBaleInventory;
import com.st.wastepaper.model.WastepaperDetail;

/**
 * @author roshan
 *
 */
public interface WastePaperUnloadBaleDao {

	/**
	 * @param startdate
	 * @param enddate
	 * @return
	 * @throws IOException 
	 * @throws Exception 
	 */
	List<WastePaperBaleInventory> getUnloadBales(Date startdate, Date enddate) throws Exception;

	/**
	 * @return
	 */
	List<WastePaperBaleInventory> getGrade();

	/**
	 * @param date
	 * @return
	 */
	List<com.st.wastepaper.model.BarcodeComman> getClosedMonth(Date date);

	/**
	 * @param barcodeComman
	 * @return
	 */
	int save(BarcodeComman barcodeComman);

	/**
	 * @param month
	 * @param year
	 * @return
	 */
	List<BarcodeComman> getClosedMonth(int month, int year);

	/**
	 * @param barcodeComman
	 */
	void update(BarcodeComman barcodeComman);

	/**
	 * @return
	 */
	List<WastePaperBaleInventory> getFRPLocationData();

	/**
	 * @param releaseNumber
	 * @return
	 */
	List<WastepaperDetail> getReceivingReport(int releaseNumber);

	/**
	 * @param releaseNumber
	 * @return
	 */
	List<WastepaperDetail> getRejectBales(int releaseNumber);

	/**
	 * @param custname
	 * @param sdate
	 * @param edate
	 * @return
	 */
	Map<String, String> getDailyInventeryReport(String custname, Date sdate, Date edate);

}

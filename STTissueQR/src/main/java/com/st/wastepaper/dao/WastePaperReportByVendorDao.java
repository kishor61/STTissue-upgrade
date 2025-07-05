/**
 *Aug 7, 2015
 *WastePaperReportByVendorDao.java
 * TODO
 *com.st.wastepaper.dao
 *WastePaperReportByVendorDao.java
 *Sunil Singh Bora
 */
package com.st.wastepaper.dao;

import java.util.Date;
import java.util.List;

import com.st.wastepaper.model.ByVendor;
import com.st.wastepaper.model.WastepaperDetail;

/**
 * @author roshan
 *
 */
public interface WastePaperReportByVendorDao {

	/**
	 * @return 
	 * 
	 */
	List<ByVendor> vendor();

	/**
	 * @param sDate
	 * @param eDate
	 * @param vendorname
	 * @return
	 */
	List<WastepaperDetail> loadVendorData(Date sDate, Date eDate, String vendorname);

}

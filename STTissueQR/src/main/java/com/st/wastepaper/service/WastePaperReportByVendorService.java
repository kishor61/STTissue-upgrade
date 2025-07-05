/**
 *Aug 7, 2015
 *WastePaperReportByVendorService.java
 * TODO
 *com.st.wastepaper.service
 *WastePaperReportByVendorService.java
 *Sunil Singh Bora
 */
package com.st.wastepaper.service;

import java.util.Date;
import java.util.List;

import com.st.wastepaper.model.ByVendor;
import com.st.wastepaper.model.WastepaperDetail;

/**
 * @author roshan
 *
 */
public interface WastePaperReportByVendorService {

	/**
	 * @return
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

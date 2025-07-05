/**
 *Aug 14, 2015
 *WastePaperReportByVendorAndGradeService.java
 * TODO
 *com.st.wastepaper.service
 *WastePaperReportByVendorAndGradeService.java
 *Sunil Singh Bora
 */
package com.st.wastepaper.service;

import java.util.Date;
import java.util.List;

import com.st.wastepaper.model.WastepaperDetail;

/**
 * @author roshan
 *
 */
public interface WastePaperReportByVendorAndGradeService {

	/**
	 * @param sDate
	 * @param eDate
	 * @param gradeid
	 * @param vendor
	 * @return
	 */
	List<WastepaperDetail> load(Date sDate, Date eDate, int gradeid,
			String vendor);

}

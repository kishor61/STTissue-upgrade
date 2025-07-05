/**
 *Aug 14, 2015
 *WastePaperReportByVendorAndGradeDao.java
 * TODO
 *com.st.wastepaper.dao
 *WastePaperReportByVendorAndGradeDao.java
 *Sunil Singh Bora
 */
package com.st.wastepaper.dao;

import java.util.Date;
import java.util.List;

import com.st.wastepaper.model.WastepaperDetail;

/**
 * @author roshan
 *
 */
public interface WastePaperReportByVendorAndGradeDao {

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

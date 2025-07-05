/**
 *Aug 12, 2015
 *WastePaperReportByGradeService.java
 * TODO
 *com.st.wastepaper.service
 *WastePaperReportByGradeService.java
 *Sunil Singh Bora
 */
package com.st.wastepaper.service;

import java.util.Date;
import java.util.List;

import com.st.wastepaper.model.ByGrade;
import com.st.wastepaper.model.ByVendor;
import com.st.wastepaper.model.WastepaperDetail;

/**
 * @author roshan
 *
 */
public interface WastePaperReportByGradeService {


	/**
	 * @return
	 */
	List<ByGrade> grade();

	/**
	 * @param sDate
	 * @param eDate
	 * @param gradeid
	 * @return
	 */
	List<WastepaperDetail> load(Date sDate, Date eDate, int gradeid);

}

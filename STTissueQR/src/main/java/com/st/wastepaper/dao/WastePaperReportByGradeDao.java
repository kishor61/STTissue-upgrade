/**
 *Aug 13, 2015
 *WastePaperReportByGradeDao.java
 * TODO
 *com.st.wastepaper.dao
 *WastePaperReportByGradeDao.java
 *Sunil Singh Bora
 */
package com.st.wastepaper.dao;

import java.util.Date;
import java.util.List;

import com.st.wastepaper.model.ByGrade;
import com.st.wastepaper.model.WastepaperDetail;

/**
 * @author roshan
 *
 */
public interface WastePaperReportByGradeDao {

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
	List<WastepaperDetail> loadgradedata(Date sDate, Date eDate, int gradeid);

}

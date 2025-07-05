/**
 *Oct 9, 2015
 *WastePaperUnloadByShiftDao.java
 * TODO
 *com.st.wastepaper.dao
 *WastePaperUnloadByShiftDao.java
 *Sunil Singh Bora
 */
package com.st.wastepaper.dao;

import java.util.Date;
import java.util.List;

import com.st.wastepaper.model.WastePaperUnloadByShift;

/**
 * @author roshan
 *
 */
public interface WastePaperUnloadByShiftDao {

	/**
	 * @param startdate
	 * @param enddate
	 * @return
	 */
	List<WastePaperUnloadByShift> getUnloadByShift(Date startdate, Date enddate);

}

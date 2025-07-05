/**
 *Oct 9, 2015
 *WastePaperUnloadByShiftService.java
 * TODO
 *com.st.wastepaper.service
 *WastePaperUnloadByShiftService.java
 */
package com.st.wastepaper.service;

import java.util.Date;
import java.util.List;

import com.st.wastepaper.model.WastePaperUnloadByShift;

/**
 * @author roshan
 *
 */
public interface WastePaperUnloadByShiftService {

	/**
	 * @param startdate
	 * @param enddate
	 * @return
	 */
	List<WastePaperUnloadByShift> getUnloadByShift(Date startdate, Date enddate);

}

/**
 *Oct 9, 2015
 *WastePaperUnloadByShiftServiceImp.java
 * TODO
 *com.st.wastepaper.service
 *WastePaperUnloadByShiftServiceImp.java
 *Sunil Singh Bora
 */
package com.st.wastepaper.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.st.wastepaper.dao.WastePaperConsumedBaleDao;
import com.st.wastepaper.dao.WastePaperUnloadByShiftDao;
import com.st.wastepaper.model.WastePaperUnloadByShift;

/**
 * @author roshan
 *
 */
@Service
public class WastePaperUnloadByShiftServiceImp implements WastePaperUnloadByShiftService{

	@Autowired
	private WastePaperUnloadByShiftDao wastepaperunloadbyshiftdao; 
	/* (non-Javadoc)
	 * @see com.st.wastepaper.service.WastePaperUnloadByShiftService#getUnloadByShift(java.util.Date, java.util.Date)
	 */
	@Transactional
	@Override
	public List<WastePaperUnloadByShift> getUnloadByShift(Date startdate,Date enddate) {
		return wastepaperunloadbyshiftdao.getUnloadByShift(startdate,enddate);
	}

}

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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.st.wastepaper.dao.WastePaperReportByVendorAndGradeDao;
import com.st.wastepaper.model.WastepaperDetail;

/**
 * @author roshan
 *
 */
@Service
public class WastePaperReportByVendorAndGradeServiceImp implements WastePaperReportByVendorAndGradeService{

	@Autowired
	private WastePaperReportByVendorAndGradeDao wastepaperreportbyvendorandgradedao; 
	/* (non-Javadoc)
	 * @see com.st.wastepaper.service.WastePaperReportByVendorAndGradeService#load(java.util.Date, java.util.Date, int, java.lang.String)
	 */
	@Override
	@Transactional
	public List<WastepaperDetail> load(Date sDate, Date eDate, int gradeid,
			String vendor) {
		return wastepaperreportbyvendorandgradedao.load(sDate,eDate,gradeid,vendor);
	}

}

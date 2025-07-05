/**
 *Aug 12, 2015
 *WastePaperReportByGradeServiceImp.java
 * TODO
 *com.st.wastepaper.service
 *WastePaperReportByGradeServiceImp.java
 *Sunil Singh Bora
 */
package com.st.wastepaper.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.st.wastepaper.dao.WastePaperReportByGradeDao;
import com.st.wastepaper.dao.WastePaperReportByVendorDao;
import com.st.wastepaper.model.ByGrade;
import com.st.wastepaper.model.ByVendor;
import com.st.wastepaper.model.WastepaperDetail;

/**
 * @author roshan
 *
 */
@Service
public class WastePaperReportByGradeServiceImp implements WastePaperReportByGradeService {

	@Autowired
	private WastePaperReportByGradeDao wastepaperreportbygradedao;  
	/* (non-Javadoc)
	 * @see com.st.wastepaper.service.WastePaperReportByGradeService#grade()
	 */
	@Transactional
	@Override
	public List<ByGrade> grade() {
		// TODO Auto-generated method stub
		return wastepaperreportbygradedao.grade();
	}
	/* (non-Javadoc)
	 * @see com.st.wastepaper.service.WastePaperReportByGradeService#load(java.util.Date, java.util.Date, int)
	 */
	@Transactional
	@Override
	public List<WastepaperDetail> load(Date sDate, Date eDate, int gradeid) {
		// TODO Auto-generated method stub
		return wastepaperreportbygradedao.loadgradedata(sDate,eDate,gradeid);
	}

	

}

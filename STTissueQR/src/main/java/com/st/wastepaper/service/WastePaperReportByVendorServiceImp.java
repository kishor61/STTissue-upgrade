/**
 *Aug 7, 2015
 *WastePaperReportByVendorServiceImp.java
 * TODO
 *com.st.wastepaper.service
 *WastePaperReportByVendorServiceImp.java
 *Sunil Singh Bora
 */
package com.st.wastepaper.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.st.wastepaper.dao.WastePaperReportByVendorDao;
import com.st.wastepaper.dao.WastePaperUnloadBaleDao;
import com.st.wastepaper.model.ByVendor;
import com.st.wastepaper.model.WastepaperDetail;

/**
 * @author roshan
 *
 */
@Service
public class WastePaperReportByVendorServiceImp implements WastePaperReportByVendorService {

	@Autowired
	private WastePaperReportByVendorDao wastepaperreportbyvendordao;
	/* (non-Javadoc)
	 * @see com.st.wastepaper.service.WastePaperReportByVendorService#vendor()
	 */
	@Override
	@Transactional
	public List<ByVendor> vendor() {
		// TODO Auto-generated method stub
		return wastepaperreportbyvendordao.vendor();
		
	}
	/* (non-Javadoc)
	 * @see com.st.wastepaper.service.WastePaperReportByVendorService#loadVendorData(java.util.Date, java.util.Date, java.lang.String)
	 */
	@Override
	@Transactional
	public List<WastepaperDetail> loadVendorData(Date sDate, Date eDate,
			String vendorname) {
		// TODO Auto-generated method stub
		return wastepaperreportbyvendordao.loadVendorData(sDate,eDate,vendorname);
	}

}

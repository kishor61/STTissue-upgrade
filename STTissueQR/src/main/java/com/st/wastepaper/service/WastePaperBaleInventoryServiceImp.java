/**
 *Jul 8, 2015
 *WastePaperBaleInventoryServiceImp.java
 * TODO
 *com.st.wastepaperunloadbale.service
 *WastePaperBaleInventoryServiceImp.java
 *Sunil Singh Bora
 */
package com.st.wastepaper.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.st.wastepaper.dao.WastePaperUnloadBaleDao;
import com.st.wastepaper.model.BarcodeComman;
import com.st.wastepaper.model.WastePaperBaleInventory;
import com.st.wastepaper.model.WastepaperDetail;

/**
 * @author roshan
 *
 */
@Service
public class WastePaperBaleInventoryServiceImp implements WastePaperBaleInventoryService {

	@Autowired
	private WastePaperUnloadBaleDao wastepaperunloadbaleDao;
	/* (non-Javadoc)
	 * @see com.st.wastepaperunloadbale.service.WastePaperBaleInventoryService#getUnloadBales(java.util.Date, java.util.Date)
	 */
	@Transactional
	@Override
	public List<WastePaperBaleInventory> getUnloadBales(Date startdate,Date enddate) throws Exception {
		// TODO Auto-generated method stub
		return wastepaperunloadbaleDao.getUnloadBales(startdate,enddate);
	}
	/* (non-Javadoc)
	 * @see com.st.wastepaperunloadbale.service.WastePaperBaleInventoryService#getGrade()
	 */
	@Transactional
	@Override
	public List<WastePaperBaleInventory> getGrade() {
		// TODO Auto-generated method stub
		return wastepaperunloadbaleDao.getGrade();
	}
	@Transactional
	@Override
	public List<BarcodeComman> getClosedMonth(Date date)throws Exception {
		// TODO Auto-generated method stub
		return wastepaperunloadbaleDao.getClosedMonth(date);
	}
	/* (non-Javadoc)
	 * @see com.st.wastepaperunloadbale.service.WastePaperBaleInventoryService#save(com.st.wastepaperunloadbale.model.BarcodeComman)
	 */
	@Transactional
	@Override
	public int save(BarcodeComman barcodeComman) {
		// TODO Auto-generated method stub
		return wastepaperunloadbaleDao.save(barcodeComman);
	}
	/* (non-Javadoc)
	 * @see com.st.wastepaperunloadbale.service.WastePaperBaleInventoryService#getClosedMonth(int, int)
	 */
	@Transactional
	@Override
	public List<BarcodeComman> getClosedMonth(int month, int year) {
		// TODO Auto-generated method stub
		return wastepaperunloadbaleDao.getClosedMonth(month,year);
	}
	/* (non-Javadoc)
	 * @see com.st.wastepaperunloadbale.service.WastePaperBaleInventoryService#update(com.st.wastepaperunloadbale.model.BarcodeComman)
	 */
	@Transactional
	@Override
	public void update(BarcodeComman barcodeComman) {
		// TODO Auto-generated method stub
		//frpYieldDao.update(frpYield);
		wastepaperunloadbaleDao.update(barcodeComman);
	}
	/* (non-Javadoc)
	 * @see com.st.wastepaper.service.WastePaperBaleInventoryService#getFRPLocationData()
	 */
	@Transactional
	@Override
	public List<WastePaperBaleInventory> getFRPLocationData() {
		// TODO Auto-generated method stub
		return wastepaperunloadbaleDao.getFRPLocationData();
	}
	/* (non-Javadoc)
	 * @see com.st.wastepaper.service.WastePaperBaleInventoryService#getReceivingReport(int)
	 */
	@Transactional
	@Override
	public List<WastepaperDetail> getReceivingReport(int releaseNumber) {
		// TODO Auto-generated method stub
		return wastepaperunloadbaleDao.getReceivingReport(releaseNumber);
	}
	/* (non-Javadoc)
	 * @see com.st.wastepaper.service.WastePaperBaleInventoryService#getRejectBales(int)
	 */
	@Transactional
	@Override
	public List<WastepaperDetail> getRejectBales(int releaseNumber) {
		// TODO Auto-generated method stub
		return wastepaperunloadbaleDao.getRejectBales(releaseNumber);
	}
	/* (non-Javadoc)
	 * @see com.st.wastepaper.service.WastePaperBaleInventoryService#getDailyInventeryReport(java.lang.String, java.util.Date)
	 */
	@Override
	public Map<String, String> getDailyInventeryReport(String custname, Date sdate,Date edate) {
		
		return wastepaperunloadbaleDao.getDailyInventeryReport(custname,sdate,edate);
	}
	
}

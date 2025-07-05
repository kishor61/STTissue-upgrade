/**
 *Jul 18, 2015
 *WastePaperUnloadBaleInventoryServiceImp.java
 * TODO
 *com.st.wastepaperconsumedbale.service
 *WastePaperUnloadBaleInventoryServiceImp.java
 *Sunil Singh Bora
 */
package com.st.wastepaper.service;

import java.lang.annotation.Target;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.st.wastepaper.dao.WastePaperConsumedBaleDao;
import com.st.wastepaper.model.BarcodeComman;
import com.st.wastepaper.model.WastePaperBaleInventory;

/**
 * @author roshan
 *
 */
@Service
public class WastePaperUnloadBaleInventoryServiceImp implements WastePaperUnloadBaleInventoryService {


	@Autowired
	private WastePaperConsumedBaleDao wastePaperConsumedBaleDao;
	/* (non-Javadoc)
	 * @see com.st.wastepaperconsumedbale.service.WastePaperUnloadBaleInventoryService#getConsumedData(java.util.Date, java.util.Date)
	 */
	@Transactional
	@Override
	public List<WastePaperBaleInventory> getConsumedData(Date startdate,Date enddate) throws Exception {
		// TODO Auto-generated method stub
		return wastePaperConsumedBaleDao.getConsumedData(startdate,enddate);
	}
	/* (non-Javadoc)
	 * @see com.st.wastepaperunloadbale.service.WastePaperUnloadBaleInventoryService#getOpenMonth(java.util.Date, java.util.Date)
	 */
	@Transactional
	@Override
	public List<BarcodeComman> getOpenMonth(int month, int year) throws ParseException {
		// TODO Auto-generated method stub
		return wastePaperConsumedBaleDao.getOpenMonth(month,year);
	}
	/* (non-Javadoc)
	 * @see com.st.wastepaperunloadbale.service.WastePaperUnloadBaleInventoryService#getOpenMonthAvailable(int, int)
	 */
	@Override
	public List<BarcodeComman> getOpenMonthAvailable(int month, int year) {
		// TODO Auto-generated method stub
		return wastePaperConsumedBaleDao.getOpenMonthAvailable(month,year);
	}
	@Override
	public List<WastePaperBaleInventory> getConsumedDayData(Date yesterdayDate, Date yesterdayDate2, String string,
			String string2) {
		// TODO Auto-generated method stub
		return wastePaperConsumedBaleDao.getConsumedDayData(yesterdayDate,yesterdayDate2,string,string2);
	}
	/* (non-Javadoc)
	 * @see com.st.wastepaper.service.WastePaperUnloadBaleInventoryService#getPulpLine(java.util.Date, java.util.Date)
	 */
	@Override
	public List<String> getPulpLine(Date yesterdayDate, Date yesterdayDate2) {
		
		return wastePaperConsumedBaleDao.getPulpLine(yesterdayDate, yesterdayDate2);
	}
}

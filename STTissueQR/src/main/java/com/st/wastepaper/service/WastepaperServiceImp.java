/**
 *Feb 17, 2015
 *WastepaperServiceImp.java
 * TODO
 *com.st.wastepaper.service
 *WastepaperServiceImp.java
 *Sunil Singh Bora
 */
package com.st.wastepaper.service;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.st.wastepaper.dao.WastepaperDao;
import com.st.wastepaper.model.WastepaperDetail;

/**
 * @author roshan
 *
 */
@Service
public class WastepaperServiceImp implements WastepaperService {

	@Autowired
	private WastepaperDao wastepaperDao;
	
	/* (non-Javadoc)
	 * @see com.st.wastepaper.service.WastepaperService#getWastepaperDetailData(java.util.Date, java.util.Date)
	 */
	@Transactional
	@Override
	public List<WastepaperDetail> getWastepaperDetailData(Date sdate, Date edate) {
		return wastepaperDao.getWastepaperDetailData(sdate,edate);
	}

	/* (non-Javadoc)
	 * @see com.st.wastepaper.service.WastepaperService#getTransferToMaster(java.util.Date, java.util.Date)
	 */
	
	@Transactional
	@Override
	public List<WastepaperDetail> getTransferToMaster(Date sDate, Date eDate) {
		// TODO Auto-generated method stub
		return wastepaperDao.getTransferToMaster(sDate,eDate);
	}

	/* (non-Javadoc)
	 * @see com.st.wastepaper.service.WastepaperService#addtomaster(com.st.wastepaper.model.WastepaperDetail)
	 */
	@Transactional
	@Override
	public int addtomaster(WastepaperDetail wastepaperDetail) {
		// TODO Auto-generated method stub
		return wastepaperDao.getAddtomaster(wastepaperDetail);
	}

	/* (non-Javadoc)
	 * @see com.st.wastepaper.service.WastepaperService#checkreleseNumber(int)
	 */
	@Transactional
	@Override
	public List<WastepaperDetail> checkreleseNumber(int releaseNo,int gradeid) {
		// TODO Auto-generated method stub
		return wastepaperDao.checkreleseNumber(releaseNo,gradeid);
	}

	/* (non-Javadoc)
	 * @see com.st.wastepaper.service.WastepaperService#addtomasterUpdate(com.st.wastepaper.model.WastepaperDetail)
	 */
	@Transactional
	@Override
	public void addtomasterUpdate(WastepaperDetail wastepaperDetail) {
		// TODO Auto-generated method stub
		wastepaperDao.addtomasterUpdate(wastepaperDetail);
		
	}
	//Code Starts From Here Done By Roshan Tailor Date :- 07/02/2015 MM/DD/YYYY Night Shift
	/* (non-Javadoc)
	 * @see com.st.wastepaper.service.WastepaperService#EditFreight(java.lang.String)
	 */
	@Transactional
	@Override
	public List<WastepaperDetail> EditFreight(int id) {
		// TODO Auto-generated method stub
		return wastepaperDao.EditFreight(id);
	}
	//Code Ends Here Done By Roshan Tailor Date:- 07/02/2014 MM/DD/YYYY NIght Shift

	/* (non-Javadoc)
	 * @see com.st.wastepaper.service.WastepaperService#update(com.st.wastepaper.model.WastepaperDetail)
	 */
	@Transactional
	@Override
	public void update(WastepaperDetail wastepaperDetail) {
		// TODO Auto-generated method stub 
		wastepaperDao.update(wastepaperDetail);
	}
	/* (non-Javadoc)
	 * @see com.st.wastepaper.service.WastepaperService#addNewEstimatedFreight(com.st.wastepaper.model.WastepaperDetail)
	 */
	@Transactional
	@Override
	public void addNewEstimatedFreight(WastepaperDetail wastepaperDetail) {
		// TODO Auto-generated method stub
		wastepaperDao.addNewEstimatedFreight(wastepaperDetail);
	}

	/* (non-Javadoc)
	 * @see com.st.wastepaper.service.WastepaperService#getWastePaperInBoundByDeliveryData(java.util.Date, java.util.Date)
	 */
	@Transactional
	@Override
	public List<WastepaperDetail> getWastePaperInBoundByDeliveryData(Date sDate, Date eDate) throws ParseException {
		// TODO Auto-generated method stub
		return wastepaperDao.getWastePaperInBoundByDeliveryData(sDate,eDate);
		
	}

	/* (non-Javadoc)
	 * @see com.st.wastepaper.service.WastepaperService#getWastePaperInBoundByDeliveryData1(java.util.Date, java.util.Date)
	 */
	@Override
	public List<WastepaperDetail> getWastePaperInBoundByDeliveryData1(
			Date sDate, Date eDate) {
		return wastepaperDao.getWastePaperInBoundByDeliveryData1(sDate,eDate);
	}
}

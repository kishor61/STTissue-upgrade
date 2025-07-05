/**
 *Mar 2, 2016
 *TransferPricePerTonDataServiceImp.java
 * TODO
 *com.st.wastepaper.service
 *TransferPricePerTonDataServiceImp.java
 *Sunil Singh Bora
 */
package com.st.wastepaper.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.st.wastepaper.dao.TransferPricePerTonDataDao;
import com.st.wastepaper.dao.WastepaperDao;
import com.st.wastepaper.model.WastepaperDetail;

/**
 * @author sbora
 *
 */
@Service
public class TransferPricePerTonDataServiceImp  implements TransferPricePerTonDataService{

	
	@Autowired
	private TransferPricePerTonDataDao transferpricepertondatadao;
	
	/* (non-Javadoc)
	 * @see com.st.wastepaper.service.TransferPricePerTonDataService#getTransferAbleData(java.util.Date, java.util.Date)
	 */
	@Transactional
	@Override
	public List<WastepaperDetail> getTransferAbleData(Date sDate, Date eDate) {
		// TODO Auto-generated method stub
		return transferpricepertondatadao.getTransferAbleData(sDate,eDate);
	}

	/* (non-Javadoc)
	 * @see com.st.wastepaper.service.TransferPricePerTonDataService#save(com.st.wastepaper.model.WastepaperDetail)
	 */
	@Transactional
	@Override
	public int save(WastepaperDetail detail) {
		// TODO Auto-generated method stub
		return transferpricepertondatadao.save(detail);
	}

}

/**
 *Mar 2, 2016
 *TransferPricePerTonDataDao.java
 * TODO
 *com.st.wastepaper.dao
 *TransferPricePerTonDataDao.java
 *Sunil Singh Bora
 */
package com.st.wastepaper.dao;

import java.util.Date;
import java.util.List;

import com.st.wastepaper.model.WastepaperDetail;

/**
 * @author sbora
 *
 */
public interface TransferPricePerTonDataDao {

	/**
	 * @param sDate
	 * @param eDate
	 * @return
	 */
	List<WastepaperDetail> getTransferAbleData(Date sDate, Date eDate);

	/**
	 * @param detail
	 * @return
	 */
	int save(WastepaperDetail detail);

}

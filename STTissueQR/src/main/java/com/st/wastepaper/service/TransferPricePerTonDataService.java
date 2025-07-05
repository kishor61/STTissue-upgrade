/**
 *Mar 2, 2016
 *TransferPricePerTonDataService.java
 * TODO
 *com.st.wastepaper.service
 *TransferPricePerTonDataService.java
 *Sunil Singh Bora
 */
package com.st.wastepaper.service;

import java.util.Date;
import java.util.List;

import com.st.wastepaper.model.WastepaperDetail;

/**
 * @author sbora
 *
 */
public interface TransferPricePerTonDataService {

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

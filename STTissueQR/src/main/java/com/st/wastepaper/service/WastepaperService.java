/**
 *Feb 17, 2015
 *WastepaperService.java
 * TODO
 *com.st.wastepaper.service
 *WastepaperService.java
 *Sunil Singh Bora
 */
package com.st.wastepaper.service;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import com.st.wastepaper.model.WastepaperDetail;

/**
 * @author sbora
 *
 */
public interface WastepaperService {

	/**
	 * @param sDate
	 * @param eDate
	 * @return
	 */
	List<WastepaperDetail> getWastepaperDetailData(Date sdate, Date edate);

	/**
	 * @param sDate
	 * @param eDate
	 * @return
	 */
	List<WastepaperDetail> getTransferToMaster(Date sDate, Date eDate);

	/**
	 * @param wastepaperDetail
	 * @return
	 */
	int addtomaster(WastepaperDetail wastepaperDetail);

	/**
	 * @param releaseNo
	 * @param gradeid 
	 * @return
	 */
	List<WastepaperDetail> checkreleseNumber(int releaseNo, int gradeid);

	/**
	 * @param wastepaperDetail
	 */
	void addtomasterUpdate(WastepaperDetail wastepaperDetail);

	/**
	 * @param id
	 * @return
	 */
	List<WastepaperDetail> EditFreight(int id);

	/**
	 * @param wastepaperDetail
	 */
	void update(WastepaperDetail wastepaperDetail);

	/**
	 * @param wastepaperDetail
	 */
	void addNewEstimatedFreight(WastepaperDetail wastepaperDetail);

	/**
	 * @param sDate
	 * @param eDate
	 * @return
	 * @throws ParseException 
	 */
	List<WastepaperDetail> getWastePaperInBoundByDeliveryData(Date sDate,
			Date eDate) throws ParseException;

	/**
	 * @param sDate
	 * @param eDate
	 * @return
	 */
	List<WastepaperDetail> getWastePaperInBoundByDeliveryData1(Date sDate,
			Date eDate);

}

/**
 *Feb 17, 2015
 *WastepaperDao.java
 * TODO
 *com.st.wastepaper.dao
 *WastepaperDao.java
 *Sunil Singh Bora
 */
package com.st.wastepaper.dao;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import com.st.wastepaper.model.WastepaperDetail;

/**
 * @author sbora
 *
 */
public interface WastepaperDao {

	/**
	 * @param sdate
	 * @param edate
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
	int getAddtomaster(WastepaperDetail wastepaperDetail);

	/**
	 * @param releaseNo
	 * @param releaseNo2 
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

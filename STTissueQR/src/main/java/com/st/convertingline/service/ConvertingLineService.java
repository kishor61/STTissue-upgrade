/**
 *Mar 25, 2017
 *ConvertingLineService.java
 * TODO
 *com.st.convertingline.service
 *ConvertingLineService.java
 *Roshan Lal Tailor
 */
package com.st.convertingline.service;

import java.util.Date;
import java.util.List;

import productspecificationsignoffsheet.ProductSpecificationSignOffSheet;

import com.st.convertingline.model.ConvertingPackagerObcc;
import com.st.convertingline.model.RewinderAndUnwindStand;
import com.st.convertingline.model.ConvertingLine;

/**
 * @author roshan
 *
 */
public interface ConvertingLineService {

	/**
	 * @return
	 */
	List<ConvertingLine> getAllCustName();

	/**
	 * @return
	 */
	List<ConvertingLine> getAllSkuCode();

	/**
	 * @param data
	 * @return
	 */
	int save(ConvertingLine data);

	/**
	 * @param data
	 */
	void update(ConvertingLine data);

	/**
	 * @param format
	 * @return
	 */
	List<ConvertingLine> getCurrentDateData(String format);

	/**
	 * @param id
	 */
	void delete(int id);

	/**
	 * @param date1
	 * @param date2
	 * @return
	 */
	List<ConvertingLine> getCurrentBackDateData(Date date1, Date date2);

	/**
	 * @param wm
	 * @return
	 */
	int saveproductspecificationsignoffsheet(ProductSpecificationSignOffSheet wm);

	/**
	 * @param wm
	 */
	void updateproductspecificationsignoffsheet(
			ProductSpecificationSignOffSheet wm);

	/**
	 * @param format
	 * @return
	 */
	List<ProductSpecificationSignOffSheet> getDataOfProductSpecificationSignOffSheet(
			String format);

	/**
	 * @param id
	 */
	void productspecificationsignoffsheetdelete(int id);

	/**
	 * @param format
	 * @param format2
	 * @return
	 */
	List<ProductSpecificationSignOffSheet> getDataOfProductSpecificationSignOffSheetByDate(
			String format, String format2);

	/**
	 * @param id
	 * @return
	 */
	List<ProductSpecificationSignOffSheet> getDataOfProductSpecificationSignOffSheetToEdit(
			int id);

	/**
	 * @param date1
	 * @param date2
	 * @param customerName
	 * @return
	 */
	List<ConvertingLine> getEditForecast(Date date1, Date date2,
			String customerName);

	/**
	 * @param id
	 * @return
	 */
	List<ConvertingLine> getskuSpecificationDataEntryViewBackdatedDataEditId(
			int id);

	/**
	 * @param date1
	 * @param date2
	 * @param customer
	 * @return
	 */
	List<ConvertingLine> getForeCastData(Date date1, Date date2, String customer);

	/**
	 * @param customer
	 * @param skucode
	 * @return
	 */
	int getCheckDataIsPresentOrNotInTempTable(String customer, String skucode);

	/**
	 * @param date1
	 * @param date2
	 * @param customer
	 * @param skucode
	 * @return
	 */
	List<ConvertingLine> getFetchDataNotInTempTable(Date date1, Date date2, String customer, String skucode);

	/**
	 * @param date1
	 * @param date2
	 * @param skucode
	 * @return
	 */
	List<ConvertingLine> getForeCastDataGroupBySKUCode(Date date1, Date date2,String skucode);

	/**
	 * @param skucode
	 * @return
	 */
	int getCheckDataIsPresentOrNotInTempTableForSKUCode(String skucode);

	/**
	 * @param date1
	 * @param date2
	 * @param skucode
	 * @return
	 */
	List<ConvertingLine> getFetchDataNotInTempTableForSKUCode(Date date1,
			Date date2, String skucode);

	/**
	 * @param date1
	 * @param date2
	 * @param customer_Name
	 * @param sKU_Code
	 * @return
	 */
	List<ConvertingLine> getSearchForecastCustomerAndSKUCodeWise(Date date1,
			Date date2, String customer_Name, String sKU_Code);

	/**
	 * @param date1
	 * @param date2
	 * @param skucode
	 * @return
	 */
	List<ConvertingLine> getForeCastDataGroupBySKUCode_ByShipToDate(Date date1,
			Date date2, String skucode);

	/**
	 * @param skucode
	 * @return
	 */
	int getCheckDataIsPresentOrNotInTempTableForSKUCode_ByShipToDate(
			String skucode);

	/**
	 * @param date1
	 * @param date2
	 * @param skucode
	 * @return
	 */
	List<ConvertingLine> getFetchDataNotInTempTableForSKUCode_ByShipToDate(
			Date date1, Date date2, String skucode);

	/**
	 * @param customer
	 * @param skucode
	 * @param date
	 * @return
	 */
	Date getCheckLastEntryData(String customer, String skucode, Date date);

	/**
	 * @param data
	 */
	void skuspecificationForecasteUpdate(ConvertingLine data);

	/**
	 * @param data
	 * @return
	 */
	int skuspecificationForecasteSave(ConvertingLine data);

	/**
	 * @param dateS
	 * @param dateS2
	 * @return
	 */
	Double getRewiderHoursAvg(Date dateS, Date dateS2);

	/**
	 * @param data
	 
	 */
	void saveorUpdate(ConvertingPackagerObcc data);

	/**
	 * @param position
	 * @param startDate
	 * @param endDate
	 * @param shift
	 * @return
	 */
	long getDataCountDatePercentageCase(String position, String startDate, String endDate, String shift);

	/**
	 * @param string
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	List<ConvertingPackagerObcc> getCasepackOperatorDataList(String string, String startDate, String endDate);

	/**
	 * @param position
	 * @param startDate
	 * @param endDate
	 * @param shift
	 * @return
	 */
	long getDataCountDatePercentageRewind(String position, String startDate, String endDate, String shift);

	

	/**
	 * @param rewinddata
	 * @return
	 */
	int saveorUpdate(RewinderAndUnwindStand rewinddata);

	/**
	 * @param data
	 */
	void saveorUpdateRewind(RewinderAndUnwindStand data);

	/**
	 * @param string
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	List<RewinderAndUnwindStand> getOperatorDataListRewind(String string, String startDate, String endDate);

}

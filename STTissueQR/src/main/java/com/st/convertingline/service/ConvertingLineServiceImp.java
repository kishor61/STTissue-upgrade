/**
 *Mar 25, 2017
 *ConvertingLineServiceImp.java
 * TODO
 *com.st.convertingline.service
 *ConvertingLineServiceImp.java
 *Roshan Lal Tailor
 */
package com.st.convertingline.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import productspecificationsignoffsheet.ProductSpecificationSignOffSheet;

import com.st.convertingline.dao.ConvertingLineDao;
import com.st.convertingline.model.ConvertingPackagerObcc;
import com.st.convertingline.model.RewinderAndUnwindStand;
import com.st.convertingline.model.ConvertingLine;

/**
 * @author roshan
 *
 */
@Service
public class ConvertingLineServiceImp implements ConvertingLineService{

	
	@Autowired
	private ConvertingLineDao convertingLineDao;
	
	/* (non-Javadoc)
	 * @see com.st.convertingline.service.ConvertingLineService#getAllCustName()
	 */
	@Transactional
	@Override
	public List<ConvertingLine> getAllCustName() {
		// TODO Auto-generated method stub
		return convertingLineDao.getAllCustName();
	}

	/* (non-Javadoc)
	 * @see com.st.convertingline.service.ConvertingLineService#getAllSkuCode()
	 */
	@Transactional
	@Override
	public List<ConvertingLine> getAllSkuCode() {
		// TODO Auto-generated method stub
		return convertingLineDao.getAllSkuCode();
	}

	/* (non-Javadoc)
	 * @see com.st.convertingline.service.ConvertingLineService#save(com.st.convertingline.model.ConvertingLine)
	 */
	@Transactional
	@Override
	public int save(ConvertingLine data) {
		// TODO Auto-generated method stub
		return convertingLineDao.save(data);
	}

	/* (non-Javadoc)
	 * @see com.st.convertingline.service.ConvertingLineService#update(com.st.convertingline.model.ConvertingLine)
	 */
	@Transactional
	@Override
	public void update(ConvertingLine data) {
		// TODO Auto-generated method stub
		convertingLineDao.update(data);
	}

	/* (non-Javadoc)
	 * @see com.st.convertingline.service.ConvertingLineService#getCurrentDateData(java.lang.String)
	 */
	@Transactional
	@Override
	public List<ConvertingLine> getCurrentDateData(String format) {
		// TODO Auto-generated method stub
		return convertingLineDao.getCurrentDateData(format);
	}

	/* (non-Javadoc)
	 * @see com.st.convertingline.service.ConvertingLineService#delete(int)
	 */
	@Transactional
	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		convertingLineDao.delete(id);
	}

	/* (non-Javadoc)
	 * @see com.st.convertingline.service.ConvertingLineService#getCurrentBackDateData(java.util.Date, java.util.Date)
	 */
	@Transactional
	@Override
	public List<ConvertingLine> getCurrentBackDateData(Date date1, Date date2) {
		// TODO Auto-generated method stub
		return convertingLineDao.getCurrentBackDateData(date1,date2);
	}

	/* (non-Javadoc)
	 * @see com.st.convertingline.service.ConvertingLineService#saveproductspecificationsignoffsheet(productspecificationsignoffsheet.ProductSpecificationSignOffSheet)
	 */
	@Override
	@Transactional
	public int saveproductspecificationsignoffsheet(
			ProductSpecificationSignOffSheet wm) {
		// TODO Auto-generated method stub
		return convertingLineDao.saveproductspecificationsignoffsheet(wm);
	}

	/* (non-Javadoc)
	 * @see com.st.convertingline.service.ConvertingLineService#updateproductspecificationsignoffsheet(productspecificationsignoffsheet.ProductSpecificationSignOffSheet)
	 */
	@Override
	@Transactional
	public void updateproductspecificationsignoffsheet(
			ProductSpecificationSignOffSheet wm) {
		convertingLineDao.updateproductspecificationsignoffsheet(wm);
		
	}

	/* (non-Javadoc)
	 * @see com.st.convertingline.service.ConvertingLineService#getDataOfProductSpecificationSignOffSheet(java.lang.String)
	 */
	@Override
	@Transactional
	public List<ProductSpecificationSignOffSheet> getDataOfProductSpecificationSignOffSheet(String format) {
		// TODO Auto-generated method stub
		return convertingLineDao.getDataOfProductSpecificationSignOffSheet(format);
	}

	/* (non-Javadoc)
	 * @see com.st.convertingline.service.ConvertingLineService#productspecificationsignoffsheetdelete(int)
	 */
	@Override
	@Transactional
	public void productspecificationsignoffsheetdelete(int id) {
		// TODO Auto-generated method stub
		convertingLineDao.productspecificationsignoffsheetdelete(id);
	}

	/* (non-Javadoc)
	 * @see com.st.convertingline.service.ConvertingLineService#getDataOfProductSpecificationSignOffSheetByDate(java.lang.String, java.lang.String)
	 */
	@Override
	@Transactional
	public List<ProductSpecificationSignOffSheet> getDataOfProductSpecificationSignOffSheetByDate(String format, String format2) {
		// TODO Auto-generated method stub
		return convertingLineDao.getDataOfProductSpecificationSignOffSheetByDate(format,format2);
	}

	/* (non-Javadoc)
	 * @see com.st.convertingline.service.ConvertingLineService#getDataOfProductSpecificationSignOffSheetToEdit(int)
	 */
	@Override
	@Transactional
	public List<ProductSpecificationSignOffSheet> getDataOfProductSpecificationSignOffSheetToEdit(int id) {
		// TODO Auto-generated method stub
		return convertingLineDao.getDataOfProductSpecificationSignOffSheetToEdit(id);
	}

	/* (non-Javadoc)
	 * @see com.st.convertingline.service.ConvertingLineService#getEditForecast(java.util.Date, java.util.Date, java.util.List)
	 */
	@Override
	@Transactional
	public List<ConvertingLine> getEditForecast(Date date1, Date date2, String custname) {
		// TODO Auto-generated method stub
		return convertingLineDao.getEditForecast(date1,date2,custname);
	}

	/* (non-Javadoc)
	 * @see com.st.convertingline.service.ConvertingLineService#getskuSpecificationDataEntryViewBackdatedDataEditId(int)
	 */
	@Override
	@Transactional
	public List<ConvertingLine> getskuSpecificationDataEntryViewBackdatedDataEditId( int id) {
		// TODO Auto-generated method stub
		return convertingLineDao.getskuSpecificationDataEntryViewBackdatedDataEditId(id);
	}

	/* (non-Javadoc)
	 * @see com.st.convertingline.service.ConvertingLineService#getForeCastData(java.util.Date, java.util.Date, java.lang.String)
	 */
	@Override
	@Transactional
	public List<ConvertingLine> getForeCastData(Date date1, Date date2, String customer) {
		// TODO Auto-generated method stub
		return convertingLineDao.getForeCastData(date1,date2,customer);
	}

	/* (non-Javadoc)
	 * @see com.st.convertingline.service.ConvertingLineService#getCheckDataIsPresentOrNotInTempTable(java.lang.String, java.lang.String)
	 */
	@Override
	@Transactional
	public int getCheckDataIsPresentOrNotInTempTable(String customer, String skucode) {
		// TODO Auto-generated method stub
		return convertingLineDao.getCheckDataIsPresentOrNotInTempTable(customer,skucode);
	}

	/* (non-Javadoc)
	 * @see com.st.convertingline.service.ConvertingLineService#getFetchDataNotInTempTable(java.util.Date, java.util.Date, java.lang.String, java.lang.String)
	 */
	@Override
	@Transactional
	public List<ConvertingLine> getFetchDataNotInTempTable(Date date1, Date date2, String customer, String skucode) {
		// TODO Auto-generated method stub
		return convertingLineDao.getFetchDataNotInTempTable(date1,date2,customer,skucode);
	}

	/* (non-Javadoc)
	 * @see com.st.convertingline.service.ConvertingLineService#getForeCastDataGroupBySKUCode(java.util.Date, java.util.Date, java.lang.String)
	 */
	@Override
	@Transactional
	public List<ConvertingLine> getForeCastDataGroupBySKUCode(Date date1, 	Date date2, String skucode) {
		// TODO Auto-generated method stub
		return convertingLineDao.getForeCastDataGroupBySKUCode(date1,date2,skucode);
	}

	/* (non-Javadoc)
	 * @see com.st.convertingline.service.ConvertingLineService#getCheckDataIsPresentOrNotInTempTableForSKUCode(java.lang.String)
	 */
	@Override
	@Transactional
	public int getCheckDataIsPresentOrNotInTempTableForSKUCode(String skucode) {
		// TODO Auto-generated method stub
		return convertingLineDao.getCheckDataIsPresentOrNotInTempTableForSKUCode(skucode);
	}

	/* (non-Javadoc)
	 * @see com.st.convertingline.service.ConvertingLineService#getFetchDataNotInTempTableForSKUCode(java.util.Date, java.util.Date, java.lang.String)
	 */
	@Override
	@Transactional
	public List<ConvertingLine> getFetchDataNotInTempTableForSKUCode( Date date1, Date date2, String skucode) {
		// TODO Auto-generated method stub
		return convertingLineDao.getFetchDataNotInTempTableForSKUCode(date1,date2,skucode);
	}

	/* (non-Javadoc)
	 * @see com.st.convertingline.service.ConvertingLineService#getSearchForecastCustomerAndSKUCodeWise(java.util.Date, java.util.Date, java.lang.String, java.lang.String)
	 */
	@Transactional
	@Override
	public List<ConvertingLine> getSearchForecastCustomerAndSKUCodeWise(Date date1, Date date2, String customer_Name, String sKU_Code) {
		// TODO Auto-generated method stub
		return convertingLineDao.getSearchForecastCustomerAndSKUCodeWise(date1,date2,customer_Name,sKU_Code);
	}

	/* (non-Javadoc)
	 * @see com.st.convertingline.service.ConvertingLineService#getForeCastDataGroupBySKUCode_ByShipToDate(java.util.Date, java.util.Date, java.lang.String)
	 */
	@Override
	@Transactional
	public List<ConvertingLine> getForeCastDataGroupBySKUCode_ByShipToDate(
			Date date1, Date date2, String skucode) {
		// TODO Auto-generated method stub
		return convertingLineDao.getForeCastDataGroupBySKUCode_ByShipToDate(date1,date2,skucode);
	}

	/* (non-Javadoc)
	 * @see com.st.convertingline.service.ConvertingLineService#getCheckDataIsPresentOrNotInTempTableForSKUCode_ByShipToDate(java.lang.String)
	 */
	@Override
	@Transactional
	public int getCheckDataIsPresentOrNotInTempTableForSKUCode_ByShipToDate(String skucode) {
		return convertingLineDao.getCheckDataIsPresentOrNotInTempTableForSKUCode_ByShipToDate(skucode);}

	/* (non-Javadoc)
	 * @see com.st.convertingline.service.ConvertingLineService#getFetchDataNotInTempTableForSKUCode_ByShipToDate(java.util.Date, java.util.Date, java.lang.String)
	 */
	@Override
	@Transactional
	public List<ConvertingLine> getFetchDataNotInTempTableForSKUCode_ByShipToDate(
			Date date1, Date date2, String skucode) {
		// TODO Auto-generated method stub
		return convertingLineDao.getFetchDataNotInTempTableForSKUCode_ByShipToDate(date1,date2,skucode);
	}

	/* (non-Javadoc)
	 * @see com.st.convertingline.service.ConvertingLineService#getCheckLastEntryData(java.lang.String, java.lang.String, java.util.Date)
	 */
	@Override
	@Transactional
	public Date getCheckLastEntryData(String customer, String skucode, Date date) {
		// TODO Auto-generated method stub
		return convertingLineDao.getCheckLastEntryData(customer,skucode,date);
	}

	/* (non-Javadoc)
	 * @see com.st.convertingline.service.ConvertingLineService#skuspecificationForecasteUpdate(com.st.convertingline.model.ConvertingLine)
	 */
	@Override
	@Transactional
	public void skuspecificationForecasteUpdate(ConvertingLine data) {
		// TODO Auto-generated method stub
		convertingLineDao.skuspecificationForecasteUpdate(data);
	}

	/* (non-Javadoc) /frpobccCommon
	 * @see com.st.convertingline.service.ConvertingLineService#skuspecificationForecasteSave(com.st.convertingline.model.ConvertingLine)
	 */
	@Override
	@Transactional
	public int skuspecificationForecasteSave(ConvertingLine data) {
		// TODO Auto-generated method stub
		return convertingLineDao.skuspecificationForecasteSave(data);
	}

	/* (non-Javadoc)
	 * @see com.st.convertingline.service.ConvertingLineService#getRewiderHoursAvg(java.util.Date, java.util.Date)
	 */
	@Override
	public Double getRewiderHoursAvg(Date dateS, Date dateS2) {
		// TODO Auto-generated method stub
		return convertingLineDao.getRewiderHoursAvg(dateS,dateS2);
	}

	/* (non-Javadoc)
	 * @see com.st.convertingline.service.ConvertingLineService#saveorUpdate(com.st.convertingline.model.Casepacker)
	 */
	@Override
	public void saveorUpdate(ConvertingPackagerObcc data) {
		// TODO Auto-generated method stub
		
		convertingLineDao.saveorUpdate(data);
		
	}

	/* (non-Javadoc)
	 * @see com.st.convertingline.service.ConvertingLineService#getDataCountDatePercentageCase(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public long getDataCountDatePercentageCase(String position, String startDate, String endDate, String shift) {
		// TODO Auto-generated method stub
		return convertingLineDao.getDataCountDatePercentageCase(position,startDate,endDate,shift);
	}

	/* (non-Javadoc)
	 * @see com.st.convertingline.service.ConvertingLineService#getCasepackOperatorDataList(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public List<ConvertingPackagerObcc> getCasepackOperatorDataList(String string, String startDate, String endDate) {
		// TODO Auto-generated method stub
		return convertingLineDao.getCasepackOperatorDataList(string,startDate,endDate);
	}

	/* (non-Javadoc)
	 * @see com.st.convertingline.service.ConvertingLineService#getDataCountDatePercentageRewind(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public long getDataCountDatePercentageRewind(String position, String startDate, String endDate, String shift) {
		// TODO Auto-generated method stub
		return convertingLineDao.getDataCountDatePercentageRewind(position,startDate,endDate,shift);
	}

	/* (non-Javadoc)
	 * @see com.st.convertingline.service.ConvertingLineService#getOperatorDataListRewind(java.lang.String, java.lang.String, java.lang.String)
	 */
	/*
	 * @Override public List getOperatorDataListRewind(String startDate, String
	 * endDate, String string) { // TODO Auto-generated method stub return
	 * convertingLineDao.getOperatorDataListRewind(startDate,endDate,string); }
	 */

	/* (non-Javadoc)
	 * @see com.st.convertingline.service.ConvertingLineService#saveorUpdate(com.st.convertingline.model.RewinderAndUnwindStand)
	 */
	@Override
	public int saveorUpdate(RewinderAndUnwindStand rewinddata) {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see com.st.convertingline.service.ConvertingLineService#saveorUpdateRewind(com.st.convertingline.model.RewinderAndUnwindStand)
	 */
	@Override
	public void saveorUpdateRewind(RewinderAndUnwindStand data) {
		// TODO Auto-generated method stub
		convertingLineDao.saveorUpdateRewind(data);
	}

	/* (non-Javadoc)
	 * @see com.st.convertingline.service.ConvertingLineService#getOperatorDataListRewind(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public List<RewinderAndUnwindStand> getOperatorDataListRewind(String string, String startDate, String endDate) {
		// TODO Auto-generated method stub
		return convertingLineDao.getOperatorDataListRewind(string,startDate,endDate);
	}

}

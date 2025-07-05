/**
 *Oct 23, 2019
 *StockOperatorPM5ServiceImp.java
 * TODO
 *com.st.obccPM5.service
 *StockOperatorPM5ServiceImp.java
 *Roshan Lal Tailor
 */
package com.st.obccPM5.service;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.st.obccPM5.dao.StockOperatorPM5Dao;
import com.st.obccPM5.model.StockOperatorPM5;

/**
 * @author roshan
 *
 */
@Service
public class StockOperatorPM5ServiceImp implements StockOperatorPM5Service {

	@Autowired
	private StockOperatorPM5Dao stockoperatorpm5dao;
	
	/* (non-Javadoc)
	 * @see com.st.oBcc1pm5.service.StockOperatorPM55Service#saveorUpdate(com.st.oBcc1pm5.model.StockOperatorPM5)
	 */
	@Override
	public void saveorUpdate(StockOperatorPM5 data) {
		
		stockoperatorpm5dao.saveorUpdate(data);
	}


	/* (non-Javadoc)
	 * @see com.st.oBcc1pm5.service.StockOperatorPM5Service#getOperatorDataList(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public List<StockOperatorPM5> getStockOperatorPm5DataList(String position,
			String startDate, String endDate, String shift) {
		
		
		
		return stockoperatorpm5dao.getStockOperatorPm5DataList(position,startDate,endDate,shift);
	}

	/* (non-Javadoc)
	 * @see com.st.oBcc1pm5.service.StockOperatorPM5Service#getDataCountDatePercentage(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public long getDataCountDatePercentage(String position, String startDate,String endDate, String shift) throws ParseException {
		// TODO Auto-generated method stub
		return stockoperatorpm5dao.getDataCountDatePercentage(position,startDate,endDate,shift);
	}


	/* (non-Javadoc)
	 * @see com.st.obccPM5.service.StockOperatorPM5Service#getOperatorData(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public StockOperatorPM5 getOperatorData(String position, String shift, String date) {
		// TODO Auto-generated method stub
		return stockoperatorpm5dao.getOperatorData(position, shift, date);
	}}

/**
 *Jul 4, 2016
 *StockOperatorServiceImpl.java
 * TODO
 *com.st.obcc.service
 *StockOperatorServiceImpl.java
 *Sunil Singh Bora
 */
package com.st.obcc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.st.obcc.dao.StockOperatorDao;
import com.st.obcc.model.StockOperator;

/**
 * @author snavhaal
 *
 */
@Service
public class StockOperatorServiceImpl implements StockOperatorService {

	@Autowired
	private StockOperatorDao stockOperatorDao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.st.obcc.service.StockOperatorService#saveorUpdate(com.st.obcc.model
	 * .StockOperator)
	 */
	@Transactional
	@Override
	public void saveorUpdate(StockOperator data) {
		// TODO Auto-generated method stub
		stockOperatorDao.saveorUpdate(data);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.st.obcc.service.StockOperatorService#getOperatorData(java.lang.String
	 * , java.lang.String, java.lang.String, java.lang.String)
	 */
	@Transactional
	@Override
	public StockOperator getOperatorData(String position, String date,
			String shift, String crew) throws Exception {
		// TODO Auto-generated method stub
		return stockOperatorDao.getOperatorData(position, date, shift, crew);
	}
	
	/* (non-Javadoc)
	 * @see com.st.obcc.service.StockOperatorService#getOperatorDataList(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Transactional
	@Override
	public List<StockOperator> getOperatorDataList(String position,	String shift,String Sdate, String edate) throws Exception {
		// TODO Auto-generated method stub
		return stockOperatorDao.getOperatorDataList(position,shift, Sdate, edate);
	}

	/* (non-Javadoc)
	 * @see com.st.obcc.service.StockOperatorService#getDataCountDatePercentage(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	@Transactional
	public long getDataCountDatePercentage(String position,	String shift,String Sdate, String edate) throws Exception {
		// TODO Auto-generated method stub
		return stockOperatorDao.getDataCountDatePercentage(position,shift, Sdate, edate);
	}

}

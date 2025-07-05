/**
 *Jun 16, 2016
 *UtilityOperatorServiceImpl.java
 * TODO
 *com.st.obcc.service
 *UtilityOperatorServiceImpl.java
 *Sunil Singh Bora
 */
package com.st.obcc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.st.obcc.dao.UtilityOperatorDao;
import com.st.obcc.model.BackTender;
import com.st.obcc.model.UtilityOperator;
/**
 * @author snavhaal
 *
 */
@Service
public class UtilityOperatorServiceImpl implements UtilityOperatorService {

	@Autowired
	private UtilityOperatorDao utilityOperatorDao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.st.obcc.service.UtilityOperatorService#saveorUpdate(com.st.obcc.model
	 * .UtilityOperator)
	 */
	@Transactional
	@Override
	public void saveorUpdate(UtilityOperator data) {

		utilityOperatorDao.saveorUpdate(data);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.st.obcc.service.UtilityOperatorService#getOperatorData(java.lang.
	 * String, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Transactional
	@Override
	public UtilityOperator getOperatorData(String position, String date,
			String shift, String crew) throws Exception {
		// TODO Auto-generated method stub
		return utilityOperatorDao.getOperatorData(position, shift, date, crew);
	}
	
	/* (non-Javadoc)
	 * @see com.st.obcc.service.UtilityOperatorService#getOperatorDataList(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Transactional
	@Override
	public List<UtilityOperator> getOperatorDataList(String position,
			String Sdate, String edate) throws Exception {
	 
		return utilityOperatorDao.getOperatorDataList(position, Sdate, edate);
	}

	
	/* (non-Javadoc)
	 * @see com.st.obcc.service.UtilityOperatorService#getDataCountDatePercentage1(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public long getDataCountDatePercentage1(String position, String sdate,
			String edate) throws Exception {
		
		return utilityOperatorDao.getDataCountDatePercentage1(position, sdate, edate);
	}
 
	/* (non-Javadoc)
	 * @see com.st.obcc.service.UtilityOperatorService#getDataCountDatePercentage(java.lang.String, java.lang.String, java.lang.String)
	 
	@Override
	@Transactional
	public long getDataCountDatePercentage(String position, String Sdate,
			String edate) throws Exception {
		return utilityOperatorDao.getDataCountDatePercentage(position, Sdate, edate);
	}

	 (non-Javadoc)
	 * @see com.st.obcc.service.UtilityOperatorService#getDataCountDatePercentage(java.lang.String, java.lang.String)
	 
	@Override
	@Transactional
	public double getDataCountDatePercentage(String Sdate, String edate)
			throws Exception {
		// TODO Auto-generated method stub
		return utilityOperatorDao.getDataCountDatePercentage(Sdate, edate);
	}*/

}

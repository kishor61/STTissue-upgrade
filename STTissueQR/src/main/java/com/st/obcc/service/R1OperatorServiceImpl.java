/**
 *Jun 27, 2016
 *R1OperatorServiceImpl.java
 * TODO
 *com.st.obcc.service
 *R1OperatorServiceImpl.java
 *Sunil Singh Bora
 */
package com.st.obcc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.st.obcc.dao.R1OperatorDao;
import com.st.obcc.model.R1Operator;

/**
 * @author snavhaal
 *
 */
@Service
public class R1OperatorServiceImpl implements R1OperatorService {

	@Autowired
	private R1OperatorDao r1OperatorDao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.st.obcc.service.R1OperatorService#saveorUpdate(com.st.obcc.model.
	 * R1Operator)
	 */
	@Transactional
	@Override
	public void saveorUpdate(R1Operator data) {
		// TODO Auto-generated method stub
		r1OperatorDao.saveorUpdate(data);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.st.obcc.service.R1OperatorService#getOperatorData(java.lang.String,
	 * java.lang.String, java.lang.String, java.lang.String)
	 */
	@Transactional
	@Override
	public R1Operator getOperatorData(String position, String date,
			String shift, String crew) throws Exception {
		// TODO Auto-generated method stub
		return r1OperatorDao.getOperatorData(position, date, shift, crew);
	}
	
	
	/* (non-Javadoc)
	 * @see com.st.obcc.service.R1OperatorService#getOperatorDataList(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Transactional
	@Override
	public List<R1Operator> getOperatorDataList(String position, String Sdate,	String edate) throws Exception {
		// TODO Auto-generated method stub
		return r1OperatorDao.getOperatorDataList(position,Sdate,edate);
	}

	
	@Override
	public long getDataCountDatePercentage1(String position, String Sdate,	String edate) throws Exception {
		
		return r1OperatorDao.getDataCountDatePercentage1(position,Sdate,edate);
	}
	

	/* (non-Javadoc)
	 * @see com.st.obcc.service.R1OperatorService#getDataCountDatePercentage(java.lang.String, java.lang.String, java.lang.String)
	 
	@Override
	public long getDataCountDatePercentage(String position, String Sdate,
			String edate) throws Exception {
		// TODO Auto-generated method stub
		return r1OperatorDao.getDataCountDatePercentage(position,Sdate,edate);
	}

	 (non-Javadoc)
	 * @see com.st.obcc.service.R1OperatorService#getDataCountDatePercentage(java.lang.String, java.lang.String)
	 
	@Override
	public double getDataCountDatePercentage(String Sdate, String edate)
			throws Exception {
		// TODO Auto-generated method stub
		return r1OperatorDao.getDataCountDatePercentage(Sdate, edate);
	}
*/
}

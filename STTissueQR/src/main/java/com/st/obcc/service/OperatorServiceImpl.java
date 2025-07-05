/**
 *Jun 2, 2016
 *OperatorServiceImpl.java
 * TODO
 *com.st.operator.service
 *OperatorServiceImpl.java
 *Sunil Singh Bora
 */
package com.st.obcc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.st.obcc.dao.OperatorDao;
import com.st.obcc.model.OperatorData;

/**
 * @author snavhaal
 *
 */
@Service
public class OperatorServiceImpl implements OperatorService {

	@Autowired
	private OperatorDao operatorDao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.st.operator.service.OperatorService#saveOrUpdate(com.st.operator.
	 * model.OperatorData)
	 */
	@Transactional
	@Override
	public void saveorUpdate(OperatorData data) {
		operatorDao.saveorUpdate(data);

	}
	
	/* (non-Javadoc)
	 * @see com.st.operator.service.OperatorService#getOperatorData(com.st.operator.model.OperatorData)
	 */
	@Transactional
	@Override
	public OperatorData getOperatorData(String position,String date,String shift,String crew) throws Exception {
		// TODO Auto-generated method stub
		return operatorDao.getOperatorData(position, date, shift,crew);
	}
	
	/* (non-Javadoc)
	 * @see com.st.obcc.service.OperatorService#getOperatorDataList(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Transactional
	@Override
	public List<OperatorData> getOperatorDataList(String position,String Sdate, String edate) throws Exception {

		return operatorDao.getOperatorDataList(position, Sdate, edate);
	}

	
	@Override
	@Transactional
	public long getDataCountDatePercentage(String position, String Sdate,String edate) throws Exception {
		// TODO Auto-generated method stub
		return operatorDao.getDataCountDatePercentage(position, Sdate, edate);
	}

	/* (non-Javadoc)
	 * @see com.st.obcc.service.OperatorService#CheckObcc(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public boolean CheckObcc(String date, String position, String shift) {
		
		return operatorDao. CheckObcc(date,position,shift);
	}
	
	/* (non-Javadoc)
	 * @see com.st.obcc.service.OperatorService#getDataCountDatePercentage(java.lang.String, java.lang.String, java.lang.String)
	 
	@Override
	@Transactional
	public long getDataCountDatePercentage(String position, String Sdate,
			String edate) throws Exception {
		// TODO Auto-generated method stub
		return operatorDao.getDataCountDatePercentage(position, Sdate, edate);
	}

	 (non-Javadoc)
	 * @see com.st.obcc.service.OperatorService#getDataCountDatePercentage(java.lang.String, java.lang.String)
	 
	@Override
	@Transactional
	public double getDataCountDatePercentage(String Sdate, String edate)
			throws Exception {
		// TODO Auto-generated method stub
		return operatorDao.getDataCountDatePercentage(Sdate, edate);
	}*/
	
}

/**
 *Jun 22, 2016
 *MachineTenderServiceImpl.java
 * TODO
 *com.st.obcc.service
 *MachineTenderServiceImpl.java
 *Sunil Singh Bora
 */
package com.st.obcc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.st.obcc.dao.MachineTenderDao;
import com.st.obcc.model.BackTender;
import com.st.obcc.model.MachineTender;

/**
 * @author snavhaal
 *
 */
@Service
public class MachineTenderServiceImpl implements MachineTenderService {

	@Autowired
	private MachineTenderDao machineTenderDao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.st.obcc.service.MachineTenderService#getOperatorData(java.lang.String
	 * , java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	@Transactional
	public MachineTender getOperatorData(String position, String date,
			String shift, String crew) throws Exception {
		// TODO Auto-generated method stub
		return machineTenderDao.getOperatorData(position, date, shift, crew);
	}
	/* (non-Javadoc)
	 * @see com.st.obcc.service.MachineTenderService#saveorUpdate(com.st.obcc.model.MachineTender)
	 */
	@Override
	@Transactional
	public void saveorUpdate(MachineTender data) {
		// TODO Auto-generated method stub
		
		machineTenderDao.saveorUpdate(data);
	}
	
	/* (non-Javadoc)
	 * @see com.st.obcc.service.MachineTenderService#getOperatorDataList(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Transactional
	@Override
	public List<MachineTender> getOperatorDataList(String position,String shift,
			String Sdate, String edate) throws Exception {
		// TODO Auto-generated method stub
		return machineTenderDao.getOperatorDataList(position,shift, Sdate, edate);
	}
	/* (non-Javadoc)
	 * @see com.st.obcc.service.MachineTenderService#getDataCountDatePercentage(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	@Transactional
	public long getDataCountDatePercentage(String position, String shift,String Sdate,
			String edate ) throws Exception {
		// TODO Auto-generated method stub
		return machineTenderDao.getDataCountDatePercentage(position,shift, Sdate, edate);
	}
	/* (non-Javadoc)
	 * @see com.st.obcc.service.MachineTenderService#getDataCountDatePercentage(java.lang.String, java.lang.String)
	 
	@Override
	@Transactional
	public double getDataCountDatePercentage(String Sdate, String edate)
			throws Exception {
		// TODO Auto-generated method stub
		return machineTenderDao.getDataCountDatePercentage(Sdate, edate);
	}
	
	@Override
	@Transactional
	public int getDataCountDatePercentage(String position, String Sdate,
			String edate, String shift) throws Exception {
		// TODO Auto-generated method stub
		return machineTenderDao.getDataCountDatePercentage1(position, Sdate, edate, shift);
	}*/
}

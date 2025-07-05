/**
 *Jun 13, 2016
 *BackTenderServiceImpl.java
 * TODO
 *com.st.obcc.service
 *BackTenderServiceImpl.java
 *Sunil Singh Bora
 */
package com.st.obcc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.st.obcc.dao.BackTenderDao;
import com.st.obcc.dao.OperatorDao;
import com.st.obcc.model.BackTender;

/**
 * @author snavhaal
 *
 */
@Service
public class BackTenderServiceImpl implements BackTenderService {
	
	@Autowired
	private BackTenderDao backTenderDao;

	
	/* (non-Javadoc)
	 * @see com.st.obcc.service.BackTenderService#saveorUpdate(com.st.obcc.model.BackTender)
	 */
	@Transactional
	@Override
	public void saveorUpdate(BackTender data) {
	 
		backTenderDao.saveorUpdate(data);
		
	}
	
	
	
	/* (non-Javadoc)
	 * @see com.st.obcc.service.BackTenderService#getOperatorData(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Transactional
	@Override
	public BackTender getOperatorData(String position, String date,
			String shift, String crew) throws Exception {
		// TODO Auto-generated method stub
		return backTenderDao.getOperatorData(position, shift, date, crew);
	}
	
	/* (non-Javadoc)
	 * @see com.st.obcc.service.BackTenderService#getOperatorDataList(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Transactional
	@Override
	public List<BackTender> getOperatorDataList(String position,String shift ,String sdate,String edate) throws Exception {
		// TODO Auto-generated method stub
		return backTenderDao.getOperatorDataList(position, shift,sdate, edate);
	}



	/* (non-Javadoc)
	 * @see com.st.obcc.service.BackTenderService#getDataCountDatePercentage(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	@Transactional
	public long getDataCountDatePercentage(String position,String shift, String Sdate,
			String edate) throws Exception {
		// TODO Auto-generated method stub
		return backTenderDao.getDataCountDatePercentage(position,shift ,Sdate, edate);
	}



	/* (non-Javadoc)
	 * @see com.st.obcc.service.BackTenderService#getDataCountDatePercentage(java.lang.String, java.lang.String)
	 
	@Override
	@Transactional
	public double getDataCountDatePercentage(String Sdate, String edate)
			throws Exception {
		// TODO Auto-generated method stub
		return backTenderDao.getDataCountDatePercentage(Sdate, edate);
	}
	*/
	

}

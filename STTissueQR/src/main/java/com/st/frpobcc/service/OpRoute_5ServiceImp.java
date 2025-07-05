/**
 *03-Dec-2019
 *OpRoute_1ServiceImp.java
 * TODO
 *com.st.frpobcc.service
 *OpRoute_5ServiceImp.java
 *Roshan Lal Tailor
 */
package com.st.frpobcc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.st.frpobcc.dao.OpRoute_5Dao;
import com.st.frpobcc.model.OpRoute_5;

/**
 * @author sohan
 *
 */
@Service
public class OpRoute_5ServiceImp implements OpRoute_5Service {
	
	@Autowired
	private OpRoute_5Dao oproute_5dao;
	

	/* (non-Javadoc)
	 * @see com.st.frpobcc.service.OpRoute_1#saveorUpdate(com.st.frpobcc.service.OpRoute_1)
	 */
	@Override
	public void saveorUpdate(OpRoute_5 data) {
		oproute_5dao.saveorUpdate(data);
	}


	/* (non-Javadoc)
	 * @see com.st.frpobcc.service.OpRoute_5Service#getData(java.lang.String)
	 */
	@Override
	public List<OpRoute_5> getData(String sdate,String edate) {
		// TODO Auto-generated method stub
		return oproute_5dao.getData(sdate,edate);
	}


	/* (non-Javadoc)
	 * @see com.st.frpobcc.service.OpRoute_5Service#getCountDatePercentage(java.lang.String)
	 */
	@Override
	public long getCountDatePercentage(String sdate,String edate) throws Exception {
		// TODO Auto-generated method stub
		return oproute_5dao.getCountDatePercentage(sdate,edate);
	}


	/**
	 * @param endDate
	 * @param endDate2
	 * @return
	 * @throws Exception 
	 */
	public List<Integer> getCount(String sdate, String edate) throws Exception {
		// TODO Auto-generated method stub
		return oproute_5dao.getCount(sdate, edate);
	}
}

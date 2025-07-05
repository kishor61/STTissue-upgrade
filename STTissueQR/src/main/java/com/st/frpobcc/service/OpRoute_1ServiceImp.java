/**
 *27-Nov-2019
 *OpRoute_1ServiceImp.java
 * TODO
 *com.st.frpobcc.service
 *OpRoute_1ServiceImp.java
 *Roshan Lal Tailor
 */
package com.st.frpobcc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.st.frpobcc.dao.OpRoute_1Dao;
import com.st.frpobcc.model.OpRoute_1;

/**
 * @author sohan
 *
 */
@Service
public class OpRoute_1ServiceImp implements OpRoute_1Service {
	
	@Autowired
	private OpRoute_1Dao oproute_1dao;
	

	/* (non-Javadoc)
	 * @see com.st.frpobcc.service.OpRoute_1#saveorUpdate(com.st.frpobcc.service.OpRoute_1)
	 */
	@Override
	public void saveorUpdate(OpRoute_1 data) {
		oproute_1dao.saveorUpdate(data);
	}


	/**
	 * @param date
	 * @return
	 */
	public List<OpRoute_1> getData(String sdate,String edate) {
		// TODO Auto-generated method stub
		return oproute_1dao.getData(sdate,edate);
	}


	/**
	 * @param date
	 * @return
	 * @throws Exception 
	 */
	public long getCountDatePercentage(String sdate,String edate) throws Exception {
		// TODO Auto-generated method stub
		return oproute_1dao.getCountDatePercentage(sdate,edate);
	}


	/**
	 * @param startDate
	 * @param getlastDayofMonth
	 * @return
	 * @throws Exception 
	 */
	public List<Integer> getCount(String sdate, String edate) throws Exception {
		// TODO Auto-generated method stub
		return oproute_1dao.getCount(sdate,edate);
	}
}

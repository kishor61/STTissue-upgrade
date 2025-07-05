/**
 *05-Dec-2019
 *OpRoute_7ServiceImp.java
 * TODO
 *com.st.frpobcc.service
 *OpRoute_7ServiceImp.java
 *Sohan Lal Bairwa
 */
package com.st.frpobcc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.st.frpobcc.dao.OpRoute_7Dao;
import com.st.frpobcc.model.OpRoute_7;

/**
 * @author sohan
 *
 */
@Service
public class OpRoute_7ServiceImp implements OpRoute_7Service {

	@Autowired
	private OpRoute_7Dao oproute_7dao;
	/* (non-Javadoc)
	 * @see com.st.frpobcc.service.OpRoute_7Service#saveorUpdate(com.st.frpobcc.model.OpRoute_7)
	 */
	@Override
	public void saveorUpdate(OpRoute_7 data) {

		oproute_7dao.saveorUpdate(data);
	}
	/**
	 * @param date
	 * @return
	 */
	public List<OpRoute_7> getData(String sdate,String edate) {
		// TODO Auto-generated method stub
		return oproute_7dao.getData(sdate,edate);
	}
	/* (non-Javadoc)
	 * @see com.st.frpobcc.service.OpRoute_7Service#getCountDatePercentage(java.lang.String)
	 */
	@Override
	public long getCountDatePercentage(String sdate,String edate) throws Exception {
		// TODO Auto-generated method stub
		return oproute_7dao.getCountDatePercentage(sdate,edate);
	}
	/**
	 * @param endDate
	 * @param endDate2
	 * @return
	 * @throws Exception 
	 */
	public List<Integer> getCount(String sdate, String edate) throws Exception {
		// TODO Auto-generated method stub
		return oproute_7dao.getCount(sdate, edate);
	}

}

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


import com.st.frpobcc.dao.OpRoute_2Dao;
import com.st.frpobcc.model.OpRoute_2;

/**
 * @author sohan
 *
 */
@Service
public class OpRoute_2ServiceImp implements OpRoute_2Service {
	
	@Autowired
	private OpRoute_2Dao oproute_2dao;
	

	/* (non-Javadoc)
	 * @see com.st.frpobcc.service.OpRoute_1#saveorUpdate(com.st.frpobcc.service.OpRoute_1)
	 */
	@Override
	public void saveorUpdate(OpRoute_2 data) {
		oproute_2dao.saveorUpdate(data);
	}
	@Override
	public List<OpRoute_2> getData(String sdate,String edate) {
		// TODO Auto-generated method stub
		return oproute_2dao.getData(sdate,edate);
	}
	/**
	 * @param date
	 * @return
	 * @throws Exception 
	 */
	public long getCountDatePercentage(String sdate,String edate) throws Exception {
		// TODO Auto-generated method stub
		return oproute_2dao.getCountDatePercentage(sdate,edate);
	}
	/**
	 * @param startDate
	 * @param endDate
	 * @return
	 * @throws Exception 
	 */
	public List<Integer> getCount(String sdate, String edate) throws Exception {
		// TODO Auto-generated method stub
		return oproute_2dao.getCount(sdate, edate);
	}
}

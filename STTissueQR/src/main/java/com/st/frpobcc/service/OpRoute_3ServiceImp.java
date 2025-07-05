/**
 *29-Nov-2019
 *OpRoute_1ServiceImp.java
 * TODO
 *com.st.frpobcc.service
 *OpRoute_3ServiceImp.java
 *Roshan Lal Tailor
 */
package com.st.frpobcc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.st.frpobcc.dao.OpRoute_3Dao;
import com.st.frpobcc.model.OpRoute_3;

/**
 * @author sohan
 *
 */
@Service
public class OpRoute_3ServiceImp implements OpRoute_3Service {
	
	@Autowired
	private OpRoute_3Dao oproute_3dao;
	

	/* (non-Javadoc)
	 * @see com.st.frpobcc.service.OpRoute_1#saveorUpdate(com.st.frpobcc.service.OpRoute_1)
	 */
	@Override
	public void saveorUpdate(OpRoute_3 data) {
		oproute_3dao.saveorUpdate(data);
	}


	/**
	 * @param date
	 * @return
	 */
	public List<OpRoute_3> getData(String sdate,String edate) {
		// TODO Auto-generated method stub
		return oproute_3dao.getData(sdate,edate);
	}


	/* (non-Javadoc)
	 * @see com.st.frpobcc.service.OpRoute_3Service#getCountDatePercentage(java.lang.String)
	 */
	@Override
	public long getCountDatePercentage(String sdate,String edate) throws Exception {
		// TODO Auto-generated method stub
		return oproute_3dao.getCountDatePercentage(sdate,edate);
	}


	/**
	 * @param startDate
	 * @param endDate
	 * @return
	 * @throws Exception 
	 */
	public List<Integer> getCount(String sdate, String edate) throws Exception {
		// TODO Auto-generated method stub
		return oproute_3dao.getCount(sdate, edate);
	}
}

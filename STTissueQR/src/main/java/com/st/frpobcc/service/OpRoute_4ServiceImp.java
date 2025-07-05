/**
 *02-Dec-2019
 *OpRoute_1ServiceImp.java
 * TODO
 *com.st.frpobcc.service
 *OpRoute_4ServiceImp.java
 *Roshan Lal Tailor
 */
package com.st.frpobcc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.st.frpobcc.dao.OpRoute_4Dao;
import com.st.frpobcc.model.OpRoute_4;

/**
 * @author sohan
 *
 */
@Service
public class OpRoute_4ServiceImp implements OpRoute_4Service {
	
	@Autowired
	private OpRoute_4Dao oproute_4dao;
	

	/* (non-Javadoc)
	 * @see com.st.frpobcc.service.OpRoute_1#saveorUpdate(com.st.frpobcc.service.OpRoute_1)
	 */
	@Override
	public void saveorUpdate(OpRoute_4 data) {
		oproute_4dao.saveorUpdate(data);
	}


	/**
	 * @param date
	 * @return
	 */
	public List<OpRoute_4> getData(String sdate,String edate) {
		// TODO Auto-generated method stub
		return oproute_4dao.getData(sdate,edate);
	}


	/* (non-Javadoc)
	 * @see com.st.frpobcc.service.OpRoute_4Service#getCountDatePercentage(java.lang.String)
	 */
	@Override
	public long getCountDatePercentage(String sdate,String edate) throws Exception {
		// TODO Auto-generated method stub
		return oproute_4dao.getCountDatePercentage(sdate,edate);
	}


	/**
	 * @param endDate
	 * @param endDate2
	 * @return
	 * @throws Exception 
	 */
	public List<Integer> getCount(String sdate, String edate) throws Exception {
		// TODO Auto-generated method stub
		return oproute_4dao.getCount(sdate, edate);
	}
}

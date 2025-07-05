/**
 *07-Dec-2019
 *OpRoute_9ServiceImp.java
 * TODO
 *com.st.frpobcc.service
 *OpRoute_9ServiceImp.java
 *Sohan Lal Bairwa
 */
package com.st.frpobcc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.st.frpobcc.dao.OpRoute_9Dao;
import com.st.frpobcc.model.OpRoute_9;

/**
 * @author sohan
 *
 */
@Service
public class OpRoute_9ServiceImp implements OpRoute_9Service {

	@Autowired
	private OpRoute_9Dao oproute_9dao;
	/* (non-Javadoc)
	 * @see com.st.frpobcc.service.OpRoute_9Service#saveorUpdate(com.st.frpobcc.model.OpRoute_9)
	 */
	@Override
	public void saveorUpdate(OpRoute_9 data) {
		
		oproute_9dao.saveorUpdate(data);
	}
	/**
	 * @param date
	 * @return
	 */
	public List<OpRoute_9> getData(String sdate,String edate) {
		// TODO Auto-generated method stub
		return oproute_9dao.getData(sdate,edate);
	}
	/* (non-Javadoc)
	 * @see com.st.frpobcc.service.OpRoute_9Service#getCountDatePercentage(java.lang.String)
	 */
	@Override
	public long getCountDatePercentage(String sdate, String edate) throws Exception {
		// TODO Auto-generated method stub
		return oproute_9dao.getCountDatePercentage(sdate,edate);
	}
	/**
	 * @param endDate
	 * @param endDate2
	 * @return
	 * @throws Exception 
	 */
	public List<Integer> getCount(String sdate, String edate) throws Exception {
		// TODO Auto-generated method stub
		return oproute_9dao.getCount(sdate, edate);
	}

}

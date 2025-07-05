/**
 *03-Dec-2019
 *OpRoute_6ServiceImp.java
 * TODO
 *com.st.frpobcc.service
 *OpRoute_6ServiceImp.java
 *Sohan Lal Bairwa
 */
package com.st.frpobcc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.st.frpobcc.dao.Oproute_6Dao;
import com.st.frpobcc.model.OpRoute_6;

/**
 * @author sohan
 *
 */
@Service
public class OpRoute_6ServiceImp implements OpRoute_6Service {

	@Autowired
	private Oproute_6Dao oproute_6dao;
	
	@Override
	public void saveorUpdate(OpRoute_6 data) {
		
		oproute_6dao.saveorUpdate(data);
	}

	/**
	 * @param date
	 * @return
	 */
	public List<OpRoute_6> getData(String sdate,String edate) {
		// TODO Auto-generated method stub
		return oproute_6dao.getData(sdate,edate);
	}

	/* (non-Javadoc)
	 * @see com.st.frpobcc.service.OpRoute_6Service#getCountDatePercentage(java.lang.String)
	 */
	@Override
	public long getCountDatePercentage(String sdate,String edate) throws Exception {
		// TODO Auto-generated method stub
		return oproute_6dao.getCountDatePercentage(sdate,edate);
	}

	/**
	 * @param endDate
	 * @param endDate2
	 * @return
	 * @throws Exception 
	 */
	public List<Integer> getCount(String sdate, String edate) throws Exception {
		// TODO Auto-generated method stub
		return oproute_6dao.getCount(sdate, edate);
	}

}

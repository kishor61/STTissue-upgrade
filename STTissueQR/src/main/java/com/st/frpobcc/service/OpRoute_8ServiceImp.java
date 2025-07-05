/**
 *06-Dec-2019
 *OpRoute_8ServiceImp.java
 * TODO
 *com.st.frpobcc.service
 *OpRoute_8ServiceImp.java
 *Sohan Lal Bairwa
 */
package com.st.frpobcc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.st.frpobcc.dao.OpRoute_8Dao;
import com.st.frpobcc.model.OpRoute_8;

/**
 * @author sohan
 *
 */
@Service
public class OpRoute_8ServiceImp implements OpRoute_8Service {

	@Autowired
	private OpRoute_8Dao oproute_8dao;
	/* (non-Javadoc)
	 * @see com.st.frpobcc.service.OpRoute_8Service#saveorUpdate(com.st.frpobcc.model.OpRoute_8)
	 */
	@Override
	public void saveorUpdate(OpRoute_8 data) {
		oproute_8dao.saveorUpdate(data);
	}
	/**
	 * @param date
	 * @return
	 */
	public List<OpRoute_8> getData(String sdate,String edate) {
		// TODO Auto-generated method stub
		return oproute_8dao.getData(sdate,edate);
	}
	/* (non-Javadoc)
	 * @see com.st.frpobcc.service.OpRoute_8Service#getCountDatePercentage(java.lang.String)
	 */
	@Override
	public long getCountDatePercentage(String sdate,String edate) throws Exception {
		// TODO Auto-generated method stub
		return oproute_8dao.getCountDatePercentage(sdate,edate);
	}
	/**
	 * @param endDate
	 * @param endDate2
	 * @return
	 * @throws Exception 
	 */
	public List<Integer> getCount(String sdate, String edate) throws Exception {
		// TODO Auto-generated method stub
		return oproute_8dao.getCount(sdate, edate);
	}

}

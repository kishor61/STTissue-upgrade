/**
 *May 10, 2021
 *R2WaterJetsDownServiceimpl.java
 * TODO
 *com.st.obccPM5.service
 *R2WaterJetsDownServiceimpl.java
 *Sohan Lal 
 */
package com.st.obccPM5.service;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.st.obccPM5.dao.R2WaterJetsDownDao;
import com.st.obccPM5.model.R2WaterJetsDown;

/**
 * @author Sohanlal
 *
 */
@Service
public class R2WaterJetsDownServiceimpl implements R2WaterJetsDownService {

	@Autowired
	private R2WaterJetsDownDao r2OperatorPM5Dao;
	
	
	/* (non-Javadoc)
	 * @see com.st.obccPM5.service.R1OperatorPM5Service#saveorUpdate(com.st.obcc.model.R1Operator)
	 */
	@Override
	public void saveorUpdate(R2WaterJetsDown data) {
		
		r2OperatorPM5Dao.saveorUpdate(data);
	}


	/* (non-Javadoc)
	 * @see com.st.oBcc1pm5.service.R1OperatorPM5Service#getOperatorDataList(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public List<R2WaterJetsDown> getOperatorDataList(String position,String shift,String sdate, String edate) {
		
		return r2OperatorPM5Dao.getOperatorDataList(position,shift,sdate,edate);
	}
	@Override
	public List<R2WaterJetsDown> getOperatorDataListForBothShift(String position,String sdate, String edate) {
		
		return r2OperatorPM5Dao.getOperatorDataListForBothShift(position,sdate,edate);
	}


	/* (non-Javadoc)
	 * @see com.st.oBcc1pm5.service.R1OperatorPM5Service#getDataCountDatePercentage(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public long getDataCountDatePercentage(String position,String shift, String startDate,String endDate) throws ParseException {
		
		return  r2OperatorPM5Dao.getDataCountDatePercentage(position,startDate,endDate,shift);
	}


	/* (non-Javadoc)
	 * @see com.st.obccPM5.service.R1OperatorPM5Service#getOperatorData(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public R2WaterJetsDown getOperatorData(String position, String shift, String date, String crew) {
		// TODO Auto-generated method stub
		return  r2OperatorPM5Dao.getOperatorData(position, shift, date, crew);
	}

}

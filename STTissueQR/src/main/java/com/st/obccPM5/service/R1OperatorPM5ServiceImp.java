/**
 *Oct 22, 2019
 *R1OperatorPM5ServiceImp.java
 * TODO
 *com.st.obccPM5.service
 *R1OperatorPM5ServiceImp.java
 *Roshan Lal Tailor
 */
package com.st.obccPM5.service;


import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.st.obccPM5.dao.R1OperatorPM5Dao;
import com.st.obccPM5.model.R1OperatorPM5;
/**
 * @author sohan
 *
 */
@Service
public class R1OperatorPM5ServiceImp implements R1OperatorPM5Service {

	@Autowired
	private R1OperatorPM5Dao r1OperatorPM5Dao;
	
	
	/* (non-Javadoc)
	 * @see com.st.obccPM5.service.R1OperatorPM5Service#saveorUpdate(com.st.obcc.model.R1Operator)
	 */
	@Override
	public void saveorUpdate(R1OperatorPM5 data) {
		
		r1OperatorPM5Dao.saveorUpdate(data);
	}

	@Override
	public List<R1OperatorPM5> getOperatorDataListForBothShift(String position,String sdate, String edate) {
		
		return r1OperatorPM5Dao.getOperatorDataListForBothShift(position,sdate,edate);
	}
	@Override
	public List<R1OperatorPM5> getOperatorDataList(String position,String shift,String sdate, String edate) {
		
		return r1OperatorPM5Dao.getOperatorDataList(position,shift,sdate,edate);
	}


	/* (non-Javadoc)
	 * @see com.st.oBcc1pm5.service.R1OperatorPM5Service#getDataCountDatePercentage(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public long getDataCountDatePercentage(String position, String startDate,String endDate,String shift) throws ParseException {
		
		return  r1OperatorPM5Dao.getDataCountDatePercentage(position,startDate,endDate,shift);
	}


	/* (non-Javadoc)
	 * @see com.st.obccPM5.service.R1OperatorPM5Service#getOperatorData(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public R1OperatorPM5 getOperatorData(String position, String shift, String date, String crew) {
		// TODO Auto-generated method stub
		return  r1OperatorPM5Dao.getOperatorData(position, shift, date, crew);
	}

	
}

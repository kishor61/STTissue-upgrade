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

import com.st.obccPM5.dao.R1WaterJetsDownDao;
import com.st.obccPM5.model.R1WaterJetsDown;
/**
 * @author sohan
 *
 */
@Service
public class R1WaterJetsDownServiceImp implements R1WaterJetsDownService {

	@Autowired
	private R1WaterJetsDownDao r1OperatorPM5Dao;
	
	
	/* (non-Javadoc)
	 * @see com.st.obccPM5.service.R1OperatorPM5Service#saveorUpdate(com.st.obcc.model.R1Operator)
	 */
	@Override
	public void saveorUpdate(R1WaterJetsDown data) {
		
		r1OperatorPM5Dao.saveorUpdate(data);
	}


	/* (non-Javadoc)
	 * @see com.st.oBcc1pm5.service.R1OperatorPM5Service#getOperatorDataList(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public List<R1WaterJetsDown> getOperatorDataList(String position,String shift,String sdate, String edate) {
		
		return r1OperatorPM5Dao.getOperatorDataList(position,shift,sdate,edate);
	}
	@Override
	public List<R1WaterJetsDown> getOperatorDataListForBothShift(String position,String sdate, String edate) {
		
		return r1OperatorPM5Dao.getOperatorDataListForBothShift(position,sdate,edate);
	}

	/* (non-Javadoc)
	 * @see com.st.oBcc1pm5.service.R1OperatorPM5Service#getDataCountDatePercentage(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public long getDataCountDatePercentage(String position,String shift, String startDate,String endDate) throws ParseException {
		
		return  r1OperatorPM5Dao.getDataCountDatePercentage(position,startDate,endDate,shift);
	}


	/* (non-Javadoc)
	 * @see com.st.obccPM5.service.R1OperatorPM5Service#getOperatorData(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public R1WaterJetsDown getOperatorData(String position, String shift, String date, String crew) {
		// TODO Auto-generated method stub
		return  r1OperatorPM5Dao.getOperatorData(position, shift, date, crew);
	}

	
}

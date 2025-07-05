/**
 *Oct 21, 2019
 *LeadOperatorPM5ServiceImp.java
 * TODO
 *com.st.obccPM5.service
 *LeadOperatorPM5ServiceImp.java
 *Roshan Lal Tailor
 */
package com.st.obccPM5.service;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.st.obccPM5.dao.LeadOperatorPM5Dao;
import com.st.obccPM5.model.LeadOperatorPM5;

/**
 * @author roshan
 *
 */
@Service
public  class LeadOperatorPM5ServiceImp implements LeadOperatorPM5Service {
	
	@Autowired
	private LeadOperatorPM5Dao leadOperatorPM5Dao;
	

	/* (non-Javadoc)
	 * @see com.st.oBcc1pm5.service.LeadOperatorPM5Service#saveorUpdate(com.st.oBcc1pm5.model.LeadOperatorPM5)
	 */
	@Override
	public void saveorUpdate(LeadOperatorPM5 data) {

		
		leadOperatorPM5Dao.saveorUpdate(data);
	}


	/* (non-Javadoc)
	 * @see com.st.oBcc1pm5.service.LeadOperatorPM5Service#getOperatorData(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public LeadOperatorPM5 getOperatorData(String position, String date,
			String shift)throws Exception {
		
		return leadOperatorPM5Dao.getOperatorData(position, date,shift);
	}

	/* (non-Javadoc)
	 * @see com.st.oBcc1pm5.service.LeadOperatorPM5Service#getOperatorDataList(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public List<LeadOperatorPM5> getOperatorDataList(String position,
			String sdate, String edate,String shift) {
		
		return leadOperatorPM5Dao.getOperatorDataList(position, sdate, edate,shift);
	}


	/* (non-Javadoc)
	 * @see com.st.oBcc1pm5.service.LeadOperatorPM5Service#getDataCountDatePercentage(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public long getDataCountDatePercentage(String position, String startDate,String endDate,String shift) throws ParseException {
		 
		return leadOperatorPM5Dao.getDataCountDatePercentage(position, startDate,endDate,shift);
	}

}

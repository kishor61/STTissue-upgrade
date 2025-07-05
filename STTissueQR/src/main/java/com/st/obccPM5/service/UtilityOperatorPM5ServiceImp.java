/**
 *Mar 17, 2018
 *UtilityOperatorPM5ServiceImpl.java
 * TODO
 *com.st.obccPM5.service
 *UtilityOperatorPM5ServiceImpl.java
 *Roshan Lal Tailor
 */
package com.st.obccPM5.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.st.obccPM5.dao.UtilityOperatorPM5Dao;
import com.st.obccPM5.model.UtilityOperatorPM5;

/**
 * @author roshan
 *
 */
@Service
public class UtilityOperatorPM5ServiceImp implements UtilityOperatorPM5Service{

	@Autowired
	private UtilityOperatorPM5Dao utilityOperatorPM5Dao;
	@Transactional
	@Override
	public void saveorUpdate(UtilityOperatorPM5 data) {

		utilityOperatorPM5Dao.saveorUpdate(data);

	}
	@Transactional
	@Override
	public UtilityOperatorPM5 getOperatorData(String position, String date,
			String shift, String crew) throws Exception {
		// TODO Auto-generated method stub
		return utilityOperatorPM5Dao.getOperatorData(position, shift, date, crew);
	}
	
	
	@Override
	@Transactional
	public long getDataCountDatePercentage(String position, String shift,String Sdate,
			String edate) throws Exception {
		// TODO Auto-generated method stub
		return utilityOperatorPM5Dao.getDataCountDatePercentage(position,shift, Sdate, edate);
	}

	@Override
	public List<UtilityOperatorPM5> getOperatorDataList(String position, String shift, String sdate,
			String edate) throws Exception {
		// TODO Auto-generated method stub
		return utilityOperatorPM5Dao.getOperatorDataList(position, shift,sdate, edate);
	}
	@Override
	public List<UtilityOperatorPM5> getOperatorDataListForBothShift(String position,String sdate,String edate) throws Exception {
		// TODO Auto-generated method stub
		return utilityOperatorPM5Dao.getOperatorDataListForBothShift(position, sdate, edate);
	}
 
}

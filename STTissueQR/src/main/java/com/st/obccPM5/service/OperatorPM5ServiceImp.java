/**
 *Oct 24, 2019
 *OperatorPM5ServiceImp.java
 * TODO
 *com.st.obccPM5.service
 *OperatorPM5ServiceImp.java
 *Roshan Lal Tailor
 */
package com.st.obccPM5.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.st.obccPM5.dao.OperatorPM5Dao;
import com.st.obccPM5.model.OperatorPM5;

/**
 * @author roshan
 *
 */
@Service
public class OperatorPM5ServiceImp implements OperatorPM5Service {

	@Autowired
	private OperatorPM5Dao operatorPM5Dao;
	/* (non-Javadoc)
	 * @see com.st.oBcc1pm5.service.OperatorPM5Service#saveorUpdate(com.st.oBcc1pm5.model.OperatorPM5Data)
	 */
	@Override
	public void saveorUpdate(OperatorPM5 data) {
		
		
		
		operatorPM5Dao.saveorUpdate(data);

	}
	/* (non-Javadoc)
	 * @see com.st.oBcc1pm5.service.OperatorPM5Service#CheckObcc(java.lang.String, java.lang.String)
	 */
	@Override
	public boolean CheckObcc(String date, String position,String shift) {
		return operatorPM5Dao. CheckObcc(date,position,shift);
	}}

/**
 * 
 */
package com.st.tracker.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.st.common.exception.TrackerException;
import com.st.tracker.dao.BaleInventoryDao;

/**
 * @author sbora
 *
 */
@Service
public class BaleInventoryServiceImp implements BaleInventoryService {

	@Autowired
	private BaleInventoryDao baleInventoryDao;
	
	@Transactional
	public double getConsumedWetLap(Date sdate, Date edate) throws TrackerException {
		
		return baleInventoryDao.getConsumedWetLap(sdate, edate);
	}

}

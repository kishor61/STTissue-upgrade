/**
 *May 7, 2021
 *WinderDownService.java
 * TODO
 *com.st.obccPM5.service
 *WinderDownService.java
 *Sohan Lal 
 */
package com.st.obccPM5.service;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.st.obccPM5.dao.WinderDownDao;
import com.st.obccPM5.model.WinderDown;

/**
 * @author Sohanlal
 *
 */
@Service
public class WinderDownServiceImpl implements WinderDownService{
	@Autowired
	private WinderDownDao winderDownDao;
	
	@Override
	public void saveorUpdate(WinderDown data) {
		
		winderDownDao.saveorUpdate(data);
	}
	@Override
	public long getDataCountDatePercentage(String position,String shift, String sdate, String edate )
			throws ParseException {
		// TODO Auto-generated method stub
		return winderDownDao.getDataCountDatePercentage(position, sdate, edate, shift);
	}
	@Override
	public List<WinderDown> getOperatorDataList(String position, String shift, String sdate, String edate) {
		// TODO Auto-generated method stub
		return winderDownDao.getOperatorDataList(position, sdate, edate, shift);
	}
	@Override
	public List<WinderDown> getOperatorDataListForBothShift(String position, String sdate, String edate) {
		// TODO Auto-generated method stub
		return winderDownDao.getOperatorDataListForBothShift(position, sdate, edate);
	}
	
	@Override
	public WinderDown getOperatorData(String position, String shift, String date, String crew) {
		// TODO Auto-generated method stub
		return winderDownDao.getOperatorData(position, shift,date,crew);
	}

}

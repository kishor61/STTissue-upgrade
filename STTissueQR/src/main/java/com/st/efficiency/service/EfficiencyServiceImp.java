/**
 * 
 */
package com.st.efficiency.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.st.efficiency.dao.EfficiencyDao;
import com.st.efficiency.model.Efficiency;
import com.st.efficiency.model.EfficiencyShiftData;

/**
 * @author sbora
 *
 */
@Service
public class EfficiencyServiceImp implements EfficiencyService {

	@Autowired
	private EfficiencyDao efficencyDao;

	@Transactional
	@Override
	public int add(Efficiency efficency) {
		return efficencyDao.add(efficency);
	}

	@Transactional
	@Override
	public List<Efficiency> getEfficiencies(Efficiency efficiency) {
		return efficencyDao.getEfficiencies(efficiency);
	}

	@Transactional
	@Override
	public Efficiency getEfficiency(int id) {
		return efficencyDao.getEfficiency(id);
	}

	@Transactional
	@Override
	public void update(Efficiency efficency) {
		efficencyDao.update(efficency);
	}

	@Transactional
	@Override
	public void delete(int id) {
		efficencyDao.delete(id);
	}

	/* (non-Javadoc)
	 * @see com.st.efficiency.service.EfficiencyService#getEfficiencyShiftData(java.util.Date, java.util.Date, java.lang.String)
	 */
	@Transactional
	@Override
	public List<EfficiencyShiftData> getEfficiencyShiftData(Date sdate,
			Date edate, String shift) {
		return efficencyDao.getEfficiencyShiftData(sdate,edate,shift);
	}

	/* (non-Javadoc)
	 * @see com.st.efficiency.service.EfficiencyService#getEfficiencyDCSDataReport(java.util.Date, java.util.Date, java.lang.String)
	 */
	@Transactional
	@Override
	public List<EfficiencyShiftData> getEfficiencyDCSDataReport(Date sdate,Date edate) {
		// TODO Auto-generated method stub
		return efficencyDao.getEfficiencyDCSDataReport(sdate,edate);
	}

	/* (non-Javadoc)
	 * @see com.st.efficiency.service.EfficiencyService#saveDCSData(com.st.efficiency.model.EfficiencyShiftData)
	 */
	@Transactional
	@Override
	public int saveDCSData(EfficiencyShiftData eSD) {
		// TODO Auto-generated method stub
		return efficencyDao.saveDCSData(eSD);
	}

	/* (non-Javadoc)
	 * @see com.st.efficiency.service.EfficiencyService#checkTonPresentOrNot(java.util.Date, java.lang.String)
	 */
	@Transactional
	@Override
	public List<EfficiencyShiftData> checkTonPresentOrNot(Date sdate,String shift) {
		// TODO Auto-generated method stub
		return efficencyDao.checkTonPresentOrNot(sdate,shift);
	}

	/* (non-Javadoc)
	 * @see com.st.efficiency.service.EfficiencyService#editDCSReport(int)
	 */
	@Transactional
	@Override
	public List<EfficiencyShiftData> editDCSReport(int id) {
		// TODO Auto-generated method stub
		return efficencyDao.editDCSReport(id);
	}

	/* (non-Javadoc)
	 * @see com.st.efficiency.service.EfficiencyService#updateDCSData(com.st.efficiency.model.EfficiencyShiftData)
	 */
	@Transactional
	@Override
	public void updateDCSData(EfficiencyShiftData eSD) {
		// TODO Auto-generated method stub
		efficencyDao.updateDCSData(eSD);
	}

}

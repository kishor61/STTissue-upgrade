/**
 * 
 */
package com.st.efficiencypm5.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.st.efficiencypm5.dao.EfficiencyDaoPM5;
import com.st.efficiencypm5.model.EfficiencyPM5;
import com.st.efficiencypm5.model.EfficiencyShiftDataPM5;

/**
 * @author sbora
 *
 */
@Service
public class EfficiencyServiceImpPM5 implements EfficiencyServicePM5 {

	@Autowired
	private EfficiencyDaoPM5 efficencyDao;

	@Transactional
	@Override
	public int add(EfficiencyPM5 efficency) {
		return efficencyDao.add(efficency);
	}

	@Transactional
	@Override
	public List<EfficiencyPM5> getEfficiencies(EfficiencyPM5 efficiency) {
		return efficencyDao.getEfficiencies(efficiency);
	}

	@Transactional
	@Override
	public EfficiencyPM5 getEfficiency(int id) {
		return efficencyDao.getEfficiency(id);
	}

	@Transactional
	@Override
	public void update(EfficiencyPM5 efficency) {
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
	public List<EfficiencyShiftDataPM5> getEfficiencyShiftData(Date sdate,
			Date edate, String shift) {
		return efficencyDao.getEfficiencyShiftData(sdate,edate,shift);
	}

	/* (non-Javadoc)
	 * @see com.st.efficiency.service.EfficiencyService#getEfficiencyDCSDataReport(java.util.Date, java.util.Date, java.lang.String)
	 */
	@Transactional
	@Override
	public List<EfficiencyShiftDataPM5> getEfficiencyDCSDataReport(Date sdate,Date edate) {
		// TODO Auto-generated method stub
		return efficencyDao.getEfficiencyDCSDataReport(sdate,edate);
	}

	/* (non-Javadoc)
	 * @see com.st.efficiency.service.EfficiencyService#saveDCSData(com.st.efficiency.model.EfficiencyShiftData)
	 */
	@Transactional
	@Override
	public int saveDCSData(EfficiencyShiftDataPM5 eSD) {
		// TODO Auto-generated method stub
		return efficencyDao.saveDCSData(eSD);
	}

	/* (non-Javadoc)
	 * @see com.st.efficiency.service.EfficiencyService#checkTonPresentOrNot(java.util.Date, java.lang.String)
	 */
	@Transactional
	@Override
	public List<EfficiencyShiftDataPM5> checkTonPresentOrNot(Date sdate,String shift) {
		// TODO Auto-generated method stub
		return efficencyDao.checkTonPresentOrNot(sdate,shift);
	}

	/* (non-Javadoc)
	 * @see com.st.efficiency.service.EfficiencyService#editDCSReport(int)
	 */
	@Transactional
	@Override
	public List<EfficiencyShiftDataPM5> editDCSReport(int id) {
		// TODO Auto-generated method stub
		return efficencyDao.editDCSReport(id);
	}

	/* (non-Javadoc)
	 * @see com.st.efficiency.service.EfficiencyService#updateDCSData(com.st.efficiency.model.EfficiencyShiftData)
	 */
	@Transactional
	@Override
	public void updateDCSData(EfficiencyShiftDataPM5 eSD) {
		// TODO Auto-generated method stub
		efficencyDao.updateDCSData(eSD);
	}

}

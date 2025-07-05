/**
 *Mar 21, 2018
 *KpiRecordableDatePM5ServiceImp.java
 * TODO
 *com.st.utilitykpimasterPM5.service
 *KpiRecordableDatePM5ServiceImp.java
 *Roshan Lal Tailor
 */
package com.st.utilitykpimasterPM5.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.st.utilitykpimaster.model.KpiRecordableDate;

/**
 * @author roshan
 *
 */
@Service
public class KpiRecordableDatePM5ServiceImp implements KpiRecordableDatePM5Service {

	@Autowired com.st.utilitykpimasterPM5.dao.KpiRecordableDatePM5Dao KpiRecordableDatePM5Dao;
	/* (non-Javadoc)
	 * @see com.st.utilitykpimasterPM5.service.KpiRecordableDatePM5Service#getKpiRecordableDate()
	 */
	@Override
	@Transactional
	public List<KpiRecordableDate> getKpiRecordableDate() {
		// TODO Auto-generated method stub
		return KpiRecordableDatePM5Dao.getKpiRecordableDate();
	}

	/* (non-Javadoc)
	 * @see com.st.utilitykpimasterPM5.service.KpiRecordableDatePM5Service#save(com.st.utilitykpimaster.model.KpiRecordableDate)
	 */
	@Override
	@Transactional
	public int save(KpiRecordableDate kpiRecordableDate) {
		// TODO Auto-generated method stub
		return KpiRecordableDatePM5Dao.save(kpiRecordableDate);
	}

	/* (non-Javadoc)
	 * @see com.st.utilitykpimasterPM5.service.KpiRecordableDatePM5Service#delete(int)
	 */
	@Override
	@Transactional
	public void delete(int id) {
		// TODO Auto-generated method stub
		KpiRecordableDatePM5Dao.delete(id);
	}

	/* (non-Javadoc)
	 * @see com.st.utilitykpimasterPM5.service.KpiRecordableDatePM5Service#getLastKpiRecordableDate()
	 */
	@Override
	public KpiRecordableDate getLastKpiRecordableDate() {
		// TODO Auto-generated method stub
		return null;
	}

}

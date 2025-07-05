/**
 * 
 */
package com.st.utilitykpimaster.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.st.utilitykpimaster.dao.KpiRecordableDateDao;
import com.st.utilitykpimaster.model.KpiRecordableDate;

/**
 * @author sbora
 *
 */
@Service
public class KpiRecordableDateServiceImp implements KpiRecordableDateService {

	@Autowired
	private KpiRecordableDateDao kpiRecordableDateDao;
	
	@Transactional
	@Override
	public int save(KpiRecordableDate kpiRecordableDate) {
		return kpiRecordableDateDao.save(kpiRecordableDate);
	}

	@Transactional
	@Override
	public List<KpiRecordableDate> getKpiRecordableDate() {
		return kpiRecordableDateDao.getKpiRecordableDate();
	}

	@Transactional
	@Override
	public void delete(int id) {
		kpiRecordableDateDao.delete(id);
	}

	@Transactional
	@Override
	public KpiRecordableDate getLastKpiRecordableDate() {
		return kpiRecordableDateDao.getLastKpiRecordableDate();
	}

}

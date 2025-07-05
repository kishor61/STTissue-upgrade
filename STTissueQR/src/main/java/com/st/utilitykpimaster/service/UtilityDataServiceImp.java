/**
 * 
 */
package com.st.utilitykpimaster.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.st.utilitykpimaster.dao.UtilityDataDao;
import com.st.utilitykpimaster.model.UtilityData;

/**
 * @author sbora
 *
 */
@Service
public class UtilityDataServiceImp implements UtilityDataService {

	@Autowired
	private UtilityDataDao utilityDataDao;
	
	@Transactional
	@Override
	public int save(UtilityData utilityData) {
		return utilityDataDao.save(utilityData);
	}

	@Transactional
	@Override
	public void update(UtilityData utilityData) {
		utilityDataDao.update(utilityData);
	}

	@Transactional
	@Override
	public UtilityData getPrevUtilityData(int id) {
		return utilityDataDao.getPrevUtilityData(id);
	}

	@Transactional
	@Override
	public List<UtilityData> getUtilityDatasL31() {
		return utilityDataDao.getUtilityDatasL31();
	}

	@Transactional
	@Override
	public void delete(int id) {
		utilityDataDao.delete(id);
	}

	@Transactional
	@Override
	public List<UtilityData> getPrevUtilityData(Date sdate, Date edate) {
		return utilityDataDao.getPrevUtilityData(sdate,edate);
	}

	@Transactional
	@Override
	public UtilityData getUtilityData(int id) {
		return utilityDataDao.getUtilityData(id);
	}

}

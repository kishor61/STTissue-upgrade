/**
 *Feb 1, 2018
 *UtilityDataServiceImpPM5.java
 * TODO
 *com.st.utilitykpimasterPM5.service
 *UtilityDataServiceImpPM5.java
 *Roshan Lal Tailor
 */
package com.st.utilitykpimasterPM5.service;

import java.lang.annotation.Target;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.st.utilitykpimaster.dao.UtilityDataDao;
import com.st.utilitykpimaster.model.UtilityData;
import com.st.utilitykpimasterPM5.dao.UtilityDataPM5Dao;

/**
 * @author roshan
 *
 */
@Service
public class UtilityDataServiceImpPM5 implements UtilityDataServicePM5 {

	@Autowired
	private UtilityDataPM5Dao utilityDataPM5Dao;
	
	/* (non-Javadoc)
	 * @see com.st.utilitykpimasterPM5.service.UtilityDataServicePM5#getUtilityDatasL31()
	 */
	@Override
	@Transactional
	public List<UtilityData> getUtilityDatasL31() {
		// TODO Auto-generated method stub
		return utilityDataPM5Dao.getUtilityDatasL31();
	}

	/* (non-Javadoc)
	 * @see com.st.utilitykpimasterPM5.service.UtilityDataServicePM5#getUtilityData(int)
	 */
	@Override
	@Transactional
	public UtilityData getUtilityData(int id) {
		// TODO Auto-generated method stub
		return utilityDataPM5Dao.getUtilityData(id);
	}

	/* (non-Javadoc)
	 * @see com.st.utilitykpimasterPM5.service.UtilityDataServicePM5#save(com.st.utilitykpimaster.model.UtilityData)
	 */
	@Override
	@Transactional
	public int save(UtilityData utilityData) {
		// TODO Auto-generated method stub
		return utilityDataPM5Dao.save(utilityData);
	}

	/* (non-Javadoc)
	 * @see com.st.utilitykpimasterPM5.service.UtilityDataServicePM5#getPrevUtilityData(int)
	 */
	@Override
	@Transactional
	public UtilityData getPrevUtilityData(int id) {
		// TODO Auto-generated method stub
		return utilityDataPM5Dao.getPrevUtilityData(id);
	}

	/* (non-Javadoc)
	 * @see com.st.utilitykpimasterPM5.service.UtilityDataServicePM5#update(com.st.utilitykpimaster.model.UtilityData)
	 */
	@Override
	@Transactional
	public void update(UtilityData utilityData) {
		// TODO Auto-generated method stub
		utilityDataPM5Dao.update(utilityData);
	}

	/* (non-Javadoc)
	 * @see com.st.utilitykpimasterPM5.service.UtilityDataServicePM5#delete(int)
	 */
	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		utilityDataPM5Dao.delete(id);
	}

	/* (non-Javadoc)
	 * @see com.st.utilitykpimasterPM5.service.UtilityDataServicePM5#getPrevUtilityData(java.util.Date, java.util.Date)
	 */
	@Override
	public List<UtilityData> getPrevUtilityData(Date sdate, Date edate) {
		// TODO Auto-generated method stub
		return utilityDataPM5Dao.getPrevUtilityData(sdate,edate);
	}

}

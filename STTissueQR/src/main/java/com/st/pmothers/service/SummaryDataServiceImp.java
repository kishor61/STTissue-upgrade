/**
 *Dec 1, 2014
 *SummaryDataServiceImp.java
 * TODO
 *com.st.pmothers.service
 *SummaryDataServiceImp.java
 *Sunil Singh Bora
 */
package com.st.pmothers.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.st.pmothers.dao.SummaryDataDao;
import com.st.pmothers.model.SummaryData;

/**
 * @author sbora
 *
 */
@Service
public class SummaryDataServiceImp implements SummaryDataService {

	@Autowired
	private SummaryDataDao summaryDataDao;
	
	
	

	/* (non-Javadoc)
	 * @see com.st.pmothers.service.SummaryDataService#saveOrUpdate(com.st.pmothers.model.SummaryData)
	 */
	@Transactional
	@Override
	public int saveOrUpdate(SummaryData summaryData) {
		return summaryDataDao.saveOrUpdate(summaryData);
	}

	/* (non-Javadoc)
	 * @see com.st.pmothers.service.SummaryDataService#getDateList(java.util.Date, java.util.Date)
	 */
	@Transactional
	@Override
	public List<Map<String, Object>> getDateList(Date sdate, Date edate) {
		return summaryDataDao.getDateList(sdate,edate);
	}

	/* (non-Javadoc)
	 * @see com.st.pmothers.service.SummaryDataService#getSummaryData(int)
	 */
	@Transactional
	@Override
	public SummaryData getSummaryData(int id) {
		return summaryDataDao.getSummaryData(id);
	}

	/* (non-Javadoc)
	 * @see com.st.pmothers.service.SummaryDataService#getMonthToDateData(java.util.Date)
	 */
	@Transactional
	@Override
	public SummaryData getMonthToDateData(Date date) {

		
		return summaryDataDao.getMonthToDateData(date);
	}

	/* (non-Javadoc)
	 * @see com.st.pmothers.service.SummaryDataService#delete(int)
	 */
	@Transactional
	@Override
	public void delete(int id) {
		summaryDataDao.delete(id);
	} 
}

/**
 *Sep 12, 2017
 *DownTimeAndLostTimeReportServiceImp.java
 * TODO
 *com.st.downtimeandlosttimereport.service
 *DownTimeAndLostTimeReportServiceImp.java
 *Roshan Lal Tailor
 */
package com.st.downtimeandlosttimereport.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.st.downtimeandlosttimereport.dao.DownTimeAndLostTimeReportDao;
import com.st.downtimeandlosttimereport.model.DownTimeAndLostTimeReport;

/**
 * @author roshan
 *
 */
@Service
public class DownTimeAndLostTimeReportServiceImp implements DownTimeAndLostTimeReportService{

	@Autowired DownTimeAndLostTimeReportDao DownTimeAndLostTimeReportDao;
	/* (non-Javadoc)
	 * @see com.st.downtimeandlosttimereport.service.DownTimeAndLostTimeReportService#getDataDateWise()
	 */
	@Override
	@Transactional
	public List<DownTimeAndLostTimeReport> getDataDateWise(Date sDate, Date eDate) {
		// TODO Auto-generated method stub
		 return DownTimeAndLostTimeReportDao.getDataDateWise(sDate,eDate);
	}
	/* (non-Javadoc)
	 * @see com.st.downtimeandlosttimereport.service.DownTimeAndLostTimeReportService#getsecondaryCode()
	 */
	@Override
	public List<DownTimeAndLostTimeReport> getsecondaryCode() {
		// TODO Auto-generated method stub
		 return DownTimeAndLostTimeReportDao.getsecondaryCode();
	}

}

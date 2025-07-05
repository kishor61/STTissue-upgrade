/**
 *May 25, 2021
 *EmergencyServiceImpl.java
 * TODO
 *com.st.Emergency.Service
 *EmergencyServiceImpl.java
 *Sohan Lal 
 */
package com.st.Emergency.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.st.Emergency.dao.EmergencyDao;
import com.st.Emergency.model.EmergencyIncident;
import com.st.Emergency.model.IncidentReport;

/**
 * @author kishore
 *
 */
@Service
public class EmergencyServiceImpl implements EmergencyService {
	
	@Autowired
	private EmergencyDao emergencyDao;
	
	public void saveorUpdate(EmergencyIncident data) {
		int i=emergencyDao.saveorUpdate(data);
		System.out.println(i);
	}
	@Override
	public List<EmergencyIncident> getData(String sdate,String edate)
	{
		return emergencyDao.getData(sdate,edate);
	}
	/* (non-Javadoc)
	 * @see com.st.Emergency.service.EmergencyService#getData(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public List<EmergencyIncident> getData(String sdate, String edate, String status, String starIncidentLocation,
			String incidentType,String locationIncidentOccured,String team) {		
			return emergencyDao.getData( sdate, edate ,  status,starIncidentLocation,incidentType, locationIncidentOccured,team);	
		
	}
	/* (non-Javadoc)
	 * @see com.st.Emergency.service.EmergencyService#getData(int)
	 */
	@Override
	public List<EmergencyIncident> getData(int id) {
		// TODO Auto-generated method stub
		return emergencyDao.getData(id);
	}
	/* (non-Javadoc)
	 * @see com.st.Emergency.service.EmergencyService#updateViewStatus()
	 */
	@Override
	public void updateViewStatus(int id) {
		// TODO Auto-generated method stub
		 emergencyDao.updateViewStatus(id);
	}
	/* (non-Javadoc)
	 * @see com.st.Emergency.service.EmergencyService#incidentReportSaveorUpdate(com.st.Emergency.model.IncidentReport)
	 */
	@Override
	public Integer incidentReportSaveorUpdate(IncidentReport incidentReport) {
		return emergencyDao.incidentReportSaveorUpdate(incidentReport);
	}
	/* (non-Javadoc)
	 * @see com.st.Emergency.service.EmergencyService#getIncidentReportData(int)
	 */
	@Override
	public IncidentReport getIncidentReportData(int id) {
		// TODO Auto-generated method stub
		return emergencyDao.getIncidentReportData(id);
	}
	/* (non-Javadoc)
	 * @see com.st.Emergency.service.EmergencyService#saveorUpdate(com.st.Emergency.model.EmergencyIncident, com.st.Emergency.model.IncidentReport)
	 */
	@Override
	@Transactional
	public int saveorUpdate(EmergencyIncident emergencyIncident, IncidentReport incidentReport) {
		int i=0,j=0;
		int id=0;
		try {
			i=emergencyDao.saveorUpdate(emergencyIncident);
			
			if(i>0)
			{
			   List<EmergencyIncident>  lst= emergencyDao.getData();
			   id=lst.get(0).getId();
				 incidentReport.setEmergencyIncidentID(id);
				j=emergencyDao.incidentReportSaveorUpdate(incidentReport);
			if(j==0)
				emergencyDao.deleteData(id);
			}
		}catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
			emergencyDao.deleteData(id);
			return 0;
		}
		
		return j;
	}
	
}

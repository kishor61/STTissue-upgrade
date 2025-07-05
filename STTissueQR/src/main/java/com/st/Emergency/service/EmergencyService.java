/**
 *May 25, 2021
 *EmergencyService.java
 * TODO
 *com.st.Emergency.Service
 *EmergencyService.java
 *Sohan Lal 
 */
package com.st.Emergency.service;

import java.util.List;

import com.st.Emergency.model.EmergencyIncident;
import com.st.Emergency.model.IncidentReport;

/**
 * @author kishore
 *
 */
public interface EmergencyService {
	public void saveorUpdate(EmergencyIncident data);

	List<EmergencyIncident> getData(String sdate, String edate);

	

	/**
	 * @param id
	 * @return
	 */
	public List<EmergencyIncident> getData(int id);

	/**
	 * @param sdate
	 * @param edate
	 * @param status
	 * @param starIncidentLocation
	 * @param incidentType
	 * @return
	 */
	public List<EmergencyIncident> getData(String sdate, String edate, String status, String starIncidentLocation,
			String incidentType,String locationIncidentOccured,String team);

	/**
	 * @param id 
	 * 
	 */
	public void updateViewStatus(int id);

	/**
	 * @param incidentReport
	 * @return 
	 */
	public Integer incidentReportSaveorUpdate(IncidentReport incidentReport);

	/**
	 * @param id
	 * @return
	 */
	public IncidentReport getIncidentReportData(int id);

	/**
	 * @param emergencyIncident
	 * @param incidentReport
	 */
	public int saveorUpdate(EmergencyIncident emergencyIncident, IncidentReport incidentReport);
}
 

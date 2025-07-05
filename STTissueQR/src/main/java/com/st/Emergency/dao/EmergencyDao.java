/**
 *May 25, 2021
 *EmergencyService.java
 * TODO
 *com.st.Emergency.Service
 *EmergencyService.java
 *Sohan Lal 
 */
package com.st.Emergency.dao;

import java.util.List;

import com.st.Emergency.model.EmergencyIncident;
import com.st.Emergency.model.IncidentReport;

/**
 * @author kishore
 *
 */
public interface EmergencyDao {
	public Integer saveorUpdate(EmergencyIncident data);

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
	 * @param sdate
	 * @param edate
	 * @return
	 */
	public List<EmergencyIncident> getDataWithDate(String sdate, String edate);

	/**
	 * @param id 
	 * @return
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
	 * @return
	 */
	public IncidentReport getIncidentReportDataTop1();

	/**
	 * @return
	 */
	List<EmergencyIncident> getData();

	/**
	 * @param id
	 */
	public void deleteData(int id);
}
 

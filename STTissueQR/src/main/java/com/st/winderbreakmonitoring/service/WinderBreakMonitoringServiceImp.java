/**
 *Oct 30, 2015
 *WinderBreakMonitoringServiceImp.java
 * TODO
 *com.st.winderbreakmonitoring.service
 *WinderBreakMonitoringServiceImp.java
 *Sunil Singh Bora
 */
package com.st.winderbreakmonitoring.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.st.winderbreakmonitoring.model.WinderBreakMonitoring;
import com.st.winderbreakmonitoring.dao.*;
/**
 * @author roshan
 *
 */
@Service
public class WinderBreakMonitoringServiceImp implements WinderBreakMonitoringService {

	@Autowired
	private WinderBreakMonitoringDao winderbreakmonitoringdao;
	/* (non-Javadoc)
	 * @see com.st.winderbreakmonitoring.service.WinderBreakMonitoringService#getWinderBreakData(java.util.Date, java.util.Date)
	 */
	@Transactional
	@Override
	public List<WinderBreakMonitoring> getWinderBreakData(Date sdate, Date edate) {
		// TODO Auto-generated method stub
		return winderbreakmonitoringdao.getWinderBreakData(sdate,edate);
	}
	/* (non-Javadoc)
	 * @see com.st.winderbreakmonitoring.service.WinderBreakMonitoringService#save(com.st.winderbreakmonitoring.model.WinderBreakMonitoring)
	 */
	@Transactional
	@Override
	public int save(WinderBreakMonitoring wm) {
		// TODO Auto-generated method stub
		return winderbreakmonitoringdao.save(wm);
	}
	/* (non-Javadoc)
	 * @see com.st.winderbreakmonitoring.service.WinderBreakMonitoringService#update(com.st.winderbreakmonitoring.model.WinderBreakMonitoring)
	 */
	@Transactional
	@Override
	public void update(WinderBreakMonitoring wm) {
		// TODO Auto-generated method stub
		winderbreakmonitoringdao.update(wm);
		
	}
	/* (non-Javadoc)
	 * @see com.st.winderbreakmonitoring.service.WinderBreakMonitoringService#getWinderBreakMonitoringReport(java.util.Date, java.util.Date)
	 */
	@Transactional
	@Override
	public List<WinderBreakMonitoring> getWinderBreakMonitoringReport(
			Date sdate, Date edate) {
		// TODO Auto-generated method stub
		return winderbreakmonitoringdao.getWinderBreakMonitoringReport(sdate,edate);
	}
	/* (non-Javadoc)
	 * @see com.st.winderbreakmonitoring.service.WinderBreakMonitoringService#delete(int)
	 */
	@Transactional
	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		winderbreakmonitoringdao.delete(id);
	}
	/* (non-Javadoc)
	 * @see com.st.winderbreakmonitoring.service.WinderBreakMonitoringService#getWinderBreakReason()
	 */
	@Transactional
	@Override
	public List<WinderBreakMonitoring> getWinderBreakReason() {
		// TODO Auto-generated method stub
		return winderbreakmonitoringdao.getWinderBreakReason();
	}
	/* (non-Javadoc)
	 * @see com.st.winderbreakmonitoring.service.WinderBreakMonitoringService#savebreakreason(com.st.winderbreakmonitoring.model.WinderBreakMonitoring)
	 */
	@Transactional
	@Override
	public int savebreakreason(WinderBreakMonitoring wm) {
		// TODO Auto-generated method stub
		return winderbreakmonitoringdao.savebreakreason(wm);
	}
	/* (non-Javadoc)
	 * @see com.st.winderbreakmonitoring.service.WinderBreakMonitoringService#getEditWinderBreakReason(int)
	 */
	@Transactional
	@Override
	public List<WinderBreakMonitoring> getEditWinderBreakReason(int id) {
		// TODO Auto-generated method stub
		return winderbreakmonitoringdao.getEditWinderBreakReason(id);
	}
	/* (non-Javadoc)
	 * @see com.st.winderbreakmonitoring.service.WinderBreakMonitoringService#updatebreakreason(com.st.winderbreakmonitoring.model.WinderBreakMonitoring)
	 */
	@Transactional
	@Override
	public void updatebreakreason(WinderBreakMonitoring wm) {
		// TODO Auto-generated method stub
		winderbreakmonitoringdao.updatebreakreason(wm);
	}
	/* (non-Javadoc)
	 * @see com.st.winderbreakmonitoring.service.WinderBreakMonitoringService#deleteBreakReason(int)
	 */
	@Transactional
	@Override
	public void deleteBreakReason(int id) {
		winderbreakmonitoringdao.deleteBreakReason(id);
		
	}
	/* (non-Javadoc)
	 * @see com.st.winderbreakmonitoring.service.WinderBreakMonitoringService#getWinderBreakDataOfID(int)
	 */
	@Transactional
	@Override
	public List<WinderBreakMonitoring> getWinderBreakDataOfID(int id) {
		// TODO Auto-generated method stub
		return winderbreakmonitoringdao.getWinderBreakDataOfID(id);
	}
	/* (non-Javadoc)
	 * @see com.st.winderbreakmonitoring.service.WinderBreakMonitoringService#savebreakreason1(com.st.winderbreakmonitoring.model.WinderBreakMonitoring)
	 */
	@Transactional
	@Override
	public int savebreakreason1(WinderBreakMonitoring wm) {
		// TODO Auto-generated method stub
		return winderbreakmonitoringdao.savebreakreason1(wm);
	}
	/* (non-Javadoc)
	 * @see com.st.winderbreakmonitoring.service.WinderBreakMonitoringService#updatebreakreason1(com.st.winderbreakmonitoring.model.WinderBreakMonitoring)
	 */
	@Transactional
	@Override
	public void updatebreakreason1(WinderBreakMonitoring wm) {
		// TODO Auto-generated method stub
		winderbreakmonitoringdao.updatebreakreason1(wm);
	}
	/* (non-Javadoc)
	 * @see com.st.winderbreakmonitoring.service.WinderBreakMonitoringService#getWinderSecondaryBreakReason()
	 */
	@Transactional
	@Override
	public List<WinderBreakMonitoring> getWinderSecondaryBreakReason() {
		// TODO Auto-generated method stub
		return winderbreakmonitoringdao.getWinderSecondaryBreakReason();
	}
	/* (non-Javadoc)
	 * @see com.st.winderbreakmonitoring.service.WinderBreakMonitoringService#getSecondaryReason(java.lang.String)
	 */
	@Transactional
	@Override
	public List<WinderBreakMonitoring> getSecondaryReason(String reasonforbreak) {
		// TODO Auto-generated method stub
		return winderbreakmonitoringdao.getSecondaryReason(reasonforbreak);
	}
	/* (non-Javadoc)
	 * @see com.st.winderbreakmonitoring.service.WinderBreakMonitoringService#getEditWinderBreakSecondaryReason(int)
	 */
	@Transactional
	@Override
	public List<WinderBreakMonitoring> getEditWinderBreakSecondaryReason(int id) {
		// TODO Auto-generated method stub
		return winderbreakmonitoringdao.getEditWinderBreakSecondaryReason(id);
	}
	/* (non-Javadoc)
	 * @see com.st.winderbreakmonitoring.service.WinderBreakMonitoringService#deleteBreakReason1(int)
	 */
	@Transactional
	@Override
	public void deleteBreakReason1(int id) {
		winderbreakmonitoringdao.deleteBreakReason1(id);
		
	}

}

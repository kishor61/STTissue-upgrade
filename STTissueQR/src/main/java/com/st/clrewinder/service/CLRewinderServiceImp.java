/**
 *May 1, 2017
 *CLRewinderServiceImp.java
 * TODO
 *com.st.clrewinder.service
 *CLRewinderServiceImp.java
 *Roshan Lal Tailor
 */
package com.st.clrewinder.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.st.clrewinder.dao.CLRewinderDao;
import com.st.clrewinder.model.CLRewinder;

/**
 * @author roshan
 *
 */
@Service
public class CLRewinderServiceImp implements CLRewinderService{

	@Autowired
	private CLRewinderDao winderbreakmonitoringdao;
	
	/* (non-Javadoc)
	 * @see com.st.clrewinder.service.CLRewinderService#getWinderBreakData(java.util.Date, java.util.Date)
	 */
	@Transactional
	@Override
	public List<CLRewinder> getWinderBreakData(Date sdate, Date edate) {
		// TODO Auto-generated method stub
		return winderbreakmonitoringdao.getWinderBreakData(sdate,edate);
	}

	/* (non-Javadoc)
	 * @see com.st.clrewinder.service.CLRewinderService#save(com.st.clrewinder.model.CLRewinder)
	 */
	@Transactional
	@Override
	public int save(CLRewinder wm) {
		// TODO Auto-generated method stub
		return winderbreakmonitoringdao.save(wm);
	}

	/* (non-Javadoc)
	 * @see com.st.clrewinder.service.CLRewinderService#update(com.st.clrewinder.model.CLRewinder)
	 */
	@Transactional
	@Override
	public void update(CLRewinder wm) {
		// TODO Auto-generated method stub
		winderbreakmonitoringdao.update(wm);
	}

	/* (non-Javadoc)
	 * @see com.st.clrewinder.service.CLRewinderService#getWinderBreakMonitoringReport(java.util.Date, java.util.Date)
	 */
	@Override
	@Transactional
	public List<CLRewinder> getWinderBreakMonitoringReport(Date sdate,
			Date edate) {
		// TODO Auto-generated method stub
		return winderbreakmonitoringdao.getWinderBreakMonitoringReport(sdate,edate);
	}

	/* (non-Javadoc)
	 * @see com.st.clrewinder.service.CLRewinderService#delete(int)
	 */
	@Override
	@Transactional
	public void delete(int id) {
		// TODO Auto-generated method stub
		winderbreakmonitoringdao.delete(id);
	}

	/* (non-Javadoc)
	 * @see com.st.clrewinder.service.CLRewinderService#getWinderBreakReason()
	 */
	@Override
	@Transactional
	public List<CLRewinder> getWinderBreakReason() {
		// TODO Auto-generated method stub
		return winderbreakmonitoringdao.getWinderBreakReason();
	}

	/* (non-Javadoc)
	 * @see com.st.clrewinder.service.CLRewinderService#savebreakreason(com.st.clrewinder.model.CLRewinder)
	 */
	@Override
	@Transactional
	public int savebreakreason(CLRewinder wm) {
		// TODO Auto-generated method stub
		return winderbreakmonitoringdao.savebreakreason(wm);
	}

	/* (non-Javadoc)
	 * @see com.st.clrewinder.service.CLRewinderService#getEditWinderBreakReason(int)
	 */
	@Override
	@Transactional
	public List<CLRewinder> getEditWinderBreakReason(int id) {
		// TODO Auto-generated method stub
		return winderbreakmonitoringdao.getEditWinderBreakReason(id);
	}

	/* (non-Javadoc)
	 * @see com.st.clrewinder.service.CLRewinderService#updatebreakreason(com.st.clrewinder.model.CLRewinder)
	 */
	@Override
	@Transactional
	public void updatebreakreason(CLRewinder wm) {
		// TODO Auto-generated method stub
		winderbreakmonitoringdao.updatebreakreason(wm);
	}

	/* (non-Javadoc)
	 * @see com.st.clrewinder.service.CLRewinderService#deleteBreakReason(int)
	 */
	@Override
	@Transactional
	public void deleteBreakReason(int id) {
		// TODO Auto-generated method stub
		winderbreakmonitoringdao.deleteBreakReason(id);
	}

	/* (non-Javadoc)
	 * @see com.st.clrewinder.service.CLRewinderService#getWinderBreakDataOfID(int)
	 */
	@Override
	@Transactional
	public List<CLRewinder> getWinderBreakDataOfID(int id) {
		// TODO Auto-generated method stub
		return winderbreakmonitoringdao.getWinderBreakDataOfID(id);
	}

	/* (non-Javadoc)
	 * @see com.st.clrewinder.service.CLRewinderService#savebreakreason1(com.st.clrewinder.model.CLRewinder)
	 */
	@Override
	@Transactional
	public int savebreakreason1(CLRewinder wm) {
		// TODO Auto-generated method stub
		return winderbreakmonitoringdao.savebreakreason1(wm);
	}

	/* (non-Javadoc)
	 * @see com.st.clrewinder.service.CLRewinderService#updatebreakreason1(com.st.clrewinder.model.CLRewinder)
	 */
	@Override
	@Transactional
	public void updatebreakreason1(CLRewinder wm) {
		// TODO Auto-generated method stub
		winderbreakmonitoringdao.updatebreakreason1(wm);
	}

	/* (non-Javadoc)
	 * @see com.st.clrewinder.service.CLRewinderService#getWinderSecondaryBreakReason()
	 */
	@Override
	@Transactional
	public List<CLRewinder> getWinderSecondaryBreakReason() {
		// TODO Auto-generated method stub
		return winderbreakmonitoringdao.getWinderSecondaryBreakReason();
	}

	/* (non-Javadoc)
	 * @see com.st.clrewinder.service.CLRewinderService#getSecondaryReason(java.lang.String)
	 */
	@Override
	public List<CLRewinder> getSecondaryReason(String reasonforbreak) {
		// TODO Auto-generated method stub
		return winderbreakmonitoringdao.getSecondaryReason(reasonforbreak);
	}

	/* (non-Javadoc)
	 * @see com.st.clrewinder.service.CLRewinderService#getEditWinderBreakSecondaryReason(int)
	 */
	@Override
	@Transactional
	public List<CLRewinder> getEditWinderBreakSecondaryReason(int id) {
		// TODO Auto-generated method stub
		return winderbreakmonitoringdao.getEditWinderBreakSecondaryReason(id);
	}

	/* (non-Javadoc)
	 * @see com.st.clrewinder.service.CLRewinderService#deleteBreakReason1(int)
	 */
	@Override
	@Transactional
	public void deleteBreakReason1(int id) {
		// TODO Auto-generated method stub
		winderbreakmonitoringdao.deleteBreakReason1(id);
	}

	/* (non-Javadoc)
	 * @see com.st.clrewinder.service.CLRewinderService#deleteSecondaryBreakReason(int)
	 */
	@Transactional
	@Override
	public void deleteSecondaryBreakReason(int id) {
		// TODO Auto-generated method stub
		winderbreakmonitoringdao.deleteSecondaryBreakReason(id);
	}

	/* (non-Javadoc)
	 * @see com.st.clrewinder.service.CLRewinderService#getWinderBreakReasonShow()
	 */
	@Override
	@Transactional
	public List<CLRewinder> getWinderBreakReasonShow() {
		// TODO Auto-generated method stub
		return winderbreakmonitoringdao.getWinderBreakReasonShow();
	}

	/* (non-Javadoc)
	 * @see com.st.clrewinder.service.CLRewinderService#getSecondaryReason()
	 */
	@Transactional
	@Override
	public List<CLRewinder> getSecondaryReason() {
		// TODO Auto-generated method stub
		return winderbreakmonitoringdao.getSecondaryReason();
	}

	/* (non-Javadoc)
	 * @see com.st.clrewinder.service.CLRewinderService#getPrimaryReason()
	 */
	@Transactional
	@Override
	public List<CLRewinder> getPrimaryReason() {
		// TODO Auto-generated method stub
		return winderbreakmonitoringdao.getPrimaryReason();
	}

	/* (non-Javadoc)
	 * @see com.st.clrewinder.service.CLRewinderService#getWinderSecondaryBreakReasonGroupBy()
	 */
	@Transactional
	@Override
	public List<CLRewinder> getWinderSecondaryBreakReasonGroupBy() {
		// TODO Auto-generated method stub
		return winderbreakmonitoringdao.getWinderSecondaryBreakReasonGroupBy();
	}

	/* (non-Javadoc)
	 * @see com.st.clrewinder.service.CLRewinderService#getWinderBreakReasonShowGroupBy()
	 */
	@Override
	@Transactional
	public List<CLRewinder> getWinderBreakReasonShowGroupBy() {
		// TODO Auto-generated method stub
		return winderbreakmonitoringdao.getWinderBreakReasonShowGroupBy();
	}

	/* (non-Javadoc)
	 * @see com.st.clrewinder.service.CLRewinderService#getEfficiencySummaryReportData(java.util.Date, java.util.Date, java.lang.String, java.lang.String)
	 */
	@Override
	@Transactional
	public List<CLRewinder> getEfficiencySummaryReportData(Date sdate, Date edate, String pcode, String scode,String primaryCode) {
		// TODO Auto-generated method stub
		return winderbreakmonitoringdao.getEfficiencySummaryReportData(sdate,edate,pcode,scode,primaryCode);
	}

	/* (non-Javadoc)
	 * @see com.st.clrewinder.service.CLRewinderService#getWinderBreakReasonPrimaryReason()
	 */
	@Override
	@Transactional
	public List<CLRewinder> getWinderBreakReasonPrimaryReason() {
		// TODO Auto-generated method stub
		return winderbreakmonitoringdao.getWinderBreakReasonPrimaryReason();
	}
	
	

}

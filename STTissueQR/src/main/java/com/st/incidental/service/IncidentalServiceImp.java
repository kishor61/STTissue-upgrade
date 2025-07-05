/**
 *Mar 27, 2018
 *IncidentalServiceImp.java
 * TODO
 *com.st.incidental.service
 *IncidentalServiceImp.java
 *Roshan Lal Tailor
 */
package com.st.incidental.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.st.incidental.dao.IncidentalDao;
import com.st.incidental.model.Incidental;

/**
 * @author roshan
 *
 */
@Service
public class IncidentalServiceImp implements IncidentalService{

	@Autowired
	private IncidentalDao incidentalDao;
	/* (non-Javadoc)
	 * @see com.st.incidental.service.IncidentalService#getUserAutiors()
	 */
	@Override
	@Transactional
	public List<Incidental> getUserAutiors() {
		// TODO Auto-generated method stub
		return incidentalDao.getUserAutiors();
	}
	/* (non-Javadoc)
	 * @see com.st.incidental.service.IncidentalService#saveOrUpdate(com.st.incidental.model.Incidental)
	 */
	@Override
	@Transactional
	public void saveOrUpdate(Incidental auditor) {
		// TODO Auto-generated method stub
		incidentalDao.saveOrUpdate(auditor);
	}
	/* (non-Javadoc)
	 * @see com.st.incidental.service.IncidentalService#getUserAuditor(int)
	 */
	@Override
	@Transactional
	public Incidental getUserAuditor(int id) {
		// TODO Auto-generated method stub
		return incidentalDao.getUserAuditor(id);
	}
	/* (non-Javadoc)
	 * @see com.st.incidental.service.IncidentalService#editAuditorStatus(com.st.incidental.model.Incidental)
	 */
	@Override
	@Transactional
	public void editAuditorStatus(Incidental data) {
		// TODO Auto-generated method stub
		incidentalDao.editAuditorStatus(data);
	}
	/* (non-Javadoc)
	 * @see com.st.incidental.service.IncidentalService#uploadDocuments(com.st.incidental.model.Incidental)
	 */
	@Override
	@Transactional
	public void uploadDocuments(Incidental auditor) {
		// TODO Auto-generated method stub
		incidentalDao.uploadDocuments(auditor);
	}
	/* (non-Javadoc)
	 * @see com.st.incidental.service.IncidentalService#getIncidentalReportData(java.util.Date, java.util.Date)
	 */
	@Override
	@Transactional
	public List<Incidental> getIncidentalReportData(Date sdate, Date edate) {
		// TODO Auto-generated method stub
		return incidentalDao.getIncidentalReportData(sdate,edate);
	}
	/* (non-Javadoc)
	 * @see com.st.incidental.service.IncidentalService#getUploadedFileById(int)
	 */
	@Override
	public List<Incidental> getUploadedFileById(int id) {
		// TODO Auto-generated method stub
		return incidentalDao.getUploadedFileById(id);
	}
	/* (non-Javadoc)
	 * @see com.st.incidental.service.IncidentalService#getLastUplodedDocId(java.lang.String)
	 */
	@Override
	@Transactional
	public int getLastUplodedDocId(String docid) {
		// TODO Auto-generated method stub
		return incidentalDao.getLastUplodedDocId(docid);
	}
	/* (non-Javadoc)
	 * @see com.st.incidental.service.IncidentalService#reviewAction(com.st.incidental.model.Incidental)
	 */
	@Override
	@Transactional
	public void reviewAction(Incidental incidental) {
		// TODO Auto-generated method stub
		incidentalDao.reviewAction(incidental);
	}
	/* (non-Javadoc)
	 * @see com.st.incidental.service.IncidentalService#checkDocumentIsReviewdOrNot(java.lang.String, int)
	 */
	@Override
	@Transactional
	public double checkDocumentIsReviewdOrNot(String name, int id) {
		// TODO Auto-generated method stub
		return incidentalDao.checkDocumentIsReviewdOrNot(name,id);
	}
	/* (non-Javadoc)
	 * @see com.st.incidental.service.IncidentalService#getReportReviewedActionsShow(java.util.Date, java.util.Date)
	 */
	@Override
	@Transactional
	public List<Incidental> getReportReviewedActionsShow(Date sdate, Date edate) {
		// TODO Auto-generated method stub
		return incidentalDao.getReportReviewedActionsShow(sdate,edate);
	}
	/* (non-Javadoc)
	 * @see com.st.incidental.service.IncidentalService#getReportReviewedActionsShow_Comment()
	 */
	@Override
	@Transactional
	public List<Incidental> getReportReviewedActionsShow_Comment() {
		// TODO Auto-generated method stub
		return incidentalDao.getReportReviewedActionsShow_Comment();
	}
	/* (non-Javadoc)
	 * @see com.st.incidental.service.IncidentalService#getUserAutiors_Active()
	 */
	@Override
	@Transactional
	public List<Incidental> getUserAutiors_Active() {
		// TODO Auto-generated method stub
		return incidentalDao.getUserAutiors_Active();
	}
	/* (non-Javadoc)
	 * @see com.st.incidental.service.IncidentalService#delete(int)
	 */
	@Override
	@Transactional
	public void delete(int id) {
		// TODO Auto-generated method stub
		incidentalDao.delete(id);
	}

}

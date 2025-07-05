/**
 *Mar 27, 2018
 *IncidentalDao.java
 * TODO
 *com.st.incidental.dao
 *IncidentalDao.java
 *Roshan Lal Tailor
 */
package com.st.incidental.dao;

import java.util.Date;
import java.util.List;

import com.st.incidental.model.Incidental;

/**
 * @author roshan
 *
 */
public interface IncidentalDao {

	/**
	 * @return
	 */
	List<Incidental> getUserAutiors();

	/**
	 * @param auditor
	 */
	void saveOrUpdate(Incidental auditor);

	/**
	 * @param id
	 * @return
	 */
	Incidental getUserAuditor(int id);

	/**
	 * @param data
	 */
	void editAuditorStatus(Incidental data);

	/**
	 * @param auditor
	 */
	void uploadDocuments(Incidental auditor);

	/**
	 * @param sdate
	 * @param edate
	 * @return
	 */
	List<Incidental> getIncidentalReportData(Date sdate, Date edate);

	/**
	 * @param id
	 * @return
	 */
	List<Incidental> getUploadedFileById(int id);

	/**
	 * @param docid
	 * @return
	 */
	int getLastUplodedDocId(String docid);

	/**
	 * @param incidental
	 */
	void reviewAction(Incidental incidental);

	/**
	 * @param name
	 * @param id
	 * @return
	 */
	double checkDocumentIsReviewdOrNot(String name, int id);

	/**
	 * @param sdate
	 * @param edate
	 * @return
	 */
	List<Incidental> getReportReviewedActionsShow(Date sdate, Date edate);

	/**
	 * @return
	 */
	List<Incidental> getReportReviewedActionsShow_Comment();

	/**
	 * @return
	 */
	List<Incidental> getUserAutiors_Active();

	/**
	 * @param id
	 */
	void delete(int id);

}

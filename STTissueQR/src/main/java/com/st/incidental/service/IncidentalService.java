/**
 *Mar 27, 2018
 *IncidentalService.java
 * TODO
 *com.st.incidental.service
 *IncidentalService.java
 *Roshan Lal Tailor
 */
package com.st.incidental.service;

import java.util.Date;
import java.util.List;

import com.st.incidental.model.Incidental;

/**
 * @author roshan
 *
 */
public interface IncidentalService {

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
	 * @return 
	 */
	void uploadDocuments(Incidental auditor);

	/**
	 * @param sDate
	 * @param eDate
	 * @return
	 */
	List<Incidental> getIncidentalReportData(Date sDate, Date eDate);

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
	 * @param sDate
	 * @param eDate
	 * @return
	 */
	List<Incidental> getReportReviewedActionsShow(Date sDate, Date eDate);

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

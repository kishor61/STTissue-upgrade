/**
 * 
 */
package com.st.oimnotes.service;

import java.util.Date;
import java.util.List;

import com.st.oimnotes.model.Category;
import com.st.oimnotes.model.FollowUp;
import com.st.oimnotes.model.FollowUpHistory;
import com.st.oimnotes.model.Summary;

/**
 * @author sbora
 *
 */
public interface OimNotesService {

	/**
	 * @param category
	 */
	void saveOrUpdate(Category category);

	/**
	 * @return
	 */
	List<Category> getCategory();

	/**
	 * @param id
	 * @return
	 */
	Category getCategory(int id);

	/**
	 * @param summaryObj
	 */
	void saveOrUpdate(Summary summary);

	/**
	 * @param categoryId
	 * @param d
	 * @return
	 */
	List<Summary> getSummaries(int categoryId, Date d, Date ed);

	/**
	 * @param id
	 * @return
	 */
	Summary getSummary(int id);

	/**
	 * @param id
	 */
	void deleteSummary(int id);

	/**
	 * @param followUpOb
	 */
	void saveOrUpdate(FollowUp followUpOb);

	/**
	 * @param sid
	 * @return
	 */
	List<FollowUp> getFollowUps(int sid);

	/**
	 * @param id
	 * @return
	 */
	FollowUp getFollowUp(int id);

	/**
	 * @param id
	 */
	void deleteFollowUp(int id);

	/**
	 * @param edate 
	 * @param sdate 
	 * @return
	 */
	List<Summary> getSummariesAll(Date sdate, Date edate);

	/**
	 * @param sdate
	 * @param edate
	 * @return
	 */
	List<Summary> getSummariesFolloUps(Date sdate, Date edate);

	/**
	 * @param category
	 * @param sdate
	 * @param edate
	 * @return
	 */
	List<Summary> getSummariesFolloUps(int category, Date sdate, Date edate);

	/**
	 * @param fid
	 * @return
	 */
	List<FollowUpHistory> getFollowUpHistory(int fid);

	/**
	 * @param closedBy 
	 * @param closed 
	 * @param id
	 */
	void closeFollowUp(Date closed, String closedBy, int id);

	/**
	 * @param sid
	 * @param tag
	 * @return
	 */
	List<FollowUp> getFollowUps(int sid, String tag);

	/**
	 * @param sDate
	 * @param eDate
	 * @return
	 */
	List<Summary> getSummariesDates(Date sDate, Date eDate);

	/**
	 * @param categoryId
	 * @param sDate
	 * @param eDate
	 * @return
	 */
	List<Summary> getSummariesDates(int categoryId, Date sDate, Date eDate);

	/**
	 * @return
	 */
	List<Summary> getOpenSummariesFolloUps();

	/**
	 * @param id
	 * @param string
	 * @param notes
	 */
	void addFollowUpChangeHistory(int id, String message, String notes);



}

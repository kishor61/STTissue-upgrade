/**
 * 
 */
package com.st.oimnotes.dao;

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
public interface OimNotesDao {

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
	 * @param summary
	 */
	void saveOrUpdate(Summary summary);

	/**
	 * @param categoryId
	 * @param date
	 * @return
	 */
	List<Summary> getSummaries(int categoryId, Date date,Date edate);

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
	List<Summary> getSummariesDates(Date sdate, Date edate);

	/**
	 * @param categoryId
	 * @param sDate
	 * @param eDate
	 * @return
	 */
	List<Summary> getSummariesDates(int categoryId, Date sdate, Date edate);

	/**
	 * @return
	 */
	List<Summary> getOpenSummariesFolloUps();

	/**
	 * @param id
	 * @param message
	 * @param notes
	 */
	void addFollowUpChangeHistory(int id, String message, String notes);

}

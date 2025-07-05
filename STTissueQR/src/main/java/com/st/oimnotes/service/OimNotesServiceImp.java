/**
 * 
 */
package com.st.oimnotes.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.st.oimnotes.dao.OimNotesDao;
import com.st.oimnotes.model.Category;
import com.st.oimnotes.model.FollowUp;
import com.st.oimnotes.model.FollowUpHistory;
import com.st.oimnotes.model.Summary;

/**
 * @author sbora
 *
 */
@Service
public class OimNotesServiceImp implements OimNotesService{

	@Autowired
	private OimNotesDao oimNotesDao;
	
	/* (non-Javadoc)
	 * @see com.st.oimnotes.service.OimNotesService#saveOrUpdate(com.st.oimnotes.model.Category)
	 */
	@Transactional
	@Override
	public void saveOrUpdate(Category category) {
		oimNotesDao.saveOrUpdate(category);
	}

	/* (non-Javadoc)
	 * @see com.st.oimnotes.service.OimNotesService#getCategory()
	 */
	@Transactional
	@Override
	public List<Category> getCategory() {
		return oimNotesDao.getCategory();
	}

	/* (non-Javadoc)
	 * @see com.st.oimnotes.service.OimNotesService#getCategory(int)
	 */
	@Transactional
	@Override
	public Category getCategory(int id) {
		return oimNotesDao.getCategory(id);
	}

	/* (non-Javadoc)
	 * @see com.st.oimnotes.service.OimNotesService#saveOrUpdate(com.st.oimnotes.model.Summary)
	 */
	@Transactional
	@Override
	public void saveOrUpdate(Summary summary) {
		oimNotesDao.saveOrUpdate(summary);
	}

	/* (non-Javadoc)
	 * @see com.st.oimnotes.service.OimNotesService#getSummaries(int, java.util.Date)
	 */
	@Transactional
	@Override
	public List<Summary> getSummaries(int categoryId, Date date,Date edate) {
		return oimNotesDao.getSummaries(categoryId,date,edate);
	}

	/* (non-Javadoc)
	 * @see com.st.oimnotes.service.OimNotesService#getSummary(int)
	 */
	@Transactional
	@Override
	public Summary getSummary(int id) {
		return oimNotesDao.getSummary(id);
	}

	/* (non-Javadoc)
	 * @see com.st.oimnotes.service.OimNotesService#deleteSummary(int)
	 */
	@Transactional
	@Override
	public void deleteSummary(int id) {
		oimNotesDao.deleteSummary(id);
	}

	/* (non-Javadoc)
	 * @see com.st.oimnotes.service.OimNotesService#saveOrUpdate(com.st.oimnotes.model.FollowUp)
	 */
	@Transactional
	@Override
	public void saveOrUpdate(FollowUp followUpOb) {
		oimNotesDao.saveOrUpdate(followUpOb);
	}

	/* (non-Javadoc)
	 * @see com.st.oimnotes.service.OimNotesService#getFollowUps(int)
	 */
	@Transactional
	@Override
	public List<FollowUp> getFollowUps(int sid) {
		return oimNotesDao.getFollowUps(sid);
	}

	/* (non-Javadoc)
	 * @see com.st.oimnotes.service.OimNotesService#getFollowUp(int)
	 */
	@Transactional
	@Override
	public FollowUp getFollowUp(int id) {
		return oimNotesDao.getFollowUp(id);
	}

	/* (non-Javadoc)
	 * @see com.st.oimnotes.service.OimNotesService#deleteFollowUp(int)
	 */
	@Transactional
	@Override
	public void deleteFollowUp(int id) {
		oimNotesDao.deleteFollowUp(id);
	}

	/* (non-Javadoc)
	 * @see com.st.oimnotes.service.OimNotesService#getSummariesAll()
	 */
	@Transactional
	@Override
	public List<Summary> getSummariesAll(Date sdate, Date edate) {
		return oimNotesDao.getSummariesAll(sdate,edate);
	}

	/* (non-Javadoc)
	 * @see com.st.oimnotes.service.OimNotesService#getSummariesFolloUps(java.util.Date, java.util.Date)
	 */
	@Transactional
	@Override
	public List<Summary> getSummariesFolloUps(Date sdate, Date edate) {
		return oimNotesDao.getSummariesFolloUps(sdate,edate);
	}

	/* (non-Javadoc)
	 * @see com.st.oimnotes.service.OimNotesService#getSummariesFolloUps(java.lang.String, java.util.Date, java.util.Date)
	 */
	@Transactional
	@Override
	public List<Summary> getSummariesFolloUps(int category, Date sdate,
			Date edate) {
		return oimNotesDao.getSummariesFolloUps(category,sdate,edate);
	}

	/* (non-Javadoc)
	 * @see com.st.oimnotes.service.OimNotesService#getFollowUpHistory(int)
	 */
	@Transactional
	@Override
	public List<FollowUpHistory> getFollowUpHistory(int fid) {
		return oimNotesDao.getFollowUpHistory(fid);
	}

	/* (non-Javadoc)
	 * @see com.st.oimnotes.service.OimNotesService#closeFollowUp(int)
	 */
	@Transactional
	@Override
	public void closeFollowUp(Date closed, String closedBy, int id) {
		oimNotesDao.closeFollowUp(closed,closedBy,id);
	}

	/* (non-Javadoc)
	 * @see com.st.oimnotes.service.OimNotesService#getFollowUps(int, java.lang.String)
	 */
	@Transactional
	@Override
	public List<FollowUp> getFollowUps(int sid, String tag) {
		return oimNotesDao.getFollowUps(sid,tag);
	}

	/* (non-Javadoc)
	 * @see com.st.oimnotes.service.OimNotesService#getSummariesDates(java.util.Date, java.util.Date)
	 */
	@Transactional
	@Override
	public List<Summary> getSummariesDates(Date sDate, Date eDate) {
		return oimNotesDao.getSummariesDates(sDate,eDate);
	}

	/* (non-Javadoc)
	 * @see com.st.oimnotes.service.OimNotesService#getSummariesDates(int, java.util.Date, java.util.Date)
	 */
	@Transactional
	@Override
	public List<Summary> getSummariesDates(int categoryId, Date sDate,
			Date eDate) {
		return oimNotesDao.getSummariesDates(categoryId,sDate,eDate);
	}

	/* (non-Javadoc)
	 * @see com.st.oimnotes.service.OimNotesService#getOpenSummariesFolloUps()
	 */
	@Transactional
	@Override
	public List<Summary> getOpenSummariesFolloUps() {
		return oimNotesDao.getOpenSummariesFolloUps();
	}

	/* (non-Javadoc)
	 * @see com.st.oimnotes.service.OimNotesService#addFollowUpChangeHistory(int, java.lang.String, java.lang.String)
	 */
	@Transactional
	@Override
	public void addFollowUpChangeHistory(int id, String message, String notes) {
		oimNotesDao.addFollowUpChangeHistory(id,message,notes);
	}

}

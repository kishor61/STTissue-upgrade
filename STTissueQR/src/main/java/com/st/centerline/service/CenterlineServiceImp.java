/**
 * 
 */
package com.st.centerline.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.st.centerline.dao.CenterlineDao;
import com.st.centerline.model.CenterlineData;
import com.st.centerline.model.CenterlineGrade;

/**
 * @author sbora
 *
 */
@Service
public class CenterlineServiceImp implements CenterlineService {

	@Autowired
	private CenterlineDao centerlineDao;
	
	@Transactional
	@Override
	public CenterlineGrade getCenterlineGrade(int grade) {
		return centerlineDao.getCenterlineGrade(grade);
	}

	@Transactional
	@Override
	public List<Map<String, Object>> getCenterlineGrades() {
		return centerlineDao.getCenterlineGrades();
	}

	@Transactional
	@Override
	public int save(CenterlineData centerlineData) {
		return centerlineDao.save(centerlineData);
	}

	@Transactional
	@Override
	public void update(CenterlineData centerlineData) {
		centerlineDao.update(centerlineData);
	}
	
	@Transactional
	@Override
	public List<Map<String, Object>> getCurrentRunningGrade() {
		return centerlineDao.getCurrentRunningGrade();
	}

	@Transactional
	@Override
	public CenterlineData getCenterlineData(int id) {
		
		return centerlineDao.getCenterlineData(id);
	}

	@Transactional
	@Override
	public void delete(int id) {
		centerlineDao.delete(id);
	}

	@Transactional
	@Override
	public List<CenterlineData> getCenterlineData(Date sdate, Date edate) {
		return centerlineDao.getCenterlineData(sdate, edate);
	}

	@Transactional
	@Override
	public List<CenterlineData> getCenterlineData(Date sdate, Date edate,
			int grade) {
		return centerlineDao.getCenterlineData(sdate, edate, grade);
	}

	@Transactional
	@Override
	public List<CenterlineGrade> getCenterlineGradeIds() {
		return centerlineDao.getCenterlineGradeIds();
	}

	@Transactional
	@Override
	public boolean isGradeExist(String flag) {
		return centerlineDao.isGradeExist(flag);
	}

	@Transactional
	@Override
	public int save(CenterlineGrade centerlineGrade) {
		return centerlineDao.save(centerlineGrade);
	}

	@Transactional
	@Override
	public void update(CenterlineGrade centerlineGrade) {
		centerlineDao.update(centerlineGrade);
	}

	/* (non-Javadoc)
	 * @see com.st.centerline.service.CenterlineService#getCenterlineDataSinglrOrAllSearch(java.util.Date, java.util.Date)
	 */
	@Override
	@Transactional
	public List<CenterlineGrade> getCenterlineDataSinglrOrAllSearch(Date dateS, Date dateE) {
		// TODO Auto-generated method stub
		return centerlineDao.getCenterlineDataSinglrOrAllSearch(dateS,dateE);
	}

}

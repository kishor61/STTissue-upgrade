/**
 *May 10, 2018
 *CenterlinePM5ServiceImp.java
 * TODO
 *com.st.centerlinePM5.service
 *CenterlinePM5ServiceImp.java
 *Roshan Lal Tailor
 */
package com.st.centerlinePM5.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.st.centerline.model.CenterlineData;
import com.st.centerline.model.CenterlineGrade;
import com.st.centerlinePM5.dao.CenterlineDaoPM5;

/**
 * @author roshan
 *
 */
@Service
public class CenterlinePM5ServiceImp implements CenterlinePM5Service{

	@Autowired
	private CenterlineDaoPM5 centerlineDao;
	/* (non-Javadoc)
	 * @see com.st.centerlinePM5.service.CenterlinePM5Service#getCenterlineGrade(int)
	 */
	@Override
	@Transactional
	public CenterlineGrade getCenterlineGrade(int grade) {
		// TODO Auto-generated method stub
		return centerlineDao.getCenterlineGrade(grade);
	}

	/* (non-Javadoc)
	 * @see com.st.centerlinePM5.service.CenterlinePM5Service#getCenterlineData(int)
	 */
	@Override
	@Transactional
	public CenterlineData getCenterlineData(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.st.centerlinePM5.service.CenterlinePM5Service#getCenterlineGrades()
	 */
	@Override
	@Transactional
	public List<Map<String, Object>> getCenterlineGrades() {
		// TODO Auto-generated method stub
		return centerlineDao.getCenterlineGrades();
	}

	/* (non-Javadoc)
	 * @see com.st.centerlinePM5.service.CenterlinePM5Service#save(com.st.centerline.model.CenterlineData)
	 */
	@Override
	@Transactional
	public int save(CenterlineData centerlineData) {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see com.st.centerlinePM5.service.CenterlinePM5Service#update(com.st.centerline.model.CenterlineData)
	 */
	@Override
	@Transactional
	public void update(CenterlineData centerlineData) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see com.st.centerlinePM5.service.CenterlinePM5Service#save(com.st.centerline.model.CenterlineGrade)
	 */
	@Override
	@Transactional
	public int save(CenterlineGrade centerlineGrade) {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see com.st.centerlinePM5.service.CenterlinePM5Service#update(com.st.centerline.model.CenterlineGrade)
	 */
	@Override
	@Transactional
	public void update(CenterlineGrade centerlineGrade) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see com.st.centerlinePM5.service.CenterlinePM5Service#isGradeExist(java.lang.String)
	 */
	@Override
	@Transactional
	public boolean isGradeExist(String flag) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see com.st.centerlinePM5.service.CenterlinePM5Service#getCenterlineGradeIds()
	 */
	@Override
	@Transactional
	public List<CenterlineGrade> getCenterlineGradeIds() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.st.centerlinePM5.service.CenterlinePM5Service#getCurrentRunningGrade()
	 */
	@Override
	@Transactional
	public List<Map<String, Object>> getCurrentRunningGrade() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.st.centerlinePM5.service.CenterlinePM5Service#delete(int)
	 */
	@Override
	@Transactional
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see com.st.centerlinePM5.service.CenterlinePM5Service#getCenterlineData(java.util.Date, java.util.Date)
	 */
	@Override
	@Transactional
	public List<CenterlineData> getCenterlineData(Date sdate, Date edate) {
		// TODO Auto-generated method stub
		return centerlineDao.getCenterlineData(sdate, edate);
	}

	/* (non-Javadoc)
	 * @see com.st.centerlinePM5.service.CenterlinePM5Service#getCenterlineData(java.util.Date, java.util.Date, int)
	 */
	@Override
	@Transactional
	public List<CenterlineData> getCenterlineData(Date sdate, Date edate,int grade) {
		// TODO Auto-generated method stub
		return centerlineDao.getCenterlineData(sdate, edate, grade);
	}

	/* (non-Javadoc)
	 * @see com.st.centerlinePM5.service.CenterlinePM5Service#getCenterlineDataSinglrOrAllSearch(java.util.Date, java.util.Date)
	 */
	@Override
	@Transactional
	public List<CenterlineGrade> getCenterlineDataSinglrOrAllSearch(Date dateS,
			Date dateE) {
		// TODO Auto-generated method stub
		return null;
	}

}

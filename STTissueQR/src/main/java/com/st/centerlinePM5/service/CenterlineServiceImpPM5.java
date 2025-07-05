/**
 *Feb 1, 2018
 *CenterlineServiceImpPM5.java
 * TODO
 *com.st.centerlinePM5.service
 *CenterlineServiceImpPM5.java
 *Roshan Lal Tailor
 */
package com.st.centerlinePM5.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.st.centerline.dao.CenterlineDao;
import com.st.centerline.model.CenterlineData;
import com.st.centerline.model.CenterlineGrade;
import com.st.centerlinePM5.dao.CenterlineDaoPM5;

/**
 * @author roshan
 *
 */
@Service
public class CenterlineServiceImpPM5 implements CenterlineServicePM5 {

	@Autowired
	private CenterlineDaoPM5 centerlineDaoPM5;
	
	/* (non-Javadoc)
	 * @see com.st.centerlinePM5.service.CenterlineServicePM5#getCenterlineGrades()
	 */
	@Override
	@Transactional
	public List<Map<String, Object>> getCenterlineGrades() {
		// TODO Auto-generated method stub
		return centerlineDaoPM5.getCenterlineGrades();
	}

	/* (non-Javadoc)
	 * @see com.st.centerlinePM5.service.CenterlineServicePM5#getCenterlineGradeIds()
	 */
	@Override
	@Transactional
	public List<CenterlineGrade> getCenterlineGradeIds() {
		// TODO Auto-generated method stub
		return centerlineDaoPM5.getCenterlineGradeIds();
	}

	/* (non-Javadoc)
	 * @see com.st.centerlinePM5.service.CenterlineServicePM5#getCenterlineGrade(int)
	 */
	@Override
	@Transactional
	public CenterlineGrade getCenterlineGrade(int grade) {
		// TODO Auto-generated method stub
		return centerlineDaoPM5.getCenterlineGrade(grade);
	}

	/* (non-Javadoc)
	 * @see com.st.centerlinePM5.service.CenterlineServicePM5#update(com.st.centerline.model.CenterlineGrade)
	 */
	@Override
	@Transactional
	public void update(CenterlineGrade centerlineGrade) {
		// TODO Auto-generated method stub
		centerlineDaoPM5.update(centerlineGrade);
	}

	/* (non-Javadoc)
	 * @see com.st.centerlinePM5.service.CenterlineServicePM5#save(com.st.centerline.model.CenterlineGrade)
	 */
	@Override
	@Transactional
	public int save(CenterlineGrade centerlineGrade) {
		// TODO Auto-generated method stub
		return centerlineDaoPM5.save(centerlineGrade);
	}

	/* (non-Javadoc)
	 * @see com.st.centerlinePM5.service.CenterlineServicePM5#getCenterlineData(int)
	 */
	@Override
	@Transactional
	public CenterlineData getCenterlineData(int id) {
		// TODO Auto-generated method stub
		return centerlineDaoPM5.getCenterlineData(id);
	}

	/* (non-Javadoc)
	 * @see com.st.centerlinePM5.service.CenterlineServicePM5#save(com.st.centerline.model.CenterlineData)
	 */
	@Override
	@Transactional
	public int save(CenterlineData centerlineData) {
		// TODO Auto-generated method stub
		return centerlineDaoPM5.save(centerlineData);
	}

	/* (non-Javadoc)
	 * @see com.st.centerlinePM5.service.CenterlineServicePM5#update(com.st.centerline.model.CenterlineData)
	 */
	@Override
	@Transactional
	public void update(CenterlineData centerlineData) {
		// TODO Auto-generated method stub
		centerlineDaoPM5.update(centerlineData);
	}

	/* (non-Javadoc)
	 * @see com.st.centerlinePM5.service.CenterlineServicePM5#getCurrentRunningGrade()
	 */
	@Override
	@Transactional
	public List<Map<String, Object>> getCurrentRunningGrade() {
		// TODO Auto-generated method stub
		return centerlineDaoPM5.getCurrentRunningGrade();
	}

	/* (non-Javadoc)
	 * @see com.st.centerlinePM5.service.CenterlineServicePM5#delete(int)
	 */
	@Override
	@Transactional
	public void delete(int id) {
		// TODO Auto-generated method stub
		centerlineDaoPM5.delete(id);
	}

}

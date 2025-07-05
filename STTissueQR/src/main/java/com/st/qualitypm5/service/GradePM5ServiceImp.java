/**
 *Dec 21, 2017
 *GradePM5ServiceImp.java
 * TODO
 *com.st.qualitypm5.service
 *GradePM5ServiceImp.java
 *Roshan Lal Tailor
 */
package com.st.qualitypm5.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.st.qualitypm5.dao.GradePM5Dao;
import com.st.qualitypm5.model.GradePM5;

/**
 * @author roshan
 *
 */
@Service
public class GradePM5ServiceImp implements GradePM5Service {

	@Autowired
	private GradePM5Dao gradepm5Dao;
	
	/* (non-Javadoc)
	 * @see com.st.qualitypm5.service.GradePM5Service#getGrades()
	 */
	@Override
	@Transactional
	public List<GradePM5> getGrades() {
		// TODO Auto-generated method stub
		return gradepm5Dao.getGrades();
	}

	/* (non-Javadoc)
	 * @see com.st.qualitypm5.service.GradePM5Service#save(com.st.qualitypm5.model.GradePM5)
	 */
	@Override
	@Transactional
	public void save(GradePM5 grade) throws Exception {
		// TODO Auto-generated method stub
		gradepm5Dao.save(grade);
	}

	/* (non-Javadoc)
	 * @see com.st.qualitypm5.service.GradePM5Service#update(com.st.qualitypm5.model.GradePM5)
	 */
	@Override
	@Transactional
	public void update(GradePM5 grade) throws Exception {
		// TODO Auto-generated method stub
		gradepm5Dao.update(grade);
	}

	/* (non-Javadoc)
	 * @see com.st.qualitypm5.service.GradePM5Service#totalGrade()
	 */
	@Override
	@Transactional
	public int totalGrade() {
		// TODO Auto-generated method stub
		return gradepm5Dao.totalGrade();
	}

	/* (non-Javadoc)
	 * @see com.st.qualitypm5.service.GradePM5Service#getGrades(int)
	 */
	@Override
	@Transactional
	public List<GradePM5> getGrades(int page) {
		// TODO Auto-generated method stub
		return gradepm5Dao.getGrades(page);
	}

	/* (non-Javadoc)
	 * @see com.st.qualitypm5.service.GradePM5Service#getGradesProperties()
	 */
	@Override
	@Transactional
	public List<Map<String, Object>> getGradesProperties() {
		// TODO Auto-generated method stub
		return gradepm5Dao.getGradesProperties();
	}

	/* (non-Javadoc)
	 * @see com.st.qualitypm5.service.GradePM5Service#getGrade(java.lang.String)
	 */
	@Override
	@Transactional
	public GradePM5 getGrade(String gradeCode) {
		// TODO Auto-generated method stub
		return gradepm5Dao.getGrade(gradeCode);
	}

}

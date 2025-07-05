/**
 *Dec 21, 2017
 *GradeTargetPM5ServiceImp.java
 * TODO
 *com.st.qualitypm5.service
 *GradeTargetPM5ServiceImp.java
 *Roshan Lal Tailor
 */
package com.st.qualitypm5.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.st.qualitypm5.dao.GradeTargetPM5Dao;
import com.st.qualitypm5.model.GradeTargetPM5;
import com.st.qualitypm6.dao.GradeTargetDao;
import com.st.qualitypm6.model.GradeTarget;

/**
 * @author roshan
 *
 */
@Service
public class GradeTargetPM5ServiceImp implements GradeTargetPM5Service{

	@Autowired
	private GradeTargetPM5Dao gradeTargetPM5Dao;
	
	/* (non-Javadoc)
	 * @see com.st.qualitypm5.service.GradeTargetPM5Service#getGradeTargets(java.lang.String)
	 */
	@Override
	@Transactional
	public List<GradeTargetPM5> getGradeTargets(String gradeCode) {
		// TODO Auto-generated method stub
		return gradeTargetPM5Dao.getGradeTargets(gradeCode);
	}

	/* (non-Javadoc)
	 * @see com.st.qualitypm5.service.GradeTargetPM5Service#save(java.util.List)
	 */
	@Override
	@Transactional
	public void save(List<GradeTargetPM5> gradeTargets) {
		// TODO Auto-generated method stub
		gradeTargetPM5Dao.save(gradeTargets);
	}

	/* (non-Javadoc)
	 * @see com.st.qualitypm5.service.GradeTargetPM5Service#getGradeTarget(java.lang.String)
	 */
	@Override
	@Transactional
	public List<GradeTargetPM5> getGradeTarget(String gradeCode) {
		// TODO Auto-generated method stub
		return gradeTargetPM5Dao.getGradeTarget(gradeCode);
	}

}

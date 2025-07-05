package com.st.qualitypm6.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.st.qualitypm6.dao.GradeTargetDao;
import com.st.qualitypm6.model.GradeTarget;

@Service
public class GradeTargetServiceImp implements GradeTargetService {

	@Autowired
	private GradeTargetDao gradeTargetDao;
	
	@Transactional
	@Override
	public void save(GradeTarget gradeTarget) throws Exception {
		gradeTargetDao.save(gradeTarget);
	}

	@Transactional
	@Override
	public List<GradeTarget> getGradeTargets(String gradeCode) {
		// TODO Auto-generated method stub
		return gradeTargetDao.getGradeTargets(gradeCode);
	}

	@Transactional
	@Override
	public void save(List<GradeTarget> gradeTargets) throws Exception {
		gradeTargetDao.save(gradeTargets);
		
	}

	@Transactional
	@Override
	public GradeTarget getGradeTarget(String grade, String prop) {
		// TODO Auto-generated method stub
		return gradeTargetDao.getGradeTarget(grade, prop);
	}
	
	@Transactional
	@Override
	public List<GradeTarget> getGradeTarget(String gradeCode) {
		// TODO Auto-generated method stub
		return gradeTargetDao.getGradeTarget(gradeCode);
	}

}

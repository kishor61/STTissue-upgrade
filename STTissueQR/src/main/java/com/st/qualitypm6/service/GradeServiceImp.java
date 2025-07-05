package com.st.qualitypm6.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.st.qualitypm6.dao.GradeDao;
import com.st.qualitypm6.model.Grade;
@Service
public class GradeServiceImp implements GradeService {

	@Autowired
	private GradeDao gradeDao;
	
	@Transactional
	@Override
	public void save(Grade grade) throws Exception {
		gradeDao.save(grade);
	}

	@Transactional
	@Override
	public int totalGrade() {
		return gradeDao.totalGrade();
	}
	@Transactional
	@Override
	public List<Grade> getGrades(int page) {
		return gradeDao.getGrades(page);
	}

	@Transactional
	@Override
	public List<Grade> getGrades() {
		return gradeDao.getGrades();
	}

	@Transactional
	@Override
	public List<Map<String, Object>> getGradesProperties() {
		// TODO Auto-generated method stub
		return gradeDao.getGradesProperties();
	}
	
	@Transactional
	@Override
	public Grade getGrade(String gradeCode) {
		// TODO Auto-generated method stub
		return gradeDao.getGrade(gradeCode);
	}

	@Transactional
	@Override
	public void update(Grade grade) throws Exception {
		gradeDao.update(grade);
	}


}

package com.st.qualitypm6.dao;

import java.util.List;
import java.util.Map;

import com.st.qualitypm6.model.Grade;

public interface GradeDao {
	void save(Grade grade) throws Exception;
	void update(Grade grade) throws Exception;
	int totalGrade();
	List<Grade> getGrades(int page);
	List<Grade> getGrades();
	List<Map<String, Object>> getGradesProperties();
	
	
	Grade getGrade(String gradeCode);
	
}

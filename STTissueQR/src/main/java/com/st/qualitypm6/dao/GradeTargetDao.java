package com.st.qualitypm6.dao;

import java.util.List;

import com.st.qualitypm6.model.GradeTarget;

public interface GradeTargetDao {
	void save(GradeTarget gradeTarget)throws Exception;
	List<GradeTarget> getGradeTargets(String gradeCode);
	
	void save(List<GradeTarget> gradeTargets) throws Exception;
	
	GradeTarget getGradeTarget(String grade,String prop);
	List<GradeTarget> getGradeTarget(String gradeCode);
	
	
	
}

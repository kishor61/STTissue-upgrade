package com.st.qualitypm6.service;

import java.util.List;

import com.st.qualitypm6.model.GradeTarget;

public interface GradeTargetService {
	void save(GradeTarget gradeTarget)throws Exception;
	List<GradeTarget> getGradeTargets(String gradeCode);
	void save(List<GradeTarget> gradeTargets) throws Exception;
	GradeTarget getGradeTarget(String grade,String prop);
	List<GradeTarget> getGradeTarget(String gradeCode);
}

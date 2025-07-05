/**
 *Dec 21, 2017
 *GradePM5Service.java
 * TODO
 *com.st.qualitypm5.service
 *GradePM5Service.java
 *Roshan Lal Tailor
 */
package com.st.qualitypm5.service;

import java.util.List;
import java.util.Map;

import com.st.qualitypm5.model.GradePM5;
import com.st.qualitypm6.model.Grade;

/**
 * @author roshan
 *
 */
public interface GradePM5Service {

	void save(GradePM5 grade) throws Exception;
	void update(GradePM5 grade) throws Exception;
	int totalGrade();
	List<GradePM5> getGrades(int page);
	List<GradePM5> getGrades();

	List<Map<String, Object>> getGradesProperties();

	GradePM5 getGrade(String gradeCode);
}

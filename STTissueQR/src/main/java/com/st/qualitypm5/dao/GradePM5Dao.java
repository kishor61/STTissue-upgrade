/**
 *Dec 21, 2017
 *GradePM5Dao.java
 * TODO
 *com.st.qualitypm5.dao
 *GradePM5Dao.java
 *Roshan Lal Tailor
 */
package com.st.qualitypm5.dao;

import java.util.List;
import java.util.Map;

import com.st.qualitypm5.model.GradePM5;

/**
 * @author roshan
 *
 */
public interface GradePM5Dao {

	/**
	 * @return
	 */
	List<GradePM5> getGrades();

	/**
	 * @param grade
	 */
	void save(GradePM5 grade);

	/**
	 * @param grade
	 */
	void update(GradePM5 grade);

	/**
	 * @return
	 */
	int totalGrade();

	/**
	 * @param page
	 * @return
	 */
	List<GradePM5> getGrades(int page);

	/**
	 * @return
	 */
	List<Map<String, Object>> getGradesProperties();

	/**
	 * @param gradeCode
	 * @return
	 */
	GradePM5 getGrade(String gradeCode);

}

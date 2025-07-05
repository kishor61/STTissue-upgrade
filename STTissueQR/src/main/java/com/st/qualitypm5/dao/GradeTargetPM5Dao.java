/**
 *Dec 21, 2017
 *GradeTargetPM5Dao.java
 * TODO
 *com.st.qualitypm5.dao
 *GradeTargetPM5Dao.java
 *Roshan Lal Tailor
 */
package com.st.qualitypm5.dao;

import java.util.List;

import com.st.qualitypm5.model.GradeTargetPM5;

/**
 * @author roshan
 *
 */
public interface GradeTargetPM5Dao {

	/**
	 * @param gradeCode
	 * @return
	 */
	List<GradeTargetPM5> getGradeTargets(String gradeCode);

	/**
	 * @param gradeTargets
	 */
	void save(List<GradeTargetPM5> gradeTargets);

	/**
	 * @param gradeCode
	 * @return
	 */
	List<GradeTargetPM5> getGradeTarget(String gradeCode);

}

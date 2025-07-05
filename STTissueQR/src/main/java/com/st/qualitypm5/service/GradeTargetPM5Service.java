/**
 *Dec 21, 2017
 *GradeTargetPM5Service.java
 * TODO
 *com.st.qualitypm5.service
 *GradeTargetPM5Service.java
 *Roshan Lal Tailor
 */
package com.st.qualitypm5.service;

import java.util.List;

import com.st.qualitypm5.model.GradeTargetPM5;
import com.st.qualitypm6.model.GradeTarget;

/**
 * @author roshan
 *
 */
public interface GradeTargetPM5Service {

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

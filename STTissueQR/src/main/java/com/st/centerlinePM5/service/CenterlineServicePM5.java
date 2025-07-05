/**
 *Feb 1, 2018
 *CenterlineServicePM5.java
 * TODO
 *com.st.centerlinePM5.service
 *CenterlineServicePM5.java
 *Roshan Lal Tailor
 */
package com.st.centerlinePM5.service;

import java.util.List;
import java.util.Map;

import com.st.centerline.model.CenterlineData;
import com.st.centerline.model.CenterlineGrade;

/**
 * @author roshan
 *
 */
public interface CenterlineServicePM5 {

	/**
	 * @return
	 */
	List<Map<String, Object>> getCenterlineGrades();

	public List<CenterlineGrade> getCenterlineGradeIds();
	
	public CenterlineGrade getCenterlineGrade(int grade);
	
	void update(CenterlineGrade centerlineGrade);
	
	int save(CenterlineGrade centerlineGrade);

	/**
	 * @param parseInt
	 * @return
	 */
	CenterlineData getCenterlineData(int parseInt);

	/**
	 * @param centerlineData
	 * @return
	 */
	int save(CenterlineData centerlineData);

	/**
	 * @param centerlineData
	 */
	void update(CenterlineData centerlineData);

	/**
	 * @return
	 */
	List<Map<String, Object>> getCurrentRunningGrade();

	/**
	 * @param id
	 */
	void delete(int id);
}

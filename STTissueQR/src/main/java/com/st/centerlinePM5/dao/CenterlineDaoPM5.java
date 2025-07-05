/**
 *Feb 1, 2018
 *CenterlineDaoPM5.java
 * TODO
 *com.st.centerlinePM5.dao
 *CenterlineDaoPM5.java
 *Roshan Lal Tailor
 */
package com.st.centerlinePM5.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.st.centerline.model.CenterlineData;
import com.st.centerline.model.CenterlineGrade;

/**
 * @author roshan
 *
 */
public interface CenterlineDaoPM5 {

	/**
	 * @return
	 */
	List<Map<String, Object>> getCenterlineGrades();

	/**
	 * @return
	 */
	List<CenterlineGrade> getCenterlineGradeIds();

	/**
	 * @param grade
	 * @return
	 */
	CenterlineGrade getCenterlineGrade(int grade);

	/**
	 * @param centerlineGrade
	 */
	void update(CenterlineGrade centerlineGrade);

	/**
	 * @param centerlineGrade
	 * @return
	 */
	int save(CenterlineGrade centerlineGrade);

	/**
	 * @param id
	 * @return
	 */
	CenterlineData getCenterlineData(int id);

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

	/**
	 * @param sdate
	 * @param edate
	 * @param grade
	 * @return
	 */
	List<CenterlineData> getCenterlineData(Date sdate, Date edate, int grade);

	/**
	 * @param sdate
	 * @param edate
	 * @return
	 */
	List<CenterlineData> getCenterlineData(Date sdate, Date edate);

}

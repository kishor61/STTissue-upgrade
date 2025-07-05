/**
 *May 10, 2018
 *CenterlinePM5Service.java
 * TODO
 *com.st.centerlinePM5.service
 *CenterlinePM5Service.java
 *Roshan Lal Tailor
 */
package com.st.centerlinePM5.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.st.centerline.model.CenterlineData;
import com.st.centerline.model.CenterlineGrade;

/**
 * @author roshan
 *
 */
public interface CenterlinePM5Service {
	public CenterlineGrade getCenterlineGrade(int grade);
	public CenterlineData getCenterlineData(int id);
	public List<Map<String, Object>> getCenterlineGrades();
	int save(CenterlineData centerlineData);
	void update(CenterlineData centerlineData);
	int save(CenterlineGrade centerlineGrade);
	void update(CenterlineGrade centerlineGrade);
	
	boolean isGradeExist(String flag);
	
	public List<CenterlineGrade> getCenterlineGradeIds();
	/**
	 * @return
	 */
	List<Map<String, Object>> getCurrentRunningGrade();
	/**
	 * @param id
	 */
	public void delete(int id);
	
	//Report
	List<CenterlineData> getCenterlineData(Date sdate,Date edate);
	List<CenterlineData> getCenterlineData(Date sdate,Date edate,int grade);
	/**
	 * @param dateS
	 * @param dateE
	 * @return
	 */
	public List<CenterlineGrade> getCenterlineDataSinglrOrAllSearch(Date dateS,
			Date dateE);
}

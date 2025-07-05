/**
 * 
 */
package com.st.centerline.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.st.centerline.model.CenterlineData;
import com.st.centerline.model.CenterlineGrade;

/**
 * @author sbora
 *
 */
public interface CenterlineDao {
	public CenterlineGrade getCenterlineGrade(int grade);
	public CenterlineData getCenterlineData(int id);
	public List<Map<String, Object>> getCenterlineGrades();
	public List<CenterlineGrade> getCenterlineGradeIds();
	
	
	///
	int save(CenterlineData centerlineData);
	void update(CenterlineData centerlineData);
	
	int save(CenterlineGrade centerlineGrade);
	void update(CenterlineGrade centerlineGrade);
	
	/**
	 * @return
	 */
	public List<Map<String, Object>> getCurrentRunningGrade();
	/**
	 * @param id
	 */
	public void delete(int id);
	
	
	//Report
	List<CenterlineData> getCenterlineData(Date sdate,Date edate);
	List<CenterlineData> getCenterlineData(Date sdate,Date edate,int grade);
	
	
	boolean isGradeExist(String flag);
	/**
	 * @param dateS
	 * @param dateE
	 * @return
	 */
	public List<CenterlineGrade> getCenterlineDataSinglrOrAllSearch(Date dateS,
			Date dateE);
	
}

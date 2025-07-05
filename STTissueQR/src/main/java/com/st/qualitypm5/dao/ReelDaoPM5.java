/**
 *Dec 22, 2017
 *ReelDaoPM5.java
 * TODO
 *com.st.qualitypm5.dao
 *ReelDaoPM5.java
 *Roshan Lal Tailor
 */
package com.st.qualitypm5.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.st.qualitypm5.model.ReelPM5;
import com.st.qualitypm6.model.Reel;

/**
 * @author roshan
 *
 */
public interface ReelDaoPM5 {

	/**
	 * @param gradeCode
	 * @param date
	 * @return
	 */
	List<ReelPM5> getReels(String gradeCode, Date date);

	/**
	 * @param reel
	 * @return
	 * @throws Exception 
	 */
	int save(ReelPM5 reel) throws Exception;

	/**
	 * @param reel
	 * @throws Exception 
	 */
	void update(ReelPM5 reel) throws Exception;

	/**
	 * @param reelNo
	 * @param year
	 * @return
	 */
	boolean isReelNumberExist(String reelNo, String year);

	/**
	 * @param reelNo
	 * @return
	 */
	boolean isReelNumberExist(String reelNo);

	/**
	 * @return
	 */
	List<String> getReels();

	/**
	 * @param gradeCode
	 * @return
	 */
	List<String> getReelByGradeCode(String gradeCode);

	/**
	 * @param idsList
	 */
	void delete(List<String> idsList);

	/**
	 * @param gradeCode
	 * @param reelNo
	 * @return
	 */
	Object getCustomerName(String gradeCode, String reelNo);

	/**
	 * @param id
	 * @return
	 */
	ReelPM5 getReelById(int id);

	/**
	 * @param reelNo
	 * @return
	 */
	List<ReelPM5> getReelByReelNo(String reelNo);

	/**
	 * @param reel
	 * @return
	 */
	List<Map<String, Object>> findMatch(ReelPM5 reel);

	/**
	 * @return
	 */
	String getMaxReel();

	/**
	 * @param reel
	 * @return
	 */
	Map<String, Date> getPrevNextReelDate(String reel);

	/**
	 * @param date
	 * @param date2
	 * @param string
	 * @param string2
	 * @param string3
	 * @param string4
	 * @return
	 */
	List<ReelPM5> getReelData(Date date, Date date2, String string,
			String string2, String string3, String string4);

	/**
	 * @return
	 */
	double getBirghtnessAvgOfDay();

	/**
	 * @return
	 */
	double getBirghtnessAvgOfLastDay();

	/**
	 * @param grade
	 * @return
	 */
	double getBirghtnessAvgOfLastDay(String grade);

	/**
	 * @param sdate
	 * @param edate
	 * @param customer
	 * @return
	 */
	List<String> getGrades(Date sdate, Date edate, String customer);

	/**
	 * @param currentReelNumber
	 * @param currentGradeCodeByAjax
	 * @return
	 */
	String getcurrentreel(String currentReelNumber,
			String currentGradeCodeByAjax);

	/**
	 * @return
	 */
	String getlastgradecode();

	/**
	 * @param date1
	 * @param date2
	 * @param customer
	 * @return
	 */
	List<Reel> getReelsByCustomer(Date date1, Date date2, String customer);

	/**
	 * @param sdate
	 * @param edate
	 * @param gradeCode
	 * @param customer
	 * @return
	 */
	List<Reel> getReelsByGradeCustomer(Date sdate, Date edate, String gradeCode, String customer);

}

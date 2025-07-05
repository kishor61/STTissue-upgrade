package com.st.qualitypm6.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.st.qualitypm6.model.Reel;

public interface ReelDao {
	List<Reel> getReels(String gradeCode,Date date);
	
	//List<Reel> getReels(String gradeCode,Date date,String entryAutoFlag);
	
	int save(Reel reel) throws Exception;
	//void update(Reel reel,String entryAutoFlag) throws Exception;
	void update(Reel reel) throws Exception;
	
	boolean isReelNumberExist(String reelNo,String year);
	boolean isReelNumberExist(String reelNo);
	List<String> getReels();
	List<String> getReelByGradeCode(String gradeCode);
	void delete(List<String> idsList);
	Object getCustomerName(String gradeCode, String reelNo);
	
	Reel getReelById(int id);
	
	//void updateEntryById(List<Integer> ids,String entryFlag);
	
	//Methos for report
	/*List<Reel> getReels(Date sdate,Date edate);
	List<Reel> getReelsByGrade(Date sdate, Date edate, String gradeCode);
	List<Reel> getReelsByCustomer(Date sdate, Date edate, String customer);
	List<Reel> getReelsByGrade(String gradeCode);
	List<Reel> getReelsByCustomer(String customer);
	List<Reel> getReelsByReel(Date sdate, Date edate, String reel);
	List<Reel> getReelsByGradeCustomer(Date sdate, Date edate,
			String gradeCode, String customer);
	List<Reel> getReelsByGradeReel(Date sdate, Date edate, String gradeCode,
			String reel);
	List<Reel> getReelsByGradeCustomerReel(Date sdate, Date edate,
			String gradeCode, String customer, String reel);
	List<Reel> getReelsByCustomerReel(Date sdate, Date edate, String customer,
			String reel);
	*/
	
	///
	List<Reel> getReelByReelNo(String reelNo);

	List<Map<String, Object>> findMatch(Reel reel);
	
	String getMaxReel();
	Map<String, Date> getPrevNextReelDate(String reel);
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

	
//	Code Starts From Here Done By Roshan Tailor Date :- 04/07/2015
	/**
	 * @param currentReelNumber
	 * @return
	 */
	String getcurrentreel(String currentReelNumber, String currentGradeCodeByAjax);
//	Code Ends Here Done By Roshan Tailor	
	
//	Code Starts From here Done by Roshan Tailor Date :- 04/16/2015
	/**
	 * @return
	 */
	String getlastgradecode();
//	Code Ends Here Done By Roshan Tailor

	/**
	 * @param sdate
	 * @param edate
	 * @param grade
	 * @param customer
	 * @param reel
	 * @param type
	 * @return
	 */
	List<Reel> getReelData(Date sdate, Date edate, String grade,
			String customer, String reel, String type);

	/**
	 * @param string
	 * @param dateFrom
	 * @param dateTo
	 * @return
	 */
	List<Reel> getReelByReelNo(String string, Date dateFrom, Date dateTo);

	/**
	 * @param string
	 * @param dateFrom
	 * @param dateTo
	 * @return
	 */
	List<Reel> getReelByReelNopm5(String string, Date dateFrom, Date dateTo);

	/**
	 * @param valueOf
	 * @param dateFrom
	 * @param dateTo
	 * @return
	 */
	List<Reel> getReelByReelNo_Pm5(String valueOf, Date dateFrom, Date dateTo);

	/**
	 * @param string
	 * @param dateFrom
	 * @param dateTo
	 * @return
	 */
	
	
}
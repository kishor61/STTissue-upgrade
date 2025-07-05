/**
 *Dec 22, 2017
 *ReelServicePM5.java
 * TODO
 *com.st.qualitypm5.service
 *ReelServicePM5.java
 *Roshan Lal Tailor
 */
package com.st.qualitypm5.service;

import java.io.File;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.st.qualitypm5.model.ReelPM5;
import com.st.qualitypm6.model.Reel;

/**
 * @author roshan
 *
 */
public interface ReelServicePM5 {
	List<ReelPM5> getReels(String gradeCode,Date date);
	//List<Reel> getReels(String gradeCode,Date date,String entryAutoFlag);
	
	
	int save(ReelPM5 reel) throws Exception;
	
	void update(ReelPM5 reel) throws Exception;
	
	boolean isReelNumberExist(String reelNo,String year);
	
	boolean isReelNumberExist(String reelNo);
	
	List<String> getReels();
	
	List<String> getReelByGradeCode(String gradeCode);
	
	void delete(List<String> idsList);
	
	Object getCustomerName(String gradeCode, String reelNo);
	
	ReelPM5 getReelById(int id);
	
	
	
	
	List<ReelPM5> getReelByReelNo(String reelNo);
	/**
	 * @param reel
	 * @return
	 */
	List<Map<String, Object>> findMatch(ReelPM5 reel);
	

	String getMaxReel();
	Map<String, Date> getPrevNextReelDate(String reel);
	
	
	//
	List<Map<String, Object>> getFormatedData(List<ReelPM5> reels) throws ParseException ;
	
	
	public void createPdfReelReport(File file,Date date) throws Exception;
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
	 * @param checkDate
	 * @param checkDate2
	 * @param customer
	 * @return
	 */
	List<String> getGrades(Date sdate, Date edate, String customer);


	/**
	 * @param currentReelNumber
	 * @return
	 */
	String getcurrentreel(String currentReelNumber, String currentGradeCodeByAjax);


//	Code Starts From Here Done By Roshan Tailor Date :- 04/16/2015
	/**
	 * @return
	 */
	String getlastgradecode();
//	Code Ends Here Done By Roshan Tailor


	/**
	 * @param parse
	 * @param parse2
	 * @param grade
	 * @param customer
	 * @param reel
	 * @param type
	 * @return
	 */
	List<ReelPM5> getReelData(Date parse, Date parse2, String grade,
			String customer, String reel, String type);


	/**
	 * @param parse
	 * @param parse2
	 * @param string
	 * @return
	 */
	List<Reel> getReelsByCustomer(Date parse, Date parse2, String string);


	/**
	 * @param parse
	 * @param parse2
	 * @param gradeCode
	 * @param customer
	 * @return
	 */
	List<Reel> getReelsByGradeCustomer(Date parse, Date parse2, String gradeCode, String customer);


}

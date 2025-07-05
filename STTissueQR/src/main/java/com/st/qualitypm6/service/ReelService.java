package com.st.qualitypm6.service;

import java.io.File;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.st.qualitypm6.model.Reel;

public interface ReelService {
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
	//List<Reel> getReels(Date sdate,Date edate);
	//List<Reel> getReelsByGrade(Date parse, Date parse2, String gradeCode);
	//List<Reel> getReelsByCustomer(Date parse, Date parse2, String customer);
	//List<Reel> getReelsByGrade(String gradeCode);
	//List<Reel> getReelsByCustomer(String customer);
	//List<Reel> getReelsByReel(Date parse, Date parse2, String reel);
	//List<Reel> getReelsByGradeCustomer(Date sdate, Date edate, String gradeCode,String customer);
	//List<Reel> getReelsByGradeReel(Date sdate, Date edate, String gradeCode,			String reel);
	//List<Reel> getReelsByGradeCustomerReel(Date sdate, Date edate,			String gradeCode, String customer, String reel);
	//List<Reel> getReelsByCustomerReel(Date sdate, Date edate, String customer,			String reel);
	
	
	
	
	///
	List<Reel> getReelByReelNo(String reelNo);
	/**
	 * @param reel
	 * @return
	 */
	List<Map<String, Object>> findMatch(Reel reel);
	

	String getMaxReel();
	Map<String, Date> getPrevNextReelDate(String reel);
	
	
	//
	List<Map<String, Object>> getFormatedData(List<Reel> reels) throws ParseException ;
	
	
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
	List<Reel> getReelData(Date parse, Date parse2, String grade,
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
	 * @param dateTo
	 * @param dateFrom
	 * @return
	 */
	List<Reel> getReelByReelNo_Pm5(String valueOf, Date dateTo, Date dateFrom);


}

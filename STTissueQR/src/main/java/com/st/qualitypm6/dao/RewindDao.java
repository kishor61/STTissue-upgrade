package com.st.qualitypm6.dao;

import java.util.Date;
import java.util.List;

import com.st.qualitypm6.model.Rewind;

public interface RewindDao {
	List<Rewind> getRewinds(String gradeCode,String reel,Date date);
	
	int save(Rewind rewind) throws Exception;
	//void update(Rewind rewind,String entryAutoFlag) throws Exception;
	void update(Rewind rewind);
	
	//List<Rewind> getRewinds(String gradeCode,Date date,String reel,String entryAutoFlag);
	boolean isSetNumberExist(String setNo);
	void delete(List<String> idsList);

	List<Rewind> getRewinds(String gradeCode, Date jdate, String reelNo);
	
	List<Rewind> getRewinds(String gradeCode, Date jdate);
	
	//void updateEntryById(List<Integer> ids,String entryFlag);
	
	
	//Report Method
/*	List<Rewind> getRewind(Date sdate, Date edate);

	List<Rewind> getRewindByGrade(Date sdate, Date edate, String gradeCode);
	List<Rewind> getRewindByCustomer(Date sdate, Date edate, String customer);
	List<Rewind> getRewindByReel(Date sdate, Date edate, String reel);
	
	List<Rewind> getRewindByGrade(String gradeCode);
	List<Rewind> getRewindByCustomer(String customer);
	List<Rewind> getRewindByReel(String reel);

	List<Rewind> getRewindByGradeCustomer(Date sdate, Date edate,
			String gradeCode, String customer);
	List<Rewind> getRewindByGradeReel(Date sdate, Date edate,
			String gradeCode, String reel);
	List<Rewind> getRewindByGradeCustomerReel(Date sdate, Date edate,
			String gradeCode, String customer, String reel);
	List<Rewind> getRewindByCustomerReel(Date sdate, Date edate,
			String customer, String reel);*/

	Rewind getRewindById(int id);

	/**
	 * @param reel
	 * @param set
	 * @return
	 */
	List<Rewind> getRewindInfo(String reel, String set);

	/**
	 * @param sdate
	 * @param edate
	 * @param gradeCode
	 * @param customer
	 * @return
	 */
	List<Rewind> getRewindByGradeCustomerGraph(List<String> reels,
			String gradeCode, String customer);

	/**
	 * @param sdate
	 * @param edate
	 * @param grade
	 * @param customer
	 * @param reel
	 * @param type
	 * @return
	 */
	List<Rewind> getRewindData(Date sdate, Date edate, String grade,
			String customer, String reel, String type);
}

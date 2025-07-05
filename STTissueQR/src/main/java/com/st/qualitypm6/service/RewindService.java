package com.st.qualitypm6.service;

import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.st.qualitypm6.model.Rewind;

public interface RewindService {
	List<Rewind> getRewinds(String gradeCode,String reel,Date date);

	int save(Rewind rewind) throws Exception;
	//void update(Rewind rewind,String entryAutoFlag) throws Exception;
	void update(Rewind rewind);
//	List<Rewind> getRewinds(String gradeCode,Date date,String reel,String entryAutoFlag);
	boolean isSetNumberExist(String setNo);
	void delete(List<String> idsList);
	List<Rewind> getRewinds(String gradeCode, Date jdate, String reelNo);
	List<Rewind> getRewinds(String gradeCode, Date jdate);
	//void updateEntryById(List<Integer> ids,String entryFlag);
	

	Rewind getRewindById(int id);

	/**
	 * @param reel
	 * @param set
	 * @return
	 */
	List<Rewind> getRewindInfo(String reel, String set);

	
	
	List<Map<String, Object>> getFormatedData(List<Rewind> rewinds) throws Exception;

	/**
	 * @param fileRwinderPdf
	 * @param date
	 * @throws Exception 
	 */
	void createPdfReelReport(File fileRwinderPdf, Date date) throws Exception;

	/**
	 * @param checkDate
	 * @param checkDate2
	 * @param gradeCode
	 * @param customer
	 * @return
	 */
	List<Rewind> getRewindByGradeCustomerGraph(List<String> reels,
			String gradeCode, String customer);

	/**
	 * @param parse
	 * @param parse2
	 * @param grade
	 * @param customer
	 * @param reel
	 * @param type
	 * @return
	 */
	List<Rewind> getRewindData(Date sdate, Date edate, String grade,
			String customer, String reel, String type);
	
}

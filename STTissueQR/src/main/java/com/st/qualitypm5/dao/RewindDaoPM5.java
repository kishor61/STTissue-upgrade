/**
 *Dec 25, 2017
 *RewindDaoPM5.java
 * TODO
 *com.st.qualitypm5.dao
 *RewindDaoPM5.java
 *Roshan Lal Tailor
 */
package com.st.qualitypm5.dao;

import java.util.Date;
import java.util.List;

import com.st.qualitypm5.model.RewindPM5;

/**
 * @author roshan
 *
 */
public interface RewindDaoPM5 {

	/**
	 * @param gradeCode
	 * @param jdate
	 * @return
	 */
	List<RewindPM5> getRewinds(String gradeCode, Date jdate);

	/**
	 * @param id
	 * @return
	 */
	RewindPM5 getRewindById(int id);

	/**
	 * @param rewind
	 */
	void update(RewindPM5 rewind);

	/**
	 * @param setNo
	 * @return
	 */
	boolean isSetNumberExist(String setNo);

	/**
	 * @param rewind
	 * @return
	 */
	int save(RewindPM5 rewind);

	/**
	 * @param idsList
	 */
	void delete(List<String> idsList);

	/**
	 * @param reel
	 * @param set
	 * @return
	 */
	List<RewindPM5> getRewindInfo(String reel, String set);

	/**
	 * @param sdate
	 * @param edate
	 * @param grade
	 * @param customer
	 * @param reel
	 * @param type
	 * @return
	 */
	List<RewindPM5> getRewindData(Date sdate, Date edate, String grade,
			String customer, String reel, String type);

}

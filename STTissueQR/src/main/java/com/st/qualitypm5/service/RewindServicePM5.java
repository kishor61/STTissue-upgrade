/**
 *Dec 25, 2017
 *RewindServicePM5.java
 * TODO
 *com.st.qualitypm5.service
 *RewindServicePM5.java
 *Roshan Lal Tailor
 */
package com.st.qualitypm5.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.lowagie.text.DocumentException;
import com.st.qualitypm5.model.RewindPM5;

/**
 * @author roshan
 *
 */
public interface RewindServicePM5 {

	/**
	 * @param gradeCode
	 * @param shiftDate
	 * @return
	 */
	List<RewindPM5> getRewinds(String gradeCode, Date shiftDate);

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
	 * @param parse
	 * @param parse2
	 * @param grade
	 * @param customer
	 * @param reel
	 * @param type
	 * @return
	 */
	List<RewindPM5> getRewindData(Date parse, Date parse2, String grade,
			String customer, String reel, String type);

	/**
	 * @param rewinds
	 * @return
	 */
	List<Map<String, Object>> getFormatedData(List<RewindPM5> rewinds);

	/**
	 * @param fileRwinderPdf
	 * @param date
	 * @throws FileNotFoundException 
	 * @throws DocumentException 
	 * @throws IOException 
	 */
	void createPdfReelReport(File fileRwinderPdf, Date date) throws FileNotFoundException, DocumentException, IOException;

}

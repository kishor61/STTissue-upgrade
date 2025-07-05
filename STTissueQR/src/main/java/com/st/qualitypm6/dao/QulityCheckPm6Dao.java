/**
 *Oct 17, 2019
 *QulityCheck_Pm6Dao.java
 * TODO
 *com.st.qualitypm6.dao
 *QulityCheck_Pm6Dao.java
 *Roshan Lal Tailor
 */
package com.st.qualitypm6.dao;

import java.util.Date;
import java.util.List;

import com.st.qualitypm6.model.QulityCheck_Pm6;

import productspecificationsignoffsheet.ProductSpecificationSignOffSheet;

/**
 * @author roshan
 *
 */
public interface QulityCheckPm6Dao {

	/**
	 * @param date
	 * @return
	 */
	List<QulityCheck_Pm6> getDataOfQulityCheck_Pm6(Date date);

	/**
	 * @param wm
	 * @return
	 */
	int savequalitychecklist(QulityCheck_Pm6 wm);

	/**
	 * @param id
	 */
	void qualitychecklistdelete(int id);

	/**
	 * @param wm
	 */
	void updatequalitychecklist(QulityCheck_Pm6 wm);

	/**
	 * @param sdate
	 * @param edate
	 * @return
	 */
	List<QulityCheck_Pm6> getDataOfQulityCheck_Pm6(Date sdate, Date edate);

	/**
	 * @param sdate
	 * @param edate
	 * @return
	 */
	List<ProductSpecificationSignOffSheet> getDataOfQulityCheck_Pm6(String sdate, String edate);

	/**
	 * @param id
	 * @return
	 */
	List<QulityCheck_Pm6> getDataOfQulityCheck_Pm6(int id);

}

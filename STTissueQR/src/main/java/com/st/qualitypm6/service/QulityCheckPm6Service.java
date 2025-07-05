/**
 *Oct 17, 2019
 *QulityCheck_Pm6Service.java
 * TODO
 *com.st.qualitypm6.service
 *QulityCheck_Pm6Service.java
 *Roshan Lal Tailor
 */
package com.st.qualitypm6.service;

import java.util.Date;
import java.util.List;

import com.st.qualitypm6.model.QulityCheck_Pm6;

import productspecificationsignoffsheet.ProductSpecificationSignOffSheet;

/**
 * @author roshan
 *
 */
public interface QulityCheckPm6Service {

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
	 * @param wm
	 */
	void updatequalitychecklist(QulityCheck_Pm6 wm);

	/**
	 * @param id
	 */
	void qualitychecklistdelete(int id);

	/**
	 * @param sdate
	 * @param edate
	 * @return
	 */
	List<QulityCheck_Pm6> getDataOfQulityCheck_Pm6(Date sdate, Date edate);

	/**
	 * @param format
	 * @param format2
	 * @return
	 */
	List<ProductSpecificationSignOffSheet> getDataOfProductSpecificationSignOffSheetByDate(String format,
			String format2);

	/**
	 * @param id
	 * @return
	 */
	List<QulityCheck_Pm6> getDataOfQulityCheck_Pm6(int id);

}

/**
 *Oct 12, 2017
 *ManintenanceLogCr6Pm6FrpDao.java
 * TODO
 *com.st.manintenancelogcr6pm6frp.dao
 *ManintenanceLogCr6Pm6FrpDao.java
 *Roshan Lal Tailor
 */
package com.st.manintenancelogcr6pm6frp.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.st.manintenancelogcr6pm6frp.model.ManintenanceLogCr6Pm6Frp;
import com.st.manintenancelogcr6pm6frp.model.ManintenanceLogCr6Pm6FrpArea;

/**
 * @author roshan
 *
 */
public interface ManintenanceLogCr6Pm6FrpDao {

	/**
	 * @param ar
	 * @return
	 */
	int save(ManintenanceLogCr6Pm6FrpArea ar);

	/**
	 * @return
	 */
	List<ManintenanceLogCr6Pm6Frp> getGrades();

	/**
	 * @param data
	 * @return
	 */
	int save(ManintenanceLogCr6Pm6Frp data);

	/**
	 * @param data
	 */
	void update(ManintenanceLogCr6Pm6Frp data);

	/**
	 * @param date
	 * @param shift 
	 * @return
	 */
	List<ManintenanceLogCr6Pm6Frp> getCurrentDateData(Date date, String shift);

	/**
	 * @param id
	 */
	void delete(int id);

	/**
	 * @return
	 */
	List<Map<String, Object>> getArea_ForJSON();

	/**
	 * @param sdate
	 * @param edate
	 * @param userType 
	 * @return
	 */
	List<ManintenanceLogCr6Pm6Frp> getDateBetweenData(String sdate, String edate, String userType);

	/**
	 * @param sdate
	 * @param edate
	 * @param operator 
	 * @return
	 */
	List<ManintenanceLogCr6Pm6Frp> getDateBetweenData_Email(String sdate,
			String edate, String operator);

	/**
	 * @param sdate
	 * @param shift
	 * @return
	 */
	List<ManintenanceLogCr6Pm6Frp> getCurrentDateDataShiftWise(Date sdate,
			String shift);

}

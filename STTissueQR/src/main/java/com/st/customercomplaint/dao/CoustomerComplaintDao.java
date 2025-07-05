/**
 *Oct 27, 2015
 *CoustomerComplaintDao.java
 * TODO
 *com.st.customercomplaint.dao
 *CoustomerComplaintDao.java
 *Sunil Singh Bora
 */
package com.st.customercomplaint.dao;

import java.util.Date;
import java.util.List;

import com.st.customercomplaint.model.CustomerComplaint;

/**
 * @author roshan
 *
 */
public interface CoustomerComplaintDao {

	/**
	 * @param sdate
	 * @param edate
	 * @return
	 */
	List<CustomerComplaint> getCustomerComplaint(Date sdate, Date edate);

	/**
	 * @param complaint
	 * @return
	 */
	int save(CustomerComplaint complaint);

	/**
	 * @param complaint
	 */
	void update(CustomerComplaint complaint);

	/**
	 * @param sdate
	 * @param edate
	 * @return
	 */
	List<CustomerComplaint> getComplaintCustomerReport(Date sdate, Date edate);

	/**
	 * @param id
	 */
	void delete(int id);

	/**
	 * @param id
	 * @return
	 */
	List<CustomerComplaint> editComplaintCustomerReport(int id);

}

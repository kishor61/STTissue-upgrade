/**
 *Oct 27, 2015
 *CoustomerComplaintService.java
 * TODO
 *com.st.customercomplaint.service
 *CoustomerComplaintService.java
 *Sunil Singh Bora
 */
package com.st.customercomplaint.service;

import java.util.Date;
import java.util.List;

import com.st.customercomplaint.model.CustomerComplaint;

/**
 * @author roshan
 *
 */
public interface CoustomerComplaintService {

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

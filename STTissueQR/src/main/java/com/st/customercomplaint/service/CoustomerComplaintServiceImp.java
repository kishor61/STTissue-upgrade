/**
 *Oct 27, 2015
 *CoustomerComplaintServiceImp.java
 * TODO
 *com.st.customercomplaint.service
 *CoustomerComplaintServiceImp.java
 *Sunil Singh Bora
 */
package com.st.customercomplaint.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.st.customercomplaint.dao.CoustomerComplaintDao;
import com.st.customercomplaint.model.CustomerComplaint;

/**
 * @author roshan
 *
 */
@Service
public class CoustomerComplaintServiceImp implements CoustomerComplaintService {

	@Autowired
	private CoustomerComplaintDao coustomercomplaintdao;	
	/* (non-Javadoc)
	 * @see com.st.customercomplaint.service.CoustomerComplaintService#getCustomerComplaint(java.util.Date, java.util.Date)
	 */
	@Transactional
	@Override
	public List<CustomerComplaint> getCustomerComplaint(Date sdate, Date edate) {
		// TODO Auto-generated method stub
		return coustomercomplaintdao.getCustomerComplaint(sdate,edate);
	}
	/* (non-Javadoc)
	 * @see com.st.customercomplaint.service.CoustomerComplaintService#save(com.st.customercomplaint.model.CustomerComplaint)
	 */
	@Transactional
	@Override
	public int save(CustomerComplaint complaint) {
		// TODO Auto-generated method stub
		return coustomercomplaintdao.save(complaint);
	}
	/* (non-Javadoc)
	 * @see com.st.customercomplaint.service.CoustomerComplaintService#update(com.st.customercomplaint.model.CustomerComplaint)
	 */
	@Transactional
	@Override
	public void update(CustomerComplaint complaint) {
		// TODO Auto-generated method stub
		coustomercomplaintdao.update(complaint);
	}
	/* (non-Javadoc)
	 * @see com.st.customercomplaint.service.CoustomerComplaintService#getComplaintCustomerReport(java.util.Date, java.util.Date)
	 */
	@Transactional
	@Override
	public List<CustomerComplaint> getComplaintCustomerReport(Date sdate,
			Date edate) {
		// TODO Auto-generated method stub
		return coustomercomplaintdao.getComplaintCustomerReport(sdate,edate);
	}
	/* (non-Javadoc)
	 * @see com.st.customercomplaint.service.CoustomerComplaintService#delete(int)
	 */
	@Transactional
	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		coustomercomplaintdao.delete(id);
	}
	/* (non-Javadoc)
	 * @see com.st.customercomplaint.service.CoustomerComplaintService#editComplaintCustomerReport(int)
	 */
	@Transactional
	@Override
	public List<CustomerComplaint> editComplaintCustomerReport(int id) {
		// TODO Auto-generated method stub
		return coustomercomplaintdao.editComplaintCustomerReport(id);
	}

}

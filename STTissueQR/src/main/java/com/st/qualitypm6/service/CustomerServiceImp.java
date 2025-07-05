package com.st.qualitypm6.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.st.qualitypm6.dao.CustomerDao;

@Service
public class CustomerServiceImp implements CustomerService {

	@Autowired
	private CustomerDao customerDao;
	
	
	@Transactional
	@Override
	public List<String> getCustomers() {
		return customerDao.getCustomers();
	}

	@Transactional
	@Override
	public void saveCustomer(String name, String location, String city,
			String state) {
		customerDao.saveCustomer(name,location,city,state);
		
	}
	@Transactional
	@Override
	public List<Map<String, Object>> getCustomersFullInfo() {
		return customerDao.getCustomersFullInfo();
	}

	@Transactional
	@Override
	public void delete(List<String> customerIds) {
		customerDao.delete(customerIds);
	}

	@Transactional
	@Override
	public void updateCustomer(int id, String name, String location,
			String city, String state) {
		customerDao.updateCustomer(id,name,location,city,state);
	}

	@Transactional
	@Override
	public List<Map<String, Object>> getCustomerById(int id) {
		return customerDao.getCustomerById(id);
	}

}

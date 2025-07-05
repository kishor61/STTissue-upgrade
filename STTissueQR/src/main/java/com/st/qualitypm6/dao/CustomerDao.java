package com.st.qualitypm6.dao;

import java.util.List;
import java.util.Map;

public interface CustomerDao {

	List<String> getCustomers();
	List<Map<String, Object>> getCustomersFullInfo();

	void saveCustomer(String name, String location, String city, String state);
	void delete(List<String> customerIds);
	/**
	 * @param id
	 * @param name
	 * @param location
	 * @param city
	 * @param state
	 */
	void updateCustomer(int id, String name, String location, String city,String state);

	public List<Map<String, Object>> getCustomerById(int id);
}

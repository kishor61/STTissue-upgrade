/**
 *May 5, 2016
 *WetlapInventoryServiceImp.java
 * TODO
 *com.st.wetlapinventory.service
 *WetlapInventoryServiceImp.java
 *Sunil Singh Bora
 */
package com.st.wetlapinventory.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.st.wetlapinventory.dao.WetlapInventoryDao;
import com.st.wetlapinventory.model.WetlapInventory;

/**
 * @author roshan
 *
 */
@Service
public class WetlapInventoryServiceImp implements WetlapInventoryService{

	@Autowired
	private WetlapInventoryDao wetlapinventorydao; 
	/* (non-Javadoc)
	 * @see com.st.wetlapinventory.service.WetlapInventoryService#getReportData()
	 */
	@Transactional
	@Override
	public List<WetlapInventory> getReportData() {
		// TODO Auto-generated method stub
		return wetlapinventorydao.getReportData();
	}
	/* (non-Javadoc)
	 * @see com.st.wetlapinventory.service.WetlapInventoryService#getReportMillData()
	 */
	@Transactional
	@Override
	public List<WetlapInventory> getReportMillData() {
		// TODO Auto-generated method stub
		return wetlapinventorydao.getReportMillData();
	}

}

/**
 *May 5, 2016
 *WetlapInventoryDao.java
 * TODO
 *com.st.wetlapinventory.dao
 *WetlapInventoryDao.java
 *Sunil Singh Bora
 */
package com.st.wetlapinventory.dao;

import java.util.List;

import com.st.wetlapinventory.model.WetlapInventory;

/**
 * @author roshan
 *
 */
public interface WetlapInventoryDao {

	/**
	 * @return
	 */
	List<WetlapInventory> getReportData();

	/**
	 * @return
	 */
	List<WetlapInventory> getReportMillData();

}

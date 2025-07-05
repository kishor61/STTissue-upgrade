/**
 *May 5, 2016
 *WetlapInventoryService.java
 * TODO
 *com.st.wetlapinventory.service
 *WetlapInventoryService.java
 *Sunil Singh Bora
 */
package com.st.wetlapinventory.service;

import java.util.List;

import com.st.wetlapinventory.model.WetlapInventory;

/**
 * @author roshan
 *
 */
public interface WetlapInventoryService {

	/**
	 * @return
	 */
	List<WetlapInventory> getReportData();

	/**
	 * @return
	 */
	List<WetlapInventory> getReportMillData();

}

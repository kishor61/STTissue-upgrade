/**
 *Jan 12, 2018
 *DespatchDao.java
 * TODO
 *com.st.despatch.dao
 *DespatchDao.java
 *Roshan Lal Tailor
 */
package com.st.despatch.dao;

import java.util.Date;
import java.util.List;

import com.st.despatch.model.Despatch;

/**
 * @author roshan
 *
 */
public interface DespatchDao {

	/**
	 * @param sDate
	 * @param type 
	 * @return
	 */
	List<Despatch> getDespatchData(Date sDate, String type);

	/**
	 * @return
	 */
	List<Despatch> getDespatchData_Temp();

	/**
	 * @param tblName 
	 * @param releasenumber
	 * @param pickupdate
	 * @return
	 */
	int getCheckDateTempTable(String tblName, int releasenumber, Date pickupdate);

	/**
	 * @param releasenumber
	 * @param pickuppoint
	 * @return
	 */
	int getCheckPickUpPointTempTable(String tblName, int releasenumber, String pickuppoint);

	/**
	 * @param releasenumber
	 * @param pickupcity
	 * @return
	 */
	int getCheckPickUpCityTempTable(String tblName, int releasenumber, String pickupcity);

	/**
	 * @param releasenumber
	 * @return
	 */
	int getCheckPickUpStateTempTable(String tblName, int releasenumber, String pickupstate);

	/**
	 * @param releasenumber
	 * @param cellnumber
	 * @return
	 */
	int getCheckPickUpCellNumberTempTable(String tblName, int releasenumber, String cellnumber);

	/**
	 * @param releasenumber
	 * @param grade
	 * @return
	 */
	int getCheckGradeTempTable(String tblName, int releasenumber, String grade);

	/**
	 * @param releasenumber
	 * @param careeririd
	 * @return
	 */
	int getCheckCareerirIdTempTable(String tblName, int releasenumber, String careeririd);

	/**
	 * @param releasenumber
	 * @param unloadcomments
	 * @return
	 */
	int getCheckUnloadCommantsTempTable(String tblName, int releasenumber, String unloadcomments);

	/**
	 * @param releasenumber
	 * @param releasenumber2
	 * @return
	 */
	int getCheckReleaseTempTable(String tblName, int releasenumber, int releasenumber2);

	int getCarrirRateTempTable(String tblName, int releasenumber, int carrierRate);

}

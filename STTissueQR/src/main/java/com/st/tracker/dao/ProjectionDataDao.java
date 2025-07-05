/**
 * 
 */
package com.st.tracker.dao;

import java.util.Date;
import java.util.List;

import com.st.tracker.model.BaleInventory;
import com.st.tracker.model.ProjectionData;

/**
 * @author sbora
 *
 */
public interface ProjectionDataDao {

	/**
	 * @param sdate
	 * @param edate
	 * @param gradeIds
	 * @return
	 */
	List<ProjectionData> getProjectionData(Date sdate, Date edate,List<Integer> gradeIds);
	
	
	void saveProjectionDataTemp(List<ProjectionData> projectionDatas);


	/**
	 * @param gradeIds 
	 * @param edate 
	 * @param sdate 
	 * @return
	 */
	List<ProjectionData> getFiberPurchasingDataTemp(Date sdate, Date edate, List<Integer> gradeIds);

	
	void saveFiberPurchasingDataTemp(List<ProjectionData> projectionDatas);


	/**
	 * @param gradeIds 
	 * @param edate 
	 * @param sdate 
	 * @return
	 */
	List<ProjectionData> getProjectionDataTemp(Date sdate, Date edate, List<Integer> gradeIds);


	/**
	 * @param edate 
	 * @param sdate 
	 * @return
	 */
	List<BaleInventory> getConsumedData(Date sdate, Date edate);



}

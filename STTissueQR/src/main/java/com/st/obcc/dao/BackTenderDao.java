/**
 *Jun 13, 2016
 *BackTenderDao.java
 * TODO
 *com.st.obcc.dao
 *BackTenderDao.java
 *Sunil Singh Bora
 */
package com.st.obcc.dao;

import java.util.List;

import com.st.obcc.model.BackTender;

/**
 * @author snavhaal
 *
 */
public interface BackTenderDao {
	
	void saveorUpdate(BackTender data);
	
	BackTender getOperatorData(String position,String shift,String date,String crew) throws Exception;
	
	List<BackTender> getOperatorDataList(String position,String Sdate,String edate,String shift) throws Exception;
	
	long getDataCountDatePercentage(String position,String Sdate,String edate,String shift) throws Exception;

}

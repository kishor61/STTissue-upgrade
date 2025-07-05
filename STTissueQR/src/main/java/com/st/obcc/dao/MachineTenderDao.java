/**
 *Jun 22, 2016
 *MachineTenderDao.java
 * TODO
 *com.st.obcc.dao
 *MachineTenderDao.java
 *Sunil Singh Bora
 */
package com.st.obcc.dao;

import java.util.List;

import com.st.obcc.model.MachineTender;

/**
 * @author snavhaal
 *
 */
public interface MachineTenderDao {
	
	void saveorUpdate(MachineTender data);
	
	MachineTender getOperatorData(String position,String date,String shift,String crew) throws Exception;

	List<MachineTender> getOperatorDataList(String position,String Sdate,String edate,String shift) throws Exception;
	
	long getDataCountDatePercentage(String position,String Sdate,String edate,String shift) throws Exception;
	
}

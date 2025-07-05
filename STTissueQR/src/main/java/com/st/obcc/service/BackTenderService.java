/**
 *Jun 13, 2016
 *BackTenderService.java
 * TODO
 *com.st.obcc.service
 *BackTenderService.java
 *Sunil Singh Bora
 */
package com.st.obcc.service;

import java.util.List;

import com.st.obcc.model.BackTender;

/**
 * @author snavhaal
 *
 */
public interface BackTenderService {

	void saveorUpdate(BackTender data);
	
	BackTender getOperatorData(String position,String date,String shift,String crew) throws Exception;
	
	List<BackTender> getOperatorDataList(String position,String shift ,String sdate,String edate) throws Exception;
	
	long getDataCountDatePercentage(String position,String Sdate,String edate,String shift) throws Exception;
	
	//double getDataCountDatePercentage(String Sdate,String edate) throws Exception;
	
}

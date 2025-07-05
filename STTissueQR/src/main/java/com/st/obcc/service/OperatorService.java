/**
 *Jun 2, 2016
 *OperatorService.java
 * TODO
 *com.st.operator.service
 *OperatorService.java
 *Sunil Singh Bora
 */
package com.st.obcc.service;

import java.util.List;

import com.st.obcc.model.OperatorData;

/**
 * @author snavhaal
 *
 */
public interface OperatorService {
	
	void saveorUpdate(OperatorData data);
	
	OperatorData getOperatorData(String position,String date,String shift,String crew) throws Exception;
	
	List<OperatorData> getOperatorDataList(String position,String Sdate,String edate) throws Exception;
	
/*	long getDataCountDatePercentage(String position,String Sdate,String edate) throws Exception;
	
	double getDataCountDatePercentage(String Sdate,String edate) throws Exception;*/

	/**
	 * @param position
	 * @param Sdate
	 * @param edate
	 * @return
	 * @throws Exception
	 */
	long getDataCountDatePercentage(String position, String Sdate,String edate)throws Exception;

	/**
	 * @param date
	 * @param position
	 * @param shift
	 * @return
	 */
	boolean CheckObcc(String date, String position, String shift);

}

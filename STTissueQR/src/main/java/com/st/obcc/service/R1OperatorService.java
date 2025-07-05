/**
 *Jun 27, 2016
 *R1OperatorService.java
 * TODO
 *com.st.obcc.service
 *R1OperatorService.java
 *Sunil Singh Bora
 */
package com.st.obcc.service;

import java.util.List;

import com.st.obcc.model.R1Operator;

/**
 * @author snavhaal
 *
 */
public interface R1OperatorService {
	
	void saveorUpdate(R1Operator data);
	
	R1Operator getOperatorData(String position,String date,String shift,String crew) throws Exception;
	
	List<R1Operator> getOperatorDataList(String position, String Sdate,String edate) throws Exception;
	
/*	long getDataCountDatePercentage(String position,String Sdate,String edate) throws Exception;
	
	double getDataCountDatePercentage(String Sdate,String edate) throws Exception;*/

	/**
	 * @param position
	 * @param Sdate
	 * @param edate
	 * @return
	 * @throws Exception
	 */
	long getDataCountDatePercentage1(String position, String Sdate,	String edate)
			throws Exception;

}

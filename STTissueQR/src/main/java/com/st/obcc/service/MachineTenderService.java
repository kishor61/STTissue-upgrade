/**
 *Jun 22, 2016
 *MachineTenderService.java
 * TODO
 *com.st.obcc.service
 *MachineTenderService.java
 *Sunil Singh Bora
 */
package com.st.obcc.service;

import java.util.List;

import com.st.obcc.model.MachineTender;
import com.st.obcc.model.R1Operator;

/**
 * @author snavhaal
 *
 */
public interface MachineTenderService {
	
	
	void saveorUpdate(MachineTender data);
	
	MachineTender getOperatorData(String position,String date,String shift,String crew) throws Exception;
	
	List<MachineTender> getOperatorDataList(String position,String Sdate,String edate,String shift) throws Exception;
	
	long getDataCountDatePercentage(String position,String Sdate,String edate,String shift) throws Exception;
	
	/*double getDataCountDatePercentage(String Sdate,String edate) throws Exception;

	*//**
	 * @param position
	 * @param Sdate
	 * @param edate
	 * @param shift
	 * @return
	 * @throws Exception
	 *//*
	int getDataCountDatePercentage1(String position, String Sdate,
			String edate, String shift) throws Exception;*/
}

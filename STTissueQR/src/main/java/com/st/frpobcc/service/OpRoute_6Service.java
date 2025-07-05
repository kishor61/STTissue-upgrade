/**
 *03-Dec-2019
 *OpRoute_6Service.java
 * TODO
 *com.st.frpobcc.service
 *OpRoute_6Service.java
 *Roshan Lal Tailor
 */
package com.st.frpobcc.service;

import java.util.List;

import com.st.frpobcc.model.OpRoute_6;

/**
 * @author sohan
 *
 */
public interface OpRoute_6Service {
	
	void saveorUpdate(OpRoute_6 data);
	List<OpRoute_6> getData(String sdate,String edate);
	long getCountDatePercentage(String sdate,String edate) throws Exception;
}

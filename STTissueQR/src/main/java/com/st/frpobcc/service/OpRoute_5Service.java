/**
 *03-Dec-2019
 *OpRoute_1.java
 * TODO
 *com.st.frpobcc.service
 *OpRoute_5.java
 *Roshan Lal Tailor
 */
package com.st.frpobcc.service;

import java.util.List;

import com.st.frpobcc.model.OpRoute_5;

/**
 * @author sohan
 *
 */
public interface OpRoute_5Service {
	
	void saveorUpdate(OpRoute_5 data);
	List<OpRoute_5> getData(String sdate,String edate);
	long getCountDatePercentage(String sdate,String edate) throws Exception;
}

/**
 *02-Dec-2019
 *OpRoute_1.java
 * TODO
 *com.st.frpobcc.service
 *OpRoute_4.java
 *Roshan Lal Tailor
 */
package com.st.frpobcc.service;

import java.util.List;

import com.st.frpobcc.model.OpRoute_4;

/**
 * @author sohan
 *
 */
public interface OpRoute_4Service {
	
	void saveorUpdate(OpRoute_4 data);
	List<OpRoute_4> getData(String sdate,String edate);
	long getCountDatePercentage(String sdate,String edate) throws Exception;

}

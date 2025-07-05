/**
 *27-Nov-2019
 *OpRoute_1.java
 * TODO
 *com.st.frpobcc.service
 *OpRoute_1.java
 *Roshan Lal Tailor
 */
package com.st.frpobcc.service;

import java.util.List;

import com.st.frpobcc.model.OpRoute_2;

/**
 * @author sohan
 *
 */
public interface OpRoute_2Service {
	
	void saveorUpdate(OpRoute_2 data);
	List<OpRoute_2> getData(String sdate,String edate);
	long getCountDatePercentage(String sdate,String edate) throws Exception;
}

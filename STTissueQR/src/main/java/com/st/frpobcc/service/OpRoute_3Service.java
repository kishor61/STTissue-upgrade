/**
 *29-Nov-2019
 *OpRoute_1.java
 * TODO
 *com.st.frpobcc.service
 *OpRoute_3.java
 *Roshan Lal Tailor
 */
package com.st.frpobcc.service;

import java.util.List;

import com.st.frpobcc.model.OpRoute_3;

/**
 * @author sohan
 *
 */
public interface OpRoute_3Service {
	
	void saveorUpdate(OpRoute_3 data);
	List<OpRoute_3> getData(String sdate,String edate);
	long getCountDatePercentage(String sdate,String edate) throws Exception;
}

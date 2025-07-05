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

import com.st.frpobcc.model.OpRoute_1;


/**
 * @author sohan
 *
 */
public interface OpRoute_1Service {
	
	void saveorUpdate(OpRoute_1 data);
	List<OpRoute_1> getData(String sdate,String edate);
	long getCountDatePercentage(String sdate,String edate) throws Exception;
}

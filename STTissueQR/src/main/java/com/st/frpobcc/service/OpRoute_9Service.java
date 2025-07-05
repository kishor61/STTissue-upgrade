/**
 *07-Dec-2019
 *OpRoute_9Service.java
 * TODO
 *com.st.frpobcc.service
 *OpRoute_9Service.java
 *Sohan Lal Bairwa
 */
package com.st.frpobcc.service;

import java.util.List;

import com.st.frpobcc.model.OpRoute_9;

/**
 * @author sohan
 *
 */
public interface OpRoute_9Service {
	void saveorUpdate(OpRoute_9 data);
	List<OpRoute_9> getData(String sdate,String edate);
	long getCountDatePercentage(String sdate,String edate) throws Exception;
}

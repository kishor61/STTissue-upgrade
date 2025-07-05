/**
 *05-Dec-2019
 *OpRoute_7Service.java
 * TODO
 *com.st.frpobcc.service
 *OpRoute_7Service.java
 *Sohan Lal Bairwa
 */
package com.st.frpobcc.service;

import java.util.List;

import com.st.frpobcc.model.OpRoute_7;

/**
 * @author sohan
 *
 */
public interface OpRoute_7Service {
	void saveorUpdate(OpRoute_7 data);
	List<OpRoute_7> getData(String sdate,String edate);
	long getCountDatePercentage(String sdate,String edate) throws Exception;
}

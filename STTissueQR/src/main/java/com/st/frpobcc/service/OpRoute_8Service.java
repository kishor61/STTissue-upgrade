/**
 *06-Dec-2019
 *OpRoute_8Service.java
 * TODO
 *com.st.frpobcc.service
 *OpRoute_8Service.java
 *Sohan Lal Bairwa
 */
package com.st.frpobcc.service;

import java.util.List;

import com.st.frpobcc.model.OpRoute_8;

/**
 * @author sohan
 *
 */
public interface OpRoute_8Service {
	void saveorUpdate(OpRoute_8 data);
	List<OpRoute_8> getData(String sdate,String edate);
	long getCountDatePercentage(String sdate,String edate) throws Exception;
}

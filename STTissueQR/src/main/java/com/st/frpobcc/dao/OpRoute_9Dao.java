/**
 *07-Dec-2019
 *OpRoute_9Dao.java
 * TODO
 *com.st.frpobcc.dao
 *OpRoute_9Dao.java
 *Sohan Lal Bairwa
 */
package com.st.frpobcc.dao;

import java.util.List;

import com.st.frpobcc.model.OpRoute_9;

/**
 * @author sohan
 *
 */
public interface OpRoute_9Dao {
	void saveorUpdate(OpRoute_9 data);
	List<OpRoute_9> getData(String sdate, String edate);	
	long getCountDatePercentage(String sdate, String edate) throws Exception;
	/**
	 * @param sdate
	 * @param edate
	 * @return
	 * @throws Exception
	 */
	List<Integer> getCount(String sdate, String edate) throws Exception;
}	
	

/**
 *05-Dec-2019
 *OpRoute_7Dao.java
 * TODO
 *com.st.frpobcc.dao
 *OpRoute_7Dao.java
 *Sohan Lal Bairwa
 */
package com.st.frpobcc.dao;

import java.util.List;

import com.st.frpobcc.model.OpRoute_7;

/**
 * @author sohan
 *
 */
public interface OpRoute_7Dao {
	
	void saveorUpdate(OpRoute_7 data);
	List<OpRoute_7> getData(String sdate,String edate);
	/**
	 * @param date
	 * @return
	 * @throws Exception
	 */
	long getCountDatePercentage(String sdate,String edate) throws Exception;
	/**
	 * @param sdate
	 * @param edate
	 * @return
	 * @throws Exception
	 */
	List<Integer> getCount(String sdate, String edate) throws Exception;
}
/**
 *06-Dec-2019
 *OpRoute_8Dao.java
 * TODO
 *com.st.frpobcc.dao
 *OpRoute_8Dao.java
 *Sohan Lal Bairwa
 */
package com.st.frpobcc.dao;

import java.util.List;

import com.st.frpobcc.model.OpRoute_8;

/**
 * @author sohan
 *
 */
public interface OpRoute_8Dao {
	void saveorUpdate(OpRoute_8 data);
	List<OpRoute_8> getData(String sdate,String edate);
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

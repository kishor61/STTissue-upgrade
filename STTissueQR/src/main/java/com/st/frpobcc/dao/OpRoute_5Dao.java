/**
 *03-Dec-2019
 *OpRoute_2Dao.java
 * TODO
 *com.st.frpobcc.dao
 *OpRoute_5Dao.java
 *Roshan Lal Tailor
 */
package com.st.frpobcc.dao;

import java.util.List;

import com.st.frpobcc.model.OpRoute_5;

/**
 * @author sohan
 *
 */
public interface OpRoute_5Dao {
	void saveorUpdate(OpRoute_5 data);
	List<OpRoute_5> getData(String sdate,String edate);
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

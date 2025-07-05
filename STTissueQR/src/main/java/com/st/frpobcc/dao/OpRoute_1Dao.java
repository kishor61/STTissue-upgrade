/**
 *27-Nov-2019
 *OpRoute_1Dao.java
 * TODO
 *com.st.frpobcc.dao
 *OpRoute_1Dao.java
 *Roshan Lal Tailor
 */
package com.st.frpobcc.dao;

import java.util.List;

import com.st.frpobcc.model.OpRoute_1;

/**
 * @author sohan
 *
 */
public interface OpRoute_1Dao {
	void saveorUpdate(OpRoute_1 data);

	/**
	 * @param date
	 * @return
	 */
	List<OpRoute_1> getData(String sdate,String edate);

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

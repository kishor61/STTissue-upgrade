/**
 *27-Nov-2019
 *OpRoute_2Dao.java
 * TODO
 *com.st.frpobcc.dao
 *OpRoute_2Dao.java
 *Roshan Lal Tailor
 */
package com.st.frpobcc.dao;

import java.util.List;

import com.st.frpobcc.model.OpRoute_2;

/**
 * @author sohan
 *
 */
public interface OpRoute_2Dao {
	void saveorUpdate(OpRoute_2 data);

	/**
	 * @param date
	 * @return
	 */
	List<OpRoute_2> getData(String sdate,String edate);

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

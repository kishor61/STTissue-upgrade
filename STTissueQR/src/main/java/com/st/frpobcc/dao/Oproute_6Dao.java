/**
 *03-Dec-2019
 *Oproute_6Dao.java
 * TODO
 *com.st.frpobcc.dao
 *Oproute_6Dao.java
 *Roshan Lal Tailor
 */
package com.st.frpobcc.dao;

import java.util.List;

import com.st.frpobcc.model.OpRoute_6;

/**
 * @author sohan
 *
 */
public interface Oproute_6Dao {

	void saveorUpdate(OpRoute_6 data);
	List<OpRoute_6> getData(String sdate,String edate);
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

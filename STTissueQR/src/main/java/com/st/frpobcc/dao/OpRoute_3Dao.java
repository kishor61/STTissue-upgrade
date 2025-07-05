/**
 *29-Nov-2019
 *OpRoute_2Dao.java
 * TODO
 *com.st.frpobcc.dao
 *OpRoute_3Dao.java
 *Roshan Lal Tailor
 */
package com.st.frpobcc.dao;

import java.util.List;

import com.st.frpobcc.model.OpRoute_3;

/**
 * @author sohan
 *
 */
public interface OpRoute_3Dao {
	void saveorUpdate(OpRoute_3 data);
	List<OpRoute_3> getData(String sdate,String edate);
	long getCountDatePercentage(String sdate,String edate) throws Exception;
	/**
	 * @param sdate
	 * @param edate
	 * @return
	 * @throws Exception
	 */
	List<Integer> getCount(String sdate, String edate) throws Exception;

}

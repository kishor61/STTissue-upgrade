/**
 *Oct 24, 2019
 *OperatorPM5Dao.java
 * TODO
 *com.st.obccPM5.dao
 *OperatorPM5Dao.java
 *Roshan Lal Tailor
 */
package com.st.obccPM5.dao;

import com.st.obccPM5.model.OperatorPM5;

/**
 * @author roshan
 *
 */
public interface OperatorPM5Dao {


	/**
	 * @param data
	 */
	void saveorUpdate(OperatorPM5 data);

	/**
	 * @param date
	 * @param position
	 * @param shift
	 * @return
	 */
	boolean CheckObcc(String date, String position, String shift);}

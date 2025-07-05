/**
 *Oct 24, 2019
 *OperatorPM5Service.java
 * TODO
 *com.st.obccPM5.service
 *OperatorPM5Service.java
 *Roshan Lal Tailor
 */
package com.st.obccPM5.service;

import com.st.obccPM5.model.OperatorPM5;


/**
 * @author roshan
 *
 */
public interface OperatorPM5Service {
	void saveorUpdate(OperatorPM5 data);


	/**
	 * @param date
	 * @param position
	 * @param shift
	 * @return
	 */
	boolean CheckObcc(String date, String position, String shift);}

/**
 *Oct 23, 2019
 *StockOperatorPM55Service.java
 * TODO
 *com.st.obccPM5.service
 *StockOperatorPM55Service.java
 *Roshan Lal Tailor
 */
package com.st.obccPM5.service;

import java.text.ParseException;
import java.util.List;
import com.st.obccPM5.model.StockOperatorPM5;

/**
 * @author Sohan
 *
 */
public interface StockOperatorPM5Service {
	
	void saveorUpdate(StockOperatorPM5 data);

	/**
	 * @param position
	 * @param startDate
	 * @param endDate
	 * @param shift
	 * @return
	 * @throws ParseException 
	 */
	long getDataCountDatePercentage(String position, String startDate,String endDate, String shift) throws ParseException;

	/**
	 * @param position
	 * @param startDate
	 * @param endDate
	 * @param shift
	 * @return
	 */
	List<StockOperatorPM5> getStockOperatorPm5DataList(String position,
			String startDate, String endDate, String shift);

	/**
	 * @param position
	 * @param shift
	 * @param date
	 * @return
	 */
	StockOperatorPM5 getOperatorData(String position, String shift, String date);}

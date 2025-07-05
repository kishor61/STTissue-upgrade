/**
 *Oct 23, 2019
 *StockOperatorPM5Dao.java
 * TODO
 *com.st.obccPM5.dao
 *StockOperatorPM5Dao.java
 *Roshan Lal Tailor
 */
package com.st.obccPM5.dao;
import java.text.ParseException;
import java.util.List;
import com.st.obccPM5.model.StockOperatorPM5;

/**
 * @author roshan
 *
 */
public interface StockOperatorPM5Dao {
	
	void saveorUpdate(StockOperatorPM5 data);


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
	StockOperatorPM5 getOperatorData(String position, String shift, String date);


	/**
	 * @param position
	 * @param sdate
	 * @param edate
	 * @param shift
	 * @return
	 * @throws ParseException 
	 */
	long getDataCountDatePercentage(String position, String sdate, String edate, String shift) throws ParseException;
}

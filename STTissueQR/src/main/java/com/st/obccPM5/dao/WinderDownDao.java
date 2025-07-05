/**
 *May 7, 2021
 *WinderDownDao.java
 * TODO
 *com.st.obccPM5.dao
 *WinderDownDao.java
 *Sohan Lal 
 */
package com.st.obccPM5.dao;

import java.text.ParseException;
import java.util.List;

import com.st.obccPM5.model.WinderDown;

/**
 * @author Sohanlal
 *
 */
public interface WinderDownDao {void saveorUpdate(WinderDown data);


/**
 * @param position
 * @param sdate
 * @param edate
 * @param shift
 * @return
 */
List<WinderDown> getOperatorDataList(String position, String sdate,
		String edate, String shift);
List<WinderDown> getOperatorDataListForBothShift(String position, String sdate,
		String edate);


/**
 * @param position
 * @param sdate
 * @param edate
 * @param shift
 * @return
 */
WinderDown getOperatorData(String position,
		String date, String shift,String crew);


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


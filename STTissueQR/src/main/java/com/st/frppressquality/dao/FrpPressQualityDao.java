/**
 * 
 */
package com.st.frppressquality.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.st.frppressquality.model.FrpDailyData;
import com.st.frppressquality.model.FrpPressQuality;
import com.st.frppressquality.model.SludgeHauling;
import com.st.frppressquality.model.StickiesData;

/**
 * @author sbora
 *
 */
public interface FrpPressQualityDao {

	/**
	 * @param frpPressQuality
	 * @return
	 */
	int save(FrpPressQuality frpPressQuality);

	/**
	 * @param frpPressQuality
	 */
	void update(FrpPressQuality frpPressQuality);

	/**
	 * @param sdate
	 * @param edate
	 * @param type
	 * @return
	 */
	List<FrpPressQuality> getFrpPressQualities(Date sdate, Date edate,
			String type);

	/**
	 * @param frpPressQuality
	 * @return
	 */
	boolean isLotExist(FrpPressQuality frpPressQuality);

	/**
	 * @param id
	 */
	void delete(int id);

	/**
	 * @param id
	 * @return
	 */
	FrpPressQuality getFrpPressQuality(int id);

	/**
	 * @return
	 */
	double getBirghtnessAvgOfDay();

	/**
	 * @return
	 */
	double getBirghtnessAvgOfLastDay();

	/**
	 * @param date
	 * @return
	 */
	double getBirghtnessAvgByDate(Date date);

	/**
	 * @param date
	 * @return
	 */
	double getSludgConsistencyAvg(Date date);

	/**
	 * @param sludgeHauling
	 * @return
	 */
	int saveOrUpdate(SludgeHauling sludgeHauling);

	/**
	 * @param sdate
	 * @param edate
	 * @return
	 */
	List<SludgeHauling> getSludgeHauling(Date sdate, Date edate);

	/**
	 * @param id
	 */
	void deleteSludgeHauling(int id);

	/**
	 * @param id
	 * @return
	 */
	SludgeHauling getSludgeHauling(int id);

	/**
	 * @param sdate
	 * @param edate
	 * @return
	 */
	List<FrpDailyData> getDailyReportData(Date sdate, Date edate);

	/**
	 * @param sdate
	 * @param edate
	 * @return
	 */
	List<FrpDailyData> getMonthlyReportData(Date sdate, Date edate);

	/**
	 * @param sdate
	 * @param edate
	 * @param grade 
	 * @return
	 */
	List<FrpDailyData> getFiberBalanceReportData(Date sdate, Date edate, String grade);

	/**
	 * @return
	 */
	List<Map<String, Object>> getBirghtness();

/**
	 * @param date
	 * @return
	 */
//	Code Starts From Here Done By Roshan TAilor Date :- 03/21/2015 MM/DD/YYYY
	Map<String, Object> getPressQualityInfo(Date date);
//	Code Ends Here Done By Roshan Tailor

/**
 * @param stickiesData
 * @return
 */
int saveOrUpdate(StickiesData stickiesData);

/**
 * @param sdate
 * @param edate
 * @return
 */
List<StickiesData> getStickiesData(Date sdate, Date edate);

/**
 * @param stickiesData
 */
void update(StickiesData stickiesData);

/**
 * @param id
 */
void deleteStickiedata(int id);

List<StickiesData> getStickiesDataById(int id);
}

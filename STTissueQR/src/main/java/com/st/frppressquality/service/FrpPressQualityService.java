/**
 * 
 */
package com.st.frppressquality.service;

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
public interface FrpPressQualityService {

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
	 * @param checkDate
	 * @return
	 */
	double getBirghtnessAvgByDate(Date date);

	/**
	 * @param checkDate
	 * @return
	 */
	double getSludgConsistencyAvg(Date checkDate);

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
	 * @param checkDate
	 * @param checkDate2
	 * @return
	 */
	List<FrpDailyData> getDailyReportData(Date sdate, Date edate);

	/**
	 * @param checkDate
	 * @param checkDate2
	 * @return
	 */
	List<FrpDailyData> getMonthlyReportData(Date sdate, Date edate);

	/**
	 * @param checkDate
	 * @param checkDate2
	 * @param grade 
	 * @return
	 */
	List<FrpDailyData> getFiberBalanceReportData(Date checkDate, Date checkDate2, String grade);

	/**
	 * @return
	 */
	List<Map<String, Object>> getBirghtness();

	/**
	 * @param d
	 * @return
	 */
//	Code Starts From Here Done By Roshan TAilor Date : -03/21/2015
	Map<String, Object> getPressQualityInfo(Date date);

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

//	Code Ends Here Done By Roshan Tailor
}

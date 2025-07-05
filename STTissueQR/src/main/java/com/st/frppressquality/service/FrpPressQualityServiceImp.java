/**
 * 
 */
package com.st.frppressquality.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.st.frppressquality.dao.FrpPressQualityDao;
import com.st.frppressquality.model.FrpDailyData;
import com.st.frppressquality.model.FrpPressQuality;
import com.st.frppressquality.model.SludgeHauling;
import com.st.frppressquality.model.StickiesData;

/**
 * @author sbora
 *
 */
@Service
public class FrpPressQualityServiceImp implements FrpPressQualityService {

	@Autowired
	private FrpPressQualityDao frpPressQualityDao;
	
	
	@Transactional
	@Override
	public int save(FrpPressQuality frpPressQuality) {
		return frpPressQualityDao.save(frpPressQuality);
	}

	@Transactional
	@Override
	public void update(FrpPressQuality frpPressQuality) {
		frpPressQualityDao.update(frpPressQuality);
	}

	@Transactional
	@Override
	public List<FrpPressQuality> getFrpPressQualities(Date sdate, Date edate,
			String type) {
		return frpPressQualityDao.getFrpPressQualities(sdate,edate,type);
	}

	@Transactional
	@Override
	public boolean isLotExist(FrpPressQuality frpPressQuality) {
		return frpPressQualityDao.isLotExist(frpPressQuality);
	}

	@Transactional
	@Override
	public void delete(int id) {
		frpPressQualityDao.delete(id);
	}

	@Transactional
	@Override
	public FrpPressQuality getFrpPressQuality(int id) {
		return frpPressQualityDao.getFrpPressQuality(id);
	}

	/* (non-Javadoc)
	 * @see com.st.frppressquality.service.FrpPressQualityService#getBirghtnessAvgOfDay()
	 */
	@Transactional
	@Override
	public double getBirghtnessAvgOfDay() {
		return frpPressQualityDao.getBirghtnessAvgOfDay();
	}

	/* (non-Javadoc)
	 * @see com.st.frppressquality.service.FrpPressQualityService#getBirghtnessAvgOfLastDay()
	 */
	@Transactional
	@Override
	public double getBirghtnessAvgOfLastDay() {
		return frpPressQualityDao.getBirghtnessAvgOfLastDay();
	}

	/* (non-Javadoc)
	 * @see com.st.frppressquality.service.FrpPressQualityService#getBirghtnessAvgByDate(java.util.Date)
	 */
	@Transactional
	@Override
	public double getBirghtnessAvgByDate(Date date) {
		return frpPressQualityDao.getBirghtnessAvgByDate(date);
	}

	/* (non-Javadoc)
	 * @see com.st.frppressquality.service.FrpPressQualityService#getSludgConsistencyAvg(java.util.Date)
	 */
	@Transactional
	@Override
	public double getSludgConsistencyAvg(Date date) {
		return frpPressQualityDao.getSludgConsistencyAvg(date);
	}

	/* (non-Javadoc)
	 * @see com.st.frppressquality.service.FrpPressQualityService#saveOrUpdate(com.st.frppressquality.model.SludgeHauling)
	 */
	
	@Transactional
	@Override
	public int saveOrUpdate(SludgeHauling sludgeHauling) {
		
		return frpPressQualityDao.saveOrUpdate(sludgeHauling);
	}

	/* (non-Javadoc)
	 * @see com.st.frppressquality.service.FrpPressQualityService#getSludgeHauling(java.util.Date, java.util.Date)
	 */
	@Transactional
	@Override
	public List<SludgeHauling> getSludgeHauling(Date sdate, Date edate) {
		
		return frpPressQualityDao.getSludgeHauling(sdate,edate);
	}

	/* (non-Javadoc)
	 * @see com.st.frppressquality.service.FrpPressQualityService#deleteSludgeHauling(int)
	 */
	@Transactional
	@Override
	public void deleteSludgeHauling(int id) {
		frpPressQualityDao.deleteSludgeHauling(id);
	}

	/* (non-Javadoc)
	 * @see com.st.frppressquality.service.FrpPressQualityService#getSludgeHauling(int)
	 */
	@Transactional
	@Override
	public SludgeHauling getSludgeHauling(int id) {
		
		return frpPressQualityDao.getSludgeHauling(id);
	}

	/* (non-Javadoc)
	 * @see com.st.frppressquality.service.FrpPressQualityService#getDailyReportData(java.util.Date, java.util.Date)
	 */
	@Transactional
	@Override
	public List<FrpDailyData> getDailyReportData(Date sdate, Date edate) {
		return frpPressQualityDao.getDailyReportData(sdate,edate);
	}

	/* (non-Javadoc)
	 * @see com.st.frppressquality.service.FrpPressQualityService#getMonthlyReportData(java.util.Date, java.util.Date)
	 */
	@Transactional
	@Override
	public List<FrpDailyData> getMonthlyReportData(Date sdate, Date edate) {
		return frpPressQualityDao.getMonthlyReportData(sdate,edate);
	}

	/* (non-Javadoc)
	 * @see com.st.frppressquality.service.FrpPressQualityService#getFiberBalanceReportData(java.util.Date, java.util.Date)
	 */
	@Transactional
	@Override
	public List<FrpDailyData> getFiberBalanceReportData(Date sdate,
			Date edate,String grade) {
		return frpPressQualityDao.getFiberBalanceReportData(sdate,edate,grade);
	}

	/* (non-Javadoc)
	 * @see com.st.frppressquality.service.FrpPressQualityService#getBirghtness()
	 */
	@Transactional
	@Override
	public List<Map<String, Object>> getBirghtness() {
		return frpPressQualityDao.getBirghtness();
	}

	/* (non-Javadoc)
	 * @see com.st.frppressquality.service.FrpPressQualityService#getPressQualityInfo(java.util.Date)
	 */
//Code Starts From Here Done By Roshan Tailor Date :- 03/18/2015
	@Transactional
	@Override
	public Map<String, Object> getPressQualityInfo(Date date) {
		//System.out.println("Date 2::::"+date);
		return frpPressQualityDao.getPressQualityInfo(date);
	}
//Code Ends Here Done By Roshan Tailor

	/* (non-Javadoc)
	 * @see com.st.frppressquality.service.FrpPressQualityService#saveOrUpdate(com.st.frppressquality.model.StickiesData)
	 */
	@Override
	public int saveOrUpdate(StickiesData stickiesData) {
		// TODO Auto-generated method stub
		return frpPressQualityDao.saveOrUpdate(stickiesData);
	}

	/* (non-Javadoc)
	 * @see com.st.frppressquality.service.FrpPressQualityService#getStickiesData(java.util.Date, java.util.Date)
	 */
	@Override
	public List<StickiesData> getStickiesData(Date sdate, Date edate) {
		// TODO Auto-generated method stub
		return frpPressQualityDao.getStickiesData(sdate,edate);
	}

	/* (non-Javadoc)
	 * @see com.st.frppressquality.service.FrpPressQualityService#update(com.st.frppressquality.model.StickiesData)
	 */
	@Override
	public void update(StickiesData stickiesData) {
		// TODO Auto-generated method stub
		frpPressQualityDao.update(stickiesData);
	}

	/* (non-Javadoc)
	 * @see com.st.frppressquality.service.FrpPressQualityService#deleteStickiedata(int)
	 */
	@Override
	public void deleteStickiedata(int id) {
		// TODO Auto-generated method stub
		frpPressQualityDao.deleteStickiedata(id);
		
	}

	@Override
	public List<StickiesData> getStickiesDataById(int id) {
		// TODO Auto-generated method stub
		return frpPressQualityDao.getStickiesDataById(id);
	}
}

/**
 * 
 */
package com.st.frpefficiency.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.st.frpefficiency.dao.FrpEfficiencyCodeDao;
import com.st.frpefficiency.model.FrpEfficiency;
import com.st.frpefficiency.model.FrpPrimaryCode;
import com.st.frpefficiency.model.FrpSecondaryCode;

/**
 * @author sbora
 *
 */
@Service
public class FrpEfficiencyCodeServiceImp implements FrpEfficiencyCodeService {

	
	@Autowired
	private FrpEfficiencyCodeDao frpEfficiencyCodeDao;
	
	/* (non-Javadoc)
	 * @see com.st.efficiency.service.EfficencyCodeService#getPrimaryCode()
	 */
	@Transactional
	@Override
	public FrpPrimaryCode getPrimaryCode(int id) {
		
		return frpEfficiencyCodeDao.getPrimaryCode(id);
	}

	/* (non-Javadoc)
	 * @see com.st.efficiency.service.EfficencyCodeService#getSecondaryCode()
	 */
	@Transactional
	@Override
	public FrpSecondaryCode getSecondaryCode(int id) {
		
		return frpEfficiencyCodeDao.getSecondaryCode(id);
	}

	/* (non-Javadoc)
	 * @see com.st.efficiency.service.EfficencyCodeService#getPrimaryCodes()
	 */
	@Transactional
	@Override
	public List<FrpPrimaryCode> getPrimaryCodes() {
		
		return frpEfficiencyCodeDao.getPrimaryCodes();
	}

	/* (non-Javadoc)
	 * @see com.st.efficiency.service.EfficencyCodeService#getSecondaryCodes(com.st.efficiency.model.PrimaryCode)
	 */
	@Transactional
	@Override
	public List<FrpSecondaryCode> getSecondaryCodes(FrpPrimaryCode code) {
		
		return frpEfficiencyCodeDao.getSecondaryCodes(code);
	}

	/* (non-Javadoc)
	 * @see com.st.efficiency.service.EfficencyCodeService#add(com.st.efficiency.model.PrimaryCode)
	 */
	@Transactional
	@Override
	public int add(FrpPrimaryCode code) {
		
		return frpEfficiencyCodeDao.add(code);
	}

	/* (non-Javadoc)
	 * @see com.st.efficiency.service.EfficencyCodeService#add(com.st.efficiency.model.SecondaryCode)
	 */
	@Transactional
	@Override
	public int add(FrpSecondaryCode code) {
		
		return frpEfficiencyCodeDao.add(code);
	}

	/* (non-Javadoc)
	 * @see com.st.efficiency.service.EfficencyCodeService#update(com.st.efficiency.model.PrimaryCode)
	 */
	@Transactional
	@Override
	public void update(FrpPrimaryCode code) {
		frpEfficiencyCodeDao.update(code);

	}

	/* (non-Javadoc)
	 * @see com.st.efficiency.service.EfficencyCodeService#update(com.st.efficiency.model.SecondaryCode)
	 */
	@Transactional
	@Override
	public void update(FrpSecondaryCode code) {
		frpEfficiencyCodeDao.update(code);

	}

	/* (non-Javadoc)
	 * @see com.st.efficiency.service.EfficencyCodeService#delete(com.st.efficiency.model.PrimaryCode)
	 */
	@Transactional
	@Override
	public void delete(FrpPrimaryCode code) {
		frpEfficiencyCodeDao.delete(code);

	}

	/* (non-Javadoc)
	 * @see com.st.efficiency.service.EfficencyCodeService#delete(com.st.efficiency.model.SecondaryCode)
	 */
	@Transactional
	@Override
	public void delete(FrpSecondaryCode code) {
		frpEfficiencyCodeDao.delete(code);

	}

	/* (non-Javadoc)
	 * @see com.st.efficiency.service.EfficencyCodeService#getSecondaryCodes()
	 */
	@Transactional
	@Override
	public List<FrpSecondaryCode> getSecondaryCodes() {
		return frpEfficiencyCodeDao.getSecondaryCodes();
	}

	/* (non-Javadoc)
	 * @see com.st.frpefficiency.service.FrpEfficiencyCodeService#getSummaryData(java.util.Date, java.util.Date, int, int)
	 */
	@Transactional
	@Override
	public List<FrpEfficiency> getSummaryData(Date sdate, Date edate,
			int pcode, int scode) {
		// TODO Auto-generated method stub
		return frpEfficiencyCodeDao.getSummaryData(sdate,edate,pcode,scode);
	}

}

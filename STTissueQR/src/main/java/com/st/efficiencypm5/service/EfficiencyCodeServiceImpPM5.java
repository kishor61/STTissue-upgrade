/**
 * 
 */
package com.st.efficiencypm5.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.st.efficiency.dao.EfficiencyCodeDao;
import com.st.efficiency.model.Efficiency;
import com.st.efficiency.model.PrimaryCode;
import com.st.efficiency.model.SecondaryCode;
import com.st.efficiencypm5.dao.EfficiencyCodeDaoPM5;
import com.st.efficiencypm5.model.EfficiencyPM5;
import com.st.efficiencypm5.model.PrimaryCodePM5;
import com.st.efficiencypm5.model.SecondaryCodePM5;

/**
 * @author sbora
 *
 */
@Service
public class EfficiencyCodeServiceImpPM5 implements EfficiencyCodeServicePM5 {

	
	@Autowired
	private EfficiencyCodeDaoPM5 efficencyCodeDao;
	
	/* (non-Javadoc)
	 * @see com.st.efficiency.service.EfficencyCodeService#getPrimaryCode()
	 */
	@Transactional
	@Override
	public PrimaryCodePM5 getPrimaryCode(int id) {
		
		return efficencyCodeDao.getPrimaryCode(id);
	}

	/* (non-Javadoc)
	 * @see com.st.efficiency.service.EfficencyCodeService#getSecondaryCode()
	 */
	@Transactional
	@Override
	public SecondaryCodePM5 getSecondaryCode(int id) {
		
		return efficencyCodeDao.getSecondaryCode(id);
	}

	/* (non-Javadoc)
	 * @see com.st.efficiency.service.EfficencyCodeService#getPrimaryCodes()
	 */
	@Transactional
	@Override
	public List<PrimaryCodePM5> getPrimaryCodes() {
		
		return efficencyCodeDao.getPrimaryCodes();
	}

	/* (non-Javadoc)
	 * @see com.st.efficiency.service.EfficencyCodeService#getSecondaryCodes(com.st.efficiency.model.PrimaryCode)
	 */
	@Transactional
	@Override
	public List<SecondaryCodePM5> getSecondaryCodes(PrimaryCodePM5 code) {
		
		return efficencyCodeDao.getSecondaryCodes(code);
	}

	/* (non-Javadoc)
	 * @see com.st.efficiency.service.EfficencyCodeService#add(com.st.efficiency.model.PrimaryCode)
	 */
	@Transactional
	@Override
	public int add(PrimaryCodePM5 code) {
		
		return efficencyCodeDao.add(code);
	}

	/* (non-Javadoc)
	 * @see com.st.efficiency.service.EfficencyCodeService#add(com.st.efficiency.model.SecondaryCode)
	 */
	@Transactional
	@Override
	public int add(SecondaryCodePM5 code) {
		
		return efficencyCodeDao.add(code);
	}

	/* (non-Javadoc)
	 * @see com.st.efficiency.service.EfficencyCodeService#update(com.st.efficiency.model.PrimaryCode)
	 */
	@Transactional
	@Override
	public void update(PrimaryCodePM5 code) {
		efficencyCodeDao.update(code);

	}

	/* (non-Javadoc)
	 * @see com.st.efficiency.service.EfficencyCodeService#update(com.st.efficiency.model.SecondaryCode)
	 */
	@Transactional
	@Override
	public void update(SecondaryCodePM5 code) {
		efficencyCodeDao.update(code);

	}

	/* (non-Javadoc)
	 * @see com.st.efficiency.service.EfficencyCodeService#delete(com.st.efficiency.model.PrimaryCode)
	 */
	@Transactional
	@Override
	public void delete(PrimaryCodePM5 code) {
		efficencyCodeDao.delete(code);

	}

	/* (non-Javadoc)
	 * @see com.st.efficiency.service.EfficencyCodeService#delete(com.st.efficiency.model.SecondaryCode)
	 */
	@Transactional
	@Override
	public void delete(SecondaryCodePM5 code) {
		efficencyCodeDao.delete(code);

	}

	/* (non-Javadoc)
	 * @see com.st.efficiency.service.EfficencyCodeService#getSecondaryCodes()
	 */
	@Transactional
	@Override
	public List<SecondaryCodePM5> getSecondaryCodes() {
		return efficencyCodeDao.getSecondaryCodes();
	}

	/* (non-Javadoc)
	 * @see com.st.efficiency.service.EfficiencyCodeService#getSummaryData(java.util.Date, java.util.Date, int, int)
	 */
	@Transactional
	@Override
	public List<EfficiencyPM5> getSummaryData(Date sdate, Date edate, int pcode,
			int scode) {
		return efficencyCodeDao.getSummaryData(sdate,edate,pcode,scode);
	}

}

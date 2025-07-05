/**
 * 
 */
package com.st.efficiency.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.st.efficiency.dao.EfficiencyCodeDao;
import com.st.efficiency.model.Efficiency;
import com.st.efficiency.model.PrimaryCode;
import com.st.efficiency.model.SecondaryCode;

/**
 * @author sbora
 *
 */
@Service
public class EfficiencyCodeServiceImp implements EfficiencyCodeService {

	
	@Autowired
	private EfficiencyCodeDao efficencyCodeDao;
	
	/* (non-Javadoc)
	 * @see com.st.efficiency.service.EfficencyCodeService#getPrimaryCode()
	 */
	@Transactional
	@Override
	public PrimaryCode getPrimaryCode(int id) {
		
		return efficencyCodeDao.getPrimaryCode(id);
	}

	/* (non-Javadoc)
	 * @see com.st.efficiency.service.EfficencyCodeService#getSecondaryCode()
	 */
	@Transactional
	@Override
	public SecondaryCode getSecondaryCode(int id) {
		
		return efficencyCodeDao.getSecondaryCode(id);
	}

	/* (non-Javadoc)
	 * @see com.st.efficiency.service.EfficencyCodeService#getPrimaryCodes()
	 */
	@Transactional
	@Override
	public List<PrimaryCode> getPrimaryCodes() {
		
		return efficencyCodeDao.getPrimaryCodes();
	}

	/* (non-Javadoc)
	 * @see com.st.efficiency.service.EfficencyCodeService#getSecondaryCodes(com.st.efficiency.model.PrimaryCode)
	 */
	@Transactional
	@Override
	public List<SecondaryCode> getSecondaryCodes(PrimaryCode code) {
		
		return efficencyCodeDao.getSecondaryCodes(code);
	}

	/* (non-Javadoc)
	 * @see com.st.efficiency.service.EfficencyCodeService#add(com.st.efficiency.model.PrimaryCode)
	 */
	@Transactional
	@Override
	public int add(PrimaryCode code) {
		
		return efficencyCodeDao.add(code);
	}

	/* (non-Javadoc)
	 * @see com.st.efficiency.service.EfficencyCodeService#add(com.st.efficiency.model.SecondaryCode)
	 */
	@Transactional
	@Override
	public int add(SecondaryCode code) {
		
		return efficencyCodeDao.add(code);
	}

	/* (non-Javadoc)
	 * @see com.st.efficiency.service.EfficencyCodeService#update(com.st.efficiency.model.PrimaryCode)
	 */
	@Transactional
	@Override
	public void update(PrimaryCode code) {
		efficencyCodeDao.update(code);

	}

	/* (non-Javadoc)
	 * @see com.st.efficiency.service.EfficencyCodeService#update(com.st.efficiency.model.SecondaryCode)
	 */
	@Transactional
	@Override
	public void update(SecondaryCode code) {
		efficencyCodeDao.update(code);

	}

	/* (non-Javadoc)
	 * @see com.st.efficiency.service.EfficencyCodeService#delete(com.st.efficiency.model.PrimaryCode)
	 */
	@Transactional
	@Override
	public void delete(PrimaryCode code) {
		efficencyCodeDao.delete(code);

	}

	/* (non-Javadoc)
	 * @see com.st.efficiency.service.EfficencyCodeService#delete(com.st.efficiency.model.SecondaryCode)
	 */
	@Transactional
	@Override
	public void delete(SecondaryCode code) {
		efficencyCodeDao.delete(code);

	}

	/* (non-Javadoc)
	 * @see com.st.efficiency.service.EfficencyCodeService#getSecondaryCodes()
	 */
	@Transactional
	@Override
	public List<SecondaryCode> getSecondaryCodes() {
		return efficencyCodeDao.getSecondaryCodes();
	}

	/* (non-Javadoc)
	 * @see com.st.efficiency.service.EfficiencyCodeService#getSummaryData(java.util.Date, java.util.Date, int, int)
	 */
	@Transactional
	@Override
	public List<Efficiency> getSummaryData(Date sdate, Date edate, int pcode,
			int scode) {
		return efficencyCodeDao.getSummaryData(sdate,edate,pcode,scode);
	}

}

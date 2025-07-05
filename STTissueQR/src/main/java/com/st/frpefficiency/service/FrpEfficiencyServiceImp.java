/**
 * 
 */
package com.st.frpefficiency.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.st.frpefficiency.dao.FrpEfficiencyDao;
import com.st.frpefficiency.model.FrpEfficiency;

/**
 * @author sbora
 *
 */
@Service
public class FrpEfficiencyServiceImp implements FrpEfficiencyService {

	@Autowired
	private FrpEfficiencyDao frpEfficiencyDao;

	@Transactional
	@Override
	public int add(FrpEfficiency efficency) {
		return frpEfficiencyDao.add(efficency);
	}

	@Transactional
	@Override
	public List<FrpEfficiency> getEfficiencies(FrpEfficiency efficiency) {
		return frpEfficiencyDao.getEfficiencies(efficiency);
	}

	@Transactional
	@Override
	public FrpEfficiency getEfficiency(int id) {
		return frpEfficiencyDao.getEfficiency(id);
	}

	@Transactional
	@Override
	public void update(FrpEfficiency efficency) {
		frpEfficiencyDao.update(efficency);
	}

	@Transactional
	@Override
	public void delete(int id) {
		frpEfficiencyDao.delete(id);
	}

}

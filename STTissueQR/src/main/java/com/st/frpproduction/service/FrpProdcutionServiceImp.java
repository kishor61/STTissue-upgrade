/**
 * 
 */
package com.st.frpproduction.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.st.frpproduction.dao.FrpProdcutionDao;
import com.st.frpproduction.model.FrpProdcution;

/**
 * @author sbora
 *
 */
@Service
public class FrpProdcutionServiceImp implements FrpProdcutionService {
	@Autowired
	private FrpProdcutionDao frpProdcutionDao;

	@Transactional
	@Override
	public int save(FrpProdcution frpProdcution) {
		return frpProdcutionDao.save(frpProdcution);
	}

	@Transactional
	@Override
	public void update(FrpProdcution frpProdcution) {
		frpProdcutionDao.update(frpProdcution);
	}

	@Transactional
	@Override
	public List<FrpProdcution> getFrpProdcutions(Date sdate, Date edate,
			String prodType,String grade) {
		return frpProdcutionDao.getFrpProdcutions(sdate, edate, prodType,grade);
	}

	@Transactional
	@Override
	public FrpProdcution getFrpProdcution(int id) {
		return frpProdcutionDao.getFrpProdcution(id);
	}

	@Transactional
	@Override
	public void delete(int id) {
		frpProdcutionDao.delete(id);
	}

	@Transactional
	@Override
	public FrpProdcution getFrpProdcutionLast(Date date) {
		return frpProdcutionDao.getFrpProdcutionLast(date);
	}

	/* (non-Javadoc)
	 * @see com.st.frpproduction.service.FrpProdcutionService#getMTDFrpProdcution(java.util.Date)
	 */
	@Transactional
	@Override
	public FrpProdcution getMTDFrpProdcution(Date date,String prodType) {
		return frpProdcutionDao.getMTDFrpProdcution(date,prodType);
	}


}

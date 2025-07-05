/**
 *Mar 3, 2016
 *FrpProdcutionOperatorDataEntryServiceImp.java
 * TODO
 *com.st.frpproduction.service
 *FrpProdcutionOperatorDataEntryServiceImp.java
 *Sunil Singh Bora
 */
package com.st.frpproduction.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.st.frpproduction.model.FrpProdcutionOperatorDataEntry;
import com.st.frpprojection.dao.FrpProdcutionOperatorDataEntryDao;

/**
 * @author roshan
 *
 */
@Service
public class FrpProdcutionOperatorDataEntryServiceImp implements FrpProdcutionOperatorDataEntryService {

	@Autowired
	private FrpProdcutionOperatorDataEntryDao frpprodcutionoperatordataentrydao ;	
	
	/* (non-Javadoc)
	 * @see com.st.frpproduction.service.FrpProdcutionOperatorDataEntryService#save(com.st.frpproduction.model.FrpProdcutionOperatorDataEntry)
	 */
	@Transactional
	@Override
	public int save(FrpProdcutionOperatorDataEntry colum) {
		// TODO Auto-generated method stub
		return frpprodcutionoperatordataentrydao.save(colum);
	}

	/* (non-Javadoc)
	 * @see com.st.frpproduction.service.FrpProdcutionOperatorDataEntryService#checkexistentry(java.util.Date, java.lang.String)
	 */
	@Transactional
	@Override
	public List<FrpProdcutionOperatorDataEntry> checkexistentry(Date date,String shift,String crew) {
		// TODO Auto-generated method stub
		return frpprodcutionoperatordataentrydao.checkexistentry(date,shift,crew);
	}

	/* (non-Javadoc)
	 * @see com.st.frpproduction.service.FrpProdcutionOperatorDataEntryService#checkexistentry(int)
	 */
	@Transactional
	@Override
	public List<FrpProdcutionOperatorDataEntry> checkexistentry(int id) {
		// TODO Auto-generated method stub
		return frpprodcutionoperatordataentrydao.checkexistentry(id);
	}

	/* (non-Javadoc)
	 * @see com.st.frpproduction.service.FrpProdcutionOperatorDataEntryService#update(com.st.frpproduction.model.FrpProdcutionOperatorDataEntry)
	 */
	@Transactional
	@Override
	public void update(FrpProdcutionOperatorDataEntry colum) {
		// TODO Auto-generated method stub
		frpprodcutionoperatordataentrydao.update(colum);
	}

	/* (non-Javadoc)
	 * @see com.st.frpproduction.service.FrpProdcutionOperatorDataEntryService#getFrpProducationDataEntryReport(java.util.Date, java.util.Date)
	 */
	@Transactional
	@Override
	public List<FrpProdcutionOperatorDataEntry> getFrpProducationDataEntryReport(
			Date sDate, Date eDate) {
		// TODO Auto-generated method stub
		return frpprodcutionoperatordataentrydao.getFrpProducationDataEntryReport(sDate,eDate);
	}

	/* (non-Javadoc)
	 * @see com.st.frpproduction.service.FrpProdcutionOperatorDataEntryService#getFrpProducationDataEntryDetailedReport(java.util.Date, java.util.Date)
	 */
	@Transactional
	@Override
	public List<FrpProdcutionOperatorDataEntry> getFrpProducationDataEntryDetailedReport(
			Date sDate, Date eDate) {
		// TODO Auto-generated method stub
		return frpprodcutionoperatordataentrydao.getFrpProducationDataEntryDetailedReport(sDate,eDate);
	}

	/* (non-Javadoc)
	 * @see com.st.frpproduction.service.FrpProdcutionOperatorDataEntryService#getFrpProducationBackDatedEntryShow(java.util.Date, java.lang.String)
	 */
	@Transactional
	@Override
	public List<FrpProdcutionOperatorDataEntry> getFrpProducationBackDatedEntryShow(Date sDate,String shift,String crew) {
		// TODO Auto-generated method stub
		return frpprodcutionoperatordataentrydao.getFrpProducationBackDatedEntryShow(sDate,shift,crew);
	}

	/* (non-Javadoc)
	 * @see com.st.frpproduction.service.FrpProdcutionOperatorDataEntryService#getFrpProducationBackDatedEntryShow1(java.util.Date, java.lang.String)
	 */
	@Transactional
	@Override
	public List<FrpProdcutionOperatorDataEntry> getFrpProducationBackDatedEntryShow1(
			Date sDate, String shift) {
		// TODO Auto-generated method stub
		return frpprodcutionoperatordataentrydao.getFrpProducationBackDatedEntryShow1(sDate,shift);
	}

	/* (non-Javadoc)
	 * @see com.st.frpproduction.service.FrpProdcutionOperatorDataEntryService#checkexistentry1(java.util.Date, java.lang.String)
	 */
	@Transactional
	@Override
	public List<FrpProdcutionOperatorDataEntry> checkexistentry1(Date date,
			String shift) {
		// TODO Auto-generated method stub
		return frpprodcutionoperatordataentrydao.checkexistentry1(date,shift);
	}

	/* (non-Javadoc)
	 * @see com.st.frpproduction.service.FrpProdcutionOperatorDataEntryService#getcol1avg(java.util.Date, java.util.Date)
	 */
	@Transactional
	@Override
	public List<FrpProdcutionOperatorDataEntry> getcol1avg(Date sDate,
			Date eDate) {
		// TODO Auto-generated method stub
		return frpprodcutionoperatordataentrydao.getcol1avg(sDate,eDate);
	}

	/* (non-Javadoc)
	 * @see com.st.frpproduction.service.FrpProdcutionOperatorDataEntryService#getcol1avg1(java.util.Date, java.util.Date)
	 */
	@Transactional
	@Override
	public List<FrpProdcutionOperatorDataEntry> getcol1avg1(Date sDate,
			Date eDate) {
		// TODO Auto-generated method stub
		return frpprodcutionoperatordataentrydao.getcol1avg1(sDate,eDate);
	}
	
	/* (non-Javadoc)
	 * @see com.st.frpproduction.service.FrpProdcutionOperatorDataEntryService#getcol1avg1(java.util.Date, java.util.Date)
	 */
	@Transactional
	@Override
	public List<FrpProdcutionOperatorDataEntry> getcol1avg2(Date sDate,
			Date eDate) {
		// TODO Auto-generated method stub
		return frpprodcutionoperatordataentrydao.getcol1avg2(sDate,eDate);
	}
	/* (non-Javadoc)
	 * @see com.st.frpproduction.service.FrpProdcutionOperatorDataEntryService#getcol1avg1(java.util.Date, java.util.Date)
	 */
	@Transactional
	@Override
	public List<FrpProdcutionOperatorDataEntry> getcol1avg3(Date sDate,
			Date eDate) {
		// TODO Auto-generated method stub
		return frpprodcutionoperatordataentrydao.getcol1avg3(sDate,eDate);
	}

	/* (non-Javadoc)
	 * @see com.st.frpproduction.service.FrpProdcutionOperatorDataEntryService#getFrpProducationDataEntryDetailedReport1(java.util.Date, java.util.Date)
	 */
	@Transactional
	@Override
	public List<FrpProdcutionOperatorDataEntry> getFrpProducationDataEntryDetailedReport1(
			Date sDate, Date eDate) {
		// TODO Auto-generated method stub
		return frpprodcutionoperatordataentrydao.getFrpProducationDataEntryDetailedReport1(sDate,eDate);
	}

	/* (non-Javadoc)
	 * @see com.st.frpproduction.service.FrpProdcutionOperatorDataEntryService#deleteRecord(int)
	 */
	@Transactional
	@Override
	public void deleteRecord(int id) {
		// TODO Auto-generated method stub
		frpprodcutionoperatordataentrydao.deleteRecord(id);
	}
}

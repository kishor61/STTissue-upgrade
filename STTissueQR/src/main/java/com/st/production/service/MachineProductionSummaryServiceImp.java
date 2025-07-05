/**
 *May 23, 2016
 *MachineProductionSummaryServiceImp.java
 * TODO
 *com.st.production.service
 *MachineProductionSummaryServiceImp.java
 *Sunil Singh Bora
 */
package com.st.production.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.st.common.exception.ProductionException;
import com.st.production.dao.MachineProductionDao;
import com.st.production.model.MachineAndWrapper;
import com.st.production.model.MachineProduction;

/**
 * @author roshan
 *
 */
@Service
public class MachineProductionSummaryServiceImp implements MachineProductionSummaryService {

	/* (non-Javadoc)
	 * @see com.st.production.service.MachineProductionSummaryService#getMachineAndWrapperSummaryReport(java.util.Date, java.util.Date)
	 */
	@Autowired
	private com.st.production.dao.MachineProductionSummaryDao machineproductionsummarydao ;
	
	@Override
	public List<MachineAndWrapper> getMachineAndWrapperSummaryReport(Date sdate, Date edate) throws ProductionException {
		// TODO Auto-generated method stub
		return machineproductionsummarydao.getMachineAndWrapperSummaryReport(sdate,edate);
	}

	/**
	 * @param sDate
	 * @param eDate
	 * @param shift
	 * @return
	 */
	@Override
	@Transactional
	public List<MachineProduction> getMachineBreakFreeProduction(Date sDate,
			Date eDate, String shift) {
		// TODO Auto-generated method stub
		return machineproductionsummarydao.getMachineBreakFreeProduction(sDate,eDate,shift);
	}

}

/**
 *May 23, 2016
 *MachineProductionSummaryServiceImp.java
 * TODO
 *com.st.production.service
 *MachineProductionSummaryServiceImp.java
 *Sunil Singh Bora
 */
package com.st.productionpm5.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.st.common.exception.ProductionException;
import com.st.productionpm5.dao.MachineProductionSummaryDaoPM5;
import com.st.productionpm5.model.MachineAndWrapperPM5;
import com.st.productionpm5.model.MachineProductionPM5;

/**
 * @author roshan
 *
 */
@Service
public class MachineProductionSummaryServiceImpPM5 implements MachineProductionSummaryServicePM5 {

	/* (non-Javadoc)
	 * @see com.st.production.service.MachineProductionSummaryService#getMachineAndWrapperSummaryReport(java.util.Date, java.util.Date)
	 */
	@Autowired
	private MachineProductionSummaryDaoPM5  machineproductionsummarydao;
	
	@Override
	public List<MachineAndWrapperPM5> getMachineAndWrapperSummaryReport(Date sdate, Date edate) throws ProductionException {
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
	public List<MachineProductionPM5> getMachineBreakFreeProduction(Date sDate,
			Date eDate, String shift) {
		// TODO Auto-generated method stub
		return machineproductionsummarydao.getMachineBreakFreeProduction(sDate,eDate,shift);
	}

}

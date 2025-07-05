/**
 *Jan 12, 2018
 *DespatchServiceImp.java
 * TODO
 *com.st.despatch.service
 *DespatchServiceImp.java
 *Roshan Lal Tailor
 */
package com.st.despatch.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.st.despatch.dao.DespatchDao;
import com.st.despatch.model.Despatch;

/**
 * @author roshan
 *
 */
@Service
public class DespatchServiceImp implements DespatchService{

	@Autowired
	private DespatchDao despatchDao; 
	/* (non-Javadoc)
	 * @see com.st.despatch.service.DespatchService#getDespatchData(java.util.Date)
	 */
	@Override
	@Transactional
	public List<Despatch> getDespatchData(Date sDate,String type) {
		// TODO Auto-generated method stub
		return despatchDao.getDespatchData(sDate,type);
	}
	/* (non-Javadoc)
	 * @see com.st.despatch.service.DespatchService#getDespatchData_Temp()
	 */
	@Override
	@Transactional
	public List<Despatch> getDespatchData_Temp() {
		// TODO Auto-generated method stub
		return despatchDao.getDespatchData_Temp();
	}
	/* (non-Javadoc)
	 * @see com.st.despatch.service.DespatchService#getCheckDateTempTable(int, java.util.Date)
	 */
	@Override
	@Transactional
	public int getCheckDateTempTable(String tblName,int releasenumber, Date pickupdate) {
		// TODO Auto-generated method stub
		return despatchDao.getCheckDateTempTable(tblName,releasenumber,pickupdate);
	}
	/* (non-Javadoc)
	 * @see com.st.despatch.service.DespatchService#getCheckPickUpPointTempTable(int, java.util.Date)
	 */
	@Override
	@Transactional
	public int getCheckPickUpPointTempTable(String tblName,int releasenumber, String pickuppoint) {
		// TODO Auto-generated method stub
		return despatchDao.getCheckPickUpPointTempTable(tblName,releasenumber,pickuppoint);
	}
	/* (non-Javadoc)
	 * @see com.st.despatch.service.DespatchService#getCheckPickUpCityTempTable(int, java.lang.String)
	 */
	@Override
	@Transactional
	public int getCheckPickUpCityTempTable(String tblName,int releasenumber, String pickupcity) {
		// TODO Auto-generated method stub
		return despatchDao.getCheckPickUpCityTempTable(tblName,releasenumber,pickupcity);
	}
	/* (non-Javadoc)
	 * @see com.st.despatch.service.DespatchService#getCheckPickUpStateTempTable(int, java.lang.String)
	 */
	@Override
	@Transactional
	public int getCheckPickUpStateTempTable(String tblName,int releasenumber,String pickupstate) {
		// TODO Auto-generated method stub
		return despatchDao.getCheckPickUpStateTempTable(tblName,releasenumber,pickupstate);
	}
	/* (non-Javadoc)
	 * @see com.st.despatch.service.DespatchService#getCheckPickUpCellNumberTempTable(int, java.lang.String)
	 */
	@Override
	@Transactional
	public int getCheckPickUpCellNumberTempTable(String tblName,int releasenumber,String cellnumber) {
		// TODO Auto-generated method stub
		return despatchDao.getCheckPickUpCellNumberTempTable(tblName,releasenumber,cellnumber);
	}
	/* (non-Javadoc)
	 * @see com.st.despatch.service.DespatchService#getCheckGradeTempTable(int, java.lang.String)
	 */
	@Override
	@Transactional
	public int getCheckGradeTempTable(String tblName,int releasenumber, String grade) {
		// TODO Auto-generated method stub
		return despatchDao.getCheckGradeTempTable(tblName,releasenumber,grade);
	}
	/* (non-Javadoc)
	 * @see com.st.despatch.service.DespatchService#getCheckCareerirIdTempTable(int, java.lang.String)
	 */
	@Override
	@Transactional
	public int getCheckCareerirIdTempTable(String tblName,int releasenumber, String careeririd) {
		// TODO Auto-generated method stub
		return despatchDao.getCheckCareerirIdTempTable(tblName,releasenumber,careeririd);
	}
	/* (non-Javadoc)
	 * @see com.st.despatch.service.DespatchService#getCheckUnloadCommantsTempTable(int, java.lang.String)
	 */
	@Override
	@Transactional
	public int getCheckUnloadCommantsTempTable(String tblName,int releasenumber,String unloadcomments) {
		// TODO Auto-generated method stub
		return despatchDao.getCheckUnloadCommantsTempTable(tblName,releasenumber,unloadcomments);
	}
	/* (non-Javadoc)
	 * @see com.st.despatch.service.DespatchService#getCheckReleaseTempTable(int, int)
	 */
	@Override
	@Transactional
	public int getCheckReleaseTempTable(String tblName,int releasenumber, int releasenumber2) {
		// TODO Auto-generated method stub
		return despatchDao.getCheckReleaseTempTable(tblName,releasenumber,releasenumber2);
	}
	@Override
	public int getCarrirRateTempTable(String tblName, int releasenumber, int carrierRate) {
		return despatchDao.getCarrirRateTempTable(tblName,releasenumber,carrierRate);
	}

}

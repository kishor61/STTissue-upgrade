/**
 * 
 */
package com.st.chemicalinventory.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.st.chemicalinventory.dao.ChemicalInventoryDao;
import com.st.chemicalinventory.model.Chemical;
import com.st.chemicalinventory.model.ChemicalCode;
import com.st.chemicalinventory.model.ChemicalData;
import com.st.chemicalinventory.model.ChemicalPrimaryCode;
import com.st.chemicalinventory.model.ChemicalReportData;
import com.st.chemicalinventory.model.ChemicalSecondaryCode;
import com.st.chemicalinventory.model.ChemicalReportData.ReportData;

/**
 * @author sbora
 *
 */
@Service
public class ChemicalInventoryServiceImp implements ChemicalInventoryService {

	@Autowired
	private ChemicalInventoryDao chemicalInventoryDao;
	/* (non-Javadoc)
	 * @see com.st.chemicalinventory.service.ChemicalInventoryService#saveOrUpdate(com.st.chemicalinventory.model.ChemicalPrimaryCode)
	 */
	@Transactional
	@Override
	public void saveOrUpdate(ChemicalPrimaryCode chemicalPrimaryCode) {
		chemicalInventoryDao.saveOrUpdate(chemicalPrimaryCode);
	}
	/* (non-Javadoc)
	 * @see com.st.chemicalinventory.service.ChemicalInventoryService#getChemicalPrimaryCodes()
	 */
	@Transactional
	@Override
	public List<ChemicalPrimaryCode> getChemicalPrimaryCodes() {
		return chemicalInventoryDao.getChemicalPrimaryCodes();
	}
	/* (non-Javadoc)
	 * @see com.st.chemicalinventory.service.ChemicalInventoryService#getChemicalPrimaryCode(java.lang.Object)
	 */
	@Transactional
	@Override
	public ChemicalPrimaryCode getChemicalPrimaryCode(int id) {
		
		return chemicalInventoryDao.getChemicalPrimaryCode(id);
	}
	/* (non-Javadoc)
	 * @see com.st.chemicalinventory.service.ChemicalInventoryService#deletePrimaryCode(int)
	 */
	@Transactional
	@Override
	public void deletePrimaryCode(int id) {
		chemicalInventoryDao.deletePrimaryCode(id);
	}
	/* (non-Javadoc)
	 * @see com.st.chemicalinventory.service.ChemicalInventoryService#saveOrUpdate(com.st.chemicalinventory.model.ChemicalSecondaryCode)
	 */
	@Transactional
	@Override
	public void saveOrUpdate(ChemicalSecondaryCode chemicalSecondaryCode) {
		chemicalInventoryDao.saveOrUpdate(chemicalSecondaryCode);
	}
	/* (non-Javadoc)
	 * @see com.st.chemicalinventory.service.ChemicalInventoryService#deleteSecondary(int)
	 */
	@Transactional
	@Override
	public void deleteSecondary(int id) {
		chemicalInventoryDao.deleteSecondary(id);
		
	}
	/* (non-Javadoc)
	 * @see com.st.chemicalinventory.service.ChemicalInventoryService#getChemicalSecondaryCode(int)
	 */
	@Transactional
	@Override
	public ChemicalSecondaryCode getChemicalSecondaryCode(int id) {
		
		return chemicalInventoryDao.getChemicalSecondaryCode(id);
	}
	/* (non-Javadoc)
	 * @see com.st.chemicalinventory.service.ChemicalInventoryService#getChemicalSecondaryCodes()
	 */
	@Transactional
	@Override
	public List<ChemicalSecondaryCode> getChemicalSecondaryCodes() {
		
		return chemicalInventoryDao.getChemicalSecondaryCodes();
	}
	/* (non-Javadoc)
	 * @see com.st.chemicalinventory.service.ChemicalInventoryService#saveOrUpdate(com.st.chemicalinventory.model.ChemicalCode)
	 */
	@Transactional
	@Override
	public void saveOrUpdate(ChemicalCode chemicalCode) {
		
		chemicalInventoryDao.saveOrUpdate(chemicalCode);
	}
	/* (non-Javadoc)
	 * @see com.st.chemicalinventory.service.ChemicalInventoryService#getChemicalCodes()
	 */
	@Transactional
	@Override
	public List<ChemicalCode> getChemicalCodes() {
		return chemicalInventoryDao.getChemicalCodes();
	}
	/* (non-Javadoc)
	 * @see com.st.chemicalinventory.service.ChemicalInventoryService#deleteChemical(int)
	 */
	@Transactional
	@Override
	public void deleteChemical(int id) {
		chemicalInventoryDao.deleteChemical(id);
	}
	/* (non-Javadoc)
	 * @see com.st.chemicalinventory.service.ChemicalInventoryService#getChemicalCode(int)
	 */
	@Transactional
	@Override
	public ChemicalCode getChemicalCode(int id) {
		return chemicalInventoryDao.getChemicalCode(id);
	}
	/* (non-Javadoc)
	 * @see com.st.chemicalinventory.service.ChemicalInventoryService#saveOrUpdate(com.st.chemicalinventory.model.Chemical)
	 */
	/* (non-Javadoc)
	 * @see com.st.chemicalinventory.service.ChemicalInventoryService#deleteChemicalCode(int)
	 */
	@Transactional
	@Override
	public void deleteChemicalCode(int id) {
		chemicalInventoryDao.deleteChemicalCode(id);
	}
	
	@Transactional
	@Override
	public void saveOrUpdate(Chemical chemical) {
		chemicalInventoryDao.saveOrUpdate(chemical);
	}
	/* (non-Javadoc)
	 * @see com.st.chemicalinventory.service.ChemicalInventoryService#getChemical(int)
	 */
	@Transactional
	@Override
	public Chemical getChemical(int id) {
		return chemicalInventoryDao.getChemical(id);
	}
	/* (non-Javadoc)
	 * @see com.st.chemicalinventory.service.ChemicalInventoryService#isChemicalExist(int, int)
	 */
	@Transactional
	@Override
	public Chemical isChemicalExist(int sid, int cid) {
		return chemicalInventoryDao.isChemicalExist(sid,cid);
	}
	/* (non-Javadoc)
	 * @see com.st.chemicalinventory.service.ChemicalInventoryService#getChemicals()
	 */
	@Transactional
	@Override
	public List<Chemical> getChemicals() {
		return chemicalInventoryDao.getChemicals();
	}
	/* (non-Javadoc)
	 * @see com.st.chemicalinventory.service.ChemicalInventoryService#saveOrUpdate(com.st.chemicalinventory.model.ChemicalData)
	 */
	@Transactional
	@Override
	public int saveOrUpdate(ChemicalData chemicalData) {
		return chemicalInventoryDao.saveOrUpdate(chemicalData);
	}
	/* (non-Javadoc)
	 * @see com.st.chemicalinventory.service.ChemicalInventoryService#getChemicalReportData()
	 */
	@Transactional
	@Override
	public List<ChemicalReportData> getChemicalReportData(Date from, Date to, int pid, int sid) {
		return chemicalInventoryDao.getChemicalReportData(from,to,pid,sid);
	}
	/* (non-Javadoc)
	 * @see com.st.chemicalinventory.service.ChemicalInventoryService#getChemicalData(java.util.Date, java.lang.String)
	 */
	@Transactional
	@Override
	public List<Chemical> getChemicalData(Date date, String entryId) {
		return chemicalInventoryDao.getChemicalData(date,entryId);
	}
	/* (non-Javadoc)
	 * @see com.st.chemicalinventory.service.ChemicalInventoryService#getChemicalReportDataDetail(java.util.Date, java.util.Date)
	 */
	@Transactional
	@Override
	public ChemicalReportData getChemicalReportDataDetail(Date sdate, Date edate) {
		
		List<ChemicalData> chemicals=chemicalInventoryDao.getChemicalReportDataDetail(sdate, edate);
		
		List<ChemicalPrimaryCode> primaryCodes=new ArrayList<>();
		List<ChemicalSecondaryCode> secondaryCodes=new ArrayList<>();
		
		//Code for header 
		
		for (ChemicalData chemicalData : chemicals) {
			ChemicalPrimaryCode primaryCode=new ChemicalPrimaryCode(chemicalData.getPid());
			if(!primaryCodes.contains(primaryCode)){
				primaryCode.setName(chemicalData.getPrimaryName());
				primaryCodes.add(primaryCode);
				primaryCode.setCount(primaryCode.getCount()+1);
			}else{
				primaryCode=primaryCodes.get(primaryCodes.indexOf(primaryCode));
				primaryCode.setCount(primaryCode.getCount()+1);
			}
			
			ChemicalSecondaryCode secondaryCode=new ChemicalSecondaryCode(chemicalData.getSid());
			if(!secondaryCodes.contains(secondaryCode)){
				secondaryCode.setName(chemicalData.getSecondaryName());
				secondaryCode.setPid(primaryCode.getId());
				secondaryCodes.add(secondaryCode);
				secondaryCode.setCount(secondaryCode.getCount()+1);
			}else{
				secondaryCode=secondaryCodes.get(secondaryCodes.indexOf(secondaryCode));
				secondaryCode.setCount(secondaryCode.getCount()+1);
			}
			
		}
		
		
		
		
		
		ChemicalReportData chemicalReportData=new ChemicalReportData();
		
		
		
		
		
		
		
		List<ChemicalReportData> datas=chemicalInventoryDao.getChemicalReportData(sdate, edate, 0, 0);
		
		List<ReportData> reportDatas=new ArrayList<ChemicalReportData.ReportData>();
		
		SimpleDateFormat dateFormat=new SimpleDateFormat("MM-dd-yyyy");
		
		for (ChemicalReportData data : datas) {
			
			ReportData reportData=new ChemicalReportData().new ReportData();
			reportData.setDate(dateFormat.format(data.getDate()));
			reportData.setEntryId(data.getEntryId());
			List<ChemicalData> dataValues=data.getDatas();
			for (ChemicalData chemicalData : chemicals) {
				ChemicalData chemicalDataValue=getChemicalValue(dataValues,chemicalData);
				if(chemicalDataValue==null){
					reportData.getValues().add(0d);
				}else{
					reportData.getValues().add(chemicalDataValue.getConsumption());
					chemicalData.setTotalConsumption(chemicalData.getTotalConsumption()+chemicalDataValue.getConsumption());
				}
			}
			
			reportDatas.add(reportData);
		}
		
		
		
		chemicalReportData.setPrimaryCodes(primaryCodes); //Primary Code Header
		chemicalReportData.setSecondaryCodes(secondaryCodes); // Secondary Code Header
		chemicalReportData.setDatas(chemicals);// Header and Total
		chemicalReportData.setReportDatas(reportDatas); // Data
		
		return chemicalReportData;
	}
	/**
	 * @param dataValues
	 * @param chemicalData
	 * @return
	 */
	private ChemicalData getChemicalValue(List<ChemicalData> dataValues,
			ChemicalData chemicalData) {
		
		ChemicalData data=null;
		for (ChemicalData dataChemicalData : dataValues) {
			if(chemicalData.getCcid()==dataChemicalData.getCcid()
				&& chemicalData.getSid()==dataChemicalData.getSid()
				&& chemicalData.getPid()==dataChemicalData.getPid()){
				data=dataChemicalData;
				break;
			}
		}
		
		return data;
	}
	/* (non-Javadoc)
	 * @see com.st.chemicalinventory.service.ChemicalInventoryService#deleteChemicalData(java.util.Date, java.lang.String)
	 */
	@Transactional
	@Override
	public void deleteChemicalData(Date date, String entryId) {
		chemicalInventoryDao.deleteChemicalData(date,entryId);
	}

	

}

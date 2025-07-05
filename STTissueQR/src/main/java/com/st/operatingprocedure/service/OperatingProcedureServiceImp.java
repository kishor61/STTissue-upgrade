/**
 *Jan 10, 2015
 *OperatingProcedureServiceImp.java
 * TODO
 *com.st.operatingprocedure.service
 *OperatingProcedureServiceImp.java
 *Sunil Singh Bora
 */
package com.st.operatingprocedure.service;

import java.lang.annotation.Target;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.st.operatingprocedure.dao.OperatingProcedureDao;
import com.st.operatingprocedure.model.OperatingProcedure;
import com.st.operatingprocedure.model.Type;

/**
 * @author roshan
 *
 */
@Service
public class OperatingProcedureServiceImp implements OperatingProcedureService {

	@Autowired
	private OperatingProcedureDao operatingProcedureDao;
	
	/* (non-Javadoc)
	 * @see com.st.operatingprocedure.service.OperatingProcedureService#save(com.st.operatingprocedure.model.OperatingProcedure)
	 */
	@Transactional
	@Override
	public void save(OperatingProcedure operatingProcedure) {
		operatingProcedureDao.save(operatingProcedure);
	}

	/* (non-Javadoc)
	 * @see com.st.operatingprocedure.service.OperatingProcedureService#getTypes()
	 */
	@Transactional
	@Override
	public List<String> getTypes() {
		return operatingProcedureDao.getTypes();
	}

	/* (non-Javadoc)
	 * @see com.st.operatingprocedure.service.OperatingProcedureService#getOperatingProcedure()
	 */
	@Transactional
	@Override
	public List<OperatingProcedure> getOperatingProcedure() {
		return operatingProcedureDao.getOperatingProcedure();
	}

	/* (non-Javadoc)
	 * @see com.st.operatingprocedure.service.OperatingProcedureService#delete(int)
	 */
	@Transactional
	@Override
	public void delete(int id) {
		operatingProcedureDao.delete(id);
	}

	/* (non-Javadoc)
	 * @see com.st.operatingprocedure.service.OperatingProcedureService#updateCategory(java.lang.String, java.lang.String)
	 */
	@Transactional
	@Override
	public void updateCategory(String newCat, String oldCat) {
		operatingProcedureDao.updateCategory(newCat,oldCat);
	}

	/* (non-Javadoc)
	 * @see com.st.operatingprocedure.service.OperatingProcedureService#getOperatingProcedure(java.lang.String, java.lang.String)
	 */
	@Transactional
	@Override
	public List<OperatingProcedure> getOperatingProcedure(String file, String area,String category,String subCategory) {
		return operatingProcedureDao.getOperatingProcedure(file,area,category,subCategory);
	}

	/* (non-Javadoc)
	 * @see com.st.operatingprocedure.service.OperatingProcedureService#getSubTypes()
	 */
	@Transactional
	@Override
	public List<String> getSubTypes() {
		return operatingProcedureDao.getSubTypes();
	}

	/* (non-Javadoc)
	 * @see com.st.operatingprocedure.service.OperatingProcedureService#getTypesAndSubTypes()
	 */
	@Transactional
	@Override
	public List<Type> getTypesAndSubTypes() {
		// TODO Auto-generated method stub
		return operatingProcedureDao.getTypesAndSubTypes();
	}

	/* (non-Javadoc)
	 * @see com.st.operatingprocedure.service.OperatingProcedureService#updateSubCategory(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Transactional
	@Override
	public void updateSubCategory(String newcat, String oldcat, String type) {
		operatingProcedureDao.updateSubCategory(newcat, oldcat,type);
	}

	/* (non-Javadoc)
	 * @see com.st.operatingprocedure.service.OperatingProcedureService#getOperatingProcedure(int)
	 */
	@Transactional
	@Override
	public OperatingProcedure getOperatingProcedure(int id) {
		
		return operatingProcedureDao.getOperatingProcedure(id);
	}

	/* (non-Javadoc)
	 * @see com.st.operatingprocedure.service.OperatingProcedureService#update(com.st.operatingprocedure.model.OperatingProcedure)
	 */
	@Transactional
	@Override
	public void update(OperatingProcedure procedure) {
		operatingProcedureDao.update(procedure);
	}

	/* (non-Javadoc)
	 * @see com.st.operatingprocedure.service.OperatingProcedureService#saveMainCatgoryNameData(com.st.operatingprocedure.model.OperatingProcedure)
	 */
	@Transactional
	@Override
	public int saveMainCatgoryNameData(OperatingProcedure vendorSeller) {
		// TODO Auto-generated method stub
		return operatingProcedureDao.saveMainCatgoryNameData(vendorSeller);
	}

	/* (non-Javadoc)
	 * @see com.st.operatingprocedure.service.OperatingProcedureService#getMainCategory()
	 */
	@Transactional
	@Override
	public List<OperatingProcedure> getMainCategory() {
		// TODO Auto-generated method stub
		return operatingProcedureDao.getMainCategory();
	}

	/* (non-Javadoc)
	 * @see com.st.operatingprocedure.service.OperatingProcedureService#deleteMainCatgoryNameData(com.st.operatingprocedure.model.OperatingProcedure)
	 */
	@Transactional
	@Override
	public void deleteMainCatgoryNameData(OperatingProcedure vendorSeller) {
		// TODO Auto-generated method stub
		operatingProcedureDao.deleteMainCatgoryNameData(vendorSeller);
	}

	/* (non-Javadoc)
	 * @see com.st.operatingprocedure.service.OperatingProcedureService#updateMainCatgoryNameData(com.st.operatingprocedure.model.OperatingProcedure)
	 */
	@Transactional
	@Override
	public void updateMainCatgoryNameData(OperatingProcedure vendorSeller) {
		// TODO Auto-generated method stub
		operatingProcedureDao.updateMainCatgoryNameData(vendorSeller);
	}

	/* (non-Javadoc)
	 * @see com.st.operatingprocedure.service.OperatingProcedureService#saveSubCatgoryNameData(com.st.operatingprocedure.model.OperatingProcedure)
	 */
	@Transactional
	@Override
	public int saveSubCatgoryNameData(OperatingProcedure vendorSeller) {
		// TODO Auto-generated method stub
		return operatingProcedureDao.saveSubCatgoryNameData(vendorSeller);
	}

	/* (non-Javadoc)
	 * @see com.st.operatingprocedure.service.OperatingProcedureService#getSubCategory()
	 */
	@Transactional
	@Override
	public List<OperatingProcedure> getSubCategory() {
		// TODO Auto-generated method stub
		return operatingProcedureDao.getSubCategory();
	}

	/* (non-Javadoc)
	 * @see com.st.operatingprocedure.service.OperatingProcedureService#deleteSubCatgoryNameData(com.st.operatingprocedure.model.OperatingProcedure)
	 */
	@Transactional
	@Override
	public void deleteSubCatgoryNameData(OperatingProcedure vendorSeller) {
		// TODO Auto-generated method stub
		operatingProcedureDao.deleteSubCatgoryNameData(vendorSeller);
	}

	/* (non-Javadoc)
	 * @see com.st.operatingprocedure.service.OperatingProcedureService#saveAreaName(com.st.operatingprocedure.model.OperatingProcedure)
	 */
	@Override
	@Transactional
	public int saveAreaName(OperatingProcedure vendorSeller) {
		// TODO Auto-generated method stub
		return operatingProcedureDao.saveAreaName(vendorSeller);
	}

	/* (non-Javadoc)
	 * @see com.st.operatingprocedure.service.OperatingProcedureService#getArea()
	 */
	@Override
	@Transactional
	public List<OperatingProcedure> getArea() {
		// TODO Auto-generated method stub
		return operatingProcedureDao.getArea();
	}

	/* (non-Javadoc)
	 * @see com.st.operatingprocedure.service.OperatingProcedureService#updateAreaName(com.st.operatingprocedure.model.OperatingProcedure)
	 */
	@Override
	@Transactional
	public void updateAreaName(OperatingProcedure vendorSeller) {
		// TODO Auto-generated method stub
		operatingProcedureDao.updateAreaName(vendorSeller);
	}

	/* (non-Javadoc)
	 * @see com.st.operatingprocedure.service.OperatingProcedureService#deletAreaName(com.st.operatingprocedure.model.OperatingProcedure)
	 */
	@Override
	@Transactional
	public void deletAreaName(OperatingProcedure vendorSeller) {
		// TODO Auto-generated method stub
		operatingProcedureDao.deletAreaName(vendorSeller);
	}

	/* (non-Javadoc)
	 * @see com.st.operatingprocedure.service.OperatingProcedureService#getAreas()
	 */
	@Override
	@Transactional
	public List<String> getAreas() {
		// TODO Auto-generated method stub
		return operatingProcedureDao.getAreas();
	}

	/* (non-Javadoc)
	 * @see com.st.operatingprocedure.service.OperatingProcedureService#updateAreaNameEdit(java.lang.String, java.lang.String)
	 */
	@Override
	@Transactional
	public void updateAreaNameEdit(String newcat, String oldcat) {
		// TODO Auto-generated method stub
		operatingProcedureDao.updateAreaNameEdit(newcat,oldcat);
	
	}

	/* (non-Javadoc)
	 * @see com.st.operatingprocedure.service.OperatingProcedureService#getMainCatogoeryByAreaWise(java.lang.String)
	 */
	@Override
	@Transactional
	public List<OperatingProcedure> getMainCatogoeryByAreaWise(String area) {
		// TODO Auto-generated method stub
		return operatingProcedureDao.getMainCatogoeryByAreaWise(area);
	}

	/* (non-Javadoc)
	 * @see com.st.operatingprocedure.service.OperatingProcedureService#getSubCatogoeryByAreaAndMainCatWise(java.lang.String, java.lang.String)
	 */
	@Override
	@Transactional
	public List<OperatingProcedure> getSubCatogoeryByAreaAndMainCatWise(String area, String maincat) {
		// TODO Auto-generated method stub
		return operatingProcedureDao.getSubCatogoeryByAreaAndMainCatWise(area,maincat);
	}


}

/**
 *Jan 10, 2015
 *OperatingProcedureServiceDao.java
 * TODO
 *com.st.operatingprocedure.dao
 *OperatingProcedureServiceDao.java
 *Sunil Singh Bora
 */
package com.st.operatingprocedure.dao;

import java.util.List;

import com.st.operatingprocedure.model.OperatingProcedure;
import com.st.operatingprocedure.model.Type;

/**
 * @author sbora
 *
 */
public interface OperatingProcedureDao {

	/**
	 * @param operatingProcedure
	 */
	void save(OperatingProcedure operatingProcedure);

	/**
	 * @return
	 */
	List<String> getTypes();

	/**
	 * @return
	 */
	List<OperatingProcedure> getOperatingProcedure();

	/**
	 * @param id
	 */
	void delete(int id);

	/**
	 * @param newCat
	 * @param oldCat
	 */
	void updateCategory(String newCat, String oldCat);

	/**
	 * @param file
	 * @param category
	 * @param subCategory2 
	 * @return
	 */
	List<OperatingProcedure> getOperatingProcedure(String file, String category,String subCategory, String subCategory2);

	/**
	 * @return
	 */
	List<String> getSubTypes();

	/**
	 * @return
	 */
	List<Type> getTypesAndSubTypes();

	/**
	 * @param newcat
	 * @param oldcat
	 * @param type
	 */
	void updateSubCategory(String newcat, String oldcat, String type);

	/**
	 * @param id
	 * @return
	 */
	OperatingProcedure getOperatingProcedure(int id);

	/**
	 * @param procedure
	 */
	void update(OperatingProcedure procedure);

	/**
	 * @param vendorSeller
	 * @return
	 */
	int saveMainCatgoryNameData(OperatingProcedure vendorSeller);

	/**
	 * @return
	 */
	List<OperatingProcedure> getMainCategory();

	/**
	 * @param vendorSeller
	 */
	void deleteMainCatgoryNameData(OperatingProcedure vendorSeller);

	/**
	 * @param vendorSeller
	 */
	void updateMainCatgoryNameData(OperatingProcedure vendorSeller);

	/**
	 * @param vendorSeller
	 * @return
	 */
	int saveSubCatgoryNameData(OperatingProcedure vendorSeller);

	/**
	 * @return
	 */
	List<OperatingProcedure> getSubCategory();

	/**
	 * @param vendorSeller
	 */
	void deleteSubCatgoryNameData(OperatingProcedure vendorSeller);

	/**
	 * @param vendorSeller
	 * @return
	 */
	int saveAreaName(OperatingProcedure vendorSeller);

	/**
	 * @return
	 */
	List<OperatingProcedure> getArea();

	/**
	 * @param vendorSeller
	 */
	void updateAreaName(OperatingProcedure vendorSeller);

	/**
	 * @param vendorSeller
	 */
	void deletAreaName(OperatingProcedure vendorSeller);

	/**
	 * @return
	 */
	List<String> getAreas();

	/**
	 * @param newcat
	 * @param oldcat
	 */
	void updateAreaNameEdit(String newcat, String oldcat);

	/**
	 * @param area
	 * @return
	 */
	List<OperatingProcedure> getMainCatogoeryByAreaWise(String area);

	/**
	 * @param area
	 * @param maincat
	 * @return
	 */
	List<OperatingProcedure> getSubCatogoeryByAreaAndMainCatWise(String area,
			String maincat);

}

/**
 *Mar 3, 2016
 *FrpProdcutionOperatorDataEntryService.java
 * TODO
 *com.st.frpproduction.service
 *FrpProdcutionOperatorDataEntryService.java
 *Sunil Singh Bora
 */
package com.st.frpproduction.service;

import java.util.Date;
import java.util.List;

import com.st.frpproduction.model.FrpProdcutionOperatorDataEntry;

/**
 * @author sbora
 *
 */
public interface FrpProdcutionOperatorDataEntryService {

	/**
	 * @param colum
	 * @return
	 */
	int save(FrpProdcutionOperatorDataEntry colum);

	/**
	 * @param date
	 * @param shift
	 * @param crew 
	 * @return
	 */
	List<FrpProdcutionOperatorDataEntry> checkexistentry(Date date, String shift, String crew);

	/**
	 * @param id
	 * @return
	 */
	List<FrpProdcutionOperatorDataEntry> checkexistentry(int id);

	/**
	 * @param colum
	 */
	void update(FrpProdcutionOperatorDataEntry colum);

	/**
	 * @param sDate
	 * @param eDate
	 * @return
	 */
	List<FrpProdcutionOperatorDataEntry> getFrpProducationDataEntryReport(
			Date sDate, Date eDate);

	/**
	 * @param sDate
	 * @param eDate
	 * @return
	 */
	List<FrpProdcutionOperatorDataEntry> getFrpProducationDataEntryDetailedReport(
			Date sDate, Date eDate);

	/**
	 * @param sDate
	 * @param shift
	 * @param crew 
	 * @return
	 */
	List<FrpProdcutionOperatorDataEntry> getFrpProducationBackDatedEntryShow(
			Date sDate, String shift, String crew);

	/**
	 * @param sDate
	 * @param shift
	 * @return
	 */
	List<FrpProdcutionOperatorDataEntry> getFrpProducationBackDatedEntryShow1(
			Date sDate, String shift);

	/**
	 * @param date
	 * @param shift
	 * @return
	 */
	List<FrpProdcutionOperatorDataEntry> checkexistentry1(Date date,
			String shift);

	/**
	 * @param sDate
	 * @param eDate
	 * @return
	 */
	List<FrpProdcutionOperatorDataEntry> getcol1avg(Date sDate, Date eDate);

	/**
	 * @param sDate
	 * @param eDate
	 * @return
	 */
	List<FrpProdcutionOperatorDataEntry> getcol1avg1(Date sDate, Date eDate);

	/**
	 * @param sDate
	 * @param eDate
	 * @return
	 */
	List<FrpProdcutionOperatorDataEntry> getcol1avg2(Date sDate, Date eDate);

	/**
	 * @param sDate
	 * @param eDate
	 * @return
	 */
	List<FrpProdcutionOperatorDataEntry> getcol1avg3(Date sDate, Date eDate);

	/**
	 * @param sDate
	 * @param eDate
	 * @return
	 */
	List<FrpProdcutionOperatorDataEntry> getFrpProducationDataEntryDetailedReport1(
			Date sDate, Date eDate);

	/**
	 * @param id
	 */
	void deleteRecord(int id);

}

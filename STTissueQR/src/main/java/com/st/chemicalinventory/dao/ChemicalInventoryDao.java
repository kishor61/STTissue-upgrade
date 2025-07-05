/**
 * 
 */
package com.st.chemicalinventory.dao;

import java.util.Date;
import java.util.List;

import com.st.chemicalinventory.model.Chemical;
import com.st.chemicalinventory.model.ChemicalCode;
import com.st.chemicalinventory.model.ChemicalData;
import com.st.chemicalinventory.model.ChemicalPrimaryCode;
import com.st.chemicalinventory.model.ChemicalReportData;
import com.st.chemicalinventory.model.ChemicalSecondaryCode;

/**
 * @author sbora
 *
 */
public interface ChemicalInventoryDao {

	/**
	 * @param chemicalPrimaryCode
	 */
	void saveOrUpdate(ChemicalPrimaryCode chemicalPrimaryCode);

	/**
	 * @return
	 */
	List<ChemicalPrimaryCode> getChemicalPrimaryCodes();

	/**
	 * @param id
	 * @return
	 */
	ChemicalPrimaryCode getChemicalPrimaryCode(int id);

	/**
	 * @param id
	 */
	void deletePrimaryCode(int id);

	/**
	 * @param chemicalSecondaryCode
	 */
	void saveOrUpdate(ChemicalSecondaryCode chemicalSecondaryCode);

	/**
	 * @param id
	 */
	void deleteSecondary(int id);

	/**
	 * @param id
	 * @return
	 */
	ChemicalSecondaryCode getChemicalSecondaryCode(int id);

	/**
	 * @return
	 */
	List<ChemicalSecondaryCode> getChemicalSecondaryCodes();

	/**
	 * @param chemicalCode
	 */
	void saveOrUpdate(ChemicalCode chemicalCode);

	/**
	 * @return
	 */
	List<ChemicalCode> getChemicalCodes();

	/**
	 * @param id
	 */
	void deleteChemical(int id);

	/**
	 * @param id
	 * @return
	 */
	ChemicalCode getChemicalCode(int id);

	/**
	 * @param chemical
	 */
	void saveOrUpdate(Chemical chemical);

	/**
	 * @param id
	 * @return
	 */
	Chemical getChemical(int id);

	/**
	 * @param sid
	 * @param cid
	 * @return
	 */
	Chemical isChemicalExist(int sid, int cid);

	/**
	 * @return
	 */
	List<Chemical> getChemicals();

	/**
	 * @param id
	 */
	void deleteChemicalCode(int id);

	/**
	 * @param chemicalData
	 * @return
	 */
	int saveOrUpdate(ChemicalData chemicalData);

	/**
	 * @param from
	 * @param to
	 * @param cid
	 * @param pid
	 * @param sid
	 * @return
	 */
	List<ChemicalReportData> getChemicalReportData(Date from, Date to,
			int pid, int sid);

	/**
	 * @param date
	 * @param entryId
	 * @return
	 */
	List<Chemical> getChemicalData(Date date, String entryId);

	/**
	 * @param sdate
	 * @param edate
	 * @return
	 */
	List<ChemicalData> getChemicalReportDataDetail(Date sdate, Date edate);

	/**
	 * @param date
	 * @param entryId
	 */
	void deleteChemicalData(Date date, String entryId);


}

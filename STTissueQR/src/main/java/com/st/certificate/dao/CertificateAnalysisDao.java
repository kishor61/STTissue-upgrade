/**
 *Nov 12, 2014
 *CertificateAnalysisDao.java
 * TODO
 *com.st.certificate.dao
 *CertificateAnalysisDao.java
 *Sunil Singh Bora
 */
package com.st.certificate.dao;

import java.util.Date;
import java.util.List;

import com.st.certificate.model.Rewdinder;

/**
 * @author sbora
 *
 */
public interface CertificateAnalysisDao {

	/**
	 * @return
	 */
	Rewdinder getRewinder();

	/**
	 * @param dateFrom
	 * @param dateTo
	 * @param grade 
	 * @param custCode
	 * @return
	 */
	List<Rewdinder> getRewinders(Date dateFrom, Date dateTo, String customer, String grade);

	/**
	 * @param dateTo 
	 * @param dateFrom 
	 * @param customer
	 * @return
	 */
	List<String> getRewindersGrade(Date dateFrom, Date dateTo, String customer);

	/**
	 * @param string
	 * @param customer 
	 * @param dateTo 
	 * @param dateFrom 
	 * @return
	 */
	List<Rewdinder> getRewindersByReel(String string, Date dateFrom, Date dateTo, String customer);

	/**
	 * @param string
	 * @param dateFrom
	 * @param dateTo
	 * @return
	 */
	List<Rewdinder> getRewindersByReel(String string, Date dateFrom, Date dateTo);

	/**
	 * @return
	 */
	Rewdinder getRewinderpm5();

	/**
	 * @param dateFrom
	 * @param dateTo
	 * @param customer
	 * @return
	 */
	List<String> getRewindersGradepm5(Date dateFrom, Date dateTo, String customer);

	/**
	 * @param dateFrom
	 * @param dateTo
	 * @param decode
	 * @param grade
	 * @return
	 */
	List<Rewdinder> getRewinderspm5(Date dateFrom, Date dateTo, String decode, String grade);

	/**
	 * @param eDate
	 * @param sDate
	 * @param customer
	 * @return
	 */
	List<Rewdinder> getRewindersGradeWithReelpm5(Date eDate, Date sDate, String customer);

	/**
	 * @param eDate
	 * @param sDate
	 * @param customer
	 * @return
	 */
	List<Rewdinder> getRewindersGradeWithReelpm6(Date sDate, Date eDate, String customer);

	/**
	 * @param reel
	 * @param dateFrom
	 * @param dateTo
	 * @param customer
	 * @return
	 */
	List<Rewdinder> getRewindersByReel_Pm5(String reel, Date dateFrom, Date dateTo, String customer);

	/**
	 * @param eDate
	 * @param sDate
	 * @return
	 */
	List<Rewdinder> getCustomers(Date eDate, Date sDate);

	/**
	 * @param customer
	 * @return
	 */
	String getCustMails(String customer);

}

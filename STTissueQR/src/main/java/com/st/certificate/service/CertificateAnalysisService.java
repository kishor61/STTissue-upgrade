/**
 *Nov 12, 2014
 *CertificateAnalysisService.java
 * TODO
 *com.st.certificate.service
 *CertificateAnalysisService.java
 *Sunil Singh Bora
 */
package com.st.certificate.service;

import java.util.Date;
import java.util.List;

import com.st.certificate.model.Rewdinder;
import com.st.qualitypm6.model.Rewind;

/**
 * @author sbora
 *
 */
public interface CertificateAnalysisService {

	/**
	 * @return
	 */
	Rewdinder getRewinder();

	/**
	 * @param dateFrom
	 * @param dateTo
	 * @param custCode
	 * @param grade
	 * @return
	 */
	List<Rewdinder> getRewinders(Date dateFrom, Date dateTo, String customer,
			String grade);

	/**
	 * @param dateTo 
	 * @param dateFrom 
	 * @param customer
	 * @return
	 */
	List<String> getRewindersGrade(Date dateFrom, Date dateTo, String customer);

	/**
	 * @param string
	 * @param dateTo 
	 * @param dateFrom 
	 * @param customer 
	 * @return
	 */
	List<Rewdinder> getRewindersByReel(String string, Date dateFrom, Date dateTo, String customer);

	/**
	 * @return
	 */
	Rewdinder getRewinderpm5();

	

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
	 * @param dateTo
	 * @param dateFrom
	 * @param customer
	 * @return
	 */
	List<Rewdinder> getRewindersByReel_Pm5(String reel, Date dateTo, Date dateFrom, String customer);

	/**
	 * @param dateFrom
	 * @param dateTo
	 * @param customer
	 * @return
	 */
	List<String> getRewindersGradepm5(Date dateFrom, Date dateTo, String customer);

	/**
	 * @param sDate
	 * @param eDate
	 * @return
	 */
	List<Rewdinder> getCustomers(Date sDate, Date eDate);

	/**
	 * @param customer
	 * @return
	 */
	String getCustMails(String customer);

	

}

/**
 *Nov 12, 2014
 *CertificateAnalysisServiceImp.java
 * TODO
 *com.st.certificate.service
 *CertificateAnalysisServiceImp.java
 *Sunil Singh Bora
 */
package com.st.certificate.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.st.certificate.dao.CertificateAnalysisDao;
import com.st.certificate.model.Rewdinder;

/**
 * @author sbora
 *
 */
@Service
public class CertificateAnalysisServiceImp implements CertificateAnalysisService{
	@Autowired
	private CertificateAnalysisDao certificateAnalysisDao;

	/* (non-Javadoc)
	 * @see com.st.certificate.service.CertificateAnalysisService#getCustomers()
	 */
	@Transactional
	@Override
	public Rewdinder getRewinder() {
		return certificateAnalysisDao.getRewinder();
	}

	/* (non-Javadoc)
	 * @see com.st.certificate.service.CertificateAnalysisService#getRewinders(java.util.Date, java.util.Date, java.lang.String, java.lang.String)
	 */
	@Transactional
	@Override
	public List<Rewdinder> getRewinders(Date dateFrom, Date dateTo,
			String customer, String grade) {
		return certificateAnalysisDao.getRewinders(dateFrom,dateTo,customer,grade);
	}

	/* (non-Javadoc)
	 * @see com.st.certificate.service.CertificateAnalysisService#getRewindersGrade(java.lang.String)
	 */
	@Transactional
	@Override
	public List<String> getRewindersGrade(Date dateFrom, Date dateTo, String customer) {
		// TODO Auto-generated method stub
		return certificateAnalysisDao.getRewindersGrade(dateFrom,dateTo,customer);
	}

	/* (non-Javadoc)
	 * @see com.st.certificate.service.CertificateAnalysisService#getRewindersByReel(java.lang.String)
	 */
	

	/* (non-Javadoc)
	 * @see com.st.certificate.service.CertificateAnalysisService#getRewindersByReel(java.lang.String, java.util.Date, java.util.Date)
	 */
	@Override
	public List<Rewdinder> getRewindersByReel(String string, Date dateFrom, Date dateTo,String customer) {
		// TODO Auto-generated method stub
		return certificateAnalysisDao.getRewindersByReel(string,dateFrom,dateTo,customer);
	}

	/* (non-Javadoc)
	 * @see com.st.certificate.service.CertificateAnalysisService#getRewinderpm5()
	 */
	@Override
	public Rewdinder getRewinderpm5() {
		// TODO Auto-generated method stub
		return certificateAnalysisDao.getRewinderpm5();
	}

	

	/* (non-Javadoc)
	 * @see com.st.certificate.service.CertificateAnalysisService#getRewinderspm5(java.util.Date, java.util.Date, java.lang.String, java.lang.String)
	 */
	@Override
	public List<Rewdinder> getRewinderspm5(Date dateFrom, Date dateTo, String decode, String grade) {
		// TODO Auto-generated method stub
		return certificateAnalysisDao.getRewinderspm5(dateFrom,dateTo,decode,grade);
	}

	/* (non-Javadoc)
	 * @see com.st.certificate.service.CertificateAnalysisService#getRewindersGradeWithReelpm5(java.util.Date, java.util.Date, java.lang.String)
	 */
	@Override
	public List<Rewdinder> getRewindersGradeWithReelpm5(Date eDate, Date sDate, String customer) {
		// TODO Auto-generated method stub
		return certificateAnalysisDao.getRewindersGradeWithReelpm5(eDate,sDate,customer);
	}
	@Override
	public List<Rewdinder> getCustomers(Date eDate, Date sDate) {
		// TODO Auto-generated method stub
		return certificateAnalysisDao.getCustomers(eDate,sDate);
	}
	/* (non-Javadoc)
	 * @see com.st.certificate.service.CertificateAnalysisService#getRewindersGradeWithReelpm6(java.util.Date, java.util.Date, java.lang.String)
	 */
	@Override
	public List<Rewdinder> getRewindersGradeWithReelpm6(Date sDate, Date eDate, String customer) {
		// TODO Auto-generated method stub
		return certificateAnalysisDao.getRewindersGradeWithReelpm6(sDate,eDate,customer);
	}

	/* (non-Javadoc)
	 * @see com.st.certificate.service.CertificateAnalysisService#getRewindersByReel_Pm5(java.lang.String, java.util.Date, java.util.Date, java.lang.String)
	 */
	@Override
	public List<Rewdinder> getRewindersByReel_Pm5(String reel, Date dateTo, Date dateFrom, String customer) {
		// TODO Auto-generated method stub
		return  certificateAnalysisDao.getRewindersByReel_Pm5(reel,dateFrom,dateTo,customer);
	}

	/* (non-Javadoc)
	 * @see com.st.certificate.service.CertificateAnalysisService#getRewindersGradepm5(java.util.Date, java.util.Date, java.lang.String)
	 */
	@Override
	public List<String> getRewindersGradepm5(Date dateFrom, Date dateTo, String customer) {
		// TODO Auto-generated method stub
		return certificateAnalysisDao.getRewindersGradepm5(dateFrom, dateTo, customer);
	}

	/* (non-Javadoc)
	 * @see com.st.certificate.service.CertificateAnalysisService#getCustMails(java.lang.String)
	 */
	@Override
	public String getCustMails(String customer) {
		// TODO Auto-generated method stub
		return certificateAnalysisDao.getCustMails(customer);
	}

	
	
}

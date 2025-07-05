/**
 *09-Jun-2020
 *MailDehBoardServiceImp.java
 * TODO
 *com.st.common.service
 *MailDehBoardServiceImp.java
 *Roshan Lal Tailor
 */
package com.st.common.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.st.common.dao.MailDehBoardDao;
import com.st.common.model.MailDeshBoard;

/**
 * @author sohan
 *
 */
@Service
public class MailDehBoardServiceImp implements MailDehBoardService {

	@Autowired
	private MailDehBoardDao mailboardDao;
	@Override
	public List<MailDeshBoard> getMailDatas() {
		return mailboardDao.getMailDatas();
	}
	@Override
	public void save(Date date, String reportName, String frquencyOfMail, String timeToCheck, boolean status,
			String erroCode, String senderName, String reportId) {
		mailboardDao.save(date, reportName,  frquencyOfMail,  timeToCheck,  status,	 erroCode,  senderName,reportId);
	}

}

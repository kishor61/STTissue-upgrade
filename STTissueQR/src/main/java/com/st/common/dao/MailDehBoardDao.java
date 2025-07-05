/**
 *09-Jun-2020
 *MailDehBoardDao.java
 * TODO
 *com.st.common.dao
 *MailDehBoardDao.java
 *Roshan Lal Tailor
 */
package com.st.common.dao;

import java.util.Date;
import java.util.List;

import com.st.common.model.MailDeshBoard;

/**
 * @author sohan
 *
 */
public interface MailDehBoardDao {
	public List<MailDeshBoard> getMailDatas();
	public void save(Date date, String reportName, String frquencyOfMail, String timeToCheck, boolean status,
			String erroCode, String senderName, String reportId);
}

/**
 *09-Jun-2020
 *MailDehBoardService.java
 * TODO
 *com.st.common.service
 *MailDehBoardService.java
 *Roshan Lal Tailor
 */
package com.st.common.service;

import java.util.Date;
import java.util.List;

import com.st.common.model.MailDeshBoard;

/**
 * @author sohan
 *
 */
public interface MailDehBoardService {
	public List<MailDeshBoard> getMailDatas();
	
	public void save(Date date, String reportName, String frquencyOfMail, String timeToCheck, boolean b,
			String erroCode, String senderName, String reportId);
}

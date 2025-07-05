/**
 *Jan 19, 2018
 *ManintenanceLogCr6Pm6FrpReportMailer.java
 * TODO
 *com.st.manintenancelogcr6pm6frp.mailer
 *ManintenanceLogCr6Pm6FrpReportMailer.java
 *Roshan Lal Tailor
 */
package com.st.manintenancelogcr6pm6frp.mailer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import jakarta.mail.internet.MimeMessage;
import javax.sql.DataSource;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Component;

import com.st.common.CommonUtil;
import com.st.manintenancelogcr6pm6frp.model.ManintenanceLogCr6Pm6Frp;
import com.st.manintenancelogcr6pm6frp.reporthandler.ManintenanceLogCr6Pm6FrpReportHandler;
import com.st.manintenancelogcr6pm6frp.service.ManintenanceLogCr6Pm6FrpService;

/**
 * @author roshan
 *
 */
@Component
public class ManintenanceLogCr6Pm6FrpReportMailer {

private static final Logger logger = LoggerFactory.getLogger(ManintenanceLogCr6Pm6FrpReportHandler.class);
	
	private SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
	private SimpleDateFormat dateTimeFormat = new SimpleDateFormat("MM-dd-yyyy h:mm a");
	
	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private JavaMailSender mailSender;
	
	
	@Value("${mail.dailyshiftlogreport.to}")
	private String emailTo;
	
	@Value("${mail.dailyshiftlogreport.bcc}")
	private String emailBcc;

	@Value("${mail.from}")
	private String emailFrom;

	@Value("${mail.fromname}")
	private String emailFromName;

	@Value("${mail.to.error}")
	private String emailToError;
	
	@Autowired
	private ManintenanceLogCr6Pm6FrpService manintenanceLogCr6Pm6FrpServic;
	
	@Autowired
	private ManintenanceLogCr6Pm6FrpReportHandler ManintenanceLogCr6Pm6FrpReportHandler;
	
	/**
	 * @param sdate
	 * @param edate
	 * @param string 
	 * @throws IOException 
	 */
	public void sendDailyShiftReportMail(Date sdate, Date edate, final String operator) throws IOException {
		String folder = System.getProperty("catalina.base")
				+ "/Daily Shift Log Report";
		File folderFile = new File(folder);
		if (!folderFile.exists()) {
			folderFile.mkdirs();
		}

		final File xlsfile = new File(folder, "Daily Shift Log Report" + ".xlsx");

		prepareDocumentForDailyShiftLogs(xlsfile, sdate,edate,operator);

		mailSender.send(new MimeMessagePreparator() {

			@Override
			public void prepare(MimeMessage mimeMessage) throws Exception {
				MimeMessageHelper messageHelper = new MimeMessageHelper(
						mimeMessage, true);
				messageHelper.setTo(emailTo.split(";"));
				messageHelper.setFrom(emailFrom, emailFromName);
				messageHelper.setBcc(emailBcc.split(";"));
				
				if(operator.equalsIgnoreCase("ALL") || operator==""){
					messageHelper.setSubject(dateFormat.format(new Date())
							+ "-STT-PM6-Daily Shift Log Report");
				}else if(operator.equalsIgnoreCase("OPERATOR6")){
					messageHelper.setSubject(dateFormat.format(new Date())
							+ "-STT-PM5-Daily Shift Log Report");
				}else{
					messageHelper.setSubject(dateFormat.format(new Date())
							+ "-STT-Daily Shift Log Report");
				}
				
				
				messageHelper.setText(getMessage(), true);
				if (xlsfile.exists()) {
					messageHelper.addAttachment(
							dateFormat.format(new Date())
									+ "-STT-Daily Shift Log Report.xlsx",
							new ByteArrayResource(IOUtils
									.toByteArray(new FileInputStream(xlsfile))));
				}
				logger.info("ST Tissue Daily Shift Log Report mail is sent");
			}

			private String getMessage() {
				StringBuilder builder = new StringBuilder();
				builder.append("Hello Sir,<br/><br/>");
				builder.append("Please find the attached <b>\"ST Tissue Daily Shift Log Report\"</b> for your review.<br/>");
				builder.append("<br/>Thank you,<br/>");
				builder.append("Jaipur<br/><p style='font-size: 12px;'>*** This is an automatically system generated email at:"
						+ dateTimeFormat.format(new Date()) + " ***</p>");

				return builder.toString();
			}
		});

	
	}

	/**
	 * @param xlsfile
	 * @param sdate
	 * @param edate
	 * @param operator 
	 * @throws IOException 
	 */
	private void prepareDocumentForDailyShiftLogs(File xlsfile, Date sdate,
			Date edate, String operator) throws IOException {
		
		String SDate=dateFormat.format(sdate);
		String EDate=dateFormat.format(edate);
		
		Date sDate=CommonUtil.checkDate(SDate, dateFormat);
		Date eDate=CommonUtil.checkDate(EDate, dateFormat);
		
		List<ManintenanceLogCr6Pm6Frp> details=manintenanceLogCr6Pm6FrpServic.getDateBetweenData_Email(dateFormat.format(sDate),dateFormat.format(eDate),operator);
		
		FileOutputStream outputStream = new FileOutputStream(xlsfile);
		
		ManintenanceLogCr6Pm6FrpReportHandler.emailManintenanceLogCr6Pm6FrpReport(details,outputStream);

		outputStream.close();

	}

}

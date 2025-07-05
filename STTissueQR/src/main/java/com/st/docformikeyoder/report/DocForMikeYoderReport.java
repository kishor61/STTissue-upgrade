/**
 *Jun 1, 2016
 *DocForMikeYoderReport.java
 * TODO
 *com.st.docformikeyoder.report
 *DocForMikeYoderReport.java
 *Sunil Singh Bora
 */
package com.st.docformikeyoder.report;

import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import jakarta.mail.internet.MimeMessage;

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

import com.st.production.automailer.ProductionReportAutoMailer;

/**
 * @author roshan
 *
 */
@Component
public class DocForMikeYoderReport {

	private static final Logger logger = LoggerFactory.getLogger(ProductionReportAutoMailer.class);
	private SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
	private SimpleDateFormat dateTimeFormat = new SimpleDateFormat("MM-dd-yyyy h:mm a");

	
	@Autowired
	private JavaMailSender mailSender;
	
	@Value("${mail.to.yoderdoc}")
	private String emailToyoderdoc;
	
	@Value("${mail.bcc}")
	private String emailBcc;
	
	@Value("${mail.from}")
	private String emailFrom;

	@Value("${mail.fromname}")
	private String emailFromName;
	
	@Value("${mail.to.error}")
	private String emailToError;

	/**
	 * 
	 */
	public void sendMailAt8am() {
		String folder = System.getProperty("catalina.base")+ "/MikeYoderDocFile";
		File folderFile = new File(folder);

		if (!folderFile.exists()) {
			folderFile.mkdirs();
		}
		final File xlsfile = new File(folder, "List_of_Work_Orders" + ".docx");
		
		mailSender.send(new MimeMessagePreparator() {

			@Override
			public void prepare(MimeMessage mimeMessage) throws Exception {
				MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true);
				messageHelper.setTo(emailToyoderdoc.split(";"));
				messageHelper.setFrom(emailFrom, emailFromName);
				messageHelper.setBcc(emailBcc.split(";"));
				messageHelper.setSubject(dateFormat.format(new Date())+" STT-List Of Work Orders Report");
				messageHelper.setText(getMessage(), true);
				if (xlsfile.exists()) {
					messageHelper.addAttachment("List_of_Work_Orders.docx",new ByteArrayResource(IOUtils.toByteArray(new FileInputStream(xlsfile))));
				}
				logger.info("ST Tissue List Of Work Orders File reports mail is sent");
			}

			private String getMessage() {
				StringBuilder builder = new StringBuilder();
				builder.append("Hello Mike ,<br/><br/>");
				builder.append("Please find the attached <b>\"ST Tissue - List Of Work Orders File\"</b> for your review.<br/>");
				builder.append("<br/>Thank you,<br/>");
				builder.append("Jaipur<br/><p style='font-size: 12px;'>*** This is an automatically system generated email at:"
						+ dateTimeFormat.format(new Date()) + " ***</p>");

				return builder.toString();
			}
		});
	}
}

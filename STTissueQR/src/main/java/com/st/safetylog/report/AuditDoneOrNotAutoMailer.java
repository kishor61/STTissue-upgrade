/**
 *May 24, 2016
 *AuditDoneOrNotAutoMailer.java
 * TODO
 *com.st.safetylog.report
 *AuditDoneOrNotAutoMailer.java
 *Sunil Singh Bora
 */
package com.st.safetylog.report;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import jakarta.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Component;

import com.st.production.automailer.ProductionReportAutoMailer;
import com.st.safetylog.model.SafetyHousekeepingSchedule;

/**
 * @author roshan
 *
 */
@Component
public class AuditDoneOrNotAutoMailer {

	private static final Logger logger = LoggerFactory.getLogger(ProductionReportAutoMailer.class);
	private SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
	private SimpleDateFormat dateTimeFormat = new SimpleDateFormat("MM-dd-yyyy h:mm a");
	private SimpleDateFormat dateTimeFormat4 = new SimpleDateFormat("yyyy-MM-dd");
	
	@Autowired
	private JavaMailSender mailSender;
	
	@Value("${mail.to.auditdoneornot}")
	private String emailToauditdoneornot;
	
	@Value("${mail.bcc}")
	private String emailBcc;
	
	@Value("${mail.from}")
	private String emailFrom;

	@Value("${mail.fromname}")
	private String emailFromName;
	
	@Value("${mail.to.error}")
	private String emailToError;
	
	/**
	 * @param auditStatus
	 * @param auditerDetails
	 */
	public void sendMailOnFriday7am(final List<SafetyHousekeepingSchedule> auditStatus, final List<SafetyHousekeepingSchedule> auditerDetails) {

		mailSender.send(new MimeMessagePreparator() {

			@Override
			public void prepare(MimeMessage mimeMessage) throws Exception {

				try {

					if(auditStatus.size()>0){
						for(SafetyHousekeepingSchedule data:auditStatus){
							boolean status =data.isAuditStatus();
							int auditorId=data.getAuditor();
							if(status==true){
								
							}else if(status==false){
								for(SafetyHousekeepingSchedule data2 :auditerDetails  ){
									
									String auditorEmail=data2.getAuditorEamil();
									String auditorName=data2.getAuditorName();
									
									MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, "UTF-8");
									//messageHelper.setTo(emailToauditdoneornot.split(";"));
									messageHelper.setTo(auditorEmail);
									messageHelper.setBcc(emailBcc.split(";"));
									messageHelper.setFrom(emailFrom, emailFromName);

									Calendar cal = Calendar.getInstance();
									cal.add(Calendar.DATE, -1);

									messageHelper.setSubject(dateTimeFormat4.format(cal.getTime()) + "-STT-Reminder For Audit or Input Is Pending ");
									mimeMessage.setContent(getMessageBody(auditorName, auditorEmail),"text/html");
								}
									
							}else{
								
								
							}
						}
					}else{
						System.out.println("HHHH");
						MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, "UTF-8");
						messageHelper.setTo("ajay.tak@st-technology.com");
						messageHelper.setCc("roshan@stinfosys.com");
						messageHelper.setFrom(emailFrom, emailFromName);

						Calendar cal = Calendar.getInstance();
						cal.add(Calendar.DATE, -1);

						messageHelper.setSubject(dateTimeFormat4.format(cal.getTime()) + "-STT-Reminder For Audit or Input Is Pending ");
						mimeMessage.setContent(getMessageBody1(),"text/html");
					}
					
					

				} catch (Exception e) {
					logger.error("Error message in Frp Producation Operator Data Entry Report..."+ e.getMessage(), e);

					MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, "UTF-8");
					messageHelper.setTo(emailToError.split(";"));
					messageHelper.setFrom(emailFrom);
					messageHelper.setSubject("Fail to send Reminder For Audit report.");
					mimeMessage.setContent("Unable to read Reminder For Audit  data<br>"+ e.getMessage(), "text/html");
				}

				logger.info("Reminder For Audit Report Mail Sent....");
			}
		});
	}

	/**
	 * @return
	 */
	@SuppressWarnings("unchecked")
	protected String getMessageBody1() {
		StringBuilder builder = new StringBuilder();
		
		builder.append("Hello Ajay/Roshan,"
				+ "<br/><br/>Your Audit or Input Data In System Is Done, No Audit Is Pending.<br/>"
				+ "<br/>");
		builder.append("");
		builder.append("<br/>--<br/>Thank You,<br/>Jaipur<br/><p style='font-size: 12px;'>*** This is an automatically system generated email:Time"
				+ dateTimeFormat.format(new Date()) + " ***</p>");
		
		return builder.toString();
	}

	/**
	 * @param auditorName
	 * @param auditorEmail
	 * @return
	 */
	@SuppressWarnings("unchecked")
	protected Object getMessageBody(String auditorName, String auditorEmail) {
		StringBuilder builder = new StringBuilder();
		
		builder.append("Hello "+auditorName+","
				+ "<br/><br/>Your Audit or Input Data In System Is Pending.<br/>"
				+ "<br/>");
		builder.append("");
		builder.append("<br/>--<br/>Thank You,<br/>Jaipur<br/><p style='font-size: 12px;'>*** This is an automatically system generated email:Time"
				+ dateTimeFormat.format(new Date()) + " ***</p>");
		
		return builder.toString();
	}
}

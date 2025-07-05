/**
 *Nov 30, 2017
 *CoustomerComplaintReportMailer.java
 * TODO
 *com.st.customercomplaint.mailer
 *CoustomerComplaintReportMailer.java
 *Roshan Lal Tailor
 */
package com.st.customercomplaint.mailer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

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

import com.st.customercomplaint.model.CustomerComplaint;
import com.st.customercomplaint.report.CustomerComplaintReportHandller;
import com.st.customercomplaint.service.CoustomerComplaintService;

/**
 * @author roshan
 *
 */
@Component
public class CustomerComplaintReportMailer {

	
	private static final Logger logger = LoggerFactory.getLogger(CustomerComplaintReportMailer.class);
	private SimpleDateFormat dateTimeFormat = new SimpleDateFormat("MM-dd-yyyy h:mm a");
	private SimpleDateFormat dateTimeFormat4 = new SimpleDateFormat("yyyy-MM-dd");
	
	@Autowired
	private CoustomerComplaintService coustomercomplaintservice;
	
	@Autowired
	private CustomerComplaintReportHandller customercomplaintreporthandller;
	
	
	@Autowired
	private JavaMailSender mailSender;
	
	@Value("${mail.from}")
	private String emailFrom;

	@Value("${mail.fromname}")
	private String emailFromName;
	
	@Value("${mail.to.CustomerComplaintReport}")
	private String mailTo;
	
	@Value("${mail.bcc.CustomerComplaintReport}")
	private String mailBcc;
	
	/**
	 * @param sdate
	 * @param edate
	 * @throws IOException 
	 */
	public void sendComplaintCustomerReportEmail(Date sdate, Date edate) throws IOException {
		String folder=System.getProperty("catalina.base")+"/Customer Complaint Report Email_Roshan Tailor";
		File folderFile=new File(folder);
		if(!folderFile.exists()){
			folderFile.mkdirs();
		}
		
		final File xlsfile=new File(folder,"Customer Complaint Report"+".xlsx");
		
		prepareCustomerComplaintReportEmail(xlsfile,sdate,edate);
		mailSender.send(new MimeMessagePreparator(){

			@Override
			public void prepare(MimeMessage mimeMessage) throws Exception {
				MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage,true);
				messageHelper.setTo(mailTo.split(";"));
				messageHelper.setFrom(emailFrom,emailFromName);
				messageHelper.setBcc(mailBcc.split(";"));
				
				Calendar cal = Calendar.getInstance();
				cal.add(Calendar.DATE, 0);
				
				messageHelper.setSubject(dateTimeFormat4.format(cal.getTime())+"-Customer Complaint Report");
				
				messageHelper.setText(getMessage(), true);
				if(xlsfile.exists()){
					messageHelper.addAttachment(dateTimeFormat4.format(cal.getTime())+"-Customer Complaint Report.xlsx", new ByteArrayResource(IOUtils.toByteArray(new FileInputStream(xlsfile))));
				}
				logger.info("ST Tissue Customer Complaint Report mail is sent");
			}

			private String getMessage() {
				StringBuilder builder=new StringBuilder();
				builder.append("Hello Sir,<br/><br/>");
				builder.append("Please find the attached <b>\"ST Tissue Customer Complaint Report\"</b> for your review.<br/>");
				builder.append("<br/>Thank you,<br/>");
				builder.append("Jaipur<br/><p style='font-size: 12px;'>*** This is an automatically system generated email at:"+dateTimeFormat.format(new Date())+" ***</p>");
				builder.append("<br/><p style='color: white;'>Roshan Tailor</p><br/>");
				return builder.toString();
			}});
		
		
		
	}

	/**
	 * @param xlsfile
	 * @param edate 
	 * @param sdate 
	 * @throws IOException 
	 */
	private void prepareCustomerComplaintReportEmail(File xlsfile, Date sdate, Date edate) throws IOException {
		FileOutputStream outputStream=new FileOutputStream(xlsfile);
		
		List<CustomerComplaint> datas=coustomercomplaintservice.getComplaintCustomerReport(sdate,edate);
		customercomplaintreporthandller.complaintCustomerReportSendMailFunction(datas,outputStream);
		outputStream.close();
	}

}

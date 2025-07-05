/**
 *Dec 2, 2014
 *SummaryDataAutoMailer.java
 * TODO
 *com.st.pmothers.automailer
 *SummaryDataAutoMailer.java
 *Sunil Singh Bora
 */
package com.st.pmothers.automailer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.mail.internet.MimeMessage;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Component;

import com.st.common.model.UserAuditor;
import com.st.common.service.UserAuditorService;
import com.st.pmothers.model.SummaryData;
import com.st.pmothers.report.SummaryDataReportHanlder;
import com.st.pmothers.service.SummaryDataService;

/**
 * @author sbora
 *
 */
@Component
public class SummaryDataAutoMailer {
	private static final Logger logger=LoggerFactory.getLogger(SummaryDataAutoMailer.class);
	
	private SimpleDateFormat dateTimeFormat=new SimpleDateFormat("MM-dd-yyyy h:mm a");
	
	private SimpleDateFormat dateTimeFormat2=new SimpleDateFormat("yyyy-MM-dd");
	//Code Ends Here Done By Roshan Tailor
	
	
	@Value("${mail.to}")
	private String emailTo;
	
	@Value("${mail.bcc}")
	private String emailBcc;
	
	@Value("${mail.from}")
	private String emailFrom;
	
	@Value("${mail.fromname}")
	private String emailFromName;
	
	@Value("${mail.to.error}")
	private String emailToError;
	
	@Autowired
	private JavaMailSender mailSender;
	
	@Autowired
	private UserAuditorService userAuditorService;
	
	@Autowired
	private SummaryDataService summaryDataService;
	
	@Autowired
	private SummaryDataReportHanlder summaryDataReportHanlder;
	
	
	public void sendSummaryMail(int id) throws Exception{
		String folder=System.getProperty("catalina.base")+"/Daily Summary Report";
		File folderFile=new File(folder);
		if(!folderFile.exists()){
			folderFile.mkdirs();
		}
		
		final File filePdf=new File(folder,"Daily Summary Report"+".pdf");
		SummaryData summaryData=summaryDataService.getSummaryData(id);
		preparePdfDocument(summaryData,filePdf);
		
		
		
		List<UserAuditor> userAuditors=userAuditorService.getUserAutiors();
		
		List<String> emailList=new ArrayList<>();
		for (UserAuditor userAuditor : userAuditors) {
			if(StringUtils.isNotEmpty(userAuditor.getEmail())){
				emailList.add(userAuditor.getEmail());
			}
		}
		
		String[] emails=new String[emailList.size()];
		for (int i=0;i<emailList.size();i++) {
			emails[i]=emailList.get(i);
		}
		final String[] finalEmail=emails;
		
		
		if(finalEmail!=null && finalEmail.length>0){
			try {
				mailSender.send(new MimeMessagePreparator(){

					@Override
					public void prepare(MimeMessage mimeMessage) throws Exception {
						MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage,true);
						messageHelper.setTo(finalEmail);
						messageHelper.setFrom(emailFrom,emailFromName);
						messageHelper.setBcc(emailBcc.split(";"));
						//messageHelper.setSubject("ST Tissue Daily Summary Report "+dateTimeFormat.format(new Date()));
						//Code Starts From Here Done By Roshan Tailor
						messageHelper.setSubject(dateTimeFormat2.format(new Date())+"-STT-Daily Summary Report");
						//Code Ends Here Done By Roshan TAilor
						messageHelper.setText(getMessage(), true);
						if(filePdf.exists()){
							messageHelper.addAttachment(dateTimeFormat2.format(new Date())+"-STT-Daily Summary Report.pdf", new ByteArrayResource(IOUtils.toByteArray(new FileInputStream(filePdf))));
						}
						logger.info("Group mail of ST Daily Summary Report is sent");
					}

					private String getMessage() {
						StringBuilder builder=new StringBuilder();
						builder.append("Hello Sir,<br/><br/>");
						builder.append("Please find the attached <b>\"Daily Summary Report\"</b> for your review.<br/>");
						builder.append("<br/>Thank you,<br/>");
						builder.append("Jaipur<br><p style='font-size: 12px;'>*** This is an automatically system generated email at:"+dateTimeFormat.format(new Date())+" ***</p>");
						
						return builder.toString();
					}});
			} catch (Exception e) {
				logger.error("Fail to send ST Daily Summary Report mail...", e);
			}
		}
		
	}
	


	/**
	 * @param filePdf
	 * @throws Exception 
	 */
	private void preparePdfDocument(SummaryData summaryData,File filePdf) throws Exception {
		FileOutputStream outputStream=new FileOutputStream(filePdf);
		summaryDataReportHanlder.createPdfDailySummaryReport(summaryData, outputStream);
		outputStream.close();
	}
}

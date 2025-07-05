/**
 * 
 */
package com.st.oimnotes.automailer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

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

import com.st.common.OimCommon;
import com.st.common.model.UserAuditor;
import com.st.common.service.UserAuditorService;
import com.st.oimnotes.model.Summary;
import com.st.oimnotes.report.OimNotesReportHandler;
import com.st.oimnotes.service.OimNotesService;

/**
 * @author sbora
 *
 */
@Component
public class OimnotesAutoMailer {
private static final Logger logger=LoggerFactory.getLogger(OimnotesAutoMailer.class);
	
	private SimpleDateFormat dateTimeFormat=new SimpleDateFormat("MM-dd-yyyy h:mm a");
	
private SimpleDateFormat dateTimeFormat2=new SimpleDateFormat("yyyy-MM-dd");
//	Code Ends Here Done By Roshan Tailor
	@Autowired
	private JavaMailSender mailSender;
	

	@Autowired
	private UserAuditorService userAuditorService;
	
	@Autowired
	private OimNotesService oimNotesService;
	
	@Autowired
	private OimNotesReportHandler oimNotesReport;
	
	
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
	
	public void  sendMailOpenReport() throws Exception {
		
		String folder=System.getProperty("catalina.base")+"/Oim Notes";
		File folderFile=new File(folder);
		if(!folderFile.exists()){
			folderFile.mkdirs();
		}
		
		
		final File filePdf=new File(folder,"Process Improvement Meeting Notes - Open Follow Up"+".pdf");
		
		prepareOpemFollowUpPdfDocument(filePdf);
		
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
						//messageHelper.setSubject("ST Tissue Process Improvement Meeting Notes - Open Follow Ups "+dateTimeFormat.format(new Date()));
						//Code Starts From Here Done By Roshan 
						messageHelper.setSubject(dateTimeFormat2.format(new Date())+"-STT-Improvement Meeting Notes - Open Follow Ups");
						//Code Ends Here Done Rodhan Tailor
						messageHelper.setText(getMessage(), true);
						if(filePdf.exists()){
							messageHelper.addAttachment(dateTimeFormat2.format(new Date())+"-STT-Process Improvement Meeting Notes - Open Follow Ups.pdf", new ByteArrayResource(IOUtils.toByteArray(new FileInputStream(filePdf))));
						}
						logger.info("Group mail of ST Safety Open action item is sent");
					}

					private String getMessage() {
						StringBuilder builder=new StringBuilder();
						builder.append("Hello Sir,<br/><br/>");
						builder.append("Please find the attached <b>\"ST Tissue Process Improvement Meeting Notes - Open Follow Ups\"</b> for your review.<br/>");
						builder.append("<br/>Thank you,<br/>");
						builder.append("Jaipur<br><p style='font-size: 12px;'>*** This is an automatically system generated email at:"+dateTimeFormat.format(new Date())+" ***</p>");
						
						return builder.toString();
					}});
			} catch (Exception e) {
				logger.error("Fail to send Open Process Impmrovement notes...mail", e);
			}
		}
		
	}

	/**
	 * @param filePdf
	 * @throws Exception 
	 */
	private void prepareOpemFollowUpPdfDocument(File filePdf) throws Exception {
		
		Map<String, String> recurrences =OimCommon.getRecurrenceList();
		List<Summary> summaries=oimNotesService.getOpenSummariesFolloUps();
		
		
		FileOutputStream outputStream=new FileOutputStream(filePdf);
		
		oimNotesReport.createOpenFollowUpReport(summaries,recurrences,outputStream);
		 
		outputStream.close();
	}
}

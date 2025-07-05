/**
 *Dec 26, 2017
 *ReelRewinderPM5AutoMailer.java
 * TODO
 *com.st.qualitypm5.automailer
 *ReelRewinderPM5AutoMailer.java
 *Roshan Lal Tailor
 */
package com.st.qualitypm5.automailer;

import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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

import com.st.qualitypm5.service.ReelServicePM5;
import com.st.qualitypm5.service.RewindServicePM5;
import com.st.qualitypm6.automailer.ReelRewinderAutoMailer;
import com.st.qualitypm6.service.ReelService;
import com.st.qualitypm6.service.RewindService;

/**
 * @author roshan
 *
 */
@Component
public class ReelRewinderPM5AutoMailer {

	private static final Logger logger=LoggerFactory.getLogger(ReelRewinderPM5AutoMailer.class);
	
	private SimpleDateFormat dateFormat=new SimpleDateFormat("MM-dd-yyyy");
	private SimpleDateFormat dateFormat3=new SimpleDateFormat("yyyyMMddHHmm");
	private SimpleDateFormat dateTimeFormat=new SimpleDateFormat("MM-dd-yyyy h:mm a");
	private SimpleDateFormat dateFormat5=new SimpleDateFormat("yyyy-MM-dd");
		
		
	
	@Autowired
	private JavaMailSender mailSender;
	
	
	@Autowired
	private ReelServicePM5 reelServicepm5;
	
	@Autowired
	private RewindServicePM5 rewindServicePM5;
	
	
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
	
	/**
	 * @param repientEmails 
	 * @param date2
	 * @param string
	 */
	public void sendMail(final Date date, final String shift, String repientEmails) {
		
		mailSender.send(new MimeMessagePreparator() {
			
			@Override
			public void prepare(MimeMessage mimeMessage) throws Exception {
				try {
					
					String folder=System.getProperty("catalina.base")+"/Quality Reports_PM5";
					File folderFile=new File(folder);
					if(!folderFile.exists()){
						folderFile.mkdirs();
					}
					
					Calendar cal=Calendar.getInstance();
					cal.setTime(date);
					
					cal.add(Calendar.DATE, -1);
					System.out.println(cal.getTime());
					File fileReelPdf=new File(folder,"ST Tissue PM5 Tissue Machine Quality Report-REEL Testing "+dateFormat3.format(new Date())+".pdf");
					reelServicepm5.createPdfReelReport(fileReelPdf, cal.getTime());
					
					File fileRwinderPdf=new File(folder,"ST Tissue PM5 Tissue Machine Quality Report-REWINDER Testing "+dateFormat3.format(new Date())+".pdf");
					rewindServicePM5.createPdfReelReport(fileRwinderPdf, cal.getTime());
					
					MimeMessageHelper messageHelper=new MimeMessageHelper(mimeMessage,true);
					messageHelper.setTo(emailTo.split(";"));
					messageHelper.setFrom(emailFrom,emailFromName);
					messageHelper.setBcc(emailBcc.split(";"));
					
					messageHelper.setSubject(dateFormat5.format(date)+"-STT-PM5 Quality Reports"+""+shift);
					
					messageHelper.setText(getMessageBody(fileReelPdf,fileRwinderPdf,cal.getTime()), true);
					
					if(fileReelPdf.exists()){
						logger.info("Sending reel file as attachment="+fileReelPdf.getName());
						messageHelper.addAttachment(dateFormat5.format(cal.getTime())+"-STT-PM5 Tissue Machine Quality Report-REEL Testing.pdf", new ByteArrayResource(IOUtils.toByteArray(new FileInputStream(fileReelPdf))));
					}
					
					if(fileRwinderPdf.exists()){
						logger.info("Sending rwinder file as attachment="+fileReelPdf.getName());
						messageHelper.addAttachment(dateFormat5.format(cal.getTime())+"-STT-PM5 Tissue Machine Quality Report-REWINDER Testing.pdf", new ByteArrayResource(IOUtils.toByteArray(new FileInputStream(fileRwinderPdf))));
					}
					
						
				} catch (Exception e) {
					logger.error("Error message in PM5 quality report..."+e.getMessage(),e);
					MimeMessageHelper messageHelper=new MimeMessageHelper(mimeMessage, "UTF-8");
					messageHelper.setTo(emailToError.split(";"));
					messageHelper.setFrom(emailFrom);
					messageHelper.setSubject("Fail to send PM5 quality report.");
					mimeMessage.setContent("Unable to read production data<br>"+e.getMessage(), "text/html");
				}
				

				logger.info("Production Summary Report PM5 message sent....");
			}	

			
		});
		
	}

	/**
	 * @param fileReelPdf
	 * @param fileRwinderPdf
	 * @param date
	 * @return
	 */
	private String getMessageBody(File fileReelPdf, File fileRwinderPdf, Date date) {
		
		StringBuilder builder=new StringBuilder();
		builder.append("Hello Sir, <br/>");
		
		if(fileReelPdf.exists() && fileRwinderPdf.exists()){
			builder.append("Please find the attached ST Tissue PM5 Quality Reports of "+dateFormat.format(date)+" for your review.<br/><br/>");	
		}else if(fileReelPdf.exists() && !fileRwinderPdf.exists()){
			builder.append("Please find the attached ST Tissue PM5 Quality Reports of "+dateFormat.format(date)+" for your review.<br/><br/>");
			builder.append("<p style=\"color: red;\">Note: There is no data for PM5 Tissue Machine Quality Report-Rewinder.</p><br/><br/>");
		}else if(!fileReelPdf.exists() && fileRwinderPdf.exists()){
			builder.append("Please find the attached ST Tissue PM5 Quality Reports of "+dateFormat.format(date)+" for your review.<br/><br/>");
			builder.append("<p style=\"color: red;\">Note: There is no data for PM5 Tissue Machine Quality Report-Reel.</p><br/><br/>");
		}else{
			builder.append(
					"<p>We are unable to generate ST Tissue  PM5 Quality Reports at this time because<br><br>"
					+ "<span style=\"color: red;font-size: 18px;\"> \"Either data not available in database or Machine is under maintenance.\"</span></p>");
		}
		
		builder.append("Thank you,<br/>");
		builder.append("Jaipur<br/><p style='font-size: 12px;'>*** This is an automatically system generated email at:"+dateTimeFormat.format(new Date())+" ***</p>");
		
		return builder.toString();
	}

}

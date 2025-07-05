/**
 * 
 */
package com.st.safetylog.automailer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
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

import com.st.common.CommonUtil;
import com.st.common.model.UserAuditor;
import com.st.common.service.UserAuditorService;
import com.st.safetylog.model.SafetyHousekeeping;
import com.st.safetylog.model.SafetyHousekeepingSchedule;
import com.st.safetylog.model.SafetyHousekeepingStdType;
import com.st.safetylog.report.SafetyHousekeepingReport;
import com.st.safetylog.service.SafetyHousekeepingService;

/**
 * @author sbora
 *
 */
@Component
public class SafetyHousekeepingAutoMailer {
	private static final Logger logger=LoggerFactory.getLogger(SafetyHousekeepingAutoMailer.class);
	
	private SimpleDateFormat dateFormat=new SimpleDateFormat("MM-dd-yyyy");
	private SimpleDateFormat dateTimeFormat=new SimpleDateFormat("MM-dd-yyyy h:mm a");
	private SimpleDateFormat dateTimeFormat2=new SimpleDateFormat("yyyy-MM-dd");
	//Code Ends Here Done By Roshan Tailor
	
	@Autowired
	private JavaMailSender mailSender;
	
	@Autowired
	private SafetyHousekeepingService safetyHousekeepingService;
	
	@Autowired
	private UserAuditorService userAuditorService;
	
	@Autowired
	private SafetyHousekeepingReport safetyHousekeepingReport;
	
	
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
	
	
	public void sendScheduleMail() throws Exception {
		
		String folder=System.getProperty("catalina.base")+"/Safety Housekeeping";
		File folderFile=new File(folder);
		if(!folderFile.exists()){
			folderFile.mkdirs();
		}
		
		final File filePdf=new File(folder,"Safety Housekeeping Standard"+".pdf");
		
		preparePdfDocument(filePdf);
		
		Calendar calendar=Calendar.getInstance();
		calendar.setTime(CommonUtil.checkDate(dateFormat.format(new Date()), dateFormat));
		calendar.add(Calendar.DATE, 1);
//		System.out.println(calendar.getTime());
		
		List<SafetyHousekeepingSchedule> schedules=safetyHousekeepingService.getScheduledList(calendar.getTime());
	
		
		for (final SafetyHousekeepingSchedule safetyHousekeepingSchedule : schedules) {
			
			if(StringUtils.isNotEmpty(safetyHousekeepingSchedule.getAuditorEamil())){
				try {
					mailSender.send(new MimeMessagePreparator(){

						@Override
						public void prepare(MimeMessage mimeMessage) throws Exception {
							MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage,true);
							messageHelper.setTo(safetyHousekeepingSchedule.getAuditorEamil());
							messageHelper.setFrom(emailFrom,emailFromName);
							messageHelper.setBcc(emailBcc.split(";"));
							//messageHelper.setSubject("ST Tissue Safety, Environmental and Housekeeping Inspection - Reminder "+dateTimeFormat.format(new Date()));
							
							//Code Starts From Here Done By Roshan Tailor Date:- 06/27/2015
								messageHelper.setSubject(dateTimeFormat2.format(new Date())+"-STT-Safety, Environmental and Housekeeping Inspection - Reminder");
							//Code Ends Here Done By Roshan Tailor Date :- 06/27/2015
							
							messageHelper.setText(getMessage(safetyHousekeepingSchedule), true);
							if(filePdf.exists()){
								logger.info("Housekeeping file as attachment="+filePdf.getName()+" to "+safetyHousekeepingSchedule.getAuditorName());
								messageHelper.addAttachment(dateTimeFormat2.format(new Date())+"-STT-Safety Housekeeping Form.pdf", new ByteArrayResource(IOUtils.toByteArray(new FileInputStream(filePdf))));
							}
						}

						private String getMessage(
								SafetyHousekeepingSchedule safetyHousekeepingSchedule) {
							StringBuilder builder=new StringBuilder();
							builder.append("<b>Area:-</b> "+safetyHousekeepingSchedule.getAreaName()+"<br/>");
							builder.append("<b>Audit Date:-</b> "+dateFormat.format(safetyHousekeepingSchedule.getDate())+"<br/>");
							
							builder.append("<br/>Thank you,<br/>");
							builder.append("Jaipur<br/><p style='font-size: 12px;'>*** This is an automatically system generated email at:"+dateTimeFormat.format(new Date())+" ***</p>");
							
							return builder.toString();
						}});
				} catch (Exception e) {
					logger.error("Fail to send Safety Housekeeping email to..."+safetyHousekeepingSchedule.getAuditorEamil(), e);
				}
			}
			
		}
		
	}
	/**
	 * @param filePdf
	 * @throws Exception 
	 */
	private void preparePdfDocument(File filePdf) throws Exception {
		List<SafetyHousekeepingStdType> types=safetyHousekeepingService.getSafetyHouseStandard();
		List<SafetyHousekeeping> housekeepings=safetyHousekeepingService.getSafetyHousekeeping();
		FileOutputStream outputStream=new FileOutputStream(filePdf);
		safetyHousekeepingReport.createHousekeepingStandardReport(types,housekeepings,outputStream);
		outputStream.close();
	}
	

	public void sendOpenActionItemMail() throws Exception {
		
		String folder=System.getProperty("catalina.base")+"/Safety Housekeeping";
		File folderFile=new File(folder);
		if(!folderFile.exists()){
			folderFile.mkdirs();
		}
		
		//System.out.println(folderFile.getAbsolutePath());
		
		final File filePdf=new File(folder,"Safety Housekeeping Standard-Open Action Items"+".pdf");
		
		prepareOpenActionItemPdfDocument(filePdf);
		
		Calendar calendar=Calendar.getInstance();
		calendar.setTime(CommonUtil.checkDate(dateFormat.format(new Date()), dateFormat));
		calendar.add(Calendar.DATE, 1);
		
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
						messageHelper.setTo("sohanlal@stinfosys.com");
						messageHelper.setFrom(emailFrom,emailFromName);
						messageHelper.setBcc(emailBcc.split(";"));
						//messageHelper.setSubject("ST Tissue Safety Housekeeping - Open Action Items "+dateTimeFormat.format(new Date()));
						//Code Starts From Here Done By Roshan Tailor Date :- 06/27/2015
						messageHelper.setSubject(dateTimeFormat2.format(new Date())+"-STT-Safety Housekeeping - Open Action Items");
						//Code Ends Here Done By Roshan Tailor Date :- 06/27/2015
						messageHelper.setText(getMessage(), true);
						if(filePdf.exists()){
							 
							messageHelper.addAttachment(dateTimeFormat2.format(new Date())+"-STT-Safety Housekeeping - Open Action Items.pdf", new ByteArrayResource(IOUtils.toByteArray(new FileInputStream(filePdf))));
						}
						logger.info("Group mail of ST Safety Open action item is sent");
					}

					private String getMessage() {
						StringBuilder builder=new StringBuilder();
						builder.append("Hello Sir,<br/><br/>");
						builder.append("Please find the attached <b>\"ST Tissue Safety Housekeeping - Open Action Items\"</b> for your review.<br/>");
						builder.append("<br/>Thank you,<br/>");
						builder.append("Jaipur<br/><p style='font-size: 12px;'>*** This is an automatically system generated email at:"+dateTimeFormat.format(new Date())+" ***</p>");
						
						return builder.toString();
					}});
			} catch (Exception e) {
				logger.error("Fail to send ST Tissue Safety Housekeeping - Open Action Items mail...", e);
			}
		}
		
	}
	/**
	 * @param filePdf
	 * @throws Exception 
	 */
	private void prepareOpenActionItemPdfDocument(File filePdf) throws Exception {
		List<SafetyHousekeeping> housekeepings=safetyHousekeepingService.getSafetyHousekeepingOpen(0,0,null);
		FileOutputStream outputStream=new FileOutputStream(filePdf);
		safetyHousekeepingReport.createHousekeepingOpenReport(housekeepings, outputStream);
		outputStream.close();
	}
}

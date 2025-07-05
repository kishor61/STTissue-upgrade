/**
 *Feb 4, 2015
 *FrpProjectionAutoMailer.java
 * TODO
 *com.st.frpprojection.automailer
 *FrpProjectionAutoMailer.java
 *Sunil Singh Bora
 */
package com.st.frpprojectionJon.automailer;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import jakarta.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Component;

import com.st.common.FrpCommon;
import com.st.frpprojection.service.FrpProjectionService;

/**
 * @author sbora
 *
 */
@Component
public class FrpProjectionJonAutoMailer {
private static final Logger logger=LoggerFactory.getLogger(FrpProjectionJonAutoMailer.class);
	
	private SimpleDateFormat dateFormat=new SimpleDateFormat("MM-dd-yyyy");
	private SimpleDateFormat dateTimeFormat=new SimpleDateFormat("MM-dd-yyyy h:mm a");
	
	private SimpleDateFormat dateTimeFormat4=new SimpleDateFormat("yyyy-MM-dd");
	//Code Ends Here Done By Roshan Tailor :- 06/27/2015
	
	@Autowired
	private JavaMailSender mailSender;

	@Autowired
	private FrpProjectionService frpProjectionService;
	
	
	@Value("${mail.to.frpprojection}")
	private String emailTo;
	
	@Value("${mail.bcc}")
	private String emailBcc;
	
	@Value("${mail.from}")
	private String emailFrom;
	
	@Value("${mail.fromname}")
	private String emailFromName;
	
	@Value("${mail.to.error}")
	private String emailToError;
	
	
	public void sendProjectionReminderMail(){
		final Calendar calendar=Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		calendar.add(Calendar.DATE, 4);
		
		final List<Map<String, Object>> maps=frpProjectionService.getProjectionReminder(calendar.getTime());
		
		if(!maps.isEmpty()){
			try {
				mailSender.send(new MimeMessagePreparator(){

					@Override
					public void prepare(MimeMessage mimeMessage) throws Exception {
						MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage,true);
						messageHelper.setTo(emailTo.split(";"));
						messageHelper.setFrom(emailFrom,emailFromName);
						messageHelper.setBcc(emailBcc.split(";")); 
						messageHelper.setSubject(dateTimeFormat4.format(new Date())+"-STT-FRP Projection - Reminder");
						
						
						StringBuilder builder=new StringBuilder();
						builder.append("Dear Sir,<br>");

						for (Map<String, Object> map : maps) {
							builder.append("FRP Projection moving to "+FrpCommon.getGrade().get(map.get("TYPE"))+" on "+dateFormat.format(calendar.getTime())+"</b>");
						}
						
						builder.append("<br/><br/>Thanks,<br/> Jaipur<br><p style='font-size: 12px;'>*** This is an automatically system generated email at:"+dateTimeFormat.format(new Date())+" ***</p>");
						
						messageHelper.setText(builder.toString()+"", true);
						
					}
				});
					
			} catch (Exception e) {
				logger.error("Fail to send Projection reminder mail...."+ e.getMessage());
			}
		}
	}
}

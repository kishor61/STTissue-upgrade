/**
 *Mar 29, 2018
 *IncidentalMailer.java
 * TODO
 *com.st.incidental.mailer
 *IncidentalMailer.java
 *Roshan Lal Tailor
 */
package com.st.incidental.mailer;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;

import jakarta.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Component;

import com.st.incidental.model.Incidental;

/**
 * @author roshan
 *
 */
@Component
public class IncidentalMailer {

	/**
	 * @param auditor
	 */
	@Autowired
	private JavaMailSender mailSender;
	
	@Value("${mail.to.higherauthority}")
	private String emailTofrpoperatorentry;
	
	@Value("${mail.bcc.higherauthority}")
	private String emailBcc;
	
	@Value("${mail.from}")
	private String emailFrom;

	@Value("${mail.fromname}")
	private String emailFromName;
	
	@Value("${mail.to.error}")
	private String emailToError;
	
	private SimpleDateFormat dateTimeFormat = new SimpleDateFormat("MM-dd-yyyy h:mm a");
	private SimpleDateFormat dateFormat=new SimpleDateFormat("MM-dd-yyyy");
	
	public void sendMailToAuditores(final Incidental auditor, final String[] finalEmail, final int id, final String description, final String subjectLine) {
		
		mailSender.send(new MimeMessagePreparator(){

			@Override
			public void prepare(MimeMessage mimeMessage) throws Exception {
				MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage,true);
				messageHelper.setTo(finalEmail);
				messageHelper.setReplyTo("susan.hudgins@sttissuellc.com");
				messageHelper.setFrom(emailFrom,emailFromName);
				messageHelper.setBcc(emailBcc.split(";"));
				
				//messageHelper.setSubject(dateFormat.format(new Date())+"-STT-Incidental Document Uploaded");
				messageHelper.setSubject(subjectLine);
				
				messageHelper.setText(getMessage(auditor), true);
				
			}

			private String getMessage(Incidental auditor) {
				StringBuilder builder=new StringBuilder();
				builder.append("<table bgcolor='#f5f5f5' width='100%' border='0' cellspacing='0' cellpadding='0' style='mso-table-lspace: 0pt;mso-table-rspace: 0pt;padding-top: 30px;'>"
						+ "<tbody>"
						+ "<tr>"
						+ "<td>"
						+ "<table align='center' border='0' cellpadding='0' cellspacing='0' width='600' style='margin: auto;mso-table-lspace: 0pt;mso-table-rspace: 0pt;'>"
						+ "<tbody>"
						+ "<tr>"
						+ "<td>"
						+ "<table border='0' cellpadding='0' cellspacing='0' width='100%' style='background-color: #fff;border-left: 1px solid #e3e3e3;border-right: 1px solid #e3e3e3;border-top: 1px solid #e3e3e3;mso-table-lspace: 0pt;mso-table-rspace: 0pt;'>"
						+ "<tbody>"
						+ "<tr>"
						+ "<td align='center' style='padding: 20px; ' valign='middle'>"
						+ "<img src='http://www.stpaperllc.com/images/stPaperTissuelogo.gif' style='width: 200px;'>"
						+ "</td>"
						+ "</tr>"
						+ "<tr>"
						+ "<td align='center' cellpadding='0' style='padding: 0px; text-align: center;' valign='middle' width='100%' bgcolor='#397C88'>"
						+ "<table border='0' width='100%' style='mso-table-lspace: 0pt;mso-table-rspace: 0pt;'>"
						+ "<tbody>"
						+ "<tr>"
						+ "<td style='padding:20px 20px 20px 30px;' width='70px;'></td>"
						+ "<td style='padding:20px 20px 20px 0; font-family:Arial, Helvetica, sans-serif; color:#fff; text-align:left' width='100%'>"
						+ "<span style='font-size:16px; font-weight:bold'>"
						+ "</span>"
						+ "<br>"
						+ "<span style='font-size:14px; font-weight:bold; line-height: 24px'>Incidental Document Uploaded</span>"
						+ "</td>"
						+ "</tr>"
						+ "</tbody>"
						+ "</table>"
						+ "</td>"
						+ "</tr>"
						+ "</tbody>"
						+ "</table>"
						+ "<table width='100%' align='center' cellpadding='0' cellspacing='0' style='mso-table-lspace: 0pt;mso-table-rspace: 0pt;'>"
						+ "<tbody>"
						+ "<tr>"
						+ "<td align='center' style='max-width: 600px; background-color:white; padding: 0 30px; border-left: 1px solid #e3e3e3; border-right: 1px solid #e3e3e3; border-bottom: 1px solid #e3e3e3'>"
						+ "<table cellpadding='0' cellspacing='0' border='0' width='100%' style='mso-table-lspace: 0pt;mso-table-rspace: 0pt;'>"
						+ "<tbody>"
						+ "<tr>"
						+ "<td align='center' valign='top' style='padding: 20px 0 10px 0; font-family: Arial, Helvetica, sans-serif; font-size: 16px; line-height: 24px; color: #666; '>"
						+ "<p style=' margin: 0 0 16px; text-align: left; font: normal 12px/20px Arial, Helvetica, sans-serif;'>Hello,</p>"
						+ "<div style=' margin: 10px 0 10px; text-align: left; font: normal 12px/20px Arial, Helvetica, sans-serif;'>A new <b>Incidental Document</b> has been uploaded.Please have a look on it via ST Tissue Application or click on 'Download Attachment' to download the attachment.</div>"
						+ "</td>"
						+ "</tr>"
						
						+ "<tr>"
						+ "<b><p style=' margin: 0 0 16px; text-align: left; font: normal 16px/22px Arial, Helvetica, sans-serif;'>Document Description:</p></b><p style='font-size: 12px;'>"+description+"</p>"
						+ "</tr>"

						+ "<tr>"
						+ "<td align='center' valign='top' style='padding: 20px 60px; background-color: #e3e3e3; font-family: Arial, Helvetica, sans-serif; font-size: 24px; line-height: 24px; color: #333; font-weight: 600;'>");
						
						InetAddress ipAddr = null;
						try {
							ipAddr = InetAddress.getLocalHost();
						} catch (UnknownHostException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						System.out.println();
						
						if(ipAddr.getHostAddress().equalsIgnoreCase("172.16.5.54")){
							builder.append("<a href='192.168.80.5:8089/BTSQR/incidentaluser/view/data/downloadfile/"+id+"' target='_blank'>Download Attachment</a>");
						}else{
							builder.append("<a href='192.168.80.5:8080/BTSQR/incidentaluser/view/data/downloadfile/"+id+"' target='_blank'>Download Attachment</a>");
						}
						builder.append("</td>"
						+ "</tr>"
						+ "<tr>"
						+ "<td align='center' valign='top' style='padding: 30px 0 40px 0; font-family: Arial, Helvetica, sans-serif; font-size: 16px; line-height: 24px; color: #666; '>"
						+ "<div style='text-align: left; font: normal 12px/20px Arial, Helvetica, sans-serif; color: #666;'>"
						+ "If you got this email by mistake, just ignore it.<br> "
						+ "<br>Thanks, "
						+ "<br>Susan Hudgins"
						+ "<br>Administrative Assistant/HR"
						+ "<br>ST Tissue, LLC"
						+ "<br>34050 Union Camp Drive"
						+ "<br>Franklin, VA 23851"
						+ "<br>757-304-5040"
						+ "<br>757-304-5059 (fax)"
						+ "<br>"
						+ "<br><p style='font-size: 12px;'>*** This is an automatically system generated email at:" + dateTimeFormat.format(new Date()) + " ***</p>"
						+ "</div>"
						+ "</td>"
						+ "</tr>"
						+ "</tbody>"
						+ "</table>"
						+ "</td>"
						+ "</tr>"
						+ "</tbody>"
						+ "</table>"
						+ "<table align='center' border='0' cellpadding='0' cellspacing='0' width='100%' style='mso-table-lspace: 0pt;mso-table-rspace: 0pt;'>"
						+ "<tbody>"
						+ "<tr>"
						+ "<td style='text-align: center;text-align: center; padding: 20px 30px 40px 30px;font-family: arial, sans-serif; font-size: 12px; line-height: 18px;color: #999;'>"
						+ "<div>You are receiving this email because you expressed interest in <b>Incidental Uploaded Document(s)</b>.</div>"
						+ "</td>"
						+ "</tr>"
						+ "</tbody>"
						+ "</table>"
						+ "</td>"
						+ "</tr>"
						+ "</tbody>"
						+ "</table>"
						+ "</td>"
						+ "</tr>"
						+ "</tbody>"
						+ "</table>");
				builder.append("<br/><p style='color: white;'>Roshan Tailor</p><br/>");
				return builder.toString();
			}});
		
		
		
	}

}

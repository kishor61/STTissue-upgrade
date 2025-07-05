/**
 *Dec 7, 2016
 *HigherAutorityDecisionMailer.java
 * TODO
 *com.st.higherauthoritydecision.mailer
 *HigherAutorityDecisionMailer.java
 *Roshan Lal Tailor
 */
package com.st.higherauthoritydecision.mailer;

import jakarta.mail.internet.MimeMessage;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Component;

/**
 * @author roshan
 *
 */
@Component
public class HigherAutorityDecisionMailer {

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
	
	/**
	 * @param string
	 * @param otp
	 */
	public void getPermissionAndMail(final String status, final String otp) {
		
		mailSender.send(new MimeMessagePreparator(){

			@Override
			public void prepare(MimeMessage mimeMessage) throws Exception {
				MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage,true);
				messageHelper.setTo(emailTofrpoperatorentry.split(";"));
				messageHelper.setFrom(emailFrom,emailFromName);
				messageHelper.setBcc(emailBcc.split(";"));
				if(status.equalsIgnoreCase("Block")){
					messageHelper.setSubject("ST Tissue - OTP For Blocking  Auto Mail Firing");
				}else{
					messageHelper.setSubject("ST Tissue - OTP For Allowing Auto Mail Firing");
				}
				messageHelper.setText(getMessage(status,otp), true);
				
			}

			private String getMessage(String status, String otp) {
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
						+ "<span style='font-size:14px; font-weight:bold; line-height: 24px'>One Time Password</span>"
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
						+ "<p style=' margin: 0 0 16px; text-align: left; font: normal 16px/24px Arial, Helvetica, sans-serif;'>Hi Ajay / Roshan,</p>"
						+ "<div style=' margin: 10px 0 10px; text-align: left; font: normal 16px/24px Arial, Helvetica, sans-serif;'> Here is your six-digit security code:</div>"
						+ "</td>"
						+ "</tr>"
						+ "<tr>"
						+ "<td align='center' valign='top' style='padding: 20px 60px; background-color: #e3e3e3; font-family: Arial, Helvetica, sans-serif; font-size: 24px; line-height: 24px; color: #333; font-weight: 600;'>"+otp+"</td>"
						+ "</tr>"
						+ "<tr>"
						+ "<td align='center' valign='top' style='padding: 30px 0 40px 0; font-family: Arial, Helvetica, sans-serif; font-size: 16px; line-height: 24px; color: #666; '>"
						+ "<div style='text-align: left; font: normal 16px/24px Arial, Helvetica, sans-serif; color: #666;'>To continue <b>"+status+"</b>, please return to the page you were on and enter this code."
						+ "<br>"
						+ "<br>If you got this email by mistake, just ignore it. Our Application is safe with us! "
						+ "<br>"
						+ "<br>Thanks, "
						+ "<br>S.E.Roshan"
						+ "<br>Development Team "
						+ "<br>Jaipur "
						+ "<br>"
						//+ "<a href='//www.rediffmail.com/cgi-bin/red.cgi?red=http://Aakritivan.com&amp;isImage=0&amp;BlockImage=0&amp;rediffng=0&amp;rdf=V3AAbVImVDlTb1dtVisCZVU3UWM%3D&amp;rogue=7aad2875669754da315d3b4b3382801c9ab0f9a0' target='_blank' rel='external'>Aakritivan.com</a> Team"
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
						+ "<div>You are receiving this email because you expressed interest to <b>"+status+"</b> the auto firing mails of ST Tissue Application.</div>"
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

	/**
	 * @param status
	 */
	public void getInformToTechnicalTeam(final String status) {
		
		mailSender.send(new MimeMessagePreparator(){

			@Override
			public void prepare(MimeMessage mimeMessage) throws Exception {
				MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage,true);
				messageHelper.setTo(emailTofrpoperatorentry.split(";"));
				messageHelper.setFrom(emailFrom,emailFromName);
				messageHelper.setBcc(emailBcc.split(";"));
				if(status.equalsIgnoreCase("Block")){
					messageHelper.setSubject("ST Tissue - Auto Mail Firing Are Blocked");
				}else{
					messageHelper.setSubject("ST Tissue - Auto Mail Firing Are Running");
				}
				messageHelper.setText(getMessage(status), true);
				
			}

			private String getMessage(String status) {
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
						+ "<span style='font-size:14px; font-weight:bold; line-height: 24px'>Auto Mail Firing Status</span>"
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
						+ "<p style=' margin: 0 0 16px; text-align: left; font: normal 16px/24px Arial, Helvetica, sans-serif;'>Hello Team,,</p>"
						
						+ "</td>"
						+ "</tr>"
						+ "<tr>"
						+ "<td align='center' valign='top' style='padding: 30px 0 40px 0; font-family: Arial, Helvetica, sans-serif; font-size: 16px; line-height: 24px; color: #666; '>"
						+ "<div style='text-align: left; font: normal 16px/24px Arial, Helvetica, sans-serif; color: #666;'>ST Tissue Application Auto Mail Firing Are Now <b>"+status+"</b>."
						+ "<div style='text-align: left; font: normal 16px/24px Arial, Helvetica, sans-serif; color: #666;'>For Any Information Please Contact To Development Team.</b>."
						+ "<br>"
						+ "<br>If you got this email by mistake, just ignore it. Our Application is safe with us! "
						+ "<br>"
						+ "<br>Thanks, "
						+ "<br>S.E.Roshan"	
						+ "<br>Development Team "
						+ "<br>Jaipur "
						+ "<br>"
						//+ "<a href='//www.rediffmail.com/cgi-bin/red.cgi?red=http://Aakritivan.com&amp;isImage=0&amp;BlockImage=0&amp;rediffng=0&amp;rdf=V3AAbVImVDlTb1dtVisCZVU3UWM%3D&amp;rogue=7aad2875669754da315d3b4b3382801c9ab0f9a0' target='_blank' rel='external'>Aakritivan.com</a> Team"
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
						+ "<div>You are receiving this email because you expressed interest to <b>"+status+"</b> the auto firing mails of ST Tissue Application.</div>"
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

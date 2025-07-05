/**
 *Oct 30, 2019
 *ObccPM5ReportingMailer.java
 * TODO
 *com.st.obccPM5.mailer
 *ObccPM5ReportingMailer.java
 *Roshan Lal Tailor
 */
package com.st.obccPM5.mailer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
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

import com.st.obccPM5.model.R2OperatorPM5;
import com.st.obccPM5.report.handler.Obcc1PM5pdfReportHandler;
import com.st.obccPM5.service.R2OperatorPM5Service;
import com.st.production.automailer.ProductionReportAutoMailer;

/**
 * @author sohan
 *
 */
@Component
public class ObccPM5ReportingMailer {
	
	@Autowired
	private R2OperatorPM5Service r2operatorpm5service;
	@Autowired
	private Obcc1PM5pdfReportHandler obccpm5PdfReportHandler;
	
	@Autowired
	private JavaMailSender mailSender;
	
	@Value("${mail.to.machinebreakfreepercentage}")
	private String emailTomachinebreakfreepercentage;
	
	@Value("${mail.bcc}")
	private String emailBcc;
	
	@Value("${mail.from}")
	private String emailFrom;

	@Value("${mail.fromname}")
	private String emailFromName;

	private static final Logger logger = LoggerFactory.getLogger(ProductionReportAutoMailer.class);
	private SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
	private SimpleDateFormat dateTimeFormat = new SimpleDateFormat("MM-dd-yyyy h:mm a");
	private SimpleDateFormat dateTimeFormat4 = new SimpleDateFormat("yyyy-MM-dd");
	private SimpleDateFormat format = new SimpleDateFormat("MM-dd-yyyy");
	
	
	
	/**
	 * @param position
	 * @param sdate
	 * @param edate
	 * @throws Exception 
	 */
	public void getOBCCR2ReportingMail(String position, String sdate,String edate) throws Exception {
		String folder=System.getProperty("catalina.base")+"/OBCC_R2_Reporting_Mail_PM6_Roshan Tailor";
		File folderFile=new File(folder);
		if(!folderFile.exists()){
			folderFile.mkdirs();
		}
		
		
		final File filePdf=new File(folder,"OBCC R2 Operator - Report"+".pdf");
		final int  i = prepareDetailedReportDocumentR2(filePdf,sdate,edate,position);
		mailSender.send(new MimeMessagePreparator(){

			@Override
			public void prepare(MimeMessage mimeMessage) throws Exception {
				MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage,true);
				messageHelper.setTo(emailTomachinebreakfreepercentage.split(";"));
				messageHelper.setFrom(emailFrom,emailFromName);
				messageHelper.setBcc(emailBcc.split(";"));
				
				Calendar cal = Calendar.getInstance();
				cal.add(Calendar.DATE, -1);
				
				messageHelper.setSubject(dateTimeFormat4.format(cal.getTime())+"-PM6-OBCC R2 Operator - Report");
				
				messageHelper.setText(getMessage(), true);
				if(i!=0){
					messageHelper.addAttachment(dateTimeFormat4.format(cal.getTime())+"-OBCC R2 Operator - Report.pdf", new ByteArrayResource(IOUtils.toByteArray(new FileInputStream(filePdf))));
				}
				logger.info("ST Tissue OBCC R2 Operator - Report mail is sent");
			}

			private String getMessage() {
				StringBuilder builder=new StringBuilder();
				builder.append("Hello Sir,<br/><br/>");
				builder.append("Please find the attached <b>\"ST Tissue OBCC R2 Operator - Report Of PM6\"</b> for your review.<br/>");
				if(i==0){
					builder.append("<br/><p style='color: red;font-size: 15px;'>We Are Unable To Generate The Report.<br>Either Data Not Found Or Application in Under Maintenance.</p><br/>");
				}
				builder.append("<br/>Thank you,<br/>");
				builder.append("Jaipur<br/><p style='font-size: 12px;'>*** This is an automatically system generated email at:"+dateTimeFormat.format(new Date())+" ***</p>");
				builder.append("<br/><p style='color: white;'>Roshan Tailor</p><br/>");
				
				return builder.toString();
			}});
		
		
		
	}
	
	/**
	 * @param filePdf
	 * @param sdate
	 * @param edate
	 * @param position
	 * @return
	 * @throws Exception 
	 */
	private int prepareDetailedReportDocumentR2(File filePdf, String sdate,
			String edate, String position) throws Exception {
		
		List<R2OperatorPM5> datas  = r2operatorpm5service.getOperatorDataList(position, sdate, edate);
		long l =  r2operatorpm5service.getDataCountDatePercentage(position, sdate, sdate,"both");
		if(datas.size() !=0)
		{
			FileOutputStream outputStream=new FileOutputStream(filePdf);
			obccpm5PdfReportHandler.createR2Pdf(datas,outputStream,l);
			outputStream.close();
			return 1;
		}
		else
		{
			return 0;
		}
			
		
		
	}

}

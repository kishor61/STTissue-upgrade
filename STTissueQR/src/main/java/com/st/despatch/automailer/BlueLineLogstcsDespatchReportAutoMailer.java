/**
 *Aug 27, 2021
 *NewDespatchAutoMailer.java
 * TODO
 *com.st.despatch.automailer
 *NewDespatchAutoMailer.java
 *Sohan Lal 
 */
package com.st.despatch.automailer;

/**
 * @author Sohanlal
 *
 */

	import java.io.File;
	import java.io.FileInputStream;
	import java.io.FileOutputStream;
	import java.io.IOException;	
	import java.text.SimpleDateFormat;
	
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
	import org.springframework.scheduling.annotation.Scheduled;
	import org.springframework.stereotype.Component;

	import com.st.common.CommonUtil;	
	import com.st.despatch.model.Despatch;
	import com.st.despatch.report.NewDespatchReportHandler;
	import com.st.despatch.service.DespatchService;
	
	
	@Component
	public class BlueLineLogstcsDespatchReportAutoMailer {

		private static final Logger logger = LoggerFactory.getLogger(BlueLineLogstcsDespatchReportAutoMailer.class);
		private SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
		private SimpleDateFormat dateTimeFormat = new SimpleDateFormat("MM-dd-yyyy h:mm a");
		
		
		
		@Autowired
		private JavaMailSender mailSender;
		@Autowired
		private DespatchService despatchService;		
		@Autowired
		private NewDespatchReportHandler despatchReportHandler;
		
		@Value("${mail.blueLinedespatchreport.to}")
		private String emailTo;
		
		@Value("${mail.blueLinedespatchreport.bcc}")
		private String emailBcc;		
		

		@Value("${mail.from}")
		private String emailFrom;

		@Value("${mail.fromname}")
		private String emailFromName;

		public void sendDespatchMail(final Date sdate, final String carrierId) throws IOException {
			String folder = System.getProperty("catalina.base")
					+ "/Despatch";
			File folderFile = new File(folder);
			if (!folderFile.exists()) {
				folderFile.mkdirs();
			}

			final File xlsfile = new File(folder, "Despatch" + ".xlsx");

			if(carrierId.equalsIgnoreCase("BL")){
				prepareGAHDocument(xlsfile, sdate);
			}
			

			mailSender.send(new MimeMessagePreparator() {

				@Override
				public void prepare(MimeMessage mimeMessage) throws Exception {
					MimeMessageHelper messageHelper = new MimeMessageHelper(
							mimeMessage, true);
					if(carrierId.equalsIgnoreCase("BL")){
						messageHelper.setTo(emailTo.split(";"));
					}
					
					messageHelper.setFrom(emailFrom, emailFromName);
					messageHelper.setReplyTo("Joan.Wilson@stpaperllc.com");
					
					if(carrierId.equalsIgnoreCase("BL")){
						messageHelper.setBcc(emailBcc.split(";"));
					}

					
					messageHelper.setSubject(dateFormat.format(new Date())
							+ "-STT-Blue Line Logstcs -Despatch Report");
					messageHelper.setText(getMessage(), true);
					if (xlsfile.exists()) {
						messageHelper.addAttachment(
								dateFormat.format(new Date())
										+ "-STT-Despatch Report.xlsx",
								new ByteArrayResource(IOUtils
										.toByteArray(new FileInputStream(xlsfile))));
					}
					logger.info("ST Tissue Despatch reports mail is sent");
				}

				private String getMessage() {
					StringBuilder builder = new StringBuilder();
					builder.append("Hello Sir,<br/><br/>");
					builder.append("Please find the attached <b>\"ST Tissue Despatch Report\"</b> for your review.<br/>");
					builder.append("<br/>Thank you,<br/>");
					builder.append("Jaipur<br/><p style='font-size: 12px;'>*** This is an automatically system generated email at:"
							+ dateTimeFormat.format(new Date()) + " ***</p>");

					return builder.toString();
				}
			});

		}
		
		/**
		 * @param xlsfile
		 * @param sdate
		 * @throws IOException 
		 */
		private void prepareGAHDocument(File xlsfile, Date sdate) throws IOException {
			
			String date=dateFormat.format(sdate);
			
			Date sDate=CommonUtil.checkDate(date, dateFormat);
			
			List<Despatch> datas=despatchService.getDespatchData(sDate,"BL");
			
			//List<Despatch> datas_Temp=despatchService.getDespatchData_Temp();
			
			FileOutputStream outputStream = new FileOutputStream(xlsfile);

			//despatchReportHandler.createExcelDespatchReport(datas,datas_Temp,outputStream);
			String tblName="newtbldispatch_temp";
			despatchReportHandler.createExcelDespatchReport(datas,tblName,outputStream);

			outputStream.close();

		}
		
		
}

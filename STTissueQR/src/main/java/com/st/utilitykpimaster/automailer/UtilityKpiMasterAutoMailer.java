/**
 *Dec 5, 2014
 *UtilityKpiMasterAutoMailer.java
 * TODO
 *com.st.utilitykpimaster.automailer
 *UtilityKpiMasterAutoMailer.java
 *Sunil Singh Bora
 */
package com.st.utilitykpimaster.automailer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

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

import com.st.common.CommonUtil;
import com.st.utilitykpimaster.model.KpiRecordableDate;
import com.st.utilitykpimaster.model.MasterData;
import com.st.utilitykpimaster.report.UtilityKpiMasterReportHandler;
import com.st.utilitykpimaster.service.KpiRecordableDateService;
import com.st.utilitykpimaster.service.MasterDataService;

/**
 * @author sbora
 *
 */
@Component
public class UtilityKpiMasterAutoMailer {
	
	private static final Logger logger=LoggerFactory.getLogger(UtilityKpiMasterAutoMailer.class);
	private SimpleDateFormat dateTimeFormat=new SimpleDateFormat("MM-dd-yyyy h:mm a");
	
	private SimpleDateFormat dateTimeFormat2=new SimpleDateFormat("yyyy-MM-dd");
	//Code Ends Here Done By Roshan Tailor Date:- 06/27/2015
	
	@Value("${mail.to}")
	private String emailTo;
	

	@Value("${mail.to.kpi.draft}")
	private String emailpkidraftTo;
	
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
	private MasterDataService masterDataService;
	
	@Autowired
	private KpiRecordableDateService kpiRecordableDateService;
	
	@Autowired
	private UtilityKpiMasterReportHandler utilityKpiMasterReportHandler;
	
	
	
	public void sendKPIMail(){
		
		
		mailSender.send(new MimeMessagePreparator() {
			
			@Override
			public void prepare(MimeMessage mimeMessage) throws Exception {
				try {
					
					String folder=System.getProperty("catalina.base")+"/KPI";
					File folderFile=new File(folder);
					if(!folderFile.exists()){
						folderFile.mkdirs();
					}
					
					
					File filePdf=new File(folder,"Daily Kpi"+".pdf");
					
					prepareKPIReport(filePdf);
					
					MimeMessageHelper messageHelper=new MimeMessageHelper(mimeMessage,true);
					messageHelper.setTo(emailTo.split(";"));
					messageHelper.setFrom(emailFrom,emailFromName);
					messageHelper.setBcc(emailBcc.split(";"));
					//messageHelper.setSubject("ST Tissue - Daily KPI "+dateTimeFormat.format(new Date()));
					//Code Starts From Here Done By Roshan Tailor Date :- 06/27/2015
					
					Calendar cal = Calendar.getInstance();
					cal.add(Calendar.DATE, -1);
				//	System.out.println("Yesterday's date = "+ cal.getTime());
					
					messageHelper.setSubject(dateTimeFormat2.format(cal.getTime())+"-STT-PM6-Daily KPI");
					//Code Ends Here Done By Roshan Tailor Date :- 06/27/2015
					messageHelper.setText(getMessageBody(), true);
					
					if(filePdf.exists()){
						logger.info("Sending kpi file as attachment="+filePdf.getName());
						messageHelper.addAttachment(dateTimeFormat2.format(cal.getTime())+"-STT-Daily KPI.pdf", new ByteArrayResource(IOUtils.toByteArray(new FileInputStream(filePdf))));
					}
					
						
				} catch (Exception e) {
					logger.error("Error message in PM6 quality report..."+e.getMessage(),e);
					MimeMessageHelper messageHelper=new MimeMessageHelper(mimeMessage, "UTF-8");
					messageHelper.setTo(emailToError.split(";"));
					messageHelper.setFrom(emailFrom);
					messageHelper.setSubject("Fail to send KPI report.");
					mimeMessage.setContent("Unable to read production data<br>"+e.getMessage(), "text/html");
				}
				

				logger.info("KPI Report message sent....");
			}

			private String getMessageBody() {
				StringBuilder builder=new StringBuilder();
				builder.append("Hello Sir,<br/><br/>");
				builder.append("Please find the attached <b>\"ST Tissue Daily KPI\"</b> for your review.<br/>");
				builder.append("<br/>Thank you,<br/>");
				builder.append("Jaipur<br/><p style='font-size: 12px;'>*** This is an automatically system generated email at:"+dateTimeFormat.format(new Date())+" ***</p>");
				
				return builder.toString();
			}

			
		});
		
	}

	/**
	 * @param filePdf
	 * @throws Exception 
	 */
	private void prepareKPIReport(File filePdf) throws Exception {
		Calendar calendar=Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.add(Calendar.DATE, -1);
		
		List<MasterData> masterDatas=masterDataService.getMasterDatas(CommonUtil.getFirstDate(calendar.getTime()),calendar.getTime());
		List<Map<String, String>> datas=masterDataService.getReportData(masterDatas,"K");
		
		KpiRecordableDate kpiRecordableDate=kpiRecordableDateService.getLastKpiRecordableDate();
		Date recordableDate=null;
		if(kpiRecordableDate!=null){
			recordableDate=kpiRecordableDate.getDate();
		}
		
		FileOutputStream outputStream=new FileOutputStream(filePdf);
		utilityKpiMasterReportHandler.createKpiPdf(datas, recordableDate, calendar.getTime(), outputStream);
		outputStream.close();
		
	}

	/**
	 * 
	 */
	public void sendKPIMail_Draft() {
		
		
		mailSender.send(new MimeMessagePreparator() {
			
			@Override
			public void prepare(MimeMessage mimeMessage) throws Exception {
				try {
					
					String folder=System.getProperty("catalina.base")+"/KPI_PM6_Draft_Roshan";
					File folderFile=new File(folder);
					if(!folderFile.exists()){
						folderFile.mkdirs();
					}
					
					
					File filePdf=new File(folder,"Daily Kpi_Draft"+".pdf");
					
					prepareKPIReport(filePdf);
					
					MimeMessageHelper messageHelper=new MimeMessageHelper(mimeMessage,true);
					messageHelper.setTo(emailpkidraftTo.split(";"));
					messageHelper.setFrom(emailFrom,emailFromName);
					messageHelper.setBcc(emailBcc.split(";"));
					//messageHelper.setSubject("ST Tissue - Daily KPI "+dateTimeFormat.format(new Date()));
					//Code Starts From Here Done By Roshan Tailor Date :- 06/27/2015
					
					Calendar cal = Calendar.getInstance();
					cal.add(Calendar.DATE, -1);
				//	System.out.println("Yesterday's date = "+ cal.getTime());
					
					messageHelper.setSubject(dateTimeFormat2.format(cal.getTime())+"-STT-PM6-Daily KPI Report Draft");
					//Code Ends Here Done By Roshan Tailor Date :- 06/27/2015
					messageHelper.setText(getMessageBody(), true);
					
					if(filePdf.exists()){
						logger.info("Sending kpi file as attachment="+filePdf.getName());
						messageHelper.addAttachment(dateTimeFormat2.format(cal.getTime())+"-STT-Daily KPI_Draft.pdf", new ByteArrayResource(IOUtils.toByteArray(new FileInputStream(filePdf))));
					}
					
						
				} catch (Exception e) {
					logger.error("Error message in PM6 quality report..."+e.getMessage(),e);
					MimeMessageHelper messageHelper=new MimeMessageHelper(mimeMessage, "UTF-8");
					messageHelper.setTo(emailToError.split(";"));
					messageHelper.setFrom(emailFrom);
					messageHelper.setSubject("Fail to send KPI Draft report.");
					mimeMessage.setContent("Unable to read production data<br>"+e.getMessage(), "text/html");
				}
				

				logger.info("KPI Draft Report message sent....");
			}

			private String getMessageBody() {
				StringBuilder builder=new StringBuilder();
				builder.append("Hello Sir,<br/><br/>");
				builder.append("Please find the attached <b>\"ST Tissue Daily KPI Draft\"</b> for your review.<br/>");
				builder.append("<br/>Thank you,<br/>");
				builder.append("Jaipur<br/><p style='font-size: 12px;'>*** This is an automatically system generated email at:"+dateTimeFormat.format(new Date())+" ***</p>");
				
				return builder.toString();
			}

			
		});
		
	}
}

/**
 *Apr 11, 2016
 *FrpProdcutionOperatorDataEntryDetailedReportHandler.java
 * TODO
 *com.st.frpproduction.report
 *FrpProdcutionOperatorDataEntryDetailedReportHandler.java
 *Sunil Singh Bora
 */
package com.st.frpproduction.report;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
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

import com.st.common.CommonUtil;
import com.st.frpproduction.model.FrpProdcutionOperatorDataEntry;
import com.st.frpproduction.service.FrpProdcutionOperatorDataEntryService;
import com.st.production.automailer.ProductionReportAutoMailer;

/**
 * @author sbora
 *
 */
@Component
public class FrpProdcutionOperatorDataEntryDetailedReportHandler {

	private static final Logger logger = LoggerFactory.getLogger(ProductionReportAutoMailer.class);
	private SimpleDateFormat dateTimeFormat = new SimpleDateFormat("MM-dd-yyyy h:mm a");
	private SimpleDateFormat dateTimeFormat4 = new SimpleDateFormat("yyyy-MM-dd");
	
	@Autowired
	private FrpProdcutionOperatorDataEntryService frpprodcutionoperatordataentryservice ;
	
	@Autowired
	private FrpProdcutionOperatorDataEntryDetailedReportGenerator frpprodcutionoperatordataentrydetailedreportgenerator;
	
	@Autowired
	private JavaMailSender mailSender;
	
	@Value("${mail.to.frpoperatorentry}")
	private String emailTofrpoperatorentry;
	
	@Value("${mail.bcc}")
	private String emailBcc;
	
	@Value("${mail.from}")
	private String emailFrom;

	@Value("${mail.fromname}")
	private String emailFromName;
	
	@Value("${mail.to.error}")
	private String emailToError;
	
	/**
	 * @param sDate
	 * @param eDate
	 * @throws IOException 
	 */
	public void sendDetailedReportMailAt8am(final Date sDate,final Date eDate) throws IOException {
		String folder=System.getProperty("catalina.base")+"/FRP Production Operator Data Entry Detailed Report";
		File folderFile=new File(folder);
		if(!folderFile.exists()){
			folderFile.mkdirs();
		}
		
		final File xlsfile=new File(folder,"FRP-MTD Daily Production Report"+".xlsx");
		
		prepareDetailedReportDocument(xlsfile,sDate,eDate);
		mailSender.send(new MimeMessagePreparator(){

			@Override
			public void prepare(MimeMessage mimeMessage) throws Exception {
				MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage,true);
				messageHelper.setTo(emailTofrpoperatorentry.split(";"));
				messageHelper.setFrom(emailFrom,emailFromName);
				messageHelper.setBcc(emailBcc.split(";"));
				
				Calendar cal = Calendar.getInstance();
				cal.add(Calendar.DATE, -1);
				
				messageHelper.setSubject(dateTimeFormat4.format(cal.getTime())+"-FRP-MTD Daily Production - Report");
				
				messageHelper.setText(getMessage(), true);
				if(xlsfile.exists()){
					messageHelper.addAttachment(dateTimeFormat4.format(cal.getTime())+"-FRP-MTD Daily Production Report.xlsx", new ByteArrayResource(IOUtils.toByteArray(new FileInputStream(xlsfile))));
				}
				logger.info("ST Tissue FRP-MTD Daily Production Report mail is sent");
			}

			private String getMessage() {
				StringBuilder builder=new StringBuilder();
				builder.append("Hello Sir,<br/><br/>");
				builder.append("Please find the attached <b>\"ST Tissue FRP-MTD Daily Production Report\"</b> for your review.<br/>");
				builder.append("<br/>Thank you,<br/>");
				builder.append("Jaipur<br/><p style='font-size: 12px;'>*** This is an automatically system generated email at:"+dateTimeFormat.format(new Date())+" ***</p>");
				
				return builder.toString();
			}});
		
		
		
	}

	/**
	 * @param xlsfile
	 * @param eDate2 
	 * @param sDate2 
	 * @throws IOException 
	 */
	private void prepareDetailedReportDocument(File xlsfile, Date sDate2, Date eDate2) throws IOException {
		// TODO Auto-generated method stub
		
		Calendar date1=Calendar.getInstance();
		date1.setTime(sDate2);

		Calendar ecal=Calendar.getInstance();
		ecal.setTime(date1.getTime());
		ecal.set(Calendar.HOUR_OF_DAY, 0);
		ecal.set(Calendar.MINUTE, 0);
		ecal.set(Calendar.SECOND, 0);
		ecal.set(Calendar.MILLISECOND, 0);
		
		Calendar toCal=Calendar.getInstance();
		toCal.setTime(ecal.getTime());
		toCal.add(Calendar.DATE, 0);
		
		//For Last Date
		Calendar date=Calendar.getInstance();
		date.setTime(eDate2);
		
		Calendar scal=Calendar.getInstance();
		scal.setTime(date.getTime());
		scal.set(Calendar.HOUR_OF_DAY, 0);
		scal.set(Calendar.MINUTE, 0);
		scal.set(Calendar.SECOND, 0);
		scal.set(Calendar.MILLISECOND, 0);
		
		Calendar frmCal=Calendar.getInstance();
		frmCal.setTime(scal.getTime());
		frmCal.add(Calendar.DATE, -1);
		
		
		
		List<FrpProdcutionOperatorDataEntry> details=frpprodcutionoperatordataentryservice.getFrpProducationDataEntryDetailedReport(toCal.getTime(),frmCal.getTime());
		
		List<FrpProdcutionOperatorDataEntry> Aavg = frpprodcutionoperatordataentryservice.getcol1avg(toCal.getTime(),frmCal.getTime());
		List<FrpProdcutionOperatorDataEntry> Bavg = frpprodcutionoperatordataentryservice.getcol1avg1(toCal.getTime(),frmCal.getTime());
		List<FrpProdcutionOperatorDataEntry> Cavg = frpprodcutionoperatordataentryservice.getcol1avg2(toCal.getTime(),frmCal.getTime());
		List<FrpProdcutionOperatorDataEntry> Davg = frpprodcutionoperatordataentryservice.getcol1avg3(toCal.getTime(),frmCal.getTime());
		FileOutputStream outputStream=new FileOutputStream(xlsfile);
		frpprodcutionoperatordataentrydetailedreportgenerator.createEfficiencyShiftReport(details,Aavg,Bavg,Cavg,Davg, outputStream);
		outputStream.close();
	}

}

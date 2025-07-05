/**
 *Sep 6, 2016
 *MeahineBreakFreeProductionReportMailer.java
 * TODO
 *com.st.production.report
 *MeahineBreakFreeProductionReportMailer.java
 *Roshan Lal Tailor
 */
package com.st.production.report;

import java.io.File;
import java.io.FileInputStream;
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

import com.st.production.automailer.ProductionReportAutoMailer;
import com.st.production.model.MachineProduction;
import com.st.production.service.MachineProductionSummaryServiceImp;

/**
 * @author roshan
 *
 */
@Component
public class MeahineBreakFreeProductionReportMailer {

	private static final Logger logger = LoggerFactory.getLogger(ProductionReportAutoMailer.class);
	private SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
	private SimpleDateFormat dateTimeFormat = new SimpleDateFormat("MM-dd-yyyy h:mm a");
	private SimpleDateFormat dateTimeFormat4 = new SimpleDateFormat("yyyy-MM-dd");
	
	@Autowired
	private MachineProductionSummaryServiceImp machineproductionsummaryserviceimp;
	
	@Autowired
	private MeahineBreakFreeProductionReportHandler meahinebreakfreeproductionreport;
	
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
	
	@Value("${mail.to.error}")
	private String emailToError;
	
	/**
	 * @param sDate
	 * @param eDate
	 * @param shift
	 * @throws IOException 
	 */
	public void getMachineBreakFreeProductionMail(final Date sDate, final Date eDate,final String shift) throws IOException {
		String folder=System.getProperty("catalina.base")+"/Machine_Production_BreakFree_Percentage_Report_Roshan Tailor";
		File folderFile=new File(folder);
		if(!folderFile.exists()){
			folderFile.mkdirs();
		}
		
		final File xlsfile=new File(folder,"Machine_Production_BreakFree_Percentage_Report"+".xlsx");
		
		prepareDetailedReportDocument(xlsfile,sDate,eDate,shift);
		mailSender.send(new MimeMessagePreparator(){

			@Override
			public void prepare(MimeMessage mimeMessage) throws Exception {
				MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage,true);
				messageHelper.setTo(emailTomachinebreakfreepercentage.split(";"));
				messageHelper.setFrom(emailFrom,emailFromName);
				messageHelper.setBcc(emailBcc.split(";"));
				
				Calendar cal = Calendar.getInstance();
				cal.add(Calendar.DATE, -1);
				
				messageHelper.setSubject(dateTimeFormat4.format(cal.getTime())+"-Machine Production Break Free Percentage - Report");
				
				messageHelper.setText(getMessage(), true);
				if(xlsfile.exists()){
					messageHelper.addAttachment(dateTimeFormat4.format(cal.getTime())+"-Machine_Production_BreakFree_Percentage_Report.xlsx", new ByteArrayResource(IOUtils.toByteArray(new FileInputStream(xlsfile))));
				}
				logger.info("ST Tissue Machine Prodcution Break Free Percentage Report mail is sent");
			}

			private String getMessage() {
				StringBuilder builder=new StringBuilder();
				builder.append("Hello Sir,<br/><br/>");
				builder.append("Please find the attached <b>\"ST Tissue Machine Production Break Free Percentage Report\"</b> for your review.<br/>");
				builder.append("<br/>Thank you,<br/>");
				builder.append("Jaipur<br/><p style='font-size: 12px;'>*** This is an automatically system generated email at:"+dateTimeFormat.format(new Date())+" ***</p>");
				builder.append("<br/><p style='color: white;'>Roshan Tailor</p><br/>");
				
				return builder.toString();
			}});
		
		
		
	}

	/**
	 * @param xlsfile
	 * @param sDate
	 * @param eDate
	 * @param shift
	 * @throws IOException 
	 */
	
	private void prepareDetailedReportDocument(File xlsfile, Date sDate,Date eDate, String shift) throws IOException {
		// TODO Auto-generated method stub
		
		Calendar date1=Calendar.getInstance();
		date1.setTime(sDate);

		Calendar ecal=Calendar.getInstance();
		ecal.setTime(date1.getTime());
		ecal.set(Calendar.HOUR_OF_DAY, 7);
		ecal.set(Calendar.MINUTE, 0);
		ecal.set(Calendar.SECOND, 0);
		ecal.set(Calendar.MILLISECOND, 0);
		
		Calendar toCal=Calendar.getInstance();
		toCal.setTime(ecal.getTime());
		toCal.add(Calendar.DATE, 0);
		
		//For Last Date
		Calendar date=Calendar.getInstance();
		date.setTime(eDate);
		
		Calendar scal=Calendar.getInstance();
		scal.setTime(date.getTime());
		scal.set(Calendar.HOUR_OF_DAY, 6);
		scal.set(Calendar.MINUTE, 59);
		scal.set(Calendar.SECOND, 59);
		scal.set(Calendar.MILLISECOND, 0);
		
		Calendar frmCal=Calendar.getInstance();
		frmCal.setTime(scal.getTime());
		frmCal.add(Calendar.DATE, 1);
		
		
		List<MachineProduction> data=machineproductionsummaryserviceimp.getMachineBreakFreeProduction(toCal.getTime(),frmCal.getTime(),shift);
		
		FileOutputStream outputStream=new FileOutputStream(xlsfile);
		
		meahinebreakfreeproductionreport.createReportAuto(data,outputStream);
		
		outputStream.close();
	}

}

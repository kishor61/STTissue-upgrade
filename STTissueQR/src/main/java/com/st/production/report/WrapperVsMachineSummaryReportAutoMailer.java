/**
 *Jun 16, 2016
 *WrapperVsMachineSummaryReportAutoMailer.java
 * TODO
 *com.st.production.report
 *WrapperVsMachineSummaryReportAutoMailer.java
 *Sunil Singh Bora
 */
package com.st.production.report;

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
import com.st.common.exception.ProductionException;
import com.st.production.automailer.ProductionReportAutoMailer;
import com.st.production.model.MachineAndWrapper;
import com.st.production.service.MachineProductionSummaryService;

/**
 * @author roshan
 *
 */
@Component
public class WrapperVsMachineSummaryReportAutoMailer {

	private static final Logger logger = LoggerFactory.getLogger(ProductionReportAutoMailer.class);
	private SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
	private SimpleDateFormat dateTimeFormat = new SimpleDateFormat("MM-dd-yyyy h:mm a");
	private SimpleDateFormat dateTimeFormat4 = new SimpleDateFormat("yyyy-MM-dd");
	
	@Autowired
	private JavaMailSender mailSender;
	
	@Autowired
	private MachineProductionSummaryService machineproductionsummaryservice;
	
	@Autowired
	private WrapperVsMachineSummaryReportHandler wrapperVsmachinesummaryreporthandler;
	
	
	@Value("${mail.to}")
	private String emailTo;

	@Value("${mail.to.sttreport.cr61}")
	private String emailToSttreportAndCR61;
	
	
	@Value("${mail.to.gradeandhours}")
	private String emailToGradeAndHours;

	@Value("${mail.bcc}")
	private String emailBcc;

	@Value("${mail.from}")
	private String emailFrom;

	@Value("${mail.fromname}")
	private String emailFromName;

	@Value("${mail.to.error}")
	private String emailToError;
	/**
	 * @throws ProductionException 
	 * @throws IOException 
	 * 
	 */
	public void sendMailMachineVsWrapperSummaryReport() throws ProductionException, IOException {
		String folder = System.getProperty("catalina.base")
				+ "/MachineVsWrapperSummaryReport";
		File folderFile = new File(folder);
		if (!folderFile.exists()) {
			folderFile.mkdirs();
		}

		final File xlsfile = new File(folder, "Machine Vs Wrapper Summary Report" + ".xlsx");

		prepareMachineVsWrapperSummaryReport(xlsfile);

		mailSender.send(new MimeMessagePreparator() {

			@Override
			public void prepare(MimeMessage mimeMessage) throws Exception {
				MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true);
				messageHelper.setTo(emailToSttreportAndCR61.split(";"));
				messageHelper.setFrom(emailFrom, emailFromName);
				messageHelper.setBcc(emailBcc.split(";"));

				Date shiftDate = CommonUtil.getShiftDate();

				Calendar sCal = Calendar.getInstance();
				sCal.setTime(shiftDate);
				sCal.set(Calendar.HOUR_OF_DAY, 0);
				sCal.set(Calendar.MINUTE, 0);
				sCal.set(Calendar.SECOND, 0);
				sCal.set(Calendar.MILLISECOND, 0);
				sCal.add(Calendar.DATE, -1);

				messageHelper.setSubject(dateTimeFormat4.format(new Date())+ "-PM6-STT-Machine Vs Wrapper Summary Reports");

				messageHelper.setText(getMessage(), true);
				if (xlsfile.exists()) {
					messageHelper.addAttachment(dateTimeFormat4.format(sCal.getTime())+ "-STT-Machine Vs Wrapper Summary Reports.xlsx",new ByteArrayResource(IOUtils.toByteArray(new FileInputStream(xlsfile))));
				}
				logger.info("ST Tissue Machine Vs Wrapper Summary Reports mail is sent");
			}

			private String getMessage() {
				StringBuilder builder = new StringBuilder();
				builder.append("Hello Sir,<br/><br/>");
				builder.append("Please find the attached <b>\"ST Tissue - Machine Vs Wrapper Summary Report\"</b> for your review.<br/>");
				builder.append("<br/>Thank you,<br/>");
				builder.append("Jaipur<br/><p style='font-size: 12px;'>*** This is an automatically system generated email at:"
						+ dateTimeFormat.format(new Date()) + " ***</p>");

				return builder.toString();
			}
		});
	}
	/**
	 * @param xlsfile
	 * @throws ProductionException 
	 * @throws IOException 
	 */
	private void prepareMachineVsWrapperSummaryReport(File xlsfile) throws ProductionException, IOException {
		Date shiftDate = CommonUtil.getShiftDate();

		Calendar sCal = Calendar.getInstance();
		sCal.setTime(shiftDate);
		sCal.set(Calendar.HOUR_OF_DAY, 0);
		sCal.set(Calendar.MINUTE, 0);
		sCal.set(Calendar.SECOND, 0);
		sCal.set(Calendar.MILLISECOND, 0);
		//sCal.add(Calendar.DATE, -1);
		sCal.add(Calendar.DATE, 0);
		
		Calendar eCal = Calendar.getInstance();
		eCal.setTime(shiftDate);
		eCal.set(Calendar.HOUR_OF_DAY, 0);
		eCal.set(Calendar.MINUTE, 0);
		eCal.set(Calendar.SECOND, 0);
		eCal.set(Calendar.MILLISECOND, 0);
		//eCal.add(Calendar.DATE, -2);
		eCal.add(Calendar.DATE, -1);
		

		
		FileOutputStream outputStream = new FileOutputStream(xlsfile);
		List<MachineAndWrapper> machineAndWrappersSummary=machineproductionsummaryservice.getMachineAndWrapperSummaryReport(eCal.getTime(), sCal.getTime());
		wrapperVsmachinesummaryreporthandler.createMachineAndWrapperSummaryReport(machineAndWrappersSummary,outputStream);
		
		//List<MachineAndWrapper> machineAndWrappers = machineProductionService.getMachineAndWrapper(eCal.getTime(), sCal.getTime());
		//productionPM6ReportHandler.createMachineAndWrapperReport(machineAndWrappers, outputStream);
		outputStream.close();
	}

}

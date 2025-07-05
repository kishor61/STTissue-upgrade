/**
 *Aug 3, 2016
 *GradeAndHourSummaryInAMonthReportAutoMailer.java
 * TODO
 *com.st.production.report
 *GradeAndHourSummaryInAMonthReportAutoMailer.java
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
import com.st.common.exception.ProductionException;
import com.st.production.automailer.ProductionReportAutoMailer;
import com.st.production.model.MachineAndWrapper;
import com.st.production.service.WrapperProductionService;

/**
 * @author roshan
 *
 */
@Component
public class GradeAndHourSummaryInAMonthReportAutoMailer {



	private static final Logger logger = LoggerFactory.getLogger(ProductionReportAutoMailer.class);
	private SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
	private SimpleDateFormat dateTimeFormat = new SimpleDateFormat("MM-dd-yyyy h:mm a");
	private SimpleDateFormat dateTimeFormat4 = new SimpleDateFormat("yyyy-MM-dd");
	
	@Autowired
	private JavaMailSender mailSender;
	
	@Value("${mail.to.gradeandhoursummaryinamonthreport}")
	private String emailTobill;
	
	@Value("${mail.bcc}")
	private String emailBcc;
	
	@Value("${mail.from}")
	private String emailFrom;

	@Value("${mail.fromname}")
	private String emailFromName;
	
	@Value("${mail.to.error}")
	private String emailToError;
	/**
	 * 
	 */
	@Autowired
	private WrapperProductionService wrapperProductionService;
	
	@Autowired
	private ProductionReportHandler productionReportHandler;
	
	public void sendMailGradeAndHourSummaryInAMonth() throws ProductionException, IOException {
		String folder = System.getProperty("catalina.base")
				+ "/GradeAndHourSummaryInAMonthReport_Roshan";
		File folderFile = new File(folder);
		if (!folderFile.exists()) {
			folderFile.mkdirs();
		}

		final File xlsfile = new File(folder, "Grade And Hours Summary Report_Tons Per Day" + ".xlsx");

		prepareGradeAndHourSummaryInAMonthReport(xlsfile);

		mailSender.send(new MimeMessagePreparator() {

			@Override
			public void prepare(MimeMessage mimeMessage) throws Exception {
				MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true);
				messageHelper.setTo(emailTobill.split(";"));
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

				messageHelper.setSubject(dateTimeFormat4.format(new Date())+ "-STT-Grade And Hours Summary Report-Tons Per Day");

				messageHelper.setText(getMessage(), true);
				if (xlsfile.exists()) {
					messageHelper.addAttachment(dateTimeFormat4.format(sCal.getTime())+ "-STT-Grade And Hours Summary Report_Tons Per Day.xlsx",new ByteArrayResource(IOUtils.toByteArray(new FileInputStream(xlsfile))));
				}
				logger.info("ST Tissue Grade And Hours Summary Report mail is sent");
			}

			private String getMessage() throws ProductionException {
				StringBuilder builder = new StringBuilder();
				builder.append("Hello Sir,<br/><br/>");
				builder.append("Please find the attached <b>\"ST Tissue - Grade And Hours Summary Report_Tons Per Day \"</b> for your review.<br/>");
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
	private void prepareGradeAndHourSummaryInAMonthReport(File xlsfile) throws ProductionException, IOException {
		Calendar scal = Calendar.getInstance();
		// add -1 month to current month
		scal.add(Calendar.MONTH, -1);
		// set DATE to 1, so first date of previous month
		scal.set(Calendar.DATE, 1);
		scal.set(Calendar.HOUR_OF_DAY, 7);
		scal.set(Calendar.MINUTE, 0);
		scal.set(Calendar.SECOND, 0);
		scal.set(Calendar.MILLISECOND, 0);
		
		Calendar ecal = Calendar.getInstance();
		// set actual maximum date of previous month
		ecal.set(Calendar.DATE,ecal.getActualMaximum(Calendar.DAY_OF_MONTH));
		ecal.set(Calendar.HOUR_OF_DAY, 6);
		ecal.set(Calendar.MINUTE, 59);
		ecal.set(Calendar.SECOND, 59);
		ecal.set(Calendar.MILLISECOND, 0);
		ecal.add(Calendar.DATE, 1);
		
		/*Calendar aCalendar = Calendar.getInstance();
		// add -1 month to current month
		aCalendar.add(Calendar.MONTH, -1);
		// set DATE to 1, so first date of previous month
		aCalendar.set(Calendar.DATE, 1);

		Date firstDateOfPreviousMonth = aCalendar.getTime();

		// set actual maximum date of previous month
		aCalendar.set(Calendar.DATE,aCalendar.getActualMaximum(Calendar.DAY_OF_MONTH));
		//read it
		Date lastDateOfPreviousMonth = aCalendar.getTime();*/
		
		
		FileOutputStream outputStream = new FileOutputStream(xlsfile);
		
		/*List<Map<String, Object>> datas=wrapperProductionService.getGradeAndHourData(CommonUtil.checkDate(scal.getTime(), dateFormat),CommonUtil.checkDate(edate, dateFormat));*/
		List<Map<String, Object>> datas=wrapperProductionService.getGradeAndHourData(scal.getTime(),ecal.getTime());
		productionReportHandler.createExcelGradeAndHoursWithSummaryReport(datas, outputStream);
		
		outputStream.close();
	}

}

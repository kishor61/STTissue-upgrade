/**
 *Jan 12, 2018
 *DespatchAutoMailer.java
 * TODO
 *com.st.despatch.automailer
 *DespatchAutoMailer.java
 *Roshan Lal Tailor
 */
package com.st.despatch.automailer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import jakarta.mail.internet.MimeMessage;
import jakarta.servlet.ServletContext;
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

import com.st.certificate.model.Rewdinder;
import com.st.certificate.report.CertificateReportHandler;
import com.st.certificate.service.CertificateAnalysisService;
import com.st.common.CommonUtil;
import com.st.despatch.model.Despatch;
import com.st.despatch.report.DespatchReportHandler;
import com.st.despatch.service.DespatchService;

@Component
public class DespatchAutoMailer {

	private static final Logger logger = LoggerFactory.getLogger(DespatchAutoMailer.class);
	private SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
	private SimpleDateFormat dateTimeFormat = new SimpleDateFormat("MM-dd-yyyy h:mm a");

	@Autowired
	private ServletContext context;

	@Autowired
	private JavaMailSender mailSender;

	@Autowired
	private DespatchService despatchService;

	@Autowired
	private CertificateAnalysisService certificateAnalysisService;

	@Autowired
	private CertificateReportHandler certificateReport;

	@Autowired
	private DespatchReportHandler despatchReportHandler;

	@Value("${mail.despatchreport.to}")
	private String emailTo;

	@Value("${mail.coaweekly.to}")
	private String emailToCoa;

	@Value("${mail.despatchreport.bcc}")
	private String emailBcc;

	@Value("${mail.despatchreportwh.to}")
	private String emailToWH;

	@Value("${mail.despatchreportwh.bcc}")
	private String emailBccWH;
	
	@Value("${mail.despatchreportry.to}")
	private String emailToRY;

	@Value("${mail.despatchreportry.bcc}")
	private String emailBccRY;
	
	@Value("${mail.despatchreport.toAmazone}")
	private String emailToAmazone;

	@Value("${mail.despatchreport.amazoneBcc}")
	private String emailAmazonBcc;
	
	@Value("${mail.despatchreport.toecho}")
	private String emailToecho;

	@Value("${mail.despatchreport.echoBcc}")
	private String emailechoBcc;
	
	@Value("${mail.despatchreport.toMT}")
	private String emailToMT;

	@Value("${mail.despatchreport.MTBcc}")
	private String emailMTBcc;
	
	@Value("${mail.despatchreport.toCH_Robinson}")
	private String emailToCH_Robinson;

	@Value("${mail.despatchreport.CH_RobinsonBcc}")
	private String emailCH_RobinsonBcc;
	
	@Value("${mail.despatchreport.toAR}")
	private String emailToAR;

	@Value("${mail.despatchreport.ARBcc}")
	private String emailARBcc;
	
	@Value("${mail.despatchreport.toAV}")
	private String emailToAV;

	@Value("${mail.despatchreport.AVBcc}")
	private String emailAVBcc;
	
	@Value("${mail.despatchreport.toLA}")
	private String emailToLA;

	@Value("${mail.despatchreport.LABcc}")
	private String emailLABcc;
	
	
	@Value("${mail.from}")
	private String emailFrom;

	@Value("${mail.fromname}")
	private String emailFromName;

	@Value("${mail.to.error}")
	private String emailToError;

	/**
	 * @param string
	 * @param checkDate
	 * @throws IOException
	 */
	public void sendDespatchMail(final Date sdate, final String carrierId) throws IOException {
		String folder = System.getProperty("catalina.base") + "/Despatch";
		File folderFile = new File(folder);
		if (!folderFile.exists()) {
			folderFile.mkdirs();
		}

		final File xlsfile = new File(folder, "Despatch" + ".xlsx");

		if (carrierId.equalsIgnoreCase("BN")) {
			prepareGAHDocument(xlsfile, sdate);
		} else if (carrierId.equalsIgnoreCase("WH")) {
			prepareGAHDocumentForWH(xlsfile, sdate);
		} else if (carrierId.equalsIgnoreCase("RY")) {
			prepareGAHDocumentForSM(xlsfile, sdate);
		} else if (carrierId.equalsIgnoreCase("AM")) {
			prepareGAHDocumentForAmazone(xlsfile, sdate);
		}  else if (carrierId.equalsIgnoreCase("EC")) {
			prepareGAHDocumentForEcho(xlsfile, sdate);
		}else if (carrierId.equalsIgnoreCase("MT")) {
			prepareGAHDocumentForMT(xlsfile, sdate);
		}else if (carrierId.equalsIgnoreCase("CH")) {
			prepareGAHDocumentForCH_Robinson(xlsfile, sdate);
		}else if (carrierId.equalsIgnoreCase("AR")) {
			prepareGAHDocumentForAR(xlsfile, sdate);
		}else if (carrierId.equalsIgnoreCase("AV")) {
			prepareGAHDocumentForIF(xlsfile, sdate);
		}else if (carrierId.equalsIgnoreCase("LA")) {
			prepareGAHDocumentForLA(xlsfile, sdate);
		}
		
		
		mailSender.send(new MimeMessagePreparator() {

			@Override
			public void prepare(MimeMessage mimeMessage) throws Exception {
				MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true);
				if (carrierId.equalsIgnoreCase("BN")) {
					messageHelper.setTo(emailTo.split(";"));
				} else if (carrierId.equalsIgnoreCase("WH")) {
					messageHelper.setTo(emailToWH.split(";"));
				} else if (carrierId.equalsIgnoreCase("RY")) {
					messageHelper.setTo(emailToRY.split(";"));
				}else if (carrierId.equalsIgnoreCase("AM")) {
					messageHelper.setTo(emailToAmazone.split(";"));
				}else if (carrierId.equalsIgnoreCase("EC")) {
					messageHelper.setTo(emailToecho.split(";"));
				}else if (carrierId.equalsIgnoreCase("MT")) {
					messageHelper.setTo(emailToMT.split(";"));
				}else if (carrierId.equalsIgnoreCase("CH")) {
					messageHelper.setTo(emailToCH_Robinson.split(";"));
				}else if (carrierId.equalsIgnoreCase("AR")) {
					messageHelper.setTo(emailToAR.split(";"));
				}else if (carrierId.equalsIgnoreCase("AV")) {
					messageHelper.setTo(emailToAV.split(";"));
				}else if (carrierId.equalsIgnoreCase("LA")) {
					messageHelper.setTo(emailToLA.split(";"));
				}

				

				messageHelper.setFrom(emailFrom, emailFromName);
				messageHelper.setReplyTo("Joan.Wilson@stpaperllc.com");
				String subTitle="";
				if (carrierId.equalsIgnoreCase("BN")) {
					messageHelper.setBcc(emailBcc.split(";"));
					subTitle="BNSF";
				} else if (carrierId.equalsIgnoreCase("WH")) {
					messageHelper.setBcc(emailBccWH.split(";"));
					subTitle="WH";
				}else if (carrierId.equalsIgnoreCase("RY")) {
					messageHelper.setBcc(emailBccRY.split(";"));
					subTitle="Ryan Transportation";
				}else if (carrierId.equalsIgnoreCase("AM")) {
					messageHelper.setBcc(emailAmazonBcc.split(";"));
					subTitle="Amazon Freight";
				}else if (carrierId.equalsIgnoreCase("EC")) {
					messageHelper.setBcc(emailechoBcc.split(";"));
					subTitle="Echo Global Logistics";
				}else if (carrierId.equalsIgnoreCase("MT")) {
					messageHelper.setBcc(emailMTBcc.split(";"));
					subTitle="MT";
				}else if (carrierId.equalsIgnoreCase("CH")) {
					messageHelper.setBcc(emailCH_RobinsonBcc.split(";"));
					subTitle="CH Robinson";
				}else if (carrierId.equalsIgnoreCase("AR")) {
					messageHelper.setBcc(emailARBcc.split(";"));
					subTitle="AR";
				}else if (carrierId.equalsIgnoreCase("AV")) {
					messageHelper.setBcc(emailAVBcc.split(";"));
					subTitle="AV";
				}else if (carrierId.equalsIgnoreCase("LA")) {
					messageHelper.setBcc(emailLABcc.split(";"));
					subTitle="LA";
				}
				

				messageHelper.setSubject(dateFormat.format(new Date()) + "-STT-" + subTitle + "-Despatch Report");
				messageHelper.setText(getMessage(subTitle), true);
				
				if (xlsfile.exists()) {
					messageHelper.addAttachment(dateFormat.format(new Date()) + "-STT-" + subTitle +"-Despatch Report.xlsx",
							new ByteArrayResource(IOUtils.toByteArray(new FileInputStream(xlsfile))));
				}
				logger.info( dateFormat.format(new Date()) +"-STT-" + subTitle + "-Despatch Report mail is sent");
			}

			private String getMessage(String subTitle) {
				StringBuilder builder = new StringBuilder();
				builder.append("Hello Sir,<br/><br/>");
				builder.append("Please find the attached <b>\"ST Tissue "+subTitle+" Despatch Report\"</b> for your review.<br/>");
				builder.append("<br/>Thank you,<br/>");
				builder.append(
						"Jaipur<br/><p style='font-size: 12px;'>*** This is an automatically system generated email at:"
								+ dateTimeFormat.format(new Date()) + " ***</p>");

				return builder.toString();
			}
		});

	}
	/**
	 *  InboundFreight
	 * @param xlsfile
	 * @param sdate
	 * @throws IOException 
	 */
	private void prepareGAHDocumentForLA(File xlsfile, Date sdate) throws IOException {

		String date = dateFormat.format(sdate);
		Date sDate = CommonUtil.checkDate(date, dateFormat);
		List<Despatch> datas = despatchService.getDespatchData(sDate, "LA");
		FileOutputStream outputStream = new FileOutputStream(xlsfile);
		String tblName = "tbldispatch_temp_LA";
		despatchReportHandler.createExcelDespatchReportForWH(datas, tblName, outputStream);
		outputStream.close();
		
	
		
	}
	private void prepareGAHDocumentForIF(File xlsfile, Date sdate) throws IOException {

		String date = dateFormat.format(sdate);
		Date sDate = CommonUtil.checkDate(date, dateFormat);
		List<Despatch> datas = despatchService.getDespatchData(sDate, "AV");
		FileOutputStream outputStream = new FileOutputStream(xlsfile);
		String tblName = "tbldispatch_temp_AV";
		despatchReportHandler.createExcelDespatchReportForWH(datas, tblName, outputStream);
		outputStream.close();
		
	
		
	}
	private void prepareGAHDocumentForAR(File xlsfile, Date sdate) throws IOException {
		String date = dateFormat.format(sdate);
		Date sDate = CommonUtil.checkDate(date, dateFormat);
		List<Despatch> datas = despatchService.getDespatchData(sDate, "AR");
		FileOutputStream outputStream = new FileOutputStream(xlsfile);
		String tblName = "tbldispatch_temp_AR";
		despatchReportHandler.createExcelDespatchReportForWH(datas, tblName, outputStream);
		outputStream.close();
		
	}
	private void prepareGAHDocumentForCH_Robinson(File xlsfile, Date sdate) throws IOException {
		String date = dateFormat.format(sdate);
		Date sDate = CommonUtil.checkDate(date, dateFormat);
		List<Despatch> datas = despatchService.getDespatchData(sDate, "CH");
		FileOutputStream outputStream = new FileOutputStream(xlsfile);
		String tblName = "tbldispatch_temp_CH_Robinson";
		despatchReportHandler.createExcelDespatchReportForWH(datas, tblName, outputStream);
		outputStream.close();
		
	}
	
	private void prepareGAHDocumentForMT(File xlsfile, Date sdate) throws IOException {
		String date = dateFormat.format(sdate);
		Date sDate = CommonUtil.checkDate(date, dateFormat);
		List<Despatch> datas = despatchService.getDespatchData(sDate, "MT");
		FileOutputStream outputStream = new FileOutputStream(xlsfile);
		String tblName = "tbldispatch_temp_MT";
		despatchReportHandler.createExcelDespatchReportForWH(datas, tblName, outputStream);
		outputStream.close();
		
	}

	private void prepareGAHDocumentForEcho(File xlsfile, Date sdate) throws IOException {
		String date = dateFormat.format(sdate);
		Date sDate = CommonUtil.checkDate(date, dateFormat);
		List<Despatch> datas = despatchService.getDespatchData(sDate, "EC");
		FileOutputStream outputStream = new FileOutputStream(xlsfile);
		String tblName = "tbldispatch_temp_echo";
		despatchReportHandler.createExcelDespatchReportForWH(datas, tblName, outputStream);
		outputStream.close();
	}

	private void prepareGAHDocumentForAmazone(File xlsfile, Date sdate) throws IOException {
		String date = dateFormat.format(sdate);
		Date sDate = CommonUtil.checkDate(date, dateFormat);
		List<Despatch> datas = despatchService.getDespatchData(sDate, "AM");
		FileOutputStream outputStream = new FileOutputStream(xlsfile);
		String tblName = "tbldispatch_temp_amazone";
		despatchReportHandler.createExcelDespatchReportForWH(datas, tblName, outputStream);
		outputStream.close();
	}
	
	private void prepareGAHDocumentForSM(File xlsfile, Date sdate) throws IOException {
		String date = dateFormat.format(sdate);
		Date sDate = CommonUtil.checkDate(date, dateFormat);
		List<Despatch> datas = despatchService.getDespatchData(sDate, "RY");
		FileOutputStream outputStream = new FileOutputStream(xlsfile);
		String tblName = "tbldispatch_temp_SC";
		despatchReportHandler.createExcelDespatchReportForWH(datas, tblName, outputStream);
		outputStream.close();
	}

	
	private void prepareGAHDocument(File xlsfile, Date sdate) throws IOException {

		String date = dateFormat.format(sdate);

		Date sDate = CommonUtil.checkDate(date, dateFormat);

		List<Despatch> datas = despatchService.getDespatchData(sDate, "BN");

		// List<Despatch> datas_Temp=despatchService.getDespatchData_Temp();

		FileOutputStream outputStream = new FileOutputStream(xlsfile);

		// despatchReportHandler.createExcelDespatchReport(datas,datas_Temp,outputStream);
		String tblName = "tbldispatch_temp";
		despatchReportHandler.createExcelDespatchReport(datas, tblName, outputStream);

		outputStream.close();

	}

	/**
	 * @param xlsfile
	 * @param sdate
	 * @throws IOException
	 */
	private void prepareGAHDocumentForWH(File xlsfile, Date sdate) throws IOException {

		String date = dateFormat.format(sdate);

		Date sDate = CommonUtil.checkDate(date, dateFormat);

		List<Despatch> datas = despatchService.getDespatchData(sDate, "WH");

		FileOutputStream outputStream = new FileOutputStream(xlsfile);

		String tblName = "tbldispatch_temp_WH";
		despatchReportHandler.createExcelDespatchReportForWH(datas, tblName, outputStream);

		outputStream.close();

	}

	/**
	 * @param date
	 * @param string
	 * @throws IOException
	 */
	public void sendCertificateMail(final Date sdate,final Date edate, final String customer) throws IOException {

		String folder = System.getProperty("catalina.base") + "/COA";
		File folderFile = new File(folder);
		if (!folderFile.exists()) {
			folderFile.mkdirs();
		}
		final File xlsfile = new File(context.getRealPath("/") + "WEB-INF/CertificateOfAnalysis.xlsx");

		prepareGAHDocument(xlsfile, sdate,edate, customer);
		mailSender.send(new MimeMessagePreparator() {

			@Override
			public void prepare(MimeMessage mimeMessage) throws Exception {
				MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true);
				String emails = certificateAnalysisService.getCustMails(customer);
				messageHelper.setTo(emails.split(";"));
				messageHelper.setFrom(emailFrom, emailFromName);
				messageHelper.setSubject(dateFormat.format(new Date()) + "-STT-" + customer + "-COA Report PM6");
				messageHelper.setText(getMessage(), true);
				messageHelper.addAttachment(dateFormat.format(new Date()) + "CertificateOfAnalysis_PM6.xlsx",
						new ByteArrayResource(IOUtils.toByteArray(new FileInputStream(xlsfile))));
				logger.info("ST Customer COA reports mail is sent");
			}

			private String getMessage() {
				StringBuilder builder = new StringBuilder();
				builder.append("Hello Sir,<br/><br/>");
				builder.append("Please find the attached <b>\"STT COA Report\"</b> for your review.<br/>");
				builder.append("<br/>Thank you,<br/>");
				builder.append(
						"Jaipur<br/><p style='font-size: 12px;'>*** This is an automatically system generated email at:"
								+ dateTimeFormat.format(new Date()) + " ***</p>");

				return builder.toString();
			}
		});

	}

	private void prepareGAHDocument(File xlsfile, Date sdate,Date edate, String customer) throws IOException {
		List<Rewdinder> reels = certificateAnalysisService.getRewindersGradeWithReelpm6(sdate, edate, customer);

		FileOutputStream outputStream = new FileOutputStream(xlsfile);
		InputStream fi = new FileInputStream(context.getRealPath("/") + "resources/images/STTissue.JPG");
		certificateReport.createReportExcelWeekly(customer, fi, sdate, edate, reels, xlsfile, outputStream);
		outputStream.close();
	}

	public List<Rewdinder> getCustomers() {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.DATE, 1);
		cal.add(Calendar.DAY_OF_MONTH, -1);
		Date lastDateOfPreviousMonth = cal.getTime();
		cal.set(Calendar.DATE, 1);
		Date firstDateOfPreviousMonth = cal.getTime();
		Date sdate = CommonUtil.checkDate(dateFormat.format(firstDateOfPreviousMonth), dateFormat);
		Date edate = CommonUtil.checkDate(dateFormat.format(lastDateOfPreviousMonth), dateFormat);
		
		System.out.println("Date" + edate);
		return certificateAnalysisService.getCustomers(sdate, edate);
	}

	/**
	 * @param date
	 * @param string
	 * @param string2
	 * @throws IOException
	 */
	public void sendCertificateMailPm5(final Date sdate,final Date edate, final String customer, String machinenum) throws IOException {

		String folder = System.getProperty("catalina.base") + "/COA";
		File folderFile = new File(folder);
		if (!folderFile.exists()) {
			folderFile.mkdirs();
		}
		final File xlsfile = new File(context.getRealPath("/") + "WEB-INF/CertificateOfAnalysis_PM5.xlsx");

		prepareGAHDocumentPM5(xlsfile, sdate,edate, customer);

		mailSender.send(new MimeMessagePreparator() {

			@Override
			public void prepare(MimeMessage mimeMessage) throws Exception {
				MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true);
				String emails = certificateAnalysisService.getCustMails(customer);
				messageHelper.setTo(emails.split(";"));
				messageHelper.setFrom(emailFrom, emailFromName);
				// messageHelper.setReplyTo("Joan.Wilson@stpaperllc.com");
				messageHelper.setSubject(dateFormat.format(new Date()) + "-STT-" + customer + "-COA Report_PM5");
				messageHelper.setText(getMessage(), true);
				/* if (xlsfile.exists()) { */
				messageHelper.addAttachment(dateFormat.format(new Date()) + "CertificateOfAnalysis_PM5.xlsx",
						new ByteArrayResource(IOUtils.toByteArray(new FileInputStream(xlsfile))));
				// }
				logger.info("ST Customer COA reports mail is sent");
			}

			private String getMessage() {
				StringBuilder builder = new StringBuilder();
				builder.append("Hello Sir,<br/><br/>");
				builder.append("Please find the attached <b>\"STT COA Report PM5\"</b> for your review.<br/>");
				builder.append("<br/>Thank you,<br/>");
				builder.append(
						"Jaipur<br/><p style='font-size: 12px;'>*** This is an automatically system generated email at:"
								+ dateTimeFormat.format(new Date()) + " ***</p>");

				return builder.toString();
			}
		});

		// TODO Auto-generated method stub

	}

	/**
	 * @param xlsfile
	 * @param sdate
	 * @param customer
	 * @throws IOException
	 */
	private void prepareGAHDocumentPM5(File xlsfile, Date sdate,Date edate, String customer) throws IOException {

		List<Rewdinder> reels = certificateAnalysisService.getRewindersGradeWithReelpm5(sdate, edate, customer);

		FileOutputStream outputStream = new FileOutputStream(xlsfile);
		InputStream fi = new FileInputStream(context.getRealPath("/") + "resources/images/STTissue.JPG");
		certificateReport.createReportExcelWeekly_Pm5(customer, fi, sdate, edate, reels, xlsfile, outputStream);
		outputStream.close();
	}

}

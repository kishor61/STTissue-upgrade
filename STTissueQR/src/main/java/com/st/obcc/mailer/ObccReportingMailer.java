/**
 *Sep 14, 2016
 *ObccReportingMailer.java
 * TODO
 *com.st.obcc.mailer
 *ObccReportingMailer.java
 *Roshan Lal Tailor
 */
package com.st.obcc.mailer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Formatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

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

import com.st.obcc.model.BackTender;
import com.st.obcc.model.MachineTender;
import com.st.obcc.model.OBCCCommanMehod;
import com.st.obcc.model.OperatorData;
import com.st.obcc.model.R1Operator;
import com.st.obcc.model.StockOperator;
import com.st.obcc.model.UtilityOperator;
import com.st.obcc.report.handler.ObccReportHandler;
import com.st.obcc.report.handler.obccPdfReportHandler;
import com.st.obcc.service.BackTenderService;
import com.st.obcc.service.MachineTenderService;
import com.st.obcc.service.OperatorService;
import com.st.obcc.service.R1OperatorService;
import com.st.obcc.service.StockOperatorService;
import com.st.obcc.service.UtilityOperatorService;
import com.st.production.automailer.ProductionReportAutoMailer;
/**
 * @author roshan
 *
 *
 *OBCCReport
 */
@Component
public class ObccReportingMailer {

	private static final Logger logger = LoggerFactory.getLogger(ProductionReportAutoMailer.class);
	private SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
	private SimpleDateFormat dateTimeFormat = new SimpleDateFormat("MM-dd-yyyy h:mm a");
	private SimpleDateFormat dateTimeFormat4 = new SimpleDateFormat("yyyy-MM-dd");
	private SimpleDateFormat format = new SimpleDateFormat("MM-dd-yyyy");
	
	
	@Autowired
	private ObccReportHandler obccReportHandler;
	
	@Autowired
	private R1OperatorService r1OperatorService;
	
	@Autowired
	private obccPdfReportHandler obccPdfReportHandler;
	
	@Autowired
	private OperatorService operatorService;
	
	@Autowired
	private UtilityOperatorService utilityOperatorService;
	
	@Autowired
	private BackTenderService backTenderService;
	
	@Autowired
	private MachineTenderService machineTenderService;
	
	@Autowired
	private StockOperatorService stockOperatorService;
	
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
	
	
	@Value("${mail.to.obccmonthlyreport}")
	private String emailobccmonthlyreport;
	
	
	
	/**
	 * @param position
	 * @param sdate
	 * @param edate
	 * @throws Exception 
	 */
	public void getOBCCR1ReportingMail(String position, String sdate,String edate) throws Exception {
		String folder=System.getProperty("catalina.base")+"/OBCC_R1_Reporting_Mail_PM6_Roshan Tailor";
		File folderFile=new File(folder);
		if(!folderFile.exists()){
			folderFile.mkdirs();
		}
		
		
		final File filePdf=new File(folder,"OBCC R1 Operator - Report"+".pdf");
		final int  i = prepareDetailedReportDocument(filePdf,sdate,edate,position);
		mailSender.send(new MimeMessagePreparator(){

			@Override
			public void prepare(MimeMessage mimeMessage) throws Exception {
				MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage,true);
				messageHelper.setTo(emailTomachinebreakfreepercentage.split(";"));
				messageHelper.setFrom(emailFrom,emailFromName);
				messageHelper.setBcc(emailBcc.split(";"));
				
				Calendar cal = Calendar.getInstance();
				cal.add(Calendar.DATE, -1);
				
				messageHelper.setSubject(dateTimeFormat4.format(cal.getTime())+"-PM6-OBCC R1 Operator - Report");
				
				messageHelper.setText(getMessage(), true);
				if(i!=0){
					messageHelper.addAttachment(dateTimeFormat4.format(cal.getTime())+"-OBCC R1 Operator - Report.pdf", new ByteArrayResource(IOUtils.toByteArray(new FileInputStream(filePdf))));
				}
				logger.info("ST Tissue OBCC R1 Operator - Report mail is sent");
			}

			private String getMessage() {
				StringBuilder builder=new StringBuilder();
				builder.append("Hello Sir,<br/><br/>");
				builder.append("Please find the attached <b>\"ST Tissue OBCC R1 Operator - Report Of PM6\"</b> for your review.<br/>");
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
	 * @param xlsfile
	 * @param sdate
	 * @param edate
	 * @param position
	 * @throws Exception 
	 */
	private int prepareDetailedReportDocument(File filePdf, String sdate,String edate, String position) throws Exception {
		
		List<R1Operator> datas  = r1OperatorService.getOperatorDataList(position, sdate, edate);
		
		long l =  r1OperatorService.getDataCountDatePercentage1(position, sdate, edate);
		
		if(datas.size() !=0)
		{
			FileOutputStream outputStream=new FileOutputStream(filePdf);
			
			System.out.println(datas.size()+"Roshan");
			  
			obccPdfReportHandler.createR1OperatorPdf(datas,outputStream,l);
			
			System.out.println(datas.size()+"Tailor");
			outputStream.close();
			return 1;
		}
		else
		{
			return 0;
		}
			
		
		
	}

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
		
		List<OperatorData> datas  = operatorService.getOperatorDataList(position, sdate, edate);
		long l =  operatorService.getDataCountDatePercentage(position, sdate, sdate);
		if(datas.size() !=0)
		{
			FileOutputStream outputStream=new FileOutputStream(filePdf);
			obccPdfReportHandler.createR2Pdf(datas,outputStream,l);
			outputStream.close();
			return 1;
		}
		else
		{
			return 0;
		}
			
		
		
	}

	/**
	 * @param position
	 * @param sdate
	 * @param edate
	 * @throws Exception 
	 */
	public void getOBCCUtilityReportingMail(String position, String sdate,String edate) throws Exception {
		String folder=System.getProperty("catalina.base")+"/OBCC_Utility_Reporting_Mail_PM6_Roshan Tailor";
		File folderFile=new File(folder);
		if(!folderFile.exists()){
			folderFile.mkdirs();
		}
		
		
		final File filePdf=new File(folder,"OBCC Utility Operator - Report"+".pdf");
		final int  i = prepareDetailedReportDocumentUtility(filePdf,sdate,edate,position);
		mailSender.send(new MimeMessagePreparator(){

			@Override
			public void prepare(MimeMessage mimeMessage) throws Exception {
				MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage,true);
				messageHelper.setTo(emailTomachinebreakfreepercentage.split(";"));
				messageHelper.setFrom(emailFrom,emailFromName);
				messageHelper.setBcc(emailBcc.split(";"));
				
				Calendar cal = Calendar.getInstance();
				cal.add(Calendar.DATE, -1);
				
				messageHelper.setSubject(dateTimeFormat4.format(cal.getTime())+"-OBCC Utility Operator - Report");
				
				messageHelper.setText(getMessage(), true);
				if(i!=0){
					messageHelper.addAttachment(dateTimeFormat4.format(cal.getTime())+"-OBCC Utility Operator - Report.pdf", new ByteArrayResource(IOUtils.toByteArray(new FileInputStream(filePdf))));
				}
				logger.info("ST Tissue OBCC Utility Operator - Report mail is sent");
			}

			private String getMessage() {
				StringBuilder builder=new StringBuilder();
				builder.append("Hello Sir,<br/><br/>");
				builder.append("Please find the attached <b>\"ST Tissue OBCC Utility Operator - Report Of PM6\"</b> for your review.<br/>");
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
	private int prepareDetailedReportDocumentUtility(File filePdf,
			String sdate, String edate, String position) throws Exception {
		
		List<UtilityOperator> datas  = utilityOperatorService.getOperatorDataList(position, sdate, edate);
		long l =  utilityOperatorService.getDataCountDatePercentage1(position, sdate, edate);
		
		if(datas.size() !=0)
		{
			FileOutputStream outputStream=new FileOutputStream(filePdf);
			obccPdfReportHandler.createUtilityOperatorPdf(datas,outputStream,l);
			outputStream.close();
			return 1;
		}
		else
		{
			return 0;
		}
			
		
		
	}

	/**
	 * @param position
	 * @param sdate
	 * @param edate
	 * @throws Exception 
	 */
	public void getOBCCBackTenderReportingMail(String position, String sdate,String edate) throws Exception {
		String folder=System.getProperty("catalina.base")+"/OBCC_BackTender_Reporting_Mail_PM6_Roshan Tailor";
		File folderFile=new File(folder);
		if(!folderFile.exists()){
			folderFile.mkdirs();
		}
		
		
		final File filePdf=new File(folder,"OBCC Back Tender Operator - Report"+".pdf");
		final int  i = prepareDetailedReportDocumentBackTender(filePdf,sdate,edate,position);
		mailSender.send(new MimeMessagePreparator(){

			@Override
			public void prepare(MimeMessage mimeMessage) throws Exception {
				MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage,true);
				messageHelper.setTo(emailTomachinebreakfreepercentage.split(";"));
				messageHelper.setFrom(emailFrom,emailFromName);
				messageHelper.setBcc(emailBcc.split(";"));
				
				Calendar cal = Calendar.getInstance();
				cal.add(Calendar.DATE, -1);
				
				messageHelper.setSubject(dateTimeFormat4.format(cal.getTime())+"-PM6-OBCC Back Tender Operator - Report");
				
				messageHelper.setText(getMessage(), true);
				if(i!=0){
					messageHelper.addAttachment(dateTimeFormat4.format(cal.getTime())+"-OBCC Back Tender Operator - Report.pdf", new ByteArrayResource(IOUtils.toByteArray(new FileInputStream(filePdf))));
				}
				logger.info("ST Tissue OBCC Back Tender Operator - Report mail is sent");
			}

			private String getMessage() {
				StringBuilder builder=new StringBuilder();
				builder.append("Hello Sir,<br/><br/>");
				builder.append("Please find the attached <b>\"ST Tissue OBCC Back Tender Operator - Report Of PM6\"</b> for your review.<br/>");
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
	private int prepareDetailedReportDocumentBackTender(File filePdf,
			String sdate, String edate, String position) throws Exception {
		
		List<BackTender> daylst = backTenderService.getOperatorDataList(position, sdate, edate, "day");
		List<BackTender> nightlst = backTenderService.getOperatorDataList(position, sdate, edate, "night");
		long l = backTenderService.getDataCountDatePercentage(position,sdate,edate,"Both");
		
		if(daylst.size() !=0 || nightlst.size() !=0)
		{
			
			FileOutputStream outputStream=new FileOutputStream(filePdf);
			obccPdfReportHandler.createBackTernerOperatorPdf(daylst,nightlst,outputStream,l);
			outputStream.close();
			return 1;
		}
		else
		{
			return 0;
		}
	}

	/**
	 * @param position
	 * @param sdate
	 * @param edate
	 * @throws Exception 
	 */
	public void getOBCCMachineTenderReportingMail(String position,String sdate, String edate) throws Exception {
		String folder=System.getProperty("catalina.base")+"/OBCC_MachineTender_Reporting_Mail_PM6_Roshan Tailor";
		File folderFile=new File(folder);
		if(!folderFile.exists()){
			folderFile.mkdirs();
		}
		
		
		final File filePdf=new File(folder,"OBCC Machine Tender Operator - Report"+".pdf");
		final int  i = prepareDetailedReportDocumentMachineTender(filePdf,sdate,edate,position);
		mailSender.send(new MimeMessagePreparator(){

			@Override
			public void prepare(MimeMessage mimeMessage) throws Exception {
				MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage,true);
				messageHelper.setTo(emailTomachinebreakfreepercentage.split(";"));
				messageHelper.setFrom(emailFrom,emailFromName);
				messageHelper.setBcc(emailBcc.split(";"));
				
				Calendar cal = Calendar.getInstance();
				cal.add(Calendar.DATE, -1);
				
				messageHelper.setSubject(dateTimeFormat4.format(cal.getTime())+"-PM6-OBCC Machine Tender Operator - Report");
				
				messageHelper.setText(getMessage(), true);
				if(i!=0){
					messageHelper.addAttachment(dateTimeFormat4.format(cal.getTime())+"-OBCC Machine Tender Operator - Report.pdf", new ByteArrayResource(IOUtils.toByteArray(new FileInputStream(filePdf))));
				}
				logger.info("ST Tissue OBCC Machine Tender Operator - Report mail is sent");
			}

			private String getMessage() {
				StringBuilder builder=new StringBuilder();
				builder.append("Hello Sir,<br/><br/>");
				builder.append("Please find the attached <b>\"ST Tissue OBCC Machine Tender Operator - Report Of PM6\"</b> for your review.<br/>");
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
	private int prepareDetailedReportDocumentMachineTender(File filePdf,
			String sdate, String edate, String position) throws Exception {
		
		List<MachineTender> daylst  = machineTenderService.getOperatorDataList(position, sdate, edate,"day");
		List<MachineTender> nightlst  = machineTenderService.getOperatorDataList(position, sdate, edate,"night");
		
		if(daylst.size() !=0 || nightlst.size() !=0)
		{
			FileOutputStream outputStream=new FileOutputStream(filePdf);
			long l = machineTenderService.getDataCountDatePercentage(position,sdate,edate,"Both"); 
			obccPdfReportHandler.createMachineTernerOperatorPdf(daylst,nightlst,outputStream,l);
			outputStream.close();
			return 1;
		}
		else
		{
			return 0;
		}
	}

	/**
	 * @param position
	 * @param sdate
	 * @param edate
	 * @throws Exception 
	 */
	public void getOBCCStockOperatorReportingMail(String position,String sdate, String edate) throws Exception {
		String folder=System.getProperty("catalina.base")+"/OBCC_StockOperator_Reporting_Mail_PM6_Roshan Tailor";
		File folderFile=new File(folder);
		if(!folderFile.exists()){
			folderFile.mkdirs();
		}
		
		
		final File filePdf=new File(folder,"OBCC Stock Operator - Report"+".pdf");
		final int  i = prepareDetailedReportDocumentStockOperator(filePdf,sdate,edate,position);
		mailSender.send(new MimeMessagePreparator(){

			@Override
			public void prepare(MimeMessage mimeMessage) throws Exception {
				MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage,true);
				messageHelper.setTo(emailTomachinebreakfreepercentage.split(";"));
				messageHelper.setFrom(emailFrom,emailFromName);
				messageHelper.setBcc(emailBcc.split(";"));
				
				Calendar cal = Calendar.getInstance();
				cal.add(Calendar.DATE, -1);
				
				messageHelper.setSubject(dateTimeFormat4.format(cal.getTime())+"-PM6-OBCC Stock Operator - Report");
				
				messageHelper.setText(getMessage(), true);
				if(i!=0){
					messageHelper.addAttachment(dateTimeFormat4.format(cal.getTime())+"-OBCC Stock Operator - Report.pdf", new ByteArrayResource(IOUtils.toByteArray(new FileInputStream(filePdf))));
				}
				logger.info("ST Tissue OBCC Stock Operator - Report mail is sent");
			}

			private String getMessage() {
				StringBuilder builder=new StringBuilder();
				builder.append("Hello Sir,<br/><br/>");
				builder.append("Please find the attached <b>\"ST Tissue OBCC Stock Operator - Report Of PM6\"</b> for your review.<br/>");
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
	private int prepareDetailedReportDocumentStockOperator(File filePdf,
			String sdate, String edate, String position) throws Exception {
		
		List<StockOperator> daylst  = stockOperatorService.getOperatorDataList(position, sdate, edate,"day");
		List<StockOperator> nightlst  = stockOperatorService.getOperatorDataList(position, sdate, edate,"night");
		long l = stockOperatorService.getDataCountDatePercentage(position,sdate,edate,"Both"); 
		if(daylst.size() !=0 || nightlst.size() !=0)
		{
			FileOutputStream outputStream=new FileOutputStream(filePdf);
			obccPdfReportHandler.createStokeOperatorPdf(daylst,nightlst,outputStream,l);
			outputStream.close();
			return 1;
		}
		else
		{
			return 0;
		}
	}

	/**
	 * @throws Exception 
	 * 
	 */
	public void sendOBCCEmailPercentageMonthWise(String startDate,String endDate) throws Exception {
		String folder=System.getProperty("catalina.base")+"/OBCC_Download Percentage Report MonthWise_PM6_Roshan";
		File folderFile=new File(folder);
		if(!folderFile.exists()){
			folderFile.mkdirs();
		}
		
		final File xlsfile=new File(folder,"OBCC Download Percentage Month Wise-Report"+".xlsx");
		
		prepareOBCCDownloadPercentageReportDOC(startDate,endDate,xlsfile);
		mailSender.send(new MimeMessagePreparator(){

			@Override
			public void prepare(MimeMessage mimeMessage) throws Exception {
				MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage,true);
				messageHelper.setTo(emailobccmonthlyreport.split(";"));
				messageHelper.setFrom(emailFrom,emailFromName);
				messageHelper.setBcc(emailBcc.split(";"));
				
				Calendar aCalendar = Calendar.getInstance();
				aCalendar.add(Calendar.MONTH, -1);
				aCalendar.set(Calendar.DATE, 1);
				Date firstDateOfPreviousMonth = aCalendar.getTime();
				
				Calendar cal = Calendar.getInstance();
				cal.setTime(firstDateOfPreviousMonth);

				int month = cal.get(Calendar.MONTH);
				int year = cal.get(Calendar.YEAR);
				
				Formatter fmt = new Formatter();
				fmt = new Formatter();
				fmt.format("%tB",cal);
			    String date=""+fmt+"-"+year;
				
				messageHelper.setSubject(date+"-PM6-OBCC Download Percentage Month Wise-Report");
				
				messageHelper.setText(getMessage(), true);
				if(xlsfile.exists()){
					messageHelper.addAttachment(date+"-OBCC Download Percentage Month Wise-Report.xlsx", new ByteArrayResource(IOUtils.toByteArray(new FileInputStream(xlsfile))));
				}
				logger.info("ST Tissue OBCC Download Percentage Month Wise-Report mail is sent");
			}

			private String getMessage() {
				StringBuilder builder=new StringBuilder();
				builder.append("Hello Sir,<br/><br/>");
				builder.append("Please find the attached <b>\"ST Tissue OBCC Download Percentage Month Wise-Report  Of PM6\"</b> for your review.<br/>");
				builder.append("<br/>Thank you,<br/>");
				builder.append("Jaipur<br/><p style='font-size: 12px;'>*** This is an automatically system generated email at:"+dateTimeFormat.format(new Date())+" ***</p>");
				builder.append("<br/><b style='color: white;'>Roshan Tailor</b>,<br/>");
				return builder.toString();
			}});
		
		
		
	}

	/**
	 * @param xlsfile
	 * @throws Exception 
	 */
	private void prepareOBCCDownloadPercentageReportDOC(String startDate,String endDate,File xlsfile) throws Exception {
		// TODO Auto-generated method stub

		// TODO Auto-generated method stub
		int startMonth = OBCCCommanMehod.getMonth(startDate); 
		int endMonth =   OBCCCommanMehod.getMonth(endDate);
	   
		int startYear = OBCCCommanMehod.getYear(startDate); 
		int endYear =   OBCCCommanMehod.getYear(endDate);
	   	System.out.println("startDate" + startMonth);
		System.out.println("endDate" + endMonth);   
	   
		
		SimpleDateFormat f = new SimpleDateFormat("mm-DD-yyyy");
		int n = 0;
	    Date d1;
		try {
			 d1 = format.parse(startDate);
			 Date d2 = format.parse(endDate);
			 n = OBCCCommanMehod.differenceInMonths(d1, d2);
			System.out.println("diff days"+n);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		 
		if(startYear!=endYear)
		{
			endMonth = n;   
		}
		else
		{
			
		}
		 
		
	   Map<Date, Double> map = new HashMap<Date, Double>();
	   Map<Date, Double> r1map = new HashMap<Date, Double>();
	   Map<Date, Double> utilitymap = new HashMap<Date, Double>();
	   Map<Date, Double> backtendermap = new HashMap<Date, Double>();
	   Map<Date, Double> stockmap = new HashMap<Date, Double>();
	   Map<Date, Double> machinemap = new HashMap<Date, Double>();
	   double R1Percenatge = 0.0;
	   double R2Percenatge = 0.0;
	   double utilityoperator = 0.0;
	   double stockOperatorday = 0.0;
	   double stockOperatornight = 0.0;
	   double machinetenderday = 0.0;
	   double machinetendernight = 0.0;
	   double backtenderday = 0.0;
	   double backtendernight = 0.0;
	   
	   for (int i = 0; i <= n; i++) {
		   String getlastDayofMonth = null;
		   
		   if(OBCCCommanMehod.checksameMonth(startDate,endDate) == true)
		   {
			   getlastDayofMonth = endDate;
		   }
		   else
		   {
			   getlastDayofMonth = OBCCCommanMehod.getLastDateOfMonth(startDate);
		   }
		   
		   R1Percenatge = r1OperatorService.getDataCountDatePercentage1("R1",startDate, endDate);
		   R2Percenatge = operatorService.getDataCountDatePercentage("R2",startDate, endDate);
		   utilityoperator = utilityOperatorService.getDataCountDatePercentage1("utilityoperator",startDate, endDate);
		   stockOperatorday = stockOperatorService.getDataCountDatePercentage("stockoperator","day",startDate, endDate);
		   stockOperatornight = stockOperatorService.getDataCountDatePercentage("stockoperator","night",startDate, endDate);
		   double stockOperator=(stockOperatorday+stockOperatornight)/2;
		   machinetenderday = machineTenderService.getDataCountDatePercentage("machinetender","day",startDate, endDate);
		   machinetendernight = machineTenderService.getDataCountDatePercentage("machinetender","night",startDate, endDate);
		   double machinetender=( machinetenderday+ machinetendernight)/2;
		   backtenderday = backTenderService.getDataCountDatePercentage("backtender","day",startDate, endDate);		  
		   backtendernight = backTenderService.getDataCountDatePercentage("backtender","night",startDate, endDate);
		   double backtender=( backtenderday+ backtendernight)/2;  
		    
		   startDate = OBCCCommanMehod.addOneMonth(startDate);
		   map.put(format.parse(getlastDayofMonth), R2Percenatge);
		   r1map.put(format.parse(getlastDayofMonth), R1Percenatge);
		   utilitymap.put(format.parse(getlastDayofMonth), utilityoperator);
		   stockmap.put(format.parse(getlastDayofMonth), stockOperator);
		   backtendermap.put(format.parse(getlastDayofMonth),backtender );
		   machinemap.put(format.parse(getlastDayofMonth), machinetender);
		   startMonth = startMonth+1;
		   
	   }
	   Map<Date, Double> treeMap4 = new TreeMap<Date, Double>(map);
	   Map<Date, Double> treeMap2 = new TreeMap<Date, Double>(r1map);
	   Map<Date, Double> treeMap3 = new TreeMap<Date, Double>(utilitymap);
	   Map<Date, Double> treeMap1 = new TreeMap<Date, Double>(backtendermap);
	   Map<Date, Double> treeMap5 = new TreeMap<Date, Double>(stockmap);
	   Map<Date, Double> treeMap6 = new TreeMap<Date, Double>(machinemap);

	   FileOutputStream outputStream=new FileOutputStream(xlsfile);
	obccReportHandler.getExcelReportbyPercentageSecond(treeMap4,treeMap1,treeMap6,treeMap5,treeMap3,treeMap2,outputStream);

	outputStream.close();
	
	}

}

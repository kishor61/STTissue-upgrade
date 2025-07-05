/**
 *Feb 2, 2018
 *BarcodeInvetoryReportMailer.java
 * TODO
 *com.st.wastepaper.mailer
 *BarcodeInvetoryReportMailer.java
 *Roshan Lal Tailor
 */
package com.st.wastepaper.mailer;

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
import jakarta.servlet.ServletContext;
import javax.sql.DataSource;

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
import com.st.despatch.automailer.DespatchAutoMailer;
import com.st.despatch.report.DespatchReportHandler;
import com.st.despatch.service.DespatchService;
import com.st.wastepaper.model.BarcodeComman;
import com.st.wastepaper.model.WastePaperBaleInventory;
import com.st.wastepaper.report.BarcodeInvetoryReportHandler;
import com.st.wastepaper.service.WastePaperBaleInventoryService;
import com.st.wastepaper.service.WastePaperUnloadBaleInventoryService;

/**
 * @author roshan
 *
 */
@Component
public class BarcodeInvetoryReportMailer {

	private static final Logger logger = LoggerFactory.getLogger(BarcodeInvetoryReportMailer.class);
	private SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
	private SimpleDateFormat dateTimeFormat = new SimpleDateFormat("MM-dd-yyyy h:mm a");
	private SimpleDateFormat monthFormat=new SimpleDateFormat("MM");
	private SimpleDateFormat dayFormat=new SimpleDateFormat("dd");
	private SimpleDateFormat yearFormat=new SimpleDateFormat("yyyy");
	
	@Autowired 
	private WastePaperUnloadBaleInventoryService wastePaperUnloadBaleInventoryService;
	
	@Autowired
	private WastePaperBaleInventoryService wastePaperBaleInventoryService;
	
	@Autowired
	private BarcodeInvetoryReportHandler barcodeInvetoryReportHandler;

	@Autowired
	private JavaMailSender mailSender;

	@Value("${mail.wastepaperbaleinventory.to}")
	private String emailTo;
	
	/*@Value("${mail.dailyinvrepo}")
	private String dailyinvrepo;*/
	
	@Value("${mail.wastepaperbaleinventory.bcc}")
	private String emailBcc;
	
	@Value("${mail.from}")
	private String emailFrom;

	@Value("${mail.fromname}")
	private String emailFromName;

	@Value("${mail.to.error}")
	private String emailToError;
	/**
	 * @param date 
	 * @param custname 
	 * @param startdate
	 * @throws Exception 
	 */
	
	
	
	
	/*public void getDailyInventeryReport(String custname, Date date) throws IOException {
		
		String folder = System.getProperty("catalina.base")
				+ "/DailyInventery- REPORT";
		File folderFile = new File(folder);
		if (!folderFile.exists()) {
			folderFile.mkdirs();
		}

		final File xlsfile = new File(folder, "DailyInventery"	+ ".xls");
		
		FileOutputStream outputStream = new FileOutputStream(xlsfile);

		//Map<String,Float> map=wastePaperBaleInventoryService.getDailyInventeryReport(custname,date);
		//barcodeInvetoryReportHandler.getDailyInventeryReport(custname,map,outputStream);
		
		mailSender.send(new MimeMessagePreparator() {
			@Override
			public void prepare(MimeMessage mimeMessage) throws Exception {
				MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true);
				messageHelper.setTo(dailyinvrepo.split(";"));
				messageHelper.setFrom(emailFrom, emailFromName);
			//	messageHelper.setBcc(emailBcc.split(";"));
				
				messageHelper.setSubject(dateFormat.format(new Date())
						+ "-STT-DAILY INVENTORY REPORT");
				messageHelper.setText(getMessage(), true);
				if (xlsfile.exists()) {
					messageHelper.addAttachment(
							dateFormat.format(new Date())
									+ "-STT-DAILY INVENTORY REPORT.xlsx",
							new ByteArrayResource(IOUtils
									.toByteArray(new FileInputStream(xlsfile))));
				}
				logger.info("ST Tissue DAILY INVENTORY REPORT  mail is sent");
			}
			private String getMessage() {
				StringBuilder builder = new StringBuilder();
				builder.append("Hello Sir,<br/><br/>");
				builder.append("Please find the attached <b>\"ST Tissue Daily Inventory Report \"</b> for your review.<br/>");
				builder.append("<br/>Thank you,<br/>");
				builder.append("Jaipur<br/><p style='font-size: 12px;'>*** This is an automatically system generated email at:"
						+ dateTimeFormat.format(new Date()) + " ***</p>");
				return builder.toString();
			}
		});
		outputStream.close();
	}*/
	
	//mail.dailyinvrepo
	public void getBarcodeInventoryReportSendEmail(Date sdate) throws Exception {
		String folder = System.getProperty("catalina.base")
				+ "/WASTE PAPER BALE INVENTORY REPORT";
		File folderFile = new File(folder);
		if (!folderFile.exists()) {
			folderFile.mkdirs();
		}

		final File xlsfile = new File(folder, "Waste Paper Bale Inventory Report" + ".xlsx");

		prepareWASTEPAPERBALEINVENTORYREPORTDocument(xlsfile, sdate);
		

		mailSender.send(new MimeMessagePreparator() {

			@Override
			public void prepare(MimeMessage mimeMessage) throws Exception {
				MimeMessageHelper messageHelper = new MimeMessageHelper(
						mimeMessage, true);
				messageHelper.setTo(emailTo.split(";"));
				messageHelper.setFrom(emailFrom, emailFromName);
				messageHelper.setBcc(emailBcc.split(";"));
				
				messageHelper.setSubject(dateFormat.format(new Date())
						+ "-STT-WASTE PAPER BALE INVENTORY REPORT");
				messageHelper.setText(getMessage(), true);
				if (xlsfile.exists()) {
					messageHelper.addAttachment(
							dateFormat.format(new Date())
									+ "-STT-Waste Paper Bale Inventory Report.xlsx",
							new ByteArrayResource(IOUtils
									.toByteArray(new FileInputStream(xlsfile))));
				}
				logger.info("ST Tissue WASTE PAPER BALE INVENTORY REPORT  mail is sent");
			}

			private String getMessage() {
				StringBuilder builder = new StringBuilder();
				builder.append("Hello Sir,<br/><br/>");
				builder.append("Please find the attached <b>\"ST Tissue Waste Paper Bale Inventory Report \"</b> for your review.<br/>");
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
	 * @throws Exception 
	 */
	private void prepareWASTEPAPERBALEINVENTORYREPORTDocument(File xlsfile,Date startdate) throws Exception {
		// TODO Auto-generated method stub
		String firstDay1=dayFormat.format(startdate);
		Date currentMonthSDate =null;
		if(firstDay1.equalsIgnoreCase("01")){
			Calendar cal = Calendar.getInstance();
	        cal.setTime(startdate);
			cal.add(Calendar.MONTH, -1);
	        cal.set(Calendar.DATE, 1);
			currentMonthSDate = cal.getTime();
			cal.set(Calendar.DATE,cal.getActualMaximum(Calendar.DAY_OF_MONTH));
		}else{
			Calendar cal = Calendar.getInstance();
	        cal.setTime(startdate);
			cal.add(Calendar.MONTH, 0);
	        cal.set(Calendar.DATE, 1);
			currentMonthSDate = cal.getTime();
			cal.set(Calendar.DATE,cal.getActualMaximum(Calendar.DAY_OF_MONTH));
		}
		

		//New Condition Applied Here If Date Is 1
		String firstDay=dayFormat.format(startdate);
		System.out.println("firstDay:::"+firstDay);
		java.sql.Date preDayOfStartDate=null;
		if(firstDay.equalsIgnoreCase("01")){
			// Subtract 1 day From startdate
			System.out.println("Yes");
			System.out.println("Starts Date::"+dateFormat.format(startdate));
			
			Calendar t1 = Calendar.getInstance();
			t1.setTime(startdate);
			t1.add(Calendar.MONTH, 0);
			t1.add(Calendar.DATE, -1);
			preDayOfStartDate = new java.sql.Date(t1.getTimeInMillis());
			System.out.println("preDayOfStartDate::"+dateFormat.format(preDayOfStartDate));
			System.out.println("currentMonthSDate::"+dateFormat.format(currentMonthSDate));
		}else{
			// Subtract 1 day From startdate
			System.out.println("NO");
			System.out.println("Starts Date::"+dateFormat.format(startdate));
			
			Calendar t2 = Calendar.getInstance();
			t2.setTime(startdate);
			t2.add(Calendar.DATE, -1);
			preDayOfStartDate = new java.sql.Date(t2.getTimeInMillis());
		}
		
		List<WastePaperBaleInventory> unloadbalesdata=wastePaperBaleInventoryService.getUnloadBales(currentMonthSDate,preDayOfStartDate);
		
		List<WastePaperBaleInventory> consumedBalesData=wastePaperUnloadBaleInventoryService.getConsumedData(currentMonthSDate,preDayOfStartDate);
		
		
		Calendar cal1 = Calendar.getInstance();
		cal1.setTime(startdate);
		cal1.add(Calendar.DATE, -1);
		System.out.println("Yesterday's date = "+ cal1.getTime());
		Date yesterdayDate=cal1.getTime();
			
		//Code For One Day Consumed Bales And Weight Starts from Here
		List<WastePaperBaleInventory> consumedBalesDataOfOneDay=wastePaperUnloadBaleInventoryService.getConsumedData(yesterdayDate,yesterdayDate);
		
		SimpleDateFormat monthAnd = new SimpleDateFormat("MM");
		SimpleDateFormat yearAnd = new SimpleDateFormat("yyyy");
		 
		//String monthS=monthAnd.format(startdate);
		String monthS=monthAnd.format(preDayOfStartDate);
		int month = Integer.parseInt(monthS);
		/*if(month==1){
			 month=2;
		}*/
		 
		//String yearS=yearAnd.format(startdate);
		String yearS=yearAnd.format(preDayOfStartDate);
		int year = Integer.parseInt(yearS);
		
		//String dayS=dayFormat.format(startdate);
		String dayS=dayFormat.format(preDayOfStartDate);
		int day = Integer.parseInt(dayS);
		
		List<BarcodeComman> openingMonth=null;
		 
		if(day==1 || day==01){
			//openingMonth=wastePaperUnloadBaleInventoryService.getOpenMonth(month-1,year);
			openingMonth=wastePaperUnloadBaleInventoryService.getOpenMonth(month,year);
		}else{
			openingMonth=wastePaperUnloadBaleInventoryService.getOpenMonth(month,year);
		}
		
		List<WastePaperBaleInventory> frpData=wastePaperBaleInventoryService.getFRPLocationData();
		
		FileOutputStream outputStream = new FileOutputStream(xlsfile);
		barcodeInvetoryReportHandler.getCreateBarcodeInventoryExcelReport(unloadbalesdata,consumedBalesData,consumedBalesDataOfOneDay,preDayOfStartDate,openingMonth,frpData,yesterdayDate,startdate,outputStream);
		
	}
	
	

}

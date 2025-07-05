/**
 *Jun 20, 2018
 *DashBoardReportMailer.java
 * TODO
 *com.st.dashboard.report
 *DashBoardReportMailer.java
 *Roshan Lal Tailor
 */
package com.st.dashboard.report;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
import com.st.convertingline.model.ConvertingLineProduction;
import com.st.frpproduction.model.FrpProdcutionOperatorDataEntry;
import com.st.frpproduction.service.FrpProdcutionOperatorDataEntryService;
import com.st.production.automailer.ProductionReportAutoMailer;
import com.st.production.model.MachineProduction;
import com.st.production.report.MeahineBreakFreeProductionReportHandler;
import com.st.production.service.MachineProductionService;
import com.st.production.service.MachineProductionSummaryServiceImp;
import com.st.productionpm5.service.MachineProductionServicePM5;
import com.st.utilitykpimaster.model.KpiRecordableDate;
import com.st.utilitykpimaster.service.KpiRecordableDateService;

/**
 * @author roshan
 *
 */
@Component
public class DashBoardReportMailer {

	private static final Logger logger = LoggerFactory.getLogger(DashBoardReportMailer.class);
	private SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
	private SimpleDateFormat dateTimeFormat = new SimpleDateFormat("MM-dd-yyyy h:mm a");
	private SimpleDateFormat dateTimeFormat4 = new SimpleDateFormat("yyyy-MM-dd");
	
	@Autowired
	private KpiRecordableDateService kpiRecordableDateService;
	
	@Autowired
	private FrpProdcutionOperatorDataEntryService frpprodcutionoperatordataentryservice ;
	
	@Autowired
	private MachineProductionServicePM5 machineProductionPM5Service;
	
	@Autowired
	private MachineProductionService machineProductionService;
	
	
	
	@Autowired
	private DashBoardReport dashBoardReport;
	
	@Autowired
	private JavaMailSender mailSender;
	
	@Value("${mail.to.sttdailydashboardreport}")
	private String emailTomsttdailydashboardreport;
	
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
	 * @throws IOException 
	 * @throws ProductionException 
	 */
	public void getDashBoardReportMailerMail(Date sDate) throws ProductionException, IOException {
		String folder=System.getProperty("catalina.base")+"/STT_Daily_DashBoard_Report_Roshan Tailor";
		File folderFile=new File(folder);
		if(!folderFile.exists()){
			folderFile.mkdirs();
		}
		
		final File xlsfile=new File(folder,"STT_Daily_DashBoard_Report"+".xlsx");
		
		prepareDetailedReportDocument(xlsfile,sDate);
		mailSender.send(new MimeMessagePreparator(){

			@Override
			public void prepare(MimeMessage mimeMessage) throws Exception {
				MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage,true);
				messageHelper.setTo(emailTomsttdailydashboardreport.split(";"));
				messageHelper.setFrom(emailFrom,emailFromName);
				messageHelper.setBcc(emailBcc.split(";"));
				
				Calendar cal = Calendar.getInstance();
				cal.add(Calendar.DATE, -1);
				
				messageHelper.setSubject(dateTimeFormat4.format(cal.getTime())+"-STT Daily DashBoard Report");
				
				messageHelper.setText(getMessage(), true);
				if(xlsfile.exists()){
					messageHelper.addAttachment(dateTimeFormat4.format(cal.getTime())+"-STT_Daily_DashBoard_Report.xlsx", new ByteArrayResource(IOUtils.toByteArray(new FileInputStream(xlsfile))));
				}
				logger.info("ST Tissue STT_Daily_DashBoard_Report mail is sent");
			}

			private String getMessage() {
				StringBuilder builder=new StringBuilder();
				builder.append("Hello Sir,<br/><br/>");
				builder.append("Please find the attached <b>\"ST Tissue Daily DashBoard Report\"</b> for your review.<br/>");
				builder.append("<br/>Thank you,<br/>");
				builder.append("Jaipur<br/><p style='font-size: 12px;'>*** This is an automatically system generated email at:"+dateTimeFormat.format(new Date())+" ***</p>");
				builder.append("<br/><p style='color: white;'>Roshan Tailor</p><br/>");
				
				return builder.toString();
			}});
		
		
		
	}

	/**
	 * @param xlsfile
	 * @param sDate
	 * @throws ProductionException 
	 * @throws IOException 
	 */
	private void prepareDetailedReportDocument(File xlsfile, Date sDate) throws ProductionException, IOException {
		// TODO Auto-generated method stub
		

		List<Map<String, String>> datas1=new ArrayList<>();
		datas1=machineProductionPM5Service.formatDataForDailyReport(sDate,sDate);
		
		List<Map<String, String>> datas2=new ArrayList<>();
		datas2=machineProductionService.formatDataForDailyReport(sDate,sDate);
		
		List<FrpProdcutionOperatorDataEntry> details=frpprodcutionoperatordataentryservice.getFrpProducationDataEntryReport(sDate,sDate);
		
		List<ConvertingLineProduction> caseData=null;

		KpiRecordableDate kpiRecordableDate=kpiRecordableDateService.getLastKpiRecordableDate();
		
		int lrdays=0;
		String lrdate="";
		if(kpiRecordableDate!=null){
			int days=CommonUtil.getDaysDiffernce(kpiRecordableDate.getDate(), sDate);
			
			if(days>0){
				lrdate=dateFormat.format(kpiRecordableDate.getDate());
				lrdays=days;
			}

		}
		
		
		FileOutputStream outputStream=new FileOutputStream(xlsfile);
		
		dashBoardReport.createDailyDashBoardReportForAutoMail(datas1,datas2,details,caseData,lrdate,lrdays,sDate,outputStream);
		
		outputStream.close();
	}

}

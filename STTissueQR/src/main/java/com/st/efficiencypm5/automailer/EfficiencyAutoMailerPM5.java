/**
 *Sep 9, 2015
 *EfficiencyAutoMailer.java
 * TODO
 *com.st.efficiency.automailer
 *EfficiencyAutoMailer.java
 *Sunil Singh Bora
 */
package com.st.efficiencypm5.automailer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
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
import com.st.efficiency.model.EfficiencyShiftData;
import com.st.efficiency.report.EfficiencyReportHandler;
import com.st.efficiency.service.EfficiencyService;

/**
 * @author sbora
 *
 */
@Component
public class EfficiencyAutoMailerPM5 {
	private static final Logger logger=LoggerFactory.getLogger(EfficiencyAutoMailerPM5.class);
	private SimpleDateFormat dateTimeFormat=new SimpleDateFormat("MM-dd-yyyy h:mm a");
	private SimpleDateFormat dateTimeFormat4=new SimpleDateFormat("yyyy-MM-dd");
	
	@Autowired
	private JavaMailSender mailSender;
	
	@Autowired
	private EfficiencyReportHandler efficiencyReportHandler;

	@Autowired
	private EfficiencyService efficiencyService;
	
	@Value("${mail.to}")
	private String emailTo;
	
	@Value("${mail.to.henry.shumate}")
	private String emailToSSTReportsNHenryShumate;
	
	@Value("${mail.bcc}")
	private String emailBcc;
	
	@Value("${mail.from}")
	private String emailFrom;
	
	@Value("${mail.fromname}")
	private String emailFromName;
	
	@Value("${mail.to.error}")
	private String emailToError;
	
	/**
	 * @throws IOException 
	 * @throws ParseException 
	 * 
	 */
	public void sendEfficiencyByShiftMail() throws IOException, ParseException {
		String folder=System.getProperty("catalina.base")+"/Efficiency By Shift";
		File folderFile=new File(folder);
		if(!folderFile.exists()){
			folderFile.mkdirs();
		}
		
		final File xlsfile=new File(folder,"Efficiency By Shift"+".xlsx");
		
		prepareEfficiencyByShiftDocument(xlsfile);
		mailSender.send(new MimeMessagePreparator(){

			@Override
			public void prepare(MimeMessage mimeMessage) throws Exception {
				MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage,true);
				messageHelper.setTo(emailToSSTReportsNHenryShumate.split(";"));
				messageHelper.setFrom(emailFrom,emailFromName);
				messageHelper.setBcc(emailBcc.split(";"));
				
				System.out.println("Roshan");
				System.out.println("Email:"+emailToSSTReportsNHenryShumate.split(";"));
				Calendar cal = Calendar.getInstance();
				cal.add(Calendar.DATE, -1);
				
				messageHelper.setSubject(dateTimeFormat4.format(new Date())+"-Efficiency By Shift - Report");
				
				messageHelper.setText(getMessage(), true);
				if(xlsfile.exists()){
					messageHelper.addAttachment(dateTimeFormat4.format(cal.getTime())+"-Efficiency By Shift report.xlsx", new ByteArrayResource(IOUtils.toByteArray(new FileInputStream(xlsfile))));
				}
				logger.info("ST Tissue Efficiency By Shift reports mail is sent");
			}

			private String getMessage() {
				StringBuilder builder=new StringBuilder();
				builder.append("Hello Sir,<br/><br/>");
				builder.append("Please find the attached <b>\"ST Tissue Efficiency By Shift reports\"</b> for your review.<br/>");
				builder.append("<br/>Thank you,<br/>");
				builder.append("Jaipur<br/><p style='font-size: 12px;'>*** This is an automatically system generated email at:"+dateTimeFormat.format(new Date())+" ***</p>");
				
				return builder.toString();
			}});
		
		
		
	}

	/**
	 * @param xlsfile
	 * @throws IOException 
	 * @throws ParseException 
	 */
	private void prepareEfficiencyByShiftDocument(File xlsfile) throws IOException, ParseException {
		Calendar calendar=Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.add(Calendar.DATE, -1);
		
		//List<EfficiencyShiftData> datas=efficiencyService.getEfficiencyShiftData(CommonUtil.getFirstDate(calendar.getTime()),calendar.getTime(), "ALL");
		FileOutputStream outputStream=new FileOutputStream(xlsfile);
		
		SimpleDateFormat dateFormat=new SimpleDateFormat("MM-dd-yyyy");
		
		List<EfficiencyShiftData> datas1=null;
		List<EfficiencyShiftData> datas=null;
		datas1=efficiencyService.getEfficiencyShiftData(CommonUtil.getFirstDate(calendar.getTime()),calendar.getTime(), "ALL");
		
		

		final List<String> list1 = new ArrayList<String>();
		for (EfficiencyShiftData data : datas1) {
			list1.add(dateFormat.format(data.getDate()));
		}

		//Set<String> uniqueSet = new HashSet<String>(list1);
		for (String temp : list1) {
			//System.out.println(temp + ": " + Collections.frequency(list1, temp));
			
			Date currentDate=new Date();
			//System.out.println("currentDate::"+currentDate);
			if(temp.equals(dateFormat.format(currentDate))){
				
			}else{
				if(Collections.frequency(list1, temp)==1){
					
					datas = new ArrayList<EfficiencyShiftData>();
					EfficiencyShiftData cash = new EfficiencyShiftData();
					
					Date date = dateFormat.parse(temp);
					
					cash.setDate(date);
					//cash.setCrew("A");
					cash.setCrew("C");
					cash.setShift("");
					cash.setActualWt(0.0);
					cash.setSlabOff(0);
					cash.setWrapWhite(10.80);
					cash.setWrapRed(0);
					cash.setWrapRej(0);
					cash.setWrapTotal(10.80);
					cash.setVariance(0);
					cash.setVariancePer(0);
					//cash.setDowntime(0);//Here This Is Important Term
					//cash.setUptime(0.0);
					cash.setQuality(0);
					cash.setYield(0);
					cash.setEffTotal(100);
					datas.add(cash);
					
				}else{
					
				}
			}
			
		}
		
		List<EfficiencyShiftData> newList = new ArrayList<EfficiencyShiftData>();
		if(datas==null){
			
		}else{
			newList.addAll(datas);
		}
		newList.addAll(datas1);
		
		Collections.sort(newList, new Comparator<EfficiencyShiftData>() {
			  public int compare(EfficiencyShiftData o1, EfficiencyShiftData o2) {
			      return o1.getDate().compareTo(o2.getDate());
			  }
			});
		
		
		
		efficiencyReportHandler.createEfficiencyShiftReport(newList, outputStream);
		outputStream.close();
		
	}

}
